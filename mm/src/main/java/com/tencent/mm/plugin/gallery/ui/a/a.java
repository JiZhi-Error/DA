package com.tencent.mm.plugin.gallery.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiResumeDownloadTaskForNative;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public final class a extends com.tencent.mm.ui.tools.b.a {
    private String cJp;
    public int mSize = 104857600;
    private AbstractC1391a xsy;

    /* renamed from: com.tencent.mm.plugin.gallery.ui.a.a$a  reason: collision with other inner class name */
    public interface AbstractC1391a {
    }

    private a(String str) {
        this.cJp = str;
    }

    public static a azf(String str) {
        AppMethodBeat.i(111734);
        a aVar = new a(str);
        AppMethodBeat.o(111734);
        return aVar;
    }

    public final int dSv() {
        AppMethodBeat.i(257761);
        int bCj = bCj();
        AppMethodBeat.o(257761);
        return bCj;
    }

    @Override // com.tencent.mm.ui.tools.b.a
    public final int bCj() {
        int i2;
        double d2;
        int i3 = 10485760;
        AppMethodBeat.i(111735);
        if (Util.isNullOrNil(this.cJp)) {
            Log.w("MicroMsg.VideoBoundaryCheck", "dz[check video but path is null or nil]");
        }
        boolean is2G = NetStatusUtil.is2G(MMApplicationContext.getContext());
        boolean Sx = c.Sx(this.cJp);
        if (Sx) {
            String str = this.cJp;
            if (!is2G) {
                i3 = this.mSize;
            }
            if (is2G) {
                d2 = 60000.0d;
            } else {
                d2 = (double) this.mSize;
            }
            i2 = SightVideoJNI.shouldRemuxingVFS(str, JsApiResumeDownloadTaskForNative.CTRL_INDEX, 500, i3, d2, 1000000);
        } else {
            if (((int) s.boW(this.cJp)) > (is2G ? 10485760 : 26214400)) {
                i2 = -1;
            } else {
                i2 = 1;
            }
        }
        Log.i("MicroMsg.VideoBoundaryCheck", "check should remuxing, ret %d, isMp4 %b", Integer.valueOf(i2), Boolean.valueOf(Sx));
        switch (i2) {
            case -6:
            case -5:
            case -4:
            case -3:
            case -2:
                AppMethodBeat.o(111735);
                return 1;
            case -1:
                AppMethodBeat.o(111735);
                return 2;
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                AppMethodBeat.o(111735);
                return 0;
            default:
                Log.e("MicroMsg.VideoBoundaryCheck", "unknown check type %d", Integer.valueOf(i2));
                AppMethodBeat.o(111735);
                return 1;
        }
    }

    @Override // com.tencent.mm.ui.tools.b.a
    public final void dSw() {
        AppMethodBeat.i(111736);
        if (this.xsy == null) {
            Log.w("MicroMsg.VideoBoundaryCheck", "dz[callback is null]");
            AppMethodBeat.o(111736);
            return;
        }
        bCj();
        AppMethodBeat.o(111736);
    }
}
