package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bfj extends a {
    public eih LOX;
    public String LOY = "";
    public int LOZ = 0;
    public long timestamp = 0;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122492);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LOX != null) {
                aVar.ni(1, this.LOX.computeSize());
                this.LOX.writeFields(aVar);
            }
            if (this.LOY != null) {
                aVar.e(2, this.LOY);
            }
            aVar.bb(3, this.timestamp);
            aVar.aM(4, this.LOZ);
            AppMethodBeat.o(122492);
            return 0;
        } else if (i2 == 1) {
            int nh = this.LOX != null ? g.a.a.a.nh(1, this.LOX.computeSize()) + 0 : 0;
            if (this.LOY != null) {
                nh += g.a.a.b.b.a.f(2, this.LOY);
            }
            int r = nh + g.a.a.b.b.a.r(3, this.timestamp) + g.a.a.b.b.a.bu(4, this.LOZ);
            AppMethodBeat.o(122492);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122492);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfj bfj = (bfj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eih eih = new eih();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eih.populateBuilderWithField(aVar4, eih, a.getNextFieldNumber(aVar4))) {
                        }
                        bfj.LOX = eih;
                    }
                    AppMethodBeat.o(122492);
                    return 0;
                case 2:
                    bfj.LOY = aVar3.UbS.readString();
                    AppMethodBeat.o(122492);
                    return 0;
                case 3:
                    bfj.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(122492);
                    return 0;
                case 4:
                    bfj.LOZ = aVar3.UbS.zi();
                    AppMethodBeat.o(122492);
                    return 0;
                default:
                    AppMethodBeat.o(122492);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122492);
            return -1;
        }
    }
}
