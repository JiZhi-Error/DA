package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class asy extends dpc {
    public int KBv;
    public LinkedList<axa> LAj = new LinkedList<>();
    public long LDN;
    public float LDT;
    public long LDU;
    public b LDs;
    public long ViH;
    public int tUC;

    public asy() {
        AppMethodBeat.i(209431);
        AppMethodBeat.o(209431);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209432);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.KBv);
            aVar.E(3, this.LDT);
            if (this.LDs != null) {
                aVar.c(4, this.LDs);
            }
            aVar.aM(5, this.tUC);
            aVar.e(6, 8, this.LAj);
            aVar.bb(7, this.LDU);
            aVar.bb(8, this.LDN);
            aVar.bb(9, this.ViH);
            AppMethodBeat.o(209432);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KBv) + g.a.a.b.b.a.fS(3) + 4;
            if (this.LDs != null) {
                nh += g.a.a.b.b.a.b(4, this.LDs);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.tUC) + g.a.a.a.c(6, 8, this.LAj) + g.a.a.b.b.a.r(7, this.LDU) + g.a.a.b.b.a.r(8, this.LDN) + g.a.a.b.b.a.r(9, this.ViH);
            AppMethodBeat.o(209432);
            return bu;
        } else if (i2 == 2) {
            this.LAj.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209432);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            asy asy = (asy) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        asy.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(209432);
                    return 0;
                case 2:
                    asy.KBv = aVar3.UbS.zi();
                    AppMethodBeat.o(209432);
                    return 0;
                case 3:
                    asy.LDT = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209432);
                    return 0;
                case 4:
                    asy.LDs = aVar3.UbS.hPo();
                    AppMethodBeat.o(209432);
                    return 0;
                case 5:
                    asy.tUC = aVar3.UbS.zi();
                    AppMethodBeat.o(209432);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        axa axa = new axa();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = axa.populateBuilderWithField(aVar5, axa, dpc.getNextFieldNumber(aVar5))) {
                        }
                        asy.LAj.add(axa);
                    }
                    AppMethodBeat.o(209432);
                    return 0;
                case 7:
                    asy.LDU = aVar3.UbS.zl();
                    AppMethodBeat.o(209432);
                    return 0;
                case 8:
                    asy.LDN = aVar3.UbS.zl();
                    AppMethodBeat.o(209432);
                    return 0;
                case 9:
                    asy.ViH = aVar3.UbS.zl();
                    AppMethodBeat.o(209432);
                    return 0;
                default:
                    AppMethodBeat.o(209432);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209432);
            return -1;
        }
    }
}
