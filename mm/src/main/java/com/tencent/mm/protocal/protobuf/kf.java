package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class kf extends dpc {
    public LinkedList<fn> KOA = new LinkedList<>();
    public LinkedList<dqz> KOB = new LinkedList<>();

    public kf() {
        AppMethodBeat.i(6396);
        AppMethodBeat.o(6396);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(6397);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(6397);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.KOA);
            aVar.e(3, 8, this.KOB);
            AppMethodBeat.o(6397);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.KOA) + g.a.a.a.c(3, 8, this.KOB);
            AppMethodBeat.o(6397);
            return nh;
        } else if (i2 == 2) {
            this.KOA.clear();
            this.KOB.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(6397);
                throw bVar2;
            }
            AppMethodBeat.o(6397);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            kf kfVar = (kf) objArr[1];
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
                        kfVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(6397);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fn fnVar = new fn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fnVar.populateBuilderWithField(aVar5, fnVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        kfVar.KOA.add(fnVar);
                    }
                    AppMethodBeat.o(6397);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqz dqz = new dqz();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqz.populateBuilderWithField(aVar6, dqz, dpc.getNextFieldNumber(aVar6))) {
                        }
                        kfVar.KOB.add(dqz);
                    }
                    AppMethodBeat.o(6397);
                    return 0;
                default:
                    AppMethodBeat.o(6397);
                    return -1;
            }
        } else {
            AppMethodBeat.o(6397);
            return -1;
        }
    }
}
