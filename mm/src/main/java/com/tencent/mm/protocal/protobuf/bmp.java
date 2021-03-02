package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class bmp extends a {
    public String LVq;
    public String Md5;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(104789);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LVq == null) {
                b bVar = new b("Not all required fields were included: ActivityId");
                AppMethodBeat.o(104789);
                throw bVar;
            }
            if (this.LVq != null) {
                aVar.e(1, this.LVq);
            }
            if (this.Md5 != null) {
                aVar.e(2, this.Md5);
            }
            AppMethodBeat.o(104789);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.LVq != null ? g.a.a.b.b.a.f(1, this.LVq) + 0 : 0;
            if (this.Md5 != null) {
                f2 += g.a.a.b.b.a.f(2, this.Md5);
            }
            AppMethodBeat.o(104789);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.LVq == null) {
                b bVar2 = new b("Not all required fields were included: ActivityId");
                AppMethodBeat.o(104789);
                throw bVar2;
            }
            AppMethodBeat.o(104789);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bmp bmp = (bmp) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    bmp.LVq = aVar3.UbS.readString();
                    AppMethodBeat.o(104789);
                    return 0;
                case 2:
                    bmp.Md5 = aVar3.UbS.readString();
                    AppMethodBeat.o(104789);
                    return 0;
                default:
                    AppMethodBeat.o(104789);
                    return -1;
            }
        } else {
            AppMethodBeat.o(104789);
            return -1;
        }
    }
}
