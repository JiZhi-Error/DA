package com.tencent.mm.compatible.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.CharArrayWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import java.security.AccessController;
import java.util.BitSet;

public final class q {
    static BitSet gLC = new BitSet(256);
    static String gLD;

    static {
        AppMethodBeat.i(155915);
        gLD = null;
        for (int i2 = 97; i2 <= 122; i2++) {
            gLC.set(i2);
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            gLC.set(i3);
        }
        for (int i4 = 48; i4 <= 57; i4++) {
            gLC.set(i4);
        }
        gLC.set(45);
        gLC.set(95);
        gLC.set(46);
        gLC.set(42);
        gLD = (String) AccessController.doPrivileged(new h("file.encoding"));
        AppMethodBeat.o(155915);
    }

    @Deprecated
    public static String encode(String str) {
        AppMethodBeat.i(155913);
        String str2 = null;
        try {
            str2 = encode(str, gLD);
        } catch (UnsupportedEncodingException e2) {
        }
        AppMethodBeat.o(155913);
        return str2;
    }

    public static String encode(String str, String str2) {
        BitSet bitSet;
        char charAt;
        AppMethodBeat.i(155914);
        StringBuffer stringBuffer = new StringBuffer(str.length());
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        if (str2 == null) {
            NullPointerException nullPointerException = new NullPointerException("charsetName");
            AppMethodBeat.o(155914);
            throw nullPointerException;
        }
        try {
            Charset forName = Charset.forName(str2);
            boolean z = false;
            int i2 = 0;
            while (i2 < str.length()) {
                char charAt2 = str.charAt(i2);
                if (gLC.get(charAt2)) {
                    if (charAt2 == ' ') {
                        z = true;
                    }
                    stringBuffer.append((char) charAt2);
                    i2++;
                } else {
                    char c2 = charAt2;
                    do {
                        charArrayWriter.write(c2);
                        if (c2 >= 55296 && c2 <= 56319 && i2 + 1 < str.length() && (charAt = str.charAt(i2 + 1)) >= 56320 && charAt <= 57343) {
                            charArrayWriter.write(charAt);
                            i2++;
                        }
                        i2++;
                        if (i2 >= str.length()) {
                            break;
                        }
                        bitSet = gLC;
                        c2 = str.charAt(i2);
                    } while (!bitSet.get(c2));
                    charArrayWriter.flush();
                    String str3 = new String(charArrayWriter.toCharArray());
                    new p();
                    byte[] bytes = str3.getBytes(forName);
                    if (bytes == null) {
                        bytes = str3.getBytes();
                    }
                    for (int i3 = 0; i3 < bytes.length; i3++) {
                        stringBuffer.append('%');
                        char forDigit = Character.forDigit((bytes[i3] >> 4) & 15, 16);
                        if (Character.isLetter(forDigit)) {
                            forDigit = (char) (forDigit - ' ');
                        }
                        stringBuffer.append(forDigit);
                        char forDigit2 = Character.forDigit(bytes[i3] & 15, 16);
                        if (Character.isLetter(forDigit2)) {
                            forDigit2 = (char) (forDigit2 - ' ');
                        }
                        stringBuffer.append(forDigit2);
                    }
                    charArrayWriter.reset();
                    z = true;
                }
            }
            if (z) {
                String stringBuffer2 = stringBuffer.toString();
                AppMethodBeat.o(155914);
                return stringBuffer2;
            }
            AppMethodBeat.o(155914);
            return str;
        } catch (IllegalCharsetNameException e2) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(str2);
            AppMethodBeat.o(155914);
            throw unsupportedEncodingException;
        } catch (UnsupportedCharsetException e3) {
            UnsupportedEncodingException unsupportedEncodingException2 = new UnsupportedEncodingException(str2);
            AppMethodBeat.o(155914);
            throw unsupportedEncodingException2;
        }
    }
}
