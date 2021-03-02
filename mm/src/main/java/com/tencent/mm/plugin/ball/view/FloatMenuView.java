package com.tencent.mm.plugin.ball.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.os.Vibrator;
import android.support.v4.content.b;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.RelativeLayout;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ball.a.a;
import com.tencent.mm.plugin.ball.b.e;
import com.tencent.mm.plugin.ball.c.d;
import com.tencent.mm.plugin.ball.d.c;
import com.tencent.mm.plugin.ball.f.e;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.view.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class FloatMenuView extends RelativeLayout implements d {
    public boolean oVo;
    public boolean oVp;
    private boolean oVs;
    private Vibrator paT;
    private String pby;
    private int pcA;
    public int pcB;
    public View pcC;
    public int pcD;
    public boolean pcE;
    private volatile boolean pcF;
    private ResultReceiver pcG;
    private boolean pcH;
    public int pco;
    public int pcp;
    private RecyclerView pcq;
    private a pcr;
    private LinearLayoutManager pcs;
    private List<BallInfo> pct;
    public Set<c> pcu;
    private com.tencent.mm.plugin.ball.d.d pcv;
    private LayoutAnimationController pcw;
    private LayoutAnimationController pcx;
    private LayoutAnimationController pcy;
    private LayoutAnimationController pcz;

    static /* synthetic */ void a(FloatMenuView floatMenuView, int i2, int i3) {
        AppMethodBeat.i(217122);
        floatMenuView.eZ(i2, i3);
        AppMethodBeat.o(217122);
    }

    static /* synthetic */ void a(FloatMenuView floatMenuView, BallInfo ballInfo) {
        AppMethodBeat.i(106515);
        floatMenuView.M(ballInfo);
        AppMethodBeat.o(106515);
    }

    static /* synthetic */ void b(FloatMenuView floatMenuView, BallInfo ballInfo) {
        AppMethodBeat.i(106517);
        floatMenuView.N(ballInfo);
        AppMethodBeat.o(106517);
    }

    public FloatMenuView(Context context) {
        this(context, null);
    }

    public FloatMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FloatMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(106490);
        this.pcu = new CopyOnWriteArraySet();
        this.pcv = null;
        this.oVs = true;
        this.pcD = -1;
        this.pcE = false;
        this.pcF = false;
        this.pcG = null;
        this.pcH = false;
        View.inflate(context, R.layout.ays, this);
        setBackgroundColor(b.n(context, R.color.rh));
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.ball.view.FloatMenuView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(106484);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatMenuView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                FloatMenuView.a(FloatMenuView.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(106484);
            }
        });
        this.paT = (Vibrator) context.getSystemService("vibrator");
        this.pcq = (RecyclerView) findViewById(R.id.fct);
        this.pcq.setOverScrollMode(2);
        setClipChildren(false);
        this.pcq.setClipChildren(false);
        this.pcr = new a(context);
        this.pcr.oVs = this.oVs;
        if (!this.oVs) {
            this.pcq.setItemAnimator(null);
        } else {
            AnonymousClass4 r0 = new d.b() {
                /* class com.tencent.mm.plugin.ball.view.FloatMenuView.AnonymousClass4 */

                @Override // com.tencent.mm.plugin.ball.view.d.b
                public final boolean a(final RecyclerView.v vVar, final Animator.AnimatorListener animatorListener) {
                    AppMethodBeat.i(217116);
                    if (vVar == null || vVar.aus == null) {
                        AppMethodBeat.o(217116);
                        return false;
                    }
                    float measuredWidth = (float) vVar.aus.getMeasuredWidth();
                    if (measuredWidth <= 0.0f) {
                        measuredWidth = (float) FloatMenuView.this.getMeasuredWidth();
                    }
                    if (FloatMenuView.this.oVo) {
                        measuredWidth = -measuredWidth;
                    }
                    Log.i("MicroMsg.FloatMenuView", "alvinluo animateRemove tranX: %f", Float.valueOf(measuredWidth));
                    vVar.aus.animate().alpha(0.0f).translationX(measuredWidth).setListener(new Animator.AnimatorListener() {
                        /* class com.tencent.mm.plugin.ball.view.FloatMenuView.AnonymousClass4.AnonymousClass1 */

                        public final void onAnimationStart(Animator animator) {
                            AppMethodBeat.i(217112);
                            if (animatorListener != null) {
                                animatorListener.onAnimationStart(animator);
                            }
                            AppMethodBeat.o(217112);
                        }

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(217113);
                            if (animatorListener != null) {
                                animatorListener.onAnimationEnd(animator);
                            }
                            long j2 = 200;
                            if (!com.tencent.mm.plugin.ball.f.d.h(FloatMenuView.this.pct)) {
                                j2 = 0;
                            }
                            h.RTc.n(new Runnable() {
                                /* class com.tencent.mm.plugin.ball.view.FloatMenuView.AnonymousClass4.AnonymousClass1.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(217111);
                                    if ((vVar instanceof a.C0850a) && ((a.C0850a) vVar).oVO != null) {
                                        FloatMenuView.a(FloatMenuView.this, ((a.C0850a) vVar).oVO, ((a.C0850a) vVar).position);
                                    }
                                    AppMethodBeat.o(217111);
                                }
                            }, j2);
                            AppMethodBeat.o(217113);
                        }

                        public final void onAnimationCancel(Animator animator) {
                            AppMethodBeat.i(217114);
                            if (animatorListener != null) {
                                animatorListener.onAnimationCancel(animator);
                            }
                            AppMethodBeat.o(217114);
                        }

                        public final void onAnimationRepeat(Animator animator) {
                            AppMethodBeat.i(217115);
                            if (animatorListener != null) {
                                animatorListener.onAnimationRepeat(animator);
                            }
                            AppMethodBeat.o(217115);
                        }
                    }).start();
                    AppMethodBeat.o(217116);
                    return true;
                }
            };
            d dVar = new d();
            dVar.atn = 200;
            dVar.ato = 200;
            dVar.atq = 200;
            dVar.atp = 200;
            dVar.atp = 160;
            dVar.oVt = r0;
            this.pcr.oVt = r0;
            this.pcq.setItemAnimator(dVar);
        }
        this.pcr.oVr = new com.tencent.mm.plugin.ball.d.b() {
            /* class com.tencent.mm.plugin.ball.view.FloatMenuView.AnonymousClass2 */

            @Override // com.tencent.mm.plugin.ball.d.b
            public final void v(BallInfo ballInfo) {
                AppMethodBeat.i(106485);
                FloatMenuView.a(FloatMenuView.this, ballInfo);
                AppMethodBeat.o(106485);
            }

            @Override // com.tencent.mm.plugin.ball.d.b
            public final void a(BallInfo ballInfo, int i2) {
                AppMethodBeat.i(106486);
                FloatMenuView.a(FloatMenuView.this, ballInfo, i2);
                AppMethodBeat.o(106486);
            }

            @Override // com.tencent.mm.plugin.ball.d.b
            public final void d(BallInfo ballInfo) {
                AppMethodBeat.i(106487);
                FloatMenuView.b(FloatMenuView.this, ballInfo);
                AppMethodBeat.o(106487);
            }
        };
        this.pcq.setAdapter(this.pcr);
        this.pcs = new LinearLayoutManager() {
            /* class com.tencent.mm.plugin.ball.view.FloatMenuView.AnonymousClass3 */

            @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
            public final boolean canScrollVertically() {
                AppMethodBeat.i(106488);
                boolean z = FloatMenuView.this.pcF;
                AppMethodBeat.o(106488);
                return z;
            }

            @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
            public final boolean canScrollHorizontally() {
                return false;
            }
        };
        this.pcs.setOrientation(1);
        this.pcq.setLayoutManager(this.pcs);
        this.pcA = com.tencent.mm.cb.a.aH(context, R.dimen.a7j) + com.tencent.mm.cb.a.aH(context, R.dimen.a7z) + com.tencent.mm.cb.a.aH(context, R.dimen.a7x);
        this.pcw = AnimationUtils.loadLayoutAnimation(context, R.anim.c1);
        this.pcy = AnimationUtils.loadLayoutAnimation(context, R.anim.c2);
        this.pcx = AnimationUtils.loadLayoutAnimation(context, R.anim.bz);
        this.pcz = AnimationUtils.loadLayoutAnimation(context, R.anim.c0);
        AppMethodBeat.o(106490);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(106491);
        if ((keyEvent.getKeyCode() == 4 || keyEvent.getKeyCode() == 3 || keyEvent.getKeyCode() == 82) && keyEvent.getAction() == 0) {
            cjK();
            AppMethodBeat.o(106491);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(106491);
        return dispatchKeyEvent;
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(106492);
        int i2 = configuration.orientation;
        for (c cVar : this.pcu) {
            cVar.onOrientationChange(i2);
        }
        AppMethodBeat.o(106492);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        AppMethodBeat.i(184625);
        super.onMeasure(i2, i3);
        if (this.pcv != null) {
            this.pcv.cie();
        }
        AppMethodBeat.o(184625);
    }

    @Override // com.tencent.mm.plugin.ball.c.d
    public final void a(List<BallInfo> list, BallInfo ballInfo) {
        AppMethodBeat.i(106493);
        List<BallInfo> cj = com.tencent.mm.plugin.ball.f.d.cj(com.tencent.mm.plugin.ball.f.d.ci(list));
        String cs = cs(cj);
        if (Util.isEqual(cs, this.pby)) {
            Log.i("MicroMsg.FloatMenuView", "FloatMenuView ignore refresh");
            AppMethodBeat.o(106493);
            return;
        }
        this.pby = cs;
        this.pct = cj;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(com.tencent.mm.plugin.ball.f.d.h(this.pct) ? this.pct.size() : 0);
        Log.i("MicroMsg.FloatMenuView", "menuBallInfoList, size:%s", objArr);
        this.pcr.oVq = this.pct;
        this.pcr.atj.notifyChanged();
        if (!com.tencent.mm.plugin.ball.f.d.h(com.tencent.mm.plugin.ball.f.d.d(list, ballInfo))) {
            e((AnimatorListenerAdapter) null);
            AppMethodBeat.o(106493);
            return;
        }
        eZ(this.pco, this.pcp);
        AppMethodBeat.o(106493);
    }

    private static String cs(List<BallInfo> list) {
        AppMethodBeat.i(106494);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            BallInfo ballInfo = list.get(i2);
            sb.append(ballInfo.key).append(ballInfo.type).append(ballInfo.icon).append(ballInfo.noe).append(ballInfo.name).append(ballInfo.tag).append(ballInfo.state).append(ballInfo.oWr).append(ballInfo.nno).append(ballInfo.progress).append("|");
        }
        String mD5String = MD5Util.getMD5String(sb.toString());
        AppMethodBeat.o(106494);
        return mD5String;
    }

    public void setInLongPressMode(boolean z) {
        AppMethodBeat.i(106495);
        this.oVp = z;
        this.pcr.oVp = z;
        this.pcr.atj.notifyChanged();
        AppMethodBeat.o(106495);
    }

    public final void P(MotionEvent motionEvent) {
        AppMethodBeat.i(106496);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        View o = this.pcq.o(rawX - ((float) this.pcq.getLeft()), rawY - ((float) this.pcq.getTop()));
        if (o != null) {
            d(RecyclerView.bw(o), o);
            AppMethodBeat.o(106496);
            return;
        }
        d(-1, null);
        AppMethodBeat.o(106496);
    }

    private void d(int i2, View view) {
        AppMethodBeat.i(106497);
        if (i2 == -1) {
            dp(this.pcC);
        } else if (i2 != this.pcD) {
            dp(this.pcC);
            m16do(view);
        }
        this.pcD = i2;
        this.pcC = view;
        AppMethodBeat.o(106497);
    }

    /* renamed from: do  reason: not valid java name */
    private void m16do(View view) {
        AppMethodBeat.i(106498);
        if (view != null) {
            view.clearAnimation();
            if ((view.getTag() instanceof BallInfo) && !((BallInfo) view.getTag()).oWr) {
                view.animate().scaleX(1.1f).scaleY(1.1f).setDuration(100).start();
                cjJ();
            }
        }
        AppMethodBeat.o(106498);
    }

    public static void dp(View view) {
        AppMethodBeat.i(106499);
        if (view != null) {
            view.clearAnimation();
            view.animate().scaleX(1.0f).scaleY(1.0f).setDuration(100).start();
        }
        AppMethodBeat.o(106499);
    }

    public void setCanAddFloatBallWhenHide(boolean z) {
        this.pcH = z;
    }

    public void setForceShowFloatMenu(boolean z) {
        this.pcE = z;
    }

    public final void cjD() {
        AppMethodBeat.i(106500);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(null);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V", this, bVar.axR());
        c((ResultReceiver) null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", "show", "(Landroid/animation/AnimatorListenerAdapter;)V");
        AppMethodBeat.o(106500);
    }

    public final void c(ResultReceiver resultReceiver) {
        AppMethodBeat.i(217120);
        if (getVisibility() == 0) {
            Log.i("MicroMsg.FloatMenuView", "float menu already show");
            AppMethodBeat.o(217120);
            return;
        }
        this.pcG = resultReceiver;
        setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.addListener(new e(this, null));
        ofFloat.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.ball.view.FloatMenuView.AnonymousClass6 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(217118);
                FloatMenuView.a(FloatMenuView.this, true);
                AppMethodBeat.o(217118);
            }
        });
        ofFloat.start();
        cjE();
        AppMethodBeat.o(217120);
    }

    public final void e(AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.i(106501);
        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
        bVar.bm(animatorListenerAdapter);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "(Landroid/animation/AnimatorListenerAdapter;)V", this, bVar.axR());
        if (getVisibility() == 8) {
            Log.i("MicroMsg.FloatMenuView", "float menu already hide");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "(Landroid/animation/AnimatorListenerAdapter;)V");
            AppMethodBeat.o(106501);
            return;
        }
        cjF();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(200L);
        ofFloat.addListener(new com.tencent.mm.plugin.ball.b.d(this, animatorListenerAdapter));
        ofFloat.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.ball.view.FloatMenuView.AnonymousClass7 */

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(217119);
                FloatMenuView.a(FloatMenuView.this, false);
                FloatMenuView.this.pcG = null;
                AppMethodBeat.o(217119);
            }
        });
        ofFloat.start();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/ball/view/FloatMenuView", "com/tencent/mm/plugin/ball/view/FloatMenuView", MessengerShareContentUtility.SHARE_BUTTON_HIDE, "(Landroid/animation/AnimatorListenerAdapter;)V");
        AppMethodBeat.o(106501);
    }

    private void cjE() {
        AppMethodBeat.i(106502);
        if (this.oVo) {
            this.pcq.setLayoutAnimation(this.pcw);
        } else {
            this.pcq.setLayoutAnimation(this.pcy);
        }
        this.pcq.startLayoutAnimation();
        if (com.tencent.mm.plugin.ball.f.d.h(this.pct)) {
            for (BallInfo ballInfo : this.pct) {
                N(ballInfo);
            }
        }
        AppMethodBeat.o(106502);
    }

    private void cjF() {
        AppMethodBeat.i(106503);
        if (this.oVo) {
            this.pcq.setLayoutAnimation(this.pcx);
        } else {
            this.pcq.setLayoutAnimation(this.pcz);
        }
        this.pcq.startLayoutAnimation();
        AppMethodBeat.o(106503);
    }

    public final void cjG() {
        AppMethodBeat.i(217121);
        if (getVisibility() == 8) {
            Log.i("MicroMsg.FloatMenuView", "float menu already hide");
            AppMethodBeat.o(217121);
            return;
        }
        setVisibility(8);
        AppMethodBeat.o(217121);
    }

    public void setVisibility(int i2) {
        AppMethodBeat.i(106504);
        super.setVisibility(i2);
        if (i2 == 8) {
            Log.i("MicroMsg.FloatMenuView", "setVisibility, updateMenuContentView when GONE");
            eZ(this.pco, this.pcp);
            setForceShowFloatMenu(false);
        }
        AppMethodBeat.o(106504);
    }

    private void eZ(int i2, int i3) {
        AppMethodBeat.i(106505);
        this.pco = i2;
        this.pcp = i3;
        cjI();
        AppMethodBeat.o(106505);
    }

    private int cjH() {
        AppMethodBeat.i(106506);
        if (com.tencent.mm.plugin.ball.f.d.h(this.pct)) {
            int size = this.pct.size() * this.pcA;
            AppMethodBeat.o(106506);
            return size;
        }
        AppMethodBeat.o(106506);
        return 0;
    }

    private void cjI() {
        int i2;
        int i3;
        AppMethodBeat.i(106507);
        if (this.pcq == null) {
            AppMethodBeat.o(106507);
        } else if (getVisibility() == 0) {
            Log.i("MicroMsg.FloatMenuView", "updateMenuContentView, ignore when visible");
            AppMethodBeat.o(106507);
        } else {
            this.pcF = false;
            int i4 = this.pcB == 0 ? com.tencent.mm.plugin.ball.f.e.oYK : this.pcB;
            int cjH = cjH();
            e.a T = com.tencent.mm.plugin.ball.f.d.T(this.pco, this.pcp, i4);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int jo = com.tencent.mm.cb.a.jo(MMApplicationContext.getContext()) - com.tencent.mm.plugin.ball.f.e.oYJ;
            if (this.pcp + i4 + cjH <= jo) {
                int i5 = i4 + this.pcp;
                if (T == e.a.TOP_LEFT || T == e.a.BOTTOM_LEFT) {
                    b(layoutParams, i5);
                    this.pcw.setOrder(0);
                } else {
                    a(layoutParams, i5);
                    this.pcy.setOrder(0);
                }
                this.pcs.an(false);
                this.pcq.setLayoutManager(this.pcs);
            } else if (this.pcp - cjH >= com.tencent.mm.plugin.ball.f.e.oYV) {
                int i6 = this.pcp - cjH;
                this.pcF = i6 < com.tencent.mm.plugin.ball.f.e.oYJ;
                if (i6 < com.tencent.mm.plugin.ball.f.e.oYJ) {
                    i3 = com.tencent.mm.plugin.ball.f.e.oYJ;
                } else {
                    i3 = i6;
                }
                if (T == e.a.TOP_LEFT || T == e.a.BOTTOM_LEFT) {
                    b(layoutParams, i3);
                    this.pcw.setOrder(1);
                } else {
                    a(layoutParams, i3);
                    this.pcy.setOrder(1);
                }
                this.pcs.an(true);
                this.pcq.setLayoutManager(this.pcs);
            } else {
                int i7 = jo - cjH;
                this.pcF = i7 < com.tencent.mm.plugin.ball.f.e.oYJ;
                if (i7 < com.tencent.mm.plugin.ball.f.e.oYJ) {
                    i2 = com.tencent.mm.plugin.ball.f.e.oYJ;
                } else {
                    i2 = i7;
                }
                if (T == e.a.TOP_LEFT || T == e.a.BOTTOM_LEFT) {
                    b(layoutParams, i2);
                    this.pcw.setOrder(0);
                } else {
                    a(layoutParams, i2);
                    this.pcy.setOrder(0);
                }
                this.pcs.an(false);
                this.pcq.setLayoutManager(this.pcs);
            }
            Log.i("MicroMsg.FloatMenuView", "updateMenuContentView, anchorView:[%s, %s], margins:[%s, %s, %s, %s], enableScroll:%b", Integer.valueOf(this.pco), Integer.valueOf(this.pcp), Integer.valueOf(layoutParams.leftMargin), Integer.valueOf(layoutParams.topMargin), Integer.valueOf(layoutParams.rightMargin), Integer.valueOf(layoutParams.bottomMargin), Boolean.valueOf(this.pcF));
            this.pcq.setLayoutParams(layoutParams);
            AppMethodBeat.o(106507);
        }
    }

    private static void a(RelativeLayout.LayoutParams layoutParams, int i2) {
        AppMethodBeat.i(106508);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.rightMargin = 0;
        layoutParams.topMargin = i2;
        layoutParams.addRule(11);
        AppMethodBeat.o(106508);
    }

    private static void b(RelativeLayout.LayoutParams layoutParams, int i2) {
        AppMethodBeat.i(106509);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.leftMargin = 0;
        layoutParams.topMargin = i2;
        layoutParams.addRule(9);
        AppMethodBeat.o(106509);
    }

    private void cjJ() {
        AppMethodBeat.i(106510);
        if (this.paT != null) {
            this.paT.vibrate(10);
        }
        AppMethodBeat.o(106510);
    }

    public final void cjK() {
        AppMethodBeat.i(106511);
        for (c cVar : this.pcu) {
            cVar.cid();
        }
        AppMethodBeat.o(106511);
    }

    public final void M(BallInfo ballInfo) {
        AppMethodBeat.i(106512);
        for (c cVar : this.pcu) {
            cVar.v(ballInfo);
        }
        AppMethodBeat.o(106512);
    }

    private void N(BallInfo ballInfo) {
        AppMethodBeat.i(106513);
        for (c cVar : this.pcu) {
            cVar.d(ballInfo);
        }
        AppMethodBeat.o(106513);
    }

    public void setOnMeasuredListener(com.tencent.mm.plugin.ball.d.d dVar) {
        this.pcv = dVar;
    }

    static /* synthetic */ void a(FloatMenuView floatMenuView) {
        AppMethodBeat.i(106514);
        for (c cVar : floatMenuView.pcu) {
            cVar.cic();
        }
        AppMethodBeat.o(106514);
    }

    static /* synthetic */ void a(FloatMenuView floatMenuView, BallInfo ballInfo, int i2) {
        AppMethodBeat.i(106516);
        for (c cVar : floatMenuView.pcu) {
            cVar.a(ballInfo, i2);
        }
        AppMethodBeat.o(106516);
    }

    static /* synthetic */ void a(FloatMenuView floatMenuView, boolean z) {
        int i2;
        AppMethodBeat.i(217123);
        if (floatMenuView.pcG != null) {
            Bundle bundle = null;
            if (!z) {
                bundle = new Bundle();
                bundle.putBoolean("can_add_float_ball_when_hide", floatMenuView.pcH);
                floatMenuView.pcH = false;
            }
            ResultReceiver resultReceiver = floatMenuView.pcG;
            if (z) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            resultReceiver.send(i2, bundle);
        }
        AppMethodBeat.o(217123);
    }
}
