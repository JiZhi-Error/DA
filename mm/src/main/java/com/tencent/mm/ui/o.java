package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.recovery.wx.util.WXUtil;

public final class o {
    Runnable jNB;
    private boolean kgv = true;

    private static boolean gIy() {
        AppMethodBeat.i(161503);
        g.aAf();
        boolean azo = a.azo();
        String aA = bf.iDu.aA(WXUtil.LAST_LOGIN_USERNAME, "");
        if (azo || !aA.equals("")) {
            AppMethodBeat.o(161503);
            return false;
        }
        AppMethodBeat.o(161503);
        return true;
    }

    public final boolean bc(Activity activity) {
        AppMethodBeat.i(33366);
        if (!this.kgv) {
            AppMethodBeat.o(33366);
            return true;
        }
        this.kgv = false;
        SharedPreferences sharedPreferences = activity.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0);
        boolean z = sharedPreferences.getBoolean("SP_PERMISSION_HAD_REQUEST_PERMISSION_STORAGE", false);
        int i2 = sharedPreferences.getInt("SP_PERMISSION_HAD_REQUEST_PERMISSION_UID", Integer.MIN_VALUE);
        if ((!z || MMApplicationContext.getContext().getApplicationInfo().uid != i2) && (!gIy() || !g.aAe().azG().aBb())) {
            boolean a2 = b.a(activity, "android.permission.WRITE_EXTERNAL_STORAGE", 33, "", "");
            Log.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "check resume, summerper checkPermission checkStorage[%b]", Boolean.valueOf(a2));
            sharedPreferences.edit().putBoolean("SP_PERMISSION_HAD_REQUEST_PERMISSION_STORAGE", true).apply();
            sharedPreferences.edit().putInt("SP_PERMISSION_HAD_REQUEST_PERMISSION_UID", MMApplicationContext.getContext().getApplicationInfo().uid).apply();
            if (!a2) {
                AppMethodBeat.o(33366);
                return false;
            }
            AppMethodBeat.o(33366);
            return true;
        }
        Log.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "ingore check permission on resume, %b, %d", Boolean.valueOf(z), Integer.valueOf(i2));
        AppMethodBeat.o(33366);
        return true;
    }

    public static boolean gIz() {
        AppMethodBeat.i(163278);
        Log.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "ingore check permission on init");
        AppMethodBeat.o(163278);
        return true;
    }

    public final boolean a(final Activity activity, final int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(33368);
        if (iArr == null || iArr.length <= 0) {
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(iArr == null ? -1 : iArr.length);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = strArr;
            objArr[3] = Util.getStack();
            Log.w("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "onRequestPermissionsResult, grantResults length is:%d requestCode:%d, permissions:%s, stack:%s", objArr);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.ui.o.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(33360);
                    if (o.this.jNB != null) {
                        o.this.jNB.run();
                    }
                    AppMethodBeat.o(33360);
                }

                public final String toString() {
                    AppMethodBeat.i(33361);
                    String str = super.toString() + "|onInitDelay";
                    AppMethodBeat.o(33361);
                    return str;
                }
            }, 500);
            AppMethodBeat.o(33368);
            return true;
        }
        Log.i("MicroMsg.LauncherUI.LauncherUICheckPermissionHelper", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", Integer.valueOf(i2), Integer.valueOf(iArr[0]), Long.valueOf(Thread.currentThread().getId()));
        switch (i2) {
            case 32:
            case 64:
            case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*{ENCODED_INT: 96}*/:
                int i3 = R.string.fln;
                if (i2 == 96) {
                    i3 = R.string.flc;
                } else if (i2 == 64) {
                    i3 = R.string.fl_;
                }
                if (iArr[0] == 0) {
                    if (i2 == 32) {
                        e.INSTANCE.idkeyStat(462, 0, 1, true);
                    } else if (i2 == 96) {
                        e.INSTANCE.idkeyStat(462, 1, 1, true);
                        q.aoH();
                        q.aoy();
                    } else {
                        e.INSTANCE.idkeyStat(462, 2, 1, true);
                    }
                    if (this.jNB != null) {
                        this.jNB.run();
                    }
                } else {
                    h.a((Context) activity, activity.getString(i3), activity.getString(R.string.flp), activity.getString(R.string.e_k), activity.getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.o.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(33362);
                            if (i2 == 32) {
                                e.INSTANCE.idkeyStat(462, 3, 1, true);
                            } else if (i2 == 96) {
                                e.INSTANCE.idkeyStat(462, 4, 1, true);
                            } else {
                                e.INSTANCE.idkeyStat(462, 5, 1, true);
                            }
                            Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                            intent.addFlags(268435456);
                            Activity activity = activity;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/LauncherUICheckPermissionHelper$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            activity.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/LauncherUICheckPermissionHelper$2", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            dialogInterface.dismiss();
                            activity.finish();
                            AppMethodBeat.o(33362);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.o.AnonymousClass3 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(33363);
                            if (i2 == 32) {
                                e.INSTANCE.idkeyStat(462, 6, 1, true);
                            } else if (i2 == 96) {
                                e.INSTANCE.idkeyStat(462, 7, 1, true);
                            } else {
                                e.INSTANCE.idkeyStat(462, 8, 1, true);
                            }
                            dialogInterface.dismiss();
                            activity.finish();
                            AppMethodBeat.o(33363);
                        }
                    });
                }
                AppMethodBeat.o(33368);
                return true;
            case 33:
            case 70:
            case PlayerException.EXCEPTION_IN_RELEASE /*{ENCODED_INT: 97}*/:
                int i4 = R.string.fln;
                if (i2 == 97) {
                    i4 = R.string.flc;
                } else if (i2 == 70) {
                    i4 = R.string.fl_;
                }
                if (iArr[0] != 0) {
                    this.kgv = false;
                    h.a((Context) activity, activity.getString(i4), activity.getString(R.string.flp), activity.getString(R.string.e_k), activity.getString(R.string.amn), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.o.AnonymousClass4 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(33364);
                            if (i2 == 33) {
                                e.INSTANCE.idkeyStat(462, 12, 1, true);
                            } else if (i2 == 97) {
                                e.INSTANCE.idkeyStat(462, 13, 1, true);
                            } else {
                                e.INSTANCE.idkeyStat(462, 14, 1, true);
                            }
                            Intent intent = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
                            intent.addFlags(268435456);
                            Activity activity = activity;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/ui/LauncherUICheckPermissionHelper$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            activity.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/ui/LauncherUICheckPermissionHelper$4", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            dialogInterface.dismiss();
                            AppMethodBeat.o(33364);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.o.AnonymousClass5 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(33365);
                            if (i2 == 33) {
                                e.INSTANCE.idkeyStat(462, 15, 1, true);
                            } else if (i2 == 97) {
                                e.INSTANCE.idkeyStat(462, 16, 1, true);
                            } else {
                                e.INSTANCE.idkeyStat(462, 17, 1, true);
                            }
                            dialogInterface.dismiss();
                            AppMethodBeat.o(33365);
                        }
                    });
                } else if (i2 == 33) {
                    e.INSTANCE.idkeyStat(462, 9, 1, true);
                } else if (i2 == 97) {
                    e.INSTANCE.idkeyStat(462, 10, 1, true);
                } else {
                    e.INSTANCE.idkeyStat(462, 11, 1, true);
                }
                AppMethodBeat.o(33368);
                return true;
            default:
                AppMethodBeat.o(33368);
                return false;
        }
    }
}
