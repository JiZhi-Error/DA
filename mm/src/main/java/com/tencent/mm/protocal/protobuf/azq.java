package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class azq extends a {
    public awe LJv;
    public long object_id;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209616);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.object_id);
            if (this.LJv != null) {
                aVar.ni(2, this.LJv.computeSize());
                this.LJv.writeFields(aVar);
            }
            AppMethodBeat.o(209616);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.object_id) + 0;
            if (this.LJv != null) {
                r += g.a.a.a.nh(2, this.LJv.computeSize());
            }
            AppMethodBeat.o(209616);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209616);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            azq azq = (azq) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    azq.object_id = aVar3.UbS.zl();
                    AppMethodBeat.o(209616);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        awe awe = new awe();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = awe.populateBuilderWithField(aVar4, awe, a.getNextFieldNumber(aVar4))) {
                        }
                        azq.LJv = awe;
                    }
                    AppMethodBeat.o(209616);
                    return 0;
                default:
                    AppMethodBeat.o(209616);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209616);
            return -1;
        }
    }
}
