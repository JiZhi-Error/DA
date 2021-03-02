package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ekh extends dop {
    public String Njb;
    public String Njc;
    public String Njd;
    public String Njf;
    public String Njp;
    public int Nju;
    public String Njv;
    public String desc;
    public int yRL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72607);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Njb != null) {
                aVar.e(2, this.Njb);
            }
            if (this.Njc != null) {
                aVar.e(3, this.Njc);
            }
            if (this.Njd != null) {
                aVar.e(4, this.Njd);
            }
            aVar.aM(5, this.yRL);
            if (this.desc != null) {
                aVar.e(6, this.desc);
            }
            aVar.aM(7, this.Nju);
            if (this.Njf != null) {
                aVar.e(8, this.Njf);
            }
            if (this.Njp != null) {
                aVar.e(9, this.Njp);
            }
            if (this.Njv != null) {
                aVar.e(10, this.Njv);
            }
            AppMethodBeat.o(72607);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Njb != null) {
                nh += g.a.a.b.b.a.f(2, this.Njb);
            }
            if (this.Njc != null) {
                nh += g.a.a.b.b.a.f(3, this.Njc);
            }
            if (this.Njd != null) {
                nh += g.a.a.b.b.a.f(4, this.Njd);
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.yRL);
            if (this.desc != null) {
                bu += g.a.a.b.b.a.f(6, this.desc);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.Nju);
            if (this.Njf != null) {
                bu2 += g.a.a.b.b.a.f(8, this.Njf);
            }
            if (this.Njp != null) {
                bu2 += g.a.a.b.b.a.f(9, this.Njp);
            }
            if (this.Njv != null) {
                bu2 += g.a.a.b.b.a.f(10, this.Njv);
            }
            AppMethodBeat.o(72607);
            return bu2;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72607);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ekh ekh = (ekh) objArr[1];
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
                        ekh.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72607);
                    return 0;
                case 2:
                    ekh.Njb = aVar3.UbS.readString();
                    AppMethodBeat.o(72607);
                    return 0;
                case 3:
                    ekh.Njc = aVar3.UbS.readString();
                    AppMethodBeat.o(72607);
                    return 0;
                case 4:
                    ekh.Njd = aVar3.UbS.readString();
                    AppMethodBeat.o(72607);
                    return 0;
                case 5:
                    ekh.yRL = aVar3.UbS.zi();
                    AppMethodBeat.o(72607);
                    return 0;
                case 6:
                    ekh.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(72607);
                    return 0;
                case 7:
                    ekh.Nju = aVar3.UbS.zi();
                    AppMethodBeat.o(72607);
                    return 0;
                case 8:
                    ekh.Njf = aVar3.UbS.readString();
                    AppMethodBeat.o(72607);
                    return 0;
                case 9:
                    ekh.Njp = aVar3.UbS.readString();
                    AppMethodBeat.o(72607);
                    return 0;
                case 10:
                    ekh.Njv = aVar3.UbS.readString();
                    AppMethodBeat.o(72607);
                    return 0;
                default:
                    AppMethodBeat.o(72607);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72607);
            return -1;
        }
    }
}
