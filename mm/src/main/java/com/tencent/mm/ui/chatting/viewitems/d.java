package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.yj;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelappbrand.d;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.dwq;
import com.tencent.mm.protocal.protobuf.dwr;
import com.tencent.mm.protocal.protobuf.fdy;
import com.tencent.mm.protocal.protobuf.fey;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.appbrand.b;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class d extends c {
    private static final String PHp = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d#wechat_redirect");
    private q Fxt;
    private c Oxy;
    private View.OnClickListener PHq;
    private View.OnClickListener PHr;
    private View.OnTouchListener PHs;
    private g PHt;
    private boolean PHu;
    private int[] PHv = new int[2];
    private com.tencent.mm.ui.chatting.e.a PhN;
    private q gxX;
    private int rGT;
    private View.OnClickListener rID;

    static /* synthetic */ void a(d dVar, int i2, String str, String str2, String str3, String str4, int i3) {
        AppMethodBeat.i(233580);
        dVar.d(i2, str, str2, str3, str4, i3);
        AppMethodBeat.o(233580);
    }

    static {
        AppMethodBeat.i(233585);
        AppMethodBeat.o(233585);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTT() {
        return false;
    }

    public d() {
        AppMethodBeat.i(233571);
        c.a aVar = new c.a();
        aVar.iaT = true;
        aVar.jbq = R.drawable.bar;
        this.Oxy = aVar.bdv();
        com.tencent.mm.kernel.g.aAf();
        this.rGT = com.tencent.mm.kernel.a.getUin();
        this.PHt = (g) com.tencent.mm.kernel.g.af(g.class);
        this.PHq = new a(this, (byte) 0);
        this.PHr = new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.d.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(233555);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.ag.a.a aVar = (com.tencent.mm.ag.a.a) view.getTag();
                Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", aVar.username);
                d.a(d.this, aVar.username, aVar.appId);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(233555);
            }
        };
        this.rID = new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.d.AnonymousClass3 */

            public final void onClick(View view) {
                String str;
                AppMethodBeat.i(233557);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (d.this.PHt != null) {
                    str = d.this.PHt.bul();
                } else {
                    str = null;
                }
                int a2 = d.a(d.this, ((Integer) view.getTag(R.id.geq)).intValue());
                com.tencent.mm.ag.a.a HK = com.tencent.mm.ag.a.a.HK(((bq) view.getTag()).dTX.field_content);
                String nullAsNil = Util.nullAsNil(HK.appId);
                String nullAsNil2 = Util.nullAsNil(HK.msgId);
                String nullAsNil3 = Util.nullAsNil(HK.dCx);
                String nullAsNil4 = Util.nullAsNil(HK.username);
                int i2 = HK.version;
                int i3 = HK.type;
                String HL = com.tencent.mm.ag.a.a.HL(HK.title);
                Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) container click", nullAsNil4);
                com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                gVar.username = nullAsNil4;
                gVar.iOo = i3;
                gVar.version = i2;
                gVar.kHw = nullAsNil3;
                gVar.dCw = "1162:" + nullAsNil2 + ":" + HL;
                gVar.scene = 1162;
                AppBrandLaunchFromNotifyReferrer appBrandLaunchFromNotifyReferrer = new AppBrandLaunchFromNotifyReferrer();
                appBrandLaunchFromNotifyReferrer.appId = Util.nullAsNil(nullAsNil);
                appBrandLaunchFromNotifyReferrer.uin = d.this.rGT;
                appBrandLaunchFromNotifyReferrer.lej = 2;
                appBrandLaunchFromNotifyReferrer.lek = Util.nullAsNil(nullAsNil2);
                appBrandLaunchFromNotifyReferrer.content = HL;
                appBrandLaunchFromNotifyReferrer.lel = a2;
                appBrandLaunchFromNotifyReferrer.lem = str;
                gVar.kHI = appBrandLaunchFromNotifyReferrer;
                ((r) com.tencent.mm.kernel.g.af(r.class)).a(d.this.PhN.Pwc.getContext(), gVar);
                ((com.tencent.mm.ui.chatting.d.b.g) d.this.PhN.bh(com.tencent.mm.ui.chatting.d.b.g.class)).amz(a2);
                d.a(d.this, 4, nullAsNil, nullAsNil2, nullAsNil3, (String) null, a2);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(233557);
            }
        };
        this.PHs = new View.OnTouchListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.d.AnonymousClass4 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(233558);
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        d.this.PHv[0] = (int) motionEvent.getRawX();
                        d.this.PHv[1] = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(233558);
                return false;
            }
        };
        AppMethodBeat.o(233571);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean bM(int i2, boolean z) {
        return i2 == 872415281;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(233572);
        if (view == null || view.getTag() == null) {
            view = layoutInflater.inflate(R.layout.qj, (ViewGroup) null);
            view.setTag(new bw().hi(view));
        }
        AppMethodBeat.o(233572);
        return view;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTU() {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
        String nullAsNil;
        String nullAsNil2;
        AppMethodBeat.i(233573);
        this.PhN = aVar2;
        bw bwVar = (bw) aVar;
        com.tencent.mm.ag.a.a HK = com.tencent.mm.ag.a.a.HK(caVar.field_content);
        if (caVar.field_isSend == 2) {
            bwVar.PRF.setVisibility(0);
            bwVar.timeTV.setVisibility(8);
        } else {
            bwVar.PRF.setVisibility(8);
        }
        ca amt = ((k) this.PhN.bh(k.class)).amt(0);
        if (amt != null && amt.field_isSend == 2) {
            ((k) this.PhN.bh(k.class)).amv(1);
        }
        if (caVar.field_isSend == 2) {
            bwVar.PRG.setVisibility(8);
        } else {
            bwVar.PRG.setVisibility(0);
            WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(HK.username);
            if (Xk == null || Util.isNullOrNil(Xk.field_brandIconURL) || Util.isNullOrNil(Xk.field_nickname)) {
                nullAsNil = Util.nullAsNil(HK.iconUrl);
                nullAsNil2 = Util.nullAsNil(HK.nickname);
            } else {
                nullAsNil = Xk.field_brandIconURL;
                nullAsNil2 = Xk.field_nickname;
            }
            String nullAsNil3 = Util.nullAsNil(HK.username);
            bwVar.gyr.setTag(null);
            bwVar.pIN.setText(l.b(this.PhN.Pwc.getContext(), nullAsNil2, bwVar.pIN.getTextSize()));
            bwVar.pIN.setTag(HK);
            com.tencent.mm.av.q.bcV().a(nullAsNil, bwVar.gyr, this.Oxy);
            bwVar.gyr.setTag(new bq(caVar, (String) null));
            bwVar.gyr.setTag(R.id.geq, Integer.valueOf(i2));
            bwVar.gyr.setOnClickListener(this.rID);
            bwVar.gyr.setOnLongClickListener(null);
            bwVar.gyr.setContentDescription(aa.getDisplayName(nullAsNil3) + this.PhN.Pwc.getContext().getString(R.string.a4u));
            if (!Boolean.valueOf(((g) com.tencent.mm.kernel.g.af(g.class)).cp(HK.appId + "#NotifyMessageStatus", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)).booleanValue()) {
                bwVar.PRH.setVisibility(0);
                this.PHu = true;
            } else {
                bwVar.PRH.setVisibility(8);
                this.PHu = false;
            }
            bwVar.PRI.setTag(caVar);
            bwVar.PRI.setTag(R.id.geq, Integer.valueOf(i2));
            bwVar.PRI.setOnClickListener(this.PHq);
        }
        if (caVar.field_isSend != 2) {
            bwVar.titleTv.setText(Util.nullAsNil(HK.title));
            bwVar.PRG.setOnClickListener(this.rID);
            bwVar.PRG.setTag(new bq(caVar, (String) null));
            bwVar.PRG.setLongClickable(true);
            bwVar.PRG.setTag(R.id.iu_, this.PHv);
            bwVar.PRG.setTag(R.id.geq, Integer.valueOf(i2));
            bwVar.PRG.setOnLongClickListener(c(this.PhN));
            bwVar.PRG.setOnTouchListener(this.PHs);
        }
        AppMethodBeat.o(233573);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(m mVar, View view, ca caVar) {
        AppMethodBeat.i(233574);
        bq bqVar = (bq) view.getTag();
        if (bqVar == null) {
            AppMethodBeat.o(233574);
            return false;
        }
        mVar.a(bqVar.position, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
        AppMethodBeat.o(233574);
        return true;
    }

    /* access modifiers changed from: package-private */
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTV() {
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTX() {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        AppMethodBeat.i(233575);
        switch (menuItem.getItemId()) {
            case 100:
                com.tencent.mm.ag.a.a HK = com.tencent.mm.ag.a.a.HK(caVar.field_content);
                ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hc(caVar.field_msgId);
                d(9, Util.nullAsNil(HK.appId), Util.nullAsNil(HK.msgId), Util.nullAsNil(HK.dCx), null, 0);
                break;
        }
        AppMethodBeat.o(233575);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final void a(c.a aVar, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
        AppMethodBeat.i(233576);
        if (str == null || aVar.userTV == null) {
            AppMethodBeat.o(233576);
            return;
        }
        a(aVar, l.b(aVar2.Pwc.getContext(), ((f) aVar2.bh(f.class)).bmF(str), aVar.userTV.getTextSize()));
        AppMethodBeat.o(233576);
    }

    private void d(int i2, String str, String str2, String str3, String str4, int i3) {
        AppMethodBeat.i(233577);
        String str5 = null;
        if (this.PHt != null) {
            str5 = this.PHt.bul();
        }
        Log.d("MicroMsg.ChattingItemAppBrandNotifyMsg", "appbrand notify report(%d), eventId : %d, appId %s, msgId %s, pagePath %s, label %s", 19724, Integer.valueOf(i2), str, str2, str3, str4);
        h.INSTANCE.a(19724, 1, Integer.valueOf(i2), 0, Integer.valueOf(i3), 0, null, 0, 0, 0, str, str3, str4, str2, 0, null, null, 0, null, null, str5);
        AppMethodBeat.o(233577);
    }

    final class a implements View.OnClickListener {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b2) {
            this();
        }

        public final void onClick(final View view) {
            AppMethodBeat.i(233570);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            final ca caVar = (ca) view.getTag();
            final int intValue = ((Integer) view.getTag(R.id.geq)).intValue();
            Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener onclick");
            if (caVar == null) {
                Log.w("MicroMsg.ChattingItemAppBrandNotifyMsg", "AppBrandNotityMsgMoreViewClickListener, on more view click, but msg is null.");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(233570);
                return;
            }
            com.tencent.mm.ag.a.a HK = com.tencent.mm.ag.a.a.HK(caVar.field_content);
            final String nullAsNil = Util.nullAsNil(HK.appId);
            final String nullAsNil2 = Util.nullAsNil(HK.dCx);
            final String nullAsNil3 = Util.nullAsNil(HK.nickname);
            final String nullAsNil4 = Util.nullAsNil(HK.msgId);
            final com.tencent.mm.ui.appbrand.b bVar2 = new com.tencent.mm.ui.appbrand.b(view.getContext(), d.this.PHu ? 1 : 0, HK.username);
            bVar2.OMR = new b.a() {
                /* class com.tencent.mm.ui.chatting.viewitems.d.a.AnonymousClass1 */

                @Override // com.tencent.mm.ui.appbrand.b.a
                public final void gKh() {
                    AppMethodBeat.i(233566);
                    bVar2.dismiss();
                    List<b.C2076b> list = bVar2.OMQ;
                    StringBuilder sb = new StringBuilder();
                    for (b.C2076b bVar : list) {
                        if (bVar.pWp) {
                            sb.append(bVar.OMU).append(":");
                        }
                    }
                    if (sb.length() > 0) {
                        sb.setLength(sb.length() - 1);
                    }
                    d.a(d.this, nullAsNil3, nullAsNil, nullAsNil4, nullAsNil2, sb.toString(), intValue);
                    AppMethodBeat.o(233566);
                }

                @Override // com.tencent.mm.ui.appbrand.b.a
                public final void gKi() {
                    AppMethodBeat.i(233567);
                    bVar2.dismiss();
                    d.a(d.this, view, nullAsNil);
                    final s sVar = new s(caVar.field_content);
                    d dVar = d.this;
                    Context context = view.getContext();
                    view.getResources().getString(R.string.zb);
                    dVar.Fxt = com.tencent.mm.ui.base.h.a(context, view.getResources().getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.ui.chatting.viewitems.d.a.AnonymousClass1.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(233565);
                            bg.azz().a(sVar);
                            AppMethodBeat.o(233565);
                        }
                    });
                    bg.azz().a(sVar, 0);
                    d.a(d.this, 3, nullAsNil, nullAsNil4, nullAsNil2, (String) null, d.a(d.this, intValue));
                    AppMethodBeat.o(233567);
                }

                @Override // com.tencent.mm.ui.appbrand.b.a
                public final void gKj() {
                    AppMethodBeat.i(233568);
                    bVar2.dismiss();
                    ((com.tencent.mm.plugin.messenger.foundation.a.l) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hc(caVar.field_msgId);
                    AppMethodBeat.o(233568);
                }

                @Override // com.tencent.mm.ui.appbrand.b.a
                public final void gKk() {
                    AppMethodBeat.i(233569);
                    bVar2.dismiss();
                    com.tencent.mm.ag.a.a HK = com.tencent.mm.ag.a.a.HK(caVar.field_content);
                    Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "on app brand(%s) name click", HK.username);
                    com.tencent.mm.br.c.b(view.getContext(), "appbrand", ".ui.AppBrandAuthorizeUI", new Intent().putExtra("key_username", HK.username));
                    AppMethodBeat.o(233569);
                }
            };
            bVar2.gv(view);
            d.a(d.this, 7, nullAsNil, nullAsNil4, nullAsNil2, (String) null, d.a(d.this, intValue));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$AppBrandNotifyMsgMoreViewClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(233570);
        }
    }

    static /* synthetic */ void a(d dVar, String str, String str2) {
        AppMethodBeat.i(233578);
        Intent intent = new Intent();
        intent.putExtra("key_username", str);
        intent.putExtra("key_from_scene", 5);
        WxaExposedParams.a aVar = new WxaExposedParams.a();
        aVar.appId = str2;
        aVar.from = 6;
        intent.putExtra("key_scene_exposed_params", aVar.bAv());
        com.tencent.mm.br.c.b(dVar.PhN.Pwc.getContext(), "appbrand", ".ui.AppBrandProfileUI", intent);
        AppMethodBeat.o(233578);
    }

    static /* synthetic */ int a(d dVar, int i2) {
        AppMethodBeat.i(233579);
        int max = Math.max(0, ((k) dVar.PhN.bh(k.class)).getCount() - i2);
        AppMethodBeat.o(233579);
        return max;
    }

    static /* synthetic */ void g(d dVar) {
        AppMethodBeat.i(233581);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.chatting.viewitems.d.AnonymousClass7 */

            public final void run() {
                AppMethodBeat.i(233561);
                if (d.this.gxX != null && d.this.gxX.isShowing()) {
                    d.this.gxX.dismiss();
                }
                AppMethodBeat.o(233561);
            }
        });
        AppMethodBeat.o(233581);
    }

    static /* synthetic */ void a(d dVar, String str, final String str2, final String str3, final String str4, final String str5, final int i2) {
        AppMethodBeat.i(233582);
        final e eVar = new e((Context) dVar.PhN.Pwc.getContext(), 1, true);
        eVar.Dm(true);
        Resources resources = dVar.PhN.Pwc.getContext().getResources();
        View inflate = LayoutInflater.from(dVar.PhN.Pwc.getContext()).inflate(R.layout.q0, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.iqz);
        textView.setText(String.format(resources.getString(R.string.ax4), str));
        textView.setTextSize(1, 14.0f);
        eVar.V(inflate, true);
        View inflate2 = LayoutInflater.from(dVar.PhN.Pwc.getContext()).inflate(R.layout.pz, (ViewGroup) null);
        inflate2.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.d.AnonymousClass9 */

            public final void onClick(View view) {
                AppMethodBeat.i(233563);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                eVar.bMo();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppBrandNotifyMsg$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(233563);
            }
        });
        eVar.setFooterView(inflate2);
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.ui.chatting.viewitems.d.AnonymousClass10 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(233564);
                mVar.a(0, d.this.PhN.Pwc.getMMResources().getColor(R.color.a5e), d.this.PhN.Pwc.getMMResources().getString(R.string.axe));
                AppMethodBeat.o(233564);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.ui.chatting.viewitems.d.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(233556);
                switch (menuItem.getItemId()) {
                    case 0:
                        d.a(d.this, str2);
                        d.a(d.this, 2, str2, str3, str4, str5, d.a(d.this, i2));
                        break;
                }
                AppMethodBeat.o(233556);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(233582);
    }

    static /* synthetic */ void a(d dVar, final View view, final String str) {
        AppMethodBeat.i(233583);
        bg.azz().a(1198, new i() {
            /* class com.tencent.mm.ui.chatting.viewitems.d.AnonymousClass5 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                AppMethodBeat.i(233559);
                bg.azz().b(1198, this);
                Log.d("MicroMsg.ChattingItemAppBrandNotifyMsg", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.FALSE);
                if (d.this.Fxt != null) {
                    d.this.Fxt.dismiss();
                    d.this.Fxt = null;
                }
                if (i2 == 0 && i3 == 0) {
                    fey aXR = ((s) qVar).aXR();
                    if (aXR == null) {
                        u.makeText(view.getContext(), (int) R.string.fh8, 0).show();
                        AppMethodBeat.o(233559);
                        return;
                    }
                    String str2 = aXR.NAn;
                    Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", str);
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        Log.i("MicroMsg.ChattingItemAppBrandNotifyMsg", "appId(%s) or msgId(%s) is null or nil.", str, str2);
                        u.makeText(view.getContext(), (int) R.string.fhd, 0).show();
                        AppMethodBeat.o(233559);
                        return;
                    }
                    try {
                        String format = String.format(Locale.US, d.PHp, URLEncoder.encode(str, ProtocolPackage.ServerEncoding), URLEncoder.encode(str2, ProtocolPackage.ServerEncoding), 13);
                        Log.d("MicroMsg.ChattingItemAppBrandNotifyMsg", "go to complain page(%s, %s), url:%s", str2, str, format);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", format);
                        c.r(intent, d.this.PhN.getTalkerUserName());
                        com.tencent.mm.br.c.b(d.this.PhN.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(233559);
                    } catch (UnsupportedEncodingException e2) {
                        Log.e("MicroMsg.ChattingItemAppBrandNotifyMsg", "Error occurred when encode url.");
                        u.makeText(view.getContext(), (int) R.string.fhd, 0).show();
                        AppMethodBeat.o(233559);
                    }
                } else {
                    u.makeText(view.getContext(), (int) R.string.fh8, 0).show();
                    AppMethodBeat.o(233559);
                }
            }
        });
        AppMethodBeat.o(233583);
    }

    static /* synthetic */ void a(d dVar, String str) {
        AppMethodBeat.i(233584);
        final LinkedList<fdy> linkedList = new LinkedList<>();
        fdy fdy = new fdy();
        fdy.dNI = str;
        fdy.status = 1;
        linkedList.add(fdy);
        dwq dwq = new dwq();
        dwq.MeZ = linkedList;
        dwq.scene = 3;
        d.a aVar = com.tencent.mm.modelappbrand.d.iIp;
        com.tencent.mm.ak.aa.a(d.a.a(dwq), new aa.a() {
            /* class com.tencent.mm.ui.chatting.viewitems.d.AnonymousClass8 */

            @Override // com.tencent.mm.ak.aa.a
            public final int a(int i2, int i3, String str, com.tencent.mm.ak.d dVar, com.tencent.mm.ak.q qVar) {
                AppMethodBeat.i(233562);
                Log.d("MicroMsg.ChattingItemAppBrandNotifyMsg", "setReceiveOff errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                d.g(d.this);
                if (i2 == 0 && i3 == 0) {
                    if (((dwr) dVar.iLL.iLR) == null) {
                        Log.e("MicroMsg.ChattingItemAppBrandNotifyMsg", "setReceiveOff failed, response is null!");
                    } else {
                        for (int i4 = 0; i4 < linkedList.size(); i4++) {
                            fdy fdy = (fdy) linkedList.get(i4);
                            if (fdy == null) {
                                Log.w("MicroMsg.ChattingItemAppBrandNotifyMsg", "scene end, item is null");
                            } else {
                                yj yjVar = new yj();
                                yjVar.eeG.appId = fdy.dNI;
                                yj.a aVar = yjVar.eeG;
                                aVar.dCs = fdy.status == 0;
                                EventCenter.instance.publish(yjVar);
                            }
                        }
                    }
                    AppMethodBeat.o(233562);
                } else {
                    u.makeText(d.this.PhN.Pwc.getContext(), (int) R.string.fhl, 0).show();
                    AppMethodBeat.o(233562);
                }
                return 0;
            }
        }, true);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.chatting.viewitems.d.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(233560);
                if (d.this.gxX == null) {
                    d dVar = d.this;
                    Activity context = d.this.PhN.Pwc.getContext();
                    d.this.PhN.Pwc.getContext().getString(R.string.zb);
                    dVar.gxX = com.tencent.mm.ui.base.h.a((Context) context, 3, d.this.PhN.Pwc.getContext().getString(R.string.fhe), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.ui.chatting.viewitems.d.AnonymousClass6.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                }
                d.this.gxX.show();
                AppMethodBeat.o(233560);
            }
        });
        AppMethodBeat.o(233584);
    }
}
