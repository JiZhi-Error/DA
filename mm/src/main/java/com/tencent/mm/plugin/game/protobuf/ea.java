package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ea extends a {
    public String jfi;
    public String xut;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256651);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.jfi == null) {
                b bVar = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(256651);
                throw bVar;
            }
            if (this.jfi != null) {
                aVar.e(1, this.jfi);
            }
            if (this.xut != null) {
                aVar.e(2, this.xut);
            }
            AppMethodBeat.o(256651);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.jfi != null ? g.a.a.b.b.a.f(1, this.jfi) + 0 : 0;
            if (this.xut != null) {
                f2 += g.a.a.b.b.a.f(2, this.xut);
            }
            AppMethodBeat.o(256651);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.jfi == null) {
                b bVar2 = new b("Not all required fields were included: AppId");
                AppMethodBeat.o(256651);
                throw bVar2;
            }
            AppMethodBeat.o(256651);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ea eaVar = (ea) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eaVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(256651);
                    return 0;
                case 2:
                    eaVar.xut = aVar3.UbS.readString();
                    AppMethodBeat.o(256651);
                    return 0;
                default:
                    AppMethodBeat.o(256651);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256651);
            return -1;
        }
    }
}