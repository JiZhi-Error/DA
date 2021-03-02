package com.tencent.mm.view;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.map.geolocation.sapp.TencentLocation;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\u0016\u0018\u0000 k*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0004klmnB\u000f\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tB!\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010X\u001a\u0004\u0018\u00010Y2\u0006\u0010Z\u001a\u00020\u000bJ\u0010\u0010[\u001a\u0002062\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\\\u001a\u0002002\u0006\u0010]\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u000200H\u0016J\b\u0010a\u001a\u00020bH\u0014J\b\u0010c\u001a\u00020bH\u0014J\b\u0010d\u001a\u00020bH\u0016J\u0018\u0010e\u001a\u00020b2\u0006\u0010Z\u001a\u00020\u000b2\b\b\u0002\u0010f\u001a\u000200J\u000e\u0010g\u001a\u00020b2\u0006\u0010L\u001a\u00020MJ\u0018\u0010h\u001a\u00020b2\u0006\u0010Z\u001a\u00020\u000b2\b\b\u0002\u0010f\u001a\u000200J\b\u0010i\u001a\u00020bH\u0016J\b\u0010j\u001a\u00020bH\u0016R4\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u000e\u0010-\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010.\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\"R$\u00101\u001a\u0002002\u0006\u0010\r\u001a\u000200@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0011\u00105\u001a\u000206¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0011\u0010?\u001a\u00020@¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010C\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u001a\u0010L\u001a\u00020MX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR(\u0010S\u001a\u0004\u0018\u00010R2\b\u0010\r\u001a\u0004\u0018\u00010R@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010W¨\u0006o"}, hxF = {"Lcom/tencent/mm/view/MediaBanner;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Landroid/support/v7/widget/RecyclerView$Adapter;", "adapter", "getAdapter", "()Landroid/support/v7/widget/RecyclerView$Adapter;", "setAdapter", "(Landroid/support/v7/widget/RecyclerView$Adapter;)V", "container", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", "container$delegate", "Lkotlin/Lazy;", "dataObserver", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "getDataObserver", "()Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "setDataObserver", "(Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;)V", "focusPosition", "getFocusPosition", "()I", "setFocusPosition", "(I)V", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "indicator", "Lcom/tencent/mm/view/IMediaBannerIndicator;", "getIndicator", "()Lcom/tencent/mm/view/IMediaBannerIndicator;", "setIndicator", "(Lcom/tencent/mm/view/IMediaBannerIndicator;)V", "indicatorBottomMargin", "indicatorHeight", "getIndicatorHeight", "", "isAutoPlay", "()Z", "setAutoPlay", "(Z)V", "manager", "Landroid/support/v7/widget/LinearLayoutManager;", "getManager", "()Landroid/support/v7/widget/LinearLayoutManager;", "pageChangeCallback", "Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "getPageChangeCallback", "()Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "setPageChangeCallback", "(Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;)V", "pagerView", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "getPagerView", "()Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "pagerViewContainer", "getPagerViewContainer", "()Landroid/widget/FrameLayout;", "parentRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getParentRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setParentRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/tencent/mm/view/MediaBanner$Style;", "getStyle", "()Lcom/tencent/mm/view/MediaBanner$Style;", "setStyle", "(Lcom/tencent/mm/view/MediaBanner$Style;)V", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "viewPool", "getViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "setViewPool", "(Landroid/support/v7/widget/RecyclerView$RecycledViewPool;)V", "getChildViewAt", "Landroid/view/View;", "position", "getLinearLayoutManager", "isInterceptTouch", TencentLocation.EXTRA_DIRECTION, "event", "Landroid/view/MotionEvent;", "isSuperIntercept", "onAttachedToWindow", "", "onDetachedFromWindow", "pauseLoopPlay", "selectViewAt", "isAuto", "setIndicatorStyle", "smoothScrollTo", "startLoopPlay", "stopLoopPlay", "Companion", "ILayoutManagerScrollEnableCallback", "IPageChangeCallback", "Style", "libmmui_release"})
public class MediaBanner<VH extends RecyclerView.v> extends FrameLayout {
    public static final a RjN = new a((byte) 0);
    private final int RjB = ((int) getResources().getDimension(R.dimen.ce));
    private d RjC = d.BOTTOM;
    private c RjD;
    private final LinearLayoutManager RjE;
    private h RjF;
    private int RjG;
    private RecyclerView RjH;
    private RecyclerView.c RjI;
    private final RecyclerHorizontalViewPager RjJ;
    private final FrameLayout RjK;
    private RecyclerView.m RjL;
    private final kotlin.f RjM;
    final MMHandler handler;
    private RecyclerView.a<VH> hbg;
    public boolean isAutoPlay;
    private final int oYw = ((int) getResources().getDimension(R.dimen.ct));

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/view/MediaBanner$ILayoutManagerScrollEnableCallback;", "", "setScrollVerticallyEnable", "", "enable", "", "libmmui_release"})
    public interface b {
        void pc(boolean z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, hxF = {"Lcom/tencent/mm/view/MediaBanner$IPageChangeCallback;", "", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "libmmui_release"})
    public interface c {
        void e(int i2, boolean z, boolean z2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/view/MediaBanner$Style;", "", "(Ljava/lang/String;I)V", "BOTTOM", "INSIDE", "NONE", "libmmui_release"})
    public enum d {
        BOTTOM,
        INSIDE,
        NONE;

        static {
            AppMethodBeat.i(164539);
            AppMethodBeat.o(164539);
        }

        public static d valueOf(String str) {
            AppMethodBeat.i(164541);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(164541);
            return dVar;
        }
    }

    static {
        AppMethodBeat.i(164547);
        AppMethodBeat.o(164547);
    }

    public final LinearLayout getContainer() {
        AppMethodBeat.i(164550);
        LinearLayout linearLayout = (LinearLayout) this.RjM.getValue();
        AppMethodBeat.o(164550);
        return linearLayout;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/view/MediaBanner$Companion;", "", "()V", "IMAGE_LOOP_INTERVAL", "", "IMAGE_LOOP_PAUSE_INTERVAL", "SCROLL_TO_NEXT_IMG_WHAT", "", "TAG", "", "libmmui_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(164553);
        Context context2 = getContext();
        p.g(context2, "context");
        this.RjE = fF(context2);
        Context context3 = getContext();
        p.g(context3, "context");
        this.RjF = new MediaBannerIndicator(context3);
        this.RjI = new f(this);
        Context context4 = getContext();
        p.g(context4, "context");
        this.RjJ = new h(this, context4);
        this.RjK = new FrameLayout(getContext());
        this.RjM = kotlin.g.ah(new e(this));
        this.RjJ.setHasFixedSize(false);
        this.RjE.ca(3);
        this.RjE.setItemPrefetchEnabled(true);
        this.RjE.setOrientation(0);
        this.RjJ.setLayoutManager(this.RjE);
        this.RjK.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LinearLayout container = getContainer();
        if (container != null) {
            container.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        }
        setIndicatorStyle(this.RjC);
        this.RjJ.setOnInterceptTouchEvent(new RecyclerHorizontalViewPager.c(this) {
            /* class com.tencent.mm.view.MediaBanner.AnonymousClass1 */
            final /* synthetic */ MediaBanner RjO;
            private float aTD;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.RjO = r1;
            }

            @Override // com.tencent.mm.view.RecyclerHorizontalViewPager.c
            public final void n(MotionEvent motionEvent) {
                RecyclerView.LayoutManager layoutManager;
                RecyclerView.LayoutManager layoutManager2;
                boolean z;
                AppMethodBeat.i(204957);
                p.h(motionEvent, "event");
                if (motionEvent.getAction() == 1) {
                    MediaBanner mediaBanner = this.RjO;
                    if (mediaBanner.isAutoPlay) {
                        mediaBanner.handler.removeMessages(1);
                        mediaBanner.handler.sendEmptyMessageDelayed(1, 2000);
                    }
                }
                RecyclerView parentRecyclerView = this.RjO.getParentRecyclerView();
                if (parentRecyclerView != null) {
                    layoutManager = parentRecyclerView.getLayoutManager();
                } else {
                    layoutManager = null;
                }
                if ((layoutManager instanceof b) && (layoutManager2 = this.RjO.getPagerView().getLayoutManager()) != null) {
                    if (!(layoutManager2 instanceof LinearLayoutManager) || ((LinearLayoutManager) layoutManager2).getItemCount() <= 1) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        layoutManager2 = null;
                    }
                    if (layoutManager2 != null) {
                        if (layoutManager2 == null) {
                            t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                            AppMethodBeat.o(204957);
                            throw tVar;
                        }
                        if (motionEvent.getAction() == 0) {
                            this.aTD = motionEvent.getRawX();
                        } else if (motionEvent.getAction() == 2 && Math.abs(motionEvent.getRawX() - this.aTD) >= 10.0f) {
                            ((b) layoutManager).pc(false);
                        }
                        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            ((b) layoutManager).pc(true);
                        }
                        AppMethodBeat.o(204957);
                        return;
                    }
                }
                AppMethodBeat.o(204957);
            }

            @Override // com.tencent.mm.view.RecyclerHorizontalViewPager.c
            public final boolean b(MotionEvent motionEvent, boolean z) {
                AppMethodBeat.i(204958);
                p.h(motionEvent, "event");
                boolean d2 = MediaBanner.d(motionEvent, z);
                AppMethodBeat.o(204958);
                return d2;
            }
        });
        this.handler = new MMHandler(Looper.getMainLooper(), new g(this));
        AppMethodBeat.o(164553);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaBanner(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(164554);
        Context context2 = getContext();
        p.g(context2, "context");
        this.RjE = fF(context2);
        Context context3 = getContext();
        p.g(context3, "context");
        this.RjF = new MediaBannerIndicator(context3);
        this.RjI = new f(this);
        Context context4 = getContext();
        p.g(context4, "context");
        this.RjJ = new h(this, context4);
        this.RjK = new FrameLayout(getContext());
        this.RjM = kotlin.g.ah(new e(this));
        this.RjJ.setHasFixedSize(false);
        this.RjE.ca(3);
        this.RjE.setItemPrefetchEnabled(true);
        this.RjE.setOrientation(0);
        this.RjJ.setLayoutManager(this.RjE);
        this.RjK.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        LinearLayout container = getContainer();
        if (container != null) {
            container.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        }
        setIndicatorStyle(this.RjC);
        this.RjJ.setOnInterceptTouchEvent(new RecyclerHorizontalViewPager.c(this) {
            /* class com.tencent.mm.view.MediaBanner.AnonymousClass1 */
            final /* synthetic */ MediaBanner RjO;
            private float aTD;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.RjO = r1;
            }

            @Override // com.tencent.mm.view.RecyclerHorizontalViewPager.c
            public final void n(MotionEvent motionEvent) {
                RecyclerView.LayoutManager layoutManager;
                RecyclerView.LayoutManager layoutManager2;
                boolean z;
                AppMethodBeat.i(204957);
                p.h(motionEvent, "event");
                if (motionEvent.getAction() == 1) {
                    MediaBanner mediaBanner = this.RjO;
                    if (mediaBanner.isAutoPlay) {
                        mediaBanner.handler.removeMessages(1);
                        mediaBanner.handler.sendEmptyMessageDelayed(1, 2000);
                    }
                }
                RecyclerView parentRecyclerView = this.RjO.getParentRecyclerView();
                if (parentRecyclerView != null) {
                    layoutManager = parentRecyclerView.getLayoutManager();
                } else {
                    layoutManager = null;
                }
                if ((layoutManager instanceof b) && (layoutManager2 = this.RjO.getPagerView().getLayoutManager()) != null) {
                    if (!(layoutManager2 instanceof LinearLayoutManager) || ((LinearLayoutManager) layoutManager2).getItemCount() <= 1) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (!z) {
                        layoutManager2 = null;
                    }
                    if (layoutManager2 != null) {
                        if (layoutManager2 == null) {
                            t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
                            AppMethodBeat.o(204957);
                            throw tVar;
                        }
                        if (motionEvent.getAction() == 0) {
                            this.aTD = motionEvent.getRawX();
                        } else if (motionEvent.getAction() == 2 && Math.abs(motionEvent.getRawX() - this.aTD) >= 10.0f) {
                            ((b) layoutManager).pc(false);
                        }
                        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                            ((b) layoutManager).pc(true);
                        }
                        AppMethodBeat.o(204957);
                        return;
                    }
                }
                AppMethodBeat.o(204957);
            }

            @Override // com.tencent.mm.view.RecyclerHorizontalViewPager.c
            public final boolean b(MotionEvent motionEvent, boolean z) {
                AppMethodBeat.i(204958);
                p.h(motionEvent, "event");
                boolean d2 = MediaBanner.d(motionEvent, z);
                AppMethodBeat.o(204958);
                return d2;
            }
        });
        this.handler = new MMHandler(Looper.getMainLooper(), new g(this));
        AppMethodBeat.o(164554);
    }

    public final int getIndicatorHeight() {
        return this.RjB;
    }

    public final d getStyle() {
        return this.RjC;
    }

    public final void setStyle(d dVar) {
        AppMethodBeat.i(164548);
        p.h(dVar, "<set-?>");
        this.RjC = dVar;
        AppMethodBeat.o(164548);
    }

    public final c getPageChangeCallback() {
        return this.RjD;
    }

    public final void setPageChangeCallback(c cVar) {
        this.RjD = cVar;
    }

    public final LinearLayoutManager getManager() {
        return this.RjE;
    }

    public final h getIndicator() {
        return this.RjF;
    }

    public final void setIndicator(h hVar) {
        AppMethodBeat.i(204966);
        p.h(hVar, "<set-?>");
        this.RjF = hVar;
        AppMethodBeat.o(204966);
    }

    public final int getFocusPosition() {
        return this.RjG;
    }

    public final void setFocusPosition(int i2) {
        this.RjG = i2;
    }

    public final RecyclerView getParentRecyclerView() {
        return this.RjH;
    }

    public final void setParentRecyclerView(RecyclerView recyclerView) {
        this.RjH = recyclerView;
    }

    public LinearLayoutManager fF(Context context) {
        AppMethodBeat.i(204967);
        p.h(context, "context");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager();
        AppMethodBeat.o(204967);
        return linearLayoutManager;
    }

    public final void setAutoPlay(boolean z) {
        AppMethodBeat.i(204968);
        this.isAutoPlay = z;
        if (z) {
            dGY();
            AppMethodBeat.o(204968);
            return;
        }
        dGZ();
        AppMethodBeat.o(204968);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/view/MediaBanner$dataObserver$1", "Landroid/support/v7/widget/RecyclerView$AdapterDataObserver;", "onChanged", "", "onItemRangeInserted", "positionStart", "", "itemCount", "onItemRangeRemoved", "libmmui_release"})
    public static final class f extends RecyclerView.c {
        final /* synthetic */ MediaBanner RjO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(MediaBanner mediaBanner) {
            this.RjO = mediaBanner;
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onChanged() {
            AppMethodBeat.i(204960);
            super.onChanged();
            RecyclerView.a<VH> adapter = this.RjO.getAdapter();
            if (adapter != null) {
                this.RjO.getIndicator().setCount(adapter.getItemCount());
                if (this.RjO.getIndicator().getCount() > 0) {
                    RecyclerHorizontalViewPager pagerView = this.RjO.getPagerView();
                    com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                    com.tencent.mm.hellhoundlib.a.a.a(pagerView, a2.axQ(), "com/tencent/mm/view/MediaBanner$dataObserver$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
                    pagerView.scrollToPosition(((Integer) a2.pG(0)).intValue());
                    com.tencent.mm.hellhoundlib.a.a.a(pagerView, "com/tencent/mm/view/MediaBanner$dataObserver$1", "onChanged", "()V", "Undefined", "scrollToPosition", "(I)V");
                }
                AppMethodBeat.o(204960);
                return;
            }
            AppMethodBeat.o(204960);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeInserted(int i2, int i3) {
            AppMethodBeat.i(204961);
            super.onItemRangeInserted(i2, i3);
            RecyclerView.a<VH> adapter = this.RjO.getAdapter();
            if (adapter != null) {
                this.RjO.getIndicator().setCount(adapter.getItemCount());
                AppMethodBeat.o(204961);
                return;
            }
            AppMethodBeat.o(204961);
        }

        @Override // android.support.v7.widget.RecyclerView.c
        public final void onItemRangeRemoved(int i2, int i3) {
            AppMethodBeat.i(204962);
            super.onItemRangeRemoved(i2, i3);
            RecyclerView.a<VH> adapter = this.RjO.getAdapter();
            if (adapter != null) {
                this.RjO.getIndicator().setCount(adapter.getItemCount());
                AppMethodBeat.o(204962);
                return;
            }
            AppMethodBeat.o(204962);
        }
    }

    public final RecyclerView.c getDataObserver() {
        return this.RjI;
    }

    public final void setDataObserver(RecyclerView.c cVar) {
        AppMethodBeat.i(204969);
        p.h(cVar, "<set-?>");
        this.RjI = cVar;
        AppMethodBeat.o(204969);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/view/MediaBanner$pagerView$1", "Lcom/tencent/mm/view/RecyclerHorizontalViewPager;", "onPageChange", "", "position", "", "isIdle", "", "isAuto", "libmmui_release"})
    public static final class h extends RecyclerHorizontalViewPager {
        final /* synthetic */ MediaBanner RjO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(MediaBanner mediaBanner, Context context) {
            super(context);
            this.RjO = mediaBanner;
        }

        @Override // com.tencent.mm.view.RecyclerHorizontalViewPager
        public final void e(int i2, boolean z, boolean z2) {
            AppMethodBeat.i(204965);
            super.e(i2, z, z2);
            this.RjO.setFocusPosition(i2);
            this.RjO.getIndicator().setCurrentIndex(i2);
            c pageChangeCallback = this.RjO.getPageChangeCallback();
            if (pageChangeCallback != null) {
                pageChangeCallback.e(i2, z, z2);
                AppMethodBeat.o(204965);
                return;
            }
            AppMethodBeat.o(204965);
        }
    }

    public final RecyclerHorizontalViewPager getPagerView() {
        return this.RjJ;
    }

    public final FrameLayout getPagerViewContainer() {
        return this.RjK;
    }

    public final RecyclerView.m getViewPool() {
        return this.RjL;
    }

    public final void setViewPool(RecyclerView.m mVar) {
        AppMethodBeat.i(164549);
        this.RjL = mVar;
        this.RjJ.setRecycledViewPool(mVar);
        AppMethodBeat.o(164549);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final void setIndicatorStyle(d dVar) {
        AppMethodBeat.i(204970);
        p.h(dVar, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
        this.RjC = dVar;
        switch (k.$EnumSwitchMapping$0[dVar.ordinal()]) {
            case 1:
                this.RjK.removeView(this.RjF.getView());
                LinearLayout container = getContainer();
                if (container != null) {
                    container.removeView(this.RjF.getView());
                }
                removeView(this.RjF.getView());
                AppMethodBeat.o(204970);
                return;
            case 2:
                LinearLayout container2 = getContainer();
                if (container2 != null) {
                    container2.setOrientation(1);
                    container2.setGravity(49);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 17;
                    this.RjK.addView(this.RjJ, layoutParams);
                    container2.addView(this.RjK, new LinearLayout.LayoutParams(-1, -2));
                    View view = this.RjF.getView();
                    if (view instanceof LinearLayout) {
                        ((LinearLayout) view).setGravity(17);
                    }
                    container2.addView(this.RjF.getView(), new LinearLayout.LayoutParams(-1, this.RjB));
                    container2.setGravity(17);
                    addView(container2, new FrameLayout.LayoutParams(-1, -1));
                    AppMethodBeat.o(204970);
                    return;
                }
                AppMethodBeat.o(204970);
                return;
            case 3:
                this.RjK.addView(this.RjJ);
                addView(this.RjK, new FrameLayout.LayoutParams(-1, -1));
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, this.RjB);
                layoutParams2.bottomMargin = this.oYw;
                layoutParams2.gravity = 81;
                View view2 = this.RjF.getView();
                if (view2 instanceof LinearLayout) {
                    ((LinearLayout) view2).setGravity(81);
                }
                addView(this.RjF.getView(), layoutParams2);
                break;
        }
        AppMethodBeat.o(204970);
    }

    public static boolean d(MotionEvent motionEvent, boolean z) {
        AppMethodBeat.i(164551);
        p.h(motionEvent, "event");
        AppMethodBeat.o(164551);
        return z;
    }

    public static /* synthetic */ void a(MediaBanner mediaBanner, int i2) {
        AppMethodBeat.i(204972);
        mediaBanner.bV(i2, false);
        AppMethodBeat.o(204972);
    }

    public final void bV(int i2, boolean z) {
        AppMethodBeat.i(204971);
        RecyclerHorizontalViewPager recyclerHorizontalViewPager = this.RjJ;
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerHorizontalViewPager, a2.axQ(), "com/tencent/mm/view/MediaBanner", "selectViewAt", "(IZ)V", "Undefined", "scrollToPosition", "(I)V");
        recyclerHorizontalViewPager.scrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerHorizontalViewPager, "com/tencent/mm/view/MediaBanner", "selectViewAt", "(IZ)V", "Undefined", "scrollToPosition", "(I)V");
        this.RjJ.e(i2, true, z);
        AppMethodBeat.o(204971);
    }

    public static /* synthetic */ void b(MediaBanner mediaBanner, int i2) {
        AppMethodBeat.i(204974);
        mediaBanner.bW(i2, false);
        AppMethodBeat.o(204974);
    }

    public final void bW(int i2, boolean z) {
        AppMethodBeat.i(204973);
        RecyclerHorizontalViewPager recyclerHorizontalViewPager = this.RjJ;
        com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(i2, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerHorizontalViewPager, a2.axQ(), "com/tencent/mm/view/MediaBanner", "smoothScrollTo", "(IZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
        recyclerHorizontalViewPager.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(recyclerHorizontalViewPager, "com/tencent/mm/view/MediaBanner", "smoothScrollTo", "(IZ)V", "Undefined", "smoothScrollToPosition", "(I)V");
        this.RjJ.e(i2, true, z);
        AppMethodBeat.o(204973);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", LocaleUtil.ITALIAN, "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
    static final class g implements MMHandler.Callback {
        final /* synthetic */ MediaBanner RjO;

        g(MediaBanner mediaBanner) {
            this.RjO = mediaBanner;
        }

        public final boolean handleMessage(Message message) {
            int i2;
            int i3;
            int i4 = 0;
            AppMethodBeat.i(204964);
            switch (message.what) {
                case 1:
                    RecyclerView.a<VH> adapter = this.RjO.getAdapter();
                    if (adapter != null) {
                        i2 = adapter.getItemCount();
                    } else {
                        i2 = 0;
                    }
                    if (i2 > 1) {
                        int focusPosition = this.RjO.getFocusPosition() + 1;
                        RecyclerView.a<VH> adapter2 = this.RjO.getAdapter();
                        if (adapter2 != null) {
                            i3 = adapter2.getItemCount();
                        } else {
                            i3 = 0;
                        }
                        if (focusPosition >= i3) {
                            RecyclerView.a<VH> adapter3 = this.RjO.getAdapter();
                            if (adapter3 != null) {
                                i4 = adapter3.getItemCount();
                            }
                            if (focusPosition == i4) {
                                final RecyclerView.a<VH> adapter4 = this.RjO.getAdapter();
                                if (adapter4 instanceof com.tencent.mm.ui.base.a.a) {
                                    try {
                                        adapter4.b(this.RjO.getDataObserver());
                                    } catch (Exception e2) {
                                    }
                                    ((com.tencent.mm.ui.base.a.a) adapter4).alC(((com.tencent.mm.ui.base.a.a) adapter4).getItemCount());
                                    this.RjO.getPagerView().setItemAnimator(null);
                                    MediaBanner.b(this.RjO, focusPosition);
                                    this.RjO.postDelayed(new Runnable(this) {
                                        /* class com.tencent.mm.view.MediaBanner.g.AnonymousClass1 */
                                        final /* synthetic */ g RjT;

                                        {
                                            this.RjT = r1;
                                        }

                                        public final void run() {
                                            AppMethodBeat.i(204963);
                                            ((com.tencent.mm.ui.base.a.a) adapter4).removeItem(((com.tencent.mm.ui.base.a.a) adapter4).getItemCount() - 1);
                                            adapter4.a(this.RjT.RjO.getDataObserver());
                                            this.RjT.RjO.bV(0, true);
                                            this.RjT.RjO.dGY();
                                            AppMethodBeat.o(204963);
                                        }
                                    }, 500);
                                    break;
                                }
                            }
                        } else {
                            this.RjO.bW(focusPosition, true);
                            this.RjO.dGY();
                            break;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(204964);
            return true;
        }
    }

    public void dGY() {
        AppMethodBeat.i(204975);
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, 2500);
        AppMethodBeat.o(204975);
    }

    public void dGZ() {
        AppMethodBeat.i(204976);
        this.handler.removeMessages(1);
        AppMethodBeat.o(204976);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(204977);
        super.onAttachedToWindow();
        if (this.isAutoPlay) {
            dGY();
        }
        AppMethodBeat.o(204977);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(204978);
        super.onDetachedFromWindow();
        dGZ();
        AppMethodBeat.o(204978);
    }

    public final RecyclerView.a<VH> getAdapter() {
        return this.hbg;
    }

    public final void setAdapter(RecyclerView.a<VH> aVar) {
        AppMethodBeat.i(164552);
        this.hbg = aVar;
        this.RjJ.setAdapter(this.hbg);
        RecyclerView.a<VH> aVar2 = this.hbg;
        if (aVar2 != null) {
            aVar2.a(this.RjI);
            AppMethodBeat.o(164552);
            return;
        }
        AppMethodBeat.o(164552);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Landroid/widget/LinearLayout;", "VH", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "invoke"})
    static final class e extends q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ MediaBanner RjO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(MediaBanner mediaBanner) {
            super(0);
            this.RjO = mediaBanner;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(164545);
            if (this.RjO.getStyle() == d.BOTTOM) {
                LinearLayout linearLayout = new LinearLayout(this.RjO.getContext());
                AppMethodBeat.o(164545);
                return linearLayout;
            }
            AppMethodBeat.o(164545);
            return null;
        }
    }
}
