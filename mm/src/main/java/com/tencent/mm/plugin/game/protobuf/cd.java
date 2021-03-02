package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cd extends a {
    public int oUv;
    public String xIy;
    public cu xJb;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256641);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.oUv);
            if (this.xIy != null) {
                aVar.e(2, this.xIy);
            }
            if (this.xJb != null) {
                aVar.ni(3, this.xJb.computeSize());
                this.xJb.writeFields(aVar);
            }
            AppMethodBeat.o(256641);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.oUv) + 0;
            if (this.xIy != null) {
                bu += g.a.a.b.b.a.f(2, this.xIy);
            }
            if (this.xJb != null) {
                bu += g.a.a.a.nh(3, this.xJb.computeSize());
            }
            AppMethodBeat.o(256641);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256641);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cd cdVar = (cd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cdVar.oUv = aVar3.UbS.zi();
                    AppMethodBeat.o(256641);
                    return 0;
                case 2:
                    cdVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(256641);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cu cuVar = new cu();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cuVar.populateBuilderWithField(aVar4, cuVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cdVar.xJb = cuVar;
                    }
                    AppMethodBeat.o(256641);
                    return 0;
                default:
                    AppMethodBeat.o(256641);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256641);
            return -1;
        }
    }
}
