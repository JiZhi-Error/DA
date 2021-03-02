package com.tencent.mm.plugin.finder.storage;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.upload.action.a;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tavkit.component.TAVExporter;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c {
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> UUA = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播间红包入口").b("FINDER_DEBUG_LIVE_LUCKY_MONEY_ENTRANCE", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2, 3}), kotlin.a.j.listOf((Object[]) new String[]{"默认", "不允许", "允许-非节日", "允许-节日"}));
    private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a UUB = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "红包封面小程序是否用体验版", "FINDER_RED_PACKET_IS_Trial_Version");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> UUC = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否用新热度值").d(b.a.clicfg_finder_live_is_use_new_heat).b("FINDER_LIVE_HEAT_USE_NEW", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"否", "是"})).avE("T6");
    private static com.tencent.mm.plugin.finder.storage.config.b<String> UUD = new com.tencent.mm.plugin.finder.storage.config.c("重置直播红包H5", be.UUH).avE("T5");
    private static com.tencent.mm.plugin.finder.storage.config.b<String> UUE = new com.tencent.mm.plugin.finder.storage.config.c("直播红包测试", bf.UUI).avE("T5");
    private static com.tencent.mm.plugin.finder.storage.config.b<String> UUF = new com.tencent.mm.plugin.finder.storage.config.c("重置身份确认半屏", bg.UUJ).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> UUk = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播最多可选可见人数").b("LIVE_USER_MAX_COUNT", kotlin.a.j.listOf((Object[]) new Integer[]{0, 3, 500}), kotlin.a.j.listOf((Object[]) new String[]{"不启动", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "500"})).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> UUl = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否开启手势切Tab").d(b.a.clicfg_finder_gesture_view_pager_home_ui).b("FINDER_OPEN_GESTURE_HOME_UI", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭(0)", "打开(1)"})).avE("T6");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> UUm = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(3, "预加载过滤已读剩下feed数则丢弃").avD("FinderPrefetchFilterMinFeedCount").b("FINDER_PREFETCH_FILTER_MIN_FEED_COUNT", kotlin.a.j.listOf((Object[]) new Integer[]{3, 6}), kotlin.a.j.listOf((Object[]) new String[]{TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "6"})).avE("T6");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> UUn = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "发现页没红点，是否默认跳热门").d(b.a.clicfg_finder_is_jump_hot_without_entrance_reddot).b("IS_HARD_JUMP_HOT_WITHOUT_ENTRANCE_REDDOT", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"})).avE("T6");
    private static com.tencent.mm.plugin.finder.storage.config.c UUo = new com.tencent.mm.plugin.finder.storage.config.c("重置直播多身份教育页", ak.UUG);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> UUp = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "半屏分享流视频播放完后是否弹出下拉引导").d(b.a.clicfg_finder_share_popup_pull_tips_half_screen_enable).b("debugSharePopupPullTipsHalfScreenLayout", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> UUq = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "全屏分享流视频播放完后是否弹出下拉引导").d(b.a.clicfg_finder_share_popup_pull_tips_full_screen_enable).b("debugSharePopupPullTipsFullScreenLayout", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> UUr = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否打开观看直播的身份的入口").d(b.a.clicfg_finder_live_visitor_role_entrance).b("FINDER_LIVE_VISITOR_ROLE_ENTRANCE", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "非release打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> UUs = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(28, "观看直播的身份昵称最大长度").d(b.a.clicfg_finder_live_visitor_role_nickname_length).b("FINDER_LIVE_VISITOR_ROLE_NICKNAME_LENGTH", kotlin.a.j.listOf((Object[]) new Integer[]{14, 28, 32, 50}), kotlin.a.j.listOf((Object[]) new String[]{"14", "28", "32", "50"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> UUt = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否过滤自己的头像").d(b.a.clicfg_finder_live_visitor_role_filter_avatarurl).b("FINDER_LIVE_VISITOR_ROLE_FILTER_MYSELF_AVATARURL", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"是", "否"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> UUu = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "编辑页允许铺满全屏").d(b.a.clicfg_finder_edit_allow_filling_full_screen).b("FINDER_EDIT_ALLOW_FILLING_FULL_SCREEN", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关", "开"})).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> UUv = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "视频号朋友赞列表大头像").d(b.a.clicfg_finder_friend_like_big_avatar).b("FINDER_FRIEND_LIKE_BIG_AVATAR", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> UUw = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "视频显示居中策略").b("MEDIA_CENTER_ADJUST_SELECT", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2})), kotlin.a.j.listOf((Object[]) new String[]{"现网", "靠顶", "靠底"})).avE("T6");
    private static final com.tencent.mm.plugin.finder.storage.config.c UUx = new com.tencent.mm.plugin.finder.storage.config.c("重置是否进入过红包小程序标志", bh.UUK);
    private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a UUy = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "是否展示粉丝数", "FINDER_SHOW_FANS_COUNT");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> UUz = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(90, "活动结束时间支持用户选择最近x天").d(b.a.clicfg_finder_activity_end_time_max_day);
    private static final String msg = ("\n    开关或后台配置需求：\n    1、可配置（接x）：分享页详情页进入的圈外入口隐藏（默认显示）" + dru() + "\n    2、可配置（接x）：搜索仅支持搜索账号（默认仅支持搜索账号）" + drr() + " 后台处理\n    4、可配置（接x）：好友点赞实名展示（默认展示点赞好友数量）\n    5、可配置（接x）：互动通知红点推送到发现页（默认为不推送到发现页）" + drs() + "\n    6、可配置（接x）：没内容情况下推账号/feed（默认为推10条feed）\n\n    开关或后台配置需求：\n    1、可配置（后台配置）：视频可发表最高时长（1min）、最短时长（3s）。可选择视频的最高时长（5min）、可短时长（3s）。 " + b.a.clicfg_ultron_record_video_max_duration_android + "\n    2、可配置（后台配置）：发表配文字最长字数（1000字）。发表评论文字最长字数（800字）。FinderMediaPublishTextLimit\n    3、可配置（后台配置）：timeline每次拉取feed数量（10条）\n    4、可配置（后台配置）：视频图片等是否要预加载（默认为预加载）\n    5、可配追（后台配置）：视频发表最大码率（2000 kbps）、视频发表最大分辨率（1080P）、图片发表最大分辨率（1080P） FinderRecordVideoConfig FinderPublishVideoConfig\n    **字符字数定义：ASCII码字符为0.5个字，其他文字为1个字，emoji为两个字\n    ");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAA = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "推荐 TL snap 滑动体验").b("TIMELINE_SNAP", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAB = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "全局 TL snap 滑动体验").d(b.a.clicfg_finder_enable_global_snap).b("TIMELINE_SNAP_GLOBAL", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAC = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(600, "snap 敏感度").b("TIMELINE_SNAP_THRESHOLD", kotlin.a.j.listOf((Object[]) new Integer[]{1, 300, 600, 1200, 2400, 4800, 6000}), kotlin.a.j.listOf((Object[]) new String[]{"1", "300", "600", "1200", "2400", "4800", "6000"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAD = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "优化找最合适规格播放开关").d(b.a.clicfg_finder_opt_find_best_video_enable).b("OPT_FIND_BEST_VIDEO_ENABLE", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAE = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "修复reinit selector").d(b.a.clicfg_finder_fix_reinit_selector_enable).b("FIX_REINIT_SELECTOR_ENABLE", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vAF = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "直播分享打开单流", "FINDER_LIVE_SHARE_MSG_OPEN_SHARE_PAGE");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAG = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "尝试转h265").d(b.a.clicfg_finder_tran_to_h265_if_enable).b("TRT_TO_TRAN_265_IF_CAN", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAH = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否支持解码器复用").d(b.a.clicfg_finder_ftpp_codec_reuse).b("ENABLE_MEDIA_CODEC_REUSE", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1})), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAI = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否打开视频预加载").b("ENABLE_VIDEO_PRELOAD", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1})), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAJ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否打开帐号详情入口").d(b.a.clicfg_finder_show_account_detail).b("IF_SHOW_ACCOUTN_DETAIL", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static com.tencent.mm.plugin.finder.storage.config.b<Integer> vAK = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播礼物连击生成相同comboId").b("FINDER_LIVE_GIFT_CONTINUOUS_CLICK_MANAGER_USE_SAME_COMBO_ID", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static com.tencent.mm.plugin.finder.storage.config.b<Boolean> vAL = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "直播礼物打赏mock工具是否打开").b("FINDER_LIVE_GIFT_MOCK_DEBUG", kotlin.a.j.listOf((Object[]) new Boolean[]{Boolean.TRUE, Boolean.FALSE}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static com.tencent.mm.plugin.finder.storage.config.b<Integer> vAM = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播礼物debug").b("FINDER_LIVE_GIFT_DEBUG", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static com.tencent.mm.plugin.finder.storage.config.b<Integer> vAN = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "视频号直播礼物开关").d(b.a.clicfg_finder_live_gift_enable).b("FINDER_LIVE_GIFT_ENABLE", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"})).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAO = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(3, "抽奖时长上限(秒)").d(b.a.clicfg_finder_live_gift_anim_duration).b("FINDER_LIVE_GIFT_ANIM_STAY_DURATION", kotlin.a.j.listOf((Object[]) new Integer[]{3, 1, 10, 30}), kotlin.a.j.listOf((Object[]) new String[]{"3秒", "1秒", "10秒", "30秒"})).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAP = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "视频号直播送礼通知昵称长度").d(b.a.clicfg_finder_live_gift_queue_nickname_length);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAQ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(10000, "视频号直播送礼队列最大缓存长度").d(b.a.clicfg_finder_live_gift_queue_max_size);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAR = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(10, "视频号直播送礼队列聚合id延迟消失时长/秒").d(b.a.clicfg_finder_live_gift_comboid_live_time);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Long> vAS = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(9000, "视频号直播送礼大礼物默认播放时长").d(b.a.clicfg_finder_live_gift_full_pag_default_duration);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAT = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播打赏模拟上榜").d(b.a.clicfg_finder_live_msg_badge_debug).b("FINDER_LIVE_MSG_BADGE_DEBUG", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2, 3, 9}), kotlin.a.j.listOf((Object[]) new String[]{"不上榜", "榜1", "榜2", "榜3", "榜9"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAU = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(3, "观众打赏榜单自动刷新间隔/秒").d(b.a.clicfg_finder_live_member_list_autorefresh).b("FINDER_LIVE_MEMBER_LIST_AUTO_REFRESH", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2, 3, 5, 10, -1}), kotlin.a.j.listOf((Object[]) new String[]{"0秒", "1秒", "2秒", "3秒", "5秒", "10秒", "不自动刷新"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAV = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "热度值是否在榜单展示时冻住").d(b.a.clicfg_finder_live_common_info_frozen).b("FINDER_LIVE_COMMON_INFO_FROZEN", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"是", "否"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAW = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播打赏是否本地假插").d(b.a.clicfg_finder_live_msg_send_local_gift).b("FINDER_LIVE_MSG_SEND_LOCAL_GIFT", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"是", "否"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAX = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "评论列表是否保留自己不超过一半上限的评论数据").d(b.a.clicfg_finder_live_msg_save_myself_comment).b("FINDER_LIVE_MSG_SAVE_MYSELF_COMMENT", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"是", "否"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAY;
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAZ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1000, "直播评论长度限制").d(b.a.clicfg_finder_live_comment_list_size_limit).b("FINDER_LIVE_COMMENT_SIZE_LIMIT", kotlin.a.j.listOf((Object[]) new Integer[]{5, 10}), kotlin.a.j.listOf((Object[]) new String[]{"限制5条", "限制10条"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAa = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "横向直播").d(b.a.clicfg_finder_live_orientation_switch).b("debugFinderLiveLandscape", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAb = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "横屏视频自动适配").d(b.a.clicfg_finder_live_fit_landscape_video).b("debugLandscapeVideoFit", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAc = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "直播抽奖入口").d(b.a.clicfg_finder_live_lottery_switch).b("debugFinderLiveLottery", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAd = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(60, "抽奖气泡展示时长(秒)").d(b.a.clicfg_finder_live_lottery_bubble_stay_duration).b("FINDER_LIVE_LOTTERY_BUBBLE_STAY_DURATION", kotlin.a.j.listOf((Object[]) new Integer[]{60, 5, 30, 100}), kotlin.a.j.listOf((Object[]) new String[]{"60秒", "5秒", "30秒", "100秒"})).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAe = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(60, "抽奖中气泡展示时长(秒)").d(b.a.clicfg_finder_live_lottery_bubble_computing_stay_duration).b("FINDER_LIVE_LOTTERY_BUBBLE_COMPUTING_STAY_DURATION", kotlin.a.j.listOf((Object[]) new Integer[]{60, 5, 30, 200}), kotlin.a.j.listOf((Object[]) new String[]{"60秒", "5秒", "30秒", "200秒"})).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAf = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "抽奖是否使用本地过滤策略(默认使用)").d(b.a.clicfg_finder_live_lottery_update_strategy);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAg = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(10, "抽奖本地缓存的已看过抽奖个数").d(b.a.clicfg_finder_live_lottery_saveid_size);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAh = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(5, "视频号直播feed缓存时间").d(b.a.clicfg_finder_live_feed_cache_duration);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAi = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "朋友圈直播一键清除").d(b.a.clicfg_finder_sns_clear_btn_ui).b("FINDER_SNS_CLEAR_BTN", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAj = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "X实验设置浮评初始默认开关", w.vCA).d(b.a.clicfg_finder_feed_bullet_subtitle_expt_set_switch).b("FINDER_BULLET_SUBTITLE_EXPT_SWITCH", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"无", "默认关闭", "默认打开"})).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.c vAk = new com.tencent.mm.plugin.finder.storage.config.c("清除记录的浮评X实验默认配置", x.vCB);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAl = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "音乐跟拍入口").d(b.a.clicfg_finder_follow_pat_entrance).b("FINDER_FOLLOW_PAT_ENTRANCE", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAm = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否支持分享专辑").d(b.a.clicfg_finder_share_album_enable).b("IS_ENABLE_SHARE_ALBUM", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1})), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAn = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否支持分享专辑预加载").d(b.a.clicfg_finder_share_album_preload_enable).b("IS_ENABLE_SHARE_ALBUM_PRELOAD", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1})), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAo = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否开启智能滤镜").b("USERINFO_FINDER_ENABLE_IMAGE_ENHANCEMENT_SETTING_INT_SYNC", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"默认", "开", "关"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAp = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "展示智能滤镜场景").b("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_SCENE_INT_SYNC", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"默认", "开", "关"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAq = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "展示智能滤镜人脸关键点").b("USERINFO_FINDER_SHOW_IMAGE_ENHANCEMENT_FACE_LANDMARKS_INT_SYNC", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"默认", "开", "关"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAr = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "长视频发表入口").d(b.a.clicfg_finder_long_video_post_entrance).b("MEGA_VIDEO_POST_ENTRANCE", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAs = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "开启hevc编码").b("USERINFO_FINDER_HEVC_ENCODE_OPTION_INT_SYNC", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"关", "vcode", "系统硬编"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Long> vAt = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(vxe, "长视频第一阶段预加载size").d(b.a.clicfg_finder_long_video_first_preload).b("MEGA_VIDEO_PRELOAD_FIRST_SIZE", kotlin.a.j.listOf((Object[]) new Long[]{2097152L, 2048L}), kotlin.a.j.listOf((Object[]) new String[]{"2M", "200K"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Long> vAu = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(vxe, "长视频第二阶段预加载size").d(b.a.clicfg_finder_long_video_second_preload).b("MEGA_VIDEO_PRELOAD_SECOND_SIZE", kotlin.a.j.listOf((Object[]) new Long[]{2097152L, 2048L}), kotlin.a.j.listOf((Object[]) new String[]{"2M", "200K"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Long> vAv = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(1, "无spec时，视频码率默认选择").d(b.a.clicfg_finder_video_without_spec_default_bitrate).b("WITHOUT_SPEC_DEFAULT_BIT_RATE", kotlin.a.j.listOf((Object[]) new Long[]{Long.valueOf((long) vxe), 1L}), kotlin.a.j.listOf((Object[]) new String[]{"xVO", "xV2/xV1"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAw = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "长视频浏览入口").d(b.a.clicfg_mega_video_visit_entrance).b("MEGA_VIDEO_POST_ENTRANCE", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAx = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "长视频点赞、收藏和profile tab开关").b("MEGA_VIDEO_TAB_SWITCH", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAy = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "分享流跳转视频号默认Tab").d(b.a.clicfg_finder_share_jump_home_default_tab).b("debugShareJumpHomeDefaultTab", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"关注", "朋友", "推荐"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vAz = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "分享流视频播放完后是否弹出下拉引导").d(b.a.clicfg_finder_share_popup_pull_tips_enable).b("debugSharePopupPullTipsLayout", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBA = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "打开附近的直播和人-强制").d(b.a.clicfg_finder_live_friends_total).b("FINDER_NEARBY_LIVE_FRIENDS", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"})).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBB = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "直播Feed下拉出相似流").d(b.a.clicfg_finder_live_pull_similar).b("FINDER_NEARBY_LIVE_PULL_SIMILAR", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"})).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBC = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "热门搜索推荐").d(b.a.clicfg_finder_search_hot).b("FINDER_SEARCH_HOT", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"})).avE("T42");
    private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBD = new com.tencent.mm.plugin.finder.storage.config.c("清除全屏引导标志", ab.vCF).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBE = new com.tencent.mm.plugin.finder.storage.config.c("清除发表后引导点赞标志", al.vCP).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBF = new com.tencent.mm.plugin.finder.storage.config.c("清除私密赞标志", aa.vCE).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBG = new com.tencent.mm.plugin.finder.storage.config.c("清除全屏点赞引导标志", ac.vCG).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBH = new com.tencent.mm.plugin.finder.storage.config.c("清除直播广场的滑动引导", af.vCJ).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBI = new com.tencent.mm.plugin.finder.storage.config.c("清除附近的直播和人的NEW红点", ae.vCI).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBJ = new com.tencent.mm.plugin.finder.storage.config.c("最近赞过开关-打开", ah.vCL).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<String> vBK = new com.tencent.mm.plugin.finder.storage.config.c("最近赞过开关-关闭", ag.vCK).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vBL = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "直播新手引导一直出", "FINDER_LIVE_NEW_GUIDE_CLEAR_CONFIG");
    private static final com.tencent.mm.plugin.finder.storage.config.c vBM = new com.tencent.mm.plugin.finder.storage.config.c("清除直播新手引导标记", ad.vCH);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBN = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "直播上滑新手引导开关").d(b.a.clicfg_finder_live_guide_enable).b("FINDER_LIVE_GUIDE_ENABLE", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"})).avE("T32_next");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBO = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "进入Finder点击时提前加载").d(b.a.clicfg_finder_enter_prefetch_cgi_final).b("FINDER_FINDER_ENTER_LOAD_SWITCH", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"默认", "打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.c vBQ = new com.tencent.mm.plugin.finder.storage.config.c("重置红包入口关闭标志", ai.vCM);
    private static final com.tencent.mm.plugin.finder.storage.config.c vBR = new com.tencent.mm.plugin.finder.storage.config.c("重置是否进入过红包小程序标志", aj.vCN);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBS = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "cgi流水").b("FINDER_FINDER_CGI_DEBUG_SWITCH", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"默认", "打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Boolean> vBT = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(true, "朋友圈poi点击是否跳转新详情页").d(b.a.clicfg_finder_poi_redirect_to_new_page_v2);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBU = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否开启视频preparing").d(b.a.clicfg_finder_enable_tp_video_prepare).b("FINDER_VIDEO_TP_PREPARE_ENABLE", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"})).avE("T5");
    private static String vBV = "";
    private static String vBW = "100, 60, 1000, 60";
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBX = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "使用 Flutter UI").b("DEBUG_FLUTTER_UI", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{1, 0})), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBY = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(10, "长视频添加进历史准入时间偏移").d(b.a.clicfg_finder_mega_video_add_to_history_offset);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBZ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(10, "长视频从历史删除准出时间偏移").d(b.a.clicfg_finder_mega_video_delete_from_history_offset);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBa = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否使用本地时间创建直播预告").b("FINDER_LIVE_NOTICE_TIME", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"使用服务器时间", "使用本地时间"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBb = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否展示开播分组入口").d(b.a.clicfg_finder_live_visibility_entrance).b("FINDER_LIVE_VISIBLITY_ENTRANCE", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"是", "否"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBc = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "开播分组分组是否插入假数据").b("FINDER_LIVE_VISIBLITY_DEBUG_DATA", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"否", "是"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBd = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "发表强制触发软编压缩").b("FINDER_POST_FORCE_ZIP", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"默认", "开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBe = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否允许软编回退").b("USERINFO_FINDER_ENABLE_SOFT_ENCODE_FALLBACK_INT_SYNC", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关", "开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBf = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否支持横屏预览").d(b.a.clicfg_finder_horizontal_previewing_enable).b("FINDER_ENABLE_HORIZONTAL_PREVIEWING", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关", "开"})).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBg = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "开启完播跟赞").d(b.a.clicfg_finder_follow_like_recommend_enable).b("FINDER_ENABLE_FOLLOW_LIKE_RECOMMEND", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关", "开"})).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBh = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "开启全局全屏体验").d(b.a.clicfg_finder_global_full_screen_enjoy_enable).b("FINDER_GLOBAL_FULLSCREEN_ENJOY", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关", "开"})).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBi = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "开启推荐流全屏体验").d(b.a.clicfg_finder_hot_full_screen_enjoy_enable).b("FINDER_HOT_FULLSCREEN_ENJOY", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关", "开"})).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBj = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "开启关注流全屏体验").d(b.a.clicfg_finder_follow_full_screen_enjoy_enable).b("FINDER_FOLLOW_FULLSCREEN_ENJOY", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关", "开"})).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBk = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "开启朋友流全屏体验").d(b.a.clicfg_finder_friend_full_screen_enjoy_enable).b("FINDER_FRIEND_FULLSCREEN_ENJOY", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关", "开"})).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBl = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "开启其他场景全屏体验").d(b.a.clicfg_finder_other_full_screen_enjoy_enable).b("FINDER_OTHER_FULLSCREEN_ENJOY", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关", "开"})).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBm = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "开启分享流全屏体验").d(b.a.clicfg_finder_share_full_screen_enjoy_enable).b("FINDER_SHARE_FULLSCREEN_ENJOY", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关", "开"})).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBn = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "编辑页关闭半屏预览").d(b.a.clicfg_finder_post_disable_half_screen).b("FINDER_POST_DISABLE_HALF_SCREEN", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关", "开"})).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBo = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "分享流完播自动下滚").d(b.a.clicfg_finder_share_auto_scroll_next_feed).b("FINDER_SHARE_AUTO_SCROLL_NEXT_FEED_ENABLE", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关", "开"})).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Float> vBp = new com.tencent.mm.plugin.finder.storage.config.item.c("全屏视频撑满比例（高/宽）").d(b.a.clicfg_finder_full_screen_inside_radio).b("FINDER_FULLSCREEN_INSIDE_RADIO", kotlin.a.j.listOf((Object[]) new Float[]{Float.valueOf(1.773f), Float.valueOf(1.333f), Float.valueOf(2.0f)}), kotlin.a.j.listOf((Object[]) new String[]{"16:9", "4:3", "2:1"})).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBq = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "视频号直播前置摄像头渲染镜像开关").d(b.a.clicfg_finder_live_front_camera_mirror_enable).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBr = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否过滤视频号内的热门红点").b("FINDER_FILTER_HOT_REDDOT_IN_FINDER", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1})), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"})).d(b.a.clicfg_enable_filter_hot_reddot_in_finder);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBs = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "创作者服务中心URL").b("FINDER_POSTER_SERVICE_URL", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"使用后台下发url", "TEST", "REAL"})).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBt = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播是否打开拍一拍").d(b.a.clicfg_finder_live_tickle_enable).b("FINDER_LIVE_TICKLE_ENABLE", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"})).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBu = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播是否打开回复").d(b.a.clicfg_finder_live_reply_enable).b("FINDER_LIVE_REPLY_ENABLE", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"})).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBv = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "直播美颜开关").d(b.a.clicfg_finder_live_beauty_enable).b("FINDER_LIVE_BEAUTY_ENABLE", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"})).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBw = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "直播滤镜开关").d(b.a.clicfg_finder_live_filter_enable).b("FINDER_LIVE_FILTER_ENABLE", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"})).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBx = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "直播连麦是否打开").d(b.a.clicfg_finder_live_link_mic_enable).b("FINDER_LIVE_LINK_MIC_ENABLE", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"})).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBy = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(3, "活动分享使用的业务分享type").b("FINDER_ACTIVITY_SHARE_BUSINESS_TYPE", kotlin.a.j.listOf((Object[]) new Integer[]{3, 100000001}), kotlin.a.j.listOf((Object[]) new String[]{"默认值", "100000001"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vBz = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "打开附近的直播和人").d(b.a.clicfg_finder_live_friends).b("FINDER_NEARBY_LIVE_FRIENDS", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"})).avE("T32");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vCa = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(15, "直播添加进历史准入时间偏移").d(b.a.clicfg_finder_live_add_to_history_offset);
    public static final c vCb = new c();
    private static final com.tencent.mm.plugin.finder.storage.config.c vwA = new com.tencent.mm.plugin.finder.storage.config.c("测试游戏中心h5调直播", an.vCR);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vwB = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "测试游戏中心h5调直播调试设置").b("GAME_CENTER_JSAPI_DEBUG_CONFIG", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2})), kotlin.a.j.listOf((Object[]) new String[]{"默认(0)", "mock主播没开播", "mock直播已结束"}));
    private static final int vwC = (vwv * 10);
    private static final int vwD = (vwv * 1);
    private static long vwE = (28 * ((long) vwv));
    private static com.tencent.mm.plugin.finder.storage.config.b<Long> vwF = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(vxe, "长视频文件上限").b("debugLongVideoMaxSize", new ArrayList(kotlin.a.j.listOf((Object[]) new Long[]{Long.valueOf((long) vxe), Long.valueOf(20 * ((long) vwv)), Long.valueOf(800 * ((long) vwv))})), kotlin.a.j.listOf((Object[]) new String[]{"默认(0)", "20MB", "800MB"}));
    private static int vwG = (vwv * 28);
    private static final int vwH = 300;
    private static int vwI = TAVExporter.VIDEO_EXPORT_HEIGHT;
    private static int vwJ = 1080;
    private static int vwK = 90;
    private static final int vwL = (vwu * 140);
    private static int vwM = 1080;
    private static int vwN = 1080;
    private static int vwO = 70;
    private static int vwP = 1080;
    private static int vwQ = 1080;
    private static int vwR = 70;
    private static int vwS = 50;
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vwT = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "不再接收私信入口").avD("FinderPrivateRefuseAllMsgSwitch").b("REFUSE_ALL_PRIVATE_MSG_SWITCH", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 0})), kotlin.a.j.listOf((Object[]) new String[]{"默认(0)", "打开入口(1)", "关闭入口(0)"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vwU = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "发表模拟失败").b("FINDER_POST_FAILED_IN_STAGE", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2, 3})), kotlin.a.j.listOf((Object[]) new String[]{"关闭(0)", "裁剪失败", "上传失败", "cgi失败"}));
    private static final int vwV = 3;
    private static final int vwW = 800;
    private static int vwX = vxu;
    private static final int vwY = 45;
    private static final int vwZ = 45;
    private static final int vwu = 1024;
    private static final int vwv = 1048576;
    private static final float vww = vww;
    private static int vwx = 5;
    private static final com.tencent.mm.plugin.finder.storage.config.c vwy = new com.tencent.mm.plugin.finder.storage.config.c("显示视频编码配置", ay.vDc);
    private static final int vwz = 40;
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxA = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "实名点赞").d(b.a.clicfg_finder_real_name_like).b("REAL_NAME_LIKE_CONFIG", kotlin.a.j.listOf((Object[]) new Integer[]{1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"实名点赞", "非实名点赞"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxB = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "实名点赞头像").d(b.a.clicfg_finder_real_name_like_avatar_control).b("REAL_NAME_LIKE_AVATAR_RADIUS_CONTROL", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"圆头像", "方头像"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxC = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "评论全屏方案").d(b.a.clicfg_finder_comment_fullscreen).b("COMMENT_STYLE_CONFIG", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"全屏", "半屏"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxD = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "圈外分享模式(仅预览)").d(b.a.clicfg_finder_comment_fullscreen).b("USERINFO_FINDER_FORWARD_DEBUG_TYPE_INT", kotlin.a.j.listOf((Object[]) new Integer[]{-1, 1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"默认", "允许nickname", "过滤nickname"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxE = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "附近tab使用瀑布流/卡片流开关").d(b.a.clicfg_finder_lbs_stream_cgi).b("LBS_UI_CONFIG", kotlin.a.j.listOf((Object[]) new Integer[]{1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"瀑布流", "卡片流"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxF = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(20, "关注/点赞折叠超过x条后折叠").b("FOLLOW_LIKE_FOLD_MORE_THAN_X", kotlin.a.j.listOf((Object[]) new Integer[]{20, 3}), kotlin.a.j.listOf((Object[]) new String[]{"20", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL}));
    private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vxG = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "开启视频预加载预览View", "USERINFO_FINDER_PRELOAD_VIEW_BOOLEAN_SYNC");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxI = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "切换单Tab").d(b.a.clicfg_finder_more_tab_enable).b("FINDER_TAB_STYLE_CONFIG", kotlin.a.j.listOf((Object[]) new Integer[]{1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"切换多tab", "切换单tab"}));
    private static final com.tencent.mm.plugin.finder.storage.config.c vxJ = new com.tencent.mm.plugin.finder.storage.config.c("重置最后退出TL时间为0", av.vCZ);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxK = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(800, "评论字数限制10").avD("FinderCommentTextLimit").b("COMMENT_TEXT_LIMIT_CONFIG", kotlin.a.j.listOf((Object) 10), kotlin.a.j.listOf("评论字数限制10"));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxL = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1000, "Media字数限制15").avD("FinderMediaPublishTextLimit").b("MEDIA_TEXT_LIMIT_CONFIG", kotlin.a.j.listOf((Object) 15), kotlin.a.j.listOf("Media字数限制15"));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxM = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(800, "纯文本字数限制15").avD("FinderPureTextPublishTextLimit").b("PURE_TEXT_LIMIT_CONFIG", kotlin.a.j.listOf((Object) 20), kotlin.a.j.listOf("纯文本字数限制15"));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxN = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(3, "最大话题数改为3个").avD("FinderMaxTopicCount").b("MAX_TOPIC_CONFIG", kotlin.a.j.listOf((Object) 3), kotlin.a.j.listOf("最大话题数改为3个"));
    private static final com.tencent.mm.plugin.finder.storage.config.c vxO = new com.tencent.mm.plugin.finder.storage.config.c("假菊花Toast", u.vCy);
    private static final com.tencent.mm.plugin.finder.storage.config.c vxP = new com.tencent.mm.plugin.finder.storage.config.c("游戏sdk分享测试", aw.vDa);
    private static final com.tencent.mm.plugin.finder.storage.config.c vxQ = new com.tencent.mm.plugin.finder.storage.config.c("秒剪sdk分享测试", ax.vDb);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxR = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "发表跳转第三方app").b("SHARE_SDK_TEST3", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "秒剪测试"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxS = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "sdk分享特殊情况").b("SHARE_POST_DEBUG", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2, 3})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "无视频号浏览权限", "无视频号发表帐号权限", "发现页关闭了视频号"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxT = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "我-视频入口控制").b("ME_FINDER_ENTRY_DEBUG", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2, 3})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "青少年模式", "无视频号发表帐号权限", "命中安全打击/封禁"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxU = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "A-我-视频入口开关").d(b.a.clicfg_finder_me_finder_switch).b("ME_FINDER_ENTRY_SWITCH", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxV = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "B-profile设置展示视频号，是否影响我-视频号").d(b.a.clicfg_finder_setting_to_me_finder_switch).b("SETTING_TO_ME_FINDER_ENTRY_SWITCH", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"不影响", "影响"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxW = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "C-设置页出“展示我的视频号”开关").d(b.a.clicfg_finder_setting_finder_wxprofile_switch).b("FINDER_SETTING_WXPROFILE_SWITCH", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxX = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "D-创建帐号-默认使用微信昵称").d(b.a.clicfg_finder_create_wxname_switch).b("FINDER_CREATE_WXNAME_SWITCH", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxY = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(15, "话题最大长度改为10").avD("FinderTopicTextLimit").b("MAX_TOPIC_LENGTH_CONFIG", kotlin.a.j.listOf((Object) 10), kotlin.a.j.listOf("话题最大长度改为10"));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxZ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "话题推荐开关").avD("FinderSuggestTagViewShow").b("TOPIC_RECOMMEND_CONFIG", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final int vxa = 10;
    private static boolean vxb;
    private static boolean vxc;
    private static long vxd = -1;
    private static final long vxe = (((Environment.getExternalStorageDirectory().getFreeSpace() / 1024) / 1024) / 1024);
    private static final kotlin.f vxf = kotlin.g.ah(bb.vDf);
    private static final kotlin.f vxg = kotlin.g.ah(bc.vDg);
    private static final kotlin.f vxh = kotlin.g.ah(bd.vDh);
    public static final kotlin.f vxi = kotlin.g.ah(aq.vCU);
    private static final kotlin.f vxj = kotlin.g.ah(ap.vCT);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxk = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "视频号直播拉取评论时间间隔").d(b.a.clicfg_finder_live_get_comment_duration);
    private static int vxl = 1;
    private static boolean vxm;
    private static int vxn = 5;
    private static int vxo = 2;
    private static boolean vxp = true;
    private static int vxq;
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxr = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(vxu, "tab流自动刷新缓存时间").d(b.a.clicfg_finder_timeline_refresh_expired).b("AUTO_REEFRESH_CACHE_INTERVAL", kotlin.a.j.listOf((Object[]) new Integer[]{Integer.valueOf((int) vxu), 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000}), kotlin.a.j.listOf((Object[]) new String[]{"默认(5min)", "10s", "30s", "1min"}));
    private static final long vxs = vxs;
    private static final boolean vxt;
    private static final int vxu = vxu;
    private static final int vxv = 5000;
    private static final int vxw = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mp4_parse_for_finder, 0);
    private static boolean vxx = true;
    private static final kotlin.k.b<Double> vxy;
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vxz = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "二级评论是否展开").avD("FinderCommentAutoExpandSubcommentList").b("COMMENT_EXPAND_CONFIG", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"是", "否"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyA = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "个人中心用户状态").b("FINDER_SELF_STATE", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{1, 2, 3, 4, 5, 6, 7, -1})), new ArrayList(kotlin.a.j.listOf((Object[]) new String[]{"无发表资格", "有发表资格但未创建账号", "账号处于正常状态", "账号被封禁", "账号审核中", "账号被禁言", "全网禁言", "reset"})));
    private static final com.tencent.mm.plugin.finder.storage.config.c vyB = new com.tencent.mm.plugin.finder.storage.config.c("重置首次获得发表权限标志", at.vCX);
    private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vyC = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(true, "自动触发正例反馈");
    private static final com.tencent.mm.plugin.finder.storage.config.c vyD = new com.tencent.mm.plugin.finder.storage.config.c("清空通知lastBuffer", f.vCk);
    private static final com.tencent.mm.plugin.finder.storage.config.c vyE = new com.tencent.mm.plugin.finder.storage.config.c("清理New红点配置", g.vCl);
    private static final com.tencent.mm.plugin.finder.storage.config.c vyF = new com.tencent.mm.plugin.finder.storage.config.c("清理更多相似动态状态", i.vCn);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyG = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "打开评论抽屉是否调整feed位置").b("IS_ADJUST_FEED_WHEN_OPEN_DRAWER", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"默认模式(关闭)", "自动调整模式"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Long> vyH = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(100, "refresh假菊花时长").d(b.a.clicfg_finder_fake_preload_tab_refresh_time).b("TIMELINE_REFRESH_EXPIRED_TIME", new ArrayList(kotlin.a.j.listOf((Object[]) new Long[]{500L, 100L, 200L, 400L, 500L, 600L, 700L, 800L, 1000L, 3000L})), kotlin.a.j.listOf((Object[]) new String[]{"默认(500)", "100", "200", "400", "500", "600", "700", "800", "1000", "3000"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Long> vyI = new com.tencent.mm.plugin.finder.storage.config.item.longtype.a(1200000, "预加载debug轮询时长").d(b.a.clicfg_finder_check_preload_tab_refresh_time).b("PRELOAD_DURATION", new ArrayList(kotlin.a.j.listOf((Object[]) new Long[]{1200000L, 5000L, 10000L, Long.valueOf((long) Util.MILLSECONDS_OF_MINUTE)})), kotlin.a.j.listOf((Object[]) new String[]{"默认(20min)", "5s", "10s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.c vyJ = new com.tencent.mm.plugin.finder.storage.config.c("生效一次，收到红点会去掉（朋友/关注）发现页红点", C1282c.vCh);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyK = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "视频模板").b("USERINFO_FINDER_EDITOR_VIDEO_TEMPLATE_INT_SYNC", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关", "开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyL = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "点赞事件UI").b("TIMELINE_LIKE_EVENT_CONFIG", kotlin.a.j.listOf((Object[]) new Integer[]{1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"卡片模式", "m+n模式"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyM = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "FIDNER_RED_DOT_STYLE").b("FIDNER_RED_DOT_STYLE", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2, 3, 4, 5, 7, 6, -1}), kotlin.a.j.listOf((Object[]) new String[]{"4(ICON)+liked", "7(SQUARE_ICON)+liked", "11(ICON_WITH_RED_DOT)+liked", "12(SQUARE_ICON_WITH_RED_DOT)+liked", "liked+13(RIGHT_ICON_WITH_RED_DOT)", "liked+14(RIGHT_SQUARE_ICON_WITH_RED_DOT)", "4(ICON)", "7(SQUARE_ICON)", BuildConfig.KINDA_DEFAULT}));
    private static List<kotlin.o<Integer, String>> vyN = kotlin.a.j.listOf((Object[]) new kotlin.o[]{new kotlin.o(4, "liked"), new kotlin.o(7, "liked"), new kotlin.o(11, "liked"), new kotlin.o(12, "liked特别长的红点信息特别长的红点信息特别长的红点信息"), new kotlin.o(13, "liked特别长的红点信息特别长的红点信息特别长的红点信息"), new kotlin.o(14, "liked特别长的红点信息特别长的红点信息特别长的红点信息"), new kotlin.o(4, ""), new kotlin.o(7, ""), new kotlin.o(-1, "")});
    private static boolean vyO = true;
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyP = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "MARK_READ_OPEN").avD("FinderMarkReadOpenControl").b("FinderMarkReadOpenControl", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 0})), kotlin.a.j.listOf((Object[]) new String[]{"默认(1)", "打开入口(1)", "关闭入口(0)"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyQ = new t("是否打开私信入口").d(b.a.clicfg_finder_msg_entrance_enable).b("ENABLE_FINDER_MESSAGE", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"默认", "打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyR = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "截屏上报").d(b.a.clicfg_finder_android_report_when_screen_shot).b("FINDER_REPORT_WHEN_SCREEN_SHOT", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{1, 0})), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyS = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "是否在朋友tab制造个假跳转热门数据").b("FAKE_CARD_JUMP_HOT_TAB_DATA", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{1, 0})), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyT = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(BuildInfo.IS_FLAVOR_PURPLE ? 1 : 0, "加载图片渐现").b("LOAD_IMAGE_ANIM", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{1, 0})), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyU = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(800, "切换ViewPage速度").b("SWITC_VIEW_PAGE_TIME", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 200, 400, 600, 700, 800, 1000, 1200, 1500})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "200", "400", "600", "700", "800", "1000", "1200", "1500"}));
    private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vyV = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "是否在作者视角动态展示假数据");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyW = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "私密帐号").d(b.a.clicfg_finder_android_private_account_switch).b("PRIVATE_ACCOUNT_ENABLE_DEBUG", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{1, 0})), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static com.tencent.mm.plugin.finder.storage.config.c vyX = new com.tencent.mm.plugin.finder.storage.config.c("重置私密feed点赞提示次数", p.vCu);
    private static com.tencent.mm.plugin.finder.storage.config.b<Integer> vyY = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "支持匿名赞").d(b.a.clicfg_finder_self_private_like_enable).b("USERINFO_SELF_PRIVATE_LIKE_INT_SYNC", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 0})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "支持", "不支持"}));
    private static final com.tencent.mm.plugin.finder.storage.config.c vyZ = new com.tencent.mm.plugin.finder.storage.config.c("重置私密feed点赞和匿名赞提示次数", au.vCY);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vya = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "打开切换身份评论").d(b.a.clicfg_finder_can_switch_scene).b("CAN_SWITCH_SCENE", kotlin.a.j.listOf((Object) 1), kotlin.a.j.listOf("打开"));
    private static com.tencent.mm.plugin.finder.storage.config.c vyb = new com.tencent.mm.plugin.finder.storage.config.c("重置切换身份提示", q.vCv);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyc = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1000, "最大at数改为3个").avD("FinderMaxMentionSbCount").b("MAX_AT_COUNT_CONFIG", kotlin.a.j.listOf((Object) 3), kotlin.a.j.listOf("最大at数改为3个"));
    private static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vyd = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "发表feed/评论点赞固定失败");
    private static com.tencent.mm.plugin.finder.storage.config.c vye = new com.tencent.mm.plugin.finder.storage.config.c("评论点赞重试间隔改为1s", r.vCw);
    private static com.tencent.mm.plugin.finder.storage.config.c vyf = new com.tencent.mm.plugin.finder.storage.config.c("清除keybuf/账号数据", e.vCj);
    private static com.tencent.mm.plugin.finder.storage.config.c vyg = new com.tencent.mm.plugin.finder.storage.config.c("清除图片视频所有缓存", h.vCm);
    private static com.tencent.mm.plugin.finder.storage.config.c vyh = new com.tencent.mm.plugin.finder.storage.config.c("清空keybuf", d.vCi);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyi = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(80, "RecyclerView滑动速度").b("RECYCLERVIEW_SPEED", kotlin.a.j.listOf((Object[]) new Integer[]{80, 50, 60, 70, 80, 90, 100, 130}), kotlin.a.j.listOf((Object[]) new String[]{"默认(0.8)", "0.5倍", "0.6倍", "0.7倍", "0.8倍", "0.9倍", "1倍", "1.3倍"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyj = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(300, "loadmore假菊花时长").avD("FinderFakeLoadingDurationMS").b("TIMELINE_LOADING_EXPIRED_TIME", kotlin.a.j.listOf((Object[]) new Integer[]{100, 200, 400, 500, 600, 700, 800, 1000, 3000}), kotlin.a.j.listOf((Object[]) new String[]{"100", "200", "400", "500", "600", "700", "800", "1000", "3000"}));
    private static com.tencent.mm.plugin.finder.storage.config.c vyk = new com.tencent.mm.plugin.finder.storage.config.c("把自己改成非白名单用户", a.vCc);
    private static com.tencent.mm.plugin.finder.storage.config.c vyl = new com.tencent.mm.plugin.finder.storage.config.c("把所有feed改为仅自己可见", v.vCz);
    private static com.tencent.mm.plugin.finder.storage.config.c vym = new com.tencent.mm.plugin.finder.storage.config.c("双击与展开教育/收藏红点重置", s.vCx);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyn = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "红点不受配置时间限制").b("USERINFO_FINDER_TEST_RED_DOT_FACTOR_INT_SYNC", kotlin.a.j.listOf((Object[]) new Integer[]{1, 1000000000}), kotlin.a.j.listOf((Object[]) new String[]{"默认", "无限制"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyo = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "后台合成").b("USERINFO_FINDER_VIDEO_REMUX_BACKGROUND_INT_SYNC", kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"X实验配置", "否", "是"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyp = new com.tencent.mm.plugin.finder.storage.config.item.integer.a((BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG) ? 1 : 0, "特效").b("USERINFO_FINDER_EDITOR_MAGIC_INT_SYNC", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关", "开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vyq = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "允许3:4视频比例").b("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"默认", "开", "关"}));
    private static com.tencent.mm.plugin.finder.storage.config.c vyr = new com.tencent.mm.plugin.finder.storage.config.c("发表相机红点重置", as.vCW);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vys = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "只看某个feed").b("USERINFO_FINDER_CARE_FEED_TYPE_INT", kotlin.a.j.listOf((Object[]) new Integer[]{-1, 2, 4, 8}), kotlin.a.j.listOf((Object[]) new String[]{"DEFAULT", "FINDER_FEED_PHOTO", "FINDER_FEED_VIDEO", "FINDER_FEED_MIX_MEDIA"}));
    private static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vyt = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "进入视频号Crash");
    private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vyu = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "输出视频号DEBUG日志", "USERINFO_FINDER_DEBUG_LOG_BOOLEAN_SYNC");
    private static final com.tencent.mm.plugin.finder.storage.config.c vyv = new com.tencent.mm.plugin.finder.storage.config.c("清理首页文件缓存", y.vCC);
    private static final com.tencent.mm.plugin.finder.storage.config.c vyw = new com.tencent.mm.plugin.finder.storage.config.c("清理发表队列", z.vCD);
    private static final com.tencent.mm.plugin.finder.storage.config.c vyx = new com.tencent.mm.plugin.finder.storage.config.c("查看Finder缓存大小", b.vCd);
    private static final com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vyy = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "资源清理调试模式");
    private static final com.tencent.mm.plugin.finder.storage.config.c vyz = new com.tencent.mm.plugin.finder.storage.config.c("复制finder配置到剪贴板", j.vCo);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzA = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_n_r_p_i_interval").b("nearby_no_reddot_prefetch_inner_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzB = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "tab_inner_hot_prefetch_switch").b("tab_inner_hot_prefetch_switch", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 1, 0})), kotlin.a.j.listOf((Object[]) new String[]{"默认", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE, "false"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzC = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "是否本地调整点赞头像顺序").d(b.a.clicfg_adjust_avatar_order_like).b("ADJUST_AVATAR_ORDER_LIKE", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1})), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzD = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "引导用户点赞自己的视频").d(b.a.clicfg_finder_self_like_edu).b("DEBUG_SELF_LIKE_EDU", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1})), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "支持"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzE = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "引导用户点赞后评论").d(b.a.clicfg_finder_like_comment_edu).b("DEBUG_SELF_LIKE_EDU", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1})), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "支持"}));
    private static final com.tencent.mm.plugin.finder.storage.config.c vzF = new com.tencent.mm.plugin.finder.storage.config.c("重置profile展示微信资料页提示", ba.vDe);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzG = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "专栏布局样式大小").b("STREAM_CARD_LAYOUT", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2})), kotlin.a.j.listOf((Object[]) new String[]{"不支持", "大大大 ", " 小小小 "}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzH = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "feed播放一段时间后，出评论输入框").d(b.a.clicfg_finder_feed_show_comment_auto).b("FEED_COMMENT_EDU", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1})), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzI = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "原创帐号开关").b("ORIGIN_ACCOUNT_ENABLE", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.c vzJ = new com.tencent.mm.plugin.finder.storage.config.c("原创帐号发表提示和红点重置", ar.vCV);
    private static final com.tencent.mm.plugin.finder.storage.config.c vzK = new com.tencent.mm.plugin.finder.storage.config.c("直播发起红点重置", ao.vCS);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzL = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "朋友的外显评论是否显示头像").d(b.a.clicfg_finder_friend_comment_show_header).b("DEBUG_SELF_LIKE_EDU", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1})), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzM = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "强制所有feed都为新闻类").b("FEED_ALL_FORCE_NEWS", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzN = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(10, "首次打开热门预加载请求随机数").d(b.a.clicfg_finder_first_hot_tab_preload_random).b("FIRST_HOT_TAB_PRELOAD_RANDOM", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 2, 5, 10})), kotlin.a.j.listOf((Object[]) new String[]{"重置first", "关闭", "50%", "20%", "10%"})).H(am.vCQ);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzO = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "3天2天总开关").d(b.a.clicfg_finder_3_day_2_day_enable).b("THREE_DAY_TWO_DAY_ENABLE", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1})), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzP = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(259200000, "3天超时阈值").d(b.a.clicfg_finder_3_day_threshold).b("THREE_DAY_THRESHOLD", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{259200000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 180000})), kotlin.a.j.listOf((Object[]) new String[]{"3天", "30 秒", "3 分钟"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzQ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(172800000, "2天不出阈值").d(b.a.clicfg_finder_2_day_threshold).b("TWO_DAY_THRESHOLD", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{172800000, Integer.valueOf((int) com.tencent.mm.hardcoder.g.sHCENCODEVIDEOTIMEOUT), 120000})), kotlin.a.j.listOf((Object[]) new String[]{"2天", "20 秒", "2 分钟"})).d(b.a.clicfg_finder_like_comment_edu).b("DEBUG_SELF_LIKE_EDU", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1})), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "支持"}));
    private static com.tencent.mm.plugin.finder.storage.config.c vzR = new com.tencent.mm.plugin.finder.storage.config.c("重置直播勾选协议", n.vCs);
    private static com.tencent.mm.plugin.finder.storage.config.c vzS = new com.tencent.mm.plugin.finder.storage.config.c("重置实名认证缓存", o.vCt);
    private static com.tencent.mm.plugin.finder.storage.config.b<Integer> vzT = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播推荐列表是否允许重复").b("debugFinderLiveListRepeat", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"允许", "不允许"}));
    private static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a vzU = new com.tencent.mm.plugin.finder.storage.config.item.booleantype.a(false, "打开美颜实时调节器", "FINDER_LIVE_BEAUTY_DEBUG");
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzV = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "视频号发布直播").d(b.a.clicfg_finder_live_switch).b("debugFinderLive", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzW = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "视频号直播购物").d(b.a.clicfg_finder_live_shopping_switch).b("debugFinderLiveShoppingEnable", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"打开", "关闭"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzX = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "直播第三方购物").d(b.a.clicfg_finder_live_shopping_middle_page_switch).b("debugFinderLiveThreadPartyShoppingStrategy", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"中间页（实验状态）", "详情页（非实验状态）"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzY = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(3, "直播购物讲解气泡位置刷新频率").d(b.a.clicfg_finder_live_shopping_refresh_frequency);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzZ = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "购物小程序版本").b("FINDER_LIVE_USING_DEBUG_MINIPRO", kotlin.a.j.listOf((Object[]) new Integer[]{1, 0}), kotlin.a.j.listOf((Object[]) new String[]{"正式版", "测试版"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vza = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "收藏动画开关").b("IS_SHOW_FAV_ANIM_UNLIMITED", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1}), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzb = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(1, "视频质量分上报").d(b.a.clicfg_finder_report_quality_info).b("REPORT_QUALITY_INFO", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1})), kotlin.a.j.listOf((Object[]) new String[]{"关闭", "打开"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzc = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "选择 FeedHeadBar 样式").d(b.a.clicfg_finder_android_feed_header_style).b("SWITCH_FEED_TITLE_STYLE", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 0, 2})), kotlin.a.j.listOf((Object[]) new String[]{"默认(0)", "沉浸式(1)", "非沉浸式(0)", "4:3 沉浸式(2)"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzd = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "发表支持4:3").d(b.a.clicfg_finder_video_3_4_ratio_enable).b("USERINFO_FINDER_VIDEO_RATIO_3_4_INT_SYNC", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 0})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "支持", "不支持"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vze = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "TL导航栏icon样式").b("POST_ENTRANCE_OUTSIDE_ENABLE", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2, 3})), kotlin.a.j.listOf((Object[]) new String[]{"[A]默认", "[B]发表右上角+热门加附近", "[C]搜索右上角+热门加附近", "[D]热门加附近"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzf = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "切换朋友圈跳视频号入口类型", az.vDd).b("SNS_TO_FINDER_SWITCH", kotlin.a.j.listOf((Object[]) new Integer[]{0, 1, 2}), kotlin.a.j.listOf((Object[]) new String[]{"默认", "跳转方式1", "跳转方式2"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzg = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "发表上传block").b("DEBUG_POST_UPLOAD_BLOCK", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 20})), kotlin.a.j.listOf((Object[]) new String[]{"不block", "block 20秒"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzh = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "红点数据库插入数据count", l.vCq).b("DEBUG_FINDER_INSERT_RED_DOT_DB", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{30, 100, 500, 1000, 5000})), kotlin.a.j.listOf((Object[]) new String[]{PayuSecureEncrypt.ENCRYPT_VERSION_HASH, "100", "500", "1000", "5000"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<String> vzi = new com.tencent.mm.plugin.finder.storage.config.c("清除全屏tab红点标记", k.vCp).avE("T5");
    private static final com.tencent.mm.plugin.finder.storage.config.c vzj = new com.tencent.mm.plugin.finder.storage.config.c("红点数据库插入数据标记位", m.vCr);
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzk = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(0, "收藏出相似流").b("DEBUG_FAV_SIMILAR", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{0, 1})), kotlin.a.j.listOf((Object[]) new String[]{"使用后台配置", "支持"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzl = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_r_p_o_interval").b("follow_reddot_prefetch_outter_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzm = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_r_p_o_interval").b("friend_reddot_prefetch_outter_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzn = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_r_p_o_interval").b("hot_reddot_prefetch_outter_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzo = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_r_p_o_interval").b("nearby_reddot_prefetch_outter_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzp = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_n_r_p_o_interval").b("follow_no_reddot_prefetch_outter_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzq = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_n_r_p_o_interval").b("friend_no_reddot_prefetch_outter_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzr = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_n_r_p_o_interval").b("hot_no_reddot_prefetch_outter_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzs = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_n_r_p_o_interval").b("nearby_no_reddot_prefetch_outter_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzt = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_r_p_i_interval").b("follow_reddot_prefetch_inner_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzu = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_r_p_i_interval").b("friend_reddot_prefetch_inner_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzv = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_r_p_i_interval").b("hot_reddot_prefetch_inner_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzw = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "nearby_r_p_i_interval").b("nearby_reddot_prefetch_inner_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzx = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "follow_n_r_p_i_interval").b("follow_no_reddot_prefetch_inner_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzy = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "friend_n_r_p_i_interval").b("friend_no_reddot_prefetch_inner_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));
    private static final com.tencent.mm.plugin.finder.storage.config.b<Integer> vzz = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "hot_n_r_p_i_interval").b("hot_no_reddot_prefetch_inner_interval", new ArrayList(kotlin.a.j.listOf((Object[]) new Integer[]{-1, 0, 10000, 10000, Integer.valueOf((int) CommonUtils.MAX_TIMEOUT_MS), 60000})), kotlin.a.j.listOf((Object[]) new String[]{"默认", "0s", "10s", "20s", "30s", "1min"}));

    public static boolean drB() {
        AppMethodBeat.i(251643);
        boolean booleanValue = ((Boolean) vxf.getValue()).booleanValue();
        AppMethodBeat.o(251643);
        return booleanValue;
    }

    public static int drG() {
        AppMethodBeat.i(166942);
        int intValue = ((Number) vxj.getValue()).intValue();
        AppMethodBeat.o(166942);
        return intValue;
    }

    static final class aa extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final aa vCE = new aa();

        static {
            AppMethodBeat.i(251577);
            AppMethodBeat.o(251577);
        }

        aa() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251576);
            Activity activity2 = activity;
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_FEED_GROUP_LIKE_GUIDE_INT, (Object) 0);
            if (activity2 != null) {
                com.tencent.mm.ui.base.u.makeText(activity2, "已清除，可重新测试", 0).show();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251576);
            return xVar;
        }
    }

    static final class ab extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final ab vCF = new ab();

        static {
            AppMethodBeat.i(251579);
            AppMethodBeat.o(251579);
        }

        ab() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251578);
            Activity activity2 = activity;
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_FULL_FEED_GUIDE_BOOLEAN, Boolean.FALSE);
            if (activity2 != null) {
                com.tencent.mm.ui.base.u.makeText(activity2, "已清除，可重新测试", 0).show();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251578);
            return xVar;
        }
    }

    static final class ac extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final ac vCG = new ac();

        static {
            AppMethodBeat.i(251581);
            AppMethodBeat.o(251581);
        }

        ac() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251580);
            Activity activity2 = activity;
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_FULL_LIKE_FEED_GUIDE_INT, (Object) 0);
            if (activity2 != null) {
                com.tencent.mm.ui.base.u.makeText(activity2, "已清除，可重新测试", 0).show();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251580);
            return xVar;
        }
    }

    static final class ad extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final ad vCH = new ad();

        static {
            AppMethodBeat.i(251583);
            AppMethodBeat.o(251583);
        }

        ad() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251582);
            Activity activity2 = activity;
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_HAS_SHOW_LIVE_GUIDE_BOOLEAN_SYNC, Boolean.FALSE);
            if (activity2 != null) {
                com.tencent.mm.ui.base.u.makeText(activity2, "已清除，可重新测试", 0).show();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251582);
            return xVar;
        }
    }

    static final class ae extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final ae vCI = new ae();

        static {
            AppMethodBeat.i(251585);
            AppMethodBeat.o(251585);
        }

        ae() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251584);
            Activity activity2 = activity;
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FIRST_SHOW_NEARBY_REDDOT_BOOLEAN_SYNC, Boolean.TRUE);
            if (activity2 != null) {
                com.tencent.mm.ui.base.u.makeText(activity2, "已清除，可重新测试", 0).show();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251584);
            return xVar;
        }
    }

    static final class af extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final af vCJ = new af();

        static {
            AppMethodBeat.i(251587);
            AppMethodBeat.o(251587);
        }

        af() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251586);
            Activity activity2 = activity;
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FIRST_SHOW_NEARBY_LIVE_SQUARE_SCROLL_GUIDE_BOOLEAN_SYNC, Boolean.TRUE);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).resetCache();
            if (activity2 != null) {
                com.tencent.mm.ui.base.u.makeText(activity2, "已清除，可重新测试", 0).show();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251586);
            return xVar;
        }
    }

    static final class al extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final al vCP = new al();

        static {
            AppMethodBeat.i(251599);
            AppMethodBeat.o(251599);
        }

        al() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251598);
            Activity activity2 = activity;
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_SHOW_SELF_FEED_LIKE_TIPS_TIMES_INT, (Object) 0);
            if (activity2 != null) {
                com.tencent.mm.ui.base.u.makeText(activity2, "已清除，可重新测试", 0).show();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251598);
            return xVar;
        }
    }

    static final class am extends kotlin.g.b.q implements kotlin.g.a.b<Integer, kotlin.x> {
        public static final am vCQ = new am();

        static {
            AppMethodBeat.i(251601);
            AppMethodBeat.o(251601);
        }

        am() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Integer num) {
            AppMethodBeat.i(251600);
            if (num.intValue() == 0) {
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_MY_FINDER_FIRST_HOT_TAB_PRELOAD_INT_SYNC, (Object) 0);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251600);
            return xVar;
        }
    }

    static final class an extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final an vCR = new an();

        static {
            AppMethodBeat.i(251603);
            AppMethodBeat.o(251603);
        }

        an() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251602);
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(NativeProtocol.WEB_DIALOG_ACTION, "autoOpenFinderLive");
            jSONObject2.put("finderUserName", "v2_060000231003b20faec8c4e18818c3d1cb04eb33b077ae835e04464cdde50c6c0af16e7d9204@finder");
            jSONObject2.put("commentScene", 9);
            jSONObject.put(IssueStorage.COLUMN_EXT_INFO, jSONObject2);
            ((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderUI(activity, jSONObject.toString());
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251602);
            return xVar;
        }
    }

    static final class aq extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final aq vCU = new aq();

        static {
            AppMethodBeat.i(251607);
            AppMethodBeat.o(251607);
        }

        aq() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(251606);
            AppMethodBeat.o(251606);
            return 5;
        }
    }

    static final class ay extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final ay vDc = new ay();

        static {
            AppMethodBeat.i(251623);
            AppMethodBeat.o(251623);
        }

        ay() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251622);
            Activity activity2 = activity;
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder("短视频录制:");
            c cVar = c.vCb;
            StringBuilder append = sb.append(sb2.append(c.dqw()).append("\n-----------------\n").toString());
            StringBuilder sb3 = new StringBuilder("短视频相册:");
            c cVar2 = c.vCb;
            StringBuilder append2 = append.append(sb3.append(c.dqx()).append("\n-----------------\n").toString());
            StringBuilder sb4 = new StringBuilder("长视频:");
            c cVar3 = c.vCb;
            append2.append(sb4.append(c.dqy()).toString());
            if (activity2 != null) {
                FinderDebugUIC.a aVar = FinderDebugUIC.wvw;
                String sb5 = sb.toString();
                kotlin.g.b.p.g(sb5, "sb.toString()");
                FinderDebugUIC.a.aG(activity2, sb5);
            } else {
                com.tencent.mm.ui.base.u.makeText(MMApplicationContext.getContext(), sb.toString(), 1).show();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251622);
            return xVar;
        }
    }

    static final class az extends kotlin.g.b.q implements kotlin.g.a.m<Integer, Context, kotlin.x> {
        public static final az vDd = new az();

        static {
            AppMethodBeat.i(251625);
            AppMethodBeat.o(251625);
        }

        az() {
            super(2);
        }

        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(Integer num, Context context) {
            AppMethodBeat.i(251624);
            com.tencent.mm.platformtools.ac.jPK = num.intValue();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251624);
            return xVar;
        }
    }

    static final class b extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final b vCd = new b();

        static {
            AppMethodBeat.i(251528);
            AppMethodBeat.o(251528);
        }

        b() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251527);
            final Activity activity2 = activity;
            com.tencent.f.h.RTc.aX(new Runnable() {
                /* class com.tencent.mm.plugin.finder.storage.c.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(251526);
                    com.tencent.mm.plugin.finder.utils.al alVar = com.tencent.mm.plugin.finder.utils.al.waC;
                    com.tencent.mm.ac.c cVar = new com.tencent.mm.ac.c("dumpCacheDir");
                    String str = "";
                    com.tencent.mm.plugin.finder.utils.i[] iVarArr = com.tencent.mm.plugin.finder.utils.al.waB;
                    for (int i2 = 0; i2 < iVarArr.length; i2++) {
                        str = str + ((String) iVarArr[i2].dBF().first) + "\n";
                    }
                    StringBuilder append = new StringBuilder().append(com.tencent.mm.plugin.finder.utils.al.dEx()).append(": \n ").append(str).append("  ");
                    cVar.aBw();
                    final String sb = append.append(kotlin.x.SXb).toString();
                    com.tencent.mm.ac.d.h(new kotlin.g.a.a<kotlin.x>(this) {
                        /* class com.tencent.mm.plugin.finder.storage.c.b.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 vCf;

                        {
                            this.vCf = r2;
                        }

                        @Override // kotlin.g.a.a
                        public final /* synthetic */ kotlin.x invoke() {
                            AppMethodBeat.i(251525);
                            Activity activity = activity2;
                            if (activity == null) {
                                kotlin.g.b.p.hyc();
                            }
                            com.tencent.mm.ui.base.h.X(activity, sb, "嗯");
                            kotlin.x xVar = kotlin.x.SXb;
                            AppMethodBeat.o(251525);
                            return xVar;
                        }
                    });
                    AppMethodBeat.o(251526);
                }
            });
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251527);
            return xVar;
        }
    }

    static final class l extends kotlin.g.b.q implements kotlin.g.a.m<Integer, Context, kotlin.x> {
        public static final l vCq = new l();

        static {
            AppMethodBeat.i(251548);
            AppMethodBeat.o(251548);
        }

        l() {
            super(2);
        }

        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(Integer num, Context context) {
            AppMethodBeat.i(251547);
            int intValue = num.intValue();
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            com.tencent.mm.plugin.finder.extension.reddot.c cVar = ((PluginFinder) ah).getRedDotManager().tJN;
            Log.i("Finder.RedDotCtrInfoStorage", "insertData :".concat(String.valueOf(intValue)));
            for (int i2 = 0; i2 < intValue; i2++) {
                if (i2 % 2 == 0) {
                    long aWA = cl.aWA();
                    FinderTipsShowEntranceExtInfo finderTipsShowEntranceExtInfo = new FinderTipsShowEntranceExtInfo();
                    bbi bbi = new bbi();
                    bbi.LKM = String.valueOf(cl.aWA());
                    bbi.priority = 100000;
                    bbi.type = -1;
                    bdo bdo = new bdo();
                    bdo.xGz = 1;
                    bdo.LNm = 1;
                    bdo.path = "FinderEntrance";
                    bbi.GaM.add(bdo);
                    bdo bdo2 = new bdo();
                    bdo2.xGz = 1;
                    bdo2.LNm = 1;
                    bdo2.path = "TLPersonalCenter";
                    bdo2.Bvg = "FinderEntrance";
                    bbi.GaM.add(bdo2);
                    bdo bdo3 = new bdo();
                    bdo3.xGz = 1;
                    bdo3.LNm = 1;
                    bdo3.path = "TLCamera";
                    bdo3.Bvg = "TLPersonalCenter";
                    bbi.GaM.add(bdo3);
                    com.tencent.mm.plugin.finder.extension.reddot.k f2 = new com.tencent.mm.plugin.finder.extension.reddot.k().f(bbi);
                    f2.field_time = aWA;
                    f2.field_tipsShowEntranceExtInfo = finderTipsShowEntranceExtInfo;
                    com.tencent.mm.plugin.finder.extension.reddot.k.a(f2, cVar);
                } else {
                    long aWA2 = cl.aWA();
                    FinderTipsShowEntranceExtInfo finderTipsShowEntranceExtInfo2 = new FinderTipsShowEntranceExtInfo();
                    bbi bbi2 = new bbi();
                    bbi2.LKM = String.valueOf(cl.aWA());
                    bbi2.priority = 100000;
                    bbi2.type = 2;
                    bdo bdo4 = new bdo();
                    bdo4.xGz = 2;
                    bdo4.LNm = 1;
                    bdo4.path = "AuthorProfileNotify";
                    bdo4.count = 17;
                    bbi2.GaM.add(bdo4);
                    bdo bdo5 = new bdo();
                    bdo5.xGz = 2;
                    bdo5.LNm = 1;
                    bdo5.path = "NotificitionCenterNotify";
                    bdo5.count = 5;
                    bbi2.GaM.add(bdo5);
                    com.tencent.mm.plugin.finder.extension.reddot.k f3 = new com.tencent.mm.plugin.finder.extension.reddot.k().f(bbi2);
                    f3.field_time = aWA2;
                    f3.field_tipsShowEntranceExtInfo = finderTipsShowEntranceExtInfo2;
                    com.tencent.mm.plugin.finder.extension.reddot.k.a(f3, cVar);
                }
            }
            com.tencent.mm.ui.base.u uVar = new com.tencent.mm.ui.base.u(MMApplicationContext.getContext());
            uVar.setText(R.string.da9);
            uVar.gLj();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251547);
            return xVar;
        }
    }

    static final class w extends kotlin.g.b.q implements kotlin.g.a.m<Integer, Context, kotlin.x> {
        public static final w vCA = new w();

        static {
            AppMethodBeat.i(251569);
            AppMethodBeat.o(251569);
        }

        w() {
            super(2);
        }

        @Override // kotlin.g.a.m
        public final /* synthetic */ kotlin.x invoke(Integer num, Context context) {
            AppMethodBeat.i(251568);
            num.intValue();
            Context context2 = context;
            if (context2 != null) {
                com.tencent.mm.ui.base.u.makeText(context2, "重启微信后生效", 0).show();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251568);
            return xVar;
        }
    }

    static final class x extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final x vCB = new x();

        static {
            AppMethodBeat.i(251571);
            AppMethodBeat.o(251571);
        }

        x() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251570);
            Activity activity2 = activity;
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_FEED_BULLET_SUBTITLE_EXPT_HAS_SET_BOOLEAN_SYNC, Boolean.FALSE);
            if (activity2 != null) {
                com.tencent.mm.ui.base.u.makeText(activity2, "已清除，可重新测试", 0).show();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251570);
            return xVar;
        }
    }

    static {
        kotlin.k.b<Double> M;
        AppMethodBeat.i(166903);
        com.tencent.mm.plugin.vlog.ui.plugin.f fVar = com.tencent.mm.plugin.vlog.ui.plugin.f.GHk;
        if (com.tencent.mm.plugin.vlog.ui.plugin.f.fDl()) {
            M = kotlin.k.j.M(0.75d);
        } else {
            M = kotlin.k.j.M(0.8571428571428571d);
        }
        vxy = M;
        com.tencent.mm.plugin.finder.storage.config.item.integer.a aVar = new com.tencent.mm.plugin.finder.storage.config.item.integer.a(-1, "视频号直播观众模式");
        e.a aVar2 = e.a.hxc;
        e.a aVar3 = e.a.hxc;
        vAY = aVar.b("FINDER_LIVE_VISITOR_MODE", kotlin.a.j.listOf((Object[]) new Integer[]{-1, Integer.valueOf(e.a.aCe()), Integer.valueOf(e.a.aCf())}), kotlin.a.j.listOf((Object[]) new String[]{"跟随后台", "TRTC", "CDN"})).d(b.a.clicfg_finder_live_visitor_mode);
        AppMethodBeat.o(166903);
    }

    private c() {
    }

    public static final /* synthetic */ boolean dxl() {
        AppMethodBeat.i(251697);
        boolean drA = drA();
        AppMethodBeat.o(251697);
        return drA;
    }

    public static final /* synthetic */ boolean[] dxm() {
        AppMethodBeat.i(166955);
        boolean[] drC = drC();
        AppMethodBeat.o(166955);
        return drC;
    }

    public static int dqs() {
        return vwv;
    }

    public static float dqt() {
        return vww;
    }

    public static int dqu() {
        return vwx;
    }

    public static void dqv() {
        vwx = 1;
    }

    public static VideoTransPara dqw() {
        AppMethodBeat.i(166904);
        com.tencent.mm.plugin.vlog.model.m mVar = com.tencent.mm.plugin.vlog.model.m.Gyi;
        if (com.tencent.mm.plugin.vlog.model.m.fAU()) {
            com.tencent.mm.plugin.vlog.model.m mVar2 = com.tencent.mm.plugin.vlog.model.m.Gyi;
            VideoTransPara fAV = com.tencent.mm.plugin.vlog.model.m.fAV();
            if (fAV == null) {
                com.tencent.mm.modelcontrol.e baZ = com.tencent.mm.modelcontrol.e.baZ();
                kotlin.g.b.p.g(baZ, "SubCoreVideoControl.getCore()");
                fAV = baZ.bbe();
                kotlin.g.b.p.g(fAV, "SubCoreVideoControl.getC…e().finderRecordVideoPara");
            }
            AppMethodBeat.o(166904);
            return fAV;
        }
        com.tencent.mm.modelcontrol.e baZ2 = com.tencent.mm.modelcontrol.e.baZ();
        kotlin.g.b.p.g(baZ2, "SubCoreVideoControl.getCore()");
        VideoTransPara bbe = baZ2.bbe();
        kotlin.g.b.p.g(bbe, "SubCoreVideoControl.getC…e().finderRecordVideoPara");
        AppMethodBeat.o(166904);
        return bbe;
    }

    public static VideoTransPara dqx() {
        AppMethodBeat.i(166905);
        com.tencent.mm.plugin.vlog.model.m mVar = com.tencent.mm.plugin.vlog.model.m.Gyi;
        if (com.tencent.mm.plugin.vlog.model.m.fAU()) {
            com.tencent.mm.plugin.vlog.model.m mVar2 = com.tencent.mm.plugin.vlog.model.m.Gyi;
            VideoTransPara fAV = com.tencent.mm.plugin.vlog.model.m.fAV();
            if (fAV == null) {
                com.tencent.mm.modelcontrol.e baZ = com.tencent.mm.modelcontrol.e.baZ();
                kotlin.g.b.p.g(baZ, "SubCoreVideoControl.getCore()");
                fAV = baZ.bbf();
                kotlin.g.b.p.g(fAV, "SubCoreVideoControl.getCore().finderAlbumVideoPara");
            }
            AppMethodBeat.o(166905);
            return fAV;
        }
        com.tencent.mm.modelcontrol.e baZ2 = com.tencent.mm.modelcontrol.e.baZ();
        kotlin.g.b.p.g(baZ2, "SubCoreVideoControl.getCore()");
        VideoTransPara bbf = baZ2.bbf();
        kotlin.g.b.p.g(bbf, "SubCoreVideoControl.getCore().finderAlbumVideoPara");
        AppMethodBeat.o(166905);
        return bbf;
    }

    public static VideoTransPara dqy() {
        AppMethodBeat.i(251630);
        com.tencent.mm.modelcontrol.e baZ = com.tencent.mm.modelcontrol.e.baZ();
        kotlin.g.b.p.g(baZ, "SubCoreVideoControl.getCore()");
        VideoTransPara bbg = baZ.bbg();
        kotlin.g.b.p.g(bbg, "SubCoreVideoControl.getC….finderAlbumLongVideoPara");
        AppMethodBeat.o(251630);
        return bbg;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dqz() {
        return vwy;
    }

    public static int dqA() {
        AppMethodBeat.i(166906);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_album_video_max_select_duration_android, 300);
        AppMethodBeat.o(166906);
        return a2;
    }

    public static boolean dqB() {
        AppMethodBeat.i(166907);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_finder_remux_use_adaparams, 1) == 1) {
            AppMethodBeat.o(166907);
            return true;
        }
        AppMethodBeat.o(166907);
        return false;
    }

    public static int dqC() {
        return vwz;
    }

    public static boolean dqD() {
        AppMethodBeat.i(251631);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_jsapi, 1) == 1) {
            AppMethodBeat.o(251631);
            return true;
        }
        AppMethodBeat.o(251631);
        return false;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dqE() {
        return vwA;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dqF() {
        return vwB;
    }

    public static boolean dqG() {
        AppMethodBeat.i(251632);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_reproduction, 0) == 1) {
            AppMethodBeat.o(251632);
            return true;
        }
        AppMethodBeat.o(251632);
        return false;
    }

    public static boolean dqH() {
        AppMethodBeat.i(251633);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_finder_create_guide_entry_enable, 0) == 1) {
            AppMethodBeat.o(251633);
            return true;
        }
        AppMethodBeat.o(251633);
        return false;
    }

    public static long dqI() {
        AppMethodBeat.i(251634);
        long a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_video_max_size, 28 * ((long) vwv));
        AppMethodBeat.o(251634);
        return a2;
    }

    public static long dqJ() {
        AppMethodBeat.i(251635);
        long a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_long_video_max_size, 450 * ((long) vwv));
        AppMethodBeat.o(251635);
        return a2;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Long> dqK() {
        return vwF;
    }

    public static long dqL() {
        AppMethodBeat.i(251636);
        if (vwF.value().longValue() <= vxe || (!BuildInfo.DEBUG && !BuildInfo.IS_FLAVOR_PURPLE && !BuildInfo.IS_FLAVOR_RED)) {
            long a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_long_video_max_size_buffer, 100 * ((long) vwv)) + dqJ();
            AppMethodBeat.o(251636);
            return a2;
        }
        long longValue = vwF.value().longValue();
        AppMethodBeat.o(251636);
        return longValue;
    }

    public static int dqM() {
        AppMethodBeat.i(251637);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_big_file_length, vwv * 28);
        AppMethodBeat.o(251637);
        return a2;
    }

    public static int dqN() {
        return vwH;
    }

    public static int dqO() {
        boolean z2;
        AppMethodBeat.i(166908);
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        kotlin.g.b.p.g(af2, "MMKernel.service<IConfig…onfigService::class.java)");
        String value = ((com.tencent.mm.plugin.zero.b.a) af2).aqJ().getValue("FinderFeedCompressResolution");
        String str = value;
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            AppMethodBeat.o(166908);
            return TAVExporter.VIDEO_EXPORT_HEIGHT;
        } else if (value == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(166908);
            throw tVar;
        } else {
            int safeParseInt = Util.safeParseInt(kotlin.n.n.a(kotlin.n.n.trim(value).toString(), new String[]{"*"}).get(1));
            AppMethodBeat.o(166908);
            return safeParseInt;
        }
    }

    public static int dqP() {
        boolean z2;
        AppMethodBeat.i(166909);
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        kotlin.g.b.p.g(af2, "MMKernel.service<IConfig…onfigService::class.java)");
        String value = ((com.tencent.mm.plugin.zero.b.a) af2).aqJ().getValue("FinderFeedCompressResolution");
        String str = value;
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            AppMethodBeat.o(166909);
            return 1080;
        }
        Log.d("FinderConfig", "FinderFeedCompressResolution=".concat(String.valueOf(value)));
        if (value == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(166909);
            throw tVar;
        }
        int safeParseInt = Util.safeParseInt(kotlin.n.n.a(kotlin.n.n.trim(value).toString(), new String[]{"*"}).get(0));
        AppMethodBeat.o(166909);
        return safeParseInt;
    }

    public static int dqQ() {
        AppMethodBeat.i(166910);
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        kotlin.g.b.p.g(af2, "MMKernel.service<IConfig…onfigService::class.java)");
        String value = ((com.tencent.mm.plugin.zero.b.a) af2).aqJ().getValue("FinderFeedCompressPicLevel");
        String str = value;
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(166910);
            return 90;
        }
        Log.d("FinderConfig", "FinderFeedCompressPicLevel=".concat(String.valueOf(value)));
        if (value == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(166910);
            throw tVar;
        }
        int safeParseInt = Util.safeParseInt(kotlin.n.n.trim(value).toString());
        AppMethodBeat.o(166910);
        return safeParseInt;
    }

    public static int dqR() {
        return vwL;
    }

    public static int dqS() {
        AppMethodBeat.i(166911);
        int i2 = vwM;
        AppMethodBeat.o(166911);
        return i2;
    }

    public static int dqT() {
        AppMethodBeat.i(166912);
        int i2 = vwN;
        AppMethodBeat.o(166912);
        return i2;
    }

    public static int dqU() {
        AppMethodBeat.i(166913);
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        kotlin.g.b.p.g(af2, "MMKernel.service<IConfig…onfigService::class.java)");
        String value = ((com.tencent.mm.plugin.zero.b.a) af2).aqJ().getValue("FinderHeadCompressPicLevel");
        String str = value;
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(166913);
            return 90;
        }
        Log.i("FinderConfig", "FinderHeadCompressPicLevel=".concat(String.valueOf(value)));
        if (value == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(166913);
            throw tVar;
        }
        int safeParseInt = Util.safeParseInt(kotlin.n.n.trim(value).toString());
        AppMethodBeat.o(166913);
        return safeParseInt;
    }

    public static int dqV() {
        boolean z2;
        AppMethodBeat.i(166914);
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        kotlin.g.b.p.g(af2, "MMKernel.service<IConfig…onfigService::class.java)");
        String value = ((com.tencent.mm.plugin.zero.b.a) af2).aqJ().getValue("FinderProfileBgImgCompressResolution");
        String str = value;
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            AppMethodBeat.o(166914);
            return 1080;
        } else if (value == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(166914);
            throw tVar;
        } else {
            int safeParseInt = Util.safeParseInt(kotlin.n.n.a(kotlin.n.n.trim(value).toString(), new String[]{"*"}).get(0));
            AppMethodBeat.o(166914);
            return safeParseInt;
        }
    }

    public static int dqW() {
        boolean z2;
        AppMethodBeat.i(166915);
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        kotlin.g.b.p.g(af2, "MMKernel.service<IConfig…onfigService::class.java)");
        String value = ((com.tencent.mm.plugin.zero.b.a) af2).aqJ().getValue("FinderProfileBgImgCompressResolution");
        String str = value;
        if (str == null || str.length() == 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            AppMethodBeat.o(166915);
            return 1080;
        }
        Log.i("FinderConfig", "FinderHeadCompressResolution=".concat(String.valueOf(value)));
        if (value == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(166915);
            throw tVar;
        }
        int safeParseInt = Util.safeParseInt(kotlin.n.n.a(kotlin.n.n.trim(value).toString(), new String[]{"*"}).get(1));
        AppMethodBeat.o(166915);
        return safeParseInt;
    }

    public static int dqX() {
        AppMethodBeat.i(166916);
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        kotlin.g.b.p.g(af2, "MMKernel.service<IConfig…onfigService::class.java)");
        String value = ((com.tencent.mm.plugin.zero.b.a) af2).aqJ().getValue("FinderProfileBgImgCompressPicLevel");
        String str = value;
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(166916);
            return 70;
        }
        Log.i("FinderConfig", "FinderProfileBgImgCompressPicLevel=".concat(String.valueOf(value)));
        if (value == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
            AppMethodBeat.o(166916);
            throw tVar;
        }
        int safeParseInt = Util.safeParseInt(kotlin.n.n.trim(value).toString());
        AppMethodBeat.o(166916);
        return safeParseInt;
    }

    public static int dqY() {
        AppMethodBeat.i(251638);
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        kotlin.g.b.p.g(af2, "MMKernel.service<IConfig…onfigService::class.java)");
        int i2 = ((com.tencent.mm.plugin.zero.b.a) af2).aqJ().getInt("FinderCoverCompressPicLevel", 50);
        AppMethodBeat.o(251638);
        return i2;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dqZ() {
        return vwT;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dra() {
        return vwU;
    }

    public static int drb() {
        return vwV;
    }

    public static void KP(int i2) {
        vwX = i2;
    }

    public static int drc() {
        return vwX;
    }

    public static int drd() {
        return vwY;
    }

    public static int dre() {
        return vwZ;
    }

    public static boolean drf() {
        return vxb;
    }

    public static boolean drg() {
        return vxc;
    }

    public static long drh() {
        AppMethodBeat.i(166917);
        if (vxd <= vxe || Log.getLogLevel() > 1) {
            long a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_finder_folder_size_dump_interval, 86400L) * 1000;
            AppMethodBeat.o(166917);
            return a2;
        }
        long j2 = vxd;
        AppMethodBeat.o(166917);
        return j2;
    }

    private static float dri() {
        AppMethodBeat.i(166918);
        Log.i("FinderConfig", "FOLDER_SIZE_LEVEL, PhoneRemainSpace, " + vxe);
        if (vxe < 10) {
            AppMethodBeat.o(166918);
            return 0.5f;
        } else if (vxe < 20) {
            AppMethodBeat.o(166918);
            return 1.0f;
        } else {
            AppMethodBeat.o(166918);
            return 2.0f;
        }
    }

    public static long drj() {
        AppMethodBeat.i(166919);
        long a2 = (long) (((float) (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_finder_folder_size_image, 1024L) * ((long) vwv))) * dri());
        AppMethodBeat.o(166919);
        return a2;
    }

    public static long drk() {
        AppMethodBeat.i(166920);
        long a2 = (long) (((float) (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_finder_folder_size_avatar, 100L) * ((long) vwv))) * dri());
        AppMethodBeat.o(166920);
        return a2;
    }

    public static long drl() {
        AppMethodBeat.i(166921);
        long a2 = (long) (((float) (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_finder_folder_size_cropimg, 500L) * ((long) vwv))) * dri());
        AppMethodBeat.o(166921);
        return a2;
    }

    public static long drm() {
        AppMethodBeat.i(166922);
        long a2 = (long) (((float) (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_finder_folder_size_video, 1024L) * ((long) vwv))) * dri());
        AppMethodBeat.o(166922);
        return a2;
    }

    public static long drn() {
        AppMethodBeat.i(166923);
        long a2 = (long) (((float) (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_finder_folder_size_tmp, 500L) * ((long) vwv))) * dri());
        AppMethodBeat.o(166923);
        return a2;
    }

    public static long dro() {
        AppMethodBeat.i(166924);
        long a2 = (long) (((float) (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_finder_folder_size_capture, 500L) * ((long) vwv))) * dri());
        AppMethodBeat.o(166924);
        return a2;
    }

    public static long drp() {
        AppMethodBeat.i(166925);
        long a2 = (long) (((float) (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_finder_folder_size_posttmp, 500L) * ((long) vwv))) * dri());
        AppMethodBeat.o(166925);
        return a2;
    }

    public static int drq() {
        AppMethodBeat.i(166929);
        int i2 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderTimelineEntry", 0);
        AppMethodBeat.o(166929);
        return i2;
    }

    public static boolean drr() {
        AppMethodBeat.i(166930);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_finder_search_only_contact_android, 1) == 1) {
            AppMethodBeat.o(166930);
            return true;
        }
        AppMethodBeat.o(166930);
        return false;
    }

    public static boolean drs() {
        AppMethodBeat.i(166932);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_finder_show_reddot_number_attab_android, 1) == 1) {
            AppMethodBeat.o(166932);
            return true;
        }
        AppMethodBeat.o(166932);
        return false;
    }

    public static boolean drt() {
        AppMethodBeat.i(166933);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_finder_search_watchlist_android, 1) == 1) {
            AppMethodBeat.o(166933);
            return true;
        }
        AppMethodBeat.o(166933);
        return false;
    }

    public static boolean dru() {
        AppMethodBeat.i(166934);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_share_detail_entrance_switch_android, 1) == 1) {
            AppMethodBeat.o(166934);
            return true;
        }
        AppMethodBeat.o(166934);
        return false;
    }

    public static boolean drv() {
        AppMethodBeat.i(166935);
        if (((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderShareDetailCommentListShow", 1) == 1) {
            AppMethodBeat.o(166935);
            return true;
        }
        AppMethodBeat.o(166935);
        return false;
    }

    public static boolean drw() {
        AppMethodBeat.i(166936);
        if (((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderShareDetailCommentButtonShow", 1) == 1) {
            AppMethodBeat.o(166936);
            return true;
        }
        AppMethodBeat.o(166936);
        return false;
    }

    public static boolean drx() {
        AppMethodBeat.i(251639);
        if (((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderFeedCameraShowPostEducation", 1) == 1) {
            AppMethodBeat.o(251639);
            return true;
        }
        AppMethodBeat.o(251639);
        return false;
    }

    public static String dry() {
        AppMethodBeat.i(251640);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_MY_FINDER_POST_EDU_TITLE_STRING_SYNC, "");
        if (obj == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(251640);
            throw tVar;
        }
        String str = (String) obj;
        if (Util.isNullOrNil(str)) {
            String string = MMApplicationContext.getContext().getString(R.string.d3k);
            kotlin.g.b.p.g(string, "MMApplicationContext.get…finder_no_post_edu_title)");
            AppMethodBeat.o(251640);
            return string;
        }
        AppMethodBeat.o(251640);
        return str;
    }

    public static boolean hUN() {
        AppMethodBeat.i(261378);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_finder_live_user_visibility, 1) == 1) {
            AppMethodBeat.o(261378);
            return true;
        }
        AppMethodBeat.o(261378);
        return false;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> hUO() {
        return UUk;
    }

    public static String drz() {
        AppMethodBeat.i(251641);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_MY_FINDER_POST_EDU_DESC_STRING_SYNC, "");
        if (obj == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(251641);
            throw tVar;
        }
        String str = (String) obj;
        if (Util.isNullOrNil(str)) {
            String string = MMApplicationContext.getContext().getString(R.string.d3j);
            kotlin.g.b.p.g(string, "MMApplicationContext.get….finder_no_post_edu_desc)");
            AppMethodBeat.o(251641);
            return string;
        }
        AppMethodBeat.o(251641);
        return str;
    }

    private static boolean drA() {
        boolean z2;
        AppMethodBeat.i(251642);
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = kotlin.a.j.listOf((Object[]) new b.a[]{b.a.clicfg_finder_ftpp_codec_reuse_model_list_0, b.a.clicfg_finder_ftpp_codec_reuse_model_list_1, b.a.clicfg_finder_ftpp_codec_reuse_model_list_2, b.a.clicfg_finder_ftpp_codec_reuse_model_list_3, b.a.clicfg_finder_ftpp_codec_reuse_model_list_4, b.a.clicfg_finder_ftpp_codec_reuse_model_list_5, b.a.clicfg_finder_ftpp_codec_reuse_model_list_6, b.a.clicfg_finder_ftpp_codec_reuse_model_list_7, b.a.clicfg_finder_ftpp_codec_reuse_model_list_8, b.a.clicfg_finder_ftpp_codec_reuse_model_list_9}).iterator();
        boolean z3 = false;
        while (true) {
            if (!it.hasNext()) {
                z2 = z3;
                break;
            }
            String a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a((b.a) it.next(), "{mode:1,whitelist:[],apilevel:[],company:[],blacklist:[]}");
            if (!TextUtils.isEmpty(a2)) {
                try {
                    JSONObject jSONObject = new JSONObject(a2);
                    if (jSONObject.getInt("mode") == 1) {
                        JSONArray jSONArray = jSONObject.getJSONArray("whitelist");
                        int length = jSONArray.length();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= length) {
                                break;
                            }
                            String string = jSONArray.getString(i2);
                            Log.d("FinderConfig", "checkEnableCodecReuse modelName:".concat(String.valueOf(string)));
                            if (kotlin.n.n.I(Build.MODEL, string, true)) {
                                z3 = true;
                                break;
                            }
                            i2++;
                        }
                        if (z3) {
                            z2 = z3;
                            break;
                        }
                    }
                } catch (Throwable th) {
                    Log.printErrStackTrace("FinderConfig", th, "", new Object[0]);
                }
                z3 = z3;
            }
        }
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1505, 9, z2 ? 1 : vxe);
        Log.i("FinderConfig", "checkEnableCodecReuse enableCodecReuse:" + z2 + " duration:" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(251642);
        return z2;
    }

    private static boolean[] drC() {
        AppMethodBeat.i(166939);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_meida_gesture_preview, "{isEnableImage:false,isEnableVideo:false,hard-close:[]}");
        if (!TextUtils.isEmpty(a2)) {
            try {
                Log.i("FinderConfig", "[checkEnableGesturePreviewMedia] JSON=".concat(String.valueOf(a2)));
                JSONObject jSONObject = new JSONObject(a2);
                JSONArray jSONArray = jSONObject.getJSONArray("hard-close");
                int length = jSONArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                    String string = jSONObject2.getString("device-brand");
                    String string2 = jSONObject2.getString("device-model");
                    int i3 = jSONObject2.getInt("below-sdk-version");
                    boolean z2 = jSONObject2.getBoolean("isEnableImage");
                    boolean z3 = jSONObject2.getBoolean("isEnableVideo");
                    String str = Build.BRAND + " " + Build.MODEL;
                    Log.i("FinderConfig", "[checkEnableGesturePreviewMedia] name=" + string + " model=" + string2 + " version=" + i3 + " isEnableImage=" + z2 + " isEnableVideo=" + z3 + " | this device=" + str + " version=" + Build.VERSION.SDK_INT);
                    if (i3 >= Build.VERSION.SDK_INT) {
                        kotlin.g.b.p.g(string, "name");
                        if (kotlin.n.n.a((CharSequence) str, (CharSequence) string, true)) {
                            kotlin.g.b.p.g(string2, "model");
                            if (kotlin.n.n.a((CharSequence) str, (CharSequence) string2, true)) {
                                boolean[] zArr = {z2, z3};
                                AppMethodBeat.o(166939);
                                return zArr;
                            }
                        } else {
                            continue;
                        }
                    }
                }
                boolean z4 = jSONObject.getBoolean("isEnableImage");
                boolean z5 = jSONObject.getBoolean("isEnableVideo");
                boolean[] zArr2 = {z4, z5};
                Log.i("FinderConfig", "[checkEnableGesturePreviewMedia] isEnableImage=" + z4 + " isEnableVideo=" + z5);
                AppMethodBeat.o(166939);
                return zArr2;
            } catch (Exception e2) {
                Log.printErrStackTrace("FinderConfig", e2, "", new Object[0]);
            }
        } else {
            Log.i("FinderConfig", "[checkEnableGesturePreviewMedia] json is Empty! just pass!");
            boolean[] zArr3 = {true, true};
            AppMethodBeat.o(166939);
            return zArr3;
        }
    }

    public static boolean drD() {
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(251644);
        if (vAI.value().intValue() == 1) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_video_preload_enable, 1) != 1) {
            z3 = false;
        }
        if (BuildInfo.DEBUG || BuildInfo.DEBUG) {
            AppMethodBeat.o(251644);
            return z2;
        }
        AppMethodBeat.o(251644);
        return z3;
    }

    public static boolean drE() {
        AppMethodBeat.i(251645);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_image_preload_enable, 1) == 1) {
            AppMethodBeat.o(251645);
            return true;
        }
        AppMethodBeat.o(251645);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0138 A[Catch:{ Throwable -> 0x01b9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static kotlin.o<java.lang.Integer, java.lang.Boolean> drF() {
        /*
        // Method dump skipped, instructions count: 451
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.storage.c.drF():kotlin.o");
    }

    public static boolean drH() {
        AppMethodBeat.i(251647);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_is_user_vlog_mode, 1) == 1 || BuildInfo.IS_FLAVOR_PURPLE || BuildInfo.DEBUG) {
            AppMethodBeat.o(251647);
            return true;
        }
        AppMethodBeat.o(251647);
        return false;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> drI() {
        return vxk;
    }

    public static boolean drJ() {
        AppMethodBeat.i(251648);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_vlog_is_background_mux, 1) == 1) {
            AppMethodBeat.o(251648);
            return true;
        }
        AppMethodBeat.o(251648);
        return false;
    }

    public static String drK() {
        AppMethodBeat.i(166943);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_fake_video_config, "{\"configs\":[{\"brands\":\"\",\"models\":\"\", \"maxSize\":4000}]}");
        AppMethodBeat.o(166943);
        return a2;
    }

    public static boolean drL() {
        AppMethodBeat.i(166944);
        if (((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderEnableFriendCommentJumpToProfile", 0) == 1) {
            AppMethodBeat.o(166944);
            return true;
        }
        AppMethodBeat.o(166944);
        return false;
    }

    public static boolean drM() {
        AppMethodBeat.i(166945);
        boolean z2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_enter_get_gps, 1) == 1;
        Log.i("FinderConfig", "[GET] isGetGps=".concat(String.valueOf(z2)));
        AppMethodBeat.o(166945);
        return z2;
    }

    public static boolean drN() {
        AppMethodBeat.i(166948);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_topic_switch, 1) == 1) {
            AppMethodBeat.o(166948);
            return true;
        }
        AppMethodBeat.o(166948);
        return false;
    }

    public static boolean drO() {
        AppMethodBeat.i(251649);
        if (((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderMaxMentionSbCount", 1000) > 0) {
            AppMethodBeat.o(251649);
            return true;
        }
        AppMethodBeat.o(251649);
        return false;
    }

    public static boolean drP() {
        AppMethodBeat.i(166950);
        if (vxl == 0 && Log.getLogLevel() <= 1) {
            AppMethodBeat.o(166950);
            return false;
        } else if (((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderPoiJumpTopicSwitch", 0) == 1) {
            AppMethodBeat.o(166950);
            return true;
        } else {
            AppMethodBeat.o(166950);
            return false;
        }
    }

    public static boolean drQ() {
        AppMethodBeat.i(166952);
        if (vxm && Log.getLogLevel() <= 1) {
            AppMethodBeat.o(166952);
            return true;
        } else if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_preload_comment, 1) == 1) {
            AppMethodBeat.o(166952);
            return true;
        } else {
            AppMethodBeat.o(166952);
            return false;
        }
    }

    public static int drR() {
        AppMethodBeat.i(178407);
        if (vxn == 5 || Log.getLogLevel() > 1) {
            int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_preload_comment_remain_count, vxn);
            AppMethodBeat.o(178407);
            return a2;
        }
        int i2 = vxn;
        AppMethodBeat.o(178407);
        return i2;
    }

    public static int drS() {
        AppMethodBeat.i(178412);
        if (vya.value().intValue() == 1) {
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_LAST_COMMENT_SCENE_INT_SYNC, vxo);
            if (i2 <= 0) {
                int i3 = vxo;
                AppMethodBeat.o(178412);
                return i3;
            }
            AppMethodBeat.o(178412);
            return i2;
        }
        AppMethodBeat.o(178412);
        return 2;
    }

    public static void KQ(int i2) {
        AppMethodBeat.i(251650);
        Log.i("FinderConfig", "set REPLY_SCENE value:".concat(String.valueOf(i2)));
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_LAST_COMMENT_SCENE_INT_SYNC, Integer.valueOf(i2));
        AppMethodBeat.o(251650);
    }

    public static int drT() {
        return vxo;
    }

    public static boolean drU() {
        AppMethodBeat.i(178413);
        if (((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderCommentShowBlacklist", 0) == 1) {
            AppMethodBeat.o(178413);
            return true;
        }
        AppMethodBeat.o(178413);
        return false;
    }

    public static int drV() {
        AppMethodBeat.i(178414);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_can_select_district, 0);
        AppMethodBeat.o(178414);
        return a2;
    }

    public static boolean drW() {
        AppMethodBeat.i(178415);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        if (aAh.azQ().a(ar.a.USERINFO_FINDER_SHOW_CHANGE_DISTRICT_LONG, vxe) == vxe) {
            AppMethodBeat.o(178415);
            return true;
        }
        AppMethodBeat.o(178415);
        return false;
    }

    public static boolean drX() {
        AppMethodBeat.i(178416);
        if (vxq == 1 && Log.getLogLevel() <= 1) {
            AppMethodBeat.o(178416);
            return true;
        } else if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_use_daemon_record, 0) == 1) {
            AppMethodBeat.o(178416);
            return true;
        } else {
            AppMethodBeat.o(178416);
            return false;
        }
    }

    public static int drY() {
        AppMethodBeat.i(178417);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_high_record_bitrate, 10000000);
        AppMethodBeat.o(178417);
        return a2;
    }

    public static int drZ() {
        AppMethodBeat.i(178418);
        int i2 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("FinderCommentNickNameMaxLength", 6);
        AppMethodBeat.o(178418);
        return i2;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsa() {
        return vxr;
    }

    public static long dsb() {
        return vxs;
    }

    public static boolean dsc() {
        AppMethodBeat.i(251651);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_gesture_seek_bar, 1) == 1) {
            AppMethodBeat.o(251651);
            return true;
        }
        AppMethodBeat.o(251651);
        return false;
    }

    public static boolean dsd() {
        return vxt;
    }

    public static int dse() {
        return vxu;
    }

    public static int dsf() {
        return vxv;
    }

    public static /* synthetic */ String dsg() {
        AppMethodBeat.i(251653);
        String bb2 = bb(4, "");
        AppMethodBeat.o(251653);
        return bb2;
    }

    public static String bb(int i2, String str) {
        String str2;
        AppMethodBeat.i(251652);
        kotlin.g.b.p.h(str, "defaultStr");
        if (TextUtils.isEmpty(str)) {
            switch (i2) {
                case 1:
                    str2 = MMApplicationContext.getContext().getString(R.string.d_s);
                    kotlin.g.b.p.g(str2, "MMApplicationContext.get…string.finder_tab_friend)");
                    break;
                case 2:
                default:
                    str2 = "";
                    break;
                case 3:
                    str2 = MMApplicationContext.getContext().getString(R.string.d_r);
                    kotlin.g.b.p.g(str2, "MMApplicationContext.get…string.finder_tab_follow)");
                    break;
                case 4:
                    str2 = MMApplicationContext.getContext().getString(R.string.d_u);
                    kotlin.g.b.p.g(str2, "MMApplicationContext.get…tring.finder_tab_machine)");
                    break;
            }
        } else {
            str2 = str;
        }
        switch (i2) {
            case 1:
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                Object obj = aAh.azQ().get(ar.a.USERINFO_FINDER_TAB_FRIEND_NAME_STRING, str2);
                if (obj == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(251652);
                    throw tVar;
                }
                String str3 = (String) obj;
                AppMethodBeat.o(251652);
                return str3;
            case 2:
            default:
                AppMethodBeat.o(251652);
                return "";
            case 3:
                com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
                Object obj2 = aAh2.azQ().get(ar.a.USERINFO_FINDER_TAB_FOLLOW_NAME_STRING, str2);
                if (obj2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(251652);
                    throw tVar2;
                }
                String str4 = (String) obj2;
                AppMethodBeat.o(251652);
                return str4;
            case 4:
                com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
                Object obj3 = aAh3.azQ().get(ar.a.USERINFO_FINDER_TAB_MACHINE_NAME_STRING, str2);
                if (obj3 == null) {
                    kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(251652);
                    throw tVar3;
                }
                String str5 = (String) obj3;
                AppMethodBeat.o(251652);
                return str5;
        }
    }

    public static boolean dsh() {
        AppMethodBeat.i(251654);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_multi_video_download_enable, 1) == 1) {
            AppMethodBeat.o(251654);
            return true;
        }
        AppMethodBeat.o(251654);
        return false;
    }

    public static int dsi() {
        return vxw;
    }

    public static boolean dsj() {
        AppMethodBeat.i(251655);
        boolean z2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_store_last_tab_type_enable, 1) == 1;
        Log.i("FinderConfig", "[GET] isEnableStoreLastTabType=".concat(String.valueOf(z2)));
        AppMethodBeat.o(251655);
        return z2;
    }

    public static void dsk() {
        AppMethodBeat.i(251656);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_HAS_ENTER_MULTI_TAB_INT_SYNC, (Object) 1);
        vxx = false;
        AppMethodBeat.o(251656);
    }

    public static boolean dsl() {
        AppMethodBeat.i(251657);
        boolean z2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_preload_tab_refresh_enable, 1) == 1;
        Log.i("FinderConfig", "[GET] isEnablePreloadStreamRefresh=".concat(String.valueOf(z2)));
        AppMethodBeat.o(251657);
        return z2;
    }

    public static boolean dsm() {
        AppMethodBeat.i(251658);
        boolean z2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_preload_video_for_preload_refresh_enable, 1) == 1;
        Log.i("FinderConfig", "[GET] isEnablePreloadVideoForPreloadStream=".concat(String.valueOf(z2)));
        AppMethodBeat.o(251658);
        return z2;
    }

    public static kotlin.k.b<Double> dsn() {
        return vxy;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dso() {
        return vxz;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsp() {
        return vxA;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsq() {
        return vxB;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsr() {
        return vxC;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dss() {
        return vxD;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dst() {
        return vxE;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsu() {
        return vxF;
    }

    public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dsv() {
        return vxG;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> hUP() {
        return UUl;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsx() {
        return vxI;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dsy() {
        return vxJ;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> hUQ() {
        return UUm;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsz() {
        return vxK;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsA() {
        return vxL;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsB() {
        return vxM;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsC() {
        return vxN;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dsD() {
        return vxO;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dsE() {
        return vxP;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dsF() {
        return vxQ;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsG() {
        return vxR;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsH() {
        return vxS;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsI() {
        return vxT;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsJ() {
        return vxU;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsK() {
        return vxV;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsL() {
        return vxW;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsM() {
        return vxX;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsN() {
        return vxY;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsO() {
        return vxZ;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsP() {
        return vya;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> hUR() {
        return UUn;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dsQ() {
        return vyb;
    }

    public static int dsR() {
        AppMethodBeat.i(251659);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_SWITCH_SCENE_TIP_INT_SYNC, 4);
        AppMethodBeat.o(251659);
        return i2;
    }

    public static void KR(int i2) {
        AppMethodBeat.i(251660);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_SWITCH_SCENE_TIP_INT_SYNC, Integer.valueOf(i2));
        AppMethodBeat.o(251660);
    }

    public static int dsS() {
        AppMethodBeat.i(251661);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_SHOW_SELF_FEED_LIKE_TIPS_TIMES_INT, 0);
        AppMethodBeat.o(251661);
        return i2;
    }

    public static void KS(int i2) {
        AppMethodBeat.i(251662);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_SHOW_SELF_FEED_LIKE_TIPS_TIMES_INT, Integer.valueOf(i2));
        AppMethodBeat.o(251662);
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsT() {
        return vyc;
    }

    public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dsU() {
        return vyd;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dsV() {
        return vye;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dsW() {
        return vyf;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dsX() {
        return vyg;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dsY() {
        return vyh;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dsZ() {
        return vyi;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dta() {
        return vyj;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dtb() {
        return vyk;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dtc() {
        return vyl;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dtd() {
        return vym;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dte() {
        return vyn;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtf() {
        return vyo;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtg() {
        return vyp;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dth() {
        return vyq;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dti() {
        return vyr;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtj() {
        return vys;
    }

    public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dtk() {
        return vyt;
    }

    public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dtl() {
        return vyu;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dtm() {
        return vyv;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dtn() {
        return vyw;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dto() {
        return vyx;
    }

    public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dtp() {
        return vyy;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dtq() {
        return vyz;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtr() {
        return vyA;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dts() {
        return vyB;
    }

    public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dtt() {
        return vyC;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dtu() {
        return vyD;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dtv() {
        return vyE;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dtw() {
        return vyF;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtx() {
        return vyG;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Long> dty() {
        return vyH;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dtz() {
        return vyJ;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtA() {
        return vyK;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtB() {
        return vyL;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtC() {
        return vyM;
    }

    public static List<kotlin.o<Integer, String>> dtD() {
        return vyN;
    }

    public static boolean dtE() {
        AppMethodBeat.i(251663);
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        kotlin.g.b.p.g(af2, "MMKernel.service<IConfig…onfigService::class.java)");
        if (((com.tencent.mm.plugin.zero.b.a) af2).aqJ().getInt("FinderStatsReportControl", 1) == 1) {
            AppMethodBeat.o(251663);
            return true;
        }
        AppMethodBeat.o(251663);
        return false;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtF() {
        return vyP;
    }

    public static final class t extends com.tencent.mm.plugin.finder.storage.config.item.integer.a {
        t(String str) {
            super(0, str);
        }

        @Override // com.tencent.mm.plugin.finder.storage.config.b
        public final /* synthetic */ Integer value() {
            AppMethodBeat.i(251563);
            if (com.tencent.mm.model.z.aUh()) {
                AppMethodBeat.o(251563);
                return 0;
            }
            Integer num = (Integer) super.value();
            AppMethodBeat.o(251563);
            return num;
        }
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtG() {
        return vyQ;
    }

    public static int dtH() {
        AppMethodBeat.i(251664);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_cdn_upload_control, 0);
        AppMethodBeat.o(251664);
        return a2;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtI() {
        return vyR;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtJ() {
        return vyS;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtK() {
        return vyT;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtL() {
        return vyU;
    }

    public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dtM() {
        return vyV;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtN() {
        return vyW;
    }

    public static int dtO() {
        AppMethodBeat.i(251665);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_PRIVATE_LIKE_TIPS_COUNT_INT_SYNC, 3);
        AppMethodBeat.o(251665);
        return i2;
    }

    public static void KT(int i2) {
        AppMethodBeat.i(251666);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_PRIVATE_LIKE_TIPS_COUNT_INT_SYNC, Integer.valueOf(i2));
        AppMethodBeat.o(251666);
    }

    public static int dtP() {
        AppMethodBeat.i(251667);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_PRIVATE_LIKE_TIPS_COUNT2_INT_SYNC, 3);
        AppMethodBeat.o(251667);
        return i2;
    }

    public static void KU(int i2) {
        AppMethodBeat.i(251668);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_PRIVATE_LIKE_TIPS_COUNT2_INT_SYNC, Integer.valueOf(i2));
        AppMethodBeat.o(251668);
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtQ() {
        return vyY;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dtR() {
        return vyZ;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtS() {
        return vza;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtT() {
        return vzb;
    }

    public static boolean dtU() {
        AppMethodBeat.i(251669);
        if (vzb.value().intValue() == 1) {
            AppMethodBeat.o(251669);
            return true;
        }
        AppMethodBeat.o(251669);
        return false;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtV() {
        return vzc;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtW() {
        return vzd;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtX() {
        return vze;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtY() {
        return vzf;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dtZ() {
        return vzg;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dua() {
        return vzh;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<String> dub() {
        return vzi;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c duc() {
        return vzj;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dud() {
        return vzk;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> due() {
        return vzl;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duf() {
        return vzm;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dug() {
        return vzn;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duh() {
        return vzo;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dui() {
        return vzp;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duj() {
        return vzq;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duk() {
        return vzr;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dul() {
        return vzs;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dum() {
        return vzt;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dun() {
        return vzu;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duo() {
        return vzv;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dup() {
        return vzw;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duq() {
        return vzx;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dur() {
        return vzy;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dus() {
        return vzz;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dut() {
        return vzA;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duu() {
        return vzB;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duv() {
        return vzC;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duw() {
        return vzD;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dux() {
        return vzE;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c duy() {
        return vzF;
    }

    static final class bb extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final bb vDf = new bb();

        static {
            AppMethodBeat.i(251629);
            AppMethodBeat.o(251629);
        }

        bb() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(251628);
            c cVar = c.vCb;
            Boolean valueOf = Boolean.valueOf(c.dxl());
            AppMethodBeat.o(251628);
            return valueOf;
        }
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duz() {
        return vzH;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duA() {
        return vzI;
    }

    static final class bc extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final bc vDg = new bc();

        static {
            AppMethodBeat.i(166900);
            AppMethodBeat.o(166900);
        }

        bc() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(166899);
            c cVar = c.vCb;
            Boolean valueOf = Boolean.valueOf(c.dxm()[0]);
            AppMethodBeat.o(166899);
            return valueOf;
        }
    }

    public static String duB() {
        AppMethodBeat.i(251670);
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        kotlin.g.b.p.g(af2, "MMKernel.service<IConfig…onfigService::class.java)");
        String value = ((com.tencent.mm.plugin.zero.b.a) af2).aqJ().getValue("FinderShowOriginalCertificationUrl");
        if (Util.isNullOrNil(value)) {
            AppMethodBeat.o(251670);
            return "https://support.weixin.qq.com/cgi-bin/mmfindersupport-bin/newreadtemplate?t=page/outer_page/original_plan&wechat_real_lang=zh_CN";
        }
        kotlin.g.b.p.g(value, "url");
        AppMethodBeat.o(251670);
        return value;
    }

    static final class bd extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final bd vDh = new bd();

        static {
            AppMethodBeat.i(166902);
            AppMethodBeat.o(166902);
        }

        bd() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(166901);
            c cVar = c.vCb;
            Boolean valueOf = Boolean.valueOf(c.dxm()[1]);
            AppMethodBeat.o(166901);
            return valueOf;
        }
    }

    public static com.tencent.mm.plugin.finder.storage.config.c duC() {
        return vzJ;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c duD() {
        return vzK;
    }

    public static int duE() {
        AppMethodBeat.i(251671);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_ORIGIN_ACCOUNT_POST_TIPSCOUNT_INT_SYNC, 1);
        AppMethodBeat.o(251671);
        return i2;
    }

    public static void KV(int i2) {
        AppMethodBeat.i(251672);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_FINDER_ORIGIN_ACCOUNT_POST_TIPSCOUNT_INT_SYNC, Integer.valueOf(i2));
        AppMethodBeat.o(251672);
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duF() {
        return vzL;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duG() {
        return vzM;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duH() {
        return vzN;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duI() {
        return vzO;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duJ() {
        return vzP;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duK() {
        return vzQ;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c duL() {
        return vzR;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c duM() {
        return vzS;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c hUS() {
        return UUo;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duN() {
        return vzT;
    }

    public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a duO() {
        return vzU;
    }

    public static boolean duP() {
        AppMethodBeat.i(251673);
        if (vzT.value().intValue() == 1) {
            AppMethodBeat.o(251673);
            return true;
        }
        AppMethodBeat.o(251673);
        return false;
    }

    public static int duQ() {
        AppMethodBeat.i(251674);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        int i2 = aAh.azQ().getInt(ar.a.USERINFO_LIVE_KNOW_LICENSE_UPDATE_INT_SYNC, 0);
        AppMethodBeat.o(251674);
        return i2;
    }

    public static void KW(int i2) {
        AppMethodBeat.i(251675);
        Log.i("FinderConfig", "set LIVE_LICENSE value:".concat(String.valueOf(i2)));
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        aAh.azQ().set(ar.a.USERINFO_LIVE_KNOW_LICENSE_UPDATE_INT_SYNC, Integer.valueOf(i2));
        AppMethodBeat.o(251675);
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duR() {
        return vzV;
    }

    public static boolean duS() {
        AppMethodBeat.i(251676);
        if (vzV.value().intValue() == 1) {
            AppMethodBeat.o(251676);
            return true;
        }
        AppMethodBeat.o(251676);
        return false;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duT() {
        return vzW;
    }

    static final class ap extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        public static final ap vCT = new ap();

        static {
            AppMethodBeat.i(166898);
            AppMethodBeat.o(166898);
        }

        ap() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(166897);
            Integer valueOf = Integer.valueOf(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_record_video_max_duration_android, 60));
            AppMethodBeat.o(166897);
            return valueOf;
        }
    }

    public static boolean duU() {
        AppMethodBeat.i(251677);
        if (vzW.value().intValue() == 1) {
            AppMethodBeat.o(251677);
            return true;
        }
        AppMethodBeat.o(251677);
        return false;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duV() {
        return vzX;
    }

    public static boolean duW() {
        AppMethodBeat.i(251678);
        if (vzX.value().intValue() == 0) {
            AppMethodBeat.o(251678);
            return true;
        }
        AppMethodBeat.o(251678);
        return false;
    }

    public static int duX() {
        AppMethodBeat.i(251679);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_live_shopping_height_percent, 75);
        AppMethodBeat.o(251679);
        return a2;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> duY() {
        return vzY;
    }

    public static int duZ() {
        AppMethodBeat.i(251680);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_live_max_num, 50);
        AppMethodBeat.o(251680);
        return a2;
    }

    public static int dva() {
        AppMethodBeat.i(251681);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_live_minipro_prerender_level, 10);
        AppMethodBeat.o(251681);
        return a2;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvb() {
        return vzZ;
    }

    public static boolean dvc() {
        AppMethodBeat.i(251682);
        if (vzZ.value().intValue() == 0) {
            AppMethodBeat.o(251682);
            return true;
        }
        AppMethodBeat.o(251682);
        return false;
    }

    public static int dvd() {
        AppMethodBeat.i(251683);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_live_bullet_comment_limit_num, 10);
        AppMethodBeat.o(251683);
        return a2;
    }

    public static int dve() {
        AppMethodBeat.i(251684);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_live_refresh_duration, 60);
        AppMethodBeat.o(251684);
        return a2;
    }

    public static int dvf() {
        AppMethodBeat.i(251685);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_live_statistics_frequency, 4000);
        AppMethodBeat.o(251685);
        return a2;
    }

    public static int dvg() {
        AppMethodBeat.i(251686);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_live_visitor_max_retry_count, 100);
        AppMethodBeat.o(251686);
        return a2;
    }

    public static int dvh() {
        AppMethodBeat.i(251687);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_live_visitor_retry_interval, 3);
        AppMethodBeat.o(251687);
        return a2;
    }

    public static boolean hUT() {
        AppMethodBeat.i(261379);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_live_sei_enable_switch, 1) == 1) {
            AppMethodBeat.o(261379);
            return true;
        }
        AppMethodBeat.o(261379);
        return false;
    }

    public static boolean hUU() {
        AppMethodBeat.i(261380);
        if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_live_hevc_enc_enable_switch, 0) == 1) {
            AppMethodBeat.o(261380);
            return true;
        }
        AppMethodBeat.o(261380);
        return false;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvi() {
        return vAa;
    }

    public static boolean dvj() {
        AppMethodBeat.i(251688);
        if (vAa.value().intValue() == 1) {
            AppMethodBeat.o(251688);
            return true;
        }
        AppMethodBeat.o(251688);
        return false;
    }

    public static boolean dvk() {
        AppMethodBeat.i(251689);
        if (vAb.value().intValue() == 1) {
            AppMethodBeat.o(251689);
            return true;
        }
        AppMethodBeat.o(251689);
        return false;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvl() {
        return vAc;
    }

    public static boolean dvm() {
        AppMethodBeat.i(251690);
        if (vAc.value().intValue() == 1) {
            AppMethodBeat.o(251690);
            return true;
        }
        AppMethodBeat.o(251690);
        return false;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvn() {
        return vAd;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvo() {
        return vAe;
    }

    public static int dvp() {
        AppMethodBeat.i(251691);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_live_lottery_duration, 15);
        AppMethodBeat.o(251691);
        return a2;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvq() {
        return vAf;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvr() {
        return vAg;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvs() {
        return vAh;
    }

    public static List<String> dvt() {
        AppMethodBeat.i(251692);
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        kotlin.g.b.p.g(af2, "MMKernel.service<IConfig…onfigService::class.java)");
        String value = ((com.tencent.mm.plugin.zero.b.a) af2).aqJ().getValue("FinderTopicInputStopTokenList");
        if (!(value instanceof String)) {
            value = null;
        }
        if (value == null || !(!kotlin.g.b.p.j(value, ""))) {
            List<String> listOf = kotlin.a.j.listOf((Object[]) new String[]{"\\s", "\\n", "#", "@", "\\t"});
            AppMethodBeat.o(251692);
            return listOf;
        }
        ArrayList arrayList = new ArrayList();
        for (T t2 : kotlin.n.n.a(value, new String[]{"_"})) {
            if (!Util.isNullOrNil(t2)) {
                arrayList.add(t2);
            }
        }
        ArrayList arrayList2 = arrayList;
        Log.i("FinderConfig", "endchars: ".concat(String.valueOf(arrayList2)));
        AppMethodBeat.o(251692);
        return arrayList2;
    }

    public static List<String> dvu() {
        AppMethodBeat.i(251693);
        com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.zero.b.a.class);
        kotlin.g.b.p.g(af2, "MMKernel.service<IConfig…onfigService::class.java)");
        String value = ((com.tencent.mm.plugin.zero.b.a) af2).aqJ().getValue("FinderMentionInputStopTokenList");
        if (!(value instanceof String)) {
            value = null;
        }
        if (value == null || !(!kotlin.g.b.p.j(value, ""))) {
            List<String> listOf = kotlin.a.j.listOf((Object[]) new String[]{"\\s", "\\n", "#", "@", "\\t"});
            AppMethodBeat.o(251693);
            return listOf;
        }
        ArrayList arrayList = new ArrayList();
        for (T t2 : kotlin.n.n.a(value, new String[]{"_"})) {
            if (!Util.isNullOrNil(t2)) {
                arrayList.add(t2);
            }
        }
        ArrayList arrayList2 = arrayList;
        Log.i("FinderConfig", "endchars: ".concat(String.valueOf(arrayList2)));
        AppMethodBeat.o(251693);
        return arrayList2;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvv() {
        return vAj;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dvw() {
        return vAk;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvx() {
        return vAl;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvy() {
        return vAm;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvz() {
        return vAn;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvA() {
        return vAo;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvB() {
        return vAp;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvC() {
        return vAq;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvD() {
        return vAr;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvE() {
        return vAs;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Long> dvF() {
        return vAt;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Long> dvG() {
        return vAu;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Long> dvH() {
        return vAv;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvI() {
        return vAw;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvJ() {
        return vAx;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvK() {
        return vAy;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvL() {
        return vAz;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> hUV() {
        return UUp;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> hUW() {
        return UUq;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvM() {
        return vAA;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvN() {
        return vAB;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvO() {
        return vAC;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvP() {
        return vAD;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvQ() {
        return vAE;
    }

    public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dvR() {
        return vAF;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvS() {
        return vAG;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvT() {
        return vAH;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvU() {
        return vAI;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvV() {
        return vAJ;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvW() {
        return vAK;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Boolean> dvX() {
        return vAL;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvY() {
        return vAO;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dvZ() {
        return vAP;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwa() {
        return vAQ;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwb() {
        return vAR;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Long> dwc() {
        return vAS;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwd() {
        return vAT;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwe() {
        return vAU;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwf() {
        return vAV;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwg() {
        return vAW;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwh() {
        return vAX;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwi() {
        return vAY;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwj() {
        return vAZ;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwk() {
        return vBa;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwl() {
        return vBb;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwm() {
        return vBc;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> hUX() {
        return UUr;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> hUY() {
        return UUs;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> hUZ() {
        return UUt;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwn() {
        return vBd;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwo() {
        return vBe;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwp() {
        return vBf;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwq() {
        return vBg;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwr() {
        return vBh;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dws() {
        return vBi;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwt() {
        return vBj;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwu() {
        return vBk;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwv() {
        return vBl;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dww() {
        return vBm;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwx() {
        return vBn;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> hVa() {
        return UUu;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwy() {
        return vBo;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Float> dwz() {
        return vBp;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwA() {
        return vBq;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwB() {
        return vBr;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwC() {
        return vBs;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwD() {
        return vBt;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwE() {
        return vBu;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwF() {
        return vBv;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwG() {
        return vBw;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwH() {
        return vBy;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwI() {
        return vBz;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwJ() {
        return vBA;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwK() {
        return vBB;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwL() {
        return vBC;
    }

    static final class av extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final av vCZ = new av();

        static {
            AppMethodBeat.i(251617);
            AppMethodBeat.o(251617);
        }

        av() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251616);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_EXIT_FINDER_TL_LONG_SYNC, Long.valueOf((long) c.vxe));
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_EXIT_NEARBY_LONG_SYNC, Long.valueOf((long) c.vxe));
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251616);
            return xVar;
        }
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<String> dwM() {
        return vBD;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<String> dwN() {
        return vBE;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<String> dwO() {
        return vBF;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<String> dwP() {
        return vBG;
    }

    static final class u extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final u vCy = new u();

        static {
            AppMethodBeat.i(251565);
            AppMethodBeat.o(251565);
        }

        u() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            boolean z = false;
            AppMethodBeat.i(251564);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            boolean z2 = aAh.azQ().getBoolean(ar.a.USERINFO_FINDER_TEST_FAKE_LOADING_TOAST_BOOLEAN, false);
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            com.tencent.mm.storage.ao azQ = aAh2.azQ();
            ar.a aVar = ar.a.USERINFO_FINDER_TEST_FAKE_LOADING_TOAST_BOOLEAN;
            if (!z2) {
                z = true;
            }
            azQ.set(aVar, Boolean.valueOf(z));
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251564);
            return xVar;
        }
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<String> dwQ() {
        return vBH;
    }

    static final class aw extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final aw vDa = new aw();

        static {
            AppMethodBeat.i(251619);
            AppMethodBeat.o(251619);
        }

        aw() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251618);
            com.tencent.mm.plugin.finder.utils.r rVar = com.tencent.mm.plugin.finder.utils.r.vWn;
            ((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).sdkShare("businessType", "appid", com.tencent.mm.plugin.finder.utils.r.dCi());
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251618);
            return xVar;
        }
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<String> dwR() {
        return vBI;
    }

    static final class ax extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final ax vDb = new ax();

        static {
            AppMethodBeat.i(251621);
            AppMethodBeat.o(251621);
        }

        ax() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251620);
            com.tencent.mm.plugin.finder.utils.r rVar = com.tencent.mm.plugin.finder.utils.r.vWn;
            ((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).sdkShare("businessType", "appid", com.tencent.mm.plugin.finder.utils.r.dCj());
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251620);
            return xVar;
        }
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<String> dwS() {
        return vBJ;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<String> dwT() {
        return vBK;
    }

    public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a dwU() {
        return vBL;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dwV() {
        return vBM;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwW() {
        return vBN;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dwX() {
        return vBO;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> hVb() {
        return UUv;
    }

    public static boolean dwY() {
        AppMethodBeat.i(251694);
        if (vBO.value().intValue() == 1) {
            AppMethodBeat.o(251694);
            return true;
        }
        AppMethodBeat.o(251694);
        return false;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dxa() {
        return vBQ;
    }

    public static com.tencent.mm.plugin.finder.storage.config.c dxb() {
        return vBR;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dxc() {
        return vBS;
    }

    static final class q extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final q vCv = new q();

        static {
            AppMethodBeat.i(251558);
            AppMethodBeat.o(251558);
        }

        q() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251557);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_SWITCH_SCENE_TIP_INT_SYNC, (Object) 4);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251557);
            return xVar;
        }
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Boolean> dxd() {
        return vBT;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dxe() {
        return vBU;
    }

    public static String dxf() {
        AppMethodBeat.i(251695);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_cgi_blocklist, "");
        kotlin.g.b.p.g(a2, "MMKernel.service(IExptSe…finder_cgi_blocklist, \"\")");
        AppMethodBeat.o(251695);
        return a2;
    }

    public static String dxg() {
        AppMethodBeat.i(251696);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_finder_cgi_block_limit, "200, 60, 1000, 60");
        kotlin.g.b.p.g(a2, "MMKernel.service(IExptSe…mit, \"200, 60, 1000, 60\")");
        AppMethodBeat.o(251696);
        return a2;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> hVc() {
        return UUw;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dxh() {
        return vBX;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dxi() {
        return vBY;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dxj() {
        return vBZ;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> dxk() {
        return vCa;
    }

    static final class r extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final r vCw = new r();

        static {
            AppMethodBeat.i(251560);
            AppMethodBeat.o(251560);
        }

        r() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251559);
            a.C1302a aVar = com.tencent.mm.plugin.finder.upload.action.a.vTR;
            com.tencent.mm.plugin.finder.upload.action.a.qnq = 1000;
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251559);
            return xVar;
        }
    }

    public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a hVd() {
        return UUy;
    }

    static final class e extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final e vCj = new e();

        static {
            AppMethodBeat.i(251534);
            AppMethodBeat.o(251534);
        }

        e() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251533);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_SYNC_KEYBUF2_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_INIT_KEYBUF2_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
            aAh3.azQ().set(ar.a.USERINFO_MY_FINDER_USERNAME_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
            aAh4.azQ().set(ar.a.USERINFO_MY_FINDER_NICKNAME_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh5, "MMKernel.storage()");
            aAh5.azQ().set(ar.a.USERINFO_MY_FINDER_SIGNATURE_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh6, "MMKernel.storage()");
            aAh6.azQ().set(ar.a.USERINFO_MY_FINDER_AVATAR_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh7 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh7, "MMKernel.storage()");
            aAh7.azQ().set(ar.a.USERINFO_MY_FINDER_AUTH_INFO_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh8 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh8, "MMKernel.storage()");
            aAh8.azQ().set(ar.a.USERINFO_MY_FINDER_COVER_IMG_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh9 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh9, "MMKernel.storage()");
            aAh9.azQ().set(ar.a.USERINFO_MY_FINDER_LOCAL_COVER_IMG_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh10 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh10, "MMKernel.storage()");
            aAh10.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_FLAG2_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh11 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh11, "MMKernel.storage()");
            aAh11.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_ENTRANCE2_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh12 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh12, "MMKernel.storage()");
            aAh12.azQ().set(ar.a.USERINFO_FINDER_FIRST_CREATE_USER_BOOLEAN, Boolean.FALSE);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251533);
            return xVar;
        }
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> hVe() {
        return UUz;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> hVf() {
        return UUA;
    }

    public static com.tencent.mm.plugin.finder.storage.config.item.booleantype.a hVg() {
        return UUB;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<Integer> hVh() {
        return UUC;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<String> hVi() {
        return UUD;
    }

    static final class h extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final h vCm = new h();

        static {
            AppMethodBeat.i(251540);
            AppMethodBeat.o(251540);
        }

        h() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251539);
            com.tencent.mm.plugin.finder.utils.al alVar = com.tencent.mm.plugin.finder.utils.al.waC;
            for (com.tencent.mm.plugin.finder.utils.i iVar : com.tencent.mm.plugin.finder.utils.al.waB) {
                com.tencent.mm.vfs.s.deleteDir(iVar.path);
            }
            for (com.tencent.mm.plugin.finder.utils.i iVar2 : com.tencent.mm.plugin.finder.utils.al.waB) {
                iVar2.dBE();
            }
            Log.i("Finder.Loader", "cleanFile finderAccPath:" + com.tencent.mm.plugin.finder.utils.al.dEx() + " finderImgPath:" + com.tencent.mm.plugin.finder.utils.al.war + " finderVideoPath:" + com.tencent.mm.plugin.finder.utils.al.wau + " finderCapturePath:" + com.tencent.mm.plugin.finder.utils.al.waw);
            com.tencent.mm.plugin.finder.storage.logic.d dVar = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
            boolean bnU = com.tencent.mm.plugin.finder.storage.logic.d.bnU();
            StringBuilder append = new StringBuilder("ret=[").append(bnU).append("] finderVideoPath=");
            com.tencent.mm.plugin.finder.utils.al alVar2 = com.tencent.mm.plugin.finder.utils.al.waC;
            StringBuilder append2 = append.append(com.tencent.mm.plugin.finder.utils.al.dEz()).append(" finderImgPath=");
            com.tencent.mm.plugin.finder.utils.al alVar3 = com.tencent.mm.plugin.finder.utils.al.waC;
            Log.i("FinderConfig", append2.append(com.tencent.mm.plugin.finder.utils.al.dEy()).toString());
            com.tencent.mm.ui.base.u.makeText(MMApplicationContext.getContext(), "db: ".concat(String.valueOf(bnU)), 1).show();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251539);
            return xVar;
        }
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<String> hVj() {
        return UUE;
    }

    public static com.tencent.mm.plugin.finder.storage.config.b<String> hVk() {
        return UUF;
    }

    static final class d extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final d vCi = new d();

        static {
            AppMethodBeat.i(251532);
            AppMethodBeat.o(251532);
        }

        d() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251531);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_SYNC_KEYBUF2_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_INIT_KEYBUF2_STRING_SYNC, "");
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
            aAh3.azQ().set(ar.a.USERINFO_FINDER_FIRST_CREATE_USER_BOOLEAN, Boolean.FALSE);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251531);
            return xVar;
        }
    }

    static final class a extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final a vCc = new a();

        static {
            AppMethodBeat.i(251524);
            AppMethodBeat.o(251524);
        }

        a() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251523);
            ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).closeFinderEntryForDebug();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251523);
            return xVar;
        }
    }

    static final class v extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final v vCz = new v();

        static {
            AppMethodBeat.i(251567);
            AppMethodBeat.o(251567);
        }

        v() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251566);
            FinderItem.a aVar = FinderItem.Companion;
            FinderItem.debugOnlySelfSee = true;
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251566);
            return xVar;
        }
    }

    static final class s extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final s vCx = new s();

        static {
            AppMethodBeat.i(251562);
            AppMethodBeat.o(251562);
        }

        s() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251561);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(FinderHomeTabStateVM.Mt(3), (Object) 0);
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(FinderHomeTabStateVM.Mt(1), (Object) 0);
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
            aAh3.azQ().set(FinderHomeTabStateVM.Mt(4), (Object) 0);
            com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh4, "MMKernel.storage()");
            aAh4.azQ().set(FinderHomeTabStateVM.Mt(2), (Object) 0);
            com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh5, "MMKernel.storage()");
            aAh5.azQ().set(ar.a.USERINFO_FINDER_TIP_COLLAPSIBLE_INT, (Object) 0);
            com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh6, "MMKernel.storage()");
            aAh6.azQ().set(ar.a.USERINFO_FINDER_HAS_CLICK_FAV_BOOLEAN_SYNC, Boolean.FALSE);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251561);
            return xVar;
        }
    }

    static final class as extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final as vCW = new as();

        static {
            AppMethodBeat.i(251611);
            AppMethodBeat.o(251611);
        }

        as() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251610);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_LOCAL_RED_DOT_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            ((PluginFinder) ah).getRedDotManager().Iy(-1);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251610);
            return xVar;
        }
    }

    static final class y extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final y vCC = new y();

        static {
            AppMethodBeat.i(251573);
            AppMethodBeat.o(251573);
        }

        y() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251572);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).resetCache();
            l.a aVar2 = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            l.a.clearAll();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251572);
            return xVar;
        }
    }

    static final class z extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final z vCD = new z();

        static {
            AppMethodBeat.i(251575);
            AppMethodBeat.o(251575);
        }

        z() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251574);
            ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().db.rawQuery("DELETE FROM FinderFeedItem  WHERE localFlag IN (0, 1, 2);", null, 2);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251574);
            return xVar;
        }
    }

    static final class j extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final j vCo = new j();

        static {
            AppMethodBeat.i(251544);
            AppMethodBeat.o(251544);
        }

        j() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251543);
            StringBuilder sb = new StringBuilder("clicfg_ultron_finder_search_only_contact_android: ");
            c cVar = c.vCb;
            StringBuilder append = sb.append(c.drr()).append('\n').append("clicfg_ultron_finder_show_reddot_number_attab_android:");
            c cVar2 = c.vCb;
            StringBuilder append2 = append.append(c.drs()).append('\n').append("clicfg_ultron_record_video_max_duration_android:");
            c cVar3 = c.vCb;
            StringBuilder append3 = append2.append(c.dqw().duration).append('\n').append("clicfg_ultron_record_video_min_duration_android:");
            c cVar4 = c.vCb;
            StringBuilder append4 = append3.append(c.dqw().minDuration).append('\n').append("clicfg_ultron_album_video_max_duration_android:");
            c cVar5 = c.vCb;
            StringBuilder append5 = append4.append(c.dqx().duration).append('\n').append("clicfg_ultron_album_video_min_duration_android:");
            c cVar6 = c.vCb;
            String sb2 = append5.append(c.dqx().minDuration).append('\n').append("clicfg_ultron_album_video_max_select_duration_android:").append(((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ultron_album_video_max_select_duration_android, 300)).toString();
            StringBuilder sb3 = new StringBuilder("MXM_DynaCfg_AV_Item_Key_FinderCommentTextLimit:");
            c cVar7 = c.vCb;
            StringBuilder append6 = sb3.append(c.dsz().value().intValue()).append('\n').append("MXM_DynaCfg_AV_Item_Key_FinderCommentTextLimit:");
            c cVar8 = c.vCb;
            StringBuilder append7 = append6.append(c.dsA().value().intValue()).append('\n').append("clicfg_ultron_finder_folder_size_dump_interval:");
            c cVar9 = c.vCb;
            StringBuilder append8 = append7.append(c.drh()).append('\n').append("clicfg_ultron_finder_folder_size_image:");
            c cVar10 = c.vCb;
            StringBuilder append9 = append8.append(c.drj()).append('\n').append("clicfg_ultron_finder_folder_size_avatar:");
            c cVar11 = c.vCb;
            StringBuilder append10 = append9.append(c.drk()).append('\n').append("clicfg_ultron_finder_folder_size_cropimg:");
            c cVar12 = c.vCb;
            StringBuilder append11 = append10.append(c.drl()).append('\n').append("clicfg_ultron_finder_folder_size_video:");
            c cVar13 = c.vCb;
            StringBuilder append12 = append11.append(c.drm()).append('\n').append("clicfg_ultron_finder_folder_size_tmp:");
            c cVar14 = c.vCb;
            StringBuilder append13 = append12.append(c.drn()).append('\n').append("clicfg_ultron_finder_folder_size_capture:");
            c cVar15 = c.vCb;
            StringBuilder append14 = append13.append(c.dro()).append('\n').append("clicfg_ultron_finder_folder_size_posttmp:");
            c cVar16 = c.vCb;
            append14.append(c.drp()).append('\n');
            ClipboardHelper.setText(sb2);
            com.tencent.mm.ui.base.u.makeText(MMApplicationContext.getContext(), sb2, 1).show();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251543);
            return xVar;
        }
    }

    static final class at extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final at vCX = new at();

        static {
            AppMethodBeat.i(251613);
            AppMethodBeat.o(251613);
        }

        at() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251612);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_HAS_SHOWN_GET_POST_QUALITY_TIPS_BOOLEAN_SYNC, Boolean.FALSE);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251612);
            return xVar;
        }
    }

    static final class f extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final f vCk = new f();

        static {
            AppMethodBeat.i(251536);
            AppMethodBeat.o(251536);
        }

        f() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251535);
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            com.tencent.mm.plugin.finder.utils.y.dCJ();
            com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
            com.tencent.mm.plugin.finder.utils.y.dCK();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251535);
            return xVar;
        }
    }

    static final class g extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final g vCl = new g();

        static {
            AppMethodBeat.i(251538);
            AppMethodBeat.o(251538);
        }

        g() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251537);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_HAS_ENTER_MULTI_TAB_INT_SYNC, (Object) 0);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251537);
            return xVar;
        }
    }

    static final class i extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final i vCn = new i();

        static {
            AppMethodBeat.i(251542);
            AppMethodBeat.o(251542);
        }

        i() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251541);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_SIMILAR_TIPS_SHOWN_INT_SYNC, (Object) 0);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251541);
            return xVar;
        }
    }

    /* renamed from: com.tencent.mm.plugin.finder.storage.c$c */
    static final class C1282c extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final C1282c vCh = new C1282c();

        static {
            AppMethodBeat.i(251530);
            AppMethodBeat.o(251530);
        }

        C1282c() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251529);
            f.a aVar = com.tencent.mm.plugin.finder.extension.reddot.f.tJP;
            com.tencent.mm.plugin.finder.extension.reddot.f.tJO = true;
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251529);
            return xVar;
        }
    }

    static final class p extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final p vCu = new p();

        static {
            AppMethodBeat.i(251556);
            AppMethodBeat.o(251556);
        }

        p() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251555);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_SWITCH_SCENE_TIP_INT_SYNC, (Object) 3);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251555);
            return xVar;
        }
    }

    static final class au extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final au vCY = new au();

        static {
            AppMethodBeat.i(251615);
            AppMethodBeat.o(251615);
        }

        au() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251614);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_PRIVATE_LIKE_TIPS_COUNT_INT_SYNC, (Object) 3);
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_PRIVATE_LIKE_TIPS_COUNT2_INT_SYNC, (Object) 3);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251614);
            return xVar;
        }
    }

    static final class k extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final k vCp = new k();

        static {
            AppMethodBeat.i(251546);
            AppMethodBeat.o(251546);
        }

        k() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251545);
            com.tencent.mm.plugin.finder.extension.reddot.l lVar = com.tencent.mm.plugin.finder.extension.reddot.l.tLu;
            com.tencent.mm.plugin.finder.extension.reddot.l.mU(false);
            com.tencent.mm.ui.base.u.makeText(MMApplicationContext.getContext(), "已清除全屏tab红点标记", 0).show();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251545);
            return xVar;
        }
    }

    static final class m extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final m vCr = new m();

        static {
            AppMethodBeat.i(251550);
            AppMethodBeat.o(251550);
        }

        m() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251549);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_REDDOT_DELETE_DUP_BOOLEAN_SYNC, Boolean.FALSE);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251549);
            return xVar;
        }
    }

    static final class ba extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final ba vDe = new ba();

        static {
            AppMethodBeat.i(251627);
            AppMethodBeat.o(251627);
        }

        ba() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251626);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_WXPROFILE_ENTRY_EDU_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_WXPROFILE_ENTRY_EDU2_INT_SYNC, (Object) 0);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251626);
            return xVar;
        }
    }

    static final class ar extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final ar vCV = new ar();

        static {
            AppMethodBeat.i(251609);
            AppMethodBeat.o(251609);
        }

        ar() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251608);
            c cVar = c.vCb;
            c.KV(1);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_MY_FINDER_ORIGINAL_REDDOT_FLAG2_INT_SYNC, (Object) 0);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251608);
            return xVar;
        }
    }

    static final class ao extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final ao vCS = new ao();

        static {
            AppMethodBeat.i(251605);
            AppMethodBeat.o(251605);
        }

        ao() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251604);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_MY_FINDER_LIVE_NEW_REDDOT_FLAG_INT_SYNC, (Object) 0);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251604);
            return xVar;
        }
    }

    static final class n extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final n vCs = new n();

        static {
            AppMethodBeat.i(251552);
            AppMethodBeat.o(251552);
        }

        n() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251551);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_LIVE_KNOW_LICENSE_UPDATE_INT_SYNC, (Object) 0);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251551);
            return xVar;
        }
    }

    static final class o extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final o vCt = new o();

        static {
            AppMethodBeat.i(251554);
            AppMethodBeat.o(251554);
        }

        o() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251553);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_LIVE_VERIFY_BOOLEAN_SYNC, Boolean.FALSE);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251553);
            return xVar;
        }
    }

    static final class ak extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final ak UUG = new ak();

        static {
            AppMethodBeat.i(261369);
            AppMethodBeat.o(261369);
        }

        ak() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(261368);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_LIVE_ALIAS_GUIDE_SHOW_BOOLEAN_SYNC, Boolean.FALSE);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(261368);
            return xVar;
        }
    }

    static final class ah extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final ah vCL = new ah();

        static {
            AppMethodBeat.i(251591);
            AppMethodBeat.o(251591);
        }

        ah() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251590);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_SHOW_FINDER_RECENT_LIKE_INT_SYNC, (Object) 1);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251590);
            return xVar;
        }
    }

    static final class ag extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final ag vCK = new ag();

        static {
            AppMethodBeat.i(251589);
            AppMethodBeat.o(251589);
        }

        ag() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251588);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_SHOW_FINDER_RECENT_LIKE_INT_SYNC, (Object) 0);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251588);
            return xVar;
        }
    }

    static final class ai extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final ai vCM = new ai();

        static {
            AppMethodBeat.i(251593);
            AppMethodBeat.o(251593);
        }

        ai() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251592);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_HAS_CLOSE_REDPACK_TIPS_BOOLEAN_SYNC, Boolean.FALSE);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251592);
            return xVar;
        }
    }

    static final class aj extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final aj vCN = new aj();

        static {
            AppMethodBeat.i(251595);
            AppMethodBeat.o(251595);
        }

        aj() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(251594);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_HAS_ENTER_REDPACK_MINI_APP_BOOLEAN_SYNC, Boolean.FALSE);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(251594);
            return xVar;
        }
    }

    static final class bh extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final bh UUK = new bh();

        static {
            AppMethodBeat.i(261377);
            AppMethodBeat.o(261377);
        }

        bh() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(261376);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_HAS_ENTER_REDPACK_MINI_APP_BOOLEAN_SYNC, Boolean.FALSE);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(261376);
            return xVar;
        }
    }

    static final class be extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final be UUH = new be();

        static {
            AppMethodBeat.i(261371);
            AppMethodBeat.o(261371);
        }

        be() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(261370);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_LIVE_LUCKY_MONEY_GUIDE_INT_SYNC, (Object) 0);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(261370);
            return xVar;
        }
    }

    static final class bf extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final bf UUI = new bf();

        static {
            AppMethodBeat.i(261373);
            AppMethodBeat.o(261373);
        }

        bf() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(261372);
            ((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).createLuckyMoneyLive(MMApplicationContext.getContext(), "21029574718@chatroom");
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(261372);
            return xVar;
        }
    }

    static final class bg extends kotlin.g.b.q implements kotlin.g.a.b<Activity, kotlin.x> {
        public static final bg UUJ = new bg();

        static {
            AppMethodBeat.i(261375);
            AppMethodBeat.o(261375);
        }

        bg() {
            super(1);
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Activity activity) {
            AppMethodBeat.i(261374);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            aAh.azQ().set(ar.a.USERINFO_FINDER_LIVE_SHOW_FIDNER_ACCOUNT_CONFIRM_INT_SYNC, (Object) 0);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(261374);
            return xVar;
        }
    }
}
