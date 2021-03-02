package com.tencent.liteav.videodecoder;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import com.tencent.liteav.basic.a;
import com.tencent.liteav.basic.d.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.TPDecoderType;

public class e {
    public static boolean a(int i2, int i3, int i4) {
        AppMethodBeat.i(259944);
        if (a.a()) {
            AppMethodBeat.o(259944);
            return true;
        }
        boolean b2 = b(i2, i3, i4);
        AppMethodBeat.o(259944);
        return b2;
    }

    public static boolean b(int i2, int i3, int i4) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        AppMethodBeat.i(259945);
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 21) {
            MediaCodecList mediaCodecList = new MediaCodecList(1);
            MediaCodecInfo[] codecInfos = mediaCodecList.getCodecInfos();
            for (MediaCodecInfo mediaCodecInfo : codecInfos) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                if (!mediaCodecInfo.isEncoder()) {
                    int length = supportedTypes.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        String str = supportedTypes[i5];
                        if (str.contains(TPDecoderType.TP_CODEC_MIMETYPE_HEVC)) {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                            if (capabilitiesForType != null && (videoCapabilities = capabilitiesForType.getVideoCapabilities()) != null) {
                                boolean areSizeAndRateSupported = videoCapabilities.areSizeAndRateSupported(i2, i3, (double) i4);
                                boolean areSizeAndRateSupported2 = videoCapabilities.areSizeAndRateSupported(i3, i2, (double) i4);
                                TXCLog.i("TXCVideoDecoderUtils", "got hevc decoder:%s, type:%s, supportPort= %b,supportLand=%b", mediaCodecInfo.getName(), str, Boolean.valueOf(areSizeAndRateSupported), Boolean.valueOf(areSizeAndRateSupported2));
                                if (!areSizeAndRateSupported2 || !areSizeAndRateSupported) {
                                    MediaFormat mediaFormat = null;
                                    if (areSizeAndRateSupported2 || areSizeAndRateSupported) {
                                        if (!areSizeAndRateSupported2) {
                                            mediaFormat = MediaFormat.createVideoFormat(TPDecoderType.TP_CODEC_MIMETYPE_HEVC, i3, i2);
                                        } else if (!areSizeAndRateSupported) {
                                            mediaFormat = MediaFormat.createVideoFormat(TPDecoderType.TP_CODEC_MIMETYPE_HEVC, i2, i3);
                                        }
                                    }
                                    if (mediaFormat != null) {
                                        String findDecoderForFormat = mediaCodecList.findDecoderForFormat(mediaFormat);
                                        TXCLog.i("TXCVideoDecoderUtils", "findDecoderForFormat hevc decodername:%s", findDecoderForFormat);
                                        if (findDecoderForFormat != null) {
                                            z = true;
                                        }
                                    }
                                } else {
                                    z = true;
                                }
                            }
                        } else {
                            i5++;
                        }
                    }
                }
            }
        }
        boolean z2 = z && c.a().k();
        TXCLog.i("TXCVideoDecoderUtils", "config hevc decoder switch : " + z2 + " ,isSupport=" + z);
        AppMethodBeat.o(259945);
        return z2;
    }
}
