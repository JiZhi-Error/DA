package com.tencent.mm.danmaku.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

public final class g<T> {
    public final a<T> gQB;
    public final b gQC;
    public final Comparator<T> mComparator;
    public int mSize = 0;

    public interface b<T> {
        int m(T t, long j2);
    }

    public g(Comparator<T> comparator, b<T> bVar) {
        AppMethodBeat.i(241753);
        this.gQC = bVar;
        this.gQB = new a<>();
        this.mComparator = comparator;
        AppMethodBeat.o(241753);
    }

    public static final class a<T> {
        public a<T> gQD;
        public a<T> gQE;
        public final T mData;

        public a() {
            AppMethodBeat.i(241752);
            this.mData = null;
            this.gQD = this;
            this.gQE = this;
            AppMethodBeat.o(241752);
        }

        public a(T t, a<T> aVar, a<T> aVar2) {
            this.mData = t;
            this.gQD = aVar;
            this.gQE = aVar2;
        }
    }

    public final void clear() {
        this.gQB.gQD = this.gQB;
        this.gQB.gQE = this.gQB;
        this.mSize = 0;
    }

    public final T peekFirst() {
        return this.gQB.gQD.mData;
    }
}
