package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class ry extends a {
    public String KZp;
    public String KZq;
    public int KZr;
    public String KZs;
    public int KZt;
    public String Title;
    public String Url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117846);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title == null) {
                b bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(117846);
                throw bVar;
            } else if (this.Url == null) {
                b bVar2 = new b("Not all required fields were included: Url");
                AppMethodBeat.o(117846);
                throw bVar2;
            } else if (this.KZp == null) {
                b bVar3 = new b("Not all required fields were included: Position");
                AppMethodBeat.o(117846);
                throw bVar3;
            } else if (this.KZq == null) {
                b bVar4 = new b("Not all required fields were included: DetailInfo");
                AppMethodBeat.o(117846);
                throw bVar4;
            } else {
                if (this.Title != null) {
                    aVar.e(1, this.Title);
                }
                if (this.Url != null) {
                    aVar.e(2, this.Url);
                }
                if (this.KZp != null) {
                    aVar.e(3, this.KZp);
                }
                if (this.KZq != null) {
                    aVar.e(4, this.KZq);
                }
                aVar.aM(5, this.KZr);
                if (this.KZs != null) {
                    aVar.e(6, this.KZs);
                }
                aVar.aM(7, this.KZt);
                AppMethodBeat.o(117846);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.Url != null) {
                f2 += g.a.a.b.b.a.f(2, this.Url);
            }
            if (this.KZp != null) {
                f2 += g.a.a.b.b.a.f(3, this.KZp);
            }
            if (this.KZq != null) {
                f2 += g.a.a.b.b.a.f(4, this.KZq);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.KZr);
            if (this.KZs != null) {
                bu += g.a.a.b.b.a.f(6, this.KZs);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.KZt);
            AppMethodBeat.o(117846);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Title == null) {
                b bVar5 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(117846);
                throw bVar5;
            } else if (this.Url == null) {
                b bVar6 = new b("Not all required fields were included: Url");
                AppMethodBeat.o(117846);
                throw bVar6;
            } else if (this.KZp == null) {
                b bVar7 = new b("Not all required fields were included: Position");
                AppMethodBeat.o(117846);
                throw bVar7;
            } else if (this.KZq == null) {
                b bVar8 = new b("Not all required fields were included: DetailInfo");
                AppMethodBeat.o(117846);
                throw bVar8;
            } else {
                AppMethodBeat.o(117846);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ry ryVar = (ry) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ryVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(117846);
                    return 0;
                case 2:
                    ryVar.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(117846);
                    return 0;
                case 3:
                    ryVar.KZp = aVar3.UbS.readString();
                    AppMethodBeat.o(117846);
                    return 0;
                case 4:
                    ryVar.KZq = aVar3.UbS.readString();
                    AppMethodBeat.o(117846);
                    return 0;
                case 5:
                    ryVar.KZr = aVar3.UbS.zi();
                    AppMethodBeat.o(117846);
                    return 0;
                case 6:
                    ryVar.KZs = aVar3.UbS.readString();
                    AppMethodBeat.o(117846);
                    return 0;
                case 7:
                    ryVar.KZt = aVar3.UbS.zi();
                    AppMethodBeat.o(117846);
                    return 0;
                default:
                    AppMethodBeat.o(117846);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117846);
            return -1;
        }
    }
}
