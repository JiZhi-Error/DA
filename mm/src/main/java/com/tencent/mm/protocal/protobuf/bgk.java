package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class bgk extends a {
    public bgd LQk;
    public LinkedList<String> LQl = new LinkedList<>();

    public bgk() {
        AppMethodBeat.i(42644);
        AppMethodBeat.o(42644);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(42645);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LQk == null) {
                b bVar = new b("Not all required fields were included: GameItem");
                AppMethodBeat.o(42645);
                throw bVar;
            }
            if (this.LQk != null) {
                aVar.ni(1, this.LQk.computeSize());
                this.LQk.writeFields(aVar);
            }
            aVar.e(2, 1, this.LQl);
            AppMethodBeat.o(42645);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.LQk != null ? g.a.a.a.nh(1, this.LQk.computeSize()) + 0 : 0) + g.a.a.a.c(2, 1, this.LQl);
            AppMethodBeat.o(42645);
            return nh;
        } else if (i2 == 2) {
            this.LQl.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LQk == null) {
                b bVar2 = new b("Not all required fields were included: GameItem");
                AppMethodBeat.o(42645);
                throw bVar2;
            }
            AppMethodBeat.o(42645);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bgk bgk = (bgk) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        bgd bgd = new bgd();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = bgd.populateBuilderWithField(aVar4, bgd, a.getNextFieldNumber(aVar4))) {
                        }
                        bgk.LQk = bgd;
                    }
                    AppMethodBeat.o(42645);
                    return 0;
                case 2:
                    bgk.LQl.add(aVar3.UbS.readString());
                    AppMethodBeat.o(42645);
                    return 0;
                default:
                    AppMethodBeat.o(42645);
                    return -1;
            }
        } else {
            AppMethodBeat.o(42645);
            return -1;
        }
    }
}
