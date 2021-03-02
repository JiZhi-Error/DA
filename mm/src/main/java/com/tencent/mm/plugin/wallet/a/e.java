package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class e extends a {
    public String HEm;
    public String name;
    public String url;
    public String weappPath;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91289);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.url != null) {
                aVar.e(1, this.url);
            }
            if (this.name != null) {
                aVar.e(2, this.name);
            }
            if (this.HEm != null) {
                aVar.e(3, this.HEm);
            }
            if (this.weappPath != null) {
                aVar.e(4, this.weappPath);
            }
            AppMethodBeat.o(91289);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.url != null ? g.a.a.b.b.a.f(1, this.url) + 0 : 0;
            if (this.name != null) {
                f2 += g.a.a.b.b.a.f(2, this.name);
            }
            if (this.HEm != null) {
                f2 += g.a.a.b.b.a.f(3, this.HEm);
            }
            if (this.weappPath != null) {
                f2 += g.a.a.b.b.a.f(4, this.weappPath);
            }
            AppMethodBeat.o(91289);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91289);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            e eVar = (e) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(91289);
                    return 0;
                case 2:
                    eVar.name = aVar3.UbS.readString();
                    AppMethodBeat.o(91289);
                    return 0;
                case 3:
                    eVar.HEm = aVar3.UbS.readString();
                    AppMethodBeat.o(91289);
                    return 0;
                case 4:
                    eVar.weappPath = aVar3.UbS.readString();
                    AppMethodBeat.o(91289);
                    return 0;
                default:
                    AppMethodBeat.o(91289);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91289);
            return -1;
        }
    }
}
