package com.tencent.mm.emoji.c;

import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.aq;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/emoji/report/EmojiDesignerReport;", "", "()V", "ActionBack", "", "ActionClick", "ActionDownload", "ActionExposure", "ActionViewPackDetail", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonBoardReddotNotificationStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmoticonBoardReddotNotificationStruct;", "report", "", NativeProtocol.WEB_DIALOG_ACTION, "plugin-emojisdk_release"})
public final class d {
    private static final aq hci = new aq();
    public static final d hcj = new d();

    static {
        AppMethodBeat.i(183963);
        AppMethodBeat.o(183963);
    }

    private d() {
    }

    public static aq awd() {
        return hci;
    }

    public static void pl(int i2) {
        AppMethodBeat.i(183962);
        if (hci.getIndex() > 0) {
            hci.jS(i2);
            hci.bfK();
        }
        AppMethodBeat.o(183962);
    }
}
