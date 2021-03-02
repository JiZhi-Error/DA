package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aw extends a {
    public an Btj;
    public long uin;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(198641);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.uin);
            if (this.Btj != null) {
                aVar.ni(2, this.Btj.computeSize());
                this.Btj.writeFields(aVar);
            }
            AppMethodBeat.o(198641);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.uin) + 0;
            if (this.Btj != null) {
                r += g.a.a.a.nh(2, this.Btj.computeSize());
            }
            AppMethodBeat.o(198641);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(198641);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aw awVar = (aw) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    awVar.uin = aVar3.UbS.zl();
                    AppMethodBeat.o(198641);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        an anVar = new an();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = anVar.populateBuilderWithField(aVar4, anVar, a.getNextFieldNumber(aVar4))) {
                        }
                        awVar.Btj = anVar;
                    }
                    AppMethodBeat.o(198641);
                    return 0;
                default:
                    AppMethodBeat.o(198641);
                    return -1;
            }
        } else {
            AppMethodBeat.o(198641);
            return -1;
        }
    }
}
