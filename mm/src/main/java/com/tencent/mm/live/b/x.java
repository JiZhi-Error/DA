package com.tencent.mm.live.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.kernel.g;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.live.ui.LiveUIA;
import com.tencent.mm.model.aa;
import com.tencent.mm.n.h;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD = {1, 1, 16}, hxE = {"\u0000É\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u0002\n\u0002\b\r*\u0001\bÆ\u0002\u0018\u00002\u00020\u0001:\b×\u0001Ø\u0001Ù\u0001Ú\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0007\u0010Ê\u0001\u001a\u00020\u0004J\u0012\u0010Ë\u0001\u001a\u00020\u00042\t\u0010Ì\u0001\u001a\u0004\u0018\u00010\u0004J\b\u0010Í\u0001\u001a\u00030Î\u0001J\u0007\u0010Ï\u0001\u001a\u00020\u0004J\b\u0010Ð\u0001\u001a\u00030Î\u0001J\b\u0010Ñ\u0001\u001a\u00030Î\u0001J\b\u0010Ò\u0001\u001a\u00030Î\u0001J\b\u0010Ó\u0001\u001a\u00030Î\u0001J\b\u0010Ô\u0001\u001a\u00030Î\u0001J\b\u0010Õ\u0001\u001a\u00030Î\u0001J\u0018\u0010Ö\u0001\u001a\u00030Î\u00012\u0006\u0010&\u001a\u00020'2\u0006\u00107\u001a\u000202R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0013\"\u0004\b\"\u0010\u0015R\u001a\u0010#\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\b\"\u0004\b*\u0010\nR\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u00107\u001a\u000202X\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00104\"\u0004\b9\u00106R\u001a\u0010:\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00104\"\u0004\b;\u00106R\u001a\u0010<\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00104\"\u0004\b=\u00106R\u001a\u0010>\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00104\"\u0004\b?\u00106R\u001a\u0010@\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00104\"\u0004\bA\u00106R\u001a\u0010B\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u00104\"\u0004\bC\u00106R\u001a\u0010D\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00104\"\u0004\bE\u00106R\u001a\u0010F\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u00104\"\u0004\bG\u00106R\u001a\u0010H\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\b\"\u0004\bJ\u0010\nR\u001a\u0010K\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\b\"\u0004\bM\u0010\nR\u001c\u0010N\u001a\u0004\u0018\u00010OX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020UX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u001a\u0010Z\u001a\u00020[X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u001a\u0010`\u001a\u00020aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u001c\u0010f\u001a\u0004\u0018\u00010gX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001c\u0010l\u001a\u0004\u0018\u00010mX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR\u001a\u0010r\u001a\u00020sX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR\u001a\u0010x\u001a\u00020yX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010{\"\u0004\b|\u0010}R\u0011\u0010~\u001a\u00020X\u0004¢\u0006\u0005\n\u0003\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\b\"\u0005\b\u0001\u0010\nR \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\b\"\u0005\b\u0001\u0010\nR3\u0010\u0001\u001a\u0016\u0012\u0005\u0012\u00030\u00010\u0001j\n\u0012\u0005\u0012\u00030\u0001`\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R1\u0010\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00040\u0001j\t\u0012\u0004\u0012\u00020\u0004`\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b \u0001\u0010\u0001R{\u0010¡\u0001\u001a^\u0012\u0004\u0012\u00020\u0004\u0012#\u0012!\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u00040\u0001j\t\u0012\u0004\u0012\u00020\u0004`\u0001\u0012\u0004\u0012\u00020\u00060£\u00010¢\u0001j.\u0012\u0004\u0012\u00020\u0004\u0012#\u0012!\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u00040\u0001j\t\u0012\u0004\u0012\u00020\u0004`\u0001\u0012\u0004\u0012\u00020\u00060£\u0001`¤\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001\"\u0006\b§\u0001\u0010¨\u0001R \u0010©\u0001\u001a\u00030\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bª\u0001\u0010\u0001\"\u0006\b«\u0001\u0010\u0001R \u0010¬\u0001\u001a\u00030­\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b®\u0001\u0010¯\u0001\"\u0006\b°\u0001\u0010±\u0001R\u001f\u0010²\u0001\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b³\u0001\u0010\u0013\"\u0005\b´\u0001\u0010\u0015R\u001d\u0010µ\u0001\u001a\u00020\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¶\u0001\u0010\b\"\u0005\b·\u0001\u0010\nR\u001d\u0010¸\u0001\u001a\u00020\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¹\u0001\u0010\b\"\u0005\bº\u0001\u0010\nR\u001d\u0010»\u0001\u001a\u00020\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¼\u0001\u0010\b\"\u0005\b½\u0001\u0010\nR\u001d\u0010¾\u0001\u001a\u00020\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¿\u0001\u0010\b\"\u0005\bÀ\u0001\u0010\nR\u001d\u0010Á\u0001\u001a\u00020\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÂ\u0001\u0010\b\"\u0005\bÃ\u0001\u0010\nR\u001d\u0010Ä\u0001\u001a\u00020\u0006X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÅ\u0001\u0010\b\"\u0005\bÆ\u0001\u0010\nR\u001d\u0010Ç\u0001\u001a\u00020\u0004X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÈ\u0001\u0010\u0013\"\u0005\bÉ\u0001\u0010\u0015¨\u0006Û\u0001"}, hxF = {"Lcom/tencent/mm/live/model/RoomLiveService;", "", "()V", "TAG", "", "anchorLinkSuccessCountPerShow", "", "getAnchorLinkSuccessCountPerShow", "()I", "setAnchorLinkSuccessCountPerShow", "(I)V", "anchorStatus", "Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "getAnchorStatus", "()Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;", "setAnchorStatus", "(Lcom/tencent/mm/protocal/protobuf/LiveAnchorStatus;)V", "anchorUserName", "getAnchorUserName", "()Ljava/lang/String;", "setAnchorUserName", "(Ljava/lang/String;)V", "value", "audienceCountMax", "getAudienceCountMax", "setAudienceCountMax", "beautyConfig", "Lcom/tencent/mm/live/core/render/BeautyConfig;", "getBeautyConfig", "()Lcom/tencent/mm/live/core/render/BeautyConfig;", "setBeautyConfig", "(Lcom/tencent/mm/live/core/render/BeautyConfig;)V", "callingMicNickname", "getCallingMicNickname", "setCallingMicNickname", "callingMicUsername", "getCallingMicUsername", "setCallingMicUsername", "context", "Landroid/content/Context;", "enterFromScene", "getEnterFromScene", "setEnterFromScene", "filterConfig", "Lcom/tencent/mm/live/core/render/FilterConfig;", "getFilterConfig", "()Lcom/tencent/mm/live/core/render/FilterConfig;", "setFilterConfig", "(Lcom/tencent/mm/live/core/render/FilterConfig;)V", "hasChangeVideoModePerLinkMic", "", "getHasChangeVideoModePerLinkMic", "()Z", "setHasChangeVideoModePerLinkMic", "(Z)V", "isAnchor", "isClickStartLive", "setClickStartLive", "isForeigner", "setForeigner", "isLiveNameChanged", "setLiveNameChanged", "isManualClosed", "setManualClosed", "isStartLiveReport", "setStartLiveReport", "isVerifyChecked", "setVerifyChecked", "isVerifyUiShow", "setVerifyUiShow", "isVisitorReport", "setVisitorReport", "lastOrientation", "getLastOrientation", "setLastOrientation", "linkMicRequestCount", "getLinkMicRequestCount", "setLinkMicRequestCount", "liveCookies", "", "getLiveCookies", "()[B", "setLiveCookies", "([B)V", "liveDynamicConfig", "Lcom/tencent/mm/live/model/RoomLiveService$LiveDynamicConfig;", "getLiveDynamicConfig", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveDynamicConfig;", "setLiveDynamicConfig", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveDynamicConfig;)V", "liveFaceVerifyInfo", "Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;", "getLiveFaceVerifyInfo", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;", "setLiveFaceVerifyInfo", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;)V", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "getLiveInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveInfo;", "setLiveInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveInfo;)V", "liveRoomModel", "Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "getLiveRoomModel", "()Lcom/tencent/mm/live/core/core/model/LiveRoomModel;", "setLiveRoomModel", "(Lcom/tencent/mm/live/core/core/model/LiveRoomModel;)V", "liveSdkInfo", "Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "getLiveSdkInfo", "()Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;", "setLiveSdkInfo", "(Lcom/tencent/mm/protocal/protobuf/LiveSdkInfo;)V", "liveSmallWindowInfo", "Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;", "getLiveSmallWindowInfo", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;", "setLiveSmallWindowInfo", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;)V", "liveStatus", "Lcom/tencent/mm/live/model/RoomLiveService$LiveStatus;", "getLiveStatus", "()Lcom/tencent/mm/live/model/RoomLiveService$LiveStatus;", "setLiveStatus", "(Lcom/tencent/mm/live/model/RoomLiveService$LiveStatus;)V", "mCheckDeviceLsn", "com/tencent/mm/live/model/RoomLiveService$mCheckDeviceLsn$1", "Lcom/tencent/mm/live/model/RoomLiveService$mCheckDeviceLsn$1;", "mLastOrientation", "getMLastOrientation", "setMLastOrientation", "mStartLinkTimes", "", "getMStartLinkTimes", "()J", "setMStartLinkTimes", "(J)V", "micPmkExpire", "getMicPmkExpire", "setMicPmkExpire", "miniWindowClickListener", "Landroid/view/View$OnClickListener;", "getMiniWindowClickListener", "()Landroid/view/View$OnClickListener;", "setMiniWindowClickListener", "(Landroid/view/View$OnClickListener;)V", "msgFilterTime", "getMsgFilterTime", "setMsgFilterTime", "msgList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/view/adapter/CommentData;", "Lkotlin/collections/ArrayList;", "getMsgList", "()Ljava/util/ArrayList;", "setMsgList", "(Ljava/util/ArrayList;)V", "onlineHeadImgList", "getOnlineHeadImgList", "setOnlineHeadImgList", "shareRoomList", "Ljava/util/HashMap;", "Lkotlin/Pair;", "Lkotlin/collections/HashMap;", "getShareRoomList", "()Ljava/util/HashMap;", "setShareRoomList", "(Ljava/util/HashMap;)V", "startAudienceUV", "getStartAudienceUV", "setStartAudienceUV", "sysMsgManager", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "getSysMsgManager", "()Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;", "setSysMsgManager", "(Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager;)V", "thumbUrl", "getThumbUrl", "setThumbUrl", "visitorCommentCount", "getVisitorCommentCount", "setVisitorCommentCount", "visitorConnectCount", "getVisitorConnectCount", "setVisitorConnectCount", "visitorConnectReqCount", "getVisitorConnectReqCount", "setVisitorConnectReqCount", "visitorEnterErrorCode", "getVisitorEnterErrorCode", "setVisitorEnterErrorCode", "visitorEnterMemberCount", "getVisitorEnterMemberCount", "setVisitorEnterMemberCount", "visitorLikeCount", "getVisitorLikeCount", "setVisitorLikeCount", "wechatRoomId", "getWechatRoomId", "setWechatRoomId", "displayLiveName", "displayUsername", ch.COL_USERNAME, "finishCurLive", "", "formatLikeCount", "liveError", "liveFinish", "liveStart", "release", "resetData", "resetLiveFaceVerifyInfo", "setup", "LiveDynamicConfig", "LiveFaceVerifyInfo", "LiveSmallWindowInfo", "LiveStatus", "plugin-logic_release"})
public final class x {
    private static final String TAG = TAG;
    private static Context context;
    private static boolean dMz;
    private static com.tencent.mm.live.core.b.a hDV;
    private static com.tencent.mm.live.core.b.b hDW;
    private static String hFW = "";
    private static ciq hIA = new ciq();
    private static String hIB = "";
    private static String hIC = "";
    private static boolean hID;
    private static d hIE = new d((byte) 0);
    private static b hIF = new b();
    private static a hIG = new a((byte) 0);
    private static c hIH = new c();
    private static boolean hII;
    private static boolean hIJ;
    private static boolean hIK;
    private static boolean hIL;
    private static boolean hIM;
    private static int hIN;
    private static int hIO;
    private static int hIP;
    private static int hIQ = -1;
    private static int hIR;
    private static int hIS;
    private static int hIT;
    private static int hIU;
    private static boolean hIV;
    private static int hIW;
    private static int hIX;
    private static int hIY;
    private static long hIZ;
    private static ArrayList<String> hIq = new ArrayList<>();
    private static HashMap<String, o<ArrayList<String>, Integer>> hIr = new HashMap<>();
    private static ArrayList<com.tencent.mm.live.view.a.a> hIs = new ArrayList<>();
    private static byte[] hIt;
    private static civ hIu = new civ();
    private static cjb hIv;
    private static String hIw = "";
    private static int hIx;
    private static com.tencent.mm.live.core.core.b.f hIy;
    private static long hIz;
    private static boolean hJa;
    private static com.tencent.mm.live.b.b.a hJb = new com.tencent.mm.live.b.b.a();
    private static long hJc;
    private static final e hJd = new e();
    private static View.OnClickListener hJe = f.hJr;
    public static final x hJf = new x();
    private static boolean isManualClosed;
    private static int lastOrientation = -1;
    private static String thumbUrl;

    static {
        AppMethodBeat.i(207732);
        com.tencent.mm.live.core.b.a aVar = new com.tencent.mm.live.core.b.a();
        e.c cVar = e.c.hxm;
        aVar.hDh.put(Integer.valueOf(e.c.aCh()), 60);
        e.c cVar2 = e.c.hxm;
        aVar.hDh.put(Integer.valueOf(e.c.aCi()), -1);
        e.c cVar3 = e.c.hxm;
        aVar.hDh.put(Integer.valueOf(e.c.aCl()), -1);
        e.c cVar4 = e.c.hxm;
        aVar.hDh.put(Integer.valueOf(e.c.aCj()), -1);
        e.c cVar5 = e.c.hxm;
        aVar.hDh.put(Integer.valueOf(e.c.aCm()), -1);
        e.c cVar6 = e.c.hxm;
        aVar.hDh.put(Integer.valueOf(e.c.aCk()), -1);
        hDV = aVar;
        hJd.alive();
        AppMethodBeat.o(207732);
    }

    private x() {
    }

    public static com.tencent.mm.live.core.b.a aGk() {
        return hDV;
    }

    public static com.tencent.mm.live.core.b.b aGl() {
        return hDW;
    }

    public static void GQ(String str) {
        AppMethodBeat.i(207720);
        p.h(str, "<set-?>");
        hFW = str;
        AppMethodBeat.o(207720);
    }

    public static String aGm() {
        return hFW;
    }

    public static ArrayList<String> aGn() {
        return hIq;
    }

    public static HashMap<String, o<ArrayList<String>, Integer>> aGo() {
        return hIr;
    }

    public static ArrayList<com.tencent.mm.live.view.a.a> aGp() {
        return hIs;
    }

    public static byte[] aGq() {
        return hIt;
    }

    public static void ad(byte[] bArr) {
        hIt = bArr;
    }

    public static void a(civ civ) {
        AppMethodBeat.i(207721);
        p.h(civ, "<set-?>");
        hIu = civ;
        AppMethodBeat.o(207721);
    }

    public static civ aGr() {
        return hIu;
    }

    public static void a(cjb cjb) {
        hIv = cjb;
    }

    public static cjb aGs() {
        return hIv;
    }

    public static void GR(String str) {
        thumbUrl = str;
    }

    public static void GS(String str) {
        AppMethodBeat.i(207722);
        p.h(str, "<set-?>");
        hIw = str;
        AppMethodBeat.o(207722);
    }

    public static String aGt() {
        return hIw;
    }

    public static int aGu() {
        return hIx;
    }

    public static void qT(int i2) {
        hIx = i2;
    }

    public static com.tencent.mm.live.core.core.b.f aGv() {
        return hIy;
    }

    public static void b(com.tencent.mm.live.core.core.b.f fVar) {
        hIy = fVar;
    }

    public static long aGw() {
        return hIz;
    }

    public static void zB(long j2) {
        hIz = j2;
    }

    public static void a(ciq ciq) {
        AppMethodBeat.i(207723);
        p.h(ciq, "<set-?>");
        hIA = ciq;
        AppMethodBeat.o(207723);
    }

    public static ciq aGx() {
        return hIA;
    }

    public static void aGy() {
        isManualClosed = true;
    }

    public static boolean isManualClosed() {
        return isManualClosed;
    }

    public static int getLastOrientation() {
        return lastOrientation;
    }

    public static void setLastOrientation(int i2) {
        lastOrientation = i2;
    }

    public static void GT(String str) {
        AppMethodBeat.i(207724);
        p.h(str, "<set-?>");
        hIB = str;
        AppMethodBeat.o(207724);
    }

    public static String aGz() {
        return hIB;
    }

    public static void GU(String str) {
        AppMethodBeat.i(207725);
        p.h(str, "<set-?>");
        hIC = str;
        AppMethodBeat.o(207725);
    }

    public static String aGA() {
        return hIC;
    }

    public static boolean aGB() {
        return hID;
    }

    public static void aGC() {
        hID = true;
    }

    public static d aGD() {
        return hIE;
    }

    public static b aGE() {
        return hIF;
    }

    public static a aGF() {
        return hIG;
    }

    public static c aGG() {
        return hIH;
    }

    public static boolean aGH() {
        return hII;
    }

    public static void eH(boolean z) {
        hII = z;
    }

    public static boolean aGI() {
        return hIJ;
    }

    public static void eI(boolean z) {
        hIJ = z;
    }

    public static boolean aGJ() {
        return hIK;
    }

    public static void eJ(boolean z) {
        hIK = z;
    }

    public static boolean aGK() {
        return hIL;
    }

    public static void eK(boolean z) {
        hIL = z;
    }

    public static boolean aGL() {
        return hIM;
    }

    public static void eL(boolean z) {
        hIM = z;
    }

    public static int aGM() {
        return hIN;
    }

    public static void qU(int i2) {
        if (hIN < i2) {
            hIN = i2;
        } else if (i2 == -1) {
            hIN = 0;
        }
    }

    public static int aGN() {
        return hIO;
    }

    public static void qV(int i2) {
        hIO = i2;
    }

    public static int aGO() {
        return hIP;
    }

    public static void qW(int i2) {
        hIP = i2;
    }

    public static int aGP() {
        return hIQ;
    }

    public static void qX(int i2) {
        hIQ = i2;
    }

    public static int aGQ() {
        return hIR;
    }

    public static void qY(int i2) {
        hIR = i2;
    }

    public static int aGR() {
        return hIS;
    }

    public static void qZ(int i2) {
        hIS = i2;
    }

    public static int aGS() {
        return hIT;
    }

    public static void ra(int i2) {
        hIT = i2;
    }

    public static int aGT() {
        return hIU;
    }

    public static void rb(int i2) {
        hIU = i2;
    }

    public static boolean aGU() {
        return hIV;
    }

    public static void eM(boolean z) {
        hIV = z;
    }

    public static int aGV() {
        return hIW;
    }

    public static void rc(int i2) {
        hIW = i2;
    }

    public static int aGW() {
        return hIX;
    }

    public static void rd(int i2) {
        hIX = i2;
    }

    public static int aGX() {
        return hIY;
    }

    public static void re(int i2) {
        hIY = i2;
    }

    public static long aGY() {
        return hIZ;
    }

    public static void zC(long j2) {
        hIZ = j2;
    }

    public static boolean aGZ() {
        return hJa;
    }

    public static void eN(boolean z) {
        hJa = z;
    }

    public static com.tencent.mm.live.b.b.a aHa() {
        return hJb;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/live/model/RoomLiveService$mCheckDeviceLsn$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/LiveStateActionEvent;", "callback", "", "event", "plugin-logic_release"})
    public static final class e extends IListener<lv> {
        e() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lv lvVar) {
            lv.a aVar;
            lv.a aVar2;
            lv.a aVar3;
            lv.a aVar4;
            lv.a aVar5;
            lv.a aVar6;
            lv.a aVar7;
            boolean z;
            AppMethodBeat.i(207717);
            lv lvVar2 = lvVar;
            if (!(lvVar2 == null || (aVar7 = lvVar2.dRl) == null)) {
                com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.live.a.class);
                p.g(ah, "MMKernel.plugin(IPluginLive::class.java)");
                if (!((com.tencent.mm.live.a) ah).isAnchorLiving()) {
                    com.tencent.mm.kernel.b.a ah2 = g.ah(com.tencent.mm.live.a.class);
                    p.g(ah2, "MMKernel.plugin(IPluginLive::class.java)");
                    if (!((com.tencent.mm.live.a) ah2).isVisitorLiving()) {
                        z = false;
                        aVar7.isStart = z;
                    }
                }
                z = true;
                aVar7.isStart = z;
            }
            x xVar = x.hJf;
            if (x.aGr().hyH != 0) {
                b.a aVar8 = com.tencent.mm.live.core.core.d.b.hCo;
                if (b.a.aDp()) {
                    if (!(lvVar2 == null || (aVar6 = lvVar2.dRl) == null)) {
                        aVar6.dMz = false;
                    }
                    if (!(lvVar2 == null || (aVar5 = lvVar2.dRl) == null)) {
                        b.a aVar9 = com.tencent.mm.live.core.core.d.b.hCo;
                        MMApplicationContext.getContext();
                        aVar5.dRm = b.a.aEf().hAz.aDu();
                    }
                    if (!(lvVar2 == null || (aVar4 = lvVar2.dRl) == null)) {
                        b.a aVar10 = com.tencent.mm.live.core.core.d.b.hCo;
                        MMApplicationContext.getContext();
                        aVar4.dRn = b.a.aEf().hAz.aDt();
                    }
                } else {
                    b.a aVar11 = com.tencent.mm.live.core.core.a.b.hyv;
                    if (b.a.aDp()) {
                        if (!(lvVar2 == null || (aVar3 = lvVar2.dRl) == null)) {
                            aVar3.dMz = true;
                        }
                        if (!(lvVar2 == null || (aVar2 = lvVar2.dRl) == null)) {
                            b.a aVar12 = com.tencent.mm.live.core.core.a.b.hyv;
                            MMApplicationContext.getContext();
                            aVar2.dRm = b.a.aDo().hAz.aDu();
                        }
                        if (!(lvVar2 == null || (aVar = lvVar2.dRl) == null)) {
                            b.a aVar13 = com.tencent.mm.live.core.core.a.b.hyv;
                            MMApplicationContext.getContext();
                            aVar.dRn = b.a.aDo().hAz.aDt();
                        }
                    }
                }
            }
            AppMethodBeat.o(207717);
            return true;
        }
    }

    public static long aHb() {
        return hJc;
    }

    public static void zD(long j2) {
        hJc = j2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f implements View.OnClickListener {
        public static final f hJr = new f();

        static {
            AppMethodBeat.i(207719);
            AppMethodBeat.o(207719);
        }

        f() {
        }

        public final void onClick(View view) {
            AppMethodBeat.i(207718);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/model/RoomLiveService$miniWindowClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent(MMApplicationContext.getContext(), LiveUIA.class);
            intent.putExtra("route_to_maximize", true);
            intent.addFlags(268435456);
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/live/model/RoomLiveService$miniWindowClickListener$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/live/model/RoomLiveService$miniWindowClickListener$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/model/RoomLiveService$miniWindowClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(207718);
        }
    }

    public static View.OnClickListener aHc() {
        return hJe;
    }

    public static String aHd() {
        AppMethodBeat.i(207726);
        if (hIu.LXG <= 0) {
            Context context2 = MMApplicationContext.getContext();
            p.g(context2, "MMApplicationContext.getContext()");
            String string = context2.getResources().getString(R.string.egm);
            p.g(string, "MMApplicationContext.get…ing.live_like_count_zero)");
            AppMethodBeat.o(207726);
            return string;
        } else if (hIu.LXG < 10000) {
            String valueOf = String.valueOf(hIu.LXG);
            AppMethodBeat.o(207726);
            return valueOf;
        } else if (hIu.LXG % 10000 >= 1000) {
            ae aeVar = ae.SYK;
            Context context3 = MMApplicationContext.getContext();
            p.g(context3, "MMApplicationContext.getContext()");
            String string2 = context3.getResources().getString(R.string.egk);
            p.g(string2, "MMApplicationContext.get…g.live_like_count_format)");
            String format = String.format(string2, Arrays.copyOf(new Object[]{Float.valueOf(((float) hIu.LXG) / 10000.0f)}, 1));
            p.g(format, "java.lang.String.format(format, *args)");
            AppMethodBeat.o(207726);
            return format;
        } else {
            ae aeVar2 = ae.SYK;
            Context context4 = MMApplicationContext.getContext();
            p.g(context4, "MMApplicationContext.getContext()");
            String string3 = context4.getResources().getString(R.string.egl);
            p.g(string3, "MMApplicationContext.get…ve_like_count_int_format)");
            String format2 = String.format(string3, Arrays.copyOf(new Object[]{Integer.valueOf(hIu.LXG / 10000)}, 1));
            p.g(format2, "java.lang.String.format(format, *args)");
            AppMethodBeat.o(207726);
            return format2;
        }
    }

    public static String aHe() {
        String str;
        AppMethodBeat.i(207727);
        if (Util.isNullOrNil(hIu.LpF)) {
            str = hIu.MnO;
            if (str == null) {
                AppMethodBeat.o(207727);
                return "";
            }
        } else {
            str = hIu.LpF;
            if (str == null) {
                str = "";
            }
        }
        AppMethodBeat.o(207727);
        return str;
    }

    public static String GV(String str) {
        AppMethodBeat.i(207728);
        if (str == null) {
            AppMethodBeat.o(207728);
            return "";
        }
        String Is = aa.Is(str);
        if (Util.isNullOrNil(Is)) {
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.chatroom.a.c.class);
            p.g(af, "MMKernel.service(IChatroomService::class.java)");
            ah Kd = ((com.tencent.mm.plugin.chatroom.a.c) af).aSX().Kd(hFW);
            if (Kd == null) {
                Is = aa.getDisplayName(str);
            } else {
                Is = Kd.getDisplayName(str);
                if (Util.isNullOrNil(Is)) {
                    Is = aa.getDisplayName(str);
                }
            }
        }
        p.g(Is, "result");
        AppMethodBeat.o(207728);
        return Is;
    }

    public static void aHf() {
        hIE.hJo = true;
        hIE.hJn = false;
    }

    public static void aHg() {
        hIE.hJp = true;
    }

    public static void aHh() {
        hIE.hJn = true;
        hIE.hJo = false;
    }

    public static void and() {
        AppMethodBeat.i(207729);
        Log.printInfoStack(TAG, "resetData", new Object[0]);
        hIz = 0;
        hFW = "";
        hIq.clear();
        hIr.clear();
        hIt = null;
        hIu = new civ();
        hIv = null;
        thumbUrl = null;
        com.tencent.mm.live.b.b.a aVar = hJb;
        aVar.hKM = null;
        aVar.hKN = null;
        aVar.hKO = null;
        aVar.hKP = null;
        aVar.hKQ = null;
        aVar.hKR = null;
        aVar.hKS = null;
        aVar.hKU = null;
        aVar.hKT.clear();
        aVar.hKV = "";
        aVar.hKW = "";
        hIs.clear();
        hIw = "";
        hIx = 0;
        hIy = null;
        hIA = new ciq();
        isManualClosed = false;
        lastOrientation = -1;
        hIB = "";
        hIC = "";
        hIG = new a((byte) 0);
        hIH = new c();
        hID = false;
        hIE = new d((byte) 0);
        hIF = new b();
        context = null;
        dMz = false;
        AppMethodBeat.o(207729);
    }

    public static void u(Context context2, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        AppMethodBeat.i(207730);
        p.h(context2, "context");
        dMz = z;
        context = context2;
        int i2 = Util.getInt(h.aqJ().getValue("MMLiveConfigBitSet"), 0);
        a aVar = hIG;
        if (!com.tencent.mm.ac.d.cW(i2, 1)) {
            z2 = true;
        } else {
            z2 = false;
        }
        aVar.hJg = z2;
        a aVar2 = hIG;
        if (!com.tencent.mm.ac.d.cW(i2, 2)) {
            z3 = true;
        } else {
            z3 = false;
        }
        aVar2.hJh = z3;
        a aVar3 = hIG;
        if (!com.tencent.mm.ac.d.cW(i2, 4)) {
            z4 = true;
        } else {
            z4 = false;
        }
        aVar3.hJi = z4;
        a aVar4 = hIG;
        if (com.tencent.mm.ac.d.cW(i2, 8)) {
            z5 = false;
        }
        aVar4.hJj = z5;
        AppMethodBeat.o(207730);
    }

    public static void aHi() {
        AppMethodBeat.i(207731);
        Context context2 = context;
        if (context2 != null) {
            if (context2 instanceof Activity) {
                if (dMz) {
                    b.a aVar = com.tencent.mm.live.core.core.a.b.hyv;
                    b.a.aDo().aBU();
                } else {
                    b.a aVar2 = com.tencent.mm.live.core.core.d.b.hCo;
                    b.a.aEf().aBU();
                }
                ((Activity) context2).finishAndRemoveTask();
            }
            AppMethodBeat.o(207731);
            return;
        }
        AppMethodBeat.o(207731);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/live/model/RoomLiveService$LiveStatus;", "", "liveFinished", "", "liveStarted", "liveHasError", "liveJumpToOtherUI", "(ZZZZ)V", "getLiveFinished", "()Z", "setLiveFinished", "(Z)V", "getLiveHasError", "setLiveHasError", "getLiveJumpToOtherUI", "setLiveJumpToOtherUI", "getLiveStarted", "setLiveStarted", "component1", "component2", "component3", "component4", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-logic_release"})
    public static final class d {
        public boolean hJn;
        public boolean hJo;
        public boolean hJp;
        public boolean hJq;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof d) {
                    d dVar = (d) obj;
                    if (!(this.hJn == dVar.hJn && this.hJo == dVar.hJo && this.hJp == dVar.hJp && this.hJq == dVar.hJq)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i2 = 1;
            boolean z = this.hJn;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = i3 * 31;
            boolean z2 = this.hJo;
            if (z2) {
                z2 = true;
            }
            int i7 = z2 ? 1 : 0;
            int i8 = z2 ? 1 : 0;
            int i9 = z2 ? 1 : 0;
            int i10 = (i7 + i6) * 31;
            boolean z3 = this.hJp;
            if (z3) {
                z3 = true;
            }
            int i11 = z3 ? 1 : 0;
            int i12 = z3 ? 1 : 0;
            int i13 = z3 ? 1 : 0;
            int i14 = (i11 + i10) * 31;
            boolean z4 = this.hJq;
            if (!z4) {
                i2 = z4 ? 1 : 0;
            }
            return i14 + i2;
        }

        public final String toString() {
            AppMethodBeat.i(207716);
            String str = "LiveStatus(liveFinished=" + this.hJn + ", liveStarted=" + this.hJo + ", liveHasError=" + this.hJp + ", liveJumpToOtherUI=" + this.hJq + ")";
            AppMethodBeat.o(207716);
            return str;
        }

        private d() {
            this.hJn = false;
            this.hJo = false;
            this.hJp = false;
            this.hJq = false;
        }

        public /* synthetic */ d(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/live/model/RoomLiveService$LiveDynamicConfig;", "", "enableLandscape", "", "enableCheckPhoneNum", "enableVisitorPolicyPage", "enableVerifyPage", "(ZZZZ)V", "getEnableCheckPhoneNum", "()Z", "setEnableCheckPhoneNum", "(Z)V", "getEnableLandscape", "setEnableLandscape", "getEnableVerifyPage", "setEnableVerifyPage", "getEnableVisitorPolicyPage", "setEnableVisitorPolicyPage", "component1", "component2", "component3", "component4", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "plugin-logic_release"})
    public static final class a {
        public boolean hJg;
        boolean hJh;
        boolean hJi;
        boolean hJj;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (!(this.hJg == aVar.hJg && this.hJh == aVar.hJh && this.hJi == aVar.hJi && this.hJj == aVar.hJj)) {
                        return false;
                    }
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            int i2 = 1;
            boolean z = this.hJg;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = i3 * 31;
            boolean z2 = this.hJh;
            if (z2) {
                z2 = true;
            }
            int i7 = z2 ? 1 : 0;
            int i8 = z2 ? 1 : 0;
            int i9 = z2 ? 1 : 0;
            int i10 = (i7 + i6) * 31;
            boolean z3 = this.hJi;
            if (z3) {
                z3 = true;
            }
            int i11 = z3 ? 1 : 0;
            int i12 = z3 ? 1 : 0;
            int i13 = z3 ? 1 : 0;
            int i14 = (i11 + i10) * 31;
            boolean z4 = this.hJj;
            if (!z4) {
                i2 = z4 ? 1 : 0;
            }
            return i14 + i2;
        }

        public final String toString() {
            AppMethodBeat.i(207703);
            String str = "LiveDynamicConfig(enableLandscape=" + this.hJg + ", enableCheckPhoneNum=" + this.hJh + ", enableVisitorPolicyPage=" + this.hJi + ", enableVerifyPage=" + this.hJj + ")";
            AppMethodBeat.o(207703);
            return str;
        }

        private a() {
            this.hJg = true;
            this.hJh = true;
            this.hJi = true;
            this.hJj = true;
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u001e\u001a\u00020\u001bJ\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006 "}, hxF = {"Lcom/tencent/mm/live/model/RoomLiveService$LiveSmallWindowInfo;", "", "userId", "", "streamType", "", "width", "height", "(Ljava/lang/String;III)V", "getHeight", "()I", "setHeight", "(I)V", "getStreamType", "setStreamType", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "getWidth", "setWidth", "component1", "component2", "component3", "component4", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "isLandscape", "toString", "plugin-logic_release"})
    public static final class c {
        public int height;
        public int streamType;
        public String userId;
        public int width;

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0028, code lost:
            if (r3.height == r4.height) goto L_0x002a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 207715(0x32b63, float:2.91071E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x002a
                boolean r0 = r4 instanceof com.tencent.mm.live.b.x.c
                if (r0 == 0) goto L_0x002f
                com.tencent.mm.live.b.x$c r4 = (com.tencent.mm.live.b.x.c) r4
                java.lang.String r0 = r3.userId
                java.lang.String r1 = r4.userId
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x002f
                int r0 = r3.streamType
                int r1 = r4.streamType
                if (r0 != r1) goto L_0x002f
                int r0 = r3.width
                int r1 = r4.width
                if (r0 != r1) goto L_0x002f
                int r0 = r3.height
                int r1 = r4.height
                if (r0 != r1) goto L_0x002f
            L_0x002a:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x002e:
                return r0
            L_0x002f:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x002e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.x.c.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            AppMethodBeat.i(207714);
            String str = this.userId;
            int hashCode = ((((((str != null ? str.hashCode() : 0) * 31) + this.streamType) * 31) + this.width) * 31) + this.height;
            AppMethodBeat.o(207714);
            return hashCode;
        }

        public final String toString() {
            AppMethodBeat.i(207713);
            String str = "LiveSmallWindowInfo(userId=" + this.userId + ", streamType=" + this.streamType + ", width=" + this.width + ", height=" + this.height + ")";
            AppMethodBeat.o(207713);
            return str;
        }

        public /* synthetic */ c() {
            this("");
            AppMethodBeat.i(207712);
            AppMethodBeat.o(207712);
        }

        private c(String str) {
            p.h(str, "userId");
            AppMethodBeat.i(207711);
            this.userId = str;
            this.streamType = 0;
            this.width = 0;
            this.height = 0;
            AppMethodBeat.o(207711);
        }

        public final void setUserId(String str) {
            AppMethodBeat.i(207710);
            p.h(str, "<set-?>");
            this.userId = str;
            AppMethodBeat.o(207710);
        }

        public final boolean isLandscape() {
            return this.width > this.height;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/live/model/RoomLiveService$LiveFaceVerifyInfo;", "", "needFaceVerify", "", "verifyUrl", "", "isFromAnchor", "(ZLjava/lang/String;Z)V", "()Z", "setFromAnchor", "(Z)V", "getNeedFaceVerify", "setNeedFaceVerify", "getVerifyUrl", "()Ljava/lang/String;", "setVerifyUrl", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "plugin-logic_release"})
    public static final class b {
        public boolean hJk;
        public String hJl;
        public boolean hJm;

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
            if (r3.hJm == r4.hJm) goto L_0x0024;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 207709(0x32b5d, float:2.91062E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0024
                boolean r0 = r4 instanceof com.tencent.mm.live.b.x.b
                if (r0 == 0) goto L_0x0029
                com.tencent.mm.live.b.x$b r4 = (com.tencent.mm.live.b.x.b) r4
                boolean r0 = r3.hJk
                boolean r1 = r4.hJk
                if (r0 != r1) goto L_0x0029
                java.lang.String r0 = r3.hJl
                java.lang.String r1 = r4.hJl
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0029
                boolean r0 = r3.hJm
                boolean r1 = r4.hJm
                if (r0 != r1) goto L_0x0029
            L_0x0024:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0028:
                return r0
            L_0x0029:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0028
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.live.b.x.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 1;
            AppMethodBeat.i(207708);
            boolean z = this.hJk;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = i3 * 31;
            String str = this.hJl;
            int hashCode = ((str != null ? str.hashCode() : 0) + i6) * 31;
            boolean z2 = this.hJm;
            if (!z2) {
                i2 = z2 ? 1 : 0;
            }
            int i7 = hashCode + i2;
            AppMethodBeat.o(207708);
            return i7;
        }

        public final String toString() {
            AppMethodBeat.i(207707);
            String str = "LiveFaceVerifyInfo(needFaceVerify=" + this.hJk + ", verifyUrl=" + this.hJl + ", isFromAnchor=" + this.hJm + ")";
            AppMethodBeat.o(207707);
            return str;
        }

        public /* synthetic */ b() {
            this("");
            AppMethodBeat.i(207706);
            AppMethodBeat.o(207706);
        }

        private b(String str) {
            p.h(str, "verifyUrl");
            AppMethodBeat.i(207705);
            this.hJk = false;
            this.hJl = str;
            this.hJm = true;
            AppMethodBeat.o(207705);
        }

        public final void GW(String str) {
            AppMethodBeat.i(207704);
            p.h(str, "<set-?>");
            this.hJl = str;
            AppMethodBeat.o(207704);
        }
    }
}
