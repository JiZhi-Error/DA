package com.tencent.mm.plugin.expt.hellhound.core.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/core/v2/view/ViewEventId;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "toString", "", "INVALIDATE", "TOUCH", "SINGLE_CLICK", "LONG_CLICK", "DOUBLE_CLICK", "ITEM_CLICK", "ITEM_LONG_CLICK", "ITEM_SELECTED", "DRAG", "KEY", "HOVER", "GLIDE", "plugin-expt_release"})
public enum d {
    INVALIDATE(-1),
    TOUCH(0),
    SINGLE_CLICK(1),
    LONG_CLICK(2),
    DOUBLE_CLICK(3),
    ITEM_CLICK(4),
    ITEM_LONG_CLICK(5),
    ITEM_SELECTED(6),
    DRAG(7),
    KEY(8),
    HOVER(9),
    GLIDE(10);
    
    public final int value;

    public static d valueOf(String str) {
        AppMethodBeat.i(220762);
        d dVar = (d) Enum.valueOf(d.class, str);
        AppMethodBeat.o(220762);
        return dVar;
    }

    private d(int i2) {
        this.value = i2;
    }

    static {
        AppMethodBeat.i(220759);
        AppMethodBeat.o(220759);
    }

    public final String toString() {
        AppMethodBeat.i(220760);
        String str = name() + '=' + this.value;
        AppMethodBeat.o(220760);
        return str;
    }
}
