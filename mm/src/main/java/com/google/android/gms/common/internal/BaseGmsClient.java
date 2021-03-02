package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

public abstract class BaseGmsClient<T extends IInterface> {
    public static final int CONNECT_STATE_CONNECTED = 4;
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    public static final int CONNECT_STATE_LOCAL_CONNECTING = 3;
    public static final int CONNECT_STATE_REMOTE_CONNECTING = 2;
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final String FEATURE_GOOGLE_ME = "service_googleme";
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", FEATURE_GOOGLE_ME};
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private static final Feature[] zzqz = new Feature[0];
    @VisibleForTesting
    protected ConnectionProgressReportCallbacks mConnectionProgressReportCallbacks;
    private final Context mContext;
    @VisibleForTesting
    protected AtomicInteger mDisconnectCount;
    final Handler mHandler;
    private final Object mLock;
    private final Looper zzcn;
    private final GoogleApiAvailabilityLight zzgk;
    private int zzra;
    private long zzrb;
    private long zzrc;
    private int zzrd;
    private long zzre;
    @VisibleForTesting
    private GmsServiceEndpoint zzrf;
    private final GmsClientSupervisor zzrg;
    private final Object zzrh;
    @GuardedBy("mServiceBrokerLock")
    private IGmsServiceBroker zzri;
    @GuardedBy("mLock")
    private T zzrj;
    private final ArrayList<BaseGmsClient<T>.CallbackProxy> zzrk;
    @GuardedBy("mLock")
    private BaseGmsClient<T>.GmsServiceConnection zzrl;
    @GuardedBy("mLock")
    private int zzrm;
    private final BaseConnectionCallbacks zzrn;
    private final BaseOnConnectionFailedListener zzro;
    private final int zzrp;
    private final String zzrq;
    private ConnectionResult zzrr;
    private boolean zzrs;
    private volatile ConnectionInfo zzrt;

    public interface BaseConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i2);
    }

    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    /* access modifiers changed from: protected */
    public abstract class CallbackProxy<TListener> {
        private TListener zzli;
        private boolean zzrv = false;

        public CallbackProxy(TListener tlistener) {
            this.zzli = tlistener;
        }

        public void deliverCallback() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.zzli;
                if (this.zzrv) {
                    String valueOf = String.valueOf(this);
                    new StringBuilder(String.valueOf(valueOf).length() + 47).append("Callback proxy ").append(valueOf).append(" being reused. This is not safe.");
                }
            }
            if (tlistener != null) {
                try {
                    deliverCallback(tlistener);
                } catch (RuntimeException e2) {
                    onDeliverCallbackFailed();
                    throw e2;
                }
            } else {
                onDeliverCallbackFailed();
            }
            synchronized (this) {
                this.zzrv = true;
            }
            unregister();
        }

        /* access modifiers changed from: protected */
        public abstract void deliverCallback(TListener tlistener);

        /* access modifiers changed from: protected */
        public abstract void onDeliverCallbackFailed();

        public void removeListener() {
            synchronized (this) {
                this.zzli = null;
            }
        }

        public void unregister() {
            removeListener();
            synchronized (BaseGmsClient.this.zzrk) {
                BaseGmsClient.this.zzrk.remove(this);
            }
        }
    }

    public interface ConnectionProgressReportCallbacks {
        void onReportServiceBinding(ConnectionResult connectionResult);
    }

    @VisibleForTesting
    public static final class GmsCallbacks extends IGmsCallbacks.Stub {
        private BaseGmsClient zzrw;
        private final int zzrx;

        public GmsCallbacks(BaseGmsClient baseGmsClient, int i2) {
            this.zzrw = baseGmsClient;
            this.zzrx = i2;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void onAccountValidationComplete(int i2, Bundle bundle) {
            AppMethodBeat.i(4592);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
            AppMethodBeat.o(4592);
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void onPostInitComplete(int i2, IBinder iBinder, Bundle bundle) {
            AppMethodBeat.i(4593);
            Preconditions.checkNotNull(this.zzrw, "onPostInitComplete can be called only once per call to getRemoteService");
            this.zzrw.onPostInitHandler(i2, iBinder, bundle, this.zzrx);
            this.zzrw = null;
            AppMethodBeat.o(4593);
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        public final void onPostInitCompleteWithConnectionInfo(int i2, IBinder iBinder, ConnectionInfo connectionInfo) {
            AppMethodBeat.i(4594);
            Preconditions.checkNotNull(this.zzrw, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            Preconditions.checkNotNull(connectionInfo);
            this.zzrw.zza((BaseGmsClient) connectionInfo);
            onPostInitComplete(i2, iBinder, connectionInfo.getResolutionBundle());
            AppMethodBeat.o(4594);
        }
    }

    @VisibleForTesting
    public final class GmsServiceConnection implements ServiceConnection {
        private final int zzrx;

        public GmsServiceConnection(int i2) {
            this.zzrx = i2;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            AppMethodBeat.i(4595);
            if (iBinder == null) {
                BaseGmsClient.this.zzj(16);
                AppMethodBeat.o(4595);
                return;
            }
            synchronized (BaseGmsClient.this.zzrh) {
                try {
                    BaseGmsClient.this.zzri = IGmsServiceBroker.Stub.asInterface(iBinder);
                } catch (Throwable th) {
                    AppMethodBeat.o(4595);
                    throw th;
                }
            }
            BaseGmsClient.this.onPostServiceBindingHandler(0, null, this.zzrx);
            AppMethodBeat.o(4595);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            AppMethodBeat.i(4596);
            synchronized (BaseGmsClient.this.zzrh) {
                try {
                    BaseGmsClient.this.zzri = null;
                } catch (Throwable th) {
                    AppMethodBeat.o(4596);
                    throw th;
                }
            }
            BaseGmsClient.this.mHandler.sendMessage(BaseGmsClient.this.mHandler.obtainMessage(6, this.zzrx, 1));
            AppMethodBeat.o(4596);
        }
    }

    public class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        public LegacyClientCallbackAdapter() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public void onReportServiceBinding(ConnectionResult connectionResult) {
            AppMethodBeat.i(4597);
            if (connectionResult.isSuccess()) {
                BaseGmsClient.this.getRemoteService(null, BaseGmsClient.this.getScopes());
                AppMethodBeat.o(4597);
                return;
            }
            if (BaseGmsClient.this.zzro != null) {
                BaseGmsClient.this.zzro.onConnectionFailed(connectionResult);
            }
            AppMethodBeat.o(4597);
        }
    }

    /* access modifiers changed from: protected */
    public final class PostInitCallback extends zza {
        public final IBinder service;

        public PostInitCallback(int i2, IBinder iBinder, Bundle bundle) {
            super(i2, bundle);
            this.service = iBinder;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final void handleServiceFailure(ConnectionResult connectionResult) {
            AppMethodBeat.i(4598);
            if (BaseGmsClient.this.zzro != null) {
                BaseGmsClient.this.zzro.onConnectionFailed(connectionResult);
            }
            BaseGmsClient.this.onConnectionFailed(connectionResult);
            AppMethodBeat.o(4598);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final boolean handleServiceSuccess() {
            AppMethodBeat.i(4599);
            try {
                String interfaceDescriptor = this.service.getInterfaceDescriptor();
                if (!BaseGmsClient.this.getServiceDescriptor().equals(interfaceDescriptor)) {
                    String serviceDescriptor = BaseGmsClient.this.getServiceDescriptor();
                    new StringBuilder(String.valueOf(serviceDescriptor).length() + 34 + String.valueOf(interfaceDescriptor).length()).append("service descriptor mismatch: ").append(serviceDescriptor).append(" vs. ").append(interfaceDescriptor);
                    AppMethodBeat.o(4599);
                    return false;
                }
                IInterface createServiceInterface = BaseGmsClient.this.createServiceInterface(this.service);
                if (createServiceInterface == null || (!BaseGmsClient.this.zza((BaseGmsClient) 2, 4, (int) createServiceInterface) && !BaseGmsClient.this.zza((BaseGmsClient) 3, 4, (int) createServiceInterface))) {
                    AppMethodBeat.o(4599);
                    return false;
                }
                BaseGmsClient.this.zzrr = null;
                Bundle connectionHint = BaseGmsClient.this.getConnectionHint();
                if (BaseGmsClient.this.zzrn != null) {
                    BaseGmsClient.this.zzrn.onConnected(connectionHint);
                }
                AppMethodBeat.o(4599);
                return true;
            } catch (RemoteException e2) {
                AppMethodBeat.o(4599);
                return false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final class PostServiceBindingCallback extends zza {
        public PostServiceBindingCallback(int i2, Bundle bundle) {
            super(i2, bundle);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final void handleServiceFailure(ConnectionResult connectionResult) {
            AppMethodBeat.i(4600);
            BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(connectionResult);
            BaseGmsClient.this.onConnectionFailed(connectionResult);
            AppMethodBeat.o(4600);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final boolean handleServiceSuccess() {
            AppMethodBeat.i(4601);
            BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
            AppMethodBeat.o(4601);
            return true;
        }
    }

    public interface SignOutCallbacks {
        void onSignOutComplete();
    }

    abstract class zza extends BaseGmsClient<T>.CallbackProxy {
        public final Bundle resolution;
        public final int statusCode;

        protected zza(int i2, Bundle bundle) {
            super(Boolean.TRUE);
            this.statusCode = i2;
            this.resolution = bundle;
        }

        /* access modifiers changed from: protected */
        public void deliverCallback(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                BaseGmsClient.this.zza((BaseGmsClient) 1, (int) null);
                return;
            }
            switch (this.statusCode) {
                case 0:
                    if (!handleServiceSuccess()) {
                        BaseGmsClient.this.zza((BaseGmsClient) 1, (int) null);
                        handleServiceFailure(new ConnectionResult(8, null));
                        return;
                    }
                    return;
                case 10:
                    BaseGmsClient.this.zza((BaseGmsClient) 1, (int) null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    BaseGmsClient.this.zza((BaseGmsClient) 1, (int) null);
                    if (this.resolution != null) {
                        pendingIntent = (PendingIntent) this.resolution.getParcelable(BaseGmsClient.KEY_PENDING_INTENT);
                    }
                    handleServiceFailure(new ConnectionResult(this.statusCode, pendingIntent));
                    return;
            }
        }

        /* access modifiers changed from: protected */
        public abstract void handleServiceFailure(ConnectionResult connectionResult);

        /* access modifiers changed from: protected */
        public abstract boolean handleServiceSuccess();

        /* access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.BaseGmsClient.CallbackProxy
        public void onDeliverCallbackFailed() {
        }
    }

    final class zzb extends Handler {
        public zzb(Looper looper) {
            super(looper);
        }

        private static void zza(Message message) {
            AppMethodBeat.i(4603);
            CallbackProxy callbackProxy = (CallbackProxy) message.obj;
            callbackProxy.onDeliverCallbackFailed();
            callbackProxy.unregister();
            AppMethodBeat.o(4603);
        }

        private static boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 7;
        }

        public final void handleMessage(Message message) {
            PendingIntent pendingIntent = null;
            AppMethodBeat.i(4602);
            if (BaseGmsClient.this.mDisconnectCount.get() != message.arg1) {
                if (zzb(message)) {
                    zza(message);
                }
                AppMethodBeat.o(4602);
            } else if ((message.what == 1 || message.what == 7 || message.what == 4 || message.what == 5) && !BaseGmsClient.this.isConnecting()) {
                zza(message);
                AppMethodBeat.o(4602);
            } else if (message.what == 4) {
                BaseGmsClient.this.zzrr = new ConnectionResult(message.arg2);
                if (!BaseGmsClient.this.zzcr() || BaseGmsClient.this.zzrs) {
                    ConnectionResult connectionResult = BaseGmsClient.this.zzrr != null ? BaseGmsClient.this.zzrr : new ConnectionResult(8);
                    BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(connectionResult);
                    BaseGmsClient.this.onConnectionFailed(connectionResult);
                    AppMethodBeat.o(4602);
                    return;
                }
                BaseGmsClient.this.zza((BaseGmsClient) 3, (int) null);
                AppMethodBeat.o(4602);
            } else if (message.what == 5) {
                ConnectionResult connectionResult2 = BaseGmsClient.this.zzrr != null ? BaseGmsClient.this.zzrr : new ConnectionResult(8);
                BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(connectionResult2);
                BaseGmsClient.this.onConnectionFailed(connectionResult2);
                AppMethodBeat.o(4602);
            } else if (message.what == 3) {
                if (message.obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) message.obj;
                }
                ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, pendingIntent);
                BaseGmsClient.this.mConnectionProgressReportCallbacks.onReportServiceBinding(connectionResult3);
                BaseGmsClient.this.onConnectionFailed(connectionResult3);
                AppMethodBeat.o(4602);
            } else if (message.what == 6) {
                BaseGmsClient.this.zza((BaseGmsClient) 5, (int) null);
                if (BaseGmsClient.this.zzrn != null) {
                    BaseGmsClient.this.zzrn.onConnectionSuspended(message.arg2);
                }
                BaseGmsClient.this.onConnectionSuspended(message.arg2);
                BaseGmsClient.this.zza((BaseGmsClient) 5, 1, (int) null);
                AppMethodBeat.o(4602);
            } else if (message.what == 2 && !BaseGmsClient.this.isConnected()) {
                zza(message);
                AppMethodBeat.o(4602);
            } else if (zzb(message)) {
                ((CallbackProxy) message.obj).deliverCallback();
                AppMethodBeat.o(4602);
            } else {
                Log.wtf("GmsClient", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
                AppMethodBeat.o(4602);
            }
        }
    }

    @VisibleForTesting
    protected BaseGmsClient(Context context, Handler handler, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i2, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        this.mLock = new Object();
        this.zzrh = new Object();
        this.zzrk = new ArrayList<>();
        this.zzrm = 1;
        this.zzrr = null;
        this.zzrs = false;
        this.zzrt = null;
        this.mDisconnectCount = new AtomicInteger(0);
        this.mContext = (Context) Preconditions.checkNotNull(context, "Context must not be null");
        this.mHandler = (Handler) Preconditions.checkNotNull(handler, "Handler must not be null");
        this.zzcn = handler.getLooper();
        this.zzrg = (GmsClientSupervisor) Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzgk = (GoogleApiAvailabilityLight) Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzrp = i2;
        this.zzrn = baseConnectionCallbacks;
        this.zzro = baseOnConnectionFailedListener;
        this.zzrq = null;
    }

    protected BaseGmsClient(Context context, Looper looper, int i2, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailabilityLight.getInstance(), i2, (BaseConnectionCallbacks) Preconditions.checkNotNull(baseConnectionCallbacks), (BaseOnConnectionFailedListener) Preconditions.checkNotNull(baseOnConnectionFailedListener), str);
    }

    @VisibleForTesting
    protected BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i2, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.mLock = new Object();
        this.zzrh = new Object();
        this.zzrk = new ArrayList<>();
        this.zzrm = 1;
        this.zzrr = null;
        this.zzrs = false;
        this.zzrt = null;
        this.mDisconnectCount = new AtomicInteger(0);
        this.mContext = (Context) Preconditions.checkNotNull(context, "Context must not be null");
        this.zzcn = (Looper) Preconditions.checkNotNull(looper, "Looper must not be null");
        this.zzrg = (GmsClientSupervisor) Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzgk = (GoogleApiAvailabilityLight) Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.mHandler = new zzb(looper);
        this.zzrp = i2;
        this.zzrn = baseConnectionCallbacks;
        this.zzro = baseOnConnectionFailedListener;
        this.zzrq = str;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(int i2, T t) {
        boolean z = true;
        if ((i2 == 4) != (t != null)) {
            z = false;
        }
        Preconditions.checkArgument(z);
        synchronized (this.mLock) {
            this.zzrm = i2;
            this.zzrj = t;
            onSetConnectState(i2, t);
            switch (i2) {
                case 1:
                    if (this.zzrl != null) {
                        this.zzrg.unbindService(getStartServiceAction(), getStartServicePackage(), getServiceBindFlags(), this.zzrl, getRealClientName());
                        this.zzrl = null;
                        break;
                    }
                    break;
                case 2:
                case 3:
                    if (!(this.zzrl == null || this.zzrf == null)) {
                        String zzcw = this.zzrf.zzcw();
                        String packageName = this.zzrf.getPackageName();
                        new StringBuilder(String.valueOf(zzcw).length() + 70 + String.valueOf(packageName).length()).append("Calling connect() while still connected, missing disconnect() for ").append(zzcw).append(" on ").append(packageName);
                        this.zzrg.unbindService(this.zzrf.zzcw(), this.zzrf.getPackageName(), this.zzrf.getBindFlags(), this.zzrl, getRealClientName());
                        this.mDisconnectCount.incrementAndGet();
                    }
                    this.zzrl = new GmsServiceConnection(this.mDisconnectCount.get());
                    this.zzrf = (this.zzrm != 3 || getLocalStartServiceAction() == null) ? new GmsServiceEndpoint(getStartServicePackage(), getStartServiceAction(), false, getServiceBindFlags()) : new GmsServiceEndpoint(getContext().getPackageName(), getLocalStartServiceAction(), true, getServiceBindFlags());
                    if (!this.zzrg.bindService(this.zzrf.zzcw(), this.zzrf.getPackageName(), this.zzrf.getBindFlags(), this.zzrl, getRealClientName())) {
                        String zzcw2 = this.zzrf.zzcw();
                        String packageName2 = this.zzrf.getPackageName();
                        new StringBuilder(String.valueOf(zzcw2).length() + 34 + String.valueOf(packageName2).length()).append("unable to connect to service: ").append(zzcw2).append(" on ").append(packageName2);
                        onPostServiceBindingHandler(16, null, this.mDisconnectCount.get());
                        break;
                    }
                    break;
                case 4:
                    onConnectedLocked(t);
                    break;
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(ConnectionInfo connectionInfo) {
        this.zzrt = connectionInfo;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean zza(int i2, int i3, T t) {
        boolean z;
        synchronized (this.mLock) {
            if (this.zzrm != i2) {
                z = false;
            } else {
                zza(i3, t);
                z = true;
            }
        }
        return z;
    }

    private final boolean zzcq() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzrm == 3;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean zzcr() {
        if (this.zzrs || TextUtils.isEmpty(getServiceDescriptor()) || TextUtils.isEmpty(getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException e2) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zzj(int i2) {
        int i3;
        if (zzcq()) {
            i3 = 5;
            this.zzrs = true;
        } else {
            i3 = 4;
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(i3, this.mDisconnectCount.get(), 16));
    }

    public void checkAvailabilityAndConnect() {
        int isGooglePlayServicesAvailable = this.zzgk.isGooglePlayServicesAvailable(this.mContext, getMinApkVersion());
        if (isGooglePlayServicesAvailable != 0) {
            zza(1, (IInterface) null);
            triggerNotAvailable(new LegacyClientCallbackAdapter(), isGooglePlayServicesAvailable, null);
            return;
        }
        connect(new LegacyClientCallbackAdapter());
    }

    /* access modifiers changed from: protected */
    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.mConnectionProgressReportCallbacks = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        zza(2, (IInterface) null);
    }

    /* access modifiers changed from: protected */
    public abstract T createServiceInterface(IBinder iBinder);

    public void disconnect() {
        this.mDisconnectCount.incrementAndGet();
        synchronized (this.zzrk) {
            int size = this.zzrk.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.zzrk.get(i2).removeListener();
            }
            this.zzrk.clear();
        }
        synchronized (this.zzrh) {
            this.zzri = null;
        }
        zza(1, (IInterface) null);
    }

    @Deprecated
    public final void doCallbackDEPRECATED(BaseGmsClient<T>.CallbackProxy callbackProxy) {
        synchronized (this.zzrk) {
            this.zzrk.add(callbackProxy);
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(2, this.mDisconnectCount.get(), -1, callbackProxy));
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i2;
        T t;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.mLock) {
            i2 = this.zzrm;
            t = this.zzrj;
        }
        synchronized (this.zzrh) {
            iGmsServiceBroker = this.zzri;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        switch (i2) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("REMOTE_CONNECTING");
                break;
            case 3:
                printWriter.print("LOCAL_CONNECTING");
                break;
            case 4:
                printWriter.print("CONNECTED");
                break;
            case 5:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append(BuildConfig.COMMAND);
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println(BuildConfig.COMMAND);
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzrc > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j2 = this.zzrc;
            String format = simpleDateFormat.format(new Date(this.zzrc));
            append.println(new StringBuilder(String.valueOf(format).length() + 21).append(j2).append(" ").append(format).toString());
        }
        if (this.zzrb > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            switch (this.zzra) {
                case 1:
                    printWriter.append("CAUSE_SERVICE_DISCONNECTED");
                    break;
                case 2:
                    printWriter.append("CAUSE_NETWORK_LOST");
                    break;
                default:
                    printWriter.append((CharSequence) String.valueOf(this.zzra));
                    break;
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j3 = this.zzrb;
            String format2 = simpleDateFormat.format(new Date(this.zzrb));
            append2.println(new StringBuilder(String.valueOf(format2).length() + 21).append(j3).append(" ").append(format2).toString());
        }
        if (this.zzre > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.zzrd));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j4 = this.zzre;
            String format3 = simpleDateFormat.format(new Date(this.zzre));
            append3.println(new StringBuilder(String.valueOf(format3).length() + 21).append(j4).append(" ").append(format3).toString());
        }
    }

    public Account getAccount() {
        return null;
    }

    public final Account getAccountOrDefault() {
        return getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
    }

    public Feature[] getApiFeatures() {
        return zzqz;
    }

    public final Feature[] getAvailableFeatures() {
        ConnectionInfo connectionInfo = this.zzrt;
        if (connectionInfo == null) {
            return null;
        }
        return connectionInfo.getAvailableFeatures();
    }

    public Bundle getConnectionHint() {
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public String getEndpointPackageName() {
        if (isConnected() && this.zzrf != null) {
            return this.zzrf.getPackageName();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    /* access modifiers changed from: protected */
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @VisibleForTesting
    public final Handler getHandlerForTesting() {
        return this.mHandler;
    }

    /* access modifiers changed from: protected */
    public String getLocalStartServiceAction() {
        return null;
    }

    public final Looper getLooper() {
        return this.zzcn;
    }

    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getRealClientName() {
        return this.zzrq == null ? this.mContext.getClass().getName() : this.zzrq;
    }

    public void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        GetServiceRequest extraArgs = new GetServiceRequest(this.zzrp).setCallingPackage(this.mContext.getPackageName()).setExtraArgs(getGetServiceRequestExtraArgs());
        if (set != null) {
            extraArgs.setScopes(set);
        }
        if (requiresSignIn()) {
            extraArgs.setClientRequestedAccount(getAccountOrDefault()).setAuthenticatedAccount(iAccountAccessor);
        } else if (requiresAccount()) {
            extraArgs.setClientRequestedAccount(getAccount());
        }
        extraArgs.setClientRequiredFeatures(getRequiredFeatures());
        extraArgs.setClientApiFeatures(getApiFeatures());
        try {
            synchronized (this.zzrh) {
                if (this.zzri != null) {
                    this.zzri.getService(new GmsCallbacks(this, this.mDisconnectCount.get()), extraArgs);
                }
            }
        } catch (DeadObjectException e2) {
            triggerConnectionSuspended(1);
        } catch (SecurityException e3) {
            throw e3;
        } catch (RemoteException | RuntimeException e4) {
            onPostInitHandler(8, null, null, this.mDisconnectCount.get());
        }
    }

    public Feature[] getRequiredFeatures() {
        return zzqz;
    }

    /* access modifiers changed from: protected */
    public Set<Scope> getScopes() {
        return Collections.EMPTY_SET;
    }

    public final T getService() {
        T t;
        synchronized (this.mLock) {
            if (this.zzrm == 5) {
                throw new DeadObjectException();
            }
            checkConnected();
            Preconditions.checkState(this.zzrj != null, "Client is connected but service is null");
            t = this.zzrj;
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public int getServiceBindFlags() {
        return 129;
    }

    public IBinder getServiceBrokerBinder() {
        IBinder asBinder;
        synchronized (this.zzrh) {
            asBinder = this.zzri == null ? null : this.zzri.asBinder();
        }
        return asBinder;
    }

    @VisibleForTesting
    public final IGmsServiceBroker getServiceBrokerForTesting() {
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.zzrh) {
            iGmsServiceBroker = this.zzri;
        }
        return iGmsServiceBroker;
    }

    /* access modifiers changed from: protected */
    public abstract String getServiceDescriptor();

    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    /* access modifiers changed from: protected */
    public abstract String getStartServiceAction();

    /* access modifiers changed from: protected */
    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzrm == 4;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzrm == 2 || this.zzrm == 3;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void onConnectedLocked(T t) {
        this.zzrc = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzrd = connectionResult.getErrorCode();
        this.zzre = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onConnectionSuspended(int i2) {
        this.zzra = i2;
        this.zzrb = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public void onPostInitHandler(int i2, IBinder iBinder, Bundle bundle, int i3) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i3, -1, new PostInitCallback(i2, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    public void onPostServiceBindingHandler(int i2, Bundle bundle, int i3) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(7, i3, -1, new PostServiceBindingCallback(i2, bundle)));
    }

    /* access modifiers changed from: package-private */
    public void onSetConnectState(int i2, T t) {
    }

    public void onUserSignOut(SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    public boolean providesSignIn() {
        return false;
    }

    public boolean requiresAccount() {
        return false;
    }

    public boolean requiresGooglePlayServices() {
        return true;
    }

    public boolean requiresSignIn() {
        return false;
    }

    @VisibleForTesting
    public void setConnectionInfoForTesting(ConnectionInfo connectionInfo) {
        this.zzrt = connectionInfo;
    }

    @VisibleForTesting
    public final void setServiceBrokerForTesting(IGmsServiceBroker iGmsServiceBroker) {
        synchronized (this.zzrh) {
            this.zzri = iGmsServiceBroker;
        }
    }

    @VisibleForTesting
    public final void setServiceForTesting(T t) {
        zza(t != null ? 4 : 1, t);
    }

    public void triggerConnectionSuspended(int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, this.mDisconnectCount.get(), i2));
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public void triggerNotAvailable(ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i2, PendingIntent pendingIntent) {
        this.mConnectionProgressReportCallbacks = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.mDisconnectCount.get(), i2, pendingIntent));
    }
}
