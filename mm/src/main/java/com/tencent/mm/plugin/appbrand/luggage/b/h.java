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
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class h extends a implements b {
    private final AppBrandRuntime kEc;

    h(AppBrandRuntime appBrandRuntime) {
        this.kEc = appBrandRuntime;
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public final String Lb() {
        return "WxBlobImageReader";
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public final boolean match(String str) {
        AppMethodBeat.i(219331);
        if (str == null || !str.startsWith("wxblob://")) {
            AppMethodBeat.o(219331);
            return false;
        }
        AppMethodBeat.o(219331);
        return true;
    }

    private static Pair<String, String> acr(String str) {
        AppMethodBeat.i(219332);
        if (Util.isNullOrNil(str)) {
            Pair<String, String> create = Pair.create(null, null);
            AppMethodBeat.o(219332);
            return create;
        }
        int lastIndexOf = str.lastIndexOf("wxblob://");
        if (lastIndexOf < 0) {
            Pair<String, String> create2 = Pair.create(null, null);
            AppMethodBeat.o(219332);
            return create2;
        }
        Pair<String, String> create3 = Pair.create(str.substring(0, lastIndexOf), str.substring(lastIndexOf));
        AppMethodBeat.o(219332);
        return create3;
    }

    @Override // com.tencent.luggage.bridge.impl.a.a
    public final void a(String str, a.c cVar) {
        AppMethodBeat.i(219333);
        if (cVar == null) {
            AppMethodBeat.o(219333);
            return;
        }
        q fileSystem = this.kEc.getFileSystem();
        if (fileSystem == null) {
            cVar.C(null);
            AppMethodBeat.o(219333);
            return;
        }
        cVar.C(fileSystem.Wc((String) acr(str).second));
        AppMethodBeat.o(219333);
    }

    @Override // com.tencent.mm.plugin.appbrand.f.a.AbstractC0580a
    public final Bitmap b(String str, Rect rect, a.b bVar) {
        String str2;
        com.tencent.mm.plugin.appbrand.luggage.a.a aVar;
        AppMethodBeat.i(219334);
        if (!match(str)) {
            AppMethodBeat.o(219334);
            return null;
        }
        q fileSystem = this.kEc.getFileSystem();
        if (fileSystem == null) {
            AppMethodBeat.o(219334);
            return null;
        }
        o VV = fileSystem.VV((String) acr(str).second);
        if (VV == null || !VV.exists()) {
            AppMethodBeat.o(219334);
            return null;
        }
        String z = aa.z(VV.her());
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
        AppMethodBeat.o(219334);
        return a2;
    }

    @Override // com.tencent.mm.plugin.appbrand.f.b
    public final boolean a(f fVar, String str) {
        AppMethodBeat.i(219335);
        if (fVar == null || str == null || str.length() == 0) {
            AppMethodBeat.o(219335);
            return false;
        } else if (str.startsWith("wxblob://") || Util.nullAsNil((String) acr(str).second).startsWith("wxblob://")) {
            AppMethodBeat.o(219335);
            return true;
        } else {
            AppMethodBeat.o(219335);
            return false;
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.f.b
    public final String b(f fVar, String str) {
        AppMethodBeat.i(219336);
        if (!a(fVar, str)) {
            AppMethodBeat.o(219336);
            return str;
        }
        String nullAsNil = Util.nullAsNil((String) acr(str).second);
        AppMethodBeat.o(219336);
        return nullAsNil;
    }
}
