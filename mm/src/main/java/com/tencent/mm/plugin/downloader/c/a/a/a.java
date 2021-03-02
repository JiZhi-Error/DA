package com.tencent.mm.plugin.downloader.c.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dop;
import com.tencent.mm.protocal.protobuf.jr;
import java.util.LinkedList;

public final class a extends dop {
    public LinkedList<String> qFI = new LinkedList<>();
    public boolean qFJ;
    public boolean qFK;
    public boolean qFL;

    public a() {
        AppMethodBeat.i(153039);
        AppMethodBeat.o(153039);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153040);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.e(2, 1, this.qFI);
            aVar.cc(3, this.qFJ);
            aVar.cc(4, this.qFK);
            aVar.cc(5, this.qFL);
            AppMethodBeat.o(153040);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.a.c(2, 1, this.qFI) + g.a.a.b.b.a.fS(3) + 1 + g.a.a.b.b.a.fS(4) + 1 + g.a.a.b.b.a.fS(5) + 1;
            AppMethodBeat.o(153040);
            return nh;
        } else if (i2 == 2) {
            this.qFI.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153040);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        jr jrVar = new jr();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = jrVar.populateBuilderWithField(aVar5, jrVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        aVar4.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(153040);
                    return 0;
                case 2:
                    aVar4.qFI.add(aVar3.UbS.readString());
                    AppMethodBeat.o(153040);
                    return 0;
                case 3:
                    aVar4.qFJ = aVar3.UbS.yZ();
                    AppMethodBeat.o(153040);
                    return 0;
                case 4:
                    aVar4.qFK = aVar3.UbS.yZ();
                    AppMethodBeat.o(153040);
                    return 0;
                case 5:
                    aVar4.qFL = aVar3.UbS.yZ();
                    AppMethodBeat.o(153040);
                    return 0;
                default:
                    AppMethodBeat.o(153040);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153040);
            return -1;
        }
    }
}
