package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.ui.contact.SelectContactUI;
import com.tencent.mm.ui.contact.u;

public final class f extends b {
    String PdV = null;
    String QhV = null;

    public f(Context context, String str, String str2) {
        super(context);
        AppMethodBeat.i(38778);
        this.PdV = str;
        this.QhV = str2;
        if (this.view != null) {
            this.view.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.conversation.a.f.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(38777);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Intent intent = new Intent((Context) f.this.Kgr.get(), SelectContactUI.class);
                    intent.putExtra("list_attr", u.ll(u.PWR, 256));
                    intent.putExtra("list_type", 10);
                    intent.putExtra("received_card_name", f.this.PdV);
                    intent.putExtra("recommend_friends", true);
                    intent.putExtra("titile", ((Context) f.this.Kgr.get()).getString(R.string.g4));
                    Context context = (Context) f.this.Kgr.get();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    a.a(context, bl.axQ(), "com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    a.a(context, "com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    bg.aVF().aTm().KY(f.this.PdV);
                    bg.aVF().aTm().KY(f.this.QhV);
                    h.INSTANCE.a(11003, f.this.PdV, 2, 0);
                    a.a(this, "com/tencent/mm/ui/conversation/banner/ChattingRecommendBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(38777);
                }
            });
            ((ImageView) this.view.findViewById(R.id.au_)).setImageBitmap(c.a(this.PdV, true, -1, null));
        }
        AppMethodBeat.o(38778);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        return R.layout.tz;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
    }
}
