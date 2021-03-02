package com.bumptech.glide.load.b.b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.loader.hotplug.EnvConsts;

public final class i {
    public final int aJb;
    public final int aJc;
    public final int aJd;
    private final Context context;

    interface c {
        int pj();

        int pk();
    }

    public i(a aVar) {
        int i2;
        AppMethodBeat.i(77162);
        this.context = aVar.context;
        if (a(aVar.aJf)) {
            i2 = aVar.aJl / 2;
        } else {
            i2 = aVar.aJl;
        }
        this.aJd = i2;
        ActivityManager activityManager = aVar.aJf;
        float f2 = aVar.aJj;
        float f3 = aVar.aJk;
        int round = Math.round((!a(activityManager) ? f2 : f3) * ((float) (activityManager.getMemoryClass() * 1024 * 1024)));
        int pj = aVar.aJg.pj() * aVar.aJg.pk() * 4;
        int round2 = Math.round(((float) pj) * aVar.aJi);
        int round3 = Math.round(((float) pj) * aVar.aJh);
        int i3 = round - this.aJd;
        if (round3 + round2 <= i3) {
            this.aJc = round3;
            this.aJb = round2;
        } else {
            float f4 = ((float) i3) / (aVar.aJi + aVar.aJh);
            this.aJc = Math.round(aVar.aJh * f4);
            this.aJb = Math.round(f4 * aVar.aJi);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            new StringBuilder("Calculation complete, Calculated memory cache size: ").append(dk(this.aJc)).append(", pool size: ").append(dk(this.aJb)).append(", byte array size: ").append(dk(this.aJd)).append(", memory class limited? ").append(round3 + round2 > round).append(", max size: ").append(dk(round)).append(", memoryClass: ").append(aVar.aJf.getMemoryClass()).append(", isLowMemoryDevice: ").append(a(aVar.aJf));
        }
        AppMethodBeat.o(77162);
    }

    private String dk(int i2) {
        AppMethodBeat.i(77163);
        String formatFileSize = Formatter.formatFileSize(this.context, (long) i2);
        AppMethodBeat.o(77163);
        return formatFileSize;
    }

    @TargetApi(19)
    static boolean a(ActivityManager activityManager) {
        AppMethodBeat.i(77164);
        if (Build.VERSION.SDK_INT >= 19) {
            boolean isLowRamDevice = activityManager.isLowRamDevice();
            AppMethodBeat.o(77164);
            return isLowRamDevice;
        }
        AppMethodBeat.o(77164);
        return true;
    }

    public static final class a {
        static final int aJe = (Build.VERSION.SDK_INT < 26 ? 4 : 1);
        ActivityManager aJf;
        c aJg;
        float aJh = 2.0f;
        float aJi = ((float) aJe);
        float aJj = 0.4f;
        float aJk = 0.33f;
        int aJl = 4194304;
        final Context context;

        public a(Context context2) {
            AppMethodBeat.i(77161);
            this.context = context2;
            this.aJf = (ActivityManager) context2.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            this.aJg = new b(context2.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && i.a(this.aJf)) {
                this.aJi = 0.0f;
            }
            AppMethodBeat.o(77161);
        }
    }

    static final class b implements c {
        private final DisplayMetrics aJm;

        b(DisplayMetrics displayMetrics) {
            this.aJm = displayMetrics;
        }

        @Override // com.bumptech.glide.load.b.b.i.c
        public final int pj() {
            return this.aJm.widthPixels;
        }

        @Override // com.bumptech.glide.load.b.b.i.c
        public final int pk() {
            return this.aJm.heightPixels;
        }
    }
}
