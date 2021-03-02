package com.tencent.mm.plugin.transvoice.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.v4.view.b.e;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.transvoice.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class SoundWaveView extends View {
    private Interpolator GuA;
    private int GuB;
    private int GuC;
    private int GuD;
    private int GuE;
    private int GuF;
    private int GuG;
    private int GuH;
    private Runnable GuI;
    private int GuJ;
    private a GuK;
    private d Gut;
    private b Guu;
    private ArrayList<Integer> Guv;
    private ArrayList<Integer> Guw;
    private ArrayList<AnimatorSet> Gux;
    private List<List<Float>> Guy;
    private List<List<Float>> Guz;
    private int mHeight;
    private Paint mPaint;
    private int mWidth;

    static /* synthetic */ void a(SoundWaveView soundWaveView) {
        AppMethodBeat.i(185307);
        soundWaveView.aAM();
        AppMethodBeat.o(185307);
    }

    static /* synthetic */ void a(SoundWaveView soundWaveView, float f2, List list) {
        AppMethodBeat.i(186027);
        soundWaveView.a(f2, list);
        AppMethodBeat.o(186027);
    }

    static /* synthetic */ void g(SoundWaveView soundWaveView) {
        AppMethodBeat.i(186028);
        soundWaveView.fAF();
        AppMethodBeat.o(186028);
    }

    /* access modifiers changed from: package-private */
    public static class c {
        static int GuV = 2;
        static int GuW = 1;
        static int GuX = 1;
        static int GuY = 4;
        static int GuZ = 34;
        static int Gva = 10;
        static String Gvb = "#000000";
        static int Gvc = 5;
        static int Gvd = 5;
        static int Gve = 2;
        static int Gvf = 300;
        static int Gvg = 100;
        static int Gvh = 500;
        static int Gvi = 1000;
        static float Gvj = 0.8f;
        static float[] Gvk = {0.8f, 0.6f};
        static float[] Gvl = {0.5f, 0.3f};
        static int Gvm = acu(Gvc);
        static int Gvn = acu(Gvc * Gvd);
        static int Gvo = acu(Gvc * Gve);

        static {
            AppMethodBeat.i(185284);
            AppMethodBeat.o(185284);
        }

        private static int acu(int i2) {
            return ((i2 - 1) * GuW) + (GuV * i2);
        }
    }

    public SoundWaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SoundWaveView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(185288);
        this.Gut = d.NORMAL;
        this.Guu = b.WAITING;
        this.Guy = new ArrayList();
        this.Guz = new ArrayList();
        this.GuI = new Runnable() {
            /* class com.tencent.mm.plugin.transvoice.ui.SoundWaveView.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(185277);
                Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active waiting!!!");
                SoundWaveView.this.Guu = b.WAITING;
                SoundWaveView.a(SoundWaveView.this);
                AppMethodBeat.o(185277);
            }
        };
        this.GuJ = -1;
        this.GuK = new a(this, (byte) 0);
        init(context, attributeSet);
        AppMethodBeat.o(185288);
    }

    private void init(Context context, AttributeSet attributeSet) {
        Interpolator eVar;
        AppMethodBeat.i(185289);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.C1841a.SoundWaveView, 0, 0);
            int i2 = obtainStyledAttributes.getInt(0, d.NORMAL.ordinal());
            if (i2 == d.NORMAL.ordinal()) {
                this.Gut = d.NORMAL;
            } else if (i2 == d.MINI.ordinal()) {
                this.Gut = d.MINI;
            } else {
                Log.e("MicroMsg.NewTrans2Txt.SoundWaveView", "style err! %s", Integer.valueOf(i2));
            }
            obtainStyledAttributes.recycle();
            Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "init style %s", this.Gut);
        }
        this.GuB = at.fromDPToPix(getContext(), c.GuV);
        this.GuC = at.fromDPToPix(getContext(), c.GuW);
        this.GuD = at.fromDPToPix(getContext(), c.GuX);
        this.GuE = at.fromDPToPix(getContext(), c.GuY);
        this.GuF = at.fromDPToPix(getContext(), c.GuZ);
        this.GuG = at.fromDPToPix(getContext(), c.Gva);
        this.GuH = at.fromDPToPix(getContext(), c.Gvm);
        this.mWidth = at.fromDPToPix(getContext(), c.Gvn);
        this.mHeight = at.fromDPToPix(getContext(), c.GuZ);
        this.Guv = new ArrayList<>();
        for (int i3 = 0; i3 < c.Gvd; i3++) {
            this.Guv.add(Integer.valueOf(this.GuE));
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i4 = 0; i4 < c.Gvc; i4++) {
                arrayList.add(Float.valueOf((float) this.GuE));
                arrayList2.add(Float.valueOf((float) this.GuE));
            }
            this.Guy.add(arrayList);
            this.Guz.add(arrayList2);
        }
        this.Guw = new ArrayList<>();
        for (int i5 = 0; i5 < c.Gvc * c.Gvd; i5++) {
            this.Guw.add(Integer.valueOf(this.GuE));
        }
        fAz();
        fAA();
        this.Gux = new ArrayList<>(c.Gvc * c.Gvd);
        if (Build.VERSION.SDK_INT >= 21) {
            eVar = new PathInterpolator(0.0f, 0.5f, 0.2f, 1.0f);
        } else {
            eVar = new e();
        }
        this.GuA = eVar;
        fAG();
        fAD();
        this.mPaint = new Paint(1);
        this.mPaint.setColor(Color.parseColor(c.Gvb));
        this.mPaint.setAlpha(128);
        AppMethodBeat.o(185289);
    }

    private void fAz() {
        AppMethodBeat.i(185290);
        int bundleCount = getBundleCount();
        for (int i2 = 0; i2 < bundleCount; i2++) {
            this.Guv.set(i2, Integer.valueOf(this.GuE));
        }
        AppMethodBeat.o(185290);
    }

    private void fAA() {
        AppMethodBeat.i(185291);
        int volumeItemCount = getVolumeItemCount();
        for (int i2 = 0; i2 < volumeItemCount; i2++) {
            this.Guw.set(i2, Integer.valueOf(this.GuE));
        }
        AppMethodBeat.o(185291);
    }

    private void fAB() {
        AppMethodBeat.i(186024);
        for (List<Float> list : this.Guy) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.set(i2, Float.valueOf((float) this.GuE));
            }
        }
        AppMethodBeat.o(186024);
    }

    private void fAC() {
        AppMethodBeat.i(186025);
        for (List<Float> list : this.Guz) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                list.set(i2, Float.valueOf((float) this.GuE));
            }
        }
        AppMethodBeat.o(186025);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(185292);
        super.onMeasure(i2, i3);
        if (d.MINI == this.Gut) {
            this.mWidth = at.fromDPToPix(getContext(), c.Gvo);
        } else {
            this.mWidth = at.fromDPToPix(getContext(), c.Gvn);
        }
        Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "style: %s, w: %s, h: %s.", this.Gut, Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight));
        setMeasuredDimension(this.mWidth, this.mHeight);
        AppMethodBeat.o(185292);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(185293);
        super.onDraw(canvas);
        if (b.REACTING == this.Guu || b.JUDGING == this.Guu) {
            int bundleCount = getBundleCount();
            for (int i2 = 0; i2 < bundleCount; i2++) {
                this.Guv.get(i2).intValue();
                int i3 = c.Gvc;
                for (int i4 = 0; i4 < i3; i4++) {
                    float floatValue = this.Guz.get(i2).get(i4).floatValue();
                    float floatValue2 = this.Guy.get(i2).get(i4).floatValue();
                    this.Guy.get(i2).set(i4, Float.valueOf(((floatValue - floatValue2) / 6.0f) + floatValue2));
                }
                int i5 = (this.GuH * i2) + (this.GuC * i2);
                for (int i6 = 0; i6 < i3; i6++) {
                    int i7 = (this.GuB * i6) + (this.GuC * i6) + i5;
                    float floatValue3 = this.Guy.get(i2).get(i6).floatValue();
                    if (floatValue3 < ((float) this.GuE)) {
                        floatValue3 = (float) this.GuE;
                    }
                    if (floatValue3 > ((float) this.GuF)) {
                        floatValue3 = (float) this.GuF;
                    }
                    float f2 = (((float) this.mHeight) - floatValue3) / 2.0f;
                    canvas.drawRoundRect((float) i7, f2, (float) (this.GuB + i7), f2 + floatValue3, (float) this.GuD, (float) this.GuD, this.mPaint);
                }
            }
        } else if (b.WAITING == this.Guu) {
            int volumeItemCount = getVolumeItemCount();
            for (int i8 = 0; i8 < volumeItemCount; i8++) {
                int i9 = (this.mWidth - ((i8 + 1) * this.GuB)) - (this.GuC * i8);
                int intValue = (this.mHeight - this.Guw.get(i8).intValue()) / 2;
                canvas.drawRoundRect((float) i9, (float) intValue, (float) (i9 + this.GuB), (float) (this.Guw.get(i8).intValue() + intValue), (float) this.GuD, (float) this.GuD, this.mPaint);
            }
        }
        invalidate();
        AppMethodBeat.o(185293);
    }

    public final void acr(int i2) {
        int i3;
        AppMethodBeat.i(185294);
        float f2 = ((float) i2) / 100.0f;
        Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "iVolume %s, fVolume %s", Integer.valueOf(i2), Float.valueOf(f2));
        if (((double) f2) > 0.05d) {
            if (b.JUDGING == this.Guu) {
                Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "cancel judging!!!");
                this.Guu = b.REACTING;
                removeCallbacks(this.GuI);
            }
            if (b.WAITING == this.Guu) {
                Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "active reacting!!!");
                this.Guu = b.REACTING;
                fAE();
            }
        } else if (b.REACTING == this.Guu) {
            this.Guu = b.JUDGING;
            postDelayed(this.GuI, (long) c.Gvf);
        }
        if (b.REACTING == this.Guu || b.JUDGING == this.Guu) {
            fAz();
            float interpolation = this.GuA.getInterpolation(f2);
            Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "PathInterpolatorCompat value: %s.", Float.valueOf(interpolation));
            int i4 = (int) (interpolation * ((float) this.GuF));
            int activeBundleIndex = getActiveBundleIndex();
            Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, activeBundleIndex: %s", Integer.valueOf(activeBundleIndex));
            this.Guv.set(activeBundleIndex, Integer.valueOf(i4));
            int nextInt = new Random().nextInt(2);
            if (this.GuK.start == activeBundleIndex) {
                this.Guv.set(this.GuK.end, Integer.valueOf((int) (((float) i4) * c.Gvk[nextInt])));
                if (this.GuK.end - 1 != this.GuK.start) {
                    this.Guv.set(this.GuK.end - 1, Integer.valueOf((int) (c.Gvk[1 - nextInt] * ((float) i4))));
                }
            } else if (this.GuK.end == activeBundleIndex) {
                this.Guv.set(this.GuK.start, Integer.valueOf((int) (((float) i4) * c.Gvk[nextInt])));
                if (this.GuK.start + 1 != this.GuK.end) {
                    this.Guv.set(this.GuK.start + 1, Integer.valueOf((int) (c.Gvk[1 - nextInt] * ((float) i4))));
                }
            } else {
                this.Guv.set(this.GuK.start, Integer.valueOf((int) (((float) i4) * c.Gvk[nextInt])));
                this.Guv.set(this.GuK.end, Integer.valueOf((int) (c.Gvk[nextInt] * ((float) i4))));
            }
            int bundleCount = getBundleCount();
            int nextInt2 = new Random().nextInt(2);
            if (bundleCount == c.Gvd) {
                int i5 = bundleCount / 2;
                final int i6 = 0;
                while (i6 < bundleCount) {
                    if (act(i6)) {
                        this.Guv.set(i6, Integer.valueOf((int) (((float) i4) * c.Gvl[nextInt2])));
                        i3 = 1 - nextInt2;
                    } else {
                        i3 = nextInt2;
                    }
                    if (2 == Math.abs(i5 - i6)) {
                        postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.transvoice.ui.SoundWaveView.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(186018);
                                SoundWaveView.a(SoundWaveView.this, (float) ((Integer) SoundWaveView.this.Guv.get(i6)).intValue(), (List) SoundWaveView.this.Guz.get(i6));
                                AppMethodBeat.o(186018);
                            }
                        }, 320);
                    } else if (1 == Math.abs(i5 - i6)) {
                        postDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.transvoice.ui.SoundWaveView.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(186019);
                                SoundWaveView.a(SoundWaveView.this, (float) ((Integer) SoundWaveView.this.Guv.get(i6)).intValue(), (List) SoundWaveView.this.Guz.get(i6));
                                AppMethodBeat.o(186019);
                            }
                        }, 160);
                    } else if (Math.abs(i5 - i6) == 0) {
                        a((float) this.Guv.get(i6).intValue(), this.Guz.get(i6));
                    }
                    i6++;
                    nextInt2 = i3;
                }
            } else {
                int i7 = 0;
                while (i7 < bundleCount) {
                    if (act(i7)) {
                        this.Guv.set(i7, Integer.valueOf((int) (((float) i4) * c.Gvl[nextInt2])));
                        nextInt2 = 1 - nextInt2;
                    }
                    a((float) this.Guv.get(i7).intValue(), this.Guz.get(i7));
                    i7++;
                    nextInt2 = nextInt2;
                }
            }
            invalidate();
        }
        AppMethodBeat.o(185294);
    }

    private void aAM() {
        AppMethodBeat.i(185295);
        this.GuJ = -1;
        fAA();
        fAE();
        fAF();
        AppMethodBeat.o(185295);
    }

    private void a(float f2, final List<Float> list) {
        AppMethodBeat.i(186026);
        int i2 = c.Gvc;
        int i3 = i2 / 2;
        for (final int i4 = 0; i4 < i2; i4++) {
            final float pow = (float) (((double) f2) * Math.pow((double) c.Gvj, (double) Math.abs(i3 - i4)));
            if (2 == Math.abs(i3 - i4)) {
                postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.transvoice.ui.SoundWaveView.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(186020);
                        list.set(i4, Float.valueOf(pow));
                        AppMethodBeat.o(186020);
                    }
                }, 320);
            } else if (1 == Math.abs(i3 - i4)) {
                postDelayed(new Runnable() {
                    /* class com.tencent.mm.plugin.transvoice.ui.SoundWaveView.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(186021);
                        list.set(i4, Float.valueOf(pow));
                        AppMethodBeat.o(186021);
                    }
                }, 160);
            } else if (Math.abs(i3 - i4) == 0) {
                list.set(i4, Float.valueOf(pow));
            }
        }
        AppMethodBeat.o(186026);
    }

    private int getVolumeItemCount() {
        AppMethodBeat.i(185296);
        int bundleCount = getBundleCount() * c.Gvc;
        AppMethodBeat.o(185296);
        return bundleCount;
    }

    private int getBundleCount() {
        int i2 = c.Gvd;
        if (d.MINI == this.Gut) {
            return c.Gve;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public class a {
        int end;
        int start;

        private a() {
            this.start = -1;
            this.end = -1;
        }

        /* synthetic */ a(SoundWaveView soundWaveView, byte b2) {
            this();
        }

        public final String toString() {
            AppMethodBeat.i(185280);
            String str = "start: " + this.start + " end: " + this.end;
            AppMethodBeat.o(185280);
            return str;
        }
    }

    private boolean acs(int i2) {
        return i2 >= this.GuK.start && i2 <= this.GuK.end;
    }

    private boolean act(int i2) {
        AppMethodBeat.i(185297);
        if (!acs(i2)) {
            AppMethodBeat.o(185297);
            return true;
        }
        AppMethodBeat.o(185297);
        return false;
    }

    private void fAD() {
        AppMethodBeat.i(185298);
        this.Gux.clear();
        int volumeItemCount = getVolumeItemCount();
        for (final int i2 = 0; i2 < volumeItemCount; i2++) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setStartDelay((long) (c.Gvg * i2));
            animatorSet.setInterpolator(new LinearInterpolator());
            AnonymousClass6 r4 = new ValueAnimator.AnimatorUpdateListener() {
                /* class com.tencent.mm.plugin.transvoice.ui.SoundWaveView.AnonymousClass6 */

                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(186022);
                    SoundWaveView.this.Guw.set(i2, (Integer) valueAnimator.getAnimatedValue());
                    SoundWaveView.this.invalidate();
                    AppMethodBeat.o(186022);
                }
            };
            ValueAnimator ofInt = ValueAnimator.ofInt(this.GuE, this.GuG);
            ofInt.setDuration((long) c.Gvh);
            ofInt.addUpdateListener(r4);
            ValueAnimator ofInt2 = ValueAnimator.ofInt(this.GuG, this.GuE);
            ofInt2.setDuration((long) c.Gvh);
            ofInt2.addUpdateListener(r4);
            ValueAnimator ofInt3 = ValueAnimator.ofInt(this.GuE, this.GuE);
            ofInt3.setDuration((long) c.Gvi);
            ofInt3.addUpdateListener(r4);
            animatorSet.addListener(new Animator.AnimatorListener() {
                /* class com.tencent.mm.plugin.transvoice.ui.SoundWaveView.AnonymousClass7 */

                public final void onAnimationStart(Animator animator) {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.i(186023);
                    Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "AnimatorSet onAnimationEnd, mode: %s", SoundWaveView.this.Guu);
                    if (b.WAITING == SoundWaveView.this.Guu && i2 == SoundWaveView.this.Gux.size() - 1 && SoundWaveView.this.isShown()) {
                        Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "restart waiting anim!!!");
                        SoundWaveView.g(SoundWaveView.this);
                    }
                    AppMethodBeat.o(186023);
                }

                public final void onAnimationCancel(Animator animator) {
                }

                public final void onAnimationRepeat(Animator animator) {
                }
            });
            animatorSet.playSequentially(ofInt, ofInt2, ofInt3);
            this.Gux.add(animatorSet);
        }
        AppMethodBeat.o(185298);
    }

    private void fAE() {
        AppMethodBeat.i(185299);
        Iterator<AnimatorSet> it = this.Gux.iterator();
        while (it.hasNext()) {
            it.next().end();
        }
        AppMethodBeat.o(185299);
    }

    private void fAF() {
        AppMethodBeat.i(185300);
        Iterator<AnimatorSet> it = this.Gux.iterator();
        while (it.hasNext()) {
            it.next().start();
        }
        AppMethodBeat.o(185300);
    }

    private void fAG() {
        AppMethodBeat.i(185301);
        int bundleCount = getBundleCount();
        int i2 = bundleCount / 2;
        int i3 = i2 + -1 < 0 ? 0 : i2 - 1;
        int i4 = i2 + 1 >= bundleCount ? bundleCount - 1 : i2 + 1;
        this.GuK.start = i3;
        this.GuK.end = i4;
        Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "initBaseBundleGroupInfo: %s", this.GuK.toString());
        AppMethodBeat.o(185301);
    }

    private int getActiveBundleIndex() {
        AppMethodBeat.i(185302);
        Log.d("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, mLastActiveBundleIndex: %s.", Integer.valueOf(this.GuJ));
        if (-1 == this.GuJ) {
            this.GuJ = new Random().nextInt((this.GuK.end - this.GuK.start) + 1) + this.GuK.start;
            int i2 = this.GuJ;
            AppMethodBeat.o(185302);
            return i2;
        }
        int nextInt = new Random().nextInt(3);
        if (1 == nextInt) {
            int i3 = this.GuJ - 1;
            if (act(i3)) {
                i3 = this.GuJ + 1;
                if (act(i3)) {
                    Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", Integer.valueOf(this.GuJ), this.GuK);
                    int i4 = this.GuJ;
                    AppMethodBeat.o(185302);
                    return i4;
                }
            }
            AppMethodBeat.o(185302);
            return i3;
        } else if (2 == nextInt) {
            int i5 = this.GuJ + 1;
            if (act(i5)) {
                i5 = this.GuJ - 1;
                if (act(i5)) {
                    Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "getActiveBundleIndex, keep! %s %s", Integer.valueOf(this.GuJ), this.GuK);
                    int i6 = this.GuJ;
                    AppMethodBeat.o(185302);
                    return i6;
                }
            }
            AppMethodBeat.o(185302);
            return i5;
        } else {
            int i7 = this.GuJ;
            AppMethodBeat.o(185302);
            return i7;
        }
    }

    public enum b {
        WAITING,
        REACTING,
        JUDGING;

        public static b valueOf(String str) {
            AppMethodBeat.i(185282);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(185282);
            return bVar;
        }

        static {
            AppMethodBeat.i(185283);
            AppMethodBeat.o(185283);
        }
    }

    public enum d {
        NORMAL,
        MINI;

        public static d valueOf(String str) {
            AppMethodBeat.i(185286);
            d dVar = (d) Enum.valueOf(d.class, str);
            AppMethodBeat.o(185286);
            return dVar;
        }

        static {
            AppMethodBeat.i(185287);
            AppMethodBeat.o(185287);
        }
    }

    public void setStyle(d dVar) {
        AppMethodBeat.i(185303);
        this.Gut = dVar;
        Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "set style %s", this.Gut);
        AppMethodBeat.o(185303);
    }

    public final void a(d dVar) {
        AppMethodBeat.i(185304);
        this.Gut = dVar;
        fAz();
        fAA();
        fAG();
        fAD();
        Log.i("MicroMsg.NewTrans2Txt.SoundWaveView", "update style %s", this.Gut);
        requestLayout();
        reset();
        AppMethodBeat.o(185304);
    }

    private void reset() {
        AppMethodBeat.i(185305);
        fAB();
        fAC();
        this.Guu = b.WAITING;
        aAM();
        AppMethodBeat.o(185305);
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(185306);
        super.setVisibility(i2);
        if (i2 == 0) {
            reset();
        }
        AppMethodBeat.o(185306);
    }
}
