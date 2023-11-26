package org.woofteam.immortalcultivationplan.utils;


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.lang.annotation.Documented;
import java.time.Instant;
import java.util.Date;
@Component
public class JWTUtils {
    /**
     * 过期时间(单位:秒)
     */

    private static long EXPIRE_TIME;
    @Value(value = "${JWT.expire}")
    public void setExpireTime(long expireTime){
        EXPIRE_TIME= expireTime;
    }
    /**
     * 加密算法
     */
    private final static SecureDigestAlgorithm<SecretKey, SecretKey> ALGORITHM =Jwts.SIG.HS256;
    /**
     * 私钥 / 生成签名的时候使用的秘钥secret，一般可以从本地配置文件中读取，切记这个秘钥不能外露，只在服务端使用，在任何场景都不应该流露出去。
     * 一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
     * 应该大于等于 256位(长度32及以上的字符串)，并且是随机的字符串
     */

    private static String SECRET ;
    @Value(value = "${JWT.secret}")
    public void setSecret(String secret){
        SECRET= secret;
    }
    /**
     * 秘钥实例
     */
//    public static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes());
    /**
     * jwt签发者
     */
    private final static String JWT_ISS = "Tiam";
    /**
     * jwt主题
     */
    private final static String SUBJECT = "Peripherals";

    /**
        这些是一组预定义的声明，它们 不是强制性的，而是推荐的 ，以 提供一组有用的、可互操作的声明 。
        iss: jwt签发者
        sub: jwt所面向的用户
        aud: 接收jwt的一方
        exp: jwt的过期时间，这个过期时间必须要大于签发时间
        nbf: 定义在什么时间之前，该jwt都是不可用的.
        iat: jwt的签发时间
        jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击
     */
    public static String generateToken(String id){
        Date now = new Date();
        Date expiration =  Date.from(Instant.now().plusSeconds(EXPIRE_TIME));

        return Jwts.builder()
                .header()
                .add("type", "JWT").and()
                .issuedAt(now)
                .subject(id)
                .expiration(expiration)
                .signWith(Keys.hmacShaKeyFor(SECRET.getBytes()),ALGORITHM)
                .compact();
    }
    /**
     * 解析token 如果过期会抛出ExpiredJwtException
     * @param token token
     * @return Jws<Claims>
     */
    public static  Jws<Claims>  getClaimsByToken(String token){
        return  Jwts.parser().verifyWith(Keys.hmacShaKeyFor(SECRET.getBytes())).build().parseSignedClaims(token);
    }
    public static Boolean isExpire(String token){
        Date now = new Date();
        Date expiration1 = getClaimsByToken(token).getPayload().getExpiration();
        return expiration1.after(now);
    }
}
