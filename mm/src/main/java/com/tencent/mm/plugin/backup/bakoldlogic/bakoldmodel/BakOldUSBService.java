package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.Intent;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.c;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.c.f;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.protocal.protobuf.blq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.MMService;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BakOldUSBService extends MMService implements i {
    private boolean oOM = false;
    private int oRb = -1;

    @Override // com.tencent.mm.service.MMService
    public final IBinder akL() {
        AppMethodBeat.i(21812);
        Log.i("MicroMsg.BakOldUSBService", "onBind()");
        AppMethodBeat.o(21812);
        return null;
    }

    @Override // com.tencent.mm.service.MMService
    public final void onCreate() {
        AppMethodBeat.i(21813);
        Log.i("MicroMsg.BakOldUSBService", "onCreate()");
        super.onCreate();
        bg.azz().a(595, this);
        b.a(1, this);
        AppMethodBeat.o(21813);
    }

    @Override // com.tencent.mm.service.MMService
    public final int onStartCommand(Intent intent, int i2, int i3) {
        int i4 = 1;
        AppMethodBeat.i(21814);
        Log.i("MicroMsg.BakOldUSBService", "onStartCommand() scene：%d", Integer.valueOf(this.oRb));
        if (intent == null) {
            Log.w("MicroMsg.BakOldUSBService", "onStartCommand intent is null");
            AppMethodBeat.o(21814);
        } else {
            String stringExtra = intent.getStringExtra("url");
            if (Util.isNullOrNil(stringExtra)) {
                Log.e("MicroMsg.BakOldUSBService", "onStartCommand url is null");
                stopSelf();
                AppMethodBeat.o(21814);
            } else {
                this.oOM = intent.getBooleanExtra("isFromWifi", false);
                Log.i("MicroMsg.BakOldUSBService", "Broadcast url:%s, isFromWifi:%b", stringExtra, Boolean.valueOf(this.oOM));
                a.cgZ().chb().aWm();
                c chb = a.cgZ().chb();
                if (this.oOM) {
                    i4 = 2;
                }
                chb.oRr = i4;
                if (!bg.aVG()) {
                    Log.e("MicroMsg.BakOldUSBService", "onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(className);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(21814);
                } else {
                    bg.azz().a(new f(stringExtra), 0);
                    AppMethodBeat.o(21814);
                }
            }
        }
        return 2;
    }

    @Override // com.tencent.mm.service.MMService
    public final void onDestroy() {
        AppMethodBeat.i(21815);
        bg.azz().b(595, this);
        b.b(1, this);
        super.onDestroy();
        Log.i("MicroMsg.BakOldUSBService", "onDestroy thread:" + Thread.currentThread().getName());
        AppMethodBeat.o(21815);
    }

    private boolean cgX() {
        return this.oRb == 0 || this.oRb == 1;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        AppMethodBeat.i(21816);
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i2);
        objArr[1] = Integer.valueOf(i3);
        objArr[2] = str;
        objArr[3] = qVar == null ? "" : qVar.getClass().getSimpleName();
        objArr[4] = Integer.valueOf(this.oRb);
        Log.i("MicroMsg.BakOldUSBService", "summerbak onSceneEnd [%d, %d, %s] [%s] backupScene[%d]", objArr);
        if (qVar instanceof b) {
            Log.d("MicroMsg.BakOldUSBService", "summerback BackupBaseScene type[%d], backupScene[%d]", Integer.valueOf(qVar.getType()), Integer.valueOf(this.oRb));
            if (qVar.getType() == 1 && i2 == 0 && i3 == 0) {
                Intent className = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
                className.addFlags(335544320);
                className.putExtra("nofification_type", "back_to_pcmgr_notification");
                if (!cgX()) {
                    z = true;
                } else {
                    z = false;
                }
                className.putExtra("newPCBackup", z);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(className);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldmodel/BakOldUSBService", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            stopSelf();
            AppMethodBeat.o(21816);
            return;
        }
        if (qVar instanceof f) {
            if (i2 == 0 && i3 == 0) {
                blq chs = ((f) qVar).chs();
                a.cgZ().oIU = chs.ID;
                a.cgZ().oIV = chs.KML;
                a.cgZ().oIW = chs.KMM;
                this.oRb = chs.Scene;
                Log.d("MicroMsg.BakOldUSBService", "summerbak getconnetinfo type: %d, scene: %d isFromWifi:%b", Integer.valueOf(chs.oUv), Integer.valueOf(chs.Scene), Boolean.valueOf(this.oOM));
                if (!this.oOM && chs.oUv == 1) {
                    Log.e("MicroMsg.BakOldUSBService", "broast from usb but type is wifi, url may be fake!!!!");
                    stopSelf();
                    AppMethodBeat.o(21816);
                    return;
                } else if (cgX()) {
                    a.cgZ().cha().eR(chs.KME, chs.KMF);
                    b.a(a.cgZ().cha());
                    b.a(a.cgZ().chc());
                    b.Bb(1);
                    a.cgZ().chc().f(chs.oUv, chs.KMD);
                    AppMethodBeat.o(21816);
                    return;
                } else {
                    Log.d("MicroMsg.BakOldUSBService", "summerbak onSceneEnd need todo for new scene:% ", Integer.valueOf(this.oRb));
                    AppMethodBeat.o(21816);
                    return;
                }
            } else {
                a.cgZ().chb().oRs = 2;
                a.cgZ().chb().aWm();
                if (i2 == 4 && i3 == -2011) {
                    Log.i("MicroMsg.BakOldUSBService", "getConnect info: INVALID URL");
                } else {
                    Log.i("MicroMsg.BakOldUSBService", "getConnect info other error");
                }
                a.cgZ().cha();
                e.chj();
                stopSelf();
            }
        }
        AppMethodBeat.o(21816);
    }

    @Override // com.tencent.mm.service.MMService
    public final String getTag() {
        return "MicroMsg.BakOldUSBService";
    }
}
