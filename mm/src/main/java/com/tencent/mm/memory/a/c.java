package com.tencent.mm.memory.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import java.util.Map;

public final class c<T, V> extends a<T, V, V, V> {
    public c(int i2) {
        super(i2);
    }

    public c(f.b<T, V> bVar) {
        super(bVar);
    }

    @Override // com.tencent.mm.memory.a.a.a.e
    public final V ca(V v) {
        return v;
    }

    @Override // com.tencent.mm.memory.a.a.a.e
    public final V bY(V v) {
        return v;
    }

    @Override // com.tencent.mm.memory.a.a.a.e
    public final V A(T t, V v) {
        return v;
    }

    @Override // com.tencent.mm.memory.a.a.a.e
    public final T aSg() {
        return null;
    }

    @Override // com.tencent.mm.b.f
    public final Map<T, V> snapshot() {
        AppMethodBeat.i(156489);
        Map<T, V> snapshot = this.iuv.snapshot();
        AppMethodBeat.o(156489);
        return snapshot;
    }
}
