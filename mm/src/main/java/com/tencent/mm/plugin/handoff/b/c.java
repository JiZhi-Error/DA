package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/handoff/parser/HandOffListParser;", "Lcom/tencent/mm/plugin/handoff/parser/BaseXmlContent;", "()V", "handOffList", "Lcom/tencent/mm/plugin/handoff/model/HandOffList;", "getHandOffList", "()Lcom/tencent/mm/plugin/handoff/model/HandOffList;", "items", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "getItems", "()Ljava/util/List;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "api-handoff_release"})
public final class c extends a {
    private final List<HandOff> iHf = new ArrayList();
    public final b yhL = new b(0, null, 0, 7);

    public c() {
        AppMethodBeat.i(238079);
        AppMethodBeat.o(238079);
    }

    @Override // com.tencent.mm.plugin.handoff.b.a
    public final void c(XmlPullParser xmlPullParser) {
        AppMethodBeat.i(238077);
        p.h(xmlPullParser, "parser");
        this.yhL.dJY = e(xmlPullParser, "opcode");
        this.yhL.seq = f(xmlPullParser, "seq");
        super.c(xmlPullParser);
        b bVar = this.yhL;
        List<HandOff> list = this.iHf;
        p.h(list, "<set-?>");
        bVar.yhH = list;
        AppMethodBeat.o(238077);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.handoff.b.a
    public final void a(String str, XmlPullParser xmlPullParser) {
        HandOff f2;
        AppMethodBeat.i(238078);
        p.h(str, "tag");
        p.h(xmlPullParser, "parser");
        switch (str.hashCode()) {
            case 692806304:
                if (str.equals("handoff")) {
                    int e2 = e(xmlPullParser, "type");
                    g gVar = g.yhO;
                    i OJ = g.OJ(e2);
                    if (!(OJ == null || (f2 = OJ.f(xmlPullParser)) == null)) {
                        this.iHf.add(f2);
                        AppMethodBeat.o(238078);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(238078);
    }
}
