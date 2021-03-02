package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class nh extends a {
    public int KSA;
    public String KSB;
    public int KSC;
    public int KSD;
    public b KSE;
    public int KSF;
    public dbo KSG;
    public String KSH;
    public String KSI;
    public String KSh;
    public int KSi;
    public String KSj;
    public String KSk;
    public String KSl;
    public String KSm;
    public String KSn;
    public String KSo;
    public int KSp;
    public int KSq;
    public int KSr;
    public int KSs;
    public String KSt;
    public String KSu;
    public int KSv;
    public int KSw;
    public int KSx;
    public String KSy;
    public String KSz;
    public String Title;
    public int iAb;
    public String iAc;
    public int izV;
    public int zbj;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124399);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            if (this.KSh != null) {
                aVar.e(2, this.KSh);
            }
            if (this.iAc != null) {
                aVar.e(3, this.iAc);
            }
            aVar.aM(4, this.KSi);
            if (this.KSj != null) {
                aVar.e(5, this.KSj);
            }
            if (this.KSk != null) {
                aVar.e(6, this.KSk);
            }
            if (this.KSl != null) {
                aVar.e(7, this.KSl);
            }
            if (this.KSm != null) {
                aVar.e(8, this.KSm);
            }
            if (this.KSn != null) {
                aVar.e(9, this.KSn);
            }
            aVar.aM(10, this.iAb);
            if (this.KSo != null) {
                aVar.e(11, this.KSo);
            }
            aVar.aM(12, this.KSp);
            aVar.aM(13, this.KSq);
            aVar.aM(14, this.KSr);
            aVar.aM(15, this.KSs);
            if (this.KSt != null) {
                aVar.e(16, this.KSt);
            }
            if (this.KSu != null) {
                aVar.e(17, this.KSu);
            }
            aVar.aM(18, this.KSv);
            aVar.aM(19, this.KSw);
            aVar.aM(20, this.KSx);
            if (this.KSy != null) {
                aVar.e(21, this.KSy);
            }
            if (this.KSz != null) {
                aVar.e(22, this.KSz);
            }
            aVar.aM(23, this.KSA);
            if (this.KSB != null) {
                aVar.e(24, this.KSB);
            }
            aVar.aM(25, this.KSC);
            aVar.aM(26, this.KSD);
            if (this.KSE != null) {
                aVar.c(27, this.KSE);
            }
            aVar.aM(28, this.zbj);
            aVar.aM(29, this.KSF);
            aVar.aM(30, this.izV);
            if (this.KSG != null) {
                aVar.ni(31, this.KSG.computeSize());
                this.KSG.writeFields(aVar);
            }
            if (this.KSH != null) {
                aVar.e(32, this.KSH);
            }
            if (this.KSI != null) {
                aVar.e(33, this.KSI);
            }
            AppMethodBeat.o(124399);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.KSh != null) {
                f2 += g.a.a.b.b.a.f(2, this.KSh);
            }
            if (this.iAc != null) {
                f2 += g.a.a.b.b.a.f(3, this.iAc);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.KSi);
            if (this.KSj != null) {
                bu += g.a.a.b.b.a.f(5, this.KSj);
            }
            if (this.KSk != null) {
                bu += g.a.a.b.b.a.f(6, this.KSk);
            }
            if (this.KSl != null) {
                bu += g.a.a.b.b.a.f(7, this.KSl);
            }
            if (this.KSm != null) {
                bu += g.a.a.b.b.a.f(8, this.KSm);
            }
            if (this.KSn != null) {
                bu += g.a.a.b.b.a.f(9, this.KSn);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.iAb);
            if (this.KSo != null) {
                bu2 += g.a.a.b.b.a.f(11, this.KSo);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(12, this.KSp) + g.a.a.b.b.a.bu(13, this.KSq) + g.a.a.b.b.a.bu(14, this.KSr) + g.a.a.b.b.a.bu(15, this.KSs);
            if (this.KSt != null) {
                bu3 += g.a.a.b.b.a.f(16, this.KSt);
            }
            if (this.KSu != null) {
                bu3 += g.a.a.b.b.a.f(17, this.KSu);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(18, this.KSv) + g.a.a.b.b.a.bu(19, this.KSw) + g.a.a.b.b.a.bu(20, this.KSx);
            if (this.KSy != null) {
                bu4 += g.a.a.b.b.a.f(21, this.KSy);
            }
            if (this.KSz != null) {
                bu4 += g.a.a.b.b.a.f(22, this.KSz);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(23, this.KSA);
            if (this.KSB != null) {
                bu5 += g.a.a.b.b.a.f(24, this.KSB);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(25, this.KSC) + g.a.a.b.b.a.bu(26, this.KSD);
            if (this.KSE != null) {
                bu6 += g.a.a.b.b.a.b(27, this.KSE);
            }
            int bu7 = bu6 + g.a.a.b.b.a.bu(28, this.zbj) + g.a.a.b.b.a.bu(29, this.KSF) + g.a.a.b.b.a.bu(30, this.izV);
            if (this.KSG != null) {
                bu7 += g.a.a.a.nh(31, this.KSG.computeSize());
            }
            if (this.KSH != null) {
                bu7 += g.a.a.b.b.a.f(32, this.KSH);
            }
            if (this.KSI != null) {
                bu7 += g.a.a.b.b.a.f(33, this.KSI);
            }
            AppMethodBeat.o(124399);
            return bu7;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124399);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            nh nhVar = (nh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    nhVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                case 2:
                    nhVar.KSh = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                case 3:
                    nhVar.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                case 4:
                    nhVar.KSi = aVar3.UbS.zi();
                    AppMethodBeat.o(124399);
                    return 0;
                case 5:
                    nhVar.KSj = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                case 6:
                    nhVar.KSk = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                case 7:
                    nhVar.KSl = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                case 8:
                    nhVar.KSm = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                case 9:
                    nhVar.KSn = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                case 10:
                    nhVar.iAb = aVar3.UbS.zi();
                    AppMethodBeat.o(124399);
                    return 0;
                case 11:
                    nhVar.KSo = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                case 12:
                    nhVar.KSp = aVar3.UbS.zi();
                    AppMethodBeat.o(124399);
                    return 0;
                case 13:
                    nhVar.KSq = aVar3.UbS.zi();
                    AppMethodBeat.o(124399);
                    return 0;
                case 14:
                    nhVar.KSr = aVar3.UbS.zi();
                    AppMethodBeat.o(124399);
                    return 0;
                case 15:
                    nhVar.KSs = aVar3.UbS.zi();
                    AppMethodBeat.o(124399);
                    return 0;
                case 16:
                    nhVar.KSt = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                case 17:
                    nhVar.KSu = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                case 18:
                    nhVar.KSv = aVar3.UbS.zi();
                    AppMethodBeat.o(124399);
                    return 0;
                case 19:
                    nhVar.KSw = aVar3.UbS.zi();
                    AppMethodBeat.o(124399);
                    return 0;
                case 20:
                    nhVar.KSx = aVar3.UbS.zi();
                    AppMethodBeat.o(124399);
                    return 0;
                case 21:
                    nhVar.KSy = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                case 22:
                    nhVar.KSz = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                case 23:
                    nhVar.KSA = aVar3.UbS.zi();
                    AppMethodBeat.o(124399);
                    return 0;
                case 24:
                    nhVar.KSB = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                case 25:
                    nhVar.KSC = aVar3.UbS.zi();
                    AppMethodBeat.o(124399);
                    return 0;
                case 26:
                    nhVar.KSD = aVar3.UbS.zi();
                    AppMethodBeat.o(124399);
                    return 0;
                case 27:
                    nhVar.KSE = aVar3.UbS.hPo();
                    AppMethodBeat.o(124399);
                    return 0;
                case 28:
                    nhVar.zbj = aVar3.UbS.zi();
                    AppMethodBeat.o(124399);
                    return 0;
                case 29:
                    nhVar.KSF = aVar3.UbS.zi();
                    AppMethodBeat.o(124399);
                    return 0;
                case 30:
                    nhVar.izV = aVar3.UbS.zi();
                    AppMethodBeat.o(124399);
                    return 0;
                case 31:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dbo dbo = new dbo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dbo.populateBuilderWithField(aVar4, dbo, a.getNextFieldNumber(aVar4))) {
                        }
                        nhVar.KSG = dbo;
                    }
                    AppMethodBeat.o(124399);
                    return 0;
                case 32:
                    nhVar.KSH = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                case 33:
                    nhVar.KSI = aVar3.UbS.readString();
                    AppMethodBeat.o(124399);
                    return 0;
                default:
                    AppMethodBeat.o(124399);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124399);
            return -1;
        }
    }
}
