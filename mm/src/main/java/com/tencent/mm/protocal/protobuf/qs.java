package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class qs extends a {
    public String KXy;
    public LinkedList<dgp> KXz = new LinkedList<>();

    public qs() {
        AppMethodBeat.i(200187);
        AppMethodBeat.o(200187);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(200188);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KXy != null) {
                aVar.e(1, this.KXy);
            }
            aVar.e(2, 8, this.KXz);
            AppMethodBeat.o(200188);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.KXy != null ? g.a.a.b.b.a.f(1, this.KXy) + 0 : 0) + g.a.a.a.c(2, 8, this.KXz);
            AppMethodBeat.o(200188);
            return f2;
        } else if (i2 == 2) {
            this.KXz.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(200188);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            qs qsVar = (qs) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    qsVar.KXy = aVar3.UbS.readString();
                    AppMethodBeat.o(200188);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dgp dgp = new dgp();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dgp.populateBuilderWithField(aVar4, dgp, a.getNextFieldNumber(aVar4))) {
                        }
                        qsVar.KXz.add(dgp);
                    }
                    AppMethodBeat.o(200188);
                    return 0;
                default:
                    AppMethodBeat.o(200188);
                    return -1;
            }
        } else {
            AppMethodBeat.o(200188);
            return -1;
        }
    }
}
