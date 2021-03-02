package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class qi extends dpc {
    public dis KTz;
    public int KXj;
    public b KXk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212265);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(212265);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.KXj);
            if (this.KXk != null) {
                aVar.c(3, this.KXk);
            }
            if (this.KTz != null) {
                aVar.ni(4, this.KTz.computeSize());
                this.KTz.writeFields(aVar);
            }
            AppMethodBeat.o(212265);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KXj);
            if (this.KXk != null) {
                nh += g.a.a.b.b.a.b(3, this.KXk);
            }
            if (this.KTz != null) {
                nh += g.a.a.a.nh(4, this.KTz.computeSize());
            }
            AppMethodBeat.o(212265);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(212265);
                throw bVar2;
            }
            AppMethodBeat.o(212265);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            qi qiVar = (qi) objArr[1];
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
                        qiVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(212265);
                    return 0;
                case 2:
                    qiVar.KXj = aVar3.UbS.zi();
                    AppMethodBeat.o(212265);
                    return 0;
                case 3:
                    qiVar.KXk = aVar3.UbS.hPo();
                    AppMethodBeat.o(212265);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dis dis = new dis();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dis.populateBuilderWithField(aVar5, dis, dpc.getNextFieldNumber(aVar5))) {
                        }
                        qiVar.KTz = dis;
                    }
                    AppMethodBeat.o(212265);
                    return 0;
                default:
                    AppMethodBeat.o(212265);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212265);
            return -1;
        }
    }
}
