package com.tencent.mm.plugin.backup.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class d extends a {
    public String ID;
    public h oTn;
    public int oTo;
    public int oTp;
    public int oTq;
    public int oTr;
    public int oTs;
    public int oTt;
    public int oTu;
    public int oTv;
    public int oTw;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(22104);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ID == null) {
                b bVar = new b("Not all required fields were included: ID");
                AppMethodBeat.o(22104);
                throw bVar;
            }
            if (this.ID != null) {
                aVar.e(1, this.ID);
            }
            if (this.oTn != null) {
                aVar.ni(2, this.oTn.computeSize());
                this.oTn.writeFields(aVar);
            }
            aVar.aM(3, this.oTo);
            aVar.aM(4, this.oTp);
            aVar.aM(5, this.oTq);
            aVar.aM(6, this.oTr);
            aVar.aM(7, this.oTs);
            aVar.aM(8, this.oTt);
            aVar.aM(9, this.oTu);
            aVar.aM(10, this.oTv);
            aVar.aM(11, this.oTw);
            AppMethodBeat.o(22104);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.ID != null ? g.a.a.b.b.a.f(1, this.ID) + 0 : 0;
            if (this.oTn != null) {
                f2 += g.a.a.a.nh(2, this.oTn.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.oTo) + g.a.a.b.b.a.bu(4, this.oTp) + g.a.a.b.b.a.bu(5, this.oTq) + g.a.a.b.b.a.bu(6, this.oTr) + g.a.a.b.b.a.bu(7, this.oTs) + g.a.a.b.b.a.bu(8, this.oTt) + g.a.a.b.b.a.bu(9, this.oTu) + g.a.a.b.b.a.bu(10, this.oTv) + g.a.a.b.b.a.bu(11, this.oTw);
            AppMethodBeat.o(22104);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.ID == null) {
                b bVar2 = new b("Not all required fields were included: ID");
                AppMethodBeat.o(22104);
                throw bVar2;
            }
            AppMethodBeat.o(22104);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dVar.ID = aVar3.UbS.readString();
                    AppMethodBeat.o(22104);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        h hVar = new h();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = hVar.populateBuilderWithField(aVar4, hVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.oTn = hVar;
                    }
                    AppMethodBeat.o(22104);
                    return 0;
                case 3:
                    dVar.oTo = aVar3.UbS.zi();
                    AppMethodBeat.o(22104);
                    return 0;
                case 4:
                    dVar.oTp = aVar3.UbS.zi();
                    AppMethodBeat.o(22104);
                    return 0;
                case 5:
                    dVar.oTq = aVar3.UbS.zi();
                    AppMethodBeat.o(22104);
                    return 0;
                case 6:
                    dVar.oTr = aVar3.UbS.zi();
                    AppMethodBeat.o(22104);
                    return 0;
                case 7:
                    dVar.oTs = aVar3.UbS.zi();
                    AppMethodBeat.o(22104);
                    return 0;
                case 8:
                    dVar.oTt = aVar3.UbS.zi();
                    AppMethodBeat.o(22104);
                    return 0;
                case 9:
                    dVar.oTu = aVar3.UbS.zi();
                    AppMethodBeat.o(22104);
                    return 0;
                case 10:
                    dVar.oTv = aVar3.UbS.zi();
                    AppMethodBeat.o(22104);
                    return 0;
                case 11:
                    dVar.oTw = aVar3.UbS.zi();
                    AppMethodBeat.o(22104);
                    return 0;
                default:
                    AppMethodBeat.o(22104);
                    return -1;
            }
        } else {
            AppMethodBeat.o(22104);
            return -1;
        }
    }
}
