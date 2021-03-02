package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.c;

public final class k extends j {
    private ImageView JLa;
    private TextView JLb;

    public k(View view, com.tencent.mm.plugin.wenote.model.nativenote.manager.k kVar) {
        super(view, kVar);
        AppMethodBeat.i(30870);
        this.qOs.setVisibility(8);
        this.dKU.setVisibility(8);
        this.kmg.setVisibility(8);
        this.qOs.setOnClickListener(null);
        this.JLa = (ImageView) view.findViewById(R.id.g1o);
        this.JLb = (TextView) view.findViewById(R.id.g1q);
        AppMethodBeat.o(30870);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a, com.tencent.mm.plugin.wenote.ui.nativenote.a.j
    public final void a(c cVar, int i2, int i3) {
        AppMethodBeat.i(30871);
        super.a(cVar, i2, i3);
        if (cVar.getType() != -4) {
            AppMethodBeat.o(30871);
            return;
        }
        this.qOz.setVisibility(0);
        AppMethodBeat.o(30871);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final int cCY() {
        return -4;
    }
}
