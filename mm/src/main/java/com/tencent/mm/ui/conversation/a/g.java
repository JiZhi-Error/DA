package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.e;

public final class g extends b {
    String PdV = null;
    boolean Pdm = false;
    String QhV = null;

    public g(Context context, String str, String str2, boolean z) {
        super(context);
        AppMethodBeat.i(38781);
        this.PdV = str;
        this.QhV = str2;
        this.Pdm = z;
        if (this.view != null) {
            TextView textView = (TextView) this.view.findViewById(R.id.ay4);
            String aU = bg.aVF().aTn().aU(this.PdV, "wording");
            String aU2 = bg.aVF().aTn().aU(this.QhV, "wording");
            if (!Util.isNullOrNil(aU)) {
                textView.setText(aU);
            } else if (!Util.isNullOrNil(aU2)) {
                textView.setText(aU2);
            }
            String aU3 = bg.aVF().aTn().aU(this.PdV, "linkname");
            final String aU4 = bg.aVF().aTn().aU(this.PdV, "linksrc");
            TextView textView2 = (TextView) this.view.findViewById(R.id.ay3);
            if (!Util.isNullOrNil(aU3)) {
                textView2.setText(aU3);
            }
            textView2.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.conversation.a.g.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(38779);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent();
                    intent.putExtra("k_username", g.this.PdV);
                    int i2 = 39;
                    if (g.this.Pdm) {
                        i2 = 36;
                    }
                    intent.putExtra("showShare", false);
                    if (!Util.isNullOrNil(aU4)) {
                        intent.putExtra("rawUrl", aU4);
                    } else {
                        intent.putExtra("rawUrl", String.format(e.C2115e.OyU, Integer.valueOf(i2)));
                    }
                    if (g.this.Kgr.get() != null) {
                        c.b((Context) g.this.Kgr.get(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                    bg.aVF().aTn().KY(g.this.PdV);
                    bg.aVF().aTn().KY(g.this.QhV);
                    a.a(this, "com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(38779);
                }
            });
            ((ImageView) this.view.findViewById(R.id.ay2)).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.conversation.a.g.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(38780);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    bg.aVF().aTn().KY(g.this.PdV);
                    bg.aVF().aTn().KY(g.this.QhV);
                    a.a(this, "com/tencent/mm/ui/conversation/banner/ChattingSecurityBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(38780);
                }
            });
        }
        AppMethodBeat.o(38781);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.u0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
    }
}
