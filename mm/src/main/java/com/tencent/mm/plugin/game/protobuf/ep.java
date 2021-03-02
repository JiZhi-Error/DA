package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ep extends a {
    public String xJt;
    public eq xNP;
    public am xNQ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41846);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xNP != null) {
                aVar.ni(1, this.xNP.computeSize());
                this.xNP.writeFields(aVar);
            }
            if (this.xNQ != null) {
                aVar.ni(2, this.xNQ.computeSize());
                this.xNQ.writeFields(aVar);
            }
            if (this.xJt != null) {
                aVar.e(3, this.xJt);
            }
            AppMethodBeat.o(41846);
            return 0;
        } else if (i2 == 1) {
            int nh = this.xNP != null ? g.a.a.a.nh(1, this.xNP.computeSize()) + 0 : 0;
            if (this.xNQ != null) {
                nh += g.a.a.a.nh(2, this.xNQ.computeSize());
            }
            if (this.xJt != null) {
                nh += g.a.a.b.b.a.f(3, this.xJt);
            }
            AppMethodBeat.o(41846);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41846);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ep epVar = (ep) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eq eqVar = new eq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eqVar.populateBuilderWithField(aVar4, eqVar, a.getNextFieldNumber(aVar4))) {
                        }
                        epVar.xNP = eqVar;
                    }
                    AppMethodBeat.o(41846);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        am amVar = new am();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = amVar.populateBuilderWithField(aVar5, amVar, a.getNextFieldNumber(aVar5))) {
                        }
                        epVar.xNQ = amVar;
                    }
                    AppMethodBeat.o(41846);
                    return 0;
                case 3:
                    epVar.xJt = aVar3.UbS.readString();
                    AppMethodBeat.o(41846);
                    return 0;
                default:
                    AppMethodBeat.o(41846);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41846);
            return -1;
        }
    }
}
