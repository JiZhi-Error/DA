package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bln extends dpc {
    public LinkedList<qq> KKx = new LinkedList<>();
    public int KLm;
    public int KZh;
    public int KZk;
    public long LRV;
    public int LUs;

    public bln() {
        AppMethodBeat.i(117869);
        AppMethodBeat.o(117869);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117870);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.e(2, 8, this.KKx);
            aVar.aM(3, this.KZh);
            aVar.aM(4, this.LUs);
            aVar.aM(5, this.KLm);
            aVar.bb(6, this.LRV);
            aVar.aM(7, this.KZk);
            AppMethodBeat.o(117870);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.KKx) + g.a.a.b.b.a.bu(3, this.KZh) + g.a.a.b.b.a.bu(4, this.LUs) + g.a.a.b.b.a.bu(5, this.KLm) + g.a.a.b.b.a.r(6, this.LRV) + g.a.a.b.b.a.bu(7, this.KZk);
            AppMethodBeat.o(117870);
            return nh;
        } else if (i2 == 2) {
            this.KKx.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117870);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bln bln = (bln) objArr[1];
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
                        bln.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(117870);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        qq qqVar = new qq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = qqVar.populateBuilderWithField(aVar5, qqVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        bln.KKx.add(qqVar);
                    }
                    AppMethodBeat.o(117870);
                    return 0;
                case 3:
                    bln.KZh = aVar3.UbS.zi();
                    AppMethodBeat.o(117870);
                    return 0;
                case 4:
                    bln.LUs = aVar3.UbS.zi();
                    AppMethodBeat.o(117870);
                    return 0;
                case 5:
                    bln.KLm = aVar3.UbS.zi();
                    AppMethodBeat.o(117870);
                    return 0;
                case 6:
                    bln.LRV = aVar3.UbS.zl();
                    AppMethodBeat.o(117870);
                    return 0;
                case 7:
                    bln.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(117870);
                    return 0;
                default:
                    AppMethodBeat.o(117870);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117870);
            return -1;
        }
    }
}
