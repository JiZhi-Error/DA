package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cxw extends dpc {
    public String APx;
    public String MCI;
    public cxz MCM;
    public LinkedList<cxw> MCN = new LinkedList<>();
    public int MCO;
    public String type;

    public cxw() {
        AppMethodBeat.i(117539);
        AppMethodBeat.o(117539);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117540);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.MCM != null) {
                aVar.ni(2, this.MCM.computeSize());
                this.MCM.writeFields(aVar);
            }
            if (this.MCI != null) {
                aVar.e(3, this.MCI);
            }
            if (this.APx != null) {
                aVar.e(4, this.APx);
            }
            if (this.type != null) {
                aVar.e(5, this.type);
            }
            aVar.e(6, 8, this.MCN);
            aVar.aM(7, this.MCO);
            AppMethodBeat.o(117540);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.MCM != null) {
                nh += g.a.a.a.nh(2, this.MCM.computeSize());
            }
            if (this.MCI != null) {
                nh += g.a.a.b.b.a.f(3, this.MCI);
            }
            if (this.APx != null) {
                nh += g.a.a.b.b.a.f(4, this.APx);
            }
            if (this.type != null) {
                nh += g.a.a.b.b.a.f(5, this.type);
            }
            int c2 = nh + g.a.a.a.c(6, 8, this.MCN) + g.a.a.b.b.a.bu(7, this.MCO);
            AppMethodBeat.o(117540);
            return c2;
        } else if (i2 == 2) {
            this.MCN.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117540);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cxw cxw = (cxw) objArr[1];
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
                        cxw.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(117540);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cxz cxz = new cxz();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cxz.populateBuilderWithField(aVar5, cxz, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cxw.MCM = cxz;
                    }
                    AppMethodBeat.o(117540);
                    return 0;
                case 3:
                    cxw.MCI = aVar3.UbS.readString();
                    AppMethodBeat.o(117540);
                    return 0;
                case 4:
                    cxw.APx = aVar3.UbS.readString();
                    AppMethodBeat.o(117540);
                    return 0;
                case 5:
                    cxw.type = aVar3.UbS.readString();
                    AppMethodBeat.o(117540);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cxw cxw2 = new cxw();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cxw2.populateBuilderWithField(aVar6, cxw2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        cxw.MCN.add(cxw2);
                    }
                    AppMethodBeat.o(117540);
                    return 0;
                case 7:
                    cxw.MCO = aVar3.UbS.zi();
                    AppMethodBeat.o(117540);
                    return 0;
                default:
                    AppMethodBeat.o(117540);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117540);
            return -1;
        }
    }
}
