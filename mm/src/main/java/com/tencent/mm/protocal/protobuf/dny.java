package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dny extends dop {
    public int KYp;
    public String MBV;
    public b MQS;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72579);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MQS != null) {
                aVar.c(2, this.MQS);
            }
            if (this.MBV != null) {
                aVar.e(3, this.MBV);
            }
            aVar.aM(4, this.KYp);
            AppMethodBeat.o(72579);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MQS != null) {
                nh += g.a.a.b.b.a.b(2, this.MQS);
            }
            if (this.MBV != null) {
                nh += g.a.a.b.b.a.f(3, this.MBV);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.KYp);
            AppMethodBeat.o(72579);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72579);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dny dny = (dny) objArr[1];
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
                        dny.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72579);
                    return 0;
                case 2:
                    dny.MQS = aVar3.UbS.hPo();
                    AppMethodBeat.o(72579);
                    return 0;
                case 3:
                    dny.MBV = aVar3.UbS.readString();
                    AppMethodBeat.o(72579);
                    return 0;
                case 4:
                    dny.KYp = aVar3.UbS.zi();
                    AppMethodBeat.o(72579);
                    return 0;
                default:
                    AppMethodBeat.o(72579);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72579);
            return -1;
        }
    }
}
