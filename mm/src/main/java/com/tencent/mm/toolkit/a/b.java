package com.tencent.mm.toolkit.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.os.WorkSource;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.toolkit.a.a.c;
import com.tencent.mm.toolkit.a.d;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* access modifiers changed from: package-private */
public final class b implements c {
    private final a Ovm;
    private Context mContext;

    b(a aVar) {
        this.Ovm = aVar;
    }

    @Override // com.tencent.mm.toolkit.a.a.c
    public final void gS(Context context) {
        this.mContext = context;
    }

    @Override // com.tencent.mm.toolkit.a.a.c
    public final void b(c cVar) {
        AppMethodBeat.i(196804);
        Context context = this.mContext;
        a aVar = new a();
        if (context == null || android.support.v4.content.b.checkSelfPermission(context, "android.permission.WAKE_LOCK") != 0) {
            e.gGe();
        } else {
            aVar.hCN = ((PowerManager) context.getSystemService("power")).newWakeLock(1, e.TAG);
            if (!aVar.hCN.isHeld()) {
                aVar.hCN.setWorkSource(new WorkSource());
                aVar.hCN.acquire();
            }
            aVar.Ovn = ((WifiManager) context.getSystemService("wifi")).createWifiLock("WIFI LOCK : " + e.TAG);
            if (!aVar.Ovn.isHeld()) {
                aVar.Ovn.acquire();
            }
        }
        do {
            try {
                cVar.mState = 2010;
                c(cVar);
            } catch (com.tencent.mm.toolkit.a.a.a e2) {
                boolean z = e.DEBUG;
                int i2 = e2.mErrorCode;
                String localizedMessage = e2.getLocalizedMessage();
                cVar.mState = 2040;
                if (cVar.Ovs) {
                    if (e.DEBUG) {
                        new StringBuilder("clean up target file, path = ").append(cVar.Ovr.getPath());
                        e.gGd();
                    }
                    d.b.U(cVar.Ovr);
                    d.b.U(cVar.Ovq);
                }
                a.a(cVar, i2, localizedMessage);
                cVar.finish();
                return;
            } finally {
                aVar.release();
                AppMethodBeat.o(196804);
            }
        } while (cVar.mState == 2060);
    }

    private static int a(byte[] bArr, InputStream inputStream) {
        AppMethodBeat.i(196809);
        try {
            int read = inputStream.read(bArr);
            AppMethodBeat.o(196809);
            return read;
        } catch (IOException e2) {
            boolean z = e.DEBUG;
            if ("unexpected end of stream".equals(e2.getMessage())) {
                AppMethodBeat.o(196809);
                return -1;
            }
            AppMethodBeat.o(196809);
            return Integer.MIN_VALUE;
        }
    }

    private static boolean a(byte[] bArr, int i2, OutputStream outputStream, FileDescriptor fileDescriptor) {
        AppMethodBeat.i(196810);
        if (fileDescriptor.valid()) {
            try {
                outputStream.write(bArr, 0, i2);
                outputStream.flush();
                fileDescriptor.sync();
                AppMethodBeat.o(196810);
                return true;
            } catch (IOException e2) {
                boolean z = e.DEBUG;
                AppMethodBeat.o(196810);
                return false;
            }
        } else {
            if (e.DEBUG) {
                e.gGe();
            }
            AppMethodBeat.o(196810);
            return false;
        }
    }

    static class a {
        WifiManager.WifiLock Ovn;
        PowerManager.WakeLock hCN;

        a() {
        }

        public final void release() {
            AppMethodBeat.i(196803);
            try {
                if (this.hCN != null && this.hCN.isHeld()) {
                    this.hCN.release();
                }
                if (this.Ovn != null && this.Ovn.isHeld()) {
                    this.Ovn.release();
                }
                AppMethodBeat.o(196803);
            } catch (Throwable th) {
                boolean z = e.DEBUG;
                AppMethodBeat.o(196803);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x02b5  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009e A[Catch:{ all -> 0x0194 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01f3 A[SYNTHETIC, Splitter:B:73:0x01f3] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0214  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(com.tencent.mm.toolkit.a.c r11) {
        /*
        // Method dump skipped, instructions count: 802
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.toolkit.a.b.c(com.tencent.mm.toolkit.a.c):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.tencent.mm.toolkit.a.c r9, java.net.HttpURLConnection r10) {
        /*
            r4 = -1
            r0 = 1
            r8 = 196806(0x300c6, float:2.75784E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r8)
            long r2 = r9.mContentLength
            int r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0013
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
        L_0x0012:
            return r0
        L_0x0013:
            java.lang.String r1 = "Transfer-Encoding"
            java.lang.String r1 = r10.getHeaderField(r1)
            if (r1 == 0) goto L_0x0029
            java.lang.String r2 = "chunked"
            boolean r1 = r1.equalsIgnoreCase(r2)
            if (r1 == 0) goto L_0x0029
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
            goto L_0x0012
        L_0x0029:
            java.lang.String r1 = "Content-Length"
            java.lang.String r1 = r10.getHeaderField(r1)     // Catch:{ NumberFormatException -> 0x0041 }
            long r2 = java.lang.Long.parseLong(r1)     // Catch:{ NumberFormatException -> 0x0041 }
            long r6 = r9.Ovw     // Catch:{ NumberFormatException -> 0x004b }
            long r6 = r6 + r2
            r9.mContentLength = r6     // Catch:{ NumberFormatException -> 0x004b }
        L_0x0039:
            int r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0046
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
            goto L_0x0012
        L_0x0041:
            r1 = move-exception
            r2 = r4
        L_0x0043:
            boolean r1 = com.tencent.mm.toolkit.a.e.DEBUG
            goto L_0x0039
        L_0x0046:
            r0 = 0
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
            goto L_0x0012
        L_0x004b:
            r1 = move-exception
            goto L_0x0043
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.toolkit.a.b.a(com.tencent.mm.toolkit.a.c, java.net.HttpURLConnection):boolean");
    }

    private static boolean a(c cVar, File file) {
        AppMethodBeat.i(196807);
        if (!cVar.Ovu || !file.exists()) {
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                boolean createNewFile = file.createNewFile();
                AppMethodBeat.o(196807);
                return createNewFile;
            } catch (IOException e2) {
                boolean z = e.DEBUG;
                AppMethodBeat.o(196807);
                return false;
            }
        } else {
            AppMethodBeat.o(196807);
            return true;
        }
    }

    private static void a(c cVar, InputStream inputStream, OutputStream outputStream, FileDescriptor fileDescriptor) {
        AppMethodBeat.i(196808);
        cVar.mState = 2012;
        byte[] bArr = new byte[4096];
        long j2 = cVar.mContentLength;
        if (e.DEBUG) {
            new StringBuilder("Start transfer data, content length = ").append(j2).append(", id = ").append(cVar.mId);
            e.gGd();
        }
        while (!cVar.mCancelled) {
            int a2 = a(bArr, inputStream);
            long j3 = cVar.Ovw;
            System.currentTimeMillis();
            if (a2 == -1) {
                cVar.mState = TXLiteAVCode.EVT_VIDEO_DECODER_CACHE_TOO_MANY_FRAMES;
                try {
                    if (!cVar.Ovq.renameTo(cVar.Ovr)) {
                        com.tencent.mm.toolkit.a.a.a aVar = new com.tencent.mm.toolkit.a.a.a(1001, "Cannot rename intermediate file to dest file!");
                        AppMethodBeat.o(196808);
                        throw aVar;
                    }
                    if (cVar.OvA != null) {
                        cVar.OvA.d(cVar);
                    }
                    com.tencent.mm.toolkit.a.a.b bVar = cVar.OvC;
                    if (bVar != null) {
                        bVar.a(cVar);
                    }
                    cVar.finish();
                    AppMethodBeat.o(196808);
                    return;
                } catch (com.tencent.mm.toolkit.a.a.a e2) {
                    boolean z = e.DEBUG;
                    com.tencent.mm.toolkit.a.a.a aVar2 = new com.tencent.mm.toolkit.a.a.a(e2.mErrorCode, e2.getLocalizedMessage());
                    AppMethodBeat.o(196808);
                    throw aVar2;
                }
            } else if (a2 == Integer.MIN_VALUE) {
                com.tencent.mm.toolkit.a.a.a aVar3 = new com.tencent.mm.toolkit.a.a.a(1102, "Failed reading http response");
                AppMethodBeat.o(196808);
                throw aVar3;
            } else if (a(bArr, a2, outputStream, fileDescriptor)) {
                cVar.Ovw = j3 + ((long) a2);
            } else {
                com.tencent.mm.toolkit.a.a.a aVar4 = new com.tencent.mm.toolkit.a.a.a(1001, "Failed writing file");
                AppMethodBeat.o(196808);
                throw aVar4;
            }
        }
        if (e.DEBUG) {
            new StringBuilder("Stopping the download as Download Request is cancelled, id ").append(cVar.mId);
            e.gGd();
        }
        com.tencent.mm.toolkit.a.a.a aVar5 = new com.tencent.mm.toolkit.a.a.a(TXLiteAVCode.WARNING_MICROPHONE_DEVICE_EMPTY, "Download cancelled");
        AppMethodBeat.o(196808);
        throw aVar5;
    }
}
