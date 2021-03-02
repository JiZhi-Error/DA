package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;

public final class eyu extends a {
    public long KMm;
    public String MRZ;
    public String Title;
    public String iAc;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32533);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MRZ == null) {
                b bVar = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(32533);
                throw bVar;
            } else if (this.Title == null) {
                b bVar2 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(32533);
                throw bVar2;
            } else if (this.iAc == null) {
                b bVar3 = new b("Not all required fields were included: Content");
                AppMethodBeat.o(32533);
                throw bVar3;
            } else {
                if (this.MRZ != null) {
                    aVar.e(1, this.MRZ);
                }
                if (this.Title != null) {
                    aVar.e(2, this.Title);
                }
                if (this.iAc != null) {
                    aVar.e(3, this.iAc);
                }
                aVar.bb(4, this.KMm);
                AppMethodBeat.o(32533);
                return 0;
            }
        } else if (i2 == 1) {
            int f2 = this.MRZ != null ? g.a.a.b.b.a.f(1, this.MRZ) + 0 : 0;
            if (this.Title != null) {
                f2 += g.a.a.b.b.a.f(2, this.Title);
            }
            if (this.iAc != null) {
                f2 += g.a.a.b.b.a.f(3, this.iAc);
            }
            int r = f2 + g.a.a.b.b.a.r(4, this.KMm);
            AppMethodBeat.o(32533);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MRZ == null) {
                b bVar4 = new b("Not all required fields were included: Talker");
                AppMethodBeat.o(32533);
                throw bVar4;
            } else if (this.Title == null) {
                b bVar5 = new b("Not all required fields were included: Title");
                AppMethodBeat.o(32533);
                throw bVar5;
            } else if (this.iAc == null) {
                b bVar6 = new b("Not all required fields were included: Content");
                AppMethodBeat.o(32533);
                throw bVar6;
            } else {
                AppMethodBeat.o(32533);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eyu eyu = (eyu) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    eyu.MRZ = aVar3.UbS.readString();
                    AppMethodBeat.o(32533);
                    return 0;
                case 2:
                    eyu.Title = aVar3.UbS.readString();
                    AppMethodBeat.o(32533);
                    return 0;
                case 3:
                    eyu.iAc = aVar3.UbS.readString();
                    AppMethodBeat.o(32533);
                    return 0;
                case 4:
                    eyu.KMm = aVar3.UbS.zl();
                    AppMethodBeat.o(32533);
                    return 0;
                default:
                    AppMethodBeat.o(32533);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32533);
            return -1;
        }
    }
}
