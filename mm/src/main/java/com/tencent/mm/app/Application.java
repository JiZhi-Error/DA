package com.tencent.mm.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;

public class Application extends TinkerApplication {
    private static final String CLASSLOADER_INITIALIZER_CLASSNAME = "com.tencent.mm.plugin.expansions.ExpansionsClassLoaderInitializer";
    private static final String CLASSLOADER_INITIALIZER_METHODNAME = "initializeClassLoader";
    public static final boolean IS_OBB_ENABLED = false;
    private static final String TINKER_LOADER_ENTRY_CLASSNAME = "com.tencent.tinker.loader.TinkerLoader";
    private static final String WECHAT_APPLICATION_LIKE_CLASSNAME = "com.tencent.mm.app.MMApplicationLike";

    public Application() {
        super(7, WECHAT_APPLICATION_LIKE_CLASSNAME, TINKER_LOADER_ENTRY_CLASSNAME, true, true);
    }

    @SuppressLint({"NewApi"})
    private void replaceAndInitAppClassLoader() {
        this.tinkerResultIntent = new Intent();
        ShareIntentUtil.setIntentReturnCode(this.tinkerResultIntent, -1);
    }

    @Override // com.tencent.tinker.loader.app.TinkerApplication
    public void onBaseContextAttached(Context context, long j2, long j3) {
        super.onBaseContextAttached(context, j2, j3);
    }
}
