package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.b;
import android.support.v4.e.a;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Map;

/* access modifiers changed from: package-private */
public final class p {
    private final SharedPreferences bLQ;
    private final af bLR;
    private final Map<String, ag> bLS;
    private final Context bLv;

    public p(Context context) {
        this(context, new af());
        AppMethodBeat.i(4185);
        AppMethodBeat.o(4185);
    }

    private p(Context context, af afVar) {
        AppMethodBeat.i(4186);
        this.bLS = new a();
        this.bLv = context;
        this.bLQ = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.bLR = afVar;
        File file = new File(b.U(this.bLv), "com.google.android.gms.appid-no-backup");
        if (!file.exists()) {
            try {
                if (file.createNewFile() && !isEmpty()) {
                    zzag();
                    FirebaseInstanceId.yc().yh();
                }
                AppMethodBeat.o(4186);
                return;
            } catch (IOException e2) {
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    String valueOf = String.valueOf(e2.getMessage());
                    if (valueOf.length() != 0) {
                        "Error creating file in no backup dir: ".concat(valueOf);
                        AppMethodBeat.o(4186);
                        return;
                    }
                    new String("Error creating file in no backup dir: ");
                }
            }
        }
        AppMethodBeat.o(4186);
    }

    private static String b(String str, String str2, String str3) {
        AppMethodBeat.i(4190);
        String sb = new StringBuilder(String.valueOf(str).length() + 4 + String.valueOf(str2).length() + String.valueOf(str3).length()).append(str).append("|T|").append(str2).append("|").append(str3).toString();
        AppMethodBeat.o(4190);
        return sb;
    }

    private final synchronized boolean isEmpty() {
        boolean isEmpty;
        AppMethodBeat.i(4189);
        isEmpty = this.bLQ.getAll().isEmpty();
        AppMethodBeat.o(4189);
        return isEmpty;
    }

    static String o(String str, String str2) {
        AppMethodBeat.i(4191);
        String sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length()).append(str).append("|S|").append(str2).toString();
        AppMethodBeat.o(4191);
        return sb;
    }

    public final synchronized void b(String str, String str2, String str3, String str4, String str5) {
        AppMethodBeat.i(4194);
        String b2 = q.b(str4, str5, System.currentTimeMillis());
        if (b2 == null) {
            AppMethodBeat.o(4194);
        } else {
            SharedPreferences.Editor edit = this.bLQ.edit();
            edit.putString(b(str, str2, str3), b2);
            edit.commit();
            AppMethodBeat.o(4194);
        }
    }

    public final synchronized void bQ(String str) {
        AppMethodBeat.i(4196);
        String concat = String.valueOf(str).concat("|T|");
        SharedPreferences.Editor edit = this.bLQ.edit();
        for (String str2 : this.bLQ.getAll().keySet()) {
            if (str2.startsWith(concat)) {
                edit.remove(str2);
            }
        }
        edit.commit();
        AppMethodBeat.o(4196);
    }

    public final synchronized q c(String str, String str2, String str3) {
        q bR;
        AppMethodBeat.i(4193);
        bR = q.bR(this.bLQ.getString(b(str, str2, str3), null));
        AppMethodBeat.o(4193);
        return bR;
    }

    public final synchronized String ys() {
        String str = null;
        synchronized (this) {
            AppMethodBeat.i(4187);
            String string = this.bLQ.getString("topic_operaion_queue", null);
            if (string != null) {
                String[] split = string.split(",");
                if (split.length > 1 && !TextUtils.isEmpty(split[1])) {
                    str = split[1];
                    AppMethodBeat.o(4187);
                }
            }
            AppMethodBeat.o(4187);
        }
        return str;
    }

    public final synchronized boolean zzf(String str) {
        boolean z;
        AppMethodBeat.i(4188);
        String string = this.bLQ.getString("topic_operaion_queue", "");
        String valueOf = String.valueOf(",");
        String valueOf2 = String.valueOf(str);
        if (string.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
            String valueOf3 = String.valueOf(",");
            String valueOf4 = String.valueOf(str);
            this.bLQ.edit().putString("topic_operaion_queue", string.substring((valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3)).length())).apply();
            z = true;
            AppMethodBeat.o(4188);
        } else {
            z = false;
            AppMethodBeat.o(4188);
        }
        return z;
    }

    public final synchronized void zzag() {
        AppMethodBeat.i(4192);
        this.bLS.clear();
        File[] listFiles = af.ar(this.bLv).listFiles();
        for (File file : listFiles) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
        this.bLQ.edit().clear().commit();
        AppMethodBeat.o(4192);
    }

    public final synchronized ag bP(String str) {
        ag agVar;
        AppMethodBeat.i(4195);
        agVar = this.bLS.get(str);
        if (agVar != null) {
            AppMethodBeat.o(4195);
        } else {
            try {
                Context context = this.bLv;
                agVar = af.k(context, str);
                if (agVar == null) {
                    agVar = af.j(context, str);
                }
            } catch (ah e2) {
                FirebaseInstanceId.yc().yh();
                agVar = af.j(this.bLv, str);
            }
            this.bLS.put(str, agVar);
            AppMethodBeat.o(4195);
        }
        return agVar;
    }
}
