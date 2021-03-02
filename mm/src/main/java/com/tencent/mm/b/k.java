package com.tencent.mm.b;

import com.qq.taf.jce.JceStruct;
import com.tencent.wxmm.v2encoder;

public final class k {
    private static void a(j jVar, j jVar2, j jVar3, j jVar4, j jVar5, j jVar6) {
        jVar3.begin = 0;
        jVar3.array = jVar2.array;
        jVar4.begin = 28;
        jVar4.array = jVar2.array;
        jVar5.begin = 0;
        jVar5.array = jVar.array;
        jVar6.begin = 32;
        jVar6.array = jVar.array;
    }

    private static void a(j jVar, j jVar2, j jVar3) {
        for (int i2 = 0; i2 < 8; i2++) {
            jVar.array[jVar.begin + i2] = (byte) (jVar2.array[jVar2.begin + i2] ^ jVar3.array[jVar3.begin + i2]);
        }
    }

    private static void a(j jVar, j jVar2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr = jVar.array;
            int i4 = jVar.begin + i3;
            bArr[i4] = (byte) (bArr[i4] ^ jVar2.array[jVar2.begin + i3]);
        }
    }

    private static void b(j jVar, j jVar2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            jVar.array[jVar.begin + i3] = (byte) ((jVar2.array[(i3 >> 3) + jVar2.begin] >> (i3 & 7)) & 1);
        }
    }

    private static void c(j jVar, j jVar2, int i2) {
        d(jVar2, jVar, i2);
        for (int i3 = 0; i3 < 28 - i2; i3++) {
            jVar.array[jVar.begin + i3] = jVar.array[jVar.begin + i3 + i2];
        }
        for (int i4 = 0; i4 < i2; i4++) {
            jVar.array[((jVar.begin + i4) + 28) - i2] = jVar2.array[jVar2.begin + i4];
        }
    }

    private static void a(j jVar, j jVar2, byte[] bArr, int i2, j jVar3) {
        for (int i3 = 0; i3 < i2; i3++) {
            jVar3.array[jVar3.begin + i3] = jVar2.array[(jVar2.begin + bArr[i3]) - 1];
        }
        d(jVar, jVar3, i2);
    }

    private static void a(j[] jVarArr, j jVar, byte[] bArr, int i2, j jVar2, j jVar3, j jVar4, j jVar5) {
        a(jVar, 24);
        j jVar6 = new j(bArr);
        if (i2 > 24) {
            i2 = 24;
        }
        d(jVar, jVar6, i2);
        byte[] bArr2 = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, JceStruct.STRUCT_END, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, JceStruct.SIMPLE_LIST, 5, 28, 20, JceStruct.ZERO_TAG, 4};
        byte[] bArr3 = {14, 17, JceStruct.STRUCT_END, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, JceStruct.ZERO_TAG, 4, 26, 8, v2encoder.enumCODEC_vcodec2, 7, 27, 20, JceStruct.SIMPLE_LIST, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32};
        byte[] bArr4 = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};
        b(jVar2, jVar, 64);
        a(jVar2, jVar2, bArr2, 56, jVar5);
        for (int i3 = 0; i3 < 16; i3++) {
            c(jVar3, jVar5, bArr4[i3]);
            c(jVar4, jVar5, bArr4[i3]);
            a(jVarArr[i3], jVar2, bArr3, 48, jVar5);
        }
    }

    private static void a(j jVar, j jVar2, j jVar3, j jVar4) {
        byte b2 = 0;
        byte[] bArr = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, 14, 15, v2encoder.enumCODEC_vcodec2, 17, v2encoder.enumCODEC_vcodec2, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};
        byte[] bArr2 = {v2encoder.enumCODEC_vcodec2, 7, 20, 21, 29, JceStruct.ZERO_TAG, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, JceStruct.SIMPLE_LIST, 30, 6, 22, JceStruct.STRUCT_END, 4, 25};
        a(jVar3, jVar, bArr, 48, jVar4);
        a(jVar3, jVar2, 48);
        byte[][][] bArr3 = {new byte[][]{new byte[]{14, 4, JceStruct.SIMPLE_LIST, 1, 2, 15, JceStruct.STRUCT_END, 8, 3, 10, 6, JceStruct.ZERO_TAG, 5, 9, 0, 7}, new byte[]{0, 15, 7, 4, 14, 2, JceStruct.SIMPLE_LIST, 1, 10, 6, JceStruct.ZERO_TAG, JceStruct.STRUCT_END, 9, 5, 3, 8}, new byte[]{4, 1, 14, 8, JceStruct.SIMPLE_LIST, 6, 2, JceStruct.STRUCT_END, 15, JceStruct.ZERO_TAG, 9, 7, 3, 10, 5, 0}, new byte[]{15, JceStruct.ZERO_TAG, 8, 2, 4, 9, 1, 7, 5, JceStruct.STRUCT_END, 3, 14, 10, 0, 6, JceStruct.SIMPLE_LIST}}, new byte[][]{new byte[]{15, 1, 8, 14, 6, JceStruct.STRUCT_END, 3, 4, 9, 7, 2, JceStruct.SIMPLE_LIST, JceStruct.ZERO_TAG, 0, 5, 10}, new byte[]{3, JceStruct.SIMPLE_LIST, 4, 7, 15, 2, 8, 14, JceStruct.ZERO_TAG, 0, 1, 10, 6, 9, JceStruct.STRUCT_END, 5}, new byte[]{0, 14, 7, JceStruct.STRUCT_END, 10, 4, JceStruct.SIMPLE_LIST, 1, 5, 8, JceStruct.ZERO_TAG, 6, 9, 3, 2, 15}, new byte[]{JceStruct.SIMPLE_LIST, 8, 10, 1, 3, 15, 4, 2, JceStruct.STRUCT_END, 6, 7, JceStruct.ZERO_TAG, 0, 5, 14, 9}}, new byte[][]{new byte[]{10, 0, 9, 14, 6, 3, 15, 5, 1, JceStruct.SIMPLE_LIST, JceStruct.ZERO_TAG, 7, JceStruct.STRUCT_END, 4, 2, 8}, new byte[]{JceStruct.SIMPLE_LIST, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, JceStruct.ZERO_TAG, JceStruct.STRUCT_END, 15, 1}, new byte[]{JceStruct.SIMPLE_LIST, 6, 4, 9, 8, 15, 3, 0, JceStruct.STRUCT_END, 1, 2, JceStruct.ZERO_TAG, 5, 10, 14, 7}, new byte[]{1, 10, JceStruct.SIMPLE_LIST, 0, 6, 9, 8, 7, 4, 15, 14, 3, JceStruct.STRUCT_END, 5, 2, JceStruct.ZERO_TAG}}, new byte[][]{new byte[]{7, JceStruct.SIMPLE_LIST, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, 4, 15}, new byte[]{JceStruct.SIMPLE_LIST, 8, JceStruct.STRUCT_END, 5, 6, 15, 0, 3, 4, 7, 2, JceStruct.ZERO_TAG, 1, 10, 14, 9}, new byte[]{10, 6, 9, 0, JceStruct.ZERO_TAG, JceStruct.STRUCT_END, 7, JceStruct.SIMPLE_LIST, 15, 1, 3, 14, 5, 2, 8, 4}, new byte[]{3, 15, 0, 6, 10, 1, JceStruct.SIMPLE_LIST, 8, 9, 4, 5, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, 7, 2, 14}}, new byte[][]{new byte[]{2, JceStruct.ZERO_TAG, 4, 1, 7, 10, JceStruct.STRUCT_END, 6, 8, 5, 3, 15, JceStruct.SIMPLE_LIST, 0, 14, 9}, new byte[]{14, JceStruct.STRUCT_END, 2, JceStruct.ZERO_TAG, 4, 7, JceStruct.SIMPLE_LIST, 1, 5, 0, 15, 10, 3, 9, 8, 6}, new byte[]{4, 2, 1, JceStruct.STRUCT_END, 10, JceStruct.SIMPLE_LIST, 7, 8, 15, 9, JceStruct.ZERO_TAG, 5, 6, 3, 0, 14}, new byte[]{JceStruct.STRUCT_END, 8, JceStruct.ZERO_TAG, 7, 1, 14, 2, JceStruct.SIMPLE_LIST, 6, 15, 0, 9, 10, 4, 5, 3}}, new byte[][]{new byte[]{JceStruct.ZERO_TAG, 1, 10, 15, 9, 2, 6, 8, 0, JceStruct.SIMPLE_LIST, 3, 4, 14, 7, 5, JceStruct.STRUCT_END}, new byte[]{10, 15, 4, 2, 7, JceStruct.ZERO_TAG, 9, 5, 6, 1, JceStruct.SIMPLE_LIST, 14, 0, JceStruct.STRUCT_END, 3, 8}, new byte[]{9, 14, 15, 5, 2, 8, JceStruct.ZERO_TAG, 3, 7, 0, 4, 10, 1, JceStruct.SIMPLE_LIST, JceStruct.STRUCT_END, 6}, new byte[]{4, 3, 2, JceStruct.ZERO_TAG, 9, 5, 15, 10, JceStruct.STRUCT_END, 14, 1, 7, 6, 0, 8, JceStruct.SIMPLE_LIST}}, new byte[][]{new byte[]{4, JceStruct.STRUCT_END, 2, 14, 15, 0, 8, JceStruct.SIMPLE_LIST, 3, JceStruct.ZERO_TAG, 9, 7, 5, 10, 6, 1}, new byte[]{JceStruct.SIMPLE_LIST, 0, JceStruct.STRUCT_END, 7, 4, 9, 1, 10, 14, 3, 5, JceStruct.ZERO_TAG, 2, 15, 8, 6}, new byte[]{1, 4, JceStruct.STRUCT_END, JceStruct.SIMPLE_LIST, JceStruct.ZERO_TAG, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2}, new byte[]{6, JceStruct.STRUCT_END, JceStruct.SIMPLE_LIST, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, JceStruct.ZERO_TAG}}, new byte[][]{new byte[]{JceStruct.SIMPLE_LIST, 2, 8, 4, 6, 15, JceStruct.STRUCT_END, 1, 10, 9, 3, 14, 5, 0, JceStruct.ZERO_TAG, 7}, new byte[]{1, 15, JceStruct.SIMPLE_LIST, 8, 10, 3, 7, 4, JceStruct.ZERO_TAG, 5, 6, JceStruct.STRUCT_END, 0, 14, 9, 2}, new byte[]{7, JceStruct.STRUCT_END, 4, 1, 9, JceStruct.ZERO_TAG, 14, 2, 0, 6, 10, JceStruct.SIMPLE_LIST, 15, 3, 5, 8}, new byte[]{2, 1, 14, 7, 4, 10, 8, JceStruct.SIMPLE_LIST, 15, JceStruct.ZERO_TAG, 9, 0, 3, 5, 6, JceStruct.STRUCT_END}}};
        int i2 = jVar3.begin;
        int i3 = jVar.begin;
        while (b2 < 8) {
            b(jVar, new j(bArr3[b2][(byte) ((jVar3.array[jVar3.begin + 0] << 1) + jVar3.array[jVar3.begin + 5])][(byte) ((jVar3.array[jVar3.begin + 1] << 3) + (jVar3.array[jVar3.begin + 2] << 2) + (jVar3.array[jVar3.begin + 3] << 1) + jVar3.array[jVar3.begin + 4])]), 4);
            b2 = (byte) (b2 + 1);
            jVar3.begin += 6;
            jVar.begin += 4;
        }
        jVar3.begin = i2;
        jVar.begin = i3;
        a(jVar, jVar, bArr2, 32, jVar4);
    }

    private static void a(j jVar, j jVar2, j[] jVarArr, int i2, j jVar3, j jVar4, j jVar5, j jVar6, j jVar7, j jVar8) {
        byte[] bArr = {58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, JceStruct.ZERO_TAG, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, v2encoder.enumCODEC_vcodec2, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, JceStruct.STRUCT_END, 3, 61, 53, 45, 37, 29, 21, JceStruct.SIMPLE_LIST, 5, 63, 55, 47, 39, 31, 23, 15, 7};
        byte[] bArr2 = {40, 8, 48, v2encoder.enumCODEC_vcodec2, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, JceStruct.SIMPLE_LIST, 53, 21, 61, 29, 36, 4, 44, JceStruct.ZERO_TAG, 52, 20, 60, 28, 35, 3, 43, JceStruct.STRUCT_END, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25};
        b(jVar3, jVar2, 64);
        a(jVar3, jVar3, bArr, 64, jVar8);
        if (i2 == 0) {
            for (int i3 = 0; i3 < 16; i3++) {
                d(jVar5, jVar7, 32);
                a(jVar7, jVarArr[i3], jVar4, jVar8);
                a(jVar7, jVar6, 32);
                d(jVar6, jVar5, 32);
            }
        } else {
            for (int i4 = 15; i4 >= 0; i4--) {
                d(jVar5, jVar6, 32);
                a(jVar6, jVarArr[i4], jVar4, jVar8);
                a(jVar6, jVar7, 32);
                d(jVar7, jVar5, 32);
            }
        }
        a(jVar3, jVar3, bArr2, 64, jVar8);
        a(jVar, 8);
        for (int i5 = 0; i5 < 64; i5++) {
            byte[] bArr3 = jVar.array;
            int i6 = jVar.begin + (i5 >> 3);
            bArr3[i6] = (byte) (bArr3[i6] | (jVar3.array[jVar3.begin + i5] << (i5 & 7)));
        }
    }

    public static char Using_DES(byte[] bArr, byte[] bArr2, long j2, int i2, byte[] bArr3, int i3) {
        j jVar = new j(bArr);
        j jVar2 = new j(bArr2);
        j[] jVarArr = new j[16];
        for (int i4 = 0; i4 < 16; i4++) {
            jVarArr[i4] = new j(new byte[48]);
        }
        j jVar3 = new j(new byte[256]);
        j jVar4 = new j(new byte[24]);
        j jVar5 = new j(new byte[64]);
        j jVar6 = new j();
        j jVar7 = new j();
        j jVar8 = new j();
        j jVar9 = new j();
        j jVar10 = new j(new byte[64]);
        j jVar11 = new j(new byte[48]);
        j jVar12 = new j(new byte[32]);
        j jVar13 = new j(new byte[9]);
        j jVar14 = new j(new byte[8]);
        if (bArr3 != null && bArr3.length > 0) {
            long j3 = (7 + j2) & -8;
            if (j3 != 0) {
                a(jVar10, jVar5, jVar6, jVar7, jVar8, jVar9);
                a(jVarArr, jVar4, bArr3, i2, jVar5, jVar6, jVar7, jVar3);
                int i5 = jVar2.begin;
                int i6 = jVar.begin;
                if (i3 == 0) {
                    a(jVar, jVar13, jVarArr, i3, jVar10, jVar11, jVar12, jVar8, jVar9, jVar3);
                    d(jVar14, jVar, 8);
                    jVar.begin += 8;
                    long j4 = 0;
                    long j5 = j3 >> 3;
                    while (j4 < j5) {
                        a(jVar14, jVar14, jVar2);
                        a(jVar, jVar14, jVarArr, i3, jVar10, jVar11, jVar12, jVar8, jVar9, jVar3);
                        d(jVar14, jVar, 8);
                        j4++;
                        jVar.begin += 8;
                        jVar2.begin += 8;
                    }
                } else {
                    d(jVar13, jVar2, 8);
                    jVar2.begin += 8;
                    long j6 = 1;
                    long j7 = j3 >> 3;
                    while (j6 < j7) {
                        a(jVar14, jVar2, jVarArr, i3, jVar10, jVar11, jVar12, jVar8, jVar9, jVar3);
                        a(jVar, jVar14, jVar13);
                        d(jVar13, jVar2, 8);
                        j6++;
                        jVar.begin += 8;
                        jVar2.begin += 8;
                    }
                }
                jVar2.begin = i5;
                jVar.begin = i6;
                return 1;
            }
        }
        return 0;
    }

    private static void d(j jVar, j jVar2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            jVar.array[jVar.begin + i3] = jVar2.array[jVar2.begin + i3];
        }
    }

    private static void a(j jVar, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            jVar.array[jVar.begin + i3] = 0;
        }
    }
}
