package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class buy extends dpc {
    public boolean KPb;
    public LinkedList<duw> KPc = new LinkedList<>();
    public boolean Mbo;
    public LinkedList<duw> Mbp = new LinkedList<>();

    public buy() {
        AppMethodBeat.i(153280);
        AppMethodBeat.o(153280);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153281);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(153281);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.cc(2, this.KPb);
            aVar.e(3, 8, this.KPc);
            aVar.cc(4, this.Mbo);
            aVar.e(5, 8, this.Mbp);
            AppMethodBeat.o(153281);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.fS(2) + 1 + g.a.a.a.c(3, 8, this.KPc) + g.a.a.b.b.a.fS(4) + 1 + g.a.a.a.c(5, 8, this.Mbp);
            AppMethodBeat.o(153281);
            return nh;
        } else if (i2 == 2) {
            this.KPc.clear();
            this.Mbp.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(153281);
                throw bVar2;
            }
            AppMethodBeat.o(153281);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            buy buy = (buy) objArr[1];
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
                        buy.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(153281);
                    return 0;
                case 2:
                    buy.KPb = aVar3.UbS.yZ();
                    AppMethodBeat.o(153281);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        duw duw = new duw();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = duw.populateBuilderWithField(aVar5, duw, dpc.getNextFieldNumber(aVar5))) {
                        }
                        buy.KPc.add(duw);
                    }
                    AppMethodBeat.o(153281);
                    return 0;
                case 4:
                    buy.Mbo = aVar3.UbS.yZ();
                    AppMethodBeat.o(153281);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        duw duw2 = new duw();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = duw2.populateBuilderWithField(aVar6, duw2, dpc.getNextFieldNumber(aVar6))) {
                        }
                        buy.Mbp.add(duw2);
                    }
                    AppMethodBeat.o(153281);
                    return 0;
                default:
                    AppMethodBeat.o(153281);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153281);
            return -1;
        }
    }
}