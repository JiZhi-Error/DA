package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ade extends a {
    public String id;
    public long timestamp;
    public int type;
    public boolean vtY = true;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220685);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.id == null) {
                b bVar = new b("Not all required fields were included: id");
                AppMethodBeat.o(220685);
                throw bVar;
            }
            if (this.id != null) {
                aVar.e(1, this.id);
            }
            aVar.bb(2, this.timestamp);
            aVar.aM(3, this.type);
            aVar.cc(4, this.vtY);
            AppMethodBeat.o(220685);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.id != null ? g.a.a.b.b.a.f(1, this.id) + 0 : 0) + g.a.a.b.b.a.r(2, this.timestamp) + g.a.a.b.b.a.bu(3, this.type) + g.a.a.b.b.a.fS(4) + 1;
            AppMethodBeat.o(220685);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.id == null) {
                b bVar2 = new b("Not all required fields were included: id");
                AppMethodBeat.o(220685);
                throw bVar2;
            }
            AppMethodBeat.o(220685);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ade ade = (ade) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ade.id = aVar3.UbS.readString();
                    AppMethodBeat.o(220685);
                    return 0;
                case 2:
                    ade.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(220685);
                    return 0;
                case 3:
                    ade.type = aVar3.UbS.zi();
                    AppMethodBeat.o(220685);
                    return 0;
                case 4:
                    ade.vtY = aVar3.UbS.yZ();
                    AppMethodBeat.o(220685);
                    return 0;
                default:
                    AppMethodBeat.o(220685);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220685);
            return -1;
        }
    }
}
