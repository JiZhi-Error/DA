package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import g.a.a.c.a;
import java.util.LinkedList;

public final class eee extends dop {
    public LinkedList<dqi> BlackList = new LinkedList<>();
    public int BlackListCount;
    public LinkedList<dqi> GroupUser = new LinkedList<>();
    public int GroupUserCount;
    public SKBuiltinBuffer_t KLP;
    public SKBuiltinBuffer_t Nem;
    public int Neq;
    public String izX;

    public eee() {
        AppMethodBeat.i(118468);
        AppMethodBeat.o(118468);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118469);
        if (i2 == 0) {
            a aVar = (a) objArr[0];
            if (this.Nem == null) {
                b bVar = new b("Not all required fields were included: ObjDesc");
                AppMethodBeat.o(118469);
                throw bVar;
            }
            if (this.BaseRequest != null) {
                aVar.ni(1, this.BaseRequest.computeSize());
                this.BaseRequest.writeFields(aVar);
            }
            if (this.Nem != null) {
                aVar.ni(2, this.Nem.computeSize());
                this.Nem.writeFields(aVar);
            }
            if (this.izX != null) {
                aVar.e(3, this.izX);
            }
            if (this.KLP != null) {
                aVar.ni(4, this.KLP.computeSize());
                this.KLP.writeFields(aVar);
            }
            aVar.aM(5, this.Neq);
            aVar.aM(6, this.BlackListCount);
            aVar.e(7, 8, this.BlackList);
            aVar.aM(8, this.GroupUserCount);
            aVar.e(9, 8, this.GroupUser);
            AppMethodBeat.o(118469);
            return 0;
        } else if (i2 == 1) {
            int nh = this.BaseRequest != null ? g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0 : 0;
            if (this.Nem != null) {
                nh += g.a.a.a.nh(2, this.Nem.computeSize());
            }
            if (this.izX != null) {
                nh += g.a.a.b.b.a.f(3, this.izX);
            }
            if (this.KLP != null) {
                nh += g.a.a.a.nh(4, this.KLP.computeSize());
            }
            int bu = nh + g.a.a.b.b.a.bu(5, this.Neq) + g.a.a.b.b.a.bu(6, this.BlackListCount) + g.a.a.a.c(7, 8, this.BlackList) + g.a.a.b.b.a.bu(8, this.GroupUserCount) + g.a.a.a.c(9, 8, this.GroupUser);
            AppMethodBeat.o(118469);
            return bu;
        } else if (i2 == 2) {
            this.BlackList.clear();
            this.GroupUser.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = dop.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = dop.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Nem == null) {
                b bVar2 = new b("Not all required fields were included: ObjDesc");
                AppMethodBeat.o(118469);
                throw bVar2;
            }
            AppMethodBeat.o(118469);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eee eee = (eee) objArr[1];
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
                        eee.BaseRequest = jrVar;
                    }
                    AppMethodBeat.o(118469);
                    return 0;
                case 2:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = sKBuiltinBuffer_t.populateBuilderWithField(aVar5, sKBuiltinBuffer_t, dop.getNextFieldNumber(aVar5))) {
                        }
                        eee.Nem = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(118469);
                    return 0;
                case 3:
                    eee.izX = aVar3.UbS.readString();
                    AppMethodBeat.o(118469);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar6, sKBuiltinBuffer_t2, dop.getNextFieldNumber(aVar6))) {
                        }
                        eee.KLP = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(118469);
                    return 0;
                case 5:
                    eee.Neq = aVar3.UbS.zi();
                    AppMethodBeat.o(118469);
                    return 0;
                case 6:
                    eee.BlackListCount = aVar3.UbS.zi();
                    AppMethodBeat.o(118469);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi.populateBuilderWithField(aVar7, dqi, dop.getNextFieldNumber(aVar7))) {
                        }
                        eee.BlackList.add(dqi);
                    }
                    AppMethodBeat.o(118469);
                    return 0;
                case 8:
                    eee.GroupUserCount = aVar3.UbS.zi();
                    AppMethodBeat.o(118469);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dqi2.populateBuilderWithField(aVar8, dqi2, dop.getNextFieldNumber(aVar8))) {
                        }
                        eee.GroupUser.add(dqi2);
                    }
                    AppMethodBeat.o(118469);
                    return 0;
                default:
                    AppMethodBeat.o(118469);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118469);
            return -1;
        }
    }
}
