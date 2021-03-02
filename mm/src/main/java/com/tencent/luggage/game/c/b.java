package com.tencent.luggage.game.c;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.view.View;
import com.tencent.luggage.game.b.c;
import com.tencent.luggage.game.c.g;
import com.tencent.magicbrush.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.utils.r;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class b {
    private static final String cuR = ("wagame://" + WeChatHosts.domainString(R.string.e2b) + "/WAGameVConsole.html");
    public g cuP;
    private k cuQ;
    boolean cuS = false;
    public View cuT;
    private LinkedList<String> cuU;
    private boolean cuV = false;
    private e cuW;
    private Context mContext;

    static /* synthetic */ void a(b bVar, String str) {
        AppMethodBeat.i(222874);
        bVar.dm(str);
        AppMethodBeat.o(222874);
    }

    static /* synthetic */ int d(b bVar) {
        AppMethodBeat.i(222875);
        int displayHeight = bVar.getDisplayHeight();
        AppMethodBeat.o(222875);
        return displayHeight;
    }

    public static b a(e eVar, Context context, k kVar) {
        AppMethodBeat.i(222872);
        b bVar = new b(c.LV().cuE, eVar, context, kVar);
        AppMethodBeat.o(222872);
        return bVar;
    }

    private b(g gVar, e eVar, Context context, k kVar) {
        AppMethodBeat.i(130495);
        this.cuQ = kVar;
        this.cuP = gVar;
        this.mContext = context;
        this.cuW = eVar;
        this.cuP.aF(context);
        this.cuP.Ma().Mb();
        this.cuT = new a(this.mContext);
        this.cuT.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.luggage.game.c.b.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(130487);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/luggage/game/inspector/ConsoleViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b bVar2 = b.this;
                if (bVar2.cuS) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                    ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        /* class com.tencent.luggage.game.c.b.AnonymousClass3 */
                        int height = b.d(b.this);

                        {
                            AppMethodBeat.i(130491);
                            AppMethodBeat.o(130491);
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            AppMethodBeat.i(130492);
                            if (((Float) valueAnimator.getAnimatedValue()).floatValue() == 1.0f) {
                                b.this.cuP.setVisibility(8);
                                AppMethodBeat.o(130492);
                                return;
                            }
                            b.this.cuP.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) this.height));
                            b.this.cuP.requestLayout();
                            AppMethodBeat.o(130492);
                        }
                    });
                    ofFloat.start();
                    bVar2.cuS = false;
                } else {
                    bVar2.cuP.setTranslationY((float) bVar2.getDisplayHeight());
                    bVar2.cuP.setVisibility(0);
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
                    ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        /* class com.tencent.luggage.game.c.b.AnonymousClass4 */
                        int height = b.d(b.this);

                        {
                            AppMethodBeat.i(130493);
                            AppMethodBeat.o(130493);
                        }

                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            AppMethodBeat.i(130494);
                            b.this.cuP.setTranslationY(((Float) valueAnimator.getAnimatedValue()).floatValue() * ((float) this.height));
                            b.this.cuP.requestLayout();
                            AppMethodBeat.o(130494);
                        }
                    });
                    ofFloat2.start();
                    bVar2.cuS = true;
                }
                a.a(this, "com/tencent/luggage/game/inspector/ConsoleViewWrapper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(130487);
            }
        });
        this.cuP.a(new g.b() {
            /* class com.tencent.luggage.game.c.b.AnonymousClass2 */

            @Override // com.tencent.luggage.game.c.g.b
            public final boolean dn(String str) {
                AppMethodBeat.i(130488);
                boolean equals = b.cuR.equals(str);
                AppMethodBeat.o(130488);
                return equals;
            }

            @Override // com.tencent.luggage.game.c.g.b
            public final void LZ() {
                AppMethodBeat.i(130489);
                b.this.cuV = true;
                if (b.this.cuU != null && !b.this.cuU.isEmpty()) {
                    Iterator it = b.this.cuU.iterator();
                    while (it.hasNext()) {
                        b.a(b.this, (String) it.next());
                    }
                }
                AppMethodBeat.o(130489);
            }

            @Override // com.tencent.luggage.game.c.g.b
            /* renamed from: do  reason: not valid java name */
            public final InputStream m3do(String str) {
                AppMethodBeat.i(130490);
                InputStream openRead = b.this.cuQ.bqZ().openRead(str);
                AppMethodBeat.o(130490);
                return openRead;
            }
        });
        this.cuP.loadUrl(cuR);
        this.cuP.setTranslationY(100000.0f);
        this.cuP.setVisibility(8);
        AppMethodBeat.o(130495);
    }

    static {
        AppMethodBeat.i(222876);
        AppMethodBeat.o(222876);
    }

    /* access modifiers changed from: package-private */
    public final int getDisplayHeight() {
        AppMethodBeat.i(130496);
        int width = ((int) (((float) this.cuW.cLz.find(0).getWidth()) * this.mContext.getResources().getDisplayMetrics().density)) + 1;
        AppMethodBeat.o(130496);
        return width;
    }

    public final void log(String str) {
        AppMethodBeat.i(130497);
        if (this.cuV) {
            dm(str);
            AppMethodBeat.o(130497);
            return;
        }
        if (this.cuU == null) {
            this.cuU = new LinkedList<>();
        }
        this.cuU.add(str);
        AppMethodBeat.o(130497);
    }

    private void dm(String str) {
        AppMethodBeat.i(130498);
        String afJ = r.afJ(str);
        if (Build.VERSION.SDK_INT >= 19) {
            this.cuP.dp("console._log('" + afJ + "')");
            AppMethodBeat.o(130498);
            return;
        }
        this.cuP.loadUrl("javascript:console._log('" + afJ + "')");
        AppMethodBeat.o(130498);
    }

    public final void post(Runnable runnable) {
        AppMethodBeat.i(130499);
        this.cuP.getView().post(runnable);
        AppMethodBeat.o(130499);
    }

    public final View getView() {
        AppMethodBeat.i(222873);
        View view = this.cuP.getView();
        AppMethodBeat.o(222873);
        return view;
    }
}
