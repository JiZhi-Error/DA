package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class diw extends dop {
    public dks MNc;
    public dkl MNd;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50098);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.MNc != null) {
                aVar.ni(2, this.MNc.computeSize());
                this.MNc.writeFields(aVar);
            }
            if (this.MNd != null) {
                aVar.ni(3, this.MNd.computeSize());
                this.MNd.writeFields(aVar);
            }
            AppMethodBeat.o(50098);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MNc != null) {
                nh += g.a.a.a.nh(2, this.MNc.computeSize());
            }
            if (this.MNd != null) {
                nh += g.a.a.a.nh(3, this.MNd.computeSize());
            }
            AppMethodBeat.o(50098);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50098);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            diw diw = (diw) objArr[1];
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
                        diw.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(50098);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dks dks = new dks();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dks.populateBuilderWithField(aVar5, dks, dop.getNextFieldNumber(aVar5))) {
                        }
                        diw.MNc = dks;
                    }
                    AppMethodBeat.o(50098);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dkl dkl = new dkl();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dkl.populateBuilderWithField(aVar6, dkl, dop.getNextFieldNumber(aVar6))) {
                        }
                        diw.MNd = dkl;
                    }
                    AppMethodBeat.o(50098);
                    return 0;
                default:
                    AppMethodBeat.o(50098);
                    return -1;
            }
        } else {
            AppMethodBeat.o(50098);
            return -1;
        }
    }
}
