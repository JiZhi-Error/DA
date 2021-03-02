package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dks extends a {
    public aat MaO;
    public long clK;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50102);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.clK);
            if (this.MaO != null) {
                aVar.ni(2, this.MaO.computeSize());
                this.MaO.writeFields(aVar);
            }
            AppMethodBeat.o(50102);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.clK) + 0;
            if (this.MaO != null) {
                r += g.a.a.a.nh(2, this.MaO.computeSize());
            }
            AppMethodBeat.o(50102);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50102);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dks dks = (dks) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dks.clK = aVar3.UbS.zl();
                    AppMethodBeat.o(50102);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aat aat = new aat();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aat.populateBuilderWithField(aVar4, aat, a.getNextFieldNumber(aVar4))) {
                        }
                        dks.MaO = aat;
                    }
                    AppMethodBeat.o(50102);
                    return 0;
                default:
                    AppMethodBeat.o(50102);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50102);
            return -1;
        }
    }
}
