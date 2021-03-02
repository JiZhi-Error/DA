package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.model.HandOff;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\r\u0010\u000b\u001a\u00028\u0000H$¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001b\u0010\u0006\u001a\u00028\u00008DX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/handoff/parser/HandOffParser;", "T", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/plugin/handoff/parser/BaseXmlContent;", "Lcom/tencent/mm/plugin/handoff/parser/IHandOffParser;", "()V", "handOff", "getHandOff", "()Lcom/tencent/mm/plugin/handoff/model/HandOff;", "handOff$delegate", "Lkotlin/Lazy;", "newHandOff", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseHandOff", "api-handoff_release"})
public abstract class f<T extends HandOff> extends a implements i {
    private final kotlin.f yhM = g.ah(new a(this));

    /* access modifiers changed from: protected */
    public abstract T dYn();

    /* access modifiers changed from: protected */
    public final T dYo() {
        return (T) ((HandOff) this.yhM.getValue());
    }

    @Override // com.tencent.mm.plugin.handoff.b.a
    public final void c(XmlPullParser xmlPullParser) {
        p.h(xmlPullParser, "parser");
        String d2 = d(xmlPullParser, "id");
        long f2 = f(xmlPullParser, "createtime");
        dYo().setId(d2);
        dYo().setCreateTime(f2);
        super.c(xmlPullParser);
    }

    @Override // com.tencent.mm.plugin.handoff.b.i
    public final HandOff f(XmlPullParser xmlPullParser) {
        p.h(xmlPullParser, "parser");
        c(xmlPullParser);
        return dYo();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001 \u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "T", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "invoke", "()Lcom/tencent/mm/plugin/handoff/model/HandOff;"})
    static final class a extends q implements kotlin.g.a.a<T> {
        final /* synthetic */ f yhN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(f fVar) {
            super(0);
            this.yhN = fVar;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(238084);
            HandOff dYn = this.yhN.dYn();
            AppMethodBeat.o(238084);
            return dYn;
        }
    }
}
