package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.wo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.secinforeport.a.a;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.g.o;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.FlipView;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsPermissionUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.SnsUploadUI;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.bb;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.bg;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.m;
import com.tencent.mm.plugin.sns.ui.widget.SnsPostDescPreloadTextView;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.ana;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anq;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.protocal.protobuf.eyd;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.s;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public final class b implements i, o.g {
    protected k EBv;
    q EoW;
    private ai Epj;
    View Fai;
    private String Faj;
    private TimeLineObject Fak;
    Activity activity;
    private int source;

    public final void ebz() {
        AppMethodBeat.i(100190);
        g.aAi();
        g.aAg().hqi.a(218, this);
        AppMethodBeat.o(100190);
    }

    public final void removeListener() {
        AppMethodBeat.i(100191);
        g.aAi();
        g.aAg().hqi.b(218, this);
        AppMethodBeat.o(100191);
    }

    public b(Activity activity2, int i2, ai aiVar) {
        AppMethodBeat.i(100192);
        this.activity = activity2;
        this.source = i2;
        this.Epj = aiVar;
        AppMethodBeat.o(100192);
    }

    public final void c(k kVar) {
        this.EBv = kVar;
    }

    public final void a(View view, String str, TimeLineObject timeLineObject) {
        this.Fai = view;
        this.Faj = str;
        this.Fak = timeLineObject;
    }

    private String fkt() {
        au.b aPp;
        AppMethodBeat.i(100193);
        if (this.Fai != null && (this.Fai instanceof SnsPostDescPreloadTextView)) {
            AppMethodBeat.o(100193);
            return null;
        } else if (this.Fai == null || !(this.Fai.getTag() instanceof bg) || !((bg) this.Fai.getTag()).fiA() || (aPp = au.aPp(aj.faO().aQm(this.Faj).getSnsId())) == null) {
            AppMethodBeat.o(100193);
            return null;
        } else {
            String str = aPp.result;
            AppMethodBeat.o(100193);
            return str;
        }
    }

    private ADInfo g(SnsInfo snsInfo) {
        AppMethodBeat.i(100194);
        if (snsInfo == null) {
            AppMethodBeat.o(100194);
            return null;
        } else if (this.source == 2) {
            ADInfo atAdInfo = snsInfo.getAtAdInfo();
            AppMethodBeat.o(100194);
            return atAdInfo;
        } else {
            ADInfo adInfo = snsInfo.getAdInfo();
            AppMethodBeat.o(100194);
            return adInfo;
        }
    }

    @Override // com.tencent.mm.ui.base.o.g
    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
        String str;
        int i3;
        com.tencent.mm.modelsns.k tP;
        com.tencent.mm.modelsns.k tP2;
        AppMethodBeat.i(100195);
        if (this.Fai == null) {
            AppMethodBeat.o(100195);
            return;
        }
        switch (menuItem.getItemId()) {
            case 0:
                String fkt = fkt();
                if (Util.isNullOrNil(fkt)) {
                    fkt = this.Fak.ContentDesc;
                }
                if (ClipboardHelper.setTextSwallowException(fkt)) {
                    h.cD(this.activity, this.activity.getString(R.string.ta));
                    a aVar = a.INSTANCE;
                    a.q(2, this.Fak.Id, Util.getUTF8ByteLength(fkt));
                    AppMethodBeat.o(100195);
                    return;
                }
                h.cD(this.activity, this.activity.getString(R.string.j80));
                AppMethodBeat.o(100195);
                return;
            case 1:
                String fkt2 = fkt();
                if (Util.isNullOrNil(fkt2)) {
                    fkt2 = this.Fak.ContentDesc;
                }
                this.Epj.fat().kp(this.Faj, this.Fak.Id);
                cz czVar = new cz();
                com.tencent.mm.plugin.sns.l.a.a(czVar, this.Faj, (CharSequence) fkt2);
                czVar.dFZ.activity = this.activity;
                czVar.dFZ.dGf = 30;
                EventCenter.instance.publish(czVar);
                AppMethodBeat.o(100195);
                return;
            case 2:
                this.Epj.fat().kp(this.Faj, this.Fak.Id);
                cz czVar2 = new cz();
                SnsInfo aQm = f.aQm(this.Faj);
                if (aQm.isAd() && aQm.getAdXml().isLandingPagesAd()) {
                    aRr(this.Faj);
                } else if (this.Fak.showFlag == 1) {
                    com.tencent.mm.plugin.sns.l.a.a(czVar2, this.Faj, 0);
                    czVar2.dFZ.activity = this.activity;
                    czVar2.dFZ.dGf = 31;
                    EventCenter.instance.publish(czVar2);
                } else if (this.Fai.getTag() instanceof bc) {
                    com.tencent.mm.plugin.sns.l.a.a(czVar2, this.Faj, ((bc) this.Fai.getTag()).index);
                    czVar2.dFZ.activity = this.activity;
                    czVar2.dFZ.dGf = 31;
                    EventCenter.instance.publish(czVar2);
                }
                if (aQm.isAd()) {
                    SnsAdClick snsAdClick = new SnsAdClick(this.source, this.source == 0 ? 1 : 2, aQm.field_snsId, 11, 0);
                    com.tencent.mm.plugin.sns.data.k.a(snsAdClick, this.EBv, aQm, 11);
                    r.a(snsAdClick);
                }
                AppMethodBeat.o(100195);
                return;
            case 3:
                this.Epj.fat().kp(this.Faj, this.Fak.Id);
                String aRg = bk.aRg(this.Fak.ContentObj.Url);
                if (Util.isNullOrNil(aRg)) {
                    Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
                    AppMethodBeat.o(100195);
                    return;
                }
                cz czVar3 = new cz();
                SnsInfo aQm2 = f.aQm(this.Faj);
                if (aQm2 != null) {
                    String JX = ad.JX(new StringBuilder().append(aQm2.field_snsId).toString());
                    ad.b G = ad.aVe().G(JX, true);
                    G.l("prePublishId", "sns_" + r.Jb(aQm2.field_snsId));
                    G.l("preUsername", aQm2.field_userName);
                    G.l("preChatName", "");
                    G.l("url", aRg);
                    G.l("preMsgIndex", 0);
                    G.l("sendAppMsgScene", 1);
                    G.l("adExtStr", aQm2.getTimeLine().statExtStr);
                    czVar3.dFZ.sessionId = JX;
                }
                SnsInfo aQm3 = aj.faO().aQm(this.Faj);
                if (aQm3 != null && this.Fak.ContentObj.LoU == 18) {
                    com.tencent.mm.plugin.sns.ad.g.o.a(o.d.AdUrl, o.c.Fav, o.e.Samll, 0, aQm3, this.source);
                }
                if (!Util.isNullOrNil(this.Fak.canvasInfo)) {
                    aRr(aQm3.getLocalid());
                    AppMethodBeat.o(100195);
                    return;
                }
                if (aQm3.isAd()) {
                    SnsAdClick snsAdClick2 = new SnsAdClick(this.source, this.source == 0 ? 1 : 2, aQm2.field_snsId, 11, 0);
                    com.tencent.mm.plugin.sns.data.k.a(snsAdClick2, this.EBv, aQm3, 11);
                    r.a(snsAdClick2);
                }
                com.tencent.mm.plugin.sns.l.a.a(czVar3, aRg, this.Faj);
                czVar3.dFZ.activity = this.activity;
                czVar3.dFZ.dGf = 28;
                EventCenter.instance.publish(czVar3);
                if (czVar3.dGa.ret == 0) {
                    long nowSecond = Util.nowSecond();
                    if (!Util.isNullOrNil(aRg)) {
                        Log.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", 13378, aRg, Long.valueOf(nowSecond), 3, 2, 1);
                        String str2 = "";
                        try {
                            str2 = URLEncoder.encode(aRg, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                        } catch (UnsupportedEncodingException e2) {
                            Log.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", e2, "", new Object[0]);
                        }
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(13378, str2, Long.valueOf(nowSecond), 3, 2, 1);
                    }
                }
                AppMethodBeat.o(100195);
                return;
            case 4:
                this.Epj.fat().kp(this.Faj, this.Fak.Id);
                SnsInfo aQm4 = aj.faO().aQm(this.Faj);
                if (this.Fak.ContentObj.LoV.size() != 0) {
                    cnb cnb = this.Fak.ContentObj.LoV.get(0);
                    if (aQm4 == null || cnb == null) {
                        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                        AppMethodBeat.o(100195);
                        return;
                    }
                    cz czVar4 = new cz();
                    TimeLineObject timeLineObject = this.Fak;
                    if (cnb == null || aQm4 == null || aQm4.localid == 0) {
                        Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                        czVar4.dFZ.dGe = R.string.c_2;
                    } else if (aj.isInValid()) {
                        Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                        czVar4.dFZ.dGe = R.string.c_j;
                    } else {
                        String format = String.format("%s#%s", r.Jb(aQm4.field_snsId), cnb.Id);
                        anb anb = new anb();
                        anh anh = new anh();
                        Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", aQm4.getUserName());
                        anh.bhf(aQm4.getUserName());
                        anh.bhg(z.aTY());
                        anh.ajm(2);
                        anh.MA(((long) aQm4.getCreateTime()) * 1000);
                        anh.bhk(aQm4.getSnsId());
                        anh.bhh(format);
                        if (!(timeLineObject == null || timeLineObject.AppInfo == null)) {
                            anh.bhl(timeLineObject.AppInfo.Id);
                        }
                        aml aml = new aml();
                        aml.bgx(format);
                        aml.bgm(cnb.Url);
                        aml.bgn(cnb.MsC);
                        aml.bgl(aQm4.getTimeLine().ContentObj.Url);
                        boolean z = false;
                        if (!(timeLineObject == null || timeLineObject.ContentObj.jfy == null || !s.YS(timeLineObject.ContentObj.jfy.jfz))) {
                            z = true;
                            aml.bgu(timeLineObject.ContentObj.jfy.jfz);
                        }
                        String str3 = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.e(cnb);
                        if (s.YS(str3)) {
                            z = true;
                            aml.bgu(str3);
                        }
                        if (!z) {
                            aml.At(true);
                            aml.bgo(cnb.Msz);
                            anq anq = new anq();
                            anq.bhv(cnb.Msz);
                            anb.b(anq);
                        }
                        aml.bgL(cnb.songAlbumUrl);
                        aml.bgM(cnb.songLyric);
                        aml.ajd(7);
                        aml.bgf(cnb.Title);
                        aml.bgg(cnb.Desc);
                        aml.As(true);
                        anb.ppH.add(aml);
                        anb.a(anh);
                        czVar4.dFZ.dGb = anb;
                        czVar4.dFZ.type = 7;
                        com.tencent.mm.plugin.sns.l.a.a(aml, aQm4);
                    }
                    czVar4.dFZ.activity = this.activity;
                    czVar4.dFZ.dGf = 25;
                    EventCenter.instance.publish(czVar4);
                }
                AppMethodBeat.o(100195);
                return;
            case 5:
                this.Epj.fat().kp(this.Faj, this.Fak.Id);
                if (this.Fak != null) {
                    cz czVar5 = new cz();
                    TimeLineObject timeLineObject2 = this.Fak;
                    if (timeLineObject2 == null) {
                        Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                        czVar5.dFZ.dGe = R.string.c_2;
                    } else {
                        anb anb2 = new anb();
                        anh anh2 = new anh();
                        ana ana = new ana();
                        anh2.bhf(timeLineObject2.UserName);
                        anh2.bhg(z.aTY());
                        anh2.ajm(2);
                        anh2.MA(Util.nowMilliSecond());
                        if (timeLineObject2.AppInfo != null) {
                            anh2.bhl(timeLineObject2.AppInfo.Id);
                        }
                        if (timeLineObject2.ContentObj != null) {
                            ana.bgY(timeLineObject2.ContentObj.Title);
                            ana.bgZ(timeLineObject2.ContentObj.Desc);
                            if (timeLineObject2.ContentObj.LoV != null && !timeLineObject2.ContentObj.LoV.isEmpty()) {
                                cnb cnb2 = timeLineObject2.ContentObj.LoV.get(0);
                                ana.ajj(cnb2.subType);
                                ana.bhb(cnb2.EpK);
                                ana.bha(cnb2.Msz);
                            }
                        }
                        czVar5.dFZ.title = ana.title;
                        czVar5.dFZ.desc = ana.desc;
                        czVar5.dFZ.dGb = anb2;
                        czVar5.dFZ.type = 10;
                        anb2.a(anh2);
                        anb2.b(ana);
                    }
                    czVar5.dFZ.activity = this.activity;
                    czVar5.dFZ.dGf = 26;
                    EventCenter.instance.publish(czVar5);
                    AppMethodBeat.o(100195);
                    return;
                }
                break;
            case 7:
                final SnsInfo aQm5 = aj.faO().aQm(this.Faj);
                if (aQm5 == null) {
                    Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "delete comment fail!!! snsInfo is null");
                    AppMethodBeat.o(100195);
                    return;
                }
                new f.a(this.activity).bow(this.activity.getResources().getString(R.string.h5g)).boA(this.activity.getResources().getString(R.string.tf)).apb(this.activity.getResources().getColor(R.color.a5e)).b(new f.c() {
                    /* class com.tencent.mm.plugin.sns.ui.d.b.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        final com.tencent.mm.plugin.sns.model.s sVar;
                        String str2;
                        int i2 = 0;
                        AppMethodBeat.i(203952);
                        String snsId = aQm5.getSnsId();
                        m mVar = (m) b.this.Fai.getTag();
                        if (mVar != null) {
                            if (y.aQH(snsId)) {
                                sVar = new com.tencent.mm.plugin.sns.model.s(y.aOa(snsId), 6, mVar.DIu);
                                g.aAi();
                                g.aAg().hqi.a(sVar, 0);
                            } else {
                                sVar = new com.tencent.mm.plugin.sns.model.s(y.aOa(snsId), 4, mVar.DIu);
                                g.aAi();
                                g.aAg().hqi.a(sVar, 0);
                            }
                            b bVar = b.this;
                            Activity activity = b.this.activity;
                            b.this.activity.getString(R.string.zb);
                            bVar.EoW = h.a((Context) activity, b.this.activity.getString(R.string.h5m), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.plugin.sns.ui.d.b.AnonymousClass2.AnonymousClass1 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(203951);
                                    g.aAi();
                                    g.aAg().hqi.a(sVar);
                                    AppMethodBeat.o(203951);
                                }
                            });
                            if (mVar.DIu != null) {
                                int i3 = mVar.DIu.MYT;
                                str2 = mVar.DIu.Username;
                                i2 = i3;
                            } else {
                                str2 = "";
                            }
                            e eVar = e.DUQ;
                            e.b(aQm5, i2, str2, 1);
                        }
                        AppMethodBeat.o(203952);
                    }
                }).boB(this.activity.getResources().getString(R.string.sz)).a(new f.c() {
                    /* class com.tencent.mm.plugin.sns.ui.d.b.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        String str2;
                        AppMethodBeat.i(203950);
                        m mVar = (m) b.this.Fai.getTag();
                        int i2 = 0;
                        if (mVar == null || mVar.DIu == null) {
                            str2 = "";
                        } else {
                            int i3 = mVar.DIu.MYT;
                            str2 = mVar.DIu.Username;
                            i2 = i3;
                        }
                        e eVar = e.DUQ;
                        e.b(aQm5, i2, str2, 2);
                        AppMethodBeat.o(203950);
                    }
                }).show();
                AppMethodBeat.o(100195);
                return;
            case 8:
                SnsInfo aQm6 = aj.faO().aQm(this.Faj);
                if (aQm6 != null) {
                    com.tencent.mm.plugin.sns.abtest.a.b(aQm6);
                    Intent intent = new Intent();
                    intent.putExtra("sns_permission_snsinfo_svr_id", aQm6.field_snsId);
                    intent.putExtra("sns_permission_userName", aQm6.getUserName());
                    intent.putExtra("sns_permission_anim", true);
                    intent.setClass(this.activity, SnsPermissionUI.class);
                    this.activity.startActivityForResult(intent, 11);
                    AppMethodBeat.o(100195);
                    return;
                }
                break;
            case 9:
                this.Epj.fat().kp(this.Faj, this.Fak.Id);
                if (this.Fak != null) {
                    cz czVar6 = new cz();
                    TimeLineObject timeLineObject3 = this.Fak;
                    if (timeLineObject3 == null) {
                        Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or tlObj is null");
                        czVar6.dFZ.dGe = R.string.c_2;
                    } else {
                        anb anb3 = new anb();
                        anh anh3 = new anh();
                        ank ank = new ank();
                        anh3.bhf(timeLineObject3.UserName);
                        anh3.bhg(z.aTY());
                        anh3.ajm(8);
                        anh3.MA(Util.nowMilliSecond());
                        if (timeLineObject3.AppInfo != null) {
                            anh3.bhl(timeLineObject3.AppInfo.Id);
                        }
                        if (timeLineObject3.ContentObj != null) {
                            ank.bho(timeLineObject3.ContentObj.Title);
                            ank.bhp(timeLineObject3.ContentObj.Desc);
                            if (timeLineObject3.ContentObj.LoV != null && !timeLineObject3.ContentObj.LoV.isEmpty()) {
                                cnb cnb3 = timeLineObject3.ContentObj.LoV.get(0);
                                ank.bhr(cnb3.EpK);
                                ank.bhq(cnb3.Msz);
                            }
                        }
                        czVar6.dFZ.title = ank.title;
                        czVar6.dFZ.desc = ank.desc;
                        czVar6.dFZ.dGb = anb3;
                        czVar6.dFZ.type = 15;
                        anb3.a(anh3);
                        anb3.b(ank);
                    }
                    czVar6.dFZ.activity = this.activity;
                    czVar6.dFZ.dGf = 27;
                    EventCenter.instance.publish(czVar6);
                    AppMethodBeat.o(100195);
                    return;
                }
                break;
            case 10:
                this.Epj.fat().kp(this.Faj, this.Fak.Id);
                SnsInfo aQm7 = com.tencent.mm.plugin.sns.storage.f.aQm(this.Faj);
                if (aQm7 == null || !aQm7.isAd() || !aQm7.getAdXml().isLandingPagesAd()) {
                    SnsInfo aQm8 = aj.faO().aQm(this.Faj);
                    if (aQm8 != null) {
                        if (aQm8.isAd()) {
                            com.tencent.mm.plugin.sns.ad.g.o.a(o.d.Sight, o.c.Fav, o.e.Samll, 0, aQm8, this.source);
                            SnsAdClick snsAdClick3 = new SnsAdClick(this.source, this.source == 0 ? 1 : 2, aQm8.field_snsId, 11, 0);
                            com.tencent.mm.plugin.sns.data.k.a(snsAdClick3, this.EBv, aQm8, 11);
                            r.a(snsAdClick3);
                        }
                        cz czVar7 = new cz();
                        com.tencent.mm.plugin.sns.l.a.a(czVar7, aQm8);
                        czVar7.dFZ.activity = this.activity;
                        czVar7.dFZ.dGf = 29;
                        EventCenter.instance.publish(czVar7);
                    }
                    AppMethodBeat.o(100195);
                    return;
                }
                SnsInfo aQm9 = aj.faO().aQm(this.Faj);
                if (aQm9 != null && aQm9.isAd()) {
                    SnsAdClick snsAdClick4 = new SnsAdClick(this.source, this.source == 0 ? 1 : 2, aQm7.field_snsId, 11, 0);
                    com.tencent.mm.plugin.sns.data.k.a(snsAdClick4, this.EBv, aQm7, 11);
                    r.a(snsAdClick4);
                }
                aRr(this.Faj);
                AppMethodBeat.o(100195);
                return;
            case 11:
                if (this.Fai.getTag() instanceof m) {
                    m mVar = (m) this.Fai.getTag();
                    if (ClipboardHelper.setTextSwallowException(mVar.iAc)) {
                        h.cD(this.activity, this.activity.getString(R.string.ta));
                        if (mVar.DIu != null) {
                            a aVar2 = a.INSTANCE;
                            a.q(4, this.Fak.Id + ":" + mVar.DIu.MYT, Util.getUTF8ByteLength(mVar.iAc));
                            AppMethodBeat.o(100195);
                            return;
                        }
                    } else {
                        h.cD(this.activity, this.activity.getString(R.string.j80));
                    }
                    AppMethodBeat.o(100195);
                    return;
                }
                break;
            case 12:
                cnb cnb4 = this.Fak.ContentObj.LoV.get(0);
                Intent intent2 = new Intent();
                intent2.putExtra("Select_Conv_Type", 3);
                intent2.putExtra("select_is_ret", true);
                intent2.putExtra("mutil_select_is_ret", true);
                intent2.putExtra("image_path", ar.ki(aj.getAccSnsPath(), cnb4.Id) + r.e(cnb4));
                intent2.putExtra("Retr_Msg_Type", 11);
                c.c(this.activity, ".ui.transmit.SelectConversationUI", intent2, 15);
                AppMethodBeat.o(100195);
                return;
            case 13:
                com.tencent.mm.plugin.sns.abtest.a.a(this.activity, aj.faO().aQm(this.Faj));
                AppMethodBeat.o(100195);
                return;
            case 14:
                if (WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.Fai.getContext())) {
                    SnsInfo aQm10 = aj.faO().aQm(this.Faj);
                    if (aQm10 != null) {
                        if (this.source == 0) {
                            tP2 = com.tencent.mm.modelsns.k.tO(com.tencent.mm.plugin.appbrand.jsapi.pay.g.CTRL_INDEX);
                        } else {
                            tP2 = com.tencent.mm.modelsns.k.tP(com.tencent.mm.plugin.appbrand.jsapi.pay.g.CTRL_INDEX);
                        }
                        tP2.PH(r.v(aQm10)).tR(aQm10.field_type).fL(aQm10.isAd()).PH(aQm10.getUxinfo());
                        tP2.bfK();
                    }
                    au.E(aQm10);
                    AppMethodBeat.o(100195);
                    return;
                }
                break;
            case 15:
                if ((this.Fai.getTag() instanceof m) && WeChatBrands.Business.Entries.ContextTranslate.checkAvailable(this.Fai.getContext())) {
                    m mVar2 = (m) this.Fai.getTag();
                    SnsInfo aQl = aj.faO().aQl(mVar2.Epv);
                    if (aQl != null) {
                        if (this.source == 0) {
                            tP = com.tencent.mm.modelsns.k.tO(715);
                        } else {
                            tP = com.tencent.mm.modelsns.k.tP(715);
                        }
                        tP.PH(r.v(aQl)).tR(aQl.field_type).fL(aQl.isAd()).PH(aQl.getUxinfo());
                        if (mVar2.DIu != null) {
                            tP.PH(mVar2.DIu.MYT == 0 ? new StringBuilder().append(mVar2.DIu.MYV).toString() : new StringBuilder().append(mVar2.DIu.MYT).toString());
                        } else {
                            tP.PH("");
                        }
                        tP.bfK();
                    }
                    au.a((m) this.Fai.getTag());
                    AppMethodBeat.o(100195);
                    return;
                }
            case 16:
                au.F(aj.faO().aQm(this.Faj));
                AppMethodBeat.o(100195);
                return;
            case 17:
                if (this.Fai.getTag() instanceof m) {
                    au.b((m) this.Fai.getTag());
                    AppMethodBeat.o(100195);
                    return;
                }
                break;
            case 18:
                Activity activity2 = this.activity;
                SnsInfo aQm11 = aj.faO().aQm(this.Faj);
                if (aQm11 != null) {
                    Intent intent3 = new Intent();
                    if (aQm11.getTimeLine().ContentObj.LoU == 1) {
                        int i4 = 0;
                        if (this.Fai.getTag() instanceof at) {
                            i4 = ((bc) this.Fai.getTag()).index;
                        }
                        cnb b2 = an.b(aQm11, i4);
                        if (b2 == null) {
                            Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "send photo fail, mediaObj is null");
                            AppMethodBeat.o(100195);
                            return;
                        }
                        String str4 = b2.Id;
                        intent3.putExtra("sns_send_data_ui_image_path", FlipView.i(ar.ki(aj.getAccSnsPath(), str4) + r.l(b2), activity2));
                        intent3.putExtra("sns_send_data_ui_image_media_id", str4);
                    } else if ((aQm11.getTimeLine().ContentObj.LoU == 4 || aQm11.getTimeLine().ContentObj.LoU == 42 || aQm11.getTimeLine().ContentObj.LoU == 15 || aQm11.getTimeLine().ContentObj.LoU == 3) && (aQm11.getTimeLine().ContentObj.LoV.isEmpty() || aQm11.getTimeLine().ContentObj.LoV.get(0) == null)) {
                        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mediaObj is null, send failed!");
                        AppMethodBeat.o(100195);
                        return;
                    }
                    intent3.putExtra("exdevice_open_scene_type", 1);
                    intent3.putExtra("sns_local_id", this.Faj);
                    intent3.putExtra("sns_send_data_ui_activity", true);
                    c.f(this.activity, ".ui.chatting.ChattingSendDataToDeviceUI", intent3);
                }
                AppMethodBeat.o(100195);
                return;
            case 19:
                Activity activity3 = this.activity;
                SnsInfo aQm12 = aj.faO().aQm(this.Faj);
                if (aQm12 == null) {
                    Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but sns info is null.");
                    AppMethodBeat.o(100195);
                    return;
                } else if (aQm12.isAd()) {
                    Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but it is ad");
                    AppMethodBeat.o(100195);
                    return;
                } else if (aQm12.getTimeLine() == null || aQm12.getTimeLine().ContentObj == null || Util.isNullOrNil(aQm12.getTimeLine().ContentObj.LoV)) {
                    Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute play video but media is null");
                    AppMethodBeat.o(100195);
                    return;
                } else {
                    cnb cnb5 = aQm12.getTimeLine().ContentObj.LoV.get(0);
                    if (cnb5 == null) {
                        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "mute paly video but media is null");
                        AppMethodBeat.o(100195);
                        return;
                    }
                    String ki = ar.ki(aj.getAccSnsPath(), cnb5.Id);
                    String str5 = "";
                    if (s.YS(ki + r.j(cnb5))) {
                        str5 = ki + r.e(cnb5);
                    }
                    if (s.YS(ki + r.p(cnb5))) {
                        str5 = ki + r.n(cnb5);
                    }
                    Intent intent4 = new Intent();
                    intent4.setClass(this.activity, SnsOnlineVideoActivity.class);
                    intent4.putExtra("intent_thumbpath", str5);
                    intent4.putExtra("intent_localid", this.Faj);
                    intent4.putExtra("intent_from_scene", this.source);
                    intent4.putExtra("intent_ismute", true);
                    if (activity3 instanceof SnsTimeLineUI) {
                        intent4.putExtra("sns_video_scene", 1);
                    } else if (activity3 instanceof SnsCommentDetailUI) {
                        intent4.putExtra("sns_video_scene", 5);
                    } else if (activity3 instanceof SnsUploadUI) {
                        intent4.putExtra("sns_video_scene", 6);
                    }
                    if (this.Fai != null) {
                        int[] iArr = new int[2];
                        this.Fai.getLocationInWindow(iArr);
                        int width = this.Fai.getWidth();
                        int height = this.Fai.getHeight();
                        intent4.putExtra("img_gallery_left", iArr[0]);
                        intent4.putExtra("img_gallery_top", iArr[1]);
                        intent4.putExtra("img_gallery_width", width);
                        intent4.putExtra("img_gallery_height", height);
                    }
                    Activity activity4 = this.activity;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent4);
                    com.tencent.mm.hellhoundlib.a.a.a(activity4, bl.axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimeLineMMMenuItemSelectedListener", "mutePlayVideo", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity4.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity4, "com/tencent/mm/plugin/sns/ui/listener/TimeLineMMMenuItemSelectedListener", "mutePlayVideo", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    this.activity.overridePendingTransition(0, 0);
                    AppMethodBeat.o(100195);
                    return;
                }
            case 20:
                this.Epj.fat().kp(this.Faj, this.Fak.Id);
                SnsInfo aQm13 = com.tencent.mm.plugin.sns.storage.f.aQm(this.Faj);
                if (aQm13 == null || !aQm13.isAd() || !aQm13.getAdXml().isLandingPagesAd()) {
                    byl(this.Faj);
                    AppMethodBeat.o(100195);
                    return;
                }
                SnsInfo aQm14 = aj.faO().aQm(this.Faj);
                if (!(aQm14 == null || !aQm14.isAd() || this.Fak == null)) {
                    SnsAdClick snsAdClick5 = new SnsAdClick(this.source, this.source == 0 ? 1 : 2, aQm13.field_snsId, 11, 0);
                    com.tencent.mm.plugin.sns.data.k.a(snsAdClick5, this.EBv, aQm13, 11);
                    r.a(snsAdClick5);
                }
                aRr(this.Faj);
                AppMethodBeat.o(100195);
                return;
            case 21:
                SnsInfo aQm15 = com.tencent.mm.plugin.sns.storage.f.aQm(this.Faj);
                if (aQm15 == null) {
                    Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, info is null");
                    AppMethodBeat.o(100195);
                    return;
                } else if (this.Fai.getTag() == null || !(this.Fai.getTag() instanceof bc)) {
                    Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "edit photo fail, tag is null or tag is not SnsImageViewTag");
                    AppMethodBeat.o(100195);
                    return;
                } else {
                    bb.a(this.activity, menuItem.getIntent(), aQm15, (bc) this.Fai.getTag(), this.source == 0 ? 1 : 2, this.source, this.Epj);
                    AppMethodBeat.o(100195);
                    return;
                }
            case 22:
                if (this.Fak == null) {
                    Log.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favNotelink,tlobj is null, return");
                    AppMethodBeat.o(100195);
                    return;
                }
                cz czVar8 = new cz();
                com.tencent.mm.plugin.sns.l.a.a(czVar8, this.Faj);
                czVar8.dFZ.activity = this.activity;
                czVar8.dFZ.dGf = 28;
                EventCenter.instance.publish(czVar8);
                AppMethodBeat.o(100195);
                return;
            case 23:
                eyd eyd = this.Fak.weappInfo;
                if (this.Fak == null || eyd == null) {
                    Log.e("MicroMsg.TimeLineMMMenuItemSelectedListener", "favoriteAppBrand weappInfo null");
                    AppMethodBeat.o(100195);
                    return;
                }
                WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(eyd.username);
                amj amj = new amj();
                amj.username = eyd.username;
                if (Xk != null) {
                    amj.appId = Xk.field_appId;
                }
                amj.dCx = eyd.path;
                amj.dMe = eyd.nbf;
                amj.version = eyd.version;
                amj.eda = eyd.eda;
                amj.subType = eyd.subType;
                String str6 = null;
                aml aml2 = new aml();
                aml2.ajd(19);
                if (this.Fak.ContentObj != null) {
                    String str7 = this.Fak.ContentObj.Title;
                    if (this.Fak.ContentObj.LoV == null || this.Fak.ContentObj.LoV.isEmpty()) {
                        aml2.At(true);
                        str6 = str7;
                    } else {
                        cnb cnb6 = this.Fak.ContentObj.LoV.get(0);
                        String str8 = ar.ki(aj.getAccSnsPath(), cnb6.Id) + r.e(cnb6);
                        aml2.bgt(str8);
                        aml2.bgu(str8);
                        str6 = str7;
                    }
                } else {
                    aml2.At(true);
                }
                if (Util.isNullOrNil(str6)) {
                    if (Xk == null || Util.isNullOrNil(Xk.field_nickname)) {
                        str6 = this.activity.getString(R.string.a0f);
                    } else {
                        str6 = Xk.field_nickname;
                    }
                }
                aml2.bgf(str6);
                aml2.bgg(str6);
                aml2.bgs(com.tencent.mm.plugin.fav.a.b.ds(aml2.toString(), 19));
                anh anh4 = new anh();
                anh4.bhf(z.aTY());
                anh4.MA(Util.nowMilliSecond());
                anh4.ajm(2);
                anb anb4 = new anb();
                anb4.ppH.add(aml2);
                anb4.c(amj);
                anb4.a(anh4);
                anb4.bhd(str6);
                cz czVar9 = new cz();
                czVar9.dFZ.activity = this.activity;
                czVar9.dFZ.title = str6;
                czVar9.dFZ.desc = str6;
                czVar9.dFZ.dGb = anb4;
                czVar9.dFZ.type = 19;
                EventCenter.instance.publish(czVar9);
                AppMethodBeat.o(100195);
                return;
            case 24:
                if (!(this.Fak == null || this.Fak.ContentObj == null)) {
                    ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).c(this.Fak.ContentObj.Lpa);
                    h.cD(this.activity, this.activity.getString(R.string.caf));
                    AppMethodBeat.o(100195);
                    return;
                }
            case 25:
                if (!(this.Fak == null || this.Fak.ContentObj == null || this.Fak.ContentObj.LoU != 28)) {
                    cz czVar10 = new cz();
                    TimeLineObject timeLineObject4 = this.Fak;
                    if (timeLineObject4 == null) {
                        Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, tlObj is null");
                        czVar10.dFZ.dGe = R.string.c_3;
                    } else {
                        String format2 = String.format("%s", timeLineObject4.Id);
                        anb anb5 = new anb();
                        anh anh5 = new anh();
                        aml aml3 = new aml();
                        anh5.bhf(timeLineObject4.UserName);
                        anh5.bhg(z.aTY());
                        anh5.ajm(2);
                        anh5.MA(((long) timeLineObject4.CreateTime) * 1000);
                        anh5.bhk(timeLineObject4.Id);
                        anh5.bhh(format2);
                        aml3.bgx(format2);
                        com.tencent.mm.plugin.sns.l.a.a(aml3, timeLineObject4);
                        aml3.ajd(20);
                        if (timeLineObject4.ContentObj.jfy != null) {
                            amm amm = new amm();
                            amm.e(timeLineObject4.ContentObj.jfy);
                            aml3.a(amm);
                        }
                        anb5.ppH.add(aml3);
                        anb5.a(anh5);
                        anb5.d(timeLineObject4.ContentObj.dME);
                        czVar10.dFZ.dGb = anb5;
                        czVar10.dFZ.type = 20;
                    }
                    czVar10.dFZ.activity = this.activity;
                    EventCenter.instance.publish(czVar10);
                }
                AppMethodBeat.o(100195);
                return;
            case 26:
                SnsInfo aQm16 = com.tencent.mm.plugin.sns.storage.f.aQm(this.Faj);
                bc bcVar = (bc) this.Fai.getTag();
                TimeLineObject timeLine = aQm16.getTimeLine();
                cnb cnb7 = bcVar.index < timeLine.ContentObj.LoV.size() ? timeLine.ContentObj.LoV.get(bcVar.index) : new cnb();
                com.tencent.mm.plugin.websearch.api.o oVar = new com.tencent.mm.plugin.websearch.api.o();
                oVar.context = this.activity;
                oVar.dHq = ar.ki(aj.getAccSnsPath(), cnb7.Id) + r.l(cnb7);
                oVar.IDs = aQm16.field_userName;
                if (this.activity instanceof SnsTimeLineUI) {
                    oVar.dGf = 10;
                } else if (this.activity instanceof SnsCommentDetailUI) {
                    oVar.dGf = 7;
                }
                oVar.DIq = cnb7;
                oVar.dRS = r.Jb(aQm16.field_snsId);
                ((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).startImageSearch(oVar);
                AppMethodBeat.o(100195);
                return;
            case 27:
                String fkt3 = fkt();
                if (Util.isNullOrNil(fkt3)) {
                    str = this.Fak.ContentDesc;
                } else {
                    str = fkt3;
                }
                String Nj = d.Nj(77);
                ag agVar = new ag();
                agVar.sessionId = Nj;
                agVar.context = this.activity;
                agVar.query = str;
                agVar.scene = 77;
                agVar.IEk = true;
                agVar.IEl = true;
                agVar.IEm = true;
                agVar.IEn = 1;
                agVar.statusBarColor = com.tencent.mm.cb.a.n(this.activity, R.color.afz);
                agVar.IEo = true;
                agVar.dVU.put("chatSearch", "1");
                ((com.tencent.mm.plugin.websearch.api.h) g.af(com.tencent.mm.plugin.websearch.api.h.class)).a(agVar);
                if (this.activity instanceof SnsTimeLineUI) {
                    i3 = 3;
                } else {
                    i3 = 5;
                }
                com.tencent.mm.plugin.websearch.api.ar.a(2, Nj, 77, 0, "", "", r.Jb(com.tencent.mm.plugin.sns.storage.f.aQm(this.Faj).field_snsId), i3, "", 0, (long) str.length());
                break;
            case 28:
                this.Epj.fat().kp(this.Faj, this.Fak.Id);
                SnsInfo aQm17 = aj.faO().aQm(this.Faj);
                if (this.Fak.ContentObj.LoV.size() != 0) {
                    cnb cnb8 = this.Fak.ContentObj.LoV.get(0);
                    if (aQm17 == null || cnb8 == null) {
                        Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite music fail, snsinfo or mediaobj is null");
                        AppMethodBeat.o(100195);
                        return;
                    }
                    cz czVar11 = new cz();
                    TimeLineObject timeLineObject5 = this.Fak;
                    css css = this.Fak.ContentObj.jfy;
                    if (cnb8 == null || aQm17 == null || aQm17.localid == 0) {
                        Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, event is null or snsId error or media is null");
                        czVar11.dFZ.dGe = R.string.c_2;
                    } else if (aj.isInValid()) {
                        Log.w("MicroMsg.Sns.GetFavDataSource", "fill favorite event fail, sns core is invalid");
                        czVar11.dFZ.dGe = R.string.c_j;
                    } else {
                        String format3 = String.format("%s#%s", r.Jb(aQm17.field_snsId), cnb8.Id);
                        anb anb6 = new anb();
                        anh anh6 = new anh();
                        Log.i("MicroMsg.Sns.GetFavDataSource", "fav sns music, from %s", aQm17.getUserName());
                        anh6.bhf(aQm17.getUserName());
                        anh6.bhg(z.aTY());
                        anh6.ajm(2);
                        anh6.MA(((long) aQm17.getCreateTime()) * 1000);
                        anh6.bhk(aQm17.getSnsId());
                        anh6.bhh(format3);
                        if (!(timeLineObject5 == null || timeLineObject5.AppInfo == null)) {
                            anh6.bhl(timeLineObject5.AppInfo.Id);
                        }
                        aml aml4 = new aml();
                        aml4.bgx(format3);
                        aml4.bgm(cnb8.Url);
                        aml4.bgn(cnb8.MsC);
                        aml4.bgl(aQm17.getTimeLine().ContentObj.Url);
                        boolean z2 = false;
                        if (!(timeLineObject5 == null || timeLineObject5.ContentObj.jfy == null || !s.YS(timeLineObject5.ContentObj.jfy.jfz))) {
                            z2 = true;
                            aml4.bgu(timeLineObject5.ContentObj.jfy.jfz);
                        }
                        String str9 = ar.ki(aj.getAccSnsPath(), cnb8.Id) + r.e(cnb8);
                        if (s.YS(str9)) {
                            z2 = true;
                            aml4.bgu(str9);
                        }
                        if (!z2) {
                            aml4.At(true);
                            aml4.bgo(cnb8.Msz);
                            anq anq2 = new anq();
                            anq2.bhv(cnb8.Msz);
                            anb6.b(anq2);
                        }
                        aml4.bgL(cnb8.songAlbumUrl);
                        aml4.bgM(cnb8.songLyric);
                        aml4.ajd(29);
                        aml4.bgf(cnb8.Title);
                        aml4.bgg(cnb8.Desc);
                        aml4.As(true);
                        if (css != null) {
                            amm amm2 = new amm();
                            amm2.e(css);
                            aml4.a(amm2);
                        }
                        anb6.ppH.add(aml4);
                        anb6.a(anh6);
                        czVar11.dFZ.dGb = anb6;
                        czVar11.dFZ.type = 21;
                        com.tencent.mm.plugin.sns.l.a.a(aml4, aQm17);
                    }
                    czVar11.dFZ.activity = this.activity;
                    czVar11.dFZ.dGf = 25;
                    EventCenter.instance.publish(czVar11);
                }
                AppMethodBeat.o(100195);
                return;
        }
        AppMethodBeat.o(100195);
    }

    private void aRr(String str) {
        String str2;
        AppMethodBeat.i(100196);
        SnsInfo aQm = aj.faO().aQm(str);
        if (aQm == null) {
            AppMethodBeat.o(100196);
            return;
        }
        TimeLineObject timeLine = aQm.getTimeLine();
        if (aQm.isAd()) {
            AdSnsInfo adSnsInfo = aQm.getAdSnsInfo();
            String Q = com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i.Q(aQm);
            if (!Util.isNullOrNil(Q)) {
                adSnsInfo.field_adxml = Q;
            }
            str2 = adSnsInfo.field_adxml;
        } else {
            str2 = timeLine.canvasInfo;
        }
        Map<String, String> parseXml = XmlParser.parseXml(str2, com.tencent.mm.g.c.f.COL_ADXML, null);
        if (parseXml == null) {
            AppMethodBeat.o(100196);
        } else if (!parseXml.containsKey(".adxml.adCanvasInfo")) {
            h.n(this.activity, R.string.c_b, 0);
            AppMethodBeat.o(100196);
        } else {
            String JX = ad.JX(new StringBuilder().append(aQm.field_snsId).toString());
            String nullAs = Util.nullAs(parseXml.get(".adxml.adCanvasInfo.shareTitle"), "");
            String nullAs2 = Util.nullAs(parseXml.get(".adxml.adCanvasInfo.shareWebUrl"), "");
            String nullAs3 = Util.nullAs(parseXml.get(".adxml.adCanvasInfo.shareDesc"), "");
            cz czVar = new cz();
            wo woVar = new wo();
            woVar.ecC.ecF = str;
            woVar.ecC.ecG = czVar;
            woVar.ecC.url = nullAs2;
            EventCenter.instance.publish(woVar);
            if (!woVar.ecD.dFE) {
                if (czVar.dFZ.dGe == 0) {
                    czVar.dFZ.dGe = R.string.c__;
                }
                h.n(this.activity, czVar.dFZ.dGe, 0);
                AppMethodBeat.o(100196);
                return;
            }
            czVar.dFZ.sessionId = JX;
            czVar.dFZ.title = nullAs;
            czVar.dFZ.desc = nullAs3;
            anb anb = czVar.dFZ.dGb;
            if (!(anb == null || anb.ppH == null || anb.ppH.size() <= 0 || anb.ppH.get(0) == null)) {
                anb.ppH.get(0).bgE(str2);
                if (Util.isNullOrNil(anb.ppH.get(0).title)) {
                    anb.ppH.get(0).bgf(czVar.dFZ.title);
                }
                if (Util.isNullOrNil(anb.ppH.get(0).desc)) {
                    anb.ppH.get(0).bgg(czVar.dFZ.desc);
                }
                anh anh = new anh();
                anh.bhf(timeLine.UserName);
                anh.bhg(z.aTY());
                anh.ajm(2);
                anh.MA(Util.nowMilliSecond());
                anb.a(anh);
            }
            czVar.dFZ.activity = this.activity;
            czVar.dFZ.dGf = 28;
            EventCenter.instance.publish(czVar);
            AppMethodBeat.o(100196);
        }
    }

    private void byl(String str) {
        String str2;
        AppMethodBeat.i(259467);
        SnsInfo aQm = aj.faO().aQm(str);
        String str3 = null;
        if (aQm != null && aQm.isAd()) {
            str3 = aQm.getAdInfoLink();
            if (Util.isNullOrNil(str3)) {
                str3 = aQm.getAdLink();
            }
        }
        if (Util.isNullOrNil(str3)) {
            str2 = bk.aRg(this.Fak.ContentObj.Url);
        } else {
            str2 = str3;
        }
        if (Util.isNullOrNil(str2)) {
            Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "favorite url fail, url is null");
            AppMethodBeat.o(259467);
            return;
        }
        cz czVar = new cz();
        SnsInfo aQm2 = com.tencent.mm.plugin.sns.storage.f.aQm(this.Faj);
        if (aQm2 != null) {
            String JX = ad.JX(new StringBuilder().append(aQm2.field_snsId).toString());
            ad.b G = ad.aVe().G(JX, true);
            G.l("prePublishId", "sns_" + r.Jb(aQm2.field_snsId));
            G.l("preUsername", aQm2.field_userName);
            G.l("preChatName", "");
            G.l("url", str2);
            G.l("preMsgIndex", 0);
            G.l("sendAppMsgScene", 1);
            G.l("adExtStr", aQm2.getTimeLine().statExtStr);
            czVar.dFZ.sessionId = JX;
        }
        if (aQm != null && (this.Fak.ContentObj.LoU == 18 || aQm.isAd())) {
            com.tencent.mm.plugin.sns.ad.g.o.a(o.d.AdUrl, o.c.Fav, o.e.Samll, 0, aQm, this.source);
            if (this.Fak != null) {
                SnsAdClick snsAdClick = new SnsAdClick(this.source, this.source == 0 ? 1 : 2, aQm2.field_snsId, 11, 0);
                com.tencent.mm.plugin.sns.data.k.a(snsAdClick, this.EBv, aQm, 11);
                r.a(snsAdClick);
            }
        }
        if (!Util.isNullOrNil(this.Fak.canvasInfo)) {
            aRr(aQm.getLocalid());
            AppMethodBeat.o(259467);
            return;
        }
        com.tencent.mm.plugin.sns.l.a.a(czVar, str2, this.Faj);
        czVar.dFZ.activity = this.activity;
        czVar.dFZ.dGf = 28;
        EventCenter.instance.publish(czVar);
        if (czVar.dGa.ret == 0) {
            long nowSecond = Util.nowSecond();
            if (!Util.isNullOrNil(str2)) {
                Log.d("MicroMsg.TimeLineMMMenuItemSelectedListener", "report(%s), url : %s, clickTimestamp : %d, scene : %d, actionType : %d, flag : %d", 13378, str2, Long.valueOf(nowSecond), 3, 2, 1);
                String str4 = "";
                try {
                    str4 = URLEncoder.encode(str2, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e2) {
                    Log.printErrStackTrace("MicroMsg.TimeLineMMMenuItemSelectedListener", e2, "", new Object[0]);
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13378, str4, Long.valueOf(nowSecond), 3, 2, 1);
            }
        }
        AppMethodBeat.o(259467);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(100197);
        if (i3 == -1) {
            if (i2 == 15) {
                SnsInfo aQm = aj.faO().aQm(this.Faj);
                cnb cnb = this.Fak.ContentObj.LoV.get(0);
                String stringExtra = intent.getStringExtra("Select_Conv_User");
                String stringExtra2 = intent.getStringExtra("custom_send_text");
                String str = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.e(cnb);
                for (String str2 : Util.stringsToList(stringExtra.split(","))) {
                    if (aQm.isAd()) {
                        String str3 = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.j(cnb);
                        TimeLineObject timeLine = aQm.getTimeLine();
                        ADXml adXml = aQm.getAdXml();
                        eeq eeq = new eeq();
                        eeq.LxJ = cnb.ERX;
                        eeq.iyZ = cnb.MsF;
                        if (timeLine.ContentObj.LoU == 15) {
                            eeq.izf = g(aQm).uxInfo;
                            eeq.izg = timeLine.Id;
                        } else {
                            eeq.izf = timeLine.streamvideo.izf;
                            eeq.izg = timeLine.streamvideo.izg;
                        }
                        eeq.izb = timeLine.ContentDesc;
                        eeq.ize = Util.isNullOrNil(cnb.MsI) ? cnb.Msz : cnb.MsI;
                        if (adXml != null && adXml.attachShareLinkIsHidden == 0) {
                            eeq.izd = adXml.attachShareLinkUrl;
                            eeq.izc = adXml.attachShareLinkWording;
                        }
                        int aOx = r.aOx(str3);
                        Log.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send adsight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", str2, str3, str, cnb.MsF, Integer.valueOf(cnb.ERX), Integer.valueOf(aOx));
                        com.tencent.mm.plugin.messenger.a.g.eir().a(this.activity, str2, str3, str, 43, aOx, eeq, timeLine.statExtStr, null);
                        com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra2, str2);
                        r.a(new SnsAdClick(this.source, this.source == 0 ? 1 : 2, aQm.field_snsId, 12, 0));
                        boolean Eq = ab.Eq(str2);
                        com.tencent.mm.plugin.sns.ad.g.o.a(o.d.Sight, Eq ? o.c.Chatroom : o.c.Chat, o.e.Samll, Eq ? v.Ie(str2) : 0, aQm, this.source);
                        AppMethodBeat.o(100197);
                        return;
                    }
                    String str4 = ar.ki(aj.getAccSnsPath(), cnb.Id) + r.j(cnb);
                    int aOx2 = r.aOx(str4);
                    Log.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "send sight to %s, videopath %s, thumbpath %s url: %s time: %d, duration: %s", str2, str4, str, cnb.MsF, Integer.valueOf(cnb.ERX), Integer.valueOf(aOx2));
                    com.tencent.mm.plugin.messenger.a.g.eir().a(this.activity, str2, str4, str, 43, aOx2, this.Fak.statExtStr, (String) null);
                    com.tencent.mm.plugin.messenger.a.g.eir().iF(stringExtra2, str2);
                }
                com.tencent.mm.ui.widget.snackbar.b.r(this.activity, this.activity.getString(R.string.dzo));
                AppMethodBeat.o(100197);
                return;
            }
        } else if (i2 == 15) {
            SnsInfo aQm2 = aj.faO().aQm(this.Faj);
            if (aQm2 == null) {
                Log.w("MicroMsg.TimeLineMMMenuItemSelectedListener", "menuitemselected and snsinfo is null %s", this.Faj);
                AppMethodBeat.o(100197);
                return;
            }
            r.a(new SnsAdClick(this.source, this.source == 0 ? 1 : 2, aQm2.field_snsId, 13, 0));
        }
        AppMethodBeat.o(100197);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        String str2;
        long j2;
        AppMethodBeat.i(100198);
        Log.i("MicroMsg.TimeLineMMMenuItemSelectedListener", "onSceneEnd");
        if (this.EoW != null && this.EoW.isShowing()) {
            this.EoW.dismiss();
        }
        if (i2 == 0 && i3 == 0 && (qVar instanceof com.tencent.mm.plugin.sns.model.s) && (((com.tencent.mm.plugin.sns.model.s) qVar).type == 4 || ((com.tencent.mm.plugin.sns.model.s) qVar).type == 6)) {
            u.u(this.activity, this.activity.getResources().getString(R.string.hbj), R.raw.icons_filled_done);
            com.tencent.mm.plugin.sns.model.s sVar = (com.tencent.mm.plugin.sns.model.s) qVar;
            if (sVar.DIu == null) {
                str2 = "";
            } else {
                str2 = sVar.DIu.Username;
            }
            if (!Util.isEqual(str2, z.aTY())) {
                int i4 = 9;
                if (((com.tencent.mm.plugin.sns.model.s) qVar).type == 6) {
                    i4 = 10;
                }
                long j3 = ((com.tencent.mm.plugin.sns.model.s) qVar).DIt;
                com.tencent.mm.plugin.sns.storage.i faT = aj.faT();
                com.tencent.mm.plugin.sns.model.s sVar2 = (com.tencent.mm.plugin.sns.model.s) qVar;
                if (sVar2.DIu == null) {
                    j2 = 0;
                } else if (sVar2.type == 6) {
                    j2 = sVar2.DIu.MYV;
                } else {
                    j2 = (long) sVar2.DIu.MYT;
                }
                com.tencent.mm.plugin.sns.storage.h i5 = faT.i(j3, j2, i4);
                if (i5 != null) {
                    i5.feD();
                    aj.faT().update(i5.systemRowid, i5);
                }
            }
        }
        AppMethodBeat.o(100198);
    }
}
