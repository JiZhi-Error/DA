package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.liteav.TXLiteAVCode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.ac.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.ui.y;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.protocal.protobuf.cea;
import com.tencent.mm.protocal.protobuf.ceb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.base.h;
import com.tencent.sqlitelint.behaviour.persistence.IssueStorage;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiLaunchApplicationDirectly extends JsApiLaunchApplication {
    private static final int CTRL_INDEX = 620;
    private static final String NAME = "launchApplicationDirectly";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication, com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* bridge */ /* synthetic */ void a(s sVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45538);
        a(sVar, jSONObject, i2);
        AppMethodBeat.o(45538);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplication
    public final void a(final s sVar, JSONObject jSONObject, final int i2) {
        String str;
        AppMethodBeat.i(45537);
        if (jSONObject == null) {
            Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "data is null");
            sVar.i(i2, h("fail:data is null", null));
            AppMethodBeat.o(45537);
            return;
        }
        final String optString = jSONObject.optString("appId");
        final String optString2 = jSONObject.optString("schemeUrl");
        final String optString3 = jSONObject.optString("parameter");
        int i3 = Util.getInt(jSONObject.optString("alertType"), 0);
        int i4 = Util.getInt(jSONObject.optString("operateDirectly"), 0);
        final String optString4 = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
        final String optString5 = jSONObject.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
        final String optString6 = jSONObject.optString("installSchemeUrl");
        final String optString7 = jSONObject.optString("fileMd5");
        final String optString8 = jSONObject.optString("taskName");
        Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "appid : %s, scheme : %s, extinfo:[%s], parameter : %s", optString, optString2, optString4, optString3);
        if (!Util.isNullOrNil(optString) || !Util.isNullOrNil(optString2)) {
            String appId = sVar.getAppId();
            ac currentPageView = sVar.getCurrentPageView();
            if (currentPageView != null) {
                str = currentPageView.lBI;
            } else {
                Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "getCurrentPageView is null");
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
            cea.scene = ((q) sVar.getRuntime()).ON().cyA.scene;
            cea.url = str;
            cea.MjE = optString2;
            cea.qwp = i3;
            cea.LEg = 1;
            cea.MjF = i4;
            cea.MjG = optString6;
            Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "run cgi to check(appId : %s, toAppId : %s, scene : %s, url : %s, schemeUrl : %s, alertType : %s, operateDirectly : %s)", appId, optString, Integer.valueOf(cea.scene), cea.url, cea.MjE, Integer.valueOf(cea.qwp), Integer.valueOf(cea.MjF));
            IPCRunCgi.a(aVar.aXF(), new IPCRunCgi.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.AnonymousClass1 */

                @Override // com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a
                public final void a(final int i2, final int i3, String str, final d dVar) {
                    AppMethodBeat.i(45515);
                    Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "on RunCgi callback errType:%d errCode:%d msg:%s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                    com.tencent.mm.ch.a.post(new Runnable() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            String str;
                            AppMethodBeat.i(45514);
                            if (i2 == 0 && i3 == 0) {
                                final ceb ceb = (ceb) dVar.iLL.iLR;
                                Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication check result(showType:%d, errCode:%d, jumpFlog:%d)", Integer.valueOf(ceb.xGz), Integer.valueOf(ceb.dIZ), Integer.valueOf(ceb.MjI));
                                switch (ceb.dIZ) {
                                    case 0:
                                        if (ceb.MjI == 1) {
                                            sVar.i(i2, JsApiLaunchApplicationDirectly.this.h("fail:install app denied", null));
                                            AppMethodBeat.o(45514);
                                            return;
                                        } else if (b.getPackageInfo(MMApplicationContext.getContext(), optString5) == null) {
                                            Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication, no weishi app, go download it");
                                            MMHandlerThread.postToMainThread(new Runnable() {
                                                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                public final void run() {
                                                    AppMethodBeat.i(226671);
                                                    JsApiLaunchApplicationDirectly jsApiLaunchApplicationDirectly = JsApiLaunchApplicationDirectly.this;
                                                    String str = optString6;
                                                    String str2 = optString;
                                                    String str3 = optString8;
                                                    String str4 = optString7;
                                                    String str5 = optString5;
                                                    s sVar = sVar;
                                                    int i2 = i2;
                                                    h.a(sVar.getContext(), sVar.getContext().getString(R.string.a1m), "", sVar.getContext().getString(R.string.jn), sVar.getContext().getString(R.string.je), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(sVar, str2, str, str3, str4, str5, i2) {
                                                        /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.AnonymousClass3 */
                                                        final /* synthetic */ String cQM;
                                                        final /* synthetic */ s cvO;
                                                        final /* synthetic */ int cvP;
                                                        final /* synthetic */ String kNk;
                                                        final /* synthetic */ String lAb;
                                                        final /* synthetic */ String lAc;
                                                        final /* synthetic */ String val$appId;

                                                        {
                                                            this.cvO = r2;
                                                            this.val$appId = r3;
                                                            this.lAb = r4;
                                                            this.lAc = r5;
                                                            this.kNk = r6;
                                                            this.cQM = r7;
                                                            this.cvP = r8;
                                                        }

                                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                                            AppMethodBeat.i(45517);
                                                            JsApiLaunchApplicationDirectly.a(JsApiLaunchApplicationDirectly.this, this.cvO);
                                                            JSONObject jSONObject = new JSONObject();
                                                            try {
                                                                jSONObject.put("appId", this.val$appId);
                                                                jSONObject.put("taskUrl", this.lAb);
                                                                jSONObject.put("taskName", this.lAc);
                                                                jSONObject.put("fileMd5", this.kNk);
                                                                jSONObject.put(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME, this.cQM);
                                                                AppBrandMainProcessService.a(new AddDownloadTaskStraightTask(JsApiLaunchApplicationDirectly.this, this.cvO, this.cvP, jSONObject));
                                                                this.cvO.i(this.cvP, JsApiLaunchApplicationDirectly.this.h("ok:user downloaded app", null));
                                                                AppMethodBeat.o(45517);
                                                            } catch (JSONException e2) {
                                                                Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication, download app fail", e2);
                                                                this.cvO.i(this.cvP, JsApiLaunchApplicationDirectly.this.h("fail:download app fail", null));
                                                                AppMethodBeat.o(45517);
                                                            }
                                                        }
                                                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener(sVar, i2) {
                                                        /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.AnonymousClass4 */
                                                        final /* synthetic */ s cvO;
                                                        final /* synthetic */ int cvP;

                                                        {
                                                            this.cvO = r2;
                                                            this.cvP = r3;
                                                        }

                                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                                            AppMethodBeat.i(45518);
                                                            Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "fail:user canceled install");
                                                            JsApiLaunchApplicationDirectly.a(JsApiLaunchApplicationDirectly.this, this.cvO);
                                                            this.cvO.i(this.cvP, JsApiLaunchApplicationDirectly.this.h("fail:user canceled install", null));
                                                            AppMethodBeat.o(45518);
                                                        }
                                                    });
                                                    AppMethodBeat.o(226671);
                                                }
                                            });
                                            AppMethodBeat.o(45514);
                                            return;
                                        } else {
                                            final a aVar = new a(new a.AbstractC0595a() {
                                                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                                @Override // com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.a.AbstractC0595a
                                                public final void u(boolean z, boolean z2) {
                                                    AppMethodBeat.i(226672);
                                                    Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                                                    JsApiLaunchApplicationDirectly.a(JsApiLaunchApplicationDirectly.this, sVar);
                                                    if (z) {
                                                        sVar.i(i2, JsApiLaunchApplicationDirectly.this.h("ok", null));
                                                        AppMethodBeat.o(226672);
                                                        return;
                                                    }
                                                    sVar.i(i2, JsApiLaunchApplicationDirectly.this.h("fail:scheme launch fail", null));
                                                    AppMethodBeat.o(226672);
                                                }
                                            });
                                            if (!Util.isNullOrNil(optString2)) {
                                                final Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString2));
                                                intent.addFlags(268435456);
                                                List<ResolveInfo> queryIntentActivities = Util.queryIntentActivities(sVar.getContext(), intent);
                                                if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                                                    if (!TextUtils.isEmpty(intent.getPackage()) || queryIntentActivities.size() != 1) {
                                                        str = intent.getPackage();
                                                    } else {
                                                        str = com.tencent.mm.pluginsdk.model.app.h.b(queryIntentActivities.get(0));
                                                    }
                                                    if (!Util.nullAsNil(MMApplicationContext.getPackageName()).equals(str)) {
                                                        MMHandlerThread.postToMainThread(new Runnable() {
                                                            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.AnonymousClass1.AnonymousClass1.AnonymousClass3 */

                                                            public final void run() {
                                                                AppMethodBeat.i(45513);
                                                                aVar.hj(com.tencent.mm.pluginsdk.model.app.h.a(sVar.getContext(), intent, (String) null, ceb.xGz, aVar, bundle));
                                                                AppMethodBeat.o(45513);
                                                            }
                                                        });
                                                        AppMethodBeat.o(45514);
                                                        return;
                                                    }
                                                }
                                            }
                                            final LaunchApplicationTask launchApplicationTask = new LaunchApplicationTask(AndroidContextUtil.castActivityOrNull(sVar.getRuntime().mContext));
                                            launchApplicationTask.appId = optString;
                                            launchApplicationTask.lzV = optString3;
                                            launchApplicationTask.extInfo = optString4;
                                            launchApplicationTask.dFP = bundle;
                                            launchApplicationTask.dDG = ceb.xGz;
                                            launchApplicationTask.lyv = new Runnable() {
                                                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.AnonymousClass1.AnonymousClass1.AnonymousClass4 */

                                                public final void run() {
                                                    AppMethodBeat.i(226673);
                                                    Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "callback task.success:%b", Boolean.valueOf(launchApplicationTask.success));
                                                    launchApplicationTask.bDK();
                                                    if (!launchApplicationTask.success) {
                                                        sVar.i(i2, JsApiLaunchApplicationDirectly.this.h("fail:sdk launch fail", null));
                                                        AppMethodBeat.o(226673);
                                                        return;
                                                    }
                                                    sVar.i(i2, JsApiLaunchApplicationDirectly.this.h("ok", null));
                                                    AppMethodBeat.o(226673);
                                                }
                                            };
                                            launchApplicationTask.bDJ();
                                            launchApplicationTask.bDI();
                                            AppMethodBeat.o(45514);
                                            return;
                                        }
                                    case 1:
                                    default:
                                        sVar.i(i2, JsApiLaunchApplicationDirectly.this.h("fail:check fail 1", null));
                                        AppMethodBeat.o(45514);
                                        return;
                                    case 2:
                                        sVar.i(i2, JsApiLaunchApplicationDirectly.this.h("fail:check fail forbidden scene 2", null));
                                        AppMethodBeat.o(45514);
                                        return;
                                }
                            } else {
                                sVar.i(i2, JsApiLaunchApplicationDirectly.this.h("fail:check fail", null));
                                AppMethodBeat.o(45514);
                            }
                        }
                    });
                    AppMethodBeat.o(45515);
                }
            });
            AppMethodBeat.o(45537);
            return;
        }
        Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "appid and scheme is null or nil");
        sVar.i(i2, h("fail:appid and scheme is null or nil", null));
        AppMethodBeat.o(45537);
    }

    static class LaunchApplicationTask extends AppBrandProxyTransparentUIProcessTask {
        public static final Parcelable.Creator<LaunchApplicationTask> CREATOR = new Parcelable.Creator<LaunchApplicationTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.LaunchApplicationTask.AnonymousClass2 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ LaunchApplicationTask[] newArray(int i2) {
                return new LaunchApplicationTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ LaunchApplicationTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45528);
                LaunchApplicationTask launchApplicationTask = new LaunchApplicationTask(parcel, (byte) 0);
                AppMethodBeat.o(45528);
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
            AppMethodBeat.i(45529);
            a aVar2 = new a(new a.AbstractC0595a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.LaunchApplicationTask.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.a.AbstractC0595a
                public final void u(boolean z, boolean z2) {
                    AppMethodBeat.i(45527);
                    Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "onLaunchAppCallback(launchRet : %s, launchSuccess : %s)", Boolean.valueOf(z), Boolean.valueOf(z2));
                    if (z) {
                        LaunchApplicationTask.this.success = true;
                        aVar.bDH();
                        AppMethodBeat.o(45527);
                        return;
                    }
                    LaunchApplicationTask.this.success = false;
                    aVar.bDH();
                    AppMethodBeat.o(45527);
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
                    Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication nil appId or parameter.");
                } else {
                    String str2 = this.appId + "://" + this.lzV;
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2));
                    Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "launchApplication by opensdk failed, try to launch by scheme(%s).", str2);
                    intent.addFlags(268435456);
                    List<ResolveInfo> queryIntentActivities = Util.queryIntentActivities(context, intent);
                    if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                        if (!TextUtils.isEmpty(intent.getPackage()) || queryIntentActivities.size() != 1) {
                            str = intent.getPackage();
                        } else {
                            str = com.tencent.mm.pluginsdk.model.app.h.b(queryIntentActivities.get(0));
                        }
                        if (!Util.nullAsNil(MMApplicationContext.getPackageName()).equals(str)) {
                            aVar2.iMQ = false;
                            aVar2.lzY = false;
                            aVar2.lzZ = false;
                            aVar2.dQW = false;
                            z = com.tencent.mm.pluginsdk.model.app.h.a(context, intent, null, aVar2, this.dFP);
                            z2 = z;
                        }
                    }
                    z = z2;
                    z2 = z;
                }
            }
            aVar2.hj(z2);
            AppMethodBeat.o(45529);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask
        public final void bjk() {
            AppMethodBeat.i(45530);
            Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInClientProcess");
            if (this.lyv != null) {
                Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInClientProcess asyncCallback != null");
                this.lyv.run();
            }
            AppMethodBeat.o(45530);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(45531);
            this.dDG = parcel.readInt();
            this.appId = parcel.readString();
            this.lzV = parcel.readString();
            this.extInfo = parcel.readString();
            this.dFP = parcel.readBundle();
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.success = z;
            AppMethodBeat.o(45531);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyTransparentUIProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45532);
            parcel.writeInt(this.dDG);
            parcel.writeString(this.appId);
            parcel.writeString(this.lzV);
            parcel.writeString(this.extInfo);
            parcel.writeBundle(this.dFP);
            parcel.writeByte((byte) (this.success ? 1 : 0));
            AppMethodBeat.o(45532);
        }

        public LaunchApplicationTask(Activity activity) {
            super(activity);
        }

        private LaunchApplicationTask(Parcel parcel) {
            AppMethodBeat.i(45533);
            f(parcel);
            AppMethodBeat.o(45533);
        }

        static {
            AppMethodBeat.i(45534);
            AppMethodBeat.o(45534);
        }
    }

    static class a implements al {
        volatile boolean dQW;
        volatile boolean iMQ;
        AbstractC0595a lAu;
        volatile boolean lzY;
        volatile boolean lzZ;

        /* access modifiers changed from: package-private */
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly$a$a  reason: collision with other inner class name */
        public interface AbstractC0595a {
            void u(boolean z, boolean z2);
        }

        a(AbstractC0595a aVar) {
            this.lAu = aVar;
        }

        @Override // com.tencent.mm.pluginsdk.model.app.al
        public final void v(boolean z, boolean z2) {
            AppMethodBeat.i(226674);
            this.iMQ = true;
            this.lzY = z;
            if (this.lzZ && this.lAu != null) {
                this.lAu.u(this.dQW, z);
            }
            AppMethodBeat.o(226674);
        }

        /* access modifiers changed from: package-private */
        public final void hj(boolean z) {
            AppMethodBeat.i(45536);
            this.dQW = z;
            this.lzZ = true;
            if (this.iMQ && this.lAu != null) {
                this.lAu.u(z, this.lzY);
            }
            AppMethodBeat.o(45536);
        }
    }

    static class AddDownloadTaskStraightTask extends MainProcessTask {
        public static final Parcelable.Creator<AddDownloadTaskStraightTask> CREATOR = new Parcelable.Creator<AddDownloadTaskStraightTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.AddDownloadTaskStraightTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ AddDownloadTaskStraightTask[] newArray(int i2) {
                return new AddDownloadTaskStraightTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ AddDownloadTaskStraightTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(45519);
                AddDownloadTaskStraightTask addDownloadTaskStraightTask = new AddDownloadTaskStraightTask(parcel);
                AppMethodBeat.o(45519);
                return addDownloadTaskStraightTask;
            }
        };
        private int csv;
        private s kAr;
        private p lAi;
        private String lAj;
        private String lAk;
        private String lAl;
        private String lAm;
        private long lAn;
        private String lAo;
        private String lAp;
        private boolean lAq;
        private String lAr;
        private long lAs;
        private String mAppId;
        private String mPackageName;

        public AddDownloadTaskStraightTask(p pVar, s sVar, int i2, JSONObject jSONObject) {
            AppMethodBeat.i(45520);
            this.lAi = pVar;
            this.kAr = sVar;
            this.csv = i2;
            this.lAj = jSONObject.optString("taskName");
            this.lAk = jSONObject.optString("taskUrl");
            this.lAl = jSONObject.optString("fileMd5");
            this.lAm = jSONObject.optString("alternativeUrl");
            this.lAn = (long) jSONObject.optInt("taskSize", 0);
            this.lAo = jSONObject.optString(IssueStorage.COLUMN_EXT_INFO);
            this.lAp = jSONObject.optString("fileType");
            this.mAppId = jSONObject.optString("appId");
            this.mPackageName = jSONObject.optString(AssistantStore.DownloadInfos.DownloadInfoColumns.PACKAGENAME);
            this.lAq = true;
            AppMethodBeat.o(45520);
        }

        public AddDownloadTaskStraightTask(Parcel parcel) {
            AppMethodBeat.i(45521);
            f(parcel);
            AppMethodBeat.o(45521);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            String format;
            AppMethodBeat.i(45523);
            if (this.lAq) {
                if (Util.isNullOrNil(this.lAr)) {
                    format = "fail";
                } else {
                    format = String.format("fail:%s", this.lAr);
                }
                this.kAr.i(this.csv, this.lAi.h(format, null));
                AppMethodBeat.o(45523);
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("downloadId", Long.valueOf(this.lAs));
            this.kAr.i(this.csv, this.lAi.n("ok", hashMap));
            AppMethodBeat.o(45523);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(45524);
            this.lAj = parcel.readString();
            this.lAk = parcel.readString();
            this.lAl = parcel.readString();
            this.lAm = parcel.readString();
            this.lAn = parcel.readLong();
            this.lAo = parcel.readString();
            this.lAp = parcel.readString();
            this.mAppId = parcel.readString();
            this.mPackageName = parcel.readString();
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.lAq = z;
            this.lAr = parcel.readString();
            this.lAs = parcel.readLong();
            AppMethodBeat.o(45524);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(45525);
            parcel.writeString(this.lAj);
            parcel.writeString(this.lAk);
            parcel.writeString(this.lAl);
            parcel.writeString(this.lAm);
            parcel.writeLong(this.lAn);
            parcel.writeString(this.lAo);
            parcel.writeString(this.lAp);
            parcel.writeString(this.mAppId);
            parcel.writeString(this.mPackageName);
            parcel.writeInt(this.lAq ? 1 : 0);
            parcel.writeString(this.lAr);
            parcel.writeLong(this.lAs);
            AppMethodBeat.o(45525);
        }

        static {
            AppMethodBeat.i(45526);
            AppMethodBeat.o(45526);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(45522);
            g.aAi();
            if (!g.aAh().isSDCardAvailable()) {
                this.lAr = "fail_sdcard_not_ready";
            } else if (this.lAn > 0 && !e.yV(this.lAn)) {
                this.lAr = "fail_sdcard_has_not_enough_space";
            } else if (Util.isNullOrNil(this.lAk)) {
                this.lAr = "fail_invalid_url";
            } else {
                Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "runInMainProcess taskUrl:%s md5:%s", this.lAk, this.lAl);
                g.a aVar = new g.a();
                aVar.alj(this.lAk);
                aVar.alk(this.lAm);
                aVar.setFileSize(this.lAn);
                aVar.all(this.lAj);
                aVar.setFileMD5(this.lAl);
                aVar.setAppId(this.mAppId);
                aVar.gm(this.mPackageName);
                aVar.kS(true);
                aVar.Fl(Util.getInt(this.lAp, 1));
                aVar.setScene(TXLiteAVCode.WARNING_IGNORE_UPSTREAM_FOR_AUDIENCE);
                aVar.Rv(this.lAo);
                long a2 = f.cBv().a(aVar.qIY);
                Log.i("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight, downloadId = ".concat(String.valueOf(a2)));
                if (a2 <= 0) {
                    Log.e("MicroMsg.JsApiLaunchApplicationDirectly", "doAddDownloadTaskStraight fail, downloadId = ".concat(String.valueOf(a2)));
                    this.lAr = "";
                } else {
                    this.lAq = false;
                    this.lAs = a2;
                }
            }
            bDU();
            AppMethodBeat.o(45522);
        }
    }

    static /* synthetic */ void a(JsApiLaunchApplicationDirectly jsApiLaunchApplicationDirectly, final s sVar) {
        AppMethodBeat.i(45539);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchApplicationDirectly.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(45516);
                if (sVar != null && "wxfe02ecfe70800f46".equalsIgnoreCase(sVar.getAppId()) && sVar.getContext() != null && (sVar.getContext() instanceof Activity)) {
                    y.a(((Activity) sVar.getContext()).getWindow(), true, false);
                }
                AppMethodBeat.o(45516);
            }
        });
        AppMethodBeat.o(45539);
    }
}
