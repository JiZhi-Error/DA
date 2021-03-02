package com.tencent.mm.plugin.mmsight.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.aa;
import java.util.ArrayList;
import java.util.List;

public class MMSightRecordButton extends FrameLayout {
    private static final int Pw = ViewConfiguration.getTapTimeout();
    private static final float zBj = (((float) MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.ad0)) / ((float) MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.acz)));
    private float aTE = -1.0f;
    private boolean enable = true;
    private MMHandler hAk = new MMHandler(Looper.getMainLooper());
    private Runnable had = new Runnable() {
        /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.AnonymousClass5 */

        public final void run() {
            AppMethodBeat.i(94535);
            Log.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", Boolean.valueOf(MMSightRecordButton.this.zBo), Boolean.valueOf(MMSightRecordButton.this.zBp));
            if (!MMSightRecordButton.this.zBo) {
                MMSightRecordButton.this.zBp = true;
                if (MMSightRecordButton.this.zBB != null) {
                    MMSightRecordButton.this.zBB.jK();
                }
            }
            AppMethodBeat.o(94535);
        }
    };
    private boolean ipv = false;
    private boolean isAnimating = false;
    private View progressBar;
    private boolean tQl = false;
    private d zBA;
    private b zBB;
    private c zBC;
    private a zBD;
    private Drawable zBE;
    private Drawable zBF;
    private boolean zBG = false;
    private boolean zBH = false;
    private Runnable zBI = new Runnable() {
        /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.AnonymousClass6 */

        public final void run() {
            AppMethodBeat.i(94536);
            Log.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", Boolean.valueOf(MMSightRecordButton.this.tQl));
            if (MMSightRecordButton.this.tQl) {
                MMSightRecordButton.g(MMSightRecordButton.this);
            }
            AppMethodBeat.o(94536);
        }
    };
    private boolean zBe = false;
    private long zBk = -1;
    private View zBl;
    private View zBm;
    private MMSightCircularProgressBar zBn;
    private boolean zBo = false;
    private boolean zBp = false;
    private ViewPropertyAnimator zBq;
    private ViewPropertyAnimator zBr;
    private ValueAnimator zBs;
    private ValueAnimator zBt;
    private ViewPropertyAnimator zBu;
    private ViewPropertyAnimator zBv;
    private int zBw;
    private int zBx;
    private int zBy = -1;
    private int zBz = -2130706433;

    public interface a {
        void ekJ();
    }

    public interface b {
        void cJI();

        void cJJ();

        void jK();
    }

    public interface c {
        void Gt(int i2);

        void Gu(int i2);
    }

    public interface d {
        void cJK();
    }

    static /* synthetic */ void a(MMSightRecordButton mMSightRecordButton, int i2) {
        AppMethodBeat.i(187094);
        super.setVisibility(i2);
        AppMethodBeat.o(187094);
    }

    static /* synthetic */ void a(MMSightRecordButton mMSightRecordButton, AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(187093);
        mMSightRecordButton.f(animatorListenerAdapter);
        AppMethodBeat.o(187093);
    }

    static /* synthetic */ void g(MMSightRecordButton mMSightRecordButton) {
        AppMethodBeat.i(187095);
        mMSightRecordButton.ekH();
        AppMethodBeat.o(187095);
    }

    static {
        AppMethodBeat.i(94555);
        AppMethodBeat.o(94555);
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(94538);
        init();
        AppMethodBeat.o(94538);
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(94539);
        init();
        AppMethodBeat.o(94539);
    }

    private void init() {
        AppMethodBeat.i(94540);
        Log.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", 500, Integer.valueOf(Pw));
        this.zBE = getContext().getResources().getDrawable(R.drawable.ait);
        this.zBF = getContext().getResources().getDrawable(R.drawable.aiu);
        aa.jQ(getContext()).inflate(R.layout.bat, (ViewGroup) this, true);
        this.zBl = findViewById(R.id.dyg);
        this.zBm = findViewById(R.id.g7o);
        this.progressBar = findViewById(R.id.gl_);
        this.zBn = (MMSightCircularProgressBar) findViewById(R.id.b34);
        this.zBl.setBackgroundDrawable(this.zBE);
        this.zBm.setBackgroundDrawable(this.zBF);
        this.enable = true;
        AppMethodBeat.o(94540);
    }

    public void setHighLightOuter(int i2) {
        AppMethodBeat.i(94541);
        this.zBx = i2;
        if (this.zBF instanceof GradientDrawable) {
            ((GradientDrawable) this.zBF).setColor(i2);
        }
        AppMethodBeat.o(94541);
    }

    public void setInnerColor(int i2) {
        AppMethodBeat.i(94542);
        if (this.zBE instanceof GradientDrawable) {
            ((GradientDrawable) this.zBE).setColor(i2);
        }
        AppMethodBeat.o(94542);
    }

    public void setSimpleTapCallback(d dVar) {
        this.zBA = dVar;
    }

    public void setLongPressCallback(b bVar) {
        this.zBB = bVar;
    }

    public void setLongPressScrollCallback(c cVar) {
        this.zBC = cVar;
    }

    public void setErrorPressCallback(a aVar) {
        this.zBD = aVar;
    }

    public void setTouchEnable(boolean z) {
        AppMethodBeat.i(94543);
        Log.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", Boolean.valueOf(z));
        this.enable = z;
        AppMethodBeat.o(94543);
    }

    public final void showLoading() {
        AppMethodBeat.i(187084);
        Log.i("MicroMsg.MMSightRecordButton", "showLoading");
        this.progressBar.setVisibility(0);
        AppMethodBeat.o(187084);
    }

    public final void ekF() {
        AppMethodBeat.i(94545);
        Log.i("MicroMsg.MMSightRecordButton", "hideProgressBar");
        this.progressBar.setVisibility(8);
        AppMethodBeat.o(94545);
    }

    public final void rk(boolean z) {
        AppMethodBeat.i(187085);
        this.zBe = z;
        this.zBn.setEnableSubProgress(z);
        this.zBn.setCircularColor(Color.parseColor("#00000000"));
        if (z) {
            this.zBn.setVisibility(4);
            AppMethodBeat.o(187085);
            return;
        }
        this.zBn.reset();
        this.zBn.setVisibility(0);
        AppMethodBeat.o(187085);
    }

    public final void ekG() {
        AppMethodBeat.i(187086);
        this.zBn.setVisibility(0);
        AppMethodBeat.o(187086);
    }

    public final void QS(int i2) {
        AppMethodBeat.i(187087);
        int size = this.zBn.getSubProgress().size();
        if (size > 0 && i2 != size) {
            MMSightCircularProgressBar mMSightCircularProgressBar = this.zBn;
            if (mMSightCircularProgressBar.zBc.size() > 0) {
                mMSightCircularProgressBar.zBc.remove(mMSightCircularProgressBar.zBc.size() - 1);
                if (mMSightCircularProgressBar.zBc.size() > 0) {
                    mMSightCircularProgressBar.zAX = mMSightCircularProgressBar.zBc.get(mMSightCircularProgressBar.zBc.size() - 1).floatValue();
                } else {
                    mMSightCircularProgressBar.zAX = 0.0f;
                }
                mMSightCircularProgressBar.invalidate();
            }
        }
        AppMethodBeat.o(187087);
    }

    public List<Float> getSubProgress() {
        AppMethodBeat.i(187088);
        ArrayList<Float> subProgress = this.zBn.getSubProgress();
        AppMethodBeat.o(187088);
        return subProgress;
    }

    public final void rl(boolean z) {
        AppMethodBeat.i(187089);
        MMSightCircularProgressBar mMSightCircularProgressBar = this.zBn;
        mMSightCircularProgressBar.zBg = z;
        mMSightCircularProgressBar.postInvalidate();
        AppMethodBeat.o(187089);
    }

    public final void a(int i2, int i3, final MMSightCircularProgressBar.a aVar) {
        AppMethodBeat.i(94546);
        Log.printInfoStack("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", 0, 100, Integer.valueOf(i2), aVar);
        this.ipv = true;
        this.zBn.setInitProgress(0);
        this.zBn.setMaxProgress(100);
        this.zBn.setDuration(i2);
        if (!this.zBe) {
            this.zBn.setVisibility(0);
        }
        this.zBn.setCircularColor(i3);
        this.zBn.setProgressCallback(new MMSightCircularProgressBar.a() {
            /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a
            public final void lK(final boolean z) {
                AppMethodBeat.i(187082);
                Log.printInfoStack("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
                MMSightRecordButton.this.hideProgress();
                MMSightRecordButton.a(MMSightRecordButton.this, new AnimatorListenerAdapter() {
                    /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.AnonymousClass1.AnonymousClass1 */

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(94528);
                        Log.printInfoStack("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
                        MMSightRecordButton.this.ipv = false;
                        if (aVar != null) {
                            aVar.lK(z);
                        }
                        AppMethodBeat.o(94528);
                    }
                });
                AppMethodBeat.o(187082);
            }

            @Override // com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.a
            public final void Z(ArrayList<Float> arrayList) {
                AppMethodBeat.i(187083);
                if (aVar != null) {
                    aVar.Z(arrayList);
                }
                AppMethodBeat.o(187083);
            }
        });
        MMSightCircularProgressBar mMSightCircularProgressBar = this.zBn;
        Log.i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s currentProgress:%s", Integer.valueOf(mMSightCircularProgressBar.zAY), Integer.valueOf(mMSightCircularProgressBar.zAZ), Integer.valueOf(mMSightCircularProgressBar.duration), Float.valueOf(mMSightCircularProgressBar.zAX));
        mMSightCircularProgressBar.isStart = true;
        if (mMSightCircularProgressBar.zBa != null) {
            mMSightCircularProgressBar.zBa.cancel();
            mMSightCircularProgressBar.zBa = null;
        }
        mMSightCircularProgressBar.zBa = new c(mMSightCircularProgressBar.zAX, (float) mMSightCircularProgressBar.zAZ, mMSightCircularProgressBar.duration);
        c cVar = mMSightCircularProgressBar.zBa;
        MMSightCircularProgressBar.AnonymousClass1 r2 = 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00a4: CONSTRUCTOR  (r2v3 'r2' com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar$1) = (r0v8 'mMSightCircularProgressBar' com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar) call: com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar.1.<init>(com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar):void type: CONSTRUCTOR in method: com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.a(int, int, com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar$a):void, file: classes7.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar, state: GENERATED_AND_UNLOADED
            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
            	... 14 more
            */
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.a(int, int, com.tencent.mm.plugin.mmsight.ui.MMSightCircularProgressBar$a):void");
    }

    public final void hideProgress() {
        AppMethodBeat.i(94547);
        if (this.zBe) {
            MMSightCircularProgressBar mMSightCircularProgressBar = this.zBn;
            if (mMSightCircularProgressBar.zBa != null) {
                mMSightCircularProgressBar.zBa.cancel();
                mMSightCircularProgressBar.zBa = null;
            }
            if (mMSightCircularProgressBar.zAX > 0.0f && ((mMSightCircularProgressBar.zBc.size() > 0 && mMSightCircularProgressBar.zAX > mMSightCircularProgressBar.zBc.get(mMSightCircularProgressBar.zBc.size() - 1).floatValue()) || mMSightCircularProgressBar.zBc.size() == 0)) {
                mMSightCircularProgressBar.zBc.add(Float.valueOf(mMSightCircularProgressBar.zAX));
            }
            mMSightCircularProgressBar.invalidate();
            AppMethodBeat.o(94547);
            return;
        }
        this.zBn.reset();
        this.zBn.setVisibility(8);
        AppMethodBeat.o(94547);
    }

    private void ekH() {
        AppMethodBeat.i(187090);
        Log.d("MicroMsg.MMSightRecordButton", "startTransition");
        this.isAnimating = true;
        if (this.zBq != null) {
            this.zBq.cancel();
            this.zBq = null;
        }
        this.zBq = this.zBl.animate().scaleX(0.5f).scaleY(0.5f);
        this.zBq.setListener(new AnimatorListenerAdapter(null) {
            /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.AnonymousClass2 */
            final /* synthetic */ AnimatorListenerAdapter zBN = null;

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(94530);
                MMSightRecordButton.this.isAnimating = true;
                if (this.zBN != null) {
                    this.zBN.onAnimationStart(animator);
                }
                AppMethodBeat.o(94530);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(94531);
                MMSightRecordButton.this.isAnimating = false;
                if (this.zBN != null) {
                    this.zBN.onAnimationEnd(animator);
                }
                AppMethodBeat.o(94531);
            }
        }).setDuration(150).start();
        if (this.zBr != null) {
            this.zBr.cancel();
            this.zBr = null;
        }
        this.zBr = this.zBm.animate().scaleX(zBj).scaleY(zBj);
        this.zBr.setDuration(150).start();
        if (this.zBx != this.zBw) {
            if (this.zBs != null) {
                this.zBs.cancel();
            }
            this.zBs = ObjectAnimator.ofInt(this.zBF, "color", this.zBx, this.zBw);
            this.zBs.setDuration(150L);
            this.zBs.setEvaluator(a.getInstance());
            this.zBs.start();
        }
        if (this.zBt != null) {
            this.zBt.cancel();
        }
        this.zBt = ObjectAnimator.ofInt(this.zBE, "color", this.zBy, this.zBz);
        this.zBt.setDuration(150L);
        this.zBt.setEvaluator(a.getInstance());
        this.zBt.start();
        AppMethodBeat.o(187090);
    }

    private void f(final AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(94548);
        this.isAnimating = true;
        if (this.zBu != null) {
            this.zBu.cancel();
            this.zBu = null;
        }
        this.zBu = this.zBl.animate().scaleX(1.0f).scaleY(1.0f);
        this.zBu.setListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.AnonymousClass3 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(94532);
                MMSightRecordButton.this.isAnimating = true;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationStart(animator);
                }
                AppMethodBeat.o(94532);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(94533);
                MMSightRecordButton.this.isAnimating = false;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
                AppMethodBeat.o(94533);
            }
        }).setDuration(150).start();
        this.zBv = this.zBm.animate().scaleX(1.0f).scaleY(1.0f);
        this.zBv.setDuration(150).start();
        if (this.zBt != null) {
            this.zBt.cancel();
        }
        this.zBt = ObjectAnimator.ofInt(this.zBE, "color", this.zBz, this.zBy);
        this.zBt.setDuration(150L);
        this.zBt.setEvaluator(a.getInstance());
        this.zBt.start();
        if (this.zBx != this.zBw) {
            if (this.zBs != null) {
                this.zBs.cancel();
            }
            this.zBs = ObjectAnimator.ofInt(this.zBF, "color", this.zBw, this.zBx);
            this.zBs.setDuration(150L);
            this.zBs.setEvaluator(a.getInstance());
            this.zBs.start();
        }
        AppMethodBeat.o(94548);
    }

    public void setVisibility(final int i2) {
        AppMethodBeat.i(94549);
        Log.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", Boolean.valueOf(this.isAnimating));
        if (this.isAnimating) {
            postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(94534);
                    MMSightRecordButton.a(MMSightRecordButton.this, i2);
                    AppMethodBeat.o(94534);
                }
            }, 150);
            AppMethodBeat.o(94549);
            return;
        }
        super.setVisibility(i2);
        AppMethodBeat.o(94549);
    }

    public final void reset() {
        AppMethodBeat.i(94550);
        setClipChildren(false);
        this.enable = true;
        this.zBl.setScaleX(1.0f);
        this.zBl.setScaleY(1.0f);
        this.zBm.setScaleX(1.0f);
        this.zBm.setScaleY(1.0f);
        this.progressBar.setVisibility(8);
        hideProgress();
        this.zBn.reset();
        AppMethodBeat.o(94550);
    }

    public final void stopRecord() {
        AppMethodBeat.i(187091);
        if (this.ipv && !this.tQl) {
            MotionEvent obtain = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);
            obtain.setAction(3);
            onTouchEvent(obtain);
        }
        AppMethodBeat.o(187091);
    }

    public final boolean ekI() {
        AppMethodBeat.i(187092);
        if (!this.zBe || getSubProgress().isEmpty()) {
            AppMethodBeat.o(187092);
            return true;
        }
        AppMethodBeat.o(187092);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(94551);
        if (!this.enable) {
            Log.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
            AppMethodBeat.o(94551);
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                if (!this.ipv || this.zBe) {
                    this.tQl = true;
                    this.zBk = System.currentTimeMillis();
                    this.zBo = false;
                    this.zBp = false;
                    this.aTE = motionEvent.getRawY();
                    if (this.zBB != null && !this.ipv) {
                        this.zBB.cJJ();
                    }
                    this.hAk.removeCallbacksAndMessages(null);
                    if (!this.ipv) {
                        this.hAk.postDelayed(this.had, 550);
                        this.hAk.postDelayed(this.zBI, 250);
                    }
                    this.zBH = true;
                    this.zBG = true;
                    break;
                } else {
                    AppMethodBeat.o(94551);
                    return false;
                }
                break;
            case 1:
            case 3:
                this.tQl = false;
                this.hAk.removeCallbacks(this.zBI, Integer.valueOf(Pw));
                this.hAk.removeCallbacks(this.had);
                if (!(this.zBq == null || this.zBr == null)) {
                    this.zBq.cancel();
                    this.zBr.cancel();
                }
                final long currentTimeMillis = System.currentTimeMillis() - this.zBk;
                Log.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", Boolean.valueOf(this.zBp), Boolean.valueOf(this.zBo), Long.valueOf(this.zBk), Long.valueOf(currentTimeMillis));
                hideProgress();
                f(new AnimatorListenerAdapter() {
                    /* class com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton.AnonymousClass7 */

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(94537);
                        if (MMSightRecordButton.this.zBk > 0 && currentTimeMillis <= 500 && !MMSightRecordButton.this.zBp) {
                            Log.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", Boolean.valueOf(MMSightRecordButton.this.zBo), Boolean.valueOf(MMSightRecordButton.this.zBp));
                            MMSightRecordButton.this.zBo = true;
                            if (!MMSightRecordButton.this.zBp) {
                                MMSightRecordButton.j(MMSightRecordButton.this);
                                if (MMSightRecordButton.this.zBA != null) {
                                    MMSightRecordButton.this.zBA.cJK();
                                    AppMethodBeat.o(94537);
                                    return;
                                }
                            }
                        } else if (MMSightRecordButton.this.zBp) {
                            Log.i("MicroMsg.MMSightRecordButton", "on Long Press finish ，isRecordIng:%b", Boolean.valueOf(MMSightRecordButton.this.ipv));
                            if (MMSightRecordButton.this.ipv) {
                                MMSightRecordButton.this.ipv = false;
                            }
                            if (MMSightRecordButton.this.zBB != null) {
                                MMSightRecordButton.this.zBB.cJI();
                                AppMethodBeat.o(94537);
                                return;
                            }
                        } else {
                            Log.i("MicroMsg.MMSightRecordButton", "error action up");
                            if (MMSightRecordButton.this.ipv) {
                                MMSightRecordButton.j(MMSightRecordButton.this);
                            }
                            if (MMSightRecordButton.this.zBD != null) {
                                MMSightRecordButton.this.zBD.ekJ();
                            }
                        }
                        AppMethodBeat.o(94537);
                    }
                });
                break;
            case 2:
                float rawY = motionEvent.getRawY();
                int[] iArr = new int[2];
                getLocationInWindow(iArr);
                if (rawY < ((float) iArr[1]) && (this.zBp || !this.zBe)) {
                    if (this.aTE > 0.0f) {
                        float abs = Math.abs(rawY - this.aTE);
                        if (rawY >= this.aTE || abs < 10.0f) {
                            if (rawY > this.aTE && abs >= 10.0f) {
                                int i2 = (int) (abs / 10.0f);
                                Log.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", Integer.valueOf(i2), Boolean.valueOf(this.zBH));
                                int min = Math.min(i2, 3);
                                if (this.zBC != null) {
                                    c cVar = this.zBC;
                                    if (this.zBH) {
                                        min = 1;
                                    }
                                    cVar.Gu(min);
                                }
                                this.zBH = false;
                                this.aTE = rawY;
                                break;
                            }
                        } else {
                            int i3 = (int) (abs / 10.0f);
                            Log.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", Integer.valueOf(i3), Boolean.valueOf(this.zBG));
                            int min2 = Math.min(i3, 3);
                            if (this.zBC != null) {
                                c cVar2 = this.zBC;
                                if (this.zBG) {
                                    min2 = 1;
                                }
                                cVar2.Gt(min2);
                            }
                            this.aTE = rawY;
                            this.zBG = false;
                            break;
                        }
                    } else {
                        this.aTE = motionEvent.getRawY();
                        break;
                    }
                }
                break;
        }
        AppMethodBeat.o(94551);
        return true;
    }

    static /* synthetic */ void j(MMSightRecordButton mMSightRecordButton) {
        AppMethodBeat.i(187096);
        if (mMSightRecordButton.zBe) {
            if (!mMSightRecordButton.ipv) {
                mMSightRecordButton.ipv = true;
                mMSightRecordButton.ekH();
                mMSightRecordButton.zBp = true;
                if (mMSightRecordButton.zBB != null) {
                    mMSightRecordButton.zBB.jK();
                    AppMethodBeat.o(187096);
                    return;
                }
            } else {
                mMSightRecordButton.ipv = false;
                mMSightRecordButton.zBB.cJI();
            }
        }
        AppMethodBeat.o(187096);
    }
}
