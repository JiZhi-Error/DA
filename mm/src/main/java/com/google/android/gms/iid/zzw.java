package com.google.android.gms.iid;

/* access modifiers changed from: package-private */
public final /* synthetic */ class zzw implements Runnable {
    private final zzt zzch;

    zzw(zzt zzt) {
        this.zzch = zzt;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        if (android.util.Log.isLoggable("MessengerIpcClient", 3) == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        r2 = java.lang.String.valueOf(r0);
        new java.lang.StringBuilder(java.lang.String.valueOf(r2).length() + 8).append("Sending ").append(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006b, code lost:
        r2 = r1.zzcg.zzk;
        r3 = r1.zzcc;
        r4 = android.os.Message.obtain();
        r4.what = r0.what;
        r4.arg1 = r0.zzck;
        r4.replyTo = r3;
        r3 = new android.os.Bundle();
        r3.putBoolean("oneWay", r0.zzu());
        r3.putString("pkg", r2.getPackageName());
        r3.putBundle("data", r0.zzcm);
        r4.setData(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0 = r1.zzcd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a9, code lost:
        if (r0.zzab == null) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ab, code lost:
        r0.zzab.send(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00b2, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b3, code lost:
        r1.zzd(2, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c4, code lost:
        if (r0.zzcj == null) goto L_0x00cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c6, code lost:
        r0.zzcj.send(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cd, code lost:
        r0 = new java.lang.IllegalStateException("Both messengers are null");
        com.tencent.matrix.trace.core.AppMethodBeat.o(2569);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00da, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        // Method dump skipped, instructions count: 219
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzw.run():void");
    }
}
