package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class eqy extends a {
    public boolean GAH;
    public String IFw;
    public long duration;
    public String iiv;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(201304);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.IFw == null) {
                b bVar = new b("Not all required fields were included: templatePath");
                AppMethodBeat.o(201304);
                throw bVar;
            } else if (this.iiv == null) {
                b bVar2 = new b("Not all required fields were included: musicPath");
                AppMethodBeat.o(201304);
                throw bVar2;
            } else {
                if (this.IFw != null) {
                    aVar.e(1, this.IFw);
                }
                if (this.iiv != null) {
                    aVar.e(2, this.iiv);
                }
                aVar.bb(3, this.duration);
                aVar.cc(4, this.GAH);
                AppMethodBeat.o(201304);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.IFw != null ? g.a.a.b.b.a.f(1, this.IFw) + 0 : 0;
            if (this.iiv != null) {
                f2 += g.a.a.b.b.a.f(2, this.iiv);
            }
            int r = f2 + g.a.a.b.b.a.r(3, this.duration) + g.a.a.b.b.a.fS(4) + 1;
            AppMethodBeat.o(201304);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.IFw == null) {
                b bVar3 = new b("Not all required fields were included: templatePath");
                AppMethodBeat.o(201304);
                throw bVar3;
            } else if (this.iiv == null) {
                b bVar4 = new b("Not all required fields were included: musicPath");
                AppMethodBeat.o(201304);
                throw bVar4;
            } else {
                AppMethodBeat.o(201304);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eqy eqy = (eqy) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eqy.IFw = aVar3.UbS.readString();
                    AppMethodBeat.o(201304);
                    return 0;
                case 2:
                    eqy.iiv = aVar3.UbS.readString();
                    AppMethodBeat.o(201304);
                    return 0;
                case 3:
                    eqy.duration = aVar3.UbS.zl();
                    AppMethodBeat.o(201304);
                    return 0;
                case 4:
                    eqy.GAH = aVar3.UbS.yZ();
                    AppMethodBeat.o(201304);
                    return 0;
                default:
                    AppMethodBeat.o(201304);
                    return -1;
            }
        } else {
            AppMethodBeat.o(201304);
            return -1;
        }
    }
}
