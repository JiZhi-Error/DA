package com.tencent.mm.plugin.dbbackup;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ci;
import com.tencent.mm.plugin.dbbackup.d;
import com.tencent.mm.plugin.zero.b.b;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDebug;
import com.tencent.wcdb.repair.DBDumpUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public final class c implements a {
    private d qCX;
    private MMHandler qCY = null;

    c(d dVar) {
        this.qCX = dVar;
    }

    private boolean eU(final Context context) {
        AppMethodBeat.i(23047);
        if (g.aAh().azL() == null) {
            h.n(context, R.string.fx_, R.string.zb);
            AppMethodBeat.o(23047);
        } else {
            context.getString(R.string.zb);
            final q a2 = h.a(context, context.getString(R.string.fx9), false, (DialogInterface.OnCancelListener) null);
            final ci glA = ((b) g.af(b.class)).glA();
            glA.aWr();
            d dVar = this.qCX;
            AnonymousClass1 r3 = new b() {
                /* class com.tencent.mm.plugin.dbbackup.c.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.dbbackup.b
                public final void Fk(final int i2) {
                    AppMethodBeat.i(23037);
                    glA.aWs();
                    MMHandlerThread.postToMainThread(new Runnable() {
                        /* class com.tencent.mm.plugin.dbbackup.c.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            int i2;
                            AppMethodBeat.i(23036);
                            if (a2 != null) {
                                a2.dismiss();
                            }
                            switch (i2) {
                                case -3:
                                    i2 = R.string.fx_;
                                    break;
                                case -2:
                                    i2 = R.string.fxa;
                                    break;
                                case -1:
                                default:
                                    i2 = R.string.fx8;
                                    break;
                                case 0:
                                    i2 = R.string.fxb;
                                    break;
                            }
                            h.n(context, i2, R.string.zb);
                            AppMethodBeat.o(23036);
                        }
                    });
                    AppMethodBeat.o(23037);
                }
            };
            o oVar = new o(MMApplicationContext.getContext().getFilesDir(), "DBRecoverStarted");
            WakerLock wakerLock = new WakerLock(MMApplicationContext.getContext(), "MicroMsg.SubCoreDBBackup");
            d.AnonymousClass5 r9 = new b(oVar, r3, wakerLock) {
                /* class com.tencent.mm.plugin.dbbackup.d.AnonymousClass5 */
                final /* synthetic */ b qDQ;
                int qEk = 0;
                final /* synthetic */ o qEl;
                final /* synthetic */ WakerLock qEm;

                {
                    this.qEl = r3;
                    this.qDQ = r4;
                    this.qEm = r5;
                }

                @Override // com.tencent.mm.plugin.dbbackup.b
                public final void Fk(int i2) {
                    int i3;
                    AppMethodBeat.i(23083);
                    do {
                        if (this.qEk > 0) {
                            Log.i("MicroMsg.SubCoreDBBackup", "Recovery stage %d result: %d", Integer.valueOf(this.qEk), Integer.valueOf(i2));
                        }
                        if (i2 == 0) {
                            this.qEl.delete();
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(181, 29, 1, true);
                            if (this.qDQ != null) {
                                this.qDQ.Fk(i2);
                            }
                            this.qEm.unLock();
                            AppMethodBeat.o(23083);
                            return;
                        } else if (i2 == -2) {
                            this.qEl.delete();
                            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(181, 3, 1, true);
                            if (this.qDQ != null) {
                                this.qDQ.Fk(i2);
                            }
                            this.qEm.unLock();
                            AppMethodBeat.o(23083);
                            return;
                        } else {
                            int i4 = this.qEk + 1;
                            this.qEk = i4;
                            switch (i4) {
                                case 1:
                                    Log.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: REPAIR", Integer.valueOf(this.qEk));
                                    i2 = d.this.b((String) null, this);
                                    continue;
                                case 2:
                                    Log.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: BACKUP RECOVER", Integer.valueOf(this.qEk));
                                    i2 = d.this.a((String) null, this);
                                    continue;
                                case 3:
                                    Log.i("MicroMsg.SubCoreDBBackup", "Database recovery stage %d: DUMP", Integer.valueOf(this.qEk));
                                    d dVar = d.this;
                                    bg.aVF();
                                    String azL = c.azL();
                                    if (azL == null || azL.isEmpty()) {
                                        i3 = -3;
                                    } else {
                                        o oVar = new o(azL);
                                        if (!oVar.canRead()) {
                                            i3 = -3;
                                        } else {
                                            StringBuilder append = new StringBuilder().append(com.tencent.mm.compatible.deviceinfo.q.dr(true));
                                            bg.aVF();
                                            String substring = com.tencent.mm.b.g.getMessageDigest(append.append(c.getUin()).toString().getBytes()).substring(0, 7);
                                            long length = oVar.length() * 2;
                                            long dataAvailableSize = Util.getDataAvailableSize();
                                            Log.i("MicroMsg.SubCoreDBBackup", "db recover needSize : %d blockSize:%d", Long.valueOf(length), Long.valueOf(dataAvailableSize));
                                            if (dataAvailableSize < length) {
                                                i3 = -2;
                                            } else {
                                                bg.aAk().setHighPriority();
                                                bg.aAk().postAtFrontOfQueueToWorker(new Runnable(oVar, substring, this) {
                                                    /* class com.tencent.mm.plugin.dbbackup.d.AnonymousClass4 */
                                                    final /* synthetic */ b qDQ;
                                                    final /* synthetic */ o qEh;
                                                    final /* synthetic */ String val$key;

                                                    {
                                                        this.qEh = r2;
                                                        this.val$key = r3;
                                                        this.qDQ = r4;
                                                    }

                                                    public final void run() {
                                                        int i2;
                                                        AppMethodBeat.i(23082);
                                                        try {
                                                            Thread.sleep(200);
                                                        } catch (InterruptedException e2) {
                                                        }
                                                        bg.aVF();
                                                        String azM = c.azM();
                                                        String str = azM + this.qEh.getName().replace(".db", "temp.db");
                                                        Log.i("MicroMsg.SubCoreDBBackup", "temp db path is %s", str);
                                                        this.qEh.am(new o(str));
                                                        List<String> asList = Arrays.asList("getcontactinfo", "contact", "contact_ext", "ContactCmdBuf", "rcontact", "img_flag", "userinfo");
                                                        final int[] iArr = new int[1];
                                                        long currentTimeMillis = System.currentTimeMillis();
                                                        bg.aVF();
                                                        boolean a2 = c.getDataDB().a(str, this.val$key, azM + "sqlTemp.sql", asList, new DBDumpUtil.ExecuteSqlCallback() {
                                                            /* class com.tencent.mm.plugin.dbbackup.d.AnonymousClass4.AnonymousClass1 */

                                                            @Override // com.tencent.wcdb.repair.DBDumpUtil.ExecuteSqlCallback
                                                            public final String preExecute(String str) {
                                                                int[] iArr = iArr;
                                                                iArr[0] = iArr[0] + 1;
                                                                return null;
                                                            }
                                                        });
                                                        if (a2) {
                                                            bg.aVF();
                                                            c.aSQ().eiH();
                                                            bg.aVF();
                                                            c.aST().gCu();
                                                            bg.aVF();
                                                            c.aSQ().eiJ();
                                                            bg.aVF();
                                                            c.aSQ().eiI();
                                                            i2 = 12;
                                                        } else {
                                                            i2 = 15;
                                                        }
                                                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(181, (long) i2, 1, true);
                                                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                                        Log.i("MicroMsg.SubCoreDBBackup", "execute %d sql and last %d", Integer.valueOf(iArr[0]), Long.valueOf(currentTimeMillis2));
                                                        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                                                        Object[] objArr = new Object[3];
                                                        objArr[0] = Integer.valueOf(a2 ? 1 : 0);
                                                        objArr[1] = iArr;
                                                        objArr[2] = Long.valueOf(currentTimeMillis2);
                                                        hVar.a(11224, objArr);
                                                        bg.aAk().setLowPriority();
                                                        if (this.qDQ != null) {
                                                            this.qDQ.Fk(a2 ? 0 : -1);
                                                        }
                                                        AppMethodBeat.o(23082);
                                                    }
                                                });
                                                i3 = 0;
                                            }
                                        }
                                    }
                                    i2 = i3;
                                    continue;
                                default:
                                    this.qEl.delete();
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(181, 30, 1, true);
                                    if (this.qDQ != null) {
                                        this.qDQ.Fk(i2);
                                    }
                                    this.qEm.unLock();
                                    AppMethodBeat.o(23083);
                                    return;
                            }
                        }
                    } while (i2 != 0);
                    AppMethodBeat.o(23083);
                }
            };
            Log.i("MicroMsg.SubCoreDBBackup", "Database recover started.");
            wakerLock.lock();
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(181, 28, 1, true);
            try {
                oVar.createNewFile();
            } catch (IOException e2) {
            }
            r9.Fk(-1);
            AppMethodBeat.o(23047);
        }
        return true;
    }

    private boolean b(final Context context, String[] strArr) {
        char c2 = 65535;
        AppMethodBeat.i(23048);
        String str = g.aAh().cachePath;
        final String str2 = str + "ctest/";
        final String str3 = str + "EnMicroMsg.db";
        final String str4 = str2 + "EnMicroMsg.db";
        final String[] strArr2 = {"", "-journal", "-wal", ".sm", ".bak"};
        if (strArr.length > 1) {
            String str5 = strArr[1];
            switch (str5.hashCode()) {
                case -778987502:
                    if (str5.equals("clear-test")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3095028:
                    if (str5.equals("dump")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 1220142353:
                    if (str5.equals("make-test")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 1933703003:
                    if (str5.equals("recover-test")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    final String azL = g.aAh().azL();
                    if (azL == null) {
                        h.c(context, "没有找到损坏信息", "", true);
                        AppMethodBeat.o(23048);
                        return true;
                    }
                    final q a2 = h.a(context, "正在获取损坏信息", false, (DialogInterface.OnCancelListener) null);
                    ThreadPool.post(new Runnable() {
                        /* class com.tencent.mm.plugin.dbbackup.c.AnonymousClass5 */

                        public final void run() {
                            AppMethodBeat.i(231684);
                            s.boN(com.tencent.mm.loader.j.b.aKF() + "/MicroMsg");
                            s.nz(s.boZ(azL), com.tencent.mm.loader.j.b.aKF() + "/MicroMsg/corrupted.zip");
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.dbbackup.c.AnonymousClass5.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(231683);
                                    if (a2 != null) {
                                        a2.dismiss();
                                    }
                                    h.c(context, "损坏信息已保存", "", true);
                                    AppMethodBeat.o(231683);
                                }
                            });
                            AppMethodBeat.o(231684);
                        }
                    }, "DBCommand");
                    AppMethodBeat.o(23048);
                    return true;
                case 1:
                    if (s.YS(str2)) {
                        Toast.makeText(context, "Corruption test database exists.\nClear or recover before creating a new one.", 1).show();
                        AppMethodBeat.o(23048);
                        return true;
                    }
                    bg.aVF();
                    com.tencent.mm.model.c.getDataDB().gFH().close();
                    s.boN(str2);
                    for (int i2 = 0; i2 < 5; i2++) {
                        String str6 = strArr2[i2];
                        s.nx(str3 + str6, str4 + str6);
                    }
                    d.eW(context);
                    AppMethodBeat.o(23048);
                    return true;
                case 2:
                    if (!s.YS(str2)) {
                        Toast.makeText(context, "Corruption test database not exist.", 0).show();
                        AppMethodBeat.o(23048);
                        return true;
                    }
                    h.a(context, "Do you really want to recover test database?\nYour current database WILL BE LOST.", (String) null, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.dbbackup.c.AnonymousClass6 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(23045);
                            bg.aVF();
                            com.tencent.mm.model.c.getDataDB().gFH().close();
                            String[] strArr = strArr2;
                            for (String str : strArr) {
                                s.deleteFile(str3 + str);
                                s.nx(str4 + str, str3 + str);
                            }
                            s.dy(str2, true);
                            d.eW(context);
                            AppMethodBeat.o(23045);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(23048);
                    return true;
                case 3:
                    if (!s.YS(str2)) {
                        Toast.makeText(context, "Corruption test database not exist.", 0).show();
                        AppMethodBeat.o(23048);
                        return true;
                    }
                    h.a(context, "Do you really want to clear test database?\nIt can't be recovered anymore.", (String) null, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.dbbackup.c.AnonymousClass7 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(231685);
                            s.dy(str2, true);
                            Toast.makeText(context, "Corruption test database cleared.", 0).show();
                            AppMethodBeat.o(231685);
                        }
                    }, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(23048);
                    return true;
                default:
                    AppMethodBeat.o(23048);
                    return false;
            }
        } else {
            StringBuilder sb = new StringBuilder(512);
            String azL2 = g.aAh().azL();
            sb.append("Corrupted DB: ");
            if (azL2 == null) {
                sb.append("not exist");
            } else {
                sb.append(azL2.contains("/ctest/") ? APMidasPayAPI.ENV_TEST : "exists");
                sb.append("\nCorrupted DB size: ").append(s.boW(azL2));
                sb.append("\nSaved master exists: ").append(s.YS(azL2 + ".sm"));
                sb.append("\nContent backup exists: ").append(s.YS(azL2 + ".bak"));
            }
            TextView textView = new TextView(context);
            textView.setText(sb);
            textView.setGravity(8388627);
            textView.setTextSize(1, 10.0f);
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            textView.setTextColor(context.getResources().getColor(R.color.FG_0));
            textView.setTypeface(Typeface.MONOSPACE);
            textView.setMovementMethod(new ScrollingMovementMethod());
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.hs);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            h.a(context, (String) null, textView, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(23048);
            return true;
        }
    }

    private static boolean eV(Context context) {
        String str;
        AppMethodBeat.i(23049);
        int lastErrorLine = SQLiteDebug.getLastErrorLine();
        ArrayList<SQLiteDebug.IOTraceStats> lastIOTraceStats = SQLiteDebug.getLastIOTraceStats();
        if (lastIOTraceStats == null || lastIOTraceStats.isEmpty()) {
            AppMethodBeat.o(23049);
        } else {
            SQLiteDebug.IOTraceStats iOTraceStats = lastIOTraceStats.get(0);
            String str2 = "";
            try {
                bg.aVF();
                str2 = com.tencent.mm.b.g.getMessageDigest((com.tencent.mm.compatible.deviceinfo.q.dr(true) + com.tencent.mm.model.c.getUin()).getBytes()).substring(0, 7);
            } catch (Exception e2) {
            }
            String format = String.format("DB corrupted (line: %d, hash: %s) => %s", Integer.valueOf(lastErrorLine), str2, iOTraceStats.toString());
            String str3 = "";
            if (iOTraceStats.lastReadPage != null) {
                str3 = Base64.encodeToString(iOTraceStats.lastReadPage, 0);
            }
            if (iOTraceStats.lastJournalReadPage != null) {
                str = Base64.encodeToString(iOTraceStats.lastJournalReadPage, 0);
            } else {
                str = "";
            }
            HashMap hashMap = new HashMap();
            hashMap.put("lastReadPage", str3);
            hashMap.put("lastJournalReadPage", str);
            com.tencent.mm.plugin.report.service.h.INSTANCE.e("DBCorrupt", format, hashMap);
            TextView textView = new TextView(context);
            textView.setText(format);
            textView.setGravity(8388627);
            textView.setTextSize(1, 10.0f);
            textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            textView.setTextColor(context.getResources().getColor(R.color.FG_0));
            textView.setTypeface(Typeface.MONOSPACE);
            textView.setMovementMethod(new ScrollingMovementMethod());
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.hs);
            textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            h.a(context, (String) null, textView, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(23049);
        }
        return true;
    }

    private static boolean c(Context context, String[] strArr) {
        String concat;
        AppMethodBeat.i(23050);
        ao azQ = g.aAh().azQ();
        if (strArr.length > 1) {
            try {
                int intValue = Integer.decode(strArr[1]).intValue();
                if (intValue > 2 || intValue < 0) {
                    NumberFormatException numberFormatException = new NumberFormatException();
                    AppMethodBeat.o(23050);
                    throw numberFormatException;
                }
                azQ.set(89, Integer.valueOf(intValue));
                azQ.gBI();
                concat = "Recovery status set to ".concat(String.valueOf(intValue));
            } catch (NumberFormatException e2) {
                concat = "Recovery status must be 0, 1 or 2";
            }
        } else {
            concat = "Recovery status is ".concat(String.valueOf(azQ.getInt(89, 0)));
        }
        Toast.makeText(context, concat, 0).show();
        AppMethodBeat.o(23050);
        return true;
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(final Context context, String[] strArr, String str) {
        final String str2;
        int i2;
        boolean z;
        AppMethodBeat.i(23051);
        String str3 = strArr[0];
        char c2 = 65535;
        switch (str3.hashCode()) {
            case -1955673212:
                if (str3.equals("//recover")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1870250080:
                if (str3.equals("//backupdb")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1832373669:
                if (str3.equals("//recover-status")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -1648083177:
                if (str3.equals("//post-recover")) {
                    c2 = 2;
                    break;
                }
                break;
            case -896707907:
                if (str3.equals("//iotracedb")) {
                    c2 = 7;
                    break;
                }
                break;
            case -398050965:
                if (str3.equals("//corruptdb")) {
                    c2 = 6;
                    break;
                }
                break;
            case -137452885:
                if (str3.equals("//repairdb")) {
                    c2 = 5;
                    break;
                }
                break;
            case 206015859:
                if (str3.equals("//fixdb")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1483443294:
                if (str3.equals("//recover-old")) {
                    c2 = 0;
                    break;
                }
                break;
            case 1793722114:
                if (str3.equals("//recoverdb")) {
                    c2 = 4;
                    break;
                }
                break;
            case 2027162967:
                if (str3.equals("//dbbusy")) {
                    c2 = '\t';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                boolean eU = eU(context);
                AppMethodBeat.o(23051);
                return eU;
            case 1:
                Intent intent = new Intent(context, DBRecoveryUI.class);
                intent.putExtra("scene", 2);
                intent.setFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/dbbackup/DBCommand", "newRecover", "(Landroid/content/Context;[Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/dbbackup/DBCommand", "newRecover", "(Landroid/content/Context;[Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(23051);
                return true;
            case 2:
                bg.aVF();
                d.cAY();
                Toast.makeText(context, "Post recovery cleanup done.", 0).show();
                AppMethodBeat.o(23051);
                return true;
            case 3:
                if (strArr.length <= 1 || !strArr[1].equals("cipher")) {
                    final boolean z2 = strArr.length > 1 && strArr[1].equals("incremental");
                    final long nanoTime = System.nanoTime();
                    final q a2 = h.a(context, "Backing database up. Please wait...", false, (DialogInterface.OnCancelListener) null);
                    if (!this.qCX.a(z2, new b() {
                        /* class com.tencent.mm.plugin.dbbackup.c.AnonymousClass2 */

                        @Override // com.tencent.mm.plugin.dbbackup.b
                        public final void Fk(final int i2) {
                            AppMethodBeat.i(23039);
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.plugin.dbbackup.c.AnonymousClass2.AnonymousClass1 */

                                public final void run() {
                                    String str;
                                    AppMethodBeat.i(23038);
                                    if (a2 != null) {
                                        a2.dismiss();
                                    }
                                    if (i2 == 0) {
                                        Object[] objArr = new Object[2];
                                        objArr[0] = z2 ? "incremental" : "new";
                                        objArr[1] = Float.valueOf(((float) (System.nanoTime() - nanoTime)) / 1.0E9f);
                                        str = String.format("Database (%s) backup succeeded, elapsed %.2f seconds.", objArr);
                                    } else if (i2 == 1) {
                                        str = "Database backup canceled.";
                                    } else {
                                        str = "Database backup failed.";
                                    }
                                    Toast.makeText(context, str, 0).show();
                                    AppMethodBeat.o(23038);
                                }
                            });
                            AppMethodBeat.o(23039);
                        }
                    })) {
                        if (a2 != null) {
                            a2.dismiss();
                        }
                        Toast.makeText(context, "Database is busy.", 0).show();
                    }
                } else {
                    bg.aVF();
                    ao azQ = com.tencent.mm.model.c.azQ();
                    if (strArr.length > 2) {
                        String str4 = strArr[2];
                        char c3 = 65535;
                        switch (str4.hashCode()) {
                            case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                                if (str4.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                                    c3 = 5;
                                    break;
                                }
                                break;
                            case 49:
                                if (str4.equals("1")) {
                                    c3 = 2;
                                    break;
                                }
                                break;
                            case 3521:
                                if (str4.equals("no")) {
                                    c3 = 3;
                                    break;
                                }
                                break;
                            case 3551:
                                if (str4.equals("on")) {
                                    c3 = 1;
                                    break;
                                }
                                break;
                            case 109935:
                                if (str4.equals("off")) {
                                    c3 = 4;
                                    break;
                                }
                                break;
                            case 119527:
                                if (str4.equals("yes")) {
                                    c3 = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c3) {
                            case 0:
                            case 1:
                            case 2:
                                azQ.setInt(237571, 0);
                                azQ.gBI();
                                break;
                            case 3:
                            case 4:
                            case 5:
                                azQ.setInt(237571, 1);
                                azQ.gBI();
                                break;
                        }
                    }
                    if (azQ.getInt(237571, 0) == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Toast.makeText(context, "Database backup with cipher: ".concat(String.valueOf(z)), 0).show();
                }
                AppMethodBeat.o(23051);
                return true;
            case 4:
                String str5 = strArr.length > 1 ? strArr[1] : null;
                final long nanoTime2 = System.nanoTime();
                context.getString(R.string.zb);
                final q a3 = h.a(context, context.getString(R.string.fx9), false, (DialogInterface.OnCancelListener) null);
                this.qCX.a(str5, new b() {
                    /* class com.tencent.mm.plugin.dbbackup.c.AnonymousClass3 */

                    @Override // com.tencent.mm.plugin.dbbackup.b
                    public final void Fk(final int i2) {
                        AppMethodBeat.i(23041);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.dbbackup.c.AnonymousClass3.AnonymousClass1 */

                            public final void run() {
                                String str;
                                AppMethodBeat.i(23040);
                                if (a3 != null) {
                                    a3.dismiss();
                                }
                                if (i2 == 0) {
                                    str = String.format("Database recovery succeeded, elapsed %.2f seconds.", Float.valueOf(((float) (System.nanoTime() - nanoTime2)) / 1.0E9f));
                                } else if (i2 == 1) {
                                    str = "Database recovery canceled.";
                                } else {
                                    str = "Database recovery failed.";
                                }
                                Toast.makeText(context, str, 0).show();
                                AppMethodBeat.o(23040);
                            }
                        });
                        AppMethodBeat.o(23041);
                    }
                });
                AppMethodBeat.o(23051);
                return true;
            case 5:
                String str6 = strArr.length > 1 ? strArr[1] : null;
                final long nanoTime3 = System.nanoTime();
                context.getString(R.string.zb);
                final q a4 = h.a(context, context.getString(R.string.fx9), false, (DialogInterface.OnCancelListener) null);
                int b2 = this.qCX.b(str6, new b() {
                    /* class com.tencent.mm.plugin.dbbackup.c.AnonymousClass4 */

                    @Override // com.tencent.mm.plugin.dbbackup.b
                    public final void Fk(final int i2) {
                        AppMethodBeat.i(23043);
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.dbbackup.c.AnonymousClass4.AnonymousClass1 */

                            public final void run() {
                                String str;
                                AppMethodBeat.i(23042);
                                if (a4 != null) {
                                    a4.dismiss();
                                }
                                if (i2 == 0) {
                                    str = String.format("Database recovery succeeded, elapsed %.2f seconds.", Float.valueOf(((float) (System.nanoTime() - nanoTime3)) / 1.0E9f));
                                } else if (i2 == 1) {
                                    str = "Database recovery canceled.";
                                } else {
                                    str = "Database recovery failed.";
                                }
                                Toast.makeText(context, str, 0).show();
                                AppMethodBeat.o(23042);
                            }
                        });
                        AppMethodBeat.o(23043);
                    }
                });
                if (b2 != 0) {
                    if (a4 != null) {
                        a4.dismiss();
                    }
                    switch (b2) {
                        case -3:
                            i2 = R.string.fx_;
                            break;
                        case -2:
                            i2 = R.string.fxa;
                            break;
                        default:
                            i2 = R.string.fx8;
                            break;
                    }
                    Toast.makeText(context, i2, 1).show();
                }
                AppMethodBeat.o(23051);
                return true;
            case 6:
                boolean b3 = b(context, strArr);
                AppMethodBeat.o(23051);
                return b3;
            case 7:
                boolean eV = eV(context);
                AppMethodBeat.o(23051);
                return eV;
            case '\b':
                boolean c4 = c(context, strArr);
                AppMethodBeat.o(23051);
                return c4;
            case '\t':
                if (this.qCY == null) {
                    this.qCY = new MMHandler("DBBusyTest", new MMHandler.Callback() {
                        /* class com.tencent.mm.plugin.dbbackup.c.AnonymousClass8 */

                        public final boolean handleMessage(Message message) {
                            AppMethodBeat.i(231686);
                            SQLiteDatabase gFH = g.aAh().hqK.gFH();
                            switch (message.what) {
                                case 1:
                                    gFH.beginTransaction();
                                    AppMethodBeat.o(231686);
                                    return true;
                                case 2:
                                    gFH.endTransaction();
                                    AppMethodBeat.o(231686);
                                    return true;
                                default:
                                    AppMethodBeat.o(231686);
                                    return false;
                            }
                        }
                    });
                    this.qCY.sendEmptyMessage(1);
                    Toast.makeText(context, "TEST: Begin transaction", 1).show();
                } else {
                    this.qCY.sendEmptyMessage(2);
                    this.qCY.quitSafely();
                    this.qCY = null;
                    Toast.makeText(context, "TEST: End transaction", 1).show();
                }
                AppMethodBeat.o(23051);
                return true;
            case '\n':
                if (strArr.length > 1) {
                    String str7 = strArr[1];
                    char c5 = 65535;
                    switch (str7.hashCode()) {
                        case -798724128:
                            if (str7.equals("duplicated-messages")) {
                                c5 = 1;
                                break;
                            }
                            break;
                        case 1732757995:
                            if (str7.equals("rconv-dirty")) {
                                c5 = 0;
                                break;
                            }
                            break;
                    }
                    switch (c5) {
                        case 0:
                            str2 = "DELETE FROM rconversation WHERE typeof(flag) <> 'integer'";
                            break;
                        case 1:
                            str2 = "DELETE FROM message WHERE rowid NOT IN (SELECT max(rowid) FROM message GROUP BY talker,msgSvrId,createTime)";
                            break;
                        default:
                            str2 = null;
                            break;
                    }
                    if (str2 != null) {
                        final q a5 = h.a(context, "正在执行修复", false, (DialogInterface.OnCancelListener) null);
                        ThreadPool.post(new Runnable() {
                            /* class com.tencent.mm.plugin.dbbackup.c.AnonymousClass9 */

                            public final void run() {
                                final String str;
                                AppMethodBeat.i(231688);
                                try {
                                    int executeUpdateDelete = g.aAh().hqK.gFH().compileStatement(str2).executeUpdateDelete();
                                    str = "成功更新 " + executeUpdateDelete + " 条记录";
                                    Log.i("MicroMsg.DBCommand", "SQL executed, changes: %d, SQL: %s", Integer.valueOf(executeUpdateDelete), str2);
                                } catch (RuntimeException e2) {
                                    str = "Execution failed: " + e2.getMessage();
                                    Log.printErrStackTrace("MicroMsg.DBCommand", e2, "Failed executing SQL: %s", str2);
                                }
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.dbbackup.c.AnonymousClass9.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(231687);
                                        if (a5 != null) {
                                            a5.dismiss();
                                        }
                                        h.c(context, str, "", true);
                                        AppMethodBeat.o(231687);
                                    }
                                });
                                AppMethodBeat.o(231688);
                            }
                        }, "DBCommand");
                        AppMethodBeat.o(23051);
                        return true;
                    }
                }
                AppMethodBeat.o(23051);
                return false;
            default:
                AppMethodBeat.o(23051);
                return false;
        }
    }
}
