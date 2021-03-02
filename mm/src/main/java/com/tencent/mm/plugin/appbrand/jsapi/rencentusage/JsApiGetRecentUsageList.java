package com.tencent.mm.plugin.appbrand.jsapi.rencentusage;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.appusage.j;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.rencentusage.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.util.ArrayList;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J%\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Companion", "plugin-appbrand-integration_release"})
public final class JsApiGetRecentUsageList extends d<f> {
    public static final int CTRL_INDEX = 853;
    public static final String NAME = "getRecentUsageList";
    public static final Companion mow = new Companion((byte) 0);

    static {
        AppMethodBeat.i(228470);
        AppMethodBeat.o(228470);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "ret", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "kotlin.jvm.PlatformType", "onCallback"})
    static final class a<T> implements com.tencent.mm.ipcinvoker.d<ResultType> {
        final /* synthetic */ int kAd;
        final /* synthetic */ f lyn;

        a(f fVar, int i2) {
            this.lyn = fVar;
            this.kAd = i2;
        }

        @Override // com.tencent.mm.ipcinvoker.d
        public final /* synthetic */ void bn(Object obj) {
            String str;
            AppMethodBeat.i(228468);
            Companion.Result result = (Companion.Result) obj;
            a.C0702a aVar = a.moD;
            f fVar = this.lyn;
            int i2 = this.kAd;
            p.g(result, "ret");
            p.h(fVar, "component");
            p.h(result, "recentUsageInfo");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestId", i2);
            jSONObject.put("recentUsageInfo", new JSONArray(result.data));
            jSONObject.put(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, result.errorCode);
            String jSONObject2 = jSONObject.put(OpenSDKTool4Assistant.EXTRA_ERROR_MSG, result.errorMsg).toString();
            p.g(jSONObject2, "with(JSONObject()) {\n   …\n            }.toString()");
            StringBuilder sb = new StringBuilder();
            if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                str = "data=" + jSONObject2 + '\n';
            } else {
                str = "******";
            }
            Log.i("MicroMsg.JsApiOnGetRecentUsageListResultEvent", sb.append(str).append("errorCode=").append(result.errorCode).append('\n').append("errorMsg=").append(result.errorMsg).toString());
            new a((byte) 0).g(fVar).Zg(jSONObject2).bEo();
            AppMethodBeat.o(228468);
        }
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final void a(f fVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(228469);
        if (fVar == null) {
            AppMethodBeat.o(228469);
        } else if (jSONObject == null) {
            AppMethodBeat.o(228469);
        } else {
            Log.i("MicroMsg.JsApiGetRecentUsageList", "data=".concat(String.valueOf(jSONObject)));
            int optInt = jSONObject.optInt("count", Integer.MAX_VALUE);
            if (optInt < 0) {
                fVar.i(i2, Zf("fail:illegal count"));
                AppMethodBeat.o(228469);
                return;
            }
            int optInt2 = jSONObject.optInt("requestId", Integer.MAX_VALUE);
            if (optInt2 == Integer.MAX_VALUE) {
                fVar.i(i2, Zf("fail:illegal requestId"));
                AppMethodBeat.o(228469);
                return;
            }
            long optLong = jSONObject.optLong("lastUpdateTime", MAlarmHandler.NEXT_FIRE_INTERVAL);
            if (optLong < 0) {
                fVar.i(i2, Zf("fail:illegal lastUpdateTime"));
                AppMethodBeat.o(228469);
                return;
            }
            fVar.i(i2, Zf("ok"));
            h.a(MainProcessIPCService.dkO, new Companion.Parameter(optInt, optLong, optInt2), Companion.a.class, new a(fVar, optInt2));
            AppMethodBeat.o(228469);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001:\u0003\n\u000b\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "UPDATE_TIME_FOR_FIRST_PAGE", "", "Parameter", "Result", "Task", "plugin-appbrand-integration_release"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(byte b2) {
            this();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\bH\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "data", "", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "", OpenSDKTool4Assistant.EXTRA_ERROR_MSG, "(Ljava/lang/String;ILjava/lang/String;)V", "getData", "()Ljava/lang/String;", "getErrorCode", "()I", "getErrorMsg", "component1", "component2", "component3", "copy", "describeContents", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "writeToParcel", "", "flags", "Companion", "plugin-appbrand-integration_release"})
        public static final class Result implements Parcelable {
            public static final Parcelable.Creator<Result> CREATOR = new b();
            public static final a mox = new a((byte) 0);
            final String data;
            final int errorCode;
            final String errorMsg;

            /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
                if (kotlin.g.b.p.j(r3.errorMsg, r4.errorMsg) != false) goto L_0x0028;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final boolean equals(java.lang.Object r4) {
                /*
                    r3 = this;
                    r2 = 228462(0x37c6e, float:3.20143E-40)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                    if (r3 == r4) goto L_0x0028
                    boolean r0 = r4 instanceof com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList.Companion.Result
                    if (r0 == 0) goto L_0x002d
                    com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList$Companion$Result r4 = (com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList.Companion.Result) r4
                    java.lang.String r0 = r3.data
                    java.lang.String r1 = r4.data
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x002d
                    int r0 = r3.errorCode
                    int r1 = r4.errorCode
                    if (r0 != r1) goto L_0x002d
                    java.lang.String r0 = r3.errorMsg
                    java.lang.String r1 = r4.errorMsg
                    boolean r0 = kotlin.g.b.p.j(r0, r1)
                    if (r0 == 0) goto L_0x002d
                L_0x0028:
                    r0 = 1
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                L_0x002c:
                    return r0
                L_0x002d:
                    r0 = 0
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                    goto L_0x002c
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList.Companion.Result.equals(java.lang.Object):boolean");
            }

            public final int hashCode() {
                int i2 = 0;
                AppMethodBeat.i(228461);
                String str = this.data;
                int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.errorCode) * 31;
                String str2 = this.errorMsg;
                if (str2 != null) {
                    i2 = str2.hashCode();
                }
                int i3 = hashCode + i2;
                AppMethodBeat.o(228461);
                return i3;
            }

            public final String toString() {
                AppMethodBeat.i(228460);
                String str = "Result(data=" + this.data + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ")";
                AppMethodBeat.o(228460);
                return str;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "ERR_CODE_CGI_FAILED", "", "ERR_CODE_SUCCESS", "plugin-appbrand-integration_release"})
            public static final class a {
                private a() {
                }

                public /* synthetic */ a(byte b2) {
                    this();
                }
            }

            public /* synthetic */ Result(String str) {
                this(str, 0, "");
                AppMethodBeat.i(228457);
                AppMethodBeat.o(228457);
            }

            public Result(String str, int i2, String str2) {
                p.h(str, "data");
                p.h(str2, OpenSDKTool4Assistant.EXTRA_ERROR_MSG);
                AppMethodBeat.i(228456);
                this.data = str;
                this.errorCode = i2;
                this.errorMsg = str2;
                AppMethodBeat.o(228456);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "plugin-appbrand-integration_release"})
            public static final class b implements Parcelable.Creator<Result> {
                b() {
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ Result createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(228454);
                    p.h(parcel, "parcel");
                    Result result = new Result(parcel);
                    AppMethodBeat.o(228454);
                    return result;
                }

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ Result[] newArray(int i2) {
                    return new Result[i2];
                }
            }

            static {
                AppMethodBeat.i(228459);
                AppMethodBeat.o(228459);
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public Result(android.os.Parcel r6) {
                /*
                    r5 = this;
                    r4 = 228458(0x37c6a, float:3.20138E-40)
                    java.lang.String r0 = "parcel"
                    kotlin.g.b.p.h(r6, r0)
                    java.lang.String r0 = r6.readString()
                    if (r0 != 0) goto L_0x0012
                    kotlin.g.b.p.hyc()
                L_0x0012:
                    java.lang.String r1 = "parcel.readString()!!"
                    kotlin.g.b.p.g(r0, r1)
                    int r1 = r6.readInt()
                    java.lang.String r2 = r6.readString()
                    if (r2 != 0) goto L_0x0025
                    kotlin.g.b.p.hyc()
                L_0x0025:
                    java.lang.String r3 = "parcel.readString()!!"
                    kotlin.g.b.p.g(r2, r3)
                    r5.<init>(r0, r1, r2)
                    com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                    com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList.Companion.Result.<init>(android.os.Parcel):void");
            }

            public final void writeToParcel(Parcel parcel, int i2) {
                AppMethodBeat.i(228455);
                p.h(parcel, "parcel");
                parcel.writeString(this.data);
                parcel.writeInt(this.errorCode);
                parcel.writeString(this.errorMsg);
                AppMethodBeat.o(228455);
            }

            public final int describeContents() {
                return 0;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0011\u001a\u00020\bHÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0006H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "count", "", "lastUpdateTime", "", "requestId", "(IJI)V", "getCount", "()I", "getLastUpdateTime", "()J", "getRequestId", "component1", "component2", "component3", "copy", "describeContents", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "", "hashCode", "toString", "", "writeToParcel", "", "flags", "CREATOR", "plugin-appbrand-integration_release"})
        public static final class Parameter implements Parcelable {
            public static final a CREATOR = new a((byte) 0);
            final int count;
            final long lastUpdateTime;
            final int requestId;

            static {
                AppMethodBeat.i(228452);
                AppMethodBeat.o(228452);
            }

            public final boolean equals(Object obj) {
                if (this != obj) {
                    if (obj instanceof Parameter) {
                        Parameter parameter = (Parameter) obj;
                        if (!(this.count == parameter.count && this.lastUpdateTime == parameter.lastUpdateTime && this.requestId == parameter.requestId)) {
                            return false;
                        }
                    }
                    return false;
                }
                return true;
            }

            public final int hashCode() {
                long j2 = this.lastUpdateTime;
                return (((this.count * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.requestId;
            }

            public final String toString() {
                AppMethodBeat.i(228453);
                String str = "Parameter(count=" + this.count + ", lastUpdateTime=" + this.lastUpdateTime + ", requestId=" + this.requestId + ")";
                AppMethodBeat.o(228453);
                return str;
            }

            public Parameter(int i2, long j2, int i3) {
                this.count = i2;
                this.lastUpdateTime = j2;
                this.requestId = i3;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public Parameter(Parcel parcel) {
                this(parcel.readInt(), parcel.readLong(), parcel.readInt());
                p.h(parcel, "parcel");
                AppMethodBeat.i(228451);
                AppMethodBeat.o(228451);
            }

            public final void writeToParcel(Parcel parcel, int i2) {
                AppMethodBeat.i(228450);
                p.h(parcel, "parcel");
                parcel.writeInt(this.count);
                parcel.writeLong(this.lastUpdateTime);
                parcel.writeInt(this.requestId);
                AppMethodBeat.o(228450);
            }

            public final int describeContents() {
                return 0;
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "plugin-appbrand-integration_release"})
            public static final class a implements Parcelable.Creator<Parameter> {
                private a() {
                }

                public /* synthetic */ a(byte b2) {
                    this();
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ Parameter createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(228449);
                    p.h(parcel, "parcel");
                    Parameter parameter = new Parameter(parcel);
                    AppMethodBeat.o(228449);
                    return parameter;
                }

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ Parameter[] newArray(int i2) {
                    return new Parameter[i2];
                }
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tH\u0002J\f\u0010\n\u001a\u00020\u000b*\u00020\fH\u0002¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Task;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Parameter;", "Lcom/tencent/mm/plugin/appbrand/jsapi/rencentusage/JsApiGetRecentUsageList$Companion$Result;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "toJsonObject", "Lorg/json/JSONObject;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppBrandRecentTaskInfo;", "plugin-appbrand-integration_release"})
        public static final class a implements com.tencent.mm.ipcinvoker.b<Parameter, Result> {

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<no name provided>", "", "lastUpdateTime", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList$Companion$a$a  reason: collision with other inner class name */
            static final class C0700a extends q implements kotlin.g.a.b<Long, x> {
                final /* synthetic */ com.tencent.mm.ipcinvoker.d kFf;
                final /* synthetic */ a moy;
                final /* synthetic */ Parameter moz;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0700a(a aVar, Parameter parameter, com.tencent.mm.ipcinvoker.d dVar) {
                    super(1);
                    this.moy = aVar;
                    this.moz = parameter;
                    this.kFf = dVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.g.a.b
                public final /* synthetic */ x invoke(Long l) {
                    AppMethodBeat.i(228463);
                    long longValue = l.longValue();
                    ArrayList<AppBrandRecentTaskInfo> g2 = n.buJ().byp().g(longValue, this.moz.count);
                    JSONArray jSONArray = new JSONArray();
                    Log.i("MicroMsg.JsApiGetRecentUsageList", "lastUpdateTime=" + longValue + "  requestId=" + this.moz.requestId + " count=" + this.moz.count);
                    p.g(g2, "infoList");
                    for (T t : g2) {
                        if (BuildInfo.IS_FLAVOR_RED || BuildInfo.DEBUG) {
                            Log.i("MicroMsg.JsApiGetRecentUsageList", "appName=" + t.appName + "  userName=" + ((AppBrandRecentTaskInfo) t).username + " lastUpdateTime=" + t.crj);
                        }
                        p.g(t, "each");
                        jSONArray.put(a.a(t));
                    }
                    com.tencent.mm.ipcinvoker.d dVar = this.kFf;
                    String jSONArray2 = jSONArray.toString();
                    p.g(jSONArray2, "it.toString()");
                    dVar.bn(new Result(jSONArray2));
                    x xVar = x.SXb;
                    AppMethodBeat.o(228463);
                    return xVar;
                }
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<no name provided>", "", "firstPage", "", "lastUpdateTime", "", "invoke"})
            static final class b extends q implements m<Boolean, Long, x> {
                final /* synthetic */ com.tencent.mm.ipcinvoker.d kFf;
                final /* synthetic */ kotlin.g.a.b moA;
                final /* synthetic */ Parameter moz;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                b(Parameter parameter, kotlin.g.a.b bVar, com.tencent.mm.ipcinvoker.d dVar) {
                    super(2);
                    this.moz = parameter;
                    this.moA = bVar;
                    this.kFf = dVar;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                @Override // kotlin.g.a.m
                public final /* synthetic */ x invoke(Boolean bool, Long l) {
                    AppMethodBeat.i(228465);
                    boolean booleanValue = bool.booleanValue();
                    final long longValue = l.longValue();
                    if (j.bxS() || booleanValue) {
                        j.bxQ().a(Util.nowMilliSecond(), false, null, 3, 0, this.moz.count, longValue, new j.a(this) {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.rencentusage.JsApiGetRecentUsageList.Companion.a.b.AnonymousClass1 */
                            final /* synthetic */ b moB;

                            {
                                this.moB = r1;
                            }

                            @Override // com.tencent.mm.plugin.appbrand.appusage.j.a
                            public final void n(boolean z, String str) {
                                AppMethodBeat.i(228464);
                                Log.i("MicroMsg.JsApiGetRecentUsageList", "fetchNextPageFromServer  success=" + z + " errorMsg=" + str);
                                if (z) {
                                    this.moB.moA.invoke(Long.valueOf(longValue));
                                    AppMethodBeat.o(228464);
                                    return;
                                }
                                com.tencent.mm.ipcinvoker.d dVar = this.moB.kFf;
                                p.g(str, OpenSDKTool4Assistant.EXTRA_ERROR_MSG);
                                dVar.bn(new Result("", -1000, str));
                                AppMethodBeat.o(228464);
                            }
                        });
                    } else {
                        this.moA.invoke(Long.valueOf(longValue));
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(228465);
                    return xVar;
                }
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
            @Override // com.tencent.mm.ipcinvoker.b
            public final /* synthetic */ void invoke(Parameter parameter, com.tencent.mm.ipcinvoker.d<Result> dVar) {
                AppMethodBeat.i(228466);
                Parameter parameter2 = parameter;
                if (parameter2 == null) {
                    AppMethodBeat.o(228466);
                } else if (dVar == null) {
                    AppMethodBeat.o(228466);
                } else {
                    C0700a aVar = new C0700a(this, parameter2, dVar);
                    b bVar = new b(parameter2, aVar, dVar);
                    if (0 == parameter2.lastUpdateTime) {
                        aVar.invoke(Long.valueOf((long) MAlarmHandler.NEXT_FIRE_INTERVAL));
                        bVar.invoke(Boolean.TRUE, Long.valueOf((long) MAlarmHandler.NEXT_FIRE_INTERVAL));
                        AppMethodBeat.o(228466);
                        return;
                    }
                    bVar.invoke(Boolean.FALSE, Long.valueOf(parameter2.lastUpdateTime));
                    AppMethodBeat.o(228466);
                }
            }

            public static final /* synthetic */ JSONObject a(AppBrandRecentTaskInfo appBrandRecentTaskInfo) {
                AppMethodBeat.i(228467);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("userName", appBrandRecentTaskInfo.username);
                jSONObject.put("appName", appBrandRecentTaskInfo.appName);
                jSONObject.put("appId", appBrandRecentTaskInfo.appId);
                jSONObject.put("shortNickname", appBrandRecentTaskInfo.cyB);
                jSONObject.put("appIcon", appBrandRecentTaskInfo.kVo);
                jSONObject.put("appServiceType", appBrandRecentTaskInfo.cyo);
                jSONObject.put("appVersion", appBrandRecentTaskInfo.appVersion);
                jSONObject.put("runningFlag", appBrandRecentTaskInfo.czf);
                jSONObject.put("cannotAddStarWxaUtil", appBrandRecentTaskInfo.kWb);
                jSONObject.put("starApp", appBrandRecentTaskInfo.kVp);
                jSONObject.put("debugType", appBrandRecentTaskInfo.eix);
                jSONObject.put(ch.COL_UPDATETIME, appBrandRecentTaskInfo.crj);
                jSONObject.put("runInThirdPartyAppRecently", appBrandRecentTaskInfo.kWc);
                jSONObject.put("thirdPartyAppUsingDesc", appBrandRecentTaskInfo.kWd);
                if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scene_appbrand_rencent_use_list, 0) == 1) {
                    jSONObject.put("showTradingGuaranteeFlag", appBrandRecentTaskInfo.kVq);
                }
                if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_appbrand_show_official_flag, 0) == 1) {
                    jSONObject.put("showOfficialFlag", appBrandRecentTaskInfo.kVr);
                }
                AppMethodBeat.o(228467);
                return jSONObject;
            }
        }
    }
}
