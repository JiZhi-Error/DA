package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ke extends dop {
    public LinkedList<String> KOv = new LinkedList<>();
    public LinkedList<don> KOw = new LinkedList<>();
    public long KOx;
    public int KOy;
    public int KOz;
    public String pLm;

    public ke() {
        AppMethodBeat.i(6394);
        AppMethodBeat.o(6394);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(6395);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 1, this.KOv);
            aVar.e(3, 8, this.KOw);
            if (this.pLm != null) {
                aVar.e(4, this.pLm);
            }
            aVar.bb(5, this.KOx);
            aVar.aM(6, this.KOy);
            aVar.aM(7, this.KOz);
            AppMethodBeat.o(6395);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 1, this.KOv) + g.a.a.a.c(3, 8, this.KOw);
            if (this.pLm != null) {
                nh += g.a.a.b.b.a.f(4, this.pLm);
            }
            int r = nh + g.a.a.b.b.a.r(5, this.KOx) + g.a.a.b.b.a.bu(6, this.KOy) + g.a.a.b.b.a.bu(7, this.KOz);
            AppMethodBeat.o(6395);
            return r;
        } else if (i2 == 2) {
            this.KOv.clear();
            this.KOw.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(6395);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ke keVar = (ke) objArr[1];
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
                        keVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(6395);
                    return 0;
                case 2:
                    keVar.KOv.add(aVar3.UbS.readString());
                    AppMethodBeat.o(6395);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        don don = new don();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = don.populateBuilderWithField(aVar5, don, dop.getNextFieldNumber(aVar5))) {
                        }
                        keVar.KOw.add(don);
                    }
                    AppMethodBeat.o(6395);
                    return 0;
                case 4:
                    keVar.pLm = aVar3.UbS.readString();
                    AppMethodBeat.o(6395);
                    return 0;
                case 5:
                    keVar.KOx = aVar3.UbS.zl();
                    AppMethodBeat.o(6395);
                    return 0;
                case 6:
                    keVar.KOy = aVar3.UbS.zi();
                    AppMethodBeat.o(6395);
                    return 0;
                case 7:
                    keVar.KOz = aVar3.UbS.zi();
                    AppMethodBeat.o(6395);
                    return 0;
                default:
                    AppMethodBeat.o(6395);
                    return -1;
            }
        } else {
            AppMethodBeat.o(6395);
            return -1;
        }
    }
}
