package org.xwalk.core;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;

class XWalkMixedResources extends Resources {
    private Resources mLibraryResource;

    private boolean isCalledInLibrary() {
        AppMethodBeat.i(154797);
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            if (className.startsWith("org.chromium") || className.startsWith("org.xwalk.core.internal")) {
                AppMethodBeat.o(154797);
                return true;
            } else if (className.startsWith("org.xwalk.core") && !className.endsWith("XWalkMixedResources")) {
                AppMethodBeat.o(154797);
                return false;
            }
        }
        AppMethodBeat.o(154797);
        return false;
    }

    XWalkMixedResources(Resources resources, Resources resources2) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        AppMethodBeat.i(154798);
        this.mLibraryResource = resources2;
        AppMethodBeat.o(154798);
    }

    @Override // android.content.res.Resources
    public CharSequence getText(int i2) {
        AppMethodBeat.i(154799);
        boolean isCalledInLibrary = isCalledInLibrary();
        if (isCalledInLibrary) {
            try {
                CharSequence text = this.mLibraryResource.getText(i2);
                AppMethodBeat.o(154799);
                return text;
            } catch (Resources.NotFoundException e2) {
                if (isCalledInLibrary) {
                    CharSequence text2 = super.getText(i2);
                    AppMethodBeat.o(154799);
                    return text2;
                }
                CharSequence text3 = this.mLibraryResource.getText(i2);
                AppMethodBeat.o(154799);
                return text3;
            }
        } else {
            CharSequence text4 = super.getText(i2);
            AppMethodBeat.o(154799);
            return text4;
        }
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i2) {
        AppMethodBeat.i(154800);
        boolean isCalledInLibrary = isCalledInLibrary();
        if (isCalledInLibrary) {
            try {
                XmlResourceParser layout = this.mLibraryResource.getLayout(i2);
                AppMethodBeat.o(154800);
                return layout;
            } catch (Resources.NotFoundException e2) {
                if (isCalledInLibrary) {
                    XmlResourceParser layout2 = super.getLayout(i2);
                    AppMethodBeat.o(154800);
                    return layout2;
                }
                XmlResourceParser layout3 = this.mLibraryResource.getLayout(i2);
                AppMethodBeat.o(154800);
                return layout3;
            }
        } else {
            XmlResourceParser layout4 = super.getLayout(i2);
            AppMethodBeat.o(154800);
            return layout4;
        }
    }

    @Override // android.content.res.Resources
    public void getValue(int i2, TypedValue typedValue, boolean z) {
        AppMethodBeat.i(154801);
        boolean isCalledInLibrary = isCalledInLibrary();
        if (isCalledInLibrary) {
            try {
                this.mLibraryResource.getValue(i2, typedValue, z);
                AppMethodBeat.o(154801);
            } catch (Resources.NotFoundException e2) {
                if (isCalledInLibrary) {
                    super.getValue(i2, typedValue, z);
                    AppMethodBeat.o(154801);
                    return;
                }
                this.mLibraryResource.getValue(i2, typedValue, z);
                AppMethodBeat.o(154801);
            }
        } else {
            super.getValue(i2, typedValue, z);
            AppMethodBeat.o(154801);
        }
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i2, int i3, TypedValue typedValue, boolean z) {
        AppMethodBeat.i(154802);
        boolean isCalledInLibrary = isCalledInLibrary();
        if (isCalledInLibrary) {
            try {
                this.mLibraryResource.getValueForDensity(i2, i3, typedValue, z);
                AppMethodBeat.o(154802);
            } catch (Resources.NotFoundException e2) {
                if (isCalledInLibrary) {
                    super.getValueForDensity(i2, i3, typedValue, z);
                    AppMethodBeat.o(154802);
                    return;
                }
                this.mLibraryResource.getValueForDensity(i2, i3, typedValue, z);
                AppMethodBeat.o(154802);
            }
        } else {
            super.getValueForDensity(i2, i3, typedValue, z);
            AppMethodBeat.o(154802);
        }
    }

    public int getIdentifier(String str, String str2, String str3) {
        AppMethodBeat.i(154803);
        if (isCalledInLibrary()) {
            int identifier = this.mLibraryResource.getIdentifier(str, str2, str3);
            if (identifier != 0) {
                AppMethodBeat.o(154803);
                return identifier;
            }
            int identifier2 = super.getIdentifier(str, str2, str3);
            AppMethodBeat.o(154803);
            return identifier2;
        }
        int identifier3 = super.getIdentifier(str, str2, str3);
        if (identifier3 != 0) {
            AppMethodBeat.o(154803);
            return identifier3;
        }
        int identifier4 = this.mLibraryResource.getIdentifier(str, str2, str3);
        AppMethodBeat.o(154803);
        return identifier4;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i2) {
        AppMethodBeat.i(154804);
        boolean isCalledInLibrary = isCalledInLibrary();
        if (isCalledInLibrary) {
            try {
                Drawable drawable = this.mLibraryResource.getDrawable(i2);
                AppMethodBeat.o(154804);
                return drawable;
            } catch (Resources.NotFoundException e2) {
                if (isCalledInLibrary) {
                    Drawable drawable2 = super.getDrawable(i2);
                    AppMethodBeat.o(154804);
                    return drawable2;
                }
                Drawable drawable3 = this.mLibraryResource.getDrawable(i2);
                AppMethodBeat.o(154804);
                return drawable3;
            }
        } else {
            Drawable drawable4 = super.getDrawable(i2);
            AppMethodBeat.o(154804);
            return drawable4;
        }
    }
}
