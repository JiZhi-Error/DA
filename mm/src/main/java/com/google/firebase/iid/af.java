package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.b;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.firebase_messaging.zzh;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.recovery.wx.util.EncryptUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Properties;

/* access modifiers changed from: package-private */
public final class af {
    af() {
    }

    private static ag a(SharedPreferences sharedPreferences, String str) {
        AppMethodBeat.i(4244);
        String string = sharedPreferences.getString(p.o(str, "|P|"), null);
        String string2 = sharedPreferences.getString(p.o(str, "|K|"), null);
        if (string == null || string2 == null) {
            AppMethodBeat.o(4244);
            return null;
        }
        ag agVar = new ag(r(string, string2), b(sharedPreferences, str));
        AppMethodBeat.o(4244);
        return agVar;
    }

    private static /* synthetic */ void a(Throwable th, FileInputStream fileInputStream) {
        AppMethodBeat.i(4248);
        if (th != null) {
            try {
                fileInputStream.close();
                AppMethodBeat.o(4248);
            } catch (Throwable th2) {
                zzh.zza(th, th2);
                AppMethodBeat.o(4248);
            }
        } else {
            fileInputStream.close();
            AppMethodBeat.o(4248);
        }
    }

    private static /* synthetic */ void a(Throwable th, FileOutputStream fileOutputStream) {
        AppMethodBeat.i(4247);
        if (th != null) {
            try {
                fileOutputStream.close();
                AppMethodBeat.o(4247);
            } catch (Throwable th2) {
                zzh.zza(th, th2);
                AppMethodBeat.o(4247);
            }
        } else {
            fileOutputStream.close();
            AppMethodBeat.o(4247);
        }
    }

    static File ar(Context context) {
        AppMethodBeat.i(4241);
        File U = b.U(context);
        if (U == null || !U.isDirectory()) {
            File filesDir = context.getFilesDir();
            AppMethodBeat.o(4241);
            return filesDir;
        }
        AppMethodBeat.o(4241);
        return U;
    }

    private static long b(SharedPreferences sharedPreferences, String str) {
        AppMethodBeat.i(4246);
        String string = sharedPreferences.getString(p.o(str, "cre"), null);
        if (string != null) {
            try {
                long parseLong = Long.parseLong(string);
                AppMethodBeat.o(4246);
                return parseLong;
            } catch (NumberFormatException e2) {
            }
        }
        AppMethodBeat.o(4246);
        return 0;
    }

    static ag j(Context context, String str) {
        AppMethodBeat.i(4236);
        ag agVar = new ag(a.ym(), System.currentTimeMillis());
        try {
            ag k = k(context, str);
            if (k != null) {
                Log.isLoggable("FirebaseInstanceId", 3);
                AppMethodBeat.o(4236);
                return k;
            }
        } catch (ah e2) {
        }
        Log.isLoggable("FirebaseInstanceId", 3);
        a(context, str, agVar);
        b(context, str, agVar);
        AppMethodBeat.o(4236);
        return agVar;
    }

    static ag k(Context context, String str) {
        ah ahVar;
        AppMethodBeat.i(4237);
        try {
            ag l = l(context, str);
            if (l != null) {
                b(context, str, l);
                AppMethodBeat.o(4237);
                return l;
            }
            ahVar = null;
            try {
                ag a2 = a(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (a2 != null) {
                    a(context, str, a2);
                    AppMethodBeat.o(4237);
                    return a2;
                }
                e = ahVar;
                if (e != null) {
                    AppMethodBeat.o(4237);
                    throw e;
                }
                AppMethodBeat.o(4237);
                return null;
            } catch (ah e2) {
                e = e2;
            }
        } catch (ah e3) {
            ahVar = e3;
        }
    }

    private static ag l(Context context, String str) {
        AppMethodBeat.i(4239);
        File m = m(context, str);
        if (!m.exists()) {
            AppMethodBeat.o(4239);
            return null;
        }
        try {
            ag x = x(m);
            AppMethodBeat.o(4239);
            return x;
        } catch (IOException e2) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e2);
                new StringBuilder(String.valueOf(valueOf).length() + 40).append("Failed to read key from file, retrying: ").append(valueOf);
            }
            try {
                ag x2 = x(m);
                AppMethodBeat.o(4239);
                return x2;
            } catch (IOException e3) {
                String valueOf2 = String.valueOf(e3);
                new StringBuilder(String.valueOf(valueOf2).length() + 45).append("IID file exists, but failed to read from it: ").append(valueOf2);
                ah ahVar = new ah(e3);
                AppMethodBeat.o(4239);
                throw ahVar;
            }
        }
    }

    private static File m(Context context, String str) {
        String sb;
        AppMethodBeat.i(4242);
        if (TextUtils.isEmpty(str)) {
            sb = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), 11);
                sb = new StringBuilder(String.valueOf(encodeToString).length() + 33).append("com.google.InstanceId_").append(encodeToString).append(".properties").toString();
            } catch (UnsupportedEncodingException e2) {
                AssertionError assertionError = new AssertionError(e2);
                AppMethodBeat.o(4242);
                throw assertionError;
            }
        }
        File file = new File(ar(context), sb);
        AppMethodBeat.o(4242);
        return file;
    }

    private static KeyPair r(String str, String str2) {
        AppMethodBeat.i(4238);
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory instance = KeyFactory.getInstance(EncryptUtil.KEY_ALGORITHM);
                KeyPair keyPair = new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
                AppMethodBeat.o(4238);
                return keyPair;
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
                String valueOf = String.valueOf(e2);
                new StringBuilder(String.valueOf(valueOf).length() + 19).append("Invalid key stored ").append(valueOf);
                ah ahVar = new ah(e2);
                AppMethodBeat.o(4238);
                throw ahVar;
            }
        } catch (IllegalArgumentException e3) {
            ah ahVar2 = new ah(e3);
            AppMethodBeat.o(4238);
            throw ahVar2;
        }
    }

    private static ag x(File file) {
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(4243);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String property = properties.getProperty("pub");
            String property2 = properties.getProperty("pri");
            if (property == null || property2 == null) {
                a((Throwable) null, fileInputStream);
                AppMethodBeat.o(4243);
                return null;
            }
            try {
                ag agVar = new ag(r(property, property2), Long.parseLong(properties.getProperty("cre")));
                a((Throwable) null, fileInputStream);
                AppMethodBeat.o(4243);
                return agVar;
            } catch (NumberFormatException e2) {
                ah ahVar = new ah(e2);
                AppMethodBeat.o(4243);
                throw ahVar;
            }
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            a(th2, fileInputStream);
            AppMethodBeat.o(4243);
            throw th;
        }
    }

    private static void a(Context context, String str, ag agVar) {
        AppMethodBeat.i(4240);
        try {
            Log.isLoggable("FirebaseInstanceId", 3);
            File m = m(context, str);
            m.createNewFile();
            Properties properties = new Properties();
            properties.setProperty("pub", agVar.zzq());
            properties.setProperty("pri", agVar.yv());
            properties.setProperty("cre", String.valueOf(agVar.bMD));
            FileOutputStream fileOutputStream = new FileOutputStream(m);
            try {
                properties.store(fileOutputStream, (String) null);
                a((Throwable) null, fileOutputStream);
                AppMethodBeat.o(4240);
            } catch (Throwable th) {
                a(th, fileOutputStream);
                AppMethodBeat.o(4240);
                throw th;
            }
        } catch (IOException e2) {
            String valueOf = String.valueOf(e2);
            new StringBuilder(String.valueOf(valueOf).length() + 21).append("Failed to write key: ").append(valueOf);
            AppMethodBeat.o(4240);
        }
    }

    private static void b(Context context, String str, ag agVar) {
        AppMethodBeat.i(4245);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (agVar.equals(a(sharedPreferences, str))) {
                AppMethodBeat.o(4245);
                return;
            }
        } catch (ah e2) {
        }
        Log.isLoggable("FirebaseInstanceId", 3);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(p.o(str, "|P|"), agVar.zzq());
        edit.putString(p.o(str, "|K|"), agVar.yv());
        edit.putString(p.o(str, "cre"), String.valueOf(agVar.bMD));
        edit.commit();
        AppMethodBeat.o(4245);
    }
}
