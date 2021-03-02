package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cuq extends dop {
    public int KRg;
    public int MzW;
    public LinkedList<cus> MzX = new LinkedList<>();
    public LinkedList<cup> MzY = new LinkedList<>();
    public int source;

    public cuq() {
        AppMethodBeat.i(6413);
        AppMethodBeat.o(6413);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(6414);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.MzW);
            aVar.aM(3, this.KRg);
            aVar.e(4, 8, this.MzX);
            aVar.e(5, 8, this.MzY);
            aVar.aM(6, this.source);
            AppMethodBeat.o(6414);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MzW) + g.a.a.b.b.a.bu(3, this.KRg) + g.a.a.a.c(4, 8, this.MzX) + g.a.a.a.c(5, 8, this.MzY) + g.a.a.b.b.a.bu(6, this.source);
            AppMethodBeat.o(6414);
            return nh;
        } else if (i2 == 2) {
            this.MzX.clear();
            this.MzY.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(6414);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cuq cuq = (cuq) objArr[1];
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
                        cuq.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(6414);
                    return 0;
                case 2:
                    cuq.MzW = aVar3.UbS.zi();
                    AppMethodBeat.o(6414);
                    return 0;
                case 3:
                    cuq.KRg = aVar3.UbS.zi();
                    AppMethodBeat.o(6414);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cus cus = new cus();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cus.populateBuilderWithField(aVar5, cus, dop.getNextFieldNumber(aVar5))) {
                        }
                        cuq.MzX.add(cus);
                    }
                    AppMethodBeat.o(6414);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cup cup = new cup();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cup.populateBuilderWithField(aVar6, cup, dop.getNextFieldNumber(aVar6))) {
                        }
                        cuq.MzY.add(cup);
                    }
                    AppMethodBeat.o(6414);
                    return 0;
                case 6:
                    cuq.source = aVar3.UbS.zi();
                    AppMethodBeat.o(6414);
                    return 0;
                default:
                    AppMethodBeat.o(6414);
                    return -1;
            }
        } else {
            AppMethodBeat.o(6414);
            return -1;
        }
    }
}
