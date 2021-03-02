package com.tencent.mm.plugin.profile.ui.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.MStorageEx;
import java.lang.ref.WeakReference;

public final class b implements MStorageEx.IOnStorageChange {
    private WeakReference<MStorageEx.IOnStorageChange> cMO;

    public b(MStorageEx.IOnStorageChange iOnStorageChange) {
        AppMethodBeat.i(27601);
        this.cMO = new WeakReference<>(iOnStorageChange);
        AppMethodBeat.o(27601);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public final void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(27602);
        if (this.cMO.get() != null) {
            this.cMO.get().onNotifyChange(i2, mStorageEx, obj);
        }
        AppMethodBeat.o(27602);
    }
}
