package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.tav.core.AssetExtension;

public final class y extends IEvent {
    public a dCW;

    public static final class a {
        public int action;
        public String appId;
        public String dtX;
        public long duration;
        public String dvn;
        public int errCode;
        public String errMsg;
        public String state;
    }

    public y() {
        this((byte) 0);
    }

    private y(byte b2) {
        AppMethodBeat.i(136973);
        this.dCW = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(136973);
    }

    public static String jA(int i2) {
        if (i2 == 0 || i2 == 1) {
            return AssetExtension.SCENE_PLAY;
        }
        if (i2 == 2) {
            return "pause";
        }
        if (i2 == 3) {
            return "stop";
        }
        if (i2 == 4) {
            return "error";
        }
        if (i2 == 5) {
            return "ended";
        }
        if (i2 == 6) {
            return "seeked";
        }
        if (i2 == 7) {
            return "canplay";
        }
        if (i2 == 9) {
            return "waiting";
        }
        if (i2 == 10) {
            return "seeking";
        }
        if (i2 == 11) {
            return "real_play";
        }
        if (i2 == 12) {
            return "mix_play_ready";
        }
        if (i2 == 13) {
            return "preload_end";
        }
        return "";
    }
}
