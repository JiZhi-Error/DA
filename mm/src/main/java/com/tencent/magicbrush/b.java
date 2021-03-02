package com.tencent.magicbrush;

import android.graphics.Bitmap;
import android.view.TextureView;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.a.c;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.magicbrush.utils.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.concurrent.Callable;
import kotlin.aa;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\rJ*\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\"\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J\"\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0002J*\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0007J.\u0010\u0015\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\bH\u0004J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\n2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\bJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0016\u001a\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001e"}, hxF = {"Lcom/tencent/magicbrush/MBCanvasHandler;", "", "magicbrush", "Lcom/tencent/magicbrush/MagicBrush;", "(Lcom/tencent/magicbrush/MagicBrush;)V", "getMagicbrush", "()Lcom/tencent/magicbrush/MagicBrush;", "captureCanvas", "Landroid/graphics/Bitmap;", "windowId", "", "canvasId", "isWindow", "", "timeout", "", "captureCanvasOnJsThread", "captureCanvasOnOtherThread", "captureCanvasOnOtherThreadWaitingSwapDone", "captureDefaultWindow", "cache", "captureScreenCanvas", "virtualElementId", "width", "height", "bitmap", "captureWindow", "findViewOrNull", "Lcom/tencent/magicbrush/ui/MagicBrushView;", "Companion", "lib-magicbrush-nano_release"})
public final class b {
    private static final String TAG = TAG;
    private static final long cKw = cKw;
    public static final a cKx = new a((byte) 0);
    final e cui;

    public b(e eVar) {
        p.h(eVar, "magicbrush");
        AppMethodBeat.i(140087);
        this.cui = eVar;
        AppMethodBeat.o(140087);
    }

    public static final /* synthetic */ Bitmap a(b bVar, int i2, int i3, boolean z) {
        AppMethodBeat.i(161145);
        Bitmap k = bVar.k(i2, i3, z);
        AppMethodBeat.o(161145);
        return k;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, hxF = {"Lcom/tencent/magicbrush/MBCanvasHandler$Companion;", "", "()V", "CAPTURE_TIMEOUT", "", "getCAPTURE_TIMEOUT", "()J", "TAG", "", "getTAG", "()Ljava/lang/String;", "lib-magicbrush-nano_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(161144);
        AppMethodBeat.o(161144);
    }

    public final Bitmap h(int i2, int i3, boolean z) {
        AppMethodBeat.i(206815);
        if (i3 > 0 || z) {
            com.tencent.magicbrush.handler.c Rl = this.cui.Rl();
            p.g(Rl, "magicbrush.jsThreadHandler");
            if (Rl.LO()) {
                Bitmap k = k(i2, i3, z);
                AppMethodBeat.o(206815);
                return k;
            } else if (!z) {
                Bitmap i4 = i(i2, i3, z);
                AppMethodBeat.o(206815);
                return i4;
            } else {
                Bitmap j2 = j(i2, i3, z);
                AppMethodBeat.o(206815);
                return j2;
            }
        } else {
            AppMethodBeat.o(206815);
            return null;
        }
    }

    private final Bitmap i(int i2, int i3, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(161141);
        c.C0193c.i("MagicBrush", "captureCanvasOnOtherThread", new Object[0]);
        Bitmap bitmap = (Bitmap) this.cui.Rl().c(new CallableC0197b(this, i2, i3, z));
        Object[] objArr = new Object[1];
        if (bitmap != null) {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        c.C0193c.i("MagicBrush", "ca done %b", objArr);
        AppMethodBeat.o(161141);
        return bitmap;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u0004"}, hxF = {"com/tencent/magicbrush/MBCanvasHandler$captureCanvasOnOtherThreadWaitingSwapDone$ret$1", "Lcom/tencent/magicbrush/utils/ManualFinishableSyncTask;", "Landroid/graphics/Bitmap;", "run", "lib-magicbrush-nano_release"})
    public static final class c extends com.tencent.magicbrush.utils.d<Bitmap> {
        final /* synthetic */ int cKA;
        final /* synthetic */ boolean cKB;
        final /* synthetic */ b cKy;
        final /* synthetic */ int cKz;

        /* JADX WARN: Incorrect types in method signature: (IIZJLjava/lang/Object;)V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar, int i2, int i3, boolean z, long j2) {
            super(j2);
            this.cKy = bVar;
            this.cKz = i2;
            this.cKA = i3;
            this.cKB = z;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "beforeSwap"})
        static final class a implements MBRuntime.a {
            final /* synthetic */ c cKC;

            a(c cVar) {
                this.cKC = cVar;
            }

            @Override // com.tencent.magicbrush.MBRuntime.a
            public final void beforeSwap(boolean z) {
                AppMethodBeat.i(161138);
                a aVar = b.cKx;
                c.C0193c.i(b.TAG, "hy: is swap all window: ".concat(String.valueOf(z)), new Object[0]);
                this.cKC.setResultFinish(b.a(this.cKC.cKy, this.cKC.cKz, this.cKC.cKA, this.cKC.cKB));
                AppMethodBeat.o(161138);
            }
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.magicbrush.utils.d
        public final /* synthetic */ Bitmap run() {
            AppMethodBeat.i(161139);
            this.cKy.cui.a(new a(this));
            AppMethodBeat.o(161139);
            return null;
        }
    }

    private final Bitmap j(int i2, int i3, boolean z) {
        boolean z2;
        AppMethodBeat.i(206816);
        c.C0193c.i("MagicBrush", "hy: captureCanvasOnOtherThreadWaitingSwapDone", new Object[0]);
        Bitmap bitmap = (Bitmap) new c(this, i2, i3, z, cKw).b(this.cui.Rl());
        String str = TAG;
        Object[] objArr = new Object[1];
        if (bitmap == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        objArr[0] = Boolean.valueOf(z2);
        c.C0193c.i(str, "hy: is ret bitmap is null? %b", objArr);
        AppMethodBeat.o(206816);
        return bitmap;
    }

    private final Bitmap k(int i2, int i3, boolean z) {
        AppMethodBeat.i(161143);
        Bitmap l = this.cui.l(i2, i3, z);
        AppMethodBeat.o(161143);
        return l;
    }

    /* access modifiers changed from: package-private */
    public final MagicBrushView ih(int i2) {
        AppMethodBeat.i(140086);
        MagicBrushView findOrNull = this.cui.cLz.findOrNull(i2);
        if (findOrNull == null) {
            com.github.henryye.nativeiv.a.b.e("MagicBrush", "findView [%d] but can not find. thread = [%s]", Integer.valueOf(i2), Thread.currentThread());
            AppMethodBeat.o(140086);
            return null;
        }
        AppMethodBeat.o(140086);
        return findOrNull;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/graphics/Bitmap;", "call"})
    /* renamed from: com.tencent.magicbrush.b$b  reason: collision with other inner class name */
    public static final class CallableC0197b<V> implements Callable<Bitmap> {
        final /* synthetic */ int cKA;
        final /* synthetic */ boolean cKB;
        final /* synthetic */ b cKy;
        final /* synthetic */ int cKz;

        CallableC0197b(b bVar, int i2, int i3, boolean z) {
            this.cKy = bVar;
            this.cKz = i2;
            this.cKA = i3;
            this.cKB = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public final /* synthetic */ Bitmap call() {
            AppMethodBeat.i(185067);
            Bitmap a2 = b.a(this.cKy, this.cKz, this.cKA, this.cKB);
            AppMethodBeat.o(185067);
            return a2;
        }
    }

    public static /* synthetic */ Bitmap a(b bVar) {
        AppMethodBeat.i(140085);
        MagicBrushView ih = bVar.ih(0);
        if (ih == null) {
            AppMethodBeat.o(140085);
            return null;
        }
        MagicBrushView.b bVar2 = ih.cOS;
        if (bVar2 instanceof TextureView) {
            c.C0193c.i("MagicBrushView", "hy: trigger get bitmap in texture view. need sync ui thread", new Object[0]);
            f fVar = f.cPx;
            Bitmap bitmap = (Bitmap) f.f(new MagicBrushView.i(bVar2));
            AppMethodBeat.o(140085);
            return bitmap;
        }
        c.C0193c.i("MagicBrushView", "hy: trigger get bitmap int other views", new Object[0]);
        e eVar = ih.cui;
        if (eVar == null) {
            p.btv("magicbrush");
        }
        Bitmap h2 = eVar.cLA.h(ih.cOR, -1, true);
        AppMethodBeat.o(140085);
        return h2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/graphics/Bitmap;", "invoke"})
    static final class d extends q implements kotlin.g.a.a<Bitmap> {
        final /* synthetic */ MagicBrushView cKD;
        final /* synthetic */ int cKE;
        final /* synthetic */ int cKF;
        final /* synthetic */ Bitmap cKG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(MagicBrushView magicBrushView, int i2, int i3, Bitmap bitmap) {
            super(0);
            this.cKD = magicBrushView;
            this.cKE = i2;
            this.cKF = i3;
            this.cKG = bitmap;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Bitmap invoke() {
            AppMethodBeat.i(140081);
            MagicBrushView magicBrushView = this.cKD;
            int i2 = this.cKE;
            int i3 = this.cKF;
            Bitmap bitmap = this.cKG;
            boolean z = magicBrushView.cOS instanceof TextureView;
            if (!aa.SXc || z) {
                MagicBrushView.b bVar = magicBrushView.cOS;
                if (bVar == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.TextureView");
                    AppMethodBeat.o(140081);
                    throw tVar;
                }
                TextureView textureView = (TextureView) bVar;
                MagicBrushView.a aVar = MagicBrushView.cPb;
                if (MagicBrushView.a.b(bitmap, i2, i3) != null) {
                    Bitmap bitmap2 = textureView.getBitmap(bitmap);
                    AppMethodBeat.o(140081);
                    return bitmap2;
                }
                Bitmap bitmap3 = textureView.getBitmap(i2, i3);
                AppMethodBeat.o(140081);
                return bitmap3;
            }
            AssertionError assertionError = new AssertionError("Assertion failed");
            AppMethodBeat.o(140081);
            throw assertionError;
        }
    }
}
