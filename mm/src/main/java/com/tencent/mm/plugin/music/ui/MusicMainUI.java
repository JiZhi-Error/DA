package com.tencent.mm.plugin.music.ui;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ay.f;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.plugin.appbrand.widget.music.MusicSeekBar;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.model.m;
import com.tencent.mm.plugin.music.model.o;
import com.tencent.mm.plugin.music.ui.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.l.d;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.tavkit.component.TAVExporter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Timer;
import junit.framework.Assert;

@com.tencent.mm.ui.base.a(32)
public class MusicMainUI extends MMActivity implements ViewPager.OnPageChangeListener, i {
    private d.a AhI = new d.a() {
        /* class com.tencent.mm.plugin.music.ui.MusicMainUI.AnonymousClass11 */

        @Override // com.tencent.mm.plugin.music.f.a.d.a
        public final void fn(int i2, int i3) {
            AppMethodBeat.i(63244);
            if (MusicMainUI.this.AnG == null) {
                if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                    Assert.assertTrue("pager is null, err", false);
                }
                Log.w("MicroMsg.Music.MusicMainUI", "pager is null, return");
                AppMethodBeat.o(63244);
                return;
            }
            if (MusicMainUI.this.mode == 1 && !MusicMainUI.this.AnL) {
                float floatExtra = MusicMainUI.this.getIntent().getFloatExtra("key_offset", 0.0f);
                float f2 = floatExtra * 1000.0f;
                long currentTimeMillis = (long) (f2 + ((float) (System.currentTimeMillis() - MusicMainUI.this.getIntent().getLongExtra("music_player_beg_time", 0))));
                if (currentTimeMillis >= 0) {
                    MusicMainUI.this.AnG.av(MusicMainUI.this.AnF.getCurrentItem(), currentTimeMillis + 200);
                }
            } else if (i2 >= 0 && i3 > 0) {
                MusicMainUI.this.AnG.av(MusicMainUI.this.AnF.getCurrentItem(), (long) i2);
            }
            Message message = new Message();
            message.what = 1;
            MusicMainUI.this.AnV.sendMessage(message);
            AppMethodBeat.o(63244);
        }
    };
    private boolean AkV;
    private CheckBox AnB;
    private ImageButton AnC;
    private ImageButton AnD;
    private MusicSeekBar AnE;
    private MusicViewPager AnF;
    private b AnG;
    private LinearLayout AnH;
    private TextView AnI;
    private ImageView AnJ;
    private ImageView AnK;
    private boolean AnL;
    private long AnM = 0;
    private long AnN = 0;
    private String AnO;
    private boolean AnP = false;
    private String AnQ = "";
    private String AnR = "";
    private boolean AnS = false;
    private int AnT = 0;
    private Timer AnU;
    private MMHandler AnV = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.plugin.music.ui.MusicMainUI.AnonymousClass2 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            AppMethodBeat.i(63229);
            if (message.what == 1) {
                MusicMainUI.q(MusicMainUI.this);
            }
            AppMethodBeat.o(63229);
        }
    };
    private MMHandler goC = new MMHandler(Looper.getMainLooper());
    private IListener lEl = new IListener<mx>() {
        /* class com.tencent.mm.plugin.music.ui.MusicMainUI.AnonymousClass6 */

        {
            AppMethodBeat.i(160409);
            this.__eventId = mx.class.getName().hashCode();
            AppMethodBeat.o(160409);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mx mxVar) {
            AppMethodBeat.i(63239);
            final mx mxVar2 = mxVar;
            switch (mxVar2.dSE.action) {
                case 0:
                case 1:
                    MusicMainUI.this.AnB.setChecked(false);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.music.ui.MusicMainUI.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(63233);
                            if (mxVar2.dSE.action == 0 && ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).getMode() != 2) {
                                MusicMainUI.this.AnF.setAdapter(MusicMainUI.this.AnG);
                                MusicMainUI.this.AnF.setCurrentItem(((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).eue() + 100000);
                            }
                            MusicMainUI.l(MusicMainUI.this);
                            AppMethodBeat.o(63233);
                        }
                    });
                    break;
                case 2:
                case 3:
                case 4:
                    MusicMainUI.this.AnB.setChecked(true);
                    break;
                case 5:
                    PlaySound.play(MusicMainUI.this.getContext(), R.string.gyz);
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.music.ui.MusicMainUI.AnonymousClass6.AnonymousClass3 */

                        public final void run() {
                            AppMethodBeat.i(63235);
                            m.aw(MusicMainUI.this);
                            MusicMainUI.l(MusicMainUI.this);
                            AppMethodBeat.o(63235);
                        }
                    });
                    break;
                case 6:
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.music.ui.MusicMainUI.AnonymousClass6.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(63236);
                            b bVar = MusicMainUI.this.AnG;
                            String str = mxVar2.dSE.dSF;
                            boolean z = false;
                            for (Map.Entry<Integer, View> entry : bVar.Anj.entrySet()) {
                                b.a aVar = (b.a) entry.getValue().getTag();
                                if (aVar.AkC.field_musicId.equals(str)) {
                                    aVar.b(o.euD().aHW(str), true);
                                    z = true;
                                } else {
                                    z = z;
                                }
                            }
                            if (!z) {
                                Log.i("MicroMsg.Music.MusicMainAdapter", "holder song id is not exist, do refresh all");
                                bVar.notifyDataSetChanged();
                            }
                            AppMethodBeat.o(63236);
                        }
                    });
                    break;
                case 7:
                    if (((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).getMode() != 2) {
                        MusicMainUI.this.AnB.setChecked(true);
                        break;
                    } else {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.music.ui.MusicMainUI.AnonymousClass6.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(63234);
                                MusicMainUI.this.AnF.setCurrentItem(MusicMainUI.this.AnF.getCurrentItem() + 1);
                                AppMethodBeat.o(63234);
                            }
                        });
                        break;
                    }
                case 8:
                    MusicMainUI.this.AnE.jl(false);
                    break;
                case 13:
                    if (((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).getMode() == 2) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.music.ui.MusicMainUI.AnonymousClass6.AnonymousClass5 */

                            public final void run() {
                                AppMethodBeat.i(63237);
                                MusicMainUI.this.AnF.setCurrentItem(MusicMainUI.this.AnF.getCurrentItem() - 1);
                                AppMethodBeat.o(63237);
                            }
                        });
                        break;
                    }
                    break;
                case 14:
                    if (((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).getMode() == 2) {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.music.ui.MusicMainUI.AnonymousClass6.AnonymousClass6 */

                            public final void run() {
                                AppMethodBeat.i(63238);
                                MusicMainUI.this.AnF.setCurrentItem(MusicMainUI.this.AnF.getCurrentItem() + 1);
                                AppMethodBeat.o(63238);
                            }
                        });
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(63239);
            return false;
        }
    };
    private long lastShakeTime;
    private int mode;
    private int scene;
    private com.tencent.mm.pluginsdk.l.d shakeSensor;
    private int wAr = -1;

    public MusicMainUI() {
        AppMethodBeat.i(63247);
        AppMethodBeat.o(63247);
    }

    static /* synthetic */ void a(MusicMainUI musicMainUI) {
        AppMethodBeat.i(63261);
        musicMainUI.evm();
        AppMethodBeat.o(63261);
    }

    static /* synthetic */ void a(MusicMainUI musicMainUI, com.tencent.mm.plugin.music.model.e.a aVar) {
        AppMethodBeat.i(63264);
        musicMainUI.k(aVar);
        AppMethodBeat.o(63264);
    }

    static /* synthetic */ int g(MusicMainUI musicMainUI) {
        int i2 = musicMainUI.AnT;
        musicMainUI.AnT = i2 + 1;
        return i2;
    }

    static /* synthetic */ void l(MusicMainUI musicMainUI) {
        AppMethodBeat.i(63263);
        musicMainUI.evl();
        AppMethodBeat.o(63263);
    }

    static /* synthetic */ void q(MusicMainUI musicMainUI) {
        AppMethodBeat.i(63265);
        musicMainUI.cBY();
        AppMethodBeat.o(63265);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        AppMethodBeat.i(219881);
        AppMethodBeat.at(this, z);
        super.onWindowFocusChanged(z);
        if (z) {
            getWindow().getDecorView().setSystemUiVisibility(TAVExporter.VIDEO_EXPORT_HEIGHT);
            setActionbarColor(getContext().getResources().getColor(R.color.ac_));
            hideActionbarLine();
            if (!this.AnS) {
                if (this.AnC != null) {
                    eB(this.AnC);
                }
                if (this.AnD != null) {
                    eB(this.AnD);
                }
                this.AnS = true;
            }
        }
        AppMethodBeat.o(219881);
    }

    private void eB(View view) {
        AppMethodBeat.i(219882);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        layoutParams.setMargins(layoutParams.leftMargin, layoutParams.topMargin + ao.getStatusBarHeight(getContext()), layoutParams.rightMargin, layoutParams.bottomMargin);
        view.setLayoutParams(layoutParams);
        AppMethodBeat.o(219882);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x01f6  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0201  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r14) {
        /*
        // Method dump skipped, instructions count: 646
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.music.ui.MusicMainUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
    }

    class b extends d.a {
        private b() {
        }

        /* synthetic */ b(MusicMainUI musicMainUI, byte b2) {
            this();
        }

        @Override // com.tencent.mm.pluginsdk.l.d.a
        public final void onShake(boolean z) {
            AppMethodBeat.i(63246);
            Log.i("MicroMsg.Music.MusicMainUI", "shake %b", Boolean.valueOf(z));
            long ticksToNow = Util.ticksToNow(MusicMainUI.this.lastShakeTime);
            if (ticksToNow < 1200) {
                Log.i("MicroMsg.Music.MusicMainUI", "tryStartShake delay too short:".concat(String.valueOf(ticksToNow)));
                AppMethodBeat.o(63246);
                return;
            }
            Log.w("MicroMsg.Music.MusicMainUI", "tryStartShake delay too enough:".concat(String.valueOf(ticksToNow)));
            MusicMainUI.this.lastShakeTime = Util.currentTicks();
            MusicMainUI.g(MusicMainUI.this);
            if (MusicMainUI.this.AnT % 2 == 0) {
                ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).Pl(MusicMainUI.this.scene);
            }
            AppMethodBeat.o(63246);
        }

        @Override // com.tencent.mm.pluginsdk.l.d.a
        public final void onRelease() {
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(63249);
        super.onResume();
        this.AnM = System.currentTimeMillis();
        this.AnP = false;
        if (!((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).etZ()) {
            Log.i("MicroMsg.Music.MusicMainUI", "no need to shake music");
            ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).eub();
        } else if (!this.AkV) {
            if (this.shakeSensor != null && this.shakeSensor.gom() && !this.shakeSensor.gok()) {
                this.shakeSensor.a(new b(this, (byte) 0));
            }
            this.lastShakeTime = Util.currentTicks();
        }
        k.euj().etW().b(this.AhI);
        cBY();
        AppMethodBeat.o(63249);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        int i2;
        int i3;
        int i4 = 1;
        AppMethodBeat.i(63250);
        super.onPause();
        this.AnN = System.currentTimeMillis();
        f etU = k.euj().etU();
        com.tencent.mm.plugin.music.model.e.a etY = ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).etY();
        if (!(etU == null || etY == null)) {
            if (!TextUtils.isEmpty(etY.field_songLyric)) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (!TextUtils.isEmpty(etU.jfw)) {
                this.AnQ = etU.jfw;
            }
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[13];
            objArr[0] = "";
            objArr[1] = "";
            objArr[2] = Long.valueOf(this.AnM);
            objArr[3] = Long.valueOf(this.AnN);
            objArr[4] = etY.field_songName;
            objArr[5] = 0;
            objArr[6] = this.AnO;
            objArr[7] = Integer.valueOf(i2);
            if (this.AnP) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            objArr[8] = Integer.valueOf(i3);
            objArr[9] = Integer.valueOf(etU.jeT);
            objArr[10] = this.AnQ;
            objArr[11] = this.AnR;
            if (this.scene != 9) {
                i4 = 0;
            }
            objArr[12] = Integer.valueOf(i4);
            hVar.a(17629, objArr);
        }
        if (this.shakeSensor != null) {
            this.shakeSensor.cBo();
        }
        k.euj().etW().c(this.AhI);
        AppMethodBeat.o(63250);
    }

    private void evl() {
        AppMethodBeat.i(63251);
        this.AnG.count = 200000;
        this.AnG.notifyDataSetChanged();
        if (((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).eug()) {
            this.AnF.setCanSlide(true);
            AppMethodBeat.o(63251);
            return;
        }
        this.AnF.setCanSlide(false);
        AppMethodBeat.o(63251);
    }

    private void evm() {
        AppMethodBeat.i(63252);
        if (this.AnU != null) {
            this.AnU.cancel();
        }
        this.AnU = null;
        AppMethodBeat.o(63252);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(63253);
        super.onDestroy();
        if (this.shakeSensor != null) {
            this.shakeSensor.cBo();
        }
        if (this.AnG != null) {
            b bVar = this.AnG;
            bVar.Aky.removeCallbacksAndMessages(null);
            com.tencent.mm.plugin.music.model.i iVar = bVar.Ank;
            iVar.Aky.removeCallbacksAndMessages(null);
            iVar.gnw.clear();
        }
        if (this.AnE != null) {
            this.AnE.jl(false);
        }
        evm();
        EventCenter.instance.removeListener(this.lEl);
        k.euj().etW().c(this.AhI);
        if (!k.euj().etW().bec()) {
            k.euj().etW().stopPlay();
        }
        ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).euf();
        AppMethodBeat.o(63253);
    }

    public void onClickBack(View view) {
        AppMethodBeat.i(63254);
        Log.i("MicroMsg.Music.MusicMainUI", "onClickBack finish");
        finish();
        AppMethodBeat.o(63254);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.be1;
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
    }

    class a implements Runnable {
        int position;

        public a(int i2) {
            this.position = i2;
        }

        public final void run() {
            AppMethodBeat.i(63245);
            ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).SO(this.position);
            com.tencent.mm.plugin.music.model.e.a etY = ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).etY();
            if (etY == null) {
                AppMethodBeat.o(63245);
                return;
            }
            if (etY.euM()) {
                MusicMainUI.this.l(etY);
            }
            if (((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).eug()) {
                MusicMainUI.this.AnF.setCanSlide(true);
            }
            MusicMainUI.a(MusicMainUI.this, etY);
            AppMethodBeat.o(63245);
        }
    }

    private void k(com.tencent.mm.plugin.music.model.e.a aVar) {
        AppMethodBeat.i(63256);
        if (!m.a(aVar) || this.AkV) {
            this.AnB.setVisibility(4);
            this.AnD.setVisibility(4);
            AppMethodBeat.o(63256);
            return;
        }
        this.AnB.setVisibility(0);
        this.AnD.setVisibility(0);
        AppMethodBeat.o(63256);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        AppMethodBeat.i(63257);
        Log.i("MicroMsg.Music.MusicMainUI", "onPageSelected %d", Integer.valueOf(i2));
        if (((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).eug()) {
            this.AnF.setCanSlide(false);
        }
        this.goC.removeCallbacksAndMessages(null);
        this.goC.postDelayed(new a(i2), 500);
        if (this.wAr == -1) {
            this.wAr = i2;
        }
        if (this.wAr != i2) {
            this.wAr = i2;
            com.tencent.mm.plugin.music.model.d.e.Alx = true;
            h.INSTANCE.idkeyStat(285, 3, 1, false);
            com.tencent.mm.plugin.music.model.d.e.hu(1, this.scene);
        }
        AppMethodBeat.o(63257);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(63258);
        if (-1 == i3 && 1 == i2) {
            m.a(k.euj().etU(), intent, this);
            AppMethodBeat.o(63258);
            return;
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(63258);
    }

    private void cBY() {
        AppMethodBeat.i(63259);
        int etn = k.euj().etW().etn();
        int duration = k.euj().etW().getDuration();
        if (etn > 0 && duration > 0) {
            this.AnE.setProgress(etn);
            this.AnE.setMaxProgress(duration);
        }
        AppMethodBeat.o(63259);
    }

    public final void l(com.tencent.mm.plugin.music.model.e.a aVar) {
        AppMethodBeat.i(63260);
        com.tencent.mm.plugin.music.model.e.a etY = ((e) com.tencent.mm.plugin.music.f.c.b.aS(e.class)).etY();
        if (etY == null) {
            AppMethodBeat.o(63260);
            return;
        }
        if (!(!etY.h(aVar) || this.AnD == null || this.AnC == null || this.AnB == null || this.AnD.getBackground() == null || this.AnC.getBackground() == null || this.AnB.getBackground() == null || this.AnE == null)) {
            if (aVar.euM()) {
                int i2 = aVar.field_songLyricColor;
                this.AnD.getBackground().setColorFilter(i2, PorterDuff.Mode.MULTIPLY);
                this.AnC.getBackground().setColorFilter(i2, PorterDuff.Mode.MULTIPLY);
                this.AnB.getBackground().setColorFilter(i2, PorterDuff.Mode.MULTIPLY);
                this.AnE.setColor(i2);
                this.AnI.setTextColor(i2);
                this.AnK.getDrawable().setColorFilter(i2, PorterDuff.Mode.MULTIPLY);
                AppMethodBeat.o(63260);
                return;
            }
            this.AnD.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
            this.AnC.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
            this.AnB.getBackground().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
            this.AnE.setColor(-1);
            this.AnI.setTextColor(-1);
            this.AnK.getDrawable().setColorFilter(-1, PorterDuff.Mode.MULTIPLY);
        }
        AppMethodBeat.o(63260);
    }

    public void onClickSend(View view) {
        AppMethodBeat.i(63255);
        final f etU = k.euj().etU();
        Log.i("MicroMsg.Music.MusicMainUI", "MusicType:%d, SongWebUrl ", Integer.valueOf(etU.jeT), etU.jfd);
        if (etU.jeT == 11) {
            ho hoVar = new ho();
            EventCenter.instance.publish(hoVar);
            final String str = hoVar.dMd.appId;
            String str2 = hoVar.dMd.brandName;
            final String str3 = hoVar.dMd.appUserName;
            final int i2 = hoVar.dMd.dMe;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            Log.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", str, str2, Integer.valueOf(i2), str3);
            String string = getString(R.string.dvd, new Object[]{str2});
            if (!TextUtils.isEmpty(etU.jfd)) {
                ArrayList arrayList = new ArrayList();
                String[] strArr = {getString(R.string.f9x), getString(R.string.f9y), getString(R.string.ay9), string};
                arrayList.add(0);
                arrayList.add(2);
                arrayList.add(3);
                arrayList.add(4);
                com.tencent.mm.ui.base.h.a(this, "", strArr, "", new h.d() {
                    /* class com.tencent.mm.plugin.music.ui.MusicMainUI.AnonymousClass8 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    @Override // com.tencent.mm.ui.base.h.d
                    public final void oj(int i2) {
                        AppMethodBeat.i(63241);
                        switch (i2) {
                            case 0:
                                m.av(MusicMainUI.this);
                                com.tencent.mm.plugin.music.model.d.e.SX(MusicMainUI.this.scene);
                                com.tencent.mm.plugin.music.model.d.e.SZ(2);
                                AppMethodBeat.o(63241);
                                return;
                            case 1:
                                m.c(etU, MusicMainUI.this);
                                com.tencent.mm.plugin.music.model.d.e.SY(MusicMainUI.this.scene);
                                com.tencent.mm.plugin.music.model.d.e.SZ(1);
                                AppMethodBeat.o(63241);
                                return;
                            case 2:
                                m.a(etU, MusicMainUI.this);
                                com.tencent.mm.plugin.music.model.d.e.SZ(3);
                                AppMethodBeat.o(63241);
                                return;
                            case 3:
                                m.ag(str, str3, i2);
                                break;
                        }
                        AppMethodBeat.o(63241);
                    }
                });
                AppMethodBeat.o(63255);
                return;
            }
            new ArrayList().add(1);
            com.tencent.mm.ui.base.h.a(this, "", new String[]{string}, "", new h.d() {
                /* class com.tencent.mm.plugin.music.ui.MusicMainUI.AnonymousClass9 */

                @Override // com.tencent.mm.ui.base.h.d
                public final void oj(int i2) {
                    AppMethodBeat.i(63242);
                    switch (i2) {
                        case 0:
                            m.ag(str, str3, i2);
                            break;
                    }
                    AppMethodBeat.o(63242);
                }
            });
            AppMethodBeat.o(63255);
            return;
        }
        if (!TextUtils.isEmpty(etU.jfd)) {
            ArrayList arrayList2 = new ArrayList();
            String[] strArr2 = {getString(R.string.f9x), getString(R.string.f9y), getString(R.string.ay9), getString(R.string.c8x)};
            arrayList2.add(0);
            arrayList2.add(2);
            arrayList2.add(3);
            arrayList2.add(4);
            com.tencent.mm.ui.base.h.a(this, "", strArr2, "", new h.d() {
                /* class com.tencent.mm.plugin.music.ui.MusicMainUI.AnonymousClass10 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.ui.base.h.d
                public final void oj(int i2) {
                    AppMethodBeat.i(63243);
                    switch (i2) {
                        case 0:
                            m.av(MusicMainUI.this);
                            com.tencent.mm.plugin.music.model.d.e.SX(MusicMainUI.this.scene);
                            com.tencent.mm.plugin.music.model.d.e.SZ(2);
                            AppMethodBeat.o(63243);
                            return;
                        case 1:
                            m.c(etU, MusicMainUI.this);
                            com.tencent.mm.plugin.music.model.d.e.SY(MusicMainUI.this.scene);
                            com.tencent.mm.plugin.music.model.d.e.SZ(1);
                            AppMethodBeat.o(63243);
                            return;
                        case 2:
                            m.a(etU, MusicMainUI.this);
                            com.tencent.mm.plugin.music.model.d.e.SZ(3);
                            AppMethodBeat.o(63243);
                            return;
                        case 3:
                            m.b(etU, MusicMainUI.this);
                            com.tencent.mm.plugin.music.model.d.e.SZ(4);
                            break;
                    }
                    AppMethodBeat.o(63243);
                }
            });
        }
        AppMethodBeat.o(63255);
    }

    static /* synthetic */ void e(MusicMainUI musicMainUI) {
        AppMethodBeat.i(63262);
        f etU = k.euj().etU();
        if (etU == null) {
            Log.e("MicroMsg.Music.MusicMainUI", "doJumpToApp wrapper is null");
            AppMethodBeat.o(63262);
            return;
        }
        Log.i("MicroMsg.Music.MusicMainUI", "doJumpToApp MusicType:%d, SongWebUrl:%s, AppId:%s, srcUsername:%s", Integer.valueOf(etU.jeT), etU.jfd, etU.jfi, etU.eag);
        g o = com.tencent.mm.pluginsdk.model.app.h.o(etU.jfi, true, false);
        if (o != null) {
            Log.i("MicroMsg.Music.MusicMainUI", "packageName:%s", o.field_packageName);
        } else {
            Log.e("MicroMsg.Music.MusicMainUI", "appInfo is null");
        }
        musicMainUI.AnP = true;
        if (etU.jeT == 11) {
            ho hoVar = new ho();
            EventCenter.instance.publish(hoVar);
            String str = hoVar.dMd.appId;
            String str2 = hoVar.dMd.brandName;
            String str3 = hoVar.dMd.appUserName;
            int i2 = hoVar.dMd.dMe;
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            Log.i("MicroMsg.Music.MusicMainUI", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", str, str2, Integer.valueOf(i2), str3);
            Log.i("MicroMsg.Music.MusicMainUI", "launch app brand Application");
            m.ag(str, str3, i2);
            AppMethodBeat.o(63262);
        } else if (!TextUtils.isEmpty(etU.jfi) && etU.jfi.equals("wx485a97c844086dc9")) {
            Log.i("MicroMsg.Music.MusicMainUI", "launch qq music Application");
            m.b(etU, musicMainUI);
            AppMethodBeat.o(63262);
        } else if (!TextUtils.isEmpty(etU.jfi) && o != null && !TextUtils.isEmpty(o.field_packageName) && com.tencent.mm.pluginsdk.model.app.h.s(musicMainUI, etU.jfi)) {
            Log.i("MicroMsg.Music.MusicMainUI", "launch third party app, package name:%s", o.field_packageName);
            Intent launchIntentForPackage = MMApplicationContext.getContext().getPackageManager().getLaunchIntentForPackage(o.field_packageName);
            if (launchIntentForPackage != null) {
                launchIntentForPackage.addFlags(268435456);
                com.tencent.mm.pluginsdk.model.app.h.a(musicMainUI, launchIntentForPackage, o.field_appName, new al() {
                    /* class com.tencent.mm.plugin.music.ui.MusicMainUI.AnonymousClass3 */

                    @Override // com.tencent.mm.pluginsdk.model.app.al
                    public final void v(boolean z, boolean z2) {
                        AppMethodBeat.i(219880);
                        Log.i("MicroMsg.Music.MusicMainUI", "onLaunchApp launchSuccess:%b", Boolean.valueOf(z));
                        AppMethodBeat.o(219880);
                    }
                }, null);
                AppMethodBeat.o(63262);
                return;
            }
            Log.e("MicroMsg.Music.MusicMainUI", "launchApp fail intent is null");
            AppMethodBeat.o(63262);
        } else if (!TextUtils.isEmpty(etU.eag)) {
            String str4 = etU.jfd == null ? etU.jfb : etU.jfd;
            Log.i("MicroMsg.Music.MusicMainUI", "launch biz H5 url:%s", str4);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", str4);
            c.b(musicMainUI, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(63262);
        } else {
            String str5 = etU.jfd == null ? etU.jfb : etU.jfd;
            Log.i("MicroMsg.Music.MusicMainUI", "launch H5 url:%s", str5);
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", str5);
            c.b(musicMainUI, "webview", ".ui.tools.WebViewUI", intent2);
            AppMethodBeat.o(63262);
        }
    }
}
