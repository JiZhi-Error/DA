package com.tencent.mm.plugin.finder.activity.uic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ih;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.bw;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r*\u0001\u0016\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001UB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u000200H\u0002J\b\u00102\u001a\u00020\u0010H\u0002J\b\u00103\u001a\u000200H\u0002J\b\u00104\u001a\u000200H\u0002J\b\u00105\u001a\u000200H\u0002J\b\u00106\u001a\u00020\u0007H\u0002J\b\u00107\u001a\u00020\u0007H\u0002J\b\u00108\u001a\u000200H\u0002J\b\u00109\u001a\u000200H\u0002J\b\u0010:\u001a\u00020#H\u0002J\b\u0010;\u001a\u00020#H\u0002J\u0012\u0010<\u001a\u0002002\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u000200H\u0016J,\u0010@\u001a\u0002002\u0006\u0010A\u001a\u00020*2\u0006\u0010B\u001a\u00020*2\b\u0010C\u001a\u0004\u0018\u00010\u00072\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u001c\u0010F\u001a\u0002002\b\u0010-\u001a\u0004\u0018\u00010.2\b\b\u0002\u0010G\u001a\u00020#H\u0002J\b\u0010H\u001a\u00020IH\u0002J\b\u0010J\u001a\u000200H\u0002J\u0010\u0010K\u001a\u0002002\u0006\u0010L\u001a\u00020\u0007H\u0002J\b\u0010M\u001a\u000200H\u0002J\b\u0010N\u001a\u000200H\u0002J\b\u0010O\u001a\u000200H\u0002J\b\u0010P\u001a\u000200H\u0002J\b\u0010Q\u001a\u000200H\u0002J\b\u0010R\u001a\u000200H\u0002J\b\u0010S\u001a\u000200H\u0002J\b\u0010T\u001a\u000200H\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020*X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "activityName", "", "backBtn", "Landroid/widget/LinearLayout;", "backIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "bottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "closeActivitySheet", "coordinatorLayout", "Landroid/view/View;", "emptyView", "Landroid/widget/FrameLayout;", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$finderTopicInfoListener$1;", "forceVisibleRunnable", "Lcom/tencent/threadpool/runnable/FutureEx;", "headerBgLayout", "headerContainer", "headerCoverView", "Landroid/widget/ImageView;", "headerDefaultCoverView", "headerMaskContainer", "Landroid/view/ViewGroup;", "headerMaskCoverView", "isReceivedTopic", "", "moreBtn", "moreIcon", "progressBar", "Landroid/widget/ProgressBar;", "progressRunnable", "screenHeight", "", "screenWidth", "titleContainer", "topicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "adjustCoverImageView", "", "closeActivity", "createShareHeader", "dismissProgress", "fixActionBar", "forceCampaignVisible", "getIconUrl", "getShareDesc", "initScreenWidth", "initView", "isEnableDeleteActivity", "notShare", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onTopicInfo", "ignoreCover", "optActivityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderActivityEvent;", "report", "setCover", "coverUrl", "setCoverMaskMargin", "setCoverStyle", "setInvalidView", "setLoadingStatus", "setNormalStyle", "showBottomSheet", "showCloseSheet", "showProgress", "Companion", "plugin-finder_release"})
public final class FinderActivityActionBarUIC extends UIComponent implements com.tencent.mm.ak.i {
    private static final int pLU = 10003;
    private static final float tqA = tqA;
    public static final a tqB = new a((byte) 0);
    private static final int tqu = 10001;
    private static final int tqv = 10002;
    private static final int tqw = 10004;
    private static final int tqx = tqx;
    private static final int tqy = tqy;
    private static final float tqz = tqz;
    private ViewGroup UGR;
    private View UGS;
    private FrameLayout UGT;
    private View UGU;
    private boolean UGV;
    private com.tencent.f.i.d<?> UGW;
    private String activityName = "";
    private bds dMU;
    private com.tencent.mm.ui.widget.a.e hOv;
    private WeImageView hQb;
    private int mEX;
    private int mEY;
    private ProgressBar progressBar;
    private ImageView tqi;
    private ImageView tqj;
    private ImageView tqk;
    private View tql;
    private LinearLayout tqm;
    private LinearLayout tqn;
    private aqk tqo;
    private com.tencent.f.i.d<?> tqp;
    private FrameLayout tqq;
    private WeImageView tqr;
    private com.tencent.mm.ui.widget.a.e tqs;
    private final d tqt = new d(this);

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n¨\u0006\u000b"}, hxF = {"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$setCover$1$1"})
    public static final class g<T, R> implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.o, Bitmap> {
        final /* synthetic */ ImageView tqC;
        final /* synthetic */ FinderActivityActionBarUIC tqD;
        final /* synthetic */ String tqE;

        g(ImageView imageView, FinderActivityActionBarUIC finderActivityActionBarUIC, String str) {
            this.tqC = imageView;
            this.tqD = finderActivityActionBarUIC;
            this.tqE = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<com.tencent.mm.plugin.finder.loader.o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(242017);
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.activity.uic.FinderActivityActionBarUIC.g.AnonymousClass1 */
                    final /* synthetic */ g tqF;

                    {
                        this.tqF = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(242016);
                        com.tencent.f.i.d dVar = this.tqF.tqD.UGW;
                        if (dVar != null) {
                            dVar.cancel(false);
                        }
                        this.tqF.tqC.setVisibility(0);
                        FinderActivityActionBarUIC.b(this.tqF.tqD, this.tqF.tqD.dMU);
                        x xVar = x.SXb;
                        AppMethodBeat.o(242016);
                        return xVar;
                    }
                });
                Log.i("Finder.ActivityActionBarUIC", "[handleActivityProfileCover] [" + bitmap2.getWidth() + ':' + bitmap2.getHeight() + "] allocationByteCount=" + Util.getSizeKB((long) bitmap2.getAllocationByteCount()) + " coverUrl=" + this.tqE);
                AppMethodBeat.o(242017);
                return;
            }
            AppMethodBeat.o(242017);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class o extends kotlin.g.b.q implements kotlin.g.a.b<String, x> {
        final /* synthetic */ FinderActivityActionBarUIC tqD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(FinderActivityActionBarUIC finderActivityActionBarUIC) {
            super(1);
            this.tqD = finderActivityActionBarUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(String str) {
            AppMethodBeat.i(260073);
            kotlin.g.b.p.h(str, LocaleUtil.ITALIAN);
            Log.i("Finder.ActivityActionBarUIC", "setAnnounceView");
            y yVar = y.vXH;
            y.mk(this.tqD.getContext());
            x xVar = x.SXb;
            AppMethodBeat.o(260073);
            return xVar;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderActivityActionBarUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        kotlin.g.b.p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(242032);
        AppMethodBeat.o(242032);
    }

    public static final /* synthetic */ void a(FinderActivityActionBarUIC finderActivityActionBarUIC, String str) {
        AppMethodBeat.i(260082);
        finderActivityActionBarUIC.setCover(str);
        AppMethodBeat.o(260082);
    }

    public static final /* synthetic */ void b(FinderActivityActionBarUIC finderActivityActionBarUIC, bds bds) {
        AppMethodBeat.i(260081);
        finderActivityActionBarUIC.a(bds, true);
        AppMethodBeat.o(260081);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$Companion;", "", "()V", "FIX_RATIO", "", "MASK_TOP_MARGIN_RATIO", "MENU_ID_CLOSE_ACTIVITY", "", "MENU_ID_COMPLAIN_ACTIVITY", "MENU_ID_CONFIRM_CLOSE_ACTIVITY", "MENU_ID_MORE", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(242033);
        AppMethodBeat.o(242033);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        FinderActivityActionBarUIC finderActivityActionBarUIC;
        FinderActivityActionBarUIC finderActivityActionBarUIC2;
        FrameLayout frameLayout;
        Integer num = null;
        AppMethodBeat.i(242028);
        super.onCreate(bundle);
        this.tqt.alive();
        this.tql = getActivity().findViewById(R.id.fd);
        this.UGS = getActivity().findViewById(R.id.f4);
        this.UGT = (FrameLayout) getActivity().findViewById(R.id.jzb);
        this.UGU = getActivity().findViewById(R.id.bg4);
        FrameLayout frameLayout2 = this.UGT;
        if (frameLayout2 != null) {
            ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
            int statusBarHeight = au.getStatusBarHeight(getActivity());
            float dimension = getActivity().getResources().getDimension(R.dimen.b9);
            layoutParams.height = kotlin.h.a.cR(((float) statusBarHeight) + dimension);
            frameLayout2.setLayoutParams(layoutParams);
            View view = this.UGS;
            if (view != null) {
                view.setMinimumHeight(kotlin.h.a.cR(((float) statusBarHeight) + dimension));
            }
        }
        this.activityName = getIntent().getStringExtra("key_activity_name");
        com.tencent.mm.kernel.g.azz().a(5909, this);
        LinearLayout linearLayout = (LinearLayout) getActivity().findViewById(R.id.ck3);
        if (linearLayout != null) {
            linearLayout.setOnClickListener(new e(this));
            finderActivityActionBarUIC = this;
        } else {
            linearLayout = null;
            finderActivityActionBarUIC = this;
        }
        finderActivityActionBarUIC.tqm = linearLayout;
        this.hQb = (WeImageView) getActivity().findViewById(R.id.ck4);
        this.tqr = (WeImageView) getActivity().findViewById(R.id.ck6);
        LinearLayout linearLayout2 = (LinearLayout) getActivity().findViewById(R.id.ck5);
        if (linearLayout2 != null) {
            linearLayout2.setOnClickListener(new f(this));
            finderActivityActionBarUIC2 = this;
        } else {
            linearLayout2 = null;
            finderActivityActionBarUIC2 = this;
        }
        finderActivityActionBarUIC2.tqn = linearLayout2;
        this.tqi = (ImageView) getActivity().findViewById(R.id.f1);
        this.tqj = (ImageView) getActivity().findViewById(R.id.f2);
        this.UGR = (ViewGroup) getActivity().findViewById(R.id.jt5);
        this.progressBar = (ProgressBar) getActivity().findViewById(R.id.fe);
        this.tqq = (FrameLayout) getActivity().findViewById(R.id.c3e);
        if (!Util.isNullOrNil(getIntent().getStringExtra("key_cover_url")) && (frameLayout = this.tqq) != null) {
            frameLayout.setBackground(getResources().getDrawable(R.drawable.cvd));
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(242028);
            throw tVar;
        }
        WindowManager windowManager = activity.getWindowManager();
        kotlin.g.b.p.g(windowManager, "(activity as Activity).windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.mEX = displayMetrics.widthPixels;
        this.mEY = displayMetrics.heightPixels;
        cXo();
        ImageView imageView = this.tqi;
        if (imageView != null) {
            imageView.post(new b(imageView));
        }
        float f2 = tqz * ((float) this.mEX);
        ImageView imageView2 = this.tqj;
        ViewGroup.LayoutParams layoutParams2 = imageView2 != null ? imageView2.getLayoutParams() : null;
        if (layoutParams2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
            AppMethodBeat.o(242028);
            throw tVar2;
        }
        layoutParams2.height = (int) f2;
        ImageView imageView3 = this.tqj;
        if (imageView3 != null) {
            imageView3.setLayoutParams(layoutParams2);
        }
        StringBuilder sb = new StringBuilder("showProgress: ");
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            num = Integer.valueOf(progressBar2.getVisibility());
        }
        Log.i("Finder.ActivityActionBarUIC", sb.append(num).toString());
        com.tencent.f.i.d<?> dVar = this.tqp;
        if (dVar != null) {
            dVar.cancel(false);
        }
        this.tqp = com.tencent.f.h.RTc.n(new p(this), 500);
        long longExtra = getIntent().getLongExtra("key_activity_id", 0);
        String stringExtra = getIntent().getStringExtra("key_from_user");
        if (stringExtra == null) {
            stringExtra = "";
        }
        int intExtra = getIntent().getIntExtra("key_report_scene", 0);
        if (intExtra != 0) {
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(getIntent().getLongExtra("key_ref_object_id", 0), intExtra, 6, stringExtra, 0, 2, com.tencent.mm.ac.d.zs(longExtra));
        }
        ImageView imageView4 = this.tqi;
        if (imageView4 != null) {
            imageView4.setVisibility(4);
        }
        ViewGroup viewGroup = this.UGR;
        if (viewGroup != null) {
            viewGroup.setVisibility(4);
        }
        View view2 = this.UGU;
        if (view2 != null) {
            view2.setVisibility(4);
        }
        ImageView imageView5 = this.tqk;
        if (imageView5 != null) {
            imageView5.setVisibility(4);
        }
        FrameLayout frameLayout3 = this.tqq;
        if (frameLayout3 != null) {
            frameLayout3.setVisibility(0);
        }
        ProgressBar progressBar3 = this.progressBar;
        if (progressBar3 != null) {
            progressBar3.setVisibility(0);
            AppMethodBeat.o(242028);
            return;
        }
        AppMethodBeat.o(242028);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(242029);
        super.onDestroy();
        this.tqt.dead();
        com.tencent.mm.kernel.g.azz().b(5909, this);
        AppMethodBeat.o(242029);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$1$1"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ FinderActivityActionBarUIC tqD;

        e(FinderActivityActionBarUIC finderActivityActionBarUIC) {
            this.tqD = finderActivityActionBarUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242014);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.tqD.getActivity().isFinishing()) {
                this.tqD.getActivity().finish();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242014);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$2$1"})
    static final class f implements View.OnClickListener {
        final /* synthetic */ FinderActivityActionBarUIC tqD;

        f(FinderActivityActionBarUIC finderActivityActionBarUIC) {
            this.tqD = finderActivityActionBarUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(242015);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FinderActivityActionBarUIC.a(this.tqD);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$initView$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(242015);
        }
    }

    private final void setCover(String str) {
        AppMethodBeat.i(260078);
        ImageView imageView = this.tqi;
        if (imageView != null) {
            com.tencent.mm.plugin.finder.loader.g gVar = new com.tencent.mm.plugin.finder.loader.g(str);
            com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.loader.a.b<com.tencent.mm.plugin.finder.loader.o, Bitmap> bQ = com.tencent.mm.plugin.finder.loader.m.djY().bQ(gVar);
            com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
            bQ.a(com.tencent.mm.plugin.finder.loader.m.a(m.a.PROFILE_COVER)).a(new g(imageView, this, str)).c(imageView);
        }
        Log.i("Finder.ActivityActionBarUIC", "forceCampaignVisible: ");
        com.tencent.f.i.d<?> dVar = this.UGW;
        if (dVar != null) {
            dVar.cancel(false);
        }
        this.UGW = com.tencent.f.h.RTc.n(new q(this), 2000);
        AppMethodBeat.o(260078);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ ImageView tqC;

        b(ImageView imageView) {
            this.tqC = imageView;
        }

        public final void run() {
            AppMethodBeat.i(242011);
            ViewGroup.LayoutParams layoutParams = this.tqC.getLayoutParams();
            layoutParams.height = (int) (((float) this.tqC.getWidth()) * FinderActivityActionBarUIC.tqz);
            this.tqC.setLayoutParams(layoutParams);
            AppMethodBeat.o(242011);
        }
    }

    private final void cXo() {
        AppMethodBeat.i(242030);
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(242030);
            throw tVar;
        }
        ((MMActivity) activity).getController().updataStatusBarIcon(ao.isDarkMode());
        int color = getResources().getColor(R.color.fo);
        WeImageView weImageView = this.hQb;
        if (weImageView != null) {
            weImageView.setIconColor(color);
        }
        WeImageView weImageView2 = this.tqr;
        if (weImageView2 != null) {
            weImageView2.setIconColor(color);
        }
        ImageView imageView = this.tqk;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        ImageView imageView2 = this.tqj;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        ImageView imageView3 = this.tqi;
        if (imageView3 != null) {
            imageView3.setVisibility(4);
        }
        ViewGroup viewGroup = this.UGR;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
            AppMethodBeat.o(242030);
            return;
        }
        AppMethodBeat.o(242030);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showBottomSheet$1$1"})
    public static final class h implements o.f {
        final /* synthetic */ FinderActivityActionBarUIC tqD;

        h(FinderActivityActionBarUIC finderActivityActionBarUIC) {
            this.tqD = finderActivityActionBarUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            boolean z;
            boolean z2;
            AppMethodBeat.i(242018);
            kotlin.g.b.p.g(mVar, "menu");
            if (mVar.gKQ()) {
                String string = this.tqD.getActivity().getString(R.string.yz);
                kotlin.g.b.p.g(string, "activity.getString(R.string.app_share_to_weixin)");
                String string2 = this.tqD.getActivity().getString(R.string.d9p);
                kotlin.g.b.p.g(string2, "activity.getString(R.string.finder_share_timeline)");
                if (FinderActivityActionBarUIC.b(this.tqD)) {
                    y yVar = y.vXH;
                    string = y.dP("", R.string.d8u);
                    y yVar2 = y.vXH;
                    string2 = y.dP("", R.string.d8v);
                    z = true;
                    z2 = true;
                } else {
                    z = false;
                    z2 = false;
                }
                mVar.a(FinderActivityActionBarUIC.tqv, string, R.raw.finder_icons_filled_share, this.tqD.getResources().getColor(R.color.Brand), z2);
                mVar.a(FinderActivityActionBarUIC.pLU, string2, R.raw.bottomsheet_icon_moment, 0, z);
            }
            AppMethodBeat.o(242018);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showBottomSheet$1$2"})
    public static final class i implements o.g {
        final /* synthetic */ FinderActivityActionBarUIC tqD;

        i(FinderActivityActionBarUIC finderActivityActionBarUIC) {
            this.tqD = finderActivityActionBarUIC;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            long j2;
            String str;
            long j3;
            AppMethodBeat.i(242019);
            kotlin.g.b.p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            if (itemId != FinderActivityActionBarUIC.tqv) {
                if (itemId == FinderActivityActionBarUIC.pLU) {
                    if (FinderActivityActionBarUIC.b(this.tqD)) {
                        u.makeText(this.tqD.getActivity(), (int) R.string.d8v, 0).show();
                        AppMethodBeat.o(242019);
                        return;
                    }
                    s.a aVar = s.vWt;
                    AppCompatActivity activity = this.tqD.getActivity();
                    if (activity == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                        AppMethodBeat.o(242019);
                        throw tVar;
                    }
                    MMActivity mMActivity = (MMActivity) activity;
                    aqk aqk = this.tqD.tqo;
                    String str2 = aqk != null ? aqk.eventName : null;
                    aqk aqk2 = this.tqD.tqo;
                    if (aqk2 != null) {
                        j2 = (long) aqk2.LCy;
                    } else {
                        j2 = 0;
                    }
                    s.a.b(mMActivity, str2, 7, j2, FinderActivityActionBarUIC.d(this.tqD), FinderActivityActionBarUIC.e(this.tqD), null, 9, "", FinderActivityActionBarUIC.f(this.tqD));
                }
                AppMethodBeat.o(242019);
            } else if (FinderActivityActionBarUIC.b(this.tqD)) {
                u.makeText(this.tqD.getActivity(), (int) R.string.d8u, 0).show();
                AppMethodBeat.o(242019);
            } else {
                s.a aVar2 = s.vWt;
                AppCompatActivity activity2 = this.tqD.getActivity();
                if (activity2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                    AppMethodBeat.o(242019);
                    throw tVar2;
                }
                MMActivity mMActivity2 = (MMActivity) activity2;
                aqk aqk3 = this.tqD.tqo;
                if (aqk3 != null) {
                    str = aqk3.eventName;
                } else {
                    str = null;
                }
                aqk aqk4 = this.tqD.tqo;
                if (aqk4 != null) {
                    j3 = (long) aqk4.LCy;
                } else {
                    j3 = 0;
                }
                aVar2.a(mMActivity2, str, 7, j3, FinderActivityActionBarUIC.d(this.tqD), FinderActivityActionBarUIC.e(this.tqD), (axt) null, 9, "", FinderActivityActionBarUIC.f(this.tqD));
                AppMethodBeat.o(242019);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showBottomSheet$1$3"})
    public static final class j implements o.f {
        final /* synthetic */ FinderActivityActionBarUIC tqD;

        j(FinderActivityActionBarUIC finderActivityActionBarUIC) {
            this.tqD = finderActivityActionBarUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            FinderContact finderContact;
            AppMethodBeat.i(242020);
            kotlin.g.b.p.g(mVar, "menu");
            if (mVar.gKQ()) {
                boolean b2 = FinderActivityActionBarUIC.b(this.tqD);
                if (FinderActivityActionBarUIC.g(this.tqD)) {
                    mVar.a(FinderActivityActionBarUIC.tqw, this.tqD.getResources().getString(R.string.cgn), R.raw.finder_outlined_turnoff, b2);
                    AppMethodBeat.o(242020);
                    return;
                }
                aqk aqk = this.tqD.tqo;
                if (!kotlin.g.b.p.j((aqk == null || (finderContact = aqk.contact) == null) ? null : finderContact.username, z.aUg())) {
                    mVar.a(FinderActivityActionBarUIC.tqy, this.tqD.getResources().getString(R.string.cx_), R.raw.icons_outlined_report_problem, b2);
                }
            }
            AppMethodBeat.o(242020);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showBottomSheet$1$4"})
    public static final class k implements o.g {
        final /* synthetic */ FinderActivityActionBarUIC tqD;

        k(FinderActivityActionBarUIC finderActivityActionBarUIC) {
            this.tqD = finderActivityActionBarUIC;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            long j2;
            AppMethodBeat.i(242021);
            kotlin.g.b.p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            if (itemId == FinderActivityActionBarUIC.tqw) {
                FinderActivityActionBarUIC.h(this.tqD);
                AppMethodBeat.o(242021);
                return;
            }
            if (itemId == FinderActivityActionBarUIC.tqy) {
                com.tencent.mm.plugin.finder.feed.logic.a aVar = com.tencent.mm.plugin.finder.feed.logic.a.tUv;
                AppCompatActivity activity = this.tqD.getActivity();
                aqk aqk = this.tqD.tqo;
                if (aqk != null) {
                    j2 = aqk.twd;
                } else {
                    j2 = 0;
                }
                com.tencent.mm.plugin.finder.feed.logic.a.i(activity, j2);
            }
            AppMethodBeat.o(242021);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showBottomSheet$1$5"})
    public static final class l implements e.b {
        final /* synthetic */ FinderActivityActionBarUIC tqD;

        l(FinderActivityActionBarUIC finderActivityActionBarUIC) {
            this.tqD = finderActivityActionBarUIC;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(242022);
            this.tqD.hOv = null;
            AppMethodBeat.o(242022);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showCloseSheet$1$1"})
    public static final class m implements o.f {
        final /* synthetic */ FinderActivityActionBarUIC tqD;

        m(FinderActivityActionBarUIC finderActivityActionBarUIC) {
            this.tqD = finderActivityActionBarUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(260075);
            kotlin.g.b.p.g(mVar, "menu");
            if (mVar.gKQ()) {
                mVar.a(FinderActivityActionBarUIC.tqx, this.tqD.getResources().getColor(R.color.Red), this.tqD.getResources().getString(R.string.cgn));
            }
            AppMethodBeat.o(260075);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showCloseSheet$1$2"})
    public static final class n implements o.g {
        final /* synthetic */ FinderActivityActionBarUIC tqD;

        n(FinderActivityActionBarUIC finderActivityActionBarUIC) {
            this.tqD = finderActivityActionBarUIC;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(260076);
            kotlin.g.b.p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == FinderActivityActionBarUIC.tqx) {
                FinderActivityActionBarUIC.j(this.tqD);
            }
            AppMethodBeat.o(260076);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$showCloseSheet$1$3"})
    public static final class r implements e.b {
        final /* synthetic */ FinderActivityActionBarUIC tqD;

        r(FinderActivityActionBarUIC finderActivityActionBarUIC) {
            this.tqD = finderActivityActionBarUIC;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(260077);
            this.tqD.tqs = null;
            AppMethodBeat.o(260077);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/activity/uic/FinderActivityActionBarUIC$finderTopicInfoListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTopicEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class d extends IListener<ih> {
        final /* synthetic */ FinderActivityActionBarUIC tqD;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderActivityActionBarUIC finderActivityActionBarUIC) {
            this.tqD = finderActivityActionBarUIC;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ih ihVar) {
            bds bds;
            String str;
            aqk aqk;
            aqk aqk2;
            ih.a aVar;
            ih.a aVar2;
            String str2 = null;
            AppMethodBeat.i(242013);
            ih ihVar2 = ihVar;
            FinderActivityActionBarUIC.n(this.tqD);
            int i2 = (ihVar2 == null || (aVar2 = ihVar2.dMT) == null) ? 0 : aVar2.responseCode;
            if (i2 == 0) {
                if (!this.tqD.UGV) {
                    FinderActivityActionBarUIC finderActivityActionBarUIC = this.tqD;
                    if (ihVar2 == null || (aVar = ihVar2.dMT) == null) {
                        bds = null;
                    } else {
                        bds = aVar.dMU;
                    }
                    finderActivityActionBarUIC.dMU = bds;
                    bds bds2 = this.tqD.dMU;
                    if (!(bds2 == null || (aqk2 = bds2.LNz) == null)) {
                        str2 = aqk2.coverImgUrl;
                    }
                    if (!Util.isNullOrNil(str2)) {
                        FinderActivityActionBarUIC finderActivityActionBarUIC2 = this.tqD;
                        bds bds3 = this.tqD.dMU;
                        if (bds3 == null || (aqk = bds3.LNz) == null || (str = aqk.coverImgUrl) == null) {
                            str = "";
                        }
                        FinderActivityActionBarUIC.a(finderActivityActionBarUIC2, str);
                    } else {
                        FinderActivityActionBarUIC.a(this.tqD, this.tqD.dMU);
                    }
                    this.tqD.UGV = true;
                }
            } else if (-4058 == i2 || -4056 == i2 || -4063 == i2) {
                FinderActivityActionBarUIC.s(this.tqD);
            } else {
                FrameLayout frameLayout = this.tqD.tqq;
                if (frameLayout != null) {
                    frameLayout.setVisibility(0);
                }
                ProgressBar progressBar = this.tqD.progressBar;
                if (progressBar != null) {
                    progressBar.setVisibility(8);
                }
            }
            AppMethodBeat.o(242013);
            return true;
        }
    }

    static /* synthetic */ void a(FinderActivityActionBarUIC finderActivityActionBarUIC, bds bds) {
        AppMethodBeat.i(260080);
        finderActivityActionBarUIC.a(bds, false);
        AppMethodBeat.o(260080);
    }

    private final void a(bds bds, boolean z) {
        String str;
        String str2;
        String str3 = null;
        AppMethodBeat.i(260079);
        Log.i("Finder.ActivityActionBarUIC", "onTopicInfo : ignoreCover ".concat(String.valueOf(z)));
        FrameLayout frameLayout = this.tqq;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        ProgressBar progressBar2 = this.progressBar;
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
        this.tqo = bds != null ? bds.LNz : null;
        aqk aqk = this.tqo;
        if (aqk != null) {
            str = aqk.eventName;
        } else {
            str = null;
        }
        this.activityName = str;
        View view = this.UGU;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.tql;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        ViewGroup viewGroup = this.UGR;
        if (viewGroup != null) {
            viewGroup.setVisibility(0);
        }
        aqk aqk2 = this.tqo;
        if (aqk2 != null) {
            str3 = aqk2.coverImgUrl;
        }
        if (!Util.isNullOrNil(str3)) {
            if (!z) {
                aqk aqk3 = this.tqo;
                if (aqk3 == null || (str2 = aqk3.coverImgUrl) == null) {
                    str2 = "";
                }
                setCover(str2);
            }
            AppCompatActivity activity = getActivity();
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(260079);
                throw tVar;
            }
            ((MMActivity) activity).getController().updataStatusBarIcon(true);
            int color = getResources().getColor(R.color.pg);
            WeImageView weImageView = this.hQb;
            if (weImageView != null) {
                weImageView.setIconColor(color);
            }
            WeImageView weImageView2 = this.tqr;
            if (weImageView2 != null) {
                weImageView2.setIconColor(color);
            }
            ImageView imageView = this.tqk;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = this.tqj;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ImageView imageView3 = this.tqi;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
                AppMethodBeat.o(260079);
                return;
            }
            AppMethodBeat.o(260079);
            return;
        }
        cXo();
        AppMethodBeat.o(260079);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        String str2;
        FinderContact finderContact;
        AppMethodBeat.i(242031);
        if ((qVar instanceof bw) && ((bw) qVar).scene == 1) {
            if (i2 == 0 && i3 == 0) {
                FinderProfileHeaderUIC.a aVar = FinderProfileHeaderUIC.vbZ;
                com.tencent.mm.b.h access$getUserExtInfoCache$cp = FinderProfileHeaderUIC.access$getUserExtInfoCache$cp();
                aqk aqk = this.tqo;
                if (aqk == null || (finderContact = aqk.contact) == null || (str2 = finderContact.username) == null) {
                    str2 = "";
                }
                access$getUserExtInfoCache$cp.remove(str2);
                if (!getActivity().isFinishing()) {
                    getActivity().finish();
                    AppMethodBeat.o(242031);
                    return;
                }
            } else if (i3 == -4059) {
                com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                com.tencent.mm.plugin.finder.activity.view.a aVar3 = ((FinderActivityHeaderNewUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderActivityHeaderNewUIC.class)).trc;
                if (aVar3 != null) {
                    WeImageView weImageView = aVar3.tsc;
                    if (weImageView != null) {
                        weImageView.setVisibility(8);
                    }
                    TextView textView = aVar3.tsd;
                    if (textView != null) {
                        textView.setText(aVar3.gte.getResources().getString(R.string.j9z));
                    }
                    if (!Util.isNullOrNil(aVar3.coverUrl)) {
                        LinearLayout linearLayout = aVar3.tri;
                        if (linearLayout != null) {
                            linearLayout.setBackgroundResource(R.drawable.cuh);
                        }
                        TextView textView2 = aVar3.tsd;
                        if (textView2 != null) {
                            textView2.setTextColor(aVar3.gte.getResources().getColor(R.color.BW_100_Alpha_0_3));
                            AppMethodBeat.o(242031);
                            return;
                        }
                        AppMethodBeat.o(242031);
                        return;
                    }
                    LinearLayout linearLayout2 = aVar3.tri;
                    if (linearLayout2 != null) {
                        linearLayout2.setBackgroundResource(R.drawable.cui);
                    }
                    TextView textView3 = aVar3.tsd;
                    if (textView3 != null) {
                        textView3.setTextColor(aVar3.gte.getResources().getColor(R.color.FG_2));
                        AppMethodBeat.o(242031);
                        return;
                    }
                    AppMethodBeat.o(242031);
                    return;
                }
            }
        }
        AppMethodBeat.o(242031);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class q implements Runnable {
        final /* synthetic */ FinderActivityActionBarUIC tqD;

        q(FinderActivityActionBarUIC finderActivityActionBarUIC) {
            this.tqD = finderActivityActionBarUIC;
        }

        public final void run() {
            AppMethodBeat.i(260074);
            Log.i("Finder.ActivityActionBarUIC", "forceCampaignVisible execute!");
            FinderActivityActionBarUIC.b(this.tqD, this.tqD.dMU);
            AppMethodBeat.o(260074);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class p implements Runnable {
        final /* synthetic */ FinderActivityActionBarUIC tqD;

        p(FinderActivityActionBarUIC finderActivityActionBarUIC) {
            this.tqD = finderActivityActionBarUIC;
        }

        public final void run() {
            AppMethodBeat.i(242027);
            ProgressBar progressBar = this.tqD.progressBar;
            if (progressBar != null) {
                Log.i("Finder.ActivityActionBarUIC", "showProgress visible change");
                if (progressBar.getVisibility() != 0) {
                    progressBar.setVisibility(0);
                }
                AppMethodBeat.o(242027);
                return;
            }
            AppMethodBeat.o(242027);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderActivityActionBarUIC tqD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderActivityActionBarUIC finderActivityActionBarUIC) {
            super(0);
            this.tqD = finderActivityActionBarUIC;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(242012);
            ProgressBar progressBar = this.tqD.progressBar;
            if (progressBar != null && progressBar.getVisibility() == 0) {
                progressBar.setVisibility(8);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(242012);
            return xVar;
        }
    }

    public static final /* synthetic */ void a(FinderActivityActionBarUIC finderActivityActionBarUIC) {
        AppMethodBeat.i(242034);
        if (finderActivityActionBarUIC.hOv == null) {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) finderActivityActionBarUIC.getActivity(), 0, true);
            View inflate = aa.jQ(finderActivityActionBarUIC.getContext()).inflate(R.layout.ceq, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.jsy);
            String string = finderActivityActionBarUIC.getContext().getResources().getString(R.string.j9p);
            kotlin.g.b.p.g(string, "context.resources.getStr…r_activity_announce_name)");
            String string2 = finderActivityActionBarUIC.getResources().getString(R.string.jd1, string);
            kotlin.g.b.p.g(string2, "resources.getString(R.st…n_announce, announceName)");
            SpannableString spannableString = new SpannableString(string2 + ' ');
            Drawable m2 = ar.m(finderActivityActionBarUIC.getContext(), R.raw.icons_outlined_arrow, finderActivityActionBarUIC.getResources().getColor(R.color.FG_1));
            m2.setBounds(0, 0, (int) finderActivityActionBarUIC.getContext().getResources().getDimension(R.dimen.a4n), (int) finderActivityActionBarUIC.getContext().getResources().getDimension(R.dimen.c5));
            spannableString.setSpan(new com.tencent.mm.ui.widget.a(m2, 1), spannableString.length() - 1, spannableString.length(), 17);
            spannableString.setSpan(new com.tencent.mm.plugin.finder.view.l(string2, finderActivityActionBarUIC.getContext().getResources().getColor(R.color.vj), finderActivityActionBarUIC.getContext().getResources().getColor(R.color.ac_), false, false, new o(finderActivityActionBarUIC)), string2.length() - 6, string2.length(), 17);
            textView.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(finderActivityActionBarUIC.getContext()));
            kotlin.g.b.p.g(textView, "textView");
            textView.setText(spannableString);
            kotlin.g.b.p.g(inflate, "headerView");
            eVar.V(inflate, true);
            eVar.a(new h(finderActivityActionBarUIC));
            eVar.a(new i(finderActivityActionBarUIC));
            eVar.b(new j(finderActivityActionBarUIC));
            eVar.b(new k(finderActivityActionBarUIC));
            eVar.b(new l(finderActivityActionBarUIC));
            finderActivityActionBarUIC.hOv = eVar;
        }
        com.tencent.mm.ui.widget.a.e eVar2 = finderActivityActionBarUIC.hOv;
        if (eVar2 != null) {
            eVar2.dGm();
            AppMethodBeat.o(242034);
            return;
        }
        AppMethodBeat.o(242034);
    }

    public static final /* synthetic */ boolean b(FinderActivityActionBarUIC finderActivityActionBarUIC) {
        String str;
        AppMethodBeat.i(242035);
        boolean isNullOrNil = Util.isNullOrNil(finderActivityActionBarUIC.activityName);
        StringBuilder append = new StringBuilder("notShare ").append(isNullOrNil).append(", ");
        aqk aqk = finderActivityActionBarUIC.tqo;
        if (aqk != null) {
            str = aqk.eventName;
        } else {
            str = null;
        }
        Log.i("Finder.ActivityActionBarUIC", append.append(Util.isNullOrNil(str)).toString());
        AppMethodBeat.o(242035);
        return isNullOrNil;
    }

    public static final /* synthetic */ String d(FinderActivityActionBarUIC finderActivityActionBarUIC) {
        String str;
        AppMethodBeat.i(242036);
        aqk aqk = finderActivityActionBarUIC.tqo;
        if (aqk == null || (str = aqk.coverImgUrl) == null) {
            str = "";
        }
        AppMethodBeat.o(242036);
        return str;
    }

    public static final /* synthetic */ String e(FinderActivityActionBarUIC finderActivityActionBarUIC) {
        AppMethodBeat.i(242037);
        bds bds = finderActivityActionBarUIC.dMU;
        String string = finderActivityActionBarUIC.getResources().getString(R.string.cgz, com.tencent.mm.plugin.finder.utils.k.Lw(bds != null ? bds.LzC : 0));
        kotlin.g.b.p.g(string, "resources.getString(R.st…Number(participateCount))");
        AppMethodBeat.o(242037);
        return string;
    }

    public static final /* synthetic */ aoi f(FinderActivityActionBarUIC finderActivityActionBarUIC) {
        String str;
        String str2;
        int i2;
        FinderContact finderContact;
        AppMethodBeat.i(242038);
        aoi aoi = new aoi();
        aqk aqk = finderActivityActionBarUIC.tqo;
        aoi.LAp = com.tencent.mm.ac.d.zs(aqk != null ? aqk.twd : 0);
        aqk aqk2 = finderActivityActionBarUIC.tqo;
        if (aqk2 == null || (str = aqk2.eventName) == null) {
            str = "";
        }
        aoi.LAq = str;
        aqk aqk3 = finderActivityActionBarUIC.tqo;
        if (aqk3 == null || (finderContact = aqk3.contact) == null || (str2 = finderContact.nickname) == null) {
            str2 = "";
        }
        aoi.LAr = str2;
        aqk aqk4 = finderActivityActionBarUIC.tqo;
        if (aqk4 != null) {
            i2 = aqk4.LCy;
        } else {
            i2 = 0;
        }
        aoi.trl = i2;
        AppMethodBeat.o(242038);
        return aoi;
    }

    public static final /* synthetic */ boolean g(FinderActivityActionBarUIC finderActivityActionBarUIC) {
        String str;
        aqk aqk;
        aqk aqk2;
        FinderContact finderContact;
        AppMethodBeat.i(242039);
        aqk aqk3 = finderActivityActionBarUIC.tqo;
        if (aqk3 == null || (finderContact = aqk3.contact) == null) {
            str = null;
        } else {
            str = finderContact.username;
        }
        if (kotlin.g.b.p.j(str, z.aUg())) {
            y yVar = y.vXH;
            bds bds = finderActivityActionBarUIC.dMU;
            int i2 = (bds == null || (aqk2 = bds.LNz) == null) ? 0 : aqk2.ViD;
            bds bds2 = finderActivityActionBarUIC.dMU;
            if (!y.bd(i2, (bds2 == null || (aqk = bds2.LNz) == null) ? 0 : aqk.endTime)) {
                AppMethodBeat.o(242039);
                return true;
            }
        }
        AppMethodBeat.o(242039);
        return false;
    }

    public static final /* synthetic */ void h(FinderActivityActionBarUIC finderActivityActionBarUIC) {
        AppMethodBeat.i(242040);
        if (finderActivityActionBarUIC.tqs == null) {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) finderActivityActionBarUIC.getActivity(), 1, true);
            eVar.j(finderActivityActionBarUIC.getResources().getString(R.string.cgm), 17, finderActivityActionBarUIC.getResources().getDimensionPixelSize(R.dimen.kc));
            eVar.a(new m(finderActivityActionBarUIC));
            eVar.a(new n(finderActivityActionBarUIC));
            eVar.b(new r(finderActivityActionBarUIC));
            finderActivityActionBarUIC.tqs = eVar;
        }
        com.tencent.mm.ui.widget.a.e eVar2 = finderActivityActionBarUIC.tqs;
        if (eVar2 != null) {
            if (!eVar2.isShowing()) {
                eVar2.dGm();
            }
            AppMethodBeat.o(242040);
            return;
        }
        AppMethodBeat.o(242040);
    }

    public static final /* synthetic */ void j(FinderActivityActionBarUIC finderActivityActionBarUIC) {
        String str;
        FinderContact finderContact;
        AppMethodBeat.i(242041);
        aqk aqk = finderActivityActionBarUIC.tqo;
        if (aqk != null) {
            aqk aqk2 = finderActivityActionBarUIC.tqo;
            if (aqk2 == null || (finderContact = aqk2.contact) == null || (str = finderContact.username) == null) {
                str = "";
            }
            kotlin.g.b.p.g(str, "eventInfo?.contact?.username ?: \"\"");
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(finderActivityActionBarUIC.getActivity()).get(FinderReporterUIC.class)).dIx();
            new bw(1, Long.valueOf(aqk.twd), str, null, dIx).d(finderActivityActionBarUIC.getActivity(), finderActivityActionBarUIC.getResources().getString(R.string.dbf), 500);
            com.tencent.mm.kernel.g.azz().b(new bw(1, Long.valueOf(aqk.twd), str, null, dIx));
            AppMethodBeat.o(242041);
            return;
        }
        Log.i("Finder.ActivityActionBarUIC", "closeActivity invalid eventInfo null");
        AppMethodBeat.o(242041);
    }

    public static final /* synthetic */ void n(FinderActivityActionBarUIC finderActivityActionBarUIC) {
        AppMethodBeat.i(242042);
        StringBuilder sb = new StringBuilder("dismissProgress: ");
        ProgressBar progressBar2 = finderActivityActionBarUIC.progressBar;
        Log.i("Finder.ActivityActionBarUIC", sb.append(progressBar2 != null ? Integer.valueOf(progressBar2.getVisibility()) : null).toString());
        com.tencent.f.i.d<?> dVar = finderActivityActionBarUIC.tqp;
        if (dVar != null) {
            dVar.cancel(false);
        }
        com.tencent.mm.ac.d.h(new c(finderActivityActionBarUIC));
        AppMethodBeat.o(242042);
    }

    public static final /* synthetic */ void s(FinderActivityActionBarUIC finderActivityActionBarUIC) {
        AppMethodBeat.i(260083);
        FrameLayout frameLayout = finderActivityActionBarUIC.tqq;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        ProgressBar progressBar2 = finderActivityActionBarUIC.progressBar;
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
        View view = finderActivityActionBarUIC.tql;
        if (view != null) {
            view.setVisibility(0);
        }
        LinearLayout linearLayout = finderActivityActionBarUIC.tqm;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        LinearLayout linearLayout2 = finderActivityActionBarUIC.tqn;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(4);
        }
        View findViewById = finderActivityActionBarUIC.getActivity().findViewById(R.id.gl0);
        if (findViewById != null) {
            findViewById.setVisibility(4);
        }
        AppCompatActivity activity = finderActivityActionBarUIC.getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(260083);
            throw tVar;
        }
        ((MMActivity) activity).getController().updataStatusBarIcon(ao.isDarkMode());
        ImageView imageView = finderActivityActionBarUIC.tqk;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        ImageView imageView2 = finderActivityActionBarUIC.tqi;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        ViewGroup viewGroup = finderActivityActionBarUIC.UGR;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        View view2 = finderActivityActionBarUIC.UGU;
        if (view2 != null) {
            view2.setVisibility(8);
            AppMethodBeat.o(260083);
            return;
        }
        AppMethodBeat.o(260083);
    }
}
