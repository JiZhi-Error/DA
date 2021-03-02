package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public class zm extends dpc {
    public int KXC;
    public b LkM;
    public b LkN;
    public b LkO;
    public b LkP;
    public int version;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225288);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(225288);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.LkM != null) {
                aVar.c(2, this.LkM);
            }
            if (this.LkN != null) {
                aVar.c(3, this.LkN);
            }
            if (this.LkO != null) {
                aVar.c(4, this.LkO);
            }
            aVar.aM(5, this.version);
            aVar.aM(6, this.KXC);
            if (this.LkP != null) {
                aVar.c(7, this.LkP);
            }
            AppMethodBeat.o(225288);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.LkM != null) {
                nh += g.a.a.b.b.a.b(2, this.LkM);
            }
            if (this.LkN != null) {
                nh += g.a.a.b.b.a.b(3, this.LkN);
            }
            if (this.LkO != null) {
                nh += g.a.a.b.b.a.b(4, this.LkO);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.version) + g.a.a.b.b.a.bu(6, this.KXC);
            if (this.LkP != null) {
                bu += g.a.a.b.b.a.b(7, this.LkP);
            }
            AppMethodBeat.o(225288);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(225288);
                throw bVar2;
            }
            AppMethodBeat.o(225288);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            zm zmVar = (zm) objArr[1];
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
                        zmVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(225288);
                    return 0;
                case 2:
                    zmVar.LkM = aVar3.UbS.hPo();
                    AppMethodBeat.o(225288);
                    return 0;
                case 3:
                    zmVar.LkN = aVar3.UbS.hPo();
                    AppMethodBeat.o(225288);
                    return 0;
                case 4:
                    zmVar.LkO = aVar3.UbS.hPo();
                    AppMethodBeat.o(225288);
                    return 0;
                case 5:
                    zmVar.version = aVar3.UbS.zi();
                    AppMethodBeat.o(225288);
                    return 0;
                case 6:
                    zmVar.KXC = aVar3.UbS.zi();
                    AppMethodBeat.o(225288);
                    return 0;
                case 7:
                    zmVar.LkP = aVar3.UbS.hPo();
                    AppMethodBeat.o(225288);
                    return 0;
                default:
                    AppMethodBeat.o(225288);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225288);
            return -1;
        }
    }
}
