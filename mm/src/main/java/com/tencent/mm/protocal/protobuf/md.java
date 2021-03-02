package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class md extends dop {
    public int KMz;
    public int KPF;
    public String KPG;
    public String KPH;
    public String KPI;
    public String KPJ;
    public String KPK;
    public String KPL;
    public String KPM;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155394);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.KMz);
            aVar.aM(3, this.KPF);
            if (this.KPG != null) {
                aVar.e(4, this.KPG);
            }
            if (this.KPH != null) {
                aVar.e(5, this.KPH);
            }
            if (this.KPI != null) {
                aVar.e(6, this.KPI);
            }
            if (this.KPJ != null) {
                aVar.e(7, this.KPJ);
            }
            if (this.KPK != null) {
                aVar.e(8, this.KPK);
            }
            if (this.KPL != null) {
                aVar.e(9, this.KPL);
            }
            if (this.KPM != null) {
                aVar.e(10, this.KPM);
            }
            AppMethodBeat.o(155394);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.KMz) + g.a.a.b.b.a.bu(3, this.KPF);
            if (this.KPG != null) {
                nh += g.a.a.b.b.a.f(4, this.KPG);
            }
            if (this.KPH != null) {
                nh += g.a.a.b.b.a.f(5, this.KPH);
            }
            if (this.KPI != null) {
                nh += g.a.a.b.b.a.f(6, this.KPI);
            }
            if (this.KPJ != null) {
                nh += g.a.a.b.b.a.f(7, this.KPJ);
            }
            if (this.KPK != null) {
                nh += g.a.a.b.b.a.f(8, this.KPK);
            }
            if (this.KPL != null) {
                nh += g.a.a.b.b.a.f(9, this.KPL);
            }
            if (this.KPM != null) {
                nh += g.a.a.b.b.a.f(10, this.KPM);
            }
            AppMethodBeat.o(155394);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(155394);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            md mdVar = (md) objArr[1];
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
                        mdVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(155394);
                    return 0;
                case 2:
                    mdVar.KMz = aVar3.UbS.zi();
                    AppMethodBeat.o(155394);
                    return 0;
                case 3:
                    mdVar.KPF = aVar3.UbS.zi();
                    AppMethodBeat.o(155394);
                    return 0;
                case 4:
                    mdVar.KPG = aVar3.UbS.readString();
                    AppMethodBeat.o(155394);
                    return 0;
                case 5:
                    mdVar.KPH = aVar3.UbS.readString();
                    AppMethodBeat.o(155394);
                    return 0;
                case 6:
                    mdVar.KPI = aVar3.UbS.readString();
                    AppMethodBeat.o(155394);
                    return 0;
                case 7:
                    mdVar.KPJ = aVar3.UbS.readString();
                    AppMethodBeat.o(155394);
                    return 0;
                case 8:
                    mdVar.KPK = aVar3.UbS.readString();
                    AppMethodBeat.o(155394);
                    return 0;
                case 9:
                    mdVar.KPL = aVar3.UbS.readString();
                    AppMethodBeat.o(155394);
                    return 0;
                case 10:
                    mdVar.KPM = aVar3.UbS.readString();
                    AppMethodBeat.o(155394);
                    return 0;
                default:
                    AppMethodBeat.o(155394);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155394);
            return -1;
        }
    }
}
