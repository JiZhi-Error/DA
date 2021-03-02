package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dot extends dpc {
    public String MBB;
    public int MBD;
    public String MBO;
    public int MRX;
    public int MRY;
    public String wFL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91672);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91672);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.wFL != null) {
                aVar.e(2, this.wFL);
            }
            if (this.MBB != null) {
                aVar.e(3, this.MBB);
            }
            aVar.aM(4, this.MRX);
            aVar.aM(5, this.MRY);
            aVar.aM(6, this.MBD);
            if (this.MBO != null) {
                aVar.e(7, this.MBO);
            }
            AppMethodBeat.o(91672);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.wFL != null) {
                nh += g.a.a.b.b.a.f(2, this.wFL);
            }
            if (this.MBB != null) {
                nh += g.a.a.b.b.a.f(3, this.MBB);
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.MRX) + g.a.a.b.b.a.bu(5, this.MRY) + g.a.a.b.b.a.bu(6, this.MBD);
            if (this.MBO != null) {
                bu += g.a.a.b.b.a.f(7, this.MBO);
            }
            AppMethodBeat.o(91672);
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
                AppMethodBeat.o(91672);
                throw bVar2;
            }
            AppMethodBeat.o(91672);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dot dot = (dot) objArr[1];
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
                        dot.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91672);
                    return 0;
                case 2:
                    dot.wFL = aVar3.UbS.readString();
                    AppMethodBeat.o(91672);
                    return 0;
                case 3:
                    dot.MBB = aVar3.UbS.readString();
                    AppMethodBeat.o(91672);
                    return 0;
                case 4:
                    dot.MRX = aVar3.UbS.zi();
                    AppMethodBeat.o(91672);
                    return 0;
                case 5:
                    dot.MRY = aVar3.UbS.zi();
                    AppMethodBeat.o(91672);
                    return 0;
                case 6:
                    dot.MBD = aVar3.UbS.zi();
                    AppMethodBeat.o(91672);
                    return 0;
                case 7:
                    dot.MBO = aVar3.UbS.readString();
                    AppMethodBeat.o(91672);
                    return 0;
                default:
                    AppMethodBeat.o(91672);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91672);
            return -1;
        }
    }
}
