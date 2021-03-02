package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public final class fhd extends a {
    public String KRv;
    public int LHK;
    public long UPE;
    public ffq UPF;
    public String UPG;
    public String UPH;
    public String desc;
    public String gTk;
    public String title;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259363);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.UPE);
            if (this.UPF != null) {
                aVar.ni(2, this.UPF.computeSize());
                this.UPF.writeFields(aVar);
            }
            if (this.title != null) {
                aVar.e(3, this.title);
            }
            if (this.KRv != null) {
                aVar.e(4, this.KRv);
            }
            if (this.desc != null) {
                aVar.e(5, this.desc);
            }
            if (this.UPG != null) {
                aVar.e(6, this.UPG);
            }
            if (this.UPH != null) {
                aVar.e(7, this.UPH);
            }
            aVar.aM(8, this.LHK);
            if (this.gTk != null) {
                aVar.e(9, this.gTk);
            }
            AppMethodBeat.o(259363);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.UPE) + 0;
            if (this.UPF != null) {
                r += g.a.a.a.nh(2, this.UPF.computeSize());
            }
            if (this.title != null) {
                r += g.a.a.b.b.a.f(3, this.title);
            }
            if (this.KRv != null) {
                r += g.a.a.b.b.a.f(4, this.KRv);
            }
            if (this.desc != null) {
                r += g.a.a.b.b.a.f(5, this.desc);
            }
            if (this.UPG != null) {
                r += g.a.a.b.b.a.f(6, this.UPG);
            }
            if (this.UPH != null) {
                r += g.a.a.b.b.a.f(7, this.UPH);
            }
            int bu = r + g.a.a.b.b.a.bu(8, this.LHK);
            if (this.gTk != null) {
                bu += g.a.a.b.b.a.f(9, this.gTk);
            }
            AppMethodBeat.o(259363);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259363);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fhd fhd = (fhd) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    fhd.UPE = aVar3.UbS.zl();
                    AppMethodBeat.o(259363);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        ffq ffq = new ffq();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = ffq.populateBuilderWithField(aVar4, ffq, a.getNextFieldNumber(aVar4))) {
                        }
                        fhd.UPF = ffq;
                    }
                    AppMethodBeat.o(259363);
                    return 0;
                case 3:
                    fhd.title = aVar3.UbS.readString();
                    AppMethodBeat.o(259363);
                    return 0;
                case 4:
                    fhd.KRv = aVar3.UbS.readString();
                    AppMethodBeat.o(259363);
                    return 0;
                case 5:
                    fhd.desc = aVar3.UbS.readString();
                    AppMethodBeat.o(259363);
                    return 0;
                case 6:
                    fhd.UPG = aVar3.UbS.readString();
                    AppMethodBeat.o(259363);
                    return 0;
                case 7:
                    fhd.UPH = aVar3.UbS.readString();
                    AppMethodBeat.o(259363);
                    return 0;
                case 8:
                    fhd.LHK = aVar3.UbS.zi();
                    AppMethodBeat.o(259363);
                    return 0;
                case 9:
                    fhd.gTk = aVar3.UbS.readString();
                    AppMethodBeat.o(259363);
                    return 0;
                default:
                    AppMethodBeat.o(259363);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259363);
            return -1;
        }
    }
}
