package com.tencent.mm.plugin.dbbackup.a;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.wcdb.DatabaseErrorHandler;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteStatement;
import com.tencent.wcdb.repair.RecoverKit;
import com.tencent.wcdb.support.CancellationSignal;
import com.tencent.wcdb.support.OperationCanceledException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

public final class a extends AsyncTask<Void, Integer, Integer> {
    private static final String[] CONFLICT_VALUES = {"", " OR ROLLBACK", " OR ABORT", " OR FAIL", " OR IGNORE", " OR REPLACE"};
    private static final SQLiteCipherSpec qEp = new SQLiteCipherSpec().setPageSize(1024).setSQLCipherVersion(1);
    private final CancellationSignal mCancellationSignal;
    private List<byte[]> qEA;
    private d qEB;
    private boolean qEC;
    private b qED;
    private boolean qEE;
    private int qEF;
    private long qEG;
    private long qEH;
    private SQLiteDatabase qEq;
    private String qEr;
    private String qEs;
    private String qEt;
    private String qEu;
    private List<String> qEv;
    private List<String> qEw;
    private byte[] qEx;
    private byte[] qEy;
    private List<byte[]> qEz;

    public interface b {
        void M(long j2, long j3);

        void X(int i2, int i3, int i4);

        void onCanceled();

        void onFailure();

        void onSuccess();
    }

    public interface d {
        Collection<byte[]> cAU();

        Collection<byte[]> cAV();
    }

    /* access modifiers changed from: package-private */
    public interface e {
        boolean a(Cursor cursor, SQLiteStatement sQLiteStatement);
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    static /* synthetic */ void a(a aVar, Object[] objArr) {
        AppMethodBeat.i(23136);
        aVar.publishProgress(objArr);
        AppMethodBeat.o(23136);
    }

    static /* synthetic */ void b(a aVar, Object[] objArr) {
        AppMethodBeat.i(23137);
        aVar.publishProgress(objArr);
        AppMethodBeat.o(23137);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ Integer doInBackground(Void[] voidArr) {
        AppMethodBeat.i(23135);
        Integer rI = rI();
        AppMethodBeat.o(23135);
        return rI;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(Integer num) {
        AppMethodBeat.i(23134);
        Integer num2 = num;
        if (this.qED != null) {
            switch (num2.intValue()) {
                case -2:
                    this.qED.M(this.qEH, this.qEG);
                    AppMethodBeat.o(23134);
                    return;
                case -1:
                default:
                    this.qED.onFailure();
                    break;
                case 0:
                    this.qED.onSuccess();
                    AppMethodBeat.o(23134);
                    return;
                case 1:
                    this.qED.onCanceled();
                    AppMethodBeat.o(23134);
                    return;
            }
        }
        AppMethodBeat.o(23134);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onProgressUpdate(Integer[] numArr) {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(23133);
        Integer[] numArr2 = numArr;
        if (this.qED != null) {
            int intValue = numArr2.length > 0 ? numArr2[0].intValue() : 0;
            if (numArr2.length >= 2) {
                i2 = numArr2[1].intValue();
            } else {
                i2 = 0;
            }
            if (numArr2.length >= 3) {
                i3 = numArr2[2].intValue();
            }
            this.qED.X(intValue, i2, i3);
        }
        AppMethodBeat.o(23133);
    }

    static {
        AppMethodBeat.i(23138);
        AppMethodBeat.o(23138);
    }

    /* renamed from: com.tencent.mm.plugin.dbbackup.a.a$a  reason: collision with other inner class name */
    public static class C0942a {
        public d qEB;
        public boolean qEC;
        public b qED;
        private LinkedHashSet<byte[]> qEV = new LinkedHashSet<>();
        private LinkedHashSet<byte[]> qEW = new LinkedHashSet<>();
        public String qEr;
        public String qEs;
        public String qEt;
        public String qEu;
        private List<String> qEv = new ArrayList();
        private List<String> qEw = new ArrayList();
        private byte[] qEx;
        private byte[] qEy;

        public C0942a() {
            AppMethodBeat.i(23114);
            AppMethodBeat.o(23114);
        }

        public final a cBi() {
            AppMethodBeat.i(23115);
            a aVar = new a((byte) 0);
            aVar.qEr = this.qEr;
            aVar.qEs = this.qEs;
            aVar.qEt = this.qEt;
            aVar.qEu = this.qEu;
            aVar.qEv = new ArrayList(this.qEv);
            aVar.qEw = new ArrayList(this.qEw);
            aVar.qEx = this.qEx;
            aVar.qEy = this.qEy;
            aVar.qEB = this.qEB;
            aVar.qEz = new ArrayList(this.qEV);
            aVar.qEA = new ArrayList(this.qEW);
            aVar.qEC = this.qEC;
            aVar.qED = this.qED;
            AppMethodBeat.o(23115);
            return aVar;
        }

        public final C0942a akU(String str) {
            AppMethodBeat.i(23116);
            this.qEv.add(str);
            AppMethodBeat.o(23116);
            return this;
        }

        public final C0942a akV(String str) {
            AppMethodBeat.i(23117);
            this.qEw.add(str);
            AppMethodBeat.o(23117);
            return this;
        }

        public final C0942a bl(byte[] bArr) {
            AppMethodBeat.i(23118);
            this.qEx = Arrays.copyOf(bArr, bArr.length);
            AppMethodBeat.o(23118);
            return this;
        }

        public final C0942a bm(byte[] bArr) {
            AppMethodBeat.i(23119);
            this.qEy = Arrays.copyOf(bArr, bArr.length);
            AppMethodBeat.o(23119);
            return this;
        }
    }

    private a() {
        AppMethodBeat.i(23120);
        this.mCancellationSignal = new CancellationSignal();
        AppMethodBeat.o(23120);
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x01e9  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0220  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0229  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x024f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Integer rI() {
        /*
        // Method dump skipped, instructions count: 682
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.a.a.rI():java.lang.Integer");
    }

    public final void cancel() {
        AppMethodBeat.i(23122);
        this.mCancellationSignal.cancel();
        Log.i("MicroMsg.DBRecoveryTask", "Recovery cancel triggered.");
        AppMethodBeat.o(23122);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int cBc() {
        /*
        // Method dump skipped, instructions count: 241
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.a.a.cBc():int");
    }

    private int cBd() {
        AppMethodBeat.i(23124);
        if (this.qEq != null) {
            if (this.qEq.isOpen()) {
                this.qEq.close();
            }
            this.qEq = null;
        }
        this.mCancellationSignal.throwIfCanceled();
        String str = this.qEr + '-' + Util.getRandomString(6);
        Log.i("MicroMsg.DBRecoveryTask", "Open target database: ".concat(String.valueOf(str)));
        try {
            this.qEq = SQLiteDatabase.openOrCreateDatabase(str, this.qEx, qEp, (SQLiteDatabase.CursorFactory) null, (DatabaseErrorHandler) null, 1);
            DatabaseUtils.stringForQuery(this.qEq, "PRAGMA journal_mode=OFF;", null);
            this.qEq.execSQL("PRAGMA synchronous=OFF;");
            AppMethodBeat.o(23124);
            return 0;
        } catch (Exception e2) {
            Log.e("MicroMsg.DBRecoveryTask", "Cannot open target database '%s': %s", str, e2.getMessage());
            c(1, "Cannot open target database", e2);
            AppMethodBeat.o(23124);
            throw e2;
        }
    }

    private int kQ(boolean z) {
        AppMethodBeat.i(23125);
        Log.i("MicroMsg.DBRecoveryTask", "Close and rename target database: " + this.qEr);
        if (this.qEq == null) {
            AppMethodBeat.o(23125);
            return -1;
        }
        o oVar = new o(this.qEq.getPath());
        if (this.qEq.isOpen()) {
            this.qEq.close();
        }
        if (!z) {
            Log.i("MicroMsg.DBRecoveryTask", "Delete temporary database file %s", oVar);
            oVar.delete();
        } else if (!oVar.am(new o(this.qEr))) {
            Log.e("MicroMsg.DBRecoveryTask", "Cannot rename %s to %s", oVar, this.qEr);
            AppMethodBeat.o(23125);
            return -1;
        }
        AppMethodBeat.o(23125);
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0235, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0236, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0241, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0242, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x024a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x021c  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x024a A[ExcHandler: OperationCanceledException (e com.tencent.wcdb.support.OperationCanceledException), PHI: r5 
      PHI: (r5v1 com.tencent.wcdb.repair.RepairKit) = (r5v0 com.tencent.wcdb.repair.RepairKit), (r5v3 com.tencent.wcdb.repair.RepairKit), (r5v3 com.tencent.wcdb.repair.RepairKit) binds: [B:16:0x00ac, B:28:0x00fa, B:29:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:16:0x00ac] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int cBe() {
        /*
        // Method dump skipped, instructions count: 599
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.a.a.cBe():int");
    }

    private int cBf() {
        RecoverKit recoverKit;
        AppMethodBeat.i(23127);
        this.mCancellationSignal.throwIfCanceled();
        Log.i("MicroMsg.DBRecoveryTask", "Begin backup recovery.");
        RecoverKit recoverKit2 = null;
        for (String str : this.qEw) {
            try {
                RecoverKit recoverKit3 = new RecoverKit(this.qEq, str, this.qEz.get(0));
                try {
                    Log.i("MicroMsg.DBRecoveryTask", "Loaded backup data: ".concat(String.valueOf(str)));
                    recoverKit2 = recoverKit3;
                } catch (Exception e2) {
                    e = e2;
                    recoverKit = recoverKit3;
                    Log.e("MicroMsg.DBRecoveryTask", "Load backup data failed: " + e.getMessage());
                    recoverKit2 = recoverKit;
                }
            } catch (Exception e3) {
                e = e3;
                recoverKit = recoverKit2;
                Log.e("MicroMsg.DBRecoveryTask", "Load backup data failed: " + e.getMessage());
                recoverKit2 = recoverKit;
            }
        }
        if (recoverKit2 == null) {
            AppMethodBeat.o(23127);
            return -1;
        }
        try {
            int run = recoverKit2.run(false, this.mCancellationSignal);
            if (run == 0) {
                Log.i("MicroMsg.DBRecoveryTask", "Backup recovery succeeded.");
            } else if (run == 1) {
                Log.i("MicroMsg.DBRecoveryTask", "Backup recovery cancelled.");
                this.mCancellationSignal.throwIfCanceled();
            } else {
                Log.e("MicroMsg.DBRecoveryTask", "Backup recovery failed.");
            }
            recoverKit2.release();
            AppMethodBeat.o(23127);
            return run;
        } catch (OperationCanceledException e4) {
            AppMethodBeat.o(23127);
            throw e4;
        } catch (Exception e5) {
            Log.e("MicroMsg.DBRecoveryTask", "Failed to repair database: " + e5.getMessage());
            c(4, "Failed to recover backup database", e5);
            recoverKit2.release();
            AppMethodBeat.o(23127);
            return -1;
        } catch (Throwable th) {
            recoverKit2.release();
            AppMethodBeat.o(23127);
            throw th;
        }
    }

    private int cBg() {
        AppMethodBeat.i(231690);
        try {
            this.qEq.execSQL("DELETE FROM rconversation WHERE typeof(flag) <> 'integer';", null, this.mCancellationSignal);
            AppMethodBeat.o(231690);
            return 0;
        } catch (OperationCanceledException e2) {
            AppMethodBeat.o(231690);
            throw e2;
        } catch (Exception e3) {
            Log.printErrStackTrace("MicroMsg.DBRecoveryTask", e3, "Verification failed", new Object[0]);
            AppMethodBeat.o(231690);
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.tencent.wcdb.database.SQLiteDatabase r8, int r9) {
        /*
        // Method dump skipped, instructions count: 129
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.a.a.a(com.tencent.wcdb.database.SQLiteDatabase, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x025b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0262  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int cBh() {
        /*
        // Method dump skipped, instructions count: 652
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.a.a.cBh():int");
    }

    /* access modifiers changed from: package-private */
    public static class c {
        final String name;
        final String oxJ;
        final boolean qEX;
        final boolean qEY;
        final String type;

        c(String str, String str2, boolean z, String str3, boolean z2) {
            this.name = str;
            this.type = str2;
            this.qEX = z;
            this.oxJ = str3;
            this.qEY = z2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<com.tencent.mm.plugin.dbbackup.a.a.c> a(com.tencent.wcdb.database.SQLiteDatabase r12, java.lang.String r13) {
        /*
        // Method dump skipped, instructions count: 151
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.a.a.a(com.tencent.wcdb.database.SQLiteDatabase, java.lang.String):java.util.List");
    }

    private int b(SQLiteDatabase sQLiteDatabase, String str) {
        int i2 = 0;
        AppMethodBeat.i(231694);
        List<c> a2 = a(sQLiteDatabase, str);
        List<c> a3 = a(this.qEq, str);
        if (a2 == null) {
            Log.e("MicroMsg.DBRecoveryTask", "ALTER TABLE detection for '%s' failed because no such table in source DB.");
            AppMethodBeat.o(231694);
            return -1;
        } else if (a3 == null) {
            Log.e("MicroMsg.DBRecoveryTask", "ALTER TABLE detection for '%s' failed because no such table in target DB.");
            AppMethodBeat.o(231694);
            return -1;
        } else if (a3.size() < a2.size()) {
            try {
                this.qEq.beginTransaction();
                StringBuilder sb = new StringBuilder();
                for (int size = a3.size(); size < a2.size(); size++) {
                    c cVar = a2.get(size);
                    sb.setLength(0);
                    sb.append("ALTER TABLE ").append(str).append(" ADD COLUMN ").append(cVar.name).append(' ').append(cVar.type);
                    if (cVar.qEX) {
                        sb.append(" NOT NULL");
                    }
                    if (cVar.oxJ != null && !cVar.oxJ.isEmpty()) {
                        sb.append(" DEFAULT (").append(cVar.oxJ).append(')');
                    }
                    sb.append(';');
                    String sb2 = sb.toString();
                    this.qEq.execSQL(sb2, null, this.mCancellationSignal);
                    Log.i("MicroMsg.DBRecoveryTask", ">>> ".concat(String.valueOf(sb2)));
                    i2++;
                }
                this.qEq.setTransactionSuccessful();
                return i2;
            } finally {
                if (this.qEq.inTransaction()) {
                    this.qEq.endTransaction();
                }
                AppMethodBeat.o(231694);
            }
        } else {
            AppMethodBeat.o(231694);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x017c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0183  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int a(com.tencent.wcdb.database.SQLiteDatabase r10, java.lang.String r11, int r12, boolean r13, int r14, com.tencent.mm.plugin.dbbackup.a.a.e r15) {
        /*
        // Method dump skipped, instructions count: 518
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.dbbackup.a.a.a(com.tencent.wcdb.database.SQLiteDatabase, java.lang.String, int, boolean, int, com.tencent.mm.plugin.dbbackup.a.a$e):int");
    }

    private static long akT(String str) {
        AppMethodBeat.i(23130);
        o oVar = new o(str);
        if (!oVar.isDirectory()) {
            oVar = oVar.heq();
        }
        do {
            long usableSpace = oVar.getUsableSpace();
            if (usableSpace > 0) {
                AppMethodBeat.o(23130);
                return usableSpace;
            }
            oVar = oVar.heq();
        } while (oVar != null);
        AppMethodBeat.o(23130);
        return 0;
    }

    private static void oA(int i2) {
        AppMethodBeat.i(23131);
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(181, (long) i2, 1, true);
        AppMethodBeat.o(23131);
    }

    @SuppressLint({"DefaultLocale"})
    private static void c(int i2, String str, Throwable th) {
        AppMethodBeat.i(23132);
        com.tencent.mm.plugin.report.e.INSTANCE.e("DBRepairNew", String.format("[Stage: %d] %s%s", Integer.valueOf(i2), str, "\n" + Util.stackTraceToString(th)), null);
        AppMethodBeat.o(23132);
    }
}
