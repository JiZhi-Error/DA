package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eaz extends dop {
    public long Nar;
    public int OpCode;
    public int Scene;
    public LinkedList<dqi> oTA = new LinkedList<>();
    public int oTz;
    public String xMo;

    public eaz() {
        AppMethodBeat.i(125821);
        AppMethodBeat.o(125821);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125822);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.OpCode);
            aVar.bb(3, this.Nar);
            if (this.xMo != null) {
                aVar.e(4, this.xMo);
            }
            aVar.aM(5, this.oTz);
            aVar.e(6, 8, this.oTA);
            aVar.aM(7, this.Scene);
            AppMethodBeat.o(125822);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.OpCode) + g.a.a.b.b.a.r(3, this.Nar);
            if (this.xMo != null) {
                nh += g.a.a.b.b.a.f(4, this.xMo);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.oTz) + g.a.a.a.c(6, 8, this.oTA) + g.a.a.b.b.a.bu(7, this.Scene);
            AppMethodBeat.o(125822);
            return bu;
        } else if (i2 == 2) {
            this.oTA.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(125822);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eaz eaz = (eaz) objArr[1];
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
                        eaz.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(125822);
                    return 0;
                case 2:
                    eaz.OpCode = aVar3.UbS.zi();
                    AppMethodBeat.o(125822);
                    return 0;
                case 3:
                    eaz.Nar = aVar3.UbS.zl();
                    AppMethodBeat.o(125822);
                    return 0;
                case 4:
                    eaz.xMo = aVar3.UbS.readString();
                    AppMethodBeat.o(125822);
                    return 0;
                case 5:
                    eaz.oTz = aVar3.UbS.zi();
                    AppMethodBeat.o(125822);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        eaz.oTA.add(dqi);
                    }
                    AppMethodBeat.o(125822);
                    return 0;
                case 7:
                    eaz.Scene = aVar3.UbS.zi();
                    AppMethodBeat.o(125822);
                    return 0;
                default:
                    AppMethodBeat.o(125822);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125822);
            return -1;
        }
    }
}
