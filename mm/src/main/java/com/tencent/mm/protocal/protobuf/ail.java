package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ail extends a {
    public String dbPath;
    public String sql;
    public String syg;
    public int syl;
    public String syr;
    public String syt;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(220695);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.syg != null) {
                aVar.e(1, this.syg);
            }
            aVar.aM(2, this.syl);
            if (this.sql != null) {
                aVar.e(3, this.sql);
            }
            if (this.dbPath != null) {
                aVar.e(4, this.dbPath);
            }
            if (this.syr != null) {
                aVar.e(5, this.syr);
            }
            if (this.syt != null) {
                aVar.e(6, this.syt);
            }
            AppMethodBeat.o(220695);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.syg != null ? g.a.a.b.b.a.f(1, this.syg) + 0 : 0) + g.a.a.b.b.a.bu(2, this.syl);
            if (this.sql != null) {
                f2 += g.a.a.b.b.a.f(3, this.sql);
            }
            if (this.dbPath != null) {
                f2 += g.a.a.b.b.a.f(4, this.dbPath);
            }
            if (this.syr != null) {
                f2 += g.a.a.b.b.a.f(5, this.syr);
            }
            if (this.syt != null) {
                f2 += g.a.a.b.b.a.f(6, this.syt);
            }
            AppMethodBeat.o(220695);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(220695);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ail ail = (ail) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ail.syg = aVar3.UbS.readString();
                    AppMethodBeat.o(220695);
                    return 0;
                case 2:
                    ail.syl = aVar3.UbS.zi();
                    AppMethodBeat.o(220695);
                    return 0;
                case 3:
                    ail.sql = aVar3.UbS.readString();
                    AppMethodBeat.o(220695);
                    return 0;
                case 4:
                    ail.dbPath = aVar3.UbS.readString();
                    AppMethodBeat.o(220695);
                    return 0;
                case 5:
                    ail.syr = aVar3.UbS.readString();
                    AppMethodBeat.o(220695);
                    return 0;
                case 6:
                    ail.syt = aVar3.UbS.readString();
                    AppMethodBeat.o(220695);
                    return 0;
                default:
                    AppMethodBeat.o(220695);
                    return -1;
            }
        } else {
            AppMethodBeat.o(220695);
            return -1;
        }
    }
}
