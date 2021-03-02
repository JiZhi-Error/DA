package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fj extends dop {
    public LinkedList<acd> KII = new LinkedList<>();
    public int KIJ;
    public int KIK;
    public String session_id;
    public String url;

    public fj() {
        AppMethodBeat.i(103186);
        AppMethodBeat.o(103186);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(103187);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.url != null) {
                aVar.e(2, this.url);
            }
            aVar.e(4, 8, this.KII);
            if (this.session_id != null) {
                aVar.e(5, this.session_id);
            }
            aVar.aM(6, this.KIJ);
            aVar.aM(7, this.KIK);
            AppMethodBeat.o(103187);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.url != null) {
                nh += g.a.a.b.b.a.f(2, this.url);
            }
            int c2 = nh + g.a.a.a.c(4, 8, this.KII);
            if (this.session_id != null) {
                c2 += g.a.a.b.b.a.f(5, this.session_id);
            }
            int bu = c2 + g.a.a.b.b.a.bu(6, this.KIJ) + g.a.a.b.b.a.bu(7, this.KIK);
            AppMethodBeat.o(103187);
            return bu;
        } else if (i2 == 2) {
            this.KII.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(103187);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fj fjVar = (fj) objArr[1];
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
                        fjVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(103187);
                    return 0;
                case 2:
                    fjVar.url = aVar3.UbS.readString();
                    AppMethodBeat.o(103187);
                    return 0;
                case 3:
                default:
                    AppMethodBeat.o(103187);
                    return -1;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        acd acd = new acd();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = acd.populateBuilderWithField(aVar5, acd, dop.getNextFieldNumber(aVar5))) {
                        }
                        fjVar.KII.add(acd);
                    }
                    AppMethodBeat.o(103187);
                    return 0;
                case 5:
                    fjVar.session_id = aVar3.UbS.readString();
                    AppMethodBeat.o(103187);
                    return 0;
                case 6:
                    fjVar.KIJ = aVar3.UbS.zi();
                    AppMethodBeat.o(103187);
                    return 0;
                case 7:
                    fjVar.KIK = aVar3.UbS.zi();
                    AppMethodBeat.o(103187);
                    return 0;
            }
        } else {
            AppMethodBeat.o(103187);
            return -1;
        }
    }
}
