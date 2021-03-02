package com.tencent.sqlitelint;

import android.content.Context;
import android.content.res.XmlResourceParser;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.sqlitelint.util.SLog;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParserException;

public final class CheckerWhiteListLogic {
    private static final String ATTRIBUTE_CHECKER_NAME = "name";
    private static final String TAG = "SQLiteLint.CheckerWhiteListLogic";
    private static final String TAG_CHECKER = "checker";
    private static final String TAG_WHITE_LIST_ELEMENT = "element";

    public static void setWhiteList(Context context, String str, int i2) {
        String str2;
        String str3 = null;
        AppMethodBeat.i(52818);
        try {
            XmlResourceParser xml = context.getResources().getXml(i2);
            if (xml == null) {
                SLog.w(TAG, "buildWhiteListSet: parser null", new Object[0]);
                AppMethodBeat.o(52818);
                return;
            }
            try {
                int eventType = xml.getEventType();
                HashMap hashMap = new HashMap();
                int i3 = 0;
                while (true) {
                    if (eventType != 1) {
                        switch (eventType) {
                            case 0:
                            case 3:
                                break;
                            case 1:
                            default:
                                SLog.w(TAG, "buildWhiteListMap: default branch , eventType:%d", Integer.valueOf(eventType));
                                break;
                            case 2:
                                String name = xml.getName();
                                if (TAG_CHECKER.equalsIgnoreCase(name)) {
                                    str2 = xml.getAttributeValue(null, "name");
                                } else {
                                    str2 = str3;
                                }
                                if (TAG_WHITE_LIST_ELEMENT.equalsIgnoreCase(name) && !SQLiteLintUtil.isNullOrNil(str2)) {
                                    String nextText = xml.nextText();
                                    if (hashMap.get(str2) == null) {
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add(nextText);
                                        hashMap.put(str2, arrayList);
                                    } else {
                                        ((List) hashMap.get(str2)).add(nextText);
                                    }
                                    SLog.v(TAG, "buildWhiteListMap: add to whiteList[%s]: %s", str2, nextText);
                                    str3 = str2;
                                    break;
                                } else {
                                    str3 = str2;
                                    break;
                                }
                                break;
                        }
                        xml.next();
                        eventType = xml.getEventType();
                        i3++;
                        if (i3 > 10000) {
                            SLog.e(TAG, "buildWhiteListMap:maybe dead loop!!", new Object[0]);
                        }
                    }
                }
                addToNative(str, hashMap);
            } catch (XmlPullParserException e2) {
                SLog.w(TAG, "buildWhiteListSet: exp=%s", e2.getLocalizedMessage());
            } catch (IOException e3) {
                SLog.w(TAG, "buildWhiteListSet: exp=%s", e3.getLocalizedMessage());
            }
            xml.close();
            AppMethodBeat.o(52818);
        } catch (Exception e4) {
            SLog.w(TAG, "buildWhiteListSet: getResources exp=%s", e4.getLocalizedMessage());
            AppMethodBeat.o(52818);
        }
    }

    private static void addToNative(String str, Map<String, List<String>> map) {
        AppMethodBeat.i(52819);
        if (map == null) {
            AppMethodBeat.o(52819);
            return;
        }
        String[] strArr = new String[map.size()];
        String[][] strArr2 = new String[map.size()][];
        int i2 = 0;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            strArr[i2] = entry.getKey();
            List<String> value = entry.getValue();
            strArr2[i2] = new String[value.size()];
            for (int i3 = 0; i3 < value.size(); i3++) {
                strArr2[i2][i3] = value.get(i3);
            }
            i2++;
        }
        SQLiteLintNativeBridge.nativeAddToWhiteList(str, strArr, strArr2);
        AppMethodBeat.o(52819);
    }
}
