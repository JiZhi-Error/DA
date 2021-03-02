package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class fgn extends a {
    public String ViT;
    public String ViX;
    public long begin_time;
    public long pWi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259346);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ViT != null) {
                aVar.e(1, this.ViT);
            }
            aVar.bb(2, this.begin_time);
            aVar.bb(3, this.pWi);
            if (this.ViX != null) {
                aVar.e(4, this.ViX);
            }
            AppMethodBeat.o(259346);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.ViT != null ? g.a.a.b.b.a.f(1, this.ViT) + 0 : 0) + g.a.a.b.b.a.r(2, this.begin_time) + g.a.a.b.b.a.r(3, this.pWi);
            if (this.ViX != null) {
                f2 += g.a.a.b.b.a.f(4, this.ViX);
            }
            AppMethodBeat.o(259346);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259346);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fgn fgn = (fgn) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    fgn.ViT = aVar3.UbS.readString();
                    AppMethodBeat.o(259346);
                    return 0;
                case 2:
                    fgn.begin_time = aVar3.UbS.zl();
                    AppMethodBeat.o(259346);
                    return 0;
                case 3:
                    fgn.pWi = aVar3.UbS.zl();
                    AppMethodBeat.o(259346);
                    return 0;
                case 4:
                    fgn.ViX = aVar3.UbS.readString();
                    AppMethodBeat.o(259346);
                    return 0;
                default:
                    AppMethodBeat.o(259346);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259346);
            return -1;
        }
    }
}
