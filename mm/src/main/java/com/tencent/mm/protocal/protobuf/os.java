package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class os extends a {
    public String KSV;
    public LinkedList<String> KUB = new LinkedList<>();
    public String KUE;

    public os() {
        AppMethodBeat.i(212244);
        AppMethodBeat.o(212244);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(212245);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KSV != null) {
                aVar.e(1, this.KSV);
            }
            aVar.e(2, 1, this.KUB);
            if (this.KUE != null) {
                aVar.e(3, this.KUE);
            }
            AppMethodBeat.o(212245);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KSV != null ? g.a.a.b.b.a.f(1, this.KSV) + 0 : 0) + g.a.a.a.c(2, 1, this.KUB);
            if (this.KUE != null) {
                f2 += g.a.a.b.b.a.f(3, this.KUE);
            }
            AppMethodBeat.o(212245);
            return f2;
        } else if (i2 == 2) {
            this.KUB.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(212245);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            os osVar = (os) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    osVar.KSV = aVar3.UbS.readString();
                    AppMethodBeat.o(212245);
                    return 0;
                case 2:
                    osVar.KUB.add(aVar3.UbS.readString());
                    AppMethodBeat.o(212245);
                    return 0;
                case 3:
                    osVar.KUE = aVar3.UbS.readString();
                    AppMethodBeat.o(212245);
                    return 0;
                default:
                    AppMethodBeat.o(212245);
                    return -1;
            }
        } else {
            AppMethodBeat.o(212245);
            return -1;
        }
    }
}
