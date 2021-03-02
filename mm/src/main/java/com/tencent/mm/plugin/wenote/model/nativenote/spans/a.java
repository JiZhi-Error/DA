package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;

public final class a {
    public final q JIU;
    public int qSZ;
    public int qTa;

    public a(q qVar, int i2, int i3) {
        this.JIU = qVar;
        this.qSZ = i2;
        this.qTa = i3;
    }

    public final String toString() {
        AppMethodBeat.i(30624);
        String str = this.JIU.name() + " - " + this.qSZ + FilePathGenerator.ANDROID_DIR_SEP + this.qTa;
        AppMethodBeat.o(30624);
        return str;
    }
}
