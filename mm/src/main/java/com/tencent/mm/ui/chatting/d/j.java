package com.tencent.mm.ui.chatting.d;

import android.content.Context;
import android.net.Uri;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.byp.b.a;
import com.tencent.mm.plugin.game.protobuf.aa;
import com.tencent.mm.plugin.game.protobuf.h;
import com.tencent.mm.plugin.game.protobuf.k;
import com.tencent.mm.plugin.gamelife.a.b;
import com.tencent.mm.plugin.gamelife.a.d;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.plugin.websearch.PluginWebSearch;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.chatting.d.a.a;
import com.tencent.mm.ui.chatting.d.b.i;
import com.tencent.mm.ui.chatting.d.b.u;
import com.tencent.mm.ui.widget.cedit.api.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@a(gRF = i.class)
class j extends a implements i {
    j() {
    }

    @Override // com.tencent.mm.ui.chatting.d.b.i
    public final boolean gPw() {
        AppMethodBeat.i(233067);
        boolean bju = as.bju(this.dom.getTalkerUserName());
        AppMethodBeat.o(233067);
        return bju;
    }

    @Override // com.tencent.mm.ui.chatting.d.b.i
    public final void gPx() {
        AppMethodBeat.i(233068);
        this.dom.Pwc.setMMTitle(this.dom.GUe.arJ());
        String avi = ((f) g.af(f.class)).avi(this.dom.getTalkerUserName());
        if (TextUtils.isEmpty(avi)) {
            Log.e("GameLife.ChattingComponent", "talker username get failed!");
            AppMethodBeat.o(233068);
            return;
        }
        com.tencent.mm.plugin.gamelife.a.a aAR = ((b) g.af(b.class)).aAR(avi);
        if (aAR == null) {
            Log.e("GameLife.ChattingComponent", "talker contact get failed!");
            AppMethodBeat.o(233068);
            return;
        }
        if (!TextUtils.isEmpty(aAR.getTag()) && aAR.dWY() == 1) {
            this.dom.Pwc.setMMSubTitle(aAR.getTag());
        }
        AppMethodBeat.o(233068);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIm() {
        ArrayList<a.C2027a> arrayList;
        AppMethodBeat.i(233069);
        super.gIm();
        if (!gPw()) {
            AppMethodBeat.o(233069);
            return;
        }
        final com.tencent.mm.plugin.gamelife.a.a aAR = ((b) g.af(b.class)).aAR(this.dom.gRI());
        if (aAR == null) {
            Log.e("GameLife.ChattingComponent", "self contact get failed!");
        } else {
            final ChatFooter gPO = ((u) this.dom.bh(u.class)).gPO();
            if (gPO != null) {
                final c cVar = (c) this.dom.findViewById(R.id.auj);
                cVar.refresh(((PluginWebSearch) g.ah(PluginWebSearch.class)).isUseSysEditText());
                cVar.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    /* class com.tencent.mm.ui.chatting.d.j.AnonymousClass1 */

                    public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                        StringBuilder sb;
                        AppMethodBeat.i(233064);
                        int gYL = cVar.gYL();
                        if (gYL < 0) {
                            AppMethodBeat.o(233064);
                            return;
                        }
                        int fromDPToPix = gYL - com.tencent.mm.cb.a.fromDPToPix((Context) j.this.dom.Pwc.getContext(), 52);
                        String str = null;
                        if (!TextUtils.isEmpty(aAR.getTag()) && aAR.dWY() == 1) {
                            str = String.format(" (%s)", aAR.getTag());
                        }
                        String nullAsNil = Util.nullAsNil(aAR.dWW().field_nickname);
                        if (str != null) {
                            nullAsNil = nullAsNil + str;
                        }
                        float desiredWidth = Layout.getDesiredWidth(nullAsNil + " : ", cVar.getPaint());
                        StringBuilder sb2 = new StringBuilder();
                        String str2 = aAR.dWW().field_nickname;
                        if (str2 == null || desiredWidth <= ((float) fromDPToPix)) {
                            sb2.append(str2);
                            sb = sb2;
                        } else {
                            String hm = com.tencent.mm.ui.tools.f.hm(str2, str == null ? 20 : 12);
                            if (Character.isHighSurrogate(hm.charAt(hm.length() - 1))) {
                                hm = hm.substring(0, hm.length() - 1);
                            }
                            sb = sb2.append(hm).append("...");
                        }
                        if (str != null) {
                            sb.append(str);
                        }
                        if (sb.length() != 0) {
                            sb.append(" : ");
                        }
                        gPO.a(j.this.dom.gRI(), Boolean.FALSE, l.c(j.this.dom.Pwc.getContext(), sb));
                        cVar.removeOnLayoutChangeListener(this);
                        AppMethodBeat.o(233064);
                    }
                });
            }
        }
        ChatFooter gPO2 = ((u) this.dom.bh(u.class)).gPO();
        if (gPO2 != null) {
            k dSZ = com.tencent.mm.plugin.game.commlib.a.dSZ();
            if (dSZ == null) {
                arrayList = null;
            } else {
                String avi = ((f) g.af(f.class)).avi(this.dom.getTalkerUserName());
                if (TextUtils.isEmpty(avi)) {
                    arrayList = null;
                } else {
                    ArrayList<a.C2027a> arrayList2 = new ArrayList<>(dSZ.xJi.size());
                    Iterator<h> it = dSZ.xJi.iterator();
                    while (it.hasNext()) {
                        final h next = it.next();
                        if (next.xJa != 0) {
                            a.C2027a aVar = new a.C2027a();
                            aVar.KhQ = next.pLn;
                            aVar.KhR = next.xIZ ? 1 : 0;
                            aVar.uSc = next.xJa == 1 ? 1 : 2;
                            if (next.xJa == 1 && next.xJb != null) {
                                aVar.KhT = next.xJb.jfi;
                                String str = next.xJb.xut;
                                String gRI = this.dom.gRI();
                                if (!(gRI == null || avi == null)) {
                                    String format = String.format("from_username=%s&to_username=%s", q.encode(gRI), q.encode(avi));
                                    str = TextUtils.isEmpty(str) ? "?".concat(String.valueOf(format)) : str.contains("?") ? str.endsWith("?") ? str + format : String.format("%s&%s", str, format) : String.format("%s?%s", str, format);
                                }
                                aVar.KhV = str;
                                aVar.KhW = String.valueOf(next.xJb.xMC);
                            } else if (next.xJa == 2) {
                                String str2 = next.xIy;
                                String gRI2 = this.dom.gRI();
                                if (!(Util.isNullOrNil(str2) || gRI2 == null || avi == null)) {
                                    Uri.Builder buildUpon = Uri.parse(str2).buildUpon();
                                    buildUpon.appendQueryParameter("from_username", gRI2);
                                    buildUpon.appendQueryParameter("to_username", avi);
                                    str2 = buildUpon.build().toString();
                                }
                                aVar.nnB = str2;
                                aVar.Kif = next.xJf;
                                if (!Util.isNullOrNil(aVar.nnB) && aVar.Kif != 0) {
                                    com.tencent.mm.plugin.game.luggage.h.a(com.tencent.mm.plugin.game.luggage.i.class, aVar.nnB, null);
                                }
                            }
                            Iterator<aa> it2 = next.xJc.iterator();
                            while (it2.hasNext()) {
                                aa next2 = it2.next();
                                if (next2.rBI != null) {
                                    a.b bVar = new a.b();
                                    bVar.title = next2.Title;
                                    bVar.desc = next2.Desc;
                                    String str3 = next2.rBI;
                                    char c2 = 65535;
                                    switch (str3.hashCode()) {
                                        case 3241:
                                            if (str3.equals(LocaleUtil.ENGLISH)) {
                                                c2 = 3;
                                                break;
                                            }
                                            break;
                                        case 115861276:
                                            if (str3.equals(LocaleUtil.CHINA)) {
                                                c2 = 0;
                                                break;
                                            }
                                            break;
                                        case 115861428:
                                            if (str3.equals(LocaleUtil.HONGKONG)) {
                                                c2 = 2;
                                                break;
                                            }
                                            break;
                                        case 115861812:
                                            if (str3.equals(LocaleUtil.TAIWAN)) {
                                                c2 = 1;
                                                break;
                                            }
                                            break;
                                    }
                                    switch (c2) {
                                        case 0:
                                            aVar.KhX = bVar;
                                            break;
                                        case 1:
                                            aVar.KhZ = bVar;
                                            break;
                                        case 2:
                                            aVar.KhY = bVar;
                                            break;
                                        case 3:
                                            aVar.Kia = bVar;
                                            break;
                                    }
                                }
                            }
                            aVar.iconUrl = next.IconUrl;
                            aVar.Kib = next.xJd;
                            aVar.Kid = 56;
                            aVar.Kic = 56;
                            aVar.Kig = new a.C2027a.AbstractC2028a() {
                                /* class com.tencent.mm.ui.chatting.d.j.AnonymousClass2 */

                                @Override // com.tencent.mm.pluginsdk.ui.chat.a.C2027a.AbstractC2028a
                                public final String gqg() {
                                    AppMethodBeat.i(233065);
                                    String ek = ((d) g.af(d.class)).ek(j.this.dom.getTalkerUserName(), next.xIY);
                                    AppMethodBeat.o(233065);
                                    return ek;
                                }
                            };
                            Log.i("GameLife.ChattingComponent", "add AppPanel: enter_id[%s] red_dot[%d] appid[%s] url[%s] title[%s] type[%d]", aVar.KhQ, Integer.valueOf(aVar.KhR), aVar.KhT, aVar.nnB, aVar.KhX.title, Integer.valueOf(next.xIY));
                            arrayList2.add(aVar);
                        }
                    }
                    arrayList = arrayList2;
                }
            }
            gPO2.setAppPanelUnCertainEnterArrayList(arrayList);
            gPO2.gqW();
        }
        ((com.tencent.mm.plugin.gamelife.a.c) g.af(com.tencent.mm.plugin.gamelife.a.c.class)).ave(this.dom.getTalkerUserName());
        if (!Util.isNullOrNil(this.dom.getTalkerUserName())) {
            com.tencent.f.h.RTc.aY(new Runnable() {
                /* class com.tencent.mm.ui.chatting.d.j.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(233066);
                    List<ca> fw = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().fw(Collections.singletonList("gamelifemessage"));
                    for (ca caVar : fw) {
                        a.C0899a aVar = com.tencent.mm.plugin.byp.b.a.pPx;
                        if (!com.tencent.mm.plugin.byp.b.a.pPw.contains(Long.valueOf(caVar.field_msgId))) {
                            caVar.setStatus(5);
                            ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(caVar.field_msgId, caVar);
                        }
                    }
                    Log.i("GameLife.ChattingComponent", "sending msg size=%s talker=%s username=%s", Integer.valueOf(fw.size()), j.this.dom.gOZ(), j.this.dom.getTalkerUserName());
                    AppMethodBeat.o(233066);
                }
            });
        }
        AppMethodBeat.o(233069);
    }

    @Override // com.tencent.mm.ui.m, com.tencent.mm.ui.chatting.d.a
    public final void gIn() {
        AppMethodBeat.i(233070);
        super.gIn();
        if (!gPw()) {
            AppMethodBeat.o(233070);
            return;
        }
        ((com.tencent.mm.plugin.gamelife.a.c) g.af(com.tencent.mm.plugin.gamelife.a.c.class)).ave(this.dom.getTalkerUserName());
        com.tencent.mm.plugin.game.luggage.h.destroy();
        AppMethodBeat.o(233070);
    }
}
