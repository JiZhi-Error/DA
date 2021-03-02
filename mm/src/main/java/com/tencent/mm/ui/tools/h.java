package com.tencent.mm.ui.tools;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;

public final class h {
    public g Quk;
    View Qul;
    private Rect Qum = new Rect();
    Rect Qun = new Rect();
    View Quo;
    private ViewTreeObserver.OnGlobalLayoutListener Qup;
    private ViewTreeObserver.OnGlobalLayoutListener Quq;
    private boolean Qur = true;
    private int Qus;
    private int Qut;
    private int Quu;
    private int Quv;
    private Activity activity;
    private boolean ddZ = false;

    public h(Activity activity2) {
        AppMethodBeat.i(143101);
        this.activity = activity2;
        if ((activity2.getWindow().getAttributes().softInputMode & 240) != 48) {
            Log.w("MicroMsg.KeyboardHeightProvider", "activity soft input should be adjust nothing");
            this.Qur = false;
        }
        this.Quo = activity2.findViewById(16908290);
        this.Qup = new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.ui.tools.h.AnonymousClass1 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(143099);
                if (h.this.Qul != null) {
                    h.a(h.this);
                }
                AppMethodBeat.o(143099);
            }
        };
        this.Quq = new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.ui.tools.h.AnonymousClass2 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(143100);
                if (h.this.Qul != null) {
                    int i2 = h.this.Qun.bottom;
                    h.this.Quo.getWindowVisibleDisplayFrame(h.this.Qun);
                    if (h.this.Qun.bottom != i2) {
                        Log.i("MicroMsg.KeyboardHeightProvider", "onGlobalLayout: %s, %s", Integer.valueOf(i2), h.this.Qun.toShortString());
                        h.a(h.this);
                    }
                }
                AppMethodBeat.o(143100);
            }
        };
        int identifier = Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            this.Quu = Resources.getSystem().getDimensionPixelSize(identifier);
        }
        this.Quv = a.fromDPToPix((Context) activity2, 96);
        AppMethodBeat.o(143101);
    }

    public final void start() {
        AppMethodBeat.i(143102);
        if (this.Quo != null) {
            Log.i("MicroMsg.KeyboardHeightProvider", "start: %s, %s", Boolean.valueOf(this.ddZ), this.Quo.getWindowToken());
            if (!this.ddZ && this.Quo.getWindowToken() != null && !this.activity.isFinishing()) {
                this.ddZ = true;
                this.Qul = new LinearLayout(this.activity);
                this.Qul.setBackgroundColor(0);
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(1003, 131096, 1);
                layoutParams.width = 0;
                layoutParams.height = -1;
                layoutParams.gravity = 8388659;
                layoutParams.softInputMode = 16;
                layoutParams.setTitle("KeyboardWindow@" + hashCode());
                try {
                    this.activity.getWindowManager().addView(this.Qul, layoutParams);
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.KeyboardHeightProvider", e2, "", new Object[0]);
                    this.ddZ = false;
                    this.Qul = null;
                }
                if (this.ddZ) {
                    this.Qul.getViewTreeObserver().addOnGlobalLayoutListener(this.Qup);
                    this.Quo.getViewTreeObserver().addOnGlobalLayoutListener(this.Quq);
                }
                this.Qus = 0;
                this.Qut = 0;
                if ((this.activity.getWindow().getAttributes().softInputMode & 240) != 48) {
                    Log.w("MicroMsg.KeyboardHeightProvider", "start: activity soft input should be adjust nothing");
                    this.Qur = false;
                    AppMethodBeat.o(143102);
                    return;
                }
                this.Qur = true;
            }
        }
        AppMethodBeat.o(143102);
    }

    public final void close() {
        AppMethodBeat.i(143103);
        Log.i("MicroMsg.KeyboardHeightProvider", "close: ");
        this.Quo.getViewTreeObserver().removeOnGlobalLayoutListener(this.Quq);
        if (this.ddZ && this.Qul != null) {
            this.Qul.getViewTreeObserver().removeOnGlobalLayoutListener(this.Qup);
            try {
                this.activity.getWindowManager().removeView(this.Qul);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.KeyboardHeightProvider", e2, "", new Object[0]);
            }
            this.Qul = null;
        }
        this.ddZ = false;
        AppMethodBeat.o(143103);
    }

    public final void setKeyboardHeightObserver(g gVar) {
        this.Quk = gVar;
    }

    static /* synthetic */ void a(h hVar) {
        int i2;
        boolean z;
        DisplayCutout displayCutout;
        int safeInsetBottom;
        AppMethodBeat.i(143104);
        hVar.Qul.getWindowVisibleDisplayFrame(hVar.Qum);
        hVar.Quo.getWindowVisibleDisplayFrame(hVar.Qun);
        if (hVar.Qum.bottom > hVar.Qus) {
            hVar.Qus = hVar.Qum.bottom;
        }
        if (hVar.Qun.bottom > hVar.Qut) {
            hVar.Qut = hVar.Qun.bottom;
        }
        int i3 = hVar.Qut - hVar.Qus;
        if (hVar.Qur) {
            i2 = hVar.Qun.bottom - hVar.Qum.bottom;
            if (d.oD(28) && hVar.Quo.getRootWindowInsets() != null && (displayCutout = hVar.Quo.getRootWindowInsets().getDisplayCutout()) != null && (safeInsetBottom = displayCutout.getSafeInsetBottom()) == i2) {
                Log.i("MicroMsg.KeyboardHeightProvider", "handleOnGlobalLayout: has cutout bottom, %s", Integer.valueOf(safeInsetBottom));
                i2 -= safeInsetBottom;
            }
            if (i2 == hVar.Quu && hVar.Quu != 0) {
                Log.i("MicroMsg.KeyboardHeightProvider", "handleOnGlobalLayout: navigationHeight %d, %d, %d", Integer.valueOf(hVar.Qus), Integer.valueOf(hVar.Qut), Integer.valueOf(hVar.Quu));
                i2 -= hVar.Quu;
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1062, 5);
            }
            if (i2 == i3 && i3 > 0 && i3 < hVar.Quv) {
                Log.i("MicroMsg.KeyboardHeightProvider", "handleOnGlobalLayout: max bottom diff %d, %d, %d", Integer.valueOf(hVar.Qus), Integer.valueOf(hVar.Qut), Integer.valueOf(i3));
                i2 -= i3;
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1062, 6);
            }
            if (i2 != 0 || hVar.Qut - hVar.Qun.bottom <= hVar.Quv) {
                z = false;
            } else {
                Log.w("MicroMsg.KeyboardHeightProvider", "handleOnGlobalLayout: adjust nothing not work!");
                i2 = hVar.Qut - hVar.Qun.bottom;
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1062, 7);
                z = true;
            }
        } else {
            i2 = hVar.Qus - hVar.Qum.bottom;
            z = true;
        }
        Log.i("MicroMsg.KeyboardHeightProvider", "handleOnGlobalLayout: %s, %s", hVar.Qum.toShortString(), hVar.Qun.toShortString());
        if (hVar.Quk != null) {
            hVar.Quk.y(i2, z);
        }
        AppMethodBeat.o(143104);
    }
}
