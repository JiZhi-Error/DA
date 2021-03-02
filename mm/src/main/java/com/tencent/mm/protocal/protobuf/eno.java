package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eno extends dop {
    public int KMz;
    public String KPP;
    public LinkedList<cpb> Mnw = new LinkedList<>();
    public int Nlr;
    public int Nls;
    public LinkedList<cko> Nlt = new LinkedList<>();
    public String UserName;

    public eno() {
        AppMethodBeat.i(155474);
        AppMethodBeat.o(155474);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155475);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            aVar.aM(3, this.KMz);
            if (this.KPP != null) {
                aVar.e(4, this.KPP);
            }
            aVar.aM(5, this.Nlr);
            aVar.e(6, 8, this.Mnw);
            aVar.aM(7, this.Nls);
            aVar.e(8, 8, this.Nlt);
            AppMethodBeat.o(155475);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.UserName != null) {
                nh += g.a.a.b.b.a.f(2, this.UserName);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.KMz);
            if (this.KPP != null) {
                bu += g.a.a.b.b.a.f(4, this.KPP);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(5, this.Nlr) + g.a.a.a.c(6, 8, this.Mnw) + g.a.a.b.b.a.bu(7, this.Nls) + g.a.a.a.c(8, 8, this.Nlt);
            AppMethodBeat.o(155475);
            return bu2;
        } else if (i2 == 2) {
            this.Mnw.clear();
            this.Nlt.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155475);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eno eno = (eno) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        eno.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(155475);
                    return 0;
                case 2:
                    eno.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(155475);
                    return 0;
                case 3:
                    eno.KMz = aVar3.UbS.zi();
                    AppMethodBeat.o(155475);
                    return 0;
                case 4:
                    eno.KPP = aVar3.UbS.readString();
                    AppMethodBeat.o(155475);
                    return 0;
                case 5:
                    eno.Nlr = aVar3.UbS.zi();
                    AppMethodBeat.o(155475);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cpb cpb = new cpb();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cpb.populateBuilderWithField(aVar5, cpb, dop.getNextFieldNumber(aVar5))) {
                        }
                        eno.Mnw.add(cpb);
                    }
                    AppMethodBeat.o(155475);
                    return 0;
                case 7:
                    eno.Nls = aVar3.UbS.zi();
                    AppMethodBeat.o(155475);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cko cko = new cko();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cko.populateBuilderWithField(aVar6, cko, dop.getNextFieldNumber(aVar6))) {
                        }
                        eno.Nlt.add(cko);
                    }
                    AppMethodBeat.o(155475);
                    return 0;
                default:
                    AppMethodBeat.o(155475);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155475);
            return -1;
        }
    }
}
