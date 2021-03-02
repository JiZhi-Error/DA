package com.tencent.mm.plugin.emojicapture.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView;
import com.tencent.mm.plugin.appbrand.jsapi.al;
import com.tencent.mm.plugin.emojicapture.ui.b.e;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView;", "Lcom/tencent/mm/media/widget/camerarecordview/preview/CameraPreviewGLTextureView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "getPreviewTexture", "Lcom/tencent/mm/media/globject/GLTextureObject;", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureGLTextureView extends CameraPreviewGLTextureView {
    public static final a rrN = new a((byte) 0);

    static {
        AppMethodBeat.i(al.CTRL_INDEX);
        AppMethodBeat.o(al.CTRL_INDEX);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureGLTextureView$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public EmojiCaptureGLTextureView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public EmojiCaptureGLTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EmojiCaptureGLTextureView(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.media.widget.camerarecordview.preview.e, com.tencent.mm.media.widget.camerarecordview.preview.CameraPreviewGLTextureView
    public final d getPreviewTexture() {
        AppMethodBeat.i(256434);
        if (getRenderer() instanceof e) {
            com.tencent.mm.media.j.a renderer = getRenderer();
            if (renderer == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.emojicapture.ui.gl.EmojiCapturePreviewRenderer");
                AppMethodBeat.o(256434);
                throw tVar;
            }
            d cJX = ((e) renderer).cJX();
            AppMethodBeat.o(256434);
            return cJX;
        }
        d previewTexture = super.getPreviewTexture();
        AppMethodBeat.o(256434);
        return previewTexture;
    }
}
