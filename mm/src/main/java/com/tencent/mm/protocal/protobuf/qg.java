package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class qg extends a {
    public LinkedList<qf> KXh = new LinkedList<>();
    public String Title;

    public qg() {
        AppMethodBeat.i(212262);
        AppMethodBeat.o(212262);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212263);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title != null) {
                aVar.e(1, this.Title);
            }
            aVar.e(2, 8, this.KXh);
            AppMethodBeat.o(212263);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0) + g.a.a.a.c(2, 8, this.KXh);
            AppMethodBeat.o(212263);
            return f2;
        } else if (i2 == 2) {
            this.KXh.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212263);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            qg qgVar = (qg) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    qgVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(212263);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        qf qfVar = new qf();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = qfVar.populateBuilderWithField(aVar4, qfVar, a.getNextFieldNumber(aVar4))) {
                        }
                        qgVar.KXh.add(qfVar);
                    }
                    AppMethodBeat.o(212263);
                    return 0;
                default:
                    AppMethodBeat.o(212263);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212263);
            return -1;
        }
    }
}
