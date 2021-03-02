package com.tencent.mm.plugin.whatsnew.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.mogic.WxViewPager;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002EFB%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\b\u0010*\u001a\u00020\u001bH\u0002J\u0006\u0010+\u001a\u00020\u001bJ\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020\u001bH\u0014J\b\u0010.\u001a\u00020\u001bH\u0016J\u0006\u0010/\u001a\u00020\u001bJ\u0018\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\tH\u0016J\u0018\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0016J\u0010\u00106\u001a\u00020\u001b2\u0006\u00107\u001a\u00020\tH\u0016J \u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\tH\u0016J\u0010\u0010=\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\tH\u0016J\u0018\u0010>\u001a\u00020\t2\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\tH\u0016J\b\u0010A\u001a\u00020\u001bH\u0016J\u0006\u0010B\u001a\u00020\u001bJ\u0006\u0010C\u001a\u00020\u001bJ\b\u0010D\u001a\u00020\u001bH\u0003R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000¨\u0006G"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewView;", "Landroid/widget/FrameLayout;", "Landroid/support/v4/view/ViewPager$OnPageChangeListener;", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animator", "Landroid/animation/ValueAnimator;", "bubblesView", "Lcom/tencent/mm/plugin/whatsnew/ui/BubblesView;", "content", "Landroid/view/ViewGroup;", "fallback", "Landroid/widget/ImageView;", "indicator", "Lcom/tencent/mm/plugin/whatsnew/ui/LegacyCircleIndicator;", "isVideoPrepared", "", "mask", "Landroid/view/View;", "onFinish", "Lkotlin/Function0;", "", "getOnFinish", "()Lkotlin/jvm/functions/Function0;", "setOnFinish", "(Lkotlin/jvm/functions/Function0;)V", "subtitlesView", "Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewSubtitlesView;", "videoFd", "Landroid/content/res/AssetFileDescriptor;", "videoView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoTextureView;", "viewPager", "Lcom/tencent/mm/ui/mogic/WxViewPager;", "animateToFinish", "animateToNext", "cancelAnimator", "fadeIn", "initVideoPlayer", "onAttachedToWindow", "onCompletion", "onDestroy", "onError", "what", "extra", "onGetVideoSize", "width", "height", "onPageScrollStateChanged", "state", "onPageScrolled", "position", "ratio", "", "pixels", "onPageSelected", "onPlayTime", "playTime", "videoTime", "onPrepared", "onStart", "onStop", "setupViews", "Companion", "HolderAdapter", "app_release"})
public final class WhatsNewView extends FrameLayout implements ViewPager.OnPageChangeListener, j.a {
    private static final int[] JPs = {R.raw.wsn_text_1, R.raw.wsn_text_2, R.raw.wsn_text_3, R.raw.wsn_text_4, R.raw.wsn_text_5};
    public static final a JPt = new a((byte) 0);
    private final ImageView JPj;
    private final VideoTextureView JPk;
    final View JPl;
    private final LegacyCircleIndicator JPm;
    private final WhatsNewSubtitlesView JPn;
    private final BubblesView JPo;
    private AssetFileDescriptor JPp;
    private boolean JPq;
    private kotlin.g.a.a<x> JPr;
    private ValueAnimator animator;
    final ViewGroup oeO;
    private final WxViewPager rnc;

    public WhatsNewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, (byte) 0);
    }

    public static final /* synthetic */ void b(WhatsNewView whatsNewView) {
        AppMethodBeat.i(231019);
        whatsNewView.glb();
        AppMethodBeat.o(231019);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WhatsNewView(Context context, AttributeSet attributeSet, int i2, byte b2) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, 0);
        AppMethodBeat.i(231017);
        AppMethodBeat.o(231017);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WhatsNewView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(231016);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        FrameLayout.inflate(context, R.layout.cce, this);
        View findViewById = findViewById(R.id.fa3);
        p.g(findViewById, "findViewById(R.id.mask)");
        this.JPl = findViewById;
        View findViewById2 = findViewById(R.id.be9);
        p.g(findViewById2, "findViewById(R.id.content)");
        this.oeO = (ViewGroup) findViewById2;
        View findViewById3 = findViewById(R.id.j7k);
        p.g(findViewById3, "findViewById(R.id.view_pager)");
        this.rnc = (WxViewPager) findViewById3;
        View findViewById4 = findViewById(R.id.dxu);
        p.g(findViewById4, "findViewById(R.id.indicator)");
        this.JPm = (LegacyCircleIndicator) findViewById4;
        View findViewById5 = findViewById(R.id.idu);
        p.g(findViewById5, "findViewById(R.id.subtitles)");
        this.JPn = (WhatsNewSubtitlesView) findViewById5;
        View findViewById6 = findViewById(R.id.afg);
        p.g(findViewById6, "findViewById(R.id.bubbles)");
        this.JPo = (BubblesView) findViewById6;
        View findViewById7 = findViewById(R.id.caz);
        p.g(findViewById7, "findViewById(R.id.fallback)");
        this.JPj = (ImageView) findViewById7;
        if (Build.VERSION.SDK_INT < 28) {
            this.JPk = new VideoTextureView(context);
            View findViewById8 = findViewById(R.id.j6z);
            p.g(findViewById8, "findViewById(R.id.video_view_container)");
            ((RelativeLayout) findViewById8).addView(this.JPk, new RelativeLayout.LayoutParams(-1, -1));
        } else {
            this.JPk = null;
        }
        gla();
        AppMethodBeat.o(231016);
    }

    public final kotlin.g.a.a<x> getOnFinish() {
        return this.JPr;
    }

    public final void setOnFinish(kotlin.g.a.a<x> aVar) {
        this.JPr = aVar;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void gla() {
        AppMethodBeat.i(231004);
        this.rnc.setAdapter(new b());
        this.JPm.setupViewPager(this.rnc);
        WhatsNewSubtitlesView whatsNewSubtitlesView = this.JPn;
        int[] iArr = JPs;
        p.h(iArr, "imageIds");
        whatsNewSubtitlesView.removeAllViews();
        for (int i2 : iArr) {
            WeImageView weImageView = new WeImageView(whatsNewSubtitlesView.getContext());
            weImageView.setImageResource(i2);
            weImageView.setIconColor(android.support.v4.content.b.n(whatsNewSubtitlesView.getContext(), R.color.BW_100_Alpha_0_6));
            weImageView.setVisibility(8);
            weImageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            whatsNewSubtitlesView.addView(weImageView);
        }
        View childAt = whatsNewSubtitlesView.getChildAt(0);
        p.g(childAt, "getChildAt(0)");
        childAt.setVisibility(0);
        ViewGroup.LayoutParams layoutParams = this.JPn.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(231004);
            throw tVar;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.topMargin = kotlin.h.a.K(((double) com.tencent.mm.cb.a.jo(getContext())) * 0.2d);
        layoutParams2.gravity = 1;
        layoutParams2.width = com.tencent.mm.cb.a.fromDPToPix(getContext(), 240);
        layoutParams2.height = com.tencent.mm.cb.a.fromDPToPix(getContext(), 160);
        if (com.tencent.mm.cb.a.E(getContext(), com.tencent.mm.cb.a.jn(getContext())) < 320) {
            layoutParams2.width = (int) (((float) layoutParams2.width) * 0.8f);
            layoutParams2.height = (int) (((float) layoutParams2.height) * 0.8f);
        }
        this.JPn.requestLayout();
        this.rnc.setOnTouchListener(new g(new android.support.v4.view.c(getContext(), new h(this))));
        this.rnc.setOnPageChangeListener(this);
        if (this.JPk != null) {
            Log.w("MicroMsg.WhatsNewView", "use video player view, sdk_int=" + Build.VERSION.SDK_INT);
            this.JPj.setVisibility(0);
            this.JPj.setImageResource(R.drawable.csp);
            this.JPk.setVisibility(0);
            VideoTextureView videoTextureView = this.JPk;
            try {
                Resources resources = getResources();
                p.g(resources, "resources");
                this.JPp = resources.getAssets().openFd("video/wsn_background.mp4");
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WhatsNewView", e2, "openFD error %s", e2.getMessage());
            }
            videoTextureView.setVideoCallback(this);
            AssetFileDescriptor assetFileDescriptor = this.JPp;
            if (assetFileDescriptor != null) {
                videoTextureView.a(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            }
            videoTextureView.setAlpha(0.0f);
            videoTextureView.setOneTimeVideoTextureUpdateCallback(new f(this, videoTextureView));
            videoTextureView.setMute(true);
            videoTextureView.setScaleType(i.e.COVER);
            AppMethodBeat.o(231004);
            return;
        }
        Log.w("MicroMsg.WhatsNewView", "use bubbles view, sdk_int=" + Build.VERSION.SDK_INT);
        this.JPo.setVisibility(0);
        AppMethodBeat.o(231004);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onSingleTapConfirmed", "", "e", "Landroid/view/MotionEvent;", "app_release"})
    public static final class h extends GestureDetector.SimpleOnGestureListener {
        final /* synthetic */ WhatsNewView JPu;

        public final boolean onContextClick(MotionEvent motionEvent) {
            AppMethodBeat.i(231003);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onContextClick = super.onContextClick(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(231003);
            return onContextClick;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(231002);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onDoubleTap = super.onDoubleTap(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(231002);
            return onDoubleTap;
        }

        public final void onLongPress(MotionEvent motionEvent) {
            AppMethodBeat.i(231001);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
            super.onLongPress(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
            AppMethodBeat.o(231001);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            AppMethodBeat.i(231000);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
            boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$setupViews$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(231000);
            return onSingleTapUp;
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(WhatsNewView whatsNewView) {
            this.JPu = whatsNewView;
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            AppMethodBeat.i(230999);
            if (this.JPu.rnc.getCurrentItem() >= WhatsNewView.JPs.length - 1) {
                WhatsNewView.b(this.JPu);
            } else {
                WhatsNewView.c(this.JPu);
            }
            AppMethodBeat.o(230999);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    public static final class g implements View.OnTouchListener {
        final /* synthetic */ android.support.v4.view.c JPx;

        g(android.support.v4.view.c cVar) {
            this.JPx = cVar;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(230998);
            this.JPx.onTouchEvent(motionEvent);
            AppMethodBeat.o(230998);
            return false;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i2, float f2, int i3) {
        AppMethodBeat.i(231005);
        Log.i("MicroMsg.WhatsNewView", "onPageScrolled: " + i2 + ", " + f2 + ", " + i3);
        this.JPm.onPageScrolled(i2, f2, i3);
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            if (i2 >= JPs.length - 1) {
                this.oeO.setTranslationX(((float) (-this.oeO.getWidth())) * f2);
                this.JPl.setAlpha(1.0f - f2);
            }
            this.JPn.y(i2, f2);
            AppMethodBeat.o(231005);
            return;
        }
        AppMethodBeat.o(231005);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i2) {
        AppMethodBeat.i(231006);
        Log.i("MicroMsg.WhatsNewView", "onPageSelected: ".concat(String.valueOf(i2)));
        this.JPm.onPageSelected(i2);
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            AppMethodBeat.o(231006);
        } else if (i2 >= JPs.length) {
            glb();
            AppMethodBeat.o(231006);
        } else {
            AppMethodBeat.o(231006);
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i2) {
        AppMethodBeat.i(231007);
        Log.i("MicroMsg.WhatsNewView", "onPageScrollStateChanged: ".concat(String.valueOf(i2)));
        this.JPm.onPageScrollStateChanged(i2);
        if (i2 == 1 && this.rnc.getCurrentItem() != JPs.length) {
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator == null) {
                AppMethodBeat.o(231007);
                return;
            } else if (valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.animator;
                if (valueAnimator2 != null) {
                    valueAnimator2.cancel();
                }
                WhatsNewSubtitlesView whatsNewSubtitlesView = this.JPn;
                int currentItem = this.rnc.getCurrentItem();
                com.tencent.e.f.h.ez("select ".concat(String.valueOf(currentItem)));
                kotlin.k.f mY = kotlin.k.j.mY(0, whatsNewSubtitlesView.getChildCount());
                ArrayList arrayList = new ArrayList(kotlin.a.j.a(mY, 10));
                Iterator it = mY.iterator();
                while (it.hasNext()) {
                    arrayList.add(whatsNewSubtitlesView.getChildAt(((ab) it).nextInt()));
                }
                int i3 = 0;
                for (Object obj : arrayList) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        kotlin.a.j.hxH();
                    }
                    View view = (View) obj;
                    if (i3 == currentItem) {
                        p.g(view, "childView");
                        view.setVisibility(0);
                        view.setAlpha(1.0f);
                        view.setTranslationX(0.0f);
                        i3 = i4;
                    } else {
                        p.g(view, "childView");
                        view.setVisibility(8);
                        i3 = i4;
                    }
                }
            }
        }
        AppMethodBeat.o(231007);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$animateToNext$1$1"})
    public static final class e implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ WhatsNewView JPu;
        final /* synthetic */ int JPw;

        e(WhatsNewView whatsNewView, int i2) {
            this.JPu = whatsNewView;
            this.JPw = i2;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(230996);
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(230996);
                throw tVar;
            }
            this.JPu.JPn.y(this.JPw, ((Float) animatedValue).floatValue());
            AppMethodBeat.o(230996);
        }
    }

    private final void glb() {
        AppMethodBeat.i(231008);
        Log.i("MicroMsg.WhatsNewView", "animateToFinish: current=" + this.rnc.getCurrentItem());
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        float abs = Math.abs(this.oeO.getTranslationX() / ((float) this.oeO.getWidth()));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(abs, 1.0f);
        ofFloat.addUpdateListener(new c(this, abs));
        ofFloat.setDuration((long) (500.0f * (1.0f - abs)));
        ofFloat.addListener(new d(this, abs));
        ofFloat.start();
        this.animator = ofFloat;
        AppMethodBeat.o(231008);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$animateToFinish$1$1"})
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ WhatsNewView JPu;
        final /* synthetic */ float JPv;

        c(WhatsNewView whatsNewView, float f2) {
            this.JPu = whatsNewView;
            this.JPv = f2;
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(230991);
            p.g(valueAnimator, LocaleUtil.ITALIAN);
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(230991);
                throw tVar;
            }
            float floatValue = ((Float) animatedValue).floatValue();
            this.JPu.oeO.setTranslationX(((float) (-this.JPu.oeO.getWidth())) * floatValue);
            this.JPu.JPl.setAlpha(1.0f - floatValue);
            AppMethodBeat.o(230991);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$animateToFinish$1$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_release"})
    public static final class d implements Animator.AnimatorListener {
        final /* synthetic */ WhatsNewView JPu;
        final /* synthetic */ float JPv;

        d(WhatsNewView whatsNewView, float f2) {
            this.JPu = whatsNewView;
            this.JPv = f2;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(230992);
            Log.w("MicroMsg.WhatsNewView", "animateToFinish: onAnimationStart");
            AppMethodBeat.o(230992);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(230993);
            Log.w("MicroMsg.WhatsNewView", "animateToFinish: onAnimationEnd");
            this.JPu.oeO.setAlpha(0.0f);
            this.JPu.JPl.setAlpha(0.0f);
            kotlin.g.a.a<x> onFinish = this.JPu.getOnFinish();
            if (onFinish != null) {
                onFinish.invoke();
                AppMethodBeat.o(230993);
                return;
            }
            AppMethodBeat.o(230993);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.i(230994);
            Log.w("MicroMsg.WhatsNewView", "animateToFinish: onAnimationCancel");
            AppMethodBeat.o(230994);
        }

        public final void onAnimationRepeat(Animator animator) {
            AppMethodBeat.i(230995);
            Log.w("MicroMsg.WhatsNewView", "animateToFinish: onAnimationRepeat");
            AppMethodBeat.o(230995);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTextureUpdate"})
    public static final class f implements j.e {
        final /* synthetic */ WhatsNewView JPu;
        final /* synthetic */ VideoTextureView VhX;

        f(WhatsNewView whatsNewView, VideoTextureView videoTextureView) {
            this.JPu = whatsNewView;
            this.VhX = videoTextureView;
        }

        @Override // com.tencent.mm.pluginsdk.ui.tools.j.e
        public final void bLh() {
            AppMethodBeat.i(230997);
            Log.i("MicroMsg.WhatsNewView", "on video rendered");
            this.VhX.setAlpha(1.0f);
            this.JPu.JPj.setAlpha(0.0f);
            AppMethodBeat.o(230997);
        }
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void onError(int i2, int i3) {
        AppMethodBeat.i(231009);
        Log.e("MicroMsg.WhatsNewView", "play video error! what: %d.", Integer.valueOf(i2));
        VideoTextureView videoTextureView = this.JPk;
        if (videoTextureView != null) {
            videoTextureView.setAlpha(0.0f);
        }
        this.JPj.setAlpha(1.0f);
        AppMethodBeat.o(231009);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void tf() {
        AppMethodBeat.i(231010);
        Log.i("MicroMsg.WhatsNewView", "onPrepared");
        VideoTextureView videoTextureView = this.JPk;
        if (videoTextureView != null) {
            videoTextureView.start();
        }
        this.JPq = true;
        AppMethodBeat.o(231010);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void onCompletion() {
        AppMethodBeat.i(231011);
        Log.w("MicroMsg.WhatsNewView", "on video completion");
        VideoTextureView videoTextureView = this.JPk;
        if (videoTextureView != null) {
            videoTextureView.q(0.0d);
            AppMethodBeat.o(231011);
            return;
        }
        AppMethodBeat.o(231011);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final int fh(int i2, int i3) {
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void eo(int i2, int i3) {
    }

    public final void onStart() {
        VideoTextureView videoTextureView;
        AppMethodBeat.i(231012);
        Log.i("MicroMsg.WhatsNewView", "onStart");
        if (this.JPq && (videoTextureView = this.JPk) != null) {
            videoTextureView.start();
        }
        this.JPo.JOz = SystemClock.uptimeMillis();
        AppMethodBeat.o(231012);
    }

    public final void onStop() {
        AppMethodBeat.i(231013);
        Log.i("MicroMsg.WhatsNewView", "onStop");
        VideoTextureView videoTextureView = this.JPk;
        if (videoTextureView != null) {
            videoTextureView.pause();
            AppMethodBeat.o(231013);
            return;
        }
        AppMethodBeat.o(231013);
    }

    public final void onDestroy() {
        AppMethodBeat.i(231014);
        Log.i("MicroMsg.WhatsNewView", "onDestroy");
        VideoTextureView videoTextureView = this.JPk;
        if (videoTextureView != null) {
            videoTextureView.stop();
        }
        try {
            AssetFileDescriptor assetFileDescriptor = this.JPp;
            if (assetFileDescriptor != null) {
                assetFileDescriptor.close();
                AppMethodBeat.o(231014);
                return;
            }
            AppMethodBeat.o(231014);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WhatsNewView", e2, "close loopVideoAssetFD error %s", e2.getMessage());
            AppMethodBeat.o(231014);
        }
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(231015);
        super.onAttachedToWindow();
        Log.w("MicroMsg.WhatsNewView", "onAttachedToWindow");
        this.JPo.JOz = SystemClock.uptimeMillis();
        AppMethodBeat.o(231015);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/whatsnew/ui/WhatsNewView$fadeIn$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "app_release"})
    public static final class i implements Animator.AnimatorListener {
        final /* synthetic */ WhatsNewView JPu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        i(WhatsNewView whatsNewView) {
            this.JPu = whatsNewView;
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(259061);
            this.JPu.JPl.setAlpha(1.0f);
            AppMethodBeat.o(259061);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewView$HolderAdapter;", "Landroid/support/v4/view/PagerAdapter;", "()V", "destroyItem", "", "container", "Landroid/view/ViewGroup;", "position", "", "obj", "", "getCount", "instantiateItem", "isViewFromObject", "", "view", "Landroid/view/View;", "app_release"})
    public static final class b extends q {
        @Override // android.support.v4.view.q
        public final int getCount() {
            AppMethodBeat.i(230987);
            int length = WhatsNewView.JPs.length + 1;
            AppMethodBeat.o(230987);
            return length;
        }

        @Override // android.support.v4.view.q
        public final boolean isViewFromObject(View view, Object obj) {
            AppMethodBeat.i(230988);
            p.h(view, "view");
            p.h(obj, "obj");
            if (view == obj) {
                AppMethodBeat.o(230988);
                return true;
            }
            AppMethodBeat.o(230988);
            return false;
        }

        @Override // android.support.v4.view.q
        public final Object instantiateItem(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(230989);
            p.h(viewGroup, "container");
            View view = new View(viewGroup.getContext());
            viewGroup.addView(view, new ViewGroup.LayoutParams(-1, -1));
            AppMethodBeat.o(230989);
            return view;
        }

        @Override // android.support.v4.view.q
        public final void destroyItem(ViewGroup viewGroup, int i2, Object obj) {
            AppMethodBeat.i(230990);
            p.h(viewGroup, "container");
            p.h(obj, "obj");
            viewGroup.removeView((View) obj);
            AppMethodBeat.o(230990);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/whatsnew/ui/WhatsNewView$Companion;", "", "()V", "SUBTITLES", "", "TAG", "", "VIDEO_FILE", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(231018);
        AppMethodBeat.o(231018);
    }

    public static final /* synthetic */ void c(WhatsNewView whatsNewView) {
        AppMethodBeat.i(231020);
        Log.i("MicroMsg.WhatsNewView", "animateToNext: current=" + whatsNewView.rnc.getCurrentItem());
        int currentItem = whatsNewView.rnc.getCurrentItem();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setInterpolator(new android.support.v4.view.b.b());
        ofFloat.addUpdateListener(new e(whatsNewView, currentItem));
        ofFloat.setDuration(700L);
        ofFloat.start();
        whatsNewView.animator = ofFloat;
        whatsNewView.rnc.setCurrentItem(currentItem + 1, false);
        AppMethodBeat.o(231020);
    }
}
