package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class ha extends a {
    public LinkedList<String> KKJ = new LinkedList<>();
    public long KKK;
    public String dHx;
    public String dOe;
    public String jfS;

    public ha() {
        AppMethodBeat.i(138168);
        AppMethodBeat.o(138168);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(138169);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dOe == null) {
                b bVar = new b("Not all required fields were included: roomname");
                AppMethodBeat.o(138169);
                throw bVar;
            }
            if (this.dOe != null) {
                aVar.e(1, this.dOe);
            }
            if (this.dHx != null) {
                aVar.e(2, this.dHx);
            }
            if (this.jfS != null) {
                aVar.e(3, this.jfS);
            }
            aVar.e(4, 1, this.KKJ);
            aVar.bb(5, this.KKK);
            AppMethodBeat.o(138169);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.dOe != null ? g.a.a.b.b.a.f(1, this.dOe) + 0 : 0;
            if (this.dHx != null) {
                f2 += g.a.a.b.b.a.f(2, this.dHx);
            }
            if (this.jfS != null) {
                f2 += g.a.a.b.b.a.f(3, this.jfS);
            }
            int c2 = f2 + g.a.a.a.c(4, 1, this.KKJ) + g.a.a.b.b.a.r(5, this.KKK);
            AppMethodBeat.o(138169);
            return c2;
        } else if (i2 == 2) {
            this.KKJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.dOe == null) {
                b bVar2 = new b("Not all required fields were included: roomname");
                AppMethodBeat.o(138169);
                throw bVar2;
            }
            AppMethodBeat.o(138169);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ha haVar = (ha) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    haVar.dOe = aVar3.UbS.readString();
                    AppMethodBeat.o(138169);
                    return 0;
                case 2:
                    haVar.dHx = aVar3.UbS.readString();
                    AppMethodBeat.o(138169);
                    return 0;
                case 3:
                    haVar.jfS = aVar3.UbS.readString();
                    AppMethodBeat.o(138169);
                    return 0;
                case 4:
                    haVar.KKJ.add(aVar3.UbS.readString());
                    AppMethodBeat.o(138169);
                    return 0;
                case 5:
                    haVar.KKK = aVar3.UbS.zl();
                    AppMethodBeat.o(138169);
                    return 0;
                default:
                    AppMethodBeat.o(138169);
                    return -1;
            }
        } else {
            AppMethodBeat.o(138169);
            return -1;
        }
    }
}
