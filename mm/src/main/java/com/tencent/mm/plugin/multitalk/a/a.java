package com.tencent.mm.plugin.multitalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.plugin.audio.d.d;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.plugin.voip.video.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u0000 &2\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000eJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\u000eH\u0002J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J\u0006\u0010\u001a\u001a\u00020\u0011J\u0006\u0010\u001b\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0011J\u0016\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u0014J\u0006\u0010 \u001a\u00020\u0011J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u000eH\u0002J\u0006\u0010#\u001a\u00020\u0011J\u0006\u0010$\u001a\u00020\u0011J\u0006\u0010%\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/audio/MultiTalkAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "()V", "audioFocusHelper", "Lcom/tencent/mm/compatible/util/AudioFocusHelper;", "innerPlayer", "Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "getInnerPlayer", "()Lcom/tencent/mm/plugin/voip/model/AudioPlayer;", "setInnerPlayer", "(Lcom/tencent/mm/plugin/voip/model/AudioPlayer;)V", "ringPlayer", "Lcom/tencent/mm/plugin/voip/video/RingPlayer;", "checkCurrentIsSpeakerMute", "", "checkRingPlayStop", "enableSpeakerOn", "", "value", "getAudioPlayErrState", "", "getAudioPlayerStreamType", "getCurrentStreamType", "isSpeakerAfterBluetoothDisconnected", "onAudioDeviceStateChanged", "status", "refreshHandFree", "releaseAudioDeviceCauseStopRing", "releaseAudioPlayingDevice", "requestAudioDeviceToStartRing", "isCallingParty", "type", "requestAudioPlayingDevice", "setSpeakerPhoneOnInternal", "isSpeakerPhoneOn", "turnVolumeDown", "turnVolumeUp", "unInit", "Companion", "plugin-multitalk_release"})
public final class a extends com.tencent.mm.plugin.audio.b.b {
    public static final C1486a zHc = new C1486a((byte) 0);
    public e hTl = new e(MMApplicationContext.getContext());
    private com.tencent.mm.compatible.util.b jvG = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    public c zHb;

    static {
        AppMethodBeat.i(239553);
        AppMethodBeat.o(239553);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ a zHd;
        final /* synthetic */ boolean zHe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, boolean z) {
            super(1);
            this.zHd = aVar;
            this.zHe = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(239541);
            if (bool.booleanValue()) {
                Log.i("MicroMsg.MT.MultiTalkAudioManager", "the bluetooth is connected available and requestAudioDeviceToStartRing");
                this.zHd.hTl.bl(1, this.zHe);
                this.zHd.oHR = null;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(239541);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/multitalk/audio/MultiTalkAudioManager$Companion;", "", "()V", "RINGTYPE_END", "", "RINGTYPE_INVITE", "TAG", "", "plugin-multitalk_release"})
    /* renamed from: com.tencent.mm.plugin.multitalk.a.a$a  reason: collision with other inner class name */
    public static final class C1486a {
        private C1486a() {
        }

        public /* synthetic */ C1486a(byte b2) {
            this();
        }
    }

    public a() {
        AppMethodBeat.i(239552);
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.a(this, "multitalke");
        com.tencent.mm.plugin.audio.d.b.cet();
        d.cet();
        com.tencent.mm.plugin.audio.broadcast.bluetooth.a.agp("multitalke");
        this.jvG.requestFocus();
        if (!cdZ()) {
            b("multitalke", (Integer) 2);
            AppMethodBeat.o(239552);
        } else if (AY(4)) {
            b("multitalke", (Integer) 4);
            AppMethodBeat.o(239552);
        } else {
            b("multitalke", (Integer) 3);
            AppMethodBeat.o(239552);
        }
    }

    public static void unInit() {
        AppMethodBeat.i(239542);
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        a.C0831a.agt("multitalke");
        AppMethodBeat.o(239542);
    }

    public final void rs(boolean z) {
        c cVar;
        AppMethodBeat.i(239543);
        Log.i("MicroMsg.MT.MultiTalkAudioManager", "setSpeakerPhoneOn, isSpeakerPhoneOn: %b", Boolean.valueOf(z));
        jp(z);
        if (this.zHb != null) {
            c cVar2 = this.zHb;
            if (cVar2 == null) {
                AppMethodBeat.o(239543);
                return;
            } else if (cVar2.isPlaying() && (cVar = this.zHb) != null) {
                cVar.wS(z);
                AppMethodBeat.o(239543);
                return;
            }
        }
        AppMethodBeat.o(239543);
    }

    public static void elz() {
        AppMethodBeat.i(239544);
        if (AY(3) || AY(4)) {
            ac.eom().rx(false);
            AppMethodBeat.o(239544);
            return;
        }
        ac.eom().rx(true);
        AppMethodBeat.o(239544);
    }

    public final void P(boolean z, int i2) {
        AppMethodBeat.i(239545);
        if (i2 != 0) {
            this.oHR = null;
            this.hTl.g(R.raw.close_lower_volume, false, 1);
            AppMethodBeat.o(239545);
        } else if (!this.oHS) {
            Log.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing ignore bluetooth or not bt plug");
            this.hTl.bl(1, z);
            AppMethodBeat.o(239545);
        } else {
            Log.i("MicroMsg.MT.MultiTalkAudioManager", "requestAudioDeviceToStartRing but waitting the bt connected");
            this.oHR = new b(this, z);
            AppMethodBeat.o(239545);
        }
    }

    public static int eaL() {
        AppMethodBeat.i(239547);
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
        if (com.tencent.mm.plugin.audio.d.b.ceb()) {
            a.C0831a aVar2 = com.tencent.mm.plugin.audio.c.a.oIh;
            int cdX = a.C0831a.cea().cdX();
            AppMethodBeat.o(239547);
            return cdX;
        }
        com.tencent.mm.plugin.multitalk.model.q eom = ac.eom();
        p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
        if (!eom.czl()) {
            AppMethodBeat.o(239547);
            return 3;
        }
        AppMethodBeat.o(239547);
        return 0;
    }

    public final void Yl() {
        AppMethodBeat.i(239548);
        Log.i("MicroMsg.MT.MultiTalkAudioManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b %s", Boolean.valueOf(AY(3)), Boolean.valueOf(AY(4)), Integer.valueOf(hashCode()));
        if (cdZ()) {
            ac.eom().rx(false);
            if (AY(4)) {
                b("multitalke", (Integer) 4);
            } else {
                b("multitalke", (Integer) 3);
            }
            ac.eol().rz(false);
            ac.eol().ry(true);
        } else {
            com.tencent.mm.plugin.multitalk.model.q eom = ac.eom();
            p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
            if (eom.enq()) {
                b("multitalke", (Integer) 1);
                ac.eol().rz(true);
            } else {
                b("multitalke", (Integer) 2);
                ac.eol().rz(false);
            }
            ac.eol().ry(false);
        }
        this.jvG.requestFocus();
        AppMethodBeat.o(239548);
    }

    public final void elB() {
        AppMethodBeat.i(239549);
        cdV();
        agq("multitalke");
        this.jvG.apm();
        AppMethodBeat.o(239549);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.audio.b.a
    public final void iY(int i2) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(239550);
        super.iY(i2);
        switch (i2) {
            case 1:
            case 3:
            case 6:
            case 7:
                com.tencent.mm.plugin.multitalk.model.q eom = ac.eom();
                p.g(eom, "SubCoreMultiTalk.getMultiTalkManager()");
                boolean z3 = eom.czl() && !AY(3);
                com.tencent.mm.plugin.multitalk.model.q eom2 = ac.eom();
                p.g(eom2, "SubCoreMultiTalk.getMultiTalkManager()");
                if (eom2.czl() && !AY(3)) {
                    com.tencent.mm.plugin.multitalk.model.q eom3 = ac.eom();
                    p.g(eom3, "SubCoreMultiTalk.getMultiTalkManager()");
                    z3 = eom3.enS();
                }
                if (AY(3)) {
                    ac.eol().ry(true);
                } else {
                    ac.eol().rz(z3);
                }
                com.tencent.mm.plugin.multitalk.model.q eom4 = ac.eom();
                p.g(eom4, "SubCoreMultiTalk.getMultiTalkManager()");
                com.tencent.mm.plugin.multitalk.model.q eom5 = ac.eom();
                p.g(eom5, "SubCoreMultiTalk.getMultiTalkManager()");
                com.tencent.mm.plugin.multitalk.model.q eom6 = ac.eom();
                p.g(eom6, "SubCoreMultiTalk.getMultiTalkManager()");
                Log.i("MicroMsg.MT.MultiTalkAudioManager", "isSpeakerAfterBluetoothDisconnected: isHeadsetPlugged: %s, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s, isSpeaker: %s", Boolean.valueOf(AY(3)), Boolean.valueOf(eom4.enq()), Boolean.valueOf(eom5.enS()), Boolean.valueOf(eom6.czl()), Boolean.valueOf(AY(4)), Boolean.valueOf(z3));
                ac.eom().rJ(z3);
                ac.eol().ry(false);
                if (AY(3)) {
                    ac.eom().rx(false);
                    ac.eol().ry(true);
                } else {
                    ac.eom().rx(true);
                }
                if (z3) {
                    ac.eon().setVoicePlayDevice(1);
                    AppMethodBeat.o(239550);
                    return;
                } else if (AY(3)) {
                    ac.eon().setVoicePlayDevice(3);
                    AppMethodBeat.o(239550);
                    return;
                } else {
                    ac.eon().setVoicePlayDevice(2);
                    AppMethodBeat.o(239550);
                    return;
                }
            case 2:
                ac.eom().rx(false);
                cV(false);
                ac.eom().rJ(false);
                ac.eol().ry(true);
                ac.eol().rz(false);
                ac.eon().setVoicePlayDevice(4);
                AppMethodBeat.o(239550);
                return;
            case 8:
                com.tencent.mm.plugin.multitalk.model.q eom7 = ac.eom();
                p.g(eom7, "SubCoreMultiTalk.getMultiTalkManager()");
                com.tencent.mm.plugin.multitalk.model.q eom8 = ac.eom();
                p.g(eom8, "SubCoreMultiTalk.getMultiTalkManager()");
                com.tencent.mm.plugin.multitalk.model.q eom9 = ac.eom();
                p.g(eom9, "SubCoreMultiTalk.getMultiTalkManager()");
                Log.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug connected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", Boolean.valueOf(eom7.enq()), Boolean.valueOf(eom8.enS()), Boolean.valueOf(eom9.czl()), Boolean.valueOf(AY(3)));
                ac.eom().rx(false);
                ac.eom().rJ(false);
                ac.eon().setVoicePlayDevice(3);
                ac.eol().ry(true);
                ac.eol().rz(false);
                AppMethodBeat.o(239550);
                return;
            case 9:
                com.tencent.mm.plugin.multitalk.model.q eom10 = ac.eom();
                p.g(eom10, "SubCoreMultiTalk.getMultiTalkManager()");
                com.tencent.mm.plugin.multitalk.model.q eom11 = ac.eom();
                p.g(eom11, "SubCoreMultiTalk.getMultiTalkManager()");
                com.tencent.mm.plugin.multitalk.model.q eom12 = ac.eom();
                p.g(eom12, "SubCoreMultiTalk.getMultiTalkManager()");
                Log.i("MicroMsg.MT.MultiTalkAudioManager", "isHeadsetPlug disconnected, isHandsFree: %s, isHandsFreeUIStatus: %s, isRingStop: %s, isBluetoothConnected: %s", Boolean.valueOf(eom10.enq()), Boolean.valueOf(eom11.enS()), Boolean.valueOf(eom12.czl()), Boolean.valueOf(AY(4)));
                com.tencent.mm.plugin.multitalk.model.q eom13 = ac.eom();
                p.g(eom13, "SubCoreMultiTalk.getMultiTalkManager()");
                if (eom13.czl()) {
                    com.tencent.mm.plugin.multitalk.model.q eom14 = ac.eom();
                    p.g(eom14, "SubCoreMultiTalk.getMultiTalkManager()");
                    z = eom14.enS();
                } else {
                    z = true;
                }
                ac.eol().ry(false);
                if (AY(4)) {
                    ac.eol().ry(true);
                } else {
                    z2 = z;
                }
                if (z2) {
                    ac.eon().setVoicePlayDevice(1);
                } else if (AY(4)) {
                    ac.eon().setVoicePlayDevice(4);
                } else {
                    ac.eon().setVoicePlayDevice(2);
                }
                ac.eom().rJ(z2);
                ac.eom().rx(true);
                ac.eol().rz(z2);
                break;
        }
        AppMethodBeat.o(239550);
    }

    public static boolean elC() {
        AppMethodBeat.i(239551);
        boolean elC = ac.eol().elC();
        AppMethodBeat.o(239551);
        return elC;
    }

    public final void elA() {
        AppMethodBeat.i(239546);
        this.oHR = null;
        this.hTl.stop();
        this.jvG.apm();
        AppMethodBeat.o(239546);
    }
}
