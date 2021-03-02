package com.tencent.mm.ui.chatting.viewitems;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ab.i;
import com.tencent.mm.ac.d;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.b.a;
import com.tencent.mm.msgsubscription.c.a;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.k;
import com.tencent.mm.plugin.sns.data.s;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.eft;
import com.tencent.mm.protocal.protobuf.fey;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.chatting.d.b.f;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.view.ChattingAvatarImageView;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.m;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.x;

public final class ao extends c {
    private static final String PHp = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/wacomplain?action=show&appid=%s&msgid=%s&from=%d&version_type=%d&version_code=%d#wechat_redirect");
    private static final String PMD = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/waverifyinfo?action=get&appid=%s#wechat_redirect");
    private static final String PME = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e20) + "/mp/infringement?from=8&username=%s&template_id=%s&template_msg_id=%s1#wechat_redirect");
    private static int PMV = MMApplicationContext.getContext().getResources().getColor(R.color.l4);
    private static int PMW = MMApplicationContext.getContext().getResources().getColor(R.color.l4);
    private q Fxt;
    private c Oxy;
    private View.OnClickListener PHr;
    private View.OnClickListener PMF;
    private View.OnClickListener PMG;
    private View.OnClickListener PMH;
    private View.OnClickListener PMI;
    private m PMJ;
    private View.OnClickListener PMK;
    private ISubscribeMsgService.c PML = new ISubscribeMsgService.c(true, false);
    private String PMM;
    private int PMN;
    private com.tencent.mm.msgsubscription.b.a PMO;
    private String PMP = "";
    private int PMQ = -1;
    private a.b PMR = new a.b();
    private boolean PMS = false;
    private e PMT = null;
    private boolean PMU = false;
    private com.tencent.mm.ui.chatting.e.a PhN;
    private IListener<op> PvR;
    private q gxX;
    private com.tencent.mm.msgsubscription.b.a jzW;
    private String mAppId;
    private View.OnClickListener rID;

    static /* synthetic */ void a(ao aoVar, int i2, String str, String str2) {
        AppMethodBeat.i(233888);
        aoVar.X(i2, str, str2);
        AppMethodBeat.o(233888);
    }

    static /* synthetic */ void a(ao aoVar, bv bvVar, int i2) {
        AppMethodBeat.i(233903);
        aoVar.a(bvVar, i2);
        AppMethodBeat.o(233903);
    }

    static /* synthetic */ void a(ao aoVar, Map map, ca caVar, bv bvVar, ISubscribeMsgService.c cVar, boolean z) {
        AppMethodBeat.i(233901);
        aoVar.a(map, caVar, bvVar, cVar, z);
        AppMethodBeat.o(233901);
    }

    static /* synthetic */ void nj(String str, String str2) {
        AppMethodBeat.i(233889);
        Y(9, str, str2);
        AppMethodBeat.o(233889);
    }

    static {
        AppMethodBeat.i(37267);
        AppMethodBeat.o(37267);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTT() {
        return false;
    }

    public ao() {
        AppMethodBeat.i(37240);
        c.a aVar = new c.a();
        aVar.iaT = true;
        aVar.jbq = R.drawable.bar;
        this.Oxy = aVar.bdv();
        com.tencent.mm.msgsubscription.api.b bVar = com.tencent.mm.msgsubscription.api.b.jza;
        this.jzW = com.tencent.mm.msgsubscription.api.b.Ru("name_biz");
        com.tencent.mm.msgsubscription.api.b bVar2 = com.tencent.mm.msgsubscription.api.b.jza;
        this.PMO = com.tencent.mm.msgsubscription.api.b.Ru("name_wxa");
        this.PMG = new a(this, (byte) 0);
        this.PMK = new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(37198);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bq bqVar = (bq) view.getTag();
                Log.i("MicroMsg.ChattingItemDyeingTemplate", "on header (%s) name click", bqVar.userName);
                Map<String, String> parseXml = XmlParser.parseXml(bqVar.dTX.field_content, "msg", null);
                String nullAsNil = Util.nullAsNil(parseXml.get(".msg.fromusername"));
                h.INSTANCE.a(11608, ao.this.PMM, nullAsNil, 66666);
                String nullAsNil2 = Util.nullAsNil(parseXml.get(".msg.appmsg.mmreader.template_header.weapp_username"));
                if (Util.isNullOrNil(nullAsNil2)) {
                    String nullAsNil3 = Util.nullAsNil(parseXml.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
                    if (!Util.isNullOrNil(nullAsNil3)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", nullAsNil3);
                        c.r(intent, ao.this.PhN.getTalkerUserName());
                        com.tencent.mm.br.c.b(ao.this.PhN.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                    }
                } else {
                    String nullAsNil4 = Util.nullAsNil(parseXml.get(".msg.appmsg.mmreader.template_header.weapp_path"));
                    int i2 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_header.weapp_state"), 0);
                    int i3 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_header.weapp_version"), 0);
                    String nullAsNil5 = Util.nullAsNil(parseXml.get(".msg.appmsg.template_id"));
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.dCw = bqVar.dTX.field_msgSvrId + ":" + bqVar.userName + ":" + ao.this.PhN.getTalkerUserName() + ":" + nullAsNil5;
                    appBrandStatObject.scene = ao.aeQ(nullAsNil5);
                    ((r) g.af(r.class)).a(ao.this.PhN.Pwc.getContext(), nullAsNil2, (String) null, i2, i3, nullAsNil4, appBrandStatObject);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37198);
            }
        };
        this.PHr = new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass12 */

            /* JADX WARNING: Removed duplicated region for block: B:9:0x0077  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(android.view.View r9) {
                /*
                // Method dump skipped, instructions count: 169
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass12.onClick(android.view.View):void");
            }
        };
        this.PvR = new IListener<op>() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass23 */

            {
                AppMethodBeat.i(233853);
                this.__eventId = op.class.getName().hashCode();
                AppMethodBeat.o(233853);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(op opVar) {
                AppMethodBeat.i(233854);
                if (ao.this.PhN != null) {
                    ao.this.PhN.Pwc.getContext().runOnUiThread(new Runnable() {
                        /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass23.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(233852);
                            ao.this.PhN.cmy();
                            AppMethodBeat.o(233852);
                        }
                    });
                }
                AppMethodBeat.o(233854);
                return true;
            }
        };
        this.PMJ = new m() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass32 */

            {
                AppMethodBeat.i(161547);
                AppMethodBeat.o(161547);
            }

            @Override // com.tencent.mm.ui.m
            public final void gIk() {
            }

            @Override // com.tencent.mm.ui.m
            public final void gIl() {
            }

            @Override // com.tencent.mm.ui.m
            public final void gIm() {
            }

            @Override // com.tencent.mm.ui.m
            public final void cFx() {
            }

            @Override // com.tencent.mm.ui.m
            public final void cFy() {
            }

            @Override // com.tencent.mm.ui.m
            public final void gIn() {
                AppMethodBeat.i(233863);
                Log.i("MicroMsg.ChattingItemDyeingTemplate", "onChattingExitAnimStart, then remove AppBrandTmplMsgReceivingSwitchListener.");
                EventCenter.instance.removeListener(ao.this.PvR);
                if (ao.this.PhN != null) {
                    ((j) ao.this.PhN.bh(j.class)).b(this);
                }
                AppMethodBeat.o(233863);
            }

            @Override // com.tencent.mm.ui.m
            public final void gIo() {
            }
        };
        this.PMH = new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass33 */

            public final void onClick(View view) {
                AppMethodBeat.i(233864);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bq bqVar = (bq) view.getTag();
                Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", bqVar.userName);
                wq wqVar = new wq();
                wqVar.ecI.userName = bqVar.userName;
                wqVar.ecI.ecK = bqVar.pageUrl;
                Map<String, String> parseXml = XmlParser.parseXml(bqVar.dTX.field_content, "msg", null);
                String str = "";
                if (parseXml != null && parseXml.size() > 0) {
                    wqVar.ecI.ecL = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), 0);
                    str = Util.nullAsNil(parseXml.get(".msg.appmsg.template_id"));
                }
                wqVar.ecI.ecP = true;
                wqVar.ecI.scene = ao.aeQ(str);
                wqVar.ecI.dCw = bqVar.dTX.field_msgSvrId + ":" + bqVar.userName + ":" + ao.this.PhN.getTalkerUserName() + ":" + str;
                EventCenter.instance.publish(wqVar);
                ao.nj(ao.this.mAppId, ao.this.PMM);
                h.INSTANCE.a(11608, ao.this.PMM, bqVar.userName, 0);
                ao.a(ao.this, 2, ao.this.PhN.getTalkerUserName(), bqVar.userName);
                ao.a(ao.this, 8, bqVar.userName, 1, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(233864);
            }
        };
        this.rID = new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass34 */

            public final void onClick(View view) {
                AppMethodBeat.i(37231);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bq bqVar = (bq) view.getTag();
                Map<String, String> parseXml = XmlParser.parseXml(bqVar.dTX.field_content, "msg", null);
                if (parseXml == null) {
                    Log.i("MicroMsg.ChattingItemDyeingTemplate", "values map is null.");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(37231);
                    return;
                }
                int i2 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
                if (i2 == 1) {
                    String str = parseXml.get(".msg.appmsg.mmreader.category.item.weapp_username");
                    String str2 = parseXml.get(".msg.appmsg.mmreader.category.item.weapp_path");
                    int i3 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.category.item.weapp_version"), 0);
                    int i4 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.category.item.weapp_state"), 0);
                    String nullAsNil = Util.nullAsNil(parseXml.get(".msg.appmsg.template_id"));
                    Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) container click", str);
                    AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                    appBrandStatObject.dCw = bqVar.dTX.field_msgSvrId + ":" + bqVar.userName + ":" + ao.this.PhN.getTalkerUserName() + ":" + nullAsNil;
                    if (((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(bqVar.userName)) {
                        appBrandStatObject.scene = ao.aeQ(nullAsNil);
                        ((r) g.af(r.class)).a(ao.this.PhN.Pwc.getContext(), str, (String) null, i4, i3, str2, appBrandStatObject);
                    } else {
                        appBrandStatObject.scene = 1043;
                        com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(bqVar.userName);
                        ((r) g.af(r.class)).a(ao.this.PhN.Pwc.getContext(), str, null, i4, i3, str2, appBrandStatObject, fJ == null ? null : fJ.field_appId);
                    }
                    ao.nj(ao.this.mAppId, ao.this.PMM);
                    h.INSTANCE.a(11608, ao.this.PMM, bqVar.userName, 0);
                    ao.a(ao.this, 2, ao.this.PhN.getTalkerUserName(), bqVar.userName);
                } else if (i2 == 2) {
                    String str3 = parseXml.get(".msg.appmsg.mmreader.category.item.schedule_username");
                    long j2 = Util.getLong(parseXml.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1);
                    ao.g(view.getContext(), str3, j2);
                    Log.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", str3, Long.valueOf(j2));
                }
                ao.a(ao.this, 8, bqVar.userName, i2 == 1 ? 1 : 2, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37231);
            }
        };
        this.PMI = new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass35 */

            public final void onClick(View view) {
                String str;
                String str2;
                AppMethodBeat.i(37232);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bq bqVar = (bq) view.getTag();
                int i2 = bqVar.opType;
                String str3 = bqVar.PQK;
                Log.i("MicroMsg.ChattingItemDyeingTemplate", "jumpNativePage opType: %d, opInfo: %s", Integer.valueOf(bqVar.opType), bqVar.PQK);
                if (i2 == 3) {
                    Activity context = ao.this.PhN.Pwc.getContext();
                    Log.i("SnsAdUtil", "type = 0content = " + str3);
                    s aOc = k.aOc(str3);
                    String str4 = aOc.pageId;
                    String str5 = aOc.uxInfo;
                    String str6 = aOc.lAP;
                    if (context != null) {
                        if (!Util.isNullOrNil(str4, str5, str6)) {
                            Intent intent = new Intent();
                            intent.putExtra("sns_landing_pages_pageid", Util.safeParseLong(str4));
                            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                            intent.putExtra("sns_landig_pages_from_source", 21);
                            intent.putExtra("sns_landing_pages_ad_info", str6);
                            com.tencent.mm.br.c.b(context, "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
                        }
                    }
                    Log.e("SnsAdUtil", "context or pageId or uxInfo or adInfoXml is null");
                } else if (i2 == 4) {
                    try {
                        i iVar = new i(bqVar.PQK);
                        long Ga = d.Ga(iVar.optString("feed_id"));
                        long Ga2 = d.Ga(iVar.optString("live_id"));
                        ((aj) g.ah(aj.class)).enterFinderLiveVisitorUI(MMApplicationContext.getContext(), Ga, Long.valueOf(Ga2), "", iVar.optString("nonce_id"), "", "", "", "", 0);
                        ao.a(Ga, Ga2, bqVar.userName, bqVar.position);
                    } catch (Throwable th) {
                        Log.printErrStackTrace("MicroMsg.ChattingItemDyeingTemplate", th, "OP_ITEM_TYPE_FINDER_LIVE exception", new Object[0]);
                    }
                }
                Bundle bundle = bqVar.CAJ;
                if (bundle != null) {
                    int i3 = bundle.getInt("click_area_type");
                    if (i3 == 1) {
                        ao aoVar = ao.this;
                        if (bqVar.dTX != null) {
                            str2 = bqVar.dTX.field_talker;
                        } else {
                            str2 = "";
                        }
                        ao.a(aoVar, 2, str2, bqVar.userName);
                    } else if (i3 == 2) {
                        ao aoVar2 = ao.this;
                        if (bqVar.dTX != null) {
                            str = bqVar.dTX.field_talker;
                        } else {
                            str = "";
                        }
                        ao.a(aoVar2, 3, str, bqVar.userName);
                    }
                }
                ao.a(ao.this, 8, bqVar.userName, i2 == 1 ? 1 : 2, 0);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37232);
            }
        };
        AppMethodBeat.o(37240);
    }

    private void a(final bv bvVar) {
        AppMethodBeat.i(233870);
        this.PMF = new View.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass36 */

            public final void onClick(final View view) {
                AppMethodBeat.i(233867);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                final ca caVar = (ca) view.getTag(R.id.fwr);
                if (caVar == null) {
                    Log.w("MicroMsg.ChattingItemDyeingTemplate", "on more view click, but msg is null.");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(233867);
                    return;
                }
                final Map<String, String> parseXml = XmlParser.parseXml(caVar.field_content, "msg", null);
                if (parseXml == null || parseXml.size() == 0) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(233867);
                    return;
                }
                final String nullAsNil = Util.nullAsNil(parseXml.get(".msg.fromusername"));
                final boolean HF = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(nullAsNil);
                ao.this.PMT = new e(view.getContext(), 1, false);
                ao.this.PMT.HLX = new o.f() {
                    /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass36.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.base.o.f
                    public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                        String string;
                        AppMethodBeat.i(233865);
                        mVar.clear();
                        if (!ao.this.PMS) {
                            ao.a(ao.this, caVar, parseXml, mVar, ao.this.PML);
                        }
                        if (HF) {
                            string = view.getResources().getString(R.string.fh9);
                        } else {
                            string = view.getResources().getString(R.string.fh7);
                        }
                        mVar.add(0, 2, 0, string);
                        AppMethodBeat.o(233865);
                    }
                };
                ao.this.PMT.HLY = new o.g() {
                    /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass36.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.o.g
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                        int i3;
                        AppMethodBeat.i(233866);
                        int itemId = menuItem.getItemId();
                        Log.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected. msgId: %s, v: %s", Integer.valueOf(itemId), Integer.valueOf(i2), Long.valueOf(caVar.field_msgId), view);
                        switch (menuItem.getItemId()) {
                            case 0:
                            case 1:
                                ao.a(ao.this, caVar, parseXml, HF, ao.a(ao.this, parseXml), ao.this.PML, bvVar);
                                break;
                            case 2:
                                ao.a(ao.this, view, caVar, parseXml, nullAsNil);
                                break;
                        }
                        if (ao.this.PMU) {
                            if (itemId == 2) {
                                i3 = 1;
                            } else if (itemId == 1) {
                                i3 = 2;
                            } else if (itemId == 0) {
                                i3 = 3;
                            } else {
                                i3 = 0;
                            }
                            ao.a(ao.this, 9, nullAsNil, 0, i3);
                        }
                        AppMethodBeat.o(233866);
                    }
                };
                ao.this.PMT.dGm();
                ao.a(ao.this, 4, caVar.field_talker, nullAsNil);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(233867);
            }
        };
        bvVar.PRb.setOnClickListener(this.PMF);
        AppMethodBeat.o(233870);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean bM(int i2, boolean z) {
        if (i2 == 318767153) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final View a(LayoutInflater layoutInflater, View view) {
        AppMethodBeat.i(37241);
        if (view == null || view.getTag() == null) {
            view = new an(layoutInflater, R.layout.r2);
            bo boVar = new bo();
            boVar.checkBox = (CheckBox) view.findViewById(R.id.aue);
            boVar.maskView = view.findViewById(R.id.ax3);
            boVar.userTV = (TextView) view.findViewById(R.id.ayn);
            boVar.avatarIV = (ChattingAvatarImageView) view.findViewById(R.id.au2);
            boVar.timeTV = (TextView) view.findViewById(R.id.ayf);
            boVar.pxI = (LinearLayout) view.findViewById(R.id.aum);
            boVar.PQu.puO = view.findViewById(R.id.aw1);
            boVar.PQu.PQx = view.findViewById(R.id.dnw);
            boVar.PQu.hbb = (TextView) boVar.PQu.puO.findViewById(R.id.ipm);
            boVar.PQu.PQA = (LinearLayout) boVar.PQu.puO.findViewById(R.id.bra);
            boVar.PQu.uCh = (TextView) boVar.pxI.findViewById(R.id.bnx);
            boVar.PQu.PQB = boVar.pxI.findViewById(R.id.hkw);
            boVar.PQu.PQy = view.findViewById(R.id.fl6);
            boVar.PQu.PQz = view.findViewById(R.id.fl7);
            boVar.PQv.PQU = view.findViewById(R.id.aw0);
            boVar.PQv.PQV = (ImageView) view.findViewById(R.id.fwp);
            boVar.PQv.PQW = view.findViewById(R.id.fwn);
            boVar.PQv.PQY = (TextView) view.findViewById(R.id.fx5);
            boVar.PQv.PQX = (ImageView) view.findViewById(R.id.fvz);
            boVar.PQv.PQZ = view.findViewById(R.id.fw3);
            boVar.PQv.PRa = (ImageView) view.findViewById(R.id.fwt);
            boVar.PQv.PRb = view.findViewById(R.id.fwr);
            boVar.PQv.PRc = view.findViewById(R.id.fws);
            boVar.PQv.PRd = (TextView) view.findViewById(R.id.fwy);
            boVar.PQv.PRe = (TextView) view.findViewById(R.id.fw0);
            boVar.PQv.PRf = (TextView) view.findViewById(R.id.fwm);
            boVar.PQv.PRg = view.findViewById(R.id.fwo);
            boVar.PQv.PRh = (LinearLayout) view.findViewById(R.id.fwz);
            boVar.PQv.PRi = (TextView) view.findViewById(R.id.fx1);
            boVar.PQv.PRk = (TextView) view.findViewById(R.id.fx2);
            boVar.PQv.PRj = (TextView) view.findViewById(R.id.fx3);
            boVar.PQv.PRl = (TextView) view.findViewById(R.id.fx4);
            boVar.PQv.PRm = view.findViewById(R.id.fx0);
            boVar.PQv.PRn = (LinearLayout) view.findViewById(R.id.fwq);
            boVar.PQv.PRr = view.findViewById(R.id.fwg);
            boVar.PQv.PRo = view.findViewById(R.id.aad);
            boVar.PQv.PRp = (LinearLayout) view.findViewById(R.id.fwe);
            boVar.PQv.PRq = (LinearLayout) view.findViewById(R.id.bva);
            boVar.PQv.PRs = (LinearLayout) view.findViewById(R.id.fw5);
            boVar.PQv.PRv = (TextView) view.findViewById(R.id.fw7);
            boVar.PQv.PRx = (ImageView) view.findViewById(R.id.fw6);
            boVar.PQv.PRu = view.findViewById(R.id.fwf);
            boVar.PQv.PRt = (LinearLayout) view.findViewById(R.id.fw8);
            boVar.PQv.PRw = (TextView) view.findViewById(R.id.fw_);
            boVar.PQv.PRy = (ImageView) view.findViewById(R.id.fw9);
            boVar.PQv.PRz = (ImageView) view.findViewById(R.id.fvy);
            boVar.PIb = (ImageView) view.findViewById(R.id.avz);
            boVar.PQv.PRA = view.findViewById(R.id.fwu);
            boVar.PQv.PRB = (ImageView) view.findViewById(R.id.fwv);
            boVar.PQv.PRC = (TextView) view.findViewById(R.id.fww);
            boVar.PQv.PRD = (LinearLayout) view.findViewById(R.id.fw1);
            boVar.PQv.PRE = (TextView) view.findViewById(R.id.fw2);
            boVar.PQw.PGC = (LinearLayout) view.findViewById(R.id.fwj);
            boVar.PQw.PGD = (CdnImageView) view.findViewById(R.id.fwi);
            boVar.PQw.PGE = (TextView) view.findViewById(R.id.fwk);
            boVar.PQw.PGF = (TextView) view.findViewById(R.id.fwh);
            view.setTag(boVar);
        }
        AppMethodBeat.o(37241);
        return view;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTU() {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final void a(c.a aVar, int i2, com.tencent.mm.ui.chatting.e.a aVar2, final ca caVar, String str) {
        CharSequence bmF;
        int i3;
        boolean z;
        String str2;
        View view;
        boolean z2;
        AppMethodBeat.i(37242);
        this.PhN = aVar2;
        PMV = aVar2.getContext().getResources().getColor(R.color.l4);
        PMW = aVar2.getContext().getResources().getColor(R.color.l4);
        this.PMU = ((com.tencent.mm.ui.chatting.d.b.o) aVar2.bh(com.tencent.mm.ui.chatting.d.b.o.class)).gPH();
        bo boVar = (bo) aVar;
        final Map<String, String> parseXml = XmlParser.parseXml(caVar.getContent(), "msg", null);
        if (parseXml == null || parseXml.size() == 0) {
            Log.e("MicroMsg.ChattingItemDyeingTemplate", "filling fail, values is empty");
            boVar.pxI.setVisibility(8);
            AppMethodBeat.o(37242);
            return;
        }
        boVar.pxI.setVisibility(0);
        int i4 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
        this.PMM = Util.nullAsNil(parseXml.get(".msg.appmsg.template_id"));
        this.PMQ = x(parseXml);
        this.PMN = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_header.pay_style"), 0);
        EventCenter.instance.removeListener(this.PvR);
        ((j) aVar2.bh(j.class)).b(this.PMJ);
        if (i4 != 0) {
            boVar.PQu.puO.setVisibility(8);
            final bv bvVar = boVar.PQv;
            if (Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0) == 1) {
                a(bvVar, Util.nullAsNil(parseXml.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url")), Util.nullAsNil(parseXml.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), parseXml, caVar, false);
            } else if (Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_header.show_icon_and_display_name"), 0) != 0) {
                a(bvVar, Util.nullAsNil(parseXml.get(".msg.appmsg.mmreader.template_header.icon_url")), Util.nullAsNil(parseXml.get(".msg.appmsg.mmreader.template_header.display_name")), parseXml, caVar, true);
            } else {
                ((View) bvVar.PRa.getParent()).setVisibility(8);
                if (!"notifymessage".equals(caVar.ajO()) || this.PMU) {
                    bvVar.PQW.setVisibility(8);
                } else {
                    final String nullAsNil = Util.nullAsNil(parseXml.get(".msg.fromusername"));
                    if (((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(nullAsNil)) {
                        WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(nullAsNil);
                        a(bvVar.PQX, this.PhN, nullAsNil, caVar, Xk == null ? null : Xk.field_brandIconURL, parseXml);
                        bmF = Xk == null ? nullAsNil : Xk.field_nickname;
                    } else {
                        a(bvVar.PQX, this.PhN, nullAsNil, caVar, (String) null, parseXml);
                        bmF = ((f) this.PhN.bh(f.class)).bmF(nullAsNil);
                    }
                    bvVar.PQY.setText(l.b(this.PhN.getContext(), bmF, bvVar.PQY.getTextSize()));
                    if (((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(nullAsNil)) {
                        bvVar.PQW.setTag(new bq(caVar, nullAsNil));
                        bvVar.PQW.setOnClickListener(this.PHr);
                    } else {
                        bvVar.PQW.setTag(new bq(nullAsNil, this.PhN.gRM() ? this.PhN.getTalkerUserName() : null));
                        if (Util.getBoolean(parseXml.get(".msg.appmsg.mmreader.template_detail.template_ext.block"), false)) {
                            bvVar.PQW.setOnClickListener(null);
                        } else {
                            bvVar.PQW.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass6 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(233829);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    t.b e2 = ao.this.e(ao.this.PhN);
                                    if (e2 != null) {
                                        e2.onClick(view);
                                    }
                                    ao.a(ao.this, 10, ao.this.PhN.getTalkerUserName(), nullAsNil);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(233829);
                                }
                            });
                        }
                    }
                    bvVar.PQW.setVisibility(0);
                }
            }
            if (Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_header.hide_icon_and_display_name_line"), 0) != 0) {
                bvVar.PQW.setBackgroundResource(R.drawable.aij);
            } else {
                int paddingLeft = bvVar.PQW.getPaddingLeft();
                bvVar.PQW.setBackgroundResource(R.drawable.b9w);
                bvVar.PQW.setPadding(paddingLeft, 0, 0, 0);
            }
            if (Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_header.ignore_hide_title_and_time"), 0) == 0) {
                i3 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_header.hide_title_and_time"), 0);
            } else {
                i3 = 0;
            }
            int i5 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_header.hide_title"), 0);
            bvVar.PRd.setVisibility(8);
            if (i3 == 0 && i5 == 0) {
                bvVar.PRd.setVisibility(0);
                this.PMP = Util.nullAsNil(parseXml.get(".msg.appmsg.mmreader.template_header.title"));
                bvVar.PRd.setTextColor(com.tencent.mm.ui.ao.hT(c(parseXml, ".msg.appmsg.mmreader.template_header.title_color", (int) WebView.NIGHT_MODE_COLOR)));
                bvVar.PRd.setText(this.PMP);
            }
            String nullAsNil2 = Util.nullAsNil(parseXml.get(".msg.appmsg.mmreader.template_header.first_data"));
            int c2 = c(parseXml, ".msg.appmsg.mmreader.template_header.first_color", PMW);
            if (Util.isNullOrNil(nullAsNil2)) {
                bvVar.PRf.setVisibility(8);
            } else {
                bvVar.PRf.setTextColor(com.tencent.mm.ui.ao.hT(c2));
                bvVar.PRf.setText(nullAsNil2);
                bvVar.PRf.setVisibility(0);
                if (i4 == 2) {
                    bvVar.PRf.setPadding(0, this.PhN.getResources().getDimensionPixelOffset(R.dimen.hs), 0, 0);
                } else {
                    bvVar.PRf.setPadding(0, 0, 0, 0);
                }
            }
            if (i3 == 0 || !Util.isNullOrNil(nullAsNil2)) {
                bvVar.PRg.setVisibility(0);
            } else {
                bvVar.PRg.setVisibility(8);
            }
            a.b bVar = this.PMR;
            bVar.username = "";
            bVar.type = 0;
            bVar.ixM = "";
            bVar.jyz = 0;
            bVar.jAu = "";
            bVar.dWG = "";
            bVar.jumpType = 0;
            bVar.jAv = "";
            String nullAsNil3 = Util.nullAsNil(parseXml.get(".msg.fromusername"));
            if (((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(nullAsNil3)) {
                boolean ch = ch(parseXml);
                if ("notifymessage".equals(caVar.ajO())) {
                    final String nullAsNil4 = Util.nullAsNil(parseXml.get(".msg.fromusername"));
                    this.PMR.setUsername(nullAsNil4);
                    this.PMR.setType(2);
                    ((j) this.PhN.bh(j.class)).a(this.PMJ);
                    EventCenter.instance.addListener(this.PvR);
                    if (ch) {
                        WxaAttributes Xk2 = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(nullAsNil4);
                        if (Xk2 != null) {
                            this.mAppId = Xk2.field_appId;
                        } else {
                            ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(nullAsNil4, new q.a() {
                                /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass16 */

                                @Override // com.tencent.mm.plugin.appbrand.service.q.a
                                public final void b(WxaAttributes wxaAttributes) {
                                    AppMethodBeat.i(233844);
                                    if (wxaAttributes != null) {
                                        Log.v("MicroMsg.ChattingItemDyeingTemplate", "alvinluo onGetWeAppInfo appId: %s", ao.this.mAppId);
                                        ao.this.mAppId = wxaAttributes.field_appId;
                                    }
                                    AppMethodBeat.o(233844);
                                }
                            });
                        }
                        bvVar.PRD.setVisibility(this.PMS ? 0 : 8);
                        a(bvVar, 8);
                        bvVar.PRE.setText(this.PhN.getResources().getString(R.string.fhm));
                        this.PML.fY(true);
                        this.PML.fZ(true);
                        a.C0464a aVar3 = com.tencent.mm.msgsubscription.b.a.jzz;
                        a.C0464a.bH(this.PMM, new StringBuilder().append(bvVar.PRD.hashCode()).toString());
                        a.C0464a aVar4 = com.tencent.mm.msgsubscription.b.a.jzz;
                        a.C0464a.a(this.PMM, new StringBuilder().append(bvVar.PRD.hashCode()).toString(), new ISubscribeMsgService.b() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass17 */

                            @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b
                            public final void a(String str, ISubscribeMsgService.c cVar) {
                                AppMethodBeat.i(233845);
                                if (str.equals(ao.this.PMM)) {
                                    Log.d("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s, templateId: %s, isSubscribed: %b, switchOpened: %b", nullAsNil4, str, Boolean.valueOf(cVar.jyX), Boolean.valueOf(cVar.jyY));
                                    ao.this.PML = new ISubscribeMsgService.c(cVar.jyX, cVar.jyY);
                                    ao.a(ao.this, parseXml, caVar, bvVar, ao.this.PML, true);
                                    if (!ao.this.PMS && ao.this.PMT != null && ao.this.PMT.isShowing()) {
                                        ao.this.PMT.dGm();
                                    }
                                }
                                AppMethodBeat.o(233845);
                            }

                            @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b
                            public final void onError() {
                                AppMethodBeat.i(233846);
                                Log.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onError");
                                AppMethodBeat.o(233846);
                            }
                        });
                        this.PMO.bG(nullAsNil4, this.PMM);
                    } else {
                        this.PML.fZ(false);
                        WxaAttributes Xk3 = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(nullAsNil4);
                        if (Xk3 != null) {
                            this.mAppId = Xk3.field_appId;
                            boolean z3 = (Xk3.field_appOpt & 1) > 0;
                            ISubscribeMsgService.c cVar = this.PML;
                            if (!z3) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            cVar.fY(z2);
                        } else {
                            Log.i("MicroMsg.ChattingItemDyeingTemplate", "try2HandleAppBrandLogic, sync attr username %s", nullAsNil4);
                            this.PML.fY(true);
                            ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(nullAsNil4, new q.a() {
                                /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass18 */

                                @Override // com.tencent.mm.plugin.appbrand.service.q.a
                                public final void b(WxaAttributes wxaAttributes) {
                                    boolean z = true;
                                    AppMethodBeat.i(233848);
                                    if (wxaAttributes == null) {
                                        AppMethodBeat.o(233848);
                                        return;
                                    }
                                    ao.this.mAppId = wxaAttributes.field_appId;
                                    boolean z2 = (wxaAttributes.field_appOpt & 1) > 0;
                                    ISubscribeMsgService.c cVar = ao.this.PML;
                                    if (z2) {
                                        z = false;
                                    }
                                    cVar.jyX = z;
                                    MMHandlerThread.postToMainThread(new Runnable() {
                                        /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass18.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(233847);
                                            ao.a(ao.this, parseXml, caVar, bvVar, ao.this.PML, false);
                                            AppMethodBeat.o(233847);
                                        }
                                    });
                                    AppMethodBeat.o(233848);
                                }
                            });
                        }
                        a(parseXml, caVar, bvVar, this.PML, false);
                    }
                }
                bvVar.PRb.setVisibility(0);
                bvVar.PRb.setTag(R.id.fwr, caVar);
                a(bvVar);
            } else if (com.tencent.mm.al.g.Nb(nullAsNil3)) {
                boolean z4 = true;
                if (!"notifymessage".equals(caVar.ajO())) {
                    z4 = false;
                    z = true;
                } else if (!rL(this.PMQ)) {
                    z = false;
                } else {
                    String nullAsNil5 = Util.nullAsNil(parseXml.get(".msg.fromusername"));
                    this.PMR.setUsername(Util.nullAs(nullAsNil5, ""));
                    this.PMR.setType(1);
                    a.b bVar2 = this.PMR;
                    String nullAs = Util.nullAs(this.PMM, "");
                    p.h(nullAs, "<set-?>");
                    bVar2.ixM = nullAs;
                    this.PMR.jyz = this.PMQ;
                    a.b bVar3 = this.PMR;
                    String nullAs2 = Util.nullAs(this.PMP, "");
                    p.h(nullAs2, "<set-?>");
                    bVar3.jAu = nullAs2;
                    bvVar.PRD.setVisibility(this.PMS ? 0 : 8);
                    a(bvVar, 8);
                    bvVar.PRE.setText(this.PhN.getResources().getString(R.string.fhm));
                    a.C0464a aVar5 = com.tencent.mm.msgsubscription.b.a.jzz;
                    a.C0464a.bH(this.PMM, new StringBuilder().append(bvVar.PRD.hashCode()).toString());
                    a.C0464a aVar6 = com.tencent.mm.msgsubscription.b.a.jzz;
                    a.C0464a.a(this.PMM, new StringBuilder().append(bvVar.PRD.hashCode()).toString(), new ISubscribeMsgService.b() {
                        /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass7 */

                        @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b
                        public final void a(String str, ISubscribeMsgService.c cVar) {
                            AppMethodBeat.i(233830);
                            if (str.equals(ao.this.PMM)) {
                                Log.d("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onUpdated templateId: %s, isSubscribed: %b, switchOpen: %b", str, Boolean.valueOf(cVar.jyX), Boolean.valueOf(cVar.jyY));
                                ao.this.PML = new ISubscribeMsgService.c(cVar.jyX, cVar.jyY);
                                ao.a(ao.this, parseXml, caVar, bvVar, cVar);
                                if (!ao.this.PMS && ao.this.PMT != null && ao.this.PMT.isShowing()) {
                                    ao.this.PMT.dGm();
                                }
                            }
                            AppMethodBeat.o(233830);
                        }

                        @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b
                        public final void onError() {
                            AppMethodBeat.i(37208);
                            Log.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo getSubscribeStatus onError");
                            AppMethodBeat.o(37208);
                        }
                    });
                    this.jzW.bG(nullAsNil5, this.PMM);
                    z = true;
                }
                if (!z4 || !z) {
                    bvVar.PRD.setVisibility(8);
                    a(bvVar, 8);
                }
                if (z4 && z) {
                    bvVar.PRb.setVisibility(0);
                    bvVar.PRb.setTag(R.id.fwr, caVar);
                    a(bvVar);
                }
            } else {
                bvVar.PRD.setVisibility(8);
                a(bvVar, 8);
            }
            bvVar.PQV.setVisibility(8);
            bvVar.PRf.setText(Util.nullAsNil(parseXml.get(".msg.appmsg.mmreader.template_header.first_data")));
            String str3 = parseXml.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.word");
            String str4 = parseXml.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.word");
            String str5 = parseXml.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word");
            if (!Util.isNullOrNil(str4)) {
                int hT = com.tencent.mm.ui.ao.hT(c(parseXml, ".msg.appmsg.mmreader.template_detail.line_content.topline.key.color", this.PhN.getContext().getResources().getColor(R.color.a2x)));
                int hT2 = com.tencent.mm.ui.ao.hT(c(parseXml, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.color", this.PhN.getContext().getResources().getColor(R.color.a2x)));
                int hT3 = com.tencent.mm.ui.ao.hT(c(parseXml, ".msg.appmsg.mmreader.template_detail.line_content.topline.value.strikethrough_word_color", this.PhN.getContext().getResources().getColor(R.color.a2x)));
                int i6 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_detail.line_content.topline.value.small_text_count"), 0);
                bvVar.PRi.setTextColor(hT);
                bvVar.PRk.setTextColor(hT2);
                bvVar.PRl.setTextColor(hT3);
                bvVar.PRl.getPaint().setFlags(16);
                bvVar.PRi.setText(str3);
                if (i6 <= 0 || i6 >= str4.length()) {
                    bvVar.PRj.setTypeface(Typeface.DEFAULT);
                    bvVar.PRj.setVisibility(8);
                    if (str4.contains("￥") || str4.contains("¥") || str4.contains("$") || str4.contains("＄")) {
                        bvVar.PRk.setTypeface(com.tencent.mm.wallet_core.ui.f.aS(this.PhN.getContext(), 0));
                        bvVar.PRk.setTextSize(1, 40.0f);
                        bvVar.PRk.setIncludeFontPadding(true);
                    } else {
                        bvVar.PRk.setTypeface(Typeface.DEFAULT);
                        com.tencent.mm.ui.ao.a(bvVar.PRk.getPaint(), 0.8f);
                        bvVar.PRk.setTextSize(1, 32.0f);
                        bvVar.PRk.setIncludeFontPadding(false);
                    }
                    bvVar.PRk.setText(str4);
                } else {
                    bvVar.PRj.setVisibility(0);
                    bvVar.PRj.setText(str4.substring(0, i6));
                    bvVar.PRj.setTextColor(hT2);
                    bvVar.PRj.setTypeface(com.tencent.mm.wallet_core.ui.f.aS(this.PhN.getContext(), 0));
                    bvVar.PRk.setTypeface(com.tencent.mm.wallet_core.ui.f.aS(this.PhN.getContext(), 0));
                    bvVar.PRk.setTextSize(1, 40.0f);
                    bvVar.PRj.setTextSize(1, 40.0f);
                    bvVar.PRk.setIncludeFontPadding(true);
                    bvVar.PRk.setText(str4.substring(i6));
                }
                if (!Util.isNullOrNil(str5)) {
                    bvVar.PRl.setText(str5);
                    bvVar.PRl.setVisibility(0);
                } else {
                    bvVar.PRl.setVisibility(8);
                }
                bvVar.PRh.setVisibility(0);
            } else {
                bvVar.PRh.setVisibility(8);
            }
            int i7 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.category.item.template_op_type"), -1);
            if (i7 == 2) {
                Log.i("MicroMsg.ChattingItemDyeingTemplate", "[fillingCustomView]");
                bvVar.PRn.setVisibility(8);
                ViewGroup viewGroup = (ViewGroup) bvVar.PRn.getParent();
                View findViewById = viewGroup.findViewById(R.id.bk0);
                if (findViewById == null) {
                    View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bml, (ViewGroup) null);
                    bn bnVar = new bn();
                    bnVar.kc = (ImageView) inflate.findViewById(R.id.wm);
                    bnVar.uuB = (TextView) inflate.findViewById(R.id.fzc);
                    bnVar.hbb = (TextView) inflate.findViewById(R.id.ipm);
                    inflate.setTag(bnVar);
                    viewGroup.addView(inflate);
                    view = inflate;
                } else {
                    view = findViewById;
                }
                view.setVisibility(0);
                bn bnVar2 = (bn) view.getTag();
                String str6 = parseXml.get(".msg.appmsg.mmreader.category.item.schedule_username");
                String str7 = parseXml.get(".msg.appmsg.mmreader.category.item.schedule_nickname");
                parseXml.get(".msg.appmsg.mmreader.category.item.schedule_time");
                int i8 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.category.item.schedule_remindsubtype"), -1);
                bnVar2.hbb.setText(l.c(bnVar2.hbb.getContext(), parseXml.get(".msg.appmsg.mmreader.category.item.schedule_content")));
                TextView textView = bnVar2.uuB;
                Context context = bnVar2.hbb.getContext();
                if (Util.isNullOrNil(str6)) {
                    str7 = "";
                } else {
                    String str8 = null;
                    if (ab.Eq(str6)) {
                        bg.aVF();
                        as Kn = com.tencent.mm.model.c.aSN().Kn(str6);
                        if (Kn != null) {
                            str8 = Util.isNullOrNil(Kn.ajy()) ? Kn.getNickname() : Kn.ajy();
                        }
                    } else {
                        bg.aVF();
                        as Kn2 = com.tencent.mm.model.c.aSN().Kn(str6);
                        str8 = Kn2.arJ() == null ? Kn2.arI() : Kn2.arJ();
                    }
                    if (Util.isNullOrNil(str8)) {
                        Log.i("MicroMsg.ChattingItemDyeingTemplate", "[getDisplayName] username:%s nickname:%s", str6, str7);
                        if (Util.isNullOrNil(str7)) {
                            str7 = MMApplicationContext.getContext().getString(R.string.b25);
                        }
                    } else {
                        str7 = str8;
                    }
                }
                textView.setText(l.c(context, str7));
                if (i8 == 2) {
                    bnVar2.kc.setImageDrawable(MMApplicationContext.getContext().getResources().getDrawable(R.drawable.bxb));
                } else {
                    a.b.c(bnVar2.kc, str6);
                }
            } else {
                a(bvVar, parseXml);
            }
            if (Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.show_type"), 0) != 0) {
                bvVar.PRA.setVisibility(8);
                bvVar.PRp.setVisibility(8);
                bvVar.PRr.setVisibility(8);
                bvVar.PRq.setVisibility(0);
                bvVar.PRo.setVisibility(0);
                a(bvVar, caVar, parseXml);
            } else {
                bvVar.PRq.setVisibility(8);
                String str9 = parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.word");
                String str10 = parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.icon");
                boolean h2 = h(parseXml, 0);
                if (Util.isNullOrNil(str9) || h2) {
                    bvVar.PRs.setVisibility(8);
                } else {
                    bvVar.PRv.setTextColor(com.tencent.mm.ui.ao.hT(c(parseXml, ".msg.appmsg.mmreader.template_detail.opitems.opitem.color", this.PhN.getContext().getResources().getColor(R.color.a2x))));
                    bvVar.PRv.setText(str9);
                    if (Util.isNullOrNil(str10)) {
                        bvVar.PRx.setVisibility(8);
                        bvVar.PRv.setPadding(0, 0, 0, 0);
                    } else {
                        bvVar.PRx.setVisibility(0);
                        o(bvVar.PRx, str10);
                        bvVar.PRv.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix((Context) this.PhN.getContext(), 16), 0);
                    }
                    final String str11 = parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                    final String nullAsNil6 = Util.nullAsNil(parseXml.get(".msg.fromusername"));
                    int i9 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                    final String str12 = parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                    bq bqVar = new bq(caVar, nullAsNil6, str11);
                    bvVar.PRs.setTag(bqVar);
                    bvVar.PRA.setTag(bqVar);
                    if (i9 == 3 || i9 == 4) {
                        a(bvVar.PRs, caVar, parseXml, i9, 2);
                    } else if (i9 != 1 || TextUtils.isEmpty(str12)) {
                        bvVar.PRs.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass25 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(233855);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                if (!Util.isNullOrNil(str11)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", str11);
                                    intent.putExtra("geta8key_username", nullAsNil6);
                                    c.r(intent, ao.this.PhN.getTalkerUserName());
                                    com.tencent.mm.br.c.b(ao.this.PhN.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    h.INSTANCE.a(11608, ao.this.PMM, nullAsNil6, 1);
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$31", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(233855);
                            }
                        });
                        bvVar.PRA.setOnClickListener(null);
                    } else {
                        final String str13 = parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_path");
                        final int i10 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_version"), 0);
                        final int i11 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_state"), 0);
                        final String nullAsNil7 = Util.nullAsNil(parseXml.get(".msg.appmsg.template_id"));
                        AnonymousClass24 r8 = new View.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass24 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(169893);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                bq bqVar = (bq) view.getTag();
                                Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", str12);
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.dCw = bqVar.dTX.field_msgSvrId + ":" + bqVar.userName + ":" + ao.this.PhN.getTalkerUserName() + ":" + nullAsNil7;
                                if (((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(bqVar.userName)) {
                                    appBrandStatObject.scene = ao.aeQ(nullAsNil7);
                                    ((r) g.af(r.class)).a(ao.this.PhN.Pwc.getContext(), str12, (String) null, i11, i10, str13, appBrandStatObject);
                                } else {
                                    appBrandStatObject.scene = 1043;
                                    com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(bqVar.userName);
                                    ((r) g.af(r.class)).a(ao.this.PhN.Pwc.getContext(), str12, null, i11, i10, str13, appBrandStatObject, fJ == null ? null : fJ.field_appId);
                                }
                                ao.nj(ao.this.mAppId, ao.this.PMM);
                                h.INSTANCE.a(11608, ao.this.PMM, nullAsNil6, 1);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(169893);
                            }
                        };
                        bvVar.PRs.setOnClickListener(r8);
                        bvVar.PRA.setOnClickListener(r8);
                    }
                    bvVar.PRs.setVisibility(0);
                }
                String str14 = parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.word");
                String str15 = parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.icon");
                boolean h3 = h(parseXml, 1);
                if (Util.isNullOrNil(str14) || h3) {
                    bvVar.PRt.setVisibility(8);
                } else {
                    bvVar.PRw.setTextColor(com.tencent.mm.ui.ao.hT(c(parseXml, ".msg.appmsg.mmreader.template_detail.opitems.opitem1.color", this.PhN.getContext().getResources().getColor(R.color.a2x))));
                    bvVar.PRw.setText(str14);
                    if (Util.isNullOrNil(str15)) {
                        bvVar.PRy.setVisibility(8);
                        bvVar.PRw.setPadding(0, 0, 0, 0);
                    } else {
                        bvVar.PRy.setVisibility(0);
                        o(bvVar.PRy, str15);
                        bvVar.PRw.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix((Context) this.PhN.getContext(), 16), 0);
                    }
                    final String str16 = parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.url");
                    final String nullAsNil8 = Util.nullAsNil(parseXml.get(".msg.fromusername"));
                    int i12 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.op_type"), 0);
                    final String str17 = parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_username");
                    bvVar.PRt.setTag(new bq(caVar, nullAsNil8, str16));
                    if (i12 == 3 || i12 == 4) {
                        a(bvVar.PRt, caVar, parseXml, i12, 2);
                    } else if (i12 != 1 || TextUtils.isEmpty(str17)) {
                        bvVar.PRt.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass27 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(233857);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                if (!Util.isNullOrNil(str16)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", str16);
                                    c.r(intent, ao.this.PhN.getTalkerUserName());
                                    com.tencent.mm.br.c.b(ao.this.PhN.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    h.INSTANCE.a(11608, ao.this.PMM, nullAsNil8, 2);
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(233857);
                            }
                        });
                    } else {
                        final String str18 = parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_path");
                        final int i13 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_version"), 0);
                        final int i14 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem1.weapp_state"), 0);
                        final String nullAsNil9 = Util.nullAsNil(parseXml.get(".msg.appmsg.template_id"));
                        bvVar.PRt.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass26 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(233856);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                bq bqVar = (bq) view.getTag();
                                Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", str17);
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.dCw = bqVar.dTX.field_msgSvrId + ":" + bqVar.userName + ":" + ao.this.PhN.getTalkerUserName() + ":" + nullAsNil9;
                                if (((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(bqVar.userName)) {
                                    appBrandStatObject.scene = ao.aeQ(nullAsNil9);
                                    ((r) g.af(r.class)).a(ao.this.PhN.Pwc.getContext(), str17, (String) null, i14, i13, str18, appBrandStatObject);
                                } else {
                                    appBrandStatObject.scene = 1043;
                                    com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(bqVar.userName);
                                    ((r) g.af(r.class)).a(ao.this.PhN.Pwc.getContext(), str17, null, i14, i13, str18, appBrandStatObject, fJ == null ? null : fJ.field_appId);
                                }
                                ao.nj(ao.this.mAppId, ao.this.PMM);
                                h.INSTANCE.a(11608, ao.this.PMM, nullAsNil8, 2);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$32", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(233856);
                            }
                        });
                    }
                    bvVar.PRt.setVisibility(0);
                }
                bvVar.PRz.setVisibility(8);
                if (bvVar.PRs.getVisibility() == 8 && bvVar.PRt.getVisibility() == 8) {
                    bvVar.PRp.setVisibility(8);
                    bvVar.PRo.setVisibility(8);
                    bvVar.PRr.setVisibility(8);
                } else {
                    bvVar.PRr.setVisibility(0);
                    int dimensionPixelOffset = this.PhN.getResources().getDimensionPixelOffset(R.dimen.hs);
                    if (bvVar.PRs.getVisibility() == 0 && bvVar.PRt.getVisibility() == 0) {
                        bvVar.PRs.setGravity(17);
                        bvVar.PRt.setGravity(17);
                        bvVar.PRs.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                        bvVar.PRt.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                    } else if (bvVar.PRs.getVisibility() == 0) {
                        if (Util.isNullOrNil(str10)) {
                            bvVar.PRs.setGravity(19);
                            bvVar.PRs.setPadding(dimensionPixelOffset, 0, 0, 0);
                            bvVar.PRz.setVisibility(0);
                        } else {
                            bvVar.PRs.setGravity(17);
                            bvVar.PRs.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                        }
                    } else if (Util.isNullOrNil(str15)) {
                        bvVar.PRt.setGravity(19);
                        bvVar.PRt.setPadding(this.PhN.getResources().getDimensionPixelOffset(R.dimen.hs), 0, 0, 0);
                        bvVar.PRz.setVisibility(0);
                    } else {
                        bvVar.PRt.setGravity(17);
                        bvVar.PRt.setPadding(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
                    }
                    bvVar.PRp.setVisibility(0);
                    bvVar.PRo.setVisibility(0);
                }
                if (bvVar.PRs.getVisibility() == 0 && bvVar.PRt.getVisibility() == 0) {
                    bvVar.PRu.setVisibility(0);
                } else {
                    bvVar.PRu.setVisibility(8);
                }
                String nullAsNil10 = Util.nullAsNil(parseXml.get(".msg.fromusername"));
                int i15 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.op_type"), 0);
                final String str19 = parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.weapp_username");
                if (as.HF(nullAsNil10) || bvVar.PRs.getVisibility() == 8 || bvVar.PRt.getVisibility() != 8 || i15 != 1 || !as.HF(str19)) {
                    bvVar.PRA.setVisibility(8);
                } else {
                    WxaAttributes Xk4 = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(str19);
                    String str20 = Xk4 == null ? null : Xk4.field_brandIconURL;
                    String str21 = Xk4 == null ? str19 : Xk4.field_nickname;
                    com.tencent.mm.av.q.bcV().a(str20, bvVar.PRB, this.Oxy);
                    bvVar.PRC.setText(str21);
                    if (Xk4 == null) {
                        ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(str19, new q.a() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass28 */

                            @Override // com.tencent.mm.plugin.appbrand.service.q.a
                            public final void b(WxaAttributes wxaAttributes) {
                                AppMethodBeat.i(233859);
                                if (wxaAttributes == null) {
                                    AppMethodBeat.o(233859);
                                    return;
                                }
                                final String str = wxaAttributes.field_brandIconURL;
                                final String str2 = wxaAttributes.field_nickname;
                                MMHandlerThread.postToMainThread(new Runnable() {
                                    /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass28.AnonymousClass1 */

                                    public final void run() {
                                        AppMethodBeat.i(233858);
                                        com.tencent.mm.av.q.bcV().a(str, bvVar.PRB, ao.this.Oxy);
                                        bvVar.PRC.setText(TextUtils.isEmpty(str2) ? str19 : str2);
                                        AppMethodBeat.o(233858);
                                    }
                                });
                                AppMethodBeat.o(233859);
                            }
                        });
                    }
                    bvVar.PRA.setVisibility(0);
                    bvVar.PRp.setVisibility(8);
                }
            }
            final String nullAsNil11 = Util.nullAsNil(parseXml.get(".msg.fromusername"));
            String str22 = null;
            if (!Util.isNullOrNil(nullAsNil11)) {
                bg.aVF();
                str22 = com.tencent.mm.model.c.aSN().Kn(nullAsNil11).arI();
            }
            String str23 = parseXml.get(".msg.appmsg.mmreader.category.item.title");
            String str24 = parseXml.get(".msg.appmsg.mmreader.category.item.url");
            String str25 = parseXml.get(".msg.appmsg.mmreader.category.item.native_url");
            String str26 = parseXml.get(".msg.appmsg.template_id");
            String str27 = parseXml.get(".msg.appmsg.mmreader.category.item.weapp_username");
            int i16 = 0;
            if (i7 == 3 || i7 == 4) {
                bvVar.PQU.setTag(new bq(caVar, nullAsNil11));
                a(bvVar.PQU, caVar, parseXml, i7, 1);
                a(i7, parseXml, nullAsNil11);
                str2 = "";
                i16 = 3;
            } else if (i7 == 1 && !TextUtils.isEmpty(str27)) {
                bq bqVar2 = new bq(caVar, nullAsNil11, str24);
                bqVar2.position = i2;
                bvVar.PQU.setTag(bqVar2);
                bvVar.PQU.setOnClickListener(this.rID);
                str2 = Util.nullAs(str27, "");
                i16 = 2;
            } else if (i7 == -1 && ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(nullAsNil11)) {
                View view2 = bvVar.PQU;
                bq bno = new bq(caVar, false, i2, nullAsNil11, false, this.PhN.gOZ(), nullAsNil11, str22, str23).bno(str25);
                bno.pageUrl = parseXml.get(".msg.appmsg.mmreader.template_detail.opitems.opitem.url");
                view2.setTag(bno);
                bvVar.PQU.setOnClickListener(this.PMH);
                str2 = Util.nullAs(nullAsNil11, "");
                i16 = 2;
            } else if (i7 == 2) {
                bq bqVar3 = new bq(caVar, nullAsNil11, str24);
                bqVar3.position = i2;
                bvVar.PQU.setTag(bqVar3);
                bvVar.PQU.setOnClickListener(this.rID);
                str2 = "";
            } else {
                bvVar.PQU.setTag(new bq(caVar, false, i2, str24, false, this.PhN.gOZ(), nullAsNil11, str22, str23).bno(str25));
                bvVar.PQU.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass5 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(233828);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        t.p h2 = ao.this.h(ao.this.PhN);
                        if (h2 != null) {
                            h2.onClick(view);
                        }
                        ao.a(ao.this, 2, caVar.field_talker, nullAsNil11);
                        ao.a(ao.this, 8, nullAsNil11, 2, 0);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(233828);
                    }
                });
                if (!Util.isNullOrNil(str24)) {
                    str2 = Util.nullAs(str24, "");
                    i16 = 1;
                } else {
                    str2 = "";
                    i16 = 0;
                }
            }
            bvVar.PQU.setOnLongClickListener(c(this.PhN));
            bvVar.PQU.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            if (com.tencent.mm.n.h.aqK().aqz()) {
                boVar.PIb.setVisibility(0);
                c(this.PhN, boVar.PIb, new t.o(str26, caVar, str22));
            }
            String nullAsNil12 = Util.nullAsNil(parseXml.get(".msg.fromusername"));
            boolean HF = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(nullAsNil12);
            if (this.PMU && bvVar.PRb.getTag(R.id.fwr) != null) {
                Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app single talker chat");
                bvVar.PRc.setTag(R.id.fwr, caVar);
                bvVar.PRc.setOnClickListener(this.PMF);
                bvVar.PRc.setVisibility(0);
                bvVar.PRb.setVisibility(8);
                View view3 = bvVar.PRg;
                view3.setPadding(view3.getPaddingLeft(), view3.getPaddingTop(), view3.getPaddingRight(), 0);
            } else if (HF && "notifymessage".equals(caVar.ajO())) {
                Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by app brand");
                bvVar.PRc.setTag(null);
                bvVar.PRc.setVisibility(8);
            } else if (!ab.Jx(caVar.ajO()) || !com.tencent.mm.al.g.Nb(nullAsNil12) || !ch(parseXml)) {
                if (!(Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1)) {
                    Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
                } else if (bvVar.PQW.getVisibility() == 0) {
                    bvVar.PRb.setTag(caVar);
                    bvVar.PRb.setOnClickListener(this.PMG);
                    bvVar.PRb.setVisibility(0);
                    bvVar.PRc.setVisibility(8);
                } else if (bvVar.PRg.getVisibility() == 0) {
                    bvVar.PRc.setTag(caVar);
                    bvVar.PRc.setOnClickListener(this.PMG);
                    bvVar.PRc.setVisibility(0);
                    bvVar.PRb.setVisibility(8);
                }
                bvVar.PRb.setTag(null);
                bvVar.PRc.setTag(null);
                bvVar.PRb.setVisibility(8);
                bvVar.PRc.setVisibility(8);
            } else {
                Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew handled by biz subscribe msg");
                bvVar.PRc.setTag(null);
                bvVar.PRc.setVisibility(8);
            }
            this.PMR.jumpType = i16;
            a.b bVar4 = this.PMR;
            p.h(str2, "<set-?>");
            bVar4.jAv = str2;
            X(1, caVar.ajO(), nullAsNil11);
            boVar.PQv.PQU.setVisibility(0);
            AppMethodBeat.o(37242);
            return;
        }
        boVar.PQv.PQU.setVisibility(8);
        final String nullAsNil13 = Util.nullAsNil(parseXml.get(".msg.fromusername"));
        int i17 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.template_detail.template_ext.type"), 0);
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingOld extType=%d", Integer.valueOf(i17));
        if (i17 == 1) {
            String nullAsNil14 = Util.nullAsNil(parseXml.get(".msg.appmsg.mmreader.template_detail.template_ext.app.avatar_url"));
            a(boVar, l.b(this.PhN.getContext(), Util.nullAsNil(parseXml.get(".msg.appmsg.mmreader.template_detail.template_ext.app.display_name")), boVar.userTV.getTextSize()));
            boVar.avatarIV.setTag(null);
            boVar.avatarIV.setOnClickListener(null);
            com.tencent.mm.av.q.bcV().a(nullAsNil14, boVar.avatarIV, this.Oxy);
        } else {
            a(boVar, this.PhN, caVar, nullAsNil13);
            a(boVar.avatarIV, this.PhN, nullAsNil13, caVar, (String) null, parseXml);
            if (((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(nullAsNil13)) {
                boVar.PQu.PQx.setTag(new bq(caVar, nullAsNil13));
                boVar.PQu.PQx.setOnClickListener(this.PHr);
            } else {
                boVar.PQu.PQx.setTag(new bq(nullAsNil13, this.PhN.gRM() ? this.PhN.getTalkerUserName() : null));
                boVar.PQu.PQx.setOnClickListener(e(this.PhN));
            }
        }
        Log.d("MicroMsg.ChattingItemDyeingTemplate", "dyeing template talker(%s).", caVar.ajO());
        if ("notifymessage".equals(caVar.ajO()) || i17 == 1) {
            boVar.PQu.PQx.setVisibility(0);
            boVar.PQu.hbb.setTextSize(0, (float) com.tencent.mm.cb.a.aG(boVar.PQu.hbb.getContext(), R.dimen.is));
        } else {
            boVar.PQu.PQx.setVisibility(8);
            boVar.PQu.hbb.setTextSize(0, (float) com.tencent.mm.cb.a.aG(boVar.PQu.hbb.getContext(), R.dimen.f3058c));
        }
        boVar.PQu.puO.setVisibility(0);
        b ci = b.ci(parseXml);
        boVar.PQu.hbb.setText(ci.title);
        ap.a(boVar.PQu.PQA, parseXml);
        String str28 = null;
        if (!Util.isNullOrNil(nullAsNil13)) {
            bg.aVF();
            str28 = com.tencent.mm.model.c.aSN().Kn(nullAsNil13).arI();
        }
        boolean z5 = !Util.isNullOrNil(ci.url);
        int i18 = Util.getInt(parseXml.get(".msg.appmsg.mmreader.category.item.template_op_type"), 0);
        String str29 = parseXml.get(".msg.appmsg.mmreader.category.item.weapp_username");
        if (i18 != 1 || TextUtils.isEmpty(str29)) {
            if (((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(ci.url)) {
                ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(ci.url, -1, 2, new Object[0]);
            }
            boVar.PQu.puO.setTag(new bq(caVar, false, i2, ci.url, false, this.PhN.gOZ(), nullAsNil13, str28, ci.title).bno(ci.egX));
            if (this.PMU) {
                boVar.PQu.puO.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass4 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(233827);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        t.p h2 = ao.this.h(ao.this.PhN);
                        if (h2 != null) {
                            h2.onClick(view);
                        }
                        ao.a(ao.this, 8, nullAsNil13, 2, 0);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(233827);
                    }
                });
            } else {
                boVar.PQu.puO.setOnClickListener(h(this.PhN));
            }
        } else {
            bq bqVar4 = new bq(caVar, nullAsNil13, ci.url);
            bqVar4.position = i2;
            boVar.PQu.puO.setTag(bqVar4);
            boVar.PQu.puO.setOnClickListener(this.rID);
            z5 = true;
        }
        boVar.PQu.puO.setOnLongClickListener(c(this.PhN));
        boVar.PQu.puO.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) this.PhN.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
        if (!z5) {
            boVar.PQu.PQB.setVisibility(8);
            boVar.PQu.uCh.setVisibility(8);
        } else {
            boVar.PQu.PQB.setVisibility(0);
            boVar.PQu.uCh.setVisibility(0);
        }
        if (com.tencent.mm.n.h.aqK().aqz()) {
            boVar.PIb.setVisibility(0);
            c(this.PhN, boVar.PIb, new t.o(ci.ixM, caVar, str28));
        }
        a(boVar.PQu, parseXml, caVar);
        boVar.PQu.puO.setVisibility(0);
        AppMethodBeat.o(37242);
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
        AppMethodBeat.i(233871);
        bq bqVar = (bq) view.getTag();
        if (bqVar == null) {
            AppMethodBeat.o(233871);
            return false;
        }
        int i2 = bqVar.position;
        if (!this.PhN.gRN()) {
            mVar.a(i2, 100, view.getContext().getString(R.string.b06), R.raw.icons_filled_delete);
        }
        if (BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) {
            mVar.a(i2, 144, view.getContext().getString(R.string.f0_), R.raw.fix_tools_entry);
        }
        AppMethodBeat.o(233871);
        return true;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean gTX() {
        return this.PMN == 0;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean c(View view, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        AppMethodBeat.i(37244);
        switch (menuItem.getItemId()) {
            case 144:
                Intent intent = new Intent();
                intent.putExtra("Chat_Msg_Id", caVar.field_msgId);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", intent);
                break;
        }
        AppMethodBeat.o(37244);
        return false;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.ui.chatting.viewitems.c
    public final void a(c.a aVar, com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
        AppMethodBeat.i(37245);
        if (str == null || aVar.userTV == null) {
            AppMethodBeat.o(37245);
            return;
        }
        a(aVar, l.b(aVar2.Pwc.getContext(), ((f) aVar2.bh(f.class)).bmF(str), aVar.userTV.getTextSize()));
        AppMethodBeat.o(37245);
    }

    private void a(ImageView imageView, final com.tencent.mm.ui.chatting.e.a aVar, final String str, ca caVar, String str2, Map<String, String> map) {
        String str3;
        AppMethodBeat.i(233872);
        if (imageView == null) {
            AppMethodBeat.o(233872);
        } else if (ab.JE(str)) {
            imageView.setVisibility(8);
            AppMethodBeat.o(233872);
        } else {
            imageView.setVisibility(0);
            if (((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(str)) {
                com.tencent.mm.av.q.bcV().a(str2, imageView, this.Oxy);
                imageView.setTag(new bq(caVar, str));
                imageView.setOnClickListener(this.PHr);
            } else {
                a.b.d(imageView, str);
                if (aVar.gRM()) {
                    str3 = aVar.getTalkerUserName();
                } else {
                    str3 = null;
                }
                imageView.setTag(new bq(str, str3));
                if (Util.getBoolean(map.get(".msg.appmsg.mmreader.template_detail.template_ext.block"), false)) {
                    imageView.setOnClickListener(null);
                } else {
                    imageView.setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass3 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(233826);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            t.b e2 = ao.this.e(aVar);
                            if (e2 != null) {
                                e2.onClick(view);
                            }
                            ao.a(ao.this, 10, aVar.getTalkerUserName(), str);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(233826);
                        }
                    });
                }
            }
            imageView.setOnLongClickListener(f(aVar));
            imageView.setContentDescription(aa.getDisplayName(str) + aVar.Pwc.getContext().getString(R.string.a4u));
            AppMethodBeat.o(233872);
        }
    }

    private void X(int i2, String str, String str2) {
        AppMethodBeat.i(233873);
        if (!rL(this.PMQ)) {
            AppMethodBeat.o(233873);
        } else if (!ab.Jx(str)) {
            AppMethodBeat.o(233873);
        } else if (!com.tencent.mm.al.g.Nb(str2)) {
            AppMethodBeat.o(233873);
        } else {
            com.tencent.mm.msgsubscription.c.a.a(i2, this.PMR);
            AppMethodBeat.o(233873);
        }
    }

    private void a(View view, ca caVar, Map<String, String> map, int i2, int i3) {
        AppMethodBeat.i(233874);
        if (caVar == null) {
            AppMethodBeat.o(233874);
        } else if (!"notifymessage".equals(caVar.field_talker)) {
            AppMethodBeat.o(233874);
        } else {
            bq bqVar = (bq) view.getTag();
            String nullAsNil = Util.nullAsNil(map.get(".msg.appmsg.mmreader.category.item.general_string"));
            bqVar.opType = i2;
            bqVar.PQK = nullAsNil;
            Bundle bundle = new Bundle();
            bundle.putInt("click_area_type", i3);
            bqVar.CAJ = bundle;
            view.setTag(bqVar);
            view.setOnClickListener(this.PMI);
            AppMethodBeat.o(233874);
        }
    }

    private void a(bv bvVar, String str, String str2, Map<String, String> map, ca caVar, boolean z) {
        AppMethodBeat.i(37247);
        bvVar.PQY.setText(l.b(this.PhN.Pwc.getContext(), str2, bvVar.PQY.getTextSize()));
        com.tencent.mm.av.q.bcV().a(str, bvVar.PQX, this.Oxy);
        bvVar.PQX.setTag(null);
        bvVar.PQX.setOnClickListener(null);
        bvVar.PQW.setTag(null);
        bvVar.PQW.setOnClickListener(null);
        bvVar.PQW.setVisibility(0);
        String nullAsNil = Util.nullAsNil(map.get(".msg.appmsg.mmreader.template_header.weapp_username"));
        String nullAsNil2 = Util.nullAsNil(map.get(".msg.appmsg.mmreader.template_header.header_jump_url"));
        if (!Util.isNullOrNil(nullAsNil) || !Util.isNullOrNil(nullAsNil2)) {
            bvVar.PQW.setTag(new bq(caVar, Util.nullAsNil(map.get(".msg.fromusername"))));
            bvVar.PQW.setOnClickListener(this.PMK);
        } else {
            bvVar.PQW.setOnClickListener(null);
        }
        String nullAsNil3 = Util.nullAsNil(map.get(".msg.appmsg.mmreader.template_header.shortcut_icon_url"));
        if (!z || Util.isNullOrNil(nullAsNil3)) {
            ((View) bvVar.PRa.getParent()).setVisibility(8);
            AppMethodBeat.o(37247);
            return;
        }
        ((View) bvVar.PRa.getParent()).setVisibility(0);
        com.tencent.mm.av.q.bcV().a(nullAsNil3, bvVar.PRa, this.Oxy);
        AppMethodBeat.o(37247);
    }

    private void a(bp bpVar, Map<String, String> map, ca caVar) {
        AppMethodBeat.i(233875);
        if (!(Util.getInt(map.get(".msg.appmsg.mmreader.template_header.show_complaint_button"), 0) == 1)) {
            Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingMoreVNew showMoreV false");
            bpVar.PQy.setTag(null);
            bpVar.PQz.setTag(null);
            bpVar.PQy.setVisibility(8);
            bpVar.PQz.setVisibility(8);
            AppMethodBeat.o(233875);
        } else if (bpVar.PQx.getVisibility() == 0) {
            bpVar.PQy.setTag(caVar);
            bpVar.PQy.setOnClickListener(this.PMG);
            bpVar.PQy.setVisibility(0);
            bpVar.PQz.setVisibility(8);
            AppMethodBeat.o(233875);
        } else {
            bpVar.PQz.setTag(caVar);
            bpVar.PQz.setOnClickListener(this.PMG);
            bpVar.PQz.setVisibility(0);
            bpVar.PQy.setVisibility(8);
            AppMethodBeat.o(233875);
        }
    }

    private static boolean ch(Map<String, String> map) {
        AppMethodBeat.i(233876);
        boolean rL = rL(x(map));
        AppMethodBeat.o(233876);
        return rL;
    }

    private static boolean rL(int i2) {
        return i2 == 2 || i2 == 3;
    }

    private static int x(Map<String, String> map) {
        AppMethodBeat.i(233877);
        int bni = bni(map.get(".msg.appmsg.mmreader.template_detail.new_tmpl_type"));
        AppMethodBeat.o(233877);
        return bni;
    }

    private void a(final Map<String, String> map, final ca caVar, final String str, final bv bvVar, final boolean z) {
        AppMethodBeat.i(233878);
        e eVar = new e((Context) this.PhN.Pwc.getContext(), 1, true);
        if (z) {
            eVar.o(String.format(this.PhN.Pwc.getMMResources().getString(R.string.fhn), this.PMP), 17);
        } else {
            eVar.o(String.format(this.PhN.Pwc.getMMResources().getString(R.string.fhp), this.PMP), 17);
        }
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass9 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(233832);
                if (z) {
                    mVar.a(0, ao.this.PhN.Pwc.getMMResources().getColor(R.color.a5e), ao.this.PhN.Pwc.getMMResources().getString(R.string.fh0));
                    AppMethodBeat.o(233832);
                    return;
                }
                mVar.a(1, ao.this.PhN.Pwc.getMMResources().getColor(R.color.g7), ao.this.PhN.Pwc.getMMResources().getString(R.string.fhk));
                AppMethodBeat.o(233832);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass10 */
            final /* synthetic */ boolean PNc = true;

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(233833);
                switch (menuItem.getItemId()) {
                    case 0:
                        ao.a(ao.this, 8, caVar.field_talker, str);
                        ao.a(ao.this, map, true, this.PNc, bvVar, str, false);
                        AppMethodBeat.o(233833);
                        return;
                    case 1:
                        ao.a(ao.this, 9, caVar.field_talker, str);
                        ao.a(ao.this, map, false, this.PNc, bvVar, str, false);
                        break;
                }
                AppMethodBeat.o(233833);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(233878);
    }

    private void R(final boolean z, final String str) {
        String string;
        String string2;
        AppMethodBeat.i(233879);
        if (z) {
            string = this.PhN.Pwc.getContext().getString(R.string.fgu);
        } else {
            string = this.PhN.Pwc.getContext().getString(R.string.fhr);
        }
        if (z) {
            string2 = this.PhN.Pwc.getContext().getString(R.string.fgt);
        } else {
            string2 = this.PhN.Pwc.getContext().getString(R.string.fhq);
        }
        com.tencent.mm.ui.base.h.a((Context) this.PhN.Pwc.getContext(), string2, string, this.PhN.Pwc.getContext().getString(R.string.fht), this.PhN.Pwc.getContext().getString(R.string.sz), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass11 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(233839);
                Intent intent = new Intent(ao.this.PhN.Pwc.getContext(), BizSubscribeMsgManagerUI.class);
                intent.putExtra("key_biz_username", str);
                intent.putExtra("key_biz_nickname", aa.getDisplayName(str));
                if (z) {
                    intent.putExtra("key_biz_presenter_class", com.tencent.mm.msgsubscription.presenter.d.class.getName());
                } else {
                    intent.putExtra("key_biz_presenter_class", com.tencent.mm.al.b.a.class.getName());
                    intent.putExtra("key_need_update", false);
                    intent.putExtra("key_need_load_from_remote", true);
                    intent.putExtra("key_enter_scene", 2);
                }
                com.tencent.mm.br.c.a((MMFragmentActivity) ao.this.PhN.Pwc.getContext(), "com.tencent.mm.msgsubscription.ui.BizSubscribeMsgManagerUI", intent, z ? 100 : 101, new MMFragmentActivity.b() {
                    /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass11.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.MMFragmentActivity.b
                    public final void d(int i2, int i3, Intent intent) {
                        AppMethodBeat.i(233838);
                        if (i2 != 100 || intent == null) {
                            if (i2 == 101 && intent != null) {
                                boolean booleanExtra = intent.getBooleanExtra("key_need_update", false);
                                Log.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo back from SubscribeMsgManagerUI needUpdate: %b", Boolean.valueOf(booleanExtra));
                                if (!booleanExtra) {
                                    AppMethodBeat.o(233838);
                                    return;
                                }
                                ISubscribeMsgService.Companion.SubscribeMsgListWrapper subscribeMsgListWrapper = (ISubscribeMsgService.Companion.SubscribeMsgListWrapper) intent.getParcelableExtra("key_biz_data");
                                com.tencent.mm.msgsubscription.api.b bVar = com.tencent.mm.msgsubscription.api.b.jza;
                                com.tencent.mm.msgsubscription.b.a Ru = com.tencent.mm.msgsubscription.api.b.Ru("name_biz");
                                if (!(subscribeMsgListWrapper == null || Ru == null)) {
                                    ao.k(ao.this);
                                    com.tencent.mm.msgsubscription.api.c cVar = new com.tencent.mm.msgsubscription.api.c();
                                    cVar.setUsername(Util.nullAs(str, ""));
                                    cVar.jyV.addAll(subscribeMsgListWrapper.jyV);
                                    cVar.jzb = subscribeMsgListWrapper.jyW;
                                    cVar.jze = new com.tencent.mm.msgsubscription.api.a() {
                                        /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass11.AnonymousClass1.AnonymousClass2 */

                                        @Override // com.tencent.mm.msgsubscription.api.a
                                        public final void a(String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
                                            AppMethodBeat.i(233836);
                                            Log.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo updateSubscribeMsgList success");
                                            ao.l(ao.this);
                                            if (ao.this.PhN != null) {
                                                ao.this.PhN.cmy();
                                            }
                                            AppMethodBeat.o(233836);
                                        }

                                        @Override // com.tencent.mm.msgsubscription.api.a
                                        public final void i(int i2, int i3, String str) {
                                            AppMethodBeat.i(233837);
                                            Log.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo updateSubscribeMsgList onError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
                                            ao.l(ao.this);
                                            u.makeText(ao.this.PhN.Pwc.getContext(), ao.this.PhN.Pwc.getContext().getString(R.string.fhs), 1).show();
                                            AppMethodBeat.o(233837);
                                        }
                                    };
                                    Ru.a(cVar);
                                }
                            }
                            AppMethodBeat.o(233838);
                            return;
                        }
                        SubscribeMsgSettingData subscribeMsgSettingData = (SubscribeMsgSettingData) intent.getParcelableExtra("key_biz_data");
                        if (subscribeMsgSettingData != null) {
                            ao.k(ao.this);
                            com.tencent.mm.msgsubscription.util.c cVar2 = com.tencent.mm.msgsubscription.util.c.jDh;
                            com.tencent.mm.msgsubscription.util.c.a(str, subscribeMsgSettingData, new kotlin.g.a.b<SubscribeMsgRequestResult, x>() {
                                /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass11.AnonymousClass1.AnonymousClass1 */

                                /* Return type fixed from 'java.lang.Object' to match base method */
                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // kotlin.g.a.b
                                public final /* synthetic */ x invoke(SubscribeMsgRequestResult subscribeMsgRequestResult) {
                                    AppMethodBeat.i(233835);
                                    final SubscribeMsgRequestResult subscribeMsgRequestResult2 = subscribeMsgRequestResult;
                                    ao.l(ao.this);
                                    if (subscribeMsgRequestResult2 == null) {
                                        u.makeText(ao.this.PhN.Pwc.getContext(), ao.this.PhN.Pwc.getContext().getString(R.string.fhs), 1).show();
                                    } else {
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass11.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(233834);
                                                yw ywVar = new yw();
                                                ywVar.efe.dCl = str;
                                                ywVar.efe.action = !subscribeMsgRequestResult2.jyo ? 1 : 2;
                                                ywVar.efe.option = 1;
                                                EventCenter.instance.publish(ywVar);
                                                if (ao.this.PhN != null) {
                                                    ao.this.PhN.cmy();
                                                }
                                                AppMethodBeat.o(233834);
                                            }
                                        });
                                    }
                                    AppMethodBeat.o(233835);
                                    return null;
                                }
                            });
                        }
                        AppMethodBeat.o(233838);
                    }
                });
                AppMethodBeat.o(233839);
            }
        }, (DialogInterface.OnClickListener) null).setCanceledOnTouchOutside(false);
        AppMethodBeat.o(233879);
    }

    private static int bni(String str) {
        int i2;
        AppMethodBeat.i(37248);
        if (str == null) {
            str = "-1";
        }
        try {
            i2 = Integer.valueOf(str).intValue();
        } catch (NumberFormatException e2) {
            Log.e("MicroMsg.ChattingItemDyeingTemplate", e2.getMessage());
            i2 = -1;
        }
        int nullAsInt = Util.nullAsInt(Integer.valueOf(i2), -1);
        AppMethodBeat.o(37248);
        return nullAsInt;
    }

    private void a(final boolean z, final boolean z2, final ca caVar, final Map<String, String> map, final String str, final bv bvVar, final boolean z3) {
        String string;
        String string2;
        AppMethodBeat.i(233881);
        e eVar = new e((Context) this.PhN.Pwc.getContext(), 1, true);
        Resources resources = this.PhN.Pwc.getContext().getResources();
        if (z) {
            if (z2) {
                string2 = String.format(resources.getString(R.string.fhj), this.PMP);
            } else {
                string2 = resources.getString(R.string.fhi);
            }
            eVar.o(string2, 17);
        } else {
            if (z2) {
                string = String.format(resources.getString(R.string.fgy), this.PMP);
            } else {
                string = resources.getString(R.string.fgz);
            }
            eVar.o(string, 17);
        }
        eVar.HLX = new o.f() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass20 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                AppMethodBeat.i(233849);
                if (z) {
                    mVar.a(1, ao.this.PhN.Pwc.getMMResources().getColor(R.color.g7), ao.this.PhN.Pwc.getMMResources().getString(R.string.fhk));
                    AppMethodBeat.o(233849);
                    return;
                }
                mVar.a(0, ao.this.PhN.Pwc.getMMResources().getColor(R.color.a5e), ao.this.PhN.Pwc.getMMResources().getString(z2 ? R.string.fh0 : R.string.fh1));
                AppMethodBeat.o(233849);
            }
        };
        eVar.HLY = new o.g() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass21 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(233850);
                switch (menuItem.getItemId()) {
                    case 0:
                        ao.a(ao.this, 8, caVar.field_talker, str);
                        if (z2) {
                            ao.a(ao.this, map, true, z3, bvVar, str, true);
                            AppMethodBeat.o(233850);
                            return;
                        }
                        ao.a(ao.this, true, bvVar, str, caVar);
                        AppMethodBeat.o(233850);
                        return;
                    case 1:
                        ao.a(ao.this, 9, caVar.field_talker, str);
                        if (!z2) {
                            ao.a(ao.this, false, bvVar, str, caVar);
                            break;
                        } else {
                            ao.a(ao.this, map, false, z3, bvVar, str, true);
                            AppMethodBeat.o(233850);
                            return;
                        }
                }
                AppMethodBeat.o(233850);
            }
        };
        eVar.dGm();
        AppMethodBeat.o(233881);
    }

    private void a(bv bvVar, Map<String, String> map) {
        LinearLayout linearLayout;
        AppMethodBeat.i(37250);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= 100) {
                break;
            }
            String concat = i3 == 0 ? ".msg.appmsg.mmreader.template_detail.line_content.lines.line" : ".msg.appmsg.mmreader.template_detail.line_content.lines.line".concat(String.valueOf(i3));
            String str = map.get(concat + ".value.word");
            String str2 = map.get(concat + ".key.word");
            if (Util.isNullOrNil(str) && Util.isNullOrNil(str2)) {
                Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingLines: lines count=%d", Integer.valueOf(i3));
                break;
            }
            bs bsVar = new bs();
            bsVar.PQN = str;
            bsVar.PQM = Util.nullAsNil(str2);
            if (!com.tencent.mm.ui.ao.isDarkMode()) {
                bsVar.PQO = c(map, concat + ".key.wxcolors.wxcolor", c(map, concat + ".key.color", PMV));
                bsVar.PQP = c(map, concat + ".value.wxcolors.wxcolor", c(map, concat + ".value.color", this.PhN.Pwc.getContext().getResources().getColor(R.color.a2x)));
            } else {
                bsVar.PQO = c(map, concat + ".key.wxcolors.wxcolor1", c(map, concat + ".key.wxcolors.wxcolor", c(map, concat + ".key.color", PMV)));
                bsVar.PQP = c(map, concat + ".value.wxcolors.wxcolor1", c(map, concat + ".value.wxcolors.wxcolor", c(map, concat + ".value.color", this.PhN.Pwc.getContext().getResources().getColor(R.color.a2x))));
                bsVar.PQP = com.tencent.mm.ui.ao.hT(bsVar.PQP);
            }
            bsVar.PQQ = Util.getInt(map.get(new StringBuilder().append(concat).append(".key.hide").toString()), 0) != 0;
            int bnj = (bnj(bsVar.PQM) + 1) / 2;
            if (bnj <= i2) {
                bnj = i2;
            }
            arrayList.add(bsVar);
            i3++;
            i2 = bnj;
        }
        if (i2 > 8) {
            i2 = 8;
        }
        LinearLayout linearLayout2 = bvVar.PRn;
        linearLayout2.setVisibility(0);
        View findViewById = ((ViewGroup) bvVar.PRn.getParent()).findViewById(R.id.bk0);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        if (linearLayout2.getChildCount() > arrayList.size()) {
            if (arrayList.size() == 0) {
                linearLayout2.removeAllViews();
            } else {
                linearLayout2.removeViews(arrayList.size(), linearLayout2.getChildCount() - arrayList.size());
            }
        }
        StringBuilder sb = new StringBuilder();
        int childCount = linearLayout2.getChildCount();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            bs bsVar2 = (bs) arrayList.get(i4);
            if (i4 < childCount) {
                linearLayout = (LinearLayout) linearLayout2.getChildAt(i4);
            } else {
                linearLayout = (LinearLayout) LayoutInflater.from(this.PhN.Pwc.getContext()).inflate(R.layout.q6, (ViewGroup) null, false);
                bt btVar = new bt();
                btVar.PQR = (TextView) linearLayout.findViewById(R.id.ebx);
                btVar.PQS = (TextView) linearLayout.findViewById(R.id.ec4);
                linearLayout.setTag(btVar);
                linearLayout2.addView(linearLayout);
            }
            bt btVar2 = (bt) linearLayout.getTag();
            if (bsVar2.PQQ) {
                btVar2.PQR.setVisibility(8);
            } else {
                btVar2.PQR.setVisibility(0);
                btVar2.PQR.setEms(i2);
                btVar2.PQR.setTextColor(com.tencent.mm.ui.ao.hT(bsVar2.PQO));
                btVar2.PQR.setText(bsVar2.PQM);
            }
            btVar2.PQS.setTextColor(com.tencent.mm.ui.ao.hT(bsVar2.PQP));
            btVar2.PQS.setText(bsVar2.PQN);
            sb.append(Util.nullAs(bsVar2.PQM, "")).append(":").append(Util.nullAs(bsVar2.PQN, "")).append("\n");
        }
        a.b bVar = this.PMR;
        String sb2 = sb.toString();
        p.h(sb2, "<set-?>");
        bVar.dWG = sb2;
        if (linearLayout2.getChildCount() == 0) {
            bvVar.PRm.setVisibility(8);
            linearLayout2.setVisibility(8);
            AppMethodBeat.o(37250);
            return;
        }
        if (Util.getInt(map.get(".msg.appmsg.mmreader.template_detail.line_content.topline.key.hide_dash_line"), 0) != 0) {
            bvVar.PRm.setVisibility(8);
        } else {
            bvVar.PRm.setVisibility(0);
        }
        linearLayout2.setVisibility(0);
        AppMethodBeat.o(37250);
    }

    private void a(bv bvVar, ca caVar, final Map<String, String> map) {
        LinearLayout linearLayout;
        AppMethodBeat.i(37251);
        LinearLayout linearLayout2 = bvVar.PRq;
        int childCount = linearLayout2.getChildCount();
        int i2 = 0;
        while (true) {
            if (i2 >= 10) {
                break;
            }
            String concat = i2 == 0 ? ".msg.appmsg.mmreader.template_detail.opitems.opitem" : ".msg.appmsg.mmreader.template_detail.opitems.opitem".concat(String.valueOf(i2));
            String str = map.get(concat + ".word");
            String str2 = map.get(concat + ".hint_word");
            if (Util.isNullOrNil(str)) {
                Log.i("MicroMsg.ChattingItemDyeingTemplate", "fillingVerticalButtons: count=%d", Integer.valueOf(i2));
                int childCount2 = linearLayout2.getChildCount();
                if (childCount2 > i2) {
                    if (i2 == 0) {
                        linearLayout2.removeAllViews();
                        AppMethodBeat.o(37251);
                        return;
                    }
                    linearLayout2.removeViews(i2, childCount2 - i2);
                    AppMethodBeat.o(37251);
                    return;
                }
            } else {
                if (i2 < childCount) {
                    linearLayout = (LinearLayout) linearLayout2.getChildAt(i2);
                } else {
                    linearLayout = (LinearLayout) LayoutInflater.from(this.PhN.Pwc.getContext()).inflate(R.layout.q5, (ViewGroup) null, false);
                    a aVar = new a();
                    aVar.hbb = (TextView) linearLayout.findViewById(R.id.fwd);
                    aVar.kc = (ImageView) linearLayout.findViewById(R.id.fwc);
                    aVar.OFA = (LinearLayout) linearLayout.findViewById(R.id.fwa);
                    aVar.kbe = (TextView) linearLayout.findViewById(R.id.fwb);
                    linearLayout.setTag(aVar);
                    linearLayout2.addView(linearLayout);
                }
                if (h(map, i2)) {
                    linearLayout.setVisibility(8);
                } else {
                    linearLayout.setVisibility(0);
                    a aVar2 = (a) linearLayout.getTag();
                    String str3 = map.get(concat + ".icon");
                    aVar2.hbb.setTextColor(com.tencent.mm.ui.ao.hT(c(map, concat + ".color", this.PhN.Pwc.getContext().getResources().getColor(R.color.a2x))));
                    if (Util.getInt(map.get(concat + ".is_rich_text"), 0) == 0) {
                        aVar2.hbb.setSingleLine(true);
                        aVar2.hbb.setEllipsize(TextUtils.TruncateAt.END);
                        aVar2.hbb.setText(str);
                    } else {
                        int i3 = Util.getInt(map.get(concat + ".display_line_number"), 1);
                        Log.i("MicroMsg.ChattingItemDyeingTemplate", "show rich text: %s", Integer.valueOf(i3));
                        aVar2.hbb.setSingleLine(false);
                        aVar2.hbb.setText(str);
                        aVar2.hbb.setMaxLines(i3);
                        l.a(aVar2.hbb, false, (Object) null);
                    }
                    aVar2.kbe.setText(str2);
                    aVar2.kbe.setTextColor(this.PhN.Pwc.getContext().getResources().getColor(R.color.FG_1));
                    if (Util.isNullOrNil(str3)) {
                        aVar2.kc.setVisibility(8);
                        aVar2.hbb.setPadding(0, 0, 0, 0);
                    } else {
                        aVar2.kc.setVisibility(0);
                        o(aVar2.kc, str3);
                        aVar2.hbb.setPadding(0, 0, com.tencent.mm.cb.a.fromDPToPix((Context) this.PhN.Pwc.getContext(), 28), 0);
                    }
                    final String str4 = map.get(concat + ".url");
                    final String nullAsNil = Util.nullAsNil(map.get(".msg.fromusername"));
                    int i4 = Util.getInt(map.get(concat + ".op_type"), 0);
                    final String str5 = map.get(concat + ".weapp_username");
                    aVar2.OFA.setTag(new bq(caVar, nullAsNil, str4));
                    final int i5 = i2 + 1;
                    if (i4 == 3 || i4 == 4) {
                        a(aVar2.OFA, caVar, map, i4, 2);
                    } else if (i4 == 1 && !TextUtils.isEmpty(str5)) {
                        final String str6 = map.get(concat + ".weapp_path");
                        final int i6 = Util.getInt(map.get(concat + ".weapp_version"), 0);
                        final int i7 = Util.getInt(map.get(concat + ".weapp_state"), 0);
                        final String nullAsNil2 = Util.nullAsNil(map.get(".msg.appmsg.template_id"));
                        aVar2.OFA.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass29 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(233860);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                bq bqVar = (bq) view.getTag();
                                Log.i("MicroMsg.ChattingItemDyeingTemplate", "on app brand(%s) button1 click", str5);
                                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                                appBrandStatObject.dCw = bqVar.dTX.field_msgSvrId + ":" + bqVar.userName + ":" + ao.this.PhN.getTalkerUserName() + ":" + nullAsNil2;
                                if (((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(bqVar.userName)) {
                                    appBrandStatObject.scene = ao.aeQ(nullAsNil2);
                                    ((r) g.af(r.class)).a(ao.this.PhN.Pwc.getContext(), str5, (String) null, i7, i6, str6, appBrandStatObject);
                                } else {
                                    appBrandStatObject.scene = 1043;
                                    com.tencent.mm.api.c fJ = com.tencent.mm.al.g.fJ(bqVar.userName);
                                    ((r) g.af(r.class)).a(ao.this.PhN.Pwc.getContext(), str5, null, i7, i6, str6, appBrandStatObject, fJ == null ? null : fJ.field_appId);
                                }
                                ao.nj(ao.this.mAppId, ao.this.PMM);
                                h.INSTANCE.a(11608, ao.this.PMM, nullAsNil, Integer.valueOf(i5));
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$35", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(233860);
                            }
                        });
                    } else if (i4 == 2) {
                        aVar2.OFA.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass30 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(233861);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                if (i5 == 1) {
                                    String str = (String) map.get(".msg.appmsg.mmreader.category.item.schedule_username");
                                    long j2 = Util.getLong((String) map.get(".msg.appmsg.mmreader.category.item.schedule_messvrid"), -1);
                                    ao.g(view.getContext(), str, j2);
                                    h.INSTANCE.idkeyStat(795, 2, 1, false);
                                    Log.i("MicroMsg.ChattingItemDyeingTemplate", "[onClick] Remind! username:%s svrMsgId:%s", str, Long.valueOf(j2));
                                } else if (i5 == 2) {
                                    com.tencent.mm.br.c.f(view.getContext(), ".ui.AllRemindMsgUI", new Intent());
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(233861);
                            }
                        });
                    } else {
                        aVar2.OFA.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass31 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(233862);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                if (!Util.isNullOrNil(str4)) {
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", str4);
                                    c.r(intent, ao.this.PhN.getTalkerUserName());
                                    com.tencent.mm.br.c.b(ao.this.PhN.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    h.INSTANCE.a(11608, ao.this.PMM, nullAsNil, Integer.valueOf(i5));
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$37", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(233862);
                            }
                        });
                    }
                }
                i2++;
            }
        }
        AppMethodBeat.o(37251);
    }

    private static boolean h(Map<String, String> map, int i2) {
        AppMethodBeat.i(233882);
        String str = ".msg.appmsg.mmreader.template_detail.opitems.opitem" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".device_list.device";
        int i3 = 0;
        while (true) {
            String str2 = str + (i3 == 0 ? "" : Integer.valueOf(i3));
            if (!map.containsKey(str2)) {
                AppMethodBeat.o(233882);
                return false;
            } else if (Util.getInt(map.get(str2 + ".device_type"), 0) == 2) {
                int i4 = Util.getInt(map.get(str2 + ".device_op_type"), 0);
                int i5 = Util.getInt(map.get(str2 + ".device_client_version"), 0);
                Log.v("MicroMsg.ChattingItemDyeingTemplate", "checkButtonShouldHide opItemIndex: %s, deviceOpType: %s, deviceClientVersion: %x", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5));
                if (i4 != 1 || com.tencent.mm.protocal.d.KyO < i5) {
                    AppMethodBeat.o(233882);
                    return false;
                }
                AppMethodBeat.o(233882);
                return true;
            } else {
                int i6 = i3 + 1;
                if (i6 > 10) {
                    AppMethodBeat.o(233882);
                    return false;
                }
                i3 = i6;
            }
        }
    }

    private static void o(ImageView imageView, String str) {
        AppMethodBeat.i(37252);
        if (Util.isNullOrNil(str) || imageView == null) {
            AppMethodBeat.o(37252);
            return;
        }
        c.a aVar = new c.a();
        bg.aVF();
        aVar.prefixPath = com.tencent.mm.model.c.aSZ();
        aVar.jbf = true;
        aVar.hZF = true;
        com.tencent.mm.av.q.bcV().a(str, imageView, aVar.bdv());
        AppMethodBeat.o(37252);
    }

    private void a(bv bvVar, int i2) {
        AppMethodBeat.i(233883);
        if (this.PMU) {
            bvVar.PRe.setVisibility(i2);
            AppMethodBeat.o(233883);
            return;
        }
        bvVar.PQZ.setVisibility(i2);
        AppMethodBeat.o(233883);
    }

    private static void Y(int i2, String str, String str2) {
        AppMethodBeat.i(37253);
        Log.d("MicroMsg.ChattingItemDyeingTemplate", "stev report(%s), eventId : %d, appId %s, templateId %s", 13796, Integer.valueOf(i2), str, str2);
        h.INSTANCE.a(13796, Integer.valueOf(i2), str, str2, 0, Long.valueOf(Util.nowSecond()));
        AppMethodBeat.o(37253);
    }

    private static int c(Map<String, String> map, String str, int i2) {
        AppMethodBeat.i(37254);
        if (map == null || Util.isNullOrNil(str)) {
            AppMethodBeat.o(37254);
        } else {
            try {
                i2 = Color.parseColor(Util.nullAsNil(map.get(str)));
            } catch (Exception e2) {
            }
            AppMethodBeat.o(37254);
        }
        return i2;
    }

    private static int bnj(String str) {
        int i2 = 0;
        AppMethodBeat.i(37255);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(37255);
            return 0;
        }
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.substring(i3, i3 + 1).matches("[Α-￥]")) {
                i2 += 2;
            } else {
                i2++;
            }
        }
        AppMethodBeat.o(37255);
        return i2;
    }

    final class a implements View.OnClickListener {
        private a() {
        }

        /* synthetic */ a(ao aoVar, byte b2) {
            this();
        }

        public final void onClick(final View view) {
            AppMethodBeat.i(37238);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(view.getTag() instanceof ca)) {
                Log.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, tag not msg.");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37238);
                return;
            }
            final ca caVar = (ca) view.getTag();
            if (caVar == null) {
                Log.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, msg null.");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37238);
                return;
            }
            final Map<String, String> parseXml = XmlParser.parseXml(caVar.field_content, "msg", null);
            if (parseXml == null || parseXml.size() == 0) {
                Log.w("MicroMsg.ChattingItemDyeingTemplate", "BizMoreViewOnClickListener#onClick, values null.");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(37238);
                return;
            }
            final String nullAsNil = Util.nullAsNil(parseXml.get(".msg.fromusername"));
            e eVar = new e(view.getContext(), 1, false);
            eVar.HLX = new o.f() {
                /* class com.tencent.mm.ui.chatting.viewitems.ao.a.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    String string;
                    AppMethodBeat.i(37233);
                    if (((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(nullAsNil)) {
                        string = view.getResources().getString(R.string.fh9);
                    } else {
                        string = view.getResources().getString(R.string.fh7);
                    }
                    mVar.add(0, 2, 0, string);
                    AppMethodBeat.o(37233);
                }
            };
            eVar.HLY = new o.g() {
                /* class com.tencent.mm.ui.chatting.viewitems.ao.a.AnonymousClass2 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(37237);
                    Log.d("MicroMsg.ChattingItemDyeingTemplate", "on menu(id : %d, index : %d) item selected.", Integer.valueOf(menuItem.getItemId()), Integer.valueOf(i2));
                    switch (menuItem.getItemId()) {
                        case 2:
                            ao.a(ao.this, view, caVar, parseXml, nullAsNil);
                            break;
                    }
                    AppMethodBeat.o(37237);
                }
            };
            eVar.dGm();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$BizMoreViewOnClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(37238);
        }
    }

    private static void a(int i2, Map<String, String> map, String str) {
        long j2;
        AppMethodBeat.i(233884);
        if (i2 == 4) {
            try {
                j2 = d.Ga(new i(Util.nullAsNil(map.get(".msg.appmsg.mmreader.category.item.general_string"))).optString("live_id"));
            } catch (Exception e2) {
                Log.e("MicroMsg.ChattingItemDyeingTemplate", "opExtraInfo, liveId, crash: %s", e2.getMessage());
                j2 = 0;
            }
            if (com.tencent.mm.plugin.expt.hellhound.a.aow(com.tencent.mm.plugin.expt.hellhound.core.b.zs(j2))) {
                AppMethodBeat.o(233884);
                return;
            } else {
                com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                com.tencent.mm.plugin.finder.report.live.m.a(s.az.ExposeMsg, str, j2, "");
            }
        }
        AppMethodBeat.o(233884);
    }

    public static class b {
        public String egX;
        public String iAm;
        public String iAn;
        public String iAo;
        public String iAp;
        public String iAq;
        public String ixM;
        public long time;
        public String title;
        public int type;
        public String url;

        public static b ci(Map<String, String> map) {
            AppMethodBeat.i(37239);
            b bVar = new b();
            bVar.title = map.get(".msg.appmsg.mmreader.category.item.title");
            bVar.url = map.get(".msg.appmsg.mmreader.category.item.url");
            bVar.egX = map.get(".msg.appmsg.mmreader.category.item.native_url");
            bVar.iAm = map.get(".msg.appmsg.mmreader.category.item.shorturl");
            bVar.iAn = map.get(".msg.appmsg.mmreader.category.item.longurl");
            bVar.time = Util.getLong(map.get(".msg.appmsg.mmreader.category.item.pub_time"), 0);
            bVar.iAo = map.get(".msg.appmsg.mmreader.category.item.cover");
            bVar.iAp = map.get(".msg.appmsg.mmreader.category.item.tweetid");
            bVar.iAq = map.get(".msg.appmsg.mmreader.category.item.digest");
            bVar.type = Util.getInt(map.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
            bVar.ixM = map.get(".msg.appmsg.template_id");
            AppMethodBeat.o(37239);
            return bVar;
        }
    }

    private void a(final Map<String, String> map, final ca caVar, final bv bvVar, final ISubscribeMsgService.c cVar, final boolean z) {
        boolean z2;
        int i2;
        AppMethodBeat.i(233880);
        if (!cVar.jyX) {
            z2 = true;
        } else {
            z2 = false;
        }
        boolean z3 = cVar.jyY;
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo handleAppBrandMsgLogic isTmpBanned: %b, isNewTmpl: %b, templateId: %s, templateTitle: %s, isSwitchOpened: %b", Boolean.valueOf(z2), Boolean.valueOf(z), this.PMM, this.PMP, Boolean.valueOf(z3));
        LinearLayout linearLayout = bvVar.PRD;
        if (this.PMS) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        linearLayout.setVisibility(i2);
        if (z2 || (z && !z3)) {
            a(bvVar, 0);
            bvVar.PRE.setText(this.PhN.Pwc.getMMResources().getString(z ? R.string.fho : R.string.fhh));
        } else {
            a(bvVar, 8);
            bvVar.PRE.setText(this.PhN.Pwc.getMMResources().getString(z ? R.string.fhm : R.string.fgv));
        }
        bvVar.PRD.setTag(R.id.fw2, caVar);
        if (this.PMS) {
            bvVar.PRD.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass19 */

                public final void onClick(View view) {
                    AppMethodBeat.i(169890);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    ao.a(ao.this, caVar, map, true, z, cVar, bvVar);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(169890);
                }
            });
        }
        AppMethodBeat.o(233880);
    }

    static /* synthetic */ int aeQ(String str) {
        AppMethodBeat.i(233885);
        if (str == null || !str.startsWith("SUBSCRIPTION")) {
            AppMethodBeat.o(233885);
            return 1014;
        }
        AppMethodBeat.o(233885);
        return 1107;
    }

    static /* synthetic */ boolean a(ao aoVar, Map map) {
        AppMethodBeat.i(233886);
        boolean rL = rL(x(map));
        AppMethodBeat.o(233886);
        return rL;
    }

    static /* synthetic */ void a(ao aoVar, String str) {
        AppMethodBeat.i(233887);
        WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(str);
        if (Xk != null) {
            Y(1, Xk.field_appId, aoVar.PMM);
        }
        Intent intent = new Intent();
        intent.putExtra("key_username", str);
        intent.putExtra("key_from_scene", 5);
        if (Xk != null) {
            WxaExposedParams.a aVar = new WxaExposedParams.a();
            aVar.appId = Xk.field_appId;
            aVar.from = 6;
            intent.putExtra("key_scene_exposed_params", aVar.bAv());
        }
        com.tencent.mm.br.c.b(aoVar.PhN.Pwc.getContext(), "appbrand", ".ui.AppBrandProfileUI", intent);
        AppMethodBeat.o(233887);
    }

    static /* synthetic */ void a(ao aoVar, int i2, String str, int i3, int i4) {
        AppMethodBeat.i(233890);
        if (aoVar.PMU) {
            h.INSTANCE.a(21825, Integer.valueOf(i2), str, Long.valueOf(Util.nowSecond()), null, aoVar.PMM, Integer.valueOf(i3), Integer.valueOf(i4), 0);
        }
        AppMethodBeat.o(233890);
    }

    static /* synthetic */ void g(Context context, String str, long j2) {
        AppMethodBeat.i(233891);
        if (str == null) {
            Log.e("MicroMsg.ChattingItemDyeingTemplate", "[gotoChattingUIWithPosition] username is null");
            AppMethodBeat.o(233891);
            return;
        }
        bg.aVF();
        long j3 = com.tencent.mm.model.c.aSQ().aJ(str, j2).field_msgId;
        Log.i("MicroMsg.ChattingItemDyeingTemplate", "[gotoChattingUIWithPosition] msgLocalId:%s", Long.valueOf(j3));
        if (str.contains("@")) {
            bg.aVF();
            if (com.tencent.mm.model.c.aSX().Kd(str) == null) {
                Log.w("MicroMsg.ChattingItemDyeingTemplate", "[gotoChattingUIWithPosition] member is null! username:%s", str);
                com.tencent.mm.ui.base.h.d(context, context.getString(R.string.g1b), context.getString(R.string.hoz), null);
                AppMethodBeat.o(233891);
                return;
            }
        } else {
            bg.aVF();
            as Kn = com.tencent.mm.model.c.aSN().Kn(str);
            if (Kn == null || !com.tencent.mm.contact.c.oR(Kn.field_type)) {
                if (Kn == null) {
                    Log.w("MicroMsg.ChattingItemDyeingTemplate", "[gotoChattingUIWithPosition] contact is null! username:%s", str);
                } else {
                    Log.w("MicroMsg.ChattingItemDyeingTemplate", "[gotoChattingUIWithPosition] isContact not ! username:%s", str);
                }
                com.tencent.mm.ui.base.h.d(context, context.getString(R.string.g1b), context.getString(R.string.hoz), null);
                AppMethodBeat.o(233891);
                return;
            }
        }
        Intent putExtra = new Intent().putExtra("Chat_User", str).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", j3);
        putExtra.setClass(context, ChattingUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(putExtra);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate", "gotoChattingUIWithPosition", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate", "gotoChattingUIWithPosition", "(Landroid/content/Context;Ljava/lang/String;J)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(233891);
    }

    static /* synthetic */ void a(long j2, long j3, String str, int i2) {
        AppMethodBeat.i(233892);
        String str2 = s.j.COMMENT_SCENE_BOOK_NOTIFY.scene;
        com.tencent.mm.plugin.expt.hellhound.a.aox(str2);
        com.tencent.mm.plugin.finder.report.live.k.vkd.a(j2, j3, str, (long) i2, 0, s.p.LIVE_AUDIENCE_ENTER_LIVE_ROOM, str2);
        com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
        com.tencent.mm.plugin.finder.report.live.m.a(s.az.Click, str, j3, "");
        AppMethodBeat.o(233892);
    }

    static /* synthetic */ void a(ao aoVar, ca caVar, Map map, com.tencent.mm.ui.base.m mVar, ISubscribeMsgService.c cVar) {
        int i2;
        AppMethodBeat.i(233893);
        if ("notifymessage".equals(caVar.field_talker)) {
            String nullAsNil = Util.nullAsNil((String) map.get(".msg.fromusername"));
            boolean HF = ((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(nullAsNil);
            boolean Nb = com.tencent.mm.al.g.Nb(nullAsNil);
            if (HF || Nb) {
                boolean rL = rL(x(map));
                boolean z = cVar.jyX;
                boolean z2 = cVar.jyY;
                if (!z || (rL && !z2)) {
                    mVar.add(0, 1, 0, aoVar.PhN.Pwc.getContext().getResources().getString(rL ? R.string.fho : R.string.fhh));
                    AppMethodBeat.o(233893);
                    return;
                }
                Resources resources = aoVar.PhN.Pwc.getContext().getResources();
                if (rL) {
                    i2 = R.string.fhm;
                } else {
                    i2 = R.string.fgv;
                }
                mVar.add(0, 0, 0, resources.getString(i2));
            }
        }
        AppMethodBeat.o(233893);
    }

    static /* synthetic */ void a(ao aoVar, final View view, final ca caVar, final Map map, String str) {
        AppMethodBeat.i(233894);
        aoVar.X(5, caVar.field_talker, str);
        bg.azz().a(1198, new com.tencent.mm.ak.i() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass37 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                AppMethodBeat.i(233869);
                bg.azz().b(1198, this);
                Log.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.FALSE);
                if (ao.this.Fxt != null) {
                    ao.this.Fxt.dismiss();
                    ao.this.Fxt = null;
                }
                if (i2 != 0 || i3 != 0) {
                    u.makeText(view.getContext(), (int) R.string.fh8, 0).show();
                    AppMethodBeat.o(233869);
                } else if (caVar == view.getTag() || caVar == view.getTag(R.id.fwr)) {
                    fey aXR = ((com.tencent.mm.modelappbrand.s) qVar).aXR();
                    if (aXR == null) {
                        u.makeText(view.getContext(), (int) R.string.fh8, 0).show();
                        AppMethodBeat.o(233869);
                        return;
                    }
                    final String str2 = aXR.NAn;
                    String nullAsNil = Util.nullAsNil((String) map.get(".msg.fromusername"));
                    if (((com.tencent.mm.plugin.biz.a.a) g.af(com.tencent.mm.plugin.biz.a.a.class)).HF(nullAsNil)) {
                        ((com.tencent.mm.plugin.appbrand.service.q) g.af(com.tencent.mm.plugin.appbrand.service.q.class)).a(nullAsNil, new q.a() {
                            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass37.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.appbrand.service.q.a
                            public final void b(WxaAttributes wxaAttributes) {
                                AppMethodBeat.i(233868);
                                if (wxaAttributes == null) {
                                    u.makeText(view.getContext(), (int) R.string.fhd, 0).show();
                                    AppMethodBeat.o(233868);
                                    return;
                                }
                                String str = wxaAttributes.field_appId;
                                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                                    Log.i("MicroMsg.ChattingItemDyeingTemplate", "appId(%s) or msgId(%s) is null or nil.", str, str2);
                                    u.makeText(view.getContext(), (int) R.string.fhd, 0).show();
                                    AppMethodBeat.o(233868);
                                    return;
                                }
                                String n = ao.n(str, Util.getInt((String) map.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_state"), -1), Util.getInt((String) map.get(".msg.appmsg.mmreader.template_detail.template_ext.we_app_version"), -1), str2);
                                if (Util.isNullOrNil(n)) {
                                    Log.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                                    u.makeText(view.getContext(), (int) R.string.fhd, 0).show();
                                    AppMethodBeat.o(233868);
                                    return;
                                }
                                Log.d("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", str2, str, n);
                                Intent intent = new Intent();
                                intent.putExtra("rawUrl", n);
                                c.r(intent, ao.this.PhN.getTalkerUserName());
                                com.tencent.mm.br.c.b(ao.this.PhN.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                AppMethodBeat.o(233868);
                            }
                        });
                        AppMethodBeat.o(233869);
                        return;
                    }
                    Log.d("MicroMsg.ChattingItemDyeingTemplate", "more view clicked, menu item COMPLAIN_APP_BRAND selected, sync attr username %s", nullAsNil);
                    try {
                        String format = String.format(ao.PME, nullAsNil, URLEncoder.encode(ao.this.PMM, ProtocolPackage.ServerEncoding), URLEncoder.encode(str2, ProtocolPackage.ServerEncoding));
                        Log.i("MicroMsg.ChattingItemDyeingTemplate", "go to complain page(%s, %s), url:%s", str2, ao.this.PMM, format);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", format);
                        c.r(intent, ao.this.PhN.getTalkerUserName());
                        com.tencent.mm.br.c.b(ao.this.PhN.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                        AppMethodBeat.o(233869);
                    } catch (UnsupportedEncodingException e2) {
                        Log.e("MicroMsg.ChattingItemDyeingTemplate", "Error occurred when encode url.");
                        u.makeText(view.getContext(), (int) R.string.fhd, 0).show();
                        AppMethodBeat.o(233869);
                    }
                } else {
                    Log.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", Long.valueOf(caVar.field_msgId));
                    AppMethodBeat.o(233869);
                }
            }
        });
        final com.tencent.mm.modelappbrand.s sVar = new com.tencent.mm.modelappbrand.s(caVar.field_content);
        Context context = view.getContext();
        view.getResources().getString(R.string.zb);
        aoVar.Fxt = com.tencent.mm.ui.base.h.a(context, view.getResources().getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(233825);
                bg.azz().a(sVar);
                AppMethodBeat.o(233825);
            }
        });
        bg.azz().a(sVar, 0);
        AppMethodBeat.o(233894);
    }

    static /* synthetic */ void a(ao aoVar, ca caVar, Map map, boolean z, boolean z2, ISubscribeMsgService.c cVar, bv bvVar) {
        boolean z3;
        int i2;
        AppMethodBeat.i(233895);
        if (!cVar.jyX) {
            z3 = true;
        } else {
            z3 = false;
        }
        boolean z4 = cVar.jyY;
        String nullAsNil = Util.nullAsNil((String) map.get(".msg.fromusername"));
        if (z2) {
            if (z3 || !z4) {
                aoVar.X(7, caVar.field_talker, nullAsNil);
                if (!z4) {
                    i2 = 2;
                    aoVar.R(z, nullAsNil);
                } else if (z) {
                    aoVar.a(true, true, caVar, (Map<String, String>) map, nullAsNil, bvVar, true);
                    i2 = 1;
                } else {
                    aoVar.a((Map<String, String>) map, caVar, nullAsNil, bvVar, false);
                    i2 = 1;
                }
            } else {
                aoVar.X(6, caVar.field_talker, nullAsNil);
                if (z) {
                    aoVar.a(false, true, caVar, (Map<String, String>) map, nullAsNil, bvVar, true);
                    i2 = 1;
                } else {
                    aoVar.a((Map<String, String>) map, caVar, nullAsNil, bvVar, true);
                    i2 = 1;
                }
            }
            com.tencent.mm.msgsubscription.c.a aVar = com.tencent.mm.msgsubscription.c.a.jAr;
            com.tencent.mm.msgsubscription.c.a.a(nullAsNil, i2, aoVar.PMM, z3 ? 0 : 1, aoVar.PMP);
            AppMethodBeat.o(233895);
            return;
        }
        if (z) {
            if (!z3) {
                aoVar.X(6, caVar.field_talker, nullAsNil);
                aoVar.a(false, false, caVar, (Map<String, String>) map, nullAsNil, bvVar, z4);
                AppMethodBeat.o(233895);
                return;
            }
            aoVar.X(7, caVar.field_talker, nullAsNil);
            aoVar.R(true, nullAsNil);
        }
        AppMethodBeat.o(233895);
    }

    static /* synthetic */ String n(String str, int i2, int i3, String str2) {
        AppMethodBeat.i(233896);
        WxaExposedParams.a aVar = new WxaExposedParams.a();
        aVar.appId = str;
        aVar.from = 1;
        aVar.kNW = i2;
        aVar.pkgVersion = i3;
        aVar.msgId = str2;
        String a2 = w.a(aVar.bAv());
        AppMethodBeat.o(233896);
        return a2;
    }

    static /* synthetic */ void a(ao aoVar, final Map map, final ca caVar, final bv bvVar, final ISubscribeMsgService.c cVar) {
        AppMethodBeat.i(233897);
        if (!cVar.jyX || !cVar.jyY) {
            aoVar.a(bvVar, 0);
            bvVar.PRE.setText(aoVar.PhN.Pwc.getMMResources().getString(R.string.fho));
        } else {
            aoVar.a(bvVar, 8);
            bvVar.PRE.setText(aoVar.PhN.Pwc.getMMResources().getString(R.string.fhm));
        }
        bvVar.PRD.setTag(R.id.fw2, caVar);
        if (aoVar.PMS) {
            bvVar.PRD.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass8 */

                public final void onClick(View view) {
                    AppMethodBeat.i(233831);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    ao.a(ao.this, caVar, map, false, true, cVar, bvVar);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemDyeingTemplate$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(233831);
                }
            });
        }
        AppMethodBeat.o(233897);
    }

    static /* synthetic */ void a(ao aoVar, Map map, boolean z, boolean z2, bv bvVar, String str, boolean z3) {
        int i2 = 0;
        AppMethodBeat.i(233898);
        aoVar.a(bvVar, z ? 0 : 8);
        int bni = bni((String) map.get(".msg.appmsg.mmreader.template_detail.new_tmpl_type"));
        String str2 = aoVar.PMM;
        if (!z) {
            i2 = 1;
        }
        (z3 ? aoVar.PMO : aoVar.jzW).a(str, new SubscribeMsgTmpItem(str2, bni, i2, z2), new ISubscribeMsgService.b() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass15 */

            @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b
            public final void a(String str, ISubscribeMsgService.c cVar) {
                AppMethodBeat.i(233842);
                Log.i("MicroMsg.ChattingItemDyeingTemplate", "alvinluo switchSubscribeStatus onFinish isSubscribed: %b, switchOpen: %b", Boolean.valueOf(cVar.jyX), Boolean.valueOf(cVar.jyY));
                AppMethodBeat.o(233842);
            }

            @Override // com.tencent.mm.msgsubscription.api.ISubscribeMsgService.b
            public final void onError() {
                AppMethodBeat.i(233843);
                Log.e("MicroMsg.ChattingItemDyeingTemplate", "alvinluo switchSubscribeStatus onError");
                if (ao.this.PhN != null) {
                    ao.this.PhN.cmy();
                }
                AppMethodBeat.o(233843);
            }
        });
        AppMethodBeat.o(233898);
    }

    static /* synthetic */ void k(ao aoVar) {
        AppMethodBeat.i(233899);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass13 */

            public final void run() {
                AppMethodBeat.i(233840);
                if (ao.this.gxX == null) {
                    ao aoVar = ao.this;
                    Activity context = ao.this.PhN.Pwc.getContext();
                    ao.this.PhN.Pwc.getContext().getString(R.string.zb);
                    aoVar.gxX = com.tencent.mm.ui.base.h.a((Context) context, 3, ao.this.PhN.Pwc.getContext().getString(R.string.fhe), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass13.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                }
                ao.this.gxX.show();
                AppMethodBeat.o(233840);
            }
        });
        AppMethodBeat.o(233899);
    }

    static /* synthetic */ void l(ao aoVar) {
        AppMethodBeat.i(233900);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass14 */

            public final void run() {
                AppMethodBeat.i(233841);
                if (ao.this.gxX != null && ao.this.gxX.isShowing()) {
                    ao.this.gxX.dismiss();
                }
                AppMethodBeat.o(233841);
            }
        });
        AppMethodBeat.o(233900);
    }

    static /* synthetic */ void a(ao aoVar, final boolean z, final bv bvVar, final String str, final ca caVar) {
        int i2;
        int i3;
        int i4 = 2;
        AppMethodBeat.i(233902);
        aoVar.a(bvVar, z ? 0 : 8);
        yw ywVar = new yw();
        ywVar.efe.dCl = str;
        yw.a aVar = ywVar.efe;
        if (z) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        aVar.action = i2;
        ywVar.efe.option = 1;
        EventCenter.instance.publish(ywVar);
        LinkedList linkedList = new LinkedList();
        eft eft = new eft();
        eft.NfM = str;
        if (z) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        eft.NfL = i3;
        eft.oUv = 1;
        linkedList.add(eft);
        if (!z) {
            i4 = 3;
        }
        Y(i4, aoVar.mAppId, aoVar.PMM);
        bg.azz().a(1176, new com.tencent.mm.ak.i() {
            /* class com.tencent.mm.ui.chatting.viewitems.ao.AnonymousClass22 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
                int i4;
                boolean z = true;
                AppMethodBeat.i(233851);
                bg.azz().b(1176, this);
                Log.d("MicroMsg.ChattingItemDyeingTemplate", "onSceneEnd(errType : %d, errCode : %d, errMsg : %s, toBan : %s)", Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.TRUE);
                if (caVar != bvVar.PRD.getTag(R.id.fw2)) {
                    Log.w("MicroMsg.ChattingItemDyeingTemplate", "item msg(%s) has changed.", Long.valueOf(caVar.field_msgId));
                    AppMethodBeat.o(233851);
                } else if (i2 == 0 && i3 == 0) {
                    if (ao.this.PMO != null) {
                        com.tencent.mm.msgsubscription.b.a aVar = ao.this.PMO;
                        String str2 = str;
                        if (z) {
                            z = false;
                        }
                        aVar.Z(str2, z);
                    }
                    AppMethodBeat.o(233851);
                } else {
                    ao.a(ao.this, bvVar, z ? 8 : 0);
                    u.makeText(ao.this.PhN.Pwc.getContext(), (int) R.string.fhd, 0).show();
                    yw ywVar = new yw();
                    ywVar.efe.dCl = str;
                    yw.a aVar2 = ywVar.efe;
                    if (z) {
                        i4 = 2;
                    } else {
                        i4 = 1;
                    }
                    aVar2.action = i4;
                    ywVar.efe.option = 1;
                    EventCenter.instance.publish(ywVar);
                    if (ao.this.PhN != null) {
                        ao.this.PhN.cmy();
                    }
                    AppMethodBeat.o(233851);
                }
            }
        });
        bg.azz().a(new com.tencent.mm.modelappbrand.q(linkedList), 0);
        if (aoVar.PhN != null) {
            aoVar.PhN.cmy();
        }
        AppMethodBeat.o(233902);
    }
}
