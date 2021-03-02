package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class dqj extends a {
    public int MTq;
    private boolean MTr;

    @Override // com.tencent.mm.bw.a
    public final /* synthetic */ a validate() {
        AppMethodBeat.i(2386);
        dqj gul = gul();
        AppMethodBeat.o(2386);
        return gul;
    }

    public final dqj ajp(int i2) {
        this.MTq = i2;
        this.MTr = true;
        return this;
    }

    public final String toString() {
        AppMethodBeat.i(2379);
        String str = (("" + getClass().getName() + "(") + "uiVal = " + this.MTq + "   ") + ")";
        AppMethodBeat.o(2379);
        return str;
    }

    private dqj gul() {
        AppMethodBeat.i(2380);
        if (!this.MTr) {
            b bVar = new b("Not all required fields were included (false = not included in message),  uiVal:" + this.MTr);
            AppMethodBeat.o(2380);
            throw bVar;
        }
        AppMethodBeat.o(2380);
        return this;
    }

    @Override // com.tencent.mm.bw.a
    public final int computeSize() {
        AppMethodBeat.i(2381);
        int bu = g.a.a.b.b.a.bu(1, this.MTq) + 0 + 0;
        AppMethodBeat.o(2381);
        return bu;
    }

    @Override // com.tencent.mm.bw.a
    public final byte[] toByteArray() {
        AppMethodBeat.i(2382);
        gul();
        byte[] byteArray = super.toByteArray();
        AppMethodBeat.o(2382);
        return byteArray;
    }

    @Override // com.tencent.mm.bw.a
    public final void writeFields(g.a.a.c.a aVar) {
        AppMethodBeat.i(2383);
        aVar.aM(1, this.MTq);
        AppMethodBeat.o(2383);
    }

    @Override // com.tencent.mm.bw.a
    public final boolean populateBuilderWithField(g.a.a.a.a aVar, a aVar2, int i2) {
        AppMethodBeat.i(2384);
        dqj dqj = (dqj) aVar2;
        boolean z = true;
        switch (i2) {
            case 1:
                dqj.ajp(aVar.UbS.zi());
                break;
            default:
                z = false;
                break;
        }
        AppMethodBeat.o(2384);
        return z;
    }

    @Override // com.tencent.mm.bw.a
    public final /* synthetic */ a parseFrom(byte[] bArr) {
        AppMethodBeat.i(2385);
        g.a.a.a.a aVar = new g.a.a.a.a(bArr, unknownTagHandler);
        for (int nextFieldNumber = getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = getNextFieldNumber(aVar)) {
            if (!populateBuilderWithField(aVar, this, nextFieldNumber)) {
                aVar.hPl();
            }
        }
        dqj gul = gul();
        AppMethodBeat.o(2385);
        return gul;
    }
}
