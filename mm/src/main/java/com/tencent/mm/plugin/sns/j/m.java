package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class m extends a {
    public LinkedList<n> DSe = new LinkedList<>();
    public LinkedList<n> DSf = new LinkedList<>();
    public boolean DSg;

    public m() {
        AppMethodBeat.i(96162);
        AppMethodBeat.o(96162);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(96163);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.e(1, 8, this.DSe);
            aVar.e(2, 8, this.DSf);
            aVar.cc(3, this.DSg);
            AppMethodBeat.o(96163);
            return 0;
        } else if (i2 == 1) {
            int c2 = g.a.a.a.c(1, 8, this.DSe) + 0 + g.a.a.a.c(2, 8, this.DSf) + g.a.a.b.b.a.fS(3) + 1;
            AppMethodBeat.o(96163);
            return c2;
        } else if (i2 == 2) {
            this.DSe.clear();
            this.DSf.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(96163);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        n nVar = new n();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = nVar.populateBuilderWithField(aVar4, nVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mVar.DSe.add(nVar);
                    }
                    AppMethodBeat.o(96163);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        n nVar2 = new n();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = nVar2.populateBuilderWithField(aVar5, nVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        mVar.DSf.add(nVar2);
                    }
                    AppMethodBeat.o(96163);
                    return 0;
                case 3:
                    mVar.DSg = aVar3.UbS.yZ();
                    AppMethodBeat.o(96163);
                    return 0;
                default:
                    AppMethodBeat.o(96163);
                    return -1;
            }
        } else {
            AppMethodBeat.o(96163);
            return -1;
        }
    }
}
