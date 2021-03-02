package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class bzp extends a {
    public String Desc;
    public String IconUrl;
    public String Mfj;
    public String Mfk;
    public String Title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152610);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mfj != null) {
                aVar.e(1, this.Mfj);
            }
            if (this.IconUrl != null) {
                aVar.e(2, this.IconUrl);
            }
            if (this.Title != null) {
                aVar.e(3, this.Title);
            }
            if (this.Desc != null) {
                aVar.e(4, this.Desc);
            }
            if (this.Mfk != null) {
                aVar.e(5, this.Mfk);
            }
            AppMethodBeat.o(152610);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.Mfj != null ? g.a.a.b.b.a.f(1, this.Mfj) + 0 : 0;
            if (this.IconUrl != null) {
                f2 += g.a.a.b.b.a.f(2, this.IconUrl);
            }
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(3, this.Title);
            }
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(4, this.Desc);
            }
            if (this.Mfk != null) {
                f2 += g.a.a.b.b.a.f(5, this.Mfk);
            }
            AppMethodBeat.o(152610);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152610);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bzp bzp = (bzp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bzp.Mfj = aVar3.UbS.readString();
                    AppMethodBeat.o(152610);
                    return 0;
                case 2:
                    bzp.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(152610);
                    return 0;
                case 3:
                    bzp.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(152610);
                    return 0;
                case 4:
                    bzp.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(152610);
                    return 0;
                case 5:
                    bzp.Mfk = aVar3.UbS.readString();
                    AppMethodBeat.o(152610);
                    return 0;
                default:
                    AppMethodBeat.o(152610);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152610);
            return -1;
        }
    }
}
