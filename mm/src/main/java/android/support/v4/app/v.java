package android.support.v4.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.o;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class v {
    private static final Object It = new Object();
    private static String Iu;
    private static Set<String> Iv = new HashSet();
    private static d Ix;
    private static final Object sLock = new Object();
    public final NotificationManager Iw = ((NotificationManager) this.mContext.getSystemService("notification"));
    public final Context mContext;

    /* access modifiers changed from: package-private */
    public interface e {
        void a(o oVar);
    }

    public static v P(Context context) {
        return new v(context);
    }

    private v(Context context) {
        this.mContext = context;
    }

    public final boolean areNotificationsEnabled() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.Iw.areNotificationsEnabled();
        }
        if (Build.VERSION.SDK_INT < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.mContext.getSystemService("appops");
        ApplicationInfo applicationInfo = this.mContext.getApplicationInfo();
        String packageName = this.mContext.getApplicationContext().getPackageName();
        int i2 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            return ((Integer) cls.getMethod("checkOpNoThrow", new Class[]{Integer.TYPE, Integer.TYPE, String.class}).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName})).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException e2) {
            return true;
        }
    }

    public final int getImportance() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.Iw.getImportance();
        }
        return -1000;
    }

    public static Set<String> Q(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (It) {
            if (string != null) {
                if (!string.equals(Iu)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String str : split) {
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                    }
                    Iv = hashSet;
                    Iu = string;
                }
            }
            set = Iv;
        }
        return set;
    }

    public final void a(e eVar) {
        synchronized (sLock) {
            if (Ix == null) {
                Ix = new d(this.mContext.getApplicationContext());
            }
            Ix.b(eVar);
        }
    }

    /* access modifiers changed from: package-private */
    public static class d implements ServiceConnection, Handler.Callback {
        private final Map<ComponentName, a> IB = new HashMap();
        private Set<String> IC = new HashSet();
        private final Context mContext;
        private final Handler mHandler;
        private final HandlerThread mHandlerThread;

        d(Context context) {
            this.mContext = context;
            this.mHandlerThread = new HandlerThread("NotificationManagerCompat");
            this.mHandlerThread.start();
            this.mHandler = new Handler(this.mHandlerThread.getLooper(), this);
        }

        public final void b(e eVar) {
            this.mHandler.obtainMessage(0, eVar).sendToTarget();
        }

        public final boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    e eVar = (e) message.obj;
                    Set<String> Q = v.Q(this.mContext);
                    if (!Q.equals(this.IC)) {
                        this.IC = Q;
                        List<ResolveInfo> queryIntentServices = this.mContext.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                        HashSet<ComponentName> hashSet = new HashSet();
                        for (ResolveInfo resolveInfo : queryIntentServices) {
                            if (Q.contains(resolveInfo.serviceInfo.packageName)) {
                                ComponentName componentName = new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
                                if (resolveInfo.serviceInfo.permission != null) {
                                    new StringBuilder("Permission present on component ").append(componentName).append(", not adding listener record.");
                                } else {
                                    hashSet.add(componentName);
                                }
                            }
                        }
                        for (ComponentName componentName2 : hashSet) {
                            if (!this.IB.containsKey(componentName2)) {
                                if (Log.isLoggable("NotifManCompat", 3)) {
                                    new StringBuilder("Adding listener record for ").append(componentName2);
                                }
                                this.IB.put(componentName2, new a(componentName2));
                            }
                        }
                        Iterator<Map.Entry<ComponentName, a>> it = this.IB.entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry<ComponentName, a> next = it.next();
                            if (!hashSet.contains(next.getKey())) {
                                if (Log.isLoggable("NotifManCompat", 3)) {
                                    new StringBuilder("Removing listener record for ").append(next.getKey());
                                }
                                a(next.getValue());
                                it.remove();
                            }
                        }
                    }
                    for (a aVar : this.IB.values()) {
                        aVar.IG.add(eVar);
                        c(aVar);
                    }
                    return true;
                case 1:
                    c cVar = (c) message.obj;
                    ComponentName componentName3 = cVar.componentName;
                    IBinder iBinder = cVar.IA;
                    a aVar2 = this.IB.get(componentName3);
                    if (aVar2 != null) {
                        aVar2.IF = o.a.b(iBinder);
                        aVar2.retryCount = 0;
                        c(aVar2);
                    }
                    return true;
                case 2:
                    a aVar3 = this.IB.get((ComponentName) message.obj);
                    if (aVar3 != null) {
                        a(aVar3);
                    }
                    return true;
                case 3:
                    a aVar4 = this.IB.get((ComponentName) message.obj);
                    if (aVar4 != null) {
                        c(aVar4);
                    }
                    return true;
                default:
                    return false;
            }
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Connected to service ").append(componentName);
            }
            this.mHandler.obtainMessage(1, new c(componentName, iBinder)).sendToTarget();
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Disconnected from service ").append(componentName);
            }
            this.mHandler.obtainMessage(2, componentName).sendToTarget();
        }

        private void a(a aVar) {
            if (aVar.IE) {
                this.mContext.unbindService(this);
                aVar.IE = false;
            }
            aVar.IF = null;
        }

        private void b(a aVar) {
            if (!this.mHandler.hasMessages(3, aVar.componentName)) {
                aVar.retryCount++;
                if (aVar.retryCount > 6) {
                    new StringBuilder("Giving up on delivering ").append(aVar.IG.size()).append(" tasks to ").append(aVar.componentName).append(" after ").append(aVar.retryCount).append(" retries");
                    aVar.IG.clear();
                    return;
                }
                int i2 = (1 << (aVar.retryCount - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    new StringBuilder("Scheduling retry for ").append(i2).append(" ms");
                }
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(3, aVar.componentName), (long) i2);
            }
        }

        private void c(a aVar) {
            boolean z;
            if (Log.isLoggable("NotifManCompat", 3)) {
                new StringBuilder("Processing component ").append(aVar.componentName).append(", ").append(aVar.IG.size()).append(" queued tasks");
            }
            if (!aVar.IG.isEmpty()) {
                if (aVar.IE) {
                    z = true;
                } else {
                    aVar.IE = this.mContext.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.componentName), this, 33);
                    if (aVar.IE) {
                        aVar.retryCount = 0;
                    } else {
                        new StringBuilder("Unable to bind to listener ").append(aVar.componentName);
                        this.mContext.unbindService(this);
                    }
                    z = aVar.IE;
                }
                if (!z || aVar.IF == null) {
                    b(aVar);
                    return;
                }
                while (true) {
                    e peek = aVar.IG.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            new StringBuilder("Sending task ").append(peek);
                        }
                        peek.a(aVar.IF);
                        aVar.IG.remove();
                    } catch (DeadObjectException e2) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            new StringBuilder("Remote service has died: ").append(aVar.componentName);
                        }
                    } catch (RemoteException e3) {
                        new StringBuilder("RemoteException communicating with ").append(aVar.componentName);
                    }
                }
                if (!aVar.IG.isEmpty()) {
                    b(aVar);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public static class a {
            boolean IE = false;
            o IF;
            ArrayDeque<e> IG = new ArrayDeque<>();
            final ComponentName componentName;
            int retryCount = 0;

            a(ComponentName componentName2) {
                this.componentName = componentName2;
            }
        }
    }

    static class c {
        final IBinder IA;
        final ComponentName componentName;

        c(ComponentName componentName2, IBinder iBinder) {
            this.componentName = componentName2;
            this.IA = iBinder;
        }
    }

    public static class b implements e {
        final Notification Iz;
        final int id;
        final String packageName;
        final String tag = null;

        public b(String str, int i2, Notification notification) {
            this.packageName = str;
            this.id = i2;
            this.Iz = notification;
        }

        @Override // android.support.v4.app.v.e
        public final void a(o oVar) {
            oVar.a(this.packageName, this.id, this.tag, this.Iz);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("NotifyTask[");
            sb.append("packageName:").append(this.packageName);
            sb.append(", id:").append(this.id);
            sb.append(", tag:").append(this.tag);
            sb.append("]");
            return sb.toString();
        }
    }

    static class a implements e {
        final boolean Iy = false;
        final int id;
        final String packageName;
        final String tag = null;

        a(String str, int i2) {
            this.packageName = str;
            this.id = i2;
        }

        @Override // android.support.v4.app.v.e
        public final void a(o oVar) {
            if (this.Iy) {
                oVar.t(this.packageName);
            } else {
                oVar.c(this.packageName, this.id, this.tag);
            }
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("CancelTask[");
            sb.append("packageName:").append(this.packageName);
            sb.append(", id:").append(this.id);
            sb.append(", tag:").append(this.tag);
            sb.append(", all:").append(this.Iy);
            sb.append("]");
            return sb.toString();
        }
    }

    public final void cancel(int i2) {
        this.Iw.cancel(null, i2);
        if (Build.VERSION.SDK_INT <= 19) {
            a(new a(this.mContext.getPackageName(), i2));
        }
    }
}
