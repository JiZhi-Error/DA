package com.hilive.mediasdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;

public class LoadDelegate {
    private static final String TAG = "[hilive][java]";
    private static ILoadLibrary sInstance = new ILoadLibrary() {
        /* class com.hilive.mediasdk.LoadDelegate.AnonymousClass1 */

        @Override // com.hilive.mediasdk.LoadDelegate.ILoadLibrary
        public final void loadLibrary(String str) {
            AppMethodBeat.i(73586);
            loadSo(str);
            AppMethodBeat.o(73586);
        }

        @Override // com.hilive.mediasdk.LoadDelegate.ILoadLibrary
        public final void loadLibrary(String str, ClassLoader classLoader) {
        }

        private boolean loadSo(String str) {
            AppMethodBeat.i(73587);
            int i2 = 0;
            while (i2 < 3) {
                try {
                    System.loadLibrary(str);
                    LogDelegate.i(LoadDelegate.TAG, "loadSo " + str + " success!", new Object[0]);
                    AppMethodBeat.o(73587);
                    return true;
                } catch (UnsatisfiedLinkError e2) {
                    LogDelegate.e(LoadDelegate.TAG, "loadSo " + str + " failed UnsatisfiedLinkError " + (e2.getMessage() == null ? BuildConfig.COMMAND : e2.getMessage()), new Object[0]);
                } catch (SecurityException e3) {
                    LogDelegate.e(LoadDelegate.TAG, "loadSo " + str + " failed SecurityException " + (e3.getMessage() == null ? BuildConfig.COMMAND : e3.getMessage()), new Object[0]);
                } catch (NullPointerException e4) {
                    LogDelegate.e(LoadDelegate.TAG, "loadSo " + str + " failed NullPointerException " + (e4.getMessage() == null ? BuildConfig.COMMAND : e4.getMessage()), new Object[0]);
                } catch (Throwable th) {
                    LogDelegate.printStackTrace(LoadDelegate.TAG, th, "loadSo", new Object[0]);
                }
            }
            AppMethodBeat.o(73587);
            return false;
            i2++;
        }
    };
    private static boolean sLibraryLoaded = false;

    public interface ILoadLibrary {
        void loadLibrary(String str);

        void loadLibrary(String str, ClassLoader classLoader);
    }

    static {
        AppMethodBeat.i(73591);
        AppMethodBeat.o(73591);
    }

    public static void setInstance(ILoadLibrary iLoadLibrary) {
        if (iLoadLibrary != null) {
            sInstance = iLoadLibrary;
        }
    }

    public static void loadLibrary(String str) {
        AppMethodBeat.i(73588);
        sInstance.loadLibrary(str);
        AppMethodBeat.o(73588);
    }

    public static void loadLibrary(String str, ClassLoader classLoader) {
        AppMethodBeat.i(73589);
        sInstance.loadLibrary(str, classLoader);
        AppMethodBeat.o(73589);
    }

    public static void loadLibraries() {
        AppMethodBeat.i(73590);
        if (sLibraryLoaded) {
            AppMethodBeat.o(73590);
            return;
        }
        sInstance.loadLibrary("c++_shared");
        sInstance.loadLibrary("mmavmedia");
        sInstance.loadLibrary("mmmediasdk");
        sInstance.loadLibrary("mmmediasdkjni");
        AppMethodBeat.o(73590);
    }
}
