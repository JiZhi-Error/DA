package com.tencent.mm.protocal.protobuf;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class eos extends a {
    public int KEf;
    public cih KHD;
    public String KPA;
    public dql KQo;
    public int LRD;
    public int LiC;
    public String LiD;
    public String LiE;
    public String LiF;
    public String Lir;
    public String Lis;
    public String Liv;
    public int MKH;
    public int MVK;
    public ebj MmQ;
    public String MvT;
    public String Mvo;
    public String Mvp;
    public String NmA;
    public String NmB;
    public String NmC;
    public String NmD;
    public czl NmE;
    public String NmF;
    public int NmG;
    public long NmH;
    public String NmI;
    public eel NmJ;
    public long NmK;
    public int NmL;
    public String NmM;
    public int NmN;
    public int NmO;
    public int NmP;
    public fff NmQ;
    public String NmR;
    public long NmS;
    public String Nmq;
    public String Nmr;
    public int Nms;
    public int Nmt;
    public int Nmu;
    public String Nmv;
    public int Nmw;
    public dqi Nmx;
    public int Nmy;
    public String Nmz;
    public String fuW;
    public String kei;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(134260);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MmQ == null) {
                b bVar = new b("Not all required fields were included: SnsUserInfo");
                AppMethodBeat.o(134260);
                throw bVar;
            }
            if (this.MmQ != null) {
                aVar.ni(1, this.MmQ.computeSize());
                this.MmQ.writeFields(aVar);
            }
            if (this.kei != null) {
                aVar.e(2, this.kei);
            }
            if (this.Nmq != null) {
                aVar.e(3, this.Nmq);
            }
            if (this.Nmr != null) {
                aVar.e(4, this.Nmr);
            }
            aVar.aM(5, this.Nms);
            aVar.aM(6, this.Nmt);
            aVar.aM(7, this.Nmu);
            if (this.Nmv != null) {
                aVar.e(8, this.Nmv);
            }
            if (this.Lir != null) {
                aVar.e(9, this.Lir);
            }
            if (this.Lis != null) {
                aVar.e(10, this.Lis);
            }
            aVar.aM(11, this.Nmw);
            if (this.Nmx != null) {
                aVar.ni(12, this.Nmx.computeSize());
                this.Nmx.writeFields(aVar);
            }
            if (this.KQo != null) {
                aVar.ni(13, this.KQo.computeSize());
                this.KQo.writeFields(aVar);
            }
            aVar.aM(14, this.KEf);
            aVar.aM(15, this.Nmy);
            if (this.KPA != null) {
                aVar.e(16, this.KPA);
            }
            if (this.Mvo != null) {
                aVar.e(17, this.Mvo);
            }
            if (this.Mvp != null) {
                aVar.e(18, this.Mvp);
            }
            if (this.Nmz != null) {
                aVar.e(19, this.Nmz);
            }
            if (this.NmA != null) {
                aVar.e(20, this.NmA);
            }
            if (this.NmB != null) {
                aVar.e(21, this.NmB);
            }
            if (this.NmC != null) {
                aVar.e(22, this.NmC);
            }
            if (this.KHD != null) {
                aVar.ni(23, this.KHD.computeSize());
                this.KHD.writeFields(aVar);
            }
            if (this.NmD != null) {
                aVar.e(24, this.NmD);
            }
            if (this.NmE != null) {
                aVar.ni(25, this.NmE.computeSize());
                this.NmE.writeFields(aVar);
            }
            if (this.NmF != null) {
                aVar.e(26, this.NmF);
            }
            aVar.aM(27, this.NmG);
            if (this.fuW != null) {
                aVar.e(28, this.fuW);
            }
            aVar.aM(29, this.LRD);
            aVar.bb(30, this.NmH);
            if (this.NmI != null) {
                aVar.e(31, this.NmI);
            }
            aVar.aM(32, this.MKH);
            if (this.NmJ != null) {
                aVar.ni(33, this.NmJ.computeSize());
                this.NmJ.writeFields(aVar);
            }
            aVar.bb(34, this.NmK);
            aVar.aM(35, this.NmL);
            if (this.Liv != null) {
                aVar.e(36, this.Liv);
            }
            if (this.NmM != null) {
                aVar.e(37, this.NmM);
            }
            if (this.MvT != null) {
                aVar.e(38, this.MvT);
            }
            aVar.aM(39, this.MVK);
            aVar.aM(44, this.NmN);
            aVar.aM(45, this.NmO);
            aVar.aM(46, this.NmP);
            if (this.NmQ != null) {
                aVar.ni(47, this.NmQ.computeSize());
                this.NmQ.writeFields(aVar);
            }
            aVar.aM(48, this.LiC);
            if (this.LiD != null) {
                aVar.e(49, this.LiD);
            }
            if (this.LiF != null) {
                aVar.e(51, this.LiF);
            }
            if (this.LiE != null) {
                aVar.e(50, this.LiE);
            }
            if (this.NmR != null) {
                aVar.e(52, this.NmR);
            }
            aVar.bb(53, this.NmS);
            AppMethodBeat.o(134260);
            return 0;
        } else if (i2 == 1) {
            int nh = this.MmQ != null ? g.a.a.a.nh(1, this.MmQ.computeSize()) + 0 : 0;
            if (this.kei != null) {
                nh += g.a.a.b.b.a.f(2, this.kei);
            }
            if (this.Nmq != null) {
                nh += g.a.a.b.b.a.f(3, this.Nmq);
            }
            if (this.Nmr != null) {
                nh += g.a.a.b.b.a.f(4, this.Nmr);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.Nms) + g.a.a.b.b.a.bu(6, this.Nmt) + g.a.a.b.b.a.bu(7, this.Nmu);
            if (this.Nmv != null) {
                bu += g.a.a.b.b.a.f(8, this.Nmv);
            }
            if (this.Lir != null) {
                bu += g.a.a.b.b.a.f(9, this.Lir);
            }
            if (this.Lis != null) {
                bu += g.a.a.b.b.a.f(10, this.Lis);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(11, this.Nmw);
            if (this.Nmx != null) {
                bu2 += g.a.a.a.nh(12, this.Nmx.computeSize());
            }
            if (this.KQo != null) {
                bu2 += g.a.a.a.nh(13, this.KQo.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(14, this.KEf) + g.a.a.b.b.a.bu(15, this.Nmy);
            if (this.KPA != null) {
                bu3 += g.a.a.b.b.a.f(16, this.KPA);
            }
            if (this.Mvo != null) {
                bu3 += g.a.a.b.b.a.f(17, this.Mvo);
            }
            if (this.Mvp != null) {
                bu3 += g.a.a.b.b.a.f(18, this.Mvp);
            }
            if (this.Nmz != null) {
                bu3 += g.a.a.b.b.a.f(19, this.Nmz);
            }
            if (this.NmA != null) {
                bu3 += g.a.a.b.b.a.f(20, this.NmA);
            }
            if (this.NmB != null) {
                bu3 += g.a.a.b.b.a.f(21, this.NmB);
            }
            if (this.NmC != null) {
                bu3 += g.a.a.b.b.a.f(22, this.NmC);
            }
            if (this.KHD != null) {
                bu3 += g.a.a.a.nh(23, this.KHD.computeSize());
            }
            if (this.NmD != null) {
                bu3 += g.a.a.b.b.a.f(24, this.NmD);
            }
            if (this.NmE != null) {
                bu3 += g.a.a.a.nh(25, this.NmE.computeSize());
            }
            if (this.NmF != null) {
                bu3 += g.a.a.b.b.a.f(26, this.NmF);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(27, this.NmG);
            if (this.fuW != null) {
                bu4 += g.a.a.b.b.a.f(28, this.fuW);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(29, this.LRD) + g.a.a.b.b.a.r(30, this.NmH);
            if (this.NmI != null) {
                bu5 += g.a.a.b.b.a.f(31, this.NmI);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(32, this.MKH);
            if (this.NmJ != null) {
                bu6 += g.a.a.a.nh(33, this.NmJ.computeSize());
            }
            int r = bu6 + g.a.a.b.b.a.r(34, this.NmK) + g.a.a.b.b.a.bu(35, this.NmL);
            if (this.Liv != null) {
                r += g.a.a.b.b.a.f(36, this.Liv);
            }
            if (this.NmM != null) {
                r += g.a.a.b.b.a.f(37, this.NmM);
            }
            if (this.MvT != null) {
                r += g.a.a.b.b.a.f(38, this.MvT);
            }
            int bu7 = r + g.a.a.b.b.a.bu(39, this.MVK) + g.a.a.b.b.a.bu(44, this.NmN) + g.a.a.b.b.a.bu(45, this.NmO) + g.a.a.b.b.a.bu(46, this.NmP);
            if (this.NmQ != null) {
                bu7 += g.a.a.a.nh(47, this.NmQ.computeSize());
            }
            int bu8 = bu7 + g.a.a.b.b.a.bu(48, this.LiC);
            if (this.LiD != null) {
                bu8 += g.a.a.b.b.a.f(49, this.LiD);
            }
            if (this.LiF != null) {
                bu8 += g.a.a.b.b.a.f(51, this.LiF);
            }
            if (this.LiE != null) {
                bu8 += g.a.a.b.b.a.f(50, this.LiE);
            }
            if (this.NmR != null) {
                bu8 += g.a.a.b.b.a.f(52, this.NmR);
            }
            int r2 = bu8 + g.a.a.b.b.a.r(53, this.NmS);
            AppMethodBeat.o(134260);
            return r2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MmQ == null) {
                b bVar2 = new b("Not all required fields were included: SnsUserInfo");
                AppMethodBeat.o(134260);
                throw bVar2;
            }
            AppMethodBeat.o(134260);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eos eos = (eos) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ebj ebj = new ebj();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ebj.populateBuilderWithField(aVar4, ebj, a.getNextFieldNumber(aVar4))) {
                        }
                        eos.MmQ = ebj;
                    }
                    AppMethodBeat.o(134260);
                    return 0;
                case 2:
                    eos.kei = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 3:
                    eos.Nmq = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 4:
                    eos.Nmr = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 5:
                    eos.Nms = aVar3.UbS.zi();
                    AppMethodBeat.o(134260);
                    return 0;
                case 6:
                    eos.Nmt = aVar3.UbS.zi();
                    AppMethodBeat.o(134260);
                    return 0;
                case 7:
                    eos.Nmu = aVar3.UbS.zi();
                    AppMethodBeat.o(134260);
                    return 0;
                case 8:
                    eos.Nmv = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 9:
                    eos.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 10:
                    eos.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 11:
                    eos.Nmw = aVar3.UbS.zi();
                    AppMethodBeat.o(134260);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, a.getNextFieldNumber(aVar5))) {
                        }
                        eos.Nmx = dqi;
                    }
                    AppMethodBeat.o(134260);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dql dql = new dql();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dql.populateBuilderWithField(aVar6, dql, a.getNextFieldNumber(aVar6))) {
                        }
                        eos.KQo = dql;
                    }
                    AppMethodBeat.o(134260);
                    return 0;
                case 14:
                    eos.KEf = aVar3.UbS.zi();
                    AppMethodBeat.o(134260);
                    return 0;
                case 15:
                    eos.Nmy = aVar3.UbS.zi();
                    AppMethodBeat.o(134260);
                    return 0;
                case 16:
                    eos.KPA = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 17:
                    eos.Mvo = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 18:
                    eos.Mvp = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 19:
                    eos.Nmz = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 20:
                    eos.NmA = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 21:
                    eos.NmB = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 22:
                    eos.NmC = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cih cih = new cih();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = cih.populateBuilderWithField(aVar7, cih, a.getNextFieldNumber(aVar7))) {
                        }
                        eos.KHD = cih;
                    }
                    AppMethodBeat.o(134260);
                    return 0;
                case 24:
                    eos.NmD = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 25:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        czl czl = new czl();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = czl.populateBuilderWithField(aVar8, czl, a.getNextFieldNumber(aVar8))) {
                        }
                        eos.NmE = czl;
                    }
                    AppMethodBeat.o(134260);
                    return 0;
                case 26:
                    eos.NmF = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 27:
                    eos.NmG = aVar3.UbS.zi();
                    AppMethodBeat.o(134260);
                    return 0;
                case 28:
                    eos.fuW = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 29:
                    eos.LRD = aVar3.UbS.zi();
                    AppMethodBeat.o(134260);
                    return 0;
                case 30:
                    eos.NmH = aVar3.UbS.zl();
                    AppMethodBeat.o(134260);
                    return 0;
                case 31:
                    eos.NmI = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 32:
                    eos.MKH = aVar3.UbS.zi();
                    AppMethodBeat.o(134260);
                    return 0;
                case 33:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        eel eel = new eel();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = eel.populateBuilderWithField(aVar9, eel, a.getNextFieldNumber(aVar9))) {
                        }
                        eos.NmJ = eel;
                    }
                    AppMethodBeat.o(134260);
                    return 0;
                case 34:
                    eos.NmK = aVar3.UbS.zl();
                    AppMethodBeat.o(134260);
                    return 0;
                case 35:
                    eos.NmL = aVar3.UbS.zi();
                    AppMethodBeat.o(134260);
                    return 0;
                case 36:
                    eos.Liv = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 37:
                    eos.NmM = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 38:
                    eos.MvT = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 39:
                    eos.MVK = aVar3.UbS.zi();
                    AppMethodBeat.o(134260);
                    return 0;
                case 40:
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                case 42:
                case 43:
                default:
                    AppMethodBeat.o(134260);
                    return -1;
                case 44:
                    eos.NmN = aVar3.UbS.zi();
                    AppMethodBeat.o(134260);
                    return 0;
                case 45:
                    eos.NmO = aVar3.UbS.zi();
                    AppMethodBeat.o(134260);
                    return 0;
                case 46:
                    eos.NmP = aVar3.UbS.zi();
                    AppMethodBeat.o(134260);
                    return 0;
                case 47:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        fff fff = new fff();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = fff.populateBuilderWithField(aVar10, fff, a.getNextFieldNumber(aVar10))) {
                        }
                        eos.NmQ = fff;
                    }
                    AppMethodBeat.o(134260);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    eos.LiC = aVar3.UbS.zi();
                    AppMethodBeat.o(134260);
                    return 0;
                case 49:
                    eos.LiD = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 50:
                    eos.LiE = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 51:
                    eos.LiF = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 52:
                    eos.NmR = aVar3.UbS.readString();
                    AppMethodBeat.o(134260);
                    return 0;
                case 53:
                    eos.NmS = aVar3.UbS.zl();
                    AppMethodBeat.o(134260);
                    return 0;
            }
        } else {
            AppMethodBeat.o(134260);
            return -1;
        }
    }
}
