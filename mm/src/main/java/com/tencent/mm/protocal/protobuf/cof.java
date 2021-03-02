package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class cof extends dop {
    public cnl MtG;
    public cnh MtV;
    public String clientId;
    public String username;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(209764);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.username != null) {
                aVar.e(2, this.username);
            }
            if (this.clientId != null) {
                aVar.e(3, this.clientId);
            }
            if (this.MtG != null) {
                aVar.ni(4, this.MtG.computeSize());
                this.MtG.writeFields(aVar);
            }
            if (this.MtV != null) {
                aVar.ni(5, this.MtV.computeSize());
                this.MtV.writeFields(aVar);
            }
            AppMethodBeat.o(209764);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.username != null) {
                nh += g.a.a.b.b.a.f(2, this.username);
            }
            if (this.clientId != null) {
                nh += g.a.a.b.b.a.f(3, this.clientId);
            }
            if (this.MtG != null) {
                nh += g.a.a.a.nh(4, this.MtG.computeSize());
            }
            if (this.MtV != null) {
                nh += g.a.a.a.nh(5, this.MtV.computeSize());
            }
            AppMethodBeat.o(209764);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(209764);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            cof cof = (cof) objArr[1];
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
                        cof.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(209764);
                    return 0;
                case 2:
                    cof.username = aVar3.UbS.readString();
                    AppMethodBeat.o(209764);
                    return 0;
                case 3:
                    cof.clientId = aVar3.UbS.readString();
                    AppMethodBeat.o(209764);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        cnl cnl = new cnl();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = cnl.populateBuilderWithField(aVar5, cnl, dop.getNextFieldNumber(aVar5))) {
                        }
                        cof.MtG = cnl;
                    }
                    AppMethodBeat.o(209764);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        cnh cnh = new cnh();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = cnh.populateBuilderWithField(aVar6, cnh, dop.getNextFieldNumber(aVar6))) {
                        }
                        cof.MtV = cnh;
                    }
                    AppMethodBeat.o(209764);
                    return 0;
                default:
                    AppMethodBeat.o(209764);
                    return -1;
            }
        } else {
            AppMethodBeat.o(209764);
            return -1;
        }
    }
}
