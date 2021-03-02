package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dmy extends dop {
    public int KRg;
    public LinkedList<ot> MQm = new LinkedList<>();
    public int MQn;
    public int MQo;
    public long MQp;
    public int MQq;
    public int scene;

    public dmy() {
        AppMethodBeat.i(6424);
        AppMethodBeat.o(6424);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(6425);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 8, this.MQm);
            aVar.aM(3, this.MQn);
            aVar.aM(4, this.MQo);
            aVar.aM(5, this.KRg);
            aVar.bb(6, this.MQp);
            aVar.aM(7, this.scene);
            aVar.aM(8, this.MQq);
            AppMethodBeat.o(6425);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 8, this.MQm) + g.a.a.b.b.a.bu(3, this.MQn) + g.a.a.b.b.a.bu(4, this.MQo) + g.a.a.b.b.a.bu(5, this.KRg) + g.a.a.b.b.a.r(6, this.MQp) + g.a.a.b.b.a.bu(7, this.scene) + g.a.a.b.b.a.bu(8, this.MQq);
            AppMethodBeat.o(6425);
            return nh;
        } else if (i2 == 2) {
            this.MQm.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(6425);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dmy dmy = (dmy) objArr[1];
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
                        dmy.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(6425);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ot otVar = new ot();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = otVar.populateBuilderWithField(aVar5, otVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        dmy.MQm.add(otVar);
                    }
                    AppMethodBeat.o(6425);
                    return 0;
                case 3:
                    dmy.MQn = aVar3.UbS.zi();
                    AppMethodBeat.o(6425);
                    return 0;
                case 4:
                    dmy.MQo = aVar3.UbS.zi();
                    AppMethodBeat.o(6425);
                    return 0;
                case 5:
                    dmy.KRg = aVar3.UbS.zi();
                    AppMethodBeat.o(6425);
                    return 0;
                case 6:
                    dmy.MQp = aVar3.UbS.zl();
                    AppMethodBeat.o(6425);
                    return 0;
                case 7:
                    dmy.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(6425);
                    return 0;
                case 8:
                    dmy.MQq = aVar3.UbS.zi();
                    AppMethodBeat.o(6425);
                    return 0;
                default:
                    AppMethodBeat.o(6425);
                    return -1;
            }
        } else {
            AppMethodBeat.o(6425);
            return -1;
        }
    }
}
