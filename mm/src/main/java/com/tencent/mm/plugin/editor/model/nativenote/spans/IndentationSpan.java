package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.LeadingMarginSpan;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IndentationSpan extends LeadingMarginSpan.Standard implements g<Integer>, h<Integer> {
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
    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.h
    public final /* synthetic */ Integer getValue() {
        AppMethodBeat.i(181938);
        Integer valueOf = Integer.valueOf(this.qTg);
        AppMethodBeat.o(181938);
        return valueOf;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.editor.model.nativenote.spans.g' to match base method */
    @Override // com.tencent.mm.plugin.editor.model.nativenote.spans.g
    public final /* synthetic */ g<Integer> cEu() {
        AppMethodBeat.i(181939);
        IndentationSpan indentationSpan = new IndentationSpan(this.qTg, this.qTe);
        AppMethodBeat.o(181939);
        return indentationSpan;
    }
}
