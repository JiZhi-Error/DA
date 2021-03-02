package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class brq extends a {
    public LinkedList<String> LYT = new LinkedList<>();
    public String app_id;
    public String language;

    public brq() {
        AppMethodBeat.i(152582);
        AppMethodBeat.o(152582);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152583);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.language != null) {
                aVar.e(1, this.language);
            }
            if (this.app_id != null) {
                aVar.e(2, this.app_id);
            }
            aVar.e(3, 1, this.LYT);
            AppMethodBeat.o(152583);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.language != null ? g.a.a.b.b.a.f(1, this.language) + 0 : 0;
            if (this.app_id != null) {
                f2 += g.a.a.b.b.a.f(2, this.app_id);
            }
            int c2 = f2 + g.a.a.a.c(3, 1, this.LYT);
            AppMethodBeat.o(152583);
            return c2;
        } else if (i2 == 2) {
            this.LYT.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152583);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            brq brq = (brq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    brq.language = aVar3.UbS.readString();
                    AppMethodBeat.o(152583);
                    return 0;
                case 2:
                    brq.app_id = aVar3.UbS.readString();
                    AppMethodBeat.o(152583);
                    return 0;
                case 3:
                    brq.LYT.add(aVar3.UbS.readString());
                    AppMethodBeat.o(152583);
                    return 0;
                default:
                    AppMethodBeat.o(152583);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152583);
            return -1;
        }
    }
}
