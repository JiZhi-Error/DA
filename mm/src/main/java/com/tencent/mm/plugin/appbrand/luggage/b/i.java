package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.luggage.a.e;
import com.tencent.luggage.bridge.impl.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ad.k;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class i extends a implements b {
    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public final String Lb() {
        return "WxFileAdImageReader";
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public final boolean match(String str) {
        AppMethodBeat.i(162080);
        if (str == null || !str.startsWith("wxfile://ad")) {
            AppMethodBeat.o(162080);
            return false;
        }
        AppMethodBeat.o(162080);
        return true;
    }

    @Override // com.tencent.luggage.bridge.impl.a.a
    public final void a(String str, a.c cVar) {
        AppMethodBeat.i(219337);
        if (!match(str)) {
            Log.w("MicroMsg.WxFileAdImageReader", "openRead, not match, url:%s", str);
            AppMethodBeat.o(219337);
        } else if (cVar == null) {
            AppMethodBeat.o(219337);
        } else {
            k kVar = (k) e.M(k.class);
            if (kVar == null) {
                Log.i("MicroMsg.WxFileAdImageReader", "openRead, no ad service");
                AppMethodBeat.o(219337);
                return;
            }
            q btJ = kVar.btJ();
            if (btJ == null) {
                Log.i("MicroMsg.WxFileAdImageReader", "openRead, no ad file system");
                AppMethodBeat.o(219337);
                return;
            }
            cVar.C(btJ.Wc(str));
            AppMethodBeat.o(219337);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public final Bitmap b(String str, Rect rect, a.b bVar) {
        com.tencent.mm.plugin.appbrand.luggage.a.a aVar = null;
        AppMethodBeat.i(162081);
        if (!match(str)) {
            Log.w("MicroMsg.WxFileAdImageReader", "read, not match, url:%s", str);
            AppMethodBeat.o(162081);
            return null;
        }
        k kVar = (k) e.M(k.class);
        if (kVar == null) {
            Log.i("MicroMsg.WxFileAdImageReader", "read, no ad service");
            AppMethodBeat.o(162081);
            return null;
        }
        q btJ = kVar.btJ();
        if (btJ == null) {
            Log.i("MicroMsg.WxFileAdImageReader", "read, no ad file system");
            AppMethodBeat.o(162081);
            return null;
        }
        o VY = btJ.VY(str);
        if (VY == null || !VY.exists()) {
            Log.w("MicroMsg.WxFileAdImageReader", "read, file not exist, url:%s", str);
            AppMethodBeat.o(162081);
            return null;
        }
        String z = aa.z(VY.her());
        if (!z.startsWith("file://")) {
            z = "file://".concat(String.valueOf(z));
        }
        Log.w("MicroMsg.WxFileAdImageReader", "read, url:%s, path:%s", str, z);
        if (rect != null) {
            aVar = new com.tencent.mm.plugin.appbrand.luggage.a.a(rect.left, rect.top, rect.width(), rect.height());
        }
        Bitmap a2 = com.tencent.mm.modelappbrand.a.b.aXY().a(z, aVar);
        AppMethodBeat.o(162081);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.f.b
    public final boolean a(f fVar, String str) {
        AppMethodBeat.i(162082);
        if (fVar == null || str == null || str.length() == 0) {
            AppMethodBeat.o(162082);
            return false;
        }
        boolean startsWith = str.startsWith("wxfile://ad");
        AppMethodBeat.o(162082);
        return startsWith;
    }

    @Override // com.tencent.mm.plugin.appbrand.f.b
    public final String b(f fVar, String str) {
        AppMethodBeat.i(162083);
        if (!a(fVar, str)) {
            AppMethodBeat.o(162083);
        } else {
            AppMethodBeat.o(162083);
        }
        return str;
    }
}
