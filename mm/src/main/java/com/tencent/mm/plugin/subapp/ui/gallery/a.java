package com.tencent.mm.plugin.subapp.ui.gallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ay;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;

public final class a {
    AbstractC1792a FKT;
    boolean FKU;
    MMActivity activity;
    a.AbstractC1683a tgK;
    com.tencent.mm.plugin.scanner.word.a tgL;
    volatile int tgM;
    int tgN = 0;
    ImageView tgP;
    ImageView tgQ;
    ImageView tgR;
    ValueAnimator tgS;
    IListener<tp> tgT = new IListener<tp>() {
        /* class com.tencent.mm.plugin.subapp.ui.gallery.a.AnonymousClass1 */

        {
            AppMethodBeat.i(161446);
            this.__eventId = tp.class.getName().hashCode();
            AppMethodBeat.o(161446);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tp tpVar) {
            AppMethodBeat.i(29055);
            final tp tpVar2 = tpVar;
            Log.i("MicroMsg.GestureGalleryTransLogic", "scanTranslationResult %d, %s", Integer.valueOf(tpVar2.dZZ.dEb), Boolean.valueOf(tpVar2.dZZ.dDz));
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.subapp.ui.gallery.a.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(29054);
                    if (a.this.tgM == tpVar2.dZZ.dEb) {
                        a.this.cWh();
                        if (tpVar2.dZZ.dDz) {
                            if (s.YS(tpVar2.dZZ.eaa)) {
                                String cVV = a.this.FKT.cVV();
                                Intent intent = new Intent();
                                intent.putExtra("original_file_path", cVV);
                                intent.putExtra("translate_source", tpVar2.dZZ.source);
                                intent.setClass(a.this.activity, TranslationResultUI.class);
                                MMActivity mMActivity = a.this.activity;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                mMActivity.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                a.this.activity.finish();
                                a.this.activity.overridePendingTransition(R.anim.s, R.anim.s);
                                AppMethodBeat.o(29054);
                                return;
                            }
                            Log.w("MicroMsg.GestureGalleryTransLogic", "trans result path %s not exist!", tpVar2.dZZ.eaa);
                        }
                        a.this.tgM = 0;
                        h.a((Context) a.this.activity, a.this.activity.getString(R.string.ge4), "", false, (DialogInterface.OnClickListener) null);
                    }
                    AppMethodBeat.o(29054);
                }
            });
            AppMethodBeat.o(29055);
            return true;
        }
    };
    p tgU = new p.a() {
        /* class com.tencent.mm.plugin.subapp.ui.gallery.a.AnonymousClass2 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(29057);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.subapp.ui.gallery.a.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(29056);
                    if (!(g.azz().aYS() == 6 || g.azz().aYS() == 4 || a.this.tgN != 1)) {
                        h.c(a.this.activity, a.this.activity.getString(R.string.x3), "", true);
                        a.this.cWh();
                    }
                    AppMethodBeat.o(29056);
                }
            });
            AppMethodBeat.o(29057);
        }
    };

    /* renamed from: com.tencent.mm.plugin.subapp.ui.gallery.a$a  reason: collision with other inner class name */
    public interface AbstractC1792a {
        String cVV();
    }

    public a(MMActivity mMActivity, AbstractC1792a aVar, a.AbstractC1683a aVar2, boolean z) {
        AppMethodBeat.i(29062);
        this.tgK = aVar2;
        this.activity = mMActivity;
        this.FKT = aVar;
        this.FKU = z;
        this.tgQ = (ImageView) this.activity.findViewById(R.id.hb1);
        this.tgR = (ImageView) this.activity.findViewById(R.id.haz);
        this.tgP = (ImageView) this.activity.findViewById(R.id.hb2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.tgR.getLayoutParams();
        layoutParams.bottomMargin += ao.aD(this.activity);
        this.tgR.setLayoutParams(layoutParams);
        this.tgR.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.a.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(29058);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ay ayVar = new ay();
                ayVar.dEa.scene = a.this.FKU ? 6 : 5;
                ayVar.dEa.dEb = a.this.tgM;
                EventCenter.instance.publish(ayVar);
                a.this.cWh();
                a.this.tgM = 0;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/subapp/ui/gallery/GestureGalleryTransLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29058);
            }
        });
        this.tgS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.tgS.setDuration(5000L);
        this.tgS.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.a.AnonymousClass4 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(29059);
                a.this.tgP.setAlpha(0.0f);
                AppMethodBeat.o(29059);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(29060);
                a.this.tgP.setAlpha(0.0f);
                AppMethodBeat.o(29060);
            }
        });
        final int height = this.activity.getWindowManager().getDefaultDisplay().getHeight();
        this.tgS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.subapp.ui.gallery.a.AnonymousClass5 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(29061);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue <= 0.1f) {
                    a.this.tgP.setAlpha(floatValue * 10.0f);
                } else if (floatValue >= 0.9f) {
                    a.this.tgP.setAlpha((1.0f - floatValue) * 10.0f);
                }
                a.this.tgP.setTranslationY(floatValue * ((float) (height - a.this.tgP.getHeight())));
                AppMethodBeat.o(29061);
            }
        });
        this.tgT.alive();
        AppMethodBeat.o(29062);
    }

    public final void cWh() {
        AppMethodBeat.i(29063);
        this.tgN = 0;
        this.tgP.setVisibility(8);
        this.tgQ.setVisibility(8);
        this.tgR.setVisibility(8);
        cWj();
        AppMethodBeat.o(29063);
    }

    /* access modifiers changed from: package-private */
    public final void cWj() {
        AppMethodBeat.i(29064);
        this.tgS.setRepeatMode(1);
        this.tgS.setRepeatCount(0);
        this.tgS.end();
        AppMethodBeat.o(29064);
    }
}
