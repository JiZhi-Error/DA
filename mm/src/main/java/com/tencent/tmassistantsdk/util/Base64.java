package com.tencent.tmassistantsdk.util;

import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;

public class Base64 {
    static final /* synthetic */ boolean $assertionsDisabled = (!Base64.class.desiredAssertionStatus());
    public static final int CRLF = 4;
    public static final int DEFAULT = 0;
    public static final int NO_CLOSE = 16;
    public static final int NO_PADDING = 1;
    public static final int NO_WRAP = 2;
    public static final int URL_SAFE = 8;

    static {
        AppMethodBeat.i(102469);
        AppMethodBeat.o(102469);
    }

    static abstract class Coder {
        public int op;
        public byte[] output;

        public abstract int maxOutputSize(int i2);

        public abstract boolean process(byte[] bArr, int i2, int i3, boolean z);

        Coder() {
        }
    }

    public static byte[] decode(String str, int i2) {
        AppMethodBeat.i(102463);
        byte[] decode = decode(str.getBytes(), i2);
        AppMethodBeat.o(102463);
        return decode;
    }

    public static byte[] decode(byte[] bArr, int i2) {
        AppMethodBeat.i(102464);
        byte[] decode = decode(bArr, 0, bArr.length, i2);
        AppMethodBeat.o(102464);
        return decode;
    }

    public static byte[] decode(byte[] bArr, int i2, int i3, int i4) {
        AppMethodBeat.i(102465);
        Decoder decoder = new Decoder(i4, new byte[((i3 * 3) / 4)]);
        if (!decoder.process(bArr, i2, i3, true)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("bad base-64");
            AppMethodBeat.o(102465);
            throw illegalArgumentException;
        } else if (decoder.op == decoder.output.length) {
            byte[] bArr2 = decoder.output;
            AppMethodBeat.o(102465);
            return bArr2;
        } else {
            byte[] bArr3 = new byte[decoder.op];
            System.arraycopy(decoder.output, 0, bArr3, 0, decoder.op);
            AppMethodBeat.o(102465);
            return bArr3;
        }
    }

    /* access modifiers changed from: package-private */
    public static class Decoder extends Coder {
        private static final int[] DECODE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int[] DECODE_WEBSAFE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        private static final int EQUALS = -2;
        private static final int SKIP = -1;
        private final int[] alphabet;
        private int state;
        private int value;

        public Decoder(int i2, byte[] bArr) {
            AppMethodBeat.i(102459);
            this.output = bArr;
            this.alphabet = (i2 & 8) == 0 ? DECODE : DECODE_WEBSAFE;
            this.state = 0;
            this.value = 0;
            AppMethodBeat.o(102459);
        }

        @Override // com.tencent.tmassistantsdk.util.Base64.Coder
        public int maxOutputSize(int i2) {
            return ((i2 * 3) / 4) + 10;
        }

        /* JADX WARNING: Removed duplicated region for block: B:52:0x0109  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x0112  */
        @Override // com.tencent.tmassistantsdk.util.Base64.Coder
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean process(byte[] r10, int r11, int r12, boolean r13) {
            /*
            // Method dump skipped, instructions count: 350
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.util.Base64.Decoder.process(byte[], int, int, boolean):boolean");
        }
    }

    public static String encodeToString(byte[] bArr, int i2) {
        AppMethodBeat.i(102466);
        try {
            String str = new String(encode(bArr, i2), "US-ASCII");
            AppMethodBeat.o(102466);
            return str;
        } catch (UnsupportedEncodingException e2) {
            AssertionError assertionError = new AssertionError(e2);
            AppMethodBeat.o(102466);
            throw assertionError;
        }
    }

    public static byte[] encode(byte[] bArr, int i2) {
        AppMethodBeat.i(102467);
        byte[] encode = encode(bArr, 0, bArr.length, i2);
        AppMethodBeat.o(102467);
        return encode;
    }

    public static byte[] encode(byte[] bArr, int i2, int i3, int i4) {
        int i5;
        AppMethodBeat.i(102468);
        Encoder encoder = new Encoder(i4, null);
        int i6 = (i3 / 3) * 4;
        if (!encoder.do_padding) {
            switch (i3 % 3) {
                case 1:
                    i6 += 2;
                    break;
                case 2:
                    i6 += 3;
                    break;
            }
        } else if (i3 % 3 > 0) {
            i6 += 4;
        }
        if (encoder.do_newline && i3 > 0) {
            int i7 = ((i3 - 1) / 57) + 1;
            if (encoder.do_cr) {
                i5 = 2;
            } else {
                i5 = 1;
            }
            i6 += i5 * i7;
        }
        encoder.output = new byte[i6];
        encoder.process(bArr, i2, i3, true);
        if ($assertionsDisabled || encoder.op == i6) {
            byte[] bArr2 = encoder.output;
            AppMethodBeat.o(102468);
            return bArr2;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(102468);
        throw assertionError;
    }

    /* access modifiers changed from: package-private */
    public static class Encoder extends Coder {
        static final /* synthetic */ boolean $assertionsDisabled;
        private static final byte[] ENCODE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        private static final byte[] ENCODE_WEBSAFE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};
        public static final int LINE_GROUPS = 19;
        private final byte[] alphabet;
        private int count;
        public final boolean do_cr;
        public final boolean do_newline;
        public final boolean do_padding;
        private final byte[] tail;
        int tailLen;

        static {
            boolean z;
            AppMethodBeat.i(102462);
            if (!Base64.class.desiredAssertionStatus()) {
                z = true;
            } else {
                z = false;
            }
            $assertionsDisabled = z;
            AppMethodBeat.o(102462);
        }

        public Encoder(int i2, byte[] bArr) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(102460);
            this.output = bArr;
            this.do_padding = (i2 & 1) == 0;
            if ((i2 & 2) == 0) {
                z = true;
            } else {
                z = false;
            }
            this.do_newline = z;
            this.do_cr = (i2 & 4) == 0 ? false : z2;
            this.alphabet = (i2 & 8) == 0 ? ENCODE : ENCODE_WEBSAFE;
            this.tail = new byte[2];
            this.tailLen = 0;
            this.count = this.do_newline ? 19 : -1;
            AppMethodBeat.o(102460);
        }

        @Override // com.tencent.tmassistantsdk.util.Base64.Coder
        public int maxOutputSize(int i2) {
            return ((i2 * 8) / 5) + 10;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.tmassistantsdk.util.Base64.Coder
        public boolean process(byte[] bArr, int i2, int i3, boolean z) {
            int i4;
            int i5;
            int i6;
            int i7;
            byte b2;
            byte b3;
            int i8;
            int i9;
            byte b4;
            int i10;
            AppMethodBeat.i(102461);
            byte[] bArr2 = this.alphabet;
            byte[] bArr3 = this.output;
            int i11 = 0;
            int i12 = this.count;
            int i13 = i3 + i2;
            switch (this.tailLen) {
                case 0:
                    i5 = -1;
                    i4 = i2;
                    break;
                case 1:
                    if (i2 + 2 <= i13) {
                        int i14 = i2 + 1;
                        this.tailLen = 0;
                        i5 = ((this.tail[0] & 255) << 16) | ((bArr[i2] & 255) << 8) | (bArr[i14] & 255);
                        i4 = i14 + 1;
                        break;
                    }
                    i5 = -1;
                    i4 = i2;
                    break;
                case 2:
                    if (i2 + 1 <= i13) {
                        int i15 = ((this.tail[0] & 255) << 16) | ((this.tail[1] & 255) << 8);
                        i4 = i2 + 1;
                        this.tailLen = 0;
                        i5 = i15 | (bArr[i2] & 255);
                        break;
                    }
                    i5 = -1;
                    i4 = i2;
                    break;
                default:
                    i5 = -1;
                    i4 = i2;
                    break;
            }
            if (i5 != -1) {
                bArr3[0] = bArr2[(i5 >> 18) & 63];
                bArr3[1] = bArr2[(i5 >> 12) & 63];
                bArr3[2] = bArr2[(i5 >> 6) & 63];
                int i16 = 4;
                bArr3[3] = bArr2[i5 & 63];
                int i17 = i12 - 1;
                if (i17 == 0) {
                    if (this.do_cr) {
                        i16 = 5;
                        bArr3[4] = JceStruct.SIMPLE_LIST;
                    }
                    i11 = i16 + 1;
                    bArr3[i16] = 10;
                    i6 = 19;
                } else {
                    i6 = i17;
                    i11 = 4;
                }
            } else {
                i6 = i12;
            }
            while (i4 + 3 <= i13) {
                int i18 = ((bArr[i4] & 255) << 16) | ((bArr[i4 + 1] & 255) << 8) | (bArr[i4 + 2] & 255);
                bArr3[i11] = bArr2[(i18 >> 18) & 63];
                bArr3[i11 + 1] = bArr2[(i18 >> 12) & 63];
                bArr3[i11 + 2] = bArr2[(i18 >> 6) & 63];
                bArr3[i11 + 3] = bArr2[i18 & 63];
                i4 += 3;
                int i19 = i11 + 4;
                int i20 = i6 - 1;
                if (i20 == 0) {
                    if (this.do_cr) {
                        i10 = i19 + 1;
                        bArr3[i19] = JceStruct.SIMPLE_LIST;
                    } else {
                        i10 = i19;
                    }
                    i11 = i10 + 1;
                    bArr3[i10] = 10;
                    i6 = 19;
                } else {
                    i6 = i20;
                    i11 = i19;
                }
            }
            if (z) {
                if (i4 - this.tailLen == i13 - 1) {
                    int i21 = 0;
                    if (this.tailLen > 0) {
                        i21 = 1;
                        b4 = this.tail[0];
                        i9 = i4;
                    } else {
                        i9 = i4 + 1;
                        b4 = bArr[i4];
                    }
                    int i22 = (b4 & 255) << 4;
                    this.tailLen -= i21;
                    int i23 = i11 + 1;
                    bArr3[i11] = bArr2[(i22 >> 6) & 63];
                    int i24 = i23 + 1;
                    bArr3[i23] = bArr2[i22 & 63];
                    if (this.do_padding) {
                        int i25 = i24 + 1;
                        bArr3[i24] = 61;
                        i24 = i25 + 1;
                        bArr3[i25] = 61;
                    }
                    if (this.do_newline) {
                        if (this.do_cr) {
                            bArr3[i24] = JceStruct.SIMPLE_LIST;
                            i24++;
                        }
                        bArr3[i24] = 10;
                        i24++;
                    }
                    i4 = i9;
                    i11 = i24;
                } else if (i4 - this.tailLen == i13 - 2) {
                    int i26 = 0;
                    if (this.tailLen > 1) {
                        b2 = this.tail[0];
                        i26 = 1;
                    } else {
                        b2 = bArr[i4];
                        i4++;
                    }
                    int i27 = (b2 & 255) << 10;
                    if (this.tailLen > 0) {
                        b3 = this.tail[i26];
                        i26++;
                    } else {
                        b3 = bArr[i4];
                        i4++;
                    }
                    int i28 = ((b3 & 255) << 2) | i27;
                    this.tailLen -= i26;
                    int i29 = i11 + 1;
                    bArr3[i11] = bArr2[(i28 >> 12) & 63];
                    int i30 = i29 + 1;
                    bArr3[i29] = bArr2[(i28 >> 6) & 63];
                    int i31 = i30 + 1;
                    bArr3[i30] = bArr2[i28 & 63];
                    if (this.do_padding) {
                        i8 = i31 + 1;
                        bArr3[i31] = 61;
                    } else {
                        i8 = i31;
                    }
                    if (this.do_newline) {
                        if (this.do_cr) {
                            bArr3[i8] = JceStruct.SIMPLE_LIST;
                            i8++;
                        }
                        bArr3[i8] = 10;
                        i8++;
                    }
                    i11 = i8;
                } else if (this.do_newline && i11 > 0 && i6 != 19) {
                    if (this.do_cr) {
                        i7 = i11 + 1;
                        bArr3[i11] = JceStruct.SIMPLE_LIST;
                    } else {
                        i7 = i11;
                    }
                    i11 = i7 + 1;
                    bArr3[i7] = 10;
                }
                if (!$assertionsDisabled && this.tailLen != 0) {
                    AssertionError assertionError = new AssertionError();
                    AppMethodBeat.o(102461);
                    throw assertionError;
                } else if (!$assertionsDisabled && i4 != i13) {
                    AssertionError assertionError2 = new AssertionError();
                    AppMethodBeat.o(102461);
                    throw assertionError2;
                }
            } else if (i4 == i13 - 1) {
                byte[] bArr4 = this.tail;
                int i32 = this.tailLen;
                this.tailLen = i32 + 1;
                bArr4[i32] = bArr[i4];
            } else if (i4 == i13 - 2) {
                byte[] bArr5 = this.tail;
                int i33 = this.tailLen;
                this.tailLen = i33 + 1;
                bArr5[i33] = bArr[i4];
                byte[] bArr6 = this.tail;
                int i34 = this.tailLen;
                this.tailLen = i34 + 1;
                bArr6[i34] = bArr[i4 + 1];
            }
            this.op = i11;
            this.count = i6;
            AppMethodBeat.o(102461);
            return true;
        }
    }

    private Base64() {
    }
}
