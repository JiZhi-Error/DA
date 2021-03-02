package com.tencent.luggage.h;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.v4.app.a;
import android.support.v4.content.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class i {
    public static boolean a(final Activity activity, final String str, final int i2, String str2, String str3) {
        AppMethodBeat.i(140519);
        if (Build.VERSION.SDK_INT >= 23 || "MNC".equals(Build.VERSION.CODENAME)) {
            try {
                if (b.checkSelfPermission(activity, str) == 0) {
                    AppMethodBeat.o(140519);
                    return true;
                }
                if (!Util.isNullOrNil(str3)) {
                    AnonymousClass1 r0 = new DialogInterface.OnClickListener() {
                        /* class com.tencent.luggage.h.i.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(140518);
                            dialogInterface.dismiss();
                            a.a(activity, new String[]{str}, i2);
                            AppMethodBeat.o(140518);
                        }
                    };
                    String string = activity.getString(R.string.fl4);
                    String string2 = activity.getString(R.string.fl3);
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setMessage(str3).setTitle(str2).setCancelable(false).setPositiveButton(string, r0).setNegativeButton(string2, (DialogInterface.OnClickListener) null);
                    builder.show();
                } else {
                    a.a(activity, new String[]{str}, i2);
                }
                AppMethodBeat.o(140519);
                return false;
            } catch (Exception e2) {
                Log.e("Luggage.PermissionUtil", "check mpermission exception:%s.", e2);
                AppMethodBeat.o(140519);
                return true;
            }
        } else {
            AppMethodBeat.o(140519);
            return true;
        }
    }

    public static boolean n(Context context, String str) {
        int i2;
        AppMethodBeat.i(140520);
        try {
            int checkSelfPermission = b.checkSelfPermission(context, str);
            if (checkSelfPermission != 0) {
                AppMethodBeat.o(140520);
                return false;
            }
            String str2 = null;
            if (str.equals("android.permission.READ_CONTACTS")) {
                str2 = "android.permission.WRITE_CONTACTS";
            } else if (str.equals("android.permission.WRITE_CONTACTS")) {
                str2 = "android.permission.READ_CONTACTS";
            }
            if (!Util.isNullOrNil(str2)) {
                try {
                    i2 = b.checkSelfPermission(context, str2);
                } catch (Exception e2) {
                    Log.e("Luggage.PermissionUtil", "check mpermission otherPermisson exception:%s.", e2);
                    AppMethodBeat.o(140520);
                    return false;
                }
            } else {
                i2 = checkSelfPermission;
            }
            if (i2 == 0) {
                AppMethodBeat.o(140520);
                return true;
            }
            AppMethodBeat.o(140520);
            return false;
        } catch (Exception e3) {
            Log.e("Luggage.PermissionUtil", "check mpermission exception:%s.", e3);
            AppMethodBeat.o(140520);
            return false;
        }
    }
}
