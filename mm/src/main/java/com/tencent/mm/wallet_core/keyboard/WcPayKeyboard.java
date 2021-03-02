package com.tencent.mm.wallet_core.keyboard;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.LayoutListenerView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;

public class WcPayKeyboard extends RelativeLayout {
    private TextView RrZ;
    private TextView Rsa;
    private TextView Rsb;
    private TextView Rsc;
    private TextView Rsd;
    private TextView Rse;
    private TextView Rsf;
    private TextView Rsg;
    private TextView Rsh;
    private TextView Rsi;
    private TextView Rsj;
    private TextView Rsk;
    private View Rsl;
    private ViewGroup Rsm;
    private LinearLayout Rsn;
    private WcPayKeyboardAnimationActionButton Rso;
    private View Rsp;
    private b Rsq = b.INIT_STATE;
    private a Rsr;
    private boolean Rss = false;
    private ObjectAnimator Rst = null;
    private ObjectAnimator Rsu = null;
    public EditText mInputEditText;
    private TextView nAB;

    public interface a {
        void bO(float f2);
    }

    static /* synthetic */ void a(WcPayKeyboard wcPayKeyboard, int i2) {
        AppMethodBeat.i(72693);
        wcPayKeyboard.setWindowViewBottomMargin(i2);
        AppMethodBeat.o(72693);
    }

    static /* synthetic */ void f(WcPayKeyboard wcPayKeyboard) {
        AppMethodBeat.i(72695);
        wcPayKeyboard.DJ(false);
        AppMethodBeat.o(72695);
    }

    public enum b {
        NORMAL_STATE,
        SINGLE_ACTION_STATE,
        INIT_STATE;

        public static b valueOf(String str) {
            AppMethodBeat.i(72669);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(72669);
            return bVar;
        }

        static {
            AppMethodBeat.i(72670);
            AppMethodBeat.o(72670);
        }
    }

    public WcPayKeyboard(Context context) {
        super(context);
        AppMethodBeat.i(72671);
        init();
        AppMethodBeat.o(72671);
    }

    public WcPayKeyboard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(72672);
        init();
        AppMethodBeat.o(72672);
    }

    public WcPayKeyboard(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(72673);
        init();
        AppMethodBeat.o(72673);
    }

    private void init() {
        AppMethodBeat.i(72674);
        LayoutInflater.from(getContext()).inflate(R.layout.caw, (ViewGroup) this, true);
        this.Rsn = (LinearLayout) findViewById(R.id.e6e);
        this.Rsi = (TextView) findViewById(R.id.e63);
        this.RrZ = (TextView) findViewById(R.id.e64);
        this.Rsa = (TextView) findViewById(R.id.e65);
        this.Rsb = (TextView) findViewById(R.id.e66);
        this.Rsc = (TextView) findViewById(R.id.e67);
        this.Rsd = (TextView) findViewById(R.id.e68);
        this.Rse = (TextView) findViewById(R.id.e69);
        this.Rsf = (TextView) findViewById(R.id.e6_);
        this.Rsg = (TextView) findViewById(R.id.e6a);
        this.Rsh = (TextView) findViewById(R.id.e6b);
        this.Rsj = (TextView) findViewById(R.id.e6g);
        this.Rsl = findViewById(R.id.e6f);
        this.Rsk = (TextView) findViewById(R.id.e6c);
        this.Rso = (WcPayKeyboardAnimationActionButton) findViewById(R.id.e6d);
        this.nAB = (TextView) findViewById(R.id.e6i);
        this.Rsm = (ViewGroup) findViewById(R.id.e6h);
        this.Rsk.setTypeface(Typeface.defaultFromStyle(1));
        this.Rsk.setTextSize(1, 17.0f * com.tencent.mm.cb.a.ez(getContext()));
        AnonymousClass1 r0 = new View.OnClickListener() {
            /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.AnonymousClass1 */

            public final void onClick(View view) {
                int i2;
                AppMethodBeat.i(72652);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/wallet_core/keyboard/WcPayKeyboard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (WcPayKeyboard.this.mInputEditText == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/keyboard/WcPayKeyboard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(72652);
                    return;
                }
                if (view.getId() == R.id.e63) {
                    i2 = 7;
                } else if (view.getId() == R.id.e64) {
                    i2 = 8;
                } else if (view.getId() == R.id.e65) {
                    i2 = 9;
                } else if (view.getId() == R.id.e66) {
                    i2 = 10;
                } else if (view.getId() == R.id.e67) {
                    i2 = 11;
                } else if (view.getId() == R.id.e68) {
                    i2 = 12;
                } else if (view.getId() == R.id.e69) {
                    i2 = 13;
                } else if (view.getId() == R.id.e6_) {
                    i2 = 14;
                } else if (view.getId() == R.id.e6a) {
                    i2 = 15;
                } else if (view.getId() == R.id.e6b) {
                    i2 = 16;
                } else if (view.getId() == R.id.e6f) {
                    i2 = 67;
                } else if (view.getId() == R.id.e6g) {
                    i2 = 56;
                } else {
                    i2 = (view.getId() == R.id.e6c || view.getId() == R.id.e6d) ? 66 : 0;
                }
                if (!Util.isEqual(i2, 0)) {
                    view.performHapticFeedback(0, 2);
                }
                if (view.getId() != R.id.e6c) {
                    view.getId();
                }
                WcPayKeyboard.this.mInputEditText.dispatchKeyEvent(new KeyEvent(0, i2));
                WcPayKeyboard.this.mInputEditText.dispatchKeyEvent(new KeyEvent(1, i2));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/wallet_core/keyboard/WcPayKeyboard$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(72652);
            }
        };
        this.Rsn.setOnClickListener(r0);
        this.Rsi.setOnClickListener(r0);
        this.RrZ.setOnClickListener(r0);
        this.Rsa.setOnClickListener(r0);
        this.Rsb.setOnClickListener(r0);
        this.Rsc.setOnClickListener(r0);
        this.Rsd.setOnClickListener(r0);
        this.Rse.setOnClickListener(r0);
        this.Rsf.setOnClickListener(r0);
        this.Rsg.setOnClickListener(r0);
        this.Rsh.setOnClickListener(r0);
        this.Rsl.setOnClickListener(r0);
        this.Rsj.setOnClickListener(r0);
        this.Rsk.setOnClickListener(r0);
        this.Rso.setOnClickListener(r0);
        AppMethodBeat.o(72674);
    }

    public void setInputEditText(EditText editText) {
        if (editText != null) {
            this.mInputEditText = editText;
        }
    }

    public final void s(MMActivity mMActivity) {
        AppMethodBeat.i(214331);
        LayoutListenerView layoutListenerView = (LayoutListenerView) mMActivity.findViewById(R.id.ffv);
        layoutListenerView.setBackgroundColor(-1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        layoutListenerView.addView(this, layoutParams);
        setVisibility(8);
        this.Rsp = layoutListenerView.getChildAt(0);
        this.Rss = true;
        AppMethodBeat.o(214331);
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(72675);
        if (!isShown() || !hgP()) {
            AppMethodBeat.o(72675);
            return false;
        }
        hgN();
        AppMethodBeat.o(72675);
        return true;
    }

    public void setHeightListener(a aVar) {
        this.Rsr = aVar;
    }

    public final void hideWcKb() {
        AppMethodBeat.i(72676);
        Log.i("MicroMsg.WcPayKeyBoard", "hideWcKb() %s %s [%s]", Boolean.valueOf(isShown()), this.Rsq, Util.getStack());
        if (hgS()) {
            AppMethodBeat.o(72676);
        } else if (this.Rsq == b.INIT_STATE) {
            AppMethodBeat.o(72676);
        } else {
            if (isShown()) {
                if (hgP()) {
                    DI(true);
                }
                if (hgO()) {
                    hgU();
                }
            }
            AppMethodBeat.o(72676);
        }
    }

    public final void hgN() {
        AppMethodBeat.i(72677);
        Log.i("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() %s %s %s [%s]", Boolean.valueOf(isShown()), this.Rsq, Boolean.valueOf(hgS()), Util.getStack());
        if (hgS()) {
            AppMethodBeat.o(72677);
        } else if (this.Rsq == b.INIT_STATE) {
            AppMethodBeat.o(72677);
        } else {
            if (isShown() && hgP()) {
                bj(true, false);
            } else if (!isShown()) {
                if (hgP()) {
                    Log.e("MicroMsg.WcPayKeyBoard", "showSingleActionStWcKb() why here??");
                } else if (hgO()) {
                    hgV();
                }
            }
            this.Rsq = b.SINGLE_ACTION_STATE;
            AppMethodBeat.o(72677);
        }
    }

    public final void showNormalStWcKb() {
        AppMethodBeat.i(72678);
        Log.i("MicroMsg.WcPayKeyBoard", "showNormalStWcKb() %s %s %s [%s]", Boolean.valueOf(isShown()), this.Rsq, Boolean.valueOf(hgS()), Util.getStack());
        if (hgS()) {
            AppMethodBeat.o(72678);
            return;
        }
        if (!isShown()) {
            if (hgO()) {
                bj(false, false);
            }
            DJ(true);
        } else if (hgO()) {
            bj(false, true);
        }
        this.Rsq = b.NORMAL_STATE;
        AppMethodBeat.o(72678);
    }

    private boolean hgO() {
        return this.Rsq == b.SINGLE_ACTION_STATE;
    }

    public final boolean hgP() {
        return this.Rsq == b.NORMAL_STATE;
    }

    public final boolean hgQ() {
        return this.Rsq == b.INIT_STATE;
    }

    public final boolean hgR() {
        AppMethodBeat.i(72679);
        if (getVisibility() != 8 || hgQ()) {
            AppMethodBeat.o(72679);
            return false;
        }
        AppMethodBeat.o(72679);
        return true;
    }

    public void setActionText(String str) {
        AppMethodBeat.i(72680);
        this.Rsk.setText(str);
        AppMethodBeat.o(72680);
    }

    public void setTipText(String str) {
        AppMethodBeat.i(72681);
        this.nAB.setText(str);
        this.nAB.setVisibility(0);
        if (this.Rsn.isShown()) {
            post(new Runnable() {
                /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.AnonymousClass5 */

                public final void run() {
                    AppMethodBeat.i(72661);
                    if (WcPayKeyboard.this.Rss) {
                        WcPayKeyboard.a(WcPayKeyboard.this, WcPayKeyboard.this.Rsn.getHeight());
                    }
                    AppMethodBeat.o(72661);
                }
            });
        }
        AppMethodBeat.o(72681);
    }

    public final void fEW() {
        AppMethodBeat.i(72682);
        this.nAB.setVisibility(8);
        if (this.Rsn.isShown()) {
            post(new Runnable() {
                /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.AnonymousClass6 */

                public final void run() {
                    AppMethodBeat.i(72662);
                    if (WcPayKeyboard.this.Rss) {
                        WcPayKeyboard.a(WcPayKeyboard.this, WcPayKeyboard.this.Rsn.getHeight());
                    }
                    AppMethodBeat.o(72662);
                }
            });
        }
        AppMethodBeat.o(72682);
    }

    public final void DH(boolean z) {
        AppMethodBeat.i(72683);
        this.Rsk.setEnabled(z);
        this.Rso.setEnabled(z);
        if (z) {
            this.Rsk.setBackgroundResource(R.drawable.b4n);
            this.Rsk.setTextColor(getResources().getColor(R.color.ag5));
            AppMethodBeat.o(72683);
        } else if (ao.isDarkMode()) {
            this.Rsk.setBackgroundResource(R.drawable.b4o);
            this.Rsk.setTextColor(Color.parseColor("#347051"));
            AppMethodBeat.o(72683);
        } else {
            this.Rsk.setBackgroundResource(R.drawable.b4n);
            this.Rsk.setTextColor(Color.parseColor("#CDF2DF"));
            AppMethodBeat.o(72683);
        }
    }

    public final boolean hgS() {
        AppMethodBeat.i(72684);
        if (hgT() || this.Rso.hgY()) {
            AppMethodBeat.o(72684);
            return true;
        }
        AppMethodBeat.o(72684);
        return false;
    }

    private boolean hgT() {
        boolean isRunning;
        boolean isRunning2;
        AppMethodBeat.i(72685);
        if (this.Rsu == null) {
            isRunning = false;
        } else {
            isRunning = this.Rsu.isRunning();
        }
        if (this.Rst == null) {
            isRunning2 = false;
        } else {
            isRunning2 = this.Rst.isRunning();
        }
        if (isRunning || isRunning2) {
            AppMethodBeat.o(72685);
            return true;
        }
        AppMethodBeat.o(72685);
        return false;
    }

    private void bj(boolean z, boolean z2) {
        AppMethodBeat.i(72686);
        if (z) {
            this.Rso.setVisibility(0);
            if (this.Rso.RsT) {
                int[] iArr = new int[2];
                this.Rsk.getLocationOnScreen(iArr);
                this.Rsm.getLocationOnScreen(new int[2]);
                if (this.nAB.isShown()) {
                    this.nAB.getHeight();
                    com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
                }
                this.Rsl.getHeight();
                com.tencent.mm.cb.a.fromDPToPix(getContext(), 16);
                this.Rso.U(this.Rsk.getWidth(), this.Rsk.getHeight(), com.tencent.mm.cb.a.fromDPToPix(getContext(), 8), iArr[0]);
            } else {
                this.Rso.hgX();
            }
            this.Rso.RsQ = new StringBuilder().append((Object) this.Rsk.getText()).toString();
            this.Rsk.setVisibility(4);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.AnonymousClass7 */

                public final void run() {
                    AppMethodBeat.i(72663);
                    WcPayKeyboardAnimationActionButton wcPayKeyboardAnimationActionButton = WcPayKeyboard.this.Rso;
                    if (wcPayKeyboardAnimationActionButton.CPA != null) {
                        wcPayKeyboardAnimationActionButton.CPA.start();
                    }
                    WcPayKeyboard.e(WcPayKeyboard.this);
                    AppMethodBeat.o(72663);
                }
            });
            AppMethodBeat.o(72686);
        } else if (z2) {
            this.Rso.hhd();
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.AnonymousClass8 */

                public final void run() {
                    AppMethodBeat.i(72664);
                    WcPayKeyboard.f(WcPayKeyboard.this);
                    WcPayKeyboardAnimationActionButton wcPayKeyboardAnimationActionButton = WcPayKeyboard.this.Rso;
                    if (wcPayKeyboardAnimationActionButton.Rte != null) {
                        wcPayKeyboardAnimationActionButton.Rte.start();
                    }
                    AppMethodBeat.o(72664);
                }
            });
            AppMethodBeat.o(72686);
        } else {
            this.Rso.hhh();
            this.Rso.setVisibility(8);
            AppMethodBeat.o(72686);
        }
    }

    private void DI(final boolean z) {
        AppMethodBeat.i(72687);
        if (this.Rss) {
            DK(z);
            AppMethodBeat.o(72687);
            return;
        }
        final int height = this.Rsn.getHeight();
        if (this.Rsu == null) {
            this.Rsu = ObjectAnimator.ofFloat(this.Rsn, "translationY", 0.0f, (float) height);
            this.Rsu.setDuration(300L);
            this.Rsu.setInterpolator(new LinearInterpolator());
        }
        this.Rsu.removeAllListeners();
        this.Rsu.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.AnonymousClass9 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(72665);
                WcPayKeyboard.this.Rsn.setVisibility(4);
                WcPayKeyboard.this.Rsn.setTranslationY(WcPayKeyboard.this.Rsn.getTranslationY() - ((float) height));
                if (z) {
                    WcPayKeyboard.this.setVisibility(8);
                }
                AppMethodBeat.o(72665);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        this.Rsu.removeAllUpdateListeners();
        this.Rsu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.AnonymousClass10 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(72666);
                if (WcPayKeyboard.this.Rsr != null) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    float f2 = ((float) height) - floatValue;
                    Log.v("MicroMsg.WcPayKeyBoard", "hideWcPayKeyboardBase() onAnimationUpdate() baseHeight:%s translationY:%s %s", Integer.valueOf(height), Float.valueOf(floatValue), Float.valueOf(f2));
                    WcPayKeyboard.this.Rsr.bO(f2);
                }
                AppMethodBeat.o(72666);
            }
        });
        this.Rsu.start();
        AppMethodBeat.o(72687);
    }

    private void hgU() {
        AppMethodBeat.i(72688);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fk);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.AnonymousClass11 */
            final /* synthetic */ boolean Rsz = true;

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(72667);
                WcPayKeyboard.this.Rso.setVisibility(4);
                if (this.Rsz) {
                    WcPayKeyboard.this.setVisibility(8);
                }
                AppMethodBeat.o(72667);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.Rso.startAnimation(loadAnimation);
        AppMethodBeat.o(72688);
    }

    private void hgV() {
        AppMethodBeat.i(72689);
        setVisibility(0);
        this.Rso.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fj);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.AnonymousClass12 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.Rso.startAnimation(loadAnimation);
        AppMethodBeat.o(72689);
    }

    public final void DJ(final boolean z) {
        AppMethodBeat.i(72690);
        setVisibility(0);
        this.Rsn.setVisibility(4);
        this.Rsn.post(new Runnable() {
            /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(72656);
                if (WcPayKeyboard.this.Rss) {
                    WcPayKeyboard.a(WcPayKeyboard.this, z);
                    AppMethodBeat.o(72656);
                    return;
                }
                final int height = WcPayKeyboard.this.Rsn.getHeight();
                if (WcPayKeyboard.this.Rst == null) {
                    float translationY = WcPayKeyboard.this.Rsn.getTranslationY();
                    WcPayKeyboard.this.Rst = ObjectAnimator.ofFloat(WcPayKeyboard.this.Rsn, "translationY", ((float) height) + translationY, translationY);
                    WcPayKeyboard.this.Rst.setDuration(300L);
                    WcPayKeyboard.this.Rst.setInterpolator(new LinearInterpolator());
                }
                WcPayKeyboard.this.Rst.removeAllListeners();
                WcPayKeyboard.this.Rst.addListener(new Animator.AnimatorListener() {
                    /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.AnonymousClass2.AnonymousClass1 */

                    public final void onAnimationStart(Animator animator) {
                        AppMethodBeat.i(72653);
                        WcPayKeyboard.this.Rsn.setVisibility(0);
                        if (z) {
                            WcPayKeyboard.this.Rsk.setVisibility(0);
                            AppMethodBeat.o(72653);
                            return;
                        }
                        WcPayKeyboard.this.Rsk.setVisibility(4);
                        AppMethodBeat.o(72653);
                    }

                    public final void onAnimationEnd(Animator animator) {
                        AppMethodBeat.i(72654);
                        Log.d("MicroMsg.WcPayKeyBoard", "keyboard anim end");
                        if (!z) {
                            WcPayKeyboard.this.Rsk.setVisibility(0);
                            WcPayKeyboard.this.Rso.setVisibility(4);
                        }
                        AppMethodBeat.o(72654);
                    }

                    public final void onAnimationCancel(Animator animator) {
                    }

                    public final void onAnimationRepeat(Animator animator) {
                    }
                });
                WcPayKeyboard.this.Rst.removeAllUpdateListeners();
                WcPayKeyboard.this.Rst.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.AnonymousClass2.AnonymousClass2 */

                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        AppMethodBeat.i(72655);
                        if (WcPayKeyboard.this.Rsr != null) {
                            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                            float f2 = ((float) height) - floatValue;
                            Log.v("MicroMsg.WcPayKeyBoard", "showWcPayKeyboardBase() onAnimationUpdate() baseHeight:%s translationY:%s %s", Integer.valueOf(height), Float.valueOf(floatValue), Float.valueOf(f2));
                            WcPayKeyboard.this.Rsr.bO(f2);
                        }
                        AppMethodBeat.o(72655);
                    }
                });
                WcPayKeyboard.this.Rst.start();
                AppMethodBeat.o(72656);
            }
        });
        AppMethodBeat.o(72690);
    }

    private void DK(final boolean z) {
        AppMethodBeat.i(72691);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.ej);
        loadAnimation.setDuration(330);
        loadAnimation.setInterpolator(new LinearInterpolator());
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.AnonymousClass3 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(72657);
                WcPayKeyboard.this.Rsn.setVisibility(4);
                if (z) {
                    WcPayKeyboard.this.setVisibility(8);
                }
                AppMethodBeat.o(72657);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        this.Rsn.startAnimation(loadAnimation);
        setWindowViewBottomMargin(0);
        AppMethodBeat.o(72691);
    }

    private void setWindowViewBottomMargin(int i2) {
        AppMethodBeat.i(72692);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.Rsp.getLayoutParams();
        layoutParams.bottomMargin = i2;
        this.Rsp.setLayoutParams(layoutParams);
        AppMethodBeat.o(72692);
    }

    static /* synthetic */ void e(WcPayKeyboard wcPayKeyboard) {
        AppMethodBeat.i(72694);
        wcPayKeyboard.DI(false);
        AppMethodBeat.o(72694);
    }

    static /* synthetic */ void a(WcPayKeyboard wcPayKeyboard, final boolean z) {
        AppMethodBeat.i(72696);
        Animation loadAnimation = AnimationUtils.loadAnimation(wcPayKeyboard.getContext(), R.anim.ei);
        loadAnimation.setInterpolator(new LinearInterpolator());
        loadAnimation.setDuration(330);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.AnonymousClass4 */

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(72659);
                Log.d("MicroMsg.WcPayKeyBoard", "keyboard anim start");
                WcPayKeyboard.this.Rsn.setVisibility(0);
                if (z) {
                    WcPayKeyboard.this.Rsk.setVisibility(0);
                    AppMethodBeat.o(72659);
                    return;
                }
                WcPayKeyboard.this.Rsk.setVisibility(4);
                AppMethodBeat.o(72659);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(72660);
                Log.d("MicroMsg.WcPayKeyBoard", "keyboard anim end");
                WcPayKeyboard.this.post(new Runnable() {
                    /* class com.tencent.mm.wallet_core.keyboard.WcPayKeyboard.AnonymousClass4.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(72658);
                        if (!z) {
                            WcPayKeyboard.this.Rsk.setVisibility(0);
                            WcPayKeyboard.this.Rso.setVisibility(4);
                        }
                        AppMethodBeat.o(72658);
                    }
                });
                WcPayKeyboard.a(WcPayKeyboard.this, WcPayKeyboard.this.Rsn.getHeight());
                AppMethodBeat.o(72660);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        wcPayKeyboard.Rsn.startAnimation(loadAnimation);
        AppMethodBeat.o(72696);
    }
}
