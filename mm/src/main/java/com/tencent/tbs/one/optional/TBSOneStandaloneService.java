package com.tencent.tbs.one.optional;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TBSOneStandaloneService extends Service {
    public static final String IMPL_CLASS_NAME_KEY = "implClassName";

    /* renamed from: a  reason: collision with root package name */
    private ServiceImpl f2790a;

    public static abstract class ServiceImpl {

        /* renamed from: a  reason: collision with root package name */
        protected Service f2791a;

        public IBinder onBind(Intent intent) {
            return null;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onCreate() {
        }

        public void onDestroy() {
        }

        public void onLowMemory() {
        }

        public void onRebind(Intent intent) {
        }

        public abstract int onStartCommand(Intent intent, int i2, int i3);

        public void onTaskRemoved(Intent intent) {
        }

        public void onTrimMemory(int i2) {
        }

        public boolean onUnbind(Intent intent) {
            return false;
        }

        public void setBaseService(Service service) {
            this.f2791a = service;
        }
    }

    public IBinder onBind(Intent intent) {
        AppMethodBeat.i(53722);
        if (this.f2790a == null) {
            AppMethodBeat.o(53722);
            return null;
        }
        IBinder onBind = this.f2790a.onBind(intent);
        AppMethodBeat.o(53722);
        return onBind;
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(53725);
        super.onConfigurationChanged(configuration);
        if (this.f2790a != null) {
            this.f2790a.onConfigurationChanged(configuration);
        }
        AppMethodBeat.o(53725);
    }

    public void onDestroy() {
        AppMethodBeat.i(53726);
        if (this.f2790a != null) {
            this.f2790a.onDestroy();
        }
        super.onDestroy();
        AppMethodBeat.o(53726);
    }

    public void onLowMemory() {
        AppMethodBeat.i(53727);
        super.onLowMemory();
        if (this.f2790a != null) {
            this.f2790a.onLowMemory();
        }
        AppMethodBeat.o(53727);
    }

    public void onRebind(Intent intent) {
        AppMethodBeat.i(53724);
        super.onRebind(intent);
        if (this.f2790a != null) {
            this.f2790a.onRebind(intent);
        }
        AppMethodBeat.o(53724);
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        AppMethodBeat.i(53721);
        String stringExtra = intent.getStringExtra(IMPL_CLASS_NAME_KEY);
        if (!TextUtils.isEmpty(stringExtra) && (this.f2790a == null || !this.f2790a.getClass().getName().equals(stringExtra))) {
            if (this.f2790a != null) {
                this.f2790a.onDestroy();
                this.f2790a = null;
            }
            try {
                this.f2790a = (ServiceImpl) Class.forName(stringExtra).newInstance();
                this.f2790a.setBaseService(this);
            } catch (Throwable th) {
            }
            if (this.f2790a != null) {
                this.f2790a.onCreate();
            }
        }
        if (this.f2790a != null) {
            int onStartCommand = this.f2790a.onStartCommand(intent, i2, i3);
            AppMethodBeat.o(53721);
            return onStartCommand;
        }
        int onStartCommand2 = super.onStartCommand(intent, i2, i3);
        AppMethodBeat.o(53721);
        return onStartCommand2;
    }

    public void onTaskRemoved(Intent intent) {
        AppMethodBeat.i(53729);
        super.onTaskRemoved(intent);
        if (this.f2790a != null) {
            this.f2790a.onTaskRemoved(intent);
        }
        AppMethodBeat.o(53729);
    }

    public void onTrimMemory(int i2) {
        AppMethodBeat.i(53728);
        super.onTrimMemory(i2);
        if (this.f2790a != null) {
            this.f2790a.onTrimMemory(i2);
        }
        AppMethodBeat.o(53728);
    }

    public boolean onUnbind(Intent intent) {
        AppMethodBeat.i(53723);
        if (this.f2790a == null) {
            boolean onUnbind = super.onUnbind(intent);
            AppMethodBeat.o(53723);
            return onUnbind;
        }
        boolean onUnbind2 = this.f2790a.onUnbind(intent);
        AppMethodBeat.o(53723);
        return onUnbind2;
    }
}
