package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bzd extends dop {
    public fdh MeK;
    public fdi MeL;
    public fdj MeM;
    public String jfi;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(50092);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.jfi != null) {
                aVar.e(2, this.jfi);
            }
            if (this.MeK != null) {
                aVar.ni(3, this.MeK.computeSize());
                this.MeK.writeFields(aVar);
            }
            if (this.MeL != null) {
                aVar.ni(6, this.MeL.computeSize());
                this.MeL.writeFields(aVar);
            }
            if (this.MeM != null) {
                aVar.ni(7, this.MeM.computeSize());
                this.MeM.writeFields(aVar);
            }
            AppMethodBeat.o(50092);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.jfi != null) {
                nh += g.a.a.b.b.a.f(2, this.jfi);
            }
            if (this.MeK != null) {
                nh += g.a.a.a.nh(3, this.MeK.computeSize());
            }
            if (this.MeL != null) {
                nh += g.a.a.a.nh(6, this.MeL.computeSize());
            }
            if (this.MeM != null) {
                nh += g.a.a.a.nh(7, this.MeM.computeSize());
            }
            AppMethodBeat.o(50092);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(50092);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bzd bzd = (bzd) objArr[1];
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
                        bzd.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(50092);
                    return 0;
                case 2:
                    bzd.jfi = aVar3.UbS.readString();
                    AppMethodBeat.o(50092);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        fdh fdh = new fdh();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = fdh.populateBuilderWithField(aVar5, fdh, dop.getNextFieldNumber(aVar5))) {
                        }
                        bzd.MeK = fdh;
                    }
                    AppMethodBeat.o(50092);
                    return 0;
                case 4:
                case 5:
                default:
                    AppMethodBeat.o(50092);
                    return -1;
                case 6:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        fdi fdi = new fdi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = fdi.populateBuilderWithField(aVar6, fdi, dop.getNextFieldNumber(aVar6))) {
                        }
                        bzd.MeL = fdi;
                    }
                    AppMethodBeat.o(50092);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        fdj fdj = new fdj();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = fdj.populateBuilderWithField(aVar7, fdj, dop.getNextFieldNumber(aVar7))) {
                        }
                        bzd.MeM = fdj;
                    }
                    AppMethodBeat.o(50092);
                    return 0;
            }
        } else {
            AppMethodBeat.o(50092);
            return -1;
        }
    }
}
