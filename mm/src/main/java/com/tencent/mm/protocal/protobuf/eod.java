package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eod extends dpc {
    public int Brl;
    public long Brn;
    public String KHq;
    public String KIz;
    public String LbJ;
    public int LbO;
    public int MrU;
    public int NlQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127181);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(127181);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.KIz != null) {
                aVar.e(2, this.KIz);
            }
            aVar.aM(3, this.Brl);
            aVar.aM(4, this.MrU);
            aVar.aM(5, this.NlQ);
            aVar.bb(6, this.Brn);
            if (this.LbJ != null) {
                aVar.e(7, this.LbJ);
            }
            if (this.KHq != null) {
                aVar.e(8, this.KHq);
            }
            aVar.aM(9, this.LbO);
            AppMethodBeat.o(127181);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KIz != null) {
                nh += g.a.a.b.b.a.f(2, this.KIz);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.Brl) + g.a.a.b.b.a.bu(4, this.MrU) + g.a.a.b.b.a.bu(5, this.NlQ) + g.a.a.b.b.a.r(6, this.Brn);
            if (this.LbJ != null) {
                bu += g.a.a.b.b.a.f(7, this.LbJ);
            }
            if (this.KHq != null) {
                bu += g.a.a.b.b.a.f(8, this.KHq);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.LbO);
            AppMethodBeat.o(127181);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(127181);
                throw bVar2;
            }
            AppMethodBeat.o(127181);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eod eod = (eod) objArr[1];
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
                        eod.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(127181);
                    return 0;
                case 2:
                    eod.KIz = aVar3.UbS.readString();
                    AppMethodBeat.o(127181);
                    return 0;
                case 3:
                    eod.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(127181);
                    return 0;
                case 4:
                    eod.MrU = aVar3.UbS.zi();
                    AppMethodBeat.o(127181);
                    return 0;
                case 5:
                    eod.NlQ = aVar3.UbS.zi();
                    AppMethodBeat.o(127181);
                    return 0;
                case 6:
                    eod.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(127181);
                    return 0;
                case 7:
                    eod.LbJ = aVar3.UbS.readString();
                    AppMethodBeat.o(127181);
                    return 0;
                case 8:
                    eod.KHq = aVar3.UbS.readString();
                    AppMethodBeat.o(127181);
                    return 0;
                case 9:
                    eod.LbO = aVar3.UbS.zi();
                    AppMethodBeat.o(127181);
                    return 0;
                default:
                    AppMethodBeat.o(127181);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127181);
            return -1;
        }
    }
}
