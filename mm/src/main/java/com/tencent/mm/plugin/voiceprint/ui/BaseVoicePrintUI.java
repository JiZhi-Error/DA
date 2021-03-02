package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.voiceprint.model.m;
import com.tencent.mm.plugin.voiceprint.model.p;
import com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView;
import com.tencent.mm.plugin.voiceprint.ui.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.o;
import java.util.Arrays;

public abstract class BaseVoicePrintUI extends MMActivity {
    VoiceTipInfoView GRA;
    p GRB = null;
    String GRC = null;
    private boolean GRD = false;
    private View GRE;
    private boolean GRF = false;
    private final p.a GRG = new p.a() {
        /* class com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.voiceprint.model.p.a
        public final void fEG() {
            AppMethodBeat.i(29811);
            p pVar = BaseVoicePrintUI.this.GRB;
            if (pVar.doF != null) {
                pVar.doF.ZZ();
                Log.e("MicroMsg.VoicePrintRecoder", "Reset recorder.stopReocrd");
            }
            pVar.fileName = "";
            pVar.GRo = null;
            pVar.FKi = 0;
            pVar.qPl = 0;
            pVar.GRr.wN(true);
            Log.e("MicroMsg.BaseVoicePrintUI", "record stop on error");
            BaseVoicePrintUI.this.GRC = null;
            BaseVoicePrintUI.b(BaseVoicePrintUI.this);
            AppMethodBeat.o(29811);
        }
    };
    MTimerHandler GRH = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(29814);
            VoiceTipInfoView voiceTipInfoView = BaseVoicePrintUI.this.GRA;
            if (voiceTipInfoView.BgP.getAnimation() == null) {
                TextView textView = voiceTipInfoView.BgP;
                Context context = voiceTipInfoView.getContext();
                VoiceTipInfoView.AnonymousClass1 r3 = new a.AbstractC1886a() {
                    /* class com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
                    public final void fEL() {
                    }

                    @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
                    public final void fEM() {
                    }
                };
                float width = (float) textView.getWidth();
                Log.d("MicroMsg.VoiceViewAnimationHelper", "target ".concat(String.valueOf(width)));
                int[] iArr = new int[2];
                textView.getLocationInWindow(iArr);
                Log.d("MicroMsg.VoiceViewAnimationHelper", "location %d %d preX=%d", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf((int) (width + ((float) iArr[0]))));
                Animation loadAnimation = AnimationUtils.loadAnimation(context, R.anim.f8);
                loadAnimation.setDuration(200);
                loadAnimation.setStartOffset(0);
                loadAnimation.setRepeatCount(0);
                loadAnimation.setFillAfter(true);
                loadAnimation.setAnimationListener(new Animation.AnimationListener(r3) {
                    /* class com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass1 */
                    final /* synthetic */ AbstractC1886a GSE;

                    {
                        this.GSE = r1;
                    }

                    public final void onAnimationStart(Animation animation) {
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationEnd(Animation animation) {
                        AppMethodBeat.i(29934);
                        if (this.GSE != null) {
                            this.GSE.fEM();
                        }
                        Log.d("MicroMsg.VoiceViewAnimationHelper", "playTipAnim end");
                        AppMethodBeat.o(29934);
                    }
                });
                textView.startAnimation(loadAnimation);
            }
            AppMethodBeat.o(29814);
            return false;
        }
    }, true);
    private MMHandler GRI = new MMHandler(Looper.getMainLooper(), new MMHandler.Callback() {
        /* class com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.AnonymousClass5 */

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(29816);
            if (message.what == 1) {
                Log.d("MicroMsg.BaseVoicePrintUI", "start record");
                PlaySound.play(MMApplicationContext.getContext(), (int) R.string.hl5, new PlaySound.OnPlayCompletionListener() {
                    /* class com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.AnonymousClass5.AnonymousClass1 */

                    @Override // com.tencent.mm.sdk.platformtools.PlaySound.OnPlayCompletionListener
                    public final void onCompletion() {
                        AppMethodBeat.i(29815);
                        Log.i("MicroMsg.BaseVoicePrintUI", "play press sound end");
                        AppMethodBeat.o(29815);
                    }
                });
                BaseVoicePrintUI.this.GRC = "voice_pt_voice_print_record.rec";
                p pVar = BaseVoicePrintUI.this.GRB;
                String str = BaseVoicePrintUI.this.GRC;
                BaseVoicePrintUI baseVoicePrintUI = BaseVoicePrintUI.this;
                pVar.fileName = str;
                Log.d("MicroMsg.VoicePrintRecoder", "start filename %s", pVar.fileName);
                pVar.GRr.hx(baseVoicePrintUI);
                BaseVoicePrintUI.this.yJN.startTimer(100);
                BaseVoicePrintUI baseVoicePrintUI2 = BaseVoicePrintUI.this;
                baseVoicePrintUI2.GRA.fEY();
                VoiceTipInfoView voiceTipInfoView = baseVoicePrintUI2.GRA;
                Log.d("MicroMsg.VoiceTipInfoView", "hideTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", Integer.valueOf(voiceTipInfoView.mPa.getVisibility()), Boolean.valueOf(voiceTipInfoView.GSx));
                if (voiceTipInfoView.mPa.getVisibility() != 0 || voiceTipInfoView.GSx) {
                    Log.d("MicroMsg.VoiceTipInfoView", "hideTitle, directly set to INVISIBLE");
                    voiceTipInfoView.mPa.clearAnimation();
                    voiceTipInfoView.mPa.setVisibility(4);
                    voiceTipInfoView.mPa.invalidate();
                } else {
                    voiceTipInfoView.mPa.clearAnimation();
                    voiceTipInfoView.GSx = true;
                    a.a(voiceTipInfoView.mPa, voiceTipInfoView.getContext(), new a.AbstractC1886a() {
                        /* class com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView.AnonymousClass3 */

                        @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
                        public final void fEL() {
                        }

                        @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
                        public final void fEM() {
                            AppMethodBeat.i(29907);
                            VoiceTipInfoView.this.mPa.setVisibility(4);
                            VoiceTipInfoView.this.GSx = false;
                            AppMethodBeat.o(29907);
                        }
                    });
                }
                baseVoicePrintUI2.GRA.setTipText(baseVoicePrintUI2.GRf);
                baseVoicePrintUI2.GRH.stopTimer();
                baseVoicePrintUI2.GRH.startTimer(500);
                baseVoicePrintUI2.GRy.setVisibility(0);
                VoicePrintVolumeMeter voicePrintVolumeMeter = baseVoicePrintUI2.GRz;
                voicePrintVolumeMeter.reset();
                voicePrintVolumeMeter.gNC = true;
                voicePrintVolumeMeter.GSg.startTimer((long) VoicePrintVolumeMeter.yKE);
                voicePrintVolumeMeter.fES();
                AppMethodBeat.o(29816);
                return true;
            }
            AppMethodBeat.o(29816);
            return false;
        }
    });
    String GRf = null;
    Button GRx;
    View GRy;
    VoicePrintVolumeMeter GRz;
    private boolean yJE = false;
    private final MTimerHandler yJN = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            int i2;
            AppMethodBeat.i(29813);
            if (BaseVoicePrintUI.this.GRB == null) {
                AppMethodBeat.o(29813);
            } else {
                p pVar = BaseVoicePrintUI.this.GRB;
                if (pVar.doF != null) {
                    int maxAmplitude = pVar.doF.getMaxAmplitude();
                    if (maxAmplitude > p.dAR) {
                        p.dAR = maxAmplitude;
                    }
                    Log.d("MicroMsg.VoicePrintRecoder", " map: " + maxAmplitude + " max:" + p.dAR + " per:" + ((maxAmplitude * 100) / p.dAR));
                    i2 = (maxAmplitude * 100) / p.dAR;
                } else {
                    i2 = 0;
                }
                BaseVoicePrintUI.a(BaseVoicePrintUI.this, (float) i2);
                AppMethodBeat.o(29813);
            }
            return true;
        }
    }, true);

    /* access modifiers changed from: protected */
    public abstract void edG();

    /* access modifiers changed from: protected */
    public abstract void fEK();

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void i(BaseVoicePrintUI baseVoicePrintUI) {
        baseVoicePrintUI.GRE.setVisibility(0);
        if (baseVoicePrintUI.GRF) {
            baseVoicePrintUI.GRE.setVisibility(0);
            return;
        }
        baseVoicePrintUI.GRF = true;
        View view = baseVoicePrintUI.GRE;
        Button button = baseVoicePrintUI.GRx;
        AnonymousClass8 r2 = new a.AbstractC1886a() {
            /* class com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
            public final void fEL() {
            }

            @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
            public final void fEM() {
                AppMethodBeat.i(29819);
                BaseVoicePrintUI.this.GRE.setVisibility(0);
                BaseVoicePrintUI.this.GRF = false;
                AppMethodBeat.o(29819);
            }
        };
        view.clearAnimation();
        int[] iArr = new int[2];
        button.getLocationOnScreen(iArr);
        Log.d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, anchorLocation:%s", Arrays.toString(iArr));
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i2 = iArr[1] - iArr2[1];
        Log.d("MicroMsg.VoiceViewAnimationHelper", "showFromAnchorView, yStartDelta:%d", Integer.valueOf(i2));
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) i2, 0.0f);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setInterpolator(new AccelerateInterpolator());
        animationSet.setDuration(300);
        animationSet.setFillAfter(true);
        animationSet.setRepeatCount(0);
        animationSet.setAnimationListener(new Animation.AnimationListener(r2) {
            /* class com.tencent.mm.plugin.voiceprint.ui.a.AnonymousClass7 */
            final /* synthetic */ AbstractC1886a GSE;

            {
                this.GSE = r1;
            }

            public final void onAnimationStart(Animation animation) {
                AppMethodBeat.i(29943);
                if (this.GSE != null) {
                    this.GSE.fEL();
                }
                AppMethodBeat.o(29943);
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(29944);
                if (this.GSE != null) {
                    this.GSE.fEM();
                }
                AppMethodBeat.o(29944);
            }

            public final void onAnimationRepeat(Animation animation) {
            }
        });
        view.startAnimation(animationSet);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hideTitleView();
        this.GRA = (VoiceTipInfoView) findViewById(R.id.ioj);
        this.GRx = (Button) findViewById(R.id.gvb);
        this.GRy = findViewById(R.id.jcq);
        this.GRz = (VoicePrintVolumeMeter) findViewById(R.id.jcr);
        this.GRE = findViewById(R.id.ahf);
        this.GRA.fEY();
        this.GRz.setArchView(this.GRx);
        this.GRB = new p();
        this.GRB.GRs = this.GRG;
        this.GRx.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.AnonymousClass10 */
            private boolean GRL = false;
            private long yKl = 0;

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(29821);
                switch (motionEvent.getAction()) {
                    case 0:
                        BaseVoicePrintUI.this.yJE = false;
                        if (!Util.isNullOrNil(BaseVoicePrintUI.this.GRf)) {
                            this.yKl = System.currentTimeMillis();
                            BaseVoicePrintUI.this.GRx.setPressed(true);
                            BaseVoicePrintUI.this.GRD = true;
                            BaseVoicePrintUI.this.fEI();
                            BaseVoicePrintUI.this.GRI.sendEmptyMessageDelayed(1, 300);
                            Log.i("MicroMsg.BaseVoicePrintUI", "mic press down");
                            break;
                        }
                        break;
                    case 1:
                    case 3:
                        BaseVoicePrintUI.this.GRx.setPressed(false);
                        BaseVoicePrintUI.this.GRI.removeMessages(1);
                        if (System.currentTimeMillis() - this.yKl < 300) {
                            Log.d("MicroMsg.BaseVoicePrintUI", "just little touch the button, set touchDown to false");
                            BaseVoicePrintUI.this.yJE = false;
                        } else {
                            BaseVoicePrintUI.this.yJE = true;
                        }
                        Log.i("MicroMsg.BaseVoicePrintUI", "mic press up %d, hasTouchDown:%b", Integer.valueOf(motionEvent.getAction()), Boolean.valueOf(BaseVoicePrintUI.this.yJE));
                        BaseVoicePrintUI.this.GRz.stop();
                        BaseVoicePrintUI.this.yJN.stopTimer();
                        BaseVoicePrintUI.this.GRB.Qt();
                        if (BaseVoicePrintUI.this.yJE) {
                            BaseVoicePrintUI baseVoicePrintUI = BaseVoicePrintUI.this;
                            Log.d("MicroMsg.BaseVoicePrintUI", "releaseMic");
                            if (!baseVoicePrintUI.GRB.GRq) {
                                baseVoicePrintUI.GRH.stopTimer();
                                baseVoicePrintUI.GRA.setErr(R.string.hzf);
                                baseVoicePrintUI.GRA.fEX();
                                baseVoicePrintUI.GRC = null;
                            }
                            baseVoicePrintUI.GRy.setVisibility(8);
                            baseVoicePrintUI.GRA.fEV();
                            baseVoicePrintUI.GRA.setTipText(baseVoicePrintUI.GRf);
                            Log.d("MicroMsg.BaseVoicePrintUI", "localMsgFileName %s", BaseVoicePrintUI.this.GRC);
                            if (!Util.isNullOrNil(BaseVoicePrintUI.this.GRC)) {
                                BaseVoicePrintUI.this.fEK();
                            }
                            this.yKl = 0;
                            this.GRL = false;
                            BaseVoicePrintUI.this.yJE = false;
                            break;
                        } else {
                            BaseVoicePrintUI.this.GRA.setErr(R.string.hzf);
                            BaseVoicePrintUI.this.GRA.fEX();
                            break;
                        }
                }
                AppMethodBeat.o(29821);
                return false;
            }
        });
        findViewById(R.id.ea8).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(29812);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voiceprint/ui/BaseVoicePrintUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                BaseVoicePrintUI.this.finish();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voiceprint/ui/BaseVoicePrintUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29812);
            }
        });
        edG();
    }

    /* access modifiers changed from: protected */
    public final void fEH() {
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(29818);
                if (!BaseVoicePrintUI.this.GRD) {
                    BaseVoicePrintUI.i(BaseVoicePrintUI.this);
                }
                AppMethodBeat.o(29818);
            }
        }, 1300);
    }

    /* access modifiers changed from: protected */
    public final void fEI() {
        if (this.GRE.getVisibility() != 4 && this.GRE.getVisibility() != 8) {
            if (this.GRF) {
                this.GRE.setVisibility(4);
                return;
            }
            this.GRF = true;
            a.a(this.GRE, this, new a.AbstractC1886a() {
                /* class com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.AnonymousClass9 */

                @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
                public final void fEL() {
                }

                @Override // com.tencent.mm.plugin.voiceprint.ui.a.AbstractC1886a
                public final void fEM() {
                    AppMethodBeat.i(29820);
                    BaseVoicePrintUI.this.GRE.setVisibility(4);
                    BaseVoicePrintUI.this.GRF = false;
                    AppMethodBeat.o(29820);
                }
            });
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.cd_;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        this.GRz.GSg.stopTimer();
        Log.d("MicroMsg.VoicePrintVolumeMeter", "destroy, quit factor thread");
        Log.d("MicroMsg.VoicePrintLogic", "delete voiceprint voice file");
        o oVar = new o(m.cz("voice_pt_voice_print_record.rec", false));
        if (oVar.exists()) {
            oVar.delete();
        }
        o oVar2 = new o(m.cz("voice_pt_voice_print_noise_detect.rec", false));
        if (oVar2.exists()) {
            oVar2.delete();
        }
    }

    /* access modifiers changed from: protected */
    public final void fEJ() {
        acL(R.string.hzg);
    }

    /* access modifiers changed from: protected */
    public final void acL(int i2) {
        this.GRA.ekF();
        this.GRA.setErr(i2);
        this.GRA.fEX();
    }

    static /* synthetic */ void b(BaseVoicePrintUI baseVoicePrintUI) {
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.voiceprint.ui.BaseVoicePrintUI.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(29817);
                BaseVoicePrintUI.this.GRA.setErr(R.string.hzu);
                BaseVoicePrintUI.this.GRA.fEX();
                BaseVoicePrintUI.this.GRx.setPressed(false);
                BaseVoicePrintUI.this.GRx.setEnabled(false);
                BaseVoicePrintUI.this.GRz.stop();
                AppMethodBeat.o(29817);
            }
        });
    }

    static /* synthetic */ void a(BaseVoicePrintUI baseVoicePrintUI, float f2) {
        float f3 = 10.0f;
        if (f2 >= 10.0f) {
            f3 = f2;
        }
        if (f3 > 100.0f) {
            f3 = 100.0f;
        }
        baseVoicePrintUI.GRz.setVolume(f3 / 100.0f);
    }
}
