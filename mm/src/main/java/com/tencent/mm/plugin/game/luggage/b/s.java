package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import org.json.JSONObject;

public class s extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "insertWebView";
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final int dTs() {
        return 0;
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void a(Context context, String str, br.a aVar) {
    }

    @Override // com.tencent.mm.plugin.webview.luggage.jsapi.br
    public final void b(b<i>.a aVar) {
        AppMethodBeat.i(83074);
        JSONObject jSONObject = aVar.ctb.csi;
        String optString = jSONObject.optString("url");
        String optString2 = jSONObject.optString("viewId");
        int fromDPToPix = at.fromDPToPix(MMApplicationContext.getContext(), jSONObject.optInt("left"));
        int fromDPToPix2 = at.fromDPToPix(MMApplicationContext.getContext(), jSONObject.optInt("top"));
        int fromDPToPix3 = at.fromDPToPix(MMApplicationContext.getContext(), jSONObject.optInt("width"));
        int fromDPToPix4 = at.fromDPToPix(MMApplicationContext.getContext(), jSONObject.optInt("height"));
        CONTEXT context = aVar.cta;
        context.aC(new Runnable(optString, optString2, fromDPToPix3, fromDPToPix4, fromDPToPix, fromDPToPix2) {
            /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass3 */
            final /* synthetic */ String lof;
            final /* synthetic */ int val$height;
            final /* synthetic */ String val$url;
            final /* synthetic */ int val$width;
            final /* synthetic */ int xze;
            final /* synthetic */ int xzf;

            {
                this.val$url = r2;
                this.lof = r3;
                this.val$width = r4;
                this.val$height = r5;
                this.xze = r6;
                this.xzf = r7;
            }

            public final void run() {
                AppMethodBeat.i(186958);
                i.this.gbD();
                i.this.dTO();
                Bundle bundle = new Bundle();
                bundle.putAll(i.this.mParams);
                bundle.putString("rawUrl", this.val$url);
                b bVar = new b(i.this.ctg, bundle);
                i.this.xyO.put(this.lof, bVar);
                i.this.ITn.addView(bVar.mContentView, new FrameLayout.LayoutParams(this.val$width, this.val$height));
                bVar.mContentView.setX(((float) this.xze) + i.this.ITn.getX());
                bVar.mContentView.setY(((float) this.xzf) + i.this.ITn.getY());
                bVar.ega();
                bVar.gbD();
                bVar.g(this.val$url, bundle);
                AppMethodBeat.o(186958);
            }
        });
        aVar.c("", null);
        AppMethodBeat.o(83074);
    }
}
