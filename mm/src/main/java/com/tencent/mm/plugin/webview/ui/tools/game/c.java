package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.it;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    private long Jqf = 0;
    Bundle Jqg;
    public a Jqh = new a();
    long mStartTime = 0;
    long xOJ = 0;
    long xyY = 0;

    public c() {
        AppMethodBeat.i(80856);
        AppMethodBeat.o(80856);
    }

    public class a {
        public a() {
            c.this = r1;
        }

        public final void ghf() {
            c.this.Jqg = null;
            c.this.mStartTime = 0;
            c.this.xyY = 0;
            c.this.mStartTime = 0;
            c.this.xOJ = 0;
        }

        public final void LZ() {
            AppMethodBeat.i(80852);
            c.this.mStartTime = System.currentTimeMillis();
            c.this.xOJ = System.currentTimeMillis();
            AppMethodBeat.o(80852);
        }

        public final void bm(Bundle bundle) {
            AppMethodBeat.i(80853);
            c.this.Jqg = bundle;
            Log.i("MicroMsg.GamePageTimeReport", "setGamePageReportData");
            if (bundle != null && bundle.getBoolean("game_page_report_time_begin")) {
                c.this.xyY = 0;
                c.this.mStartTime = System.currentTimeMillis();
                c.this.xOJ = System.currentTimeMillis();
            }
            AppMethodBeat.o(80853);
        }

        public final void onResume() {
            AppMethodBeat.i(80854);
            if (c.this.xOJ != 0) {
                c.this.xOJ = System.currentTimeMillis();
            }
            AppMethodBeat.o(80854);
        }

        public final void onPause() {
            AppMethodBeat.i(80855);
            if (c.this.xOJ != 0) {
                c.this.xyY += System.currentTimeMillis() - c.this.xOJ;
            }
            AppMethodBeat.o(80855);
        }
    }

    public static void bl(Bundle bundle) {
        AppMethodBeat.i(80857);
        if (bundle == null) {
            AppMethodBeat.o(80857);
            return;
        }
        Set<String> keySet = bundle.keySet();
        if (keySet == null) {
            AppMethodBeat.o(80857);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : keySet) {
                jSONObject.put(str, bundle.get(str));
            }
            it itVar = new it();
            itVar.dNs.EX = 4;
            itVar.dNs.param = jSONObject.toString();
            EventCenter.instance.publish(itVar);
            AppMethodBeat.o(80857);
        } catch (JSONException e2) {
            AppMethodBeat.o(80857);
        }
    }

    public void an(Bundle bundle) {
    }

    private String baI(String str) {
        AppMethodBeat.i(80858);
        Matcher matcher = Pattern.compile("\\(.*?\\)").matcher(str);
        while (matcher.find()) {
            try {
                String nullAsNil = Util.nullAsNil(matcher.group());
                String replace = nullAsNil.replace("(", "").replace(")", "").replace(" ", "");
                if (replace.contains("__ALLSTAYTIME__")) {
                    String replace2 = replace.replace("__ALLSTAYTIME__", String.valueOf(this.Jqf / 1000));
                    String[] split = replace2.split("\\+");
                    if (split.length == 2) {
                        replace2 = String.valueOf(Util.safeParseLong(split[0]) + Util.safeParseLong(split[1]));
                    }
                    str = str.replace(nullAsNil, replace2);
                } else if (nullAsNil.contains("__FOREGROUNDTIME__")) {
                    String replace3 = replace.replace("__FOREGROUNDTIME__", String.valueOf(this.xyY / 1000));
                    String[] split2 = replace3.split("\\+");
                    if (split2.length == 2) {
                        replace3 = String.valueOf(Util.safeParseLong(split2[0]) + Util.safeParseLong(split2[1]));
                    }
                    str = str.replace(nullAsNil, replace3);
                }
            } catch (NumberFormatException e2) {
                Log.i("MicroMsg.GamePageTimeReport", "matchTimeMark, err:%s", e2.getMessage());
                AppMethodBeat.o(80858);
                return null;
            }
        }
        AppMethodBeat.o(80858);
        return str;
    }

    public static /* synthetic */ void a(c cVar) {
        AppMethodBeat.i(80859);
        if (cVar.mStartTime != 0) {
            cVar.Jqf = System.currentTimeMillis() - cVar.mStartTime;
            Log.i("MicroMsg.GamePageTimeReport", "visit page(%s), stayTime:%sms, foregroundTime:%sms", Integer.valueOf(cVar.hashCode()), Long.valueOf(cVar.Jqf), Long.valueOf(cVar.xyY));
            if (cVar.Jqg == null) {
                Log.i("MicroMsg.GamePageTimeReport", "report game page time fail. ReportData is null");
                AppMethodBeat.o(80859);
                return;
            }
            String string = cVar.Jqg.getString("game_page_report_format_data");
            String string2 = cVar.Jqg.getString("game_page_report_tabs_format_data");
            if (!Util.isNullOrNil(string)) {
                String replace = string.replace("__ALLSTAYTIME__", String.valueOf(cVar.Jqf / 1000)).replace("__FOREGROUNDTIME__", String.valueOf(cVar.xyY / 1000));
                cVar.Jqg.putString("game_page_report_format_data", replace);
                Log.i("MicroMsg.GamePageTimeReport", "visit page(%s), after replace time, reportFormatData:%s", Integer.valueOf(cVar.hashCode()), replace);
            } else if (!Util.isNullOrNil(string2)) {
                String baI = cVar.baI(string2);
                if (!Util.isNullOrNil(baI)) {
                    cVar.Jqg.putString("game_page_report_tabs_format_data", baI);
                    Log.i("MicroMsg.GamePageTimeReport", "visit page(%s), after replace time, reportTabsFormatdata:%s", Integer.valueOf(cVar.hashCode()), baI);
                }
            } else {
                AppMethodBeat.o(80859);
                return;
            }
            if (MMApplicationContext.isMMProcess()) {
                bl(cVar.Jqg);
            } else {
                cVar.an(cVar.Jqg);
            }
            cVar.Jqg = null;
        }
        AppMethodBeat.o(80859);
    }
}
