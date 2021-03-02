package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class cft extends a {
    public String iFF;
    public String key;
    public int type = -1;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220712);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.key == null) {
                b bVar = new b("Not all required fields were included: key");
                AppMethodBeat.o(220712);
                throw bVar;
            } else if (this.iFF == null) {
                b bVar2 = new b("Not all required fields were included: val");
                AppMethodBeat.o(220712);
                throw bVar2;
            } else {
                aVar.aM(1, this.type);
                if (this.key != null) {
                    aVar.e(2, this.key);
                }
                if (this.iFF != null) {
                    aVar.e(3, this.iFF);
                }
                AppMethodBeat.o(220712);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.type) + 0;
            if (this.key != null) {
                bu += g.a.a.b.b.a.f(2, this.key);
            }
            if (this.iFF != null) {
                bu += g.a.a.b.b.a.f(3, this.iFF);
            }
            AppMethodBeat.o(220712);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.key == null) {
                b bVar3 = new b("Not all required fields were included: key");
                AppMethodBeat.o(220712);
                throw bVar3;
            } else if (this.iFF == null) {
                b bVar4 = new b("Not all required fields were included: val");
                AppMethodBeat.o(220712);
                throw bVar4;
            } else {
                AppMethodBeat.o(220712);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cft cft = (cft) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cft.type = aVar3.UbS.zi();
                    AppMethodBeat.o(220712);
                    return 0;
                case 2:
                    cft.key = aVar3.UbS.readString();
                    AppMethodBeat.o(220712);
                    return 0;
                case 3:
                    cft.iFF = aVar3.UbS.readString();
                    AppMethodBeat.o(220712);
                    return 0;
                default:
                    AppMethodBeat.o(220712);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220712);
            return -1;
        }
    }
}
