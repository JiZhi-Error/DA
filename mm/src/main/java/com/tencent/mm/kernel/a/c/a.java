package com.tencent.mm.kernel.a.c;

import com.tencent.mm.kernel.h;

public abstract class a implements b {
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.kernel.a.c.a */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends a> T after(com.tencent.mm.kernel.b.a aVar) {
        h.aAl().aAe().azG().hqy.hrL.a(b.class, this, aVar);
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.kernel.a.c.a */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends a> T before(com.tencent.mm.kernel.b.a aVar) {
        h.aAl().aAe().azG().hqy.hrL.a(b.class, aVar, this);
        return this;
    }

    public void alone() {
        h.aAl().aAe().azG().hqy.hrL.a(b.class, this, this);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public String name() {
        return toString();
    }

    public String toString() {
        return getClass().getName() + '@' + Integer.toHexString(super.hashCode());
    }

    public int hashCode() {
        return name().hashCode();
    }
}
