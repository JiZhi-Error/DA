package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

/* renamed from: com.tencent.mm.plugin.game.protobuf.do  reason: invalid class name */
public final class Cdo extends a {
    public String Desc;
    public String Title;
    public String jfi;
    public String xIx;
    public String xIy;
    public String xJt;
    public String xMq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41829);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xMq == null) {
                b bVar = new b("Not all required fields were included: AppName");
                AppMethodBeat.o(41829);
                throw bVar;
            }
            if (this.xMq != null) {
                aVar.e(1, this.xMq);
            }
            if (this.xIx != null) {
                aVar.e(2, this.xIx);
            }
            if (this.Title != null) {
                aVar.e(3, this.Title);
            }
            if (this.Desc != null) {
                aVar.e(4, this.Desc);
            }
            if (this.xJt != null) {
                aVar.e(5, this.xJt);
            }
            if (this.xIy != null) {
                aVar.e(6, this.xIy);
            }
            if (this.jfi != null) {
                aVar.e(7, this.jfi);
            }
            AppMethodBeat.o(41829);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xMq != null ? g.a.a.b.b.a.f(1, this.xMq) + 0 : 0;
            if (this.xIx != null) {
                f2 += g.a.a.b.b.a.f(2, this.xIx);
            }
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(3, this.Title);
            }
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(4, this.Desc);
            }
            if (this.xJt != null) {
                f2 += g.a.a.b.b.a.f(5, this.xJt);
            }
            if (this.xIy != null) {
                f2 += g.a.a.b.b.a.f(6, this.xIy);
            }
            if (this.jfi != null) {
                f2 += g.a.a.b.b.a.f(7, this.jfi);
            }
            AppMethodBeat.o(41829);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xMq == null) {
                b bVar2 = new b("Not all required fields were included: AppName");
                AppMethodBeat.o(41829);
                throw bVar2;
            }
            AppMethodBeat.o(41829);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            Cdo doVar = (Cdo) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    doVar.xMq = aVar3.UbS.readString();
                    AppMethodBeat.o(41829);
                    return 0;
                case 2:
                    doVar.xIx = aVar3.UbS.readString();
                    AppMethodBeat.o(41829);
                    return 0;
                case 3:
                    doVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41829);
                    return 0;
                case 4:
                    doVar.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(41829);
                    return 0;
                case 5:
                    doVar.xJt = aVar3.UbS.readString();
                    AppMethodBeat.o(41829);
                    return 0;
                case 6:
                    doVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(41829);
                    return 0;
                case 7:
                    doVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(41829);
                    return 0;
                default:
                    AppMethodBeat.o(41829);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41829);
            return -1;
        }
    }
}
