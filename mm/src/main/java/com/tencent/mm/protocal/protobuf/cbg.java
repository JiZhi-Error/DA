package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cbg extends a {
    public String HIh;
    public String desc;
    public String ivw;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72498);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            if (this.ivw != null) {
                aVar.e(3, this.ivw);
            }
            if (this.HIh != null) {
                aVar.e(4, this.HIh);
            }
            AppMethodBeat.o(72498);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.desc);
            }
            if (this.ivw != null) {
                f2 += g.a.a.b.b.a.f(3, this.ivw);
            }
            if (this.HIh != null) {
                f2 += g.a.a.b.b.a.f(4, this.HIh);
            }
            AppMethodBeat.o(72498);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72498);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cbg cbg = (cbg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cbg.title = aVar3.UbS.readString();
                    AppMethodBeat.o(72498);
                    return 0;
                case 2:
                    cbg.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(72498);
                    return 0;
                case 3:
                    cbg.ivw = aVar3.UbS.readString();
                    AppMethodBeat.o(72498);
                    return 0;
                case 4:
                    cbg.HIh = aVar3.UbS.readString();
                    AppMethodBeat.o(72498);
                    return 0;
                default:
                    AppMethodBeat.o(72498);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72498);
            return -1;
        }
    }
}
