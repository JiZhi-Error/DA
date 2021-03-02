package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* access modifiers changed from: package-private */
public final class zzcj extends Handler {
    private final /* synthetic */ zzch zzml;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcj(zzch zzch, Looper looper) {
        super(looper);
        this.zzml = zzch;
    }

    public final void handleMessage(Message message) {
        AppMethodBeat.i(11382);
        switch (message.what) {
            case 0:
                PendingResult<?> pendingResult = (PendingResult) message.obj;
                synchronized (this.zzml.zzfa) {
                    if (pendingResult == null) {
                        try {
                            zzch.zza(this.zzml.zzme, new Status(13, "Transform returned null"));
                        } catch (Throwable th) {
                            AppMethodBeat.o(11382);
                            throw th;
                        }
                    } else if (pendingResult instanceof zzbx) {
                        zzch.zza(this.zzml.zzme, ((zzbx) pendingResult).getStatus());
                    } else {
                        this.zzml.zzme.zza(pendingResult);
                    }
                }
                AppMethodBeat.o(11382);
                return;
            case 1:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String valueOf = String.valueOf(runtimeException.getMessage());
                if (valueOf.length() != 0) {
                    "Runtime exception on the transformation worker thread: ".concat(valueOf);
                } else {
                    new String("Runtime exception on the transformation worker thread: ");
                }
                AppMethodBeat.o(11382);
                throw runtimeException;
            default:
                new StringBuilder(70).append("TransformationResultHandler received unknown message type: ").append(message.what);
                AppMethodBeat.o(11382);
                return;
        }
    }
}
