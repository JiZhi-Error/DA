package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ax extends a {
    public String Title;
    public String xJt;
    public String xKS;
    public LinkedList<di> xKT = new LinkedList<>();
    public eq xKU;

    public ax() {
        AppMethodBeat.i(41743);
        AppMethodBeat.o(41743);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41744);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xKS != null) {
                aVar.e(1, this.xKS);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            aVar.e(3, 8, this.xKT);
            if (this.xKU != null) {
                aVar.ni(4, this.xKU.computeSize());
                this.xKU.writeFields(aVar);
            }
            if (this.xJt != null) {
                aVar.e(5, this.xJt);
            }
            AppMethodBeat.o(41744);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xKS != null ? g.a.a.b.b.a.f(1, this.xKS) + 0 : 0;
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(2, this.Title);
            }
            int c2 = f2 + g.a.a.a.c(3, 8, this.xKT);
            if (this.xKU != null) {
                c2 += g.a.a.a.nh(4, this.xKU.computeSize());
            }
            if (this.xJt != null) {
                c2 += g.a.a.b.b.a.f(5, this.xJt);
            }
            AppMethodBeat.o(41744);
            return c2;
        } else if (i2 == 2) {
            this.xKT.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41744);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ax axVar = (ax) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    axVar.xKS = aVar3.UbS.readString();
                    AppMethodBeat.o(41744);
                    return 0;
                case 2:
                    axVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41744);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        di diVar = new di();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = diVar.populateBuilderWithField(aVar4, diVar, a.getNextFieldNumber(aVar4))) {
                        }
                        axVar.xKT.add(diVar);
                    }
                    AppMethodBeat.o(41744);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eq eqVar = new eq();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eqVar.populateBuilderWithField(aVar5, eqVar, a.getNextFieldNumber(aVar5))) {
                        }
                        axVar.xKU = eqVar;
                    }
                    AppMethodBeat.o(41744);
                    return 0;
                case 5:
                    axVar.xJt = aVar3.UbS.readString();
                    AppMethodBeat.o(41744);
                    return 0;
                default:
                    AppMethodBeat.o(41744);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41744);
            return -1;
        }
    }
}
