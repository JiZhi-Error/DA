package com.tencent.mm.plugin.music.ui.view;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.LinearInterpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.plugin.music.a;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.xwalk.core.Log;

@SuppressLint({"StaticFieldLeak"})
public class MusicPlayerLyricView extends AppCompatTextView {
    private boolean AmY;
    private e Amv;
    private int AoA;
    private int AoB;
    private int AoC;
    private int AoD;
    private int AoE;
    private int AoF;
    private String AoG;
    private float AoH;
    private b AoI;
    private int AoJ;
    private boolean AoK;
    private int AoL;
    private int AoM;
    private final int AoN;
    private final int AoO;
    private GestureDetector.SimpleOnGestureListener AoP;
    private Runnable AoQ;
    private List<a> Aor;
    private TextPaint Aos;
    private TextPaint Aot;
    private Paint.FontMetrics Aou;
    private int Aov;
    private float Aow;
    private int Aox;
    private int Aoy;
    private float Aoz;
    private ValueAnimator dgN;
    private int height;
    private boolean isInit;
    private int lineHeight;
    private long mAnimationDuration;
    private GestureDetector mDJ;
    private Scroller mScroller;
    private int textPadding;
    private int textSize;
    private int width;
    private boolean xbw;
    private float yYt;

    public interface b {
        boolean evu();
    }

    static /* synthetic */ float c(MusicPlayerLyricView musicPlayerLyricView, int i2) {
        AppMethodBeat.i(219930);
        float Tg = musicPlayerLyricView.Tg(i2);
        AppMethodBeat.o(219930);
        return Tg;
    }

    static /* synthetic */ void j(MusicPlayerLyricView musicPlayerLyricView) {
        AppMethodBeat.i(219932);
        musicPlayerLyricView.evr();
        AppMethodBeat.o(219932);
    }

    /* access modifiers changed from: package-private */
    public class a implements Comparable<a> {
        private String AoT;
        StaticLayout huH;
        float offset = Float.MIN_VALUE;
        private String text;
        long timestamp;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
            a aVar2 = aVar;
            if (aVar2 == null) {
                return -1;
            }
            return (int) (this.timestamp - aVar2.timestamp);
        }

        a(long j2, String str) {
            this.timestamp = j2;
            this.text = str;
        }

        /* access modifiers changed from: package-private */
        public final void a(TextPaint textPaint, int i2, int i3) {
            Layout.Alignment alignment;
            AppMethodBeat.i(219904);
            switch (i3) {
                case 1:
                    alignment = Layout.Alignment.ALIGN_NORMAL;
                    break;
                case 2:
                    alignment = Layout.Alignment.ALIGN_OPPOSITE;
                    break;
                default:
                    alignment = Layout.Alignment.ALIGN_CENTER;
                    break;
            }
            this.huH = new StaticLayout(evt(), textPaint, i2, alignment, 0.0f, 0.0f, false);
            this.offset = Float.MIN_VALUE;
            AppMethodBeat.o(219904);
        }

        /* access modifiers changed from: package-private */
        public final int getHeight() {
            AppMethodBeat.i(219905);
            if (this.huH == null) {
                AppMethodBeat.o(219905);
                return 0;
            }
            int height = this.huH.getHeight();
            AppMethodBeat.o(219905);
            return height;
        }

        private String evt() {
            AppMethodBeat.i(219906);
            if (!TextUtils.isEmpty(this.AoT)) {
                String str = this.text + "\n" + this.AoT;
                AppMethodBeat.o(219906);
                return str;
            }
            String str2 = this.text;
            AppMethodBeat.o(219906);
            return str2;
        }
    }

    public MusicPlayerLyricView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        AppMethodBeat.i(219907);
        init(null);
        AppMethodBeat.o(219907);
    }

    public MusicPlayerLyricView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(219908);
        this.Aor = new ArrayList();
        this.Aos = new TextPaint();
        this.Aot = new TextPaint();
        this.Aox = 256;
        this.AoA = 256;
        this.AoC = 256;
        this.textPadding = 0;
        this.textSize = (int) this.Aow;
        this.AoM = 0;
        this.isInit = false;
        this.AoN = 0;
        this.AoO = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 24);
        this.lineHeight = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 52);
        this.AoP = new GestureDetector.SimpleOnGestureListener() {
            /* class com.tencent.mm.plugin.music.ui.view.MusicPlayerLyricView.AnonymousClass2 */

            public final boolean onContextClick(MotionEvent motionEvent) {
                AppMethodBeat.i(219901);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onContextClick = super.onContextClick(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onContextClick, this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(219901);
                return onContextClick;
            }

            public final boolean onDoubleTap(MotionEvent motionEvent) {
                AppMethodBeat.i(219900);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onDoubleTap = super.onDoubleTap(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onDoubleTap, this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(219900);
                return onDoubleTap;
            }

            public final void onLongPress(MotionEvent motionEvent) {
                AppMethodBeat.i(219899);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V", this, bVar.axR());
                super.onLongPress(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", e.a.NAME, "(Landroid/view/MotionEvent;)V");
                AppMethodBeat.o(219899);
            }

            public final boolean onSingleTapUp(MotionEvent motionEvent) {
                AppMethodBeat.i(219898);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, bVar.axR());
                boolean onSingleTapUp = super.onSingleTapUp(motionEvent);
                com.tencent.mm.hellhoundlib.a.a.a(onSingleTapUp, this, "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView$2", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(219898);
                return onSingleTapUp;
            }

            public final boolean onDown(MotionEvent motionEvent) {
                AppMethodBeat.i(219894);
                if (!MusicPlayerLyricView.this.evp() || MusicPlayerLyricView.this.AoI == null) {
                    boolean onDown = super.onDown(motionEvent);
                    AppMethodBeat.o(219894);
                    return onDown;
                }
                MusicPlayerLyricView.this.mScroller.forceFinished(true);
                MusicPlayerLyricView.this.removeCallbacks(MusicPlayerLyricView.this.AoQ);
                MusicPlayerLyricView.this.AmY = true;
                MusicPlayerLyricView.this.AoK = true;
                MusicPlayerLyricView.this.invalidate();
                AppMethodBeat.o(219894);
                return true;
            }

            public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                AppMethodBeat.i(219895);
                if (MusicPlayerLyricView.this.evp()) {
                    MusicPlayerLyricView.this.yYt += -f3;
                    MusicPlayerLyricView.this.yYt = Math.min(MusicPlayerLyricView.this.yYt, MusicPlayerLyricView.c(MusicPlayerLyricView.this, 0));
                    MusicPlayerLyricView.this.yYt = Math.max(MusicPlayerLyricView.this.yYt, MusicPlayerLyricView.c(MusicPlayerLyricView.this, MusicPlayerLyricView.this.Aor.size() - 1));
                    MusicPlayerLyricView.this.invalidate();
                    AppMethodBeat.o(219895);
                    return true;
                }
                boolean onScroll = super.onScroll(motionEvent, motionEvent2, f2, f3);
                AppMethodBeat.o(219895);
                return onScroll;
            }

            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                AppMethodBeat.i(219896);
                if (MusicPlayerLyricView.this.evp()) {
                    MusicPlayerLyricView.this.mScroller.fling(0, (int) MusicPlayerLyricView.this.yYt, 0, (int) f3, 0, 0, (int) MusicPlayerLyricView.c(MusicPlayerLyricView.this, MusicPlayerLyricView.this.Aor.size() - 1), (int) MusicPlayerLyricView.c(MusicPlayerLyricView.this, 0));
                    MusicPlayerLyricView.this.xbw = true;
                    AppMethodBeat.o(219896);
                    return true;
                }
                boolean onFling = super.onFling(motionEvent, motionEvent2, f2, f3);
                AppMethodBeat.o(219896);
                return onFling;
            }

            public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                AppMethodBeat.i(219897);
                if (MusicPlayerLyricView.this.evp() && MusicPlayerLyricView.this.AoK) {
                    int d2 = MusicPlayerLyricView.d(MusicPlayerLyricView.this, (int) motionEvent.getY());
                    MusicPlayerLyricView.this.Aor.get(d2);
                    MusicPlayerLyricView.j(MusicPlayerLyricView.this);
                    if (MusicPlayerLyricView.this.AoI != null && MusicPlayerLyricView.this.AoI.evu()) {
                        MusicPlayerLyricView.this.AoK = false;
                        MusicPlayerLyricView.this.removeCallbacks(MusicPlayerLyricView.this.AoQ);
                        MusicPlayerLyricView.this.AoJ = d2;
                        MusicPlayerLyricView.this.invalidate();
                        AppMethodBeat.o(219897);
                        return true;
                    }
                }
                boolean onSingleTapConfirmed = super.onSingleTapConfirmed(motionEvent);
                AppMethodBeat.o(219897);
                return onSingleTapConfirmed;
            }
        };
        this.AoQ = new Runnable() {
            /* class com.tencent.mm.plugin.music.ui.view.MusicPlayerLyricView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(219902);
                if (MusicPlayerLyricView.this.evp() && MusicPlayerLyricView.this.AoK) {
                    MusicPlayerLyricView.this.AoK = false;
                    MusicPlayerLyricView.b(MusicPlayerLyricView.this, MusicPlayerLyricView.this.AoJ);
                }
                AppMethodBeat.o(219902);
            }
        };
        init(attributeSet);
        AppMethodBeat.o(219908);
    }

    @TargetApi(3)
    private void init(AttributeSet attributeSet) {
        AppMethodBeat.i(219909);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.C1531a.LrcView);
        this.Aoz = obtainStyledAttributes.getDimension(9, getResources().getDimension(R.dimen.aae));
        this.Aow = obtainStyledAttributes.getDimension(5, getResources().getDimension(R.dimen.aae));
        if (this.Aow == 0.0f) {
            this.Aow = this.Aoz;
        }
        this.AoM = this.AoO;
        int integer = getResources().getInteger(R.integer.n);
        this.mAnimationDuration = (long) obtainStyledAttributes.getInt(0, integer);
        this.mAnimationDuration = this.mAnimationDuration < 0 ? (long) integer : this.mAnimationDuration;
        this.Aov = obtainStyledAttributes.getColor(4, getResources().getColor(R.color.y3));
        this.Aoy = obtainStyledAttributes.getColor(1, getResources().getColor(R.color.y2));
        this.AoB = obtainStyledAttributes.getColor(14, getResources().getColor(R.color.y6));
        this.AoG = obtainStyledAttributes.getString(3);
        this.AoG = TextUtils.isEmpty(this.AoG) ? getContext().getString(R.string.enh) : this.AoG;
        this.AoH = 0.0f;
        this.AoD = obtainStyledAttributes.getColor(12, getResources().getColor(R.color.y5));
        float dimension = obtainStyledAttributes.getDimension(13, getResources().getDimension(R.dimen.aah));
        this.AoE = obtainStyledAttributes.getColor(10, getResources().getColor(R.color.y4));
        float dimension2 = obtainStyledAttributes.getDimension(11, getResources().getDimension(R.dimen.aaf));
        this.AoL = obtainStyledAttributes.getInteger(8, 1);
        obtainStyledAttributes.recycle();
        this.AoF = (int) getResources().getDimension(R.dimen.aag);
        this.Aos.setAntiAlias(true);
        this.Aos.setTextSize((float) this.textSize);
        this.Aos.setTextAlign(Paint.Align.LEFT);
        this.Aot.setAntiAlias(true);
        this.Aot.setTextSize(dimension2);
        this.Aot.setTextAlign(Paint.Align.CENTER);
        this.Aot.setStrokeWidth(dimension);
        this.Aot.setStrokeCap(Paint.Cap.ROUND);
        this.Aou = this.Aot.getFontMetrics();
        this.mDJ = new GestureDetector(getContext(), this.AoP);
        this.mDJ.setIsLongpressEnabled(false);
        this.mScroller = new Scroller(getContext());
        evq();
        AppMethodBeat.o(219909);
    }

    public void setNormalTextSize(float f2) {
        this.Aow = f2;
    }

    public void setCurrentTextSize(float f2) {
        this.Aoz = f2;
    }

    public void setTimeTextColor(int i2) {
        AppMethodBeat.i(219910);
        this.AoE = i2;
        postInvalidate();
        AppMethodBeat.o(219910);
    }

    public final boolean evp() {
        AppMethodBeat.i(219911);
        if (!this.Aor.isEmpty()) {
            AppMethodBeat.o(219911);
            return true;
        }
        AppMethodBeat.o(219911);
        return false;
    }

    public void setCurrentTime(final long j2) {
        AppMethodBeat.i(219912);
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.music.ui.view.MusicPlayerLyricView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(219893);
                if (!MusicPlayerLyricView.this.evp()) {
                    AppMethodBeat.o(219893);
                    return;
                }
                int a2 = MusicPlayerLyricView.a(MusicPlayerLyricView.this, j2);
                if (a2 != MusicPlayerLyricView.this.AoJ) {
                    MusicPlayerLyricView.this.AoJ = a2;
                    if (!MusicPlayerLyricView.this.AoK) {
                        MusicPlayerLyricView.b(MusicPlayerLyricView.this, a2);
                        AppMethodBeat.o(219893);
                        return;
                    }
                    MusicPlayerLyricView.this.invalidate();
                }
                AppMethodBeat.o(219893);
            }
        };
        if (Looper.myLooper() == Looper.getMainLooper()) {
            r0.run();
            AppMethodBeat.o(219912);
            return;
        }
        post(r0);
        AppMethodBeat.o(219912);
    }

    @Override // android.support.v7.widget.AppCompatTextView
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(219913);
        super.onLayout(z, i2, i3, i4, i5);
        if (z) {
            evq();
            if (evp()) {
                s(this.AoJ, 0);
            }
        }
        AppMethodBeat.o(219913);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(219914);
        super.onSizeChanged(i2, i3, i4, i5);
        this.height = i3;
        this.width = i2;
        AppMethodBeat.o(219914);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        float f2 = 0.0f;
        AppMethodBeat.i(219915);
        super.onDraw(canvas);
        if (this.height == 0 || this.width == 0) {
            this.height = getMeasuredHeight();
            this.width = getMeasuredWidth();
        }
        int i2 = this.lineHeight;
        if (this.Amv == null) {
            this.Aos.setColor(this.Aoy);
            a(canvas, new StaticLayout(this.AoG, this.Aos, (int) getLrcWidth(), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false), (float) i2);
            AppMethodBeat.o(219915);
            return;
        }
        evq();
        int centerLine = getCenterLine();
        if (this.AoK) {
            this.Aot.setColor(this.AoE);
            long j2 = this.Aor.get(centerLine).timestamp;
            canvas.drawText(String.format(Locale.getDefault(), "%02d", Integer.valueOf((int) (j2 / Util.MILLSECONDS_OF_MINUTE))) + ":" + String.format(Locale.getDefault(), "%02d", Integer.valueOf((int) ((j2 / 1000) % 60))), (float) (this.width - this.AoF), ((float) i2) - ((this.Aou.descent + this.Aou.ascent) / 2.0f), this.Aot);
        }
        canvas.translate(0.0f, this.yYt);
        for (int i3 = 0; i3 < this.Aor.size(); i3++) {
            if (i3 > 0) {
                f2 += (float) (((this.Aor.get(i3).getHeight() + this.Aor.get(i3 - 1).getHeight()) >> 1) + this.AoM);
            }
            if (i3 == this.AoJ) {
                this.Aos.setTextSize(this.Aoz);
                this.Aos.setColor(this.Aoy);
                this.Aos.setFakeBoldText(true);
                this.Aos.setAlpha(this.AoA);
            } else if (!this.AoK || i3 != centerLine) {
                this.Aos.setShader(null);
                this.Aos.setFakeBoldText(false);
                this.Aos.setTextSize(this.Aow);
                this.Aos.setColor(this.Aov);
                this.Aos.setAlpha(this.Aox);
            } else {
                this.Aos.setShader(null);
                this.Aos.setColor(this.AoB);
                this.Aos.setAlpha(this.AoC);
            }
            a(canvas, this.Aor.get(i3).huH, f2);
        }
        AppMethodBeat.o(219915);
    }

    private void a(Canvas canvas, StaticLayout staticLayout, float f2) {
        AppMethodBeat.i(219916);
        canvas.save();
        canvas.translate(this.AoH, f2 - ((float) (staticLayout.getHeight() >> 1)));
        staticLayout.draw(canvas);
        canvas.restore();
        AppMethodBeat.o(219916);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(219917);
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.AmY = false;
            if (evp() && !this.xbw) {
                evr();
                postDelayed(this.AoQ, 1000);
            }
        }
        GestureDetector gestureDetector = this.mDJ;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(motionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, bl.axQ(), "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        boolean a2 = com.tencent.mm.hellhoundlib.a.a.a(gestureDetector, gestureDetector.onTouchEvent((MotionEvent) bl.pG(0)), "com/tencent/mm/plugin/music/ui/view/MusicPlayerLyricView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(219917);
        return a2;
    }

    public void computeScroll() {
        AppMethodBeat.i(219918);
        if (this.mScroller.computeScrollOffset()) {
            this.yYt = (float) this.mScroller.getCurrY();
            invalidate();
        }
        if (this.xbw && this.mScroller.isFinished()) {
            this.xbw = false;
            if (evp() && !this.AmY) {
                evr();
                postDelayed(this.AoQ, 1000);
            }
        }
        AppMethodBeat.o(219918);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(219919);
        removeCallbacks(this.AoQ);
        super.onDetachedFromWindow();
        AppMethodBeat.o(219919);
    }

    public void setLyricObj(com.tencent.mm.plugin.music.model.e eVar) {
        AppMethodBeat.i(219920);
        this.Amv = eVar;
        invalidate();
        AppMethodBeat.o(219920);
    }

    private void evq() {
        AppMethodBeat.i(219921);
        if (evp() || this.width == 0 || this.isInit) {
            AppMethodBeat.o(219921);
        } else if (this.Amv == null) {
            Log.e("MicroMsg.Music.MusicPlayerLyricView", "null == lyricObj, maybe you not setLyricObj, check ！！！");
            AppMethodBeat.o(219921);
        } else {
            for (int i2 = 0; i2 < this.Amv.Akn.size(); i2++) {
                e.a SQ = this.Amv.SQ(i2);
                if (!SQ.isEmpty()) {
                    a aVar = new a(SQ.timestamp, SQ.content);
                    aVar.a(this.Aos, (int) getLrcWidth(), this.AoL);
                    this.Aor.add(aVar);
                }
            }
            this.yYt = (float) this.lineHeight;
            this.isInit = true;
            AppMethodBeat.o(219921);
        }
    }

    private void evr() {
        AppMethodBeat.i(219922);
        s(getCenterLine(), 100);
        AppMethodBeat.o(219922);
    }

    private static void evs() {
        AppMethodBeat.i(219923);
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            declaredField.setFloat(null, 1.0f);
            AppMethodBeat.o(219923);
        } catch (Exception e2) {
            AppMethodBeat.o(219923);
        }
    }

    private void s(int i2, long j2) {
        AppMethodBeat.i(219924);
        float Tg = Tg(i2);
        endAnimation();
        this.dgN = ValueAnimator.ofFloat(this.yYt, Tg);
        this.dgN.setDuration(j2);
        this.dgN.setInterpolator(new LinearInterpolator());
        this.dgN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.music.ui.view.MusicPlayerLyricView.AnonymousClass4 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(219903);
                MusicPlayerLyricView.this.yYt = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                MusicPlayerLyricView.this.invalidate();
                AppMethodBeat.o(219903);
            }
        });
        evs();
        this.dgN.start();
        AppMethodBeat.o(219924);
    }

    private void endAnimation() {
        AppMethodBeat.i(219925);
        if (this.dgN != null && this.dgN.isRunning()) {
            this.dgN.end();
        }
        AppMethodBeat.o(219925);
    }

    private int getCenterLine() {
        float f2;
        AppMethodBeat.i(219926);
        float f3 = Float.MAX_VALUE;
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.Aor.size()) {
            if (Math.abs(this.yYt - Tg(i2)) < f3) {
                f2 = Math.abs(this.yYt - Tg(i2));
                i3 = i2;
            } else {
                f2 = f3;
            }
            i2++;
            f3 = f2;
        }
        AppMethodBeat.o(219926);
        return i3;
    }

    private float Tg(int i2) {
        AppMethodBeat.i(219927);
        if (this.Aor.get(i2).offset == Float.MIN_VALUE) {
            float f2 = (float) this.lineHeight;
            for (int i3 = 1; i3 <= i2; i3++) {
                f2 -= (float) (((this.Aor.get(i3).getHeight() + this.Aor.get(i3 - 1).getHeight()) >> 1) + this.AoM);
            }
            this.Aor.get(i2).offset = f2;
        }
        float f3 = this.Aor.get(i2).offset;
        AppMethodBeat.o(219927);
        return f3;
    }

    private float getLrcWidth() {
        return ((float) this.width) - (this.AoH * 2.0f);
    }

    static /* synthetic */ int a(MusicPlayerLyricView musicPlayerLyricView, long j2) {
        AppMethodBeat.i(219928);
        int size = musicPlayerLyricView.Aor.size();
        int i2 = 0;
        while (i2 <= size) {
            int i3 = (i2 + size) / 2;
            if (j2 < musicPlayerLyricView.Aor.get(i3).timestamp) {
                size = i3 - 1;
            } else if (i3 + 1 >= musicPlayerLyricView.Aor.size() || j2 < musicPlayerLyricView.Aor.get(i3 + 1).timestamp) {
                AppMethodBeat.o(219928);
                return i3;
            } else {
                i2 = i3 + 1;
            }
        }
        AppMethodBeat.o(219928);
        return 0;
    }

    static /* synthetic */ void b(MusicPlayerLyricView musicPlayerLyricView, int i2) {
        AppMethodBeat.i(219929);
        musicPlayerLyricView.s(i2, musicPlayerLyricView.mAnimationDuration);
        AppMethodBeat.o(219929);
    }

    static /* synthetic */ int d(MusicPlayerLyricView musicPlayerLyricView, int i2) {
        float f2;
        AppMethodBeat.i(219931);
        float f3 = Float.MAX_VALUE;
        int i3 = musicPlayerLyricView.lineHeight - i2;
        int i4 = 0;
        int i5 = 0;
        while (i4 < musicPlayerLyricView.Aor.size()) {
            if (Math.abs((musicPlayerLyricView.yYt + ((float) i3)) - musicPlayerLyricView.Tg(i4)) < f3) {
                f2 = Math.abs((musicPlayerLyricView.yYt + ((float) i3)) - musicPlayerLyricView.Tg(i4));
                i5 = i4;
            } else {
                f2 = f3;
            }
            i4++;
            f3 = f2;
        }
        AppMethodBeat.o(219931);
        return i5;
    }
}
