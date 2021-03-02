package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ddu extends dop {
    public efw MIS;
    public boolean MIT;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153290);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MIS != null) {
                aVar.ni(2, this.MIS.computeSize());
                this.MIS.writeFields(aVar);
            }
            aVar.cc(3, this.MIT);
            aVar.aM(4, this.scene);
            AppMethodBeat.o(153290);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MIS != null) {
                nh += g.a.a.a.nh(2, this.MIS.computeSize());
            }
            int fS = nh + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.bu(4, this.scene);
            AppMethodBeat.o(153290);
            return fS;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153290);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ddu ddu = (ddu) objArr[1];
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
                        ddu.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(153290);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        efw efw = new efw();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = efw.populateBuilderWithField(aVar5, efw, dop.getNextFieldNumber(aVar5))) {
                        }
                        ddu.MIS = efw;
                    }
                    AppMethodBeat.o(153290);
                    return 0;
                case 3:
                    ddu.MIT = aVar3.UbS.yZ();
                    AppMethodBeat.o(153290);
                    return 0;
                case 4:
                    ddu.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(153290);
                    return 0;
                default:
                    AppMethodBeat.o(153290);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153290);
            return -1;
        }
    }
}
