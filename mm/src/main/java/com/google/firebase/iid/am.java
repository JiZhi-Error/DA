package com.google.firebase.iid;

/* access modifiers changed from: package-private */
public final /* synthetic */ class am implements Runnable {
    private final aj bMN;

    am(aj ajVar) {
        this.bMN = ajVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        r2 = java.lang.String.valueOf(r0);
        new java.lang.StringBuilder(java.lang.String.valueOf(r2).length() + 8).append("Sending ").append(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0069, code lost:
        r2 = r1.bMM.bLv;
        r3 = r1.bMI;
        r4 = android.os.Message.obtain();
        r4.what = r0.what;
        r4.arg1 = r0.bLs;
        r4.replyTo = r3;
        r3 = new android.os.Bundle();
        r3.putBoolean("oneWay", r0.zzw());
        r3.putString("pkg", r2.getPackageName());
        r3.putBundle("data", r0.bLu);
        r4.setData(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0 = r1.bMJ;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a5, code lost:
        if (r0.bMs == null) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a7, code lost:
        r0.bMs.send(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ae, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00af, code lost:
        r1.zza(2, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c0, code lost:
        if (r0.bMP == null) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c2, code lost:
        r0.bMP.send(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00c9, code lost:
        r0 = new java.lang.IllegalStateException("Both messengers are null");
        com.tencent.matrix.trace.core.AppMethodBeat.o(4268);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d6, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.am.run():void");
    }
}
