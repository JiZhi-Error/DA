package com.tencent.mm.plugin.account.friend.ui;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.p;
import com.tencent.mm.plugin.account.friend.ui.g;

public final class c implements View.OnClickListener {
    private Context context;
    private a kgI;

    public interface a {
        void gm(boolean z);
    }

    public static class b {
        public String kgK;
        public int position;
    }

    public c(Context context2, a aVar) {
        this.context = context2;
        this.kgI = aVar;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(131231);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/friend/ui/InviteContactListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        b bVar2 = (b) view.getTag();
        String str = bVar2.kgK;
        final int i2 = bVar2.position;
        new g(this.context, new g.a() {
            /* class com.tencent.mm.plugin.account.friend.ui.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.account.friend.ui.g.a
            public final void i(boolean z, String str) {
                AppMethodBeat.i(131230);
                c.this.kgI.gm(z);
                AppMethodBeat.o(131230);
            }
        }).t(new int[]{p.fd(str)});
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/friend/ui/InviteContactListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(131231);
    }
}
