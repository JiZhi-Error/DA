package com.tencent.mm.plugin.voip.video.render;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.render.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\r\b\u0016\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\tJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0012J\u0018\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\tH\u0016J\u0006\u0010$\u001a\u00020\u001cJ\u0006\u0010%\u001a\u00020\u001cJ\u0006\u0010&\u001a\u00020\u001cJ\u0006\u0010'\u001a\u00020\u001cR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView;", "Landroid/view/TextureView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "eventListner", "Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "getEventListner", "()Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;", "setEventListner", "(Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderMgr$RendererViewEvent;)V", "isFullScreen", "", "()Z", "setFullScreen", "(Z)V", "remoteMode", "getRemoteMode", "()I", "setRemoteMode", "(I)V", "addRenderEventListner", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "mode", "drawTransparent", "isTransparent", "initView", "w", "h", "release", "removeRenderEventListner", "resetRender", "resetViewSize", "Companion", "plugin-voip_release"})
public class VoIPRenderTextureView extends TextureView {
    public static final a HoK = new a((byte) 0);
    public j.b HoG;
    public int HoH;
    private boolean onr;

    static {
        AppMethodBeat.i(236312);
        AppMethodBeat.o(236312);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView$Companion;", "", "()V", "TAG", "", "plugin-voip_release"})
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public VoIPRenderTextureView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        p.h(context, "context");
        AppMethodBeat.i(236310);
        AppMethodBeat.o(236310);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VoIPRenderTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(context, "context");
        AppMethodBeat.i(236311);
        AppMethodBeat.o(236311);
    }

    public final void xv(boolean z) {
        AppMethodBeat.i(236308);
        if (z) {
            setAlpha(0.0f);
            AppMethodBeat.o(236308);
            return;
        }
        setAlpha(1.0f);
        AppMethodBeat.o(236308);
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

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\"\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/plugin/voip/video/render/VoIPRenderTextureView$addRenderEventListner$1", "Landroid/view/TextureView$SurfaceTextureListener;", "onSurfaceTextureAvailable", "", "surface", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "plugin-voip_release"})
    public static final class b implements TextureView.SurfaceTextureListener {
        final /* synthetic */ VoIPRenderTextureView HoL;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b(VoIPRenderTextureView voIPRenderTextureView) {
            this.HoL = voIPRenderTextureView;
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(236305);
            j.b eventListner = this.HoL.getEventListner();
            if (eventListner != null) {
                eventListner.aG(i2, i3, this.HoL.getRemoteMode());
                AppMethodBeat.o(236305);
                return;
            }
            AppMethodBeat.o(236305);
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(236306);
            j.b eventListner = this.HoL.getEventListner();
            if (eventListner != null) {
                eventListner.aed(this.HoL.getRemoteMode());
            }
            AppMethodBeat.o(236306);
            return true;
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            AppMethodBeat.i(236307);
            if (surfaceTexture != null) {
                j.b eventListner = this.HoL.getEventListner();
                if (eventListner != null) {
                    eventListner.a(this.HoL.getRemoteMode(), null, surfaceTexture);
                }
                j.b eventListner2 = this.HoL.getEventListner();
                if (eventListner2 != null) {
                    eventListner2.aG(i2, i3, this.HoL.getRemoteMode());
                    AppMethodBeat.o(236307);
                    return;
                }
            }
            AppMethodBeat.o(236307);
        }
    }

    public final void fMa() {
        AppMethodBeat.i(236309);
        j.b bVar = this.HoG;
        if (bVar != null) {
            bVar.fLY();
            AppMethodBeat.o(236309);
            return;
        }
        AppMethodBeat.o(236309);
    }
}
