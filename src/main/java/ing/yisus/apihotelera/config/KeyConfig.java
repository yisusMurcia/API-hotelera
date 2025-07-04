package ing.yisus.apihotelera.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Configuration
public class KeyConfig {
    @Bean
    public KeyPair rsaPair() throws Exception {
        Resource privateResource = new ClassPathResource("/keys/private_key.pem");
        Resource publicResource = new ClassPathResource("/keys/public_key.pem");
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        if(privateResource.exists() && publicResource.exists()) {
            //Cargar clave publica
            String publicKeyString = publicResource.getContentAsString(Charset.defaultCharset()).replace("-----BEGIN PUBLIC KEY-----", "")
                    .replace("-----END PUBLIC KEY-----", "").replaceAll(System.lineSeparator(), "");
            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

            //Cargar clave privada
            String privateKeyString = privateResource.getContentAsString(Charset.defaultCharset()).replace("-----BEGIN PUBLIC KEY-----","")
                    .replace("-----END PUBLIC KEY-----", "").replaceAll(System.lineSeparator(), "")
                    .replace(System.lineSeparator(), "");
            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyString);
            X509EncodedKeySpec privateKeySpec = new X509EncodedKeySpec(privateKeyBytes);
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
            return new KeyPair(publicKey, privateKey);
        }else {
            throw new IOException("No se encontraron las claves RSA en el classpath");
        }
    }
}
