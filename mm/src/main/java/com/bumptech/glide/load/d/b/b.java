package com.bumptech.glide.load.d.b;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements v<byte[]> {
    private final byte[] zy;

    public b(byte[] bArr) {
        AppMethodBeat.i(77452);
        this.zy = (byte[]) j.checkNotNull(bArr, "Argument must not be null");
        AppMethodBeat.o(77452);
    }

    @Override // com.bumptech.glide.load.b.v
    public final Class<byte[]> oV() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.b.v
    public final int getSize() {
        return this.zy.length;
    }

    @Override // com.bumptech.glide.load.b.v
    public final void recycle() {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.bumptech.glide.load.b.v
    public final /* bridge */ /* synthetic */ byte[] get() {
        return this.zy;
    }
}
