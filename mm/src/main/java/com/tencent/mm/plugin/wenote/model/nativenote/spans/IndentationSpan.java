package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.LeadingMarginSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IndentationSpan extends LeadingMarginSpan.Standard implements f<Integer>, g<Integer> {
    private final boolean qTe;
    private final int qTg;

    private IndentationSpan(int i2, boolean z) {
        super(i2);
        this.qTg = i2;
        this.qTe = z;
    }

    public int getLeadingMargin(boolean z) {
        if (this.qTe) {
            return 0;
        }
        return this.qTg;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.g
    public final /* synthetic */ Integer getValue() {
        AppMethodBeat.i(30635);
        Integer valueOf = Integer.valueOf(this.qTg);
        AppMethodBeat.o(30635);
        return valueOf;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.wenote.model.nativenote.spans.f' to match base method */
    @Override // com.tencent.mm.plugin.wenote.model.nativenote.spans.f
    public final /* synthetic */ f<Integer> gjZ() {
        AppMethodBeat.i(30636);
        IndentationSpan indentationSpan = new IndentationSpan(this.qTg, this.qTe);
        AppMethodBeat.o(30636);
        return indentationSpan;
    }
}
