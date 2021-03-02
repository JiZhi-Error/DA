package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class bxj extends dop {
    public SKBuiltinBuffer_t KPW;
    public dqi Lqk;
    public dqi Mdi;
    public dqi Mdj;
    public SKBuiltinBuffer_t Mdk;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(155420);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Lqk == null) {
                b bVar = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(155420);
                throw bVar;
            } else if (this.Mdi == null) {
                b bVar2 = new b("Not all required fields were included: Pwd");
                AppMethodBeat.o(155420);
                throw bVar2;
            } else {
                if (this.BaseRequest != null) {
                    aVar.ni(1, this.BaseRequest.computeSize());
                    this.BaseRequest.writeFields(aVar);
                }
                if (this.Lqk != null) {
                    aVar.ni(2, this.Lqk.computeSize());
                    this.Lqk.writeFields(aVar);
                }
                if (this.Mdi != null) {
                    aVar.ni(3, this.Mdi.computeSize());
                    this.Mdi.writeFields(aVar);
                }
                if (this.Mdj != null) {
                    aVar.ni(4, this.Mdj.computeSize());
                    this.Mdj.writeFields(aVar);
                }
                if (this.KPW != null) {
                    aVar.ni(5, this.KPW.computeSize());
                    this.KPW.writeFields(aVar);
                }
                if (this.Mdk != null) {
                    aVar.ni(6, this.Mdk.computeSize());
                    this.Mdk.writeFields(aVar);
                }
                AppMethodBeat.o(155420);
                return 0;
            }
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Lqk != null) {
                nh += g.a.a.a.nh(2, this.Lqk.computeSize());
            }
            if (this.Mdi != null) {
                nh += g.a.a.a.nh(3, this.Mdi.computeSize());
            }
            if (this.Mdj != null) {
                nh += g.a.a.a.nh(4, this.Mdj.computeSize());
            }
            if (this.KPW != null) {
                nh += g.a.a.a.nh(5, this.KPW.computeSize());
            }
            if (this.Mdk != null) {
                nh += g.a.a.a.nh(6, this.Mdk.computeSize());
            }
            AppMethodBeat.o(155420);
            return nh;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Lqk == null) {
                b bVar3 = new b("Not all required fields were included: UserName");
                AppMethodBeat.o(155420);
                throw bVar3;
            } else if (this.Mdi == null) {
                b bVar4 = new b("Not all required fields were included: Pwd");
                AppMethodBeat.o(155420);
                throw bVar4;
            } else {
                AppMethodBeat.o(155420);
                return 0;
            }
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            bxj bxj = (bxj) objArr[1];
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
                        bxj.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(155420);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dqi.populateBuilderWithField(aVar5, dqi, dop.getNextFieldNumber(aVar5))) {
                        }
                        bxj.Lqk = dqi;
                    }
                    AppMethodBeat.o(155420);
                    return 0;
                case 3:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dqi2.populateBuilderWithField(aVar6, dqi2, dop.getNextFieldNumber(aVar6))) {
                        }
                        bxj.Mdi = dqi2;
                    }
                    AppMethodBeat.o(155420);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi3 = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi3.populateBuilderWithField(aVar7, dqi3, dop.getNextFieldNumber(aVar7))) {
                        }
                        bxj.Mdj = dqi3;
                    }
                    AppMethodBeat.o(155420);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = sKBuiltinBuffer_t.populateBuilderWithField(aVar8, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar8))) {
                        }
                        bxj.KPW = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(155420);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar9, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar9))) {
                        }
                        bxj.Mdk = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(155420);
                    return 0;
                default:
                    AppMethodBeat.o(155420);
                    return -1;
            }
        } else {
            AppMethodBeat.o(155420);
            return -1;
        }
    }
}
