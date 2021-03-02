package com.tencent.luggage.xweb_ext.extendplugin.component.video.a.a;

import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMFileSlotManager;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class a implements f {
    MMFileSlotManager cJX = new MMFileSlotManager("bizplaylist", 86400);

    public a() {
        AppMethodBeat.i(177186);
        AppMethodBeat.o(177186);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.video.b.c.f
    public final o dU(String str) {
        o oVar;
        AppMethodBeat.i(177187);
        if (!Util.isNullOrNil(str)) {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            if (!Util.isNullOrNil(lastPathSegment) && (oVar = (o) this.cJX.findSlot(lastPathSegment)) != null) {
                Log.i("PlaylistFileInterceptor", "intercept success, contentId:%s, url:%s", lastPathSegment, str);
                o oVar2 = new o(String.format("%s/%s", aa.z(oVar.mUri), lastPathSegment));
                AppMethodBeat.o(177187);
                return oVar2;
            }
        }
        AppMethodBeat.o(177187);
        return null;
    }
}
