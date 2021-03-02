package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.IDynamiteLoader;
import com.google.android.gms.dynamite.IDynamiteLoaderV2;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

public final class DynamiteModule {
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzd();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zze();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzf();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION_NO_FORCE_STAGING = new zzg();
    public static final VersionPolicy PREFER_LOCAL = new zzc();
    public static final VersionPolicy PREFER_REMOTE = new zzb();
    @GuardedBy("DynamiteModule.class")
    private static Boolean zzabr;
    @GuardedBy("DynamiteModule.class")
    private static IDynamiteLoader zzabs;
    @GuardedBy("DynamiteModule.class")
    private static IDynamiteLoaderV2 zzabt;
    @GuardedBy("DynamiteModule.class")
    private static String zzabu;
    private static final ThreadLocal<zza> zzabv = new ThreadLocal<>();
    private static final VersionPolicy.IVersions zzabw = new zza();
    private final Context zzabx;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        @GuardedBy("DynamiteLoaderClassLoader.class")
        public static ClassLoader sClassLoader;
    }

    public static class LoadingException extends Exception {
        private LoadingException(String str) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, zza zza) {
            this(str);
        }

        private LoadingException(String str, Throwable th) {
            super(str, th);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zza zza) {
            this(str, th);
        }
    }

    public interface VersionPolicy {

        public interface IVersions {
            int getLocalVersion(Context context, String str);

            int getRemoteVersion(Context context, String str, boolean z);
        }

        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions);
    }

    /* access modifiers changed from: package-private */
    public static class zza {
        public Cursor zzaby;

        private zza() {
        }

        /* synthetic */ zza(zza zza) {
            this();
        }
    }

    static class zzb implements VersionPolicy.IVersions {
        private final int zzabz;
        private final int zzaca = 0;

        public zzb(int i2, int i3) {
            this.zzabz = i2;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions
        public final int getLocalVersion(Context context, String str) {
            return this.zzabz;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy.IVersions
        public final int getRemoteVersion(Context context, String str, boolean z) {
            return 0;
        }
    }

    static {
        AppMethodBeat.i(5463);
        AppMethodBeat.o(5463);
    }

    private DynamiteModule(Context context) {
        AppMethodBeat.i(5462);
        this.zzabx = (Context) Preconditions.checkNotNull(context);
        AppMethodBeat.o(5462);
    }

    public static int getLocalVersion(Context context, String str) {
        AppMethodBeat.i(5447);
        try {
            Class<?> loadClass = context.getApplicationContext().getClassLoader().loadClass(new StringBuilder(String.valueOf(str).length() + 61).append("com.google.android.gms.dynamite.descriptors.").append(str).append(".ModuleDescriptor").toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (!declaredField.get(null).equals(str)) {
                String valueOf = String.valueOf(declaredField.get(null));
                new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf).append("' didn't match expected id '").append(str).append("'");
                AppMethodBeat.o(5447);
                return 0;
            }
            int i2 = declaredField2.getInt(null);
            AppMethodBeat.o(5447);
            return i2;
        } catch (ClassNotFoundException e2) {
            new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.");
            AppMethodBeat.o(5447);
            return 0;
        } catch (Exception e3) {
            String valueOf2 = String.valueOf(e3.getMessage());
            if (valueOf2.length() != 0) {
                "Failed to load module descriptor class: ".concat(valueOf2);
            } else {
                new String("Failed to load module descriptor class: ");
            }
            AppMethodBeat.o(5447);
            return 0;
        }
    }

    public static Uri getQueryUri(String str, boolean z) {
        AppMethodBeat.i(5453);
        String str2 = z ? ProviderConstants.API_PATH_FORCE_STAGING : ProviderConstants.API_PATH;
        Uri parse = Uri.parse(new StringBuilder(String.valueOf(str2).length() + 42 + String.valueOf(str).length()).append("content://com.google.android.gms.chimera/").append(str2).append(FilePathGenerator.ANDROID_DIR_SEP).append(str).toString());
        AppMethodBeat.o(5453);
        return parse;
    }

    public static int getRemoteVersion(Context context, String str) {
        AppMethodBeat.i(5451);
        int remoteVersion = getRemoteVersion(context, str, false);
        AppMethodBeat.o(5451);
        return remoteVersion;
    }

    public static int getRemoteVersion(Context context, String str, boolean z) {
        AppMethodBeat.i(5448);
        synchronized (DynamiteModule.class) {
            try {
                Boolean bool = zzabr;
                if (bool == null) {
                    try {
                        Class<?> loadClass = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName());
                        Field declaredField = loadClass.getDeclaredField("sClassLoader");
                        synchronized (loadClass) {
                            try {
                                ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                                if (classLoader != null) {
                                    if (classLoader == ClassLoader.getSystemClassLoader()) {
                                        bool = Boolean.FALSE;
                                    } else {
                                        try {
                                            zza(classLoader);
                                        } catch (LoadingException e2) {
                                        }
                                        bool = Boolean.TRUE;
                                    }
                                } else if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                } else {
                                    try {
                                        int zzb2 = zzb(context, str, z);
                                        if (zzabu == null || zzabu.isEmpty()) {
                                            return zzb2;
                                        }
                                        zzh zzh = new zzh(zzabu, ClassLoader.getSystemClassLoader());
                                        zza(zzh);
                                        declaredField.set(null, zzh);
                                        zzabr = Boolean.TRUE;
                                        AppMethodBeat.o(5448);
                                        return zzb2;
                                    } catch (LoadingException e3) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                        zzabr = bool;
                                        if (bool.booleanValue()) {
                                            try {
                                                int zzb3 = zzb(context, str, z);
                                                AppMethodBeat.o(5448);
                                                return zzb3;
                                            } catch (LoadingException e4) {
                                                String valueOf = String.valueOf(e4.getMessage());
                                                if (valueOf.length() != 0) {
                                                    "Failed to retrieve remote module version: ".concat(valueOf);
                                                } else {
                                                    new String("Failed to retrieve remote module version: ");
                                                }
                                                AppMethodBeat.o(5448);
                                                return 0;
                                            }
                                        } else {
                                            int zza2 = zza(context, str, z);
                                            AppMethodBeat.o(5448);
                                            return zza2;
                                        }
                                    }
                                }
                            } catch (Throwable th) {
                                AppMethodBeat.o(5448);
                                throw th;
                            }
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e5) {
                        String valueOf2 = String.valueOf(e5);
                        new StringBuilder(String.valueOf(valueOf2).length() + 30).append("Failed to load module via V2: ").append(valueOf2);
                        bool = Boolean.FALSE;
                    }
                }
            } finally {
                AppMethodBeat.o(5448);
            }
        }
    }

    @VisibleForTesting
    public static synchronized Boolean getUseV2ForTesting() {
        Boolean bool;
        synchronized (DynamiteModule.class) {
            bool = zzabr;
        }
        return bool;
    }

    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) {
        AppMethodBeat.i(5446);
        zza zza2 = zzabv.get();
        zza zza3 = new zza(null);
        zzabv.set(zza3);
        try {
            VersionPolicy.SelectionResult selectModule = versionPolicy.selectModule(context, str, zzabw);
            int i2 = selectModule.localVersion;
            new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(i2).append(" and remote module ").append(str).append(":").append(selectModule.remoteVersion);
            if (selectModule.selection == 0 || ((selectModule.selection == -1 && selectModule.localVersion == 0) || (selectModule.selection == 1 && selectModule.remoteVersion == 0))) {
                int i3 = selectModule.localVersion;
                LoadingException loadingException = new LoadingException(new StringBuilder(91).append("No acceptable module found. Local version is ").append(i3).append(" and remote version is ").append(selectModule.remoteVersion).append(".").toString(), (zza) null);
                AppMethodBeat.o(5446);
                throw loadingException;
            } else if (selectModule.selection == -1) {
                return zzd(context, str);
            } else if (selectModule.selection == 1) {
                try {
                    DynamiteModule zza4 = zza(context, str, selectModule.remoteVersion);
                    if (zza3.zzaby != null) {
                        zza3.zzaby.close();
                    }
                    zzabv.set(zza2);
                    AppMethodBeat.o(5446);
                    return zza4;
                } catch (LoadingException e2) {
                    String valueOf = String.valueOf(e2.getMessage());
                    if (valueOf.length() != 0) {
                        "Failed to load remote module: ".concat(valueOf);
                    } else {
                        new String("Failed to load remote module: ");
                    }
                    if (selectModule.localVersion == 0 || versionPolicy.selectModule(context, str, new zzb(selectModule.localVersion, 0)).selection != -1) {
                        LoadingException loadingException2 = new LoadingException("Remote load failed. No local fallback found.", e2, null);
                        AppMethodBeat.o(5446);
                        throw loadingException2;
                    }
                    DynamiteModule zzd = zzd(context, str);
                    if (zza3.zzaby != null) {
                        zza3.zzaby.close();
                    }
                    zzabv.set(zza2);
                    AppMethodBeat.o(5446);
                    return zzd;
                }
            } else {
                LoadingException loadingException3 = new LoadingException(new StringBuilder(47).append("VersionPolicy returned invalid code:").append(selectModule.selection).toString(), (zza) null);
                AppMethodBeat.o(5446);
                throw loadingException3;
            }
        } finally {
            if (zza3.zzaby != null) {
                zza3.zzaby.close();
            }
            zzabv.set(zza2);
            AppMethodBeat.o(5446);
        }
    }

    public static Cursor queryForDynamiteModule(Context context, String str, boolean z) {
        AppMethodBeat.i(5452);
        Cursor query = context.getContentResolver().query(getQueryUri(str, z), null, null, null, null);
        AppMethodBeat.o(5452);
        return query;
    }

    @VisibleForTesting
    public static synchronized void resetInternalStateForTesting() {
        synchronized (DynamiteModule.class) {
            zzabs = null;
            zzabt = null;
            zzabu = null;
            zzabr = null;
            synchronized (DynamiteLoaderClassLoader.class) {
                DynamiteLoaderClassLoader.sClassLoader = null;
            }
        }
    }

    @VisibleForTesting
    public static synchronized void setUseV2ForTesting(Boolean bool) {
        synchronized (DynamiteModule.class) {
            zzabr = bool;
        }
    }

    private static int zza(Context context, String str, boolean z) {
        int i2 = 0;
        AppMethodBeat.i(5449);
        IDynamiteLoader zzg = zzg(context);
        if (zzg == null) {
            AppMethodBeat.o(5449);
        } else {
            try {
                i2 = zzg.getModuleVersion2(ObjectWrapper.wrap(context), str, z);
                AppMethodBeat.o(5449);
            } catch (RemoteException e2) {
                String valueOf = String.valueOf(e2.getMessage());
                if (valueOf.length() != 0) {
                    "Failed to retrieve remote module version: ".concat(valueOf);
                } else {
                    new String("Failed to retrieve remote module version: ");
                }
                AppMethodBeat.o(5449);
            }
        }
        return i2;
    }

    private static Context zza(Context context, String str, int i2, Cursor cursor, IDynamiteLoaderV2 iDynamiteLoaderV2) {
        AppMethodBeat.i(5459);
        try {
            Context context2 = (Context) ObjectWrapper.unwrap(iDynamiteLoaderV2.loadModule2(ObjectWrapper.wrap(context), str, i2, ObjectWrapper.wrap(cursor)));
            AppMethodBeat.o(5459);
            return context2;
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.toString());
            if (valueOf.length() != 0) {
                "Failed to load DynamiteLoader: ".concat(valueOf);
            } else {
                new String("Failed to load DynamiteLoader: ");
            }
            AppMethodBeat.o(5459);
            return null;
        }
    }

    private static DynamiteModule zza(Context context, String str, int i2) {
        Boolean bool;
        AppMethodBeat.i(5455);
        synchronized (DynamiteModule.class) {
            try {
                bool = zzabr;
            } catch (Throwable th) {
                AppMethodBeat.o(5455);
                throw th;
            }
        }
        if (bool == null) {
            LoadingException loadingException = new LoadingException("Failed to determine which loading route to use.", (zza) null);
            AppMethodBeat.o(5455);
            throw loadingException;
        } else if (bool.booleanValue()) {
            DynamiteModule zzc = zzc(context, str, i2);
            AppMethodBeat.o(5455);
            return zzc;
        } else {
            DynamiteModule zzb2 = zzb(context, str, i2);
            AppMethodBeat.o(5455);
            return zzb2;
        }
    }

    @GuardedBy("DynamiteModule.class")
    private static void zza(ClassLoader classLoader) {
        AppMethodBeat.i(5460);
        try {
            zzabt = IDynamiteLoaderV2.Stub.asInterface((IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]));
            AppMethodBeat.o(5460);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            LoadingException loadingException = new LoadingException("Failed to instantiate dynamite loader", e2, null);
            AppMethodBeat.o(5460);
            throw loadingException;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0026 A[Catch:{ all -> 0x002c }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x006a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(android.content.Context r6, java.lang.String r7, boolean r8) {
        /*
        // Method dump skipped, instructions count: 127
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean):int");
    }

    private static DynamiteModule zzb(Context context, String str, int i2) {
        AppMethodBeat.i(5456);
        new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i2);
        IDynamiteLoader zzg = zzg(context);
        if (zzg == null) {
            LoadingException loadingException = new LoadingException("Failed to create IDynamiteLoader.", (zza) null);
            AppMethodBeat.o(5456);
            throw loadingException;
        }
        try {
            IObjectWrapper createModuleContext = zzg.createModuleContext(ObjectWrapper.wrap(context), str, i2);
            if (ObjectWrapper.unwrap(createModuleContext) == null) {
                LoadingException loadingException2 = new LoadingException("Failed to load remote module.", (zza) null);
                AppMethodBeat.o(5456);
                throw loadingException2;
            }
            DynamiteModule dynamiteModule = new DynamiteModule((Context) ObjectWrapper.unwrap(createModuleContext));
            AppMethodBeat.o(5456);
            return dynamiteModule;
        } catch (RemoteException e2) {
            LoadingException loadingException3 = new LoadingException("Failed to load remote module.", e2, null);
            AppMethodBeat.o(5456);
            throw loadingException3;
        }
    }

    private static DynamiteModule zzc(Context context, String str, int i2) {
        IDynamiteLoaderV2 iDynamiteLoaderV2;
        AppMethodBeat.i(5458);
        new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i2);
        synchronized (DynamiteModule.class) {
            try {
                iDynamiteLoaderV2 = zzabt;
            } catch (Throwable th) {
                AppMethodBeat.o(5458);
                throw th;
            }
        }
        if (iDynamiteLoaderV2 == null) {
            LoadingException loadingException = new LoadingException("DynamiteLoaderV2 was not cached.", (zza) null);
            AppMethodBeat.o(5458);
            throw loadingException;
        }
        zza zza2 = zzabv.get();
        if (zza2 == null || zza2.zzaby == null) {
            LoadingException loadingException2 = new LoadingException("No result cursor", (zza) null);
            AppMethodBeat.o(5458);
            throw loadingException2;
        }
        Context zza3 = zza(context.getApplicationContext(), str, i2, zza2.zzaby, iDynamiteLoaderV2);
        if (zza3 == null) {
            LoadingException loadingException3 = new LoadingException("Failed to get module context", (zza) null);
            AppMethodBeat.o(5458);
            throw loadingException3;
        }
        DynamiteModule dynamiteModule = new DynamiteModule(zza3);
        AppMethodBeat.o(5458);
        return dynamiteModule;
    }

    private static DynamiteModule zzd(Context context, String str) {
        AppMethodBeat.i(5454);
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            "Selected local version of ".concat(valueOf);
        } else {
            new String("Selected local version of ");
        }
        DynamiteModule dynamiteModule = new DynamiteModule(context.getApplicationContext());
        AppMethodBeat.o(5454);
        return dynamiteModule;
    }

    private static IDynamiteLoader zzg(Context context) {
        AppMethodBeat.i(5457);
        synchronized (DynamiteModule.class) {
            try {
                if (zzabs != null) {
                    return zzabs;
                } else if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context) != 0) {
                    AppMethodBeat.o(5457);
                    return null;
                } else {
                    try {
                        IDynamiteLoader asInterface = IDynamiteLoader.Stub.asInterface((IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance());
                        if (asInterface != null) {
                            zzabs = asInterface;
                            AppMethodBeat.o(5457);
                            return asInterface;
                        }
                    } catch (Exception e2) {
                        String valueOf = String.valueOf(e2.getMessage());
                        if (valueOf.length() != 0) {
                            "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf);
                        } else {
                            new String("Failed to load IDynamiteLoader from GmsCore: ");
                        }
                    }
                    AppMethodBeat.o(5457);
                    return null;
                }
            } finally {
                AppMethodBeat.o(5457);
            }
        }
    }

    public final Context getModuleContext() {
        return this.zzabx;
    }

    public final IBinder instantiate(String str) {
        AppMethodBeat.i(5461);
        try {
            IBinder iBinder = (IBinder) this.zzabx.getClassLoader().loadClass(str).newInstance();
            AppMethodBeat.o(5461);
            return iBinder;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            String valueOf = String.valueOf(str);
            LoadingException loadingException = new LoadingException(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e2, null);
            AppMethodBeat.o(5461);
            throw loadingException;
        }
    }
}
