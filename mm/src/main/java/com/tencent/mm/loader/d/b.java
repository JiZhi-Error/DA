package com.tencent.mm.loader.d;

import com.tencent.mm.loader.f.g;
import com.tencent.mm.loader.h.f;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ&\u0010\u000e\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000fH$¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/loader/common/IDataFetcher;", "T", "", "()V", "loadData", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "fileNameCreator", "Lcom/tencent/mm/loader/listener/ILoadFileNameCreator;", "loader", "Lcom/tencent/mm/loader/loader/ITaskLoader;", "callback", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "loadDataImp", "Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "IDataReady", "IDataReady2", "libimageloader_release"})
public abstract class b<T> {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady;", "", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"})
    public interface a {
        void a(f<?> fVar);

        void onError();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bd\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, hxF = {"Lcom/tencent/mm/loader/common/IDataFetcher$IDataReady2;", "", "onDataReady", "", "resp", "Lcom/tencent/mm/loader/model/Response;", "onError", "onTransferToBatchGet", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.d.b$b  reason: collision with other inner class name */
    public interface AbstractC0401b {
        void a(f<?> fVar);

        void onError();
    }

    /* access modifiers changed from: protected */
    public abstract void a(com.tencent.mm.loader.h.a.a<T> aVar, g gVar, AbstractC0401b bVar);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "T", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ b iaa;
        final /* synthetic */ com.tencent.mm.loader.g.b iab;
        final /* synthetic */ com.tencent.mm.loader.h.a.a iac;
        final /* synthetic */ g iad;
        final /* synthetic */ a iae;

        public c(b bVar, com.tencent.mm.loader.g.b bVar2, com.tencent.mm.loader.h.a.a aVar, g gVar, a aVar2) {
            this.iaa = bVar;
            this.iab = bVar2;
            this.iac = aVar;
            this.iad = gVar;
            this.iae = aVar2;
        }

        public final void run() {
            this.iab.execute(new Runnable(this) {
                /* class com.tencent.mm.loader.d.b.c.AnonymousClass1 */
                final /* synthetic */ c iaf;

                {
                    this.iaf = r1;
                }

                public final void run() {
                    this.iaf.iaa.a(this.iaf.iac, this.iaf.iad, new AbstractC0401b(this) {
                        /* class com.tencent.mm.loader.d.b.c.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 iag;

                        /* JADX WARN: Incorrect args count in method signature: ()V */
                        {
                            this.iag = r1;
                        }

                        @Override // com.tencent.mm.loader.d.b.AbstractC0401b
                        public final void a(f<?> fVar) {
                            p.h(fVar, "resp");
                            this.iag.iaf.iae.a(fVar);
                        }

                        @Override // com.tencent.mm.loader.d.b.AbstractC0401b
                        public final void onError() {
                            this.iag.iaf.iae.onError();
                        }
                    });
                }
            });
        }
    }
}
