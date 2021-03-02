package com.tencent.mm.plugin.priority.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.priority.PluginPriority;
import com.tencent.mm.plugin.priority.a.a.a.a;
import com.tencent.mm.pluginsdk.i.f;
import com.tencent.mm.protocal.protobuf.xi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.util.c;
import com.tencent.tav.coremedia.TimeUtil;

public final class b extends a {
    private ca dTX;

    public b(ca caVar) {
        this.dTX = caVar;
    }

    @Override // com.tencent.mm.plugin.priority.model.b.a
    public final String getName() {
        return "Priority.onC2CImgReceiveTask";
    }

    public final void run() {
        double[] jr;
        boolean z;
        int i2;
        boolean z2;
        int js;
        int js2;
        AppMethodBeat.i(87866);
        if (this.dTX.field_createTime <= ((PluginPriority) g.ah(PluginPriority.class)).getInstallPriorityTime()) {
            Log.i("MicroMsg.Priority.C2CImgReceiveTask", "onC2CImgReceive time condition not support %s", f.formatTime(TimeUtil.YYYY2MM2DD_HH1MM1SS, this.dTX.field_createTime / 1000));
            AppMethodBeat.o(87866);
        } else if (((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgStorage().HL(this.dTX.field_msgId)) {
            Log.i("MicroMsg.Priority.C2CImgReceiveTask", "img already exist msg %d", Long.valueOf(this.dTX.field_msgId));
            AppMethodBeat.o(87866);
        } else {
            if (ab.Eq(this.dTX.field_talker)) {
                jr = ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jr(this.dTX.field_talker, "@all");
            } else {
                jr = ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().jr(this.dTX.field_talker, this.dTX.field_talker);
            }
            double max = Math.max(Math.max(jr[0], jr[1]), jr[2]);
            boolean z3 = true;
            int i3 = 0;
            bp.b Ky = bp.Ky(this.dTX.fqK);
            if (Ky == null) {
                z = false;
            } else {
                String str = Ky.iED;
                if (Util.isNullOrNil(str) || !com.tencent.mm.modelcontrol.b.Of(str)) {
                    z = true;
                } else {
                    z = false;
                }
            }
            if (!z) {
                i3 = 4;
                z3 = false;
            }
            if (!a.eCS()) {
                i3 |= 2;
                z3 = false;
            }
            if (!a.eCT()) {
                i3 |= 16;
                z3 = false;
            }
            if (a.aKb(this.dTX.field_talker)) {
                i2 = i3 | 8;
            } else {
                i2 = i3;
            }
            b.a aVar = b.a.clicfg_mmc2c_chat_img_auto_download_flag;
            c cVar = c.QYz;
            if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(aVar, c.hde())) {
                ((PluginPriority) g.ah(PluginPriority.class)).getC2CChatUsageLogic();
                String str2 = this.dTX.field_talker;
                xi aKg = ((PluginPriority) g.ah(PluginPriority.class)).getC2CChatUsageResultStorage().aKg(str2);
                int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmc2c_chat_img_auto_download_rank, 10);
                float a3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_mmc2c_chat_img_auto_download_score, 10.0f);
                Log.i("MicroMsg.Priority.C2CChatUsageLogic", "getAutoDownloadImgFlag %s %s %.2f", str2, Integer.valueOf(a2), Float.valueOf(a3));
                if (aKg == null || aKg.xNc > a2 || aKg.LiL <= ((double) a3)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                if (z2) {
                    if (z3) {
                        int i4 = i2 | 1;
                        Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", Double.valueOf(max), 1, Integer.valueOf(i4), Long.valueOf(this.dTX.field_msgId));
                        a(this.dTX, i4, max);
                        ((PluginPriority) g.ah(PluginPriority.class)).getC2CImgAutoDownloader().start();
                        AppMethodBeat.o(87866);
                        return;
                    }
                    Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", Double.valueOf(max), 1, Integer.valueOf(i2), Long.valueOf(this.dTX.field_msgId));
                    a(this.dTX, i2, max);
                    AppMethodBeat.o(87866);
                } else if (!z3 || ab.Eq(this.dTX.field_talker) || (js = ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().js(this.dTX.field_talker, this.dTX.field_talker)) >= 2) {
                    Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", Double.valueOf(max), 1, Integer.valueOf(i2), Long.valueOf(this.dTX.field_msgId));
                    a(this.dTX, i2 | 512, max);
                    AppMethodBeat.o(87866);
                } else {
                    int i5 = i2 | 128;
                    Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", Double.valueOf(max), 1, Integer.valueOf(i5), Long.valueOf(this.dTX.field_msgId), Integer.valueOf(js));
                    a(this.dTX, i5, max);
                    ((PluginPriority) g.ah(PluginPriority.class)).getC2CImgAutoDownloader().start();
                    AppMethodBeat.o(87866);
                }
            } else if (max >= ((double) ((PluginPriority) g.ah(PluginPriority.class)).getImgBorderPriority())) {
                if (z3) {
                    int i6 = i2 | 1;
                    Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d", Double.valueOf(max), 1, Integer.valueOf(i6), Long.valueOf(this.dTX.field_msgId));
                    a(this.dTX, i6, max);
                    ((PluginPriority) g.ah(PluginPriority.class)).getC2CImgAutoDownloader().start();
                    AppMethodBeat.o(87866);
                    return;
                }
                Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", Double.valueOf(max), 1, Integer.valueOf(i2), Long.valueOf(this.dTX.field_msgId));
                a(this.dTX, i2, max);
                AppMethodBeat.o(87866);
            } else if (!z3 || ab.Eq(this.dTX.field_talker) || (js2 = ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgImgUsageStorage().js(this.dTX.field_talker, this.dTX.field_talker)) >= 2) {
                Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Not To Auto Download %d MsgId %d", Double.valueOf(max), 1, Integer.valueOf(i2), Long.valueOf(this.dTX.field_msgId));
                a(this.dTX, i2 | 64, max);
                AppMethodBeat.o(87866);
            } else {
                int i7 = i2 | 128;
                Log.i("MicroMsg.Priority.C2CImgReceiveTask", "C2CImgReceiveTask Click Rate %.2f %d Start To Auto Download %d MsgId %d receiveCount %d", Double.valueOf(max), 1, Integer.valueOf(i7), Long.valueOf(this.dTX.field_msgId), Integer.valueOf(js2));
                a(this.dTX, i7, max);
                ((PluginPriority) g.ah(PluginPriority.class)).getC2CImgAutoDownloader().start();
                AppMethodBeat.o(87866);
            }
        }
    }

    private static void a(ca caVar, int i2, double d2) {
        AppMethodBeat.i(87867);
        if (((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic() != null) {
            ((PluginPriority) g.ah(PluginPriority.class)).getC2CMsgAutoDownloadImgLogic();
            com.tencent.mm.plugin.priority.model.a.c.b.a(caVar, i2, d2);
        }
        AppMethodBeat.o(87867);
    }
}
