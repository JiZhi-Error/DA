package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fH\u0016¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanImageOCRDialogView;", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getCloseButton", "Landroid/view/View;", "root", "getCloseLayoutHeight", "getLayoutId", "onCreateView", "", "view", "Companion", "plugin-scan_release"})
public final class ScanImageOCRDialogView extends BaseBoxDialogView {
    public static final a CDt = new a((byte) 0);

    static {
        AppMethodBeat.i(240328);
        AppMethodBeat.o(240328);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanImageOCRDialogView$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanImageOCRDialogView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(240325);
        AppMethodBeat.o(240325);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanImageOCRDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(240326);
        AppMethodBeat.o(240326);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanImageOCRDialogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(240327);
        AppMethodBeat.o(240327);
    }

    @Override // com.tencent.mm.plugin.scanner.box.BaseBoxDialogView
    public final void eP(View view) {
        AppMethodBeat.i(240322);
        p.h(view, "view");
        super.eP(view);
        TextView textView = (TextView) view.findViewById(R.id.br5);
        p.g(textView, "dialogTitle");
        ao.a(textView.getPaint(), 0.8f);
        AppMethodBeat.o(240322);
    }

    @Override // com.tencent.mm.plugin.scanner.box.BaseBoxDialogView
    public final int getLayoutId() {
        return R.layout.az3;
    }

    @Override // com.tencent.mm.plugin.scanner.box.BaseBoxDialogView
    public final View eQ(View view) {
        AppMethodBeat.i(240323);
        p.h(view, "root");
        View findViewById = view.findViewById(R.id.b4g);
        p.g(findViewById, "root.findViewById(R.id.close_img)");
        AppMethodBeat.o(240323);
        return findViewById;
    }

    @Override // com.tencent.mm.plugin.scanner.box.BaseBoxDialogView
    public final int getCloseLayoutHeight() {
        AppMethodBeat.i(240324);
        Context context = getContext();
        p.g(context, "context");
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.aht);
        AppMethodBeat.o(240324);
        return dimensionPixelSize;
    }
}
