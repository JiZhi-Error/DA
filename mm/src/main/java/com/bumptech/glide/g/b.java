package com.bumptech.glide.g;

import android.support.v4.e.a;
import android.support.v4.e.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b<K, V> extends a<K, V> {
    private int aHK;

    @Override // android.support.v4.e.n
    public final void clear() {
        AppMethodBeat.i(77722);
        this.aHK = 0;
        super.clear();
        AppMethodBeat.o(77722);
    }

    @Override // android.support.v4.e.n
    public final V setValueAt(int i2, V v) {
        AppMethodBeat.i(77723);
        this.aHK = 0;
        V v2 = (V) super.setValueAt(i2, v);
        AppMethodBeat.o(77723);
        return v2;
    }

    @Override // android.support.v4.e.n, java.util.Map
    public final V put(K k, V v) {
        AppMethodBeat.i(77724);
        this.aHK = 0;
        V v2 = (V) super.put(k, v);
        AppMethodBeat.o(77724);
        return v2;
    }

    @Override // android.support.v4.e.n
    public final void a(n<? extends K, ? extends V> nVar) {
        AppMethodBeat.i(77725);
        this.aHK = 0;
        super.a(nVar);
        AppMethodBeat.o(77725);
    }

    @Override // android.support.v4.e.n
    public final V removeAt(int i2) {
        AppMethodBeat.i(77726);
        this.aHK = 0;
        V v = (V) super.removeAt(i2);
        AppMethodBeat.o(77726);
        return v;
    }

    @Override // android.support.v4.e.n
    public final int hashCode() {
        AppMethodBeat.i(77727);
        if (this.aHK == 0) {
            this.aHK = super.hashCode();
        }
        int i2 = this.aHK;
        AppMethodBeat.o(77727);
        return i2;
    }
}
