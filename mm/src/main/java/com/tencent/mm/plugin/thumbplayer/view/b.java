package com.tencent.mm.plugin.thumbplayer.view;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@TargetApi(16)
final class b extends SurfaceTexture {
    public SurfaceTexture mSurfaceTexture = null;

    public b() {
        super(0);
    }

    public final void setOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        AppMethodBeat.i(238576);
        Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setOnFrameAvailableListener");
        this.mSurfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
        AppMethodBeat.o(238576);
    }

    public final void setDefaultBufferSize(int i2, int i3) {
        AppMethodBeat.i(238577);
        Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, setDefaultBufferSize");
        this.mSurfaceTexture.setDefaultBufferSize(i2, i3);
        AppMethodBeat.o(238577);
    }

    public final void updateTexImage() {
        AppMethodBeat.i(238578);
        Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, updateTexImage");
        this.mSurfaceTexture.updateTexImage();
        AppMethodBeat.o(238578);
    }

    public final void detachFromGLContext() {
        boolean z;
        AppMethodBeat.i(238579);
        Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, detachFromGLContext");
        try {
            this.mSurfaceTexture.detachFromGLContext();
            z = false;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e2, "%s", "detect texture problem, RuntimeException detachFromGLContext");
            z = true;
        }
        if (z) {
            try {
                Method declaredMethod = SurfaceTexture.class.getDeclaredMethod("nativeDetachFromGLContext", new Class[0]);
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(this.mSurfaceTexture, new Object[0])).intValue();
                String str = aXy() + " detect texture problem error code = " + intValue + ", detach = true, and error = " + z;
                CrashReportFactory.reportRawMessage(Base64.encodeToString(str.getBytes(), 2), "DetachFromGLContext");
                Log.w("MicroMsg.MMSurfaceTextureWrap", str);
                Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", Integer.valueOf(intValue), Boolean.TRUE, Boolean.valueOf(z));
                AppMethodBeat.o(238579);
            } catch (IllegalArgumentException e3) {
                Log.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e3, "%s", "detect texture problem, IllegalArgumentException");
                String str2 = aXy() + " detect texture problem error code = 0, detach = false, and error = " + z;
                CrashReportFactory.reportRawMessage(Base64.encodeToString(str2.getBytes(), 2), "DetachFromGLContext");
                Log.w("MicroMsg.MMSurfaceTextureWrap", str2);
                Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", 0, Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.o(238579);
            } catch (IllegalAccessException e4) {
                Log.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e4, "%s", "detect texture problem, IllegalAccessException");
                String str3 = aXy() + " detect texture problem error code = 0, detach = false, and error = " + z;
                CrashReportFactory.reportRawMessage(Base64.encodeToString(str3.getBytes(), 2), "DetachFromGLContext");
                Log.w("MicroMsg.MMSurfaceTextureWrap", str3);
                Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", 0, Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.o(238579);
            } catch (InvocationTargetException e5) {
                Log.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e5, "%s", "detect texture problem, InvocationTargetException");
                String str4 = aXy() + " detect texture problem error code = 0, detach = false, and error = " + z;
                CrashReportFactory.reportRawMessage(Base64.encodeToString(str4.getBytes(), 2), "DetachFromGLContext");
                Log.w("MicroMsg.MMSurfaceTextureWrap", str4);
                Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", 0, Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.o(238579);
            } catch (NoSuchMethodException e6) {
                Log.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e6, "%s", "detect texture problem, NoSuchMethodException");
                String str5 = aXy() + " detect texture problem error code = 0, detach = false, and error = " + z;
                CrashReportFactory.reportRawMessage(Base64.encodeToString(str5.getBytes(), 2), "DetachFromGLContext");
                Log.w("MicroMsg.MMSurfaceTextureWrap", str5);
                Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", 0, Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.o(238579);
            } catch (Exception e7) {
                Log.printErrStackTrace("MicroMsg.MMSurfaceTextureWrap", e7, "%s", "detect texture problem, Exception");
                String str6 = aXy() + " detect texture problem error code = 0, detach = false, and error = " + z;
                CrashReportFactory.reportRawMessage(Base64.encodeToString(str6.getBytes(), 2), "DetachFromGLContext");
                Log.w("MicroMsg.MMSurfaceTextureWrap", str6);
                Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", 0, Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.o(238579);
            } catch (Throwable th) {
                String str7 = aXy() + " detect texture problem error code = 0, detach = false, and error = " + z;
                CrashReportFactory.reportRawMessage(Base64.encodeToString(str7.getBytes(), 2), "DetachFromGLContext");
                Log.w("MicroMsg.MMSurfaceTextureWrap", str7);
                Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, err %s hasDetach %s hasError %s", 0, Boolean.FALSE, Boolean.valueOf(z));
                AppMethodBeat.o(238579);
                throw th;
            }
        } else {
            AppMethodBeat.o(238579);
        }
    }

    private static String aXy() {
        String str;
        AppMethodBeat.i(238580);
        StringBuilder sb = new StringBuilder(256);
        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(sb);
        Context context = MMApplicationContext.getContext();
        stringBuilderPrinter.println("#accinfo.revision=" + BuildInfo.REV);
        stringBuilderPrinter.println("#accinfo.build=" + BuildInfo.TIME + ":" + BuildInfo.HOSTNAME + ":" + ChannelUtil.channelId);
        stringBuilderPrinter.println("#accinfo.env=" + (CrashReportFactory.foreground ? "f" : "b") + ":" + Thread.currentThread().getName() + ":" + CrashReportFactory.currentActivity);
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            StatFs statFs2 = new StatFs(com.tencent.mm.loader.j.b.aKD());
            str = String.format("%dMB %s:%d:%d:%d %s:%d:%d:%d", Integer.valueOf(((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getMemoryClass()), Environment.getDataDirectory().getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), com.tencent.mm.loader.j.b.aKD(), Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks()));
        } catch (Exception e2) {
            Log.e("MicroMsg.MMSurfaceTextureWrap", "check data size failed :%s", e2.getMessage());
            str = "";
        }
        stringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(str)));
        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
        stringBuilderPrinter.println("#crashContent=");
        String sb2 = sb.toString();
        AppMethodBeat.o(238580);
        return sb2;
    }

    public final void attachToGLContext(int i2) {
        AppMethodBeat.i(238581);
        Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, attachToGLContext");
        this.mSurfaceTexture.attachToGLContext(i2);
        AppMethodBeat.o(238581);
    }

    public final void getTransformMatrix(float[] fArr) {
        AppMethodBeat.i(238582);
        Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTransformMatrix");
        this.mSurfaceTexture.getTransformMatrix(fArr);
        AppMethodBeat.o(238582);
    }

    public final long getTimestamp() {
        AppMethodBeat.i(238583);
        Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, getTimestamp");
        long timestamp = this.mSurfaceTexture.getTimestamp();
        AppMethodBeat.o(238583);
        return timestamp;
    }

    public final void release() {
        AppMethodBeat.i(238584);
        super.release();
        Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, release");
        this.mSurfaceTexture.release();
        AppMethodBeat.o(238584);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(238585);
        boolean equals = this.mSurfaceTexture.equals(obj);
        AppMethodBeat.o(238585);
        return equals;
    }

    public final int hashCode() {
        AppMethodBeat.i(238586);
        int hashCode = this.mSurfaceTexture.hashCode();
        AppMethodBeat.o(238586);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(238587);
        String obj = this.mSurfaceTexture.toString();
        AppMethodBeat.o(238587);
        return obj;
    }

    @TargetApi(19)
    public final void releaseTexImage() {
        AppMethodBeat.i(238588);
        Log.i("MicroMsg.MMSurfaceTextureWrap", "detect texture problem, releaseTexImage");
        this.mSurfaceTexture.releaseTexImage();
        AppMethodBeat.o(238588);
    }
}
