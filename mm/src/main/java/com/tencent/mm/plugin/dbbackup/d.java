package com.tencent.mm.plugin.dbbackup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.i;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDirectCursor;
import com.tencent.wcdb.repair.BackupKit;
import com.tencent.wcdb.repair.RecoverKit;
import com.tencent.wcdb.repair.RepairKit;
import com.tencent.youtu.sdkkitframework.common.StateEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class d implements bd {
    private static final SQLiteCipherSpec qDP = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
    private boolean cSX = false;
    private boolean pPV = true;
    private BroadcastReceiver pPW;
    private Runnable pPX;
    private volatile BackupKit qDB;
    private volatile RecoverKit qDC;
    private volatile RepairKit qDD;
    private volatile boolean qDE = false;
    private boolean qDF = false;
    private boolean qDG = false;
    private long qDH = 0;
    private long qDI = 600000;
    private long qDJ = 0;
    private int qDK = 10;
    private boolean qDL = false;
    final SimpleDateFormat qDM = new SimpleDateFormat("HH:mm:ss.SSS");
    private MStorage.IOnStorageChange qDN;
    private IListener qDO;

    public d() {
        AppMethodBeat.i(23090);
        AppMethodBeat.o(23090);
    }

    static /* synthetic */ boolean b(String str, long[] jArr) {
        AppMethodBeat.i(23107);
        boolean a2 = a(str, jArr);
        AppMethodBeat.o(23107);
        return a2;
    }

    static /* synthetic */ void cBb() {
        AppMethodBeat.i(23108);
        cAX();
        AppMethodBeat.o(23108);
    }

    static /* synthetic */ int n(d dVar) {
        int i2 = dVar.qDK;
        dVar.qDK = i2 + 1;
        return i2;
    }

    static {
        AppMethodBeat.i(23109);
        AppMethodBeat.o(23109);
    }

    private static long[] a(SQLiteDatabase sQLiteDatabase) {
        long j2;
        long j3;
        long j4;
        long j5 = -1;
        AppMethodBeat.i(23091);
        Cursor rawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(msgId) FROM message;", null, null);
        if (rawQueryWithFactory.moveToFirst()) {
            j2 = rawQueryWithFactory.getLong(0);
        } else {
            j2 = -1;
        }
        rawQueryWithFactory.close();
        Cursor rawQueryWithFactory2 = sQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(id) FROM ImgInfo2;", null, null);
        if (rawQueryWithFactory2.moveToFirst()) {
            j3 = rawQueryWithFactory2.getLong(0);
        } else {
            j3 = -1;
        }
        rawQueryWithFactory2.close();
        Cursor rawQueryWithFactory3 = sQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM videoinfo2;", null, null);
        if (rawQueryWithFactory3.moveToFirst()) {
            j4 = rawQueryWithFactory3.getLong(0);
        } else {
            j4 = -1;
        }
        rawQueryWithFactory3.close();
        Cursor rawQueryWithFactory4 = sQLiteDatabase.rawQueryWithFactory(SQLiteDirectCursor.FACTORY, "SELECT max(rowid) FROM EmojiInfo;", null, null);
        if (rawQueryWithFactory4.moveToFirst()) {
            j5 = rawQueryWithFactory4.getLong(0);
        }
        rawQueryWithFactory4.close();
        long[] jArr = {j2, j3, j4, j5};
        AppMethodBeat.o(23091);
        return jArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0079 A[SYNTHETIC, Splitter:B:26:0x0079] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0085 A[SYNTHETIC, Splitter:B:32:0x0085] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long[] akS(java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 156
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.d.akS(java.lang.String):long[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x005f A[SYNTHETIC, Splitter:B:17:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b A[SYNTHETIC, Splitter:B:23:0x006b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.lang.String r9, long[] r10) {
        /*
        // Method dump skipped, instructions count: 124
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.d.a(java.lang.String, long[]):boolean");
    }

    private static String[] a(long[] jArr, long[] jArr2) {
        AppMethodBeat.i(23094);
        if (jArr2 == null || jArr2.length < 4) {
            String[] strArr = {"message", "msgId <= " + jArr[0], "ImgInfo2", "id <= " + jArr[1], "videoinfo2", "rowid <= " + jArr[2], "EmojiInfo", "rowid <= " + jArr[3], "conversation", null, "rconversation", null};
            AppMethodBeat.o(23094);
            return strArr;
        }
        String[] strArr2 = {"message", String.format("msgId > %d AND msgId <= %d", Long.valueOf(jArr2[0]), Long.valueOf(jArr[0])), "ImgInfo2", String.format("id > %d AND id <= %d", Long.valueOf(jArr2[1]), Long.valueOf(jArr[1])), "videoinfo2", String.format("rowid > %d AND rowid <= %d", Long.valueOf(jArr2[2]), Long.valueOf(jArr[2])), "EmojiInfo", String.format("rowid > %d AND rowid <= %d", Long.valueOf(jArr2[3]), Long.valueOf(jArr[3])), "conversation", null, "rconversation", null};
        AppMethodBeat.o(23094);
        return strArr2;
    }

    private static boolean b(SQLiteDatabase sQLiteDatabase) {
        boolean z;
        AppMethodBeat.i(23095);
        String str = sQLiteDatabase.getPath() + ".sm";
        String str2 = str + ".tmp";
        ao azQ = g.aAh().azQ();
        long akg = azQ.akg(237569);
        long currentTimeMillis = System.currentTimeMillis();
        o oVar = new o(str);
        if (!oVar.exists() || currentTimeMillis - akg >= Util.MILLSECONDS_OF_DAY) {
            long nanoTime = System.nanoTime();
            StringBuilder append = new StringBuilder().append(q.dr(true));
            bg.aVF();
            byte[] Q = com.tencent.mm.b.g.Q(append.append(c.getUin()).toString().getBytes());
            o oVar2 = new o(str2);
            try {
                z = RepairKit.MasterInfo.save(sQLiteDatabase, com.tencent.mm.b.q.k(str2, true), Q);
            } catch (RuntimeException e2) {
                Log.printErrStackTrace("MicroMsg.SubCoreDBBackup", e2, "Failed to backup database master.", new Object[0]);
                z = false;
            }
            if (z) {
                oVar.delete();
                z = oVar2.am(oVar);
                azQ.setLong(237569, currentTimeMillis);
                azQ.gBI();
            } else {
                oVar2.delete();
            }
            long nanoTime2 = System.nanoTime() - nanoTime;
            Object[] objArr = new Object[2];
            objArr[0] = z ? "SUCCEEDED" : "FAILED";
            objArr[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
            Log.i("MicroMsg.SubCoreDBBackup", "Master table backup %s, elapsed %.3f", objArr);
            h.INSTANCE.idkeyStat(181, z ? 24 : 25, 1, false);
            AppMethodBeat.o(23095);
            return z;
        }
        AppMethodBeat.o(23095);
        return true;
    }

    public final boolean a(boolean z, final b bVar) {
        final boolean z2;
        final int i2;
        AppMethodBeat.i(23096);
        if (this.qDE) {
            Log.i("MicroMsg.SubCoreDBBackup", "Backup or recover task is in progress, %s canceled", "backup");
            AppMethodBeat.o(23096);
            return false;
        }
        final c aVF = bg.aVF();
        final String azO = c.azO();
        final SQLiteDatabase gFH = c.getDataDB().gFH();
        final String str = azO + ".bak";
        final String str2 = str + ".tmp";
        final String str3 = azO + ".sm";
        final String str4 = str3 + ".tmp";
        int i3 = 8;
        if (z) {
            if (s.YS(str)) {
                i3 = 24;
                s.nw(str, str2);
            } else {
                z = false;
            }
        }
        final long[] a2 = a(gFH);
        final long[] akS = z ? akS(azO) : null;
        final String[] a3 = a(a2, akS);
        if (akS == null) {
            z2 = false;
        } else {
            z2 = z;
        }
        if (this.qDL) {
            i2 = i3 | 3;
        } else {
            i2 = i3;
        }
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.dbbackup.d.AnonymousClass1 */

            public final void run() {
                int i2;
                int i3;
                String str;
                boolean z;
                AppMethodBeat.i(23078);
                if (!d.this.qDE) {
                    if (bVar != null) {
                        bVar.Fk(1);
                    }
                    AppMethodBeat.o(23078);
                    return;
                }
                d.this.qDB = null;
                try {
                    long nanoTime = System.nanoTime();
                    byte[] Q = com.tencent.mm.b.g.Q((q.dr(true) + c.getUin()).getBytes());
                    o oVar = new o(str3);
                    if (!z2 || !oVar.exists()) {
                        boolean save = RepairKit.MasterInfo.save(gFH, com.tencent.mm.b.q.k(str4, true), Q);
                        o oVar2 = new o(str4);
                        if (save) {
                            oVar.delete();
                            z = oVar2.am(oVar);
                        } else {
                            oVar2.delete();
                            z = save;
                        }
                        long nanoTime2 = System.nanoTime() - nanoTime;
                        Object[] objArr = new Object[2];
                        objArr[0] = z ? "SUCCEEDED" : "FAILED";
                        objArr[1] = Float.valueOf(((float) nanoTime2) / 1.0E9f);
                        Log.i("MicroMsg.SubCoreDBBackup", "Master table backup %s, elapsed %.3f", objArr);
                        h.INSTANCE.idkeyStat(181, z ? 24 : 25, 1, false);
                    }
                    long length = new o(azO).length();
                    long length2 = new o(str2).length();
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = z2 ? "incremental" : "new";
                    objArr2[1] = Long.valueOf(akS != null ? akS[0] : 0);
                    objArr2[2] = Long.valueOf(a2[0]);
                    Log.i("MicroMsg.SubCoreDBBackup", "Backup started [%s, cursor: %d ~ %d]", objArr2);
                    h.INSTANCE.a(11098, Integer.valueOf(z2 ? CdnLogic.kMediaTypeBeatificFile : 10000), String.format("%d|%d|%s", Long.valueOf(length), Long.valueOf(length2), d.this.qDM.format(new Date())));
                    d.this.qDB = new BackupKit(gFH, str2, Q, i2, a3);
                    int run = d.this.qDB.run();
                    long nanoTime3 = System.nanoTime() - nanoTime;
                    o oVar3 = new o(str2);
                    long length3 = oVar3.length();
                    if (run == 0) {
                        d.b(azO, a2);
                        o oVar4 = new o(str);
                        oVar4.delete();
                        oVar3.am(oVar4);
                        if (z2) {
                            i2 = 19;
                            i3 = 10012;
                        } else {
                            i2 = 16;
                            i3 = 10001;
                        }
                    } else {
                        oVar3.delete();
                        if (run == 1) {
                            if (z2) {
                                i2 = 20;
                                i3 = 10013;
                            } else {
                                i2 = 17;
                                i3 = 10002;
                            }
                        } else if (z2) {
                            i2 = 21;
                            i3 = 10014;
                        } else {
                            i2 = 18;
                            i3 = 10003;
                        }
                    }
                    Object[] objArr3 = new Object[3];
                    objArr3[0] = z2 ? "incremental" : "new";
                    if (run == 0) {
                        str = AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED;
                    } else {
                        str = run == 1 ? "canceled" : StateEvent.ProcessResult.FAILED;
                    }
                    objArr3[1] = str;
                    objArr3[2] = Float.valueOf(((float) nanoTime3) / 1.0E9f);
                    Log.i("MicroMsg.SubCoreDBBackup", "Database %s backup %s, elapsed %.2f seconds.", objArr3);
                    h.INSTANCE.idkeyStat(181, (long) i2, 1, false);
                    h.INSTANCE.a(11098, Integer.valueOf(i3), String.format("%d|%d|%d|%d|%d|%s", Long.valueOf(length), Long.valueOf(length2), Long.valueOf(length3), Integer.valueOf(d.this.qDB.statementCount()), Long.valueOf(nanoTime3 / TimeUtil.SECOND_TO_US), d.this.qDM.format(new Date())));
                    if (bVar != null) {
                        bVar.Fk(run);
                    }
                    d.this.qDB.release();
                    d.this.qDB = null;
                    StringBuilder sb = new StringBuilder();
                    g.aAi();
                    s.boN(sb.append(g.aAh().hqG).append("dbback").toString());
                    String str2 = str3;
                    StringBuilder sb2 = new StringBuilder();
                    g.aAi();
                    s.nw(str2, sb2.append(g.aAh().hqG).append("dbback/EnMicroMsg.db.sm").toString());
                    if (d.this.qDB != null) {
                        d.this.qDB.release();
                        d.this.qDB = null;
                    }
                    d.this.qDE = false;
                    AppMethodBeat.o(23078);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.SubCoreDBBackup", e2, "Failed to start database backup, path: %s", azO);
                    if (bVar != null) {
                        bVar.Fk(-1);
                    }
                    h.INSTANCE.idkeyStat(181, z2 ? 18 : 21, 1, false);
                    if (d.this.qDB != null) {
                        d.this.qDB.release();
                        d.this.qDB = null;
                    }
                    d.this.qDE = false;
                    AppMethodBeat.o(23078);
                } catch (Throwable th) {
                    if (d.this.qDB != null) {
                        d.this.qDB.release();
                        d.this.qDB = null;
                    }
                    d.this.qDE = false;
                    AppMethodBeat.o(23078);
                    throw th;
                }
            }
        };
        this.qDE = true;
        ThreadPool.post(r0, "DB Backup");
        AppMethodBeat.o(23096);
        return true;
    }

    public final synchronized boolean cAW() {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(23097);
            this.qDE = false;
            if (this.qDB == null) {
                AppMethodBeat.o(23097);
            } else {
                this.qDB.onCancel();
                z = true;
                AppMethodBeat.o(23097);
            }
        }
        return z;
    }

    @Deprecated
    public final synchronized int a(final String str, final b bVar) {
        AppMethodBeat.i(23098);
        final c aVF = bg.aVF();
        final long dataAvailableSize = Util.getDataAvailableSize();
        AnonymousClass2 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.dbbackup.d.AnonymousClass2 */

            /* JADX WARNING: Removed duplicated region for block: B:45:0x01d0 A[Catch:{ all -> 0x037e }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x01ed  */
            /* JADX WARNING: Removed duplicated region for block: B:51:0x0202  */
            /* JADX WARNING: Removed duplicated region for block: B:82:0x0389  */
            /* JADX WARNING: Removed duplicated region for block: B:84:0x039e  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                // Method dump skipped, instructions count: 972
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.d.AnonymousClass2.run():void");
            }
        };
        this.qDE = true;
        bg.aAk().setHighPriority();
        bg.aAk().postAtFrontOfQueueToWorker(r0);
        AppMethodBeat.o(23098);
        return 0;
    }

    @Deprecated
    public final synchronized int b(final String str, final b bVar) {
        o oVar;
        int i2 = 0;
        synchronized (this) {
            AppMethodBeat.i(23099);
            final c aVF = bg.aVF();
            if (str == null) {
                str = c.azL();
            }
            long dataAvailableSize = Util.getDataAvailableSize();
            if (str == null) {
                oVar = null;
            } else {
                oVar = new o(str);
            }
            if (oVar == null || !oVar.canRead()) {
                i2 = -3;
                AppMethodBeat.o(23099);
            } else {
                Log.i("MicroMsg.SubCoreDBBackup", "[Repair] inFileSize: %d, diskFreeSpace: %d", Long.valueOf(oVar.length()), Long.valueOf(dataAvailableSize));
                if (((float) dataAvailableSize) < ((float) oVar.length()) * 1.5f) {
                    i2 = -2;
                    AppMethodBeat.o(23099);
                } else {
                    AnonymousClass3 r1 = new Runnable() {
                        /* class com.tencent.mm.plugin.dbbackup.d.AnonymousClass3 */
                        final String[] qEf = {"message", "ImgInfo2", "videoinfo2", "EmojiInfo", "conversation", "rconversation"};

                        {
                            AppMethodBeat.i(23080);
                            AppMethodBeat.o(23080);
                        }

                        /* JADX WARNING: Code restructure failed: missing block: B:40:0x01a0, code lost:
                            r0 = move-exception;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:41:0x01a1, code lost:
                            com.tencent.mm.sdk.platformtools.Log.e("MicroMsg.SubCoreDBBackup", "Failed to load saved master: " + r0.getMessage());
                            r3 = r3 + 1;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:81:0x02c7, code lost:
                            r0 = th;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:82:0x02c8, code lost:
                            r10 = r2;
                         */
                        /* JADX WARNING: Failed to process nested try/catch */
                        /* JADX WARNING: Removed duplicated region for block: B:50:0x01f1 A[Catch:{ all -> 0x02d1 }] */
                        /* JADX WARNING: Removed duplicated region for block: B:54:0x0228  */
                        /* JADX WARNING: Removed duplicated region for block: B:56:0x0239  */
                        /* JADX WARNING: Removed duplicated region for block: B:58:0x023e  */
                        /* JADX WARNING: Removed duplicated region for block: B:72:0x0299  */
                        /* JADX WARNING: Removed duplicated region for block: B:74:0x02aa  */
                        /* JADX WARNING: Removed duplicated region for block: B:76:0x02af  */
                        /* JADX WARNING: Removed duplicated region for block: B:81:0x02c7 A[ExcHandler: all (th java.lang.Throwable), PHI: r2 
                          PHI: (r2v31 com.tencent.wcdb.repair.RepairKit$MasterInfo) = (r2v17 com.tencent.wcdb.repair.RepairKit$MasterInfo), (r2v17 com.tencent.wcdb.repair.RepairKit$MasterInfo), (r2v17 com.tencent.wcdb.repair.RepairKit$MasterInfo), (r2v33 com.tencent.wcdb.repair.RepairKit$MasterInfo) binds: [B:8:0x00ab, B:9:?, B:10:0x00b2, B:11:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:8:0x00ab] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            /*
                            // Method dump skipped, instructions count: 738
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.d.AnonymousClass3.run():void");
                        }
                    };
                    this.qDE = true;
                    bg.aAk().setHighPriority();
                    bg.aAk().postAtFrontOfQueueToWorker(r1);
                    AppMethodBeat.o(23099);
                }
            }
        }
        return i2;
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        boolean z2;
        AppMethodBeat.i(23101);
        bg.aVF();
        ao azQ = c.azQ();
        SQLiteDatabase gFH = c.getDataDB().gFH();
        this.qDJ = azQ.akg(237569);
        this.qDK = azQ.getInt(237570, 10);
        this.qDL = azQ.getInt(237571, 0) != 0;
        Context context = MMApplicationContext.getContext();
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            if (intExtra == 2 || intExtra == 5) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.cSX = z2;
        } else {
            this.cSX = false;
        }
        this.pPV = ((PowerManager) context.getSystemService("power")).isScreenOn();
        this.qDN = new MStorage.IOnStorageChange() {
            /* class com.tencent.mm.plugin.dbbackup.d.AnonymousClass7 */

            @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
            public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
                AppMethodBeat.i(23085);
                if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                    d.cBb();
                }
                AppMethodBeat.o(23085);
            }
        };
        com.tencent.mm.model.c.d.aXu().add(this.qDN);
        cAX();
        this.qDO = new IListener<ps>() {
            /* class com.tencent.mm.plugin.dbbackup.d.AnonymousClass8 */

            {
                AppMethodBeat.i(161314);
                this.__eventId = ps.class.getName().hashCode();
                AppMethodBeat.o(161314);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ps psVar) {
                boolean z;
                AppMethodBeat.i(23086);
                f aqJ = com.tencent.mm.n.h.aqJ();
                if (CrashReportFactory.hasDebuger()) {
                    d.this.qDG = true;
                    d.this.qDH = MAlarmHandler.NEXT_FIRE_INTERVAL;
                } else {
                    int i2 = aqJ.getInt("AndroidDBBackupPercentage", 0);
                    bg.aVF();
                    int ch = i.ch(c.getUin(), 100);
                    d dVar = d.this;
                    if (ch < i2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    dVar.qDG = z;
                    d.this.qDH = (long) aqJ.getInt("AndroidDBBackupMaxDBSizeMB", 0);
                    d.this.qDH *= 1048576;
                }
                d.this.qDI = (long) aqJ.getInt("AndroidDBBackupWaitSeconds", 600);
                d.this.qDI *= 1000;
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(d.this.qDG);
                objArr[1] = d.this.qDH == MAlarmHandler.NEXT_FIRE_INTERVAL ? "not limited" : Long.valueOf(d.this.qDH);
                objArr[2] = Boolean.valueOf(CrashReportFactory.hasDebuger());
                Log.d("MicroMsg.SubCoreDBBackup", "Auto backup enabled: %b, max size: %s, debugger: %b", objArr);
                d.this.qDG = false;
                AppMethodBeat.o(23086);
                return true;
            }
        };
        EventCenter.instance.addListener(this.qDO);
        this.pPW = new BroadcastReceiver() {
            /* class com.tencent.mm.plugin.dbbackup.d.AnonymousClass9 */

            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.i(23089);
                String action = intent.getAction();
                char c2 = 65535;
                switch (action.hashCode()) {
                    case -2128145023:
                        if (action.equals("android.intent.action.SCREEN_OFF")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1886648615:
                        if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1454123155:
                        if (action.equals("android.intent.action.SCREEN_ON")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 1019184907:
                        if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        d.this.pPV = true;
                        break;
                    case 1:
                        d.this.pPV = false;
                        break;
                    case 2:
                        d.this.cSX = true;
                        break;
                    case 3:
                        d.this.cSX = false;
                        break;
                }
                Log.v("MicroMsg.SubCoreDBBackup", "Action received: %s, interactive: %s, charging: %s", action, Boolean.valueOf(d.this.pPV), Boolean.valueOf(d.this.cSX));
                if (!d.this.qDG || d.this.pPX != null || !d.this.cSX || d.this.pPV) {
                    if (d.this.pPX != null) {
                        bg.aAk().getWorkerHandler().removeCallbacks(d.this.pPX);
                        d.this.pPX = null;
                        Log.i("MicroMsg.SubCoreDBBackup", "Auto database backup canceled.");
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 10010, d.this.qDM.format(new Date()));
                        AppMethodBeat.o(23089);
                        return;
                    }
                    if (d.this.qDF) {
                        d.this.cAW();
                        d.this.qDF = false;
                    }
                    AppMethodBeat.o(23089);
                } else if (System.currentTimeMillis() - d.this.qDJ < Util.MILLSECONDS_OF_DAY) {
                    Log.d("MicroMsg.SubCoreDBBackup", "Last backup time not matched.");
                    AppMethodBeat.o(23089);
                } else {
                    final boolean z = d.this.qDK < 10;
                    final AnonymousClass1 r4 = new b() {
                        /* class com.tencent.mm.plugin.dbbackup.d.AnonymousClass9.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.dbbackup.b
                        public final void Fk(int i2) {
                            AppMethodBeat.i(23087);
                            d.this.qDF = false;
                            bg.aVF();
                            ao azQ = c.azQ();
                            d.this.qDJ = System.currentTimeMillis();
                            if (i2 == 0) {
                                azQ.setLong(237569, d.this.qDJ);
                                if (z) {
                                    d.n(d.this);
                                } else {
                                    d.this.qDK = 0;
                                }
                                azQ.setInt(237570, d.this.qDK);
                            } else {
                                if (i2 != 1) {
                                    azQ.setLong(237569, d.this.qDJ);
                                    if (z) {
                                        d.this.qDK = 10;
                                        azQ.setInt(237570, d.this.qDK);
                                    }
                                }
                                AppMethodBeat.o(23087);
                            }
                            azQ.gBI();
                            AppMethodBeat.o(23087);
                        }
                    };
                    d.this.pPX = new Runnable() {
                        /* class com.tencent.mm.plugin.dbbackup.d.AnonymousClass9.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(23088);
                            d.this.pPX = null;
                            bg.aVF();
                            long length = new o(c.azO()).length();
                            long dataAvailableSize = Util.getDataAvailableSize();
                            if (length == 0) {
                                Log.i("MicroMsg.SubCoreDBBackup", "Invalid database size, backup canceled.");
                                AppMethodBeat.o(23088);
                            } else if (length > d.this.qDH || length > dataAvailableSize) {
                                Log.i("MicroMsg.SubCoreDBBackup", "Not enough disk space, backup canceled.");
                                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 10008, String.format("%d|%d", Long.valueOf(length), Long.valueOf(dataAvailableSize)));
                                AppMethodBeat.o(23088);
                            } else {
                                d.this.qDF = d.this.a(z, r4);
                                if (d.this.qDF) {
                                    Log.i("MicroMsg.SubCoreDBBackup", "Auto database backup started.");
                                }
                                AppMethodBeat.o(23088);
                            }
                        }
                    };
                    bg.aAk().postToWorkerDelayed(d.this.pPX, d.this.qDI);
                    Log.i("MicroMsg.SubCoreDBBackup", "Auto database backup scheduled.");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11098, 10009, d.this.qDM.format(new Date()));
                    AppMethodBeat.o(23089);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        context.registerReceiver(this.pPW, intentFilter);
        b.a(new c(this), "//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status", "//dbbusy", "//fixdb");
        Object[] objArr = new Object[3];
        objArr[0] = this.qDG ? "enabled" : "disabled";
        objArr[1] = this.pPV ? "" : " not";
        objArr[2] = this.cSX ? "" : " not";
        Log.i("MicroMsg.SubCoreDBBackup", "Auto database backup %s. Device status:%s interactive,%s charging.", objArr);
        b(gFH);
        com.tencent.mm.plugin.dbbackup.a.b.akW(q.dr(true));
        s.deleteFile(g.aAh().hqG + "dbback/EnMicroMsg.db.bak");
        s.deleteFile(g.aAh().hqG + "dbback/corrupted/EnMicroMsg.db.bak");
        s.deleteFile(g.aAh().cachePath + "EnMicroMsg.db.bak");
        s.deleteFile(g.aAh().cachePath + "corrupted/EnMicroMsg.db.bak");
        final String azM = c.azM();
        bg.aAk().postToWorkerDelayed(new Runnable() {
            /* class com.tencent.mm.plugin.dbbackup.d.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(23084);
                if (s.YS((azM + "corrupted/EnMicroMsg.db") + ".corrupt")) {
                    AppMethodBeat.o(23084);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                o oVar = new o(azM + "corrupted");
                if (!oVar.isDirectory()) {
                    AppMethodBeat.o(23084);
                    return;
                }
                for (o oVar2 : oVar.het()) {
                    if (currentTimeMillis - oVar2.lastModified() < 7776000000L) {
                        AppMethodBeat.o(23084);
                        return;
                    }
                }
                if (s.dy(aa.z(oVar.mUri), true)) {
                    Log.i("MicroMsg.SubCoreDBBackup", "Corrupted databases removed.");
                }
                AppMethodBeat.o(23084);
            }
        }, Util.MILLSECONDS_OF_MINUTE);
        AppMethodBeat.o(23101);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(23102);
        cAW();
        this.qDF = false;
        if (this.pPX != null) {
            bg.aAk().getWorkerHandler().removeCallbacks(this.pPX);
            this.pPX = null;
        }
        if (this.qDO != null) {
            EventCenter.instance.removeListener(this.qDO);
            this.qDO = null;
        }
        if (this.pPW != null) {
            MMApplicationContext.getContext().unregisterReceiver(this.pPW);
            this.pPW = null;
        }
        b.V("//recover-old", "//recover", "//post-recover", "//backupdb", "//recoverdb", "//repairdb", "//corruptdb", "//iotracedb", "//recover-status", "//dbbusy", "//fixdb");
        AppMethodBeat.o(23102);
    }

    private static void cAX() {
        AppMethodBeat.i(23103);
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100274");
        if (Fu.isValid()) {
            Map<String, String> gzz = Fu.gzz();
            HashMap hashMap = new HashMap();
            hashMap.put("flags", Integer.valueOf(Util.getInt(gzz.get("flags"), 0)));
            hashMap.put("acp", Integer.valueOf(Util.getInt(gzz.get("acp"), 100)));
            com.tencent.mm.storagebase.f.cf(hashMap);
        }
        AppMethodBeat.o(23103);
    }

    static void cAY() {
        AppMethodBeat.i(23104);
        com.tencent.mm.plugin.messenger.foundation.a.a.i aSQ = c.aSQ();
        aSQ.eiH();
        aSQ.eiJ();
        aSQ.eiI();
        c.aST().gCu();
        com.tencent.mm.av.q.bcR().bcy();
        ao azQ = c.azQ();
        azQ.set(ar.a.USERINFO_EMOJI_NEW_EMOJI_INT, (Object) 0);
        azQ.set(ar.a.USERINFO_EMOJI_NEW_PANEL_INT, (Object) 0);
        azQ.set(ar.a.USERINFO_EMOJI_NEW_SUGGEST_INT, (Object) 0);
        AppMethodBeat.o(23104);
    }

    public static void eW(Context context) {
        AppMethodBeat.i(23105);
        MMAppMgr.n(context, true);
        AppMethodBeat.o(23105);
    }

    public static void cAZ() {
        AppMethodBeat.i(23106);
        MMAppMgr.Bj(true);
        AppMethodBeat.o(23106);
    }
}
