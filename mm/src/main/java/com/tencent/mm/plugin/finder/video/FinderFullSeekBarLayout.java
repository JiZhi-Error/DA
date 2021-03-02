package com.tencent.mm.plugin.finder.video;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.aj;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.action.j;
import com.tencent.mm.plugin.finder.video.q;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.ae;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b6\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u0000 ¤\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002¤\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bB\u001f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u0010[\u001a\u000205H\u0002J\b\u0010\\\u001a\u000205H\u0002J\b\u0010]\u001a\u000205H\u0016J\u0010\u0010^\u001a\u00020)2\u0006\u0010_\u001a\u00020`H\u0016J\b\u0010a\u001a\u000205H\u0016J\u0010\u0010b\u001a\u0002052\u0006\u0010c\u001a\u00020dH\u0016J\u0012\u0010e\u001a\u0004\u0018\u00010d2\u0006\u0010f\u001a\u00020\rH\u0002J\b\u0010g\u001a\u00020\rH\u0016J\b\u0010h\u001a\u00020iH\u0002J\b\u0010j\u001a\u000205H\u0002J\b\u0010k\u001a\u000205H\u0002J\b\u0010l\u001a\u000205H\u0002J\u0006\u0010m\u001a\u00020)J\u0006\u0010n\u001a\u00020\rJ\b\u0010o\u001a\u00020)H\u0016J\b\u0010p\u001a\u00020)H\u0016J\b\u0010q\u001a\u000205H\u0014J\u0012\u0010r\u001a\u00020)2\b\u0010s\u001a\u0004\u0018\u00010`H\u0016J\u0012\u0010t\u001a\u00020)2\b\u0010s\u001a\u0004\u0018\u00010`H\u0016J\u0010\u0010u\u001a\u00020)2\u0006\u0010s\u001a\u00020`H\u0016J(\u0010v\u001a\u00020)2\u0006\u0010w\u001a\u00020`2\u0006\u0010x\u001a\u00020`2\u0006\u0010y\u001a\u00020i2\u0006\u0010z\u001a\u00020iH\u0016J\u0010\u0010{\u001a\u00020)2\u0006\u0010|\u001a\u00020`H\u0016J\u0010\u0010}\u001a\u0002052\u0006\u0010s\u001a\u00020`H\u0016J!\u0010~\u001a\u0002052\u0006\u0010G\u001a\u00020H2\u0006\u0010\u001a\u00020\r2\u0007\u0010\u0001\u001a\u00020)H\u0016J+\u0010\u0001\u001a\u00020)2\u0006\u0010w\u001a\u00020`2\u0006\u0010x\u001a\u00020`2\u0007\u0010\u0001\u001a\u00020i2\u0007\u0010\u0001\u001a\u00020iH\u0016J\u0011\u0010\u0001\u001a\u0002052\u0006\u0010s\u001a\u00020`H\u0016J\u0011\u0010\u0001\u001a\u00020)2\u0006\u0010s\u001a\u00020`H\u0016J\u0011\u0010\u0001\u001a\u00020)2\u0006\u0010s\u001a\u00020`H\u0016J\u0011\u0010\u0001\u001a\u0002052\u0006\u0010G\u001a\u00020HH\u0016J\u0011\u0010\u0001\u001a\u0002052\u0006\u0010G\u001a\u00020HH\u0016J\u0012\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u00020)H\u0002J\u0012\u0010\u0001\u001a\u0002052\t\u0010\u0001\u001a\u0004\u0018\u00010'J\t\u0010\u0001\u001a\u000205H\u0002J\u0012\u0010\u0001\u001a\u0002052\t\u0010\u0001\u001a\u0004\u0018\u00010'J\u0010\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u00020)J\u0012\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u00020\rH\u0016J\u0012\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u00020MH\u0016J\t\u0010\u0001\u001a\u000205H\u0002J\t\u0010\u0001\u001a\u000205H\u0002J\u0012\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u00020)H\u0016J\t\u0010\u0001\u001a\u000205H\u0002J\u001a\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0012\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u00020\rH\u0002J&\u0010\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u00020i2\b\u0010\u0001\u001a\u00030 \u00012\b\u0010¡\u0001\u001a\u00030 \u0001H\u0016J#\u0010¢\u0001\u001a\u0002052\u0007\u0010\u0001\u001a\u00020i2\u0007\u0010\u0001\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0011\u0010£\u0001\u001a\u0002052\u0006\u0010\u000f\u001a\u00020\rH\u0002R\u000e\u0010\u000f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0017\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0015\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b \u0010!R\u001b\u0010#\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b$\u0010\u0013R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R \u0010*\u001a\b\u0012\u0004\u0012\u00020)0+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\u000e\u0010/\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u001b\u00101\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b3\u0010\u0015\u001a\u0004\b2\u0010\u001cR \u00104\u001a\b\u0012\u0004\u0012\u0002050+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010,\"\u0004\b7\u0010.R \u00108\u001a\b\u0012\u0004\u0012\u00020)0+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010,\"\u0004\b:\u0010.R \u0010;\u001a\b\u0012\u0004\u0012\u00020)0+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\u000e\u0010>\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\bA\u0010\u0015\u001a\u0004\b@\u0010!R\u001b\u0010B\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\bD\u0010\u0015\u001a\u0004\bC\u0010\u001cR\u000e\u0010E\u001a\u00020FX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010G\u001a\u00020H8BX\u0002¢\u0006\f\n\u0004\bK\u0010\u0015\u001a\u0004\bI\u0010JR\u0010\u0010L\u001a\u0004\u0018\u00010MX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u00020O8\u0002X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010P\u001a\u00020Q8BX\u0002¢\u0006\f\n\u0004\bT\u0010\u0015\u001a\u0004\bR\u0010SR\u000e\u0010U\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010V\u001a\u00020W8BX\u0002¢\u0006\f\n\u0004\bZ\u0010\u0015\u001a\u0004\bX\u0010Y¨\u0006¥\u0001"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "Landroid/view/GestureDetector$OnGestureListener;", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar;", "Landroid/view/GestureDetector$OnDoubleTapListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allSec", "allTimeLongTv", "Landroid/widget/TextView;", "getAllTimeLongTv", "()Landroid/widget/TextView;", "allTimeLongTv$delegate", "Lkotlin/Lazy;", "allTimeTv", "getAllTimeTv", "allTimeTv$delegate", "awesomeGroundLayout", "Landroid/view/View;", "getAwesomeGroundLayout", "()Landroid/view/View;", "awesomeGroundLayout$delegate", "awesomeIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getAwesomeIcon", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "awesomeIcon$delegate", "currentTimeTv", "getCurrentTimeTv", "currentTimeTv$delegate", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "ignoreThisEvent", "", "isPlayingCallback", "Lkotlin/Function0;", "()Lkotlin/jvm/functions/Function0;", "setPlayingCallback", "(Lkotlin/jvm/functions/Function0;)V", "isSeekBarTrackingTouch", "isSeekMode", "longVideoLayout", "getLongVideoLayout", "longVideoLayout$delegate", "onLongVideoBtnClickListener", "", "getOnLongVideoBtnClickListener", "setOnLongVideoBtnClickListener", "onPauseClickListener", "getOnPauseClickListener", "setOnPauseClickListener", "onPrivateLikeClickListener", "getOnPrivateLikeClickListener", "setOnPrivateLikeClickListener", "pauseClickByUser", "pauseIcon", "getPauseIcon", "pauseIcon$delegate", "pauseLayout", "getPauseLayout", "pauseLayout$delegate", "rect", "Landroid/graphics/Rect;", "seekBar", "Landroid/widget/SeekBar;", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBar$delegate", "seekBarCallback", "Lcom/tencent/mm/plugin/finder/video/IFinderVideoSeekBar$SeekBarCallback;", "seekBarTouchListener", "Landroid/view/View$OnTouchListener;", "seekLayout", "Landroid/view/ViewGroup;", "getSeekLayout", "()Landroid/view/ViewGroup;", "seekLayout$delegate", "setTmpMaxProgress", "touchDetector", "Landroid/view/GestureDetector;", "getTouchDetector", "()Landroid/view/GestureDetector;", "touchDetector$delegate", "checkShowGroupLikeTips", "dismissGroupLikeTips", "dismissProgressBar", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "enterSeekMode", "exitSeekMode", "reason", "", "formatSecToMin", "second", "getCurrentProgress", "getSeekPercent", "", "hideOtherView", "hidePauseIcon", "hideSeekLayout", "isInSeekMode", "isPauseIconStatus", "isSeekingMode", "isShownSeekBar", "onAttachedToWindow", "onDoubleTap", "e", "onDoubleTapEvent", "onDown", "onFling", "e1", "e2", "velocityX", "velocityY", "onInterceptTouchEvent", "ev", e.a.NAME, "onProgressChanged", "progress", "fromUser", "onScroll", "distanceX", "distanceY", "onShowPress", "onSingleTapConfirmed", "onSingleTapUp", "onStartTrackingTouch", "onStopTrackingTouch", "refreshAwesome", "isLike", "refreshFinderFeed", "item", "reportPauseClick", "setFinderFeed", "setPlaying", "isPlaying", "setProgress", "target", "setSeekBarCallback", "callback", "showOtherView", "showPauseIcon", "showProgressBar", "isShowThumb", "showSeekLayout", "updateAllTime", "offsetSec", "updateCurrentTime", "updateProgressMs", "percent", "offsetMs", "", "allMs", "updateProgressSec", "updateSeekTime", "Companion", "plugin-finder_release"})
@SuppressLint({"ResourceType"})
public final class FinderFullSeekBarLayout extends FrameLayout implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, SeekBar.OnSeekBarChangeListener, q {
    private static final HashMap<Long, Integer> wbM = new HashMap<>();
    public static final a wbN = new a((byte) 0);
    private final Rect rect = new Rect();
    public BaseFinderFeed tNO;
    private final kotlin.f vMb = kotlin.g.ah(new u(this));
    private boolean wbA = true;
    private final kotlin.f wbB = kotlin.g.ah(new s(this));
    private final kotlin.f wbC = kotlin.g.ah(new r(this));
    private final kotlin.f wbD = kotlin.g.ah(new e(this));
    private boolean wbE;
    private q.a wbF;
    public boolean wbG;
    private final kotlin.f wbH = kotlin.g.ah(new z(this));
    @SuppressLint({"ClickableViewAccessibility"})
    private final View.OnTouchListener wbI = new v(this);
    private int wbJ;
    private int wbK;
    private boolean wbL;
    private kotlin.g.a.a<Boolean> wbq = p.wcb;
    private kotlin.g.a.a<Boolean> wbr = o.wca;
    private kotlin.g.a.a<Boolean> wbs = l.wbX;
    private kotlin.g.a.a<kotlin.x> wbt = n.wbZ;
    private final kotlin.f wbu = kotlin.g.ah(new w(this));
    private final kotlin.f wbv = kotlin.g.ah(new g(this));
    private final kotlin.f wbw = kotlin.g.ah(new c(this));
    private final kotlin.f wbx = kotlin.g.ah(new b(this));
    private final kotlin.f wby = kotlin.g.ah(new m(this));
    private final kotlin.f wbz = kotlin.g.ah(new d(this));

    private final TextView getAllTimeLongTv() {
        AppMethodBeat.i(253925);
        TextView textView = (TextView) this.wbx.getValue();
        AppMethodBeat.o(253925);
        return textView;
    }

    private final TextView getAllTimeTv() {
        AppMethodBeat.i(253924);
        TextView textView = (TextView) this.wbw.getValue();
        AppMethodBeat.o(253924);
        return textView;
    }

    private final View getAwesomeGroundLayout() {
        AppMethodBeat.i(253927);
        View view = (View) this.wbz.getValue();
        AppMethodBeat.o(253927);
        return view;
    }

    private final WeImageView getAwesomeIcon() {
        AppMethodBeat.i(253930);
        WeImageView weImageView = (WeImageView) this.wbD.getValue();
        AppMethodBeat.o(253930);
        return weImageView;
    }

    private final TextView getCurrentTimeTv() {
        AppMethodBeat.i(253923);
        TextView textView = (TextView) this.wbv.getValue();
        AppMethodBeat.o(253923);
        return textView;
    }

    private final View getLongVideoLayout() {
        AppMethodBeat.i(253926);
        View view = (View) this.wby.getValue();
        AppMethodBeat.o(253926);
        return view;
    }

    private final View getPauseLayout() {
        AppMethodBeat.i(253928);
        View view = (View) this.wbB.getValue();
        AppMethodBeat.o(253928);
        return view;
    }

    private final SeekBar getSeekBar() {
        AppMethodBeat.i(253917);
        SeekBar seekBar = (SeekBar) this.vMb.getValue();
        AppMethodBeat.o(253917);
        return seekBar;
    }

    private final ViewGroup getSeekLayout() {
        AppMethodBeat.i(253922);
        ViewGroup viewGroup = (ViewGroup) this.wbu.getValue();
        AppMethodBeat.o(253922);
        return viewGroup;
    }

    private final GestureDetector getTouchDetector() {
        AppMethodBeat.i(253937);
        GestureDetector gestureDetector = (GestureDetector) this.wbH.getValue();
        AppMethodBeat.o(253937);
        return gestureDetector;
    }

    public final WeImageView getPauseIcon() {
        AppMethodBeat.i(253929);
        WeImageView weImageView = (WeImageView) this.wbC.getValue();
        AppMethodBeat.o(253929);
        return weImageView;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final l wbX = new l();

        static {
            AppMethodBeat.i(253898);
            AppMethodBeat.o(253898);
        }

        l() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final n wbZ = new n();

        static {
            AppMethodBeat.i(253901);
            AppMethodBeat.o(253901);
        }

        n() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ kotlin.x invoke() {
            return kotlin.x.SXb;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final o wca = new o();

        static {
            AppMethodBeat.i(253902);
            AppMethodBeat.o(253902);
        }

        o() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final p wcb = new p();

        static {
            AppMethodBeat.i(253903);
            AppMethodBeat.o(253903);
        }

        p() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.FALSE;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004 \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0018\u00010\u00030\u00032\u0016\u0010\u0006\u001a\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00072\u000e\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\t0\tH\n¢\u0006\u0002\b\n"}, hxF = {"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
    public static final class t<T, R> implements com.tencent.mm.loader.f.e<com.tencent.mm.plugin.finder.loader.o, Bitmap> {
        final /* synthetic */ FinderFullSeekBarLayout wbO;

        t(FinderFullSeekBarLayout finderFullSeekBarLayout) {
            this.wbO = finderFullSeekBarLayout;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.e.b.g, java.lang.Object] */
        @Override // com.tencent.mm.loader.f.e
        public final /* synthetic */ void a(com.tencent.mm.loader.h.a.a<com.tencent.mm.plugin.finder.loader.o> aVar, com.tencent.mm.loader.e.b.g gVar, Bitmap bitmap) {
            AppMethodBeat.i(253910);
            if (bitmap != null) {
                com.tencent.mm.ac.d.h(new a(this));
            }
            AppMethodBeat.o(253910);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$refreshAwesome$1$1$1"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ t wcd;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(t tVar) {
                super(0);
                this.wcd = tVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(253909);
                WeImageView a2 = FinderFullSeekBarLayout.a(this.wcd.wbO);
                Context context = this.wcd.wbO.getContext();
                kotlin.g.b.p.g(context, "context");
                a2.setIconColor(context.getResources().getColor(R.color.v9));
                FinderFullSeekBarLayout.a(this.wcd.wbO).post(new Runnable(this) {
                    /* class com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout.t.a.AnonymousClass1 */
                    final /* synthetic */ a wce;

                    {
                        this.wce = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(253908);
                        WeImageView a2 = FinderFullSeekBarLayout.a(this.wce.wcd.wbO);
                        Context context = this.wce.wcd.wbO.getContext();
                        kotlin.g.b.p.g(context, "context");
                        a2.setIconColor(context.getResources().getColor(R.color.v9));
                        AppMethodBeat.o(253908);
                    }
                });
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(253909);
                return xVar;
            }
        }
    }

    public static final /* synthetic */ WeImageView a(FinderFullSeekBarLayout finderFullSeekBarLayout) {
        AppMethodBeat.i(253966);
        WeImageView awesomeIcon = finderFullSeekBarLayout.getAwesomeIcon();
        AppMethodBeat.o(253966);
        return awesomeIcon;
    }

    public static final /* synthetic */ void a(FinderFullSeekBarLayout finderFullSeekBarLayout, boolean z2) {
        AppMethodBeat.i(253969);
        finderFullSeekBarLayout.oH(z2);
        AppMethodBeat.o(253969);
    }

    public static final /* synthetic */ ViewGroup c(FinderFullSeekBarLayout finderFullSeekBarLayout) {
        AppMethodBeat.i(253967);
        ViewGroup seekLayout = finderFullSeekBarLayout.getSeekLayout();
        AppMethodBeat.o(253967);
        return seekLayout;
    }

    public static final /* synthetic */ void d(FinderFullSeekBarLayout finderFullSeekBarLayout) {
        AppMethodBeat.i(253968);
        finderFullSeekBarLayout.dFd();
        AppMethodBeat.o(253968);
    }

    public static final /* synthetic */ WeImageView f(FinderFullSeekBarLayout finderFullSeekBarLayout) {
        AppMethodBeat.i(253971);
        WeImageView pauseIcon = finderFullSeekBarLayout.getPauseIcon();
        AppMethodBeat.o(253971);
        return pauseIcon;
    }

    public static final /* synthetic */ GestureDetector g(FinderFullSeekBarLayout finderFullSeekBarLayout) {
        AppMethodBeat.i(253972);
        GestureDetector touchDetector = finderFullSeekBarLayout.getTouchDetector();
        AppMethodBeat.o(253972);
        return touchDetector;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R-\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n`\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$Companion;", "", "()V", "ANIMATION_DURATION", "", "ANIMATION_SEEK_LAYOUT_DURATION", "TAG", "", "showGroupTipsSet", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getShowGroupTipsSet", "()Ljava/util/HashMap;", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(253965);
        AppMethodBeat.o(253965);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFullSeekBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(attributeSet, "attrs");
        AppMethodBeat.i(253963);
        AppMethodBeat.o(253963);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFullSeekBarLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(attributeSet, "attrs");
        AppMethodBeat.i(253964);
        AppMethodBeat.o(253964);
    }

    public final kotlin.g.a.a<Boolean> getOnPrivateLikeClickListener() {
        return this.wbq;
    }

    public final void setOnPrivateLikeClickListener(kotlin.g.a.a<Boolean> aVar) {
        AppMethodBeat.i(253918);
        kotlin.g.b.p.h(aVar, "<set-?>");
        this.wbq = aVar;
        AppMethodBeat.o(253918);
    }

    public final kotlin.g.a.a<Boolean> getOnPauseClickListener() {
        return this.wbr;
    }

    public final void setOnPauseClickListener(kotlin.g.a.a<Boolean> aVar) {
        AppMethodBeat.i(253919);
        kotlin.g.b.p.h(aVar, "<set-?>");
        this.wbr = aVar;
        AppMethodBeat.o(253919);
    }

    public final void setPlayingCallback(kotlin.g.a.a<Boolean> aVar) {
        AppMethodBeat.i(253920);
        kotlin.g.b.p.h(aVar, "<set-?>");
        this.wbs = aVar;
        AppMethodBeat.o(253920);
    }

    public final kotlin.g.a.a<kotlin.x> getOnLongVideoBtnClickListener() {
        return this.wbt;
    }

    public final void setOnLongVideoBtnClickListener(kotlin.g.a.a<kotlin.x> aVar) {
        AppMethodBeat.i(253921);
        kotlin.g.b.p.h(aVar, "<set-?>");
        this.wbt = aVar;
        AppMethodBeat.o(253921);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderFullSeekBarLayout wbO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(FinderFullSeekBarLayout finderFullSeekBarLayout) {
            super(0);
            this.wbO = finderFullSeekBarLayout;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$longVideoLayout$2$1$1"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ m wbY;

            a(m mVar) {
                this.wbY = mVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(253899);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$longVideoLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                this.wbY.wbO.getOnLongVideoBtnClickListener().invoke();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$longVideoLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(253899);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(253900);
            View findViewById = FinderFullSeekBarLayout.c(this.wbO).findViewById(R.id.dbq);
            findViewById.setOnClickListener(new a(this));
            AppMethodBeat.o(253900);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderFullSeekBarLayout wbO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderFullSeekBarLayout finderFullSeekBarLayout) {
            super(0);
            this.wbO = finderFullSeekBarLayout;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$awesomeGroundLayout$2$1$1"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ d wbP;

            a(d dVar) {
                this.wbP = dVar;
            }

            public final void onClick(View view) {
                BaseFinderFeed baseFinderFeed;
                AppMethodBeat.i(253887);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$awesomeGroundLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                boolean booleanValue = this.wbP.wbO.getOnPrivateLikeClickListener().invoke().booleanValue();
                if (booleanValue && (baseFinderFeed = this.wbP.wbO.tNO) != null) {
                    aj ajVar = aj.viU;
                    FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                    Context context = this.wbP.wbO.getContext();
                    kotlin.g.b.p.g(context, "context");
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
                    aj.a(fH != null ? fH.dIx() : null, "private_like", false, baseFinderFeed.lT());
                }
                FinderFullSeekBarLayout.d(this.wbP.wbO);
                FinderFullSeekBarLayout.a(this.wbP.wbO, booleanValue);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$awesomeGroundLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(253887);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(253888);
            View findViewById = FinderFullSeekBarLayout.c(this.wbO).findViewById(R.id.xj);
            findViewById.setOnClickListener(new a(this));
            AppMethodBeat.o(253888);
            return findViewById;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderFullSeekBarLayout wbO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(FinderFullSeekBarLayout finderFullSeekBarLayout) {
            super(0);
            this.wbO = finderFullSeekBarLayout;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$pauseLayout$2$1$1"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ s wcc;

            a(s sVar) {
                this.wcc = sVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(253906);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$pauseLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (this.wcc.wbO.getOnPauseClickListener().invoke().booleanValue()) {
                    FinderFullSeekBarLayout.e(this.wcc.wbO);
                    FinderFullSeekBarLayout.f(this.wcc.wbO).setImageResource(R.raw.icons_filled_play);
                } else {
                    FinderFullSeekBarLayout.f(this.wcc.wbO).setImageResource(R.raw.icons_filled_pause);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$pauseLayout$2$$special$$inlined$also$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(253906);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(253907);
            View findViewById = FinderFullSeekBarLayout.c(this.wbO).findViewById(R.id.hgu);
            findViewById.setOnClickListener(new a(this));
            AppMethodBeat.o(253907);
            return findViewById;
        }
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        AppMethodBeat.i(253931);
        super.onAttachedToWindow();
        BaseFinderFeed baseFinderFeed = this.tNO;
        if (baseFinderFeed != null) {
            if (!baseFinderFeed.isPreview) {
                getAwesomeGroundLayout().setVisibility(0);
            }
            AppMethodBeat.o(253931);
            return;
        }
        AppMethodBeat.o(253931);
    }

    private final void oH(boolean z2) {
        String str;
        FinderItem finderItem;
        FinderObject feedObject;
        boolean z3 = false;
        AppMethodBeat.i(253932);
        com.tencent.mm.plugin.finder.storage.logic.g gVar = com.tencent.mm.plugin.finder.storage.logic.g.vGW;
        BaseFinderFeed baseFinderFeed = this.tNO;
        azu Lj = com.tencent.mm.plugin.finder.storage.logic.g.Lj((baseFinderFeed == null || (finderItem = baseFinderFeed.feedObject) == null || (feedObject = finderItem.getFeedObject()) == null) ? 0 : feedObject.objectType);
        if (Lj != null) {
            str = Lj.LJJ;
        } else {
            str = null;
        }
        Log.i("Finder.FullSeekBarLayout", "[refreshAwesome] isLike=" + z2 + " groupLikeIconUrl=" + str);
        if (!z2) {
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z3 = true;
            }
            if (z3) {
                getAwesomeIcon().setImageResource(R.raw.icons_filled_like_group);
            } else {
                getAwesomeIcon().setLayerPaint(null);
                com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
                com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> djY = com.tencent.mm.plugin.finder.loader.m.djY();
                com.tencent.mm.plugin.finder.loader.p pVar = new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE);
                com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
                djY.a(pVar, com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE)).a(new t(this)).c(getAwesomeIcon());
            }
            WeImageView awesomeIcon = getAwesomeIcon();
            Context context = getContext();
            kotlin.g.b.p.g(context, "context");
            awesomeIcon.setIconColor(context.getResources().getColor(R.color.v9));
            AppMethodBeat.o(253932);
        } else if (str != null) {
            getAwesomeIcon().setLayerPaint(null);
            com.tencent.mm.plugin.finder.loader.m mVar3 = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.plugin.finder.loader.m mVar4 = com.tencent.mm.plugin.finder.loader.m.uJa;
            com.tencent.mm.plugin.finder.loader.m.djY().a(new com.tencent.mm.plugin.finder.loader.p(str, com.tencent.mm.plugin.finder.storage.x.FULL_IMAGE), getAwesomeIcon(), com.tencent.mm.plugin.finder.loader.m.a(m.a.TIMELINE));
            AppMethodBeat.o(253932);
        } else {
            getAwesomeIcon().setImageResource(R.raw.icons_filled_like_group);
            WeImageView awesomeIcon2 = getAwesomeIcon();
            Context context2 = getContext();
            kotlin.g.b.p.g(context2, "context");
            awesomeIcon2.setIconColor(context2.getResources().getColor(R.color.Red_90));
            AppMethodBeat.o(253932);
        }
    }

    public final void setFinderFeed(BaseFinderFeed baseFinderFeed) {
        FinderItem finderItem;
        AppMethodBeat.i(253933);
        this.tNO = baseFinderFeed;
        getAllTimeTv().setVisibility(8);
        if (baseFinderFeed == null || (finderItem = baseFinderFeed.feedObject) == null || !finderItem.isLongVideo()) {
            getLongVideoLayout().setVisibility(8);
            AppMethodBeat.o(253933);
            return;
        }
        getLongVideoLayout().setVisibility(0);
        gt(0, baseFinderFeed.feedObject.getLongVideoMediaList().getFirst().videoDuration);
        AppMethodBeat.o(253933);
    }

    public final void setPlaying(boolean z2) {
        AppMethodBeat.i(253934);
        if (!z2) {
            getPauseIcon().setImageResource(R.raw.icons_filled_play);
            getPauseIcon().setTag(0);
            AppMethodBeat.o(253934);
            return;
        }
        getPauseIcon().setTag(1);
        getPauseIcon().setImageResource(R.raw.icons_filled_pause);
        AppMethodBeat.o(253934);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(253935);
        kotlin.g.b.p.h(motionEvent, "event");
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        if (dispatchTouchEvent || !this.wbI.onTouch(this, motionEvent)) {
            AppMethodBeat.o(253935);
            return dispatchTouchEvent;
        }
        AppMethodBeat.o(253935);
        return true;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(253936);
        kotlin.g.b.p.h(motionEvent, "ev");
        if (!this.wbG || !getSeekLayout().getGlobalVisibleRect(this.rect)) {
            boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(253936);
            return onInterceptTouchEvent;
        } else if (((float) this.rect.bottom) < motionEvent.getY()) {
            AppMethodBeat.o(253936);
            return true;
        } else {
            AppMethodBeat.o(253936);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class v implements View.OnTouchListener {
        final /* synthetic */ FinderFullSeekBarLayout wbO;

        v(FinderFullSeekBarLayout finderFullSeekBarLayout) {
            this.wbO = finderFullSeekBarLayout;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(253912);
            GestureDetector g2 = FinderFullSeekBarLayout.g(this.wbO);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
            com.tencent.mm.hellhoundlib.a.a.a(g2, bl.axQ(), "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            com.tencent.mm.hellhoundlib.a.a.a(g2, g2.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$seekBarTouchListener$1", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(253912);
            return true;
        }
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
        AppMethodBeat.i(253938);
        kotlin.g.b.p.h(seekBar, "seekBar");
        this.wbE = true;
        q.a aVar = this.wbF;
        if (aVar != null) {
            aVar.dFH();
            AppMethodBeat.o(253938);
            return;
        }
        AppMethodBeat.o(253938);
    }

    public final void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
        AppMethodBeat.i(253939);
        kotlin.g.b.p.h(seekBar, "seekBar");
        if (z2) {
            float f2 = (float) this.wbK;
            Mb((int) android.support.v4.b.a.p((((float) getSeekBar().getProgress()) / ((float) getSeekBar().getMax())) * f2, 0.0f, f2 - 1.0f));
        }
        AppMethodBeat.o(253939);
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        AppMethodBeat.i(253940);
        kotlin.g.b.p.h(seekBar, "seekBar");
        this.wbE = false;
        q.a aVar = this.wbF;
        if (aVar != null) {
            aVar.bn(getSeekPercent());
            AppMethodBeat.o(253940);
            return;
        }
        AppMethodBeat.o(253940);
    }

    public final boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.i(253941);
        kotlin.g.b.p.h(motionEvent, "e");
        AppMethodBeat.o(253941);
        return true;
    }

    public final void onShowPress(MotionEvent motionEvent) {
        AppMethodBeat.i(253942);
        kotlin.g.b.p.h(motionEvent, "e");
        AppMethodBeat.o(253942);
    }

    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(253943);
        kotlin.g.b.p.h(motionEvent, "e1");
        kotlin.g.b.p.h(motionEvent2, "e2");
        AppMethodBeat.o(253943);
        return false;
    }

    public final void onLongPress(MotionEvent motionEvent) {
        AppMethodBeat.i(253944);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
        kotlin.g.b.p.h(motionEvent, "e");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout", "android/view/GestureDetector$OnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(253944);
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        AppMethodBeat.i(253945);
        kotlin.g.b.p.h(motionEvent, "e1");
        kotlin.g.b.p.h(motionEvent2, "e2");
        AppMethodBeat.o(253945);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void oI(boolean z2) {
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void setProgress(int i2) {
        AppMethodBeat.i(253946);
        this.wbJ = i2;
        getSeekBar().setProgress(i2);
        AppMethodBeat.o(253946);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void dEX() {
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final int getCurrentProgress() {
        AppMethodBeat.i(253947);
        int progress = getSeekBar().getProgress();
        AppMethodBeat.o(253947);
        return progress;
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void setSeekBarCallback(q.a aVar) {
        AppMethodBeat.i(253948);
        kotlin.g.b.p.h(aVar, "callback");
        this.wbF = aVar;
        AppMethodBeat.o(253948);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final boolean dEY() {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void gs(int i2, int i3) {
        AppMethodBeat.i(253949);
        this.wbK = i3;
        gt(i2, i3);
        Mb(i2);
        setPlaying(true);
        AppMethodBeat.o(253949);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void bm(float f2) {
        AppMethodBeat.i(253950);
        getSeekBar().setProgress(kotlin.h.a.cR(((float) getSeekBar().getMax()) * f2));
        AppMethodBeat.o(253950);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final boolean dEZ() {
        return this.wbE;
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void awG(String str) {
        AppMethodBeat.i(253951);
        kotlin.g.b.p.h(str, "reason");
        if (!this.wbG) {
            AppMethodBeat.o(253951);
            return;
        }
        Log.i("Finder.FullSeekBarLayout", "[exitSeekMode] reason=".concat(String.valueOf(str)));
        this.wbG = false;
        dFb();
        dFc();
        getSeekLayout().setClickable(false);
        AppMethodBeat.o(253951);
    }

    @Override // com.tencent.mm.plugin.finder.video.q
    public final void dFa() {
        FinderItem finderItem;
        FinderObject feedObject;
        BaseFinderFeed baseFinderFeed;
        FinderItem finderItem2;
        FinderItem finderItem3;
        AppMethodBeat.i(253952);
        if (this.wbG) {
            AppMethodBeat.o(253952);
            return;
        }
        this.wbG = true;
        ViewParent parent = getParent();
        if (parent == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(253952);
            throw tVar;
        }
        View findViewById = ((View) parent).findViewById(R.id.clt);
        if (findViewById != null) {
            ViewPropertyAnimator animate = findViewById.animate();
            if (animate != null) {
                animate.cancel();
            }
            findViewById.setAlpha(0.0f);
        }
        ViewParent parent2 = getParent();
        if (parent2 == null) {
            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(253952);
            throw tVar2;
        }
        View findViewById2 = ((View) parent2).findViewById(R.id.d43);
        if (findViewById2 != null) {
            ViewPropertyAnimator animate2 = findViewById2.animate();
            if (animate2 != null) {
                animate2.cancel();
            }
            findViewById2.setAlpha(0.0f);
        }
        ViewParent parent3 = getParent();
        if (parent3 == null) {
            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(253952);
            throw tVar3;
        }
        View findViewById3 = ((View) parent3).findViewById(R.id.clr);
        if (!(findViewById3 instanceof ViewGroup)) {
            findViewById3 = null;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById3;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                kotlin.g.b.p.g(childAt, "child");
                if (childAt.getId() != R.id.fkv && childAt.getVisibility() == 0) {
                    ViewPropertyAnimator animate3 = childAt.animate();
                    if (animate3 != null) {
                        animate3.cancel();
                    }
                    childAt.animate().alpha(0.0f).setDuration(220).setListener(new i(childAt)).start();
                }
            }
        }
        BaseFinderFeed baseFinderFeed2 = this.tNO;
        if (baseFinderFeed2 == null || (finderItem3 = baseFinderFeed2.feedObject) == null || !finderItem3.isLongVideo()) {
            getLongVideoLayout().setVisibility(8);
            getAllTimeTv().setVisibility(0);
        } else {
            getAllTimeTv().setVisibility(8);
            getLongVideoLayout().setVisibility(0);
        }
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        int i3 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_FEED_GROUP_LIKE_GUIDE_INT, 0);
        if (i3 < 3) {
            ViewParent parent4 = getParent();
            if (parent4 == null) {
                kotlin.t tVar4 = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(253952);
                throw tVar4;
            }
            ViewGroup viewGroup2 = (ViewGroup) parent4;
            if (!(viewGroup2.findViewById(R.id.cls) != null)) {
                Rect rect2 = new Rect();
                if (getAwesomeGroundLayout().getGlobalVisibleRect(rect2)) {
                    View inflate = aa.jQ(getContext()).inflate(R.layout.ac5, viewGroup2, false);
                    kotlin.g.b.p.g(inflate, "tipsLayout");
                    inflate.setAlpha(0.0f);
                    viewGroup2.addView(inflate);
                    inflate.post(new f(this, rect2, inflate, i3, viewGroup2));
                }
            }
        }
        ViewGroup viewGroup3 = (ViewGroup) getSeekLayout().findViewById(R.id.g8t);
        kotlin.g.b.p.g(viewGroup3, "partTopLayout");
        int childCount2 = viewGroup3.getChildCount();
        for (int i4 = 0; i4 < childCount2; i4++) {
            View childAt2 = viewGroup3.getChildAt(i4);
            kotlin.g.b.p.g(childAt2, "child");
            if (!(childAt2.getId() == R.id.dbq || (((baseFinderFeed = this.tNO) == null || (finderItem2 = baseFinderFeed.feedObject) == null || finderItem2.isLongVideo()) && childAt2.getId() == getAllTimeTv().getId()))) {
                ViewPropertyAnimator animate4 = childAt2.animate();
                if (animate4 != null) {
                    animate4.cancel();
                }
                childAt2.setVisibility(0);
                childAt2.setAlpha(0.0f);
                childAt2.animate().alpha(1.0f).setDuration(130).setListener(null).start();
            }
        }
        View findViewById4 = getSeekLayout().findViewById(R.id.g8r);
        if (findViewById4 != null) {
            ViewPropertyAnimator animate5 = findViewById4.animate();
            if (animate5 != null) {
                animate5.cancel();
            }
            findViewById4.setVisibility(0);
            findViewById4.setAlpha(0.0f);
            findViewById4.animate().alpha(1.0f).setDuration(130).setListener(new y(this)).start();
        }
        BaseFinderFeed baseFinderFeed3 = this.tNO;
        if (!(baseFinderFeed3 == null || (finderItem = baseFinderFeed3.feedObject) == null || (feedObject = finderItem.getFeedObject()) == null)) {
            j.a aVar = com.tencent.mm.plugin.finder.upload.action.j.vUw;
            kotlin.o<Boolean, Boolean> m2 = com.tencent.mm.plugin.finder.upload.action.j.vUv.m(feedObject);
            oH(m2.first.booleanValue() && m2.second.booleanValue());
        }
        if (this.wbs.invoke().booleanValue()) {
            this.wbA = false;
            getPauseLayout().callOnClick();
        }
        getSeekLayout().setClickable(true);
        AppMethodBeat.o(253952);
    }

    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        AppMethodBeat.i(253953);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        kotlin.g.b.p.h(motionEvent, "e");
        if (this.wbG) {
            post(new q(this));
            this.wbL = true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(253953);
        return true;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class q implements Runnable {
        final /* synthetic */ FinderFullSeekBarLayout wbO;

        q(FinderFullSeekBarLayout finderFullSeekBarLayout) {
            this.wbO = finderFullSeekBarLayout;
        }

        public final void run() {
            AppMethodBeat.i(253904);
            this.wbO.awG("onSingleTapUp");
            AppMethodBeat.o(253904);
        }
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        AppMethodBeat.i(253954);
        kotlin.g.b.p.h(motionEvent, "e");
        if (this.wbL) {
            this.wbL = false;
            AppMethodBeat.o(253954);
            return false;
        }
        if (!this.wbG) {
            dFa();
        }
        AppMethodBeat.o(253954);
        return true;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        AppMethodBeat.i(253955);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout", "android/view/GestureDetector$OnDoubleTapListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(253955);
        return false;
    }

    public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    private final float getSeekPercent() {
        AppMethodBeat.i(253956);
        SeekBar seekBar = getSeekBar();
        if (seekBar == null) {
            AppMethodBeat.o(253956);
            return 0.0f;
        }
        float progress = (1.0f * ((float) seekBar.getProgress())) / ((float) seekBar.getMax());
        AppMethodBeat.o(253956);
        return progress;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$hideOtherView$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class i extends com.tencent.mm.plugin.finder.animation.a {
        final /* synthetic */ View wbW;

        i(View view) {
            this.wbW = view;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(253895);
            kotlin.g.b.p.h(animator, "animation");
            View view = this.wbW;
            kotlin.g.b.p.g(view, "child");
            view.setVisibility(4);
            this.wbW.setTag(R.id.d33, Boolean.TRUE);
            AppMethodBeat.o(253895);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$showOtherView$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class x extends com.tencent.mm.plugin.finder.animation.a {
        final /* synthetic */ View wbW;

        x(View view) {
            this.wbW = view;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(253914);
            kotlin.g.b.p.h(animator, "animation");
            View view = this.wbW;
            kotlin.g.b.p.g(view, "child");
            view.setVisibility(0);
            AppMethodBeat.o(253914);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$showSeekLayout$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class y extends com.tencent.mm.plugin.finder.animation.a {
        final /* synthetic */ FinderFullSeekBarLayout wbO;

        y(FinderFullSeekBarLayout finderFullSeekBarLayout) {
            this.wbO = finderFullSeekBarLayout;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(253915);
            BaseFinderFeed baseFinderFeed = this.wbO.tNO;
            if (baseFinderFeed != null) {
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                Context context = this.wbO.getContext();
                kotlin.g.b.p.g(context, "context");
                FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
                bbn dIx = fH != null ? fH.dIx() : null;
                aj ajVar = aj.viU;
                aj.a(dIx, "pause_by_icon", true, baseFinderFeed.lT());
                aj ajVar2 = aj.viU;
                aj.a(dIx, "private_like", true, baseFinderFeed.lT());
                AppMethodBeat.o(253915);
                return;
            }
            AppMethodBeat.o(253915);
        }
    }

    private final void dFc() {
        AppMethodBeat.i(253958);
        dFd();
        View findViewById = getSeekLayout().findViewById(R.id.g8r);
        if (findViewById != null) {
            ViewPropertyAnimator animate = findViewById.animate();
            if (animate != null) {
                animate.cancel();
            }
            findViewById.animate().alpha(0.0f).setDuration(130).setListener(new j(findViewById)).start();
        }
        ViewGroup viewGroup = (ViewGroup) getSeekLayout().findViewById(R.id.g8t);
        kotlin.g.b.p.g(viewGroup, "partTopLayout");
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            kotlin.g.b.p.g(childAt, "child");
            if (childAt.getId() != R.id.dbq && childAt.getVisibility() == 0) {
                ViewPropertyAnimator animate2 = childAt.animate();
                if (animate2 != null) {
                    animate2.cancel();
                }
                childAt.animate().alpha(0.0f).setDuration(130).setListener(new k(childAt)).start();
            }
        }
        if (!this.wbs.invoke().booleanValue()) {
            this.wbA = false;
            getPauseLayout().callOnClick();
        }
        AppMethodBeat.o(253958);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$hideSeekLayout$1$1", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class j extends com.tencent.mm.plugin.finder.animation.a {
        final /* synthetic */ View tzy;

        j(View view) {
            this.tzy = view;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(253896);
            this.tzy.setVisibility(4);
            this.tzy.setAlpha(1.0f);
            AppMethodBeat.o(253896);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$hideSeekLayout$2", "Lcom/tencent/mm/plugin/finder/animation/AnimatorEndListener;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "plugin-finder_release"})
    public static final class k extends com.tencent.mm.plugin.finder.animation.a {
        final /* synthetic */ View wbW;

        k(View view) {
            this.wbW = view;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(253897);
            View view = this.wbW;
            kotlin.g.b.p.g(view, "child");
            view.setVisibility(4);
            View view2 = this.wbW;
            kotlin.g.b.p.g(view2, "child");
            view2.setAlpha(1.0f);
            AppMethodBeat.o(253897);
        }
    }

    private final void Mb(int i2) {
        AppMethodBeat.i(253959);
        getCurrentTimeTv().setText(formatSecToMin(i2));
        AppMethodBeat.o(253959);
    }

    private final void gt(int i2, int i3) {
        BaseFinderFeed baseFinderFeed;
        AppMethodBeat.i(253960);
        String formatSecToMin = formatSecToMin(i3);
        getAllTimeTv().setText(formatSecToMin);
        if (i2 >= 60 || ((baseFinderFeed = this.tNO) != null && baseFinderFeed.isHasLongVideoTimeBack)) {
            BaseFinderFeed baseFinderFeed2 = this.tNO;
            if (baseFinderFeed2 != null) {
                baseFinderFeed2.isHasLongVideoTimeBack = true;
            }
            getAllTimeLongTv().setText(formatSecToMin(i3 - i2));
            AppMethodBeat.o(253960);
            return;
        }
        getAllTimeLongTv().setText(formatSecToMin);
        AppMethodBeat.o(253960);
    }

    private static String formatSecToMin(int i2) {
        AppMethodBeat.i(253961);
        ae aeVar = ae.SYK;
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(((long) i2) / 60), Long.valueOf(((long) i2) % 60)}, 2));
        kotlin.g.b.p.g(format, "java.lang.String.format(format, *args)");
        AppMethodBeat.o(253961);
        return format;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ ViewGroup hVi;
        final /* synthetic */ FinderFullSeekBarLayout wbO;
        final /* synthetic */ Rect wbQ;
        final /* synthetic */ View wbR;
        final /* synthetic */ int wbS;

        f(FinderFullSeekBarLayout finderFullSeekBarLayout, Rect rect, View view, int i2, ViewGroup viewGroup) {
            this.wbO = finderFullSeekBarLayout;
            this.wbQ = rect;
            this.wbR = view;
            this.wbS = i2;
            this.hVi = viewGroup;
        }

        public final void run() {
            AppMethodBeat.i(253892);
            View view = this.wbR;
            kotlin.g.b.p.g(view, "tipsLayout");
            float centerX = ((float) this.wbQ.centerX()) - (((float) view.getWidth()) / 2.0f);
            View view2 = this.wbR;
            kotlin.g.b.p.g(view2, "tipsLayout");
            float centerY = ((float) this.wbQ.centerY()) - (((float) view2.getHeight()) / 2.0f);
            Context context = this.wbO.getContext();
            kotlin.g.b.p.g(context, "context");
            float dimension = centerY - context.getResources().getDimension(R.dimen.cr);
            View view3 = this.wbR;
            kotlin.g.b.p.g(view3, "tipsLayout");
            view3.setTranslationX(centerX);
            View view4 = this.wbR;
            kotlin.g.b.p.g(view4, "tipsLayout");
            view4.setTranslationY(dimension);
            BaseFinderFeed baseFinderFeed = this.wbO.tNO;
            long lT = baseFinderFeed != null ? baseFinderFeed.lT() : 0;
            a aVar = FinderFullSeekBarLayout.wbN;
            Integer num = (Integer) FinderFullSeekBarLayout.wbM.get(Long.valueOf(lT));
            if (num == null) {
                num = 0;
            }
            kotlin.g.b.p.g(num, "showGroupTipsSet[feedId] ?: 0");
            int intValue = num.intValue();
            if (intValue == 0) {
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_FINDER_FEED_GROUP_LIKE_GUIDE_INT, Integer.valueOf(this.wbS + 1));
                a aVar2 = FinderFullSeekBarLayout.wbN;
                FinderFullSeekBarLayout.wbM.put(Long.valueOf(lT), 1);
                Log.i("Finder.FullSeekBarLayout", "[checkShowGroupLikeTips] record count=" + (this.wbS + 1));
            }
            a aVar3 = FinderFullSeekBarLayout.wbN;
            FinderFullSeekBarLayout.wbM.put(Long.valueOf(lT), Integer.valueOf(intValue + 1));
            if (intValue < 3) {
                this.wbR.animate().setStartDelay(0).setDuration(220).alpha(1.0f).setListener(new com.tencent.mm.plugin.finder.animation.a(this) {
                    /* class com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout.f.AnonymousClass1 */
                    final /* synthetic */ f wbT;

                    /* JADX WARN: Incorrect args count in method signature: ()V */
                    {
                        this.wbT = r1;
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(253891);
                        kotlin.g.b.p.h(animator, "animation");
                        Log.i("Finder.FullSeekBarLayout", "[onAnimationEnd]");
                        this.wbT.wbR.postDelayed(new a(this), 5000);
                        AppMethodBeat.o(253891);
                    }

                    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
                    /* renamed from: com.tencent.mm.plugin.finder.video.FinderFullSeekBarLayout$f$1$a */
                    static final class a implements Runnable {
                        final /* synthetic */ AnonymousClass1 wbU;

                        a(AnonymousClass1 r1) {
                            this.wbU = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(253890);
                            this.wbU.wbT.hVi.removeView(this.wbU.wbT.wbR);
                            AppMethodBeat.o(253890);
                        }
                    }
                }).start();
            }
            AppMethodBeat.o(253892);
        }
    }

    private final void dFd() {
        View findViewById;
        AppMethodBeat.i(253962);
        Log.i("Finder.FullSeekBarLayout", "[dismissGroupLikeTips]");
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup == null || (findViewById = viewGroup.findViewById(R.id.cls)) == null) {
            AppMethodBeat.o(253962);
            return;
        }
        findViewById.post(new h(findViewById, viewGroup));
        AppMethodBeat.o(253962);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/FinderFullSeekBarLayout$dismissGroupLikeTips$1$1"})
    public static final class h implements Runnable {
        final /* synthetic */ View tzy;
        final /* synthetic */ ViewGroup wbV;

        h(View view, ViewGroup viewGroup) {
            this.tzy = view;
            this.wbV = viewGroup;
        }

        public final void run() {
            AppMethodBeat.i(253894);
            this.tzy.animate().cancel();
            this.wbV.removeView(this.tzy);
            AppMethodBeat.o(253894);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
    static final class u extends kotlin.g.b.q implements kotlin.g.a.a<SeekBar> {
        final /* synthetic */ FinderFullSeekBarLayout wbO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(FinderFullSeekBarLayout finderFullSeekBarLayout) {
            super(0);
            this.wbO = finderFullSeekBarLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ SeekBar invoke() {
            AppMethodBeat.i(253911);
            View findViewById = FinderFullSeekBarLayout.c(this.wbO).findViewById(R.id.ggj);
            ((SeekBar) findViewById).setOnSeekBarChangeListener(this.wbO);
            SeekBar seekBar = (SeekBar) findViewById;
            AppMethodBeat.o(253911);
            return seekBar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
    static final class w extends kotlin.g.b.q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ FinderFullSeekBarLayout wbO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(FinderFullSeekBarLayout finderFullSeekBarLayout) {
            super(0);
            this.wbO = finderFullSeekBarLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(253913);
            ViewParent parent = this.wbO.getParent();
            if (parent == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.View");
                AppMethodBeat.o(253913);
                throw tVar;
            }
            ViewGroup viewGroup = (ViewGroup) ((View) parent).findViewById(R.id.d33);
            AppMethodBeat.o(253913);
            return viewGroup;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderFullSeekBarLayout wbO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderFullSeekBarLayout finderFullSeekBarLayout) {
            super(0);
            this.wbO = finderFullSeekBarLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(253893);
            TextView textView = (TextView) FinderFullSeekBarLayout.c(this.wbO).findViewById(R.id.j4a);
            AppMethodBeat.o(253893);
            return textView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderFullSeekBarLayout wbO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderFullSeekBarLayout finderFullSeekBarLayout) {
            super(0);
            this.wbO = finderFullSeekBarLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(253886);
            TextView textView = (TextView) FinderFullSeekBarLayout.c(this.wbO).findViewById(R.id.j6k);
            AppMethodBeat.o(253886);
            return textView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class b extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderFullSeekBarLayout wbO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderFullSeekBarLayout finderFullSeekBarLayout) {
            super(0);
            this.wbO = finderFullSeekBarLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(253885);
            View findViewById = FinderFullSeekBarLayout.c(this.wbO).findViewById(R.id.et3);
            TextView textView = (TextView) findViewById;
            kotlin.g.b.p.g(textView, LocaleUtil.ITALIAN);
            com.tencent.mm.plugin.finder.utils.e.n(textView);
            TextView textView2 = (TextView) findViewById;
            AppMethodBeat.o(253885);
            return textView2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ FinderFullSeekBarLayout wbO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(FinderFullSeekBarLayout finderFullSeekBarLayout) {
            super(0);
            this.wbO = finderFullSeekBarLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(253905);
            WeImageView weImageView = (WeImageView) FinderFullSeekBarLayout.c(this.wbO).findViewById(R.id.hgt);
            AppMethodBeat.o(253905);
            return weImageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ FinderFullSeekBarLayout wbO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FinderFullSeekBarLayout finderFullSeekBarLayout) {
            super(0);
            this.wbO = finderFullSeekBarLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(253889);
            WeImageView weImageView = (WeImageView) FinderFullSeekBarLayout.c(this.wbO).findViewById(R.id.hgr);
            AppMethodBeat.o(253889);
            return weImageView;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/view/GestureDetector;", "invoke"})
    static final class z extends kotlin.g.b.q implements kotlin.g.a.a<GestureDetector> {
        final /* synthetic */ FinderFullSeekBarLayout wbO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(FinderFullSeekBarLayout finderFullSeekBarLayout) {
            super(0);
            this.wbO = finderFullSeekBarLayout;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ GestureDetector invoke() {
            AppMethodBeat.i(253916);
            GestureDetector gestureDetector = new GestureDetector(this.wbO.getContext(), this.wbO);
            AppMethodBeat.o(253916);
            return gestureDetector;
        }
    }

    private final void dFb() {
        AppMethodBeat.i(253957);
        ViewParent parent = getParent();
        if (parent == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(253957);
            throw tVar;
        }
        View findViewById = ((View) parent).findViewById(R.id.clt);
        if (findViewById != null) {
            ViewPropertyAnimator animate = findViewById.animate();
            if (animate != null) {
                animate.cancel();
            }
            findViewById.animate().alpha(1.0f).setDuration(220).start();
        }
        ViewParent parent2 = getParent();
        if (parent2 == null) {
            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(253957);
            throw tVar2;
        }
        View findViewById2 = ((View) parent2).findViewById(R.id.d43);
        if (findViewById2 != null) {
            ViewPropertyAnimator animate2 = findViewById2.animate();
            if (animate2 != null) {
                animate2.cancel();
            }
            findViewById2.animate().alpha(1.0f).setDuration(220).start();
        }
        ViewParent parent3 = getParent();
        if (parent3 == null) {
            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type android.view.View");
            AppMethodBeat.o(253957);
            throw tVar3;
        }
        View findViewById3 = ((View) parent3).findViewById(R.id.clr);
        if (!(findViewById3 instanceof ViewGroup)) {
            findViewById3 = null;
        }
        ViewGroup viewGroup = (ViewGroup) findViewById3;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (kotlin.g.b.p.j(childAt.getTag(R.id.d33), Boolean.TRUE)) {
                    ViewPropertyAnimator animate3 = childAt.animate();
                    if (animate3 != null) {
                        animate3.cancel();
                    }
                    kotlin.g.b.p.g(childAt, "child");
                    childAt.setVisibility(0);
                    childAt.animate().alpha(1.0f).setListener(new x(childAt)).setDuration(220).start();
                }
            }
            AppMethodBeat.o(253957);
            return;
        }
        AppMethodBeat.o(253957);
    }

    public static final /* synthetic */ void e(FinderFullSeekBarLayout finderFullSeekBarLayout) {
        String str;
        AppMethodBeat.i(253970);
        if (finderFullSeekBarLayout.wbA) {
            str = "pause_by_icon";
        } else {
            finderFullSeekBarLayout.wbA = true;
            str = "pause_by_clckscreen";
        }
        BaseFinderFeed baseFinderFeed = finderFullSeekBarLayout.tNO;
        if (baseFinderFeed != null) {
            aj ajVar = aj.viU;
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            Context context = finderFullSeekBarLayout.getContext();
            kotlin.g.b.p.g(context, "context");
            FinderReporterUIC fH = FinderReporterUIC.a.fH(context);
            aj.a(fH != null ? fH.dIx() : null, str, false, baseFinderFeed.lT());
            AppMethodBeat.o(253970);
            return;
        }
        AppMethodBeat.o(253970);
    }
}
