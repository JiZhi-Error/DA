package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public class bcz extends dop {
    public apc LAv;
    public LinkedList<ecq> LEw = new LinkedList<>();
    public String LFm;
    public LinkedList<cmm> LIs = new LinkedList<>();
    public LinkedList<bdv> LMA = new LinkedList<>();
    public int LMB;
    public String LMC;
    public avk LMD;
    public int LMw;
    public long LMx;
    public String LMy;
    public long LMz;
    public int dLS;
    public float dTj;
    public String finderUsername;
    public b lastBuffer;
    public float latitude;
    public int pullType;
    public String sessionId;
    public b tVe;
    public b tabTipsByPassInfo;
    public aov uli;

    public bcz() {
        AppMethodBeat.i(184211);
        AppMethodBeat.o(184211);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169056);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.lastBuffer != null) {
                aVar.c(3, this.lastBuffer);
            }
            if (this.finderUsername != null) {
                aVar.e(4, this.finderUsername);
            }
            aVar.aM(5, this.pullType);
            if (this.uli != null) {
                aVar.ni(6, this.uli.computeSize());
                this.uli.writeFields(aVar);
            }
            aVar.E(7, this.dTj);
            aVar.E(8, this.latitude);
            if (this.sessionId != null) {
                aVar.e(9, this.sessionId);
            }
            if (this.LAv != null) {
                aVar.ni(10, this.LAv.computeSize());
                this.LAv.writeFields(aVar);
            }
            aVar.e(11, 8, this.LIs);
            aVar.aM(12, this.LMw);
            aVar.aM(13, this.dLS);
            aVar.bb(14, this.LMx);
            if (this.LMy != null) {
                aVar.e(15, this.LMy);
            }
            aVar.e(16, 8, this.LEw);
            aVar.bb(17, this.LMz);
            aVar.e(18, 8, this.LMA);
            if (this.tVe != null) {
                aVar.c(19, this.tVe);
            }
            aVar.aM(20, this.LMB);
            if (this.LMC != null) {
                aVar.e(21, this.LMC);
            }
            if (this.tabTipsByPassInfo != null) {
                aVar.c(22, this.tabTipsByPassInfo);
            }
            if (this.LMD != null) {
                aVar.ni(23, this.LMD.computeSize());
                this.LMD.writeFields(aVar);
            }
            if (this.LFm != null) {
                aVar.e(24, this.LFm);
            }
            AppMethodBeat.o(169056);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.lastBuffer != null) {
                nh += g.a.a.b.b.a.b(3, this.lastBuffer);
            }
            if (this.finderUsername != null) {
                nh += g.a.a.b.b.a.f(4, this.finderUsername);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.pullType);
            if (this.uli != null) {
                bu += g.a.a.a.nh(6, this.uli.computeSize());
            }
            int fS = bu + g.a.a.b.b.a.fS(7) + 4 + g.a.a.b.b.a.fS(8) + 4;
            if (this.sessionId != null) {
                fS += g.a.a.b.b.a.f(9, this.sessionId);
            }
            if (this.LAv != null) {
                fS += g.a.a.a.nh(10, this.LAv.computeSize());
            }
            int c2 = fS + g.a.a.a.c(11, 8, this.LIs) + g.a.a.b.b.a.bu(12, this.LMw) + g.a.a.b.b.a.bu(13, this.dLS) + g.a.a.b.b.a.r(14, this.LMx);
            if (this.LMy != null) {
                c2 += g.a.a.b.b.a.f(15, this.LMy);
            }
            int c3 = c2 + g.a.a.a.c(16, 8, this.LEw) + g.a.a.b.b.a.r(17, this.LMz) + g.a.a.a.c(18, 8, this.LMA);
            if (this.tVe != null) {
                c3 += g.a.a.b.b.a.b(19, this.tVe);
            }
            int bu2 = c3 + g.a.a.b.b.a.bu(20, this.LMB);
            if (this.LMC != null) {
                bu2 += g.a.a.b.b.a.f(21, this.LMC);
            }
            if (this.tabTipsByPassInfo != null) {
                bu2 += g.a.a.b.b.a.b(22, this.tabTipsByPassInfo);
            }
            if (this.LMD != null) {
                bu2 += g.a.a.a.nh(23, this.LMD.computeSize());
            }
            if (this.LFm != null) {
                bu2 += g.a.a.b.b.a.f(24, this.LFm);
            }
            AppMethodBeat.o(169056);
            return bu2;
        } else if (i2 == 2) {
            this.LIs.clear();
            this.LEw.clear();
            this.LMA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169056);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bcz bcz = (bcz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        bcz.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(169056);
                    return 0;
                case 2:
                default:
                    AppMethodBeat.o(169056);
                    return -1;
                case 3:
                    bcz.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(169056);
                    return 0;
                case 4:
                    bcz.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(169056);
                    return 0;
                case 5:
                    bcz.pullType = aVar3.UbS.zi();
                    AppMethodBeat.o(169056);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        bcz.uli = aov;
                    }
                    AppMethodBeat.o(169056);
                    return 0;
                case 7:
                    bcz.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169056);
                    return 0;
                case 8:
                    bcz.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169056);
                    return 0;
                case 9:
                    bcz.sessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(169056);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        apc apc = new apc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = apc.populateBuilderWithField(aVar6, apc, dop.getNextFieldNumber(aVar6))) {
                        }
                        bcz.LAv = apc;
                    }
                    AppMethodBeat.o(169056);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        cmm cmm = new cmm();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = cmm.populateBuilderWithField(aVar7, cmm, dop.getNextFieldNumber(aVar7))) {
                        }
                        bcz.LIs.add(cmm);
                    }
                    AppMethodBeat.o(169056);
                    return 0;
                case 12:
                    bcz.LMw = aVar3.UbS.zi();
                    AppMethodBeat.o(169056);
                    return 0;
                case 13:
                    bcz.dLS = aVar3.UbS.zi();
                    AppMethodBeat.o(169056);
                    return 0;
                case 14:
                    bcz.LMx = aVar3.UbS.zl();
                    AppMethodBeat.o(169056);
                    return 0;
                case 15:
                    bcz.LMy = aVar3.UbS.readString();
                    AppMethodBeat.o(169056);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        ecq ecq = new ecq();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = ecq.populateBuilderWithField(aVar8, ecq, dop.getNextFieldNumber(aVar8))) {
                        }
                        bcz.LEw.add(ecq);
                    }
                    AppMethodBeat.o(169056);
                    return 0;
                case 17:
                    bcz.LMz = aVar3.UbS.zl();
                    AppMethodBeat.o(169056);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        bdv bdv = new bdv();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = bdv.populateBuilderWithField(aVar9, bdv, dop.getNextFieldNumber(aVar9))) {
                        }
                        bcz.LMA.add(bdv);
                    }
                    AppMethodBeat.o(169056);
                    return 0;
                case 19:
                    bcz.tVe = aVar3.UbS.hPo();
                    AppMethodBeat.o(169056);
                    return 0;
                case 20:
                    bcz.LMB = aVar3.UbS.zi();
                    AppMethodBeat.o(169056);
                    return 0;
                case 21:
                    bcz.LMC = aVar3.UbS.readString();
                    AppMethodBeat.o(169056);
                    return 0;
                case 22:
                    bcz.tabTipsByPassInfo = aVar3.UbS.hPo();
                    AppMethodBeat.o(169056);
                    return 0;
                case 23:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        avk avk = new avk();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = avk.populateBuilderWithField(aVar10, avk, dop.getNextFieldNumber(aVar10))) {
                        }
                        bcz.LMD = avk;
                    }
                    AppMethodBeat.o(169056);
                    return 0;
                case 24:
                    bcz.LFm = aVar3.UbS.readString();
                    AppMethodBeat.o(169056);
                    return 0;
            }
        } else {
            AppMethodBeat.o(169056);
            return -1;
        }
    }
}
