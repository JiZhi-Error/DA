package com.google.android.exoplayer2;

import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.source.k;

public interface f extends q {

    @Deprecated
    public interface a extends q.a {
    }

    public interface b {
        void c(int i2, Object obj);
    }

    void a(k kVar);

    void a(c... cVarArr);

    void b(c... cVarArr);

    public static final class c {
        public final b bbZ;
        public final int bca;
        public final Object bcb;

        public c(b bVar, int i2, Object obj) {
            this.bbZ = bVar;
            this.bca = i2;
            this.bcb = obj;
        }
    }
}
