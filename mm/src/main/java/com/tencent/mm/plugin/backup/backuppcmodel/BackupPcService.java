package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.backup.b.d;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.plugin.backup.g.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.service.MMService;
import com.tencent.mm.storage.ar;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140422", reviewer = 20, vComment = {EType.SERVICESCHECK})
public class BackupPcService extends MMService {
    private boolean mbo = false;
    private boolean oOM = false;

    @Override // com.tencent.mm.service.MMService
    public final void onCreate() {
        AppMethodBeat.i(21623);
        Log.i("MicroMsg.BackupPcService", "onCreate.");
        super.onCreate();
        AppMethodBeat.o(21623);
    }

    @Override // com.tencent.mm.service.MMService
    public final int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(21624);
        Log.i("MicroMsg.BackupPcService", "onStartCommand.");
        if (intent == null) {
            Log.w("MicroMsg.BackupPcService", "onStartCommand intent is null");
            AppMethodBeat.o(21624);
        } else {
            final String stringExtra = intent.getStringExtra("url");
            if (Util.isNullOrNil(stringExtra)) {
                Log.e("MicroMsg.BackupPcService", "onStartCommand url is null");
                stopSelf();
                AppMethodBeat.o(21624);
            } else if (stringExtra.contains("mm.gj.qq.com")) {
                Log.i("MicroMsg.BackupPcService", "onStartCommand url from gj stop and start BakOldUSBService");
                c.startService(new Intent(MMApplicationContext.getContext(), BakOldUSBService.class).putExtra("url", intent.getStringExtra("url")).putExtra("isFromWifi", true));
                stopSelf();
                AppMethodBeat.o(21624);
            } else {
                this.oOM = intent.getBooleanExtra("isFromWifi", false);
                this.mbo = intent.getBooleanExtra("isMove", false);
                Log.i("MicroMsg.BackupPcService", "onStartCommand Broadcast url:%s, isFromWifi:%b, isMove:%b", stringExtra, Boolean.valueOf(this.oOM), Boolean.valueOf(this.mbo));
                if (this.mbo || bg.aVG()) {
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.backup.backuppcmodel.BackupPcService.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(21622);
                            c cgb = b.cga().cgb();
                            String str = stringExtra;
                            Log.w("MicroMsg.BackupPcProcessMgr", "~~~~~~~~~~~~  start by url:%s", str);
                            d.Bb(1);
                            b.cgx();
                            bg.aVF();
                            cgb.oOq = ((Integer) com.tencent.mm.model.c.azQ().get(ar.a.USERINFO_LOGIN_EXT_DEVICE_INFO_INT, (Object) 0)).intValue();
                            b.cga();
                            SharedPreferences.Editor edit = b.ceR().edit();
                            edit.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
                            edit.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
                            edit.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0);
                            edit.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0);
                            edit.commit();
                            cgb.oOr = true;
                            bg.azz().a(595, cgb.oLS);
                            bg.azz().a(new e(str), 0);
                            AppMethodBeat.o(21622);
                        }
                    });
                    AppMethodBeat.o(21624);
                } else {
                    Log.e("MicroMsg.BackupPcService", "onStartCommand onStartCommand not in Login state");
                    Intent className = new Intent().setClassName(MMApplicationContext.getContext(), "com.tencent.mm.ui.LauncherUI");
                    className.addFlags(335544320);
                    className.putExtra("nofification_type", "back_to_pcmgr_notification");
                    a bl = new a().bl(className);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/backuppcmodel/BackupPcService", "onStartCommand", "(Landroid/content/Intent;II)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    AppMethodBeat.o(21624);
                }
            }
        }
        return 2;
    }

    @Override // com.tencent.mm.service.MMService
    public final IBinder akL() {
        return null;
    }

    @Override // com.tencent.mm.service.MMService
    public final void onDestroy() {
        AppMethodBeat.i(21625);
        super.onDestroy();
        Log.i("MicroMsg.BackupPcService", "onDestroy thread:" + Thread.currentThread().getName());
        AppMethodBeat.o(21625);
    }

    @Override // com.tencent.mm.service.MMService
    public final String getTag() {
        return "MicroMsg.BackupPcService";
    }
}
