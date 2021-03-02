package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eqx extends a {
    public ccw LlY;
    public long Nop;
    public double Noq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110916);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.Nop);
            aVar.e(2, this.Noq);
            if (this.LlY != null) {
                aVar.ni(3, this.LlY.computeSize());
                this.LlY.writeFields(aVar);
            }
            AppMethodBeat.o(110916);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Nop) + 0 + g.a.a.b.b.a.fS(2) + 8;
            if (this.LlY != null) {
                r += g.a.a.a.nh(3, this.LlY.computeSize());
            }
            AppMethodBeat.o(110916);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(110916);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eqx eqx = (eqx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eqx.Nop = aVar3.UbS.zl();
                    AppMethodBeat.o(110916);
                    return 0;
                case 2:
                    eqx.Noq = Double.longBitsToDouble(aVar3.UbS.zn());
                    AppMethodBeat.o(110916);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ccw ccw = new ccw();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ccw.populateBuilderWithField(aVar4, ccw, a.getNextFieldNumber(aVar4))) {
                        }
                        eqx.LlY = ccw;
                    }
                    AppMethodBeat.o(110916);
                    return 0;
                default:
                    AppMethodBeat.o(110916);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110916);
            return -1;
        }
    }
}
