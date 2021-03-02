package com.tencent.mm.console.a;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public final class k implements a {
    static {
        AppMethodBeat.i(20188);
        b.a(new k(), "//version");
        AppMethodBeat.o(20188);
    }

    public static void init() {
    }

    @Override // com.tencent.mm.pluginsdk.cmd.a
    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(20187);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("[ver  ] %s %08X\n", ChannelUtil.formatVersion(context, d.KyO, true), Integer.valueOf(d.KyO)));
        sb.append(BuildInfo.info());
        sb.append(String.format("[cid  ] %d\n", Integer.valueOf(ChannelUtil.channelId)));
        sb.append(String.format("[s.ver] %d\n", Integer.valueOf(ai.aft(0))));
        sb.append(String.format("[l.ver] %d %s\n", Integer.valueOf(ai.aft(1)), ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getWebViewType()));
        sb.append(String.format("[w.ver] %d\n", Integer.valueOf(ai.aft(3))));
        sb.append(String.format("[b.ver] %d\n", Integer.valueOf(ai.aft(2))));
        sb.append(String.format("[r.ver] %s\n", BuildInfo.CLIENT_VERSION));
        if (BuildInfo.EX_DEVICE_LOGIN) {
            try {
                Map<String, String> parseXml = XmlParser.parseXml(Util.convertStreamToString(context.getAssets().open("merged_features.xml")), "merged", null);
                if (parseXml != null) {
                    int i2 = 0;
                    while (true) {
                        String str2 = parseXml.get(".merged.feature" + (i2 > 0 ? String.valueOf(i2) : ""));
                        if (str2 == null) {
                            break;
                        }
                        sb.append(String.format("[feature#%02d] %s\n", Integer.valueOf(i2), str2));
                        i2++;
                    }
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Version", e2, "", new Object[0]);
            }
        }
        TextView textView = new TextView(context);
        textView.setText(sb);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        textView.setTextColor(context.getResources().getColor(R.color.FG_0));
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.hs);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        h.a(context, (String) null, textView, (DialogInterface.OnClickListener) null);
        AppMethodBeat.o(20187);
        return true;
    }
}
