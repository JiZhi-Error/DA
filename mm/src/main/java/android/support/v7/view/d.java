package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import com.tencent.mm.R;

public final class d extends ContextWrapper {
    public int adF;
    private Configuration adG;
    private LayoutInflater mInflater;
    private Resources mResources;
    private Resources.Theme mTheme;

    public d() {
        super(null);
    }

    public d(Context context, int i2) {
        super(context);
        this.adF = i2;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.mTheme = theme;
    }

    /* access modifiers changed from: protected */
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void setTheme(int i2) {
        if (this.adF != i2) {
            this.adF = i2;
            hE();
        }
    }

    public final Resources.Theme getTheme() {
        if (this.mTheme != null) {
            return this.mTheme;
        }
        if (this.adF == 0) {
            this.adF = R.style.y1;
        }
        hE();
        return this.mTheme;
    }

    @Override // android.content.Context, android.content.ContextWrapper
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.mInflater == null) {
            this.mInflater = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.mInflater;
    }

    private void hE() {
        if (this.mTheme == null) {
            this.mTheme = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.mTheme.setTo(theme);
            }
        }
        this.mTheme.applyStyle(this.adF, true);
    }

    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    public final Resources getResources() {
        if (this.mResources == null) {
            if (this.adG == null) {
                this.mResources = super.getResources();
            } else if (Build.VERSION.SDK_INT >= 17) {
                this.mResources = createConfigurationContext(this.adG).getResources();
            }
        }
        return this.mResources;
    }
}
