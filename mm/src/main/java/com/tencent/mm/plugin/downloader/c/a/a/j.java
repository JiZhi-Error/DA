package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class j extends dop {
    public String gqB;
    public String qFZ;
    public String source;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153052);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.gqB == null) {
                b bVar = new b("Not all required fields were included: download_url");
                AppMethodBeat.o(153052);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.gqB != null) {
                aVar.e(2, this.gqB);
            }
            if (this.qFZ != null) {
                aVar.e(3, this.qFZ);
            }
            if (this.source != null) {
                aVar.e(4, this.source);
            }
            AppMethodBeat.o(153052);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.gqB != null) {
                nh += g.a.a.b.b.a.f(2, this.gqB);
            }
            if (this.qFZ != null) {
                nh += g.a.a.b.b.a.f(3, this.qFZ);
            }
            if (this.source != null) {
                nh += g.a.a.b.b.a.f(4, this.source);
            }
            AppMethodBeat.o(153052);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.gqB == null) {
                b bVar2 = new b("Not all required fields were included: download_url");
                AppMethodBeat.o(153052);
                throw bVar2;
            }
            AppMethodBeat.o(153052);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            j jVar = (j) objArr[1];
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
                        jVar.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(153052);
                    return 0;
                case 2:
                    jVar.gqB = aVar3.UbS.readString();
                    AppMethodBeat.o(153052);
                    return 0;
                case 3:
                    jVar.qFZ = aVar3.UbS.readString();
                    AppMethodBeat.o(153052);
                    return 0;
                case 4:
                    jVar.source = aVar3.UbS.readString();
                    AppMethodBeat.o(153052);
                    return 0;
                default:
                    AppMethodBeat.o(153052);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153052);
            return -1;
        }
    }
}
