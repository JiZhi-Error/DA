package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* access modifiers changed from: package-private */
public final class zzx implements Continuation<Void, Task<List<Task<?>>>> {
    private final /* synthetic */ Collection zzagk;

    zzx(Collection collection) {
        this.zzagk = collection;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.tasks.Task] */
    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<List<Task<?>>> then(Task<Void> task) {
        AppMethodBeat.i(13448);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zzagk);
        Task forResult = Tasks.forResult(arrayList);
        AppMethodBeat.o(13448);
        return forResult;
    }
}
