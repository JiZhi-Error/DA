package com.tinkerboots.sdk.tinker.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.lib.d.b;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.List;

public final class c extends b {
    public c(Context context) {
        super(context);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void aE(Intent intent) {
        AppMethodBeat.i(3448);
        super.aE(intent);
        AppMethodBeat.o(3448);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void a(File file, boolean z, long j2) {
        AppMethodBeat.i(3449);
        super.a(file, z, j2);
        AppMethodBeat.o(3449);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void a(File file, List<File> list, Throwable th) {
        AppMethodBeat.i(3450);
        super.a(file, list, th);
        AppMethodBeat.o(3450);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void a(File file, Throwable th) {
        AppMethodBeat.i(3451);
        super.a(file, th);
        AppMethodBeat.o(3451);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void b(File file, String str, String str2) {
        AppMethodBeat.i(3452);
        super.b(file, str, str2);
        AppMethodBeat.o(3452);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void e(File file, int i2) {
        AppMethodBeat.i(3453);
        super.e(file, i2);
        AppMethodBeat.o(3453);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void a(File file, File file2, String str, int i2) {
        AppMethodBeat.i(3454);
        super.a(file, file2, str, i2);
        AppMethodBeat.o(3454);
    }

    @Override // com.tencent.tinker.lib.d.d, com.tencent.tinker.lib.d.b
    public final void a(File file, SharePatchInfo sharePatchInfo, String str) {
        AppMethodBeat.i(3455);
        super.a(file, sharePatchInfo, str);
        AppMethodBeat.o(3455);
    }
}
