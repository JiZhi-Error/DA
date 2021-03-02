package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.k;
import com.tencent.mm.storage.ar;

public final class l {
    private static l zwj = new l();
    public SightParams zwk;

    static {
        AppMethodBeat.i(89505);
        AppMethodBeat.o(89505);
    }

    public static l ekc() {
        return zwj;
    }

    public final SightParams ekd() {
        return this.zwk;
    }

    public static d q(VideoTransPara videoTransPara) {
        AppMethodBeat.i(89503);
        d dVar = null;
        switch (k.zuy.gIP) {
            case 1:
                dVar = new m(videoTransPara);
                break;
            case 2:
                dVar = new o(videoTransPara);
                break;
        }
        AppMethodBeat.o(89503);
        return dVar;
    }

    public static int eke() {
        return k.zuy.videoBitrate;
    }

    public static int ekf() {
        return k.zuy.ilT;
    }

    public static boolean KB() {
        AppMethodBeat.i(89504);
        if (CaptureMMProxy.getInstance().getInt(ar.a.USERINFO_LOCAL_SIGHT_DEBUGINFO_INT_SYNC, 0) == 1) {
            AppMethodBeat.o(89504);
            return true;
        }
        AppMethodBeat.o(89504);
        return false;
    }

    public static String ekg() {
        switch (k.zuy.gIP) {
            case 1:
                return "RECORDER_TYPE_FFMPEG";
            case 2:
                return "ENCODER_MEDIACODEC";
            default:
                return "";
        }
    }
}
