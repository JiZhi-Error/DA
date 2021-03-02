package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static final Map<String, Class<? extends AppBrandTaskProxyUI>> lvE;

    public static void a(Context context, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, DialogInterface.OnClickListener onClickListener3) {
        AppMethodBeat.i(45380);
        AppBrandProcessProxyUI.a(context, AppBrandProcessProxyUI.class, str, str2, str3, str4, onClickListener, onClickListener2, onClickListener3);
        AppMethodBeat.o(45380);
    }

    public static <_Req extends AppBrandProxyUIProcessTask.ProcessRequest, _Result extends AppBrandProxyUIProcessTask.ProcessResult> void a(Context context, _Req _req, AppBrandProxyUIProcessTask.b<_Result> bVar) {
        AppMethodBeat.i(45381);
        a(context, _req, bVar, null);
        AppMethodBeat.o(45381);
    }

    public static <_Req extends AppBrandProxyUIProcessTask.ProcessRequest, _Result extends AppBrandProxyUIProcessTask.ProcessResult> void a(Context context, _Req _req, AppBrandProxyUIProcessTask.b<_Result> bVar, Intent intent) {
        AppMethodBeat.i(45382);
        AppBrandProcessProxyUI.a(context, _req.bDQ() ? AppBrandProcessLandscapeProxyUI.class : AppBrandProcessProxyUI.class, _req, bVar, intent);
        AppMethodBeat.o(45382);
    }

    static {
        AppMethodBeat.i(45384);
        HashMap hashMap = new HashMap();
        hashMap.put(":appbrand0", AppBrandTaskProxyUI.class);
        hashMap.put(":appbrand1", AppBrandTaskProxyUI1.class);
        hashMap.put(":appbrand2", AppBrandTaskProxyUI2.class);
        hashMap.put(":appbrand3", AppBrandTaskProxyUI3.class);
        hashMap.put(":appbrand4", AppBrandTaskProxyUI4.class);
        lvE = Collections.unmodifiableMap(hashMap);
        AppMethodBeat.o(45384);
    }

    public static <_Req extends AppBrandProxyUIProcessTask.ProcessRequest, _Result extends AppBrandProxyUIProcessTask.ProcessResult> void b(Context context, _Req _req, AppBrandProxyUIProcessTask.b<_Result> bVar) {
        AppMethodBeat.i(45383);
        Class<? extends AppBrandTaskProxyUI> cls = lvE.get(MMApplicationContext.getProcessName().replaceFirst(MMApplicationContext.getPackageName(), ""));
        if (cls == null) {
            cls = AppBrandProcessProxyUI.class;
        }
        AppBrandProcessProxyUI.a(context, cls, _req, bVar, null);
        AppMethodBeat.o(45383);
    }

    public static <_Req extends AppBrandProxyUIProcessTask.ProcessRequest, _Result extends AppBrandProxyUIProcessTask.ProcessResult> void a(Context context, _Req _req, String str) {
        AppMethodBeat.i(174742);
        Class<? extends AppBrandTaskProxyUI> cls = lvE.get(str.replaceFirst(MMApplicationContext.getPackageName(), ""));
        if (cls == null) {
            cls = AppBrandProcessProxyUI.class;
        }
        AppBrandProcessProxyUI.a(context, cls, _req, null, null);
        AppMethodBeat.o(174742);
    }
}
