package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import com.facebook.FacebookException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

public class AttributionIdentifiers {
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    private static final String TAG = AttributionIdentifiers.class.getCanonicalName();
    private static AttributionIdentifiers recentlyFetchedIdentifiers;
    private String androidAdvertiserId;
    private String androidInstallerPackage;
    private String attributionId;
    private long fetchTime;
    private boolean limitTracking;

    static {
        AppMethodBeat.i(17679);
        AppMethodBeat.o(17679);
    }

    private static AttributionIdentifiers getAndroidId(Context context) {
        AppMethodBeat.i(17673);
        AttributionIdentifiers androidIdViaReflection = getAndroidIdViaReflection(context);
        if (androidIdViaReflection == null && (androidIdViaReflection = getAndroidIdViaService(context)) == null) {
            androidIdViaReflection = new AttributionIdentifiers();
        }
        AppMethodBeat.o(17673);
        return androidIdViaReflection;
    }

    private static AttributionIdentifiers getAndroidIdViaReflection(Context context) {
        AppMethodBeat.i(17674);
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                FacebookException facebookException = new FacebookException("getAndroidId cannot be called on the main thread.");
                AppMethodBeat.o(17674);
                throw facebookException;
            }
            Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", Context.class);
            if (methodQuietly == null) {
                AppMethodBeat.o(17674);
                return null;
            }
            Object invokeMethodQuietly = Utility.invokeMethodQuietly(null, methodQuietly, context);
            if (!(invokeMethodQuietly instanceof Integer) || ((Integer) invokeMethodQuietly).intValue() != 0) {
                AppMethodBeat.o(17674);
                return null;
            }
            Method methodQuietly2 = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", Context.class);
            if (methodQuietly2 == null) {
                AppMethodBeat.o(17674);
                return null;
            }
            Object invokeMethodQuietly2 = Utility.invokeMethodQuietly(null, methodQuietly2, context);
            if (invokeMethodQuietly2 == null) {
                AppMethodBeat.o(17674);
                return null;
            }
            Method methodQuietly3 = Utility.getMethodQuietly(invokeMethodQuietly2.getClass(), "getId", new Class[0]);
            Method methodQuietly4 = Utility.getMethodQuietly(invokeMethodQuietly2.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
            if (methodQuietly3 == null || methodQuietly4 == null) {
                AppMethodBeat.o(17674);
                return null;
            }
            AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
            attributionIdentifiers.androidAdvertiserId = (String) Utility.invokeMethodQuietly(invokeMethodQuietly2, methodQuietly3, new Object[0]);
            attributionIdentifiers.limitTracking = ((Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly2, methodQuietly4, new Object[0])).booleanValue();
            AppMethodBeat.o(17674);
            return attributionIdentifiers;
        } catch (Exception e2) {
            Utility.logd("android_id", e2);
            AppMethodBeat.o(17674);
            return null;
        }
    }

    private static AttributionIdentifiers getAndroidIdViaService(Context context) {
        AppMethodBeat.i(17675);
        GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (context.bindService(intent, googleAdServiceConnection, 1)) {
            try {
                GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                attributionIdentifiers.androidAdvertiserId = googleAdInfo.getAdvertiserId();
                attributionIdentifiers.limitTracking = googleAdInfo.isTrackingLimited();
                context.unbindService(googleAdServiceConnection);
                AppMethodBeat.o(17675);
                return attributionIdentifiers;
            } catch (Exception e2) {
                Utility.logd("android_id", e2);
                context.unbindService(googleAdServiceConnection);
            } catch (Throwable th) {
                context.unbindService(googleAdServiceConnection);
                AppMethodBeat.o(17675);
                throw th;
            }
        }
        AppMethodBeat.o(17675);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0109  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.internal.AttributionIdentifiers getAttributionIdentifiers(android.content.Context r9) {
        /*
        // Method dump skipped, instructions count: 279
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.getAttributionIdentifiers(android.content.Context):com.facebook.internal.AttributionIdentifiers");
    }

    private static AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
        AppMethodBeat.i(17677);
        attributionIdentifiers.fetchTime = System.currentTimeMillis();
        recentlyFetchedIdentifiers = attributionIdentifiers;
        AppMethodBeat.o(17677);
        return attributionIdentifiers;
    }

    public String getAttributionId() {
        return this.attributionId;
    }

    public String getAndroidAdvertiserId() {
        return this.androidAdvertiserId;
    }

    public String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public boolean isTrackingLimited() {
        return this.limitTracking;
    }

    private static String getInstallerPackageName(Context context) {
        AppMethodBeat.i(17678);
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            String installerPackageName = packageManager.getInstallerPackageName(context.getPackageName());
            AppMethodBeat.o(17678);
            return installerPackageName;
        }
        AppMethodBeat.o(17678);
        return null;
    }

    /* access modifiers changed from: package-private */
    public static final class GoogleAdServiceConnection implements ServiceConnection {
        private AtomicBoolean consumed;
        private final BlockingQueue<IBinder> queue;

        private GoogleAdServiceConnection() {
            AppMethodBeat.i(17670);
            this.consumed = new AtomicBoolean(false);
            this.queue = new LinkedBlockingDeque();
            AppMethodBeat.o(17670);
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(17671);
            if (iBinder != null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException e2) {
                    AppMethodBeat.o(17671);
                    return;
                }
            }
            AppMethodBeat.o(17671);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }

        public final IBinder getBinder() {
            AppMethodBeat.i(17672);
            if (this.consumed.compareAndSet(true, true)) {
                IllegalStateException illegalStateException = new IllegalStateException("Binder already consumed");
                AppMethodBeat.o(17672);
                throw illegalStateException;
            }
            IBinder take = this.queue.take();
            AppMethodBeat.o(17672);
            return take;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class GoogleAdInfo implements IInterface {
        private static final int FIRST_TRANSACTION_CODE = 1;
        private static final int SECOND_TRANSACTION_CODE = 2;
        private IBinder binder;

        GoogleAdInfo(IBinder iBinder) {
            this.binder = iBinder;
        }

        public final IBinder asBinder() {
            return this.binder;
        }

        public final String getAdvertiserId() {
            AppMethodBeat.i(17668);
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
                AppMethodBeat.o(17668);
            }
        }

        public final boolean isTrackingLimited() {
            boolean z = true;
            AppMethodBeat.i(17669);
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                obtain.writeInt(1);
                this.binder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
                AppMethodBeat.o(17669);
            }
        }
    }
}
