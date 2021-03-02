package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class eci extends a {
    public String LOY;
    public String LPa;
    public boolean LPb = false;
    public eih Mhd;
    public eih Mhe;
    public String Mhf;
    public String Mhg;
    public int flags;
    public long timestamp = 0;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(122550);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Mhd != null) {
                aVar.ni(1, this.Mhd.computeSize());
                this.Mhd.writeFields(aVar);
            }
            if (this.Mhe != null) {
                aVar.ni(2, this.Mhe.computeSize());
                this.Mhe.writeFields(aVar);
            }
            aVar.cc(3, this.LPb);
            if (this.LOY != null) {
                aVar.e(4, this.LOY);
            }
            aVar.aM(5, this.flags);
            if (this.LPa != null) {
                aVar.e(6, this.LPa);
            }
            if (this.Mhf != null) {
                aVar.e(7, this.Mhf);
            }
            if (this.Mhg != null) {
                aVar.e(8, this.Mhg);
            }
            aVar.bb(9, this.timestamp);
            AppMethodBeat.o(122550);
            return 0;
        } else if (i2 == 1) {
            int nh = this.Mhd != null ? g.a.a.a.nh(1, this.Mhd.computeSize()) + 0 : 0;
            if (this.Mhe != null) {
                nh += g.a.a.a.nh(2, this.Mhe.computeSize());
            }
            int fS = nh + g.a.a.b.b.a.fS(3) + 1;
            if (this.LOY != null) {
                fS += g.a.a.b.b.a.f(4, this.LOY);
            }
            int bu = fS + g.a.a.b.b.a.bu(5, this.flags);
            if (this.LPa != null) {
                bu += g.a.a.b.b.a.f(6, this.LPa);
            }
            if (this.Mhf != null) {
                bu += g.a.a.b.b.a.f(7, this.Mhf);
            }
            if (this.Mhg != null) {
                bu += g.a.a.b.b.a.f(8, this.Mhg);
            }
            int r = bu + g.a.a.b.b.a.r(9, this.timestamp);
            AppMethodBeat.o(122550);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(122550);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eci eci = (eci) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        eih eih = new eih();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = eih.populateBuilderWithField(aVar4, eih, a.getNextFieldNumber(aVar4))) {
                        }
                        eci.Mhd = eih;
                    }
                    AppMethodBeat.o(122550);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eih eih2 = new eih();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eih2.populateBuilderWithField(aVar5, eih2, a.getNextFieldNumber(aVar5))) {
                        }
                        eci.Mhe = eih2;
                    }
                    AppMethodBeat.o(122550);
                    return 0;
                case 3:
                    eci.LPb = aVar3.UbS.yZ();
                    AppMethodBeat.o(122550);
                    return 0;
                case 4:
                    eci.LOY = aVar3.UbS.readString();
                    AppMethodBeat.o(122550);
                    return 0;
                case 5:
                    eci.flags = aVar3.UbS.zi();
                    AppMethodBeat.o(122550);
                    return 0;
                case 6:
                    eci.LPa = aVar3.UbS.readString();
                    AppMethodBeat.o(122550);
                    return 0;
                case 7:
                    eci.Mhf = aVar3.UbS.readString();
                    AppMethodBeat.o(122550);
                    return 0;
                case 8:
                    eci.Mhg = aVar3.UbS.readString();
                    AppMethodBeat.o(122550);
                    return 0;
                case 9:
                    eci.timestamp = aVar3.UbS.zl();
                    AppMethodBeat.o(122550);
                    return 0;
                default:
                    AppMethodBeat.o(122550);
                    return -1;
            }
        } else {
            AppMethodBeat.o(122550);
            return -1;
        }
    }
}
