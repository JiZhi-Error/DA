package com.tencent.mm.ui.l.a;

import android.content.Context;
import android.graphics.Point;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.magicbrush.e;
import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.ui.l.b.a;
import java.lang.ref.WeakReference;

public final class d implements a {
    final e QlN;
    private WeakReference<FrameLayout> QlO;
    public MagicBrushView QlP;
    private int QlQ = -1;
    boolean QlR = false;
    private final MagicBrushView.c QlS = new MagicBrushView.c() {
        /* class com.tencent.mm.ui.l.a.d.AnonymousClass1 */

        @Override // com.tencent.magicbrush.ui.MagicBrushView.c
        public final void c(Object obj, int i2, int i3) {
            g gVar;
            AppMethodBeat.i(234366);
            Log.i("MicroMsg.MagicEmojiPage", "hy: onSurfaceSizeChanged %d %s %d %d", Integer.valueOf(hashCode()), obj.toString(), Integer.valueOf(i2), Integer.valueOf(i3));
            if (d.this.QlN != null) {
                gVar = d.this.QlN.QlU;
            } else {
                gVar = null;
            }
            if (gVar != null) {
                gVar.gWH();
            }
            d.this.lp(i2, i3);
            AppMethodBeat.o(234366);
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.c
        public final void a(Object obj, int i2, int i3, boolean z) {
            AppMethodBeat.i(234367);
            Log.i("MicroMsg.MagicEmojiPage", "hy: onSurfaceAvailable: %d, %s, %d, %d, %b", Integer.valueOf(hashCode()), obj.toString(), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z));
            d.this.lp(i2, i3);
            d.this.QlR = true;
            if (!(d.this.QlN == null || d.this.QlN.QlU == null)) {
                g gVar = d.this.QlN.QlU;
                Log.i("MicroMsg.MagicEmojiService", "hy: surface ready, flush pending msgs with size: %d", Integer.valueOf(gVar.QlJ.size()));
                for (c cVar : gVar.QlJ) {
                    gVar.b(cVar);
                }
                gVar.QlJ.clear();
            }
            AppMethodBeat.o(234367);
        }

        @Override // com.tencent.magicbrush.ui.MagicBrushView.c
        public final void a(Object obj, boolean z) {
            AppMethodBeat.i(234368);
            Log.i("MicroMsg.MagicEmojiPage", "hy: onSurfaceDestroyed: %d, %s, %b", Integer.valueOf(hashCode()), obj.toString(), Boolean.valueOf(z));
            d.this.QlR = false;
            AppMethodBeat.o(234368);
        }
    };
    private boolean mIsRunning = false;

    public d(e eVar) {
        AppMethodBeat.i(259035);
        this.QlN = eVar;
        AppMethodBeat.o(259035);
    }

    private void lH() {
        AppMethodBeat.i(234371);
        Log.i("MicroMsg.MagicEmojiPage", "hy: page attaching");
        FrameLayout frameLayout = this.QlO.get();
        if (frameLayout == null) {
            a.bnK("holder is released!");
            Log.w("MicroMsg.MagicEmojiPage", "hy: holder is released!");
            AppMethodBeat.o(234371);
            return;
        }
        if (this.QlP == null) {
            Context context = MMApplicationContext.getContext();
            Log.i("MicroMsg.MagicEmojiPage", "hy: creating magic brush view");
            MagicBrushView magicBrushView = new MagicBrushView(context, MagicBrushView.h.TextureView);
            magicBrushView.setOpaque(false);
            magicBrushView.setEnableTouchEvent(false);
            e magicBrush = this.QlN.QlU.Qmf.getMagicBrush();
            if (this.QlQ < 0) {
                magicBrushView.setMagicBrush(magicBrush);
                Log.i("MicroMsg.MagicEmojiPage", "hy: first magicbrush view: %d", Integer.valueOf(this.QlQ));
                this.QlQ = magicBrushView.getVirtualElementId();
            } else {
                Log.i("MicroMsg.MagicEmojiPage", "hy: already has magicbrush view: %d", Integer.valueOf(this.QlQ));
                magicBrushView.a(magicBrush, this.QlQ);
            }
            magicBrushView.a(this.QlS);
            this.QlP = magicBrushView;
        }
        if (this.QlP.isAttachedToWindow() || this.QlP.getParent() == frameLayout) {
            Log.i("MicroMsg.MagicEmojiPage", "hy: already attached");
            AppMethodBeat.o(234371);
            return;
        }
        Log.i("MicroMsg.MagicEmojiPage", "hy: view not attached. need re-attach");
        ViewParent parent = this.QlP.getParent();
        if (parent instanceof ViewGroup) {
            Log.i("MicroMsg.MagicEmojiPage", "hy: need remove first");
            ((ViewGroup) parent).removeView(this.QlP);
        } else if (parent != null) {
            Log.printInfoStack("MicroMsg.MagicEmojiPage", "hy: view parent is not null and is not view group!", new Object[0]);
        }
        this.QlP.setViewType(MagicBrushView.h.TextureView);
        frameLayout.addView(this.QlP, new FrameLayout.LayoutParams(-1, -1));
        Log.i("MicroMsg.MagicEmojiPage", "hy: attach done");
        AppMethodBeat.o(234371);
    }

    @Override // com.tencent.mm.ui.l.a.a
    public final void CB(boolean z) {
        AppMethodBeat.i(234372);
        if (this.mIsRunning != z) {
            Log.printInfoStack("MicroMsg.MagicEmojiPage", "hy: running state change to %b", Boolean.valueOf(z));
            this.mIsRunning = z;
            if (this.mIsRunning) {
                lH();
                AppMethodBeat.o(234372);
                return;
            }
            detach();
            AppMethodBeat.o(234372);
            return;
        }
        Log.w("MicroMsg.MagicEmojiPage", "hy: same running state %b", Boolean.valueOf(z));
        AppMethodBeat.o(234372);
    }

    @Override // com.tencent.mm.ui.l.a.a
    public final void notifyDestroy() {
        AppMethodBeat.i(234373);
        Log.printInfoStack("MicroMsg.MagicEmojiPage", "hy: page destroyed from stack", new Object[0]);
        detach();
        AppMethodBeat.o(234373);
    }

    private void detach() {
        AppMethodBeat.i(259036);
        Log.i("MicroMsg.MagicEmojiPage", "hy: detach magic brush");
        FrameLayout frameLayout = this.QlO != null ? this.QlO.get() : null;
        if (frameLayout != null) {
            frameLayout.removeView(this.QlP);
        }
        if (this.QlP != null) {
            this.QlP.destroy();
            this.QlP.b(this.QlS);
            this.QlP = null;
        }
        AppMethodBeat.o(259036);
    }

    /* access modifiers changed from: package-private */
    public final void e(FrameLayout frameLayout) {
        AppMethodBeat.i(234375);
        FrameLayout frameLayout2 = this.QlO != null ? this.QlO.get() : null;
        if (frameLayout2 != frameLayout) {
            Log.i("MicroMsg.MagicEmojiPage", "hy: holder changed or create, need re-install");
            if (frameLayout2 != null) {
                detach();
            }
            this.QlO = new WeakReference<>(frameLayout);
            lH();
        }
        AppMethodBeat.o(234375);
    }

    /* access modifiers changed from: package-private */
    public final void lp(int i2, int i3) {
        g gVar;
        AppMethodBeat.i(234377);
        int zB = g.zB(i2);
        int zB2 = g.zB(i3);
        if (zB2 == 0 || zB == 0) {
            Log.e("MicroMsg.MagicEmojiPage", "hy: update width or height is 0!! Will raise up wasm crash, ignore");
            if (BuildInfo.DEBUG || WeChatEnvironment.hasDebugger()) {
                RuntimeException runtimeException = new RuntimeException("update width or height is 0!! Will raise up wasm crash, ignore");
                AppMethodBeat.o(234377);
                throw runtimeException;
            }
            AppMethodBeat.o(234377);
            return;
        }
        Log.i("MicroMsg.MagicEmojiPage", "hy: update window size to %d x %d", Integer.valueOf(zB), Integer.valueOf(zB2));
        String format = String.format("if (window !== undefined) { window.innerWidth = %d;window.innerHeight = %d; }", Integer.valueOf(zB), Integer.valueOf(zB2));
        if (this.QlN != null) {
            gVar = this.QlN.QlU;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            if (gVar.getJsRuntime() != null) {
                gVar.getJsRuntime().evaluateJavascript(format, null);
            }
            AppMethodBeat.o(234377);
            return;
        }
        Log.w("MicroMsg.MagicEmojiPage", "hy: service released!");
        AppMethodBeat.o(234377);
    }

    public final void gWD() {
        AppMethodBeat.i(234378);
        if (!this.QlR) {
            Log.w("MicroMsg.MagicEmojiPage", "hy: surface not prepared, but still need playing. use page view size as window width and height");
            Point gWE = gWE();
            lp(gWE.x, gWE.y);
        }
        AppMethodBeat.o(234378);
    }

    public final Point gWE() {
        AppMethodBeat.i(234379);
        FrameLayout frameLayout = this.QlO.get();
        if (frameLayout == null) {
            Log.w("MicroMsg.MagicEmojiPage", "hy: holder released, get page size failed");
            Point point = new Point(0, 0);
            AppMethodBeat.o(234379);
            return point;
        }
        if (this.QlP != null && this.QlP.getWidth() > 0 && this.QlP.getHeight() > 0) {
            this.QlP.isAttachedToWindow();
        }
        Point point2 = new Point(frameLayout.getWidth(), frameLayout.getHeight());
        AppMethodBeat.o(234379);
        return point2;
    }
}
