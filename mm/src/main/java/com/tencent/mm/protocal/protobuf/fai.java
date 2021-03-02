package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class fai extends a {
    public LinkedList<String> LOe = new LinkedList<>();
    public String key;

    public fai() {
        AppMethodBeat.i(224548);
        AppMethodBeat.o(224548);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(224549);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.key == null) {
                b bVar = new b("Not all required fields were included: key");
                AppMethodBeat.o(224549);
                throw bVar;
            }
            if (this.key != null) {
                aVar.e(1, this.key);
            }
            aVar.e(2, 1, this.LOe);
            AppMethodBeat.o(224549);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.key != null ? g.a.a.b.b.a.f(1, this.key) + 0 : 0) + g.a.a.a.c(2, 1, this.LOe);
            AppMethodBeat.o(224549);
            return f2;
        } else if (i2 == 2) {
            this.LOe.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.key == null) {
                b bVar2 = new b("Not all required fields were included: key");
                AppMethodBeat.o(224549);
                throw bVar2;
            }
            AppMethodBeat.o(224549);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fai fai = (fai) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fai.key = aVar3.UbS.readString();
                    AppMethodBeat.o(224549);
                    return 0;
                case 2:
                    fai.LOe.add(aVar3.UbS.readString());
                    AppMethodBeat.o(224549);
                    return 0;
                default:
                    AppMethodBeat.o(224549);
                    return -1;
            }
        } else {
            AppMethodBeat.o(224549);
            return -1;
        }
    }
}
