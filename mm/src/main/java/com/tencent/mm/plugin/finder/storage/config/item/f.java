package com.tencent.mm.plugin.finder.storage.config.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.storage.config.d;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\bH\u0016J\r\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/config/item/RealExptConfig;", "T", "Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigItem;", "defaultValue", "expname", "Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "onConfigChanged", "Lkotlin/Function0;", "", "(Ljava/lang/Object;Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;Lkotlin/jvm/functions/Function0;)V", "getExpname", "()Lcom/tencent/mm/plugin/expt/api/IExptService$ExptEnum;", "updateValueFromSvr", "value", "()Ljava/lang/Object;", "plugin-finder_release"})
public final class f<T> extends a<T> {
    private final b.a vFN;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(T t, b.a aVar, a<x> aVar2) {
        super(t, "SVR", aVar2);
        p.h(aVar, "expname");
        p.h(aVar2, "onConfigChanged");
        AppMethodBeat.i(251940);
        this.vFN = aVar;
        dys();
        d dVar = d.vFH;
        d.a(this.vFN.name(), this);
        AppMethodBeat.o(251940);
    }

    @Override // com.tencent.mm.plugin.finder.storage.config.item.a
    public final T value() {
        AppMethodBeat.i(251938);
        if (((b) g.af(b.class)).a(b.a.clicfg_finder_config_get_expt_every_time, 0) == 1) {
            dys();
        }
        T t = this.value;
        if (t == null) {
            t = this.aEX;
        }
        AppMethodBeat.o(251938);
        return t;
    }

    @Override // com.tencent.mm.plugin.finder.storage.config.item.d, com.tencent.mm.plugin.finder.storage.config.item.a
    public final void dys() {
        T t;
        AppMethodBeat.i(251939);
        T t2 = this.aEX;
        if (t2 instanceof Integer) {
            b bVar = (b) g.af(b.class);
            b.a aVar = this.vFN;
            T t3 = this.aEX;
            if (t3 == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(251939);
                throw tVar;
            }
            t = (T) Integer.valueOf(bVar.a(aVar, t3.intValue()));
        } else if (t2 instanceof Long) {
            b bVar2 = (b) g.af(b.class);
            b.a aVar2 = this.vFN;
            T t4 = this.aEX;
            if (t4 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Long");
                AppMethodBeat.o(251939);
                throw tVar2;
            }
            t = (T) Long.valueOf(bVar2.a(aVar2, t4.longValue()));
        } else if (t2 instanceof Boolean) {
            b bVar3 = (b) g.af(b.class);
            b.a aVar3 = this.vFN;
            T t5 = this.aEX;
            if (t5 == null) {
                t tVar3 = new t("null cannot be cast to non-null type kotlin.Boolean");
                AppMethodBeat.o(251939);
                throw tVar3;
            }
            t = (T) Boolean.valueOf(bVar3.a(aVar3, t5.booleanValue()));
        } else if (t2 instanceof String) {
            b bVar4 = (b) g.af(b.class);
            b.a aVar4 = this.vFN;
            T t6 = this.aEX;
            if (t6 == null) {
                t tVar4 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(251939);
                throw tVar4;
            }
            t = (T) bVar4.a(aVar4, t6);
        } else if (t2 instanceof Float) {
            b bVar5 = (b) g.af(b.class);
            b.a aVar5 = this.vFN;
            T t7 = this.aEX;
            if (t7 == null) {
                t tVar5 = new t("null cannot be cast to non-null type kotlin.Float");
                AppMethodBeat.o(251939);
                throw tVar5;
            }
            t = (T) Float.valueOf(bVar5.a(aVar5, t7.floatValue()));
        } else {
            t = this.aEX;
        }
        this.value = t;
        Log.i("ConfigItem", "[updateValueFromSvr] keyName:" + this.vFN.name() + ", has update to " + ((Object) this.value));
        AppMethodBeat.o(251939);
    }
}
