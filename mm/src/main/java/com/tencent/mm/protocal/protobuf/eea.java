package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public final class eea extends a {
    public LinkedList<dqi> BlackList = new LinkedList<>();
    public int BlackListCount;
    public int CommentCount;
    public int CreateTime;
    public int DeleteFlag;
    public LinkedList<dqi> GroupUser = new LinkedList<>();
    public int GroupUserCount;
    public long Id;
    public int Nej;
    public int Nel;
    public SKBuiltinBuffer_t Nem;
    public LinkedList<edf> Nen = new LinkedList<>();
    public int Neo;
    public LinkedList<edf> Nep = new LinkedList<>();
    public int Neq;
    public int Ner;
    public int Nes;
    public LinkedList<edf> Net = new LinkedList<>();
    public String UserName;
    public String oUJ;

    public eea() {
        AppMethodBeat.i(118461);
        AppMethodBeat.o(118461);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(118462);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.Nem == null) {
                b bVar = new b("Not all required fields were included: ObjDesc");
                AppMethodBeat.o(118462);
                throw bVar;
            }
            aVar.bb(1, this.Id);
            if (this.UserName != null) {
                aVar.e(2, this.UserName);
            }
            if (this.oUJ != null) {
                aVar.e(3, this.oUJ);
            }
            aVar.aM(4, this.CreateTime);
            aVar.aM(5, this.Nel);
            if (this.Nem != null) {
                aVar.ni(6, this.Nem.computeSize());
                this.Nem.writeFields(aVar);
            }
            aVar.aM(7, this.CommentCount);
            aVar.e(8, 8, this.Nen);
            aVar.aM(9, this.Neo);
            aVar.e(10, 8, this.Nep);
            aVar.aM(11, this.DeleteFlag);
            aVar.aM(12, this.Neq);
            aVar.aM(13, this.Nej);
            aVar.aM(14, this.Ner);
            aVar.aM(15, this.BlackListCount);
            aVar.e(16, 8, this.BlackList);
            aVar.aM(17, this.GroupUserCount);
            aVar.e(18, 8, this.GroupUser);
            aVar.aM(19, this.Nes);
            aVar.e(20, 8, this.Net);
            AppMethodBeat.o(118462);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Id) + 0;
            if (this.UserName != null) {
                r += g.a.a.b.b.a.f(2, this.UserName);
            }
            if (this.oUJ != null) {
                r += g.a.a.b.b.a.f(3, this.oUJ);
            }
            int bu = r + g.a.a.b.b.a.bu(4, this.CreateTime) + g.a.a.b.b.a.bu(5, this.Nel);
            if (this.Nem != null) {
                bu += g.a.a.a.nh(6, this.Nem.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(7, this.CommentCount) + g.a.a.a.c(8, 8, this.Nen) + g.a.a.b.b.a.bu(9, this.Neo) + g.a.a.a.c(10, 8, this.Nep) + g.a.a.b.b.a.bu(11, this.DeleteFlag) + g.a.a.b.b.a.bu(12, this.Neq) + g.a.a.b.b.a.bu(13, this.Nej) + g.a.a.b.b.a.bu(14, this.Ner) + g.a.a.b.b.a.bu(15, this.BlackListCount) + g.a.a.a.c(16, 8, this.BlackList) + g.a.a.b.b.a.bu(17, this.GroupUserCount) + g.a.a.a.c(18, 8, this.GroupUser) + g.a.a.b.b.a.bu(19, this.Nes) + g.a.a.a.c(20, 8, this.Net);
            AppMethodBeat.o(118462);
            return bu2;
        } else if (i2 == 2) {
            this.Nen.clear();
            this.Nep.clear();
            this.BlackList.clear();
            this.GroupUser.clear();
            this.Net.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.Nem == null) {
                b bVar2 = new b("Not all required fields were included: ObjDesc");
                AppMethodBeat.o(118462);
                throw bVar2;
            }
            AppMethodBeat.o(118462);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            eea eea = (eea) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    eea.Id = aVar3.UbS.zl();
                    AppMethodBeat.o(118462);
                    return 0;
                case 2:
                    eea.UserName = aVar3.UbS.readString();
                    AppMethodBeat.o(118462);
                    return 0;
                case 3:
                    eea.oUJ = aVar3.UbS.readString();
                    AppMethodBeat.o(118462);
                    return 0;
                case 4:
                    eea.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(118462);
                    return 0;
                case 5:
                    eea.Nel = aVar3.UbS.zi();
                    AppMethodBeat.o(118462);
                    return 0;
                case 6:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        eea.Nem = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(118462);
                    return 0;
                case 7:
                    eea.CommentCount = aVar3.UbS.zi();
                    AppMethodBeat.o(118462);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        edf edf = new edf();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = edf.populateBuilderWithField(aVar5, edf, a.getNextFieldNumber(aVar5))) {
                        }
                        eea.Nen.add(edf);
                    }
                    AppMethodBeat.o(118462);
                    return 0;
                case 9:
                    eea.Neo = aVar3.UbS.zi();
                    AppMethodBeat.o(118462);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        edf edf2 = new edf();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = edf2.populateBuilderWithField(aVar6, edf2, a.getNextFieldNumber(aVar6))) {
                        }
                        eea.Nep.add(edf2);
                    }
                    AppMethodBeat.o(118462);
                    return 0;
                case 11:
                    eea.DeleteFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(118462);
                    return 0;
                case 12:
                    eea.Neq = aVar3.UbS.zi();
                    AppMethodBeat.o(118462);
                    return 0;
                case 13:
                    eea.Nej = aVar3.UbS.zi();
                    AppMethodBeat.o(118462);
                    return 0;
                case 14:
                    eea.Ner = aVar3.UbS.zi();
                    AppMethodBeat.o(118462);
                    return 0;
                case 15:
                    eea.BlackListCount = aVar3.UbS.zi();
                    AppMethodBeat.o(118462);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dqi.populateBuilderWithField(aVar7, dqi, a.getNextFieldNumber(aVar7))) {
                        }
                        eea.BlackList.add(dqi);
                    }
                    AppMethodBeat.o(118462);
                    return 0;
                case 17:
                    eea.GroupUserCount = aVar3.UbS.zi();
                    AppMethodBeat.o(118462);
                    return 0;
                case 18:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dqi2.populateBuilderWithField(aVar8, dqi2, a.getNextFieldNumber(aVar8))) {
                        }
                        eea.GroupUser.add(dqi2);
                    }
                    AppMethodBeat.o(118462);
                    return 0;
                case 19:
                    eea.Nes = aVar3.UbS.zi();
                    AppMethodBeat.o(118462);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        edf edf3 = new edf();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = edf3.populateBuilderWithField(aVar9, edf3, a.getNextFieldNumber(aVar9))) {
                        }
                        eea.Net.add(edf3);
                    }
                    AppMethodBeat.o(118462);
                    return 0;
                default:
                    AppMethodBeat.o(118462);
                    return -1;
            }
        } else {
            AppMethodBeat.o(118462);
            return -1;
        }
    }
}
