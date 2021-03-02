package com.tencent.mm.plugin.luckymoney.model;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class q extends a {
    public boolean UXw;
    public int UXx;
    public int egY;
    public int egZ;
    public int eha;
    public long eht;
    public int qwe;
    public int resourceId;
    public String yPK;
    public String yQE;
    public int yRN;
    public String yRO;
    public String yRP;
    public String yRQ;
    public String yVA;
    public String yVB;
    public String yVC;
    public String yVD;
    public j yVE;
    public String yVF;
    public String yVb;
    public String yVc;
    public String yVd;
    public String yVe;
    public String yVf;
    public String yVg;
    public long yVh;
    public long yVi;
    public long yVj;
    public String yVk;
    public int yVl;
    public int yVm;
    public int yVn;
    public String yVo;
    public int yVp;
    public i yVq;
    public LinkedList<bg> yVr = new LinkedList<>();
    public bg yVs;
    public String yVt;
    public String yVu;
    public int yVv;
    public LinkedList<ad> yVw = new LinkedList<>();
    public String yVx;
    public String yVy;
    public int yVz;

    public q() {
        AppMethodBeat.i(91253);
        AppMethodBeat.o(91253);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91254);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.egY);
            aVar.aM(2, this.egZ);
            if (this.yVb != null) {
                aVar.e(3, this.yVb);
            }
            if (this.yVc != null) {
                aVar.e(4, this.yVc);
            }
            if (this.yPK != null) {
                aVar.e(5, this.yPK);
            }
            if (this.yVd != null) {
                aVar.e(6, this.yVd);
            }
            if (this.yVe != null) {
                aVar.e(7, this.yVe);
            }
            if (this.yQE != null) {
                aVar.e(8, this.yQE);
            }
            if (this.yVf != null) {
                aVar.e(9, this.yVf);
            }
            if (this.yVg != null) {
                aVar.e(10, this.yVg);
            }
            aVar.bb(11, this.eht);
            aVar.bb(12, this.yVh);
            aVar.bb(13, this.yVi);
            aVar.aM(14, this.qwe);
            aVar.bb(15, this.yVj);
            if (this.yVk != null) {
                aVar.e(16, this.yVk);
            }
            aVar.aM(17, this.yVl);
            aVar.aM(18, this.yVm);
            aVar.aM(19, this.yVn);
            if (this.yVo != null) {
                aVar.e(20, this.yVo);
            }
            aVar.aM(21, this.eha);
            aVar.aM(22, this.yVp);
            if (this.yVq != null) {
                aVar.ni(23, this.yVq.computeSize());
                this.yVq.writeFields(aVar);
            }
            aVar.aM(24, this.yRN);
            if (this.yRP != null) {
                aVar.e(25, this.yRP);
            }
            aVar.e(26, 8, this.yVr);
            if (this.yVs != null) {
                aVar.ni(27, this.yVs.computeSize());
                this.yVs.writeFields(aVar);
            }
            if (this.yVt != null) {
                aVar.e(28, this.yVt);
            }
            if (this.yVu != null) {
                aVar.e(29, this.yVu);
            }
            aVar.aM(30, this.yVv);
            aVar.aM(31, this.resourceId);
            if (this.yRQ != null) {
                aVar.e(32, this.yRQ);
            }
            aVar.e(33, 8, this.yVw);
            if (this.yRO != null) {
                aVar.e(34, this.yRO);
            }
            if (this.yVx != null) {
                aVar.e(35, this.yVx);
            }
            if (this.yVy != null) {
                aVar.e(36, this.yVy);
            }
            aVar.aM(37, this.yVz);
            if (this.yVA != null) {
                aVar.e(38, this.yVA);
            }
            if (this.yVB != null) {
                aVar.e(39, this.yVB);
            }
            if (this.yVC != null) {
                aVar.e(40, this.yVC);
            }
            if (this.yVD != null) {
                aVar.e(41, this.yVD);
            }
            if (this.yVE != null) {
                aVar.ni(42, this.yVE.computeSize());
                this.yVE.writeFields(aVar);
            }
            if (this.yVF != null) {
                aVar.e(43, this.yVF);
            }
            aVar.cc(44, this.UXw);
            aVar.aM(45, this.UXx);
            AppMethodBeat.o(91254);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.egY) + 0 + g.a.a.b.b.a.bu(2, this.egZ);
            if (this.yVb != null) {
                bu += g.a.a.b.b.a.f(3, this.yVb);
            }
            if (this.yVc != null) {
                bu += g.a.a.b.b.a.f(4, this.yVc);
            }
            if (this.yPK != null) {
                bu += g.a.a.b.b.a.f(5, this.yPK);
            }
            if (this.yVd != null) {
                bu += g.a.a.b.b.a.f(6, this.yVd);
            }
            if (this.yVe != null) {
                bu += g.a.a.b.b.a.f(7, this.yVe);
            }
            if (this.yQE != null) {
                bu += g.a.a.b.b.a.f(8, this.yQE);
            }
            if (this.yVf != null) {
                bu += g.a.a.b.b.a.f(9, this.yVf);
            }
            if (this.yVg != null) {
                bu += g.a.a.b.b.a.f(10, this.yVg);
            }
            int r = bu + g.a.a.b.b.a.r(11, this.eht) + g.a.a.b.b.a.r(12, this.yVh) + g.a.a.b.b.a.r(13, this.yVi) + g.a.a.b.b.a.bu(14, this.qwe) + g.a.a.b.b.a.r(15, this.yVj);
            if (this.yVk != null) {
                r += g.a.a.b.b.a.f(16, this.yVk);
            }
            int bu2 = r + g.a.a.b.b.a.bu(17, this.yVl) + g.a.a.b.b.a.bu(18, this.yVm) + g.a.a.b.b.a.bu(19, this.yVn);
            if (this.yVo != null) {
                bu2 += g.a.a.b.b.a.f(20, this.yVo);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(21, this.eha) + g.a.a.b.b.a.bu(22, this.yVp);
            if (this.yVq != null) {
                bu3 += g.a.a.a.nh(23, this.yVq.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(24, this.yRN);
            if (this.yRP != null) {
                bu4 += g.a.a.b.b.a.f(25, this.yRP);
            }
            int c2 = bu4 + g.a.a.a.c(26, 8, this.yVr);
            if (this.yVs != null) {
                c2 += g.a.a.a.nh(27, this.yVs.computeSize());
            }
            if (this.yVt != null) {
                c2 += g.a.a.b.b.a.f(28, this.yVt);
            }
            if (this.yVu != null) {
                c2 += g.a.a.b.b.a.f(29, this.yVu);
            }
            int bu5 = c2 + g.a.a.b.b.a.bu(30, this.yVv) + g.a.a.b.b.a.bu(31, this.resourceId);
            if (this.yRQ != null) {
                bu5 += g.a.a.b.b.a.f(32, this.yRQ);
            }
            int c3 = bu5 + g.a.a.a.c(33, 8, this.yVw);
            if (this.yRO != null) {
                c3 += g.a.a.b.b.a.f(34, this.yRO);
            }
            if (this.yVx != null) {
                c3 += g.a.a.b.b.a.f(35, this.yVx);
            }
            if (this.yVy != null) {
                c3 += g.a.a.b.b.a.f(36, this.yVy);
            }
            int bu6 = c3 + g.a.a.b.b.a.bu(37, this.yVz);
            if (this.yVA != null) {
                bu6 += g.a.a.b.b.a.f(38, this.yVA);
            }
            if (this.yVB != null) {
                bu6 += g.a.a.b.b.a.f(39, this.yVB);
            }
            if (this.yVC != null) {
                bu6 += g.a.a.b.b.a.f(40, this.yVC);
            }
            if (this.yVD != null) {
                bu6 += g.a.a.b.b.a.f(41, this.yVD);
            }
            if (this.yVE != null) {
                bu6 += g.a.a.a.nh(42, this.yVE.computeSize());
            }
            if (this.yVF != null) {
                bu6 += g.a.a.b.b.a.f(43, this.yVF);
            }
            int fS = bu6 + g.a.a.b.b.a.fS(44) + 1 + g.a.a.b.b.a.bu(45, this.UXx);
            AppMethodBeat.o(91254);
            return fS;
        } else if (i2 == 2) {
            this.yVr.clear();
            this.yVw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91254);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            q qVar = (q) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    qVar.egY = aVar3.UbS.zi();
                    AppMethodBeat.o(91254);
                    return 0;
                case 2:
                    qVar.egZ = aVar3.UbS.zi();
                    AppMethodBeat.o(91254);
                    return 0;
                case 3:
                    qVar.yVb = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 4:
                    qVar.yVc = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 5:
                    qVar.yPK = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 6:
                    qVar.yVd = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 7:
                    qVar.yVe = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 8:
                    qVar.yQE = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 9:
                    qVar.yVf = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 10:
                    qVar.yVg = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 11:
                    qVar.eht = aVar3.UbS.zl();
                    AppMethodBeat.o(91254);
                    return 0;
                case 12:
                    qVar.yVh = aVar3.UbS.zl();
                    AppMethodBeat.o(91254);
                    return 0;
                case 13:
                    qVar.yVi = aVar3.UbS.zl();
                    AppMethodBeat.o(91254);
                    return 0;
                case 14:
                    qVar.qwe = aVar3.UbS.zi();
                    AppMethodBeat.o(91254);
                    return 0;
                case 15:
                    qVar.yVj = aVar3.UbS.zl();
                    AppMethodBeat.o(91254);
                    return 0;
                case 16:
                    qVar.yVk = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 17:
                    qVar.yVl = aVar3.UbS.zi();
                    AppMethodBeat.o(91254);
                    return 0;
                case 18:
                    qVar.yVm = aVar3.UbS.zi();
                    AppMethodBeat.o(91254);
                    return 0;
                case 19:
                    qVar.yVn = aVar3.UbS.zi();
                    AppMethodBeat.o(91254);
                    return 0;
                case 20:
                    qVar.yVo = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 21:
                    qVar.eha = aVar3.UbS.zi();
                    AppMethodBeat.o(91254);
                    return 0;
                case 22:
                    qVar.yVp = aVar3.UbS.zi();
                    AppMethodBeat.o(91254);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        i iVar = new i();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = iVar.populateBuilderWithField(aVar4, iVar, a.getNextFieldNumber(aVar4))) {
                        }
                        qVar.yVq = iVar;
                    }
                    AppMethodBeat.o(91254);
                    return 0;
                case 24:
                    qVar.yRN = aVar3.UbS.zi();
                    AppMethodBeat.o(91254);
                    return 0;
                case 25:
                    qVar.yRP = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 26:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bg bgVar = new bg();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bgVar.populateBuilderWithField(aVar5, bgVar, a.getNextFieldNumber(aVar5))) {
                        }
                        qVar.yVr.add(bgVar);
                    }
                    AppMethodBeat.o(91254);
                    return 0;
                case 27:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bg bgVar2 = new bg();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bgVar2.populateBuilderWithField(aVar6, bgVar2, a.getNextFieldNumber(aVar6))) {
                        }
                        qVar.yVs = bgVar2;
                    }
                    AppMethodBeat.o(91254);
                    return 0;
                case 28:
                    qVar.yVt = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 29:
                    qVar.yVu = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 30:
                    qVar.yVv = aVar3.UbS.zi();
                    AppMethodBeat.o(91254);
                    return 0;
                case 31:
                    qVar.resourceId = aVar3.UbS.zi();
                    AppMethodBeat.o(91254);
                    return 0;
                case 32:
                    qVar.yRQ = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 33:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ad adVar = new ad();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = adVar.populateBuilderWithField(aVar7, adVar, a.getNextFieldNumber(aVar7))) {
                        }
                        qVar.yVw.add(adVar);
                    }
                    AppMethodBeat.o(91254);
                    return 0;
                case 34:
                    qVar.yRO = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 35:
                    qVar.yVx = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 36:
                    qVar.yVy = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 37:
                    qVar.yVz = aVar3.UbS.zi();
                    AppMethodBeat.o(91254);
                    return 0;
                case 38:
                    qVar.yVA = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 39:
                    qVar.yVB = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 40:
                    qVar.yVC = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    qVar.yVD = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 42:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        j jVar = new j();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = jVar.populateBuilderWithField(aVar8, jVar, a.getNextFieldNumber(aVar8))) {
                        }
                        qVar.yVE = jVar;
                    }
                    AppMethodBeat.o(91254);
                    return 0;
                case 43:
                    qVar.yVF = aVar3.UbS.readString();
                    AppMethodBeat.o(91254);
                    return 0;
                case 44:
                    qVar.UXw = aVar3.UbS.yZ();
                    AppMethodBeat.o(91254);
                    return 0;
                case 45:
                    qVar.UXx = aVar3.UbS.zi();
                    AppMethodBeat.o(91254);
                    return 0;
                default:
                    AppMethodBeat.o(91254);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91254);
            return -1;
        }
    }
}
