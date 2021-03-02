package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class djb extends a {
    public String LRO;
    public String LuX;
    public int MNf;
    public String SmallImgUrl;
    public String UserName;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(127295);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            aVar.aM(2, this.MNf);
            if (this.oUJ != null) {
                aVar.e(3, this.oUJ);
            }
            if (this.SmallImgUrl != null) {
                aVar.e(4, this.SmallImgUrl);
            }
            if (this.LuX != null) {
                aVar.e(5, this.LuX);
            }
            if (this.LRO != null) {
                aVar.e(6, this.LRO);
            }
            AppMethodBeat.o(127295);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MNf);
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(3, this.oUJ);
            }
            if (this.SmallImgUrl != null) {
                f2 += g.a.a.b.b.a.f(4, this.SmallImgUrl);
            }
            if (this.LuX != null) {
                f2 += g.a.a.b.b.a.f(5, this.LuX);
            }
            if (this.LRO != null) {
                f2 += g.a.a.b.b.a.f(6, this.LRO);
            }
            AppMethodBeat.o(127295);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(127295);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            djb djb = (djb) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    djb.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(127295);
                    return 0;
                case 2:
                    djb.MNf = aVar3.UbS.zi();
                    AppMethodBeat.o(127295);
                    return 0;
                case 3:
                    djb.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(127295);
                    return 0;
                case 4:
                    djb.SmallImgUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(127295);
                    return 0;
                case 5:
                    djb.LuX = aVar3.UbS.readString();
                    AppMethodBeat.o(127295);
                    return 0;
                case 6:
                    djb.LRO = aVar3.UbS.readString();
                    AppMethodBeat.o(127295);
                    return 0;
                default:
                    AppMethodBeat.o(127295);
                    return -1;
            }
        } else {
            AppMethodBeat.o(127295);
            return -1;
        }
    }
}
