package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class tu extends a {
    public String appId;
    public int eix;
    public String md5;
    public String path;
    public int version;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(224537);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.appId != null) {
                aVar.e(1, this.appId);
            }
            if (this.path != null) {
                aVar.e(2, this.path);
            }
            aVar.aM(3, this.version);
            aVar.aM(4, this.eix);
            if (this.md5 != null) {
                aVar.e(5, this.md5);
            }
            AppMethodBeat.o(224537);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.appId != null ? g.a.a.b.b.a.f(1, this.appId) + 0 : 0;
            if (this.path != null) {
                f2 += g.a.a.b.b.a.f(2, this.path);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.version) + g.a.a.b.b.a.bu(4, this.eix);
            if (this.md5 != null) {
                bu += g.a.a.b.b.a.f(5, this.md5);
            }
            AppMethodBeat.o(224537);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(224537);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            tu tuVar = (tu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    tuVar.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(224537);
                    return 0;
                case 2:
                    tuVar.path = aVar3.UbS.readString();
                    AppMethodBeat.o(224537);
                    return 0;
                case 3:
                    tuVar.version = aVar3.UbS.zi();
                    AppMethodBeat.o(224537);
                    return 0;
                case 4:
                    tuVar.eix = aVar3.UbS.zi();
                    AppMethodBeat.o(224537);
                    return 0;
                case 5:
                    tuVar.md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(224537);
                    return 0;
                default:
                    AppMethodBeat.o(224537);
                    return -1;
            }
        } else {
            AppMethodBeat.o(224537);
            return -1;
        }
    }
}
