package com.tencent.mm.plugin.finder.view;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J \u0010\u001f\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\rH\u0016J\u0010\u0010#\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010$\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R#\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderProgressBar;", "Landroid/widget/FrameLayout;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isEnableSeek", "", "lastX", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getListener", "()Landroid/widget/SeekBar$OnSeekBarChangeListener;", "setListener", "(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V", "seekBar", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "getSeekBar", "()Landroid/widget/SeekBar;", "seekBar$delegate", "Lkotlin/Lazy;", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onProgressChanged", "", "progress", "fromUser", "onStartTrackingTouch", "onStopTrackingTouch", "showSeekBar", "isShow", "delay", "", "Companion", "plugin-finder_release"})
public final class FinderProgressBar extends FrameLayout implements SeekBar.OnSeekBarChangeListener {
    public static final b woC = new b((byte) 0);
    private float aTD;
    private final kotlin.f vMb;
    private boolean woA;
    private SeekBar.OnSeekBarChangeListener woB;

    static {
        AppMethodBeat.i(168407);
        AppMethodBeat.o(168407);
    }

    private final SeekBar getSeekBar() {
        AppMethodBeat.i(168409);
        SeekBar seekBar = (SeekBar) this.vMb.getValue();
        AppMethodBeat.o(168409);
        return seekBar;
    }

    public static final /* synthetic */ SeekBar a(FinderProgressBar finderProgressBar) {
        AppMethodBeat.i(168416);
        SeekBar seekBar = finderProgressBar.getSeekBar();
        AppMethodBeat.o(168416);
        return seekBar;
    }

    public static final /* synthetic */ void b(FinderProgressBar finderProgressBar) {
        AppMethodBeat.i(168417);
        finderProgressBar.oZ(true);
        AppMethodBeat.o(168417);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(168414);
        LayoutInflater.from(getContext()).inflate(R.layout.al5, (ViewGroup) this, true);
        SeekBar seekBar = (SeekBar) findViewById(R.id.hgn);
        if (seekBar != null) {
            setAlpha(0.0f);
            seekBar.setOnTouchListener(a.woD);
        }
        setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderProgressBar.AnonymousClass1 */
            final /* synthetic */ FinderProgressBar woE;

            {
                this.woE = r1;
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(168402);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderProgressBar$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                Log.i("Finder.ProgressBar", "onLongClick...");
                FinderProgressBar.b(this.woE);
                view.performHapticFeedback(0, 2);
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/finder/view/FinderProgressBar$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(168402);
                return false;
            }
        });
        this.vMb = g.ah(new c(this));
        AppMethodBeat.o(168414);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(168415);
        LayoutInflater.from(getContext()).inflate(R.layout.al5, (ViewGroup) this, true);
        SeekBar seekBar = (SeekBar) findViewById(R.id.hgn);
        if (seekBar != null) {
            setAlpha(0.0f);
            seekBar.setOnTouchListener(a.woD);
        }
        setOnLongClickListener(new View.OnLongClickListener(this) {
            /* class com.tencent.mm.plugin.finder.view.FinderProgressBar.AnonymousClass1 */
            final /* synthetic */ FinderProgressBar woE;

            {
                this.woE = r1;
            }

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(168402);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderProgressBar$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                Log.i("Finder.ProgressBar", "onLongClick...");
                FinderProgressBar.b(this.woE);
                view.performHapticFeedback(0, 2);
                com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/finder/view/FinderProgressBar$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(168402);
                return false;
            }
        });
        this.vMb = g.ah(new c(this));
        AppMethodBeat.o(168415);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderProgressBar$Companion;", "", "()V", "ANIMATION_DURATION", "", "DISMISS_DELAY", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    static final class a implements View.OnTouchListener {
        public static final a woD = new a();

        static {
            AppMethodBeat.i(168401);
            AppMethodBeat.o(168401);
        }

        a() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(168408);
        p.h(motionEvent, "event");
        if (this.woA && motionEvent.getAction() == 0) {
            animate().cancel();
            setAlpha(1.0f);
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (this.woA) {
                oZ(false);
            }
        } else if (motionEvent.getAction() == 2 && this.woA) {
            float x = this.aTD - motionEvent.getX();
            float abs = Math.abs(x);
            SeekBar seekBar = getSeekBar();
            p.g(seekBar, "seekBar");
            float progress = (float) seekBar.getProgress();
            if (x >= 0.0f) {
                abs = -abs;
            }
            SeekBar seekBar2 = getSeekBar();
            p.g(seekBar2, "seekBar");
            seekBar2.setProgress((int) (abs + progress));
        }
        this.aTD = motionEvent.getX();
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(168408);
        return dispatchTouchEvent;
    }

    private final void oZ(boolean z) {
        AppMethodBeat.i(168410);
        if (z) {
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.woB;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onStartTrackingTouch(getSeekBar());
            }
            animate().cancel();
            animate().alpha(1.0f).withStartAction(new d(this)).setListener(new e(this)).setDuration(300).alpha(1.0f).setStartDelay(0).start();
            AppMethodBeat.o(168410);
            return;
        }
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener2 = this.woB;
        if (onSeekBarChangeListener2 != null) {
            onSeekBarChangeListener2.onStopTrackingTouch(getSeekBar());
        }
        animate().cancel();
        animate().alpha(0.0f).setListener(new f(this)).setDuration(300).setStartDelay(0).start();
        AppMethodBeat.o(168410);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class d implements Runnable {
        final /* synthetic */ FinderProgressBar woE;

        d(FinderProgressBar finderProgressBar) {
            this.woE = finderProgressBar;
        }

        public final void run() {
            AppMethodBeat.i(168404);
            this.woE.setAlpha(0.0f);
            this.woE.setVisibility(0);
            this.woE.woA = true;
            AppMethodBeat.o(168404);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderProgressBar$showSeekBar$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class e implements Animator.AnimatorListener {
        final /* synthetic */ FinderProgressBar woE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderProgressBar finderProgressBar) {
            this.woE = finderProgressBar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(254905);
            SeekBar a2 = FinderProgressBar.a(this.woE);
            p.g(a2, "seekBar");
            a2.setAlpha(1.0f);
            AppMethodBeat.o(254905);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderProgressBar$showSeekBar$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class f implements Animator.AnimatorListener {
        final /* synthetic */ FinderProgressBar woE;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(FinderProgressBar finderProgressBar) {
            this.woE = finderProgressBar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(254906);
            this.woE.setAlpha(0.0f);
            this.woE.woA = false;
            AppMethodBeat.o(254906);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    public final SeekBar.OnSeekBarChangeListener getListener() {
        return this.woB;
    }

    public final void setListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.woB = onSeekBarChangeListener;
    }

    public final void onProgressChanged(SeekBar seekBar, int i2, boolean z) {
        AppMethodBeat.i(168411);
        p.h(seekBar, "seekBar");
        SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = this.woB;
        if (onSeekBarChangeListener != null) {
            onSeekBarChangeListener.onProgressChanged(seekBar, i2, z);
            AppMethodBeat.o(168411);
            return;
        }
        AppMethodBeat.o(168411);
    }

    public final void onStartTrackingTouch(SeekBar seekBar) {
        AppMethodBeat.i(168412);
        p.h(seekBar, "seekBar");
        AppMethodBeat.o(168412);
    }

    public final void onStopTrackingTouch(SeekBar seekBar) {
        AppMethodBeat.i(168413);
        p.h(seekBar, "seekBar");
        AppMethodBeat.o(168413);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/widget/SeekBar;", "kotlin.jvm.PlatformType", "invoke"})
    static final class c extends q implements kotlin.g.a.a<SeekBar> {
        final /* synthetic */ FinderProgressBar woE;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderProgressBar finderProgressBar) {
            super(0);
            this.woE = finderProgressBar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ SeekBar invoke() {
            AppMethodBeat.i(168403);
            View findViewById = this.woE.findViewById(R.id.hgn);
            ((SeekBar) findViewById).setOnSeekBarChangeListener(this.woE);
            SeekBar seekBar = (SeekBar) findViewById;
            AppMethodBeat.o(168403);
            return seekBar;
        }
    }
}
