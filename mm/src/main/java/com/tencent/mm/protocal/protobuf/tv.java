package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class tv extends a {
    public String CeI;
    public LinkedList<sy> Lbb = new LinkedList<>();
    public erc Lce;
    public int Lcf;
    public int Lcg;

    public tv() {
        AppMethodBeat.i(218978);
        AppMethodBeat.o(218978);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(218979);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lce == null) {
                b bVar = new b("Not all required fields were included: matrix");
                AppMethodBeat.o(218979);
                throw bVar;
            }
            aVar.e(1, 8, this.Lbb);
            if (this.Lce != null) {
                aVar.ni(2, this.Lce.computeSize());
                this.Lce.writeFields(aVar);
            }
            aVar.aM(3, this.Lcf);
            aVar.aM(4, this.Lcg);
            if (this.CeI != null) {
                aVar.e(5, this.CeI);
            }
            AppMethodBeat.o(218979);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.Lbb) + 0;
            if (this.Lce != null) {
                c2 += g.a.a.a.nh(2, this.Lce.computeSize());
            }
            int bu = c2 + g.a.a.b.b.a.bu(3, this.Lcf) + g.a.a.b.b.a.bu(4, this.Lcg);
            if (this.CeI != null) {
                bu += g.a.a.b.b.a.f(5, this.CeI);
            }
            AppMethodBeat.o(218979);
            return bu;
        } else if (i2 == 2) {
            this.Lbb.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lce == null) {
                b bVar2 = new b("Not all required fields were included: matrix");
                AppMethodBeat.o(218979);
                throw bVar2;
            }
            AppMethodBeat.o(218979);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            tv tvVar = (tv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        sy syVar = new sy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = syVar.populateBuilderWithField(aVar4, syVar, a.getNextFieldNumber(aVar4))) {
                        }
                        tvVar.Lbb.add(syVar);
                    }
                    AppMethodBeat.o(218979);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        erc erc = new erc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = erc.populateBuilderWithField(aVar5, erc, a.getNextFieldNumber(aVar5))) {
                        }
                        tvVar.Lce = erc;
                    }
                    AppMethodBeat.o(218979);
                    return 0;
                case 3:
                    tvVar.Lcf = aVar3.UbS.zi();
                    AppMethodBeat.o(218979);
                    return 0;
                case 4:
                    tvVar.Lcg = aVar3.UbS.zi();
                    AppMethodBeat.o(218979);
                    return 0;
                case 5:
                    tvVar.CeI = aVar3.UbS.readString();
                    AppMethodBeat.o(218979);
                    return 0;
                default:
                    AppMethodBeat.o(218979);
                    return -1;
            }
        } else {
            AppMethodBeat.o(218979);
            return -1;
        }
    }
}
