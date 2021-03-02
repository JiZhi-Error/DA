package com.tencent.recovery.wx.util;

import com.qq.taf.jce.JceStruct;
import com.tencent.wxmm.v2encoder;

public class MyDES {
    public static final int DECRYPTION = 1;
    public static final int ENCRYPTION = 0;

    private static void InitVars(MyByteArray myByteArray, MyByteArray myByteArray2, MyByteArray myByteArray3, MyByteArray myByteArray4, MyByteArray myByteArray5, MyByteArray myByteArray6) {
        myByteArray3.begin = 0;
        myByteArray3.array = myByteArray2.array;
        myByteArray4.begin = 28;
        myByteArray4.array = myByteArray2.array;
        myByteArray5.begin = 0;
        myByteArray5.array = myByteArray.array;
        myByteArray6.begin = 32;
        myByteArray6.array = myByteArray.array;
    }

    private static void XOR2(MyByteArray myByteArray, MyByteArray myByteArray2, MyByteArray myByteArray3) {
        for (int i2 = 0; i2 < 8; i2++) {
            myByteArray.array[myByteArray.begin + i2] = (byte) (myByteArray2.array[myByteArray2.begin + i2] ^ myByteArray3.array[myByteArray3.begin + i2]);
        }
    }

    private static void XOR(MyByteArray myByteArray, MyByteArray myByteArray2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr = myByteArray.array;
            int i4 = myByteArray.begin + i3;
            bArr[i4] = (byte) (bArr[i4] ^ myByteArray2.array[myByteArray2.begin + i3]);
        }
    }

    private static void ByteToBit(MyByteArray myByteArray, MyByteArray myByteArray2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            myByteArray.array[myByteArray.begin + i3] = (byte) ((myByteArray2.array[(i3 >> 3) + myByteArray2.begin] >> (i3 & 7)) & 1);
        }
    }

    private static void BitToByte(MyByteArray myByteArray, MyByteArray myByteArray2, int i2) {
        memset(myByteArray, 0, i2 >> 3);
        for (int i3 = 0; i3 < i2; i3++) {
            byte[] bArr = myByteArray.array;
            int i4 = myByteArray.begin + (i3 >> 3);
            bArr[i4] = (byte) (bArr[i4] | (myByteArray2.array[myByteArray2.begin + i3] << (i3 & 7)));
        }
    }

    private static void CYCLELEFT(MyByteArray myByteArray, MyByteArray myByteArray2, int i2, int i3) {
        memcpy(myByteArray2, myByteArray, i3);
        for (int i4 = 0; i4 < i2 - i3; i4++) {
            myByteArray.array[myByteArray.begin + i4] = myByteArray.array[myByteArray.begin + i4 + i3];
        }
        for (int i5 = 0; i5 < i3; i5++) {
            myByteArray.array[((myByteArray.begin + i5) + i2) - i3] = myByteArray2.array[myByteArray2.begin + i5];
        }
    }

    private static void TRANSFORM(MyByteArray myByteArray, MyByteArray myByteArray2, byte[] bArr, int i2, MyByteArray myByteArray3) {
        for (int i3 = 0; i3 < i2; i3++) {
            myByteArray3.array[myByteArray3.begin + i3] = myByteArray2.array[(myByteArray2.begin + bArr[i3]) - 1];
        }
        memcpy(myByteArray, myByteArray3, i2);
    }

    private static void Set_SubKey(MyByteArray[] myByteArrayArr, MyByteArray myByteArray, MyByteArray myByteArray2, MyByteArray myByteArray3, MyByteArray myByteArray4, MyByteArray myByteArray5) {
        byte[] bArr = {57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18, 10, 2, 59, 51, 43, 35, 27, 19, JceStruct.STRUCT_END, 3, 60, 52, 44, 36, 63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22, 14, 6, 61, 53, 45, 37, 29, 21, JceStruct.SIMPLE_LIST, 5, 28, 20, JceStruct.ZERO_TAG, 4};
        byte[] bArr2 = {14, 17, JceStruct.STRUCT_END, 24, 1, 5, 3, 28, 15, 6, 21, 10, 23, 19, JceStruct.ZERO_TAG, 4, 26, 8, v2encoder.enumCODEC_vcodec2, 7, 27, 20, JceStruct.SIMPLE_LIST, 2, 41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48, 44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32};
        byte[] bArr3 = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};
        ByteToBit(myByteArray2, myByteArray, 64);
        TRANSFORM(myByteArray2, myByteArray2, bArr, 56, myByteArray5);
        for (int i2 = 0; i2 < 16; i2++) {
            CYCLELEFT(myByteArray3, myByteArray5, 28, bArr3[i2]);
            CYCLELEFT(myByteArray4, myByteArray5, 28, bArr3[i2]);
            TRANSFORM(myByteArrayArr[i2], myByteArray2, bArr2, 48, myByteArray5);
        }
    }

    private static void SETKEY(MyByteArray[] myByteArrayArr, MyByteArray myByteArray, byte[] bArr, int i2, MyByteArray myByteArray2, MyByteArray myByteArray3, MyByteArray myByteArray4, MyByteArray myByteArray5) {
        memset(myByteArray, 0, 24);
        MyByteArray myByteArray6 = new MyByteArray(bArr);
        if (i2 > 24) {
            i2 = 24;
        }
        memcpy(myByteArray, myByteArray6, i2);
        Set_SubKey(myByteArrayArr, myByteArray, myByteArray2, myByteArray3, myByteArray4, myByteArray5);
    }

    private static void S_BOXF(MyByteArray myByteArray, MyByteArray myByteArray2) {
        byte b2 = 0;
        byte[][][] bArr = {new byte[][]{new byte[]{14, 4, JceStruct.SIMPLE_LIST, 1, 2, 15, JceStruct.STRUCT_END, 8, 3, 10, 6, JceStruct.ZERO_TAG, 5, 9, 0, 7}, new byte[]{0, 15, 7, 4, 14, 2, JceStruct.SIMPLE_LIST, 1, 10, 6, JceStruct.ZERO_TAG, JceStruct.STRUCT_END, 9, 5, 3, 8}, new byte[]{4, 1, 14, 8, JceStruct.SIMPLE_LIST, 6, 2, JceStruct.STRUCT_END, 15, JceStruct.ZERO_TAG, 9, 7, 3, 10, 5, 0}, new byte[]{15, JceStruct.ZERO_TAG, 8, 2, 4, 9, 1, 7, 5, JceStruct.STRUCT_END, 3, 14, 10, 0, 6, JceStruct.SIMPLE_LIST}}, new byte[][]{new byte[]{15, 1, 8, 14, 6, JceStruct.STRUCT_END, 3, 4, 9, 7, 2, JceStruct.SIMPLE_LIST, JceStruct.ZERO_TAG, 0, 5, 10}, new byte[]{3, JceStruct.SIMPLE_LIST, 4, 7, 15, 2, 8, 14, JceStruct.ZERO_TAG, 0, 1, 10, 6, 9, JceStruct.STRUCT_END, 5}, new byte[]{0, 14, 7, JceStruct.STRUCT_END, 10, 4, JceStruct.SIMPLE_LIST, 1, 5, 8, JceStruct.ZERO_TAG, 6, 9, 3, 2, 15}, new byte[]{JceStruct.SIMPLE_LIST, 8, 10, 1, 3, 15, 4, 2, JceStruct.STRUCT_END, 6, 7, JceStruct.ZERO_TAG, 0, 5, 14, 9}}, new byte[][]{new byte[]{10, 0, 9, 14, 6, 3, 15, 5, 1, JceStruct.SIMPLE_LIST, JceStruct.ZERO_TAG, 7, JceStruct.STRUCT_END, 4, 2, 8}, new byte[]{JceStruct.SIMPLE_LIST, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, JceStruct.ZERO_TAG, JceStruct.STRUCT_END, 15, 1}, new byte[]{JceStruct.SIMPLE_LIST, 6, 4, 9, 8, 15, 3, 0, JceStruct.STRUCT_END, 1, 2, JceStruct.ZERO_TAG, 5, 10, 14, 7}, new byte[]{1, 10, JceStruct.SIMPLE_LIST, 0, 6, 9, 8, 7, 4, 15, 14, 3, JceStruct.STRUCT_END, 5, 2, JceStruct.ZERO_TAG}}, new byte[][]{new byte[]{7, JceStruct.SIMPLE_LIST, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, 4, 15}, new byte[]{JceStruct.SIMPLE_LIST, 8, JceStruct.STRUCT_END, 5, 6, 15, 0, 3, 4, 7, 2, JceStruct.ZERO_TAG, 1, 10, 14, 9}, new byte[]{10, 6, 9, 0, JceStruct.ZERO_TAG, JceStruct.STRUCT_END, 7, JceStruct.SIMPLE_LIST, 15, 1, 3, 14, 5, 2, 8, 4}, new byte[]{3, 15, 0, 6, 10, 1, JceStruct.SIMPLE_LIST, 8, 9, 4, 5, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, 7, 2, 14}}, new byte[][]{new byte[]{2, JceStruct.ZERO_TAG, 4, 1, 7, 10, JceStruct.STRUCT_END, 6, 8, 5, 3, 15, JceStruct.SIMPLE_LIST, 0, 14, 9}, new byte[]{14, JceStruct.STRUCT_END, 2, JceStruct.ZERO_TAG, 4, 7, JceStruct.SIMPLE_LIST, 1, 5, 0, 15, 10, 3, 9, 8, 6}, new byte[]{4, 2, 1, JceStruct.STRUCT_END, 10, JceStruct.SIMPLE_LIST, 7, 8, 15, 9, JceStruct.ZERO_TAG, 5, 6, 3, 0, 14}, new byte[]{JceStruct.STRUCT_END, 8, JceStruct.ZERO_TAG, 7, 1, 14, 2, JceStruct.SIMPLE_LIST, 6, 15, 0, 9, 10, 4, 5, 3}}, new byte[][]{new byte[]{JceStruct.ZERO_TAG, 1, 10, 15, 9, 2, 6, 8, 0, JceStruct.SIMPLE_LIST, 3, 4, 14, 7, 5, JceStruct.STRUCT_END}, new byte[]{10, 15, 4, 2, 7, JceStruct.ZERO_TAG, 9, 5, 6, 1, JceStruct.SIMPLE_LIST, 14, 0, JceStruct.STRUCT_END, 3, 8}, new byte[]{9, 14, 15, 5, 2, 8, JceStruct.ZERO_TAG, 3, 7, 0, 4, 10, 1, JceStruct.SIMPLE_LIST, JceStruct.STRUCT_END, 6}, new byte[]{4, 3, 2, JceStruct.ZERO_TAG, 9, 5, 15, 10, JceStruct.STRUCT_END, 14, 1, 7, 6, 0, 8, JceStruct.SIMPLE_LIST}}, new byte[][]{new byte[]{4, JceStruct.STRUCT_END, 2, 14, 15, 0, 8, JceStruct.SIMPLE_LIST, 3, JceStruct.ZERO_TAG, 9, 7, 5, 10, 6, 1}, new byte[]{JceStruct.SIMPLE_LIST, 0, JceStruct.STRUCT_END, 7, 4, 9, 1, 10, 14, 3, 5, JceStruct.ZERO_TAG, 2, 15, 8, 6}, new byte[]{1, 4, JceStruct.STRUCT_END, JceStruct.SIMPLE_LIST, JceStruct.ZERO_TAG, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2}, new byte[]{6, JceStruct.STRUCT_END, JceStruct.SIMPLE_LIST, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, JceStruct.ZERO_TAG}}, new byte[][]{new byte[]{JceStruct.SIMPLE_LIST, 2, 8, 4, 6, 15, JceStruct.STRUCT_END, 1, 10, 9, 3, 14, 5, 0, JceStruct.ZERO_TAG, 7}, new byte[]{1, 15, JceStruct.SIMPLE_LIST, 8, 10, 3, 7, 4, JceStruct.ZERO_TAG, 5, 6, JceStruct.STRUCT_END, 0, 14, 9, 2}, new byte[]{7, JceStruct.STRUCT_END, 4, 1, 9, JceStruct.ZERO_TAG, 14, 2, 0, 6, 10, JceStruct.SIMPLE_LIST, 15, 3, 5, 8}, new byte[]{2, 1, 14, 7, 4, 10, 8, JceStruct.SIMPLE_LIST, 15, JceStruct.ZERO_TAG, 9, 0, 3, 5, 6, JceStruct.STRUCT_END}}};
        int i2 = myByteArray2.begin;
        int i3 = myByteArray.begin;
        while (b2 < 8) {
            ByteToBit(myByteArray, new MyByteArray(bArr[b2][(byte) ((myByteArray2.array[myByteArray2.begin + 0] << 1) + myByteArray2.array[myByteArray2.begin + 5])][(byte) ((myByteArray2.array[myByteArray2.begin + 1] << 3) + (myByteArray2.array[myByteArray2.begin + 2] << 2) + (myByteArray2.array[myByteArray2.begin + 3] << 1) + myByteArray2.array[myByteArray2.begin + 4])]), 4);
            b2 = (byte) (b2 + 1);
            myByteArray2.begin += 6;
            myByteArray.begin += 4;
        }
        myByteArray2.begin = i2;
        myByteArray.begin = i3;
    }

    private static void F_FUNCTION(MyByteArray myByteArray, MyByteArray myByteArray2, MyByteArray myByteArray3, MyByteArray myByteArray4) {
        byte[] bArr = {32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9, 8, 9, 10, JceStruct.STRUCT_END, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, JceStruct.ZERO_TAG, JceStruct.SIMPLE_LIST, 14, 15, v2encoder.enumCODEC_vcodec2, 17, v2encoder.enumCODEC_vcodec2, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25, 24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1};
        byte[] bArr2 = {v2encoder.enumCODEC_vcodec2, 7, 20, 21, 29, JceStruct.ZERO_TAG, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10, 2, 8, 24, 14, 32, 27, 3, 9, 19, JceStruct.SIMPLE_LIST, 30, 6, 22, JceStruct.STRUCT_END, 4, 25};
        TRANSFORM(myByteArray3, myByteArray, bArr, 48, myByteArray4);
        XOR(myByteArray3, myByteArray2, 48);
        S_BOXF(myByteArray, myByteArray3);
        TRANSFORM(myByteArray, myByteArray, bArr2, 32, myByteArray4);
    }

    private static void DES(MyByteArray myByteArray, MyByteArray myByteArray2, MyByteArray[] myByteArrayArr, int i2, MyByteArray myByteArray3, MyByteArray myByteArray4, MyByteArray myByteArray5, MyByteArray myByteArray6, MyByteArray myByteArray7, MyByteArray myByteArray8) {
        byte[] bArr = {58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, JceStruct.ZERO_TAG, 4, 62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, v2encoder.enumCODEC_vcodec2, 8, 57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, JceStruct.STRUCT_END, 3, 61, 53, 45, 37, 29, 21, JceStruct.SIMPLE_LIST, 5, 63, 55, 47, 39, 31, 23, 15, 7};
        byte[] bArr2 = {40, 8, 48, v2encoder.enumCODEC_vcodec2, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31, 38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, JceStruct.SIMPLE_LIST, 53, 21, 61, 29, 36, 4, 44, JceStruct.ZERO_TAG, 52, 20, 60, 28, 35, 3, 43, JceStruct.STRUCT_END, 51, 19, 59, 27, 34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25};
        ByteToBit(myByteArray3, myByteArray2, 64);
        TRANSFORM(myByteArray3, myByteArray3, bArr, 64, myByteArray8);
        if (i2 == 0) {
            for (int i3 = 0; i3 < 16; i3++) {
                memcpy(myByteArray5, myByteArray7, 32);
                F_FUNCTION(myByteArray7, myByteArrayArr[i3], myByteArray4, myByteArray8);
                XOR(myByteArray7, myByteArray6, 32);
                memcpy(myByteArray6, myByteArray5, 32);
            }
        } else {
            for (int i4 = 15; i4 >= 0; i4--) {
                memcpy(myByteArray5, myByteArray6, 32);
                F_FUNCTION(myByteArray6, myByteArrayArr[i4], myByteArray4, myByteArray8);
                XOR(myByteArray6, myByteArray7, 32);
                memcpy(myByteArray7, myByteArray5, 32);
            }
        }
        TRANSFORM(myByteArray3, myByteArray3, bArr2, 64, myByteArray8);
        BitToByte(myByteArray, myByteArray3, 64);
    }

    public static char Using_DES(byte[] bArr, byte[] bArr2, long j2, int i2, byte[] bArr3, int i3) {
        MyByteArray myByteArray = new MyByteArray(bArr);
        MyByteArray myByteArray2 = new MyByteArray(bArr2);
        MyByteArray[] myByteArrayArr = new MyByteArray[16];
        for (int i4 = 0; i4 < 16; i4++) {
            myByteArrayArr[i4] = new MyByteArray(new byte[48]);
        }
        MyByteArray myByteArray3 = new MyByteArray(new byte[256]);
        MyByteArray myByteArray4 = new MyByteArray(new byte[24]);
        MyByteArray myByteArray5 = new MyByteArray(new byte[64]);
        MyByteArray myByteArray6 = new MyByteArray();
        MyByteArray myByteArray7 = new MyByteArray();
        MyByteArray myByteArray8 = new MyByteArray();
        MyByteArray myByteArray9 = new MyByteArray();
        MyByteArray myByteArray10 = new MyByteArray(new byte[64]);
        MyByteArray myByteArray11 = new MyByteArray(new byte[48]);
        MyByteArray myByteArray12 = new MyByteArray(new byte[32]);
        MyByteArray myByteArray13 = new MyByteArray(new byte[9]);
        MyByteArray myByteArray14 = new MyByteArray(new byte[8]);
        if (bArr3 != null && bArr3.length > 0) {
            long j3 = (7 + j2) & -8;
            if (j3 != 0) {
                InitVars(myByteArray10, myByteArray5, myByteArray6, myByteArray7, myByteArray8, myByteArray9);
                SETKEY(myByteArrayArr, myByteArray4, bArr3, i2, myByteArray5, myByteArray6, myByteArray7, myByteArray3);
                int i5 = myByteArray2.begin;
                int i6 = myByteArray.begin;
                if (i3 == 0) {
                    DES(myByteArray, myByteArray13, myByteArrayArr, i3, myByteArray10, myByteArray11, myByteArray12, myByteArray8, myByteArray9, myByteArray3);
                    memcpy(myByteArray14, myByteArray, 8);
                    myByteArray.begin += 8;
                    long j4 = 0;
                    long j5 = j3 >> 3;
                    while (j4 < j5) {
                        XOR2(myByteArray14, myByteArray14, myByteArray2);
                        DES(myByteArray, myByteArray14, myByteArrayArr, i3, myByteArray10, myByteArray11, myByteArray12, myByteArray8, myByteArray9, myByteArray3);
                        memcpy(myByteArray14, myByteArray, 8);
                        j4++;
                        myByteArray.begin += 8;
                        myByteArray2.begin += 8;
                    }
                } else {
                    memcpy(myByteArray13, myByteArray2, 8);
                    myByteArray2.begin += 8;
                    long j6 = 1;
                    long j7 = j3 >> 3;
                    while (j6 < j7) {
                        DES(myByteArray14, myByteArray2, myByteArrayArr, i3, myByteArray10, myByteArray11, myByteArray12, myByteArray8, myByteArray9, myByteArray3);
                        XOR2(myByteArray, myByteArray14, myByteArray13);
                        memcpy(myByteArray13, myByteArray2, 8);
                        j6++;
                        myByteArray.begin += 8;
                        myByteArray2.begin += 8;
                    }
                }
                myByteArray2.begin = i5;
                myByteArray.begin = i6;
                return 1;
            }
        }
        return 0;
    }

    private static void memcpy(MyByteArray myByteArray, MyByteArray myByteArray2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            myByteArray.array[myByteArray.begin + i3] = myByteArray2.array[myByteArray2.begin + i3];
        }
    }

    private static void memset(MyByteArray myByteArray, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            myByteArray.array[myByteArray.begin + i4] = (byte) i2;
        }
    }
}
