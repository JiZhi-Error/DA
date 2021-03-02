package com.tencent.mm.plugin.finder.megavideo.convert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.megavideo.ui.MegaVideoTLFooterLayout;
import com.tencent.mm.plugin.finder.megavideo.ui.f;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.model.aj;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.c;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.view.FinderMediaBanner;
import com.tencent.mm.plugin.finder.view.adapter.FinderMediaBannerAdapter;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.HardTouchableLayout;
import com.tencent.neattextview.textview.view.NeatTextView;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.List;
import org.json.JSONObject;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001DB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J(\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J6\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00162\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\u0018\u0010!\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0016J \u0010#\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010\u0014\u001a\u00020&H\u0002J\u0018\u0010'\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010(\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010)\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010*\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J@\u0010+\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010,\u001a\u00020\u001d2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0016J \u00100\u001a\u00020\t2\u0006\u00101\u001a\u0002022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J \u00103\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00104\u001a\u0002052\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u00106\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u00107\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u00108\u001a\u00020\u0016H\u0002J\u0018\u00109\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J \u0010:\u001a\u00020\t2\u0006\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J0\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u001a\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\u00192\b\u0010B\u001a\u0004\u0018\u00010CH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "videoCore", "Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;", "presenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;", "(Lcom/tencent/mm/plugin/finder/video/FinderVideoCore;Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTLPresenter;)V", "calculateBannerLayoutParam", "", "banner", "Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "mediaList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "feedId", "", "convertMedia", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "", "type", "createLikeFloatIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "doFav", "doLike", "isPrivate", "", "likeAction", "e", "Landroid/view/MotionEvent;", "doShare", "getLayoutId", "getLikeIcon", "filled", "private", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "initFoldButtons", "initFooterLayout", "initHeaderLayout", "initToggleHeaderAndFooter", "onBindViewHolder", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onMediaDoubleClick", "view", "Landroid/view/View;", "openCommentDrawer", "refreshCommentLayout", "totalCommentCount", "refreshDescContent", "refreshFavLayout", "isFav", "favCount", "refreshLikeLayout", "isLike", "likeCount", "setGroupLikeIcon", "imageView", "wordingConfig", "Lcom/tencent/mm/protocal/protobuf/FinderObjectExtInfo;", "Companion", "plugin-finder_release"})
public final class a extends com.tencent.mm.view.recyclerview.e<bm> {
    private static final int tzZ = 10003;
    public static final C1214a uKl = new C1214a((byte) 0);
    private final com.tencent.mm.plugin.finder.video.k tCD;
    private final com.tencent.mm.plugin.finder.megavideo.ui.f uKk;

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0006"}, hxF = {"<anonymous>", "", "isLoading", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$convertMedia$2$2$3", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$$special$$inlined$run$lambda$3"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.b<Boolean, kotlin.x> {
        final /* synthetic */ FinderMediaBanner tBM;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderMediaBanner finderMediaBanner, a aVar, com.tencent.mm.view.recyclerview.h hVar, bm bmVar) {
            super(1);
            this.tBM = finderMediaBanner;
            this.uKm = aVar;
            this.tzq = hVar;
            this.uKn = bmVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(Boolean bool) {
            AppMethodBeat.i(248286);
            if (bool.booleanValue()) {
                View Mn = this.tzq.Mn(R.id.gcc);
                kotlin.g.b.p.g(Mn, "view");
                Mn.setVisibility(4);
                Mn.setEnabled(false);
                MMProcessBar mMProcessBar = (MMProcessBar) this.tzq.Mn(R.id.epi);
                if (mMProcessBar != null) {
                    mMProcessBar.setVisibility(0);
                    mMProcessBar.gYP();
                }
            } else {
                View Mn2 = this.tzq.Mn(R.id.gcc);
                kotlin.g.b.p.g(Mn2, "view");
                Mn2.setVisibility(0);
                Mn2.setEnabled(true);
                MMProcessBar mMProcessBar2 = (MMProcessBar) this.tzq.Mn(R.id.epi);
                if (mMProcessBar2 != null) {
                    mMProcessBar2.setVisibility(8);
                    mMProcessBar2.gYO();
                }
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(248286);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(a aVar, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        AppMethodBeat.i(248340);
        aVar.b(hVar, i2);
        AppMethodBeat.o(248340);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x010d, code lost:
        if (r1 == null) goto L_0x010f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01c1  */
    @Override // com.tencent.mm.view.recyclerview.e
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h r11, com.tencent.mm.plugin.finder.model.bm r12, int r13, int r14, boolean r15, java.util.List r16) {
        /*
        // Method dump skipped, instructions count: 678
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.megavideo.convert.a.a(com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List):void");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J/\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$Companion;", "", "()V", "FULLSCREEN_FLAG", "", "MENU_ID_ONLY_POSTER_CAN_SEE", "MENU_ID_SHARE_TO_FRIEND", "MENU_ID_SHARE_TO_SNS", "TAG", "", "payloadsProgressType", "payloadsRefreshBullet", "payloadsRefreshFav", "payloadsRefreshLike", "payloadsRefreshNormalData", "onConfigurationChange", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "isLandscape", "", "resetAnimViews", "toggleHeaderFooter", "item", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "forceShow", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;Landroid/app/Activity;Ljava/lang/Boolean;)V", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.megavideo.convert.a$a  reason: collision with other inner class name */
    public static final class C1214a {
        private C1214a() {
        }

        public /* synthetic */ C1214a(byte b2) {
            this();
        }

        public static void p(com.tencent.mm.view.recyclerview.h hVar) {
            AppMethodBeat.i(248282);
            MegaVideoTLFooterLayout megaVideoTLFooterLayout = (MegaVideoTLFooterLayout) hVar.Mn(R.id.d8j);
            megaVideoTLFooterLayout.setListenKeyBoardChange(false);
            megaVideoTLFooterLayout.setShowKeyboard(false);
            kotlin.g.b.p.g(megaVideoTLFooterLayout, LocaleUtil.ITALIAN);
            megaVideoTLFooterLayout.setTranslationY(0.0f);
            FrameLayout pagerViewContainer = ((FinderMediaBanner) hVar.Mn(R.id.fbd)).getPagerViewContainer();
            pagerViewContainer.setTranslationY(0.0f);
            pagerViewContainer.setScaleX(1.0f);
            pagerViewContainer.setScaleY(1.0f);
            View Mn = hVar.Mn(R.id.izw);
            kotlin.g.b.p.g(Mn, "holder.getView<View>(R.id.unfold_video_button)");
            Mn.setTranslationY(0.0f);
            MegaVideoTLFooterLayout megaVideoTLFooterLayout2 = (MegaVideoTLFooterLayout) hVar.Mn(R.id.d8j);
            megaVideoTLFooterLayout2.uMH = null;
            megaVideoTLFooterLayout2.uMI = null;
            megaVideoTLFooterLayout2.uMG = false;
            AppMethodBeat.o(248282);
        }

        public static void a(com.tencent.mm.view.recyclerview.h hVar, bm bmVar, Activity activity, Boolean bool) {
            int i2 = 0;
            AppMethodBeat.i(248283);
            kotlin.g.b.p.h(hVar, "holder");
            kotlin.g.b.p.h(bmVar, "item");
            kotlin.g.b.p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            View Mn = hVar.Mn(R.id.fd_);
            View Mn2 = hVar.Mn(R.id.d8j);
            kotlin.g.b.p.g(Mn2, "footer");
            int i3 = Mn2.getVisibility() == 0 ? 8 : 0;
            if (kotlin.g.b.p.j(bool, Boolean.TRUE)) {
                if (Mn2.getVisibility() == 0) {
                    AppMethodBeat.o(248283);
                    return;
                }
            } else if (!kotlin.g.b.p.j(bool, Boolean.FALSE)) {
                i2 = i3;
            } else if (Mn2.getVisibility() == 8) {
                AppMethodBeat.o(248283);
                return;
            } else {
                i2 = 8;
            }
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            Resources resources = context.getResources();
            kotlin.g.b.p.g(resources, "holder.context.resources");
            if (resources.getConfiguration().orientation == 1) {
                kotlin.g.b.p.g(Mn, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
                Mn.setVisibility(i2);
                Mn2.setVisibility(i2);
                if (bmVar.djo()) {
                    View Mn3 = hVar.Mn(R.id.izw);
                    kotlin.g.b.p.g(Mn3, "holder.getView<View>(R.id.unfold_video_button)");
                    Mn3.setVisibility(i2);
                    AppMethodBeat.o(248283);
                    return;
                }
            } else {
                if (i2 == 8) {
                    Window window = activity.getWindow();
                    kotlin.g.b.p.g(window, "activity.window");
                    View decorView = window.getDecorView();
                    kotlin.g.b.p.g(decorView, "activity.window.decorView");
                    Window window2 = activity.getWindow();
                    kotlin.g.b.p.g(window2, "activity.window");
                    View decorView2 = window2.getDecorView();
                    kotlin.g.b.p.g(decorView2, "activity.window.decorView");
                    decorView.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 2054);
                } else {
                    Window window3 = activity.getWindow();
                    kotlin.g.b.p.g(window3, "activity.window");
                    View decorView3 = window3.getDecorView();
                    kotlin.g.b.p.g(decorView3, "activity.window.decorView");
                    Window window4 = activity.getWindow();
                    kotlin.g.b.p.g(window4, "activity.window");
                    View decorView4 = window4.getDecorView();
                    kotlin.g.b.p.g(decorView4, "activity.window.decorView");
                    decorView3.setSystemUiVisibility(decorView4.getSystemUiVisibility() & -2055);
                }
                Mn2.setVisibility(i2);
            }
            AppMethodBeat.o(248283);
        }
    }

    public a(com.tencent.mm.plugin.finder.video.k kVar, com.tencent.mm.plugin.finder.megavideo.ui.f fVar) {
        kotlin.g.b.p.h(kVar, "videoCore");
        kotlin.g.b.p.h(fVar, "presenter");
        AppMethodBeat.i(248333);
        this.tCD = kVar;
        this.uKk = fVar;
        AppMethodBeat.o(248333);
    }

    static {
        AppMethodBeat.i(248334);
        AppMethodBeat.o(248334);
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final int getLayoutId() {
        return R.layout.ag_;
    }

    @Override // com.tencent.mm.view.recyclerview.e
    public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
        AppMethodBeat.i(248324);
        kotlin.g.b.p.h(recyclerView, "recyclerView");
        kotlin.g.b.p.h(hVar, "holder");
        FinderMediaBanner finderMediaBanner = (FinderMediaBanner) hVar.Mn(R.id.fbd);
        FinderMediaBannerAdapter finderMediaBannerAdapter = new FinderMediaBannerAdapter(this.tCD);
        finderMediaBannerAdapter.isLongVideo = true;
        finderMediaBanner.setAdapter(finderMediaBannerAdapter);
        finderMediaBanner.setParentRecyclerView(recyclerView);
        finderMediaBanner.getIndicator().setShowOnlyOneIndicator(false);
        AppMethodBeat.o(248324);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class u implements View.OnLongClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        u(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        public final boolean onLongClick(View view) {
            com.tencent.mm.plugin.finder.loader.s sVar;
            com.tencent.mm.plugin.finder.storage.x xVar;
            String str;
            String str2;
            String str3;
            FinderVideoLayout.b playInfo;
            AppMethodBeat.i(248319);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            bm bmVar = (bm) this.qhp.hgv();
            FinderVideoLayout finderVideoLayout = (FinderVideoLayout) this.qhp.Mn(R.id.ckd);
            if (finderVideoLayout == null || (playInfo = finderVideoLayout.getPlayInfo()) == null) {
                sVar = null;
            } else {
                sVar = playInfo.uPf;
            }
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            Context context = this.qhp.getContext();
            if (context == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
                AppMethodBeat.o(248319);
                throw tVar;
            }
            FinderDebugUIC finderDebugUIC = (FinderDebugUIC) com.tencent.mm.ui.component.a.b((MMFragmentActivity) context).get(FinderDebugUIC.class);
            Context context2 = this.qhp.getContext();
            kotlin.g.b.p.g(context2, "holder.context");
            kotlin.g.b.p.g(bmVar, "item");
            com.tencent.mm.view.recyclerview.h hVar = this.qhp;
            kotlin.g.b.p.h(context2, "context");
            kotlin.g.b.p.h(bmVar, "item");
            kotlin.g.b.p.h(hVar, "holder");
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(context2, 0, false);
            long lT = bmVar.lT();
            JSONObject jSONObject = new JSONObject();
            JSONObject put = jSONObject.put("tag", "ClickMoreDebug").put("feedId", com.tencent.mm.ac.d.zs(lT)).put("signedFeedId", lT);
            cng cng = bmVar.tuP;
            JSONObject put2 = put.put("feedTime", Util.formatUnixTime(((long) (cng != null ? cng.iXu : 0)) * 1));
            cjl cjl = (cjl) kotlin.a.j.kt(bmVar.dkV());
            JSONObject put3 = put2.put("videoDuration", cjl != null ? Integer.valueOf(cjl.videoDuration) : null).put("isMegaVideo", true);
            if (sVar != null) {
                xVar = sVar.uIx;
            } else {
                xVar = null;
            }
            JSONObject put4 = put3.put("file_format", xVar);
            FinderContact finderContact = bmVar.contact;
            if (finderContact == null || (str = finderContact.username) == null) {
                str = "";
            }
            JSONObject put5 = put4.put(ch.COL_USERNAME, str);
            c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
            FinderContact finderContact2 = bmVar.contact;
            JSONObject put6 = put5.put("isFollow", c.a.asJ(finderContact2 != null ? finderContact2.username : null));
            cjl cjl2 = (cjl) kotlin.a.j.kt(bmVar.dkV());
            JSONObject put7 = put6.put("mediaType", cjl2 != null ? cjl2.mediaType : 0);
            cjl cjl3 = (cjl) kotlin.a.j.kt(bmVar.dkV());
            if (cjl3 == null || (str2 = cjl3.url) == null) {
                str2 = "";
            }
            JSONObject put8 = put7.put("mediaId", MD5Util.getMD5String(str2));
            cjl cjl4 = (cjl) kotlin.a.j.kt(bmVar.dkV());
            JSONObject put9 = put8.put("url", cjl4 != null ? kotlin.g.b.p.I(cjl4.url, Util.nullAsNil(cjl4.url_token)) : null);
            cjl cjl5 = (cjl) kotlin.a.j.kt(bmVar.dkV());
            JSONObject put10 = put9.put("thumbUrl", cjl5 != null ? kotlin.g.b.p.I(cjl5.thumbUrl, Util.nullAsNil(cjl5.thumb_url_token)) : null);
            cjl cjl6 = (cjl) kotlin.a.j.kt(bmVar.dkV());
            JSONObject put11 = put10.put("coverUrl", cjl6 != null ? kotlin.g.b.p.I(cjl6.coverUrl, Util.nullAsNil(cjl6.cover_url_token)) : null).put("description", bmVar.dkV());
            cng cng2 = bmVar.tuP;
            if (cng2 == null || (str3 = cng2.debugMessage) == null) {
                str3 = "";
            }
            put11.put("debugMessage", str3);
            StringBuilder sb = new StringBuilder("content=");
            cng cng3 = bmVar.tuP;
            if (cng3 == null) {
                cng3 = new cng();
            }
            String buv = kotlin.n.n.buv(sb.append(com.tencent.mm.ac.g.bN(cng3)).toString());
            Log.e(FinderDebugUIC.TAG, "long click more button! ".concat(String.valueOf(jSONObject)));
            Log.e(FinderDebugUIC.TAG, "long click more button allInfo! ".concat(String.valueOf(buv)));
            if (FinderDebugUIC.dHZ()) {
                eVar.a(new FinderDebugUIC.f(finderDebugUIC));
                eVar.a(new FinderDebugUIC.g(finderDebugUIC, context2, jSONObject, lT, bmVar, buv, hVar));
                eVar.dGm();
            }
            this.qhp.aus.requestLayout();
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(248319);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class v implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ a uKm;

        v(a aVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.uKm = aVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248321);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            bm bmVar = (bm) this.qhp.hgv();
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(this.qhp.getContext(), 0, false);
            com.tencent.mm.plugin.finder.megavideo.ui.f fVar = this.uKm.uKk;
            kotlin.g.b.p.g(bmVar, "item");
            kotlin.g.b.p.h(bmVar, "feed");
            kotlin.g.b.p.h(eVar, "sheet");
            eVar.a(new f.g(fVar, bmVar));
            com.tencent.mm.plugin.finder.megavideo.ui.f fVar2 = this.uKm.uKk;
            kotlin.g.b.p.h(bmVar, "feed");
            eVar.b(new f.h(fVar2, bmVar));
            eVar.a(this.uKm.uKk.a(bmVar, this.qhp));
            eVar.b(this.uKm.uKk.a(bmVar, this.qhp));
            eVar.b(new e.b(this) {
                /* class com.tencent.mm.plugin.finder.megavideo.convert.a.v.AnonymousClass1 */
                final /* synthetic */ v uKz;

                {
                    this.uKz = r1;
                }

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                    AppMethodBeat.i(248320);
                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                    Context context = this.uKz.qhp.getContext();
                    kotlin.g.b.p.g(context, "holder.context");
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
                    bbn dIx = fH != null ? fH.dIx() : null;
                    bm bmVar = (bm) this.uKz.qhp.hgv();
                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                    kotlin.g.b.p.g(bmVar, "feed");
                    com.tencent.mm.plugin.finder.report.k.a(bmVar, 2, 3, "", dIx);
                    AppMethodBeat.o(248320);
                }
            });
            eVar.dGm();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248321);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class w implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKq;

        w(a aVar, com.tencent.mm.view.recyclerview.h hVar, bm bmVar) {
            this.uKm = aVar;
            this.qhp = hVar;
            this.uKq = bmVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248322);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderVideoLayout finderVideoLayout = (FinderVideoLayout) this.qhp.Mn(R.id.ckd);
            com.tencent.mm.plugin.finder.megavideo.ui.f.a(this.uKm.uKk, this.uKq, this.qhp, finderVideoLayout != null ? finderVideoLayout.getCurrentPosSec() : 0);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$onBindViewHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248322);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class q implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ a uKm;

        q(a aVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.uKm = aVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248315);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initHeaderLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.uKm.uKk.nJ(true)) {
                Context context = this.qhp.getContext();
                if (context == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(248315);
                    throw tVar;
                }
                ((Activity) context).finish();
                this.uKm.uKk.dcl().overridePendingTransition(R.anim.s, R.anim.ej);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initHeaderLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248315);
        }
    }

    private final void a(com.tencent.mm.view.recyclerview.h hVar, bm bmVar) {
        String str;
        String str2;
        String str3;
        AppMethodBeat.i(248326);
        hVar.Mn(R.id.b46).setOnClickListener(new q(this, hVar));
        FinderContact finderContact = bmVar.contact;
        String str4 = finderContact != null ? finderContact.username : null;
        if (str4 != null) {
            FinderContact finderContact2 = bmVar.contact;
            if (finderContact2 != null) {
                str2 = finderContact2.headUrl;
            } else {
                str2 = null;
            }
            String nullAsNil = Util.nullAsNil(str2);
            c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.g asG = c.a.asG(str4);
            if (asG != null) {
                if (!Util.isNullOrNil(asG.cXH())) {
                    str3 = asG.cXH();
                } else {
                    str3 = nullAsNil;
                }
                y yVar = y.vXH;
                View Mn = hVar.Mn(R.id.w0);
                kotlin.g.b.p.g(Mn, "holder.getView<ImageView>(R.id.auth_icon)");
                y.a((ImageView) Mn, asG.field_authInfo);
            } else {
                str3 = nullAsNil;
            }
            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
            com.tencent.mm.plugin.finder.loader.a aVar2 = new com.tencent.mm.plugin.finder.loader.a(str3);
            View Mn2 = hVar.Mn(R.id.x1);
            kotlin.g.b.p.g(Mn2, "holder.getView(R.id.avatar_iv)");
            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
            dka.a(aVar2, (ImageView) Mn2, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
        }
        View Mn3 = hVar.Mn(R.id.fzg);
        kotlin.g.b.p.g(Mn3, "holder.getView<TextView>(R.id.nickname_tv)");
        TextView textView = (TextView) Mn3;
        Context context = hVar.getContext();
        FinderContact finderContact3 = bmVar.contact;
        textView.setText(com.tencent.mm.pluginsdk.ui.span.l.c(context, (finderContact3 == null || (str = finderContact3.nickname) == null) ? "" : str));
        hVar.Mn(R.id.x4).setOnClickListener(new r(this, hVar, str4, bmVar));
        if (bmVar.isPrivate()) {
            View Mn4 = hVar.Mn(R.id.er3);
            if (Mn4 != null) {
                Mn4.setVisibility(0);
                AppMethodBeat.o(248326);
                return;
            }
            AppMethodBeat.o(248326);
            return;
        }
        View Mn5 = hVar.Mn(R.id.er3);
        if (Mn5 != null) {
            Mn5.setVisibility(8);
            AppMethodBeat.o(248326);
            return;
        }
        AppMethodBeat.o(248326);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class r implements View.OnClickListener {
        final /* synthetic */ String hLl;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKq;

        r(a aVar, com.tencent.mm.view.recyclerview.h hVar, String str, bm bmVar) {
            this.uKm = aVar;
            this.qhp = hVar;
            this.hLl = str;
            this.uKq = bmVar;
        }

        public final void onClick(View view) {
            bbn dIx;
            AppMethodBeat.i(248316);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initHeaderLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            if (fH == null || (dIx = fH.dIx()) == null || dIx.tCE != 48) {
                Intent intent = new Intent();
                intent.putExtra("finder_username", this.hLl);
                intent.putExtra("KEY_FINDER_SELF_FLAG", kotlin.g.b.p.j(this.hLl, z.aUg()));
                intent.putExtra("key_enter_profile_tab", 2);
                FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                Context context2 = this.qhp.getContext();
                kotlin.g.b.p.g(context2, "holder.context");
                FinderReporterUIC.a.a(context2, intent, this.uKq.dkW(), 1, false, 64);
                com.tencent.mm.plugin.finder.utils.a aVar3 = com.tencent.mm.plugin.finder.utils.a.vUU;
                Context context3 = this.qhp.getContext();
                kotlin.g.b.p.g(context3, "holder.context");
                com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(context3, intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initHeaderLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248316);
                return;
            }
            this.uKm.uKk.dcl().finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initHeaderLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248316);
        }
    }

    private final void b(com.tencent.mm.view.recyclerview.h hVar, bm bmVar) {
        String str;
        AppMethodBeat.i(248327);
        View Mn = hVar.Mn(R.id.jj5);
        cng cng = bmVar.tuP;
        if ((cng != null ? cng.MtL : 0) != 0) {
            kotlin.g.b.p.g(Mn, "warnContainer");
            Mn.setVisibility(0);
            View Mn2 = hVar.Mn(R.id.jj8);
            kotlin.g.b.p.g(Mn2, "holder.getView<TextView>(R.id.warn_word_tv)");
            TextView textView = (TextView) Mn2;
            cng cng2 = bmVar.tuP;
            textView.setText((cng2 == null || (str = cng2.MtM) == null) ? "" : str);
        } else {
            kotlin.g.b.p.g(Mn, "warnContainer");
            Mn.setVisibility(8);
        }
        e(hVar, bmVar);
        View Mn3 = hVar.Mn(R.id.fc_);
        if (Mn3 != null) {
            Mn3.setOnClickListener(new l(this, bmVar, hVar));
        }
        View Mn4 = hVar.Mn(R.id.fch);
        if (Mn4 != null) {
            Mn4.setOnClickListener(new k(this, bmVar, hVar));
            cng cng3 = bmVar.tuP;
            int i2 = cng3 != null ? cng3.forwardCount : 0;
            String string = (!this.uKk.uLZ || i2 <= 0) ? Mn4.getContext().getString(R.string.d9k) : com.tencent.mm.plugin.finder.utils.k.gm(1, i2);
            View Mn5 = hVar.Mn(R.id.fcg);
            kotlin.g.b.p.g(Mn5, "holder.getView<TextView>…ega_video_share_count_tv)");
            ((TextView) Mn5).setText(string);
        }
        View Mn6 = hVar.Mn(R.id.fcc);
        if (Mn6 != null) {
            Mn6.setOnClickListener(new m(this, bmVar, hVar));
        }
        View Mn7 = hVar.Mn(R.id.fcc);
        if (Mn7 != null) {
            Mn7.setOnLongClickListener(new n(this, bmVar, hVar));
        }
        View Mn8 = hVar.Mn(R.id.fcc);
        if (Mn8 != null) {
            Mn8.setHapticFeedbackEnabled(false);
        }
        hVar.Mn(R.id.fc7).setOnClickListener(new o(this, hVar, bmVar));
        c.a aVar = com.tencent.mm.plugin.finder.upload.action.c.vUa;
        boolean k2 = com.tencent.mm.plugin.finder.upload.action.c.vTZ.k(bmVar.getFeedObject());
        c.a aVar2 = com.tencent.mm.plugin.finder.upload.action.c.vUa;
        b(k2, com.tencent.mm.plugin.finder.upload.action.c.vTZ.l(bmVar.getFeedObject()), hVar);
        j.a aVar3 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        boolean booleanValue = com.tencent.mm.plugin.finder.upload.action.j.vUv.m(bmVar.getFeedObject()).first.booleanValue();
        j.a aVar4 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        boolean booleanValue2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.m(bmVar.getFeedObject()).second.booleanValue();
        j.a aVar5 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        a(booleanValue, booleanValue2, com.tencent.mm.plugin.finder.upload.action.j.vUv.n(bmVar.getFeedObject()), hVar, bmVar);
        b(hVar, bmVar.getFeedObject().commentCount);
        AppMethodBeat.o(248327);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class l implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKq;

        l(a aVar, bm bmVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.uKm = aVar;
            this.uKq = bmVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(261227);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a.a(this.uKm, this.uKq, this.qhp);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261227);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$2$1"})
    public static final class k implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKn;

        k(a aVar, bm bmVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.uKm = aVar;
            this.uKn = bmVar;
            this.tzq = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(248296);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$$inlined$run$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a.b(this.uKm, this.uKn, this.tzq);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$$inlined$run$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248296);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class m implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKq;

        m(a aVar, bm bmVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.uKm = aVar;
            this.uKq = bmVar;
            this.qhp = hVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(261228);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a.a(this.uKm, this.uKq, this.qhp, false);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261228);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    public static final class n implements View.OnLongClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKq;

        n(a aVar, bm bmVar, com.tencent.mm.view.recyclerview.h hVar) {
            this.uKm = aVar;
            this.uKq = bmVar;
            this.qhp = hVar;
        }

        public final boolean onLongClick(View view) {
            com.tencent.mm.plugin.finder.api.g gVar;
            AppMethodBeat.i(261231);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtQ().value().intValue() == 1) {
                y yVar = y.vXH;
                FinderContact finderContact = this.uKq.contact;
                if (finderContact != null) {
                    gVar = com.tencent.mm.plugin.finder.api.b.a(finderContact, null);
                } else {
                    gVar = null;
                }
                if (!y.i(gVar)) {
                    WeImageView weImageView = (WeImageView) this.qhp.Mn(R.id.fca);
                    kotlin.g.b.p.g(weImageView, "view");
                    if ((weImageView.getTag() instanceof Integer) && kotlin.g.b.p.j(weImageView.getTag(), 0)) {
                        com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(this.qhp.getContext(), 1, true);
                        eVar.setTitleView(aa.jQ(this.qhp.getContext()).inflate(R.layout.aip, (ViewGroup) null));
                        eVar.a(new o.f(this) {
                            /* class com.tencent.mm.plugin.finder.megavideo.convert.a.n.AnonymousClass1 */
                            final /* synthetic */ n USq;

                            {
                                this.USq = r1;
                            }

                            @Override // com.tencent.mm.ui.base.o.f
                            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                                AppMethodBeat.i(261229);
                                kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
                                if (mVar.gKQ()) {
                                    int i2 = a.tzZ;
                                    Context context = this.USq.qhp.getContext();
                                    kotlin.g.b.p.g(context, "holder.context");
                                    mVar.d(i2, context.getResources().getString(R.string.d6_));
                                }
                                AppMethodBeat.o(261229);
                            }
                        });
                        eVar.a(new o.g(this) {
                            /* class com.tencent.mm.plugin.finder.megavideo.convert.a.n.AnonymousClass2 */
                            final /* synthetic */ n USq;

                            {
                                this.USq = r1;
                            }

                            @Override // com.tencent.mm.ui.base.o.g
                            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                                AppMethodBeat.i(261230);
                                kotlin.g.b.p.g(menuItem, "menuItem");
                                if (menuItem.getItemId() == a.tzZ) {
                                    a.a(this.USq.uKm, this.USq.uKq, this.USq.qhp, true);
                                }
                                AppMethodBeat.o(261230);
                            }
                        });
                        eVar.dGm();
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(261231);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class o implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKq;

        o(a aVar, com.tencent.mm.view.recyclerview.h hVar, bm bmVar) {
            this.uKm = aVar;
            this.qhp = hVar;
            this.uKq = bmVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(261232);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.uKm.uKk.dcl().setRequestedOrientation(12);
            a.a(this.uKm, this.qhp, this.uKq);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFooterLayout$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261232);
        }
    }

    private final void e(com.tencent.mm.view.recyclerview.h hVar, bm bmVar) {
        cnl cnl;
        String str;
        cnl cnl2;
        String str2;
        AppMethodBeat.i(261236);
        NeatTextView neatTextView = (NeatTextView) hVar.Mn(R.id.bn9);
        cng cng = bmVar.tuP;
        if (!TextUtils.isEmpty((cng == null || (cnl2 = cng.MtG) == null || (str2 = cnl2.description) == null) ? "" : str2)) {
            kotlin.g.b.p.g(neatTextView, "descriptionTv");
            neatTextView.setVisibility(0);
            Context context = hVar.getContext();
            cng cng2 = bmVar.tuP;
            neatTextView.aw(com.tencent.mm.pluginsdk.ui.span.l.c(context, (cng2 == null || (cnl = cng2.MtG) == null || (str = cnl.description) == null) ? "" : str));
            neatTextView.setOnClickListener(new t(this, hVar, bmVar));
            AppMethodBeat.o(261236);
            return;
        }
        kotlin.g.b.p.g(neatTextView, "descriptionTv");
        neatTextView.setVisibility(8);
        AppMethodBeat.o(261236);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class t implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKq;

        t(a aVar, com.tencent.mm.view.recyclerview.h hVar, bm bmVar) {
            this.uKm = aVar;
            this.qhp = hVar;
            this.uKq = bmVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(261235);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$refreshDescContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a.a(this.uKm, this.qhp, this.uKq);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$refreshDescContent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261235);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initToggleHeaderAndFooter$1$1", "Lcom/tencent/mm/view/HardTouchableLayout$OnSingleClickListener;", "onSingleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class s implements HardTouchableLayout.g {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKn;

        s(a aVar, com.tencent.mm.view.recyclerview.h hVar, bm bmVar) {
            this.uKm = aVar;
            this.tzq = hVar;
            this.uKn = bmVar;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.g
        public final void b(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(261233);
            kotlin.g.b.p.h(view, "view");
            C1214a aVar = a.uKl;
            C1214a.a(this.tzq, this.uKn, this.uKm.uKk.dcl(), null);
            AppMethodBeat.o(261233);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initToggleHeaderAndFooter$1$2", "Lcom/tencent/mm/view/HardTouchableLayout$OnDoubleClickListener;", "onDoubleClick", "", "view", "Landroid/view/View;", "e", "Landroid/view/MotionEvent;", "plugin-finder_release"})
    public static final class p implements HardTouchableLayout.b {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKn;

        p(a aVar, com.tencent.mm.view.recyclerview.h hVar, bm bmVar) {
            this.uKm = aVar;
            this.tzq = hVar;
            this.uKn = bmVar;
        }

        @Override // com.tencent.mm.view.HardTouchableLayout.b
        public final void a(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(261234);
            kotlin.g.b.p.h(view, "view");
            kotlin.g.b.p.h(motionEvent, "e");
            Log.i("Finder.FinderLongVideoConvert", "onDoubleClick " + ((bm) this.tzq.hgv()));
            a.a(this.uKm, this.tzq, motionEvent);
            AppMethodBeat.o(261234);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKq;

        i(a aVar, com.tencent.mm.view.recyclerview.h hVar, bm bmVar) {
            this.uKm = aVar;
            this.qhp = hVar;
            this.uKq = bmVar;
        }

        public final void onClick(View view) {
            String str;
            String str2;
            String str3;
            cns cns;
            AppMethodBeat.i(248294);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFoldButtons$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.uKm.uKk.dcl().setRequestedOrientation(12);
            view.postDelayed(new Runnable(this) {
                /* class com.tencent.mm.plugin.finder.megavideo.convert.a.i.AnonymousClass1 */
                final /* synthetic */ i uKr;

                {
                    this.uKr = r1;
                }

                public final void run() {
                    AppMethodBeat.i(248293);
                    Context context = this.uKr.qhp.getContext();
                    kotlin.g.b.p.g(context, "holder.context");
                    Resources resources = context.getResources();
                    kotlin.g.b.p.g(resources, "holder.context.resources");
                    if (resources.getConfiguration().orientation == 2) {
                        AppMethodBeat.o(248293);
                        return;
                    }
                    this.uKr.uKm.uKk.dcl().setRequestedOrientation(-1);
                    AppMethodBeat.o(248293);
                }
            }, 2000);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            bbn dIx = fH != null ? fH.dIx() : null;
            af afVar = af.viA;
            cng cng = this.uKq.tuP;
            String zs = com.tencent.mm.ac.d.zs((cng == null || (cns = cng.MtI) == null) ? 0 : cns.hFK);
            String zs2 = com.tencent.mm.ac.d.zs(this.uKq.lT());
            if (dIx == null || (str = dIx.sessionId) == null) {
                str = "";
            }
            if (dIx == null || (str2 = dIx.sGQ) == null) {
                str2 = "";
            }
            if (dIx == null || (str3 = dIx.sGE) == null) {
                str3 = "";
            }
            af.a(zs, zs2, 1, 2, str, str2, str3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFoldButtons$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248294);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class j implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKq;

        j(a aVar, com.tencent.mm.view.recyclerview.h hVar, bm bmVar) {
            this.uKm = aVar;
            this.qhp = hVar;
            this.uKq = bmVar;
        }

        public final void onClick(View view) {
            String str;
            String str2;
            String str3;
            cns cns;
            AppMethodBeat.i(248295);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFoldButtons$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.uKm.uKk.dcl().setRequestedOrientation(11);
            C1214a aVar = a.uKl;
            C1214a.p(this.qhp);
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            bbn dIx = fH != null ? fH.dIx() : null;
            af afVar = af.viA;
            cng cng = this.uKq.tuP;
            String zs = com.tencent.mm.ac.d.zs((cng == null || (cns = cng.MtI) == null) ? 0 : cns.hFK);
            String zs2 = com.tencent.mm.ac.d.zs(this.uKq.lT());
            if (dIx == null || (str = dIx.sessionId) == null) {
                str = "";
            }
            if (dIx == null || (str2 = dIx.sGQ) == null) {
                str2 = "";
            }
            if (dIx == null || (str3 = dIx.sGE) == null) {
                str3 = "";
            }
            af.a(zs, zs2, 1, 1, str, str2, str3);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$initFoldButtons$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(248295);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onViewCustomize"})
    public static final class e implements u.b {
        public static final e uKo = new e();

        static {
            AppMethodBeat.i(248288);
            AppMethodBeat.o(248288);
        }

        e() {
        }

        @Override // com.tencent.mm.ui.base.u.b
        public final void dU(View view) {
            TextView textView;
            AppMethodBeat.i(248287);
            if (view == null || (textView = (TextView) view.findViewById(R.id.ird)) == null) {
                AppMethodBeat.o(248287);
                return;
            }
            textView.setTextSize(1, 14.0f);
            AppMethodBeat.o(248287);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class f implements o.f {
        public static final f uKp = new f();

        static {
            AppMethodBeat.i(248290);
            AppMethodBeat.o(248290);
        }

        f() {
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(248289);
            kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.kV(10001, R.string.d9q);
                mVar.kV(10002, R.string.d9r);
            }
            AppMethodBeat.o(248289);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class g implements o.g {
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKq;

        g(a aVar, bm bmVar) {
            this.uKm = aVar;
            this.uKq = bmVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(248291);
            kotlin.g.b.p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 10001:
                    com.tencent.mm.plugin.finder.megavideo.ui.f fVar = this.uKm.uKk;
                    bm bmVar = this.uKq;
                    kotlin.g.b.p.h(bmVar, "megaVideo");
                    s.a aVar = com.tencent.mm.plugin.finder.utils.s.vWt;
                    AppCompatActivity appCompatActivity = fVar.uMk;
                    FinderItem.a aVar2 = FinderItem.Companion;
                    s.a.a(aVar, appCompatActivity, FinderItem.a.a(bmVar.getFeedObject(), 32768), 0, 12);
                    AppMethodBeat.o(248291);
                    return;
                case 10002:
                    com.tencent.mm.plugin.finder.megavideo.ui.f fVar2 = this.uKm.uKk;
                    bm bmVar2 = this.uKq;
                    kotlin.g.b.p.h(bmVar2, "megaVideo");
                    s.a aVar3 = com.tencent.mm.plugin.finder.utils.s.vWt;
                    AppCompatActivity appCompatActivity2 = fVar2.uMk;
                    FinderItem.a aVar4 = FinderItem.Companion;
                    s.a.a(appCompatActivity2, new ad(FinderItem.a.a(bmVar2.getFeedObject(), 32768)), 4, 0, 20);
                    break;
            }
            AppMethodBeat.o(248291);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class h implements e.b {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;

        h(com.tencent.mm.view.recyclerview.h hVar) {
            this.qhp = hVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(248292);
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = this.qhp.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            bbn dIx = fH != null ? fH.dIx() : null;
            bm bmVar = (bm) this.qhp.hgv();
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            kotlin.g.b.p.g(bmVar, "feed");
            com.tencent.mm.plugin.finder.report.k.a(bmVar, 1, 3, "", dIx);
            AppMethodBeat.o(248292);
        }
    }

    static /* synthetic */ void a(a aVar, bm bmVar, com.tencent.mm.view.recyclerview.h hVar, boolean z) {
        AppMethodBeat.i(261238);
        aVar.a(bmVar, hVar, z, 1, (MotionEvent) null);
        AppMethodBeat.o(261238);
    }

    private final void a(bm bmVar, com.tencent.mm.view.recyclerview.h hVar, boolean z, int i2, MotionEvent motionEvent) {
        boolean z2;
        int i3;
        AppMethodBeat.i(261237);
        y yVar = y.vXH;
        if (!y.c(bmVar.tuP)) {
            y yVar2 = y.vXH;
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            String string = hVar.getContext().getString(R.string.d60);
            kotlin.g.b.p.g(string, "holder.context.getString….finder_private_ban_like)");
            y.aF(context, string);
            AppMethodBeat.o(261237);
            return;
        }
        j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        boolean booleanValue = com.tencent.mm.plugin.finder.upload.action.j.vUv.m(bmVar.getFeedObject()).first.booleanValue();
        if (!booleanValue) {
            WeImageView f2 = f(hVar);
            f2.setLayerPaint(null);
            com.tencent.mm.plugin.finder.storage.logic.g gVar = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
            azu Lj = com.tencent.mm.plugin.finder.storage.logic.g.Lj(bmVar.getFeedObject().objectType);
            String str = Lj == null ? "" : Lj.LJE;
            if (z) {
                a(f2, Lj);
            } else {
                y yVar3 = y.vXH;
                FinderContact finderContact = bmVar.contact;
                if (y.i(finderContact != null ? com.tencent.mm.plugin.finder.api.b.a(finderContact, null) : null)) {
                    Context context2 = hVar.getContext();
                    Context context3 = hVar.getContext();
                    kotlin.g.b.p.g(context3, "holder.context");
                    f2.setImageDrawable(ar.m(context2, R.raw.finder_filled_like_lock, context3.getResources().getColor(R.color.Red_90)));
                } else {
                    String str2 = str;
                    if (!(str2 == null || str2.length() == 0)) {
                        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                        com.tencent.mm.plugin.finder.loader.m.djY().a(new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE), f2, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
                    } else {
                        Context context4 = hVar.getContext();
                        Context context5 = hVar.getContext();
                        kotlin.g.b.p.g(context5, "holder.context");
                        f2.setImageDrawable(ar.m(context4, R.raw.finder_full_like, context5.getResources().getColor(R.color.Red_90)));
                    }
                }
            }
            com.tencent.mm.plugin.finder.view.animation.c cVar = com.tencent.mm.plugin.finder.view.animation.c.wrB;
            com.tencent.mm.plugin.finder.view.animation.c.a((View) f2, 1.4f, motionEvent, true, 16);
            hVar.aus.performHapticFeedback(0, 3);
        }
        com.tencent.mm.plugin.finder.megavideo.ui.f fVar = this.uKk;
        if (!booleanValue) {
            z2 = true;
        } else {
            z2 = false;
        }
        kotlin.g.b.p.h(bmVar, "feed");
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(fVar.uMk).get(FinderReporterUIC.class)).dIx();
        aj ajVar = aj.uOw;
        FinderItem.a aVar3 = FinderItem.Companion;
        FinderItem a2 = FinderItem.a.a(bmVar.getFeedObject(), 32768);
        j.a aVar4 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
        boolean booleanValue2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.m(bmVar.getFeedObject()).second.booleanValue();
        y yVar4 = y.vXH;
        FinderContact finderContact2 = bmVar.contact;
        aj.a(dIx, i2, a2, z2, z, 2, false, booleanValue2, y.i(finderContact2 != null ? com.tencent.mm.plugin.finder.api.b.a(finderContact2, null) : null));
        hn hnVar = new hn();
        hnVar.dLW.id = bmVar.dkW();
        hnVar.dLW.type = 4;
        hn.a aVar5 = hnVar.dLW;
        if (!z2) {
            i3 = 0;
        } else if (z) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        aVar5.dLZ = i3;
        EventCenter.instance.publish(hnVar);
        AppMethodBeat.o(261237);
    }

    private final void b(com.tencent.mm.view.recyclerview.h hVar, int i2) {
        String string;
        AppMethodBeat.i(248328);
        int i3 = this.uKk.uLZ ? 1 : 2;
        if (i2 > 0) {
            string = com.tencent.mm.plugin.finder.utils.k.gm(i3, i2);
        } else {
            string = hVar.getContext().getString(R.string.cje);
        }
        View Mn = hVar.Mn(R.id.fc6);
        kotlin.g.b.p.g(Mn, "holder.getView<TextView>…a_video_comment_count_tv)");
        ((TextView) Mn).setText(string);
        AppMethodBeat.o(248328);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$openCommentDrawer$onCloseDrawerCallback$1", "Lcom/tencent/mm/plugin/finder/presenter/contract/CommentDrawerContract$CloseDrawerCallback;", "onClose", "", "commentCount", "", "data", "", "Lcom/tencent/mm/plugin/finder/model/FinderFeedComment;", "plugin-finder_release"})
    public static final class x implements CommentDrawerContract.CloseDrawerCallback {
        final /* synthetic */ com.tencent.mm.view.recyclerview.h qhp;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKq;

        x(a aVar, com.tencent.mm.view.recyclerview.h hVar, bm bmVar) {
            this.uKm = aVar;
            this.qhp = hVar;
            this.uKq = bmVar;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.contract.CommentDrawerContract.CloseDrawerCallback
        public final void g(int i2, List<? extends com.tencent.mm.plugin.finder.model.s> list) {
            AppMethodBeat.i(248323);
            kotlin.g.b.p.h(list, "data");
            a.a(this.uKm, this.qhp, this.uKq.getFeedObject().commentCount);
            hv hvVar = new hv();
            hvVar.dMr.feedId = this.uKq.getFeedObject().id;
            hvVar.dMr.dMt = this.uKq.getFeedObject().commentCount;
            EventCenter.instance.publish(hvVar);
            this.uKm.uKk.dcl().setRequestedOrientation(-1);
            AppMethodBeat.o(248323);
        }
    }

    private static WeImageView f(com.tencent.mm.view.recyclerview.h hVar) {
        AppMethodBeat.i(261239);
        WeImageView weImageView = new WeImageView(hVar.getContext());
        weImageView.setVisibility(4);
        Context context = hVar.getContext();
        kotlin.g.b.p.g(context, "holder.context");
        int dimension = (int) context.getResources().getDimension(R.dimen.co);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dimension, dimension);
        layoutParams.gravity = 17;
        weImageView.setLayoutParams(layoutParams);
        weImageView.setImageResource(R.raw.finder_full_like);
        Context context2 = hVar.getContext();
        kotlin.g.b.p.g(context2, "holder.context");
        weImageView.setIconColor(context2.getResources().getColor(R.color.Red_90));
        View Mn = hVar.Mn(R.id.fbg);
        if (!(Mn instanceof ViewGroup)) {
            Mn = null;
        }
        ViewGroup viewGroup = (ViewGroup) Mn;
        if (viewGroup != null) {
            viewGroup.addView(weImageView);
        }
        AppMethodBeat.o(261239);
        return weImageView;
    }

    private final void a(boolean z, boolean z2, int i2, com.tencent.mm.view.recyclerview.h hVar, bm bmVar) {
        kotlin.o oVar;
        com.tencent.mm.plugin.finder.api.g gVar;
        String str;
        int i3;
        String string;
        boolean z3 = true;
        AppMethodBeat.i(248329);
        WeImageView weImageView = (WeImageView) hVar.Mn(R.id.fca);
        if (z) {
            if (z2) {
                kotlin.g.b.p.g(weImageView, "likeIv");
                weImageView.setTag(2);
            } else {
                kotlin.g.b.p.g(weImageView, "likeIv");
                weImageView.setTag(1);
            }
            Integer valueOf = Integer.valueOf(a(true, z2, bmVar.getFeedObject()));
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            oVar = new kotlin.o(valueOf, Integer.valueOf(context.getResources().getColor(R.color.Red_90)));
        } else {
            kotlin.g.b.p.g(weImageView, "likeIv");
            weImageView.setTag(0);
            Integer valueOf2 = Integer.valueOf(a(false, z2, bmVar.getFeedObject()));
            Context context2 = hVar.getContext();
            kotlin.g.b.p.g(context2, "holder.context");
            oVar = new kotlin.o(valueOf2, Integer.valueOf(context2.getResources().getColor(R.color.am)));
        }
        int intValue = oVar.first.intValue();
        int intValue2 = oVar.second.intValue();
        com.tencent.mm.plugin.finder.storage.logic.g gVar2 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
        azu Lj = com.tencent.mm.plugin.finder.storage.logic.g.Lj(bmVar.getFeedObject().objectType);
        y yVar = y.vXH;
        FinderContact finderContact = bmVar.contact;
        if (finderContact != null) {
            gVar = com.tencent.mm.plugin.finder.api.b.a(finderContact, null);
        } else {
            gVar = null;
        }
        boolean i4 = y.i(gVar);
        if (z2 && z && !i4) {
            a(weImageView, Lj);
        } else if (Lj == null || i4 || z2) {
            weImageView.setImageResource(intValue);
            weImageView.setIconColor(intValue2);
        } else {
            if (z) {
                str = Lj.LJE;
            } else {
                str = Lj.LJG;
            }
            Drawable drawable = weImageView.getDrawable();
            if (drawable != null) {
                drawable.clearColorFilter();
            }
            weImageView.setClearColorFilter(true);
            weImageView.setIconColor(0);
            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.plugin.finder.loader.m.djY().a(new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE), weImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
        }
        if (this.uKk.uLZ) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        TextView textView = (TextView) hVar.Mn(R.id.fcb);
        if (i2 > 0) {
            string = com.tencent.mm.plugin.finder.utils.k.gm(i3, i2);
            kotlin.g.b.p.g(string, "FinderFormatUtil.formatNumber(scene, likeCount)");
        } else {
            com.tencent.mm.plugin.finder.storage.logic.g gVar3 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
            azu Lj2 = com.tencent.mm.plugin.finder.storage.logic.g.Lj(bmVar.getFeedObject().objectType);
            if (Lj2 != null) {
                String str2 = Lj2.LJI;
                if (!(str2 == null || str2.length() == 0)) {
                    z3 = false;
                }
                if (!z3) {
                    string = Lj2.LJI;
                    if (string == null) {
                        string = "";
                    }
                }
            }
            string = hVar.getContext().getString(R.string.cps);
            kotlin.g.b.p.g(string, "holder.context.getString…g.finder_like_count_text)");
        }
        kotlin.g.b.p.g(textView, "likeTv");
        textView.setText(string);
        AppMethodBeat.o(248329);
    }

    private static void a(WeImageView weImageView, azu azu) {
        boolean z;
        AppMethodBeat.i(248330);
        String str = azu != null ? azu.LJJ : null;
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            weImageView.setImageResource(R.raw.icons_filled_like_group);
            Context context = weImageView.getContext();
            kotlin.g.b.p.g(context, "imageView.context");
            weImageView.setIconColor(context.getResources().getColor(R.color.Red_90));
            AppMethodBeat.o(248330);
            return;
        }
        Drawable drawable = weImageView.getDrawable();
        if (drawable != null) {
            drawable.clearColorFilter();
        }
        weImageView.setClearColorFilter(true);
        weImageView.setIconColor(0);
        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
        com.tencent.mm.plugin.finder.loader.m.djY().a(new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE), weImageView, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
        AppMethodBeat.o(248330);
    }

    private static int a(boolean z, boolean z2, FinderObject finderObject) {
        com.tencent.mm.plugin.finder.api.g gVar = null;
        AppMethodBeat.i(248331);
        y yVar = y.vXH;
        FinderContact finderContact = finderObject.contact;
        if (finderContact != null) {
            gVar = com.tencent.mm.plugin.finder.api.b.a(finderContact, null);
        }
        if (y.i(gVar)) {
            if (z) {
                AppMethodBeat.o(248331);
                return R.raw.finder_filled_like_lock;
            }
            AppMethodBeat.o(248331);
            return R.raw.finder_outlined_like_lock;
        } else if (!z) {
            AppMethodBeat.o(248331);
            return R.raw.icon_outlined_awesome;
        } else if (z2) {
            AppMethodBeat.o(248331);
            return R.raw.finder_filled_like_lock;
        } else {
            AppMethodBeat.o(248331);
            return R.raw.icon_filled_awesome;
        }
    }

    private final void b(boolean z, int i2, com.tencent.mm.view.recyclerview.h hVar) {
        kotlin.o oVar;
        AppMethodBeat.i(248332);
        WeImageView weImageView = (WeImageView) hVar.Mn(R.id.fc8);
        if (weImageView != null) {
            if (z) {
                Integer valueOf = Integer.valueOf((int) R.raw.finder_icons_filled_star);
                Context context = hVar.getContext();
                kotlin.g.b.p.g(context, "holder.context");
                oVar = new kotlin.o(valueOf, Integer.valueOf(context.getResources().getColor(R.color.Orange_100)));
            } else {
                oVar = new kotlin.o(Integer.valueOf((int) R.raw.finder_icons_outlined_star), -1);
            }
            int intValue = oVar.first.intValue();
            int intValue2 = oVar.second.intValue();
            weImageView.setImageResource(intValue);
            weImageView.setIconColor(intValue2);
        }
        String string = (!this.uKk.uLZ || i2 <= 0) ? hVar.getContext().getString(R.string.cmg) : com.tencent.mm.plugin.finder.utils.k.gm(1, i2);
        View Mn = hVar.Mn(R.id.fc9);
        kotlin.g.b.p.g(Mn, "holder.getView<TextView>….mega_video_fav_count_tv)");
        ((TextView) Mn).setText(string);
        AppMethodBeat.o(248332);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$convertMedia$2$2$1", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$$special$$inlined$run$lambda$1"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ FinderMediaBanner tBM;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderMediaBanner finderMediaBanner, a aVar, com.tencent.mm.view.recyclerview.h hVar, bm bmVar) {
            super(0);
            this.tBM = finderMediaBanner;
            this.uKm = aVar;
            this.tzq = hVar;
            this.uKn = bmVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            RecyclerView.LayoutManager layoutManager;
            AppMethodBeat.i(248284);
            RecyclerView parentRecyclerView = this.tBM.getParentRecyclerView();
            if (parentRecyclerView != null) {
                layoutManager = parentRecyclerView.getLayoutManager();
            } else {
                layoutManager = null;
            }
            if (!(layoutManager instanceof FinderLinearLayoutManager)) {
                layoutManager = null;
            }
            FinderLinearLayoutManager finderLinearLayoutManager = (FinderLinearLayoutManager) layoutManager;
            if (finderLinearLayoutManager != null) {
                finderLinearLayoutManager.wtl = false;
            }
            C1214a aVar = a.uKl;
            C1214a.a(this.tzq, this.uKn, this.uKm.uKk.dcl(), Boolean.TRUE);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(248284);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$convertMedia$2$2$2", "com/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoConvert$$special$$inlined$run$lambda$2"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ FinderMediaBanner tBM;
        final /* synthetic */ com.tencent.mm.view.recyclerview.h tzq;
        final /* synthetic */ a uKm;
        final /* synthetic */ bm uKn;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderMediaBanner finderMediaBanner, a aVar, com.tencent.mm.view.recyclerview.h hVar, bm bmVar) {
            super(0);
            this.tBM = finderMediaBanner;
            this.uKm = aVar;
            this.tzq = hVar;
            this.uKn = bmVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            RecyclerView.LayoutManager layoutManager;
            AppMethodBeat.i(248285);
            RecyclerView parentRecyclerView = this.tBM.getParentRecyclerView();
            if (parentRecyclerView != null) {
                layoutManager = parentRecyclerView.getLayoutManager();
            } else {
                layoutManager = null;
            }
            if (!(layoutManager instanceof FinderLinearLayoutManager)) {
                layoutManager = null;
            }
            FinderLinearLayoutManager finderLinearLayoutManager = (FinderLinearLayoutManager) layoutManager;
            if (finderLinearLayoutManager != null) {
                finderLinearLayoutManager.wtl = true;
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(248285);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(a aVar, bm bmVar, com.tencent.mm.view.recyclerview.h hVar) {
        boolean z;
        AppMethodBeat.i(248336);
        y yVar = y.vXH;
        if (!y.d(bmVar.tuP)) {
            y yVar2 = y.vXH;
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            String string = hVar.getContext().getString(R.string.d5z);
            kotlin.g.b.p.g(string, "holder.context.getString…g.finder_private_ban_fav)");
            y.aF(context, string);
            AppMethodBeat.o(248336);
            return;
        }
        c.a aVar2 = com.tencent.mm.plugin.finder.upload.action.c.vUa;
        boolean k2 = com.tencent.mm.plugin.finder.upload.action.c.vTZ.k(bmVar.getFeedObject());
        com.tencent.mm.plugin.finder.megavideo.ui.f fVar = aVar.uKk;
        if (!k2) {
            z = true;
        } else {
            z = false;
        }
        kotlin.g.b.p.h(bmVar, "megaVideo");
        com.tencent.mm.plugin.finder.model.r rVar = com.tencent.mm.plugin.finder.model.r.uNW;
        AppCompatActivity appCompatActivity = fVar.uMk;
        FinderItem.a aVar3 = FinderItem.Companion;
        com.tencent.mm.plugin.finder.model.r.a(appCompatActivity, FinderItem.a.a(bmVar.getFeedObject(), 32768), z);
        AppMethodBeat.o(248336);
    }

    public static final /* synthetic */ void b(a aVar, bm bmVar, com.tencent.mm.view.recyclerview.h hVar) {
        List<String> list;
        String str;
        String str2;
        boolean z = false;
        AppMethodBeat.i(248337);
        y yVar = y.vXH;
        if (!y.b(bmVar.tuP)) {
            y yVar2 = y.vXH;
            Context context = hVar.getContext();
            kotlin.g.b.p.g(context, "holder.context");
            String string = hVar.getContext().getString(R.string.d61);
            kotlin.g.b.p.g(string, "holder.context.getString…finder_private_ban_share)");
            y.aF(context, string);
            AppMethodBeat.o(248337);
        } else if (bmVar.isPrivate()) {
            com.tencent.mm.ui.base.u.a(hVar.getContext(), hVar.getContext().getString(R.string.d67), e.uKo);
            AppMethodBeat.o(248337);
        } else if (bmVar.dkY()) {
            y yVar3 = y.vXH;
            String dP = y.dP("FinderSafeSelfSeeShare", R.string.d8v);
            cng cng = bmVar.tuP;
            if (cng == null || (str2 = cng.MtJ) == null) {
                list = null;
            } else {
                list = kotlin.n.n.a(str2, new String[]{"#"});
            }
            if (list != null) {
                if (list.size() > 2) {
                    z = true;
                }
                if (!z) {
                    list = null;
                }
                if (list != null) {
                    str = list.get(1);
                    y yVar4 = y.vXH;
                    Context context2 = hVar.getContext();
                    kotlin.g.b.p.g(context2, "holder.context");
                    y.aF(context2, str);
                    AppMethodBeat.o(248337);
                }
            }
            str = dP;
            y yVar42 = y.vXH;
            Context context22 = hVar.getContext();
            kotlin.g.b.p.g(context22, "holder.context");
            y.aF(context22, str);
            AppMethodBeat.o(248337);
        } else {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(hVar.getContext(), 1, false);
            eVar.a(f.uKp);
            eVar.a(new g(aVar, bmVar));
            eVar.b(new h(hVar));
            eVar.dGm();
            AppMethodBeat.o(248337);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0063  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.tencent.mm.plugin.finder.megavideo.convert.a r10, com.tencent.mm.view.recyclerview.h r11, com.tencent.mm.plugin.finder.model.bm r12) {
        /*
        // Method dump skipped, instructions count: 105
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.megavideo.convert.a.a(com.tencent.mm.plugin.finder.megavideo.convert.a, com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.bm):void");
    }

    public static final /* synthetic */ void a(a aVar, com.tencent.mm.view.recyclerview.h hVar, MotionEvent motionEvent) {
        com.tencent.mm.plugin.finder.api.g gVar;
        boolean z = false;
        AppMethodBeat.i(261240);
        bm bmVar = (bm) hVar.hgv();
        if (!aVar.uKk.uLZ) {
            j.a aVar2 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
            kotlin.o<Boolean, Boolean> m2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.m(bmVar.getFeedObject());
            boolean booleanValue = m2.first.booleanValue();
            boolean booleanValue2 = m2.second.booleanValue();
            if (!booleanValue || !booleanValue2) {
                if (booleanValue) {
                    WeImageView f2 = f(hVar);
                    com.tencent.mm.plugin.finder.storage.logic.g gVar2 = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
                    azu Lj = com.tencent.mm.plugin.finder.storage.logic.g.Lj(bmVar.getFeedObject().objectType);
                    String str = Lj == null ? "" : ao.isDarkMode() ? Lj.LJE : Lj.LJF;
                    String str2 = str;
                    if (str2 == null || str2.length() == 0) {
                        z = true;
                    }
                    if (!z) {
                        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                        com.tencent.mm.plugin.finder.loader.m.djY().a(new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE), f2, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
                    } else {
                        y yVar = y.vXH;
                        FinderContact finderContact = bmVar.contact;
                        if (finderContact != null) {
                            gVar = com.tencent.mm.plugin.finder.api.b.a(finderContact, null);
                        } else {
                            gVar = null;
                        }
                        if (y.i(gVar)) {
                            Context context = hVar.getContext();
                            Context context2 = hVar.getContext();
                            kotlin.g.b.p.g(context2, "holder.context");
                            f2.setImageDrawable(ar.m(context, R.raw.finder_filled_like_lock, context2.getResources().getColor(R.color.Red_90)));
                        } else {
                            Context context3 = hVar.getContext();
                            Context context4 = hVar.getContext();
                            kotlin.g.b.p.g(context4, "holder.context");
                            f2.setImageDrawable(ar.m(context3, R.raw.finder_full_like, context4.getResources().getColor(R.color.Red_90)));
                        }
                    }
                    com.tencent.mm.plugin.finder.view.animation.c cVar = com.tencent.mm.plugin.finder.view.animation.c.wrB;
                    com.tencent.mm.plugin.finder.view.animation.c.a((View) f2, 1.4f, motionEvent, true, 16);
                    AppMethodBeat.o(261240);
                    return;
                }
                kotlin.g.b.p.g(bmVar, "item");
                aVar.a(bmVar, hVar, false, 2, motionEvent);
            }
        }
        AppMethodBeat.o(261240);
    }
}
