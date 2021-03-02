package com.tencent.mars.sdt;

import com.tencent.mars.Mars;
import java.util.ArrayList;

public class SdtLogic {
    private static final String TAG = "mars.SdtLogic";
    private static ICallBack callBack = null;

    public interface ICallBack {
    }

    private static native ArrayList<String> getLoadLibraries();

    public static native void setHttpNetcheckCGI(String str);

    static {
        ArrayList<String> arrayList;
        try {
            arrayList = getLoadLibraries();
        } catch (UnsatisfiedLinkError e2) {
            arrayList = null;
            Mars.loadDefaultMarsLibrary();
        }
        Mars.checkLoadedModules(arrayList, TAG);
    }

    public static void setCallBack(ICallBack iCallBack) {
        callBack = iCallBack;
    }

    private static void reportSignalDetectResults(String str) {
    }
}
