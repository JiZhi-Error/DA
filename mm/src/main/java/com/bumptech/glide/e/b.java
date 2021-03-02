package com.bumptech.glide.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements c, d {
    private final d aNi;
    private c aNj;
    private c aNk;

    public b(d dVar) {
        this.aNi = dVar;
    }

    public final void a(c cVar, c cVar2) {
        this.aNj = cVar;
        this.aNk = cVar2;
    }

    @Override // com.bumptech.glide.e.c
    public final void begin() {
        AppMethodBeat.i(77619);
        if (!this.aNj.isRunning()) {
            this.aNj.begin();
        }
        AppMethodBeat.o(77619);
    }

    @Override // com.bumptech.glide.e.c
    public final void clear() {
        AppMethodBeat.i(77621);
        this.aNj.clear();
        if (this.aNk.isRunning()) {
            this.aNk.clear();
        }
        AppMethodBeat.o(77621);
    }

    @Override // com.bumptech.glide.e.c
    public final boolean isRunning() {
        AppMethodBeat.i(77622);
        if (this.aNj.isFailed()) {
            boolean isRunning = this.aNk.isRunning();
            AppMethodBeat.o(77622);
            return isRunning;
        }
        boolean isRunning2 = this.aNj.isRunning();
        AppMethodBeat.o(77622);
        return isRunning2;
    }

    @Override // com.bumptech.glide.e.c
    public final boolean isComplete() {
        AppMethodBeat.i(77623);
        if (this.aNj.isFailed()) {
            boolean isComplete = this.aNk.isComplete();
            AppMethodBeat.o(77623);
            return isComplete;
        }
        boolean isComplete2 = this.aNj.isComplete();
        AppMethodBeat.o(77623);
        return isComplete2;
    }

    @Override // com.bumptech.glide.e.c
    public final boolean qb() {
        AppMethodBeat.i(77624);
        if (this.aNj.isFailed()) {
            boolean qb = this.aNk.qb();
            AppMethodBeat.o(77624);
            return qb;
        }
        boolean qb2 = this.aNj.qb();
        AppMethodBeat.o(77624);
        return qb2;
    }

    @Override // com.bumptech.glide.e.c
    public final boolean qc() {
        AppMethodBeat.i(204488);
        if (this.aNj.isFailed()) {
            boolean qc = this.aNk.qc();
            AppMethodBeat.o(204488);
            return qc;
        }
        boolean qc2 = this.aNj.qc();
        AppMethodBeat.o(204488);
        return qc2;
    }

    @Override // com.bumptech.glide.e.c
    public final boolean isFailed() {
        AppMethodBeat.i(77626);
        if (!this.aNj.isFailed() || !this.aNk.isFailed()) {
            AppMethodBeat.o(77626);
            return false;
        }
        AppMethodBeat.o(77626);
        return true;
    }

    @Override // com.bumptech.glide.e.c
    public final void recycle() {
        AppMethodBeat.i(77627);
        this.aNj.recycle();
        this.aNk.recycle();
        AppMethodBeat.o(77627);
    }

    @Override // com.bumptech.glide.e.c
    public final boolean a(c cVar) {
        AppMethodBeat.i(77628);
        if (cVar instanceof b) {
            b bVar = (b) cVar;
            if (!this.aNj.a(bVar.aNj) || !this.aNk.a(bVar.aNk)) {
                AppMethodBeat.o(77628);
                return false;
            }
            AppMethodBeat.o(77628);
            return true;
        }
        AppMethodBeat.o(77628);
        return false;
    }

    private boolean e(c cVar) {
        AppMethodBeat.i(77632);
        if (cVar.equals(this.aNj) || (this.aNj.isFailed() && cVar.equals(this.aNk))) {
            AppMethodBeat.o(77632);
            return true;
        }
        AppMethodBeat.o(77632);
        return false;
    }

    @Override // com.bumptech.glide.e.d
    public final void f(c cVar) {
        AppMethodBeat.i(77634);
        if (this.aNi != null) {
            this.aNi.f(this);
        }
        AppMethodBeat.o(77634);
    }

    @Override // com.bumptech.glide.e.d
    public final void g(c cVar) {
        AppMethodBeat.i(77635);
        if (!cVar.equals(this.aNk)) {
            if (!this.aNk.isRunning()) {
                this.aNk.begin();
            }
            AppMethodBeat.o(77635);
            return;
        }
        if (this.aNi != null) {
            this.aNi.g(this);
        }
        AppMethodBeat.o(77635);
    }

    @Override // com.bumptech.glide.e.d
    public final boolean b(c cVar) {
        boolean z;
        AppMethodBeat.i(77629);
        if (this.aNi == null || this.aNi.b(this)) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !e(cVar)) {
            AppMethodBeat.o(77629);
            return false;
        }
        AppMethodBeat.o(77629);
        return true;
    }

    @Override // com.bumptech.glide.e.d
    public final boolean c(c cVar) {
        boolean z;
        AppMethodBeat.i(77630);
        if (this.aNi == null || this.aNi.c(this)) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !e(cVar)) {
            AppMethodBeat.o(77630);
            return false;
        }
        AppMethodBeat.o(77630);
        return true;
    }

    @Override // com.bumptech.glide.e.d
    public final boolean d(c cVar) {
        boolean z;
        AppMethodBeat.i(77631);
        if (this.aNi == null || this.aNi.d(this)) {
            z = true;
        } else {
            z = false;
        }
        if (!z || !e(cVar)) {
            AppMethodBeat.o(77631);
            return false;
        }
        AppMethodBeat.o(77631);
        return true;
    }

    @Override // com.bumptech.glide.e.d
    public final boolean qd() {
        boolean z;
        AppMethodBeat.i(77633);
        if (this.aNi == null || !this.aNi.qd()) {
            z = false;
        } else {
            z = true;
        }
        if (z || qb()) {
            AppMethodBeat.o(77633);
            return true;
        }
        AppMethodBeat.o(77633);
        return false;
    }
}
