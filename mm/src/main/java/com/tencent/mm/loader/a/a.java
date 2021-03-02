package com.tencent.mm.loader.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.loader.c.d;
import com.tencent.mm.loader.e.b.c;
import com.tencent.mm.loader.e.b.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2 \u0010\r\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\n\u0018\u00010\u000eJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J'\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0013\"\u0004\b\u0001\u0010\u00142\u0006\u0010\u000b\u001a\u0002H\u0014H\u0016¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/loader/builder/BitmapRequestBuilder;", "T", "Lcom/tencent/mm/loader/builder/RequestBuilder;", "Landroid/graphics/Bitmap;", "reqValue", "Lcom/tencent/mm/loader/model/data/DataItem;", "mImageLoaderConfiguration", "Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;", "(Lcom/tencent/mm/loader/model/data/DataItem;Lcom/tencent/mm/loader/cfg/ILoaderConfiguration;)V", "into", "", "imageView", "Landroid/widget/ImageView;", "onTaskEnd", "Lkotlin/Function2;", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "needDefault", "", "withStruct", "Lcom/tencent/mm/loader/IRequestBuilder;", "V", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/IRequestBuilder;", "libimageloader_release"})
public final class a<T> extends b<T, Bitmap> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(com.tencent.mm.loader.h.a.a<T> aVar, d<T, Bitmap> dVar) {
        super(aVar, dVar);
        p.h(aVar, "reqValue");
        p.h(dVar, "mImageLoaderConfiguration");
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014¨\u0006\b"}, hxF = {"com/tencent/mm/loader/builder/BitmapRequestBuilder$into$1", "Lcom/tencent/mm/loader/impr/target/ImageViewShowTarget;", "onResourceReadyUI", "", "resource", "Landroid/graphics/Bitmap;", "viewWeakHolder", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "libimageloader_release"})
    /* renamed from: com.tencent.mm.loader.a.a$a  reason: collision with other inner class name */
    public static final class C0397a extends c {
        final /* synthetic */ m hYB;
        final /* synthetic */ ImageView hYC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0397a(m mVar, ImageView imageView, g gVar) {
            super(gVar);
            this.hYB = mVar;
            this.hYC = imageView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.loader.e.b.g] */
        @Override // com.tencent.mm.loader.e.b.c, com.tencent.mm.loader.e.b.d, com.tencent.mm.loader.e.b.f
        public final /* bridge */ /* synthetic */ boolean a(Bitmap bitmap, g gVar) {
            return a(bitmap, (g<?>) gVar);
        }

        @Override // com.tencent.mm.loader.e.b.c, com.tencent.mm.loader.e.b.f
        public final boolean a(Bitmap bitmap, g<?> gVar) {
            p.h(gVar, "viewWeakHolder");
            boolean a2 = super.a(bitmap, gVar);
            m mVar = this.hYB;
            if (mVar != null) {
                mVar.invoke(gVar, bitmap);
            }
            return a2;
        }
    }

    public final void a(ImageView imageView, m<? super g<?>, ? super Bitmap, x> mVar) {
        p.h(imageView, "imageView");
        if (this.hYt == null) {
            this.hYt = new C0397a(mVar, imageView, new g(imageView));
        }
        vC();
    }

    @Override // com.tencent.mm.loader.b
    public final void c(ImageView imageView) {
        p.h(imageView, "imageView");
        if (this.hYt == null) {
            this.hYt = new c(new g(imageView, this.hYD));
        }
        vC();
    }

    @Override // com.tencent.mm.loader.b
    public final void a(ImageView imageView, boolean z) {
        p.h(imageView, "imageView");
        if (this.hYt == null) {
            this.hYt = new c(new g(imageView, this.hYD), z);
        }
        vC();
    }

    @Override // com.tencent.mm.loader.a.b, com.tencent.mm.loader.b
    public final void aJw() {
        if (this.hYt == null) {
            this.hYt = new com.tencent.mm.loader.e.b.a();
        }
        vC();
    }
}
