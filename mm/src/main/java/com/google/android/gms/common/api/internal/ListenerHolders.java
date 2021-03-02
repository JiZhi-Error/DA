package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

@KeepForSdk
public class ListenerHolders {
    private final Set<ListenerHolder<?>> zzlm = Collections.newSetFromMap(new WeakHashMap());

    public ListenerHolders() {
        AppMethodBeat.i(11137);
        AppMethodBeat.o(11137);
    }

    @KeepForSdk
    public static <L> ListenerHolder<L> createListenerHolder(L l, Looper looper, String str) {
        AppMethodBeat.i(11140);
        Preconditions.checkNotNull(l, "Listener must not be null");
        Preconditions.checkNotNull(looper, "Looper must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        ListenerHolder<L> listenerHolder = new ListenerHolder<>(looper, l, str);
        AppMethodBeat.o(11140);
        return listenerHolder;
    }

    @KeepForSdk
    public static <L> ListenerHolder.ListenerKey<L> createListenerKey(L l, String str) {
        AppMethodBeat.i(11141);
        Preconditions.checkNotNull(l, "Listener must not be null");
        Preconditions.checkNotNull(str, "Listener type must not be null");
        Preconditions.checkNotEmpty(str, "Listener type must not be empty");
        ListenerHolder.ListenerKey<L> listenerKey = new ListenerHolder.ListenerKey<>(l, str);
        AppMethodBeat.o(11141);
        return listenerKey;
    }

    public final void release() {
        AppMethodBeat.i(11139);
        for (ListenerHolder<?> listenerHolder : this.zzlm) {
            listenerHolder.clear();
        }
        this.zzlm.clear();
        AppMethodBeat.o(11139);
    }

    public final <L> ListenerHolder<L> zza(L l, Looper looper, String str) {
        AppMethodBeat.i(11138);
        ListenerHolder<L> createListenerHolder = createListenerHolder(l, looper, str);
        this.zzlm.add(createListenerHolder);
        AppMethodBeat.o(11138);
        return createListenerHolder;
    }
}
