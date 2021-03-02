package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fbu extends a {
    public String MOt;
    public String NxU;
    public String dQx;
    public String pinyin;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152729);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MOt != null) {
                aVar.e(1, this.MOt);
            }
            if (this.dQx != null) {
                aVar.e(2, this.dQx);
            }
            if (this.pinyin != null) {
                aVar.e(3, this.pinyin);
            }
            if (this.NxU != null) {
                aVar.e(4, this.NxU);
            }
            AppMethodBeat.o(152729);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MOt != null ? g.a.a.b.b.a.f(1, this.MOt) + 0 : 0;
            if (this.dQx != null) {
                f2 += g.a.a.b.b.a.f(2, this.dQx);
            }
            if (this.pinyin != null) {
                f2 += g.a.a.b.b.a.f(3, this.pinyin);
            }
            if (this.NxU != null) {
                f2 += g.a.a.b.b.a.f(4, this.NxU);
            }
            AppMethodBeat.o(152729);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152729);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fbu fbu = (fbu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fbu.MOt = aVar3.UbS.readString();
                    AppMethodBeat.o(152729);
                    return 0;
                case 2:
                    fbu.dQx = aVar3.UbS.readString();
                    AppMethodBeat.o(152729);
                    return 0;
                case 3:
                    fbu.pinyin = aVar3.UbS.readString();
                    AppMethodBeat.o(152729);
                    return 0;
                case 4:
                    fbu.NxU = aVar3.UbS.readString();
                    AppMethodBeat.o(152729);
                    return 0;
                default:
                    AppMethodBeat.o(152729);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152729);
            return -1;
        }
    }
}
