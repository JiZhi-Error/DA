package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.zd;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voiceprint.model.d;
import com.tencent.mm.plugin.voiceprint.model.f;
import com.tencent.mm.plugin.voiceprint.model.l;
import com.tencent.mm.plugin.voiceprint.model.o;
import com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView;
import com.tencent.mm.plugin.voiceprint.ui.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class VoiceCreateUI extends BaseVoicePrintUI implements l.a {
    private l GRS;
    private o GRT = null;
    private NoiseDetectMaskView GRU;
    private Button GRV = null;
    private int GRW = 0;
    private IListener GRX = new IListener<zd>() {
        /* class com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI.AnonymousClass1 */

        {
            AppMethodBeat.i(161461);
            this.__eventId = zd.class.getName().hashCode();
            AppMethodBeat.o(161461);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zd zdVar) {
            AppMethodBeat.i(29841);
            zd zdVar2 = zdVar;
            Log.d("MicroMsg.VoiceCreateUI", "detect finish, noise:%b", Boolean.valueOf(zdVar2.efn.efo));
            if (zdVar2.efn.efo) {
                VoiceCreateUI.a(VoiceCreateUI.this);
            } else {
                VoiceCreateUI.b(VoiceCreateUI.this);
            }
            AppMethodBeat.o(29841);
            return false;
        }
    };
    private int GRe = 1;
    private View pyo;
    private View qDs = null;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VoiceCreateUI() {
        AppMethodBeat.i(29849);
        AppMethodBeat.o(29849);
    }

    static /* synthetic */ void d(VoiceCreateUI voiceCreateUI) {
        AppMethodBeat.i(29864);
        voiceCreateUI.start();
        AppMethodBeat.o(29864);
    }

    static /* synthetic */ void e(VoiceCreateUI voiceCreateUI) {
        AppMethodBeat.i(29865);
        voiceCreateUI.fER();
        AppMethodBeat.o(29865);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
    public final void fEK() {
        AppMethodBeat.i(29850);
        Log.d("MicroMsg.VoiceCreateUI", "sendVoice, filename:%s", this.GRC);
        if (!Util.isNullOrNil(this.GRC)) {
            this.GRx.setEnabled(false);
            this.GRA.fEU();
            if (this.GRe == 1) {
                l lVar = this.GRS;
                f fVar = new f(this.GRC, 71, lVar.GRg, 0);
                fVar.GQR = true;
                bg.azz().a(fVar, 0);
                lVar.GRe = 71;
                AppMethodBeat.o(29850);
                return;
            } else if (this.GRe == 2) {
                l lVar2 = this.GRS;
                f fVar2 = new f(this.GRC, 72, lVar2.GRg, lVar2.GQT);
                fVar2.GQR = true;
                bg.azz().a(fVar2, 0);
                lVar2.GRe = 72;
            }
        }
        AppMethodBeat.o(29850);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
    public final void edG() {
        AppMethodBeat.i(29851);
        this.GRS = new l(this);
        findViewById(R.id.h6z).setVisibility(8);
        this.GRA.setTitleText(R.string.hzt);
        this.GRA.fEW();
        this.GRx.setEnabled(false);
        this.GRT = new o();
        this.pyo = findViewById(R.id.j9m);
        this.GRU = (NoiseDetectMaskView) findViewById(R.id.fa3);
        this.qDs = findViewById(R.id.ea8);
        this.GRV = (Button) findViewById(R.id.h6z);
        this.GRV.setVisibility(8);
        this.GRV.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(29843);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                VoiceCreateUI.this.fEI();
                a.a(VoiceCreateUI.this.GRA, new a.AbstractC1886a() {
                    /* class com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI.AnonymousClass2.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
                    public final void fEL() {
                        AppMethodBeat.i(29842);
                        VoiceCreateUI.this.GRV.setVisibility(8);
                        VoiceCreateUI.this.GRA.setTitleText(R.string.hzt);
                        VoiceCreateUI.this.GRA.BgP.setVisibility(0);
                        VoiceCreateUI.this.GRx.setEnabled(true);
                        VoiceCreateUI.this.GRx.setVisibility(0);
                        AppMethodBeat.o(29842);
                    }

                    @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
                    public final void fEM() {
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29843);
            }
        });
        this.GRU.setOnClickRetryCallback(new NoiseDetectMaskView.b() {
            /* class com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView.b
            public final void fEO() {
                AppMethodBeat.i(29844);
                h.INSTANCE.a(11390, 5);
                VoiceCreateUI.d(VoiceCreateUI.this);
                AppMethodBeat.o(29844);
            }
        });
        this.GRU.setOnCancelDetectCallback(new NoiseDetectMaskView.a() {
            /* class com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.voiceprint.ui.NoiseDetectMaskView.a
            public final void fEN() {
                AppMethodBeat.i(29845);
                VoiceCreateUI.e(VoiceCreateUI.this);
                o oVar = VoiceCreateUI.this.GRT;
                Log.d("MicroMsg.VoicePrintNoiseDetector", "stopDetect");
                oVar.GRj.ZZ();
                oVar.GRk.stopTimer();
                VoiceCreateUI.this.finish();
                AppMethodBeat.o(29845);
            }
        });
        EventCenter.instance.addListener(this.GRX);
        this.qDs.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(29846);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                VoiceCreateUI.e(VoiceCreateUI.this);
                VoiceCreateUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29846);
            }
        });
        start();
        AppMethodBeat.o(29851);
    }

    private void start() {
        AppMethodBeat.i(29852);
        Log.d("MicroMsg.VoiceCreateUI", "start create");
        this.GRT.reset();
        this.GRU.reset();
        fEQ();
        AppMethodBeat.o(29852);
    }

    private void fEQ() {
        AppMethodBeat.i(29853);
        Log.d("MicroMsg.VoiceCreateUI", "start noise detect");
        this.qDs.setVisibility(4);
        this.pyo.setVisibility(4);
        this.GRy.setVisibility(4);
        this.GRU.setVisibility(0);
        this.GRT.TR();
        AppMethodBeat.o(29853);
    }

    @Override // com.tencent.mm.plugin.voiceprint.model.l.a
    public final void aUs(String str) {
        AppMethodBeat.i(29854);
        Log.d("MicroMsg.VoiceCreateUI", "onGetFirstText");
        fEH();
        this.GRf = str;
        this.GRA.ekF();
        this.GRA.fEV();
        this.GRA.setTipText(str);
        this.GRx.setEnabled(true);
        AppMethodBeat.o(29854);
    }

    @Override // com.tencent.mm.plugin.voiceprint.model.l.a
    public final void aUt(String str) {
        AppMethodBeat.i(29855);
        Log.d("MicroMsg.VoiceCreateUI", "onGetSecondText");
        this.GRf = str;
        this.GRA.ekF();
        this.GRA.fEV();
        this.GRA.setTipText(str);
        this.GRx.setEnabled(true);
        AppMethodBeat.o(29855);
    }

    @Override // com.tencent.mm.plugin.voiceprint.model.l.a
    public final void Y(boolean z, int i2) {
        AppMethodBeat.i(29856);
        Log.d("MicroMsg.VoiceCreateUI", "onCreate, result:%b, step:%d", Boolean.valueOf(z), Integer.valueOf(i2));
        if (z) {
            switch (i2) {
                case 71:
                    Log.d("MicroMsg.VoiceCreateUI", "finish create step 1");
                    this.GRx.setEnabled(false);
                    this.GRe = 2;
                    fEI();
                    a.a(this.GRA, new a.AbstractC1886a() {
                        /* class com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI.AnonymousClass7 */

                        @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
                        public final void fEL() {
                            AppMethodBeat.i(29848);
                            VoiceCreateUI.this.GRA.reset();
                            VoiceCreateUI.this.GRA.fEV();
                            VoiceCreateUI.this.GRA.fEW();
                            VoiceCreateUI.this.GRx.setVisibility(4);
                            VoiceCreateUI.this.GRA.setTitleText(R.string.hzq);
                            VoiceCreateUI.this.GRV.setVisibility(0);
                            VoiceCreateUI.this.GRA.ekF();
                            AppMethodBeat.o(29848);
                        }

                        @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
                        public final void fEM() {
                        }
                    });
                    AppMethodBeat.o(29856);
                    return;
                case 72:
                    this.GRW = 0;
                    Log.d("MicroMsg.VoiceCreateUI", "finish create step 2");
                    Intent intent = new Intent();
                    intent.putExtra("KIsCreateSuccess", true);
                    setResult(-1, intent);
                    Intent intent2 = new Intent();
                    intent2.setClass(this, VoicePrintFinishUI.class);
                    intent2.putExtra("kscene_type", 72);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "finishCreateSecondStep", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "finishCreateSecondStep", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    finish();
                    break;
            }
            AppMethodBeat.o(29856);
            return;
        }
        switch (i2) {
            case 71:
                AppMethodBeat.o(29856);
                return;
            case 72:
                fER();
                this.GRW++;
                if (this.GRW < 2) {
                    this.GRx.setEnabled(true);
                    this.GRA.ekF();
                    this.GRA.setErr(R.string.hzv);
                    this.GRA.fEX();
                    break;
                } else {
                    Log.d("MicroMsg.VoiceCreateUI", "in second step, verify two times failed");
                    this.GRW = 0;
                    com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, VoiceReCreatePromptUI.class));
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl2.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/VoiceCreateUI", "promptToReCreate", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    overridePendingTransition(R.anim.eq, R.anim.en);
                    finish();
                    AppMethodBeat.o(29856);
                    return;
                }
        }
        AppMethodBeat.o(29856);
    }

    @Override // com.tencent.mm.plugin.voiceprint.model.l.a
    public final void fED() {
        AppMethodBeat.i(29857);
        fEJ();
        fER();
        AppMethodBeat.o(29857);
    }

    @Override // com.tencent.mm.plugin.voiceprint.model.l.a
    public final void aUu(String str) {
        AppMethodBeat.i(232126);
        if (Util.isNullOrNil(str)) {
            str = getString(R.string.hze);
        }
        this.GRA.ekF();
        this.GRA.setErr(str);
        this.GRA.fEX();
        fER();
        AppMethodBeat.o(232126);
    }

    private void fER() {
        AppMethodBeat.i(29859);
        Intent intent = new Intent();
        intent.putExtra("KIsCreateSuccess", false);
        setResult(-1, intent);
        AppMethodBeat.o(29859);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI
    public void onDestroy() {
        AppMethodBeat.i(29860);
        super.onDestroy();
        l lVar = this.GRS;
        bg.azz().b(611, lVar);
        bg.azz().b(612, lVar);
        lVar.GRh = null;
        EventCenter.instance.removeListener(this.GRX);
        AppMethodBeat.o(29860);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public void onBackPressed() {
        AppMethodBeat.i(29861);
        super.onBackPressed();
        fER();
        AppMethodBeat.o(29861);
    }

    static /* synthetic */ void a(VoiceCreateUI voiceCreateUI) {
        AppMethodBeat.i(29862);
        h.INSTANCE.a(11390, 4);
        NoiseDetectMaskView noiseDetectMaskView = voiceCreateUI.GRU;
        if (noiseDetectMaskView.krF != null) {
            noiseDetectMaskView.krF.setVisibility(8);
        }
        noiseDetectMaskView.xfB.setText(R.string.hzs);
        noiseDetectMaskView.GRM.setVisibility(0);
        AppMethodBeat.o(29862);
    }

    static /* synthetic */ void b(VoiceCreateUI voiceCreateUI) {
        AppMethodBeat.i(29863);
        voiceCreateUI.qDs.setVisibility(0);
        voiceCreateUI.pyo.setVisibility(0);
        voiceCreateUI.GRy.setVisibility(0);
        NoiseDetectMaskView noiseDetectMaskView = voiceCreateUI.GRU;
        AnonymousClass6 r10 = new a.AbstractC1886a() {
            /* class com.tencent.mm.plugin.voiceprint.ui.VoiceCreateUI.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
            public final void fEL() {
            }

            @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
            public final void fEM() {
                AppMethodBeat.i(29847);
                VoiceCreateUI.this.GRU.setVisibility(8);
                VoiceCreateUI.h(VoiceCreateUI.this);
                AppMethodBeat.o(29847);
            }
        };
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, -1.0f, 1, 0.0f, 1, 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatCount(0);
        translateAnimation.setAnimationListener(new Animation.AnimationListener(r10) {
            /* class com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass6 */
            final /* synthetic */ AbstractC1886a GSE;

            {
                this.GSE = r1;
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(29941);
                if (this.GSE != null) {
                    this.GSE.fEL();
                }
                AppMethodBeat.o(29941);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(29942);
                if (this.GSE != null) {
                    this.GSE.fEM();
                }
                AppMethodBeat.o(29942);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        noiseDetectMaskView.startAnimation(translateAnimation);
        AppMethodBeat.o(29863);
    }

    static /* synthetic */ void h(VoiceCreateUI voiceCreateUI) {
        AppMethodBeat.i(29866);
        voiceCreateUI.GRA.fEU();
        voiceCreateUI.GRe = 1;
        voiceCreateUI.GRS.GRe = 71;
        bg.azz().a(new d(71, ""), 0);
        AppMethodBeat.o(29866);
    }
}
