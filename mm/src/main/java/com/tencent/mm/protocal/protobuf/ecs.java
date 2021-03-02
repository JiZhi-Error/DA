package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c.a;
import java.util.LinkedList;

public final class ecs extends dop {
    public String KIz;
    public int NcY;
    public int NcZ;
    public LinkedList<ecu> Nda = new LinkedList<>();
    public ecr Ndb;
    public int Ndc;
    public LinkedList<ecr> Ndd = new LinkedList<>();
    public String xNG;
    public String xNH;

    public ecs() {
        AppMethodBeat.i(152697);
        AppMethodBeat.o(152697);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(152698);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            aVar.aM(2, this.NcY);
            if (this.xNH != null) {
                aVar.e(3, this.xNH);
            }
            if (this.xNG != null) {
                aVar.e(4, this.xNG);
            }
            if (this.KIz != null) {
                aVar.e(5, this.KIz);
            }
            aVar.aM(6, this.NcZ);
            aVar.e(7, 8, this.Nda);
            if (this.Ndb != null) {
                aVar.ni(8, this.Ndb.computeSize());
                this.Ndb.writeFields(aVar);
            }
            aVar.aM(9, this.Ndc);
            aVar.e(10, 8, this.Ndd);
            AppMethodBeat.o(152698);
            return 0;
        } else if (i2 == 1) {
            int nh = (this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0) + g.a.a.b.b.a.bu(2, this.NcY);
            if (this.xNH != null) {
                nh += g.a.a.b.b.a.f(3, this.xNH);
            }
            if (this.xNG != null) {
                nh += g.a.a.b.b.a.f(4, this.xNG);
            }
            if (this.KIz != null) {
                nh += g.a.a.b.b.a.f(5, this.KIz);
            }
            int bu = nh + g.a.a.b.b.a.bu(6, this.NcZ) + g.a.a.a.c(7, 8, this.Nda);
            if (this.Ndb != null) {
                bu += g.a.a.a.nh(8, this.Ndb.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(9, this.Ndc) + g.a.a.a.c(10, 8, this.Ndd);
            AppMethodBeat.o(152698);
            return bu2;
        } else if (i2 == 2) {
            this.Nda.clear();
            this.Ndd.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(152698);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            ecs ecs = (ecs) objArr[1];
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
                        ecs.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(152698);
                    return 0;
                case 2:
                    ecs.NcY = aVar3.UbS.zi();
                    AppMethodBeat.o(152698);
                    return 0;
                case 3:
                    ecs.xNH = aVar3.UbS.readString();
                    AppMethodBeat.o(152698);
                    return 0;
                case 4:
                    ecs.xNG = aVar3.UbS.readString();
                    AppMethodBeat.o(152698);
                    return 0;
                case 5:
                    ecs.KIz = aVar3.UbS.readString();
                    AppMethodBeat.o(152698);
                    return 0;
                case 6:
                    ecs.NcZ = aVar3.UbS.zi();
                    AppMethodBeat.o(152698);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        ecu ecu = new ecu();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = ecu.populateBuilderWithField(aVar5, ecu, dop.getNextFieldNumber(aVar5))) {
                        }
                        ecs.Nda.add(ecu);
                    }
                    AppMethodBeat.o(152698);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        ecr ecr = new ecr();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = ecr.populateBuilderWithField(aVar6, ecr, dop.getNextFieldNumber(aVar6))) {
                        }
                        ecs.Ndb = ecr;
                    }
                    AppMethodBeat.o(152698);
                    return 0;
                case 9:
                    ecs.Ndc = aVar3.UbS.zi();
                    AppMethodBeat.o(152698);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        ecr ecr2 = new ecr();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = ecr2.populateBuilderWithField(aVar7, ecr2, dop.getNextFieldNumber(aVar7))) {
                        }
                        ecs.Ndd.add(ecr2);
                    }
                    AppMethodBeat.o(152698);
                    return 0;
                default:
                    AppMethodBeat.o(152698);
                    return -1;
            }
        } else {
            AppMethodBeat.o(152698);
            return -1;
        }
    }
}
