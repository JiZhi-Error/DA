package com.tencent.tmassistantsdk.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class MD5 {
    static final byte[] PADDING = {Byte.MIN_VALUE, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    static final int S11 = 7;
    static final int S12 = 12;
    static final int S13 = 17;
    static final int S14 = 22;
    static final int S21 = 5;
    static final int S22 = 9;
    static final int S23 = 14;
    static final int S24 = 20;
    static final int S31 = 4;
    static final int S32 = 11;
    static final int S33 = 16;
    static final int S34 = 23;
    static final int S41 = 6;
    static final int S42 = 10;
    static final int S43 = 15;
    static final int S44 = 21;
    protected final byte[] buffer = new byte[64];
    protected final long[] count = new long[2];
    protected final byte[] digest = new byte[16];
    protected final long[] state = new long[4];

    public byte[] getMD5(byte[] bArr) {
        AppMethodBeat.i(102500);
        md5Init();
        md5Update(new ByteArrayInputStream(bArr), (long) bArr.length);
        md5Final();
        byte[] bArr2 = this.digest;
        AppMethodBeat.o(102500);
        return bArr2;
    }

    public MD5() {
        AppMethodBeat.i(102501);
        md5Init();
        AppMethodBeat.o(102501);
    }

    private void md5Init() {
        this.count[0] = 0;
        this.count[1] = 0;
        this.state[0] = 1732584193;
        this.state[1] = 4023233417L;
        this.state[2] = 2562383102L;
        this.state[3] = 271733878;
    }

    private long F(long j2, long j3, long j4) {
        return (j2 & j3) | ((-1 ^ j2) & j4);
    }

    private long G(long j2, long j3, long j4) {
        return (j2 & j4) | ((-1 ^ j4) & j3);
    }

    private long H(long j2, long j3, long j4) {
        return (j2 ^ j3) ^ j4;
    }

    private long I(long j2, long j3, long j4) {
        return ((-1 ^ j4) | j2) ^ j3;
    }

    private long FF(long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        AppMethodBeat.i(102502);
        long F = F(j3, j4, j5) + j6 + j8 + j2;
        long j9 = ((long) ((((int) F) >>> ((int) (32 - j7))) | (((int) F) << ((int) j7)))) + j3;
        AppMethodBeat.o(102502);
        return j9;
    }

    private long GG(long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        AppMethodBeat.i(102503);
        long G = G(j3, j4, j5) + j6 + j8 + j2;
        long j9 = ((long) ((((int) G) >>> ((int) (32 - j7))) | (((int) G) << ((int) j7)))) + j3;
        AppMethodBeat.o(102503);
        return j9;
    }

    private long HH(long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        AppMethodBeat.i(102504);
        long H = H(j3, j4, j5) + j6 + j8 + j2;
        long j9 = ((long) ((((int) H) >>> ((int) (32 - j7))) | (((int) H) << ((int) j7)))) + j3;
        AppMethodBeat.o(102504);
        return j9;
    }

    private long II(long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        AppMethodBeat.i(102505);
        long I = I(j3, j4, j5) + j6 + j8 + j2;
        long j9 = ((long) ((((int) I) >>> ((int) (32 - j7))) | (((int) I) << ((int) j7)))) + j3;
        AppMethodBeat.o(102505);
        return j9;
    }

    private boolean md5Update(InputStream inputStream, long j2) {
        int i2;
        AppMethodBeat.i(102506);
        byte[] bArr = new byte[64];
        int i3 = ((int) (this.count[0] >>> 3)) & 63;
        long[] jArr = this.count;
        long j3 = jArr[0] + (j2 << 3);
        jArr[0] = j3;
        if (j3 < (j2 << 3)) {
            long[] jArr2 = this.count;
            jArr2[1] = jArr2[1] + 1;
        }
        long[] jArr3 = this.count;
        jArr3[1] = jArr3[1] + (j2 >>> 29);
        int i4 = 64 - i3;
        if (j2 >= ((long) i4)) {
            byte[] bArr2 = new byte[i4];
            try {
                inputStream.read(bArr2, 0, i4);
                md5Memcpy(this.buffer, bArr2, i3, 0, i4);
                md5Transform(this.buffer);
                i2 = i4;
                while (((long) (i2 + 63)) < j2) {
                    try {
                        inputStream.read(bArr);
                        md5Transform(bArr);
                        i2 += 64;
                    } catch (Exception e2) {
                        AppMethodBeat.o(102506);
                        return false;
                    }
                }
                i3 = 0;
            } catch (Exception e3) {
                AppMethodBeat.o(102506);
                return false;
            }
        } else {
            i2 = 0;
        }
        byte[] bArr3 = new byte[((int) (j2 - ((long) i2)))];
        try {
            inputStream.read(bArr3);
            md5Memcpy(this.buffer, bArr3, i3, 0, bArr3.length);
            AppMethodBeat.o(102506);
            return true;
        } catch (Exception e4) {
            AppMethodBeat.o(102506);
            return false;
        }
    }

    private void md5Update(byte[] bArr, int i2) {
        int i3;
        AppMethodBeat.i(102507);
        byte[] bArr2 = new byte[64];
        int i4 = ((int) (this.count[0] >>> 3)) & 63;
        long[] jArr = this.count;
        long j2 = jArr[0] + ((long) (i2 << 3));
        jArr[0] = j2;
        if (j2 < ((long) (i2 << 3))) {
            long[] jArr2 = this.count;
            jArr2[1] = jArr2[1] + 1;
        }
        long[] jArr3 = this.count;
        jArr3[1] = jArr3[1] + ((long) (i2 >>> 29));
        int i5 = 64 - i4;
        if (i2 >= i5) {
            md5Memcpy(this.buffer, bArr, i4, 0, i5);
            md5Transform(this.buffer);
            while (i5 + 63 < i2) {
                md5Memcpy(bArr2, bArr, 0, i5, 64);
                md5Transform(bArr2);
                i5 += 64;
            }
            i3 = i5;
            i4 = 0;
        } else {
            i3 = 0;
        }
        md5Memcpy(this.buffer, bArr, i4, i3, i2 - i3);
        AppMethodBeat.o(102507);
    }

    private void md5Final() {
        AppMethodBeat.i(102508);
        byte[] bArr = new byte[8];
        Encode(bArr, this.count, 8);
        int i2 = ((int) (this.count[0] >>> 3)) & 63;
        md5Update(PADDING, i2 < 56 ? 56 - i2 : 120 - i2);
        md5Update(bArr, 8);
        Encode(this.digest, this.state, 16);
        AppMethodBeat.o(102508);
    }

    private void md5Memcpy(byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[i2 + i5] = bArr2[i3 + i5];
        }
    }

    private void md5Transform(byte[] bArr) {
        AppMethodBeat.i(102509);
        long j2 = this.state[0];
        long j3 = this.state[1];
        long j4 = this.state[2];
        long j5 = this.state[3];
        long[] jArr = new long[16];
        Decode(jArr, bArr, 64);
        long FF = FF(j2, j3, j4, j5, jArr[0], 7, 3614090360L);
        long FF2 = FF(j5, FF, j3, j4, jArr[1], 12, 3905402710L);
        long FF3 = FF(j4, FF2, FF, j3, jArr[2], 17, 606105819);
        long FF4 = FF(j3, FF3, FF2, FF, jArr[3], 22, 3250441966L);
        long FF5 = FF(FF, FF4, FF3, FF2, jArr[4], 7, 4118548399L);
        long FF6 = FF(FF2, FF5, FF4, FF3, jArr[5], 12, 1200080426);
        long FF7 = FF(FF3, FF6, FF5, FF4, jArr[6], 17, 2821735955L);
        long FF8 = FF(FF4, FF7, FF6, FF5, jArr[7], 22, 4249261313L);
        long FF9 = FF(FF5, FF8, FF7, FF6, jArr[8], 7, 1770035416);
        long FF10 = FF(FF6, FF9, FF8, FF7, jArr[9], 12, 2336552879L);
        long FF11 = FF(FF7, FF10, FF9, FF8, jArr[10], 17, 4294925233L);
        long FF12 = FF(FF8, FF11, FF10, FF9, jArr[11], 22, 2304563134L);
        long FF13 = FF(FF9, FF12, FF11, FF10, jArr[12], 7, 1804603682);
        long FF14 = FF(FF10, FF13, FF12, FF11, jArr[13], 12, 4254626195L);
        long FF15 = FF(FF11, FF14, FF13, FF12, jArr[14], 17, 2792965006L);
        long FF16 = FF(FF12, FF15, FF14, FF13, jArr[15], 22, 1236535329);
        long GG = GG(FF13, FF16, FF15, FF14, jArr[1], 5, 4129170786L);
        long GG2 = GG(FF14, GG, FF16, FF15, jArr[6], 9, 3225465664L);
        long GG3 = GG(FF15, GG2, GG, FF16, jArr[11], 14, 643717713);
        long GG4 = GG(FF16, GG3, GG2, GG, jArr[0], 20, 3921069994L);
        long GG5 = GG(GG, GG4, GG3, GG2, jArr[5], 5, 3593408605L);
        long GG6 = GG(GG2, GG5, GG4, GG3, jArr[10], 9, 38016083);
        long GG7 = GG(GG3, GG6, GG5, GG4, jArr[15], 14, 3634488961L);
        long GG8 = GG(GG4, GG7, GG6, GG5, jArr[4], 20, 3889429448L);
        long GG9 = GG(GG5, GG8, GG7, GG6, jArr[9], 5, 568446438);
        long GG10 = GG(GG6, GG9, GG8, GG7, jArr[14], 9, 3275163606L);
        long GG11 = GG(GG7, GG10, GG9, GG8, jArr[3], 14, 4107603335L);
        long GG12 = GG(GG8, GG11, GG10, GG9, jArr[8], 20, 1163531501);
        long GG13 = GG(GG9, GG12, GG11, GG10, jArr[13], 5, 2850285829L);
        long GG14 = GG(GG10, GG13, GG12, GG11, jArr[2], 9, 4243563512L);
        long GG15 = GG(GG11, GG14, GG13, GG12, jArr[7], 14, 1735328473);
        long GG16 = GG(GG12, GG15, GG14, GG13, jArr[12], 20, 2368359562L);
        long HH = HH(GG13, GG16, GG15, GG14, jArr[5], 4, 4294588738L);
        long HH2 = HH(GG14, HH, GG16, GG15, jArr[8], 11, 2272392833L);
        long HH3 = HH(GG15, HH2, HH, GG16, jArr[11], 16, 1839030562);
        long HH4 = HH(GG16, HH3, HH2, HH, jArr[14], 23, 4259657740L);
        long HH5 = HH(HH, HH4, HH3, HH2, jArr[1], 4, 2763975236L);
        long HH6 = HH(HH2, HH5, HH4, HH3, jArr[4], 11, 1272893353);
        long HH7 = HH(HH3, HH6, HH5, HH4, jArr[7], 16, 4139469664L);
        long HH8 = HH(HH4, HH7, HH6, HH5, jArr[10], 23, 3200236656L);
        long HH9 = HH(HH5, HH8, HH7, HH6, jArr[13], 4, 681279174);
        long HH10 = HH(HH6, HH9, HH8, HH7, jArr[0], 11, 3936430074L);
        long HH11 = HH(HH7, HH10, HH9, HH8, jArr[3], 16, 3572445317L);
        long HH12 = HH(HH8, HH11, HH10, HH9, jArr[6], 23, 76029189);
        long HH13 = HH(HH9, HH12, HH11, HH10, jArr[9], 4, 3654602809L);
        long HH14 = HH(HH10, HH13, HH12, HH11, jArr[12], 11, 3873151461L);
        long HH15 = HH(HH11, HH14, HH13, HH12, jArr[15], 16, 530742520);
        long HH16 = HH(HH12, HH15, HH14, HH13, jArr[2], 23, 3299628645L);
        long II = II(HH13, HH16, HH15, HH14, jArr[0], 6, 4096336452L);
        long II2 = II(HH14, II, HH16, HH15, jArr[7], 10, 1126891415);
        long II3 = II(HH15, II2, II, HH16, jArr[14], 15, 2878612391L);
        long II4 = II(HH16, II3, II2, II, jArr[5], 21, 4237533241L);
        long II5 = II(II, II4, II3, II2, jArr[12], 6, 1700485571);
        long II6 = II(II2, II5, II4, II3, jArr[3], 10, 2399980690L);
        long II7 = II(II3, II6, II5, II4, jArr[10], 15, 4293915773L);
        long II8 = II(II4, II7, II6, II5, jArr[1], 21, 2240044497L);
        long II9 = II(II5, II8, II7, II6, jArr[8], 6, 1873313359);
        long II10 = II(II6, II9, II8, II7, jArr[15], 10, 4264355552L);
        long II11 = II(II7, II10, II9, II8, jArr[6], 15, 2734768916L);
        long II12 = II(II8, II11, II10, II9, jArr[13], 21, 1309151649);
        long II13 = II(II9, II12, II11, II10, jArr[4], 6, 4149444226L);
        long II14 = II(II10, II13, II12, II11, jArr[11], 10, 3174756917L);
        long II15 = II(II11, II14, II13, II12, jArr[2], 15, 718787259);
        long II16 = II(II12, II15, II14, II13, jArr[9], 21, 3951481745L);
        long[] jArr2 = this.state;
        jArr2[0] = jArr2[0] + II13;
        long[] jArr3 = this.state;
        jArr3[1] = II16 + jArr3[1];
        long[] jArr4 = this.state;
        jArr4[2] = jArr4[2] + II15;
        long[] jArr5 = this.state;
        jArr5[3] = jArr5[3] + II14;
        AppMethodBeat.o(102509);
    }

    private void Encode(byte[] bArr, long[] jArr, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            bArr[i3] = (byte) ((int) (jArr[i4] & 255));
            bArr[i3 + 1] = (byte) ((int) ((jArr[i4] >>> 8) & 255));
            bArr[i3 + 2] = (byte) ((int) ((jArr[i4] >>> 16) & 255));
            bArr[i3 + 3] = (byte) ((int) ((jArr[i4] >>> 24) & 255));
            i3 += 4;
            i4++;
        }
    }

    private void Decode(long[] jArr, byte[] bArr, int i2) {
        AppMethodBeat.i(102510);
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            jArr[i4] = b2iu(bArr[i3]) | (b2iu(bArr[i3 + 1]) << 8) | (b2iu(bArr[i3 + 2]) << 16) | (b2iu(bArr[i3 + 3]) << 24);
            i3 += 4;
            i4++;
        }
        AppMethodBeat.o(102510);
    }

    public static long b2iu(byte b2) {
        return b2 < 0 ? (long) (b2 & 255) : (long) b2;
    }

    public static String byteHEX(byte b2) {
        AppMethodBeat.i(102511);
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String str = new String(new char[]{cArr[(b2 >>> 4) & 15], cArr[b2 & 15]});
        AppMethodBeat.o(102511);
        return str;
    }

    public static String toMD5(String str) {
        byte[] bytes;
        AppMethodBeat.i(102512);
        try {
            bytes = str.getBytes("ISO8859_1");
        } catch (UnsupportedEncodingException e2) {
            bytes = str.getBytes();
        }
        byte[] md5 = new MD5().getMD5(bytes);
        String str2 = "";
        for (int i2 = 0; i2 < 16; i2++) {
            str2 = str2 + byteHEX(md5[i2]);
        }
        AppMethodBeat.o(102512);
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028 A[SYNTHETIC, Splitter:B:13:0x0028] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0045 A[SYNTHETIC, Splitter:B:25:0x0045] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String fileToMD5(java.lang.String r7) {
        /*
            r0 = 0
            r2 = 0
            r6 = 102513(0x19071, float:1.43651E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            java.io.InputStream r1 = com.tencent.mm.vfs.s.openRead(r7)     // Catch:{ Exception -> 0x0056, all -> 0x0040 }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x0025, all -> 0x0052 }
            java.lang.String r4 = "MD5"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch:{ Exception -> 0x0025, all -> 0x0052 }
        L_0x0017:
            r5 = -1
            if (r2 == r5) goto L_0x002f
            int r2 = r1.read(r3)     // Catch:{ Exception -> 0x0025, all -> 0x0052 }
            if (r2 <= 0) goto L_0x0017
            r5 = 0
            r4.update(r3, r5, r2)     // Catch:{ Exception -> 0x0025, all -> 0x0052 }
            goto L_0x0017
        L_0x0025:
            r2 = move-exception
        L_0x0026:
            if (r1 == 0) goto L_0x002b
            r1.close()     // Catch:{ Exception -> 0x004e }
        L_0x002b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
        L_0x002e:
            return r0
        L_0x002f:
            byte[] r2 = r4.digest()
            java.lang.String r0 = convertHashToString(r2)
            if (r1 == 0) goto L_0x003c
            r1.close()     // Catch:{ Exception -> 0x004c }
        L_0x003c:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            goto L_0x002e
        L_0x0040:
            r1 = move-exception
            r2 = r1
            r3 = r0
        L_0x0043:
            if (r3 == 0) goto L_0x0048
            r3.close()     // Catch:{ Exception -> 0x0050 }
        L_0x0048:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            throw r2
        L_0x004c:
            r1 = move-exception
            goto L_0x003c
        L_0x004e:
            r1 = move-exception
            goto L_0x002b
        L_0x0050:
            r0 = move-exception
            goto L_0x0048
        L_0x0052:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L_0x0043
        L_0x0056:
            r1 = move-exception
            r1 = r0
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.util.MD5.fileToMD5(java.lang.String):java.lang.String");
    }

    public static String convertHashToString(byte[] bArr) {
        AppMethodBeat.i(102514);
        if (bArr == null) {
            AppMethodBeat.o(102514);
            return "";
        }
        String str = "";
        for (int i2 = 0; i2 < bArr.length; i2++) {
            str = str + Integer.toString((bArr[i2] & 255) + 256, 16).substring(1);
        }
        String upperCase = str.toUpperCase();
        AppMethodBeat.o(102514);
        return upperCase;
    }
}
