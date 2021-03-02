package com.tencent.mm.cache;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.x.a;
import com.tencent.mm.z.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0014J\n\u0010 \u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010!\u001a\u00020\u000bH\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\b\u0010%\u001a\u00020\u001bH\u0016J\u0018\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020#H\u0016J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020#H\u0016J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020#H\u0016J\b\u0010.\u001a\u00020\u0002H\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u00100\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u00020#H\u0016J\b\u00104\u001a\u00020\u001bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u00065"}, hxF = {"Lcom/tencent/mm/cache/FilterCache;", "Lcom/tencent/mm/cache/IBaseArtistCache;", "Lcom/tencent/mm/items/FilterItem;", "()V", "curColorWeight", "", "getCurColorWeight", "()F", "setCurColorWeight", "(F)V", "curSeletedTypeIndex", "", "getCurSeletedTypeIndex", "()I", "setCurSeletedTypeIndex", "(I)V", "effects", "", "getEffects", "()Ljava/util/List;", "preBitmap", "Landroid/graphics/Bitmap;", "getPreBitmap", "()Landroid/graphics/Bitmap;", "setPreBitmap", "(Landroid/graphics/Bitmap;)V", "add", "", "item", "clear", "clone", "", "getCacheFromLocal", "getUndoCount", "isUndoEnable", "", "onCreate", "onDestroy", "onDrawCache", "canvas", "Landroid/graphics/Canvas;", "isOverDraw", "onFinalGenerate", "onRestore", "isExit", "onSave", "peek", "pop", "saveCacheToLocal", "bitmap", "size", "isAlive", "undo", "plugin-photoedit-sdk_release"})
public final class e implements f<d> {
    private final List<d> effects;
    public int gpC;
    public float gpD;
    public Bitmap gpE;

    public e() {
        AppMethodBeat.i(163146);
        a aVar = a.hiy;
        List<a.C2173a> axh = a.axh();
        ArrayList arrayList = new ArrayList(j.a(axh, 10));
        Iterator<T> it = axh.iterator();
        while (it.hasNext()) {
            arrayList.add(new d(it.next().type));
        }
        this.effects = arrayList;
        AppMethodBeat.o(163146);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.cache.f
    public final /* bridge */ /* synthetic */ void add(d dVar) {
    }

    @Override // com.tencent.mm.cache.f
    public final void onCreate() {
    }

    @Override // com.tencent.mm.cache.f
    public final void onDestroy() {
    }

    @Override // com.tencent.mm.cache.f
    public final void dl(boolean z) {
        this.gpC = 0;
        this.gpD = 0.0f;
    }

    @Override // com.tencent.mm.cache.f
    public final void alC() {
    }

    @Override // com.tencent.mm.cache.f
    public final void a(Canvas canvas, boolean z) {
        AppMethodBeat.i(163142);
        p.h(canvas, "canvas");
        Bitmap bitmap = this.gpE;
        if (bitmap != null) {
            this.effects.get(this.gpC).a(canvas, bitmap, this.gpD);
            AppMethodBeat.o(163142);
            return;
        }
        AppMethodBeat.o(163142);
    }

    @Override // com.tencent.mm.cache.f
    public final void e(Canvas canvas) {
        AppMethodBeat.i(163143);
        p.h(canvas, "canvas");
        Bitmap bitmap = this.gpE;
        if (bitmap != null) {
            this.effects.get(this.gpC).a(canvas, bitmap, this.gpD);
            AppMethodBeat.o(163143);
            return;
        }
        AppMethodBeat.o(163143);
    }

    @Override // com.tencent.mm.cache.f
    public final void clear() {
    }

    @Override // com.tencent.mm.cache.f
    public final int ai(boolean z) {
        return 0;
    }

    @Override // com.tencent.mm.cache.f
    public final void Ya() {
    }

    @Override // java.lang.Object
    public final Object clone() {
        AppMethodBeat.i(163145);
        Object obj = new Object();
        AppMethodBeat.o(163145);
        return obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.tencent.mm.cache.f
    public final /* synthetic */ d pop() {
        AppMethodBeat.i(163144);
        d dVar = new d(1);
        AppMethodBeat.o(163144);
        return dVar;
    }
}
