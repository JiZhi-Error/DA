package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class and extends a {
    public int ecL;
    public int index;
    public int pHw;
    public String query;
    public int scene;
    public String sessionId;
    public String tay;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127475);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.scene);
            aVar.aM(2, this.pHw);
            aVar.aM(3, this.index);
            if (this.sessionId != null) {
                aVar.e(4, this.sessionId);
            }
            if (this.query != null) {
                aVar.e(5, this.query);
            }
            if (this.tay != null) {
                aVar.e(6, this.tay);
            }
            aVar.aM(7, this.ecL);
            AppMethodBeat.o(127475);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.scene) + 0 + g.a.a.b.b.a.bu(2, this.pHw) + g.a.a.b.b.a.bu(3, this.index);
            if (this.sessionId != null) {
                bu += g.a.a.b.b.a.f(4, this.sessionId);
            }
            if (this.query != null) {
                bu += g.a.a.b.b.a.f(5, this.query);
            }
            if (this.tay != null) {
                bu += g.a.a.b.b.a.f(6, this.tay);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.ecL);
            AppMethodBeat.o(127475);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127475);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            and and = (and) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    and.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(127475);
                    return 0;
                case 2:
                    and.pHw = aVar3.UbS.zi();
                    AppMethodBeat.o(127475);
                    return 0;
                case 3:
                    and.index = aVar3.UbS.zi();
                    AppMethodBeat.o(127475);
                    return 0;
                case 4:
                    and.sessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(127475);
                    return 0;
                case 5:
                    and.query = aVar3.UbS.readString();
                    AppMethodBeat.o(127475);
                    return 0;
                case 6:
                    and.tay = aVar3.UbS.readString();
                    AppMethodBeat.o(127475);
                    return 0;
                case 7:
                    and.ecL = aVar3.UbS.zi();
                    AppMethodBeat.o(127475);
                    return 0;
                default:
                    AppMethodBeat.o(127475);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127475);
            return -1;
        }
    }
}
