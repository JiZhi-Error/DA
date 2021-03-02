package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.share.internal.ShareConstants;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0003\u001c\u001d\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ4\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007J'\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\u0004\b\u0000\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00180\u00062\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0002\u0010\u001bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u0002`\n0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils;", "", "()V", "TAG", "", "gProxyFunctionsMap", "Landroid/util/SparseArray;", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/MMActivity;", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/pay/ProxyForMMActivityResultCallback;", "customAppIdInWhitleList", "", "service", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "customAppId", "libSupportUseCustomAppId", "waitForMMActivityResult", "context", "Landroid/app/Activity;", "function", "activityResultCallback", "Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultCallback;", "removeReturns", "T", "key", "", "(Landroid/util/SparseArray;I)Ljava/lang/Object;", "ProxyMMActivityResultRequest", "ProxyMMActivityResultResult", "ProxyMMActivityResultTask", "plugin-appbrand-integration_release"})
public final class AppBrandJsApiPayUtils {
    private static final SparseArray<b<MMActivity, x>> mlY = new SparseArray<>();
    public static final AppBrandJsApiPayUtils mlZ = new AppBrandJsApiPayUtils();

    static {
        AppMethodBeat.i(175184);
        AppMethodBeat.o(175184);
    }

    private AppBrandJsApiPayUtils() {
    }

    public static final boolean a(Activity activity, b<? super MMActivity, x> bVar, f.b bVar2) {
        boolean z;
        AppMethodBeat.i(228437);
        p.h(activity, "context");
        p.h(bVar, "function");
        if (activity instanceof MMActivity) {
            bVar.invoke(activity);
            AppMethodBeat.o(228437);
            return true;
        }
        try {
            int hashCode = bVar.hashCode();
            ProxyMMActivityResultRequest proxyMMActivityResultRequest = new ProxyMMActivityResultRequest(hashCode);
            int aK = com.tencent.luggage.sdk.g.a.aK(proxyMMActivityResultRequest);
            if (bVar2 != null) {
                f.aK(activity).b(new a(aK, bVar2));
            }
            mlY.put(hashCode, bVar);
            com.tencent.mm.plugin.appbrand.ipc.a.b(activity, proxyMMActivityResultRequest, null);
            z = true;
        } catch (Throwable th) {
            Log.printErrStackTrace("MicroMsg.AppBrandJsApiPayUtils", th, "waitForMMActivityResult startLogicProxy", new Object[0]);
            z = false;
        }
        AppMethodBeat.o(228437);
        return z;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
    public static final class a implements f.c {
        final /* synthetic */ int mmc;
        final /* synthetic */ f.b mmd;

        a(int i2, f.b bVar) {
            this.mmc = i2;
            this.mmd = bVar;
        }

        @Override // com.tencent.luggage.h.f.c
        public final boolean c(int i2, int i3, Intent intent) {
            AppMethodBeat.i(228436);
            if (this.mmc == i2) {
                this.mmd.a(i3, intent);
                AppMethodBeat.o(228436);
                return true;
            }
            AppMethodBeat.o(228436);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\u0014J\b\u0010\u0015\u001a\u00020\u0016H\u0014J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0016HÖ\u0001J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0006H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "requestId", "", "(I)V", "getRequestId", "()I", "component1", "copy", "describeContents", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "getStartActivityRequestCode", "getTaskClass", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "getUIAlias", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
    public static final class ProxyMMActivityResultRequest extends AppBrandProxyUIProcessTask.ProcessRequest {
        public static final a CREATOR = new a((byte) 0);
        final int requestId;

        static {
            AppMethodBeat.i(175173);
            AppMethodBeat.o(175173);
        }

        public final boolean equals(Object obj) {
            return this == obj || ((obj instanceof ProxyMMActivityResultRequest) && this.requestId == ((ProxyMMActivityResultRequest) obj).requestId);
        }

        public final int hashCode() {
            return this.requestId;
        }

        public final String toString() {
            AppMethodBeat.i(175174);
            String str = "ProxyMMActivityResultRequest(requestId=" + this.requestId + ")";
            AppMethodBeat.o(175174);
            return str;
        }

        public ProxyMMActivityResultRequest(int i2) {
            this.requestId = i2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public ProxyMMActivityResultRequest(Parcel parcel) {
            this(parcel.readInt());
            p.h(parcel, "parcel");
            AppMethodBeat.i(175172);
            AppMethodBeat.o(175172);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final Class<? extends AppBrandProxyUIProcessTask> bCJ() {
            return ProxyMMActivityResultTask.class;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final String bDO() {
            return "AppBrandJsApiPayUtils.waitForMMActivityResult";
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final int bDP() {
            AppMethodBeat.i(261667);
            int aK = com.tencent.luggage.sdk.g.a.aK(this);
            AppMethodBeat.o(261667);
            return aK;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(175171);
            p.h(parcel, "parcel");
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.requestId);
            AppMethodBeat.o(175171);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
        public final int describeContents() {
            return 0;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultRequest;", "plugin-appbrand-integration_release"})
        public static final class a implements Parcelable.Creator<ProxyMMActivityResultRequest> {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ProxyMMActivityResultRequest createFromParcel(Parcel parcel) {
                AppMethodBeat.i(175170);
                p.h(parcel, "parcel");
                ProxyMMActivityResultRequest proxyMMActivityResultRequest = new ProxyMMActivityResultRequest(parcel);
                AppMethodBeat.o(175170);
                return proxyMMActivityResultRequest;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ProxyMMActivityResultRequest[] newArray(int i2) {
                return new ProxyMMActivityResultRequest[i2];
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0014J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessResult;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "describeContents", "", "readParcel", "", LocaleUtil.INDONESIAN_NEWNAME, "writeToParcel", "flags", "CREATOR", "plugin-appbrand-integration_release"})
    public static final class ProxyMMActivityResultResult extends AppBrandProxyUIProcessTask.ProcessResult {
        public static final a CREATOR = new a((byte) 0);

        static {
            AppMethodBeat.i(175178);
            AppMethodBeat.o(175178);
        }

        public ProxyMMActivityResultResult() {
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public ProxyMMActivityResultResult(Parcel parcel) {
            this();
            p.h(parcel, "parcel");
            AppMethodBeat.i(175177);
            AppMethodBeat.o(175177);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult
        public final void k(Parcel parcel) {
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(175176);
            p.h(parcel, "parcel");
            AppMethodBeat.o(175176);
        }

        public final int describeContents() {
            return 0;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultResult;", "plugin-appbrand-integration_release"})
        public static final class a implements Parcelable.Creator<ProxyMMActivityResultResult> {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ProxyMMActivityResultResult createFromParcel(Parcel parcel) {
                AppMethodBeat.i(175175);
                p.h(parcel, "parcel");
                ProxyMMActivityResultResult proxyMMActivityResultResult = new ProxyMMActivityResultResult(parcel);
                AppMethodBeat.o(175175);
                return proxyMMActivityResultResult;
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ProxyMMActivityResultResult[] newArray(int i2) {
                return new ProxyMMActivityResultResult[i2];
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\tH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/AppBrandJsApiPayUtils$ProxyMMActivityResultTask;", "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask;", "Landroid/arch/lifecycle/LifecycleObserver;", "()V", "mHasActivityResult", "", "requestId", "", "handleRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandProxyUIProcessTask$ProcessRequest;", "onHostActivityDestroyed", "plugin-appbrand-integration_release"})
    public static final class ProxyMMActivityResultTask extends AppBrandProxyUIProcessTask implements LifecycleObserver {
        private boolean mma;
        private int requestId;

        public static final /* synthetic */ void a(ProxyMMActivityResultTask proxyMMActivityResultTask) {
            AppMethodBeat.i(175182);
            proxyMMActivityResultTask.b((AppBrandProxyUIProcessTask.ProcessResult) null);
            AppMethodBeat.o(175182);
        }

        public static final /* synthetic */ MMActivity b(ProxyMMActivityResultTask proxyMMActivityResultTask) {
            AppMethodBeat.i(228435);
            MMActivity bDF = proxyMMActivityResultTask.bDF();
            AppMethodBeat.o(228435);
            return bDF;
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
        public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
            AppMethodBeat.i(175181);
            if (processRequest == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.pay.AppBrandJsApiPayUtils.ProxyMMActivityResultRequest");
                AppMethodBeat.o(175181);
                throw tVar;
            }
            this.requestId = ((ProxyMMActivityResultRequest) processRequest).requestId;
            AppBrandJsApiPayUtils appBrandJsApiPayUtils = AppBrandJsApiPayUtils.mlZ;
            kotlin.g.a.b bVar = (kotlin.g.a.b) AppBrandJsApiPayUtils.a(AppBrandJsApiPayUtils.mlY, this.requestId);
            if (bVar == null) {
                new a(this).invoke();
                AppMethodBeat.o(175181);
                return;
            }
            f.aK(bDF()).a(new b(this));
            MMActivity bDF = bDF();
            p.g(bDF, "activityContext");
            bVar.invoke(bDF);
            AppMethodBeat.o(175181);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
        static final class b implements f.c {
            final /* synthetic */ ProxyMMActivityResultTask mmb;

            b(ProxyMMActivityResultTask proxyMMActivityResultTask) {
                this.mmb = proxyMMActivityResultTask;
            }

            @Override // com.tencent.luggage.h.f.c
            public final boolean c(int i2, int i3, Intent intent) {
                AppMethodBeat.i(175180);
                ProxyMMActivityResultTask.b(this.mmb).setResult(i3, intent);
                ProxyMMActivityResultTask.a(this.mmb);
                this.mmb.mma = true;
                AppMethodBeat.o(175180);
                return true;
            }
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onHostActivityDestroyed() {
            AppMethodBeat.i(228434);
            if (!this.mma) {
                bDF().setResult(0);
                bDF().finish();
            }
            AppMethodBeat.o(228434);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ ProxyMMActivityResultTask mmb;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(ProxyMMActivityResultTask proxyMMActivityResultTask) {
                super(0);
                this.mmb = proxyMMActivityResultTask;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(175179);
                ProxyMMActivityResultTask.a(this.mmb);
                x xVar = x.SXb;
                AppMethodBeat.o(175179);
                return xVar;
            }
        }
    }

    public static boolean c(c cVar, String str) {
        boolean z = true;
        AppMethodBeat.i(228438);
        p.h(cVar, "service");
        p.h(str, "customAppId");
        com.tencent.mm.plugin.appbrand.q runtime = cVar.getRuntime();
        p.g(runtime, "service.runtime");
        com.tencent.mm.ab.f FI = new i(runtime.bsC().cyv.lgZ).FI("call_plugin_info");
        if (FI == null) {
            AppMethodBeat.o(228438);
            return false;
        }
        int length = FI.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                z = false;
                break;
            }
            String optString = FI.pY(i2).optString("plugin_id");
            Log.i("MicroMsg.AppBrandJsApiPayUtils", "canRequestPaymentUseCustomAppId pluginId:%s customAppId:%s", optString, str);
            if (p.j(optString, str)) {
                break;
            }
            i2++;
        }
        AppMethodBeat.o(228438);
        return z;
    }

    public static boolean c(c cVar) {
        AppMethodBeat.i(228439);
        p.h(cVar, "service");
        ICommLibReader bqZ = cVar.bqZ();
        boolean z = Util.getBoolean(bqZ != null ? bqZ.UN("paymentCustomAppid") : null, false);
        Log.i("MicroMsg.AppBrandJsApiPayUtils", "libSupportUseCustomAppId %b", Boolean.valueOf(z));
        AppMethodBeat.o(228439);
        return z;
    }

    public static final boolean a(Activity activity, b<? super MMActivity, x> bVar) {
        AppMethodBeat.i(175183);
        boolean a2 = a(activity, bVar, null);
        AppMethodBeat.o(175183);
        return a2;
    }

    public static final /* synthetic */ Object a(SparseArray sparseArray, int i2) {
        AppMethodBeat.i(228440);
        Object obj = sparseArray.get(i2);
        if (obj != null) {
            sparseArray.remove(i2);
            AppMethodBeat.o(228440);
            return obj;
        }
        AppMethodBeat.o(228440);
        return null;
    }
}
