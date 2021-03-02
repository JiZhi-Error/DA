package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/storage/EmojiDesignerProductList;", "", "()V", "TAG", "", "designerUin", "", "getDesignerUin", "()I", "setDesignerUin", "(I)V", "productList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/emotion/EmojiDesignerProduct;", "getProductList", "()Ljava/util/LinkedList;", "getNew", "", "hasNew", "", "markRead", "", "Cache", "Companion", "plugin-emojisdk_release"})
public final class bg {
    public static final b Ops = new b((byte) 0);
    public final LinkedList<com.tencent.mm.storage.emotion.a> LGy = new LinkedList<>();
    private final String TAG = "MicroMsg.EmojiDesignerProductList";
    public int gWW;

    static {
        AppMethodBeat.i(183993);
        AppMethodBeat.o(183993);
    }

    public bg() {
        AppMethodBeat.i(183992);
        AppMethodBeat.o(183992);
    }

    public final boolean gCH() {
        boolean z;
        AppMethodBeat.i(183990);
        Log.i(this.TAG, "hasNew: " + this.gWW + ", " + this.LGy.size());
        int nowSecond = (int) Util.nowSecond();
        LinkedList<com.tencent.mm.storage.emotion.a> linkedList = this.LGy;
        if (!(linkedList instanceof Collection) || !linkedList.isEmpty()) {
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                if (((long) ((com.tencent.mm.storage.emotion.a) it.next()).field_syncTime) > ((long) nowSecond) - 2592000) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    AppMethodBeat.o(183990);
                    return true;
                }
            }
        }
        AppMethodBeat.o(183990);
        return false;
    }

    public final void gCI() {
        AppMethodBeat.i(183991);
        if (gCH()) {
            Iterator<T> it = this.LGy.iterator();
            while (it.hasNext()) {
                ((com.tencent.mm.storage.emotion.a) it.next()).field_syncTime = 0;
            }
            bj.gCJ().gCN().a(this);
            EventCenter.instance.publish(new rj());
        }
        AppMethodBeat.o(183991);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0005J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0006R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/storage/EmojiDesignerProductList$Cache;", "", "()V", "map", "Lcom/tencent/mm/memory/cache/DefaultResource;", "", "Lcom/tencent/mm/storage/EmojiDesignerProductList;", "getMap", "()Lcom/tencent/mm/memory/cache/DefaultResource;", "get", "designerUin", "put", "", "info", "plugin-emojisdk_release"})
    public static final class a {
        private static final c<Integer, bg> Opt = new c<>(500);
        public static final a Opu = new a();

        static {
            AppMethodBeat.i(183989);
            AppMethodBeat.o(183989);
        }

        private a() {
        }

        public static bg aki(int i2) {
            AppMethodBeat.i(183987);
            bg bgVar = Opt.get(Integer.valueOf(i2));
            if (!MMApplicationContext.isMainProcess()) {
                bgVar = new bg();
                bgVar.gWW = i2;
            } else if (bgVar == null) {
                bgVar = bj.gCJ().gCN().akn(i2);
                Opt.put(Integer.valueOf(i2), bgVar);
            }
            p.g(bgVar, "info");
            AppMethodBeat.o(183987);
            return bgVar;
        }

        public static void a(int i2, bg bgVar) {
            AppMethodBeat.i(183988);
            p.h(bgVar, "info");
            Opt.put(Integer.valueOf(i2), bgVar);
            AppMethodBeat.o(183988);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/storage/EmojiDesignerProductList$Companion;", "", "()V", "NEW_VALID", "", "plugin-emojisdk_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }
}
