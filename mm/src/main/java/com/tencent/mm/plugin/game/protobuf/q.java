package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class q extends a {
    public String Name;
    public String xIB;
    public String xIJ;
    public int xJC;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41717);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Name == null) {
                b bVar = new b("Not all required fields were included: Name");
                AppMethodBeat.o(41717);
                throw bVar;
            } else if (this.xIJ == null) {
                b bVar2 = new b("Not all required fields were included: IconURL");
                AppMethodBeat.o(41717);
                throw bVar2;
            } else {
                aVar.aM(1, this.xJC);
                if (this.Name != null) {
                    aVar.e(2, this.Name);
                }
                if (this.xIJ != null) {
                    aVar.e(3, this.xIJ);
                }
                if (this.xIB != null) {
                    aVar.e(4, this.xIB);
                }
                AppMethodBeat.o(41717);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.xJC) + 0;
            if (this.Name != null) {
                bu += g.a.a.b.b.a.f(2, this.Name);
            }
            if (this.xIJ != null) {
                bu += g.a.a.b.b.a.f(3, this.xIJ);
            }
            if (this.xIB != null) {
                bu += g.a.a.b.b.a.f(4, this.xIB);
            }
            AppMethodBeat.o(41717);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Name == null) {
                b bVar3 = new b("Not all required fields were included: Name");
                AppMethodBeat.o(41717);
                throw bVar3;
            } else if (this.xIJ == null) {
                b bVar4 = new b("Not all required fields were included: IconURL");
                AppMethodBeat.o(41717);
                throw bVar4;
            } else {
                AppMethodBeat.o(41717);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    qVar.xJC = aVar3.UbS.zi();
                    AppMethodBeat.o(41717);
                    return 0;
                case 2:
                    qVar.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(41717);
                    return 0;
                case 3:
                    qVar.xIJ = aVar3.UbS.readString();
                    AppMethodBeat.o(41717);
                    return 0;
                case 4:
                    qVar.xIB = aVar3.UbS.readString();
                    AppMethodBeat.o(41717);
                    return 0;
                default:
                    AppMethodBeat.o(41717);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41717);
            return -1;
        }
    }
}
