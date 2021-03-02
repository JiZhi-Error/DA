package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpc;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class h extends dpc {
    public int Ret;
    public int oKY;
    public int pRQ;
    public boolean qGh;
    public String rBM;
    public String xuD;
    public String xuE;
    public long xuR;
    public LinkedList<m> xuS = new LinkedList<>();

    public h() {
        AppMethodBeat.i(40873);
        AppMethodBeat.o(40873);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(40874);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(40874);
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
            aVar.cc(5, this.qGh);
            aVar.bb(6, this.xuR);
            aVar.e(7, 8, this.xuS);
            if (this.xuD != null) {
                aVar.e(8, this.xuD);
            }
            aVar.aM(9, this.oKY);
            aVar.aM(10, this.pRQ);
            AppMethodBeat.o(40874);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Ret);
            if (this.rBM != null) {
                nh += g.a.a.b.b.a.f(3, this.rBM);
            }
            if (this.xuE != null) {
                nh += g.a.a.b.b.a.f(4, this.xuE);
            }
            int fS = nh + g.a.a.b.b.a.fS(5) + 1 + g.a.a.b.b.a.r(6, this.xuR) + g.a.a.a.c(7, 8, this.xuS);
            if (this.xuD != null) {
                fS += g.a.a.b.b.a.f(8, this.xuD);
            }
            int bu = fS + g.a.a.b.b.a.bu(9, this.oKY) + g.a.a.b.b.a.bu(10, this.pRQ);
            AppMethodBeat.o(40874);
            return bu;
        } else if (i2 == 2) {
            this.xuS.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(40874);
                throw bVar2;
            }
            AppMethodBeat.o(40874);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            h hVar = (h) objArr[1];
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
                        hVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(40874);
                    return 0;
                case 2:
                    hVar.Ret = aVar3.UbS.zi();
                    AppMethodBeat.o(40874);
                    return 0;
                case 3:
                    hVar.rBM = aVar3.UbS.readString();
                    AppMethodBeat.o(40874);
                    return 0;
                case 4:
                    hVar.xuE = aVar3.UbS.readString();
                    AppMethodBeat.o(40874);
                    return 0;
                case 5:
                    hVar.qGh = aVar3.UbS.yZ();
                    AppMethodBeat.o(40874);
                    return 0;
                case 6:
                    hVar.xuR = aVar3.UbS.zl();
                    AppMethodBeat.o(40874);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        m mVar = new m();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = mVar.populateBuilderWithField(aVar5, mVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        hVar.xuS.add(mVar);
                    }
                    AppMethodBeat.o(40874);
                    return 0;
                case 8:
                    hVar.xuD = aVar3.UbS.readString();
                    AppMethodBeat.o(40874);
                    return 0;
                case 9:
                    hVar.oKY = aVar3.UbS.zi();
                    AppMethodBeat.o(40874);
                    return 0;
                case 10:
                    hVar.pRQ = aVar3.UbS.zi();
                    AppMethodBeat.o(40874);
                    return 0;
                default:
                    AppMethodBeat.o(40874);
                    return -1;
            }
        } else {
            AppMethodBeat.o(40874);
            return -1;
        }
    }
}
