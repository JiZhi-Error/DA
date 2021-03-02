package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r implements ParagraphStyle {
    public final q JIU;
    public final ParagraphStyle qTA;

    public r(q qVar, ParagraphStyle paragraphStyle) {
        this.JIU = qVar;
        this.qTA = paragraphStyle;
    }

    public final String toString() {
        AppMethodBeat.i(30663);
        String str = this.JIU.name() + " - " + this.qTA.getClass().getSimpleName();
        AppMethodBeat.o(30663);
        return str;
    }
}
