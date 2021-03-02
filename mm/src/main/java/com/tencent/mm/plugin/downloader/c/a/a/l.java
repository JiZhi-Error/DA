package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class l extends dop {
    public String qGc;
    public o qGd;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153054);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.qGc == null) {
                b bVar = new b("Not all required fields were included: search_key");
                AppMethodBeat.o(153054);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.qGc != null) {
                aVar.e(2, this.qGc);
            }
            if (this.qGd != null) {
                aVar.ni(3, this.qGd.computeSize());
                this.qGd.writeFields(aVar);
            }
            AppMethodBeat.o(153054);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.qGc != null) {
                nh += g.a.a.b.b.a.f(2, this.qGc);
            }
            if (this.qGd != null) {
                nh += g.a.a.a.nh(3, this.qGd.computeSize());
            }
            AppMethodBeat.o(153054);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.qGc == null) {
                b bVar2 = new b("Not all required fields were included: search_key");
                AppMethodBeat.o(153054);
                throw bVar2;
            }
            AppMethodBeat.o(153054);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            l lVar = (l) objArr[1];
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
                        lVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(153054);
                    return 0;
                case 2:
                    lVar.qGc = aVar3.UbS.readString();
                    AppMethodBeat.o(153054);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        o oVar = new o();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = oVar.populateBuilderWithField(aVar5, oVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        lVar.qGd = oVar;
                    }
                    AppMethodBeat.o(153054);
                    return 0;
                default:
                    AppMethodBeat.o(153054);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153054);
            return -1;
        }
    }
}
