package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class abp extends a {
    public String Lmu;
    public String Lmv;
    public LinkedList<cow> Lmw = new LinkedList<>();

    public abp() {
        AppMethodBeat.i(116467);
        AppMethodBeat.o(116467);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(116468);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Lmu != null) {
                aVar.e(1, this.Lmu);
            }
            if (this.Lmv != null) {
                aVar.e(2, this.Lmv);
            }
            aVar.e(3, 8, this.Lmw);
            AppMethodBeat.o(116468);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Lmu != null ? g.a.a.b.b.a.f(1, this.Lmu) + 0 : 0;
            if (this.Lmv != null) {
                f2 += g.a.a.b.b.a.f(2, this.Lmv);
            }
            int c2 = f2 + g.a.a.a.c(3, 8, this.Lmw);
            AppMethodBeat.o(116468);
            return c2;
        } else if (i2 == 2) {
            this.Lmw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(116468);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            abp abp = (abp) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    abp.Lmu = aVar3.UbS.readString();
                    AppMethodBeat.o(116468);
                    return 0;
                case 2:
                    abp.Lmv = aVar3.UbS.readString();
                    AppMethodBeat.o(116468);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        cow cow = new cow();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = cow.populateBuilderWithField(aVar4, cow, a.getNextFieldNumber(aVar4))) {
                        }
                        abp.Lmw.add(cow);
                    }
                    AppMethodBeat.o(116468);
                    return 0;
                default:
                    AppMethodBeat.o(116468);
                    return -1;
            }
        } else {
            AppMethodBeat.o(116468);
            return -1;
        }
    }
}
