package com.tencent.mm.loader.b.a;

import com.tencent.mm.loader.c.e;
import com.tencent.mm.loader.f;
import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.l.b;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 #*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0001#B\u0005¢\u0006\u0002\u0010\u0004J0\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u000eH\u0016J\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u000eH&J6\u0010\u0011\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00122\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u000eJ0\u0010\u0013\u001a\u00020\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u000eH&J0\u0010\u0015\u001a\u0004\u0018\u00010\u00162\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u000eJ0\u0010\u0017\u001a\u00020\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u000eH&J3\u0010\u0018\u001a\u0004\u0018\u00010\u00162\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u000eH¦\u0002J0\u0010\u0019\u001a\u00020\u00102\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u000eH\u0002J@\u0010\u001a\u001a\u00020\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001c2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u000eH&JL\u0010\u001d\u001a\u00020\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001c2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u000eH&JZ\u0010!\u001a\u00020\u00142\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00010\u001c2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001c2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00010\u000eH&R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, hxF = {"Lcom/tencent/mm/loader/cache/disk/IDiskCache;", "T", "R", "", "()V", "mFileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "buildFilePath", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "opts", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "clear", "", "configure", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "delete", "", "diskGet", "Lcom/tencent/mm/loader/model/datasource/DataSource;", "exists", "get", "makeConfig", "onSaveCompleted", "diskResource", "Lcom/tencent/mm/loader/model/Resource;", "onSaveStarted", "httpResponse", "Lcom/tencent/mm/loader/model/Response;", "resource", "save", "source", "Companion", "libimageloader_release"})
public abstract class d<T, R> {
    private static final String TAG = TAG;
    public static final a hYK = new a((byte) 0);
    private g hYG;

    public abstract boolean a(com.tencent.mm.loader.h.a.a<T> aVar, e eVar, f<?, R> fVar);

    public abstract boolean a(com.tencent.mm.loader.h.a.a<T> aVar, com.tencent.mm.loader.h.f<?> fVar, e eVar, f<?, R> fVar2);

    public abstract boolean a(com.tencent.mm.loader.h.a.a<T> aVar, com.tencent.mm.loader.h.f<?> fVar, com.tencent.mm.loader.h.e<R> eVar, com.tencent.mm.loader.h.e<R> eVar2, e eVar3, f<?, R> fVar2);

    public abstract com.tencent.mm.loader.h.b.a b(com.tencent.mm.loader.h.a.a<T> aVar, e eVar, f<?, R> fVar);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/loader/cache/disk/IDiskCache$Companion;", "", "()V", "TAG", "", "libimageloader_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public String c(com.tencent.mm.loader.h.a.a<T> aVar, e eVar, f<?, R> fVar) {
        p.h(aVar, "url");
        p.h(eVar, "opts");
        p.h(fVar, "reaper");
        String str = eVar.fullPath;
        if (str == null || str.length() == 0) {
            str = eVar.fullPath;
        }
        if (str == null || str.length() == 0) {
            StringBuilder append = new StringBuilder().append(b.icU).append(FilePathGenerator.ANDROID_DIR_SEP);
            g gVar = this.hYG;
            if (gVar == null) {
                p.hyc();
            }
            str = append.append(gVar.c(aVar)).toString();
        }
        return (str == null || str.length() == 0) ? "" : str;
    }
}
