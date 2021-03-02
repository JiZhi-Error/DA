package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class ccj extends a {
    public String Md5;
    public String Name;
    public String Type;
    public String Url;
    public int oUq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32329);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Type != null) {
                aVar.e(1, this.Type);
            }
            aVar.aM(2, this.oUq);
            if (this.Md5 != null) {
                aVar.e(3, this.Md5);
            }
            if (this.Url != null) {
                aVar.e(4, this.Url);
            }
            if (this.Name != null) {
                aVar.e(5, this.Name);
            }
            AppMethodBeat.o(32329);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.Type != null ? g.a.a.b.b.a.f(1, this.Type) + 0 : 0) + g.a.a.b.b.a.bu(2, this.oUq);
            if (this.Md5 != null) {
                f2 += g.a.a.b.b.a.f(3, this.Md5);
            }
            if (this.Url != null) {
                f2 += g.a.a.b.b.a.f(4, this.Url);
            }
            if (this.Name != null) {
                f2 += g.a.a.b.b.a.f(5, this.Name);
            }
            AppMethodBeat.o(32329);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32329);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ccj ccj = (ccj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    ccj.Type = aVar3.UbS.readString();
                    AppMethodBeat.o(32329);
                    return 0;
                case 2:
                    ccj.oUq = aVar3.UbS.zi();
                    AppMethodBeat.o(32329);
                    return 0;
                case 3:
                    ccj.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(32329);
                    return 0;
                case 4:
                    ccj.Url = aVar3.UbS.readString();
                    AppMethodBeat.o(32329);
                    return 0;
                case 5:
                    ccj.Name = aVar3.UbS.readString();
                    AppMethodBeat.o(32329);
                    return 0;
                default:
                    AppMethodBeat.o(32329);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32329);
            return -1;
        }
    }
}
