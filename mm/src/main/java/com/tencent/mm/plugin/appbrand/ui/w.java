package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;

public final class w extends ContextThemeWrapper {
    private Resources cDb;
    private LayoutInflater cDc;

    public w(Context context) {
        AppMethodBeat.i(48882);
        super.attachBaseContext(context);
        ep(context);
        AppMethodBeat.o(48882);
    }

    public w(Context context, int i2) {
        super(context, i2);
        AppMethodBeat.i(177764);
        ep(context);
        AppMethodBeat.o(177764);
    }

    private void ep(Context context) {
        AppMethodBeat.i(48884);
        this.cDb = new a(context.getResources(), com.tencent.mm.cc.a.b(context.getResources().getDisplayMetrics()));
        if (Build.VERSION.SDK_INT >= 21) {
            getTheme().getResources().getDisplayMetrics().setTo(this.cDb.getDisplayMetrics());
        }
        AppMethodBeat.o(48884);
    }

    @Override // android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final Object getSystemService(String str) {
        AppMethodBeat.i(48885);
        if (!"layout_inflater".equals(str)) {
            Object systemService = super.getSystemService(str);
            AppMethodBeat.o(48885);
            return systemService;
        } else if (this.cDc != null) {
            LayoutInflater layoutInflater = this.cDc;
            AppMethodBeat.o(48885);
            return layoutInflater;
        } else {
            LayoutInflater b2 = aa.b((LayoutInflater) super.getSystemService("layout_inflater"));
            this.cDc = b2;
            AppMethodBeat.o(48885);
            return b2;
        }
    }

    public final Resources getResources() {
        AppMethodBeat.i(48886);
        if (getAssets() == null || this.cDb == null) {
            Resources resources = super.getResources();
            AppMethodBeat.o(48886);
            return resources;
        }
        Resources resources2 = this.cDb;
        AppMethodBeat.o(48886);
        return resources2;
    }

    /* access modifiers changed from: package-private */
    public static final class a extends com.tencent.mm.plugin.appbrand.widget.a {
        private Configuration adG;
        private final Resources cDf;
        private DisplayMetrics cDg;

        a(Resources resources, DisplayMetrics displayMetrics) {
            super(resources);
            AppMethodBeat.i(48871);
            this.cDf = resources;
            this.cDg = displayMetrics;
            Configuration configuration = new Configuration(this.cDf.getConfiguration());
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            displayMetrics2.setTo(this.cDf.getDisplayMetrics());
            updateConfiguration(configuration, displayMetrics2);
            AppMethodBeat.o(48871);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a
        public final DisplayMetrics getDisplayMetrics() {
            AppMethodBeat.i(48872);
            if (this.cDg != null) {
                DisplayMetrics displayMetrics = this.cDg;
                AppMethodBeat.o(48872);
                return displayMetrics;
            }
            DisplayMetrics displayMetrics2 = super.getDisplayMetrics();
            AppMethodBeat.o(48872);
            return displayMetrics2;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a
        public final Configuration getConfiguration() {
            AppMethodBeat.i(48873);
            if (this.adG != null) {
                Configuration configuration = this.adG;
                AppMethodBeat.o(48873);
                return configuration;
            }
            Configuration configuration2 = super.getConfiguration();
            AppMethodBeat.o(48873);
            return configuration2;
        }

        private Drawable v(Drawable drawable) {
            AppMethodBeat.i(48874);
            if ((drawable instanceof BitmapDrawable) && this.cDg != null) {
                ((BitmapDrawable) drawable).setTargetDensity(this.cDg.densityDpi);
            }
            AppMethodBeat.o(48874);
            return drawable;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a, android.content.res.Resources
        public final Drawable getDrawable(int i2) {
            AppMethodBeat.i(48875);
            if (this.cDg != null) {
                Drawable drawableForDensity = getDrawableForDensity(i2, this.cDg.densityDpi);
                AppMethodBeat.o(48875);
                return drawableForDensity;
            }
            Drawable v = v(this.cDf.getDrawable(i2));
            AppMethodBeat.o(48875);
            return v;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a, android.content.res.Resources
        public final Drawable getDrawable(int i2, Resources.Theme theme) {
            AppMethodBeat.i(48876);
            try {
                if (this.cDg != null) {
                    Drawable drawableForDensity = getDrawableForDensity(i2, this.cDg.densityDpi, theme);
                    AppMethodBeat.o(48876);
                    return drawableForDensity;
                }
            } catch (NoSuchMethodError e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandUIScreenAdaptiveContextThemeWrapper", e2, "getDrawable(id, theme)", new Object[0]);
                if (theme == null) {
                    Drawable drawableForDensity2 = getDrawableForDensity(i2, this.cDg.densityDpi);
                    AppMethodBeat.o(48876);
                    return drawableForDensity2;
                }
            }
            Drawable v = v(this.cDf.getDrawable(i2, theme));
            AppMethodBeat.o(48876);
            return v;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a, android.content.res.Resources
        public final Drawable getDrawableForDensity(int i2, int i3) {
            AppMethodBeat.i(48877);
            if (i3 == 0 && this.cDg != null) {
                i3 = this.cDg.densityDpi;
            }
            Drawable drawableForDensity = this.cDf.getDrawableForDensity(i2, i3);
            AppMethodBeat.o(48877);
            return drawableForDensity;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a
        public final Drawable getDrawableForDensity(int i2, int i3, Resources.Theme theme) {
            AppMethodBeat.i(48878);
            if (i3 == 0 && this.cDg != null) {
                i3 = this.cDg.densityDpi;
            }
            Drawable drawableForDensity = this.cDf.getDrawableForDensity(i2, i3, theme);
            AppMethodBeat.o(48878);
            return drawableForDensity;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a, android.content.res.Resources
        public final int getDimensionPixelSize(int i2) {
            AppMethodBeat.i(48879);
            int zJ = zJ(i2);
            AppMethodBeat.o(48879);
            return zJ;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a, android.content.res.Resources
        public final int getDimensionPixelOffset(int i2) {
            AppMethodBeat.i(48880);
            int zI = zI(i2);
            AppMethodBeat.o(48880);
            return zI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a
        public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
            AppMethodBeat.i(48881);
            if (this.cDg != null) {
                this.cDg = com.tencent.mm.cc.a.b(displayMetrics);
                this.adG = new Configuration(configuration);
                this.adG.densityDpi = this.cDg.densityDpi;
                super.updateConfiguration(this.adG, this.cDg);
                this.cDf.updateConfiguration(configuration, displayMetrics);
                AppMethodBeat.o(48881);
                return;
            }
            super.updateConfiguration(configuration, displayMetrics);
            AppMethodBeat.o(48881);
        }
    }
}
