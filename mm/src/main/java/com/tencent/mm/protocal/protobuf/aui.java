package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aui extends dop {
    public apc LAv;
    public aov LBM;
    public avk LDR;
    public b LDs;
    public int LFc;
    public bdd LFd;
    public LinkedList<cmm> LFe = new LinkedList<>();
    public LinkedList<bdv> LFf = new LinkedList<>();
    public axj LFg;
    public auk LFh;
    public float dTj;
    public int eaQ;
    public float latitude;

    public aui() {
        AppMethodBeat.i(209473);
        AppMethodBeat.o(209473);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209474);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LBM != null) {
                aVar.ni(2, this.LBM.computeSize());
                this.LBM.writeFields(aVar);
            }
            if (this.LDs != null) {
                aVar.c(3, this.LDs);
            }
            aVar.E(4, this.dTj);
            aVar.E(5, this.latitude);
            if (this.LAv != null) {
                aVar.ni(6, this.LAv.computeSize());
                this.LAv.writeFields(aVar);
            }
            if (this.LDR != null) {
                aVar.ni(7, this.LDR.computeSize());
                this.LDR.writeFields(aVar);
            }
            aVar.aM(8, this.LFc);
            if (this.LFd != null) {
                aVar.ni(9, this.LFd.computeSize());
                this.LFd.writeFields(aVar);
            }
            aVar.e(10, 8, this.LFe);
            aVar.e(11, 8, this.LFf);
            if (this.LFg != null) {
                aVar.ni(12, this.LFg.computeSize());
                this.LFg.writeFields(aVar);
            }
            aVar.aM(13, this.eaQ);
            if (this.LFh != null) {
                aVar.ni(14, this.LFh.computeSize());
                this.LFh.writeFields(aVar);
            }
            AppMethodBeat.o(209474);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LBM != null) {
                nh += g.a.a.a.nh(2, this.LBM.computeSize());
            }
            if (this.LDs != null) {
                nh += g.a.a.b.b.a.b(3, this.LDs);
            }
            int fS = nh + g.a.a.b.b.a.fS(4) + 4 + g.a.a.b.b.a.fS(5) + 4;
            if (this.LAv != null) {
                fS += g.a.a.a.nh(6, this.LAv.computeSize());
            }
            if (this.LDR != null) {
                fS += g.a.a.a.nh(7, this.LDR.computeSize());
            }
            int bu = fS + g.a.a.b.b.a.bu(8, this.LFc);
            if (this.LFd != null) {
                bu += g.a.a.a.nh(9, this.LFd.computeSize());
            }
            int c2 = bu + g.a.a.a.c(10, 8, this.LFe) + g.a.a.a.c(11, 8, this.LFf);
            if (this.LFg != null) {
                c2 += g.a.a.a.nh(12, this.LFg.computeSize());
            }
            int bu2 = c2 + g.a.a.b.b.a.bu(13, this.eaQ);
            if (this.LFh != null) {
                bu2 += g.a.a.a.nh(14, this.LFh.computeSize());
            }
            AppMethodBeat.o(209474);
            return bu2;
        } else if (i2 == 2) {
            this.LFe.clear();
            this.LFf.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209474);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aui aui = (aui) objArr[1];
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
                        aui.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209474);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        aui.LBM = aov;
                    }
                    AppMethodBeat.o(209474);
                    return 0;
                case 3:
                    aui.LDs = aVar3.UbS.hPo();
                    AppMethodBeat.o(209474);
                    return 0;
                case 4:
                    aui.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209474);
                    return 0;
                case 5:
                    aui.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(209474);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        apc apc = new apc();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = apc.populateBuilderWithField(aVar6, apc, dop.getNextFieldNumber(aVar6))) {
                        }
                        aui.LAv = apc;
                    }
                    AppMethodBeat.o(209474);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        avk avk = new avk();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = avk.populateBuilderWithField(aVar7, avk, dop.getNextFieldNumber(aVar7))) {
                        }
                        aui.LDR = avk;
                    }
                    AppMethodBeat.o(209474);
                    return 0;
                case 8:
                    aui.LFc = aVar3.UbS.zi();
                    AppMethodBeat.o(209474);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        bdd bdd = new bdd();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = bdd.populateBuilderWithField(aVar8, bdd, dop.getNextFieldNumber(aVar8))) {
                        }
                        aui.LFd = bdd;
                    }
                    AppMethodBeat.o(209474);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        cmm cmm = new cmm();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = cmm.populateBuilderWithField(aVar9, cmm, dop.getNextFieldNumber(aVar9))) {
                        }
                        aui.LFe.add(cmm);
                    }
                    AppMethodBeat.o(209474);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        bdv bdv = new bdv();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = bdv.populateBuilderWithField(aVar10, bdv, dop.getNextFieldNumber(aVar10))) {
                        }
                        aui.LFf.add(bdv);
                    }
                    AppMethodBeat.o(209474);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        axj axj = new axj();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = axj.populateBuilderWithField(aVar11, axj, dop.getNextFieldNumber(aVar11))) {
                        }
                        aui.LFg = axj;
                    }
                    AppMethodBeat.o(209474);
                    return 0;
                case 13:
                    aui.eaQ = aVar3.UbS.zi();
                    AppMethodBeat.o(209474);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        auk auk = new auk();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = auk.populateBuilderWithField(aVar12, auk, dop.getNextFieldNumber(aVar12))) {
                        }
                        aui.LFh = auk;
                    }
                    AppMethodBeat.o(209474);
                    return 0;
                default:
                    AppMethodBeat.o(209474);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209474);
            return -1;
        }
    }
}
