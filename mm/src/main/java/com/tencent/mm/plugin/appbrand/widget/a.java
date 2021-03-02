package com.tencent.mm.plugin.appbrand.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;

public class a extends Resources {
    private final Resources mResources;

    public a(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        AppMethodBeat.i(131407);
        this.mResources = resources;
        AppMethodBeat.o(131407);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2) {
        AppMethodBeat.i(131408);
        CharSequence text = this.mResources.getText(i2);
        AppMethodBeat.o(131408);
        return text;
    }

    @Override // android.content.res.Resources
    public CharSequence getQuantityText(int i2, int i3) {
        AppMethodBeat.i(131409);
        CharSequence quantityText = this.mResources.getQuantityText(i2, i3);
        AppMethodBeat.o(131409);
        return quantityText;
    }

    @Override // android.content.res.Resources
    public String getString(int i2) {
        AppMethodBeat.i(131410);
        String string = this.mResources.getString(i2);
        AppMethodBeat.o(131410);
        return string;
    }

    @Override // android.content.res.Resources
    public String getString(int i2, Object... objArr) {
        AppMethodBeat.i(131411);
        String string = this.mResources.getString(i2, objArr);
        AppMethodBeat.o(131411);
        return string;
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3, Object... objArr) {
        AppMethodBeat.i(131412);
        String quantityString = this.mResources.getQuantityString(i2, i3, objArr);
        AppMethodBeat.o(131412);
        return quantityString;
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i2, int i3) {
        AppMethodBeat.i(131413);
        String quantityString = this.mResources.getQuantityString(i2, i3);
        AppMethodBeat.o(131413);
        return quantityString;
    }

    public CharSequence getText(int i2, CharSequence charSequence) {
        AppMethodBeat.i(131414);
        CharSequence text = this.mResources.getText(i2, charSequence);
        AppMethodBeat.o(131414);
        return text;
    }

    @Override // android.content.res.Resources
    public CharSequence[] getTextArray(int i2) {
        AppMethodBeat.i(131415);
        CharSequence[] textArray = this.mResources.getTextArray(i2);
        AppMethodBeat.o(131415);
        return textArray;
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i2) {
        AppMethodBeat.i(131416);
        String[] stringArray = this.mResources.getStringArray(i2);
        AppMethodBeat.o(131416);
        return stringArray;
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i2) {
        AppMethodBeat.i(131417);
        int[] intArray = this.mResources.getIntArray(i2);
        AppMethodBeat.o(131417);
        return intArray;
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i2) {
        AppMethodBeat.i(131418);
        TypedArray obtainTypedArray = this.mResources.obtainTypedArray(i2);
        AppMethodBeat.o(131418);
        return obtainTypedArray;
    }

    @Override // android.content.res.Resources
    public float getDimension(int i2) {
        AppMethodBeat.i(131419);
        float dimension = this.mResources.getDimension(i2);
        AppMethodBeat.o(131419);
        return dimension;
    }

    public final int zI(int i2) {
        AppMethodBeat.i(131420);
        int dimensionPixelOffset = super.getDimensionPixelOffset(i2);
        AppMethodBeat.o(131420);
        return dimensionPixelOffset;
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i2) {
        AppMethodBeat.i(131421);
        int dimensionPixelOffset = this.mResources.getDimensionPixelOffset(i2);
        AppMethodBeat.o(131421);
        return dimensionPixelOffset;
    }

    public final int zJ(int i2) {
        AppMethodBeat.i(131422);
        int dimensionPixelSize = super.getDimensionPixelSize(i2);
        AppMethodBeat.o(131422);
        return dimensionPixelSize;
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i2) {
        AppMethodBeat.i(131423);
        int dimensionPixelSize = this.mResources.getDimensionPixelSize(i2);
        AppMethodBeat.o(131423);
        return dimensionPixelSize;
    }

    public float getFraction(int i2, int i3, int i4) {
        AppMethodBeat.i(131424);
        float fraction = this.mResources.getFraction(i2, i3, i4);
        AppMethodBeat.o(131424);
        return fraction;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) {
        AppMethodBeat.i(131425);
        Drawable drawable = this.mResources.getDrawable(i2);
        AppMethodBeat.o(131425);
        return drawable;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2, Resources.Theme theme) {
        AppMethodBeat.i(131426);
        Drawable drawable = this.mResources.getDrawable(i2, theme);
        AppMethodBeat.o(131426);
        return drawable;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i2, int i3) {
        AppMethodBeat.i(131427);
        Drawable drawableForDensity = this.mResources.getDrawableForDensity(i2, i3);
        AppMethodBeat.o(131427);
        return drawableForDensity;
    }

    public Drawable getDrawableForDensity(int i2, int i3, Resources.Theme theme) {
        AppMethodBeat.i(131428);
        Drawable drawableForDensity = this.mResources.getDrawableForDensity(i2, i3, theme);
        AppMethodBeat.o(131428);
        return drawableForDensity;
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i2) {
        AppMethodBeat.i(131429);
        Movie movie = this.mResources.getMovie(i2);
        AppMethodBeat.o(131429);
        return movie;
    }

    @Override // android.content.res.Resources
    public int getColor(int i2, Resources.Theme theme) {
        AppMethodBeat.i(177586);
        int color = this.mResources.getColor(i2, theme);
        AppMethodBeat.o(177586);
        return color;
    }

    @Override // android.content.res.Resources
    public int getColor(int i2) {
        AppMethodBeat.i(131430);
        int color = this.mResources.getColor(i2);
        AppMethodBeat.o(131430);
        return color;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i2, Resources.Theme theme) {
        AppMethodBeat.i(177587);
        ColorStateList colorStateList = this.mResources.getColorStateList(i2, theme);
        AppMethodBeat.o(177587);
        return colorStateList;
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i2) {
        AppMethodBeat.i(131431);
        ColorStateList colorStateList = this.mResources.getColorStateList(i2);
        AppMethodBeat.o(131431);
        return colorStateList;
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i2) {
        AppMethodBeat.i(131432);
        boolean z = this.mResources.getBoolean(i2);
        AppMethodBeat.o(131432);
        return z;
    }

    @Override // android.content.res.Resources
    public int getInteger(int i2) {
        AppMethodBeat.i(131433);
        int integer = this.mResources.getInteger(i2);
        AppMethodBeat.o(131433);
        return integer;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i2) {
        AppMethodBeat.i(131434);
        XmlResourceParser layout = this.mResources.getLayout(i2);
        AppMethodBeat.o(131434);
        return layout;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i2) {
        AppMethodBeat.i(131435);
        XmlResourceParser animation = this.mResources.getAnimation(i2);
        AppMethodBeat.o(131435);
        return animation;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i2) {
        AppMethodBeat.i(131436);
        XmlResourceParser xml = this.mResources.getXml(i2);
        AppMethodBeat.o(131436);
        return xml;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2) {
        AppMethodBeat.i(131437);
        InputStream openRawResource = this.mResources.openRawResource(i2);
        AppMethodBeat.o(131437);
        return openRawResource;
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i2, TypedValue typedValue) {
        AppMethodBeat.i(131438);
        InputStream openRawResource = this.mResources.openRawResource(i2, typedValue);
        AppMethodBeat.o(131438);
        return openRawResource;
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i2) {
        AppMethodBeat.i(131439);
        AssetFileDescriptor openRawResourceFd = this.mResources.openRawResourceFd(i2);
        AppMethodBeat.o(131439);
        return openRawResourceFd;
    }

    @Override // android.content.res.Resources
    public void getValue(int i2, TypedValue typedValue, boolean z) {
        AppMethodBeat.i(131440);
        this.mResources.getValue(i2, typedValue, z);
        AppMethodBeat.o(131440);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z) {
        AppMethodBeat.i(131441);
        this.mResources.getValueForDensity(i2, i3, typedValue, z);
        AppMethodBeat.o(131441);
    }

    @Override // android.content.res.Resources
    public void getValue(String str, TypedValue typedValue, boolean z) {
        AppMethodBeat.i(131442);
        this.mResources.getValue(str, typedValue, z);
        AppMethodBeat.o(131442);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        AppMethodBeat.i(131443);
        TypedArray obtainAttributes = this.mResources.obtainAttributes(attributeSet, iArr);
        AppMethodBeat.o(131443);
        return obtainAttributes;
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        AppMethodBeat.i(131444);
        super.updateConfiguration(configuration, displayMetrics);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, displayMetrics);
        }
        AppMethodBeat.o(131444);
    }

    public DisplayMetrics getDisplayMetrics() {
        AppMethodBeat.i(131445);
        DisplayMetrics displayMetrics = this.mResources.getDisplayMetrics();
        AppMethodBeat.o(131445);
        return displayMetrics;
    }

    public Configuration getConfiguration() {
        AppMethodBeat.i(131446);
        Configuration configuration = this.mResources.getConfiguration();
        AppMethodBeat.o(131446);
        return configuration;
    }

    public int getIdentifier(String str, String str2, String str3) {
        AppMethodBeat.i(131447);
        int identifier = this.mResources.getIdentifier(str, str2, str3);
        AppMethodBeat.o(131447);
        return identifier;
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i2) {
        AppMethodBeat.i(131448);
        String resourceName = this.mResources.getResourceName(i2);
        AppMethodBeat.o(131448);
        return resourceName;
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i2) {
        AppMethodBeat.i(131449);
        String resourcePackageName = this.mResources.getResourcePackageName(i2);
        AppMethodBeat.o(131449);
        return resourcePackageName;
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i2) {
        AppMethodBeat.i(131450);
        String resourceTypeName = this.mResources.getResourceTypeName(i2);
        AppMethodBeat.o(131450);
        return resourceTypeName;
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i2) {
        AppMethodBeat.i(131451);
        String resourceEntryName = this.mResources.getResourceEntryName(i2);
        AppMethodBeat.o(131451);
        return resourceEntryName;
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        AppMethodBeat.i(131452);
        this.mResources.parseBundleExtras(xmlResourceParser, bundle);
        AppMethodBeat.o(131452);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        AppMethodBeat.i(131453);
        this.mResources.parseBundleExtra(str, attributeSet, bundle);
        AppMethodBeat.o(131453);
    }
}
