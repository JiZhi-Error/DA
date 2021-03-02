package com.bumptech.glide.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class g<T, Y> {
    private final long aIB;
    private long aID;
    private final Map<T, Y> aNT = new LinkedHashMap(100, 0.75f, true);
    private long maxSize;

    public g(long j2) {
        AppMethodBeat.i(77749);
        this.aIB = j2;
        this.maxSize = j2;
        AppMethodBeat.o(77749);
    }

    /* access modifiers changed from: protected */
    public int W(Y y) {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void g(T t, Y y) {
    }

    public final synchronized long qu() {
        return this.maxSize;
    }

    public final synchronized Y get(T t) {
        Y y;
        AppMethodBeat.i(77750);
        y = this.aNT.get(t);
        AppMethodBeat.o(77750);
        return y;
    }

    public final synchronized Y put(T t, Y y) {
        Y put;
        AppMethodBeat.i(77751);
        int W = W(y);
        if (((long) W) >= this.maxSize) {
            g(t, y);
            put = null;
            AppMethodBeat.o(77751);
        } else {
            if (y != null) {
                this.aID = ((long) W) + this.aID;
            }
            put = this.aNT.put(t, y);
            if (put != null) {
                this.aID -= (long) W(put);
                if (!put.equals(y)) {
                    g(t, put);
                }
            }
            o(this.maxSize);
            AppMethodBeat.o(77751);
        }
        return put;
    }

    public final synchronized Y remove(T t) {
        Y remove;
        AppMethodBeat.i(77752);
        remove = this.aNT.remove(t);
        if (remove != null) {
            this.aID -= (long) W(remove);
        }
        AppMethodBeat.o(77752);
        return remove;
    }

    public final void oZ() {
        AppMethodBeat.i(77753);
        o(0);
        AppMethodBeat.o(77753);
    }

    /* access modifiers changed from: protected */
    public final synchronized void o(long j2) {
        AppMethodBeat.i(77754);
        while (this.aID > j2) {
            Iterator<Map.Entry<T, Y>> it = this.aNT.entrySet().iterator();
            Map.Entry<T, Y> next = it.next();
            Y value = next.getValue();
            this.aID -= (long) W(value);
            T key = next.getKey();
            it.remove();
            g(key, value);
        }
        AppMethodBeat.o(77754);
    }
}
