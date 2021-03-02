package com.tencent.mm.plugin.music.b;

import android.os.Looper;
import com.tencent.mm.ay.c;
import com.tencent.mm.g.a.y;
import com.tencent.mm.plugin.music.f.a.d;
import com.tencent.mm.plugin.music.f.a.e;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tav.core.AssetExtension;

public abstract class i implements j, d {
    protected boolean AhH;
    protected d.a AhI;
    protected e Ahw = null;

    public abstract String esX();

    public abstract String getAppId();

    @Override // com.tencent.mm.plugin.music.b.j
    public final void onPhoneCall(int i2) {
        switch (i2) {
            case 0:
                if (this.AhH) {
                    this.AhH = false;
                    resume();
                    return;
                }
                return;
            case 1:
            case 2:
                if (bec()) {
                    this.AhH = true;
                    pause();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final void esU() {
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final boolean bed() {
        return false;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public boolean esV() {
        return false;
    }

    @Override // com.tencent.mm.plugin.music.f.a.d
    public final c esW() {
        return null;
    }

    public final void esY() {
        Log.i("MicroMsg.Audio.BaseAudioPlayer", "onPrepareEvent");
        y yVar = new y();
        yVar.dCW.action = 7;
        yVar.dCW.state = "canplay";
        yVar.dCW.duration = (long) getDuration();
        yVar.dCW.dtX = esX();
        yVar.dCW.appId = getAppId();
        EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
    }

    public final void esZ() {
        Log.i("MicroMsg.Audio.BaseAudioPlayer", "onStartEvent %b", Boolean.valueOf(bec()));
        y yVar = new y();
        yVar.dCW.action = 0;
        yVar.dCW.state = AssetExtension.SCENE_PLAY;
        yVar.dCW.dtX = esX();
        yVar.dCW.appId = getAppId();
        EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
        if (this.Ahw != null) {
            this.Ahw.onStart(esX());
        }
    }

    public final void eta() {
        Log.i("MicroMsg.Audio.BaseAudioPlayer", "onResumeEvent");
        y yVar = new y();
        yVar.dCW.action = 1;
        yVar.dCW.state = AssetExtension.SCENE_PLAY;
        yVar.dCW.dtX = esX();
        yVar.dCW.appId = getAppId();
        EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
        if (this.Ahw != null) {
            this.Ahw.onStart(esX());
        }
    }

    public final void etb() {
        Log.i("MicroMsg.Audio.BaseAudioPlayer", "onPauseEvent");
        y yVar = new y();
        yVar.dCW.action = 2;
        yVar.dCW.state = "pause";
        yVar.dCW.dtX = esX();
        yVar.dCW.appId = getAppId();
        EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
        if (this.Ahw != null) {
            this.Ahw.aGS(esX());
        }
    }

    public final void etc() {
        Log.i("MicroMsg.Audio.BaseAudioPlayer", "onStopEvent");
        y yVar = new y();
        yVar.dCW.action = 3;
        yVar.dCW.state = "stop";
        yVar.dCW.dtX = esX();
        yVar.dCW.appId = getAppId();
        EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
        if (this.Ahw != null) {
            this.Ahw.arD(esX());
        }
    }

    public final void etd() {
        Log.i("MicroMsg.Audio.BaseAudioPlayer", "onSeekToEvent");
        y yVar = new y();
        yVar.dCW.action = 6;
        yVar.dCW.state = "seeked";
        yVar.dCW.dtX = esX();
        yVar.dCW.appId = getAppId();
        EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
    }

    public final void ete() {
        Log.i("MicroMsg.Audio.BaseAudioPlayer", "onCompleteEvent");
        y yVar = new y();
        yVar.dCW.action = 5;
        yVar.dCW.state = "ended";
        yVar.dCW.dtX = esX();
        yVar.dCW.appId = getAppId();
        EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
        if (this.Ahw != null) {
            this.Ahw.gY(esX());
        }
    }

    public final void St(int i2) {
        Log.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent with errCode:%d", Integer.valueOf(i2));
        y yVar = new y();
        yVar.dCW.action = 4;
        yVar.dCW.state = "error";
        yVar.dCW.errCode = e.Tc(i2);
        yVar.dCW.errMsg = e.yw(i2);
        yVar.dCW.dtX = esX();
        yVar.dCW.appId = getAppId();
        EventCenter.instance.asyncPublish(yVar, Looper.getMainLooper());
        if (this.Ahw != null) {
            this.Ahw.onError(esX());
        }
    }

    public final void etf() {
        Log.i("MicroMsg.Audio.BaseAudioPlayer", "onErrorEvent");
        St(-1);
    }

    public final void a(e eVar) {
        this.Ahw = eVar;
    }
}
