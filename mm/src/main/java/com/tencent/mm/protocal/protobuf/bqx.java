package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bqx extends a {
    public String LYu;
    public esq LYv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115839);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LYu != null) {
                aVar.e(1, this.LYu);
            }
            if (this.LYv != null) {
                aVar.ni(2, this.LYv.computeSize());
                this.LYv.writeFields(aVar);
            }
            AppMethodBeat.o(115839);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LYu != null ? g.a.a.b.b.a.f(1, this.LYu) + 0 : 0;
            if (this.LYv != null) {
                f2 += g.a.a.a.nh(2, this.LYv.computeSize());
            }
            AppMethodBeat.o(115839);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(115839);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bqx bqx = (bqx) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bqx.LYu = aVar3.UbS.readString();
                    AppMethodBeat.o(115839);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        esq esq = new esq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = esq.populateBuilderWithField(aVar4, esq, a.getNextFieldNumber(aVar4))) {
                        }
                        bqx.LYv = esq;
                    }
                    AppMethodBeat.o(115839);
                    return 0;
                default:
                    AppMethodBeat.o(115839);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115839);
            return -1;
        }
    }
}
