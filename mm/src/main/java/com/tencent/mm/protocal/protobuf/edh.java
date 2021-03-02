package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class edh extends dop {
    public edf NdH;
    public edf NdI;
    public int NdJ;
    public int NdK;
    public String SessionId;
    public String izX;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118439);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.NdH == null) {
                b bVar = new b("Not all required fields were included: CommentDetail");
                AppMethodBeat.o(118439);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.izX != null) {
                aVar.e(2, this.izX);
            }
            if (this.NdH != null) {
                aVar.ni(3, this.NdH.computeSize());
                this.NdH.writeFields(aVar);
            }
            if (this.NdI != null) {
                aVar.ni(6, this.NdI.computeSize());
                this.NdI.writeFields(aVar);
            }
            aVar.aM(4, this.NdJ);
            aVar.aM(5, this.NdK);
            if (this.SessionId != null) {
                aVar.e(7, this.SessionId);
            }
            AppMethodBeat.o(118439);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.izX != null) {
                nh += g.a.a.b.b.a.f(2, this.izX);
            }
            if (this.NdH != null) {
                nh += g.a.a.a.nh(3, this.NdH.computeSize());
            }
            if (this.NdI != null) {
                nh += g.a.a.a.nh(6, this.NdI.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(4, this.NdJ) + g.a.a.b.b.a.bu(5, this.NdK);
            if (this.SessionId != null) {
                bu += g.a.a.b.b.a.f(7, this.SessionId);
            }
            AppMethodBeat.o(118439);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.NdH == null) {
                b bVar2 = new b("Not all required fields were included: CommentDetail");
                AppMethodBeat.o(118439);
                throw bVar2;
            }
            AppMethodBeat.o(118439);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            edh edh = (edh) objArr[1];
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
                        edh.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(118439);
                    return 0;
                case 2:
                    edh.izX = aVar3.UbS.readString();
                    AppMethodBeat.o(118439);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        edf edf = new edf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = edf.populateBuilderWithField(aVar5, edf, dop.getNextFieldNumber(aVar5))) {
                        }
                        edh.NdH = edf;
                    }
                    AppMethodBeat.o(118439);
                    return 0;
                case 4:
                    edh.NdJ = aVar3.UbS.zi();
                    AppMethodBeat.o(118439);
                    return 0;
                case 5:
                    edh.NdK = aVar3.UbS.zi();
                    AppMethodBeat.o(118439);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        edf edf2 = new edf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = edf2.populateBuilderWithField(aVar6, edf2, dop.getNextFieldNumber(aVar6))) {
                        }
                        edh.NdI = edf2;
                    }
                    AppMethodBeat.o(118439);
                    return 0;
                case 7:
                    edh.SessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(118439);
                    return 0;
                default:
                    AppMethodBeat.o(118439);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118439);
            return -1;
        }
    }
}
