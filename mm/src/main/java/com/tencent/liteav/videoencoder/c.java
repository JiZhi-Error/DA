package com.tencent.liteav.videoencoder;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPDecoderType;

public class c {
    public static boolean a(int i2, int i3, int i4) {
        AppMethodBeat.i(259840);
        if (2 == com.tencent.liteav.basic.d.c.a().d()) {
            if (!com.tencent.liteav.basic.d.c.a().m()) {
                TXCLog.w("TXCVideoEncoderUtils", "local not support hevc encoder");
            } else if (!com.tencent.liteav.basic.d.c.a().j()) {
                TXCLog.w("TXCVideoEncoderUtils", "not support hevc encoder: in blacklist!");
            } else if (b(i2, i3, i4)) {
                TXCLog.i("TXCVideoEncoderUtils", "config hevc switch on!");
                AppMethodBeat.o(259840);
                return true;
            }
        }
        AppMethodBeat.o(259840);
        return false;
    }

    private static boolean b(int i2, int i3, int i4) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        AppMethodBeat.i(259841);
        if (Build.VERSION.SDK_INT >= 21) {
            MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
            for (MediaCodecInfo mediaCodecInfo : codecInfos) {
                if (mediaCodecInfo.isEncoder()) {
                    String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            continue;
                            break;
                        }
                        String str = supportedTypes[i5];
                        if (str.contains(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                            if (capabilitiesForType != null && (videoCapabilities = capabilitiesForType.getVideoCapabilities()) != null && videoCapabilities.areSizeAndRateSupported(i2, i3, (double) i4) && videoCapabilities.areSizeAndRateSupported(i3, i2, (double) i4)) {
                                TXCLog.i("TXCVideoEncoderUtils", "got hevc encoder:%s, type:%s", mediaCodecInfo.getName(), str);
                                AppMethodBeat.o(259841);
                                return true;
                            }
                        } else {
                            i5++;
                        }
                    }
                }
            }
        }
        TXCLog.w("TXCVideoEncoderUtils", "not got hevc encoder");
        AppMethodBeat.o(259841);
        return false;
    }
}
