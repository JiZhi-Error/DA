package com.tencent.mm.plugin.profile.ui.tab.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.qf;
import com.tencent.mm.storage.as;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J \u0010\u0014\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004J\u0018\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/profile/ui/tab/data/BizProfileOptReporter;", "", "()V", "OPT_CLICK", "", "OPT_EXPOSE", "PROFILE_TAB_OPTION", "PROFILE_TOPIC_OPTION", "TAB_MSG", "TAB_NONE", "TAB_SERVICE", "TAB_VIDEO", "TOPIC_EXPAND_CLICK", "TOPIC_LABEL_CLICK", "reportTabClick", "", "contact", "Lcom/tencent/mm/storage/Contact;", "tabType", "addContactScene", "reportTabExposed", "reportTopicClick", "topic", "Lcom/tencent/mm/protocal/protobuf/BizTopic;", "reportTopicExpand", "app_release"})
public final class b {
    public static final b BmM = new b();

    static {
        AppMethodBeat.i(230720);
        AppMethodBeat.o(230720);
    }

    private b() {
    }

    public static void a(as asVar, int i2, int i3) {
        int i4;
        String str;
        AppMethodBeat.i(230716);
        if (asVar == null || !asVar.arv() || asVar.arH() <= 0) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        if (asVar == null || (str = asVar.getUsername()) == null) {
            str = "";
        }
        h.INSTANCE.a(21647, str, 1, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(230716);
    }

    public static void b(as asVar, int i2, int i3) {
        int i4;
        String str;
        AppMethodBeat.i(230717);
        if (asVar == null || !asVar.arv() || asVar.arH() <= 0) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        if (asVar == null || (str = asVar.getUsername()) == null) {
            str = "";
        }
        h.INSTANCE.a(21647, str, 2, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(230717);
    }

    public static void a(as asVar, qf qfVar) {
        String str;
        AppMethodBeat.i(230718);
        p.h(qfVar, "topic");
        if (asVar == null || (str = asVar.getUsername()) == null) {
            str = "";
        }
        h.INSTANCE.a(21648, str, 1, qfVar.KXd, Long.valueOf(qfVar.KXg));
        AppMethodBeat.o(230718);
    }

    public static void ac(as asVar) {
        String str;
        AppMethodBeat.i(230719);
        if (asVar == null || (str = asVar.getUsername()) == null) {
            str = "";
        }
        h.INSTANCE.a(21648, str, 2);
        AppMethodBeat.o(230719);
    }
}
