package com.tencent.mm.plugin.appbrand.jsapi.ag.e.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.luggage.h.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.al;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import java.util.TimerTask;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017*\u0001\r\u0018\u0000 L2\u00020\u0001:\u0002LMB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\b\u0010A\u001a\u00020\u0005H\u0002J\u0012\u0010B\u001a\u00020\u00152\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010C\u001a\u00020\u0015J$\u0010D\u001a\u00020\u00152\u001c\u0010E\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0013J\b\u0010F\u001a\u00020\u0015H\u0016J\b\u0010G\u001a\u00020\u0015H\u0002J\u0006\u0010H\u001a\u00020\u0015J\u0006\u0010I\u001a\u00020\u0015J\u000e\u0010J\u001a\u00020\u00152\u0006\u0010K\u001a\u00020\u0011R\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R&\u0010\u0012\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001fR\u0011\u0010 \u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b \u0010\u001fR\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R5\u0010-\u001a\u001d\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b/\u0012\b\b0\u0012\u0004\b\b(1\u0012\u0004\u0012\u00020\u00150.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0012\u00106\u001a\u000607R\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\"X.¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\u00020\u00118CX\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0016\u0010<\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@¨\u0006N"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "context", "Landroid/content/Context;", "customStyle", "", "videoCastHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "videoCastDeviceManager", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "isSearchForSwitch", "(Landroid/content/Context;ZLcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;Z)V", "backKeyEventObserver", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1;", "curLandscape", "curRotation", "", "deviceClickListener", "Lkotlin/Function2;", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "", "helpClickListener", "Lkotlin/Function0;", "getHelpClickListener", "()Lkotlin/jvm/functions/Function0;", "setHelpClickListener", "(Lkotlin/jvm/functions/Function0;)V", "hideNavigationFullScreen", "hideStatusBar", "isLandscape", "()Z", "isShowing", "mAnchorView", "Landroid/view/View;", "mBehavior", "Landroid/support/design/widget/BottomSheetBehavior;", "mBottomSheetDialog", "Landroid/app/Dialog;", "mContext", "mTreeObserver", "Landroid/view/ViewTreeObserver;", "maxBottomSheetHeight", "newLandscapeMaxWidth", "newLandscapeStyle", "onHide", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "devicesCount", "getOnHide", "()Lkotlin/jvm/functions/Function1;", "setOnHide", "(Lkotlin/jvm/functions/Function1;)V", "recycleViewAdapter", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;", "rootView", "rotation", "getRotation", "()I", "selectDeviceCancelAction", "getVideoCastDeviceManager", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager;", "getVideoCastHandler", "()Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler;", "hadRecentDevices", "initView", "notifyChange", "onBottomSheetSelected", "function", "onGlobalLayout", "setBottomSheetParams", "tryHide", "tryShow", "updateBottomSheet", "pos", "Companion", "RecycleViewAdapter", "luggage-xweb-ext_release"})
public final class g implements ViewTreeObserver.OnGlobalLayoutListener {
    public static final a mLY = new a((byte) 0);
    ViewTreeObserver afI;
    final com.tencent.mm.plugin.appbrand.jsapi.ag.e.b cJc;
    View lJI;
    Context mContext;
    Dialog mLH;
    b mLI;
    int mLJ;
    BottomSheetBehavior<?> mLK;
    boolean mLL;
    int mLM;
    boolean mLN;
    boolean mLO;
    boolean mLP;
    int mLQ;
    m<? super com.tencent.mm.plugin.appbrand.g.b.c, ? super Integer, x> mLR;
    private kotlin.g.a.a<x> mLS;
    kotlin.g.a.b<? super Integer, x> mLT;
    kotlin.g.a.a<x> mLU;
    private final c mLV;
    final j mLW;
    final boolean mLX;
    View qK;

    static {
        AppMethodBeat.i(139710);
        AppMethodBeat.o(139710);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    static final class h extends q implements kotlin.g.a.b<Integer, x> {
        public static final h mMk = new h();

        static {
            AppMethodBeat.i(139703);
            AppMethodBeat.o(139703);
        }

        h() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Integer num) {
            AppMethodBeat.i(139702);
            num.intValue();
            x xVar = x.SXb;
            AppMethodBeat.o(139702);
            return xVar;
        }
    }

    private g(Context context, com.tencent.mm.plugin.appbrand.jsapi.ag.e.b bVar, j jVar, boolean z) {
        android.support.design.widget.a aVar;
        int aH;
        p.h(context, "context");
        p.h(bVar, "videoCastHandler");
        p.h(jVar, "videoCastDeviceManager");
        AppMethodBeat.i(139709);
        this.cJc = bVar;
        this.mLW = jVar;
        this.mLX = z;
        this.mContext = context;
        this.mLO = true;
        this.mLP = true;
        this.mLT = h.mMk;
        this.mLV = new c(this);
        if (this.mContext instanceof Activity) {
            Context context2 = this.mContext;
            if (context2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(139709);
                throw tVar;
            }
            Window window = ((Activity) context2).getWindow();
            p.g(window, "(mContext as Activity).window");
            View decorView = window.getDecorView();
            if (decorView == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(139709);
                throw tVar2;
            }
            this.qK = ((ViewGroup) decorView).findViewById(16908290);
        }
        Context context3 = this.mContext;
        if (this.mLP) {
            if (context3 == null) {
                p.hyc();
            }
            aVar = new com.tencent.mm.ui.widget.a.b(context3);
        } else {
            if (context3 == null) {
                p.hyc();
            }
            aVar = new android.support.design.widget.a(context3);
        }
        this.mLH = aVar;
        View inflate = View.inflate(context3, R.layout.azf, null);
        p.g(inflate, "View.inflate(context, R.…video_cast_devices, null)");
        this.lJI = inflate;
        View view = this.lJI;
        if (view == null) {
            p.btv("rootView");
        }
        view.findViewById(R.id.ixo).setOnClickListener(new d(this));
        View view2 = this.lJI;
        if (view2 == null) {
            p.btv("rootView");
        }
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.ab7);
        recyclerView.setHasFixedSize(true);
        View view3 = this.lJI;
        if (view3 == null) {
            p.btv("rootView");
        }
        view3.findViewById(R.id.e4g).setOnClickListener(new e(this));
        View view4 = this.lJI;
        if (view4 == null) {
            p.btv("rootView");
        }
        ImageView imageView = (ImageView) view4.findViewById(R.id.e4f);
        if (j.cDv.isDarkMode()) {
            Context context4 = this.mContext;
            if (context4 == null) {
                p.hyc();
            }
            imageView.setImageDrawable(android.support.v4.content.b.l(context4, R.drawable.bwd));
        } else {
            Context context5 = this.mContext;
            if (context5 == null) {
                p.hyc();
            }
            imageView.setImageDrawable(android.support.v4.content.b.l(context5, R.drawable.bw9));
        }
        this.mLL = isLandscape();
        int aH2 = at.aH(this.mContext, R.dimen.u2);
        if (this.mLL) {
            aH = ((int) (((double) aH2) * 4.5d)) + at.aH(this.mContext, R.dimen.tv);
        } else {
            aH = ((int) (((double) aH2) * 6.5d)) + at.aH(this.mContext, R.dimen.tv);
        }
        this.mLJ = aH;
        p.g(recyclerView, "mRecyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager());
        recyclerView.setFocusable(false);
        this.mLI = new b();
        b bVar2 = this.mLI;
        if (bVar2 == null) {
            p.btv("recycleViewAdapter");
        }
        recyclerView.setAdapter(bVar2);
        recyclerView.setOverScrollMode(1);
        Dialog dialog = this.mLH;
        if (dialog == null) {
            p.btv("mBottomSheetDialog");
        }
        View view5 = this.lJI;
        if (view5 == null) {
            p.btv("rootView");
        }
        dialog.setContentView(view5);
        if (!this.mLP) {
            View view6 = this.lJI;
            if (view6 == null) {
                p.btv("rootView");
            }
            ViewParent parent = view6.getParent();
            if (parent == null) {
                t tVar3 = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(139709);
                throw tVar3;
            }
            this.mLK = BottomSheetBehavior.l((View) parent);
            BottomSheetBehavior<?> bottomSheetBehavior = this.mLK;
            if (bottomSheetBehavior == null) {
                p.hyc();
            }
            bottomSheetBehavior.J(this.mLJ);
        }
        Dialog dialog2 = this.mLH;
        if (dialog2 == null) {
            p.btv("mBottomSheetDialog");
        }
        dialog2.setOnCancelListener(new f(this));
        Dialog dialog3 = this.mLH;
        if (dialog3 == null) {
            p.btv("mBottomSheetDialog");
        }
        dialog3.setOnDismissListener(new DialogInterface$OnDismissListenerC0616g(this));
        Dialog dialog4 = this.mLH;
        if (dialog4 == null) {
            p.btv("mBottomSheetDialog");
        }
        dialog4.setCancelable(false);
        this.cJc.getRuntime().a(4, -1, this.mLV);
        AppMethodBeat.o(139709);
    }

    public /* synthetic */ g(Context context, com.tencent.mm.plugin.appbrand.jsapi.ag.e.b bVar, j jVar, boolean z, byte b2) {
        this(context, bVar, jVar, z);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"WrongConstant"})
    public final int getRotation() {
        AppMethodBeat.i(139704);
        int i2 = 0;
        if (this.mContext instanceof Activity) {
            Context context = this.mContext;
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(139704);
                throw tVar;
            }
            Window window = ((Activity) context).getWindow();
            p.g(window, "(mContext as Activity).window");
            WindowManager windowManager = window.getWindowManager();
            p.g(windowManager, "(mContext as Activity).window.windowManager");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            p.g(defaultDisplay, "(mContext as Activity).w…dowManager.defaultDisplay");
            i2 = defaultDisplay.getRotation();
        }
        AppMethodBeat.o(139704);
        return i2;
    }

    public final boolean isShowing() {
        AppMethodBeat.i(139705);
        if (this.mLH != null) {
            Dialog dialog = this.mLH;
            if (dialog == null) {
                p.btv("mBottomSheetDialog");
            }
            if (dialog.isShowing()) {
                AppMethodBeat.o(139705);
                return true;
            }
        }
        AppMethodBeat.o(139705);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean isLandscape() {
        AppMethodBeat.i(139706);
        Context context = this.mContext;
        if (context == null) {
            p.hyc();
        }
        Resources resources = context.getResources();
        p.g(resources, "mContext!!.resources");
        if (resources.getConfiguration().orientation == 2) {
            AppMethodBeat.o(139706);
            return true;
        }
        AppMethodBeat.o(139706);
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"})
    public static final class c extends al {
        final /* synthetic */ g mLZ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(g gVar) {
            this.mLZ = gVar;
        }

        @Override // com.tencent.mm.plugin.appbrand.al
        public final boolean c(KeyEvent keyEvent) {
            AppMethodBeat.i(139698);
            p.h(keyEvent, "event");
            if (1 == keyEvent.getAction()) {
                AppMethodBeat.o(139698);
                return false;
            }
            m mVar = this.mLZ.mLR;
            if (mVar != null) {
                mVar.invoke(null, 0);
            }
            this.mLZ.bMo();
            AppMethodBeat.o(139698);
            return true;
        }
    }

    public final void onGlobalLayout() {
        AppMethodBeat.i(139707);
        if (isShowing()) {
            View view = this.qK;
            if (view == null || (!view.isShown() && view.getVisibility() != 0)) {
                bMo();
                AppMethodBeat.o(139707);
                return;
            } else if (isShowing() && !(this.mLL == isLandscape() && this.mLM == getRotation())) {
                bMo();
            }
        }
        AppMethodBeat.o(139707);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class d implements View.OnClickListener {
        final /* synthetic */ g mLZ;

        d(g gVar) {
            this.mLZ = gVar;
        }

        public final void onClick(View view) {
            kotlin.g.a.a<x> aVar;
            AppMethodBeat.i(139699);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(this.mLZ.mLU == null || (aVar = this.mLZ.mLU) == null)) {
                aVar.invoke();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(139699);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u000e\u0010\b\u001a\n0\tR\u00060\u0000R\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010\r\u001a\u00020\u00072\u000e\u0010\b\u001a\n0\u000eR\u00060\u0000R\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00072\u000e\u0010\b\u001a\n0\u000eR\u00060\u0000R\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;)V", "mItemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "bindDeviceViewHolder", "", "holder", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$DeviceViewHolder;", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet;", "position", "", "bindRecentHeader", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$TitleViewHolder;", "bindSearchHeader", "deviceFallbackName", "", "device", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/MRDeviceWithStatus;", "deviceFriendlyName", "getDevice", "posSubFistTitle", "getDeviceName", "getItemCount", "getItemViewType", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DeviceViewHolder", "TitleViewHolder", "luggage-xweb-ext_release"})
    final class b extends RecyclerView.a<RecyclerView.v> {

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "kotlin-stdlib"})
        public static final class d extends TimerTask {
            final /* synthetic */ b mMf;
            final /* synthetic */ C0615b mMi;

            public d(b bVar, C0615b bVar2) {
                this.mMf = bVar;
                this.mMi = bVar2;
            }

            public final void run() {
                AppMethodBeat.i(139692);
                MMHandlerThread.postToMainThread(new a(this));
                AppMethodBeat.o(139692);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$bindSearchHeader$1$1"})
            static final class a implements Runnable {
                final /* synthetic */ d mMj;

                a(d dVar) {
                    this.mMj = dVar;
                }

                public final void run() {
                    String str;
                    AppMethodBeat.i(139691);
                    this.mMj.mMi.progressBar.setVisibility(8);
                    TextView textView = this.mMj.mMi.mMg;
                    if (g.b(g.this)) {
                        str = "暂无其他设备";
                    } else if (g.this.mLW.mMU.isEmpty()) {
                        str = "暂无可连接设备";
                    } else {
                        str = "可连接设备";
                    }
                    textView.setText(str);
                    AppMethodBeat.o(139691);
                }
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        public static final /* synthetic */ e a(b bVar, int i2) {
            AppMethodBeat.i(169117);
            e xW = bVar.xW(i2);
            AppMethodBeat.o(169117);
            return xW;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final RecyclerView.v a(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(139693);
            p.h(viewGroup, "parent");
            if (i2 == 3) {
                View inflate = LayoutInflater.from(g.this.mContext).inflate(R.layout.axc, viewGroup, false);
                p.g(inflate, "itemView");
                a aVar = new a(this, inflate);
                AppMethodBeat.o(139693);
                return aVar;
            }
            View inflate2 = LayoutInflater.from(g.this.mContext).inflate(R.layout.azg, viewGroup, false);
            p.g(inflate2, "itemView");
            C0615b bVar = new C0615b(this, inflate2);
            AppMethodBeat.o(139693);
            return bVar;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemViewType(int i2) {
            AppMethodBeat.i(139694);
            if (i2 == 0 && g.b(g.this)) {
                AppMethodBeat.o(139694);
                return 1;
            } else if (i2 == 0) {
                AppMethodBeat.o(139694);
                return 2;
            } else if (!g.b(g.this) || i2 != g.this.mLW.mMV.size() + 1) {
                AppMethodBeat.o(139694);
                return 3;
            } else {
                AppMethodBeat.o(139694);
                return 2;
            }
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.support.v7.widget.RecyclerView.a
        public final void a(RecyclerView.v vVar, int i2) {
            String str;
            AppMethodBeat.i(139695);
            p.h(vVar, "viewHolder");
            switch (getItemViewType(i2)) {
                case 1:
                    C0615b bVar = (C0615b) vVar;
                    bVar.progressBar.setVisibility(8);
                    if (g.b(g.this)) {
                        bVar.mMg.setText("最近连接");
                        AppMethodBeat.o(139695);
                        return;
                    }
                    bVar.mMg.setVisibility(8);
                    AppMethodBeat.o(139695);
                    return;
                case 2:
                    C0615b bVar2 = (C0615b) vVar;
                    TextView textView = bVar2.mMg;
                    if (g.b(g.this)) {
                    }
                    textView.setText(str);
                    kotlin.c.b.btu("progressBarHolder").schedule(new d(this, bVar2), 10000, MAlarmHandler.NEXT_FIRE_INTERVAL);
                    break;
                case 3:
                    a aVar = (a) vVar;
                    int i3 = i2 - 1;
                    aVar.mMb.setOnClickListener(new c(this, i3, i2));
                    e xW = xW(i3);
                    Log.d("MicroMsg.VideoCast.SelectDevicesBottomSheet", "bindDeviceViewHolder: ".concat(String.valueOf(xW)));
                    TextView textView2 = aVar.mMa;
                    com.tencent.mm.plugin.appbrand.g.b.b bBo = xW.mLG.bBo();
                    if (bBo == null) {
                        p.hyc();
                    }
                    String str2 = bBo.ljP;
                    p.g(str2, "device.mrDevice.dlnaDevice!!.friendlyName");
                    if (Util.isNullOrNil(str2)) {
                        com.tencent.mm.plugin.appbrand.g.b.b bBo2 = xW.mLG.bBo();
                        if (bBo2 == null) {
                            p.hyc();
                        }
                        str2 = bBo2.ljR;
                        p.g(str2, "device.mrDevice.dlnaDevice!!.modeName");
                    }
                    textView2.setText(str2);
                    if (!g.this.mLX) {
                        aVar.mMc.setVisibility(8);
                        aVar.mMd.setVisibility(8);
                        aVar.mMe.setVisibility(8);
                        AppMethodBeat.o(139695);
                        return;
                    } else if (xW.hmV && xW.isSelected && !xW.mLF) {
                        aVar.mMc.setVisibility(0);
                        aVar.mMe.setVisibility(8);
                        aVar.mMd.setVisibility(8);
                        AppMethodBeat.o(139695);
                        return;
                    } else if (!xW.hmV && xW.mLF && xW.isSelected) {
                        aVar.mMc.setVisibility(8);
                        aVar.mMe.setVisibility(8);
                        aVar.mMd.setVisibility(0);
                        AppMethodBeat.o(139695);
                        return;
                    } else if (xW.mLF || !xW.isSelected || xW.hmV) {
                        if (!xW.isSelected) {
                            aVar.mMc.setVisibility(8);
                            aVar.mMe.setVisibility(8);
                            aVar.mMd.setVisibility(8);
                        }
                        AppMethodBeat.o(139695);
                        return;
                    } else {
                        aVar.mMc.setVisibility(8);
                        aVar.mMe.setVisibility(8);
                        aVar.mMd.setVisibility(0);
                        AppMethodBeat.o(139695);
                        return;
                    }
            }
            AppMethodBeat.o(139695);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class c implements View.OnClickListener {
            final /* synthetic */ int gUj;
            final /* synthetic */ b mMf;
            final /* synthetic */ int mMh;

            c(b bVar, int i2, int i3) {
                this.mMf = bVar;
                this.mMh = i2;
                this.gUj = i3;
            }

            public final void onClick(View view) {
                boolean z;
                AppMethodBeat.i(139690);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$bindDeviceViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (g.this.mLR != null) {
                    if (!g.this.mLW.mMV.isEmpty()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z || this.mMh > g.this.mLW.mMV.size()) {
                        m mVar = g.this.mLR;
                        if (mVar == null) {
                            p.hyc();
                        }
                        mVar.invoke(b.a(this.mMf, this.mMh).mLG, Integer.valueOf(this.gUj));
                    } else {
                        m mVar2 = g.this.mLR;
                        if (mVar2 == null) {
                            p.hyc();
                        }
                        mVar2.invoke(b.a(this.mMf, this.mMh).mLG, Integer.valueOf(this.gUj));
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$bindDeviceViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(139690);
            }
        }

        private final e xW(int i2) {
            boolean z;
            boolean z2;
            e eVar;
            AppMethodBeat.i(139696);
            if (!g.this.mLW.mMV.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (!z || i2 > g.this.mLW.mMV.size()) {
                if (!g.this.mLW.mMV.isEmpty()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    eVar = g.this.mLW.mMU.get((i2 - g.this.mLW.mMV.size()) - 1);
                } else {
                    eVar = g.this.mLW.mMU.get(i2);
                }
                p.g(eVar, "if (videoCastDeviceManag…tTitle]\n                }");
                AppMethodBeat.o(139696);
                return eVar;
            }
            e eVar2 = g.this.mLW.mMV.get(i2);
            p.g(eVar2, "videoCastDeviceManager.r…tDevices[posSubFistTitle]");
            e eVar3 = eVar2;
            AppMethodBeat.o(139696);
            return eVar3;
        }

        @Override // android.support.v7.widget.RecyclerView.a
        public final int getItemCount() {
            int size;
            AppMethodBeat.i(139697);
            if (g.b(g.this)) {
                size = g.this.mLW.mMV.size() + g.this.mLW.mMU.size() + 2;
            } else {
                size = g.this.mLW.mMU.size() + g.this.mLW.mMV.size() + 1;
            }
            Log.d("MicroMsg.VideoCast.SelectDevicesBottomSheet", "item count = ".concat(String.valueOf(size)));
            AppMethodBeat.o(139697);
            return size;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$DeviceViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;Landroid/view/View;)V", "castFailTextView", "Landroid/widget/TextView;", "getCastFailTextView$luggage_xweb_ext_release", "()Landroid/widget/TextView;", "setCastFailTextView$luggage_xweb_ext_release", "(Landroid/widget/TextView;)V", "connectedImageView", "Landroid/widget/ImageView;", "getConnectedImageView$luggage_xweb_ext_release", "()Landroid/widget/ImageView;", "setConnectedImageView$luggage_xweb_ext_release", "(Landroid/widget/ImageView;)V", "connectingProgressBar", "Landroid/widget/ProgressBar;", "getConnectingProgressBar$luggage_xweb_ext_release", "()Landroid/widget/ProgressBar;", "setConnectingProgressBar$luggage_xweb_ext_release", "(Landroid/widget/ProgressBar;)V", "deviceName", "getDeviceName$luggage_xweb_ext_release", "setDeviceName$luggage_xweb_ext_release", "itemFrameLayout", "Landroid/widget/FrameLayout;", "getItemFrameLayout$luggage_xweb_ext_release", "()Landroid/widget/FrameLayout;", "setItemFrameLayout$luggage_xweb_ext_release", "(Landroid/widget/FrameLayout;)V", "luggage-xweb-ext_release"})
        @SuppressLint({"ResourceType"})
        public final class a extends RecyclerView.v {
            TextView mMa;
            FrameLayout mMb;
            ProgressBar mMc;
            ImageView mMd;
            TextView mMe;
            final /* synthetic */ b mMf;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(b bVar, View view) {
                super(view);
                p.h(view, "itemView");
                this.mMf = bVar;
                AppMethodBeat.i(139688);
                View findViewById = view.findViewById(R.id.ix8);
                p.g(findViewById, "itemView.findViewById(R.id.tv_device_name)");
                this.mMa = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.d5r);
                p.g(findViewById2, "itemView.findViewById(R.id.fl_device_item)");
                this.mMb = (FrameLayout) findViewById2;
                View findViewById3 = view.findViewById(R.id.g_z);
                p.g(findViewById3, "itemView.findViewById(R.id.pb_device_connecting)");
                this.mMc = (ProgressBar) findViewById3;
                View findViewById4 = view.findViewById(R.id.e4h);
                p.g(findViewById4, "itemView.findViewById(R.id.iv_connected)");
                this.mMd = (ImageView) findViewById4;
                View findViewById5 = view.findViewById(R.id.iwx);
                p.g(findViewById5, "itemView.findViewById(R.id.tv_cast_fail)");
                this.mMe = (TextView) findViewById5;
                this.mMd.setImageResource(R.raw.cast_successful);
                AppMethodBeat.o(139688);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter$TitleViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$RecycleViewAdapter;Landroid/view/View;)V", "headerTextView", "Landroid/widget/TextView;", "getHeaderTextView$luggage_xweb_ext_release", "()Landroid/widget/TextView;", "setHeaderTextView$luggage_xweb_ext_release", "(Landroid/widget/TextView;)V", "progressBar", "Landroid/widget/ProgressBar;", "getProgressBar$luggage_xweb_ext_release", "()Landroid/widget/ProgressBar;", "setProgressBar$luggage_xweb_ext_release", "(Landroid/widget/ProgressBar;)V", "luggage-xweb-ext_release"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.g$b$b  reason: collision with other inner class name */
        public final class C0615b extends RecyclerView.v {
            final /* synthetic */ b mMf;
            TextView mMg;
            ProgressBar progressBar;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0615b(b bVar, View view) {
                super(view);
                p.h(view, "itemView");
                this.mMf = bVar;
                AppMethodBeat.i(139689);
                View findViewById = view.findViewById(R.id.iyh);
                p.g(findViewById, "itemView.findViewById(R.id.tv_select_device_title)");
                this.mMg = (TextView) findViewById;
                View findViewById2 = view.findViewById(R.id.ga0);
                p.g(findViewById2, "itemView.findViewById(R.id.pb_device_search)");
                this.progressBar = (ProgressBar) findViewById2;
                AppMethodBeat.o(139689);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e implements View.OnClickListener {
        final /* synthetic */ g mLZ;

        e(g gVar) {
            this.mLZ = gVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(139700);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            kotlin.g.a.a aVar = this.mLZ.mLS;
            if (aVar != null) {
                aVar.invoke();
            }
            m mVar = this.mLZ.mLR;
            if (mVar != null) {
                mVar.invoke(null, 0);
            }
            this.mLZ.bMo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(139700);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class f implements DialogInterface.OnCancelListener {
        final /* synthetic */ g mLZ;

        f(g gVar) {
            this.mLZ = gVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(161188);
            m mVar = this.mLZ.mLR;
            if (mVar != null) {
                mVar.invoke(null, 0);
            }
            this.mLZ.cJc.getRuntime().a(this.mLZ.mLV);
            AppMethodBeat.o(161188);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ag.e.a.g$g  reason: collision with other inner class name */
    static final class DialogInterface$OnDismissListenerC0616g implements DialogInterface.OnDismissListener {
        final /* synthetic */ g mLZ;

        DialogInterface$OnDismissListenerC0616g(g gVar) {
            this.mLZ = gVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(161189);
            if (this.mLZ.afI != null) {
                ViewTreeObserver viewTreeObserver = this.mLZ.afI;
                if (viewTreeObserver == null) {
                    p.hyc();
                }
                if (!viewTreeObserver.isAlive()) {
                    g gVar = this.mLZ;
                    View view = this.mLZ.qK;
                    if (view == null) {
                        p.hyc();
                    }
                    gVar.afI = view.getViewTreeObserver();
                }
                ViewTreeObserver viewTreeObserver2 = this.mLZ.afI;
                if (viewTreeObserver2 == null) {
                    p.hyc();
                }
                viewTreeObserver2.removeGlobalOnLayoutListener(this.mLZ);
                this.mLZ.afI = null;
            }
            this.mLZ.mLT.invoke(Integer.valueOf(this.mLZ.mLW.mMU.size() + this.mLZ.mLW.mMV.size()));
            AppMethodBeat.o(161189);
        }
    }

    public final void bMo() {
        AppMethodBeat.i(139708);
        if (this.mLH != null) {
            if (this.mLK != null) {
                BottomSheetBehavior<?> bottomSheetBehavior = this.mLK;
                if (bottomSheetBehavior == null) {
                    p.hyc();
                }
                bottomSheetBehavior.u(true);
            }
            if (this.mContext != null) {
                Context context = this.mContext;
                if (context == null) {
                    t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                    AppMethodBeat.o(139708);
                    throw tVar;
                } else if (!((Activity) context).isFinishing()) {
                    Dialog dialog = this.mLH;
                    if (dialog == null) {
                        p.btv("mBottomSheetDialog");
                    }
                    dialog.dismiss();
                }
            }
        }
        this.cJc.getRuntime().a(this.mLV);
        AppMethodBeat.o(139708);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$Companion;", "", "()V", "TAG", "", "TYPE_DEVICE", "", "TYPE_RECENT_TITLE", "TYPE_SEARCH_TITLE", "luggage-xweb-ext_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static final /* synthetic */ boolean b(g gVar) {
        AppMethodBeat.i(139711);
        if (!gVar.mLW.mMV.isEmpty()) {
            AppMethodBeat.o(139711);
            return true;
        }
        AppMethodBeat.o(139711);
        return false;
    }
}
