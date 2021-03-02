package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dvd extends a {
    public String MWb;
    public LinkedList<dvc> MWj = new LinkedList<>();
    public String dMl;
    public String sGF;

    public dvd() {
        AppMethodBeat.i(122532);
        AppMethodBeat.o(122532);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122533);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.sGF != null) {
                aVar.e(1, this.sGF);
            }
            if (this.MWb != null) {
                aVar.e(2, this.MWb);
            }
            if (this.dMl != null) {
                aVar.e(3, this.dMl);
            }
            aVar.e(4, 8, this.MWj);
            AppMethodBeat.o(122533);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.sGF != null ? g.a.a.b.b.a.f(1, this.sGF) + 0 : 0;
            if (this.MWb != null) {
                f2 += g.a.a.b.b.a.f(2, this.MWb);
            }
            if (this.dMl != null) {
                f2 += g.a.a.b.b.a.f(3, this.dMl);
            }
            int c2 = f2 + g.a.a.a.c(4, 8, this.MWj);
            AppMethodBeat.o(122533);
            return c2;
        } else if (i2 == 2) {
            this.MWj.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122533);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dvd dvd = (dvd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dvd.sGF = aVar3.UbS.readString();
                    AppMethodBeat.o(122533);
                    return 0;
                case 2:
                    dvd.MWb = aVar3.UbS.readString();
                    AppMethodBeat.o(122533);
                    return 0;
                case 3:
                    dvd.dMl = aVar3.UbS.readString();
                    AppMethodBeat.o(122533);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dvc dvc = new dvc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dvc.populateBuilderWithField(aVar4, dvc, a.getNextFieldNumber(aVar4))) {
                        }
                        dvd.MWj.add(dvc);
                    }
                    AppMethodBeat.o(122533);
                    return 0;
                default:
                    AppMethodBeat.o(122533);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122533);
            return -1;
        }
    }
}
