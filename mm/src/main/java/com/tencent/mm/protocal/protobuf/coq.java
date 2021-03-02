package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class coq extends a {
    public int KWb;
    public String LPS;
    public int MuO;
    public int MuP;
    public String ThumbUrl;
    public String Title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(89663);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title == null) {
                b bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(89663);
                throw bVar;
            } else if (this.ThumbUrl == null) {
                b bVar2 = new b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.o(89663);
                throw bVar2;
            } else {
                aVar.aM(1, this.MuO);
                if (this.Title != null) {
                    aVar.e(2, this.Title);
                }
                if (this.ThumbUrl != null) {
                    aVar.e(3, this.ThumbUrl);
                }
                aVar.aM(4, this.KWb);
                if (this.LPS != null) {
                    aVar.e(5, this.LPS);
                }
                aVar.aM(6, this.MuP);
                AppMethodBeat.o(89663);
                return 0;
            }
        } else if (i2 == 1) {
            int bu = g.a.a.b.b.a.bu(1, this.MuO) + 0;
            if (this.Title != null) {
                bu += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.ThumbUrl != null) {
                bu += g.a.a.b.b.a.f(3, this.ThumbUrl);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(4, this.KWb);
            if (this.LPS != null) {
                bu2 += g.a.a.b.b.a.f(5, this.LPS);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(6, this.MuP);
            AppMethodBeat.o(89663);
            return bu3;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Title == null) {
                b bVar3 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(89663);
                throw bVar3;
            } else if (this.ThumbUrl == null) {
                b bVar4 = new b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.o(89663);
                throw bVar4;
            } else {
                AppMethodBeat.o(89663);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            coq coq = (coq) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    coq.MuO = aVar3.UbS.zi();
                    AppMethodBeat.o(89663);
                    return 0;
                case 2:
                    coq.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(89663);
                    return 0;
                case 3:
                    coq.ThumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(89663);
                    return 0;
                case 4:
                    coq.KWb = aVar3.UbS.zi();
                    AppMethodBeat.o(89663);
                    return 0;
                case 5:
                    coq.LPS = aVar3.UbS.readString();
                    AppMethodBeat.o(89663);
                    return 0;
                case 6:
                    coq.MuP = aVar3.UbS.zi();
                    AppMethodBeat.o(89663);
                    return 0;
                default:
                    AppMethodBeat.o(89663);
                    return -1;
            }
        } else {
            AppMethodBeat.o(89663);
            return -1;
        }
    }
}
