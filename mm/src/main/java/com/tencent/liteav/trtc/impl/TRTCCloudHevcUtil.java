package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.videodecoder.e;
import com.tencent.liteav.videoencoder.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TRTCCloudHevcUtil {
    private static String TAG = "TRTCCloudHevcUtil";
    private static boolean mLifeCycleEnableHevcDecoder = true;
    private static boolean mLifeCycleEnableHighQualityEncode = true;

    public static int getEnterRoomCodecSupportValue() {
        AppMethodBeat.i(259877);
        int hevcDecoderValue = ((c.a(1920, 1080, 20) ? 1 : 0) << 2) | getHevcDecoderValue() | 3;
        TXCLog.i(TAG, "codecability codecSupport : ".concat(String.valueOf(hevcDecoderValue)));
        AppMethodBeat.o(259877);
        return hevcDecoderValue;
    }

    public static int getHevcDecoderValue() {
        boolean z;
        int i2 = 1;
        AppMethodBeat.i(259878);
        if (!mLifeCycleEnableHevcDecoder || !e.a(1920, 1080, 20)) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            i2 = 0;
        }
        int i3 = i2 << 3;
        AppMethodBeat.o(259878);
        return i3;
    }

    public static boolean isLifeCycleEnableHevcEncode() {
        return mLifeCycleEnableHighQualityEncode;
    }

    public static boolean isLifeCycleEnableHevcDecode() {
        return mLifeCycleEnableHevcDecoder;
    }

    public static void setLifeCycleEnableHevcEncode(boolean z) {
        mLifeCycleEnableHighQualityEncode = z;
    }

    public static void setLifeCycleEnableHevcDecode(boolean z) {
        mLifeCycleEnableHevcDecoder = z;
    }
}
