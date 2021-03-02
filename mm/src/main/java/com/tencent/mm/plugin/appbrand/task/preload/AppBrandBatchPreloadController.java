package com.tencent.mm.plugin.appbrand.task.preload;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.mn;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.appcache.predownload.c;
import com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.task.e;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandBatchPreloadController implements IAppBrandBatchPreloadController {
    private static final String TAG = "MicroMsg.Predownload.AppBrandBatchPreloadController";
    private int mBusinessScene = 0;
    private boolean mIsGameEnv = false;

    @Override // com.tencent.mm.plugin.appbrand.preload.IAppBrandBatchPreloadController
    public String preload(JSONObject jSONObject, boolean z) {
        float floatValue;
        float floatValue2;
        float floatValue3;
        AppMethodBeat.i(48494);
        this.mIsGameEnv = z;
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("openParams"));
            int optInt = jSONObject2.optInt("visitScene");
            this.mBusinessScene = jSONObject2.optInt("businessScene");
            int optInt2 = jSONObject2.optInt("innerScene");
            if (this.mBusinessScene == 0) {
                AppMethodBeat.o(48494);
                return "fail:mBusinessScene illegal";
            }
            JSONArray jSONArray = new JSONArray(jSONObject.optString("preloadList"));
            if (jSONArray.length() <= 0) {
                Log.w(TAG, "preloadList is empty");
                AppMethodBeat.o(48494);
                return "fail:preloadList is empty";
            }
            b.bWE();
            Map<Integer, Float> ew = b.ew(this.mBusinessScene, optInt2);
            if ((ew == null || ew.size() <= 0) && this.mBusinessScene != 1) {
                Log.e(TAG, "predictRate null businessScene:%d,innerScene:%d", Integer.valueOf(this.mBusinessScene), Integer.valueOf(optInt2));
                AppMethodBeat.o(48494);
                return "fail:mBusinessScene predictRate error!";
            }
            if (this.mBusinessScene == 1) {
                floatValue = 0.0f;
                if (ew == null || ew.size() <= 0) {
                    Log.e(TAG, "inner predictRate null businessScene:%d,innerScene:%d", Integer.valueOf(this.mBusinessScene), Integer.valueOf(optInt2));
                    floatValue3 = 1.0f;
                    floatValue2 = 1.0f;
                } else {
                    floatValue2 = ew.get(Integer.valueOf(c.MIDDLE_LEVEL.ordinal())).floatValue();
                    floatValue3 = ew.get(Integer.valueOf(c.HIGH_LEVEL.ordinal())).floatValue();
                }
            } else {
                floatValue = ew.get(Integer.valueOf(c.LOW_LEVEL.ordinal())).floatValue();
                floatValue2 = ew.get(Integer.valueOf(c.MIDDLE_LEVEL.ordinal())).floatValue();
                floatValue3 = ew.get(Integer.valueOf(c.HIGH_LEVEL.ordinal())).floatValue();
            }
            Log.i(TAG, "mVisitScene:%d,mBusinessScene:%d,mInnerScene:%d,mLowLevelRate:%f,middleLevelRate:%f,highLevelRate:%f", Integer.valueOf(optInt), Integer.valueOf(this.mBusinessScene), Integer.valueOf(optInt2), Float.valueOf(floatValue), Float.valueOf(floatValue2), Float.valueOf(floatValue3));
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                PreloadAppInfo preloadAppInfo = new PreloadAppInfo();
                preloadAppInfo.openRate = (float) optJSONObject.optDouble("openRate");
                preloadAppInfo.appId = optJSONObject.optString("appId");
                preloadAppInfo.appType = optJSONObject.optInt("appType");
                preloadAppInfo.path = optJSONObject.optString("path");
                mn mnVar = new mn();
                mnVar.fcC = (long) optInt;
                mnVar.fcD = (long) this.mBusinessScene;
                mnVar.fcE = (long) optInt2;
                mnVar.eJx = mnVar.x("AppId", preloadAppInfo.appId, true);
                mnVar.eYW = (long) preloadAppInfo.appType;
                mnVar.fcF = mnVar.x("openRate", String.valueOf(preloadAppInfo.openRate), true);
                mnVar.fbm = mnVar.x("path", preloadAppInfo.path, true);
                mnVar.bfK();
                if (preloadAppInfo.openRate < floatValue) {
                    Log.i(TAG, "preloadAppInfo.openRate:%f < mLowLevelRate:%f", Float.valueOf(preloadAppInfo.openRate), Float.valueOf(floatValue));
                } else {
                    arrayList.add(preloadAppInfo);
                }
            }
            if (arrayList.size() > 0) {
                Collections.sort(arrayList, new Comparator<PreloadAppInfo>() {
                    /* class com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
                    @Override // java.util.Comparator
                    public final /* synthetic */ int compare(PreloadAppInfo preloadAppInfo, PreloadAppInfo preloadAppInfo2) {
                        AppMethodBeat.i(48482);
                        int compareTo = Float.valueOf(preloadAppInfo2.openRate).compareTo(Float.valueOf(preloadAppInfo.openRate));
                        AppMethodBeat.o(48482);
                        return compareTo;
                    }
                });
                PreloadAppInfo preloadAppInfo2 = (PreloadAppInfo) arrayList.get(0);
                Log.i(TAG, "high preloadAppInfo openRate:%f,appid:%s", Float.valueOf(preloadAppInfo2.openRate), preloadAppInfo2.appId);
                if (preloadAppInfo2.openRate >= floatValue3) {
                    dealPreload(c.HIGH_LEVEL, preloadAppInfo2);
                } else if (preloadAppInfo2.openRate >= floatValue2) {
                    dealPreload(c.MIDDLE_LEVEL, preloadAppInfo2);
                } else {
                    dealPreload(c.LOW_LEVEL, preloadAppInfo2);
                }
            }
            AppMethodBeat.o(48494);
            return "ok";
        } catch (JSONException e2) {
            Log.e(TAG, "parse data error:%s", e2);
            AppMethodBeat.o(48494);
            return "fail:params error!";
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private void dealPreload(c cVar, PreloadAppInfo preloadAppInfo) {
        AppMethodBeat.i(48495);
        switch (cVar) {
            case LOW_LEVEL:
                preloadMiniProgramEnv(preloadAppInfo.appType, PRELOAD_ENV_LEVEL.LOW_LEVEL, true);
                AppMethodBeat.o(48495);
                return;
            case MIDDLE_LEVEL:
                preloadMiniProgramEnv(preloadAppInfo.appType, PRELOAD_ENV_LEVEL.MIDDLE_LEVEL, true);
                predownloadPlugins(preloadAppInfo);
                AppMethodBeat.o(48495);
                return;
            case HIGH_LEVEL:
                preloadMiniProgramEnv(preloadAppInfo.appType, PRELOAD_ENV_LEVEL.HIGH_LEVEL, true);
                predownloadAllPackages(preloadAppInfo);
                break;
        }
        AppMethodBeat.o(48495);
    }

    private void preloadMiniProgramEnv(int i2, PRELOAD_ENV_LEVEL preload_env_level, boolean z) {
        AppMethodBeat.i(48496);
        g gVar = g.NIL;
        if (i2 == 1004) {
            gVar = g.WAGAME;
        } else if (i2 == 1000) {
            gVar = g.WASERVICE;
        }
        if (this.mIsGameEnv && gVar == g.WAGAME) {
            XIPCInvoker.a(MainProcessIPCService.dkO, IPCVoid.hnE, a.class, null);
            AppMethodBeat.o(48496);
        } else if (e.l(gVar)) {
            final int iF = e.iF(gVar == g.WAGAME);
            h.INSTANCE.dN(iF, z.WXA_JSAPI_BATCH_PRELOAD.nMT);
            e.a(gVar, new e.b() {
                /* class com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.appbrand.task.e.b
                public final void onReady() {
                    AppMethodBeat.i(48483);
                    h.INSTANCE.dN(iF, z.WXA_JSAPI_BATCH_PRELOAD.nMU);
                    Log.i(AppBrandBatchPreloadController.TAG, "preloadMiniProgramEnv success");
                    AppMethodBeat.o(48483);
                }
            }, z);
            AppMethodBeat.o(48496);
        } else if (e.k(gVar)) {
            Log.i(TAG, "preloadMiniProgramEnv alreadyExist");
            AppMethodBeat.o(48496);
        } else {
            Log.i(TAG, "preloadMiniProgramEnv fail internal error");
            AppMethodBeat.o(48496);
        }
    }

    private void predownloadPlugins(PreloadAppInfo preloadAppInfo) {
        AppMethodBeat.i(48497);
        XIPCInvoker.a(MainProcessIPCService.dkO, new TaskParamsCallPredownload(preloadAppInfo.appId, preloadAppInfo.appType, preloadAppInfo.path, this.mBusinessScene, true), b.class, new d<IPCVoid>() {
            /* class com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController.AnonymousClass3 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCVoid iPCVoid) {
                AppMethodBeat.i(48484);
                Log.i(AppBrandBatchPreloadController.TAG, "predownloadPlugins success");
                AppMethodBeat.o(48484);
            }
        });
        AppMethodBeat.o(48497);
    }

    private void predownloadAllPackages(PreloadAppInfo preloadAppInfo) {
        AppMethodBeat.i(48498);
        XIPCInvoker.a(MainProcessIPCService.dkO, new TaskParamsCallPredownload(preloadAppInfo.appId, preloadAppInfo.appType, preloadAppInfo.path, this.mBusinessScene, false), b.class, new d<IPCVoid>() {
            /* class com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController.AnonymousClass4 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.mm.ipcinvoker.d
            public final /* synthetic */ void bn(IPCVoid iPCVoid) {
                AppMethodBeat.i(48485);
                Log.i(AppBrandBatchPreloadController.TAG, "predownloadAllPackages success");
                AppMethodBeat.o(48485);
            }
        });
        AppMethodBeat.o(48498);
    }

    public static class TaskParamsCallPredownload implements Parcelable {
        public static final Parcelable.Creator<TaskParamsCallPredownload> CREATOR = new Parcelable.Creator<TaskParamsCallPredownload>() {
            /* class com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController.TaskParamsCallPredownload.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ TaskParamsCallPredownload[] newArray(int i2) {
                return new TaskParamsCallPredownload[0];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ TaskParamsCallPredownload createFromParcel(Parcel parcel) {
                AppMethodBeat.i(48490);
                TaskParamsCallPredownload taskParamsCallPredownload = new TaskParamsCallPredownload(parcel);
                AppMethodBeat.o(48490);
                return taskParamsCallPredownload;
            }
        };
        String appId;
        int appType;
        boolean nQN;
        String path;
        int scene;

        public TaskParamsCallPredownload(String str, int i2, String str2, int i3, boolean z) {
            this.appId = str;
            this.appType = i2;
            this.path = str2;
            this.scene = i3;
            this.nQN = z;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(48491);
            parcel.writeString(this.appId);
            parcel.writeInt(this.appType);
            parcel.writeString(this.path);
            parcel.writeInt(this.scene);
            parcel.writeInt(this.nQN ? 1 : 0);
            AppMethodBeat.o(48491);
        }

        protected TaskParamsCallPredownload(Parcel parcel) {
            boolean z = true;
            AppMethodBeat.i(48492);
            this.appId = parcel.readString();
            this.appType = parcel.readInt();
            this.path = parcel.readString();
            this.scene = parcel.readInt();
            this.nQN = parcel.readInt() != 1 ? false : z;
            AppMethodBeat.o(48492);
        }

        static {
            AppMethodBeat.i(48493);
            AppMethodBeat.o(48493);
        }
    }

    /* access modifiers changed from: package-private */
    public static class b implements com.tencent.mm.ipcinvoker.b<TaskParamsCallPredownload, IPCVoid> {
        private b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(TaskParamsCallPredownload taskParamsCallPredownload, d<IPCVoid> dVar) {
            AppMethodBeat.i(48489);
            final TaskParamsCallPredownload taskParamsCallPredownload2 = taskParamsCallPredownload;
            if (taskParamsCallPredownload2 == null) {
                Log.e(AppBrandBatchPreloadController.TAG, "invoke in mm, NULL data");
                AppMethodBeat.o(48489);
                return;
            }
            MMHandlerThread.postToMainThread(new Runnable() {
                /* class com.tencent.mm.plugin.appbrand.task.preload.AppBrandBatchPreloadController.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(48488);
                    Log.d(AppBrandBatchPreloadController.TAG, "TaskCallPredownload path:%s,scene:%d,appid:%s,appType:%d,dealPluginOnly:%b", taskParamsCallPredownload2.path, Integer.valueOf(taskParamsCallPredownload2.scene), taskParamsCallPredownload2.appId, Integer.valueOf(taskParamsCallPredownload2.appType), Boolean.valueOf(taskParamsCallPredownload2.nQN));
                    new c(taskParamsCallPredownload2.path, taskParamsCallPredownload2.scene, taskParamsCallPredownload2.appId, taskParamsCallPredownload2.appType).s(true, taskParamsCallPredownload2.nQN);
                    AppMethodBeat.o(48488);
                }
            });
            dVar.bn(null);
            AppMethodBeat.o(48489);
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements com.tencent.mm.ipcinvoker.b<IPCVoid, IPCVoid> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public /* synthetic */ void invoke(IPCVoid iPCVoid, d<IPCVoid> dVar) {
            AppMethodBeat.i(48487);
            Log.i(AppBrandBatchPreloadController.TAG, "IPC_PreloadNextGame.invoke()");
            com.tencent.mm.plugin.appbrand.task.h.bWb().a(g.WAGAME, z.WXA_JSAPI_PRELOAD);
            AppMethodBeat.o(48487);
        }
    }
}
