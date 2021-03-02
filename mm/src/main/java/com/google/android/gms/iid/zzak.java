package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.b;
import android.support.v4.e.a;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public final class zzak {
    private SharedPreferences zzcz;
    private final zzn zzda;
    private final Map<String, zzo> zzdb;
    private Context zzk;

    public zzak(Context context) {
        this(context, new zzn());
        AppMethodBeat.i(2503);
        AppMethodBeat.o(2503);
    }

    @VisibleForTesting
    private zzak(Context context, zzn zzn) {
        AppMethodBeat.i(2504);
        this.zzdb = new a();
        this.zzk = context;
        this.zzcz = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.zzda = zzn;
        File file = new File(b.U(this.zzk), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    InstanceIDListenerService.zzd(this.zzk, this);
                }
                AppMethodBeat.o(2504);
                return;
            } catch (IOException e2) {
                if (Log.isLoggable("InstanceID/Store", 3)) {
                    String valueOf = String.valueOf(e2.getMessage());
                    if (valueOf.length() != 0) {
                        "Error creating file in no backup dir: ".concat(valueOf);
                        AppMethodBeat.o(2504);
                        return;
                    }
                    new String("Error creating file in no backup dir: ");
                }
            }
        }
        AppMethodBeat.o(2504);
    }

    private static String zzd(String str, String str2, String str3) {
        AppMethodBeat.i(2506);
        String sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length()).append(str).append("|T|").append(str2).append("|").append(str3).toString();
        AppMethodBeat.o(2506);
        return sb;
    }

    static String zzh(String str, String str2) {
        AppMethodBeat.i(2515);
        String sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length()).append(str).append("|S|").append(str2).toString();
        AppMethodBeat.o(2515);
        return sb;
    }

    /* access modifiers changed from: package-private */
    public final synchronized String get(String str) {
        String string;
        AppMethodBeat.i(2507);
        string = this.zzcz.getString(str, null);
        AppMethodBeat.o(2507);
        return string;
    }

    public final boolean isEmpty() {
        AppMethodBeat.i(2505);
        boolean isEmpty = this.zzcz.getAll().isEmpty();
        AppMethodBeat.o(2505);
        return isEmpty;
    }

    public final synchronized void zzd(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(2511);
        String zzd = zzd(str, str2, str3);
        SharedPreferences.Editor edit = this.zzcz.edit();
        edit.putString(zzd, str4);
        edit.putString("appVersion", str5);
        edit.putString("lastToken", Long.toString(System.currentTimeMillis() / 1000));
        edit.commit();
        AppMethodBeat.o(2511);
    }

    public final synchronized String zze(String str, String str2, String str3) {
        String string;
        AppMethodBeat.i(2510);
        string = this.zzcz.getString(zzd(str, str2, str3), null);
        AppMethodBeat.o(2510);
        return string;
    }

    public final synchronized void zzf(String str, String str2, String str3) {
        AppMethodBeat.i(2512);
        String zzd = zzd(str, str2, str3);
        SharedPreferences.Editor edit = this.zzcz.edit();
        edit.remove(zzd);
        edit.commit();
        AppMethodBeat.o(2512);
    }

    public final synchronized void zzi(String str) {
        AppMethodBeat.i(2508);
        SharedPreferences.Editor edit = this.zzcz.edit();
        for (String str2 : this.zzcz.getAll().keySet()) {
            if (str2.startsWith(str)) {
                edit.remove(str2);
            }
        }
        edit.commit();
        AppMethodBeat.o(2508);
    }

    public final synchronized zzo zzj(String str) {
        zzo zzo;
        AppMethodBeat.i(2513);
        zzo = this.zzdb.get(str);
        if (zzo != null) {
            AppMethodBeat.o(2513);
        } else {
            try {
                zzo = this.zzda.zze(this.zzk, str);
            } catch (zzp e2) {
                InstanceIDListenerService.zzd(this.zzk, this);
                zzo = this.zzda.zzf(this.zzk, str);
            }
            this.zzdb.put(str, zzo);
            AppMethodBeat.o(2513);
        }
        return zzo;
    }

    /* access modifiers changed from: package-private */
    public final void zzk(String str) {
        AppMethodBeat.i(2514);
        synchronized (this) {
            try {
                this.zzdb.remove(str);
            } catch (Throwable th) {
                AppMethodBeat.o(2514);
                throw th;
            }
        }
        zzn.zzg(this.zzk, str);
        zzi(String.valueOf(str).concat("|"));
        AppMethodBeat.o(2514);
    }

    public final synchronized void zzx() {
        AppMethodBeat.i(2509);
        this.zzdb.clear();
        zzn.zzi(this.zzk);
        this.zzcz.edit().clear().commit();
        AppMethodBeat.o(2509);
    }
}
