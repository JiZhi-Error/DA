package com.tencent.mm.plugin.finder.storage.config.item;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.f;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.storage.config.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\bH\u0016J\r\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/config/item/RealDynaConfig;", "T", "Lcom/tencent/mm/plugin/finder/storage/config/item/ConfigItem;", "defaultValue", "expname", "", "onConfigChanged", "Lkotlin/Function0;", "", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "getExpname", "()Ljava/lang/String;", "updateValueFromSvr", "value", "()Ljava/lang/Object;", "plugin-finder_release"})
public final class e<T> extends a<T> {
    private final String vFM;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(T t, String str, a<x> aVar) {
        super(t, "SVR", aVar);
        p.h(str, "expname");
        p.h(aVar, "onConfigChanged");
        AppMethodBeat.i(251937);
        this.vFM = str;
        dys();
        d dVar = d.vFH;
        d.a(this.vFM, this);
        AppMethodBeat.o(251937);
    }

    @Override // com.tencent.mm.plugin.finder.storage.config.item.a
    public final T value() {
        AppMethodBeat.i(251935);
        if (((b) g.af(b.class)).a(b.a.clicfg_finder_config_get_expt_every_time, 0) == 1) {
            dys();
        }
        T t = this.value;
        if (t == null) {
            t = this.aEX;
        }
        AppMethodBeat.o(251935);
        return t;
    }

    @Override // com.tencent.mm.plugin.finder.storage.config.item.d, com.tencent.mm.plugin.finder.storage.config.item.a
    public final void dys() {
        T t;
        AppMethodBeat.i(251936);
        T t2 = this.aEX;
        if (t2 instanceof Integer) {
            com.tencent.mm.kernel.c.a af = g.af(com.tencent.mm.plugin.zero.b.a.class);
            p.g(af, "MMKernel.service<IConfig…onfigService::class.java)");
            f aqJ = ((com.tencent.mm.plugin.zero.b.a) af).aqJ();
            String str = this.vFM;
            T t3 = this.aEX;
            if (t3 == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(251936);
                throw tVar;
            }
            t = (T) Integer.valueOf(aqJ.getInt(str, t3.intValue()));
        } else if (t2 instanceof Long) {
            com.tencent.mm.kernel.c.a af2 = g.af(com.tencent.mm.plugin.zero.b.a.class);
            p.g(af2, "MMKernel.service<IConfig…onfigService::class.java)");
            f aqJ2 = ((com.tencent.mm.plugin.zero.b.a) af2).aqJ();
            String str2 = this.vFM;
            T t4 = this.aEX;
            if (t4 == null) {
                t tVar2 = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(251936);
                throw tVar2;
            }
            t = (T) ((Long) Integer.valueOf(aqJ2.getInt(str2, t4.intValue())));
        } else if (t2 instanceof String) {
            com.tencent.mm.kernel.c.a af3 = g.af(com.tencent.mm.plugin.zero.b.a.class);
            p.g(af3, "MMKernel.service<IConfig…onfigService::class.java)");
            String value = ((com.tencent.mm.plugin.zero.b.a) af3).aqJ().getValue(this.vFM);
            T t5 = this.aEX;
            if (t5 == null) {
                t tVar3 = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(251936);
                throw tVar3;
            }
            t = (T) Util.nullAs(value, t5);
        } else {
            t = this.aEX;
        }
        this.value = t;
        Log.i("ConfigItem", "[updateValueFromSvr] keyName:" + this.vFM + ", has update to " + ((Object) this.value));
        AppMethodBeat.o(251936);
    }
}
