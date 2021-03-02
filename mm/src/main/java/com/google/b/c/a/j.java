package com.google.b.c.a;

import com.google.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class j {
    public static String a(String str, l lVar, b bVar, b bVar2) {
        int i2 = 0;
        AppMethodBeat.i(12385);
        g[] gVarArr = {new a(), new c(), new m(), new n(), new f(), new b()};
        h hVar = new h(str);
        hVar.cdB = lVar;
        hVar.cdC = bVar;
        hVar.cdD = bVar2;
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.g(236);
            hVar.cdH = 2;
            hVar.pos += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.g(237);
            hVar.cdH = 2;
            hVar.pos += 7;
        }
        while (hVar.In()) {
            gVarArr[i2].a(hVar);
            if (hVar.cdF >= 0) {
                i2 = hVar.cdF;
                hVar.cdF = -1;
            }
        }
        int length = hVar.cdE.length();
        hVar.Iq();
        int i3 = hVar.cdG.cdP;
        if (!(length >= i3 || i2 == 0 || i2 == 5)) {
            hVar.g(254);
        }
        StringBuilder sb = hVar.cdE;
        if (sb.length() < i3) {
            sb.append((char) 129);
        }
        while (sb.length() < i3) {
            int length2 = (((sb.length() + 1) * 149) % 253) + 1 + 129;
            if (length2 > 254) {
                length2 -= 254;
            }
            sb.append((char) length2);
        }
        String sb2 = hVar.cdE.toString();
        AppMethodBeat.o(12385);
        return sb2;
    }

    static int b(CharSequence charSequence, int i2, int i3) {
        float[] fArr;
        boolean z;
        boolean z2;
        boolean z3;
        AppMethodBeat.i(12386);
        if (i2 >= charSequence.length()) {
            AppMethodBeat.o(12386);
            return i3;
        }
        if (i3 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i3] = 0.0f;
        }
        int i4 = 0;
        while (i2 + i4 != charSequence.length()) {
            char charAt = charSequence.charAt(i2 + i4);
            i4++;
            if (isDigit(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (h(charAt)) {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil((double) fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (charAt == ' ' || ((charAt >= '0' && charAt <= '9') || (charAt >= 'A' && charAt <= 'Z'))) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (h(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (charAt == ' ' || ((charAt >= '0' && charAt <= '9') || (charAt >= 'a' && charAt <= 'z'))) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (h(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (i(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (h(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (charAt < ' ' || charAt > '^') {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (h(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            fArr[5] = fArr[5] + 1.0f;
            if (i4 >= 4) {
                int[] iArr = new int[6];
                byte[] bArr = new byte[6];
                a(fArr, iArr, Integer.MAX_VALUE, bArr);
                int K = K(bArr);
                if (iArr[0] < iArr[5] && iArr[0] < iArr[1] && iArr[0] < iArr[2] && iArr[0] < iArr[3] && iArr[0] < iArr[4]) {
                    AppMethodBeat.o(12386);
                    return 0;
                } else if (iArr[5] < iArr[0] || bArr[1] + bArr[2] + bArr[3] + bArr[4] == 0) {
                    AppMethodBeat.o(12386);
                    return 5;
                } else if (K == 1 && bArr[4] > 0) {
                    AppMethodBeat.o(12386);
                    return 4;
                } else if (K == 1 && bArr[2] > 0) {
                    AppMethodBeat.o(12386);
                    return 2;
                } else if (K == 1 && bArr[3] > 0) {
                    AppMethodBeat.o(12386);
                    return 3;
                } else if (iArr[1] + 1 < iArr[0] && iArr[1] + 1 < iArr[5] && iArr[1] + 1 < iArr[4] && iArr[1] + 1 < iArr[2]) {
                    if (iArr[1] < iArr[3]) {
                        AppMethodBeat.o(12386);
                        return 1;
                    } else if (iArr[1] == iArr[3]) {
                        int i5 = i2 + i4;
                        while (true) {
                            i5++;
                            if (i5 >= charSequence.length()) {
                                break;
                            }
                            char charAt2 = charSequence.charAt(i5);
                            if (!j(charAt2)) {
                                if (!i(charAt2)) {
                                    break;
                                }
                            } else {
                                AppMethodBeat.o(12386);
                                return 3;
                            }
                        }
                        AppMethodBeat.o(12386);
                        return 1;
                    }
                }
            }
        }
        byte[] bArr2 = new byte[6];
        int[] iArr2 = new int[6];
        int a2 = a(fArr, iArr2, Integer.MAX_VALUE, bArr2);
        int K2 = K(bArr2);
        if (iArr2[0] == a2) {
            AppMethodBeat.o(12386);
            return 0;
        } else if (K2 == 1 && bArr2[5] > 0) {
            AppMethodBeat.o(12386);
            return 5;
        } else if (K2 == 1 && bArr2[4] > 0) {
            AppMethodBeat.o(12386);
            return 4;
        } else if (K2 == 1 && bArr2[2] > 0) {
            AppMethodBeat.o(12386);
            return 2;
        } else if (K2 != 1 || bArr2[3] <= 0) {
            AppMethodBeat.o(12386);
            return 1;
        } else {
            AppMethodBeat.o(12386);
            return 3;
        }
    }

    private static int a(float[] fArr, int[] iArr, int i2, byte[] bArr) {
        AppMethodBeat.i(12387);
        Arrays.fill(bArr, (byte) 0);
        int i3 = i2;
        for (int i4 = 0; i4 < 6; i4++) {
            iArr[i4] = (int) Math.ceil((double) fArr[i4]);
            int i5 = iArr[i4];
            if (i3 > i5) {
                Arrays.fill(bArr, (byte) 0);
                i3 = i5;
            }
            if (i3 == i5) {
                bArr[i4] = (byte) (bArr[i4] + 1);
            }
        }
        AppMethodBeat.o(12387);
        return i3;
    }

    private static int K(byte[] bArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 = bArr[i3] + i2;
        }
        return i2;
    }

    static boolean isDigit(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    static boolean h(char c2) {
        return c2 >= 128 && c2 <= 255;
    }

    private static boolean i(char c2) {
        AppMethodBeat.i(12388);
        if (j(c2) || c2 == ' ' || ((c2 >= '0' && c2 <= '9') || (c2 >= 'A' && c2 <= 'Z'))) {
            AppMethodBeat.o(12388);
            return true;
        }
        AppMethodBeat.o(12388);
        return false;
    }

    private static boolean j(char c2) {
        return c2 == '\r' || c2 == '*' || c2 == '>';
    }

    static void k(char c2) {
        AppMethodBeat.i(12389);
        String hexString = Integer.toHexString(c2);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal character: " + c2 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
        AppMethodBeat.o(12389);
        throw illegalArgumentException;
    }
}
