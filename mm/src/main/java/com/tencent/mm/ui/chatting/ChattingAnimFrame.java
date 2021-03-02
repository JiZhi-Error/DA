package com.tencent.mm.ui.chatting;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.e;
import com.tencent.mm.bb.l;
import com.tencent.mm.bb.o;
import com.tencent.mm.plugin.eggspring.c;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChattingAnimFrame extends FrameLayout {
    private static String qZH = "";
    private int DAQ = 30;
    private boolean PfA;
    private float PfB;
    private float PfC;
    private float PfD;
    private float PfE;
    private Interpolator PfF;
    private Interpolator PfG;
    private int PfH;
    private int PfI;
    private ValueAnimator PfJ;
    private ValueAnimator.AnimatorUpdateListener PfK = new ValueAnimator.AnimatorUpdateListener() {
        /* class com.tencent.mm.ui.chatting.ChattingAnimFrame.AnonymousClass1 */

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.i(34356);
            if (!ChattingAnimFrame.this.qVe) {
                AppMethodBeat.o(34356);
                return;
            }
            if (ChattingAnimFrame.this.PfF == null) {
                ChattingAnimFrame.this.PfF = new LinearInterpolator();
            }
            if (ChattingAnimFrame.this.PfG == null) {
                ChattingAnimFrame.this.PfG = new LinearInterpolator();
            }
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (ChattingAnimFrame.this.PfH == 2) {
                ChattingAnimFrame.this.PfE = (float) (ChattingAnimFrame.this.aYO - ChattingAnimFrame.this.PfI);
            } else if (ChattingAnimFrame.this.PfH == 3) {
                ChattingAnimFrame.this.PfD = ((float) ChattingAnimFrame.this.aYO) * ChattingAnimFrame.this.mf;
                ChattingAnimFrame.this.PfE = ((float) ChattingAnimFrame.this.aYO) * ChattingAnimFrame.this.mh;
            }
            float interpolation = ChattingAnimFrame.this.PfB + ((ChattingAnimFrame.this.PfC - ChattingAnimFrame.this.PfB) * ChattingAnimFrame.this.PfF.getInterpolation(floatValue));
            float interpolation2 = ChattingAnimFrame.this.PfD + ((ChattingAnimFrame.this.PfE - ChattingAnimFrame.this.PfD) * ChattingAnimFrame.this.PfG.getInterpolation(floatValue));
            if (ChattingAnimFrame.this.Pfv != null) {
                ChattingAnimFrame.this.Pfv.setX(interpolation);
                ChattingAnimFrame.this.Pfv.setY(interpolation2);
                if (!ChattingAnimFrame.this.Pfz && floatValue > ChattingAnimFrame.this.Pfy) {
                    Log.d("MicroMsg.ChattingAnimFrame", "luckyBagYAnim, y: %s, 1: %s, 2: %s.", Float.valueOf(floatValue), Float.valueOf(ChattingAnimFrame.this.Pfy), Float.valueOf(ChattingAnimFrame.this.Pfy * 2.0f));
                    Log.d("MicroMsg.ChattingAnimFrame", "lucky bag rotate 1.");
                    ChattingAnimFrame.this.Pfz = true;
                    ChattingAnimFrame.u(ChattingAnimFrame.this);
                }
                if (!ChattingAnimFrame.this.PfA && floatValue > ChattingAnimFrame.this.Pfy * 3.0f) {
                    Log.d("MicroMsg.ChattingAnimFrame", "luckyBagYAnim, y: %s, 1: %s, 2: %s.", Float.valueOf(floatValue), Float.valueOf(ChattingAnimFrame.this.Pfy), Float.valueOf(ChattingAnimFrame.this.Pfy * 2.0f));
                    Log.d("MicroMsg.ChattingAnimFrame", "lucky bag rotate 2.");
                    ChattingAnimFrame.this.PfA = true;
                    ChattingAnimFrame.u(ChattingAnimFrame.this);
                }
            }
            AppMethodBeat.o(34356);
        }
    };
    private Animator.AnimatorListener PfL = new Animator.AnimatorListener() {
        /* class com.tencent.mm.ui.chatting.ChattingAnimFrame.AnonymousClass2 */

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(232849);
            Log.i("MicroMsg.ChattingAnimFrame", "onAnimationStart: luckyBag");
            if (ChattingAnimFrame.this.PfH == 1) {
                ChattingAnimFrame.this.PfD = ((float) ChattingAnimFrame.this.aYO) * ChattingAnimFrame.this.mf;
                ChattingAnimFrame.this.PfE = (float) (-ChattingAnimFrame.this.PfI);
            }
            AppMethodBeat.o(232849);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(34357);
            Log.i("MicroMsg.ChattingAnimFrame", "onAnimationEnd: luckBag");
            if (ChattingAnimFrame.this.qVe) {
                ChattingAnimFrame.x(ChattingAnimFrame.this);
            }
            AppMethodBeat.o(34357);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    };
    private e PfM;
    private ObjectAnimator PfN;
    private View.OnClickListener PfO = new View.OnClickListener() {
        /* class com.tencent.mm.ui.chatting.ChattingAnimFrame.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(34358);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChattingAnimFrame$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.ChattingAnimFrame", "lucky bag click!!!");
            c.a aVar = com.tencent.mm.plugin.eggspring.c.qUO;
            com.tencent.mm.plugin.eggspring.c.qUN.FE(4);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(500);
            alphaAnimation.setFillAfter(false);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                /* class com.tencent.mm.ui.chatting.ChattingAnimFrame.AnonymousClass3.AnonymousClass1 */

                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(162382);
                    ((Vibrator) ChattingAnimFrame.this.getContext().getSystemService("vibrator")).vibrate(500);
                    if (ChattingAnimFrame.this.PfP != null) {
                        ChattingAnimFrame.this.PfP.a(ChattingAnimFrame.this.qVj, ChattingAnimFrame.this.PfM);
                    }
                    AppMethodBeat.o(162382);
                }

                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(162383);
                    ChattingAnimFrame.x(ChattingAnimFrame.this);
                    AppMethodBeat.o(162383);
                }

                public final void onAnimationRepeat(Animation animation) {
                }
            });
            ChattingAnimFrame.this.Pfv.startAnimation(alphaAnimation);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChattingAnimFrame$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(34358);
        }
    };
    private d PfP;
    List<MMAnimateView> Pfq = new ArrayList();
    private int Pfr = 30;
    private boolean Pfs = false;
    private int Pft = 0;
    private ArrayList<Integer> Pfu = new ArrayList<>();
    private MMAnimateView Pfv;
    private int Pfw = com.tencent.mm.cb.a.fromDPToPix(getContext(), 60);
    private int Pfx = com.tencent.mm.cb.a.fromDPToPix(getContext(), 80);
    private float Pfy = 0.2f;
    private boolean Pfz;
    private int aYN;
    private int aYO;
    int cBY = 0;
    private int mMaxSize = 40;
    private int mScreenHeight = com.tencent.mm.cb.a.jo(getContext());
    private int mScreenWidth = com.tencent.mm.cb.a.jn(getContext());

    /* renamed from: me  reason: collision with root package name */
    private float f1550me;
    private float mf;
    private float mg;
    private float mh;
    private boolean qVe;
    private com.tencent.mm.plugin.eggspring.c.c qVj;

    public interface d {
        void a(com.tencent.mm.plugin.eggspring.c.c cVar, e eVar);
    }

    static /* synthetic */ void x(ChattingAnimFrame chattingAnimFrame) {
        AppMethodBeat.i(232857);
        chattingAnimFrame.gNs();
        AppMethodBeat.o(232857);
    }

    private static String getDataEmojiPath() {
        AppMethodBeat.i(34370);
        if (Util.isNullOrNil(qZH)) {
            qZH = com.tencent.mm.loader.j.b.aKC().replace("/data/user/0", "/data/data");
            qZH += "/emoji";
        }
        String str = qZH;
        AppMethodBeat.o(34370);
        return str;
    }

    public ChattingAnimFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(34371);
        AppMethodBeat.o(34371);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(34372);
        super.onFinishInflate();
        this.aYO = getMeasuredHeight();
        this.aYN = getMeasuredWidth();
        Log.d("MicroMsg.ChattingAnimFrame", "onFinishInflate width:%d height:%d", Integer.valueOf(this.aYN), Integer.valueOf(this.aYO));
        AppMethodBeat.o(34372);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(34373);
        super.onLayout(z, i2, i3, i4, i5);
        this.aYO = i5 - i3;
        this.aYN = i4 - i2;
        if (this.aYO < this.mScreenHeight) {
            this.Pfs = true;
            this.Pft = this.mScreenHeight - this.aYO;
        } else {
            this.Pfs = false;
            this.Pft = 0;
        }
        Log.i("MicroMsg.ChattingAnimFrame", "onLayout width:%d height:%d isKeyBordUp:%b keyBordHeight:%d", Integer.valueOf(this.aYN), Integer.valueOf(this.aYO), Boolean.valueOf(this.Pfs), Integer.valueOf(this.Pft));
        AppMethodBeat.o(34373);
    }

    public final boolean a(e eVar) {
        boolean z;
        long abs;
        AppMethodBeat.i(34374);
        stop();
        if (eVar == null) {
            Log.w("MicroMsg.ChattingAnimFrame", "egg info is null. ignore.");
            AppMethodBeat.o(34374);
            return false;
        }
        int i2 = 0;
        int size = eVar.jgQ.size();
        if (size <= 0) {
            Log.e("MicroMsg.ChattingAnimFrame", "wtf!!! no anim!!!");
            AppMethodBeat.o(34374);
            return false;
        }
        if (1 != size) {
            i2 = new Random().nextInt(size);
            Log.d("MicroMsg.ChattingAnimFrame", "random egg: %s, from %s.", Integer.valueOf(i2), Integer.valueOf(size));
        }
        o oVar = eVar.jgQ.get(i2);
        String str = getDataEmojiPath() + "/egg/" + oVar.fileName;
        if (!s.YS(str)) {
            Log.w("MicroMsg.ChattingAnimFrame", "egg file isn't exist. ignore");
            AppMethodBeat.o(34374);
            return false;
        }
        this.PfM = eVar;
        setVisibility(0);
        if (aa.b(eVar)) {
            h.INSTANCE.dN(1263, 3);
        }
        if (oVar.jhq > 0) {
            this.Pfr = oVar.jhq;
            if (this.Pfr > 60) {
                this.Pfr = 60;
            }
        } else {
            this.Pfr = 30;
        }
        if (oVar.jhr > 0) {
            this.DAQ = oVar.jhr;
        } else {
            this.DAQ = 30;
        }
        if (oVar.maxSize > 0) {
            this.mMaxSize = oVar.maxSize;
        } else {
            this.mMaxSize = 40;
        }
        Log.i("MicroMsg.ChattingAnimFrame", "Egg viewCount:%d minSize:%d maxSize:%d AnimType:%d reportType:%d", Integer.valueOf(this.Pfr), Integer.valueOf(this.DAQ), Integer.valueOf(this.mMaxSize), Integer.valueOf(oVar.jhn), Integer.valueOf(eVar.dYn));
        long j2 = 0;
        amf(this.Pfr);
        for (int i3 = 0; i3 < this.Pfr; i3++) {
            int le = le(this.DAQ, this.mMaxSize);
            int i4 = oVar.jhn;
            if (this.Pfu == null || !this.Pfu.contains(Integer.valueOf(i3))) {
                z = false;
            } else {
                z = true;
            }
            c cVar = new c(i4, le, j2, z);
            MMAnimateView mMAnimateView = new MMAnimateView(getContext());
            mMAnimateView.setImageFilePath(str);
            mMAnimateView.setAnimation(cVar);
            mMAnimateView.setLayerType(2, null);
            mMAnimateView.setVisibility(4);
            cVar.Pgc = mMAnimateView;
            mMAnimateView.setLayoutParams(new FrameLayout.LayoutParams(cVar.mSize, cVar.mSize));
            this.Pfq.add(mMAnimateView);
            this.cBY++;
            Log.i("MicroMsg.ChattingAnimFrame", "addView counter++: [%s]. %s", Integer.valueOf(this.cBY), mMAnimateView);
            addView(mMAnimateView);
            int i5 = oVar.jhn;
            int i6 = this.Pfr;
            switch (i5) {
                case 2:
                    if (i3 < 2) {
                        abs = 800 + j2;
                    } else {
                        abs = ((long) (((Math.abs((((double) i3) - (((double) i6) * 0.5d)) - 5.0d) / ((double) (i6 * 3))) + 0.01d) * 1000.0d)) + j2;
                    }
                    j2 = abs;
                    break;
                case 3:
                    j2 += (long) (((Math.abs((((double) i3) - (((double) i6) * 0.5d)) - 5.0d) / ((double) (i6 * 6))) + 0.06d) * 1000.0d);
                    break;
                default:
                    j2 = (long) ((int) (ak(0.0f, 4.0f) * 1000.0f));
                    break;
            }
        }
        if (this.Pfq != null) {
            for (MMAnimateView mMAnimateView2 : this.Pfq) {
                if (mMAnimateView2 != null && (mMAnimateView2.getAnimation() instanceof c)) {
                    c.a((c) mMAnimateView2.getAnimation());
                }
            }
        }
        AppMethodBeat.o(34374);
        return true;
    }

    private void amf(int i2) {
        AppMethodBeat.i(34375);
        if (i2 <= 0) {
            Log.w("MicroMsg.ChattingAnimFrame", "count is zero.");
            AppMethodBeat.o(34375);
            return;
        }
        int i3 = (int) (((double) i2) * 0.1d);
        if (this.Pfu != null) {
            this.Pfu.clear();
        } else {
            this.Pfu = new ArrayList<>();
        }
        while (this.Pfu.size() < i3) {
            int ak = (int) ak(0.0f, (float) i2);
            if (!this.Pfu.contains(Integer.valueOf(ak))) {
                this.Pfu.add(Integer.valueOf(ak));
            }
        }
        AppMethodBeat.o(34375);
    }

    public final void stop() {
        AppMethodBeat.i(34376);
        Log.i("MicroMsg.ChattingAnimFrame", "stop: view: %s, count:%s", Integer.valueOf(this.Pfq.size()), Integer.valueOf(this.cBY));
        for (MMAnimateView mMAnimateView : this.Pfq) {
            mMAnimateView.clearAnimation();
            mMAnimateView.recycle();
            removeView(mMAnimateView);
            Log.i("MicroMsg.ChattingAnimFrame", "stop: remove view %s", mMAnimateView);
        }
        this.Pfq.clear();
        gNs();
        this.cBY = 0;
        Log.i("MicroMsg.ChattingAnimFrame", "stop: end child count %s", Integer.valueOf(getChildCount()));
        AppMethodBeat.o(34376);
    }

    static float ak(float f2, float f3) {
        AppMethodBeat.i(34377);
        float random = (((float) Math.random()) * (f3 - f2)) + f2;
        AppMethodBeat.o(34377);
        return random;
    }

    private static float j(float f2, float f3) {
        AppMethodBeat.i(232852);
        float max = Math.max(0.1f, Math.min(f2, f3));
        AppMethodBeat.o(232852);
        return max;
    }

    private int le(int i2, int i3) {
        AppMethodBeat.i(232853);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(getContext(), (int) ak((float) i2, (float) i3));
        AppMethodBeat.o(232853);
        return fromDPToPix;
    }

    class b extends Animation {
        private View.OnLayoutChangeListener OCV = new View.OnLayoutChangeListener() {
            /* class com.tencent.mm.ui.chatting.ChattingAnimFrame.b.AnonymousClass1 */

            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                AppMethodBeat.i(34359);
                b.this.resolve();
                AppMethodBeat.o(34359);
            }
        };
        private float PfS;
        private float PfT;
        private float PfU;
        private float PfV;
        private float PfW;
        private float PfX;
        private int PfY = 0;
        private boolean PfZ = false;
        private float mFromX;
        private float mFromY;
        private boolean mIsRunning = false;
        private int mSize = 0;
        private float mToX;
        private float mToY;

        public b(int i2, int i3) {
            AppMethodBeat.i(34360);
            this.PfY = i2;
            this.mSize = i3;
            this.PfZ = false;
            AppMethodBeat.o(34360);
        }

        public b(int i2, int i3, boolean z) {
            AppMethodBeat.i(34361);
            this.PfY = i2;
            this.mSize = i3;
            this.PfZ = z;
            AppMethodBeat.o(34361);
        }

        public final void initialize(int i2, int i3, int i4, int i5) {
            AppMethodBeat.i(34362);
            super.initialize(i2, i3, i4, i5);
            switch (this.PfY) {
                case 1:
                    this.mFromX = ChattingAnimFrame.ak(0.1f, 0.9f);
                    this.mToX = ChattingAnimFrame.ak(this.mFromX - 0.25f, this.mFromX + 0.25f);
                    this.mFromY = 1.1f;
                    this.mToY = -0.2f;
                    setInterpolator(new LinearInterpolator());
                    break;
                case 2:
                    this.mFromX = 0.0f;
                    this.mToX = 0.0f;
                    this.mFromY = 0.0f;
                    this.mToY = 1.0f;
                    setInterpolator(new com.tencent.mm.ui.c.b.a());
                    break;
                case 3:
                    this.mFromX = 0.0f;
                    this.mToX = 0.0f;
                    this.mFromY = 1.5f;
                    if (this.PfZ) {
                        this.mToY = ChattingAnimFrame.ak(0.4f, 0.55f);
                    } else {
                        this.mToY = ChattingAnimFrame.ak(0.54999995f, 0.85f);
                    }
                    setInterpolator(new com.tencent.mm.ui.c.b.b());
                    break;
                case 4:
                    float ak = ChattingAnimFrame.ak(0.0f, 1.0f - ((((float) this.mSize) * 1.0f) / ((float) ChattingAnimFrame.this.aYO)));
                    this.mFromX = 1.0f;
                    this.mToX = 0.0f - ((((float) this.mSize) * 1.0f) / ((float) ChattingAnimFrame.this.aYN));
                    this.mFromY = ak;
                    this.mToY = ak;
                    setInterpolator(new LinearInterpolator());
                    break;
                case 999:
                    this.mFromX = ChattingAnimFrame.ak(0.1f, 0.9f);
                    this.mToX = ChattingAnimFrame.ak(this.mFromX - 0.5f, this.mFromX + 0.5f);
                    this.mFromY = 0.0f;
                    this.mToY = 0.0f;
                    this.PfW = 0.8f;
                    this.PfX = 1.1f;
                    setInterpolator(new LinearInterpolator());
                    break;
                default:
                    this.mFromX = ChattingAnimFrame.ak(0.1f, 0.9f);
                    this.mToX = ChattingAnimFrame.ak(this.mFromX - 0.5f, this.mFromX + 0.5f);
                    this.mFromY = -0.2f;
                    this.mToY = 1.1f;
                    setInterpolator(new LinearInterpolator());
                    break;
            }
            if (!(this.PfY == 0 || this.PfY == 1)) {
                ChattingAnimFrame.this.addOnLayoutChangeListener(this.OCV);
            }
            resolve();
            AppMethodBeat.o(34362);
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f2, Transformation transformation) {
            AppMethodBeat.i(34363);
            if (f2 > 0.0f && !this.mIsRunning) {
                if (this.PfY == 1) {
                    this.PfU = this.mFromY * ((float) ChattingAnimFrame.this.aYO);
                    this.PfV = this.mToY * ((float) ChattingAnimFrame.this.aYO);
                }
                this.mIsRunning = true;
            }
            float f3 = this.PfS;
            float f4 = this.PfU;
            if (this.PfS != this.PfT) {
                f3 = this.PfS + ((this.PfT - this.PfS) * f2);
            }
            if (this.PfU != this.PfV) {
                f4 = this.PfU + ((this.PfV - this.PfU) * f2);
                if (this.PfY == 2) {
                    f4 -= (float) this.mSize;
                }
            }
            transformation.getMatrix().setTranslate(f3, f4);
            if (this.PfW != this.PfX && 3 == this.PfY) {
                float f5 = this.PfW + ((this.PfX - this.PfW) * f2);
                transformation.getMatrix().postScale(f5, f5);
            }
            AppMethodBeat.o(34363);
        }

        /* access modifiers changed from: protected */
        @Override // java.lang.Object, android.view.animation.Animation
        public final void finalize() {
            AppMethodBeat.i(34364);
            super.finalize();
            Log.i("MicroMsg.ChattingAnimFrame", "finalize!");
            ChattingAnimFrame.this.removeOnLayoutChangeListener(this.OCV);
            AppMethodBeat.o(34364);
        }

        public final void resolve() {
            AppMethodBeat.i(34365);
            this.PfS = this.mFromX * ((float) ChattingAnimFrame.this.aYN);
            this.PfT = this.mToX * ((float) ChattingAnimFrame.this.aYN);
            if (this.PfY == 2) {
                this.PfU = this.mFromY * ((float) ChattingAnimFrame.this.aYO);
                this.PfV = this.mToY * ((float) ChattingAnimFrame.this.aYO);
                AppMethodBeat.o(34365);
                return;
            }
            if (this.PfY == 3) {
                this.PfU = this.mFromY * ((float) ChattingAnimFrame.this.mScreenHeight);
                this.PfV = this.mToY * ((float) ChattingAnimFrame.this.mScreenHeight);
                if (ChattingAnimFrame.this.Pfs) {
                    this.PfU = (this.mFromY * ((float) ChattingAnimFrame.this.mScreenHeight)) - ((float) ChattingAnimFrame.this.Pft);
                    this.PfV = (this.mToY * ((float) ChattingAnimFrame.this.mScreenHeight)) - ((float) ChattingAnimFrame.this.Pft);
                }
                if (this.PfV < 0.0f) {
                    this.PfV = 0.0f;
                    AppMethodBeat.o(34365);
                    return;
                }
            } else if (this.PfY == 4) {
                this.PfU = this.mFromY * ((float) ChattingAnimFrame.this.aYO);
                this.PfV = this.mToY * ((float) ChattingAnimFrame.this.aYO);
                AppMethodBeat.o(34365);
                return;
            } else {
                this.PfU = this.mFromY * ((float) ChattingAnimFrame.this.mScreenHeight);
                this.PfV = this.mToY * ((float) ChattingAnimFrame.this.mScreenHeight);
            }
            AppMethodBeat.o(34365);
        }
    }

    class c extends AnimationSet {
        private long Pgb;
        MMAnimateView Pgc;
        int mSize;

        public c(int i2, int i3, long j2, boolean z) {
            super(false);
            AppMethodBeat.i(34368);
            this.mSize = i3;
            switch (i2) {
                case 0:
                case 1:
                case 4:
                    addAnimation(new b(i2, this.mSize));
                    break;
                case 2:
                    addAnimation(new b(999, this.mSize));
                    addAnimation(new b(i2, this.mSize));
                    break;
                case 3:
                    addAnimation(new b(i2, this.mSize, z));
                    addAnimation(new b(999, this.mSize));
                    break;
                default:
                    addAnimation(new b(0, this.mSize));
                    break;
            }
            setAnimationListener(new a(ChattingAnimFrame.this) {
                /* class com.tencent.mm.ui.chatting.ChattingAnimFrame.c.AnonymousClass1 */

                @Override // com.tencent.mm.ui.chatting.ChattingAnimFrame.a
                public final void onAnimationStart(Animation animation) {
                    AppMethodBeat.i(232851);
                    Log.i("MicroMsg.ChattingAnimFrame", "onAnimationStart: %s", c.this.Pgc);
                    if (c.this.Pgc != null) {
                        c.this.Pgc.postDelayed(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.ChattingAnimFrame.c.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(232850);
                                c.this.Pgc.setVisibility(0);
                                AppMethodBeat.o(232850);
                            }
                        }, c.this.Pgb);
                    }
                    AppMethodBeat.o(232851);
                }

                @Override // com.tencent.mm.ui.chatting.ChattingAnimFrame.a
                public final void onAnimationEnd(Animation animation) {
                    AppMethodBeat.i(34366);
                    Log.i("MicroMsg.ChattingAnimFrame", "onAnimationEnd: %s", c.this.Pgc);
                    c cVar = c.this;
                    if (cVar.Pgc != null) {
                        cVar.Pgc.post(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.ChattingAnimFrame.c.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(34367);
                                if (c.this.Pgc != null) {
                                    c.this.Pgc.clearAnimation();
                                    ChattingAnimFrame chattingAnimFrame = ChattingAnimFrame.this;
                                    MMAnimateView mMAnimateView = c.this.Pgc;
                                    if (!(mMAnimateView == null || chattingAnimFrame.Pfq == null)) {
                                        chattingAnimFrame.cBY--;
                                        Log.i("MicroMsg.ChattingAnimFrame", "remove view counter--: [%s]. %s", Integer.valueOf(chattingAnimFrame.cBY), mMAnimateView);
                                        mMAnimateView.recycle();
                                        mMAnimateView.clearAnimation();
                                        chattingAnimFrame.removeView(mMAnimateView);
                                        chattingAnimFrame.Pfq.remove(mMAnimateView);
                                        if (chattingAnimFrame.cBY <= 0) {
                                            chattingAnimFrame.cBY = 0;
                                        }
                                    }
                                }
                                AppMethodBeat.o(34367);
                            }
                        });
                        AppMethodBeat.o(34366);
                        return;
                    }
                    Log.w("MicroMsg.ChattingAnimFrame", "mTargetView is NULL.");
                    AppMethodBeat.o(34366);
                }
            });
            this.Pgb = 500 + j2;
            reset();
            setDuration(ChattingAnimFrame.amg(i2));
            AppMethodBeat.o(34368);
        }

        static /* synthetic */ void a(c cVar) {
            AppMethodBeat.i(34369);
            cVar.setStartOffset(cVar.Pgb);
            cVar.start();
            AppMethodBeat.o(34369);
        }
    }

    class a implements Animation.AnimationListener {
        a() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public final void gNr() {
        String str;
        AppMethodBeat.i(34379);
        if (this.PfM.gWY != null) {
            o oVar = this.PfM.gWY.jgJ;
            this.PfH = oVar.jhn;
            this.PfI = le(oVar.jhr, oVar.maxSize);
            str = oVar.fileName;
        } else if (this.PfM.uBT != null) {
            o oVar2 = this.PfM.uBT.jgJ;
            this.PfH = oVar2.jhn;
            this.PfI = le(oVar2.jhr, oVar2.maxSize);
            str = oVar2.fileName;
        } else {
            l lVar = this.PfM.gXT.jhm;
            this.PfH = lVar.jhn;
            this.PfI = com.tencent.mm.cb.a.fromDPToPix(getContext(), lVar.size);
            str = lVar.fileName;
        }
        this.Pfw = this.PfI;
        this.Pfx = this.PfI;
        this.f1550me = 0.0f;
        this.mg = (float) this.mScreenWidth;
        this.mf = 0.0f;
        this.mh = (float) this.mScreenHeight;
        float f2 = 0.9f - ((((float) this.PfI) * 1.0f) / ((float) this.mScreenWidth));
        float f3 = (((float) (-this.PfI)) * 1.1f) / ((float) this.mScreenHeight);
        this.PfG = new LinearInterpolator();
        switch (this.PfH) {
            case 1:
                this.f1550me = ak(0.1f, f2);
                this.mg = ak(this.f1550me - 0.25f, this.f1550me + 0.25f);
                this.mg = j(this.mg, f2);
                this.mf = 1.0f;
                this.mh = f3;
                break;
            case 2:
                this.f1550me = ak(0.1f, f2);
                this.mg = ak(this.f1550me - 0.25f, this.f1550me + 0.25f);
                this.mg = j(this.mg, f2);
                this.mf = f3;
                this.mh = 1.0f;
                this.PfG = new com.tencent.mm.ui.c.b.a();
                break;
            case 3:
                this.f1550me = ak(0.1f, f2);
                this.mg = ak(this.f1550me - 0.25f, this.f1550me + 0.25f);
                this.mg = j(this.mg, f2);
                this.mf = 1.5f;
                this.mh = ak(0.25f, 0.55f);
                this.PfG = new com.tencent.mm.ui.c.b.b();
                break;
            case 4:
                float ak = ak(f3, 1.0f - ((((float) this.PfI) * 1.0f) / ((float) this.aYO)));
                this.f1550me = 1.0f;
                this.mg = 0.0f - ((((float) this.PfI) * 1.0f) / ((float) this.mScreenWidth));
                this.mf = ak;
                this.mh = ak;
                break;
            default:
                this.f1550me = ak(0.1f, f2);
                this.mg = ak(this.f1550me - 0.5f, this.f1550me + 0.5f);
                this.mg = j(this.mg, f2);
                this.mf = f3;
                this.mh = 1.0f;
                break;
        }
        Log.i("MicroMsg.ChattingAnimFrame", "luckyBag, s[%s] e[%s].", Float.valueOf(this.f1550me), Float.valueOf(this.mg));
        this.PfB = ((float) this.mScreenWidth) * this.f1550me;
        this.PfC = ((float) this.mScreenWidth) * this.mg;
        this.PfD = ((float) this.mScreenHeight) * this.mf;
        this.PfE = ((float) this.mScreenHeight) * this.mh;
        if (this.PfH == 4) {
            this.PfD = ((float) this.aYO) * this.mf;
            this.PfE = ((float) this.aYO) * this.mh;
        }
        Log.i("MicroMsg.ChattingAnimFrame", "luckyBag, init: startX[%s] endX[%s] startY[%s] endY[%s].", Float.valueOf(this.PfB), Float.valueOf(this.PfC), Float.valueOf(this.PfD), Float.valueOf(this.PfE));
        if (this.Pfv == null) {
            this.Pfv = new MMAnimateView(getContext());
            this.Pfv.setOnClickListener(this.PfO);
        }
        this.Pfv.setPivotX(((float) this.Pfw) / 2.0f);
        this.Pfv.setPivotY(((float) this.Pfx) / 2.0f);
        this.Pfv.setRotation(0.0f);
        this.Pfv.setImageFilePath(getDataEmojiPath() + "/egg/" + str);
        this.Pfv.setLayoutParams(new FrameLayout.LayoutParams(this.Pfw, this.Pfx));
        this.Pfv.setX(this.PfB);
        this.Pfv.setY(this.PfD);
        this.PfJ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.PfJ.setDuration((long) ((int) ak(7000.0f, 10000.0f)));
        this.PfJ.setInterpolator(new LinearInterpolator());
        this.PfJ.addUpdateListener(this.PfK);
        this.PfJ.setStartDelay(1500);
        this.PfJ.addListener(this.PfL);
        this.PfN = ObjectAnimator.ofFloat(this.Pfv, View.ROTATION, 0.0f, 15.0f, -15.0f, 15.0f, -15.0f, 0.0f);
        this.PfN.setInterpolator(new AccelerateDecelerateInterpolator());
        this.PfN.setDuration(500L);
        this.PfN.setRepeatCount(1);
        this.Pfz = false;
        this.PfA = false;
        AppMethodBeat.o(34379);
    }

    public final void a(com.tencent.mm.plugin.eggspring.c.c cVar) {
        AppMethodBeat.i(232854);
        Log.i("MicroMsg.ChattingAnimFrame", "showLuckyBag: ");
        if (!(this.Pfv == null || this.PfJ == null || this.qVe)) {
            c.a aVar = com.tencent.mm.plugin.eggspring.c.qUO;
            com.tencent.mm.plugin.eggspring.c.qUN.FE(3);
            this.qVe = true;
            this.qVj = cVar;
            addView(this.Pfv);
            Log.i("MicroMsg.ChattingAnimFrame", "lucky bag start anim!!!");
            this.PfJ.start();
            this.Pfv.start();
        }
        AppMethodBeat.o(232854);
    }

    private void gNs() {
        AppMethodBeat.i(160226);
        if (this.Pfv != null && this.qVe) {
            this.Pfv.stop();
            removeView(this.Pfv);
            this.qVe = false;
            this.qVj = null;
            if (this.PfJ != null) {
                this.PfJ.end();
                this.PfJ = null;
            }
            if (this.PfN != null) {
                this.PfN.end();
                this.PfN = null;
            }
            this.Pfv.setRotation(0.0f);
        }
        AppMethodBeat.o(160226);
    }

    public void setOnLuckyBagClick(d dVar) {
        this.PfP = dVar;
    }

    public final boolean gNt() {
        AppMethodBeat.i(160227);
        if (this.PfM == null || this.PfM.type <= 0) {
            AppMethodBeat.o(160227);
            return true;
        } else if (this.cBY > 0 || this.qVe) {
            AppMethodBeat.o(160227);
            return false;
        } else {
            AppMethodBeat.o(160227);
            return true;
        }
    }

    static /* synthetic */ long amg(int i2) {
        AppMethodBeat.i(232855);
        switch (i2) {
            case 2:
                AppMethodBeat.o(232855);
                return 1200;
            case 3:
                AppMethodBeat.o(232855);
                return 1500;
            default:
                long ak = (long) ((int) ak(4000.0f, 6000.0f));
                AppMethodBeat.o(232855);
                return ak;
        }
    }

    static /* synthetic */ void u(ChattingAnimFrame chattingAnimFrame) {
        AppMethodBeat.i(232856);
        if (!(chattingAnimFrame.Pfv == null || chattingAnimFrame.PfN == null || !chattingAnimFrame.qVe)) {
            chattingAnimFrame.PfN.start();
        }
        AppMethodBeat.o(232856);
    }
}
