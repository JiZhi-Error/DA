package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class hv extends a {
    public LinkedList<hu> KLJ = new LinkedList<>();
    public String desc;
    public String title;

    public hv() {
        AppMethodBeat.i(123550);
        AppMethodBeat.o(123550);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(123551);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            if (this.desc != null) {
                aVar.e(2, this.desc);
            }
            aVar.e(3, 8, this.KLJ);
            AppMethodBeat.o(123551);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0;
            if (this.desc != null) {
                f2 += g.a.a.b.b.a.f(2, this.desc);
            }
            int c2 = f2 + g.a.a.a.c(3, 8, this.KLJ);
            AppMethodBeat.o(123551);
            return c2;
        } else if (i2 == 2) {
            this.KLJ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(123551);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            hv hvVar = (hv) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    hvVar.title = aVar3.UbS.readString();
                    AppMethodBeat.o(123551);
                    return 0;
                case 2:
                    hvVar.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(123551);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        hu huVar = new hu();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = huVar.populateBuilderWithField(aVar4, huVar, a.getNextFieldNumber(aVar4))) {
                        }
                        hvVar.KLJ.add(huVar);
                    }
                    AppMethodBeat.o(123551);
                    return 0;
                default:
                    AppMethodBeat.o(123551);
                    return -1;
            }
        } else {
            AppMethodBeat.o(123551);
            return -1;
        }
    }
}
