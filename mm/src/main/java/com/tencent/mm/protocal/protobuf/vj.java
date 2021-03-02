package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public class vj extends a {
    public String Leo;
    public String Lep;
    public long LfD;
    public String LfE;
    public String LfF;
    public String pRY;
    public String pWf;
    public String qGB;
    public String title;
    public String url;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(113980);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.pRY != null) {
                aVar.e(2, this.pRY);
            }
            if (this.pWf != null) {
                aVar.e(3, this.pWf);
            }
            if (this.url != null) {
                aVar.e(4, this.url);
            }
            aVar.bb(5, this.LfD);
            if (this.LfE != null) {
                aVar.e(6, this.LfE);
            }
            if (this.LfF != null) {
                aVar.e(7, this.LfF);
            }
            if (this.qGB != null) {
                aVar.e(8, this.qGB);
            }
            if (this.Leo != null) {
                aVar.e(9, this.Leo);
            }
            if (this.Lep != null) {
                aVar.e(10, this.Lep);
            }
            AppMethodBeat.o(113980);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.pRY != null) {
                f2 += g.a.a.b.b.a.f(2, this.pRY);
            }
            if (this.pWf != null) {
                f2 += g.a.a.b.b.a.f(3, this.pWf);
            }
            if (this.url != null) {
                f2 += g.a.a.b.b.a.f(4, this.url);
            }
            int r = f2 + g.a.a.b.b.a.r(5, this.LfD);
            if (this.LfE != null) {
                r += g.a.a.b.b.a.f(6, this.LfE);
            }
            if (this.LfF != null) {
                r += g.a.a.b.b.a.f(7, this.LfF);
            }
            if (this.qGB != null) {
                r += g.a.a.b.b.a.f(8, this.qGB);
            }
            if (this.Leo != null) {
                r += g.a.a.b.b.a.f(9, this.Leo);
            }
            if (this.Lep != null) {
                r += g.a.a.b.b.a.f(10, this.Lep);
            }
            AppMethodBeat.o(113980);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(113980);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            vj vjVar = (vj) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    vjVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(113980);
                    return 0;
                case 2:
                    vjVar.pRY = aVar3.UbS.readString();
                    AppMethodBeat.o(113980);
                    return 0;
                case 3:
                    vjVar.pWf = aVar3.UbS.readString();
                    AppMethodBeat.o(113980);
                    return 0;
                case 4:
                    vjVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(113980);
                    return 0;
                case 5:
                    vjVar.LfD = aVar3.UbS.zl();
                    AppMethodBeat.o(113980);
                    return 0;
                case 6:
                    vjVar.LfE = aVar3.UbS.readString();
                    AppMethodBeat.o(113980);
                    return 0;
                case 7:
                    vjVar.LfF = aVar3.UbS.readString();
                    AppMethodBeat.o(113980);
                    return 0;
                case 8:
                    vjVar.qGB = aVar3.UbS.readString();
                    AppMethodBeat.o(113980);
                    return 0;
                case 9:
                    vjVar.Leo = aVar3.UbS.readString();
                    AppMethodBeat.o(113980);
                    return 0;
                case 10:
                    vjVar.Lep = aVar3.UbS.readString();
                    AppMethodBeat.o(113980);
                    return 0;
                default:
                    AppMethodBeat.o(113980);
                    return -1;
            }
        } else {
            AppMethodBeat.o(113980);
            return -1;
        }
    }
}
