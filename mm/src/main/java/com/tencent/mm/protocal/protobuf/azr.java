package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class azr extends a {
    public int LJw;
    public String groupId;
    public azk musicInfo;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209617);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.musicInfo != null) {
                aVar.ni(1, this.musicInfo.computeSize());
                this.musicInfo.writeFields(aVar);
            }
            if (this.groupId != null) {
                aVar.e(2, this.groupId);
            }
            aVar.aM(3, this.LJw);
            AppMethodBeat.o(209617);
            return 0;
        } else if (i2 == 1) {
            int nh = this.musicInfo != null ? g.a.a.a.nh(1, this.musicInfo.computeSize()) + 0 : 0;
            if (this.groupId != null) {
                nh += g.a.a.b.b.a.f(2, this.groupId);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.LJw);
            AppMethodBeat.o(209617);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209617);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            azr azr = (azr) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        azk azk = new azk();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = azk.populateBuilderWithField(aVar4, azk, a.getNextFieldNumber(aVar4))) {
                        }
                        azr.musicInfo = azk;
                    }
                    AppMethodBeat.o(209617);
                    return 0;
                case 2:
                    azr.groupId = aVar3.UbS.readString();
                    AppMethodBeat.o(209617);
                    return 0;
                case 3:
                    azr.LJw = aVar3.UbS.zi();
                    AppMethodBeat.o(209617);
                    return 0;
                default:
                    AppMethodBeat.o(209617);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209617);
            return -1;
        }
    }
}
