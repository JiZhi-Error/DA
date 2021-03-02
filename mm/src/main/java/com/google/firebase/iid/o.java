package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.e.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

public final class o {
    private static o bLL;
    @GuardedBy("serviceClassNames")
    private final n<String, String> bLM = new n<>();
    private Boolean bLN = null;
    final Queue<Intent> bLO = new ArrayDeque();
    public final Queue<Intent> bLP = new ArrayDeque();

    private o() {
        AppMethodBeat.i(4181);
        AppMethodBeat.o(4181);
    }

    public static PendingIntent a(Context context, int i2, Intent intent) {
        AppMethodBeat.i(4182);
        Intent intent2 = new Intent(context, FirebaseInstanceIdReceiver.class);
        intent2.setAction("com.google.firebase.MESSAGING_EVENT");
        intent2.putExtra("wrapped_intent", intent);
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i2, intent2, 1073741824);
        AppMethodBeat.o(4182);
        return broadcast;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002a A[Catch:{ SecurityException -> 0x010a, IllegalStateException -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0042 A[Catch:{ SecurityException -> 0x010a, IllegalStateException -> 0x0112 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int b(android.content.Context r7, android.content.Intent r8) {
        /*
        // Method dump skipped, instructions count: 311
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.o.b(android.content.Context, android.content.Intent):int");
    }

    public static synchronized o yr() {
        o oVar;
        synchronized (o.class) {
            AppMethodBeat.i(4180);
            if (bLL == null) {
                bLL = new o();
            }
            oVar = bLL;
            AppMethodBeat.o(4180);
        }
        return oVar;
    }

    public final int a(Context context, String str, Intent intent) {
        AppMethodBeat.i(4183);
        char c2 = 65535;
        switch (str.hashCode()) {
            case -842411455:
                if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
                    c2 = 0;
                    break;
                }
                break;
            case 41532704:
                if (str.equals("com.google.firebase.MESSAGING_EVENT")) {
                    c2 = 1;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.bLO.offer(intent);
                break;
            case 1:
                this.bLP.offer(intent);
                break;
            default:
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "Unknown service action: ".concat(valueOf);
                } else {
                    new String("Unknown service action: ");
                }
                AppMethodBeat.o(4183);
                return 500;
        }
        Intent intent2 = new Intent(str);
        intent2.setPackage(context.getPackageName());
        int b2 = b(context, intent2);
        AppMethodBeat.o(4183);
        return b2;
    }
}
