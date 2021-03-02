package com.tencent.mm.protocal.protobuf;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class as extends dpc {
    public String KDA;
    public boolean KDB = false;
    public int KDC;
    public int KDD;
    public int KDE;
    public String KDF;
    public String KDG;
    public int KDH;
    public String KDI;
    public String KDJ;
    public String KDK;
    public String KDL;
    public String KDM;
    public String KDN;
    public String KDO;
    public String KDP;
    public String KDp;
    public String KDq;
    public String KDr;
    public String KDs;
    public String KDt;
    public String KDu;
    public String KDv;
    public String KDw;
    public String KDx;
    public String KDy;
    public String KDz;
    public String content;
    public String ixw;
    public String pRX;
    public LinkedList<av> pSO = new LinkedList<>();
    public LinkedList<aw> pSP = new LinkedList<>();
    public String pSQ;
    public int pSR;
    public String pSS;
    public String pST;
    public String pSU;
    public String pSV;
    public String pSW;
    public String pSX;
    public int pSY;
    public String pSZ;
    public String pTa;
    public String pTb;
    public String pTc;
    public String pTd;
    public String pTe;

    public as() {
        AppMethodBeat.i(113928);
        AppMethodBeat.o(113928);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113929);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseResponse != null) {
                aVar.ni(1, this.BaseResponse.computeSize());
                this.BaseResponse.writeFields(aVar);
            }
            if (this.KDp != null) {
                aVar.e(2, this.KDp);
            }
            if (this.KDq != null) {
                aVar.e(3, this.KDq);
            }
            if (this.KDr != null) {
                aVar.e(4, this.KDr);
            }
            if (this.content != null) {
                aVar.e(5, this.content);
            }
            if (this.KDs != null) {
                aVar.e(6, this.KDs);
            }
            if (this.KDt != null) {
                aVar.e(7, this.KDt);
            }
            if (this.KDu != null) {
                aVar.e(8, this.KDu);
            }
            if (this.KDv != null) {
                aVar.e(9, this.KDv);
            }
            if (this.KDw != null) {
                aVar.e(10, this.KDw);
            }
            if (this.KDx != null) {
                aVar.e(11, this.KDx);
            }
            if (this.KDy != null) {
                aVar.e(12, this.KDy);
            }
            if (this.KDz != null) {
                aVar.e(13, this.KDz);
            }
            if (this.pTd != null) {
                aVar.e(14, this.pTd);
            }
            if (this.pTe != null) {
                aVar.e(15, this.pTe);
            }
            if (this.KDA != null) {
                aVar.e(16, this.KDA);
            }
            aVar.cc(17, this.KDB);
            aVar.aM(18, this.KDC);
            aVar.aM(19, this.KDD);
            aVar.aM(20, this.KDE);
            if (this.ixw != null) {
                aVar.e(21, this.ixw);
            }
            if (this.KDF != null) {
                aVar.e(22, this.KDF);
            }
            if (this.KDG != null) {
                aVar.e(23, this.KDG);
            }
            aVar.aM(24, this.KDH);
            if (this.KDI != null) {
                aVar.e(25, this.KDI);
            }
            if (this.KDJ != null) {
                aVar.e(26, this.KDJ);
            }
            if (this.KDK != null) {
                aVar.e(27, this.KDK);
            }
            if (this.KDL != null) {
                aVar.e(28, this.KDL);
            }
            if (this.KDM != null) {
                aVar.e(29, this.KDM);
            }
            if (this.KDN != null) {
                aVar.e(30, this.KDN);
            }
            if (this.KDO != null) {
                aVar.e(31, this.KDO);
            }
            if (this.pRX != null) {
                aVar.e(32, this.pRX);
            }
            if (this.KDP != null) {
                aVar.e(33, this.KDP);
            }
            aVar.e(34, 8, this.pSO);
            aVar.e(35, 8, this.pSP);
            if (this.pSQ != null) {
                aVar.e(36, this.pSQ);
            }
            aVar.aM(37, this.pSR);
            if (this.pSS != null) {
                aVar.e(38, this.pSS);
            }
            if (this.pST != null) {
                aVar.e(39, this.pST);
            }
            if (this.pSU != null) {
                aVar.e(40, this.pSU);
            }
            if (this.pSV != null) {
                aVar.e(41, this.pSV);
            }
            if (this.pSW != null) {
                aVar.e(42, this.pSW);
            }
            if (this.pSX != null) {
                aVar.e(43, this.pSX);
            }
            aVar.aM(44, this.pSY);
            if (this.pSZ != null) {
                aVar.e(45, this.pSZ);
            }
            if (this.pTa != null) {
                aVar.e(46, this.pTa);
            }
            if (this.pTb != null) {
                aVar.e(47, this.pTb);
            }
            if (this.pTc != null) {
                aVar.e(48, this.pTc);
            }
            AppMethodBeat.o(113929);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseResponse != null ? g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0 : 0;
            if (this.KDp != null) {
                nh += g.a.a.b.b.a.f(2, this.KDp);
            }
            if (this.KDq != null) {
                nh += g.a.a.b.b.a.f(3, this.KDq);
            }
            if (this.KDr != null) {
                nh += g.a.a.b.b.a.f(4, this.KDr);
            }
            if (this.content != null) {
                nh += g.a.a.b.b.a.f(5, this.content);
            }
            if (this.KDs != null) {
                nh += g.a.a.b.b.a.f(6, this.KDs);
            }
            if (this.KDt != null) {
                nh += g.a.a.b.b.a.f(7, this.KDt);
            }
            if (this.KDu != null) {
                nh += g.a.a.b.b.a.f(8, this.KDu);
            }
            if (this.KDv != null) {
                nh += g.a.a.b.b.a.f(9, this.KDv);
            }
            if (this.KDw != null) {
                nh += g.a.a.b.b.a.f(10, this.KDw);
            }
            if (this.KDx != null) {
                nh += g.a.a.b.b.a.f(11, this.KDx);
            }
            if (this.KDy != null) {
                nh += g.a.a.b.b.a.f(12, this.KDy);
            }
            if (this.KDz != null) {
                nh += g.a.a.b.b.a.f(13, this.KDz);
            }
            if (this.pTd != null) {
                nh += g.a.a.b.b.a.f(14, this.pTd);
            }
            if (this.pTe != null) {
                nh += g.a.a.b.b.a.f(15, this.pTe);
            }
            if (this.KDA != null) {
                nh += g.a.a.b.b.a.f(16, this.KDA);
            }
            int fS = nh + g.a.a.b.b.a.fS(17) + 1 + g.a.a.b.b.a.bu(18, this.KDC) + g.a.a.b.b.a.bu(19, this.KDD) + g.a.a.b.b.a.bu(20, this.KDE);
            if (this.ixw != null) {
                fS += g.a.a.b.b.a.f(21, this.ixw);
            }
            if (this.KDF != null) {
                fS += g.a.a.b.b.a.f(22, this.KDF);
            }
            if (this.KDG != null) {
                fS += g.a.a.b.b.a.f(23, this.KDG);
            }
            int bu = fS + g.a.a.b.b.a.bu(24, this.KDH);
            if (this.KDI != null) {
                bu += g.a.a.b.b.a.f(25, this.KDI);
            }
            if (this.KDJ != null) {
                bu += g.a.a.b.b.a.f(26, this.KDJ);
            }
            if (this.KDK != null) {
                bu += g.a.a.b.b.a.f(27, this.KDK);
            }
            if (this.KDL != null) {
                bu += g.a.a.b.b.a.f(28, this.KDL);
            }
            if (this.KDM != null) {
                bu += g.a.a.b.b.a.f(29, this.KDM);
            }
            if (this.KDN != null) {
                bu += g.a.a.b.b.a.f(30, this.KDN);
            }
            if (this.KDO != null) {
                bu += g.a.a.b.b.a.f(31, this.KDO);
            }
            if (this.pRX != null) {
                bu += g.a.a.b.b.a.f(32, this.pRX);
            }
            if (this.KDP != null) {
                bu += g.a.a.b.b.a.f(33, this.KDP);
            }
            int c2 = bu + g.a.a.a.c(34, 8, this.pSO) + g.a.a.a.c(35, 8, this.pSP);
            if (this.pSQ != null) {
                c2 += g.a.a.b.b.a.f(36, this.pSQ);
            }
            int bu2 = c2 + g.a.a.b.b.a.bu(37, this.pSR);
            if (this.pSS != null) {
                bu2 += g.a.a.b.b.a.f(38, this.pSS);
            }
            if (this.pST != null) {
                bu2 += g.a.a.b.b.a.f(39, this.pST);
            }
            if (this.pSU != null) {
                bu2 += g.a.a.b.b.a.f(40, this.pSU);
            }
            if (this.pSV != null) {
                bu2 += g.a.a.b.b.a.f(41, this.pSV);
            }
            if (this.pSW != null) {
                bu2 += g.a.a.b.b.a.f(42, this.pSW);
            }
            if (this.pSX != null) {
                bu2 += g.a.a.b.b.a.f(43, this.pSX);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(44, this.pSY);
            if (this.pSZ != null) {
                bu3 += g.a.a.b.b.a.f(45, this.pSZ);
            }
            if (this.pTa != null) {
                bu3 += g.a.a.b.b.a.f(46, this.pTa);
            }
            if (this.pTb != null) {
                bu3 += g.a.a.b.b.a.f(47, this.pTb);
            }
            if (this.pTc != null) {
                bu3 += g.a.a.b.b.a.f(48, this.pTc);
            }
            AppMethodBeat.o(113929);
            return bu3;
        } else if (i2 == 2) {
            this.pSO.clear();
            this.pSP.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dpc.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dpc.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113929);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            as asVar = (as) objArr[1];
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
                        asVar.BaseResponse = baseResponse;
                    }
                    AppMethodBeat.o(113929);
                    return 0;
                case 2:
                    asVar.KDp = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 3:
                    asVar.KDq = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 4:
                    asVar.KDr = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 5:
                    asVar.content = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 6:
                    asVar.KDs = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 7:
                    asVar.KDt = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 8:
                    asVar.KDu = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 9:
                    asVar.KDv = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 10:
                    asVar.KDw = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 11:
                    asVar.KDx = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 12:
                    asVar.KDy = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 13:
                    asVar.KDz = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 14:
                    asVar.pTd = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 15:
                    asVar.pTe = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 16:
                    asVar.KDA = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 17:
                    asVar.KDB = aVar3.UbS.yZ();
                    AppMethodBeat.o(113929);
                    return 0;
                case 18:
                    asVar.KDC = aVar3.UbS.zi();
                    AppMethodBeat.o(113929);
                    return 0;
                case 19:
                    asVar.KDD = aVar3.UbS.zi();
                    AppMethodBeat.o(113929);
                    return 0;
                case 20:
                    asVar.KDE = aVar3.UbS.zi();
                    AppMethodBeat.o(113929);
                    return 0;
                case 21:
                    asVar.ixw = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 22:
                    asVar.KDF = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 23:
                    asVar.KDG = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 24:
                    asVar.KDH = aVar3.UbS.zi();
                    AppMethodBeat.o(113929);
                    return 0;
                case 25:
                    asVar.KDI = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 26:
                    asVar.KDJ = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 27:
                    asVar.KDK = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 28:
                    asVar.KDL = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 29:
                    asVar.KDM = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 30:
                    asVar.KDN = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 31:
                    asVar.KDO = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 32:
                    asVar.pRX = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 33:
                    asVar.KDP = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 34:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        av avVar = new av();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = avVar.populateBuilderWithField(aVar5, avVar, dpc.getNextFieldNumber(aVar5))) {
                        }
                        asVar.pSO.add(avVar);
                    }
                    AppMethodBeat.o(113929);
                    return 0;
                case 35:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        aw awVar = new aw();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = awVar.populateBuilderWithField(aVar6, awVar, dpc.getNextFieldNumber(aVar6))) {
                        }
                        asVar.pSP.add(awVar);
                    }
                    AppMethodBeat.o(113929);
                    return 0;
                case 36:
                    asVar.pSQ = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 37:
                    asVar.pSR = aVar3.UbS.zi();
                    AppMethodBeat.o(113929);
                    return 0;
                case 38:
                    asVar.pSS = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 39:
                    asVar.pST = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 40:
                    asVar.pSU = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    asVar.pSV = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 42:
                    asVar.pSW = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 43:
                    asVar.pSX = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 44:
                    asVar.pSY = aVar3.UbS.zi();
                    AppMethodBeat.o(113929);
                    return 0;
                case 45:
                    asVar.pSZ = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 46:
                    asVar.pTa = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case 47:
                    asVar.pTb = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    asVar.pTc = aVar3.UbS.readString();
                    AppMethodBeat.o(113929);
                    return 0;
                default:
                    AppMethodBeat.o(113929);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113929);
            return -1;
        }
    }
}
