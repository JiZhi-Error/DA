package com.tencent.mm.plugin.music.f;

import android.os.Looper;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.f;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import com.tencent.tav.core.AssetExtension;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class a implements d {
    protected boolean AhH;
    protected d.a AhI;
    private PhoneStatusWatcher Ahk;
    protected String AlI = "";
    protected com.tencent.mm.plugin.music.e.d AlJ;
    protected com.tencent.mm.plugin.music.e.a AlK;
    protected long AlL = 0;
    protected LinkedList<d.a> AlM = new LinkedList<>();
    protected long bmy = 0;
    public boolean dSH;
    protected long duration = 0;
    protected long iJF = 0;

    /* access modifiers changed from: protected */
    public abstract void etM();

    /* access modifiers changed from: protected */
    public final void euP() {
        if (this.Ahk == null) {
            if (b.checkSelfPermission(MMApplicationContext.getContext(), "android.permission.READ_PHONE_STATE") != 0) {
                Log.e("MicroMsg.Music.BaseMusicPlayer", "addPhoneStatusWatcher() not have read_phone_state perm");
                return;
            }
            this.Ahk = new PhoneStatusWatcher();
            this.Ahk.begin(MMApplicationContext.getContext());
            this.Ahk.addPhoneCallListener(new PhoneStatusWatcher.PhoneCallListener() {
                /* class com.tencent.mm.plugin.music.f.a.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.PhoneStatusWatcher.PhoneCallListener
                public final void onPhoneCall(int i2) {
                    AppMethodBeat.i(137297);
                    switch (i2) {
                        case 0:
                            if (a.this.AhH) {
                                a.this.AhH = false;
                                a.this.resume();
                                AppMethodBeat.o(137297);
                                return;
                            }
                            break;
                        case 1:
                        case 2:
                            if (a.this.bec()) {
                                a.this.AhH = true;
                                a.this.pause();
                                break;
                            }
                            break;
                    }
                    AppMethodBeat.o(137297);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public final void esT() {
        if (this.Ahk != null) {
            this.Ahk.end();
            this.Ahk.clearPhoneCallListener();
            this.Ahk = null;
        }
    }

    public void h(f fVar) {
        etM();
    }

    public final void G(f fVar) {
        Log.i("MicroMsg.Music.BaseMusicPlayer", "onPreparingEvent %b", Boolean.valueOf(bec()));
        this.AlI = "waiting";
        mx mxVar = new mx();
        mxVar.dSE.action = 11;
        mxVar.dSE.dSy = fVar;
        mxVar.dSE.state = "waiting";
        mxVar.dSE.duration = (long) getDuration();
        mxVar.dSE.dSG = esV();
        EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
    }

    public final void H(f fVar) {
        Log.i("MicroMsg.Music.BaseMusicPlayer", "onPrepareEvent %b", Boolean.valueOf(bec()));
        this.AlI = "canplay";
        mx mxVar = new mx();
        mxVar.dSE.action = 9;
        mxVar.dSE.dSy = fVar;
        mxVar.dSE.state = "canplay";
        mxVar.dSE.duration = (long) getDuration();
        mxVar.dSE.dSG = esV();
        EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
    }

    public final void I(f fVar) {
        Log.i("MicroMsg.Music.BaseMusicPlayer", "onStartEvent %b", Boolean.valueOf(bec()));
        this.AlI = AssetExtension.SCENE_PLAY;
        mx mxVar = new mx();
        mxVar.dSE.action = 0;
        mxVar.dSE.dSy = fVar;
        mxVar.dSE.state = AssetExtension.SCENE_PLAY;
        mxVar.dSE.duration = (long) getDuration();
        mxVar.dSE.dSG = esV();
        EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
        if (this.AlK != null) {
            this.AlK.n(fVar);
        }
    }

    public final void J(f fVar) {
        Log.i("MicroMsg.Music.BaseMusicPlayer", "onResumeEvent");
        this.AlI = AssetExtension.SCENE_PLAY;
        mx mxVar = new mx();
        mxVar.dSE.action = 1;
        mxVar.dSE.dSy = fVar;
        mxVar.dSE.state = AssetExtension.SCENE_PLAY;
        mxVar.dSE.duration = (long) getDuration();
        mxVar.dSE.dSG = esV();
        EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
        if (this.AlK != null) {
            this.AlK.o(fVar);
        }
    }

    public final void K(f fVar) {
        Log.i("MicroMsg.Music.BaseMusicPlayer", "onPauseEvent");
        this.AlI = "pause";
        mx mxVar = new mx();
        mxVar.dSE.action = 3;
        mxVar.dSE.dSy = fVar;
        mxVar.dSE.state = "pause";
        mxVar.dSE.duration = (long) getDuration();
        mxVar.dSE.dSG = esV();
        EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
        if (this.AlK != null) {
            this.AlK.p(fVar);
        }
    }

    public final void L(f fVar) {
        Log.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
        this.AlI = "stop";
        mx mxVar = new mx();
        mxVar.dSE.action = 2;
        mxVar.dSE.dSy = fVar;
        mxVar.dSE.state = "stop";
        mxVar.dSE.duration = (long) getDuration();
        mxVar.dSE.dSG = esV();
        mx.a aVar = mxVar.dSE;
        boolean z = this.dSH;
        this.dSH = false;
        aVar.dSH = z;
        EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
        if (this.AlK != null) {
            this.AlK.q(fVar);
        }
    }

    public final void M(f fVar) {
        Log.i("MicroMsg.Music.BaseMusicPlayer", "onSeekToEvent");
        this.AlI = "seeked";
        mx mxVar = new mx();
        mxVar.dSE.action = 8;
        mxVar.dSE.dSy = fVar;
        mxVar.dSE.state = "seeked";
        mxVar.dSE.duration = (long) getDuration();
        mxVar.dSE.dSG = esV();
        EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
    }

    public final void N(f fVar) {
        Log.i("MicroMsg.Music.BaseMusicPlayer", "onSeekingEvent");
        this.AlI = "seeking";
        mx mxVar = new mx();
        mxVar.dSE.action = 12;
        mxVar.dSE.dSy = fVar;
        mxVar.dSE.state = "seeking";
        mxVar.dSE.duration = (long) getDuration();
        mxVar.dSE.dSG = esV();
        EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
    }

    public final void O(f fVar) {
        Log.i("MicroMsg.Music.BaseMusicPlayer", "onStopEvent");
        this.AlI = "ended";
        mx mxVar = new mx();
        mxVar.dSE.action = 7;
        mxVar.dSE.dSy = fVar;
        mxVar.dSE.state = "ended";
        mxVar.dSE.duration = (long) getDuration();
        mxVar.dSE.dSF = fVar.jeV;
        mxVar.dSE.dSG = esV();
        EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
        if (this.AlK != null) {
            this.AlK.r(fVar);
        }
    }

    public final void d(f fVar, int i2) {
        Log.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent with errCode:%d", Integer.valueOf(i2));
        this.AlI = "error";
        mx mxVar = new mx();
        mxVar.dSE.action = 4;
        mxVar.dSE.dSy = fVar;
        mxVar.dSE.state = "error";
        mxVar.dSE.duration = (long) getDuration();
        mxVar.dSE.dSG = esV();
        mxVar.dSE.errCode = e.Tc(i2);
        mxVar.dSE.errMsg = e.yw(i2);
        EventCenter.instance.asyncPublish(mxVar, Looper.getMainLooper());
        if (this.AlK != null) {
            this.AlK.a(fVar, i2);
        }
    }

    public void a(f fVar, int i2, int i3) {
        Log.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
        d(fVar, -1);
    }

    public final void P(f fVar) {
        Log.i("MicroMsg.Music.BaseMusicPlayer", "onErrorEvent");
        d(fVar, -1);
    }

    /* access modifiers changed from: protected */
    public final String euQ() {
        return this.AlI;
    }

    public void m(f fVar) {
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void b(d.a aVar) {
        if (aVar != null && !this.AlM.contains(aVar)) {
            this.AlM.add(aVar);
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void c(d.a aVar) {
        if (aVar != null && this.AlM.contains(aVar)) {
            this.AlM.remove(aVar);
        }
    }

    /* access modifiers changed from: protected */
    public final void fn(int i2, int i3) {
        if (this.AhI != null) {
            this.AhI.fn(i2, i3);
        }
        Iterator<d.a> it = this.AlM.iterator();
        while (it.hasNext()) {
            it.next().fn(i2, i3);
        }
    }
}
