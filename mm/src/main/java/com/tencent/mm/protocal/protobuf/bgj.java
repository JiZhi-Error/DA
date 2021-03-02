package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bgj extends a {
    public LinkedList<bgd> LQd = new LinkedList<>();
    public LinkedList<bgl> LQe = new LinkedList<>();
    public String LQf;
    public String LQg;
    public LinkedList<bgk> LQh = new LinkedList<>();
    public int LQi;
    public boolean LQj;
    public String Title;
    public int type;

    public bgj() {
        AppMethodBeat.i(42642);
        AppMethodBeat.o(42642);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(42643);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            aVar.aM(2, this.type);
            aVar.e(3, 8, this.LQd);
            aVar.e(4, 8, this.LQe);
            if (this.LQf != null) {
                aVar.e(5, this.LQf);
            }
            if (this.LQg != null) {
                aVar.e(6, this.LQg);
            }
            aVar.e(7, 8, this.LQh);
            aVar.aM(8, this.LQi);
            aVar.cc(9, this.LQj);
            AppMethodBeat.o(42643);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0) + g.a.a.b.b.a.bu(2, this.type) + g.a.a.a.c(3, 8, this.LQd) + g.a.a.a.c(4, 8, this.LQe);
            if (this.LQf != null) {
                f2 += g.a.a.b.b.a.f(5, this.LQf);
            }
            if (this.LQg != null) {
                f2 += g.a.a.b.b.a.f(6, this.LQg);
            }
            int c2 = f2 + g.a.a.a.c(7, 8, this.LQh) + g.a.a.b.b.a.bu(8, this.LQi) + g.a.a.b.b.a.fS(9) + 1;
            AppMethodBeat.o(42643);
            return c2;
        } else if (i2 == 2) {
            this.LQd.clear();
            this.LQe.clear();
            this.LQh.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(42643);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bgj bgj = (bgj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bgj.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(42643);
                    return 0;
                case 2:
                    bgj.type = aVar3.UbS.zi();
                    AppMethodBeat.o(42643);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bgd bgd = new bgd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bgd.populateBuilderWithField(aVar4, bgd, a.getNextFieldNumber(aVar4))) {
                        }
                        bgj.LQd.add(bgd);
                    }
                    AppMethodBeat.o(42643);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bgl bgl = new bgl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bgl.populateBuilderWithField(aVar5, bgl, a.getNextFieldNumber(aVar5))) {
                        }
                        bgj.LQe.add(bgl);
                    }
                    AppMethodBeat.o(42643);
                    return 0;
                case 5:
                    bgj.LQf = aVar3.UbS.readString();
                    AppMethodBeat.o(42643);
                    return 0;
                case 6:
                    bgj.LQg = aVar3.UbS.readString();
                    AppMethodBeat.o(42643);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bgk bgk = new bgk();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bgk.populateBuilderWithField(aVar6, bgk, a.getNextFieldNumber(aVar6))) {
                        }
                        bgj.LQh.add(bgk);
                    }
                    AppMethodBeat.o(42643);
                    return 0;
                case 8:
                    bgj.LQi = aVar3.UbS.zi();
                    AppMethodBeat.o(42643);
                    return 0;
                case 9:
                    bgj.LQj = aVar3.UbS.yZ();
                    AppMethodBeat.o(42643);
                    return 0;
                default:
                    AppMethodBeat.o(42643);
                    return -1;
            }
        } else {
            AppMethodBeat.o(42643);
            return -1;
        }
    }
}
