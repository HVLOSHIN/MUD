package HVLO.TEXTRPG.global.exception;
import HVLO.TEXTRPG.global.constants.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GlobalException extends RuntimeException {
    ErrorCode errorCode;
}
