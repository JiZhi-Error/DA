package com.tencent.mm.ui.chatting.viewitems;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.appbrand.service.f;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.appbrand.xweb_ext.video.AppBrandWeishiVideoOperation;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.chatting.viewitems.e;

public final class ah {

    public static class a extends c {
        private d PLO;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || i2 != 687865905) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTV() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37070);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.s_);
                view.setTag(new e().hb(view));
            }
            AppMethodBeat.o(37070);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37071);
            this.PhN = aVar2;
            e eVar = (e) aVar;
            if (this.PLO == null) {
                this.PLO = new d(this.PhN, this);
            }
            e.a(eVar, i2, aVar2, caVar, false, this.PLO, c(aVar2));
            ((w) g.af(w.class)).bwL();
            AppMethodBeat.o(37071);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233807);
            boolean a2 = ah.a(this.PhN, mVar, view, caVar);
            AppMethodBeat.o(233807);
            return a2;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, final com.tencent.mm.ui.chatting.e.a aVar, final ca caVar) {
            AppMethodBeat.i(37073);
            if (menuItem.getItemId() == 111) {
                final String N = br.N(caVar);
                if (Util.isNullOrNil(N)) {
                    k.b HD = k.b.HD(bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                    if (HD != null) {
                        h.INSTANCE.a(16979, HD.izj, HD.izh, 0, 2);
                    }
                    e.b.a(aVar, caVar, a(aVar, caVar));
                } else {
                    h.INSTANCE.a(17509, 3, N);
                    com.tencent.mm.ui.base.h.a((Context) aVar.Pwc.getContext(), (int) R.string.gh9, (int) R.string.gh_, (int) R.string.zx, (int) R.string.b20, true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.viewitems.ah.a.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(37068);
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", N);
                            intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                            intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                            h.INSTANCE.a(17509, 1, N);
                            AppMethodBeat.o(37068);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.viewitems.ah.a.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(37069);
                            k.b HD = k.b.HD(bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                            if (HD != null) {
                                h.INSTANCE.a(16979, HD.izj, HD.izh, 0, 2);
                            }
                            e.b.a(aVar, caVar, a.this.a(aVar, caVar));
                            h.INSTANCE.a(17509, 2, N);
                            AppMethodBeat.o(37069);
                        }
                    });
                }
            }
            AppMethodBeat.o(37073);
            return false;
        }
    }

    public static class b extends c implements t.n {
        private d PLO;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || i2 != 687865905) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTV() {
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(37074);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.tm);
                view.setTag(new e().hb(view));
            }
            AppMethodBeat.o(37074);
            return view;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            AppMethodBeat.i(37075);
            this.PhN = aVar2;
            e eVar = (e) aVar;
            if (this.PLO == null) {
                this.PLO = new d(this.PhN, this);
            }
            e.a(eVar, i2, aVar2, caVar, true, this.PLO, c(aVar2));
            a(i2, eVar, caVar, aVar2.gRI(), aVar2.gRM(), aVar2, this);
            ((w) g.af(w.class)).bwL();
            AppMethodBeat.o(37075);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(m mVar, View view, ca caVar) {
            AppMethodBeat.i(233808);
            boolean a2 = ah.a(this.PhN, mVar, view, caVar);
            AppMethodBeat.o(233808);
            return a2;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(37077);
            if (menuItem.getItemId() == 111) {
                k.b HD = k.b.HD(bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
                if (HD != null) {
                    h.INSTANCE.a(16979, HD.izj, HD.izh, 0, 2);
                }
                e.b.a(aVar, caVar, a(aVar, caVar));
            }
            AppMethodBeat.o(37077);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            AppMethodBeat.i(233809);
            if (caVar.dOQ()) {
                com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                bp.Ad(caVar.field_msgId);
                aVar.BN(true);
            }
            AppMethodBeat.o(233809);
        }
    }

    static class e extends c.a {
        public ImageView PKi;
        public ImageView PLQ;
        public ImageView ooE;
        public ProgressBar progressBar;
        public TextView tln;

        e() {
        }

        public final c.a hb(View view) {
            AppMethodBeat.i(37081);
            super.create(view);
            this.PKi = (ImageView) view.findViewById(R.id.aul);
            this.PLQ = (ImageView) view.findViewById(R.id.aun);
            this.clickArea = view.findViewById(R.id.auf);
            this.ooE = (ImageView) view.findViewById(R.id.ayc);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.tln = (TextView) view.findViewById(R.id.atq);
            this.progressBar = (ProgressBar) view.findViewById(R.id.ayk);
            this.stateIV = (ImageView) view.findViewById(R.id.ayb);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            AppMethodBeat.o(37081);
            return this;
        }

        @SuppressLint({"ResourceType"})
        public static void a(e eVar, int i2, com.tencent.mm.ui.chatting.e.a aVar, ca caVar, boolean z, d dVar, c.View$OnLongClickListenerC2106c cVar) {
            AppMethodBeat.i(37082);
            k.b HD = k.b.HD(bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
            if (HD == null) {
                Log.w("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, content is null");
                AppMethodBeat.o(37082);
                return;
            }
            com.tencent.mm.pluginsdk.model.app.g gE = com.tencent.mm.pluginsdk.model.app.h.gE(HD.appId, HD.appVersion);
            String str = (gE == null || gE.field_appName == null || gE.field_appName.trim().length() <= 0) ? HD.appName : gE.field_appName;
            if (HD.appId == null || HD.appId.length() <= 0 || !c.gp(str)) {
                eVar.tln.setVisibility(8);
            } else {
                eVar.tln.setText(com.tencent.mm.pluginsdk.model.app.h.a(aVar.Pwc.getContext(), gE, str));
                eVar.tln.setVisibility(0);
                c.a(aVar, eVar.tln, HD.appId);
            }
            eVar.ooE.setImageDrawable(com.tencent.mm.cb.a.l(aVar.Pwc.getContext(), R.raw.shortvideo_play_btn));
            if (eVar.progressBar != null) {
                eVar.progressBar.setVisibility(8);
            }
            String d2 = q.bcR().d(caVar.field_imgPath, false, true);
            Log.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, msgImgPath:%s, thumbFullPath:%s", caVar.field_imgPath, d2);
            i bcR = q.bcR();
            float density = com.tencent.mm.cb.a.getDensity(aVar.Pwc.getContext());
            aVar.Pwc.getContext();
            Bitmap a2 = bcR.a(d2, density, R.drawable.c3h);
            if (a2 == null || a2.isRecycled()) {
                Log.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, has no video thumb");
                eVar.PLQ.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
                int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) aVar.Pwc.getContext(), 85);
                int aG = com.tencent.mm.cb.a.aG(aVar.Pwc.getContext(), R.dimen.a6);
                eVar.PKi.setImageBitmap(BitmapUtil.createMaskImage(BitmapUtil.createColorBitmap(aVar.Pwc.getContext().getResources().getColor(R.color.u6), fromDPToPix, aG), R.drawable.c3h, fromDPToPix, aG));
                eVar.PKi.setLayoutParams(new FrameLayout.LayoutParams(fromDPToPix, aG));
                eVar.PLQ.setLayoutParams(new FrameLayout.LayoutParams(fromDPToPix, aG));
            } else {
                eVar.PKi.setImageBitmap(a2);
                eVar.PKi.setLayoutParams(new FrameLayout.LayoutParams(a2.getWidth(), a2.getHeight()));
                eVar.PLQ.setLayoutParams(new FrameLayout.LayoutParams(a2.getWidth(), a2.getHeight()));
            }
            if (z) {
                if (caVar.field_status == 5 || caVar.field_status == 2) {
                    if (eVar.progressBar != null) {
                        eVar.progressBar.setVisibility(8);
                    }
                } else if (eVar.progressBar != null) {
                    eVar.progressBar.setVisibility(0);
                }
            }
            eVar.clickArea.setTag(new bq(caVar, aVar.gRM(), i2, caVar.field_talker, (char) 0));
            eVar.clickArea.setOnClickListener(dVar);
            eVar.clickArea.setOnLongClickListener(cVar);
            eVar.clickArea.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            h.INSTANCE.a(16979, HD.izj, HD.izh, 0, 0);
            com.tencent.mm.modelappbrand.a.b.aXY().LF("file://".concat(String.valueOf(d2)));
            com.tencent.mm.ag.a aVar2 = (com.tencent.mm.ag.a) HD.as(com.tencent.mm.ag.a.class);
            if (aVar2 != null && !Util.isNullOrNil(aVar2.appThumbUrl)) {
                com.tencent.mm.modelappbrand.a.b.aXY().LF(aVar2.appThumbUrl);
            }
            if (g.af(f.class) != null) {
                ((f) g.af(f.class)).a(z.CHATTING_WEISHI);
            }
            if (NetStatusUtil.isWifi(MMApplicationContext.getContext()) && aVar2 != null && !Util.isNullOrNil(aVar2.videoSource)) {
                String str2 = aVar2.videoSource;
                if (g.af(com.tencent.mm.plugin.appbrand.service.k.class) != null) {
                    com.tencent.mm.plugin.appbrand.service.k kVar = (com.tencent.mm.plugin.appbrand.service.k) g.af(com.tencent.mm.plugin.appbrand.service.k.class);
                    if (kVar.bVs()) {
                        Log.i("MicroMsg.WeishiVideoItemViewHolder", "[weishi] parseMsgInfo, invoke video cache task");
                        int bVt = kVar.bVt();
                        if (bVt != -1) {
                            bVt = bVt * 1024 * 1024;
                        }
                        XIPCInvoker.a(Appbrand0IPCService.dkO, new AppBrandWeishiVideoOperation(str2, (long) bVt), c.class, null);
                        AppMethodBeat.o(37082);
                        return;
                    }
                    Log.i("MicroMsg.WeishiVideoItemViewHolder", "parseMsgInfo, weishi video preload disabled");
                }
            }
            AppMethodBeat.o(37082);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class c implements com.tencent.mm.ipcinvoker.b<AppBrandWeishiVideoOperation, IPCVoid> {
        private c() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(AppBrandWeishiVideoOperation appBrandWeishiVideoOperation, com.tencent.mm.ipcinvoker.d<IPCVoid> dVar) {
            AppMethodBeat.i(37079);
            AppBrandWeishiVideoOperation appBrandWeishiVideoOperation2 = appBrandWeishiVideoOperation;
            com.tencent.mm.plugin.appbrand.jsapi.video.g gVar = (com.tencent.mm.plugin.appbrand.jsapi.video.g) com.tencent.luggage.a.e.M(com.tencent.mm.plugin.appbrand.jsapi.video.g.class);
            if (!(appBrandWeishiVideoOperation2 == null || gVar == null)) {
                Log.i("MicroMsg.ChattingItemAppMsgWeishiVideo", "[weishi] invoke, cache video");
                gVar.o(appBrandWeishiVideoOperation2.url, appBrandWeishiVideoOperation2.boS, appBrandWeishiVideoOperation2.length);
            }
            AppMethodBeat.o(37079);
        }
    }

    static class d extends t.e {
        private c chattingItem;

        public d(com.tencent.mm.ui.chatting.e.a aVar, c cVar) {
            super(aVar);
            this.chattingItem = cVar;
        }

        @Override // com.tencent.mm.ui.chatting.t.e
        public final void a(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            String str;
            int i2;
            Bundle bundle;
            AppMethodBeat.i(37080);
            ((com.tencent.mm.plugin.comm.a.b) g.af(com.tencent.mm.plugin.comm.a.b.class)).akR(caVar.field_talker);
            k.b HD = k.b.HD(bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
            if (HD == null) {
                Log.w("MicroMsg.WeishiVideoClickListener", "weishi chatItemClick, content is null");
                AppMethodBeat.o(37080);
            } else if (!Util.isNullOrNil(HD.izj) || !Util.isNullOrNil(HD.izi)) {
                String talkerUserName = aVar.getTalkerUserName();
                String a2 = this.chattingItem.a(aVar, caVar);
                Bundle bundle2 = new Bundle();
                if (aVar.gRM()) {
                    str = "stat_scene";
                    i2 = 2;
                    bundle = bundle2;
                } else {
                    str = "stat_scene";
                    if (ab.IT(talkerUserName)) {
                        i2 = 7;
                        bundle = bundle2;
                    } else {
                        i2 = 1;
                        bundle = bundle2;
                    }
                }
                bundle.putInt(str, i2);
                bundle2.putString("stat_msg_id", "msg_" + Long.toString(caVar.field_msgSvrId));
                bundle2.putString("stat_chat_talker_username", talkerUserName);
                bundle2.putString("stat_send_msg_user", a2);
                com.tencent.mm.pluginsdk.model.app.g gE = com.tencent.mm.pluginsdk.model.app.h.gE(HD.appId, HD.appVersion);
                bundle2.putString("stat_weishi_app_name", (gE == null || gE.field_appName == null || gE.field_appName.trim().length() <= 0) ? HD.appName : gE.field_appName);
                bundle2.putString("stat_weishi_app_id", HD.appId);
                bundle2.putString("stat_weishi_source_username", HD.eag);
                com.tencent.mm.ag.a aVar2 = (com.tencent.mm.ag.a) HD.as(com.tencent.mm.ag.a.class);
                bundle2.putBoolean("stat_weishi_from_opensdk", aVar2 != null && aVar2.ivk == 1);
                bundle2.putString("stat_weishi_msg_img_path", caVar.field_imgPath);
                bundle2.putString("stat_weishi_thumb_path", q.bcR().d(caVar.field_imgPath, false, true));
                bundle2.putString("stat_weishi_thumb_url", aVar2 != null ? aVar2.appThumbUrl : null);
                h.INSTANCE.a(16979, HD.izj, HD.izh, 0, 1);
                h.INSTANCE.idkeyStat(1129, 0, 1, false);
                ((r) g.af(r.class)).b(aVar.Pwc.getContext(), talkerUserName, a2, aVar.gRM(), HD, bundle2);
                AppMethodBeat.o(37080);
            } else {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", com.tencent.mm.pluginsdk.model.app.q.R(HD.url, aVar.gRM() ? "groupmessage" : "singlemessage"));
                intent.putExtra("webpageTitle", HD.title);
                intent.putExtra("shortUrl", HD.url);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(37080);
            }
        }
    }

    static /* synthetic */ boolean a(com.tencent.mm.ui.chatting.e.a aVar, m mVar, View view, ca caVar) {
        AppMethodBeat.i(233810);
        int i2 = ((bq) view.getTag()).position;
        k.b HD = k.b.HD(bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend));
        if (HD == null) {
            Log.w("MicroMsg.ChattingItemAppMsgWeishiVideo", "createContextMenu, content is null");
        } else if (!com.tencent.mm.pluginsdk.model.app.h.l(com.tencent.mm.pluginsdk.model.app.h.o(HD.appId, false, false)) || com.tencent.mm.ui.chatting.k.bm(caVar)) {
            Log.i("MicroMsg.ChattingItemAppMsgWeishiVideo", "createContextMenu, do not show transmit menu");
        } else {
            Log.i("MicroMsg.ChattingItemAppMsgWeishiVideo", "createContextMenu, show transmit menu");
            mVar.a(i2, 111, view.getContext().getString(R.string.g5c), R.raw.icons_filled_share);
        }
        AppMethodBeat.o(233810);
        return true;
    }
}
