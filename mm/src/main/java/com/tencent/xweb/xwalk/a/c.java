package com.tencent.xweb.xwalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.util.d;
import com.tencent.xweb.util.h;
import java.io.File;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class c extends g {
    @Override // com.tencent.xweb.xwalk.a.g
    public final String getPluginName() {
        return XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO;
    }

    @Override // com.tencent.xweb.xwalk.a.g
    public final String ca(int i2, boolean z) {
        AppMethodBeat.i(157176);
        String atd = atd(i2);
        if (atd == null || atd.isEmpty()) {
            AppMethodBeat.o(157176);
            return "";
        } else if (!z) {
            String str = atd + File.separator + "xweb_fullscreen_video.js";
            AppMethodBeat.o(157176);
            return str;
        } else {
            String str2 = atd + File.separator + "patch";
            AppMethodBeat.o(157176);
            return str2;
        }
    }

    @Override // com.tencent.xweb.xwalk.a.g
    public final boolean hvi() {
        return true;
    }

    @Override // com.tencent.xweb.xwalk.a.g
    public final int a(com.tencent.xweb.xwalk.updater.c cVar) {
        AppMethodBeat.i(219102);
        Log.i(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO, "performInstall version " + cVar.version);
        if (d.oi(cVar.path, cVar.SID)) {
            atc(cVar.version);
            Log.i(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO, "performInstall " + this.SHU + " success");
            AppMethodBeat.o(219102);
            return 0;
        }
        Log.e(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO, "performInstall failed, md5 not match");
        File file = new File(cVar.path);
        if (file.exists()) {
            file.delete();
        }
        h.dM(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO, false);
        AppMethodBeat.o(219102);
        return -1;
    }

    @Override // com.tencent.xweb.xwalk.a.g
    public final void hvj() {
        AppMethodBeat.i(157178);
        Log.i(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO, "checkVersionFiles, skip");
        AppMethodBeat.o(157178);
    }
}
