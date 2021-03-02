package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class b extends j {
    public b(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(30847);
        this.qOs.setVisibility(8);
        this.dKU.setVisibility(8);
        this.kmg.setVisibility(8);
        this.qOs.setOnClickListener(null);
        AppMethodBeat.o(30847);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a, com.tencent.mm.plugin.wenote.ui.nativenote.a.j
    public final void a(c cVar, int i2, int i3) {
        AppMethodBeat.i(30848);
        super.a(cVar, i2, i3);
        if (cVar.getType() != -2) {
            AppMethodBeat.o(30848);
        } else if (this.JJu.JIH != 3) {
            AppMethodBeat.o(30848);
        } else {
            this.qOA.setVisibility(0);
            AppMethodBeat.o(30848);
        }
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final int cCY() {
        return -2;
    }
}
