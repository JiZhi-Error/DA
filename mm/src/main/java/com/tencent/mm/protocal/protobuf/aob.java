package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class aob extends a {
    public String key;
    public String value;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(110848);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.key == null) {
                b bVar = new b("Not all required fields were included: key");
                AppMethodBeat.o(110848);
                throw bVar;
            } else if (this.value == null) {
                b bVar2 = new b("Not all required fields were included: value");
                AppMethodBeat.o(110848);
                throw bVar2;
            } else {
                if (this.key != null) {
                    aVar.e(1, this.key);
                }
                if (this.value != null) {
                    aVar.e(2, this.value);
                }
                AppMethodBeat.o(110848);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.key != null ? g.a.a.b.b.a.f(1, this.key) + 0 : 0;
            if (this.value != null) {
                f2 += g.a.a.b.b.a.f(2, this.value);
            }
            AppMethodBeat.o(110848);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.key == null) {
                b bVar3 = new b("Not all required fields were included: key");
                AppMethodBeat.o(110848);
                throw bVar3;
            } else if (this.value == null) {
                b bVar4 = new b("Not all required fields were included: value");
                AppMethodBeat.o(110848);
                throw bVar4;
            } else {
                AppMethodBeat.o(110848);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aob aob = (aob) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    aob.key = aVar3.UbS.readString();
                    AppMethodBeat.o(110848);
                    return 0;
                case 2:
                    aob.value = aVar3.UbS.readString();
                    AppMethodBeat.o(110848);
                    return 0;
                default:
                    AppMethodBeat.o(110848);
                    return -1;
            }
        } else {
            AppMethodBeat.o(110848);
            return -1;
        }
    }
}
