package com.tencent.mm.plugin.talkroom.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.egs;
import g.a.a.b;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bw.a {
    public LinkedList<egs> dTe = new LinkedList<>();
    public int sceneType;
    public String username;

    public a() {
        AppMethodBeat.i(29432);
        AppMethodBeat.o(29432);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(29433);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username == null) {
                b bVar = new b("Not all required fields were included: username");
                AppMethodBeat.o(29433);
                throw bVar;
            }
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            aVar.e(2, 8, this.dTe);
            aVar.aM(3, this.sceneType);
            AppMethodBeat.o(29433);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0) + g.a.a.a.c(2, 8, this.dTe) + g.a.a.b.b.a.bu(3, this.sceneType);
            AppMethodBeat.o(29433);
            return f2;
        } else if (i2 == 2) {
            this.dTe.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = com.tencent.mm.bw.a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.username == null) {
                b bVar2 = new b("Not all required fields were included: username");
                AppMethodBeat.o(29433);
                throw bVar2;
            }
            AppMethodBeat.o(29433);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aVar4.username = aVar3.UbS.readString();
                    AppMethodBeat.o(29433);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        egs egs = new egs();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = egs.populateBuilderWithField(aVar5, egs, com.tencent.mm.bw.a.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.dTe.add(egs);
                    }
                    AppMethodBeat.o(29433);
                    return 0;
                case 3:
                    aVar4.sceneType = aVar3.UbS.zi();
                    AppMethodBeat.o(29433);
                    return 0;
                default:
                    AppMethodBeat.o(29433);
                    return -1;
            }
        } else {
            AppMethodBeat.o(29433);
            return -1;
        }
    }
}
