package com.tencent.mm.cg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.b;
import java.util.HashSet;
import java.util.Iterator;

public final class a<T> implements b.a<T> {
    private final Object NMD;
    private HashSet<Object<T>> kYC;
    private final String mName;
    private T mValue;

    private a(String str) {
        AppMethodBeat.i(133213);
        this.NMD = new Object();
        this.mName = str;
        this.kYC = new HashSet<>();
        AppMethodBeat.o(133213);
    }

    a(String str, T t) {
        this(str);
        this.mValue = t;
    }

    @Override // com.tencent.mm.cg.b.a
    public final String name() {
        return this.mName;
    }

    @Override // com.tencent.mm.cg.b.a
    public final T get() {
        return this.mValue;
    }

    /* access modifiers changed from: package-private */
    public final void set(T t) {
        boolean z;
        AppMethodBeat.i(133214);
        T t2 = this.mValue;
        if (t == t2 || (t != null && t.equals(t2))) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            this.mValue = t;
            synchronized (this.NMD) {
                try {
                    Iterator<Object<T>> it = this.kYC.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                } finally {
                    AppMethodBeat.o(133214);
                }
            }
            return;
        }
        AppMethodBeat.o(133214);
    }

    public final String toString() {
        AppMethodBeat.i(133215);
        String str = "Status: " + this.mName;
        AppMethodBeat.o(133215);
        return str;
    }
}
