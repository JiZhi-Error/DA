package com.tencent.mm.plugin.textstatus.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n implements Cloneable {
    public static n FXs = new n().wq(true).wr(true);
    public static n FXt;
    public static n FXu;
    public static n VcA = new n().wr(true);
    public boolean FXv = false;
    public int scene = 3;
    int showFlag = 0;

    @Override // java.lang.Object
    public final /* synthetic */ Object clone() {
        AppMethodBeat.i(222804);
        n fvA = fvA();
        AppMethodBeat.o(222804);
        return fvA;
    }

    static {
        AppMethodBeat.i(222805);
        n wr = new n().wr(true);
        wr.showFlag |= 16;
        FXt = wr;
        n nVar = new n();
        nVar.showFlag |= 1;
        nVar.showFlag |= 2;
        FXu = nVar.wr(false).wq(false);
        AppMethodBeat.o(222805);
    }

    public final n fvA() {
        n nVar;
        AppMethodBeat.i(222803);
        try {
            nVar = (n) super.clone();
        } catch (Throwable th) {
            nVar = null;
        }
        AppMethodBeat.o(222803);
        return nVar;
    }

    public final n axm(int i2) {
        this.scene = i2;
        return this;
    }

    public final n fvB() {
        this.FXv = true;
        return this;
    }

    public final boolean abM(int i2) {
        return (this.showFlag & i2) != 0;
    }

    public final n wq(boolean z) {
        if (z) {
            this.showFlag |= 4;
        } else {
            this.showFlag &= -5;
        }
        return this;
    }

    private n wr(boolean z) {
        if (z) {
            this.showFlag |= 8;
        } else {
            this.showFlag &= -9;
        }
        return this;
    }
}
