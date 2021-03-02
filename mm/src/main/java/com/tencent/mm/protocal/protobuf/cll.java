package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cll extends dop {
    public long BPd;
    public int MqK;
    public LinkedList<b> MqL = new LinkedList<>();
    public long MqM;
    public long MqN;
    public float dTj;
    public float latitude;

    public cll() {
        AppMethodBeat.i(169918);
        AppMethodBeat.o(169918);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169919);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.MqK);
            aVar.E(3, this.latitude);
            aVar.E(4, this.dTj);
            aVar.e(5, 6, this.MqL);
            aVar.bb(6, this.BPd);
            aVar.bb(7, this.MqM);
            aVar.bb(8, this.MqN);
            AppMethodBeat.o(169919);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MqK) + g.a.a.b.b.a.fS(3) + 4 + g.a.a.b.b.a.fS(4) + 4 + g.a.a.a.c(5, 6, this.MqL) + g.a.a.b.b.a.r(6, this.BPd) + g.a.a.b.b.a.r(7, this.MqM) + g.a.a.b.b.a.r(8, this.MqN);
            AppMethodBeat.o(169919);
            return nh;
        } else if (i2 == 2) {
            this.MqL.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169919);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cll cll = (cll) objArr[1];
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
                        cll.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(169919);
                    return 0;
                case 2:
                    cll.MqK = aVar3.UbS.zi();
                    AppMethodBeat.o(169919);
                    return 0;
                case 3:
                    cll.latitude = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169919);
                    return 0;
                case 4:
                    cll.dTj = Float.intBitsToFloat(aVar3.UbS.zm());
                    AppMethodBeat.o(169919);
                    return 0;
                case 5:
                    cll.MqL.add(aVar3.UbS.hPo());
                    AppMethodBeat.o(169919);
                    return 0;
                case 6:
                    cll.BPd = aVar3.UbS.zl();
                    AppMethodBeat.o(169919);
                    return 0;
                case 7:
                    cll.MqM = aVar3.UbS.zl();
                    AppMethodBeat.o(169919);
                    return 0;
                case 8:
                    cll.MqN = aVar3.UbS.zl();
                    AppMethodBeat.o(169919);
                    return 0;
                default:
                    AppMethodBeat.o(169919);
                    return -1;
            }
        } else {
            AppMethodBeat.o(169919);
            return -1;
        }
    }
}
