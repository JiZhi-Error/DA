package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class adi extends a {
    public String LjZ;
    public LinkedList<Integer> Low = new LinkedList<>();

    public adi() {
        AppMethodBeat.i(32170);
        AppMethodBeat.o(32170);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32171);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LjZ != null) {
                aVar.e(1, this.LjZ);
            }
            aVar.e(2, 2, this.Low);
            AppMethodBeat.o(32171);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LjZ != null ? g.a.a.b.b.a.f(1, this.LjZ) + 0 : 0) + g.a.a.a.c(2, 2, this.Low);
            AppMethodBeat.o(32171);
            return f2;
        } else if (i2 == 2) {
            this.Low.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32171);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            adi adi = (adi) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    adi.LjZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32171);
                    return 0;
                case 2:
                    adi.Low.add(Integer.valueOf(aVar3.UbS.zi()));
                    AppMethodBeat.o(32171);
                    return 0;
                default:
                    AppMethodBeat.o(32171);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32171);
            return -1;
        }
    }
}
