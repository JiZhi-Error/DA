package com.tencent.mm.plugin.gallery.model;

import android.graphics.Bitmap;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.gallery.model.s;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class d {
    MStorageEvent<b, String> iKx = new MStorageEvent<b, String>() {
        /* class com.tencent.mm.plugin.gallery.model.d.AnonymousClass1 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.sdk.storage.MStorageEvent
        public final /* synthetic */ void processEvent(b bVar, String str) {
            AppMethodBeat.i(111251);
            bVar.ayR(str);
            AppMethodBeat.o(111251);
        }
    };
    final byte[] lock = new byte[0];
    f<String, a> xib = new com.tencent.mm.memory.a.b(200, new f.b<String, a>() {
        /* class com.tencent.mm.plugin.gallery.model.d.AnonymousClass2 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
        @Override // com.tencent.mm.b.f.b
        public final /* synthetic */ void c(String str, a aVar, a aVar2) {
            AppMethodBeat.i(179448);
            String str2 = str;
            a aVar3 = aVar;
            if (aVar3 == null) {
                Log.d("MicroMsg.GalleryCache", "BitmapReference is null.");
                AppMethodBeat.o(179448);
            } else if (aVar3.bitmap == null) {
                Log.d("MicroMsg.GalleryCache", "get is null.");
                AppMethodBeat.o(179448);
            } else {
                Log.i("MicroMsg.GalleryCache", "bitmap recycle %s.", aVar3.bitmap.toString());
                aVar3.bitmap.recycle();
                Log.d("MicroMsg.GalleryCache", "gallery remove ", str2);
                AppMethodBeat.o(179448);
            }
        }
    }, getClass());
    f xic;
    CopyOnWriteArrayList<String> xid = new CopyOnWriteArrayList<>();
    ConcurrentHashMap<String, b> xie = new ConcurrentHashMap<>();

    public interface b {
        void ayR(String str);

        String dQG();
    }

    public d() {
        AppMethodBeat.i(111254);
        f fVar = new f();
        fVar.xix = MMApplicationContext.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getInt("com.tencent.mm.gallery.cache.suffix", 0);
        Log.d("MicroMsg.DiskCache", "pennqin debug disk cache current suffix: %s.", Integer.valueOf(fVar.xix));
        fVar.dQU();
        fVar.NB(-1);
        this.xic = fVar;
        this.iKx.add(new b() {
            /* class com.tencent.mm.plugin.gallery.model.d.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.gallery.model.d.b
            public final void ayR(String str) {
                AppMethodBeat.i(179449);
                Log.d("MicroMsg.GalleryCache", "now listener size : " + d.this.xie.size());
                if (BuildInfo.DEBUG) {
                    Iterator<Map.Entry<String, b>> it = d.this.xie.entrySet().iterator();
                    while (it.hasNext()) {
                        Log.d("MicroMsg.GalleryCache", "decodeTaskKey: %s.", it.next().getKey());
                    }
                }
                Log.d("MicroMsg.GalleryCache", "will hit??? decodeTaskKey: %s.", str);
                if (d.this.xie.containsKey(str)) {
                    Log.d("MicroMsg.GalleryCache", "hit!!!");
                    b bVar = d.this.xie.get(str);
                    if (bVar != null) {
                        bVar.ayR(str);
                    }
                    AppMethodBeat.o(179449);
                    return;
                }
                Log.w("MicroMsg.GalleryCache", "not hit!!!");
                AppMethodBeat.o(179449);
            }

            @Override // com.tencent.mm.plugin.gallery.model.d.b
            public final String dQG() {
                return "";
            }
        }, (Looper) null);
        AppMethodBeat.o(111254);
    }

    public final Bitmap getBitmap(String str) {
        AppMethodBeat.i(111255);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.GalleryCache", "null filepath");
            AppMethodBeat.o(111255);
            return null;
        } else if (this.xib == null) {
            Log.w("MicroMsg.GalleryCache", "want to get bitmap, but gallery cache is null");
            AppMethodBeat.o(111255);
            return null;
        } else {
            if (this.xib.check(str)) {
                a aT = this.xib.aT(str);
                if (aT == null) {
                    Log.d("MicroMsg.GalleryCache", "weakreference is null! %s", str);
                    this.xib.remove(str);
                    AppMethodBeat.o(111255);
                    return null;
                }
                Bitmap bitmap = aT.bitmap;
                if (bitmap == null) {
                    this.xib.remove(str);
                    Log.i("MicroMsg.GalleryCache", "get bitmap is null! %s", str);
                } else if (bitmap.isRecycled()) {
                    Log.i("MicroMsg.GalleryCache", "cache bitmap has recycled: %s", str);
                    this.xib.remove(str);
                    AppMethodBeat.o(111255);
                    return null;
                } else {
                    Log.i("MicroMsg.GalleryCache", "get cached bitmap:".concat(String.valueOf(str)));
                    AppMethodBeat.o(111255);
                    return bitmap;
                }
            }
            AppMethodBeat.o(111255);
            return null;
        }
    }

    public final void a(String str, Bitmap bitmap, int i2, s.e eVar, boolean z, int i3, long j2) {
        AppMethodBeat.i(179450);
        if (this.xib == null) {
            Log.e("MicroMsg.GalleryCache", "cache is null");
            AppMethodBeat.o(179450);
            return;
        }
        this.xib.x(com.tencent.mm.plugin.gallery.a.d.a(str, eVar, j2), new a(bitmap, i2));
        if (!z) {
            this.iKx.event(com.tencent.mm.plugin.gallery.a.d.a(str, eVar, i3));
            this.iKx.doNotify();
        }
        AppMethodBeat.o(179450);
    }

    public final Bitmap b(String str, String str2, s.e eVar, long j2) {
        Bitmap NE;
        AppMethodBeat.i(179451);
        synchronized (this.lock) {
            try {
                if (this.xic == null) {
                    NE = null;
                } else {
                    if (!Util.isNullOrNil(str)) {
                        str2 = str;
                    }
                    String a2 = com.tencent.mm.plugin.gallery.a.d.a(str2, eVar, j2);
                    int hashCode = a2.hashCode();
                    Log.d("MicroMsg.GalleryCache", "keyStr: %s keyInt: %s.", a2, Integer.valueOf(hashCode));
                    NE = this.xic.NE(hashCode);
                    AppMethodBeat.o(179451);
                }
            } finally {
                AppMethodBeat.o(179451);
            }
        }
        return NE;
    }

    public final void a(String str, String str2, Bitmap bitmap, s.e eVar, long j2) {
        AppMethodBeat.i(179452);
        synchronized (this.lock) {
            if (bitmap != null) {
                try {
                    if (!bitmap.isRecycled()) {
                        if (this.xic != null) {
                            if (!Util.isNullOrNil(str)) {
                                str2 = str;
                            }
                            this.xic.a(com.tencent.mm.plugin.gallery.a.d.a(str2, eVar, j2).hashCode(), bitmap);
                            AppMethodBeat.o(179452);
                            return;
                        }
                        return;
                    }
                } finally {
                    AppMethodBeat.o(179452);
                }
            }
            Log.e("MicroMsg.GalleryCache", "saveBitmapToDiskCache bmp is null. wtf!!! tell pennqin!!!");
            AppMethodBeat.o(179452);
        }
    }

    public final void dQF() {
        AppMethodBeat.i(111259);
        this.xid.clear();
        this.xie.clear();
        AppMethodBeat.o(111259);
    }

    /* access modifiers changed from: package-private */
    public class a {
        Bitmap bitmap;
        private int type;

        public a(Bitmap bitmap2, int i2) {
            this.bitmap = bitmap2;
            this.type = i2;
        }
    }
}
