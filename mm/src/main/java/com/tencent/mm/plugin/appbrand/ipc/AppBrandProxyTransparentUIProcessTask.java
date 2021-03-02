package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AppBrandProxyTransparentUIProcessTask implements Parcelable {
    private static Map<String, WeakReference<AppBrandProxyTransparentUIProcessTask>> lvL = new ConcurrentHashMap();
    private static final Set<Object> lwv = new HashSet();
    private String jEY = new StringBuilder().append(Process.myPid()).append(hashCode()).toString();
    private int lww = -1;
    private MMActivity.a lwx = new MMActivity.a() {
        /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.AnonymousClass1 */

        @Override // com.tencent.mm.ui.MMActivity.a
        public final void d(int i2, int i3, Intent intent) {
            AppMethodBeat.i(45411);
            if (i2 == (AppBrandProxyTransparentUIProcessTask.this.hashCode() & 65535)) {
                if (intent == null) {
                    AppMethodBeat.o(45411);
                    return;
                }
                AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask = (AppBrandProxyTransparentUIProcessTask) intent.getParcelableExtra("task_object");
                AppBrandProxyTransparentUIProcessTask YW = AppBrandProxyTransparentUIProcessTask.YW(intent.getStringExtra("task_id"));
                if (YW == null) {
                    Log.e("MicroMsg.AppBrandProxyTransparentUIProcessTask", "task is null");
                    AppMethodBeat.o(45411);
                    return;
                }
                AppBrandProxyTransparentUIProcessTask.a(appBrandProxyTransparentUIProcessTask, YW);
                YW.bDK();
                YW.bjk();
                AppBrandProxyTransparentUIProcessTask.this.mContext = null;
            }
            AppMethodBeat.o(45411);
        }
    };
    Context mContext;

    public interface a {
        void bDH();
    }

    public abstract void a(Context context, a aVar);

    protected AppBrandProxyTransparentUIProcessTask() {
    }

    public AppBrandProxyTransparentUIProcessTask(Context context) {
        this.mContext = context;
    }

    public void bjk() {
    }

    public void f(Parcel parcel) {
    }

    public void writeToParcel(Parcel parcel, int i2) {
    }

    public int describeContents() {
        return 0;
    }

    public final void bDI() {
        if (this.mContext != null) {
            lvL.put(this.jEY, new WeakReference<>(this));
            Intent intent = new Intent();
            intent.setClass(this.mContext, AppBrandProxyTransparentUI.class);
            intent.putExtra("task_object", this);
            intent.putExtra("task_class_name", getClass().getName());
            intent.putExtra("task_id", this.jEY);
            intent.putExtra("orientation", this.lww);
            f.aK(this.mContext).a(intent, new f.b() {
                /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask.AnonymousClass2 */

                @Override // com.tencent.luggage.h.f.b
                public final void a(int i2, Intent intent) {
                    AppMethodBeat.i(174743);
                    AppBrandProxyTransparentUIProcessTask.this.lwx.d(AppBrandProxyTransparentUIProcessTask.this.hashCode() & 65535, i2, intent);
                    AppMethodBeat.o(174743);
                }
            });
        }
    }

    public final void bDJ() {
        lwv.add(this);
    }

    public final void bDK() {
        lwv.remove(this);
    }

    static /* synthetic */ AppBrandProxyTransparentUIProcessTask YW(String str) {
        if (!lvL.containsKey(str)) {
            return null;
        }
        if (lvL.get(str).get() == null) {
            return null;
        }
        return lvL.get(str).get();
    }

    static /* synthetic */ void a(AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask, AppBrandProxyTransparentUIProcessTask appBrandProxyTransparentUIProcessTask2) {
        Parcel obtain = Parcel.obtain();
        appBrandProxyTransparentUIProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        appBrandProxyTransparentUIProcessTask2.f(obtain);
        obtain.recycle();
    }
}
