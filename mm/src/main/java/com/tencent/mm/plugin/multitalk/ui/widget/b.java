package com.tencent.mm.plugin.multitalk.ui.widget;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.multitalk.ui.widget.MultitalkFrameView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

public final class b extends RecyclerView.v {
    public static final a zRm = new a((byte) 0);
    public MTimerHandler cve;
    public View maskView;
    public String userName;
    public MultitalkFrameView zQT;
    public ImageView zQU;
    public ImageView zQV;
    public TextView zQW;
    public WeImageView zQX;
    public TextView zQY;
    private View zQZ;
    private View zRa;
    String zRb;
    private kotlin.g.a.b<? super String, x> zRc;
    public final FrameLayout zRd;
    public boolean zRe = true;
    public View zRf;
    View zRg;
    View zRh;
    public int zRi;
    public com.tencent.mm.plugin.multitalk.ui.widget.projector.c zRj;
    private RelativeLayout zRk;
    public boolean zRl;
    public ImageView zhh;

    static {
        AppMethodBeat.i(239782);
        AppMethodBeat.o(239782);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view) {
        super(view);
        p.h(view, "itemView");
        AppMethodBeat.i(178966);
        View findViewById = view.findViewById(R.id.wt);
        p.g(findViewById, "itemView.findViewById(R.id.avatar_cell_overlay)");
        this.zRd = (FrameLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.ii8);
        p.g(findViewById2, "itemView.findViewById(R.id.talking_avatar_layout)");
        this.zRf = findViewById2;
        View findViewById3 = view.findViewById(R.id.dot);
        p.g(findViewById3, "itemView.findViewById(R.id.header_stub)");
        this.zRg = findViewById3;
        View findViewById4 = view.findViewById(R.id.d8s);
        p.g(findViewById4, "itemView.findViewById(R.id.footer_stub)");
        this.zRh = findViewById4;
        this.zRi = -1;
        this.zQT = (MultitalkFrameView) view.findViewById(R.id.iie);
        this.maskView = view.findViewById(R.id.fac);
        View findViewById5 = view.findViewById(R.id.j9s);
        if (findViewById5 == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(178966);
            throw tVar;
        }
        this.zQU = (ImageView) findViewById5;
        View findViewById6 = view.findViewById(R.id.fpk);
        if (findViewById6 == null) {
            t tVar2 = new t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(178966);
            throw tVar2;
        }
        this.zQV = (ImageView) findViewById6;
        View findViewById7 = view.findViewById(R.id.ifa);
        if (findViewById7 == null) {
            t tVar3 = new t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(178966);
            throw tVar3;
        }
        this.zQW = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.epk);
        if (findViewById8 == null) {
            t tVar4 = new t("null cannot be cast to non-null type android.widget.ImageView");
            AppMethodBeat.o(178966);
            throw tVar4;
        }
        this.zhh = (ImageView) findViewById8;
        View findViewById9 = view.findViewById(R.id.fot);
        if (findViewById9 == null) {
            t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.ui.widget.imageview.WeImageView");
            AppMethodBeat.o(178966);
            throw tVar5;
        }
        this.zQX = (WeImageView) findViewById9;
        View findViewById10 = view.findViewById(R.id.xc);
        if (findViewById10 == null) {
            t tVar6 = new t("null cannot be cast to non-null type android.widget.TextView");
            AppMethodBeat.o(178966);
            throw tVar6;
        }
        this.zQY = (TextView) findViewById10;
        this.zRa = view.findViewById(R.id.xb);
        this.zQZ = view.findViewById(R.id.x5);
        this.zRk = (RelativeLayout) view.findViewById(R.id.hbr);
        Context context = view.getContext();
        p.g(context, "itemView.context");
        this.zRj = new com.tencent.mm.plugin.multitalk.ui.widget.projector.c(context);
        AppMethodBeat.o(178966);
    }

    public static final /* synthetic */ void c(b bVar) {
        AppMethodBeat.i(239783);
        bVar.eoA();
        AppMethodBeat.o(239783);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void Rp(int i2) {
        AppMethodBeat.i(239767);
        WeImageView weImageView = this.zQX;
        if (weImageView != null) {
            View view = this.aus;
            p.g(view, "itemView");
            weImageView.setImageDrawable(ar.m(view.getContext(), R.raw.icon_filled_mike_off, -65536));
        }
        WeImageView weImageView2 = this.zQX;
        if (weImageView2 != null) {
            View view2 = this.aus;
            p.g(view2, "itemView");
            Context context = view2.getContext();
            p.g(context, "itemView.context");
            weImageView2.setIconColor(context.getResources().getColor(R.color.a5c));
        }
        View findViewById = this.aus.findViewById(R.id.fos);
        p.g(findViewById, "itemView.findViewById<Re…d.multitalk_mute_icon_bg)");
        View view3 = this.aus;
        p.g(view3, "itemView");
        Context context2 = view3.getContext();
        View view4 = this.aus;
        p.g(view4, "itemView");
        Context context3 = view4.getContext();
        p.g(context3, "itemView.context");
        ((RelativeLayout) findViewById).setBackground(ar.m(context2, R.drawable.ak6, context3.getResources().getColor(R.color.am)));
        View findViewById2 = this.aus.findViewById(R.id.fos);
        p.g(findViewById2, "itemView.findViewById<Re…d.multitalk_mute_icon_bg)");
        ((RelativeLayout) findViewById2).setVisibility(i2);
        AppMethodBeat.o(239767);
    }

    public final void Rq(int i2) {
        AppMethodBeat.i(239768);
        q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        if (eom.enA().emb() && i2 == 0) {
            ac.eom().aGa(this.zRb);
            eoA();
            this.zRl = true;
            RelativeLayout relativeLayout = this.zRk;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(0);
            }
            RelativeLayout relativeLayout2 = this.zRk;
            if (relativeLayout2 != null) {
                relativeLayout2.removeAllViews();
                com.tencent.mm.plugin.multitalk.ui.widget.projector.c cVar = this.zRj;
                if (cVar != null) {
                    cVar.a(relativeLayout2);
                }
            }
            com.tencent.mm.plugin.multitalk.ui.widget.projector.c cVar2 = this.zRj;
            if (cVar2 != null) {
                cVar2.epm();
                AppMethodBeat.o(239768);
                return;
            }
            AppMethodBeat.o(239768);
        } else if (i2 == 0 && !this.zRl && !aGr(this.zRb)) {
            Log.i("AvatarLayoutHolder", "showScreenCastIcon visible first times");
            eoA();
            this.zRl = true;
            RelativeLayout relativeLayout3 = this.zRk;
            if (relativeLayout3 != null) {
                relativeLayout3.setVisibility(0);
            }
            RelativeLayout relativeLayout4 = this.zRk;
            if (relativeLayout4 != null) {
                relativeLayout4.removeAllViews();
                com.tencent.mm.plugin.multitalk.ui.widget.projector.c cVar3 = this.zRj;
                if (cVar3 != null) {
                    cVar3.a(relativeLayout4);
                }
            }
            com.tencent.mm.plugin.multitalk.ui.widget.projector.c cVar4 = this.zRj;
            if (cVar4 != null) {
                cVar4.epl();
                AppMethodBeat.o(239768);
                return;
            }
            AppMethodBeat.o(239768);
        } else if (i2 == 0) {
            Log.i("AvatarLayoutHolder", "showScreenCastIcon invisible cause VISIBLE");
            eoA();
            RelativeLayout relativeLayout5 = this.zRk;
            if (relativeLayout5 != null) {
                relativeLayout5.removeAllViews();
                com.tencent.mm.plugin.multitalk.ui.widget.projector.c cVar5 = this.zRj;
                if (cVar5 != null) {
                    cVar5.a(relativeLayout5);
                }
            }
            com.tencent.mm.plugin.multitalk.ui.widget.projector.c cVar6 = this.zRj;
            if (cVar6 != null) {
                cVar6.Rw(i2);
                AppMethodBeat.o(239768);
                return;
            }
            AppMethodBeat.o(239768);
        } else {
            Log.i("AvatarLayoutHolder", "showScreenCastIcon invisible cause INVISIBLE");
            RelativeLayout relativeLayout6 = this.zRk;
            if (relativeLayout6 != null) {
                relativeLayout6.setVisibility(8);
            }
            com.tencent.mm.plugin.multitalk.ui.widget.projector.c cVar7 = this.zRj;
            if (cVar7 != null) {
                cVar7.epn();
                AppMethodBeat.o(239768);
                return;
            }
            AppMethodBeat.o(239768);
        }
    }

    private static boolean aGr(String str) {
        AppMethodBeat.i(239769);
        if (str == null) {
            AppMethodBeat.o(239769);
            return true;
        }
        boolean aFZ = ac.eom().aFZ(str);
        AppMethodBeat.o(239769);
        return aFZ;
    }

    public static /* synthetic */ void a(b bVar) {
        AppMethodBeat.i(239771);
        bVar.K(null);
        AppMethodBeat.o(239771);
    }

    public final void K(kotlin.g.a.b<? super String, x> bVar) {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator animate2;
        AppMethodBeat.i(239770);
        TextView textView = this.zQY;
        if (textView == null || textView.getVisibility() != 8) {
            eoA();
            AppMethodBeat.o(239770);
            return;
        }
        this.zRc = bVar;
        TextView textView2 = this.zQY;
        if (textView2 != null) {
            textView2.setText(this.userName);
        }
        View view = this.zQZ;
        if (view != null) {
            view.setAlpha(0.0f);
        }
        View view2 = this.zRa;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        TextView textView3 = this.zQY;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        MTimerHandler mTimerHandler = this.cve;
        if (mTimerHandler != null) {
            mTimerHandler.stopTimer();
        }
        MTimerHandler mTimerHandler2 = this.cve;
        if (mTimerHandler2 != null) {
            mTimerHandler2.removeCallbacksAndMessages(null);
        }
        MTimerHandler mTimerHandler3 = this.cve;
        if (mTimerHandler3 != null) {
            mTimerHandler3.quitSafely();
        }
        this.cve = new MTimerHandler(new d(this), false);
        View view3 = this.zQZ;
        if (!(view3 == null || (animate2 = view3.animate()) == null)) {
            animate2.cancel();
        }
        View view4 = this.zQZ;
        if (view4 == null || (animate = view4.animate()) == null || (alpha = animate.alpha(1.0f)) == null || (duration = alpha.setDuration(150)) == null) {
            AppMethodBeat.o(239770);
            return;
        }
        duration.setListener(new e(this));
        AppMethodBeat.o(239770);
    }

    public static final class d implements MTimerHandler.CallBack {
        final /* synthetic */ b zRn;

        d(b bVar) {
            this.zRn = bVar;
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(239765);
            b.c(this.zRn);
            AppMethodBeat.o(239765);
            return true;
        }
    }

    public static final class e implements Animator.AnimatorListener {
        final /* synthetic */ b zRn;

        e(b bVar) {
            this.zRn = bVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(239766);
            MTimerHandler mTimerHandler = this.zRn.cve;
            if (mTimerHandler != null) {
                mTimerHandler.startTimer(5000);
                AppMethodBeat.o(239766);
                return;
            }
            AppMethodBeat.o(239766);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.multitalk.ui.widget.b$b */
    public static final class C1494b implements Animator.AnimatorListener {
        final /* synthetic */ b zRn;

        C1494b(b bVar) {
            this.zRn = bVar;
        }

        public final void onAnimationRepeat(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(239762);
            TextView textView = this.zRn.zQY;
            if (textView != null) {
                textView.setVisibility(8);
            }
            View view = this.zRn.zRa;
            if (view != null) {
                view.setVisibility(8);
            }
            String str = this.zRn.userName;
            if (str != null) {
                kotlin.g.a.b bVar = this.zRn.zRc;
                if (bVar != null) {
                    bVar.invoke(str);
                    AppMethodBeat.o(239762);
                    return;
                }
                AppMethodBeat.o(239762);
                return;
            }
            AppMethodBeat.o(239762);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationStart(Animator animator) {
        }
    }

    private final void eoA() {
        ViewPropertyAnimator animate;
        ViewPropertyAnimator alpha;
        ViewPropertyAnimator duration;
        ViewPropertyAnimator animate2;
        AppMethodBeat.i(239772);
        View view = this.zQZ;
        if (!(view == null || (animate2 = view.animate()) == null)) {
            animate2.cancel();
        }
        View view2 = this.zQZ;
        if (!(view2 == null || (animate = view2.animate()) == null || (alpha = animate.alpha(0.0f)) == null || (duration = alpha.setDuration(150)) == null)) {
            duration.setListener(new C1494b(this));
        }
        MTimerHandler mTimerHandler = this.cve;
        if (mTimerHandler != null) {
            mTimerHandler.stopTimer();
        }
        MTimerHandler mTimerHandler2 = this.cve;
        if (mTimerHandler2 != null) {
            mTimerHandler2.removeCallbacksAndMessages(null);
        }
        MTimerHandler mTimerHandler3 = this.cve;
        if (mTimerHandler3 != null) {
            mTimerHandler3.quitSafely();
            AppMethodBeat.o(239772);
            return;
        }
        AppMethodBeat.o(239772);
    }

    public final void er(View view) {
        AppMethodBeat.i(239773);
        b(view, -2, -2, true);
        AppMethodBeat.o(239773);
    }

    public static /* synthetic */ void a(b bVar, boolean z, boolean z2, int i2) {
        AppMethodBeat.i(239775);
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        bVar.Z(z, z2);
        AppMethodBeat.o(239775);
    }

    public final void Z(boolean z, boolean z2) {
        AppMethodBeat.i(239774);
        if (this.zRi == 3) {
            AppMethodBeat.o(239774);
        } else if (z && this.zRi == 2) {
            AppMethodBeat.o(239774);
        } else if (z || this.zRi == -1) {
            View inflate = getLayoutInflater().inflate(R.layout.bci, (ViewGroup) this.zRd, false);
            p.g(inflate, "getLayoutInflater().infl…im, avatarOverlay, false)");
            View findViewById = inflate.findViewById(R.id.fob);
            p.g(findViewById, "center.findViewById(R.id…ltitalk_center_info_anim)");
            ImageView imageView = (ImageView) findViewById;
            if (!z || !z2) {
                View findViewById2 = inflate.findViewById(R.id.foc);
                p.g(findViewById2, "center.findViewById<Text…ltitalk_center_info_text)");
                ((TextView) findViewById2).setVisibility(8);
            }
            er(inflate);
            if (imageView.getBackground() instanceof AnimationDrawable) {
                Drawable background = imageView.getBackground();
                if (background == null) {
                    t tVar = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                    AppMethodBeat.o(239774);
                    throw tVar;
                }
                ((AnimationDrawable) background).start();
            }
            if (z) {
                this.zRi = 2;
                AppMethodBeat.o(239774);
                return;
            }
            this.zRi = 1;
            AppMethodBeat.o(239774);
        } else {
            AppMethodBeat.o(239774);
        }
    }

    private LayoutInflater getLayoutInflater() {
        AppMethodBeat.i(239776);
        View view = this.aus;
        p.g(view, "itemView");
        Object systemService = view.getContext().getSystemService("layout_inflater");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.LayoutInflater");
            AppMethodBeat.o(239776);
            throw tVar;
        }
        LayoutInflater layoutInflater = (LayoutInflater) systemService;
        AppMethodBeat.o(239776);
        return layoutInflater;
    }

    public static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(239778);
        bVar.rR(true);
        AppMethodBeat.o(239778);
    }

    public final void rR(boolean z) {
        AppMethodBeat.i(239777);
        if (!z && this.zRi == 2) {
            AppMethodBeat.o(239777);
        } else if (this.zRi != 1 && this.zRi != 2) {
            AppMethodBeat.o(239777);
        } else if (this.zRd.getChildCount() != 1) {
            AppMethodBeat.o(239777);
        } else {
            View childAt = this.zRd.getChildAt(0);
            p.g(childAt, "avatarOverlay.getChildAt(0)");
            ImageView imageView = (ImageView) childAt.findViewById(R.id.fob);
            if ((imageView != null ? imageView.getBackground() : null) instanceof AnimationDrawable) {
                Drawable background = imageView.getBackground();
                if (background == null) {
                    t tVar = new t("null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
                    AppMethodBeat.o(239777);
                    throw tVar;
                }
                ((AnimationDrawable) background).stop();
            }
            this.zRd.removeViewAt(0);
            this.zRi = -1;
            AppMethodBeat.o(239777);
        }
    }

    public static final class c implements Runnable {
        final /* synthetic */ b zRn;

        c(b bVar) {
            this.zRn = bVar;
        }

        public final void run() {
            AppMethodBeat.i(239764);
            if (this.zRn.zRi == 4) {
                com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.multitalk.ui.widget.b.c.AnonymousClass1 */
                    final /* synthetic */ c zRo;

                    {
                        this.zRo = r2;
                    }

                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(239763);
                        this.zRo.zRn.eoB();
                        x xVar = x.SXb;
                        AppMethodBeat.o(239763);
                        return xVar;
                    }
                });
            }
            AppMethodBeat.o(239764);
        }
    }

    private void b(View view, int i2, int i3, boolean z) {
        Bitmap createBitmap;
        x xVar;
        AppMethodBeat.i(239780);
        p.h(view, "centerView");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, i3, 17);
        if (z) {
            View view2 = this.aus;
            p.g(view2, "itemView");
            FrameLayout frameLayout = new FrameLayout(view2.getContext());
            boolean z2 = false;
            MultitalkFrameView multitalkFrameView = this.zQT;
            if (!(multitalkFrameView == null || (createBitmap = BitmapUtil.createBitmap(this.zRd.getWidth() / 4, this.zRd.getHeight() / 4, Bitmap.Config.ARGB_8888)) == null)) {
                try {
                    new Canvas(createBitmap).drawColor(WebView.NIGHT_MODE_COLOR);
                    MultitalkFrameView.b elementPrev = multitalkFrameView.getElementPrev();
                    if (!(elementPrev.zUW != null)) {
                        elementPrev = null;
                    }
                    if (elementPrev != null) {
                        String str = this.userName;
                        if (str == null) {
                            p.hyc();
                        }
                        Bitmap bitmap = elementPrev.zUW;
                        if (bitmap == null) {
                            p.hyc();
                        }
                        multitalkFrameView.a(str, bitmap, elementPrev.zUX, elementPrev.zUY);
                        xVar = x.SXb;
                    } else {
                        xVar = null;
                    }
                    if (xVar == null) {
                        z2 = false;
                    } else {
                        Bitmap fastblur = BitmapUtil.fastblur(createBitmap, 10);
                        View view3 = this.aus;
                        p.g(view3, "itemView");
                        BitmapDrawable bitmapDrawable = new BitmapDrawable(view3.getResources(), fastblur);
                        bitmapDrawable.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{0.3f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.3f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.3f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f})));
                        frameLayout.setBackground(bitmapDrawable);
                        z2 = true;
                    }
                } catch (Exception e2) {
                    Log.e("AvatarLayoutHolder", e2.getMessage() + ' ' + x.SXb);
                    z2 = false;
                }
            }
            if (!z2) {
                View view4 = this.aus;
                p.g(view4, "itemView");
                frameLayout.setBackgroundColor(view4.getResources().getColor(R.color.a1y));
            }
            frameLayout.addView(view, layoutParams);
            this.zRd.addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
            AppMethodBeat.o(239780);
            return;
        }
        this.zRd.addView(view, layoutParams);
        AppMethodBeat.o(239780);
    }

    public final void eoB() {
        AppMethodBeat.i(239781);
        if (this.zRi == 2 || this.zRi == 1) {
            rR(true);
        }
        this.zRd.removeAllViews();
        this.zRi = -1;
        this.zRi = -1;
        AppMethodBeat.o(239781);
    }

    public static /* synthetic */ void a(b bVar, boolean z) {
        AppMethodBeat.i(239779);
        if (bVar.zRi == -1) {
            View inflate = bVar.getLayoutInflater().inflate(R.layout.bcw, (ViewGroup) bVar.zRd, false);
            p.g(inflate, "getLayoutInflater().infl…fo, avatarOverlay, false)");
            if (!z) {
                ImageView imageView = (ImageView) inflate.findViewById(R.id.fov);
                if (imageView != null) {
                    imageView.setBackgroundResource(R.drawable.b73);
                }
                TextView textView = (TextView) inflate.findViewById(R.id.fow);
                if (textView != null) {
                    textView.setText(R.string.f6w);
                }
                inflate.setRotation(90.0f);
            }
            bVar.zRi = 4;
            View view = bVar.aus;
            p.g(view, "itemView");
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(R.dimen.c3);
            View view2 = bVar.aus;
            p.g(view2, "itemView");
            bVar.b(inflate, dimensionPixelSize, view2.getResources().getDimensionPixelSize(R.dimen.c3), false);
            h.RTc.o(new c(bVar), 3000);
        }
        AppMethodBeat.o(239779);
    }
}
