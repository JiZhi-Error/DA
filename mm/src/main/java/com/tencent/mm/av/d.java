package com.tencent.mm.av;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.util.HashMap;

public final class d {
    private HashMap<String, c> iWZ = new HashMap<>();

    public interface c {
        void a(Bitmap bitmap, byte[] bArr);
    }

    public d() {
        AppMethodBeat.i(150525);
        AppMethodBeat.o(150525);
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        AppMethodBeat.i(150526);
        super.finalize();
        AppMethodBeat.o(150526);
    }

    public static void g(String str, Bitmap bitmap) {
        AppMethodBeat.i(150527);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.CdnImageService", "push fail, key is null");
            AppMethodBeat.o(150527);
            return;
        }
        g.a.a("local_cdn_img_cache", str, bitmap);
        AppMethodBeat.o(150527);
    }

    public static Bitmap EP(String str) {
        AppMethodBeat.i(150528);
        if (str == null || str.length() == 0) {
            Log.e("MicroMsg.CdnImageService", "get fail, key is null");
            AppMethodBeat.o(150528);
            return null;
        }
        Bitmap bitmap = (Bitmap) g.a.X("local_cdn_img_cache", str);
        AppMethodBeat.o(150528);
        return bitmap;
    }

    public final void Oo(String str) {
        AppMethodBeat.i(150529);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.CdnImageService", "stop load fail, url is empty");
            AppMethodBeat.o(150529);
            return;
        }
        this.iWZ.remove(str);
        AppMethodBeat.o(150529);
    }

    public final void a(String str, c cVar) {
        boolean z;
        AppMethodBeat.i(150530);
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.CdnImageService", "do load fail, url is empty");
            AppMethodBeat.o(150530);
            return;
        }
        Bitmap EP = EP(str);
        if (EP == null || EP.isRecycled()) {
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (EP == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            Log.w("MicroMsg.CdnImageService", "try to download: url[%s], src bitmap is null[%B]", objArr);
            if (this.iWZ.containsKey(str)) {
                Log.w("MicroMsg.CdnImageService", "contains url[%s]", str);
                AppMethodBeat.o(150530);
                return;
            }
            this.iWZ.put(str, cVar);
            ThreadPool.post(new b(str, this.iWZ), "CdnImageService_download");
            AppMethodBeat.o(150530);
            return;
        }
        Log.i("MicroMsg.CdnImageService", "do load ok, url[%s], bitmap exists", str);
        if (cVar != null) {
            cVar.a(EP, null);
        }
        AppMethodBeat.o(150530);
    }

    static class b implements Runnable {
        private HashMap<String, c> iWZ;
        private String url;

        b(String str, HashMap<String, c> hashMap) {
            this.url = str;
            this.iWZ = hashMap;
        }

        public final void run() {
            Bitmap bitmap;
            AppMethodBeat.i(150524);
            byte[] httpGet = Util.httpGet(this.url);
            if (httpGet == null) {
                Log.w("MicroMsg.CdnImageService", "download fail: url[%s] data is null", this.url);
                AppMethodBeat.o(150524);
                return;
            }
            try {
                bitmap = BitmapUtil.decodeByteArray(httpGet);
            } catch (Exception e2) {
                Log.w("MicroMsg.CdnImageService", "download fail: url[%s] decode bitmap error[%s]", this.url, e2.getLocalizedMessage());
                bitmap = null;
            }
            Log.i("MicroMsg.CdnImageService", "download finish, url[%s], do post job", this.url);
            MMHandlerThread.postToMainThread(new a(this.url, bitmap, this.iWZ, httpGet));
            AppMethodBeat.o(150524);
        }
    }

    static class a implements Runnable {
        private byte[] data;
        private HashMap<String, c> iWZ;
        private Bitmap iXa;
        private String url;

        public a(String str, Bitmap bitmap, HashMap<String, c> hashMap, byte[] bArr) {
            this.url = str;
            this.iXa = bitmap;
            this.iWZ = hashMap;
            this.data = bArr;
        }

        public final void run() {
            c remove;
            AppMethodBeat.i(150523);
            q.bcQ();
            d.g(this.url, this.iXa);
            if (!(this.iWZ == null || (remove = this.iWZ.remove(this.url)) == null)) {
                remove.a(this.iXa, this.data);
            }
            Object[] objArr = new Object[1];
            objArr[0] = this.url == null ? BuildConfig.COMMAND : this.url;
            Log.i("MicroMsg.CdnImageService", "finish download post job, url[%s]", objArr);
            AppMethodBeat.o(150523);
        }
    }
}
