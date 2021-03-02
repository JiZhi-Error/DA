package com.tencent.mm.plugin.editor.adapter.a;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;

public final class e extends d {
    private View qOJ;

    public e(View view, j jVar) {
        super(view, jVar);
        AppMethodBeat.i(181653);
        this.qOs.setVisibility(8);
        this.dKU.setVisibility(8);
        this.kmg.setVisibility(8);
        this.qOs.setOnClickListener(null);
        this.qOx.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.editor.adapter.a.e.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(181652);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorSplitItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                e.this.qOr.cDF();
                e.this.qOr.requestFocus();
                a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorSplitItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(181652);
            }
        });
        AppMethodBeat.o(181653);
    }

    @Override // com.tencent.mm.plugin.editor.adapter.a.d, com.tencent.mm.plugin.editor.adapter.a.a
    public final void a(com.tencent.mm.plugin.editor.model.a.a aVar, int i2, int i3) {
        AppMethodBeat.i(181654);
        super.a(aVar, i2, i3);
        if (aVar.getType() != -1) {
            AppMethodBeat.o(181654);
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.qOy.getLayoutParams();
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        this.qOy.setLayoutParams(layoutParams);
        this.qOx.setVisibility(0);
        this.qOJ = this.aus.findViewById(R.id.g1t);
        AppMethodBeat.o(181654);
    }

    @Override // com.tencent.mm.plugin.editor.adapter.a.a
    public final int cCY() {
        return -1;
    }
}
