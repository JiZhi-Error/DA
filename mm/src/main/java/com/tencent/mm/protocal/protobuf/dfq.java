package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class dfq extends dop {
    public int LsZ;
    public dqi MKA;
    public int MKB;
    public long MKi;
    public dqi MKy;
    public dqi MKz;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(32386);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.MKy == null) {
                b bVar = new b("Not all required fields were included: ClientReport");
                AppMethodBeat.o(32386);
                throw bVar;
            } else if (this.MKz == null) {
                b bVar2 = new b("Not all required fields were included: ChannelReport");
                AppMethodBeat.o(32386);
                throw bVar2;
            } else if (this.MKA == null) {
                b bVar3 = new b("Not all required fields were included: EngineReport");
                AppMethodBeat.o(32386);
                throw bVar3;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.MKy != null) {
                    aVar.ni(2, this.MKy.computeSize());
                    this.MKy.writeFields(aVar);
                }
                if (this.MKz != null) {
                    aVar.ni(3, this.MKz.computeSize());
                    this.MKz.writeFields(aVar);
                }
                if (this.MKA != null) {
                    aVar.ni(4, this.MKA.computeSize());
                    this.MKA.writeFields(aVar);
                }
                aVar.aM(5, this.LsZ);
                aVar.bb(6, this.MKi);
                aVar.aM(7, this.MKB);
                AppMethodBeat.o(32386);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.MKy != null) {
                nh += g.a.a.a.nh(2, this.MKy.computeSize());
            }
            if (this.MKz != null) {
                nh += g.a.a.a.nh(3, this.MKz.computeSize());
            }
            if (this.MKA != null) {
                nh += g.a.a.a.nh(4, this.MKA.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.LsZ) + g.a.a.b.b.a.r(6, this.MKi) + g.a.a.b.b.a.bu(7, this.MKB);
            AppMethodBeat.o(32386);
            return bu;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.MKy == null) {
                b bVar4 = new b("Not all required fields were included: ClientReport");
                AppMethodBeat.o(32386);
                throw bVar4;
            } else if (this.MKz == null) {
                b bVar5 = new b("Not all required fields were included: ChannelReport");
                AppMethodBeat.o(32386);
                throw bVar5;
            } else if (this.MKA == null) {
                b bVar6 = new b("Not all required fields were included: EngineReport");
                AppMethodBeat.o(32386);
                throw bVar6;
            } else {
                AppMethodBeat.o(32386);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            dfq dfq = (dfq) objArr[1];
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
                        dfq.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(32386);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        dfq.MKy = dqi;
                    }
                    AppMethodBeat.o(32386);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi2.populateBuilderWithField(aVar6, dqi2, dop.getNextFieldNumber(aVar6))) {
                        }
                        dfq.MKz = dqi2;
                    }
                    AppMethodBeat.o(32386);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi3.populateBuilderWithField(aVar7, dqi3, dop.getNextFieldNumber(aVar7))) {
                        }
                        dfq.MKA = dqi3;
                    }
                    AppMethodBeat.o(32386);
                    return 0;
                case 5:
                    dfq.LsZ = aVar3.UbS.zi();
                    AppMethodBeat.o(32386);
                    return 0;
                case 6:
                    dfq.MKi = aVar3.UbS.zl();
                    AppMethodBeat.o(32386);
                    return 0;
                case 7:
                    dfq.MKB = aVar3.UbS.zi();
                    AppMethodBeat.o(32386);
                    return 0;
                default:
                    AppMethodBeat.o(32386);
                    return -1;
            }
        } else {
            AppMethodBeat.o(32386);
            return -1;
        }
    }
}