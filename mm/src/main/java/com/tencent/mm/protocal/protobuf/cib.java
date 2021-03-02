package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cib extends a {
    public String AesKey;
    public int FileSize;
    public String KMl;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104821);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KMl != null) {
                aVar.e(1, this.KMl);
            }
            if (this.AesKey != null) {
                aVar.e(2, this.AesKey);
            }
            aVar.aM(3, this.FileSize);
            AppMethodBeat.o(104821);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.KMl != null ? g.a.a.b.b.a.f(1, this.KMl) + 0 : 0;
            if (this.AesKey != null) {
                f2 += g.a.a.b.b.a.f(2, this.AesKey);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.FileSize);
            AppMethodBeat.o(104821);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(104821);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cib cib = (cib) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cib.KMl = aVar3.UbS.readString();
                    AppMethodBeat.o(104821);
                    return 0;
                case 2:
                    cib.AesKey = aVar3.UbS.readString();
                    AppMethodBeat.o(104821);
                    return 0;
                case 3:
                    cib.FileSize = aVar3.UbS.zi();
                    AppMethodBeat.o(104821);
                    return 0;
                default:
                    AppMethodBeat.o(104821);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104821);
            return -1;
        }
    }
}
