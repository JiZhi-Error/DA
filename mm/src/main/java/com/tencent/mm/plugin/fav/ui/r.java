package com.tencent.mm.plugin.fav.ui;

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
import com.tencent.mm.g.a.to;
import com.tencent.mm.g.a.tp;
import com.tencent.mm.g.b.a.ep;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.plugin.scanner.ui.TranslationResultUI;
import com.tencent.mm.plugin.scanner.word.ImageWordScanDetailEngine;
import com.tencent.mm.plugin.scanner.word.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;

public final class r {
    MMActivity activity;
    private a.AbstractC1683a tgK;
    private com.tencent.mm.plugin.scanner.word.a tgL;
    volatile int tgM;
    public int tgN = 0;
    a tgO;
    ImageView tgP;
    private ImageView tgQ;
    private ImageView tgR;
    private ValueAnimator tgS;
    private IListener<tp> tgT = new IListener<tp>() {
        /* class com.tencent.mm.plugin.fav.ui.r.AnonymousClass1 */

        {
            AppMethodBeat.i(160918);
            this.__eventId = tp.class.getName().hashCode();
            AppMethodBeat.o(160918);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(tp tpVar) {
            AppMethodBeat.i(107066);
            final tp tpVar2 = tpVar;
            Log.i("MicroMsg.PhotoTransControl", "scanTranslationResult %d, %s", Integer.valueOf(tpVar2.dZZ.dEb), Boolean.valueOf(tpVar2.dZZ.dDz));
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.r.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(107065);
                    if (r.this.tgM == tpVar2.dZZ.dEb) {
                        r.this.cWh();
                        if (tpVar2.dZZ.dDz) {
                            if (s.YS(tpVar2.dZZ.eaa)) {
                                String cVV = r.this.tgO.cVV();
                                Intent intent = new Intent();
                                intent.putExtra("original_file_path", cVV);
                                intent.putExtra("translate_source", tpVar2.dZZ.source);
                                intent.setClass(r.this.activity, TranslationResultUI.class);
                                intent.putExtra("fileid", r.this.tgO.getFileId());
                                intent.putExtra("aeskey", r.this.tgO.getAesKey());
                                MMActivity mMActivity = r.this.activity;
                                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/fav/ui/PhotoTransControl$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                mMActivity.startActivity((Intent) bl.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/fav/ui/PhotoTransControl$1$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                r.this.activity.finish();
                                r.this.activity.overridePendingTransition(R.anim.s, R.anim.s);
                                AppMethodBeat.o(107065);
                                return;
                            }
                            Log.w("MicroMsg.PhotoTransControl", "trans result path %s not exist!", tpVar2.dZZ.eaa);
                        }
                        r.this.tgM = 0;
                        h.a((Context) r.this.activity, r.this.activity.getString(R.string.ge4), "", false, (DialogInterface.OnClickListener) null);
                    }
                    AppMethodBeat.o(107065);
                }
            });
            AppMethodBeat.o(107066);
            return true;
        }
    };
    private p tgU = new p.a() {
        /* class com.tencent.mm.plugin.fav.ui.r.AnonymousClass2 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(107068);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.fav.ui.r.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(107067);
                    if (!(g.azz().aYS() == 6 || g.azz().aYS() == 4 || r.this.tgN != 1)) {
                        h.c(r.this.activity, r.this.activity.getString(R.string.x3), "", true);
                        r.this.cWh();
                    }
                    AppMethodBeat.o(107067);
                }
            });
            AppMethodBeat.o(107068);
        }
    };

    public interface a {
        String cVV();

        String getAesKey();

        String getFileId();
    }

    public r(MMActivity mMActivity, a aVar, a.AbstractC1683a aVar2) {
        AppMethodBeat.i(107073);
        this.tgK = aVar2;
        this.activity = mMActivity;
        this.tgO = aVar;
        this.tgQ = (ImageView) this.activity.findViewById(R.id.hb1);
        this.tgR = (ImageView) this.activity.findViewById(R.id.haz);
        this.tgP = (ImageView) this.activity.findViewById(R.id.hb2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.tgR.getLayoutParams();
        layoutParams.bottomMargin += ao.aD(this.activity);
        this.tgR.setLayoutParams(layoutParams);
        this.tgR.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.fav.ui.r.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(107069);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/PhotoTransControl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                ay ayVar = new ay();
                ayVar.dEa.scene = 1;
                ayVar.dEa.dEb = r.this.tgM;
                EventCenter.instance.publish(ayVar);
                r.this.cWh();
                r.this.tgM = 0;
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/PhotoTransControl$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(107069);
            }
        });
        this.tgS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.tgS.setDuration(5000L);
        this.tgS.addListener(new AnimatorListenerAdapter() {
            /* class com.tencent.mm.plugin.fav.ui.r.AnonymousClass4 */

            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(107070);
                r.this.tgP.setAlpha(0.0f);
                AppMethodBeat.o(107070);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(107071);
                r.this.tgP.setAlpha(0.0f);
                AppMethodBeat.o(107071);
            }
        });
        final int height = this.activity.getWindowManager().getDefaultDisplay().getHeight();
        this.tgS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.fav.ui.r.AnonymousClass5 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(107072);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue <= 0.1f) {
                    r.this.tgP.setAlpha(floatValue * 10.0f);
                } else if (floatValue >= 0.9f) {
                    r.this.tgP.setAlpha((1.0f - floatValue) * 10.0f);
                }
                r.this.tgP.setTranslationY(floatValue * ((float) (height - r.this.tgP.getHeight())));
                AppMethodBeat.o(107072);
            }
        });
        this.tgT.alive();
        AppMethodBeat.o(107073);
    }

    public final void onDestroy() {
        AppMethodBeat.i(107074);
        cWj();
        this.tgS.removeAllUpdateListeners();
        this.tgT.dead();
        g.aAg().b(this.tgU);
        this.tgK = null;
        this.activity = null;
        this.tgO = null;
        AppMethodBeat.o(107074);
    }

    public final void cWf() {
        long j2;
        AppMethodBeat.i(107075);
        String cVV = this.tgO.cVV();
        if ((this.tgN == 0 || this.tgN == 2) && !Util.isNullOrNil(cVV)) {
            ep epVar = new ep();
            epVar.eDV = 5;
            if (this.tgN == 2) {
                j2 = 1;
            } else {
                j2 = 0;
            }
            epVar.erW = j2;
            epVar.ejA = 3;
            epVar.rK(this.tgO.getFileId());
            epVar.rL(this.tgO.getAesKey());
            epVar.bfK();
            this.tgM = (int) (((long) z.aTY().hashCode()) + System.currentTimeMillis());
            fx translationResult = ((e) g.ah(e.class)).getTranslationResult(cVV);
            if (translationResult == null || !s.YS(translationResult.field_resultFile)) {
                cWg();
                Log.i("MicroMsg.PhotoTransControl", "try to translate img %s, sessionId %d", cVV, Integer.valueOf(this.tgM));
                to toVar = new to();
                toVar.dZY.scene = 2;
                toVar.dZY.filePath = cVV;
                toVar.dZY.dEb = this.tgM;
                EventCenter.instance.publish(toVar);
            } else {
                Intent intent = new Intent();
                intent.putExtra("original_file_path", cVV);
                intent.putExtra("translate_source", 5);
                intent.setClass(this.activity, TranslationResultUI.class);
                intent.putExtra("fileid", this.tgO.getFileId());
                intent.putExtra("aeskey", this.tgO.getAesKey());
                MMActivity mMActivity = this.activity;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                mMActivity.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/fav/ui/PhotoTransControl", "doTransPhoto", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                this.activity.finish();
                this.activity.overridePendingTransition(R.anim.s, R.anim.s);
                AppMethodBeat.o(107075);
                return;
            }
        }
        AppMethodBeat.o(107075);
    }

    public final void scan(String str) {
        AppMethodBeat.i(107076);
        if (this.activity == null || this.activity.isFinishing()) {
            AppMethodBeat.o(107076);
            return;
        }
        if (this.tgL == null) {
            this.tgL = new ImageWordScanDetailEngine(this.activity);
        }
        this.tgL.a(str, this.tgK);
        AppMethodBeat.o(107076);
    }

    private void cWg() {
        AppMethodBeat.i(107077);
        if (g.azz().aYS() == 6 || g.azz().aYS() == 4) {
            this.tgN = 1;
            this.tgP.setVisibility(0);
            this.tgQ.setVisibility(0);
            this.tgR.setVisibility(0);
            cWi();
            AppMethodBeat.o(107077);
            return;
        }
        h.c(this.activity, this.activity.getString(R.string.x3), "", true);
        cWh();
        AppMethodBeat.o(107077);
    }

    public final void cWh() {
        AppMethodBeat.i(107078);
        this.tgN = 0;
        this.tgP.setVisibility(8);
        this.tgQ.setVisibility(8);
        this.tgR.setVisibility(8);
        cWj();
        AppMethodBeat.o(107078);
    }

    private void cWi() {
        AppMethodBeat.i(107079);
        this.tgS.setRepeatMode(1);
        this.tgS.setRepeatCount(-1);
        this.tgS.start();
        AppMethodBeat.o(107079);
    }

    private void cWj() {
        AppMethodBeat.i(107080);
        this.tgS.setRepeatMode(1);
        this.tgS.setRepeatCount(0);
        this.tgS.end();
        AppMethodBeat.o(107080);
    }
}
