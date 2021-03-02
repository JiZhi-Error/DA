package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cnc extends a {
    public String Bri;
    public LinkedList<dqi> GroupUser = new LinkedList<>();
    public int MsU;
    public int MsV;
    public LinkedList<cjs> MsW = new LinkedList<>();
    public LinkedList<ebm> MsX = new LinkedList<>();
    public int MsY;
    public long MsZ;
    public int Mta;
    public LinkedList<Long> Mtb = new LinkedList<>();
    public int Mtc;
    public int Mtd;
    public String Mte;
    public int Mtf;
    public eam Mtg;
    public LinkedList<eas> Mth = new LinkedList<>();
    public String Mti;
    public long Mtj;
    public String Mtk;
    public boolean Mtl;
    public dzk Mtm;
    public cwz Mtn;
    public int Privated;
    public String eam;
    public int egZ;
    public int ibG;
    public String izX;
    public String sessionId;
    public String token;

    public cnc() {
        AppMethodBeat.i(125744);
        AppMethodBeat.o(125744);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125745);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.MsU);
            aVar.aM(2, this.MsV);
            aVar.aM(3, this.Privated);
            if (this.izX != null) {
                aVar.e(4, this.izX);
            }
            aVar.e(5, 8, this.MsW);
            aVar.e(6, 8, this.MsX);
            aVar.aM(7, this.MsY);
            aVar.aM(8, this.ibG);
            aVar.bb(9, this.MsZ);
            aVar.aM(10, this.Mta);
            aVar.e(11, 3, this.Mtb);
            aVar.aM(12, this.Mtc);
            aVar.aM(13, this.Mtd);
            if (this.token != null) {
                aVar.e(14, this.token);
            }
            if (this.Mte != null) {
                aVar.e(15, this.Mte);
            }
            aVar.aM(16, this.Mtf);
            aVar.e(17, 8, this.GroupUser);
            if (this.Mtg != null) {
                aVar.ni(18, this.Mtg.computeSize());
                this.Mtg.writeFields(aVar);
            }
            if (this.eam != null) {
                aVar.e(19, this.eam);
            }
            aVar.e(20, 8, this.Mth);
            if (this.sessionId != null) {
                aVar.e(21, this.sessionId);
            }
            if (this.Mti != null) {
                aVar.e(22, this.Mti);
            }
            if (this.Bri != null) {
                aVar.e(23, this.Bri);
            }
            aVar.aM(24, this.egZ);
            aVar.bb(25, this.Mtj);
            if (this.Mtk != null) {
                aVar.e(26, this.Mtk);
            }
            aVar.cc(27, this.Mtl);
            if (this.Mtm != null) {
                aVar.ni(28, this.Mtm.computeSize());
                this.Mtm.writeFields(aVar);
            }
            if (this.Mtn != null) {
                aVar.ni(29, this.Mtn.computeSize());
                this.Mtn.writeFields(aVar);
            }
            AppMethodBeat.o(125745);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MsU) + 0 + g.a.a.b.b.a.bu(2, this.MsV) + g.a.a.b.b.a.bu(3, this.Privated);
            if (this.izX != null) {
                bu += g.a.a.b.b.a.f(4, this.izX);
            }
            int c2 = bu + g.a.a.a.c(5, 8, this.MsW) + g.a.a.a.c(6, 8, this.MsX) + g.a.a.b.b.a.bu(7, this.MsY) + g.a.a.b.b.a.bu(8, this.ibG) + g.a.a.b.b.a.r(9, this.MsZ) + g.a.a.b.b.a.bu(10, this.Mta) + g.a.a.a.c(11, 3, this.Mtb) + g.a.a.b.b.a.bu(12, this.Mtc) + g.a.a.b.b.a.bu(13, this.Mtd);
            if (this.token != null) {
                c2 += g.a.a.b.b.a.f(14, this.token);
            }
            if (this.Mte != null) {
                c2 += g.a.a.b.b.a.f(15, this.Mte);
            }
            int bu2 = c2 + g.a.a.b.b.a.bu(16, this.Mtf) + g.a.a.a.c(17, 8, this.GroupUser);
            if (this.Mtg != null) {
                bu2 += g.a.a.a.nh(18, this.Mtg.computeSize());
            }
            if (this.eam != null) {
                bu2 += g.a.a.b.b.a.f(19, this.eam);
            }
            int c3 = bu2 + g.a.a.a.c(20, 8, this.Mth);
            if (this.sessionId != null) {
                c3 += g.a.a.b.b.a.f(21, this.sessionId);
            }
            if (this.Mti != null) {
                c3 += g.a.a.b.b.a.f(22, this.Mti);
            }
            if (this.Bri != null) {
                c3 += g.a.a.b.b.a.f(23, this.Bri);
            }
            int bu3 = c3 + g.a.a.b.b.a.bu(24, this.egZ) + g.a.a.b.b.a.r(25, this.Mtj);
            if (this.Mtk != null) {
                bu3 += g.a.a.b.b.a.f(26, this.Mtk);
            }
            int fS = bu3 + g.a.a.b.b.a.fS(27) + 1;
            if (this.Mtm != null) {
                fS += g.a.a.a.nh(28, this.Mtm.computeSize());
            }
            if (this.Mtn != null) {
                fS += g.a.a.a.nh(29, this.Mtn.computeSize());
            }
            AppMethodBeat.o(125745);
            return fS;
        } else if (i2 == 2) {
            this.MsW.clear();
            this.MsX.clear();
            this.Mtb.clear();
            this.GroupUser.clear();
            this.Mth.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125745);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cnc cnc = (cnc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cnc.MsU = aVar3.UbS.zi();
                    AppMethodBeat.o(125745);
                    return 0;
                case 2:
                    cnc.MsV = aVar3.UbS.zi();
                    AppMethodBeat.o(125745);
                    return 0;
                case 3:
                    cnc.Privated = aVar3.UbS.zi();
                    AppMethodBeat.o(125745);
                    return 0;
                case 4:
                    cnc.izX = aVar3.UbS.readString();
                    AppMethodBeat.o(125745);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cjs cjs = new cjs();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cjs.populateBuilderWithField(aVar4, cjs, a.getNextFieldNumber(aVar4))) {
                        }
                        cnc.MsW.add(cjs);
                    }
                    AppMethodBeat.o(125745);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ebm ebm = new ebm();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ebm.populateBuilderWithField(aVar5, ebm, a.getNextFieldNumber(aVar5))) {
                        }
                        cnc.MsX.add(ebm);
                    }
                    AppMethodBeat.o(125745);
                    return 0;
                case 7:
                    cnc.MsY = aVar3.UbS.zi();
                    AppMethodBeat.o(125745);
                    return 0;
                case 8:
                    cnc.ibG = aVar3.UbS.zi();
                    AppMethodBeat.o(125745);
                    return 0;
                case 9:
                    cnc.MsZ = aVar3.UbS.zl();
                    AppMethodBeat.o(125745);
                    return 0;
                case 10:
                    cnc.Mta = aVar3.UbS.zi();
                    AppMethodBeat.o(125745);
                    return 0;
                case 11:
                    cnc.Mtb.add(Long.valueOf(aVar3.UbS.zl()));
                    AppMethodBeat.o(125745);
                    return 0;
                case 12:
                    cnc.Mtc = aVar3.UbS.zi();
                    AppMethodBeat.o(125745);
                    return 0;
                case 13:
                    cnc.Mtd = aVar3.UbS.zi();
                    AppMethodBeat.o(125745);
                    return 0;
                case 14:
                    cnc.token = aVar3.UbS.readString();
                    AppMethodBeat.o(125745);
                    return 0;
                case 15:
                    cnc.Mte = aVar3.UbS.readString();
                    AppMethodBeat.o(125745);
                    return 0;
                case 16:
                    cnc.Mtf = aVar3.UbS.zi();
                    AppMethodBeat.o(125745);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi.populateBuilderWithField(aVar6, dqi, a.getNextFieldNumber(aVar6))) {
                        }
                        cnc.GroupUser.add(dqi);
                    }
                    AppMethodBeat.o(125745);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        eam eam2 = new eam();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = eam2.populateBuilderWithField(aVar7, eam2, a.getNextFieldNumber(aVar7))) {
                        }
                        cnc.Mtg = eam2;
                    }
                    AppMethodBeat.o(125745);
                    return 0;
                case 19:
                    cnc.eam = aVar3.UbS.readString();
                    AppMethodBeat.o(125745);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        eas eas = new eas();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = eas.populateBuilderWithField(aVar8, eas, a.getNextFieldNumber(aVar8))) {
                        }
                        cnc.Mth.add(eas);
                    }
                    AppMethodBeat.o(125745);
                    return 0;
                case 21:
                    cnc.sessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(125745);
                    return 0;
                case 22:
                    cnc.Mti = aVar3.UbS.readString();
                    AppMethodBeat.o(125745);
                    return 0;
                case 23:
                    cnc.Bri = aVar3.UbS.readString();
                    AppMethodBeat.o(125745);
                    return 0;
                case 24:
                    cnc.egZ = aVar3.UbS.zi();
                    AppMethodBeat.o(125745);
                    return 0;
                case 25:
                    cnc.Mtj = aVar3.UbS.zl();
                    AppMethodBeat.o(125745);
                    return 0;
                case 26:
                    cnc.Mtk = aVar3.UbS.readString();
                    AppMethodBeat.o(125745);
                    return 0;
                case 27:
                    cnc.Mtl = aVar3.UbS.yZ();
                    AppMethodBeat.o(125745);
                    return 0;
                case 28:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dzk dzk = new dzk();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dzk.populateBuilderWithField(aVar9, dzk, a.getNextFieldNumber(aVar9))) {
                        }
                        cnc.Mtm = dzk;
                    }
                    AppMethodBeat.o(125745);
                    return 0;
                case 29:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        cwz cwz = new cwz();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = cwz.populateBuilderWithField(aVar10, cwz, a.getNextFieldNumber(aVar10))) {
                        }
                        cnc.Mtn = cwz;
                    }
                    AppMethodBeat.o(125745);
                    return 0;
                default:
                    AppMethodBeat.o(125745);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125745);
            return -1;
        }
    }
}
