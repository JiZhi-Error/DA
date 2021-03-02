package com.tencent.mm.sdk.http;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;

public class HttpURLConnectionWrapper extends HttpWrapperBase {
    public static final String DEF_ATTACH_NAME = "default_attach_name";
    private static final String TAG = "MicroMsg.HttpURLConnectionWrapper";
    private HttpURLConnection conn = null;

    public HttpURLConnectionWrapper(HttpURLConnection httpURLConnection) {
        this.conn = httpURLConnection;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01c5, code lost:
        r12.conn.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01ea, code lost:
        r1 = 500;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01ec, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01ed, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(com.tencent.mm.sdk.http.HttpURLConnectionWrapper.TAG, r1, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01f9, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01fa, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(com.tencent.mm.sdk.http.HttpURLConnectionWrapper.TAG, r1, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0206, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0207, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(com.tencent.mm.sdk.http.HttpURLConnectionWrapper.TAG, r2, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0213, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0214, code lost:
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(com.tencent.mm.sdk.http.HttpURLConnectionWrapper.TAG, r2, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x022d, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x022e, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0244, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0245, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0183, code lost:
        r1 = 503;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0195, code lost:
        r12.conn.disconnect();
        com.tencent.matrix.trace.core.AppMethodBeat.o(157518);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x01c5  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x022d A[ExcHandler: all (th java.lang.Throwable), Splitter:B:14:0x0099] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x014f A[EDGE_INSN: B:138:0x014f->B:61:0x014f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00f6 A[Catch:{ Exception -> 0x00fe }, LOOP:0: B:34:0x00f0->B:36:0x00f6, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010d A[Catch:{ all -> 0x024c }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0113 A[SYNTHETIC, Splitter:B:45:0x0113] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x012c A[SYNTHETIC, Splitter:B:49:0x012c] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0131 A[SYNTHETIC, Splitter:B:52:0x0131] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015b  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0183 A[Catch:{ all -> 0x01b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0189 A[SYNTHETIC, Splitter:B:75:0x0189] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x018e A[SYNTHETIC, Splitter:B:78:0x018e] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01b9 A[SYNTHETIC, Splitter:B:93:0x01b9] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01be A[SYNTHETIC, Splitter:B:96:0x01be] */
    @Override // com.tencent.mm.sdk.http.HttpWrapperBase
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void send(com.tencent.mm.sdk.http.HttpWrapperBase.Request r13, com.tencent.mm.sdk.http.HttpWrapperBase.Response r14) {
        /*
        // Method dump skipped, instructions count: 597
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.http.HttpURLConnectionWrapper.send(com.tencent.mm.sdk.http.HttpWrapperBase$Request, com.tencent.mm.sdk.http.HttpWrapperBase$Response):void");
    }

    @Override // com.tencent.mm.sdk.http.HttpWrapperBase
    public void cancel() {
        AppMethodBeat.i(230277);
        Log.d(TAG, "cancel conection.");
        if (this.conn != null) {
            this.conn.disconnect();
        }
        AppMethodBeat.o(230277);
    }

    private void writePostStringContent(HttpWrapperBase.Request request, OutputStream outputStream) {
        AppMethodBeat.i(157519);
        if (request.params == null) {
            AppMethodBeat.o(157519);
            return;
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : request.params.keySet()) {
            sb.append(z ? "" : "&").append(URLEncoder.encode(str, ProtocolPackage.ServerEncoding)).append('=').append(URLEncoder.encode(request.params.get(str), ProtocolPackage.ServerEncoding));
            z = false;
        }
        outputStream.write(sb.toString().getBytes());
        AppMethodBeat.o(157519);
    }
}
