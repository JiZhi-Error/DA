package com.tencent.i.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends a {
    private c SqM;

    public e(c cVar, String str) {
        super(str, (byte) 0);
        AppMethodBeat.i(214684);
        this.SqM = cVar;
        if (this.SqM != null) {
            this.SqM.SqQ = this;
        }
        AppMethodBeat.o(214684);
    }

    @Override // com.tencent.i.a.a.a
    public final void q(Throwable th) {
        AppMethodBeat.i(214685);
        if (!(this.SqM == null || this.SqM.SqP == null)) {
            this.SqM.SqP.b(th, "turing async worker");
        }
        AppMethodBeat.o(214685);
    }
}
