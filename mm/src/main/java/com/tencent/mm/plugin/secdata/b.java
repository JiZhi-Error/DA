package com.tencent.mm.plugin.secdata;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B3\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0012\u0010\u0017\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\r\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00028\u00008FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/secdata/ActivityNamesSecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/secdata/ISecData;", "activityNameList", "", "", "clazz", "Ljava/lang/Class;", "type", "", "reuse", "", "(Ljava/util/List;Ljava/lang/Class;IZ)V", "getActivityNameList", "()Ljava/util/List;", "getClazz", "()Ljava/lang/Class;", "data", "getData", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;", "data$delegate", "Lkotlin/Lazy;", "check", "intent", "Landroid/content/Intent;", "getTransformData", "getType", "plugin-sec-data_release"})
public class b<T extends com.tencent.mm.bw.a> implements h<T> {
    private final f CVQ;
    private final List<String> CVR;
    private final boolean CVS;
    final Class<T> aWC;
    private final int type;

    public /* synthetic */ b(List list, Class cls) {
        this(list, cls, 5, true);
    }

    public b(List<String> list, Class<T> cls, int i2, boolean z) {
        p.h(list, "activityNameList");
        p.h(cls, "clazz");
        AppMethodBeat.i(219134);
        this.CVR = list;
        this.aWC = cls;
        this.type = i2;
        this.CVS = z;
        this.CVQ = g.ah(new a(this));
        AppMethodBeat.o(219134);
    }

    @Override // com.tencent.mm.plugin.secdata.h
    public final boolean aS(Intent intent) {
        String str;
        String className;
        List<String> a2;
        AppMethodBeat.i(219132);
        if (intent != null) {
            ComponentName component = intent.getComponent();
            if (component == null || (className = component.getClassName()) == null || (a2 = n.a(className, new String[]{"."})) == null || (str = (String) j.kv(a2)) == null) {
                str = "";
            }
            boolean contains = this.CVR.contains(str);
            AppMethodBeat.o(219132);
            return contains;
        }
        AppMethodBeat.o(219132);
        return false;
    }

    @Override // com.tencent.mm.plugin.secdata.h
    public final int getType() {
        return this.type;
    }

    @Override // com.tencent.mm.plugin.secdata.h
    public final boolean eSm() {
        return this.CVS;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke", "()Lcom/tencent/mm/protobuf/BaseProtoBuf;"})
    static final class a extends q implements kotlin.g.a.a<T> {
        final /* synthetic */ b CVT;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar) {
            super(0);
            this.CVT = bVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(219131);
            T newInstance = this.CVT.aWC.newInstance();
            AppMethodBeat.o(219131);
            return newInstance;
        }
    }

    @Override // com.tencent.mm.plugin.secdata.h
    public final T eSl() {
        AppMethodBeat.i(219133);
        T t = (T) ((com.tencent.mm.bw.a) this.CVQ.getValue());
        p.g(t, "data");
        AppMethodBeat.o(219133);
        return t;
    }
}
