package com.tencent.xweb;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.xweb.WebView;
import com.tencent.xweb.f;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.w;
import com.tencent.xweb.xwalk.a.g;
import com.tencent.xweb.xwalk.a.j;
import com.tencent.xweb.xwalk.a.m;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class h {
    private static Map<String, String> Szd = new HashMap();
    private static w.a Sze = null;

    public interface a {
        void Rz(int i2);

        void ar(int i2, int i3, int i4);

        void b(int i2, float f2, int i3, int i4, int i5, int i6);

        void c(int i2, Bitmap bitmap);

        void cTA();

        void epu();

        void epv();

        void epw();
    }

    static /* synthetic */ void b(m mVar, String str, String str2, String str3, HashMap hashMap, c cVar, Activity activity, ViewGroup viewGroup, a aVar, ValueCallback valueCallback) {
        AppMethodBeat.i(219035);
        a(mVar, str, str2, str3, hashMap, cVar, activity, viewGroup, aVar, valueCallback);
        AppMethodBeat.o(219035);
    }

    static /* synthetic */ void b(String str, ValueCallback valueCallback, int i2) {
        AppMethodBeat.i(219036);
        a(str, -1, valueCallback, i2);
        AppMethodBeat.o(219036);
    }

    static /* synthetic */ Integer f(HashMap hashMap, String str) {
        AppMethodBeat.i(219037);
        Integer b2 = b(hashMap, str);
        AppMethodBeat.o(219037);
        return b2;
    }

    static /* synthetic */ Float g(HashMap hashMap, String str) {
        AppMethodBeat.i(219038);
        Float c2 = c(hashMap, str);
        AppMethodBeat.o(219038);
        return c2;
    }

    static /* synthetic */ Bitmap h(HashMap hashMap, String str) {
        AppMethodBeat.i(219039);
        Bitmap d2 = d(hashMap, str);
        AppMethodBeat.o(219039);
        return d2;
    }

    static /* synthetic */ MotionEvent i(HashMap hashMap, String str) {
        AppMethodBeat.i(219040);
        MotionEvent e2 = e(hashMap, str);
        AppMethodBeat.o(219040);
        return e2;
    }

    public static class b {
        public int Szo;
        public int Szp;
        public int index;
        public float zoom;

        public b(int i2, float f2, int i3, int i4) {
            this.index = i2;
            this.zoom = f2;
            this.Szo = i3;
            this.Szp = i4;
        }
    }

    public enum c {
        ListView,
        ReaderView;

        public static c valueOf(String str) {
            AppMethodBeat.i(219018);
            c cVar = (c) Enum.valueOf(c.class, str);
            AppMethodBeat.o(219018);
            return cVar;
        }

        static {
            AppMethodBeat.i(219019);
            AppMethodBeat.o(219019);
        }
    }

    static {
        AppMethodBeat.i(156758);
        AppMethodBeat.o(156758);
    }

    public static void a(String str, String str2, String str3, boolean z, c cVar, Activity activity, ViewGroup viewGroup, a aVar, ValueCallback<Integer> valueCallback) {
        AppMethodBeat.i(219020);
        a(str, str2, str3, z, (HashMap<String, String>) null, cVar, activity, viewGroup, aVar, valueCallback);
        AppMethodBeat.o(219020);
    }

    public static void a(String str, String str2, String str3, boolean z, HashMap<String, String> hashMap, c cVar, Activity activity, ViewGroup viewGroup, a aVar, ValueCallback<Integer> valueCallback) {
        AppMethodBeat.i(219021);
        Log.i("XFilesReaderXWeb", "readFile by xweb, fileExt: " + (str2 != null ? str2 : BuildConfig.COMMAND));
        f.nY(str2, f.a.XWEB.name());
        g brX = f.brX(str2);
        if (!(brX instanceof m)) {
            Log.e("XFilesReaderXWeb", "readFile unSupport format".concat(String.valueOf(str2)));
            a(str2, -1, valueCallback, -7);
            AppMethodBeat.o(219021);
            return;
        }
        m mVar = (m) brX;
        int hvk = mVar.hvk();
        int atb = mVar.atb(aVar != null ? 1 : 0);
        if (hvk > 0 && hvk >= atb) {
            a(mVar, str, str2, str3, hashMap, cVar, activity, viewGroup, aVar, valueCallback);
            AppMethodBeat.o(219021);
        } else if (ai.htj() && !brX.hvi()) {
            Log.i("XFilesReaderXWeb", "readFile forbid download code, return");
            a(str2, -1, valueCallback, -1);
            AppMethodBeat.o(219021);
        } else if (!z) {
            Log.i("XFilesReaderXWeb", "readFile plugin version: " + hvk + ", require: " + atb + ", canDownload: false, return");
            a(str2, hvk, valueCallback, hvk <= 0 ? -2 : -11);
            AppMethodBeat.o(219021);
        } else {
            Log.i("XFilesReaderXWeb", "readFile plugin version: " + hvk + ", require: " + atb + ", canDownload: true, start download");
            f.bsd(str2);
            if (!a(mVar, str, str2, str3, z, hashMap, cVar, activity, viewGroup, aVar, valueCallback)) {
                f.bse(str2);
                a(str2, hvk, valueCallback, -16);
            }
            AppMethodBeat.o(219021);
        }
    }

    private static boolean a(final m mVar, final String str, final String str2, final String str3, final boolean z, final HashMap<String, String> hashMap, final c cVar, Activity activity, ViewGroup viewGroup, final a aVar, final ValueCallback<Integer> valueCallback) {
        RelativeLayout relativeLayout;
        AppMethodBeat.i(219023);
        if (Sze != null) {
            Log.i("XFilesReaderXWeb", "startDownload pre updater not finish, cancel it");
            Sze.hsE();
            Sze = null;
        }
        l.a g2 = l.g(WebView.c.WV_KIND_CW);
        if (g2 == null) {
            Log.e("XFilesReaderXWeb", "startDownload webViewProvider is null");
            AppMethodBeat.o(219023);
            return false;
        }
        w.a aVar2 = (w.a) g2.excute("STR_CMD_GET_PLUGIN_UPDATER", null);
        Sze = aVar2;
        if (aVar2 == null) {
            Log.e("XFilesReaderXWeb", "startDownload updater is null");
            AppMethodBeat.o(219023);
            return false;
        } else if (activity == null || activity.isDestroyed() || viewGroup == null) {
            Log.e("XFilesReaderXWeb", "startDownload activity destroyed");
            AppMethodBeat.o(219023);
            return false;
        } else {
            RelativeLayout relativeLayout2 = null;
            int i2 = 0;
            while (i2 < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i2);
                if (childAt != null) {
                    Object tag = childAt.getTag();
                    if ((tag instanceof String) && "view_tag_relative_layout".equalsIgnoreCase((String) tag)) {
                        relativeLayout = (RelativeLayout) childAt;
                        i2++;
                        relativeLayout2 = relativeLayout;
                    }
                }
                relativeLayout = relativeLayout2;
                i2++;
                relativeLayout2 = relativeLayout;
            }
            if (relativeLayout2 == null) {
                if (viewGroup instanceof RelativeLayout) {
                    relativeLayout2 = (RelativeLayout) viewGroup;
                } else {
                    Log.e("XFilesReaderXWeb", "startDownload layout is null");
                    AppMethodBeat.o(219023);
                    return false;
                }
            }
            Integer num = null;
            if (hashMap != null) {
                num = bsf(hashMap.get("extra_param_download_text_color"));
            }
            if (num == null) {
                num = -1140850689;
            }
            TextView textView = new TextView(activity);
            textView.setText(activity.getString(R.string.j7k) + "0%");
            textView.setTextSize(14.0f);
            textView.setTextColor(num.intValue());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13, -1);
            relativeLayout2.addView(textView, layoutParams);
            final WeakReference weakReference = new WeakReference(activity);
            final WeakReference weakReference2 = new WeakReference(viewGroup);
            final WeakReference weakReference3 = new WeakReference(textView);
            Sze.a(mVar.getPluginName(), new j() {
                /* class com.tencent.xweb.h.AnonymousClass1 */

                @Override // com.tencent.xweb.xwalk.a.j
                public final void hst() {
                    AppMethodBeat.i(219012);
                    Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateStarted");
                    AppMethodBeat.o(219012);
                }

                @Override // com.tencent.xweb.xwalk.a.j
                public final void asQ(int i2) {
                    AppMethodBeat.i(219013);
                    Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateProgress ".concat(String.valueOf(i2)));
                    Activity activity = (Activity) weakReference.get();
                    TextView textView = (TextView) weakReference3.get();
                    if (activity == null || activity.isDestroyed() || textView == null) {
                        AppMethodBeat.o(219013);
                        return;
                    }
                    textView.setText(activity.getString(R.string.j7k) + i2 + "%");
                    AppMethodBeat.o(219013);
                }

                @Override // com.tencent.xweb.xwalk.a.j
                public final void asR(int i2) {
                    AppMethodBeat.i(219014);
                    Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted errorCode = ".concat(String.valueOf(i2)));
                    w.a unused = h.Sze = null;
                    f.hO(str2, i2);
                    Activity activity = (Activity) weakReference.get();
                    ViewGroup viewGroup = (ViewGroup) weakReference2.get();
                    TextView textView = (TextView) weakReference3.get();
                    switch (i2) {
                        case 0:
                            if (activity == null || activity.isDestroyed() || viewGroup == null || textView == null) {
                                Log.e("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download success, view destroyed, return");
                                h.b(str2, valueCallback, -14);
                                AppMethodBeat.o(219014);
                                return;
                            }
                            Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download success, start read file");
                            textView.setVisibility(8);
                            h.b(mVar, str, str2, str3, hashMap, cVar, activity, viewGroup, aVar, valueCallback);
                            AppMethodBeat.o(219014);
                            return;
                        default:
                            if (!(activity == null || activity.isDestroyed() || viewGroup == null || textView == null)) {
                                textView.setText(activity.getString(R.string.j7j));
                            }
                            if (i2 == -1) {
                                Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download cancel");
                                h.b(str2, valueCallback, -15);
                                AppMethodBeat.o(219014);
                                return;
                            }
                            Log.i("XFilesReaderXWeb", "onXWalkPluginUpdateCompleted, download failed");
                            h.b(str2, valueCallback, -16);
                            AppMethodBeat.o(219014);
                            return;
                    }
                }
            });
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put("UpdaterCheckType", "1");
            Sze.b(XWalkEnvironment.getApplicationContext(), hashMap2);
            AppMethodBeat.o(219023);
            return true;
        }
    }

    private static void a(m mVar, String str, String str2, String str3, HashMap<String, String> hashMap, c cVar, Activity activity, ViewGroup viewGroup, final a aVar, ValueCallback<Integer> valueCallback) {
        boolean z;
        boolean z2;
        boolean a2;
        boolean z3;
        AppMethodBeat.i(219024);
        long currentTimeMillis = System.currentTimeMillis();
        long lB = f.lB(activity);
        if (y.hsF() != null) {
            boolean hsG = y.hsF().hsG();
            SharedPreferences sharedPreferences = y.hsF().SzQ.getSharedPreferences("wcwebview", 4);
            if (sharedPreferences == null) {
                z3 = true;
            } else {
                z3 = sharedPreferences.getBoolean("fr_disable_encry", true);
            }
            z = z3;
            z2 = hsG;
        } else {
            z = true;
            z2 = false;
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                if (!(entry == null || entry.getKey() == null || entry.getKey().isEmpty() || entry.getValue() == null || entry.getValue().isEmpty())) {
                    hashMap2.put(entry.getKey(), entry.getValue());
                }
            }
        }
        HashMap<String, String> brQ = b.brQ(mVar.getPluginName());
        if (brQ != null) {
            for (Map.Entry<String, String> entry2 : brQ.entrySet()) {
                if (!(entry2 == null || entry2.getKey() == null || entry2.getKey().isEmpty() || entry2.getValue() == null || entry2.getValue().isEmpty())) {
                    hashMap2.put("config_param_" + entry2.getKey(), entry2.getValue());
                }
            }
        }
        hashMap2.put("dark_mode", String.valueOf(XWalkEnvironment.getForceDarkMode()));
        hashMap2.put("disable_cache", String.valueOf(z2));
        hashMap2.put("disable_encry", String.valueOf(z));
        hashMap2.put("file_path", str);
        hashMap2.put("file_ext", str2);
        hashMap2.put("token", str3);
        hashMap2.put("time_start", String.valueOf(currentTimeMillis));
        hashMap2.put("memory_start", String.valueOf(lB));
        hashMap2.put("str_password_title", activity.getString(R.string.j7h));
        hashMap2.put("str_password_wrong", activity.getString(R.string.j7i));
        hashMap2.put("str_password_hint", activity.getString(R.string.j7g));
        hashMap2.put("str_button_confirm", activity.getString(R.string.j7d));
        hashMap2.put("str_button_cancel", activity.getString(R.string.j7c));
        hashMap2.put("str_operation_copy", activity.getString(R.string.j7f));
        hashMap2.put("str_hint_copied", activity.getString(R.string.j7e));
        switch (cVar) {
            case ReaderView:
                hashMap2.put("view_type", "view_type_reader");
                break;
            default:
                hashMap2.put("view_type", "view_type_list");
                break;
        }
        if (aVar != null) {
            a2 = mVar.a(hashMap2, activity, viewGroup, new ValueCallback<Pair<String, Object>>() {
                /* class com.tencent.xweb.h.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // android.webkit.ValueCallback
                public final /* synthetic */ void onReceiveValue(Pair<String, Object> pair) {
                    AppMethodBeat.i(219015);
                    Pair<String, Object> pair2 = pair;
                    if (pair2 == null || pair2.first == null || !(pair2.second instanceof HashMap)) {
                        Log.e("XFilesReaderXWeb", "actionCallback onReceiveValue error, value invalid");
                        AppMethodBeat.o(219015);
                        return;
                    }
                    try {
                        HashMap hashMap = (HashMap) pair2.second;
                        if ("ac_onViewStatusChange".equals(pair2.first)) {
                            Integer f2 = h.f(hashMap, "ac_viewIndex");
                            if (f2 == null) {
                                Log.e("XFilesReaderXWeb", "actionCallback " + ((String) pair2.first) + ", viewIndex is null");
                                AppMethodBeat.o(219015);
                                return;
                            }
                            Float g2 = h.g(hashMap, "ac_viewZoom");
                            if (g2 == null) {
                                Log.e("XFilesReaderXWeb", "actionCallback " + ((String) pair2.first) + ", viewZoom is null");
                                AppMethodBeat.o(219015);
                                return;
                            }
                            Integer f3 = h.f(hashMap, "ac_curWidth");
                            if (f3 == null) {
                                Log.e("XFilesReaderXWeb", "actionCallback " + ((String) pair2.first) + ", viewCurWidth is null");
                                AppMethodBeat.o(219015);
                                return;
                            }
                            Integer f4 = h.f(hashMap, "ac_curHeight");
                            if (f4 == null) {
                                Log.e("XFilesReaderXWeb", "actionCallback " + ((String) pair2.first) + ", viewCurHeight is null");
                                AppMethodBeat.o(219015);
                                return;
                            }
                            Integer f5 = h.f(hashMap, "ac_viewTransX");
                            if (f5 == null) {
                                Log.e("XFilesReaderXWeb", "actionCallback " + ((String) pair2.first) + ", viewTransX is null");
                                AppMethodBeat.o(219015);
                                return;
                            }
                            Integer f6 = h.f(hashMap, "ac_viewTransY");
                            if (f6 == null) {
                                Log.e("XFilesReaderXWeb", "actionCallback " + ((String) pair2.first) + ", viewTransY is null");
                                AppMethodBeat.o(219015);
                                return;
                            }
                            aVar.b(f2.intValue(), g2.floatValue(), f3.intValue(), f4.intValue(), f5.intValue(), f6.intValue());
                            AppMethodBeat.o(219015);
                        } else if ("ac_onPageCountUpdate".equals(pair2.first)) {
                            Integer f7 = h.f(hashMap, "ac_totalCount");
                            if (f7 == null) {
                                Log.e("XFilesReaderXWeb", "actionCallback " + ((String) pair2.first) + ", totalCount is null");
                                AppMethodBeat.o(219015);
                                return;
                            }
                            aVar.Rz(f7.intValue());
                            AppMethodBeat.o(219015);
                        } else if ("ac_onPageChange".equals(pair2.first)) {
                            Integer f8 = h.f(hashMap, "ac_pageIndex");
                            if (f8 == null) {
                                Log.e("XFilesReaderXWeb", "actionCallback " + ((String) pair2.first) + ", pageIndex is null");
                                AppMethodBeat.o(219015);
                                return;
                            }
                            Integer f9 = h.f(hashMap, "ac_pageWidth");
                            if (f9 == null) {
                                Log.e("XFilesReaderXWeb", "actionCallback " + ((String) pair2.first) + ", pageWidth is null");
                                AppMethodBeat.o(219015);
                                return;
                            }
                            Integer f10 = h.f(hashMap, "ac_pageHeight");
                            if (f10 == null) {
                                Log.e("XFilesReaderXWeb", "actionCallback " + ((String) pair2.first) + ", pageHeight is null");
                                AppMethodBeat.o(219015);
                                return;
                            }
                            aVar.ar(f8.intValue(), f9.intValue(), f10.intValue());
                            AppMethodBeat.o(219015);
                        } else if ("ac_onThumbnailLoad".equals(pair2.first)) {
                            Integer f11 = h.f(hashMap, "ac_pageIndex");
                            Bitmap h2 = h.h(hashMap, "ac_thumbnail");
                            if (f11 == null || h2 == null) {
                                Log.e("XFilesReaderXWeb", "actionCallback " + ((String) pair2.first) + ", pageIndex/thumbnail is null");
                                AppMethodBeat.o(219015);
                                return;
                            }
                            aVar.c(f11.intValue(), h2);
                            AppMethodBeat.o(219015);
                        } else if ("ac_onSingleTap".equals(pair2.first)) {
                            if (h.i(hashMap, "ac_motionEvent") == null) {
                                Log.e("XFilesReaderXWeb", "actionCallback " + ((String) pair2.first) + ", motion event is null");
                                AppMethodBeat.o(219015);
                                return;
                            }
                            aVar.epu();
                            AppMethodBeat.o(219015);
                        } else if ("ac_onDoubleTap".equals(pair2.first)) {
                            if (h.i(hashMap, "ac_motionEvent") == null) {
                                Log.e("XFilesReaderXWeb", "actionCallback " + ((String) pair2.first) + ", motion event is null");
                                AppMethodBeat.o(219015);
                                return;
                            }
                            AppMethodBeat.o(219015);
                        } else if ("ac_onReachEnd".equals(pair2.first)) {
                            aVar.epv();
                            AppMethodBeat.o(219015);
                        } else if ("ac_onUserOperated".equals(pair2.first)) {
                            aVar.epw();
                            AppMethodBeat.o(219015);
                        } else if ("ac_onUserCancel".equals(pair2.first)) {
                            aVar.cTA();
                            AppMethodBeat.o(219015);
                        } else {
                            Log.e("XFilesReaderXWeb", "actionCallback unknown value: " + ((String) pair2.first));
                            AppMethodBeat.o(219015);
                        }
                    } catch (Exception e2) {
                        Log.e("XFilesReaderXWeb", "actionCallback onReceiveValue error, hashMap invalid");
                        AppMethodBeat.o(219015);
                    }
                }
            }, valueCallback);
        } else {
            a2 = mVar.a(hashMap2, activity, viewGroup, null, valueCallback);
        }
        if (a2) {
            Szd.put(str3 + str, mVar.getPluginName());
        }
        AppMethodBeat.o(219024);
    }

    public static void nZ(String str, String str2) {
        AppMethodBeat.i(156757);
        try {
            if (Sze != null) {
                Log.i("XFilesReaderXWeb", "finishReadFile pre updater exist, cancel it");
                Sze.hsE();
                Sze = null;
            }
            String str3 = Szd.get(str + str2);
            if (str3 == null) {
                AppMethodBeat.o(156757);
                return;
            }
            Szd.remove(str + str2);
            g brX = com.tencent.xweb.xwalk.a.h.brX(str3);
            if (brX instanceof m) {
                Log.i("XFilesReaderXWeb", "finishReadFile ".concat(String.valueOf(str3)));
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("file_path", str2);
                hashMap.put("token", str);
                ((m) brX).D(hashMap);
                AppMethodBeat.o(156757);
                return;
            }
            Log.e("XFilesReaderXWeb", "finishReadFile unknown plugin: ".concat(String.valueOf(str3)));
            AppMethodBeat.o(156757);
        } catch (Exception e2) {
            Log.e("XFilesReaderXWeb", "finishReadFile error: " + e2.getMessage());
            AppMethodBeat.o(156757);
        }
    }

    public static b oa(String str, String str2) {
        AppMethodBeat.i(219025);
        if (str != null) {
            try {
                if (!str.isEmpty() && str2 != null && !str2.isEmpty()) {
                    String str3 = Szd.get(str + str2);
                    if (str3 == null) {
                        Log.e("XFilesReaderXWeb", "getViewStatus error, not reading");
                        AppMethodBeat.o(219025);
                        return null;
                    }
                    g brX = com.tencent.xweb.xwalk.a.h.brX(str3);
                    if (brX instanceof m) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("token", str);
                        b E = ((m) brX).E(hashMap);
                        AppMethodBeat.o(219025);
                        return E;
                    }
                    Log.e("XFilesReaderXWeb", "getViewStatus error, unknown plugin: ".concat(String.valueOf(str3)));
                    AppMethodBeat.o(219025);
                    return null;
                }
            } catch (Exception e2) {
                Log.e("XFilesReaderXWeb", "getViewStatus error: " + e2.getMessage());
                AppMethodBeat.o(219025);
                return null;
            }
        }
        Log.e("XFilesReaderXWeb", "getViewStatus error, invalid param");
        AppMethodBeat.o(219025);
        return null;
    }

    public static boolean aw(String str, String str2, int i2) {
        AppMethodBeat.i(219026);
        if (str != null) {
            try {
                if (!str.isEmpty() && str2 != null && !str2.isEmpty()) {
                    String str3 = Szd.get(str + str2);
                    if (str3 == null) {
                        Log.e("XFilesReaderXWeb", "setViewToStatus error, not reading");
                        AppMethodBeat.o(219026);
                        return false;
                    }
                    g brX = com.tencent.xweb.xwalk.a.h.brX(str3);
                    if (brX instanceof m) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("token", str);
                        hashMap.put("set_index", Integer.valueOf(i2));
                        hashMap.put("set_zoom", Float.valueOf(1.0f));
                        hashMap.put("set_x", 0);
                        hashMap.put("set_y", 0);
                        boolean F = ((m) brX).F(hashMap);
                        AppMethodBeat.o(219026);
                        return F;
                    }
                    Log.e("XFilesReaderXWeb", "setViewToStatus error, unknown plugin: ".concat(String.valueOf(str3)));
                    AppMethodBeat.o(219026);
                    return false;
                }
            } catch (Exception e2) {
                Log.e("XFilesReaderXWeb", "setViewToStatus error: " + e2.getMessage());
                AppMethodBeat.o(219026);
                return false;
            }
        }
        Log.e("XFilesReaderXWeb", "setViewToStatus error, invalid param");
        AppMethodBeat.o(219026);
        return false;
    }

    public static boolean ax(String str, String str2, int i2) {
        AppMethodBeat.i(219027);
        if (str != null) {
            try {
                if (!str.isEmpty() && str2 != null && !str2.isEmpty() && i2 >= 0) {
                    String str3 = Szd.get(str + str2);
                    if (str3 == null) {
                        Log.e("XFilesReaderXWeb", "requestThumbnail error, not reading");
                        AppMethodBeat.o(219027);
                        return false;
                    }
                    g brX = com.tencent.xweb.xwalk.a.h.brX(str3);
                    if (brX instanceof m) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("token", str);
                        hashMap.put("thumbnail_index", Integer.valueOf(i2));
                        boolean G = ((m) brX).G(hashMap);
                        AppMethodBeat.o(219027);
                        return G;
                    }
                    Log.e("XFilesReaderXWeb", "requestThumbnail error, unknown plugin: ".concat(String.valueOf(str3)));
                    AppMethodBeat.o(219027);
                    return false;
                }
            } catch (Exception e2) {
                Log.e("XFilesReaderXWeb", "requestThumbnail error: " + e2.getMessage());
                AppMethodBeat.o(219027);
                return false;
            }
        }
        Log.e("XFilesReaderXWeb", "requestThumbnail error, invalid param");
        AppMethodBeat.o(219027);
        return false;
    }

    public static boolean b(String str, String str2, MotionEvent motionEvent) {
        AppMethodBeat.i(219028);
        if (str != null) {
            try {
                if (!str.isEmpty() && str2 != null && !str2.isEmpty() && motionEvent != null) {
                    String str3 = Szd.get(str + str2);
                    if (str3 == null) {
                        Log.e("XFilesReaderXWeb", "setTouchEvent error, not reading");
                        AppMethodBeat.o(219028);
                        return false;
                    }
                    g brX = com.tencent.xweb.xwalk.a.h.brX(str3);
                    if (brX instanceof m) {
                        HashMap<String, Object> hashMap = new HashMap<>();
                        hashMap.put("token", str);
                        hashMap.put("gi_name", "gi_setTouchEvent");
                        hashMap.put("gi_touchEvent", motionEvent);
                        Object H = ((m) brX).H(hashMap);
                        if (H instanceof Boolean) {
                            boolean booleanValue = ((Boolean) H).booleanValue();
                            AppMethodBeat.o(219028);
                            return booleanValue;
                        }
                        AppMethodBeat.o(219028);
                        return false;
                    }
                    Log.e("XFilesReaderXWeb", "setTouchEvent error, unknown plugin: ".concat(String.valueOf(str3)));
                    AppMethodBeat.o(219028);
                    return false;
                }
            } catch (Exception e2) {
                Log.e("XFilesReaderXWeb", "setTouchEvent error: " + e2.getMessage());
                AppMethodBeat.o(219028);
                return false;
            }
        }
        Log.e("XFilesReaderXWeb", "setTouchEvent error, invalid param");
        AppMethodBeat.o(219028);
        return false;
    }

    private static Integer b(HashMap<String, Object> hashMap, String str) {
        AppMethodBeat.i(219029);
        if (hashMap == null) {
            Log.e("XFilesReaderXWeb", "getIntegerFromParams params is null");
            AppMethodBeat.o(219029);
            return null;
        }
        try {
            Object obj = hashMap.get(str);
            if (obj instanceof Integer) {
                Integer num = (Integer) obj;
                AppMethodBeat.o(219029);
                return num;
            }
            Log.e("XFilesReaderXWeb", "getIntegerFromParams value is not integer, key: ".concat(String.valueOf(str)));
            AppMethodBeat.o(219029);
            return null;
        } catch (Exception e2) {
            Log.e("XFilesReaderXWeb", "getIntegerFromParams error: ", e2);
            AppMethodBeat.o(219029);
            return null;
        }
    }

    private static Float c(HashMap<String, Object> hashMap, String str) {
        AppMethodBeat.i(219030);
        if (hashMap == null) {
            Log.e("XFilesReaderXWeb", "getFloatFromParams params is null");
            AppMethodBeat.o(219030);
            return null;
        }
        try {
            Object obj = hashMap.get(str);
            if (obj instanceof Float) {
                Float f2 = (Float) obj;
                AppMethodBeat.o(219030);
                return f2;
            }
            Log.e("XFilesReaderXWeb", "getFloatFromParams value is not float, key: ".concat(String.valueOf(str)));
            AppMethodBeat.o(219030);
            return null;
        } catch (Exception e2) {
            Log.e("XFilesReaderXWeb", "getFloatFromParams error: ", e2);
            AppMethodBeat.o(219030);
            return null;
        }
    }

    private static Bitmap d(HashMap<String, Object> hashMap, String str) {
        AppMethodBeat.i(219031);
        if (hashMap == null) {
            Log.e("XFilesReaderXWeb", "getBitmapFromParams params is null");
            AppMethodBeat.o(219031);
            return null;
        }
        try {
            Object obj = hashMap.get(str);
            if (obj instanceof Bitmap) {
                Bitmap bitmap = (Bitmap) obj;
                AppMethodBeat.o(219031);
                return bitmap;
            }
            Log.e("XFilesReaderXWeb", "getBitmapFromParams value is not bitmap, key: ".concat(String.valueOf(str)));
            AppMethodBeat.o(219031);
            return null;
        } catch (Exception e2) {
            Log.e("XFilesReaderXWeb", "getBitmapFromParams error: ", e2);
            AppMethodBeat.o(219031);
            return null;
        }
    }

    private static MotionEvent e(HashMap<String, Object> hashMap, String str) {
        AppMethodBeat.i(219032);
        if (hashMap == null) {
            Log.e("XFilesReaderXWeb", "getMotionEventFromParams params is null");
            AppMethodBeat.o(219032);
            return null;
        }
        try {
            Object obj = hashMap.get(str);
            if (obj instanceof MotionEvent) {
                MotionEvent motionEvent = (MotionEvent) obj;
                AppMethodBeat.o(219032);
                return motionEvent;
            }
            Log.e("XFilesReaderXWeb", "getMotionEventFromParams value is not motion event, key: ".concat(String.valueOf(str)));
            AppMethodBeat.o(219032);
            return null;
        } catch (Exception e2) {
            Log.e("XFilesReaderXWeb", "getMotionEventFromParams error: ", e2);
            AppMethodBeat.o(219032);
            return null;
        }
    }

    private static Integer bsf(String str) {
        Integer num = null;
        AppMethodBeat.i(219033);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.o(219033);
        } else {
            try {
                num = Integer.valueOf(Integer.parseInt(str));
                AppMethodBeat.o(219033);
            } catch (Exception e2) {
                Log.e("XFilesReaderXWeb", "parseInteger error:" + e2.getMessage());
                AppMethodBeat.o(219033);
            }
        }
        return num;
    }

    private static void a(String str, int i2, ValueCallback<Integer> valueCallback, int i3) {
        AppMethodBeat.i(219034);
        f.aZ(str, i2, i3);
        if (valueCallback != null) {
            valueCallback.onReceiveValue(Integer.valueOf(i3));
        }
        AppMethodBeat.o(219034);
    }

    public static boolean r(String str, boolean z, boolean z2) {
        AppMethodBeat.i(219022);
        if (!z || !e.brV(str)) {
            g brX = f.brX(str);
            if (!(brX instanceof m)) {
                Log.i("XFilesReaderXWeb", "isPluginAvailable unSupport format".concat(String.valueOf(str)));
                AppMethodBeat.o(219022);
                return false;
            }
            m mVar = (m) brX;
            int hvk = mVar.hvk();
            int atb = mVar.atb(0);
            if (hvk > 0 && hvk >= atb) {
                Log.i("XFilesReaderXWeb", "isPluginAvailable has available version");
                AppMethodBeat.o(219022);
                return true;
            } else if (ai.htj() && !brX.hvi()) {
                Log.i("XFilesReaderXWeb", "isPluginAvailable forbid download code");
                AppMethodBeat.o(219022);
                return false;
            } else if (!z2) {
                Log.i("XFilesReaderXWeb", "isPluginAvailable not installed, can not download");
                AppMethodBeat.o(219022);
                return false;
            } else {
                Log.i("XFilesReaderXWeb", "isPluginAvailable not installed, can download");
                AppMethodBeat.o(219022);
                return true;
            }
        } else {
            Log.i("XFilesReaderXWeb", "isPluginAvailable recent crashed");
            AppMethodBeat.o(219022);
            return false;
        }
    }
}
