package com.tencent.magicbrush.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.handler.JsTouchEventHandler;
import com.tencent.magicbrush.ui.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.smtt.sdk.WebView;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.a.ab;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.xwalk.core.XWalkView;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0019\b\u0016\u0018\u0000 Z2\u00020\u0001:\bZ[\\]^_`aB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rB+\b\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020&J\u000e\u0010<\u001a\u00020:2\u0006\u0010;\u001a\u00020*J\u000e\u0010=\u001a\u00020:2\u0006\u0010;\u001a\u00020-J\u0006\u0010>\u001a\u00020:J\u0019\u0010?\u001a\u0004\u0018\u00010@2\b\u0010A\u001a\u0004\u0018\u00010@H\u0000¢\u0006\u0002\bBJ)\u0010?\u001a\u0004\u0018\u00010@2\u0006\u0010C\u001a\u00020\u00102\u0006\u0010D\u001a\u00020\u00102\b\u0010A\u001a\u0004\u0018\u00010@H\u0000¢\u0006\u0002\bBJ\b\u0010E\u001a\u00020\u0010H\u0016J\u0006\u0010F\u001a\u00020\u001cJ\u0006\u0010G\u001a\u00020\fJ\u0010\u0010H\u001a\u00020\u00132\u0006\u0010I\u001a\u00020JH\u0017J\u000e\u0010K\u001a\u00020:2\u0006\u0010;\u001a\u00020&J\u000e\u0010L\u001a\u00020:2\u0006\u0010;\u001a\u00020*J\u000e\u0010M\u001a\u00020:2\u0006\u0010;\u001a\u00020-J\u000e\u0010N\u001a\u00020:2\u0006\u0010\u001d\u001a\u00020\u001cJ\u0016\u0010N\u001a\u00020:2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020\u0010J\u000e\u0010P\u001a\u00020:2\u0006\u0010/\u001a\u00020\fJ9\u0010Q\u001a\u00020:2\u0006\u0010R\u001a\u00020\u00132\u0006\u0010S\u001a\u00020\u00132!\u0010T\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\bV\u0012\b\bW\u0012\u0004\b\b(X\u0012\u0004\u0012\u00020Y0UR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R \u0010\"\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00138G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020*0%¢\u0006\b\n\u0000\u001a\u0004\b+\u0010(R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020-0%¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R$\u0010\b\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t8G@GX\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00104\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0010@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006b"}, hxF = {"Lcom/tencent/magicbrush/ui/MagicBrushView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "(Landroid/content/Context;Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;)V", "renderer", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "(Landroid/content/Context;Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;)V", "rendererView", "defStyleAttr", "", "(Landroid/content/Context;Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;Landroid/util/AttributeSet;I)V", "enableTouchEvent", "", "getEnableTouchEvent", "()Z", "setEnableTouchEvent", "(Z)V", "internalSurfaceListener", "com/tencent/magicbrush/ui/MagicBrushView$internalSurfaceListener$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$internalSurfaceListener$1;", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "value", "opaque", "getOpaque", "setOpaque", "<set-?>", "prepared", "isPrepared", "preparedListeners", "Lcom/tencent/magicbrush/utils/ListenerList;", "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "getPreparedListeners", "()Lcom/tencent/magicbrush/utils/ListenerList;", "renderingContextListeners", "Lcom/tencent/magicbrush/ui/MagicBrushView$RenderingContextListener;", "getRenderingContextListeners", "surfaceListener", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "getSurfaceListener", "v", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "setViewType", "(Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;)V", "virtualElementId", "getVirtualElementId", "()I", "setVirtualElementId$lib_magicbrush_nano_release", "(I)V", "addOnPreparedListener", "", "l", "addRenderingContextListener", "addSurfaceListener", "destroy", "getBitmap", "Landroid/graphics/Bitmap;", "bitmap", "getBitmap$lib_magicbrush_nano_release", "width", "height", "getDefaultBackground", "getMagicBrush", "getRendererView", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "removeOnPreparedListener", "removeRenderingContextListener", "removeSurfaceListener", "setMagicBrush", "id", "setRendererView", "switchToRecordableMode", "forceRecreate", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "Companion", "MBRendererView", "MBSurfaceListener", "MBSurfaceListenerAbs", "MBSurfaceListenerExt", "OnPreparedListener", "RenderingContextListener", "ViewType", "lib-magicbrush-nano_release"})
public class MagicBrushView extends FrameLayout {
    private static final h cOZ = h.TextureView;
    private static final JsTouchEventHandler cPa = new JsTouchEventHandler();
    public static final a cPb = new a((byte) 0);
    private boolean bcY;
    public int cOR;
    public b cOS;
    private final com.tencent.magicbrush.utils.c<f> cOT;
    public final com.tencent.magicbrush.utils.c<g> cOU;
    private final com.tencent.magicbrush.utils.c<c> cOV;
    private boolean cOW;
    private boolean cOX;
    private final j cOY;
    public com.tencent.magicbrush.e cui;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\tH\u0016J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\r"}, hxF = {"Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "", "onSurfaceAvailable", "", "surface", "width", "", "height", "canReadPixelsFromJava", "", "onSurfaceDestroyed", "syncDestroy", "onSurfaceSizeChanged", "lib-magicbrush-nano_release"})
    public interface c {
        void a(Object obj, int i2, int i3, boolean z);

        void a(Object obj, boolean z);

        void c(Object obj, int i2, int i3);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListenerExt;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "beforeSurfaceAvailable", "", "surface", "", "width", "", "height", "beforeSurfaceDestroyed", "beforeSurfaceSizeChanged", "lib-magicbrush-nano_release"})
    public interface e extends c {
        void aJ(Object obj);

        void aM(Object obj);

        void aN(Object obj);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, hxF = {"Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "", "onPrepared", "", "lib-magicbrush-nano_release"})
    public interface f {
        void tf();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, hxF = {"Lcom/tencent/magicbrush/ui/MagicBrushView$RenderingContextListener;", "", "onRenderingContextCreated", "", "type", "", "lib-magicbrush-nano_release"})
    public interface g {
        void hI(int i2);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, hxF = {"Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "", "(Ljava/lang/String;I)V", XWalkView.SURFACE_VIEW, XWalkView.TEXTURE_VIEW, "VirtualView", "lib-magicbrush-nano_release"})
    public enum h {
        SurfaceView,
        TextureView,
        VirtualView;

        static {
            AppMethodBeat.i(140252);
            AppMethodBeat.o(140252);
        }

        public static h valueOf(String str) {
            AppMethodBeat.i(140254);
            h hVar = (h) Enum.valueOf(h.class, str);
            AppMethodBeat.o(140254);
            return hVar;
        }
    }

    public static final /* synthetic */ com.tencent.magicbrush.e c(MagicBrushView magicBrushView) {
        AppMethodBeat.i(140277);
        com.tencent.magicbrush.e eVar = magicBrushView.cui;
        if (eVar == null) {
            p.btv("magicbrush");
        }
        AppMethodBeat.o(140277);
        return eVar;
    }

    public static final /* synthetic */ void d(MagicBrushView magicBrushView) {
        AppMethodBeat.i(140278);
        magicBrushView.bcY = true;
        AppMethodBeat.o(140278);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&JC\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00190\u00152\u0006\u0010\u001a\u001a\u00020\u001bH&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, hxF = {"Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "", "thisView", "Landroid/view/View;", "getThisView", "()Landroid/view/View;", "viewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getViewType", "()Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "getSurface", "onDestroy", "", "setSurfaceListener", "l", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "switchToRecordableMode", "forceRecreate", "", "recordable", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "Ljava/lang/Void;", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "lib-magicbrush-nano_release"})
    public interface b {
        void a(boolean z, boolean z2, kotlin.g.a.b<? super Boolean, Void> bVar, MBRuntime mBRuntime);

        Object getSurface();

        View getThisView();

        h getViewType();

        void setSurfaceListener(c cVar);

        @l(hxD = {1, 1, 16})
        public static final class a {
            public static Object a(b bVar) {
                AppMethodBeat.i(182583);
                View thisView = bVar.getThisView();
                if (thisView != null) {
                    if (thisView instanceof TextureView) {
                        SurfaceTexture surfaceTexture = ((TextureView) thisView).getSurfaceTexture();
                        AppMethodBeat.o(182583);
                        return surfaceTexture;
                    } else if (thisView instanceof SurfaceView) {
                        SurfaceHolder holder = ((SurfaceView) thisView).getHolder();
                        p.g(holder, "it.holder");
                        Surface surface = holder.getSurface();
                        AppMethodBeat.o(182583);
                        return surface;
                    }
                }
                AppMethodBeat.o(182583);
                return null;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J(\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u0012"}, hxF = {"Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListenerAbs;", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListenerExt;", "()V", "beforeSurfaceAvailable", "", "surface", "", "width", "", "height", "beforeSurfaceDestroyed", "beforeSurfaceSizeChanged", "onSurfaceAvailable", "canReadPixelsFromJava", "", "onSurfaceDestroyed", "syncDestroy", "onSurfaceSizeChanged", "lib-magicbrush-nano_release"})
    public static abstract class d implements e {
        @Override // com.tencent.magicbrush.ui.MagicBrushView.c
        public final void a(Object obj, int i2, int i3, boolean z) {
            p.h(obj, "surface");
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.c
        public final void c(Object obj, int i2, int i3) {
            p.h(obj, "surface");
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.c
        public void a(Object obj, boolean z) {
            p.h(obj, "surface");
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.e
        public final void aM(Object obj) {
            p.h(obj, "surface");
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.e
        public final void aN(Object obj) {
            p.h(obj, "surface");
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.e
        public void aJ(Object obj) {
            p.h(obj, "surface");
        }
    }

    public final int getVirtualElementId() {
        return this.cOR;
    }

    public final void setVirtualElementId$lib_magicbrush_nano_release(int i2) {
        this.cOR = i2;
    }

    public final b getRendererView() {
        return this.cOS;
    }

    public final void setRendererView(b bVar) {
        AppMethodBeat.i(140264);
        p.h(bVar, "v");
        if (!com.tencent.magicbrush.utils.f.RE()) {
            IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(140264);
            throw illegalStateException;
        } else if (p.j(bVar, this.cOS)) {
            AppMethodBeat.o(140264);
        } else {
            if (bVar instanceof TextureView) {
                ((TextureView) bVar).setOpaque(this.cOW);
                if (this.cOW) {
                    setBackgroundColor(getDefaultBackground());
                } else {
                    setBackground(null);
                    ((TextureView) bVar).setBackground(null);
                }
            }
            c.C0193c.i("MagicBrushView", "dlview: change rendererView to %s", bVar);
            Object surface = this.cOS.getSurface();
            if (surface != null) {
                this.cOY.a(surface, false);
            }
            this.cOS.setSurfaceListener(null);
            View thisView = this.cOS.getThisView();
            if (thisView != null) {
                removeView(thisView);
            }
            bVar.setSurfaceListener(this.cOY);
            View thisView2 = bVar.getThisView();
            if (thisView2 != null) {
                addView(thisView2, -1, -1);
            }
            this.cOS = bVar;
            AppMethodBeat.o(140264);
        }
    }

    public final void destroy() {
        AppMethodBeat.i(206878);
        if (!com.tencent.magicbrush.utils.f.RE()) {
            IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(206878);
            throw illegalStateException;
        }
        c.C0193c.i("MagicBrushView", "dlview: destroy this MagicBrushView %s", this);
        Object surface = this.cOS.getSurface();
        if (surface != null) {
            this.cOY.a(surface, false);
        }
        this.cOS.setSurfaceListener(null);
        com.tencent.magicbrush.e eVar = this.cui;
        if (eVar == null) {
            p.btv("magicbrush");
        }
        eVar.cLz.remove$lib_magicbrush_nano_release(this);
        AppMethodBeat.o(206878);
    }

    public final h getViewType() {
        AppMethodBeat.i(140265);
        h viewType = this.cOS.getViewType();
        AppMethodBeat.o(140265);
        return viewType;
    }

    public final void setViewType(h hVar) {
        AppMethodBeat.i(140266);
        p.h(hVar, "v");
        if (!com.tencent.magicbrush.utils.f.RE()) {
            IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
            AppMethodBeat.o(140266);
            throw illegalStateException;
        } else if (hVar == this.cOS.getViewType()) {
            c.C0193c.i("MagicBrushView", "dlview: viewType, cache hit", new Object[0]);
            AppMethodBeat.o(140266);
        } else {
            Context context = getContext();
            p.g(context, "context");
            setRendererView(a.a(context, hVar));
            AppMethodBeat.o(140266);
        }
    }

    public final void a(boolean z, boolean z2, kotlin.g.a.b<? super Boolean, Void> bVar) {
        AppMethodBeat.i(206879);
        p.h(bVar, "callback");
        b bVar2 = this.cOS;
        com.tencent.magicbrush.e eVar = this.cui;
        if (eVar == null) {
            p.btv("magicbrush");
        }
        bVar2.a(z, z2, bVar, eVar);
        AppMethodBeat.o(206879);
    }

    public final com.tencent.magicbrush.utils.c<f> getPreparedListeners() {
        return this.cOT;
    }

    public final com.tencent.magicbrush.utils.c<g> getRenderingContextListeners() {
        return this.cOU;
    }

    public final com.tencent.magicbrush.utils.c<c> getSurfaceListener() {
        return this.cOV;
    }

    public final void a(c cVar) {
        AppMethodBeat.i(162126);
        p.h(cVar, "l");
        this.cOV.add(cVar);
        AppMethodBeat.o(162126);
    }

    public final void b(c cVar) {
        AppMethodBeat.i(206880);
        p.h(cVar, "l");
        this.cOV.remove(cVar);
        AppMethodBeat.o(206880);
    }

    public final boolean getOpaque() {
        return this.cOW;
    }

    public final void setOpaque(boolean z) {
        AppMethodBeat.i(140267);
        if (getViewType() == h.SurfaceView) {
            c.C0193c.i("MagicBrushView", "SurfaceView[" + this.cOR + "] can not be set to opaque", new Object[0]);
            this.cOW = false;
            AppMethodBeat.o(140267);
            return;
        }
        c.C0193c.i("MagicBrushView", "TextureView[" + this.cOR + "] opaque set to [" + z + ']', new Object[0]);
        if (z) {
            setBackgroundColor(getDefaultBackground());
        } else {
            setBackground(null);
        }
        if (this.cOS instanceof TextureView) {
            b bVar = this.cOS;
            if (bVar == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.TextureView");
                AppMethodBeat.o(140267);
                throw tVar;
            }
            ((TextureView) bVar).setOpaque(z);
        }
        this.cOW = z;
        AppMethodBeat.o(140267);
    }

    public final com.tencent.magicbrush.e getMagicBrush() {
        AppMethodBeat.i(140268);
        com.tencent.magicbrush.e eVar = this.cui;
        if (eVar == null) {
            p.btv("magicbrush");
        }
        AppMethodBeat.o(140268);
        return eVar;
    }

    public final void setMagicBrush(com.tencent.magicbrush.e eVar) {
        AppMethodBeat.i(140269);
        p.h(eVar, "value");
        a(eVar, -1);
        AppMethodBeat.o(140269);
    }

    public final void a(com.tencent.magicbrush.e eVar, int i2) {
        AppMethodBeat.i(206881);
        p.h(eVar, "value");
        this.cui = eVar;
        com.tencent.magicbrush.e eVar2 = this.cui;
        if (eVar2 == null) {
            p.btv("magicbrush");
        }
        a.a(eVar2, getViewType());
        eVar.cLz.add$lib_magicbrush_nano_release(this, i2);
        AppMethodBeat.o(206881);
    }

    public final boolean getEnableTouchEvent() {
        return this.cOX;
    }

    public final void setEnableTouchEvent(boolean z) {
        this.cOX = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MagicBrushView(Context context, AttributeSet attributeSet) {
        this(context, null, attributeSet);
        p.h(context, "context");
        AppMethodBeat.i(140271);
        AppMethodBeat.o(140271);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MagicBrushView(Context context, b bVar) {
        this(context, bVar, null);
        p.h(context, "context");
        p.h(bVar, "renderer");
        AppMethodBeat.i(140274);
        AppMethodBeat.o(140274);
    }

    public int getDefaultBackground() {
        return WebView.NIGHT_MODE_COLOR;
    }

    private MagicBrushView(Context context, b bVar, AttributeSet attributeSet) {
        super(context, attributeSet, -1);
        b a2;
        AppMethodBeat.i(140275);
        this.cOR = -1;
        this.cOT = new com.tencent.magicbrush.utils.c<>();
        this.cOU = new com.tencent.magicbrush.utils.c<>();
        this.cOV = new com.tencent.magicbrush.utils.c<>();
        this.cOW = true;
        this.cOX = true;
        this.cOY = new j(this);
        if (bVar != null) {
            a2 = bVar;
        } else {
            h g2 = a.g(attributeSet);
            a2 = a.a(context, g2 == null ? cOZ : g2);
        }
        this.cOS = a2;
        this.cOS.setSurfaceListener(this.cOY);
        if (bVar instanceof TextureView) {
            setBackgroundColor(getDefaultBackground());
        }
        View thisView = this.cOS.getThisView();
        if (thisView != null) {
            addView(thisView, -1, -1);
            AppMethodBeat.o(140275);
            return;
        }
        AppMethodBeat.o(140275);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\nH\u0016J \u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, hxF = {"com/tencent/magicbrush/ui/MagicBrushView$internalSurfaceListener$1", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "onSurfaceAvailable", "", "surface", "", "width", "", "height", "canReadPixelsFromJava", "", "onSurfaceDestroyed", "syncDestroy", "onSurfaceSizeChanged", "lib-magicbrush-nano_release"})
    public static final class j implements c {
        final /* synthetic */ MagicBrushView cPh;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "invoke"})
        static final class a extends q implements kotlin.g.a.b<c, x> {
            final /* synthetic */ int cKE;
            final /* synthetic */ int cKF;
            final /* synthetic */ Object cPi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Object obj, int i2, int i3) {
                super(1);
                this.cPi = obj;
                this.cKE = i2;
                this.cKF = i3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(c cVar) {
                AppMethodBeat.i(140256);
                c cVar2 = cVar;
                p.h(cVar2, LocaleUtil.ITALIAN);
                if (cVar2 instanceof e) {
                    ((e) cVar2).aM(this.cPi);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(140256);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "invoke"})
        static final class b extends q implements kotlin.g.a.b<c, x> {
            final /* synthetic */ int cKE;
            final /* synthetic */ int cKF;
            final /* synthetic */ Object cPi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(Object obj, int i2, int i3) {
                super(1);
                this.cPi = obj;
                this.cKE = i2;
                this.cKF = i3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(c cVar) {
                AppMethodBeat.i(140257);
                c cVar2 = cVar;
                p.h(cVar2, LocaleUtil.ITALIAN);
                cVar2.a(this.cPi, this.cKE, this.cKF, false);
                x xVar = x.SXb;
                AppMethodBeat.o(140257);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/magicbrush/ui/MagicBrushView$OnPreparedListener;", "invoke"})
        static final class c extends q implements kotlin.g.a.b<f, x> {
            public static final c cPj = new c();

            static {
                AppMethodBeat.i(162123);
                AppMethodBeat.o(162123);
            }

            c() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(f fVar) {
                AppMethodBeat.i(162122);
                f fVar2 = fVar;
                p.h(fVar2, LocaleUtil.ITALIAN);
                fVar2.tf();
                x xVar = x.SXb;
                AppMethodBeat.o(162122);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "invoke"})
        public static final class d extends q implements kotlin.g.a.b<c, x> {
            final /* synthetic */ Object cPi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(Object obj) {
                super(1);
                this.cPi = obj;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(c cVar) {
                AppMethodBeat.i(140259);
                c cVar2 = cVar;
                p.h(cVar2, LocaleUtil.ITALIAN);
                if (cVar2 instanceof e) {
                    ((e) cVar2).aJ(this.cPi);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(140259);
                return xVar;
            }
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "invoke"})
        public static final class e extends q implements kotlin.g.a.b<c, x> {
            final /* synthetic */ Object cPi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(Object obj) {
                super(1);
                this.cPi = obj;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(c cVar) {
                AppMethodBeat.i(162124);
                c cVar2 = cVar;
                p.h(cVar2, LocaleUtil.ITALIAN);
                cVar2.a(this.cPi, false);
                x xVar = x.SXb;
                AppMethodBeat.o(162124);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "invoke"})
        static final class f extends q implements kotlin.g.a.b<c, x> {
            final /* synthetic */ int cKE;
            final /* synthetic */ int cKF;
            final /* synthetic */ Object cPi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(Object obj, int i2, int i3) {
                super(1);
                this.cPi = obj;
                this.cKE = i2;
                this.cKF = i3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(c cVar) {
                AppMethodBeat.i(140260);
                c cVar2 = cVar;
                p.h(cVar2, LocaleUtil.ITALIAN);
                if (cVar2 instanceof e) {
                    ((e) cVar2).aN(this.cPi);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(140260);
                return xVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/magicbrush/ui/MagicBrushView$MBSurfaceListener;", "invoke"})
        static final class g extends q implements kotlin.g.a.b<c, x> {
            final /* synthetic */ int cKE;
            final /* synthetic */ int cKF;
            final /* synthetic */ Object cPi;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(Object obj, int i2, int i3) {
                super(1);
                this.cPi = obj;
                this.cKE = i2;
                this.cKF = i3;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(c cVar) {
                AppMethodBeat.i(162125);
                c cVar2 = cVar;
                p.h(cVar2, LocaleUtil.ITALIAN);
                cVar2.c(this.cPi, this.cKE, this.cKF);
                x xVar = x.SXb;
                AppMethodBeat.o(162125);
                return xVar;
            }
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(MagicBrushView magicBrushView) {
            this.cPh = magicBrushView;
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.c
        public final void a(Object obj, int i2, int i3, boolean z) {
            AppMethodBeat.i(182584);
            p.h(obj, "surface");
            c.C0193c.i("MagicBrushView", "onSurfaceAvailable %s, %d, %d", obj, Integer.valueOf(i2), Integer.valueOf(i3));
            this.cPh.getSurfaceListener().c(new a(obj, i2, i3));
            try {
                if (obj instanceof Surface) {
                    MagicBrushView.c(this.cPh).a(this.cPh.getVirtualElementId(), (Surface) obj, i2, i3);
                } else if (obj instanceof SurfaceTexture) {
                    MagicBrushView.c(this.cPh).a(this.cPh.getVirtualElementId(), (SurfaceTexture) obj, i2, i3, z);
                } else {
                    String format = String.format("SurfaceType invalid. [%s]", Arrays.copyOf(new Object[]{obj}, 1));
                    p.g(format, "java.lang.String.format(this, *args)");
                    RuntimeException runtimeException = new RuntimeException(format);
                    AppMethodBeat.o(182584);
                    throw runtimeException;
                }
            } finally {
                this.cPh.getSurfaceListener().c(new b(obj, i2, i3));
                MagicBrushView.d(this.cPh);
                this.cPh.getPreparedListeners().c(c.cPj);
                this.cPh.getPreparedListeners().clear();
                AppMethodBeat.o(182584);
            }
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.c
        public final void c(Object obj, int i2, int i3) {
            AppMethodBeat.i(140262);
            p.h(obj, "surface");
            c.C0193c.i("MagicBrushView", "onSurfaceSizeChanged %s, %d, %d", obj, Integer.valueOf(i2), Integer.valueOf(i3));
            this.cPh.getSurfaceListener().c(new f(obj, i2, i3));
            try {
                if (obj instanceof Surface) {
                    MagicBrushView.c(this.cPh).b(this.cPh.getVirtualElementId(), (Surface) obj, i2, i3);
                } else if (obj instanceof SurfaceTexture) {
                    MagicBrushView.c(this.cPh).a(this.cPh.getVirtualElementId(), (SurfaceTexture) obj, i2, i3);
                } else {
                    String format = String.format("SurfaceType invalid. [%s]", Arrays.copyOf(new Object[]{obj}, 1));
                    p.g(format, "java.lang.String.format(this, *args)");
                    RuntimeException runtimeException = new RuntimeException(format);
                    AppMethodBeat.o(140262);
                    throw runtimeException;
                }
            } finally {
                this.cPh.getSurfaceListener().c(new g(obj, i2, i3));
                AppMethodBeat.o(140262);
            }
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.c
        public final void a(Object obj, boolean z) {
            AppMethodBeat.i(206877);
            p.h(obj, "surface");
            c.C0193c.i("MagicBrushView", "onSurfaceDestroyed %s, %d, %d", obj, Integer.valueOf(this.cPh.getWidth()), Integer.valueOf(this.cPh.getHeight()));
            this.cPh.getSurfaceListener().c(new d(obj));
            try {
                if (obj instanceof Surface) {
                    MagicBrushView.c(this.cPh).w(this.cPh.getVirtualElementId(), z);
                } else if (obj instanceof SurfaceTexture) {
                    MagicBrushView.c(this.cPh).a(this.cPh.getVirtualElementId(), (SurfaceTexture) obj);
                } else {
                    String format = String.format("SurfaceType invalid. [%s]", Arrays.copyOf(new Object[]{obj}, 1));
                    p.g(format, "java.lang.String.format(this, *args)");
                    RuntimeException runtimeException = new RuntimeException(format);
                    AppMethodBeat.o(206877);
                    throw runtimeException;
                }
            } finally {
                this.cPh.getSurfaceListener().c(new e(obj));
                AppMethodBeat.o(206877);
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(140270);
        p.h(motionEvent, "event");
        if (!this.cOX) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(140270);
            return onTouchEvent;
        }
        JsTouchEventHandler jsTouchEventHandler = cPa;
        com.tencent.magicbrush.e eVar = this.cui;
        if (eVar == null) {
            p.btv("magicbrush");
        }
        long a2 = jsTouchEventHandler.a(motionEvent, eVar.cLw.getDevicePixelRatio());
        com.tencent.magicbrush.e eVar2 = this.cui;
        if (eVar2 == null) {
            p.btv("magicbrush");
        }
        eVar2.a(this.cOR, a2, cPa.Rw());
        AppMethodBeat.o(140270);
        return true;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u0004H\u0002J$\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u001aJ!\u0010\u001b\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u001dJ$\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, hxF = {"Lcom/tencent/magicbrush/ui/MagicBrushView$Companion;", "", "()V", "DEFAULT_VIEW_TYPE", "Lcom/tencent/magicbrush/ui/MagicBrushView$ViewType;", "TAG", "", "touchEventHandler", "Lcom/tencent/magicbrush/handler/JsTouchEventHandler;", "checkAnimationHandler", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "viewType", "checkViewTypeValid", "createRendererViewByViewType", "Lcom/tencent/magicbrush/ui/MagicBrushView$MBRendererView;", "context", "Landroid/content/Context;", "getRendererViewOrDefault", "view", "attr", "Landroid/util/AttributeSet;", "getViewTypeByAttributeSet", "getVirtualElementByAttributeSet", "", "(Landroid/util/AttributeSet;)Ljava/lang/Integer;", "getVirtualElementIdOrZero", "virtualElementId", "(Ljava/lang/Integer;Landroid/util/AttributeSet;)I", "tryReconfigureBitmapIfNeed", "Landroid/graphics/Bitmap;", "bitmap", "width", "height", "lib-magicbrush-nano_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static h g(AttributeSet attributeSet) {
            h hVar;
            boolean z;
            AppMethodBeat.i(140249);
            h hVar2 = null;
            if (attributeSet != null) {
                Iterator it = kotlin.k.j.mY(0, attributeSet.getAttributeCount()).iterator();
                while (it.hasNext()) {
                    int nextInt = ((ab) it).nextInt();
                    if (p.j("viewType", attributeSet.getAttributeName(nextInt))) {
                        String attributeValue = attributeSet.getAttributeValue(nextInt);
                        a aVar = MagicBrushView.cPb;
                        p.g(attributeValue, "viewTypeName");
                        if (p.j(attributeValue, XWalkView.SURFACE_VIEW) || p.j(attributeValue, XWalkView.TEXTURE_VIEW)) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (!z) {
                            String format = String.format("ViewType must be [SurfaceView|TextureView], but is [%s]", Arrays.copyOf(new Object[]{attributeValue}, 1));
                            p.g(format, "java.lang.String.format(this, *args)");
                            IllegalStateException illegalStateException = new IllegalStateException(format.toString());
                            AppMethodBeat.o(140249);
                            throw illegalStateException;
                        } else if (p.j(attributeValue, XWalkView.SURFACE_VIEW)) {
                            hVar = h.SurfaceView;
                        } else {
                            hVar = h.TextureView;
                        }
                    } else {
                        hVar = hVar2;
                    }
                    hVar2 = hVar;
                }
            }
            AppMethodBeat.o(140249);
            return hVar2;
        }

        static b a(Context context, h hVar) {
            AppMethodBeat.i(140250);
            switch (i.$EnumSwitchMapping$0[hVar.ordinal()]) {
                case 1:
                    g gVar = new g(context);
                    AppMethodBeat.o(140250);
                    return gVar;
                case 2:
                    h hVar2 = new h(context);
                    AppMethodBeat.o(140250);
                    return hVar2;
                default:
                    Exception exc = new Exception("invalid viewType");
                    AppMethodBeat.o(140250);
                    throw exc;
            }
        }

        public static Bitmap b(Bitmap bitmap, int i2, int i3) {
            AppMethodBeat.i(140251);
            if (bitmap == null) {
                AppMethodBeat.o(140251);
                return null;
            } else if (bitmap.getWidth() == i2 && bitmap.getHeight() == i3) {
                AppMethodBeat.o(140251);
                return bitmap;
            } else {
                try {
                    bitmap.reconfigure(i2, i3, Bitmap.Config.ARGB_8888);
                    AppMethodBeat.o(140251);
                    return bitmap;
                } catch (Exception e2) {
                    AppMethodBeat.o(140251);
                    return null;
                }
            }
        }

        static void a(com.tencent.magicbrush.e eVar, h hVar) {
            AppMethodBeat.i(206876);
            if (hVar == h.TextureView) {
                if (!(eVar.cLw.Rq() != a.b.EglSurfaceSwapLocker)) {
                    IllegalStateException illegalStateException = new IllegalStateException(("ViewType [" + hVar + "] can not work with RAF mode[" + eVar.cLw.Rq() + ']').toString());
                    AppMethodBeat.o(206876);
                    throw illegalStateException;
                }
            }
            AppMethodBeat.o(206876);
        }
    }

    static {
        AppMethodBeat.i(140276);
        AppMethodBeat.o(140276);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "invoke"})
    public static final class i extends q implements kotlin.g.a.a<Bitmap> {
        final /* synthetic */ Bitmap cKG = null;
        final /* synthetic */ b cPg;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(b bVar) {
            super(0);
            this.cPg = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Bitmap invoke() {
            AppMethodBeat.i(140255);
            if (this.cKG != null) {
                Bitmap bitmap = ((TextureView) this.cPg).getBitmap(this.cKG);
                AppMethodBeat.o(140255);
                return bitmap;
            }
            Bitmap bitmap2 = ((TextureView) this.cPg).getBitmap();
            AppMethodBeat.o(140255);
            return bitmap2;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public MagicBrushView(Context context, h hVar) {
        this(context, a.a(context, hVar), null);
        p.h(context, "context");
        p.h(hVar, "viewType");
        AppMethodBeat.i(140273);
        AppMethodBeat.o(140273);
    }
}
