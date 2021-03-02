package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eqp extends a {
    public eqt NnZ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212312);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.NnZ != null) {
                aVar.ni(1, this.NnZ.computeSize());
                this.NnZ.writeFields(aVar);
            }
            AppMethodBeat.o(212312);
            return 0;
        } else if (i2 == 1) {
            int nh = this.NnZ != null ? g.a.a.a.nh(1, this.NnZ.computeSize()) + 0 : 0;
            AppMethodBeat.o(212312);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212312);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eqp eqp = (eqp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eqt eqt = new eqt();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eqt.populateBuilderWithField(aVar4, eqt, a.getNextFieldNumber(aVar4))) {
                        }
                        eqp.NnZ = eqt;
                    }
                    AppMethodBeat.o(212312);
                    return 0;
                default:
                    AppMethodBeat.o(212312);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212312);
            return -1;
        }
    }
}
