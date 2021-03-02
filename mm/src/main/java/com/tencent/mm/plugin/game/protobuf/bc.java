package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class bc extends a {
    public String xIG;
    public g xIz;
    public String xJt;
    public LinkedList<bd> xLe = new LinkedList<>();

    public bc() {
        AppMethodBeat.i(41748);
        AppMethodBeat.o(41748);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41749);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xIz == null) {
                b bVar = new b("Not all required fields were included: AppItem");
                AppMethodBeat.o(41749);
                throw bVar;
            }
            if (this.xIz != null) {
                aVar.ni(1, this.xIz.computeSize());
                this.xIz.writeFields(aVar);
            }
            if (this.xIG != null) {
                aVar.e(2, this.xIG);
            }
            aVar.e(3, 8, this.xLe);
            if (this.xJt != null) {
                aVar.e(4, this.xJt);
            }
            AppMethodBeat.o(41749);
            return 0;
        } else if (i2 == 1) {
            int nh = this.xIz != null ? g.a.a.a.nh(1, this.xIz.computeSize()) + 0 : 0;
            if (this.xIG != null) {
                nh += g.a.a.b.b.a.f(2, this.xIG);
            }
            int c2 = nh + g.a.a.a.c(3, 8, this.xLe);
            if (this.xJt != null) {
                c2 += g.a.a.b.b.a.f(4, this.xJt);
            }
            AppMethodBeat.o(41749);
            return c2;
        } else if (i2 == 2) {
            this.xLe.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.xIz == null) {
                b bVar2 = new b("Not all required fields were included: AppItem");
                AppMethodBeat.o(41749);
                throw bVar2;
            }
            AppMethodBeat.o(41749);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bc bcVar = (bc) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        g gVar = new g();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = gVar.populateBuilderWithField(aVar4, gVar, a.getNextFieldNumber(aVar4))) {
                        }
                        bcVar.xIz = gVar;
                    }
                    AppMethodBeat.o(41749);
                    return 0;
                case 2:
                    bcVar.xIG = aVar3.UbS.readString();
                    AppMethodBeat.o(41749);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bd bdVar = new bd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bdVar.populateBuilderWithField(aVar5, bdVar, a.getNextFieldNumber(aVar5))) {
                        }
                        bcVar.xLe.add(bdVar);
                    }
                    AppMethodBeat.o(41749);
                    return 0;
                case 4:
                    bcVar.xJt = aVar3.UbS.readString();
                    AppMethodBeat.o(41749);
                    return 0;
                default:
                    AppMethodBeat.o(41749);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41749);
            return -1;
        }
    }
}
