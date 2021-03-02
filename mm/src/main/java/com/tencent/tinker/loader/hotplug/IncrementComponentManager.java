package com.tencent.tinker.loader.hotplug;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.ServerProtocol;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerLog;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.util.HashMap;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class IncrementComponentManager {
    private static final AttrTranslator<ActivityInfo> ACTIVITY_INFO_ATTR_TRANSLATOR = new AttrTranslator<ActivityInfo>() {
        /* class com.tencent.tinker.loader.hotplug.IncrementComponentManager.AnonymousClass1 */

        /* access modifiers changed from: package-private */
        @Override // com.tencent.tinker.loader.hotplug.IncrementComponentManager.AttrTranslator
        public final void onInit(Context context, int i2, XmlPullParser xmlPullParser) {
            if (i2 == 0) {
                try {
                    if (xmlPullParser.getEventType() != 2 || !EnvConsts.ACTIVITY_MANAGER_SRVNAME.equals(xmlPullParser.getName())) {
                        throw new IllegalStateException("unexpected xml parser state when parsing incremental component manifest.");
                    }
                } catch (XmlPullParserException e2) {
                    throw new IllegalStateException(e2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void onTranslate(Context context, int i2, String str, String str2, ActivityInfo activityInfo) {
            int i3 = 0;
            if ("name".equals(str)) {
                if (str2.charAt(0) == '.') {
                    activityInfo.name = context.getPackageName() + str2;
                } else {
                    activityInfo.name = str2;
                }
            } else if ("parentActivityName".equals(str)) {
                if (Build.VERSION.SDK_INT < 16) {
                    return;
                }
                if (str2.charAt(0) == '.') {
                    activityInfo.parentActivityName = context.getPackageName() + str2;
                } else {
                    activityInfo.parentActivityName = str2;
                }
            } else if ("exported".equals(str)) {
                activityInfo.exported = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2);
            } else if ("launchMode".equals(str)) {
                activityInfo.launchMode = parseLaunchMode(str2);
            } else if ("theme".equals(str)) {
                activityInfo.theme = context.getResources().getIdentifier(str2, AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, context.getPackageName());
            } else if ("uiOptions".equals(str)) {
                if (Build.VERSION.SDK_INT >= 14) {
                    activityInfo.uiOptions = Integer.decode(str2).intValue();
                }
            } else if ("permission".equals(str)) {
                activityInfo.permission = str2;
            } else if ("taskAffinity".equals(str)) {
                activityInfo.taskAffinity = str2;
            } else if ("multiprocess".equals(str)) {
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 1;
                } else {
                    activityInfo.flags &= -2;
                }
            } else if ("finishOnTaskLaunch".equals(str)) {
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 2;
                } else {
                    activityInfo.flags &= -3;
                }
            } else if ("clearTaskOnLaunch".equals(str)) {
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 4;
                } else {
                    activityInfo.flags &= -5;
                }
            } else if ("noHistory".equals(str)) {
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 128;
                } else {
                    activityInfo.flags &= -129;
                }
            } else if ("alwaysRetainTaskState".equals(str)) {
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 8;
                } else {
                    activityInfo.flags &= -9;
                }
            } else if ("stateNotNeeded".equals(str)) {
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 16;
                } else {
                    activityInfo.flags &= -17;
                }
            } else if ("excludeFromRecents".equals(str)) {
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 32;
                } else {
                    activityInfo.flags &= -33;
                }
            } else if ("allowTaskReparenting".equals(str)) {
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 64;
                } else {
                    activityInfo.flags &= -65;
                }
            } else if ("finishOnCloseSystemDialogs".equals(str)) {
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 256;
                } else {
                    activityInfo.flags &= -257;
                }
            } else if ("showOnLockScreen".equals(str) || "showForAllUsers".equals(str)) {
                if (Build.VERSION.SDK_INT >= 23) {
                    int valueOfStaticIntField = ShareReflectUtil.getValueOfStaticIntField(ActivityInfo.class, "FLAG_SHOW_FOR_ALL_USERS", 0);
                    if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                        activityInfo.flags = valueOfStaticIntField | activityInfo.flags;
                        return;
                    }
                    activityInfo.flags = (valueOfStaticIntField ^ -1) & activityInfo.flags;
                }
            } else if ("immersive".equals(str)) {
                if (Build.VERSION.SDK_INT < 18) {
                    return;
                }
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 2048;
                } else {
                    activityInfo.flags &= -2049;
                }
            } else if ("hardwareAccelerated".equals(str)) {
                if (Build.VERSION.SDK_INT < 11) {
                    return;
                }
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 512;
                } else {
                    activityInfo.flags &= -513;
                }
            } else if ("documentLaunchMode".equals(str)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    activityInfo.documentLaunchMode = Integer.decode(str2).intValue();
                }
            } else if ("maxRecents".equals(str)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    activityInfo.maxRecents = Integer.decode(str2).intValue();
                }
            } else if ("configChanges".equals(str)) {
                activityInfo.configChanges = Integer.decode(str2).intValue();
            } else if ("windowSoftInputMode".equals(str)) {
                activityInfo.softInputMode = Integer.decode(str2).intValue();
            } else if ("persistableMode".equals(str)) {
                if (Build.VERSION.SDK_INT >= 21) {
                    activityInfo.persistableMode = Integer.decode(str2).intValue();
                }
            } else if ("allowEmbedded".equals(str)) {
                int valueOfStaticIntField2 = ShareReflectUtil.getValueOfStaticIntField(ActivityInfo.class, "FLAG_ALLOW_EMBEDDED", 0);
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                    activityInfo.flags = valueOfStaticIntField2 | activityInfo.flags;
                    return;
                }
                activityInfo.flags = (valueOfStaticIntField2 ^ -1) & activityInfo.flags;
            } else if ("autoRemoveFromRecents".equals(str)) {
                if (Build.VERSION.SDK_INT < 21) {
                    return;
                }
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 8192;
                } else {
                    activityInfo.flags &= -8193;
                }
            } else if ("relinquishTaskIdentity".equals(str)) {
                if (Build.VERSION.SDK_INT < 21) {
                    return;
                }
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 4096;
                } else {
                    activityInfo.flags &= -4097;
                }
            } else if ("resumeWhilePausing".equals(str)) {
                if (Build.VERSION.SDK_INT < 21) {
                    return;
                }
                if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str2)) {
                    activityInfo.flags |= 16384;
                } else {
                    activityInfo.flags &= -16385;
                }
            } else if ("screenOrientation".equals(str)) {
                activityInfo.screenOrientation = parseScreenOrientation(str2);
            } else if ("label".equals(str)) {
                try {
                    i3 = context.getResources().getIdentifier(str2, "string", IncrementComponentManager.sPackageName);
                } catch (Throwable th) {
                }
                if (i3 != 0) {
                    activityInfo.labelRes = i3;
                } else {
                    activityInfo.nonLocalizedLabel = str2;
                }
            } else if ("icon".equals(str)) {
                try {
                    activityInfo.icon = context.getResources().getIdentifier(str2, null, IncrementComponentManager.sPackageName);
                } catch (Throwable th2) {
                }
            } else if ("banner".equals(str)) {
                if (Build.VERSION.SDK_INT >= 20) {
                    try {
                        activityInfo.banner = context.getResources().getIdentifier(str2, null, IncrementComponentManager.sPackageName);
                    } catch (Throwable th3) {
                    }
                }
            } else if ("logo".equals(str)) {
                try {
                    activityInfo.logo = context.getResources().getIdentifier(str2, null, IncrementComponentManager.sPackageName);
                } catch (Throwable th4) {
                }
            }
        }

        private int parseLaunchMode(String str) {
            if ("standard".equalsIgnoreCase(str)) {
                return 0;
            }
            if ("singleTop".equalsIgnoreCase(str)) {
                return 1;
            }
            if ("singleTask".equalsIgnoreCase(str)) {
                return 2;
            }
            if ("singleInstance".equalsIgnoreCase(str)) {
                return 3;
            }
            ShareTinkerLog.w(IncrementComponentManager.TAG, "Unknown launchMode: ".concat(String.valueOf(str)), new Object[0]);
            return 0;
        }

        private int parseScreenOrientation(String str) {
            if ("unspecified".equalsIgnoreCase(str)) {
                return -1;
            }
            if ("behind".equalsIgnoreCase(str)) {
                return 3;
            }
            if ("landscape".equalsIgnoreCase(str)) {
                return 0;
            }
            if ("portrait".equalsIgnoreCase(str)) {
                return 1;
            }
            if ("reverseLandscape".equalsIgnoreCase(str)) {
                return 8;
            }
            if ("reversePortrait".equalsIgnoreCase(str)) {
                return 9;
            }
            if ("sensorLandscape".equalsIgnoreCase(str)) {
                return 6;
            }
            if ("sensorPortrait".equalsIgnoreCase(str)) {
                return 7;
            }
            if ("sensor".equalsIgnoreCase(str)) {
                return 4;
            }
            if ("fullSensor".equalsIgnoreCase(str)) {
                return 10;
            }
            if ("nosensor".equalsIgnoreCase(str)) {
                return 5;
            }
            if ("user".equalsIgnoreCase(str)) {
                return 2;
            }
            if (Build.VERSION.SDK_INT >= 18 && "fullUser".equalsIgnoreCase(str)) {
                return 13;
            }
            if (Build.VERSION.SDK_INT >= 18 && "locked".equalsIgnoreCase(str)) {
                return 14;
            }
            if (Build.VERSION.SDK_INT >= 18 && "userLandscape".equalsIgnoreCase(str)) {
                return 11;
            }
            if (Build.VERSION.SDK_INT < 18 || !"userPortrait".equalsIgnoreCase(str)) {
                return -1;
            }
            return 12;
        }
    };
    private static final Map<String, ActivityInfo> CLASS_NAME_TO_ACTIVITY_INFO_MAP = new HashMap();
    private static final Map<String, IntentFilter> CLASS_NAME_TO_INTENT_FILTER_MAP = new HashMap();
    private static final String TAG = "Tinker.IncrementCompMgr";
    private static final int TAG_ACTIVITY = 0;
    private static final int TAG_PROVIDER = 2;
    private static final int TAG_RECEIVER = 3;
    private static final int TAG_SERVICE = 1;
    private static Context sContext = null;
    private static volatile boolean sInitialized = false;
    private static String sPackageName = null;

    /* access modifiers changed from: package-private */
    public static abstract class AttrTranslator<T_RESULT> {
        /* access modifiers changed from: package-private */
        public abstract void onTranslate(Context context, int i2, String str, String str2, T_RESULT t_result);

        private AttrTranslator() {
        }

        /* access modifiers changed from: package-private */
        public final void translate(Context context, int i2, XmlPullParser xmlPullParser, T_RESULT t_result) {
            onInit(context, i2, xmlPullParser);
            int attributeCount = xmlPullParser.getAttributeCount();
            for (int i3 = 0; i3 < attributeCount; i3++) {
                if ("android".equals(xmlPullParser.getAttributePrefix(i3))) {
                    onTranslate(context, i2, xmlPullParser.getAttributeName(i3), xmlPullParser.getAttributeValue(i3), t_result);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void onInit(Context context, int i2, XmlPullParser xmlPullParser) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a9, code lost:
        r1 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00be, code lost:
        r1 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00bf, code lost:
        r2 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a9 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:14:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized boolean init(android.content.Context r9, com.tencent.tinker.loader.shareutil.ShareSecurityCheck r10) {
        /*
        // Method dump skipped, instructions count: 202
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.IncrementComponentManager.init(android.content.Context, com.tencent.tinker.loader.shareutil.ShareSecurityCheck):boolean");
    }

    private static synchronized ActivityInfo parseActivity(Context context, XmlPullParser xmlPullParser) {
        ActivityInfo activityInfo;
        synchronized (IncrementComponentManager.class) {
            activityInfo = new ActivityInfo();
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            activityInfo.applicationInfo = applicationInfo;
            activityInfo.packageName = sPackageName;
            activityInfo.processName = applicationInfo.processName;
            activityInfo.launchMode = 0;
            activityInfo.permission = applicationInfo.permission;
            activityInfo.screenOrientation = -1;
            activityInfo.taskAffinity = applicationInfo.taskAffinity;
            if (Build.VERSION.SDK_INT >= 11 && (applicationInfo.flags & 536870912) != 0) {
                activityInfo.flags |= 512;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                activityInfo.documentLaunchMode = 0;
            }
            if (Build.VERSION.SDK_INT >= 14) {
                activityInfo.uiOptions = applicationInfo.uiOptions;
            }
            ACTIVITY_INFO_ATTR_TRANSLATOR.translate(context, 0, xmlPullParser, activityInfo);
            int depth = xmlPullParser.getDepth();
            while (true) {
                int next = xmlPullParser.next();
                if (next != 1 && (next != 3 || xmlPullParser.getDepth() > depth)) {
                    if (!(next == 3 || next == 4)) {
                        String name = xmlPullParser.getName();
                        if ("intent-filter".equalsIgnoreCase(name)) {
                            parseIntentFilter(context, activityInfo.name, xmlPullParser);
                        } else if ("meta-data".equalsIgnoreCase(name)) {
                            parseMetaData(context, activityInfo, xmlPullParser);
                        }
                    }
                }
            }
        }
        return activityInfo;
    }

    private static synchronized void parseIntentFilter(Context context, String str, XmlPullParser xmlPullParser) {
        synchronized (IncrementComponentManager.class) {
            IntentFilter intentFilter = new IntentFilter();
            String attributeValue = xmlPullParser.getAttributeValue(null, DownloadInfo.PRIORITY);
            if (!TextUtils.isEmpty(attributeValue)) {
                intentFilter.setPriority(Integer.decode(attributeValue).intValue());
            }
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "autoVerify");
            if (!TextUtils.isEmpty(attributeValue2)) {
                try {
                    ShareReflectUtil.findMethod((Class<?>) IntentFilter.class, "setAutoVerify", (Class<?>[]) new Class[]{Boolean.TYPE}).invoke(intentFilter, Boolean.valueOf(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(attributeValue2)));
                } catch (Throwable th) {
                }
            }
            int depth = xmlPullParser.getDepth();
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                    CLASS_NAME_TO_INTENT_FILTER_MAP.put(str, intentFilter);
                } else if (!(next == 3 || next == 4)) {
                    String name = xmlPullParser.getName();
                    if (NativeProtocol.WEB_DIALOG_ACTION.equals(name)) {
                        String attributeValue3 = xmlPullParser.getAttributeValue(null, "name");
                        if (attributeValue3 != null) {
                            intentFilter.addAction(attributeValue3);
                        }
                    } else if ("category".equals(name)) {
                        String attributeValue4 = xmlPullParser.getAttributeValue(null, "name");
                        if (attributeValue4 != null) {
                            intentFilter.addCategory(attributeValue4);
                        }
                    } else if ("data".equals(name)) {
                        String attributeValue5 = xmlPullParser.getAttributeValue(null, "mimeType");
                        if (attributeValue5 != null) {
                            try {
                                intentFilter.addDataType(attributeValue5);
                            } catch (IntentFilter.MalformedMimeTypeException e2) {
                                throw new XmlPullParserException("bad mimeType", xmlPullParser, e2);
                            }
                        }
                        String attributeValue6 = xmlPullParser.getAttributeValue(null, "scheme");
                        if (attributeValue6 != null) {
                            intentFilter.addDataScheme(attributeValue6);
                        }
                        if (Build.VERSION.SDK_INT >= 19) {
                            String attributeValue7 = xmlPullParser.getAttributeValue(null, "ssp");
                            if (attributeValue7 != null) {
                                intentFilter.addDataSchemeSpecificPart(attributeValue7, 0);
                            }
                            String attributeValue8 = xmlPullParser.getAttributeValue(null, "sspPrefix");
                            if (attributeValue8 != null) {
                                intentFilter.addDataSchemeSpecificPart(attributeValue8, 1);
                            }
                            String attributeValue9 = xmlPullParser.getAttributeValue(null, "sspPattern");
                            if (attributeValue9 != null) {
                                intentFilter.addDataSchemeSpecificPart(attributeValue9, 2);
                            }
                        }
                        String attributeValue10 = xmlPullParser.getAttributeValue(null, "host");
                        String attributeValue11 = xmlPullParser.getAttributeValue(null, "port");
                        if (attributeValue10 != null) {
                            intentFilter.addDataAuthority(attributeValue10, attributeValue11);
                        }
                        String attributeValue12 = xmlPullParser.getAttributeValue(null, "path");
                        if (attributeValue12 != null) {
                            intentFilter.addDataPath(attributeValue12, 0);
                        }
                        String attributeValue13 = xmlPullParser.getAttributeValue(null, "pathPrefix");
                        if (attributeValue13 != null) {
                            intentFilter.addDataPath(attributeValue13, 1);
                        }
                        String attributeValue14 = xmlPullParser.getAttributeValue(null, "pathPattern");
                        if (attributeValue14 != null) {
                            intentFilter.addDataPath(attributeValue14, 2);
                        }
                    }
                    skipCurrentTag(xmlPullParser);
                }
            }
            CLASS_NAME_TO_INTENT_FILTER_MAP.put(str, intentFilter);
        }
    }

    private static synchronized void parseMetaData(Context context, ActivityInfo activityInfo, XmlPullParser xmlPullParser) {
        synchronized (IncrementComponentManager.class) {
            ClassLoader classLoader = IncrementComponentManager.class.getClassLoader();
            String attributeValue = xmlPullParser.getAttributeValue(null, "name");
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "value");
            if (!TextUtils.isEmpty(attributeValue)) {
                if (activityInfo.metaData == null) {
                    activityInfo.metaData = new Bundle(classLoader);
                }
                activityInfo.metaData.putString(attributeValue, attributeValue2);
            }
        }
    }

    private static void skipCurrentTag(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            if (next == 3 && xmlPullParser.getDepth() <= depth) {
                return;
            }
        }
    }

    private static synchronized void ensureInitialized() {
        synchronized (IncrementComponentManager.class) {
            if (!sInitialized) {
                throw new IllegalStateException("Not initialized!!");
            }
        }
    }

    public static boolean isIncrementActivity(String str) {
        ensureInitialized();
        return str != null && CLASS_NAME_TO_ACTIVITY_INFO_MAP.containsKey(str);
    }

    public static ActivityInfo queryActivityInfo(String str) {
        ensureInitialized();
        if (str != null) {
            return CLASS_NAME_TO_ACTIVITY_INFO_MAP.get(str);
        }
        return null;
    }

    public static ResolveInfo resolveIntent(Intent intent) {
        String str;
        ensureInitialized();
        int i2 = -1;
        IntentFilter intentFilter = null;
        int i3 = 0;
        ComponentName component = intent.getComponent();
        if (component != null) {
            str = component.getClassName();
            if (CLASS_NAME_TO_ACTIVITY_INFO_MAP.containsKey(str)) {
                i2 = 0;
            } else {
                str = null;
            }
        } else {
            String str2 = null;
            for (Map.Entry<String, IntentFilter> entry : CLASS_NAME_TO_INTENT_FILTER_MAP.entrySet()) {
                String key = entry.getKey();
                IntentFilter value = entry.getValue();
                int match = value.match(intent.getAction(), intent.getType(), intent.getScheme(), intent.getData(), intent.getCategories(), TAG);
                boolean z = match != -3 && match != -4 && match != -2 && match != -1;
                i2 = value.getPriority();
                if (!z || i2 <= i2) {
                    match = i3;
                    value = intentFilter;
                    key = str2;
                    i2 = i2;
                }
                i3 = match;
                intentFilter = value;
                str2 = key;
            }
            str = str2;
            i2 = i2;
        }
        if (str == null) {
            return null;
        }
        ResolveInfo resolveInfo = new ResolveInfo();
        resolveInfo.activityInfo = CLASS_NAME_TO_ACTIVITY_INFO_MAP.get(str);
        resolveInfo.filter = intentFilter;
        resolveInfo.match = i3;
        resolveInfo.priority = i2;
        resolveInfo.resolvePackageName = sPackageName;
        resolveInfo.icon = resolveInfo.activityInfo.icon;
        resolveInfo.labelRes = resolveInfo.activityInfo.labelRes;
        return resolveInfo;
    }

    private IncrementComponentManager() {
        throw new UnsupportedOperationException();
    }
}
