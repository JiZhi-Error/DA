package com.tencent.mm.storagebase.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storagebase.a.a;
import com.tencent.mm.storagebase.a.f;
import java.util.ArrayList;

public abstract class g<K, T extends a> {
    public d Ouf;
    public boolean Oug;

    public abstract ArrayList<T> bo(ArrayList<Object> arrayList);

    public abstract T gFL();

    public g(d dVar, int i2, boolean z) {
        this.Ouf = dVar;
        this.Oug = z;
        this.Ouf.AO(true);
        this.Ouf.a(new f.a() {
            /* class com.tencent.mm.storagebase.a.g.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.a.f.a
            public final a gFJ() {
                AppMethodBeat.i(133503);
                a gFL = g.this.gFL();
                AppMethodBeat.o(133503);
                return gFL;
            }

            @Override // com.tencent.mm.storagebase.a.f.a
            public final ArrayList<a> bo(ArrayList<Object> arrayList) {
                AppMethodBeat.i(133504);
                ArrayList<T> bo = g.this.bo(arrayList);
                AppMethodBeat.o(133504);
                return bo;
            }
        });
        if (i2 != 0) {
            this.Ouf.akA(i2);
        }
        if (!z) {
            getCount();
        }
    }

    public final void close() {
        this.Ouf.close();
        this.Ouf = null;
    }

    public final int getCount() {
        return this.Ouf.getCount();
    }

    public final boolean isClosed() {
        return this.Ouf.isClosed();
    }

    public final boolean gFx() {
        return this.Ouf.gFx();
    }

    public final void c(Object obj, T t) {
        this.Ouf.a(obj, t);
    }

    public final SparseArray<K>[] gFv() {
        return this.Ouf.gFv();
    }

    public final boolean ed(Object obj) {
        return this.Ouf.ed(obj);
    }
}
