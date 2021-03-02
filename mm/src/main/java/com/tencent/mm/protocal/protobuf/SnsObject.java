package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import g.a.a.b;
import java.util.LinkedList;

public class SnsObject extends a {
    public LinkedList<dqi> BlackList = new LinkedList<>();
    public int BlackListCount;
    public int CommentCount;
    public LinkedList<dzo> CommentUserList = new LinkedList<>();
    public int CommentUserListCount;
    public int CreateTime;
    public int DeleteFlag;
    public int ExtFlag;
    public int GroupCount;
    public LinkedList<dzw> GroupList = new LinkedList<>();
    public LinkedList<dqi> GroupUser = new LinkedList<>();
    public int GroupUserCount;
    public long Id;
    public int IsNotRichText;
    public int LikeCount;
    public int LikeFlag;
    public LinkedList<dzo> LikeUserList = new LinkedList<>();
    public int LikeUserListCount;
    public String Nickname;
    public int NoChange;
    public SKBuiltinBuffer_t ObjectDesc;
    public SKBuiltinBuffer_t ObjectOperations;
    public ddw PreDownloadInfo;
    public long ReferId;
    public String ReferUsername;
    public ear SnsRedEnvelops;
    public String Username;
    public dzk WeAppInfo;
    public int WithUserCount;
    public LinkedList<dzo> WithUserList = new LinkedList<>();
    public int WithUserListCount;

    public SnsObject() {
        AppMethodBeat.i(125791);
        AppMethodBeat.o(125791);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(125792);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.ObjectDesc == null) {
                b bVar = new b("Not all required fields were included: ObjectDesc");
                AppMethodBeat.o(125792);
                throw bVar;
            }
            aVar.bb(1, this.Id);
            if (this.Username != null) {
                aVar.e(2, this.Username);
            }
            if (this.Nickname != null) {
                aVar.e(3, this.Nickname);
            }
            aVar.aM(4, this.CreateTime);
            if (this.ObjectDesc != null) {
                aVar.ni(5, this.ObjectDesc.computeSize());
                this.ObjectDesc.writeFields(aVar);
            }
            aVar.aM(6, this.LikeFlag);
            aVar.aM(7, this.LikeCount);
            aVar.aM(8, this.LikeUserListCount);
            aVar.e(9, 8, this.LikeUserList);
            aVar.aM(10, this.CommentCount);
            aVar.aM(11, this.CommentUserListCount);
            aVar.e(12, 8, this.CommentUserList);
            aVar.aM(13, this.WithUserCount);
            aVar.aM(14, this.WithUserListCount);
            aVar.e(15, 8, this.WithUserList);
            aVar.aM(16, this.ExtFlag);
            aVar.aM(17, this.NoChange);
            aVar.aM(18, this.GroupCount);
            aVar.e(19, 8, this.GroupList);
            aVar.aM(20, this.IsNotRichText);
            if (this.ReferUsername != null) {
                aVar.e(21, this.ReferUsername);
            }
            aVar.bb(22, this.ReferId);
            aVar.aM(23, this.BlackListCount);
            aVar.e(24, 8, this.BlackList);
            aVar.aM(25, this.DeleteFlag);
            aVar.aM(26, this.GroupUserCount);
            aVar.e(27, 8, this.GroupUser);
            if (this.ObjectOperations != null) {
                aVar.ni(28, this.ObjectOperations.computeSize());
                this.ObjectOperations.writeFields(aVar);
            }
            if (this.SnsRedEnvelops != null) {
                aVar.ni(29, this.SnsRedEnvelops.computeSize());
                this.SnsRedEnvelops.writeFields(aVar);
            }
            if (this.PreDownloadInfo != null) {
                aVar.ni(30, this.PreDownloadInfo.computeSize());
                this.PreDownloadInfo.writeFields(aVar);
            }
            if (this.WeAppInfo != null) {
                aVar.ni(31, this.WeAppInfo.computeSize());
                this.WeAppInfo.writeFields(aVar);
            }
            AppMethodBeat.o(125792);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.Id) + 0;
            if (this.Username != null) {
                r += g.a.a.b.b.a.f(2, this.Username);
            }
            if (this.Nickname != null) {
                r += g.a.a.b.b.a.f(3, this.Nickname);
            }
            int bu = r + g.a.a.b.b.a.bu(4, this.CreateTime);
            if (this.ObjectDesc != null) {
                bu += g.a.a.a.nh(5, this.ObjectDesc.computeSize());
            }
            int bu2 = bu + g.a.a.b.b.a.bu(6, this.LikeFlag) + g.a.a.b.b.a.bu(7, this.LikeCount) + g.a.a.b.b.a.bu(8, this.LikeUserListCount) + g.a.a.a.c(9, 8, this.LikeUserList) + g.a.a.b.b.a.bu(10, this.CommentCount) + g.a.a.b.b.a.bu(11, this.CommentUserListCount) + g.a.a.a.c(12, 8, this.CommentUserList) + g.a.a.b.b.a.bu(13, this.WithUserCount) + g.a.a.b.b.a.bu(14, this.WithUserListCount) + g.a.a.a.c(15, 8, this.WithUserList) + g.a.a.b.b.a.bu(16, this.ExtFlag) + g.a.a.b.b.a.bu(17, this.NoChange) + g.a.a.b.b.a.bu(18, this.GroupCount) + g.a.a.a.c(19, 8, this.GroupList) + g.a.a.b.b.a.bu(20, this.IsNotRichText);
            if (this.ReferUsername != null) {
                bu2 += g.a.a.b.b.a.f(21, this.ReferUsername);
            }
            int r2 = bu2 + g.a.a.b.b.a.r(22, this.ReferId) + g.a.a.b.b.a.bu(23, this.BlackListCount) + g.a.a.a.c(24, 8, this.BlackList) + g.a.a.b.b.a.bu(25, this.DeleteFlag) + g.a.a.b.b.a.bu(26, this.GroupUserCount) + g.a.a.a.c(27, 8, this.GroupUser);
            if (this.ObjectOperations != null) {
                r2 += g.a.a.a.nh(28, this.ObjectOperations.computeSize());
            }
            if (this.SnsRedEnvelops != null) {
                r2 += g.a.a.a.nh(29, this.SnsRedEnvelops.computeSize());
            }
            if (this.PreDownloadInfo != null) {
                r2 += g.a.a.a.nh(30, this.PreDownloadInfo.computeSize());
            }
            if (this.WeAppInfo != null) {
                r2 += g.a.a.a.nh(31, this.WeAppInfo.computeSize());
            }
            AppMethodBeat.o(125792);
            return r2;
        } else if (i2 == 2) {
            this.LikeUserList.clear();
            this.CommentUserList.clear();
            this.WithUserList.clear();
            this.GroupList.clear();
            this.BlackList.clear();
            this.GroupUser.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            if (this.ObjectDesc == null) {
                b bVar2 = new b("Not all required fields were included: ObjectDesc");
                AppMethodBeat.o(125792);
                throw bVar2;
            }
            AppMethodBeat.o(125792);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            SnsObject snsObject = (SnsObject) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    snsObject.Id = aVar3.UbS.zl();
                    AppMethodBeat.o(125792);
                    return 0;
                case 2:
                    snsObject.Username = aVar3.UbS.readString();
                    AppMethodBeat.o(125792);
                    return 0;
                case 3:
                    snsObject.Nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(125792);
                    return 0;
                case 4:
                    snsObject.CreateTime = aVar3.UbS.zi();
                    AppMethodBeat.o(125792);
                    return 0;
                case 5:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = sKBuiltinBuffer_t.populateBuilderWithField(aVar4, sKBuiltinBuffer_t, a.getNextFieldNumber(aVar4))) {
                        }
                        snsObject.ObjectDesc = sKBuiltinBuffer_t;
                    }
                    AppMethodBeat.o(125792);
                    return 0;
                case 6:
                    snsObject.LikeFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(125792);
                    return 0;
                case 7:
                    snsObject.LikeCount = aVar3.UbS.zi();
                    AppMethodBeat.o(125792);
                    return 0;
                case 8:
                    snsObject.LikeUserListCount = aVar3.UbS.zi();
                    AppMethodBeat.o(125792);
                    return 0;
                case 9:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        dzo dzo = new dzo();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = dzo.populateBuilderWithField(aVar5, dzo, a.getNextFieldNumber(aVar5))) {
                        }
                        snsObject.LikeUserList.add(dzo);
                    }
                    AppMethodBeat.o(125792);
                    return 0;
                case 10:
                    snsObject.CommentCount = aVar3.UbS.zi();
                    AppMethodBeat.o(125792);
                    return 0;
                case 11:
                    snsObject.CommentUserListCount = aVar3.UbS.zi();
                    AppMethodBeat.o(125792);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        dzo dzo2 = new dzo();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = dzo2.populateBuilderWithField(aVar6, dzo2, a.getNextFieldNumber(aVar6))) {
                        }
                        snsObject.CommentUserList.add(dzo2);
                    }
                    AppMethodBeat.o(125792);
                    return 0;
                case 13:
                    snsObject.WithUserCount = aVar3.UbS.zi();
                    AppMethodBeat.o(125792);
                    return 0;
                case 14:
                    snsObject.WithUserListCount = aVar3.UbS.zi();
                    AppMethodBeat.o(125792);
                    return 0;
                case 15:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        dzo dzo3 = new dzo();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = dzo3.populateBuilderWithField(aVar7, dzo3, a.getNextFieldNumber(aVar7))) {
                        }
                        snsObject.WithUserList.add(dzo3);
                    }
                    AppMethodBeat.o(125792);
                    return 0;
                case 16:
                    snsObject.ExtFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(125792);
                    return 0;
                case 17:
                    snsObject.NoChange = aVar3.UbS.zi();
                    AppMethodBeat.o(125792);
                    return 0;
                case 18:
                    snsObject.GroupCount = aVar3.UbS.zi();
                    AppMethodBeat.o(125792);
                    return 0;
                case 19:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        dzw dzw = new dzw();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = dzw.populateBuilderWithField(aVar8, dzw, a.getNextFieldNumber(aVar8))) {
                        }
                        snsObject.GroupList.add(dzw);
                    }
                    AppMethodBeat.o(125792);
                    return 0;
                case 20:
                    snsObject.IsNotRichText = aVar3.UbS.zi();
                    AppMethodBeat.o(125792);
                    return 0;
                case 21:
                    snsObject.ReferUsername = aVar3.UbS.readString();
                    AppMethodBeat.o(125792);
                    return 0;
                case 22:
                    snsObject.ReferId = aVar3.UbS.zl();
                    AppMethodBeat.o(125792);
                    return 0;
                case 23:
                    snsObject.BlackListCount = aVar3.UbS.zi();
                    AppMethodBeat.o(125792);
                    return 0;
                case 24:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        dqi dqi = new dqi();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = dqi.populateBuilderWithField(aVar9, dqi, a.getNextFieldNumber(aVar9))) {
                        }
                        snsObject.BlackList.add(dqi);
                    }
                    AppMethodBeat.o(125792);
                    return 0;
                case 25:
                    snsObject.DeleteFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(125792);
                    return 0;
                case 26:
                    snsObject.GroupUserCount = aVar3.UbS.zi();
                    AppMethodBeat.o(125792);
                    return 0;
                case 27:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        dqi dqi2 = new dqi();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = dqi2.populateBuilderWithField(aVar10, dqi2, a.getNextFieldNumber(aVar10))) {
                        }
                        snsObject.GroupUser.add(dqi2);
                    }
                    AppMethodBeat.o(125792);
                    return 0;
                case 28:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        SKBuiltinBuffer_t sKBuiltinBuffer_t2 = new SKBuiltinBuffer_t();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = sKBuiltinBuffer_t2.populateBuilderWithField(aVar11, sKBuiltinBuffer_t2, a.getNextFieldNumber(aVar11))) {
                        }
                        snsObject.ObjectOperations = sKBuiltinBuffer_t2;
                    }
                    AppMethodBeat.o(125792);
                    return 0;
                case 29:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        ear ear = new ear();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = ear.populateBuilderWithField(aVar12, ear, a.getNextFieldNumber(aVar12))) {
                        }
                        snsObject.SnsRedEnvelops = ear;
                    }
                    AppMethodBeat.o(125792);
                    return 0;
                case 30:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        ddw ddw = new ddw();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = ddw.populateBuilderWithField(aVar13, ddw, a.getNextFieldNumber(aVar13))) {
                        }
                        snsObject.PreDownloadInfo = ddw;
                    }
                    AppMethodBeat.o(125792);
                    return 0;
                case 31:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        dzk dzk = new dzk();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = dzk.populateBuilderWithField(aVar14, dzk, a.getNextFieldNumber(aVar14))) {
                        }
                        snsObject.WeAppInfo = dzk;
                    }
                    AppMethodBeat.o(125792);
                    return 0;
                default:
                    AppMethodBeat.o(125792);
                    return -1;
            }
        } else {
            AppMethodBeat.o(125792);
            return -1;
        }
    }
}
