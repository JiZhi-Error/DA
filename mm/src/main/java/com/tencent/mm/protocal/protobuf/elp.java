package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class elp extends dop {
    public String KTl;
    public String KTt;
    public nw NkD;
    public nw NkE;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124570);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.KTt == null) {
                b bVar = new b("Not all required fields were included: brand_user_name");
                AppMethodBeat.o(124570);
                throw bVar;
            } else if (this.KTl == null) {
                b bVar2 = new b("Not all required fields were included: bizchat_id");
                AppMethodBeat.o(124570);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.KTt != null) {
                    aVar.e(2, this.KTt);
                }
                if (this.KTl != null) {
                    aVar.e(3, this.KTl);
                }
                if (this.NkD != null) {
                    aVar.ni(4, this.NkD.computeSize());
                    this.NkD.writeFields(aVar);
                }
                if (this.NkE != null) {
                    aVar.ni(5, this.NkE.computeSize());
                    this.NkE.writeFields(aVar);
                }
                AppMethodBeat.o(124570);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.KTt != null) {
                nh += g.a.a.b.b.a.f(2, this.KTt);
            }
            if (this.KTl != null) {
                nh += g.a.a.b.b.a.f(3, this.KTl);
            }
            if (this.NkD != null) {
                nh += g.a.a.a.nh(4, this.NkD.computeSize());
            }
            if (this.NkE != null) {
                nh += g.a.a.a.nh(5, this.NkE.computeSize());
            }
            AppMethodBeat.o(124570);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.KTt == null) {
                b bVar3 = new b("Not all required fields were included: brand_user_name");
                AppMethodBeat.o(124570);
                throw bVar3;
            } else if (this.KTl == null) {
                b bVar4 = new b("Not all required fields were included: bizchat_id");
                AppMethodBeat.o(124570);
                throw bVar4;
            } else {
                AppMethodBeat.o(124570);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            elp elp = (elp) objArr[1];
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
                        elp.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124570);
                    return 0;
                case 2:
                    elp.KTt = aVar3.UbS.readString();
                    AppMethodBeat.o(124570);
                    return 0;
                case 3:
                    elp.KTl = aVar3.UbS.readString();
                    AppMethodBeat.o(124570);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        nw nwVar = new nw();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = nwVar.populateBuilderWithField(aVar5, nwVar, dop.getNextFieldNumber(aVar5))) {
                        }
                        elp.NkD = nwVar;
                    }
                    AppMethodBeat.o(124570);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        nw nwVar2 = new nw();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = nwVar2.populateBuilderWithField(aVar6, nwVar2, dop.getNextFieldNumber(aVar6))) {
                        }
                        elp.NkE = nwVar2;
                    }
                    AppMethodBeat.o(124570);
                    return 0;
                default:
                    AppMethodBeat.o(124570);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124570);
            return -1;
        }
    }
}
