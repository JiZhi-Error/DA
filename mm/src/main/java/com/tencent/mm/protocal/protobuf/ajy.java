package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ajy extends dop {
    public String LsY;
    public int LsZ;
    public long Lta;
    public int Scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32193);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.LsZ);
            aVar.bb(3, this.Lta);
            if (this.LsY != null) {
                aVar.e(4, this.LsY);
            }
            aVar.aM(5, this.Scene);
            AppMethodBeat.o(32193);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LsZ) + g.a.a.b.b.a.r(3, this.Lta);
            if (this.LsY != null) {
                nh += g.a.a.b.b.a.f(4, this.LsY);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.Scene);
            AppMethodBeat.o(32193);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32193);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ajy ajy = (ajy) objArr[1];
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
                        ajy.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32193);
                    return 0;
                case 2:
                    ajy.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(32193);
                    return 0;
                case 3:
                    ajy.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(32193);
                    return 0;
                case 4:
                    ajy.LsY = aVar3.UbS.readString();
                    AppMethodBeat.o(32193);
                    return 0;
                case 5:
                    ajy.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(32193);
                    return 0;
                default:
                    AppMethodBeat.o(32193);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32193);
            return -1;
        }
    }
}
