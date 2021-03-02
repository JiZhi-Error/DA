package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class e extends a {
    public int count;
    public LinkedList<d> znt = new LinkedList<>();

    public e() {
        AppMethodBeat.i(26358);
        AppMethodBeat.o(26358);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(26359);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.count);
            aVar.e(2, 8, this.znt);
            AppMethodBeat.o(26359);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.count) + 0 + g.a.a.a.c(2, 8, this.znt);
            AppMethodBeat.o(26359);
            return bu;
        } else if (i2 == 2) {
            this.znt.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(26359);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eVar.count = aVar3.UbS.zi();
                    AppMethodBeat.o(26359);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d dVar = new d();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, a.getNextFieldNumber(aVar4))) {
                        }
                        eVar.znt.add(dVar);
                    }
                    AppMethodBeat.o(26359);
                    return 0;
                default:
                    AppMethodBeat.o(26359);
                    return -1;
            }
        } else {
            AppMethodBeat.o(26359);
            return -1;
        }
    }
}
