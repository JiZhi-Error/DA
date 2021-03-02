package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.d;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class e extends j {
    public e(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(30856);
        this.qOs.setVisibility(0);
        this.dKU.setVisibility(8);
        this.kmg.setVisibility(8);
        this.qOs.setTag(this);
        this.qOs.setOnClickListener(this.qOH);
        AppMethodBeat.o(30856);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a, com.tencent.mm.plugin.wenote.ui.nativenote.a.j
    public final void a(c cVar, int i2, int i3) {
        AppMethodBeat.i(30857);
        this.qOv.setImageResource(com.tencent.mm.plugin.fav.ui.e.asl(((d) cVar).qPP));
        this.qOt.setText(((d) cVar).title);
        this.qOu.setText(((d) cVar).content);
        super.a(cVar, i2, i3);
        AppMethodBeat.o(30857);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final int cCY() {
        return 5;
    }
}
