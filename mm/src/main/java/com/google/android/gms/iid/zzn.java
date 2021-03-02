package com.google.android.gms.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.content.b;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.gcm.zzf;
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
public final class zzn {
    zzn() {
    }

    private static zzo zzd(SharedPreferences sharedPreferences, String str) {
        AppMethodBeat.i(2541);
        String string = sharedPreferences.getString(zzak.zzh(str, "|P|"), null);
        String string2 = sharedPreferences.getString(zzak.zzh(str, "|K|"), null);
        if (string == null || string2 == null) {
            AppMethodBeat.o(2541);
            return null;
        }
        zzo zzo = new zzo(zzg(string, string2), zze(sharedPreferences, str));
        AppMethodBeat.o(2541);
        return zzo;
    }

    private static zzo zzd(File file) {
        Throwable th;
        Throwable th2;
        AppMethodBeat.i(2540);
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            String property = properties.getProperty("pub");
            String property2 = properties.getProperty("pri");
            if (property == null || property2 == null) {
                zzd((Throwable) null, fileInputStream);
                AppMethodBeat.o(2540);
                return null;
            }
            try {
                zzo zzo = new zzo(zzg(property, property2), Long.parseLong(properties.getProperty("cre")));
                zzd((Throwable) null, fileInputStream);
                AppMethodBeat.o(2540);
                return zzo;
            } catch (NumberFormatException e2) {
                zzp zzp = new zzp(e2);
                AppMethodBeat.o(2540);
                throw zzp;
            }
        } catch (Throwable th3) {
            th = th3;
            th2 = th;
            zzd(th2, fileInputStream);
            AppMethodBeat.o(2540);
            throw th;
        }
    }

    private static void zzd(Context context, String str, zzo zzo) {
        AppMethodBeat.i(2537);
        try {
            Log.isLoggable("InstanceID", 3);
            File zzj = zzj(context, str);
            zzj.createNewFile();
            Properties properties = new Properties();
            properties.setProperty("pub", zzo.zzd(zzo));
            properties.setProperty("pri", zzo.zze(zzo));
            properties.setProperty("cre", String.valueOf(zzo.zzbx));
            FileOutputStream fileOutputStream = new FileOutputStream(zzj);
            try {
                properties.store(fileOutputStream, (String) null);
                zzd((Throwable) null, fileOutputStream);
                AppMethodBeat.o(2537);
            } catch (Throwable th) {
                zzd(th, fileOutputStream);
                AppMethodBeat.o(2537);
                throw th;
            }
        } catch (IOException e2) {
            String valueOf = String.valueOf(e2);
            new StringBuilder(String.valueOf(valueOf).length() + 21).append("Failed to write key: ").append(valueOf);
            AppMethodBeat.o(2537);
        }
    }

    private static /* synthetic */ void zzd(Throwable th, FileInputStream fileInputStream) {
        AppMethodBeat.i(2545);
        if (th != null) {
            try {
                fileInputStream.close();
                AppMethodBeat.o(2545);
            } catch (Throwable th2) {
                zzf.zzd(th, th2);
                AppMethodBeat.o(2545);
            }
        } else {
            fileInputStream.close();
            AppMethodBeat.o(2545);
        }
    }

    private static /* synthetic */ void zzd(Throwable th, FileOutputStream fileOutputStream) {
        AppMethodBeat.i(2544);
        if (th != null) {
            try {
                fileOutputStream.close();
                AppMethodBeat.o(2544);
            } catch (Throwable th2) {
                zzf.zzd(th, th2);
                AppMethodBeat.o(2544);
            }
        } else {
            fileOutputStream.close();
            AppMethodBeat.o(2544);
        }
    }

    private static long zze(SharedPreferences sharedPreferences, String str) {
        AppMethodBeat.i(2543);
        String string = sharedPreferences.getString(zzak.zzh(str, "cre"), null);
        if (string != null) {
            try {
                long parseLong = Long.parseLong(string);
                AppMethodBeat.o(2543);
                return parseLong;
            } catch (NumberFormatException e2) {
            }
        }
        AppMethodBeat.o(2543);
        return 0;
    }

    private final void zze(Context context, String str, zzo zzo) {
        AppMethodBeat.i(2542);
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (zzo.equals(zzd(sharedPreferences, str))) {
                AppMethodBeat.o(2542);
                return;
            }
        } catch (zzp e2) {
        }
        Log.isLoggable("InstanceID", 3);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(zzak.zzh(str, "|P|"), zzo.zzd(zzo));
        edit.putString(zzak.zzh(str, "|K|"), zzo.zze(zzo));
        edit.putString(zzak.zzh(str, "cre"), String.valueOf(zzo.zzbx));
        edit.commit();
        AppMethodBeat.o(2542);
    }

    private static KeyPair zzg(String str, String str2) {
        AppMethodBeat.i(2535);
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory instance = KeyFactory.getInstance(EncryptUtil.KEY_ALGORITHM);
                KeyPair keyPair = new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
                AppMethodBeat.o(2535);
                return keyPair;
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
                String valueOf = String.valueOf(e2);
                new StringBuilder(String.valueOf(valueOf).length() + 19).append("Invalid key stored ").append(valueOf);
                zzp zzp = new zzp(e2);
                AppMethodBeat.o(2535);
                throw zzp;
            }
        } catch (IllegalArgumentException e3) {
            zzp zzp2 = new zzp(e3);
            AppMethodBeat.o(2535);
            throw zzp2;
        }
    }

    static void zzg(Context context, String str) {
        AppMethodBeat.i(2532);
        File zzj = zzj(context, str);
        if (zzj.exists()) {
            zzj.delete();
        }
        AppMethodBeat.o(2532);
    }

    private final zzo zzh(Context context, String str) {
        zzp zzp;
        AppMethodBeat.i(2534);
        try {
            zzo zzi = zzi(context, str);
            if (zzi != null) {
                zze(context, str, zzi);
                AppMethodBeat.o(2534);
                return zzi;
            }
            zzp = null;
            try {
                zzo zzd = zzd(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (zzd != null) {
                    zzd(context, str, zzd);
                    AppMethodBeat.o(2534);
                    return zzd;
                }
                e = zzp;
                if (e != null) {
                    AppMethodBeat.o(2534);
                    throw e;
                }
                AppMethodBeat.o(2534);
                return null;
            } catch (zzp e2) {
                e = e2;
            }
        } catch (zzp e3) {
            zzp = e3;
        }
    }

    private final zzo zzi(Context context, String str) {
        AppMethodBeat.i(2536);
        File zzj = zzj(context, str);
        if (!zzj.exists()) {
            AppMethodBeat.o(2536);
            return null;
        }
        try {
            zzo zzd = zzd(zzj);
            AppMethodBeat.o(2536);
            return zzd;
        } catch (IOException e2) {
            if (Log.isLoggable("InstanceID", 3)) {
                String valueOf = String.valueOf(e2);
                new StringBuilder(String.valueOf(valueOf).length() + 40).append("Failed to read key from file, retrying: ").append(valueOf);
            }
            try {
                zzo zzd2 = zzd(zzj);
                AppMethodBeat.o(2536);
                return zzd2;
            } catch (IOException e3) {
                String valueOf2 = String.valueOf(e3);
                new StringBuilder(String.valueOf(valueOf2).length() + 45).append("IID file exists, but failed to read from it: ").append(valueOf2);
                zzp zzp = new zzp(e3);
                AppMethodBeat.o(2536);
                throw zzp;
            }
        }
    }

    static void zzi(Context context) {
        AppMethodBeat.i(2533);
        File[] listFiles = zzj(context).listFiles();
        for (File file : listFiles) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
        AppMethodBeat.o(2533);
    }

    private static File zzj(Context context) {
        AppMethodBeat.i(2538);
        File U = b.U(context);
        if (U == null || !U.isDirectory()) {
            File filesDir = context.getFilesDir();
            AppMethodBeat.o(2538);
            return filesDir;
        }
        AppMethodBeat.o(2538);
        return U;
    }

    private static File zzj(Context context, String str) {
        String sb;
        AppMethodBeat.i(2539);
        if (TextUtils.isEmpty(str)) {
            sb = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), 11);
                sb = new StringBuilder(String.valueOf(encodeToString).length() + 33).append("com.google.InstanceId_").append(encodeToString).append(".properties").toString();
            } catch (UnsupportedEncodingException e2) {
                AssertionError assertionError = new AssertionError(e2);
                AppMethodBeat.o(2539);
                throw assertionError;
            }
        }
        File file = new File(zzj(context), sb);
        AppMethodBeat.o(2539);
        return file;
    }

    /* access modifiers changed from: package-private */
    public final zzo zze(Context context, String str) {
        AppMethodBeat.i(2530);
        zzo zzh = zzh(context, str);
        if (zzh != null) {
            AppMethodBeat.o(2530);
            return zzh;
        }
        zzo zzf = zzf(context, str);
        AppMethodBeat.o(2530);
        return zzf;
    }

    /* access modifiers changed from: package-private */
    public final zzo zzf(Context context, String str) {
        AppMethodBeat.i(2531);
        zzo zzo = new zzo(zzd.zzk(), System.currentTimeMillis());
        try {
            zzo zzh = zzh(context, str);
            if (zzh != null) {
                Log.isLoggable("InstanceID", 3);
                AppMethodBeat.o(2531);
                return zzh;
            }
        } catch (zzp e2) {
        }
        Log.isLoggable("InstanceID", 3);
        zzd(context, str, zzo);
        zze(context, str, zzo);
        AppMethodBeat.o(2531);
        return zzo;
    }
}
