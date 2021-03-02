package com.tencent.mm.plugin.finder.profile.uic;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16})
public final class c implements View.OnClickListener {
    private final /* synthetic */ b hXF;

    c(b bVar) {
        this.hXF = bVar;
    }

    public final /* synthetic */ void onClick(View view) {
        AppMethodBeat.i(250335);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$sam$android_view_View_OnClickListener$0", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        p.g(this.hXF.invoke(view), "invoke(...)");
        a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$sam$android_view_View_OnClickListener$0", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(250335);
    }
}
