package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class auu extends a {
    public int LFG;
    public cjb LFH;
    public avn LFI;
    public long LFJ;
    public String Lmn;
    public long seq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209487);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lmn != null) {
                aVar.e(1, this.Lmn);
            }
            aVar.aM(51, this.LFG);
            if (this.LFH != null) {
                aVar.ni(101, this.LFH.computeSize());
                this.LFH.writeFields(aVar);
            }
            if (this.LFI != null) {
                aVar.ni(102, this.LFI.computeSize());
                this.LFI.writeFields(aVar);
            }
            aVar.bb(103, this.LFJ);
            aVar.bb(104, this.seq);
            AppMethodBeat.o(209487);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Lmn != null ? g.a.a.b.b.a.f(1, this.Lmn) + 0 : 0) + g.a.a.b.b.a.bu(51, this.LFG);
            if (this.LFH != null) {
                f2 += g.a.a.a.nh(101, this.LFH.computeSize());
            }
            if (this.LFI != null) {
                f2 += g.a.a.a.nh(102, this.LFI.computeSize());
            }
            int r = f2 + g.a.a.b.b.a.r(103, this.LFJ) + g.a.a.b.b.a.r(104, this.seq);
            AppMethodBeat.o(209487);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209487);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            auu auu = (auu) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    auu.Lmn = aVar3.UbS.readString();
                    AppMethodBeat.o(209487);
                    return 0;
                case 51:
                    auu.LFG = aVar3.UbS.zi();
                    AppMethodBeat.o(209487);
                    return 0;
                case 101:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cjb cjb = new cjb();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cjb.populateBuilderWithField(aVar4, cjb, a.getNextFieldNumber(aVar4))) {
                        }
                        auu.LFH = cjb;
                    }
                    AppMethodBeat.o(209487);
                    return 0;
                case 102:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        avn avn = new avn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = avn.populateBuilderWithField(aVar5, avn, a.getNextFieldNumber(aVar5))) {
                        }
                        auu.LFI = avn;
                    }
                    AppMethodBeat.o(209487);
                    return 0;
                case 103:
                    auu.LFJ = aVar3.UbS.zl();
                    AppMethodBeat.o(209487);
                    return 0;
                case 104:
                    auu.seq = aVar3.UbS.zl();
                    AppMethodBeat.o(209487);
                    return 0;
                default:
                    AppMethodBeat.o(209487);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209487);
            return -1;
        }
    }
}
