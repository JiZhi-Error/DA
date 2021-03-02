package com.tencent.f.g;

import com.tencent.f.g.a.a;

public abstract class b extends a {
    static final /* synthetic */ boolean $assertionsDisabled = (!b.class.desiredAssertionStatus());
    private final int RTY;
    private final int RTZ;

    public b(int i2, int i3) {
        if ($assertionsDisabled || i2 >= i3) {
            this.RTY = i2;
            this.RTZ = i3;
            return;
        }
        throw new AssertionError();
    }

    @Override // com.tencent.f.g.a.b
    public final synchronized boolean c(g gVar) {
        boolean z;
        int hmu = gVar.hmu();
        int hF = gVar.hF("LIMIT", this.RTY);
        z = hF > hmu;
        if (!z && hF >= this.RTY) {
            gVar.hE("LIMIT", this.RTZ);
        }
        return z;
    }

    @Override // com.tencent.f.g.a.a, com.tencent.f.g.a.b
    public synchronized void a(g gVar) {
        super.a(gVar);
        if (gVar.hF("LIMIT", 0) <= this.RTZ) {
            gVar.hE("LIMIT", this.RTY);
        }
    }
}
