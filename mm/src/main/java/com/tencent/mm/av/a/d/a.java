package com.tencent.mm.av.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.memory.a.c;
import java.util.Map;

public final class a<K, V> {
    public f<K, V> icd;

    public a(int i2) {
        AppMethodBeat.i(130425);
        this.icd = new c(i2);
        AppMethodBeat.o(130425);
    }

    public final synchronized boolean check(K k) {
        boolean check;
        AppMethodBeat.i(130426);
        if (this.icd == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.o(130426);
            throw nullPointerException;
        }
        check = this.icd.check(k);
        AppMethodBeat.o(130426);
        return check;
    }

    public final V get(K k) {
        AppMethodBeat.i(130427);
        if (this.icd == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.o(130427);
            throw nullPointerException;
        }
        V v = this.icd.get(k);
        AppMethodBeat.o(130427);
        return v;
    }

    public final V put(K k, V v) {
        AppMethodBeat.i(130428);
        if (this.icd == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.o(130428);
            throw nullPointerException;
        }
        V put = this.icd.put(k, v);
        AppMethodBeat.o(130428);
        return put;
    }

    public final synchronized Map<K, V> snapshot() {
        Map<K, V> snapshot;
        AppMethodBeat.i(130429);
        if (this.icd == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.o(130429);
            throw nullPointerException;
        }
        snapshot = this.icd.snapshot();
        AppMethodBeat.o(130429);
        return snapshot;
    }

    public final synchronized String toString() {
        String obj;
        AppMethodBeat.i(130430);
        if (this.icd == null) {
            NullPointerException nullPointerException = new NullPointerException("mData == null");
            AppMethodBeat.o(130430);
            throw nullPointerException;
        }
        obj = this.icd.toString();
        AppMethodBeat.o(130430);
        return obj;
    }
}
