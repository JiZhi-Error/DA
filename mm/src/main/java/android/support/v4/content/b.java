package android.support.v4.content;

import android.accessibilityservice.AccessibilityService;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import java.io.File;
import java.util.HashMap;

public class b {
    private static TypedValue IX;
    private static final Object sLock = new Object();

    public static boolean a(Context context, Intent[] intentArr) {
        if (Build.VERSION.SDK_INT >= 16) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(null).bl(intentArr);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "android/support/v4/content/ContextCompat", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)Z", "Undefined", "startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V");
            context.startActivities((Intent[]) bl.pG(0), (Bundle) bl.pG(1));
            com.tencent.mm.hellhoundlib.a.a.a(context, "android/support/v4/content/ContextCompat", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)Z", "Undefined", "startActivities", "([Landroid/content/Intent;Landroid/os/Bundle;)V");
        } else {
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intentArr);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "android/support/v4/content/ContextCompat", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)Z", "Undefined", "startActivities", "([Landroid/content/Intent;)V");
            context.startActivities((Intent[]) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "android/support/v4/content/ContextCompat", "startActivities", "(Landroid/content/Context;[Landroid/content/Intent;Landroid/os/Bundle;)Z", "Undefined", "startActivities", "([Landroid/content/Intent;)V");
        }
        return true;
    }

    public static void startActivity(Context context, Intent intent, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bundle).bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "android/support/v4/content/ContextCompat", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
            context.startActivity((Intent) bl.pG(0), (Bundle) bl.pG(1));
            com.tencent.mm.hellhoundlib.a.a.a(context, "android/support/v4/content/ContextCompat", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;Landroid/os/Bundle;)V");
            return;
        }
        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "android/support/v4/content/ContextCompat", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl2.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "android/support/v4/content/ContextCompat", "startActivity", "(Landroid/content/Context;Landroid/content/Intent;Landroid/os/Bundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }

    public static File[] S(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getExternalFilesDirs(null);
        }
        return new File[]{context.getExternalFilesDir(null)};
    }

    public static File[] T(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return context.getExternalCacheDirs();
        }
        return new File[]{context.getExternalCacheDir()};
    }

    public static Drawable l(Context context, int i2) {
        int i3;
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getDrawable(i2);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return context.getResources().getDrawable(i2);
        }
        synchronized (sLock) {
            if (IX == null) {
                IX = new TypedValue();
            }
            context.getResources().getValue(i2, IX, true);
            i3 = IX.resourceId;
        }
        return context.getResources().getDrawable(i3);
    }

    public static ColorStateList m(Context context, @android.support.annotation.a int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i2);
        }
        return context.getResources().getColorStateList(i2);
    }

    public static int n(Context context, @android.support.annotation.a int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.getColor(i2);
        }
        return context.getResources().getColor(i2);
    }

    public static int checkSelfPermission(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static File U(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            return context.getNoBackupFilesDir();
        }
        return n(new File(context.getApplicationInfo().dataDir, "no_backup"));
    }

    private static synchronized File n(File file) {
        synchronized (b.class) {
            if (!file.exists() && !file.mkdirs() && !file.exists()) {
                new StringBuilder("Unable to create files subdir ").append(file.getPath());
                file = null;
            }
        }
        return file;
    }

    public static boolean V(Context context) {
        if (Build.VERSION.SDK_INT >= 24) {
            return context.isDeviceProtectedStorage();
        }
        return false;
    }

    public static <T> T a(Context context, Class<T> cls) {
        String str;
        if (Build.VERSION.SDK_INT >= 23) {
            return (T) context.getSystemService(cls);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            str = context.getSystemServiceName(cls);
        } else {
            str = a.IY.get(cls);
        }
        if (str != null) {
            return (T) context.getSystemService(str);
        }
        return null;
    }

    static final class a {
        static final HashMap<Class<?>, String> IY = new HashMap<>();

        static {
            if (Build.VERSION.SDK_INT > 22) {
                IY.put(SubscriptionManager.class, "telephony_subscription_service");
                IY.put(UsageStatsManager.class, "usagestats");
            }
            if (Build.VERSION.SDK_INT > 21) {
                IY.put(AppWidgetManager.class, "appwidget");
                IY.put(BatteryManager.class, "batterymanager");
                IY.put(CameraManager.class, "camera");
                IY.put(JobScheduler.class, "jobscheduler");
                IY.put(LauncherApps.class, "launcherapps");
                IY.put(MediaProjectionManager.class, "media_projection");
                IY.put(MediaSessionManager.class, "media_session");
                IY.put(RestrictionsManager.class, "restrictions");
                IY.put(TelecomManager.class, "telecom");
                IY.put(TvInputManager.class, "tv_input");
            }
            if (Build.VERSION.SDK_INT > 19) {
                IY.put(AppOpsManager.class, "appops");
                IY.put(CaptioningManager.class, "captioning");
                IY.put(ConsumerIrManager.class, "consumer_ir");
                IY.put(PrintManager.class, SharePatchInfo.FINGER_PRINT);
            }
            if (Build.VERSION.SDK_INT > 18) {
                IY.put(BluetoothManager.class, "bluetooth");
            }
            if (Build.VERSION.SDK_INT > 17) {
                IY.put(DisplayManager.class, ServerProtocol.DIALOG_PARAM_DISPLAY);
                IY.put(UserManager.class, "user");
            }
            if (Build.VERSION.SDK_INT > 16) {
                IY.put(InputManager.class, "input");
                IY.put(MediaRouter.class, "media_router");
                IY.put(NsdManager.class, "servicediscovery");
            }
            IY.put(AccessibilityService.class, "accessibility");
            IY.put(AccountManager.class, "account");
            IY.put(ActivityManager.class, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            IY.put(AlarmManager.class, "alarm");
            IY.put(AudioManager.class, SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
            IY.put(ClipboardManager.class, "clipboard");
            IY.put(ConnectivityManager.class, "connectivity");
            IY.put(DevicePolicyManager.class, "device_policy");
            IY.put(DownloadManager.class, "download");
            IY.put(DropBoxManager.class, "dropbox");
            IY.put(InputMethodManager.class, "input_method");
            IY.put(KeyguardManager.class, "keyguard");
            IY.put(LayoutInflater.class, "layout_inflater");
            IY.put(LocationManager.class, FirebaseAnalytics.b.LOCATION);
            IY.put(NfcManager.class, "nfc");
            IY.put(NotificationManager.class, "notification");
            IY.put(PowerManager.class, "power");
            IY.put(SearchManager.class, "search");
            IY.put(SensorManager.class, "sensor");
            IY.put(StorageManager.class, "storage");
            IY.put(TelephonyManager.class, "phone");
            IY.put(TextServicesManager.class, "textservices");
            IY.put(UiModeManager.class, "uimode");
            IY.put(UsbManager.class, "usb");
            IY.put(Vibrator.class, "vibrator");
            IY.put(WallpaperManager.class, "wallpaper");
            IY.put(WifiP2pManager.class, "wifip2p");
            IY.put(WifiManager.class, "wifi");
            IY.put(WindowManager.class, "window");
        }
    }
}
