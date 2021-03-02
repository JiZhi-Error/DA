package com.bumptech.glide.load.b;

import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.d;
import com.bumptech.glide.load.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class e<DataType> implements a.b {
    private final d<DataType> aFU;
    private final i aFV;
    private final DataType data;

    e(d<DataType> dVar, DataType datatype, i iVar) {
        this.aFU = dVar;
        this.data = datatype;
        this.aFV = iVar;
    }

    @Override // com.bumptech.glide.load.b.b.a.b
    public final boolean s(File file) {
        AppMethodBeat.i(76931);
        boolean a2 = this.aFU.a(this.data, file, this.aFV);
        AppMethodBeat.o(76931);
        return a2;
    }
}
