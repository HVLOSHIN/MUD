package HVLO.TEXTRPG.global.security;

import HVLO.TEXTRPG.global.constants.ErrorCode;
import HVLO.TEXTRPG.global.exception.GlobalException;
import HVLO.TEXTRPG.user.entity.User;
import HVLO.TEXTRPG.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

@Slf4j
@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    // 화이트리스트 정의
    private static final List<String> WHITELIST = List.of(
            "/api/user/login",     // 로그인 API
            "/api/user/signup"     // 회원가입 API
    );

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        // 화이트리스트에 있는 경우, JWT 검증을 생략
        for (String path : WHITELIST) {
            if (requestURI.matches(path.replace("**", ".*"))) {
                return true; // 화이트리스트에 해당하므로 요청 진행
            }
        }

        // Authorization 헤더에서 JWT 가져오기
        String authHeader = request.getHeader("Authorization");
        if(authHeader == null || !authHeader.startsWith("Bearer ")) {
            log.info(authHeader);
        }
        // Bearer 토큰 검증
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // "Bearer " 뒤의 토큰

            // 사용자 ID 추출
            String loginId = jwtUtil.extractLoginId(token);

            // 사용자 정보 조회
            User user = userRepository.findByLoginId(loginId)
                    .orElseThrow(() -> new GlobalException(ErrorCode.USER_NOT_FOUND));

            if (jwtUtil.validateToken(token, user)) { // 토큰 검증 메서드 호출
                // 토큰이 유효하면 다음으로 진행
                return true;
            }
        }
        // 토큰이 유효하지 않거나 없는 경우 에러 응답
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        return false; // 요청 처리 중단
    }
}
