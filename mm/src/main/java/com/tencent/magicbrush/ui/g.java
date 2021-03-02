package com.tencent.magicbrush.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0016J(\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016JC\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020\u00182!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*0&2\u0006\u0010+\u001a\u00020,H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006-"}, hxF = {"Lcom/tencent/magicbrush/ui/MBSurfaceView;", "Landroid/view/SurfaceView;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "Landroid/view/SurfaceHolder$Callback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getSurfaceTexture", "Landroid/graphics/SurfaceTexture;", "notifySurfaceDestroy", "", "holder", "Landroid/view/SurfaceHolder;", "syncDestroy", "", "setSurfaceListener", "l", "surfaceChanged", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "switchToRecordableMode", "forceRecreate", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "lib-magicbrush-nano_release"})
public class g extends SurfaceView implements SurfaceHolder.Callback, MagicBrushView.b {
    private final View cON = this;
    private final MagicBrushView.h cOO = MagicBrushView.h.SurfaceView;
    private MagicBrushView.c cOP;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(Context context) {
        super(context);
        p.h(context, "context");
        AppMethodBeat.i(140229);
        getHolder().addCallback(this);
        AppMethodBeat.o(140229);
    }

    @Override // com.tencent.magicbrush.ui.MagicBrushView.b
    public Object getSurface() {
        AppMethodBeat.i(182579);
        Object a2 = MagicBrushView.b.a.a(this);
        AppMethodBeat.o(182579);
        return a2;
    }

    @Override // com.tencent.magicbrush.ui.MagicBrushView.b
    public View getThisView() {
        return this.cON;
    }

    @Override // com.tencent.magicbrush.ui.MagicBrushView.b
    public MagicBrushView.h getViewType() {
        return this.cOO;
    }

    public SurfaceTexture getSurfaceTexture() {
        return null;
    }

    @Override // com.tencent.magicbrush.ui.MagicBrushView.b
    public void setSurfaceListener(MagicBrushView.c cVar) {
        this.cOP = cVar;
    }

    @Override // com.tencent.magicbrush.ui.MagicBrushView.b
    public void a(boolean z, boolean z2, b<? super Boolean, Void> bVar, MBRuntime mBRuntime) {
        AppMethodBeat.i(206872);
        p.h(bVar, "callback");
        p.h(mBRuntime, "runtime");
        bVar.invoke(Boolean.TRUE);
        AppMethodBeat.o(206872);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Object surfaceTexture;
        AppMethodBeat.i(140226);
        p.h(surfaceHolder, "holder");
        Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
        MagicBrushView.c cVar = this.cOP;
        if (cVar != null) {
            if (getSurfaceTexture() == null) {
                surfaceTexture = surfaceHolder.getSurface();
            } else {
                surfaceTexture = getSurfaceTexture();
                if (surfaceTexture == null) {
                    p.hyc();
                }
            }
            p.g(surfaceTexture, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
            cVar.a(surfaceTexture, surfaceFrame.width(), surfaceFrame.height(), false);
            AppMethodBeat.o(140226);
            return;
        }
        AppMethodBeat.o(140226);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Object surfaceTexture;
        AppMethodBeat.i(140227);
        p.h(surfaceHolder, "holder");
        MagicBrushView.c cVar = this.cOP;
        if (cVar != null) {
            if (getSurfaceTexture() == null) {
                surfaceTexture = surfaceHolder.getSurface();
            } else {
                surfaceTexture = getSurfaceTexture();
                if (surfaceTexture == null) {
                    p.hyc();
                }
            }
            p.g(surfaceTexture, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
            cVar.c(surfaceTexture, i3, i4);
            AppMethodBeat.o(140227);
            return;
        }
        AppMethodBeat.o(140227);
    }

    public final void a(SurfaceHolder surfaceHolder, boolean z) {
        Object surfaceTexture;
        AppMethodBeat.i(206873);
        p.h(surfaceHolder, "holder");
        MagicBrushView.c cVar = this.cOP;
        if (cVar != null) {
            if (getSurfaceTexture() == null) {
                surfaceTexture = surfaceHolder.getSurface();
            } else {
                surfaceTexture = getSurfaceTexture();
                if (surfaceTexture == null) {
                    p.hyc();
                }
            }
            p.g(surfaceTexture, "when (getSurfaceTexture(…-> getSurfaceTexture()!!}");
            cVar.a(surfaceTexture, z);
            AppMethodBeat.o(206873);
            return;
        }
        AppMethodBeat.o(206873);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        AppMethodBeat.i(140228);
        p.h(surfaceHolder, "holder");
        a(surfaceHolder, false);
        AppMethodBeat.o(140228);
    }
}
