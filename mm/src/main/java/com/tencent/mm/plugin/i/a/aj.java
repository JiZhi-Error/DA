package com.tencent.mm.plugin.i.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.mm.plugin.i.a.af;
import java.util.List;
import java.util.Map;

public interface aj extends com.tencent.mm.kernel.b.a {

    public interface a {
        void e(Map<Long, Integer> map, int i2);
    }

    public interface b {
        void a(long j2, int i2, Object obj);
    }

    void batchGetLiveStatus(List<Pair<Long, String>> list, a aVar);

    boolean canEnterMvAndShowToast();

    void checkInsertLiveNewReddot();

    void checkLastLiveObject();

    void cleatLiveStatusCache(Long l);

    void createLuckyMoneyLive(Context context, String str);

    void dumpAndMarkFinderFolder();

    void enterAlbumRelatedTimelineUI(Context context, Intent intent);

    void enterFinderActivityProfileUI(Context context, Intent intent);

    void enterFinderConversationUI(Context context);

    void enterFinderLbsLiveFriendsUI(Context context, Intent intent);

    void enterFinderLiveAnchorUI(Context context, long j2, Long l, String str, String str2, String str3, String str4, String str5);

    void enterFinderLiveInvitedUI(Context context, String str, String str2, String str3, String str4, String str5);

    void enterFinderLiveVisitorUI(Context context, long j2, Long l, String str, String str2, String str3, String str4, String str5, String str6, int i2);

    void enterFinderPoiFeedUI(Context context, Intent intent);

    void enterFinderPostRouterUI(Context context, Intent intent);

    void enterFinderProfileUI(Context context, Intent intent);

    void enterFinderSelfProfile(Context context, Intent intent, int i2, int i3);

    void enterFinderShareFeedUI(Context context, Intent intent);

    void enterFinderShareFeedUI(Context context, String str, Intent intent);

    void enterFinderTimelineUI(Context context, Intent intent);

    void enterFinderTimelineUI(Context context, Intent intent, Boolean bool);

    void enterFinderTopicUI(Context context, Intent intent);

    void enterFinderUI(Context context, String str);

    void enterFinderUIFromMiniApp(Context context, String str, af.a<Object> aVar, af.a<Integer> aVar2);

    String fillContextIdToIntent(int i2, int i3, int i4, Intent intent);

    String fillContextIdToIntent(String str, Intent intent);

    void forcestopCurLive();

    String genContextId(int i2, int i3, int i4);

    ap getFinderOpenSdkApi();

    ac getFinderSwitchApi();

    ae getFinderUIApi();

    af getFinderUtilApi();

    void getLiveInfo(Long l, b bVar);

    z getRedDotManager();

    int getTimelineCommentScene();

    boolean hasFinderPosted();

    boolean isAllowEditFillingFullScreen();

    boolean isAnchorLiving();

    boolean isDisablePostHalfScreen();

    boolean isVisitorLiving();

    void loadAvatar(String str, ImageView imageView);

    void loadImage(String str, ImageView imageView);

    void loadImageForSns(String str, View view);

    void openChannelsCreateContact(Activity activity, af.a<Boolean> aVar);

    void openChannelsPostPage(Activity activity);

    void refreshLiveStatus(Long l, b bVar);

    void report21053(View view, BaseAdapter baseAdapter, int i2, int i3, int i4, long j2, String str, int i5, boolean z);

    void report21053OnClick(long j2, long j3, String str, int i2, int i3, long j4, String str2, int i4, int i5, String str3, String str4, long j5, int i6);

    void report21053OnClickOnSnsAd(long j2, long j3, String str, long j4);

    void reportGiftOnReturn();

    void reportPostRedDot(int i2);

    void sdkShare(String str, String str2, String str3);

    void shareStatsReport(List<Pair<String, String>> list, boolean z);

    boolean showFinderEntry();

    boolean showPostEntry();

    void snsToFinderPostReport(String str, int i2, String str2, int i3, int i4, int i5, long j2, long j3, long j4, int i6);

    Object tryGetFinderObject(long j2, String str, int i2);
}
