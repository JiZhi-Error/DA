package com.google.android.exoplayer2.c;

import com.tencent.mm.plugin.appbrand.jsapi.nfc.g;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.wcdb.FileUtils;

public final class j {
    private static final String[] bhY = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    private static final int[] bhZ = {44100, 48000, 32000};
    private static final int[] bia = {32, 64, 96, 128, 160, 192, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 256, 288, 320, g.CTRL_INDEX, 384, 416, FileUtils.S_IRWXU};
    private static final int[] bib = {32, 48, 56, 64, 80, 96, 112, 128, 144, 160, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6, 192, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 256};
    private static final int[] bic = {32, 48, 56, 64, 80, 96, 112, 128, 160, 192, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 256, 320, 384};
    private static final int[] bid = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 256, 320};
    private static final int[] bie = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};
    public int beI;
    public int bif;
    public int bitrate;
    public int channels;
    public String mimeType;
    public int sampleRate;
    public int version;

    public static int dW(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        if ((i2 & -2097152) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return -1;
        }
        int i9 = bhZ[i6];
        if (i3 == 2) {
            i7 = i9 / 2;
        } else if (i3 == 0) {
            i7 = i9 / 4;
        } else {
            i7 = i9;
        }
        int i10 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            return ((((i3 == 3 ? bia[i5 - 1] : bib[i5 - 1]) * 12000) / i7) + i10) * 4;
        }
        if (i3 == 3) {
            i8 = i4 == 2 ? bic[i5 - 1] : bid[i5 - 1];
        } else {
            i8 = bie[i5 - 1];
        }
        if (i3 == 3) {
            return ((144000 * i8) / i7) + i10;
        }
        return (((i4 == 1 ? 72000 : 144000) * i8) / i7) + i10;
    }

    public static boolean a(int i2, j jVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if ((i2 & -2097152) != -2097152) {
            return false;
        }
        int i10 = (i2 >>> 19) & 3;
        if (i10 == 1) {
            return false;
        }
        int i11 = (i2 >>> 17) & 3;
        if (i11 == 0) {
            return false;
        }
        int i12 = (i2 >>> 12) & 15;
        if (i12 == 0 || i12 == 15) {
            return false;
        }
        int i13 = (i2 >>> 10) & 3;
        if (i13 == 3) {
            return false;
        }
        int i14 = bhZ[i13];
        if (i10 == 2) {
            i3 = i14 / 2;
        } else if (i10 == 0) {
            i3 = i14 / 4;
        } else {
            i3 = i14;
        }
        int i15 = (i2 >>> 9) & 1;
        if (i11 == 3) {
            int i16 = i10 == 3 ? bia[i12 - 1] : bib[i12 - 1];
            i8 = (((i16 * 12000) / i3) + i15) * 4;
            i7 = 384;
            i4 = i16;
        } else {
            if (i10 == 3) {
                int i17 = i11 == 2 ? bic[i12 - 1] : bid[i12 - 1];
                i5 = 1152;
                i4 = i17;
            } else {
                i4 = bie[i12 - 1];
                int i18 = i11 == 1 ? 576 : 1152;
                if (i11 == 1) {
                    i6 = 72000;
                    i7 = i18;
                    i8 = ((i6 * i4) / i3) + i15;
                } else {
                    i5 = i18;
                }
            }
            i6 = 144000;
            i7 = i5;
            i8 = ((i6 * i4) / i3) + i15;
        }
        String str = bhY[3 - i11];
        if (((i2 >> 6) & 3) == 3) {
            i9 = 1;
        } else {
            i9 = 2;
        }
        jVar.version = i10;
        jVar.mimeType = str;
        jVar.beI = i8;
        jVar.sampleRate = i3;
        jVar.channels = i9;
        jVar.bitrate = i4 * 1000;
        jVar.bif = i7;
        return true;
    }
}
