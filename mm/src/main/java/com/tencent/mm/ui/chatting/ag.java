package com.tencent.mm.ui.chatting;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.pluginsdk.ui.applet.aa;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.span.i;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.e.a;
import java.util.LinkedList;

public final class ag implements i {
    private a dom;

    public ag(a aVar) {
        this.dom = aVar;
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.i
    public final Object a(u uVar) {
        AppMethodBeat.i(34836);
        h.setPayChannel(6);
        switch (uVar.type) {
            case 1:
                String talkerUserName = this.dom.getTalkerUserName();
                AppMethodBeat.o(34836);
                return talkerUserName;
            case 2:
            case 6:
            case 7:
            case 9:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 20:
            case 21:
            case 22:
            case 23:
                this.dom.Pwc.gNh();
                break;
            case 4:
                LinkedList<String> linkedList = new LinkedList<>();
                if (ab.Iw(this.dom.getTalkerUserName())) {
                    int lastIndexOf = uVar.url.lastIndexOf(FilePathGenerator.ANDROID_DIR_SEP);
                    if (lastIndexOf >= 0) {
                        linkedList.add(uVar.url.substring(lastIndexOf + 1));
                    }
                } else {
                    linkedList.add(this.dom.getTalkerUserName());
                }
                LinkedList<Integer> linkedList2 = new LinkedList<>();
                for (int i2 = 0; i2 < linkedList.size(); i2++) {
                    linkedList2.add(6);
                }
                new aa(this.dom.Pwc.getContext(), new aa.a() {
                    /* class com.tencent.mm.ui.chatting.ag.AnonymousClass1 */

                    @Override // com.tencent.mm.pluginsdk.ui.applet.aa.a
                    /* renamed from: do  reason: not valid java name */
                    public final void m40do(boolean z) {
                    }
                }).a(linkedList, linkedList2, null);
                break;
            case 25:
            case 30:
            case 31:
            case 33:
                String talkerUserName2 = this.dom.getTalkerUserName();
                AppMethodBeat.o(34836);
                return talkerUserName2;
        }
        AppMethodBeat.o(34836);
        return null;
    }

    @Override // com.tencent.mm.pluginsdk.ui.span.i
    public final Object b(u uVar) {
        AppMethodBeat.i(34837);
        switch (uVar.type) {
            case 45:
                if (bg.aAc()) {
                    if (!g.DQ(this.dom.getTalkerUserName())) {
                        if (!g.Ng(this.dom.getTalkerUserName())) {
                            if (g.Nf(this.dom.getTalkerUserName())) {
                                AppMethodBeat.o(34837);
                                break;
                            }
                        } else {
                            AppMethodBeat.o(34837);
                            break;
                        }
                    } else {
                        AppMethodBeat.o(34837);
                        break;
                    }
                }
                String str = new String(Base64.decode(uVar.url, 0));
                String str2 = new String(Base64.decode(Util.nullAs((String) uVar.ba(String.class), ""), 0));
                Log.i("MicroMsg.MMChattingSpanClickCallback", "appId:%s,path:%s", str, str2);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1082;
                appBrandStatObject.dCw = this.dom.getTalkerUserName() + "|1";
                ((r) com.tencent.mm.kernel.g.af(r.class)).a(this.dom.Pwc.getContext(), (String) null, str, 0, 0, str2, appBrandStatObject);
            default:
                AppMethodBeat.o(34837);
                break;
        }
        return null;
    }
}
