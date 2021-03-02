package com.tencent.mm.plugin.card.ui;

import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.plugin.card.d.a;
import com.tencent.mm.plugin.card.model.CardGiftInfo;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.pluginsdk.ui.tools.VideoTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.vfs.s;

@a(3)
public class CardGiftVideoUI extends MMActivity implements a.AbstractC0901a, j.a {
    private l contextMenuHelper;
    int duration = 0;
    private boolean guh;
    private boolean isAnimated = false;
    private ProgressBar qaB;
    private MMHandler qaC = new MMHandler(Looper.getMainLooper());
    private Bundle qaD;
    private e qaE;
    private int qaF = 0;
    private int qaG = 0;
    private int qaH = 0;
    private int qaI = 0;
    private CardGiftInfo qay;
    private ImageView qaz;
    private RelativeLayout qbI;
    private j qbJ;
    private RelativeLayout qbK;
    private ImageView qbL;
    TextView qbM;
    private MMPinProgressBtn qbN;
    private TextView qbO;
    private MTimerHandler qbP = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.card.ui.CardGiftVideoUI.AnonymousClass10 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(113385);
            if (CardGiftVideoUI.this.qbJ.isPlaying()) {
                CardGiftVideoUI cardGiftVideoUI = CardGiftVideoUI.this;
                int currentPosition = CardGiftVideoUI.this.qbJ.getCurrentPosition() / 1000;
                if (cardGiftVideoUI.qbM != null && cardGiftVideoUI.duration > 0) {
                    int i2 = cardGiftVideoUI.duration - currentPosition;
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    cardGiftVideoUI.qbM.setText(i2 + "\"");
                }
            }
            AppMethodBeat.o(113385);
            return true;
        }
    }, true);
    private String videoPath;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public CardGiftVideoUI() {
        AppMethodBeat.i(113388);
        AppMethodBeat.o(113388);
    }

    static /* synthetic */ void b(CardGiftVideoUI cardGiftVideoUI, String str) {
        AppMethodBeat.i(113404);
        cardGiftVideoUI.ajI(str);
        AppMethodBeat.o(113404);
    }

    static /* synthetic */ void i(CardGiftVideoUI cardGiftVideoUI) {
        AppMethodBeat.i(113405);
        cardGiftVideoUI.cvW();
        AppMethodBeat.o(113405);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        String cardGiftInfo;
        AppMethodBeat.i(113389);
        if (getIntent().getExtras() != null) {
            getIntent().getExtras().setClassLoader(getClass().getClassLoader());
        }
        super.onCreate(bundle);
        hideTitleView();
        this.qaD = bundle;
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(1024, 1024);
        }
        if (com.tencent.mm.booter.a.akp() != null) {
            com.tencent.mm.booter.a.akp().akr();
        }
        this.qay = (CardGiftInfo) getIntent().getParcelableExtra("key_gift_into");
        this.videoPath = getIntent().getStringExtra("key_video_path");
        this.guh = getIntent().getBooleanExtra("key_is_mute", false);
        Object[] objArr = new Object[1];
        if (this.qay == null) {
            cardGiftInfo = BuildConfig.COMMAND;
        } else {
            cardGiftInfo = this.qay.toString();
        }
        objArr[0] = cardGiftInfo;
        Log.d("MicroMsg.CardGiftVideoUI", "cardGiftInfo %s", objArr);
        Log.d("MicroMsg.CardGiftVideoUI", "videoPath:%s, isMute:%b", this.videoPath, Boolean.valueOf(this.guh));
        initView();
        com.tencent.mm.plugin.card.d.a.a(this);
        cvW();
        if (this.qay == null) {
            Log.e("MicroMsg.CardGiftVideoUI", "cardGiftInfo is null");
            AppMethodBeat.o(113389);
        } else if (!Util.isNullOrNil(this.qay.pSq)) {
            com.tencent.mm.plugin.card.d.a.g(this.qay.pSr, this.qay.pSu, this.qay.pSC, 2);
            com.tencent.mm.plugin.card.d.a.g(this.qay.pSq, this.qay.pSt, this.qay.pSB, 1);
            AppMethodBeat.o(113389);
        } else {
            Log.e("MicroMsg.CardGiftVideoUI", "fromUserContentVideoUrl is null");
            AppMethodBeat.o(113389);
        }
    }

    private void ajI(String str) {
        AppMethodBeat.i(113390);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.CardGiftVideoUI", "the videoPath is null, fail~!!!");
            setResult(0);
            finish();
            AppMethodBeat.o(113390);
        } else if (!s.YS(str)) {
            Log.e("MicroMsg.CardGiftVideoUI", "the videoPath is %s, the file isn't exist~!!!", str);
            setResult(0);
            finish();
            AppMethodBeat.o(113390);
        } else {
            this.qbJ.setVideoPath(str);
            AppMethodBeat.o(113390);
        }
    }

    private void cvW() {
        AppMethodBeat.i(113391);
        if (this.contextMenuHelper == null) {
            this.contextMenuHelper = new l(getContext());
        }
        if (Util.isNullOrNil(this.videoPath)) {
            Log.e("MicroMsg.CardGiftVideoUI", "videoPath is null");
            AppMethodBeat.o(113391);
            return;
        }
        this.contextMenuHelper.a((VideoTextureView) this.qbJ, new View.OnCreateContextMenuListener() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftVideoUI.AnonymousClass1 */

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(113375);
                contextMenu.add(0, 0, 0, CardGiftVideoUI.this.getString(R.string.ar3));
                AppMethodBeat.o(113375);
            }
        }, new o.g() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftVideoUI.AnonymousClass5 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(113379);
                switch (menuItem.getItemId()) {
                    case 0:
                        p.b(CardGiftVideoUI.this.getContext(), CardGiftVideoUI.this.videoPath, new p.a() {
                            /* class com.tencent.mm.plugin.card.ui.CardGiftVideoUI.AnonymousClass5.AnonymousClass1 */

                            @Override // com.tencent.mm.platformtools.p.a
                            public final void bP(String str, String str2) {
                                AppMethodBeat.i(201319);
                                Toast.makeText(CardGiftVideoUI.this.getContext(), CardGiftVideoUI.this.getContext().getString(R.string.hwu, new Object[]{AndroidMediaUtil.getFriendlySdcardPath(str2)}), 1).show();
                                com.tencent.mm.pluginsdk.ui.tools.s.refreshMediaScanner(str2, CardGiftVideoUI.this.getContext());
                                AppMethodBeat.o(201319);
                            }

                            @Override // com.tencent.mm.platformtools.p.a
                            public final void bQ(String str, String str2) {
                                AppMethodBeat.i(201320);
                                Toast.makeText(CardGiftVideoUI.this.getContext(), CardGiftVideoUI.this.getContext().getString(R.string.hwt), 1).show();
                                AppMethodBeat.o(201320);
                            }
                        });
                        break;
                }
                AppMethodBeat.o(113379);
            }
        });
        AppMethodBeat.o(113391);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(113392);
        this.qbI = (RelativeLayout) findViewById(R.id.j6x);
        this.qbK = (RelativeLayout) findViewById(R.id.j6e);
        this.qbL = (ImageView) findViewById(R.id.j6m);
        this.qbM = (TextView) findViewById(R.id.j4l);
        this.qbN = (MMPinProgressBtn) findViewById(R.id.j62);
        this.qaB = (ProgressBar) findViewById(R.id.j59);
        this.qbO = (TextView) findViewById(R.id.j6r);
        this.qbJ = new VideoTextureView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.qbJ.setMute(this.guh);
        this.qbJ.setVideoCallback(this);
        this.qbK.addView((View) this.qbJ, layoutParams);
        this.qaz = (ImageView) findViewById(R.id.dcj);
        this.qbI.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftVideoUI.AnonymousClass6 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(113380);
                CardGiftVideoUI.this.cvQ();
                AppMethodBeat.o(113380);
                return true;
            }
        });
        ((View) this.qbJ).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftVideoUI.AnonymousClass7 */

            public final void onClick(View view) {
                AppMethodBeat.i(113381);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/CardGiftVideoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                CardGiftVideoUI.this.cvQ();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/CardGiftVideoUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(113381);
            }
        });
        this.qaE = new e(this);
        AppMethodBeat.o(113392);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onStart() {
        AppMethodBeat.i(113393);
        Bundle bundle = this.qaD;
        if (!this.isAnimated) {
            this.isAnimated = true;
            if (Build.VERSION.SDK_INT < 12) {
                Log.e("MicroMsg.CardGiftVideoUI", "version is %d, no animation", Integer.valueOf(Build.VERSION.SDK_INT));
            } else {
                this.qaF = getIntent().getIntExtra("img_top", 0);
                this.qaG = getIntent().getIntExtra("img_left", 0);
                this.qaH = getIntent().getIntExtra("img_width", 0);
                this.qaI = getIntent().getIntExtra("img_height", 0);
                this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
                if (bundle == null) {
                    this.qbI.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                        /* class com.tencent.mm.plugin.card.ui.CardGiftVideoUI.AnonymousClass8 */

                        public final boolean onPreDraw() {
                            AppMethodBeat.i(113382);
                            CardGiftVideoUI.this.qbI.getViewTreeObserver().removeOnPreDrawListener(this);
                            CardGiftVideoUI.this.qaE.a(CardGiftVideoUI.this.qbI, CardGiftVideoUI.this.qaz, null);
                            AppMethodBeat.o(113382);
                            return true;
                        }
                    });
                }
            }
        }
        super.onStart();
        AppMethodBeat.o(113393);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(113394);
        if (!Util.isNullOrNil(this.videoPath)) {
            ajI(this.videoPath);
        }
        super.onResume();
        AppMethodBeat.o(113394);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(113395);
        this.qbJ.pause();
        super.onPause();
        AppMethodBeat.o(113395);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(113396);
        this.qbJ.stop();
        this.qbP.stopTimer();
        com.tencent.mm.plugin.card.d.a.b(this);
        super.onDestroy();
        AppMethodBeat.o(113396);
    }

    @Override // android.support.v4.app.SupportActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(113397);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Log.d("MicroMsg.CardGiftVideoUI", "dispatchKeyEvent");
            cvQ();
            AppMethodBeat.o(113397);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(113397);
        return dispatchKeyEvent;
    }

    public final void cvQ() {
        AppMethodBeat.i(113398);
        this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
        this.qaE.a(this.qbI, this.qaz, new e.c() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftVideoUI.AnonymousClass9 */

            @Override // com.tencent.mm.ui.tools.e.c
            public final void onAnimationStart() {
            }

            @Override // com.tencent.mm.ui.tools.e.c
            public final void onAnimationEnd() {
                AppMethodBeat.i(113384);
                new MMHandler().post(new Runnable() {
                    /* class com.tencent.mm.plugin.card.ui.CardGiftVideoUI.AnonymousClass9.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(113383);
                        CardGiftVideoUI.this.finish();
                        CardGiftVideoUI.this.overridePendingTransition(0, 0);
                        AppMethodBeat.o(113383);
                    }
                });
                AppMethodBeat.o(113384);
            }
        }, null);
        AppMethodBeat.o(113398);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.n2;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void onError(int i2, int i3) {
        AppMethodBeat.i(113399);
        setResult(0);
        this.qbJ.stop();
        Log.e("MicroMsg.CardGiftVideoUI", "%d on play video error what %d extra %d.", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(113399);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void tf() {
        AppMethodBeat.i(113400);
        setResult(-1);
        this.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftVideoUI.AnonymousClass11 */
            final /* synthetic */ boolean qbT = true;

            public final void run() {
                AppMethodBeat.i(113386);
                Log.i("MicroMsg.CardGiftVideoUI", "%d switch video model isVideoPlay %b", Integer.valueOf(CardGiftVideoUI.this.hashCode()), Boolean.valueOf(this.qbT));
                if (this.qbT) {
                    ((View) CardGiftVideoUI.this.qbJ).setVisibility(0);
                    CardGiftVideoUI.this.qbL.setVisibility(8);
                    AppMethodBeat.o(113386);
                    return;
                }
                ((View) CardGiftVideoUI.this.qbJ).setVisibility(8);
                CardGiftVideoUI.this.qbL.setVisibility(0);
                AppMethodBeat.o(113386);
            }
        });
        this.qaC.post(new Runnable() {
            /* class com.tencent.mm.plugin.card.ui.CardGiftVideoUI.AnonymousClass12 */

            public final void run() {
                AppMethodBeat.i(113387);
                Log.d("MicroMsg.CardGiftVideoUI", "hide loading.");
                if (!(CardGiftVideoUI.this.qaB == null || CardGiftVideoUI.this.qaB.getVisibility() == 8)) {
                    CardGiftVideoUI.this.qaB.setVisibility(8);
                }
                if (!(CardGiftVideoUI.this.qbN == null || CardGiftVideoUI.this.qbN.getVisibility() == 8)) {
                    CardGiftVideoUI.this.qbN.setVisibility(8);
                }
                AppMethodBeat.o(113387);
            }
        });
        this.qbJ.start();
        this.duration = this.qbJ.getDuration() / 1000;
        this.qbP.startTimer(500);
        Log.i("MicroMsg.CardGiftVideoUI", "onPrepared videoView.start duration:%d", Integer.valueOf(this.duration));
        AppMethodBeat.o(113400);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void onCompletion() {
        AppMethodBeat.i(113401);
        Log.i("MicroMsg.CardGiftVideoUI", "%d on completion", Integer.valueOf(hashCode()));
        this.qbJ.q(0.0d);
        AppMethodBeat.o(113401);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final int fh(int i2, int i3) {
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void eo(int i2, int i3) {
    }

    @Override // com.tencent.mm.plugin.card.d.a.AbstractC0901a
    public final void cP(String str, final int i2) {
        AppMethodBeat.i(113402);
        if (str.equals(this.qay.pSq)) {
            this.qaC.post(new Runnable() {
                /* class com.tencent.mm.plugin.card.ui.CardGiftVideoUI.AnonymousClass2 */
                final /* synthetic */ int iZf = 100;

                public final void run() {
                    AppMethodBeat.i(113376);
                    if (CardGiftVideoUI.this.qbN != null) {
                        if (this.iZf == 0) {
                            CardGiftVideoUI.this.qbN.setVisibility(8);
                            AppMethodBeat.o(113376);
                            return;
                        }
                        if (CardGiftVideoUI.this.qbN.getVisibility() != 0) {
                            CardGiftVideoUI.this.qbN.setVisibility(0);
                        }
                        Log.i("MicroMsg.CardGiftVideoUI", "update progress %d %d", Integer.valueOf(i2), Integer.valueOf(this.iZf));
                        if (CardGiftVideoUI.this.qbN.getMax() != this.iZf && this.iZf > 0) {
                            CardGiftVideoUI.this.qbN.setMax(this.iZf);
                        }
                        CardGiftVideoUI.this.qbN.setProgress(i2);
                    }
                    AppMethodBeat.o(113376);
                }
            });
        }
        AppMethodBeat.o(113402);
    }

    @Override // com.tencent.mm.plugin.card.d.a.AbstractC0901a
    public final void ajH(String str) {
    }

    @Override // com.tencent.mm.plugin.card.d.a.AbstractC0901a
    public final void fw(String str, final String str2) {
        AppMethodBeat.i(113403);
        if (str.equals(this.qay.pSq)) {
            this.qaC.post(new Runnable() {
                /* class com.tencent.mm.plugin.card.ui.CardGiftVideoUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(113377);
                    CardGiftVideoUI.this.qbL.setVisibility(8);
                    CardGiftVideoUI.this.videoPath = str2;
                    CardGiftVideoUI.b(CardGiftVideoUI.this, CardGiftVideoUI.this.videoPath);
                    CardGiftVideoUI.i(CardGiftVideoUI.this);
                    AppMethodBeat.o(113377);
                }
            });
            AppMethodBeat.o(113403);
        } else if (str.equals(this.qay.pSr)) {
            this.qaC.post(new Runnable() {
                /* class com.tencent.mm.plugin.card.ui.CardGiftVideoUI.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(113378);
                    if (Util.isNullOrNil(CardGiftVideoUI.this.videoPath)) {
                        CardGiftVideoUI.this.qbL.setVisibility(0);
                        c.a aVar = new c.a();
                        aVar.prefixPath = com.tencent.mm.loader.j.b.aKJ();
                        q.bcW();
                        aVar.jbw = null;
                        aVar.fullPath = m.ajp(str2);
                        aVar.jbi = 1;
                        aVar.jbf = true;
                        aVar.jbd = true;
                        q.bcV().a(str2, CardGiftVideoUI.this.qbL, aVar.bdv());
                    }
                    AppMethodBeat.o(113378);
                }
            });
            AppMethodBeat.o(113403);
        } else {
            Log.i("MicroMsg.CardGiftVideoUI", "fieldId:%s is unsuitable", str);
            AppMethodBeat.o(113403);
        }
    }
}
