package HVLO.TEXTRPG.global;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.SecureRandom;
import java.util.Base64;

public class EncryptionUtil {
    // salt를 사용하면 같은 비밀번호라도 값이 다르게 되어 유출시에도 더 안전하다.
    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generateSalt() {
        byte[] salt = new byte[16];
        secureRandom.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String hashPassword(String password, String salt) {
        return DigestUtils.sha256Hex(salt + password);
    }
}
