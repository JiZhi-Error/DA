package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class agz extends a {
    public int LqD;
    public LinkedList<abz> LqE = new LinkedList<>();
    public String pRY;
    public String title;

    public agz() {
        AppMethodBeat.i(113996);
        AppMethodBeat.o(113996);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113997);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.pRY != null) {
                aVar.e(2, this.pRY);
            }
            aVar.aM(3, this.LqD);
            aVar.e(4, 8, this.LqE);
            AppMethodBeat.o(113997);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.pRY != null) {
                f2 += g.a.a.b.b.a.f(2, this.pRY);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.LqD) + g.a.a.a.c(4, 8, this.LqE);
            AppMethodBeat.o(113997);
            return bu;
        } else if (i2 == 2) {
            this.LqE.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113997);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            agz agz = (agz) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    agz.title = aVar3.UbS.readString();
                    AppMethodBeat.o(113997);
                    return 0;
                case 2:
                    agz.pRY = aVar3.UbS.readString();
                    AppMethodBeat.o(113997);
                    return 0;
                case 3:
                    agz.LqD = aVar3.UbS.zi();
                    AppMethodBeat.o(113997);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        abz abz = new abz();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = abz.populateBuilderWithField(aVar4, abz, a.getNextFieldNumber(aVar4))) {
                        }
                        agz.LqE.add(abz);
                    }
                    AppMethodBeat.o(113997);
                    return 0;
                default:
                    AppMethodBeat.o(113997);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113997);
            return -1;
        }
    }
}
