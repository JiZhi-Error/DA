package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bud extends dpc {
    public LinkedList<dle> MaQ = new LinkedList<>();
    public LinkedList<dko> MaR = new LinkedList<>();
    public int MaS;
    public long clK;
    public int kWY;

    public bud() {
        AppMethodBeat.i(50090);
        AppMethodBeat.o(50090);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50091);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(50091);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.kWY);
            aVar.e(3, 8, this.MaQ);
            aVar.bb(4, this.clK);
            aVar.e(5, 8, this.MaR);
            aVar.aM(6, this.MaS);
            AppMethodBeat.o(50091);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.kWY) + g.a.a.a.c(3, 8, this.MaQ) + g.a.a.b.b.a.r(4, this.clK) + g.a.a.a.c(5, 8, this.MaR) + g.a.a.b.b.a.bu(6, this.MaS);
            AppMethodBeat.o(50091);
            return nh;
        } else if (i2 == 2) {
            this.MaQ.clear();
            this.MaR.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(50091);
                throw bVar2;
            }
            AppMethodBeat.o(50091);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bud bud = (bud) objArr[1];
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
                        bud.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(50091);
                    return 0;
                case 2:
                    bud.kWY = aVar3.UbS.zi();
                    AppMethodBeat.o(50091);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dle dle = new dle();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dle.populateBuilderWithField(aVar5, dle, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bud.MaQ.add(dle);
                    }
                    AppMethodBeat.o(50091);
                    return 0;
                case 4:
                    bud.clK = aVar3.UbS.zl();
                    AppMethodBeat.o(50091);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dko dko = new dko();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dko.populateBuilderWithField(aVar6, dko, dpc.getNextFieldNumber(aVar6))) {
                        }
                        bud.MaR.add(dko);
                    }
                    AppMethodBeat.o(50091);
                    return 0;
                case 6:
                    bud.MaS = aVar3.UbS.zi();
                    AppMethodBeat.o(50091);
                    return 0;
                default:
                    AppMethodBeat.o(50091);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50091);
            return -1;
        }
    }
}
