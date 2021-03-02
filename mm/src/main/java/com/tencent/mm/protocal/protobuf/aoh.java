package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aoh extends a {
    public FinderCommentInfo LAk;
    public cjq LAl;
    public cjr LAm;
    public FinderCommentInfo LAn;
    public int LAo;
    public int actionType;
    public int tCE;
    public bbn ttO;
    public long tuf;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168935);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.actionType);
            if (this.LAk != null) {
                aVar.ni(2, this.LAk.computeSize());
                this.LAk.writeFields(aVar);
            }
            if (this.LAl != null) {
                aVar.ni(3, this.LAl.computeSize());
                this.LAl.writeFields(aVar);
            }
            if (this.LAm != null) {
                aVar.ni(4, this.LAm.computeSize());
                this.LAm.writeFields(aVar);
            }
            aVar.bb(5, this.tuf);
            if (this.LAn != null) {
                aVar.ni(6, this.LAn.computeSize());
                this.LAn.writeFields(aVar);
            }
            aVar.aM(7, this.tCE);
            if (this.ttO != null) {
                aVar.ni(8, this.ttO.computeSize());
                this.ttO.writeFields(aVar);
            }
            aVar.aM(9, this.LAo);
            AppMethodBeat.o(168935);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.actionType) + 0;
            if (this.LAk != null) {
                bu += g.a.a.a.nh(2, this.LAk.computeSize());
            }
            if (this.LAl != null) {
                bu += g.a.a.a.nh(3, this.LAl.computeSize());
            }
            if (this.LAm != null) {
                bu += g.a.a.a.nh(4, this.LAm.computeSize());
            }
            int r = bu + g.a.a.b.b.a.r(5, this.tuf);
            if (this.LAn != null) {
                r += g.a.a.a.nh(6, this.LAn.computeSize());
            }
            int bu2 = r + g.a.a.b.b.a.bu(7, this.tCE);
            if (this.ttO != null) {
                bu2 += g.a.a.a.nh(8, this.ttO.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(9, this.LAo);
            AppMethodBeat.o(168935);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168935);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aoh aoh = (aoh) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aoh.actionType = aVar3.UbS.zi();
                    AppMethodBeat.o(168935);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderCommentInfo finderCommentInfo = new FinderCommentInfo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderCommentInfo.populateBuilderWithField(aVar4, finderCommentInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        aoh.LAk = finderCommentInfo;
                    }
                    AppMethodBeat.o(168935);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cjq cjq = new cjq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cjq.populateBuilderWithField(aVar5, cjq, a.getNextFieldNumber(aVar5))) {
                        }
                        aoh.LAl = cjq;
                    }
                    AppMethodBeat.o(168935);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cjr cjr = new cjr();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cjr.populateBuilderWithField(aVar6, cjr, a.getNextFieldNumber(aVar6))) {
                        }
                        aoh.LAm = cjr;
                    }
                    AppMethodBeat.o(168935);
                    return 0;
                case 5:
                    aoh.tuf = aVar3.UbS.zl();
                    AppMethodBeat.o(168935);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        FinderCommentInfo finderCommentInfo2 = new FinderCommentInfo();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = finderCommentInfo2.populateBuilderWithField(aVar7, finderCommentInfo2, a.getNextFieldNumber(aVar7))) {
                        }
                        aoh.LAn = finderCommentInfo2;
                    }
                    AppMethodBeat.o(168935);
                    return 0;
                case 7:
                    aoh.tCE = aVar3.UbS.zi();
                    AppMethodBeat.o(168935);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        bbn bbn = new bbn();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = bbn.populateBuilderWithField(aVar8, bbn, a.getNextFieldNumber(aVar8))) {
                        }
                        aoh.ttO = bbn;
                    }
                    AppMethodBeat.o(168935);
                    return 0;
                case 9:
                    aoh.LAo = aVar3.UbS.zi();
                    AppMethodBeat.o(168935);
                    return 0;
                default:
                    AppMethodBeat.o(168935);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168935);
            return -1;
        }
    }
}
