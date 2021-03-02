package com.google.android.gms.internal.firebase_messaging;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzh {
    private static final zzi zze;
    private static final int zzf;

    static final class zza extends zzi {
        zza() {
        }

        @Override // com.google.android.gms.internal.firebase_messaging.zzi
        public final void zza(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    static {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_messaging.zzh.<clinit>():void");
    }

    private static Integer zza() {
        AppMethodBeat.i(4115);
        try {
            Integer num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            AppMethodBeat.o(4115);
            return num;
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            AppMethodBeat.o(4115);
            return null;
        }
    }

    public static void zza(Throwable th, Throwable th2) {
        AppMethodBeat.i(4114);
        zze.zza(th, th2);
        AppMethodBeat.o(4114);
    }
}
