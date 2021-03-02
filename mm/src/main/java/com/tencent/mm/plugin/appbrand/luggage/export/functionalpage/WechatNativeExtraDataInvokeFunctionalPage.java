package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b,\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 C2\u00020\u00012\u00020\u0002:\u0001CB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B§\u0001\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0017J\t\u00109\u001a\u00020\u000eHÖ\u0001J\u000e\u0010:\u001a\u00020;2\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010<\u001a\u00020;2\b\u0010=\u001a\u0004\u0018\u00010\u0007J\b\u0010>\u001a\u00020\u0007H\u0016J\u0019\u0010?\u001a\u00020;2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u000eHÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001a\u0010\u0014\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0019\"\u0004\b)\u0010\u001bR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010*\"\u0004\b+\u0010,R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0019\"\u0004\b.\u0010\u001bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010\u001bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0019\"\u0004\b4\u0010\u001bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0019\"\u0004\b6\u0010\u001bR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010#\"\u0004\b8\u0010%¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage;", "Landroid/os/Parcelable;", "Lcom/tencent/mm/plugin/appbrand/api/IWeAppOpenNativeExtraData;", "obj", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;)V", "invokeTicket", "", "apiName", "args", "jsapiType", "isGame", "", "wxa_scene", "", AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, "callbackActivity", "transitiveData", "sessionId", "instanceId", "debugMode", "pageTitle", "currentH5Url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getApiName", "()Ljava/lang/String;", "setApiName", "(Ljava/lang/String;)V", "getArgs", "setArgs", "getCallbackActivity", "setCallbackActivity", "getCurrentH5Url", "setCurrentH5Url", "getDebugMode", "()I", "setDebugMode", "(I)V", "getInstanceId", "setInstanceId", "getInvokeTicket", "setInvokeTicket", "()Z", "setGame", "(Z)V", "getJsapiType", "setJsapiType", "getPackageName", "setPackageName", "getPageTitle", "setPageTitle", "getSessionId", "setSessionId", "getTransitiveData", "setTransitiveData", "getWxa_scene", "setWxa_scene", "describeContents", "fromJson", "", "fromJsonString", "jsonString", "toJsonString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "plugin-appbrand-integration_release"})
public final class WechatNativeExtraDataInvokeFunctionalPage implements Parcelable, d {
    public static final Parcelable.Creator CREATOR = new b();
    @Deprecated
    public static final a nbi = new a((byte) 0);
    public String callbackActivity;
    boolean cuy;
    public String invokeTicket;
    private String kEY;
    String les;
    public String nbb;
    public String nbc;
    String nbd;
    int nbe;
    public int nbf;
    String nbg;
    String nbh;
    public String packageName;
    private String sessionId;

    @l(hxD = {1, 1, 16})
    public static class b implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        public final Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(228883);
            p.h(parcel, LocaleUtil.INDONESIAN_NEWNAME);
            WechatNativeExtraDataInvokeFunctionalPage wechatNativeExtraDataInvokeFunctionalPage = new WechatNativeExtraDataInvokeFunctionalPage(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
            AppMethodBeat.o(228883);
            return wechatNativeExtraDataInvokeFunctionalPage;
        }

        @Override // android.os.Parcelable.Creator
        public final Object[] newArray(int i2) {
            return new WechatNativeExtraDataInvokeFunctionalPage[i2];
        }
    }

    static {
        AppMethodBeat.i(228887);
        AppMethodBeat.o(228887);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(228888);
        p.h(parcel, "parcel");
        parcel.writeString(this.invokeTicket);
        parcel.writeString(this.nbb);
        parcel.writeString(this.nbc);
        parcel.writeString(this.nbd);
        parcel.writeInt(this.cuy ? 1 : 0);
        parcel.writeInt(this.nbe);
        parcel.writeString(this.packageName);
        parcel.writeString(this.callbackActivity);
        parcel.writeString(this.les);
        parcel.writeString(this.sessionId);
        parcel.writeString(this.kEY);
        parcel.writeInt(this.nbf);
        parcel.writeString(this.nbg);
        parcel.writeString(this.nbh);
        AppMethodBeat.o(228888);
    }

    public WechatNativeExtraDataInvokeFunctionalPage(String str, String str2, String str3, String str4, boolean z, int i2, String str5, String str6, String str7, String str8, String str9, int i3, String str10, String str11) {
        this.invokeTicket = str;
        this.nbb = str2;
        this.nbc = str3;
        this.nbd = str4;
        this.cuy = z;
        this.nbe = i2;
        this.packageName = str5;
        this.callbackActivity = str6;
        this.les = str7;
        this.sessionId = str8;
        this.kEY = str9;
        this.nbf = i3;
        this.nbg = str10;
        this.nbh = str11;
    }

    public /* synthetic */ WechatNativeExtraDataInvokeFunctionalPage() {
        this(null, null, null, null, false, 0, null, null, null, null, null, 0, null, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WechatNativeExtraDataInvokeFunctionalPage(JSONObject jSONObject) {
        this();
        p.h(jSONObject, "obj");
        AppMethodBeat.i(228886);
        am(jSONObject);
        AppMethodBeat.o(228886);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/WechatNativeExtraDataInvokeFunctionalPage$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final void am(JSONObject jSONObject) {
        AppMethodBeat.i(228884);
        p.h(jSONObject, "obj");
        this.invokeTicket = jSONObject.getString("invokeTicket");
        this.nbb = jSONObject.getString("name");
        this.packageName = jSONObject.getString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        this.nbc = jSONObject.getString("args");
        this.nbd = jSONObject.getString("jsapiType");
        this.cuy = jSONObject.optBoolean("isGame");
        this.nbe = jSONObject.getInt("wxa_scene");
        this.callbackActivity = jSONObject.getString("callbackActivity");
        this.les = jSONObject.optString("transitiveData");
        this.sessionId = jSONObject.optString("sessionId");
        this.kEY = jSONObject.optString("instanceId");
        this.nbf = jSONObject.optInt("debugMode");
        this.nbg = jSONObject.optString("title");
        this.nbh = jSONObject.optString("currentH5Url");
        AppMethodBeat.o(228884);
    }

    @Override // com.tencent.mm.plugin.appbrand.api.d
    public final String bua() {
        String str;
        AppMethodBeat.i(228885);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("invokeTicket", this.invokeTicket);
            jSONObject.put("name", this.nbb);
            jSONObject.put("args", this.nbc);
            jSONObject.put("jsapiType", this.nbd);
            jSONObject.put("isGame", this.cuy);
            jSONObject.put("wxa_scene", this.nbe);
            jSONObject.put(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, this.packageName);
            jSONObject.put("callbackActivity", this.callbackActivity);
            jSONObject.put("transitiveData", this.les);
            jSONObject.put("sessionId", this.sessionId);
            jSONObject.put("instanceId", this.kEY);
            jSONObject.put("debugMode", this.nbf);
            jSONObject.put("title", this.nbg);
            jSONObject.put("currentH5Url", this.nbh);
            str = jSONObject.toString();
            p.g(str, "obj.toString()");
        } catch (JSONException e2) {
            Log.printErrStackTrace("MicroMsg.AppBrand.WechatNativeExtraDataInvokeFunctionalPage", e2, "", new Object[0]);
            str = "{}";
        }
        AppMethodBeat.o(228885);
        return str;
    }
}
