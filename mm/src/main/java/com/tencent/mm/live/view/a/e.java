package com.tencent.mm.live.view.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16})
final class e implements View.OnClickListener {
    private final /* synthetic */ b hXF;

    e(b bVar) {
        this.hXF = bVar;
    }

    public final /* synthetic */ void onClick(View view) {
        AppMethodBeat.i(208671);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(view);
        a.b("com/tencent/mm/live/view/adapter/LiveMemberAdapter$sam$android_view_View_OnClickListener$0", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        p.g(this.hXF.invoke(view), "invoke(...)");
        a.a(this, "com/tencent/mm/live/view/adapter/LiveMemberAdapter$sam$android_view_View_OnClickListener$0", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(208671);
    }
}
