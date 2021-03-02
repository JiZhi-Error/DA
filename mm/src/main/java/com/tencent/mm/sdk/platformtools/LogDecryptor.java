package com.tencent.mm.sdk.platformtools;

import android.util.Base64;
import com.tencent.mm.b.l;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogDecryptor {
    private static final Pattern ENCRYPTED_STR_PREFIX_PATTERN = Pattern.compile(newTagPatternDeobfuscate("⍆[0-9]+@"));
    private static final char NEW_OBFUSCATED_MAGIC_CHAR = 9030;
    private static final char OBFUSCATED_MASK = 56506;
    private static final char OLD_OBFUSCATED_MAGIC_CHAR = 56475;
    private static final String TAG = "MicroMsg.LogDecryptor";
    private final LruCache<String, String> decryptedStrLruCache = new LruCache<>(256);
    private byte[] key;
    private final TagDecrypter oldTagDecryptor;

    public LogDecryptor(String str) {
        try {
            this.key = str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e2) {
            this.key = str.getBytes();
        }
        this.oldTagDecryptor = new TagDecrypter(str);
    }

    public String decryptTag(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        switch (str.charAt(0) ^ OBFUSCATED_MASK) {
            case 9030:
                return decryptImpl(str, 0, str.length());
            case 56475:
                return this.oldTagDecryptor.decryptTag(str);
            default:
                return str;
        }
    }

    public String decryptContent(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Matcher matcher = ENCRYPTED_STR_PREFIX_PATTERN.matcher(str);
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        while (true) {
            if (i2 < length) {
                if (!matcher.find(i2)) {
                    sb.append(str.substring(i2));
                    break;
                }
                if (matcher.start() != i2) {
                    sb.append(str.substring(i2, matcher.start()));
                }
                int start = matcher.start();
                int end = matcher.end();
                int parseInt = Integer.parseInt(str.substring(start + 1, end - 1));
                sb.append(decryptImpl(str, start, end + parseInt));
                i2 = end + parseInt;
            } else {
                break;
            }
        }
        return sb.toString();
    }

    private String decryptImpl(String str, int i2, int i3) {
        String substring = str.substring(i2, i3);
        if (this.decryptedStrLruCache.checkAndUpTime(substring)) {
            return this.decryptedStrLruCache.get(substring);
        }
        int i4 = i2 + 1;
        int indexOf = str.indexOf(64, i4);
        int i5 = indexOf + 1;
        try {
            String str2 = new String(l.d(Base64.decode(str.substring(i5, Integer.parseInt(str.substring(i4, indexOf)) + i5), 0), this.key), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
            this.decryptedStrLruCache.put(substring, str2);
            return str2;
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
            return "[TD]".concat(String.valueOf(substring));
        }
    }

    private static String newTagPatternDeobfuscate(String str) {
        return ((char) (str.charAt(0) ^ OBFUSCATED_MASK)) + str.substring(1);
    }
}
