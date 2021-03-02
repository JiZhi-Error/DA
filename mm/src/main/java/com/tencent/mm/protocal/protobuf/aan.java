package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class aan extends dop {
    public String KHq;
    public int KRg;
    public String KSV;
    public int LlO;
    public String LlP;
    public LinkedList<aam> LlQ = new LinkedList<>();
    public dvm LlR;
    public dws LlS;
    public int scene;

    public aan() {
        AppMethodBeat.i(124474);
        AppMethodBeat.o(124474);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(124475);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.LlO);
            if (this.LlP != null) {
                aVar.e(3, this.LlP);
            }
            if (this.KSV != null) {
                aVar.e(4, this.KSV);
            }
            if (this.KHq != null) {
                aVar.e(5, this.KHq);
            }
            aVar.e(6, 8, this.LlQ);
            aVar.aM(7, this.scene);
            aVar.aM(8, this.KRg);
            if (this.LlR != null) {
                aVar.ni(9, this.LlR.computeSize());
                this.LlR.writeFields(aVar);
            }
            if (this.LlS != null) {
                aVar.ni(10, this.LlS.computeSize());
                this.LlS.writeFields(aVar);
            }
            AppMethodBeat.o(124475);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.LlO);
            if (this.LlP != null) {
                nh += g.a.a.b.b.a.f(3, this.LlP);
            }
            if (this.KSV != null) {
                nh += g.a.a.b.b.a.f(4, this.KSV);
            }
            if (this.KHq != null) {
                nh += g.a.a.b.b.a.f(5, this.KHq);
            }
            int c2 = nh + g.a.a.a.c(6, 8, this.LlQ) + g.a.a.b.b.a.bu(7, this.scene) + g.a.a.b.b.a.bu(8, this.KRg);
            if (this.LlR != null) {
                c2 += g.a.a.a.nh(9, this.LlR.computeSize());
            }
            if (this.LlS != null) {
                c2 += g.a.a.a.nh(10, this.LlS.computeSize());
            }
            AppMethodBeat.o(124475);
            return c2;
        } else if (i2 == 2) {
            this.LlQ.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(124475);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            aan aan = (aan) objArr[1];
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
                        aan.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(124475);
                    return 0;
                case 2:
                    aan.LlO = aVar3.UbS.zi();
                    AppMethodBeat.o(124475);
                    return 0;
                case 3:
                    aan.LlP = aVar3.UbS.readString();
                    AppMethodBeat.o(124475);
                    return 0;
                case 4:
                    aan.KSV = aVar3.UbS.readString();
                    AppMethodBeat.o(124475);
                    return 0;
                case 5:
                    aan.KHq = aVar3.UbS.readString();
                    AppMethodBeat.o(124475);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aam aam = new aam();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aam.populateBuilderWithField(aVar5, aam, dop.getNextFieldNumber(aVar5))) {
                        }
                        aan.LlQ.add(aam);
                    }
                    AppMethodBeat.o(124475);
                    return 0;
                case 7:
                    aan.scene = aVar3.UbS.zi();
                    AppMethodBeat.o(124475);
                    return 0;
                case 8:
                    aan.KRg = aVar3.UbS.zi();
                    AppMethodBeat.o(124475);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dvm dvm = new dvm();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dvm.populateBuilderWithField(aVar6, dvm, dop.getNextFieldNumber(aVar6))) {
                        }
                        aan.LlR = dvm;
                    }
                    AppMethodBeat.o(124475);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dws dws = new dws();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dws.populateBuilderWithField(aVar7, dws, dop.getNextFieldNumber(aVar7))) {
                        }
                        aan.LlS = dws;
                    }
                    AppMethodBeat.o(124475);
                    return 0;
                default:
                    AppMethodBeat.o(124475);
                    return -1;
            }
        } else {
            AppMethodBeat.o(124475);
            return -1;
        }
    }
}
