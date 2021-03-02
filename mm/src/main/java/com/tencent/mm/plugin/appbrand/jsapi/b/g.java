package com.tencent.mm.plugin.appbrand.jsapi.b;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.canvas.e;
import com.tencent.mm.plugin.appbrand.canvas.widget.AppBrandDrawableView;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class g extends b {
    public static final int CTRL_INDEX = 67;
    public static final String NAME = "insertCanvas";

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final View a(h hVar, JSONObject jSONObject) {
        AppMethodBeat.i(145539);
        Context context = hVar.getContext();
        final AppBrandDrawableView appBrandDrawableView = new AppBrandDrawableView(context);
        appBrandDrawableView.getDrawContext().kZr = (e) hVar.M(e.class);
        appBrandDrawableView.getDrawContext().czm = hVar;
        appBrandDrawableView.setContentDescription(context.getString(R.string.hj));
        hVar.a(new i.b() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.b.g.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.b
            public final void onBackground() {
                AppMethodBeat.i(161176);
                AppBrandDrawableView appBrandDrawableView = appBrandDrawableView;
                Log.v("MicroMsg.MCanvasView", "onPause :%s", Integer.valueOf(appBrandDrawableView.hashCode()));
                com.tencent.mm.plugin.appbrand.canvas.b bVar = appBrandDrawableView.laI;
                bVar.kYV = 0;
                bVar.kYS.U(bVar.kYT);
                appBrandDrawableView.bzx();
                AppMethodBeat.o(161176);
            }
        });
        hVar.a(new i.d() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.b.g.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.appbrand.jsapi.i.d
            public final void onForeground() {
                AppMethodBeat.i(161177);
                appBrandDrawableView.onResume();
                AppMethodBeat.o(161177);
            }
        });
        CoverViewContainer coverViewContainer = new CoverViewContainer(context, appBrandDrawableView);
        AppMethodBeat.o(145539);
        return coverViewContainer;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.e
    public final int H(JSONObject jSONObject) {
        AppMethodBeat.i(145540);
        int i2 = jSONObject.getInt("canvasId");
        AppMethodBeat.o(145540);
        return i2;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final boolean bEW() {
        return true;
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.base.b
    public final boolean bEX() {
        return true;
    }
}
