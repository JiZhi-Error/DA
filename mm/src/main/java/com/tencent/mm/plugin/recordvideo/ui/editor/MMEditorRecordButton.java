package com.tencent.mm.plugin.recordvideo.ui.editor;

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
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.ar;

public class MMEditorRecordButton extends FrameLayout {
    private static final int Pw = ViewConfiguration.getTapTimeout();
    private static final float zBj = (((float) MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.bz)) / ((float) MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.cr)));
    private ImageView CdG;
    private MMEditorCircularProgressBar CdH;
    private d CdI;
    private b CdJ;
    private c CdK;
    private a CdL;
    private Drawable CdM;
    private float aTE = -1.0f;
    private boolean enable = true;
    private MMHandler hAk = new MMHandler(Looper.getMainLooper());
    private Runnable had = new Runnable() {
        /* class com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton.AnonymousClass3 */

        public final void run() {
            AppMethodBeat.i(237218);
            Log.i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", Boolean.valueOf(MMEditorRecordButton.this.zBo), Boolean.valueOf(MMEditorRecordButton.this.zBp));
            if (!MMEditorRecordButton.this.zBo) {
                MMEditorRecordButton.this.zBp = true;
                if (MMEditorRecordButton.this.CdJ != null) {
                    MMEditorRecordButton.this.CdJ.jK();
                }
            }
            AppMethodBeat.o(237218);
        }
    };
    private boolean isAnimating = false;
    private boolean tQl = false;
    private Drawable zBE;
    private Drawable zBF;
    private boolean zBG = false;
    private boolean zBH = false;
    private Runnable zBI = new Runnable() {
        /* class com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton.AnonymousClass4 */

        public final void run() {
            AppMethodBeat.i(237219);
            Log.i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", Boolean.valueOf(MMEditorRecordButton.this.tQl));
            if (MMEditorRecordButton.this.tQl) {
                MMEditorRecordButton.f(MMEditorRecordButton.this);
            }
            AppMethodBeat.o(237219);
        }
    };
    private boolean zBe = false;
    private long zBk = -1;
    private View zBl;
    private View zBm;
    private boolean zBo = false;
    private boolean zBp = false;
    private ViewPropertyAnimator zBr;
    private ValueAnimator zBs;
    private ViewPropertyAnimator zBu;
    private ViewPropertyAnimator zBv;
    private int zBw;
    private int zBx;
    private int zBy = -1;
    private int zBz = -2130706433;

    public interface a {
    }

    public interface b {
        void cJI();

        void jK();
    }

    public interface c {
    }

    public interface d {
    }

    static /* synthetic */ void a(MMEditorRecordButton mMEditorRecordButton, int i2) {
        AppMethodBeat.i(237232);
        super.setVisibility(i2);
        AppMethodBeat.o(237232);
    }

    static {
        AppMethodBeat.i(237234);
        AppMethodBeat.o(237234);
    }

    public MMEditorRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(237221);
        init();
        AppMethodBeat.o(237221);
    }

    public MMEditorRecordButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(237222);
        init();
        AppMethodBeat.o(237222);
    }

    private void init() {
        AppMethodBeat.i(237223);
        Log.i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", 500, Integer.valueOf(Pw));
        this.zBE = getContext().getResources().getDrawable(R.drawable.ain);
        this.zBF = getContext().getResources().getDrawable(R.drawable.aio);
        this.CdM = ar.m(getContext(), R.raw.icons_filled_mike, getResources().getColor(R.color.Orange));
        this.zBw = Color.parseColor("#FFDDDDDD");
        this.zBx = Color.parseColor("#4CFA9D3B");
        aa.jQ(getContext()).inflate(R.layout.bao, (ViewGroup) this, true);
        this.CdG = (ImageView) findViewById(R.id.dyi);
        this.zBl = findViewById(R.id.dyg);
        this.zBm = findViewById(R.id.g7o);
        this.CdH = (MMEditorCircularProgressBar) findViewById(R.id.b34);
        this.CdG.setImageDrawable(this.CdM);
        this.zBl.setBackground(this.zBE);
        this.zBm.setBackground(this.zBF);
        this.enable = true;
        AppMethodBeat.o(237223);
    }

    public void setHighLightOuter(int i2) {
        AppMethodBeat.i(237224);
        this.zBx = i2;
        if (this.zBF instanceof GradientDrawable) {
            ((GradientDrawable) this.zBF).setColor(i2);
        }
        AppMethodBeat.o(237224);
    }

    public void setInnerColor(int i2) {
        AppMethodBeat.i(237225);
        if (this.zBE instanceof GradientDrawable) {
            ((GradientDrawable) this.zBE).setColor(i2);
        }
        AppMethodBeat.o(237225);
    }

    public void setSimpleTapCallback(d dVar) {
        this.CdI = dVar;
    }

    public void setLongPressCallback(b bVar) {
        this.CdJ = bVar;
    }

    public void setLongPressScrollCallback(c cVar) {
        this.CdK = cVar;
    }

    public void setErrorPressCallback(a aVar) {
        this.CdL = aVar;
    }

    public void setTouchEnable(boolean z) {
        AppMethodBeat.i(237226);
        Log.i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", Boolean.valueOf(z));
        this.enable = z;
        AppMethodBeat.o(237226);
    }

    public final void VU(int i2) {
        AppMethodBeat.i(237227);
        Log.printInfoStack("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s", Float.valueOf(0.0f), Float.valueOf(100.0f));
        this.CdH.setCircularColor(i2);
        this.CdH.setMaxProgress(100.0f);
        this.CdH.setCurrentProgress(0.0f);
        this.CdH.setVisibility(0);
        AppMethodBeat.o(237227);
    }

    public final void bi(float f2) {
        AppMethodBeat.i(237228);
        this.CdH.setCurrentProgress(f2);
        AppMethodBeat.o(237228);
    }

    public void setVisibility(final int i2) {
        AppMethodBeat.i(237229);
        Log.i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", Boolean.valueOf(this.isAnimating));
        if (this.isAnimating) {
            postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton.AnonymousClass2 */

                public final void run() {
                    AppMethodBeat.i(237217);
                    MMEditorRecordButton.a(MMEditorRecordButton.this, i2);
                    AppMethodBeat.o(237217);
                }
            }, 150);
            AppMethodBeat.o(237229);
            return;
        }
        super.setVisibility(i2);
        AppMethodBeat.o(237229);
    }

    public final void stopRecord() {
        AppMethodBeat.i(237230);
        if (this.tQl) {
            MotionEvent obtain = MotionEvent.obtain(0, 0, 0, 0.0f, 0.0f, 0);
            obtain.setAction(3);
            onTouchEvent(obtain);
        }
        AppMethodBeat.o(237230);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(237231);
        if (!this.enable) {
            Log.i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
            AppMethodBeat.o(237231);
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.tQl = true;
                this.zBk = System.currentTimeMillis();
                this.zBo = false;
                this.zBp = false;
                this.aTE = motionEvent.getRawY();
                this.hAk.removeCallbacksAndMessages(null);
                this.hAk.postDelayed(this.had, 550);
                this.hAk.postDelayed(this.zBI, 250);
                this.zBH = true;
                this.zBG = true;
                break;
            case 1:
            case 3:
                this.tQl = false;
                this.hAk.removeCallbacks(this.zBI, Integer.valueOf(Pw));
                this.hAk.removeCallbacks(this.had);
                final long currentTimeMillis = System.currentTimeMillis() - this.zBk;
                Log.i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", Boolean.valueOf(this.zBp), Boolean.valueOf(this.zBo), Long.valueOf(this.zBk), Long.valueOf(currentTimeMillis));
                final AnonymousClass5 r4 = new AnimatorListenerAdapter() {
                    /* class com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton.AnonymousClass5 */

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(237220);
                        if (MMEditorRecordButton.this.zBk > 0 && currentTimeMillis <= 500 && !MMEditorRecordButton.this.zBp) {
                            Log.i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", Boolean.valueOf(MMEditorRecordButton.this.zBo), Boolean.valueOf(MMEditorRecordButton.this.zBp));
                            MMEditorRecordButton.this.zBo = true;
                            if (!MMEditorRecordButton.this.zBp && MMEditorRecordButton.this.CdI != null) {
                                d unused = MMEditorRecordButton.this.CdI;
                                AppMethodBeat.o(237220);
                                return;
                            }
                        } else if (!MMEditorRecordButton.this.zBp) {
                            Log.i("MicroMsg.MMSightRecordButton", "error action up");
                            if (MMEditorRecordButton.this.CdL != null) {
                                a unused2 = MMEditorRecordButton.this.CdL;
                            }
                        } else if (MMEditorRecordButton.this.CdJ != null) {
                            MMEditorRecordButton.this.CdJ.cJI();
                            AppMethodBeat.o(237220);
                            return;
                        }
                        AppMethodBeat.o(237220);
                    }
                };
                this.isAnimating = true;
                if (this.zBu != null) {
                    this.zBu.cancel();
                    this.zBu = null;
                }
                this.zBu = this.zBl.animate().scaleX(1.0f).scaleY(1.0f);
                this.zBu.setListener(new AnimatorListenerAdapter() {
                    /* class com.tencent.mm.plugin.recordvideo.ui.editor.MMEditorRecordButton.AnonymousClass1 */

                    public final void onAnimationStart(Animator animator) {
                        AppMethodBeat.i(237215);
                        MMEditorRecordButton.this.isAnimating = true;
                        if (r4 != null) {
                            r4.onAnimationStart(animator);
                        }
                        AppMethodBeat.o(237215);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(237216);
                        MMEditorRecordButton.this.isAnimating = false;
                        if (r4 != null) {
                            r4.onAnimationEnd(animator);
                        }
                        AppMethodBeat.o(237216);
                    }
                }).setDuration(150).start();
                this.zBv = this.zBm.animate().scaleX(1.0f).scaleY(1.0f);
                this.zBv.setDuration(150).start();
                if (this.zBx != this.zBw) {
                    if (this.zBs != null) {
                        this.zBs.cancel();
                    }
                    this.zBs = ObjectAnimator.ofArgb(this.zBF, "color", this.zBx, this.zBw);
                    this.zBs.setDuration(150L);
                    this.zBs.start();
                    break;
                }
                break;
            case 2:
                float rawY = motionEvent.getRawY();
                int[] iArr = new int[2];
                getLocationInWindow(iArr);
                if (rawY < ((float) iArr[1]) && (this.zBp || !this.zBe)) {
                    if (this.aTE <= 0.0f) {
                        this.aTE = motionEvent.getRawY();
                    } else {
                        float abs = Math.abs(rawY - this.aTE);
                        if (rawY < this.aTE && abs >= 10.0f) {
                            int i2 = (int) (abs / 10.0f);
                            Log.d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", Integer.valueOf(i2), Boolean.valueOf(this.zBG));
                            Math.min(i2, 3);
                            this.aTE = rawY;
                            this.zBG = false;
                        } else if (rawY > this.aTE && abs >= 10.0f) {
                            int i3 = (int) (abs / 10.0f);
                            Log.d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", Integer.valueOf(i3), Boolean.valueOf(this.zBH));
                            Math.min(i3, 3);
                            this.zBH = false;
                            this.aTE = rawY;
                        }
                    }
                    if (this.CdJ != null) {
                    }
                }
                break;
        }
        AppMethodBeat.o(237231);
        return true;
    }

    static /* synthetic */ void f(MMEditorRecordButton mMEditorRecordButton) {
        AppMethodBeat.i(237233);
        Log.d("MicroMsg.MMSightRecordButton", "startTransition");
        mMEditorRecordButton.isAnimating = true;
        if (mMEditorRecordButton.zBr != null) {
            mMEditorRecordButton.zBr.cancel();
            mMEditorRecordButton.zBr = null;
        }
        mMEditorRecordButton.zBr = mMEditorRecordButton.zBm.animate().scaleX(zBj).scaleY(zBj);
        mMEditorRecordButton.zBr.setDuration(150).start();
        if (mMEditorRecordButton.zBx != mMEditorRecordButton.zBw) {
            if (mMEditorRecordButton.zBs != null) {
                mMEditorRecordButton.zBs.cancel();
            }
            mMEditorRecordButton.zBs = ObjectAnimator.ofArgb(mMEditorRecordButton.zBF, "color", mMEditorRecordButton.zBw, mMEditorRecordButton.zBx);
            mMEditorRecordButton.zBs.setDuration(150L);
            mMEditorRecordButton.zBs.start();
        }
        AppMethodBeat.o(237233);
    }
}
