package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.lib.d.b;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

public final class f extends b {
    public f(Context context) {
        super(context);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void aE(Intent intent) {
        AppMethodBeat.i(117486);
        super.aE(intent);
        com.tencent.mm.plugin.hp.b.b.aD(intent);
        AppMethodBeat.o(117486);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void a(File file, List<File> list, Throwable th) {
        AppMethodBeat.i(117487);
        super.a(file, list, th);
        com.tencent.mm.plugin.hp.b.b.l(th);
        AppMethodBeat.o(117487);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void a(File file, Throwable th) {
        AppMethodBeat.i(117488);
        super.a(file, th);
        com.tencent.mm.plugin.hp.b.b.k(th);
        AppMethodBeat.o(117488);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void b(File file, String str, String str2) {
        AppMethodBeat.i(117489);
        super.b(file, str, str2);
        com.tencent.mm.plugin.hp.b.b.dYW();
        AppMethodBeat.o(117489);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void e(File file, int i2) {
        AppMethodBeat.i(117490);
        super.e(file, i2);
        com.tencent.mm.plugin.hp.b.b.OS(i2);
        AppMethodBeat.o(117490);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void a(File file, boolean z, long j2) {
        AppMethodBeat.i(117491);
        super.a(file, z, j2);
        Log.i("Tinker.TinkerPatchReporter", "onPatchResult start");
        com.tencent.mm.plugin.hp.b.b.C(j2, z);
        Log.appenderFlushSync();
        AppMethodBeat.o(117491);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void a(File file, File file2, String str, int i2) {
        AppMethodBeat.i(117492);
        super.a(file, file2, str, i2);
        com.tencent.mm.plugin.hp.b.b.OT(i2);
        AppMethodBeat.o(117492);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void a(File file, SharePatchInfo sharePatchInfo, String str) {
        AppMethodBeat.i(117493);
        super.a(file, sharePatchInfo, str);
        com.tencent.mm.plugin.hp.b.b.dYX();
        AppMethodBeat.o(117493);
    }
}
