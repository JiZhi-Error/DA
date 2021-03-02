package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.RelativeLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.render.j;
import com.tencent.mm.ui.ao;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u001aJ\u000e\u0010#\u001a\u00020 2\u0006\u0010$\u001a\u00020\u0015J\u0018\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001aH\u0016J\u0006\u0010(\u001a\u00020 J\u0006\u0010)\u001a\u00020 J\u000e\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020,J\u0018\u0010-\u001a\u00020 2\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020\u001aH\u0016R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006/"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView;", "Landroid/view/SurfaceView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "callback", "Landroid/view/SurfaceHolder$Callback;", "getCallback", "()Landroid/view/SurfaceHolder$Callback;", "setCallback", "(Landroid/view/SurfaceHolder$Callback;)V", "eventListner", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "getEventListner", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "setEventListner", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "remoteMode", "", "getRemoteMode", "()I", "setRemoteMode", "(I)V", "addRenderEventListner", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "release", "removeRenderEventListner", "resetViewSize", "screenSize", "Landroid/graphics/Point;", "setOpenGlViewSize", "Companion", "plugin-voip_release"})
public class VoIPRenderSurfaceView extends SurfaceView {
    public static final a HoI = new a((byte) 0);
    public SurfaceHolder.Callback HoF = new b(this);
    public j.b HoG;
    public int HoH;
    private boolean onr;

    static {
        AppMethodBeat.i(236304);
        AppMethodBeat.o(236304);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void setFullScreen(boolean z) {
        this.onr = z;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoIPRenderSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(236303);
        AppMethodBeat.o(236303);
    }

    public void jI(int i2, int i3) {
        RelativeLayout.LayoutParams layoutParams;
        AppMethodBeat.i(236299);
        if (ao.gJI()) {
            layoutParams = new RelativeLayout.LayoutParams((i3 * 9) / 16, i3);
            layoutParams.addRule(13);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        setLayoutParams(layoutParams);
        requestLayout();
        AppMethodBeat.o(236299);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/voip/video/render/VoIPRenderSurfaceView$callback$1", "Landroid/view/SurfaceHolder$Callback;", "surfaceChanged", "", "holder", "Landroid/view/SurfaceHolder;", "format", "", "width", "height", "surfaceCreated", "surfaceDestroyed", "plugin-voip_release"})
    public static final class b implements SurfaceHolder.Callback {
        final /* synthetic */ VoIPRenderSurfaceView HoJ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(VoIPRenderSurfaceView voIPRenderSurfaceView) {
            this.HoJ = voIPRenderSurfaceView;
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            AppMethodBeat.i(236296);
            j.b eventListner = this.HoJ.getEventListner();
            if (eventListner != null) {
                eventListner.aG(i3, i4, this.HoJ.getRemoteMode());
                AppMethodBeat.o(236296);
                return;
            }
            AppMethodBeat.o(236296);
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            AppMethodBeat.i(236297);
            j.b eventListner = this.HoJ.getEventListner();
            if (eventListner != null) {
                eventListner.aed(this.HoJ.getRemoteMode());
                AppMethodBeat.o(236297);
                return;
            }
            AppMethodBeat.o(236297);
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            j.b eventListner;
            AppMethodBeat.i(236298);
            if (surfaceHolder == null || (eventListner = this.HoJ.getEventListner()) == null) {
                AppMethodBeat.o(236298);
                return;
            }
            eventListner.a(this.HoJ.getRemoteMode(), surfaceHolder.getSurface(), null);
            AppMethodBeat.o(236298);
        }
    }

    public final SurfaceHolder.Callback getCallback() {
        return this.HoF;
    }

    public final void setCallback(SurfaceHolder.Callback callback) {
        AppMethodBeat.i(236300);
        p.h(callback, "<set-?>");
        this.HoF = callback;
        AppMethodBeat.o(236300);
    }

    public final j.b getEventListner() {
        return this.HoG;
    }

    public final void setEventListner(j.b bVar) {
        this.HoG = bVar;
    }

    public final int getRemoteMode() {
        return this.HoH;
    }

    public final void setRemoteMode(int i2) {
        this.HoH = i2;
    }

    public final void fLZ() {
        AppMethodBeat.i(236301);
        getHolder().removeCallback(this.HoF);
        j.b bVar = this.HoG;
        if (bVar != null) {
            bVar.aed(this.HoH);
        }
        this.HoG = null;
        AppMethodBeat.o(236301);
    }

    public void jH(int i2, int i3) {
    }

    public final void release() {
        AppMethodBeat.i(236302);
        j.b bVar = this.HoG;
        if (bVar != null) {
            bVar.aed(this.HoH);
        }
        fLZ();
        AppMethodBeat.o(236302);
    }
}
