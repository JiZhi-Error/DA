package com.tencent.mm.audio.mix.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.i.b;
import java.nio.ByteOrder;
import java.util.Arrays;

public final class c {
    public static boolean duu = false;

    public static void YP() {
        AppMethodBeat.i(136756);
        if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
            duu = true;
            AppMethodBeat.o(136756);
            return;
        }
        duu = false;
        AppMethodBeat.o(136756);
    }

    public static byte[] a(int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(136757);
        if (i2 == i3) {
            AppMethodBeat.o(136757);
            return bArr;
        }
        int length = bArr.length;
        switch (i2) {
            case 1:
            case 3:
                switch (i3) {
                    case 2:
                        byte[] bArr2 = new byte[(length * 2)];
                        for (int i4 = 0; i4 < length; i4++) {
                            byte[] bytes = a.getBytes((short) (bArr[i4] * 256), duu);
                            bArr2[i4 * 2] = bytes[0];
                            bArr2[(i4 * 2) + 1] = bytes[1];
                        }
                        AppMethodBeat.o(136757);
                        return bArr2;
                }
            case 2:
                switch (i3) {
                    case 1:
                    case 3:
                        int i5 = length / 2;
                        byte[] bArr3 = new byte[i5];
                        for (int i6 = 0; i6 < i5; i6++) {
                            bArr3[i6] = (byte) (a.a(bArr[i6 * 2], bArr[(i6 * 2) + 1], duu) / 256);
                        }
                        AppMethodBeat.o(136757);
                        return bArr3;
                }
        }
        AppMethodBeat.o(136757);
        return bArr;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static byte[] b(int i2, int i3, int i4, byte[] bArr) {
        int i5 = 0;
        AppMethodBeat.i(136758);
        if (bArr == null) {
            AppMethodBeat.o(136758);
            return bArr;
        } else if (i2 == i3) {
            AppMethodBeat.o(136758);
            return bArr;
        } else {
            switch (i4) {
                case 1:
                case 2:
                case 3:
                    int length = bArr.length;
                    switch (i2) {
                        case 1:
                            switch (i3) {
                                case 2:
                                    byte[] bArr2 = new byte[(length * 2)];
                                    switch (i4) {
                                        case 1:
                                        case 3:
                                            while (i5 < length) {
                                                byte b2 = bArr[i5];
                                                bArr2[i5 * 2] = b2;
                                                bArr2[(i5 * 2) + 1] = b2;
                                                i5++;
                                            }
                                            break;
                                        case 2:
                                            while (i5 < length) {
                                                byte b3 = bArr[i5];
                                                byte b4 = bArr[i5 + 1];
                                                bArr2[i5 * 2] = b3;
                                                bArr2[(i5 * 2) + 1] = b4;
                                                bArr2[(i5 * 2) + 2] = b3;
                                                bArr2[(i5 * 2) + 3] = b4;
                                                i5 += 2;
                                            }
                                            break;
                                    }
                                    AppMethodBeat.o(136758);
                                    return bArr2;
                            }
                        case 2:
                            switch (i3) {
                                case 1:
                                    int i6 = length / 2;
                                    byte[] bArr3 = new byte[i6];
                                    switch (i4) {
                                        case 1:
                                        case 3:
                                            while (i5 < i6) {
                                                bArr3[i5] = (byte) (((short) (((short) bArr[i5 * 2]) + ((short) bArr[(i5 * 2) + 1]))) >> 1);
                                                i5 += 2;
                                            }
                                            break;
                                        case 2:
                                            for (int i7 = 0; i7 < i6; i7 += 2) {
                                                byte b5 = bArr[i7 * 2];
                                                byte b6 = bArr[(i7 * 2) + 1];
                                                byte b7 = bArr[(i7 * 2) + 2];
                                                byte b8 = bArr[(i7 * 2) + 3];
                                                boolean z = duu;
                                                byte[] bytes = a.getBytes((short) ((a.a(b5, b6, z) / 2) + (a.a(b7, b8, z) / 2)), z);
                                                bArr3[i7] = bytes[0];
                                                bArr3[i7 + 1] = bytes[1];
                                            }
                                            break;
                                    }
                                    AppMethodBeat.o(136758);
                                    return bArr3;
                            }
                    }
                    AppMethodBeat.o(136758);
                    return bArr;
                default:
                    AppMethodBeat.o(136758);
                    return bArr;
            }
        }
    }

    public static void a(int i2, byte[] bArr, byte[][] bArr2) {
        AppMethodBeat.i(136759);
        if (bArr2.length <= 1) {
            AppMethodBeat.o(136759);
            return;
        }
        int length = bArr.length / 2;
        Arrays.fill(bArr2[0], 0, bArr2[0].length, (byte) 0);
        Arrays.fill(bArr2[1], 0, bArr2[1].length, (byte) 0);
        switch (i2) {
            case 1:
            case 3:
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4 += 2) {
                    bArr2[0][i3] = bArr[i4];
                    bArr2[1][i3] = bArr[i4 + 1];
                    i3++;
                }
                AppMethodBeat.o(136759);
                return;
            case 2:
                for (int i5 = 0; i5 < length; i5 += 2) {
                    bArr2[0][i5] = bArr[i5 * 2];
                    bArr2[0][i5 + 1] = bArr[(i5 * 2) + 1];
                    bArr2[1][i5] = bArr[(i5 * 2) + 2];
                    bArr2[1][i5 + 1] = bArr[(i5 * 2) + 3];
                }
                break;
        }
        AppMethodBeat.o(136759);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static byte[] a(int i2, byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        int i3 = 0;
        AppMethodBeat.i(136760);
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            b.e("MicroMsg.Mix.AudioConvertHelper", "sourceFirstByteArray or sourceSecondByteArray is null");
            AppMethodBeat.o(136760);
        } else if (bArr.length != bArr2.length) {
            b.e("MicroMsg.Mix.AudioConvertHelper", "sourceFirstByteArray and sourceSecondByteArray length is not same");
            AppMethodBeat.o(136760);
        } else {
            int length = bArr.length;
            bArr3 = new byte[(length * 2)];
            switch (i2) {
                case 1:
                case 3:
                    while (i3 < length) {
                        bArr3[i3] = bArr[i3];
                        bArr3[i3 + 1] = bArr2[i3];
                        i3 += 2;
                    }
                    break;
                case 2:
                    while (i3 < length) {
                        bArr3[i3 * 2] = bArr[i3];
                        bArr3[(i3 * 2) + 1] = bArr[i3 + 1];
                        bArr3[(i3 * 2) + 2] = bArr2[i3];
                        bArr3[(i3 * 2) + 3] = bArr2[i3 + 1];
                        i3 += 2;
                    }
                    break;
            }
            AppMethodBeat.o(136760);
        }
        return bArr3;
    }
}
