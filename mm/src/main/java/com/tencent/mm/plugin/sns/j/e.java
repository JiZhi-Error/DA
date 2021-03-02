package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.protocal.protobuf.dzj;
import g.a.a.b;
import java.util.LinkedList;

public final class e extends a {
    public dzj DIb;
    public String DRR;
    public int DRS;
    public String DRT;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(96156);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.DRR == null) {
                b bVar = new b("Not all required fields were included: clientID");
                AppMethodBeat.o(96156);
                throw bVar;
            } else if (this.DIb == null) {
                b bVar2 = new b("Not all required fields were included: actionGroup");
                AppMethodBeat.o(96156);
                throw bVar2;
            } else {
                if (this.DRR != null) {
                    aVar.e(1, this.DRR);
                }
                if (this.DIb != null) {
                    aVar.ni(2, this.DIb.computeSize());
                    this.DIb.writeFields(aVar);
                }
                aVar.aM(3, this.DRS);
                if (this.DRT != null) {
                    aVar.e(4, this.DRT);
                }
                AppMethodBeat.o(96156);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.DRR != null ? g.a.a.b.b.a.f(1, this.DRR) + 0 : 0;
            if (this.DIb != null) {
                f2 += g.a.a.a.nh(2, this.DIb.computeSize());
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.DRS);
            if (this.DRT != null) {
                bu += g.a.a.b.b.a.f(4, this.DRT);
            }
            AppMethodBeat.o(96156);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.DRR == null) {
                b bVar3 = new b("Not all required fields were included: clientID");
                AppMethodBeat.o(96156);
                throw bVar3;
            } else if (this.DIb == null) {
                b bVar4 = new b("Not all required fields were included: actionGroup");
                AppMethodBeat.o(96156);
                throw bVar4;
            } else {
                AppMethodBeat.o(96156);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.DRR = aVar3.UbS.readString();
                    AppMethodBeat.o(96156);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dzj dzj = new dzj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dzj.populateBuilderWithField(aVar4, dzj, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.DIb = dzj;
                    }
                    AppMethodBeat.o(96156);
                    return 0;
                case 3:
                    eVar.DRS = aVar3.UbS.zi();
                    AppMethodBeat.o(96156);
                    return 0;
                case 4:
                    eVar.DRT = aVar3.UbS.readString();
                    AppMethodBeat.o(96156);
                    return 0;
                default:
                    AppMethodBeat.o(96156);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96156);
            return -1;
        }
    }
}
