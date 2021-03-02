package com.tencent.mm.plugin.appbrand.jsapi.appdownload;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.b.g;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import org.json.JSONObject;

public final class JsApiLaunchApplicationForNative extends d<s> {
    private static final int CTRL_INDEX = 665;
    private static final String NAME = "launchApplicationForNative";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(s sVar, JSONObject jSONObject, final int i2) {
        String str;
        AppMethodBeat.i(45849);
        final s sVar2 = sVar;
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiLaunchApplicationForNative", "data is null");
            sVar2.i(i2, h("fail:data is null", null));
            AppMethodBeat.o(45849);
            return;
        }
        final String optString = jSONObject.optString("appId");
        final String optString2 = jSONObject.optString("schemeUrl");
        final String optString3 = jSONObject.optString("parameter");
        int i3 = Util.getInt(jSONObject.optString("alertType"), 0);
        int i4 = Util.getInt(jSONObject.optString("operateDirectly"), 0);
        final String optString4 = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
        final String optString5 = jSONObject.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        final String optString6 = jSONObject.optString("signature");
        Log.i("MicroMsg.JsApiLaunchApplicationForNative", "doLaunchApplication, appid : %s, scheme : %s, extinfo:[%s], parameter : %s, pkg:%s, signature:%s", optString, optString2, optString4, optString3, optString5, optString6);
        if (!Util.isNullOrNil(optString) || !Util.isNullOrNil(optString2) || !Util.isNullOrNil(optString5)) {
            String appId = sVar2.getAppId();
            ac currentPageView = sVar2.getCurrentPageView();
            if (currentPageView != null) {
                str = currentPageView.lBI;
            } else {
                Log.e("MicroMsg.JsApiLaunchApplicationForNative", "getCurrentPageView is null");
                str = null;
            }
            final Bundle bundle = new Bundle();
            if (!Util.isNullOrNil(str)) {
                try {
                    bundle.putString("current_page_url", URLEncoder.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET));
                } catch (UnsupportedEncodingException e2) {
                }
            }
            bundle.putString("current_page_appid", appId);
            d.a aVar = new d.a();
            aVar.iLN = new cea();
            aVar.iLO = new ceb();
            aVar.uri = "/cgi-bin/mmbiz-bin/checklaunchapp";
            aVar.funcId = 1125;
            cea cea = (cea) aVar.aXF().iLK.iLR;
            cea.dNI = appId;
            cea.MjD = optString;
            cea.scene = ((q) sVar2.getRuntime()).ON().cyA.scene;
            cea.url = str;
            cea.MjE = optString2;
            cea.qwp = i3;
            cea.LEg = 1;
            cea.MjF = i4;
            cea.packageName = optString5;
            Log.i("MicroMsg.JsApiLaunchApplicationForNative", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", appId, optString, Integer.valueOf(cea.scene), cea.url, cea.MjE, Integer.valueOf(cea.qwp), Integer.valueOf(cea.MjF));
            IPCRunCgi.a(aVar.aXF(), new IPCRunCgi.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.AnonymousClass1 */

                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                public final void a(final int i2, final int i3, String str, final com.tencent.mm.ak.d dVar) {
                    AppMethodBeat.i(45838);
                    Log.i("MicroMsg.JsApiLaunchApplicationForNative", "on RunCgi callback errType:%d errCode:%d msg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    com.tencent.mm.ch.a.post(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            Signature[] cj;
                            String str;
                            AppMethodBeat.i(45837);
                            if (i2 == 0 && i3 == 0) {
                                final ceb ceb = (ceb) dVar.iLL.iLR;
                                switch (ceb.dIZ) {
                                    case 0:
                                        final a aVar = new a(new a.AbstractC0625a() {
                                            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                            @Override // com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.a.AbstractC0625a
                                            public final void u(boolean z, boolean z2) {
                                                AppMethodBeat.i(45834);
                                                Log.i("MicroMsg.JsApiLaunchApplicationForNative", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                                                if (z) {
                                                    sVar2.i(i2, JsApiLaunchApplicationForNative.this.h("ok", null));
                                                    AppMethodBeat.o(45834);
                                                    return;
                                                }
                                                sVar2.i(i2, JsApiLaunchApplicationForNative.this.h("fail:scheme launch fail", null));
                                                AppMethodBeat.o(45834);
                                            }
                                        });
                                        Log.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication check result(showType : %d, errCode : %d)", Integer.valueOf(ceb.xGz), Integer.valueOf(ceb.dIZ));
                                        if (!Util.isNullOrNil(optString2)) {
                                            final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString2));
                                            intent.addFlags(268435456);
                                            List<ResolveInfo> queryIntentActivities = Util.queryIntentActivities(sVar2.getContext(), intent);
                                            if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                                                if (!TextUtils.isEmpty(intent.getPackage()) || queryIntentActivities.size() != 1) {
                                                    str = intent.getPackage();
                                                } else {
                                                    str = h.b(queryIntentActivities.get(0));
                                                }
                                                if (!Util.nullAsNil(MMApplicationContext.getPackageName()).equals(str)) {
                                                    MMHandlerThread.postToMainThread(new Runnable() {
                                                        /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                                        public final void run() {
                                                            AppMethodBeat.i(45835);
                                                            aVar.hj(h.a(sVar2.getContext(), intent, (String) null, ceb.xGz, aVar, bundle));
                                                            AppMethodBeat.o(45835);
                                                        }
                                                    });
                                                    AppMethodBeat.o(45837);
                                                    return;
                                                }
                                            }
                                        }
                                        if (!Util.isNullOrNil(optString5) && !Util.isNullOrNil(optString6) && (cj = com.tencent.mm.pluginsdk.model.app.q.cj(sVar2.ay(Activity.class), optString5)) != null && cj[0] != null) {
                                            String messageDigest = g.getMessageDigest(cj[0].toByteArray());
                                            if (messageDigest == null || !messageDigest.equalsIgnoreCase(optString6)) {
                                                Log.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication signature not match");
                                            } else {
                                                try {
                                                    Intent launchIntentForPackage = MMApplicationContext.getContext().getPackageManager().getLaunchIntentForPackage(optString5);
                                                    if (launchIntentForPackage != null) {
                                                        Bundle bundle = new Bundle();
                                                        com.tencent.mm.pluginsdk.model.app.q.k(bundle, optString3);
                                                        launchIntentForPackage.putExtras(bundle);
                                                        launchIntentForPackage.addFlags(268435456);
                                                        aVar.hj(h.a(sVar2.ay(Activity.class), launchIntentForPackage, null, aVar, bundle));
                                                        AppMethodBeat.o(45837);
                                                        return;
                                                    }
                                                } catch (Exception e2) {
                                                    Log.e("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication getLaunchIntentForPackage, %s", e2.getMessage());
                                                }
                                            }
                                        }
                                        final LaunchApplicationTask launchApplicationTask = new LaunchApplicationTask(AndroidContextUtil.castActivityOrNull(sVar2.getRuntime().mContext));
                                        launchApplicationTask.appId = optString;
                                        launchApplicationTask.lzV = optString3;
                                        launchApplicationTask.extInfo = optString4;
                                        launchApplicationTask.dFP = bundle;
                                        launchApplicationTask.dDG = ceb.xGz;
                                        launchApplicationTask.lyv = new Runnable() {
                                            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.AnonymousClass1.AnonymousClass1.AnonymousClass3 */

                                            public final void run() {
                                                AppMethodBeat.i(45836);
                                                Log.i("MicroMsg.JsApiLaunchApplicationForNative", "callback task.success:%b", Boolean.valueOf(launchApplicationTask.success));
                                                launchApplicationTask.bDK();
                                                if (!launchApplicationTask.success) {
                                                    sVar2.i(i2, JsApiLaunchApplicationForNative.this.h("fail:sdk launch fail", null));
                                                    AppMethodBeat.o(45836);
                                                    return;
                                                }
                                                sVar2.i(i2, JsApiLaunchApplicationForNative.this.h("ok", null));
                                                AppMethodBeat.o(45836);
                                            }
                                        };
                                        launchApplicationTask.bDJ();
                                        launchApplicationTask.bDI();
                                        AppMethodBeat.o(45837);
                                        return;
                                    case 1:
                                    default:
                                        sVar2.i(i2, JsApiLaunchApplicationForNative.this.h("fail:check fail 1", null));
                                        AppMethodBeat.o(45837);
                                        return;
                                    case 2:
                                        sVar2.i(i2, JsApiLaunchApplicationForNative.this.h("fail:check fail forbidden scene 2", null));
                                        AppMethodBeat.o(45837);
                                        return;
                                }
                            } else {
                                sVar2.i(i2, JsApiLaunchApplicationForNative.this.h("fail:check fail", null));
                                AppMethodBeat.o(45837);
                            }
                        }
                    });
                    AppMethodBeat.o(45838);
                }
            });
            AppMethodBeat.o(45849);
            return;
        }
        Log.e("MicroMsg.JsApiLaunchApplicationForNative", "appid and scheme is null or nil");
        sVar2.i(i2, h("fail:appid and scheme is null or nil", null));
        AppMethodBeat.o(45849);
    }

    static class LaunchApplicationTask extends AppBrandProxyTransparentUIProcessTask {
        public static final Parcelable.Creator<LaunchApplicationTask> CREATOR = new Parcelable.Creator<LaunchApplicationTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.LaunchApplicationTask.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ LaunchApplicationTask[] newArray(int i2) {
                return new LaunchApplicationTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ LaunchApplicationTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45840);
                LaunchApplicationTask launchApplicationTask = new LaunchApplicationTask(parcel, (byte) 0);
                AppMethodBeat.o(45840);
                return launchApplicationTask;
            }
        };
        public String appId;
        public int dDG;
        public Bundle dFP;
        public String extInfo;
        public Runnable lyv;
        public String lzV;
        public boolean success;

        /* synthetic */ LaunchApplicationTask(Parcel parcel, byte b2) {
            this(parcel);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask
        public final void a(Context context, final AppBrandProxyTransparentUIProcessTask.a aVar) {
            boolean z;
            String str;
            AppMethodBeat.i(45841);
            a aVar2 = new a(new a.AbstractC0625a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.LaunchApplicationTask.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative.a.AbstractC0625a
                public final void u(boolean z, boolean z2) {
                    AppMethodBeat.i(45839);
                    Log.i("MicroMsg.JsApiLaunchApplicationForNative", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                    if (z) {
                        LaunchApplicationTask.this.success = true;
                        aVar.bDH();
                        AppMethodBeat.o(45839);
                        return;
                    }
                    LaunchApplicationTask.this.success = false;
                    aVar.bDH();
                    AppMethodBeat.o(45839);
                }
            });
            WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
            wXAppExtendObject.extInfo = this.extInfo;
            WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
            wXMediaMessage.sdkVer = Build.SDK_INT;
            wXMediaMessage.messageExt = this.extInfo;
            lp lpVar = new lp();
            lpVar.dQT.dCE = wXMediaMessage;
            lpVar.dQT.appId = this.appId;
            lpVar.dQT.dDG = this.dDG;
            lpVar.dQT.context = context;
            lpVar.dQT.dFP = this.dFP;
            lpVar.dQT.dQV = aVar2;
            EventCenter.instance.publish(lpVar);
            boolean z2 = lpVar.dQU.dQW;
            if (!z2) {
                if (Util.isNullOrNil(this.appId) || Util.isNullOrNil(this.lzV)) {
                    Log.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication nil appId or parameter.");
                } else {
                    String str2 = this.appId + "://" + this.lzV;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
                    Log.i("MicroMsg.JsApiLaunchApplicationForNative", "launchApplication by opensdk failed, try to launch by scheme(%s).", str2);
                    intent.addFlags(268435456);
                    List<ResolveInfo> queryIntentActivities = Util.queryIntentActivities(context, intent);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        if (!TextUtils.isEmpty(intent.getPackage()) || queryIntentActivities.size() != 1) {
                            str = intent.getPackage();
                        } else {
                            str = h.b(queryIntentActivities.get(0));
                        }
                        if (!Util.nullAsNil(MMApplicationContext.getPackageName()).equals(str)) {
                            aVar2.iMQ = false;
                            aVar2.lzY = false;
                            aVar2.lzZ = false;
                            aVar2.dQW = false;
                            z = h.a(context, intent, null, aVar2, this.dFP);
                            z2 = z;
                        }
                    }
                    z = z2;
                    z2 = z;
                }
            }
            aVar2.hj(z2);
            AppMethodBeat.o(45841);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask
        public final void bjk() {
            AppMethodBeat.i(45842);
            Log.i("MicroMsg.JsApiLaunchApplicationForNative", "runInClientProcess");
            if (this.lyv != null) {
                Log.i("MicroMsg.JsApiLaunchApplicationForNative", "runInClientProcess asyncCallback != null");
                this.lyv.run();
            }
            AppMethodBeat.o(45842);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(45843);
            this.dDG = parcel.readInt();
            this.appId = parcel.readString();
            this.lzV = parcel.readString();
            this.extInfo = parcel.readString();
            this.dFP = parcel.readBundle();
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.success = z;
            AppMethodBeat.o(45843);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45844);
            parcel.writeInt(this.dDG);
            parcel.writeString(this.appId);
            parcel.writeString(this.lzV);
            parcel.writeString(this.extInfo);
            parcel.writeBundle(this.dFP);
            parcel.writeByte((byte) (this.success ? 1 : 0));
            AppMethodBeat.o(45844);
        }

        public LaunchApplicationTask(Activity activity) {
            super(activity);
        }

        private LaunchApplicationTask(Parcel parcel) {
            AppMethodBeat.i(45845);
            f(parcel);
            AppMethodBeat.o(45845);
        }

        static {
            AppMethodBeat.i(45846);
            AppMethodBeat.o(45846);
        }
    }

    static class a implements al {
        volatile boolean dQW;
        volatile boolean iMQ;
        AbstractC0625a lDt;
        volatile boolean lzY;
        volatile boolean lzZ;

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiLaunchApplicationForNative$a$a  reason: collision with other inner class name */
        public interface AbstractC0625a {
            void u(boolean z, boolean z2);
        }

        a(AbstractC0625a aVar) {
            this.lDt = aVar;
        }

        @Override // com.tencent.mm.pluginsdk.model.app.al
        public final void v(boolean z, boolean z2) {
            AppMethodBeat.i(226686);
            this.iMQ = true;
            this.lzY = z;
            if (this.lzZ && this.lDt != null) {
                this.lDt.u(this.dQW, z);
            }
            AppMethodBeat.o(226686);
        }

        /* access modifiers changed from: package-private */
        public final void hj(boolean z) {
            AppMethodBeat.i(45848);
            this.dQW = z;
            this.lzZ = true;
            if (this.iMQ && this.lDt != null) {
                this.lDt.u(z, this.lzY);
            }
            AppMethodBeat.o(45848);
        }
    }
}
