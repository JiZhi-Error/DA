package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bnq extends dop {
    public String KCL;
    public String LWd;
    public String LWe;
    public rx LWf;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114787);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.LWd == null) {
                b bVar = new b("Not all required fields were included: FunctionMsgID");
                AppMethodBeat.o(114787);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LWd != null) {
                aVar.e(2, this.LWd);
            }
            if (this.LWe != null) {
                aVar.e(3, this.LWe);
            }
            if (this.KCL != null) {
                aVar.e(4, this.KCL);
            }
            if (this.LWf != null) {
                aVar.ni(5, this.LWf.computeSize());
                this.LWf.writeFields(aVar);
            }
            AppMethodBeat.o(114787);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LWd != null) {
                nh += g.a.a.b.b.a.f(2, this.LWd);
            }
            if (this.LWe != null) {
                nh += g.a.a.b.b.a.f(3, this.LWe);
            }
            if (this.KCL != null) {
                nh += g.a.a.b.b.a.f(4, this.KCL);
            }
            if (this.LWf != null) {
                nh += g.a.a.a.nh(5, this.LWf.computeSize());
            }
            AppMethodBeat.o(114787);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LWd == null) {
                b bVar2 = new b("Not all required fields were included: FunctionMsgID");
                AppMethodBeat.o(114787);
                throw bVar2;
            }
            AppMethodBeat.o(114787);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bnq bnq = (bnq) objArr[1];
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
                        bnq.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(114787);
                    return 0;
                case 2:
                    bnq.LWd = aVar3.UbS.readString();
                    AppMethodBeat.o(114787);
                    return 0;
                case 3:
                    bnq.LWe = aVar3.UbS.readString();
                    AppMethodBeat.o(114787);
                    return 0;
                case 4:
                    bnq.KCL = aVar3.UbS.readString();
                    AppMethodBeat.o(114787);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        rx rxVar = new rx();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = rxVar.populateBuilderWithField(aVar5, rxVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        bnq.LWf = rxVar;
                    }
                    AppMethodBeat.o(114787);
                    return 0;
                default:
                    AppMethodBeat.o(114787);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114787);
            return -1;
        }
    }
}
