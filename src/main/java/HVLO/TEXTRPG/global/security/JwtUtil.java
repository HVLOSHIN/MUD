package HVLO.TEXTRPG.global.security;

import HVLO.TEXTRPG.global.constants.ErrorCode;
import HVLO.TEXTRPG.global.exception.GlobalException;
import HVLO.TEXTRPG.user.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "your_super_secret_key_which_is_at_least_256_bits_long"; // 비밀 키 (256비트 이상)
    private final long EXPIRATION_TIME = 1000 * 60 * 60; // 1시간 (밀리초 단위)
    private final long REFRESH_EXPIRATION_TIME = 1000 * 60 * 60 * 24; // 하루?

    // 비밀 키를 생성합니다.
    private SecretKey getSignInKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes()); // 비밀 키를 Byte 배열로 변환하여 생성
    }

    // JWT 생성 메서드
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getId().toString()) // 사용자 ID
                .claim("loginId", user.getLoginId()) // 사용자 이름 추가
                .claim("role", user.getRole().name()) // 사용자 역할 추가
                .setIssuedAt(new Date()) // 발급 시간
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 만료 시간
                .signWith(getSignInKey()) // 서명
                .compact(); // JWT 생성
    }

    // 리프레시 토큰 생성 메서드
    public String generateRefreshToken(User user) {
        return Jwts.builder()
                .setSubject(user.getId().toString()) // 사용자 ID
                .claim("loginId", user.getLoginId())
                .setIssuedAt(new Date()) // 발급 시간
                .setExpiration(new Date(System.currentTimeMillis() + REFRESH_EXPIRATION_TIME)) // 만료 시간
                .signWith(getSignInKey()) // 서명
                .compact(); // JWT 생성
    }

    // JWT 검증 메서드
    public boolean validateToken(String token, User user) {
        final String loginId = extractLoginId(token);
        return (loginId.equals(user.getLoginId()) && !isTokenExpired(token));
    }

    // JWT에서 사용자 이름 추출
    public String extractLoginId(String token) {
        return extractAllClaims(token).get("loginId", String.class);
    }

    // JWT의 모든 클레임 추출
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey()) // 서명 검증을 위한 비밀 키 설정
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    protected boolean isTokenExpired(String token) {
        try {
            return extractAllClaims(token).getExpiration().before(new Date());
        } catch (ExpiredJwtException | MalformedJwtException e) {
            throw new GlobalException(ErrorCode.NOT_AUTHORIZED);
        }

    }
}
