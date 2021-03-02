package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class e extends a {
    public int oUv;
    public c xIF;
    public String xIG;
    public g xIz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41709);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oUv);
            if (this.xIz != null) {
                aVar.ni(2, this.xIz.computeSize());
                this.xIz.writeFields(aVar);
            }
            if (this.xIF != null) {
                aVar.ni(3, this.xIF.computeSize());
                this.xIF.writeFields(aVar);
            }
            if (this.xIG != null) {
                aVar.e(4, this.xIG);
            }
            AppMethodBeat.o(41709);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oUv) + 0;
            if (this.xIz != null) {
                bu += g.a.a.a.nh(2, this.xIz.computeSize());
            }
            if (this.xIF != null) {
                bu += g.a.a.a.nh(3, this.xIF.computeSize());
            }
            if (this.xIG != null) {
                bu += g.a.a.b.b.a.f(4, this.xIG);
            }
            AppMethodBeat.o(41709);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41709);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(41709);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        g gVar = new g();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.xIz = gVar;
                    }
                    AppMethodBeat.o(41709);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        c cVar = new c();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cVar.populateBuilderWithField(aVar5, cVar, a.getNextFieldNumber(aVar5))) {
                        }
                        eVar.xIF = cVar;
                    }
                    AppMethodBeat.o(41709);
                    return 0;
                case 4:
                    eVar.xIG = aVar3.UbS.readString();
                    AppMethodBeat.o(41709);
                    return 0;
                default:
                    AppMethodBeat.o(41709);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41709);
            return -1;
        }
    }
}
