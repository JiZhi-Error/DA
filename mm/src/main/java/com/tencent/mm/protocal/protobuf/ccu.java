package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ccu extends a {
    public String AZx;
    public String LSm;
    public String MiH;
    public String MiI;
    public String MiJ;
    public String MiK;
    public String price;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72507);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.AZx == null) {
                b bVar = new b("Not all required fields were included: product_id");
                AppMethodBeat.o(72507);
                throw bVar;
            } else if (this.price == null) {
                b bVar2 = new b("Not all required fields were included: price");
                AppMethodBeat.o(72507);
                throw bVar2;
            } else if (this.LSm == null) {
                b bVar3 = new b("Not all required fields were included: currency_type");
                AppMethodBeat.o(72507);
                throw bVar3;
            } else if (this.MiH == null) {
                b bVar4 = new b("Not all required fields were included: session_data");
                AppMethodBeat.o(72507);
                throw bVar4;
            } else {
                if (this.AZx != null) {
                    aVar.e(1, this.AZx);
                }
                if (this.price != null) {
                    aVar.e(2, this.price);
                }
                if (this.LSm != null) {
                    aVar.e(3, this.LSm);
                }
                if (this.MiH != null) {
                    aVar.e(4, this.MiH);
                }
                if (this.MiI != null) {
                    aVar.e(5, this.MiI);
                }
                if (this.MiJ != null) {
                    aVar.e(6, this.MiJ);
                }
                if (this.MiK != null) {
                    aVar.e(7, this.MiK);
                }
                AppMethodBeat.o(72507);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.AZx != null ? g.a.a.b.b.a.f(1, this.AZx) + 0 : 0;
            if (this.price != null) {
                f2 += g.a.a.b.b.a.f(2, this.price);
            }
            if (this.LSm != null) {
                f2 += g.a.a.b.b.a.f(3, this.LSm);
            }
            if (this.MiH != null) {
                f2 += g.a.a.b.b.a.f(4, this.MiH);
            }
            if (this.MiI != null) {
                f2 += g.a.a.b.b.a.f(5, this.MiI);
            }
            if (this.MiJ != null) {
                f2 += g.a.a.b.b.a.f(6, this.MiJ);
            }
            if (this.MiK != null) {
                f2 += g.a.a.b.b.a.f(7, this.MiK);
            }
            AppMethodBeat.o(72507);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.AZx == null) {
                b bVar5 = new b("Not all required fields were included: product_id");
                AppMethodBeat.o(72507);
                throw bVar5;
            } else if (this.price == null) {
                b bVar6 = new b("Not all required fields were included: price");
                AppMethodBeat.o(72507);
                throw bVar6;
            } else if (this.LSm == null) {
                b bVar7 = new b("Not all required fields were included: currency_type");
                AppMethodBeat.o(72507);
                throw bVar7;
            } else if (this.MiH == null) {
                b bVar8 = new b("Not all required fields were included: session_data");
                AppMethodBeat.o(72507);
                throw bVar8;
            } else {
                AppMethodBeat.o(72507);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ccu ccu = (ccu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccu.AZx = aVar3.UbS.readString();
                    AppMethodBeat.o(72507);
                    return 0;
                case 2:
                    ccu.price = aVar3.UbS.readString();
                    AppMethodBeat.o(72507);
                    return 0;
                case 3:
                    ccu.LSm = aVar3.UbS.readString();
                    AppMethodBeat.o(72507);
                    return 0;
                case 4:
                    ccu.MiH = aVar3.UbS.readString();
                    AppMethodBeat.o(72507);
                    return 0;
                case 5:
                    ccu.MiI = aVar3.UbS.readString();
                    AppMethodBeat.o(72507);
                    return 0;
                case 6:
                    ccu.MiJ = aVar3.UbS.readString();
                    AppMethodBeat.o(72507);
                    return 0;
                case 7:
                    ccu.MiK = aVar3.UbS.readString();
                    AppMethodBeat.o(72507);
                    return 0;
                default:
                    AppMethodBeat.o(72507);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72507);
            return -1;
        }
    }
}
