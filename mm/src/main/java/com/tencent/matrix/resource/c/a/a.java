package com.tencent.matrix.resource.c.a;

public final class a {
    public final int cZm;
    public final b cZn;
    public final Object cZo;

    public a(int i2, b bVar, Object obj) {
        this.cZm = i2;
        this.cZn = bVar;
        this.cZo = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.cZm != aVar.cZm) {
            return false;
        }
        if (!this.cZn.equals(aVar.cZn)) {
            return false;
        }
        return (this.cZo == null || this.cZo.equals(aVar.cZo)) && (aVar.cZo == null || aVar.cZo.equals(this.cZo));
    }

    public final int hashCode() {
        return (this.cZn.hashCode() << 31) + this.cZm;
    }
}
