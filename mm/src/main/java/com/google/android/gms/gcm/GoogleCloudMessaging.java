package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.e.a;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.zzaf;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public class GoogleCloudMessaging {
    public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
    public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
    public static final String INSTANCE_ID_SCOPE = "GCM";
    @Deprecated
    public static final String MESSAGE_TYPE_DELETED = "deleted_messages";
    @Deprecated
    public static final String MESSAGE_TYPE_MESSAGE = "gcm";
    @Deprecated
    public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";
    @Deprecated
    public static final String MESSAGE_TYPE_SEND_EVENT = "send_event";
    private static GoogleCloudMessaging zzac;
    private static final AtomicInteger zzaf = new AtomicInteger(1);
    private PendingIntent zzad;
    private final Map<String, Handler> zzae = Collections.synchronizedMap(new a());
    private final BlockingQueue<Intent> zzag = new LinkedBlockingQueue();
    private final Messenger zzah = new Messenger(new zzf(this, Looper.getMainLooper()));
    private Context zzk;

    static {
        AppMethodBeat.i(3652);
        AppMethodBeat.o(3652);
    }

    public GoogleCloudMessaging() {
        AppMethodBeat.i(3638);
        AppMethodBeat.o(3638);
    }

    @Deprecated
    public static synchronized GoogleCloudMessaging getInstance(Context context) {
        GoogleCloudMessaging googleCloudMessaging;
        synchronized (GoogleCloudMessaging.class) {
            AppMethodBeat.i(3636);
            if (zzac == null) {
                zze(context);
                GoogleCloudMessaging googleCloudMessaging2 = new GoogleCloudMessaging();
                zzac = googleCloudMessaging2;
                googleCloudMessaging2.zzk = context.getApplicationContext();
            }
            googleCloudMessaging = zzac;
            AppMethodBeat.o(3636);
        }
        return googleCloudMessaging;
    }

    @Deprecated
    private final Intent zzd(Bundle bundle, boolean z) {
        AppMethodBeat.i(3646);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            IOException iOException = new IOException("MAIN_THREAD");
            AppMethodBeat.o(3646);
            throw iOException;
        } else if (zzf(this.zzk) < 0) {
            IOException iOException2 = new IOException("Google Play Services missing");
            AppMethodBeat.o(3646);
            throw iOException2;
        } else {
            Intent intent = new Intent(z ? "com.google.iid.TOKEN_REQUEST" : "com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(zzaf.zzl(this.zzk));
            zze(intent);
            intent.putExtra("google.message_id", new StringBuilder(21).append("google.rpc").append(zzaf.getAndIncrement()).toString());
            intent.putExtras(bundle);
            intent.putExtra("google.messenger", this.zzah);
            if (z) {
                this.zzk.sendBroadcast(intent);
            } else {
                this.zzk.startService(intent);
            }
            try {
                Intent poll = this.zzag.poll(30000, TimeUnit.MILLISECONDS);
                AppMethodBeat.o(3646);
                return poll;
            } catch (InterruptedException e2) {
                IOException iOException3 = new IOException(e2.getMessage());
                AppMethodBeat.o(3646);
                throw iOException3;
            }
        }
    }

    @VisibleForTesting
    @Deprecated
    private final synchronized String zzd(boolean z, String... strArr) {
        String stringExtra;
        AppMethodBeat.i(3645);
        String zzl = zzaf.zzl(this.zzk);
        if (zzl == null) {
            IOException iOException = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.o(3645);
            throw iOException;
        } else if (strArr == null || strArr.length == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No senderIds");
            AppMethodBeat.o(3645);
            throw illegalArgumentException;
        } else {
            StringBuilder sb = new StringBuilder(strArr[0]);
            for (int i2 = 1; i2 < strArr.length; i2++) {
                sb.append(',').append(strArr[i2]);
            }
            String sb2 = sb.toString();
            Bundle bundle = new Bundle();
            if (zzl.contains(".gsf")) {
                bundle.putString("legacy.sender", sb2);
                stringExtra = InstanceID.getInstance(this.zzk).getToken(sb2, "GCM", bundle);
                AppMethodBeat.o(3645);
            } else {
                bundle.putString("sender", sb2);
                Intent zzd = zzd(bundle, z);
                if (zzd == null) {
                    IOException iOException2 = new IOException("SERVICE_NOT_AVAILABLE");
                    AppMethodBeat.o(3645);
                    throw iOException2;
                }
                stringExtra = zzd.getStringExtra("registration_id");
                if (stringExtra != null) {
                    AppMethodBeat.o(3645);
                } else {
                    String stringExtra2 = zzd.getStringExtra("error");
                    if (stringExtra2 != null) {
                        IOException iOException3 = new IOException(stringExtra2);
                        AppMethodBeat.o(3645);
                        throw iOException3;
                    }
                    IOException iOException4 = new IOException("SERVICE_NOT_AVAILABLE");
                    AppMethodBeat.o(3645);
                    throw iOException4;
                }
            }
        }
        return stringExtra;
    }

    private final boolean zzd(Intent intent) {
        Handler remove;
        AppMethodBeat.i(3642);
        String stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra == null || (remove = this.zzae.remove(stringExtra)) == null) {
            AppMethodBeat.o(3642);
            return false;
        }
        Message obtain = Message.obtain();
        obtain.obj = intent;
        boolean sendMessage = remove.sendMessage(obtain);
        AppMethodBeat.o(3642);
        return sendMessage;
    }

    static /* synthetic */ boolean zzd(GoogleCloudMessaging googleCloudMessaging, Intent intent) {
        AppMethodBeat.i(3651);
        boolean zzd = googleCloudMessaging.zzd(intent);
        AppMethodBeat.o(3651);
        return zzd;
    }

    static void zze(Context context) {
        AppMethodBeat.i(3637);
        String packageName = context.getPackageName();
        new StringBuilder(String.valueOf(packageName).length() + 48).append("GCM SDK is deprecated, ").append(packageName).append(" should update to use FCM");
        AppMethodBeat.o(3637);
    }

    private final synchronized void zze(Intent intent) {
        AppMethodBeat.i(3648);
        if (this.zzad == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzad = PendingIntent.getBroadcast(this.zzk, 0, intent2, 0);
        }
        intent.putExtra("app", this.zzad);
        AppMethodBeat.o(3648);
    }

    public static int zzf(Context context) {
        AppMethodBeat.i(3650);
        String zzl = zzaf.zzl(context);
        if (zzl != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(zzl, 0);
                if (packageInfo != null) {
                    int i2 = packageInfo.versionCode;
                    AppMethodBeat.o(3650);
                    return i2;
                }
            } catch (PackageManager.NameNotFoundException e2) {
            }
        }
        AppMethodBeat.o(3650);
        return -1;
    }

    private final synchronized void zzg() {
        AppMethodBeat.i(3649);
        if (this.zzad != null) {
            this.zzad.cancel();
            this.zzad = null;
        }
        AppMethodBeat.o(3649);
    }

    @Deprecated
    public void close() {
        AppMethodBeat.i(3639);
        zzac = null;
        zzd.zzj = null;
        zzg();
        AppMethodBeat.o(3639);
    }

    @Deprecated
    public String getMessageType(Intent intent) {
        AppMethodBeat.i(3647);
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            AppMethodBeat.o(3647);
            return null;
        }
        String stringExtra = intent.getStringExtra("message_type");
        if (stringExtra != null) {
            AppMethodBeat.o(3647);
            return stringExtra;
        }
        AppMethodBeat.o(3647);
        return MESSAGE_TYPE_MESSAGE;
    }

    @Deprecated
    public synchronized String register(String... strArr) {
        String zzd;
        AppMethodBeat.i(3644);
        zzd = zzd(zzaf.zzk(this.zzk), strArr);
        AppMethodBeat.o(3644);
        return zzd;
    }

    @Deprecated
    public void send(String str, String str2, long j2, Bundle bundle) {
        AppMethodBeat.i(3641);
        if (str == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Missing 'to'");
            AppMethodBeat.o(3641);
            throw illegalArgumentException;
        }
        String zzl = zzaf.zzl(this.zzk);
        if (zzl == null) {
            IOException iOException = new IOException("SERVICE_NOT_AVAILABLE");
            AppMethodBeat.o(3641);
            throw iOException;
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        zze(intent);
        intent.setPackage(zzl);
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(j2));
        int indexOf = str.indexOf(64);
        String substring = indexOf > 0 ? str.substring(0, indexOf) : str;
        InstanceID.getInstance(this.zzk);
        intent.putExtra("google.from", InstanceID.zzn().zze("", substring, "GCM"));
        if (zzl.contains(".gsf")) {
            Bundle bundle2 = new Bundle();
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    String valueOf = String.valueOf(str3);
                    bundle2.putString(valueOf.length() != 0 ? "gcm.".concat(valueOf) : new String("gcm."), (String) obj);
                }
            }
            bundle2.putString("google.to", str);
            bundle2.putString("google.message_id", str2);
            InstanceID.getInstance(this.zzk).zze("GCM", "upstream", bundle2);
            AppMethodBeat.o(3641);
            return;
        }
        this.zzk.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
        AppMethodBeat.o(3641);
    }

    @Deprecated
    public void send(String str, String str2, Bundle bundle) {
        AppMethodBeat.i(3640);
        send(str, str2, -1, bundle);
        AppMethodBeat.o(3640);
    }

    @Deprecated
    public synchronized void unregister() {
        AppMethodBeat.i(3643);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            IOException iOException = new IOException("MAIN_THREAD");
            AppMethodBeat.o(3643);
            throw iOException;
        }
        InstanceID.getInstance(this.zzk).deleteInstanceID();
        AppMethodBeat.o(3643);
    }
}
