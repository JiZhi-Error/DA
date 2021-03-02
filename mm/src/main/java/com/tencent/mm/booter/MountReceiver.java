package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.StatFs;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.k;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.y;
import java.io.File;
import java.io.IOException;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
@k
public class MountReceiver extends BroadcastReceiver {
    private String action = "";
    private Context context = null;
    private MMHandler gly = new MMHandler(Looper.getMainLooper()) {
        /* class com.tencent.mm.booter.MountReceiver.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MMHandler
        public final void handleMessage(Message message) {
            boolean z = true;
            AppMethodBeat.i(19879);
            Object[] objArr = new Object[4];
            objArr[0] = MountReceiver.this.action;
            objArr[1] = Boolean.valueOf(bg.aAc());
            if (MountReceiver.this.context != null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = Boolean.valueOf(e.apo());
            Log.d("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b ContextNull:%b SdcardFull:%b", objArr);
            if (MountReceiver.this.context == null) {
                AppMethodBeat.o(19879);
            } else if (!e.apo()) {
                AppMethodBeat.o(19879);
            } else {
                u.kg(MountReceiver.this.context);
                AppMethodBeat.o(19879);
            }
        }
    };

    public MountReceiver() {
        AppMethodBeat.i(19882);
        AppMethodBeat.o(19882);
    }

    public void onReceive(Context context2, Intent intent) {
        String str;
        AppMethodBeat.i(19883);
        if (context2 == null || intent == null || Util.isNullOrNil(intent.getAction())) {
            AppMethodBeat.o(19883);
            return;
        }
        this.context = context2;
        this.action = intent.getAction();
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory != null) {
            str = externalStorageDirectory.getAbsolutePath();
        } else {
            try {
                str = new File("/sdcard/").getCanonicalPath();
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.MountReceiver", e2, "Fail to resolve canonical path for sdcard root.", new Object[0]);
                str = "/sdcard/";
            }
        }
        Log.i("MicroMsg.MountReceiver", "dkmount action:%s hasuin:%b SDCARD_ROOT[%s] primaryExtStg[%s]", this.action, Boolean.valueOf(bg.aAc()), b.aKD(), str);
        boolean equals = this.action.equals("android.intent.action.MEDIA_MOUNTED");
        if (equals || this.action.equals("android.intent.action.MEDIA_EJECT") || this.action.equals("android.intent.action.MEDIA_SHARED")) {
            boolean z = !b.aKD().equalsIgnoreCase("/dev/null");
            if (z) {
                try {
                    StatFs statFs = new StatFs(b.aKD());
                    Log.i("MicroMsg.MountReceiver", "CheckSD path[%s] blocksize:%d blockcount:%d availcount:%d", b.aKD(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()));
                } catch (Exception e3) {
                    Log.e("MicroMsg.MountReceiver", "CheckSD failed :%s", e3.getMessage());
                    z = false;
                }
            }
            Uri data = intent.getData();
            if (data != null) {
                String path = data.getPath();
                if (!b.aKD().equalsIgnoreCase(path)) {
                    if (!equals || z) {
                        AppMethodBeat.o(19883);
                        return;
                    }
                    h.INSTANCE.idkeyStat(340, b.aKD().equalsIgnoreCase("/dev/null") ? 9 : 12, 1, false);
                    if (Util.isNullOrNil(str) || !str.equalsIgnoreCase(path)) {
                        AppMethodBeat.o(19883);
                        return;
                    } else if (!new o(ar.NSe + "SdcardInfo.cfg").exists()) {
                        Log.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%s] to new [%s], ver[%d]", b.aKD(), str, Integer.valueOf(Build.VERSION.SDK_INT));
                        b.A(str, false);
                    } else {
                        an anVar = new an(ar.NSe + "SdcardInfo.cfg");
                        int intValue = ((Integer) anVar.get(2, 0)).intValue();
                        int i2 = Build.VERSION.SDK_INT;
                        String aKD = b.aKD();
                        anVar.set(1, str);
                        anVar.set(2, Integer.valueOf(i2));
                        b.A(str, false);
                        Log.w("MicroMsg.MountReceiver", "summermount init sdcard root old [%d, %s] to new [%d, %s], [%s] to [%s]", Integer.valueOf(intValue), (String) anVar.get(1, ""), Integer.valueOf(i2), str, aKD, b.aKD());
                    }
                }
            } else {
                h.INSTANCE.idkeyStat(340, equals ? 13 : 14, 1, false);
            }
            y.heX();
            if (equals) {
                bg.aAk().postToWorker(new Runnable() {
                    /* class com.tencent.mm.booter.MountReceiver.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(19880);
                        Log.d("MicroMsg.MountReceiver", "dkmount [MOUNT] action:%s hasuin:%b", MountReceiver.this.action, Boolean.valueOf(bg.aAc()));
                        if (!bg.aAc()) {
                            AppMethodBeat.o(19880);
                            return;
                        }
                        g.aAh().azT();
                        bg.aVF();
                        c.azS();
                        MountReceiver.this.gly.sendEmptyMessage(0);
                        AppMethodBeat.o(19880);
                    }
                });
                AppMethodBeat.o(19883);
                return;
            }
            u.g(context2, null);
            bg.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.booter.MountReceiver.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(19881);
                    Log.d("MicroMsg.MountReceiver", "dkmount [EJECT] action:%s hasuin:%b", MountReceiver.this.action, Boolean.valueOf(bg.aAc()));
                    if (!bg.aAc()) {
                        AppMethodBeat.o(19881);
                        return;
                    }
                    g.aAh().azT();
                    bg.aVF();
                    c.azS();
                    AppMethodBeat.o(19881);
                }
            });
            AppMethodBeat.o(19883);
            return;
        }
        AppMethodBeat.o(19883);
    }
}
