package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class c extends a {
    public String ANo;
    public LinkedList<d> HEk = new LinkedList<>();

    public c() {
        AppMethodBeat.i(91286);
        AppMethodBeat.o(91286);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91287);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ANo != null) {
                aVar.e(1, this.ANo);
            }
            aVar.e(2, 8, this.HEk);
            AppMethodBeat.o(91287);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.ANo != null ? g.a.a.b.b.a.f(1, this.ANo) + 0 : 0) + g.a.a.a.c(2, 8, this.HEk);
            AppMethodBeat.o(91287);
            return f2;
        } else if (i2 == 2) {
            this.HEk.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91287);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            c cVar = (c) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cVar.ANo = aVar3.UbS.readString();
                    AppMethodBeat.o(91287);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        d dVar = new d();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dVar.populateBuilderWithField(aVar4, dVar, a.getNextFieldNumber(aVar4))) {
                        }
                        cVar.HEk.add(dVar);
                    }
                    AppMethodBeat.o(91287);
                    return 0;
                default:
                    AppMethodBeat.o(91287);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91287);
            return -1;
        }
    }
}
