package com.tencent.mm.plugin.multitalk.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.audio.b.b;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\nJ\u0006\u0010\u000f\u001a\u00020\nJ\u0006\u0010\u0010\u001a\u00020\u0006J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0016J\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J&\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nJ\u0006\u0010 \u001a\u00020\u0013J\u0006\u0010!\u001a\u00020\u0013R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ilinkservice/audio/ILinkAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "isSpeakerSetFailed", "", "mInnerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getAudioPlayErrState", "", "getFetcedhRefInMs", "getPlayDelayInMs", "getPlayerSpeakerMode", "getPlayerSpeakerStream", "getPlayerVolume", "isAvailable", "isSpeakerAfterBluetoothDisconnected", "onAudioDeviceStateChanged", "", "status", "releaseAudioPlayingDevice", "requestAudioPlayingDevice", "setSpeakerPhoneOn", "isSpeakerPhoneOn", "setSpeakerPhoneOnInternal", "startPlay", "devCallBack", "Lcom/tencent/mm/plugin/voip/model/AudioPlayDevCallBack;", "sampleRate", WeChatBrands.Business.GROUP_CHANNELS, FFmpegMetadataRetriever.METADATA_KEY_DURATION, "stopPlay", "unInit", "Companion", "plugin-multitalk_release"})
public final class a extends b {
    public static final C1487a zKM = new C1487a((byte) 0);
    public com.tencent.mm.compatible.util.b jvG = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    public boolean qry;
    public c qrz;

    static {
        AppMethodBeat.i(239560);
        AppMethodBeat.o(239560);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/ilinkservice/audio/ILinkAudioManager$Companion;", "", "()V", "IS_SPEAKER_ON", "", "TAG", "", "plugin-multitalk_release"})
    /* renamed from: com.tencent.mm.plugin.multitalk.b.a.a$a  reason: collision with other inner class name */
    public static final class C1487a {
        private C1487a() {
        }

        public /* synthetic */ C1487a(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(239559);
        com.tencent.mm.plugin.audio.d.b.cet();
        d.cet();
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.a(this, "openvoice");
        AppMethodBeat.o(239559);
    }

    public static void unInit() {
        AppMethodBeat.i(239555);
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.agt("openvoice");
        AppMethodBeat.o(239555);
    }

    public final boolean kJ(boolean z) {
        AppMethodBeat.i(239556);
        Log.i("MicroMsg.ILinkAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", Boolean.valueOf(z));
        jp(z);
        boolean ru = ru(z);
        AppMethodBeat.o(239556);
        return ru;
    }

    private final boolean ru(boolean z) {
        AppMethodBeat.i(239557);
        c cVar = this.qrz;
        if (cVar == null || !cVar.isPlaying()) {
            AppMethodBeat.o(239557);
            return false;
        }
        c cVar2 = this.qrz;
        if (cVar2 == null) {
            p.hyc();
        }
        boolean wS = cVar2.wS(z);
        AppMethodBeat.o(239557);
        return wS;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.audio.b.a
    public final void iY(int i2) {
        boolean z = false;
        AppMethodBeat.i(239558);
        super.iY(i2);
        switch (i2) {
            case 1:
            case 3:
            case 6:
            case 7:
                this.qry &= kJ(true);
                ac.eol().ry(false);
                q eom = ac.eom();
                p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
                if (eom.czl() && !AY(3)) {
                    z = true;
                }
                q eom2 = ac.eom();
                p.g(eom2, "SubCoreMultiTalk.getMultiTalkManager()");
                if (eom2.czl() && !AY(3)) {
                    q eom3 = ac.eom();
                    p.g(eom3, "SubCoreMultiTalk.getMultiTalkManager()");
                    z = eom3.enS();
                }
                if (AY(3)) {
                    ac.eol().ry(true);
                    AppMethodBeat.o(239558);
                    return;
                }
                ac.eol().rz(z);
                AppMethodBeat.o(239558);
                return;
            case 2:
                this.qry &= kJ(false);
                ac.eol().ry(true);
                ac.eol().rz(false);
                AppMethodBeat.o(239558);
                return;
            case 8:
                Log.i("MicroMsg.ILinkAudioManager", " isHeadsetPlug connected, isBluetoothConnected: %s", Boolean.valueOf(AY(4)));
                this.qry &= kJ(false);
                ac.eol().ry(true);
                ac.eol().rz(false);
                break;
            case 9:
                Log.i("MicroMsg.ILinkAudioManager", "isHeadsetPlugged disconnected, isBluetoothConnected: %s", Boolean.valueOf(AY(4)));
                ac.eol().ry(false);
                if (AY(4)) {
                    ac.eol().ry(true);
                } else {
                    z = true;
                }
                this.qry &= kJ(z);
                ac.eol().rz(z);
                AppMethodBeat.o(239558);
                return;
        }
        AppMethodBeat.o(239558);
    }
}
