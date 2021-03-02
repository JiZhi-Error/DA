package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class auv extends a {
    public awr LFK;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209488);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LFK != null) {
                aVar.ni(1, this.LFK.computeSize());
                this.LFK.writeFields(aVar);
            }
            AppMethodBeat.o(209488);
            return 0;
        } else if (i2 == 1) {
            int nh = this.LFK != null ? g.a.a.a.nh(1, this.LFK.computeSize()) + 0 : 0;
            AppMethodBeat.o(209488);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209488);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            auv auv = (auv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        awr awr = new awr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = awr.populateBuilderWithField(aVar4, awr, a.getNextFieldNumber(aVar4))) {
                        }
                        auv.LFK = awr;
                    }
                    AppMethodBeat.o(209488);
                    return 0;
                default:
                    AppMethodBeat.o(209488);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209488);
            return -1;
        }
    }
}
