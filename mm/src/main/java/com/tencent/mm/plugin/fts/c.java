package com.tencent.mm.plugin.fts;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

public final class c implements com.tencent.mm.plugin.fts.a.d.c {
    private static int MAX_CACHE_SIZE = 32;
    private MMHandler hAk = new MMHandler(Looper.getMainLooper());
    private ConcurrentHashMap<String, a> wTr;
    private Vector<String> wTs;
    private boolean wTt = true;
    private int wTu = 0;
    private MMHandler[] wTv = new MMHandler[2];
    private ConcurrentHashMap<Long, ByteArrayOutputStream> wTw = null;
    private ConcurrentHashMap<Long, byte[]> wTx = null;
    private MMHandler wTy = null;
    private Set<String> wTz;

    /* renamed from: com.tencent.mm.plugin.fts.c$c  reason: collision with other inner class name */
    interface AbstractC1380c {
        void bA(String str, boolean z);
    }

    static /* synthetic */ Bitmap a(c cVar, String str) {
        AppMethodBeat.i(183538);
        Bitmap OQ = cVar.OQ(str);
        AppMethodBeat.o(183538);
        return OQ;
    }

    static /* synthetic */ Bitmap a(c cVar, String str, boolean z, int i2, int i3) {
        AppMethodBeat.i(183542);
        Bitmap b2 = cVar.b(str, z, i2, i3);
        AppMethodBeat.o(183542);
        return b2;
    }

    public c() {
        AppMethodBeat.i(52509);
        Log.i("MicroMsg.FTS.FTSImageLoader", "create SearchImageLoader");
        if (com.tencent.mm.compatible.util.d.oD(19)) {
            MAX_CACHE_SIZE = 64;
        } else {
            MAX_CACHE_SIZE = 32;
        }
        this.wTr = new ConcurrentHashMap<>();
        this.wTs = new Vector<>();
        this.wTw = new ConcurrentHashMap<>();
        this.wTx = new ConcurrentHashMap<>();
        this.wTz = Collections.synchronizedSet(new HashSet());
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.wTv[i2] == null) {
                this.wTv[i2] = new MMHandler("SearchImageLoader_loadImage_handler");
            }
        }
        this.wTy = new MMHandler("SearchImageLoader_saveImage_handler");
        AppMethodBeat.o(52509);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.c
    public final void a(final Context context, final ImageView imageView, String str, String str2, boolean z, int i2, int i3) {
        AppMethodBeat.i(52510);
        String a2 = a(imageView, str, str2, z, i2, i3);
        if (!this.wTt) {
            AppMethodBeat.o(52510);
            return;
        }
        b bVar = new b(a2, str, str2, z, i2, i3, new AbstractC1380c() {
            /* class com.tencent.mm.plugin.fts.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.fts.c.AbstractC1380c
            public final void bA(final String str, boolean z) {
                AppMethodBeat.i(183537);
                Log.v("MicroMsg.FTS.FTSImageLoader", "LoadBitmapJob finish: %s %b", str, Boolean.valueOf(z));
                c.this.wTz.remove(str);
                if (!z) {
                    AppMethodBeat.o(183537);
                    return;
                }
                final Bitmap a2 = c.a(c.this, str);
                if (str.equals(imageView.getTag())) {
                    c.this.hAk.post(new Runnable() {
                        /* class com.tencent.mm.plugin.fts.c.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(183536);
                            if (str.equals(imageView.getTag())) {
                                c.a.a(context.getResources(), a2, imageView);
                            }
                            AppMethodBeat.o(183536);
                        }
                    });
                }
                AppMethodBeat.o(183537);
            }
        });
        if (this.wTz.add(a2)) {
            this.wTu++;
            this.wTu %= 2;
            this.wTv[this.wTu].post(bVar);
            AppMethodBeat.o(52510);
            return;
        }
        Log.v("MicroMsg.FTS.FTSImageLoader", "cacheKey: %s | runningJobTask: %s", a2, this.wTz.toString());
        AppMethodBeat.o(52510);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.c
    public final String a(ImageView imageView, String str, String str2, boolean z, int i2, int i3) {
        AppMethodBeat.i(52511);
        String c2 = c(str, str2, z, i2, i3);
        imageView.setTag(c2);
        Log.d("MicroMsg.FTS.FTSImageLoader", "update image view cache key: hashcode=%d | cacheKey=%s", Integer.valueOf(imageView.hashCode()), c2);
        AppMethodBeat.o(52511);
        return c2;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.c
    public final void dOk() {
        AppMethodBeat.i(52512);
        Log.d("MicroMsg.FTS.FTSImageLoader", "stopLoadImageTask");
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.wTv[i2] != null) {
                this.wTv[i2].removeCallbacksAndMessages(null);
            }
        }
        AppMethodBeat.o(52512);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.c
    public final void dOl() {
        AppMethodBeat.i(52513);
        Log.d("MicroMsg.FTS.FTSImageLoader", "stopLoadImage");
        this.wTt = false;
        dOk();
        AppMethodBeat.o(52513);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.c
    public final boolean dOm() {
        return this.wTt;
    }

    @Override // com.tencent.mm.plugin.fts.a.d.c
    public final void dOn() {
        AppMethodBeat.i(52514);
        Log.d("MicroMsg.FTS.FTSImageLoader", "startLoadImage");
        this.wTt = true;
        AppMethodBeat.o(52514);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.c
    public final void dOo() {
        AppMethodBeat.i(52515);
        Log.d("MicroMsg.FTS.FTSImageLoader", "clearCacheAndTask %s", Integer.valueOf(this.wTr.size()));
        dOk();
        for (Map.Entry<String, a> entry : this.wTr.entrySet()) {
            ayf(entry.getKey());
        }
        this.wTs.clear();
        this.wTz.clear();
        AppMethodBeat.o(52515);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.c
    public final void dOp() {
        AppMethodBeat.i(52516);
        dOo();
        Log.d("MicroMsg.FTS.FTSImageLoader", "destoryLoader");
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.wTv[i2] != null) {
                this.wTv[i2].quit();
            }
        }
        for (ByteArrayOutputStream byteArrayOutputStream : this.wTw.values()) {
            try {
                byteArrayOutputStream.close();
            } catch (IOException e2) {
            }
        }
        this.wTw.clear();
        this.wTx.clear();
        this.wTy.quit();
        AppMethodBeat.o(52516);
    }

    @Override // com.tencent.mm.plugin.fts.a.d.c
    public final Bitmap b(String str, String str2, boolean z, int i2, int i3) {
        AppMethodBeat.i(52517);
        Bitmap OQ = OQ(c(str, str2, z, i2, i3));
        AppMethodBeat.o(52517);
        return OQ;
    }

    private Bitmap OQ(String str) {
        AppMethodBeat.i(52518);
        a aVar = this.wTr.get(str);
        if (!(aVar == null || aVar.bitmap == null || aVar.bitmap.isRecycled())) {
            this.wTs.remove(str);
            this.wTs.add(0, str);
        }
        if (aVar == null) {
            AppMethodBeat.o(52518);
            return null;
        }
        Bitmap bitmap = aVar.bitmap;
        AppMethodBeat.o(52518);
        return bitmap;
    }

    private synchronized byte[] getBuffer() {
        byte[] bArr;
        AppMethodBeat.i(52519);
        bArr = this.wTx.get(Long.valueOf(Thread.currentThread().getId()));
        if (bArr == null) {
            bArr = new byte[1024];
            this.wTx.put(Long.valueOf(Thread.currentThread().getId()), bArr);
        }
        AppMethodBeat.o(52519);
        return bArr;
    }

    private static String c(String str, String str2, boolean z, int i2, int i3) {
        AppMethodBeat.i(52520);
        String str3 = "fts_search_" + g.getMessageDigest((Util.nullAs(str, BuildConfig.COMMAND) + Util.nullAs(str2, BuildConfig.COMMAND) + z + i2 + "_" + i3).getBytes());
        AppMethodBeat.o(52520);
        return str3;
    }

    /* access modifiers changed from: package-private */
    public class a {
        Bitmap bitmap;
        String dUs;

        a() {
        }
    }

    /* access modifiers changed from: package-private */
    public class d implements Runnable {
        private a wTD;

        public d(a aVar) {
            this.wTD = aVar;
        }

        public final void run() {
            AppMethodBeat.i(52508);
            Log.d("MicroMsg.FTS.FTSImageLoader", "Start to run save bitmap job");
            try {
                if (!new o(this.wTD.dUs).exists()) {
                    if (this.wTD.bitmap == null || this.wTD.bitmap.isRecycled()) {
                        Log.d("MicroMsg.FTS.FTSImageLoader", "Save Bitmap is Recycled");
                    } else {
                        long currentTimeMillis = System.currentTimeMillis();
                        BitmapUtil.saveBitmapToImage(this.wTD.bitmap, 100, Bitmap.CompressFormat.PNG, this.wTD.dUs, false);
                        Log.d("MicroMsg.FTS.FTSImageLoader", "Save bitmap use time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(52508);
                        return;
                    }
                }
                AppMethodBeat.o(52508);
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.FTS.FTSImageLoader", e2, "", new Object[0]);
                AppMethodBeat.o(52508);
            }
        }
    }

    class b implements Runnable {
        private String cacheKey;
        private String dUs;
        private boolean hZE;
        private int height;
        private String url;
        private AbstractC1380c wTC;
        private int width;

        public b(String str, String str2, String str3, boolean z, int i2, int i3, AbstractC1380c cVar) {
            this.cacheKey = str;
            this.url = str2;
            this.dUs = str3;
            this.wTC = cVar;
            this.hZE = z;
            this.width = i2;
            this.height = i3;
        }

        public final void run() {
            AppMethodBeat.i(52507);
            Log.d("MicroMsg.FTS.FTSImageLoader", "Start to run load bitmap job %s", this.cacheKey);
            if (Util.isNullOrNil(this.dUs)) {
                this.dUs = c.ayg(this.cacheKey);
            }
            long currentTimeMillis = System.currentTimeMillis();
            Bitmap aj = c.aj(this.dUs, this.width, this.height);
            long currentTimeMillis2 = System.currentTimeMillis();
            if (aj != null) {
                Log.d("MicroMsg.FTS.FTSImageLoader", "Found image in local %s | localPath %s | use time %d", this.url, this.dUs, Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                c.a(c.this, this.cacheKey, this.dUs, aj);
                this.wTC.bA(this.cacheKey, true);
                AppMethodBeat.o(52507);
                return;
            }
            Bitmap a2 = c.a(c.this, this.url, this.hZE, this.width, this.height);
            Log.d("MicroMsg.FTS.FTSImageLoader", "Get image from net %s | localPath %s | use time %d", this.url, this.dUs, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
            if (a2 != null) {
                c.a(c.this, this.cacheKey, this.dUs, a2);
                this.wTC.bA(this.cacheKey, true);
                AppMethodBeat.o(52507);
                return;
            }
            this.wTC.bA(this.cacheKey, false);
            AppMethodBeat.o(52507);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a4 A[SYNTHETIC, Splitter:B:27:0x00a4] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0136 A[SYNTHETIC, Splitter:B:55:0x0136] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap b(java.lang.String r11, boolean r12, int r13, int r14) {
        /*
        // Method dump skipped, instructions count: 339
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.fts.c.b(java.lang.String, boolean, int, int):android.graphics.Bitmap");
    }

    private void ayf(String str) {
        AppMethodBeat.i(52522);
        a aVar = this.wTr.get(str);
        this.wTs.remove(str);
        this.wTr.remove(str);
        if (!(aVar == null || aVar.bitmap == null)) {
            if (!aVar.bitmap.isRecycled()) {
                Log.i("MicroMsg.FTS.FTSImageLoader", "bitmap recycle %s", aVar.bitmap);
                aVar.bitmap.recycle();
            }
            aVar.bitmap = null;
        }
        AppMethodBeat.o(52522);
    }

    static /* synthetic */ String ayg(String str) {
        AppMethodBeat.i(183539);
        String z = aa.z(new o(new o(com.tencent.mm.plugin.image.d.aSY()), str).her());
        AppMethodBeat.o(183539);
        return z;
    }

    static /* synthetic */ Bitmap aj(String str, int i2, int i3) {
        AppMethodBeat.i(183540);
        if (Util.isNullOrNil(str) || !new o(str).exists()) {
            AppMethodBeat.o(183540);
            return null;
        } else if (i2 <= 0 || i3 <= 0) {
            Bitmap Sq = u.Sq(str);
            AppMethodBeat.o(183540);
            return Sq;
        } else {
            Bitmap x = u.x(str, i2, i3);
            AppMethodBeat.o(183540);
            return x;
        }
    }

    static /* synthetic */ void a(c cVar, String str, String str2, Bitmap bitmap) {
        AppMethodBeat.i(183541);
        if (cVar.wTr.size() > MAX_CACHE_SIZE) {
            cVar.ayf(cVar.wTs.lastElement());
        }
        a aVar = new a();
        aVar.dUs = str2;
        aVar.bitmap = bitmap;
        cVar.wTr.put(str, aVar);
        if (!new o(aVar.dUs).exists()) {
            cVar.wTy.postDelayed(new d(aVar), 200);
        }
        AppMethodBeat.o(183541);
    }
}
