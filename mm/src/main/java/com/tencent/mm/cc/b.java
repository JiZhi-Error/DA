package com.tencent.mm.cc;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.vendor.Oppo;
import com.tencent.mm.svg.a.c;
import com.tencent.mm.svg.a.e;
import com.tencent.mm.ui.ao;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class b extends Resources {
    private static Method NDp = null;
    private static Method NDq = null;
    private h NDl;
    private f NDm;
    private boolean NDn;
    public a NDo;
    private Resources mResources;

    private b(Resources resources, h hVar, f fVar) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        AppMethodBeat.i(141213);
        this.NDl = hVar;
        if (resources instanceof b) {
            this.mResources = ((b) resources).mResources;
        } else {
            this.mResources = resources;
        }
        this.NDm = fVar;
        gvA();
        gvB();
        AppMethodBeat.o(141213);
    }

    private b(Resources resources, h hVar, f fVar, a aVar) {
        super(resources.getAssets(), aVar.getDisplayMetrics(), aVar.g(resources.getConfiguration()));
        AppMethodBeat.i(141214);
        this.NDo = aVar;
        this.NDl = hVar;
        if (resources instanceof b) {
            this.mResources = ((b) resources).mResources;
        } else {
            this.mResources = resources;
        }
        this.NDm = fVar;
        gvA();
        gvB();
        try {
            this.NDn = MMApplicationContext.getDefaultPreference().getBoolean("ShowStringName", false);
        } catch (Exception e2) {
            Log.e("MicroMsg.MMResources", e2.getMessage());
        }
        Log.i("MicroMsg.MMResources", "originalResources:%s mmresource:%s", resources, this);
        cr.aWI();
        AppMethodBeat.o(141214);
    }

    public final DisplayMetrics getDisplayMetrics() {
        AppMethodBeat.i(141215);
        if (this.NDo != null) {
            DisplayMetrics displayMetrics = this.NDo.getDisplayMetrics();
            AppMethodBeat.o(141215);
            return displayMetrics;
        }
        DisplayMetrics displayMetrics2 = this.mResources.getDisplayMetrics();
        AppMethodBeat.o(141215);
        return displayMetrics2;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(141216);
        Log.i("MicroMsg.MMResources", "dancy test locale %s, orientation %s, uimode:%s", configuration.locale, Integer.valueOf(configuration.orientation), Integer.valueOf(configuration.uiMode));
        if ((ao.awS() && MMApplicationContext.isMainProcess()) || !ao.awS()) {
            c.a(configuration, this.mResources);
            if (this.mResources != null) {
                this.mResources.getConfiguration().updateFrom(configuration);
            }
        }
        a aVar = this.NDo;
        DisplayMetrics displayMetrics = this.mResources.getDisplayMetrics();
        if (a.gvs()) {
            displayMetrics.density = aVar.aJm.density;
            displayMetrics.densityDpi = aVar.aJm.densityDpi;
            displayMetrics.scaledDensity = aVar.aJm.scaledDensity;
            aVar.aJm.setTo(displayMetrics);
        }
        Configuration configuration2 = new Configuration(getConfiguration());
        configuration2.fontScale += 0.1f;
        super.updateConfiguration(configuration2, getDisplayMetrics());
        Oppo._isUnDefaultFont = null;
        super.updateConfiguration(this.NDo.g(configuration), getDisplayMetrics());
        AppMethodBeat.o(141216);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d4, code lost:
        if (r0 == false) goto L_0x00f0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateConfiguration(android.content.res.Configuration r14, android.util.DisplayMetrics r15) {
        /*
        // Method dump skipped, instructions count: 894
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.cc.b.updateConfiguration(android.content.res.Configuration, android.util.DisplayMetrics):void");
    }

    public static Resources a(Resources resources, Context context) {
        AppMethodBeat.i(141218);
        Resources a2 = a(resources, context, false);
        AppMethodBeat.o(141218);
        return a2;
    }

    public static Resources a(Resources resources, Context context, boolean z) {
        AppMethodBeat.i(141219);
        h jq = h.jq(context);
        f fVar = new f();
        if (z) {
            b bVar = new b(resources, jq, fVar);
            AppMethodBeat.o(141219);
            return bVar;
        }
        b bVar2 = new b(resources, jq, fVar, new a(resources.getDisplayMetrics()));
        AppMethodBeat.o(141219);
        return bVar2;
    }

    public static Resources a(Resources resources, Context context, String str) {
        AppMethodBeat.i(141220);
        b bVar = new b(resources, h.cw(context, str), new f(), new a(resources.getDisplayMetrics()));
        AppMethodBeat.o(141220);
        return bVar;
    }

    private boolean gvz() {
        AppMethodBeat.i(141221);
        if (this.NDl == null || !h.gvz()) {
            AppMethodBeat.o(141221);
            return false;
        }
        AppMethodBeat.o(141221);
        return true;
    }

    @Override // android.content.res.Resources
    public final CharSequence getText(int i2) {
        CharSequence an;
        AppMethodBeat.i(141222);
        if (this.NDn) {
            try {
                String translate = WeChatBrands.Wordings.translate(this.mResources.getResourceEntryName(i2));
                AppMethodBeat.o(141222);
                return translate;
            } catch (Exception e2) {
                AppMethodBeat.o(141222);
                return "";
            }
        } else if (!gvz() || (an = h.an(h.getString(i2))) == null) {
            CharSequence an2 = h.an(this.mResources.getString(i2));
            if (an2 != null) {
                String translate2 = WeChatBrands.Wordings.translate(an2.toString());
                AppMethodBeat.o(141222);
                return translate2;
            }
            String translate3 = WeChatBrands.Wordings.translate(this.mResources.getString(i2));
            AppMethodBeat.o(141222);
            return translate3;
        } else {
            String translate4 = WeChatBrands.Wordings.translate(an.toString());
            AppMethodBeat.o(141222);
            return translate4;
        }
    }

    public final CharSequence getText(int i2, CharSequence charSequence) {
        CharSequence an;
        AppMethodBeat.i(141223);
        if (this.NDn) {
            try {
                String translate = WeChatBrands.Wordings.translate(this.mResources.getResourceEntryName(i2));
                AppMethodBeat.o(141223);
                return translate;
            } catch (Exception e2) {
                AppMethodBeat.o(141223);
                return "";
            }
        } else if (!gvz() || (an = h.an(h.getString(i2))) == null) {
            CharSequence an2 = h.an(this.mResources.getString(i2));
            if (an2 != null) {
                String translate2 = WeChatBrands.Wordings.translate(an2.toString());
                AppMethodBeat.o(141223);
                return translate2;
            }
            String translate3 = WeChatBrands.Wordings.translate(this.mResources.getString(i2));
            AppMethodBeat.o(141223);
            return translate3;
        } else {
            String translate4 = WeChatBrands.Wordings.translate(an.toString());
            AppMethodBeat.o(141223);
            return translate4;
        }
    }

    @Override // android.content.res.Resources
    public final String getString(int i2) {
        String string;
        AppMethodBeat.i(141224);
        if (this.NDn) {
            try {
                String translate = WeChatBrands.Wordings.translate(this.mResources.getResourceEntryName(i2));
                AppMethodBeat.o(141224);
                return translate;
            } catch (Exception e2) {
                AppMethodBeat.o(141224);
                return "";
            }
        } else if (!gvz() || (string = h.getString(i2)) == null) {
            try {
                CharSequence an = h.an(this.mResources.getString(i2));
                if (an != null) {
                    String translate2 = WeChatBrands.Wordings.translate(an.toString());
                    AppMethodBeat.o(141224);
                    return translate2;
                }
                String translate3 = WeChatBrands.Wordings.translate(this.mResources.getString(i2));
                AppMethodBeat.o(141224);
                return translate3;
            } catch (Exception e3) {
                AppMethodBeat.o(141224);
                return "";
            }
        } else {
            String translate4 = WeChatBrands.Wordings.translate(h.an(string.toString()).toString());
            AppMethodBeat.o(141224);
            return translate4;
        }
    }

    @Override // android.content.res.Resources
    public final String getQuantityString(int i2, int i3) {
        String quantityString;
        AppMethodBeat.i(141225);
        if (this.NDn) {
            try {
                String translate = WeChatBrands.Wordings.translate(this.mResources.getResourceEntryName(i2));
                AppMethodBeat.o(141225);
                return translate;
            } catch (Exception e2) {
                AppMethodBeat.o(141225);
                return "";
            }
        } else if (!gvz() || (quantityString = h.getQuantityString(i2, i3)) == null) {
            String translate2 = WeChatBrands.Wordings.translate(this.mResources.getQuantityString(i2, i3));
            AppMethodBeat.o(141225);
            return translate2;
        } else {
            String translate3 = WeChatBrands.Wordings.translate(quantityString.toString());
            AppMethodBeat.o(141225);
            return translate3;
        }
    }

    @Override // android.content.res.Resources
    public final String getQuantityString(int i2, int i3, Object... objArr) {
        String quantityString;
        AppMethodBeat.i(141226);
        if (this.NDn) {
            try {
                String translate = WeChatBrands.Wordings.translate(this.mResources.getResourceEntryName(i2));
                AppMethodBeat.o(141226);
                return translate;
            } catch (Exception e2) {
                AppMethodBeat.o(141226);
                return "";
            }
        } else if (!gvz() || (quantityString = h.getQuantityString(i2, i3, objArr)) == null) {
            String translate2 = WeChatBrands.Wordings.translate(this.mResources.getQuantityString(i2, i3, objArr));
            AppMethodBeat.o(141226);
            return translate2;
        } else {
            String charSequence = quantityString.toString();
            AppMethodBeat.o(141226);
            return charSequence;
        }
    }

    @Override // android.content.res.Resources
    public final CharSequence getQuantityText(int i2, int i3) {
        String quantityString;
        AppMethodBeat.i(141227);
        if (this.NDn) {
            try {
                String translate = WeChatBrands.Wordings.translate(this.mResources.getResourceEntryName(i2));
                AppMethodBeat.o(141227);
                return translate;
            } catch (Exception e2) {
                AppMethodBeat.o(141227);
                return "";
            }
        } else if (!gvz() || (quantityString = h.getQuantityString(i2, i3)) == null) {
            String translate2 = WeChatBrands.Wordings.translate(this.mResources.getQuantityString(i2, i3));
            AppMethodBeat.o(141227);
            return translate2;
        } else {
            String translate3 = WeChatBrands.Wordings.translate(quantityString.toString());
            AppMethodBeat.o(141227);
            return translate3;
        }
    }

    @Override // android.content.res.Resources
    public final String[] getStringArray(int i2) {
        AppMethodBeat.i(141228);
        String[] strArr = null;
        if (gvz()) {
            strArr = h.getStringArray(i2);
        }
        if (strArr == null && ((strArr = super.getStringArray(i2)) == null || strArr.length == 0)) {
            AppMethodBeat.o(141228);
            return strArr;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(WeChatBrands.Wordings.translate(str));
        }
        String[] strArr2 = (String[]) arrayList.toArray(new String[0]);
        AppMethodBeat.o(141228);
        return strArr2;
    }

    @Override // android.content.res.Resources
    public final CharSequence[] getTextArray(int i2) {
        AppMethodBeat.i(141229);
        String[] stringArray = getStringArray(i2);
        if (stringArray != null) {
            AppMethodBeat.o(141229);
            return stringArray;
        }
        CharSequence[] textArray = super.getTextArray(i2);
        AppMethodBeat.o(141229);
        return textArray;
    }

    @Override // android.content.res.Resources
    public final TypedArray obtainTypedArray(int i2) {
        AppMethodBeat.i(141230);
        TypedArray obtainTypedArray = this.mResources.obtainTypedArray(i2);
        AppMethodBeat.o(141230);
        return obtainTypedArray;
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawable(int i2) {
        Drawable h2;
        AppMethodBeat.i(141231);
        if (i2 == 0 || (h2 = this.NDm.h(this.mResources, i2)) == null) {
            Drawable d2 = d(super.getDrawable(i2), i2);
            AppMethodBeat.o(141231);
            return d2;
        }
        AppMethodBeat.o(141231);
        return h2;
    }

    @Override // android.content.res.Resources
    @TargetApi(21)
    public final Drawable getDrawable(int i2, Resources.Theme theme) {
        Drawable h2;
        AppMethodBeat.i(141232);
        if (i2 == 0 || (h2 = this.NDm.h(this.mResources, i2)) == null) {
            Drawable d2 = d(super.getDrawable(i2, theme), i2);
            AppMethodBeat.o(141232);
            return d2;
        }
        AppMethodBeat.o(141232);
        return h2;
    }

    @Override // android.content.res.Resources
    public final Drawable getDrawableForDensity(int i2, int i3) {
        Drawable h2;
        AppMethodBeat.i(141233);
        if (i2 == 0 || (h2 = this.NDm.h(this.mResources, i2)) == null) {
            Drawable d2 = d(super.getDrawableForDensity(i2, i3), i2);
            AppMethodBeat.o(141233);
            return d2;
        }
        AppMethodBeat.o(141233);
        return h2;
    }

    @TargetApi(22)
    public final Drawable getDrawableForDensity(int i2, int i3, Resources.Theme theme) {
        Drawable h2;
        AppMethodBeat.i(141234);
        if (i2 == 0 || (h2 = this.NDm.h(this.mResources, i2)) == null) {
            Drawable d2 = d(super.getDrawableForDensity(i2, i3, theme), i2);
            AppMethodBeat.o(141234);
            return d2;
        }
        AppMethodBeat.o(141234);
        return h2;
    }

    private Drawable d(Drawable drawable, int i2) {
        AppMethodBeat.i(141235);
        if (drawable == null) {
            Log.printInfoStack("MicroMsg.MMResources", "Notice!!! drawable == null!!!", new Object[0]);
            try {
                if (this.NDm.oZU.j(this, i2)) {
                    Log.e("MicroMsg.MMResources", "resources name = %s, this resource %s", getResourceName(i2), this);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.MMResources", e2, "WTF", new Object[0]);
            }
            drawable = new c(new Picture(), 0);
        }
        AppMethodBeat.o(141235);
        return drawable;
    }

    private static void gvA() {
        Field field = null;
        AppMethodBeat.i(141236);
        try {
            Class<?> cls = Class.forName("android.content.res.MiuiResources");
            if (cls != null) {
                Log.i("MicroMsg.MMResources", "sMiuiThemeEnabled false");
                field = cls.getDeclaredField("sMiuiThemeEnabled");
                if (field != null) {
                    field.setAccessible(true);
                    field.set(null, Boolean.FALSE);
                    AppMethodBeat.o(141236);
                    return;
                }
            }
            Log.e("MicroMsg.MMResources", "some thing wrong. %s %s", cls, field);
            AppMethodBeat.o(141236);
        } catch (ClassNotFoundException e2) {
            Log.i("MicroMsg.MMResources", "sMiuiThemeEnabled ClassNotFoundException");
            AppMethodBeat.o(141236);
        } catch (NoSuchFieldException e3) {
            Log.i("MicroMsg.MMResources", "sMiuiThemeEnabled NoSuchFieldException");
            AppMethodBeat.o(141236);
        } catch (IllegalAccessException e4) {
            Log.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalAccessException");
            AppMethodBeat.o(141236);
        } catch (IllegalArgumentException e5) {
            Log.i("MicroMsg.MMResources", "sMiuiThemeEnabled IllegalArgumentException");
            AppMethodBeat.o(141236);
        }
    }

    public static class a<E> extends ArrayList<E> {
        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.util.ArrayList
        public final boolean add(E e2) {
            AppMethodBeat.i(141211);
            Log.i("InterceptArrayList", "InterceptArrayList.add");
            AppMethodBeat.o(141211);
            return true;
        }

        @Override // java.util.List, java.util.AbstractList, java.util.ArrayList
        public final void add(int i2, E e2) {
            AppMethodBeat.i(141212);
            Log.i("InterceptArrayList", "InterceptArrayList.add index object");
            AppMethodBeat.o(141212);
        }
    }

    private void gvB() {
        AppMethodBeat.i(141237);
        com.tencent.mm.compatible.loader.c cVar = new com.tencent.mm.compatible.loader.c(getAssets(), "mThemeCookies", null);
        try {
            if (cVar.apg()) {
                cVar.set(new a());
            }
            AppMethodBeat.o(141237);
        } catch (NoSuchFieldException e2) {
            Log.printErrStackTrace("MicroMsg.MMResources", e2, "", new Object[0]);
            AppMethodBeat.o(141237);
        } catch (IllegalAccessException e3) {
            Log.printErrStackTrace("MicroMsg.MMResources", e3, "", new Object[0]);
            AppMethodBeat.o(141237);
        } catch (IllegalArgumentException e4) {
            Log.printErrStackTrace("MicroMsg.MMResources", e4, "", new Object[0]);
            AppMethodBeat.o(141237);
        }
    }

    public static Drawable f(Resources resources, int i2) {
        AppMethodBeat.i(141238);
        Drawable f2 = e.f(resources, i2);
        AppMethodBeat.o(141238);
        return f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r1v12, types: [android.graphics.drawable.Drawable] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.drawable.Drawable g(android.content.res.Resources r9, int r10) {
        /*
        // Method dump skipped, instructions count: 398
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.cc.b.g(android.content.res.Resources, int):android.graphics.drawable.Drawable");
    }
}
