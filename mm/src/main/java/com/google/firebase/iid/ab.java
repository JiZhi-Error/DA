package com.google.firebase.iid;

import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* access modifiers changed from: package-private */
public final class ab implements ae {
    private final FirebaseInstanceId bLY;
    private final a bLi;
    private final f bLj;
    final m bMx;
    private final ScheduledThreadPoolExecutor bMy = new ScheduledThreadPoolExecutor(1);

    ab(a aVar, FirebaseInstanceId firebaseInstanceId, f fVar) {
        AppMethodBeat.i(4230);
        this.bLi = aVar;
        this.bLY = firebaseInstanceId;
        this.bLj = fVar;
        this.bMx = new m(aVar.getApplicationContext(), fVar);
        AppMethodBeat.o(4230);
    }

    /* access modifiers changed from: package-private */
    public final String j(Bundle bundle) {
        AppMethodBeat.i(4233);
        if (bundle == null) {
            IOException iOException = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.o(4233);
            throw iOException;
        }
        String string = bundle.getString("registration_id");
        if (string != null) {
            AppMethodBeat.o(4233);
        } else {
            string = bundle.getString("unregistered");
            if (string != null) {
                AppMethodBeat.o(4233);
            } else {
                String string2 = bundle.getString("error");
                if ("RST".equals(string2)) {
                    this.bLY.yh();
                    IOException iOException2 = new IOException("INSTANCE_ID_RESET");
                    AppMethodBeat.o(4233);
                    throw iOException2;
                } else if (string2 != null) {
                    IOException iOException3 = new IOException(string2);
                    AppMethodBeat.o(4233);
                    throw iOException3;
                } else {
                    String valueOf = String.valueOf(bundle);
                    new StringBuilder(String.valueOf(valueOf).length() + 21).append("Unexpected response: ").append(valueOf);
                    new Throwable();
                    IOException iOException4 = new IOException("SERVICE_NOT_AVAILABLE");
                    AppMethodBeat.o(4233);
                    throw iOException4;
                }
            }
        }
        return string;
    }

    @Override // com.google.firebase.iid.ae
    public final Task<String> q(String str, String str2) {
        AppMethodBeat.i(4231);
        Bundle bundle = new Bundle();
        c(str, str2, bundle);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.bMy.execute(new ac(this, bundle, taskCompletionSource));
        Task<String> continueWith = taskCompletionSource.getTask().continueWith(this.bMy, new ad(this));
        AppMethodBeat.o(4231);
        return continueWith;
    }

    /* access modifiers changed from: package-private */
    public final Bundle c(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(4232);
        bundle.putString("scope", str2);
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        bundle.putString("appid", FirebaseInstanceId.zzf());
        bundle.putString("gmp_app_id", this.bLi.xR().zzs);
        bundle.putString("gmsv", Integer.toString(this.bLj.yp()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.bLj.yn());
        bundle.putString("app_ver_name", this.bLj.yo());
        bundle.putString("cliv", "fiid-12451000");
        AppMethodBeat.o(4232);
        return bundle;
    }
}
