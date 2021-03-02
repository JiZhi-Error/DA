package com.tencent.i.a.b.c.a;

import com.tencent.i.a.a.b;
import com.tencent.i.a.a.c;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a extends b implements d {
    protected AtomicBoolean Srt = new AtomicBoolean(false);

    public a(c cVar) {
        super(cVar);
    }

    @Override // com.tencent.i.a.b.c.a.d
    public boolean hqq() {
        return false;
    }

    @Override // com.tencent.i.a.b.c.a.d
    public final boolean hqr() {
        return this.Srt.get();
    }

    @Override // com.tencent.i.a.b.c.a.d
    public final void Ef(boolean z) {
        this.Srt.set(z);
    }
}
