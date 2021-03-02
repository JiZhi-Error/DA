package com.tencent.mm.loader.b.a;

import android.graphics.Bitmap;
import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.f.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0004J0\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J0\u0010\u000f\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016J0\u0010\u0011\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016JZ\u0010\u0012\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache;", "T", "Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "Landroid/graphics/Bitmap;", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "delete", "", "exists", "save", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "source", "Lcom/tencent/mm/loader/model/Resource;", "resource", "Companion", "libimageloader_release"})
public abstract class a<T> extends d<T, Bitmap> {
    private static final String TAG = TAG;
    public static final C0398a hYH = new C0398a((byte) 0);
    private g hYG = new com.tencent.mm.loader.e.a();

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: com.tencent.mm.loader.f<?, android.graphics.Bitmap> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007a, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007b, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0081, code lost:
        r2 = r1;
     */
    @Override // com.tencent.mm.loader.b.a.d
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.tencent.mm.loader.h.a.a<T> r7, com.tencent.mm.loader.h.f<?> r8, com.tencent.mm.loader.h.e<android.graphics.Bitmap> r9, com.tencent.mm.loader.h.e<android.graphics.Bitmap> r10, com.tencent.mm.loader.c.e r11, com.tencent.mm.loader.f<?, android.graphics.Bitmap> r12) {
        /*
        // Method dump skipped, instructions count: 133
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.loader.b.a.a.a(com.tencent.mm.loader.h.a.a, com.tencent.mm.loader.h.f, com.tencent.mm.loader.h.e, com.tencent.mm.loader.h.e, com.tencent.mm.loader.c.e, com.tencent.mm.loader.f):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.tencent.mm.loader.f<?, android.graphics.Bitmap> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.loader.b.a.d
    public String c(com.tencent.mm.loader.h.a.a<T> aVar, e eVar, f<?, Bitmap> fVar) {
        p.h(aVar, "url");
        p.h(eVar, "opts");
        p.h(fVar, "reaper");
        return super.c(aVar, eVar, fVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/loader/cache/disk/BitmapDiskCache$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.b.a.a$a  reason: collision with other inner class name */
    public static final class C0398a {
        private C0398a() {
        }

        public /* synthetic */ C0398a(byte b2) {
            this();
        }
    }
}
