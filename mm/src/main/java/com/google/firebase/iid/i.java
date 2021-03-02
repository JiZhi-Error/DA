package com.google.firebase.iid;

import android.support.v4.e.a;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import javax.annotation.concurrent.GuardedBy;

/* access modifiers changed from: package-private */
public final class i {
    @GuardedBy("this")
    private final Map<Pair<String, String>, TaskCompletionSource<String>> bLz = new a();

    i() {
        AppMethodBeat.i(4164);
        AppMethodBeat.o(4164);
    }

    static String a(TaskCompletionSource<String> taskCompletionSource) {
        AppMethodBeat.i(4167);
        try {
            String str = (String) Tasks.await(taskCompletionSource.getTask());
            AppMethodBeat.o(4167);
            return str;
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                IOException iOException = (IOException) cause;
                AppMethodBeat.o(4167);
                throw iOException;
            } else if (cause instanceof RuntimeException) {
                RuntimeException runtimeException = (RuntimeException) cause;
                AppMethodBeat.o(4167);
                throw runtimeException;
            } else {
                IOException iOException2 = new IOException(cause);
                AppMethodBeat.o(4167);
                throw iOException2;
            }
        } catch (InterruptedException e3) {
            IOException iOException3 = new IOException(e3);
            AppMethodBeat.o(4167);
            throw iOException3;
        }
    }

    private static String a(l lVar, TaskCompletionSource<String> taskCompletionSource) {
        AppMethodBeat.i(4166);
        try {
            String zzp = lVar.zzp();
            taskCompletionSource.setResult(zzp);
            AppMethodBeat.o(4166);
            return zzp;
        } catch (IOException | RuntimeException e2) {
            taskCompletionSource.setException(e2);
            AppMethodBeat.o(4166);
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized l a(String str, String str2, l lVar) {
        l kVar;
        AppMethodBeat.i(4165);
        Pair<String, String> pair = new Pair<>(str, str2);
        TaskCompletionSource<String> taskCompletionSource = this.bLz.get(pair);
        if (taskCompletionSource != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                new StringBuilder(String.valueOf(valueOf).length() + 29).append("Joining ongoing request for: ").append(valueOf);
            }
            l jVar = new j(taskCompletionSource);
            AppMethodBeat.o(4165);
            kVar = jVar;
        } else {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf2 = String.valueOf(pair);
                new StringBuilder(String.valueOf(valueOf2).length() + 24).append("Making new request for: ").append(valueOf2);
            }
            TaskCompletionSource<String> taskCompletionSource2 = new TaskCompletionSource<>();
            this.bLz.put(pair, taskCompletionSource2);
            kVar = new k(this, lVar, taskCompletionSource2, pair);
            AppMethodBeat.o(4165);
        }
        return kVar;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String a(l lVar, TaskCompletionSource taskCompletionSource, Pair pair) {
        AppMethodBeat.i(4168);
        try {
            String a2 = a(lVar, taskCompletionSource);
            synchronized (this) {
                try {
                    this.bLz.remove(pair);
                } finally {
                    AppMethodBeat.o(4168);
                }
            }
            return a2;
        } catch (Throwable th) {
            AppMethodBeat.o(4168);
            throw th;
        }
    }
}
