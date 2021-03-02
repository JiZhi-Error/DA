package com.tencent.mm.ui.chatting.k;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.ac.c;
import com.tencent.mm.plugin.appbrand.ac.e;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.chatting.a.c;
import com.tencent.mm.ui.tools.l;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends b {
    c PEf;
    private int gCo = -1;

    public a(Context context) {
        super(context);
        AppMethodBeat.i(36457);
        c.a aVar = new c.a();
        aVar.jbq = R.raw.app_brand_app_default_icon_for_tail;
        aVar.dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50)).jbd = true;
        this.PEf = aVar.bdv();
        AppMethodBeat.o(36457);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final int getType() {
        return 33;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final void gRY() {
        AppMethodBeat.i(36458);
        Log.i("MicroMsg.AppBrandHistoryListPresenter", "[loadData] isFirst:%s", Boolean.TRUE);
        this.PEm.gSc();
        com.tencent.mm.plugin.appbrand.ac.c.reset();
        com.tencent.mm.plugin.appbrand.ac.c.a(this.gAn, new c.a() {
            /* class com.tencent.mm.ui.chatting.k.a.AnonymousClass1 */
            final /* synthetic */ boolean qoy = true;

            @Override // com.tencent.mm.plugin.appbrand.ac.c.a
            public final void A(final LinkedList<e> linkedList) {
                AppMethodBeat.i(36448);
                AnonymousClass1 r0 = new Runnable() {
                    /* class com.tencent.mm.ui.chatting.k.a.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(36447);
                        if (!Util.isNullOrNil(linkedList)) {
                            Iterator it = linkedList.iterator();
                            while (it.hasNext()) {
                                e eVar = (e) it.next();
                                if (eVar != null) {
                                    a.this.mDataList.add(new C2098a(eVar.timestamp, eVar.type, eVar.title, eVar.msgId, eVar.username, eVar.nickname, eVar.cgo, eVar.ogt, eVar.izj, eVar.dXm, eVar.dTS, eVar.desc, eVar.imagePath, eVar.ogu));
                                }
                            }
                        }
                        a.this.PEo = a.this.mDataList;
                        if (a.this.PEm != null) {
                            a.this.PEm.D(AnonymousClass1.this.qoy, a.this.mDataList.size());
                        }
                        AppMethodBeat.o(36447);
                    }
                };
                if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
                    MMHandlerThread.postToMainThread(r0);
                    AppMethodBeat.o(36448);
                    return;
                }
                r0.run();
                AppMethodBeat.o(36448);
            }
        });
        AppMethodBeat.o(36458);
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final String bmB() {
        AppMethodBeat.i(36459);
        String string = this.mContext.getString(R.string.gfh);
        AppMethodBeat.o(36459);
        return string;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final String gSb() {
        AppMethodBeat.i(36460);
        String string = this.mContext.getString(R.string.gfh);
        AppMethodBeat.o(36460);
        return string;
    }

    @Override // com.tencent.mm.ui.chatting.f.b.a
    public final c.e gRZ() {
        AppMethodBeat.i(36461);
        AnonymousClass2 r0 = new c.e() {
            /* class com.tencent.mm.ui.chatting.k.a.AnonymousClass2 */

            @Override // com.tencent.mm.ui.chatting.a.c.e
            public final void a(View view, int i2, c.b bVar) {
                AppMethodBeat.i(36450);
                Log.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemClick] position:%s", Integer.valueOf(i2));
                a.a(a.this, (C2098a) bVar);
                AppMethodBeat.o(36450);
            }

            @Override // com.tencent.mm.ui.chatting.a.c.e
            public final void b(View view, int i2, final c.b bVar) {
                AppMethodBeat.i(36451);
                Log.i("MicroMsg.AppBrandHistoryListPresenter", "[onItemLongClick] position:%s", Integer.valueOf(i2));
                new l(view.getContext()).b(view, new View.OnCreateContextMenuListener() {
                    /* class com.tencent.mm.ui.chatting.k.a.AnonymousClass2.AnonymousClass1 */

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                    }
                }, new o.g() {
                    /* class com.tencent.mm.ui.chatting.k.a.AnonymousClass2.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        AppMethodBeat.i(36449);
                        bg.aVF();
                        a.this.d(menuItem.getItemId(), com.tencent.mm.model.c.aSQ().Hb(bVar.msgId));
                        AppMethodBeat.o(36449);
                    }
                });
                AppMethodBeat.o(36451);
            }
        };
        AppMethodBeat.o(36461);
        return r0;
    }

    @Override // com.tencent.mm.ui.chatting.a.c.f
    public final RecyclerView.v N(ViewGroup viewGroup) {
        AppMethodBeat.i(36462);
        b bVar = new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gp, viewGroup, false));
        AppMethodBeat.o(36462);
        return bVar;
    }

    @Override // com.tencent.mm.ui.chatting.a.c.f
    public final void a(c.a aVar, int i2) {
        AppMethodBeat.i(36463);
        final b bVar = (b) aVar;
        final C2098a aVar2 = (C2098a) amy(i2);
        com.tencent.mm.ag.a aVar3 = (com.tencent.mm.ag.a) aVar2.dXm.as(com.tencent.mm.ag.a.class);
        if (aVar3 == null || aVar3.ivf != 1) {
            bVar.tld.setVisibility(8);
        } else {
            bVar.tld.setVisibility(0);
        }
        if (Util.isNullOrNil(aVar2.desc)) {
            bVar.jBR.setVisibility(8);
        } else {
            bVar.jBR.setVisibility(0);
            bVar.jBR.setText(bVar.jVO.getText());
            bVar.jVO.setText(aVar2.desc);
            b.g(bVar.jBR, this.PEn.Pmg);
            if (!Util.isNullOrNil(aVar2.ogu)) {
                com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k() {
                    /* class com.tencent.mm.ui.chatting.k.a.AnonymousClass3 */

                    @Override // com.tencent.mm.modelappbrand.a.b.k
                    public final void aYg() {
                    }

                    @Override // com.tencent.mm.modelappbrand.a.b.k
                    public final void I(Bitmap bitmap) {
                        AppMethodBeat.i(36452);
                        if (bitmap == null || bitmap.isRecycled()) {
                            q.bcV().a(aVar2.imagePath, bVar.nnL, a.this.PEf);
                            AppMethodBeat.o(36452);
                            return;
                        }
                        bVar.nnL.setImageBitmap(bitmap);
                        AppMethodBeat.o(36452);
                    }

                    @Override // com.tencent.mm.modelappbrand.a.b.k
                    public final void oD() {
                        AppMethodBeat.i(36453);
                        q.bcV().a(aVar2.imagePath, bVar.nnL, a.this.PEf);
                        AppMethodBeat.o(36453);
                    }

                    @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                    public final String Lb() {
                        AppMethodBeat.i(36454);
                        String str = "SEARCH#" + n.cO(this);
                        AppMethodBeat.o(36454);
                        return str;
                    }
                }, aVar2.ogu, (b.h) null, ((k) g.af(k.class)).m10do(45, 45));
                AppMethodBeat.o(36463);
                return;
            }
        }
        q.bcV().a(aVar2.imagePath, bVar.nnL, this.PEf);
        AppMethodBeat.o(36463);
    }

    class b extends c.a {
        TextView jBR;
        ImageView nnL;
        ImageView tld;
        TextView tln;

        public b(View view) {
            super(view);
            AppMethodBeat.i(36456);
            this.nnL = (ImageView) view.findViewById(R.id.cc2);
            this.tld = (ImageView) view.findViewById(R.id.cc7);
            this.jBR = (TextView) view.findViewById(R.id.cbl);
            this.tln = (TextView) view.findViewById(R.id.cd0);
            this.tln.setVisibility(8);
            this.tld.setVisibility(8);
            AppMethodBeat.o(36456);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.ui.chatting.k.a$a  reason: collision with other inner class name */
    public class C2098a extends c.b {
        public long dTS;
        public k.b dXm;
        public String desc;
        public String imagePath;
        public String izj;
        public String ogu;

        public C2098a(long j2, int i2, String str, long j3, String str2, String str3, String str4, String str5, String str6, k.b bVar, long j4, String str7, String str8, String str9) {
            super(j2, i2, str, j3, str2, str3, str4, str5);
            this.izj = str6;
            this.dXm = bVar;
            this.dTS = j4;
            this.desc = str7;
            this.imagePath = str8;
            this.ogu = str9;
        }

        @Override // com.tencent.mm.ui.chatting.a.c.b
        public final boolean bmC(String str) {
            AppMethodBeat.i(36455);
            if (str != null) {
                String lowerCase = str.toLowerCase();
                if (!bmD(lowerCase)) {
                    if (!Util.isNullOrNil(this.desc) && ng(lowerCase, this.desc.toLowerCase())) {
                        AppMethodBeat.o(36455);
                        return true;
                    }
                } else if (!Util.isNullOrNil(this.desc) && this.desc.toLowerCase().contains(lowerCase)) {
                    AppMethodBeat.o(36455);
                    return true;
                }
                boolean bmC = super.bmC(lowerCase);
                AppMethodBeat.o(36455);
                return bmC;
            }
            AppMethodBeat.o(36455);
            return false;
        }

        @Override // com.tencent.mm.ui.chatting.a.c.b
        public final int getType() {
            return 33;
        }
    }

    private static PackageInfo getPackageInfo(Context context, String str) {
        String str2;
        PackageInfo packageInfo = null;
        AppMethodBeat.i(36464);
        if (str == null || str.length() == 0) {
            str2 = null;
        } else {
            com.tencent.mm.pluginsdk.model.app.g o = h.o(str, true, false);
            str2 = o == null ? null : o.field_packageName;
        }
        if (str2 == null) {
            AppMethodBeat.o(36464);
        } else {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                AppMethodBeat.o(36464);
            } catch (PackageManager.NameNotFoundException e2) {
                Log.printErrStackTrace("MicroMsg.AppBrandHistoryListPresenter", e2, "", new Object[0]);
                AppMethodBeat.o(36464);
            }
        }
        return packageInfo;
    }

    static /* synthetic */ void a(a aVar, C2098a aVar2) {
        boolean z;
        AppMethodBeat.i(36465);
        boolean Eq = ab.Eq(aVar.gAn);
        Log.i("MicroMsg.AppBrandHistoryListPresenter", "username: %s , appid %s ,pkgType : %s", aVar2.dXm.izi, aVar2.izj, Integer.valueOf(aVar2.dXm.izz));
        String str = aVar.gAn;
        String str2 = aVar2.username;
        Bundle bundle = new Bundle();
        bundle.putInt("stat_scene", 9);
        bundle.putString("stat_msg_id", "msg_" + Long.toString(aVar2.dTS));
        bundle.putString("stat_chat_talker_username", str);
        bundle.putString("stat_send_msg_user", str2);
        switch (aVar2.dXm.izk) {
            case 1:
                Intent intent = new Intent();
                intent.putExtra("key_username", aVar2.dXm.izi);
                if (Eq) {
                    intent.putExtra("key_from_scene", 1);
                    intent.putExtra("key_scene_note", str + ":" + str2);
                } else {
                    intent.putExtra("key_from_scene", 2);
                    intent.putExtra("key_scene_note", str);
                }
                intent.putExtra("_stat_obj", bundle);
                WxaExposedParams.a aVar3 = new WxaExposedParams.a();
                aVar3.appId = aVar2.izj;
                aVar3.from = 6;
                aVar3.kNW = aVar2.dXm.izz;
                aVar3.pkgVersion = aVar2.dXm.izm;
                intent.putExtra("key_scene_exposed_params", aVar3.bAv());
                com.tencent.mm.br.c.b(aVar.mContext, "appbrand", ".ui.AppBrandProfileUI", intent);
                z = false;
                break;
            case 2:
                com.tencent.mm.modelappbrand.a.a(str, str2, Eq, aVar2.dXm, bundle);
                z = false;
                break;
            case 3:
                com.tencent.mm.modelappbrand.a.b(str, str2, Eq, aVar2.dXm, bundle);
                z = false;
                break;
            default:
                z = true;
                break;
        }
        if (z && aVar2.dXm.type == 36) {
            ((r) g.af(r.class)).a(aVar.mContext, aVar.gAn, aVar2.username, true, aVar2.dXm, bundle);
            z = false;
        }
        Log.i("MicroMsg.AppBrandHistoryListPresenter", "goDefaultClickAction %b", Boolean.valueOf(z));
        if (z && aVar2.dXm.url != null && !aVar2.dXm.url.equals("")) {
            String R = com.tencent.mm.pluginsdk.model.app.q.R(aVar2.dXm.url, Eq ? "groupmessage" : "singlemessage");
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", R);
            intent2.putExtra("webpageTitle", aVar2.dXm.title);
            PackageInfo packageInfo = getPackageInfo(aVar.mContext, aVar2.dXm.appId);
            intent2.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
            intent2.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
            intent2.putExtra("shortUrl", aVar2.dXm.url);
            if (!Util.isNullOrNil(aVar2.dXm.eag)) {
                intent2.putExtra("srcUsername", aVar2.dXm.eag);
                intent2.putExtra("srcDisplayname", aVar2.dXm.eah);
            }
            intent2.putExtra("msg_id", aVar2.msgId);
            intent2.putExtra("KPublisherId", "msg_" + Long.toString(aVar2.dTS));
            intent2.putExtra("KAppId", aVar2.dXm.appId);
            intent2.putExtra("geta8key_username", aVar.gAn);
            intent2.putExtra("pre_username", aVar2.username);
            intent2.putExtra("from_scence", 2);
            intent2.putExtra("prePublishId", "msg_" + Long.toString(aVar2.dTS));
            intent2.putExtra("preUsername", aVar2.username);
            intent2.putExtra("preChatName", aVar.gAn);
            intent2.putExtra("preChatTYPE", 2);
            intent2.putExtra("preMsgIndex", 0);
            intent2.putExtra("share_report_pre_msg_url", aVar2.dXm.url);
            intent2.putExtra("share_report_pre_msg_title", aVar2.dXm.title);
            intent2.putExtra("share_report_pre_msg_desc", aVar2.dXm.description);
            intent2.putExtra("share_report_pre_msg_icon_url", aVar2.dXm.thumburl);
            intent2.putExtra("share_report_pre_msg_appid", aVar2.dXm.appId);
            intent2.putExtra("share_report_from_scene", 2);
            com.tencent.mm.br.c.b(aVar.mContext, "webview", ".ui.tools.WebViewUI", intent2);
        }
        AppMethodBeat.o(36465);
    }
}
