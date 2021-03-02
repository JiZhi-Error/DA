package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ddf extends a {
    public String MIm;
    public String MIn;
    public LinkedList<ehn> MIo = new LinkedList<>();

    public ddf() {
        AppMethodBeat.i(72550);
        AppMethodBeat.o(72550);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72551);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MIm != null) {
                aVar.e(1, this.MIm);
            }
            if (this.MIn != null) {
                aVar.e(2, this.MIn);
            }
            aVar.e(3, 8, this.MIo);
            AppMethodBeat.o(72551);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MIm != null ? g.a.a.b.b.a.f(1, this.MIm) + 0 : 0;
            if (this.MIn != null) {
                f2 += g.a.a.b.b.a.f(2, this.MIn);
            }
            int c2 = f2 + g.a.a.a.c(3, 8, this.MIo);
            AppMethodBeat.o(72551);
            return c2;
        } else if (i2 == 2) {
            this.MIo.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72551);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ddf ddf = (ddf) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    ddf.MIm = aVar3.UbS.readString();
                    AppMethodBeat.o(72551);
                    return 0;
                case 2:
                    ddf.MIn = aVar3.UbS.readString();
                    AppMethodBeat.o(72551);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ehn ehn = new ehn();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ehn.populateBuilderWithField(aVar4, ehn, a.getNextFieldNumber(aVar4))) {
                        }
                        ddf.MIo.add(ehn);
                    }
                    AppMethodBeat.o(72551);
                    return 0;
                default:
                    AppMethodBeat.o(72551);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72551);
            return -1;
        }
    }
}
