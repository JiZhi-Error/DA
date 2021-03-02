package com.tencent.mm.plugin.editor.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;

public final class a {
    public final o qSY;
    public int qSZ;
    public int qTa;

    public a(o oVar, int i2, int i3) {
        this.qSY = oVar;
        this.qSZ = i2;
        this.qTa = i3;
    }

    public final String toString() {
        AppMethodBeat.i(181925);
        String str = this.qSY.name() + " - " + this.qSZ + FilePathGenerator.ANDROID_DIR_SEP + this.qTa;
        AppMethodBeat.o(181925);
        return str;
    }
}
