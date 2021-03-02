package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class aof extends a {
    public String LAi;
    public LinkedList<aog> LAj = new LinkedList<>();
    public String desc;
    public String title;

    public aof() {
        AppMethodBeat.i(91463);
        AppMethodBeat.o(91463);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91464);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.LAi != null) {
                aVar.e(2, this.LAi);
            }
            aVar.e(3, 8, this.LAj);
            if (this.desc != null) {
                aVar.e(4, this.desc);
            }
            AppMethodBeat.o(91464);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.LAi != null) {
                f2 += g.a.a.b.b.a.f(2, this.LAi);
            }
            int c2 = f2 + g.a.a.a.c(3, 8, this.LAj);
            if (this.desc != null) {
                c2 += g.a.a.b.b.a.f(4, this.desc);
            }
            AppMethodBeat.o(91464);
            return c2;
        } else if (i2 == 2) {
            this.LAj.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91464);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aof aof = (aof) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aof.title = aVar3.UbS.readString();
                    AppMethodBeat.o(91464);
                    return 0;
                case 2:
                    aof.LAi = aVar3.UbS.readString();
                    AppMethodBeat.o(91464);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        aog aog = new aog();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = aog.populateBuilderWithField(aVar4, aog, a.getNextFieldNumber(aVar4))) {
                        }
                        aof.LAj.add(aog);
                    }
                    AppMethodBeat.o(91464);
                    return 0;
                case 4:
                    aof.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(91464);
                    return 0;
                default:
                    AppMethodBeat.o(91464);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91464);
            return -1;
        }
    }
}
