package com.tencent.mm.plugin.appbrand.ipc;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.lang.reflect.Constructor;

public abstract class AppBrandProxyUIProcessTask implements MMActivity.a {
    public c lwz;

    public interface b<R extends ProcessResult> {
        void a(R r);
    }

    /* access modifiers changed from: protected */
    public abstract void a(ProcessRequest processRequest);

    public final MMActivity bDF() {
        return this.lwz.bDF();
    }

    public final void b(final ProcessResult processResult) {
        AnonymousClass1 r0 = new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(45412);
                if (AppBrandProxyUIProcessTask.this.lwz == null) {
                    AppMethodBeat.o(45412);
                    return;
                }
                AppBrandProxyUIProcessTask.this.lwz.b(processResult);
                AppMethodBeat.o(45412);
            }
        };
        if (this.lwz != null) {
            this.lwz.runOnUiThread(r0);
        }
    }

    public final boolean bDG() {
        if (this.lwz == null) {
            return true;
        }
        return this.lwz.bDG();
    }

    public final AppBrandTaskProxyUI bDL() {
        if (this.lwz instanceof AppBrandTaskProxyUI) {
            return (AppBrandTaskProxyUI) this.lwz;
        }
        return null;
    }

    protected static String getString(int i2) {
        return MMApplicationContext.getResources().getString(i2);
    }

    @Override // com.tencent.mm.ui.MMActivity.a
    public void d(int i2, int i3, Intent intent) {
    }

    /* access modifiers changed from: protected */
    public void bDM() {
    }

    /* access modifiers changed from: protected */
    public void u(int[] iArr) {
    }

    public static abstract class ProcessRequest implements Parcelable {
        /* access modifiers changed from: protected */
        public abstract Class<? extends AppBrandProxyUIProcessTask> bCJ();

        public ProcessRequest() {
        }

        public ProcessRequest(Parcel parcel) {
            k(parcel);
        }

        /* access modifiers changed from: protected */
        public boolean bDN() {
            return false;
        }

        /* access modifiers changed from: protected */
        public String bDO() {
            return null;
        }

        /* access modifiers changed from: protected */
        public int bDP() {
            return -1;
        }

        /* access modifiers changed from: protected */
        public boolean bDQ() {
            return false;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
        }

        /* access modifiers changed from: protected */
        public void k(Parcel parcel) {
        }
    }

    public static abstract class ProcessResult implements Parcelable {
        /* access modifiers changed from: protected */
        public abstract void k(Parcel parcel);

        public ProcessResult() {
        }

        public ProcessResult(Parcel parcel) {
            k(parcel);
        }
    }

    public static class DefaultProcessResult extends ProcessResult {
        public static final Parcelable.Creator<DefaultProcessResult> CREATOR = new Parcelable.Creator<DefaultProcessResult>() {
            /* class com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.DefaultProcessResult.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ DefaultProcessResult[] newArray(int i2) {
                return new DefaultProcessResult[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DefaultProcessResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(226644);
                DefaultProcessResult defaultProcessResult = new DefaultProcessResult();
                AppMethodBeat.o(226644);
                return defaultProcessResult;
            }
        };

        /* access modifiers changed from: protected */
        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult
        public final void k(Parcel parcel) {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
        }

        static {
            AppMethodBeat.i(226645);
            AppMethodBeat.o(226645);
        }
    }

    static final class a {
        static <_Model extends AppBrandProxyUIProcessTask> _Model YX(String str) {
            AppMethodBeat.i(45413);
            try {
                Constructor<?> declaredConstructor = Class.forName(str).getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                _Model _model = (_Model) ((AppBrandProxyUIProcessTask) declaredConstructor.newInstance(new Object[0]));
                AppMethodBeat.o(45413);
                return _model;
            } catch (Exception e2) {
                Log.e("MicroMsg.AppBrand.IpcProxyUIModelFactory", "create mode object using className(%s), exp = %s", str, Util.stackTraceToString(e2));
                AppMethodBeat.o(45413);
                return null;
            }
        }
    }
}
