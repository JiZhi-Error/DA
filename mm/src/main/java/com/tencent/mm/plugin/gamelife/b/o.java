package com.tencent.mm.plugin.gamelife.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class o extends a {
    public String pPz;
    public String session_id;
    public a ybe;
    public n ybp;
    public String ybq;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(225902);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.session_id != null) {
                aVar.e(1, this.session_id);
            }
            if (this.ybp != null) {
                aVar.ni(2, this.ybp.computeSize());
                this.ybp.writeFields(aVar);
            }
            if (this.ybq != null) {
                aVar.e(3, this.ybq);
            }
            if (this.pPz != null) {
                aVar.e(4, this.pPz);
            }
            if (this.ybe != null) {
                aVar.ni(5, this.ybe.computeSize());
                this.ybe.writeFields(aVar);
            }
            AppMethodBeat.o(225902);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.session_id != null ? g.a.a.b.b.a.f(1, this.session_id) + 0 : 0;
            if (this.ybp != null) {
                f2 += g.a.a.a.nh(2, this.ybp.computeSize());
            }
            if (this.ybq != null) {
                f2 += g.a.a.b.b.a.f(3, this.ybq);
            }
            if (this.pPz != null) {
                f2 += g.a.a.b.b.a.f(4, this.pPz);
            }
            if (this.ybe != null) {
                f2 += g.a.a.a.nh(5, this.ybe.computeSize());
            }
            AppMethodBeat.o(225902);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(225902);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            o oVar = (o) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    oVar.session_id = aVar3.UbS.readString();
                    AppMethodBeat.o(225902);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        n nVar = new n();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = nVar.populateBuilderWithField(aVar4, nVar, a.getNextFieldNumber(aVar4))) {
                        }
                        oVar.ybp = nVar;
                    }
                    AppMethodBeat.o(225902);
                    return 0;
                case 3:
                    oVar.ybq = aVar3.UbS.readString();
                    AppMethodBeat.o(225902);
                    return 0;
                case 4:
                    oVar.pPz = aVar3.UbS.readString();
                    AppMethodBeat.o(225902);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        a aVar5 = new a();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aVar5.populateBuilderWithField(aVar6, aVar5, a.getNextFieldNumber(aVar6))) {
                        }
                        oVar.ybe = aVar5;
                    }
                    AppMethodBeat.o(225902);
                    return 0;
                default:
                    AppMethodBeat.o(225902);
                    return -1;
            }
        } else {
            AppMethodBeat.o(225902);
            return -1;
        }
    }
}
