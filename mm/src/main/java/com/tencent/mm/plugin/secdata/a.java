package com.tencent.mm.plugin.secdata;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\f¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/secdata/ActivityNameSecData;", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lcom/tencent/mm/plugin/secdata/ActivityNamesSecData;", "activityName", "", "clazz", "Ljava/lang/Class;", "type", "", "reuse", "", "(Ljava/lang/String;Ljava/lang/Class;IZ)V", "plugin-sec-data_release"})
public final class a<T extends com.tencent.mm.bw.a> extends b<T> {
    public /* synthetic */ a(String str, Class cls) {
        this(str, cls, 1, true);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(String str, Class<T> cls, int i2, boolean z) {
        super(j.listOf(str), cls, i2, z);
        p.h(str, "activityName");
        p.h(cls, "clazz");
        AppMethodBeat.i(219130);
        AppMethodBeat.o(219130);
    }
}
