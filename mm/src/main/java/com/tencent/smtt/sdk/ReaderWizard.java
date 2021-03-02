package com.tencent.smtt.sdk;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsReaderView;

public class ReaderWizard {

    /* renamed from: a  reason: collision with root package name */
    private DexLoader f1725a;

    /* renamed from: b  reason: collision with root package name */
    private TbsReaderView.ReaderCallback f1726b;

    public static boolean isSupportCurrentPlatform(Context context) {
        boolean z;
        AppMethodBeat.i(55117);
        DexLoader a2 = a();
        if (a2 != null) {
            Object invokeStaticMethod = a2.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportCurrentPlatform", new Class[]{Context.class}, context);
            if (invokeStaticMethod instanceof Boolean) {
                z = ((Boolean) invokeStaticMethod).booleanValue();
                AppMethodBeat.o(55117);
                return z;
            }
        }
        z = false;
        AppMethodBeat.o(55117);
        return z;
    }

    public static boolean isSupportExt(String str) {
        boolean z;
        AppMethodBeat.i(55118);
        DexLoader a2 = a();
        if (a2 != null) {
            Object invokeStaticMethod = a2.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "isSupportExt", new Class[]{String.class}, str);
            if (invokeStaticMethod instanceof Boolean) {
                z = ((Boolean) invokeStaticMethod).booleanValue();
                AppMethodBeat.o(55118);
                return z;
            }
        }
        z = false;
        AppMethodBeat.o(55118);
        return z;
    }

    public static Drawable getResDrawable(int i2) {
        Drawable drawable;
        AppMethodBeat.i(55119);
        DexLoader a2 = a();
        if (a2 != null) {
            Object invokeStaticMethod = a2.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResDrawable", new Class[]{Integer.class}, Integer.valueOf(i2));
            if (invokeStaticMethod instanceof Drawable) {
                drawable = (Drawable) invokeStaticMethod;
                AppMethodBeat.o(55119);
                return drawable;
            }
        }
        drawable = null;
        AppMethodBeat.o(55119);
        return drawable;
    }

    public static String getResString(int i2) {
        String str;
        AppMethodBeat.i(55120);
        DexLoader a2 = a();
        if (a2 != null) {
            Object invokeStaticMethod = a2.invokeStaticMethod("com.tencent.tbs.reader.TbsReader", "getResString", new Class[]{Integer.class}, Integer.valueOf(i2));
            if (invokeStaticMethod instanceof String) {
                str = (String) invokeStaticMethod;
                AppMethodBeat.o(55120);
                return str;
            }
        }
        str = "";
        AppMethodBeat.o(55120);
        return str;
    }

    public ReaderWizard(TbsReaderView.ReaderCallback readerCallback) {
        AppMethodBeat.i(55121);
        this.f1725a = null;
        this.f1726b = null;
        this.f1725a = a();
        this.f1726b = readerCallback;
        AppMethodBeat.o(55121);
    }

    private static DexLoader a() {
        AppMethodBeat.i(55122);
        TbsWizard c2 = g.a(true).c();
        DexLoader dexLoader = null;
        if (c2 != null) {
            dexLoader = c2.dexLoader();
        }
        AppMethodBeat.o(55122);
        return dexLoader;
    }

    public Object getTbsReader() {
        AppMethodBeat.i(55123);
        Object newInstance = this.f1725a.newInstance("com.tencent.tbs.reader.TbsReader", new Class[0], new Object[0]);
        AppMethodBeat.o(55123);
        return newInstance;
    }

    public boolean initTbsReader(Object obj, Context context) {
        AppMethodBeat.i(55124);
        if (this.f1725a == null || obj == null) {
            AppMethodBeat.o(55124);
            return false;
        }
        Object invokeMethod = this.f1725a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, new Class[]{Context.class, DexLoader.class, Object.class}, context, this.f1725a, this);
        if (!(invokeMethod instanceof Boolean)) {
            AppMethodBeat.o(55124);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeMethod).booleanValue();
        AppMethodBeat.o(55124);
        return booleanValue;
    }

    public boolean checkPlugin(Object obj, Context context, String str, boolean z) {
        AppMethodBeat.i(55125);
        if (this.f1725a == null) {
            AppMethodBeat.o(55125);
            return false;
        }
        Object invokeMethod = this.f1725a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "checkPlugin", new Class[]{Context.class, String.class, Boolean.class}, context, str, Boolean.valueOf(z));
        if (!(invokeMethod instanceof Boolean)) {
            AppMethodBeat.o(55125);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeMethod).booleanValue();
        AppMethodBeat.o(55125);
        return booleanValue;
    }

    public boolean openFile(Object obj, Context context, Bundle bundle, FrameLayout frameLayout) {
        AppMethodBeat.i(55126);
        if (this.f1725a == null) {
            AppMethodBeat.o(55126);
            return false;
        }
        Object invokeMethod = this.f1725a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "openFile", new Class[]{Context.class, Bundle.class, FrameLayout.class}, context, bundle, frameLayout);
        if (!(invokeMethod instanceof Boolean)) {
            AppMethodBeat.o(55126);
            return false;
        }
        boolean booleanValue = ((Boolean) invokeMethod).booleanValue();
        AppMethodBeat.o(55126);
        return booleanValue;
    }

    public void onSizeChanged(Object obj, int i2, int i3) {
        AppMethodBeat.i(55127);
        if (this.f1725a == null) {
            AppMethodBeat.o(55127);
            return;
        }
        this.f1725a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "onSizeChanged", new Class[]{Integer.class, Integer.class}, Integer.valueOf(i2), Integer.valueOf(i3));
        AppMethodBeat.o(55127);
    }

    public void onCallBackAction(Integer num, Object obj, Object obj2) {
        AppMethodBeat.i(55128);
        new StringBuilder("onCallBackAction actionType:").append(num).append(" args").append(obj).append(" result").append(obj2);
        if (this.f1726b != null) {
            this.f1726b.onCallBackAction(num, obj, obj2);
        }
        AppMethodBeat.o(55128);
    }

    public void doCommand(Object obj, Integer num, Object obj2, Object obj3) {
        AppMethodBeat.i(55129);
        new StringBuilder("doAction actionType:").append(num).append(" args").append(obj2).append(" result").append(obj3);
        if (this.f1725a == null) {
            AppMethodBeat.o(55129);
            return;
        }
        this.f1725a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "doCommand", new Class[]{Integer.class, Object.class, Object.class}, new Integer(num.intValue()), obj2, obj3);
        AppMethodBeat.o(55129);
    }

    public void destroy(Object obj) {
        AppMethodBeat.i(55130);
        this.f1726b = null;
        if (this.f1725a == null || obj == null) {
            AppMethodBeat.o(55130);
            return;
        }
        this.f1725a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "destroy", new Class[0], new Object[0]);
        AppMethodBeat.o(55130);
    }

    public void userStatistics(Object obj, String str) {
        AppMethodBeat.i(55131);
        if (this.f1725a == null) {
            AppMethodBeat.o(55131);
            return;
        }
        this.f1725a.invokeMethod(obj, "com.tencent.tbs.reader.TbsReader", "userStatistics", new Class[]{String.class}, str);
        AppMethodBeat.o(55131);
    }
}
