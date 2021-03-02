package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class apd extends dop {
    public String LBj;
    public String finderUsername;
    public long hFK;
    public long liveId;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209347);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.bb(2, this.liveId);
            if (this.finderUsername != null) {
                aVar.e(3, this.finderUsername);
            }
            aVar.bb(4, this.hFK);
            if (this.LBj != null) {
                aVar.e(5, this.LBj);
            }
            aVar.aM(6, this.scene);
            AppMethodBeat.o(209347);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.r(2, this.liveId);
            if (this.finderUsername != null) {
                nh += g.a.a.b.b.a.f(3, this.finderUsername);
            }
            int r = nh + g.a.a.b.b.a.r(4, this.hFK);
            if (this.LBj != null) {
                r += g.a.a.b.b.a.f(5, this.LBj);
            }
            int bu = r + g.a.a.b.b.a.bu(6, this.scene);
            AppMethodBeat.o(209347);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209347);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            apd apd = (apd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar4, jrVar, dop.getNextFieldNumber(aVar4))) {
                        }
                        apd.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209347);
                    return 0;
                case 2:
                    apd.liveId = aVar3.UbS.zl();
                    AppMethodBeat.o(209347);
                    return 0;
                case 3:
                    apd.finderUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(209347);
                    return 0;
                case 4:
                    apd.hFK = aVar3.UbS.zl();
                    AppMethodBeat.o(209347);
                    return 0;
                case 5:
                    apd.LBj = aVar3.UbS.readString();
                    AppMethodBeat.o(209347);
                    return 0;
                case 6:
                    apd.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(209347);
                    return 0;
                default:
                    AppMethodBeat.o(209347);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209347);
            return -1;
        }
    }
}
