package com.tencent.mm.protocal.protobuf;

import android.support.constraint.ConstraintLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.pay.n;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import java.util.LinkedList;

public class FinderFeedReportObject extends a {
    public String actionTrace;
    public String beforeCutMediaPath;
    public long cdnEndTime;
    public int cgiErrorCode;
    public int cgiErrorType;
    public String clickId;
    public int clickMentionCount;
    public int clickRepostCount;
    public int clickSucMentionCount;
    public int descCount;
    public int descEmojiCount;
    public int draft;
    public int draftType;
    public int dumpCgiErrorCode;
    public int dumpCgiErrorType;
    public String editId;
    public int enterScene;
    public long enterTakePhotoTime;
    public long enterVideoEditTime;
    public int existDesc;
    public int existLocation;
    public int exitPageId;
    public String followSoundTrackId;
    public String forwardingAppId;
    public int isBeauty;
    public int isDurationCut;
    public int isMultiShot;
    public int lbsFlag;
    public String link;
    public int longVideoSizeInvalid;
    public LinkedList<FinderMediaReportObject> mediaList = new LinkedList<>();
    public int mediaProcessCost;
    public int megaCgiErrorCode;
    public int megaCgiErrorType;
    public int mentionCount;
    public int mentionRepeatCount;
    public int multiShotChangeCnt;
    public int multiShotClickCnt;
    public int multiShotSuccessCnt;
    public int multiShotVideoCnt;
    public int musicType;
    public String postId;
    public int postStage;
    public int postTaskCost;
    public long remuxEndTime;
    public int remuxType;
    public int retryCount;
    public int sdkShareType;
    public axt selectLocation;
    public long sendOrExitButtonTime;
    public String sessionId;
    public int soundTrackType;
    public String topicActivityId;
    public int topicActivityType;
    public int uploadCost;
    public int uploadLogicError;
    public long uploadMediaTotalSize;
    public int videoEmojiCount;
    public String videoMediaInfo;
    public String videoMusicId;
    public int videoMusicIndex;
    public int videoMusicSearch;
    public int videoPostType;
    public long videoRecordTime;
    public int videoSource;
    public int videoSubType;
    public int videoWordingCount;

    public FinderFeedReportObject() {
        AppMethodBeat.i(168956);
        AppMethodBeat.o(168956);
    }

    @Override // com.tencent.mm.bw.a
    public final int op(int i2, Object... objArr) {
        AppMethodBeat.i(168957);
        if (i2 == 0) {
            g.a.a.c.a aVar = (g.a.a.c.a) objArr[0];
            if (this.sessionId != null) {
                aVar.e(1, this.sessionId);
            }
            aVar.aM(2, this.enterScene);
            aVar.aM(3, this.exitPageId);
            aVar.bb(4, this.enterTakePhotoTime);
            aVar.bb(5, this.enterVideoEditTime);
            aVar.bb(6, this.sendOrExitButtonTime);
            aVar.bb(7, this.videoRecordTime);
            aVar.aM(8, this.videoSource);
            aVar.aM(9, this.videoEmojiCount);
            aVar.aM(10, this.videoWordingCount);
            if (this.videoMusicId != null) {
                aVar.e(11, this.videoMusicId);
            }
            aVar.aM(12, this.videoMusicIndex);
            aVar.aM(13, this.videoMusicSearch);
            aVar.aM(14, this.videoPostType);
            if (this.videoMediaInfo != null) {
                aVar.e(15, this.videoMediaInfo);
            }
            aVar.aM(16, this.existDesc);
            aVar.aM(17, this.descCount);
            aVar.aM(18, this.descEmojiCount);
            if (this.actionTrace != null) {
                aVar.e(19, this.actionTrace);
            }
            aVar.aM(20, this.existLocation);
            if (this.link != null) {
                aVar.e(21, this.link);
            }
            aVar.aM(22, this.draft);
            aVar.bb(23, this.cdnEndTime);
            aVar.bb(24, this.remuxEndTime);
            aVar.e(25, 8, this.mediaList);
            aVar.aM(26, this.retryCount);
            aVar.aM(27, this.isBeauty);
            aVar.aM(28, this.isDurationCut);
            if (this.beforeCutMediaPath != null) {
                aVar.e(29, this.beforeCutMediaPath);
            }
            aVar.aM(30, this.isMultiShot);
            aVar.aM(31, this.multiShotChangeCnt);
            aVar.aM(32, this.multiShotClickCnt);
            aVar.aM(33, this.multiShotSuccessCnt);
            aVar.aM(35, this.multiShotVideoCnt);
            aVar.aM(36, this.videoSubType);
            if (this.postId != null) {
                aVar.e(37, this.postId);
            }
            if (this.editId != null) {
                aVar.e(38, this.editId);
            }
            aVar.aM(39, this.mentionCount);
            aVar.aM(40, this.clickMentionCount);
            aVar.aM(41, this.clickSucMentionCount);
            aVar.aM(42, this.mentionRepeatCount);
            aVar.aM(43, this.lbsFlag);
            if (this.selectLocation != null) {
                aVar.ni(44, this.selectLocation.computeSize());
                this.selectLocation.writeFields(aVar);
            }
            aVar.aM(45, this.remuxType);
            aVar.aM(46, this.uploadLogicError);
            aVar.aM(47, this.postStage);
            aVar.aM(48, this.cgiErrorCode);
            aVar.aM(49, this.cgiErrorType);
            if (this.clickId != null) {
                aVar.e(50, this.clickId);
            }
            aVar.aM(51, this.soundTrackType);
            if (this.followSoundTrackId != null) {
                aVar.e(52, this.followSoundTrackId);
            }
            aVar.aM(53, this.megaCgiErrorCode);
            aVar.aM(54, this.megaCgiErrorType);
            aVar.aM(55, this.musicType);
            aVar.aM(56, this.longVideoSizeInvalid);
            aVar.aM(57, this.mediaProcessCost);
            aVar.aM(58, this.uploadCost);
            aVar.bb(59, this.uploadMediaTotalSize);
            aVar.aM(60, this.postTaskCost);
            aVar.aM(61, this.clickRepostCount);
            aVar.aM(62, this.dumpCgiErrorCode);
            aVar.aM(63, this.dumpCgiErrorType);
            aVar.aM(64, this.sdkShareType);
            if (this.forwardingAppId != null) {
                aVar.e(65, this.forwardingAppId);
            }
            if (this.topicActivityId != null) {
                aVar.e(66, this.topicActivityId);
            }
            aVar.aM(67, this.topicActivityType);
            aVar.aM(68, this.draftType);
            AppMethodBeat.o(168957);
            return 0;
        } else if (i2 == 1) {
            int f2 = (this.sessionId != null ? g.a.a.b.b.a.f(1, this.sessionId) + 0 : 0) + g.a.a.b.b.a.bu(2, this.enterScene) + g.a.a.b.b.a.bu(3, this.exitPageId) + g.a.a.b.b.a.r(4, this.enterTakePhotoTime) + g.a.a.b.b.a.r(5, this.enterVideoEditTime) + g.a.a.b.b.a.r(6, this.sendOrExitButtonTime) + g.a.a.b.b.a.r(7, this.videoRecordTime) + g.a.a.b.b.a.bu(8, this.videoSource) + g.a.a.b.b.a.bu(9, this.videoEmojiCount) + g.a.a.b.b.a.bu(10, this.videoWordingCount);
            if (this.videoMusicId != null) {
                f2 += g.a.a.b.b.a.f(11, this.videoMusicId);
            }
            int bu = f2 + g.a.a.b.b.a.bu(12, this.videoMusicIndex) + g.a.a.b.b.a.bu(13, this.videoMusicSearch) + g.a.a.b.b.a.bu(14, this.videoPostType);
            if (this.videoMediaInfo != null) {
                bu += g.a.a.b.b.a.f(15, this.videoMediaInfo);
            }
            int bu2 = bu + g.a.a.b.b.a.bu(16, this.existDesc) + g.a.a.b.b.a.bu(17, this.descCount) + g.a.a.b.b.a.bu(18, this.descEmojiCount);
            if (this.actionTrace != null) {
                bu2 += g.a.a.b.b.a.f(19, this.actionTrace);
            }
            int bu3 = bu2 + g.a.a.b.b.a.bu(20, this.existLocation);
            if (this.link != null) {
                bu3 += g.a.a.b.b.a.f(21, this.link);
            }
            int bu4 = bu3 + g.a.a.b.b.a.bu(22, this.draft) + g.a.a.b.b.a.r(23, this.cdnEndTime) + g.a.a.b.b.a.r(24, this.remuxEndTime) + g.a.a.a.c(25, 8, this.mediaList) + g.a.a.b.b.a.bu(26, this.retryCount) + g.a.a.b.b.a.bu(27, this.isBeauty) + g.a.a.b.b.a.bu(28, this.isDurationCut);
            if (this.beforeCutMediaPath != null) {
                bu4 += g.a.a.b.b.a.f(29, this.beforeCutMediaPath);
            }
            int bu5 = bu4 + g.a.a.b.b.a.bu(30, this.isMultiShot) + g.a.a.b.b.a.bu(31, this.multiShotChangeCnt) + g.a.a.b.b.a.bu(32, this.multiShotClickCnt) + g.a.a.b.b.a.bu(33, this.multiShotSuccessCnt) + g.a.a.b.b.a.bu(35, this.multiShotVideoCnt) + g.a.a.b.b.a.bu(36, this.videoSubType);
            if (this.postId != null) {
                bu5 += g.a.a.b.b.a.f(37, this.postId);
            }
            if (this.editId != null) {
                bu5 += g.a.a.b.b.a.f(38, this.editId);
            }
            int bu6 = bu5 + g.a.a.b.b.a.bu(39, this.mentionCount) + g.a.a.b.b.a.bu(40, this.clickMentionCount) + g.a.a.b.b.a.bu(41, this.clickSucMentionCount) + g.a.a.b.b.a.bu(42, this.mentionRepeatCount) + g.a.a.b.b.a.bu(43, this.lbsFlag);
            if (this.selectLocation != null) {
                bu6 += g.a.a.a.nh(44, this.selectLocation.computeSize());
            }
            int bu7 = bu6 + g.a.a.b.b.a.bu(45, this.remuxType) + g.a.a.b.b.a.bu(46, this.uploadLogicError) + g.a.a.b.b.a.bu(47, this.postStage) + g.a.a.b.b.a.bu(48, this.cgiErrorCode) + g.a.a.b.b.a.bu(49, this.cgiErrorType);
            if (this.clickId != null) {
                bu7 += g.a.a.b.b.a.f(50, this.clickId);
            }
            int bu8 = bu7 + g.a.a.b.b.a.bu(51, this.soundTrackType);
            if (this.followSoundTrackId != null) {
                bu8 += g.a.a.b.b.a.f(52, this.followSoundTrackId);
            }
            int bu9 = bu8 + g.a.a.b.b.a.bu(53, this.megaCgiErrorCode) + g.a.a.b.b.a.bu(54, this.megaCgiErrorType) + g.a.a.b.b.a.bu(55, this.musicType) + g.a.a.b.b.a.bu(56, this.longVideoSizeInvalid) + g.a.a.b.b.a.bu(57, this.mediaProcessCost) + g.a.a.b.b.a.bu(58, this.uploadCost) + g.a.a.b.b.a.r(59, this.uploadMediaTotalSize) + g.a.a.b.b.a.bu(60, this.postTaskCost) + g.a.a.b.b.a.bu(61, this.clickRepostCount) + g.a.a.b.b.a.bu(62, this.dumpCgiErrorCode) + g.a.a.b.b.a.bu(63, this.dumpCgiErrorType) + g.a.a.b.b.a.bu(64, this.sdkShareType);
            if (this.forwardingAppId != null) {
                bu9 += g.a.a.b.b.a.f(65, this.forwardingAppId);
            }
            if (this.topicActivityId != null) {
                bu9 += g.a.a.b.b.a.f(66, this.topicActivityId);
            }
            int bu10 = bu9 + g.a.a.b.b.a.bu(67, this.topicActivityType) + g.a.a.b.b.a.bu(68, this.draftType);
            AppMethodBeat.o(168957);
            return bu10;
        } else if (i2 == 2) {
            this.mediaList.clear();
            g.a.a.a.a aVar2 = new g.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (int nextFieldNumber = a.getNextFieldNumber(aVar2); nextFieldNumber > 0; nextFieldNumber = a.getNextFieldNumber(aVar2)) {
                if (!super.populateBuilderWithField(aVar2, this, nextFieldNumber)) {
                    aVar2.hPl();
                }
            }
            AppMethodBeat.o(168957);
            return 0;
        } else if (i2 == 3) {
            g.a.a.a.a aVar3 = (g.a.a.a.a) objArr[0];
            FinderFeedReportObject finderFeedReportObject = (FinderFeedReportObject) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    finderFeedReportObject.sessionId = aVar3.UbS.readString();
                    AppMethodBeat.o(168957);
                    return 0;
                case 2:
                    finderFeedReportObject.enterScene = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 3:
                    finderFeedReportObject.exitPageId = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 4:
                    finderFeedReportObject.enterTakePhotoTime = aVar3.UbS.zl();
                    AppMethodBeat.o(168957);
                    return 0;
                case 5:
                    finderFeedReportObject.enterVideoEditTime = aVar3.UbS.zl();
                    AppMethodBeat.o(168957);
                    return 0;
                case 6:
                    finderFeedReportObject.sendOrExitButtonTime = aVar3.UbS.zl();
                    AppMethodBeat.o(168957);
                    return 0;
                case 7:
                    finderFeedReportObject.videoRecordTime = aVar3.UbS.zl();
                    AppMethodBeat.o(168957);
                    return 0;
                case 8:
                    finderFeedReportObject.videoSource = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 9:
                    finderFeedReportObject.videoEmojiCount = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 10:
                    finderFeedReportObject.videoWordingCount = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 11:
                    finderFeedReportObject.videoMusicId = aVar3.UbS.readString();
                    AppMethodBeat.o(168957);
                    return 0;
                case 12:
                    finderFeedReportObject.videoMusicIndex = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 13:
                    finderFeedReportObject.videoMusicSearch = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 14:
                    finderFeedReportObject.videoPostType = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 15:
                    finderFeedReportObject.videoMediaInfo = aVar3.UbS.readString();
                    AppMethodBeat.o(168957);
                    return 0;
                case 16:
                    finderFeedReportObject.existDesc = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 17:
                    finderFeedReportObject.descCount = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 18:
                    finderFeedReportObject.descEmojiCount = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 19:
                    finderFeedReportObject.actionTrace = aVar3.UbS.readString();
                    AppMethodBeat.o(168957);
                    return 0;
                case 20:
                    finderFeedReportObject.existLocation = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 21:
                    finderFeedReportObject.link = aVar3.UbS.readString();
                    AppMethodBeat.o(168957);
                    return 0;
                case 22:
                    finderFeedReportObject.draft = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 23:
                    finderFeedReportObject.cdnEndTime = aVar3.UbS.zl();
                    AppMethodBeat.o(168957);
                    return 0;
                case 24:
                    finderFeedReportObject.remuxEndTime = aVar3.UbS.zl();
                    AppMethodBeat.o(168957);
                    return 0;
                case 25:
                    LinkedList<byte[]> awh = aVar3.awh(intValue);
                    int size = awh.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        FinderMediaReportObject finderMediaReportObject = new FinderMediaReportObject();
                        g.a.a.a.a aVar4 = new g.a.a.a.a(awh.get(i3), unknownTagHandler);
                        for (boolean z = true; z; z = finderMediaReportObject.populateBuilderWithField(aVar4, finderMediaReportObject, a.getNextFieldNumber(aVar4))) {
                        }
                        finderFeedReportObject.mediaList.add(finderMediaReportObject);
                    }
                    AppMethodBeat.o(168957);
                    return 0;
                case 26:
                    finderFeedReportObject.retryCount = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 27:
                    finderFeedReportObject.isBeauty = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 28:
                    finderFeedReportObject.isDurationCut = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 29:
                    finderFeedReportObject.beforeCutMediaPath = aVar3.UbS.readString();
                    AppMethodBeat.o(168957);
                    return 0;
                case 30:
                    finderFeedReportObject.isMultiShot = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 31:
                    finderFeedReportObject.multiShotChangeCnt = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 32:
                    finderFeedReportObject.multiShotClickCnt = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 33:
                    finderFeedReportObject.multiShotSuccessCnt = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 34:
                default:
                    AppMethodBeat.o(168957);
                    return -1;
                case 35:
                    finderFeedReportObject.multiShotVideoCnt = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 36:
                    finderFeedReportObject.videoSubType = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 37:
                    finderFeedReportObject.postId = aVar3.UbS.readString();
                    AppMethodBeat.o(168957);
                    return 0;
                case 38:
                    finderFeedReportObject.editId = aVar3.UbS.readString();
                    AppMethodBeat.o(168957);
                    return 0;
                case 39:
                    finderFeedReportObject.mentionCount = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 40:
                    finderFeedReportObject.clickMentionCount = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    finderFeedReportObject.clickSucMentionCount = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 42:
                    finderFeedReportObject.mentionRepeatCount = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 43:
                    finderFeedReportObject.lbsFlag = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 44:
                    LinkedList<byte[]> awh2 = aVar3.awh(intValue);
                    int size2 = awh2.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        axt axt = new axt();
                        g.a.a.a.a aVar5 = new g.a.a.a.a(awh2.get(i4), unknownTagHandler);
                        for (boolean z2 = true; z2; z2 = axt.populateBuilderWithField(aVar5, axt, a.getNextFieldNumber(aVar5))) {
                        }
                        finderFeedReportObject.selectLocation = axt;
                    }
                    AppMethodBeat.o(168957);
                    return 0;
                case 45:
                    finderFeedReportObject.remuxType = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 46:
                    finderFeedReportObject.uploadLogicError = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 47:
                    finderFeedReportObject.postStage = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                    finderFeedReportObject.cgiErrorCode = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 49:
                    finderFeedReportObject.cgiErrorType = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 50:
                    finderFeedReportObject.clickId = aVar3.UbS.readString();
                    AppMethodBeat.o(168957);
                    return 0;
                case 51:
                    finderFeedReportObject.soundTrackType = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 52:
                    finderFeedReportObject.followSoundTrackId = aVar3.UbS.readString();
                    AppMethodBeat.o(168957);
                    return 0;
                case 53:
                    finderFeedReportObject.megaCgiErrorCode = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 54:
                    finderFeedReportObject.megaCgiErrorType = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 55:
                    finderFeedReportObject.musicType = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 56:
                    finderFeedReportObject.longVideoSizeInvalid = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case n.CTRL_INDEX:
                    finderFeedReportObject.mediaProcessCost = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 58:
                    finderFeedReportObject.uploadCost = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case bv.CTRL_INDEX:
                    finderFeedReportObject.uploadMediaTotalSize = aVar3.UbS.zl();
                    AppMethodBeat.o(168957);
                    return 0;
                case 60:
                    finderFeedReportObject.postTaskCost = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case PlayerException.EXCEPTION_TYPE_INITLIB /*{ENCODED_INT: 61}*/:
                    finderFeedReportObject.clickRepostCount = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 62:
                    finderFeedReportObject.dumpCgiErrorCode = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 63:
                    finderFeedReportObject.dumpCgiErrorType = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 64:
                    finderFeedReportObject.sdkShareType = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 65:
                    finderFeedReportObject.forwardingAppId = aVar3.UbS.readString();
                    AppMethodBeat.o(168957);
                    return 0;
                case 66:
                    finderFeedReportObject.topicActivityId = aVar3.UbS.readString();
                    AppMethodBeat.o(168957);
                    return 0;
                case 67:
                    finderFeedReportObject.topicActivityType = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
                case 68:
                    finderFeedReportObject.draftType = aVar3.UbS.zi();
                    AppMethodBeat.o(168957);
                    return 0;
            }
        } else {
            AppMethodBeat.o(168957);
            return -1;
        }
    }
}
