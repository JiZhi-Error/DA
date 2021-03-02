package com.tencent.mm.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.chatting.e.a;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.viewitems.e;

public final class ac implements View.OnClickListener {
    a OIz;

    public ac(a aVar) {
        this.OIz = aVar;
    }

    public final void onClick(View view) {
        AppMethodBeat.i(33517);
        b bVar = new b();
        bVar.bm(view);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/MediaIconClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        if (view.getTag() instanceof e.g) {
            s.gA(view);
            this.OIz.cmy();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/MediaIconClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33517);
    }
}
