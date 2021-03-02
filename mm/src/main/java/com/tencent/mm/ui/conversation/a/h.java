package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.ui.FacebookFriendUI;
import com.tencent.mm.pluginsdk.ui.b.b;

public final class h extends b {
    public h(Context context) {
        super(context);
        AppMethodBeat.i(38783);
        if (this.view != null) {
            this.view.findViewById(R.id.ca9).setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.conversation.a.h.AnonymousClass1 */

                public final void onClick(View view) {
                    AppMethodBeat.i(38782);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/ui/conversation/banner/FackbookTipsBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    bg.aVF();
                    c.azQ().set(65833, (Object) 0);
                    Context context = (Context) h.this.Kgr.get();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent((Context) h.this.Kgr.get(), FacebookFriendUI.class));
                    a.a(context, bl.axQ(), "com/tencent/mm/ui/conversation/banner/FackbookTipsBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    a.a(context, "com/tencent/mm/ui/conversation/banner/FackbookTipsBanner$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    h.this.view.setVisibility(8);
                    a.a(this, "com/tencent/mm/ui/conversation/banner/FackbookTipsBanner$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(38782);
                }
            });
        }
        AppMethodBeat.o(38783);
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final int getLayoutId() {
        AppMethodBeat.i(38784);
        com.tencent.mm.aw.b.bdF();
        AppMethodBeat.o(38784);
        return -1;
    }

    @Override // com.tencent.mm.pluginsdk.ui.b.b
    public final void destroy() {
    }
}
