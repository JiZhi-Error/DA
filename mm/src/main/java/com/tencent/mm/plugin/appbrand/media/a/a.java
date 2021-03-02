package com.tencent.mm.plugin.appbrand.media.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private static Map<String, c> ncL = new ConcurrentHashMap();
    private static Map<String, IListener> ncM = new HashMap();
    private static ArrayList<String> ncN = new ArrayList<>();
    private static Map<String, Boolean> ncO = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(145783);
        AppMethodBeat.o(145783);
    }

    public static void onCreate(String str) {
        AppMethodBeat.i(145775);
        Log.i("MicroMsg.Audio.AppBrandAudioClientService", "onCreate");
        ncL.clear();
        b.onCreate(str);
        ncO.put(str, Boolean.TRUE);
        AppMethodBeat.o(145775);
    }

    public static void Zl(String str) {
        AppMethodBeat.i(145776);
        Log.i("MicroMsg.Audio.AppBrandAudioClientService", "onDestroy");
        b.Zl(str);
        ncL.clear();
        Iterator<String> it = ncN.iterator();
        while (it.hasNext()) {
            IListener remove = ncM.remove(it.next());
            if (remove != null) {
                EventCenter.instance.removeListener(remove);
            }
        }
        ncM.clear();
        ncN.clear();
        ncO.remove(str);
        AppMethodBeat.o(145776);
    }

    public static void a(String str, c cVar) {
        AppMethodBeat.i(145777);
        ncL.put(str, cVar);
        AppMethodBeat.o(145777);
    }

    public static c acz(String str) {
        AppMethodBeat.i(145778);
        c cVar = ncL.get(str);
        AppMethodBeat.o(145778);
        return cVar;
    }

    public static void a(String str, IListener iListener) {
        AppMethodBeat.i(145779);
        if (TextUtils.isEmpty(str)) {
            Log.e("MicroMsg.Audio.AppBrandAudioClientService", "appId is empty");
            AppMethodBeat.o(145779);
        } else if (iListener == null) {
            Log.e("MicroMsg.Audio.AppBrandAudioClientService", "listener is null");
            AppMethodBeat.o(145779);
        } else {
            if (ncM.containsKey(str)) {
                acA(str);
            }
            Log.d("MicroMsg.Audio.AppBrandAudioClientService", "addAudioPlayerListener,appId:%s", str);
            ncM.put(str, iListener);
            if (!ncN.contains(str)) {
                ncN.add(str);
            }
            EventCenter.instance.add(iListener);
            AppMethodBeat.o(145779);
        }
    }

    public static void acA(String str) {
        AppMethodBeat.i(145780);
        if (!ncM.containsKey(str)) {
            Log.e("MicroMsg.Audio.AppBrandAudioClientService", "appId:%s not exist the appId for listener", str);
            AppMethodBeat.o(145780);
            return;
        }
        Log.d("MicroMsg.Audio.AppBrandAudioClientService", "removeAudioPlayerListener,appId:%s", str);
        ncN.remove(str);
        IListener remove = ncM.remove(str);
        if (remove != null) {
            EventCenter.instance.removeListener(remove);
        }
        AppMethodBeat.o(145780);
    }

    public static boolean acB(String str) {
        AppMethodBeat.i(145781);
        if (!ncO.containsKey(str)) {
            AppMethodBeat.o(145781);
            return false;
        }
        boolean booleanValue = ncO.get(str).booleanValue();
        AppMethodBeat.o(145781);
        return booleanValue;
    }

    public static void aw(String str, boolean z) {
        AppMethodBeat.i(145782);
        ncO.put(str, Boolean.valueOf(z));
        AppMethodBeat.o(145782);
    }
}
