package com.tencent.mm.protocal.protobuf;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eiw extends a {
    public String BmI;
    public int Eso;
    public LinkedList<aca> IDO = new LinkedList<>();
    public String IED;
    public String IEE;
    public String IEF;
    public String IEG;
    public String IEH;
    public String MwR;
    public int NiA;
    public int NiB;
    public boolean NiC;
    public String NiD;
    public eiu NiE;
    public int NiF;
    public eiw NiG;
    public int NiH;
    public eip NiI;
    public int NiJ;
    public String Nio;
    public long Nip;
    public String Niq;
    public String Nir;
    public int Nis;
    public String Nit;
    public long Niu;
    public long Niv;
    public LinkedList<eiy> Niw = new LinkedList<>();
    public int Nix;
    public long Niy;
    public eir Niz;
    public long dDw;
    public boolean dEF;
    public String eby;
    public String msN;
    public String psI;
    public String rCq;
    public String source;
    public int thumbHeight;
    public int thumbWidth;
    public long timestamp;
    public String title;
    public String videoUrl;
    public String wWb;
    public String xDQ;
    public LinkedList<dyi> xuO = new LinkedList<>();

    public eiw() {
        AppMethodBeat.i(153012);
        AppMethodBeat.o(153012);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153013);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.videoUrl != null) {
                aVar.e(2, this.videoUrl);
            }
            if (this.Nio != null) {
                aVar.e(3, this.Nio);
            }
            aVar.aM(4, this.Eso);
            if (this.psI != null) {
                aVar.e(5, this.psI);
            }
            aVar.aM(6, this.thumbWidth);
            aVar.aM(7, this.thumbHeight);
            if (this.rCq != null) {
                aVar.e(8, this.rCq);
            }
            if (this.msN != null) {
                aVar.e(9, this.msN);
            }
            if (this.xDQ != null) {
                aVar.e(10, this.xDQ);
            }
            if (this.IED != null) {
                aVar.e(11, this.IED);
            }
            if (this.IEE != null) {
                aVar.e(12, this.IEE);
            }
            if (this.IEF != null) {
                aVar.e(13, this.IEF);
            }
            if (this.source != null) {
                aVar.e(14, this.source);
            }
            if (this.eby != null) {
                aVar.e(15, this.eby);
            }
            aVar.bb(16, this.Nip);
            if (this.Niq != null) {
                aVar.e(17, this.Niq);
            }
            if (this.Nir != null) {
                aVar.e(18, this.Nir);
            }
            if (this.IEG != null) {
                aVar.e(19, this.IEG);
            }
            if (this.IEH != null) {
                aVar.e(20, this.IEH);
            }
            aVar.aM(21, this.Nis);
            if (this.Nit != null) {
                aVar.e(22, this.Nit);
            }
            if (this.MwR != null) {
                aVar.e(23, this.MwR);
            }
            aVar.e(24, 8, this.xuO);
            aVar.bb(25, this.timestamp);
            aVar.cc(26, this.dEF);
            if (this.wWb != null) {
                aVar.e(27, this.wWb);
            }
            aVar.bb(28, this.Niu);
            aVar.bb(29, this.dDw);
            aVar.bb(30, this.Niv);
            aVar.e(31, 8, this.Niw);
            aVar.aM(32, this.Nix);
            aVar.bb(33, this.Niy);
            if (this.Niz != null) {
                aVar.ni(34, this.Niz.computeSize());
                this.Niz.writeFields(aVar);
            }
            aVar.aM(35, this.NiA);
            aVar.aM(36, this.NiB);
            aVar.cc(37, this.NiC);
            if (this.NiD != null) {
                aVar.e(38, this.NiD);
            }
            if (this.NiE != null) {
                aVar.ni(39, this.NiE.computeSize());
                this.NiE.writeFields(aVar);
            }
            aVar.aM(40, this.NiF);
            if (this.NiG != null) {
                aVar.ni(41, this.NiG.computeSize());
                this.NiG.writeFields(aVar);
            }
            aVar.e(42, 8, this.IDO);
            aVar.aM(43, this.NiH);
            if (this.NiI != null) {
                aVar.ni(44, this.NiI.computeSize());
                this.NiI.writeFields(aVar);
            }
            if (this.BmI != null) {
                aVar.e(45, this.BmI);
            }
            aVar.aM(46, this.NiJ);
            AppMethodBeat.o(153013);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.videoUrl != null) {
                f2 += g.a.a.b.b.a.f(2, this.videoUrl);
            }
            if (this.Nio != null) {
                f2 += g.a.a.b.b.a.f(3, this.Nio);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.Eso);
            if (this.psI != null) {
                bu += g.a.a.b.b.a.f(5, this.psI);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.thumbWidth) + g.a.a.b.b.a.bu(7, this.thumbHeight);
            if (this.rCq != null) {
                bu2 += g.a.a.b.b.a.f(8, this.rCq);
            }
            if (this.msN != null) {
                bu2 += g.a.a.b.b.a.f(9, this.msN);
            }
            if (this.xDQ != null) {
                bu2 += g.a.a.b.b.a.f(10, this.xDQ);
            }
            if (this.IED != null) {
                bu2 += g.a.a.b.b.a.f(11, this.IED);
            }
            if (this.IEE != null) {
                bu2 += g.a.a.b.b.a.f(12, this.IEE);
            }
            if (this.IEF != null) {
                bu2 += g.a.a.b.b.a.f(13, this.IEF);
            }
            if (this.source != null) {
                bu2 += g.a.a.b.b.a.f(14, this.source);
            }
            if (this.eby != null) {
                bu2 += g.a.a.b.b.a.f(15, this.eby);
            }
            int r = bu2 + g.a.a.b.b.a.r(16, this.Nip);
            if (this.Niq != null) {
                r += g.a.a.b.b.a.f(17, this.Niq);
            }
            if (this.Nir != null) {
                r += g.a.a.b.b.a.f(18, this.Nir);
            }
            if (this.IEG != null) {
                r += g.a.a.b.b.a.f(19, this.IEG);
            }
            if (this.IEH != null) {
                r += g.a.a.b.b.a.f(20, this.IEH);
            }
            int bu3 = r + g.a.a.b.b.a.bu(21, this.Nis);
            if (this.Nit != null) {
                bu3 += g.a.a.b.b.a.f(22, this.Nit);
            }
            if (this.MwR != null) {
                bu3 += g.a.a.b.b.a.f(23, this.MwR);
            }
            int c2 = bu3 + g.a.a.a.c(24, 8, this.xuO) + g.a.a.b.b.a.r(25, this.timestamp) + g.a.a.b.b.a.fS(26) + 1;
            if (this.wWb != null) {
                c2 += g.a.a.b.b.a.f(27, this.wWb);
            }
            int r2 = c2 + g.a.a.b.b.a.r(28, this.Niu) + g.a.a.b.b.a.r(29, this.dDw) + g.a.a.b.b.a.r(30, this.Niv) + g.a.a.a.c(31, 8, this.Niw) + g.a.a.b.b.a.bu(32, this.Nix) + g.a.a.b.b.a.r(33, this.Niy);
            if (this.Niz != null) {
                r2 += g.a.a.a.nh(34, this.Niz.computeSize());
            }
            int bu4 = r2 + g.a.a.b.b.a.bu(35, this.NiA) + g.a.a.b.b.a.bu(36, this.NiB) + g.a.a.b.b.a.fS(37) + 1;
            if (this.NiD != null) {
                bu4 += g.a.a.b.b.a.f(38, this.NiD);
            }
            if (this.NiE != null) {
                bu4 += g.a.a.a.nh(39, this.NiE.computeSize());
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(40, this.NiF);
            if (this.NiG != null) {
                bu5 += g.a.a.a.nh(41, this.NiG.computeSize());
            }
            int c3 = bu5 + g.a.a.a.c(42, 8, this.IDO) + g.a.a.b.b.a.bu(43, this.NiH);
            if (this.NiI != null) {
                c3 += g.a.a.a.nh(44, this.NiI.computeSize());
            }
            if (this.BmI != null) {
                c3 += g.a.a.b.b.a.f(45, this.BmI);
            }
            int bu6 = c3 + g.a.a.b.b.a.bu(46, this.NiJ);
            AppMethodBeat.o(153013);
            return bu6;
        } else if (i2 == 2) {
            this.xuO.clear();
            this.Niw.clear();
            this.IDO.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153013);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eiw eiw = (eiw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eiw.title = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 2:
                    eiw.videoUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 3:
                    eiw.Nio = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 4:
                    eiw.Eso = aVar3.UbS.zi();
                    AppMethodBeat.o(153013);
                    return 0;
                case 5:
                    eiw.psI = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 6:
                    eiw.thumbWidth = aVar3.UbS.zi();
                    AppMethodBeat.o(153013);
                    return 0;
                case 7:
                    eiw.thumbHeight = aVar3.UbS.zi();
                    AppMethodBeat.o(153013);
                    return 0;
                case 8:
                    eiw.rCq = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 9:
                    eiw.msN = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 10:
                    eiw.xDQ = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 11:
                    eiw.IED = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 12:
                    eiw.IEE = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 13:
                    eiw.IEF = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 14:
                    eiw.source = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 15:
                    eiw.eby = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 16:
                    eiw.Nip = aVar3.UbS.zl();
                    AppMethodBeat.o(153013);
                    return 0;
                case 17:
                    eiw.Niq = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 18:
                    eiw.Nir = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 19:
                    eiw.IEG = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 20:
                    eiw.IEH = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 21:
                    eiw.Nis = aVar3.UbS.zi();
                    AppMethodBeat.o(153013);
                    return 0;
                case 22:
                    eiw.Nit = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 23:
                    eiw.MwR = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 24:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dyi dyi = new dyi();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dyi.populateBuilderWithField(aVar4, dyi, a.getNextFieldNumber(aVar4))) {
                        }
                        eiw.xuO.add(dyi);
                    }
                    AppMethodBeat.o(153013);
                    return 0;
                case 25:
                    eiw.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(153013);
                    return 0;
                case 26:
                    eiw.dEF = aVar3.UbS.yZ();
                    AppMethodBeat.o(153013);
                    return 0;
                case 27:
                    eiw.wWb = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 28:
                    eiw.Niu = aVar3.UbS.zl();
                    AppMethodBeat.o(153013);
                    return 0;
                case 29:
                    eiw.dDw = aVar3.UbS.zl();
                    AppMethodBeat.o(153013);
                    return 0;
                case 30:
                    eiw.Niv = aVar3.UbS.zl();
                    AppMethodBeat.o(153013);
                    return 0;
                case 31:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eiy eiy = new eiy();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eiy.populateBuilderWithField(aVar5, eiy, a.getNextFieldNumber(aVar5))) {
                        }
                        eiw.Niw.add(eiy);
                    }
                    AppMethodBeat.o(153013);
                    return 0;
                case 32:
                    eiw.Nix = aVar3.UbS.zi();
                    AppMethodBeat.o(153013);
                    return 0;
                case 33:
                    eiw.Niy = aVar3.UbS.zl();
                    AppMethodBeat.o(153013);
                    return 0;
                case 34:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        eir eir = new eir();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = eir.populateBuilderWithField(aVar6, eir, a.getNextFieldNumber(aVar6))) {
                        }
                        eiw.Niz = eir;
                    }
                    AppMethodBeat.o(153013);
                    return 0;
                case 35:
                    eiw.NiA = aVar3.UbS.zi();
                    AppMethodBeat.o(153013);
                    return 0;
                case 36:
                    eiw.NiB = aVar3.UbS.zi();
                    AppMethodBeat.o(153013);
                    return 0;
                case 37:
                    eiw.NiC = aVar3.UbS.yZ();
                    AppMethodBeat.o(153013);
                    return 0;
                case 38:
                    eiw.NiD = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 39:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        eiu eiu = new eiu();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = eiu.populateBuilderWithField(aVar7, eiu, a.getNextFieldNumber(aVar7))) {
                        }
                        eiw.NiE = eiu;
                    }
                    AppMethodBeat.o(153013);
                    return 0;
                case 40:
                    eiw.NiF = aVar3.UbS.zi();
                    AppMethodBeat.o(153013);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        eiw eiw2 = new eiw();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = eiw2.populateBuilderWithField(aVar8, eiw2, a.getNextFieldNumber(aVar8))) {
                        }
                        eiw.NiG = eiw2;
                    }
                    AppMethodBeat.o(153013);
                    return 0;
                case 42:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        aca aca = new aca();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = aca.populateBuilderWithField(aVar9, aca, a.getNextFieldNumber(aVar9))) {
                        }
                        eiw.IDO.add(aca);
                    }
                    AppMethodBeat.o(153013);
                    return 0;
                case 43:
                    eiw.NiH = aVar3.UbS.zi();
                    AppMethodBeat.o(153013);
                    return 0;
                case 44:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        eip eip = new eip();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = eip.populateBuilderWithField(aVar10, eip, a.getNextFieldNumber(aVar10))) {
                        }
                        eiw.NiI = eip;
                    }
                    AppMethodBeat.o(153013);
                    return 0;
                case 45:
                    eiw.BmI = aVar3.UbS.readString();
                    AppMethodBeat.o(153013);
                    return 0;
                case 46:
                    eiw.NiJ = aVar3.UbS.zi();
                    AppMethodBeat.o(153013);
                    return 0;
                default:
                    AppMethodBeat.o(153013);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153013);
            return -1;
        }
    }
}
