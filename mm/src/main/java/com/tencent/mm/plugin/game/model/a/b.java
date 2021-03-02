package com.tencent.mm.plugin.game.model.a;

import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.c.b.q;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader_app.a.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class b {
    public static long a(d dVar, int i2) {
        AppMethodBeat.i(41661);
        a aVar = new a();
        aVar.appId = dVar.field_appId;
        aVar.downloadUrl = dVar.field_downloadUrl;
        aVar.qKt = dVar.field_SecondaryUrl;
        aVar.packageName = dVar.field_packageName;
        aVar.qKv = dVar.field_size;
        aVar.mYc = dVar.field_md5;
        aVar.qKw = false;
        aVar.scene = TXLiteAVCode.WARNING_AUDIO_RECORDING_WRITE_FAIL;
        aVar.qKx = true;
        if (dVar.field_sectionMd5Byte != null) {
            try {
                q qVar = new q();
                qVar.parseFrom(dVar.field_sectionMd5Byte);
                aVar.qKz = qVar.qGz;
            } catch (IOException e2) {
            }
        }
        aVar.appName = h.a(MMApplicationContext.getContext(), h.o(dVar.field_appId, true, false), (String) null);
        aVar.dNv = i2;
        long a2 = ((c) g.af(c.class)).a(aVar, null);
        Log.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "add downloadTask id:%d, downloaderType:%d", Long.valueOf(a2), Integer.valueOf(i2));
        AppMethodBeat.o(41661);
        return a2;
    }

    public static boolean Cp(long j2) {
        AppMethodBeat.i(41662);
        f.cBv().qIA = true;
        boolean Cp = f.cBv().Cp(j2);
        AppMethodBeat.o(41662);
        return Cp;
    }
}
