package com.tencent.mm.plugin.editor.model.nativenote.spans;

import android.text.style.ParagraphStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class p implements ParagraphStyle {
    public final o qSY;
    public final ParagraphStyle qTA;

    public p(o oVar, ParagraphStyle paragraphStyle) {
        this.qSY = oVar;
        this.qTA = paragraphStyle;
    }

    public final String toString() {
        AppMethodBeat.i(181957);
        String str = this.qSY.name() + " - " + this.qTA.getClass().getSimpleName();
        AppMethodBeat.o(181957);
        return str;
    }
}
