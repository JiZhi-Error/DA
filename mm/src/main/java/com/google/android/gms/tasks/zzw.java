package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* access modifiers changed from: package-private */
public final class zzw implements Continuation<Void, List<TResult>> {
    private final /* synthetic */ Collection zzagk;

    zzw(Collection collection) {
        this.zzagk = collection;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.tasks.Task] */
    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Object then(Task<Void> task) {
        AppMethodBeat.i(13447);
        if (this.zzagk.size() == 0) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(13447);
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        for (Task task2 : this.zzagk) {
            arrayList.add(task2.getResult());
        }
        AppMethodBeat.o(13447);
        return arrayList;
    }
}
