package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cqz extends dop {
    public String HuS;
    public String Lmm;
    public ehn Mwt;
    public int time_stamp;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72523);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.time_stamp);
            if (this.Lmm != null) {
                aVar.e(3, this.Lmm);
            }
            if (this.Mwt != null) {
                aVar.ni(4, this.Mwt.computeSize());
                this.Mwt.writeFields(aVar);
            }
            if (this.HuS != null) {
                aVar.e(100, this.HuS);
            }
            AppMethodBeat.o(72523);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.time_stamp);
            if (this.Lmm != null) {
                nh += g.a.a.b.b.a.f(3, this.Lmm);
            }
            if (this.Mwt != null) {
                nh += g.a.a.a.nh(4, this.Mwt.computeSize());
            }
            if (this.HuS != null) {
                nh += g.a.a.b.b.a.f(100, this.HuS);
            }
            AppMethodBeat.o(72523);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72523);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cqz cqz = (cqz) objArr[1];
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
                        cqz.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72523);
                    return 0;
                case 2:
                    cqz.time_stamp = aVar3.UbS.zi();
                    AppMethodBeat.o(72523);
                    return 0;
                case 3:
                    cqz.Lmm = aVar3.UbS.readString();
                    AppMethodBeat.o(72523);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ehn ehn = new ehn();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ehn.populateBuilderWithField(aVar5, ehn, dop.getNextFieldNumber(aVar5))) {
                        }
                        cqz.Mwt = ehn;
                    }
                    AppMethodBeat.o(72523);
                    return 0;
                case 100:
                    cqz.HuS = aVar3.UbS.readString();
                    AppMethodBeat.o(72523);
                    return 0;
                default:
                    AppMethodBeat.o(72523);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72523);
            return -1;
        }
    }
}
