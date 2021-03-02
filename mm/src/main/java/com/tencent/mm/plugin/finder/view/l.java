package com.tencent.mm.plugin.finder.view;

import android.text.TextPaint;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.ui.ao;
import kotlin.g.a.b;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\u0010\u0010\n\u001a\u00020\f2\u0006\u0010\"\u001a\u00020#H\u0016J\u0018\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0016J\u0010\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020)H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000f\"\u0004\b\u0019\u0010\u0011R&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018¨\u0006*"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/FinderTextClickSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "text", "", "textColor", "", "clickBgColor", "bold", "", "isTopic", "onClick", "Lkotlin/Function1;", "", "(Ljava/lang/String;IIZZLkotlin/jvm/functions/Function1;)V", "getBold", "()Z", "setBold", "(Z)V", "canClick", "getCanClick", "setCanClick", "getClickBgColor", "()I", "setClickBgColor", "(I)V", "setTopic", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "getText", "()Ljava/lang/String;", "getTextColor", "setTextColor", "widget", "Landroid/view/View;", "setColor", "linkColor", "backgroundColor", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
public final class l extends p {
    public boolean sYU;
    private int sYV;
    private boolean sYW;
    private final String text;
    private int textColor;
    private b<? super String, x> uzi;
    boolean wpF;

    public /* synthetic */ l(String str, int i2, int i3, b bVar) {
        this(str, i2, i3, false, false, bVar);
        AppMethodBeat.i(168420);
        AppMethodBeat.o(168420);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(String str, int i2, int i3, boolean z, boolean z2, b<? super String, x> bVar) {
        super(i2, i3);
        kotlin.g.b.p.h(str, "text");
        kotlin.g.b.p.h(bVar, "onClick");
        AppMethodBeat.i(254995);
        this.text = str;
        this.textColor = i2;
        this.sYV = i3;
        this.sYW = z;
        this.wpF = z2;
        this.uzi = bVar;
        this.sYU = true;
        AppMethodBeat.o(254995);
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public final void onClick(View view) {
        AppMethodBeat.i(168418);
        kotlin.g.b.p.h(view, "widget");
        if (this.sYU) {
            this.uzi.invoke(this.text);
        }
        AppMethodBeat.o(168418);
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public final void setColor(int i2, int i3) {
        AppMethodBeat.i(168419);
        super.setColor(i2, i3);
        this.textColor = i2;
        this.sYV = i3;
        AppMethodBeat.o(168419);
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.p
    public final void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(254994);
        kotlin.g.b.p.h(textPaint, "ds");
        super.updateDrawState(textPaint);
        if (this.sYW) {
            ao.a(textPaint, 0.8f);
        }
        AppMethodBeat.o(254994);
    }
}
