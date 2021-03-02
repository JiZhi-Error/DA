package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.plugin.hp.tinker.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.lib.d.a;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;

public final class d extends a {
    public d(Context context) {
        super(context);
    }

    @Override // com.tencent.tinker.lib.d.c, com.tencent.tinker.lib.d.a
    public final void a(Throwable th, int i2) {
        AppMethodBeat.i(117468);
        super.a(th, i2);
        b.a(th, i2);
        AppMethodBeat.o(117468);
    }

    @Override // com.tencent.tinker.lib.d.c, com.tencent.tinker.lib.d.a
    public final void b(File file, int i2) {
        AppMethodBeat.i(117469);
        super.b(file, i2);
        b.OV(i2);
        AppMethodBeat.o(117469);
    }

    @Override // com.tencent.tinker.lib.d.c, com.tencent.tinker.lib.d.a
    public final void a(File file, int i2, boolean z) {
        AppMethodBeat.i(117470);
        ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType:%d, isDirectory:%b", file.getAbsolutePath(), Integer.valueOf(i2), Boolean.valueOf(z));
        if (i2 == 4) {
            dZl();
        } else {
            hpb();
        }
        if (i2 == 1) {
            com.tencent.tinker.lib.e.d dVar = com.tencent.tinker.lib.e.a.lk(this.context).SjZ;
            if (dVar.Ske != null && "00000000000000000000000000000000".equals(dVar.Ske)) {
                ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "Roll back patch when restarting main process, restart all other process also!", new Object[0]);
                ShareTinkerInternals.killAllOtherProcess(this.context);
            }
        }
        b.OU(i2);
        AppMethodBeat.o(117470);
    }

    @Override // com.tencent.tinker.lib.d.c, com.tencent.tinker.lib.d.a
    public final void b(int i2, Throwable th) {
        AppMethodBeat.i(117471);
        ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret: type: %d, throwable: %s", Integer.valueOf(i2), th);
        switch (i2) {
            case 0:
                ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret ok", new Object[0]);
                break;
            case 1:
                ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, can get instruction set from existed oat file", new Object[0]);
                break;
            case 2:
                ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "patch loadReporter onLoadInterpret fail, command line to interpret return error", new Object[0]);
                break;
        }
        dZl();
        b.a(i2, th);
        AppMethodBeat.o(117471);
    }

    @Override // com.tencent.tinker.lib.d.c, com.tencent.tinker.lib.d.a
    public final void c(File file, int i2) {
        AppMethodBeat.i(117472);
        super.c(file, i2);
        b.K(MMApplicationContext.sIsRevChange, i2);
        AppMethodBeat.o(117472);
    }

    @Override // com.tencent.tinker.lib.d.c, com.tencent.tinker.lib.d.a
    public final void b(String str, String str2, File file) {
        AppMethodBeat.i(117473);
        super.b(str, str2, file);
        b.dYY();
        AppMethodBeat.o(117473);
    }

    @Override // com.tencent.tinker.lib.d.c, com.tencent.tinker.lib.d.a
    public final void a(String str, String str2, File file, String str3) {
        AppMethodBeat.i(117474);
        super.a(str, str2, file, str3);
        b.dYZ();
        AppMethodBeat.o(117474);
    }

    @Override // com.tencent.tinker.lib.d.c, com.tencent.tinker.lib.d.a
    public final void a(File file, int i2, long j2) {
        int i3;
        AppMethodBeat.i(117475);
        super.a(file, i2, j2);
        switch (i2) {
            case 0:
                b.D(j2, com.tencent.tinker.lib.e.a.lk(this.context).FgY);
                break;
        }
        if (!com.tencent.tinker.lib.e.a.lk(this.context).FgY) {
            ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad retry is not main process, just return", new Object[0]);
        } else {
            String absolutePath = new File(SharePatchFileUtil.getPatchTempDirectory(this.context), "temp.apk").getAbsolutePath();
            if (absolutePath == null || !new File(absolutePath).exists()) {
                ShareTinkerLog.v("Tinker.TinkerPatchLoadReporter", "onPatchRetryLoad patch file: %s is not exist, just return", absolutePath);
            } else {
                new a(this.context, new a.AbstractC1437a() {
                    /* class com.tencent.mm.plugin.hp.tinker.d.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.hp.tinker.a.AbstractC1437a
                    public final void dZg() {
                        AppMethodBeat.i(117467);
                        if (c.lp(d.this.context).hpj()) {
                            b.dYV();
                        }
                        AppMethodBeat.o(117467);
                    }
                });
            }
        }
        Log.d("Tinker.TinkerPatchLoadReporter", "onLoadResult loadcode:%d icost:%d", Integer.valueOf(i2), Long.valueOf(j2));
        if (i2 == 0) {
            Log.i("Tinker.TinkerPatchLoadReporter", "onLoadResult currentVersion:%s", com.tencent.tinker.lib.e.a.lk(this.context).SjZ.Ske);
        }
        com.tencent.tinker.lib.e.a lk = com.tencent.tinker.lib.e.a.lk(this.context);
        if (lk.SjZ == null || lk.SjZ.Skp == null) {
            Log.i("Tinker.TinkerPatchLoadReporter", "patchCheck properties is null.");
            AppMethodBeat.o(117475);
            return;
        }
        String str = BuildInfo.CLIENT_VERSION;
        String str2 = lk.SjZ.Skp.get("patch.client.ver");
        String str3 = lk.SjZ.Skp.get(ShareConstants.NEW_TINKER_ID);
        int i4 = b.EnumC1436b.SCENE_LOAD.value;
        if (i2 == 0) {
            i3 = b.a.SUCCESS.value;
        } else {
            i3 = b.a.FAILED.value;
        }
        b.e(str, str2, str3, i4, i3);
        AppMethodBeat.o(117475);
    }

    @Override // com.tencent.tinker.lib.d.c, com.tencent.tinker.lib.d.a
    public final void d(File file, int i2) {
        AppMethodBeat.i(117476);
        super.d(file, i2);
        if (i2 == -26 || i2 == -5) {
            ShareTinkerInternals.setTinkerDisableWithSharedPreferences(this.context);
            com.tencent.tinker.lib.e.a.lk(this.context).tinkerFlags = 0;
        }
        b.OR(i2);
        AppMethodBeat.o(117476);
    }

    private void dZl() {
        AppMethodBeat.i(117477);
        new a(this.context, new a.AbstractC1437a() {
            /* class com.tencent.mm.plugin.hp.tinker.d.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.hp.tinker.a.AbstractC1437a
            public final void dZg() {
                AppMethodBeat.i(117466);
                if (d.this.hpc()) {
                    b.dYV();
                }
                AppMethodBeat.o(117466);
            }
        });
        AppMethodBeat.o(117477);
    }
}
