package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.support.v4.e.n;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

/* access modifiers changed from: package-private */
public final class m {
    private static PendingIntent bLF;
    private static int bLs = 0;
    @GuardedBy("responseCallbacks")
    private final n<String, TaskCompletionSource<Bundle>> bLG = new n<>();
    private Messenger bLH;
    private Messenger bLI;
    private zzi bLJ;
    private final f bLj;
    private final Context bLv;

    public m(Context context, f fVar) {
        AppMethodBeat.i(4171);
        this.bLv = context;
        this.bLj = fVar;
        this.bLH = new Messenger(new n(this, Looper.getMainLooper()));
        AppMethodBeat.o(4171);
    }

    private static synchronized void a(Context context, Intent intent) {
        synchronized (m.class) {
            AppMethodBeat.i(4172);
            if (bLF == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                bLF = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", bLF);
            AppMethodBeat.o(4172);
        }
    }

    private final void f(String str, Bundle bundle) {
        AppMethodBeat.i(4173);
        synchronized (this.bLG) {
            try {
                TaskCompletionSource<Bundle> remove = this.bLG.remove(str);
                if (remove == null) {
                    String valueOf = String.valueOf(str);
                    if (valueOf.length() != 0) {
                        "Missing callback for ".concat(valueOf);
                    } else {
                        new String("Missing callback for ");
                    }
                    return;
                }
                remove.setResult(bundle);
                AppMethodBeat.o(4173);
            } finally {
                AppMethodBeat.o(4173);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d9 A[SYNTHETIC, Splitter:B:32:0x00d9] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.os.Bundle i(android.os.Bundle r10) {
        /*
        // Method dump skipped, instructions count: 323
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.m.i(android.os.Bundle):android.os.Bundle");
    }

    private static synchronized String yq() {
        String num;
        synchronized (m.class) {
            AppMethodBeat.i(4176);
            int i2 = bLs;
            bLs = i2 + 1;
            num = Integer.toString(i2);
            AppMethodBeat.o(4176);
        }
        return num;
    }

    private final Bundle zzd(Bundle bundle) {
        AppMethodBeat.i(4175);
        Bundle i2 = i(bundle);
        if (i2 != null && i2.containsKey("google.messenger") && (i2 = i(bundle)) != null && i2.containsKey("google.messenger")) {
            i2 = null;
        }
        AppMethodBeat.o(4175);
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final Bundle h(Bundle bundle) {
        AppMethodBeat.i(4174);
        if (this.bLj.yp() >= 12000000) {
            ai as = ai.as(this.bLv);
            try {
                Bundle bundle2 = (Bundle) Tasks.await(as.a(new e(as.yw(), bundle)));
                AppMethodBeat.o(4174);
                return bundle2;
            } catch (InterruptedException | ExecutionException e2) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e2);
                    new StringBuilder(String.valueOf(valueOf).length() + 22).append("Error making request: ").append(valueOf);
                }
                if (!(e2.getCause() instanceof d) || ((d) e2.getCause()).errorCode != 4) {
                    AppMethodBeat.o(4174);
                    return null;
                }
                Bundle zzd = zzd(bundle);
                AppMethodBeat.o(4174);
                return zzd;
            }
        } else {
            Bundle zzd2 = zzd(bundle);
            AppMethodBeat.o(4174);
            return zzd2;
        }
    }

    static /* synthetic */ void a(m mVar, Message message) {
        AppMethodBeat.i(4178);
        if (message != null && (message.obj instanceof Intent)) {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(new zzi.a());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof zzi) {
                    mVar.bLJ = (zzi) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    mVar.bLI = (Messenger) parcelableExtra;
                }
            }
            Intent intent2 = (Intent) message.obj;
            String action = intent2.getAction();
            if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(action);
                    if (valueOf.length() != 0) {
                        "Unexpected response action: ".concat(valueOf);
                        AppMethodBeat.o(4178);
                        return;
                    }
                    new String("Unexpected response action: ");
                }
                AppMethodBeat.o(4178);
                return;
            }
            String stringExtra = intent2.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent2.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                String stringExtra2 = intent2.getStringExtra("error");
                if (stringExtra2 == null) {
                    String valueOf2 = String.valueOf(intent2.getExtras());
                    new StringBuilder(String.valueOf(valueOf2).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf2);
                    AppMethodBeat.o(4178);
                    return;
                }
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf3 = String.valueOf(stringExtra2);
                    if (valueOf3.length() != 0) {
                        "Received InstanceID error ".concat(valueOf3);
                    } else {
                        new String("Received InstanceID error ");
                    }
                }
                if (stringExtra2.startsWith("|")) {
                    String[] split = stringExtra2.split("\\|");
                    if (split.length <= 2 || !"ID".equals(split[1])) {
                        String valueOf4 = String.valueOf(stringExtra2);
                        if (valueOf4.length() != 0) {
                            "Unexpected structured response ".concat(valueOf4);
                            AppMethodBeat.o(4178);
                            return;
                        }
                        new String("Unexpected structured response ");
                        AppMethodBeat.o(4178);
                        return;
                    }
                    String str = split[2];
                    String str2 = split[3];
                    if (str2.startsWith(":")) {
                        str2 = str2.substring(1);
                    }
                    mVar.f(str, intent2.putExtra("error", str2).getExtras());
                    AppMethodBeat.o(4178);
                    return;
                }
                synchronized (mVar.bLG) {
                    for (int i2 = 0; i2 < mVar.bLG.size(); i2++) {
                        try {
                            mVar.f(mVar.bLG.keyAt(i2), intent2.getExtras());
                        } finally {
                            AppMethodBeat.o(4178);
                        }
                    }
                }
                return;
            }
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
            if (!matcher.matches()) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf5 = String.valueOf(stringExtra);
                    if (valueOf5.length() != 0) {
                        "Unexpected response string: ".concat(valueOf5);
                        AppMethodBeat.o(4178);
                        return;
                    }
                    new String("Unexpected response string: ");
                }
                AppMethodBeat.o(4178);
                return;
            }
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            Bundle extras = intent2.getExtras();
            extras.putString("registration_id", group2);
            mVar.f(group, extras);
        }
        AppMethodBeat.o(4178);
    }
}
