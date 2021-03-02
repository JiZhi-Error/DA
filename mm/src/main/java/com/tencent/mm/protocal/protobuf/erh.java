package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class erh extends a {
    public LinkedList<cmu> GzC = new LinkedList<>();
    public long KPe;
    public LinkedList<aiv> MoI = new LinkedList<>();
    public csq NoU;
    public LinkedList<ehe> NoV = new LinkedList<>();

    public erh() {
        AppMethodBeat.i(110917);
        AppMethodBeat.o(110917);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110918);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.KPe);
            if (this.NoU != null) {
                aVar.ni(2, this.NoU.computeSize());
                this.NoU.writeFields(aVar);
            }
            aVar.e(3, 8, this.NoV);
            aVar.e(4, 8, this.MoI);
            aVar.e(5, 8, this.GzC);
            AppMethodBeat.o(110918);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.KPe) + 0;
            if (this.NoU != null) {
                r += g.a.a.a.nh(2, this.NoU.computeSize());
            }
            int c2 = r + g.a.a.a.c(3, 8, this.NoV) + g.a.a.a.c(4, 8, this.MoI) + g.a.a.a.c(5, 8, this.GzC);
            AppMethodBeat.o(110918);
            return c2;
        } else if (i2 == 2) {
            this.NoV.clear();
            this.MoI.clear();
            this.GzC.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(110918);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            erh erh = (erh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    erh.KPe = aVar3.UbS.zl();
                    AppMethodBeat.o(110918);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        csq csq = new csq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = csq.populateBuilderWithField(aVar4, csq, a.getNextFieldNumber(aVar4))) {
                        }
                        erh.NoU = csq;
                    }
                    AppMethodBeat.o(110918);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ehe ehe = new ehe();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ehe.populateBuilderWithField(aVar5, ehe, a.getNextFieldNumber(aVar5))) {
                        }
                        erh.NoV.add(ehe);
                    }
                    AppMethodBeat.o(110918);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aiv aiv = new aiv();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = aiv.populateBuilderWithField(aVar6, aiv, a.getNextFieldNumber(aVar6))) {
                        }
                        erh.MoI.add(aiv);
                    }
                    AppMethodBeat.o(110918);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cmu cmu = new cmu();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = cmu.populateBuilderWithField(aVar7, cmu, a.getNextFieldNumber(aVar7))) {
                        }
                        erh.GzC.add(cmu);
                    }
                    AppMethodBeat.o(110918);
                    return 0;
                default:
                    AppMethodBeat.o(110918);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110918);
            return -1;
        }
    }
}
