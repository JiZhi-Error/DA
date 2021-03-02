package com.tencent.matrix.d.b;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.g.a;
import com.tencent.matrix.g.b;
import com.tencent.matrix.g.c;
import com.tencent.matrix.report.d;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.sqlitelint.config.SharePluginInfo;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a implements d.a {
    public static long cVA = 0;
    public static long cVB = 0;
    public static int cVC = 0;
    private final com.tencent.matrix.d.a.a cVD;
    public long cVE;
    public int cVF;
    private String cVG;
    public HashMap<Integer, Long> cVH;
    public final Runnable cVI = new Runnable() {
        /* class com.tencent.matrix.d.b.a.AnonymousClass1 */

        public final void run() {
            a.a(a.this, false, 0);
        }
    };
    private final Runnable cVJ = new Runnable() {
        /* class com.tencent.matrix.d.b.a.AnonymousClass2 */

        public final void run() {
            a.a(a.this, false, 0);
        }
    };
    public final Application.ActivityLifecycleCallbacks cVK = new Application.ActivityLifecycleCallbacks() {
        /* class com.tencent.matrix.d.b.a.AnonymousClass3 */

        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public final void onActivityStarted(Activity activity) {
        }

        public final void onActivityResumed(Activity activity) {
            a.a(a.this, activity);
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }
    };
    public final ComponentCallbacks2 cVL = new ComponentCallbacks2() {
        /* class com.tencent.matrix.d.b.a.AnonymousClass4 */

        public final void onTrimMemory(final int i2) {
            switch (i2) {
                case 15:
                case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*{ENCODED_INT: 80}*/:
                    long bn = com.tencent.matrix.g.a.bn(a.this.mContext);
                    long bk = com.tencent.matrix.g.a.bk(a.this.mContext);
                    if (bn >= 2 * bk) {
                        c.i("Matrix.MemoryCanaryCore", "onTrimMemory level:%d, but memFree > 2*threshold, memFree:%d, threshold:%d", Integer.valueOf(i2), Long.valueOf(bn), Long.valueOf(bk));
                        return;
                    }
                    a.this.mHandler.post(new Runnable() {
                        /* class com.tencent.matrix.d.b.a.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            a.a(a.this, true, i2);
                        }
                    });
                    return;
                default:
                    return;
            }
        }

        public final void onConfigurationChanged(Configuration configuration) {
        }

        public final void onLowMemory() {
            a.this.mHandler.post(new Runnable() {
                /* class com.tencent.matrix.d.b.a.AnonymousClass4.AnonymousClass2 */

                public final void run() {
                    a.a(a.this, true, 3);
                }
            });
        }
    };
    private final com.tencent.matrix.d.a cVy;
    public a.EnumC0223a cVz;
    public final Context mContext;
    public final Handler mHandler = new Handler(b.TP().getLooper());
    private boolean mIsForeground = true;
    public boolean mIsOpen = false;
    public long mStartTime;

    static /* synthetic */ void a(a aVar, boolean z, int i2) {
        int i3 = 1;
        if (!aVar.mIsOpen) {
            return;
        }
        if (!z) {
            long dalvikHeap = com.tencent.matrix.g.a.getDalvikHeap();
            long nativeHeap = com.tencent.matrix.g.a.getNativeHeap();
            c.d("Matrix.MemoryCanaryCore", "current dalvik heap:" + dalvikHeap + ", native heap:" + nativeHeap, new Object[0]);
            if (((double) dalvikHeap) / ((double) cVC) >= ((double) aVar.cVD.getThreshold())) {
                aVar.iq(1);
            } else if (((double) nativeHeap) / 512000.0d >= ((double) aVar.cVD.getThreshold())) {
                aVar.iq(2);
            } else if (((double) com.tencent.matrix.g.a.TN()) / 4194304.0d >= ((double) aVar.cVD.getThreshold())) {
                aVar.iq(4);
            } else if (System.currentTimeMillis() >= aVar.cVE) {
                com.tencent.matrix.report.c cVar = new com.tencent.matrix.report.c();
                cVar.tag = aVar.cVy.getTag();
                cVar.type = 2;
                JSONObject jSONObject = new JSONObject();
                cVar.cWe = jSONObject;
                try {
                    if (System.currentTimeMillis() - aVar.mStartTime < 0) {
                        c.e("Matrix.MemoryCanaryCore", "wrong time, curr:%d, start:%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(aVar.mStartTime));
                        return;
                    }
                    jSONObject.put("span", ((int) (System.currentTimeMillis() - aVar.mStartTime)) / 60000);
                    long currentTimeMillis = System.currentTimeMillis();
                    Debug.MemoryInfo bo = com.tencent.matrix.g.a.bo(aVar.mContext);
                    if (bo != null) {
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        c.i("Matrix.MemoryCanaryCore", "get app memory cost:".concat(String.valueOf(currentTimeMillis2)), new Object[0]);
                        if (currentTimeMillis2 > 3000) {
                            aVar.mIsOpen = false;
                            return;
                        }
                        C0221a aVar2 = new C0221a(aVar.cVG);
                        aVar.a(bo, aVar2);
                        a(jSONObject, aVar2, "appmem", aVar.cVG);
                        if (!aVar.mIsForeground) {
                            i3 = 0;
                        }
                        jSONObject.put("front", i3);
                    }
                    aVar.onDetectIssue(cVar);
                    aVar.cVF++;
                    long min = Math.min(aVar.SM(), 1800000L);
                    aVar.cVE = (System.currentTimeMillis() + min) - 5000;
                    aVar.mHandler.removeCallbacks(aVar.cVI);
                    aVar.mHandler.postDelayed(aVar.cVI, min);
                } catch (Exception e2) {
                    c.e("Matrix.MemoryCanaryCore", "normal info json exception:" + e2.toString(), new Object[0]);
                }
            }
        } else {
            aVar.iq(i2);
        }
    }

    /* renamed from: com.tencent.matrix.d.b.a$a  reason: collision with other inner class name */
    public static class C0221a {
        public int cVP = -1;
        public int cVQ = -1;
        public int cVR = -1;
        public int cVS = -1;
        public int cVT = -1;
        public int cVU = -1;
        public int cVV = -1;
        public int cVW = -1;
        public int cVX = -1;
        public int cVY = -1;
        public String cVZ;

        C0221a(String str) {
            this.cVZ = str;
        }
    }

    public a(com.tencent.matrix.d.a aVar) {
        this.cVy = aVar;
        this.mContext = aVar.getApplication();
        this.cVD = aVar.cVv;
    }

    @Override // com.tencent.matrix.report.d.a
    public final void onDetectIssue(com.tencent.matrix.report.c cVar) {
        c.i("Matrix.MemoryCanaryCore", "detected memory json:" + cVar.cWe.toString(), new Object[0]);
        this.cVy.onDetectIssue(cVar);
    }

    private void iq(int i2) {
        if (i2 != 0) {
            if (!this.cVH.containsKey(Integer.valueOf(i2)) || System.currentTimeMillis() - this.cVH.get(Integer.valueOf(i2)).longValue() >= 600000) {
                long currentTimeMillis = System.currentTimeMillis();
                Debug.MemoryInfo bo = com.tencent.matrix.g.a.bo(this.mContext);
                if (bo != null) {
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    c.i("Matrix.MemoryCanaryCore", "get app memory cost:".concat(String.valueOf(currentTimeMillis2)), new Object[0]);
                    if (currentTimeMillis2 > 3000) {
                        this.mIsOpen = false;
                        return;
                    }
                    C0221a aVar = new C0221a(this.cVG);
                    a(bo, aVar);
                    com.tencent.matrix.report.c cVar = new com.tencent.matrix.report.c();
                    cVar.tag = this.cVy.getTag();
                    cVar.type = 1;
                    JSONObject jSONObject = new JSONObject();
                    cVar.cWe = jSONObject;
                    try {
                        jSONObject.put("sysMem", cVA);
                        jSONObject.put("threshold", cVB);
                        jSONObject.put("memClass", cVC);
                        jSONObject.put("available", com.tencent.matrix.g.a.TK());
                        a(jSONObject, aVar, "appmem", this.cVG);
                        jSONObject.put("front", this.mIsForeground ? 1 : 0);
                        jSONObject.put("trimFlag", i2);
                        jSONObject.put("memfree", com.tencent.matrix.g.a.bn(this.mContext));
                        jSONObject.put("islow", com.tencent.matrix.g.a.bm(this.mContext));
                        this.cVH.put(Integer.valueOf(i2), Long.valueOf(System.currentTimeMillis()));
                        onDetectIssue(cVar);
                    } catch (Exception e2) {
                        c.e("Matrix.MemoryCanaryCore", "trim memory json exception:" + e2.toString(), new Object[0]);
                    }
                }
            } else {
                c.w("Matrix.MemoryCanaryCore", "trim memory too freq activity:%s, flag:%d", this.cVG, Integer.valueOf(i2));
            }
        }
    }

    private static void a(JSONObject jSONObject, C0221a aVar, String str, String str2) {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("pss", aVar.cVX);
        jSONObject2.put("uss", aVar.cVY);
        jSONObject2.put("java", aVar.cVR);
        jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, aVar.cVS);
        jSONObject2.put("graphics", aVar.cVT);
        jSONObject2.put(SharePluginInfo.ISSUE_KEY_STACK, aVar.cVU);
        jSONObject2.put(TMQQDownloaderOpenSDKConst.UINTYPE_CODE, aVar.cVV);
        jSONObject2.put(FacebookRequestErrorClassification.KEY_OTHER, aVar.cVW);
        jSONObject2.put("dalvikHeap", aVar.cVP);
        jSONObject2.put("nativeHeap", aVar.cVQ);
        jSONObject2.put("vmsize", com.tencent.matrix.g.a.TN());
        if (str2 != null && !str2.isEmpty()) {
            jSONObject2.put(EnvConsts.ACTIVITY_MANAGER_SRVNAME, str2);
        }
        jSONObject.put(str, jSONObject2);
    }

    public static boolean SL() {
        return Build.VERSION.SDK_INT >= 23;
    }

    private void a(Debug.MemoryInfo memoryInfo, C0221a aVar) {
        aVar.cVR = com.tencent.matrix.d.c.a.a("summary.java-heap", memoryInfo);
        if (aVar.cVR != -1) {
            aVar.cVS = com.tencent.matrix.d.c.a.a("summary.native-heap", memoryInfo);
            if (aVar.cVS != -1) {
                aVar.cVV = com.tencent.matrix.d.c.a.a("summary.code", memoryInfo);
                if (aVar.cVV != -1) {
                    aVar.cVU = com.tencent.matrix.d.c.a.a("summary.stack", memoryInfo);
                    if (aVar.cVU != -1) {
                        aVar.cVT = com.tencent.matrix.d.c.a.a("summary.graphics", memoryInfo);
                        if (aVar.cVT != -1) {
                            aVar.cVW = com.tencent.matrix.d.c.a.a("summary.private-other", memoryInfo);
                            if (aVar.cVW != -1) {
                                aVar.cVX = com.tencent.matrix.d.c.a.a("summary.total-pss", memoryInfo);
                                if (aVar.cVX != -1) {
                                    aVar.cVY = com.tencent.matrix.d.c.a.a(memoryInfo);
                                    aVar.cVP = (int) com.tencent.matrix.g.a.getDalvikHeap();
                                    aVar.cVQ = (int) com.tencent.matrix.g.a.getNativeHeap();
                                    c.i("Matrix.MemoryCanaryCore", "activity:" + this.cVG + ", totalpss:" + aVar.cVX + ", uss:" + aVar.cVY + ", java:" + aVar.cVR + " , Native:" + aVar.cVS + ", code:" + aVar.cVV + ", stack:" + aVar.cVU + ", Graphics:" + aVar.cVT + ", other:" + aVar.cVW, new Object[0]);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public final long SM() {
        if (this.cVF >= 8) {
            return 1800000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long ir = (long) ((ir(this.cVF) - ir(this.cVF - 1)) * 60000);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 <= 1000) {
            return ir;
        }
        c.e("Matrix.MemoryCanaryCore", "[getNextDelay] cost time[%s] too long!", Long.valueOf(currentTimeMillis2));
        return ir;
    }

    private int ir(int i2) {
        if (i2 <= 0) {
            return 0;
        }
        if (i2 == 1) {
            return 1;
        }
        if (i2 == 2) {
            return 2;
        }
        if (i2 >= 8) {
            return 30;
        }
        return ir(i2 - 1) + ir(i2 - 2);
    }

    public final JSONObject getJsonInfo() {
        JSONObject jSONObject = new JSONObject();
        long dalvikHeap = com.tencent.matrix.g.a.getDalvikHeap();
        long nativeHeap = com.tencent.matrix.g.a.getNativeHeap();
        try {
            jSONObject.put("dalvikHeap", dalvikHeap);
            jSONObject.put("nativeHeap", nativeHeap);
            jSONObject.put("sysMem", cVA);
            jSONObject.put("memClass", cVC);
            jSONObject.put("available", com.tencent.matrix.g.a.TK());
            jSONObject.put("memfree", com.tencent.matrix.g.a.bn(this.mContext));
            jSONObject.put("islow", com.tencent.matrix.g.a.bm(this.mContext));
            jSONObject.put("vmSize", com.tencent.matrix.g.a.TN());
        } catch (JSONException e2) {
            c.e("Matrix.MemoryCanaryCore", "getJsonInfo exception:" + e2.getMessage(), new Object[0]);
        }
        return jSONObject;
    }

    static /* synthetic */ void a(a aVar, Activity activity) {
        if (aVar.mIsOpen) {
            aVar.mHandler.removeCallbacks(aVar.cVJ);
            c.d("Matrix.MemoryCanaryCore", "activity on show:" + activity.getClass().getSimpleName(), new Object[0]);
            aVar.cVG = activity.getClass().getSimpleName();
            aVar.mHandler.postDelayed(aVar.cVJ, 1000);
        }
    }
}
