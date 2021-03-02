package com.tencent.mm.plugin.game.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class m extends a {
    public String xvf;
    public long xvg;
    public d xvh;
    public n xvi;
    public LinkedList<l> xvj = new LinkedList<>();
    public c xvk;

    public m() {
        AppMethodBeat.i(40880);
        AppMethodBeat.o(40880);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(40881);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xvf != null) {
                aVar.e(1, this.xvf);
            }
            aVar.bb(2, this.xvg);
            if (this.xvh != null) {
                aVar.ni(3, this.xvh.computeSize());
                this.xvh.writeFields(aVar);
            }
            if (this.xvi != null) {
                aVar.ni(4, this.xvi.computeSize());
                this.xvi.writeFields(aVar);
            }
            aVar.e(5, 8, this.xvj);
            if (this.xvk != null) {
                aVar.ni(6, this.xvk.computeSize());
                this.xvk.writeFields(aVar);
            }
            AppMethodBeat.o(40881);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.xvf != null ? g.a.a.b.b.a.f(1, this.xvf) + 0 : 0) + g.a.a.b.b.a.r(2, this.xvg);
            if (this.xvh != null) {
                f2 += g.a.a.a.nh(3, this.xvh.computeSize());
            }
            if (this.xvi != null) {
                f2 += g.a.a.a.nh(4, this.xvi.computeSize());
            }
            int c2 = f2 + g.a.a.a.c(5, 8, this.xvj);
            if (this.xvk != null) {
                c2 += g.a.a.a.nh(6, this.xvk.computeSize());
            }
            AppMethodBeat.o(40881);
            return c2;
        } else if (i2 == 2) {
            this.xvj.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(40881);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    mVar.xvf = aVar3.UbS.readString();
                    AppMethodBeat.o(40881);
                    return 0;
                case 2:
                    mVar.xvg = aVar3.UbS.zl();
                    AppMethodBeat.o(40881);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d dVar = new d();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mVar.xvh = dVar;
                    }
                    AppMethodBeat.o(40881);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        n nVar = new n();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = nVar.populateBuilderWithField(aVar5, nVar, a.getNextFieldNumber(aVar5))) {
                        }
                        mVar.xvi = nVar;
                    }
                    AppMethodBeat.o(40881);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        l lVar = new l();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = lVar.populateBuilderWithField(aVar6, lVar, a.getNextFieldNumber(aVar6))) {
                        }
                        mVar.xvj.add(lVar);
                    }
                    AppMethodBeat.o(40881);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        c cVar = new c();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = cVar.populateBuilderWithField(aVar7, cVar, a.getNextFieldNumber(aVar7))) {
                        }
                        mVar.xvk = cVar;
                    }
                    AppMethodBeat.o(40881);
                    return 0;
                default:
                    AppMethodBeat.o(40881);
                    return -1;
            }
        } else {
            AppMethodBeat.o(40881);
            return -1;
        }
    }
}
