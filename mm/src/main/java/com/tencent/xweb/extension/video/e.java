package com.tencent.xweb.extension.video;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebChromeClient;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.xweb.u;
import com.tencent.xweb.util.i;
import com.tencent.xweb.xwalk.a.g;
import com.tencent.xweb.xwalk.a.h;
import org.xwalk.core.Log;
import org.xwalk.core.ReflectMethod;
import org.xwalk.core.XWalkEnvironment;

public final class e {
    private static ClassLoader mClassLoader;

    public static class a implements b, u {
        private Object SCA;
        ReflectMethod SCm;
        private ReflectMethod SCn;
        private ReflectMethod SCo;
        private ReflectMethod SCp;
        private ReflectMethod SCq;
        private ReflectMethod SCr;
        private ReflectMethod SCs;
        private ReflectMethod SCt;
        private ReflectMethod SCu;
        private ReflectMethod SCv;
        private ReflectMethod SCw;
        private ReflectMethod SCx;
        private ReflectMethod SCy;
        private ReflectMethod SCz;

        public a(Object obj) {
            AppMethodBeat.i(153636);
            this.SCA = obj;
            this.SCm = new ReflectMethod(obj, APMidasPluginInfo.LAUNCH_INTERFACE_INIT, Activity.class, View.class, View.class, Context.class, String.class);
            this.SCn = new ReflectMethod(obj, "evaluteJavascript", Boolean.TYPE, Boolean.TYPE);
            this.SCo = new ReflectMethod(obj, "onShowCustomView", View.class, WebChromeClient.CustomViewCallback.class);
            this.SCp = new ReflectMethod(obj, "onHideCustomView", new Class[0]);
            this.SCq = new ReflectMethod(obj, "hasEnteredFullscreen", new Class[0]);
            this.SCr = new ReflectMethod(obj, "registerJavascriptInterface", Object.class);
            this.SCs = new ReflectMethod(obj, "disableJsCallback", Boolean.TYPE);
            this.SCt = new ReflectMethod(obj, "setVideoJsCallback", Object.class);
            this.SCw = new ReflectMethod(obj, "videoChangeStatus", new Class[0]);
            this.SCu = new ReflectMethod(obj, "videoPlay", new Class[0]);
            this.SCv = new ReflectMethod(obj, "videoPause", new Class[0]);
            this.SCx = new ReflectMethod(obj, "videoSeek", Double.TYPE);
            this.SCy = new ReflectMethod(obj, "videoExitFullscreen", new Class[0]);
            this.SCz = new ReflectMethod(obj, "supportSetRequestedOrientationCallback", new Class[0]);
            AppMethodBeat.o(153636);
        }

        @Override // com.tencent.xweb.extension.video.b
        public final void bk(boolean z, boolean z2) {
            AppMethodBeat.i(153637);
            try {
                this.SCn.invoke(Boolean.valueOf(z), Boolean.valueOf(z2));
                AppMethodBeat.o(153637);
            } catch (Exception e2) {
                Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime evaluteJavascript error:" + e2.getMessage());
                AppMethodBeat.o(153637);
            }
        }

        @Override // com.tencent.xweb.extension.video.b
        public final void eJ(Object obj) {
            AppMethodBeat.i(153638);
            try {
                this.SCr.invoke(obj);
                AppMethodBeat.o(153638);
            } catch (Exception e2) {
                Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime registerJavascriptInterface error:" + e2.getMessage());
                AppMethodBeat.o(153638);
            }
        }

        @Override // com.tencent.xweb.extension.video.b
        public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            AppMethodBeat.i(153639);
            try {
                this.SCo.invoke(view, customViewCallback);
                AppMethodBeat.o(153639);
            } catch (Exception e2) {
                Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime onShowCustomView error:" + e2.getMessage());
                AppMethodBeat.o(153639);
            }
        }

        @Override // com.tencent.xweb.extension.video.b
        public final void Em(boolean z) {
            AppMethodBeat.i(153640);
            try {
                this.SCs.invoke(Boolean.valueOf(z));
                AppMethodBeat.o(153640);
            } catch (Exception e2) {
                Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime disableJsCallback error:" + e2.getMessage());
                AppMethodBeat.o(153640);
            }
        }

        @Override // com.tencent.xweb.extension.video.b
        public final void onHideCustomView() {
            AppMethodBeat.i(153641);
            try {
                this.SCp.invoke(new Object[0]);
                AppMethodBeat.o(153641);
            } catch (Exception e2) {
                Log.e("VideoNativeInterface", "VideoNativeInterfaceRuntime onHideCustomView error:" + e2.getMessage());
                AppMethodBeat.o(153641);
            }
        }

        @Override // com.tencent.xweb.extension.video.b
        public final boolean eK(Object obj) {
            AppMethodBeat.i(153642);
            g brX = h.brX(XWalkEnvironment.XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO);
            if (brX == null || brX.SHU < 10) {
                if (brX != null) {
                    Log.i("VideoNativeInterface", "setVideoJsCallback return false fullScreenVideoPlugin is not available version:" + brX.SHU);
                } else {
                    Log.i("VideoNativeInterface", "setVideoJsCallback return false fullScreenVideoPlugin is not available");
                }
                AppMethodBeat.o(153642);
                return false;
            }
            try {
                boolean booleanValue = ((Boolean) this.SCt.invoke(obj)).booleanValue();
                AppMethodBeat.o(153642);
                return booleanValue;
            } catch (Exception e2) {
                Log.i("VideoNativeInterface", "setVideoJsCallback invoke error:" + e2.getMessage());
                AppMethodBeat.o(153642);
                return false;
            }
        }

        @Override // com.tencent.xweb.u
        public final void hsz() {
            AppMethodBeat.i(153643);
            try {
                this.SCu.invoke(new Object[0]);
                AppMethodBeat.o(153643);
            } catch (Exception e2) {
                Log.i("VideoNativeInterface", "videoPlay invoke error:" + e2.getMessage());
                AppMethodBeat.o(153643);
            }
        }

        @Override // com.tencent.xweb.u
        public final void fDd() {
            AppMethodBeat.i(153644);
            try {
                this.SCv.invoke(new Object[0]);
                AppMethodBeat.o(153644);
            } catch (Exception e2) {
                Log.i("VideoNativeInterface", "videoPause invoke error:" + e2.getMessage());
                AppMethodBeat.o(153644);
            }
        }

        @Override // com.tencent.xweb.u
        public final void F(double d2) {
            AppMethodBeat.i(153645);
            try {
                this.SCx.invoke(Double.valueOf(d2));
                AppMethodBeat.o(153645);
            } catch (Exception e2) {
                Log.i("VideoNativeInterface", "videoSeek invoke error:" + e2.getMessage());
                AppMethodBeat.o(153645);
            }
        }

        @Override // com.tencent.xweb.u
        public final boolean hsA() {
            AppMethodBeat.i(207178);
            try {
                boolean booleanValue = ((Boolean) this.SCz.invoke(new Object[0])).booleanValue();
                AppMethodBeat.o(207178);
                return booleanValue;
            } catch (Exception e2) {
                Log.i("VideoNativeInterface", "supportSetRequestedOrientationCallback invoke error:" + e2.getMessage());
                AppMethodBeat.o(207178);
                return false;
            }
        }
    }

    private static ClassLoader htq() {
        AppMethodBeat.i(153646);
        if (mClassLoader != null) {
            ClassLoader classLoader = mClassLoader;
            AppMethodBeat.o(153646);
            return classLoader;
        }
        try {
            mClassLoader = i.huI();
            ClassLoader classLoader2 = mClassLoader;
            AppMethodBeat.o(153646);
            return classLoader2;
        } catch (Exception e2) {
            Log.e("VideoNativeInterface", "getXWalkClassLoader error:" + e2.getMessage());
            AppMethodBeat.o(153646);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.xweb.extension.video.b a(android.content.Context r11, com.tencent.xweb.WebView r12, android.view.View r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 643
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.xweb.extension.video.e.a(android.content.Context, com.tencent.xweb.WebView, android.view.View, java.lang.String):com.tencent.xweb.extension.video.b");
    }
}
