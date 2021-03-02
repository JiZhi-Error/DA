package com.tencent.mm.plugin.textstatus.f.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/square/SquareItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "name", "", "desc", "topicId", "statusId", "headImgUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "getHeadImgUrl", "getName", "getStatusId", "getTopicId", "getItemId", "", "getItemType", "", "plugin-textstatus_release"})
public final class e implements a {
    public final String FYf;
    public final String FZz;
    private final String desc;
    private final String iAR;
    public final String name;

    public e(String str, String str2, String str3, String str4, String str5) {
        p.h(str, "name");
        p.h(str2, "desc");
        p.h(str3, "topicId");
        p.h(str4, "statusId");
        p.h(str5, "headImgUrl");
        AppMethodBeat.i(216245);
        this.name = str;
        this.desc = str2;
        this.FZz = str3;
        this.FYf = str4;
        this.iAR = str5;
        AppMethodBeat.o(216245);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(216244);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(216244);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 0;
    }
}
