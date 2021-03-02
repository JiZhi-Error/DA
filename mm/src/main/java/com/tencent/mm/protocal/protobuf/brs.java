package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class brs extends a {
    public aq LYX;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32256);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.scene);
            if (this.LYX != null) {
                aVar.ni(2, this.LYX.computeSize());
                this.LYX.writeFields(aVar);
            }
            AppMethodBeat.o(32256);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.scene) + 0;
            if (this.LYX != null) {
                bu += g.a.a.a.nh(2, this.LYX.computeSize());
            }
            AppMethodBeat.o(32256);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32256);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            brs brs = (brs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    brs.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(32256);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aq aqVar = new aq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aqVar.populateBuilderWithField(aVar4, aqVar, a.getNextFieldNumber(aVar4))) {
                        }
                        brs.LYX = aqVar;
                    }
                    AppMethodBeat.o(32256);
                    return 0;
                default:
                    AppMethodBeat.o(32256);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32256);
            return -1;
        }
    }
}
