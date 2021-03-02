package com.tencent.mm.plugin.topstory.ui.video;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import java.io.IOException;
import java.util.LinkedList;

public abstract class h extends RecyclerView.v implements a {
    public eiw GjH;
    public b Gmr;
    private boolean Gms;
    protected View.OnClickListener ko = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.topstory.ui.video.h.AnonymousClass1 */

        public final void onClick(View view) {
            AppMethodBeat.i(126072);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            h.this.fV(view);
            a.a(this, "com/tencent/mm/plugin/topstory/ui/video/TopStoryBaseVideoHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(126072);
        }
    };

    public abstract void fzj();

    public abstract f fzk();

    public abstract View getWowView();

    public h(View view, b bVar) {
        super(view);
        this.Gmr = bVar;
        fU(view);
    }

    public void fU(View view) {
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.a
    public void fyy() {
        this.Gmr.fyy();
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.a
    public void fyx() {
        this.Gmr.fyx();
    }

    public boolean fzi() {
        return false;
    }

    public final void d(eiw eiw) {
        this.GjH = eiw;
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoHolder", "onBindItemHolder %s", eiw.title);
        fzj();
    }

    public void wu(boolean z) {
        this.Gmr.a(this.GjH);
    }

    /* access modifiers changed from: protected */
    public void fV(View view) {
        if (this.Gmr.fyH() != fyz()) {
            this.Gmr.fyB().GnS = 2;
            this.Gmr.abU(fyz());
            com.tencent.mm.plugin.websearch.api.a.a.pl(4);
            this.Gmr.fyB().k(this.GjH);
            ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(this.Gmr.fyD(), this.GjH, fyz(), 2, "");
            return;
        }
        fW(view);
        if (fzi()) {
            fyy();
            this.Gmr.fyy();
            fyx();
            this.Gmr.fyx();
        }
    }

    public void fW(View view) {
    }

    /* access modifiers changed from: protected */
    public final void a(final b bVar, final Context context, final f fVar, final int i2) {
        final eiw acd = bVar.fyO().acd(i2);
        ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(bVar.fyD(), acd, i2, 5, "");
        if (acd != null) {
            if (this.Gmr.fyF().dFG()) {
                this.Gmr.fyF().cXa();
                this.Gms = true;
            }
            e eVar = new e(context, 1, false);
            eVar.HLX = new o.f() {
                /* class com.tencent.mm.plugin.topstory.ui.video.h.AnonymousClass2 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(126073);
                    mVar.aS(0, R.string.hxr, R.raw.bottomsheet_icon_transmit);
                    mVar.aS(1, R.string.hxs, R.raw.bottomsheet_icon_moment);
                    AppMethodBeat.o(126073);
                }
            };
            eVar.HLY = new o.g() {
                /* class com.tencent.mm.plugin.topstory.ui.video.h.AnonymousClass3 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    byte[] bArr;
                    AppMethodBeat.i(126074);
                    if (h.this.Gms) {
                        h.this.Gmr.fyF().eYd();
                        h.this.Gms = false;
                    }
                    h.this.Gmr.fyM();
                    if (menuItem.getItemId() == 1) {
                        fVar.crC();
                        p pVar = p.GnV;
                        Context context = context;
                        eiw eiw = acd;
                        eit fyD = bVar.fyD();
                        if (!(eiw == null || fyD == null)) {
                            pVar.GnW = eiw;
                            Intent intent = new Intent();
                            intent.putExtra("Ksnsupload_title", eiw.msN);
                            intent.putExtra("Ksnsupload_imgurl", eiw.IED);
                            intent.putExtra("Ksnsupload_link", eiw.rCq);
                            intent.putExtra("KContentObjDesc", Util.isNullOrNil(eiw.xDQ) ? context.getString(R.string.fvf) : eiw.xDQ);
                            intent.putExtra("KlinkThumb_url", eiw.IED);
                            intent.putExtra("Ksnsupload_source", 1);
                            intent.putExtra("Ksnsupload_type", 16);
                            intent.putExtra("need_result", true);
                            fat fat = new fat();
                            fat.IEy = eiw.psI;
                            fat.IEz = eiw.Nir;
                            fat.IEA = fyD.hes;
                            fat.IEB = eiw.Niq;
                            fat.IEC = 100201;
                            fat.rCq = eiw.rCq;
                            fat.msN = eiw.msN;
                            fat.xDQ = eiw.xDQ;
                            fat.IED = eiw.IED;
                            fat.IEE = eiw.IEE;
                            fat.IEF = eiw.IEF;
                            fat.source = eiw.source;
                            fat.eby = eiw.eby;
                            fat.IEG = eiw.IEG;
                            fat.IEH = eiw.IEH;
                            LinkedList linkedList = new LinkedList();
                            linkedList.addAll(fyD.IDO);
                            linkedList.addAll(eiw.IDO);
                            fat.IEI = p.hL(linkedList).toString();
                            fat.IEJ = com.tencent.mm.plugin.topstory.a.h.hK(eiw.xuO).toString();
                            fat.IEK = eiw.Niy;
                            fat.thumbUrl = eiw.Nio;
                            if (p.l(eiw) && fyD.Nid != null) {
                                fat.IEL = fyD.Nid.title;
                            }
                            try {
                                bArr = fat.toByteArray();
                            } catch (IOException e2) {
                                Log.printErrStackTrace("MicroMsg.TopStory.TopStoryVideoShareMgr", e2, "", new Object[0]);
                                bArr = null;
                            }
                            if (bArr != null) {
                                intent.putExtra("KWebSearchInfo", bArr);
                            }
                            c.b(context, "sns", ".ui.SnsUploadUI", intent, 1024);
                        }
                        ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(bVar.fyD(), acd, i2, 7, "");
                        AppMethodBeat.o(126074);
                        return;
                    }
                    if (menuItem.getItemId() == 0) {
                        fVar.crC();
                        p pVar2 = p.GnV;
                        Context context2 = context;
                        eiw eiw2 = acd;
                        eit fyD2 = bVar.fyD();
                        pVar2.GnW = eiw2;
                        k.b bVar = new k.b();
                        bVar.type = 5;
                        bVar.title = eiw2.msN;
                        bVar.description = Util.isNullOrNil(eiw2.xDQ) ? context2.getString(R.string.fvf) : eiw2.xDQ;
                        bVar.url = eiw2.rCq;
                        bVar.thumburl = eiw2.IED;
                        aj ajVar = new aj();
                        ajVar.IEy = eiw2.psI;
                        ajVar.IEz = eiw2.Nir;
                        ajVar.IEA = fyD2.hes;
                        ajVar.IEB = eiw2.Niq;
                        ajVar.IEC = 100201;
                        ajVar.rCq = eiw2.rCq;
                        ajVar.msN = eiw2.msN;
                        ajVar.xDQ = eiw2.xDQ;
                        ajVar.IED = eiw2.IED;
                        ajVar.IEE = eiw2.IEE;
                        ajVar.IEF = eiw2.IEF;
                        ajVar.source = eiw2.source;
                        ajVar.eby = eiw2.eby;
                        ajVar.IEG = eiw2.IEG;
                        ajVar.IEH = eiw2.IEH;
                        LinkedList linkedList2 = new LinkedList();
                        linkedList2.addAll(fyD2.IDO);
                        linkedList2.addAll(eiw2.IDO);
                        ajVar.IEI = p.hL(linkedList2).toString();
                        ajVar.IEJ = com.tencent.mm.plugin.topstory.a.h.hK(eiw2.xuO).toString();
                        ajVar.IEK = eiw2.Niy;
                        ajVar.thumbUrl = eiw2.Nio;
                        if (p.l(eiw2) && fyD2.Nid != null) {
                            ajVar.IEL = fyD2.Nid.title;
                        }
                        bVar.a(ajVar);
                        String a2 = k.b.a(bVar, null, null);
                        Intent intent2 = new Intent();
                        intent2.putExtra("Retr_Msg_Type", 2);
                        intent2.putExtra("Retr_Msg_content", a2);
                        intent2.putExtra("Multi_Retr", true);
                        intent2.putExtra("Retr_go_to_chattingUI", false);
                        intent2.putExtra("Retr_show_success_tips", true);
                        c.c(context2, ".ui.transmit.MsgRetransmitUI", intent2, 2048);
                        ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getReporter().a(bVar.fyD(), acd, i2, 6, "");
                    }
                    AppMethodBeat.o(126074);
                }
            };
            eVar.PGl = new e.b() {
                /* class com.tencent.mm.plugin.topstory.ui.video.h.AnonymousClass4 */

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                    AppMethodBeat.i(126075);
                    if (h.this.Gms) {
                        h.this.Gmr.fyF().eYd();
                        h.this.Gms = false;
                    }
                    h.this.Gmr.fyM();
                    AppMethodBeat.o(126075);
                }
            };
            eVar.dGm();
        }
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.a
    public int fyz() {
        return lR() - this.Gmr.fyK().getHeadersCount();
    }
}
