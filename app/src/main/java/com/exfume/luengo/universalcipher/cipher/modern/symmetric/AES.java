package com.exfume.luengo.universalcipher.cipher.modern.symmetric;

import com.exfume.luengo.universalcipher.interfaces.Cipher;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Hex;

/**
 * Created by Benjamin on 17/06/2016.
 */
public class AES implements Cipher {

    public final int blockSize = 16;

    private String message;
    private byte[] key;

    public AES(String message , byte[] key){
        this.message = message;
        this.key = key;
    }

    @Override
    public String Cipher() {
        byte[] text = this.message.getBytes();
        byte[] key = this.key;
        byte[] res = encrypt(text, Arrays.copyOfRange(Hex.decode(key), 0, 24), Arrays.copyOfRange(Hex.decode(key), 24, 24 + blockSize));
        return new String(Hex.encode(res));
    }

    @Override
    public String Decipher() {
        byte[] text = this.message.getBytes();
        byte[] key = this.key;
        byte[] res = decrypt(Hex.decode(text), Arrays.copyOfRange(Hex.decode(key), 0, 24), Arrays.copyOfRange(Hex.decode(key), 24, blockSize + 24));
        return new String(res);
    }


    private static byte[] encrypt(byte[] plain, byte[] key, byte[] iv) {
        try {
            PaddedBufferedBlockCipher aes = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()));
            CipherParameters ivAndKey = new ParametersWithIV(new KeyParameter(key), iv);
            aes.init(true, ivAndKey);
            return cipherData(aes, plain);
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] decrypt(byte[] ciphered, byte[] key, byte[] iv) {
        try {
            PaddedBufferedBlockCipher aes = new PaddedBufferedBlockCipher(new CBCBlockCipher(new AESEngine()));
            CipherParameters ivAndKey = new ParametersWithIV(new KeyParameter(key), iv);
            aes.init(false, ivAndKey);
            return cipherData(aes, ciphered);
        } catch (Exception e) {
            return null;
        }
    }

    private static byte[] cipherData(PaddedBufferedBlockCipher cipher, byte[] data) throws Exception {

        int minSize = cipher.getOutputSize(data.length);
        byte[] outBuf = new byte[minSize];

        int length1 = cipher.processBytes(data, 0, data.length, outBuf, 0);

        int length2 = cipher.doFinal(outBuf, length1);
        int actualLength = length1 + length2;
        byte[] result = new byte[actualLength];

        System.arraycopy(outBuf, 0, result, 0, result.length);
        return result;
    }

}
