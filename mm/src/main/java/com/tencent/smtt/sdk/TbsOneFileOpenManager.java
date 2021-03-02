package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Bundle;
import android.webkit.ValueCallback;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.TbsFileInterfaceImpl;
import java.util.Map;

public class TbsOneFileOpenManager {
    public static TbsOneFileOpenManager tbsOneGreyInfoHelper;

    public static synchronized TbsOneFileOpenManager getInstance(Context context) {
        TbsOneFileOpenManager tbsOneFileOpenManager;
        synchronized (TbsOneFileOpenManager.class) {
            AppMethodBeat.i(54336);
            if (tbsOneGreyInfoHelper == null) {
                tbsOneGreyInfoHelper = new TbsOneFileOpenManager(context);
            }
            tbsOneFileOpenManager = tbsOneGreyInfoHelper;
            AppMethodBeat.o(54336);
        }
        return tbsOneFileOpenManager;
    }

    public TbsOneFileOpenManager(Context context) {
        AppMethodBeat.i(54337);
        TbsFileInterfaceImpl.initEngine(context);
        AppMethodBeat.o(54337);
    }

    public int openFile(Context context, Bundle bundle, final ValueCallback<String> valueCallback) {
        AppMethodBeat.i(54338);
        int openFileReader = TbsFileInterfaceImpl.getInstance().openFileReader(context, bundle, new ITbsReaderCallback() {
            /* class com.tencent.smtt.sdk.TbsOneFileOpenManager.AnonymousClass1 */

            @Override // com.tencent.tbs.reader.ITbsReaderCallback
            public void onCallBackAction(Integer num, Object obj, Object obj2) {
                AppMethodBeat.i(54321);
                if (valueCallback == null) {
                    AppMethodBeat.o(54321);
                    return;
                }
                if (10 == num.intValue()) {
                    valueCallback.onReceiveValue("plugin success");
                } else if (11 == num.intValue()) {
                    valueCallback.onReceiveValue("plugin failed");
                }
                if (13 == num.intValue()) {
                    valueCallback.onReceiveValue((String) obj);
                }
                AppMethodBeat.o(54321);
            }
        }, null);
        AppMethodBeat.o(54338);
        return openFileReader;
    }

    /* access modifiers changed from: package-private */
    public void a(Map<String, String> map, Bundle bundle) {
        AppMethodBeat.i(54339);
        if (map.containsKey("filePath")) {
            bundle.putString("filePath", map.get("filePath"));
        }
        try {
            if (map.containsKey(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                bundle.putInt(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, Integer.parseInt(map.get(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)));
            }
        } catch (Exception e2) {
        }
        try {
            if (map.containsKey("topBarBgColor")) {
                bundle.putInt("topBarBgColor", Integer.parseInt(map.get("topBarBgColor")));
            }
        } catch (Exception e3) {
        }
        if (bundle != null && map.containsKey("menuData")) {
            bundle.putString("menuData", map.get("menuData"));
        }
        AppMethodBeat.o(54339);
    }

    public boolean canOpenFile(Context context, String str) {
        AppMethodBeat.i(54340);
        TbsFileInterfaceImpl.getInstance();
        boolean canOpenFile = TbsFileInterfaceImpl.canOpenFile(str);
        AppMethodBeat.o(54340);
        return canOpenFile;
    }

    public void closeFileReader() {
        AppMethodBeat.i(54341);
        TbsFileInterfaceImpl.getInstance().closeFileReader();
        AppMethodBeat.o(54341);
    }

    public int startMiniQB(Context context, String str, Map<String, String> map, String str2, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(54342);
        Bundle bundle = new Bundle();
        a(map, bundle);
        if (!map.containsKey("filePath")) {
            bundle.putString("filePath", str);
        }
        int openFile = openFile(context, bundle, valueCallback);
        AppMethodBeat.o(54342);
        return openFile;
    }
}
