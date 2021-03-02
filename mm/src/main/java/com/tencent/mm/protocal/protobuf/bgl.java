package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class bgl extends a {
    public String Desc;
    public int Gaz;
    public String LPS;
    public int LQm;
    public int LQn;
    public String ThumbUrl;
    public String Title;
    public String jfi;
    public String xMq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(42646);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Title == null) {
                b bVar = new b("Not all required fields were included: Title");
                AppMethodBeat.o(42646);
                throw bVar;
            } else if (this.Desc == null) {
                b bVar2 = new b("Not all required fields were included: Desc");
                AppMethodBeat.o(42646);
                throw bVar2;
            } else if (this.ThumbUrl == null) {
                b bVar3 = new b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.o(42646);
                throw bVar3;
            } else {
                if (this.Title != null) {
                    aVar.e(1, this.Title);
                }
                if (this.Desc != null) {
                    aVar.e(2, this.Desc);
                }
                if (this.ThumbUrl != null) {
                    aVar.e(3, this.ThumbUrl);
                }
                if (this.LPS != null) {
                    aVar.e(4, this.LPS);
                }
                aVar.aM(5, this.LQm);
                aVar.aM(6, this.LQn);
                if (this.jfi != null) {
                    aVar.e(7, this.jfi);
                }
                aVar.aM(8, this.Gaz);
                if (this.xMq != null) {
                    aVar.e(9, this.xMq);
                }
                AppMethodBeat.o(42646);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.Title != null ? g.a.a.b.b.a.f(1, this.Title) + 0 : 0;
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.Desc);
            }
            if (this.ThumbUrl != null) {
                f2 += g.a.a.b.b.a.f(3, this.ThumbUrl);
            }
            if (this.LPS != null) {
                f2 += g.a.a.b.b.a.f(4, this.LPS);
            }
            int bu = f2 + g.a.a.b.b.a.bu(5, this.LQm) + g.a.a.b.b.a.bu(6, this.LQn);
            if (this.jfi != null) {
                bu += g.a.a.b.b.a.f(7, this.jfi);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(8, this.Gaz);
            if (this.xMq != null) {
                bu2 += g.a.a.b.b.a.f(9, this.xMq);
            }
            AppMethodBeat.o(42646);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Title == null) {
                b bVar4 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(42646);
                throw bVar4;
            } else if (this.Desc == null) {
                b bVar5 = new b("Not all required fields were included: Desc");
                AppMethodBeat.o(42646);
                throw bVar5;
            } else if (this.ThumbUrl == null) {
                b bVar6 = new b("Not all required fields were included: ThumbUrl");
                AppMethodBeat.o(42646);
                throw bVar6;
            } else {
                AppMethodBeat.o(42646);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bgl bgl = (bgl) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bgl.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(42646);
                    return 0;
                case 2:
                    bgl.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(42646);
                    return 0;
                case 3:
                    bgl.ThumbUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(42646);
                    return 0;
                case 4:
                    bgl.LPS = aVar3.UbS.readString();
                    AppMethodBeat.o(42646);
                    return 0;
                case 5:
                    bgl.LQm = aVar3.UbS.zi();
                    AppMethodBeat.o(42646);
                    return 0;
                case 6:
                    bgl.LQn = aVar3.UbS.zi();
                    AppMethodBeat.o(42646);
                    return 0;
                case 7:
                    bgl.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(42646);
                    return 0;
                case 8:
                    bgl.Gaz = aVar3.UbS.zi();
                    AppMethodBeat.o(42646);
                    return 0;
                case 9:
                    bgl.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(42646);
                    return 0;
                default:
                    AppMethodBeat.o(42646);
                    return -1;
            }
        } else {
            AppMethodBeat.o(42646);
            return -1;
        }
    }
}
