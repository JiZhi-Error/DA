package com.tencent.mm.emoji.b.b;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0016J\u0013\u0010\n\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/emoji/model/panel/PanelItem;", "", "type", "", "(I)V", "getType", "()I", "contentEquals", "", FacebookRequestErrorClassification.KEY_OTHER, "equals", "plugin-emojisdk_release"})
public class ac {
    public final int type;

    public ac(int i2) {
        this.type = i2;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ac) && ((ac) obj).type == this.type;
    }

    public boolean aZ(Object obj) {
        AppMethodBeat.i(105573);
        boolean equals = equals(obj);
        AppMethodBeat.o(105573);
        return equals;
    }
}
