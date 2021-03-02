package com.tencent.mm.plugin.appbrand.luggage.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Pair;
import com.tencent.luggage.bridge.impl.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.f.a;
import com.tencent.mm.plugin.appbrand.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class j extends a implements b {
    private final AppBrandRuntime kEc;

    public j(AppBrandRuntime appBrandRuntime) {
        this.kEc = appBrandRuntime;
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public final String Lb() {
        return "WxFileImageReader";
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public final boolean match(String str) {
        AppMethodBeat.i(134903);
        if (str == null || !str.startsWith("wxfile://") || str.startsWith("wxfile://ad")) {
            AppMethodBeat.o(134903);
            return false;
        }
        AppMethodBeat.o(134903);
        return true;
    }

    private static Pair<String, String> acr(String str) {
        AppMethodBeat.i(219338);
        int lastIndexOf = str.lastIndexOf("?appId=");
        Pair<String, String> create = Pair.create(str.substring(lastIndexOf + 7), str.substring(0, lastIndexOf));
        AppMethodBeat.o(219338);
        return create;
    }

    @Override // com.tencent.luggage.bridge.impl.a.a
    public final void a(String str, a.c cVar) {
        AppMethodBeat.i(219339);
        if (cVar == null) {
            AppMethodBeat.o(219339);
            return;
        }
        q fileSystem = this.kEc.getFileSystem();
        if (fileSystem == null) {
            cVar.C(null);
            AppMethodBeat.o(219339);
            return;
        }
        cVar.C(fileSystem.Wc((String) acr(str).second));
        AppMethodBeat.o(219339);
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public final Bitmap b(String str, Rect rect, a.b bVar) {
        String str2;
        com.tencent.mm.plugin.appbrand.luggage.a.a aVar;
        AppMethodBeat.i(134904);
        if (!match(str)) {
            AppMethodBeat.o(134904);
            return null;
        }
        q fileSystem = this.kEc.getFileSystem();
        if (fileSystem == null) {
            AppMethodBeat.o(134904);
            return null;
        }
        o VY = fileSystem.VY((String) acr(str).second);
        if (VY == null || !VY.exists()) {
            AppMethodBeat.o(134904);
            return null;
        }
        String z = aa.z(VY.her());
        if (!z.startsWith("file://")) {
            str2 = "file://".concat(String.valueOf(z));
        } else {
            str2 = z;
        }
        if (rect != null) {
            aVar = new com.tencent.mm.plugin.appbrand.luggage.a.a(rect.left, rect.top, rect.width(), rect.height());
        } else {
            aVar = null;
        }
        Bitmap a2 = com.tencent.mm.modelappbrand.a.b.aXY().a(str2, aVar);
        AppMethodBeat.o(134904);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.f.b
    public final boolean a(f fVar, String str) {
        AppMethodBeat.i(134905);
        if (fVar == null || str == null || str.length() == 0) {
            AppMethodBeat.o(134905);
            return false;
        } else if (!str.startsWith("wxfile://") || str.startsWith("wxfile://ad")) {
            AppMethodBeat.o(134905);
            return false;
        } else {
            AppMethodBeat.o(134905);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.f.b
    public final String b(f fVar, String str) {
        AppMethodBeat.i(134906);
        if (!a(fVar, str)) {
            AppMethodBeat.o(134906);
            return str;
        }
        String str2 = str + "?appId=" + fVar.getAppId();
        AppMethodBeat.o(134906);
        return str2;
    }
}
