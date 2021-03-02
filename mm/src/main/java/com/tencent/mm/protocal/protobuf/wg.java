package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class wg extends dpc {
    public int Lba;
    public b Lhd;
    public int dDN;
    public String qwn;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91411);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91411);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.dDN);
            if (this.qwn != null) {
                aVar.e(3, this.qwn);
            }
            if (this.Lhd != null) {
                aVar.c(4, this.Lhd);
            }
            aVar.aM(5, this.Lba);
            AppMethodBeat.o(91411);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.dDN);
            if (this.qwn != null) {
                nh += g.a.a.b.b.a.f(3, this.qwn);
            }
            if (this.Lhd != null) {
                nh += g.a.a.b.b.a.b(4, this.Lhd);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.Lba);
            AppMethodBeat.o(91411);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91411);
                throw bVar2;
            }
            AppMethodBeat.o(91411);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            wg wgVar = (wg) objArr[1];
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
                        wgVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91411);
                    return 0;
                case 2:
                    wgVar.dDN = aVar3.UbS.zi();
                    AppMethodBeat.o(91411);
                    return 0;
                case 3:
                    wgVar.qwn = aVar3.UbS.readString();
                    AppMethodBeat.o(91411);
                    return 0;
                case 4:
                    wgVar.Lhd = aVar3.UbS.hPo();
                    AppMethodBeat.o(91411);
                    return 0;
                case 5:
                    wgVar.Lba = aVar3.UbS.zi();
                    AppMethodBeat.o(91411);
                    return 0;
                default:
                    AppMethodBeat.o(91411);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91411);
            return -1;
        }
    }
}
