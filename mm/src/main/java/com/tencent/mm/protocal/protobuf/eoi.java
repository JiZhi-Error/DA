package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eoi extends dpc {
    public int Brl;
    public long Brn;
    public int CreateTime;
    public String KIz;
    public int KUy;
    public int KXq;
    public int KZk;
    public int LbO;
    public int LrF;
    public int jeU;
    public String xNG;
    public String xNH;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(148662);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(148662);
                throw bVar;
            }
            if (this.xNH != null) {
                aVar.e(1, this.xNH);
            }
            if (this.xNG != null) {
                aVar.e(2, this.xNG);
            }
            aVar.aM(3, this.KZk);
            aVar.aM(4, this.KUy);
            aVar.aM(5, this.CreateTime);
            if (this.KIz != null) {
                aVar.e(6, this.KIz);
            }
            aVar.aM(7, this.Brl);
            aVar.aM(8, this.KXq);
            aVar.aM(9, this.jeU);
            if (this.BaseResponse != null) {
                aVar.ni(10, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(11, this.LrF);
            aVar.bb(12, this.Brn);
            aVar.aM(13, this.LbO);
            AppMethodBeat.o(148662);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xNH != null ? g.a.a.b.b.a.f(1, this.xNH) + 0 : 0;
            if (this.xNG != null) {
                f2 += g.a.a.b.b.a.f(2, this.xNG);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.KZk) + g.a.a.b.b.a.bu(4, this.KUy) + g.a.a.b.b.a.bu(5, this.CreateTime);
            if (this.KIz != null) {
                bu += g.a.a.b.b.a.f(6, this.KIz);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.Brl) + g.a.a.b.b.a.bu(8, this.KXq) + g.a.a.b.b.a.bu(9, this.jeU);
            if (this.BaseResponse != null) {
                bu2 += g.a.a.a.nh(10, this.BaseResponse.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(11, this.LrF) + g.a.a.b.b.a.r(12, this.Brn) + g.a.a.b.b.a.bu(13, this.LbO);
            AppMethodBeat.o(148662);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(148662);
                throw bVar2;
            }
            AppMethodBeat.o(148662);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eoi eoi = (eoi) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eoi.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(148662);
                    return 0;
                case 2:
                    eoi.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(148662);
                    return 0;
                case 3:
                    eoi.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(148662);
                    return 0;
                case 4:
                    eoi.KUy = aVar3.UbS.zi();
                    AppMethodBeat.o(148662);
                    return 0;
                case 5:
                    eoi.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(148662);
                    return 0;
                case 6:
                    eoi.KIz = aVar3.UbS.readString();
                    AppMethodBeat.o(148662);
                    return 0;
                case 7:
                    eoi.Brl = aVar3.UbS.zi();
                    AppMethodBeat.o(148662);
                    return 0;
                case 8:
                    eoi.KXq = aVar3.UbS.zi();
                    AppMethodBeat.o(148662);
                    return 0;
                case 9:
                    eoi.jeU = aVar3.UbS.zi();
                    AppMethodBeat.o(148662);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        BaseResponse baseResponse = new BaseResponse();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = baseResponse.populateBuilderWithField(aVar4, baseResponse, dpc.getNextFieldNumber(aVar4))) {
                        }
                        eoi.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(148662);
                    return 0;
                case 11:
                    eoi.LrF = aVar3.UbS.zi();
                    AppMethodBeat.o(148662);
                    return 0;
                case 12:
                    eoi.Brn = aVar3.UbS.zl();
                    AppMethodBeat.o(148662);
                    return 0;
                case 13:
                    eoi.LbO = aVar3.UbS.zi();
                    AppMethodBeat.o(148662);
                    return 0;
                default:
                    AppMethodBeat.o(148662);
                    return -1;
            }
        } else {
            AppMethodBeat.o(148662);
            return -1;
        }
    }
}
