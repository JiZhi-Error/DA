package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class ehs extends a {
    public String KJV;
    public String iwv;
    public int weight;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124569);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KJV != null) {
                aVar.e(1, this.KJV);
            }
            if (this.iwv != null) {
                aVar.e(2, this.iwv);
            }
            aVar.aM(3, this.weight);
            AppMethodBeat.o(124569);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KJV != null ? g.a.a.b.b.a.f(1, this.KJV) + 0 : 0;
            if (this.iwv != null) {
                f2 += g.a.a.b.b.a.f(2, this.iwv);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.weight);
            AppMethodBeat.o(124569);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124569);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ehs ehs = (ehs) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ehs.KJV = aVar3.UbS.readString();
                    AppMethodBeat.o(124569);
                    return 0;
                case 2:
                    ehs.iwv = aVar3.UbS.readString();
                    AppMethodBeat.o(124569);
                    return 0;
                case 3:
                    ehs.weight = aVar3.UbS.zi();
                    AppMethodBeat.o(124569);
                    return 0;
                default:
                    AppMethodBeat.o(124569);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124569);
            return -1;
        }
    }
}
