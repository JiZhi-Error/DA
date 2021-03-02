package com.tencent.mm.plugin.appbrand.launching.c;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.appbrand.api.WeAppOpenDeclarePromptBundle;
import com.tencent.mm.plugin.appbrand.launching.c.a;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;

public final class g implements s {
    private static final int[] mYs = {TXLiteAVCode.EVT_CAMERA_CLOSE, 1031, 1032};
    private static final int[] mYt = {1011, 1012, 1013, 1047, 1049, 1048, 1050, 1124, 1125, 1126};
    private final d mYu = new d();
    private final f mYv = new f();
    private final c mYw = new c();

    public g() {
        AppMethodBeat.i(47416);
        AppMethodBeat.o(47416);
    }

    @Override // com.tencent.mm.plugin.appbrand.service.s
    public final boolean n(String str, Bundle bundle) {
        b bVar;
        Uri uri;
        boolean z;
        AppMethodBeat.i(227133);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(227133);
            return false;
        }
        Log.i("MicroMsg.WeAppLinkOpener", "handle appLink = %s", str);
        b[] values = b.values();
        int length = values.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                bVar = null;
                break;
            }
            b bVar2 = values[i2];
            if (Util.isNullOrNil(str) || !str.startsWith(bVar2.prefix)) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                bVar = bVar2;
                break;
            }
            i2++;
        }
        if (bVar != null) {
            try {
                uri = Uri.parse(str);
            } catch (Exception e2) {
                Log.e("MicroMsg.WeAppLinkOpener", "handle nativeLink = %s, exp = %s", str, e2);
                uri = null;
            }
            if (uri == null) {
                AppMethodBeat.o(227133);
                return false;
            }
            String queryParameter = uri.getQueryParameter(ch.COL_USERNAME);
            String queryParameter2 = uri.getQueryParameter("path");
            if (Util.isNullOrNil(queryParameter) || !as.HF(queryParameter)) {
                AppMethodBeat.o(227133);
                return false;
            }
            com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
            gVar.username = queryParameter;
            gVar.version = -1;
            gVar.iOo = 0;
            gVar.kHw = queryParameter2;
            gVar.scene = bVar.scene;
            gVar.dCw = b.bOa();
            gVar.kHz = 0;
            gVar.kHA = b.bOb();
            WeAppOpenDeclarePromptBundle R = b.R(bundle);
            if (R != null) {
                gVar.kHJ = R;
            }
            ((r) com.tencent.mm.kernel.g.af(r.class)).a(null, gVar);
            AppMethodBeat.o(227133);
            return true;
        }
        AppMethodBeat.o(227133);
        return false;
    }

    @Override // com.tencent.mm.plugin.appbrand.service.s
    public final boolean b(Context context, String str, int i2, Bundle bundle, Bundle bundle2) {
        AppMethodBeat.i(227134);
        if (a.contains(mYs, i2)) {
            if (a.EnumC0736a.OK == this.mYu.a(context, str, i2, bundle, bundle2)) {
                AppMethodBeat.o(227134);
                return true;
            }
            AppMethodBeat.o(227134);
            return false;
        } else if (com.tencent.mm.compatible.loader.a.contains(mYt, i2)) {
            if (a.EnumC0736a.OK == this.mYv.a(context, str, i2, bundle, bundle2)) {
                AppMethodBeat.o(227134);
                return true;
            }
            AppMethodBeat.o(227134);
            return false;
        } else if (1064 != i2 && 1078 != i2) {
            Log.e("MicroMsg.WeAppLinkOpener", "handleScanCodeLink, unhandled case link[ %s ], scene[ %d ]", str, Integer.valueOf(i2));
            AppMethodBeat.o(227134);
            return false;
        } else if (a.EnumC0736a.OK == this.mYw.a(context, str, i2, bundle, bundle2)) {
            AppMethodBeat.o(227134);
            return true;
        } else {
            AppMethodBeat.o(227134);
            return false;
        }
    }
}
