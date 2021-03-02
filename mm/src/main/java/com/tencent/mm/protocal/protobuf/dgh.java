package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dgh extends dop {
    public long Btv;
    public long KTS;
    public String MFo;
    public int MKU;
    public long MKV;
    public int MKW;
    public long MKX;
    public long appid;
    public int dDe;
    public int platform;
    public int scene;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124539);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.MKU);
            aVar.bb(3, this.MKV);
            aVar.bb(4, this.appid);
            aVar.bb(5, this.KTS);
            aVar.aM(6, this.MKW);
            aVar.aM(7, this.scene);
            aVar.aM(8, this.dDe);
            aVar.bb(9, this.Btv);
            aVar.bb(10, this.MKX);
            aVar.aM(11, this.platform);
            if (this.MFo != null) {
                aVar.e(12, this.MFo);
            }
            AppMethodBeat.o(124539);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.MKU) + g.a.a.b.b.a.r(3, this.MKV) + g.a.a.b.b.a.r(4, this.appid) + g.a.a.b.b.a.r(5, this.KTS) + g.a.a.b.b.a.bu(6, this.MKW) + g.a.a.b.b.a.bu(7, this.scene) + g.a.a.b.b.a.bu(8, this.dDe) + g.a.a.b.b.a.r(9, this.Btv) + g.a.a.b.b.a.r(10, this.MKX) + g.a.a.b.b.a.bu(11, this.platform);
            if (this.MFo != null) {
                nh += g.a.a.b.b.a.f(12, this.MFo);
            }
            AppMethodBeat.o(124539);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124539);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dgh dgh = (dgh) objArr[1];
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
                        dgh.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124539);
                    return 0;
                case 2:
                    dgh.MKU = aVar3.UbS.zi();
                    AppMethodBeat.o(124539);
                    return 0;
                case 3:
                    dgh.MKV = aVar3.UbS.zl();
                    AppMethodBeat.o(124539);
                    return 0;
                case 4:
                    dgh.appid = aVar3.UbS.zl();
                    AppMethodBeat.o(124539);
                    return 0;
                case 5:
                    dgh.KTS = aVar3.UbS.zl();
                    AppMethodBeat.o(124539);
                    return 0;
                case 6:
                    dgh.MKW = aVar3.UbS.zi();
                    AppMethodBeat.o(124539);
                    return 0;
                case 7:
                    dgh.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(124539);
                    return 0;
                case 8:
                    dgh.dDe = aVar3.UbS.zi();
                    AppMethodBeat.o(124539);
                    return 0;
                case 9:
                    dgh.Btv = aVar3.UbS.zl();
                    AppMethodBeat.o(124539);
                    return 0;
                case 10:
                    dgh.MKX = aVar3.UbS.zl();
                    AppMethodBeat.o(124539);
                    return 0;
                case 11:
                    dgh.platform = aVar3.UbS.zi();
                    AppMethodBeat.o(124539);
                    return 0;
                case 12:
                    dgh.MFo = aVar3.UbS.readString();
                    AppMethodBeat.o(124539);
                    return 0;
                default:
                    AppMethodBeat.o(124539);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124539);
            return -1;
        }
    }
}
