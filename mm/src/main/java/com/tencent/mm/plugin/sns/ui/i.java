package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.va;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.plugin.sns.model.bc;
import com.tencent.mm.plugin.sns.model.s;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.SnsCommentFooter;
import com.tencent.mm.plugin.sns.ui.d.c;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.widget.e;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class i implements ab {
    public static List<k> EoP = new LinkedList();
    public bk DQX;
    FrameLayout DQt;
    public k EoE;
    public bc EoF;
    private boolean EoG;
    boolean EoH;
    b EoI;
    SnsCommentFooter EoJ;
    bt EoK;
    bb EoL;
    private boolean EoM;
    String EoN;
    private boolean EoO;
    bs EoQ;
    b EoR;
    com.tencent.mm.plugin.sns.h.b EoS;
    ap EoT;
    bu EoU;
    public c EoV;
    q EoW;
    private IListener EoX;
    private IListener EoY;
    View.OnLongClickListener EoZ;
    Context context;
    String gna;
    public ListView list;

    /* access modifiers changed from: package-private */
    public interface b {
        void ffv();
    }

    public i(Context context2) {
        this(context2, 2, "", 0, "");
    }

    public int ffo() {
        return 0;
    }

    public i(Context context2, int i2, String str, int i3, String str2) {
        AppMethodBeat.i(97823);
        this.EoH = false;
        this.EoI = null;
        this.EoM = false;
        this.EoN = "";
        this.EoO = false;
        this.EoW = null;
        this.EoX = new IListener<cg>() {
            /* class com.tencent.mm.plugin.sns.ui.i.AnonymousClass3 */

            {
                AppMethodBeat.i(160692);
                this.__eventId = cg.class.getName().hashCode();
                AppMethodBeat.o(160692);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(cg cgVar) {
                AppMethodBeat.i(97811);
                if (i.this.EoQ != null) {
                    i.this.EoQ.ffL();
                }
                AppMethodBeat.o(97811);
                return false;
            }
        };
        this.EoY = new IListener<va>() {
            /* class com.tencent.mm.plugin.sns.ui.i.AnonymousClass4 */

            {
                AppMethodBeat.i(160693);
                this.__eventId = va.class.getName().hashCode();
                AppMethodBeat.o(160693);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(va vaVar) {
                boolean z;
                AppMethodBeat.i(97812);
                va vaVar2 = vaVar;
                if ((vaVar2 instanceof va) && i.this.list != null) {
                    ListView listView = i.this.list;
                    if (!vaVar2.ebs.enable) {
                        z = true;
                    } else {
                        z = false;
                    }
                    listView.requestDisallowInterceptTouchEvent(z);
                }
                AppMethodBeat.o(97812);
                return false;
            }
        };
        this.EoZ = new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.i.AnonymousClass7 */

            public final boolean onLongClick(View view) {
                AppMethodBeat.i(97815);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/BaseTimeLine$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                g.aAi();
                if (!((Boolean) g.aAh().azQ().get(7490, Boolean.TRUE)).booleanValue()) {
                    Intent intent = new Intent();
                    intent.setClass(i.this.context, SnsCommentUI.class);
                    intent.putExtra("sns_comment_type", 1);
                    ((MMActivity) i.this.context).startActivityForResult(intent, 9);
                } else {
                    Context context = i.this.context;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent().setClass(i.this.context, SnsLongMsgUI.class));
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/ui/BaseTimeLine$6", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sns/ui/BaseTimeLine$6", "onLongClick", "(Landroid/view/View;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    g.aAi();
                    g.aAh().azQ().set(7490, Boolean.FALSE);
                }
                com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sns/ui/BaseTimeLine$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                AppMethodBeat.o(97815);
                return true;
            }
        };
        this.context = context2;
        this.gna = z.aTY();
        this.EoF = new bc();
        this.EoF.DMa = new com.tencent.mm.plugin.sns.k.b(i2, str, i3, str2);
        this.EoV = new c((Activity) context2, this.EoF) {
            /* class com.tencent.mm.plugin.sns.ui.i.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void dS(Object obj) {
                AppMethodBeat.i(97799);
                long j2 = 0;
                Object tag = ((View) obj).getTag();
                if (tag instanceof bc) {
                    bc bcVar = (bc) tag;
                    if (i.this.EoE != null) {
                        j2 = i.this.EoE.fr(bcVar.dJX, 6);
                    }
                }
                i.this.EoL.a((View) obj, 1, 0, i.this.EoF, j2);
                AppMethodBeat.o(97799);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void ffw() {
                AppMethodBeat.i(97800);
                if (i.this.DQX != null) {
                    i.this.DQX.fiR();
                }
                AppMethodBeat.o(97800);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void fo(View view) {
                AppMethodBeat.i(97801);
                BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
                if (i.this.DQX.fiN() == null) {
                    AppMethodBeat.o(97801);
                    return;
                }
                i.this.DQX.fiN().ffL();
                new SnsInfo();
                SnsInfo Zv = i.this.DQX.Zv(baseViewHolder.position);
                if (!Zv.isValid()) {
                    AppMethodBeat.o(97801);
                    return;
                }
                com.tencent.mm.modelsns.k tO = com.tencent.mm.modelsns.k.tO(741);
                SnsObject C = an.C(Zv);
                tO.PH(r.v(Zv)).tR(Zv.field_type).fL(Zv.isAd()).PH(Zv.getUxinfo()).PH(Zv.getUserName()).tR(C == null ? 0 : C.LikeCount).tR(C == null ? 0 : C.CommentCount);
                tO.bfK();
                if (!Zv.isAd() || (Zv.getTimeLine().ContentObj.LoW & 8) == 0) {
                    i iVar = i.this;
                    dzo dzo = new dzo();
                    String str = baseViewHolder.dRS;
                    iVar.EoN = str;
                    Log.i("MicroMsg.BaseTimeLine", "[performCommentIconClick] onCommentClick:  commentkey " + iVar.EoN + " " + baseViewHolder.dRS + " position:" + baseViewHolder.position);
                    iVar.T(Zv);
                    iVar.EoJ.setTag(Zv);
                    iVar.cqk();
                    iVar.EoJ.setVisibility(0);
                    iVar.EoJ.ECO = i.fJ(str, 0);
                    iVar.EoJ.setCommentInfo(dzo);
                    iVar.EoJ.setCommentHint(iVar.context.getString(R.string.hbp));
                    iVar.EoJ.o(i.EoP, str);
                    iVar.EoJ.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.i.AnonymousClass10 */

                        public final void run() {
                            AppMethodBeat.i(97818);
                            i.this.EoJ.setToSendTextColor(true);
                            AppMethodBeat.o(97818);
                        }
                    });
                    iVar.EoJ.oY(false);
                    iVar.h(baseViewHolder);
                    if (iVar.EoJ.ECT) {
                        h.INSTANCE.dN(150, 80);
                    }
                    AppMethodBeat.o(97801);
                    return;
                }
                i iVar2 = i.this;
                dzo dzo2 = new dzo();
                iVar2.EoN = null;
                Log.i("MicroMsg.BaseTimeLine", "[performAdAtFriendClick] onCommentClick:  commentkey " + iVar2.EoN + " " + baseViewHolder.dRS + " position:" + baseViewHolder.position);
                iVar2.T(Zv);
                iVar2.EoJ.setTag(Zv);
                iVar2.cqk();
                iVar2.EoJ.setVisibility(0);
                iVar2.EoJ.ECO = 0;
                iVar2.EoJ.setCommentHint("");
                iVar2.EoJ.setCommentInfo(dzo2);
                iVar2.EoJ.oY(true);
                iVar2.EoJ.o(i.EoP, "");
                iVar2.EoJ.post(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.i.AnonymousClass9 */

                    public final void run() {
                        AppMethodBeat.i(97817);
                        i.this.EoJ.setToSendTextColor(true);
                        AppMethodBeat.o(97817);
                    }
                });
                iVar2.h(baseViewHolder);
                if (iVar2.EoJ.ECT) {
                    h.INSTANCE.dN(150, 80);
                }
                AppMethodBeat.o(97801);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void fp(View view) {
                AppMethodBeat.i(97802);
                if (view.getTag() instanceof BaseTimeLineItem.BaseViewHolder) {
                    BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
                    if (i.this.DQX.fiN() == null) {
                        AppMethodBeat.o(97802);
                        return;
                    }
                    i.this.DQX.fiN().ffL();
                    new SnsInfo();
                    SnsInfo Zv = i.this.DQX.Zv(baseViewHolder.position);
                    if (!Zv.isValid()) {
                        AppMethodBeat.o(97802);
                        return;
                    }
                    com.tencent.mm.modelsns.k tO = com.tencent.mm.modelsns.k.tO(741);
                    SnsObject C = an.C(Zv);
                    tO.PH(r.v(Zv)).tR(Zv.field_type).fL(Zv.isAd()).PH(Zv.getUxinfo()).PH(Zv.getUserName()).tR(C == null ? 0 : C.LikeCount).tR(C == null ? 0 : C.CommentCount);
                    tO.bfK();
                    i iVar = i.this;
                    dzo dzo = new dzo();
                    String str = baseViewHolder.dRS + "@boss";
                    iVar.EoN = str;
                    Log.i("MicroMsg.BaseTimeLine", "[performAdAtBossClick] onCommentClick:  commentkey " + iVar.EoN + " " + baseViewHolder.dRS + " position:" + baseViewHolder.position);
                    g.aAi();
                    String arJ = ((l) g.af(l.class)).aSN().bjJ(Zv.getUserName()).arJ();
                    if (Zv.isAd()) {
                        arJ = e.c(Zv.getAdXml(), arJ);
                    }
                    iVar.T(Zv);
                    iVar.EoJ.setTag(Zv);
                    iVar.cqk();
                    iVar.EoJ.setVisibility(0);
                    iVar.EoJ.setCommentFlag(i.fJ(str, 1));
                    iVar.EoJ.setCommentHint(arJ);
                    iVar.EoJ.setCommentInfo(dzo);
                    iVar.EoJ.o(i.EoP, str);
                    iVar.EoJ.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.i.AnonymousClass8 */

                        public final void run() {
                            AppMethodBeat.i(97816);
                            i.this.EoJ.setToSendTextColor(true);
                            AppMethodBeat.o(97816);
                        }
                    });
                    iVar.h(baseViewHolder);
                    if (iVar.EoJ.ECT) {
                        h.INSTANCE.dN(150, 80);
                    }
                }
                AppMethodBeat.o(97802);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void fq(View view) {
                AppMethodBeat.i(97803);
                if (i.this.DQX != null) {
                    i.this.DQX.fz(view);
                }
                AppMethodBeat.o(97803);
            }

            /* JADX WARNING: Removed duplicated region for block: B:28:0x0119  */
            /* JADX WARNING: Removed duplicated region for block: B:35:0x016b  */
            /* JADX WARNING: Removed duplicated region for block: B:42:0x01a4  */
            @Override // com.tencent.mm.plugin.sns.ui.d.c
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void fr(final android.view.View r23) {
                /*
                // Method dump skipped, instructions count: 422
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.i.AnonymousClass1.fr(android.view.View):void");
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void fs(View view) {
                AppMethodBeat.i(97805);
                i.this.EoU.fka();
                i.this.EoQ.ffL();
                i.this.EoT.fcl();
                i.this.EoR.onr = true;
                i.this.EoR.fn(view);
                AppMethodBeat.o(97805);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void ffx() {
                AppMethodBeat.i(97806);
                i.this.EoR.ffh();
                AppMethodBeat.o(97806);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void ft(View view) {
                AppMethodBeat.i(97807);
                i.this.EoR.fcl();
                if (view.getTag() != null) {
                    com.tencent.mm.plugin.sns.data.c cVar = (com.tencent.mm.plugin.sns.data.c) view.getTag();
                    i.this.EoE.a(cVar.position, cVar.dHp, cVar.ece, 1);
                    try {
                        SnsInfo aQm = aj.faO().aQm(cVar.dHp);
                        if (aQm == null || !aQm.isAd()) {
                            Log.e("MicroMsg.TimelineClickListener", "reportAdFeedBackDel: info is null or not ad");
                            AppMethodBeat.o(97807);
                            return;
                        }
                        com.tencent.mm.plugin.sns.data.i.a(2, cVar.ece, aQm.getAdInfo(), aQm.getAdXml());
                        AppMethodBeat.o(97807);
                        return;
                    } catch (Throwable th) {
                        Log.e("MicroMsg.TimelineClickListener", "reportAdFeedBackDel: " + th.toString());
                    }
                }
                AppMethodBeat.o(97807);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void ffy() {
                AppMethodBeat.i(203229);
                i.this.EoR.fcl();
                AppMethodBeat.o(203229);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void fu(View view) {
                AppMethodBeat.i(97808);
                i.this.EoU.fka();
                i.this.EoQ.ffL();
                i.this.EoR.fcl();
                i.this.EoT.onr = true;
                if (i.this.ffo() == 0) {
                    i.this.EoT.v(view, false);
                    AppMethodBeat.o(97808);
                    return;
                }
                i.this.EoT.v(view, true);
                AppMethodBeat.o(97808);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.c
            public final void ffz() {
                AppMethodBeat.i(97809);
                i.this.EoT.fcl();
                AppMethodBeat.o(97809);
            }
        };
        this.EoV.ebz();
        EventCenter.instance.addListener(this.EoX);
        EventCenter.instance.addListener(this.EoY);
        AppMethodBeat.o(97823);
    }

    static {
        AppMethodBeat.i(97828);
        AppMethodBeat.o(97828);
    }

    public final void b(k kVar) {
        AppMethodBeat.i(203230);
        this.EoE = kVar;
        if (this.EoV != null) {
            this.EoV.c(kVar);
        }
        AppMethodBeat.o(203230);
    }

    /* access modifiers changed from: package-private */
    public final void cqk() {
        AppMethodBeat.i(97824);
        if (this.EoM) {
            AppMethodBeat.o(97824);
            return;
        }
        this.EoM = true;
        this.EoJ.setAfterEditAction(this.EoK.ERL);
        this.EoJ.setOnCommentSendImp(new SnsCommentFooter.b() {
            /* class com.tencent.mm.plugin.sns.ui.i.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.sns.ui.SnsCommentFooter.b
            public final void kP(String str, String str2) {
                String sb;
                e.b bVar;
                AppMethodBeat.i(97813);
                SnsInfo snsInfo = (SnsInfo) i.this.EoJ.getTag();
                Log.d("MicroMsg.BaseTimeLine", "onCommentSend click");
                if ((str == null || str.trim().equals("")) && Util.isNullOrNil(str2)) {
                    Log.e("MicroMsg.BaseTimeLine", "onCommentSend tosendText is null or empty");
                    AppMethodBeat.o(97813);
                    return;
                }
                dzo commentInfo = i.this.EoJ.getCommentInfo();
                SnsObject C = an.C(snsInfo);
                com.tencent.mm.modelsns.k tO = com.tencent.mm.modelsns.k.tO((commentInfo.MYT == 0 && commentInfo.MYV == 0) ? 708 : 709);
                if (tO.opType == 708) {
                    tO.PH(r.v(snsInfo)).tR(snsInfo.field_type).fL(snsInfo.isAd()).PH(snsInfo.getUxinfo()).PH(snsInfo.field_userName).tR(C.LikeCount).tR(C.CommentCount);
                } else {
                    com.tencent.mm.modelsns.k PH = tO.PH(r.v(snsInfo)).tR(snsInfo.field_type).fL(snsInfo.isAd()).PH(snsInfo.getUxinfo()).PH(commentInfo.Username);
                    if (commentInfo.MYT == 0) {
                        sb = new StringBuilder().append(commentInfo.MYV).toString();
                    } else {
                        sb = new StringBuilder().append(commentInfo.MYT).toString();
                    }
                    PH.PH(sb).tR(C.LikeCount).tR(C.CommentCount);
                }
                tO.bfK();
                if (i.this.EoF != null) {
                    i.this.EoF.DMa.L(snsInfo);
                }
                int commentFlag = i.this.EoJ.getCommentFlag();
                Log.i("MicroMsg.BaseTimeLine", "onCommentSend click %s", Integer.valueOf(commentFlag));
                if (com.tencent.mm.plugin.sns.ui.widget.e.iY(commentFlag, 8)) {
                    String substring = str.substring(i.this.EoJ.getCommentAtPrefix().length());
                    Log.i("MicroMsg.BaseTimeLine", "send atFriend ad timeline comment");
                    aq.a.a(snsInfo, 16, substring, i.this.EoJ.getCommentInfo(), commentFlag, 0, str2);
                } else {
                    Log.i("MicroMsg.BaseTimeLine", "send timeline comment");
                    aq.a.a(snsInfo, snsInfo.isAd() ? 8 : 2, str, i.this.EoJ.getCommentInfo(), commentFlag, 0, str2);
                }
                i.this.DQX.aB(i.this.EoK.ERL);
                i.this.ffp();
                if (Util.isNullOrNil(str2) && !Util.isNullOrNil(i.this.EoN)) {
                    Iterator<k> it = i.EoP.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        k next = it.next();
                        if (i.this.EoN.equals(next.key)) {
                            Log.d("MicroMsg.BaseTimeLine", "remove ct");
                            i.EoP.remove(next);
                            break;
                        }
                    }
                }
                com.tencent.mm.plugin.sns.k.e eVar = com.tencent.mm.plugin.sns.k.e.DUQ;
                String Jb = r.Jb(snsInfo.field_snsId);
                if (!(Jb == null || (bVar = eVar.DVc.get(Jb)) == null || bVar.DVQ == null)) {
                    bVar.DVQ.eOZ = 1;
                }
                AppMethodBeat.o(97813);
            }
        });
        SnsCommentFooter snsCommentFooter = this.EoJ;
        AnonymousClass6 r1 = new MMEditText.a() {
            /* class com.tencent.mm.plugin.sns.ui.i.AnonymousClass6 */

            @Override // com.tencent.mm.ui.widget.MMEditText.a
            public final void onBack() {
                AppMethodBeat.i(97814);
                if (i.this.EoJ.getVisibility() == 0) {
                    i.this.EoJ.setVisibility(8);
                    AppMethodBeat.o(97814);
                    return;
                }
                ((Activity) i.this.context).finish();
                AppMethodBeat.o(97814);
            }
        };
        if (snsCommentFooter.ECK != null) {
            snsCommentFooter.ECK.setBackListener(r1);
        }
        AppMethodBeat.o(97824);
    }

    /* access modifiers changed from: package-private */
    public final void ffp() {
        AppMethodBeat.i(97825);
        if (!this.EoM) {
            AppMethodBeat.o(97825);
            return;
        }
        if (this.EoJ.getVisibility() != 8) {
            this.EoJ.setVisibility(8);
        }
        bk bkVar = this.DQX;
        if (bkVar.EKo != null) {
            bkVar.EKo.setVisibility(8);
        }
        bkVar.EKo = null;
        AppMethodBeat.o(97825);
    }

    /* access modifiers changed from: package-private */
    public final void h(BaseTimeLineItem.BaseViewHolder baseViewHolder) {
        int i2;
        AppMethodBeat.i(97826);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix(this.context, 8);
        if (baseViewHolder.EWQ != null) {
            i2 = fromDPToPix + (baseViewHolder.EWT.getHeight() - baseViewHolder.EWQ.getBottom());
            Log.i("MicroMsg.BaseTimeLine", "comment item bottom = " + baseViewHolder.EWQ.getBottom());
        } else {
            i2 = 0;
        }
        this.EoK.position = baseViewHolder.position;
        this.EoK.ERG = baseViewHolder.convertView.getHeight() - i2;
        baseViewHolder.EWQ = null;
        this.EoK.ERH = baseViewHolder.convertView.getTop();
        this.EoK.EBc = this.list.getBottom();
        Log.e("MicroMsg.BaseTimeLine", "originalTop:" + this.EoK.ERH);
        if (!(this.context instanceof MMActivity) || ((MMActivity) this.context).keyboardState() == 1) {
            this.EoK.fjY();
            AppMethodBeat.o(97826);
            return;
        }
        this.EoG = true;
        AppMethodBeat.o(97826);
    }

    /* access modifiers changed from: package-private */
    public final void T(SnsInfo snsInfo) {
        AppMethodBeat.i(176293);
        if (snsInfo == null || snsInfo.getTimeLine() == null || snsInfo.getTimeLine().ContentObj == null || (snsInfo.getTimeLine().ContentObj.LoW & 128) != 0) {
            this.EoJ.setFeedEmojiCommentEnable(false);
            AppMethodBeat.o(176293);
            return;
        }
        this.EoJ.setFeedEmojiCommentEnable(true);
        AppMethodBeat.o(176293);
    }

    public final void ffq() {
        AppMethodBeat.i(203231);
        if (this.EoG) {
            this.EoG = false;
            this.EoK.fjY();
        }
        AppMethodBeat.o(203231);
    }

    @Override // com.tencent.mm.plugin.sns.ui.ab
    public final ap ffr() {
        return this.EoT;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ab
    public final b ffs() {
        return this.EoR;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ab
    public final bs fft() {
        return this.EoQ;
    }

    @Override // com.tencent.mm.plugin.sns.ui.ab
    public final bu ffu() {
        return this.EoU;
    }

    public class a implements View.OnClickListener {
        private dzo DIu;
        private BaseTimeLineItem.BaseViewHolder Eon;
        private CharSequence Epf = "";
        private String gCv;

        public a(dzo dzo, String str, CharSequence charSequence, BaseTimeLineItem.BaseViewHolder baseViewHolder) {
            this.gCv = str;
            this.DIu = dzo;
            this.Eon = baseViewHolder;
            this.Epf = charSequence;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(97822);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/BaseTimeLine$CommentClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!y.aQJ(this.Eon.dRS)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/BaseTimeLine$CommentClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97822);
                return;
            }
            this.Eon.EWQ = view;
            if (this.DIu == null || this.DIu.Username == null || !this.DIu.Username.equals(i.this.gna)) {
                new SnsInfo();
                SnsInfo Zv = i.this.DQX.Zv(this.Eon.position);
                if (Zv.isInValid()) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/BaseTimeLine$CommentClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(97822);
                } else if (!m.w(Zv)) {
                    com.tencent.mm.plugin.sns.lucky.ui.a.f(this.Eon.EWX.getContext(), this.Eon.EWX.ZD(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/BaseTimeLine$CommentClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(97822);
                } else {
                    com.tencent.mm.modelsns.k tO = com.tencent.mm.modelsns.k.tO(742);
                    SnsObject C = an.C(Zv);
                    tO.PH(r.v(Zv)).tR(Zv.field_type).fL(Zv.isAd()).PH(Zv.getUxinfo()).PH(this.DIu.MYT == 0 ? new StringBuilder().append(this.DIu.MYV).toString() : new StringBuilder().append(this.DIu.MYT).toString()).PH(this.DIu.Username).tR(C == null ? 0 : C.LikeCount).tR(C == null ? 0 : C.CommentCount);
                    tO.bfK();
                    i iVar = i.this;
                    BaseTimeLineItem.BaseViewHolder baseViewHolder = this.Eon;
                    String str = i.this.context.getString(R.string.h9y) + this.gCv;
                    dzo dzo = this.DIu;
                    String str2 = baseViewHolder.dRS + str;
                    iVar.EoN = str2;
                    Log.i("MicroMsg.BaseTimeLine", "[performCommentClick] onCommentClick:  commentkey " + iVar.EoN + " " + baseViewHolder.dRS + " position:" + baseViewHolder.position);
                    iVar.EoJ.setTag(Zv);
                    iVar.cqk();
                    iVar.EoJ.setVisibility(0);
                    iVar.EoJ.ECO = i.fJ(str2, 0);
                    iVar.EoJ.setCommentHint(str + iVar.context.getString(R.string.h4y));
                    if (!(Zv == null || !Zv.isAd() || dzo == null || dzo.Username == null || !dzo.Username.equals(Zv.getUserName()))) {
                        iVar.EoJ.ECO = i.fJ(str2, 1);
                    }
                    iVar.T(Zv);
                    iVar.EoJ.setCommentInfo(dzo);
                    iVar.EoJ.o(i.EoP, str2);
                    iVar.EoJ.post(new Runnable() {
                        /* class com.tencent.mm.plugin.sns.ui.i.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(97810);
                            i.this.EoJ.setToSendTextColor(true);
                            AppMethodBeat.o(97810);
                        }
                    });
                    iVar.EoJ.oY(false);
                    iVar.h(baseViewHolder);
                    if (iVar.EoJ.ECT) {
                        h.INSTANCE.dN(150, 80);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/BaseTimeLine$CommentClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(97822);
                }
            } else {
                if (i.this.EoK.ERJ) {
                    i.this.ffp();
                    i.this.EoK.ERJ = false;
                }
                com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(i.this.context);
                AnonymousClass1 r2 = new View.OnCreateContextMenuListener() {
                    /* class com.tencent.mm.plugin.sns.ui.i.a.AnonymousClass1 */

                    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                        AppMethodBeat.i(97819);
                        if (a.this.DIu != null && !com.tencent.mm.plugin.sns.ui.widget.e.iY(a.this.DIu.MYX, 16)) {
                            contextMenu.add(0, 0, 0, i.this.context.getString(R.string.t_));
                        }
                        contextMenu.add(1, 1, 0, i.this.context.getString(R.string.tf));
                        AppMethodBeat.o(97819);
                    }
                };
                AnonymousClass2 r3 = new o.g() {
                    /* class com.tencent.mm.plugin.sns.ui.i.a.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        int i3 = 4;
                        int i4 = 0;
                        AppMethodBeat.i(97821);
                        switch (menuItem.getItemId()) {
                            case 0:
                                if (ClipboardHelper.setTextSwallowException(a.this.Epf)) {
                                    com.tencent.mm.ui.base.h.cD(i.this.context, i.this.context.getString(R.string.ta));
                                    if (a.this.DIu != null) {
                                        String unsignedLongString = Util.getUnsignedLongString(y.aOa(a.this.Eon.dRS));
                                        com.tencent.mm.plugin.secinforeport.a.a aVar = com.tencent.mm.plugin.secinforeport.a.a.INSTANCE;
                                        com.tencent.mm.plugin.secinforeport.a.a.q(4, unsignedLongString + ":" + a.this.DIu.MYT, Util.getUTF8ByteLength(a.this.Epf.toString()));
                                        AppMethodBeat.o(97821);
                                        return;
                                    }
                                } else {
                                    com.tencent.mm.ui.base.h.cD(i.this.context, i.this.context.getString(R.string.j80));
                                    AppMethodBeat.o(97821);
                                    return;
                                }
                                break;
                            case 1:
                                Log.e("MicroMsg.BaseTimeLine", "del snsId:" + a.this.Eon.dRS + " commentId:" + a.this.DIu);
                                long aOa = y.aOa(a.this.Eon.dRS);
                                if (y.aQH(a.this.Eon.dRS)) {
                                    i3 = 6;
                                }
                                final s sVar = new s(aOa, i3, a.this.DIu);
                                g.aAi();
                                g.aAg().hqi.a(sVar, 0);
                                i iVar = i.this;
                                Context context = i.this.context;
                                i.this.context.getString(R.string.zb);
                                iVar.EoW = com.tencent.mm.ui.base.h.a(context, i.this.context.getString(R.string.h5m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.sns.ui.i.a.AnonymousClass2.AnonymousClass1 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(97820);
                                        g.aAi();
                                        g.aAg().hqi.a(sVar);
                                        AppMethodBeat.o(97820);
                                    }
                                });
                                String str = "";
                                if (a.this.DIu != null) {
                                    i4 = a.this.DIu.MYT;
                                    str = a.this.DIu.Username;
                                }
                                com.tencent.mm.plugin.sns.k.e eVar = com.tencent.mm.plugin.sns.k.e.DUQ;
                                com.tencent.mm.plugin.sns.k.e.a(a.this.Eon.snsobj, i4, str);
                                break;
                        }
                        AppMethodBeat.o(97821);
                    }
                };
                int[] iArr = new int[2];
                if (view.getTag(R.id.iu_) instanceof int[]) {
                    iArr = (int[]) view.getTag(R.id.iu_);
                }
                aVar.a(view, r2, r3, iArr[0], iArr[1]);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/BaseTimeLine$CommentClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(97822);
            }
        }
    }

    public final void ffv() {
        AppMethodBeat.i(179145);
        if (this.EoI != null) {
            this.EoI.ffv();
        }
        AppMethodBeat.o(179145);
    }

    public final void clean() {
        AppMethodBeat.i(203232);
        this.EoV.removeListener();
        if (this.EoJ != null) {
            this.EoJ.fib();
        }
        EventCenter.instance.removeListener(this.EoX);
        EventCenter.instance.removeListener(this.EoY);
        AppMethodBeat.o(203232);
    }

    static int fJ(String str, int i2) {
        AppMethodBeat.i(97827);
        Iterator<k> it = EoP.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            k next = it.next();
            if (Util.isEqual(next.key, str)) {
                i2 = next.cSx;
                break;
            }
        }
        AppMethodBeat.o(97827);
        return i2;
    }
}
