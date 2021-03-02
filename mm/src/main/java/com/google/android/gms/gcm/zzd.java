package com.google.android.gms.gcm;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;

final class zzd {
    static zzd zzj;
    private final Context zzk;
    private String zzl;
    private final AtomicInteger zzm = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private zzd(Context context) {
        AppMethodBeat.i(3699);
        this.zzk = context.getApplicationContext();
        AppMethodBeat.o(3699);
    }

    static synchronized zzd zzd(Context context) {
        zzd zzd;
        synchronized (zzd.class) {
            AppMethodBeat.i(3697);
            if (zzj == null) {
                zzj = new zzd(context);
            }
            zzd = zzj;
            AppMethodBeat.o(3697);
        }
        return zzd;
    }

    static String zzd(Bundle bundle, String str) {
        AppMethodBeat.i(3698);
        String string = bundle.getString(str);
        if (string == null) {
            string = bundle.getString(str.replace("gcm.n.", "gcm.notification."));
        }
        AppMethodBeat.o(3698);
        return string;
    }

    private final Bundle zze() {
        AppMethodBeat.i(3702);
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = this.zzk.getPackageManager().getApplicationInfo(this.zzk.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException e2) {
        }
        if (applicationInfo == null || applicationInfo.metaData == null) {
            Bundle bundle = Bundle.EMPTY;
            AppMethodBeat.o(3702);
            return bundle;
        }
        Bundle bundle2 = applicationInfo.metaData;
        AppMethodBeat.o(3702);
        return bundle2;
    }

    private final String zze(Bundle bundle, String str) {
        AppMethodBeat.i(3701);
        String zzd = zzd(bundle, str);
        if (!TextUtils.isEmpty(zzd)) {
            AppMethodBeat.o(3701);
            return zzd;
        }
        String valueOf = String.valueOf(str);
        String valueOf2 = String.valueOf("_loc_key");
        String zzd2 = zzd(bundle, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        if (TextUtils.isEmpty(zzd2)) {
            AppMethodBeat.o(3701);
            return null;
        }
        Resources resources = this.zzk.getResources();
        int identifier = resources.getIdentifier(zzd2, "string", this.zzk.getPackageName());
        if (identifier == 0) {
            String valueOf3 = String.valueOf(str);
            String valueOf4 = String.valueOf("_loc_key");
            String substring = (valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3)).substring(6);
            new StringBuilder(String.valueOf(substring).length() + 49 + String.valueOf(zzd2).length()).append(substring).append(" resource not found: ").append(zzd2).append(" Default value will be used.");
            AppMethodBeat.o(3701);
            return null;
        }
        String valueOf5 = String.valueOf(str);
        String valueOf6 = String.valueOf("_loc_args");
        String zzd3 = zzd(bundle, valueOf6.length() != 0 ? valueOf5.concat(valueOf6) : new String(valueOf5));
        if (TextUtils.isEmpty(zzd3)) {
            String string = resources.getString(identifier);
            AppMethodBeat.o(3701);
            return string;
        }
        try {
            JSONArray jSONArray = new JSONArray(zzd3);
            Object[] objArr = new String[jSONArray.length()];
            for (int i2 = 0; i2 < objArr.length; i2++) {
                objArr[i2] = jSONArray.opt(i2);
            }
            String string2 = resources.getString(identifier, objArr);
            AppMethodBeat.o(3701);
            return string2;
        } catch (JSONException e2) {
            String valueOf7 = String.valueOf(str);
            String valueOf8 = String.valueOf("_loc_args");
            String substring2 = (valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7)).substring(6);
            new StringBuilder(String.valueOf(substring2).length() + 41 + String.valueOf(zzd3).length()).append("Malformed ").append(substring2).append(": ").append(zzd3).append("  Default value will be used.");
            AppMethodBeat.o(3701);
            return null;
        } catch (MissingFormatArgumentException e3) {
            new StringBuilder(String.valueOf(zzd2).length() + 58 + String.valueOf(zzd3).length()).append("Missing format argument for ").append(zzd2).append(": ").append(zzd3).append(" Default value will be used.");
            AppMethodBeat.o(3701);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x009f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x017a  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x02cf  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02d8  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x02e1  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x02e9  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02ee  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zze(android.os.Bundle r15) {
        /*
        // Method dump skipped, instructions count: 765
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.gcm.zzd.zze(android.os.Bundle):boolean");
    }
}
