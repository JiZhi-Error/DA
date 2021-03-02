package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class l extends j {
    private View qOJ;

    public l(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(30873);
        this.qOs.setVisibility(8);
        this.dKU.setVisibility(8);
        this.kmg.setVisibility(8);
        this.qOs.setOnClickListener(null);
        this.qOx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wenote.ui.nativenote.a.l.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(30872);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteSplitItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                l.this.JKX.cDF();
                l.this.JKX.requestFocus();
                a.a(this, "com/tencent/mm/plugin/wenote/ui/nativenote/itemholder/NoteSplitItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(30872);
            }
        });
        AppMethodBeat.o(30873);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a, com.tencent.mm.plugin.wenote.ui.nativenote.a.j
    public final void a(c cVar, int i2, int i3) {
        AppMethodBeat.i(30874);
        super.a(cVar, i2, i3);
        if (cVar.getType() != -1) {
            AppMethodBeat.o(30874);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.qOy.getLayoutParams();
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        this.qOy.setLayoutParams(layoutParams);
        this.qOx.setVisibility(0);
        this.qOJ = this.aus.findViewById(R.id.g1t);
        AppMethodBeat.o(30874);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final int cCY() {
        return -1;
    }
}
