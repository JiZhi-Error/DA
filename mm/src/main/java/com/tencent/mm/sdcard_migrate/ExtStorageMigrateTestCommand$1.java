package com.tencent.mm.sdcard_migrate;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdcard_migrate.util.ExtStorageMigrateException;
import com.tencent.mm.sdk.platformtools.Log;

class ExtStorageMigrateTestCommand$1 extends MigrateResultCallbackAdapter {
    final /* synthetic */ c NHA;
    final /* synthetic */ Context val$context;

    ExtStorageMigrateTestCommand$1(c cVar, Context context) {
        this.NHA = cVar;
        this.val$context = context;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.sdcard_migrate.MigrateResultCallback, com.tencent.mm.sdcard_migrate.MigrateResultCallbackAdapter
    public final void ajC(int i2) {
        AppMethodBeat.i(204627);
        Toast.makeText(this.val$context, "Cancelled, reason: ".concat(String.valueOf(i2)), 1).show();
        AppMethodBeat.o(204627);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.sdcard_migrate.MigrateResultCallback, com.tencent.mm.sdcard_migrate.MigrateResultCallbackAdapter
    public final void a(int i2, ExtStorageMigrateException extStorageMigrateException) {
        AppMethodBeat.i(204628);
        Log.printErrStackTrace("MicroMsg.ExtStorageMigrateTestCommand", extStorageMigrateException, "[-] Failure.", new Object[0]);
        Toast.makeText(this.val$context, "Failure, reason: ".concat(String.valueOf(i2)), 1).show();
        AppMethodBeat.o(204628);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.sdcard_migrate.MigrateResultCallback, com.tencent.mm.sdcard_migrate.MigrateResultCallbackAdapter
    public final void gwI() {
        AppMethodBeat.i(204629);
        Toast.makeText(this.val$context, "Done.", 1).show();
        AppMethodBeat.o(204629);
    }
}
