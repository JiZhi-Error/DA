package com.bumptech.glide.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i implements c, d {
    private c aNE;
    private c aNF;
    private final d aNi;
    private boolean isRunning;

    i() {
        this(null);
    }

    public i(d dVar) {
        this.aNi = dVar;
    }

    public final void a(c cVar, c cVar2) {
        this.aNE = cVar;
        this.aNF = cVar2;
    }

    @Override // com.bumptech.glide.e.d
    public final boolean qd() {
        AppMethodBeat.i(77690);
        if (qm() || qb()) {
            AppMethodBeat.o(77690);
            return true;
        }
        AppMethodBeat.o(77690);
        return false;
    }

    @Override // com.bumptech.glide.e.d
    public final void f(c cVar) {
        AppMethodBeat.i(77691);
        if (cVar.equals(this.aNF)) {
            AppMethodBeat.o(77691);
            return;
        }
        if (this.aNi != null) {
            this.aNi.f(this);
        }
        if (!this.aNF.isComplete()) {
            this.aNF.clear();
        }
        AppMethodBeat.o(77691);
    }

    @Override // com.bumptech.glide.e.d
    public final void g(c cVar) {
        AppMethodBeat.i(77692);
        if (!cVar.equals(this.aNE)) {
            AppMethodBeat.o(77692);
            return;
        }
        if (this.aNi != null) {
            this.aNi.g(this);
        }
        AppMethodBeat.o(77692);
    }

    private boolean qm() {
        AppMethodBeat.i(77693);
        if (this.aNi == null || !this.aNi.qd()) {
            AppMethodBeat.o(77693);
            return false;
        }
        AppMethodBeat.o(77693);
        return true;
    }

    @Override // com.bumptech.glide.e.c
    public final void begin() {
        AppMethodBeat.i(77694);
        this.isRunning = true;
        if (!this.aNE.isComplete() && !this.aNF.isRunning()) {
            this.aNF.begin();
        }
        if (this.isRunning && !this.aNE.isRunning()) {
            this.aNE.begin();
        }
        AppMethodBeat.o(77694);
    }

    @Override // com.bumptech.glide.e.c
    public final void clear() {
        AppMethodBeat.i(77696);
        this.isRunning = false;
        this.aNF.clear();
        this.aNE.clear();
        AppMethodBeat.o(77696);
    }

    @Override // com.bumptech.glide.e.c
    public final boolean isRunning() {
        AppMethodBeat.i(77697);
        boolean isRunning2 = this.aNE.isRunning();
        AppMethodBeat.o(77697);
        return isRunning2;
    }

    @Override // com.bumptech.glide.e.c
    public final boolean isComplete() {
        AppMethodBeat.i(77698);
        if (this.aNE.isComplete() || this.aNF.isComplete()) {
            AppMethodBeat.o(77698);
            return true;
        }
        AppMethodBeat.o(77698);
        return false;
    }

    @Override // com.bumptech.glide.e.c
    public final boolean qb() {
        AppMethodBeat.i(77699);
        if (this.aNE.qb() || this.aNF.qb()) {
            AppMethodBeat.o(77699);
            return true;
        }
        AppMethodBeat.o(77699);
        return false;
    }

    @Override // com.bumptech.glide.e.c
    public final boolean qc() {
        AppMethodBeat.i(204492);
        boolean qc = this.aNE.qc();
        AppMethodBeat.o(204492);
        return qc;
    }

    @Override // com.bumptech.glide.e.c
    public final boolean isFailed() {
        AppMethodBeat.i(77701);
        boolean isFailed = this.aNE.isFailed();
        AppMethodBeat.o(77701);
        return isFailed;
    }

    @Override // com.bumptech.glide.e.c
    public final void recycle() {
        AppMethodBeat.i(77702);
        this.aNE.recycle();
        this.aNF.recycle();
        AppMethodBeat.o(77702);
    }

    @Override // com.bumptech.glide.e.c
    public final boolean a(c cVar) {
        AppMethodBeat.i(77703);
        if (cVar instanceof i) {
            i iVar = (i) cVar;
            if (this.aNE != null ? this.aNE.a(iVar.aNE) : iVar.aNE == null) {
                if (this.aNF != null ? this.aNF.a(iVar.aNF) : iVar.aNF == null) {
                    AppMethodBeat.o(77703);
                    return true;
                }
            }
            AppMethodBeat.o(77703);
            return false;
        }
        AppMethodBeat.o(77703);
        return false;
    }

    @Override // com.bumptech.glide.e.d
    public final boolean b(c cVar) {
        boolean z;
        AppMethodBeat.i(77687);
        if (this.aNi == null || this.aNi.b(this)) {
            z = true;
        } else {
            z = false;
        }
        if (!z || (!cVar.equals(this.aNE) && this.aNE.qb())) {
            AppMethodBeat.o(77687);
            return false;
        }
        AppMethodBeat.o(77687);
        return true;
    }

    @Override // com.bumptech.glide.e.d
    public final boolean c(c cVar) {
        boolean z;
        AppMethodBeat.i(77688);
        if (this.aNi == null || this.aNi.c(this)) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !cVar.equals(this.aNE) || qd()) {
            AppMethodBeat.o(77688);
            return false;
        }
        AppMethodBeat.o(77688);
        return true;
    }

    @Override // com.bumptech.glide.e.d
    public final boolean d(c cVar) {
        boolean z;
        AppMethodBeat.i(77689);
        if (this.aNi == null || this.aNi.d(this)) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !cVar.equals(this.aNE)) {
            AppMethodBeat.o(77689);
            return false;
        }
        AppMethodBeat.o(77689);
        return true;
    }
}
