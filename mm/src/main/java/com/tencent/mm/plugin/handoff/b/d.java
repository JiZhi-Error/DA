package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.model.HandOffMG;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/handoff/parser/HandOffMGParser;", "Lcom/tencent/mm/plugin/handoff/parser/HandOffParser;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMG;", "()V", "newHandOff", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "api-handoff_release"})
public final class d extends f<HandOffMG> {
    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.handoff.b.a
    public final void a(String str, XmlPullParser xmlPullParser) {
        AppMethodBeat.i(238081);
        p.h(str, "tag");
        p.h(xmlPullParser, "parser");
        super.a(str, xmlPullParser);
        AppMethodBeat.o(238081);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.handoff.model.HandOff' to match base method */
    @Override // com.tencent.mm.plugin.handoff.b.f
    public final /* synthetic */ HandOffMG dYn() {
        AppMethodBeat.i(238080);
        HandOffMG handOffMG = new HandOffMG();
        AppMethodBeat.o(238080);
        return handOffMG;
    }
}
