package com.tencent.mm.plugin.recordvideo.ui.editor.item.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\u000fX\u0004¢\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u0004\u0018\u00010\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u0000@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00038F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\f¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "", "defaultTime", "", "(J)V", "value", "", "dirty", "setDirty", "(Z)V", "offset", "getOffset", "()J", "setOffset", "refer", "Ljava/util/LinkedList;", "target", "getTarget", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;", "setTarget", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/property/TimePoint;)V", "<set-?>", "time", "getTime", "plugin-recordvideo_release"})
public final class c {
    private c Cgv;
    private final LinkedList<c> Cgw;
    private boolean dirty;
    public long offset;
    private long time;

    private c() {
        AppMethodBeat.i(237885);
        this.Cgw = new LinkedList<>();
        this.time = 0;
        this.dirty = true;
        AppMethodBeat.o(237885);
    }

    public /* synthetic */ c(byte b2) {
        this();
    }

    public final void a(c cVar) {
        LinkedList<c> linkedList;
        LinkedList<c> linkedList2;
        AppMethodBeat.i(237881);
        if (!p.j(this.Cgv, cVar)) {
            c cVar2 = this.Cgv;
            if (!(cVar2 == null || (linkedList2 = cVar2.Cgw) == null)) {
                linkedList2.remove(this);
            }
            this.Cgv = cVar;
            c cVar3 = this.Cgv;
            if (!(cVar3 == null || (linkedList = cVar3.Cgw) == null)) {
                linkedList.add(this);
            }
            tE(true);
        }
        AppMethodBeat.o(237881);
    }

    public final void Il(long j2) {
        AppMethodBeat.i(237882);
        if (this.offset != j2) {
            this.offset = j2;
            tE(true);
        }
        AppMethodBeat.o(237882);
    }

    public final long getTime() {
        AppMethodBeat.i(237883);
        if (this.dirty) {
            c cVar = this.Cgv;
            this.time = (cVar != null ? cVar.getTime() : 0) + this.offset;
            tE(false);
        }
        long j2 = this.time;
        AppMethodBeat.o(237883);
        return j2;
    }

    private final void tE(boolean z) {
        AppMethodBeat.i(237884);
        if (this.dirty != z) {
            this.dirty = z;
            if (z) {
                Iterator<T> it = this.Cgw.iterator();
                while (it.hasNext()) {
                    it.next().tE(z);
                }
            }
        }
        AppMethodBeat.o(237884);
    }
}
