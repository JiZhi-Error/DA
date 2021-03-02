package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class de extends a {
    public String IconUrl;
    public String Title;
    public String xIy;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41818);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.IconUrl != null) {
                aVar.e(1, this.IconUrl);
            }
            if (this.Title != null) {
                aVar.e(2, this.Title);
            }
            if (this.xIy != null) {
                aVar.e(3, this.xIy);
            }
            AppMethodBeat.o(41818);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.IconUrl != null ? g.a.a.b.b.a.f(1, this.IconUrl) + 0 : 0;
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.xIy != null) {
                f2 += g.a.a.b.b.a.f(3, this.xIy);
            }
            AppMethodBeat.o(41818);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41818);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            de deVar = (de) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    deVar.IconUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(41818);
                    return 0;
                case 2:
                    deVar.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(41818);
                    return 0;
                case 3:
                    deVar.xIy = aVar3.UbS.readString();
                    AppMethodBeat.o(41818);
                    return 0;
                default:
                    AppMethodBeat.o(41818);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41818);
            return -1;
        }
    }
}
