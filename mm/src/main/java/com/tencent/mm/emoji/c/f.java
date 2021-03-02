package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ap;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/emoji/report/EmojiResReport;", "", "()V", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/EmojiResReportStruct;", "getStruct", "()Lcom/tencent/mm/autogen/mmdata/rpt/EmojiResReportStruct;", "setStruct", "(Lcom/tencent/mm/autogen/mmdata/rpt/EmojiResReportStruct;)V", "load", "", "success", "", "setVersion", "oldVersion", "", "newVersion", "unzip", "plugin-emojisdk_release"})
public final class f {
    public ap hcm = new ap();

    public f() {
        AppMethodBeat.i(200002);
        AppMethodBeat.o(200002);
    }

    public final void ee(boolean z) {
        AppMethodBeat.i(199999);
        this.hcm.jR(1);
        if (z) {
            this.hcm.cV(1);
            this.hcm.cW(0);
            AppMethodBeat.o(199999);
            return;
        }
        this.hcm.cV(2);
        this.hcm.cW(1);
        AppMethodBeat.o(199999);
    }

    public final void ef(boolean z) {
        AppMethodBeat.i(200000);
        this.hcm.jR(2);
        if (z) {
            this.hcm.cV(1);
            this.hcm.cW(0);
            AppMethodBeat.o(200000);
            return;
        }
        this.hcm.cV(2);
        this.hcm.cW(1);
        AppMethodBeat.o(200000);
    }

    public final void cK(int i2, int i3) {
        AppMethodBeat.i(200001);
        this.hcm.jP(i2);
        this.hcm.jQ(i3);
        AppMethodBeat.o(200001);
    }
}
