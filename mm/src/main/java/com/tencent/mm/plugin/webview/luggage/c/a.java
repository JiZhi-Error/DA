package com.tencent.mm.plugin.webview.luggage.c;

import android.os.Build;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    public static void c(final Window window, final boolean z) {
        AppMethodBeat.i(78761);
        if (z) {
            window.getDecorView().setSystemUiVisibility(a(window, z));
            window.setFlags(1024, 1024);
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
                /* class com.tencent.mm.plugin.webview.luggage.c.a.AnonymousClass1 */

                public final void onSystemUiVisibilityChange(int i2) {
                    AppMethodBeat.i(78760);
                    if ((i2 & 4) == 0) {
                        window.getDecorView().setSystemUiVisibility(a.a(window, z));
                    }
                    AppMethodBeat.o(78760);
                }
            });
            AppMethodBeat.o(78761);
            return;
        }
        window.getDecorView().setSystemUiVisibility(a(window, z));
        window.clearFlags(1024);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(null);
        AppMethodBeat.o(78761);
    }

    public static int a(Window window, boolean z) {
        int i2;
        AppMethodBeat.i(78762);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (z) {
            int i3 = systemUiVisibility | 1024 | 256;
            if (Build.VERSION.SDK_INT >= 20) {
                i3 = i3 | 512 | 2;
            }
            i2 = i3 | 4;
            if (Build.VERSION.SDK_INT >= 19) {
                i2 |= 4096;
            }
        } else {
            int i4 = systemUiVisibility & -1025 & -257;
            if (Build.VERSION.SDK_INT >= 20) {
                i4 = i4 & -513 & -3;
            }
            i2 = i4 & -5;
            if (Build.VERSION.SDK_INT >= 19) {
                i2 &= -4097;
            }
        }
        AppMethodBeat.o(78762);
        return i2;
    }
}
