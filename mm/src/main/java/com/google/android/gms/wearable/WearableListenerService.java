package com.google.android.gms.wearable;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelClient;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.internal.zzah;
import com.google.android.gms.wearable.internal.zzas;
import com.google.android.gms.wearable.internal.zzaw;
import com.google.android.gms.wearable.internal.zzen;
import com.google.android.gms.wearable.internal.zzfe;
import com.google.android.gms.wearable.internal.zzfo;
import com.google.android.gms.wearable.internal.zzhp;
import com.google.android.gms.wearable.internal.zzi;
import com.google.android.gms.wearable.internal.zzl;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class WearableListenerService extends Service implements CapabilityApi.CapabilityListener, ChannelApi.ChannelListener, DataApi.DataListener, MessageApi.MessageListener {
    public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
    private ComponentName service;
    private zzc zzad;
    private IBinder zzae;
    private Intent zzaf;
    private Looper zzag;
    private final Object zzah = new Object();
    private boolean zzai;
    private zzas zzaj = new zzas(new zza());

    class zza extends ChannelClient.ChannelCallback {
        private zza() {
        }

        @Override // com.google.android.gms.wearable.ChannelClient.ChannelCallback
        public final void onChannelClosed(ChannelClient.Channel channel, int i2, int i3) {
            AppMethodBeat.i(100898);
            WearableListenerService.this.onChannelClosed(channel, i2, i3);
            AppMethodBeat.o(100898);
        }

        @Override // com.google.android.gms.wearable.ChannelClient.ChannelCallback
        public final void onChannelOpened(ChannelClient.Channel channel) {
            AppMethodBeat.i(100897);
            WearableListenerService.this.onChannelOpened(channel);
            AppMethodBeat.o(100897);
        }

        @Override // com.google.android.gms.wearable.ChannelClient.ChannelCallback
        public final void onInputClosed(ChannelClient.Channel channel, int i2, int i3) {
            AppMethodBeat.i(100899);
            WearableListenerService.this.onInputClosed(channel, i2, i3);
            AppMethodBeat.o(100899);
        }

        @Override // com.google.android.gms.wearable.ChannelClient.ChannelCallback
        public final void onOutputClosed(ChannelClient.Channel channel, int i2, int i3) {
            AppMethodBeat.i(100900);
            WearableListenerService.this.onOutputClosed(channel, i2, i3);
            AppMethodBeat.o(100900);
        }
    }

    /* access modifiers changed from: package-private */
    public class zzb implements ServiceConnection {
        private zzb(WearableListenerService wearableListenerService) {
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        }

        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* access modifiers changed from: package-private */
    public final class zzc extends Handler {
        private boolean started;
        private final zzb zzal = new zzb();

        zzc(Looper looper) {
            super(looper);
            AppMethodBeat.i(100901);
            AppMethodBeat.o(100901);
        }

        @SuppressLint({"UntrackedBindService"})
        private final synchronized void zzb() {
            AppMethodBeat.i(100904);
            if (this.started) {
                AppMethodBeat.o(100904);
            } else {
                if (Log.isLoggable("WearableLS", 2)) {
                    String valueOf = String.valueOf(WearableListenerService.this.service);
                    new StringBuilder(String.valueOf(valueOf).length() + 13).append("bindService: ").append(valueOf);
                }
                WearableListenerService.this.bindService(WearableListenerService.this.zzaf, this.zzal, 1);
                this.started = true;
                AppMethodBeat.o(100904);
            }
        }

        @SuppressLint({"UntrackedBindService"})
        private final synchronized void zzb(String str) {
            AppMethodBeat.i(100905);
            if (!this.started) {
                AppMethodBeat.o(100905);
            } else {
                if (Log.isLoggable("WearableLS", 2)) {
                    String valueOf = String.valueOf(WearableListenerService.this.service);
                    new StringBuilder(String.valueOf(str).length() + 17 + String.valueOf(valueOf).length()).append("unbindService: ").append(str).append(", ").append(valueOf);
                }
                try {
                    WearableListenerService.this.unbindService(this.zzal);
                } catch (RuntimeException e2) {
                }
                this.started = false;
                AppMethodBeat.o(100905);
            }
        }

        public final void dispatchMessage(Message message) {
            AppMethodBeat.i(100902);
            zzb();
            try {
                super.dispatchMessage(message);
                if (!hasMessages(0)) {
                    zzb("dispatch");
                    AppMethodBeat.o(100902);
                    return;
                }
                AppMethodBeat.o(100902);
            } catch (Throwable th) {
                if (!hasMessages(0)) {
                    zzb("dispatch");
                }
                AppMethodBeat.o(100902);
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public final void quit() {
            AppMethodBeat.i(100903);
            getLooper().quit();
            zzb("quit");
            AppMethodBeat.o(100903);
        }
    }

    /* access modifiers changed from: package-private */
    public final class zzd extends zzen {
        private volatile int zzam;

        private zzd() {
            this.zzam = -1;
        }

        private final boolean zza(Runnable runnable, String str, Object obj) {
            boolean z;
            AppMethodBeat.i(100915);
            if (Log.isLoggable("WearableLS", 3)) {
                String.format("%s: %s %s", str, WearableListenerService.this.service.toString(), obj);
            }
            int callingUid = Binder.getCallingUid();
            if (callingUid == this.zzam) {
                z = true;
            } else if (zzhp.zza(WearableListenerService.this).zze("com.google.android.wearable.app.cn") && UidVerifier.uidHasPackageName(WearableListenerService.this, callingUid, "com.google.android.wearable.app.cn")) {
                this.zzam = callingUid;
                z = true;
            } else if (UidVerifier.isGooglePlayServicesUid(WearableListenerService.this, callingUid)) {
                this.zzam = callingUid;
                z = true;
            } else {
                new StringBuilder(57).append("Caller is not GooglePlayServices; caller UID: ").append(callingUid);
                z = false;
            }
            if (!z) {
                AppMethodBeat.o(100915);
                return false;
            }
            synchronized (WearableListenerService.this.zzah) {
                try {
                    if (WearableListenerService.this.zzai) {
                        return false;
                    }
                    WearableListenerService.this.zzad.post(runnable);
                    AppMethodBeat.o(100915);
                    return true;
                } finally {
                    AppMethodBeat.o(100915);
                }
            }
        }

        @Override // com.google.android.gms.wearable.internal.zzem
        public final void onConnectedNodes(List<zzfo> list) {
            AppMethodBeat.i(100910);
            zza(new zzp(this, list), "onConnectedNodes", list);
            AppMethodBeat.o(100910);
        }

        @Override // com.google.android.gms.wearable.internal.zzem
        public final void zza(DataHolder dataHolder) {
            AppMethodBeat.i(100906);
            zzl zzl = new zzl(this, dataHolder);
            try {
                String valueOf = String.valueOf(dataHolder);
                if (zza(zzl, "onDataItemChanged", new StringBuilder(String.valueOf(valueOf).length() + 18).append(valueOf).append(", rows=").append(dataHolder.getCount()).toString())) {
                    AppMethodBeat.o(100906);
                }
            } finally {
                dataHolder.close();
                AppMethodBeat.o(100906);
            }
        }

        @Override // com.google.android.gms.wearable.internal.zzem
        public final void zza(zzah zzah) {
            AppMethodBeat.i(100911);
            zza(new zzq(this, zzah), "onConnectedCapabilityChanged", zzah);
            AppMethodBeat.o(100911);
        }

        @Override // com.google.android.gms.wearable.internal.zzem
        public final void zza(zzaw zzaw) {
            AppMethodBeat.i(100914);
            zza(new zzt(this, zzaw), "onChannelEvent", zzaw);
            AppMethodBeat.o(100914);
        }

        @Override // com.google.android.gms.wearable.internal.zzem
        public final void zza(zzfe zzfe) {
            AppMethodBeat.i(100907);
            zza(new zzm(this, zzfe), "onMessageReceived", zzfe);
            AppMethodBeat.o(100907);
        }

        @Override // com.google.android.gms.wearable.internal.zzem
        public final void zza(zzfo zzfo) {
            AppMethodBeat.i(100908);
            zza(new zzn(this, zzfo), "onPeerConnected", zzfo);
            AppMethodBeat.o(100908);
        }

        @Override // com.google.android.gms.wearable.internal.zzem
        public final void zza(zzi zzi) {
            AppMethodBeat.i(100913);
            zza(new zzs(this, zzi), "onEntityUpdate", zzi);
            AppMethodBeat.o(100913);
        }

        @Override // com.google.android.gms.wearable.internal.zzem
        public final void zza(zzl zzl) {
            AppMethodBeat.i(100912);
            zza(new zzr(this, zzl), "onNotificationReceived", zzl);
            AppMethodBeat.o(100912);
        }

        @Override // com.google.android.gms.wearable.internal.zzem
        public final void zzb(zzfo zzfo) {
            AppMethodBeat.i(100909);
            zza(new zzo(this, zzfo), "onPeerDisconnected", zzfo);
            AppMethodBeat.o(100909);
        }
    }

    public WearableListenerService() {
        AppMethodBeat.i(100916);
        AppMethodBeat.o(100916);
    }

    public Looper getLooper() {
        AppMethodBeat.i(100920);
        if (this.zzag == null) {
            HandlerThread handlerThread = new HandlerThread("WearableListenerService");
            handlerThread.start();
            this.zzag = handlerThread.getLooper();
        }
        Looper looper = this.zzag;
        AppMethodBeat.o(100920);
        return looper;
    }

    public final IBinder onBind(Intent intent) {
        AppMethodBeat.i(100919);
        if (BIND_LISTENER_INTENT_ACTION.equals(intent.getAction())) {
            IBinder iBinder = this.zzae;
            AppMethodBeat.o(100919);
            return iBinder;
        }
        AppMethodBeat.o(100919);
        return null;
    }

    @Override // com.google.android.gms.wearable.CapabilityApi.CapabilityListener
    public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelClosed(Channel channel, int i2, int i3) {
    }

    public void onChannelClosed(ChannelClient.Channel channel, int i2, int i3) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onChannelOpened(Channel channel) {
    }

    public void onChannelOpened(ChannelClient.Channel channel) {
    }

    public void onConnectedNodes(List<Node> list) {
    }

    public void onCreate() {
        AppMethodBeat.i(100917);
        super.onCreate();
        this.service = new ComponentName(this, getClass().getName());
        if (Log.isLoggable("WearableLS", 3)) {
            String valueOf = String.valueOf(this.service);
            new StringBuilder(String.valueOf(valueOf).length() + 10).append("onCreate: ").append(valueOf);
        }
        this.zzad = new zzc(getLooper());
        this.zzaf = new Intent(BIND_LISTENER_INTENT_ACTION);
        this.zzaf.setComponent(this.service);
        this.zzae = new zzd();
        AppMethodBeat.o(100917);
    }

    @Override // com.google.android.gms.wearable.DataApi.DataListener
    public void onDataChanged(DataEventBuffer dataEventBuffer) {
    }

    public void onDestroy() {
        AppMethodBeat.i(100918);
        if (Log.isLoggable("WearableLS", 3)) {
            String valueOf = String.valueOf(this.service);
            new StringBuilder(String.valueOf(valueOf).length() + 11).append("onDestroy: ").append(valueOf);
        }
        synchronized (this.zzah) {
            try {
                this.zzai = true;
                if (this.zzad == null) {
                    String valueOf2 = String.valueOf(this.service);
                    IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf2).length() + 111).append("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()? component=").append(valueOf2).toString());
                    AppMethodBeat.o(100918);
                    throw illegalStateException;
                }
                this.zzad.quit();
            } catch (Throwable th) {
                AppMethodBeat.o(100918);
                throw th;
            }
        }
        super.onDestroy();
        AppMethodBeat.o(100918);
    }

    public void onEntityUpdate(zzb zzb2) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onInputClosed(Channel channel, int i2, int i3) {
    }

    public void onInputClosed(ChannelClient.Channel channel, int i2, int i3) {
    }

    @Override // com.google.android.gms.wearable.MessageApi.MessageListener
    public void onMessageReceived(MessageEvent messageEvent) {
    }

    public void onNotificationReceived(zzd zzd2) {
    }

    @Override // com.google.android.gms.wearable.ChannelApi.ChannelListener
    public void onOutputClosed(Channel channel, int i2, int i3) {
    }

    public void onOutputClosed(ChannelClient.Channel channel, int i2, int i3) {
    }

    public void onPeerConnected(Node node) {
    }

    public void onPeerDisconnected(Node node) {
    }
}
