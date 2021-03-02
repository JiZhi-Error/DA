package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cti extends dpc {
    public int GroupCount;
    public LinkedList<bfo> GroupList = new LinkedList<>();
    public int Myh;
    public LinkedList<ctl> xMV = new LinkedList<>();

    public cti() {
        AppMethodBeat.i(155443);
        AppMethodBeat.o(155443);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155444);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(155444);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.Myh);
            aVar.e(3, 8, this.xMV);
            aVar.aM(4, this.GroupCount);
            aVar.e(5, 8, this.GroupList);
            AppMethodBeat.o(155444);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.Myh) + g.a.a.a.c(3, 8, this.xMV) + g.a.a.b.b.a.bu(4, this.GroupCount) + g.a.a.a.c(5, 8, this.GroupList);
            AppMethodBeat.o(155444);
            return nh;
        } else if (i2 == 2) {
            this.xMV.clear();
            this.GroupList.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(155444);
                throw bVar2;
            }
            AppMethodBeat.o(155444);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cti cti = (cti) objArr[1];
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
                        cti.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(155444);
                    return 0;
                case 2:
                    cti.Myh = aVar3.UbS.zi();
                    AppMethodBeat.o(155444);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ctl ctl = new ctl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ctl.populateBuilderWithField(aVar5, ctl, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cti.xMV.add(ctl);
                    }
                    AppMethodBeat.o(155444);
                    return 0;
                case 4:
                    cti.GroupCount = aVar3.UbS.zi();
                    AppMethodBeat.o(155444);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bfo bfo = new bfo();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bfo.populateBuilderWithField(aVar6, bfo, dpc.getNextFieldNumber(aVar6))) {
                        }
                        cti.GroupList.add(bfo);
                    }
                    AppMethodBeat.o(155444);
                    return 0;
                default:
                    AppMethodBeat.o(155444);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155444);
            return -1;
        }
    }
}
