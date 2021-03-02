package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dy extends a {
    public LinkedList<ec> xNq = new LinkedList<>();
    public dz xNr;
    public String xNs;
    public String xNt;

    public dy() {
        AppMethodBeat.i(256648);
        AppMethodBeat.o(256648);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256649);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.xNq);
            if (this.xNr != null) {
                aVar.ni(2, this.xNr.computeSize());
                this.xNr.writeFields(aVar);
            }
            if (this.xNs != null) {
                aVar.e(3, this.xNs);
            }
            if (this.xNt != null) {
                aVar.e(4, this.xNt);
            }
            AppMethodBeat.o(256649);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.xNq) + 0;
            if (this.xNr != null) {
                c2 += g.a.a.a.nh(2, this.xNr.computeSize());
            }
            if (this.xNs != null) {
                c2 += g.a.a.b.b.a.f(3, this.xNs);
            }
            if (this.xNt != null) {
                c2 += g.a.a.b.b.a.f(4, this.xNt);
            }
            AppMethodBeat.o(256649);
            return c2;
        } else if (i2 == 2) {
            this.xNq.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256649);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dy dyVar = (dy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ec ecVar = new ec();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ecVar.populateBuilderWithField(aVar4, ecVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dyVar.xNq.add(ecVar);
                    }
                    AppMethodBeat.o(256649);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dz dzVar = new dz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dzVar.populateBuilderWithField(aVar5, dzVar, a.getNextFieldNumber(aVar5))) {
                        }
                        dyVar.xNr = dzVar;
                    }
                    AppMethodBeat.o(256649);
                    return 0;
                case 3:
                    dyVar.xNs = aVar3.UbS.readString();
                    AppMethodBeat.o(256649);
                    return 0;
                case 4:
                    dyVar.xNt = aVar3.UbS.readString();
                    AppMethodBeat.o(256649);
                    return 0;
                default:
                    AppMethodBeat.o(256649);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256649);
            return -1;
        }
    }
}
