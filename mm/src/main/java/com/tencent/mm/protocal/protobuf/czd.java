package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class czd extends a {
    public String Desc;
    public String IconUrl;
    public String MEq;
    public String MEr;
    public String Title;
    public int xuX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117888);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MEq != null) {
                aVar.e(1, this.MEq);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.Desc != null) {
                aVar.e(3, this.Desc);
            }
            if (this.IconUrl != null) {
                aVar.e(4, this.IconUrl);
            }
            if (this.MEr != null) {
                aVar.e(5, this.MEr);
            }
            aVar.aM(6, this.xuX);
            AppMethodBeat.o(117888);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MEq != null ? g.a.a.b.b.a.f(1, this.MEq) + 0 : 0;
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(3, this.Desc);
            }
            if (this.IconUrl != null) {
                f2 += g.a.a.b.b.a.f(4, this.IconUrl);
            }
            if (this.MEr != null) {
                f2 += g.a.a.b.b.a.f(5, this.MEr);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.xuX);
            AppMethodBeat.o(117888);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117888);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            czd czd = (czd) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    czd.MEq = aVar3.UbS.readString();
                    AppMethodBeat.o(117888);
                    return 0;
                case 2:
                    czd.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(117888);
                    return 0;
                case 3:
                    czd.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(117888);
                    return 0;
                case 4:
                    czd.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(117888);
                    return 0;
                case 5:
                    czd.MEr = aVar3.UbS.readString();
                    AppMethodBeat.o(117888);
                    return 0;
                case 6:
                    czd.xuX = aVar3.UbS.zi();
                    AppMethodBeat.o(117888);
                    return 0;
                default:
                    AppMethodBeat.o(117888);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117888);
            return -1;
        }
    }
}
