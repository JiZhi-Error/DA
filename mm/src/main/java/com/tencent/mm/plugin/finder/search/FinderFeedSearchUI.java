package com.tencent.mm.plugin.finder.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.v;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.actions.SearchIntents;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.cgi.cf;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ag;
import com.tencent.mm.plugin.finder.model.aj;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.k;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFeedMegaVideoBtnAnimUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderHorizontalVideoPreviewUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aqw;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.ayy;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import kotlin.a.ak;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Î\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013*\u0002&B\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002¿\u0001B\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\bJ\u0016\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u00152\u0006\u0010Y\u001a\u00020\bJ \u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020\u00152\u0006\u0010Y\u001a\u00020\b2\u0006\u0010Z\u001a\u00020\bH\u0002J\u0010\u0010[\u001a\u00020V2\u0006\u0010\\\u001a\u00020]H\u0002J\u0006\u0010^\u001a\u00020_J\b\u0010`\u001a\u00020VH\u0002J\b\u0010a\u001a\u00020bH\u0016J\b\u0010c\u001a\u00020\u001eH\u0016J\b\u0010d\u001a\u00020\bH\u0016J\u0018\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020jH\u0016J\u0010\u0010k\u001a\u00020f2\u0006\u0010g\u001a\u00020hH\u0016J\b\u0010l\u001a\u00020\bH\u0014J\b\u0010m\u001a\u00020EH\u0016J\u0010\u0010n\u001a\u00020o2\u0006\u0010g\u001a\u00020hH\u0017J\b\u0010p\u001a\u00020\bH\u0016J\b\u0010q\u001a\u00020TH\u0016J\b\u0010r\u001a\u00020VH\u0002J\b\u0010s\u001a\u00020VH\u0002J\u0018\u0010t\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020w0v\u0018\u00010uH\u0016J\b\u0010x\u001a\u00020VH\u0003J\b\u0010y\u001a\u00020VH\u0002J\b\u0010z\u001a\u00020VH\u0002J\b\u0010{\u001a\u00020VH\u0002J\b\u0010|\u001a\u00020:H\u0016J\b\u0010}\u001a\u00020:H\u0016J\u0010\u0010~\u001a\u00020:2\u0006\u0010g\u001a\u00020hH\u0002J&\u0010\u001a\u00020V2\u0007\u0010\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\b2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0014J\t\u0010\u0001\u001a\u00020VH\u0016J\u0014\u0010\u0001\u001a\u00020V2\t\u0010\u0001\u001a\u0004\u0018\u00010@H\u0016J\u0014\u0010\u0001\u001a\u00020V2\t\u0010\u0001\u001a\u0004\u0018\u00010@H\u0016J\u0014\u0010\u0001\u001a\u00020V2\t\u0010\u0001\u001a\u0004\u0018\u00010@H\u0016J\u0015\u0010\u0001\u001a\u00020V2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010\u0001\u001a\u00020VH\u0014J>\u0010\u0001\u001a\u00020V2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00152\t\u0010\u0001\u001a\u0004\u0018\u00010\u00152\u0011\u0010\u0001\u001a\f\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u0012\u0010\u0001\u001a\u00020V2\u0007\u0010\u0001\u001a\u00020:H\u0016J'\u0010\u0001\u001a\u00020V2\u0007\u0010g\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020:2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\u001a\u0010\u0001\u001a\u00020V2\u0006\u0010g\u001a\u00020h2\u0007\u0010\u0001\u001a\u00020:H\u0016J%\u0010\u0001\u001a\u00020V2\u0007\u0010g\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030 \u00012\u0007\u0010¡\u0001\u001a\u00020:H\u0016J5\u0010¢\u0001\u001a\u00020V2\u0006\u0010g\u001a\u00020h2\u0007\u0010¡\u0001\u001a\u00020:2\u0007\u0010£\u0001\u001a\u00020:2\u0007\u0010¤\u0001\u001a\u00020\b2\u0007\u0010¥\u0001\u001a\u00020:H\u0016J\t\u0010¦\u0001\u001a\u00020VH\u0014J\t\u0010§\u0001\u001a\u00020VH\u0014J2\u0010¨\u0001\u001a\u00020V2\u0007\u0010©\u0001\u001a\u00020\b2\u0007\u0010ª\u0001\u001a\u00020\b2\t\u0010«\u0001\u001a\u0004\u0018\u00010\u00152\n\u0010¬\u0001\u001a\u0005\u0018\u00010­\u0001H\u0016J\t\u0010®\u0001\u001a\u00020:H\u0016J\t\u0010¯\u0001\u001a\u00020VH\u0016J\u001e\u0010°\u0001\u001a\u00020V2\u0007\u0010±\u0001\u001a\u00020\b2\n\u0010²\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010³\u0001\u001a\u00020VH\u0002J\t\u0010´\u0001\u001a\u00020VH\u0002J-\u0010µ\u0001\u001a\u00020V2\u0006\u0010;\u001a\u00020:2\u0006\u0010K\u001a\u00020\u00152\u0007\u0010¶\u0001\u001a\u00020:2\t\b\u0002\u0010·\u0001\u001a\u00020:H\u0002J\u0014\u0010¸\u0001\u001a\u00020V2\t\b\u0002\u0010¹\u0001\u001a\u00020:H\u0002J\u0012\u0010º\u0001\u001a\u00020V2\u0007\u0010g\u001a\u00030\u0001H\u0016J\u0011\u0010»\u0001\u001a\u00020V2\u0006\u0010g\u001a\u00020hH\u0016J)\u0010¼\u0001\u001a\u00020V2\u0006\u0010K\u001a\u00020\u00152\u000b\b\u0002\u0010½\u0001\u001a\u0004\u0018\u00010>2\t\b\u0002\u0010¾\u0001\u001a\u00020:H\u0002R\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015XD¢\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020!0 X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\"\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0004¢\u0006\u0004\n\u0002\u0010'R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8FX\u0002¢\u0006\f\n\u0004\b/\u0010\u001b\u001a\u0004\b-\u0010.R\u001a\u00100\u001a\u000201X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u000e\u00106\u001a\u000207X.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020:X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020:X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X.¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u00020BX\u0004¢\u0006\u0004\n\u0002\u0010CR\u000e\u0010D\u001a\u00020EX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX.¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020MX.¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX.¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020RX.¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020TX\u0004¢\u0006\u0002\n\u0000¨\u0006À\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderFeedSearchUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/search/FTSSearchView$FTSSearchViewListener;", "Lcom/tencent/mm/ui/search/FTSEditTextView$FTSEditTextListener;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedContract;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MENU_ID_CANCEL_FAV_TO_FINDER", "", "MENU_ID_CLOSE_COMMENT", "MENU_ID_EXPOSE", "MENU_ID_FAV_TO_FINDER", "MENU_ID_FOLLOW_PAT", "MENU_ID_OPEN_COMMENT", "MENU_ID_REPRINT", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_TIMELINE", "MENU_ID_UNFOLLOW", "MENU_ID_UNINTEREST", "TAG", "", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "commentPreloader$delegate", "Lkotlin/Lazy;", "continueFlag", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderCommentComponent;", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "feedChangeListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "feedExposeInfoChangeListener", "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/search/FinderFeedSearchUI$feedExposeInfoChangeListener$1;", "feedList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "finderLiveNoticePreLoader$delegate", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "historyLogic", "Lcom/tencent/mm/plugin/finder/search/FinderSearchHistoryLogic;", "initPosition", "isFirstCreate", "", "isFromHistory", "isOtherEnableFullScreenEnjoy", "lastBuff", "Lcom/tencent/mm/protobuf/ByteString;", "loadingView", "Landroid/view/View;", "mOnScrollListener", "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$mOnScrollListener$1", "Lcom/tencent/mm/plugin/finder/search/FinderFeedSearchUI$mOnScrollListener$1;", "mediaBannerViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "netSceneFinderSearch", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSearch;", "noResultView", "Landroid/widget/TextView;", "offset", SearchIntents.EXTRA_QUERY, "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "requestId", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "searchView", "Lcom/tencent/mm/ui/search/FTSSearchView;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "addExposeItem", "", "id", "", "position", "type", "addFinderObject", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "fixActionBarStatus", "getActivity", "Lcom/tencent/mm/ui/MMActivity;", "getCommentDrawer", "getCommentScene", "getCreateMoreMenuListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnCreateMMMenuListener;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "sheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "getCreateSecondMoreMenuListener", "getLayoutId", "getMediaBannerRecyclerViewPool", "getMoreMenuItemSelectedListener", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "getReportType", "getVideoCore", "goBack", "handleIntent", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initContentView", "initData", "initSearchView", "initVideoAbout", "isFinderSelfScene", "isHideStatusBar", "isSelf", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onClickBackBtn", "view", "onClickCancelBtn", "onClickClearTextBtn", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEditTextChange", "totalText", "inEditText", "tagList", "", "Lcom/tencent/mm/ui/search/FTSSearchView$IFTSTagModel;", "textChangeStatus", "Lcom/tencent/mm/ui/search/FTSEditTextView$TextChangeStatus;", "onEditTextFocusChange", "hasFocus", "onFavFeed", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "isFav", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onFollow", "isFollow", "onLikeComment", FFmpegMetadataRetriever.METADATA_KEY_COMMENT, "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "isLike", "onLikeFeed", "private", "likeAction", "preIsPrivate", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSearchKeyDown", "onSwipeBack", "onTagClick", FirebaseAnalytics.b.INDEX, "tag", "overlayStatusBar", "reportOnExpose", "reportSearch", "isFeedEmpty", "isHotWordSearch", "reportSearchExpose", "needClear", "shareFeed", "shareFeedToSns", "startSearch", "hotSessionBuffer", "isFromHotSearch", "FinderFeedSearchReporter", "plugin-finder_release"})
public final class FinderFeedSearchUI extends MMFinderUI implements com.tencent.mm.ak.i, com.tencent.mm.plugin.finder.feed.i, FTSEditTextView.a, a.b {
    private final String TAG = "Finder.FinderFeedSearchUI";
    private HashMap _$_findViewCache;
    private int continueFlag;
    private String dPI = "";
    private View hSw;
    private RecyclerView hak;
    private int jKy;
    private int offset;
    private final int pLU;
    private final int pMa;
    private String query = "";
    private final com.tencent.mm.plugin.finder.video.k tCD;
    private final int tLD;
    private final int tLE;
    private final int tLF;
    private final int tLG;
    private final int tLH;
    private final int tLJ;
    private final int tLK;
    private final int tLL;
    private RecyclerView.m tLO = new RecyclerView.m();
    private RefreshLoadMoreLayout tLS;
    private com.tencent.mm.plugin.finder.view.e tLT;
    public FinderLikeDrawer tLV;
    private boolean tPW;
    private final kotlin.f tRX;
    private final kotlin.f tRY;
    private com.tencent.mm.bw.b tVM;
    private final int tqv;
    private boolean twi;
    private final int tzW;
    private com.tencent.mm.ui.search.a ubO;
    private HashMap<String, a> vtH = new HashMap<>();
    private TextView vtJ;
    private h vtK;
    private cf vtL;
    private boolean vtZ = true;
    private DataBuffer<bo> vua = new DataBuffer<>(null, 1, null);
    private IListener<hn> vub;
    private final d vuc;
    private final q vud;

    private com.tencent.mm.plugin.finder.feed.model.d dcW() {
        AppMethodBeat.i(251285);
        com.tencent.mm.plugin.finder.feed.model.d dVar = (com.tencent.mm.plugin.finder.feed.model.d) this.tRX.getValue();
        AppMethodBeat.o(251285);
        return dVar;
    }

    private com.tencent.mm.plugin.finder.feed.model.f dcX() {
        AppMethodBeat.i(251286);
        com.tencent.mm.plugin.finder.feed.model.f fVar = (com.tencent.mm.plugin.finder.feed.model.f) this.tRY.getValue();
        AppMethodBeat.o(251286);
        return fVar;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(251302);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(251302);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(251301);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(251301);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.b<Integer, bo> {
        final /* synthetic */ FinderFeedSearchUI vue;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(FinderFeedSearchUI finderFeedSearchUI) {
            super(1);
            this.vue = finderFeedSearchUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ bo invoke(Integer num) {
            BaseFinderFeed baseFinderFeed;
            AppMethodBeat.i(178404);
            int intValue = num.intValue();
            if (intValue < 0 || intValue >= this.vue.vua.size()) {
                AppMethodBeat.o(178404);
                return null;
            }
            bo boVar = (bo) this.vue.vua.get(intValue);
            if (boVar instanceof BaseFinderFeed) {
                baseFinderFeed = (BaseFinderFeed) boVar;
            } else {
                baseFinderFeed = null;
            }
            BaseFinderFeed baseFinderFeed2 = baseFinderFeed;
            AppMethodBeat.o(178404);
            return baseFinderFeed2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.m<Integer, Integer, LinkedList<bo>> {
        final /* synthetic */ FinderFeedSearchUI vue;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(FinderFeedSearchUI finderFeedSearchUI) {
            super(2);
            this.vue = finderFeedSearchUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ LinkedList<bo> invoke(Integer num, Integer num2) {
            Integer num3;
            DataBuffer dataBuffer;
            List a2;
            AppMethodBeat.i(251277);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            if (intValue >= 0) {
                DataBuffer dataBuffer2 = this.vue.vua;
                if (dataBuffer2 != null) {
                    num3 = Integer.valueOf(dataBuffer2.size());
                } else {
                    num3 = null;
                }
                if (!(intValue2 >= num3.intValue() || (dataBuffer = this.vue.vua) == null || (a2 = kotlin.a.j.a((List) dataBuffer, new kotlin.k.f(intValue, intValue2))) == null)) {
                    LinkedList linkedList = new LinkedList(a2);
                    AppMethodBeat.o(251277);
                    return linkedList;
                }
            }
            AppMethodBeat.o(251277);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class o extends kotlin.g.b.q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FinderFeedSearchUI vue;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(FinderFeedSearchUI finderFeedSearchUI) {
            super(1);
            this.vue = finderFeedSearchUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(166766);
            String str2 = str;
            kotlin.g.b.p.h(str2, LocaleUtil.ITALIAN);
            FinderFeedSearchUI.c(this.vue).getFtsEditText().O(str2, null);
            this.vue.twi = true;
            FinderFeedSearchUI.a(this.vue, str2);
            x xVar = x.SXb;
            AppMethodBeat.o(166766);
            return xVar;
        }
    }

    public FinderFeedSearchUI() {
        AppMethodBeat.i(166792);
        y yVar = y.vXH;
        this.tPW = y.isOtherEnableFullScreenEnjoy();
        this.tCD = new com.tencent.mm.plugin.finder.video.k();
        this.tRX = kotlin.g.ah(new c(this));
        this.tRY = kotlin.g.ah(new e(this));
        this.tLD = 99;
        this.tzW = 100;
        this.pMa = 101;
        this.tqv = 102;
        this.pLU = 103;
        this.tLE = 104;
        this.tLF = 105;
        this.tLG = 106;
        this.tLH = 107;
        this.tLJ = 108;
        this.tLK = 110;
        this.tLL = 111;
        this.vuc = new d(this);
        this.vud = new q();
        AppMethodBeat.o(166792);
    }

    public static final /* synthetic */ RecyclerView b(FinderFeedSearchUI finderFeedSearchUI) {
        AppMethodBeat.i(166793);
        RecyclerView recyclerView = finderFeedSearchUI.hak;
        if (recyclerView == null) {
            kotlin.g.b.p.btv("recyclerView");
        }
        AppMethodBeat.o(166793);
        return recyclerView;
    }

    public static final /* synthetic */ com.tencent.mm.ui.search.a c(FinderFeedSearchUI finderFeedSearchUI) {
        AppMethodBeat.i(166794);
        com.tencent.mm.ui.search.a aVar = finderFeedSearchUI.ubO;
        if (aVar == null) {
            kotlin.g.b.p.btv("searchView");
        }
        AppMethodBeat.o(166794);
        return aVar;
    }

    public static final /* synthetic */ RefreshLoadMoreLayout l(FinderFeedSearchUI finderFeedSearchUI) {
        AppMethodBeat.i(166796);
        RefreshLoadMoreLayout refreshLoadMoreLayout = finderFeedSearchUI.tLS;
        if (refreshLoadMoreLayout == null) {
            kotlin.g.b.p.btv("rlLayout");
        }
        AppMethodBeat.o(166796);
        return refreshLoadMoreLayout;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        com.tencent.mm.bw.b bVar;
        String str;
        com.tencent.mm.plugin.finder.event.base.c a2;
        AppMethodBeat.i(166771);
        super.onCreate(bundle);
        this.ubO = new com.tencent.mm.ui.search.a(this);
        com.tencent.mm.ui.search.a aVar = this.ubO;
        if (aVar == null) {
            kotlin.g.b.p.btv("searchView");
        }
        aVar.setSearchViewListener(this);
        com.tencent.mm.ui.search.a aVar2 = this.ubO;
        if (aVar2 == null) {
            kotlin.g.b.p.btv("searchView");
        }
        aVar2.getFtsEditText().setHint(getString(R.string.yn));
        com.tencent.mm.ui.search.a aVar3 = this.ubO;
        if (aVar3 == null) {
            kotlin.g.b.p.btv("searchView");
        }
        aVar3.getFtsEditText().setFtsEditTextListener(this);
        com.tencent.mm.ui.search.a aVar4 = this.ubO;
        if (aVar4 == null) {
            kotlin.g.b.p.btv("searchView");
        }
        aVar4.getFtsEditText().setCanDeleteTag(false);
        com.tencent.mm.ui.search.a aVar5 = this.ubO;
        if (aVar5 == null) {
            kotlin.g.b.p.btv("searchView");
        }
        aVar5.getFtsEditText().gWY();
        if (this.tPW) {
            com.tencent.mm.ui.search.a aVar6 = this.ubO;
            if (aVar6 == null) {
                kotlin.g.b.p.btv("searchView");
            }
            View findViewById = aVar6.findViewById(R.id.aib);
            kotlin.g.b.p.g(findViewById, "searchView.findViewById<View>(R.id.cancel_btn)");
            findViewById.setVisibility(8);
            com.tencent.mm.ui.search.a aVar7 = this.ubO;
            if (aVar7 == null) {
                kotlin.g.b.p.btv("searchView");
            }
            LinearLayout searchContainer = aVar7.getSearchContainer();
            kotlin.g.b.p.g(searchContainer, "searchView.searchContainer");
            searchContainer.setBackground(null);
            com.tencent.mm.ui.search.a aVar8 = this.ubO;
            if (aVar8 == null) {
                kotlin.g.b.p.btv("searchView");
            }
            LinearLayout searchContainer2 = aVar8.getSearchContainer();
            kotlin.g.b.p.g(searchContainer2, "searchView.searchContainer");
            ViewGroup.LayoutParams layoutParams = searchContainer2.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                AppMethodBeat.o(166771);
                throw tVar;
            }
            ((LinearLayout.LayoutParams) layoutParams).leftMargin = 0;
            com.tencent.mm.ui.search.a aVar9 = this.ubO;
            if (aVar9 == null) {
                kotlin.g.b.p.btv("searchView");
            }
            aVar9.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(R.id.c2);
            com.tencent.mm.ui.search.a aVar10 = this.ubO;
            if (aVar10 == null) {
                kotlin.g.b.p.btv("searchView");
            }
            frameLayout.addView(aVar10);
            com.tencent.mm.ui.search.a aVar11 = this.ubO;
            if (aVar11 == null) {
                kotlin.g.b.p.btv("searchView");
            }
            Context context = aVar11.getContext();
            kotlin.g.b.p.g(context, "searchView.context");
            int color = context.getResources().getColor(R.color.v7);
            com.tencent.mm.ui.search.a aVar12 = this.ubO;
            if (aVar12 == null) {
                kotlin.g.b.p.btv("searchView");
            }
            FTSEditTextView ftsEditText = aVar12.getFtsEditText();
            kotlin.g.b.p.g(ftsEditText, "searchView.ftsEditText");
            ftsEditText.getEditText().setTextColor(color);
            com.tencent.mm.ui.search.a aVar13 = this.ubO;
            if (aVar13 == null) {
                kotlin.g.b.p.btv("searchView");
            }
            aVar13.getSearchIcon().setIconColor(color);
            com.tencent.mm.ui.search.a aVar14 = this.ubO;
            if (aVar14 == null) {
                kotlin.g.b.p.btv("searchView");
            }
            FTSEditTextView ftsEditText2 = aVar14.getFtsEditText();
            kotlin.g.b.p.g(ftsEditText2, "searchView.ftsEditText");
            ImageButton clearBtn = ftsEditText2.getClearBtn();
            kotlin.g.b.p.g(clearBtn, "searchView.ftsEditText.clearBtn");
            clearBtn.getDrawable().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        } else {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dwL().value().intValue() == 1) {
                com.tencent.mm.ui.search.a aVar15 = this.ubO;
                if (aVar15 == null) {
                    kotlin.g.b.p.btv("searchView");
                }
                aVar15.gXh();
            }
            FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(R.id.dbh);
            kotlin.g.b.p.g(frameLayout2, "full_actionbar");
            frameLayout2.setVisibility(8);
            ActionBar supportActionBar = getSupportActionBar();
            if (supportActionBar == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(supportActionBar, "supportActionBar!!");
            com.tencent.mm.ui.search.a aVar16 = this.ubO;
            if (aVar16 == null) {
                kotlin.g.b.p.btv("searchView");
            }
            supportActionBar.setCustomView(aVar16);
        }
        amZ();
        e.a aVar17 = com.tencent.mm.plugin.finder.view.e.wky;
        Window window = getWindow();
        kotlin.g.b.p.g(window, "window");
        View decorView = window.getDecorView();
        kotlin.g.b.p.g(decorView, "window.decorView");
        this.tLT = e.a.a(this, decorView, 2, false, 0, 24);
        FinderLikeDrawer.a aVar18 = FinderLikeDrawer.wnm;
        AppCompatActivity context2 = getContext();
        kotlin.g.b.p.g(context2, "context");
        Window window2 = getWindow();
        kotlin.g.b.p.g(window2, "getActivity().window");
        FinderLikeDrawer.a aVar19 = FinderLikeDrawer.wnm;
        this.tLV = FinderLikeDrawer.a.a(context2, window2, FinderLikeDrawer.tvl);
        View findViewById2 = getContext().findViewById(R.id.h7t);
        kotlin.g.b.p.g(findViewById2, "context.findViewById(R.id.rl_layout)");
        this.tLS = (RefreshLoadMoreLayout) findViewById2;
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            kotlin.g.b.p.btv("rlLayout");
        }
        this.hak = refreshLoadMoreLayout.getRecyclerView();
        View findViewById3 = getContext().findViewById(R.id.g01);
        kotlin.g.b.p.g(findViewById3, "context.findViewById(R.id.no_result_tv)");
        this.vtJ = (TextView) findViewById3;
        View findViewById4 = getContext().findViewById(R.id.epl);
        kotlin.g.b.p.g(findViewById4, "context.findViewById(R.id.loading_layout)");
        this.hSw = findViewById4;
        FinderLinearLayoutManager finderLinearLayoutManager = new FinderLinearLayoutManager(this);
        if (this.tPW) {
            finderLinearLayoutManager.wsx = 25.0f;
            finderLinearLayoutManager.qOi = 100;
        }
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            kotlin.g.b.p.btv("recyclerView");
        }
        recyclerView.setLayoutManager(finderLinearLayoutManager);
        WxRecyclerAdapter wxRecyclerAdapter = new WxRecyclerAdapter(new b(this), this.vua);
        RecyclerView recyclerView2 = this.hak;
        if (recyclerView2 == null) {
            kotlin.g.b.p.btv("recyclerView");
        }
        recyclerView2.setAdapter(wxRecyclerAdapter);
        RecyclerView recyclerView3 = this.hak;
        if (recyclerView3 == null) {
            kotlin.g.b.p.btv("recyclerView");
        }
        recyclerView3.a(this.vud);
        RecyclerView recyclerView4 = this.hak;
        if (recyclerView4 == null) {
            kotlin.g.b.p.btv("recyclerView");
        }
        recyclerView4.setHasFixedSize(true);
        RecyclerView recyclerView5 = this.hak;
        if (recyclerView5 == null) {
            kotlin.g.b.p.btv("recyclerView");
        }
        recyclerView5.setItemViewCacheSize(5);
        if (!this.tPW) {
            RecyclerView recyclerView6 = this.hak;
            if (recyclerView6 == null) {
                kotlin.g.b.p.btv("recyclerView");
            }
            recyclerView6.b(new com.tencent.mm.plugin.finder.view.decoration.b(new ColorDrawable(getResources().getColor(R.color.BW_93)), (int) getResources().getDimension(R.dimen.a4f)));
            TextView textView = this.vtJ;
            if (textView == null) {
                kotlin.g.b.p.btv("noResultView");
            }
            textView.setTextColor(getResources().getColor(R.color.uj));
        } else {
            TextView textView2 = this.vtJ;
            if (textView2 == null) {
                kotlin.g.b.p.btv("noResultView");
            }
            textView2.setTextColor(getResources().getColor(R.color.ut));
            ((TouchableLayout) _$_findCachedViewById(R.id.izn)).setBackgroundColor(getResources().getColor(R.color.rv));
            FrameLayout frameLayout3 = (FrameLayout) _$_findCachedViewById(R.id.dbh);
            kotlin.g.b.p.g(frameLayout3, "full_actionbar");
            frameLayout3.setVisibility(0);
            ((LinearLayout) _$_findCachedViewById(R.id.xu)).setOnClickListener(new i(this));
            AppCompatActivity context3 = getContext();
            kotlin.g.b.p.g(context3, "context");
            int dimension = ((int) context3.getResources().getDimension(R.dimen.cb)) + au.eu(getContext()) + au.getStatusBarHeight(getContext());
            ListView listView = (ListView) _$_findCachedViewById(R.id.dpq);
            kotlin.g.b.p.g(listView, "history_lv");
            ViewGroup.LayoutParams layoutParams2 = listView.getLayoutParams();
            if (layoutParams2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(166771);
                throw tVar2;
            }
            ((FrameLayout.LayoutParams) layoutParams2).topMargin = dimension;
            ListView listView2 = (ListView) _$_findCachedViewById(R.id.dpq);
            kotlin.g.b.p.g(listView2, "history_lv");
            listView2.setTag(Boolean.TRUE);
            Window window3 = getWindow();
            kotlin.g.b.p.g(window3, "window");
            View decorView2 = window3.getDecorView();
            kotlin.g.b.p.g(decorView2, "window.decorView");
            decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 1024 | 256);
            Window window4 = getWindow();
            kotlin.g.b.p.g(window4, "window");
            window4.setStatusBarColor(0);
            getController().p(this, getResources().getColor(R.color.ac_));
            com.tencent.mm.ui.b.e(this, false);
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 != null) {
                supportActionBar2.setBackgroundDrawable(new ColorDrawable(0));
                supportActionBar2.hide();
            }
            int statusBarHeight = au.getStatusBarHeight(this);
            FrameLayout frameLayout4 = (FrameLayout) _$_findCachedViewById(R.id.dbh);
            kotlin.g.b.p.g(frameLayout4, "full_actionbar");
            ViewGroup.LayoutParams layoutParams3 = frameLayout4.getLayoutParams();
            layoutParams3.height += statusBarHeight;
            FrameLayout frameLayout5 = (FrameLayout) _$_findCachedViewById(R.id.dbh);
            kotlin.g.b.p.g(frameLayout5, "full_actionbar");
            frameLayout5.setLayoutParams(layoutParams3);
            ((FrameLayout) _$_findCachedViewById(R.id.dbh)).setPadding(0, statusBarHeight, 0, 0);
            y yVar = y.vXH;
            Window window5 = getWindow();
            kotlin.g.b.p.g(window5, "window");
            y.b(window5, false);
            setNavigationbarColor(getResources().getColor(R.color.fm));
            com.tencent.mm.plugin.finder.ui.e eVar = new com.tencent.mm.plugin.finder.ui.e();
            RecyclerView recyclerView7 = this.hak;
            if (recyclerView7 == null) {
                kotlin.g.b.p.btv("recyclerView");
            }
            eVar.f(recyclerView7);
        }
        RecyclerView recyclerView8 = this.hak;
        if (recyclerView8 == null) {
            kotlin.g.b.p.btv("recyclerView");
        }
        recyclerView8.setOnTouchListener(new j(this));
        RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.tLS;
        if (refreshLoadMoreLayout2 == null) {
            kotlin.g.b.p.btv("rlLayout");
        }
        refreshLoadMoreLayout2.setEnablePullDownHeader(false);
        RefreshLoadMoreLayout refreshLoadMoreLayout3 = this.tLS;
        if (refreshLoadMoreLayout3 == null) {
            kotlin.g.b.p.btv("rlLayout");
        }
        View inflate = aa.jQ(getContext()).inflate(R.layout.b21, (ViewGroup) null);
        kotlin.g.b.p.g(inflate, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
        refreshLoadMoreLayout3.setLoadMoreFooter(inflate);
        RefreshLoadMoreLayout refreshLoadMoreLayout4 = this.tLS;
        if (refreshLoadMoreLayout4 == null) {
            kotlin.g.b.p.btv("rlLayout");
        }
        refreshLoadMoreLayout4.setActionCallback(new k(this));
        String str2 = this.query;
        if (str2 != null) {
            com.tencent.mm.ui.search.a aVar20 = this.ubO;
            if (aVar20 == null) {
                kotlin.g.b.p.btv("searchView");
            }
            aVar20.getFtsEditText().O(str2, null);
        }
        RecyclerView recyclerView9 = this.hak;
        if (recyclerView9 == null) {
            kotlin.g.b.p.btv("recyclerView");
        }
        com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(this.jKy, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView9, a3.axQ(), "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView9.scrollToPosition(((Integer) a3.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView9, "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "initContentView", "()V", "Undefined", "scrollToPosition", "(I)V");
        com.tencent.mm.ui.component.a aVar21 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.f d2 = FinderReporterUIC.d((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class));
        if (d2 != null) {
            RecyclerView recyclerView10 = this.hak;
            if (recyclerView10 == null) {
                kotlin.g.b.p.btv("recyclerView");
            }
            d2.m(recyclerView10);
        }
        com.tencent.mm.ui.component.a aVar22 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.c a4 = FinderReporterUIC.a((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class));
        if (a4 != null) {
            a4.a(new a());
        }
        EventCenter.instance.add(this.vuc);
        dcW().a(2, 6, new l(this));
        com.tencent.mm.ui.component.a aVar23 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.c a5 = FinderReporterUIC.a((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class));
        if (a5 != null) {
            a5.a(dcW());
        }
        dcX().e(new m(this));
        FinderReporterUIC.a aVar24 = FinderReporterUIC.wzC;
        AppCompatActivity context4 = getContext();
        kotlin.g.b.p.g(context4, "context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context4);
        if (!(fH == null || (a2 = FinderReporterUIC.a(fH)) == null)) {
            a2.a(dcX());
        }
        com.tencent.mm.ui.component.a aVar25 = com.tencent.mm.ui.component.a.PRN;
        FinderFeedMegaVideoBtnAnimUIC finderFeedMegaVideoBtnAnimUIC = (FinderFeedMegaVideoBtnAnimUIC) com.tencent.mm.ui.component.a.b(this).get(FinderFeedMegaVideoBtnAnimUIC.class);
        RecyclerView recyclerView11 = this.hak;
        if (recyclerView11 == null) {
            kotlin.g.b.p.btv("recyclerView");
        }
        finderFeedMegaVideoBtnAnimUIC.t(recyclerView11);
        this.vub = new n(this, wxRecyclerAdapter);
        IListener<hn> iListener = this.vub;
        if (iListener != null) {
            iListener.alive();
        }
        com.tencent.mm.plugin.finder.video.k.a(this.tCD, this, new p(this), 4);
        String stringExtra = getIntent().getStringExtra("key_search_query");
        if (!Util.isNullOrNil(stringExtra)) {
            com.tencent.mm.ui.search.a aVar26 = this.ubO;
            if (aVar26 == null) {
                kotlin.g.b.p.btv("searchView");
            }
            aVar26.getFtsEditText().O(stringExtra, null);
            byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_search_session_buffer");
            if (byteArrayExtra != null) {
                bVar = new com.tencent.mm.bw.b(byteArrayExtra);
            } else {
                bVar = null;
            }
            if (stringExtra == null) {
                str = "";
            } else {
                str = stringExtra;
            }
            a(str, bVar, true);
            h hVar = this.vtK;
            if (hVar == null) {
                kotlin.g.b.p.btv("historyLogic");
            }
            hVar.auX(stringExtra);
        }
        AppMethodBeat.o(166771);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(251287);
        y yVar = y.vXH;
        if (y.isOtherEnableFullScreenEnjoy()) {
            Set<Class<? extends UIComponent>> of = ak.setOf(FinderHorizontalVideoPreviewUIC.class);
            AppMethodBeat.o(251287);
            return of;
        }
        AppMethodBeat.o(251287);
        return null;
    }

    @Override // com.tencent.mm.ui.MMFragmentActivity
    public final boolean isHideStatusBar() {
        AppMethodBeat.i(251288);
        y yVar = y.vXH;
        boolean isOtherEnableFullScreenEnjoy = y.isOtherEnableFullScreenEnjoy();
        AppMethodBeat.o(251288);
        return isOtherEnableFullScreenEnjoy;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initVideoAbout$1", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore$Initializer;", "getData", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isUseAutoPlay", "", "isUsePreload", "onAttachRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
    public static final class p implements k.b {
        final /* synthetic */ FinderFeedSearchUI vue;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        p(FinderFeedSearchUI finderFeedSearchUI) {
            this.vue = finderFeedSearchUI;
        }

        @Override // com.tencent.mm.plugin.finder.video.k.b
        public final RecyclerView dch() {
            AppMethodBeat.i(166767);
            RecyclerView b2 = FinderFeedSearchUI.b(this.vue);
            AppMethodBeat.o(166767);
            return b2;
        }

        @Override // com.tencent.mm.plugin.finder.video.k.b
        public final DataBuffer<bo> dci() {
            AppMethodBeat.i(251280);
            DataBuffer<bo> dataBuffer = this.vue.vua;
            AppMethodBeat.o(251280);
            return dataBuffer;
        }
    }

    private final void amZ() {
        AppMethodBeat.i(251289);
        i iVar = i.vvu;
        i.dqb().clear();
        i iVar2 = i.vvu;
        if (i.dqa() != null) {
            i iVar3 = i.vvu;
            aqw dqa = i.dqa();
            if (dqa == null) {
                kotlin.g.b.p.hyc();
            }
            i iVar4 = i.vvu;
            i.a(null);
            String str = dqa.dPI;
            if (str == null) {
                str = "";
            }
            this.dPI = str;
            String str2 = dqa.query;
            if (str2 == null) {
                str2 = "";
            }
            this.query = str2;
            this.offset = dqa.offset;
            this.continueFlag = dqa.continueFlag;
            this.tVM = dqa.tVM;
            this.jKy = dqa.LCH;
            LinkedList<FinderObject> linkedList = dqa.tbD;
            kotlin.g.b.p.g(linkedList, "finderFeedObj.objectList");
            LinkedList<FinderObject> linkedList2 = linkedList;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList2, 10));
            for (T t : linkedList2) {
                kotlin.g.b.p.g(t, LocaleUtil.ITALIAN);
                i((FinderObject) t);
                arrayList.add(x.SXb);
            }
        } else {
            String uuid = UUID.randomUUID().toString();
            kotlin.g.b.p.g(uuid, "UUID.randomUUID().toString()");
            this.dPI = uuid;
            this.query = "";
            com.tencent.mm.ui.search.a aVar = this.ubO;
            if (aVar == null) {
                kotlin.g.b.p.btv("searchView");
            }
            aVar.getFtsEditText().awD();
            com.tencent.mm.ui.search.a aVar2 = this.ubO;
            if (aVar2 == null) {
                kotlin.g.b.p.btv("searchView");
            }
            aVar2.getFtsEditText().awC();
        }
        this.tLO.aw(1, 10);
        this.tLO.aw(2, 10);
        this.vtK = new h(this, this.tPW, new o(this));
        AppMethodBeat.o(251289);
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final com.tencent.mm.plugin.finder.view.e dcg() {
        AppMethodBeat.i(251290);
        com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
        if (eVar == null) {
            kotlin.g.b.p.btv("drawer");
        }
        AppMethodBeat.o(251290);
        return eVar;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(251291);
        super.onActivityResult(i2, i3, intent);
        com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
        if (eVar == null) {
            kotlin.g.b.p.btv("drawer");
        }
        eVar.d(i2, intent);
        AppMethodBeat.o(251291);
    }

    private final void i(FinderObject finderObject) {
        AppMethodBeat.i(166772);
        FinderItem.a aVar = FinderItem.Companion;
        FinderItem a2 = FinderItem.a.a(finderObject, 16);
        i iVar = i.vvu;
        i.dqb().put(Long.valueOf(a2.getId()), a2);
        c.a aVar2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        this.vua.add(c.a.s(a2));
        AppMethodBeat.o(166772);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ FinderFeedSearchUI vue;

        i(FinderFeedSearchUI finderFeedSearchUI) {
            this.vue = finderFeedSearchUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(251270);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.vue.onBackPressed();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initContentView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(251270);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/MotionEvent;", "onTouch"})
    static final class j implements View.OnTouchListener {
        final /* synthetic */ FinderFeedSearchUI vue;

        j(FinderFeedSearchUI finderFeedSearchUI) {
            this.vue = finderFeedSearchUI;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(251271);
            FinderFeedSearchUI.c(this.vue).getFtsEditText().gUA();
            this.vue.hideVKB();
            AppMethodBeat.o(251271);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initContentView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "plugin-finder_release"})
    public static final class k extends RefreshLoadMoreLayout.a {
        private boolean tMa = true;
        final /* synthetic */ FinderFeedSearchUI vue;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(251274);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initContentView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initContentView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(251274);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(251276);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initContentView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initContentView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(251276);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(251275);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initContentView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.onRefreshEnd(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initContentView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(251275);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(FinderFeedSearchUI finderFeedSearchUI) {
            this.vue = finderFeedSearchUI;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            View findViewById;
            TextView textView;
            TextView textView2;
            View findViewById2;
            TextView textView3;
            TextView textView4;
            AppMethodBeat.i(251272);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initContentView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            String unused = this.vue.TAG;
            com.tencent.e.f.h.hkS();
            String str = this.vue.query;
            if (str != null) {
                if (this.vue.continueFlag == 1) {
                    FinderFeedSearchUI finderFeedSearchUI = this.vue;
                    int i2 = this.vue.offset;
                    String str2 = this.vue.dPI;
                    com.tencent.mm.bw.b bVar = this.vue.tVM;
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    finderFeedSearchUI.vtL = new cf(str, i2, str2, bVar, 0, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.vue).get(FinderReporterUIC.class)).dIx(), 80);
                    com.tencent.mm.kernel.g.azz().b(this.vue.vtL);
                    com.tencent.mm.kernel.g.azz().a(3820, this.vue);
                    View loadMoreFooter = FinderFeedSearchUI.l(this.vue).getLoadMoreFooter();
                    if (!(loadMoreFooter == null || (textView4 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                        textView4.setText(R.string.d0l);
                    }
                    View loadMoreFooter2 = FinderFeedSearchUI.l(this.vue).getLoadMoreFooter();
                    if (!(loadMoreFooter2 == null || (textView3 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                        textView3.setVisibility(0);
                    }
                    View loadMoreFooter3 = FinderFeedSearchUI.l(this.vue).getLoadMoreFooter();
                    if (!(loadMoreFooter3 == null || (findViewById2 = loadMoreFooter3.findViewById(R.id.ep0)) == null)) {
                        findViewById2.setVisibility(8);
                    }
                } else {
                    View loadMoreFooter4 = FinderFeedSearchUI.l(this.vue).getLoadMoreFooter();
                    if (!(loadMoreFooter4 == null || (textView2 = (TextView) loadMoreFooter4.findViewById(R.id.ep1)) == null)) {
                        textView2.setText(R.string.d0m);
                    }
                    View loadMoreFooter5 = FinderFeedSearchUI.l(this.vue).getLoadMoreFooter();
                    if (!(loadMoreFooter5 == null || (textView = (TextView) loadMoreFooter5.findViewById(R.id.ep1)) == null)) {
                        textView.setVisibility(8);
                    }
                    View loadMoreFooter6 = FinderFeedSearchUI.l(this.vue).getLoadMoreFooter();
                    if (!(loadMoreFooter6 == null || (findViewById = loadMoreFooter6.findViewById(R.id.ep0)) == null)) {
                        findViewById.setVisibility(0);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initContentView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(251272);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void IF(int i2) {
            AppMethodBeat.i(251273);
            if (this.tMa && i2 > 0) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                com.tencent.mm.plugin.finder.event.base.f d2 = FinderReporterUIC.d((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.vue).get(FinderReporterUIC.class));
                if (d2 != null) {
                    d2.dap().onScrollStateChanged(FinderFeedSearchUI.b(this.vue), 5);
                }
                this.tMa = false;
            }
            AppMethodBeat.o(251273);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$initContentView$7", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class n extends IListener<hn> {
        final /* synthetic */ WxRecyclerAdapter uMv;
        final /* synthetic */ FinderFeedSearchUI vue;

        n(FinderFeedSearchUI finderFeedSearchUI, WxRecyclerAdapter wxRecyclerAdapter) {
            this.vue = finderFeedSearchUI;
            this.uMv = wxRecyclerAdapter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hn hnVar) {
            AppMethodBeat.i(251279);
            hn hnVar2 = hnVar;
            kotlin.g.b.p.h(hnVar2, "event");
            com.tencent.mm.ac.d.a(0, new a(this, hnVar2));
            AppMethodBeat.o(251279);
            return true;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
            final /* synthetic */ hn $event;
            final /* synthetic */ n vuh;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(n nVar, hn hnVar) {
                super(0);
                this.vuh = nVar;
                this.$event = hnVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                boolean z;
                boolean z2;
                boolean z3;
                AppMethodBeat.i(251278);
                Log.i(this.vuh.vue.TAG, "feedChangeListener " + this.$event.dLW.id);
                switch (this.$event.dLW.type) {
                    case 0:
                        if (this.$event.dLW.id != 0) {
                            e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                            hn.a aVar2 = this.$event.dLW;
                            if (aVar2 == null) {
                                kotlin.g.b.p.hyc();
                            }
                            if (e.a.Fy(aVar2.id) != null) {
                                Iterator it = this.vuh.vue.vua.iterator();
                                int i2 = 0;
                                while (true) {
                                    if (it.hasNext()) {
                                        bo boVar = (bo) it.next();
                                        if (!(boVar instanceof BaseFinderFeed) || ((BaseFinderFeed) boVar).feedObject.getId() != this.$event.dLW.id) {
                                            z3 = false;
                                        } else {
                                            z3 = true;
                                        }
                                        if (!z3) {
                                            i2++;
                                        }
                                    } else {
                                        i2 = -1;
                                    }
                                }
                                if (i2 != -1) {
                                    this.vuh.uMv.e(i2, 1, 1);
                                    break;
                                }
                            }
                        }
                        break;
                    case 4:
                        if (this.$event.dLW.id != 0) {
                            Iterator it2 = this.vuh.vue.vua.iterator();
                            int i3 = 0;
                            while (true) {
                                if (it2.hasNext()) {
                                    bo boVar2 = (bo) it2.next();
                                    if (!(boVar2 instanceof BaseFinderFeed) || ((BaseFinderFeed) boVar2).feedObject.getId() != this.$event.dLW.id) {
                                        z2 = false;
                                    } else {
                                        z2 = true;
                                    }
                                    if (!z2) {
                                        i3++;
                                    }
                                } else {
                                    i3 = -1;
                                }
                            }
                            if (i3 != -1) {
                                this.vuh.uMv.e(i3, 1, new kotlin.o(3, 1));
                                break;
                            }
                        }
                        break;
                    case 5:
                        if (this.$event.dLW.id != 0) {
                            Iterator it3 = this.vuh.vue.vua.iterator();
                            int i4 = 0;
                            while (true) {
                                if (it3.hasNext()) {
                                    bo boVar3 = (bo) it3.next();
                                    if (!(boVar3 instanceof BaseFinderFeed) || ((BaseFinderFeed) boVar3).feedObject.getId() != this.$event.dLW.id) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (!z) {
                                        i4++;
                                    }
                                } else {
                                    i4 = -1;
                                }
                            }
                            if (i4 != -1) {
                                this.vuh.uMv.e(i4, 1, new kotlin.o(4, 1));
                                break;
                            }
                        }
                        break;
                }
                x xVar = x.SXb;
                AppMethodBeat.o(251278);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final com.tencent.mm.plugin.finder.video.k getVideoCore() {
        return this.tCD;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.ab8;
    }

    @Override // com.tencent.mm.ui.search.a.b
    public final void onClickBackBtn(View view) {
        AppMethodBeat.i(166773);
        hideVKB();
        finish();
        AppMethodBeat.o(166773);
    }

    public final void onClickCancelBtn(View view) {
        AppMethodBeat.i(166774);
        hideVKB();
        finish();
        AppMethodBeat.o(166774);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void dpw() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0022, code lost:
        if (r0 == null) goto L_0x0024;
     */
    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r6, java.lang.String r7, java.util.List<com.tencent.mm.ui.search.a.c> r8, com.tencent.mm.ui.search.FTSEditTextView.b r9) {
        /*
        // Method dump skipped, instructions count: 101
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.FinderFeedSearchUI.a(java.lang.String, java.lang.String, java.util.List, com.tencent.mm.ui.search.FTSEditTextView$b):void");
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void eh(boolean z) {
        AppMethodBeat.i(166776);
        if (z) {
            com.tencent.mm.plugin.finder.report.l lVar = com.tencent.mm.plugin.finder.report.l.vfB;
            com.tencent.mm.plugin.finder.report.l.doe();
        }
        AppMethodBeat.o(166776);
    }

    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    public final void onClickClearTextBtn(View view) {
        AppMethodBeat.i(166779);
        com.tencent.mm.ui.search.a aVar = this.ubO;
        if (aVar == null) {
            kotlin.g.b.p.btv("searchView");
        }
        aVar.getFtsEditText().awD();
        showVKB();
        AppMethodBeat.o(166779);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        if (r0 == null) goto L_0x003e;
     */
    @Override // com.tencent.mm.ui.search.FTSEditTextView.a
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean awE() {
        /*
        // Method dump skipped, instructions count: 110
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.FinderFeedSearchUI.awE():boolean");
    }

    @Override // com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.widget.SwipeBackLayout.a
    public final void onSwipeBack() {
        AppMethodBeat.i(251292);
        super.onSwipeBack();
        hideVKB();
        AppMethodBeat.o(251292);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-finder_release"})
    public static final class b implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ FinderFeedSearchUI vue;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(FinderFeedSearchUI finderFeedSearchUI) {
            this.vue = finderFeedSearchUI;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(166749);
            switch (i2) {
                case 2:
                case 3001:
                    if (this.vue.tPW) {
                        com.tencent.mm.plugin.finder.convert.q qVar = new com.tencent.mm.plugin.finder.convert.q(this.vue, false, 0, 6);
                        AppMethodBeat.o(166749);
                        return qVar;
                    }
                    u uVar = new u(this.vue, false, 0, 6);
                    AppMethodBeat.o(166749);
                    return uVar;
                case 4:
                case 3002:
                    if (this.vue.tPW) {
                        com.tencent.mm.plugin.finder.convert.t tVar = new com.tencent.mm.plugin.finder.convert.t(this.vue.tCD, this.vue, false, 0, 12);
                        AppMethodBeat.o(166749);
                        return tVar;
                    }
                    com.tencent.mm.plugin.finder.convert.ak akVar = new com.tencent.mm.plugin.finder.convert.ak(this.vue.tCD, this.vue, false, 0, 12);
                    AppMethodBeat.o(166749);
                    return akVar;
                case 9:
                    if (this.vue.tPW) {
                        com.tencent.mm.plugin.finder.convert.r rVar = new com.tencent.mm.plugin.finder.convert.r(this.vue.tCD, this.vue, 0, 0, 28);
                        AppMethodBeat.o(166749);
                        return rVar;
                    }
                    com.tencent.mm.plugin.finder.convert.x xVar = new com.tencent.mm.plugin.finder.convert.x(this.vue.tCD, this.vue);
                    AppMethodBeat.o(166749);
                    return xVar;
                default:
                    com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                    AppMethodBeat.o(166749);
                    return fVar;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class f implements o.f {
        final /* synthetic */ BaseFinderFeed tEM;
        final /* synthetic */ FinderFeedSearchUI vue;

        f(FinderFeedSearchUI finderFeedSearchUI, BaseFinderFeed baseFinderFeed) {
            this.vue = finderFeedSearchUI;
            this.tEM = baseFinderFeed;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            boolean z;
            boolean z2;
            com.tencent.mm.plugin.finder.event.a b2;
            boolean z3 = true;
            AppMethodBeat.i(166753);
            String string = this.vue.getContext().getString(R.string.yz);
            kotlin.g.b.p.g(string, "context.getString(R.string.app_share_to_weixin)");
            String string2 = this.vue.getContext().getString(R.string.d9p);
            kotlin.g.b.p.g(string2, "context.getString(R.string.finder_share_timeline)");
            kotlin.g.b.p.g(this.vue.getContext().getString(R.string.c8z), "context.getString(R.string.favorite)");
            if (this.tEM.feedObject.isOnlySelfSee() || this.tEM.feedObject.isNotShare()) {
                y yVar = y.vXH;
                string = y.dP("FinderSafeSelfSeeForward", R.string.d8u);
                y yVar2 = y.vXH;
                string2 = y.dP("FinderSafeSelfSeeShare", R.string.d8v);
                y yVar3 = y.vXH;
                y.dP("FinderSafeSelfSeeCollect", R.string.d8t);
                z = true;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            AppCompatActivity context = this.vue.getContext();
            kotlin.g.b.p.g(context, "context");
            mVar.a(this.vue.tqv, string, R.raw.finder_icons_filled_share, context.getResources().getColor(R.color.Brand), z2);
            mVar.a(this.vue.pLU, string2, R.raw.bottomsheet_icon_moment, 0, z);
            if (this.vue.tPW) {
                c.a aVar = com.tencent.mm.plugin.finder.upload.action.c.vUa;
                if (com.tencent.mm.plugin.finder.upload.action.c.vTZ.k(this.tEM.feedObject.getFeedObject())) {
                    z3 = false;
                }
                if (z3) {
                    AppCompatActivity context2 = this.vue.getContext();
                    kotlin.g.b.p.g(context2, "context");
                    mVar.a(this.vue.tLK, this.vue.getContext().getString(R.string.c8z), R.raw.finder_icons_filled_star2, context2.getResources().getColor(R.color.a3b));
                } else {
                    AppCompatActivity context3 = this.vue.getContext();
                    kotlin.g.b.p.g(context3, "context");
                    mVar.a(this.vue.tLL, this.vue.getContext().getString(R.string.cir), R.raw.finder_icons_filled_unstar2, context3.getResources().getColor(R.color.a3b));
                }
            }
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.I(this.tEM.lT(), 6);
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.vue);
            if (fH == null || (b2 = FinderReporterUIC.b(fH)) == null) {
                AppMethodBeat.o(166753);
                return;
            }
            b2.cZR().Ew(this.tEM.lT());
            AppMethodBeat.o(166753);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final o.f a(BaseFinderFeed baseFinderFeed, com.tencent.mm.ui.widget.a.e eVar) {
        AppMethodBeat.i(166781);
        kotlin.g.b.p.h(baseFinderFeed, "feed");
        kotlin.g.b.p.h(eVar, "sheet");
        f fVar = new f(this, baseFinderFeed);
        AppMethodBeat.o(166781);
        return fVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class g implements o.f {
        final /* synthetic */ BaseFinderFeed tEM;
        final /* synthetic */ FinderFeedSearchUI vue;

        g(FinderFeedSearchUI finderFeedSearchUI, BaseFinderFeed baseFinderFeed) {
            this.vue = finderFeedSearchUI;
            this.tEM = baseFinderFeed;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(166754);
            y yVar = y.vXH;
            if (y.C(this.tEM.feedObject)) {
                int i2 = this.vue.tLJ;
                y yVar2 = y.vXH;
                mVar.a(i2, y.x(this.tEM), R.raw.finder_bgm_gif_first_page, !this.tEM.feedObject.isPostFinish() || this.tEM.feedObject.isPostFailed());
            }
            if (!FinderFeedSearchUI.p(this.tEM)) {
                mVar.b(this.vue.pMa, this.vue.getContext().getString(R.string.f3g), R.raw.icons_outlined_report_problem);
            }
            AppMethodBeat.o(166754);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final o.f i(BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(166782);
        kotlin.g.b.p.h(baseFinderFeed, "feed");
        g gVar = new g(this, baseFinderFeed);
        AppMethodBeat.o(166782);
        return gVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    static final class h implements o.g {
        final /* synthetic */ BaseFinderFeed tEM;
        final /* synthetic */ FinderFeedSearchUI vue;

        h(FinderFeedSearchUI finderFeedSearchUI, BaseFinderFeed baseFinderFeed) {
            this.vue = finderFeedSearchUI;
            this.tEM = baseFinderFeed;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            int i3;
            azr azr = null;
            AppMethodBeat.i(166759);
            String str = this.vue.TAG;
            StringBuilder append = new StringBuilder("getMoreMenuItemSelectedListener feed ").append(this.tEM).append(' ').append(i2).append(" menuItem:");
            kotlin.g.b.p.g(menuItem, "menuItem");
            Log.i(str, append.append(menuItem.getItemId()).toString());
            int itemId = menuItem.getItemId();
            if (itemId == this.vue.tLD) {
                int indexOf = this.vue.vua.indexOf(this.tEM);
                if (indexOf >= 0) {
                    final RecyclerView.f itemAnimator = FinderFeedSearchUI.b(this.vue).getItemAnimator();
                    v vVar = new v();
                    vVar.lz();
                    FinderFeedSearchUI.b(this.vue).setItemAnimator(vVar);
                    FinderFeedSearchUI.b(this.vue).postDelayed(new Runnable(this) {
                        /* class com.tencent.mm.plugin.finder.search.FinderFeedSearchUI.h.AnonymousClass1 */
                        final /* synthetic */ h vuf;

                        {
                            this.vuf = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(166755);
                            FinderFeedSearchUI.b(this.vuf.vue).setItemAnimator(itemAnimator);
                            AppMethodBeat.o(166755);
                        }
                    }, vVar.ly());
                    Log.i(this.vue.TAG, "defaultItemAnimator.removeDuration =" + vVar.ly());
                    com.tencent.mm.plugin.finder.feed.logic.c cVar = com.tencent.mm.plugin.finder.feed.logic.c.tUx;
                    AppCompatActivity context = this.vue.getContext();
                    kotlin.g.b.p.g(context, "context");
                    com.tencent.mm.plugin.finder.feed.logic.c.a(context, this.tEM.feedObject.getId(), this.tEM.feedObject.getObjectNonceId(), new kotlin.g.a.b<Integer, LinkedList<Long>>(this) {
                        /* class com.tencent.mm.plugin.finder.search.FinderFeedSearchUI.h.AnonymousClass2 */
                        final /* synthetic */ h vuf;

                        {
                            this.vuf = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // kotlin.g.a.b
                        public final /* synthetic */ LinkedList<Long> invoke(Integer num) {
                            String str;
                            String str2;
                            AppMethodBeat.i(178403);
                            int intValue = num.intValue();
                            LinkedList linkedList = new LinkedList();
                            Iterator it = this.vuf.vue.vua.iterator();
                            kotlin.g.b.p.g(it, "feedList.iterator()");
                            int i2 = 0;
                            while (it.hasNext()) {
                                Object next = it.next();
                                kotlin.g.b.p.g(next, "iterator.next()");
                                bo boVar = (bo) next;
                                if (boVar instanceof BaseFinderFeed) {
                                    com.tencent.mm.plugin.finder.api.g gVar = ((BaseFinderFeed) boVar).contact;
                                    if (gVar != null) {
                                        str = gVar.field_username;
                                    } else {
                                        str = null;
                                    }
                                    com.tencent.mm.plugin.finder.api.g gVar2 = this.vuf.tEM.contact;
                                    if (gVar2 != null) {
                                        str2 = gVar2.field_username;
                                    } else {
                                        str2 = null;
                                    }
                                    if (kotlin.g.b.p.j(str, str2)) {
                                        it.remove();
                                        linkedList.add(Long.valueOf(((BaseFinderFeed) boVar).feedObject.m21getCreateTime()));
                                        RecyclerView.a adapter = FinderFeedSearchUI.b(this.vuf.vue).getAdapter();
                                        if (adapter != null) {
                                            adapter.ck(i2);
                                        }
                                        Log.i(this.vuf.vue.TAG, "[UNINTEREST] removeAt " + i2 + " subType=" + intValue);
                                    }
                                }
                                i2++;
                            }
                            AppMethodBeat.o(178403);
                            return linkedList;
                        }
                    });
                    AppMethodBeat.o(166759);
                    return;
                }
                Log.i(this.vue.TAG, "[UNINTEREST] pos error ".concat(String.valueOf(indexOf)));
                AppMethodBeat.o(166759);
                return;
            }
            if (itemId == this.vue.tzW) {
                if (this.tEM.contact == null) {
                    AppMethodBeat.o(166759);
                    return;
                }
            } else if (itemId == this.vue.tqv) {
                s.a.a(s.vWt, this.vue, this.tEM.feedObject, 3, 4);
                AppMethodBeat.o(166759);
                return;
            } else if (itemId == this.vue.pLU) {
                s.a aVar = s.vWt;
                s.a.a(this.vue, this.tEM, 0, 0, 28);
                AppMethodBeat.o(166759);
                return;
            } else if (itemId == this.vue.tLE) {
                com.tencent.mm.plugin.finder.utils.g gVar = com.tencent.mm.plugin.finder.utils.g.vVq;
                com.tencent.mm.plugin.finder.utils.g.a(this.tEM, this.vue);
                AppMethodBeat.o(166759);
                return;
            } else if (itemId == this.vue.pMa) {
                y yVar = y.vXH;
                if (y.w(this.tEM)) {
                    awe liveInfo = this.tEM.feedObject.getLiveInfo();
                    if (liveInfo != null) {
                        long j2 = liveInfo.liveId;
                        com.tencent.mm.plugin.finder.feed.logic.a aVar2 = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                        AppCompatActivity context2 = this.vue.getContext();
                        kotlin.g.b.p.g(context2, "context");
                        com.tencent.mm.plugin.finder.feed.logic.a.b(context2, j2, this.tEM.feedObject.getUserName());
                        AppMethodBeat.o(166759);
                        return;
                    }
                    AppMethodBeat.o(166759);
                    return;
                }
                com.tencent.mm.plugin.finder.feed.logic.a aVar3 = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                AppCompatActivity context3 = this.vue.getContext();
                kotlin.g.b.p.g(context3, "context");
                com.tencent.mm.plugin.finder.feed.logic.a.a(context3, this.tEM.feedObject.field_id, 0, 0, 12);
                AppMethodBeat.o(166759);
                return;
            } else if (itemId == this.vue.tLF) {
                Intent intent = new Intent();
                FinderObjectDesc finderObjectDesc = this.tEM.feedObject.getFeedObject().objectDesc;
                intent.putExtra("postRefMediaList", finderObjectDesc != null ? finderObjectDesc.toByteArray() : null);
                y yVar2 = y.vXH;
                intent.putExtra("postRefFeedInfo", y.u(this.tEM).toByteArray());
                intent.putExtra("postType", this.tEM.feedObject.getMediaType());
                intent.putExtra("key_finder_post_from", 5);
                com.tencent.mm.plugin.finder.utils.a aVar4 = com.tencent.mm.plugin.finder.utils.a.vUU;
                AppCompatActivity context4 = this.vue.getContext();
                kotlin.g.b.p.g(context4, "context");
                com.tencent.mm.plugin.finder.utils.a.enterFinderPostUI(context4, intent);
                AppMethodBeat.o(166759);
                return;
            } else if (itemId == this.vue.tLH) {
                ((com.tencent.mm.plugin.i.a.v) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.v.class)).a(this.tEM.feedObject.getId(), this.tEM.feedObject.getFeedObject(), this.tEM.feedObject.getObjectNonceId(), true, new ai<ayy>(this) {
                    /* class com.tencent.mm.plugin.finder.search.FinderFeedSearchUI.h.AnonymousClass3 */
                    final /* synthetic */ h vuf;

                    /* JADX WARN: Incorrect args count in method signature: ()V */
                    {
                        this.vuf = r1;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
                    @Override // com.tencent.mm.plugin.i.a.ai
                    public final /* synthetic */ void a(ayy ayy, apg apg) {
                        AppMethodBeat.i(166758);
                        kotlin.g.b.p.h(ayy, "req");
                        kotlin.g.b.p.h(apg, "ret");
                        if (apg.retCode == 0) {
                            com.tencent.mm.ui.base.u.makeText(this.vuf.vue.getContext(), (int) R.string.cnn, 0).show();
                            AppMethodBeat.o(166758);
                            return;
                        }
                        com.tencent.mm.ui.base.u.makeText(this.vuf.vue.getContext(), (int) R.string.cnm, 0).show();
                        Log.i(this.vuf.vue.TAG, "finder_feed_open_comment_no_ok " + apg.retCode);
                        AppMethodBeat.o(166758);
                    }
                });
                AppMethodBeat.o(166759);
                return;
            } else if (itemId == this.vue.tLG) {
                ((com.tencent.mm.plugin.i.a.v) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.v.class)).a(this.tEM.feedObject.getId(), this.tEM.feedObject.getFeedObject(), this.tEM.feedObject.getObjectNonceId(), false, new ai<ayy>(this) {
                    /* class com.tencent.mm.plugin.finder.search.FinderFeedSearchUI.h.AnonymousClass4 */
                    final /* synthetic */ h vuf;

                    /* JADX WARN: Incorrect args count in method signature: ()V */
                    {
                        this.vuf = r1;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.protocal.protobuf.apg] */
                    @Override // com.tencent.mm.plugin.i.a.ai
                    public final /* synthetic */ void a(ayy ayy, apg apg) {
                        AppMethodBeat.i(251267);
                        kotlin.g.b.p.h(ayy, "req");
                        kotlin.g.b.p.h(apg, "ret");
                        if (apg.retCode == 0) {
                            com.tencent.mm.ui.base.u.makeText(this.vuf.vue.getContext(), (int) R.string.cmp, 0).show();
                            AppMethodBeat.o(251267);
                            return;
                        }
                        com.tencent.mm.ui.base.u.makeText(this.vuf.vue.getContext(), (int) R.string.cmo, 0).show();
                        Log.i(this.vuf.vue.TAG, "finder_feed_close_comment_ok " + apg.retCode);
                        AppMethodBeat.o(251267);
                    }
                });
                AppMethodBeat.o(166759);
                return;
            } else if (itemId == this.vue.tLJ) {
                if (this.tEM.feedObject.isPostFinish()) {
                    FinderReporterUIC.a aVar5 = FinderReporterUIC.wzC;
                    AppCompatActivity context5 = this.vue.getContext();
                    kotlin.g.b.p.g(context5, "context");
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(context5);
                    if (fH != null) {
                        i3 = fH.tCE;
                    } else {
                        i3 = 0;
                    }
                    if (i3 != 52) {
                        e.a aVar6 = com.tencent.mm.plugin.finder.storage.data.e.vFX;
                        e.a.n(this.tEM.feedObject);
                        w wVar = w.vXp;
                        FinderObjectDesc finderObjectDesc2 = this.tEM.feedObject.getFeedObject().objectDesc;
                        if (finderObjectDesc2 != null) {
                            azr = finderObjectDesc2.feedBgmInfo;
                        }
                        w.a(azr, Long.valueOf(this.tEM.feedObject.field_id), 0);
                    } else if (this.vue.getContext() instanceof FinderTopicTimelineUI) {
                        AppCompatActivity context6 = this.vue.getContext();
                        if (context6 == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.ui.FinderTopicTimelineUI");
                            AppMethodBeat.o(166759);
                            throw tVar;
                        }
                        ((FinderTopicTimelineUI) context6).onBackPressed();
                    }
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    AppCompatActivity context7 = this.vue.getContext();
                    kotlin.g.b.p.g(context7, "context");
                    com.tencent.mm.plugin.finder.report.k.a(context7, 1, 1, Integer.valueOf(this.tEM.feedObject.field_finderObject.follow_feed_count));
                    AppMethodBeat.o(166759);
                    return;
                }
            } else if (itemId == this.vue.tLK) {
                AppCompatActivity context8 = this.vue.getContext();
                kotlin.g.b.p.g(context8, "context");
                com.tencent.mm.ui.base.u.a(this.vue.getContext(), context8.getResources().getString(R.string.cp8), new u.b(this) {
                    /* class com.tencent.mm.plugin.finder.search.FinderFeedSearchUI.h.AnonymousClass5 */
                    final /* synthetic */ h vuf;

                    {
                        this.vuf = r1;
                    }

                    @Override // com.tencent.mm.ui.base.u.b
                    public final void dU(View view) {
                        WeImageView weImageView;
                        TextView textView;
                        AppMethodBeat.i(251268);
                        if (!(view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null)) {
                            textView.setTextSize(1, 14.0f);
                        }
                        if (!(view == null || (weImageView = (WeImageView) view.findViewById(R.id.irc)) == null)) {
                            weImageView.setImageResource(R.raw.icons_filled_done);
                            Context context = weImageView.getContext();
                            kotlin.g.b.p.g(context, "context");
                            weImageView.setIconColor(context.getResources().getColor(R.color.ag1));
                        }
                        this.vuf.vue.a(this.vuf.tEM.feedObject, true, (com.tencent.mm.view.recyclerview.h) null);
                        AppMethodBeat.o(251268);
                    }
                });
                AppMethodBeat.o(166759);
                return;
            } else if (itemId == this.vue.tLL) {
                AppCompatActivity context9 = this.vue.getContext();
                kotlin.g.b.p.g(context9, "context");
                com.tencent.mm.ui.base.u.a(this.vue.getContext(), context9.getResources().getString(R.string.cp7), new u.b(this) {
                    /* class com.tencent.mm.plugin.finder.search.FinderFeedSearchUI.h.AnonymousClass6 */
                    final /* synthetic */ h vuf;

                    {
                        this.vuf = r1;
                    }

                    @Override // com.tencent.mm.ui.base.u.b
                    public final void dU(View view) {
                        WeImageView weImageView;
                        TextView textView;
                        AppMethodBeat.i(251269);
                        if (!(view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null)) {
                            textView.setTextSize(1, 14.0f);
                        }
                        if (!(view == null || (weImageView = (WeImageView) view.findViewById(R.id.irc)) == null)) {
                            weImageView.setImageResource(R.raw.icons_filled_done);
                            Context context = weImageView.getContext();
                            kotlin.g.b.p.g(context, "context");
                            weImageView.setIconColor(context.getResources().getColor(R.color.ag1));
                        }
                        this.vuf.vue.a(this.vuf.tEM.feedObject, false, (com.tencent.mm.view.recyclerview.h) null);
                        AppMethodBeat.o(251269);
                    }
                });
            }
            AppMethodBeat.o(166759);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    @SuppressLint({"ResourceType"})
    public final o.g j(BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(166783);
        kotlin.g.b.p.h(baseFinderFeed, "feed");
        h hVar = new h(this, baseFinderFeed);
        AppMethodBeat.o(166783);
        return hVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final void a(FinderItem finderItem, boolean z, com.tencent.mm.view.recyclerview.h hVar) {
        AppMethodBeat.i(251293);
        kotlin.g.b.p.h(finderItem, "feed");
        com.tencent.mm.plugin.finder.model.r rVar = com.tencent.mm.plugin.finder.model.r.uNW;
        com.tencent.mm.plugin.finder.model.r.a(this, finderItem, z);
        AppMethodBeat.o(251293);
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final void a(FinderItem finderItem) {
        AppMethodBeat.i(251294);
        kotlin.g.b.p.h(finderItem, "feed");
        s.a.a(s.vWt, this, finderItem, 0, 12);
        AppMethodBeat.o(251294);
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final void k(BaseFinderFeed baseFinderFeed) {
        AppMethodBeat.i(251295);
        kotlin.g.b.p.h(baseFinderFeed, "feed");
        s.a aVar = s.vWt;
        s.a.a(this, baseFinderFeed, 4, 0, 20);
        AppMethodBeat.o(251295);
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final void a(BaseFinderFeed baseFinderFeed, boolean z, boolean z2, int i2, boolean z3) {
        AppMethodBeat.i(251296);
        kotlin.g.b.p.h(baseFinderFeed, "feed");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx();
        aj ajVar = aj.uOw;
        FinderItem finderItem = baseFinderFeed.feedObject;
        boolean z4 = baseFinderFeed.showLikeTips;
        y yVar = y.vXH;
        aj.a(dIx, i2, finderItem, z, z2, 2, z4, z3, y.i(baseFinderFeed.contact));
        AppMethodBeat.o(251296);
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final void b(BaseFinderFeed baseFinderFeed, boolean z) {
        String str;
        int i2;
        String str2;
        int i3;
        String username;
        String username2;
        AppMethodBeat.i(166785);
        kotlin.g.b.p.h(baseFinderFeed, "feed");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        AppCompatActivity context = getContext();
        kotlin.g.b.p.g(context, "context");
        bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(context).get(FinderReporterUIC.class)).dIx();
        ag agVar = ag.uOs;
        com.tencent.mm.plugin.finder.api.g gVar = baseFinderFeed.contact;
        if (gVar == null || (username2 = gVar.getUsername()) == null) {
            str = "";
        } else {
            str = username2;
        }
        if (z) {
            bb.a aVar2 = bb.tve;
            i2 = bb.tvb;
        } else {
            bb.a aVar3 = bb.tve;
            i2 = bb.tvc;
        }
        com.tencent.mm.kernel.g.azz().b(ag.a(dIx, str, i2));
        c.a aVar4 = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g gVar2 = baseFinderFeed.contact;
        if (gVar2 == null || (username = gVar2.getUsername()) == null) {
            str2 = "";
        } else {
            str2 = username;
        }
        if (z) {
            g.a aVar5 = com.tencent.mm.plugin.finder.api.g.tsD;
            i3 = com.tencent.mm.plugin.finder.api.g.tsB;
        } else {
            g.a aVar6 = com.tencent.mm.plugin.finder.api.g.tsD;
            i3 = com.tencent.mm.plugin.finder.api.g.tsC;
        }
        c.a.du(str2, i3);
        AppMethodBeat.o(166785);
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final RecyclerView.m dcf() {
        return this.tLO;
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final void a(FinderItem finderItem, FinderCommentInfo finderCommentInfo) {
        AppMethodBeat.i(166786);
        kotlin.g.b.p.h(finderItem, "feed");
        kotlin.g.b.p.h(finderCommentInfo, FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
        AppMethodBeat.o(166786);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        com.tencent.mm.plugin.finder.event.base.c a2;
        AppMethodBeat.i(166787);
        i iVar = i.vvu;
        i.dqb().clear();
        h hVar = this.vtK;
        if (hVar == null) {
            kotlin.g.b.p.btv("historyLogic");
        }
        hVar.onDestroy();
        com.tencent.mm.plugin.finder.storage.data.f.vGd.clearCache();
        EventCenter.instance.removeListener(this.vuc);
        com.tencent.mm.kernel.g.azz().b(3820, this);
        hideVKB();
        dcW().onDetach();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.c a3 = FinderReporterUIC.a((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class));
        if (a3 != null) {
            a3.b(dcW());
        }
        dcX().onDetach();
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        AppCompatActivity context = getContext();
        kotlin.g.b.p.g(context, "context");
        FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
        if (!(fH == null || (a2 = FinderReporterUIC.a(fH)) == null)) {
            a2.b(dcX());
        }
        IListener<hn> iListener = this.vub;
        if (iListener != null) {
            iListener.dead();
        }
        com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
        if (eVar == null) {
            kotlin.g.b.p.btv("drawer");
        }
        eVar.onDetach();
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            kotlin.g.b.p.btv("recyclerView");
        }
        recyclerView.b(this.vud);
        super.onDestroy();
        AppMethodBeat.o(166787);
    }

    static /* synthetic */ void a(FinderFeedSearchUI finderFeedSearchUI, String str) {
        AppMethodBeat.i(251298);
        finderFeedSearchUI.a(str, (com.tencent.mm.bw.b) null, false);
        AppMethodBeat.o(251298);
    }

    private final void a(String str, com.tencent.mm.bw.b bVar, boolean z) {
        AppMethodBeat.i(251297);
        this.query = str;
        this.offset = 0;
        this.continueFlag = 0;
        this.tVM = null;
        this.vua.clear();
        String uuid = UUID.randomUUID().toString();
        kotlin.g.b.p.g(uuid, "UUID.randomUUID().toString()");
        this.dPI = uuid;
        if (this.vtL != null) {
            com.tencent.mm.kernel.g.azz().a(this.vtL);
        }
        int i2 = z ? 10 : 0;
        int i3 = this.offset;
        String str2 = this.dPI;
        com.tencent.mm.bw.b bVar2 = this.tVM;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        this.vtL = new cf(str, i3, str2, bVar2, i2, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this).get(FinderReporterUIC.class)).dIx(), bVar);
        cf cfVar = this.vtL;
        if (cfVar != null) {
            cfVar.twi = this.twi;
        }
        cf cfVar2 = this.vtL;
        if (cfVar2 != null) {
            cfVar2.twj = z;
        }
        com.tencent.mm.kernel.g.azz().b(this.vtL);
        com.tencent.mm.kernel.g.azz().a(3820, this);
        View view = this.hSw;
        if (view == null) {
            kotlin.g.b.p.btv("loadingView");
        }
        view.setVisibility(0);
        TextView textView = this.vtJ;
        if (textView == null) {
            kotlin.g.b.p.btv("noResultView");
        }
        textView.setVisibility(8);
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            kotlin.g.b.p.btv("rlLayout");
        }
        refreshLoadMoreLayout.setVisibility(8);
        RecyclerView recyclerView = this.hak;
        if (recyclerView == null) {
            kotlin.g.b.p.btv("recyclerView");
        }
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "startSearch", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Z)V", "Undefined", "scrollToPosition", "(I)V");
        recyclerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI", "startSearch", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;Z)V", "Undefined", "scrollToPosition", "(I)V");
        AppMethodBeat.o(251297);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        RecyclerView.a adapter;
        boolean z;
        AppMethodBeat.i(166789);
        com.tencent.mm.kernel.g.azz().b(3820, this);
        int size = this.vua.size();
        int size2 = this.vua.size();
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 7, 1, false);
            cf cfVar = this.vtL;
            bcb bcb = cfVar != null ? cfVar.twl : null;
            if (bcb == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSearchResponse");
                AppMethodBeat.o(166789);
                throw tVar;
            }
            LinkedList<FinderObject> linkedList = bcb.tbD;
            kotlin.g.b.p.g(linkedList, "response.objectList");
            LinkedList<FinderObject> linkedList2 = linkedList;
            ArrayList arrayList = new ArrayList(kotlin.a.j.a(linkedList2, 10));
            for (T t : linkedList2) {
                kotlin.g.b.p.g(t, LocaleUtil.ITALIAN);
                i((FinderObject) t);
                arrayList.add(x.SXb);
            }
            this.offset = bcb.offset;
            this.continueFlag = bcb.continueFlag;
            this.tVM = bcb.tVM;
            int size3 = this.vua.size();
            Log.i(this.TAG, "onSceneEnd " + bcb.offset + ' ' + bcb.continueFlag + ' ' + this.vua.size());
            cf cfVar2 = this.vtL;
            if (cfVar2 != null) {
                z = cfVar2.twi;
            } else {
                z = false;
            }
            String str2 = this.query;
            boolean isEmpty = bcb.tbD.isEmpty();
            cf cfVar3 = this.vtL;
            boolean z2 = cfVar3 != null && cfVar3.twj;
            int i4 = z ? 2 : 1;
            if (z2) {
                i4 = 3;
            }
            int i5 = isEmpty ? 1 : 2;
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
            String dob = com.tencent.mm.plugin.finder.report.k.dob();
            String str3 = this.dPI;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            AppCompatActivity context = getContext();
            kotlin.g.b.p.g(context, "context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            com.tencent.mm.plugin.finder.report.k.a(dob, str3, str2, 3, i4, 2, 0, i5, fH != null ? fH.dIx() : null);
            size2 = size3;
        } else {
            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1265, 8, 1, false);
        }
        RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
        if (refreshLoadMoreLayout == null) {
            kotlin.g.b.p.btv("rlLayout");
        }
        refreshLoadMoreLayout.apT(size2);
        if (size2 == 0) {
            View view = this.hSw;
            if (view == null) {
                kotlin.g.b.p.btv("loadingView");
            }
            view.setVisibility(8);
            TextView textView = this.vtJ;
            if (textView == null) {
                kotlin.g.b.p.btv("noResultView");
            }
            textView.setVisibility(0);
            RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.tLS;
            if (refreshLoadMoreLayout2 == null) {
                kotlin.g.b.p.btv("rlLayout");
            }
            refreshLoadMoreLayout2.setVisibility(8);
        } else {
            View view2 = this.hSw;
            if (view2 == null) {
                kotlin.g.b.p.btv("loadingView");
            }
            view2.setVisibility(8);
            TextView textView2 = this.vtJ;
            if (textView2 == null) {
                kotlin.g.b.p.btv("noResultView");
            }
            textView2.setVisibility(8);
            RefreshLoadMoreLayout refreshLoadMoreLayout3 = this.tLS;
            if (refreshLoadMoreLayout3 == null) {
                kotlin.g.b.p.btv("rlLayout");
            }
            refreshLoadMoreLayout3.setVisibility(0);
        }
        if (size == 0) {
            RecyclerView recyclerView = this.hak;
            if (recyclerView == null) {
                kotlin.g.b.p.btv("recyclerView");
            }
            RecyclerView.a adapter2 = recyclerView.getAdapter();
            if (adapter2 != null) {
                adapter2.notifyDataSetChanged();
                AppMethodBeat.o(166789);
                return;
            }
            AppMethodBeat.o(166789);
            return;
        }
        if (size < size2) {
            RecyclerView recyclerView2 = this.hak;
            if (recyclerView2 == null) {
                kotlin.g.b.p.btv("recyclerView");
            }
            if (!(recyclerView2 == null || (adapter = recyclerView2.getAdapter()) == null)) {
                adapter.as(size, size2 - size);
                AppMethodBeat.o(166789);
                return;
            }
        }
        AppMethodBeat.o(166789);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void K(long r16, int r18) {
        /*
        // Method dump skipped, instructions count: 169
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.search.FinderFeedSearchUI.K(long, int):void");
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final MMActivity getActivity() {
        return this;
    }

    @Override // com.tencent.mm.plugin.finder.feed.i
    public final boolean dbZ() {
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/search/FinderFeedSearchUI$FinderFeedSearchReporter;", "Lcom/tencent/mm/plugin/finder/event/base/EventObserver;", "(Lcom/tencent/mm/plugin/finder/search/FinderFeedSearchUI;)V", "onEventHappen", "", "event", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "plugin-finder_release"})
    public final class a extends com.tencent.mm.plugin.finder.event.base.d {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a() {
        }

        @Override // com.tencent.mm.plugin.finder.event.base.d
        public final void a(com.tencent.mm.plugin.finder.event.base.b bVar) {
            int i2;
            int i3;
            AppMethodBeat.i(166748);
            kotlin.g.b.p.h(bVar, "event");
            if ((bVar instanceof com.tencent.mm.plugin.finder.event.base.h) && ((((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 5 || ((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 0 || ((com.tencent.mm.plugin.finder.event.base.h) bVar).type == 1) && (i2 = ((com.tencent.mm.plugin.finder.event.base.h) bVar).tIy) <= (i3 = ((com.tencent.mm.plugin.finder.event.base.h) bVar).tIA))) {
                while (true) {
                    if (i2 < FinderFeedSearchUI.this.vua.size() && i2 >= 0) {
                        FinderFeedSearchUI.this.K(((bo) FinderFeedSearchUI.this.vua.get(i2)).lT(), i2);
                    }
                    if (i2 == i3) {
                        break;
                    }
                    i2++;
                }
            }
            AppMethodBeat.o(166748);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(178405);
        super.onResume();
        com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
        if (eVar == null) {
            kotlin.g.b.p.btv("drawer");
        }
        eVar.onUIResume();
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "6", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_RESUME);
        if (!this.vtZ) {
            RecyclerView recyclerView = this.hak;
            if (recyclerView == null) {
                kotlin.g.b.p.btv("recyclerView");
            }
            recyclerView.post(new r(this));
            AppMethodBeat.o(178405);
            return;
        }
        this.vtZ = false;
        AppMethodBeat.o(178405);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class r implements Runnable {
        final /* synthetic */ FinderFeedSearchUI vue;

        r(FinderFeedSearchUI finderFeedSearchUI) {
            this.vue = finderFeedSearchUI;
        }

        public final void run() {
            AppMethodBeat.i(251283);
            FinderFeedSearchUI.A(this.vue);
            AppMethodBeat.o(251283);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onPause() {
        AppMethodBeat.i(178406);
        super.onPause();
        if (this.tLT == null) {
            kotlin.g.b.p.btv("drawer");
        }
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "6", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_PAUSE);
        AppMethodBeat.o(178406);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$feedExposeInfoChangeListener$1", "Lcom/tencent/mm/plugin/finder/view/FinderExposeChangedEventListener;", "tag", "", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getFeedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "feedId", "", "notifyAdapter", "", "exposeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExposeInfo;", "plugin-finder_release"})
    public static final class d extends com.tencent.mm.plugin.finder.view.f {
        private String tag;
        final /* synthetic */ FinderFeedSearchUI vue;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderFeedSearchUI finderFeedSearchUI) {
            this.vue = finderFeedSearchUI;
            AppMethodBeat.i(166752);
            this.tag = finderFeedSearchUI.TAG;
            AppMethodBeat.o(166752);
        }

        @Override // com.tencent.mm.plugin.finder.view.f
        public final String getTag() {
            return this.tag;
        }

        @Override // com.tencent.mm.plugin.finder.view.f
        public final FinderItem EB(long j2) {
            AppMethodBeat.i(166750);
            RecyclerView.a adapter = FinderFeedSearchUI.b(this.vue).getAdapter();
            if (adapter == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                AppMethodBeat.o(166750);
                throw tVar;
            }
            RecyclerView.v vVar = ((com.tencent.mm.view.recyclerview.g) adapter).V(j2, false);
            if (vVar != null) {
                bo boVar = (bo) this.vue.vua.get(vVar.lR());
                if (boVar instanceof BaseFinderFeed) {
                    FinderItem finderItem = ((BaseFinderFeed) boVar).feedObject;
                    AppMethodBeat.o(166750);
                    return finderItem;
                }
            }
            AppMethodBeat.o(166750);
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.view.f
        public final void a(long j2, azt azt) {
            AppMethodBeat.i(166751);
            RecyclerView b2 = FinderFeedSearchUI.b(this.vue);
            RecyclerView.a adapter = b2.getAdapter();
            if (adapter == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
                AppMethodBeat.o(166751);
                throw tVar;
            }
            RecyclerView.v vVar = ((com.tencent.mm.view.recyclerview.g) adapter).V(j2, false);
            if (vVar != null) {
                int lR = vVar.lR();
                RecyclerView.a adapter2 = b2.getAdapter();
                if (adapter2 != null) {
                    adapter2.b(lR, new kotlin.o(1, azt));
                    AppMethodBeat.o(166751);
                    return;
                }
                AppMethodBeat.o(166751);
                return;
            }
            AppMethodBeat.o(166751);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        return 6;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 2;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$mOnScrollListener$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class q extends RecyclerView.l {
        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(251282);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$mOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$mOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(251282);
        }

        q() {
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(251281);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$mOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "6", com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/search/FinderFeedSearchUI$mOnScrollListener$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(251281);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.d> {
        final /* synthetic */ FinderFeedSearchUI vue;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderFeedSearchUI finderFeedSearchUI) {
            super(0);
            this.vue = finderFeedSearchUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.feed.model.d invoke() {
            AppMethodBeat.i(251265);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.feed.model.d dVar = ((FinderCommentPreloaderUIC) com.tencent.mm.ui.component.a.b(this.vue).get(FinderCommentPreloaderUIC.class)).tLy;
            AppMethodBeat.o(251265);
            return dVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.finder.feed.model.f> {
        final /* synthetic */ FinderFeedSearchUI vue;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderFeedSearchUI finderFeedSearchUI) {
            super(0);
            this.vue = finderFeedSearchUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.finder.feed.model.f invoke() {
            AppMethodBeat.i(251266);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.feed.model.f fVar = ((FinderLiveNoticePreLoadUIC) com.tencent.mm.ui.component.a.b(this.vue).get(FinderLiveNoticePreLoadUIC.class)).wyi;
            AppMethodBeat.o(251266);
            return fVar;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(166791);
        com.tencent.mm.plugin.finder.view.e eVar = this.tLT;
        if (eVar == null) {
            kotlin.g.b.p.btv("drawer");
        }
        if (eVar.dGs()) {
            com.tencent.mm.plugin.finder.view.e eVar2 = this.tLT;
            if (eVar2 == null) {
                kotlin.g.b.p.btv("drawer");
            }
            eVar2.dGr();
            AppMethodBeat.o(166791);
            return;
        }
        FinderLikeDrawer finderLikeDrawer = this.tLV;
        if (finderLikeDrawer == null) {
            kotlin.g.b.p.btv("friendLikeDrawer");
        }
        if (finderLikeDrawer.dGs()) {
            FinderLikeDrawer finderLikeDrawer2 = this.tLV;
            if (finderLikeDrawer2 == null) {
                kotlin.g.b.p.btv("friendLikeDrawer");
            }
            finderLikeDrawer2.dGr();
            AppMethodBeat.o(166791);
            return;
        }
        finish();
        AppMethodBeat.o(166791);
    }

    public static final /* synthetic */ boolean p(BaseFinderFeed baseFinderFeed) {
        String str;
        AppMethodBeat.i(166797);
        com.tencent.mm.plugin.finder.api.g gVar = baseFinderFeed.contact;
        if (gVar != null) {
            str = gVar.field_username;
        } else {
            str = null;
        }
        boolean I = kotlin.n.n.I(str, z.aUg(), false);
        AppMethodBeat.o(166797);
        return I;
    }

    public static final /* synthetic */ void A(FinderFeedSearchUI finderFeedSearchUI) {
        AppMethodBeat.i(251300);
        RecyclerView recyclerView = finderFeedSearchUI.hak;
        if (recyclerView == null) {
            kotlin.g.b.p.btv("recyclerView");
        }
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView recyclerView2 = finderFeedSearchUI.hak;
            if (recyclerView2 == null) {
                kotlin.g.b.p.btv("recyclerView");
            }
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            if (layoutManager == null) {
                t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(251300);
                throw tVar;
            }
            int ks = ((LinearLayoutManager) layoutManager).ks();
            RecyclerView recyclerView3 = finderFeedSearchUI.hak;
            if (recyclerView3 == null) {
                kotlin.g.b.p.btv("recyclerView");
            }
            RecyclerView.LayoutManager layoutManager2 = recyclerView3.getLayoutManager();
            if (layoutManager2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                AppMethodBeat.o(251300);
                throw tVar2;
            }
            int ku = ((LinearLayoutManager) layoutManager2).ku();
            if (ks <= ku) {
                while (true) {
                    if (ks >= 0 && ks < finderFeedSearchUI.vua.size()) {
                        finderFeedSearchUI.K(finderFeedSearchUI.vua.get(ks).lT(), ks);
                    }
                    if (ks == ku) {
                        break;
                    }
                    ks++;
                }
            }
        }
        AppMethodBeat.o(251300);
    }
}
