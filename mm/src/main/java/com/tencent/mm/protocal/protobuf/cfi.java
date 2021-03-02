package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class cfi extends a {
    public ade Mlu;
    public LinkedList<cft> Mlv = new LinkedList<>();
    public int cSx = 0;
    public String dNA;

    public cfi() {
        AppMethodBeat.i(220710);
        AppMethodBeat.o(220710);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220711);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mlu == null) {
                b bVar = new b("Not all required fields were included: idInfo");
                AppMethodBeat.o(220711);
                throw bVar;
            }
            if (this.Mlu != null) {
                aVar.ni(1, this.Mlu.computeSize());
                this.Mlu.writeFields(aVar);
            }
            aVar.aM(2, this.cSx);
            if (this.dNA != null) {
                aVar.e(3, this.dNA);
            }
            aVar.e(4, 8, this.Mlv);
            AppMethodBeat.o(220711);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.Mlu != null ? g.a.a.a.nh(1, this.Mlu.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.cSx);
            if (this.dNA != null) {
                nh += g.a.a.b.b.a.f(3, this.dNA);
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.Mlv);
            AppMethodBeat.o(220711);
            return c2;
        } else if (i2 == 2) {
            this.Mlv.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Mlu == null) {
                b bVar2 = new b("Not all required fields were included: idInfo");
                AppMethodBeat.o(220711);
                throw bVar2;
            }
            AppMethodBeat.o(220711);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cfi cfi = (cfi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ade ade = new ade();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ade.populateBuilderWithField(aVar4, ade, a.getNextFieldNumber(aVar4))) {
                        }
                        cfi.Mlu = ade;
                    }
                    AppMethodBeat.o(220711);
                    return 0;
                case 2:
                    cfi.cSx = aVar3.UbS.zi();
                    AppMethodBeat.o(220711);
                    return 0;
                case 3:
                    cfi.dNA = aVar3.UbS.readString();
                    AppMethodBeat.o(220711);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cft cft = new cft();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cft.populateBuilderWithField(aVar5, cft, a.getNextFieldNumber(aVar5))) {
                        }
                        cfi.Mlv.add(cft);
                    }
                    AppMethodBeat.o(220711);
                    return 0;
                default:
                    AppMethodBeat.o(220711);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220711);
            return -1;
        }
    }
}
