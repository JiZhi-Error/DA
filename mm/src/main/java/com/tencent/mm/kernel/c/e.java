package com.tencent.mm.kernel.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.c.a;

public final class e<T extends a> implements b, c<T> {
    private T htG;

    public e(T t) {
        this.htG = t;
    }

    @Override // com.tencent.mm.kernel.c.c
    public final T aBe() {
        return this.htG;
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBc() {
        AppMethodBeat.i(157490);
        if (this.htG instanceof b) {
            ((b) this.htG).aBc();
        }
        AppMethodBeat.o(157490);
    }

    @Override // com.tencent.mm.kernel.c.b
    public final void aBd() {
        AppMethodBeat.i(157491);
        if (this.htG instanceof b) {
            ((b) this.htG).aBd();
        }
        AppMethodBeat.o(157491);
    }
}
