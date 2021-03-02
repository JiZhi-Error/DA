package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ay extends a {
    public String Desc;
    public String Title;
    public String jfi;
    public String xIy;
    public String xKV;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41745);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xKV != null) {
                aVar.e(1, this.xKV);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.Desc != null) {
                aVar.e(3, this.Desc);
            }
            if (this.xIy != null) {
                aVar.e(4, this.xIy);
            }
            if (this.jfi != null) {
                aVar.e(5, this.jfi);
            }
            AppMethodBeat.o(41745);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.xKV != null ? g.a.a.b.b.a.f(1, this.xKV) + 0 : 0;
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.Desc != null) {
                f2 += g.a.a.b.b.a.f(3, this.Desc);
            }
            if (this.xIy != null) {
                f2 += g.a.a.b.b.a.f(4, this.xIy);
            }
            if (this.jfi != null) {
                f2 += g.a.a.b.b.a.f(5, this.jfi);
            }
            AppMethodBeat.o(41745);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41745);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ay ayVar = (ay) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ayVar.xKV = aVar3.UbS.readString();
                    AppMethodBeat.o(41745);
                    return 0;
                case 2:
                    ayVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41745);
                    return 0;
                case 3:
                    ayVar.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(41745);
                    return 0;
                case 4:
                    ayVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(41745);
                    return 0;
                case 5:
                    ayVar.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(41745);
                    return 0;
                default:
                    AppMethodBeat.o(41745);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41745);
            return -1;
        }
    }
}
