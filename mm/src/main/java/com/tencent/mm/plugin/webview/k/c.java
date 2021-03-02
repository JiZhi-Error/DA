package com.tencent.mm.plugin.webview.k;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.webview.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private a JBm = new a(this, (byte) 0);
    Map<String, String> JBn = new HashMap();
    public MutableLiveData<String> JBo = new MutableLiveData<>();
    public b JBp = b.NONE;
    String appId;
    public String msl;

    public c() {
        AppMethodBeat.i(82376);
        AppMethodBeat.o(82376);
    }

    public final void mm(String str, String str2) {
        AppMethodBeat.i(82377);
        this.appId = str2;
        this.msl = str;
        this.JBp = b.LOADING;
        long currentTimeMillis = System.currentTimeMillis();
        String a2 = com.tencent.mm.an.c.a("vestacountavatar", currentTimeMillis, z.aUL().field_username, String.valueOf(currentTimeMillis));
        this.JBn.put(Util.nullAsNil(a2), str);
        mn(str, a2);
        AppMethodBeat.o(82377);
    }

    private void mn(String str, String str2) {
        AppMethodBeat.i(82378);
        g gVar = new g();
        gVar.taskName = "task_VestImgUploadEngine";
        gVar.gqy = this.JBm;
        gVar.field_mediaId = str2;
        gVar.field_fullpath = str;
        gVar.field_fileType = com.tencent.mm.i.a.gpY;
        gVar.field_priority = com.tencent.mm.i.a.gpL;
        gVar.field_needStorage = true;
        gVar.field_isStreamMedia = false;
        gVar.field_appType = 200;
        gVar.field_bzScene = 2;
        if (!f.baQ().f(gVar)) {
            Log.e("MicroMsg.VestImgUploadEngine", "hy: cdntra addSendTask failed. clientid:%s", str2);
            this.JBp = b.FAIL;
        }
        AppMethodBeat.o(82378);
    }

    /* access modifiers changed from: package-private */
    public class a implements g.a {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        @Override // com.tencent.mm.i.g.a
        public final int a(String str, int i2, com.tencent.mm.i.c cVar, d dVar, boolean z) {
            AppMethodBeat.i(82372);
            Log.d("MicroMsg.VestImgUploadEngine", "cdntra cdnCallback clientid:%s startRet:%d proginfo:[%s] res:[%s]", str, Integer.valueOf(i2), cVar, dVar);
            synchronized (c.this) {
                if (dVar != null) {
                    try {
                        if (dVar.field_retCode == 0 && i2 == 0) {
                            String str2 = c.this.JBn.get(str);
                            if (!c.this.msl.equals(str2)) {
                                Log.i("MicroMsg.VestImgUploadEngine", "currentPath=%s,callbackPath=%s, path updated after CDNTaskCallback", c.this.msl, str2);
                            } else {
                                Log.i("MicroMsg.VestImgUploadEngine", "CDN upload success, file url = %s", dVar.field_fileUrl);
                                com.tencent.mm.kernel.g.azz().a(new k(dVar.field_fileUrl, c.this.appId, str2), 0);
                                AppMethodBeat.o(82372);
                            }
                        }
                    } finally {
                        AppMethodBeat.o(82372);
                    }
                }
                AppMethodBeat.o(82372);
            }
            return 0;
        }

        @Override // com.tencent.mm.i.g.a
        public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
        }

        @Override // com.tencent.mm.i.g.a
        public final byte[] f(String str, byte[] bArr) {
            return null;
        }
    }

    public enum b {
        NONE,
        LOADING,
        SUCCESS,
        FAIL;

        public static b valueOf(String str) {
            AppMethodBeat.i(82374);
            b bVar = (b) Enum.valueOf(b.class, str);
            AppMethodBeat.o(82374);
            return bVar;
        }

        static {
            AppMethodBeat.i(82375);
            AppMethodBeat.o(82375);
        }
    }
}
