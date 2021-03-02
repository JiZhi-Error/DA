package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class blu extends dpc {
    public LinkedList<Integer> LRr = new LinkedList<>();
    public int LUB;
    public LinkedList<cpl> LUC = new LinkedList<>();
    public LinkedList<eqf> LUD = new LinkedList<>();
    public LinkedList<dtv> LUE = new LinkedList<>();

    public blu() {
        AppMethodBeat.i(32234);
        AppMethodBeat.o(32234);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32235);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32235);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.LUB);
            aVar.e(3, 8, this.LUC);
            aVar.f(4, 2, this.LRr);
            aVar.e(5, 8, this.LUD);
            aVar.e(6, 8, this.LUE);
            AppMethodBeat.o(32235);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LUB) + g.a.a.a.c(3, 8, this.LUC) + g.a.a.a.d(4, 2, this.LRr) + g.a.a.a.c(5, 8, this.LUD) + g.a.a.a.c(6, 8, this.LUE);
            AppMethodBeat.o(32235);
            return nh;
        } else if (i2 == 2) {
            this.LUC.clear();
            this.LRr.clear();
            this.LUD.clear();
            this.LUE.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32235);
                throw bVar2;
            }
            AppMethodBeat.o(32235);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            blu blu = (blu) objArr[1];
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
                        blu.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32235);
                    return 0;
                case 2:
                    blu.LUB = aVar3.UbS.zi();
                    AppMethodBeat.o(32235);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cpl cpl = new cpl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cpl.populateBuilderWithField(aVar5, cpl, dpc.getNextFieldNumber(aVar5))) {
                        }
                        blu.LUC.add(cpl);
                    }
                    AppMethodBeat.o(32235);
                    return 0;
                case 4:
                    blu.LRr = new g.a.a.a.a(aVar3.UbS.hPo().zy, unknownTagHandler).UbS.hPm();
                    AppMethodBeat.o(32235);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eqf eqf = new eqf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eqf.populateBuilderWithField(aVar6, eqf, dpc.getNextFieldNumber(aVar6))) {
                        }
                        blu.LUD.add(eqf);
                    }
                    AppMethodBeat.o(32235);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dtv dtv = new dtv();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dtv.populateBuilderWithField(aVar7, dtv, dpc.getNextFieldNumber(aVar7))) {
                        }
                        blu.LUE.add(dtv);
                    }
                    AppMethodBeat.o(32235);
                    return 0;
                default:
                    AppMethodBeat.o(32235);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32235);
            return -1;
        }
    }
}
