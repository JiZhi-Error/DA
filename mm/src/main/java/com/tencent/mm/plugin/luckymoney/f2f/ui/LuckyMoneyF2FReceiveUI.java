package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.luckymoney.f2f.a.c;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.d;
import java.io.IOException;

@a(3)
public class LuckyMoneyF2FReceiveUI extends LuckyMoneyBaseUI {
    private String ehh;
    private DisplayMetrics metrics;
    private String rCq;
    private String yQE;
    private int yRL;
    private String yRQ;
    private String yRS;
    private String yRT;
    private TextView ySp;
    private View yTp;
    private CdnImageView yTq;
    private TextView yTr;
    private ImageView yTs;
    private ValueAnimator yTt;
    private ValueAnimator yTu;
    private Intent yTv;
    private boolean yTw = false;

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(LuckyMoneyF2FReceiveUI luckyMoneyF2FReceiveUI, Class cls, Intent intent) {
        AppMethodBeat.i(65113);
        luckyMoneyF2FReceiveUI.startActivity(cls, intent);
        AppMethodBeat.o(65113);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(65109);
        super.onCreate(bundle);
        this.yTp = findViewById(R.id.f41);
        this.yTq = (CdnImageView) findViewById(R.id.f45);
        this.ySp = (TextView) findViewById(R.id.f46);
        this.yTr = (TextView) findViewById(R.id.f48);
        this.yTs = (ImageView) findViewById(R.id.f4e);
        this.yTs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(65102);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                LuckyMoneyF2FReceiveUI.this.yTu.cancel();
                LuckyMoneyF2FReceiveUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/f2f/ui/LuckyMoneyF2FReceiveUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(65102);
            }
        });
        getContentView().setVisibility(8);
        this.rCq = getIntent().getStringExtra("key_share_url");
        k.aeJ(6);
        doSceneProgress(new c(this.rCq), true);
        this.metrics = getResources().getDisplayMetrics();
        this.yTt = ValueAnimator.ofFloat(1.0f, 0.0f).setDuration(300L);
        this.yTu = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(300L);
        this.yTu.setStartDelay(1000);
        this.yTt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.AnonymousClass2 */

            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(65103);
                LuckyMoneyF2FReceiveUI.this.yTp.setTranslationY((-((Float) valueAnimator.getAnimatedValue()).floatValue()) * ((float) LuckyMoneyF2FReceiveUI.this.metrics.heightPixels));
                AppMethodBeat.o(65103);
            }
        });
        this.yTt.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.AnonymousClass3 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(65104);
                Log.i("LuckyMoneyF2FReceiveUI", "packet top in animator end");
                LuckyMoneyF2FReceiveUI.this.yTu.start();
                AppMethodBeat.o(65104);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        this.yTu.addListener(new Animator.AnimatorListener() {
            /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.AnonymousClass4 */

            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(65105);
                Log.i("LuckyMoneyF2FReceiveUI", "packet exit animator end");
                if (LuckyMoneyF2FReceiveUI.this.yTv != null) {
                    LuckyMoneyF2FReceiveUI.a(LuckyMoneyF2FReceiveUI.this, LuckyMoneyBeforeDetailUI.class, LuckyMoneyF2FReceiveUI.this.yTv);
                }
                LuckyMoneyF2FReceiveUI.this.setResult(-1, null);
                LuckyMoneyF2FReceiveUI.this.finish();
                if (LuckyMoneyF2FReceiveUI.this.yTv != null) {
                    LuckyMoneyF2FReceiveUI.this.overridePendingTransition(R.anim.dd, R.anim.di);
                }
                AppMethodBeat.o(65105);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        AppMethodBeat.o(65109);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.b3v;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(65110);
        super.onResume();
        addSceneEndListener(1997);
        if (this.yTw) {
            finish();
        }
        AppMethodBeat.o(65110);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStop() {
        AppMethodBeat.i(65111);
        super.onStop();
        removeSceneEndListener(1997);
        AppMethodBeat.o(65111);
    }

    @Override // com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(65112);
        Log.i("LuckyMoneyF2FReceiveUI", "errType: %d,errCode: %d,errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (!(qVar instanceof c)) {
            AppMethodBeat.o(65112);
            return true;
        }
        c cVar = (c) qVar;
        int i4 = cVar.egZ;
        int i5 = cVar.yRK;
        this.yRL = cVar.yRL;
        int i6 = cVar.yRN;
        String str2 = cVar.yRO;
        String str3 = cVar.yRP;
        Log.i("LuckyMoneyF2FReceiveUI", "hbStatus: %d, recvStatus:%d, errorType:%d", Integer.valueOf(cVar.egZ), Integer.valueOf(cVar.yRK), Integer.valueOf(cVar.dGe));
        if (com.tencent.mm.plugin.wallet_core.utils.c.a(cVar.yRJ.Lus)) {
            com.tencent.mm.plugin.wallet_core.utils.c cVar2 = new com.tencent.mm.plugin.wallet_core.utils.c(this);
            cVar2.b(cVar.yRJ.Lus);
            cVar2.IoO = true;
            AppMethodBeat.o(65112);
            return true;
        } else if (i5 == 2) {
            if (i4 == 5) {
                m.vli.a(s.bh.RED_PACKET_EXPIRED_NOTIFY, s.bg.UNKNOWN, true);
                h.d(this, getString(R.string.ep_), "", new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.AnonymousClass5 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(65106);
                        LuckyMoneyF2FReceiveUI.this.finish();
                        AppMethodBeat.o(65106);
                    }
                });
            } else {
                this.yQE = cVar.yQE;
                this.ehh = cVar.ehh;
                this.yRS = cVar.yRS;
                this.yRT = cVar.yRT;
                this.yRQ = cVar.yRQ;
                this.yTv = new Intent();
                if (Util.isNullOrNil(this.yRS)) {
                    if (!Util.isNullOrNil(this.ehh) && !ab.IS(this.ehh)) {
                        i iVar = new i();
                        iVar.username = this.ehh;
                        p.aYB().b(iVar);
                    }
                    af.a(this.yTq, (String) null, this.ehh);
                } else {
                    int fromDPToPix = BackwardSupportUtil.BitmapFactory.fromDPToPix(this, 48.0f);
                    this.yTq.setRoundCorner(true);
                    this.yTq.s(this.yRS, fromDPToPix, fromDPToPix, R.drawable.bcb);
                }
                com.tencent.mm.plugin.luckymoney.model.q qVar2 = new com.tencent.mm.plugin.luckymoney.model.q();
                qVar2.eht = (long) this.yRL;
                qVar2.yQE = this.yQE;
                qVar2.egZ = i4;
                qVar2.eha = i5;
                qVar2.yRP = str3;
                qVar2.yRN = i6;
                qVar2.yVy = this.ehh;
                qVar2.yRO = str2;
                if (Util.isNullOrNil(this.yRT)) {
                    qVar2.yVd = af.Ir(this.ehh);
                } else {
                    qVar2.yVd = this.yRT;
                }
                qVar2.yRQ = this.yRQ;
                qVar2.egY = 2;
                Log.i("LuckyMoneyF2FReceiveUI", "is most lucky %d", Integer.valueOf(cVar.yRR));
                if (cVar.yRR > 0) {
                    qVar2.yVc = getString(R.string.eq2);
                }
                if (Util.isNullOrNil(this.yRS)) {
                    qVar2.yVe = af.aDw(this.ehh);
                } else {
                    qVar2.yVe = this.yRS;
                }
                try {
                    this.yTv.putExtra("key_detail_info", qVar2.toByteArray());
                    dju dju = cVar.yRM;
                    if (dju != null) {
                        RealnameGuideHelper realnameGuideHelper = new RealnameGuideHelper();
                        realnameGuideHelper.b(String.valueOf(dju.KCl), dju.yXJ, dju.lHA, dju.lHB, dju.yXK, qVar.getType());
                        this.yTv.putExtra("key_realname_guide_helper", realnameGuideHelper);
                    }
                } catch (IOException e2) {
                    Log.e("LuckyMoneyF2FReceiveUI", "lucky detail toBytes error: " + e2.getMessage());
                }
                if (!Util.isNullOrNil(this.yRT)) {
                    af.a(this, this.ySp, this.yRT);
                } else {
                    if (!Util.isNullOrNil(this.yQE, this.ehh)) {
                        af.a(this, this.ySp, af.Ir(this.ehh));
                    }
                }
                af.a(this, this.yTr, this.yRQ);
                this.yTt.start();
                getContentView().setVisibility(0);
            }
            AppMethodBeat.o(65112);
            return true;
        } else {
            if (cVar.yRM != null) {
                Log.i("LuckyMoneyF2FReceiveUI", "need real name verify");
                dju dju2 = cVar.yRM;
                RealnameGuideHelper realnameGuideHelper2 = new RealnameGuideHelper();
                realnameGuideHelper2.b(String.valueOf(dju2.KCl), dju2.yXJ, dju2.lHA, dju2.lHB, dju2.yXK, qVar.getType());
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".f2f.ui.LuckyMoneyF2FReceiveUI");
                bundle.putString("realname_verify_process_jump_plugin", "luckymoney");
                if (realnameGuideHelper2.a(this, bundle, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.AnonymousClass6 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(65107);
                        LuckyMoneyF2FReceiveUI.this.finish();
                        AppMethodBeat.o(65107);
                    }
                }, new d.a() {
                    /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.AnonymousClass7 */

                    @Override // com.tencent.mm.wallet_core.d.a
                    public final Intent q(int i2, Bundle bundle) {
                        return null;
                    }
                }, false)) {
                    this.yTw = true;
                    AppMethodBeat.o(65112);
                    return true;
                }
            }
            if (Util.isNullOrNil(str)) {
                str = getString(R.string.epf);
            }
            h.d(this, str, "", new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FReceiveUI.AnonymousClass8 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(65108);
                    LuckyMoneyF2FReceiveUI.this.finish();
                    AppMethodBeat.o(65108);
                }
            });
            AppMethodBeat.o(65112);
            return true;
        }
    }
}
