package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ekj extends dop {
    public String KBM;
    public String KHN;
    public String NjB;
    public String Njb;
    public String Njc;
    public String Njt;
    public int yRL;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(72609);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KBM != null) {
                aVar.e(2, this.KBM);
            }
            if (this.KHN != null) {
                aVar.e(3, this.KHN);
            }
            if (this.Njb != null) {
                aVar.e(4, this.Njb);
            }
            if (this.Njc != null) {
                aVar.e(5, this.Njc);
            }
            aVar.aM(6, this.yRL);
            if (this.Njt != null) {
                aVar.e(7, this.Njt);
            }
            if (this.NjB != null) {
                aVar.e(8, this.NjB);
            }
            AppMethodBeat.o(72609);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KBM != null) {
                nh += g.a.a.b.b.a.f(2, this.KBM);
            }
            if (this.KHN != null) {
                nh += g.a.a.b.b.a.f(3, this.KHN);
            }
            if (this.Njb != null) {
                nh += g.a.a.b.b.a.f(4, this.Njb);
            }
            if (this.Njc != null) {
                nh += g.a.a.b.b.a.f(5, this.Njc);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.yRL);
            if (this.Njt != null) {
                bu += g.a.a.b.b.a.f(7, this.Njt);
            }
            if (this.NjB != null) {
                bu += g.a.a.b.b.a.f(8, this.NjB);
            }
            AppMethodBeat.o(72609);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(72609);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ekj ekj = (ekj) objArr[1];
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
                        ekj.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(72609);
                    return 0;
                case 2:
                    ekj.KBM = aVar3.UbS.readString();
                    AppMethodBeat.o(72609);
                    return 0;
                case 3:
                    ekj.KHN = aVar3.UbS.readString();
                    AppMethodBeat.o(72609);
                    return 0;
                case 4:
                    ekj.Njb = aVar3.UbS.readString();
                    AppMethodBeat.o(72609);
                    return 0;
                case 5:
                    ekj.Njc = aVar3.UbS.readString();
                    AppMethodBeat.o(72609);
                    return 0;
                case 6:
                    ekj.yRL = aVar3.UbS.zi();
                    AppMethodBeat.o(72609);
                    return 0;
                case 7:
                    ekj.Njt = aVar3.UbS.readString();
                    AppMethodBeat.o(72609);
                    return 0;
                case 8:
                    ekj.NjB = aVar3.UbS.readString();
                    AppMethodBeat.o(72609);
                    return 0;
                default:
                    AppMethodBeat.o(72609);
                    return -1;
            }
        } else {
            AppMethodBeat.o(72609);
            return -1;
        }
    }
}
