package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bfa extends dop {
    public String egX;
    public int limit;
    public int msgType;
    public int offset;
    public int scene;
    public String yQE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(214292);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.egX != null) {
                aVar.e(2, this.egX);
            }
            aVar.aM(3, this.limit);
            aVar.aM(4, this.offset);
            if (this.yQE != null) {
                aVar.e(5, this.yQE);
            }
            aVar.aM(6, this.msgType);
            aVar.aM(7, this.scene);
            AppMethodBeat.o(214292);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.egX != null) {
                nh += g.a.a.b.b.a.f(2, this.egX);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.limit) + g.a.a.b.b.a.bu(4, this.offset);
            if (this.yQE != null) {
                bu += g.a.a.b.b.a.f(5, this.yQE);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.msgType) + g.a.a.b.b.a.bu(7, this.scene);
            AppMethodBeat.o(214292);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(214292);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bfa bfa = (bfa) objArr[1];
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
                        bfa.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(214292);
                    return 0;
                case 2:
                    bfa.egX = aVar3.UbS.readString();
                    AppMethodBeat.o(214292);
                    return 0;
                case 3:
                    bfa.limit = aVar3.UbS.zi();
                    AppMethodBeat.o(214292);
                    return 0;
                case 4:
                    bfa.offset = aVar3.UbS.zi();
                    AppMethodBeat.o(214292);
                    return 0;
                case 5:
                    bfa.yQE = aVar3.UbS.readString();
                    AppMethodBeat.o(214292);
                    return 0;
                case 6:
                    bfa.msgType = aVar3.UbS.zi();
                    AppMethodBeat.o(214292);
                    return 0;
                case 7:
                    bfa.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(214292);
                    return 0;
                default:
                    AppMethodBeat.o(214292);
                    return -1;
            }
        } else {
            AppMethodBeat.o(214292);
            return -1;
        }
    }
}
