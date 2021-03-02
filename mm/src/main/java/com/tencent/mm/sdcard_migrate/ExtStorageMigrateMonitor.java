package com.tencent.mm.sdcard_migrate;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.d;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.PeriodRecorder;
import com.tencent.mm.vending.g.g;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class ExtStorageMigrateMonitor {
    private static final String CURRENT_PROCESS_NAME = d.cQi;
    private static final PeriodRecorder NGR = new PeriodRecorder("ExtStorageMigrateMonitor", TimeUnit.DAYS.toMillis(1), true, true);
    private static final boolean[] NGS = {false};
    private static final PendingOps NGT = new PendingOps((byte) 0);
    private static final a NGU = new a() {
        /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.AnonymousClass1 */

        private static void a(int i2, String str, Throwable th, String str2, Object... objArr) {
            String str3;
            AppMethodBeat.i(176852);
            String str4 = "[@" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH).format(new Date()) + "|" + ExtStorageMigrateMonitor.CURRENT_PROCESS_NAME + "]";
            if (objArr == null || objArr.length == 0) {
                str3 = str4 + str2;
            } else {
                str3 = str4 + String.format(str2, objArr);
            }
            if (th != null) {
                StringWriter stringWriter = new StringWriter();
                PrintWriter printWriter = new PrintWriter(stringWriter);
                th.printStackTrace(printWriter);
                printWriter.flush();
                str3 = str3 + "\n" + stringWriter.toString();
                printWriter.close();
            }
            synchronized (ExtStorageMigrateMonitor.NGS) {
                try {
                    if (ExtStorageMigrateMonitor.NGS[0]) {
                        ExtStorageMigrateMonitor.V(i2, str, str3);
                    } else if (i2 != 3) {
                        ExtStorageMigrateMonitor.NGT.W(i2, str, str3);
                    }
                } finally {
                    AppMethodBeat.o(176852);
                }
            }
        }

        @Override // com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.a
        public final void d(String str, String str2, Object... objArr) {
            AppMethodBeat.i(197146);
            Log.d(str, str2, objArr);
            a(3, str, null, str2, objArr);
            AppMethodBeat.o(197146);
        }

        @Override // com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.a
        public final void i(String str, String str2, Object... objArr) {
            AppMethodBeat.i(176853);
            Log.i(str, str2, objArr);
            a(4, str, null, str2, objArr);
            AppMethodBeat.o(176853);
        }

        @Override // com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.a
        public final void w(String str, String str2, Object... objArr) {
            AppMethodBeat.i(176854);
            Log.w(str, str2, objArr);
            a(5, str, null, str2, objArr);
            AppMethodBeat.o(176854);
        }

        @Override // com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.a
        public final void e(String str, String str2, Object... objArr) {
            AppMethodBeat.i(176855);
            Log.e(str, str2, objArr);
            a(6, str, null, str2, objArr);
            AppMethodBeat.o(176855);
        }

        @Override // com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.a
        public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
            AppMethodBeat.i(176856);
            Log.printErrStackTrace(str, th, str2, objArr);
            a(6, str, th, str2, objArr);
            AppMethodBeat.o(176856);
        }
    };

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static /* synthetic */ PendingOps gwQ() {
        AppMethodBeat.i(197158);
        PendingOps gwM = gwM();
        AppMethodBeat.o(197158);
        return gwM;
    }

    static /* synthetic */ void q(long j2, long j3, long j4) {
        AppMethodBeat.i(197159);
        p(j2, j3, j4);
        AppMethodBeat.o(197159);
    }

    static {
        AppMethodBeat.i(176861);
        AppMethodBeat.o(176861);
    }

    /* access modifiers changed from: package-private */
    public static class PendingOps implements Parcelable {
        public static final Parcelable.Creator<PendingOps> CREATOR = new Parcelable.Creator<PendingOps>() {
            /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.PendingOps.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ PendingOps[] newArray(int i2) {
                return new PendingOps[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ PendingOps createFromParcel(Parcel parcel) {
                AppMethodBeat.i(197147);
                int readInt = parcel.readInt();
                if (readInt != -33554431) {
                    IllegalStateException illegalStateException = new IllegalStateException("Version mismatch, expected: " + Integer.toHexString(-33554431) + ", got: " + Integer.toHexString(readInt));
                    AppMethodBeat.o(197147);
                    throw illegalStateException;
                }
                PendingOps pendingOps = new PendingOps((byte) 0);
                int readInt2 = parcel.readInt();
                for (int i2 = 0; i2 < readInt2; i2++) {
                    pendingOps.r(parcel.readLong(), parcel.readLong(), parcel.readLong());
                }
                int readInt3 = parcel.readInt();
                for (int i3 = 0; i3 < readInt3; i3++) {
                    pendingOps.W(parcel.readInt(), parcel.readString(), parcel.readString());
                }
                AppMethodBeat.o(197147);
                return pendingOps;
            }
        };
        private final List<a> NGV;
        private final List<b> NGW;

        private PendingOps() {
            AppMethodBeat.i(197150);
            this.NGV = Collections.synchronizedList(new ArrayList(16));
            this.NGW = Collections.synchronizedList(new ArrayList(32));
            AppMethodBeat.o(197150);
        }

        /* synthetic */ PendingOps(byte b2) {
            this();
        }

        /* access modifiers changed from: package-private */
        public static class a {
            long id;
            long key;
            long value;

            a(long j2, long j3, long j4) {
                this.id = j2;
                this.key = j3;
                this.value = j4;
            }

            public final String toString() {
                AppMethodBeat.i(197148);
                String str = "IDKeyOp {id:" + this.id + ", key:" + this.key + ", value:" + this.value + "}";
                AppMethodBeat.o(197148);
                return str;
            }
        }

        /* access modifiers changed from: package-private */
        public static class b {
            int level;
            String msg;
            String tag;

            b(int i2, String str, String str2) {
                this.level = i2;
                this.tag = str;
                this.msg = str2;
            }

            public final String toString() {
                AppMethodBeat.i(197149);
                String str = "LogOp {level:" + this.level + ", tag:" + this.tag + ", msg:" + this.msg + "}";
                AppMethodBeat.o(197149);
                return str;
            }
        }

        /* access modifiers changed from: package-private */
        public final void r(long j2, long j3, long j4) {
            AppMethodBeat.i(197151);
            this.NGV.add(new a(j2, j3, j4));
            AppMethodBeat.o(197151);
        }

        /* access modifiers changed from: package-private */
        public final void W(int i2, String str, String str2) {
            AppMethodBeat.i(197152);
            this.NGW.add(new b(i2, str, str2));
            AppMethodBeat.o(197152);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(197153);
            parcel.writeInt(-33554431);
            parcel.writeInt(this.NGV.size());
            for (a aVar : this.NGV) {
                parcel.writeLong(aVar.id);
                parcel.writeLong(aVar.key);
                parcel.writeLong(aVar.value);
            }
            parcel.writeInt(this.NGW.size());
            for (b bVar : this.NGW) {
                parcel.writeInt(bVar.level);
                parcel.writeString(bVar.tag);
                parcel.writeString(bVar.msg);
            }
            AppMethodBeat.o(197153);
        }

        static {
            AppMethodBeat.i(197154);
            AppMethodBeat.o(197154);
        }
    }

    public static void ME(long j2) {
        AppMethodBeat.i(176859);
        if (!NGR.isExpired("idkey_1315_" + j2)) {
            AppMethodBeat.o(176859);
            return;
        }
        synchronized (NGS) {
            try {
                if (NGS[0]) {
                    p(1315, j2, 1);
                } else {
                    NGT.r(1315, j2, 1);
                }
            } finally {
                AppMethodBeat.o(176859);
            }
        }
    }

    public static a gwK() {
        return NGU;
    }

    private static void p(long j2, long j3, long j4) {
        AppMethodBeat.i(185089);
        e.INSTANCE.idkeyStat(j2, j3, j4, true);
        AppMethodBeat.o(185089);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.PendingOps gwM() {
        /*
            r1 = 0
            r5 = 0
            r6 = 197155(0x30223, float:2.76273E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            java.lang.String r0 = "mmkv_extstg_mon_pending_ops"
            com.tencent.mm.sdk.platformtools.MultiProcessMMKV r0 = com.tencent.mm.sdk.platformtools.MultiProcessMMKV.getMMKV(r0)     // Catch:{ Throwable -> 0x0044 }
            java.lang.String r2 = "mmkv_key_pendingops"
            byte[] r0 = r0.decodeBytes(r2)     // Catch:{ Throwable -> 0x0044 }
            if (r0 == 0) goto L_0x0057
            android.os.Parcel r2 = android.os.Parcel.obtain()     // Catch:{ all -> 0x0036 }
            r3 = 0
            int r4 = r0.length     // Catch:{ all -> 0x005c }
            r2.unmarshall(r0, r3, r4)     // Catch:{ all -> 0x005c }
            r0 = 0
            r2.setDataPosition(r0)     // Catch:{ all -> 0x005c }
            android.os.Parcelable$Creator<com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor$PendingOps> r0 = com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.PendingOps.CREATOR     // Catch:{ all -> 0x005c }
            java.lang.Object r0 = r0.createFromParcel(r2)     // Catch:{ all -> 0x005c }
            com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor$PendingOps r0 = (com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.PendingOps) r0     // Catch:{ all -> 0x005c }
            if (r2 == 0) goto L_0x0032
            r2.recycle()
        L_0x0032:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
        L_0x0035:
            return r0
        L_0x0036:
            r0 = move-exception
            r2 = r1
        L_0x0038:
            if (r2 == 0) goto L_0x003d
            r2.recycle()
        L_0x003d:
            r2 = 197155(0x30223, float:2.76273E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            throw r0
        L_0x0044:
            r0 = move-exception
            com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor$a r2 = com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.NGU
            java.lang.String r3 = "MicroMsg.ExtStorageMigrateMonitor"
            java.lang.String r4 = "[-] Fail to load from persist storage."
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r2.printErrStackTrace(r3, r0, r4, r5)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            r0 = r1
            goto L_0x0035
        L_0x0057:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            r0 = r1
            goto L_0x0035
        L_0x005c:
            r0 = move-exception
            goto L_0x0038
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.gwM():com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor$PendingOps");
    }

    public static void gwN() {
        AppMethodBeat.i(197156);
        try {
            PendingOps pendingOps = new PendingOps((byte) 0);
            MultiProcessMMKV mmkv = MultiProcessMMKV.getMMKV("mmkv_extstg_mon_pending_ops");
            PendingOps gwM = gwM();
            if (gwM != null) {
                pendingOps.NGV.addAll(gwM.NGV);
                pendingOps.NGW.addAll(gwM.NGW);
            }
            pendingOps.NGV.addAll(NGT.NGV);
            pendingOps.NGW.addAll(NGT.NGW);
            Parcel parcel = null;
            try {
                parcel = Parcel.obtain();
                pendingOps.writeToParcel(parcel, 0);
                mmkv.encode("mmkv_key_pendingops", parcel.marshall());
                if (parcel != null) {
                    parcel.recycle();
                }
                NGT.NGV.clear();
                NGT.NGW.clear();
                AppMethodBeat.o(197156);
            } catch (Throwable th) {
                if (parcel != null) {
                    parcel.recycle();
                }
                AppMethodBeat.o(197156);
                throw th;
            }
        } catch (Throwable th2) {
            NGU.printErrStackTrace("MicroMsg.ExtStorageMigrateMonitor", th2, "[-] Fail to flush to persist storage.", new Object[0]);
            AppMethodBeat.o(197156);
        }
    }

    public static void gwL() {
        AppMethodBeat.i(176860);
        if (!d.cQi.equals(d.dks.getApplication().getPackageName())) {
            AppMethodBeat.o(176860);
            return;
        }
        g.hdG().Oc(500).d(new com.tencent.mm.vending.c.a<Void, Void>() {
            /* class com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.vending.c.a
            public final /* synthetic */ Void call(Void r3) {
                AppMethodBeat.i(176858);
                Void buw = buw();
                AppMethodBeat.o(176858);
                return buw;
            }

            private static Void buw() {
                AppMethodBeat.i(176857);
                synchronized (ExtStorageMigrateMonitor.NGS) {
                    try {
                        ExtStorageMigrateMonitor.NGS[0] = true;
                    } catch (Throwable th) {
                        AppMethodBeat.o(176857);
                        throw th;
                    }
                }
                PendingOps gwQ = ExtStorageMigrateMonitor.gwQ();
                if (gwQ != null) {
                    for (PendingOps.a aVar : gwQ.NGV) {
                        ExtStorageMigrateMonitor.q(aVar.id, aVar.key, aVar.value);
                    }
                    for (PendingOps.b bVar : gwQ.NGW) {
                        ExtStorageMigrateMonitor.V(bVar.level, bVar.tag, bVar.msg);
                    }
                    ExtStorageMigrateMonitor.gwR();
                }
                for (PendingOps.a aVar2 : ExtStorageMigrateMonitor.NGT.NGV) {
                    ExtStorageMigrateMonitor.q(aVar2.id, aVar2.key, aVar2.value);
                }
                ExtStorageMigrateMonitor.NGT.NGV.clear();
                for (PendingOps.b bVar2 : ExtStorageMigrateMonitor.NGT.NGW) {
                    ExtStorageMigrateMonitor.V(bVar2.level, bVar2.tag, bVar2.msg);
                }
                ExtStorageMigrateMonitor.NGT.NGW.clear();
                AppMethodBeat.o(176857);
                return null;
            }
        });
        AppMethodBeat.o(176860);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    static /* synthetic */ void V(int i2, String str, String str2) {
        AppMethodBeat.i(197157);
        switch (i2) {
            case 2:
                Log.v(str, str2);
                AppMethodBeat.o(197157);
                return;
            case 3:
                Log.d(str, str2);
                AppMethodBeat.o(197157);
                return;
            case 4:
                Log.i(str, str2);
                AppMethodBeat.o(197157);
                return;
            case 5:
                Log.w(str, str2);
                AppMethodBeat.o(197157);
                return;
            case 6:
                Log.e(str, str2);
                break;
        }
        AppMethodBeat.o(197157);
    }

    static /* synthetic */ void gwR() {
        AppMethodBeat.i(197160);
        try {
            MultiProcessMMKV.getMMKV("mmkv_extstg_mon_pending_ops").removeValueForKey("mmkv_key_pendingops");
            AppMethodBeat.o(197160);
        } catch (Throwable th) {
            NGU.printErrStackTrace("MicroMsg.ExtStorageMigrateMonitor", th, "[-] Fail to clear persisted ops.", new Object[0]);
            AppMethodBeat.o(197160);
        }
    }
}
