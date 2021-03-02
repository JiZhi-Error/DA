package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bcl extends a {
    public bcg LLB;
    public String LLC;
    public aoi LLD;
    public String dST;
    public String desc;
    public String iconUrl;
    public int tvC;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(164048);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dST != null) {
                aVar.e(1, this.dST);
            }
            aVar.aM(2, this.tvC);
            if (this.iconUrl != null) {
                aVar.e(3, this.iconUrl);
            }
            if (this.desc != null) {
                aVar.e(4, this.desc);
            }
            if (this.LLB != null) {
                aVar.ni(5, this.LLB.computeSize());
                this.LLB.writeFields(aVar);
            }
            if (this.LLC != null) {
                aVar.e(6, this.LLC);
            }
            if (this.LLD != null) {
                aVar.ni(7, this.LLD.computeSize());
                this.LLD.writeFields(aVar);
            }
            AppMethodBeat.o(164048);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dST != null ? g.a.a.b.b.a.f(1, this.dST) + 0 : 0) + g.a.a.b.b.a.bu(2, this.tvC);
            if (this.iconUrl != null) {
                f2 += g.a.a.b.b.a.f(3, this.iconUrl);
            }
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(4, this.desc);
            }
            if (this.LLB != null) {
                f2 += g.a.a.a.nh(5, this.LLB.computeSize());
            }
            if (this.LLC != null) {
                f2 += g.a.a.b.b.a.f(6, this.LLC);
            }
            if (this.LLD != null) {
                f2 += g.a.a.a.nh(7, this.LLD.computeSize());
            }
            AppMethodBeat.o(164048);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(164048);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bcl bcl = (bcl) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bcl.dST = aVar3.UbS.readString();
                    AppMethodBeat.o(164048);
                    return 0;
                case 2:
                    bcl.tvC = aVar3.UbS.zi();
                    AppMethodBeat.o(164048);
                    return 0;
                case 3:
                    bcl.iconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(164048);
                    return 0;
                case 4:
                    bcl.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(164048);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bcg bcg = new bcg();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bcg.populateBuilderWithField(aVar4, bcg, a.getNextFieldNumber(aVar4))) {
                        }
                        bcl.LLB = bcg;
                    }
                    AppMethodBeat.o(164048);
                    return 0;
                case 6:
                    bcl.LLC = aVar3.UbS.readString();
                    AppMethodBeat.o(164048);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aoi aoi = new aoi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aoi.populateBuilderWithField(aVar5, aoi, a.getNextFieldNumber(aVar5))) {
                        }
                        bcl.LLD = aoi;
                    }
                    AppMethodBeat.o(164048);
                    return 0;
                default:
                    AppMethodBeat.o(164048);
                    return -1;
            }
        } else {
            AppMethodBeat.o(164048);
            return -1;
        }
    }
}
