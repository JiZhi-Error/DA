package com.tencent.luggage.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a extends ContextThemeWrapper {
    private static final b cDd = new b() {
        /* class com.tencent.luggage.g.a.AnonymousClass1 */

        @Override // com.tencent.luggage.g.a.b
        public final DisplayMetrics a(DisplayMetrics displayMetrics, Configuration configuration) {
            AppMethodBeat.i(169462);
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            displayMetrics2.setTo(displayMetrics);
            AppMethodBeat.o(169462);
            return displayMetrics2;
        }
    };
    private Resources cDb;
    private LayoutInflater cDc;
    private final b cDe;

    public interface b {
        DisplayMetrics a(DisplayMetrics displayMetrics, Configuration configuration);
    }

    static /* synthetic */ DisplayMetrics a(a aVar, DisplayMetrics displayMetrics, Configuration configuration) {
        AppMethodBeat.i(169478);
        DisplayMetrics a2 = aVar.a(displayMetrics, configuration);
        AppMethodBeat.o(169478);
        return a2;
    }

    static {
        AppMethodBeat.i(169479);
        AppMethodBeat.o(169479);
    }

    public a(Context context, b bVar) {
        AppMethodBeat.i(169474);
        super.attachBaseContext(context);
        this.cDe = bVar == null ? cDd : bVar;
        AppMethodBeat.o(169474);
    }

    @Override // android.content.Context, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final Object getSystemService(String str) {
        AppMethodBeat.i(169475);
        if (!"layout_inflater".equals(str)) {
            Object systemService = super.getSystemService(str);
            AppMethodBeat.o(169475);
            return systemService;
        } else if (this.cDc != null) {
            LayoutInflater layoutInflater = this.cDc;
            AppMethodBeat.o(169475);
            return layoutInflater;
        } else {
            LayoutInflater layoutInflater2 = (LayoutInflater) super.getSystemService("layout_inflater");
            this.cDc = layoutInflater2;
            AppMethodBeat.o(169475);
            return layoutInflater2;
        }
    }

    public final Resources getResources() {
        AppMethodBeat.i(169476);
        if (getAssets() != null) {
            if (this.cDb == null) {
                Resources resources = super.getResources();
                this.cDb = new C0165a(resources, a(resources.getDisplayMetrics(), resources.getConfiguration()));
            }
            Resources resources2 = this.cDb;
            AppMethodBeat.o(169476);
            return resources2;
        }
        Resources resources3 = super.getResources();
        AppMethodBeat.o(169476);
        return resources3;
    }

    private DisplayMetrics a(DisplayMetrics displayMetrics, Configuration configuration) {
        AppMethodBeat.i(169477);
        DisplayMetrics a2 = this.cDe.a(displayMetrics, configuration);
        AppMethodBeat.o(169477);
        return a2;
    }

    /* renamed from: com.tencent.luggage.g.a$a  reason: collision with other inner class name */
    final class C0165a extends com.tencent.mm.plugin.appbrand.widget.a {
        private Configuration adG;
        private final Resources cDf;
        private DisplayMetrics cDg;

        C0165a(Resources resources, DisplayMetrics displayMetrics) {
            super(resources);
            AppMethodBeat.i(169463);
            this.cDf = resources;
            this.cDg = displayMetrics;
            Configuration configuration = new Configuration(this.cDf.getConfiguration());
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            displayMetrics2.setTo(this.cDf.getDisplayMetrics());
            updateConfiguration(configuration, displayMetrics2);
            AppMethodBeat.o(169463);
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a
        public final DisplayMetrics getDisplayMetrics() {
            AppMethodBeat.i(169464);
            if (this.cDg != null) {
                DisplayMetrics displayMetrics = this.cDg;
                AppMethodBeat.o(169464);
                return displayMetrics;
            }
            DisplayMetrics displayMetrics2 = super.getDisplayMetrics();
            AppMethodBeat.o(169464);
            return displayMetrics2;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a
        public final Configuration getConfiguration() {
            AppMethodBeat.i(169465);
            if (this.adG != null) {
                Configuration configuration = this.adG;
                AppMethodBeat.o(169465);
                return configuration;
            }
            Configuration configuration2 = super.getConfiguration();
            AppMethodBeat.o(169465);
            return configuration2;
        }

        private Drawable v(Drawable drawable) {
            AppMethodBeat.i(169466);
            if ((drawable instanceof BitmapDrawable) && this.cDg != null) {
                ((BitmapDrawable) drawable).setTargetDensity(this.cDg.densityDpi);
            }
            AppMethodBeat.o(169466);
            return drawable;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a, android.content.res.Resources
        public final Drawable getDrawable(int i2) {
            AppMethodBeat.i(169467);
            if (this.cDg != null) {
                Drawable drawableForDensity = getDrawableForDensity(i2, this.cDg.densityDpi);
                AppMethodBeat.o(169467);
                return drawableForDensity;
            }
            Drawable v = v(this.cDf.getDrawable(i2));
            AppMethodBeat.o(169467);
            return v;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a, android.content.res.Resources
        @TargetApi(21)
        public final Drawable getDrawable(int i2, Resources.Theme theme) {
            AppMethodBeat.i(169468);
            if (this.cDg != null) {
                Drawable drawableForDensity = getDrawableForDensity(i2, this.cDg.densityDpi, theme);
                AppMethodBeat.o(169468);
                return drawableForDensity;
            }
            Drawable v = v(this.cDf.getDrawable(i2, theme));
            AppMethodBeat.o(169468);
            return v;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a, android.content.res.Resources
        @TargetApi(21)
        public final Drawable getDrawableForDensity(int i2, int i3) {
            AppMethodBeat.i(169469);
            if (i3 == 0 && this.cDg != null) {
                i3 = this.cDg.densityDpi;
            }
            Drawable drawableForDensity = this.cDf.getDrawableForDensity(i2, i3);
            AppMethodBeat.o(169469);
            return drawableForDensity;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a
        @TargetApi(21)
        public final Drawable getDrawableForDensity(int i2, int i3, Resources.Theme theme) {
            AppMethodBeat.i(169470);
            if (i3 == 0 && this.cDg != null) {
                i3 = this.cDg.densityDpi;
            }
            Drawable drawableForDensity = this.cDf.getDrawableForDensity(i2, i3, theme);
            AppMethodBeat.o(169470);
            return drawableForDensity;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a, android.content.res.Resources
        public final int getDimensionPixelOffset(int i2) {
            AppMethodBeat.i(169471);
            int zI = zI(i2);
            AppMethodBeat.o(169471);
            return zI;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a, android.content.res.Resources
        public final int getDimensionPixelSize(int i2) {
            AppMethodBeat.i(169472);
            int zJ = zJ(i2);
            AppMethodBeat.o(169472);
            return zJ;
        }

        @Override // com.tencent.mm.plugin.appbrand.widget.a
        public final void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
            AppMethodBeat.i(169473);
            if (this.cDg != null) {
                this.cDg = a.a(a.this, displayMetrics, configuration);
                this.adG = new Configuration(configuration);
                this.adG.densityDpi = this.cDg.densityDpi;
                super.updateConfiguration(this.adG, this.cDg);
                this.cDf.updateConfiguration(configuration, displayMetrics);
                AppMethodBeat.o(169473);
                return;
            }
            super.updateConfiguration(configuration, displayMetrics);
            AppMethodBeat.o(169473);
        }
    }
}
