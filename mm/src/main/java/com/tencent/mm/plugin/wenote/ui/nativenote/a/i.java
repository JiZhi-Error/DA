package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.g;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class i extends j {
    public i(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(30864);
        this.qOs.setVisibility(0);
        this.dKU.setVisibility(8);
        this.kmg.setVisibility(8);
        this.qOs.setTag(this);
        this.qOs.setOnClickListener(this.qOH);
        AppMethodBeat.o(30864);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a, com.tencent.mm.plugin.wenote.ui.nativenote.a.j
    public final void a(c cVar, int i2, int i3) {
        AppMethodBeat.i(30865);
        this.qOv.setImageResource(R.raw.app_attach_file_icon_location);
        this.qOt.setText(((g) cVar).kHV);
        this.qOu.setText(((g) cVar).iUO);
        super.a(cVar, i2, i3);
        AppMethodBeat.o(30865);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final int cCY() {
        return 3;
    }
}
