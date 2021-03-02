package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ax;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.np;
import com.tencent.mm.g.a.qx;
import com.tencent.mm.g.a.qz;
import com.tencent.mm.g.a.vw;
import com.tencent.mm.g.a.wj;
import com.tencent.mm.g.a.wn;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.FlipView;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;
import java.util.List;

public final class w implements i {
    SnsInfo DqO;
    cnb DzV;
    e Epy = null;
    SnsCmdList EqW = new SnsCmdList();
    private final a EqX;
    boolean EqY;
    int EqZ = 0;
    String Eqk;
    String Eqn;
    String Eqo;
    String Eqp;
    String Eqq;
    String Eqr;
    long Eqs;
    boolean Equ = false;
    FlipView.b Eqw;
    IListener Eqy = new IListener<np>() {
        /* class com.tencent.mm.plugin.sns.ui.w.AnonymousClass5 */

        {
            AppMethodBeat.i(203252);
            this.__eventId = np.class.getName().hashCode();
            AppMethodBeat.o(203252);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(np npVar) {
            AppMethodBeat.i(203253);
            np npVar2 = npVar;
            if (npVar2 == null || !(npVar2 instanceof np)) {
                Log.e("MicroMsg.GalleryTitleManager", "event is null or not a instant of NotifyDealQBarStrResultEvent");
            } else {
                Log.i("MicroMsg.GalleryTitleManager", "notify Event: %d", Integer.valueOf(npVar2.dTL.dTJ));
                if (npVar2.dTL.activity != ((Activity) w.this.context) || !npVar2.dTL.dDX.equals(w.this.Eqn)) {
                    Log.e("MicroMsg.GalleryTitleManager", "not the same");
                }
            }
            AppMethodBeat.o(203253);
            return false;
        }
    };
    boolean Era = false;
    boolean Erb = false;
    private final String Erc;
    String Mc;
    final Context context;
    int dFL;
    int dFM;
    int fromScene;
    ScanCodeSheetItemLogic mHu;
    public int oUs = 0;
    IListener teF = new IListener<qz>() {
        /* class com.tencent.mm.plugin.sns.ui.w.AnonymousClass4 */

        {
            AppMethodBeat.i(160697);
            this.__eventId = qz.class.getName().hashCode();
            AppMethodBeat.o(160697);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qz qzVar) {
            AppMethodBeat.i(97898);
            qz qzVar2 = qzVar;
            if (w.this.Epy == null || w.this.Eqk == null) {
                Log.e("MicroMsg.GalleryTitleManager", "not in recoging");
                AppMethodBeat.o(97898);
            } else if (qzVar2 == null || !(qzVar2 instanceof qz)) {
                Log.e("MicroMsg.GalleryTitleManager", "receive invalid callbak");
                AppMethodBeat.o(97898);
            } else if (!qzVar2.dXz.filePath.equals(w.this.Eqk)) {
                Log.e("MicroMsg.GalleryTitleManager", "not same filepath");
                AppMethodBeat.o(97898);
            } else {
                Log.i("MicroMsg.GalleryTitleManager", "recog result: " + qzVar2.dXz.result);
                if (!Util.isNullOrNil(qzVar2.dXz.result)) {
                    w.this.Eqn = qzVar2.dXz.result;
                    w.this.dFL = qzVar2.dXz.dFL;
                    w.this.dFM = qzVar2.dXz.dFM;
                    if (!(w.this.Eqn == null || w.this.Epy == null)) {
                        w.this.Equ = true;
                        w.this.mHu.cm(w.this.dFL, w.this.Eqn);
                    }
                    w.this.a(w.this.EqY, w.this.DqO, w.this.DzV);
                }
                w.this.Eqk = null;
                AppMethodBeat.o(97898);
            }
            return false;
        }
    };
    public q tipDialog = null;

    public interface a {
        void fH(String str, int i2);

        void fI(String str, int i2);

        void ffK();

        void kQ(String str, String str2);
    }

    public final void Zu(int i2) {
        AppMethodBeat.i(97909);
        if (i2 == 0) {
            AppMethodBeat.o(97909);
            return;
        }
        this.EqW.Yj(i2);
        AppMethodBeat.o(97909);
    }

    public w(Context context2, a aVar, int i2) {
        AppMethodBeat.i(203256);
        this.context = context2;
        this.fromScene = i2;
        this.EqX = aVar;
        this.Erc = ((Activity) context2).getIntent().getStringExtra("sns_gallery_pre_title");
        this.mHu = new ScanCodeSheetItemLogic(context2, new ScanCodeSheetItemLogic.a() {
            /* class com.tencent.mm.plugin.sns.ui.w.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a
            public final void bLz() {
                AppMethodBeat.i(97895);
                if (w.this.Epy != null && w.this.Epy.isShowing()) {
                    w.this.Equ = true;
                    w.this.a(w.this.EqY, w.this.DqO, w.this.DzV);
                }
                AppMethodBeat.o(97895);
            }
        });
        AppMethodBeat.o(203256);
    }

    public final void ffJ() {
        AppMethodBeat.i(97911);
        Intent intent = new Intent();
        intent.putExtra("sns_cmd_list", this.EqW);
        ((Activity) this.context).setResult(-1, intent);
        ((Activity) this.context).finish();
        AppMethodBeat.o(97911);
    }

    public final void a(boolean z, SnsInfo snsInfo, cnb cnb) {
        AppMethodBeat.i(97912);
        a(z, snsInfo, cnb, this.Era, this.Erb, false, 0);
        AppMethodBeat.o(97912);
    }

    public final void a(boolean z, SnsInfo snsInfo, cnb cnb, boolean z2, boolean z3, boolean z4, int i2) {
        AppMethodBeat.i(203257);
        this.EqY = z;
        this.DqO = snsInfo;
        this.DzV = cnb;
        this.Mc = cnb.Id;
        this.Era = z2;
        this.Erb = z3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!z) {
            snsInfo.getTimeLine();
            arrayList.add(this.context.getString(R.string.h9u));
            arrayList2.add(3);
            if (c.aZU("favorite")) {
                arrayList.add(this.context.getString(R.string.fn9));
                arrayList2.add(6);
            }
            if (snsInfo.field_type == 15 || snsInfo.field_type == 5) {
                arrayList.add(this.context.getString(R.string.gav));
                arrayList2.add(2);
            } else if (snsInfo.field_type == 1) {
                arrayList.add(this.context.getString(R.string.gaq));
                arrayList2.add(2);
                if (z2) {
                    arrayList.add(this.context.getString(R.string.az0));
                    arrayList2.add(9);
                }
                if (z3) {
                    arrayList.add(this.context.getString(R.string.ayy));
                    arrayList2.add(11);
                }
            } else {
                arrayList.add(this.context.getString(R.string.h_2));
                arrayList2.add(2);
            }
            ef efVar = new ef();
            efVar.dHy.dHp = snsInfo.getLocalid();
            EventCenter.instance.publish(efVar);
            if (efVar.dHz.dGX) {
                arrayList.add(this.context.getString(R.string.xa));
                arrayList2.add(8);
            }
            if (this.Eqn != null) {
                arrayList.add("");
                arrayList2.add(7);
            }
            if (((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch() && snsInfo.field_type == 1 && r.Yn(this.fromScene)) {
                arrayList.add(this.context.getString(R.string.cf_));
                arrayList2.add(10);
                ab abVar = new ab();
                ab abVar2 = abVar.ie("").m7if(r.Jb(this.DqO.field_snsId));
                abVar2.enp = r.Yo(this.fromScene);
                abVar2.eki = 1;
                abVar2.enq = 81;
                abVar.ig("");
                abVar.ih("");
                abVar.ii(com.tencent.mm.b.g.getMD5(ar.ki(aj.getAccSnsPath(), cnb.Id) + r.l(cnb)));
                abVar.enx = System.currentTimeMillis();
                abVar.bfK();
                com.tencent.mm.plugin.websearch.api.ar.a(abVar);
            }
            b(arrayList, arrayList2, snsInfo, cnb, i2);
        } else if (snsInfo == null) {
            AppMethodBeat.o(203257);
            return;
        } else {
            if (snsInfo.getLocalPrivate() > 0) {
                if (!Util.isNullOrNil(aj.fau()) && aj.fau().equals(snsInfo.getUserName())) {
                    arrayList.add(this.context.getString(R.string.h_f));
                    arrayList2.add(5);
                }
                arrayList.add(this.context.getString(R.string.h9u));
                arrayList2.add(3);
            } else {
                arrayList.add(this.context.getString(R.string.h_g));
                arrayList2.add(1);
                arrayList.add(this.context.getString(R.string.h9u));
                arrayList2.add(3);
            }
            if (c.aZU("favorite")) {
                arrayList.add(this.context.getString(R.string.fn9));
                arrayList2.add(6);
            }
            if (snsInfo.field_type == 15 || snsInfo.field_type == 5) {
                arrayList.add(this.context.getString(R.string.gav));
                arrayList2.add(2);
            } else if (snsInfo.field_type == 1) {
                arrayList.add(this.context.getString(R.string.gaq));
                arrayList2.add(2);
                if (z2) {
                    arrayList.add(this.context.getString(R.string.az0));
                    arrayList2.add(9);
                }
                if (z3) {
                    arrayList.add(this.context.getString(R.string.ayy));
                    arrayList2.add(11);
                }
            } else {
                arrayList.add(this.context.getString(R.string.h_2));
                arrayList2.add(2);
            }
            ef efVar2 = new ef();
            efVar2.dHy.dHp = snsInfo.getLocalid();
            EventCenter.instance.publish(efVar2);
            if (efVar2.dHz.dGX) {
                arrayList.add(this.context.getString(R.string.xa));
                arrayList2.add(8);
            }
            if (this.Eqn != null) {
                arrayList.add("");
                arrayList2.add(7);
            }
            if (((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch() && snsInfo.field_type == 1 && r.Yn(this.fromScene)) {
                arrayList.add(this.context.getString(R.string.cf_));
                arrayList2.add(10);
                if (!this.Equ) {
                    ab abVar3 = new ab();
                    ab abVar4 = abVar3.ie("").m7if(r.Jb(this.DqO.field_snsId));
                    abVar4.enp = r.Yo(this.fromScene);
                    abVar4.eki = 1;
                    abVar4.enq = 81;
                    abVar3.ig("");
                    abVar3.ih("");
                    abVar3.ii(com.tencent.mm.b.g.getMD5(ar.ki(aj.getAccSnsPath(), cnb.Id) + r.l(cnb)));
                    abVar3.enx = System.currentTimeMillis();
                    abVar3.bfK();
                    com.tencent.mm.plugin.websearch.api.ar.a(abVar3);
                }
            }
            a(arrayList, arrayList2, snsInfo, cnb, i2);
        }
        if (true == z4) {
            g.aAi();
            if (g.aAg().hqi.aYS() != 0) {
                qx qxVar = new qx();
                String str = ar.ki(aj.getAccSnsPath(), this.Mc) + r.l(cnb);
                qxVar.dXu.filePath = str;
                this.Eqs = System.currentTimeMillis();
                qxVar.dXu.dDZ = this.Eqs;
                this.Eqk = str;
                EventCenter.instance.publish(qxVar);
            }
        }
        AppMethodBeat.o(203257);
    }

    private void a(final List<String> list, final List<Integer> list2, final SnsInfo snsInfo, final cnb cnb, final int i2) {
        AppMethodBeat.i(97914);
        if (this.Epy == null) {
            this.Epy = new e(this.context, 1, false);
        } else if (this.Equ) {
            this.Equ = false;
        }
        this.Epy.HLX = new o.f() {
            /* class com.tencent.mm.plugin.sns.ui.w.AnonymousClass6 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(97899);
                w.this.Epy.setFooterView(null);
                mVar.clear();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (((Integer) list2.get(i2)).intValue() == 7) {
                        w.this.Epy.setFooterView(w.a(w.this, snsInfo));
                    } else {
                        mVar.d(((Integer) list2.get(i2)).intValue(), (CharSequence) list.get(i2));
                    }
                }
                mVar.d(-1, w.this.context.getString(R.string.h5l));
                AppMethodBeat.o(97899);
            }
        };
        this.Epy.HLY = new o.g() {
            /* class com.tencent.mm.plugin.sns.ui.w.AnonymousClass7 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(97902);
                if (w.this.Eqw != null) {
                    w.this.Eqw.ffI();
                }
                int itemId = menuItem.getItemId();
                Log.d("MicroMsg.GalleryTitleManager", "showAlertWithDel ".concat(String.valueOf(itemId)));
                switch (itemId) {
                    case -1:
                        if (snsInfo.getTimeLine().ContentObj.LoV.size() > 1) {
                            h.a(w.this.context, w.this.context.getString(R.string.h9i), "", new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.sns.ui.w.AnonymousClass7.AnonymousClass1 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(97900);
                                    w.this.U(snsInfo);
                                    AppMethodBeat.o(97900);
                                }
                            }, (DialogInterface.OnClickListener) null);
                            AppMethodBeat.o(97902);
                            return;
                        }
                        h.a(w.this.context, w.this.context.getString(R.string.h9g), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.sns.ui.w.AnonymousClass7.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(97901);
                                w.this.U(snsInfo);
                                AppMethodBeat.o(97901);
                            }
                        }, (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(97902);
                        return;
                    case 1:
                        w wVar = w.this;
                        SnsInfo snsInfo = snsInfo;
                        if (snsInfo.isWaitPost() || snsInfo.isDieItem()) {
                            aj.faO().Zs(snsInfo.localid);
                            AppMethodBeat.o(97902);
                            return;
                        }
                        s sVar = new s(snsInfo.field_snsId, 2);
                        g.aAi();
                        g.aAg().hqi.a(sVar, 0);
                        Context context = wVar.context;
                        wVar.context.getString(R.string.zb);
                        wVar.tipDialog = h.a(context, wVar.context.getString(R.string.h_c), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener(sVar) {
                            /* class com.tencent.mm.plugin.sns.ui.w.AnonymousClass2 */
                            final /* synthetic */ s EpC;

                            {
                                this.EpC = r2;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(97896);
                                if (w.this.oUs != 0) {
                                    g.aAi();
                                    g.aAg().hqi.a(this.EpC);
                                    w.this.oUs = 0;
                                }
                                AppMethodBeat.o(97896);
                            }
                        });
                        AppMethodBeat.o(97902);
                        return;
                    case 2:
                        if (!(snsInfo == null || snsInfo.getTimeLine().ContentObj == null)) {
                            if (snsInfo.field_type != 15) {
                                String str = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.l(cnb);
                                if (r.aBO(str) == 4) {
                                    String str2 = com.tencent.mm.vfs.s.k(str, false) + "_tmp";
                                    com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ(str2));
                                    ((com.tencent.mm.plugin.emoji.b.c) g.af(com.tencent.mm.plugin.emoji.b.c.class)).nativeWxam2Pic(com.tencent.mm.vfs.s.k(str, false), str2);
                                    com.tencent.mm.pluginsdk.ui.tools.s.l(str2, w.this.context);
                                    AppMethodBeat.o(97902);
                                    return;
                                }
                                com.tencent.mm.pluginsdk.ui.tools.s.l(str, w.this.context);
                                AppMethodBeat.o(97902);
                                return;
                            }
                            w.aQS(snsInfo.getLocalid());
                            AppMethodBeat.o(97902);
                            return;
                        }
                    case 3:
                        if (!(snsInfo == null || snsInfo.getTimeLine().ContentObj == null)) {
                            if (snsInfo.getTimeLine().ContentObj.LoU == 1) {
                                w.this.aQR(ar.ki(aj.getAccSnsPath(), cnb.Id) + r.l(cnb));
                                AppMethodBeat.o(97902);
                                return;
                            }
                            w.aQT(snsInfo.getLocalid());
                            AppMethodBeat.o(97902);
                            return;
                        }
                    case 5:
                        w wVar2 = w.this;
                        s sVar2 = new s(snsInfo.field_snsId, 3);
                        g.aAi();
                        g.aAg().hqi.a(sVar2, 0);
                        Context context2 = wVar2.context;
                        wVar2.context.getString(R.string.zb);
                        wVar2.tipDialog = h.a(context2, wVar2.context.getString(R.string.h_c), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener(sVar2) {
                            /* class com.tencent.mm.plugin.sns.ui.w.AnonymousClass3 */
                            final /* synthetic */ s EpD;

                            {
                                this.EpD = r2;
                            }

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(203251);
                                g.aAi();
                                g.aAg().hqi.a(this.EpD);
                                AppMethodBeat.o(203251);
                            }
                        });
                        AppMethodBeat.o(97902);
                        return;
                    case 6:
                        if (!(snsInfo == null || snsInfo.getTimeLine().ContentObj == null)) {
                            w.a(w.this, snsInfo, cnb);
                            AppMethodBeat.o(97902);
                            return;
                        }
                    case 8:
                        w.b(w.this, snsInfo, cnb);
                        AppMethodBeat.o(97902);
                        return;
                    case 9:
                        if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(w.this.context)) {
                            wj wjVar = new wj();
                            wjVar.ecv.mediaId = w.this.Mc;
                            EventCenter.instance.publish(wjVar);
                            AppMethodBeat.o(97902);
                            return;
                        }
                        break;
                    case 10:
                        if (snsInfo.getTimeLine().ContentObj.LoU == 1) {
                            com.tencent.mm.plugin.websearch.api.o oVar = new com.tencent.mm.plugin.websearch.api.o();
                            oVar.context = w.this.context;
                            oVar.dHq = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.l(cnb);
                            oVar.IDs = w.this.DqO.field_userName;
                            oVar.dRS = r.Jb(w.this.DqO.field_snsId);
                            oVar.DIq = cnb;
                            oVar.dGf = r.Yo(w.this.fromScene);
                            ((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(oVar);
                            AppMethodBeat.o(97902);
                            return;
                        }
                        break;
                    case 11:
                        if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(w.this.context)) {
                            vw vwVar = new vw();
                            vwVar.ebW.mediaId = w.this.Mc;
                            vwVar.ebW.dkU = snsInfo.getUserName();
                            EventCenter.instance.publish(vwVar);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(97902);
            }
        };
        this.Epy.PGl = new e.b() {
            /* class com.tencent.mm.plugin.sns.ui.w.AnonymousClass8 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                AppMethodBeat.i(97903);
                if (w.this.Eqw != null) {
                    w.this.Eqw.ffI();
                }
                ax axVar = new ax();
                axVar.dDY.dDZ = w.this.Eqs;
                axVar.dDY.filePath = w.this.Eqk;
                EventCenter.instance.publish(axVar);
                w.this.Epy = null;
                w.this.Eqk = null;
                w.this.DqO = null;
                w.this.Mc = null;
                w.this.Eqn = null;
                w.this.Eqo = null;
                w.this.Eqp = null;
                w.this.Eqr = null;
                w.this.Eqq = null;
                w wVar = w.this;
                w.this.dFM = 0;
                wVar.dFL = 0;
                w.this.EqZ = 0;
                AppMethodBeat.o(97903);
            }
        };
        this.Epy.dGm();
        if (this.Eqw != null) {
            this.Eqw.ha(list2);
        }
        AppMethodBeat.o(97914);
    }

    private void b(final List<String> list, final List<Integer> list2, final SnsInfo snsInfo, final cnb cnb, final int i2) {
        AppMethodBeat.i(97915);
        if (list.size() == 0) {
            AppMethodBeat.o(97915);
            return;
        }
        if (this.Epy == null) {
            this.Epy = new e(this.context, 1, false);
        } else if (this.Equ) {
            this.Equ = false;
        }
        this.Epy.HLX = new o.f() {
            /* class com.tencent.mm.plugin.sns.ui.w.AnonymousClass9 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(97904);
                w.this.Epy.setFooterView(null);
                mVar.clear();
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (((Integer) list2.get(i2)).intValue() == 7) {
                        w.this.Epy.setFooterView(w.a(w.this, snsInfo));
                    } else {
                        mVar.d(((Integer) list2.get(i2)).intValue(), (CharSequence) list.get(i2));
                    }
                }
                AppMethodBeat.o(97904);
            }
        };
        this.Epy.HLY = new o.g() {
            /* class com.tencent.mm.plugin.sns.ui.w.AnonymousClass10 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(97905);
                int itemId = menuItem.getItemId();
                Log.d("MicroMsg.GalleryTitleManager", "showAlert ".concat(String.valueOf(itemId)));
                switch (itemId) {
                    case 2:
                        if (!(snsInfo == null || snsInfo.getTimeLine().ContentObj == null)) {
                            if (snsInfo.field_type != 15) {
                                com.tencent.mm.pluginsdk.ui.tools.s.l(ar.ki(aj.getAccSnsPath(), cnb.Id) + r.l(cnb), w.this.context);
                                AppMethodBeat.o(97905);
                                return;
                            }
                            w.aQS(snsInfo.getLocalid());
                            AppMethodBeat.o(97905);
                            return;
                        }
                    case 3:
                        if (!(snsInfo == null || snsInfo.getTimeLine().ContentObj == null)) {
                            if (snsInfo.getTimeLine().ContentObj.LoU == 1) {
                                w.this.aQR(ar.ki(aj.getAccSnsPath(), cnb.Id) + r.l(cnb));
                                AppMethodBeat.o(97905);
                                return;
                            }
                            w.aQT(snsInfo.getLocalid());
                            AppMethodBeat.o(97905);
                            return;
                        }
                    case 4:
                        w wVar = w.this;
                        long j2 = snsInfo.field_snsId;
                        SnsInfo JJ = aj.faO().JJ(j2);
                        if (j2 == 0 || JJ == null) {
                            AppMethodBeat.o(97905);
                            return;
                        }
                        Intent intent = new Intent();
                        intent.putExtra("k_username", JJ.getUserName());
                        intent.putExtra("k_expose_msg_id", j2);
                        intent.putExtra("showShare", false);
                        intent.putExtra("rawUrl", String.format(e.C2115e.OyU, 33));
                        c.b(wVar.context, "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(97905);
                        return;
                    case 6:
                        if (!(snsInfo == null || snsInfo.getTimeLine().ContentObj == null)) {
                            w.a(w.this, snsInfo, cnb);
                            AppMethodBeat.o(97905);
                            return;
                        }
                    case 8:
                        w.b(w.this, snsInfo, cnb);
                        AppMethodBeat.o(97905);
                        return;
                    case 9:
                        if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(w.this.context)) {
                            wj wjVar = new wj();
                            wjVar.ecv.mediaId = w.this.Mc;
                            EventCenter.instance.publish(wjVar);
                            AppMethodBeat.o(97905);
                            return;
                        }
                        break;
                    case 10:
                        if (snsInfo.getTimeLine().ContentObj.LoU == 1) {
                            com.tencent.mm.plugin.websearch.api.o oVar = new com.tencent.mm.plugin.websearch.api.o();
                            oVar.context = w.this.context;
                            oVar.dHq = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.l(cnb);
                            oVar.IDs = w.this.DqO.field_userName;
                            oVar.dRS = r.Jb(w.this.DqO.field_snsId);
                            oVar.DIq = cnb;
                            oVar.dGf = r.Yo(w.this.fromScene);
                            ((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(oVar);
                            AppMethodBeat.o(97905);
                            return;
                        }
                        break;
                    case 11:
                        if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(w.this.context)) {
                            vw vwVar = new vw();
                            vwVar.ebW.mediaId = w.this.Mc;
                            vwVar.ebW.dkU = snsInfo.getUserName();
                            EventCenter.instance.publish(vwVar);
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(97905);
            }
        };
        this.Epy.PGl = new e.b() {
            /* class com.tencent.mm.plugin.sns.ui.w.AnonymousClass11 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                AppMethodBeat.i(203254);
                ax axVar = new ax();
                axVar.dDY.dDZ = w.this.Eqs;
                axVar.dDY.filePath = w.this.Eqk;
                EventCenter.instance.publish(axVar);
                w.this.Epy = null;
                w.this.Eqk = null;
                w.this.DqO = null;
                w.this.Mc = null;
                w.this.Eqn = null;
                w.this.Eqo = null;
                w.this.Eqp = null;
                w.this.Eqr = null;
                w.this.Eqq = null;
                w wVar = w.this;
                w.this.dFM = 0;
                wVar.dFL = 0;
                w.this.EqZ = 0;
                AppMethodBeat.o(203254);
            }
        };
        this.Epy.dGm();
        AppMethodBeat.o(97915);
    }

    /* access modifiers changed from: protected */
    public final void U(SnsInfo snsInfo) {
        AppMethodBeat.i(97916);
        if (snsInfo.isWaitPost() || snsInfo.isDieItem()) {
            aj.faO().Zs(snsInfo.localid);
            this.EqW.Yj(snsInfo.localid);
            AppMethodBeat.o(97916);
            return;
        }
        aj.faN().Jr(snsInfo.field_snsId);
        final s sVar = new s(snsInfo.field_snsId, 1);
        g.aAi();
        g.aAg().hqi.a(sVar, 0);
        Context context2 = this.context;
        this.context.getString(R.string.zb);
        this.tipDialog = h.a(context2, this.context.getString(R.string.h5m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.sns.ui.w.AnonymousClass13 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(97908);
                if (w.this.oUs != 0) {
                    g.aAi();
                    g.aAg().hqi.a(sVar);
                    w.this.oUs = 0;
                }
                AppMethodBeat.o(97908);
            }
        });
        AppMethodBeat.o(97916);
    }

    /* access modifiers changed from: protected */
    public final void aQR(String str) {
        AppMethodBeat.i(97917);
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        com.tencent.mm.plugin.sns.c.a.jRt.k(intent, this.context);
        AppMethodBeat.o(97917);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(97918);
        if (i2 == 0 && i3 == 0 && qVar != null) {
            Log.i("MicroMsg.GalleryTitleManager", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str + " type = " + qVar.getType() + " @" + hashCode());
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
            }
            s sVar = (s) qVar;
            switch (sVar.type) {
                case -1:
                    this.EqX.fH("", sVar.type);
                    AppMethodBeat.o(97918);
                    return;
                case 1:
                    this.EqW.Yj(sVar.ecf);
                    this.EqX.fH(y.bq("sns_table_", (long) sVar.ecf), sVar.type);
                    AppMethodBeat.o(97918);
                    return;
                case 2:
                    this.EqW.Yk(sVar.ecf);
                    this.EqX.fH("", sVar.type);
                    AppMethodBeat.o(97918);
                    return;
                case 3:
                    this.EqW.Yk(sVar.ecf);
                    this.EqX.fH(y.bq("sns_table_", (long) sVar.ecf), sVar.type);
                    break;
            }
            AppMethodBeat.o(97918);
            return;
        }
        AppMethodBeat.o(97918);
    }

    static /* synthetic */ View a(w wVar, final SnsInfo snsInfo) {
        AppMethodBeat.i(97919);
        View a2 = wVar.mHu.a(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.w.AnonymousClass12 */

            public final void onClick(View view) {
                AppMethodBeat.i(203255);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/GalleryTitleManager$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.i("MicroMsg.GalleryTitleManager", "request deal QBAR string");
                if (w.this.Epy != null && w.this.Epy.isShowing()) {
                    w.this.Epy.bMo();
                }
                Bundle bundle = new Bundle();
                bundle.putString("stat_msg_id", "sns_" + r.Jb(snsInfo.field_snsId));
                bundle.putString("stat_send_msg_user", snsInfo.field_userName);
                bundle.putInt("stat_scene", 3);
                w wVar = w.this;
                Log.i("MicroMsg.GalleryTitleManager", "request deal QBAR string");
                cr crVar = new cr();
                crVar.dFK.activity = (Activity) wVar.context;
                crVar.dFK.dDX = wVar.Eqn;
                crVar.dFK.dFL = wVar.dFL;
                crVar.dFK.dFM = wVar.dFM;
                crVar.dFK.dFP = bundle;
                EventCenter.instance.publish(crVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/GalleryTitleManager$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203255);
            }
        }, wVar.dFL, wVar.Eqn, 6);
        AppMethodBeat.o(97919);
        return a2;
    }

    static /* synthetic */ void a(w wVar, SnsInfo snsInfo, cnb cnb) {
        AppMethodBeat.i(203258);
        if (snsInfo == null) {
            Log.i("MicroMsg.GalleryTitleManager", "error beacause info null");
            AppMethodBeat.o(203258);
        } else if (snsInfo.field_type == 1) {
            cz czVar = new cz();
            com.tencent.mm.plugin.sns.l.a.a(czVar, snsInfo, cnb.Id);
            czVar.dFZ.activity = (Activity) wVar.context;
            czVar.dFZ.dGf = 15;
            EventCenter.instance.publish(czVar);
            AppMethodBeat.o(203258);
        } else {
            if (snsInfo != null) {
                if (!snsInfo.isAd()) {
                    String localid = snsInfo.getLocalid();
                    wn wnVar = new wn();
                    wnVar.ecy.dKy = 2;
                    wnVar.ecy.ecz = 16;
                    wnVar.ecy.ecA = false;
                    wnVar.ecy.dJX = localid;
                    EventCenter.instance.publish(wnVar);
                    AppMethodBeat.o(203258);
                    return;
                }
                cz czVar2 = new cz();
                com.tencent.mm.plugin.sns.l.a.a(czVar2, snsInfo);
                czVar2.dFZ.activity = (Activity) wVar.context;
                czVar2.dFZ.dGf = 16;
                EventCenter.instance.publish(czVar2);
            }
            AppMethodBeat.o(203258);
        }
    }

    static /* synthetic */ void b(w wVar, SnsInfo snsInfo, cnb cnb) {
        AppMethodBeat.i(203259);
        if (snsInfo == null) {
            Log.e("MicroMsg.GalleryTitleManager", "error beacause info null");
            AppMethodBeat.o(203259);
            return;
        }
        Intent intent = new Intent();
        if (snsInfo.field_type == 1) {
            String str = cnb.Id;
            intent.putExtra("sns_send_data_ui_image_path", FlipView.i(ar.ki(aj.getAccSnsPath(), str) + r.l(cnb), wVar.context));
            intent.putExtra("sns_send_data_ui_image_media_id", str);
        }
        intent.putExtra("sns_send_data_ui_activity", true);
        intent.putExtra("sns_local_id", snsInfo.getLocalid());
        c.f(wVar.context, ".ui.chatting.ChattingSendDataToDeviceUI", intent);
        AppMethodBeat.o(203259);
    }

    static /* synthetic */ void aQS(String str) {
        AppMethodBeat.i(203260);
        wn wnVar = new wn();
        wnVar.ecy.dKy = 3;
        wnVar.ecy.dJX = str;
        EventCenter.instance.publish(wnVar);
        AppMethodBeat.o(203260);
    }

    static /* synthetic */ void aQT(String str) {
        AppMethodBeat.i(203261);
        wn wnVar = new wn();
        wnVar.ecy.dKy = 1;
        wnVar.ecy.ecB = 2;
        wnVar.ecy.dJX = str;
        EventCenter.instance.publish(wnVar);
        AppMethodBeat.o(203261);
    }
}
