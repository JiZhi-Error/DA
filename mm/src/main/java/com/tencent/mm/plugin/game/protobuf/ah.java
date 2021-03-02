package com.tencent.mm.plugin.game.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class ah extends a {
    public String Desc;
    public g xIz;
    public LinkedList<String> xKe = new LinkedList<>();
    public String xKf;

    public ah() {
        AppMethodBeat.i(41727);
        AppMethodBeat.o(41727);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(41728);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.xIz != null) {
                aVar.ni(1, this.xIz.computeSize());
                this.xIz.writeFields(aVar);
            }
            aVar.e(2, 1, this.xKe);
            if (this.xKf != null) {
                aVar.e(3, this.xKf);
            }
            if (this.Desc != null) {
                aVar.e(4, this.Desc);
            }
            AppMethodBeat.o(41728);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.xIz != null ? g.a.a.a.nh(1, this.xIz.computeSize()) + 0 : 0) + g.a.a.a.c(2, 1, this.xKe);
            if (this.xKf != null) {
                nh += g.a.a.b.b.a.f(3, this.xKf);
            }
            if (this.Desc != null) {
                nh += g.a.a.b.b.a.f(4, this.Desc);
            }
            AppMethodBeat.o(41728);
            return nh;
        } else if (i2 == 2) {
            this.xKe.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(41728);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ah ahVar = (ah) objArr[1];
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
                        ahVar.xIz = gVar;
                    }
                    AppMethodBeat.o(41728);
                    return 0;
                case 2:
                    ahVar.xKe.add(aVar3.UbS.readString());
                    AppMethodBeat.o(41728);
                    return 0;
                case 3:
                    ahVar.xKf = aVar3.UbS.readString();
                    AppMethodBeat.o(41728);
                    return 0;
                case 4:
                    ahVar.Desc = aVar3.UbS.readString();
                    AppMethodBeat.o(41728);
                    return 0;
                default:
                    AppMethodBeat.o(41728);
                    return -1;
            }
        } else {
            AppMethodBeat.o(41728);
            return -1;
        }
    }
}
