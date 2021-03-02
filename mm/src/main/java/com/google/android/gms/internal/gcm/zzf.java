package com.google.android.gms.internal.gcm;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzf {
    private static final zzg zzdc;
    private static final int zzdd;

    static final class zzd extends zzg {
        zzd() {
        }

        @Override // com.google.android.gms.internal.gcm.zzg
        public final void zzd(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    static {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gcm.zzf.<clinit>():void");
    }

    public static void zzd(Throwable th, Throwable th2) {
        AppMethodBeat.i(2577);
        zzdc.zzd(th, th2);
        AppMethodBeat.o(2577);
    }

    private static Integer zzy() {
        AppMethodBeat.i(2578);
        try {
            Integer num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            AppMethodBeat.o(2578);
            return num;
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            AppMethodBeat.o(2578);
            return null;
        }
    }
}
