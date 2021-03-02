package com.tencent.mm.plugin.hp.tinker;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.af;
import com.tencent.mm.plugin.hp.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.lib.b.a;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import java.io.File;
import java.util.Properties;

public final class c extends a {
    private final int ynk;

    public c(Context context) {
        super(context);
        AppMethodBeat.i(117464);
        this.ynk = ((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getMemoryClass();
        ShareTinkerLog.v("Tinker.TinkerPatchListener", "application maxMemory:" + this.ynk, new Object[0]);
        AppMethodBeat.o(117464);
    }

    @Override // com.tencent.tinker.lib.b.a
    public final int ij(String str, String str2) {
        int i2;
        boolean z = false;
        AppMethodBeat.i(117465);
        File file = new File(str);
        ShareTinkerLog.v("Tinker.TinkerPatchListener", "receive a patch file: %s, file size:%d", str, Long.valueOf(SharePatchFileUtil.getFileOrDirectorySize(file)));
        int ij = super.ij(str, str2);
        if (ij == 0) {
            if (this.ynk < 45) {
                ij = -23;
            } else {
                ij = !com.tencent.mm.plugin.hp.d.c.dZz() ? -21 : 0;
            }
        }
        if (ij == 0) {
            com.tencent.tinker.lib.e.a.lk(this.context);
            if (ij == 0) {
                Properties fastGetPatchPackageMeta = ShareTinkerInternals.fastGetPatchPackageMeta(file);
                if (fastGetPatchPackageMeta == null) {
                    ij = -24;
                } else {
                    String property = fastGetPatchPackageMeta.getProperty("patch.basepack.client.ver");
                    ShareTinkerLog.v("Tinker.TinkerPatchListener", "get BASE_CLIENT_VERSION:".concat(String.valueOf(property)), new Object[0]);
                    if (property == null || !property.equalsIgnoreCase(com.tencent.mm.loader.j.a.CLIENT_VERSION)) {
                        ij = -25;
                    }
                }
            }
        }
        if (ij == 0 && ShareTinkerInternals.isVmArt() && af.b(new Throwable().getStackTrace())) {
            ij = -26;
        }
        Properties fastGetPatchPackageMeta2 = com.tencent.mm.plugin.hp.d.c.fastGetPatchPackageMeta(file);
        if (fastGetPatchPackageMeta2 != null) {
            String str3 = BuildInfo.CLIENT_VERSION;
            String property2 = fastGetPatchPackageMeta2.getProperty("patch.client.ver");
            String property3 = fastGetPatchPackageMeta2.getProperty(ShareConstants.NEW_TINKER_ID);
            int i3 = b.EnumC1436b.SCENE_CHECK.value;
            if (ij == 0) {
                i2 = b.a.SUCCESS.value;
            } else {
                i2 = b.a.FAILED.value;
            }
            b.e(str3, property2, property3, i3, i2);
        } else {
            Log.i("Tinker.TinkerPatchListener", "patchCheck properties is null.");
        }
        if (ij == 0) {
            z = true;
        }
        b.qj(z);
        AppMethodBeat.o(117465);
        return ij;
    }
}
