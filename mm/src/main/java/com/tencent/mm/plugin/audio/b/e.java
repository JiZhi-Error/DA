package com.tencent.mm.plugin.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "doShiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "shiftSpeaker", "StreamType", "", "Companion", "plugin-audio_release"})
public class e extends a {
    public static final a oHZ = new a((byte) 0);

    static {
        AppMethodBeat.i(223965);
        AppMethodBeat.o(223965);
    }

    @Override // com.tencent.mm.plugin.audio.b.a
    public final boolean jp(boolean z) {
        AppMethodBeat.i(223962);
        boolean z2 = z(z, false);
        AppMethodBeat.o(223962);
        return z2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/audio/mgr/BaseVoIPAudioManager$Companion;", "", "()V", "TAG", "", "plugin-audio_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final boolean a(boolean z, int i2, boolean z2) {
        AppMethodBeat.i(223963);
        int streamMaxVolume = this.audioManager.getStreamMaxVolume(i2);
        Log.d("MicroMsg.VoIPAudioManager", "maxVolume:".concat(String.valueOf(streamMaxVolume)));
        int i3 = streamMaxVolume / 3;
        int streamVolume = this.audioManager.getStreamVolume(i2);
        if (streamVolume < i3) {
            com.tencent.mm.compatible.b.a.a(this.audioManager, i2, i3, 0);
        }
        Log.i("MicroMsg.VoIPAudioManager", "StreamType:" + i2 + "  current:" + streamVolume);
        boolean z3 = z(z, z2);
        AppMethodBeat.o(223963);
        return z3;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e oIa;
        final /* synthetic */ z.d oIb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar, z.d dVar) {
            super(0);
            this.oIa = eVar;
            this.oIb = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(223960);
            if (this.oIb.SYE != this.oIa.audioManager.getMode()) {
                if (this.oIa.gCZ == 0) {
                    this.oIa.gCZ = 1;
                } else if (this.oIa.gCZ == 2) {
                    this.oIa.gCZ = 3;
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(223960);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e oIa;
        final /* synthetic */ z.d oIc;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(e eVar, z.d dVar) {
            super(0);
            this.oIa = eVar;
            this.oIc = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(223961);
            if (this.oIc.SYE != this.oIa.audioManager.getMode()) {
                if (this.oIa.gCZ == 0) {
                    this.oIa.gCZ = 2;
                } else if (this.oIa.gCZ == 1) {
                    this.oIa.gCZ = 3;
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(223961);
            return xVar;
        }
    }

    private final boolean z(boolean z, boolean z2) {
        AppMethodBeat.i(223964);
        int mode = this.audioManager.getMode();
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        Log.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker:%b -> %b", Boolean.valueOf(a.C0831a.cea().isSpeakerphoneOn()), Boolean.valueOf(z));
        if (PhoneStatusWatcher.isCalling()) {
            Log.v("MicroMsg.VoIPAudioManager", "shiftSpeaker return when calling Mode:%d", Integer.valueOf(mode));
            AppMethodBeat.o(223964);
            return false;
        }
        if (!z2) {
            a.C0831a aVar2 = com.tencent.mm.plugin.audio.c.a.oIh;
            com.tencent.mm.plugin.audio.d.b bVar = com.tencent.mm.plugin.audio.d.b.oIo;
            if (com.tencent.mm.plugin.audio.d.b.ceb() || this.gCW) {
                Log.i("MicroMsg.VoIPAudioManager", "dkbt shiftSpeaker isBluetoothOn");
                Log.d("MicroMsg.VoIPAudioManager", "Bluetooth is on and now is in VoIP , set 3 MODE_IN_COMMUNICATION..");
                b(3, (kotlin.g.a.a<x>) null);
                AppMethodBeat.o(223964);
                return false;
            }
        }
        if (ae.gKu.gDA) {
            if (ae.gKu.anV()) {
                if (ae.gKu.gDC >= 0) {
                    b(ae.gKu.gDC, (kotlin.g.a.a<x>) null);
                } else if (ae.gKu.gDD >= 0) {
                    if (z) {
                        b(0, (kotlin.g.a.a<x>) null);
                    } else {
                        b(2, (kotlin.g.a.a<x>) null);
                    }
                }
                if (ae.gKu.gDE > 0) {
                    super.cV(z);
                }
                AppMethodBeat.o(223964);
                return z;
            } else if (ae.gKu.anW()) {
                if (z) {
                    if (ae.gKu.anZ()) {
                        super.cV(true);
                    }
                    com.tencent.mm.compatible.deviceinfo.b bVar2 = ae.gKu;
                    p.g(bVar2, "SrvDeviceInfo.mAudioInfo");
                    if (bVar2.anY() >= 0) {
                        com.tencent.mm.compatible.deviceinfo.b bVar3 = ae.gKu;
                        p.g(bVar3, "SrvDeviceInfo.mAudioInfo");
                        b(bVar3.anY(), (kotlin.g.a.a<x>) null);
                    }
                } else {
                    if (ae.gKu.aob()) {
                        super.cV(false);
                    }
                    com.tencent.mm.compatible.deviceinfo.b bVar4 = ae.gKu;
                    p.g(bVar4, "SrvDeviceInfo.mAudioInfo");
                    if (bVar4.aoa() >= 0) {
                        com.tencent.mm.compatible.deviceinfo.b bVar5 = ae.gKu;
                        p.g(bVar5, "SrvDeviceInfo.mAudioInfo");
                        b(bVar5.aoa(), (kotlin.g.a.a<x>) null);
                    }
                }
                AppMethodBeat.o(223964);
                return z;
            }
        }
        if (z) {
            z.d dVar = new z.d();
            dVar.SYE = 3;
            if (ae.gKu.gEe >= 0) {
                dVar.SYE = ae.gKu.gEe;
            }
            Log.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker useSpeakerMode: %s, getMode: %s", Integer.valueOf(dVar.SYE), Integer.valueOf(this.audioManager.getMode()));
            if (dVar.SYE != this.audioManager.getMode()) {
                b(dVar.SYE, new b(this, dVar));
            }
            Log.i("MicroMsg.VoIPAudioManager", "voip doShiftSpeaker true isSpeakerphoneOn: %s", Boolean.valueOf(this.audioManager.isSpeakerphoneOn()));
            super.cV(true);
        } else {
            z.d dVar2 = new z.d();
            dVar2.SYE = 3;
            if (k.alh() && 2 == ae.gKE.gGF) {
                dVar2.SYE = 2;
            }
            if (ae.gKu.gEf >= 0) {
                dVar2.SYE = ae.gKu.gEf;
            }
            Log.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker usePhoneMode: %s getMode:%s", Integer.valueOf(dVar2.SYE), Integer.valueOf(this.audioManager.getMode()));
            if (dVar2.SYE != this.audioManager.getMode()) {
                b(dVar2.SYE, new c(this, dVar2));
            }
            Log.i("MicroMsg.VoIPAudioManager", "VoIP doShiftSpeaker false isSpeakerphoneOn: %s", Boolean.valueOf(this.audioManager.isSpeakerphoneOn()));
            super.cV(false);
        }
        AppMethodBeat.o(223964);
        return z;
    }
}
