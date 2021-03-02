package com.tencent.mm.plugin.game.luggage.b;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.luggage.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.luggage.g.i;
import com.tencent.mm.plugin.webview.luggage.jsapi.br;
import com.tencent.mm.plugin.webview.luggage.jsapi.bs;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.at;
import org.json.JSONObject;

public class ak extends bs<i> {
    @Override // com.tencent.luggage.d.b
    public final String name() {
        return "updateInsertedWebView";
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
        AppMethodBeat.i(83093);
        JSONObject jSONObject = aVar.ctb.csi;
        jSONObject.optString("url");
        String optString = jSONObject.optString("viewId");
        int fromDPToPix = at.fromDPToPix(MMApplicationContext.getContext(), jSONObject.optInt("left"));
        int fromDPToPix2 = at.fromDPToPix(MMApplicationContext.getContext(), jSONObject.optInt("top"));
        int fromDPToPix3 = at.fromDPToPix(MMApplicationContext.getContext(), jSONObject.optInt("width"));
        int fromDPToPix4 = at.fromDPToPix(MMApplicationContext.getContext(), jSONObject.optInt("height"));
        CONTEXT context = aVar.cta;
        context.aC(new Runnable(optString, fromDPToPix3, fromDPToPix4, fromDPToPix, fromDPToPix2) {
            /* class com.tencent.mm.plugin.game.luggage.g.i.AnonymousClass4 */
            final /* synthetic */ String lof;
            final /* synthetic */ int val$height;
            final /* synthetic */ int val$width;
            final /* synthetic */ int xze;
            final /* synthetic */ int xzf;

            {
                this.lof = r2;
                this.val$width = r3;
                this.val$height = r4;
                this.xze = r5;
                this.xzf = r6;
            }

            public final void run() {
                AppMethodBeat.i(186959);
                b bVar = (b) i.this.xyO.get(this.lof);
                if (bVar == null) {
                    AppMethodBeat.o(186959);
                    return;
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) bVar.mContentView.getLayoutParams();
                layoutParams.width = this.val$width;
                layoutParams.height = this.val$height;
                bVar.mContentView.setLayoutParams(layoutParams);
                bVar.mContentView.setX(((float) this.xze) + i.this.ITn.getX());
                bVar.mContentView.setY(((float) this.xzf) + i.this.ITn.getY());
                AppMethodBeat.o(186959);
            }
        });
        AppMethodBeat.o(83093);
    }
}
