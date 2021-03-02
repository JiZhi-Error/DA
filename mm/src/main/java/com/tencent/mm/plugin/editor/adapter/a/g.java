package com.tencent.mm.plugin.editor.adapter.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.editor.model.a.a;
import com.tencent.mm.plugin.editor.model.a.k;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;

public final class g extends d {
    public g(View view, j jVar) {
        super(view, jVar);
        AppMethodBeat.i(181661);
        this.qOs.setVisibility(0);
        this.dKU.setVisibility(8);
        this.kmg.setVisibility(8);
        this.qOs.setTag(this);
        this.qOs.setOnClickListener(this.qOH);
        AppMethodBeat.o(181661);
    }

    @Override // com.tencent.mm.plugin.editor.adapter.a.d, com.tencent.mm.plugin.editor.adapter.a.a
    public final void a(a aVar, int i2, int i3) {
        AppMethodBeat.i(181662);
        this.qOv.setImageResource(R.raw.msg_state_fail_resend);
        this.qOt.setText(((k) aVar).title);
        this.qOu.setText(((k) aVar).content);
        super.a(aVar, i2, i3);
        AppMethodBeat.o(181662);
    }

    @Override // com.tencent.mm.plugin.editor.adapter.a.a
    public final int cCY() {
        return 0;
    }
}
