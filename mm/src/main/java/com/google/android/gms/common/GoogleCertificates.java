package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.internal.ICertData;
import com.google.android.gms.common.internal.IGoogleCertificatesApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.tencent.kinda.framework.app.KindaConfigCacheStg;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.CheckReturnValue;
import javax.annotation.concurrent.GuardedBy;

/* access modifiers changed from: package-private */
@CheckReturnValue
public final class GoogleCertificates {
    private static volatile IGoogleCertificatesApi zzax;
    private static final Object zzay = new Object();
    private static Context zzaz;
    @GuardedBy("GoogleCertificates.class")
    private static Set<ICertData> zzba;
    @GuardedBy("GoogleCertificates.class")
    private static Set<ICertData> zzbb;

    /* access modifiers changed from: package-private */
    public static abstract class CertData extends ICertData.Stub {
        private int zzbc;

        protected CertData(byte[] bArr) {
            Preconditions.checkArgument(bArr.length == 25);
            this.zzbc = Arrays.hashCode(bArr);
        }

        protected static byte[] zzd(String str) {
            try {
                return str.getBytes(KindaConfigCacheStg.SAVE_CHARSET);
            } catch (UnsupportedEncodingException e2) {
                throw new AssertionError(e2);
            }
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof ICertData)) {
                return false;
            }
            try {
                ICertData iCertData = (ICertData) obj;
                if (iCertData.getHashCode() != hashCode()) {
                    return false;
                }
                IObjectWrapper bytesWrapped = iCertData.getBytesWrapped();
                if (bytesWrapped == null) {
                    return false;
                }
                return Arrays.equals(getBytes(), (byte[]) ObjectWrapper.unwrap(bytesWrapped));
            } catch (RemoteException e2) {
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        public abstract byte[] getBytes();

        @Override // com.google.android.gms.common.internal.ICertData
        public IObjectWrapper getBytesWrapped() {
            return ObjectWrapper.wrap(getBytes());
        }

        @Override // com.google.android.gms.common.internal.ICertData
        public int getHashCode() {
            return hashCode();
        }

        public int hashCode() {
            return this.zzbc;
        }
    }

    static {
        AppMethodBeat.i(4406);
        AppMethodBeat.o(4406);
    }

    static synchronized void init(Context context) {
        synchronized (GoogleCertificates.class) {
            AppMethodBeat.i(4400);
            if (zzaz != null || context == null) {
                AppMethodBeat.o(4400);
            } else {
                zzaz = context.getApplicationContext();
                AppMethodBeat.o(4400);
            }
        }
    }

    static zzg zza(String str, CertData certData, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(4405);
        try {
            zzc();
            Preconditions.checkNotNull(zzaz);
            try {
                if (zzax.isGoogleOrPlatformSigned(new GoogleCertificatesQuery(str, certData, z), ObjectWrapper.wrap(zzaz.getPackageManager()))) {
                    zzg zzg = zzg.zzg();
                    AppMethodBeat.o(4405);
                    return zzg;
                }
                if (z || !zza(str, certData, true).zzbl) {
                    z2 = false;
                }
                zzg zza = zzg.zza(str, certData, z, z2);
                AppMethodBeat.o(4405);
                return zza;
            } catch (RemoteException e2) {
                zzg zza2 = zzg.zza("module call", e2);
                AppMethodBeat.o(4405);
                return zza2;
            }
        } catch (DynamiteModule.LoadingException e3) {
            zzg zza3 = zzg.zza("module init", e3);
            AppMethodBeat.o(4405);
            return zza3;
        }
    }

    private static Set<ICertData> zza(IBinder[] iBinderArr) {
        AppMethodBeat.i(4402);
        int length = iBinderArr.length;
        HashSet hashSet = new HashSet(length);
        for (IBinder iBinder : iBinderArr) {
            ICertData asInterface = ICertData.Stub.asInterface(iBinder);
            if (asInterface != null) {
                hashSet.add(asInterface);
            }
        }
        AppMethodBeat.o(4402);
        return hashSet;
    }

    private static void zzc() {
        AppMethodBeat.i(4401);
        if (zzax != null) {
            AppMethodBeat.o(4401);
            return;
        }
        Preconditions.checkNotNull(zzaz);
        synchronized (zzay) {
            try {
                if (zzax == null) {
                    zzax = IGoogleCertificatesApi.Stub.asInterface(DynamiteModule.load(zzaz, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "com.google.android.gms.googlecertificates").instantiate("com.google.android.gms.common.GoogleCertificatesImpl"));
                }
            } finally {
                AppMethodBeat.o(4401);
            }
        }
    }

    static synchronized Set<ICertData> zzd() {
        Set<ICertData> emptySet;
        synchronized (GoogleCertificates.class) {
            AppMethodBeat.i(4403);
            if (zzba != null) {
                emptySet = zzba;
                AppMethodBeat.o(4403);
            } else {
                try {
                    zzc();
                    try {
                        IObjectWrapper googleCertificates = zzax.getGoogleCertificates();
                        if (googleCertificates == null) {
                            emptySet = Collections.emptySet();
                            AppMethodBeat.o(4403);
                        } else {
                            zzba = zza((IBinder[]) ObjectWrapper.unwrap(googleCertificates));
                            emptySet = zzba;
                            AppMethodBeat.o(4403);
                        }
                    } catch (RemoteException e2) {
                        emptySet = Collections.emptySet();
                        AppMethodBeat.o(4403);
                    }
                } catch (DynamiteModule.LoadingException e3) {
                    emptySet = Collections.emptySet();
                    AppMethodBeat.o(4403);
                }
            }
        }
        return emptySet;
    }

    static synchronized Set<ICertData> zze() {
        Set<ICertData> emptySet;
        synchronized (GoogleCertificates.class) {
            AppMethodBeat.i(4404);
            if (zzbb != null) {
                emptySet = zzbb;
                AppMethodBeat.o(4404);
            } else {
                try {
                    zzc();
                    try {
                        IObjectWrapper googleReleaseCertificates = zzax.getGoogleReleaseCertificates();
                        if (googleReleaseCertificates == null) {
                            emptySet = Collections.emptySet();
                            AppMethodBeat.o(4404);
                        } else {
                            zzbb = zza((IBinder[]) ObjectWrapper.unwrap(googleReleaseCertificates));
                            emptySet = zzbb;
                            AppMethodBeat.o(4404);
                        }
                    } catch (RemoteException e2) {
                        emptySet = Collections.emptySet();
                        AppMethodBeat.o(4404);
                    }
                } catch (DynamiteModule.LoadingException e3) {
                    emptySet = Collections.emptySet();
                    AppMethodBeat.o(4404);
                }
            }
        }
        return emptySet;
    }
}
