package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0016\u0018\u0000 ~2\u00020\u00012\u00020\u0002:\u0001~B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u000209H\u0016J\u0010\u0010@\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0017H\u0002J:\u0010A\u001a\u00020>2\u0006\u0010B\u001a\u00020\n2\u0006\u0010C\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u00152\b\b\u0002\u0010E\u001a\u00020F2\u000e\b\u0002\u0010G\u001a\b\u0012\u0004\u0012\u00020>0HH\u0002J\u0010\u0010I\u001a\u00020>2\u0006\u0010J\u001a\u00020\nH\u0002J*\u0010K\u001a\u00020>2\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\n2\b\b\u0002\u0010N\u001a\u00020\r2\u0006\u0010O\u001a\u00020\nH\u0002J\b\u0010P\u001a\u00020>H\u0002J\u0010\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\u0015H\u0002J\u0010\u0010S\u001a\u00020\u00152\u0006\u0010T\u001a\u00020\u0015H\u0002J\n\u0010U\u001a\u0004\u0018\u000109H\u0016J\u0010\u0010V\u001a\u00020\u00152\u0006\u0010B\u001a\u00020\nH\u0002J\u0018\u0010W\u001a\u00020>2\u0006\u0010T\u001a\u00020\u00152\u0006\u0010X\u001a\u00020\u0015H\u0002J\u0010\u0010Y\u001a\u00020>2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010Z\u001a\u00020>H\u0002J\u0018\u0010[\u001a\u00020>2\u0006\u0010?\u001a\u00020\u00172\u0006\u0010\\\u001a\u00020\nH\u0002J\b\u0010]\u001a\u00020>H\u0002J\u0010\u0010^\u001a\u00020\r2\u0006\u0010\\\u001a\u00020\nH\u0002J\u0010\u0010_\u001a\u00020>2\u0006\u0010?\u001a\u000209H\u0014J\u0012\u0010`\u001a\u00020\r2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\u0018\u0010c\u001a\u00020>2\u0006\u0010d\u001a\u00020\n2\u0006\u0010e\u001a\u00020\nH\u0014J\u0010\u0010f\u001a\u00020>2\u0006\u0010?\u001a\u000209H\u0014J\u0018\u0010g\u001a\u00020>2\u0006\u0010h\u001a\u00020\u00152\u0006\u0010i\u001a\u00020\rH\u0002J\u0018\u0010j\u001a\u00020>2\u0006\u0010?\u001a\u0002092\u0006\u0010\\\u001a\u00020\nH\u0014J\u0018\u0010j\u001a\u00020>2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010O\u001a\u00020\nH\u0002J\u0018\u0010k\u001a\u00020>2\u0006\u0010?\u001a\u0002092\u0006\u0010\\\u001a\u00020\nH\u0014J\u0010\u0010k\u001a\u00020>2\u0006\u0010\\\u001a\u00020\nH\u0002J\u0012\u0010l\u001a\u00020\r2\b\u0010a\u001a\u0004\u0018\u00010bH\u0016J\b\u0010m\u001a\u00020>H\u0002J\b\u0010n\u001a\u00020>H\u0016J\u0010\u0010o\u001a\u00020>2\u0006\u0010?\u001a\u000209H\u0016J\u0010\u0010p\u001a\u00020>2\u0006\u0010?\u001a\u00020\u0017H\u0002J\b\u0010q\u001a\u00020>H\u0002J\u0010\u0010r\u001a\u00020>2\u0006\u0010s\u001a\u00020\rH\u0016J\u0010\u0010t\u001a\u00020>2\u0006\u0010u\u001a\u00020\rH\u0016J\u0010\u0010v\u001a\u00020>2\u0006\u0010w\u001a\u00020-H\u0016J\u0010\u0010x\u001a\u00020>2\u0006\u0010y\u001a\u00020)H\u0016J\u0010\u0010z\u001a\u00020>2\u0006\u0010{\u001a\u00020+H\u0016J\u0010\u0010|\u001a\u00020>2\u0006\u0010\\\u001a\u00020\nH\u0016J\u0018\u0010|\u001a\u00020>2\u0006\u0010\\\u001a\u00020\n2\u0006\u0010O\u001a\u00020\nH\u0016J\b\u0010}\u001a\u00020>H\u0002R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R6\u00104\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150605j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u001506`7X\u000e¢\u0006\u0002\n\u0000R\u001e\u00108\u001a\u0012\u0012\u0004\u0012\u00020905j\b\u0012\u0004\u0012\u000209`7X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTabView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "canScrollDefaultTab", "", "canVibrate", "getCanVibrate", "()Z", "setCanVibrate", "(Z)V", "container", "currentTranslationX", "", "dotView", "Landroid/view/View;", "dotViewWidth", "enableSwitchTab", "gestureDetector", "Landroid/view/GestureDetector;", "hasScrolledDefaultTab", "isFlingSwitchTab", "isScrollingX", "lastOffsetX", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mTouchDownSelectedIndex", "mTouching", "onTabClickListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnClickListener;", "onTabScrollListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "onTabSelectedListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "pendingSelectedIndex", "scrollInterpolator", "Landroid/view/animation/LinearInterpolator;", "scrollState", "selectedIndex", "tabTranslationInited", "tabTranslationXAreaList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "tabViewList", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "vibrator", "Landroid/os/Vibrator;", "viewWidth", "addTab", "", "tab", "addTabInternal", "animateScrollX", "targetIndex", "fromTransX", "toTransX", FFmpegMetadataRetriever.METADATA_KEY_DURATION, "", "onScrollEnd", "Lkotlin/Function0;", "changeScrollState", "state", "changeTab", "fromIndex", "toIndex", "needScrollAnimation", "tabSelectedAction", "computeTabTranslationXArea", "getIndexByTransX", "transX", "getMoveOffsetX", "offsetX", "getSelectedTab", "getTargetTransXByIndex", "handleScroll", "offsetY", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initDotView", "initTabClickListener", FirebaseAnalytics.b.INDEX, "initVibrator", "isIndexValid", "onAddTab", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRemoveTab", "onScrollX", "currentTransX", "isTouching", "onTabSelected", "onTabUnselected", "onTouchEvent", "onTouchUp", "removeAllTabs", "removeTab", "removeTabInternal", "scrollDefaultTab", "setEnableSwitchTab", "enable", "setEnabled", "enabled", "setOnTabChangedListener", "tabOnSelectedListener", "setOnTabClickListener", "tabOnClickListener", "setOnTabScrollListener", "tabOnScrollListener", "setSelectedTab", "vibrate", "Companion", "plugin-scan_release"})
public class BaseScrollTabView extends LinearLayout {
    public static final a CQY = new a((byte) 0);
    private float CBd;
    private float CBe;
    private float CBf;
    private VelocityTracker CBg;
    private boolean CJp;
    private View CQG;
    private ArrayList<a> CQH;
    private int CQI;
    private int CQJ;
    private boolean CQK;
    private boolean CQL;
    private LinearInterpolator CQM;
    private ArrayList<o<Float, Float>> CQN;
    private boolean CQO;
    private e CQP;
    private c CQQ;
    private d CQR;
    private float CQS;
    private float CQT;
    private int CQU;
    private boolean CQV;
    private boolean CQW;
    private boolean CQX;
    private int bxP;
    private int gRD;
    private GestureDetector jKk;
    private float onW;
    private Vibrator paT;
    private LinearLayout tmh;
    private int vp;

    static {
        AppMethodBeat.i(52371);
        AppMethodBeat.o(52371);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        public static final b CQZ = new b();

        static {
            AppMethodBeat.i(52340);
            AppMethodBeat.o(52340);
        }

        b() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public static final /* synthetic */ void a(BaseScrollTabView baseScrollTabView, float f2, boolean z) {
        AppMethodBeat.i(52373);
        baseScrollTabView.d(f2, z);
        AppMethodBeat.o(52373);
    }

    public static final /* synthetic */ void a(BaseScrollTabView baseScrollTabView, int i2, int i3) {
        AppMethodBeat.i(52372);
        baseScrollTabView.m28if(i2, i3);
        AppMethodBeat.o(52372);
    }

    public static final /* synthetic */ LinearLayout g(BaseScrollTabView baseScrollTabView) {
        AppMethodBeat.i(52374);
        LinearLayout linearLayout = baseScrollTabView.tmh;
        if (linearLayout == null) {
            p.btv("container");
        }
        AppMethodBeat.o(52374);
        return linearLayout;
    }

    public static final /* synthetic */ void h(BaseScrollTabView baseScrollTabView) {
        AppMethodBeat.i(52375);
        baseScrollTabView.WT(1);
        AppMethodBeat.o(52375);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$Companion;", "", "()V", "DEFAULT_SELECTED_INDEX", "", "MOVE_OFFSET_X_FACTOR", "", "SCROLL_ANIMATION_DURATION", "", "TAB_SELECTED_ACTION_BAR_CODE_TO_SCAN_GOODS", "TAB_SELECTED_ACTION_CLICK", "TAB_SELECTED_ACTION_DEFAULT", "TAB_SELECTED_ACTION_EXTERNAL_SCROLL", "TAB_SELECTED_ACTION_SCROLL", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final boolean getCanVibrate() {
        return this.CQX;
    }

    /* access modifiers changed from: protected */
    public final void setCanVibrate(boolean z) {
        this.CQX = z;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "plugin-scan_release"})
    public static final class f extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ BaseScrollTabView CRa;

        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(240634);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(240634);
            return onContextClick;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(240633);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(240633);
            return onDoubleTap;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(240632);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            super.onLongPress(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(240632);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(240631);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(240631);
            return onSingleTapUp;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(BaseScrollTabView baseScrollTabView) {
            this.CRa = baseScrollTabView;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            boolean z = true;
            AppMethodBeat.i(52344);
            Log.v("MicroMsg.BaseScrollTabView", "alvinluo onFling velocityX: %f, velocityY: %f, touchDownSelectedIndex: %d, selectedIndex: %d", Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(this.CRa.CQU), Integer.valueOf(this.CRa.bxP));
            if (this.CRa.CQU != this.CRa.bxP) {
                z = false;
            }
            if (Math.abs(f2) > Math.abs(f3) && z) {
                if (f2 <= -100.0f) {
                    int i2 = this.CRa.bxP + 1;
                    if (BaseScrollTabView.a(this.CRa, i2)) {
                        this.CRa.CQV = true;
                        this.CRa.ii(i2, 2);
                    }
                } else if (f2 >= 100.0f) {
                    int i3 = this.CRa.bxP - 1;
                    if (BaseScrollTabView.a(this.CRa, i3)) {
                        this.CRa.CQV = true;
                        this.CRa.ii(i3, 2);
                    }
                }
            }
            boolean onFling = super.onFling(motionEvent, motionEvent2, f2, f3);
            AppMethodBeat.o(52344);
            return onFling;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BaseScrollTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(52369);
        AppMethodBeat.o(52369);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseScrollTabView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Object systemService;
        p.h(context, "context");
        AppMethodBeat.i(52370);
        this.CJp = true;
        this.CQH = new ArrayList<>();
        this.bxP = -1;
        this.CQJ = -1;
        this.CQK = true;
        this.CQM = new LinearInterpolator();
        this.CQN = new ArrayList<>();
        this.vp = 1;
        this.CQU = -1;
        this.jKk = new GestureDetector(getContext(), new f(this));
        View inflate = LayoutInflater.from(context).inflate(R.layout.az9, (ViewGroup) this, true);
        View findViewById = inflate.findViewById(R.id.hco);
        p.g(findViewById, "view.findViewById(R.id.scroll_tab_container)");
        this.tmh = (LinearLayout) findViewById;
        View findViewById2 = inflate.findViewById(R.id.hcp);
        p.g(findViewById2, "view.findViewById(R.id.scroll_tab_dot)");
        this.CQG = findViewById2;
        this.CQI = getResources().getDimensionPixelSize(R.dimen.f3062g);
        if (this.paT == null && (systemService = getContext().getSystemService("vibrator")) != null) {
            this.paT = (Vibrator) systemService;
        }
        AppMethodBeat.o(52370);
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        AppMethodBeat.i(52346);
        p.h(aVar, "tab");
        AppMethodBeat.o(52346);
    }

    /* access modifiers changed from: protected */
    public void a(a aVar, int i2) {
        AppMethodBeat.i(52347);
        p.h(aVar, "tab");
        AppMethodBeat.o(52347);
    }

    /* access modifiers changed from: protected */
    public void b(a aVar, int i2) {
        AppMethodBeat.i(52348);
        p.h(aVar, "tab");
        AppMethodBeat.o(52348);
    }

    private final void cjJ() {
        Vibrator vibrator;
        AppMethodBeat.i(52349);
        if (!this.CQX || (vibrator = this.paT) == null) {
            AppMethodBeat.o(52349);
            return;
        }
        vibrator.vibrate(10);
        AppMethodBeat.o(52349);
    }

    public void setEnableSwitchTab(boolean z) {
        this.CJp = z;
    }

    public void setEnabled(boolean z) {
        AppMethodBeat.i(170043);
        super.setEnabled(z);
        Iterator<T> it = this.CQH.iterator();
        while (it.hasNext()) {
            it.next().setTabEnabled(z);
        }
        View view = this.CQG;
        if (view == null) {
            p.btv("dotView");
        }
        view.setEnabled(z);
        AppMethodBeat.o(170043);
    }

    public final void ii(int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(52350);
        Log.i("MicroMsg.BaseScrollTabView", "alvinluo setSelectedTab last: %d, selected: %d, isScrollingX: %b, tabTranslationInited: %b, tabSelectedAction: %d", Integer.valueOf(this.bxP), Integer.valueOf(i2), Boolean.valueOf(this.CQL), Boolean.valueOf(this.CQO), Integer.valueOf(i3));
        if (this.bxP == i2 || this.CQL) {
            AppMethodBeat.o(52350);
            return;
        }
        if (this.bxP != -1) {
            i4 = this.bxP;
        }
        if (this.CQO) {
            a(i4, i2, true, i3);
            AppMethodBeat.o(52350);
            return;
        }
        this.CQJ = i2;
        AppMethodBeat.o(52350);
    }

    public void setSelectedTab(int i2) {
        AppMethodBeat.i(52351);
        ii(i2, 0);
        AppMethodBeat.o(52351);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(52352);
        p.h(aVar, "tab");
        if (this.CQH.contains(aVar)) {
            Log.w("MicroMsg.BaseScrollTabView", "alvinluo addTab tab has been added and ignore, hashCode: %d", Integer.valueOf(aVar.hashCode()));
            AppMethodBeat.o(52352);
            return;
        }
        View view = (View) aVar;
        Log.v("MicroMsg.BaseScrollTabView", "alvinluo addTabInternal size: %d", Integer.valueOf(this.CQH.size()));
        view.setOnClickListener(new g(this, this.CQH.size(), view));
        this.CQH.add((a) view);
        LinearLayout linearLayout = this.tmh;
        if (linearLayout == null) {
            p.btv("container");
        }
        linearLayout.addView(view, new LinearLayout.LayoutParams(-2, -2));
        a((a) view);
        AppMethodBeat.o(52352);
    }

    public final void removeAllTabs() {
        AppMethodBeat.i(52353);
        Log.i("MicroMsg.BaseScrollTabView", "alvinluo removeAllTabs");
        for (T t : this.CQH) {
            if (t == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(52353);
                throw tVar;
            }
            T t2 = t;
            LinearLayout linearLayout = this.tmh;
            if (linearLayout == null) {
                p.btv("container");
            }
            linearLayout.removeView(t2);
        }
        this.CQH.clear();
        AppMethodBeat.o(52353);
    }

    public void setOnTabChangedListener(e eVar) {
        AppMethodBeat.i(52354);
        p.h(eVar, "tabOnSelectedListener");
        this.CQP = eVar;
        AppMethodBeat.o(52354);
    }

    public void setOnTabClickListener(c cVar) {
        AppMethodBeat.i(52355);
        p.h(cVar, "tabOnClickListener");
        this.CQQ = cVar;
        AppMethodBeat.o(52355);
    }

    public void setOnTabScrollListener(d dVar) {
        AppMethodBeat.i(52356);
        p.h(dVar, "tabOnScrollListener");
        this.CQR = dVar;
        AppMethodBeat.o(52356);
    }

    public a getSelectedTab() {
        AppMethodBeat.i(52357);
        if (this.bxP < 0 || this.bxP >= this.CQH.size()) {
            AppMethodBeat.o(52357);
            return null;
        }
        a aVar = this.CQH.get(this.bxP);
        AppMethodBeat.o(52357);
        return aVar;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(52358);
        this.gRD = com.tencent.mm.cb.a.jn(getContext());
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE), i3);
        if (getMeasuredWidth() != 0 && getMeasuredWidth() < this.gRD) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.gRD, 1073741824), i3);
        }
        if (getMeasuredWidth() != 0) {
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.gRD);
            View view = this.CQG;
            if (view == null) {
                p.btv("dotView");
            }
            objArr[1] = Integer.valueOf(view.getMeasuredWidth());
            Log.v("MicroMsg.BaseScrollTabView", "alvinluo initDotView viewWidth: %d, dotView width: %d", objArr);
            View view2 = this.CQG;
            if (view2 == null) {
                p.btv("dotView");
            }
            float f2 = ((float) this.gRD) / 2.0f;
            View view3 = this.CQG;
            if (view3 == null) {
                p.btv("dotView");
            }
            view2.setTranslationX(f2 - ((float) view3.getMeasuredWidth()));
            Log.v("MicroMsg.BaseScrollTabView", "alvinluo computeTabTranslationXArea");
            this.CQN.clear();
            float f3 = ((float) this.gRD) / 2.0f;
            int i4 = 0;
            int i5 = 0;
            for (T t : this.CQH) {
                int i6 = i4 + 1;
                if (i4 < 0) {
                    j.hxH();
                }
                T t2 = t;
                if (t2 == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.View");
                    AppMethodBeat.o(52358);
                    throw tVar;
                }
                T t3 = t2;
                float measuredWidth = (f3 - ((float) i5)) - ((float) t3.getMeasuredWidth());
                float f4 = f3 - ((float) i5);
                i5 += t3.getMeasuredWidth();
                this.CQN.add(new o<>(Float.valueOf(measuredWidth), Float.valueOf(f4)));
                Log.d("MicroMsg.BaseScrollTabView", "alvinluo computeTabTranslationXArea index: %d, start: %f, end: %f, tabWidth: %d, accumulativeWidth: %d", Integer.valueOf(i4), Float.valueOf(measuredWidth), Float.valueOf(f4), Integer.valueOf(t3.getMeasuredWidth()), Integer.valueOf(i5));
                i4 = i6;
            }
            this.CQO = true;
            a aVar = (a) j.kt(this.CQH);
            if (!(aVar == null || ((View) aVar).getMeasuredWidth() == 0)) {
                Log.v("MicroMsg.BaseScrollTabView", "alvinluo scrollDefaultTab selectedIndex: %d, pendingSelectedIndex: %d", Integer.valueOf(this.bxP), Integer.valueOf(this.CQJ));
                if (this.CQJ != -1) {
                    a(this.bxP, this.CQJ, false, 0);
                    this.CQJ = -1;
                    AppMethodBeat.o(52358);
                    return;
                } else if (this.bxP == -1 || this.bxP == 0) {
                    float WU = WU(0);
                    LinearLayout linearLayout = this.tmh;
                    if (linearLayout == null) {
                        p.btv("container");
                    }
                    linearLayout.setTranslationX(WU);
                    Log.v("MicroMsg.BaseScrollTabView", "alvinluo scrollDefaultTab set default tab %f", Float.valueOf(WU));
                    a(this.bxP, 0, false, 0);
                }
            }
        }
        AppMethodBeat.o(52358);
    }

    private final void a(int i2, int i3, boolean z, int i4) {
        AppMethodBeat.i(52359);
        if (i2 == i3) {
            AppMethodBeat.o(52359);
            return;
        }
        WS(i2);
        LinearLayout linearLayout = this.tmh;
        if (linearLayout == null) {
            p.btv("container");
        }
        float translationX = linearLayout.getTranslationX();
        float WU = WU(i3);
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        LinearLayout linearLayout2 = this.tmh;
        if (linearLayout2 == null) {
            p.btv("container");
        }
        objArr[2] = Float.valueOf(linearLayout2.getTranslationX());
        objArr[3] = Float.valueOf(WU);
        Log.d("MicroMsg.BaseScrollTabView", "alvinluo changeTab from: %d, to: %d, currentTransX: %f, targetTransX: %f", objArr);
        this.bxP = i3;
        if (z) {
            a(this, i3, translationX, WU, 0, new e(this, i3, i4), 8);
            AppMethodBeat.o(52359);
            return;
        }
        this.CQK = false;
        LinearLayout linearLayout3 = this.tmh;
        if (linearLayout3 == null) {
            p.btv("container");
        }
        linearLayout3.setTranslationX(WU);
        m28if(i3, i4);
        AppMethodBeat.o(52359);
    }

    /* renamed from: if  reason: not valid java name */
    private final void m28if(int i2, int i3) {
        AppMethodBeat.i(52360);
        a aVar = (a) j.L(this.CQH, i2);
        if (aVar != null) {
            a(aVar, i2);
            aVar.eRu();
            e eVar = this.CQP;
            if (eVar != null) {
                eVar.m30if(aVar.getTabId(), i3);
            }
            cjJ();
            AppMethodBeat.o(52360);
            return;
        }
        AppMethodBeat.o(52360);
    }

    private final void WS(int i2) {
        AppMethodBeat.i(52361);
        a aVar = (a) j.L(this.CQH, i2);
        if (aVar != null) {
            b(aVar, i2);
            aVar.eRv();
            e eVar = this.CQP;
            if (eVar != null) {
                eVar.WQ(aVar.getTabId());
                AppMethodBeat.o(52361);
                return;
            }
            AppMethodBeat.o(52361);
            return;
        }
        AppMethodBeat.o(52361);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g implements View.OnClickListener {
        final /* synthetic */ BaseScrollTabView CRa;
        final /* synthetic */ View CRg;
        final /* synthetic */ int puW;

        g(BaseScrollTabView baseScrollTabView, int i2, View view) {
            this.CRa = baseScrollTabView;
            this.puW = i2;
            this.CRg = view;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(52345);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$initTabClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!this.CRa.CJp) {
                Log.w("MicroMsg.BaseScrollTabView", "alvinluo onTabClick not enableSwitchTab");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$initTabClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(52345);
                return;
            }
            this.CRa.setCanVibrate(true);
            Log.i("MicroMsg.BaseScrollTabView", "alvinluo onTabClick index: %d", Integer.valueOf(this.puW));
            a aVar = (a) j.L(this.CRa.CQH, this.puW);
            if (aVar != null) {
                aVar.getTabId();
                c unused = this.CRa.CQQ;
            }
            this.CRa.ii(this.puW, 1);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$initTabClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(52345);
        }
    }

    private static /* synthetic */ void a(BaseScrollTabView baseScrollTabView, int i2, float f2, float f3, long j2, kotlin.g.a.a aVar, int i3) {
        long j3;
        AppMethodBeat.i(52363);
        if ((i3 & 8) != 0) {
            j3 = 150;
        } else {
            j3 = j2;
        }
        baseScrollTabView.a(i2, f2, f3, j3, (i3 & 16) != 0 ? b.CQZ : aVar);
        AppMethodBeat.o(52363);
    }

    private final void a(int i2, float f2, float f3, long j2, kotlin.g.a.a<x> aVar) {
        ViewPropertyAnimator interpolator;
        ViewPropertyAnimator translationX;
        ViewPropertyAnimator updateListener;
        ViewPropertyAnimator listener;
        ViewPropertyAnimator duration;
        AppMethodBeat.i(52362);
        if (this.CQL) {
            AppMethodBeat.o(52362);
            return;
        }
        Log.i("MicroMsg.BaseScrollTabView", "alvinluo animateScrollX targetIndex: %d, fromTransX: %f, toTransX: %f", Integer.valueOf(i2), Float.valueOf(f2), Float.valueOf(f3));
        this.CQL = true;
        LinearLayout linearLayout = this.tmh;
        if (linearLayout == null) {
            p.btv("container");
        }
        ViewPropertyAnimator animate = linearLayout.animate();
        if (animate == null || (interpolator = animate.setInterpolator(this.CQM)) == null || (translationX = interpolator.translationX(f3)) == null || (updateListener = translationX.setUpdateListener(new c(this, f2, f3))) == null || (listener = updateListener.setListener(new d(this, aVar))) == null || (duration = listener.setDuration(j2)) == null) {
            AppMethodBeat.o(52362);
            return;
        }
        duration.start();
        AppMethodBeat.o(52362);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ BaseScrollTabView CRa;
        final /* synthetic */ float CRb;
        final /* synthetic */ float CRc;

        c(BaseScrollTabView baseScrollTabView, float f2, float f3) {
            this.CRa = baseScrollTabView;
            this.CRb = f2;
            this.CRc = f3;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(52341);
            p.g(valueAnimator, "animation");
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(52341);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            BaseScrollTabView.a(this.CRa, (floatValue * (this.CRc - this.CRb)) + this.CRb, this.CRa.CQW);
            AppMethodBeat.o(52341);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$animateScrollX$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
    public static final class d implements Animator.AnimatorListener {
        final /* synthetic */ BaseScrollTabView CRa;
        final /* synthetic */ kotlin.g.a.a CRd;

        d(BaseScrollTabView baseScrollTabView, kotlin.g.a.a aVar) {
            this.CRa = baseScrollTabView;
            this.CRd = aVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(52342);
            this.CRd.invoke();
            this.CRa.CQJ = -1;
            this.CRa.CQL = false;
            Log.v("MicroMsg.BaseScrollTabView", "alvinluo animateScrollX onAnimationEnd %f", Float.valueOf(BaseScrollTabView.g(this.CRa).getTranslationX()));
            BaseScrollTabView.h(this.CRa);
            AppMethodBeat.o(52342);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(52364);
        Object[] objArr = new Object[1];
        objArr[0] = motionEvent != null ? Integer.valueOf(motionEvent.getAction()) : null;
        Log.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent %s", objArr);
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        if (onInterceptTouchEvent) {
            AppMethodBeat.o(52364);
            return onInterceptTouchEvent;
        } else if (!this.CJp) {
            boolean onInterceptTouchEvent2 = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(52364);
            return onInterceptTouchEvent2;
        } else if (motionEvent == null) {
            AppMethodBeat.o(52364);
            return false;
        } else {
            if (this.CBg == null) {
                this.CBg = VelocityTracker.obtain();
            }
            VelocityTracker velocityTracker = this.CBg;
            if (velocityTracker == null) {
                p.hyc();
            }
            velocityTracker.addMovement(motionEvent);
            VelocityTracker velocityTracker2 = this.CBg;
            if (velocityTracker2 == null) {
                p.hyc();
            }
            velocityTracker2.computeCurrentVelocity(1000);
            VelocityTracker velocityTracker3 = this.CBg;
            if (velocityTracker3 == null) {
                p.hyc();
            }
            int xVelocity = (int) velocityTracker3.getXVelocity();
            VelocityTracker velocityTracker4 = this.CBg;
            if (velocityTracker4 == null) {
                p.hyc();
            }
            int yVelocity = (int) velocityTracker4.getYVelocity();
            switch (motionEvent.getAction() & 255) {
                case 0:
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = Float.valueOf(motionEvent.getRawX());
                    objArr2[1] = Float.valueOf(motionEvent.getRawY());
                    LinearLayout linearLayout = this.tmh;
                    if (linearLayout == null) {
                        p.btv("container");
                    }
                    objArr2[2] = Float.valueOf(linearLayout.getTranslationX());
                    Log.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent down: %f, %f, currentTranslationX: %f", objArr2);
                    this.CBe = motionEvent.getRawX();
                    this.CBf = motionEvent.getRawY();
                    LinearLayout linearLayout2 = this.tmh;
                    if (linearLayout2 == null) {
                        p.btv("container");
                    }
                    this.CQS = linearLayout2.getTranslationX();
                    z = false;
                    break;
                case 1:
                    z = false;
                    break;
                case 2:
                    float rawX = motionEvent.getRawX() - this.CBe;
                    float rawY = motionEvent.getRawY() - this.CBf;
                    Log.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", Float.valueOf(rawX), Float.valueOf(rawY), Integer.valueOf(xVelocity), Integer.valueOf(yVelocity));
                    if (Math.abs(xVelocity) > Math.abs(yVelocity) && Math.abs(rawX) > Math.abs(rawY) && Math.abs(rawX) >= 5.0f) {
                        z = true;
                        break;
                    }
                default:
                    z = false;
                    break;
            }
            Log.v("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent action: %s, isIntercept: %b", Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(z));
            AppMethodBeat.o(52364);
            return z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01d7  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0208  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x035f  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0388  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x03af A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r15) {
        /*
        // Method dump skipped, instructions count: 1060
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.scanner.ui.widget.BaseScrollTabView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    private final void d(float f2, boolean z) {
        AppMethodBeat.i(52366);
        this.CQX = true;
        float WU = WU(this.bxP);
        d dVar = this.CQR;
        if (dVar != null) {
            dVar.u(this.bxP, f2 - WU);
        }
        if (z) {
            WT(2);
            AppMethodBeat.o(52366);
            return;
        }
        if (!z) {
            WT(3);
        }
        AppMethodBeat.o(52366);
    }

    private final void WT(int i2) {
        AppMethodBeat.i(52367);
        if (this.vp != i2) {
            Log.d("MicroMsg.BaseScrollTabView", "alvinluo changeScrollState state: %d", Integer.valueOf(i2));
            this.vp = i2;
            d dVar = this.CQR;
            if (dVar != null) {
                dVar.onScrollStateChanged(i2);
                AppMethodBeat.o(52367);
                return;
            }
        }
        AppMethodBeat.o(52367);
    }

    private final float WU(int i2) {
        AppMethodBeat.i(52368);
        o oVar = (o) j.L(this.CQN, i2);
        if (oVar != null) {
            float floatValue = (oVar.second.floatValue() + oVar.first.floatValue()) / 2.0f;
            AppMethodBeat.o(52368);
            return floatValue;
        }
        AppMethodBeat.o(52368);
        return 0.0f;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class e extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ BaseScrollTabView CRa;
        final /* synthetic */ int CRe;
        final /* synthetic */ int CRf;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(BaseScrollTabView baseScrollTabView, int i2, int i3) {
            super(0);
            this.CRa = baseScrollTabView;
            this.CRe = i2;
            this.CRf = i3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(52343);
            BaseScrollTabView.a(this.CRa, this.CRe, this.CRf);
            x xVar = x.SXb;
            AppMethodBeat.o(52343);
            return xVar;
        }
    }

    public static final /* synthetic */ boolean a(BaseScrollTabView baseScrollTabView, int i2) {
        AppMethodBeat.i(52376);
        if (i2 < 0 || i2 >= baseScrollTabView.CQH.size()) {
            AppMethodBeat.o(52376);
            return false;
        }
        AppMethodBeat.o(52376);
        return true;
    }
}
