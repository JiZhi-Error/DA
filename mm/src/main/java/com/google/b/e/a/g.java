package com.google.b.e.a;

import com.google.b.b.c;
import com.google.b.h;
import com.qq.taf.jce.JceStruct;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsMediaPlayer;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

/* access modifiers changed from: package-private */
public final class g {
    private static final byte[] ceT = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, JceStruct.SIMPLE_LIST, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};
    private static final byte[] ceU = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, JceStruct.SIMPLE_LIST, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};
    private static final byte[] ceV = new byte[128];
    private static final byte[] ceW = new byte[128];
    private static final Charset ceX = Charset.forName(KindaConfigCacheStg.SAVE_CHARSET);

    static {
        AppMethodBeat.i(12403);
        Arrays.fill(ceV, (byte) -1);
        for (int i2 = 0; i2 < ceT.length; i2++) {
            byte b2 = ceT[i2];
            if (b2 > 0) {
                ceV[b2] = (byte) i2;
            }
        }
        Arrays.fill(ceW, (byte) -1);
        for (int i3 = 0; i3 < ceU.length; i3++) {
            byte b3 = ceU[i3];
            if (b3 > 0) {
                ceW[b3] = (byte) i3;
            }
        }
        AppMethodBeat.o(12403);
    }

    static String a(String str, c cVar, Charset charset) {
        c cr;
        AppMethodBeat.i(12396);
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = ceX;
        } else if (!ceX.equals(charset) && (cr = c.cr(charset.name())) != null) {
            int i2 = cr.cdd[0];
            if (i2 >= 0 && i2 < 900) {
                sb.append((char) 927);
                sb.append((char) i2);
            } else if (i2 < 810900) {
                sb.append((char) 926);
                sb.append((char) ((i2 / TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR) - 1));
                sb.append((char) (i2 % TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR));
            } else if (i2 < 811800) {
                sb.append((char) 925);
                sb.append((char) (810900 - i2));
            } else {
                h hVar = new h("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i2)));
                AppMethodBeat.o(12396);
                throw hVar;
            }
        }
        int length = str.length();
        if (cVar == c.TEXT) {
            a(str, 0, length, sb, 0);
        } else if (cVar == c.BYTE) {
            byte[] bytes = str.getBytes(charset);
            a(bytes, bytes.length, 1, sb);
        } else if (cVar == c.NUMERIC) {
            sb.append((char) 902);
            a(str, 0, length, sb);
        } else {
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                int f2 = f(str, i4);
                if (f2 >= 13) {
                    sb.append((char) 902);
                    i5 = 2;
                    a(str, i4, f2, sb);
                    i3 = 0;
                    i4 = f2 + i4;
                } else {
                    int g2 = g(str, i4);
                    if (g2 >= 5 || f2 == length) {
                        if (i5 != 0) {
                            sb.append((char) 900);
                            i3 = 0;
                            i5 = 0;
                        }
                        i3 = a(str, i4, g2, sb, i3);
                        i4 += g2;
                    } else {
                        int a2 = a(str, i4, charset);
                        if (a2 == 0) {
                            a2 = 1;
                        }
                        byte[] bytes2 = str.substring(i4, i4 + a2).getBytes(charset);
                        if (bytes2.length == 1 && i5 == 0) {
                            a(bytes2, 1, 0, sb);
                        } else {
                            a(bytes2, bytes2.length, i5, sb);
                            i3 = 0;
                            i5 = 1;
                        }
                        i4 = a2 + i4;
                    }
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(12396);
        return sb2;
    }

    private static int a(CharSequence charSequence, int i2, int i3, StringBuilder sb, int i4) {
        char charAt;
        AppMethodBeat.i(12397);
        StringBuilder sb2 = new StringBuilder(i3);
        int i5 = 0;
        while (true) {
            char charAt2 = charSequence.charAt(i2 + i5);
            switch (i4) {
                case 0:
                    if (!l(charAt2)) {
                        if (!m(charAt2)) {
                            if (!n(charAt2)) {
                                sb2.append((char) 29);
                                sb2.append((char) ceW[charAt2]);
                                break;
                            } else {
                                i4 = 2;
                                sb2.append((char) 28);
                            }
                        } else {
                            sb2.append((char) 27);
                            i4 = 1;
                            continue;
                        }
                    } else if (charAt2 != ' ') {
                        sb2.append((char) (charAt2 - 'A'));
                        break;
                    } else {
                        sb2.append((char) 26);
                        break;
                    }
                case 1:
                    if (!m(charAt2)) {
                        if (!l(charAt2)) {
                            if (!n(charAt2)) {
                                sb2.append((char) 29);
                                sb2.append((char) ceW[charAt2]);
                                break;
                            } else {
                                i4 = 2;
                                sb2.append((char) 28);
                                continue;
                            }
                        } else {
                            sb2.append((char) 27);
                            sb2.append((char) (charAt2 - 'A'));
                            break;
                        }
                    } else if (charAt2 != ' ') {
                        sb2.append((char) (charAt2 - 'a'));
                        break;
                    } else {
                        sb2.append((char) 26);
                        break;
                    }
                case 2:
                    if (n(charAt2)) {
                        sb2.append((char) ceV[charAt2]);
                        break;
                    } else if (l(charAt2)) {
                        sb2.append((char) 28);
                        i4 = 0;
                        continue;
                    } else if (m(charAt2)) {
                        sb2.append((char) 27);
                        i4 = 1;
                    } else if (i2 + i5 + 1 >= i3 || !o(charSequence.charAt(i2 + i5 + 1))) {
                        sb2.append((char) 29);
                        sb2.append((char) ceW[charAt2]);
                        break;
                    } else {
                        i4 = 3;
                        sb2.append((char) 25);
                    }
                    break;
                default:
                    if (o(charAt2)) {
                        sb2.append((char) ceW[charAt2]);
                        break;
                    } else {
                        sb2.append((char) 29);
                        i4 = 0;
                        continue;
                    }
            }
            i5++;
            if (i5 >= i3) {
                int length = sb2.length();
                char c2 = 0;
                int i6 = 0;
                while (i6 < length) {
                    if (i6 % 2 != 0) {
                        charAt = (char) ((c2 * 30) + sb2.charAt(i6));
                        sb.append(charAt);
                    } else {
                        charAt = sb2.charAt(i6);
                    }
                    i6++;
                    c2 = charAt;
                }
                if (length % 2 != 0) {
                    sb.append((char) ((c2 * 30) + 29));
                }
                AppMethodBeat.o(12397);
                return i4;
            }
        }
    }

    private static void a(byte[] bArr, int i2, int i3, StringBuilder sb) {
        AppMethodBeat.i(12398);
        if (i2 == 1 && i3 == 0) {
            sb.append((char) 913);
        } else if (i2 % 6 == 0) {
            sb.append((char) 924);
        } else {
            sb.append((char) 901);
        }
        int i4 = 0;
        if (i2 >= 6) {
            char[] cArr = new char[5];
            while ((i2 + 0) - i4 >= 6) {
                long j2 = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    j2 = (j2 << 8) + ((long) (bArr[i4 + i5] & 255));
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) ((int) (j2 % 900));
                    j2 /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
        }
        while (i4 < i2 + 0) {
            sb.append((char) (bArr[i4] & 255));
            i4++;
        }
        AppMethodBeat.o(12398);
    }

    private static void a(String str, int i2, int i3, StringBuilder sb) {
        AppMethodBeat.i(12399);
        StringBuilder sb2 = new StringBuilder((i3 / 3) + 1);
        BigInteger valueOf = BigInteger.valueOf(900);
        BigInteger valueOf2 = BigInteger.valueOf(0);
        int i4 = 0;
        while (i4 < i3) {
            sb2.setLength(0);
            int min = Math.min(44, i3 - i4);
            BigInteger bigInteger = new BigInteger("1" + str.substring(i2 + i4, i2 + i4 + min));
            do {
                sb2.append((char) bigInteger.mod(valueOf).intValue());
                bigInteger = bigInteger.divide(valueOf);
            } while (!bigInteger.equals(valueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i4 += min;
        }
        AppMethodBeat.o(12399);
    }

    private static boolean isDigit(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    private static boolean l(char c2) {
        return c2 == ' ' || (c2 >= 'A' && c2 <= 'Z');
    }

    private static boolean m(char c2) {
        return c2 == ' ' || (c2 >= 'a' && c2 <= 'z');
    }

    private static boolean n(char c2) {
        return ceV[c2] != -1;
    }

    private static boolean o(char c2) {
        return ceW[c2] != -1;
    }

    private static int f(CharSequence charSequence, int i2) {
        AppMethodBeat.i(12400);
        int i3 = 0;
        int length = charSequence.length();
        if (i2 < length) {
            char charAt = charSequence.charAt(i2);
            while (isDigit(charAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    charAt = charSequence.charAt(i2);
                }
            }
        }
        AppMethodBeat.o(12400);
        return i3;
    }

    private static int g(CharSequence charSequence, int i2) {
        boolean z;
        AppMethodBeat.i(12401);
        int length = charSequence.length();
        int i3 = i2;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            int i4 = 0;
            while (i4 < 13 && isDigit(charAt) && i3 < length) {
                i4++;
                i3++;
                if (i3 < length) {
                    charAt = charSequence.charAt(i3);
                }
            }
            if (i4 < 13) {
                if (i4 <= 0) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 == '\t' || charAt2 == '\n' || charAt2 == '\r' || (charAt2 >= ' ' && charAt2 <= '~')) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        break;
                    }
                    i3++;
                }
            } else {
                int i5 = (i3 - i2) - i4;
                AppMethodBeat.o(12401);
                return i5;
            }
        }
        int i6 = i3 - i2;
        AppMethodBeat.o(12401);
        return i6;
    }

    private static int a(String str, int i2, Charset charset) {
        AppMethodBeat.i(12402);
        CharsetEncoder newEncoder = charset.newEncoder();
        int length = str.length();
        int i3 = i2;
        while (i3 < length) {
            char charAt = str.charAt(i3);
            int i4 = 0;
            while (i4 < 13 && isDigit(charAt)) {
                i4++;
                int i5 = i3 + i4;
                if (i5 >= length) {
                    break;
                }
                charAt = str.charAt(i5);
            }
            if (i4 >= 13) {
                int i6 = i3 - i2;
                AppMethodBeat.o(12402);
                return i6;
            }
            char charAt2 = str.charAt(i3);
            if (!newEncoder.canEncode(charAt2)) {
                h hVar = new h("Non-encodable character detected: " + charAt2 + " (Unicode: " + ((int) charAt2) + ')');
                AppMethodBeat.o(12402);
                throw hVar;
            }
            i3++;
        }
        int i7 = i3 - i2;
        AppMethodBeat.o(12402);
        return i7;
    }
}
