package otherTest;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;
/**
 * <p>Title: xCRMS </p>
 * Description: <br>
 * Copyright: CorpRights xQuant.com<br>
 * Company: xQuant.com<br>
 *
 * @author wenchao.chai
 * @version 1.1.1.RELEASE
 * @date 2020/7/31 17:29
 */
public class Rsa2Net {
    public static void main(String[] args)
    {
        String tes="MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBAL8z2QlXCL6w7rvY0Gbl8ARtQSXY+pEW5hlUHlmspqHt4k8/SkoF796gDqk4yyOcoWhkZWLPPugK35Mn7V+m5Jyfu8C0gVKOfWOA8A0T4hxV2ThAoMUq7QtB2K6s9AoumrxDfAkMBbsXEHYwfD/hxr/3DQ3lUvSFB6BnhiHEOyzpAgMBAAECgYEAol/9qRjorEjF9XEjSr9rHddKxEGIST8RGeF+BNnCiTHkRziQdlykYIO876jzmsKhsG3STB+EZLsXM3ls9RZefcsPF5mLOCSOCow3DikfCtAy4hntsU9JwpuYE0V4A+Sgfd24fatqbu+JxE2nvpSbAPczDOgBFPNfYBkhMiuZ/iECQQDzUeq7lFcIE4uWhRGveVFjNAGuSsW+q9GOwO7tS5YwuAIQ2M+XgYGRFo8xMC6V/9SfqJtmSU1zk72pMlYufIqHAkEAySqkcKbWuobq5I9KSQISq2qCuGKtj/iUFho4PCD1YxhnQ7gcHA4OpS1dRFjtXJYQPTX9be+mmypsCFIyofE5DwJBAPGZ20wahTh9v9Lbmq3z9n5ce3bGxAcJsHDg3d09eooxi8uSnL5BV5frII+k2f0TI9rMnlE4Y/FpN5+zXaOXAi0CQQCs3Aqfjo23jJWtPv/LSo+2YnjfblPMAgNmFrO532xc8axSgZMN/HpTL28UewHD7GMZ5hnWbPcSIFrir5c4luq7AkEAi90WdnZVPxtSTqkkLYbnh4Ro2WhdwRjkfyBxBZZx8hfaM6MfLPi3A0rw9DPOSB4M/BMchtEh3bXuI7bue2tG+A==";
        byte[] temp=b64decode(tes);
        String ver=getRSAPrivateKeyAsNetFormat(temp);//转换私钥

        String tes1="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0kH9Vk6RoktBW9UkwZPLstqqUaNvQzHqUNwFjvT2i3MzUoJFQfN7EaXVEaoNgK/v0j4loRbzYgLsABUj+rKv2LMmZsW8pYjqMK4Dw5vVXKfP/5JDG2lQz+S/Ibi9kygk80uCcb6Xrhg9lqXMKVNqpp2V/B/PqBYppZ4FnGqdAHoIbvq51Y/+4MAhRa1bpiFkHb3GLg6iS7CtNsuD08BLMdteurwSonlWFO8grec5Fy3K7jgbNTelJWHZKL+U4zZn56wk871XsBajl3GKrPGelgbk35Am6DkLNcUF4eKD24zFZO7nTWVnQnF4pha2cMAj+ptxso9ii86bj+M9mtitzQIDAQAB";
        byte[] temp1=b64decode(tes1);
        String ver1=getRSAPublicKeyAsNetFormat(temp1);//转换公钥

        System.out.println(ver1);
    //String temp2= encodePublicKeyToXml(temp1);

    }

    private static String getRSAPrivateKeyAsNetFormat(byte[] encodedPrivkey) {
        try {
            StringBuffer buff = new StringBuffer(1024);

            PKCS8EncodedKeySpec pvkKeySpec = new PKCS8EncodedKeySpec(
                    encodedPrivkey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPrivateCrtKey pvkKey = (RSAPrivateCrtKey) keyFactory
                    .generatePrivate(pvkKeySpec);

            buff.append("<RSAKeyValue>");
            buff.append("<Modulus>"
                    + b64encode(removeMSZero(pvkKey.getModulus().toByteArray()))
                    + "</Modulus>");

            buff.append("<Exponent>"
                    + b64encode(removeMSZero(pvkKey.getPublicExponent()
                    .toByteArray())) + "</Exponent>");

            buff.append("<P>"
                    + b64encode(removeMSZero(pvkKey.getPrimeP().toByteArray()))
                    + "</P>");

            buff.append("<Q>"
                    + b64encode(removeMSZero(pvkKey.getPrimeQ().toByteArray()))
                    + "</Q>");

            buff.append("<DP>"
                    + b64encode(removeMSZero(pvkKey.getPrimeExponentP()
                    .toByteArray())) + "</DP>");

            buff.append("<DQ>"
                    + b64encode(removeMSZero(pvkKey.getPrimeExponentQ()
                    .toByteArray())) + "</DQ>");

            buff.append("<InverseQ>"
                    + b64encode(removeMSZero(pvkKey.getCrtCoefficient()
                    .toByteArray())) + "</InverseQ>");

            buff.append("<D>"
                    + b64encode(removeMSZero(pvkKey.getPrivateExponent()
                    .toByteArray())) + "</D>");
            buff.append("</RSAKeyValue>");

            return buff.toString().replaceAll("[ \t\n\r]", "");
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    private static String getRSAPublicKeyAsNetFormat(byte[] encodedPrivkey) {
        try {
            StringBuffer buff = new StringBuffer(1024);

            PKCS8EncodedKeySpec pvkKeySpec = new PKCS8EncodedKeySpec(encodedPrivkey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            RSAPublicKey pukKey=(RSAPublicKey) keyFactory.generatePublic(new X509EncodedKeySpec(encodedPrivkey));
// RSAPrivateCrtKey pvkKey = (RSAPrivateCrtKey) keyFactory.generatePrivate(pvkKeySpec);

//PublicKey publicKey =KeyFactory.getInstance("RSA").generatePublic(pvkKeySpec);

            buff.append("<RSAKeyValue>");
            buff.append("<Modulus>"
                    + b64encode(removeMSZero(pukKey.getModulus().toByteArray()))
                    + "</Modulus>");
            buff.append("<Exponent>"
                    + b64encode(removeMSZero(pukKey.getPublicExponent()
                    .toByteArray())) + "</Exponent>");
            buff.append("</RSAKeyValue>");
            return buff.toString().replaceAll("[ \t\n\r]", "");
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    public static String encodePublicKeyToXml(PublicKey key) {
        if (!RSAPublicKey.class.isInstance(key)) {
            return null;
        }
        RSAPublicKey pubKey = (RSAPublicKey) key;
        StringBuilder sb = new StringBuilder();

        sb.append("<RSAKeyValue>");
        sb.append("<Modulus>")
                .append(Base64.getEncoder().encode(pubKey.getModulus().toByteArray()))
                .append("</Modulus>");
        sb.append("<Exponent>")
                .append(Base64.getEncoder().encode(pubKey.getPublicExponent()
                        .toByteArray())).append("</Exponent>");
        sb.append("</RSAKeyValue>");
        return sb.toString();
    }

    private static byte[] removeMSZero(byte[] data) {
        byte[] data1;
        int len = data.length;
        if (data[0] == 0) {
            data1 = new byte[data.length - 1];
            System.arraycopy(data, 1, data1, 0, len - 1);
        } else
            data1 = data;

        return data1;
    }

    private static String b64encode(byte[] data) {

        String b64str = new String(Base64.getEncoder().encode(data));
        return b64str;
    }

    private static byte[] b64decode(String data) {
        byte[] decodeData = Base64.getDecoder().decode(data);
        return decodeData;
    }
}
