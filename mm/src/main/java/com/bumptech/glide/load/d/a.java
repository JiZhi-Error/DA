package com.bumptech.glide.load.d;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.v;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a<T> implements v<T> {
    protected final T data;

    public a(T t) {
        AppMethodBeat.i(77345);
        this.data = (T) j.checkNotNull(t, "Argument must not be null");
        AppMethodBeat.o(77345);
    }

    @Override // com.bumptech.glide.load.b.v
    public final Class<T> oV() {
        AppMethodBeat.i(77346);
        Class<T> cls = (Class<T>) this.data.getClass();
        AppMethodBeat.o(77346);
        return cls;
    }

    @Override // com.bumptech.glide.load.b.v
    public final T get() {
        return this.data;
    }

    @Override // com.bumptech.glide.load.b.v
    public final int getSize() {
        return 1;
    }

    @Override // com.bumptech.glide.load.b.v
    public final void recycle() {
    }
}
