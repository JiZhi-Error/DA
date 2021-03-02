package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fcl extends dop {
    public LinkedList<fcq> Nyp = new LinkedList<>();
    public dnf Nyq;

    public fcl() {
        AppMethodBeat.i(123689);
        AppMethodBeat.o(123689);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123690);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.Nyp);
            if (this.Nyq != null) {
                aVar.ni(3, this.Nyq.computeSize());
                this.Nyq.writeFields(aVar);
            }
            AppMethodBeat.o(123690);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.Nyp);
            if (this.Nyq != null) {
                nh += g.a.a.a.nh(3, this.Nyq.computeSize());
            }
            AppMethodBeat.o(123690);
            return nh;
        } else if (i2 == 2) {
            this.Nyp.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123690);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fcl fcl = (fcl) objArr[1];
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
                        fcl.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(123690);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fcq fcq = new fcq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fcq.populateBuilderWithField(aVar5, fcq, dop.getNextFieldNumber(aVar5))) {
                        }
                        fcl.Nyp.add(fcq);
                    }
                    AppMethodBeat.o(123690);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dnf dnf = new dnf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dnf.populateBuilderWithField(aVar6, dnf, dop.getNextFieldNumber(aVar6))) {
                        }
                        fcl.Nyq = dnf;
                    }
                    AppMethodBeat.o(123690);
                    return 0;
                default:
                    AppMethodBeat.o(123690);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123690);
            return -1;
        }
    }
}
