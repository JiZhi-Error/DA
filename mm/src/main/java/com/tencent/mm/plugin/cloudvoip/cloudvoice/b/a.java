package com.tencent.mm.plugin.cloudvoip.cloudvoice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.plugin.audio.b.c;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0006J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0006\u0010\u0015\u001a\u00020\u0011J\u0006\u0010\u0016\u001a\u00020\u0011J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J&\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010 \u001a\u00020\u0011J\u0006\u0010!\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/audio/OpenVoiceAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseMusicAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "isSpeakerSetFailed", "", "mInnerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getAudioPlayErrState", "", "getFetcedhRefInMs", "getPlayDelayInMs", "getPlayerSpeakerMode", "getPlayerSpeakerStream", "getPlayerVolume", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "isAvailable", "onAudioDeviceStateChanged", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "setSpeakerPhoneOn", "isSpeakerPhoneOn", "setSpeakerPhoneOnInternal", "startPlay", "devCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "sampleRate", WeChatBrands.Business.GROUP_CHANNELS, FFmpegMetadataRetriever.METADATA_KEY_DURATION, "stopPlay", "unInit", "Companion", "cloudvoice_release"})
public final class a extends c {
    public static final C0927a qrA = new C0927a((byte) 0);
    public b jvG = new b(MMApplicationContext.getContext());
    public boolean qry;
    public com.tencent.mm.plugin.voip.model.c qrz;

    static {
        AppMethodBeat.i(186812);
        AppMethodBeat.o(186812);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/audio/OpenVoiceAudioManager$Companion;", "", "()V", "IS_SPEAKER_ON", "", "TAG", "", "cloudvoice_release"})
    /* renamed from: com.tencent.mm.plugin.cloudvoip.cloudvoice.b.a$a  reason: collision with other inner class name */
    public static final class C0927a {
        private C0927a() {
        }

        public /* synthetic */ C0927a(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(186811);
        init();
        AppMethodBeat.o(186811);
    }

    public final void init() {
        AppMethodBeat.i(186807);
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.cei().oId.registerBroadcasts();
        com.tencent.mm.plugin.audio.d.b.cet();
        d.cet();
        a.C0831a aVar2 = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.a(this, "openvoice");
        AppMethodBeat.o(186807);
    }

    public static void unInit() {
        AppMethodBeat.i(186808);
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.agt("openvoice");
        a.C0831a aVar2 = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.cei().oId.unRegisterBroadcasts();
        AppMethodBeat.o(186808);
    }

    public final boolean kJ(boolean z) {
        AppMethodBeat.i(186809);
        Log.i("MicroMsg.OpenVoiceAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", Boolean.valueOf(z));
        jp(z);
        com.tencent.mm.plugin.voip.model.c cVar = this.qrz;
        if (cVar == null || cVar.isPlaying()) {
            AppMethodBeat.o(186809);
            return false;
        }
        com.tencent.mm.plugin.voip.model.c cVar2 = this.qrz;
        if (cVar2 == null) {
            p.hyc();
        }
        boolean wS = cVar2.wS(z);
        AppMethodBeat.o(186809);
        return wS;
    }

    public final boolean isAvailable() {
        return this.qrz != null;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.audio.b.a
    public final void iY(int i2) {
        boolean z = false;
        AppMethodBeat.i(186810);
        super.iY(i2);
        switch (i2) {
            case 1:
            case 3:
            case 6:
            case 7:
                this.qry &= kJ(true);
                AppMethodBeat.o(186810);
                return;
            case 2:
                this.qry = kJ(false) & this.qry;
                AppMethodBeat.o(186810);
                return;
            case 8:
                Log.i("MicroMsg.OpenVoiceAudioManager", " isHeadsetPlug connected, isBluetoothConnected: %s", Boolean.valueOf(AY(4)));
                this.qry = kJ(false) & this.qry;
                break;
            case 9:
                Log.i("MicroMsg.OpenVoiceAudioManager", "isHeadsetPlugged disconnected, isBluetoothConnected: %s", Boolean.valueOf(AY(4)));
                if (!AY(4)) {
                    z = true;
                }
                this.qry = kJ(z) & this.qry;
                AppMethodBeat.o(186810);
                return;
        }
        AppMethodBeat.o(186810);
    }
}
