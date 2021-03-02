package com.tencent.mm.plugin.flash.b;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;

public final class e extends a {
    @Override // com.tencent.mm.plugin.flash.b.a
    public final int dKV() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.flash.b.a
    public final int dLb() {
        return 1;
    }

    @Override // com.tencent.mm.plugin.flash.b.a
    public final int dLc() {
        return 2;
    }

    @Override // com.tencent.mm.plugin.flash.b.g, com.tencent.mm.plugin.flash.b.a
    public final void r(TextView textView) {
        AppMethodBeat.i(186648);
        textView.setText(a.aI(textView.getContext(), R.string.c6f));
        AppMethodBeat.o(186648);
    }
}
