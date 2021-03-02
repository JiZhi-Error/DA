package kotlin.l.b.a.b.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class y {
    public static boolean s(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(59635);
        if (X(bArr, i2, i3) == 0) {
            AppMethodBeat.o(59635);
            return true;
        }
        AppMethodBeat.o(59635);
        return false;
    }

    public static int X(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(59636);
        while (i2 < i3 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i3) {
            AppMethodBeat.o(59636);
            return 0;
        }
        int Y = Y(bArr, i2, i3);
        AppMethodBeat.o(59636);
        return Y;
    }

    private static int Y(byte[] bArr, int i2, int i3) {
        int i4;
        AppMethodBeat.i(59637);
        while (i2 < i3) {
            int i5 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 < 0) {
                if (b2 < -32) {
                    if (i5 >= i3) {
                        AppMethodBeat.o(59637);
                        return b2;
                    }
                    if (b2 >= -62) {
                        i4 = i5 + 1;
                        if (bArr[i5] > -65) {
                        }
                    }
                    AppMethodBeat.o(59637);
                    return -1;
                } else if (b2 < -16) {
                    if (i5 >= i3 - 1) {
                        int Z = Z(bArr, i5, i3);
                        AppMethodBeat.o(59637);
                        return Z;
                    }
                    int i6 = i5 + 1;
                    byte b3 = bArr[i5];
                    if (b3 <= -65 && ((b2 != -32 || b3 >= -96) && (b2 != -19 || b3 < -96))) {
                        i4 = i6 + 1;
                        if (bArr[i6] > -65) {
                        }
                    }
                    AppMethodBeat.o(59637);
                    return -1;
                } else if (i5 >= i3 - 2) {
                    int Z2 = Z(bArr, i5, i3);
                    AppMethodBeat.o(59637);
                    return Z2;
                } else {
                    int i7 = i5 + 1;
                    byte b4 = bArr[i5];
                    if (b4 <= -65 && (((b2 << 28) + (b4 + 112)) >> 30) == 0) {
                        int i8 = i7 + 1;
                        if (bArr[i7] <= -65) {
                            i4 = i8 + 1;
                            if (bArr[i8] > -65) {
                            }
                        }
                    }
                    AppMethodBeat.o(59637);
                    return -1;
                }
                i2 = i4;
            } else {
                i2 = i5;
            }
        }
        AppMethodBeat.o(59637);
        return 0;
    }

    private static int gV(int i2) {
        if (i2 > -12) {
            return -1;
        }
        return i2;
    }

    static int by(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return (i3 << 8) ^ i2;
    }

    static int z(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return ((i3 << 8) ^ i2) ^ (i4 << 16);
    }

    private static int Z(byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(59638);
        byte b2 = bArr[i2 - 1];
        switch (i3 - i2) {
            case 0:
                int gV = gV(b2);
                AppMethodBeat.o(59638);
                return gV;
            case 1:
                int by = by(b2, bArr[i2]);
                AppMethodBeat.o(59638);
                return by;
            case 2:
                int z = z(b2, bArr[i2], bArr[i2 + 1]);
                AppMethodBeat.o(59638);
                return z;
            default:
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(59638);
                throw assertionError;
        }
    }
}
