package com.tencent.mm.plugin.fav.ui;

import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.audio.b.j;
import com.tencent.mm.compatible.b.c;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.vfs.o;

public class FavPostVoiceUI extends MMBaseActivity {
    private static final int[] jxw = {R.drawable.b_l, R.drawable.b_m, R.drawable.b_n, R.drawable.b_o, R.drawable.b_p, R.drawable.b_q, R.drawable.b_r};
    private static final int[] tfe = {0, 15, 30, 45, 60, 75, 90, 100};
    private View cBH;
    private long duration;
    boolean isFinishing = false;
    private final MTimerHandler jxC = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            int i2;
            int i3 = 0;
            AppMethodBeat.i(106789);
            j jVar = FavPostVoiceUI.this.qPp;
            if (jVar.status == 1) {
                int maxAmplitude = jVar.dAP.getMaxAmplitude();
                if (maxAmplitude > j.dAR) {
                    j.dAR = maxAmplitude;
                }
                i2 = (maxAmplitude * 100) / j.dAR;
            } else {
                i2 = 0;
            }
            while (true) {
                if (i3 < FavPostVoiceUI.jxw.length) {
                    if (i2 >= FavPostVoiceUI.tfe[i3] && i2 < FavPostVoiceUI.tfe[i3 + 1]) {
                        FavPostVoiceUI.this.tfa.setBackgroundResource(FavPostVoiceUI.jxw[i3]);
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            AppMethodBeat.o(106789);
            return true;
        }
    }, true);
    private int mEY;
    private String path;
    private boolean qPk;
    private long qPl;
    private boolean qPm;
    private long qPn = -1;
    private Toast qPo;
    private j qPp;
    private final MMHandler qPx = new MMHandler() {
        /* class com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.AnonymousClass6 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(106794);
            super.handleMessage(message);
            FavPostVoiceUI.this.cVX();
            FavPostVoiceUI.this.teX.setBackgroundResource(R.drawable.aqs);
            FavPostVoiceUI.this.teX.setEnabled(true);
            AppMethodBeat.o(106794);
        }
    };
    private final MTimerHandler qPy = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.AnonymousClass7 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(106795);
            if (FavPostVoiceUI.this.qPn == -1) {
                FavPostVoiceUI.this.qPn = Util.currentTicks();
            }
            long ticksToNow = Util.ticksToNow(FavPostVoiceUI.this.qPn);
            if (ticksToNow >= 3590000 && ticksToNow <= Util.MILLSECONDS_OF_HOUR) {
                if (FavPostVoiceUI.this.qPo == null) {
                    FavPostVoiceUI.this.qPo = Toast.makeText(FavPostVoiceUI.this, FavPostVoiceUI.this.getString(R.string.c8w, new Object[]{Integer.valueOf((int) ((Util.MILLSECONDS_OF_HOUR - ticksToNow) / 1000))}), 0);
                } else {
                    FavPostVoiceUI.this.qPo.setText(FavPostVoiceUI.this.getString(R.string.c8w, new Object[]{Integer.valueOf((int) ((Util.MILLSECONDS_OF_HOUR - ticksToNow) / 1000))}));
                }
                FavPostVoiceUI.this.qPo.show();
            }
            if (ticksToNow >= Util.MILLSECONDS_OF_HOUR) {
                Log.v("MicroMsg.FavPostVoiceUI", "record stop on countdown");
                FavPostVoiceUI.this.qPm = true;
                FavPostVoiceUI.p(FavPostVoiceUI.this);
                AppMethodBeat.o(106795);
                return false;
            }
            AppMethodBeat.o(106795);
            return true;
        }
    }, true);
    private Button teX;
    private View teY;
    private View teZ;
    private ImageView tfa;
    private View tfb;
    private View tfc;
    private TextView tfd;

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FavPostVoiceUI() {
        AppMethodBeat.i(106798);
        AppMethodBeat.o(106798);
    }

    static /* synthetic */ void c(FavPostVoiceUI favPostVoiceUI) {
        AppMethodBeat.i(106809);
        favPostVoiceUI.cVY();
        AppMethodBeat.o(106809);
    }

    static /* synthetic */ void p(FavPostVoiceUI favPostVoiceUI) {
        AppMethodBeat.i(106812);
        favPostVoiceUI.cDc();
        AppMethodBeat.o(106812);
    }

    @Override // com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(106799);
        super.onCreate(bundle);
        setContentView(aa.jQ(this).inflate(R.layout.a7w, (ViewGroup) null));
        this.tfa = (ImageView) findViewById(R.id.j_n);
        this.tfb = findViewById(R.id.j_o);
        this.tfc = findViewById(R.id.j_q);
        this.teY = findViewById(R.id.j_u);
        this.teZ = findViewById(R.id.j_v);
        this.tfd = (TextView) findViewById(R.id.j_w);
        this.cBH = findViewById(R.id.j_p);
        findViewById(R.id.j_m).setVisibility(8);
        this.cBH.setVisibility(8);
        findViewById(R.id.j_m).setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.AnonymousClass2 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(106790);
                FavPostVoiceUI.c(FavPostVoiceUI.this);
                AppMethodBeat.o(106790);
                return false;
            }
        });
        findViewById(R.id.ccq).setVisibility(8);
        this.qPp = cVW();
        this.teX = (Button) findViewById(R.id.ccp);
        this.teX.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.AnonymousClass5 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(106793);
                if (view == FavPostVoiceUI.this.teX) {
                    int rawY = (int) motionEvent.getRawY();
                    int[] iArr = new int[2];
                    FavPostVoiceUI.this.mEY = FavPostVoiceUI.this.getResources().getDisplayMetrics().heightPixels;
                    FavPostVoiceUI.this.teX.getLocationOnScreen(iArr);
                    int i2 = iArr[1];
                    switch (motionEvent.getAction()) {
                        case 0:
                            if (!FavPostVoiceUI.this.qPk) {
                                FavPostVoiceUI.this.qPk = true;
                                FavPostVoiceUI.j(FavPostVoiceUI.this);
                            }
                            AppMethodBeat.o(106793);
                            break;
                        case 1:
                            if (FavPostVoiceUI.this.qPk) {
                                if (FavPostVoiceUI.this.tfc.getVisibility() == 0) {
                                    Log.w("MicroMsg.FavPostVoiceUI", "action up -> cancel");
                                    FavPostVoiceUI.n(FavPostVoiceUI.this);
                                } else if (!FavPostVoiceUI.this.qPm) {
                                    FavPostVoiceUI.p(FavPostVoiceUI.this);
                                }
                                AppMethodBeat.o(106793);
                                break;
                            } else {
                                AppMethodBeat.o(106793);
                                break;
                            }
                        case 2:
                            if (rawY > FavPostVoiceUI.this.mEY - BackwardSupportUtil.BitmapFactory.fromDPToPix(FavPostVoiceUI.this, 60.0f) || rawY >= i2) {
                                FavPostVoiceUI.this.tfb.setVisibility(0);
                                FavPostVoiceUI.this.tfc.setVisibility(8);
                            } else {
                                FavPostVoiceUI.this.tfb.setVisibility(8);
                                FavPostVoiceUI.this.tfc.setVisibility(0);
                            }
                            AppMethodBeat.o(106793);
                            break;
                        case 3:
                            Log.w("MicroMsg.FavPostVoiceUI", "action cancel");
                            FavPostVoiceUI.n(FavPostVoiceUI.this);
                            AppMethodBeat.o(106793);
                            break;
                        default:
                            AppMethodBeat.o(106793);
                            break;
                    }
                } else {
                    AppMethodBeat.o(106793);
                }
                return false;
            }
        });
        cVX();
        String cUn = b.cUn();
        o oVar = new o(cUn);
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        do {
            str = cUn + FilePathGenerator.ANDROID_DIR_SEP + System.currentTimeMillis();
        } while (new o(str).exists());
        this.path = str;
        this.tfd.post(new Runnable() {
            /* class com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(106791);
                FavPostVoiceUI.this.findViewById(R.id.j_m).setVisibility(0);
                FavPostVoiceUI.this.cBH.setVisibility(0);
                FavPostVoiceUI.this.findViewById(R.id.ccq).setVisibility(0);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration(300);
                TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                translateAnimation.setDuration(300);
                FavPostVoiceUI.this.cBH.startAnimation(alphaAnimation);
                FavPostVoiceUI.this.findViewById(R.id.j_m).startAnimation(alphaAnimation);
                FavPostVoiceUI.this.findViewById(R.id.ccq).startAnimation(translateAnimation);
                AppMethodBeat.o(106791);
            }
        });
        AppMethodBeat.o(106799);
    }

    private j cVW() {
        AppMethodBeat.i(106800);
        c.a aVar = c.a.AMR;
        j jVar = new j();
        jVar.dAQ = new j.a() {
            /* class com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.AnonymousClass4 */

            @Override // com.tencent.mm.audio.b.j.a
            public final void onError() {
                AppMethodBeat.i(106792);
                FavPostVoiceUI.this.jxC.stopTimer();
                FavPostVoiceUI.this.qPy.stopTimer();
                AppMethodBeat.o(106792);
            }
        };
        AppMethodBeat.o(106800);
        return jVar;
    }

    private void cDc() {
        long j2 = 0;
        AppMethodBeat.i(106801);
        if (!this.qPk) {
            AppMethodBeat.o(106801);
            return;
        }
        this.teX.setKeepScreenOn(true);
        this.teX.setBackgroundResource(R.drawable.aqr);
        this.teX.setText(R.string.caw);
        this.qPp.ZZ();
        if (this.qPl != 0) {
            j2 = Util.ticksToNow(this.qPl);
        }
        this.duration = j2;
        boolean z = this.duration < 800;
        this.jxC.stopTimer();
        this.qPy.stopTimer();
        if (!z) {
            String str = this.path;
            int i2 = (int) this.duration;
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.FavPostLogic", "postVoice path null");
            } else {
                g gVar = new g();
                gVar.field_type = 3;
                gVar.field_sourceType = 6;
                k.G(gVar);
                aml aml = new aml();
                aml.bgt(str);
                aml.ajc(i2);
                aml.At(true);
                aml.ajd(gVar.field_type);
                aml.bgp("amr");
                gVar.field_favProto.ppH.add(aml);
                b.C(gVar);
                h.INSTANCE.a(10648, 1, 0);
            }
            setResult(-1);
            finish();
            BackwardSupportUtil.AnimationHelper.overridePendingTransition(this, 0, 0);
        } else {
            cDe();
            this.teX.setEnabled(false);
            this.teX.setBackgroundResource(R.drawable.aqq);
            this.teZ.setVisibility(0);
            this.teY.setVisibility(8);
            this.qPx.sendEmptyMessageDelayed(0, 500);
        }
        this.qPk = false;
        AppMethodBeat.o(106801);
    }

    public final void cVX() {
        AppMethodBeat.i(106802);
        this.teY.setVisibility(0);
        this.teZ.setVisibility(8);
        this.tfc.setVisibility(8);
        this.tfb.setVisibility(0);
        this.tfd.setText(R.string.c8v);
        this.teX.setBackgroundResource(R.drawable.aqs);
        this.teX.setText(R.string.caw);
        this.tfa.setVisibility(4);
        this.qPk = false;
        AppMethodBeat.o(106802);
    }

    private void cDe() {
        AppMethodBeat.i(106803);
        o oVar = new o(this.path);
        if (oVar.exists()) {
            oVar.delete();
        }
        AppMethodBeat.o(106803);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onDestroy() {
        AppMethodBeat.i(106804);
        super.onDestroy();
        AppMethodBeat.o(106804);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onResume() {
        AppMethodBeat.i(106805);
        super.onResume();
        AppMethodBeat.o(106805);
    }

    @Override // com.tencent.mm.ui.MMBaseActivity, com.tencent.mm.hellhoundlib.activities.HellActivity
    public void onPause() {
        AppMethodBeat.i(106806);
        super.onPause();
        cDc();
        AppMethodBeat.o(106806);
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(106807);
        if (4 == i2) {
            cVY();
            AppMethodBeat.o(106807);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(106807);
        return onKeyDown;
    }

    private void cVY() {
        AppMethodBeat.i(106808);
        if (this.isFinishing) {
            AppMethodBeat.o(106808);
            return;
        }
        this.isFinishing = true;
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(300);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(300);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            /* class com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.AnonymousClass8 */

            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
                AppMethodBeat.i(106797);
                FavPostVoiceUI.this.tfb.post(new Runnable() {
                    /* class com.tencent.mm.plugin.fav.ui.FavPostVoiceUI.AnonymousClass8.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(106796);
                        FavPostVoiceUI.this.setResult(0);
                        FavPostVoiceUI.this.finish();
                        BackwardSupportUtil.AnimationHelper.overridePendingTransition(FavPostVoiceUI.this, 0, 0);
                        AppMethodBeat.o(106796);
                    }
                });
                AppMethodBeat.o(106797);
            }
        });
        findViewById(R.id.j_m).setVisibility(8);
        findViewById(R.id.ccq).setVisibility(8);
        this.cBH.setVisibility(8);
        this.cBH.startAnimation(alphaAnimation);
        findViewById(R.id.j_m).startAnimation(alphaAnimation);
        findViewById(R.id.ccq).startAnimation(translateAnimation);
        AppMethodBeat.o(106808);
    }

    static /* synthetic */ void j(FavPostVoiceUI favPostVoiceUI) {
        AppMethodBeat.i(106810);
        favPostVoiceUI.teX.setKeepScreenOn(true);
        favPostVoiceUI.teX.setBackgroundResource(R.drawable.aqs);
        favPostVoiceUI.teX.setText(R.string.cbr);
        favPostVoiceUI.qPm = false;
        favPostVoiceUI.qPp = favPostVoiceUI.cVW();
        if (favPostVoiceUI.qPp.hy(favPostVoiceUI.path)) {
            favPostVoiceUI.qPl = Util.currentTicks();
            favPostVoiceUI.qPy.startTimer(200);
            favPostVoiceUI.tfa.setVisibility(0);
            favPostVoiceUI.jxC.startTimer(100);
            favPostVoiceUI.tfd.setText(R.string.ca9);
            AppMethodBeat.o(106810);
            return;
        }
        favPostVoiceUI.qPl = 0;
        AppMethodBeat.o(106810);
    }

    static /* synthetic */ void n(FavPostVoiceUI favPostVoiceUI) {
        AppMethodBeat.i(106811);
        favPostVoiceUI.teX.setKeepScreenOn(false);
        favPostVoiceUI.qPp.ZZ();
        favPostVoiceUI.jxC.stopTimer();
        favPostVoiceUI.qPy.stopTimer();
        favPostVoiceUI.cDe();
        favPostVoiceUI.cVX();
        AppMethodBeat.o(106811);
    }
}
