package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public final class ListenerHolder<L> {
    private final zza zzlh;
    private volatile L zzli;
    private final ListenerKey<L> zzlj;

    @KeepForSdk
    public static final class ListenerKey<L> {
        private final L zzli;
        private final String zzll;

        @KeepForSdk
        ListenerKey(L l, String str) {
            this.zzli = l;
            this.zzll = str;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(11131);
            if (this == obj) {
                AppMethodBeat.o(11131);
                return true;
            } else if (!(obj instanceof ListenerKey)) {
                AppMethodBeat.o(11131);
                return false;
            } else {
                ListenerKey listenerKey = (ListenerKey) obj;
                if (this.zzli != listenerKey.zzli || !this.zzll.equals(listenerKey.zzll)) {
                    AppMethodBeat.o(11131);
                    return false;
                }
                AppMethodBeat.o(11131);
                return true;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(11132);
            int identityHashCode = (System.identityHashCode(this.zzli) * 31) + this.zzll.hashCode();
            AppMethodBeat.o(11132);
            return identityHashCode;
        }
    }

    @KeepForSdk
    public interface Notifier<L> {
        @KeepForSdk
        void notifyListener(L l);

        @KeepForSdk
        void onNotifyListenerFailed();
    }

    final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            boolean z = true;
            AppMethodBeat.i(11133);
            if (message.what != 1) {
                z = false;
            }
            Preconditions.checkArgument(z);
            ListenerHolder.this.notifyListenerInternal((Notifier) message.obj);
            AppMethodBeat.o(11133);
        }
    }

    @KeepForSdk
    ListenerHolder(Looper looper, L l, String str) {
        AppMethodBeat.i(11134);
        this.zzlh = new zza(looper);
        this.zzli = (L) Preconditions.checkNotNull(l, "Listener must not be null");
        this.zzlj = new ListenerKey<>(l, Preconditions.checkNotEmpty(str));
        AppMethodBeat.o(11134);
    }

    @KeepForSdk
    public final void clear() {
        this.zzli = null;
    }

    @KeepForSdk
    public final ListenerKey<L> getListenerKey() {
        return this.zzlj;
    }

    @KeepForSdk
    public final boolean hasListener() {
        return this.zzli != null;
    }

    @KeepForSdk
    public final void notifyListener(Notifier<? super L> notifier) {
        AppMethodBeat.i(11135);
        Preconditions.checkNotNull(notifier, "Notifier must not be null");
        this.zzlh.sendMessage(this.zzlh.obtainMessage(1, notifier));
        AppMethodBeat.o(11135);
    }

    /* access modifiers changed from: package-private */
    @KeepForSdk
    public final void notifyListenerInternal(Notifier<? super L> notifier) {
        AppMethodBeat.i(11136);
        L l = this.zzli;
        if (l == null) {
            notifier.onNotifyListenerFailed();
            AppMethodBeat.o(11136);
            return;
        }
        try {
            notifier.notifyListener(l);
            AppMethodBeat.o(11136);
        } catch (RuntimeException e2) {
            notifier.onNotifyListenerFailed();
            AppMethodBeat.o(11136);
            throw e2;
        }
    }
}
