package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fhf extends dop {
    public String LAt;
    public aov LBM;
    public int Vjr;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(259365);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.LBM != null) {
                aVar.ni(2, this.LBM.computeSize());
                this.LBM.writeFields(aVar);
            }
            aVar.aM(3, this.Vjr);
            if (this.LAt != null) {
                aVar.e(4, this.LAt);
            }
            AppMethodBeat.o(259365);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.LBM != null) {
                nh += g.a.a.a.nh(2, this.LBM.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.Vjr);
            if (this.LAt != null) {
                bu += g.a.a.b.b.a.f(4, this.LAt);
            }
            AppMethodBeat.o(259365);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(259365);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fhf fhf = (fhf) objArr[1];
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
                        fhf.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(259365);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aov aov = new aov();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aov.populateBuilderWithField(aVar5, aov, dop.getNextFieldNumber(aVar5))) {
                        }
                        fhf.LBM = aov;
                    }
                    AppMethodBeat.o(259365);
                    return 0;
                case 3:
                    fhf.Vjr = aVar3.UbS.zi();
                    AppMethodBeat.o(259365);
                    return 0;
                case 4:
                    fhf.LAt = aVar3.UbS.readString();
                    AppMethodBeat.o(259365);
                    return 0;
                default:
                    AppMethodBeat.o(259365);
                    return -1;
            }
        } else {
            AppMethodBeat.o(259365);
            return -1;
        }
    }
}