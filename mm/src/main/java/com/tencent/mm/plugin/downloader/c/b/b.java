package com.tencent.mm.plugin.downloader.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class b extends a {
    public String icon;
    public r qGm;
    public r qGn;
    public String qGo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153059);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.icon != null) {
                aVar.e(1, this.icon);
            }
            if (this.qGm != null) {
                aVar.ni(2, this.qGm.computeSize());
                this.qGm.writeFields(aVar);
            }
            if (this.qGn != null) {
                aVar.ni(3, this.qGn.computeSize());
                this.qGn.writeFields(aVar);
            }
            if (this.qGo != null) {
                aVar.e(4, this.qGo);
            }
            AppMethodBeat.o(153059);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.icon != null ? g.a.a.b.b.a.f(1, this.icon) + 0 : 0;
            if (this.qGm != null) {
                f2 += g.a.a.a.nh(2, this.qGm.computeSize());
            }
            if (this.qGn != null) {
                f2 += g.a.a.a.nh(3, this.qGn.computeSize());
            }
            if (this.qGo != null) {
                f2 += g.a.a.b.b.a.f(4, this.qGo);
            }
            AppMethodBeat.o(153059);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153059);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            b bVar = (b) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bVar.icon = aVar3.UbS.readString();
                    AppMethodBeat.o(153059);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        r rVar = new r();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = rVar.populateBuilderWithField(aVar4, rVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bVar.qGm = rVar;
                    }
                    AppMethodBeat.o(153059);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        r rVar2 = new r();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = rVar2.populateBuilderWithField(aVar5, rVar2, a.getNextFieldNumber(aVar5))) {
                        }
                        bVar.qGn = rVar2;
                    }
                    AppMethodBeat.o(153059);
                    return 0;
                case 4:
                    bVar.qGo = aVar3.UbS.readString();
                    AppMethodBeat.o(153059);
                    return 0;
                default:
                    AppMethodBeat.o(153059);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153059);
            return -1;
        }
    }
}
