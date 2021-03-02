package com.tencent.mm.plugin.finder.utils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.report.q;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.g.r;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axf;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bcg;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.bcl;
import com.tencent.mm.protocal.protobuf.bcu;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil;", "", "Companion", "plugin-finder_release"})
public interface s {
    public static final a vWt = a.vWu;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012JL\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\fJ\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u001e2\b\b\u0002\u0010#\u001a\u00020$JJ\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\f2\u0006\u0010(\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\f2\b\u0010*\u001a\u0004\u0018\u00010\f2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010\f2\b\u0010.\u001a\u0004\u0018\u00010/J\u0018\u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\b\b\u0002\u0010#\u001a\u00020$J \u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010\u0011\u001a\u00020\u0012J \u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010:\u001a\u0004\u0018\u00010;J \u0010<\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010=\u001a\u00020>2\b\u0010:\u001a\u0004\u0018\u00010;J.\u0010?\u001a\u0002052\u0006\u00106\u001a\u00020@2\u0006\u0010\"\u001a\u00020\u001e2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020\u0004H\u0002J\"\u0010D\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010E\u001a\u00020F2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010BJ]\u0010G\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010\"\u001a\u00020\u001e2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B29\b\u0002\u0010H\u001a3\u0012'\u0012%\u0012\u0004\u0012\u00020\f\u0018\u00010Jj\n\u0012\u0004\u0012\u00020\f\u0018\u0001`K¢\u0006\f\bL\u0012\b\bM\u0012\u0004\b\b(N\u0012\u0004\u0012\u000205\u0018\u00010IJ.\u0010O\u001a\u0002052\u0006\u00106\u001a\u00020@2\u0006\u0010\"\u001a\u00020\u001e2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020\u0004H\u0002J,\u0010P\u001a\u0002052\u0006\u00106\u001a\u00020@2\u0006\u0010\u001d\u001a\u00020Q2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u0004H\u0002J*\u0010R\u001a\u0002052\u0006\u00106\u001a\u00020@2\u0006\u0010\u001d\u001a\u00020Q2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u0004J,\u0010S\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00102\u001a\u0002032\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020\u0004J,\u0010T\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010\u001d\u001a\u00020U2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020\u0004J\u001e\u0010V\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\fJ,\u0010Z\u001a\u0002052\u0006\u00106\u001a\u00020@2\u0006\u0010\"\u001a\u00020\u001e2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020\u0004J6\u0010[\u001a\u0002052\u0006\u00106\u001a\u00020@2\u0006\u0010\u001d\u001a\u00020Q2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u0004J6\u0010]\u001a\u0002052\u0006\u00106\u001a\u00020^2\u0006\u0010\u001d\u001a\u00020Q2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010C\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u0004H\u0002J\u0006\u0010_\u001a\u000205J6\u0010`\u001a\u0002052\u0006\u00106\u001a\u00020@2\u0006\u0010\u001d\u001a\u00020Q2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010B2\b\b\u0002\u0010C\u001a\u00020\u00042\b\b\u0002\u0010\\\u001a\u00020\u0004Jd\u0010a\u001a\u0002052\u0006\u00106\u001a\u0002072\b\u0010'\u001a\u0004\u0018\u00010\f2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010b\u001a\u00020c2\b\u0010)\u001a\u0004\u0018\u00010\f2\b\u0010*\u001a\u0004\u0018\u00010\f2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010d\u001a\u00020\u00042\b\u0010e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/Jd\u0010f\u001a\u0002052\u0006\u00106\u001a\u0002072\b\u0010'\u001a\u0004\u0018\u00010\f2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010b\u001a\u00020c2\b\u0010)\u001a\u0004\u0018\u00010\f2\b\u0010*\u001a\u0004\u0018\u00010\f2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010d\u001a\u00020\u00042\b\u0010e\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\fXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006g"}, hxF = {"Lcom/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion;", "", "()V", "REQUEST_CODE_SHARE_FEED_TO_CHAT", "", "REQUEST_CODE_SHARE_FEED_TO_SNS", "REQUEST_CODE_SHARE_LIVE_INVITE_TO_CHAT", "REQUEST_CODE_SHARE_LIVE_TO_CHAT", "REQUEST_CODE_SHARE_LIVE_TO_SNS", "REQUEST_CODE_SHARE_NAMECARD_TO_CAHT", "REQUEST_CODE_SHARE_VIDEO_FILE_TO_CHAT", "TAG", "", "getTAG", "()Ljava/lang/String;", "genFinderShareAlbum", "Lcom/tencent/mm/protocal/protobuf/FinderShareAlbum;", "card", "Lcom/tencent/mm/protocal/protobuf/FinderStreamCard;", "cardId", "title", "subTitle", "urls", "", "urlTokens", "cardBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getFavEventInfo", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "feed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "thumbPath", "getFinderShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderShareObject;", "feedObject", "isShareSns", "", "getFinderTopic", "Lcom/tencent/mm/protocal/protobuf/FinderShareTopic;", "topic", "topicType", "iconUrl", "desc", "poiLocation", "Lcom/tencent/mm/protocal/protobuf/FinderLocation;", "patMusicId", "activityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderActivityEvent;", "getMegaVideoShareObject", "Lcom/tencent/mm/protocal/protobuf/MegaVideoShareObject;", "finderMegaVideo", "Lcom/tencent/mm/protocal/protobuf/FinderMegaVideo;", "shareAlbumToConversation", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "objectContent", "Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderAlbum;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "shareAlbumToSnsTimeLine", "snsShare", "Lcom/tencent/mm/modelsns/SnsFinderShareAlbum;", "shareFeedToConversation", "Landroid/support/v7/app/AppCompatActivity;", "param", "Landroid/os/Bundle;", "shareType", "shareFinderContactToConversation", "contact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "shareInvitingLiveToConversation", "callback", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/ParameterName;", "name", "avatar", "shareLiveToConversation", "shareLiveToSnsTimeLineInternal", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "shareLiveToStatusInternal", "shareMegaVideoToConversation", "shareMegaVideoToSnsTimeLine", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "sharePoiFeedToConversation", FirebaseAnalytics.b.LOCATION, "Lcom/tencent/mm/protocal/protobuf/SnsLocation;", "poiCategories", "shareToConversation", "shareToSnsTimeLine", "postFromSnsType", "shareToSnsTimeLineInternal", "Lcom/tencent/mm/ui/MMFragmentActivity;", "shareToStatusInternal", "shareToStatusTimeLine", "shareTopicToConversation", "totalCount", "", "scene", "followId", "shareTopicToSnsTimeLine", "plugin-finder_release"})
    public static final class a {
        private static final String TAG = TAG;
        static final /* synthetic */ a vWu = new a();

        static {
            AppMethodBeat.i(167909);
            AppMethodBeat.o(167909);
        }

        private a() {
        }

        public static String getTAG() {
            return TAG;
        }

        public static /* synthetic */ void a(a aVar, AppCompatActivity appCompatActivity, FinderItem finderItem, int i2, int i3) {
            AppMethodBeat.i(253505);
            if ((i3 & 8) != 0) {
                i2 = 1;
            }
            aVar.a(appCompatActivity, finderItem, i2);
            AppMethodBeat.o(253505);
        }

        public final void a(AppCompatActivity appCompatActivity, FinderItem finderItem, int i2) {
            AppMethodBeat.i(253504);
            p.h(appCompatActivity, "context");
            p.h(finderItem, "feedObject");
            switch (finderItem.getMediaType()) {
                case 9:
                    a(appCompatActivity, finderItem);
                    AppMethodBeat.o(253504);
                    return;
                default:
                    b(appCompatActivity, finderItem, i2);
                    AppMethodBeat.o(253504);
                    return;
            }
        }

        private final void a(AppCompatActivity appCompatActivity, FinderItem finderItem) {
            Long l2;
            Integer num;
            AppMethodBeat.i(253506);
            y yVar = y.vXH;
            if (!y.u(finderItem.getFeedObject())) {
                y yVar2 = y.vXH;
                String string = appCompatActivity.getString(R.string.d61);
                p.g(string, "context.getString(R.stri…finder_private_ban_share)");
                y.aF(appCompatActivity, string);
                AppMethodBeat.o(253506);
                return;
            }
            String str = TAG;
            StringBuilder append = new StringBuilder("share live  ").append(finderItem.getId()).append(' ');
            FinderObject feedObject = finderItem.getFeedObject();
            StringBuilder append2 = append.append((feedObject != null ? Integer.valueOf(feedObject.forward_style) : null).intValue()).append(" to conversation,liveId:");
            awe liveInfo = finderItem.getLiveInfo();
            if (liveInfo != null) {
                l2 = Long.valueOf(liveInfo.liveId);
            } else {
                l2 = null;
            }
            StringBuilder append3 = append2.append(l2).append(",desc:").append(finderItem.getDescription()).append(",liveStatus ");
            awe liveInfo2 = finderItem.getLiveInfo();
            if (liveInfo2 != null) {
                num = Integer.valueOf(liveInfo2.liveStatus);
            } else {
                num = null;
            }
            Log.i(str, append3.append(num).toString());
            k.b bVar = new k.b();
            com.tencent.mm.plugin.i.a.b bVar2 = new com.tencent.mm.plugin.i.a.b();
            bVar2.b(finderItem.getFinderLive());
            bVar.a(bVar2);
            bVar.type = 63;
            bVar.title = MMApplicationContext.getContext().getString(R.string.enf);
            bVar.url = MMApplicationContext.getContext().getString(R.string.eng);
            Intent intent = new Intent();
            intent.putExtra("Retr_Msg_Type", 23);
            intent.putExtra("Multi_Retr", true);
            intent.putExtra("Retr_Msg_content", k.b.a(bVar, null, null));
            intent.putExtra("Retr_go_to_chattingUI", false);
            intent.putExtra("Retr_show_success_tips", true);
            if (appCompatActivity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                AppMethodBeat.o(253506);
                throw tVar;
            }
            com.tencent.mm.br.c.a((MMFragmentActivity) appCompatActivity, ".ui.transmit.MsgRetransmitUI", intent, 1005, new g(this, finderItem));
            AppMethodBeat.o(253506);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
        public static final class g implements MMFragmentActivity.b {
            final /* synthetic */ FinderItem vST;
            final /* synthetic */ a vWv;

            g(a aVar, FinderItem finderItem) {
                this.vWv = aVar;
                this.vST = finderItem;
            }

            @Override // com.tencent.mm.ui.MMFragmentActivity.b
            public final void d(int i2, int i3, Intent intent) {
                boolean z;
                String str;
                AppMethodBeat.i(253498);
                new ArrayList();
                if (i3 == -1) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("SendMsgUsernames");
                    p.g(stringArrayListExtra, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
                    Log.i(a.getTAG(), "share finderObject %d to %s", Long.valueOf(this.vST.getId()), stringArrayListExtra);
                    if (!stringArrayListExtra.isEmpty()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        String str2 = "";
                        JSONObject jSONObject = new JSONObject();
                        Iterator<String> it = stringArrayListExtra.iterator();
                        while (true) {
                            str = str2;
                            if (!it.hasNext()) {
                                break;
                            }
                            str2 = str + it.next() + ';';
                        }
                        if (n.nm(str, ";")) {
                            int length = str.length() - 1;
                            if (str == null) {
                                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                                AppMethodBeat.o(253498);
                                throw tVar;
                            }
                            str = str.substring(0, length);
                            p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        }
                        jSONObject.put("1", str);
                        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_SHARE, jSONObject.toString());
                        AppMethodBeat.o(253498);
                        return;
                    }
                } else {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "");
                    com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_SHARE, jSONObject2.toString());
                }
                AppMethodBeat.o(253498);
            }
        }

        public static /* synthetic */ void a(a aVar, MMActivity mMActivity, FinderItem finderItem, kotlin.g.a.b bVar) {
            AppMethodBeat.i(253507);
            p.h(mMActivity, "context");
            p.h(finderItem, "feedObject");
            String str = TAG;
            StringBuilder append = new StringBuilder("share live inviting ").append(finderItem.getId()).append(' ');
            FinderObject feedObject = finderItem.getFeedObject();
            StringBuilder append2 = append.append((feedObject != null ? Integer.valueOf(feedObject.forward_style) : null).intValue()).append(" to conversation,liveId:");
            awe liveInfo = finderItem.getLiveInfo();
            StringBuilder append3 = append2.append(liveInfo != null ? Long.valueOf(liveInfo.liveId) : null).append(",desc:").append(finderItem.getDescription()).append("liveStatus ");
            awe liveInfo2 = finderItem.getLiveInfo();
            Log.i(str, append3.append(liveInfo2 != null ? Integer.valueOf(liveInfo2.liveStatus) : null).toString());
            k.b bVar2 = new k.b();
            com.tencent.mm.plugin.i.a.a aVar2 = new com.tencent.mm.plugin.i.a.a();
            axf finderLive = finderItem.getFinderLive();
            p.h(finderLive, "<set-?>");
            aVar2.wDV = finderLive;
            bVar2.a(aVar2);
            bVar2.type = 65;
            bVar2.title = MMApplicationContext.getContext().getString(R.string.enf);
            bVar2.url = MMApplicationContext.getContext().getString(R.string.eng);
            Intent intent = new Intent();
            intent.putExtra("Retr_Msg_Type", 24);
            intent.putExtra("Multi_Retr", true);
            intent.putExtra("Retr_Msg_content", k.b.a(bVar2, null, null));
            intent.putExtra("Retr_go_to_chattingUI", false);
            intent.putExtra("Retr_show_success_tips", true);
            intent.addFlags(268435456);
            com.tencent.mm.br.c.a(mMActivity, ".ui.transmit.MsgRetransmitUI", intent, 1007, new f(aVar, finderItem, bVar));
            AppMethodBeat.o(253507);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
        public static final class f implements MMActivity.a {
            final /* synthetic */ kotlin.g.a.b gWe;
            final /* synthetic */ FinderItem vST;
            final /* synthetic */ a vWv;

            f(a aVar, FinderItem finderItem, kotlin.g.a.b bVar) {
                this.vWv = aVar;
                this.vST = finderItem;
                this.gWe = bVar;
            }

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(253497);
                ArrayList<String> arrayList = new ArrayList<>();
                if (i3 == -1) {
                    arrayList = intent.getStringArrayListExtra("SendMsgUsernames");
                    p.g(arrayList, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
                    Log.i(a.getTAG(), "share finderObject %d to %s", Long.valueOf(this.vST.getId()), arrayList);
                }
                kotlin.g.a.b bVar = this.gWe;
                if (bVar != null) {
                    bVar.invoke(arrayList);
                    AppMethodBeat.o(253497);
                    return;
                }
                AppMethodBeat.o(253497);
            }
        }

        private final void b(AppCompatActivity appCompatActivity, FinderItem finderItem, int i2) {
            AppMethodBeat.i(253508);
            y yVar = y.vXH;
            if (!y.u(finderItem.getFeedObject())) {
                y yVar2 = y.vXH;
                String string = appCompatActivity.getString(R.string.d61);
                p.g(string, "context.getString(R.stri…finder_private_ban_share)");
                y.aF(appCompatActivity, string);
                AppMethodBeat.o(253508);
                return;
            }
            Log.i(TAG, "shareToConversation, id:" + finderItem.getId() + ", pflag:" + finderItem.getFeedObject().permissionFlag);
            if (finderItem.getFeedObject().privateFlag == 1) {
                u.a(appCompatActivity, appCompatActivity.getString(R.string.d67), c.vWy);
                AppMethodBeat.o(253508);
                return;
            }
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1278, 11, 1, false);
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            if (com.tencent.mm.plugin.finder.spam.a.avp("share")) {
                AppMethodBeat.o(253508);
                return;
            }
            z.f fVar = new z.f();
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            fVar.SYG = (T) ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(appCompatActivity).get(FinderReporterUIC.class)).dIx();
            k.b bVar = new k.b();
            com.tencent.mm.plugin.i.a.f fVar2 = new com.tencent.mm.plugin.i.a.f();
            fVar2.a(x(finderItem));
            bVar.a(fVar2);
            bVar.type = 51;
            bVar.title = MMApplicationContext.getContext().getString(R.string.enf);
            bVar.url = MMApplicationContext.getContext().getString(R.string.eng);
            Intent intent = new Intent();
            intent.putExtra("Retr_Msg_Type", 18);
            intent.putExtra("Multi_Retr", true);
            intent.putExtra("Retr_Msg_content", k.b.a(bVar, null, null));
            intent.putExtra("Retr_go_to_chattingUI", false);
            intent.putExtra("Retr_show_success_tips", true);
            if (appCompatActivity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                AppMethodBeat.o(253508);
                throw tVar;
            }
            com.tencent.mm.br.c.a((MMFragmentActivity) appCompatActivity, ".ui.transmit.MsgRetransmitUI", intent, 1001, new d(this, finderItem, appCompatActivity, i2, fVar));
            AppMethodBeat.o(253508);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
        public static final class c implements u.b {
            public static final c vWy = new c();

            static {
                AppMethodBeat.i(253495);
                AppMethodBeat.o(253495);
            }

            c() {
            }

            @Override // com.tencent.mm.ui.base.u.b
            public final void dU(View view) {
                TextView textView;
                AppMethodBeat.i(253494);
                if (view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null) {
                    AppMethodBeat.o(253494);
                    return;
                }
                textView.setTextSize(1, 14.0f);
                AppMethodBeat.o(253494);
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
        public static final class d implements MMFragmentActivity.b {
            final /* synthetic */ FinderItem vST;
            final /* synthetic */ z.f vWA;
            final /* synthetic */ a vWv;
            final /* synthetic */ int vWz;
            final /* synthetic */ AppCompatActivity vao;

            d(a aVar, FinderItem finderItem, AppCompatActivity appCompatActivity, int i2, z.f fVar) {
                this.vWv = aVar;
                this.vST = finderItem;
                this.vao = appCompatActivity;
                this.vWz = i2;
                this.vWA = fVar;
            }

            @Override // com.tencent.mm.ui.MMFragmentActivity.b
            public final void d(int i2, int i3, Intent intent) {
                ArrayList<String> arrayList;
                long j2;
                AppMethodBeat.i(253496);
                ArrayList<String> arrayList2 = new ArrayList<>();
                if (i3 == -1) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("SendMsgUsernames");
                    p.g(stringArrayListExtra, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
                    Log.i(a.getTAG(), "share finderObject %d to %s", Long.valueOf(this.vST.getId()), stringArrayListExtra);
                    if (!stringArrayListExtra.isEmpty()) {
                        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                        com.tencent.mm.plugin.finder.event.a b2 = FinderReporterUIC.b((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.vao).get(FinderReporterUIC.class));
                        if (b2 != null) {
                            b2.cZR().Eh(this.vST.getId());
                            arrayList = stringArrayListExtra;
                        } else {
                            arrayList = stringArrayListExtra;
                        }
                    } else {
                        arrayList = stringArrayListExtra;
                    }
                } else {
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    com.tencent.mm.plugin.finder.event.a b3 = FinderReporterUIC.b((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.vao).get(FinderReporterUIC.class));
                    if (b3 != null) {
                        b3.cZR().Ej(this.vST.getId());
                        arrayList = arrayList2;
                    } else {
                        arrayList = arrayList2;
                    }
                }
                if (i3 == -1) {
                    j2 = 1;
                } else {
                    j2 = 2;
                }
                if (this.vST.getFromType() == 32768) {
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    bm bmVar = new bm(this.vST.getFeedObject());
                    int i4 = this.vWz;
                    String listToString = Util.listToString(arrayList, ";");
                    p.g(listToString, "Util.listToString(toUsers, \";\")");
                    com.tencent.mm.plugin.finder.report.k.a(bmVar, i4, j2, listToString, this.vWA.SYG, (long) arrayList.size());
                    AppMethodBeat.o(253496);
                    return;
                }
                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                long id = this.vST.getId();
                int i5 = this.vWz;
                String listToString2 = Util.listToString(arrayList, ";");
                p.g(listToString2, "Util.listToString(toUsers, \";\")");
                com.tencent.mm.plugin.finder.report.k.a(id, i5, j2, listToString2, this.vWA.SYG, (long) arrayList.size(), (FinderItem) null, 64);
                AppMethodBeat.o(253496);
            }
        }

        public static /* synthetic */ void a(AppCompatActivity appCompatActivity, BaseFinderFeed baseFinderFeed, int i2, int i3, int i4) {
            Long l2;
            Integer num;
            AppMethodBeat.i(253509);
            if ((i4 & 8) != 0) {
                i2 = 2;
            }
            if ((i4 & 16) != 0) {
                i3 = 0;
            }
            p.h(appCompatActivity, "context");
            p.h(baseFinderFeed, "feed");
            switch (baseFinderFeed.feedObject.getMediaType()) {
                case 9:
                    y yVar = y.vXH;
                    if (!y.u(baseFinderFeed.feedObject.getFeedObject())) {
                        y yVar2 = y.vXH;
                        String string = appCompatActivity.getString(R.string.d61);
                        p.g(string, "context.getString(R.stri…finder_private_ban_share)");
                        y.aF(appCompatActivity, string);
                        AppMethodBeat.o(253509);
                        return;
                    }
                    String str = TAG;
                    StringBuilder sb = new StringBuilder("share finderObject %d %d to sns,liveId:");
                    awe liveInfo = baseFinderFeed.feedObject.getLiveInfo();
                    if (liveInfo != null) {
                        l2 = Long.valueOf(liveInfo.liveId);
                    } else {
                        l2 = null;
                    }
                    StringBuilder append = sb.append(l2).append(",desc:").append(baseFinderFeed.feedObject.getDescription()).append(",liveStatus:");
                    awe liveInfo2 = baseFinderFeed.feedObject.getLiveInfo();
                    if (liveInfo2 != null) {
                        num = Integer.valueOf(liveInfo2.liveStatus);
                    } else {
                        num = null;
                    }
                    String sb2 = append.append(num).append(' ').toString();
                    Object[] objArr = new Object[2];
                    objArr[0] = Long.valueOf(baseFinderFeed.feedObject.getId());
                    FinderObject feedObject = baseFinderFeed.feedObject.getFeedObject();
                    objArr[1] = feedObject != null ? Integer.valueOf(feedObject.forward_style) : null;
                    Log.i(str, sb2, objArr);
                    Intent intent = new Intent();
                    com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                    dVar.a(baseFinderFeed.feedObject.getFinderLive());
                    intent.putExtra("ksnsupload_finder_live_xml", dVar.bfF());
                    intent.putExtra("Ksnsupload_type", 21);
                    intent.putExtra("need_result", true);
                    if (appCompatActivity == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                        AppMethodBeat.o(253509);
                        throw tVar;
                    }
                    com.tencent.mm.br.c.a((MMFragmentActivity) appCompatActivity, ".plugin.sns.ui.SnsUploadUI", intent, 1006, new h(appCompatActivity, baseFinderFeed));
                    AppMethodBeat.o(253509);
                    return;
                default:
                    MMFragmentActivity mMFragmentActivity = (MMFragmentActivity) appCompatActivity;
                    y yVar3 = y.vXH;
                    if (!y.u(baseFinderFeed.feedObject.getFeedObject())) {
                        y yVar4 = y.vXH;
                        String string2 = mMFragmentActivity.getString(R.string.d61);
                        p.g(string2, "context.getString(R.stri…finder_private_ban_share)");
                        y.aF(mMFragmentActivity, string2);
                        AppMethodBeat.o(253509);
                        return;
                    } else if (baseFinderFeed.feedObject.isPrivate()) {
                        u.a(mMFragmentActivity, mMFragmentActivity.getString(R.string.d67), j.vWC);
                        AppMethodBeat.o(253509);
                        return;
                    } else {
                        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1278, 12, 1, false);
                        com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
                        if (!com.tencent.mm.plugin.finder.spam.a.avp("share")) {
                            String str2 = TAG;
                            String str3 = "share finderObject %d %d to sns, pflag:" + baseFinderFeed.feedObject.getFeedObject().permissionFlag + ' ';
                            Object[] objArr2 = new Object[2];
                            objArr2[0] = Long.valueOf(baseFinderFeed.feedObject.getId());
                            FinderObject feedObject2 = baseFinderFeed.feedObject.getFeedObject();
                            objArr2[1] = feedObject2 != null ? Integer.valueOf(feedObject2.forward_style) : null;
                            Log.i(str2, str3, objArr2);
                            z.f fVar = new z.f();
                            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                            fVar.SYG = (T) ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(mMFragmentActivity).get(FinderReporterUIC.class)).dIx();
                            Intent intent2 = new Intent();
                            com.tencent.mm.modelsns.e eVar = new com.tencent.mm.modelsns.e();
                            eVar.jlg = c(baseFinderFeed.feedObject, true);
                            intent2.putExtra("ksnsupload_finder_object_xml", eVar.bfF());
                            intent2.putExtra("Ksnsupload_type", 17);
                            intent2.putExtra("need_result", true);
                            intent2.putExtra("finder_post_from_sns_type", i3);
                            if (i2 == 5) {
                                intent2.putExtra("finder_feed_id", baseFinderFeed.feedObject.getId());
                                intent2.putExtra("ksnsupload_finder_need_report", true);
                                q qVar = q.vgE;
                                fVar.SYG.sessionId = q.dot();
                            }
                            com.tencent.mm.br.c.a(mMFragmentActivity, ".plugin.sns.ui.SnsUploadUI", intent2, 1002, new k(mMFragmentActivity, baseFinderFeed, i2, fVar));
                        }
                        AppMethodBeat.o(253509);
                        return;
                    }
            }
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
        public static final class j implements u.b {
            public static final j vWC = new j();

            static {
                AppMethodBeat.i(253502);
                AppMethodBeat.o(253502);
            }

            j() {
            }

            @Override // com.tencent.mm.ui.base.u.b
            public final void dU(View view) {
                TextView textView;
                AppMethodBeat.i(253501);
                if (view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null) {
                    AppMethodBeat.o(253501);
                    return;
                }
                textView.setTextSize(1, 14.0f);
                AppMethodBeat.o(253501);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareToSnsTimeLineInternal$2", "Lcom/tencent/mm/ui/MMFragmentActivity$IMMOnFragmentActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
        public static final class k implements MMFragmentActivity.b {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ z.f vWA;
            final /* synthetic */ MMFragmentActivity vWD;
            final /* synthetic */ int vWz;

            k(MMFragmentActivity mMFragmentActivity, BaseFinderFeed baseFinderFeed, int i2, z.f fVar) {
                this.vWD = mMFragmentActivity;
                this.tEM = baseFinderFeed;
                this.vWz = i2;
                this.vWA = fVar;
            }

            @Override // com.tencent.mm.ui.MMFragmentActivity.b
            public final void d(int i2, int i3, Intent intent) {
                long j2;
                AppMethodBeat.i(253503);
                if (i3 == -1) {
                    com.tencent.mm.ui.base.h.cA(this.vWD, this.vWD.getString(R.string.z0));
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    com.tencent.mm.plugin.finder.event.a b2 = FinderReporterUIC.b((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.vWD).get(FinderReporterUIC.class));
                    if (b2 != null) {
                        b2.cZR().Ei(this.tEM.lT());
                    }
                } else {
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    com.tencent.mm.plugin.finder.event.a b3 = FinderReporterUIC.b((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.vWD).get(FinderReporterUIC.class));
                    if (b3 != null) {
                        b3.cZR().Ek(this.tEM.lT());
                    }
                }
                if (i3 == -1) {
                    j2 = 1;
                } else {
                    j2 = 2;
                }
                if (this.tEM.feedObject.getFromType() == 32768) {
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    com.tencent.mm.plugin.finder.report.k.a(new bm(this.tEM.feedObject.getFeedObject()), this.vWz, j2, "", this.vWA.SYG);
                    AppMethodBeat.o(253503);
                    return;
                }
                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a(this.tEM.feedObject.getId(), this.vWz, j2, "", this.vWA.SYG, 0, this.tEM.feedObject, 32);
                AppMethodBeat.o(253503);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareLiveToSnsTimeLineInternal$1", "Lcom/tencent/mm/ui/MMFragmentActivity$IMMOnFragmentActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
        public static final class h implements MMFragmentActivity.b {
            final /* synthetic */ BaseFinderFeed tEM;
            final /* synthetic */ AppCompatActivity vao;

            h(AppCompatActivity appCompatActivity, BaseFinderFeed baseFinderFeed) {
                this.vao = appCompatActivity;
                this.tEM = baseFinderFeed;
            }

            @Override // com.tencent.mm.ui.MMFragmentActivity.b
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(253499);
                if (i3 == -1) {
                    com.tencent.mm.ui.base.h.cA(this.vao, this.vao.getString(R.string.z0));
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    com.tencent.mm.plugin.finder.event.a b2 = FinderReporterUIC.b((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.vao).get(FinderReporterUIC.class));
                    if (b2 != null) {
                        b2.cZR().Ei(this.tEM.lT());
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("2", "");
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_SHARE, jSONObject.toString());
                    AppMethodBeat.o(253499);
                    return;
                }
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                com.tencent.mm.plugin.finder.event.a b3 = FinderReporterUIC.b((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.vao).get(FinderReporterUIC.class));
                if (b3 != null) {
                    b3.cZR().Ek(this.tEM.lT());
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("4", "");
                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_SHARE, jSONObject2.toString());
                AppMethodBeat.o(253499);
            }
        }

        public static /* synthetic */ void a(a aVar, MMActivity mMActivity, com.tencent.mm.plugin.finder.api.g gVar) {
            String str;
            String str2;
            AppMethodBeat.i(253510);
            p.h(mMActivity, "context");
            p.h(gVar, "contact");
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1278, 13, 1, false);
            com.tencent.mm.plugin.finder.spam.a aVar2 = com.tencent.mm.plugin.finder.spam.a.vwk;
            if (!com.tencent.mm.plugin.finder.spam.a.avp("share")) {
                if ((gVar.field_extFlag & 1048576) > 0) {
                    Log.i(TAG, "shareFinderContactToConversation: forbid share contact, nickname=" + gVar.getNickname());
                    AppMethodBeat.o(253510);
                    return;
                }
                z.d dVar = new z.d();
                com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                dVar.SYE = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(mMActivity).get(FinderReporterUIC.class)).tCE;
                k.b bVar = new k.b();
                com.tencent.mm.plugin.i.a.e eVar = new com.tencent.mm.plugin.i.a.e();
                eVar.setUsername(gVar.getUsername());
                String nullAsNil = Util.nullAsNil(gVar.getNickname());
                p.g(nullAsNil, "Util.nullAsNil(contact.getNickname())");
                eVar.setNickname(nullAsNil);
                String nullAsNil2 = Util.nullAsNil(gVar.cXH());
                p.g(nullAsNil2, "Util.nullAsNil(contact.getAvatarUrl())");
                eVar.setAvatar(nullAsNil2);
                FinderAuthInfo finderAuthInfo = gVar.field_authInfo;
                eVar.ML(finderAuthInfo != null ? finderAuthInfo.authIconType : 0);
                FinderAuthInfo finderAuthInfo2 = gVar.field_authInfo;
                if (finderAuthInfo2 == null || (str = finderAuthInfo2.authProfession) == null) {
                    str = "";
                }
                eVar.axa(str);
                FinderAuthInfo finderAuthInfo3 = gVar.field_authInfo;
                if (finderAuthInfo3 == null || (str2 = finderAuthInfo3.authIconUrl) == null) {
                    str2 = "";
                }
                eVar.axb(str2);
                bVar.a(eVar);
                bVar.type = 50;
                bVar.title = MMApplicationContext.getContext().getString(R.string.enf);
                bVar.url = MMApplicationContext.getContext().getString(R.string.eng);
                Intent intent = new Intent();
                intent.putExtra("Retr_Msg_Type", 20);
                intent.putExtra("Multi_Retr", true);
                intent.putExtra("Retr_Msg_content", k.b.a(bVar, null, null));
                intent.putExtra("Retr_go_to_chattingUI", false);
                intent.putExtra("Retr_show_success_tips", true);
                com.tencent.mm.br.c.a(mMActivity, ".ui.transmit.MsgRetransmitUI", intent, 1003, new e(aVar, gVar, dVar));
            }
            AppMethodBeat.o(253510);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
        public static final class e implements MMActivity.a {
            final /* synthetic */ com.tencent.mm.plugin.finder.api.g tEr;
            final /* synthetic */ z.d tNv;
            final /* synthetic */ a vWv;

            e(a aVar, com.tencent.mm.plugin.finder.api.g gVar, z.d dVar) {
                this.vWv = aVar;
                this.tEr = gVar;
                this.tNv = dVar;
            }

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                int i4;
                AppMethodBeat.i(167898);
                if (i3 == -1) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("SendMsgUsernames");
                    Log.i(a.getTAG(), "share namecard %s(%s) to %s", this.tEr.getNickname(), this.tEr.getUsername(), stringArrayListExtra);
                    p.g(stringArrayListExtra, "toUsers");
                    if (!stringArrayListExtra.isEmpty()) {
                        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                        String username = this.tEr.getUsername();
                        String listToString = Util.listToString(stringArrayListExtra, ",");
                        p.g(listToString, "Util.listToString(toUsers, \",\")");
                        FinderAuthInfo finderAuthInfo = this.tEr.field_authInfo;
                        if (finderAuthInfo != null) {
                            i4 = finderAuthInfo.authIconType;
                        } else {
                            i4 = 0;
                        }
                        com.tencent.mm.plugin.finder.report.k.j(username, listToString, i4, this.tNv.SYE);
                    }
                }
                AppMethodBeat.o(167898);
            }
        }

        public static /* synthetic */ void a(AppCompatActivity appCompatActivity, BaseFinderFeed baseFinderFeed, Bundle bundle) {
            Long l2;
            Integer num;
            Integer num2 = null;
            AppMethodBeat.i(253511);
            p.h(appCompatActivity, "context");
            p.h(baseFinderFeed, "feed");
            switch (baseFinderFeed.feedObject.getMediaType()) {
                case 9:
                    p.h(appCompatActivity, "context");
                    p.h(baseFinderFeed, "feed");
                    y yVar = y.vXH;
                    if (y.u(baseFinderFeed.feedObject.getFeedObject())) {
                        String str = TAG;
                        StringBuilder sb = new StringBuilder("share finderObject %d %d to status,liveId:");
                        awe liveInfo = baseFinderFeed.feedObject.getLiveInfo();
                        if (liveInfo != null) {
                            l2 = Long.valueOf(liveInfo.liveId);
                        } else {
                            l2 = null;
                        }
                        StringBuilder append = sb.append(l2).append(",desc:").append(baseFinderFeed.feedObject.getDescription()).append(",liveStatus:");
                        awe liveInfo2 = baseFinderFeed.feedObject.getLiveInfo();
                        if (liveInfo2 != null) {
                            num = Integer.valueOf(liveInfo2.liveStatus);
                        } else {
                            num = null;
                        }
                        String sb2 = append.append(num).append(' ').toString();
                        Object[] objArr = new Object[2];
                        objArr[0] = Long.valueOf(baseFinderFeed.feedObject.getId());
                        FinderObject feedObject = baseFinderFeed.feedObject.getFeedObject();
                        if (feedObject != null) {
                            num2 = Integer.valueOf(feedObject.forward_style);
                        }
                        objArr[1] = num2;
                        Log.i(str, sb2, objArr);
                        com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
                        dVar.a(baseFinderFeed.feedObject.getFinderLive());
                        String string = bundle.getString("FINDER_LIVE_SHARE_KEY_STATUS_VERIFY");
                        ArrayList arrayList = new ArrayList();
                        r rVar = new r();
                        rVar.GaO = "2";
                        rVar.GaQ = dVar.bfF();
                        arrayList.add(rVar);
                        m.a aVar = new m.a();
                        aVar.aSY("1020");
                        aVar.aTe(appCompatActivity.getResources().getString(R.string.cs7, dVar.jlf.nickName));
                        aVar.aTb("live_player@inner");
                        String str2 = dVar.jlf.hJs;
                        if (str2 == null) {
                            str2 = "";
                        }
                        aVar.aTc(str2);
                        aVar.aTd(string);
                        aVar.hE(arrayList);
                        ((com.tencent.mm.plugin.textstatus.a.i) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.textstatus.a.i.class)).a(appCompatActivity, aVar.fvz());
                        break;
                    } else {
                        y yVar2 = y.vXH;
                        String string2 = appCompatActivity.getString(R.string.d61);
                        p.g(string2, "context.getString(R.stri…finder_private_ban_share)");
                        y.aF(appCompatActivity, string2);
                        AppMethodBeat.o(253511);
                        return;
                    }
            }
            AppMethodBeat.o(253511);
        }

        public static /* synthetic */ bcj x(FinderItem finderItem) {
            AppMethodBeat.i(253513);
            bcj c2 = c(finderItem, false);
            AppMethodBeat.o(253513);
            return c2;
        }

        public static bcj c(FinderItem finderItem, boolean z) {
            String nickName;
            String str;
            String str2;
            long j2 = 0;
            AppMethodBeat.i(253512);
            p.h(finderItem, "feedObject");
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            int intValue = com.tencent.mm.plugin.finder.storage.c.dss().value().intValue();
            Log.i(TAG, "getFinderShareObject " + intValue + ' ' + finderItem.getFeedObject().forward_style + ' ' + z);
            if (!z || intValue == 1) {
                nickName = finderItem.getNickName();
            } else if (intValue == 2) {
                nickName = "";
            } else if (com.tencent.mm.ac.d.cW(finderItem.getFeedObject().forward_style, 1)) {
                nickName = "";
            } else {
                nickName = finderItem.getNickName();
            }
            bcj bcj = new bcj();
            bcj.objectId = com.tencent.mm.ac.d.zs(finderItem.getId());
            bcj.objectNonceId = finderItem.getObjectNonceId();
            bcj.vXJ = finderItem.getMediaType();
            FinderContact finderContact = finderItem.getFeedObject().contact;
            if (finderContact == null || (str = finderContact.headUrl) == null) {
                str = "";
            }
            bcj.uNR = str;
            bcj.nickname = nickName;
            bcj.username = finderItem.getUserName();
            com.tencent.mm.plugin.finder.search.i iVar = com.tencent.mm.plugin.finder.search.i.vvu;
            bcj.desc = com.tencent.mm.plugin.finder.search.i.auY(finderItem.getDescription());
            bcj.dJl = finderItem.getMediaList().size();
            LinkedList<bch> linkedList = bcj.mediaList;
            LinkedList<cjl> mediaList = finderItem.getMediaList();
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(mediaList, 10));
            for (T t : mediaList) {
                bch bch = new bch();
                bch.mediaType = t.mediaType;
                StringBuilder append = new StringBuilder().append(t.url);
                String str3 = t.url_token;
                if (str3 == null) {
                    str3 = "";
                }
                bch.url = append.append(str3).toString();
                if (!Util.isNullOrNil(t.coverUrl)) {
                    StringBuilder append2 = new StringBuilder().append(t.coverUrl);
                    String str4 = t.cover_url_token;
                    if (str4 == null) {
                        str4 = "";
                    }
                    bch.thumbUrl = append2.append(str4).toString();
                } else {
                    StringBuilder append3 = new StringBuilder().append(t.thumbUrl);
                    String str5 = t.thumb_url_token;
                    if (str5 == null) {
                        str5 = "";
                    }
                    bch.thumbUrl = append3.append(str5).toString();
                }
                bch.width = t.width;
                bch.height = t.height;
                bch.LLv = t.videoDuration;
                arrayList.add(bch);
            }
            linkedList.addAll(arrayList);
            bcj.localId = !finderItem.isPostFinish() ? finderItem.getLocalId() : 0;
            cng megaVideo = finderItem.getMegaVideo();
            if (megaVideo != null) {
                j2 = megaVideo.id;
            }
            bcj.LLw = com.tencent.mm.ac.d.zs(j2);
            cng megaVideo2 = finderItem.getMegaVideo();
            if (megaVideo2 == null || (str2 = megaVideo2.LOd) == null) {
                str2 = "";
            }
            bcj.LLx = str2;
            AppMethodBeat.o(253512);
            return bcj;
        }

        public static /* synthetic */ void a(a aVar, MMActivity mMActivity, String str, int i2, long j2, String str2, String str3, axt axt, int i3, String str4) {
            AppMethodBeat.i(253515);
            aVar.a(mMActivity, str, i2, j2, str2, str3, axt, i3, str4, (aoi) null);
            AppMethodBeat.o(253515);
        }

        public final void a(MMActivity mMActivity, String str, int i2, long j2, String str2, String str3, axt axt, int i3, String str4, aoi aoi) {
            com.tencent.mm.plugin.i.a.c cVar;
            int i4;
            int i5;
            AppMethodBeat.i(253514);
            p.h(mMActivity, "context");
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            if (com.tencent.mm.plugin.finder.spam.a.avp("share")) {
                AppMethodBeat.o(253514);
                return;
            }
            k.b bVar = new k.b();
            if (i2 != 7) {
                com.tencent.mm.plugin.i.a.h hVar = new com.tencent.mm.plugin.i.a.h();
                hVar.a(a(str, i2, str2, str3, axt, str4, null));
                cVar = hVar;
            } else {
                bVar.izD = 3;
                com.tencent.mm.plugin.i.a.c cVar2 = new com.tencent.mm.plugin.i.a.c();
                cVar2.a(a(str, i2, str2, str3, axt, str4, aoi));
                cVar = cVar2;
            }
            bVar.a(cVar);
            switch (i2) {
                case 4:
                    i4 = 72;
                    break;
                case 5:
                case 6:
                default:
                    i4 = 59;
                    break;
                case 7:
                    i4 = 75;
                    break;
            }
            bVar.type = i4;
            bVar.title = MMApplicationContext.getContext().getString(R.string.enf);
            bVar.url = MMApplicationContext.getContext().getString(R.string.eng);
            Intent intent = new Intent();
            switch (i2) {
                case 4:
                    i5 = 25;
                    break;
                case 5:
                case 6:
                default:
                    i5 = 21;
                    break;
                case 7:
                    i5 = 27;
                    break;
            }
            intent.putExtra("Retr_Msg_Type", i5);
            intent.putExtra("Multi_Retr", true);
            intent.putExtra("Retr_Msg_content", k.b.a(bVar, null, null));
            intent.putExtra("Retr_go_to_chattingUI", false);
            intent.putExtra("Retr_show_success_tips", true);
            com.tencent.mm.br.c.a(mMActivity, ".ui.transmit.MsgRetransmitUI", intent, 1001, new l(this, str, i2, j2, aoi, mMActivity, i3));
            AppMethodBeat.o(253514);
        }

        /* access modifiers changed from: package-private */
        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
        public static final class l implements MMActivity.a {
            final /* synthetic */ MMActivity $context;
            final /* synthetic */ int $scene;
            final /* synthetic */ String vWE;
            final /* synthetic */ int vWF;
            final /* synthetic */ long vWG;
            final /* synthetic */ aoi vWH;
            final /* synthetic */ a vWv;

            l(a aVar, String str, int i2, long j2, aoi aoi, MMActivity mMActivity, int i3) {
                this.vWv = aVar;
                this.vWE = str;
                this.vWF = i2;
                this.vWG = j2;
                this.vWH = aoi;
                this.$context = mMActivity;
                this.$scene = i3;
            }

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                boolean z = false;
                AppMethodBeat.i(167901);
                ArrayList<String> arrayList = new ArrayList<>();
                if (i3 == -1) {
                    arrayList = intent.getStringArrayListExtra("SendMsgUsernames");
                    p.g(arrayList, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
                    Log.i(a.getTAG(), "share topic %s to %s", this.vWE, arrayList);
                }
                if (this.vWF == 7) {
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    if (i3 == -1) {
                        z = true;
                    }
                    String listToString = Util.listToString(arrayList, ",");
                    p.g(listToString, "Util.listToString(toUsers, \",\")");
                    long j2 = this.vWG;
                    aoi aoi = this.vWH;
                    String str = aoi != null ? aoi.LAp : null;
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    com.tencent.mm.plugin.finder.report.k.a(1, z, listToString, j2, str, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.$context).get(FinderReporterUIC.class)).dIx());
                    AppMethodBeat.o(167901);
                    return;
                }
                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                if (i3 == -1) {
                    z = true;
                }
                String nullAsNil = Util.nullAsNil(this.vWE);
                p.g(nullAsNil, "Util.nullAsNil(topic)");
                int i4 = this.vWF;
                long j3 = this.vWG;
                String listToString2 = Util.listToString(arrayList, ",");
                p.g(listToString2, "Util.listToString(toUsers, \",\")");
                com.tencent.mm.plugin.finder.report.k.a(1, z, nullAsNil, i4, j3, listToString2);
                AppMethodBeat.o(167901);
            }
        }

        public static /* synthetic */ void a(MMActivity mMActivity, String str, int i2, long j2, String str2, String str3, axt axt, int i3, String str4) {
            AppMethodBeat.i(253517);
            b(mMActivity, str, i2, j2, str2, str3, axt, i3, str4, null);
            AppMethodBeat.o(253517);
        }

        public static void b(MMActivity mMActivity, String str, int i2, long j2, String str2, String str3, axt axt, int i3, String str4, aoi aoi) {
            com.tencent.mm.modelsns.j jVar;
            int i4;
            AppMethodBeat.i(253516);
            p.h(mMActivity, "context");
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            if (com.tencent.mm.plugin.finder.spam.a.avp("share")) {
                AppMethodBeat.o(253516);
                return;
            }
            Log.i(TAG, "share topic %s to sns", str);
            Intent intent = new Intent();
            if (i2 == 7) {
                com.tencent.mm.modelsns.b bVar = new com.tencent.mm.modelsns.b();
                bVar.jld = a(str, i2, str2, str3, axt, str4, aoi);
                jVar = bVar;
            } else {
                com.tencent.mm.modelsns.f fVar = new com.tencent.mm.modelsns.f();
                fVar.jld = a(str, i2, str2, str3, axt, str4, aoi);
                jVar = fVar;
            }
            switch (i2) {
                case 4:
                    i4 = 22;
                    break;
                case 5:
                case 6:
                default:
                    i4 = 18;
                    break;
                case 7:
                    i4 = 24;
                    break;
            }
            if (i2 == 7) {
                intent.putExtra("ksnsupload_finder_activity_xml", jVar.bfF());
            } else {
                intent.putExtra("ksnsupload_finder_topic_xml", jVar.bfF());
            }
            intent.putExtra("Ksnsupload_type", i4);
            intent.putExtra("need_result", true);
            com.tencent.mm.br.c.a(mMActivity, ".plugin.sns.ui.SnsUploadUI", intent, 1002, new m(mMActivity, i2, j2, aoi, str, i3));
            AppMethodBeat.o(253516);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/utils/FinderShareUtil$Companion$shareTopicToSnsTimeLine$1", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "mmOnActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-finder_release"})
        public static final class m implements MMActivity.a {
            final /* synthetic */ MMActivity $context;
            final /* synthetic */ int $scene;
            final /* synthetic */ String vWE;
            final /* synthetic */ int vWF;
            final /* synthetic */ long vWG;
            final /* synthetic */ aoi vWH;

            m(MMActivity mMActivity, int i2, long j2, aoi aoi, String str, int i3) {
                this.$context = mMActivity;
                this.vWF = i2;
                this.vWG = j2;
                this.vWH = aoi;
                this.vWE = str;
                this.$scene = i3;
            }

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                boolean z = true;
                AppMethodBeat.i(167902);
                if (i3 == -1) {
                    com.tencent.mm.ui.base.h.cA(this.$context, this.$context.getString(R.string.z0));
                }
                if (this.vWF == 7) {
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    if (i3 != -1) {
                        z = false;
                    }
                    long j2 = this.vWG;
                    aoi aoi = this.vWH;
                    String str = aoi != null ? aoi.LAp : null;
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    com.tencent.mm.plugin.finder.report.k.a(2, z, "", j2, str, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.$context).get(FinderReporterUIC.class)).dIx());
                    AppMethodBeat.o(167902);
                    return;
                }
                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                if (i3 != -1) {
                    z = false;
                }
                String nullAsNil = Util.nullAsNil(this.vWE);
                p.g(nullAsNil, "Util.nullAsNil(topic)");
                com.tencent.mm.plugin.finder.report.k.a(2, z, nullAsNil, this.vWF, this.vWG, "");
                AppMethodBeat.o(167902);
            }
        }

        private static bcl a(String str, int i2, String str2, String str3, axt axt, String str4, aoi aoi) {
            float f2;
            float f3 = 0.0f;
            AppMethodBeat.i(253518);
            bcl bcl = new bcl();
            bcl.dST = Util.nullAsNil(str);
            bcl.tvC = i2;
            bcl.iconUrl = Util.nullAsNil(str2);
            bcl.desc = Util.nullAsNil(str3);
            bcl.LLC = Util.nullAsNil(str4);
            bcg bcg = new bcg();
            bcg.LIb = axt != null ? axt.LIb : null;
            if (axt != null) {
                f2 = axt.dTj;
            } else {
                f2 = 0.0f;
            }
            bcg.dTj = f2;
            if (axt != null) {
                f3 = axt.latitude;
            }
            bcg.latitude = f3;
            bcl.LLB = bcg;
            if (aoi != null) {
                bcl.LLD = aoi;
            }
            AppMethodBeat.o(253518);
            return bcl;
        }

        private static bcf a(String str, String str2, String str3, List<String> list, List<String> list2, com.tencent.mm.bw.b bVar) {
            int i2 = 0;
            AppMethodBeat.i(253520);
            bcf bcf = new bcf();
            bcf.cardId = str;
            bcf.title = str2;
            bcf.oqZ = str3;
            for (T t : list.subList(0, kotlin.k.j.na(4, list.size()))) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                bcf.LLt.add(t);
                bcf.LLu.add(list2.get(i2));
                i2 = i3;
            }
            bcf.tVe = bVar;
            AppMethodBeat.o(253520);
            return bcf;
        }

        public static bcf b(bcu bcu) {
            LinkedList<FinderMedia> linkedList;
            AppMethodBeat.i(253521);
            p.h(bcu, "card");
            LinkedList linkedList2 = new LinkedList();
            LinkedList linkedList3 = new LinkedList();
            LinkedList<FinderObject> linkedList4 = bcu.object;
            p.g(linkedList4, "card.`object`");
            int i2 = 0;
            for (T t : linkedList4) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    kotlin.a.j.hxH();
                }
                T t2 = t;
                if (i2 < 4) {
                    FinderObjectDesc finderObjectDesc = t2.objectDesc;
                    FinderMedia first = (finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null) ? null : linkedList.getFirst();
                    if (first != null) {
                        String str = first.thumbUrl;
                        if (str != null) {
                            linkedList2.add(str);
                        }
                        String str2 = first.thumb_url_token;
                        if (str2 != null) {
                            linkedList3.add(str2);
                            i2 = i3;
                        } else {
                            i2 = i3;
                        }
                    }
                }
                i2 = i3;
            }
            bcf a2 = a(com.tencent.mm.ac.d.zs(bcu.id), bcu.IFO, bcu.LLT, linkedList2, linkedList3, bcu.tVe);
            AppMethodBeat.o(253521);
            return a2;
        }

        public final void a(MMActivity mMActivity, com.tencent.mm.plugin.i.a.d dVar, bbn bbn) {
            AppMethodBeat.i(253522);
            p.h(mMActivity, "context");
            p.h(dVar, "objectContent");
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            if (com.tencent.mm.plugin.finder.spam.a.avp("share")) {
                AppMethodBeat.o(253522);
                return;
            }
            k.b bVar = new k.b();
            bVar.a(dVar);
            bVar.type = 73;
            bVar.title = MMApplicationContext.getContext().getString(R.string.enf);
            bVar.url = MMApplicationContext.getContext().getString(R.string.eng);
            Intent intent = new Intent();
            intent.putExtra("Retr_Msg_Type", 22);
            intent.putExtra("Multi_Retr", true);
            intent.putExtra("Retr_Msg_content", k.b.a(bVar, null, null));
            intent.putExtra("Retr_go_to_chattingUI", false);
            intent.putExtra("Retr_show_success_tips", true);
            com.tencent.mm.br.c.a(mMActivity, ".ui.transmit.MsgRetransmitUI", intent, 1001, new C1318a(this, dVar, bbn));
            AppMethodBeat.o(253522);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
        /* renamed from: com.tencent.mm.plugin.finder.utils.s$a$a  reason: collision with other inner class name */
        static final class C1318a implements MMActivity.a {
            final /* synthetic */ bbn $contextObj;
            final /* synthetic */ a vWv;
            final /* synthetic */ com.tencent.mm.plugin.i.a.d vWw;

            C1318a(a aVar, com.tencent.mm.plugin.i.a.d dVar, bbn bbn) {
                this.vWv = aVar;
                this.vWw = dVar;
                this.$contextObj = bbn;
            }

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(253492);
                if (i3 == -1) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("SendMsgUsernames");
                    if (stringArrayListExtra == null) {
                        stringArrayListExtra = new ArrayList<>(0);
                    }
                    String listToString = Util.listToString(stringArrayListExtra, ";");
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    long Ga = com.tencent.mm.ac.d.Ga(this.vWw.jle.cardId);
                    p.g(listToString, "users");
                    com.tencent.mm.plugin.finder.report.k.a(Ga, 3, 1, listToString, (long) stringArrayListExtra.size(), this.$contextObj);
                    Log.i(a.getTAG(), "[shareAlbumToChat] " + this.vWw.jle.title + " to " + stringArrayListExtra);
                    AppMethodBeat.o(253492);
                    return;
                }
                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a(com.tencent.mm.ac.d.Ga(this.vWw.jle.cardId), 3, 2, "", 0, this.$contextObj);
                AppMethodBeat.o(253492);
            }
        }

        public final void a(MMActivity mMActivity, com.tencent.mm.modelsns.c cVar, bbn bbn) {
            AppMethodBeat.i(253523);
            p.h(mMActivity, "context");
            p.h(cVar, "snsShare");
            com.tencent.mm.plugin.finder.spam.a aVar = com.tencent.mm.plugin.finder.spam.a.vwk;
            if (com.tencent.mm.plugin.finder.spam.a.avp("share")) {
                AppMethodBeat.o(253523);
                return;
            }
            Log.i(TAG, "[shareAlbumToSnsTimeLine] share album to sns. " + cVar.jle.title);
            Intent intent = new Intent();
            intent.putExtra("ksnsupload_finder_album_xml", cVar.bfF());
            intent.putExtra("Ksnsupload_type", 20);
            intent.putExtra("need_result", true);
            com.tencent.mm.br.c.a(mMActivity, ".plugin.sns.ui.SnsUploadUI", intent, 1002, new b(this, mMActivity, cVar, bbn));
            AppMethodBeat.o(253523);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
        static final class b implements MMActivity.a {
            final /* synthetic */ MMActivity $context;
            final /* synthetic */ bbn $contextObj;
            final /* synthetic */ a vWv;
            final /* synthetic */ com.tencent.mm.modelsns.c vWx;

            b(a aVar, MMActivity mMActivity, com.tencent.mm.modelsns.c cVar, bbn bbn) {
                this.vWv = aVar;
                this.$context = mMActivity;
                this.vWx = cVar;
                this.$contextObj = bbn;
            }

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(253493);
                if (i3 == -1) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("SendMsgUsernames");
                    if (stringArrayListExtra == null) {
                        stringArrayListExtra = new ArrayList<>(0);
                    }
                    String listToString = Util.listToString(stringArrayListExtra, ";");
                    com.tencent.mm.ui.base.h.cA(this.$context, this.$context.getString(R.string.z0));
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    long Ga = com.tencent.mm.ac.d.Ga(this.vWx.jle.cardId);
                    p.g(listToString, "users");
                    com.tencent.mm.plugin.finder.report.k.a(Ga, 2, 1, listToString, (long) stringArrayListExtra.size(), this.$contextObj);
                    Log.i(a.getTAG(), "[shareAlbumToSnsTimeLine] " + this.vWx.jle.title + " to " + stringArrayListExtra);
                    AppMethodBeat.o(253493);
                    return;
                }
                com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a(com.tencent.mm.ac.d.Ga(this.vWx.jle.cardId), 2, 2, "", 0, this.$contextObj);
                AppMethodBeat.o(253493);
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
        public static final class i implements MMActivity.a {
            final /* synthetic */ com.tencent.mm.plugin.i.a.g vWB;
            final /* synthetic */ a vWv;

            public i(a aVar, com.tencent.mm.plugin.i.a.g gVar) {
                this.vWv = aVar;
                this.vWB = gVar;
            }

            @Override // com.tencent.mm.ui.MMActivity.a
            public final void d(int i2, int i3, Intent intent) {
                AppMethodBeat.i(253500);
                new ArrayList();
                if (i3 == -1) {
                    ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("SendMsgUsernames");
                    p.g(stringArrayListExtra, "data.getStringArrayListE…sgRetr.KSendMsgUsernames)");
                    Log.i(a.getTAG(), "share poi %s to %s", this.vWB.wDZ, stringArrayListExtra);
                }
                AppMethodBeat.o(253500);
            }
        }
    }
}
