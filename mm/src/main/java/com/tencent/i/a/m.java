package com.tencent.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class m {
    private a SqI;

    /* synthetic */ m(a aVar, byte b2) {
        this(aVar);
    }

    private m(a aVar) {
        this.SqI = aVar;
    }

    public final j hqa() {
        if (this.SqI != null) {
            return this.SqI.SqJ;
        }
        return null;
    }

    public static final class a {
        public j SqJ;

        public final m hqb() {
            AppMethodBeat.i(214678);
            if (this.SqJ == null) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("You're trying to build a TuringSMIJob with no TuringShieldConfigs, this is not allowed.");
                AppMethodBeat.o(214678);
                throw illegalArgumentException;
            }
            m mVar = new m(this, (byte) 0);
            AppMethodBeat.o(214678);
            return mVar;
        }
    }
}
