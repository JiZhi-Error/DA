package com.tencent.mm.plugin.ipcall.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.ipcall.model.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 )2\u00020\u0001:\u0002)*B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001c\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u001aJ\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001aH\u0016J\u0006\u0010\"\u001a\u00020\u001fJ\u0010\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020\u0018H\u0016J\u0006\u0010%\u001a\u00020\u001fJ\u0006\u0010&\u001a\u00020\u001fJ\u0006\u0010'\u001a\u00020\u001fJ\u0006\u0010(\u001a\u00020\u001fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, hxF = {"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "deviceChangeCallback", "Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "getDeviceChangeCallback", "()Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "setDeviceChangeCallback", "(Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;)V", "ipCallAudioPlayer", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "getIpCallAudioPlayer", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;", "setIpCallAudioPlayer", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallAudioPlayer;)V", "ipCallRecorder", "Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "getIpCallRecorder", "()Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;", "setIpCallRecorder", "(Lcom/tencent/mm/plugin/ipcall/model/device/IPCallRecorder;)V", "resumeSpeakerStatus", "", "getAudioPlayVolume", "", "getCurrentStreamType", "getPlayErrState", "getRecordErrState", "initAudioPlayingDevice", "", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestSpeakerOn", "value", "requestSpeakerOnResume", JsApiStartRecordVoice.NAME, JsApiStopRecordVoice.NAME, "unInit", "Companion", "OnDeviceChangeCallback", "app_release"})
public final class a extends com.tencent.mm.plugin.audio.b.b {
    public static final C1440a ypD = new C1440a((byte) 0);
    public final com.tencent.mm.compatible.util.b jvG = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    public com.tencent.mm.plugin.ipcall.model.c.a ypA;
    public c ypB;
    private boolean ypC;
    public b ypz;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$OnDeviceChangeCallback;", "", "onBluetoothPlugStateChange", "", "isPlugged", "", "onHeadsetPlugStateChange", "app_release"})
    public interface b {
        void qu(boolean z);

        void qv(boolean z);
    }

    static {
        AppMethodBeat.i(230654);
        AppMethodBeat.o(230654);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/ipcall/model/audio/IPCallAudioManager$Companion;", "", "()V", "TAG", "", "app_release"})
    /* renamed from: com.tencent.mm.plugin.ipcall.model.a.a$a  reason: collision with other inner class name */
    public static final class C1440a {
        private C1440a() {
        }

        public /* synthetic */ C1440a(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(230653);
        com.tencent.mm.plugin.audio.d.b.cet();
        d.cet();
        this.jvG.requestFocus();
        this.ypA = new com.tencent.mm.plugin.ipcall.model.c.a(this);
        this.ypB = new c();
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.a(this, "ipcall");
        AppMethodBeat.o(230653);
    }

    public static void unInit() {
        AppMethodBeat.i(230648);
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.agt("ipcall");
        AppMethodBeat.o(230648);
    }

    @Override // com.tencent.mm.plugin.audio.b.a
    public final void cV(boolean z) {
        AppMethodBeat.i(230649);
        com.tencent.mm.plugin.ipcall.model.c.a aVar = this.ypA;
        if (aVar != null) {
            aVar.qw(z);
        }
        this.ypC = isSpeakerphoneOn();
        AppMethodBeat.o(230649);
    }

    public final void eaE() {
        AppMethodBeat.i(230650);
        cV(this.ypC);
        AppMethodBeat.o(230650);
    }

    public final void bFT() {
        AppMethodBeat.i(230651);
        c cVar = this.ypB;
        if (cVar != null) {
            cVar.bFT();
            AppMethodBeat.o(230651);
            return;
        }
        AppMethodBeat.o(230651);
    }

    @Override // com.tencent.mm.plugin.audio.b.a
    public final void iY(int i2) {
        b bVar;
        AppMethodBeat.i(230652);
        super.iY(i2);
        switch (i2) {
            case 1:
            case 3:
            case 6:
            case 7:
                if (!AY(3)) {
                    b bVar2 = this.ypz;
                    if (bVar2 != null) {
                        bVar2.qv(false);
                        AppMethodBeat.o(230652);
                        return;
                    }
                    AppMethodBeat.o(230652);
                    return;
                }
                break;
            case 2:
                a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
                com.tencent.mm.plugin.audio.d.b bVar3 = com.tencent.mm.plugin.audio.d.b.oIo;
                if (com.tencent.mm.plugin.audio.d.b.ceb() && this.ypz != null) {
                    b bVar4 = this.ypz;
                    if (bVar4 != null) {
                        bVar4.qv(true);
                        AppMethodBeat.o(230652);
                        return;
                    }
                    AppMethodBeat.o(230652);
                    return;
                }
            case 8:
                Log.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug connected");
                if (!AY(4)) {
                    b bVar5 = this.ypz;
                    if (bVar5 != null) {
                        bVar5.qu(true);
                        AppMethodBeat.o(230652);
                        return;
                    }
                    AppMethodBeat.o(230652);
                    return;
                }
                break;
            case 9:
                Log.i("MicroMsg.IPCallAudioManager", "onHeadsetPlug disconnect");
                if (!AY(4) && (bVar = this.ypz) != null) {
                    bVar.qu(false);
                    AppMethodBeat.o(230652);
                    return;
                }
        }
        AppMethodBeat.o(230652);
    }
}
