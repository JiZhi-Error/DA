package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class abr extends a {
    public String appId;
    public String appName;
    public String version;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(117856);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.appId != null) {
                aVar.e(1, this.appId);
            }
            if (this.appName != null) {
                aVar.e(2, this.appName);
            }
            if (this.version != null) {
                aVar.e(3, this.version);
            }
            AppMethodBeat.o(117856);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.appId != null ? g.a.a.b.b.a.f(1, this.appId) + 0 : 0;
            if (this.appName != null) {
                f2 += g.a.a.b.b.a.f(2, this.appName);
            }
            if (this.version != null) {
                f2 += g.a.a.b.b.a.f(3, this.version);
            }
            AppMethodBeat.o(117856);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(117856);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            abr abr = (abr) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    abr.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(117856);
                    return 0;
                case 2:
                    abr.appName = aVar3.UbS.readString();
                    AppMethodBeat.o(117856);
                    return 0;
                case 3:
                    abr.version = aVar3.UbS.readString();
                    AppMethodBeat.o(117856);
                    return 0;
                default:
                    AppMethodBeat.o(117856);
                    return -1;
            }
        } else {
            AppMethodBeat.o(117856);
            return -1;
        }
    }
}
