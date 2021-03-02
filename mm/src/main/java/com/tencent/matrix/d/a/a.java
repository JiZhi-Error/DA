package com.tencent.matrix.d.a;

import com.tencent.c.a.a;
import com.tencent.matrix.g.c;

public final class a {
    private final com.tencent.c.a.a cQF;

    /* renamed from: com.tencent.matrix.d.a.a$a  reason: collision with other inner class name */
    public static final class C0220a {
        public com.tencent.c.a.a cVx;
    }

    public /* synthetic */ a(com.tencent.c.a.a aVar, byte b2) {
        this(aVar);
    }

    private a(com.tencent.c.a.a aVar) {
        this.cQF = aVar;
        c.i("Matrix.MemoryConfig", "MemoryConfig()", new Object[0]);
    }

    public final float getThreshold() {
        return this.cQF.ei(a.EnumC0131a.clicfg_matrix_memory_threshold.name());
    }
}
