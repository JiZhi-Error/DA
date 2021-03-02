package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dwt extends dop {
    public String MWO;
    public float dTj;
    public float latitude;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32438);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.E(2, this.dTj);
            aVar.E(3, this.latitude);
            aVar.aM(4, this.scene);
            if (this.MWO != null) {
                aVar.e(5, this.MWO);
            }
            AppMethodBeat.o(32438);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.fS(2) + 4 + g.a.a.b.b.a.fS(3) + 4 + g.a.a.b.b.a.bu(4, this.scene);
            if (this.MWO != null) {
                nh += g.a.a.b.b.a.f(5, this.MWO);
            }
            AppMethodBeat.o(32438);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(32438);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dwt dwt = (dwt) objArr[1];
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
                        dwt.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32438);
                    return 0;
                case 2:
                    dwt.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(32438);
                    return 0;
                case 3:
                    dwt.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(32438);
                    return 0;
                case 4:
                    dwt.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(32438);
                    return 0;
                case 5:
                    dwt.MWO = aVar3.UbS.readString();
                    AppMethodBeat.o(32438);
                    return 0;
                default:
                    AppMethodBeat.o(32438);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32438);
            return -1;
        }
    }
}
