package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ab extends a {
    public eo xJW;
    public boolean xJX;
    public boolean xJY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256632);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xJW != null) {
                aVar.ni(1, this.xJW.computeSize());
                this.xJW.writeFields(aVar);
            }
            aVar.cc(2, this.xJX);
            aVar.cc(4, this.xJY);
            AppMethodBeat.o(256632);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.xJW != null ? g.a.a.a.nh(1, this.xJW.computeSize()) + 0 : 0) + g.a.a.b.b.a.fS(2) + 1 + g.a.a.b.b.a.fS(4) + 1;
            AppMethodBeat.o(256632);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256632);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ab abVar = (ab) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eo eoVar = new eo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eoVar.populateBuilderWithField(aVar4, eoVar, a.getNextFieldNumber(aVar4))) {
                        }
                        abVar.xJW = eoVar;
                    }
                    AppMethodBeat.o(256632);
                    return 0;
                case 2:
                    abVar.xJX = aVar3.UbS.yZ();
                    AppMethodBeat.o(256632);
                    return 0;
                case 3:
                default:
                    AppMethodBeat.o(256632);
                    return -1;
                case 4:
                    abVar.xJY = aVar3.UbS.yZ();
                    AppMethodBeat.o(256632);
                    return 0;
            }
        } else {
            AppMethodBeat.o(256632);
            return -1;
        }
    }
}
