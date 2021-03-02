package com.tencent.mm.plugin.product.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class m extends a {
    public String Bae;
    public String Baf;
    public LinkedList<h> Bag = new LinkedList<>();

    public m() {
        AppMethodBeat.i(91280);
        AppMethodBeat.o(91280);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91281);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Bae != null) {
                aVar.e(1, this.Bae);
            }
            if (this.Baf != null) {
                aVar.e(2, this.Baf);
            }
            aVar.e(3, 8, this.Bag);
            AppMethodBeat.o(91281);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Bae != null ? g.a.a.b.b.a.f(1, this.Bae) + 0 : 0;
            if (this.Baf != null) {
                f2 += g.a.a.b.b.a.f(2, this.Baf);
            }
            int c2 = f2 + g.a.a.a.c(3, 8, this.Bag);
            AppMethodBeat.o(91281);
            return c2;
        } else if (i2 == 2) {
            this.Bag.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91281);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            m mVar = (m) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    mVar.Bae = aVar3.UbS.readString();
                    AppMethodBeat.o(91281);
                    return 0;
                case 2:
                    mVar.Baf = aVar3.UbS.readString();
                    AppMethodBeat.o(91281);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        h hVar = new h();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = hVar.populateBuilderWithField(aVar4, hVar, a.getNextFieldNumber(aVar4))) {
                        }
                        mVar.Bag.add(hVar);
                    }
                    AppMethodBeat.o(91281);
                    return 0;
                default:
                    AppMethodBeat.o(91281);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91281);
            return -1;
        }
    }
}
