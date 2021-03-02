package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bc extends a {
    public String KEq;
    public String KEr;
    public String KEs;
    public String jfi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125688);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jfi != null) {
                aVar.e(1, this.jfi);
            }
            if (this.KEq != null) {
                aVar.e(2, this.KEq);
            }
            if (this.KEr != null) {
                aVar.e(3, this.KEr);
            }
            if (this.KEs != null) {
                aVar.e(4, this.KEs);
            }
            AppMethodBeat.o(125688);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.jfi != null ? g.a.a.b.b.a.f(1, this.jfi) + 0 : 0;
            if (this.KEq != null) {
                f2 += g.a.a.b.b.a.f(2, this.KEq);
            }
            if (this.KEr != null) {
                f2 += g.a.a.b.b.a.f(3, this.KEr);
            }
            if (this.KEs != null) {
                f2 += g.a.a.b.b.a.f(4, this.KEs);
            }
            AppMethodBeat.o(125688);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125688);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bc bcVar = (bc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bcVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(125688);
                    return 0;
                case 2:
                    bcVar.KEq = aVar3.UbS.readString();
                    AppMethodBeat.o(125688);
                    return 0;
                case 3:
                    bcVar.KEr = aVar3.UbS.readString();
                    AppMethodBeat.o(125688);
                    return 0;
                case 4:
                    bcVar.KEs = aVar3.UbS.readString();
                    AppMethodBeat.o(125688);
                    return 0;
                default:
                    AppMethodBeat.o(125688);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125688);
            return -1;
        }
    }
}
