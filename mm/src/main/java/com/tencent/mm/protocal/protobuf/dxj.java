package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dxj extends dpc {
    public int MXm;
    public LinkedList<dxh> iAd = new LinkedList<>();
    public int pVJ;
    public long seq;

    public dxj() {
        AppMethodBeat.i(114076);
        AppMethodBeat.o(114076);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114077);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114077);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.iAd);
            aVar.aM(3, this.MXm);
            aVar.bb(4, this.seq);
            aVar.aM(5, this.pVJ);
            AppMethodBeat.o(114077);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.iAd) + g.a.a.b.b.a.bu(3, this.MXm) + g.a.a.b.b.a.r(4, this.seq) + g.a.a.b.b.a.bu(5, this.pVJ);
            AppMethodBeat.o(114077);
            return nh;
        } else if (i2 == 2) {
            this.iAd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(114077);
                throw bVar2;
            }
            AppMethodBeat.o(114077);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dxj dxj = (dxj) objArr[1];
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
                        dxj.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(114077);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dxh dxh = new dxh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dxh.populateBuilderWithField(aVar5, dxh, dpc.getNextFieldNumber(aVar5))) {
                        }
                        dxj.iAd.add(dxh);
                    }
                    AppMethodBeat.o(114077);
                    return 0;
                case 3:
                    dxj.MXm = aVar3.UbS.zi();
                    AppMethodBeat.o(114077);
                    return 0;
                case 4:
                    dxj.seq = aVar3.UbS.zl();
                    AppMethodBeat.o(114077);
                    return 0;
                case 5:
                    dxj.pVJ = aVar3.UbS.zi();
                    AppMethodBeat.o(114077);
                    return 0;
                default:
                    AppMethodBeat.o(114077);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114077);
            return -1;
        }
    }
}
