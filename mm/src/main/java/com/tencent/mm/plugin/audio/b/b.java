package com.tencent.mm.plugin.audio.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.audio.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneStatusWatcher;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager;", "Lcom/tencent/mm/plugin/audio/mgr/BaseAudioManager;", "()V", "shiftSpeaker", "", "beSpeakerphoneOn", "ignoreBluetooth", "StreamType", "", "Companion", "plugin-audio_release"})
public class b extends a {
    public static final a oHX = new a((byte) 0);

    static {
        AppMethodBeat.i(223955);
        AppMethodBeat.o(223955);
    }

    @Override // com.tencent.mm.plugin.audio.b.a
    public final boolean jp(boolean z) {
        int i2 = 2;
        AppMethodBeat.i(223954);
        a.C0831a aVar = com.tencent.mm.plugin.audio.c.a.oIh;
        Log.d("MicroMsg.IPCallAudioManager", "IPCall dkbt shiftSpeaker:%b -> %b", Boolean.valueOf(a.C0831a.cea().isSpeakerphoneOn()), Boolean.valueOf(z));
        if (PhoneStatusWatcher.isCalling()) {
            Log.v("MicroMsg.IPCallAudioManager", "shiftSpeaker return when calling");
            AppMethodBeat.o(223954);
            return false;
        } else if (ae.gKu.gES) {
            if (z) {
                int i3 = 3;
                if (ae.gKu.gET >= 0) {
                    i3 = ae.gKu.gET;
                }
                Log.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i3)));
                if (i3 != this.audioManager.getMode()) {
                    b(i3, (kotlin.g.a.a<x>) null);
                }
                if (!this.audioManager.isSpeakerphoneOn()) {
                    super.cV(true);
                }
            } else {
                int i4 = 3;
                if (ae.gKu.gEU >= 0) {
                    i4 = ae.gKu.gEU;
                }
                Log.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(i4)));
                a.C0831a aVar2 = com.tencent.mm.plugin.audio.c.a.oIh;
                if (i4 != a.C0831a.getMode()) {
                    a.C0831a aVar3 = com.tencent.mm.plugin.audio.c.a.oIh;
                    a.C0831a.cea().b(i4, (kotlin.g.a.a<x>) null);
                }
                if (this.audioManager.isSpeakerphoneOn()) {
                    super.cV(false);
                }
            }
            AppMethodBeat.o(223954);
            return z;
        } else {
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
                    AppMethodBeat.o(223954);
                    return z;
                } else if (ae.gKu.anW()) {
                    if (z) {
                        if (ae.gKu.anZ()) {
                            super.cV(true);
                        }
                        com.tencent.mm.compatible.deviceinfo.b bVar = ae.gKu;
                        p.g(bVar, "SrvDeviceInfo.mAudioInfo");
                        if (bVar.anY() >= 0) {
                            com.tencent.mm.compatible.deviceinfo.b bVar2 = ae.gKu;
                            p.g(bVar2, "SrvDeviceInfo.mAudioInfo");
                            b(bVar2.anY(), (kotlin.g.a.a<x>) null);
                        }
                    } else {
                        if (ae.gKu.aob()) {
                            super.js(true);
                        }
                        com.tencent.mm.compatible.deviceinfo.b bVar3 = ae.gKu;
                        p.g(bVar3, "SrvDeviceInfo.mAudioInfo");
                        if (bVar3.aoa() >= 0) {
                            com.tencent.mm.compatible.deviceinfo.b bVar4 = ae.gKu;
                            p.g(bVar4, "SrvDeviceInfo.mAudioInfo");
                            b(bVar4.aoa(), (kotlin.g.a.a<x>) null);
                        }
                    }
                    AppMethodBeat.o(223954);
                    return z;
                }
            }
            if (z) {
                int i5 = 3;
                if (ae.gKu.gEe >= 0) {
                    i5 = ae.gKu.gEe;
                }
                Log.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker useSpeakerMode:".concat(String.valueOf(i5)));
                a.C0831a aVar4 = com.tencent.mm.plugin.audio.c.a.oIh;
                if (i5 != a.C0831a.getMode()) {
                    a.C0831a aVar5 = com.tencent.mm.plugin.audio.c.a.oIh;
                    a.C0831a.cea().b(i5, (kotlin.g.a.a<x>) null);
                }
                super.cV(true);
            } else {
                if (!k.alh() || 2 != ae.gKE.gGF) {
                    i2 = 3;
                }
                if (ae.gKu.gEf >= 0) {
                    i2 = ae.gKu.gEf;
                }
                Log.d("MicroMsg.IPCallAudioManager", "IPCall doShiftSpeaker usePhoneMode:".concat(String.valueOf(i2)));
                a.C0831a aVar6 = com.tencent.mm.plugin.audio.c.a.oIh;
                if (i2 != a.C0831a.getMode()) {
                    a.C0831a aVar7 = com.tencent.mm.plugin.audio.c.a.oIh;
                    a.C0831a.cea().b(i2, (kotlin.g.a.a<x>) null);
                }
                super.cV(z);
            }
            AppMethodBeat.o(223954);
            return z;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/audio/mgr/BaseIPCallAudioManager$Companion;", "", "()V", "TAG", "", "plugin-audio_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
