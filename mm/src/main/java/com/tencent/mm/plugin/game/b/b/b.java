package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.c.a;
import java.util.LinkedList;

public final class b extends dpc {
    public int Ret;
    public String desc;
    public int pRQ;
    public String rBM;
    public String xuE;
    public boolean xuF = false;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(40865);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(40865);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.Ret);
            if (this.rBM != null) {
                aVar.e(3, this.rBM);
            }
            if (this.xuE != null) {
                aVar.e(4, this.xuE);
            }
            aVar.cc(5, this.xuF);
            aVar.aM(6, this.pRQ);
            if (this.desc != null) {
                aVar.e(7, this.desc);
            }
            AppMethodBeat.o(40865);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Ret);
            if (this.rBM != null) {
                nh += g.a.a.b.b.a.f(3, this.rBM);
            }
            if (this.xuE != null) {
                nh += g.a.a.b.b.a.f(4, this.xuE);
            }
            int fS = nh + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.bu(6, this.pRQ);
            if (this.desc != null) {
                fS += g.a.a.b.b.a.f(7, this.desc);
            }
            AppMethodBeat.o(40865);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(40865);
                throw bVar2;
            }
            AppMethodBeat.o(40865);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar3 = (b) objArr[1];
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
                        bVar3.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(40865);
                    return 0;
                case 2:
                    bVar3.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(40865);
                    return 0;
                case 3:
                    bVar3.rBM = aVar3.UbS.readString();
                    AppMethodBeat.o(40865);
                    return 0;
                case 4:
                    bVar3.xuE = aVar3.UbS.readString();
                    AppMethodBeat.o(40865);
                    return 0;
                case 5:
                    bVar3.xuF = aVar3.UbS.yZ();
                    AppMethodBeat.o(40865);
                    return 0;
                case 6:
                    bVar3.pRQ = aVar3.UbS.zi();
                    AppMethodBeat.o(40865);
                    return 0;
                case 7:
                    bVar3.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(40865);
                    return 0;
                default:
                    AppMethodBeat.o(40865);
                    return -1;
            }
        } else {
            AppMethodBeat.o(40865);
            return -1;
        }
    }
}
