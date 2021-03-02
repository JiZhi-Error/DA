package com.tencent.mm.plugin.wear.model.g;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aar;
import com.tencent.mm.plugin.wear.ui.WearYoLockUI;
import com.tencent.mm.plugin.wear.ui.WearYoNoLockUI;
import com.tencent.mm.protocal.protobuf.ezx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class a {
    private KeyguardManager IxK = ((KeyguardManager) MMApplicationContext.getContext().getSystemService("keyguard"));
    LinkedHashMap<String, C1931a> IyJ = new LinkedHashMap<>();
    private PowerManager powerManager = ((PowerManager) MMApplicationContext.getContext().getSystemService("power"));

    public a() {
        AppMethodBeat.i(30135);
        AppMethodBeat.o(30135);
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.g.a$a  reason: collision with other inner class name */
    class C1931a {
        String content;
        String dkU;

        public C1931a(String str, String str2) {
            this.dkU = str;
            this.content = str2;
        }
    }

    public static aar aWq(String str) {
        AppMethodBeat.i(30136);
        aar aar = new aar();
        aar.ehE.dDe = 1;
        aar.ehE.username = str;
        EventCenter.instance.publish(aar);
        AppMethodBeat.o(30136);
        return aar;
    }

    public final void fWh() {
        C1931a aVar;
        boolean z;
        AppMethodBeat.i(30137);
        if (aWq(null).ehF.ehG != 0) {
            Log.i("MicroMsg.wear.WearYoLogic", "current show yo");
            AppMethodBeat.o(30137);
            return;
        }
        synchronized (this.IyJ) {
            try {
                Iterator<Map.Entry<String, C1931a>> it = this.IyJ.entrySet().iterator();
                if (it.hasNext()) {
                    aVar = it.next().getValue();
                } else {
                    aVar = null;
                }
                if (aVar != null) {
                    this.IyJ.remove(aVar.dkU);
                }
            } finally {
                AppMethodBeat.o(30137);
            }
        }
        if (aVar != null) {
            String str = aVar.content;
            ezx ezx = new ezx();
            Map<String, String> parseXml = XmlParser.parseXml(str, "msg", null);
            if (parseXml == null) {
                ezx.oUv = 0;
            } else {
                ezx.oUv = Util.getInt(parseXml.get(".msg.yo.$type"), 0);
                ezx.oTz = Util.getInt(parseXml.get(".msg.yo.$count"), 0);
            }
            Intent intent = new Intent();
            intent.putExtra("key_talker", aVar.dkU);
            try {
                intent.putExtra("key_data", ezx.toByteArray());
            } catch (IOException e2) {
            }
            intent.addFlags(268435456);
            if (this.IxK.inKeyguardRestrictedInputMode() || !this.powerManager.isScreenOn()) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                intent.setClass(MMApplicationContext.getContext(), WearYoLockUI.class);
            } else {
                intent.setClass(MMApplicationContext.getContext(), WearYoNoLockUI.class);
            }
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/wear/model/yo/WearYoLogic", "publishNextYoMessage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/wear/model/yo/WearYoLogic", "publishNextYoMessage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
    }
}
