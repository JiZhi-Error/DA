package com.google.a;

final class bc<T> implements br<T> {
    private final aw bXE;
    private final cb<?, ?> bYB;
    private final s<?> bYC;
    private final boolean bYs;

    private bc(cb<?, ?> cbVar, s<?> sVar, aw awVar) {
        this.bYB = cbVar;
        this.bYs = sVar.f(awVar);
        this.bYC = sVar;
        this.bXE = awVar;
    }

    static <T> bc<T> a(cb<?, ?> cbVar, s<?> sVar, aw awVar) {
        return new bc<>(cbVar, sVar, awVar);
    }

    @Override // com.google.a.br
    public final boolean equals(T t, T t2) {
        if (!this.bYB.aw(t).equals(this.bYB.aw(t2))) {
            return false;
        }
        if (this.bYs) {
            return this.bYC.an(t).equals(this.bYC.an(t2));
        }
        return true;
    }

    @Override // com.google.a.br
    public final int hashCode(T t) {
        int hashCode = this.bYB.aw(t).hashCode();
        if (this.bYs) {
            return (hashCode * 53) + this.bYC.an(t).hashCode();
        }
        return hashCode;
    }

    @Override // com.google.a.br
    public final void n(T t, T t2) {
        bt.a(this.bYB, t, t2);
        if (this.bYs) {
            bt.a(this.bYC, t, t2);
        }
    }

    @Override // com.google.a.br
    public final void ap(T t) {
        this.bYB.ap(t);
        this.bYC.ap(t);
    }
}
