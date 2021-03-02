package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fhh extends a {
    public boolean Vjs;
    public String Vjt;
    public boolean Vju;
    public boolean Vjv;
    public String dNI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259367);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.dNI != null) {
                aVar.e(1, this.dNI);
            }
            aVar.cc(2, this.Vjs);
            if (this.Vjt != null) {
                aVar.e(3, this.Vjt);
            }
            aVar.cc(4, this.Vju);
            aVar.cc(5, this.Vjv);
            AppMethodBeat.o(259367);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.dNI != null ? g.a.a.b.b.a.f(1, this.dNI) + 0 : 0) + g.a.a.b.b.a.fS(2) + 1;
            if (this.Vjt != null) {
                f2 += g.a.a.b.b.a.f(3, this.Vjt);
            }
            int fS = f2 + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1;
            AppMethodBeat.o(259367);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259367);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fhh fhh = (fhh) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fhh.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(259367);
                    return 0;
                case 2:
                    fhh.Vjs = aVar3.UbS.yZ();
                    AppMethodBeat.o(259367);
                    return 0;
                case 3:
                    fhh.Vjt = aVar3.UbS.readString();
                    AppMethodBeat.o(259367);
                    return 0;
                case 4:
                    fhh.Vju = aVar3.UbS.yZ();
                    AppMethodBeat.o(259367);
                    return 0;
                case 5:
                    fhh.Vjv = aVar3.UbS.yZ();
                    AppMethodBeat.o(259367);
                    return 0;
                default:
                    AppMethodBeat.o(259367);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259367);
            return -1;
        }
    }
}
