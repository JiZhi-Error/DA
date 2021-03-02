package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class bgg extends a {
    public String KHk;
    public int KWb;
    public String LPS;
    public String LPZ;
    public String hik;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(42637);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.hik == null) {
                b bVar = new b("Not all required fields were included: AppID");
                AppMethodBeat.o(42637);
                throw bVar;
            } else if (this.LPZ == null) {
                b bVar2 = new b("Not all required fields were included: RecommendKey");
                AppMethodBeat.o(42637);
                throw bVar2;
            } else {
                if (this.hik != null) {
                    aVar.e(1, this.hik);
                }
                if (this.LPZ != null) {
                    aVar.e(2, this.LPZ);
                }
                if (this.KHk != null) {
                    aVar.e(3, this.KHk);
                }
                aVar.aM(4, this.KWb);
                if (this.LPS != null) {
                    aVar.e(5, this.LPS);
                }
                AppMethodBeat.o(42637);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.hik != null ? g.a.a.b.b.a.f(1, this.hik) + 0 : 0;
            if (this.LPZ != null) {
                f2 += g.a.a.b.b.a.f(2, this.LPZ);
            }
            if (this.KHk != null) {
                f2 += g.a.a.b.b.a.f(3, this.KHk);
            }
            int bu = f2 + g.a.a.b.b.a.bu(4, this.KWb);
            if (this.LPS != null) {
                bu += g.a.a.b.b.a.f(5, this.LPS);
            }
            AppMethodBeat.o(42637);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.hik == null) {
                b bVar3 = new b("Not all required fields were included: AppID");
                AppMethodBeat.o(42637);
                throw bVar3;
            } else if (this.LPZ == null) {
                b bVar4 = new b("Not all required fields were included: RecommendKey");
                AppMethodBeat.o(42637);
                throw bVar4;
            } else {
                AppMethodBeat.o(42637);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bgg bgg = (bgg) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bgg.hik = aVar3.UbS.readString();
                    AppMethodBeat.o(42637);
                    return 0;
                case 2:
                    bgg.LPZ = aVar3.UbS.readString();
                    AppMethodBeat.o(42637);
                    return 0;
                case 3:
                    bgg.KHk = aVar3.UbS.readString();
                    AppMethodBeat.o(42637);
                    return 0;
                case 4:
                    bgg.KWb = aVar3.UbS.zi();
                    AppMethodBeat.o(42637);
                    return 0;
                case 5:
                    bgg.LPS = aVar3.UbS.readString();
                    AppMethodBeat.o(42637);
                    return 0;
                default:
                    AppMethodBeat.o(42637);
                    return -1;
            }
        } else {
            AppMethodBeat.o(42637);
            return -1;
        }
    }
}
