package com.tencent.mm.util;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.ako;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mmkv.MMKV;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b+\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0016\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\bJ\u000e\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\bJ\u0006\u0010\"\u001a\u00020\u001cJ\u0006\u0010#\u001a\u00020\u001cJ\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\u0004J\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020\u0004J\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\u0004J\u0006\u0010*\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020\u0004J\u0006\u0010,\u001a\u00020\bJ\u0006\u0010-\u001a\u00020\u001cJ\u0006\u0010.\u001a\u00020\u001cJ\u0006\u0010/\u001a\u00020\u0004J\u0006\u00100\u001a\u00020\u0004J\u0006\u00101\u001a\u00020\u0004J\u0006\u00102\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020\u0004J\u0006\u00105\u001a\u00020\u001cJ\u0006\u00106\u001a\u00020\u001cJ\u0006\u00107\u001a\u00020\u001cJ\u0006\u00108\u001a\u00020\u001cJ\u0006\u00109\u001a\u00020\u001cJ\u0006\u0010:\u001a\u00020\u0004J\u0006\u0010;\u001a\u00020\u001cJ\u0006\u0010<\u001a\u00020\u001cJ\u0006\u0010=\u001a\u00020\u0004J\u0006\u0010>\u001a\u00020\u0004J\u0006\u0010?\u001a\u00020\u001cJ\u000e\u0010@\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\bJ\u0006\u0010A\u001a\u00020\u001cJ\u0006\u0010B\u001a\u00020\u001cJ\u0006\u0010C\u001a\u00020\u001cJ\u0016\u0010D\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\b2\u0006\u0010E\u001a\u00020\bJ\u0006\u0010F\u001a\u00020\u001cR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR-\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u000ej\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006G"}, hxF = {"Lcom/tencent/mm/util/ExptSettingLogic;", "", "()V", c.QYv, "", "getInnerVersion", "()I", "InnerVersionKey", "", "getInnerVersionKey", "()Ljava/lang/String;", "TAG", "getTAG", "defaultValueMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getDefaultValueMap", "()Ljava/util/HashMap;", "exptSettingConfig", "Lcom/tencent/mm/protocal/protobuf/ExptSettingConfig;", "getExptSettingConfig", "()Lcom/tencent/mm/protocal/protobuf/ExptSettingConfig;", "mmkv", "Lcom/tencent/mmkv/MMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mmkv/MMKV;", "applyLocalTemplate", "", "getConfigKey", "groupKey", "itemKey", "getConfigValue", "key", "getCopyMsgInfoFlag", "getExptFlag", "getExptFlagInt", "getIsUseSysEditTextFlag", "getJsAccelerateFlag", "getOpenAppShortcutFlag", "getOpenInlineTagC2CFlag", "getOpenInlineTagSNSFlag", "getOpenMvChattingFlag", "getOpenMvTypeFlag", "getTinkerBaseId", "isCacheSosResult", "isCloseAutoTinkerPatch", "isFuIconOpenInSnsFeeds", "isIconOpenInContact", "isIconOpenInGroup", "isIconOpenInNewMsg", "isIconOpenInSnsCommentAndLike", "isIconOpenInSnsFeeds", "isInnerUser", "isOpenAutoProcessor", "isOpenCenterActionBar", "isOpenImageSearch", "isOpenMultiTaskMode", "isOpenNewTips", "isOpenNewUpdater", "isOpenNorthWestIDC", "isOpenTextStatus", "isPlanetOpen", "isRedOrPurple", "needRestart", "openPreload", "openXEffector", "resetTemplate", "setConfigValue", "value", "useQQMusicPlayer", "libcompatible_release"})
public final class c {
    private static final String QYv = QYv;
    private static final int QYw = 8;
    private static final akm QYx = new akm();
    private static final HashMap<String, String> QYy = new HashMap<>();
    public static final c QYz = new c();
    private static final String TAG = TAG;
    private static final MMKV mmkv = MMKV.mmkvWithID("ExptSettingLogic", 2);

    static {
        AppMethodBeat.i(215534);
        akn akn = new akn();
        akn.key = "total";
        akn.title = "全局配置";
        ako ako = new ako();
        ako.key = "total";
        ako.title = "试验总开关";
        ako.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako.type = 0;
        akn.iAd.add(ako);
        x xVar = x.SXb;
        ako ako2 = new ako();
        ako2.key = "copyMsgInfo";
        ako2.title = "复制消息体";
        ako2.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako2.type = 0;
        akn.iAd.add(ako2);
        x xVar2 = x.SXb;
        ako ako3 = new ako();
        ako3.key = "switchNorthwestIDC";
        ako3.title = "是否切换西北IDC";
        ako3.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako3.type = 0;
        akn.iAd.add(ako3);
        x xVar3 = x.SXb;
        ako ako4 = new ako();
        ako4.key = "openAppShortcut";
        ako4.title = "是否打开快捷菜单";
        ako4.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako4.type = 0;
        ako4.Lty = 1;
        akn.iAd.add(ako4);
        x xVar4 = x.SXb;
        ako ako5 = new ako();
        ako5.key = "openCenterActionBar";
        ako5.title = "是否开启ActionBar居中";
        ako5.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako5.type = 0;
        ako5.Lty = 1;
        akn.iAd.add(ako5);
        x xVar5 = x.SXb;
        ako ako6 = new ako();
        ako6.key = "openMultiTaskMode";
        ako6.title = "是否开启负一屏";
        ako6.oxJ = "1";
        ako6.type = 0;
        ako6.Lty = 1;
        akn.iAd.add(ako6);
        x xVar6 = x.SXb;
        QYx.Ltx.add(akn);
        x xVar7 = x.SXb;
        akn akn2 = new akn();
        akn2.key = "search";
        akn2.title = "基础搜索配置";
        ako ako7 = new ako();
        ako7.key = "openResetTemplate";
        ako7.title = "是否启动重置模板";
        ako7.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako7.Lty = 1;
        ako7.type = 0;
        akn2.iAd.add(ako7);
        x xVar8 = x.SXb;
        ako ako8 = new ako();
        ako8.key = "applyLocalTemplate";
        ako8.title = "是否允许应用本地模板";
        ako8.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako8.type = 0;
        akn2.iAd.add(ako8);
        x xVar9 = x.SXb;
        ako ako9 = new ako();
        ako9.key = "openInlineTagC2C";
        ako9.title = "是否打开行内Tag（会话）";
        ako9.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako9.type = 0;
        akn2.iAd.add(ako9);
        x xVar10 = x.SXb;
        ako ako10 = new ako();
        ako10.key = "openInlineTagSns";
        ako10.title = "是否打开行内Tag（朋友圈）";
        ako10.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako10.type = 0;
        akn2.iAd.add(ako10);
        x xVar11 = x.SXb;
        ako ako11 = new ako();
        ako11.key = "isUseSysEditText";
        ako11.title = "是否使用系统EditText";
        ako11.oxJ = "1";
        ako11.type = 0;
        akn2.iAd.add(ako11);
        x xVar12 = x.SXb;
        QYx.Ltx.add(akn2);
        x xVar13 = x.SXb;
        akn akn3 = new akn();
        akn3.key = "topstory";
        akn3.title = "看一看配置";
        ako ako12 = new ako();
        ako12.key = "openJsAccelerate";
        ako12.title = "是否打开JSCodeCache加速";
        ako12.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako12.type = 0;
        akn3.iAd.add(ako12);
        x xVar14 = x.SXb;
        QYx.Ltx.add(akn3);
        x xVar15 = x.SXb;
        akn akn4 = new akn();
        akn4.key = "websearch";
        akn4.title = "搜一搜配置";
        ako ako13 = new ako();
        ako13.key = "openPreload";
        ako13.title = "是否打开搜一搜WebView预加载";
        ako13.oxJ = "1";
        ako13.Lty = 1;
        ako13.type = 0;
        akn4.iAd.add(ako13);
        x xVar16 = x.SXb;
        ako ako14 = new ako();
        ako14.key = "cacheSosResult";
        ako14.title = "是否存储搜一搜结果到SDcard";
        ako14.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako14.type = 0;
        akn4.iAd.add(ako14);
        x xVar17 = x.SXb;
        ako ako15 = new ako();
        ako15.key = "openImageSearch";
        ako15.title = "是否打开搜一搜图片搜索";
        ako15.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako15.type = 0;
        akn4.iAd.add(ako15);
        x xVar18 = x.SXb;
        QYx.Ltx.add(akn4);
        x xVar19 = x.SXb;
        akn akn5 = new akn();
        akn5.key = "updater";
        akn5.title = "更新配置";
        ako ako16 = new ako();
        ako16.key = "closeAutoTinkerPatch";
        ako16.title = "是否关闭自动TinkerPatch";
        ako16.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako16.type = 0;
        akn5.iAd.add(ako16);
        x xVar20 = x.SXb;
        ako ako17 = new ako();
        ako17.key = "openNewUpdater";
        ako17.title = "是否打开新版更新机制";
        ako17.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako17.type = 0;
        akn5.iAd.add(ako17);
        x xVar21 = x.SXb;
        ako ako18 = new ako();
        ako18.key = "openAutoProcessor";
        ako18.title = "是否打开自动处理逻辑";
        ako18.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako18.type = 0;
        akn5.iAd.add(ako18);
        x xVar22 = x.SXb;
        ako ako19 = new ako();
        ako19.key = "tinkerBaseId";
        ako19.title = "设置TinkerBaseId";
        ako19.oxJ = "";
        ako19.type = 1;
        akn5.iAd.add(ako19);
        x xVar23 = x.SXb;
        QYx.Ltx.add(akn5);
        x xVar24 = x.SXb;
        akn akn6 = new akn();
        akn6.key = "musicplayer";
        akn6.title = "音乐播放器";
        ako ako20 = new ako();
        ako20.key = "openXEffector";
        ako20.title = "是否打开XEffector";
        ako20.oxJ = "1";
        ako20.type = 0;
        akn6.iAd.add(ako20);
        x xVar25 = x.SXb;
        ako ako21 = new ako();
        ako21.key = "openMvType";
        ako21.title = "是否打开新的MV卡片类型";
        ako21.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako21.type = 0;
        akn6.iAd.add(ako21);
        x xVar26 = x.SXb;
        ako ako22 = new ako();
        ako22.key = "openMvChatting";
        ako22.title = "是否打开聊天室";
        ako22.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako22.type = 0;
        akn6.iAd.add(ako22);
        x xVar27 = x.SXb;
        ako ako23 = new ako();
        ako23.key = "useQQMusicPlayer";
        ako23.title = "是否使用QQ音乐播放器";
        ako23.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako23.type = 0;
        akn6.iAd.add(ako23);
        x xVar28 = x.SXb;
        QYx.Ltx.add(akn6);
        x xVar29 = x.SXb;
        akn akn7 = new akn();
        akn7.key = "textstatus";
        akn7.title = "状态配置";
        ako ako24 = new ako();
        ako24.key = "openTextStatus";
        ako24.title = "开启文字状态";
        ako24.oxJ = "1";
        ako24.Lty = 0;
        ako24.type = 0;
        akn7.iAd.add(ako24);
        x xVar30 = x.SXb;
        ako ako25 = new ako();
        ako25.key = "isPlanetOpen";
        ako25.title = "开启状态星球";
        ako25.oxJ = AppEventsConstants.EVENT_PARAM_VALUE_NO;
        ako25.type = 0;
        akn7.iAd.add(ako25);
        x xVar31 = x.SXb;
        ako ako26 = new ako();
        ako26.key = "isNewTipsOpen";
        ako26.title = "开启NewTips";
        ako26.oxJ = "1";
        ako26.type = 0;
        akn7.iAd.add(ako26);
        x xVar32 = x.SXb;
        ako ako27 = new ako();
        ako27.key = "isIconOpenInContact";
        ako27.title = "开启通讯录icon";
        ako27.oxJ = "1";
        ako27.type = 0;
        akn7.iAd.add(ako27);
        x xVar33 = x.SXb;
        ako ako28 = new ako();
        ako28.key = "isIconOpenInGroup";
        ako28.title = "开启群聊icon";
        ako28.oxJ = "1";
        ako28.type = 0;
        akn7.iAd.add(ako28);
        x xVar34 = x.SXb;
        ako ako29 = new ako();
        ako29.key = "isIconOpenInSnsFeeds";
        ako29.title = "开启朋友圈feeds icon";
        ako29.oxJ = "1";
        ako29.type = 0;
        akn7.iAd.add(ako29);
        x xVar35 = x.SXb;
        ako ako30 = new ako();
        ako30.key = "isFuIconOpenInSnsFeeds";
        ako30.title = "开启朋友圈福 feeds icon";
        ako30.oxJ = "1";
        ako30.type = 0;
        akn7.iAd.add(ako30);
        x xVar36 = x.SXb;
        ako ako31 = new ako();
        ako31.key = "isIconOpenInSnsCommentAndLike";
        ako31.title = "开启朋友圈点赞/评论icon";
        ako31.oxJ = "1";
        ako31.type = 0;
        akn7.iAd.add(ako31);
        x xVar37 = x.SXb;
        ako ako32 = new ako();
        ako32.key = "isIconOpenInNewMsg";
        ako32.title = "开启朋友圈消息提醒列表icon";
        ako32.oxJ = "1";
        ako32.type = 0;
        akn7.iAd.add(ako32);
        x xVar38 = x.SXb;
        QYx.Ltx.add(akn7);
        x xVar39 = x.SXb;
        h.RTc.b(AnonymousClass1.QYA, TAG);
        AppMethodBeat.o(215534);
    }

    private c() {
    }

    public static String getTAG() {
        return TAG;
    }

    public static String hcY() {
        return QYv;
    }

    public static int hcZ() {
        return QYw;
    }

    public static akm hda() {
        return QYx;
    }

    public static MMKV hdb() {
        return mmkv;
    }

    public static HashMap<String, String> hdc() {
        return QYy;
    }

    public static String np(String str, String str2) {
        AppMethodBeat.i(215522);
        p.h(str, "groupKey");
        p.h(str2, "itemKey");
        String str3 = str + '-' + str2;
        AppMethodBeat.o(215522);
        return str3;
    }

    public static String axY(String str) {
        AppMethodBeat.i(215523);
        p.h(str, "key");
        MMKV mmkv2 = mmkv;
        String str2 = QYy.get(str);
        if (str2 == null) {
            str2 = "";
        }
        String decodeString = mmkv2.decodeString(str, str2);
        p.g(decodeString, "mmkv.decodeString(key, defaultValueMap[key] ?: \"\")");
        AppMethodBeat.o(215523);
        return decodeString;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean nq(java.lang.String r9, java.lang.String r10) {
        /*
        // Method dump skipped, instructions count: 177
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.util.c.nq(java.lang.String, java.lang.String):boolean");
    }

    public static int hdd() {
        AppMethodBeat.i(215525);
        int i2 = Util.getInt(axY(np("total", "total")), 0);
        AppMethodBeat.o(215525);
        return i2;
    }

    public static boolean hde() {
        AppMethodBeat.i(215526);
        if (Util.getInt(axY(np("total", "total")), 0) == 1) {
            AppMethodBeat.o(215526);
            return true;
        }
        AppMethodBeat.o(215526);
        return false;
    }

    public static boolean hdf() {
        return BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.IS_FLAVOR_RED;
    }

    public static boolean hdg() {
        AppMethodBeat.i(215527);
        if (BuildInfo.DEBUG || hdf() || WeChatEnvironment.hasDebugger()) {
            AppMethodBeat.o(215527);
            return true;
        }
        AppMethodBeat.o(215527);
        return false;
    }

    public static int hdh() {
        AppMethodBeat.i(215528);
        int i2 = Util.getInt(axY(np("total", "openAppShortcut")), 0);
        AppMethodBeat.o(215528);
        return i2;
    }

    public static int hdi() {
        AppMethodBeat.i(215529);
        int i2 = Util.getInt(axY(np("search", "openInlineTagC2C")), 0);
        AppMethodBeat.o(215529);
        return i2;
    }

    public static int hdj() {
        AppMethodBeat.i(215530);
        int i2 = Util.getInt(axY(np("search", "openInlineTagSns")), 0);
        AppMethodBeat.o(215530);
        return i2;
    }

    public static String hdk() {
        AppMethodBeat.i(215531);
        String axY = axY(np("updater", "tinkerBaseId"));
        AppMethodBeat.o(215531);
        return axY;
    }

    public static boolean cnC() {
        AppMethodBeat.i(215532);
        if (Util.getInt(axY(np("websearch", "openPreload")), 0) == 1) {
            AppMethodBeat.o(215532);
            return true;
        }
        AppMethodBeat.o(215532);
        return false;
    }

    public static boolean hdl() {
        AppMethodBeat.i(215533);
        if (Util.getInt(axY(np("musicplayer", "openXEffector")), 1) == 1) {
            AppMethodBeat.o(215533);
            return true;
        }
        AppMethodBeat.o(215533);
        return false;
    }
}
