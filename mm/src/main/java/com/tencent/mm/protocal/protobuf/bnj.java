package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bnj extends dpc {
    public String HZQ;
    public int LVW;
    public String LVX;
    public int pTZ;
    public String pUa;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(186725);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(186725);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            aVar.aM(4, this.LVW);
            if (this.LVX != null) {
                aVar.e(5, this.LVX);
            }
            if (this.HZQ != null) {
                aVar.e(6, this.HZQ);
            }
            AppMethodBeat.o(186725);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.LVW);
            if (this.LVX != null) {
                bu += g.a.a.b.b.a.f(5, this.LVX);
            }
            if (this.HZQ != null) {
                bu += g.a.a.b.b.a.f(6, this.HZQ);
            }
            AppMethodBeat.o(186725);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(186725);
                throw bVar2;
            }
            AppMethodBeat.o(186725);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bnj bnj = (bnj) objArr[1];
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
                        bnj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(186725);
                    return 0;
                case 2:
                    bnj.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(186725);
                    return 0;
                case 3:
                    bnj.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(186725);
                    return 0;
                case 4:
                    bnj.LVW = aVar3.UbS.zi();
                    AppMethodBeat.o(186725);
                    return 0;
                case 5:
                    bnj.LVX = aVar3.UbS.readString();
                    AppMethodBeat.o(186725);
                    return 0;
                case 6:
                    bnj.HZQ = aVar3.UbS.readString();
                    AppMethodBeat.o(186725);
                    return 0;
                default:
                    AppMethodBeat.o(186725);
                    return -1;
            }
        } else {
            AppMethodBeat.o(186725);
            return -1;
        }
    }
}