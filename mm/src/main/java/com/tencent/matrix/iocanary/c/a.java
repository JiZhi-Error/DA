package com.tencent.matrix.iocanary.c;

import android.content.Context;
import com.tencent.matrix.iocanary.core.IOIssue;
import com.tencent.matrix.report.c;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static String sPackageName = null;

    public static void setPackageName(Context context) {
        if (sPackageName == null) {
            sPackageName = context.getPackageName();
        }
    }

    public static String getThrowableStack(Throwable th) {
        StackTraceElement[] stackTrace;
        if (th == null || (stackTrace = th.getStackTrace()) == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList(stackTrace.length);
        for (int i2 = 0; i2 < stackTrace.length; i2++) {
            String className = stackTrace[i2].getClassName();
            if (!className.contains("libcore.io") && !className.contains("com.tencent.matrix.iocanary") && !className.contains("java.io") && !className.contains("dalvik.system") && !className.contains("android.os")) {
                arrayList.add(stackTrace[i2]);
            }
        }
        if (arrayList.size() > 10 && sPackageName != null) {
            ListIterator listIterator = arrayList.listIterator(arrayList.size());
            while (listIterator.hasPrevious()) {
                if (!((StackTraceElement) listIterator.previous()).getClassName().contains(sPackageName)) {
                    listIterator.remove();
                }
                if (arrayList.size() <= 10) {
                    break;
                }
            }
        }
        StringBuffer stringBuffer = new StringBuffer(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((StackTraceElement) it.next()).append('\n');
        }
        return stringBuffer.toString();
    }

    public static c a(IOIssue iOIssue) {
        if (iOIssue == null) {
            return null;
        }
        c cVar = new c(iOIssue.type);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("path", iOIssue.path);
            jSONObject.put("size", iOIssue.fileSize);
            jSONObject.put("op", iOIssue.opCnt);
            jSONObject.put("buffer", iOIssue.bufferSize);
            jSONObject.put("cost", iOIssue.opCostTime);
            jSONObject.put("opType", iOIssue.opType);
            jSONObject.put("opSize", iOIssue.opSize);
            jSONObject.put("thread", iOIssue.threadName);
            jSONObject.put(SharePluginInfo.ISSUE_KEY_STACK, iOIssue.stack);
            jSONObject.put("repeat", iOIssue.repeatReadCnt);
        } catch (JSONException e2) {
        }
        cVar.cWe = jSONObject;
        return cVar;
    }
}
