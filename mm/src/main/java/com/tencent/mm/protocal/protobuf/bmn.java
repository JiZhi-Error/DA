package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bmn extends dop {
    public LinkedList<String> LVo = new LinkedList<>();
    public int scene;

    public bmn() {
        AppMethodBeat.i(114025);
        AppMethodBeat.o(114025);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(114026);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 1, this.LVo);
            aVar.aM(3, this.scene);
            AppMethodBeat.o(114026);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 1, this.LVo) + g.a.a.b.b.a.bu(3, this.scene);
            AppMethodBeat.o(114026);
            return nh;
        } else if (i2 == 2) {
            this.LVo.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(114026);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bmn bmn = (bmn) objArr[1];
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
                        bmn.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(114026);
                    return 0;
                case 2:
                    bmn.LVo.add(aVar3.UbS.readString());
                    AppMethodBeat.o(114026);
                    return 0;
                case 3:
                    bmn.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(114026);
                    return 0;
                default:
                    AppMethodBeat.o(114026);
                    return -1;
            }
        } else {
            AppMethodBeat.o(114026);
            return -1;
        }
    }
}
