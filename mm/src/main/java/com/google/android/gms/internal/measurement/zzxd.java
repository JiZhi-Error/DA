package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.PrintStream;

public final class zzxd {
    private static final zzxe zzbnx;
    private static final int zzbny;

    static final class zza extends zzxe {
        zza() {
        }

        @Override // com.google.android.gms.internal.measurement.zzxe
        public final void zza(Throwable th, PrintStream printStream) {
            AppMethodBeat.i(40325);
            th.printStackTrace(printStream);
            AppMethodBeat.o(40325);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f  */
    static {
        /*
        // Method dump skipped, instructions count: 129
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzxd.<clinit>():void");
    }

    public static void zza(Throwable th, PrintStream printStream) {
        AppMethodBeat.i(40326);
        zzbnx.zza(th, printStream);
        AppMethodBeat.o(40326);
    }

    private static Integer zzsd() {
        AppMethodBeat.i(40327);
        try {
            Integer num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            AppMethodBeat.o(40327);
            return num;
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            AppMethodBeat.o(40327);
            return null;
        }
    }
}
