package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;

public final class alc extends a {
    public String Lub;
    public String finderUsername;
    public long hFK;
    public int mediaType;
    public String sessionBuffer;
    public int videoDuration;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209321);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.hFK);
            if (this.finderUsername != null) {
                aVar.e(2, this.finderUsername);
            }
            if (this.sessionBuffer != null) {
                aVar.e(3, this.sessionBuffer);
            }
            if (this.Lub != null) {
                aVar.e(4, this.Lub);
            }
            aVar.aM(5, this.videoDuration);
            aVar.aM(6, this.mediaType);
            AppMethodBeat.o(209321);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.hFK) + 0;
            if (this.finderUsername != null) {
                r += g.a.a.b.b.a.f(2, this.finderUsername);
            }
            if (this.sessionBuffer != null) {
                r += g.a.a.b.b.a.f(3, this.sessionBuffer);
            }
            if (this.Lub != null) {
                r += g.a.a.b.b.a.f(4, this.Lub);
            }
            int bu = r + g.a.a.b.b.a.bu(5, this.videoDuration) + g.a.a.b.b.a.bu(6, this.mediaType);
            AppMethodBeat.o(209321);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209321);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            alc alc = (alc) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    alc.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(209321);
                    return 0;
                case 2:
                    alc.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(209321);
                    return 0;
                case 3:
                    alc.sessionBuffer = aVar3.UbS.readString();
                    AppMethodBeat.o(209321);
                    return 0;
                case 4:
                    alc.Lub = aVar3.UbS.readString();
                    AppMethodBeat.o(209321);
                    return 0;
                case 5:
                    alc.videoDuration = aVar3.UbS.zi();
                    AppMethodBeat.o(209321);
                    return 0;
                case 6:
                    alc.mediaType = aVar3.UbS.zi();
                    AppMethodBeat.o(209321);
                    return 0;
                default:
                    AppMethodBeat.o(209321);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209321);
            return -1;
        }
    }
}
