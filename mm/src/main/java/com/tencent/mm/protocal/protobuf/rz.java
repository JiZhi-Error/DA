package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class rz extends a {
    public String APy;
    public String KZu;
    public String KZv;
    public String KZw;
    public int KZx;
    public String KZy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117847);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.KZu == null) {
                b bVar = new b("Not all required fields were included: ProductId");
                AppMethodBeat.o(117847);
                throw bVar;
            } else if (this.APy == null) {
                b bVar2 = new b("Not all required fields were included: ProductName");
                AppMethodBeat.o(117847);
                throw bVar2;
            } else if (this.KZv == null) {
                b bVar3 = new b("Not all required fields were included: SellerName");
                AppMethodBeat.o(117847);
                throw bVar3;
            } else if (this.KZw == null) {
                b bVar4 = new b("Not all required fields were included: SellerUserName");
                AppMethodBeat.o(117847);
                throw bVar4;
            } else {
                if (this.KZu != null) {
                    aVar.e(1, this.KZu);
                }
                if (this.APy != null) {
                    aVar.e(2, this.APy);
                }
                if (this.KZv != null) {
                    aVar.e(3, this.KZv);
                }
                if (this.KZw != null) {
                    aVar.e(4, this.KZw);
                }
                aVar.aM(5, this.KZx);
                if (this.KZy != null) {
                    aVar.e(6, this.KZy);
                }
                AppMethodBeat.o(117847);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.KZu != null ? g.a.a.b.b.a.f(1, this.KZu) + 0 : 0;
            if (this.APy != null) {
                f2 += g.a.a.b.b.a.f(2, this.APy);
            }
            if (this.KZv != null) {
                f2 += g.a.a.b.b.a.f(3, this.KZv);
            }
            if (this.KZw != null) {
                f2 += g.a.a.b.b.a.f(4, this.KZw);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.KZx);
            if (this.KZy != null) {
                bu += g.a.a.b.b.a.f(6, this.KZy);
            }
            AppMethodBeat.o(117847);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KZu == null) {
                b bVar5 = new b("Not all required fields were included: ProductId");
                AppMethodBeat.o(117847);
                throw bVar5;
            } else if (this.APy == null) {
                b bVar6 = new b("Not all required fields were included: ProductName");
                AppMethodBeat.o(117847);
                throw bVar6;
            } else if (this.KZv == null) {
                b bVar7 = new b("Not all required fields were included: SellerName");
                AppMethodBeat.o(117847);
                throw bVar7;
            } else if (this.KZw == null) {
                b bVar8 = new b("Not all required fields were included: SellerUserName");
                AppMethodBeat.o(117847);
                throw bVar8;
            } else {
                AppMethodBeat.o(117847);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            rz rzVar = (rz) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    rzVar.KZu = aVar3.UbS.readString();
                    AppMethodBeat.o(117847);
                    return 0;
                case 2:
                    rzVar.APy = aVar3.UbS.readString();
                    AppMethodBeat.o(117847);
                    return 0;
                case 3:
                    rzVar.KZv = aVar3.UbS.readString();
                    AppMethodBeat.o(117847);
                    return 0;
                case 4:
                    rzVar.KZw = aVar3.UbS.readString();
                    AppMethodBeat.o(117847);
                    return 0;
                case 5:
                    rzVar.KZx = aVar3.UbS.zi();
                    AppMethodBeat.o(117847);
                    return 0;
                case 6:
                    rzVar.KZy = aVar3.UbS.readString();
                    AppMethodBeat.o(117847);
                    return 0;
                default:
                    AppMethodBeat.o(117847);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117847);
            return -1;
        }
    }
}
