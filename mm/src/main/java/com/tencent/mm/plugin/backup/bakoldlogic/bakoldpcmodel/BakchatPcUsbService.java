package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.bakoldlogic.c.f;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.MMService;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BakchatPcUsbService extends MMService implements i {
    private boolean oOM = false;

    @Override // com.tencent.mm.service.MMService
    public final IBinder akL() {
        return null;
    }

    @Override // com.tencent.mm.service.MMService
    public final void onCreate() {
        AppMethodBeat.i(21914);
        Log.i("MicroMsg.BakchatPcUsbService", "onCreate()");
        super.onCreate();
        bg.azz().a(595, this);
        b.a(1, this);
        AppMethodBeat.o(21914);
    }

    @Override // com.tencent.mm.service.MMService
    public final int onStartCommand(Intent intent, int i2, int i3) {
        int i4 = 1;
        AppMethodBeat.i(21915);
        Log.i("MicroMsg.BakchatPcUsbService", "onStartCommand()");
        if (intent == null) {
            Log.w("MicroMsg.BakchatPcUsbService", "onStartCommand intent is null");
            AppMethodBeat.o(21915);
        } else {
            String stringExtra = intent.getStringExtra("url");
            if (Util.isNullOrNil(stringExtra)) {
                Log.e("MicroMsg.BakchatPcUsbService", "onStartCommand url is null");
                stopSelf();
                AppMethodBeat.o(21915);
            } else {
                this.oOM = intent.getBooleanExtra("isFromWifi", false);
                Log.i("MicroMsg.BakchatPcUsbService", "Broadcast url:%s, isFromWifi:%b", stringExtra, Boolean.valueOf(this.oOM));
                a.cgZ().chb().aWm();
                c chb = a.cgZ().chb();
                if (this.oOM) {
                    i4 = 2;
                }
                chb.oRr = i4;
                if (!bg.aVG()) {
                    Log.e("MicroMsg.BakchatPcUsbService", "onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    a bl = new a().bl(className);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(21915);
                } else {
                    bg.azz().a(new f(stringExtra), 0);
                    AppMethodBeat.o(21915);
                }
            }
        }
        return 2;
    }

    @Override // com.tencent.mm.service.MMService
    public final void onDestroy() {
        AppMethodBeat.i(21916);
        bg.azz().b(595, this);
        b.b(1, this);
        super.onDestroy();
        Log.i("MicroMsg.BakchatPcUsbService", "onDestroy" + Thread.currentThread().getName());
        AppMethodBeat.o(21916);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(21917);
        if (qVar instanceof b) {
            if (qVar.getType() == 1 && i2 == 0 && i3 == 0) {
                Intent className = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                a bl = new a().bl(className);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/BakchatPcUsbService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            stopSelf();
            AppMethodBeat.o(21917);
            return;
        }
        if (qVar instanceof f) {
            if (i2 == 0 && i3 == 0) {
                blq chs = ((f) qVar).chs();
                if (this.oOM) {
                    Log.i("MicroMsg.BakchatPcUsbService", "from wifi, reconnect");
                    a.cgZ().chc().chd();
                }
                if (this.oOM || chs.oUv != 1) {
                    a.cgZ().oIU = chs.ID;
                    a.cgZ().oIV = chs.KML;
                    a.cgZ().oIW = chs.KMM;
                    a.cgZ().cha().eR(chs.KME, chs.KMF);
                    b.a(a.cgZ().cha());
                    b.a(a.cgZ().chc());
                    b.Bb(1);
                    a.cgZ().chc().f(chs.oUv, chs.KMD);
                    AppMethodBeat.o(21917);
                    return;
                }
                Log.e("MicroMsg.BakchatPcUsbService", "broast from usb but type is wifi, url may be fake!!!!");
                stopSelf();
                AppMethodBeat.o(21917);
                return;
            }
            a.cgZ().chb().oRs = 2;
            a.cgZ().chb().aWm();
            if (i2 == 4 && i3 == -2011) {
                Log.i("MicroMsg.BakchatPcUsbService", "getConnect info: INVALID URL");
                if (this.oOM) {
                }
            } else {
                Log.i("MicroMsg.BakchatPcUsbService", "getConnect info other error");
            }
            a.cgZ().cha();
            e.chj();
            stopSelf();
        }
        AppMethodBeat.o(21917);
    }

    @Override // com.tencent.mm.service.MMService
    public final String getTag() {
        return "MicroMsg.BakchatPcUsbService";
    }
}
