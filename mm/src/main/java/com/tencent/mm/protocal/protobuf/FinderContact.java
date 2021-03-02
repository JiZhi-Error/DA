package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.LinkedList;

public class FinderContact extends a {
    public FinderAuthInfo authInfo;
    public String coverImgUrl;
    public int extFlag;
    public app extInfo;
    public int fans_count;
    public int followFlag;
    public int followTime;
    public int foreign_user_flag;
    public int friend_follow_count;
    public String headUrl;
    public String liveCoverImgUrl;
    public int liveStatus;
    public apr live_info;
    public awt live_notice_info;
    public String loggingout_wording;
    public aps msgInfo;
    public String nickname;
    public int originalEntranceFlag;
    public int originalFlag;
    public bac originalInfo;
    public long seq;
    public String signature;
    public int spamStatus;
    public String username;
    public String wx_username_v5;

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168945);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.nickname != null) {
                aVar.e(2, this.nickname);
            }
            if (this.headUrl != null) {
                aVar.e(3, this.headUrl);
            }
            aVar.bb(4, this.seq);
            if (this.signature != null) {
                aVar.e(5, this.signature);
            }
            aVar.aM(6, this.followFlag);
            aVar.aM(7, this.followTime);
            if (this.authInfo != null) {
                aVar.ni(8, this.authInfo.computeSize());
                this.authInfo.writeFields(aVar);
            }
            if (this.coverImgUrl != null) {
                aVar.e(9, this.coverImgUrl);
            }
            aVar.aM(10, this.spamStatus);
            aVar.aM(11, this.extFlag);
            if (this.extInfo != null) {
                aVar.ni(12, this.extInfo.computeSize());
                this.extInfo.writeFields(aVar);
            }
            aVar.aM(13, this.originalFlag);
            if (this.originalInfo != null) {
                aVar.ni(14, this.originalInfo.computeSize());
                this.originalInfo.writeFields(aVar);
            }
            aVar.aM(15, this.liveStatus);
            if (this.msgInfo != null) {
                aVar.ni(16, this.msgInfo.computeSize());
                this.msgInfo.writeFields(aVar);
            }
            aVar.aM(17, this.originalEntranceFlag);
            if (this.liveCoverImgUrl != null) {
                aVar.e(18, this.liveCoverImgUrl);
            }
            aVar.aM(19, this.foreign_user_flag);
            if (this.live_notice_info != null) {
                aVar.ni(20, this.live_notice_info.computeSize());
                this.live_notice_info.writeFields(aVar);
            }
            if (this.loggingout_wording != null) {
                aVar.e(21, this.loggingout_wording);
            }
            if (this.live_info != null) {
                aVar.ni(22, this.live_info.computeSize());
                this.live_info.writeFields(aVar);
            }
            aVar.aM(23, this.friend_follow_count);
            aVar.aM(24, this.fans_count);
            if (this.wx_username_v5 != null) {
                aVar.e(25, this.wx_username_v5);
            }
            AppMethodBeat.o(168945);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.nickname != null) {
                f2 += g.a.a.b.b.a.f(2, this.nickname);
            }
            if (this.headUrl != null) {
                f2 += g.a.a.b.b.a.f(3, this.headUrl);
            }
            int r = f2 + g.a.a.b.b.a.r(4, this.seq);
            if (this.signature != null) {
                r += g.a.a.b.b.a.f(5, this.signature);
            }
            int bu = r + g.a.a.b.b.a.bu(6, this.followFlag) + g.a.a.b.b.a.bu(7, this.followTime);
            if (this.authInfo != null) {
                bu += g.a.a.a.nh(8, this.authInfo.computeSize());
            }
            if (this.coverImgUrl != null) {
                bu += g.a.a.b.b.a.f(9, this.coverImgUrl);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(10, this.spamStatus) + g.a.a.b.b.a.bu(11, this.extFlag);
            if (this.extInfo != null) {
                bu2 += g.a.a.a.nh(12, this.extInfo.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(13, this.originalFlag);
            if (this.originalInfo != null) {
                bu3 += g.a.a.a.nh(14, this.originalInfo.computeSize());
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(15, this.liveStatus);
            if (this.msgInfo != null) {
                bu4 += g.a.a.a.nh(16, this.msgInfo.computeSize());
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(17, this.originalEntranceFlag);
            if (this.liveCoverImgUrl != null) {
                bu5 += g.a.a.b.b.a.f(18, this.liveCoverImgUrl);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(19, this.foreign_user_flag);
            if (this.live_notice_info != null) {
                bu6 += g.a.a.a.nh(20, this.live_notice_info.computeSize());
            }
            if (this.loggingout_wording != null) {
                bu6 += g.a.a.b.b.a.f(21, this.loggingout_wording);
            }
            if (this.live_info != null) {
                bu6 += g.a.a.a.nh(22, this.live_info.computeSize());
            }
            int bu7 = bu6 + g.a.a.b.b.a.bu(23, this.friend_follow_count) + g.a.a.b.b.a.bu(24, this.fans_count);
            if (this.wx_username_v5 != null) {
                bu7 += g.a.a.b.b.a.f(25, this.wx_username_v5);
            }
            AppMethodBeat.o(168945);
            return bu7;
        } else if (i2 == 2) {
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168945);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            FinderContact finderContact = (FinderContact) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    finderContact.username = aVar3.UbS.readString();
                    AppMethodBeat.o(168945);
                    return 0;
                case 2:
                    finderContact.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(168945);
                    return 0;
                case 3:
                    finderContact.headUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(168945);
                    return 0;
                case 4:
                    finderContact.seq = aVar3.UbS.zl();
                    AppMethodBeat.o(168945);
                    return 0;
                case 5:
                    finderContact.signature = aVar3.UbS.readString();
                    AppMethodBeat.o(168945);
                    return 0;
                case 6:
                    finderContact.followFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168945);
                    return 0;
                case 7:
                    finderContact.followTime = aVar3.UbS.zi();
                    AppMethodBeat.o(168945);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderAuthInfo finderAuthInfo = new FinderAuthInfo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderAuthInfo.populateBuilderWithField(aVar4, finderAuthInfo, a.getNextFieldNumber(aVar4))) {
                        }
                        finderContact.authInfo = finderAuthInfo;
                    }
                    AppMethodBeat.o(168945);
                    return 0;
                case 9:
                    finderContact.coverImgUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(168945);
                    return 0;
                case 10:
                    finderContact.spamStatus = aVar3.UbS.zi();
                    AppMethodBeat.o(168945);
                    return 0;
                case 11:
                    finderContact.extFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168945);
                    return 0;
                case 12:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        app app = new app();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = app.populateBuilderWithField(aVar5, app, a.getNextFieldNumber(aVar5))) {
                        }
                        finderContact.extInfo = app;
                    }
                    AppMethodBeat.o(168945);
                    return 0;
                case 13:
                    finderContact.originalFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168945);
                    return 0;
                case 14:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        bac bac = new bac();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = bac.populateBuilderWithField(aVar6, bac, a.getNextFieldNumber(aVar6))) {
                        }
                        finderContact.originalInfo = bac;
                    }
                    AppMethodBeat.o(168945);
                    return 0;
                case 15:
                    finderContact.liveStatus = aVar3.UbS.zi();
                    AppMethodBeat.o(168945);
                    return 0;
                case 16:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        aps aps = new aps();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = aps.populateBuilderWithField(aVar7, aps, a.getNextFieldNumber(aVar7))) {
                        }
                        finderContact.msgInfo = aps;
                    }
                    AppMethodBeat.o(168945);
                    return 0;
                case 17:
                    finderContact.originalEntranceFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168945);
                    return 0;
                case 18:
                    finderContact.liveCoverImgUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(168945);
                    return 0;
                case 19:
                    finderContact.foreign_user_flag = aVar3.UbS.zi();
                    AppMethodBeat.o(168945);
                    return 0;
                case 20:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        awt awt = new awt();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = awt.populateBuilderWithField(aVar8, awt, a.getNextFieldNumber(aVar8))) {
                        }
                        finderContact.live_notice_info = awt;
                    }
                    AppMethodBeat.o(168945);
                    return 0;
                case 21:
                    finderContact.loggingout_wording = aVar3.UbS.readString();
                    AppMethodBeat.o(168945);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        apr apr = new apr();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = apr.populateBuilderWithField(aVar9, apr, a.getNextFieldNumber(aVar9))) {
                        }
                        finderContact.live_info = apr;
                    }
                    AppMethodBeat.o(168945);
                    return 0;
                case 23:
                    finderContact.friend_follow_count = aVar3.UbS.zi();
                    AppMethodBeat.o(168945);
                    return 0;
                case 24:
                    finderContact.fans_count = aVar3.UbS.zi();
                    AppMethodBeat.o(168945);
                    return 0;
                case 25:
                    finderContact.wx_username_v5 = aVar3.UbS.readString();
                    AppMethodBeat.o(168945);
                    return 0;
                default:
                    AppMethodBeat.o(168945);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168945);
            return -1;
        }
    }
}
