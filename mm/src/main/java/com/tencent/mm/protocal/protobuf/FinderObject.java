package com.tencent.mm.protocal.protobuf;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.LinkedList;

public class FinderObject extends a {
    public aoq attachmentList;
    public int commentClose;
    public int commentCount;
    public LinkedList<FinderCommentInfo> commentList = new LinkedList<>();
    public FinderContact contact;
    public int createtime;
    public String debugMessage;
    public int deletetime;
    public long displayId;
    public String displayidDiscarded;
    public int event_status_flag;
    public int favCount;
    public int favFlag;
    public int foldedFlag;
    public ard foldedLayout;
    public int follow_feed_count;
    public int forwardCount;
    public int forward_style;
    public int friendLikeCount;
    public azx hotTopics;
    public long id;
    public int incFriendLikeCount;
    public int is_poi_same_city;
    public b likeBuffer;
    public int likeCount;
    public int likeFlag;
    public LinkedList<FinderCommentInfo> likeList = new LinkedList<>();
    public awe liveInfo;
    public LinkedList<FinderContact> mentionedUserContact = new LinkedList<>();
    public int msgEventFlag;
    public String msgId;
    public String nickname;
    public FinderObjectDesc objectDesc;
    public String objectNonceId;
    public int objectStatus;
    public int objectType;
    public int orgRecommendType;
    public int originalFlag;
    public int permissionFlag;
    public String posTriggerConfig;
    public int privateFlag;
    public int readCount;
    public String recommendReason;
    public int recommendReasonType;
    public int recommendType;
    public LinkedList<String> recommenderList = new LinkedList<>();
    public FinderContact refObjectContact;
    public long refObjectFlag;
    public long refObjectId;
    public String refObjectNonceId;
    public int secondaryShowFlag;
    public String sendShareFavWording;
    public String sessionBuffer;
    public bcq snsShareInfo;
    public int stickyTime;
    public String tipsWording;
    public int urlValidDuration;
    public String username;
    public int warnFlag;
    public String warnWording;

    public FinderObject() {
        AppMethodBeat.i(169021);
        AppMethodBeat.o(169021);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(169022);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            aVar.bb(1, this.id);
            if (this.nickname != null) {
                aVar.e(2, this.nickname);
            }
            if (this.username != null) {
                aVar.e(3, this.username);
            }
            if (this.objectDesc != null) {
                aVar.ni(4, this.objectDesc.computeSize());
                this.objectDesc.writeFields(aVar);
            }
            aVar.aM(5, this.createtime);
            aVar.aM(6, this.likeFlag);
            aVar.e(7, 8, this.likeList);
            aVar.e(8, 8, this.commentList);
            aVar.aM(9, this.forwardCount);
            if (this.contact != null) {
                aVar.ni(10, this.contact.computeSize());
                this.contact.writeFields(aVar);
            }
            if (this.displayidDiscarded != null) {
                aVar.e(11, this.displayidDiscarded);
            }
            aVar.e(12, 1, this.recommenderList);
            aVar.bb(13, this.displayId);
            aVar.aM(14, this.likeCount);
            aVar.aM(15, this.commentCount);
            if (this.recommendReason != null) {
                aVar.e(16, this.recommendReason);
            }
            aVar.aM(17, this.readCount);
            aVar.aM(18, this.deletetime);
            aVar.aM(19, this.commentClose);
            aVar.bb(20, this.refObjectFlag);
            aVar.bb(21, this.refObjectId);
            if (this.refObjectContact != null) {
                aVar.ni(22, this.refObjectContact.computeSize());
                this.refObjectContact.writeFields(aVar);
            }
            aVar.aM(23, this.recommendType);
            aVar.aM(24, this.friendLikeCount);
            if (this.objectNonceId != null) {
                aVar.e(25, this.objectNonceId);
            }
            if (this.refObjectNonceId != null) {
                aVar.e(26, this.refObjectNonceId);
            }
            aVar.aM(27, this.objectStatus);
            if (this.sendShareFavWording != null) {
                aVar.e(28, this.sendShareFavWording);
            }
            aVar.aM(29, this.originalFlag);
            aVar.aM(30, this.secondaryShowFlag);
            if (this.tipsWording != null) {
                aVar.e(31, this.tipsWording);
            }
            aVar.aM(32, this.orgRecommendType);
            aVar.e(33, 8, this.mentionedUserContact);
            if (this.sessionBuffer != null) {
                aVar.e(34, this.sessionBuffer);
            }
            aVar.aM(35, this.warnFlag);
            if (this.warnWording != null) {
                aVar.e(36, this.warnWording);
            }
            if (this.liveInfo != null) {
                aVar.ni(37, this.liveInfo.computeSize());
                this.liveInfo.writeFields(aVar);
            }
            aVar.aM(38, this.favCount);
            aVar.aM(39, this.favFlag);
            aVar.aM(40, this.foldedFlag);
            if (this.foldedLayout != null) {
                aVar.ni(41, this.foldedLayout.computeSize());
                this.foldedLayout.writeFields(aVar);
            }
            aVar.aM(42, this.recommendReasonType);
            aVar.aM(43, this.urlValidDuration);
            aVar.aM(44, this.forward_style);
            if (this.posTriggerConfig != null) {
                aVar.e(45, this.posTriggerConfig);
            }
            aVar.aM(46, this.privateFlag);
            aVar.aM(47, this.msgEventFlag);
            if (this.msgId != null) {
                aVar.e(48, this.msgId);
            }
            aVar.aM(49, this.incFriendLikeCount);
            if (this.debugMessage != null) {
                aVar.e(50, this.debugMessage);
            }
            if (this.likeBuffer != null) {
                aVar.c(51, this.likeBuffer);
            }
            aVar.aM(52, this.permissionFlag);
            aVar.aM(54, this.stickyTime);
            if (this.hotTopics != null) {
                aVar.ni(55, this.hotTopics.computeSize());
                this.hotTopics.writeFields(aVar);
            }
            if (this.attachmentList != null) {
                aVar.ni(56, this.attachmentList.computeSize());
                this.attachmentList.writeFields(aVar);
            }
            aVar.aM(57, this.objectType);
            if (this.snsShareInfo != null) {
                aVar.ni(58, this.snsShareInfo.computeSize());
                this.snsShareInfo.writeFields(aVar);
            }
            aVar.aM(60, this.follow_feed_count);
            aVar.aM(61, this.event_status_flag);
            aVar.aM(62, this.is_poi_same_city);
            AppMethodBeat.o(169022);
            return 0;
        } else if (i2 == 1) {
            int r = g.a.a.b.b.a.r(1, this.id) + 0;
            if (this.nickname != null) {
                r += g.a.a.b.b.a.f(2, this.nickname);
            }
            if (this.username != null) {
                r += g.a.a.b.b.a.f(3, this.username);
            }
            if (this.objectDesc != null) {
                r += g.a.a.a.nh(4, this.objectDesc.computeSize());
            }
            int bu = r + g.a.a.b.b.a.bu(5, this.createtime) + g.a.a.b.b.a.bu(6, this.likeFlag) + g.a.a.a.c(7, 8, this.likeList) + g.a.a.a.c(8, 8, this.commentList) + g.a.a.b.b.a.bu(9, this.forwardCount);
            if (this.contact != null) {
                bu += g.a.a.a.nh(10, this.contact.computeSize());
            }
            if (this.displayidDiscarded != null) {
                bu += g.a.a.b.b.a.f(11, this.displayidDiscarded);
            }
            int c2 = bu + g.a.a.a.c(12, 1, this.recommenderList) + g.a.a.b.b.a.r(13, this.displayId) + g.a.a.b.b.a.bu(14, this.likeCount) + g.a.a.b.b.a.bu(15, this.commentCount);
            if (this.recommendReason != null) {
                c2 += g.a.a.b.b.a.f(16, this.recommendReason);
            }
            int bu2 = c2 + g.a.a.b.b.a.bu(17, this.readCount) + g.a.a.b.b.a.bu(18, this.deletetime) + g.a.a.b.b.a.bu(19, this.commentClose) + g.a.a.b.b.a.r(20, this.refObjectFlag) + g.a.a.b.b.a.r(21, this.refObjectId);
            if (this.refObjectContact != null) {
                bu2 += g.a.a.a.nh(22, this.refObjectContact.computeSize());
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(23, this.recommendType) + g.a.a.b.b.a.bu(24, this.friendLikeCount);
            if (this.objectNonceId != null) {
                bu3 += g.a.a.b.b.a.f(25, this.objectNonceId);
            }
            if (this.refObjectNonceId != null) {
                bu3 += g.a.a.b.b.a.f(26, this.refObjectNonceId);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(27, this.objectStatus);
            if (this.sendShareFavWording != null) {
                bu4 += g.a.a.b.b.a.f(28, this.sendShareFavWording);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(29, this.originalFlag) + g.a.a.b.b.a.bu(30, this.secondaryShowFlag);
            if (this.tipsWording != null) {
                bu5 += g.a.a.b.b.a.f(31, this.tipsWording);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(32, this.orgRecommendType) + g.a.a.a.c(33, 8, this.mentionedUserContact);
            if (this.sessionBuffer != null) {
                bu6 += g.a.a.b.b.a.f(34, this.sessionBuffer);
            }
            int bu7 = bu6 + g.a.a.b.b.a.bu(35, this.warnFlag);
            if (this.warnWording != null) {
                bu7 += g.a.a.b.b.a.f(36, this.warnWording);
            }
            if (this.liveInfo != null) {
                bu7 += g.a.a.a.nh(37, this.liveInfo.computeSize());
            }
            int bu8 = bu7 + g.a.a.b.b.a.bu(38, this.favCount) + g.a.a.b.b.a.bu(39, this.favFlag) + g.a.a.b.b.a.bu(40, this.foldedFlag);
            if (this.foldedLayout != null) {
                bu8 += g.a.a.a.nh(41, this.foldedLayout.computeSize());
            }
            int bu9 = bu8 + g.a.a.b.b.a.bu(42, this.recommendReasonType) + g.a.a.b.b.a.bu(43, this.urlValidDuration) + g.a.a.b.b.a.bu(44, this.forward_style);
            if (this.posTriggerConfig != null) {
                bu9 += g.a.a.b.b.a.f(45, this.posTriggerConfig);
            }
            int bu10 = bu9 + g.a.a.b.b.a.bu(46, this.privateFlag) + g.a.a.b.b.a.bu(47, this.msgEventFlag);
            if (this.msgId != null) {
                bu10 += g.a.a.b.b.a.f(48, this.msgId);
            }
            int bu11 = bu10 + g.a.a.b.b.a.bu(49, this.incFriendLikeCount);
            if (this.debugMessage != null) {
                bu11 += g.a.a.b.b.a.f(50, this.debugMessage);
            }
            if (this.likeBuffer != null) {
                bu11 += g.a.a.b.b.a.b(51, this.likeBuffer);
            }
            int bu12 = bu11 + g.a.a.b.b.a.bu(52, this.permissionFlag) + g.a.a.b.b.a.bu(54, this.stickyTime);
            if (this.hotTopics != null) {
                bu12 += g.a.a.a.nh(55, this.hotTopics.computeSize());
            }
            if (this.attachmentList != null) {
                bu12 += g.a.a.a.nh(56, this.attachmentList.computeSize());
            }
            int bu13 = bu12 + g.a.a.b.b.a.bu(57, this.objectType);
            if (this.snsShareInfo != null) {
                bu13 += g.a.a.a.nh(58, this.snsShareInfo.computeSize());
            }
            int bu14 = bu13 + g.a.a.b.b.a.bu(60, this.follow_feed_count) + g.a.a.b.b.a.bu(61, this.event_status_flag) + g.a.a.b.b.a.bu(62, this.is_poi_same_city);
            AppMethodBeat.o(169022);
            return bu14;
        } else if (i2 == 2) {
            this.likeList.clear();
            this.commentList.clear();
            this.recommenderList.clear();
            this.mentionedUserContact.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(169022);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            FinderObject finderObject = (FinderObject) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    finderObject.id = aVar3.UbS.zl();
                    AppMethodBeat.o(169022);
                    return 0;
                case 2:
                    finderObject.nickname = aVar3.UbS.readString();
                    AppMethodBeat.o(169022);
                    return 0;
                case 3:
                    finderObject.username = aVar3.UbS.readString();
                    AppMethodBeat.o(169022);
                    return 0;
                case 4:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderObjectDesc finderObjectDesc = new FinderObjectDesc();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderObjectDesc.populateBuilderWithField(aVar4, finderObjectDesc, a.getNextFieldNumber(aVar4))) {
                        }
                        finderObject.objectDesc = finderObjectDesc;
                    }
                    AppMethodBeat.o(169022);
                    return 0;
                case 5:
                    finderObject.createtime = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 6:
                    finderObject.likeFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 7:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        FinderCommentInfo finderCommentInfo = new FinderCommentInfo();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = finderCommentInfo.populateBuilderWithField(aVar5, finderCommentInfo, a.getNextFieldNumber(aVar5))) {
                        }
                        finderObject.likeList.add(finderCommentInfo);
                    }
                    AppMethodBeat.o(169022);
                    return 0;
                case 8:
                    LinkedList<byte[]> awh3 = aVar3.awh(intValue);
                    int size3 = awh3.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        FinderCommentInfo finderCommentInfo2 = new FinderCommentInfo();
                        g.a.a.a.a aVar6 = new g.a.a.a.a(awh3.get(i5), unknownTagHandler);
                        for (boolean z3 = true; z3; z3 = finderCommentInfo2.populateBuilderWithField(aVar6, finderCommentInfo2, a.getNextFieldNumber(aVar6))) {
                        }
                        finderObject.commentList.add(finderCommentInfo2);
                    }
                    AppMethodBeat.o(169022);
                    return 0;
                case 9:
                    finderObject.forwardCount = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 10:
                    LinkedList<byte[]> awh4 = aVar3.awh(intValue);
                    int size4 = awh4.size();
                    for (int i6 = 0; i6 < size4; i6++) {
                        FinderContact finderContact = new FinderContact();
                        g.a.a.a.a aVar7 = new g.a.a.a.a(awh4.get(i6), unknownTagHandler);
                        for (boolean z4 = true; z4; z4 = finderContact.populateBuilderWithField(aVar7, finderContact, a.getNextFieldNumber(aVar7))) {
                        }
                        finderObject.contact = finderContact;
                    }
                    AppMethodBeat.o(169022);
                    return 0;
                case 11:
                    finderObject.displayidDiscarded = aVar3.UbS.readString();
                    AppMethodBeat.o(169022);
                    return 0;
                case 12:
                    finderObject.recommenderList.add(aVar3.UbS.readString());
                    AppMethodBeat.o(169022);
                    return 0;
                case 13:
                    finderObject.displayId = aVar3.UbS.zl();
                    AppMethodBeat.o(169022);
                    return 0;
                case 14:
                    finderObject.likeCount = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 15:
                    finderObject.commentCount = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 16:
                    finderObject.recommendReason = aVar3.UbS.readString();
                    AppMethodBeat.o(169022);
                    return 0;
                case 17:
                    finderObject.readCount = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 18:
                    finderObject.deletetime = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 19:
                    finderObject.commentClose = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 20:
                    finderObject.refObjectFlag = aVar3.UbS.zl();
                    AppMethodBeat.o(169022);
                    return 0;
                case 21:
                    finderObject.refObjectId = aVar3.UbS.zl();
                    AppMethodBeat.o(169022);
                    return 0;
                case 22:
                    LinkedList<byte[]> awh5 = aVar3.awh(intValue);
                    int size5 = awh5.size();
                    for (int i7 = 0; i7 < size5; i7++) {
                        FinderContact finderContact2 = new FinderContact();
                        g.a.a.a.a aVar8 = new g.a.a.a.a(awh5.get(i7), unknownTagHandler);
                        for (boolean z5 = true; z5; z5 = finderContact2.populateBuilderWithField(aVar8, finderContact2, a.getNextFieldNumber(aVar8))) {
                        }
                        finderObject.refObjectContact = finderContact2;
                    }
                    AppMethodBeat.o(169022);
                    return 0;
                case 23:
                    finderObject.recommendType = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 24:
                    finderObject.friendLikeCount = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 25:
                    finderObject.objectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(169022);
                    return 0;
                case 26:
                    finderObject.refObjectNonceId = aVar3.UbS.readString();
                    AppMethodBeat.o(169022);
                    return 0;
                case 27:
                    finderObject.objectStatus = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 28:
                    finderObject.sendShareFavWording = aVar3.UbS.readString();
                    AppMethodBeat.o(169022);
                    return 0;
                case 29:
                    finderObject.originalFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 30:
                    finderObject.secondaryShowFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 31:
                    finderObject.tipsWording = aVar3.UbS.readString();
                    AppMethodBeat.o(169022);
                    return 0;
                case 32:
                    finderObject.orgRecommendType = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 33:
                    LinkedList<byte[]> awh6 = aVar3.awh(intValue);
                    int size6 = awh6.size();
                    for (int i8 = 0; i8 < size6; i8++) {
                        FinderContact finderContact3 = new FinderContact();
                        g.a.a.a.a aVar9 = new g.a.a.a.a(awh6.get(i8), unknownTagHandler);
                        for (boolean z6 = true; z6; z6 = finderContact3.populateBuilderWithField(aVar9, finderContact3, a.getNextFieldNumber(aVar9))) {
                        }
                        finderObject.mentionedUserContact.add(finderContact3);
                    }
                    AppMethodBeat.o(169022);
                    return 0;
                case 34:
                    finderObject.sessionBuffer = aVar3.UbS.readString();
                    AppMethodBeat.o(169022);
                    return 0;
                case 35:
                    finderObject.warnFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 36:
                    finderObject.warnWording = aVar3.UbS.readString();
                    AppMethodBeat.o(169022);
                    return 0;
                case 37:
                    LinkedList<byte[]> awh7 = aVar3.awh(intValue);
                    int size7 = awh7.size();
                    for (int i9 = 0; i9 < size7; i9++) {
                        awe awe = new awe();
                        g.a.a.a.a aVar10 = new g.a.a.a.a(awh7.get(i9), unknownTagHandler);
                        for (boolean z7 = true; z7; z7 = awe.populateBuilderWithField(aVar10, awe, a.getNextFieldNumber(aVar10))) {
                        }
                        finderObject.liveInfo = awe;
                    }
                    AppMethodBeat.o(169022);
                    return 0;
                case 38:
                    finderObject.favCount = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 39:
                    finderObject.favFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 40:
                    finderObject.foldedFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    LinkedList<byte[]> awh8 = aVar3.awh(intValue);
                    int size8 = awh8.size();
                    for (int i10 = 0; i10 < size8; i10++) {
                        ard ard = new ard();
                        g.a.a.a.a aVar11 = new g.a.a.a.a(awh8.get(i10), unknownTagHandler);
                        for (boolean z8 = true; z8; z8 = ard.populateBuilderWithField(aVar11, ard, a.getNextFieldNumber(aVar11))) {
                        }
                        finderObject.foldedLayout = ard;
                    }
                    AppMethodBeat.o(169022);
                    return 0;
                case 42:
                    finderObject.recommendReasonType = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 43:
                    finderObject.urlValidDuration = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 44:
                    finderObject.forward_style = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 45:
                    finderObject.posTriggerConfig = aVar3.UbS.readString();
                    AppMethodBeat.o(169022);
                    return 0;
                case 46:
                    finderObject.privateFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 47:
                    finderObject.msgEventFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    finderObject.msgId = aVar3.UbS.readString();
                    AppMethodBeat.o(169022);
                    return 0;
                case 49:
                    finderObject.incFriendLikeCount = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 50:
                    finderObject.debugMessage = aVar3.UbS.readString();
                    AppMethodBeat.o(169022);
                    return 0;
                case 51:
                    finderObject.likeBuffer = aVar3.UbS.hPo();
                    AppMethodBeat.o(169022);
                    return 0;
                case 52:
                    finderObject.permissionFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 53:
                case bv.CTRL_INDEX:
                default:
                    AppMethodBeat.o(169022);
                    return -1;
                case 54:
                    finderObject.stickyTime = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 55:
                    LinkedList<byte[]> awh9 = aVar3.awh(intValue);
                    int size9 = awh9.size();
                    for (int i11 = 0; i11 < size9; i11++) {
                        azx azx = new azx();
                        g.a.a.a.a aVar12 = new g.a.a.a.a(awh9.get(i11), unknownTagHandler);
                        for (boolean z9 = true; z9; z9 = azx.populateBuilderWithField(aVar12, azx, a.getNextFieldNumber(aVar12))) {
                        }
                        finderObject.hotTopics = azx;
                    }
                    AppMethodBeat.o(169022);
                    return 0;
                case 56:
                    LinkedList<byte[]> awh10 = aVar3.awh(intValue);
                    int size10 = awh10.size();
                    for (int i12 = 0; i12 < size10; i12++) {
                        aoq aoq = new aoq();
                        g.a.a.a.a aVar13 = new g.a.a.a.a(awh10.get(i12), unknownTagHandler);
                        for (boolean z10 = true; z10; z10 = aoq.populateBuilderWithField(aVar13, aoq, a.getNextFieldNumber(aVar13))) {
                        }
                        finderObject.attachmentList = aoq;
                    }
                    AppMethodBeat.o(169022);
                    return 0;
                case n.CTRL_INDEX:
                    finderObject.objectType = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 58:
                    LinkedList<byte[]> awh11 = aVar3.awh(intValue);
                    int size11 = awh11.size();
                    for (int i13 = 0; i13 < size11; i13++) {
                        bcq bcq = new bcq();
                        g.a.a.a.a aVar14 = new g.a.a.a.a(awh11.get(i13), unknownTagHandler);
                        for (boolean z11 = true; z11; z11 = bcq.populateBuilderWithField(aVar14, bcq, a.getNextFieldNumber(aVar14))) {
                        }
                        finderObject.snsShareInfo = bcq;
                    }
                    AppMethodBeat.o(169022);
                    return 0;
                case 60:
                    finderObject.follow_feed_count = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                    finderObject.event_status_flag = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
                case 62:
                    finderObject.is_poi_same_city = aVar3.UbS.zi();
                    AppMethodBeat.o(169022);
                    return 0;
            }
        } else {
            AppMethodBeat.o(169022);
            return -1;
        }
    }
}
