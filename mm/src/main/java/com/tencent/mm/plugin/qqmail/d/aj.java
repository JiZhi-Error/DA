package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class aj extends a {
    public String name;
    public String path;
    public long size;
    public int state;
    public String svrId;
    public long ulj;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122801);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.path == null) {
                b bVar = new b("Not all required fields were included: path");
                AppMethodBeat.o(122801);
                throw bVar;
            } else if (this.name == null) {
                b bVar2 = new b("Not all required fields were included: name");
                AppMethodBeat.o(122801);
                throw bVar2;
            } else {
                if (this.path != null) {
                    aVar.e(1, this.path);
                }
                if (this.name != null) {
                    aVar.e(2, this.name);
                }
                aVar.bb(3, this.size);
                aVar.aM(4, this.state);
                aVar.bb(5, this.ulj);
                if (this.svrId != null) {
                    aVar.e(6, this.svrId);
                }
                AppMethodBeat.o(122801);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.path != null ? g.a.a.b.b.a.f(1, this.path) + 0 : 0;
            if (this.name != null) {
                f2 += g.a.a.b.b.a.f(2, this.name);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.size) + g.a.a.b.b.a.bu(4, this.state) + g.a.a.b.b.a.r(5, this.ulj);
            if (this.svrId != null) {
                r += g.a.a.b.b.a.f(6, this.svrId);
            }
            AppMethodBeat.o(122801);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.path == null) {
                b bVar3 = new b("Not all required fields were included: path");
                AppMethodBeat.o(122801);
                throw bVar3;
            } else if (this.name == null) {
                b bVar4 = new b("Not all required fields were included: name");
                AppMethodBeat.o(122801);
                throw bVar4;
            } else {
                AppMethodBeat.o(122801);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aj ajVar = (aj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ajVar.path = aVar3.UbS.readString();
                    AppMethodBeat.o(122801);
                    return 0;
                case 2:
                    ajVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(122801);
                    return 0;
                case 3:
                    ajVar.size = aVar3.UbS.zl();
                    AppMethodBeat.o(122801);
                    return 0;
                case 4:
                    ajVar.state = aVar3.UbS.zi();
                    AppMethodBeat.o(122801);
                    return 0;
                case 5:
                    ajVar.ulj = aVar3.UbS.zl();
                    AppMethodBeat.o(122801);
                    return 0;
                case 6:
                    ajVar.svrId = aVar3.UbS.readString();
                    AppMethodBeat.o(122801);
                    return 0;
                default:
                    AppMethodBeat.o(122801);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122801);
            return -1;
        }
    }
}
