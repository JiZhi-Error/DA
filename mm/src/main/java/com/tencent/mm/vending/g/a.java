package com.tencent.mm.vending.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements b {
    @Override // com.tencent.mm.vending.g.b
    public final void ej(Object obj) {
        AppMethodBeat.i(74800);
        com.tencent.mm.vending.f.a.w("Vending.DummyMario", "call DummyMario interrupt()", new Object[0]);
        AppMethodBeat.o(74800);
    }

    @Override // com.tencent.mm.vending.g.b
    public final void hdw() {
        AppMethodBeat.i(74801);
        com.tencent.mm.vending.f.a.w("Vending.DummyMario", "call DummyMario pending()", new Object[0]);
        AppMethodBeat.o(74801);
    }

    @Override // com.tencent.mm.vending.g.b
    public final void G(Object... objArr) {
        AppMethodBeat.i(74802);
        com.tencent.mm.vending.f.a.w("Vending.DummyMario", "call DummyMario wormhole()", new Object[0]);
        AppMethodBeat.o(74802);
    }

    @Override // com.tencent.mm.vending.g.b
    public final void resume() {
        AppMethodBeat.i(74803);
        com.tencent.mm.vending.f.a.w("Vending.DummyMario", "call DummyMario resume()", new Object[0]);
        AppMethodBeat.o(74803);
    }
}
