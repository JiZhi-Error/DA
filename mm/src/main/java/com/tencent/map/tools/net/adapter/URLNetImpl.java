package com.tencent.map.tools.net.adapter;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.HttpURLConnection;

public class URLNetImpl extends AbsNetImpl {
    private static final boolean DEBUG = false;
    private static final String TAG = "URLNetImpl";
    private HttpURLConnection mCurrentConnect;

    /* access modifiers changed from: protected */
    @Override // com.tencent.map.tools.net.adapter.AbsNetImpl
    public void onCreateNet(Context context, Bundle bundle) {
        AppMethodBeat.i(180928);
        disableConnectionReuseIfNecessary();
        AppMethodBeat.o(180928);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0068, code lost:
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006e, code lost:
        r0.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00e8, code lost:
        r6.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x010e, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x010f, code lost:
        r4 = r1;
        r6 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x010e A[ExcHandler: IOException (r1v4 'e' java.io.IOException A[CUSTOM_DECLARE]), PHI: r5 
      PHI: (r5v2 int) = (r5v0 int), (r5v3 int) binds: [B:12:0x0027, B:41:0x00a1] A[DONT_GENERATE, DONT_INLINE], Splitter:B:12:0x0027] */
    @Override // com.tencent.map.tools.net.adapter.AbsNetImpl
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.map.tools.net.NetResponse onGetRequest(java.lang.String r10, java.lang.String r11, int r12, int r13, java.util.HashMap<java.lang.String, java.lang.String> r14, com.tencent.map.tools.net.http.HttpCanceler r15) {
        /*
        // Method dump skipped, instructions count: 282
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.tools.net.adapter.URLNetImpl.onGetRequest(java.lang.String, java.lang.String, int, int, java.util.HashMap, com.tencent.map.tools.net.http.HttpCanceler):com.tencent.map.tools.net.NetResponse");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ff, code lost:
        r7.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0131, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0132, code lost:
        r5 = r3;
        r9 = r2;
        r7 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x010c  */
    @Override // com.tencent.map.tools.net.adapter.AbsNetImpl
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.map.tools.net.NetResponse onPostRequest(java.lang.String r12, java.lang.String r13, byte[] r14, int r15, java.util.HashMap<java.lang.String, java.lang.String> r16, com.tencent.map.tools.net.http.HttpCanceler r17, int r18) {
        /*
        // Method dump skipped, instructions count: 330
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.tools.net.adapter.URLNetImpl.onPostRequest(java.lang.String, java.lang.String, byte[], int, java.util.HashMap, com.tencent.map.tools.net.http.HttpCanceler, int):com.tencent.map.tools.net.NetResponse");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0085, code lost:
        r0.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009a, code lost:
        r5.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a7, code lost:
        r5.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b5, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00b6, code lost:
        r4 = r1;
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c0, code lost:
        r2 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00c1, code lost:
        r4 = r1;
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00c8, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b5 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:13:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c0 A[ExcHandler: IOException (e java.io.IOException), PHI: r3 
      PHI: (r3v10 int) = (r3v0 int), (r3v11 int), (r3v11 int) binds: [B:13:0x0030, B:14:?, B:15:0x003f] A[DONT_GENERATE, DONT_INLINE], Splitter:B:13:0x0030] */
    @Override // com.tencent.map.tools.net.adapter.AbsNetImpl
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.tencent.map.tools.net.NetResponse onPostNoBuffer(java.lang.String r8, java.lang.String r9, byte[] r10) {
        /*
        // Method dump skipped, instructions count: 209
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.tools.net.adapter.URLNetImpl.onPostNoBuffer(java.lang.String, java.lang.String, byte[]):com.tencent.map.tools.net.NetResponse");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e1  */
    @Override // com.tencent.map.tools.net.adapter.AbsNetImpl
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRangePost(java.lang.String r7, byte[] r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, com.tencent.map.tools.net.http.HttpCanceler r13) {
        /*
        // Method dump skipped, instructions count: 260
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.map.tools.net.adapter.URLNetImpl.onRangePost(java.lang.String, byte[], java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.tencent.map.tools.net.http.HttpCanceler):void");
    }

    private void disableConnectionReuseIfNecessary() {
        AppMethodBeat.i(180933);
        if (Integer.parseInt(Build.VERSION.SDK) < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        AppMethodBeat.o(180933);
    }

    @Override // com.tencent.map.tools.net.NetAdapter
    public boolean cancel() {
        AppMethodBeat.i(180934);
        if (this.mCurrentConnect != null) {
            this.mCurrentConnect.disconnect();
            AppMethodBeat.o(180934);
            return true;
        }
        AppMethodBeat.o(180934);
        return false;
    }

    class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f1443a = true;

        /* renamed from: c  reason: collision with root package name */
        private int f1445c;

        a(int i2) {
            AppMethodBeat.i(180927);
            this.f1445c = i2;
            if (this.f1445c > 3) {
                this.f1445c = 3;
            }
            if (this.f1445c <= 0) {
                this.f1445c = 1;
            }
            AppMethodBeat.o(180927);
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return this.f1443a && this.f1445c > 0;
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            this.f1445c--;
        }
    }
}
