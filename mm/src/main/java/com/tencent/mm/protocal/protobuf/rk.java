package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.c;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class rk extends dpc {
    public c Iah;
    public long Iaj;
    public long KYQ;
    public LinkedList<String> KYR = new LinkedList<>();
    public int KYS;
    public int KYT;
    public String KYU;
    public String KYV;
    public String KYW;
    public boolean KYX;
    public int pTZ;
    public String pUa;

    public rk() {
        AppMethodBeat.i(91377);
        AppMethodBeat.o(91377);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91378);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91378);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTZ);
            if (this.pUa != null) {
                aVar.e(3, this.pUa);
            }
            aVar.bb(4, this.Iaj);
            if (this.Iah != null) {
                aVar.ni(5, this.Iah.computeSize());
                this.Iah.writeFields(aVar);
            }
            aVar.bb(6, this.KYQ);
            aVar.e(7, 1, this.KYR);
            aVar.aM(8, this.KYS);
            aVar.aM(9, this.KYT);
            if (this.KYU != null) {
                aVar.e(10, this.KYU);
            }
            if (this.KYV != null) {
                aVar.e(11, this.KYV);
            }
            if (this.KYW != null) {
                aVar.e(12, this.KYW);
            }
            aVar.cc(13, this.KYX);
            AppMethodBeat.o(91378);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTZ);
            if (this.pUa != null) {
                nh += g.a.a.b.b.a.f(3, this.pUa);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.Iaj);
            if (this.Iah != null) {
                r += g.a.a.a.nh(5, this.Iah.computeSize());
            }
            int r2 = r + g.a.a.b.b.a.r(6, this.KYQ) + g.a.a.a.c(7, 1, this.KYR) + g.a.a.b.b.a.bu(8, this.KYS) + g.a.a.b.b.a.bu(9, this.KYT);
            if (this.KYU != null) {
                r2 += g.a.a.b.b.a.f(10, this.KYU);
            }
            if (this.KYV != null) {
                r2 += g.a.a.b.b.a.f(11, this.KYV);
            }
            if (this.KYW != null) {
                r2 += g.a.a.b.b.a.f(12, this.KYW);
            }
            int fS = r2 + g.a.a.b.b.a.fS(13) + 1;
            AppMethodBeat.o(91378);
            return fS;
        } else if (i2 == 2) {
            this.KYR.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91378);
                throw bVar2;
            }
            AppMethodBeat.o(91378);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            rk rkVar = (rk) objArr[1];
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
                        rkVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91378);
                    return 0;
                case 2:
                    rkVar.pTZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91378);
                    return 0;
                case 3:
                    rkVar.pUa = aVar3.UbS.readString();
                    AppMethodBeat.o(91378);
                    return 0;
                case 4:
                    rkVar.Iaj = aVar3.UbS.zl();
                    AppMethodBeat.o(91378);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        c cVar = new c();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cVar.populateBuilderWithField(aVar5, cVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        rkVar.Iah = cVar;
                    }
                    AppMethodBeat.o(91378);
                    return 0;
                case 6:
                    rkVar.KYQ = aVar3.UbS.zl();
                    AppMethodBeat.o(91378);
                    return 0;
                case 7:
                    rkVar.KYR.add(aVar3.UbS.readString());
                    AppMethodBeat.o(91378);
                    return 0;
                case 8:
                    rkVar.KYS = aVar3.UbS.zi();
                    AppMethodBeat.o(91378);
                    return 0;
                case 9:
                    rkVar.KYT = aVar3.UbS.zi();
                    AppMethodBeat.o(91378);
                    return 0;
                case 10:
                    rkVar.KYU = aVar3.UbS.readString();
                    AppMethodBeat.o(91378);
                    return 0;
                case 11:
                    rkVar.KYV = aVar3.UbS.readString();
                    AppMethodBeat.o(91378);
                    return 0;
                case 12:
                    rkVar.KYW = aVar3.UbS.readString();
                    AppMethodBeat.o(91378);
                    return 0;
                case 13:
                    rkVar.KYX = aVar3.UbS.yZ();
                    AppMethodBeat.o(91378);
                    return 0;
                default:
                    AppMethodBeat.o(91378);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91378);
            return -1;
        }
    }
}
