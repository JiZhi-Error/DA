package com.tencent.mm.plugin.secdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.HashMap;
import java.util.Map;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0017\u0010\u0012\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0013\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u0014J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\u0018\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u001d\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bR'\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00028\u00000\b8FX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/secdata/DefaultListSecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/secdata/IListSecData;", "type", "", "(I)V", "itemObjMap", "Ljava/util/HashMap;", "", "getItemObjMap", "()Ljava/util/HashMap;", "itemObjMap$delegate", "Lkotlin/Lazy;", "copyItemObj", "", "fromKey", "toKey", "getItemObj", "key", "(Ljava/lang/String;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getListItemObjMap", "", "getType", "moveItemObj", "putItemObj", "value", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "plugin-sec-data_release"})
public final class d<T extends com.tencent.mm.bw.a> implements f<T> {
    private final f CVW = g.ah(a.CVX);
    private final int type = 1;

    private HashMap<String, T> eSn() {
        AppMethodBeat.i(219140);
        HashMap<String, T> hashMap = (HashMap) this.CVW.getValue();
        AppMethodBeat.o(219140);
        return hashMap;
    }

    public d() {
        AppMethodBeat.i(219144);
        AppMethodBeat.o(219144);
    }

    @Override // com.tencent.mm.plugin.secdata.f
    public final int getType() {
        return this.type;
    }

    @Override // com.tencent.mm.plugin.secdata.f
    public final Map<String, T> eSo() {
        AppMethodBeat.i(219141);
        HashMap<String, T> eSn = eSn();
        AppMethodBeat.o(219141);
        return eSn;
    }

    @Override // com.tencent.mm.plugin.secdata.f
    public final void c(String str, T t) {
        AppMethodBeat.i(219142);
        p.h(str, "key");
        p.h(t, "value");
        eSn().put(str, t);
        AppMethodBeat.o(219142);
    }

    @Override // com.tencent.mm.plugin.secdata.f
    public final void jS(String str, String str2) {
        AppMethodBeat.i(219143);
        p.h(str, "fromKey");
        p.h(str2, "toKey");
        T t = eSn().get(str);
        if (t != null) {
            p.g(t, LocaleUtil.ITALIAN);
            eSn().put(str2, t);
            AppMethodBeat.o(219143);
            return;
        }
        AppMethodBeat.o(219143);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Ljava/util/HashMap;", "", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<HashMap<String, T>> {
        public static final a CVX = new a();

        static {
            AppMethodBeat.i(219139);
            AppMethodBeat.o(219139);
        }

        a() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(219138);
            HashMap hashMap = new HashMap();
            AppMethodBeat.o(219138);
            return hashMap;
        }
    }
}
