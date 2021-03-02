package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class d extends a {
    public String appId;
    public String jgH;
    public String jgI;
    public o jgJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(223634);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.appId != null) {
                aVar.e(1, this.appId);
            }
            if (this.jgH != null) {
                aVar.e(2, this.jgH);
            }
            if (this.jgI != null) {
                aVar.e(3, this.jgI);
            }
            if (this.jgJ != null) {
                aVar.ni(4, this.jgJ.computeSize());
                this.jgJ.writeFields(aVar);
            }
            AppMethodBeat.o(223634);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.appId != null ? g.a.a.b.b.a.f(1, this.appId) + 0 : 0;
            if (this.jgH != null) {
                f2 += g.a.a.b.b.a.f(2, this.jgH);
            }
            if (this.jgI != null) {
                f2 += g.a.a.b.b.a.f(3, this.jgI);
            }
            if (this.jgJ != null) {
                f2 += g.a.a.a.nh(4, this.jgJ.computeSize());
            }
            AppMethodBeat.o(223634);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(223634);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            d dVar = (d) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dVar.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(223634);
                    return 0;
                case 2:
                    dVar.jgH = aVar3.UbS.readString();
                    AppMethodBeat.o(223634);
                    return 0;
                case 3:
                    dVar.jgI = aVar3.UbS.readString();
                    AppMethodBeat.o(223634);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        o oVar = new o();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = oVar.populateBuilderWithField(aVar4, oVar, a.getNextFieldNumber(aVar4))) {
                        }
                        dVar.jgJ = oVar;
                    }
                    AppMethodBeat.o(223634);
                    return 0;
                default:
                    AppMethodBeat.o(223634);
                    return -1;
            }
        } else {
            AppMethodBeat.o(223634);
            return -1;
        }
    }
}
