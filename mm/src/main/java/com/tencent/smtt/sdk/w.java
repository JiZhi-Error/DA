package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.tav.core.AssetExtension;
import dalvik.system.DexClassLoader;

/* access modifiers changed from: package-private */
public class w {

    /* renamed from: a  reason: collision with root package name */
    protected DexLoader f2139a = null;

    public w(DexLoader dexLoader) {
        this.f2139a = dexLoader;
    }

    public Object a(Context context) {
        AppMethodBeat.i(188236);
        Object newInstance = this.f2139a.newInstance("com.tencent.tbs.player.TbsPlayerProxy", new Class[]{Context.class, DexClassLoader.class}, context, this.f2139a.getClassLoader());
        AppMethodBeat.o(188236);
        return newInstance;
    }

    public boolean a(Object obj, Bundle bundle, FrameLayout frameLayout, Object obj2) {
        Object invokeMethod;
        AppMethodBeat.i(188237);
        if (obj2 != null) {
            invokeMethod = this.f2139a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", AssetExtension.SCENE_PLAY, new Class[]{Bundle.class, FrameLayout.class, Object.class}, bundle, frameLayout, obj2);
        } else {
            invokeMethod = this.f2139a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", AssetExtension.SCENE_PLAY, new Class[]{Bundle.class, FrameLayout.class}, bundle, frameLayout);
        }
        if (invokeMethod instanceof Boolean) {
            boolean booleanValue = ((Boolean) invokeMethod).booleanValue();
            AppMethodBeat.o(188237);
            return booleanValue;
        }
        AppMethodBeat.o(188237);
        return false;
    }

    public void a(Object obj, Activity activity, int i2) {
        AppMethodBeat.i(188238);
        this.f2139a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onActivity", new Class[]{Activity.class, Integer.TYPE}, activity, Integer.valueOf(i2));
        AppMethodBeat.o(188238);
    }

    public void a(Object obj) {
        AppMethodBeat.i(188239);
        this.f2139a.invokeMethod(obj, "com.tencent.tbs.player.TbsPlayerProxy", "onUserStateChanged", new Class[0], new Object[0]);
        AppMethodBeat.o(188239);
    }
}
