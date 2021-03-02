package com.tencent.mm.console.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ku;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;

public final class e implements a {
    static {
        AppMethodBeat.i(20178);
        b.a(new e(), "//hotpatch");
        AppMethodBeat.o(20178);
    }

    public static void init() {
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        String str2;
        AppMethodBeat.i(20177);
        if (Log.getLogLevel() > 1) {
            AppMethodBeat.o(20177);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(20177);
            return true;
        } else {
            String str3 = strArr[1];
            char c2 = 65535;
            switch (str3.hashCode()) {
                case 3237038:
                    if (str3.equals("info")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 93029230:
                    if (str3.equals("apply")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 94627080:
                    if (str3.equals("check")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 94746189:
                    if (str3.equals("clear")) {
                        c2 = 2;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    if (strArr.length < 3) {
                        str2 = "/data/local/tmp/test.apk";
                    } else {
                        str2 = strArr[2];
                    }
                    Log.d("MicroMsg.CommandTestHotPatches", "hotpatch test from %s", str2);
                    if (!com.tencent.tinker.lib.e.a.lk(context).Ska) {
                        com.tencent.tinker.lib.e.a.lk(context).dZn();
                    }
                    bg.aVF();
                    c.azQ().set(ar.a.USERINFO_TINKER_BOOTS_CHECK_LAST_TIME_LONG, Long.valueOf(System.currentTimeMillis() - 300000));
                    ku kuVar = new ku();
                    kuVar.dPP.dPU = str2;
                    EventCenter.instance.publish(kuVar);
                    AppMethodBeat.o(20177);
                    return true;
                case 1:
                    Log.d("MicroMsg.CommandTestHotPatches", "hotpatch current class loader=%s", getClass().getClassLoader());
                    AppMethodBeat.o(20177);
                    return true;
                case 2:
                    Log.d("MicroMsg.CommandTestHotPatches", "clear hotpatch");
                    ku kuVar2 = new ku();
                    kuVar2.dPP.dDe = 1;
                    EventCenter.instance.publish(kuVar2);
                    AppMethodBeat.o(20177);
                    return true;
                case 3:
                    if (strArr.length < 3) {
                        AppMethodBeat.o(20177);
                        return true;
                    }
                    String str4 = strArr[2];
                    if (!str4.startsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
                        str4 = "/data/data/" + context.getPackageName() + "/app_dex/" + str4;
                    }
                    Log.i("MicroMsg.CommandTestHotPatches", "hotpatch check patch file %s", str4);
                    Log.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
                    Log.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
                    Log.i("MicroMsg.CommandTestHotPatches", "hotpatch check md5, passed=%b", Boolean.valueOf(SharePatchFileUtil.checkIfMd5Valid(str4)));
                    Log.i("MicroMsg.CommandTestHotPatches", "-------------------------------------------------------------------------------------");
                    AppMethodBeat.o(20177);
                    return true;
                default:
                    AppMethodBeat.o(20177);
                    return true;
            }
        }
    }
}
