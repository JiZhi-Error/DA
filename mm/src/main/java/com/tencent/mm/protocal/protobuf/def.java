package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class def extends a {
    public String MJn;
    public int MJo;
    public String appId;
    public int packageType;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153295);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.appId != null) {
                aVar.e(1, this.appId);
            }
            if (this.MJn != null) {
                aVar.e(2, this.MJn);
            }
            aVar.aM(3, this.packageType);
            aVar.aM(4, this.MJo);
            AppMethodBeat.o(153295);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.appId != null ? g.a.a.b.b.a.f(1, this.appId) + 0 : 0;
            if (this.MJn != null) {
                f2 += g.a.a.b.b.a.f(2, this.MJn);
            }
            int bu = f2 + g.a.a.b.b.a.bu(3, this.packageType) + g.a.a.b.b.a.bu(4, this.MJo);
            AppMethodBeat.o(153295);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153295);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            def def = (def) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    def.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(153295);
                    return 0;
                case 2:
                    def.MJn = aVar3.UbS.readString();
                    AppMethodBeat.o(153295);
                    return 0;
                case 3:
                    def.packageType = aVar3.UbS.zi();
                    AppMethodBeat.o(153295);
                    return 0;
                case 4:
                    def.MJo = aVar3.UbS.zi();
                    AppMethodBeat.o(153295);
                    return 0;
                default:
                    AppMethodBeat.o(153295);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153295);
            return -1;
        }
    }
}
