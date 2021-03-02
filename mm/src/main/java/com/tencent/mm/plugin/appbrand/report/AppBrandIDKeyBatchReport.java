package com.tencent.mm.plugin.appbrand.report;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.protocal.protobuf.dnf;
import com.tencent.mm.protocal.protobuf.fcl;
import com.tencent.mm.protocal.protobuf.fcm;
import com.tencent.mm.protocal.protobuf.fcq;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class AppBrandIDKeyBatchReport {
    private static final long nGk = TimeUnit.SECONDS.toMillis(30);
    private static volatile IDKeyBatchReportTask nGl;

    static /* synthetic */ String access$800() {
        AppMethodBeat.i(48038);
        String bUi = bUi();
        AppMethodBeat.o(48038);
        return bUi;
    }

    static /* synthetic */ IDKeyBatchReportTask bUl() {
        AppMethodBeat.i(227368);
        IDKeyBatchReportTask bUh = bUh();
        AppMethodBeat.o(227368);
        return bUh;
    }

    static {
        AppMethodBeat.i(227369);
        AppMethodBeat.o(227369);
    }

    private static IDKeyBatchReportTask bUh() {
        AppMethodBeat.i(48035);
        if (nGl == null) {
            nGl = new IDKeyBatchReportTask();
        }
        IDKeyBatchReportTask iDKeyBatchReportTask = nGl;
        AppMethodBeat.o(48035);
        return iDKeyBatchReportTask;
    }

    private static String bUi() {
        AppMethodBeat.i(48036);
        if (!g.aAc()) {
            com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
            AppMethodBeat.o(48036);
            throw bVar;
        }
        String str = g.aAh().cachePath;
        if (!str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            str = str + FilePathGenerator.ANDROID_DIR_SEP;
        }
        String str2 = str + "appbrand/report/";
        FilePathGenerator.checkMkdir(str2);
        AppMethodBeat.o(48036);
        return str2;
    }

    public static void ce(String str, int i2) {
        AppMethodBeat.i(227366);
        bUh().nGn = 1;
        bUh().nGp = str;
        bUh().nGq = i2;
        AppBrandMainProcessService.a(bUh());
        AppMethodBeat.o(227366);
    }

    public static void a(fcq fcq) {
        AppMethodBeat.i(48037);
        if (fcq == null) {
            AppMethodBeat.o(48037);
        } else if (MMApplicationContext.isMMProcess()) {
            b.c(fcq);
            AppMethodBeat.o(48037);
        } else {
            a.b(fcq);
            AppMethodBeat.o(48037);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class IDKeyBatchReportTask extends MainProcessTask {
        public static final Parcelable.Creator<IDKeyBatchReportTask> CREATOR = new Parcelable.Creator<IDKeyBatchReportTask>() {
            /* class com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.IDKeyBatchReportTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ IDKeyBatchReportTask[] newArray(int i2) {
                return new IDKeyBatchReportTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ IDKeyBatchReportTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(48016);
                IDKeyBatchReportTask iDKeyBatchReportTask = new IDKeyBatchReportTask(parcel);
                AppMethodBeat.o(48016);
                return iDKeyBatchReportTask;
            }
        };
        int nGn;
        int nGo;
        String nGp;
        int nGq;
        fcq nGr;

        IDKeyBatchReportTask() {
        }

        IDKeyBatchReportTask(Parcel parcel) {
            AppMethodBeat.i(48017);
            f(parcel);
            AppMethodBeat.o(48017);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(48018);
            if (1 == this.nGn) {
                if (!Util.isNullOrNil(this.nGp) && g.aAf().hpY) {
                    Pair<Boolean, Integer> J = ((com.tencent.mm.plugin.appbrand.appcache.predownload.e.b) n.W(com.tencent.mm.plugin.appbrand.appcache.predownload.e.b.class)).J(this.nGp, 5, this.nGq);
                    if (((Boolean) J.first).booleanValue()) {
                        Log.i("MicroMsg.AppBrandIDKeyBatchReport", "report blocked by appid(%s) scene(%d) ", this.nGp, Integer.valueOf(this.nGq));
                        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a aVar = com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.INSTANCE;
                        com.tencent.mm.plugin.appbrand.appcache.predownload.c.a.F((long) ((Integer) J.second).intValue(), 167);
                        AppMethodBeat.o(48018);
                        return;
                    }
                }
                b.sz(0);
                b.access$300();
                AppMethodBeat.o(48018);
            } else if (2 == this.nGn) {
                b.Wz();
                AppMethodBeat.o(48018);
            } else {
                if (3 == this.nGn) {
                    b.c(this.nGr);
                }
                AppMethodBeat.o(48018);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(48019);
            this.nGn = parcel.readInt();
            this.nGo = parcel.readInt();
            this.nGp = parcel.readString();
            this.nGq = parcel.readInt();
            if (3 == this.nGn) {
                try {
                    this.nGr = new fcq();
                    this.nGr.parseFrom(parcel.createByteArray());
                    AppMethodBeat.o(48019);
                    return;
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandIDKeyBatchReport", "parse WxaAppRecord from parcel, e = %s", e2);
                    this.nGr = null;
                }
            }
            AppMethodBeat.o(48019);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(48020);
            parcel.writeInt(this.nGn);
            parcel.writeInt(this.nGo);
            parcel.writeString(this.nGp);
            parcel.writeInt(this.nGq);
            if (3 == this.nGn) {
                try {
                    parcel.writeByteArray(this.nGr.toByteArray());
                    AppMethodBeat.o(48020);
                    return;
                } catch (Exception e2) {
                    Log.e("MicroMsg.AppBrandIDKeyBatchReport", "write WxaAppRecord to parcel, e = %s", e2);
                }
            }
            AppMethodBeat.o(48020);
        }

        static {
            AppMethodBeat.i(48021);
            AppMethodBeat.o(48021);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class b {
        private static final ReentrantReadWriteLock nGs = new ReentrantReadWriteLock();
        private static volatile MTimerHandler nGt = null;
        private static volatile MTimerHandler nGu = null;
        private static volatile int nGv;

        static /* synthetic */ void Wz() {
            AppMethodBeat.i(48032);
            bUm();
            AppMethodBeat.o(48032);
        }

        static {
            AppMethodBeat.i(48034);
            AppMethodBeat.o(48034);
        }

        private static void bUm() {
            AppMethodBeat.i(48026);
            if (nGt != null) {
                nGt.stopTimer();
                nGt = null;
            }
            AppMethodBeat.o(48026);
        }

        private static LinkedList<fcq> bUn() {
            int i2 = 0;
            AppMethodBeat.i(48027);
            nGs.readLock().lock();
            try {
                o oVar = new o(AppBrandIDKeyBatchReport.bUk());
                if (!oVar.exists()) {
                    Log.d("MicroMsg.AppBrandIDKeyBatchReport", "reportFile not exist!");
                    nGs.readLock().unlock();
                    bUo();
                    AppMethodBeat.o(48027);
                    return null;
                }
                LinkedList<fcq> linkedList = new LinkedList<>();
                long length = oVar.length();
                while (true) {
                    byte[] aW = s.aW(AppBrandIDKeyBatchReport.bUk(), i2, 4);
                    if (aW != null) {
                        int readInt = new DataInputStream(new ByteArrayInputStream(aW)).readInt();
                        byte[] aW2 = s.aW(AppBrandIDKeyBatchReport.bUk(), i2 + 4, readInt);
                        if (Util.isNullOrNil(aW2)) {
                            break;
                        }
                        linkedList.add((fcq) new fcq().parseFrom(aW2));
                        i2 = readInt + 4 + i2;
                        if (((long) i2) >= length) {
                            break;
                        }
                    } else {
                        Log.e("MicroMsg.AppBrandIDKeyBatchReport", "preData is null!");
                        nGs.readLock().unlock();
                        bUo();
                        AppMethodBeat.o(48027);
                        return null;
                    }
                }
                nGs.readLock().unlock();
                bUo();
                AppMethodBeat.o(48027);
                return linkedList;
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandIDKeyBatchReport", "read file error %s", e2.getMessage());
                Log.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e2, "readReportData()", new Object[0]);
                nGs.readLock().unlock();
                bUo();
                AppMethodBeat.o(48027);
                return null;
            } catch (OutOfMemoryError e3) {
                Log.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e3, "readReportData()", new Object[0]);
                nGs.readLock().unlock();
                AppMethodBeat.o(48027);
                return null;
            } catch (Throwable th) {
                nGs.readLock().unlock();
                bUo();
                AppMethodBeat.o(48027);
                throw th;
            }
        }

        private static void bUo() {
            AppMethodBeat.i(48028);
            nGs.writeLock().lock();
            try {
                s.deleteFile(AppBrandIDKeyBatchReport.bUk());
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e2, "removeFile()", new Object[0]);
            }
            nGs.writeLock().unlock();
            AppMethodBeat.o(48028);
        }

        static /* synthetic */ void c(final fcq fcq) {
            AppMethodBeat.i(48029);
            if (fcq == null) {
                AppMethodBeat.o(48029);
                return;
            }
            h.RTc.b(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.b.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(48025);
                    b.d(fcq);
                    AppMethodBeat.o(48025);
                }
            }, "MicroMsg.AppBrandIDKeyBatchReport");
            AppMethodBeat.o(48029);
        }

        static /* synthetic */ void sz(int i2) {
            long j2;
            AppMethodBeat.i(48030);
            Log.i("MicroMsg.AppBrandIDKeyBatchReport", "startTimeCount duration:%d", Integer.valueOf(i2));
            if (i2 <= 0) {
                j2 = 1 * AppBrandIDKeyBatchReport.nGk;
            } else {
                j2 = ((long) i2) * AppBrandIDKeyBatchReport.nGk;
            }
            bUm();
            MTimerHandler mTimerHandler = new MTimerHandler("MicroMsg.AppBrandIDKeyBatchReport", (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.b.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(48023);
                    Log.d("MicroMsg.AppBrandIDKeyBatchReport", "startReport run in TimerTask!");
                    b.access$300();
                    AppMethodBeat.o(48023);
                    return true;
                }
            }, true);
            nGt = mTimerHandler;
            mTimerHandler.startTimer(j2);
            AppMethodBeat.o(48030);
        }

        static /* synthetic */ void access$300() {
            boolean z;
            long j2;
            AppMethodBeat.i(48031);
            final LinkedList<fcq> bUn = bUn();
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(bUn == null ? -1 : bUn.size());
            Log.i("MicroMsg.AppBrandIDKeyBatchReport", "reportToSvr, data.size=%d", objArr);
            if (Util.isNullOrNil(bUn)) {
                z = false;
            } else {
                d.a aVar = new d.a();
                aVar.iLN = new fcl();
                aVar.iLO = new fcm();
                aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxaappidkeybatchreport";
                aVar.funcId = 1009;
                aVar.iLP = 0;
                aVar.respCmdId = 0;
                d aXF = aVar.aXF();
                dnf dnf = new dnf();
                dnf.oUj = Build.MANUFACTURER;
                dnf.MQy = 2;
                dnf.hid = com.tencent.mm.protocal.d.KyJ;
                dnf.hie = com.tencent.mm.protocal.d.KyI;
                dnf.Dqw = MMApplicationContext.getResources().getDisplayMetrics().widthPixels;
                dnf.MQz = MMApplicationContext.getResources().getDisplayMetrics().heightPixels;
                dnf.hif = com.tencent.mm.protocal.d.KyL;
                dnf.hig = com.tencent.mm.protocal.d.KyM;
                dnf.pLl = MMApplicationContext.getResources().getConfiguration().locale.getLanguage();
                ((fcl) aXF.iLK.iLR).Nyq = dnf;
                ((fcl) aXF.iLK.iLR).Nyp = bUn;
                aa.a(aXF, new aa.a() {
                    /* class com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.b.AnonymousClass3 */

                    @Override // com.tencent.mm.ak.aa.a
                    public final int a(int i2, int i3, String str, d dVar, q qVar) {
                        AppMethodBeat.i(48024);
                        Log.i("MicroMsg.AppBrandIDKeyBatchReport", "reportToSvr, cgi back, errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                        if (i2 == 0 && i3 == 0) {
                            int unused = b.nGv = ((fcm) dVar.iLL.iLR).Nyr;
                            b.sz(b.nGv);
                        } else {
                            Iterator it = bUn.iterator();
                            while (it.hasNext()) {
                                b.d((fcq) it.next());
                            }
                        }
                        AppMethodBeat.o(48024);
                        return 0;
                    }
                }, true);
                z = true;
            }
            if (z) {
                int i2 = nGv;
                if (i2 <= 0) {
                    j2 = 5 * AppBrandIDKeyBatchReport.nGk;
                } else {
                    j2 = ((long) (i2 + 5)) * AppBrandIDKeyBatchReport.nGk;
                }
                if (nGu != null) {
                    nGu.stopTimer();
                    nGu = null;
                }
                MTimerHandler mTimerHandler = new MTimerHandler("MicroMsg.AppBrandIDKeyBatchReport", (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                    /* class com.tencent.mm.plugin.appbrand.report.AppBrandIDKeyBatchReport.b.AnonymousClass1 */

                    @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                    public final boolean onTimerExpired() {
                        AppMethodBeat.i(48022);
                        b.Wz();
                        Log.d("MicroMsg.AppBrandIDKeyBatchReport", "on timer expired in monitor timer!");
                        AppMethodBeat.o(48022);
                        return true;
                    }
                }, false);
                nGu = mTimerHandler;
                mTimerHandler.startTimer(j2);
            }
            AppMethodBeat.o(48031);
        }

        static /* synthetic */ void d(fcq fcq) {
            AppMethodBeat.i(227365);
            Log.i("MicroMsg.AppBrandIDKeyBatchReport", "writeReportData type:%d", Integer.valueOf(fcq.oUv));
            nGs.writeLock().lock();
            try {
                byte[] byteArray = fcq.toByteArray();
                o oVar = new o(AppBrandIDKeyBatchReport.access$800());
                if (!oVar.exists()) {
                    oVar.mkdirs();
                }
                o oVar2 = new o(AppBrandIDKeyBatchReport.bUk());
                if (!oVar2.exists()) {
                    oVar2.createNewFile();
                }
                int length = byteArray.length;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                new DataOutputStream(byteArrayOutputStream).writeInt(length);
                byte[] byteArray2 = byteArrayOutputStream.toByteArray();
                s.e(AppBrandIDKeyBatchReport.bUk(), byteArray2, byteArray2.length);
                s.e(AppBrandIDKeyBatchReport.bUk(), byteArray, byteArray.length);
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrandIDKeyBatchReport", "appendToFile exception:%s", e2.getMessage());
                Log.printErrStackTrace("MicroMsg.AppBrandIDKeyBatchReport", e2, "", new Object[0]);
            } finally {
                nGs.writeLock().unlock();
                AppMethodBeat.o(227365);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a {
        private static final byte[] nGm = new byte[0];

        static /* synthetic */ void b(fcq fcq) {
            AppMethodBeat.i(48015);
            synchronized (nGm) {
                try {
                    AppBrandIDKeyBatchReport.bUl().nGr = fcq;
                    AppBrandIDKeyBatchReport.bUl().nGn = 3;
                    AppBrandMainProcessService.a(AppBrandIDKeyBatchReport.bUl());
                } finally {
                    AppMethodBeat.o(48015);
                }
            }
        }
    }

    static /* synthetic */ String bUk() {
        AppMethodBeat.i(227367);
        String str = bUi() + "WxaAppRecord";
        AppMethodBeat.o(227367);
        return str;
    }
}
