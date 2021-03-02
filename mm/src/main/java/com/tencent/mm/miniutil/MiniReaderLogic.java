package com.tencent.mm.miniutil;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.webkit.ValueCallback;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.xweb.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class MiniReaderLogic {

    public static abstract class a<T> implements ValueCallback<T> {
        public boolean iBj = false;
    }

    private static String a(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str2, boolean z6) {
        AppMethodBeat.i(223518);
        Context context = MMApplicationContext.getContext();
        String str3 = "";
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pkgName", context.getPackageName());
            if (z5) {
                jSONObject.put("className", "com.tencent.mm.ui.tools.MiniQbCallBackMMUI");
            } else {
                jSONObject.put("className", "com.tencent.mm.ui.tools.MiniQbCallBackUI");
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "miniqb");
            jSONObject2.put("filePath", str);
            jSONObject2.put("processName", MMApplicationContext.getProcessName());
            jSONObject2.put("appid", str2);
            jSONObject.put("thirdCtx", jSONObject2);
            boolean gJY = ao.gJY();
            ArrayList arrayList = new ArrayList();
            if (z4) {
                JSONObject a2 = a(8, R.drawable.c9q, context.getString(R.string.cei), true, 1);
                if (z2) {
                    a2.put("from", "multitask");
                } else {
                    a2.put("from", "");
                }
                a2.put("hasCurrentMultiTask", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                a2.put("multiTaskId", MD5Util.getMD5String(String.format("%s", str)));
                JSONObject a3 = a(4, R.drawable.c6a, context.getString(R.string.c2x), true, 2);
                JSONObject a4 = a(5, R.drawable.icon_file_handoff, context.getString(R.string.cek), z3, 3);
                if (gJY) {
                    arrayList.add(a2);
                }
                arrayList.add(a3);
                arrayList.add(a4);
                if (z6) {
                    arrayList.add(a(7, R.drawable.bxw, context.getString(R.string.o4), true, 4));
                }
            } else {
                JSONObject h2 = h(8, R.drawable.c9q, context.getString(R.string.cei));
                if (z2) {
                    h2.put("from", "multitask");
                } else {
                    h2.put("from", "");
                }
                h2.put("hasCurrentMultiTask", z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                h2.put("multiTaskId", MD5Util.getMD5String(String.format("%s", str)));
                JSONObject h3 = h(4, R.drawable.c6a, context.getString(R.string.c2x));
                if (gJY) {
                    arrayList.add(h2);
                }
                arrayList.add(h3);
                if (z6) {
                    arrayList.add(h(7, R.drawable.bxw, context.getString(R.string.o4)));
                }
            }
            jSONObject.put("menuItems", new JSONArray((Collection) arrayList));
            str3 = jSONObject.toString();
        } catch (Exception e2) {
            Log.e("MicroMsg.FilesFloatBall.MiniReaderLogic", "getMenuInfo() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
        }
        AppMethodBeat.o(223518);
        return str3;
    }

    private static JSONObject a(int i2, int i3, String str, boolean z, int i4) {
        AppMethodBeat.i(223519);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", i2);
            jSONObject.put("iconResId", i3);
            jSONObject.put("text", str);
            jSONObject.put("isShow", z);
            jSONObject.put("idx", i4);
        } catch (Exception e2) {
            Log.e("MicroMsg.FilesFloatBall.MiniReaderLogic", "getMenuInfo() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
        }
        AppMethodBeat.o(223519);
        return jSONObject;
    }

    private static JSONObject h(int i2, int i3, String str) {
        AppMethodBeat.i(150142);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", i2);
            jSONObject.put("iconResId", i3);
            jSONObject.put("text", str);
        } catch (Exception e2) {
            Log.e("MicroMsg.FilesFloatBall.MiniReaderLogic", "getMenuInfo() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
        }
        AppMethodBeat.o(150142);
        return jSONObject;
    }

    public static void a(boolean z, boolean z2, boolean z3, Context context, String str, String str2, String str3, String str4, ValueCallback<String> valueCallback, ValueCallback<Integer> valueCallback2, int i2, boolean z4) {
        AppMethodBeat.i(223520);
        a(z, z2, z3, false, context, str, str2, str3, str4, valueCallback, valueCallback2, false, "", i2, true, z4);
        AppMethodBeat.o(223520);
    }

    public static void a(boolean z, boolean z2, Context context, String str, String str2, String str3, String str4, ValueCallback<String> valueCallback, ValueCallback<Integer> valueCallback2) {
        AppMethodBeat.i(223521);
        a(z, z2, false, false, context, str, str2, str3, str4, valueCallback, valueCallback2, true, "", 0, true, false);
        AppMethodBeat.o(223521);
    }

    public static void a(boolean z, boolean z2, Context context, String str, String str2, String str3, String str4, ValueCallback<String> valueCallback, ValueCallback<Integer> valueCallback2, String str5, boolean z3) {
        AppMethodBeat.i(223522);
        a(z, false, false, z2, context, str, str2, str3, str4, valueCallback, valueCallback2, true, str5, 0, z3, false);
        AppMethodBeat.o(223522);
    }

    private static void a(boolean z, boolean z2, boolean z3, boolean z4, Context context, String str, String str2, String str3, String str4, ValueCallback<String> valueCallback, ValueCallback<Integer> valueCallback2, boolean z5, String str5, int i2, boolean z6, boolean z7) {
        AppMethodBeat.i(223523);
        HashMap hashMap = new HashMap();
        hashMap.put("menuData", a(str, z, z2, z4, z3, z5, str5, z7));
        if (z4) {
            int i3 = 1;
            if (Util.isEqual(i2, 9)) {
                i3 = 3;
            }
            hashMap.put("param_flag", String.valueOf(i3));
        }
        com.tencent.mm.cr.a.a(context, str, str2, str3, str4, true, (HashMap<String, String>) hashMap, f.a.NONE, valueCallback, valueCallback2, z6);
        AppMethodBeat.o(223523);
    }

    public static void a(boolean z, Context context, String str, String str2, String str3, String str4, ValueCallback<String> valueCallback, ValueCallback<Integer> valueCallback2, String str5, boolean z2) {
        AppMethodBeat.i(223524);
        a(z, false, context, str, str2, str3, str4, valueCallback, valueCallback2, true, str5, z2, false);
        AppMethodBeat.o(223524);
    }

    public static void a(boolean z, boolean z2, Context context, String str, String str2, String str3, String str4, ValueCallback<String> valueCallback, ValueCallback<Integer> valueCallback2, boolean z3, String str5, boolean z4, boolean z5) {
        AppMethodBeat.i(223525);
        HashMap hashMap = new HashMap();
        hashMap.put("menuData", a(str, z, z2, false, false, z3, str5, z5));
        hashMap.put("query_param", "feature_wx_float_window");
        com.tencent.mm.cr.a.a(context, str, str2, str3, str4, false, (HashMap<String, String>) hashMap, f.a.NONE, valueCallback, valueCallback2, z4);
        AppMethodBeat.o(223525);
    }

    public static void a(boolean z, Context context, String str, String str2, String str3, String str4, ValueCallback<String> valueCallback, ValueCallback<Integer> valueCallback2, boolean z2, String str5, boolean z3) {
        AppMethodBeat.i(223526);
        HashMap hashMap = new HashMap();
        hashMap.put("menuData", a(str, z, false, false, true, z2, str5, z3));
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", 1);
            jSONObject.put("isShow", !z);
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", 2);
            jSONObject2.put("isShow", z);
            jSONArray.put(jSONObject2);
            hashMap.put("update_menu_param", jSONArray.toString());
        } catch (Exception e2) {
            Log.e("MicroMsg.FilesFloatBall.MiniReaderLogic", "updateMenu() Exception:%s %s", e2.getClass().getSimpleName(), e2.getMessage());
        }
        com.tencent.mm.cr.a.a(context, str, str2, str3, str4, true, (HashMap<String, String>) hashMap, f.a.NONE, valueCallback, valueCallback2, true);
        AppMethodBeat.o(223526);
    }

    public static final class MiniQbFloatBallMenuActionBrandEvent implements Parcelable {
        public static final Parcelable.Creator<MiniQbFloatBallMenuActionBrandEvent> CREATOR = new Parcelable.Creator<MiniQbFloatBallMenuActionBrandEvent>() {
            /* class com.tencent.mm.miniutil.MiniReaderLogic.MiniQbFloatBallMenuActionBrandEvent.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ MiniQbFloatBallMenuActionBrandEvent[] newArray(int i2) {
                return new MiniQbFloatBallMenuActionBrandEvent[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ MiniQbFloatBallMenuActionBrandEvent createFromParcel(Parcel parcel) {
                AppMethodBeat.i(150136);
                MiniQbFloatBallMenuActionBrandEvent miniQbFloatBallMenuActionBrandEvent = new MiniQbFloatBallMenuActionBrandEvent(parcel);
                AppMethodBeat.o(150136);
                return miniQbFloatBallMenuActionBrandEvent;
            }
        };
        public int action;
        public String filePath;

        public MiniQbFloatBallMenuActionBrandEvent(int i2, String str) {
            this.action = i2;
            this.filePath = str;
        }

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(150137);
            parcel.writeInt(this.action);
            parcel.writeString(this.filePath);
            AppMethodBeat.o(150137);
        }

        protected MiniQbFloatBallMenuActionBrandEvent(Parcel parcel) {
            AppMethodBeat.i(150138);
            this.action = parcel.readInt();
            this.filePath = parcel.readString();
            AppMethodBeat.o(150138);
        }

        static {
            AppMethodBeat.i(150139);
            AppMethodBeat.o(150139);
        }
    }
}
