package com.tencent.mm.accessibility;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public class Util {
    public static Activity getActivityOfView(View view) {
        AppMethodBeat.i(160019);
        if (view == null) {
            AppMethodBeat.o(160019);
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                AppMethodBeat.o(160019);
                return activity;
            }
        }
        AppMethodBeat.o(160019);
        return null;
    }

    public static boolean resourceHasPackage(int i2) {
        return (i2 >>> 24) != 0;
    }

    public static String getViewIdName(View view) {
        String str;
        AppMethodBeat.i(160020);
        if (view == null) {
            AppMethodBeat.o(160020);
            return "NO_ID";
        }
        int id = view.getId();
        StringBuilder sb = new StringBuilder(128);
        if (id != -1) {
            Resources resources = view.getResources();
            if (resourceHasPackage(id) && resources != null) {
                switch (-16777216 & id) {
                    case TPMediaCodecProfileLevel.HEVCMainTierLevel62 /*{ENCODED_INT: 16777216}*/:
                        str = "android";
                        String resourceTypeName = resources.getResourceTypeName(id);
                        String resourceEntryName = resources.getResourceEntryName(id);
                        sb.append(" ");
                        sb.append(str);
                        sb.append(":");
                        sb.append(resourceTypeName);
                        sb.append(FilePathGenerator.ANDROID_DIR_SEP);
                        sb.append(resourceEntryName);
                        break;
                    case 2130706432:
                        str = "app";
                        String resourceTypeName2 = resources.getResourceTypeName(id);
                        String resourceEntryName2 = resources.getResourceEntryName(id);
                        sb.append(" ");
                        sb.append(str);
                        sb.append(":");
                        sb.append(resourceTypeName2);
                        sb.append(FilePathGenerator.ANDROID_DIR_SEP);
                        sb.append(resourceEntryName2);
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            String resourceTypeName22 = resources.getResourceTypeName(id);
                            String resourceEntryName22 = resources.getResourceEntryName(id);
                            sb.append(" ");
                            sb.append(str);
                            sb.append(":");
                            sb.append(resourceTypeName22);
                            sb.append(FilePathGenerator.ANDROID_DIR_SEP);
                            sb.append(resourceEntryName22);
                            break;
                        } catch (Throwable th) {
                            break;
                        }
                }
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(160020);
        return sb2;
    }
}
