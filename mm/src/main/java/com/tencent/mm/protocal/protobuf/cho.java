package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class cho extends a {
    public String LRO;
    public String Lir;
    public String Lis;
    public String UserName;
    public String oUJ;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(138178);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.UserName != null) {
                aVar.e(1, this.UserName);
            }
            if (this.oUJ != null) {
                aVar.e(2, this.oUJ);
            }
            if (this.Lir != null) {
                aVar.e(3, this.Lir);
            }
            if (this.Lis != null) {
                aVar.e(4, this.Lis);
            }
            if (this.LRO != null) {
                aVar.e(5, this.LRO);
            }
            AppMethodBeat.o(138178);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.UserName != null ? g.a.a.b.b.a.f(1, this.UserName) + 0 : 0;
            if (this.oUJ != null) {
                f2 += g.a.a.b.b.a.f(2, this.oUJ);
            }
            if (this.Lir != null) {
                f2 += g.a.a.b.b.a.f(3, this.Lir);
            }
            if (this.Lis != null) {
                f2 += g.a.a.b.b.a.f(4, this.Lis);
            }
            if (this.LRO != null) {
                f2 += g.a.a.b.b.a.f(5, this.LRO);
            }
            AppMethodBeat.o(138178);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(138178);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cho cho = (cho) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    cho.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(138178);
                    return 0;
                case 2:
                    cho.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(138178);
                    return 0;
                case 3:
                    cho.Lir = aVar3.UbS.readString();
                    AppMethodBeat.o(138178);
                    return 0;
                case 4:
                    cho.Lis = aVar3.UbS.readString();
                    AppMethodBeat.o(138178);
                    return 0;
                case 5:
                    cho.LRO = aVar3.UbS.readString();
                    AppMethodBeat.o(138178);
                    return 0;
                default:
                    AppMethodBeat.o(138178);
                    return -1;
            }
        } else {
            AppMethodBeat.o(138178);
            return -1;
        }
    }
}
