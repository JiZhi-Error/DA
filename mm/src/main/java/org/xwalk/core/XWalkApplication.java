package org.xwalk.core;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class XWalkApplication extends Application {
    private static final String TAG = "XWalkLib";
    private static XWalkApplication gApp = null;
    private Resources mRes = null;

    public void onCreate() {
        AppMethodBeat.i(154625);
        super.onCreate();
        gApp = this;
        AppMethodBeat.o(154625);
    }

    public Resources getResources() {
        AppMethodBeat.i(154626);
        if (this.mRes == null) {
            Resources resources = super.getResources();
            AppMethodBeat.o(154626);
            return resources;
        }
        Resources resources2 = this.mRes;
        AppMethodBeat.o(154626);
        return resources2;
    }

    /* access modifiers changed from: package-private */
    public void addResource(Resources resources) {
        AppMethodBeat.i(154627);
        if (this.mRes != null) {
            AppMethodBeat.o(154627);
            return;
        }
        this.mRes = new XWalkMixedResources(super.getResources(), resources);
        AppMethodBeat.o(154627);
    }

    /* access modifiers changed from: package-private */
    public void addResource(String str) {
        AppMethodBeat.i(154628);
        if (this.mRes != null) {
            AppMethodBeat.o(154628);
            return;
        }
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            Resources resources = super.getResources();
            this.mRes = new XWalkMixedResources(super.getResources(), new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration()));
            AppMethodBeat.o(154628);
        } catch (Exception e2) {
            Log.e(TAG, e2.getMessage());
            AppMethodBeat.o(154628);
        }
    }

    static XWalkApplication getApplication() {
        return gApp;
    }
}
