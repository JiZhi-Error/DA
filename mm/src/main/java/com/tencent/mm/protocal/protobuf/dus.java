package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dus extends a {
    public ccw MVX;
    public long MVY;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110910);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MVX != null) {
                aVar.ni(1, this.MVX.computeSize());
                this.MVX.writeFields(aVar);
            }
            aVar.bb(2, this.MVY);
            AppMethodBeat.o(110910);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.MVX != null ? g.a.a.a.nh(1, this.MVX.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.MVY);
            AppMethodBeat.o(110910);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(110910);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dus dus = (dus) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ccw ccw = new ccw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ccw.populateBuilderWithField(aVar4, ccw, a.getNextFieldNumber(aVar4))) {
                        }
                        dus.MVX = ccw;
                    }
                    AppMethodBeat.o(110910);
                    return 0;
                case 2:
                    dus.MVY = aVar3.UbS.zl();
                    AppMethodBeat.o(110910);
                    return 0;
                default:
                    AppMethodBeat.o(110910);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110910);
            return -1;
        }
    }
}
