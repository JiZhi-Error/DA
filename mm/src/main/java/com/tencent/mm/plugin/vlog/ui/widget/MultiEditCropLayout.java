package com.tencent.mm.plugin.vlog.ui.widget;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.e;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0016J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0016J\u0010\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "isFullscreenMode", "", "calculateLayout", "", "changed", "left", "top", "right", "bottom", "enableFullscreenMode", "onChangeVisibilityRect", "rectF", "Landroid/graphics/RectF;", "isHard", e.b.NAME, "e1", "Landroid/view/MotionEvent;", "Companion", "plugin-vlog_release"})
public class MultiEditCropLayout extends CropLayout {
    public static final a GQj = new a((byte) 0);
    public boolean Gna;

    static {
        AppMethodBeat.i(192177);
        AppMethodBeat.o(192177);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiEditCropLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(192175);
        AppMethodBeat.o(192175);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiEditCropLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(192176);
        AppMethodBeat.o(192176);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout$Companion;", "", "()V", "TAG", "", "plugin-vlog_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.widget.cropview.CropLayout
    public final void b(RectF rectF, boolean z) {
        AppMethodBeat.i(192172);
        p.h(rectF, "rectF");
        if (!this.Gna) {
            super.b(rectF, z);
            AppMethodBeat.o(192172);
            return;
        }
        getVisibilityRect().set(rectF);
        AppMethodBeat.o(192172);
    }

    @Override // com.tencent.mm.ui.widget.cropview.CropLayout
    public final void e(boolean z, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(192173);
        if (!this.Gna) {
            super.e(z, i2, i3, i4, i5);
            AppMethodBeat.o(192173);
            return;
        }
        View contentView = getContentView();
        if (contentView != null) {
            if (this.QMf) {
                setShouldLayout(false);
                getContentBaseRect().set(contentView.getLeft(), contentView.getTop(), contentView.getRight(), contentView.getBottom());
                contentView.setPivotX(getContentBaseRect().exactCenterX());
                contentView.setPivotY(getContentBaseRect().exactCenterY());
                getTmpRectF().set(getContentBaseRect());
                getMainMatrix().mapRect(getTmpRectF());
                getTmpRectF().round(getContentRect());
                getContentRectF().set(getTmpRectF());
                if (getInitFinish().invoke(getMainMatrix()).booleanValue()) {
                    hbh();
                    getContentRectF().round(getContentCenterRect());
                }
            }
            AppMethodBeat.o(192173);
            return;
        }
        AppMethodBeat.o(192173);
    }

    @Override // com.tencent.mm.ui.widget.cropview.CropLayout, com.tencent.mm.ui.widget.cropview.BaseCropLayout, com.tencent.mm.ui.widget.cropview.TouchEventLayout
    public final void ad(MotionEvent motionEvent) {
        AppMethodBeat.i(192174);
        p.h(motionEvent, "e1");
        if (!this.Gna) {
            super.ad(motionEvent);
            AppMethodBeat.o(192174);
            return;
        }
        CropLayout.c onChangeListener = getOnChangeListener();
        if (!(onChangeListener instanceof CropLayout.d)) {
            onChangeListener = null;
        }
        CropLayout.d dVar = (CropLayout.d) onChangeListener;
        if (dVar != null) {
            dVar.fDk();
            AppMethodBeat.o(192174);
            return;
        }
        AppMethodBeat.o(192174);
    }
}
