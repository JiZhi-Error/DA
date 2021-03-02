package com.tencent.mm.plugin.collect.reward.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c;
import com.tencent.mm.an.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class a implements g.a {
    private static a qxI;
    private String filename;
    public Map<String, AbstractC0931a> oPn;

    /* renamed from: com.tencent.mm.plugin.collect.reward.b.a$a  reason: collision with other inner class name */
    public interface AbstractC0931a {
        void Y(String str, int i2, int i3);
    }

    public static a czR() {
        AppMethodBeat.i(63915);
        if (qxI == null) {
            qxI = new a();
        }
        a aVar = qxI;
        AppMethodBeat.o(63915);
        return aVar;
    }

    public final boolean a(String str, String str2, AbstractC0931a aVar) {
        AppMethodBeat.i(63916);
        Log.i("MicroMsg.QrRewardCdnDownloadHelper", "downloadImage. imageId:%s", str);
        o oVar = new o(czV());
        if (!oVar.exists()) {
            oVar.mkdirs();
        }
        g gVar = new g();
        gVar.taskName = "task_QrRewardCdnDownloadHelper";
        gVar.ehd = false;
        gVar.gqy = this;
        gVar.field_fullpath = czV() + czT();
        gVar.field_mediaId = Util.nullAsNil(c.a("QrRewardImg", Util.nowMilliSecond(), z.aUL().field_username, ""));
        gVar.field_fileId = str;
        gVar.field_aesKey = str2;
        gVar.field_fileType = com.tencent.mm.i.a.MediaType_FILE;
        gVar.field_priority = com.tencent.mm.i.a.gpM;
        gVar.field_needStorage = false;
        gVar.field_isStreamMedia = false;
        gVar.field_appType = 0;
        gVar.field_bzScene = 0;
        if (this.oPn == null) {
            this.oPn = new HashMap();
        }
        this.oPn.put(gVar.field_mediaId, aVar);
        if (!f.baQ().b(gVar, -1)) {
            Log.e("MicroMsg.QrRewardCdnDownloadHelper", "ljd: cdntra addSendTask failed. imageId:%s", str);
            AppMethodBeat.o(63916);
            return false;
        }
        AppMethodBeat.o(63916);
        return true;
    }

    public final boolean czS() {
        AppMethodBeat.i(63917);
        boolean exists = new o(czV() + czT()).exists();
        AppMethodBeat.o(63917);
        return exists;
    }

    private String czT() {
        AppMethodBeat.i(63918);
        if (Util.isNullOrNil(this.filename)) {
            this.filename = MD5Util.getMD5String(z.aTY() + "_reward_img");
        }
        String str = this.filename;
        AppMethodBeat.o(63918);
        return str;
    }

    public final String czU() {
        AppMethodBeat.i(63919);
        String str = czV() + czT();
        AppMethodBeat.o(63919);
        return str;
    }

    @Override // com.tencent.mm.i.g.a
    public final int a(final String str, final int i2, com.tencent.mm.i.c cVar, final d dVar, boolean z) {
        AppMethodBeat.i(63920);
        Log.i("MicroMsg.QrRewardCdnDownloadHelper", "cdn callback, id: %s, ret: %s, sceneResult: %s", str, Integer.valueOf(i2), dVar);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.collect.reward.b.a.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(63914);
                AbstractC0931a aVar = a.this.oPn.get(str);
                if (aVar == null) {
                    Log.w("MicroMsg.QrRewardCdnDownloadHelper", "no callback");
                    AppMethodBeat.o(63914);
                } else if (dVar != null) {
                    aVar.Y(str, i2, dVar.field_retCode);
                    a.this.oPn.remove(str);
                    if (dVar.field_retCode == 0) {
                        h.INSTANCE.idkeyStat(724, 8, 1, false);
                        AppMethodBeat.o(63914);
                        return;
                    }
                    h.INSTANCE.idkeyStat(724, 9, 1, false);
                    AppMethodBeat.o(63914);
                } else {
                    Log.v("MicroMsg.QrRewardCdnDownloadHelper", "download is not end");
                    AppMethodBeat.o(63914);
                }
            }
        });
        AppMethodBeat.o(63920);
        return 0;
    }

    @Override // com.tencent.mm.i.g.a
    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
    }

    @Override // com.tencent.mm.i.g.a
    public final byte[] f(String str, byte[] bArr) {
        return new byte[0];
    }

    private static String czV() {
        AppMethodBeat.i(63921);
        String str = b.aKJ() + "wallet/img/";
        AppMethodBeat.o(63921);
        return str;
    }
}
