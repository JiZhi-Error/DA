package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bjf extends dop {
    public LinkedList<ccm> LSR = new LinkedList<>();
    public cco LST;
    public long LSU;

    public bjf() {
        AppMethodBeat.i(82406);
        AppMethodBeat.o(82406);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(82407);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.LSR);
            if (this.LST != null) {
                aVar.ni(4, this.LST.computeSize());
                this.LST.writeFields(aVar);
            }
            aVar.bb(5, this.LSU);
            AppMethodBeat.o(82407);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.LSR);
            if (this.LST != null) {
                nh += g.a.a.a.nh(4, this.LST.computeSize());
            }
            int r = nh + g.a.a.b.b.a.r(5, this.LSU);
            AppMethodBeat.o(82407);
            return r;
        } else if (i2 == 2) {
            this.LSR.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(82407);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bjf bjf = (bjf) objArr[1];
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
                        bjf.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(82407);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ccm ccm = new ccm();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ccm.populateBuilderWithField(aVar5, ccm, dop.getNextFieldNumber(aVar5))) {
                        }
                        bjf.LSR.add(ccm);
                    }
                    AppMethodBeat.o(82407);
                    return 0;
                case 3:
                default:
                    AppMethodBeat.o(82407);
                    return -1;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cco cco = new cco();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cco.populateBuilderWithField(aVar6, cco, dop.getNextFieldNumber(aVar6))) {
                        }
                        bjf.LST = cco;
                    }
                    AppMethodBeat.o(82407);
                    return 0;
                case 5:
                    bjf.LSU = aVar3.UbS.zl();
                    AppMethodBeat.o(82407);
                    return 0;
            }
        } else {
            AppMethodBeat.o(82407);
            return -1;
        }
    }
}
