package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public final class f {
    public int Kbq = -7829368;
    public boolean Kbr = false;
    public int Kbs = -1593835521;
    public boolean Kbt = false;
    public boolean Kbu = false;
    private int Kbv = WebView.NIGHT_MODE_COLOR;
    public boolean Kbw = false;
    public int Kbx = 0;
    public boolean Kby = false;
    private int version = 0;

    public f(String str, Context context) {
        AppMethodBeat.i(141159);
        Map<String, String> parseXml = XmlParser.parseXml(str, "chatbg", null);
        if (parseXml == null) {
            Log.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed, values is null");
            AppMethodBeat.o(141159);
            return;
        }
        String concat = ".".concat(String.valueOf("chatbg"));
        try {
            this.version = Util.nullAsNil(Integer.valueOf(parseXml.get(concat + ".$version")));
            this.Kbq = (int) Util.nullAs(Long.valueOf(Long.parseLong(parseXml.get(concat + ".$time_color"), 16)), (long) context.getResources().getColor(R.color.FG_2));
            this.Kbr = Util.nullAsFalse(Boolean.valueOf(parseXml.get(concat + ".$time_show_shadow_color")));
            this.Kbs = (int) Util.nullAs(Long.valueOf(Long.parseLong(parseXml.get(concat + ".$time_shadow_color"), 16)), 0);
            this.Kbt = Util.nullAsFalse(Boolean.valueOf(parseXml.get(concat + ".$time_show_background")));
            this.Kbu = Util.nullAsFalse(Boolean.valueOf(parseXml.get(concat + ".$time_light_background")));
            this.Kbv = (int) Util.nullAs(Long.valueOf(Long.parseLong(parseXml.get(concat + ".$voice_second_color"), 16)), -16777216);
            this.Kbw = Util.nullAsFalse(Boolean.valueOf(parseXml.get(concat + ".$voice_second_show_shadow_color")));
            this.Kbx = (int) Util.nullAs(Long.valueOf(Long.parseLong(parseXml.get(concat + ".$voice_second_shadow_color"), 16)), 0);
            this.Kby = Util.nullAsFalse(Boolean.valueOf(parseXml.get(concat + ".$voice_second_show_background")));
            AppMethodBeat.o(141159);
        } catch (Exception e2) {
            Log.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed");
            Log.printErrStackTrace("MicroMsg.ChatBgAttr", e2, "", new Object[0]);
            AppMethodBeat.o(141159);
        }
    }
}
