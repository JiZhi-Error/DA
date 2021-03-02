package com.tencent.mm.protocal.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class b extends a {
    public LinkedList<a> KBq = new LinkedList<>();
    public int id;
    public String msg;
    public String title;

    public b() {
        AppMethodBeat.i(123717);
        AppMethodBeat.o(123717);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123718);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.aM(1, this.id);
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.msg != null) {
                aVar.e(3, this.msg);
            }
            aVar.e(4, 8, this.KBq);
            AppMethodBeat.o(123718);
            return 0;
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.id) + 0;
            if (this.title != null) {
                bu += g.a.a.b.b.a.f(2, this.title);
            }
            if (this.msg != null) {
                bu += g.a.a.b.b.a.f(3, this.msg);
            }
            int c2 = bu + g.a.a.a.c(4, 8, this.KBq);
            AppMethodBeat.o(123718);
            return c2;
        } else if (i2 == 2) {
            this.KBq.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123718);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.id = aVar3.UbS.zi();
                    AppMethodBeat.o(123718);
                    return 0;
                case 2:
                    bVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(123718);
                    return 0;
                case 3:
                    bVar.msg = aVar3.UbS.readString();
                    AppMethodBeat.o(123718);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        a aVar4 = new a();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aVar4.populateBuilderWithField(aVar5, aVar4, a.getNextFieldNumber(aVar5))) {
                        }
                        bVar.KBq.add(aVar4);
                    }
                    AppMethodBeat.o(123718);
                    return 0;
                default:
                    AppMethodBeat.o(123718);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123718);
            return -1;
        }
    }
}
