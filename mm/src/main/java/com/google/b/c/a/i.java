package com.google.b.c.a;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.cr;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.appbrand.jsapi.p.b;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.core.common.TPCodecParamers;

public final class i {
    private static final int[] cdI = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] cdJ = {new int[]{228, 48, 15, 111, 62}, new int[]{23, 68, 144, g.CTRL_INDEX, 240, 92, 254}, new int[]{28, 24, 185, 166, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, 248, 116, 255, 110, 61}, new int[]{TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, 138, 205, 12, 194, 168, 39, 245, 60, 97, 120}, new int[]{41, 153, 158, 91, 61, 42, TbsListener.ErrorCode.NEEDDOWNLOAD_3, 213, 97, 178, 100, 242}, new int[]{156, 97, 192, 252, 95, 9, 157, 119, 138, 45, 18, 186, 83, 185}, new int[]{83, 195, 100, 39, 188, 75, 66, 61, TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, 213, 109, 129, 94, 254, TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, 48, 90, 188}, new int[]{15, 195, 244, 9, TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, 71, 168, 2, 188, 160, 153, 145, 253, 79, 108, 82, 27, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, 186, 172}, new int[]{52, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 88, 205, 109, 39, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6, 21, 155, 197, 251, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, 155, 21, 5, 172, 254, 124, 12, 181, 184, 96, 50, 193}, new int[]{211, 231, 43, 97, 71, 96, 103, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, 37, 151, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE, 53, 75, 34, cr.CTRL_INDEX, 121, 17, 138, 110, 213, 141, r.CTRL_INDEX, 120, 151, TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, 168, 93, 255}, new int[]{245, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, 242, 218, 130, 250, TbsListener.ErrorCode.STARTDOWNLOAD_3, 181, 102, 120, 84, 179, TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, 251, 80, 182, 229, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, 184, 59, 25, TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, 98, 81, 112}, new int[]{77, 193, 137, 31, 19, 38, 22, 153, 247, 105, 122, 2, 245, 133, 242, 8, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, 95, 100, 9, TbsListener.ErrorCode.STARTDOWNLOAD_8, 105, 214, 111, 57, 121, 21, 1, 253, 57, 54, 101, 248, 202, 69, 50, 150, TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, 226, 5, 9, 5}, new int[]{245, 132, 172, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, 96, 32, 117, 22, TbsListener.ErrorCode.TPATCH_FAIL, 133, TbsListener.ErrorCode.TPATCH_FAIL, 231, 205, 188, TbsListener.ErrorCode.DECOUPLE_TPATCH_INSTALL_SUCCESS, 87, 191, 106, 16, TbsListener.ErrorCode.NEEDDOWNLOAD_8, 118, 23, 37, 90, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE, 205, TPCodecParamers.TP_PROFILE_MPEG2_AAC_HE, 88, 120, 100, 66, 138, 186, 240, 82, 44, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6, 87, 187, TbsListener.ErrorCode.NEEDDOWNLOAD_8, 160, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, 69, 213, 92, 253, TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR, 19}, new int[]{TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, 9, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, TbsListener.ErrorCode.TPATCH_FAIL, 12, 17, TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, 208, 100, 29, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE, 230, 192, 215, TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_FAIL, 150, JsApiGetBackgroundAudioState.CTRL_INDEX, 36, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, 38, 200, 132, 54, 228, 146, 218, TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS, 117, 203, 29, 232, 144, TbsListener.ErrorCode.TPATCH_FAIL, 22, 150, 201, 117, 62, 207, TbsListener.ErrorCode.STARTDOWNLOAD_5, 13, 137, 245, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, 67, 247, 28, 155, 43, 203, 107, TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS, 53, TbsListener.ErrorCode.NEEDDOWNLOAD_4, 46}, new int[]{242, 93, 169, 50, 144, 210, 39, 118, 202, 188, 201, 189, TbsListener.ErrorCode.NEEDDOWNLOAD_4, 108, 196, 37, 185, 112, g.CTRL_INDEX, 230, 245, 63, 197, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 250, 106, 185, TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_5, 64, 114, 71, 161, 44, TbsListener.ErrorCode.NEEDDOWNLOAD_8, 6, 27, 218, 51, 63, 87, 10, 40, 130, 188, 17, TbsListener.ErrorCode.STARTDOWNLOAD_4, 31, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_6, TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE, 4, 107, 232, 7, 94, 166, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 124, 86, 47, 11, 204}, new int[]{TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, 228, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3, 89, 251, 149, JsApiGetBackgroundAudioState.CTRL_INDEX, 56, 89, 33, TbsListener.ErrorCode.NEEDDOWNLOAD_8, 244, 154, 36, 73, TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH, 213, r.CTRL_INDEX, 248, TXLiveConstants.RENDER_ROTATION_180, TbsListener.ErrorCode.DECOUPLE_INCURUPDATE_SUCCESS, 197, 158, TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING, 68, 122, 93, 213, 15, 160, TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL, 236, 66, b.CTRL_INDEX, 153, 185, 202, TbsListener.ErrorCode.STARTDOWNLOAD_8, 179, 25, TbsListener.ErrorCode.COPY_INSTALL_SUCCESS, 232, 96, 210, 231, r.CTRL_INDEX, TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM, TbsListener.ErrorCode.DECOUPLE_TPATCH_FAIL, 181, TbsListener.ErrorCode.TPATCH_BACKUP_NOT_VALID, 59, 52, 172, 25, 49, 232, 211, 189, 64, 54, 108, 153, 132, 63, 96, 103, 82, 186}};
    private static final int[] cdK = new int[256];
    private static final int[] cdL = new int[255];

    static {
        int i2 = 1;
        int i3 = 0;
        while (i3 < 255) {
            cdL[i3] = i2;
            cdK[i2] = i3;
            int i4 = i2 << 1;
            if (i4 >= 256) {
                i4 ^= 301;
            }
            i3++;
            i2 = i4;
        }
    }

    public static String a(String str, k kVar) {
        AppMethodBeat.i(12341);
        if (str.length() != kVar.cdP) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The number of codewords does not match the selected symbol");
            AppMethodBeat.o(12341);
            throw illegalArgumentException;
        }
        StringBuilder sb = new StringBuilder(kVar.cdP + kVar.cdQ);
        sb.append(str);
        int Ik = kVar.Ik();
        if (Ik == 1) {
            sb.append(c(str, kVar.cdQ));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[Ik];
            int[] iArr2 = new int[Ik];
            int[] iArr3 = new int[Ik];
            for (int i2 = 0; i2 < Ik; i2++) {
                iArr[i2] = kVar.hh(i2 + 1);
                iArr2[i2] = kVar.cdV;
                iArr3[i2] = 0;
                if (i2 > 0) {
                    iArr3[i2] = iArr3[i2 - 1] + iArr[i2];
                }
            }
            for (int i3 = 0; i3 < Ik; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < kVar.cdP; i4 += Ik) {
                    sb2.append(str.charAt(i4));
                }
                String c2 = c(sb2.toString(), iArr2[i3]);
                int i5 = i3;
                int i6 = 0;
                while (i5 < iArr2[i3] * Ik) {
                    sb.setCharAt(kVar.cdP + i5, c2.charAt(i6));
                    i5 += Ik;
                    i6++;
                }
            }
        }
        String sb3 = sb.toString();
        AppMethodBeat.o(12341);
        return sb3;
    }

    private static String c(CharSequence charSequence, int i2) {
        AppMethodBeat.i(12342);
        String a2 = a(charSequence, charSequence.length(), i2);
        AppMethodBeat.o(12342);
        return a2;
    }

    private static String a(CharSequence charSequence, int i2, int i3) {
        AppMethodBeat.i(12343);
        int i4 = 0;
        while (true) {
            if (i4 >= cdI.length) {
                i4 = -1;
                break;
            } else if (cdI[i4] == i3) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 < 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i3)));
            AppMethodBeat.o(12343);
            throw illegalArgumentException;
        }
        int[] iArr = cdJ[i4];
        char[] cArr = new char[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            cArr[i5] = 0;
        }
        for (int i6 = 0; i6 < i2 + 0; i6++) {
            int charAt = charSequence.charAt(i6) ^ cArr[i3 - 1];
            for (int i7 = i3 - 1; i7 > 0; i7--) {
                if (charAt == 0 || iArr[i7] == 0) {
                    cArr[i7] = cArr[i7 - 1];
                } else {
                    cArr[i7] = (char) (cArr[i7 - 1] ^ cdL[(cdK[charAt] + cdK[iArr[i7]]) % 255]);
                }
            }
            if (charAt == 0 || iArr[0] == 0) {
                cArr[0] = 0;
            } else {
                cArr[0] = (char) cdL[(cdK[charAt] + cdK[iArr[0]]) % 255];
            }
        }
        char[] cArr2 = new char[i3];
        for (int i8 = 0; i8 < i3; i8++) {
            cArr2[i8] = cArr[(i3 - i8) - 1];
        }
        String valueOf = String.valueOf(cArr2);
        AppMethodBeat.o(12343);
        return valueOf;
    }
}
