package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ehj extends a {
    public ehn Mwt;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72585);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.Mwt != null) {
                aVar.ni(2, this.Mwt.computeSize());
                this.Mwt.writeFields(aVar);
            }
            AppMethodBeat.o(72585);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.Mwt != null) {
                f2 += g.a.a.a.nh(2, this.Mwt.computeSize());
            }
            AppMethodBeat.o(72585);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72585);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ehj ehj = (ehj) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ehj.title = aVar3.UbS.readString();
                    AppMethodBeat.o(72585);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ehn ehn = new ehn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ehn.populateBuilderWithField(aVar4, ehn, a.getNextFieldNumber(aVar4))) {
                        }
                        ehj.Mwt = ehn;
                    }
                    AppMethodBeat.o(72585);
                    return 0;
                default:
                    AppMethodBeat.o(72585);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72585);
            return -1;
        }
    }
}
