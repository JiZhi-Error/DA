package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public class FinderCommentInfo extends a {
    public int blacklist_flag;
    public String client_id;
    public long commentId;
    public String content;
    public int continueFlag;
    public long createtime;
    public int deleteFlag;
    public int displayFlag;
    public long displayid;
    public String displayidDiscarded;
    public int expandCommentCount;
    public int extFlag;
    public String headUrl;
    public b lastBuffer;
    public LinkedList<FinderCommentInfo> levelTwoComment = new LinkedList<>();
    public int likeCount;
    public int likeFlag;
    public aps msgInfo;
    public String nickname;
    public int replyBlacklistFlag;
    public long replyCommentId;
    public String replyNickname;
    public String reply_content;
    public String reply_username;
    public int unreadFlag;
    public int upContinueFlag;
    public String username;

    public FinderCommentInfo() {
        AppMethodBeat.i(168940);
        AppMethodBeat.o(168940);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168941);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.username != null) {
                aVar.e(1, this.username);
            }
            if (this.nickname != null) {
                aVar.e(2, this.nickname);
            }
            if (this.content != null) {
                aVar.e(3, this.content);
            }
            aVar.bb(4, this.commentId);
            aVar.bb(5, this.replyCommentId);
            aVar.aM(6, this.deleteFlag);
            if (this.headUrl != null) {
                aVar.e(7, this.headUrl);
            }
            aVar.e(8, 8, this.levelTwoComment);
            aVar.bb(9, this.createtime);
            if (this.replyNickname != null) {
                aVar.e(10, this.replyNickname);
            }
            if (this.displayidDiscarded != null) {
                aVar.e(11, this.displayidDiscarded);
            }
            aVar.aM(12, this.likeFlag);
            aVar.aM(13, this.likeCount);
            aVar.bb(14, this.displayid);
            aVar.aM(15, this.expandCommentCount);
            if (this.lastBuffer != null) {
                aVar.c(16, this.lastBuffer);
            }
            aVar.aM(17, this.continueFlag);
            aVar.aM(18, this.displayFlag);
            aVar.aM(19, this.blacklist_flag);
            if (this.reply_content != null) {
                aVar.e(20, this.reply_content);
            }
            if (this.reply_username != null) {
                aVar.e(21, this.reply_username);
            }
            if (this.client_id != null) {
                aVar.e(22, this.client_id);
            }
            aVar.aM(23, this.upContinueFlag);
            aVar.aM(24, this.replyBlacklistFlag);
            aVar.aM(25, this.extFlag);
            aVar.aM(26, this.unreadFlag);
            if (this.msgInfo != null) {
                aVar.ni(27, this.msgInfo.computeSize());
                this.msgInfo.writeFields(aVar);
            }
            AppMethodBeat.o(168941);
            return 0;
        } else if (i2 == 1) {
            int f2 = this.username != null ? g.a.a.b.b.a.f(1, this.username) + 0 : 0;
            if (this.nickname != null) {
                f2 += g.a.a.b.b.a.f(2, this.nickname);
            }
            if (this.content != null) {
                f2 += g.a.a.b.b.a.f(3, this.content);
            }
            int r = f2 + g.a.a.b.b.a.r(4, this.commentId) + g.a.a.b.b.a.r(5, this.replyCommentId) + g.a.a.b.b.a.bu(6, this.deleteFlag);
            if (this.headUrl != null) {
                r += g.a.a.b.b.a.f(7, this.headUrl);
            }
            int c2 = r + g.a.a.a.c(8, 8, this.levelTwoComment) + g.a.a.b.b.a.r(9, this.createtime);
            if (this.replyNickname != null) {
                c2 += g.a.a.b.b.a.f(10, this.replyNickname);
            }
            if (this.displayidDiscarded != null) {
                c2 += g.a.a.b.b.a.f(11, this.displayidDiscarded);
            }
            int bu = c2 + g.a.a.b.b.a.bu(12, this.likeFlag) + g.a.a.b.b.a.bu(13, this.likeCount) + g.a.a.b.b.a.r(14, this.displayid) + g.a.a.b.b.a.bu(15, this.expandCommentCount);
            if (this.lastBuffer != null) {
                bu += g.a.a.b.b.a.b(16, this.lastBuffer);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(17, this.continueFlag) + g.a.a.b.b.a.bu(18, this.displayFlag) + g.a.a.b.b.a.bu(19, this.blacklist_flag);
            if (this.reply_content != null) {
                bu2 += g.a.a.b.b.a.f(20, this.reply_content);
            }
            if (this.reply_username != null) {
                bu2 += g.a.a.b.b.a.f(21, this.reply_username);
            }
            if (this.client_id != null) {
                bu2 += g.a.a.b.b.a.f(22, this.client_id);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(23, this.upContinueFlag) + g.a.a.b.b.a.bu(24, this.replyBlacklistFlag) + g.a.a.b.b.a.bu(25, this.extFlag) + g.a.a.b.b.a.bu(26, this.unreadFlag);
            if (this.msgInfo != null) {
                bu3 += g.a.a.a.nh(27, this.msgInfo.computeSize());
            }
            AppMethodBeat.o(168941);
            return bu3;
        } else if (i2 == 2) {
            this.levelTwoComment.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168941);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            FinderCommentInfo finderCommentInfo = (FinderCommentInfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    finderCommentInfo.username = aVar3.UbS.readString();
                    AppMethodBeat.o(168941);
                    return 0;
                case 2:
                    finderCommentInfo.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(168941);
                    return 0;
                case 3:
                    finderCommentInfo.content = aVar3.UbS.readString();
                    AppMethodBeat.o(168941);
                    return 0;
                case 4:
                    finderCommentInfo.commentId = aVar3.UbS.zl();
                    AppMethodBeat.o(168941);
                    return 0;
                case 5:
                    finderCommentInfo.replyCommentId = aVar3.UbS.zl();
                    AppMethodBeat.o(168941);
                    return 0;
                case 6:
                    finderCommentInfo.deleteFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168941);
                    return 0;
                case 7:
                    finderCommentInfo.headUrl = aVar3.UbS.readString();
                    AppMethodBeat.o(168941);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderCommentInfo finderCommentInfo2 = new FinderCommentInfo();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderCommentInfo2.populateBuilderWithField(aVar4, finderCommentInfo2, a.getNextFieldNumber(aVar4))) {
                        }
                        finderCommentInfo.levelTwoComment.add(finderCommentInfo2);
                    }
                    AppMethodBeat.o(168941);
                    return 0;
                case 9:
                    finderCommentInfo.createtime = aVar3.UbS.zl();
                    AppMethodBeat.o(168941);
                    return 0;
                case 10:
                    finderCommentInfo.replyNickname = aVar3.UbS.readString();
                    AppMethodBeat.o(168941);
                    return 0;
                case 11:
                    finderCommentInfo.displayidDiscarded = aVar3.UbS.readString();
                    AppMethodBeat.o(168941);
                    return 0;
                case 12:
                    finderCommentInfo.likeFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168941);
                    return 0;
                case 13:
                    finderCommentInfo.likeCount = aVar3.UbS.zi();
                    AppMethodBeat.o(168941);
                    return 0;
                case 14:
                    finderCommentInfo.displayid = aVar3.UbS.zl();
                    AppMethodBeat.o(168941);
                    return 0;
                case 15:
                    finderCommentInfo.expandCommentCount = aVar3.UbS.zi();
                    AppMethodBeat.o(168941);
                    return 0;
                case 16:
                    finderCommentInfo.lastBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(168941);
                    return 0;
                case 17:
                    finderCommentInfo.continueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168941);
                    return 0;
                case 18:
                    finderCommentInfo.displayFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168941);
                    return 0;
                case 19:
                    finderCommentInfo.blacklist_flag = aVar3.UbS.zi();
                    AppMethodBeat.o(168941);
                    return 0;
                case 20:
                    finderCommentInfo.reply_content = aVar3.UbS.readString();
                    AppMethodBeat.o(168941);
                    return 0;
                case 21:
                    finderCommentInfo.reply_username = aVar3.UbS.readString();
                    AppMethodBeat.o(168941);
                    return 0;
                case 22:
                    finderCommentInfo.client_id = aVar3.UbS.readString();
                    AppMethodBeat.o(168941);
                    return 0;
                case 23:
                    finderCommentInfo.upContinueFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168941);
                    return 0;
                case 24:
                    finderCommentInfo.replyBlacklistFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168941);
                    return 0;
                case 25:
                    finderCommentInfo.extFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168941);
                    return 0;
                case 26:
                    finderCommentInfo.unreadFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168941);
                    return 0;
                case 27:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        aps aps = new aps();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = aps.populateBuilderWithField(aVar5, aps, a.getNextFieldNumber(aVar5))) {
                        }
                        finderCommentInfo.msgInfo = aps;
                    }
                    AppMethodBeat.o(168941);
                    return 0;
                default:
                    AppMethodBeat.o(168941);
                    return -1;
            }
        } else {
            AppMethodBeat.o(168941);
            return -1;
        }
    }
}
