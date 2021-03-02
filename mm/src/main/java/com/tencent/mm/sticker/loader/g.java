package com.tencent.mm.sticker.loader;

import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.j;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u000e\u001a\u00020\u000b2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tJ\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/sticker/loader/StickerTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "info", "Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "(Lcom/tencent/mm/sticker/loader/StickerLoadInfo;)V", "TAG", "", "callbackList", "Ljava/util/LinkedList;", "Lkotlin/Function1;", "", "", "getInfo", "()Lcom/tencent/mm/sticker/loader/StickerLoadInfo;", "addCallback", "callback", "cancel", "onResult", "success", "plugin-sticker_release"})
public abstract class g extends c {
    final LinkedList<b<Boolean, x>> NNT = new LinkedList<>();
    public final StickerLoadInfo NNU;
    private final String TAG = "MicroMsg.StickerTask";

    public g(StickerLoadInfo stickerLoadInfo) {
        p.h(stickerLoadInfo, "info");
        this.NNU = stickerLoadInfo;
    }

    public void dQ(boolean z) {
        Iterator<T> it = this.NNT.iterator();
        while (it.hasNext()) {
            it.next().invoke(Boolean.valueOf(z));
        }
        if (z) {
            a(j.OK);
        } else {
            a(j.Fail);
        }
    }
}
