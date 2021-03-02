package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class chd extends dop {
    public acc KOF;
    public String LkK;
    public int Mbn;
    public boolean Mem;
    public boolean Men;
    public fcc Mmn;
    public fea Mmo;
    public fdb Mmp;
    public fez Mmq;
    public fds Mmr;
    public feb Mms;
    public int Mmt;
    public String Mmu;
    public String Mmv;
    public fec Mmw;
    public ctd Mmx;
    public fdx Mmy;
    public String jfi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123624);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            if (this.Mmn != null) {
                aVar.ni(3, this.Mmn.computeSize());
                this.Mmn.writeFields(aVar);
            }
            aVar.aM(4, this.Mbn);
            if (this.Mmo != null) {
                aVar.ni(5, this.Mmo.computeSize());
                this.Mmo.writeFields(aVar);
            }
            if (this.Mmp != null) {
                aVar.ni(6, this.Mmp.computeSize());
                this.Mmp.writeFields(aVar);
            }
            if (this.Mmq != null) {
                aVar.ni(7, this.Mmq.computeSize());
                this.Mmq.writeFields(aVar);
            }
            if (this.Mmr != null) {
                aVar.ni(8, this.Mmr.computeSize());
                this.Mmr.writeFields(aVar);
            }
            if (this.Mms != null) {
                aVar.ni(9, this.Mms.computeSize());
                this.Mms.writeFields(aVar);
            }
            aVar.aM(10, this.Mmt);
            if (this.Mmu != null) {
                aVar.e(11, this.Mmu);
            }
            if (this.Mmv != null) {
                aVar.e(12, this.Mmv);
            }
            aVar.cc(13, this.Mem);
            aVar.cc(14, this.Men);
            if (this.Mmw != null) {
                aVar.ni(15, this.Mmw.computeSize());
                this.Mmw.writeFields(aVar);
            }
            if (this.Mmx != null) {
                aVar.ni(16, this.Mmx.computeSize());
                this.Mmx.writeFields(aVar);
            }
            if (this.LkK != null) {
                aVar.e(17, this.LkK);
            }
            if (this.KOF != null) {
                aVar.ni(18, this.KOF.computeSize());
                this.KOF.writeFields(aVar);
            }
            if (this.Mmy != null) {
                aVar.ni(19, this.Mmy.computeSize());
                this.Mmy.writeFields(aVar);
            }
            AppMethodBeat.o(123624);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(2, this.jfi);
            }
            if (this.Mmn != null) {
                nh += g.a.a.a.nh(3, this.Mmn.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.Mbn);
            if (this.Mmo != null) {
                bu += g.a.a.a.nh(5, this.Mmo.computeSize());
            }
            if (this.Mmp != null) {
                bu += g.a.a.a.nh(6, this.Mmp.computeSize());
            }
            if (this.Mmq != null) {
                bu += g.a.a.a.nh(7, this.Mmq.computeSize());
            }
            if (this.Mmr != null) {
                bu += g.a.a.a.nh(8, this.Mmr.computeSize());
            }
            if (this.Mms != null) {
                bu += g.a.a.a.nh(9, this.Mms.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.Mmt);
            if (this.Mmu != null) {
                bu2 += g.a.a.b.b.a.f(11, this.Mmu);
            }
            if (this.Mmv != null) {
                bu2 += g.a.a.b.b.a.f(12, this.Mmv);
            }
            int fS = bu2 + g.a.a.b.b.a.fS(13) + 1 + g.a.a.b.b.a.fS(14) + 1;
            if (this.Mmw != null) {
                fS += g.a.a.a.nh(15, this.Mmw.computeSize());
            }
            if (this.Mmx != null) {
                fS += g.a.a.a.nh(16, this.Mmx.computeSize());
            }
            if (this.LkK != null) {
                fS += g.a.a.b.b.a.f(17, this.LkK);
            }
            if (this.KOF != null) {
                fS += g.a.a.a.nh(18, this.KOF.computeSize());
            }
            if (this.Mmy != null) {
                fS += g.a.a.a.nh(19, this.Mmy.computeSize());
            }
            AppMethodBeat.o(123624);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123624);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            chd chd = (chd) objArr[1];
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
                        chd.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(123624);
                    return 0;
                case 2:
                    chd.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(123624);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fcc fcc = new fcc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fcc.populateBuilderWithField(aVar5, fcc, dop.getNextFieldNumber(aVar5))) {
                        }
                        chd.Mmn = fcc;
                    }
                    AppMethodBeat.o(123624);
                    return 0;
                case 4:
                    chd.Mbn = aVar3.UbS.zi();
                    AppMethodBeat.o(123624);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fea fea = new fea();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = fea.populateBuilderWithField(aVar6, fea, dop.getNextFieldNumber(aVar6))) {
                        }
                        chd.Mmo = fea;
                    }
                    AppMethodBeat.o(123624);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        fdb fdb = new fdb();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = fdb.populateBuilderWithField(aVar7, fdb, dop.getNextFieldNumber(aVar7))) {
                        }
                        chd.Mmp = fdb;
                    }
                    AppMethodBeat.o(123624);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        fez fez = new fez();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = fez.populateBuilderWithField(aVar8, fez, dop.getNextFieldNumber(aVar8))) {
                        }
                        chd.Mmq = fez;
                    }
                    AppMethodBeat.o(123624);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        fds fds = new fds();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = fds.populateBuilderWithField(aVar9, fds, dop.getNextFieldNumber(aVar9))) {
                        }
                        chd.Mmr = fds;
                    }
                    AppMethodBeat.o(123624);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        feb feb = new feb();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = feb.populateBuilderWithField(aVar10, feb, dop.getNextFieldNumber(aVar10))) {
                        }
                        chd.Mms = feb;
                    }
                    AppMethodBeat.o(123624);
                    return 0;
                case 10:
                    chd.Mmt = aVar3.UbS.zi();
                    AppMethodBeat.o(123624);
                    return 0;
                case 11:
                    chd.Mmu = aVar3.UbS.readString();
                    AppMethodBeat.o(123624);
                    return 0;
                case 12:
                    chd.Mmv = aVar3.UbS.readString();
                    AppMethodBeat.o(123624);
                    return 0;
                case 13:
                    chd.Mem = aVar3.UbS.yZ();
                    AppMethodBeat.o(123624);
                    return 0;
                case 14:
                    chd.Men = aVar3.UbS.yZ();
                    AppMethodBeat.o(123624);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        fec fec = new fec();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = fec.populateBuilderWithField(aVar11, fec, dop.getNextFieldNumber(aVar11))) {
                        }
                        chd.Mmw = fec;
                    }
                    AppMethodBeat.o(123624);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        ctd ctd = new ctd();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = ctd.populateBuilderWithField(aVar12, ctd, dop.getNextFieldNumber(aVar12))) {
                        }
                        chd.Mmx = ctd;
                    }
                    AppMethodBeat.o(123624);
                    return 0;
                case 17:
                    chd.LkK = aVar3.UbS.readString();
                    AppMethodBeat.o(123624);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        acc acc = new acc();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = acc.populateBuilderWithField(aVar13, acc, dop.getNextFieldNumber(aVar13))) {
                        }
                        chd.KOF = acc;
                    }
                    AppMethodBeat.o(123624);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        fdx fdx = new fdx();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = fdx.populateBuilderWithField(aVar14, fdx, dop.getNextFieldNumber(aVar14))) {
                        }
                        chd.Mmy = fdx;
                    }
                    AppMethodBeat.o(123624);
                    return 0;
                default:
                    AppMethodBeat.o(123624);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123624);
            return -1;
        }
    }
}
