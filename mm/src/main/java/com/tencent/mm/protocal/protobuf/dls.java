package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class dls extends a {
    public String MPm;
    public dlt MaT;
    public String content;
    public String iwt;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168758);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.content != null) {
                aVar.e(1, this.content);
            }
            if (this.iwt != null) {
                aVar.e(2, this.iwt);
            }
            if (this.MPm != null) {
                aVar.e(3, this.MPm);
            }
            if (this.MaT != null) {
                aVar.ni(4, this.MaT.computeSize());
                this.MaT.writeFields(aVar);
            }
            AppMethodBeat.o(168758);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.content != null ? g.a.a.b.b.a.f(1, this.content) + 0 : 0;
            if (this.iwt != null) {
                f2 += g.a.a.b.b.a.f(2, this.iwt);
            }
            if (this.MPm != null) {
                f2 += g.a.a.b.b.a.f(3, this.MPm);
            }
            if (this.MaT != null) {
                f2 += g.a.a.a.nh(4, this.MaT.computeSize());
            }
            AppMethodBeat.o(168758);
            return f2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168758);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dls dls = (dls) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    dls.content = aVar3.UbS.readString();
                    AppMethodBeat.o(168758);
                    return 0;
                case 2:
                    dls.iwt = aVar3.UbS.readString();
                    AppMethodBeat.o(168758);
                    return 0;
                case 3:
                    dls.MPm = aVar3.UbS.readString();
                    AppMethodBeat.o(168758);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        dlt dlt = new dlt();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = dlt.populateBuilderWithField(aVar4, dlt, a.getNextFieldNumber(aVar4))) {
                        }
                        dls.MaT = dlt;
                    }
                    AppMethodBeat.o(168758);
                    return 0;
                default:
                    AppMethodBeat.o(168758);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168758);
            return -1;
        }
    }
}
