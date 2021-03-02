package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanGoodsDialogView;", "Lcom/tencent/mm/plugin/scanner/box/BaseBoxDialogView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getCloseButton", "Landroid/view/View;", "root", "getCloseLayoutHeight", "getLayoutId", "Companion", "plugin-scan_release"})
public final class ScanGoodsDialogView extends BaseBoxDialogView {
    public static final a CDs = new a((byte) 0);

    static {
        AppMethodBeat.i(240321);
        AppMethodBeat.o(240321);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/scanner/box/ScanGoodsDialogView$Companion;", "", "()V", "TAG", "", "plugin-scan_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanGoodsDialogView(Context context) {
        this(context, null);
        p.h(context, "context");
        AppMethodBeat.i(240318);
        AppMethodBeat.o(240318);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanGoodsDialogView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(240319);
        AppMethodBeat.o(240319);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanGoodsDialogView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(240320);
        AppMethodBeat.o(240320);
    }

    @Override // com.tencent.mm.plugin.scanner.box.BaseBoxDialogView
    public final int getLayoutId() {
        return R.layout.az1;
    }

    @Override // com.tencent.mm.plugin.scanner.box.BaseBoxDialogView
    public final View eQ(View view) {
        AppMethodBeat.i(240316);
        p.h(view, "root");
        View findViewById = view.findViewById(R.id.b4g);
        p.g(findViewById, "root.findViewById(R.id.close_img)");
        AppMethodBeat.o(240316);
        return findViewById;
    }

    @Override // com.tencent.mm.plugin.scanner.box.BaseBoxDialogView
    public final int getCloseLayoutHeight() {
        AppMethodBeat.i(240317);
        Context context = getContext();
        p.g(context, "context");
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.aht);
        AppMethodBeat.o(240317);
        return dimensionPixelSize;
    }
}
