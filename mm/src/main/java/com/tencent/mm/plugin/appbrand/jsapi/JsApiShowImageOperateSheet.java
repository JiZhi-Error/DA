package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Pair;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.app.AppBrandMixExportLogicService;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.page.ag;
import com.tencent.mm.plugin.appbrand.utils.c;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsApiShowImageOperateSheet extends d<ag> {
    public static final int CTRL_INDEX = 626;
    public static final String NAME = "showImageOperateSheet";

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.appbrand.jsapi.f, org.json.JSONObject, int] */
    @Override // com.tencent.mm.plugin.appbrand.jsapi.d
    public final /* synthetic */ void a(ag agVar, JSONObject jSONObject, int i2) {
        AppMethodBeat.i(45701);
        ag agVar2 = agVar;
        try {
            String string = jSONObject.getString("imageUrl");
            String string2 = jSONObject.getString("imageBase64");
            int zD = g.zD(jSONObject.getInt("elementLeft"));
            int zD2 = g.zD(jSONObject.getInt("elementTop"));
            new BottomSheetLogicHelper(agVar2, string, string2, new Rect(zD, zD2, g.zD(jSONObject.getInt("elementWidth")) + zD, g.zD(jSONObject.getInt("elementHeight")) + zD2)).bEq();
            agVar2.i(i2, h("ok", null));
            AppMethodBeat.o(45701);
        } catch (JSONException e2) {
            Log.e("MicroMsg.JsApiShowImageOperateSheet", "fail exp:%s", e2.getLocalizedMessage());
            agVar2.i(i2, h("fail invalid params", null));
            AppMethodBeat.o(45701);
        }
    }

    /* access modifiers changed from: package-private */
    public static class BottomSheetLogicHelper {
        private static Set<Integer> lBJ;
        private static Set<Integer> lBK;
        private IPCQRCodeRecognizeResult lBL;
        private e lBM;
        private final ag lBN;
        private final String lBO;
        private final String lBP;
        private final Rect lBQ;

        static {
            AppMethodBeat.i(45700);
            HashSet hashSet = new HashSet();
            lBJ = hashSet;
            hashSet.add(3);
            HashSet hashSet2 = new HashSet();
            lBK = hashSet2;
            hashSet2.add(22);
            AppMethodBeat.o(45700);
        }

        public BottomSheetLogicHelper(ag agVar, String str, String str2, Rect rect) {
            this.lBN = agVar;
            this.lBO = str;
            this.lBP = str2;
            this.lBQ = rect;
        }

        public final void bEq() {
            AppMethodBeat.i(45691);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(45653);
                    BottomSheetLogicHelper.a(BottomSheetLogicHelper.this);
                    AppMethodBeat.o(45653);
                }
            }, (long) (com.tencent.luggage.h.g.aM(this.lBN.getContext()) ? 100 : 0));
            AppMethodBeat.o(45691);
        }

        private void a(c.a aVar) {
            AppMethodBeat.i(45692);
            if (!Util.isNullOrNil(this.lBP)) {
                o Wa = this.lBN.getFileSystem().Wa("showSheet_base64_" + System.currentTimeMillis());
                if (Wa == null) {
                    Log.e("MicroMsg.JsApiShowImageOperateSheet", "loadImage failed for allocTempFile");
                    AppMethodBeat.o(45692);
                    return;
                }
                String z = aa.z(Wa.her());
                byte[] decode = Base64.decode(this.lBP, 0);
                s.f(z, decode, decode.length);
                aVar.Wz(z);
                AppMethodBeat.o(45692);
                return;
            }
            com.tencent.mm.plugin.appbrand.utils.c.a(this.lBN, this.lBO, null, aVar);
            AppMethodBeat.o(45692);
        }

        static final class a implements com.tencent.mm.ipcinvoker.b<IPCString, IPCInteger> {
            private a() {
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
            @Override // com.tencent.mm.ipcinvoker.b
            public final /* synthetic */ void invoke(IPCString iPCString, com.tencent.mm.ipcinvoker.d<IPCInteger> dVar) {
                AppMethodBeat.i(45665);
                IPCString iPCString2 = iPCString;
                if (iPCString2 == null) {
                    Log.e("MicroMsg.JsApiShowImageOperateSheet", "IPCFav data null");
                    AppMethodBeat.o(45665);
                    return;
                }
                cz czVar = new cz();
                ((ad) com.tencent.mm.kernel.g.af(ad.class)).a(czVar, 1, iPCString2.value);
                czVar.dFZ.dGf = 32;
                EventCenter.instance.publish(czVar);
                if (dVar != null) {
                    dVar.bn(new IPCInteger(czVar.dGa.ret));
                }
                AppMethodBeat.o(45665);
            }
        }

        static final class c implements com.tencent.mm.ipcinvoker.b<IPCQRCodeRecognizeParam, IPCQRCodeRecognizeResult> {
            private boolean lCb = false;

            private c() {
            }

            static /* synthetic */ void a(c cVar, IPCQRCodeRecognizeParam iPCQRCodeRecognizeParam, com.tencent.mm.ipcinvoker.d dVar) {
                AppMethodBeat.i(45677);
                cVar.a(iPCQRCodeRecognizeParam, (com.tencent.mm.ipcinvoker.d<IPCQRCodeRecognizeResult>) dVar, true);
                AppMethodBeat.o(45677);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
            @Override // com.tencent.mm.ipcinvoker.b
            public final /* synthetic */ void invoke(IPCQRCodeRecognizeParam iPCQRCodeRecognizeParam, com.tencent.mm.ipcinvoker.d<IPCQRCodeRecognizeResult> dVar) {
                AppMethodBeat.i(45675);
                IPCQRCodeRecognizeParam iPCQRCodeRecognizeParam2 = iPCQRCodeRecognizeParam;
                if (iPCQRCodeRecognizeParam2 == null) {
                    Log.e("MicroMsg.JsApiShowImageOperateSheet", "IPCQRCodeRecognize data null");
                    AppMethodBeat.o(45675);
                    return;
                }
                a(iPCQRCodeRecognizeParam2, dVar, false);
                AppMethodBeat.o(45675);
            }

            private void a(final IPCQRCodeRecognizeParam iPCQRCodeRecognizeParam, final com.tencent.mm.ipcinvoker.d<IPCQRCodeRecognizeResult> dVar, boolean z) {
                AppMethodBeat.i(45674);
                final String str = z ? iPCQRCodeRecognizeParam.lCi : iPCQRCodeRecognizeParam.kTQ;
                Log.i("MicroMsg.JsApiShowImageOperateSheet", "doRecognizeLogic mIsBakPathUsed:%b useBak:%b path:%s", Boolean.valueOf(this.lCb), Boolean.valueOf(z), str);
                this.lCb = z;
                if (Util.isNullOrNil(str)) {
                    AppMethodBeat.o(45674);
                    return;
                }
                final i iVar = new i();
                final i iVar2 = new i();
                T t = (T) new IListener<qz>() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.c.AnonymousClass1 */

                    {
                        AppMethodBeat.i(160594);
                        this.__eventId = qz.class.getName().hashCode();
                        AppMethodBeat.o(160594);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(qz qzVar) {
                        AppMethodBeat.i(45671);
                        qz qzVar2 = qzVar;
                        Log.i("MicroMsg.JsApiShowImageOperateSheet", "IPCQRCodeRecognize callback");
                        if (iVar.value != null) {
                            EventCenter.instance.removeListener(iVar.value);
                        }
                        if (iVar2.value != null) {
                            EventCenter.instance.removeListener(iVar2.value);
                        }
                        if (!str.equals(qzVar2.dXz.filePath)) {
                            Log.w("MicroMsg.JsApiShowImageOperateSheet", "IPCQRCodeRecognize file path no same recognizeFilePath:%s filePath:%s", str, qzVar2.dXz.filePath);
                        } else {
                            Log.d("MicroMsg.JsApiShowImageOperateSheet", "result: " + qzVar2.dXz.result);
                            if (dVar != null) {
                                IPCQRCodeRecognizeResult iPCQRCodeRecognizeResult = new IPCQRCodeRecognizeResult();
                                iPCQRCodeRecognizeResult.result = qzVar2.dXz.result;
                                iPCQRCodeRecognizeResult.filePath = qzVar2.dXz.filePath;
                                iPCQRCodeRecognizeResult.dFL = qzVar2.dXz.dFL;
                                iPCQRCodeRecognizeResult.dFM = qzVar2.dXz.dFM;
                                dVar.bn(iPCQRCodeRecognizeResult);
                                c.a(c.this, iPCQRCodeRecognizeResult, dVar);
                            }
                        }
                        AppMethodBeat.o(45671);
                        return false;
                    }
                };
                iVar.value = t;
                T t2 = (T) new IListener<qy>() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.c.AnonymousClass2 */

                    {
                        AppMethodBeat.i(160595);
                        this.__eventId = qy.class.getName().hashCode();
                        AppMethodBeat.o(160595);
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
                    @Override // com.tencent.mm.sdk.event.IListener
                    public final /* synthetic */ boolean callback(qy qyVar) {
                        AppMethodBeat.i(45672);
                        qy qyVar2 = qyVar;
                        Log.i("MicroMsg.JsApiShowImageOperateSheet", "IPCQRCodeRecognize failed : mIsBakPathUsed:%b", Boolean.valueOf(c.this.lCb));
                        if (iVar.value != null) {
                            EventCenter.instance.removeListener(iVar.value);
                        }
                        if (iVar2.value != null) {
                            EventCenter.instance.removeListener(iVar2.value);
                        }
                        if (!str.equals(qyVar2.dXy.filePath)) {
                            Log.w("MicroMsg.JsApiShowImageOperateSheet", "IPCQRCodeRecognize failed : file path no same recognizeFilePath:%s filePath:%s", str, qyVar2.dXy.filePath);
                            AppMethodBeat.o(45672);
                        } else if (c.this.lCb) {
                            AppMethodBeat.o(45672);
                        } else {
                            c.a(c.this, iPCQRCodeRecognizeParam, dVar);
                            AppMethodBeat.o(45672);
                        }
                        return false;
                    }
                };
                iVar2.value = t2;
                EventCenter.instance.addListener(t);
                EventCenter.instance.addListener(t2);
                qx qxVar = new qx();
                qxVar.dXu.dDZ = System.currentTimeMillis();
                qxVar.dXu.filePath = str;
                qxVar.dXu.dXv = BottomSheetLogicHelper.lBJ;
                EventCenter.instance.publish(qxVar);
                AppMethodBeat.o(45674);
            }

            static /* synthetic */ void a(c cVar, final IPCQRCodeRecognizeResult iPCQRCodeRecognizeResult, final com.tencent.mm.ipcinvoker.d dVar) {
                AppMethodBeat.i(45676);
                AppBrandMixExportLogicService.y(iPCQRCodeRecognizeResult.result, iPCQRCodeRecognizeResult.dFL, iPCQRCodeRecognizeResult.dFM).a(new d.b<Pair<String, String>>() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.c.AnonymousClass3 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.g.d.b
                    public final /* synthetic */ void bz(Pair<String, String> pair) {
                        AppMethodBeat.i(45673);
                        Pair<String, String> pair2 = pair;
                        String str = (String) pair2.first;
                        String str2 = (String) pair2.second;
                        if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str2)) {
                            iPCQRCodeRecognizeResult.nickName = str;
                            iPCQRCodeRecognizeResult.iAR = str2;
                            dVar.bn(iPCQRCodeRecognizeResult);
                            AppMethodBeat.o(45673);
                            return;
                        }
                        Log.w("MicroMsg.JsApiShowImageOperateSheet", "processGetInfo nil");
                        AppMethodBeat.o(45673);
                    }
                });
                AppMethodBeat.o(45676);
            }
        }

        /* access modifiers changed from: package-private */
        public static final class IPCQRCodeRecognizeParam implements Parcelable {
            public static final Parcelable.Creator<IPCQRCodeRecognizeParam> CREATOR = new Parcelable.Creator<IPCQRCodeRecognizeParam>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeParam.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ IPCQRCodeRecognizeParam[] newArray(int i2) {
                    return new IPCQRCodeRecognizeParam[i2];
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ IPCQRCodeRecognizeParam createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(45678);
                    IPCQRCodeRecognizeParam iPCQRCodeRecognizeParam = new IPCQRCodeRecognizeParam(parcel);
                    AppMethodBeat.o(45678);
                    return iPCQRCodeRecognizeParam;
                }
            };
            private String kTQ;
            private String lCi;

            protected IPCQRCodeRecognizeParam() {
            }

            protected IPCQRCodeRecognizeParam(Parcel parcel) {
                AppMethodBeat.i(45679);
                this.kTQ = parcel.readString();
                this.lCi = parcel.readString();
                AppMethodBeat.o(45679);
            }

            public final int describeContents() {
                return 0;
            }

            public final void writeToParcel(Parcel parcel, int i2) {
                AppMethodBeat.i(45680);
                parcel.writeString(this.kTQ);
                parcel.writeString(this.lCi);
                AppMethodBeat.o(45680);
            }

            static {
                AppMethodBeat.i(45681);
                AppMethodBeat.o(45681);
            }
        }

        /* access modifiers changed from: package-private */
        public static final class IPCQRCodeRecognizeResult implements Parcelable {
            public static final Parcelable.Creator<IPCQRCodeRecognizeResult> CREATOR = new Parcelable.Creator<IPCQRCodeRecognizeResult>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ IPCQRCodeRecognizeResult[] newArray(int i2) {
                    return new IPCQRCodeRecognizeResult[i2];
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ IPCQRCodeRecognizeResult createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(45682);
                    IPCQRCodeRecognizeResult iPCQRCodeRecognizeResult = new IPCQRCodeRecognizeResult(parcel);
                    AppMethodBeat.o(45682);
                    return iPCQRCodeRecognizeResult;
                }
            };
            private int dFL;
            private int dFM;
            private String filePath;
            private String iAR;
            private String nickName;
            private String result;

            protected IPCQRCodeRecognizeResult() {
            }

            protected IPCQRCodeRecognizeResult(Parcel parcel) {
                AppMethodBeat.i(45683);
                this.result = parcel.readString();
                this.filePath = parcel.readString();
                this.dFL = parcel.readInt();
                this.dFM = parcel.readInt();
                this.nickName = parcel.readString();
                this.iAR = parcel.readString();
                AppMethodBeat.o(45683);
            }

            public final int describeContents() {
                return 0;
            }

            public final void writeToParcel(Parcel parcel, int i2) {
                AppMethodBeat.i(45684);
                parcel.writeString(this.result);
                parcel.writeString(this.filePath);
                parcel.writeInt(this.dFL);
                parcel.writeInt(this.dFM);
                parcel.writeString(this.nickName);
                parcel.writeString(this.iAR);
                AppMethodBeat.o(45684);
            }

            static {
                AppMethodBeat.i(45685);
                AppMethodBeat.o(45685);
            }
        }

        static final class b extends AppBrandProxyUIProcessTask {
            private b() {
            }

            @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
            public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
                AppMethodBeat.i(45670);
                if (!(processRequest instanceof IPCProcessQRCodeResultRequest)) {
                    Log.e("MicroMsg.JsApiShowImageOperateSheet", "IPCProcessQRCodeResultTask request instance not valid");
                    AppMethodBeat.o(45670);
                    return;
                }
                IPCProcessQRCodeResultRequest iPCProcessQRCodeResultRequest = (IPCProcessQRCodeResultRequest) processRequest;
                cr crVar = new cr();
                crVar.dFK.activity = bDF();
                crVar.dFK.dDX = iPCProcessQRCodeResultRequest.lCa.result;
                crVar.dFK.dFL = iPCProcessQRCodeResultRequest.lCa.dFL;
                crVar.dFK.dFM = iPCProcessQRCodeResultRequest.lCa.dFM;
                crVar.dFK.scene = 44;
                Bundle bundle = new Bundle();
                bundle.putInt("stat_scene", 6);
                bundle.putString("stat_app_id", iPCProcessQRCodeResultRequest.appID);
                bundle.putString("stat_url", iPCProcessQRCodeResultRequest.pageUrl);
                crVar.dFK.dFP = bundle;
                EventCenter.instance.publish(crVar);
                AppMethodBeat.o(45670);
            }
        }

        /* access modifiers changed from: package-private */
        public static final class IPCProcessQRCodeResultRequest extends AppBrandProxyUIProcessTask.ProcessRequest {
            public static final Parcelable.Creator<IPCProcessQRCodeResultRequest> CREATOR = new Parcelable.Creator<IPCProcessQRCodeResultRequest>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCProcessQRCodeResultRequest.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ IPCProcessQRCodeResultRequest[] newArray(int i2) {
                    return new IPCProcessQRCodeResultRequest[i2];
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ IPCProcessQRCodeResultRequest createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(45666);
                    IPCProcessQRCodeResultRequest iPCProcessQRCodeResultRequest = new IPCProcessQRCodeResultRequest(parcel);
                    AppMethodBeat.o(45666);
                    return iPCProcessQRCodeResultRequest;
                }
            };
            private String appID;
            private IPCQRCodeRecognizeResult lCa;
            private String pageUrl;

            protected IPCProcessQRCodeResultRequest() {
            }

            protected IPCProcessQRCodeResultRequest(Parcel parcel) {
                AppMethodBeat.i(45667);
                this.lCa = (IPCQRCodeRecognizeResult) parcel.readParcelable(IPCProcessQRCodeResultRequest.class.getClassLoader());
                this.appID = parcel.readString();
                this.pageUrl = parcel.readString();
                AppMethodBeat.o(45667);
            }

            @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
            public final void writeToParcel(Parcel parcel, int i2) {
                AppMethodBeat.i(45668);
                parcel.writeParcelable(this.lCa, i2);
                parcel.writeString(this.appID);
                parcel.writeString(this.pageUrl);
                AppMethodBeat.o(45668);
            }

            @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
            public final int describeContents() {
                return 0;
            }

            @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
            public final boolean bDN() {
                return true;
            }

            static {
                AppMethodBeat.i(45669);
                AppMethodBeat.o(45669);
            }

            @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
            public final Class<? extends AppBrandProxyUIProcessTask> bCJ() {
                return b.class;
            }
        }

        static final class IPCSendToFriendEmojiRequest extends AppBrandProxyUIProcessTask.ProcessRequest {
            public static final Parcelable.Creator<IPCSendToFriendEmojiRequest> CREATOR = new Parcelable.Creator<IPCSendToFriendEmojiRequest>() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest.AnonymousClass1 */

                /* Return type fixed from 'java.lang.Object[]' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* bridge */ /* synthetic */ IPCSendToFriendEmojiRequest[] newArray(int i2) {
                    return new IPCSendToFriendEmojiRequest[i2];
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ IPCSendToFriendEmojiRequest createFromParcel(Parcel parcel) {
                    AppMethodBeat.i(45686);
                    IPCSendToFriendEmojiRequest iPCSendToFriendEmojiRequest = new IPCSendToFriendEmojiRequest(parcel);
                    AppMethodBeat.o(45686);
                    return iPCSendToFriendEmojiRequest;
                }
            };
            private String lCj;

            protected IPCSendToFriendEmojiRequest() {
            }

            protected IPCSendToFriendEmojiRequest(Parcel parcel) {
                AppMethodBeat.i(45687);
                this.lCj = parcel.readString();
                AppMethodBeat.o(45687);
            }

            @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
            public final void writeToParcel(Parcel parcel, int i2) {
                AppMethodBeat.i(45688);
                parcel.writeString(this.lCj);
                AppMethodBeat.o(45688);
            }

            @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
            public final int describeContents() {
                return 0;
            }

            static {
                AppMethodBeat.i(45689);
                AppMethodBeat.o(45689);
            }

            @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest
            public final Class<? extends AppBrandProxyUIProcessTask> bCJ() {
                return d.class;
            }
        }

        static final class d extends AppBrandProxyUIProcessTask {
            private d() {
            }

            @Override // com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask
            public final void a(AppBrandProxyUIProcessTask.ProcessRequest processRequest) {
                EmojiInfo emojiInfo;
                boolean z;
                AppMethodBeat.i(45690);
                if (!(processRequest instanceof IPCSendToFriendEmojiRequest)) {
                    Log.e("MicroMsg.JsApiShowImageOperateSheet", "IPCSendToFriendEmojiRequest request instance not valid");
                    AppMethodBeat.o(45690);
                    return;
                }
                String str = ((IPCSendToFriendEmojiRequest) processRequest).lCj;
                EmojiInfo aml = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(s.bhK(str));
                if (aml == null) {
                    com.tencent.mm.pluginsdk.a.d emojiMgr = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
                    MMApplicationContext.getContext();
                    emojiInfo = ((com.tencent.mm.plugin.emoji.b.d) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(emojiMgr.amn(str));
                } else {
                    emojiInfo = aml;
                }
                long boW = emojiInfo == null ? 0 : s.boW(emojiInfo.hYx());
                String hYx = emojiInfo == null ? str : emojiInfo.hYx();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                if ((BitmapUtil.decodeFile(hYx, options) == null || options.outHeight <= com.tencent.mm.n.c.aqo()) && options.outWidth <= com.tencent.mm.n.c.aqo()) {
                    z = false;
                } else {
                    z = true;
                }
                if (boW > ((long) com.tencent.mm.n.c.aqp()) || z) {
                    h.a(bDF(), MMApplicationContext.getResources().getString(R.string.bs3), "", MMApplicationContext.getResources().getString(R.string.e2u), (DialogInterface.OnClickListener) null);
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("Retr_File_Name", emojiInfo == null ? "" : emojiInfo.getMd5());
                    intent.putExtra("Retr_Msg_Type", 5);
                    intent.putExtra("Retr_MsgImgScene", 1);
                    com.tencent.mm.br.c.f(bDF(), ".ui.transmit.MsgRetransmitUI", intent);
                }
                b(null);
                AppMethodBeat.o(45690);
            }
        }

        static /* synthetic */ void a(BottomSheetLogicHelper bottomSheetLogicHelper) {
            AppMethodBeat.i(45693);
            Log.i("MicroMsg.JsApiShowImageOperateSheet", "showBottomSheet imageUrl:%s", bottomSheetLogicHelper.lBO);
            final Context context = bottomSheetLogicHelper.lBN.getContext();
            if (bottomSheetLogicHelper.lBM == null) {
                bottomSheetLogicHelper.lBM = new e(context, 1, false);
            }
            bottomSheetLogicHelper.lBM.HLX = new o.f() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.AnonymousClass2 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(45654);
                    BottomSheetLogicHelper.this.lBM.setFooterView(null);
                    mVar.clear();
                    mVar.kV(1, R.string.g5c);
                    mVar.kV(2, R.string.gaq);
                    mVar.kV(3, R.string.fn9);
                    if (BottomSheetLogicHelper.this.lBL == null || Util.isNullOrNil(BottomSheetLogicHelper.this.lBL.result)) {
                        BottomSheetLogicHelper.a(BottomSheetLogicHelper.this, BottomSheetLogicHelper.this.lBN);
                        AppMethodBeat.o(45654);
                    } else if (com.tencent.mm.plugin.scanner.g.ca(BottomSheetLogicHelper.this.lBL.dFL, BottomSheetLogicHelper.this.lBL.result)) {
                        BottomSheetLogicHelper.this.lBM.setFooterView(BottomSheetLogicHelper.a(BottomSheetLogicHelper.this, context, BottomSheetLogicHelper.this.lBL.nickName, BottomSheetLogicHelper.this.lBL.iAR));
                        AppMethodBeat.o(45654);
                    } else {
                        Log.w("MicroMsg.JsApiShowImageOperateSheet", "showBottomSheet not WXCode codeType:%d result:%s", Integer.valueOf(BottomSheetLogicHelper.this.lBL.dFL), BottomSheetLogicHelper.this.lBL.result);
                        AppMethodBeat.o(45654);
                    }
                }
            };
            bottomSheetLogicHelper.lBM.HLY = new o.g() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.AnonymousClass3 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(45655);
                    switch (menuItem.getItemId()) {
                        case 1:
                            BottomSheetLogicHelper.e(BottomSheetLogicHelper.this);
                            AppMethodBeat.o(45655);
                            return;
                        case 2:
                            BottomSheetLogicHelper.f(BottomSheetLogicHelper.this);
                            AppMethodBeat.o(45655);
                            return;
                        case 3:
                            BottomSheetLogicHelper.g(BottomSheetLogicHelper.this);
                            AppMethodBeat.o(45655);
                            return;
                        case 4:
                            BottomSheetLogicHelper.h(BottomSheetLogicHelper.this);
                            break;
                    }
                    AppMethodBeat.o(45655);
                }
            };
            bottomSheetLogicHelper.lBM.PGl = new e.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.AnonymousClass4 */

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                }
            };
            if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
                bottomSheetLogicHelper.lBM.dGm();
            }
            AppMethodBeat.o(45693);
        }

        static /* synthetic */ View a(BottomSheetLogicHelper bottomSheetLogicHelper, Context context, String str, String str2) {
            AppMethodBeat.i(45694);
            AnonymousClass5 r0 = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(45656);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/JsApiShowImageOperateSheet$BottomSheetLogicHelper$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (BottomSheetLogicHelper.this.lBM.isShowing()) {
                        BottomSheetLogicHelper.this.lBM.bMo();
                    }
                    BottomSheetLogicHelper.h(BottomSheetLogicHelper.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/JsApiShowImageOperateSheet$BottomSheetLogicHelper$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(45656);
                }
            };
            com.tencent.mm.ui.widget.bottomsheet.b bVar = new com.tencent.mm.ui.widget.bottomsheet.b(context);
            if (Util.isNullOrNil(str)) {
                str = context.getString(R.string.fv7);
            }
            bVar.setTitle(str);
            bVar.setSubtitle(context.getString(R.string.fv6));
            if (!Util.isNullOrNil(str2)) {
                com.tencent.mm.av.a.a.bdb().loadImage(str2, bVar.getIcon());
            }
            bVar.setOnClickListener(r0);
            AppMethodBeat.o(45694);
            return bVar;
        }

        static /* synthetic */ void a(BottomSheetLogicHelper bottomSheetLogicHelper, ag agVar) {
            final Bitmap bitmap;
            AppMethodBeat.i(45695);
            final com.tencent.mm.vfs.o Wa = agVar.getFileSystem().Wa("showSheet_" + System.currentTimeMillis());
            if (Wa == null) {
                Log.e("MicroMsg.JsApiShowImageOperateSheet", "processRecognizeQRCodeLogic failed for allocTempFile");
                AppMethodBeat.o(45695);
                return;
            }
            final Bitmap bRB = agVar.bRB();
            if (bRB == null || bRB.isRecycled() || bRB.getWidth() <= 0 || bRB.getHeight() <= 0) {
                Log.e("MicroMsg.JsApiShowImageOperateSheet", "processRecognizeQRCodeLogic bitmap not valid");
                AppMethodBeat.o(45695);
                return;
            }
            Rect rect = bottomSheetLogicHelper.lBQ;
            int width = bRB.getWidth();
            int height = bRB.getHeight();
            Log.i("MicroMsg.JsApiShowImageOperateSheet", "constructValidElementRect from left:%d top:%d width:%d height:%d", Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.width()), Integer.valueOf(rect.height()));
            Rect rect2 = new Rect(Math.min(width, Math.max(0, rect.left)), Math.min(height, Math.max(0, rect.top)), Math.min(width, Math.max(0, rect.right)), Math.min(height, Math.max(0, rect.bottom)));
            Log.i("MicroMsg.JsApiShowImageOperateSheet", "constructValidElementRect final left:%d top:%d width:%d height:%d", Integer.valueOf(rect2.left), Integer.valueOf(rect2.top), Integer.valueOf(rect2.width()), Integer.valueOf(rect2.height()));
            if (rect2.width() <= 0 || rect2.height() <= 0) {
                bitmap = null;
            } else {
                bitmap = Bitmap.createBitmap(bRB, rect2.left, rect2.top, rect2.width(), rect2.height());
            }
            com.tencent.mm.ch.a.post(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.AnonymousClass9 */

                public final void run() {
                    AppMethodBeat.i(45664);
                    String z = aa.z(Wa.her());
                    String str = aa.z(Wa.her()) + "_full";
                    Log.i("MicroMsg.JsApiShowImageOperateSheet", "processRecognizeQRCodeLogic capturePath:%s", z);
                    IPCQRCodeRecognizeParam iPCQRCodeRecognizeParam = new IPCQRCodeRecognizeParam();
                    try {
                        BitmapUtil.saveBitmapToImage(bRB, 100, Bitmap.CompressFormat.JPEG, str, true);
                        iPCQRCodeRecognizeParam.kTQ = str;
                        if (bitmap == null || bitmap.isRecycled()) {
                            iPCQRCodeRecognizeParam.lCi = null;
                        } else {
                            BitmapUtil.saveBitmapToImage(bitmap, 100, Bitmap.CompressFormat.JPEG, z, true);
                            iPCQRCodeRecognizeParam.kTQ = z;
                            iPCQRCodeRecognizeParam.lCi = str;
                        }
                        if (bitmap != null && !bitmap.isRecycled()) {
                            Log.i("MicroMsg.JsApiShowImageOperateSheet", "bitmap recycle %s", bitmap);
                            bitmap.recycle();
                        }
                        if (bRB != null && !bRB.isRecycled()) {
                            bRB.recycle();
                        }
                    } catch (Exception e2) {
                        Log.w("MicroMsg.JsApiShowImageOperateSheet", "save temp bitmap to file failed, . exception : %s", e2);
                        if (bitmap != null && !bitmap.isRecycled()) {
                            Log.i("MicroMsg.JsApiShowImageOperateSheet", "bitmap recycle %s", bitmap);
                            bitmap.recycle();
                        }
                        if (bRB != null && !bRB.isRecycled()) {
                            bRB.recycle();
                        }
                    } catch (Throwable th) {
                        if (bitmap != null && !bitmap.isRecycled()) {
                            Log.i("MicroMsg.JsApiShowImageOperateSheet", "bitmap recycle %s", bitmap);
                            bitmap.recycle();
                        }
                        if (bRB != null && !bRB.isRecycled()) {
                            bRB.recycle();
                        }
                        AppMethodBeat.o(45664);
                        throw th;
                    }
                    com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, iPCQRCodeRecognizeParam, c.class, new com.tencent.mm.ipcinvoker.d<IPCQRCodeRecognizeResult>() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.AnonymousClass9.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.ipcinvoker.d
                        public final /* synthetic */ void bn(IPCQRCodeRecognizeResult iPCQRCodeRecognizeResult) {
                            AppMethodBeat.i(45663);
                            IPCQRCodeRecognizeResult iPCQRCodeRecognizeResult2 = iPCQRCodeRecognizeResult;
                            if (iPCQRCodeRecognizeResult2 == null) {
                                Log.w("MicroMsg.JsApiShowImageOperateSheet", "processRecognizeQRCodeLogic data null");
                                AppMethodBeat.o(45663);
                            } else if (!BottomSheetLogicHelper.lBK.contains(Integer.valueOf(iPCQRCodeRecognizeResult2.dFL))) {
                                Log.w("MicroMsg.JsApiShowImageOperateSheet", "processRecognizeQRCodeLogic codeType:%d not support", Integer.valueOf(iPCQRCodeRecognizeResult2.dFL));
                                AppMethodBeat.o(45663);
                            } else if (Util.isNullOrNil(iPCQRCodeRecognizeResult2.result)) {
                                Log.w("MicroMsg.JsApiShowImageOperateSheet", "processRecognizeQRCodeLogic result nil");
                                AppMethodBeat.o(45663);
                            } else {
                                BottomSheetLogicHelper.this.lBL = iPCQRCodeRecognizeResult2;
                                if (BottomSheetLogicHelper.this.lBM != null && BottomSheetLogicHelper.this.lBM.isShowing()) {
                                    BottomSheetLogicHelper.this.bEq();
                                }
                                AppMethodBeat.o(45663);
                            }
                        }
                    });
                    AppMethodBeat.o(45664);
                }
            });
            AppMethodBeat.o(45695);
        }

        static /* synthetic */ void e(BottomSheetLogicHelper bottomSheetLogicHelper) {
            AppMethodBeat.i(45696);
            bottomSheetLogicHelper.a(new c.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.AnonymousClass6 */

                @Override // com.tencent.mm.plugin.appbrand.utils.c.a
                public final void Wz(final String str) {
                    AppMethodBeat.i(45658);
                    Log.i("MicroMsg.JsApiShowImageOperateSheet", "sendToFriend path:%s", str);
                    if (Util.isNullOrNil(str)) {
                        AppMethodBeat.o(45658);
                    } else if (ImgUtil.isGif(str)) {
                        Log.i("MicroMsg.JsApiShowImageOperateSheet", "sendToFriend as emoji");
                        IPCSendToFriendEmojiRequest iPCSendToFriendEmojiRequest = new IPCSendToFriendEmojiRequest();
                        iPCSendToFriendEmojiRequest.lCj = str;
                        com.tencent.mm.plugin.appbrand.ipc.a.a(BottomSheetLogicHelper.this.lBN.getContext(), iPCSendToFriendEmojiRequest, (AppBrandProxyUIProcessTask.b) null);
                        AppMethodBeat.o(45658);
                    } else {
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.AnonymousClass6.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(45657);
                                Intent intent = new Intent();
                                intent.putExtra("Retr_File_Name", str);
                                intent.putExtra("Retr_Compress_Type", 0);
                                intent.putExtra("Retr_Msg_Type", 0);
                                com.tencent.mm.br.c.f(BottomSheetLogicHelper.this.lBN.getContext(), ".ui.transmit.MsgRetransmitUI", intent);
                                AppMethodBeat.o(45657);
                            }
                        });
                        AppMethodBeat.o(45658);
                    }
                }
            });
            AppMethodBeat.o(45696);
        }

        static /* synthetic */ void f(BottomSheetLogicHelper bottomSheetLogicHelper) {
            AppMethodBeat.i(45697);
            bottomSheetLogicHelper.a(new c.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.AnonymousClass7 */

                @Override // com.tencent.mm.plugin.appbrand.utils.c.a
                public final void Wz(String str) {
                    AppMethodBeat.i(45659);
                    Log.i("MicroMsg.JsApiShowImageOperateSheet", "saveToSDCard localPath:%s", str);
                    if (Util.isNullOrNil(str)) {
                        AppMethodBeat.o(45659);
                        return;
                    }
                    com.tencent.mm.pluginsdk.ui.tools.s.l(str, BottomSheetLogicHelper.this.lBN.getContext());
                    AppMethodBeat.o(45659);
                }
            });
            AppMethodBeat.o(45697);
        }

        static /* synthetic */ void g(BottomSheetLogicHelper bottomSheetLogicHelper) {
            AppMethodBeat.i(45698);
            bottomSheetLogicHelper.a(new c.a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.AnonymousClass8 */

                @Override // com.tencent.mm.plugin.appbrand.utils.c.a
                public final void Wz(String str) {
                    AppMethodBeat.i(45662);
                    Log.i("MicroMsg.JsApiShowImageOperateSheet", "fav localPath:%s", str);
                    if (Util.isNullOrNil(str)) {
                        AppMethodBeat.o(45662);
                        return;
                    }
                    com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, new IPCString(str), a.class, new com.tencent.mm.ipcinvoker.d<IPCInteger>() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.AnonymousClass8.AnonymousClass1 */

                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // com.tencent.mm.ipcinvoker.d
                        public final /* synthetic */ void bn(IPCInteger iPCInteger) {
                            AppMethodBeat.i(45661);
                            IPCInteger iPCInteger2 = iPCInteger;
                            if (iPCInteger2 == null) {
                                Log.e("MicroMsg.JsApiShowImageOperateSheet", "fav ipc callback data null");
                                AppMethodBeat.o(45661);
                                return;
                            }
                            int i2 = iPCInteger2.value;
                            Log.i("MicroMsg.JsApiShowImageOperateSheet", "fav result:%d", Integer.valueOf(i2));
                            final Context context = BottomSheetLogicHelper.this.lBN.getContext();
                            if (i2 == 0 && (context instanceof Activity)) {
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.AnonymousClass8.AnonymousClass1.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(45660);
                                        com.tencent.mm.ui.widget.snackbar.b.r((Activity) context, context.getString(R.string.caf));
                                        AppMethodBeat.o(45660);
                                    }
                                });
                            }
                            AppMethodBeat.o(45661);
                        }
                    });
                    AppMethodBeat.o(45662);
                }
            });
            AppMethodBeat.o(45698);
        }

        static /* synthetic */ void h(BottomSheetLogicHelper bottomSheetLogicHelper) {
            AppMethodBeat.i(45699);
            Log.i("MicroMsg.JsApiShowImageOperateSheet", "processQRCodeResultLogic");
            if (bottomSheetLogicHelper.lBL == null || Util.isNullOrNil(bottomSheetLogicHelper.lBL.result)) {
                Log.w("MicroMsg.JsApiShowImageOperateSheet", "processQRCodeResultLogic result nil");
                AppMethodBeat.o(45699);
                return;
            }
            IPCProcessQRCodeResultRequest iPCProcessQRCodeResultRequest = new IPCProcessQRCodeResultRequest();
            iPCProcessQRCodeResultRequest.lCa = bottomSheetLogicHelper.lBL;
            iPCProcessQRCodeResultRequest.appID = bottomSheetLogicHelper.lBN.getAppId();
            iPCProcessQRCodeResultRequest.pageUrl = bottomSheetLogicHelper.lBN.lBI;
            com.tencent.mm.plugin.appbrand.ipc.a.a(bottomSheetLogicHelper.lBN.getContext(), iPCProcessQRCodeResultRequest, (AppBrandProxyUIProcessTask.b) null);
            AppMethodBeat.o(45699);
        }
    }
}
