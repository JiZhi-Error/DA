package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class emo extends dop {
    public int NkL;
    public ajt NkM;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(153311);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            aVar.aM(3, this.NkL);
            if (this.NkM != null) {
                aVar.ni(4, this.NkM.computeSize());
                this.NkM.writeFields(aVar);
            }
            AppMethodBeat.o(153311);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.username != null) {
                nh += g.a.a.b.b.a.f(2, this.username);
            }
            int bu = nh + g.a.a.b.b.a.bu(3, this.NkL);
            if (this.NkM != null) {
                bu += g.a.a.a.nh(4, this.NkM.computeSize());
            }
            AppMethodBeat.o(153311);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(153311);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            emo emo = (emo) objArr[1];
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
                        emo.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(153311);
                    return 0;
                case 2:
                    emo.username = aVar3.UbS.readString();
                    AppMethodBeat.o(153311);
                    return 0;
                case 3:
                    emo.NkL = aVar3.UbS.zi();
                    AppMethodBeat.o(153311);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ajt ajt = new ajt();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ajt.populateBuilderWithField(aVar5, ajt, dop.getNextFieldNumber(aVar5))) {
                        }
                        emo.NkM = ajt;
                    }
                    AppMethodBeat.o(153311);
                    return 0;
                default:
                    AppMethodBeat.o(153311);
                    return -1;
            }
        } else {
            AppMethodBeat.o(153311);
            return -1;
        }
    }
}
