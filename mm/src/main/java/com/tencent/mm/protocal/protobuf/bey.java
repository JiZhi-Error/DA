package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class bey extends a {
    public String title;
    public LinkedList<ahq> yUI = new LinkedList<>();

    public bey() {
        AppMethodBeat.i(214289);
        AppMethodBeat.o(214289);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214290);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.title != null) {
                aVar.e(1, this.title);
            }
            aVar.e(2, 8, this.yUI);
            AppMethodBeat.o(214290);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.title != null ? g.a.a.b.b.a.f(1, this.title) + 0 : 0) + g.a.a.a.c(2, 8, this.yUI);
            AppMethodBeat.o(214290);
            return f2;
        } else if (i2 == 2) {
            this.yUI.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(214290);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bey bey = (bey) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    bey.title = aVar3.UbS.readString();
                    AppMethodBeat.o(214290);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ahq ahq = new ahq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ahq.populateBuilderWithField(aVar4, ahq, a.getNextFieldNumber(aVar4))) {
                        }
                        bey.yUI.add(ahq);
                    }
                    AppMethodBeat.o(214290);
                    return 0;
                default:
                    AppMethodBeat.o(214290);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214290);
            return -1;
        }
    }
}
