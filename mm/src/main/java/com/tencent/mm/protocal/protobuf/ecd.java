package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ecd extends a {
    public int NbF;
    public esq NbG;
    public int Ncl;
    public int Ncm;
    public int Ncn;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115855);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NbG == null) {
                b bVar = new b("Not all required fields were included: Addr");
                AppMethodBeat.o(115855);
                throw bVar;
            }
            if (this.NbG != null) {
                aVar.ni(1, this.NbG.computeSize());
                this.NbG.writeFields(aVar);
            }
            aVar.aM(2, this.NbF);
            aVar.aM(3, this.Ncl);
            aVar.aM(4, this.Ncm);
            aVar.aM(5, this.Ncn);
            AppMethodBeat.o(115855);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.NbG != null ? g.a.a.a.nh(1, this.NbG.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.NbF) + g.a.a.b.b.a.bu(3, this.Ncl) + g.a.a.b.b.a.bu(4, this.Ncm) + g.a.a.b.b.a.bu(5, this.Ncn);
            AppMethodBeat.o(115855);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NbG == null) {
                b bVar2 = new b("Not all required fields were included: Addr");
                AppMethodBeat.o(115855);
                throw bVar2;
            }
            AppMethodBeat.o(115855);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ecd ecd = (ecd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        esq esq = new esq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = esq.populateBuilderWithField(aVar4, esq, a.getNextFieldNumber(aVar4))) {
                        }
                        ecd.NbG = esq;
                    }
                    AppMethodBeat.o(115855);
                    return 0;
                case 2:
                    ecd.NbF = aVar3.UbS.zi();
                    AppMethodBeat.o(115855);
                    return 0;
                case 3:
                    ecd.Ncl = aVar3.UbS.zi();
                    AppMethodBeat.o(115855);
                    return 0;
                case 4:
                    ecd.Ncm = aVar3.UbS.zi();
                    AppMethodBeat.o(115855);
                    return 0;
                case 5:
                    ecd.Ncn = aVar3.UbS.zi();
                    AppMethodBeat.o(115855);
                    return 0;
                default:
                    AppMethodBeat.o(115855);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115855);
            return -1;
        }
    }
}
