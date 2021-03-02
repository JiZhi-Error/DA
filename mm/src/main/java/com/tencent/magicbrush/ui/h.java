package com.tencent.magicbrush.ui;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import android.view.View;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J&\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\bH\u0016JC\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00192!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b$\u0012\b\b%\u0012\u0004\b\b(&\u0012\u0004\u0012\u00020'0#2\u0006\u0010(\u001a\u00020)H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006*"}, hxF = {"Lcom/tencent/magicbrush/ui/MBTextureView;", "Landroid/view/TextureView;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "Landroid/view/TextureView$SurfaceTextureListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "canCaptureFromjava", "", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "setSurfaceListener", "l", "switchToRecordableMode", "foceRecreate", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "lib-magicbrush-nano_release"})
public class h extends TextureView implements TextureView.SurfaceTextureListener, MagicBrushView.b {
    private final View cON = this;
    private final MagicBrushView.h cOO;
    private MagicBrushView.c cOP;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(140235);
        super.setSurfaceTextureListener(this);
        this.cOO = MagicBrushView.h.TextureView;
        AppMethodBeat.o(140235);
    }

    @Override // com.tencent.magicbrush.ui.MagicBrushView.b
    public Object getSurface() {
        AppMethodBeat.i(182581);
        Object a2 = MagicBrushView.b.a.a(this);
        AppMethodBeat.o(182581);
        return a2;
    }

    @Override // com.tencent.magicbrush.ui.MagicBrushView.b
    public View getThisView() {
        return this.cON;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(140230);
        p.h(surfaceTexture, "surface");
        p.h(surfaceTexture, "surface");
        MagicBrushView.c cVar = this.cOP;
        if (cVar != null) {
            cVar.a(surfaceTexture, i2, i3, true);
            AppMethodBeat.o(140230);
            return;
        }
        AppMethodBeat.o(140230);
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        AppMethodBeat.i(140231);
        p.h(surfaceTexture, "surface");
        MagicBrushView.c cVar = this.cOP;
        if (cVar != null) {
            cVar.c(surfaceTexture, i2, i3);
            AppMethodBeat.o(140231);
            return;
        }
        AppMethodBeat.o(140231);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(140232);
        p.h(surfaceTexture, "surface");
        MagicBrushView.c cVar = this.cOP;
        if (cVar != null) {
            cVar.a(surfaceTexture, false);
        }
        AppMethodBeat.o(140232);
        return false;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(140233);
        p.h(surfaceTexture, "surface");
        AppMethodBeat.o(140233);
    }

    @Override // com.tencent.magicbrush.ui.MagicBrushView.b
    public MagicBrushView.h getViewType() {
        return this.cOO;
    }

    @Override // com.tencent.magicbrush.ui.MagicBrushView.b
    public void setSurfaceListener(MagicBrushView.c cVar) {
        this.cOP = cVar;
    }

    @Override // com.tencent.magicbrush.ui.MagicBrushView.b
    public final void a(boolean z, boolean z2, b<? super Boolean, Void> bVar, MBRuntime mBRuntime) {
        AppMethodBeat.i(206874);
        p.h(bVar, "callback");
        p.h(mBRuntime, "runtime");
        bVar.invoke(Boolean.TRUE);
        AppMethodBeat.o(206874);
    }
}
