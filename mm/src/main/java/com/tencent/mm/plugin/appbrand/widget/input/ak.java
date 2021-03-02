package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ce.e;
import com.tencent.mm.plugin.appbrand.app.j;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class ak extends com.tencent.mm.plugin.appbrand.widget.input.panel.c {
    private static final int ovy = MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.is);
    private e ovx = null;

    ak() {
    }

    @Override // com.tencent.mm.plugin.appbrand.widget.input.panel.c
    public final e cbY() {
        AppMethodBeat.i(49919);
        if (this.ovx == null) {
            this.ovx = new a();
        }
        e eVar = this.ovx;
        AppMethodBeat.o(49919);
        return eVar;
    }

    static final class c extends ContextWrapper {
        private Resources mResources;

        public c(Context context) {
            super(context);
        }

        public final Resources getResources() {
            AppMethodBeat.i(49917);
            if (this.mResources == null || !(this.mResources instanceof d)) {
                Resources resources = super.getResources();
                this.mResources = new d(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
                Resources resources2 = this.mResources;
                AppMethodBeat.o(49917);
                return resources2;
            }
            Resources resources3 = this.mResources;
            AppMethodBeat.o(49917);
            return resources3;
        }
    }

    static final class d extends Resources {
        d(AssetManager assetManager, DisplayMetrics displayMetrics, Configuration configuration) {
            super(assetManager, displayMetrics, configuration);
        }

        @Override // android.content.res.Resources
        public final String[] getStringArray(int i2) {
            AppMethodBeat.i(49918);
            if (R.array.a3 == i2) {
                String[] strArr = new String[0];
                AppMethodBeat.o(49918);
                return strArr;
            } else if (R.array.a4 == i2) {
                String[] strArr2 = new String[0];
                AppMethodBeat.o(49918);
                return strArr2;
            } else {
                String[] stringArray = super.getStringArray(i2);
                AppMethodBeat.o(49918);
                return stringArray;
            }
        }
    }

    static final class a extends e {
        private String[] ovz;

        static {
            AppMethodBeat.i(49910);
            j.UJ("com.tencent.mm.plugin.emoji.PluginEmoji");
            AppMethodBeat.o(49910);
        }

        a() {
            super(new c(MMApplicationContext.getContext()));
            AppMethodBeat.i(49905);
            this.ovz = null;
            this.ovz = MMApplicationContext.getContext().getResources().getStringArray(R.array.a5);
            AppMethodBeat.o(49905);
        }

        @Override // com.tencent.mm.ce.e
        public final int cbZ() {
            return 0;
        }

        @Override // com.tencent.mm.ce.e
        public final int cca() {
            if (this.ovz != null) {
                return this.ovz.length;
            }
            return 0;
        }

        @Override // com.tencent.mm.ce.e
        public final Drawable Al(int i2) {
            AppMethodBeat.i(49906);
            f.cbc();
            b bVar = new b(Am(i2), ak.ovy, (byte) 0);
            AppMethodBeat.o(49906);
            return bVar;
        }

        @Override // com.tencent.mm.ce.e
        public final String Am(int i2) {
            AppMethodBeat.i(49907);
            if (this.ovz == null || i2 < 0 || i2 > this.ovz.length - 1) {
                AppMethodBeat.o(49907);
                return "";
            }
            String[] split = this.ovz[i2].split(" ");
            char[] chars = Character.toChars(Integer.decode(split[0]).intValue());
            String sb = new StringBuilder().append(chars).append(Character.toChars(Integer.decode(split[1]).intValue())).toString();
            AppMethodBeat.o(49907);
            return sb;
        }

        @Override // com.tencent.mm.ce.e
        public final String An(int i2) {
            AppMethodBeat.i(49909);
            String Am = Am(i2);
            AppMethodBeat.o(49909);
            return Am;
        }
    }

    static {
        AppMethodBeat.i(49920);
        AppMethodBeat.o(49920);
    }

    static final class b extends Drawable {
        private final TextPaint Ol;
        private final int mSize;
        private final String mText;
        private Rect ovA;

        /* synthetic */ b(String str, int i2, byte b2) {
            this(str, i2);
        }

        private b(String str, int i2) {
            AppMethodBeat.i(49911);
            this.mText = str;
            this.mSize = i2;
            this.Ol = new TextPaint();
            this.Ol.setAntiAlias(true);
            this.Ol.setTextAlign(Paint.Align.CENTER);
            this.Ol.setTextSize((float) this.mSize);
            this.ovA = new Rect();
            this.Ol.getTextBounds(this.mText, 0, this.mText.length(), this.ovA);
            AppMethodBeat.o(49911);
        }

        public final int getIntrinsicWidth() {
            AppMethodBeat.i(49912);
            int width = this.ovA.width();
            AppMethodBeat.o(49912);
            return width;
        }

        public final int getIntrinsicHeight() {
            AppMethodBeat.i(49913);
            int height = this.ovA.height();
            AppMethodBeat.o(49913);
            return height;
        }

        public final void draw(Canvas canvas) {
            AppMethodBeat.i(49914);
            canvas.drawText(this.mText, (float) (getBounds().width() / 2), ((float) (getBounds().height() / 2)) - ((this.Ol.descent() + this.Ol.ascent()) / 2.0f), this.Ol);
            AppMethodBeat.o(49914);
        }

        public final void setAlpha(int i2) {
            AppMethodBeat.i(49915);
            this.Ol.setAlpha(i2);
            AppMethodBeat.o(49915);
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            AppMethodBeat.i(49916);
            this.Ol.setColorFilter(colorFilter);
            AppMethodBeat.o(49916);
        }

        public final int getOpacity() {
            return -3;
        }
    }
}
