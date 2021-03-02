package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class anr extends a {
    public String Coh;
    public LinkedList<ans> KXX = new LinkedList<>();
    public String Lhy;
    public String LyJ;
    public long LyK;
    public long LyL;
    public String LyM;
    public long LyN;

    public anr() {
        AppMethodBeat.i(91458);
        AppMethodBeat.o(91458);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(91459);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.LyJ != null) {
                aVar.e(1, this.LyJ);
            }
            aVar.e(2, 8, this.KXX);
            aVar.bb(3, this.LyK);
            aVar.bb(4, this.LyL);
            if (this.LyM != null) {
                aVar.e(5, this.LyM);
            }
            if (this.Coh != null) {
                aVar.e(6, this.Coh);
            }
            aVar.bb(7, this.LyN);
            if (this.Lhy != null) {
                aVar.e(8, this.Lhy);
            }
            AppMethodBeat.o(91459);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.LyJ != null ? g.a.a.b.b.a.f(1, this.LyJ) + 0 : 0) + g.a.a.a.c(2, 8, this.KXX) + g.a.a.b.b.a.r(3, this.LyK) + g.a.a.b.b.a.r(4, this.LyL);
            if (this.LyM != null) {
                f2 += g.a.a.b.b.a.f(5, this.LyM);
            }
            if (this.Coh != null) {
                f2 += g.a.a.b.b.a.f(6, this.Coh);
            }
            int r = f2 + g.a.a.b.b.a.r(7, this.LyN);
            if (this.Lhy != null) {
                r += g.a.a.b.b.a.f(8, this.Lhy);
            }
            AppMethodBeat.o(91459);
            return r;
        } else if (i2 == 2) {
            this.KXX.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(91459);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            anr anr = (anr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    anr.LyJ = aVar3.UbS.readString();
                    AppMethodBeat.o(91459);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ans ans = new ans();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ans.populateBuilderWithField(aVar4, ans, a.getNextFieldNumber(aVar4))) {
                        }
                        anr.KXX.add(ans);
                    }
                    AppMethodBeat.o(91459);
                    return 0;
                case 3:
                    anr.LyK = aVar3.UbS.zl();
                    AppMethodBeat.o(91459);
                    return 0;
                case 4:
                    anr.LyL = aVar3.UbS.zl();
                    AppMethodBeat.o(91459);
                    return 0;
                case 5:
                    anr.LyM = aVar3.UbS.readString();
                    AppMethodBeat.o(91459);
                    return 0;
                case 6:
                    anr.Coh = aVar3.UbS.readString();
                    AppMethodBeat.o(91459);
                    return 0;
                case 7:
                    anr.LyN = aVar3.UbS.zl();
                    AppMethodBeat.o(91459);
                    return 0;
                case 8:
                    anr.Lhy = aVar3.UbS.readString();
                    AppMethodBeat.o(91459);
                    return 0;
                default:
                    AppMethodBeat.o(91459);
                    return -1;
            }
        } else {
            AppMethodBeat.o(91459);
            return -1;
        }
    }
}
