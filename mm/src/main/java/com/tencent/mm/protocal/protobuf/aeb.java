package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aeb extends dop {
    public String KTt;
    public bfs Lpw;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124481);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Lpw == null) {
                b bVar = new b("Not all required fields were included: full_chat");
                AppMethodBeat.o(124481);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.KTt != null) {
                aVar.e(2, this.KTt);
            }
            if (this.Lpw != null) {
                aVar.ni(3, this.Lpw.computeSize());
                this.Lpw.writeFields(aVar);
            }
            AppMethodBeat.o(124481);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KTt != null) {
                nh += g.a.a.b.b.a.f(2, this.KTt);
            }
            if (this.Lpw != null) {
                nh += g.a.a.a.nh(3, this.Lpw.computeSize());
            }
            AppMethodBeat.o(124481);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lpw == null) {
                b bVar2 = new b("Not all required fields were included: full_chat");
                AppMethodBeat.o(124481);
                throw bVar2;
            }
            AppMethodBeat.o(124481);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aeb aeb = (aeb) objArr[1];
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
                        aeb.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124481);
                    return 0;
                case 2:
                    aeb.KTt = aVar3.UbS.readString();
                    AppMethodBeat.o(124481);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        bfs bfs = new bfs();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = bfs.populateBuilderWithField(aVar5, bfs, dop.getNextFieldNumber(aVar5))) {
                        }
                        aeb.Lpw = bfs;
                    }
                    AppMethodBeat.o(124481);
                    return 0;
                default:
                    AppMethodBeat.o(124481);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124481);
            return -1;
        }
    }
}
