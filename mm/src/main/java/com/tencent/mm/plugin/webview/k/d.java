package com.tencent.mm.plugin.webview.k;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class d {
    public static String aYW(String str) {
        AppMethodBeat.i(224512);
        o oVar = new o(b.aKV());
        if (!oVar.mkdirs()) {
            Log.i("MicroMsg.WebJSSDKUtil", "mkdirs failed.File is exist = " + oVar.exists());
        }
        if (!oVar.exists()) {
            Log.e("MicroMsg.WebJSSDKUtil", "camera storage path do not exist.(%s)", b.aKV());
        }
        String str2 = aa.z(oVar.her()) + FilePathGenerator.ANDROID_DIR_SEP + str + ".jpg";
        Log.i("MicroMsg.WebJSSDKUtil", "get file path from capture file name : %s == %s", str, str2);
        AppMethodBeat.o(224512);
        return str2;
    }

    public static Intent aYX(String str) {
        AppMethodBeat.i(224513);
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", FileProviderHelper.getUriForFile(MMApplicationContext.getContext(), new o(aYW(str))));
        AppMethodBeat.o(224513);
        return intent;
    }

    public static Intent gcV() {
        AppMethodBeat.i(224514);
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        AppMethodBeat.o(224514);
        return intent;
    }

    public static Intent gcW() {
        AppMethodBeat.i(224515);
        Intent intent = new Intent("android.provider.MediaStore.RECORD_SOUND");
        AppMethodBeat.o(224515);
        return intent;
    }
}
