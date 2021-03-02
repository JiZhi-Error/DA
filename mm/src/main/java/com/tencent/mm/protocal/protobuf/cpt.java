package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cpt extends dop {
    public int KGZ;
    public LinkedList<cpv> KOH = new LinkedList<>();
    public int MvK;
    public LinkedList<cps> MvL = new LinkedList<>();
    public int MvM;
    public String MvN;
    public int Scene;

    public cpt() {
        AppMethodBeat.i(127498);
        AppMethodBeat.o(127498);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127499);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.KGZ);
            aVar.aM(3, this.MvK);
            aVar.e(4, 8, this.MvL);
            aVar.aM(5, this.MvM);
            aVar.e(6, 8, this.KOH);
            if (this.MvN != null) {
                aVar.e(7, this.MvN);
            }
            aVar.aM(8, this.Scene);
            AppMethodBeat.o(127499);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KGZ) + g.a.a.b.b.a.bu(3, this.MvK) + g.a.a.a.c(4, 8, this.MvL) + g.a.a.b.b.a.bu(5, this.MvM) + g.a.a.a.c(6, 8, this.KOH);
            if (this.MvN != null) {
                nh += g.a.a.b.b.a.f(7, this.MvN);
            }
            int bu = nh + g.a.a.b.b.a.bu(8, this.Scene);
            AppMethodBeat.o(127499);
            return bu;
        } else if (i2 == 2) {
            this.MvL.clear();
            this.KOH.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127499);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cpt cpt = (cpt) objArr[1];
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
                        cpt.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(127499);
                    return 0;
                case 2:
                    cpt.KGZ = aVar3.UbS.zi();
                    AppMethodBeat.o(127499);
                    return 0;
                case 3:
                    cpt.MvK = aVar3.UbS.zi();
                    AppMethodBeat.o(127499);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cps cps = new cps();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cps.populateBuilderWithField(aVar5, cps, dop.getNextFieldNumber(aVar5))) {
                        }
                        cpt.MvL.add(cps);
                    }
                    AppMethodBeat.o(127499);
                    return 0;
                case 5:
                    cpt.MvM = aVar3.UbS.zi();
                    AppMethodBeat.o(127499);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cpv cpv = new cpv();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cpv.populateBuilderWithField(aVar6, cpv, dop.getNextFieldNumber(aVar6))) {
                        }
                        cpt.KOH.add(cpv);
                    }
                    AppMethodBeat.o(127499);
                    return 0;
                case 7:
                    cpt.MvN = aVar3.UbS.readString();
                    AppMethodBeat.o(127499);
                    return 0;
                case 8:
                    cpt.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(127499);
                    return 0;
                default:
                    AppMethodBeat.o(127499);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127499);
            return -1;
        }
    }
}
