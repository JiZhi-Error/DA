package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.e.a;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class zzaf {
    private static int zzck = 0;
    private static final zzaj<Boolean> zzco = zzai.zzw().zzd("gcm_iid_use_messenger_ipc", true);
    private static String zzcp = null;
    private static boolean zzcq = false;
    private static int zzcr = 0;
    private static int zzcs = 0;
    private static BroadcastReceiver zzct = null;
    private PendingIntent zzad;
    private Messenger zzah;
    private Map<String, Object> zzcu = new a();
    private Messenger zzcv;
    private MessengerCompat zzcw;
    private Context zzk;

    static {
        AppMethodBeat.i(2500);
        AppMethodBeat.o(2500);
    }

    public zzaf(Context context) {
        AppMethodBeat.i(2484);
        this.zzk = context;
        AppMethodBeat.o(2484);
    }

    private static void zzd(Object obj, Object obj2) {
        AppMethodBeat.i(2494);
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
                AppMethodBeat.o(2494);
                return;
            } catch (RemoteException e2) {
                String valueOf = String.valueOf(e2);
                new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to send response ").append(valueOf);
            }
        }
        AppMethodBeat.o(2494);
    }

    private final void zzd(String str, Object obj) {
        AppMethodBeat.i(2493);
        synchronized (getClass()) {
            try {
                Object obj2 = this.zzcu.get(str);
                this.zzcu.put(str, obj);
                zzd(obj2, obj);
            } finally {
                AppMethodBeat.o(2493);
            }
        }
    }

    private static boolean zzd(PackageManager packageManager, String str) {
        AppMethodBeat.i(2488);
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            zzcp = applicationInfo.packageName;
            zzcs = applicationInfo.uid;
            AppMethodBeat.o(2488);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(2488);
            return false;
        }
    }

    private static boolean zzd(PackageManager packageManager, String str, String str2) {
        AppMethodBeat.i(2487);
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", str) == 0) {
            boolean zzd = zzd(packageManager, str);
            AppMethodBeat.o(2487);
            return zzd;
        }
        new StringBuilder(String.valueOf(str).length() + 56 + String.valueOf(str2).length()).append("Possible malicious package ").append(str).append(" declares ").append(str2).append(" without permission");
        AppMethodBeat.o(2487);
        return false;
    }

    private final synchronized void zzg(Intent intent) {
        AppMethodBeat.i(2491);
        if (this.zzad == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzad = PendingIntent.getBroadcast(this.zzk, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzad);
        AppMethodBeat.o(2491);
    }

    static String zzi(Bundle bundle) {
        AppMethodBeat.i(2492);
        if (bundle == null) {
            IOException iOException = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.o(2492);
            throw iOException;
        }
        String string = bundle.getString("registration_id");
        if (string == null) {
            string = bundle.getString("unregistered");
        }
        if (string == null) {
            String string2 = bundle.getString("error");
            if (string2 != null) {
                IOException iOException2 = new IOException(string2);
                AppMethodBeat.o(2492);
                throw iOException2;
            }
            String valueOf = String.valueOf(bundle);
            new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf);
            new Throwable();
            IOException iOException3 = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.o(2492);
            throw iOException3;
        }
        AppMethodBeat.o(2492);
        return string;
    }

    private final Bundle zzj(Bundle bundle) {
        AppMethodBeat.i(2497);
        Bundle zzk2 = zzk(bundle);
        if (zzk2 != null && zzk2.containsKey("google.messenger") && (zzk2 = zzk(bundle)) != null && zzk2.containsKey("google.messenger")) {
            zzk2 = null;
        }
        AppMethodBeat.o(2497);
        return zzk2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x011a A[SYNTHETIC, Splitter:B:32:0x011a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.os.Bundle zzk(android.os.Bundle r10) {
        /*
        // Method dump skipped, instructions count: 498
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzaf.zzk(android.os.Bundle):android.os.Bundle");
    }

    public static boolean zzk(Context context) {
        AppMethodBeat.i(2485);
        if (zzcp != null) {
            zzl(context);
        }
        boolean z = zzcq;
        AppMethodBeat.o(2485);
        return z;
    }

    public static String zzl(Context context) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(2486);
        if (zzcp != null) {
            String str = zzcp;
            AppMethodBeat.o(2486);
            return str;
        }
        zzcr = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        if (!PlatformVersion.isAtLeastO()) {
            Iterator<ResolveInfo> it = packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
            while (true) {
                if (it.hasNext()) {
                    if (zzd(packageManager, it.next().serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                        zzcq = false;
                        z2 = true;
                        break;
                    }
                } else {
                    z2 = false;
                    break;
                }
            }
            if (z2) {
                String str2 = zzcp;
                AppMethodBeat.o(2486);
                return str2;
            }
        }
        Iterator<ResolveInfo> it2 = packageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0).iterator();
        while (true) {
            if (it2.hasNext()) {
                if (zzd(packageManager, it2.next().activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
                    zzcq = true;
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z) {
            String str3 = zzcp;
            AppMethodBeat.o(2486);
            return str3;
        } else if (zzd(packageManager, "com.google.android.gms")) {
            zzcq = PlatformVersion.isAtLeastO();
            String str4 = zzcp;
            AppMethodBeat.o(2486);
            return str4;
        } else if (PlatformVersion.isAtLeastLollipop() || !zzd(packageManager, "com.google.android.gsf")) {
            AppMethodBeat.o(2486);
            return null;
        } else {
            zzcq = false;
            String str5 = zzcp;
            AppMethodBeat.o(2486);
            return str5;
        }
    }

    private static int zzm(Context context) {
        AppMethodBeat.i(2489);
        try {
            int i2 = context.getPackageManager().getPackageInfo(zzl(context), 0).versionCode;
            AppMethodBeat.o(2489);
            return i2;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(2489);
            return -1;
        }
    }

    private static synchronized String zzv() {
        String num;
        synchronized (zzaf.class) {
            AppMethodBeat.i(2498);
            int i2 = zzck;
            zzck = i2 + 1;
            num = Integer.toString(i2);
            AppMethodBeat.o(2498);
        }
        return num;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzd(Bundle bundle, KeyPair keyPair) {
        AppMethodBeat.i(2496);
        int zzm = zzm(this.zzk);
        bundle.putString("gmsv", Integer.toString(zzm));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", Integer.toString(InstanceID.zzg(this.zzk)));
        bundle.putString("app_ver_name", InstanceID.zzh(this.zzk));
        bundle.putString("cliv", "iid-12451000");
        bundle.putString("appid", InstanceID.zzd(keyPair));
        if (zzm < 12000000 || !zzco.get().booleanValue()) {
            Bundle zzj = zzj(bundle);
            AppMethodBeat.o(2496);
            return zzj;
        }
        try {
            Bundle bundle2 = (Bundle) Tasks.await(new zzr(this.zzk).zzd(1, bundle));
            AppMethodBeat.o(2496);
            return bundle2;
        } catch (InterruptedException | ExecutionException e2) {
            if (Log.isLoggable("InstanceID", 3)) {
                String valueOf = String.valueOf(e2);
                new StringBuilder(String.valueOf(valueOf).length() + 22).append("Error making request: ").append(valueOf);
            }
            if (!(e2.getCause() instanceof zzaa) || ((zzaa) e2.getCause()).getErrorCode() != 4) {
                AppMethodBeat.o(2496);
                return null;
            }
            Bundle zzj2 = zzj(bundle);
            AppMethodBeat.o(2496);
            return zzj2;
        }
    }

    public final void zze(Message message) {
        AppMethodBeat.i(2490);
        if (message == null) {
            AppMethodBeat.o(2490);
        } else if (message.obj instanceof Intent) {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof MessengerCompat) {
                    this.zzcw = (MessengerCompat) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    this.zzcv = (Messenger) parcelableExtra;
                }
            }
            zzh((Intent) message.obj);
            AppMethodBeat.o(2490);
        } else {
            AppMethodBeat.o(2490);
        }
    }

    public final void zzh(Intent intent) {
        AppMethodBeat.i(2495);
        if (intent == null) {
            Log.isLoggable("InstanceID", 3);
            AppMethodBeat.o(2495);
            return;
        }
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
            String stringExtra = intent.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                String stringExtra2 = intent.getStringExtra("error");
                if (stringExtra2 == null) {
                    String valueOf = String.valueOf(intent.getExtras());
                    new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf);
                    AppMethodBeat.o(2495);
                    return;
                }
                if (Log.isLoggable("InstanceID", 3)) {
                    String valueOf2 = String.valueOf(stringExtra2);
                    if (valueOf2.length() != 0) {
                        "Received InstanceID error ".concat(valueOf2);
                    } else {
                        new String("Received InstanceID error ");
                    }
                }
                String str = null;
                if (stringExtra2.startsWith("|")) {
                    String[] split = stringExtra2.split("\\|");
                    if (!"ID".equals(split[1])) {
                        String valueOf3 = String.valueOf(stringExtra2);
                        if (valueOf3.length() != 0) {
                            "Unexpected structured response ".concat(valueOf3);
                        } else {
                            new String("Unexpected structured response ");
                        }
                    }
                    if (split.length > 2) {
                        str = split[2];
                        stringExtra2 = split[3];
                        if (stringExtra2.startsWith(":")) {
                            stringExtra2 = stringExtra2.substring(1);
                        }
                    } else {
                        stringExtra2 = "UNKNOWN";
                    }
                    intent.putExtra("error", stringExtra2);
                }
                if (str == null) {
                    synchronized (getClass()) {
                        try {
                            for (String str2 : this.zzcu.keySet()) {
                                Object obj = this.zzcu.get(str2);
                                this.zzcu.put(str2, stringExtra2);
                                zzd(obj, stringExtra2);
                            }
                        } finally {
                            AppMethodBeat.o(2495);
                        }
                    }
                    return;
                }
                zzd(str, (Object) stringExtra2);
                AppMethodBeat.o(2495);
                return;
            }
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
            if (!matcher.matches()) {
                if (Log.isLoggable("InstanceID", 3)) {
                    String valueOf4 = String.valueOf(stringExtra);
                    if (valueOf4.length() != 0) {
                        "Unexpected response string: ".concat(valueOf4);
                        AppMethodBeat.o(2495);
                        return;
                    }
                    new String("Unexpected response string: ");
                }
                AppMethodBeat.o(2495);
                return;
            }
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            Bundle extras = intent.getExtras();
            extras.putString("registration_id", group2);
            zzd(group, (Object) extras);
            AppMethodBeat.o(2495);
            return;
        }
        if (Log.isLoggable("InstanceID", 3)) {
            String valueOf5 = String.valueOf(intent.getAction());
            if (valueOf5.length() != 0) {
                "Unexpected response ".concat(valueOf5);
                AppMethodBeat.o(2495);
                return;
            }
            new String("Unexpected response ");
        }
        AppMethodBeat.o(2495);
    }
}
