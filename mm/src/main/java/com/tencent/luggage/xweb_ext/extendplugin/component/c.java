package com.tencent.luggage.xweb_ext.extendplugin.component;

import android.view.View;
import com.tencent.luggage.xweb_ext.extendplugin.a.a;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.jsapi.s.b;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class c<OriginVideoContainer extends g, PipVideoContainer extends View> implements p<OriginVideoContainer, PipVideoContainer> {
    private final a cDK;

    protected c(a aVar) {
        this.cDK = aVar;
    }

    public final b dQ(String str) {
        final b.a aaE;
        final Boolean bool;
        try {
            i iVar = new i(str);
            String optString = iVar.optString("pictureInPictureMode", null);
            if (optString == null) {
                aaE = null;
            } else {
                aaE = b.a.aaE(optString);
            }
            if (iVar.has("pictureInPictureShowProgress")) {
                bool = Boolean.valueOf(iVar.optBoolean("pictureInPictureShowProgress", false));
            } else {
                bool = null;
            }
            return new b() {
                /* class com.tencent.luggage.xweb_ext.extendplugin.component.c.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.s.b
                public final b.a Px() {
                    return aaE;
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.s.b
                public final Boolean Py() {
                    return bool;
                }
            };
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.AppBrand.AbsXWebPipInfoProvider#" + this.cDK.getId(), e2, "getPipExtra fail", new Object[0]);
            return null;
        }
    }
}
