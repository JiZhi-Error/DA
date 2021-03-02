package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fa extends a {
    public String Id;
    public String KIq;
    public String KIr;
    public int KIs;
    public String Version;
    public String xMq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125709);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Id != null) {
                aVar.e(1, this.Id);
            }
            if (this.Version != null) {
                aVar.e(2, this.Version);
            }
            if (this.xMq != null) {
                aVar.e(3, this.xMq);
            }
            if (this.KIq != null) {
                aVar.e(4, this.KIq);
            }
            if (this.KIr != null) {
                aVar.e(5, this.KIr);
            }
            aVar.aM(6, this.KIs);
            AppMethodBeat.o(125709);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Id != null ? g.a.a.b.b.a.f(1, this.Id) + 0 : 0;
            if (this.Version != null) {
                f2 += g.a.a.b.b.a.f(2, this.Version);
            }
            if (this.xMq != null) {
                f2 += g.a.a.b.b.a.f(3, this.xMq);
            }
            if (this.KIq != null) {
                f2 += g.a.a.b.b.a.f(4, this.KIq);
            }
            if (this.KIr != null) {
                f2 += g.a.a.b.b.a.f(5, this.KIr);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.KIs);
            AppMethodBeat.o(125709);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125709);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fa faVar = (fa) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    faVar.Id = aVar3.UbS.readString();
                    AppMethodBeat.o(125709);
                    return 0;
                case 2:
                    faVar.Version = aVar3.UbS.readString();
                    AppMethodBeat.o(125709);
                    return 0;
                case 3:
                    faVar.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(125709);
                    return 0;
                case 4:
                    faVar.KIq = aVar3.UbS.readString();
                    AppMethodBeat.o(125709);
                    return 0;
                case 5:
                    faVar.KIr = aVar3.UbS.readString();
                    AppMethodBeat.o(125709);
                    return 0;
                case 6:
                    faVar.KIs = aVar3.UbS.zi();
                    AppMethodBeat.o(125709);
                    return 0;
                default:
                    AppMethodBeat.o(125709);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125709);
            return -1;
        }
    }
}
