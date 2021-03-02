package com.tencent.mm.plugin.finder.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.d.a;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.at;
import com.tencent.mm.plugin.finder.live.model.FinderLiveConfig;
import com.tencent.mm.plugin.finder.live.model.g;
import com.tencent.mm.plugin.finder.live.model.n;
import com.tencent.mm.plugin.finder.live.plugin.aj;
import com.tencent.mm.plugin.finder.live.plugin.y;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.ffr;
import com.tencent.mm.protocal.protobuf.fge;
import com.tencent.mm.protocal.protobuf.fgf;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.tools.f;
import com.tencent.rtmp.TXLivePlayConfig;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.r;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000®\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013J\u0010\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0017\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\"\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u001e\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\u001f\u001a\u00020\u0013J\u0006\u0010 \u001a\u00020\u0013J\u000e\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#J\u0018\u0010$\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&J\u0006\u0010'\u001a\u00020\tJ\u0018\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u001bJ0\u0010-\u001a\u00020.2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020100j\b\u0012\u0004\u0012\u000201`22\u0006\u00103\u001a\u0002012\b\b\u0002\u00104\u001a\u00020\u001bJ8\u00105\u001a\u00020.2\u0016\u0010/\u001a\u0012\u0012\u0004\u0012\u00020100j\b\u0012\u0004\u0012\u000201`22\u0006\u00103\u001a\u0002012\u0006\u00106\u001a\u00020\u001b2\b\b\u0002\u00104\u001a\u00020\u001bJ\f\u00107\u001a\b\u0012\u0004\u0012\u00020&08J\u0010\u00109\u001a\u0004\u0018\u00010\u00042\u0006\u0010\"\u001a\u00020#J\u0016\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001b2\u0006\u0010=\u001a\u00020\u0004J\u0006\u0010>\u001a\u00020?J\u001e\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GJ\u001e\u0010H\u001a\u00020A2\u0006\u00106\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EJ\u000e\u0010I\u001a\u00020\u001b2\u0006\u0010J\u001a\u00020KJ\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020M\u0018\u000108J\u000e\u0010N\u001a\u00020O2\u0006\u0010\f\u001a\u00020\rJ\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\u0004082\u000e\u0010Q\u001a\n\u0012\u0004\u0012\u00020S\u0018\u00010RJ\u0016\u0010T\u001a\u00020\u001b2\u0006\u0010B\u001a\u00020C2\u0006\u0010U\u001a\u00020\u0013J$\u0010V\u001a\u00020\u00042\b\u0010W\u001a\u0004\u0018\u00010\u00042\b\u0010X\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010Y\u001a\u00020\u0013J\u0017\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010\\\u001a\u0004\u0018\u00010]¢\u0006\u0002\u0010^J\u001e\u0010_\u001a\u00020\u001b2\u0006\u0010`\u001a\u00020\u001b2\u0006\u0010a\u001a\u00020\u001b2\u0006\u0010b\u001a\u00020\u001bJ\u0006\u0010c\u001a\u00020dJ\u0016\u0010e\u001a\u00020\u001b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010f\u001a\u00020\u0013J \u0010g\u001a\u00020\u00042\u0006\u0010h\u001a\u00020\u00042\u0006\u0010i\u001a\u00020\u001b2\b\b\u0002\u0010j\u001a\u00020\u0013J\u0018\u0010k\u001a\u0004\u0018\u00010M2\u0006\u0010B\u001a\u00020C2\u0006\u0010\"\u001a\u00020#J\u0016\u0010l\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u001b2\u0006\u0010n\u001a\u00020\u0013J\u000e\u0010o\u001a\u00020\u00042\u0006\u0010p\u001a\u00020\u001bJ\u000e\u0010q\u001a\u00020\u00132\u0006\u0010r\u001a\u00020[J\u000e\u0010s\u001a\u00020\u00132\u0006\u0010t\u001a\u00020[J \u0010u\u001a\u00020\t2\u0006\u0010v\u001a\u00020w2\b\u0010x\u001a\u0004\u0018\u00010y2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010z\u001a\u00020\t2\u0006\u0010J\u001a\u00020KJ\u0006\u0010{\u001a\u00020\u0013J$\u0010|\u001a\u00020\u00132\b\u0010}\u001a\u0004\u0018\u00010\u00042\b\u0010~\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001a\u00020\u0013J\u000f\u0010\u0001\u001a\u00020\u00132\u0006\u0010W\u001a\u00020\u0004J\u000f\u0010\u0001\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rJ\u0007\u0010\u0001\u001a\u00020\u0013J\u001d\u0010\u0001\u001a\u00020\u00132\b\u0010W\u001a\u0004\u0018\u00010\u00042\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0011\u0010\u0001\u001a\u00020\u00132\b\u0010W\u001a\u0004\u0018\u00010\u0004J\u0011\u0010\u0001\u001a\u00020\u00132\u0006\u0010D\u001a\u00020EH\u0002J!\u0010\u0001\u001a\u00020\t2\u0006\u0010B\u001a\u00020C2\u0007\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u0004J\u0010\u0010\u0001\u001a\u00020\u00132\u0007\u0010\u0001\u001a\u00020[J\u0016\u0010\u0001\u001a\u0004\u0018\u00010&2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0004H\u0002J.\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020&082\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0R2\u0011\b\u0002\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020&\u0018\u000108J0\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u0001082\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020S0R2\u0012\b\u0002\u0010\u0001\u001a\u000b\u0012\u0005\u0012\u00030\u0001\u0018\u000108J\u0018\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\u00042\u0006\u0010h\u001a\u00020\u0004J1\u0010\u0001\u001a\u00020\u00042\u0007\u0010\u0001\u001a\u00020\u00042\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020&082\u0007\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020[J\u000f\u0010\u0001\u001a\u00020\u00132\u0006\u0010t\u001a\u00020[J\u0018\u0010\u0001\u001a\u00020\t2\u000f\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020&\u0018\u000108J*\u0010\u0001\u001a\u00020\t2\u000f\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020&\u0018\u0001082\u0007\u0010\u0001\u001a\u00020\u001b2\u0007\u0010\u0001\u001a\u00020[JJ\u0010\u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030 \u00012\b\u0010¡\u0001\u001a\u00030¢\u00012-\b\u0002\u0010£\u0001\u001a&\u0012\u0019\u0012\u0017\u0018\u00010¢\u0001¢\u0006\u000f\b¥\u0001\u0012\n\b¦\u0001\u0012\u0005\b\b(§\u0001\u0012\u0004\u0012\u00020\t\u0018\u00010¤\u0001J%\u0010¨\u0001\u001a\u00020\t2\b\u0010©\u0001\u001a\u00030ª\u00012\u0007\u0010«\u0001\u001a\u00020\u00042\t\b\u0002\u0010¬\u0001\u001a\u00020\u001bJC\u0010­\u0001\u001a\u00020\t2\n\u0010®\u0001\u001a\u0005\u0018\u00010¯\u00012\n\u0010°\u0001\u001a\u0005\u0018\u00010±\u00012\u0007\u0010²\u0001\u001a\u00020\u001b2\u0007\u0010³\u0001\u001a\u00020\u001b2\u0010\u0010´\u0001\u001a\u000b\u0012\u0004\u0012\u00020\t\u0018\u00010µ\u0001J#\u0010¶\u0001\u001a\u00020\t2\b\u0010·\u0001\u001a\u00030ª\u00012\u0007\u0010¸\u0001\u001a\u00020\u00042\u0007\u0010¹\u0001\u001a\u00020\u001bJ\u0011\u0010º\u0001\u001a\u00020\t2\b\u0010»\u0001\u001a\u00030±\u0001J\u0017\u0010¼\u0001\u001a\u00020\t2\u0006\u0010B\u001a\u00020C2\u0006\u0010h\u001a\u00020\u0004J\u0011\u0010½\u0001\u001a\u00020\t2\b\u0010\u0001\u001a\u00030 \u0001R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006¾\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderLiveUtil;", "", "()V", "FINDER_LIVE_MMKV", "", "TAG", "getTAG", "()Ljava/lang/String;", "addSelfAppMsg", "", "appMsg", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAppMsg;", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "adjustMarginTopInSecondaryLiveRoom", "plugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "adjustMarginWhenLandScape", "ifLeft", "", "audienceMicLinked", "micUser", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveLinkMicUser;", "audienceMicWaitingAudio", "audienceMicWaitingVideo", "canShowShopEntrance", "livePrivilegesFlag", "", "shopAppId", "shopAppUrl", "canShowShopEntranceWhenJoinLive", "canShowVisitorRoleEntrance", "checkCanShowShopEntrance", "checkIfAtMe", "commentData", "Lcom/tencent/mm/plugin/finder/live/model/IFinderLiveMsg;", "checkIfTickleMe", "visitorRole", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAliasInfo;", "checkInsertLiveNewReddot", "convertToLiveConfig", "Lcom/tencent/mm/live/api/LiveConfig;", "obj", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "toWhere", "convertToSimilarLive", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveConfig;", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "clickFeed", "commentScene", "convertToVisitorLiveData", "tabType", "getAliasInfoList", "Ljava/util/LinkedList;", "getAtName", "getBadgeLevelImageSpan", "Lcom/tencent/mm/plugin/finder/live/model/FinderLiveItalicImageSpan;", "badgeLevel", "badgeTag", "getConfig", "Lcom/tencent/rtmp/TXLivePlayConfig;", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "context", "Landroid/content/Context;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getCurrentOrientation", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "getDebugFinderLiveContact", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "getFinderCotactForSelfComment", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getFinderLiveAndienceFileIdList", "list", "", "", "getLanscapePadding", "isScondaryDevice", "getLiveDisplayName", ch.COL_USERNAME, "nickname", "printLog", "getLiveTotalHeat", "", "liveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveInfo;)Ljava/lang/Long;", "getLotteryRemainTime", "beginTime", "endTime", "remainTime", "getMMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "getRenderMode", "isLandscape", "getSubMsgString", "msg", "maxCharCount", "withEllapse", "getTickleContact", "getVisibilityString", "visibilityMode", "showDetail", "getVisitorModeString", "visitorMode", "giftFuncEnableByContactFlag", "contactFlag", "giftFuncEnableBySwitchFlag", "switchFlag", "handleJoinLiveLikeConfettiResponse", "response", "Lcom/tencent/mm/protocal/protobuf/FinderJoinLiveResp;", "confettiPlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveLikeConfettiPlugin;", "hideSoftInput", "isAnchorLive", "isEqual", "strA", "strB", "enableEmpty", "isFriend", "isInSecondaryDevice", "isLibPagEnabled", "isMyCurrentVisitorRole", "isMyself", "isSelf", "jumpAdPage", "pageId", "uxInfo", "linkMicFuncEnableBySwitchFlag", "value", "parseAliasInfoContent", "msgContent", "parseAliasInfoList", "container", "parseFinderLiveAudienceList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveAudienceListFile;", "printDebugMsg", "tag", "printVisitorRoleInfo", "prefix", "visitorRoleList", "curVisitorRoleType", "visitorRoleModifyTime", "rewardGainEnableBySwitchFlag", "saveAliasInfoList", "aliasInfoList", "saveVisitorRoleInfo", "visitorRoleType", "modifyTime", "setBigPitcureBlurBitmap", "view", "Landroid/view/View;", "bitmap", "Landroid/graphics/Bitmap;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "blurBitmap", "setBlurBitmap", "imageView", "Landroid/widget/ImageView;", "url", "radius", "setETInputConfig", "descTv", "Landroid/widget/EditText;", "textCountTv", "Landroid/widget/TextView;", "maxInputLength", "maxInputSize", "configCallback", "Lkotlin/Function0;", "setLiveAvatar", "avatarIv", "avatarUrl", "roleType", "setLiveGiftTypeFace", "tv", "showDebugToast", "vibrate", "plugin-finder_release"})
public final class m {
    private static final String TAG = TAG;
    private static final String vVG = vVG;
    public static final m vVH = new m();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class b implements o.f {
        final /* synthetic */ Context $context;
        final /* synthetic */ BaseFinderFeed tEM;
        final /* synthetic */ com.tencent.mm.ui.widget.a.e tPJ;

        b(BaseFinderFeed baseFinderFeed, Context context, com.tencent.mm.ui.widget.a.e eVar) {
            this.tEM = baseFinderFeed;
            this.$context = context;
            this.tPJ = eVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lkotlin/Triple;", "", "invoke"})
        static final class a extends q implements kotlin.g.a.b<r<? extends String, ? extends String, ? extends String>, x> {
            final /* synthetic */ com.tencent.mm.ui.base.m tPL;
            final /* synthetic */ b vVK;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, com.tencent.mm.ui.base.m mVar) {
                super(1);
                this.vVK = bVar;
                this.tPL = mVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(r<? extends String, ? extends String, ? extends String> rVar) {
                AppMethodBeat.i(253403);
                r<? extends String, ? extends String, ? extends String> rVar2 = rVar;
                p.h(rVar2, LocaleUtil.ITALIAN);
                com.tencent.mm.ui.base.m mVar = this.tPL;
                p.g(mVar, "menu");
                mVar.avn().clear();
                if (!(this.vVK.tEM.feedObject.isOnlySelfSee() || this.vVK.tEM.feedObject.isNotShare())) {
                    com.tencent.mm.ui.base.m mVar2 = this.tPL;
                    at.b bVar = at.tSs;
                    mVar2.a(at.cXr(), (CharSequence) this.vVK.$context.getString(R.string.d9p), R.raw.bottomsheet_icon_moment, 0, false);
                } else {
                    com.tencent.mm.ui.base.m mVar3 = this.tPL;
                    at.b bVar2 = at.tSs;
                    mVar3.a(at.cXr(), (CharSequence) rVar2.second, R.raw.bottomsheet_icon_moment, 0, true);
                }
                this.vVK.tPJ.fPw();
                x xVar = x.SXb;
                AppMethodBeat.o(253403);
                return xVar;
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:7:0x010c  */
        @Override // com.tencent.mm.ui.base.o.f
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m r11) {
            /*
            // Method dump skipped, instructions count: 370
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.utils.m.b.onCreateMMMenu(com.tencent.mm.ui.base.m):void");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "round1Result", "Landroid/graphics/Bitmap;", "invoke"})
    static final class d extends q implements kotlin.g.a.b<Bitmap, x> {
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ View hCI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(View view, kotlin.g.a.b bVar) {
            super(1);
            this.hCI = view;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Bitmap bitmap) {
            AppMethodBeat.i(253407);
            a.C0373a aVar = com.tencent.mm.live.b.d.a.hLg;
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            a.C0373a.a(bitmap, context.getResources().getColor(R.color.ac), new kotlin.g.a.b<Bitmap, x>(this) {
                /* class com.tencent.mm.plugin.finder.utils.m.d.AnonymousClass1 */
                final /* synthetic */ d vVL;

                {
                    this.vVL = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Bitmap bitmap) {
                    AppMethodBeat.i(253406);
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 != null) {
                        if (this.vVL.hCI instanceof ImageView) {
                            Context context = MMApplicationContext.getContext();
                            p.g(context, "MMApplicationContext.getContext()");
                            ((ImageView) this.vVL.hCI).setImageDrawable(new BitmapDrawable(context.getResources(), bitmap2));
                        } else {
                            View view = this.vVL.hCI;
                            Context context2 = MMApplicationContext.getContext();
                            p.g(context2, "MMApplicationContext.getContext()");
                            view.setBackground(new BitmapDrawable(context2.getResources(), bitmap2));
                        }
                        kotlin.g.a.b bVar = this.vVL.gWe;
                        if (bVar != null) {
                            bVar.invoke(bitmap2);
                        }
                    } else {
                        kotlin.g.a.b bVar2 = this.vVL.gWe;
                        if (bVar2 != null) {
                            bVar2.invoke(null);
                        }
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(253406);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(253407);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    static final class h<T, R> implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.o, Bitmap> {
        final /* synthetic */ ImageView ULQ;

        h(ImageView imageView) {
            this.ULQ = imageView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<com.tencent.mm.plugin.finder.loader.o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(261440);
            final Bitmap bitmap2 = bitmap;
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.utils.m.h.AnonymousClass1 */
                final /* synthetic */ h UVc;

                {
                    this.UVc = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(261439);
                    if (bitmap2 != null) {
                        this.UVc.ULQ.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(bitmap2, false, ((float) bitmap2.getWidth()) / 2.0f));
                    } else {
                        this.UVc.ULQ.setVisibility(8);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(261439);
                    return xVar;
                }
            });
            AppMethodBeat.o(261440);
        }
    }

    static {
        AppMethodBeat.i(253452);
        AppMethodBeat.o(253452);
    }

    private m() {
    }

    public static String getTAG() {
        return TAG;
    }

    public static void checkInsertLiveNewReddot() {
        boolean z = false;
        AppMethodBeat.i(253411);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        if (aAh.azQ().getInt(ar.a.USERINFO_MY_FINDER_LIVE_NEW_REDDOT_FLAG_INT_SYNC, 0) == 1) {
            z = true;
        }
        if (z) {
            AppMethodBeat.o(253411);
            return;
        }
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!com.tencent.mm.plugin.finder.storage.c.duS()) {
            AppMethodBeat.o(253411);
            return;
        }
        com.tencent.mm.plugin.finder.extension.reddot.f redDotManager = ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getRedDotManager();
        bbi bbi = new bbi();
        bbi.LKM = String.valueOf(cl.aWA());
        bbi.priority = SQLiteDatabase.SQLITE_MAX_LIKE_PATTERN_LENGTH;
        bbi.type = 1010;
        bdo bdo = new bdo();
        bdo.xGz = 1;
        bdo.LNm = 1;
        bdo.path = "FinderEntrance";
        bbi.GaM.add(bdo);
        bdo bdo2 = new bdo();
        bdo2.xGz = 1;
        bdo2.LNm = 1;
        bdo2.path = "TLPersonalCenter";
        bbi.GaM.add(bdo2);
        bdo bdo3 = new bdo();
        bdo3.xGz = 1;
        bdo3.LNm = 1;
        bdo3.path = "FinderSelfLiveEntrance";
        bbi.GaM.add(bdo3);
        com.tencent.mm.plugin.finder.extension.reddot.f.a(redDotManager, bbi, "checkInsertLiveNewReddot", null, true, null, 20);
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_MY_FINDER_LIVE_NEW_REDDOT_FLAG_INT_SYNC, (Object) 1);
        AppMethodBeat.o(253411);
    }

    public static o.f a(Context context, BaseFinderFeed baseFinderFeed, com.tencent.mm.ui.widget.a.e eVar) {
        AppMethodBeat.i(253412);
        p.h(context, "context");
        p.h(baseFinderFeed, "feed");
        p.h(eVar, "sheet");
        b bVar = new b(baseFinderFeed, context, eVar);
        AppMethodBeat.o(253412);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class c implements o.f {
        final /* synthetic */ Context $context;
        final /* synthetic */ BaseFinderFeed tEM;
        final /* synthetic */ int tTj;

        c(BaseFinderFeed baseFinderFeed, int i2, Context context) {
            this.tEM = baseFinderFeed;
            this.tTj = i2;
            this.$context = context;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(253405);
            m mVar2 = m.vVH;
            if (!m.t(this.tEM)) {
                if (!(this.tTj == 3 || this.tTj == 1)) {
                    at.b bVar = at.tSs;
                    mVar.b(at.ddd(), this.$context.getString(R.string.f3j), R.raw.finder_feed_dislike);
                }
                at.b bVar2 = at.tSs;
                mVar.b(at.ddf(), this.$context.getString(R.string.f3g), R.raw.icons_outlined_report_problem);
            }
            AppMethodBeat.o(253405);
        }
    }

    public static o.f a(int i2, Context context, BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(253413);
        p.h(context, "context");
        p.h(baseFinderFeed, "feed");
        c cVar = new c(baseFinderFeed, i2, context);
        AppMethodBeat.o(253413);
        return cVar;
    }

    public static /* synthetic */ void h(ImageView imageView, String str) {
        AppMethodBeat.i(253415);
        g(imageView, str);
        AppMethodBeat.o(253415);
    }

    public static void g(ImageView imageView, String str) {
        AppMethodBeat.i(253414);
        p.h(imageView, "imageView");
        p.h(str, "url");
        Log.i(TAG, "setBlurBitmap imageView:" + imageView.getId() + ",url:" + str);
        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
        com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dke = com.tencent.mm.plugin.finder.loader.m.dke();
        com.tencent.mm.plugin.finder.loader.e eVar = new com.tencent.mm.plugin.finder.loader.e(str, com.tencent.mm.plugin.finder.storage.x.THUMB_IMAGE);
        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
        dke.a(eVar, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
        AppMethodBeat.o(253414);
    }

    public static void a(View view, Bitmap bitmap, kotlin.g.a.b<? super Bitmap, x> bVar) {
        AppMethodBeat.i(253416);
        p.h(view, "view");
        p.h(bitmap, "bitmap");
        a.C0373a aVar = com.tencent.mm.live.b.d.a.hLg;
        Context context = MMApplicationContext.getContext();
        p.g(context, "MMApplicationContext.getContext()");
        a.C0373a.a(bitmap, context.getResources().getColor(R.color.ac), new d(view, bVar));
        AppMethodBeat.o(253416);
    }

    public static /* synthetic */ LiveConfig q(FinderObject finderObject) {
        AppMethodBeat.i(253417);
        int i2 = LiveConfig.hvU;
        p.h(finderObject, "obj");
        LiveConfig.a qo = new LiveConfig.a().qo(i2);
        awe awe = finderObject.liveInfo;
        LiveConfig.a Gg = qo.zt(awe != null ? awe.liveId : 0).Gd(finderObject.objectNonceId).zu(finderObject.id).Gg(finderObject.username);
        FinderObjectDesc finderObjectDesc = finderObject.objectDesc;
        LiveConfig aBR = Gg.Gh(finderObjectDesc != null ? finderObjectDesc.description : null).Gl(finderObject.sessionBuffer).aBR();
        p.g(aBR, "builder.toWhere(toWhere)…fer)\n            .build()");
        AppMethodBeat.o(253417);
        return aBR;
    }

    public static FinderLiveConfig a(ArrayList<bo> arrayList, bo boVar, int i2) {
        int i3;
        FinderItem finderItem;
        FinderObject feedObject;
        awe awe;
        awe liveInfo;
        boolean z;
        String str;
        awe liveInfo2;
        AppMethodBeat.i(253418);
        p.h(arrayList, "data");
        p.h(boVar, "clickFeed");
        ArrayList arrayList2 = new ArrayList();
        for (T t : arrayList) {
            boolean z2 = t instanceof BaseFinderFeed;
            y yVar = y.vXH;
            if (t == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                AppMethodBeat.o(253418);
                throw tVar;
            } else if (y.w((BaseFinderFeed) t) && z2) {
                FinderItem finderItem2 = t.feedObject;
                if (finderItem2 == null || (liveInfo = finderItem2.getLiveInfo()) == null || liveInfo.liveStatus != 2) {
                    arrayList2.add(t);
                } else {
                    String str2 = TAG;
                    StringBuilder append = new StringBuilder("convertToVisitorLiveData feed:").append(t.lT()).append(",is click feed:");
                    long lT = t.lT();
                    if (boVar == null || lT != boVar.lT()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    StringBuilder append2 = append.append(z).append(",nickname:");
                    com.tencent.mm.plugin.finder.api.g gVar = t.contact;
                    if (gVar != null) {
                        str = gVar.getNickname();
                    } else {
                        str = null;
                    }
                    StringBuilder append3 = append2.append(str).append(",live status:");
                    FinderItem finderItem3 = t.feedObject;
                    Log.i(str2, append3.append((finderItem3 == null || (liveInfo2 = finderItem3.getLiveInfo()) == null) ? null : Integer.valueOf(liveInfo2.liveStatus)).append('!').toString());
                    if (t.lT() == boVar.lT()) {
                        arrayList2.add(t);
                    }
                }
            }
        }
        int a2 = j.a((List) arrayList2, (Object) boVar);
        int i4 = a2 >= 0 ? a2 : 0;
        FinderLiveConfig finderLiveConfig = new FinderLiveConfig();
        finderLiveConfig.uis = i4;
        finderLiveConfig.tCE = i2;
        ArrayList<BaseFinderFeed> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(j.a(arrayList3, 10));
        for (BaseFinderFeed baseFinderFeed : arrayList3) {
            arrayList4.add(q(baseFinderFeed.feedObject.getFeedObject()));
        }
        finderLiveConfig.ac(new ArrayList<>(arrayList4));
        finderLiveConfig.uiy = 1;
        BaseFinderFeed baseFinderFeed2 = (BaseFinderFeed) j.L(arrayList2, i4);
        if (baseFinderFeed2 == null || (finderItem = baseFinderFeed2.feedObject) == null || (feedObject = finderItem.getFeedObject()) == null || (awe = feedObject.liveInfo) == null) {
            i3 = 0;
        } else {
            i3 = awe.LGU;
        }
        finderLiveConfig.extFlag = i3;
        AppMethodBeat.o(253418);
        return finderLiveConfig;
    }

    public static FinderLiveConfig a(ArrayList<bo> arrayList, bo boVar, int i2, int i3) {
        int i4;
        FinderItem finderItem;
        FinderObject feedObject;
        awe awe;
        awe liveInfo;
        boolean z;
        String str;
        awe liveInfo2;
        AppMethodBeat.i(253419);
        p.h(arrayList, "data");
        p.h(boVar, "clickFeed");
        ArrayList arrayList2 = new ArrayList();
        for (T t : arrayList) {
            boolean z2 = t instanceof BaseFinderFeed;
            y yVar = y.vXH;
            if (t == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                AppMethodBeat.o(253419);
                throw tVar;
            } else if (y.w((BaseFinderFeed) t) && z2) {
                FinderItem finderItem2 = t.feedObject;
                if (finderItem2 == null || (liveInfo = finderItem2.getLiveInfo()) == null || liveInfo.liveStatus != 2) {
                    arrayList2.add(t);
                } else {
                    String str2 = TAG;
                    StringBuilder append = new StringBuilder("convertToVisitorLiveData feed:").append(t.lT()).append(",is click feed:");
                    long lT = t.lT();
                    if (boVar == null || lT != boVar.lT()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    StringBuilder append2 = append.append(z).append(",nickname:");
                    com.tencent.mm.plugin.finder.api.g gVar = t.contact;
                    if (gVar != null) {
                        str = gVar.getNickname();
                    } else {
                        str = null;
                    }
                    StringBuilder append3 = append2.append(str).append(",live status:");
                    FinderItem finderItem3 = t.feedObject;
                    Log.i(str2, append3.append((finderItem3 == null || (liveInfo2 = finderItem3.getLiveInfo()) == null) ? null : Integer.valueOf(liveInfo2.liveStatus)).append('!').toString());
                    if (t.lT() == boVar.lT()) {
                        arrayList2.add(t);
                    }
                }
            }
        }
        int a2 = j.a((List) arrayList2, (Object) boVar);
        int i5 = a2 >= 0 ? a2 : 0;
        FinderLiveConfig finderLiveConfig = new FinderLiveConfig();
        finderLiveConfig.uis = i5;
        finderLiveConfig.dLS = i2;
        finderLiveConfig.tCE = i3;
        ArrayList<BaseFinderFeed> arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(j.a(arrayList3, 10));
        for (BaseFinderFeed baseFinderFeed : arrayList3) {
            arrayList4.add(q(baseFinderFeed.feedObject.getFeedObject()));
        }
        finderLiveConfig.ac(new ArrayList<>(arrayList4));
        BaseFinderFeed baseFinderFeed2 = (BaseFinderFeed) j.L(arrayList2, i5);
        if (baseFinderFeed2 == null || (finderItem = baseFinderFeed2.feedObject) == null || (feedObject = finderItem.getFeedObject()) == null || (awe = feedObject.liveInfo) == null) {
            i4 = 0;
        } else {
            i4 = awe.LGU;
        }
        finderLiveConfig.extFlag = i4;
        AppMethodBeat.o(253419);
        return finderLiveConfig;
    }

    public static boolean isFriend(String str) {
        AppMethodBeat.i(253420);
        p.h(str, ch.COL_USERNAME);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
        p.g(af, "MMKernel.service(IMessengerStorage::class.java)");
        as Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) af).aSN().Kn(str);
        p.g(Kn, "contact");
        boolean arv = Kn.arv();
        AppMethodBeat.o(253420);
        return arv;
    }

    public static boolean dBN() {
        AppMethodBeat.i(253421);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_MY_FINDER_LIVE_FLAG_INT_SYNC, (Object) 0);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(253421);
            throw tVar;
        }
        int intValue = ((Integer) obj).intValue();
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        Object obj2 = aAh2.azQ().get(ar.a.USERINFO_MY_FINDER_SHOP_APPID_STRING_SYNC, "");
        if (obj2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(253421);
            throw tVar2;
        }
        String str = (String) obj2;
        com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh3, "MMKernel.storage()");
        Object obj3 = aAh3.azQ().get(ar.a.USERINFO_MY_FINDER_SHOP_PATH_STRING_SYNC, "");
        if (obj3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(253421);
            throw tVar3;
        }
        boolean z = z(intValue, str, (String) obj3);
        AppMethodBeat.o(253421);
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0079, code lost:
        if (r0 == false) goto L_0x0080;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean z(int r5, java.lang.String r6, java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 133
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.utils.m.z(int, java.lang.String, java.lang.String):boolean");
    }

    public static boolean hl(String str, String str2) {
        AppMethodBeat.i(261443);
        Log.i(TAG, "canShowShopEntrance appId:" + str + ", appUrl:" + str2);
        if (!Util.isNullOrNil(str)) {
            AppMethodBeat.o(261443);
            return true;
        }
        AppMethodBeat.o(261443);
        return false;
    }

    public static boolean hVq() {
        AppMethodBeat.i(261444);
        y yVar = y.vXH;
        boolean dCM = y.dCM();
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int intValue = com.tencent.mm.plugin.finder.storage.c.hUX().value().intValue();
        Log.i(TAG, "canShowVisitorRoleEntrance isTest:" + dCM + ",configValue:" + intValue);
        switch (intValue) {
            case 0:
                AppMethodBeat.o(261444);
                return true;
            case 1:
                AppMethodBeat.o(261444);
                return dCM;
            default:
                AppMethodBeat.o(261444);
                return false;
        }
    }

    public static void hd(String str, String str2) {
        AppMethodBeat.i(253423);
        p.h(str, "tag");
        p.h(str2, "msg");
        y yVar = y.vXH;
        if (y.dCM()) {
            Log.i(str + "(Debug)", str2);
        }
        AppMethodBeat.o(253423);
    }

    public static void dk(Context context, String str) {
        AppMethodBeat.i(261445);
        p.h(context, "context");
        p.h(str, "msg");
        y yVar = y.vXH;
        if (y.dCM()) {
            com.tencent.mm.ac.d.h(new i(context, str));
        }
        AppMethodBeat.o(261445);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class a implements Runnable {
        final /* synthetic */ com.tencent.mm.plugin.finder.live.plugin.d vVI;
        final /* synthetic */ boolean vVJ;

        a(com.tencent.mm.plugin.finder.live.plugin.d dVar, boolean z) {
            this.vVI = dVar;
            this.vVJ = z;
        }

        public final void run() {
            AppMethodBeat.i(253402);
            if (this.vVI.umb.getLayoutParams() != null && (this.vVI.umb.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && this.vVI.isLandscape()) {
                int currentOrientation = this.vVI.getCurrentOrientation();
                m mVar = m.vVH;
                Context context = this.vVI.umb.getContext();
                p.g(context, "plugin.vg.context");
                m mVar2 = m.vVH;
                int B = m.B(context, m.i(this.vVI.getLiveData()));
                if (this.vVJ) {
                    ViewGroup.LayoutParams layoutParams = this.vVI.umb.getLayoutParams();
                    if (layoutParams == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(253402);
                        throw tVar;
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(B);
                } else {
                    ViewGroup.LayoutParams layoutParams2 = this.vVI.umb.getLayoutParams();
                    if (layoutParams2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(253402);
                        throw tVar2;
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginEnd(B);
                }
                this.vVI.umb.requestLayout();
                y yVar = y.vXH;
                if (y.dCM()) {
                    m mVar3 = m.vVH;
                    Log.i(m.getTAG(), "plugin:" + this.vVI.name() + ",Orientation:" + currentOrientation + ",ifLeft:" + this.vVJ);
                }
                this.vVI.umb.setTag(R.id.cwa, Integer.valueOf(currentOrientation));
            }
            AppMethodBeat.o(253402);
        }
    }

    public static int B(Context context, boolean z) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(253427);
        p.h(context, "context");
        if (ao.aQ(context)) {
            i2 = au.getStatusBarHeight(context);
        } else {
            i2 = 0;
        }
        if (z) {
            i3 = au.aD(context);
        }
        if (z) {
            int mZ = kotlin.k.j.mZ(i2, i3) + context.getResources().getDimensionPixelOffset(R.dimen.ct);
            AppMethodBeat.o(253427);
            return mZ;
        } else if (i2 > 0) {
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.ct) + i2;
            AppMethodBeat.o(253427);
            return dimensionPixelOffset;
        } else {
            int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.ce);
            AppMethodBeat.o(253427);
            return dimensionPixelOffset2;
        }
    }

    public static int ag(int i2, int i3, int i4) {
        int i5;
        AppMethodBeat.i(253428);
        int aWB = cl.aWB();
        int i6 = i3 - aWB;
        int i7 = i3 - i2;
        if (i6 > i7 || i6 > i4) {
            i5 = i4;
        } else {
            i5 = i6;
        }
        if (i6 <= 0) {
            i5 = 0;
        }
        Log.i(TAG, "getLotteryRemainTime serverTime:" + aWB + ",beginTime:" + i2 + ",endTime:" + i3 + ",remainTime:" + i4 + ",calRemainTime:" + i6 + ",duration:" + i7 + ",result:" + i5);
        AppMethodBeat.o(253428);
        return i5;
    }

    public static boolean a(com.tencent.mm.plugin.finder.live.model.t tVar) {
        FinderContact finderContact;
        AppMethodBeat.i(253429);
        p.h(tVar, "commentData");
        if ((tVar instanceof com.tencent.mm.plugin.finder.live.model.f) && tVar.getType() == 20002) {
            avn avn = ((com.tencent.mm.plugin.finder.live.model.f) tVar).uio.LFz;
            if (p.j((avn == null || (finderContact = avn.contact) == null) ? null : finderContact.username, z.aTY())) {
                AppMethodBeat.o(253429);
                return true;
            }
        }
        AppMethodBeat.o(253429);
        return false;
    }

    public static String b(com.tencent.mm.plugin.finder.live.model.t tVar) {
        FinderContact finderContact;
        AppMethodBeat.i(253430);
        p.h(tVar, "commentData");
        if (!(tVar instanceof com.tencent.mm.plugin.finder.live.model.f) || tVar.getType() != 20002) {
            AppMethodBeat.o(253430);
            return "";
        }
        avn avn = ((com.tencent.mm.plugin.finder.live.model.f) tVar).uio.LFz;
        if (avn == null || (finderContact = avn.contact) == null) {
            AppMethodBeat.o(253430);
            return null;
        }
        String str = finderContact.nickname;
        AppMethodBeat.o(253430);
        return str;
    }

    public static void a(aut aut, com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        AppMethodBeat.i(253431);
        p.h(aut, "appMsg");
        p.h(gVar, "liveData");
        com.tencent.mm.plugin.finder.live.model.f fVar = new com.tencent.mm.plugin.finder.live.model.f(aut);
        avn avn = new avn();
        avn.contact = m(gVar);
        aut.LFE = avn;
        gVar.uDs.add(fVar);
        com.tencent.mm.live.b.m mVar = com.tencent.mm.live.b.m.hGg;
        com.tencent.mm.live.b.m.aFe();
        AppMethodBeat.o(253431);
    }

    public static avn a(Context context, com.tencent.mm.plugin.finder.live.model.t tVar) {
        AppMethodBeat.i(253432);
        p.h(context, "context");
        p.h(tVar, "commentData");
        if (!(tVar instanceof com.tencent.mm.plugin.finder.live.model.f) || tVar.getType() != 20001) {
            AppMethodBeat.o(253432);
            return null;
        }
        avn avn = ((com.tencent.mm.plugin.finder.live.model.f) tVar).uio.LFz;
        AppMethodBeat.o(253432);
        return avn;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.tencent.mm.plugin.finder.live.model.t r7, com.tencent.mm.protocal.protobuf.aus r8) {
        /*
        // Method dump skipped, instructions count: 117
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.utils.m.a(com.tencent.mm.plugin.finder.live.model.t, com.tencent.mm.protocal.protobuf.aus):boolean");
    }

    public static void eg(View view) {
        AppMethodBeat.i(253434);
        p.h(view, "view");
        view.performHapticFeedback(1, 3);
        AppMethodBeat.o(253434);
    }

    public static TXLivePlayConfig dBO() {
        AppMethodBeat.i(253435);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int dvg = com.tencent.mm.plugin.finder.storage.c.dvg();
        com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
        int dvh = com.tencent.mm.plugin.finder.storage.c.dvh();
        TXLivePlayConfig tXLivePlayConfig = new TXLivePlayConfig();
        tXLivePlayConfig.setConnectRetryCount(dvg);
        tXLivePlayConfig.setConnectRetryInterval(dvh);
        com.tencent.mm.plugin.finder.storage.c cVar3 = com.tencent.mm.plugin.finder.storage.c.vCb;
        boolean hUT = com.tencent.mm.plugin.finder.storage.c.hUT();
        tXLivePlayConfig.setEnableMessage(hUT);
        Log.i(TAG, "cdn config retry count:" + dvg + ",retry interval:" + dvh + ", sei:" + hUT);
        AppMethodBeat.o(253435);
        return tXLivePlayConfig;
    }

    public static int a(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, boolean z) {
        boolean z2;
        boolean z3;
        int i2 = 5;
        AppMethodBeat.i(253436);
        p.h(gVar, "liveData");
        int djc = gVar.djc();
        e.a aVar = e.a.hxc;
        if (djc != e.a.aCe()) {
            e.a aVar2 = e.a.hxc;
            if (djc == e.a.aCf()) {
                List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = gVar.UPZ;
                p.g(list, "audienceLinkMicUserList");
                if (!list.isEmpty()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2 || gVar.uEB != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    Log.i(TAG, "isLinkingMicOrPk,  RENDER_MODE_FULL_FILL_SCREEN");
                    i2 = 0;
                } else if (gVar.djn()) {
                    Log.i(TAG, "fitLandscapeVideo RENDER_MODE_ADJUST_RESOLUTION");
                    i2 = 1;
                } else if (z) {
                    Log.i(TAG, "isLandscape RENDER_MODE_ADJUST_RESOLUTION");
                    i2 = 1;
                } else {
                    Log.i(TAG, "RENDER_MODE_FULL_FILL_SCREEN");
                    i2 = 0;
                }
            } else {
                Log.i(TAG, "unknown audienceMode:" + gVar.djc());
                i2 = 0;
            }
        } else if (!gVar.djn() && !z) {
            i2 = 2;
        }
        Log.i(TAG, "getRenderMode audienceMode:" + gVar.djc() + ", renderMode:" + i2);
        AppMethodBeat.o(253436);
        return i2;
    }

    public static boolean dBP() {
        AppMethodBeat.i(253437);
        b.a aVar = com.tencent.mm.live.core.core.a.b.hyv;
        if (!b.a.aDp()) {
            a.C0381a aVar2 = com.tencent.mm.live.core.core.c.a.hAj;
            if (!a.C0381a.aDp()) {
                AppMethodBeat.o(253437);
                return false;
            }
        }
        AppMethodBeat.o(253437);
        return true;
    }

    public static void p(TextView textView) {
        AppMethodBeat.i(253438);
        p.h(textView, "tv");
        try {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            textView.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/SF-Pro-Display-BoldItalic.otf"));
            AppMethodBeat.o(253438);
        } catch (Exception e2) {
            Log.e(TAG, "setTypeface() Exception:" + e2.getMessage());
            AppMethodBeat.o(253438);
        }
    }

    public static boolean dBQ() {
        AppMethodBeat.i(253439);
        com.tencent.mm.plugin.expansions.d dVar = com.tencent.mm.plugin.expansions.d.rNG;
        boolean aoc = com.tencent.mm.plugin.expansions.d.aoc("xlab");
        AppMethodBeat.o(253439);
        return aoc;
    }

    public static boolean Gc(long j2) {
        AppMethodBeat.i(253440);
        boolean cW = com.tencent.mm.ac.d.cW((int) j2, 4);
        AppMethodBeat.o(253440);
        return cW;
    }

    public static boolean Gd(long j2) {
        AppMethodBeat.i(253441);
        boolean cW = com.tencent.mm.ac.d.cW((int) j2, 2);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        p.g(af, "MMKernel.service(ITeenModeService::class.java)");
        boolean Vt = ((com.tencent.mm.plugin.teenmode.a.b) af).Vt();
        boolean dBQ = dBQ();
        Log.i(TAG, "giftFuncEnableBySwitchFlag isTeenMode:" + Vt + " pagEnable:" + dBQ + " enableGiftBySwitchFlag:" + cW + " switchFlag:" + j2);
        if (!cW || !dBQ || Vt) {
            AppMethodBeat.o(253441);
            return false;
        }
        AppMethodBeat.o(253441);
        return true;
    }

    public static boolean Ge(long j2) {
        AppMethodBeat.i(253442);
        boolean cW = com.tencent.mm.ac.d.cW((int) j2, 1);
        AppMethodBeat.o(253442);
        return cW;
    }

    public static boolean RM(long j2) {
        AppMethodBeat.i(261447);
        boolean cW = com.tencent.mm.ac.d.cW((int) j2, 1);
        com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class);
        p.g(af, "MMKernel.service(ITeenModeService::class.java)");
        boolean Vt = ((com.tencent.mm.plugin.teenmode.a.b) af).Vt();
        y yVar = y.vXH;
        boolean dCT = y.dCT();
        boolean dBQ = dBQ();
        Log.i(TAG, "giftFuncEnableByContactFlag isTeenMode:" + Vt + " pagEnable:" + dBQ + " enableGiftByContactFlag:" + cW + " regChina:" + dCT + " switchFlag:" + j2);
        if (!cW || Vt || !dCT || !dBQ) {
            AppMethodBeat.o(261447);
            return false;
        }
        AppMethodBeat.o(261447);
        return true;
    }

    public static /* synthetic */ String dM(String str, int i2) {
        AppMethodBeat.i(253444);
        String p = p(str, i2, true);
        AppMethodBeat.o(253444);
        return p;
    }

    public static String p(String str, int i2, boolean z) {
        AppMethodBeat.i(253443);
        p.h(str, "msg");
        String hm = com.tencent.mm.ui.tools.f.hm(str, i2);
        if (!z || str.length() <= hm.length()) {
            p.g(hm, "subString");
            AppMethodBeat.o(253443);
            return hm;
        }
        String str2 = hm + "...";
        AppMethodBeat.o(253443);
        return str2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\b0\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\n¢\u0006\u0002\b\u000b"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
    static final class e implements InputFilter {
        final /* synthetic */ EditText vVM;

        e(EditText editText) {
            this.vVM = editText;
        }

        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            AppMethodBeat.i(253408);
            EditText editText = this.vVM;
            if (editText != null) {
                editText.getText();
            }
            String obj = charSequence.toString();
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(253408);
                throw tVar;
            } else if (obj.contentEquals(r0)) {
                AppMethodBeat.o(253408);
                return r0;
            } else {
                AppMethodBeat.o(253408);
                return null;
            }
        }
    }

    public static void a(EditText editText, TextView textView, int i2, int i3, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(253445);
        InputFilter[] inputFilterArr = {new e(editText), new f(i2, i2, f.a.MODE_CHINESE_AS_2)};
        if (editText != null) {
            editText.setFilters(inputFilterArr);
        }
        g gVar = new g(textView, i3, aVar);
        if (editText != null) {
            editText.addTextChangedListener(gVar);
            AppMethodBeat.o(253445);
            return;
        }
        AppMethodBeat.o(253445);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/utils/FinderLiveUtil$setETInputConfig$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-finder_release"})
    public static final class f extends com.tencent.mm.ui.tools.f {
        final /* synthetic */ int vVN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(int i2, int i3, f.a aVar) {
            super(i3, aVar);
            this.vVN = i2;
        }

        @Override // com.tencent.mm.ui.tools.f
        public final CharSequence filter(CharSequence charSequence, int i2, int i3, Spanned spanned, int i4, int i5) {
            int a2;
            int i6;
            CharSequence charSequence2;
            AppMethodBeat.i(253409);
            if ((spanned != null ? spanned.length() : 0) > i4) {
                a2 = com.tencent.mm.ui.tools.f.a(String.valueOf(spanned != null ? spanned.subSequence(0, i4) : null), f.a.MODE_CHINESE_AS_2);
            } else {
                a2 = com.tencent.mm.ui.tools.f.a(String.valueOf(spanned), f.a.MODE_CHINESE_AS_2);
            }
            if (spanned == null || spanned.length() <= i5) {
                i6 = 0;
            } else {
                i6 = com.tencent.mm.ui.tools.f.a(spanned.subSequence(i5, spanned.length()).toString(), f.a.MODE_CHINESE_AS_2);
            }
            int a3 = com.tencent.mm.ui.tools.f.a(String.valueOf(charSequence), f.a.MODE_CHINESE_AS_2);
            int i7 = (this.vVN - a2) - i6;
            if (a3 > i7) {
                m mVar = m.vVH;
                String p = m.p(String.valueOf(charSequence), i7, false);
                AppMethodBeat.o(253409);
                return p;
            }
            if (charSequence != null) {
                charSequence2 = charSequence;
            }
            AppMethodBeat.o(253409);
            return charSequence2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/finder/utils/FinderLiveUtil$setETInputConfig$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
    public static final class g implements TextWatcher {
        final /* synthetic */ TextView vVO;
        final /* synthetic */ int vVP;
        final /* synthetic */ kotlin.g.a.a vVQ;

        g(TextView textView, int i2, kotlin.g.a.a aVar) {
            this.vVO = textView;
            this.vVP = i2;
            this.vVQ = aVar;
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(253410);
            int bnP = com.tencent.mm.ui.tools.f.bnP(String.valueOf(editable)) / 2;
            TextView textView = this.vVO;
            if (textView != null) {
                textView.setText(bnP >= 0 ? new StringBuilder().append(bnP).append('/').append(this.vVP).toString() : "0/" + this.vVP);
            }
            kotlin.g.a.a aVar = this.vVQ;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(253410);
                return;
            }
            AppMethodBeat.o(253410);
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public static com.tencent.mm.plugin.finder.live.model.g bd(int i2, String str) {
        AppMethodBeat.i(253446);
        p.h(str, "badgeTag");
        switch (i2) {
            case 1:
                g.a aVar = com.tencent.mm.plugin.finder.live.model.g.uiK;
                Drawable atD = g.a.atD(str);
                n.a aVar2 = n.ujr;
                float dfS = n.dfS();
                n.a aVar3 = n.ujr;
                float dfS2 = n.dfS();
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                int color = context.getResources().getColor(R.color.pr);
                n.a aVar4 = n.ujr;
                int dfQ = n.dfQ();
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                int color2 = context2.getResources().getColor(R.color.ag2);
                n.a aVar5 = n.ujr;
                com.tencent.mm.plugin.finder.live.model.g gVar = new com.tencent.mm.plugin.finder.live.model.g(atD, new n(str, dfS, dfS2, color, dfQ, color2, n.dfR()));
                AppMethodBeat.o(253446);
                return gVar;
            case 2:
                g.a aVar6 = com.tencent.mm.plugin.finder.live.model.g.uiK;
                Drawable atD2 = g.a.atD(str);
                n.a aVar7 = n.ujr;
                float dfS3 = n.dfS();
                n.a aVar8 = n.ujr;
                float dfS4 = n.dfS();
                Context context3 = MMApplicationContext.getContext();
                p.g(context3, "MMApplicationContext.getContext()");
                int color3 = context3.getResources().getColor(R.color.pt);
                n.a aVar9 = n.ujr;
                int dfQ2 = n.dfQ();
                Context context4 = MMApplicationContext.getContext();
                p.g(context4, "MMApplicationContext.getContext()");
                int color4 = context4.getResources().getColor(R.color.ag2);
                n.a aVar10 = n.ujr;
                com.tencent.mm.plugin.finder.live.model.g gVar2 = new com.tencent.mm.plugin.finder.live.model.g(atD2, new n(str, dfS3, dfS4, color3, dfQ2, color4, n.dfR()));
                AppMethodBeat.o(253446);
                return gVar2;
            case 3:
                g.a aVar11 = com.tencent.mm.plugin.finder.live.model.g.uiK;
                Drawable atD3 = g.a.atD(str);
                n.a aVar12 = n.ujr;
                float dfS5 = n.dfS();
                n.a aVar13 = n.ujr;
                float dfS6 = n.dfS();
                Context context5 = MMApplicationContext.getContext();
                p.g(context5, "MMApplicationContext.getContext()");
                int color5 = context5.getResources().getColor(R.color.ps);
                n.a aVar14 = n.ujr;
                int dfQ3 = n.dfQ();
                Context context6 = MMApplicationContext.getContext();
                p.g(context6, "MMApplicationContext.getContext()");
                int color6 = context6.getResources().getColor(R.color.ag2);
                n.a aVar15 = n.ujr;
                com.tencent.mm.plugin.finder.live.model.g gVar3 = new com.tencent.mm.plugin.finder.live.model.g(atD3, new n(str, dfS5, dfS6, color5, dfQ3, color6, n.dfR()));
                AppMethodBeat.o(253446);
                return gVar3;
            default:
                g.a aVar16 = com.tencent.mm.plugin.finder.live.model.g.uiK;
                Drawable atD4 = g.a.atD(str);
                n.a aVar17 = n.ujr;
                float dfS7 = n.dfS();
                n.a aVar18 = n.ujr;
                float dfS8 = n.dfS();
                Context context7 = MMApplicationContext.getContext();
                p.g(context7, "MMApplicationContext.getContext()");
                int color7 = context7.getResources().getColor(R.color.BW_100_Alpha_0_3);
                n.a aVar19 = n.ujr;
                int dfQ4 = n.dfQ();
                Context context8 = MMApplicationContext.getContext();
                p.g(context8, "MMApplicationContext.getContext()");
                int color8 = context8.getResources().getColor(R.color.ag2);
                n.a aVar20 = n.ujr;
                com.tencent.mm.plugin.finder.live.model.g gVar4 = new com.tencent.mm.plugin.finder.live.model.g(atD4, new n(str, dfS7, dfS8, color7, dfQ4, color8, n.dfR()));
                AppMethodBeat.o(253446);
                return gVar4;
        }
    }

    public static LinkedList<avn> dBR() {
        AppMethodBeat.i(253447);
        y yVar = y.vXH;
        if (y.dCM()) {
            LinkedList<avn> linkedList = new LinkedList<>();
            y.a aVar = y.uoV;
            int dhf = y.dhf();
            for (int i2 = 0; i2 < dhf; i2++) {
                avn avn = new avn();
                avn.hFI = i2 % 7 == 0 ? 0 : 1;
                avn.LGi = (dhf * 1000) - (i2 * 50);
                FinderContact finderContact = new FinderContact();
                finderContact.username = "index:".concat(String.valueOf(i2));
                finderContact.nickname = "测试用户".concat(String.valueOf(i2));
                avn.contact = finderContact;
                linkedList.add(avn);
            }
            AppMethodBeat.o(253447);
            return linkedList;
        }
        AppMethodBeat.o(253447);
        return null;
    }

    public static MultiProcessMMKV VQ() {
        AppMethodBeat.i(253448);
        StringBuilder append = new StringBuilder().append(vVG);
        p.g(com.tencent.mm.kernel.g.aAf(), "MMKernel.account()");
        MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV(append.append(com.tencent.mm.kernel.a.getUin()).toString());
        p.g(mmkv, "MultiProcessMMKV.getMMKV…+ MMKernel.account().uin)");
        AppMethodBeat.o(253448);
        return mmkv;
    }

    public static String awU(int i2) {
        AppMethodBeat.i(261448);
        if (i2 == 0 || !com.tencent.mm.ac.d.cW(i2, 7)) {
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            String string = context.getResources().getString(R.string.d03);
            p.g(string, "if (showDetail) {\n      …1/19/21\n                }");
            AppMethodBeat.o(261448);
            return string;
        }
        Context context2 = MMApplicationContext.getContext();
        p.g(context2, "MMApplicationContext.getContext()");
        String string2 = context2.getResources().getString(R.string.jc3);
        p.g(string2, "if (showDetail) {\n      …e_list)\n                }");
        AppMethodBeat.o(261448);
        return string2;
    }

    public static LinkedList<avh> b(List<byte[]> list, LinkedList<avh> linkedList) {
        AppMethodBeat.i(253450);
        p.h(list, "list");
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        } else {
            linkedList.clear();
        }
        for (byte[] bArr : list) {
            avh avh = new avh();
            avh.parseFrom(bArr);
            linkedList.add(avh);
        }
        AppMethodBeat.o(253450);
        return linkedList;
    }

    public static LinkedList<String> ez(List<byte[]> list) {
        AppMethodBeat.i(253451);
        LinkedList<String> linkedList = new LinkedList<>();
        if (list == null) {
            Log.i(TAG, "getFinderLiveAndienceFileIdList list is empty!");
            AppMethodBeat.o(253451);
            return linkedList;
        }
        StringBuilder sb = new StringBuilder("AndienceFileIdList:");
        int i2 = 0;
        for (T t : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            avh avh = new avh();
            avh.parseFrom((byte[]) t);
            String str = avh.KRd;
            String str2 = str;
            if (!(str2 == null || str2.length() == 0)) {
                linkedList.add(str);
                p.g(sb.append("[" + avh.title + ',' + avh.KRd + ']'), "printMsg.append(\"[${item.title},${item.file_id}]\")");
                i2 = i3;
            } else {
                Log.i(TAG, "getFinderLiveAndienceFileIdList index:" + i2 + " item:" + avh.title + " is empty!");
                i2 = i3;
            }
        }
        Log.i(TAG, "getFinderLiveAndienceFileIdList ".concat(String.valueOf(sb)));
        AppMethodBeat.o(253451);
        return linkedList;
    }

    public static LinkedList<aus> c(List<byte[]> list, LinkedList<aus> linkedList) {
        AppMethodBeat.i(261449);
        p.h(list, "list");
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        } else {
            linkedList.clear();
        }
        for (byte[] bArr : list) {
            aus aus = new aus();
            aus.parseFrom(bArr);
            linkedList.add(aus);
        }
        AppMethodBeat.o(261449);
        return linkedList;
    }

    public static String awV(int i2) {
        AppMethodBeat.i(261450);
        switch (i2) {
            case 1:
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                String string = context.getResources().getString(R.string.jco);
                p.g(string, "MMApplicationContext.get…live_visitor_role_wechat)");
                AppMethodBeat.o(261450);
                return string;
            case 2:
            default:
                AppMethodBeat.o(261450);
                return "";
            case 3:
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                String string2 = context2.getResources().getString(R.string.jch);
                p.g(string2, "MMApplicationContext.get…live_visitor_role_finder)");
                AppMethodBeat.o(261450);
                return string2;
        }
    }

    public static FinderContact m(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        AppMethodBeat.i(261451);
        p.h(gVar, "liveData");
        FinderContact finderContact = new FinderContact();
        aus aus = gVar.UQh;
        switch (aus.LFy) {
            case 2:
                finderContact.username = "";
                finderContact.nickname = aus.nickname;
                finderContact.headUrl = aus.qFV;
                break;
            case 3:
                finderContact.username = z.aUg();
                finderContact.nickname = aus.nickname;
                finderContact.headUrl = aus.qFV;
                break;
            default:
                finderContact.username = z.aTY();
                finderContact.nickname = z.aUa();
                finderContact.headUrl = aus.qFV;
                break;
        }
        AppMethodBeat.o(261451);
        return finderContact;
    }

    public static void g(ImageView imageView, String str, int i2) {
        AppMethodBeat.i(261453);
        p.h(imageView, "avatarIv");
        p.h(str, "avatarUrl");
        switch (i2) {
            case 1:
            case 2:
                com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dkb = com.tencent.mm.plugin.finder.loader.m.dkb();
                com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(str);
                com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                dkb.a(aVar, imageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.WX_AVATAR));
                AppMethodBeat.o(261453);
                return;
            default:
                com.tencent.mm.plugin.finder.loader.m mVar3 = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dkb2 = com.tencent.mm.plugin.finder.loader.m.dkb();
                com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(str);
                com.tencent.mm.plugin.finder.loader.m mVar4 = com.tencent.mm.plugin.finder.loader.m.uJa;
                dkb2.a(aVar2, com.tencent.mm.plugin.finder.loader.m.a(m.a.WX_AVATAR)).a(new h(imageView)).vC();
                AppMethodBeat.o(261453);
                return;
        }
    }

    public static LinkedList<aus> hVr() {
        LinkedList<aus> linkedList;
        Exception e2;
        AppMethodBeat.i(261454);
        LinkedList<aus> linkedList2 = new LinkedList<>();
        try {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            String str = (String) aAh.azQ().i(ar.a.USERINFO_FINDER_LIVE_ALIAS_LIST1_STRING_SYNC);
            fgf fgf = new fgf();
            if (str != null) {
                Charset charset = kotlin.n.d.ISO_8859_1;
                if (str == null) {
                    t tVar = new t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(261454);
                    throw tVar;
                }
                byte[] bytes = str.getBytes(charset);
                p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                fgf.parseFrom(bytes);
            }
            linkedList = fgf.LEV;
            p.g(linkedList, "safeAliasInfo.alias_info");
            try {
                Log.i(TAG, "getAliasInfoList result:" + com.tencent.mm.ac.g.bN(fgf));
                AppMethodBeat.o(261454);
            } catch (Exception e3) {
                e2 = e3;
                try {
                    y yVar = y.vXH;
                    y.a(e2, "getAliasInfoList:" + e2.getMessage());
                    AppMethodBeat.o(261454);
                } catch (Throwable th) {
                    AppMethodBeat.o(261454);
                    return linkedList;
                }
                return linkedList;
            }
        } catch (Exception e4) {
            e2 = e4;
            linkedList = linkedList2;
            y yVar2 = y.vXH;
            y.a(e2, "getAliasInfoList:" + e2.getMessage());
            AppMethodBeat.o(261454);
            return linkedList;
        } catch (Throwable th2) {
            linkedList = linkedList2;
            AppMethodBeat.o(261454);
            return linkedList;
        }
        return linkedList;
    }

    public static void a(LinkedList<aus> linkedList, int i2, long j2) {
        AppMethodBeat.i(261455);
        bU(linkedList);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_LIVE_VISITOR_ROLE_INT_SYNC, Integer.valueOf(i2));
        com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh2, "MMKernel.storage()");
        aAh2.azQ().set(ar.a.USERINFO_FINDER_LIVE_ALIAS_MODIFY_TIME_LONG_SYNC, Long.valueOf(j2));
        String str = TAG;
        if (linkedList == null) {
            linkedList = new LinkedList<>();
        }
        Log.i(str, String.valueOf(a("saveVisitorRoleInfo", linkedList, i2, j2)));
        AppMethodBeat.o(261455);
    }

    public static void bU(LinkedList<aus> linkedList) {
        AppMethodBeat.i(261456);
        try {
            fgf fgf = new fgf();
            if (linkedList == null) {
                linkedList = new LinkedList<>();
            }
            fgf.LEV = linkedList;
            byte[] byteArray = fgf.toByteArray();
            p.g(byteArray, "saveList.toByteArray()");
            String str = new String(byteArray, kotlin.n.d.ISO_8859_1);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_LIVE_ALIAS_LIST1_STRING_SYNC, str);
            Log.i(TAG, "saveAliasInfoList cacheListStr:" + com.tencent.mm.ac.g.bN(fgf));
            AppMethodBeat.o(261456);
        } catch (Exception e2) {
            y yVar = y.vXH;
            y.a(e2, "saveAliasInfoList:" + e2.getMessage());
            AppMethodBeat.o(261456);
        }
    }

    public static boolean byb(String str) {
        AppMethodBeat.i(261457);
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            AppMethodBeat.o(261457);
            return false;
        }
        y yVar = y.vXH;
        if (y.awn(str)) {
            AppMethodBeat.o(261457);
            return true;
        }
        y yVar2 = y.vXH;
        if (y.In(str)) {
            AppMethodBeat.o(261457);
            return true;
        }
        AppMethodBeat.o(261457);
        return false;
    }

    public static String a(String str, LinkedList<aus> linkedList, int i2, long j2) {
        AppMethodBeat.i(261459);
        p.h(str, "prefix");
        p.h(linkedList, "visitorRoleList");
        StringBuilder sb = new StringBuilder("[printVisitorRoleInfo]" + str + ":curVisitorRoleType:" + i2 + ";visitorRoleModifyTime:" + j2 + ';');
        LinkedList<aus> linkedList2 = linkedList;
        synchronized (linkedList2) {
            try {
                int i3 = 0;
                for (T t : linkedList2) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        j.hxH();
                    }
                    T t2 = t;
                    StringBuilder append = new StringBuilder("[").append(i3).append(':');
                    if (t2 == null) {
                        t2 = "";
                    }
                    sb.append(append.append(com.tencent.mm.ac.g.bN(t2)).append(']').toString());
                    i3 = i4;
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(261459);
                throw th;
            }
        }
        String sb2 = sb.toString();
        p.g(sb2, "msg.toString()");
        AppMethodBeat.o(261459);
        return sb2;
    }

    public static void bD(Activity activity) {
        AppMethodBeat.i(261460);
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            Context context = currentFocus.getContext();
            InputMethodManager inputMethodManager = (InputMethodManager) (context != null ? context.getSystemService("input_method") : null);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
                AppMethodBeat.o(261460);
                return;
            }
        }
        AppMethodBeat.o(261460);
    }

    public static void ad(Context context, String str, String str2) {
        AppMethodBeat.i(261461);
        p.h(context, "context");
        p.h(str, "pageId");
        p.h(str2, "uxInfo");
        StringBuilder sb = new StringBuilder();
        sb.append("<ADInfo><uxInfo>").append(str2).append("</uxInfo></ADInfo>");
        Intent intent = new Intent();
        intent.putExtra("sns_landing_pages_pageid", Util.safeParseLong(str));
        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
        intent.putExtra("sns_landig_pages_from_source", 24);
        intent.putExtra("sns_landing_pages_ad_info", sb.toString());
        com.tencent.mm.br.c.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
        AppMethodBeat.o(261461);
    }

    public static boolean h(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
        return eVar != null && eVar.UPO == 2;
    }

    public static boolean i(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
        return eVar != null && eVar.UPO == 1;
    }

    public static Long a(awe awe) {
        AppMethodBeat.i(261462);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (com.tencent.mm.plugin.finder.storage.c.hVh().value().intValue() == 1) {
            if (awe != null) {
                Long valueOf = Long.valueOf(awe.ViH);
                AppMethodBeat.o(261462);
                return valueOf;
            }
            AppMethodBeat.o(261462);
            return null;
        } else if (awe != null) {
            Long valueOf2 = Long.valueOf(awe.LDN);
            AppMethodBeat.o(261462);
            return valueOf2;
        } else {
            AppMethodBeat.o(261462);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String uhA;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(Context context, String str) {
            super(0);
            this.$context = context;
            this.uhA = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(261441);
            u.makeText(this.$context, this.uhA, 0).show();
            x xVar = x.SXb;
            AppMethodBeat.o(261441);
            return xVar;
        }
    }

    public static void a(auf auf, aj ajVar, com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        boolean z;
        Integer num = null;
        boolean z2 = false;
        AppMethodBeat.i(261442);
        p.h(auf, "response");
        p.h(gVar, "liveData");
        gVar.UQe.clear();
        fge fge = auf.ViK;
        LinkedList<ffr> linkedList = fge != null ? fge.ViM : null;
        String str = TAG;
        StringBuilder sb = new StringBuilder("handleJoinLiveLikeConfettiResponse, size:");
        if (linkedList != null) {
            num = Integer.valueOf(linkedList.size());
        }
        StringBuilder append = sb.append(num).append(", confettiPlugin init ok?:");
        if (ajVar != null) {
            z = true;
        } else {
            z = false;
        }
        Log.i(str, append.append(z).toString());
        LinkedList<ffr> linkedList2 = linkedList;
        if (linkedList2 == null || linkedList2.isEmpty()) {
            z2 = true;
        }
        if (!z2) {
            gVar.UQe.addAll(linkedList);
            if (ajVar != null) {
                ajVar.bS(gVar.UQe);
                AppMethodBeat.o(261442);
                return;
            }
        }
        AppMethodBeat.o(261442);
    }

    public static boolean i(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        AppMethodBeat.i(253424);
        p.h(gVar, "liveData");
        if (gVar.sourceType == 1 || gVar.sourceType == 2 || gVar.sourceType == 3) {
            AppMethodBeat.o(253424);
            return true;
        }
        AppMethodBeat.o(253424);
        return false;
    }

    public static void a(com.tencent.mm.plugin.finder.live.plugin.d dVar) {
        AppMethodBeat.i(253425);
        p.h(dVar, "plugin");
        if (dVar.umb.getLayoutParams() != null && (dVar.umb.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && dVar.isLandscape()) {
            Context context = dVar.umb.getContext();
            p.g(context, "plugin.vg.context");
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.cb);
            ViewGroup.LayoutParams layoutParams = dVar.umb.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(253425);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = dimensionPixelOffset;
        }
        AppMethodBeat.o(253425);
    }

    public static void a(com.tencent.mm.plugin.finder.live.plugin.d dVar, boolean z) {
        AppMethodBeat.i(253426);
        p.h(dVar, "plugin");
        dVar.umb.post(new a(dVar, z));
        AppMethodBeat.o(253426);
    }

    public static /* synthetic */ String hm(String str, String str2) {
        aus aus;
        AppMethodBeat.i(261452);
        if (!dBP() && byb(str)) {
            com.tencent.mm.plugin.finder.live.model.o oVar = com.tencent.mm.plugin.finder.live.model.o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = com.tencent.mm.plugin.finder.live.model.o.dfZ();
            if (!(dfZ == null || (aus = dfZ.UQh) == null || aus.LFy != 2)) {
                if (str2 == null) {
                    str2 = "";
                }
                AppMethodBeat.o(261452);
                return str2;
            }
        }
        y yVar = y.vXH;
        String he = y.he(str, str2);
        AppMethodBeat.o(261452);
        return he;
    }

    public static /* synthetic */ boolean hn(String str, String str2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(261458);
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean isEqual = z2 & Util.isEqual(str, str2);
        AppMethodBeat.o(261458);
        return isEqual;
    }

    public static final /* synthetic */ boolean t(BaseFinderFeed baseFinderFeed) {
        String str;
        AppMethodBeat.i(253453);
        com.tencent.mm.plugin.finder.api.g gVar = baseFinderFeed.contact;
        if (gVar != null) {
            str = gVar.field_username;
        } else {
            str = null;
        }
        boolean I = kotlin.n.n.I(str, z.aUg(), false);
        AppMethodBeat.o(253453);
        return I;
    }
}
