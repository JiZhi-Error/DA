package com.tencent.mm.loader.b.a;

import android.graphics.Bitmap;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.h.f;
import com.tencent.mm.vfs.r;
import java.io.FileNotFoundException;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\fH\u0016J0\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\fH\u0016J0\u0010\u0011\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\fH\u0016J3\u0010\u0012\u001a\u0004\u0018\u00010\u00132\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\fH\u0002J@\u0010\u0014\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\fH\u0016JL\u0010\u0017\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\fH\u0016JZ\u0010\u001b\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00102\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/loader/cache/disk/DefaultImageDiskCache;", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "", "Landroid/graphics/Bitmap;", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "clear", "", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "delete", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "exists", "get", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "onSaveCompleted", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "Companion", "libimageloader_release"})
public final class b extends d<String, Bitmap> {
    private static final String TAG = TAG;
    public static final a hYI = new a((byte) 0);
    private g hYG = new com.tencent.mm.loader.e.a();

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007a, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007b, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0080, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0081, code lost:
        r2 = r1;
     */
    @Override // com.tencent.mm.loader.b.a.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.mm.loader.h.a.a<java.lang.String> r7, com.tencent.mm.loader.h.f<?> r8, com.tencent.mm.loader.h.e<android.graphics.Bitmap> r9, com.tencent.mm.loader.h.e<android.graphics.Bitmap> r10, com.tencent.mm.loader.c.e r11, com.tencent.mm.loader.f<?, android.graphics.Bitmap> r12) {
        /*
        // Method dump skipped, instructions count: 131
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.loader.b.a.b.a(com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.h.f, com.tencent.mm.loader.h.e, com.tencent.mm.loader.h.e, com.tencent.mm.loader.c.e, com.tencent.mm.loader.f):boolean");
    }

    @Override // com.tencent.mm.loader.b.a.d
    public final boolean a(com.tencent.mm.loader.h.a.a<String> aVar, f<?> fVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar2) {
        p.h(aVar, "url");
        p.h(fVar, "httpResponse");
        p.h(eVar, "opts");
        p.h(fVar2, "reaper");
        return true;
    }

    @Override // com.tencent.mm.loader.b.a.d
    public final boolean a(com.tencent.mm.loader.h.a.a<String> aVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        p.h(aVar, "url");
        p.h(eVar, "opts");
        p.h(fVar, "reaper");
        return true;
    }

    @Override // com.tencent.mm.loader.b.a.d
    public final com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<String> aVar, e eVar, com.tencent.mm.loader.f<?, Bitmap> fVar) {
        p.h(aVar, "url");
        p.h(eVar, "opts");
        p.h(fVar, "reaper");
        try {
            if (aVar.aKr() == com.tencent.mm.loader.h.a.b.ASSET_DATA) {
                return com.tencent.mm.loader.h.b.a.Hl(aVar.aKs());
            }
            if (aVar.aKr() == com.tencent.mm.loader.h.a.b.LOCAL_PATH) {
                return com.tencent.mm.loader.h.b.a.j(aVar.aKs(), com.tencent.mm.vending.j.b.ep(aVar.aKs()));
            }
            try {
                String c2 = c(aVar, eVar, fVar);
                String str = c2;
                if (str == null || str.length() == 0) {
                    return null;
                }
                return com.tencent.mm.loader.h.b.a.a(new r(c2), new r(c2));
            } catch (FileNotFoundException e2) {
                return null;
            }
        } catch (Exception e3) {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/loader/cache/disk/DefaultImageDiskCache$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }
}
