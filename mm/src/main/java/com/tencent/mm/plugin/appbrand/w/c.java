package com.tencent.mm.plugin.appbrand.w;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public enum c {
    INSTANCE;
    
    private Map<a, Long> nFE = new HashMap();
    private Map<a, Long> nFF = new HashMap();

    private c(String str) {
        AppMethodBeat.i(140783);
        AppMethodBeat.o(140783);
    }

    public static c valueOf(String str) {
        AppMethodBeat.i(140782);
        c cVar = (c) Enum.valueOf(c.class, str);
        AppMethodBeat.o(140782);
        return cVar;
    }

    static {
        AppMethodBeat.i(140786);
        AppMethodBeat.o(140786);
    }

    public enum a {
        AppStart("AppStart"),
        LoadPageFrame("LoadPageFrame"),
        PrepareJsRuntime("PrepareJsRuntime"),
        GetDom("GetDom"),
        ParseDom("ParseDom"),
        DiffDom("DiffDom"),
        GetGlobalCss("GetGlobalCss"),
        GetCss("GetCss"),
        ParseCss("ParseCss"),
        GetData("GetData"),
        Layout("Layout"),
        JSEvent("JSEvent"),
        StartUp("StartUp");
        
        private String name;

        public static a valueOf(String str) {
            AppMethodBeat.i(140779);
            a aVar = (a) Enum.valueOf(a.class, str);
            AppMethodBeat.o(140779);
            return aVar;
        }

        static {
            AppMethodBeat.i(140780);
            AppMethodBeat.o(140780);
        }

        private a(String str) {
            this.name = str;
        }

        public final String toString() {
            return this.name;
        }
    }

    public final void a(a aVar) {
        AppMethodBeat.i(140784);
        this.nFE.put(aVar, Long.valueOf(SystemClock.elapsedRealtime()));
        AppMethodBeat.o(140784);
    }

    public final String toString() {
        return "";
    }
}
