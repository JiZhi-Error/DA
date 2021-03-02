package com.tencent.mm.plugin.wenote.ui.nativenote.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;

public final class n extends j {
    public n(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(30881);
        this.qOs.setVisibility(0);
        this.dKU.setVisibility(8);
        this.kmg.setVisibility(8);
        this.qOs.setTag(this);
        this.qOs.setOnClickListener(this.qOH);
        AppMethodBeat.o(30881);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a, com.tencent.mm.plugin.wenote.ui.nativenote.a.j
    public final void a(c cVar, int i2, int i3) {
        AppMethodBeat.i(30882);
        this.qOv.setImageResource(R.raw.msg_state_fail_resend);
        this.qOt.setText(((j) cVar).title);
        this.qOu.setText(((j) cVar).content);
        super.a(cVar, i2, i3);
        AppMethodBeat.o(30882);
    }

    @Override // com.tencent.mm.plugin.wenote.ui.nativenote.a.a
    public final int cCY() {
        return 0;
    }
}
