package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.MMUserAvatarInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b;
import com.tencent.mm.plugin.appbrand.jsapi.auth.g;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.permission.a.b;
import com.tencent.mm.plugin.appbrand.r.e;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.widget.dialog.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.protocal.protobuf.cev;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.g.a.m;
import kotlin.x;
import org.apache.commons.b.g;
import org.json.JSONObject;

public final class JsApiOperateWXData extends i {
    public static final int CTRL_INDEX = 79;
    public static final String NAME = "operateWXData";
    private final m lGR = new m();

    public JsApiOperateWXData() {
        AppMethodBeat.i(174777);
        AppMethodBeat.o(174777);
    }

    @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.i
    public final void a(d dVar, JSONObject jSONObject, int i2, e eVar) {
        AppMethodBeat.i(226709);
        try {
            jSONObject.put("wxdataDequeueTimestamp", Util.nowMilliSecond());
            String string = jSONObject.getString("data");
            boolean optBoolean = jSONObject.optBoolean("isImportant");
            OperateWXDataTask operateWXDataTask = new OperateWXDataTask();
            operateWXDataTask.appId = dVar.getAppId();
            operateWXDataTask.lFR = "operateWXData";
            l OT = dVar.getRuntime().OT();
            if (OT != null) {
                operateWXDataTask.iOo = OT.leE.kNW;
            }
            operateWXDataTask.iLM = this.iLM;
            operateWXDataTask.lFN = this;
            operateWXDataTask.lFO = dVar;
            operateWXDataTask.lGT = string;
            operateWXDataTask.lHc = optBoolean;
            operateWXDataTask.lqe = i2;
            operateWXDataTask.lFP = eVar;
            operateWXDataTask.lGY = new HashMap();
            AppBrandStatObject TS = a.TS(operateWXDataTask.appId);
            if (TS != null) {
                operateWXDataTask.lBE = TS.scene;
            }
            if (dVar instanceof s) {
                operateWXDataTask.lGg = 1;
            } else if (dVar instanceof ac) {
                operateWXDataTask.lGg = 2;
            }
            int optInt = jSONObject.optInt("queueLength", -1);
            long optLong = jSONObject.optLong("wxdataQueueTimestamp", MAlarmHandler.NEXT_FIRE_INTERVAL);
            long optLong2 = jSONObject.optLong("wxdataDequeueTimestamp", MAlarmHandler.NEXT_FIRE_INTERVAL);
            operateWXDataTask.lHe = optInt;
            operateWXDataTask.lHf = optLong;
            operateWXDataTask.lHg = optLong2;
            operateWXDataTask.bDJ();
            AppBrandMainProcessService.a(operateWXDataTask);
            AppMethodBeat.o(226709);
        } catch (Exception e2) {
            Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "Exception %s", e2.getMessage());
            dVar.i(i2, h("fail", null));
            eVar.bEE();
            AppMethodBeat.o(226709);
        }
    }

    public static void clear(String str) {
        AppMethodBeat.i(46104);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(46104);
            return;
        }
        try {
            OperateWXDataTask.bEO();
            String[] allKeys = OperateWXDataTask.lGS.allKeys();
            if (allKeys == null) {
                AppMethodBeat.o(46104);
                return;
            }
            for (String str2 : allKeys) {
                if (!TextUtils.isEmpty(str2) && str2.startsWith(str)) {
                    OperateWXDataTask.lGS.remove(str2);
                }
            }
            AppMethodBeat.o(46104);
        } catch (Throwable th) {
            Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "clear(%s) e=%s", str, th);
            AppMethodBeat.o(46104);
        }
    }

    /* access modifiers changed from: package-private */
    public static class OperateWXDataTask extends MainProcessTask {
        public static final Parcelable.Creator<OperateWXDataTask> CREATOR = new Parcelable.Creator<OperateWXDataTask>() {
            /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.AnonymousClass4 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ OperateWXDataTask[] newArray(int i2) {
                return new OperateWXDataTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ OperateWXDataTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(180211);
                OperateWXDataTask operateWXDataTask = new OperateWXDataTask(parcel);
                AppMethodBeat.o(180211);
                return operateWXDataTask;
            }
        };
        private static final MultiProcessMMKV lGS = MultiProcessMMKV.getMMKV("MicroMsg.AppBrand.JsApiOperateWXData");
        public String appId;
        public int cgiErrorCode;
        private boolean iLM;
        public int iOo;
        int lBE;
        transient i lFN;
        transient d lFO;
        transient e lFP;
        public String lFR;
        public String lFS;
        public int lFT;
        public String lFU;
        public String lFV;
        public String lFW;
        public String lFX;
        public boolean lFY;
        public String lFZ;
        public String lGT;
        public String lGU;
        public String lGV;
        public int lGW;
        public String lGX;
        public Map<String, byte[]> lGY;
        public MMUserAvatarInfo lGZ;
        public String lGa = "";
        public String lGb = "";
        public int lGc;
        public String lGe;
        int lGg;
        int lHa;
        private boolean lHb;
        boolean lHc;
        private boolean lHd = false;
        transient int lHe;
        transient long lHf;
        transient long lHg;
        private long lHh;
        private long lHi;
        private long lHj = -1;
        private long lHk = -1;
        public int lqe;
        public String mAppName;

        public interface a {
            void a(LinkedList<drb> linkedList, String str, String str2);

            void bK(String str, int i2);

            void onSuccess(String str);
        }

        static /* synthetic */ boolean b(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.i(46095);
            boolean bDU = operateWXDataTask.bDU();
            AppMethodBeat.o(46095);
            return bDU;
        }

        static /* synthetic */ boolean c(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.i(46096);
            boolean bDU = operateWXDataTask.bDU();
            AppMethodBeat.o(46096);
            return bDU;
        }

        static /* synthetic */ boolean d(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.i(46097);
            boolean bDU = operateWXDataTask.bDU();
            AppMethodBeat.o(46097);
            return bDU;
        }

        static /* synthetic */ boolean e(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.i(46098);
            boolean bDU = operateWXDataTask.bDU();
            AppMethodBeat.o(46098);
            return bDU;
        }

        static /* synthetic */ boolean f(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.i(226707);
            boolean bDU = operateWXDataTask.bDU();
            AppMethodBeat.o(226707);
            return bDU;
        }

        static /* synthetic */ boolean g(OperateWXDataTask operateWXDataTask) {
            AppMethodBeat.i(46099);
            boolean bDU = operateWXDataTask.bDU();
            AppMethodBeat.o(46099);
            return bDU;
        }

        static void bEO() {
        }

        static {
            AppMethodBeat.i(46102);
            AppMethodBeat.o(46102);
        }

        public OperateWXDataTask() {
            AppMethodBeat.i(174776);
            AppMethodBeat.o(174776);
        }

        public OperateWXDataTask(Parcel parcel) {
            AppMethodBeat.i(46085);
            f(parcel);
            AppMethodBeat.o(46085);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(46086);
            if (this.lHd) {
                this.lHj = Util.nowMilliSecond();
            } else {
                this.lHh = Util.nowMilliSecond();
            }
            AnonymousClass1 r7 = new a() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.AnonymousClass1 */

                @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.a
                public final void onSuccess(String str) {
                    AppMethodBeat.i(46066);
                    Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSuccess !");
                    try {
                        OperateWXDataTask.this.lGV = g.a(new String[]{OperateWXDataTask.this.appId, new StringBuilder().append(OperateWXDataTask.this.lGg).toString(), new StringBuilder().append(OperateWXDataTask.this.lqe).toString(), new StringBuilder().append(Util.currentTicks()).toString()}, "$");
                        OperateWXDataTask.lGS.putString(OperateWXDataTask.this.lGV, str).commit();
                        if (TextUtils.isEmpty(OperateWXDataTask.lGS.getString(OperateWXDataTask.this.lGV, null))) {
                            IOException iOException = new IOException("write data failed");
                            AppMethodBeat.o(46066);
                            throw iOException;
                        }
                        JsApiOperateWXData.Bg(0);
                        if (TextUtils.isEmpty(OperateWXDataTask.this.lGV)) {
                            OperateWXDataTask.this.lGU = str;
                        }
                        OperateWXDataTask.this.lFS = "ok";
                        OperateWXDataTask.b(OperateWXDataTask.this);
                        AppMethodBeat.o(46066);
                    } catch (Throwable th) {
                        if (TextUtils.isEmpty(OperateWXDataTask.this.lGV)) {
                            OperateWXDataTask.this.lGU = str;
                        }
                        AppMethodBeat.o(46066);
                        throw th;
                    }
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.a
                public final void bK(String str, int i2) {
                    AppMethodBeat.i(226704);
                    Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "onFailure !");
                    OperateWXDataTask.this.lFS = "fail:".concat(String.valueOf(str));
                    OperateWXDataTask.this.cgiErrorCode = i2;
                    OperateWXDataTask.c(OperateWXDataTask.this);
                    AppMethodBeat.o(226704);
                }

                @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.a
                public final void a(LinkedList<drb> linkedList, String str, String str2) {
                    AppMethodBeat.i(46068);
                    Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "onConfirm !");
                    OperateWXDataTask.this.lGc = linkedList.size();
                    for (int i2 = 0; i2 < OperateWXDataTask.this.lGc; i2++) {
                        try {
                            OperateWXDataTask.this.lGY.put(String.valueOf(i2), linkedList.get(i2).toByteArray());
                        } catch (IOException e2) {
                            Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", e2.getMessage());
                            Log.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", e2, "", new Object[0]);
                            OperateWXDataTask.this.lFS = "fail";
                            OperateWXDataTask.d(OperateWXDataTask.this);
                            AppMethodBeat.o(46068);
                            return;
                        }
                    }
                    OperateWXDataTask.this.mAppName = str;
                    OperateWXDataTask.this.lFU = str2;
                    OperateWXDataTask.this.lFS = "needConfirm";
                    if (linkedList.size() > 0) {
                        drb drb = linkedList.get(0);
                        OperateWXDataTask.this.lGe = drb.MTJ == null ? "" : drb.MTJ;
                        if ("scope.userInfo".equals(drb.KWK)) {
                            OperateWXDataTask.this.lGb = z.aUa();
                            Log.i("MicroMsg.AppBrand.JsApiOperateWXData", "userNickName=" + (OperateWXDataTask.this.lGb == null ? "" : OperateWXDataTask.this.lGb));
                            String aTY = z.aTY();
                            g.a aVar = g.lFD;
                            g.a.a(aTY, new g.b() {
                                /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.AnonymousClass1.AnonymousClass1 */

                                @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.g.b
                                public final void UI(String str) {
                                    AppMethodBeat.i(46065);
                                    OperateWXDataTask.this.lGa = str;
                                    OperateWXDataTask.e(OperateWXDataTask.this);
                                    AppMethodBeat.o(46065);
                                }
                            });
                            AppMethodBeat.o(46068);
                            return;
                        }
                        OperateWXDataTask.f(OperateWXDataTask.this);
                        AppMethodBeat.o(46068);
                        return;
                    }
                    OperateWXDataTask.g(OperateWXDataTask.this);
                    AppMethodBeat.o(46068);
                }
            };
            if (this.lFR.equals("operateWXData")) {
                a(this.appId, this.lGT, "", this.iOo, this.lFT, 0, r7, this.lHc);
                AppMethodBeat.o(46086);
                return;
            }
            if (this.lFR.equals("operateWXDataConfirm")) {
                a(this.appId, this.lGT, this.lGX, this.iOo, this.lFT, this.lGW, r7, this.lHc);
            }
            AppMethodBeat.o(46086);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void hg(boolean z) {
            AppMethodBeat.i(46087);
            super.hg(z);
            JsApiOperateWXData.Bg(z ? 4 : 5);
            AppMethodBeat.o(46087);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(46088);
            bDK();
            if (!this.lFO.isRunning()) {
                this.lFP.bEE();
                AppMethodBeat.o(46088);
            } else if (this.lFS.equals("ok")) {
                HashMap hashMap = new HashMap();
                String str = this.lGU;
                if (!TextUtils.isEmpty(this.lGV)) {
                    try {
                        str = lGS.getString(this.lGV, "");
                        lGS.remove(this.lGV);
                        JsApiOperateWXData.Bg(2);
                    } catch (Throwable th) {
                        Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "runInClientProcess loginResult ok, get data from XProcessStore failed, appId[%s], callbackId[%d], e=%s", this.appId, Integer.valueOf(this.lqe), th);
                        JsApiOperateWXData.Bg(3);
                    }
                }
                hashMap.put("data", str);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("isConfirm", Boolean.valueOf(this.lHd));
                hashMap2.put("queueLength", Integer.valueOf(this.lHe));
                hashMap2.put("wxdataQueueTimestamp", Long.valueOf(this.lHf));
                hashMap2.put("wxdataDequeueTimestamp", Long.valueOf(this.lHg));
                hashMap2.put("beginCGITimestamp", Long.valueOf(this.lHh));
                hashMap2.put("CGICallbackTimestamp", Long.valueOf(this.lHi));
                hashMap2.put("beginCGITimestampAfterConfirm", Long.valueOf(this.lHj));
                hashMap2.put("CGICallbackTimestampAfterConfirm", Long.valueOf(this.lHk));
                hashMap2.put("wxlibCallbackTimestamp", Long.valueOf(Util.nowMilliSecond()));
                hashMap.put("clientInfo", hashMap2);
                String n = this.lFN.n("ok", hashMap);
                Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "callback data:%s", n);
                this.lFO.i(this.lqe, n);
                this.lFP.bEE();
                AppMethodBeat.o(46088);
            } else if (this.lFS.contains("fail")) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("err_code", String.valueOf(this.cgiErrorCode));
                this.lFO.i(this.lqe, this.lFN.n(this.lFS, hashMap3));
                this.lFP.bEE();
                AppMethodBeat.o(46088);
            } else {
                if (this.lFS.equals("needConfirm")) {
                    final LinkedList linkedList = new LinkedList();
                    for (int i2 = 0; i2 < this.lGc; i2++) {
                        byte[] bArr = this.lGY.get(String.valueOf(i2));
                        drb drb = new drb();
                        try {
                            drb.parseFrom(bArr);
                            linkedList.add(drb);
                        } catch (IOException e2) {
                            Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "IOException %s", e2.getMessage());
                            Log.printErrStackTrace("MicroMsg.AppBrand.JsApiOperateWXData", e2, "", new Object[0]);
                            this.lFN.b(this.lFO, this.lqe, "fail");
                            this.lFP.bEE();
                            AppMethodBeat.o(46088);
                            return;
                        }
                    }
                    if (linkedList.size() > 0) {
                        this.lFO.P(new Runnable() {
                            /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(180209);
                                drb drb = (drb) linkedList.getFirst();
                                final b a2 = b.a.a(OperateWXDataTask.this.lFO, new h.b() {
                                    /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.AnonymousClass2.AnonymousClass1 */

                                    @Override // com.tencent.mm.plugin.appbrand.permission.a.b.c
                                    public final void a(int i2, ArrayList<String> arrayList, int i3) {
                                        AppMethodBeat.i(180203);
                                        Log.i("MicroMsg.AppBrand.JsApiOperateWXData", "stev onRevMsg resultCode %d", Integer.valueOf(i2));
                                        switch (i2) {
                                            case 1:
                                            case 2:
                                                OperateWXDataTask.this.lFR = "operateWXDataConfirm";
                                                OperateWXDataTask.this.lGX = arrayList.size() > 0 ? arrayList.get(0) : "";
                                                OperateWXDataTask.this.lFT = i2;
                                                OperateWXDataTask.this.lGW = i3;
                                                AppBrandMainProcessService.a(OperateWXDataTask.this);
                                                if (i2 == 2) {
                                                    OperateWXDataTask.this.lFN.b(OperateWXDataTask.this.lFO, OperateWXDataTask.this.lqe, "fail auth deny");
                                                    OperateWXDataTask.this.lFP.bEE();
                                                    AppMethodBeat.o(180203);
                                                    return;
                                                }
                                                break;
                                            default:
                                                Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "press back button!");
                                                OperateWXDataTask.this.lFN.b(OperateWXDataTask.this.lFO, OperateWXDataTask.this.lqe, "fail auth cancel");
                                                OperateWXDataTask.this.lFP.bEE();
                                                break;
                                        }
                                        AppMethodBeat.o(180203);
                                    }
                                });
                                a2.setAppBrandName(OperateWXDataTask.this.mAppName);
                                a2.setRequestDesc(drb.Desc);
                                a2.setApplyWording(OperateWXDataTask.this.lFV);
                                a2.setNegativeButtonText(OperateWXDataTask.this.lFW);
                                a2.setPositiveButtonText(OperateWXDataTask.this.lFX);
                                a2.setIconUrl(OperateWXDataTask.this.lFU);
                                if (!OperateWXDataTask.this.lFY || TextUtils.isEmpty(OperateWXDataTask.this.lFZ)) {
                                    a2.ia(false);
                                } else {
                                    a2.ia(true);
                                    a2.setExplainOnClickListener(new View.OnClickListener() {
                                        /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.AnonymousClass2.AnonymousClass2 */

                                        public final void onClick(View view) {
                                            AppMethodBeat.i(180204);
                                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                            bVar.bm(view);
                                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXData$OperateWXDataTask$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                            a2.a(OperateWXDataTask.this.lFO, OperateWXDataTask.this.lFZ, (ag) OperateWXDataTask.this.lFO.M(ag.class)).h(OperateWXDataTask.this.lFO);
                                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXData$OperateWXDataTask$2$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(180204);
                                        }
                                    });
                                }
                                if (!TextUtils.isEmpty(OperateWXDataTask.this.lGe)) {
                                    a2.setSimpleDetailDesc(OperateWXDataTask.this.lGe);
                                }
                                if (!"scope.userInfo".equals(drb.KWK)) {
                                    a2.setScope(drb.KWK);
                                } else if (OperateWXDataTask.this.lGZ != null) {
                                    final com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b bVar = new com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b(OperateWXDataTask.this.lFO.getContext(), OperateWXDataTask.this.lGZ, drb.KWK, new b.c() {
                                        /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.AnonymousClass2.AnonymousClass3 */

                                        @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c
                                        public final void a(boolean z, boolean z2, String str, String str2, m<? super Activity, ? super String, x> mVar) {
                                            AppMethodBeat.i(180205);
                                            if (z || z2) {
                                                if (!z) {
                                                    a2.setFunctionButtonText(str);
                                                    a2.setFunctionButtonTextColor(OperateWXDataTask.this.lFO.getContext().getResources().getColor(R.color.BW_0_Alpha_0_3));
                                                } else {
                                                    a2.setFunctionButtonText("");
                                                }
                                                OperateWXDataTask.a(OperateWXDataTask.this, a2, false, mVar);
                                                AppMethodBeat.o(180205);
                                                return;
                                            }
                                            a2.setFunctionButtonText(str2);
                                            a2.setFunctionButtonTextColor(OperateWXDataTask.this.lFO.getContext().getResources().getColor(R.color.x0));
                                            OperateWXDataTask.a(OperateWXDataTask.this, a2, true, mVar);
                                            AppMethodBeat.o(180205);
                                        }

                                        @Override // com.tencent.mm.plugin.appbrand.jsapi.auth.entity.b.c
                                        public final void bz(List<i.a> list) {
                                            AppMethodBeat.i(180206);
                                            a2.setSelectListItem(list);
                                            AppMethodBeat.o(180206);
                                        }
                                    });
                                    a2.setItemCheckedListener(new i.b() {
                                        /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.AnonymousClass2.AnonymousClass4 */

                                        @Override // com.tencent.mm.plugin.appbrand.widget.dialog.i.b
                                        public final void a(i.a aVar) {
                                            AppMethodBeat.i(226705);
                                            bVar.b(aVar);
                                            AppMethodBeat.o(226705);
                                        }
                                    });
                                    a2.setOnListItemLongClickListener(new i.d() {
                                        /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.AnonymousClass2.AnonymousClass5 */

                                        @Override // com.tencent.mm.plugin.appbrand.widget.dialog.i.d
                                        public final void a(View view, i.a aVar, int i2) {
                                            int i3 = 0;
                                            AppMethodBeat.i(226706);
                                            MotionEvent lastPointerDownTouchEvent = a2.getLastPointerDownTouchEvent();
                                            int round = lastPointerDownTouchEvent == null ? 0 : Math.round(lastPointerDownTouchEvent.getRawX());
                                            if (lastPointerDownTouchEvent != null) {
                                                i3 = Math.round(lastPointerDownTouchEvent.getRawY());
                                            }
                                            bVar.a(view, i2, round, i3);
                                            AppMethodBeat.o(226706);
                                        }
                                    });
                                } else {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(new i.a(OperateWXDataTask.this.lGb, OperateWXDataTask.this.lFO.getContext().getResources().getString(R.string.a0j), drb.KWK, e.Mq(OperateWXDataTask.this.lGa), (byte) 0));
                                    a2.setSelectListItem(arrayList);
                                }
                                a2.h(OperateWXDataTask.this.lFO);
                                AppMethodBeat.o(180209);
                            }
                        });
                        AppMethodBeat.o(46088);
                        return;
                    }
                    this.lFN.b(this.lFO, this.lqe, "fail");
                    this.lFP.bEE();
                }
                AppMethodBeat.o(46088);
            }
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4 = true;
            AppMethodBeat.i(46090);
            this.appId = parcel.readString();
            this.lFS = parcel.readString();
            this.mAppName = parcel.readString();
            this.lFU = parcel.readString();
            this.lGT = parcel.readString();
            this.lGU = parcel.readString();
            this.lGV = parcel.readString();
            this.lqe = parcel.readInt();
            this.lFR = parcel.readString();
            this.lGX = parcel.readString();
            this.lGc = parcel.readInt();
            this.lGY = parcel.readHashMap(HashMap.class.getClassLoader());
            this.iOo = parcel.readInt();
            this.lFT = parcel.readInt();
            this.lBE = parcel.readInt();
            this.lGg = parcel.readInt();
            this.lGb = parcel.readString();
            this.lGa = parcel.readString();
            this.lFX = parcel.readString();
            this.lFW = parcel.readString();
            this.lFV = parcel.readString();
            this.lGZ = (MMUserAvatarInfo) parcel.readParcelable(MMUserAvatarInfo.class.getClassLoader());
            this.lHa = parcel.readInt();
            this.lHb = parcel.readInt() == 1;
            this.lGW = parcel.readInt();
            if (parcel.readInt() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.lHc = z;
            if (parcel.readInt() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.lFY = z2;
            this.lFZ = parcel.readString();
            this.lGe = parcel.readString();
            this.cgiErrorCode = parcel.readInt();
            this.lHh = parcel.readLong();
            this.lHi = parcel.readLong();
            this.lHj = parcel.readLong();
            this.lHk = parcel.readLong();
            if (parcel.readInt() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.lHd = z3;
            if (parcel.readInt() <= 0) {
                z4 = false;
            }
            this.iLM = z4;
            AppMethodBeat.o(46090);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            int i3;
            int i4;
            int i5;
            int i6 = 1;
            AppMethodBeat.i(46091);
            parcel.writeString(this.appId);
            parcel.writeString(this.lFS);
            parcel.writeString(this.mAppName);
            parcel.writeString(this.lFU);
            parcel.writeString(this.lGT);
            parcel.writeString(this.lGU);
            parcel.writeString(this.lGV);
            parcel.writeInt(this.lqe);
            parcel.writeString(this.lFR);
            parcel.writeString(this.lGX);
            parcel.writeInt(this.lGc);
            parcel.writeMap(this.lGY);
            parcel.writeInt(this.iOo);
            parcel.writeInt(this.lFT);
            parcel.writeInt(this.lBE);
            parcel.writeInt(this.lGg);
            parcel.writeString(this.lGb);
            parcel.writeString(this.lGa);
            parcel.writeString(this.lFX);
            parcel.writeString(this.lFW);
            parcel.writeString(this.lFV);
            parcel.writeParcelable(this.lGZ, i2);
            parcel.writeInt(this.lHa);
            parcel.writeInt(this.lHb ? 1 : 0);
            parcel.writeInt(this.lGW);
            if (this.lHc) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            parcel.writeInt(i3);
            if (this.lFY) {
                i4 = 1;
            } else {
                i4 = 0;
            }
            parcel.writeInt(i4);
            parcel.writeString(this.lFZ);
            parcel.writeString(this.lGe);
            parcel.writeInt(this.cgiErrorCode);
            parcel.writeLong(this.lHh);
            parcel.writeLong(this.lHi);
            parcel.writeLong(this.lHj);
            parcel.writeLong(this.lHk);
            if (this.lHd) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            parcel.writeInt(i5);
            if (!this.iLM) {
                i6 = 0;
            }
            parcel.writeInt(i6);
            AppMethodBeat.o(46091);
        }

        private void a(String str, final String str2, String str3, int i2, int i3, int i4, final a aVar, boolean z) {
            com.tencent.mm.plugin.appbrand.r.e dVar;
            AppMethodBeat.i(46092);
            if (!z) {
                Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateWxData");
                dVar = new com.tencent.mm.plugin.appbrand.r.e(str, str2, str3, i2, i4, i3, this.lBE, this.iLM, new e.a<com.tencent.mm.plugin.appbrand.r.e>() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.AnonymousClass5 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
                    @Override // com.tencent.mm.plugin.appbrand.r.e.a
                    public final /* bridge */ /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.plugin.appbrand.r.e eVar) {
                        AppMethodBeat.i(180212);
                        OperateWXDataTask.this.a(i2, i3, str, eVar, str2, aVar);
                        AppMethodBeat.o(180212);
                    }
                });
            } else {
                Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "scene: OperateImportantWxData");
                dVar = new com.tencent.mm.plugin.appbrand.r.d(str, str2, str3, i2, i4, i3, this.lBE, new e.a<com.tencent.mm.plugin.appbrand.r.e>() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.AnonymousClass6 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.ak.q] */
                    @Override // com.tencent.mm.plugin.appbrand.r.e.a
                    public final /* bridge */ /* synthetic */ void a(int i2, int i3, String str, com.tencent.mm.plugin.appbrand.r.e eVar) {
                        AppMethodBeat.i(46083);
                        OperateWXDataTask.this.a(i2, i3, str, eVar, str2, aVar);
                        AppMethodBeat.o(46083);
                    }
                });
            }
            dVar.yB(this.lGg);
            com.tencent.mm.kernel.g.azz().a(dVar, 0);
            AppMethodBeat.o(46092);
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2, int i3, String str, com.tencent.mm.plugin.appbrand.r.e eVar, String str2, a aVar) {
            cev cev;
            AppMethodBeat.i(46093);
            Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (this.lHd) {
                this.lHk = Util.nowMilliSecond();
            } else {
                this.lHi = Util.nowMilliSecond();
            }
            if (i2 == 0 && i3 == 0) {
                if (eVar != null) {
                    if (this.lFT == 2) {
                        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "press reject button");
                        AppMethodBeat.o(46093);
                        return;
                    }
                    if (eVar.rr == null) {
                        cev = null;
                    } else {
                        cev = (cev) eVar.rr.iLL.iLR;
                    }
                    if (cev.Mkb == null) {
                        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "JsApiBaseResponse is null, enterData:".concat(String.valueOf(str2)));
                        aVar.bK("cgi fail response null", 0);
                        AppMethodBeat.o(46093);
                        return;
                    }
                    int i4 = cev.Mkb.dIZ;
                    String str3 = cev.Mkb.dJa;
                    drb drb = cev.Mkq;
                    LinkedList<drb> linkedList = new LinkedList<>();
                    if (drb != null) {
                        linkedList.add(drb);
                    }
                    String str4 = cev.xMq;
                    String str5 = cev.KFs;
                    Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "stev NetSceneJSOperateWxData jsErrcode %d", Integer.valueOf(i4));
                    if (i4 == -12000) {
                        this.lHd = true;
                        this.lFV = cev.Mkg;
                        this.lFX = cev.Mkf;
                        this.lFW = cev.Mke;
                        if (cev.Mkh != null) {
                            this.lFY = cev.Mkh.KHU;
                            this.lFZ = cev.Mkh.KHV;
                        }
                        if (cev.Mkt != null) {
                            this.lGZ = new MMUserAvatarInfo(cev.Mkt);
                        }
                        aVar.a(linkedList, str4, str5);
                        AppMethodBeat.o(46093);
                        return;
                    } else if (i4 != 0) {
                        Log.e("MicroMsg.AppBrand.JsApiOperateWXData", "onSceneEnd NetSceneJSOperateWxData Failed %s", str3);
                        aVar.bK(str3, i4);
                    } else if (cev.oTm == null) {
                        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "Data is null, enterData:".concat(String.valueOf(str2)));
                        aVar.bK("internal error", i4);
                        AppMethodBeat.o(46093);
                        return;
                    } else {
                        String yO = cev.oTm.yO();
                        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "resp data %s", yO);
                        aVar.onSuccess(yO);
                        AppMethodBeat.o(46093);
                        return;
                    }
                }
                AppMethodBeat.o(46093);
                return;
            }
            aVar.bK(String.format("cgi fail(%d,%d)", Integer.valueOf(i2), Integer.valueOf(i3)), 0);
            AppMethodBeat.o(46093);
        }

        static /* synthetic */ void a(OperateWXDataTask operateWXDataTask, com.tencent.mm.plugin.appbrand.permission.a.b bVar, boolean z, final m mVar) {
            AppMethodBeat.i(226708);
            if (!z) {
                bVar.setFunctionButtonOnClickListener(null);
                AppMethodBeat.o(226708);
                return;
            }
            bVar.setFunctionButtonOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData.OperateWXDataTask.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(180210);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXData$OperateWXDataTask$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    mVar.invoke(i.b(OperateWXDataTask.this.lFO), OperateWXDataTask.this.appId);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXData$OperateWXDataTask$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(180210);
                }
            });
            AppMethodBeat.o(226708);
        }
    }

    static /* synthetic */ void Bg(long j2) {
        AppMethodBeat.i(226710);
        Log.d("MicroMsg.AppBrand.JsApiOperateWXData", "idkeyStat [%d -> %d]", 1063L, Long.valueOf(j2));
        com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1063, j2, 1, false);
        AppMethodBeat.o(226710);
    }
}
