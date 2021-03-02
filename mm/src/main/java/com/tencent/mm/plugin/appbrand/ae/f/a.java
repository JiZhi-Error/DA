package com.tencent.mm.plugin.appbrand.ae.f;

import com.qq.taf.jce.JceStruct;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wxmm.v2encoder;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class a {
    private static final byte[] ojA = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, 14, 15, v2encoder.enumCODEC_vcodec2, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] ojB = {45, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 95, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
    private static final byte[] ojC;
    private static final byte[] ojx = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
    private static final byte[] ojy = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, 14, 15, v2encoder.enumCODEC_vcodec2, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    private static final byte[] ojz = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

    static {
        byte[] bArr = new byte[CdnLogic.kAppTypeFestivalImage];
        // fill-array-data instruction
        bArr[0] = -9;
        bArr[1] = -9;
        bArr[2] = -9;
        bArr[3] = -9;
        bArr[4] = -9;
        bArr[5] = -9;
        bArr[6] = -9;
        bArr[7] = -9;
        bArr[8] = -9;
        bArr[9] = -5;
        bArr[10] = -5;
        bArr[11] = -9;
        bArr[12] = -9;
        bArr[13] = -5;
        bArr[14] = -9;
        bArr[15] = -9;
        bArr[16] = -9;
        bArr[17] = -9;
        bArr[18] = -9;
        bArr[19] = -9;
        bArr[20] = -9;
        bArr[21] = -9;
        bArr[22] = -9;
        bArr[23] = -9;
        bArr[24] = -9;
        bArr[25] = -9;
        bArr[26] = -9;
        bArr[27] = -9;
        bArr[28] = -9;
        bArr[29] = -9;
        bArr[30] = -9;
        bArr[31] = -9;
        bArr[32] = -5;
        bArr[33] = -9;
        bArr[34] = -9;
        bArr[35] = -9;
        bArr[36] = -9;
        bArr[37] = -9;
        bArr[38] = -9;
        bArr[39] = -9;
        bArr[40] = -9;
        bArr[41] = -9;
        bArr[42] = -9;
        bArr[43] = -9;
        bArr[44] = -9;
        bArr[45] = 0;
        bArr[46] = -9;
        bArr[47] = -9;
        bArr[48] = 1;
        bArr[49] = 2;
        bArr[50] = 3;
        bArr[51] = 4;
        bArr[52] = 5;
        bArr[53] = 6;
        bArr[54] = 7;
        bArr[55] = 8;
        bArr[56] = 9;
        bArr[57] = 10;
        bArr[58] = -9;
        bArr[59] = -9;
        bArr[60] = -9;
        bArr[61] = -1;
        bArr[62] = -9;
        bArr[63] = -9;
        bArr[64] = -9;
        bArr[65] = 11;
        bArr[66] = 12;
        bArr[67] = 13;
        bArr[68] = 14;
        bArr[69] = 15;
        bArr[70] = 16;
        bArr[71] = 17;
        bArr[72] = 18;
        bArr[73] = 19;
        bArr[74] = 20;
        bArr[75] = 21;
        bArr[76] = 22;
        bArr[77] = 23;
        bArr[78] = 24;
        bArr[79] = 25;
        bArr[80] = 26;
        bArr[81] = 27;
        bArr[82] = 28;
        bArr[83] = 29;
        bArr[84] = 30;
        bArr[85] = 31;
        bArr[86] = 32;
        bArr[87] = 33;
        bArr[88] = 34;
        bArr[89] = 35;
        bArr[90] = 36;
        bArr[91] = -9;
        bArr[92] = -9;
        bArr[93] = -9;
        bArr[94] = -9;
        bArr[95] = 37;
        bArr[96] = -9;
        bArr[97] = 38;
        bArr[98] = 39;
        bArr[99] = 40;
        bArr[100] = 41;
        bArr[101] = 42;
        bArr[102] = 43;
        bArr[103] = 44;
        bArr[104] = 45;
        bArr[105] = 46;
        bArr[106] = 47;
        bArr[107] = 48;
        bArr[108] = 49;
        bArr[109] = 50;
        bArr[110] = 51;
        bArr[111] = 52;
        bArr[112] = 53;
        bArr[113] = 54;
        bArr[114] = 55;
        bArr[115] = 56;
        bArr[116] = 57;
        bArr[117] = 58;
        bArr[118] = 59;
        bArr[119] = 60;
        bArr[120] = 61;
        bArr[121] = 62;
        bArr[122] = 63;
        bArr[123] = -9;
        bArr[124] = -9;
        bArr[125] = -9;
        bArr[126] = -9;
        bArr[127] = -9;
        bArr[128] = -9;
        bArr[129] = -9;
        bArr[130] = -9;
        bArr[131] = -9;
        bArr[132] = -9;
        bArr[133] = -9;
        bArr[134] = -9;
        bArr[135] = -9;
        bArr[136] = -9;
        bArr[137] = -9;
        bArr[138] = -9;
        bArr[139] = -9;
        bArr[140] = -9;
        bArr[141] = -9;
        bArr[142] = -9;
        bArr[143] = -9;
        bArr[144] = -9;
        bArr[145] = -9;
        bArr[146] = -9;
        bArr[147] = -9;
        bArr[148] = -9;
        bArr[149] = -9;
        bArr[150] = -9;
        bArr[151] = -9;
        bArr[152] = -9;
        bArr[153] = -9;
        bArr[154] = -9;
        bArr[155] = -9;
        bArr[156] = -9;
        bArr[157] = -9;
        bArr[158] = -9;
        bArr[159] = -9;
        bArr[160] = -9;
        bArr[161] = -9;
        bArr[162] = -9;
        bArr[163] = -9;
        bArr[164] = -9;
        bArr[165] = -9;
        bArr[166] = -9;
        bArr[167] = -9;
        bArr[168] = -9;
        bArr[169] = -9;
        bArr[170] = -9;
        bArr[171] = -9;
        bArr[172] = -9;
        bArr[173] = -9;
        bArr[174] = -9;
        bArr[175] = -9;
        bArr[176] = -9;
        bArr[177] = -9;
        bArr[178] = -9;
        bArr[179] = -9;
        bArr[180] = -9;
        bArr[181] = -9;
        bArr[182] = -9;
        bArr[183] = -9;
        bArr[184] = -9;
        bArr[185] = -9;
        bArr[186] = -9;
        bArr[187] = -9;
        bArr[188] = -9;
        bArr[189] = -9;
        bArr[190] = -9;
        bArr[191] = -9;
        bArr[192] = -9;
        bArr[193] = -9;
        bArr[194] = -9;
        bArr[195] = -9;
        bArr[196] = -9;
        bArr[197] = -9;
        bArr[198] = -9;
        bArr[199] = -9;
        bArr[200] = -9;
        bArr[201] = -9;
        bArr[202] = -9;
        bArr[203] = -9;
        bArr[204] = -9;
        bArr[205] = -9;
        bArr[206] = -9;
        bArr[207] = -9;
        bArr[208] = -9;
        bArr[209] = -9;
        bArr[210] = -9;
        bArr[211] = -9;
        bArr[212] = -9;
        bArr[213] = -9;
        bArr[214] = -9;
        bArr[215] = -9;
        bArr[216] = -9;
        bArr[217] = -9;
        bArr[218] = -9;
        bArr[219] = -9;
        bArr[220] = -9;
        bArr[221] = -9;
        bArr[222] = -9;
        bArr[223] = -9;
        bArr[224] = -9;
        bArr[225] = -9;
        bArr[226] = -9;
        bArr[227] = -9;
        bArr[228] = -9;
        bArr[229] = -9;
        bArr[230] = -9;
        bArr[231] = -9;
        bArr[232] = -9;
        bArr[233] = -9;
        bArr[234] = -9;
        bArr[235] = -9;
        bArr[236] = -9;
        bArr[237] = -9;
        bArr[238] = -9;
        bArr[239] = -9;
        bArr[240] = -9;
        bArr[241] = -9;
        bArr[242] = -9;
        bArr[243] = -9;
        bArr[244] = -9;
        bArr[245] = -9;
        bArr[246] = -9;
        bArr[247] = -9;
        bArr[248] = -9;
        bArr[249] = -9;
        bArr[250] = -9;
        bArr[251] = -9;
        bArr[252] = -9;
        bArr[253] = -9;
        bArr[254] = -9;
        bArr[255] = -9;
        bArr[256] = -9;
        ojC = bArr;
    }

    public static String aR(byte[] bArr) {
        AppMethodBeat.i(156670);
        String str = null;
        try {
            str = J(bArr, bArr.length);
        } catch (IOException e2) {
        }
        AppMethodBeat.o(156670);
        return str;
    }

    private static byte[] a(byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5) {
        int i6 = 0;
        byte[] bArr3 = ojx;
        int i7 = (i3 > 1 ? (bArr[i2 + 1] << 24) >>> 16 : 0) | (i3 > 0 ? (bArr[i2] << 24) >>> 8 : 0);
        if (i3 > 2) {
            i6 = (bArr[i2 + 2] << 24) >>> 24;
        }
        int i8 = i6 | i7;
        switch (i3) {
            case 1:
                bArr2[i4] = bArr3[i8 >>> 18];
                bArr2[i4 + 1] = bArr3[(i8 >>> 12) & 63];
                bArr2[i4 + 2] = 61;
                bArr2[i4 + 3] = 61;
                break;
            case 2:
                bArr2[i4] = bArr3[i8 >>> 18];
                bArr2[i4 + 1] = bArr3[(i8 >>> 12) & 63];
                bArr2[i4 + 2] = bArr3[(i8 >>> 6) & 63];
                bArr2[i4 + 3] = 61;
                break;
            case 3:
                bArr2[i4] = bArr3[i8 >>> 18];
                bArr2[i4 + 1] = bArr3[(i8 >>> 12) & 63];
                bArr2[i4 + 2] = bArr3[(i8 >>> 6) & 63];
                bArr2[i4 + 3] = bArr3[i8 & 63];
                break;
        }
        return bArr2;
    }

    private static String J(byte[] bArr, int i2) {
        byte[] bArr2;
        AppMethodBeat.i(156671);
        if (bArr == null) {
            Log.i("MicroMsg.AppBrandNetWork.Base64", "Cannot serialize a null array.");
            bArr2 = new byte[0];
        } else if (i2 < 0) {
            Log.i("MicroMsg.AppBrandNetWork.Base64", "Cannot have length offset: ".concat(String.valueOf(i2)));
            bArr2 = new byte[0];
        } else if (i2 + 0 > bArr.length) {
            Log.i("MicroMsg.AppBrandNetWork.Base64", "off + len > source.length  ");
            bArr2 = new byte[0];
        } else {
            bArr2 = new byte[((i2 % 3 > 0 ? 4 : 0) + ((i2 / 3) * 4))];
            int i3 = i2 - 2;
            int i4 = 0;
            int i5 = 0;
            while (i5 < i3) {
                a(bArr, i5 + 0, 3, bArr2, i4, 0);
                i4 += 4;
                i5 += 3;
            }
            if (i5 < i2) {
                a(bArr, i5 + 0, i2 - i5, bArr2, i4, 0);
                i4 += 4;
            }
            if (i4 <= bArr2.length - 1) {
                byte[] bArr3 = new byte[i4];
                System.arraycopy(bArr2, 0, bArr3, 0, i4);
                bArr2 = bArr3;
            }
        }
        try {
            String str = new String(bArr2, "US-ASCII");
            AppMethodBeat.o(156671);
            return str;
        } catch (UnsupportedEncodingException e2) {
            String str2 = new String(bArr2);
            AppMethodBeat.o(156671);
            return str2;
        }
    }
}
