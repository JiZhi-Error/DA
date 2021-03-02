package com.tencent.mm.plugin.multitask.ui.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB!\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskSnapViewWrapper;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mm/plugin/multitask/ui/base/IMultiTaskView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "snapView", "Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskSnapView;", "getSnapView", "()Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskSnapView;", "setSnapView", "(Lcom/tencent/mm/plugin/multitask/ui/base/MultiTaskSnapView;)V", "getView", "Landroid/view/View;", "initUI", "", "setBitmap", "bitmap", "Landroid/graphics/Bitmap;", "plugin-multitask_release"})
public class MultiTaskSnapViewWrapper extends FrameLayout implements a {
    private MultiTaskSnapView Ado;

    public final MultiTaskSnapView getSnapView() {
        return this.Ado;
    }

    public final void setSnapView(MultiTaskSnapView multiTaskSnapView) {
        this.Ado = multiTaskSnapView;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTaskSnapViewWrapper(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(200757);
        initUI();
        AppMethodBeat.o(200757);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTaskSnapViewWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(200758);
        initUI();
        AppMethodBeat.o(200758);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiTaskSnapViewWrapper(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(200759);
        initUI();
        AppMethodBeat.o(200759);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.base.a
    public void setBitmap(Bitmap bitmap) {
        AppMethodBeat.i(200755);
        p.h(bitmap, "bitmap");
        Matrix matrix = new Matrix();
        matrix.setScale(1.0f, 1.0f);
        MultiTaskSnapView multiTaskSnapView = this.Ado;
        if (multiTaskSnapView != null) {
            multiTaskSnapView.setImageMatrix(matrix);
        }
        MultiTaskSnapView multiTaskSnapView2 = this.Ado;
        if (multiTaskSnapView2 != null) {
            multiTaskSnapView2.setImageBitmap(bitmap);
            AppMethodBeat.o(200755);
            return;
        }
        AppMethodBeat.o(200755);
    }

    private final void initUI() {
        AppMethodBeat.i(200756);
        this.Ado = new MultiTaskSnapView(getContext());
        addView(this.Ado);
        MultiTaskSnapView multiTaskSnapView = this.Ado;
        if (multiTaskSnapView != null) {
            multiTaskSnapView.setScaleType(ImageView.ScaleType.MATRIX);
            AppMethodBeat.o(200756);
            return;
        }
        AppMethodBeat.o(200756);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.base.a
    public View getView() {
        return this;
    }
}
