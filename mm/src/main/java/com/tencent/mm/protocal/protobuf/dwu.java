package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dwu extends dpc {
    public boolean DhA;
    public int Dhr;
    public int Dhu;
    public String Dhv;
    public String Dhw;
    public String Dhx;
    public String Dhy;
    public String Dhz;
    public String eaP;
    public String gTG;
    public String iwv;
    public String ixw;
    public String pRX;
    public String pRY;
    public String pRZ;
    public int pSb;
    public int pTI;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32439);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32439);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.pTI);
            if (this.pRX != null) {
                aVar.e(3, this.pRX);
            }
            if (this.eaP != null) {
                aVar.e(4, this.eaP);
            }
            if (this.title != null) {
                aVar.e(5, this.title);
            }
            if (this.pRY != null) {
                aVar.e(6, this.pRY);
            }
            if (this.pRZ != null) {
                aVar.e(7, this.pRZ);
            }
            if (this.gTG != null) {
                aVar.e(8, this.gTG);
            }
            if (this.iwv != null) {
                aVar.e(9, this.iwv);
            }
            if (this.ixw != null) {
                aVar.e(10, this.ixw);
            }
            aVar.aM(11, this.Dhr);
            aVar.aM(12, this.Dhu);
            if (this.Dhv != null) {
                aVar.e(13, this.Dhv);
            }
            if (this.Dhw != null) {
                aVar.e(14, this.Dhw);
            }
            if (this.Dhx != null) {
                aVar.e(19, this.Dhx);
            }
            if (this.Dhy != null) {
                aVar.e(21, this.Dhy);
            }
            aVar.aM(22, this.pSb);
            if (this.Dhz != null) {
                aVar.e(23, this.Dhz);
            }
            aVar.cc(24, this.DhA);
            AppMethodBeat.o(32439);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.pTI);
            if (this.pRX != null) {
                nh += g.a.a.b.b.a.f(3, this.pRX);
            }
            if (this.eaP != null) {
                nh += g.a.a.b.b.a.f(4, this.eaP);
            }
            if (this.title != null) {
                nh += g.a.a.b.b.a.f(5, this.title);
            }
            if (this.pRY != null) {
                nh += g.a.a.b.b.a.f(6, this.pRY);
            }
            if (this.pRZ != null) {
                nh += g.a.a.b.b.a.f(7, this.pRZ);
            }
            if (this.gTG != null) {
                nh += g.a.a.b.b.a.f(8, this.gTG);
            }
            if (this.iwv != null) {
                nh += g.a.a.b.b.a.f(9, this.iwv);
            }
            if (this.ixw != null) {
                nh += g.a.a.b.b.a.f(10, this.ixw);
            }
            int bu = nh + g.a.a.b.b.a.bu(11, this.Dhr) + g.a.a.b.b.a.bu(12, this.Dhu);
            if (this.Dhv != null) {
                bu += g.a.a.b.b.a.f(13, this.Dhv);
            }
            if (this.Dhw != null) {
                bu += g.a.a.b.b.a.f(14, this.Dhw);
            }
            if (this.Dhx != null) {
                bu += g.a.a.b.b.a.f(19, this.Dhx);
            }
            if (this.Dhy != null) {
                bu += g.a.a.b.b.a.f(21, this.Dhy);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(22, this.pSb);
            if (this.Dhz != null) {
                bu2 += g.a.a.b.b.a.f(23, this.Dhz);
            }
            int fS = bu2 + g.a.a.b.b.a.fS(24) + 1;
            AppMethodBeat.o(32439);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(32439);
                throw bVar2;
            }
            AppMethodBeat.o(32439);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dwu dwu = (dwu) objArr[1];
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
                        dwu.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(32439);
                    return 0;
                case 2:
                    dwu.pTI = aVar3.UbS.zi();
                    AppMethodBeat.o(32439);
                    return 0;
                case 3:
                    dwu.pRX = aVar3.UbS.readString();
                    AppMethodBeat.o(32439);
                    return 0;
                case 4:
                    dwu.eaP = aVar3.UbS.readString();
                    AppMethodBeat.o(32439);
                    return 0;
                case 5:
                    dwu.title = aVar3.UbS.readString();
                    AppMethodBeat.o(32439);
                    return 0;
                case 6:
                    dwu.pRY = aVar3.UbS.readString();
                    AppMethodBeat.o(32439);
                    return 0;
                case 7:
                    dwu.pRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32439);
                    return 0;
                case 8:
                    dwu.gTG = aVar3.UbS.readString();
                    AppMethodBeat.o(32439);
                    return 0;
                case 9:
                    dwu.iwv = aVar3.UbS.readString();
                    AppMethodBeat.o(32439);
                    return 0;
                case 10:
                    dwu.ixw = aVar3.UbS.readString();
                    AppMethodBeat.o(32439);
                    return 0;
                case 11:
                    dwu.Dhr = aVar3.UbS.zi();
                    AppMethodBeat.o(32439);
                    return 0;
                case 12:
                    dwu.Dhu = aVar3.UbS.zi();
                    AppMethodBeat.o(32439);
                    return 0;
                case 13:
                    dwu.Dhv = aVar3.UbS.readString();
                    AppMethodBeat.o(32439);
                    return 0;
                case 14:
                    dwu.Dhw = aVar3.UbS.readString();
                    AppMethodBeat.o(32439);
                    return 0;
                case 15:
                case 16:
                case 17:
                case 18:
                case 20:
                default:
                    AppMethodBeat.o(32439);
                    return -1;
                case 19:
                    dwu.Dhx = aVar3.UbS.readString();
                    AppMethodBeat.o(32439);
                    return 0;
                case 21:
                    dwu.Dhy = aVar3.UbS.readString();
                    AppMethodBeat.o(32439);
                    return 0;
                case 22:
                    dwu.pSb = aVar3.UbS.zi();
                    AppMethodBeat.o(32439);
                    return 0;
                case 23:
                    dwu.Dhz = aVar3.UbS.readString();
                    AppMethodBeat.o(32439);
                    return 0;
                case 24:
                    dwu.DhA = aVar3.UbS.yZ();
                    AppMethodBeat.o(32439);
                    return 0;
            }
        } else {
            AppMethodBeat.o(32439);
            return -1;
        }
    }
}
