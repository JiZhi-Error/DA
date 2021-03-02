package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class dqi extends a {
    public String MTo;
    public boolean MTp;

    @Override // com.tencent.mm.bw.a
    public final /* bridge */ /* synthetic */ a validate() {
        return this;
    }

    public final dqi bhy(String str) {
        this.MTo = str;
        this.MTp = true;
        return this;
    }

    @Override // com.tencent.mm.bw.a
    public final int computeSize() {
        AppMethodBeat.i(2387);
        int i2 = 0;
        if (this.MTp) {
            i2 = g.a.a.b.b.a.f(1, this.MTo) + 0;
        }
        int i3 = i2 + 0;
        AppMethodBeat.o(2387);
        return i3;
    }

    @Override // com.tencent.mm.bw.a
    public final byte[] toByteArray() {
        AppMethodBeat.i(2388);
        byte[] byteArray = super.toByteArray();
        AppMethodBeat.o(2388);
        return byteArray;
    }

    @Override // com.tencent.mm.bw.a
    public final void writeFields(g.a.a.c.a aVar) {
        AppMethodBeat.i(2389);
        if (this.MTp) {
            aVar.e(1, this.MTo);
        }
        AppMethodBeat.o(2389);
    }

    @Override // com.tencent.mm.bw.a
    public final boolean populateBuilderWithField(g.a.a.a.a aVar, a aVar2, int i2) {
        AppMethodBeat.i(2390);
        dqi dqi = (dqi) aVar2;
        boolean z = true;
        switch (i2) {
            case 1:
                dqi.bhy(aVar.UbS.readString());
                break;
            default:
                z = false;
                break;
        }
        AppMethodBeat.o(2390);
        return z;
    }

    public final String toString() {
        return this.MTo;
    }

    @Override // com.tencent.mm.bw.a
    public final /* synthetic */ a parseFrom(byte[] bArr) {
        AppMethodBeat.i(2391);
        g.a.a.a.a aVar = new g.a.a.a.a(bArr, unknownTagHandler);
        for (int nextFieldNumber = getNextFieldNumber(aVar); nextFieldNumber > 0; nextFieldNumber = getNextFieldNumber(aVar)) {
            if (!populateBuilderWithField(aVar, this, nextFieldNumber)) {
                aVar.hPl();
            }
        }
        AppMethodBeat.o(2391);
        return this;
    }
}
