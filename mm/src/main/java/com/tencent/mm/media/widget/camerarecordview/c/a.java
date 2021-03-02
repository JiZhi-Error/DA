package com.tencent.mm.media.widget.camerarecordview.c;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.c;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0015\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\u0006\u0010\u001c\u001a\u00020\u001aR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0004\n\u0002\u0010\u0016¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit;", "", "ctx", "Landroid/content/Context;", "process", "Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;", "(Landroid/content/Context;Lcom/tencent/mm/media/widget/camerarecordview/process/ICameraContainerProcess;)V", "cameraConfig", "Lcom/tencent/mm/media/widget/camera/CameraConfig;", "getCameraConfig", "()Lcom/tencent/mm/media/widget/camera/CameraConfig;", "setCameraConfig", "(Lcom/tencent/mm/media/widget/camera/CameraConfig;)V", "context", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "currentDisplayRotation", "", "orientationChangeListener", "com/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1", "Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1;", "checkContext", "", "enableFit", "", "enable", "release", "Companion", "plugin-mediaeditor_release"})
public final class a {
    public static final C0433a iqt = new C0433a((byte) 0);
    public Context context;
    com.tencent.mm.media.widget.a.b hAu;
    private int iqr;
    public b iqs;

    static {
        AppMethodBeat.i(94289);
        AppMethodBeat.o(94289);
    }

    public a(Context context2, com.tencent.mm.media.widget.camerarecordview.d.a aVar) {
        p.h(context2, "ctx");
        p.h(aVar, "process");
        AppMethodBeat.i(94288);
        this.context = context2;
        this.iqs = new b(this, aVar, this.context);
        AppMethodBeat.o(94288);
    }

    public static final /* synthetic */ boolean a(a aVar) {
        AppMethodBeat.i(94290);
        boolean aQs = aVar.aQs();
        AppMethodBeat.o(94290);
        return aQs;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$Companion;", "", "()V", "TAG", "", "plugin-mediaeditor_release"})
    /* renamed from: com.tencent.mm.media.widget.camerarecordview.c.a$a  reason: collision with other inner class name */
    public static final class C0433a {
        private C0433a() {
        }

        public /* synthetic */ C0433a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/media/widget/camerarecordview/orientationfit/PreviewOrientationFit$orientationChangeListener$1", "Landroid/view/OrientationEventListener;", "onOrientationChanged", "", "orientation", "", "plugin-mediaeditor_release"})
    public static final class b extends OrientationEventListener {
        final /* synthetic */ a iqu;
        final /* synthetic */ com.tencent.mm.media.widget.camerarecordview.d.a iqv;

        /* JADX WARN: Incorrect types in method signature: (Lcom/tencent/mm/media/widget/camerarecordview/d/a;Landroid/content/Context;I)V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(a aVar, com.tencent.mm.media.widget.camerarecordview.d.a aVar2, Context context) {
            super(context, 3);
            this.iqu = aVar;
            this.iqv = aVar2;
        }

        public final void onOrientationChanged(int i2) {
            boolean z;
            com.tencent.mm.media.widget.a.b bVar;
            AppMethodBeat.i(94286);
            if (!a.a(this.iqu)) {
                AppMethodBeat.o(94286);
                return;
            }
            Context context = this.iqu.context;
            if (context == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(94286);
                throw tVar;
            }
            WindowManager windowManager = ((Activity) context).getWindowManager();
            p.g(windowManager, "(context as Activity).windowManager");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            p.g(defaultDisplay, "(context as Activity).windowManager.defaultDisplay");
            int rotation = defaultDisplay.getRotation();
            if (rotation == this.iqu.iqr) {
                AppMethodBeat.o(94286);
                return;
            }
            Log.i("MicroMsg.PreviewOrientationFit", "last rotation :" + this.iqu.iqr + " ,current rotation:" + rotation);
            this.iqu.iqr = rotation;
            switch (rotation) {
                case 0:
                    z = false;
                    break;
                case 1:
                    z = true;
                    break;
                case 2:
                    z = true;
                    break;
                case 3:
                    z = true;
                    break;
                default:
                    z = false;
                    break;
            }
            if (!z) {
                com.tencent.mm.media.widget.a.b bVar2 = this.iqu.hAu;
                if (bVar2 != null) {
                    com.tencent.mm.media.widget.a.b.rt(270);
                    this.iqv.getCameraPreviewView().a(bVar2);
                    c cVar = c.ipU;
                    com.tencent.mm.media.j.a renderer = c.getRenderer();
                    if (renderer != null) {
                        renderer.qx(com.tencent.mm.media.widget.a.b.aPk());
                        AppMethodBeat.o(94286);
                        return;
                    }
                    AppMethodBeat.o(94286);
                    return;
                }
                AppMethodBeat.o(94286);
            } else if (!z || (bVar = this.iqu.hAu) == null) {
                AppMethodBeat.o(94286);
            } else {
                com.tencent.mm.media.widget.a.b.rt(90);
                this.iqv.getCameraPreviewView().a(bVar);
                c cVar2 = c.ipU;
                com.tencent.mm.media.j.a renderer2 = c.getRenderer();
                if (renderer2 != null) {
                    renderer2.qx(com.tencent.mm.media.widget.a.b.aPk());
                    AppMethodBeat.o(94286);
                    return;
                }
                AppMethodBeat.o(94286);
            }
        }
    }

    public final void a(boolean z, com.tencent.mm.media.widget.a.b bVar) {
        AppMethodBeat.i(94287);
        Log.i("MicroMsg.PreviewOrientationFit", "enable :" + z + " ,cameraConfig " + bVar);
        if (!aQs()) {
            AppMethodBeat.o(94287);
        } else if (z) {
            this.hAu = bVar;
            Context context2 = this.context;
            if (context2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(94287);
                throw tVar;
            }
            ((Activity) context2).setRequestedOrientation(7);
            this.iqs.enable();
            AppMethodBeat.o(94287);
        } else {
            Context context3 = this.context;
            if (context3 == null) {
                t tVar2 = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(94287);
                throw tVar2;
            }
            ((Activity) context3).setRequestedOrientation(1);
            this.iqs.disable();
            this.iqr = 0;
            AppMethodBeat.o(94287);
        }
    }

    private final boolean aQs() {
        if (this.context == null) {
            return false;
        }
        return true;
    }
}
