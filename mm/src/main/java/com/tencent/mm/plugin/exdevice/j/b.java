package com.tencent.mm.plugin.exdevice.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.c.c;
import com.tencent.mm.plugin.exdevice.c.h;
import com.tencent.mm.plugin.exdevice.i.a;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.Log;

public final class b extends a implements d {
    private final d rEB;

    public b(c cVar, d dVar) {
        super(cVar, dVar);
        AppMethodBeat.i(23797);
        a(this);
        this.rEB = dVar;
        AppMethodBeat.o(23797);
    }

    @Override // com.tencent.mm.plugin.exdevice.j.d
    public final void a(long j2, int i2, int i3, String str) {
        AppMethodBeat.i(23798);
        Log.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "onTaskSceneEnd, SwitchViewPush taskId = %d, errType = %d, errCode = %d, errMsg = %s", Long.valueOf(j2), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (2 == ((h) this.rEy).cKk()) {
            Log.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Switch view push has been sended to device, now try to check close strategy");
            com.tencent.mm.plugin.exdevice.i.b anI = ad.cKL().anI(new StringBuilder().append(this.rEy.pkb).toString());
            if (anI != null) {
                switch (anI.field_closeStrategy) {
                    case 1:
                        Log.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, stop channel(device id = %d)", Integer.valueOf(anI.field_closeStrategy), Long.valueOf(this.rEy.pkb));
                        if (u.cLy().rxT != null) {
                            u.cLy().rxT.De(this.rEy.pkb);
                            break;
                        }
                        break;
                    case 2:
                        Log.i("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "the close Strategy is %d, Record it(%d) in the shut down device list", Integer.valueOf(anI.field_closeStrategy), Long.valueOf(this.rEy.pkb));
                        if (!a.ad("shut_down_device", this.rEy.pkb)) {
                            Log.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "MMExDeviceCore.getDeviceInfoManager().addShutDownDevice failed!!!");
                            break;
                        }
                        break;
                    default:
                        Log.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "Error close strategy(%d)", Integer.valueOf(anI.field_closeStrategy));
                        break;
                }
            } else {
                Log.e("MicroMsg.exdevice.ExDeviceTaskSwitchViewPush", "get hdinfo by mac failed!!!, Mac = %d", Long.valueOf(this.rEy.pkb));
                if (this.rEB != null) {
                    this.rEB.a(j2, i2, i3, str);
                }
                AppMethodBeat.o(23798);
                return;
            }
        }
        if (this.rEB != null) {
            this.rEB.a(j2, i2, i3, str);
        }
        AppMethodBeat.o(23798);
    }
}
