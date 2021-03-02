package com.tencent.mm.plugin.secdata;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\r\u0010\u0014\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u0015\u001a\u00020\u0007H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u000b\u001a\u00028\u00008FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/secdata/DefaultSecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/secdata/ISecData;", "clazz", "Ljava/lang/Class;", "type", "", "(Ljava/lang/Class;I)V", "getClazz", "()Ljava/lang/Class;", "data", "getData", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "data$delegate", "Lkotlin/Lazy;", "check", "", "intent", "Landroid/content/Intent;", "getTransformData", "getType", "plugin-sec-data_release"})
public final class e<T extends com.tencent.mm.bw.a> implements h<T> {
    private final f CVQ = g.ah(new a(this));
    final Class<T> aWC;
    private final int type;

    public e(Class<T> cls, int i2) {
        p.h(cls, "clazz");
        AppMethodBeat.i(219147);
        this.aWC = cls;
        this.type = i2;
        AppMethodBeat.o(219147);
    }

    @Override // com.tencent.mm.plugin.secdata.h
    public final boolean eSm() {
        return true;
    }

    @Override // com.tencent.mm.plugin.secdata.h
    public final boolean aS(Intent intent) {
        return false;
    }

    @Override // com.tencent.mm.plugin.secdata.h
    public final int getType() {
        return this.type;
    }

    @Override // com.tencent.mm.plugin.secdata.h
    public final T eSl() {
        AppMethodBeat.i(219146);
        T t = (T) ((com.tencent.mm.bw.a) this.CVQ.getValue());
        p.g(t, "data");
        AppMethodBeat.o(219146);
        return t;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;"})
    static final class a extends q implements kotlin.g.a.a<T> {
        final /* synthetic */ e CVY;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e eVar) {
            super(0);
            this.CVY = eVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(219145);
            T newInstance = this.CVY.aWC.newInstance();
            AppMethodBeat.o(219145);
            return newInstance;
        }
    }
}
