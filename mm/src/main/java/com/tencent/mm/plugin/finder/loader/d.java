package com.tencent.mm.plugin.finder.loader;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.e.c.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J<\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00142\u0010\u0010\u0015\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderBlurBitmapProducer;", "Lcom/tencent/mm/loader/impr/transcoder/ResourceTranscoder;", "Landroid/graphics/Bitmap;", "blurRadius", "", "extraBgColor", "", "(FLjava/lang/Integer;)V", "getBlurRadius", "()F", "setBlurRadius", "(F)V", "getExtraBgColor", "()Ljava/lang/Integer;", "setExtraBgColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "asResource", "Lcom/tencent/mm/loader/model/Resource;", "targetView", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "reaper", "Lcom/tencent/mm/loader/Reaper;", "input", "asResourceName", "", "source", "Companion", "plugin-finder_release"})
public final class d extends b<Bitmap> {
    public static final a uIl = new a((byte) 0);
    private float uIj = 25.0f;
    private Integer uIk;

    static {
        AppMethodBeat.i(248210);
        AppMethodBeat.o(248210);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/loader/FinderBlurBitmapProducer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public d(Integer num) {
        this.uIk = num;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c3 A[SYNTHETIC, Splitter:B:24:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e7 A[SYNTHETIC, Splitter:B:31:0x00e7] */
    @Override // com.tencent.mm.loader.d.f
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.tencent.mm.loader.h.e<? extends android.graphics.Bitmap> a(com.tencent.mm.loader.e.b.g<?> r8, com.tencent.mm.loader.f<?, android.graphics.Bitmap> r9, com.tencent.mm.loader.h.e<android.graphics.Bitmap> r10) {
        /*
        // Method dump skipped, instructions count: 270
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.loader.d.a(com.tencent.mm.loader.e.b.g, com.tencent.mm.loader.f, com.tencent.mm.loader.h.e):com.tencent.mm.loader.h.e");
    }

    @Override // com.tencent.mm.loader.d.f
    public final String Hi(String str) {
        AppMethodBeat.i(248209);
        p.h(str, "source");
        AppMethodBeat.o(248209);
        return str;
    }
}
