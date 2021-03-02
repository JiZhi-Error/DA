package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bcf extends a {
    public LinkedList<String> LLt = new LinkedList<>();
    public LinkedList<String> LLu = new LinkedList<>();
    public String cardId;
    public String oqZ;
    public b tVe;
    public String title;

    public bcf() {
        AppMethodBeat.i(196091);
        AppMethodBeat.o(196091);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(196092);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.cardId != null) {
                aVar.e(1, this.cardId);
            }
            if (this.title != null) {
                aVar.e(2, this.title);
            }
            if (this.oqZ != null) {
                aVar.e(3, this.oqZ);
            }
            aVar.e(4, 1, this.LLt);
            aVar.e(5, 1, this.LLu);
            if (this.tVe != null) {
                aVar.c(6, this.tVe);
            }
            AppMethodBeat.o(196092);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.cardId != null ? g.a.a.b.b.a.f(1, this.cardId) + 0 : 0;
            if (this.title != null) {
                f2 += g.a.a.b.b.a.f(2, this.title);
            }
            if (this.oqZ != null) {
                f2 += g.a.a.b.b.a.f(3, this.oqZ);
            }
            int c2 = f2 + g.a.a.a.c(4, 1, this.LLt) + g.a.a.a.c(5, 1, this.LLu);
            if (this.tVe != null) {
                c2 += g.a.a.b.b.a.b(6, this.tVe);
            }
            AppMethodBeat.o(196092);
            return c2;
        } else if (i2 == 2) {
            this.LLt.clear();
            this.LLu.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(196092);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bcf bcf = (bcf) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bcf.cardId = aVar3.UbS.readString();
                    AppMethodBeat.o(196092);
                    return 0;
                case 2:
                    bcf.title = aVar3.UbS.readString();
                    AppMethodBeat.o(196092);
                    return 0;
                case 3:
                    bcf.oqZ = aVar3.UbS.readString();
                    AppMethodBeat.o(196092);
                    return 0;
                case 4:
                    bcf.LLt.add(aVar3.UbS.readString());
                    AppMethodBeat.o(196092);
                    return 0;
                case 5:
                    bcf.LLu.add(aVar3.UbS.readString());
                    AppMethodBeat.o(196092);
                    return 0;
                case 6:
                    bcf.tVe = aVar3.UbS.hPo();
                    AppMethodBeat.o(196092);
                    return 0;
                default:
                    AppMethodBeat.o(196092);
                    return -1;
            }
        } else {
            AppMethodBeat.o(196092);
            return -1;
        }
    }
}
