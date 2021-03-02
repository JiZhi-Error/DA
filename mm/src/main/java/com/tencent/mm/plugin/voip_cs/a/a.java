package com.tencent.mm.plugin.voip_cs.a;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.audio.b.c;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.plugin.audio.b.e;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011*\u0001\u0006\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\u000e\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u000fJ\b\u0010\u0016\u001a\u00020\rH\u0002J\b\u0010\u0017\u001a\u00020\rH\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0006\u0010\u001a\u001a\u00020\rJ\u0006\u0010\u001b\u001a\u00020\rJ\u0006\u0010\u001c\u001a\u00020\u0011J\u0006\u0010\u001d\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\rJ\u0010\u0010\u001f\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010 \u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "()V", "audioPlayDevCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "mPcmRecListener", "com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1;", "player", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "recorder", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder;", "enableSpeaker", "", "speakerOn", "", "getAudioPlayVolume", "", "getAudioPlayerStreamType", "getAudioRecordReadNum", "getCurrentStreamType", "isRingStop", "iniRecord", "initPlayer", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "startPlayAudio", "startRecordAudio", "stop", "switchSpeakerPhone", "unInit", "Companion", "plugin-voip-cs_release"})
public final class a extends e {
    public static final C1899a HqB = new C1899a((byte) 0);
    public com.tencent.mm.plugin.voip.model.c GWB;
    private final c HqA = new c();
    public com.tencent.mm.audio.b.c qrH;
    private final com.tencent.mm.plugin.voip.model.b zMj = b.HqC;

    static {
        AppMethodBeat.i(199046);
        AppMethodBeat.o(199046);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$Companion;", "", "()V", "TAG", "", "plugin-voip-cs_release"})
    /* renamed from: com.tencent.mm.plugin.voip_cs.a.a$a  reason: collision with other inner class name */
    public static final class C1899a {
        private C1899a() {
        }

        public /* synthetic */ C1899a(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(199045);
        com.tencent.mm.plugin.audio.d.b.cet();
        d.cet();
        this.qrH = new com.tencent.mm.audio.b.c(v2protocal.VOICE_SAMPLERATE, 1, 1);
        com.tencent.mm.audio.b.c cVar = this.qrH;
        if (cVar != null) {
            cVar.jk(20);
        }
        com.tencent.mm.audio.b.c cVar2 = this.qrH;
        if (cVar2 != null) {
            cVar2.dd(true);
        }
        com.tencent.mm.audio.b.c cVar3 = this.qrH;
        if (cVar3 != null) {
            cVar3.aag();
        }
        com.tencent.mm.audio.b.c cVar4 = this.qrH;
        if (cVar4 != null) {
            cVar4.x(1, false);
        }
        com.tencent.mm.audio.b.c cVar5 = this.qrH;
        if (cVar5 != null) {
            cVar5.dc(true);
        }
        com.tencent.mm.audio.b.c cVar6 = this.qrH;
        if (cVar6 != null) {
            cVar6.a(this.HqA);
        }
        this.GWB = new com.tencent.mm.plugin.voip.model.c();
        com.tencent.mm.plugin.voip.model.c cVar7 = this.GWB;
        if (cVar7 != null) {
            cVar7.N(v2protocal.VOICE_SAMPLERATE, 1, 20, 0);
        }
        com.tencent.mm.plugin.voip.model.c cVar8 = this.GWB;
        if (cVar8 != null) {
            cVar8.F(MMApplicationContext.getContext(), false);
        }
        com.tencent.mm.plugin.voip.model.c cVar9 = this.GWB;
        if (cVar9 != null) {
            cVar9.a(this.zMj);
        }
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.a(this, "voipcs");
        AppMethodBeat.o(199045);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "", "pcm", "", "kotlin.jvm.PlatformType", "len", "PlayDevDataCallBack"})
    static final class b implements com.tencent.mm.plugin.voip.model.b {
        public static final b HqC = new b();

        static {
            AppMethodBeat.i(199036);
            AppMethodBeat.o(199036);
        }

        b() {
        }

        @Override // com.tencent.mm.plugin.voip.model.b
        public final int Q(byte[] bArr, int i2) {
            AppMethodBeat.i(199035);
            Log.d("MicroMsg.cs.VoIPCsAudioManager", "PlayDevDataCallBack,pcm data len:" + bArr.length);
            com.tencent.mm.plugin.voip_cs.c.b.a fMr = com.tencent.mm.plugin.voip_cs.c.c.fMr();
            p.g(fMr, "SubCoreVoipCS.getVoipCSEngine()");
            int playCallback = fMr.fMM().playCallback(bArr, i2);
            if (playCallback != 0) {
                Log.d("MicroMsg.cs.VoIPCsAudioManager", "PlayDevDataCallBack is failure! pc data:" + bArr.length + ",ret:" + playCallback);
            }
            if (playCallback != 0) {
                AppMethodBeat.o(199035);
                return 1;
            }
            AppMethodBeat.o(199035);
            return 0;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/voip_cs/audio/VoIPCSAudioManager$mPcmRecListener$1", "Lcom/tencent/mm/audio/recorder/MMPcmRecorder$OnPcmRecListener;", "onRecError", "", "state", "", "detailState", "onRecPcmDataReady", "pcm", "", "len", "plugin-voip-cs_release"})
    public static final class c implements c.a {
        c() {
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void w(byte[] bArr, int i2) {
            AppMethodBeat.i(199037);
            p.h(bArr, "pcm");
            if (i2 <= 0) {
                Log.e("MicroMsg.cs.VoIPCsAudioManager", "pcm data len <= 0");
                AppMethodBeat.o(199037);
                return;
            }
            Log.d("MicroMsg.cs.VoIPCsAudioManager", "onRecPcmDataReady,pcm data len:" + bArr.length);
            com.tencent.mm.plugin.voip_cs.c.b.a fMr = com.tencent.mm.plugin.voip_cs.c.c.fMr();
            p.g(fMr, "SubCoreVoipCS.getVoipCSEngine()");
            Log.d("MicroMsg.cs.VoIPCsAudioManager", "recordCallback,ret:".concat(String.valueOf(fMr.fMM().recordCallback(bArr, i2, 200))));
            AppMethodBeat.o(199037);
        }

        @Override // com.tencent.mm.audio.b.c.a
        public final void cj(int i2, int i3) {
            AppMethodBeat.i(199038);
            Log.i("MicroMsg.cs.VoIPCsAudioManager", "OnPcmRecListener onRecError %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
            AppMethodBeat.o(199038);
        }
    }

    public static void unInit() {
        AppMethodBeat.i(199039);
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.agt("voipcs");
        AppMethodBeat.o(199039);
    }

    private final boolean wS(boolean z) {
        AppMethodBeat.i(199040);
        if (this.GWB != null) {
            com.tencent.mm.plugin.voip.model.c cVar = this.GWB;
            if (cVar == null) {
                p.hyc();
            }
            boolean wS = cVar.wS(z);
            AppMethodBeat.o(199040);
            return wS;
        }
        AppMethodBeat.o(199040);
        return false;
    }

    private final void xo(boolean z) {
        boolean z2;
        AppMethodBeat.i(199041);
        Log.printDebugStack("MicroMsg.cs.VoIPCsAudioManager", "enableSpeaker: ".concat(String.valueOf(z)), new Object[0]);
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
        if (com.tencent.mm.plugin.audio.d.b.ceb()) {
            z2 = false;
        } else {
            z2 = z;
        }
        if (ae.gKu.gDA) {
            ae.gKu.dump();
            if (ae.gKu.gDB > 0) {
                wS(z2);
            }
        }
        if (ae.gKu.gEh >= 0 || ae.gKu.gEi >= 0) {
            wS(z);
        }
        if (this.GWB != null) {
            com.tencent.mm.plugin.voip.model.c cVar = this.GWB;
            if (cVar == null) {
                p.hyc();
            }
            a(z, cVar.bhV(), false);
            com.tencent.mm.plugin.voip_cs.c.c.fMr().xe(z);
        }
        AppMethodBeat.o(199041);
    }

    public final int xC(boolean z) {
        int i2 = 2;
        AppMethodBeat.i(199042);
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
        if (com.tencent.mm.plugin.audio.d.b.ceb()) {
            a.C0831a aVar2 = com.tencent.mm.plugin.audio.c.a.oIh;
            i2 = a.C0831a.cea().cdX();
        } else if (!z) {
            com.tencent.mm.plugin.voip_cs.c.e fMs = com.tencent.mm.plugin.voip_cs.c.c.fMs();
            p.g(fMs, "SubCoreVoipCS.getVoipCSService()");
            if (fMs.fMy() == 2 || this.GWB == null) {
                i2 = 0;
            } else {
                com.tencent.mm.plugin.voip.model.c cVar = this.GWB;
                if (cVar == null) {
                    p.hyc();
                }
                i2 = cVar.bhV();
            }
        }
        Log.d("MicroMsg.cs.VoIPCsAudioManager", "Current StreamType:%d", Integer.valueOf(i2));
        AppMethodBeat.o(199042);
        return i2;
    }

    public final void Yl() {
        AppMethodBeat.i(199043);
        if (!cdW()) {
            a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
            com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
            if (!com.tencent.mm.plugin.audio.d.b.ceb()) {
                b("voipcs", (Integer) 1);
                xo(true);
                AppMethodBeat.o(199043);
                return;
            }
        }
        b("voipcs", (Integer) 4);
        xo(false);
        AppMethodBeat.o(199043);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.audio.b.a
    public final void iY(int i2) {
        AppMethodBeat.i(199044);
        super.iY(i2);
        switch (i2) {
            case 1:
            case 3:
            case 6:
            case 7:
                agq("voipcs");
                xo(true);
                AppMethodBeat.o(199044);
                return;
            case 2:
                xo(false);
                AppMethodBeat.o(199044);
                return;
            case 8:
                xo(false);
                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.i4u), 0).show();
                AppMethodBeat.o(199044);
                return;
            case 9:
                xo(true);
                Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.string.i4v), 0).show();
                break;
        }
        AppMethodBeat.o(199044);
    }
}
