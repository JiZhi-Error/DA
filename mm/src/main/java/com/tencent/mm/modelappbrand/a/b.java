package com.tencent.mm.modelappbrand.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.modelappbrand.a.d;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.s;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static String iIN;
    private static g iIO = g.iJi;
    private final Map<k, String> iIH;
    private final Map<String, k> iII;
    private final Map<Integer, String> iIJ;
    public final e iIK;
    private final l iIL;
    private final i iIM;

    public interface f extends c {
        Bitmap w(InputStream inputStream);
    }

    public interface g {
        public static final g iJi = new g() {
            /* class com.tencent.mm.modelappbrand.a.b.g.AnonymousClass1 */

            @Override // com.tencent.mm.modelappbrand.a.b.g
            public final Bitmap decodeStream(InputStream inputStream) {
                AppMethodBeat.i(176002);
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
                AppMethodBeat.o(176002);
                return decodeStream;
            }
        };

        Bitmap decodeStream(InputStream inputStream);
    }

    public interface h extends c {
        Bitmap J(Bitmap bitmap);
    }

    public interface i {
        OutputStream LM(String str);

        boolean gC(String str);

        InputStream openRead(String str);
    }

    public interface j {
        void aj(byte[] bArr);
    }

    public interface k extends c {
        void I(Bitmap bitmap);

        @Override // com.tencent.mm.modelappbrand.a.c
        String Lb();

        void aYg();

        void oD();
    }

    public interface l {
        Bitmap EP(String str);

        void LN(String str);

        void clear();

        void f(Bitmap bitmap);

        void put(String str, Bitmap bitmap);

        void remove(String str);
    }

    public interface p {
        boolean e(ImageView imageView);
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    static /* synthetic */ String LL(String str) {
        AppMethodBeat.i(204427);
        String LI = LI(str);
        AppMethodBeat.o(204427);
        return LI;
    }

    static /* synthetic */ byte[] a(b bVar, String str) {
        AppMethodBeat.i(204422);
        byte[] LG = bVar.LG(str);
        AppMethodBeat.o(204422);
        return LG;
    }

    static /* synthetic */ g aYc() {
        AppMethodBeat.i(204426);
        g aXZ = aXZ();
        AppMethodBeat.o(204426);
        return aXZ;
    }

    static /* synthetic */ String aZ(String str, String str2) {
        AppMethodBeat.i(204423);
        String aY = aY(str, str2);
        AppMethodBeat.o(204423);
        return aY;
    }

    static /* synthetic */ String b(String str, h hVar, f fVar) {
        AppMethodBeat.i(204424);
        String a2 = a(str, hVar, fVar);
        AppMethodBeat.o(204424);
        return a2;
    }

    /* access modifiers changed from: package-private */
    public static final class o {
        static final b iJw = new b((byte) 0);

        static {
            AppMethodBeat.i(131382);
            AppMethodBeat.o(131382);
        }
    }

    public static b aXY() {
        return o.iJw;
    }

    public static class c implements k {
        @Override // com.tencent.mm.modelappbrand.a.b.k
        public final void aYg() {
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k
        public void I(Bitmap bitmap) {
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k
        public final void oD() {
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
        public final String Lb() {
            return "DefaultLoadTarget";
        }
    }

    private b() {
        AppMethodBeat.i(131383);
        this.iIH = new ConcurrentHashMap();
        this.iII = new ConcurrentHashMap();
        this.iIJ = new ConcurrentHashMap();
        this.iIL = new d();
        this.iIM = new C0449b((byte) 0);
        this.iIK = new e(new MMHandler("AppBrandSimpleImageLoaderDiskIOHandlerThread"), (byte) 0);
        AppMethodBeat.o(131383);
    }

    private void d(ImageView imageView) {
        AppMethodBeat.i(131384);
        if (imageView == null) {
            AppMethodBeat.o(131384);
            return;
        }
        String remove = this.iIJ.remove(Integer.valueOf(imageView.hashCode()));
        if (remove == null) {
            AppMethodBeat.o(131384);
            return;
        }
        a(this.iII.get(remove));
        AppMethodBeat.o(131384);
    }

    public final void a(k kVar) {
        AppMethodBeat.i(204417);
        if (kVar == null) {
            AppMethodBeat.o(204417);
            return;
        }
        String remove = this.iIH.remove(kVar);
        if (!Util.isNullOrNil(remove)) {
            this.iII.remove(remove);
        }
        AppMethodBeat.o(204417);
    }

    public final Bitmap LE(String str) {
        AppMethodBeat.i(131385);
        Bitmap EP = this.iIL.EP(str);
        if (EP == null || EP.isRecycled()) {
            AppMethodBeat.o(131385);
            return null;
        }
        AppMethodBeat.o(131385);
        return EP;
    }

    public final Bitmap a(String str, f fVar) {
        InputStream inputStream;
        Throwable th;
        Exception e2;
        Bitmap decodeStream;
        AppMethodBeat.i(131386);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(131386);
            return null;
        }
        String a2 = a(str, (h) null, fVar);
        Bitmap EP = this.iIL.EP(a2);
        if (EP != null) {
            AppMethodBeat.o(131386);
            return EP;
        }
        try {
            if (str.startsWith("file://")) {
                try {
                    inputStream = s.openRead(str);
                } catch (FileNotFoundException e3) {
                    Log.e("Luggage.AppBrandSimpleImageLoader", "findCachedLocal: load from local file, file not found ");
                    Util.qualityClose(null);
                    AppMethodBeat.o(131386);
                    return null;
                }
            } else {
                inputStream = this.iIM.openRead(LI(str));
            }
            if (inputStream == null) {
                Util.qualityClose(inputStream);
                AppMethodBeat.o(131386);
                return null;
            }
            if (fVar != null) {
                try {
                    decodeStream = fVar.w(inputStream);
                } catch (Exception e4) {
                    e2 = e4;
                    try {
                        Log.printErrStackTrace("Luggage.AppBrandSimpleImageLoader", e2, "findCachedLocal", new Object[0]);
                        Util.qualityClose(inputStream);
                        AppMethodBeat.o(131386);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        Util.qualityClose(inputStream);
                        AppMethodBeat.o(131386);
                        throw th;
                    }
                }
            } else {
                decodeStream = aXZ().decodeStream(inputStream);
            }
            if (decodeStream != null) {
                this.iIL.put(a2, decodeStream);
            }
            Util.qualityClose(inputStream);
            AppMethodBeat.o(131386);
            return decodeStream;
        } catch (Exception e5) {
            e2 = e5;
            inputStream = null;
            Log.printErrStackTrace("Luggage.AppBrandSimpleImageLoader", e2, "findCachedLocal", new Object[0]);
            Util.qualityClose(inputStream);
            AppMethodBeat.o(131386);
            return null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            Util.qualityClose(inputStream);
            AppMethodBeat.o(131386);
            throw th;
        }
    }

    public final void clearCache() {
        AppMethodBeat.i(161226);
        this.iIL.clear();
        AppMethodBeat.o(161226);
    }

    public final String LF(String str) {
        AppMethodBeat.i(131387);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(131387);
            return null;
        }
        String a2 = a(new c(), str, (h) null);
        AppMethodBeat.o(131387);
        return a2;
    }

    public final class a implements e.a, Runnable {
        final /* synthetic */ b iIS;
        final /* synthetic */ q iIT;
        final /* synthetic */ android.arch.a.c.a iIU;
        final /* synthetic */ Map iIV;
        private boolean mCanceled = false;
        final /* synthetic */ String val$url;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(b bVar, q qVar, android.arch.a.c.a aVar, String str, Map map) {
            this.iIS = bVar;
            this.iIT = qVar;
            this.iIU = aVar;
            this.val$url = str;
            this.iIV = map;
        }

        /* access modifiers changed from: package-private */
        public final void aYd() {
            AppMethodBeat.i(204404);
            this.iIS.iIK.post(new Runnable() {
                /* class com.tencent.mm.modelappbrand.a.b.a.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(204402);
                    a.this.iIS.iIK.LR(a.this.iIT.iJy);
                    a.this.iIS.iIK.LO(a.this.iIT.iJy);
                    AppMethodBeat.o(204402);
                }
            });
            AppMethodBeat.o(204404);
        }

        public final void run() {
            AppMethodBeat.i(204405);
            if (this.iIS.iIK.LP(this.iIT.iJy)) {
                this.iIS.iIK.a(this.iIT.iJy, this);
                AppMethodBeat.o(204405);
                return;
            }
            this.iIS.iIK.LQ(this.iIT.iJy);
            aYe();
            AppMethodBeat.o(204405);
        }

        @Override // com.tencent.mm.modelappbrand.a.b.e.a
        public final void aYe() {
            AppMethodBeat.i(204406);
            if (this.mCanceled) {
                AppMethodBeat.o(204406);
                return;
            }
            try {
                InputStream openRead = this.iIS.iIM.openRead(this.iIT.iJy);
                if (openRead != null) {
                    if (this.iIU != null) {
                        this.iIU.apply(openRead);
                    }
                    aYd();
                    AppMethodBeat.o(204406);
                    return;
                }
                com.tencent.f.h.RTc.aX(new com.tencent.f.i.h() {
                    /* class com.tencent.mm.modelappbrand.a.b.a.AnonymousClass2 */

                    @Override // com.tencent.f.i.h, com.tencent.f.i.g
                    public final String getKey() {
                        return "AppBrandSimpleImageLoaderDownloadThread";
                    }

                    public final void run() {
                        AppMethodBeat.i(204403);
                        n.a(a.this.iIT, a.this.iIV, a.this.iIS.iIM);
                        if (a.this.iIU != null) {
                            try {
                                a.this.iIU.apply(a.this.iIS.iIM.openRead(a.this.iIT.iJy));
                            } catch (Throwable th) {
                            }
                        }
                        a.this.aYd();
                        AppMethodBeat.o(204403);
                    }
                });
                AppMethodBeat.o(204406);
            } catch (Throwable th) {
                Log.e("Luggage.AppBrandSimpleImageLoader", "loadIntoDiskCache diskCache.openRead failed, url=%s, e=%s", this.val$url, th);
                if (this.iIU != null) {
                    this.iIU.apply(null);
                }
                aYd();
                AppMethodBeat.o(204406);
            }
        }

        @Override // com.tencent.mm.modelappbrand.a.b.e.a
        public final void aYf() {
            this.mCanceled = true;
        }
    }

    public final String a(k kVar, String str, h hVar, f fVar) {
        AppMethodBeat.i(131388);
        String b2 = b(kVar, str, hVar, fVar);
        AppMethodBeat.o(131388);
        return b2;
    }

    private String b(final k kVar, final String str, h hVar, f fVar) {
        AppMethodBeat.i(204418);
        if (kVar == null) {
            AppMethodBeat.o(204418);
            return null;
        } else if (Util.isNullOrNil(str)) {
            kVar.oD();
            AppMethodBeat.o(204418);
            return null;
        } else {
            try {
                if (BuildConfig.COMMAND.equals(Uri.parse(str).getHost())) {
                    kVar.oD();
                    AppMethodBeat.o(204418);
                    return null;
                }
            } catch (Exception e2) {
            }
            Log.d("Luggage.AppBrandSimpleImageLoader", "load before start LoadTask url %s", str);
            final n nVar = new n(str, null, hVar, this, this.iIL, this.iIM, fVar, b(kVar));
            final String aYj = nVar.aYj();
            AnonymousClass1 r1 = new Runnable() {
                /* class com.tencent.mm.modelappbrand.a.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(131336);
                    Bitmap LE = b.this.LE(aYj);
                    if (LE != null) {
                        kVar.I(LE);
                        Log.d("Luggage.AppBrandSimpleImageLoader", "load already cached, url %s, bitmap %s", str, LE);
                        AppMethodBeat.o(131336);
                        return;
                    }
                    String aYi = nVar.aYi();
                    b.this.iIH.put(kVar, aYi);
                    b.this.iII.put(aYi, kVar);
                    kVar.aYg();
                    n nVar = nVar;
                    nVar.iJj.iIK.post(new Runnable() {
                        /* class com.tencent.mm.modelappbrand.a.b.n.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(131368);
                            n.this.aYe();
                            AppMethodBeat.o(131368);
                        }
                    });
                    AppMethodBeat.o(131336);
                }
            };
            if (MMHandlerThread.isMainThread()) {
                r1.run();
            } else {
                MMHandlerThread.postToMainThread(r1);
            }
            AppMethodBeat.o(204418);
            return aYj;
        }
    }

    public final String a(k kVar, String str, h hVar) {
        AppMethodBeat.i(131389);
        String a2 = a(kVar, str, hVar, (f) null);
        AppMethodBeat.o(131389);
        return a2;
    }

    public final String a(ImageView imageView, String str, int i2, h hVar) {
        AppMethodBeat.i(131390);
        if (imageView == null) {
            AppMethodBeat.o(131390);
            return null;
        }
        String a2 = a(imageView, str, imageView.getContext().getResources().getDrawable(i2), hVar);
        AppMethodBeat.o(131390);
        return a2;
    }

    public final String a(ImageView imageView, String str, Drawable drawable, h hVar) {
        AppMethodBeat.i(131391);
        String a2 = a(imageView, str, drawable, hVar, null, null);
        AppMethodBeat.o(131391);
        return a2;
    }

    public final String a(ImageView imageView, String str, f fVar) {
        AppMethodBeat.i(204419);
        String a2 = a(imageView, str, null, null, fVar, null);
        AppMethodBeat.o(204419);
        return a2;
    }

    public final String a(ImageView imageView, String str, final Drawable drawable, h hVar, f fVar, p pVar) {
        AppMethodBeat.i(204420);
        if (imageView == null) {
            AppMethodBeat.o(204420);
            return null;
        }
        d(imageView);
        if (Util.isNullOrNil(str)) {
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
            }
            AppMethodBeat.o(204420);
            return null;
        }
        AnonymousClass2 r0 = new m(imageView, this, str, pVar) {
            /* class com.tencent.mm.modelappbrand.a.b.AnonymousClass2 */

            @Override // com.tencent.mm.modelappbrand.a.b.m, com.tencent.mm.modelappbrand.a.b.k
            public final void aYg() {
                AppMethodBeat.i(131337);
                if (!(getImageView() == null || drawable == null)) {
                    getImageView().setImageDrawable(drawable);
                }
                AppMethodBeat.o(131337);
            }
        };
        String a2 = a(r0, str, hVar, fVar);
        if (!r0.iJl) {
            this.iIJ.put(Integer.valueOf(imageView.hashCode()), aY(b(r0), a2));
        }
        AppMethodBeat.o(204420);
        return a2;
    }

    private static String b(k kVar) {
        AppMethodBeat.i(204421);
        String str = kVar.Lb() + "@" + kVar.hashCode();
        AppMethodBeat.o(204421);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] LG(java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelappbrand.a.b.LG(java.lang.String):byte[]");
    }

    private static String aY(String str, String str2) {
        AppMethodBeat.i(131394);
        String str3 = str + str2;
        AppMethodBeat.o(131394);
        return str3;
    }

    private static String a(String str, h hVar, f fVar) {
        AppMethodBeat.i(131395);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (hVar != null) {
            sb.append("|transformation:");
            sb.append(hVar.Lb());
        }
        if (fVar != null) {
            sb.append("|decoder:");
            sb.append(fVar.Lb());
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(131395);
        return sb2;
    }

    /* access modifiers changed from: package-private */
    public static class m implements k {
        private final b iJj;
        private final p iJk;
        boolean iJl;
        private final String key;
        private final WeakReference<ImageView> oi;
        private final String url;

        /* synthetic */ m(ImageView imageView, b bVar, String str, p pVar, byte b2) {
            this(imageView, bVar, str, pVar);
        }

        /* access modifiers changed from: package-private */
        public final ImageView getImageView() {
            AppMethodBeat.i(131362);
            ImageView imageView = this.oi.get();
            AppMethodBeat.o(131362);
            return imageView;
        }

        private m(ImageView imageView, b bVar, String str, p pVar) {
            AppMethodBeat.i(204410);
            this.iJl = false;
            this.oi = new WeakReference<>(imageView);
            this.iJj = bVar;
            this.key = "ImageView";
            this.url = str;
            this.iJk = pVar;
            AppMethodBeat.o(204410);
        }

        private void aYh() {
            AppMethodBeat.i(131364);
            ImageView imageView = this.oi.get();
            if (imageView != null) {
                this.iJj.iIJ.remove(Integer.valueOf(imageView.hashCode()));
            }
            AppMethodBeat.o(131364);
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k
        public void aYg() {
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k
        public final void I(Bitmap bitmap) {
            AppMethodBeat.i(131365);
            aYh();
            ImageView imageView = this.oi.get();
            this.iJl = true;
            if (imageView != null) {
                if (!MMHandlerThread.isMainThread()) {
                    Log.printDebugStack("Luggage.AppBrandSimpleImageLoader", "onBitmapLoaded invoke in non-main thread!!!", new Object[0]);
                }
                if (this.iJk == null || this.iJk.e(imageView)) {
                    imageView.setImageDrawable(new f(imageView.getResources(), bitmap));
                } else {
                    Log.i("Luggage.AppBrandSimpleImageLoader", "check fail，abort set image url=" + this.url);
                    AppMethodBeat.o(131365);
                    return;
                }
            }
            AppMethodBeat.o(131365);
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k
        public final void oD() {
            AppMethodBeat.i(131366);
            aYh();
            AppMethodBeat.o(131366);
        }

        @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
        public final String Lb() {
            return this.key;
        }
    }

    public static final class d implements l {
        final com.tencent.mm.b.f<String, Reference<Bitmap>> iJc = new com.tencent.mm.b.h<String, Reference<Bitmap>>() {
            /* class com.tencent.mm.modelappbrand.a.b.d.AnonymousClass1 */
            private final Map<Reference<Bitmap>, Integer> iJd = new ConcurrentHashMap();

            {
                AppMethodBeat.i(131345);
                AppMethodBeat.o(131345);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [boolean, java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // com.tencent.mm.b.h, com.tencent.mm.sdk.platformtools.LruCache
            public final /* synthetic */ void entryRemoved(boolean z, String str, Reference<Bitmap> reference, Reference<Bitmap> reference2) {
                Object obj;
                Object obj2;
                AppMethodBeat.i(131349);
                String str2 = str;
                Reference<Bitmap> reference3 = reference;
                Reference<Bitmap> reference4 = reference2;
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(d.this.iJc.size() / 10);
                objArr[1] = Integer.valueOf(d.this.iJc.maxSize() / 10);
                if (reference3 == null) {
                    obj = "null-ref";
                } else {
                    obj = reference3.get();
                }
                objArr[2] = obj;
                if (reference4 == null) {
                    obj2 = "null-ref";
                } else {
                    obj2 = reference4.get();
                }
                objArr[3] = obj2;
                Log.d("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", "entryRemoved, curSize %d KB, maxSize %d KB, oldBmp %s, newBmp %s", objArr);
                super.entryRemoved(z, str2, reference3, reference4);
                Bitmap bitmap = reference3 == null ? null : reference3.get();
                if (bitmap != (reference4 == null ? null : reference4.get())) {
                    d.this.f(bitmap);
                }
                this.iJd.remove(reference3);
                AppMethodBeat.o(131349);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // com.tencent.mm.b.f, com.tencent.mm.b.h, com.tencent.mm.sdk.platformtools.LruCache
            public final /* synthetic */ int sizeOf(String str, Reference<Bitmap> reference) {
                int i2;
                AppMethodBeat.i(131348);
                Reference<Bitmap> reference2 = reference;
                if (reference2 == null) {
                    AppMethodBeat.o(131348);
                    return 0;
                }
                Integer num = this.iJd.get(reference2);
                if (num == null || num.intValue() < 0) {
                    Bitmap bitmap = reference2.get();
                    if (bitmap == null || bitmap.isRecycled()) {
                        i2 = 0;
                    } else {
                        i2 = android.support.v4.graphics.a.c(bitmap);
                    }
                    this.iJd.put(reference2, Integer.valueOf(i2));
                    AppMethodBeat.o(131348);
                    return i2;
                }
                int intValue = num.intValue();
                AppMethodBeat.o(131348);
                return intValue;
            }

            @Override // com.tencent.mm.b.f, com.tencent.mm.b.h
            public final void clear() {
                AppMethodBeat.i(131346);
                Log.d("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear");
                try {
                    super.clear();
                } catch (IllegalStateException e2) {
                    Log.printErrStackTrace("LRUMap", e2, "clear", new Object[0]);
                }
                this.iJd.clear();
                AppMethodBeat.o(131346);
            }

            @Override // com.tencent.mm.b.f, com.tencent.mm.b.h
            public final void a(f.a<String, Reference<Bitmap>> aVar) {
                AppMethodBeat.i(131347);
                Log.d("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear(OnClearListener)");
                super.a(aVar);
                this.iJd.clear();
                AppMethodBeat.o(131347);
            }
        };

        public d() {
            AppMethodBeat.i(131350);
            AppMethodBeat.o(131350);
        }

        @Override // com.tencent.mm.modelappbrand.a.b.l
        public final Bitmap EP(String str) {
            AppMethodBeat.i(131351);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(131351);
                return null;
            }
            synchronized (this.iJc) {
                try {
                    Reference<Bitmap> reference = this.iJc.get(str);
                    if (reference == null) {
                        return null;
                    }
                    Bitmap bitmap = reference.get();
                    if (bitmap == null || bitmap.isRecycled()) {
                        this.iJc.remove(str);
                        AppMethodBeat.o(131351);
                        return null;
                    }
                    AppMethodBeat.o(131351);
                    return bitmap;
                } finally {
                    AppMethodBeat.o(131351);
                }
            }
        }

        @Override // com.tencent.mm.modelappbrand.a.b.l
        public final void put(String str, Bitmap bitmap) {
            AppMethodBeat.i(131352);
            if (Util.isNullOrNil(str) || bitmap == null) {
                AppMethodBeat.o(131352);
                return;
            }
            Log.d("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", "put, key %s, bmp %s", str, bitmap);
            try {
                synchronized (this.iJc) {
                    try {
                        this.iJc.put(str, new SoftReference(bitmap));
                    } finally {
                        AppMethodBeat.o(131352);
                    }
                }
            } catch (IllegalStateException e2) {
                AppMethodBeat.o(131352);
            }
        }

        @Override // com.tencent.mm.modelappbrand.a.b.l
        public final void f(Bitmap bitmap) {
            AppMethodBeat.i(131353);
            Log.d("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", "release, bmp %s", bitmap);
            if (bitmap != null) {
                bitmap.isRecycled();
            }
            AppMethodBeat.o(131353);
        }

        @Override // com.tencent.mm.modelappbrand.a.b.l
        public final void clear() {
            AppMethodBeat.i(131354);
            Log.d("Luggage.AppBrandSimpleImageLoader.DefaultMemoryCache", "clear");
            synchronized (this.iJc) {
                try {
                    this.iJc.clear();
                } finally {
                    AppMethodBeat.o(131354);
                }
            }
        }

        @Override // com.tencent.mm.modelappbrand.a.b.l
        public final void LN(String str) {
            AppMethodBeat.i(161225);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(161225);
                return;
            }
            synchronized (this.iJc) {
                try {
                    Iterator<String> it = this.iJc.keySet().iterator();
                    while (it.hasNext()) {
                        if (it.next().contains(str)) {
                            it.remove();
                        }
                    }
                } finally {
                    AppMethodBeat.o(161225);
                }
            }
        }

        @Override // com.tencent.mm.modelappbrand.a.b.l
        public final void remove(String str) {
            AppMethodBeat.i(204407);
            synchronized (this.iJc) {
                try {
                    this.iJc.remove(str);
                } finally {
                    AppMethodBeat.o(204407);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.modelappbrand.a.b$b  reason: collision with other inner class name */
    static final class C0449b implements i {
        private C0449b() {
        }

        /* synthetic */ C0449b(byte b2) {
            this();
        }

        @Override // com.tencent.mm.modelappbrand.a.b.i
        public final OutputStream LM(String str) {
            AppMethodBeat.i(131342);
            try {
                if (!s.boN(b.iIN) && !new com.tencent.mm.vfs.o(b.iIN).isDirectory()) {
                    s.deleteFile(b.iIN);
                    s.boN(b.iIN);
                }
            } catch (Throwable th) {
                Log.e("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openWrite mkdirs e=%s", th);
            }
            String str2 = b.iIN + str;
            final String str3 = str2 + ".wlock";
            s.deleteFile(str3);
            s.dy(str3, true);
            s.f(str3, new byte[1], 1);
            try {
                s.deleteFile(str2);
                s.dy(str2, true);
                AnonymousClass1 r0 = new BufferedOutputStream(s.dw(str2, false)) {
                    /* class com.tencent.mm.modelappbrand.a.b.C0449b.AnonymousClass1 */

                    @Override // java.io.OutputStream, java.io.FilterOutputStream, java.io.BufferedOutputStream, java.io.Flushable
                    public final synchronized void flush() {
                        AppMethodBeat.i(131341);
                        super.flush();
                        s.deleteFile(str3);
                        AppMethodBeat.o(131341);
                    }
                };
                AppMethodBeat.o(131342);
                return r0;
            } catch (IOException e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", e2, "openWrite fileName %s, parent exists[%b]", str, Boolean.valueOf(s.YS(b.iIN)));
                AppMethodBeat.o(131342);
                return null;
            }
        }

        @Override // com.tencent.mm.modelappbrand.a.b.i
        public final InputStream openRead(String str) {
            InputStream inputStream = null;
            AppMethodBeat.i(131343);
            String str2 = b.iIN + str;
            if (s.YS(str2 + ".wlock")) {
                AppMethodBeat.o(131343);
            } else {
                try {
                    inputStream = s.openRead(str2);
                    AppMethodBeat.o(131343);
                } catch (IOException e2) {
                    Log.d("MicroMsg.AppBrandSimpleImageLoader.DefaultDiskCache", "openRead fileName %s, e %s", str, e2);
                    AppMethodBeat.o(131343);
                }
            }
            return inputStream;
        }

        @Override // com.tencent.mm.modelappbrand.a.b.i
        public final boolean gC(String str) {
            AppMethodBeat.i(131344);
            if (Util.isNullOrNil(str) || !s.deleteFile(b.iIN + str)) {
                AppMethodBeat.o(131344);
                return false;
            }
            AppMethodBeat.o(131344);
            return true;
        }
    }

    public static final class e {
        public final MMHandler iJf;
        private final Map<String, List<a>> iJg;
        private final Map<String, Boolean> iJh;

        /* access modifiers changed from: package-private */
        public interface a {
            void aYe();

            void aYf();
        }

        /* synthetic */ e(MMHandler mMHandler, byte b2) {
            this(mMHandler);
        }

        private e(MMHandler mMHandler) {
            AppMethodBeat.i(131355);
            this.iJg = new HashMap();
            this.iJh = new HashMap();
            this.iJf = mMHandler;
            AppMethodBeat.o(131355);
        }

        /* access modifiers changed from: package-private */
        public final void LO(String str) {
            AppMethodBeat.i(131356);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(131356);
                return;
            }
            List<a> remove = this.iJg.remove(str);
            if (Util.isNullOrNil(remove)) {
                AppMethodBeat.o(131356);
                return;
            }
            for (a aVar : remove) {
                aVar.aYe();
            }
            AppMethodBeat.o(131356);
        }

        /* access modifiers changed from: package-private */
        public final boolean LP(String str) {
            AppMethodBeat.i(131357);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(131357);
                return false;
            }
            boolean containsKey = this.iJh.containsKey(str);
            AppMethodBeat.o(131357);
            return containsKey;
        }

        /* access modifiers changed from: package-private */
        public final void LQ(String str) {
            AppMethodBeat.i(204408);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(204408);
                return;
            }
            this.iJh.put(str, Boolean.TRUE);
            AppMethodBeat.o(204408);
        }

        /* access modifiers changed from: package-private */
        public final void LR(String str) {
            AppMethodBeat.i(131358);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(131358);
                return;
            }
            this.iJh.remove(str);
            AppMethodBeat.o(131358);
        }

        /* access modifiers changed from: package-private */
        public final void a(String str, a aVar) {
            AppMethodBeat.i(204409);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(204409);
                return;
            }
            List<a> list = this.iJg.get(str);
            if (list == null) {
                list = new LinkedList<>();
                this.iJg.put(str, list);
            }
            list.add(aVar);
            AppMethodBeat.o(204409);
        }

        /* access modifiers changed from: package-private */
        public final void b(String str, a aVar) {
            AppMethodBeat.i(131359);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(131359);
                return;
            }
            List<a> list = this.iJg.get(str);
            if (list == null) {
                AppMethodBeat.o(131359);
                return;
            }
            list.remove(aVar);
            AppMethodBeat.o(131359);
        }

        /* access modifiers changed from: package-private */
        public final void LS(String str) {
            AppMethodBeat.i(131360);
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(131360);
                return;
            }
            List<a> remove = this.iJg.remove(str);
            if (!Util.isNullOrNil(remove)) {
                for (a aVar : remove) {
                    aVar.aYf();
                }
                remove.clear();
            }
            AppMethodBeat.o(131360);
        }

        /* access modifiers changed from: package-private */
        public final void post(Runnable runnable) {
            AppMethodBeat.i(131361);
            this.iJf.post(runnable);
            AppMethodBeat.o(131361);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class n implements e.a {
        final i iIM;
        final b iJj;
        final q iJm;
        private final h iJn;
        final l iJo;
        private final f iJp;
        private final String iJq;
        boolean iJr = true;
        final Map<String, String> mHeaders;

        public n(String str, Map<String, String> map, h hVar, b bVar, l lVar, i iVar, f fVar, String str2) {
            AppMethodBeat.i(204411);
            this.iJm = new q(str, (byte) 0);
            this.mHeaders = null;
            this.iJn = hVar;
            this.iJj = bVar;
            this.iJo = lVar;
            this.iIM = iVar;
            this.iJp = fVar;
            this.iJq = str2;
            AppMethodBeat.o(204411);
        }

        /* access modifiers changed from: package-private */
        public final String aYi() {
            AppMethodBeat.i(131372);
            String aZ = b.aZ(this.iJq, aYj());
            AppMethodBeat.o(131372);
            return aZ;
        }

        /* access modifiers changed from: package-private */
        public final String aYj() {
            AppMethodBeat.i(131373);
            String b2 = b.b(this.iJm.toString(), this.iJn, this.iJp);
            AppMethodBeat.o(131373);
            return b2;
        }

        /* access modifiers changed from: package-private */
        public final void aYk() {
            AppMethodBeat.i(131374);
            try {
                Bitmap aYl = aYl();
                if (aYl != null && !aYl.isRecycled()) {
                    this.iJj.iIK.LR(this.iJm.iJy);
                    this.iJj.iIK.b(this.iJm.iJy, this);
                    L(aYl);
                    this.iJj.iIK.LO(this.iJm.iJy);
                }
                AppMethodBeat.o(131374);
            } catch (d e2) {
                Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", " doIOJobImpl, exp %s", e2);
                this.iJj.iIK.LR(this.iJm.iJy);
                this.iJj.iIK.LS(this.iJm.iJy);
                L(null);
                if (e2 instanceof d.a) {
                    this.iJj.iIM.gC(this.iJm.iJy);
                }
                AppMethodBeat.o(131374);
            } catch (IOException e3) {
                Log.printErrStackTrace("Luggage.AppBrandSimpleImageLoader.LoadTask", e3, " doIOJobImpl, io exp ", new Object[0]);
                this.iJj.iIK.LR(this.iJm.iJy);
                this.iJj.iIK.b(this.iJm.iJy, this);
                this.iJj.iIK.LO(this.iJm.iJy);
                if (e3 instanceof FileNotFoundException) {
                    L(null);
                }
                AppMethodBeat.o(131374);
            }
        }

        @Override // com.tencent.mm.modelappbrand.a.b.e.a
        public final void aYe() {
            AppMethodBeat.i(131375);
            final Bitmap EP = this.iJo.EP(aYj());
            if (EP != null && !EP.isRecycled()) {
                Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "before actually doIOJob, same keyForMemory bitmap already exists, key %s", aYj());
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.modelappbrand.a.b.n.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(131367);
                        n.this.I(EP);
                        AppMethodBeat.o(131367);
                    }
                });
                AppMethodBeat.o(131375);
            } else if (this.iJj.iIK.LP(this.iJm.iJy)) {
                this.iJj.iIK.a(this.iJm.iJy, this);
                Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "already has job processing, make this job pending, key %s", this.iJm.iJy);
                AppMethodBeat.o(131375);
            } else {
                this.iJj.iIK.LQ(this.iJm.iJy);
                aYk();
                AppMethodBeat.o(131375);
            }
        }

        @Override // com.tencent.mm.modelappbrand.a.b.e.a
        public final void aYf() {
            AppMethodBeat.i(131376);
            k kVar = (k) this.iJj.iII.remove(aYi());
            if (kVar != null) {
                this.iJj.iIH.remove(kVar);
            }
            AppMethodBeat.o(131376);
        }

        /* access modifiers changed from: package-private */
        public final void I(Bitmap bitmap) {
            AppMethodBeat.i(131377);
            k kVar = (k) this.iJj.iII.remove(aYi());
            if (kVar != null) {
                kVar.I(bitmap);
                this.iJj.iIH.remove(kVar);
            }
            AppMethodBeat.o(131377);
        }

        private Bitmap K(Bitmap bitmap) {
            AppMethodBeat.i(131378);
            Bitmap J = this.iJn.J(bitmap);
            AppMethodBeat.o(131378);
            return J;
        }

        private void L(final Bitmap bitmap) {
            boolean z = false;
            AppMethodBeat.i(131379);
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(bitmap != null && !bitmap.isRecycled());
            Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread bitmap ok %b", objArr);
            if (!(this.iJn == null || bitmap == null || bitmap.isRecycled())) {
                Bitmap K = K(bitmap);
                Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread, transform bmp, origin %s, transformed %s", bitmap, K);
                if (K != bitmap) {
                    this.iJo.f(bitmap);
                }
                bitmap = K;
            }
            Object[] objArr2 = new Object[2];
            objArr2[0] = bitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                z = true;
            }
            objArr2[1] = Boolean.valueOf(z);
            Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInWorkerThread before post to main thread, bitmap %s, ok %b", objArr2);
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.modelappbrand.a.b.n.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(131369);
                    n.this.iJo.put(n.this.aYj(), bitmap);
                    n nVar = n.this;
                    Bitmap bitmap = bitmap;
                    if (bitmap == null || bitmap.isRecycled()) {
                        Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onLoadFailed bmp %s", bitmap);
                        k kVar = (k) nVar.iJj.iII.remove(nVar.aYi());
                        if (kVar != null) {
                            kVar.oD();
                            nVar.iJj.iIH.remove(kVar);
                        }
                        AppMethodBeat.o(131369);
                        return;
                    }
                    Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "postLoadInMainThread, onBitmapLoaded bmp %s", bitmap);
                    nVar.I(bitmap);
                    AppMethodBeat.o(131369);
                }
            });
            AppMethodBeat.o(131379);
        }

        private Bitmap aYl() {
            Bitmap bitmap = null;
            AppMethodBeat.i(131380);
            if (!b.aYb()) {
                Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, sdcard unavailable");
                d.c cVar = new d.c();
                AppMethodBeat.o(131380);
                throw cVar;
            }
            InputStream openRead = this.iIM.openRead(this.iJm.iJy);
            if (openRead == null) {
                Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, null from disk, tryDownload %b", Boolean.valueOf(this.iJr));
                if (this.iJr) {
                    com.tencent.f.h.RTc.aX(new com.tencent.f.i.h() {
                        /* class com.tencent.mm.modelappbrand.a.b.n.AnonymousClass4 */

                        public final void run() {
                            AppMethodBeat.i(131371);
                            n.a(n.this.iJm, n.this.mHeaders, n.this.iIM);
                            n.this.iJj.iIK.post(new Runnable() {
                                /* class com.tencent.mm.modelappbrand.a.b.n.AnonymousClass4.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(131370);
                                    n.this.iJr = false;
                                    n.this.aYk();
                                    AppMethodBeat.o(131370);
                                }
                            });
                            AppMethodBeat.o(131371);
                        }

                        @Override // com.tencent.f.i.h, com.tencent.f.i.g
                        public final String getKey() {
                            return "AppBrandSimpleImageLoaderDownloadThread";
                        }
                    });
                } else {
                    this.iJj.iIK.LS(this.iJm.iJy);
                    this.iJj.iIK.LR(this.iJm.iJy);
                    d.b bVar = new d.b();
                    AppMethodBeat.o(131380);
                    throw bVar;
                }
            }
            if (openRead != null) {
                try {
                    bitmap = x(openRead);
                } catch (Exception e2) {
                    Log.printErrStackTrace("Luggage.AppBrandSimpleImageLoader.LoadTask", e2, " decode ", new Object[0]);
                }
                if (bitmap == null || bitmap.isRecycled()) {
                    Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decode failed, bmp %s", bitmap);
                    d.a aVar = new d.a();
                    AppMethodBeat.o(131380);
                    throw aVar;
                }
                Log.d("Luggage.AppBrandSimpleImageLoader.LoadTask", "loadFromDiskOrTriggerDownload, decoded bmp %s, size %d KB, url %s", bitmap, Integer.valueOf(android.support.v4.graphics.a.c(bitmap) / 1024), this.iJm);
                AppMethodBeat.o(131380);
            } else {
                AppMethodBeat.o(131380);
            }
            return bitmap;
        }

        private Bitmap x(InputStream inputStream) {
            AppMethodBeat.i(131381);
            try {
                if (this.iJp != null) {
                    return this.iJp.w(inputStream);
                }
                Bitmap decodeStream = b.aYc().decodeStream(inputStream);
                Util.qualityClose(inputStream);
                AppMethodBeat.o(131381);
                return decodeStream;
            } finally {
                Util.qualityClose(inputStream);
                AppMethodBeat.o(131381);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:36:0x0064, code lost:
            if (r3 != null) goto L_0x0066;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            r4.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x008a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x008b, code lost:
            r2.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x008f, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0090, code lost:
            r1 = r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a7, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:50:0x00a8, code lost:
            r3.addSuppressed(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ac, code lost:
            r4.close();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x004c  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x008f A[ExcHandler: all (r0v4 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:4:0x000f] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static void a(com.tencent.mm.modelappbrand.a.b.q r10, java.util.Map<java.lang.String, java.lang.String> r11, com.tencent.mm.modelappbrand.a.b.i r12) {
            /*
            // Method dump skipped, instructions count: 185
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelappbrand.a.b.n.a(com.tencent.mm.modelappbrand.a.b$q, java.util.Map, com.tencent.mm.modelappbrand.a.b$i):void");
        }
    }

    static {
        AppMethodBeat.i(131403);
        com.tencent.mm.vfs.o X = com.tencent.mm.vfs.o.X(MMApplicationContext.getContext().getExternalCacheDir());
        if (X == null) {
            X = com.tencent.mm.vfs.o.X(MMApplicationContext.getContext().getCacheDir());
        }
        if (X != null) {
            LH(aa.z(X.her()));
        }
        AppMethodBeat.o(131403);
    }

    public static void LH(String str) {
        AppMethodBeat.i(176003);
        if (!str.endsWith(FilePathGenerator.ANDROID_DIR_SEP)) {
            str = str + FilePathGenerator.ANDROID_DIR_SEP;
        }
        String str2 = str + "wxacache/";
        iIN = str2;
        s.boN(str2);
        AppMethodBeat.o(176003);
    }

    private static String LI(String str) {
        AppMethodBeat.i(131396);
        String str2 = null;
        if (!Util.isNullOrNil(str)) {
            str2 = com.tencent.mm.b.g.getMessageDigest(str.getBytes());
        }
        AppMethodBeat.o(131396);
        return str2;
    }

    public final void LJ(String str) {
        AppMethodBeat.i(131397);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(131397);
            return;
        }
        String LI = LI(str);
        if (this.iIK.LP(LI)) {
            AppMethodBeat.o(131397);
            return;
        }
        this.iIM.gC(LI);
        AppMethodBeat.o(131397);
    }

    public final void LK(String str) {
        AppMethodBeat.i(161227);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(161227);
            return;
        }
        this.iIL.LN(str);
        AppMethodBeat.o(161227);
    }

    public static final class q {
        private final String iJx;
        public final String iJy;

        public /* synthetic */ q(String str, byte b2) {
            this(str);
        }

        private q(String str) {
            AppMethodBeat.i(204414);
            if (TextUtils.isEmpty(str)) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                AppMethodBeat.o(204414);
                throw illegalArgumentException;
            }
            this.iJx = str;
            this.iJy = b.LL(str);
            AppMethodBeat.o(204414);
        }

        public final String toString() {
            return this.iJx;
        }

        /* access modifiers changed from: package-private */
        public final InputStream D(Map<String, String> map) {
            AppMethodBeat.i(204415);
            if (this.iJx.startsWith("file://") || this.iJx.startsWith("wcf://")) {
                try {
                    InputStream openRead = s.openRead(this.iJx);
                    AppMethodBeat.o(204415);
                    return openRead;
                } catch (FileNotFoundException e2) {
                    Log.printErrStackTrace("Luggage.AppBrandSimpleImageLoader", e2, "load from local file %s", this.iJx);
                    AppMethodBeat.o(204415);
                    throw e2;
                }
            } else {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.iJx).openConnection();
                a(httpURLConnection, map);
                try {
                    if (httpURLConnection.getResponseCode() == 301 || httpURLConnection.getResponseCode() == 302) {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        try {
                            httpURLConnection.getInputStream().close();
                            httpURLConnection.disconnect();
                        } catch (Throwable th) {
                        }
                        if (URLUtil.isAboutUrl(headerField) || !URLUtil.isNetworkUrl(headerField)) {
                            MalformedURLException malformedURLException = new MalformedURLException(String.format("Origin %s, Location %s", this.iJx, headerField));
                            AppMethodBeat.o(204415);
                            throw malformedURLException;
                        }
                        httpURLConnection = (HttpURLConnection) new URL(headerField).openConnection();
                        httpURLConnection.setInstanceFollowRedirects(false);
                        a(httpURLConnection, map);
                    }
                    final com.tencent.mm.plugin.appbrand.ac.i iVar = new com.tencent.mm.plugin.appbrand.ac.i(httpURLConnection);
                    AnonymousClass1 r0 = new BufferedInputStream(httpURLConnection.getInputStream()) {
                        /* class com.tencent.mm.modelappbrand.a.b.q.AnonymousClass1 */

                        @Override // java.io.FilterInputStream, java.io.BufferedInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
                        public final void close() {
                            AppMethodBeat.i(204413);
                            try {
                                super.close();
                            } finally {
                                org.apache.commons.a.e.a((URLConnection) iVar.value);
                                AppMethodBeat.o(204413);
                            }
                        }
                    };
                    AppMethodBeat.o(204415);
                    return r0;
                } catch (ArrayIndexOutOfBoundsException e3) {
                    IOException iOException = new IOException(e3);
                    AppMethodBeat.o(204415);
                    throw iOException;
                } catch (Exception e4) {
                    IOException iOException2 = new IOException(e4);
                    AppMethodBeat.o(204415);
                    throw iOException2;
                }
            }
        }

        private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
            AppMethodBeat.i(204416);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    Log.i("Luggage.AppBrandSimpleImageLoader", "setHeaders, header: %s: %s", entry.getKey(), entry.getValue());
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
            AppMethodBeat.o(204416);
        }
    }

    public final void a(final String str, final j jVar) {
        AppMethodBeat.i(183777);
        byte[] LG = LG(str);
        if (LG == null || LG.length == 0) {
            b(new k() {
                /* class com.tencent.mm.modelappbrand.a.b.AnonymousClass3 */

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void aYg() {
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void I(Bitmap bitmap) {
                    AppMethodBeat.i(131339);
                    com.tencent.mm.plugin.appbrand.ac.m.bZn().postToWorker(new Runnable() {
                        /* class com.tencent.mm.modelappbrand.a.b.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(131338);
                            byte[] a2 = b.a(b.this, str);
                            if (jVar != null) {
                                jVar.aj(a2);
                            }
                            AppMethodBeat.o(131338);
                        }
                    });
                    AppMethodBeat.o(131339);
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k
                public final void oD() {
                    AppMethodBeat.i(131340);
                    if (jVar != null) {
                        jVar.aj(null);
                    }
                    AppMethodBeat.o(131340);
                }

                @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                public final String Lb() {
                    return "BytesLoadTarget";
                }
            }, str, null, null);
            AppMethodBeat.o(183777);
            return;
        }
        jVar.aj(LG);
        AppMethodBeat.o(183777);
    }

    public static void a(g gVar) {
        synchronized (o.iJw) {
            iIO = gVar;
        }
    }

    private static g aXZ() {
        g gVar;
        synchronized (o.iJw) {
            gVar = iIO;
        }
        return gVar;
    }

    static /* synthetic */ boolean aYb() {
        AppMethodBeat.i(204425);
        if (TextUtils.isEmpty(iIN)) {
            AppMethodBeat.o(204425);
            return false;
        }
        boolean canWrite = new com.tencent.mm.vfs.o(iIN).canWrite();
        AppMethodBeat.o(204425);
        return canWrite;
    }
}
