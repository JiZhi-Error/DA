package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eum extends dop {
    public int LsZ;
    public long Lta;
    public String MKC;
    public long NpN;
    public eus NqI;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(115911);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.NqI == null) {
                b bVar = new b("Not all required fields were included: ReportData");
                AppMethodBeat.o(115911);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MKC != null) {
                aVar.e(2, this.MKC);
            }
            aVar.aM(3, this.LsZ);
            aVar.bb(4, this.Lta);
            if (this.NqI != null) {
                aVar.ni(5, this.NqI.computeSize());
                this.NqI.writeFields(aVar);
            }
            aVar.bb(6, this.NpN);
            AppMethodBeat.o(115911);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MKC != null) {
                nh += g.a.a.b.b.a.f(2, this.MKC);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.LsZ) + g.a.a.b.b.a.r(4, this.Lta);
            if (this.NqI != null) {
                bu += g.a.a.a.nh(5, this.NqI.computeSize());
            }
            int r = bu + g.a.a.b.b.a.r(6, this.NpN);
            AppMethodBeat.o(115911);
            return r;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NqI == null) {
                b bVar2 = new b("Not all required fields were included: ReportData");
                AppMethodBeat.o(115911);
                throw bVar2;
            }
            AppMethodBeat.o(115911);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eum eum = (eum) objArr[1];
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
                        eum.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(115911);
                    return 0;
                case 2:
                    eum.MKC = aVar3.UbS.readString();
                    AppMethodBeat.o(115911);
                    return 0;
                case 3:
                    eum.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(115911);
                    return 0;
                case 4:
                    eum.Lta = aVar3.UbS.zl();
                    AppMethodBeat.o(115911);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        eus eus = new eus();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = eus.populateBuilderWithField(aVar5, eus, dop.getNextFieldNumber(aVar5))) {
                        }
                        eum.NqI = eus;
                    }
                    AppMethodBeat.o(115911);
                    return 0;
                case 6:
                    eum.NpN = aVar3.UbS.zl();
                    AppMethodBeat.o(115911);
                    return 0;
                default:
                    AppMethodBeat.o(115911);
                    return -1;
            }
        } else {
            AppMethodBeat.o(115911);
            return -1;
        }
    }
}
