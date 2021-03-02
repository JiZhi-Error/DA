package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bds extends a {
    public azk LJj;
    public int LNt;
    public int LNu;
    public int LNv;
    public bdr LNw;
    public int LNx;
    public int LNy;
    public aqk LNz;
    public int LzC;
    public String coverUrl;
    public String dST;
    public int followFlag;
    public int friendFollowCount;
    public bdl tmpl_info;
    public int tvC;
    public long twp;
    public String twq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209704);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dST != null) {
                aVar.e(1, this.dST);
            }
            aVar.bb(2, this.twp);
            aVar.aM(3, this.LzC);
            if (this.twq != null) {
                aVar.e(4, this.twq);
            }
            aVar.aM(5, this.tvC);
            aVar.aM(6, this.followFlag);
            if (this.coverUrl != null) {
                aVar.e(7, this.coverUrl);
            }
            aVar.aM(8, this.friendFollowCount);
            aVar.aM(9, this.LNt);
            aVar.aM(10, this.LNu);
            if (this.LJj != null) {
                aVar.ni(11, this.LJj.computeSize());
                this.LJj.writeFields(aVar);
            }
            aVar.aM(12, this.LNv);
            if (this.LNw != null) {
                aVar.ni(13, this.LNw.computeSize());
                this.LNw.writeFields(aVar);
            }
            aVar.aM(14, this.LNx);
            if (this.tmpl_info != null) {
                aVar.ni(15, this.tmpl_info.computeSize());
                this.tmpl_info.writeFields(aVar);
            }
            aVar.aM(16, this.LNy);
            if (this.LNz != null) {
                aVar.ni(17, this.LNz.computeSize());
                this.LNz.writeFields(aVar);
            }
            AppMethodBeat.o(209704);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dST != null ? g.a.a.b.b.a.f(1, this.dST) + 0 : 0) + g.a.a.b.b.a.r(2, this.twp) + g.a.a.b.b.a.bu(3, this.LzC);
            if (this.twq != null) {
                f2 += g.a.a.b.b.a.f(4, this.twq);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.tvC) + g.a.a.b.b.a.bu(6, this.followFlag);
            if (this.coverUrl != null) {
                bu += g.a.a.b.b.a.f(7, this.coverUrl);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.friendFollowCount) + g.a.a.b.b.a.bu(9, this.LNt) + g.a.a.b.b.a.bu(10, this.LNu);
            if (this.LJj != null) {
                bu2 += g.a.a.a.nh(11, this.LJj.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(12, this.LNv);
            if (this.LNw != null) {
                bu3 += g.a.a.a.nh(13, this.LNw.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(14, this.LNx);
            if (this.tmpl_info != null) {
                bu4 += g.a.a.a.nh(15, this.tmpl_info.computeSize());
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(16, this.LNy);
            if (this.LNz != null) {
                bu5 += g.a.a.a.nh(17, this.LNz.computeSize());
            }
            AppMethodBeat.o(209704);
            return bu5;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209704);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bds bds = (bds) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bds.dST = aVar3.UbS.readString();
                    AppMethodBeat.o(209704);
                    return 0;
                case 2:
                    bds.twp = aVar3.UbS.zl();
                    AppMethodBeat.o(209704);
                    return 0;
                case 3:
                    bds.LzC = aVar3.UbS.zi();
                    AppMethodBeat.o(209704);
                    return 0;
                case 4:
                    bds.twq = aVar3.UbS.readString();
                    AppMethodBeat.o(209704);
                    return 0;
                case 5:
                    bds.tvC = aVar3.UbS.zi();
                    AppMethodBeat.o(209704);
                    return 0;
                case 6:
                    bds.followFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(209704);
                    return 0;
                case 7:
                    bds.coverUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(209704);
                    return 0;
                case 8:
                    bds.friendFollowCount = aVar3.UbS.zi();
                    AppMethodBeat.o(209704);
                    return 0;
                case 9:
                    bds.LNt = aVar3.UbS.zi();
                    AppMethodBeat.o(209704);
                    return 0;
                case 10:
                    bds.LNu = aVar3.UbS.zi();
                    AppMethodBeat.o(209704);
                    return 0;
                case 11:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        azk azk = new azk();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = azk.populateBuilderWithField(aVar4, azk, a.getNextFieldNumber(aVar4))) {
                        }
                        bds.LJj = azk;
                    }
                    AppMethodBeat.o(209704);
                    return 0;
                case 12:
                    bds.LNv = aVar3.UbS.zi();
                    AppMethodBeat.o(209704);
                    return 0;
                case 13:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bdr bdr = new bdr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bdr.populateBuilderWithField(aVar5, bdr, a.getNextFieldNumber(aVar5))) {
                        }
                        bds.LNw = bdr;
                    }
                    AppMethodBeat.o(209704);
                    return 0;
                case 14:
                    bds.LNx = aVar3.UbS.zi();
                    AppMethodBeat.o(209704);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bdl bdl = new bdl();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bdl.populateBuilderWithField(aVar6, bdl, a.getNextFieldNumber(aVar6))) {
                        }
                        bds.tmpl_info = bdl;
                    }
                    AppMethodBeat.o(209704);
                    return 0;
                case 16:
                    bds.LNy = aVar3.UbS.zi();
                    AppMethodBeat.o(209704);
                    return 0;
                case 17:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aqk aqk = new aqk();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aqk.populateBuilderWithField(aVar7, aqk, a.getNextFieldNumber(aVar7))) {
                        }
                        bds.LNz = aqk;
                    }
                    AppMethodBeat.o(209704);
                    return 0;
                default:
                    AppMethodBeat.o(209704);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209704);
            return -1;
        }
    }
}
