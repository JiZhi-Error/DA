package com.tencent.mm.plugin.secdata;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0012\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\r\u0010\u0015\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\b\u0010\u0016\u001a\u00020\u0007H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00028\u00008FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/secdata/AllActivitySecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/secdata/ISecData;", "clazz", "Ljava/lang/Class;", "type", "", "reuse", "", "(Ljava/lang/Class;IZ)V", "getClazz", "()Ljava/lang/Class;", "data", "getData", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "data$delegate", "Lkotlin/Lazy;", "check", "intent", "Landroid/content/Intent;", "getTransformData", "getType", "plugin-sec-data_release"})
public final class c<T extends com.tencent.mm.bw.a> implements h<T> {
    private final f CVQ;
    private final boolean CVS;
    final Class<T> aWC;
    private final int type;

    public c(Class<T> cls, int i2) {
        p.h(cls, "clazz");
        AppMethodBeat.i(263554);
        this.aWC = cls;
        this.type = i2;
        this.CVS = true;
        this.CVQ = g.ah(new a(this));
        AppMethodBeat.o(263554);
    }

    public /* synthetic */ c(Class cls, int i2, byte b2) {
        this(cls, i2);
    }

    @Override // com.tencent.mm.plugin.secdata.h
    public final boolean eSm() {
        return true;
    }

    @Override // com.tencent.mm.plugin.secdata.h
    public final boolean aS(Intent intent) {
        return true;
    }

    @Override // com.tencent.mm.plugin.secdata.h
    public final int getType() {
        return this.type;
    }

    @Override // com.tencent.mm.plugin.secdata.h
    public final T eSl() {
        AppMethodBeat.i(219136);
        T t = (T) ((com.tencent.mm.bw.a) this.CVQ.getValue());
        p.g(t, "data");
        AppMethodBeat.o(219136);
        return t;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;"})
    static final class a extends q implements kotlin.g.a.a<T> {
        final /* synthetic */ c CVU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(c cVar) {
            super(0);
            this.CVU = cVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(219135);
            T newInstance = this.CVU.aWC.newInstance();
            AppMethodBeat.o(219135);
            return newInstance;
        }
    }
}
