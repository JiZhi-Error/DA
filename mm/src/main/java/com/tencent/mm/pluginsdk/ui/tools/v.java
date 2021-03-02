package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class v {
    public static j iE(Context context) {
        AppMethodBeat.i(116317);
        if (Util.nullAs(ae.gKE.gHE, "").equals("surface")) {
            Log.i("MicroMsg.VideoViewFactory", "match full type surface");
            VideoSurfaceView videoSurfaceView = new VideoSurfaceView(context);
            AppMethodBeat.o(116317);
            return videoSurfaceView;
        } else if (l.apy()) {
            Log.i("MicroMsg.VideoViewFactory", "IS MTK platform");
            VideoSightView videoSightView = new VideoSightView(context);
            AppMethodBeat.o(116317);
            return videoSightView;
        } else {
            Log.i("MicroMsg.VideoViewFactory", "default settings, use sightview");
            VideoSightView videoSightView2 = new VideoSightView(context);
            AppMethodBeat.o(116317);
            return videoSightView2;
        }
    }
}
