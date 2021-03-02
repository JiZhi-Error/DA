package com.google.android.gms.internal.stable;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzk {
    private static final zzl zzahg;
    private static final int zzahh;

    static final class zza extends zzl {
        zza() {
        }

        @Override // com.google.android.gms.internal.stable.zzl
        public final void zza(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001e  */
    static {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.stable.zzk.<clinit>():void");
    }

    public static void zza(Throwable th, Throwable th2) {
        AppMethodBeat.i(5514);
        zzahg.zza(th, th2);
        AppMethodBeat.o(5514);
    }

    private static Integer zzdw() {
        AppMethodBeat.i(5515);
        try {
            Integer num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            AppMethodBeat.o(5515);
            return num;
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            AppMethodBeat.o(5515);
            return null;
        }
    }
}
