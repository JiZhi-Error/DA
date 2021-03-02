package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class fau extends a {
    public egk IDN;
    public long KZg;
    public String KZj;
    public int KZk;
    public String LPT;
    public int MEt;
    public int MRb;
    public int MRf;
    public LinkedList<eou> MUs = new LinkedList<>();
    public chl MlQ;
    public aah MlR;
    public LinkedList<aca> Nva = new LinkedList<>();
    public int NwG = 2;
    public String NwH;
    public int NwV;
    public String NwW;
    public String NwX;
    public int NwY;
    public LinkedList<String> NwZ = new LinkedList<>();
    public LinkedList<ctz> Nxa = new LinkedList<>();
    public b Nxb;
    public b Nxc;
    public dzr Nxd;
    public aev Nxe;
    public dci Nxf;
    public egh Nxg;
    public int Scene;
    public String rBI;

    public fau() {
        AppMethodBeat.i(117954);
        AppMethodBeat.o(117954);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117955);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LPT == null) {
                g.a.a.b bVar = new g.a.a.b("Not all required fields were included: Keyword");
                AppMethodBeat.o(117955);
                throw bVar;
            }
            aVar.aM(1, this.MRb);
            if (this.LPT != null) {
                aVar.e(2, this.LPT);
            }
            aVar.aM(3, this.KZk);
            aVar.bb(4, this.KZg);
            aVar.aM(5, this.NwV);
            if (this.MlQ != null) {
                aVar.ni(6, this.MlQ.computeSize());
                this.MlQ.writeFields(aVar);
            }
            aVar.e(7, 8, this.MUs);
            aVar.aM(8, this.Scene);
            if (this.KZj != null) {
                aVar.e(9, this.KZj);
            }
            aVar.aM(10, this.MRf);
            if (this.NwW != null) {
                aVar.e(11, this.NwW);
            }
            if (this.NwX != null) {
                aVar.e(12, this.NwX);
            }
            aVar.aM(13, this.NwY);
            aVar.e(14, 1, this.NwZ);
            aVar.aM(15, this.NwG);
            if (this.IDN != null) {
                aVar.ni(16, this.IDN.computeSize());
                this.IDN.writeFields(aVar);
            }
            aVar.e(17, 8, this.Nva);
            aVar.e(18, 8, this.Nxa);
            if (this.rBI != null) {
                aVar.e(19, this.rBI);
            }
            if (this.Nxb != null) {
                aVar.c(20, this.Nxb);
            }
            if (this.NwH != null) {
                aVar.e(21, this.NwH);
            }
            if (this.Nxc != null) {
                aVar.c(22, this.Nxc);
            }
            if (this.Nxd != null) {
                aVar.ni(23, this.Nxd.computeSize());
                this.Nxd.writeFields(aVar);
            }
            if (this.Nxe != null) {
                aVar.ni(24, this.Nxe.computeSize());
                this.Nxe.writeFields(aVar);
            }
            if (this.Nxf != null) {
                aVar.ni(25, this.Nxf.computeSize());
                this.Nxf.writeFields(aVar);
            }
            aVar.aM(26, this.MEt);
            if (this.MlR != null) {
                aVar.ni(27, this.MlR.computeSize());
                this.MlR.writeFields(aVar);
            }
            if (this.Nxg != null) {
                aVar.ni(28, this.Nxg.computeSize());
                this.Nxg.writeFields(aVar);
            }
            AppMethodBeat.o(117955);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MRb) + 0;
            if (this.LPT != null) {
                bu += g.a.a.b.b.a.f(2, this.LPT);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(3, this.KZk) + g.a.a.b.b.a.r(4, this.KZg) + g.a.a.b.b.a.bu(5, this.NwV);
            if (this.MlQ != null) {
                bu2 += g.a.a.a.nh(6, this.MlQ.computeSize());
            }
            int c2 = bu2 + g.a.a.a.c(7, 8, this.MUs) + g.a.a.b.b.a.bu(8, this.Scene);
            if (this.KZj != null) {
                c2 += g.a.a.b.b.a.f(9, this.KZj);
            }
            int bu3 = c2 + g.a.a.b.b.a.bu(10, this.MRf);
            if (this.NwW != null) {
                bu3 += g.a.a.b.b.a.f(11, this.NwW);
            }
            if (this.NwX != null) {
                bu3 += g.a.a.b.b.a.f(12, this.NwX);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(13, this.NwY) + g.a.a.a.c(14, 1, this.NwZ) + g.a.a.b.b.a.bu(15, this.NwG);
            if (this.IDN != null) {
                bu4 += g.a.a.a.nh(16, this.IDN.computeSize());
            }
            int c3 = bu4 + g.a.a.a.c(17, 8, this.Nva) + g.a.a.a.c(18, 8, this.Nxa);
            if (this.rBI != null) {
                c3 += g.a.a.b.b.a.f(19, this.rBI);
            }
            if (this.Nxb != null) {
                c3 += g.a.a.b.b.a.b(20, this.Nxb);
            }
            if (this.NwH != null) {
                c3 += g.a.a.b.b.a.f(21, this.NwH);
            }
            if (this.Nxc != null) {
                c3 += g.a.a.b.b.a.b(22, this.Nxc);
            }
            if (this.Nxd != null) {
                c3 += g.a.a.a.nh(23, this.Nxd.computeSize());
            }
            if (this.Nxe != null) {
                c3 += g.a.a.a.nh(24, this.Nxe.computeSize());
            }
            if (this.Nxf != null) {
                c3 += g.a.a.a.nh(25, this.Nxf.computeSize());
            }
            int bu5 = c3 + g.a.a.b.b.a.bu(26, this.MEt);
            if (this.MlR != null) {
                bu5 += g.a.a.a.nh(27, this.MlR.computeSize());
            }
            if (this.Nxg != null) {
                bu5 += g.a.a.a.nh(28, this.Nxg.computeSize());
            }
            AppMethodBeat.o(117955);
            return bu5;
        } else if (i2 == 2) {
            this.MUs.clear();
            this.NwZ.clear();
            this.Nva.clear();
            this.Nxa.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LPT == null) {
                g.a.a.b bVar2 = new g.a.a.b("Not all required fields were included: Keyword");
                AppMethodBeat.o(117955);
                throw bVar2;
            }
            AppMethodBeat.o(117955);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fau fau = (fau) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fau.MRb = aVar3.UbS.zi();
                    AppMethodBeat.o(117955);
                    return 0;
                case 2:
                    fau.LPT = aVar3.UbS.readString();
                    AppMethodBeat.o(117955);
                    return 0;
                case 3:
                    fau.KZk = aVar3.UbS.zi();
                    AppMethodBeat.o(117955);
                    return 0;
                case 4:
                    fau.KZg = aVar3.UbS.zl();
                    AppMethodBeat.o(117955);
                    return 0;
                case 5:
                    fau.NwV = aVar3.UbS.zi();
                    AppMethodBeat.o(117955);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        chl chl = new chl();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = chl.populateBuilderWithField(aVar4, chl, a.getNextFieldNumber(aVar4))) {
                        }
                        fau.MlQ = chl;
                    }
                    AppMethodBeat.o(117955);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eou eou = new eou();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eou.populateBuilderWithField(aVar5, eou, a.getNextFieldNumber(aVar5))) {
                        }
                        fau.MUs.add(eou);
                    }
                    AppMethodBeat.o(117955);
                    return 0;
                case 8:
                    fau.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(117955);
                    return 0;
                case 9:
                    fau.KZj = aVar3.UbS.readString();
                    AppMethodBeat.o(117955);
                    return 0;
                case 10:
                    fau.MRf = aVar3.UbS.zi();
                    AppMethodBeat.o(117955);
                    return 0;
                case 11:
                    fau.NwW = aVar3.UbS.readString();
                    AppMethodBeat.o(117955);
                    return 0;
                case 12:
                    fau.NwX = aVar3.UbS.readString();
                    AppMethodBeat.o(117955);
                    return 0;
                case 13:
                    fau.NwY = aVar3.UbS.zi();
                    AppMethodBeat.o(117955);
                    return 0;
                case 14:
                    fau.NwZ.add(aVar3.UbS.readString());
                    AppMethodBeat.o(117955);
                    return 0;
                case 15:
                    fau.NwG = aVar3.UbS.zi();
                    AppMethodBeat.o(117955);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        egk egk = new egk();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = egk.populateBuilderWithField(aVar6, egk, a.getNextFieldNumber(aVar6))) {
                        }
                        fau.IDN = egk;
                    }
                    AppMethodBeat.o(117955);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aca aca = new aca();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aca.populateBuilderWithField(aVar7, aca, a.getNextFieldNumber(aVar7))) {
                        }
                        fau.Nva.add(aca);
                    }
                    AppMethodBeat.o(117955);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ctz ctz = new ctz();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = ctz.populateBuilderWithField(aVar8, ctz, a.getNextFieldNumber(aVar8))) {
                        }
                        fau.Nxa.add(ctz);
                    }
                    AppMethodBeat.o(117955);
                    return 0;
                case 19:
                    fau.rBI = aVar3.UbS.readString();
                    AppMethodBeat.o(117955);
                    return 0;
                case 20:
                    fau.Nxb = aVar3.UbS.hPo();
                    AppMethodBeat.o(117955);
                    return 0;
                case 21:
                    fau.NwH = aVar3.UbS.readString();
                    AppMethodBeat.o(117955);
                    return 0;
                case 22:
                    fau.Nxc = aVar3.UbS.hPo();
                    AppMethodBeat.o(117955);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dzr dzr = new dzr();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dzr.populateBuilderWithField(aVar9, dzr, a.getNextFieldNumber(aVar9))) {
                        }
                        fau.Nxd = dzr;
                    }
                    AppMethodBeat.o(117955);
                    return 0;
                case 24:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        aev aev = new aev();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = aev.populateBuilderWithField(aVar10, aev, a.getNextFieldNumber(aVar10))) {
                        }
                        fau.Nxe = aev;
                    }
                    AppMethodBeat.o(117955);
                    return 0;
                case 25:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        dci dci = new dci();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = dci.populateBuilderWithField(aVar11, dci, a.getNextFieldNumber(aVar11))) {
                        }
                        fau.Nxf = dci;
                    }
                    AppMethodBeat.o(117955);
                    return 0;
                case 26:
                    fau.MEt = aVar3.UbS.zi();
                    AppMethodBeat.o(117955);
                    return 0;
                case 27:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        aah aah = new aah();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = aah.populateBuilderWithField(aVar12, aah, a.getNextFieldNumber(aVar12))) {
                        }
                        fau.MlR = aah;
                    }
                    AppMethodBeat.o(117955);
                    return 0;
                case 28:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        egh egh = new egh();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = egh.populateBuilderWithField(aVar13, egh, a.getNextFieldNumber(aVar13))) {
                        }
                        fau.Nxg = egh;
                    }
                    AppMethodBeat.o(117955);
                    return 0;
                default:
                    AppMethodBeat.o(117955);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117955);
            return -1;
        }
    }
}
