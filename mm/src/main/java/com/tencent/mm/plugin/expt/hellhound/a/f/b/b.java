package com.tencent.mm.plugin.expt.hellhound.a.f.b;

import android.app.Activity;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.i;
import com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a;
import com.tencent.mm.plugin.expt.hellhound.a.h.a;
import com.tencent.mm.protocal.protobuf.cbo;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.dvb;
import com.tencent.mm.protocal.protobuf.dvd;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.protocal.protobuf.dvk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.j.c;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig;", "", "()V", "Companion", "plugin-expt_release"})
public final class b {
    private static final List<i> sIx = j.listOf((Object[]) new i[]{new i("999", com.tencent.mm.plugin.expt.hellhound.core.b.szb, j.ac("ChattingUIFragment", "ChattingUI")), new i("998", com.tencent.mm.plugin.expt.hellhound.core.b.szb, j.ac("BizConversationUI")), new i("104", com.tencent.mm.plugin.expt.hellhound.core.b.szb, j.ac("BizTimeLineUI")), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.szb, j.ac("AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4")), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.szb, j.ac("AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4")), new i("105", "LauncherUI", j.ac("AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4")), new i("105", "LauncherUI", j.ac("AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4")), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.szb, j.ac("AppBrandLauncherUI")), new i("105", "LauncherUI", j.ac("AppBrandLauncherUI")), new i("105", "WXShortcutEntryActivity", j.ac("AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4")), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.szc, j.ac("AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4")), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4")), new i("105", com.tencent.mm.plugin.expt.hellhound.core.b.sze, j.ac("AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4")), new i("113", com.tencent.mm.plugin.expt.hellhound.core.b.szb, j.ac("ReaderAppUI")), new i("114", com.tencent.mm.plugin.expt.hellhound.core.b.szc, j.ac("FTSMainUI")), new i("147", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("FTSMainUI")), new i("115", com.tencent.mm.plugin.expt.hellhound.core.b.szc, j.ac("AddMoreFriendsUI")), new i("116", com.tencent.mm.plugin.expt.hellhound.core.b.szc, j.ac("FMessageConversationUI")), new i("117", com.tencent.mm.plugin.expt.hellhound.core.b.szc, j.ac("ChatroomContactUI")), new i("118", com.tencent.mm.plugin.expt.hellhound.core.b.szc, j.ac("ContactLabelManagerUI")), new i("106", com.tencent.mm.plugin.expt.hellhound.core.b.szb, j.ac("FTSMainUI")), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.szb, j.ac("SelectContactUI")), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.szc, j.ac("SelectContactUI")), new i("107", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("SelectContactUI")), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.szb, j.ac("AddMoreFriendsUI")), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.szc, j.ac("AddMoreFriendsUI")), new i("108", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("AddMoreFriendsUI")), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.szb, j.ac("BaseScanUI")), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.szc, j.ac("BaseScanUI")), new i("109", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("BaseScanUI")), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.szb, j.ac("WalletOfflineEntranceUI")), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.szc, j.ac("WalletOfflineEntranceUI")), new i("110", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("WalletOfflineEntranceUI")), new i("119", com.tencent.mm.plugin.expt.hellhound.core.b.szc, j.ac("BrandServiceIndexUI")), new i("120", com.tencent.mm.plugin.expt.hellhound.core.b.szc, j.ac("EnterpriseBizContactListUI")), new i("121", "AddressUIFragment", j.ac("OpenIMAddressUI")), new i("122", "AddressUIFragment", j.ac("ContactInfoUI")), new i("123", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("SnsTimeLineUI")), new i("124", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("BaseScanUI")), new i("125", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("ShakeReportUI")), new i("126", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("TopStoryHomeUI")), new i("127", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("FTSSOSHomeWebViewUI")), new i("128", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("NearbyFriendsIntroUI", "NearbyFriendsUI", "NearbyPersonalInfoUI", "NearbyFriendShowSayHiUI")), new i("129", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("BottleBeachUI")), new i("130", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("AppBrandPluginUI")), new i("131", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("WebViewUI", "1", "jd_store")), new i("131", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("AppBrandLaunchProxyUI", "AppBrandUI", "AppBrandUI1", "AppBrandUI2", "AppBrandUI3", "AppBrandUI4")), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("GameWebViewUI")), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("GameCenterUI")), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("LuggageGameWebViewUI")), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("GameWebViewMpUI")), new i("132", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("LuggageGameWebViewMpUI")), new i("133", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("AppBrandLauncherUI")), new i("134", com.tencent.mm.plugin.expt.hellhound.core.b.sze, j.ac("SettingsPersonalInfoUI")), new i("135", com.tencent.mm.plugin.expt.hellhound.core.b.sze, j.ac("MallIndexUI", "MallIndexUIv2")), new i("136", com.tencent.mm.plugin.expt.hellhound.core.b.sze, j.ac("FavoriteIndexUI")), new i("137", com.tencent.mm.plugin.expt.hellhound.core.b.sze, j.ac("SnsUserUI", "AlbumUI")), new i("138", com.tencent.mm.plugin.expt.hellhound.core.b.sze, j.ac("CardHomePageNewUI", "CardHomePageUI", "CardIndexUI", "CardInvalidCardUI", "CardViewUI", "ShareCardListUI", "CardHomePageV3UI")), new i("139", "MoreTabUI", j.ac("EmojiStoreV2UI", "MMFlutterActivity")), new i("140", "MoreTabUI", j.ac("SettingsUI")), new i("141", "MoreTabUI", j.ac("StoryCaptureUI", "MMRecordUI")), new i("142", "MoreTabUI", j.ac("StoryGalleryView", "StoryVideoView")), new i("143", "FindMoreFriendsUI", j.ac("FinderTimelineUI")), new i("143", "FindMoreFriendsUI", j.ac("FinderHomeUI")), new i("143", "FindMoreFriendsUI", j.ac("FinderConversationUI")), new i("143", "AddressUIFragment", j.ac("FinderTimelineUI")), new i("143", "FinderHomeUI", j.ac("FinderSelfUI")), new i("145", "LauncherUI", j.ac("FloatingBall")), new i("146", "LauncherUI", j.ac("VideoActivity")), new i("149", "AddressUIFragment", j.ac("OnlyChatContactMgrUI")), new i("150", com.tencent.mm.plugin.expt.hellhound.core.b.szd, j.ac("NearbyHomeUI"))});
    public static final a sIy = new a((byte) 0);

    public static final String aqn(String str) {
        AppMethodBeat.i(122604);
        String aqn = a.aqn(str);
        AppMethodBeat.o(122604);
        return aqn;
    }

    public static final c<String, String> aqp(String str) {
        AppMethodBeat.i(177417);
        c<String, String> aqp = a.aqp(str);
        AppMethodBeat.o(177417);
        return aqp;
    }

    public static final boolean aqr(String str) {
        AppMethodBeat.i(122610);
        boolean aqr = a.aqr(str);
        AppMethodBeat.o(122610);
        return aqr;
    }

    public static final boolean aqt(String str) {
        AppMethodBeat.i(122612);
        boolean aqt = a.aqt(str);
        AppMethodBeat.o(122612);
        return aqt;
    }

    public static final Long aqx(String str) {
        AppMethodBeat.i(122618);
        Long aqx = a.aqx(str);
        AppMethodBeat.o(122618);
        return aqx;
    }

    public static final String aqy(String str) {
        AppMethodBeat.i(185599);
        String aqy = a.aqy(str);
        AppMethodBeat.o(185599);
        return aqy;
    }

    public static final String cPQ() {
        AppMethodBeat.i(122621);
        String cPQ = a.cPQ();
        AppMethodBeat.o(122621);
        return cPQ;
    }

    public static final boolean cPX() {
        AppMethodBeat.i(122619);
        boolean cPX = a.cPX();
        AppMethodBeat.o(122619);
        return cPX;
    }

    public static final String gv(String str, String str2) {
        AppMethodBeat.i(177416);
        String a2 = a.a(str, str2, (List<String>) null);
        AppMethodBeat.o(177416);
        return a2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b<\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010FH\u0007J\u0012\u0010C\u001a\u00020D2\b\u0010G\u001a\u0004\u0018\u00010HH\u0007J\u0012\u0010I\u001a\u0004\u0018\u00010\u00042\u0006\u0010J\u001a\u00020\u0004H\u0007J\u0012\u0010K\u001a\u0004\u0018\u00010\u00042\u0006\u0010L\u001a\u00020\u0004H\u0007J\b\u0010M\u001a\u00020NH\u0007J\u0018\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020P2\u0006\u0010R\u001a\u00020PH\u0007J\u0018\u0010S\u001a\u00020\u00042\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020PH\u0007J\n\u0010W\u001a\u0004\u0018\u00010\u0004H\u0007J\n\u0010X\u001a\u0004\u0018\u00010\u0004H\u0007J(\u0010Y\u001a\u0004\u0018\u00010\u00042\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010\\\u001a\u0004\u0018\u00010\u00042\b\u0010]\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u0010^\u001a\u0004\u0018\u00010\u0004H\u0007J\u0019\u0010_\u001a\u0004\u0018\u00010U2\b\u0010`\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010aJ\u0014\u0010b\u001a\u0004\u0018\u00010\u00042\b\u0010G\u001a\u0004\u0018\u00010HH\u0007J\u0010\u0010b\u001a\u00020\u00042\u0006\u0010c\u001a\u00020PH\u0003J\u0010\u0010d\u001a\u00020\u00042\u0006\u0010c\u001a\u00020PH\u0003J\"\u0010e\u001a\n\u0012\u0004\u0012\u00020f\u0018\u00010A2\b\u0010g\u001a\u0004\u0018\u00010\u00042\u0006\u0010h\u001a\u00020NH\u0007J8\u0010i\u001a\u0004\u0018\u00010\u00042\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010\\\u001a\u0004\u0018\u00010\u00042\b\u0010]\u001a\u0004\u0018\u00010\u00042\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010AH\u0007J.\u0010k\u001a\u0004\u0018\u00010\u00042\b\u0010\\\u001a\u0004\u0018\u00010\u00042\b\u0010]\u001a\u0004\u0018\u00010\u00042\u000e\u0010j\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010AH\u0007J\u0014\u0010l\u001a\u0004\u0018\u00010\u00042\b\u0010m\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010n\u001a\u0004\u0018\u00010\u00042\b\u0010o\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010p\u001a\u00020N2\b\u0010g\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010q\u001a\u00020N2\b\u0010g\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010r\u001a\u00020N2\b\u0010g\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010s\u001a\u00020N2\b\u0010g\u001a\u0004\u0018\u00010\u0004H\u0007J\b\u0010t\u001a\u00020NH\u0007J\u0012\u0010u\u001a\u00020N2\b\u0010v\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010w\u001a\u00020N2\u0006\u0010g\u001a\u00020\u0004H\u0002J\u0012\u0010x\u001a\u00020N2\b\u0010g\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010y\u001a\u00020N2\u0006\u0010g\u001a\u00020\u0004H\u0007J\u0012\u0010z\u001a\u00020N2\b\u0010g\u001a\u0004\u0018\u00010\u0004H\u0007J \u0010{\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010|2\b\u0010L\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010}\u001a\u00020D2\b\u0010g\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010~\u001a\u0004\u0018\u00010\u00042\b\u0010G\u001a\u0004\u0018\u00010HH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020B0AX\u0004¢\u0006\u0002\n\u0000¨\u0006"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/config/HellKSessionConfig$Companion;", "", "()V", "CHATTING_UI", "", "CHATTING_UI_FRAGMENT", "ILLEGAL_CONFIG_ID", "SESSION_ID_ADDRESS_ADD_FRIEND", "SESSION_ID_ADDRESS_SEARCH", "SESSION_ID_ADD_FRIEND", "SESSION_ID_APPBRAND", "SESSION_ID_AppBrandLauncherUI", "SESSION_ID_BIZ_LIST", "SESSION_ID_BIZ_MESSAGE", "SESSION_ID_BaseScanUI", "SESSION_ID_BottleBeachUI", "SESSION_ID_CHAT", "SESSION_ID_CHAT_PLUGIN_WECHAT_MOVEMENT", "SESSION_ID_CHAT_ROOM", "SESSION_ID_CHAT_SERVICE", "SESSION_ID_CHAT_SERVICE_NOTIFY", "SESSION_ID_CHAT_VIRTUAL", "SESSION_ID_CONTACT_BIZ", "SESSION_ID_CardHomePageUI", "SESSION_ID_ChatroomContactUI", "SESSION_ID_ContactInfoUI", "SESSION_ID_ContactLabelManagerUI", "SESSION_ID_ENTERPRISE", "SESSION_ID_EmojiStoreV2UI", "SESSION_ID_FINDER", "SESSION_ID_FIND_SEARCH", "SESSION_ID_FMessageConversationUI", "SESSION_ID_FTSSOSHomeWebViewUI", "SESSION_ID_FavoriteIndexUI", "SESSION_ID_FloatingWindow", "SESSION_ID_GAME", "SESSION_ID_GLOBAL_SEARCH", "SESSION_ID_HELP", "SESSION_ID_MINI_GAME", "SESSION_ID_MallIndexUI", "SESSION_ID_NEW_NEARBY", "SESSION_ID_NearbyFriendsUI", "SESSION_ID_Nearby_Rest", "SESSION_ID_ONLY_CAHT_FRIENDS", "SESSION_ID_OpenIMAddressUI", "SESSION_ID_SEARCH_BaseScanUI", "SESSION_ID_SELECT_CONTACTUI", "SESSION_ID_SettingsPersonalInfoUI", "SESSION_ID_SettingsUI", "SESSION_ID_ShakeReportUI", "SESSION_ID_SnsTimeLineUI", "SESSION_ID_SnsUserUI", "SESSION_ID_StoryCaptureUI", "SESSION_ID_StoryGalleryView", "SESSION_ID_TENCENT_NEWS", "SESSION_ID_TopStoryHomeUI", "SESSION_ID_VOIP_FloatingWindow", "SESSION_ID_WalletOfflineEntranceUI", "SESSION_ID_WebViewUI_jd_store", "TAB_AddressUIFragment", "TAB_FindMoreFriendsUI", "TAB_MainUI", "TAB_MoreTabUI", "TAG", "mSessionIdEntryListLocal", "", "Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/SessionKEntry;", "convertChatSid", "", "hellSession", "Lcom/tencent/mm/protocal/protobuf/HellSession;", "pageSession", "Lcom/tencent/mm/protocal/protobuf/PageSession;", "cutInvalidatePageKeyToName", "pageId", "cutSessonToSid", "session", "doNotNeedSessionMonitor", "", "generateSeq", "", "seqOfPage", "seqOfUBA", "getBizIdOfSessionParam", AppMeasurement.Param.TIMESTAMP, "", "seq", "getCurSession", "getCurSid", "getIdentifySidExpect", "curActivity", "Landroid/app/Activity;", "srcPage", "dstPage", "getLastSession", "getPageStartTimeOfBizId", "bizId", "(Ljava/lang/String;)Ljava/lang/Long;", "getRealChatSid", "chattingType", "getRealChatSidLocal", "getSessionPageOfConfig", "Lcom/tencent/mm/protocal/protobuf/SessionPagePath;", "sid", "isDetailReport", "getSidId", "args", "getSidLocal", "getTabIdOfLauncher", "tabPageName", "getTabSessionIdOfLauncher", "sessionId", "isAppBrandSession", "isBizSid", "isChatSessionId", "isChatSid", "isCurBizSid", "isEffectiveSession", "sessoinId", "isEffectiveSessionBySid", "isFloatSession", "isJdSid", "isVoipSession", "spliteSession", "Lcom/tencent/mm/vending/tuple/Tuple2;", "updateCurSid", "updateRealChatSessionId", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static String a(Activity activity, String str, String str2) {
            AppMethodBeat.i(122591);
            p.g(c.cQa(), "HellSessionCloudConfig.getInstance()");
            duz cQb = c.cQb();
            if (cQb == null) {
                AppMethodBeat.o(122591);
                return null;
            }
            Iterator<dvd> it = cQb.MWg.iterator();
            while (it.hasNext()) {
                dvd next = it.next();
                if (next != null && !next.MWj.isEmpty() && !(!p.j(next.MWb, str))) {
                    String str3 = next.dMl;
                    p.g(str3, "config.pageName");
                    for (String str4 : n.a(str3, new String[]{","})) {
                        if (str4 == null) {
                            t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                            AppMethodBeat.o(122591);
                            throw tVar;
                        } else if (p.j(n.trim(str4).toString(), str2)) {
                            Log.i("HABBYGE-MALI.HellKSessionConfig", "getIdentifySidExpect, sid: " + next.sGF);
                            if (a.a(activity, next)) {
                                String str5 = next.sGF;
                                AppMethodBeat.o(122591);
                                return str5;
                            }
                        }
                    }
                    continue;
                }
            }
            AppMethodBeat.o(122591);
            return null;
        }

        public static String a(String str, String str2, List<String> list) {
            int i2;
            boolean z;
            AppMethodBeat.i(122592);
            String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str);
            String aoE2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str2);
            Log.i("HABBYGE-MALI.HellKSessionConfig", "getSessionIdLocal: " + aoE + ", " + aoE2);
            if ((p.j("ChattingUI", str2) || p.j("ChattingUIFragment", str2)) && (p.j(com.tencent.mm.plugin.expt.hellhound.core.b.szb, aoE) || TextUtils.isEmpty(aoE))) {
                Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: 999");
                AppMethodBeat.o(122592);
                return "999";
            }
            if (p.j("WebViewUI", aoE2) && (p.j("FindMoreFriendsUI", aoE) || p.j("MainUI", aoE) || p.j("AddressUIFragment", aoE))) {
                a.C1021a aVar = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
                if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cQY()) {
                    AppMethodBeat.o(122592);
                    return "148";
                }
            }
            if (p.j("BaseScanUI", aoE2)) {
                a.C1020a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.sJe;
                if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cQQ()) {
                    AppMethodBeat.o(122592);
                    return "124";
                }
                a.C1021a aVar3 = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
                if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cQX()) {
                    AppMethodBeat.o(122592);
                    return "109";
                }
            }
            if (list == null || list.isEmpty()) {
                for (i iVar : b.sIx) {
                    if (TextUtils.isEmpty(aoE)) {
                        AppMethodBeat.o(122592);
                        return null;
                    } else if (p.j(aoE, iVar.sII)) {
                        for (String str3 : iVar.sIJ) {
                            if (p.j(aoE2, str3)) {
                                if (p.j(iVar.sessionId, "109")) {
                                    a.C1021a aVar4 = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
                                    if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cQX()) {
                                        AppMethodBeat.o(122592);
                                        return "109";
                                    }
                                    AppMethodBeat.o(122592);
                                    return "124";
                                } else if (p.j(iVar.sessionId, "105") || p.j(iVar.sessionId, "131")) {
                                    a.C1020a aVar5 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.sJe;
                                    if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cQP()) {
                                        AppMethodBeat.o(122592);
                                        return "131";
                                    }
                                    AppMethodBeat.o(122592);
                                    return "105";
                                } else {
                                    String str4 = iVar.sessionId;
                                    AppMethodBeat.o(122592);
                                    return str4;
                                }
                            }
                        }
                        continue;
                    }
                }
            } else {
                int i3 = 0;
                boolean z2 = false;
                for (i iVar2 : b.sIx) {
                    if (TextUtils.isEmpty(aoE)) {
                        AppMethodBeat.o(122592);
                        return null;
                    }
                    if (!(!p.j(aoE, iVar2.sII))) {
                        Iterator<String> it = iVar2.sIJ.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            if (!z2) {
                                if (!p.j(aoE2, next)) {
                                    break;
                                }
                                z2 = true;
                                i3 = 0;
                            } else if (i3 < list.size()) {
                                int i4 = i3 + 1;
                                if (!p.j(next, list.get(i3))) {
                                    i3 = 0;
                                    z = false;
                                    break;
                                }
                                i3 = i4;
                            } else {
                                String str5 = iVar2.sessionId;
                                AppMethodBeat.o(122592);
                                return str5;
                            }
                        }
                        z = z2;
                        if (z) {
                            String str6 = iVar2.sessionId;
                            AppMethodBeat.o(122592);
                            return str6;
                        }
                        i2 = i3;
                    } else {
                        i2 = i3;
                        z = z2;
                    }
                    i3 = i2;
                    z2 = z;
                }
            }
            AppMethodBeat.o(122592);
            return null;
        }

        public static String aqn(String str) {
            AppMethodBeat.i(122593);
            p.h(str, "session");
            if (str.length() <= 3) {
                AppMethodBeat.o(122593);
                return str;
            } else if (n.a((CharSequence) str, (CharSequence) "_", false)) {
                String str2 = n.a(str, new String[]{"_"}).get(0);
                AppMethodBeat.o(122593);
                return str2;
            } else {
                String substring = str.substring(0, 3);
                p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                AppMethodBeat.o(122593);
                return substring;
            }
        }

        public static c<String, String> aqp(String str) {
            AppMethodBeat.i(122594);
            if (str == null) {
                AppMethodBeat.o(122594);
                return null;
            } else if (p.compare(str.length(), 4) <= 0) {
                AppMethodBeat.o(122594);
                return null;
            } else {
                List<String> a2 = n.a(str, new String[]{"_"});
                if (a2 == null) {
                    AppMethodBeat.o(122594);
                    return null;
                } else if (p.compare(a2.size(), 2) != 0) {
                    AppMethodBeat.o(122594);
                    return null;
                } else {
                    c<String, String> Q = com.tencent.mm.vending.j.a.Q(a2.get(0), a2.get(1));
                    AppMethodBeat.o(122594);
                    return Q;
                }
            }
        }

        static String Hl(int i2) {
            AppMethodBeat.i(122595);
            p.g(c.cQa(), "HellSessionCloudConfig.getInstance()");
            duz cQb = c.cQb();
            if (cQb == null) {
                String Hm = Hm(i2);
                AppMethodBeat.o(122595);
                return Hm;
            } else if (cQb.gyp) {
                Log.e("HABBYGE-MALI.HellKSessionConfig", "getRealChatSid, configCloud.isDel");
                AppMethodBeat.o(122595);
                return "-1";
            } else {
                Iterator<duy> it = cQb.MWe.iterator();
                while (it.hasNext()) {
                    duy next = it.next();
                    if (next != null) {
                        Log.i("HABBYGE-MALI.HellKSessionConfig", "getRealChatSid, chatConfig.expect=" + next.MWc);
                        if (Util.getInt(next.MWc, -1) == i2) {
                            String str = next.sGF;
                            p.g(str, "chatConfig.sid");
                            AppMethodBeat.o(122595);
                            return str;
                        }
                    }
                }
                String Hm2 = Hm(i2);
                AppMethodBeat.o(122595);
                return Hm2;
            }
        }

        private static String Hm(int i2) {
            String str;
            AppMethodBeat.i(122596);
            switch (i2) {
                case 0:
                    str = "101";
                    break;
                case 1:
                    str = "102";
                    break;
                case 2:
                    str = "103";
                    break;
                case 3:
                default:
                    str = "-1";
                    break;
                case 4:
                    str = "111";
                    break;
                case 5:
                    str = "112";
                    break;
            }
            Log.i("HABBYGE-MALI.HellKSessionConfig", "getRealChatSidLocal: ".concat(String.valueOf(str)));
            AppMethodBeat.o(122596);
            return str;
        }

        public static boolean aqr(String str) {
            AppMethodBeat.i(122597);
            if (p.j("101", str) || p.j("102", str) || p.j("103", str) || p.j("111", str) || p.j("112", str)) {
                AppMethodBeat.o(122597);
                return true;
            }
            AppMethodBeat.o(122597);
            return false;
        }

        public static boolean aqt(String str) {
            AppMethodBeat.i(221121);
            if (str == null) {
                AppMethodBeat.o(221121);
                return false;
            }
            boolean j2 = p.j("145", aqn(str));
            AppMethodBeat.o(221121);
            return j2;
        }

        public static Long aqx(String str) {
            boolean z;
            Long l;
            AppMethodBeat.i(122598);
            if (str != null) {
                if (str.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    try {
                        l = Long.valueOf(Long.parseLong(n.a(str, new String[]{"_"}).get(0)));
                    } catch (Exception e2) {
                        Log.printErrStackTrace("HABBYGE-MALI.HellKSessionConfig", e2, "getPageStartTimeOfBusinessId, crash: " + e2.getMessage(), new Object[0]);
                        l = null;
                    }
                    AppMethodBeat.o(122598);
                    return l;
                }
            }
            AppMethodBeat.o(122598);
            return null;
        }

        public static boolean cPX() {
            AppMethodBeat.i(122599);
            if (!com.tencent.mm.plugin.expt.hellhound.a.cNo()) {
                Log.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor, fetchHellhoundConfig: FALSE");
                AppMethodBeat.o(122599);
                return true;
            }
            p.g(c.cQa(), "HellSessionCloudConfig.getInstance()");
            if (c.cQc() || com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0) {
                Log.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor FALSE");
                AppMethodBeat.o(122599);
                return true;
            } else if (!com.tencent.mm.plugin.expt.hellhound.a.cNq()) {
                Log.i("HABBYGE-MALI.HellKSessionConfig", "HellSessionMonitor monitor, close !!!");
                AppMethodBeat.o(122599);
                return true;
            } else {
                AppMethodBeat.o(122599);
                return false;
            }
        }

        public static String cPZ() {
            AppMethodBeat.i(122600);
            cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
            if (cQo == null) {
                AppMethodBeat.o(122600);
                return null;
            }
            String str = cQo.sessionId;
            AppMethodBeat.o(122600);
            return str;
        }

        public static String cPQ() {
            AppMethodBeat.i(122601);
            String cPZ = cPZ();
            if (cPZ == null) {
                AppMethodBeat.o(122601);
                return null;
            }
            String aqn = aqn(cPZ);
            AppMethodBeat.o(122601);
            return aqn;
        }

        public static String aqy(String str) {
            AppMethodBeat.i(221122);
            if (str == null) {
                AppMethodBeat.o(221122);
                return null;
            } else if (n.a((CharSequence) str, (CharSequence) ".", false)) {
                if (p.j(str, com.tencent.mm.plugin.expt.hellhound.core.b.syW)) {
                    AppMethodBeat.o(221122);
                    return AppEventsConstants.EVENT_PARAM_VALUE_NO;
                } else if (p.j(str, com.tencent.mm.plugin.expt.hellhound.core.b.syX)) {
                    AppMethodBeat.o(221122);
                    return "1";
                } else if (p.j(str, com.tencent.mm.plugin.expt.hellhound.core.b.syY)) {
                    AppMethodBeat.o(221122);
                    return "2";
                } else if (p.j(str, com.tencent.mm.plugin.expt.hellhound.core.b.syZ)) {
                    AppMethodBeat.o(221122);
                    return TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
                } else {
                    AppMethodBeat.o(221122);
                    return str;
                }
            } else if (p.j(str, com.tencent.mm.plugin.expt.hellhound.core.b.szb)) {
                AppMethodBeat.o(221122);
                return AppEventsConstants.EVENT_PARAM_VALUE_NO;
            } else if (p.j(str, com.tencent.mm.plugin.expt.hellhound.core.b.szc)) {
                AppMethodBeat.o(221122);
                return "1";
            } else if (p.j(str, com.tencent.mm.plugin.expt.hellhound.core.b.szd)) {
                AppMethodBeat.o(221122);
                return "2";
            } else if (p.j(str, com.tencent.mm.plugin.expt.hellhound.core.b.sze)) {
                AppMethodBeat.o(221122);
                return TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
            } else {
                AppMethodBeat.o(221122);
                return str;
            }
        }

        static boolean aqB(String str) {
            AppMethodBeat.i(185598);
            if (p.j(str, AppEventsConstants.EVENT_PARAM_VALUE_NO) || p.j(str, "1") || p.j(str, "2") || p.j(str, TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL)) {
                AppMethodBeat.o(185598);
                return false;
            }
            boolean isNumeric = com.tencent.mm.plugin.expt.hellhound.core.b.isNumeric(str);
            AppMethodBeat.o(185598);
            return isNumeric;
        }
    }

    static {
        AppMethodBeat.i(122602);
        AppMethodBeat.o(122602);
    }

    public static final String a(Activity activity, String str, String str2, List<String> list) {
        AppMethodBeat.i(122603);
        String aoE = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(str);
        Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: " + aoE + ", " + str2);
        p.g(c.cQa(), "HellSessionCloudConfig.getInstance()");
        duz cQb = c.cQb();
        if (cQb == null) {
            String a2 = a.a(aoE, str2, list);
            AppMethodBeat.o(122603);
            return a2;
        } else if (cQb.gyp) {
            Log.e("HABBYGE-MALI.HellKSessionConfig", "getSidId, sessionCloud.isDel ture");
            AppMethodBeat.o(122603);
            return null;
        } else if ((p.j("ChattingUI", str2) || p.j("ChattingUIFragment", str2)) && (p.j(com.tencent.mm.plugin.expt.hellhound.core.b.szb, aoE) || TextUtils.isEmpty(aoE))) {
            Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId: 999");
            AppMethodBeat.o(122603);
            return "999";
        } else {
            if (p.j("WebViewUI", str2)) {
                if (p.j("FindMoreFriendsUI", aoE)) {
                    if (cQb.MWf == null) {
                        a.C1021a aVar = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
                        if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cQY()) {
                            a.C1021a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
                            com.tencent.mm.plugin.expt.hellhound.a.h.a.mp(false);
                            AppMethodBeat.o(122603);
                            return "148";
                        }
                    } else if (list != null && list.size() >= 2 && p.j(cQb.MWf.MWh, list.get(0)) && p.j(cQb.MWf.MWi, list.get(1))) {
                        Log.i("HABBYGE-MALI.HellKSessionConfig", "getSidId, SESSION_ID_WebViewUI_jd_store");
                        AppMethodBeat.o(122603);
                        return "131";
                    }
                } else if (p.j("MainUI", aoE) || p.j("AddressUIFragment", aoE)) {
                    a.C1021a aVar3 = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
                    if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cQY()) {
                        a.C1021a aVar4 = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
                        com.tencent.mm.plugin.expt.hellhound.a.h.a.mp(false);
                        AppMethodBeat.o(122603);
                        return "148";
                    }
                }
            }
            if (p.j("BaseScanUI", str2)) {
                a.C1020a aVar5 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.sJe;
                if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cQQ()) {
                    a.C1020a aVar6 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.sJe;
                    com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.mm(false);
                    AppMethodBeat.o(122603);
                    return "124";
                }
                a.C1021a aVar7 = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
                if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cQX()) {
                    a.C1021a aVar8 = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
                    com.tencent.mm.plugin.expt.hellhound.a.h.a.mo(false);
                    AppMethodBeat.o(122603);
                    return "109";
                }
            }
            a.C1020a aVar9 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.sJe;
            com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cQQ();
            if (list == null || list.isEmpty()) {
                Iterator<dvb> it = cQb.MWd.iterator();
                while (it.hasNext()) {
                    dvb next = it.next();
                    if (next != null && p.j(next.MWb, aoE)) {
                        String str3 = next.dMl;
                        p.g(str3, "config.pageName");
                        for (String str4 : n.b(str3, new String[]{","})) {
                            if (str4 == null) {
                                t tVar = new t("null cannot be cast to non-null type kotlin.CharSequence");
                                AppMethodBeat.o(122603);
                                throw tVar;
                            } else if (p.j(n.trim(str4).toString(), str2)) {
                                if (p.j(next.sGF, "109")) {
                                    a.C1021a aVar10 = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
                                    if (com.tencent.mm.plugin.expt.hellhound.a.h.a.cQX()) {
                                        a.C1021a aVar11 = com.tencent.mm.plugin.expt.hellhound.a.h.a.sJC;
                                        com.tencent.mm.plugin.expt.hellhound.a.h.a.mo(false);
                                        AppMethodBeat.o(122603);
                                        return "109";
                                    }
                                    AppMethodBeat.o(122603);
                                    return "124";
                                } else if (p.j(next.sGF, "105") || p.j(next.sGF, "131")) {
                                    a.C1020a aVar12 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.sJe;
                                    if (com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.cQP()) {
                                        a.C1020a aVar13 = com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.sJe;
                                        com.tencent.mm.plugin.expt.hellhound.a.f.g.b.a.ml(false);
                                        AppMethodBeat.o(122603);
                                        return "131";
                                    }
                                    AppMethodBeat.o(122603);
                                    return "105";
                                } else {
                                    String str5 = next.sGF;
                                    AppMethodBeat.o(122603);
                                    return str5;
                                }
                            }
                        }
                        continue;
                    }
                }
                String a3 = a.a(activity, aoE, str2);
                if (a3 != null) {
                    AppMethodBeat.o(122603);
                    return a3;
                }
            }
            Log.i("HABBYGE-MALI.HellKSessionConfig", "get sid by cloud config, but NULL, dignose sid By local config !!!");
            String a4 = a.a(aoE, str2, list);
            AppMethodBeat.o(122603);
            return a4;
        }
    }

    public static final String aqo(String str) {
        AppMethodBeat.i(122605);
        p.h(str, "pageId");
        List<String> a2 = n.a(str, new String[]{"_"});
        if (a2.size() < 2) {
            AppMethodBeat.o(122605);
            return str;
        }
        String str2 = a2.get(0);
        AppMethodBeat.o(122605);
        return str2;
    }

    public static final void a(cbo cbo) {
        AppMethodBeat.i(122606);
        if (cbo != null) {
            LinkedList<cyl> linkedList = cbo.Mhr;
            p.g(linkedList, "hellSession.sessions");
            ArrayList arrayList = new ArrayList();
            for (T t : linkedList) {
                T t2 = t;
                String str = t2.sessionId;
                p.g(str, "it.sessionId");
                if (p.j(a.aqn(str), "999") && (t2.MDo == 0 || t2.MDo == 1 || t2.MDo == 2 || t2.MDo == 4 || t2.MDo == 5)) {
                    arrayList.add(t);
                }
            }
            List<cyl> p = j.p(arrayList);
            if (p == null) {
                AppMethodBeat.o(122606);
                return;
            }
            Log.i("HABBYGE-MALI.HellKSessionConfig", "after, sessionList.size: " + p.size());
            String str2 = null;
            for (cyl cyl : p) {
                c<String, String> aqp = a.aqp(cyl.sessionId);
                if (aqp != null) {
                    str2 = "_" + aqp.get(1);
                }
                Log.i("HABBYGE-MALI.HellKSessionConfig", "handleChatting, session, Start: " + cyl.sessionId + ", " + str2);
                cyl.sessionId = a.Hl(cyl.MDo);
                if (!p.j(cyl.sessionId, "-1")) {
                    cyl.sessionId += str2;
                }
                Log.i("HABBYGE-MALI.HellKSessionConfig", "handleChatting, session, End: " + cyl.sessionId);
            }
        }
        AppMethodBeat.o(122606);
    }

    public static final void i(cyl cyl) {
        AppMethodBeat.i(122607);
        if (cyl != null) {
            c<String, String> aqp = a.aqp(cyl.sessionId);
            if (aqp == null) {
                AppMethodBeat.o(122607);
                return;
            } else if (!(!p.j("999", aqp.get(0)))) {
                cyl.sessionId = a.Hl(cyl.MDo) + "_" + aqp.get(1);
            }
        }
        AppMethodBeat.o(122607);
    }

    public static final void aqq(String str) {
        AppMethodBeat.i(177418);
        if (str == null) {
            AppMethodBeat.o(177418);
            return;
        }
        cyl cQo = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
        if (cQo == null) {
            AppMethodBeat.o(177418);
            return;
        }
        c<String, String> aqp = a.aqp(cQo.sessionId);
        if (aqp == null) {
            AppMethodBeat.o(177418);
            return;
        }
        if (!a.aqt(cQo.sessionId)) {
            Log.i("HABBYGE-MALI.HellKSessionConfig", "HellK, updateCurSid, old: " + cQo.sessionId);
            String str2 = str + "_" + aqp.get(1);
            cQo.sessionId = str2;
            com.tencent.mm.plugin.expt.hellhound.a.f.c.c.m(cQo);
            Log.i("HABBYGE-MALI.HellKSessionConfig", "HellK, updateCurSid, new: ".concat(String.valueOf(str2)));
        }
        AppMethodBeat.o(177418);
    }

    public static final String j(cyl cyl) {
        AppMethodBeat.i(122608);
        if (cyl == null) {
            AppMethodBeat.o(122608);
            return null;
        }
        c<String, String> aqp = a.aqp(cyl.sessionId);
        if (aqp == null) {
            String str = cyl.sessionId;
            AppMethodBeat.o(122608);
            return str;
        }
        if (!p.j("999", aqp.get(0))) {
            Object obj = aqp.get(0);
            if (!(obj instanceof Integer) || -1 != ((Integer) obj).intValue()) {
                String str2 = cyl.sessionId;
                AppMethodBeat.o(122608);
                return str2;
            }
        }
        String str3 = a.Hl(cyl.MDo) + "_" + aqp.get(1);
        cyl.sessionId = str3;
        AppMethodBeat.o(122608);
        return str3;
    }

    public static final String k(cyl cyl) {
        AppMethodBeat.i(122609);
        if (cyl == null) {
            AppMethodBeat.o(122609);
            return null;
        }
        c<String, String> aqp = a.aqp(cyl.sessionId);
        if (aqp == null) {
            String str = cyl.sessionId;
            AppMethodBeat.o(122609);
            return str;
        } else if (!p.j("999", aqp.get(0))) {
            String str2 = cyl.sessionId;
            p.g(str2, "pageSession.sessionId");
            String aqn = a.aqn(str2);
            AppMethodBeat.o(122609);
            return aqn;
        } else {
            Log.i("HABBYGE-MALI.HellKSessionConfig", "getRealChatSessionId: " + cyl.MDo);
            String Hl = a.Hl(cyl.MDo);
            AppMethodBeat.o(122609);
            return Hl;
        }
    }

    public static final boolean aqs(String str) {
        AppMethodBeat.i(122611);
        if (str == null) {
            AppMethodBeat.o(122611);
            return false;
        }
        boolean j2 = p.j("105", a.aqn(str));
        AppMethodBeat.o(122611);
        return j2;
    }

    public static final boolean aqu(String str) {
        AppMethodBeat.i(122614);
        if (str == null) {
            AppMethodBeat.o(122614);
            return false;
        }
        String aqn = a.aqn(str);
        if (p.j("999", aqn) || a.aqr(aqn)) {
            AppMethodBeat.o(122614);
            return true;
        }
        AppMethodBeat.o(122614);
        return false;
    }

    public static final boolean aqv(String str) {
        AppMethodBeat.i(122615);
        p.h(str, "sid");
        boolean j2 = p.j("131", str);
        AppMethodBeat.o(122615);
        return j2;
    }

    public static final List<dvk> aqw(String str) {
        AppMethodBeat.i(122616);
        if (str != null) {
            if (!(str.length() == 0)) {
                p.g(d.cQe(), "HellSessionPageCloudConfig.getInstance()");
                dvh cQf = d.cQf();
                if (cQf == null) {
                    AppMethodBeat.o(122616);
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                Iterator<dvk> it = cQf.MWn.iterator();
                while (it.hasNext()) {
                    dvk next = it.next();
                    if (next != null && next.type == 0) {
                        if (!(!p.j(next.sGF, str)) || !(!p.j(next.sGF, "-1"))) {
                            if (!next.vtY) {
                                next = null;
                            }
                            if (next != null) {
                                arrayList.add(next);
                            }
                        }
                    }
                }
                ArrayList arrayList2 = arrayList;
                AppMethodBeat.o(122616);
                return arrayList2;
            }
        }
        AppMethodBeat.o(122616);
        return null;
    }

    public static final String s(long j2, int i2) {
        AppMethodBeat.i(122617);
        String str = String.valueOf(j2) + "_" + i2;
        AppMethodBeat.o(122617);
        return str;
    }

    public static final int fM(int i2, int i3) {
        if (i2 >= i3) {
            return i2 + 1;
        }
        return i3 + 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean cPY() {
        /*
            r2 = 1
            r3 = 0
            r4 = 122620(0x1defc, float:1.71827E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            java.lang.String r1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a.cPQ()
            r0 = r1
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0037
            if (r1 == 0) goto L_0x0035
            java.lang.String r0 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a.aqn(r1)
            java.lang.String r1 = "104"
            boolean r1 = kotlin.g.b.p.j(r1, r0)
            if (r1 != 0) goto L_0x002d
            java.lang.String r1 = "998"
            boolean r0 = kotlin.g.b.p.j(r1, r0)
            if (r0 == 0) goto L_0x0035
        L_0x002d:
            r0 = r2
        L_0x002e:
            if (r0 == 0) goto L_0x0037
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            r0 = r2
        L_0x0034:
            return r0
        L_0x0035:
            r0 = r3
            goto L_0x002e
        L_0x0037:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            r0 = r3
            goto L_0x0034
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.expt.hellhound.a.f.b.b.cPY():boolean");
    }

    public static final String aqz(String str) {
        AppMethodBeat.i(221123);
        if (str == null) {
            AppMethodBeat.o(221123);
            return null;
        } else if (n.a((CharSequence) str, (CharSequence) "_", false)) {
            List<String> a2 = n.a(str, new String[]{"_"});
            String str2 = a.aqy(a2.get(0)) + "_" + a2.get(1);
            AppMethodBeat.o(221123);
            return str2;
        } else {
            AppMethodBeat.o(221123);
            return str;
        }
    }

    public static final boolean aqA(String str) {
        AppMethodBeat.i(185600);
        if (str == null) {
            AppMethodBeat.o(185600);
            return false;
        } else if (n.a((CharSequence) str, (CharSequence) "_", false)) {
            boolean aqB = a.aqB(n.a(str, new String[]{"_"}).get(0));
            AppMethodBeat.o(185600);
            return aqB;
        } else {
            boolean aqB2 = a.aqB(str);
            AppMethodBeat.o(185600);
            return aqB2;
        }
    }
}
