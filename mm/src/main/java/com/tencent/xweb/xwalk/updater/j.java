package com.tencent.xweb.xwalk.updater;

import android.os.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.http.HttpClientWrapper;
import java.util.Timer;
import java.util.TimerTask;
import org.xwalk.core.XWalkInitializer;

public final class j extends AsyncTask<a, b, c> {
    private a SJA = null;
    private int SJB = 0;
    private long SJC = 0;
    private b SJz = null;
    private Timer mTimer = null;

    public static class a {
        public boolean SJE;
        public String mFilePath;
        public String mUrl;
    }

    public static class b {
        public long SJF;
        public long mTotalSize;
        public String mUrl;
    }

    public static class c {
        public int SJG;
        public int SJH;
        public long baN;
        public String lAr;
        public String mFilePath;
        public int mNetWorkType;
        public int mRetryTimes;
        public long mTotalSize;
        public String mUrl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ c doInBackground(a[] aVarArr) {
        AppMethodBeat.i(154587);
        c a2 = a(aVarArr);
        AppMethodBeat.o(154587);
        return a2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(c cVar) {
        boolean z = false;
        AppMethodBeat.i(154586);
        c cVar2 = cVar;
        if (cVar2 == null) {
            cVar2 = new c();
            cVar2.SJG = HttpClientWrapper.RET_CODE_FILE_NOT_FOUND;
            XWalkInitializer.addXWalkInitializeLog("XWebHttpTask invalid params para onPostExecute");
        }
        if (cVar2.SJG == 0) {
            XWalkInitializer.addXWalkInitializeLog("task succeed! ");
            this.SJz.a(cVar2);
            AppMethodBeat.o(154586);
            return;
        }
        XWalkInitializer.addXWalkInitializeLog("task failed! retcode = " + cVar2.SJG + " mRetrytimes = " + this.SJB);
        if (!(this.SJB >= 2 || cVar2.SJG == -10001 || cVar2.SJG == -10004)) {
            z = true;
        }
        if (z) {
            this.SJB++;
            XWalkInitializer.addXWalkInitializeLog("task retry!  mRetrytimes = " + this.SJB);
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask() {
                /* class com.tencent.xweb.xwalk.updater.j.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(154583);
                    XWalkInitializer.addXWalkInitializeLog("task retry execute ! mRetrytimes = " + j.this.SJB);
                    j.a(j.this.SJA, j.this.SJz, j.this.SJB);
                    j.d(j.this);
                    AppMethodBeat.o(154583);
                }
            }, 3000 * ((long) this.SJB));
            AppMethodBeat.o(154586);
            return;
        }
        this.SJz.b(cVar2);
        AppMethodBeat.o(154586);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onProgressUpdate(b[] bVarArr) {
    }

    public static void a(a aVar, b bVar) {
        AppMethodBeat.i(154584);
        j jVar = new j();
        jVar.SJz = bVar;
        jVar.SJA = aVar;
        jVar.SJB = 0;
        jVar.SJC = System.currentTimeMillis();
        jVar.execute(jVar.SJA);
        AppMethodBeat.o(154584);
    }

    /* access modifiers changed from: protected */
    public final void onPreExecute() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x024b A[SYNTHETIC, Splitter:B:59:0x024b] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0250 A[Catch:{ IOException -> 0x02c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0255  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x02eb A[SYNTHETIC, Splitter:B:86:0x02eb] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02f0 A[Catch:{ IOException -> 0x02ff }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x02f5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.xweb.xwalk.updater.j.c a(com.tencent.xweb.xwalk.updater.j.a... r13) {
        /*
        // Method dump skipped, instructions count: 815
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.xwalk.updater.j.a(com.tencent.xweb.xwalk.updater.j$a[]):com.tencent.xweb.xwalk.updater.j$c");
    }

    static /* synthetic */ void a(a aVar, b bVar, int i2) {
        AppMethodBeat.i(154588);
        j jVar = new j();
        jVar.SJz = bVar;
        jVar.SJA = aVar;
        jVar.SJB = i2;
        jVar.SJC = System.currentTimeMillis();
        jVar.execute(jVar.SJA);
        AppMethodBeat.o(154588);
    }

    static /* synthetic */ void d(j jVar) {
        AppMethodBeat.i(154589);
        if (jVar.mTimer != null) {
            jVar.mTimer.cancel();
            jVar.mTimer = null;
        }
        AppMethodBeat.o(154589);
    }
}
