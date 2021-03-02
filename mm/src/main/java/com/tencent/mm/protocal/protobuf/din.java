package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class din extends dpc {
    public int KBv;
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

    public din() {
        AppMethodBeat.i(91656);
        AppMethodBeat.o(91656);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91657);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse == null) {
                b bVar = new b("Not all required fields were included: BaseResponse");
                AppMethodBeat.o(91657);
                throw bVar;
            }
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            aVar.bb(2, this.eht);
            aVar.aM(3, this.MBF);
            aVar.bb(4, this.MBG);
            aVar.aM(5, this.KBv);
            aVar.bb(6, this.MBH);
            aVar.aM(9, this.yPJ);
            aVar.e(10, 8, this.MBI);
            if (this.yPK != null) {
                aVar.e(11, this.yPK);
            }
            if (this.MBJ != null) {
                aVar.e(12, this.MBJ);
            }
            if (this.MBK != null) {
                aVar.e(13, this.MBK);
            }
            if (this.MBL != null) {
                aVar.e(14, this.MBL);
            }
            aVar.aM(15, this.MBM);
            if (this.yPM != null) {
                aVar.e(16, this.yPM);
            }
            aVar.aM(17, this.MBN);
            if (this.yPL != null) {
                aVar.e(18, this.yPL);
            }
            aVar.aM(19, this.MBE);
            aVar.aM(20, this.yPI);
            aVar.aM(21, this.MBD);
            if (this.MBO != null) {
                aVar.e(22, this.MBO);
            }
            AppMethodBeat.o(91657);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.eht) + g.a.a.b.b.a.bu(3, this.MBF) + g.a.a.b.b.a.r(4, this.MBG) + g.a.a.b.b.a.bu(5, this.KBv) + g.a.a.b.b.a.r(6, this.MBH) + g.a.a.b.b.a.bu(9, this.yPJ) + g.a.a.a.c(10, 8, this.MBI);
            if (this.yPK != null) {
                nh += g.a.a.b.b.a.f(11, this.yPK);
            }
            if (this.MBJ != null) {
                nh += g.a.a.b.b.a.f(12, this.MBJ);
            }
            if (this.MBK != null) {
                nh += g.a.a.b.b.a.f(13, this.MBK);
            }
            if (this.MBL != null) {
                nh += g.a.a.b.b.a.f(14, this.MBL);
            }
            int bu = nh + g.a.a.b.b.a.bu(15, this.MBM);
            if (this.yPM != null) {
                bu += g.a.a.b.b.a.f(16, this.yPM);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(17, this.MBN);
            if (this.yPL != null) {
                bu2 += g.a.a.b.b.a.f(18, this.yPL);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(19, this.MBE) + g.a.a.b.b.a.bu(20, this.yPI) + g.a.a.b.b.a.bu(21, this.MBD);
            if (this.MBO != null) {
                bu3 += g.a.a.b.b.a.f(22, this.MBO);
            }
            AppMethodBeat.o(91657);
            return bu3;
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
                AppMethodBeat.o(91657);
                throw bVar2;
            }
            AppMethodBeat.o(91657);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            din din = (din) objArr[1];
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
                        din.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(91657);
                    return 0;
                case 2:
                    din.eht = aVar3.UbS.zl();
                    AppMethodBeat.o(91657);
                    return 0;
                case 3:
                    din.MBF = aVar3.UbS.zi();
                    AppMethodBeat.o(91657);
                    return 0;
                case 4:
                    din.MBG = aVar3.UbS.zl();
                    AppMethodBeat.o(91657);
                    return 0;
                case 5:
                    din.KBv = aVar3.UbS.zi();
                    AppMethodBeat.o(91657);
                    return 0;
                case 6:
                    din.MBH = aVar3.UbS.zl();
                    AppMethodBeat.o(91657);
                    return 0;
                case 7:
                case 8:
                default:
                    AppMethodBeat.o(91657);
                    return -1;
                case 9:
                    din.yPJ = aVar3.UbS.zi();
                    AppMethodBeat.o(91657);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cai cai = new cai();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cai.populateBuilderWithField(aVar5, cai, dpc.getNextFieldNumber(aVar5))) {
                        }
                        din.MBI.add(cai);
                    }
                    AppMethodBeat.o(91657);
                    return 0;
                case 11:
                    din.yPK = aVar3.UbS.readString();
                    AppMethodBeat.o(91657);
                    return 0;
                case 12:
                    din.MBJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91657);
                    return 0;
                case 13:
                    din.MBK = aVar3.UbS.readString();
                    AppMethodBeat.o(91657);
                    return 0;
                case 14:
                    din.MBL = aVar3.UbS.readString();
                    AppMethodBeat.o(91657);
                    return 0;
                case 15:
                    din.MBM = aVar3.UbS.zi();
                    AppMethodBeat.o(91657);
                    return 0;
                case 16:
                    din.yPM = aVar3.UbS.readString();
                    AppMethodBeat.o(91657);
                    return 0;
                case 17:
                    din.MBN = aVar3.UbS.zi();
                    AppMethodBeat.o(91657);
                    return 0;
                case 18:
                    din.yPL = aVar3.UbS.readString();
                    AppMethodBeat.o(91657);
                    return 0;
                case 19:
                    din.MBE = aVar3.UbS.zi();
                    AppMethodBeat.o(91657);
                    return 0;
                case 20:
                    din.yPI = aVar3.UbS.zi();
                    AppMethodBeat.o(91657);
                    return 0;
                case 21:
                    din.MBD = aVar3.UbS.zi();
                    AppMethodBeat.o(91657);
                    return 0;
                case 22:
                    din.MBO = aVar3.UbS.readString();
                    AppMethodBeat.o(91657);
                    return 0;
            }
        } else {
            AppMethodBeat.o(91657);
            return -1;
        }
    }
}
