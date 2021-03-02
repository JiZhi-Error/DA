package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cfa extends dop {
    public String KBt;
    public String LUq;
    public String Mju;
    public String dNI;
    public int qwL;
    public String signature;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(90969);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.dNI != null) {
                aVar.e(2, this.dNI);
            }
            if (this.KBt != null) {
                aVar.e(3, this.KBt);
            }
            if (this.signature != null) {
                aVar.e(4, this.signature);
            }
            aVar.aM(5, this.qwL);
            if (this.Mju != null) {
                aVar.e(6, this.Mju);
            }
            if (this.LUq != null) {
                aVar.e(7, this.LUq);
            }
            AppMethodBeat.o(90969);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.dNI != null) {
                nh += g.a.a.b.b.a.f(2, this.dNI);
            }
            if (this.KBt != null) {
                nh += g.a.a.b.b.a.f(3, this.KBt);
            }
            if (this.signature != null) {
                nh += g.a.a.b.b.a.f(4, this.signature);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.qwL);
            if (this.Mju != null) {
                bu += g.a.a.b.b.a.f(6, this.Mju);
            }
            if (this.LUq != null) {
                bu += g.a.a.b.b.a.f(7, this.LUq);
            }
            AppMethodBeat.o(90969);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(90969);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cfa cfa = (cfa) objArr[1];
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
                        cfa.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(90969);
                    return 0;
                case 2:
                    cfa.dNI = aVar3.UbS.readString();
                    AppMethodBeat.o(90969);
                    return 0;
                case 3:
                    cfa.KBt = aVar3.UbS.readString();
                    AppMethodBeat.o(90969);
                    return 0;
                case 4:
                    cfa.signature = aVar3.UbS.readString();
                    AppMethodBeat.o(90969);
                    return 0;
                case 5:
                    cfa.qwL = aVar3.UbS.zi();
                    AppMethodBeat.o(90969);
                    return 0;
                case 6:
                    cfa.Mju = aVar3.UbS.readString();
                    AppMethodBeat.o(90969);
                    return 0;
                case 7:
                    cfa.LUq = aVar3.UbS.readString();
                    AppMethodBeat.o(90969);
                    return 0;
                default:
                    AppMethodBeat.o(90969);
                    return -1;
            }
        } else {
            AppMethodBeat.o(90969);
            return -1;
        }
    }
}
