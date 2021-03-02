package com.tencent.mm.plugin.scanner.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0014J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tH\u0014R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabView;", "Lcom/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "tabPaddingVertical", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "", "onAddTab", "tab", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "onTabSelected", FirebaseAnalytics.b.INDEX, "onTabUnselected", "Companion", "plugin-scan_release"})
public final class ScanScrollTabView extends BaseScrollTabView {
    public static final a CSz = new a((byte) 0);
    private int CSy;

    static {
        AppMethodBeat.i(52448);
        AppMethodBeat.o(52448);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanScrollTabView$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanScrollTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(52446);
        AppMethodBeat.o(52446);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanScrollTabView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(52447);
        this.CSy = context.getResources().getDimensionPixelSize(R.dimen.hs);
        AppMethodBeat.o(52447);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.scanner.ui.widget.BaseScrollTabView
    public final void a(a aVar) {
        AppMethodBeat.i(52443);
        p.h(aVar, "tab");
        if (aVar instanceof View) {
            ((View) aVar).setPadding(this.CSy, 0, this.CSy, 0);
        }
        AppMethodBeat.o(52443);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.scanner.ui.widget.BaseScrollTabView
    public final void a(a aVar, int i2) {
        AppMethodBeat.i(52444);
        p.h(aVar, "tab");
        super.a(aVar, i2);
        AppMethodBeat.o(52444);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.scanner.ui.widget.BaseScrollTabView
    public final void b(a aVar, int i2) {
        AppMethodBeat.i(52445);
        p.h(aVar, "tab");
        super.b(aVar, i2);
        AppMethodBeat.o(52445);
    }
}
