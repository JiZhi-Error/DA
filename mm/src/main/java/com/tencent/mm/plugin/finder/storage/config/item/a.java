package com.tencent.mm.plugin.finder.storage.config.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0016\u0018\u0000 \u0017*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0017B'\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\bH\u0016J\r\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bR\u0016\u0010\u0003\u001a\u00028\u0000X\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigItem;", "T", "Lcom/tencent/mm/plugin/finder/storage/config/item/IConfigItem;", "defaultValue", "name", "", "onConfigChanged", "Lkotlin/Function0;", "", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getDefaultValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getName", "()Ljava/lang/String;", "value", "getValue", "setValue", "(Ljava/lang/Object;)V", "getItemName", "notifyValueChanged", "toString", "updateValueFromSvr", "Companion", "plugin-finder_release"})
public class a<T> implements d {
    public static final C1284a vFK = new C1284a((byte) 0);
    final T aEX;
    public final String name;
    private kotlin.g.a.a<x> vFJ;
    T value;

    static {
        AppMethodBeat.i(251931);
        AppMethodBeat.o(251931);
    }

    public /* synthetic */ a(Object obj, String str) {
        this(obj, str, null);
    }

    public a(T t, String str, kotlin.g.a.a<x> aVar) {
        p.h(str, "name");
        AppMethodBeat.i(251930);
        this.aEX = t;
        this.name = str;
        this.vFJ = aVar;
        AppMethodBeat.o(251930);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigItem$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.storage.config.item.a$a  reason: collision with other inner class name */
    public static final class C1284a {
        private C1284a() {
        }

        public /* synthetic */ C1284a(byte b2) {
            this();
        }
    }

    public String toString() {
        AppMethodBeat.i(251928);
        String str = "name " + this.name + " value " + ((Object) this.value) + " dummyValue " + ((Object) this.aEX);
        AppMethodBeat.o(251928);
        return str;
    }

    public T value() {
        T t = this.value;
        return t == null ? this.aEX : t;
    }

    @Override // com.tencent.mm.plugin.finder.storage.config.item.d
    public void dys() {
    }

    @Override // com.tencent.mm.plugin.finder.storage.config.item.d
    public final void dyt() {
        AppMethodBeat.i(251929);
        kotlin.g.a.a<x> aVar = this.vFJ;
        if (aVar != null) {
            aVar.invoke();
            AppMethodBeat.o(251929);
            return;
        }
        AppMethodBeat.o(251929);
    }
}
