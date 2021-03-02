package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class cry extends a {
    public axy Aqo;
    public String MqW;
    public String MwX;
    public String Mxa;
    public int Mxb;
    public String lDR;
    public String qHg;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(256709);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.MwX != null) {
                aVar.e(1, this.MwX);
            }
            if (this.MqW != null) {
                aVar.e(2, this.MqW);
            }
            if (this.lDR != null) {
                aVar.e(3, this.lDR);
            }
            if (this.qHg != null) {
                aVar.e(4, this.qHg);
            }
            if (this.Mxa != null) {
                aVar.e(5, this.Mxa);
            }
            aVar.aM(6, this.Mxb);
            if (this.Aqo != null) {
                aVar.ni(7, this.Aqo.computeSize());
                this.Aqo.writeFields(aVar);
            }
            AppMethodBeat.o(256709);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.MwX != null ? g.a.a.b.b.a.f(1, this.MwX) + 0 : 0;
            if (this.MqW != null) {
                f2 += g.a.a.b.b.a.f(2, this.MqW);
            }
            if (this.lDR != null) {
                f2 += g.a.a.b.b.a.f(3, this.lDR);
            }
            if (this.qHg != null) {
                f2 += g.a.a.b.b.a.f(4, this.qHg);
            }
            if (this.Mxa != null) {
                f2 += g.a.a.b.b.a.f(5, this.Mxa);
            }
            int bu = f2 + g.a.a.b.b.a.bu(6, this.Mxb);
            if (this.Aqo != null) {
                bu += g.a.a.a.nh(7, this.Aqo.computeSize());
            }
            AppMethodBeat.o(256709);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(256709);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cry cry = (cry) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    cry.MwX = aVar3.UbS.readString();
                    AppMethodBeat.o(256709);
                    return 0;
                case 2:
                    cry.MqW = aVar3.UbS.readString();
                    AppMethodBeat.o(256709);
                    return 0;
                case 3:
                    cry.lDR = aVar3.UbS.readString();
                    AppMethodBeat.o(256709);
                    return 0;
                case 4:
                    cry.qHg = aVar3.UbS.readString();
                    AppMethodBeat.o(256709);
                    return 0;
                case 5:
                    cry.Mxa = aVar3.UbS.readString();
                    AppMethodBeat.o(256709);
                    return 0;
                case 6:
                    cry.Mxb = aVar3.UbS.zi();
                    AppMethodBeat.o(256709);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        axy axy = new axy();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = axy.populateBuilderWithField(aVar4, axy, a.getNextFieldNumber(aVar4))) {
                        }
                        cry.Aqo = axy;
                    }
                    AppMethodBeat.o(256709);
                    return 0;
                default:
                    AppMethodBeat.o(256709);
                    return -1;
            }
        } else {
            AppMethodBeat.o(256709);
            return -1;
        }
    }
}
