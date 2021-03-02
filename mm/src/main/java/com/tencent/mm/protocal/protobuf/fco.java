package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class fco extends dop {
    public LinkedList<cpc> Nyv = new LinkedList<>();
    public String appId;

    public fco() {
        AppMethodBeat.i(147823);
        AppMethodBeat.o(147823);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(147824);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.appId != null) {
                aVar.e(2, this.appId);
            }
            aVar.e(3, 8, this.Nyv);
            AppMethodBeat.o(147824);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.appId != null) {
                nh += g.a.a.b.b.a.f(2, this.appId);
            }
            int c2 = nh + g.a.a.a.c(3, 8, this.Nyv);
            AppMethodBeat.o(147824);
            return c2;
        } else if (i2 == 2) {
            this.Nyv.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(147824);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            fco fco = (fco) objArr[1];
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
                        fco.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(147824);
                    return 0;
                case 2:
                    fco.appId = aVar3.UbS.readString();
                    AppMethodBeat.o(147824);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cpc cpc = new cpc();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cpc.populateBuilderWithField(aVar5, cpc, dop.getNextFieldNumber(aVar5))) {
                        }
                        fco.Nyv.add(cpc);
                    }
                    AppMethodBeat.o(147824);
                    return 0;
                default:
                    AppMethodBeat.o(147824);
                    return -1;
            }
        } else {
            AppMethodBeat.o(147824);
            return -1;
        }
    }
}
