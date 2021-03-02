package com.tencent.mm.plugin.game.media.background;

import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.tools.e;
import com.tencent.mm.vfs.s;

@a(3)
public class GameFakeVideoUI extends MMActivity implements j.a {
    int duration = 0;
    TextView hPF;
    e qaE;
    ImageView qaz;
    private j qbJ;
    private MTimerHandler qbP = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.game.media.background.GameFakeVideoUI.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(41195);
            if (GameFakeVideoUI.this.qbJ.isPlaying()) {
                GameFakeVideoUI gameFakeVideoUI = GameFakeVideoUI.this;
                int currentPosition = ((int) (((long) GameFakeVideoUI.this.qbJ.getCurrentPosition()) - GameFakeVideoUI.this.xCP)) / 1000;
                if (gameFakeVideoUI.hPF != null && gameFakeVideoUI.duration > 0) {
                    int i2 = gameFakeVideoUI.duration - currentPosition;
                    if (i2 < 0) {
                        i2 = 0;
                    }
                    gameFakeVideoUI.hPF.setText(i2 + "\"");
                }
            }
            AppMethodBeat.o(41195);
            return true;
        }
    }, true);
    private RelativeLayout qbo;
    private String videoPath;
    RelativeLayout xCN;
    private FakeVideoViewLayer xCO;
    private long xCP;
    private long xCQ;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameFakeVideoUI() {
        AppMethodBeat.i(41198);
        AppMethodBeat.o(41198);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41199);
        super.onCreate(bundle);
        hideTitleView();
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(1024, 1024);
        }
        if (com.tencent.mm.booter.a.akp() != null) {
            com.tencent.mm.booter.a.akp().akr();
        }
        this.xCN = (RelativeLayout) findViewById(R.id.j6x);
        this.qaz = (ImageView) findViewById(R.id.dcj);
        this.qbo = (RelativeLayout) findViewById(R.id.j6e);
        this.hPF = (TextView) findViewById(R.id.j4l);
        this.qbJ = new GameFakeVideoView(this);
        this.qbJ.setVideoCallback(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.qbo.addView((View) this.qbJ, layoutParams);
        String stringExtra = getIntent().getStringExtra("game_bg_mix_fake_local_id");
        if (stringExtra == null || !stringExtra.startsWith("weixin://bgmixid/")) {
            setResult(101);
            finish();
            AppMethodBeat.o(41199);
            return;
        }
        String replace = stringExtra.replace("weixin://bgmixid/", "");
        Log.i("MicroMsg.Haowan.GameFakeVideoUI", "bgMixTaskId:%s", replace);
        com.tencent.mm.plugin.recordvideo.background.e eVar = com.tencent.mm.plugin.recordvideo.background.e.BKp;
        c aLf = com.tencent.mm.plugin.recordvideo.background.e.aLf(replace);
        if (aLf == null || aLf.eIK() == null) {
            setResult(102);
            finish();
            AppMethodBeat.o(41199);
            return;
        }
        this.videoPath = aLf.eIK().BOz;
        Log.i("MicroMsg.Haowan.GameFakeVideoUI", "videoPath:%s", this.videoPath);
        aio eII = aLf.eII();
        this.xCP = eII.startTime;
        this.xCQ = eII.endTime;
        com.tencent.mm.plugin.recordvideo.background.a aVar = com.tencent.mm.plugin.recordvideo.background.a.BKb;
        this.xCO = com.tencent.mm.plugin.recordvideo.background.a.gN(this);
        this.qbo.addView(this.xCO, new ViewGroup.LayoutParams(-1, -1));
        this.xCO.setFakeVideoInfo(aLf);
        this.qbJ.setMute(this.xCO.BYt);
        this.qbo.setOnTouchListener(new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.game.media.background.GameFakeVideoUI.AnonymousClass1 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(41194);
                GameFakeVideoUI gameFakeVideoUI = GameFakeVideoUI.this;
                gameFakeVideoUI.qaE.a(gameFakeVideoUI.xCN, gameFakeVideoUI.qaz, new e.c() {
                    /* class com.tencent.mm.plugin.game.media.background.GameFakeVideoUI.AnonymousClass3 */

                    @Override // com.tencent.mm.ui.tools.e.c
                    public final void onAnimationStart() {
                    }

                    @Override // com.tencent.mm.ui.tools.e.c
                    public final void onAnimationEnd() {
                        AppMethodBeat.i(41197);
                        new MMHandler().post(new Runnable() {
                            /* class com.tencent.mm.plugin.game.media.background.GameFakeVideoUI.AnonymousClass3.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(41196);
                                GameFakeVideoUI.this.finish();
                                GameFakeVideoUI.this.overridePendingTransition(0, 0);
                                AppMethodBeat.o(41196);
                            }
                        });
                        AppMethodBeat.o(41197);
                    }
                }, null);
                AppMethodBeat.o(41194);
                return true;
            }
        });
        this.qaE = new e(this);
        AppMethodBeat.o(41199);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(41200);
        if (!Util.isNullOrNil(this.videoPath)) {
            String str = this.videoPath;
            if (Util.isNullOrNil(str)) {
                Log.e("MicroMsg.Haowan.GameFakeVideoUI", "the videoPath is null, fail~!!!");
                setResult(0);
                finish();
            } else if (!s.YS(str)) {
                Log.e("MicroMsg.Haowan.GameFakeVideoUI", "the videoPath is %s, the file isn't exist~!!!", str);
                setResult(0);
                finish();
            } else {
                this.qbJ.setVideoPath(str);
                this.xCO.tv(false);
            }
        }
        super.onResume();
        setKeepScreenOn(true);
        f.e(true, true, true);
        AppMethodBeat.o(41200);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(41201);
        this.qbJ.pause();
        this.xCO.eLA();
        super.onPause();
        setKeepScreenOn(false);
        f.e(false, true, true);
        AppMethodBeat.o(41201);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(41202);
        this.qbJ.stop();
        this.xCO.eLB();
        this.qbP.stopTimer();
        super.onDestroy();
        AppMethodBeat.o(41202);
    }

    private void setKeepScreenOn(boolean z) {
        AppMethodBeat.i(41203);
        if (this.qbJ instanceof GameFakeVideoView) {
            ((GameFakeVideoView) this.qbJ).setKeepScreenOn(z);
        }
        AppMethodBeat.o(41203);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void onError(int i2, int i3) {
        AppMethodBeat.i(41204);
        setResult(0);
        this.qbJ.stop();
        Log.e("MicroMsg.Haowan.GameFakeVideoUI", "play video error what %d extra %d.", Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(41204);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void tf() {
        AppMethodBeat.i(41205);
        setResult(-1);
        this.qbJ.start();
        this.duration = ((int) (this.xCQ - this.xCP)) / 1000;
        this.qbP.startTimer(500);
        this.qbJ.q((double) this.xCP);
        Log.i("MicroMsg.Haowan.GameFakeVideoUI", "onPrepared videoView.start duration:%d", Integer.valueOf(this.duration));
        AppMethodBeat.o(41205);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void onCompletion() {
        AppMethodBeat.i(41206);
        Log.i("MicroMsg.Haowan.GameFakeVideoUI", "on completion, startTime:%d", Long.valueOf(this.xCP));
        this.qbJ.q((double) this.xCP);
        AppMethodBeat.o(41206);
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final int fh(int i2, int i3) {
        AppMethodBeat.i(41207);
        if (this.qbJ.isPlaying() && ((long) this.qbJ.getCurrentPosition()) >= this.xCQ && this.xCQ < ((long) this.qbJ.getDuration())) {
            Log.i("MicroMsg.Haowan.GameFakeVideoUI", "currentPosition:%d reach endTime:%d, seekTo startTime:%d", Integer.valueOf(this.qbJ.getCurrentPosition()), Long.valueOf(this.xCQ), Long.valueOf(this.xCP));
            this.qbJ.d((double) this.xCP, true);
        }
        AppMethodBeat.o(41207);
        return 0;
    }

    @Override // com.tencent.mm.pluginsdk.ui.tools.j.a
    public final void eo(int i2, int i3) {
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.aq5;
    }
}
