package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cxg extends dpc {
    public int KBv;
    public dju LgT;
    public int MBD;
    public int MBE;
    public int MBF;
    public long MBG;
    public long MBH;
    public LinkedList<cai> MBI = new LinkedList<>();
    public String MBJ;
    public String MBK;
    public String MBL;
    public int MBM;
    public int MBN;
    public String MBO;
    public long eht;
    public int yPI;
    public int yPJ;
    public String yPK;
    public String yPL;
    public String yPM;

    public cxg() {
        AppMethodBeat.i(91566);
        AppMethodBeat.o(91566);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91567);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91567);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.aM(2, this.MBD);
            aVar.aM(3, this.MBE);
            aVar.aM(4, this.yPI);
            aVar.bb(5, this.eht);
            aVar.aM(6, this.MBF);
            aVar.bb(7, this.MBG);
            aVar.aM(8, this.KBv);
            aVar.bb(9, this.MBH);
            aVar.aM(10, this.yPJ);
            aVar.e(11, 8, this.MBI);
            if (this.yPK != null) {
                aVar.e(12, this.yPK);
            }
            if (this.MBJ != null) {
                aVar.e(13, this.MBJ);
            }
            if (this.MBK != null) {
                aVar.e(14, this.MBK);
            }
            if (this.MBL != null) {
                aVar.e(15, this.MBL);
            }
            aVar.aM(16, this.MBM);
            if (this.yPM != null) {
                aVar.e(17, this.yPM);
            }
            aVar.aM(18, this.MBN);
            if (this.yPL != null) {
                aVar.e(19, this.yPL);
            }
            if (this.LgT != null) {
                aVar.ni(20, this.LgT.computeSize());
                this.LgT.writeFields(aVar);
            }
            if (this.MBO != null) {
                aVar.e(21, this.MBO);
            }
            AppMethodBeat.o(91567);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MBD) + g.a.a.b.b.a.bu(3, this.MBE) + g.a.a.b.b.a.bu(4, this.yPI) + g.a.a.b.b.a.r(5, this.eht) + g.a.a.b.b.a.bu(6, this.MBF) + g.a.a.b.b.a.r(7, this.MBG) + g.a.a.b.b.a.bu(8, this.KBv) + g.a.a.b.b.a.r(9, this.MBH) + g.a.a.b.b.a.bu(10, this.yPJ) + g.a.a.a.c(11, 8, this.MBI);
            if (this.yPK != null) {
                nh += g.a.a.b.b.a.f(12, this.yPK);
            }
            if (this.MBJ != null) {
                nh += g.a.a.b.b.a.f(13, this.MBJ);
            }
            if (this.MBK != null) {
                nh += g.a.a.b.b.a.f(14, this.MBK);
            }
            if (this.MBL != null) {
                nh += g.a.a.b.b.a.f(15, this.MBL);
            }
            int bu = nh + g.a.a.b.b.a.bu(16, this.MBM);
            if (this.yPM != null) {
                bu += g.a.a.b.b.a.f(17, this.yPM);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(18, this.MBN);
            if (this.yPL != null) {
                bu2 += g.a.a.b.b.a.f(19, this.yPL);
            }
            if (this.LgT != null) {
                bu2 += g.a.a.a.nh(20, this.LgT.computeSize());
            }
            if (this.MBO != null) {
                bu2 += g.a.a.b.b.a.f(21, this.MBO);
            }
            AppMethodBeat.o(91567);
            return bu2;
        } else if (i2 == 2) {
            this.MBI.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.BaseResponse == null) {
                b bVar2 = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91567);
                throw bVar2;
            }
            AppMethodBeat.o(91567);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cxg cxg = (cxg) objArr[1];
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
                        cxg.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91567);
                    return 0;
                case 2:
                    cxg.MBD = aVar3.UbS.zi();
                    AppMethodBeat.o(91567);
                    return 0;
                case 3:
                    cxg.MBE = aVar3.UbS.zi();
                    AppMethodBeat.o(91567);
                    return 0;
                case 4:
                    cxg.yPI = aVar3.UbS.zi();
                    AppMethodBeat.o(91567);
                    return 0;
                case 5:
                    cxg.eht = aVar3.UbS.zl();
                    AppMethodBeat.o(91567);
                    return 0;
                case 6:
                    cxg.MBF = aVar3.UbS.zi();
                    AppMethodBeat.o(91567);
                    return 0;
                case 7:
                    cxg.MBG = aVar3.UbS.zl();
                    AppMethodBeat.o(91567);
                    return 0;
                case 8:
                    cxg.KBv = aVar3.UbS.zi();
                    AppMethodBeat.o(91567);
                    return 0;
                case 9:
                    cxg.MBH = aVar3.UbS.zl();
                    AppMethodBeat.o(91567);
                    return 0;
                case 10:
                    cxg.yPJ = aVar3.UbS.zi();
                    AppMethodBeat.o(91567);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cai cai = new cai();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cai.populateBuilderWithField(aVar5, cai, dpc.getNextFieldNumber(aVar5))) {
                        }
                        cxg.MBI.add(cai);
                    }
                    AppMethodBeat.o(91567);
                    return 0;
                case 12:
                    cxg.yPK = aVar3.UbS.readString();
                    AppMethodBeat.o(91567);
                    return 0;
                case 13:
                    cxg.MBJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91567);
                    return 0;
                case 14:
                    cxg.MBK = aVar3.UbS.readString();
                    AppMethodBeat.o(91567);
                    return 0;
                case 15:
                    cxg.MBL = aVar3.UbS.readString();
                    AppMethodBeat.o(91567);
                    return 0;
                case 16:
                    cxg.MBM = aVar3.UbS.zi();
                    AppMethodBeat.o(91567);
                    return 0;
                case 17:
                    cxg.yPM = aVar3.UbS.readString();
                    AppMethodBeat.o(91567);
                    return 0;
                case 18:
                    cxg.MBN = aVar3.UbS.zi();
                    AppMethodBeat.o(91567);
                    return 0;
                case 19:
                    cxg.yPL = aVar3.UbS.readString();
                    AppMethodBeat.o(91567);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dju dju = new dju();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dju.populateBuilderWithField(aVar6, dju, dpc.getNextFieldNumber(aVar6))) {
                        }
                        cxg.LgT = dju;
                    }
                    AppMethodBeat.o(91567);
                    return 0;
                case 21:
                    cxg.MBO = aVar3.UbS.readString();
                    AppMethodBeat.o(91567);
                    return 0;
                default:
                    AppMethodBeat.o(91567);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91567);
            return -1;
        }
    }
}
