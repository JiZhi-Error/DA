package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ag.x;
import com.tencent.mm.aj.p;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.hb;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.b.a.it;
import com.tencent.mm.g.b.a.ol;
import com.tencent.mm.g.c.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.k;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.i.a.aq;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.sns.ad.g.o;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.ar;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.ak;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.axt;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.eep;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.e;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.UUID;
import org.xwalk.core.XWalkEnvironment;

public final class br {
    public View.OnClickListener EIc = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass1 */

        public final void onClick(View view) {
            String str;
            k tP;
            k tP2;
            String str2;
            byte[] aZm;
            ADInfo adInfo;
            int i2;
            AppMethodBeat.i(99724);
            b bVar = new b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - br.this.lastClickTime < 500) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99724);
                return;
            }
            br.this.lastClickTime = currentTimeMillis;
            if (view.getTag() instanceof s) {
                s sVar = (s) view.getTag();
                String str3 = null;
                TimeLineObject timeLineObject = sVar.EpO;
                SnsInfo aQm = aj.faO().aQm(sVar.dHp);
                if (br.this.Epj != null) {
                    br.this.Epj.fat().M(aQm);
                }
                if (timeLineObject.ContentObj.LoU == 18) {
                    br brVar = br.this;
                    Context context = br.this.context;
                    TimeLineObject timeLineObject2 = sVar.EpO;
                    o.a(o.b.AdUrl, o.a.EnterCompleteVideo, aj.faO().aQm(sVar.dHp), brVar.source);
                    Intent intent = new Intent();
                    cnb cnb = null;
                    if (timeLineObject2.ContentObj.LoV.size() > 0) {
                        cnb = timeLineObject2.ContentObj.LoV.get(0);
                    }
                    intent.putExtra("KFromTimeLine", false);
                    intent.putExtra("KStremVideoUrl", timeLineObject2.ContentObj.Url);
                    intent.putExtra("KSta_SourceType", 2);
                    intent.putExtra("KSta_Scene", o.b.AdUrl.value);
                    intent.putExtra("KSta_FromUserName", timeLineObject2.UserName);
                    intent.putExtra("KSta_SnSId", timeLineObject2.Id);
                    if (cnb == null) {
                        intent.putExtra("KMediaId", "fakeid_" + (cnb == null ? timeLineObject2.Id : cnb.Id));
                    } else {
                        intent.putExtra("KMediaId", cnb.Id);
                    }
                    eep eep = timeLineObject2.streamvideo;
                    if (eep != null) {
                        intent.putExtra("KMediaVideoTime", eep.iza);
                        intent.putExtra("StreamWording", eep.izc);
                        intent.putExtra("StremWebUrl", eep.izd);
                        intent.putExtra("KMediaTitle", eep.izb);
                        intent.putExtra("KStremVideoUrl", eep.iyZ);
                        intent.putExtra("KThumUrl", eep.ize);
                        intent.putExtra("KSta_StremVideoAduxInfo", eep.izf);
                        intent.putExtra("KSta_StremVideoPublishId", eep.izg);
                    }
                    intent.putExtra("KSta_SnsStatExtStr", timeLineObject2.statExtStr);
                    if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_ad_landing_page_new_stream_video, 0) > 0) {
                        c.b(context, "sns", ".ui.SnsAdStreamVideoPlayUI", intent);
                        Log.i("MicroMsg.TimeLineClickEvent", "use new stream video play UI");
                    } else {
                        c.b(context, "sns", ".ui.VideoAdPlayerUI", intent);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99724);
                    return;
                } else if (timeLineObject.webSearchInfo == null || Util.isNullOrNil(timeLineObject.webSearchInfo.IEy)) {
                    if (timeLineObject.ContentObj.LoU == 28) {
                        long aOw = r.aOw(timeLineObject.ContentObj.dME.objectId);
                        long j2 = timeLineObject.ContentObj.dME.localId;
                        if (!(aOw == 0 && j2 == 0)) {
                            Intent intent2 = new Intent();
                            intent2.putExtra("report_scene", 3);
                            intent2.putExtra("from_user", timeLineObject.UserName);
                            intent2.putExtra("feed_object_id", aOw);
                            intent2.putExtra("feed_object_nonceId", timeLineObject.ContentObj.dME.objectNonceId);
                            intent2.putExtra("business_type", 0);
                            intent2.putExtra("finder_user_name", timeLineObject.ContentObj.dME.username);
                            intent2.putExtra("key_from_user_name", timeLineObject.UserName);
                            intent2.putExtra("tab_type", 5);
                            intent2.putExtra("feed_local_id", j2);
                            intent2.putExtra("key_finder_teen_mode_check", true);
                            intent2.putExtra("key_finder_teen_mode_scene", 3);
                            intent2.putExtra("key_finder_teen_mode_user_name", timeLineObject.ContentObj.dME.nickname);
                            intent2.putExtra("key_finder_teen_mode_user_id", timeLineObject.ContentObj.dME.username);
                            if (aOw == 0 && j2 != 0) {
                                intent2.putExtra("key_posting_scene", true);
                            }
                            ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 25, intent2);
                            ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderShareFeedUI(br.this.context, intent2);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(99724);
                            return;
                        }
                    } else if (timeLineObject.ContentObj.LoU == 36) {
                        long aOw2 = r.aOw(timeLineObject.ContentObj.Lpd.objectId);
                        if (aOw2 != 0) {
                            Intent intent3 = new Intent();
                            intent3.putExtra("report_scene", 3);
                            intent3.putExtra("from_user", timeLineObject.UserName);
                            intent3.putExtra("feed_object_id", aOw2);
                            intent3.putExtra("feed_object_nonceId", timeLineObject.ContentObj.Lpd.objectNonceId);
                            intent3.putExtra("business_type", 1);
                            intent3.putExtra("key_from_user_name", timeLineObject.UserName);
                            intent3.putExtra("tab_type", 5);
                            ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 53, intent3);
                            ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderShareFeedUI(br.this.context, intent3);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(99724);
                            return;
                        }
                    }
                    if (timeLineObject.ContentObj.LoU == 34 || timeLineObject.ContentObj.LoU == 43) {
                        long aOw3 = r.aOw(timeLineObject.ContentObj.Lpc.hJs);
                        long aOw4 = r.aOw(timeLineObject.ContentObj.Lpc.feedId);
                        if (!(aOw3 == 0 || aOw4 == 0)) {
                            if (Util.isEqual(z.aUg(), timeLineObject.ContentObj.Lpc.username)) {
                                ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderLiveAnchorUI(br.this.context, aOw4, Long.valueOf(aOw3), timeLineObject.ContentObj.Lpc.objectNonceId, timeLineObject.ContentObj.Lpc.desc, "", "", "");
                            } else {
                                ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderLiveVisitorUI(br.this.context, aOw4, Long.valueOf(aOw3), timeLineObject.ContentObj.Lpc.username, timeLineObject.ContentObj.Lpc.objectNonceId, timeLineObject.ContentObj.Lpc.desc, "", "", "", 0);
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(99724);
                            return;
                        }
                    }
                    if (timeLineObject.ContentObj.LoU == 29 && timeLineObject.ContentObj.LoZ != null) {
                        Intent intent4 = new Intent();
                        intent4.putExtra("key_topic_title", timeLineObject.ContentObj.LoZ.dST);
                        intent4.putExtra("key_topic_type", timeLineObject.ContentObj.LoZ.tvC);
                        axt axt = new axt();
                        axt.LIb = timeLineObject.ContentObj.LoZ.LLB.LIb;
                        axt.dTj = timeLineObject.ContentObj.LoZ.LLB.dTj;
                        axt.latitude = timeLineObject.ContentObj.LoZ.LLB.latitude;
                        try {
                            intent4.putExtra("key_topic_poi_location", axt.toByteArray());
                        } catch (IOException e2) {
                            Log.e("MicroMsg.TimeLineClickEvent", "location toByteArray exception");
                        }
                        intent4.putExtra("key_from_user", timeLineObject.UserName);
                        intent4.putExtra("key_report_scene", 3);
                        intent4.putExtra("KEY_TAB_TYPE", 5);
                        UUID.randomUUID();
                        intent4.putExtra("key_finder_teen_mode_check", true);
                        intent4.putExtra("key_finder_teen_mode_scene", 3);
                        intent4.putExtra("key_finder_teen_mode_user_name", "");
                        intent4.putExtra("key_finder_teen_mode_user_id", "");
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, timeLineObject.ContentObj.LoZ.tvC == 1 ? 22 : 26, intent4);
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderTopicUI(br.this.context, intent4);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(99724);
                        return;
                    } else if (timeLineObject.ContentObj.LoU == 37 && timeLineObject.ContentObj.LoZ != null) {
                        Intent intent5 = new Intent();
                        intent5.putExtra("key_topic_title", timeLineObject.ContentObj.LoZ.dST);
                        intent5.putExtra("KEY_FOLLOW_ID", timeLineObject.ContentObj.LoZ.LLC);
                        intent5.putExtra("key_topic_type", timeLineObject.ContentObj.LoZ.tvC);
                        axt axt2 = new axt();
                        axt2.LIb = timeLineObject.ContentObj.LoZ.LLB.LIb;
                        axt2.dTj = timeLineObject.ContentObj.LoZ.LLB.dTj;
                        axt2.latitude = timeLineObject.ContentObj.LoZ.LLB.latitude;
                        try {
                            intent5.putExtra("key_topic_poi_location", axt2.toByteArray());
                        } catch (IOException e3) {
                            Log.e("MicroMsg.TimeLineClickEvent", "location toByteArray exception");
                        }
                        intent5.putExtra("key_from_user", timeLineObject.UserName);
                        intent5.putExtra("key_report_scene", 3);
                        intent5.putExtra("KEY_TAB_TYPE", 5);
                        UUID.randomUUID();
                        switch (timeLineObject.ContentObj.LoZ.tvC) {
                            case 1:
                                i2 = 22;
                                break;
                            case 2:
                                i2 = 26;
                                break;
                            case 3:
                            default:
                                i2 = 22;
                                break;
                            case 4:
                                i2 = 49;
                                break;
                        }
                        intent5.putExtra("key_finder_teen_mode_scene", 3);
                        intent5.putExtra("key_finder_teen_mode_check", true);
                        intent5.putExtra("key_finder_teen_mode_user_name", "");
                        intent5.putExtra("key_finder_teen_mode_user_id", "");
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, i2, intent5);
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderTopicUI(br.this.context, intent5);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(99724);
                        return;
                    } else if (timeLineObject.ContentObj.LoU != 38 || timeLineObject.ContentObj.Lpb == null) {
                        if (timeLineObject.ContentObj.LoU == 39) {
                            switch (timeLineObject.ContentObj.izD) {
                                case 3:
                                    Intent intent6 = new Intent();
                                    intent6.putExtra("key_topic_title", timeLineObject.ContentObj.Lpe.dST);
                                    intent6.putExtra("key_topic_type", timeLineObject.ContentObj.Lpe.tvC);
                                    axt axt3 = new axt();
                                    axt3.LIb = timeLineObject.ContentObj.Lpe.LLB.LIb;
                                    axt3.dTj = timeLineObject.ContentObj.Lpe.LLB.dTj;
                                    axt3.latitude = timeLineObject.ContentObj.Lpe.LLB.latitude;
                                    try {
                                        intent6.putExtra("key_topic_poi_location", axt3.toByteArray());
                                    } catch (IOException e4) {
                                        Log.e("MicroMsg.TimeLineClickEvent", "location toByteArray exception");
                                    }
                                    intent6.putExtra("key_finder_teen_mode_check", true);
                                    intent6.putExtra("key_from_user", timeLineObject.UserName);
                                    intent6.putExtra("key_report_scene", 3);
                                    intent6.putExtra("KEY_TAB_TYPE", 5);
                                    UUID.randomUUID();
                                    aoi aoi = timeLineObject.ContentObj.Lpe.LLD;
                                    intent6.putExtra("key_activity_id", d.Ga(aoi.LAp));
                                    intent6.putExtra("key_activity_name", aoi.LAq);
                                    intent6.putExtra("key_nick_name", aoi.LAr);
                                    intent6.putExtra("key_cover_url", timeLineObject.ContentObj.Lpe.iconUrl);
                                    ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 59, intent6);
                                    ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderActivityProfileUI(br.this.context, intent6);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(99724);
                                    return;
                                case XWalkEnvironment.TEST_APK_START_VERSION /*{ENCODED_INT: 100000000}*/:
                                    if (timeLineObject.ContentObj.LoZ != null) {
                                        Intent intent7 = new Intent();
                                        intent7.putExtra("key_topic_title", timeLineObject.ContentObj.LoZ.dST);
                                        intent7.putExtra("key_topic_type", timeLineObject.ContentObj.LoZ.tvC);
                                        axt axt4 = new axt();
                                        axt4.LIb = timeLineObject.ContentObj.LoZ.LLB.LIb;
                                        axt4.dTj = timeLineObject.ContentObj.LoZ.LLB.dTj;
                                        axt4.latitude = timeLineObject.ContentObj.LoZ.LLB.latitude;
                                        try {
                                            intent7.putExtra("key_topic_poi_location", axt4.toByteArray());
                                        } catch (IOException e5) {
                                            Log.e("MicroMsg.TimeLineClickEvent", "location toByteArray exception");
                                        }
                                        intent7.putExtra("key_from_user", timeLineObject.UserName);
                                        intent7.putExtra("key_report_scene", 3);
                                        intent7.putExtra("KEY_TAB_TYPE", 5);
                                        UUID.randomUUID();
                                        intent7.putExtra("key_finder_teen_mode_check", true);
                                        intent7.putExtra("key_finder_teen_mode_scene", 3);
                                        intent7.putExtra("key_finder_teen_mode_user_name", "");
                                        intent7.putExtra("key_finder_teen_mode_user_id", "");
                                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, timeLineObject.ContentObj.LoZ.tvC == 1 ? 22 : 26, intent7);
                                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderTopicUI(br.this.context, intent7);
                                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                        AppMethodBeat.o(99724);
                                        return;
                                    }
                                    Intent intent62 = new Intent();
                                    intent62.putExtra("key_topic_title", timeLineObject.ContentObj.Lpe.dST);
                                    intent62.putExtra("key_topic_type", timeLineObject.ContentObj.Lpe.tvC);
                                    axt axt32 = new axt();
                                    axt32.LIb = timeLineObject.ContentObj.Lpe.LLB.LIb;
                                    axt32.dTj = timeLineObject.ContentObj.Lpe.LLB.dTj;
                                    axt32.latitude = timeLineObject.ContentObj.Lpe.LLB.latitude;
                                    intent62.putExtra("key_topic_poi_location", axt32.toByteArray());
                                    intent62.putExtra("key_finder_teen_mode_check", true);
                                    intent62.putExtra("key_from_user", timeLineObject.UserName);
                                    intent62.putExtra("key_report_scene", 3);
                                    intent62.putExtra("KEY_TAB_TYPE", 5);
                                    UUID.randomUUID();
                                    aoi aoi2 = timeLineObject.ContentObj.Lpe.LLD;
                                    intent62.putExtra("key_activity_id", d.Ga(aoi2.LAp));
                                    intent62.putExtra("key_activity_name", aoi2.LAq);
                                    intent62.putExtra("key_nick_name", aoi2.LAr);
                                    intent62.putExtra("key_cover_url", timeLineObject.ContentObj.Lpe.iconUrl);
                                    ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 59, intent62);
                                    ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderActivityProfileUI(br.this.context, intent62);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(99724);
                                    return;
                            }
                        }
                        if (!TextUtils.isEmpty(timeLineObject.canvasInfo) && !i.aQg(timeLineObject.canvasInfo)) {
                            String aU = br.aU(timeLineObject.canvasInfo, f.COL_ADXML, ".adxml.adActionLink");
                            if (!TextUtils.isEmpty(aU)) {
                                str3 = br.aRg(aU);
                            }
                        }
                        if (TextUtils.isEmpty(str3)) {
                            str = br.aRg(timeLineObject.ContentObj.Url);
                        } else {
                            str = str3;
                        }
                        if (str == null || str.length() == 0) {
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(99724);
                            return;
                        }
                        int scene = br.this.Epj.getScene();
                        if (((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(str)) {
                            str = ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).d(str, 2, scene, (int) (System.currentTimeMillis() / 1000));
                        }
                        Intent intent8 = new Intent();
                        Bundle bundle = null;
                        if (timeLineObject != null) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putString("KSnsStrId", timeLineObject.Id);
                            bundle2.putString("KSnsLocalId", sVar.dHp);
                            bundle2.putBoolean("KFromTimeline", true);
                            if (timeLineObject.ContentObj != null && timeLineObject.ContentObj.LoV.size() > 0) {
                                bundle2.putString("K_sns_thumb_url", timeLineObject.ContentObj.LoV.get(0).Msz);
                                bundle2.putString("K_sns_raw_url", timeLineObject.ContentObj.Url);
                                Log.i("MicroMsg.TimeLineClickEvent", "put the thumb url %s redirectUrl %s", timeLineObject.ContentObj.LoV.get(0).Msz, timeLineObject.ContentObj.Url);
                            }
                            bundle = bundle2;
                        }
                        bundle.putString("key_snsad_statextstr", timeLineObject.statExtStr);
                        intent8.putExtra("rawUrl", str);
                        intent8.putExtra("shortUrl", str);
                        intent8.putExtra("useJs", true);
                        intent8.putExtra("type", -255);
                        if (timeLineObject.publicUserName != null) {
                            intent8.putExtra("srcUsername", timeLineObject.publicUserName);
                            intent8.putExtra("srcDisplayname", timeLineObject.sourceNickName);
                            Log.i("MicroMsg.TimeLineClickEvent", "urlRedirectListener tlObj.sourceNickName: " + timeLineObject.sourceNickName + " tlObj.publicUserName: " + timeLineObject.publicUserName);
                        }
                        intent8.putExtra("sns_local_id", sVar.dHp);
                        if (aQm != null) {
                            intent8.putExtra("KPublisherId", "sns_" + r.Jb(aQm.field_snsId));
                            intent8.putExtra("pre_username", aQm.field_userName);
                            intent8.putExtra("prePublishId", "sns_" + r.Jb(aQm.field_snsId));
                            intent8.putExtra("preUsername", aQm.field_userName);
                            intent8.putExtra("share_report_pre_msg_url", str);
                            intent8.putExtra("share_report_pre_msg_title", timeLineObject.ContentObj.Title);
                            intent8.putExtra("share_report_pre_msg_desc", timeLineObject.ContentObj.Desc);
                            if (timeLineObject.ContentObj.LoV != null && timeLineObject.ContentObj.LoV.size() > 0) {
                                intent8.putExtra("share_report_pre_msg_icon_url", timeLineObject.ContentObj.LoV.get(0).Msz);
                            }
                            intent8.putExtra("share_report_pre_msg_appid", "");
                            intent8.putExtra("share_report_from_scene", 1);
                        }
                        if (!(timeLineObject == null || timeLineObject.AppInfo == null)) {
                            intent8.putExtra("KAppId", timeLineObject.AppInfo.Id);
                        }
                        if (aQm != null && aQm.isAd()) {
                            if (br.this.source == 2) {
                                adInfo = aQm.getAtAdInfo();
                            } else {
                                adInfo = aQm.getAdInfo();
                            }
                            if (adInfo != null) {
                                intent8.putExtra("KsnsViewId", adInfo.viewId);
                            }
                        }
                        if (!(aQm == null || timeLineObject == null)) {
                            if (br.this.source == 0) {
                                tP = k.tO(718);
                            } else {
                                tP = k.tP(718);
                            }
                            tP.PH(r.v(aQm)).tR(aQm.field_type).fL(aQm.isAd()).PH(aQm.getUxinfo()).PH(timeLineObject.publicUserName).PH(timeLineObject.AppInfo == null ? "" : timeLineObject.AppInfo.Id).PH(timeLineObject.ContentObj.Url);
                            tP.bfK();
                            if (br.this.source == 0) {
                                tP2 = k.tO(743);
                            } else {
                                tP2 = k.tP(743);
                            }
                            k PH = tP2.PH(r.v(aQm)).tR(aQm.field_type).fL(aQm.isAd()).PH(aQm.getUxinfo()).PH(timeLineObject.publicUserName);
                            if (timeLineObject.AppInfo == null) {
                                str2 = "";
                            } else {
                                str2 = timeLineObject.AppInfo.Id;
                            }
                            PH.PH(str2).PH(timeLineObject.ContentObj.Url);
                            if (!(bundle == null || (aZm = tP2.aZm()) == null)) {
                                bundle.putByteArray("intent_key_StatisticsOplog", aZm);
                            }
                        }
                        if (bundle != null) {
                            intent8.putExtra("jsapiargs", bundle);
                        }
                        intent8.putExtra("geta8key_scene", 2);
                        intent8.putExtra("from_scence", 3);
                        if (!(timeLineObject.ContentObj.LoY == null || timeLineObject.ContentObj.LoY.iAb == -1)) {
                            intent8.putExtra(e.p.OzA, timeLineObject.ContentObj.LoY.iAb);
                        }
                        if (Util.isNullOrNil(timeLineObject.canvasInfo) || !i.aQg(timeLineObject.canvasInfo) || aQm == null) {
                            intent8.putExtra("key_enable_teen_mode_check", true);
                            intent8.putExtra("msgUsername", timeLineObject.UserName);
                            intent8.putExtra("serverMsgID", timeLineObject.Id);
                            intent8.addFlags(536870912);
                            int i3 = timeLineObject.ContentObj.LoY != null ? timeLineObject.ContentObj.LoY.iAb : -1;
                            if (timeLineObject.ContentObj.LoY != null && i3 == 5 && timeLineObject.ContentObj.LoY.iwe == 1 && ((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()) {
                                x xVar = new x();
                                xVar.iAh = intent8.getStringExtra("KPublisherId");
                                xVar.dHp = intent8.getStringExtra("sns_local_id");
                                xVar.dHc = intent8.getStringExtra("srcUsername");
                                xVar.iAg = intent8.getStringExtra("srcDisplayname");
                                xVar.iAi.url = intent8.getStringExtra("rawUrl");
                                xVar.iAi.title = timeLineObject.ContentObj.Title;
                                xVar.iAi.iAq = timeLineObject.ContentObj.LoY.desc;
                                if (!Util.isNullOrNil(timeLineObject.ContentObj.LoY.coverUrl)) {
                                    xVar.iAi.iAo = timeLineObject.ContentObj.LoY.coverUrl;
                                } else {
                                    xVar.iAi.iAo = intent8.getStringExtra("share_report_pre_msg_icon_url");
                                }
                                xVar.iAi.type = i3;
                                xVar.iAi.time = (long) timeLineObject.ContentObj.LoY.iwd;
                                xVar.iAi.iAs = timeLineObject.ContentObj.LoY.duration;
                                xVar.iAi.videoWidth = timeLineObject.ContentObj.LoY.videoWidth;
                                xVar.iAi.videoHeight = timeLineObject.ContentObj.LoY.videoHeight;
                                xVar.iAi.vid = timeLineObject.ContentObj.LoY.vid;
                                xVar.iwg = timeLineObject.ContentObj.LoY.iwg;
                                xVar.t(intent8);
                                intent8.putExtra(e.b.OyQ, 2);
                                intent8.putExtra(e.b.OyR, scene);
                                int[] iArr = new int[2];
                                View findViewById = view.findViewById(R.id.dw4);
                                if (findViewById != null) {
                                    int width = findViewById.getWidth();
                                    int height = findViewById.getHeight();
                                    findViewById.getLocationInWindow(iArr);
                                    intent8.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                                }
                            }
                            if (!((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(4) || !((com.tencent.mm.plugin.brandservice.a.b) g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(br.this.context, str, i3, 2, scene, intent8)) {
                                com.tencent.mm.plugin.sns.c.a.jRt.i(intent8, br.this.context);
                            } else {
                                Log.i("MicroMsg.TimeLineClickEvent", "jump to TmplWebview");
                            }
                            String str4 = null;
                            int i4 = 0;
                            if (!(timeLineObject == null || timeLineObject.AppInfo == null)) {
                                str4 = timeLineObject.AppInfo.Id;
                                i4 = Util.getInt(timeLineObject.AppInfo.Version, 0);
                            }
                            String w = com.tencent.mm.plugin.sns.c.a.jRu.w(str4, i4);
                            if (!Util.isNullOrNil(w)) {
                                String str5 = null;
                                if (!(timeLineObject == null || timeLineObject.actionInfo == null || timeLineObject.actionInfo.KEw == null)) {
                                    str5 = timeLineObject.actionInfo.KEw.KEq;
                                }
                                com.tencent.mm.plugin.sns.c.a.jRu.a(br.this.context, str4, w, timeLineObject == null ? null : timeLineObject.UserName, 5, 4, 1, str5, timeLineObject.Id);
                            }
                            h.INSTANCE.a(11105, timeLineObject.UserName, timeLineObject.ContentObj.Url);
                            if (aQm != null && (aQm.field_type == 4 || aQm.field_type == 42)) {
                                cnb cnb2 = timeLineObject.ContentObj.LoV.get(0);
                                h hVar = h.INSTANCE;
                                Object[] objArr = new Object[3];
                                objArr[0] = 1;
                                objArr[1] = cnb2 == null ? "" : cnb2.Desc;
                                objArr[2] = timeLineObject.AppInfo.Id;
                                hVar.a(13043, objArr);
                            }
                        } else {
                            int[] iArr2 = new int[2];
                            if (view != null) {
                                view.getLocationInWindow(iArr2);
                            }
                            int width2 = view.getWidth();
                            int height2 = view.getHeight();
                            Intent intent9 = new Intent();
                            intent9.putExtra("img_gallery_left", iArr2[0]);
                            intent9.putExtra("img_gallery_top", iArr2[1]);
                            intent9.putExtra("img_gallery_width", width2);
                            intent9.putExtra("img_gallery_height", height2);
                            if (timeLineObject != null) {
                                LinkedList<cnb> linkedList = timeLineObject.ContentObj.LoV;
                                if (linkedList.size() > 0) {
                                    intent9.putExtra("sns_landing_pages_share_thumb_url", linkedList.get(0).Msz);
                                }
                            }
                            intent9.putExtra("sns_landing_pages_share_sns_id", aQm.getSnsId());
                            intent9.putExtra("sns_landing_pages_rawSnsId", aQm.getTimeLine().Id);
                            intent9.putExtra("sns_landing_pages_aid", aQm.getAid());
                            intent9.putExtra("sns_landing_pages_traceid", aQm.getTraceid());
                            intent9.putExtra("sns_landing_pages_ux_info", aQm.getUxinfo());
                            intent9.putExtra("sns_landig_pages_from_source", br.this.source == 0 ? 3 : 4);
                            intent9.setClass(br.this.context, SnsAdNativeLandingPagesUI.class);
                            intent9.putExtra("sns_landing_pages_xml", timeLineObject.canvasInfo);
                            intent9.putExtra("sns_landing_pages_rec_src", aQm.getAdRecSrc());
                            intent9.putExtra("sns_landing_pages_xml_prefix", f.COL_ADXML);
                            i.y(intent9, br.this.context);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(99724);
                            return;
                        }
                    } else {
                        bcf bcf = timeLineObject.ContentObj.Lpb;
                        Intent intent10 = new Intent();
                        intent10.putExtra("TITLE_WORDING", bcf.title);
                        intent10.putExtra("AUTO_REFRESH", true);
                        try {
                            intent10.putExtra("FINDER_SHARE_ALBUM", bcf.toByteArray());
                        } catch (IOException e6) {
                        }
                        intent10.putExtra("STREAM_CARD_BUFFER", bcf.tVe.toByteArray());
                        intent10.putExtra("GET_REL_SCENE", 14);
                        intent10.putExtra("COMMENT_SCENE", 51);
                        intent10.putExtra("CARD_ID", r.aOw(bcf.cardId));
                        intent10.putExtra("SHARED_USERNAME", timeLineObject.UserName);
                        intent10.putExtra("FROM_SHARE_SCENE", 3);
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterAlbumRelatedTimelineUI(br.this.context, intent10);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(99724);
                        return;
                    }
                } else {
                    br brVar2 = br.this;
                    fat fat = timeLineObject.webSearchInfo;
                    if (fat != null && !Util.isNullOrNil(fat.IEy)) {
                        ai.a(brVar2.context, com.tencent.mm.plugin.topstory.a.h.a(fat, 31, ak.aXe("discoverRecommendEntry").optString("wording")));
                        String str6 = timeLineObject.UserName;
                        String str7 = timeLineObject.Id;
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("isShareClick=1");
                        stringBuffer.append("&relevant_vid=");
                        stringBuffer.append(fat.IEy);
                        stringBuffer.append("&relevant_pre_searchid=");
                        stringBuffer.append(fat.IEA);
                        stringBuffer.append("&relevant_shared_openid=");
                        stringBuffer.append(fat.IEB);
                        stringBuffer.append("&rec_category=");
                        if (fat.IEK > 0) {
                            stringBuffer.append(fat.IEK);
                        } else {
                            stringBuffer.append(fat.IEC);
                        }
                        stringBuffer.append("&source=");
                        stringBuffer.append(fat.source);
                        stringBuffer.append("&fromUser=");
                        stringBuffer.append(str6);
                        stringBuffer.append("&fromScene=");
                        stringBuffer.append(3);
                        stringBuffer.append("&targetInfo=");
                        stringBuffer.append(str7);
                        stringBuffer.append("&expand=");
                        stringBuffer.append(fat.IEz);
                        Log.i("MicroMsg.TopStory.TopStoryReportApiLogic", "reportTopStoryClickShareItem 15371 %s", stringBuffer.toString());
                        doc doc = new doc();
                        doc.MRe = stringBuffer.toString();
                        g.azz().a(new ad(doc), 0);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99724);
                    return;
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99724);
        }
    };
    private a ERb;
    public View.OnClickListener ERc = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass12 */

        public final void onClick(View view) {
            AppMethodBeat.i(99731);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(view == null || view.getTag() == null || !(view.getTag() instanceof ai))) {
                TimeLineObject timeLineObject = ((ai) view.getTag()).EpO;
                WeakReference<View> weakReference = ((ai) view.getTag()).EsG;
                if (!(timeLineObject == null || timeLineObject.ContentObj == null || timeLineObject.ContentObj.Lpa == null || weakReference == null || weakReference.get() == null)) {
                    View view2 = weakReference.get();
                    Rect rect = new Rect();
                    int[] iArr = new int[2];
                    view2.getLocationOnScreen(iArr);
                    rect.set(iArr[0], iArr[1], iArr[0] + view2.getMeasuredWidth(), view2.getMeasuredHeight() + iArr[1]);
                    com.tencent.mm.modelsns.h.a(view.getContext(), timeLineObject.ContentObj.Lpa, rect);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99731);
        }
    };
    public View.OnClickListener ERd = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass18 */

        public final void onClick(View view) {
            AppMethodBeat.i(99734);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() != null && (view.getTag() instanceof TimeLineObject)) {
                if (!WeChatBrands.Business.Entries.MomentChannels.checkAvailable(view.getContext())) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99734);
                    return;
                }
                TimeLineObject timeLineObject = (TimeLineObject) view.getTag();
                if (timeLineObject.ContentObj != null && timeLineObject.ContentObj.dME != null) {
                    long aOw = r.aOw(timeLineObject.ContentObj.dME.objectId);
                    long j2 = timeLineObject.ContentObj.dME.localId;
                    if (!(aOw == 0 && j2 == 0)) {
                        Intent intent = new Intent();
                        intent.putExtra("report_scene", 3);
                        intent.putExtra("from_user", timeLineObject.UserName);
                        intent.putExtra("feed_object_id", aOw);
                        intent.putExtra("feed_object_nonceId", timeLineObject.ContentObj.dME.objectNonceId);
                        intent.putExtra("business_type", 0);
                        intent.putExtra("finder_user_name", timeLineObject.ContentObj.dME.username);
                        intent.putExtra("key_from_user_name", timeLineObject.UserName);
                        intent.putExtra("tab_type", 5);
                        intent.putExtra("key_comment_scene", 38);
                        intent.putExtra("feed_local_id", j2);
                        intent.putExtra("key_finder_teen_mode_check", true);
                        intent.putExtra("key_finder_teen_mode_scene", 3);
                        intent.putExtra("key_finder_teen_mode_user_name", timeLineObject.ContentObj.dME.nickname);
                        intent.putExtra("key_finder_teen_mode_user_id", timeLineObject.ContentObj.dME.username);
                        if (aOw == 0 && j2 != 0) {
                            intent.putExtra("key_posting_scene", true);
                        }
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 38, intent);
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderShareFeedUI(br.this.context, intent);
                    }
                } else if (!(timeLineObject.ContentObj == null || timeLineObject.ContentObj.Lpd == null)) {
                    long aOw2 = r.aOw(timeLineObject.ContentObj.Lpd.objectId);
                    if (aOw2 != 0) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("report_scene", 3);
                        intent2.putExtra("from_user", timeLineObject.UserName);
                        intent2.putExtra("feed_object_id", aOw2);
                        intent2.putExtra("feed_object_nonceId", timeLineObject.ContentObj.Lpd.objectNonceId);
                        intent2.putExtra("business_type", 1);
                        intent2.putExtra("key_from_user_name", timeLineObject.UserName);
                        intent2.putExtra("tab_type", 5);
                        intent2.putExtra("key_comment_scene", 53);
                        intent2.putExtra("key_finder_teen_mode_check", true);
                        intent2.putExtra("key_finder_teen_mode_scene", 3);
                        intent2.putExtra("key_finder_teen_mode_user_name", timeLineObject.ContentObj.Lpd.nickname);
                        intent2.putExtra("key_finder_teen_mode_user_id", timeLineObject.ContentObj.Lpd.username);
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 38, intent2);
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderShareFeedUI(br.this.context, intent2);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99734);
        }
    };
    public View.OnClickListener ERe = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass19 */

        public final void onClick(View view) {
            AppMethodBeat.i(99735);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() != null && (view.getTag() instanceof TimeLineObject)) {
                TimeLineObject timeLineObject = (TimeLineObject) view.getTag();
                long aOw = r.aOw(timeLineObject.ContentObj.Lpc.hJs);
                long aOw2 = r.aOw(timeLineObject.ContentObj.Lpc.feedId);
                if (!(aOw == 0 || aOw2 == 0)) {
                    if (Util.isEqual(z.aUg(), timeLineObject.ContentObj.Lpc.username)) {
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderLiveAnchorUI(br.this.context, aOw2, Long.valueOf(aOw), timeLineObject.ContentObj.Lpc.objectNonceId, timeLineObject.ContentObj.Lpc.desc, "", "", "");
                    } else {
                        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq = timeLineObject.UserName == null ? "" : timeLineObject.UserName;
                        com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr = timeLineObject.Id;
                        com.tencent.mm.plugin.expt.hellhound.a.aox("temp_6");
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).report21053OnClick(aOw2, aOw, timeLineObject.ContentObj.Lpc.username, -1, -1, 7, "temp_6", timeLineObject.ContentObj.Lpc.liveStatus == 1 ? 1 : 2, com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cPi(), com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq, com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr, System.currentTimeMillis(), 1);
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderLiveVisitorUI(br.this.context, aOw2, Long.valueOf(aOw), timeLineObject.ContentObj.Lpc.username, timeLineObject.ContentObj.Lpc.objectNonceId, timeLineObject.ContentObj.Lpc.desc, "", "", "", 0);
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99735);
                    return;
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99735);
        }
    };
    public View.OnClickListener ERf = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass20 */

        public final void onClick(View view) {
            cnb cnb;
            AppMethodBeat.i(99736);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() != null && (view.getTag() instanceof s)) {
                if (!((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).canEnterMvAndShowToast()) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99736);
                    return;
                }
                TimeLineObject timeLineObject = ((s) view.getTag()).EpO;
                boolean z = timeLineObject.ContentObj.LoU == 42;
                if (!z && timeLineObject.AppInfo != null) {
                    if (timeLineObject.ContentObj.LoU == 4) {
                        com.tencent.mm.plugin.comm.a aVar = com.tencent.mm.plugin.comm.a.qCo;
                        if (com.tencent.mm.plugin.comm.a.akQ(timeLineObject.AppInfo.Id)) {
                            z = true;
                        }
                    }
                    z = false;
                }
                Object[] objArr = new Object[3];
                objArr[0] = Boolean.valueOf(z);
                objArr[1] = Integer.valueOf(timeLineObject.ContentObj.LoU);
                objArr[2] = timeLineObject.AppInfo == null ? "" : timeLineObject.AppInfo.Id;
                Log.i("MicroMsg.TimeLineClickEvent", "canEnterMv:%b, type:%d, appId:%s", objArr);
                if (z) {
                    if (!br.aMJ(timeLineObject.Id)) {
                        css css = timeLineObject.ContentObj != null ? timeLineObject.ContentObj.jfy : null;
                        if (css != null) {
                            try {
                                css css2 = new css();
                                css2.parseFrom(css.toByteArray());
                                com.tencent.mm.ay.a.c(com.tencent.mm.ay.i.a(aj.getAccPath(), timeLineObject, 1, com.tencent.mm.ay.h.a(timeLineObject.Id, css2)));
                            } catch (IOException e2) {
                                Log.e("MicroMsg.TimeLineClickEvent", "playMvMusic fail: " + e2.getLocalizedMessage());
                            }
                        }
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_scene", 7);
                    if (!timeLineObject.ContentObj.LoV.isEmpty() && (cnb = timeLineObject.ContentObj.LoV.get(0)) != null) {
                        intent.putExtra("key_mv_song_name", cnb.Title);
                        intent.putExtra("key_mv_song_lyric", cnb.songLyric);
                        intent.putExtra("key_mv_album_cover_url", cnb.songAlbumUrl);
                    }
                    if (timeLineObject.ContentObj.jfy != null) {
                        css css3 = timeLineObject.ContentObj.jfy;
                        intent.putExtra("key_mv_feed_id", css3.Ktn);
                        intent.putExtra("key_mv_nonce_id", css3.Kto);
                        intent.putExtra("key_mv_cover_url", css3.Ktp);
                        intent.putExtra("key_mv_poster", css3.Ktq);
                        intent.putExtra("key_mv_singer_name", css3.singerName);
                        intent.putExtra("key_mv_album_name", css3.albumName);
                        intent.putExtra("key_mv_music_genre", css3.musicGenre);
                        intent.putExtra("key_mv_issue_date", String.valueOf(css3.issueDate));
                        intent.putExtra("key_mv_identification", css3.identification);
                        intent.putExtra("key_mv_extra_info", css3.extraInfo);
                        intent.putExtra("key_mv_music_duration", css3.Alz);
                        intent.putExtra("key_mv_thumb_path", css3.jfz);
                    }
                    intent.setFlags(268435456);
                    SecDataUIC.a aVar2 = SecDataUIC.CWq;
                    cst cst = (cst) SecDataUIC.a.a(br.this.context, "MusicMvMainUI", 7, cst.class);
                    cst.scene = 1;
                    com.tencent.mm.plugin.comm.a aVar3 = com.tencent.mm.plugin.comm.a.qCo;
                    cst.sGQ = com.tencent.mm.plugin.comm.a.cAK();
                    cst.MxI = 85;
                    cst.MxJ = timeLineObject.Id;
                    c.b(br.this.context, "mv", ".ui.MusicMvMainUI", intent);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99736);
                    return;
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99736);
        }
    };
    public View.OnClickListener ERg = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass21 */

        public final void onClick(View view) {
            bv bvVar;
            AppMethodBeat.i(99737);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(view.getTag() == null || !(view.getTag() instanceof bv) || (bvVar = (bv) view.getTag()) == null)) {
                Intent intent = new Intent(br.this.context, SnsWsFoldDetailUI.class);
                intent.putExtra("key_ws_group_id", bvVar.EQE);
                intent.putExtra("key_ws_detail_max_id", bvVar.DIf);
                intent.putExtra("key_ws_detail_min_id", bvVar.DIg);
                intent.putExtra("key_ws_detail_username", bvVar.username);
                ArrayList<String> arrayList = new ArrayList<>();
                for (Long l : bvVar.idList) {
                    arrayList.add(r.Jc(l.longValue()));
                }
                intent.putStringArrayListExtra("key_ws_str_sns_id_list", arrayList);
                Context context = br.this.context;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.plugin.sns.k.e.DUQ.a(bvVar.idList, bvVar.EQE, bvVar.username);
                it itVar = com.tencent.mm.plugin.sns.k.e.DUQ.DVH.get(Long.valueOf(bvVar.EQE));
                if (itVar != null) {
                    itVar.ePH = 1;
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99737);
        }
    };
    public View.OnClickListener ERh = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass22 */

        public final void onClick(View view) {
            AppMethodBeat.i(99738);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() != null && (view.getTag() instanceof TimeLineObject)) {
                if (!WeChatBrands.Business.Entries.MomentChannels.checkAvailable(view.getContext())) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99738);
                    return;
                }
                TimeLineObject timeLineObject = (TimeLineObject) view.getTag();
                if (timeLineObject.ContentObj != null && timeLineObject.ContentObj.dME != null) {
                    long aOw = r.aOw(timeLineObject.ContentObj.dME.objectId);
                    long j2 = timeLineObject.ContentObj.dME.localId;
                    if (!(aOw == 0 && j2 == 0)) {
                        Intent intent = new Intent();
                        intent.putExtra("report_scene", 3);
                        intent.putExtra("from_user", timeLineObject.UserName);
                        intent.putExtra("feed_object_id", aOw);
                        intent.putExtra("feed_object_nonceId", timeLineObject.ContentObj.dME.objectNonceId);
                        intent.putExtra("business_type", 0);
                        intent.putExtra("finder_user_name", timeLineObject.ContentObj.dME.username);
                        intent.putExtra("key_from_user_name", timeLineObject.UserName);
                        intent.putExtra("tab_type", 5);
                        intent.putExtra("feed_local_id", j2);
                        intent.putExtra("key_finder_teen_mode_check", true);
                        intent.putExtra("key_finder_teen_mode_scene", 3);
                        intent.putExtra("key_finder_teen_mode_user_name", timeLineObject.ContentObj.dME.nickname);
                        intent.putExtra("key_finder_teen_mode_user_id", timeLineObject.ContentObj.dME.username);
                        if (aOw == 0 && j2 != 0) {
                            intent.putExtra("key_posting_scene", true);
                        }
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 38, intent);
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderShareFeedUI(br.this.context, intent);
                    }
                } else if (!(timeLineObject.ContentObj == null || timeLineObject.ContentObj.Lpd == null)) {
                    long aOw2 = r.aOw(timeLineObject.ContentObj.Lpd.objectId);
                    if (aOw2 != 0) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("report_scene", 3);
                        intent2.putExtra("from_user", timeLineObject.UserName);
                        intent2.putExtra("feed_object_id", aOw2);
                        intent2.putExtra("feed_object_nonceId", timeLineObject.ContentObj.Lpd.objectNonceId);
                        intent2.putExtra("business_type", 1);
                        intent2.putExtra("key_from_user_name", timeLineObject.UserName);
                        intent2.putExtra("tab_type", 5);
                        intent2.putExtra("key_finder_teen_mode_check", true);
                        intent2.putExtra("key_finder_teen_mode_scene", 3);
                        intent2.putExtra("key_finder_teen_mode_user_name", timeLineObject.ContentObj.Lpd.nickname);
                        intent2.putExtra("key_finder_teen_mode_user_id", timeLineObject.ContentObj.Lpd.username);
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 53, intent2);
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderShareFeedUI(br.this.context, intent2);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99738);
        }
    };
    public View.OnClickListener ERi = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass23 */

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.i(99739);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            br brVar = br.this;
            if (view == null || !(view.getTag() instanceof TimeLineObject)) {
                z = true;
            } else {
                String str = ((TimeLineObject) view.getTag()).AppInfo.Id;
                if ("wx485a97c844086dc9".equals(str)) {
                    c.b(view.getContext(), "shake", ".ui.ShakeReportUI", new Intent().putExtra("shake_music", true));
                    z = true;
                } else if ("wx7fa037cc7dfabad5".equals(str)) {
                    com.tencent.mm.plugin.sport.a.c.pl(34);
                    g.aAi();
                    if (com.tencent.mm.contact.c.oR(((l) g.af(l.class)).aSN().Kn("gh_43f2581f6fd6").field_type)) {
                        Intent intent = new Intent();
                        intent.putExtra("Chat_User", "gh_43f2581f6fd6");
                        intent.putExtra("finish_direct", true);
                        c.f(brVar.context, ".ui.chatting.ChattingUI", intent);
                    } else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Contact_User", "gh_43f2581f6fd6");
                        c.b(brVar.context, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    }
                    z = true;
                } else if ("wx9181ed3f223e6d76".equals(str) || "wx2fe12a395c426fcf".equals(str)) {
                    Log.i("MicroMsg.TimeLineClickEvent", "hy: shake new year closed. try to go to shake TV");
                    Intent intent3 = new Intent();
                    intent3.putExtra("shake_tv", true);
                    c.b(view.getContext(), "shake", ".ui.ShakeReportUI", intent3);
                    z = true;
                } else if ("wxfbc915ff7c30e335".equals(str)) {
                    Intent intent4 = new Intent();
                    intent4.putExtra("BaseScanUI_select_scan_mode", 1);
                    if (!com.tencent.mm.q.a.o(brVar.context, true) && !com.tencent.mm.q.a.cA(brVar.context) && !com.tencent.mm.q.a.cE(brVar.context)) {
                        c.b(brVar.context, "scanner", ".ui.BaseScanUI", intent4);
                    }
                    z = true;
                } else if (!"wxaf060266bfa9a35c".equals(str)) {
                    z = false;
                } else if (!com.tencent.mm.ay.e.bek()) {
                    z = true;
                } else {
                    Intent intent5 = new Intent();
                    intent5.putExtra("shake_tv", true);
                    c.b(brVar.context, "shake", ".ui.ShakeReportUI", intent5);
                    z = true;
                }
            }
            if (!z) {
                if (view == null || !(view.getTag() instanceof TimeLineObject)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99739);
                    return;
                } else if (!WeChatBrands.Business.Entries.MomentChannels.checkAvailable(view.getContext())) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99739);
                    return;
                } else {
                    TimeLineObject timeLineObject = (TimeLineObject) view.getTag();
                    if (timeLineObject == null || timeLineObject.AppInfo == null) {
                        Log.e("MicroMsg.TimeLineClickEvent", "appInfo is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(99739);
                        return;
                    } else if (timeLineObject.ContentObj != null && timeLineObject.ContentObj.LoU == 28 && timeLineObject.ContentObj.dME != null) {
                        Intent intent6 = new Intent();
                        intent6.putExtra("key_from_profile_share_scene", 3);
                        intent6.putExtra("key_enter_profile_type", 8);
                        intent6.putExtra("key_comment_scene", 37);
                        if (Util.isNullOrNil(timeLineObject.ContentObj.dME.username)) {
                            intent6.putExtra("finder_username", "");
                            intent6.putExtra("key_finder_object_Id", timeLineObject.ContentObj.dME.objectId);
                            intent6.putExtra("key_finder_object_nonce_id_key", timeLineObject.ContentObj.dME.objectNonceId);
                        } else {
                            intent6.putExtra("finder_username", timeLineObject.ContentObj.dME.username);
                        }
                        intent6.putExtra("key_finder_teen_mode_check", true);
                        intent6.putExtra("key_finder_teen_mode_scene", 3);
                        intent6.putExtra("key_finder_teen_mode_user_name", timeLineObject.ContentObj.dME.nickname);
                        intent6.putExtra("key_finder_teen_mode_user_id", timeLineObject.ContentObj.dME.username);
                        String str2 = Util.nullAsNil(((com.tencent.mm.plugin.expt.b.c) g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD()) + "," + Util.nullAsNil(timeLineObject.UserName) + "," + timeLineObject.ContentObj.dME.objectId + "," + timeLineObject.Id;
                        Log.i("MicroMsg.TimeLineClickEvent", "report20587, ".concat(String.valueOf(str2)));
                        h.INSTANCE.kvStat(20587, str2);
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 32, intent6);
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderProfileUI(view.getContext(), intent6);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(99739);
                        return;
                    } else if (timeLineObject.ContentObj != null && timeLineObject.ContentObj.LoU == 36 && timeLineObject.ContentObj.Lpd != null) {
                        Intent intent7 = new Intent();
                        intent7.putExtra("key_from_profile_share_scene", 3);
                        intent7.putExtra("key_enter_profile_type", 8);
                        intent7.putExtra("key_comment_scene", 37);
                        if (Util.isNullOrNil(timeLineObject.ContentObj.Lpd.username)) {
                            intent7.putExtra("finder_username", "");
                            intent7.putExtra("key_finder_object_Id", timeLineObject.ContentObj.Lpd.objectId);
                            intent7.putExtra("key_finder_object_nonce_id_key", timeLineObject.ContentObj.Lpd.objectNonceId);
                        } else {
                            intent7.putExtra("finder_username", timeLineObject.ContentObj.Lpd.username);
                        }
                        intent7.putExtra("key_finder_teen_mode_check", true);
                        intent7.putExtra("key_finder_teen_mode_scene", 3);
                        intent7.putExtra("key_finder_teen_mode_user_name", timeLineObject.ContentObj.Lpd.nickname);
                        intent7.putExtra("key_finder_teen_mode_user_id", timeLineObject.ContentObj.Lpd.username);
                        String str3 = Util.nullAsNil(((com.tencent.mm.plugin.expt.b.c) g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD()) + "," + Util.nullAsNil(timeLineObject.UserName) + "," + timeLineObject.ContentObj.Lpd.objectId + "," + timeLineObject.Id;
                        Log.i("MicroMsg.TimeLineClickEvent", "report20587, ".concat(String.valueOf(str3)));
                        h.INSTANCE.kvStat(20587, str3);
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 32, intent7);
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderProfileUI(view.getContext(), intent7);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(99739);
                        return;
                    } else if (timeLineObject.ContentObj != null && ((timeLineObject.ContentObj.LoU == 34 || timeLineObject.ContentObj.LoU == 43) && timeLineObject.ContentObj.Lpc != null)) {
                        Intent intent8 = new Intent();
                        intent8.putExtra("key_from_profile_share_scene", 3);
                        intent8.putExtra("key_enter_profile_type", 8);
                        if (Util.isNullOrNil(timeLineObject.ContentObj.Lpc.username)) {
                            intent8.putExtra("finder_username", "");
                            intent8.putExtra("key_finder_object_Id", timeLineObject.ContentObj.Lpc.feedId);
                            intent8.putExtra("key_finder_object_nonce_id_key", timeLineObject.ContentObj.Lpc.objectNonceId);
                        } else {
                            intent8.putExtra("finder_username", timeLineObject.ContentObj.Lpc.username);
                            intent8.putExtra("key_finder_teen_mode_user_id", timeLineObject.ContentObj.Lpc.username);
                        }
                        if (!Util.isNullOrNil(timeLineObject.ContentObj.Lpc.nickName)) {
                            intent8.putExtra("key_finder_teen_mode_user_name", timeLineObject.ContentObj.Lpc.nickName);
                        }
                        intent8.putExtra("key_finder_teen_mode_check", true);
                        intent8.putExtra("key_finder_teen_mode_scene", 3);
                        Log.i("MicroMsg.TimeLineClickEvent", "report20587, ".concat(String.valueOf(Util.nullAsNil(((com.tencent.mm.plugin.expt.b.c) g.af(com.tencent.mm.plugin.expt.b.c.class)).cMD()) + "," + Util.nullAsNil(timeLineObject.UserName) + "," + timeLineObject.ContentObj.Lpc.feedId + "," + timeLineObject.Id)));
                        ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderProfileUI(view.getContext(), intent8);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(99739);
                        return;
                    } else if (timeLineObject.ContentObj == null || timeLineObject.ContentObj.LoU != 1 || timeLineObject.ContentObj.Lpc == null) {
                        String str4 = timeLineObject.AppInfo.Id;
                        String go = com.tencent.mm.plugin.sns.c.a.jRu.go(str4);
                        if (!Util.isNullOrNil(go)) {
                            String str5 = timeLineObject == null ? null : timeLineObject.UserName;
                            int i2 = 2;
                            if (timeLineObject.ContentObj.LoU == 1) {
                                i2 = 2;
                            } else if (timeLineObject.ContentObj.LoU == 3) {
                                i2 = 5;
                            }
                            String str6 = null;
                            if (!(timeLineObject.actionInfo == null || timeLineObject.actionInfo.KEw == null)) {
                                str6 = timeLineObject.actionInfo.KEw.KEq;
                            }
                            ry ryVar = new ry();
                            ryVar.dYw.context = br.this.context;
                            ryVar.dYw.scene = 4;
                            ryVar.dYw.dNI = str4;
                            ryVar.dYw.packageName = go;
                            ryVar.dYw.msgType = i2;
                            ryVar.dYw.dRL = str5;
                            ryVar.dYw.mediaTagName = str6;
                            ryVar.dYw.dYx = 5;
                            ryVar.dYw.dTS = 0;
                            ryVar.dYw.dYy = timeLineObject.Id;
                            EventCenter.instance.publish(ryVar);
                            is isVar = new is();
                            isVar.dNr.actionCode = 2;
                            isVar.dNr.scene = 3;
                            isVar.dNr.extMsg = "timeline_src=3";
                            isVar.dNr.appId = str4;
                            isVar.dNr.context = br.this.context;
                            EventCenter.instance.publish(isVar);
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(99739);
                            return;
                        }
                        String e2 = com.tencent.mm.plugin.sns.c.a.jRu.e(br.this.context, str4, "timeline");
                        if (e2 == null || e2.length() == 0) {
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(99739);
                            return;
                        }
                        Intent intent9 = new Intent();
                        intent9.putExtra("rawUrl", e2);
                        intent9.putExtra("shortUrl", e2);
                        intent9.putExtra("useJs", true);
                        intent9.putExtra("type", -255);
                        intent9.putExtra("geta8key_scene", 2);
                        com.tencent.mm.plugin.sns.c.a.jRt.i(intent9, br.this.context);
                    } else {
                        long aOw = r.aOw(timeLineObject.ContentObj.Lpc.hJs);
                        long aOw2 = r.aOw(timeLineObject.ContentObj.Lpc.feedId);
                        if (aOw == 0 || aOw2 == 0) {
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(99739);
                            return;
                        }
                        if (Util.isEqual(z.aUg(), timeLineObject.ContentObj.Lpc.username)) {
                            ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderLiveAnchorUI(br.this.context, aOw2, Long.valueOf(aOw), timeLineObject.ContentObj.Lpc.objectNonceId, timeLineObject.ContentObj.Lpc.desc, "", "", "");
                        } else {
                            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq = timeLineObject.UserName == null ? "" : timeLineObject.UserName;
                            com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr = timeLineObject.Id;
                            com.tencent.mm.plugin.expt.hellhound.a.aox("temp_6");
                            ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).report21053OnClick(aOw2, aOw, timeLineObject.ContentObj.Lpc.username, -1, -1, 7, "temp_6", timeLineObject.ContentObj.Lpc.liveStatus == 1 ? 1 : 2, com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cPi(), com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEq, com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEr, System.currentTimeMillis(), 1);
                            ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderLiveVisitorUI(br.this.context, aOw2, Long.valueOf(aOw), timeLineObject.ContentObj.Lpc.username, timeLineObject.ContentObj.Lpc.objectNonceId, timeLineObject.ContentObj.Lpc.desc, "", "", "", 4);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(99739);
                        return;
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99739);
        }
    };
    public View.OnClickListener ERj = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass24 */

        public final void onClick(View view) {
            AppMethodBeat.i(99740);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() instanceof bo) {
                final bo boVar = (bo) view.getTag();
                if (Util.isNullOrNil(boVar.CAZ)) {
                    Log.e("MicroMsg.TimeLineClickEvent", "show source profile fail, username is null");
                    Toast.makeText(br.this.context, br.this.context.getString(R.string.dg5, 3, -1), 0).show();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99740);
                    return;
                }
                g.aAi();
                as Kn = ((l) g.af(l.class)).aSN().Kn(boVar.CAZ);
                if (Kn == null || !Kn.field_username.equals(boVar.CAZ)) {
                    ay.a.iDq.a(boVar.CAZ, "", new ay.b.a() {
                        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass24.AnonymousClass1 */

                        @Override // com.tencent.mm.model.ay.b.a
                        public final void p(String str, boolean z) {
                            AppMethodBeat.i(203843);
                            if (br.this.tipDialog != null) {
                                br.this.tipDialog.dismiss();
                            }
                            if (!z) {
                                Toast.makeText(br.this.context, br.this.context.getString(R.string.dg5, 3, -1), 0).show();
                                AppMethodBeat.o(203843);
                                return;
                            }
                            com.tencent.mm.aj.c.ap(str, 3);
                            p.aYD().Mg(str);
                            Intent intent = new Intent();
                            intent.addFlags(268435456);
                            intent.putExtra("Contact_User", str);
                            intent.putExtra("Contact_Scene", 37);
                            g.aAi();
                            as Kn = ((l) g.af(l.class)).aSN().Kn(str);
                            if (Kn != null && Kn.gBM()) {
                                h.INSTANCE.kvStat(10298, str + ",37");
                                intent.putExtra("Contact_Scene", 37);
                            }
                            com.tencent.mm.plugin.sns.c.a.jRt.c(intent, br.this.context);
                            AppMethodBeat.o(203843);
                        }
                    });
                    br brVar = br.this;
                    Context context = br.this.context;
                    br.this.context.getString(R.string.zb);
                    brVar.tipDialog = com.tencent.mm.ui.base.h.a(context, br.this.context.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass24.AnonymousClass2 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(203844);
                            ay.a.iDq.JZ(boVar.CAZ);
                            AppMethodBeat.o(203844);
                        }
                    });
                } else {
                    Intent intent = new Intent();
                    intent.addFlags(268435456);
                    intent.putExtra("Contact_User", boVar.CAZ);
                    h.INSTANCE.kvStat(10298, boVar.CAZ + ",37");
                    intent.putExtra("Contact_Scene", 37);
                    com.tencent.mm.plugin.sns.c.a.jRt.c(intent, br.this.context);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(99740);
                    return;
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99740);
        }
    };
    public View.OnClickListener ERk = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass2 */

        public final void onClick(View view) {
            AppMethodBeat.i(99725);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(view.getTag() instanceof s)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99725);
                return;
            }
            s sVar = (s) view.getTag();
            TimeLineObject timeLineObject = sVar.EpO;
            if (timeLineObject.ContentObj.LoV.size() > 0) {
                SnsInfo aQm = aj.faO().aQm(sVar.dHp);
                if (br.this.Epj != null) {
                    br.this.Epj.fat().M(aQm);
                }
                String str = timeLineObject.ContentObj.LoV.get(0).EpK;
                Intent intent = new Intent();
                intent.putExtra("key_Product_xml", str);
                intent.putExtra("key_ProductUI_getProductInfoScene", 2);
                c.b(view.getContext(), "scanner", ".ui.ProductUI", intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99725);
        }
    };
    public View.OnClickListener ERl = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass3 */

        public final void onClick(View view) {
            AppMethodBeat.i(99726);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.d("MicroMsg.TimeLineClickEvent", "hardTVRedirectListener");
            if (!(view.getTag() instanceof s)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99726);
                return;
            }
            s sVar = (s) view.getTag();
            TimeLineObject timeLineObject = sVar.EpO;
            if (timeLineObject.ContentObj.LoV.size() > 0) {
                SnsInfo aQm = aj.faO().aQm(sVar.dHp);
                if (br.this.Epj != null) {
                    br.this.Epj.fat().M(aQm);
                }
                String str = timeLineObject.ContentObj.LoV.get(0).EpK;
                Intent intent = new Intent();
                intent.putExtra("key_TV_xml", str);
                intent.putExtra("key_TV_getProductInfoScene", 2);
                c.b(view.getContext(), "shake", ".ui.TVInfoUI", intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99726);
        }
    };
    public View.OnClickListener ERm = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass4 */

        public final void onClick(View view) {
            AppMethodBeat.i(99727);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(view.getTag() instanceof s)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99727);
                return;
            }
            s sVar = (s) view.getTag();
            TimeLineObject timeLineObject = sVar.EpO;
            if (timeLineObject.ContentObj.LoV.size() > 0) {
                SnsInfo aQm = aj.faO().aQm(sVar.dHp);
                if (br.this.Epj != null) {
                    br.this.Epj.fat().M(aQm);
                }
                String str = timeLineObject.ContentObj.LoV.get(0).EpK;
                Intent intent = new Intent();
                intent.putExtra("sns_object_data", str);
                intent.putExtra("preceding_scence", 10);
                intent.putExtra("download_entrance_scene", 13);
                c.b(view.getContext(), "emoji", ".ui.EmojiStoreDetailUI", intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99727);
        }
    };
    public View.OnClickListener ERn = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass5 */

        public final void onClick(View view) {
            AppMethodBeat.i(99728);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(view.getTag() instanceof s)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99728);
                return;
            }
            s sVar = (s) view.getTag();
            TimeLineObject timeLineObject = sVar.EpO;
            if (timeLineObject.ContentObj.LoV.size() > 0) {
                SnsInfo aQm = aj.faO().aQm(sVar.dHp);
                if (br.this.Epj != null) {
                    br.this.Epj.fat().M(aQm);
                }
                String str = timeLineObject.ContentObj.LoV.get(0).EpK;
                Intent intent = new Intent();
                intent.putExtra("sns_object_data", str);
                intent.putExtra("extra_scence", 13);
                c.b(view.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99728);
        }
    };
    public View.OnClickListener ERo = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass6 */

        public final void onClick(View view) {
            AppMethodBeat.i(99729);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(view.getTag() instanceof s)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99729);
                return;
            }
            s sVar = (s) view.getTag();
            TimeLineObject timeLineObject = sVar.EpO;
            if (timeLineObject.ContentObj.LoV.size() > 0) {
                SnsInfo aQm = aj.faO().aQm(sVar.dHp);
                if (br.this.Epj != null) {
                    br.this.Epj.fat().M(aQm);
                }
                String str = timeLineObject.ContentObj.LoV.get(0).EpK;
                Intent intent = new Intent();
                intent.putExtra("sns_object_data", str);
                intent.putExtra("extra_scence", 13);
                c.b(view.getContext(), "emoji", ".ui.EmojiStoreTopicUI", intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99729);
        }
    };
    public View.OnClickListener ERp = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass7 */

        public final void onClick(View view) {
            AppMethodBeat.i(99730);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!(view.getTag() instanceof s)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(99730);
                return;
            }
            s sVar = (s) view.getTag();
            TimeLineObject timeLineObject = sVar.EpO;
            if (timeLineObject.ContentObj.LoV.size() > 0) {
                SnsInfo aQm = aj.faO().aQm(sVar.dHp);
                if (br.this.Epj != null) {
                    br.this.Epj.fat().M(aQm);
                }
                String str = timeLineObject.ContentObj.LoV.get(0).EpK;
                Intent intent = new Intent();
                intent.putExtra("sns_object_data", str);
                c.b(view.getContext(), "emoji", ".ui.v2.EmojiStoreV2SingleProductUI", intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(99730);
        }
    };
    public View.OnClickListener ERq = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass8 */

        public final void onClick(View view) {
            AppMethodBeat.i(179318);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            boolean z = view.getTag() instanceof s;
            Log.d("MicroMsg.TimeLineClickEvent", "musicRedirectListener click ".concat(String.valueOf(z)));
            if (!z) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(179318);
                return;
            }
            br.a(br.this, (s) view.getTag());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(179318);
        }
    };
    public View.OnClickListener ERr = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass9 */

        public final void onClick(View view) {
            AppMethodBeat.i(203833);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            boolean z = view.getTag() instanceof s;
            Log.d("MicroMsg.TimeLineClickEvent", "musicRedirectListener click ".concat(String.valueOf(z)));
            if (!z) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203833);
                return;
            }
            br.a(br.this, (s) view.getTag());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203833);
        }
    };
    public View.OnClickListener ERs = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass10 */

        public final void onClick(View view) {
            AppMethodBeat.i(203834);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener");
            if (!(view.getTag() instanceof s)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203834);
                return;
            }
            s sVar = (s) view.getTag();
            TimeLineObject timeLineObject = sVar.EpO;
            SnsInfo aQm = aj.faO().aQm(sVar.dHp);
            if (br.this.Epj != null) {
                br.this.Epj.fat().M(aQm);
            }
            if (timeLineObject.weappInfo == null) {
                Log.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener weappInfo is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203834);
                return;
            }
            String str = timeLineObject.weappInfo.username;
            String str2 = timeLineObject.weappInfo.path;
            Log.i("MicroMsg.TimeLineClickEvent", "username: " + str + "pagepath: " + str2);
            wq wqVar = new wq();
            wqVar.ecI.userName = str;
            wqVar.ecI.ecK = str2;
            wqVar.ecI.scene = 1009;
            wqVar.ecI.dCw = timeLineObject.Id + ":" + timeLineObject.UserName;
            Bundle bundle = new Bundle();
            bundle.putString("stat_send_msg_user", aQm.getUserName());
            bundle.putString("stat_msg_id", "sns_" + r.Jb(aQm.field_snsId));
            EventCenter.instance.publish(wqVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203834);
        }
    };
    public View.OnClickListener ERt = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass11 */

        public final void onClick(View view) {
            AppMethodBeat.i(203835);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener");
            if (!(view.getTag() instanceof s)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203835);
                return;
            }
            s sVar = (s) view.getTag();
            TimeLineObject timeLineObject = sVar.EpO;
            SnsInfo aQm = aj.faO().aQm(sVar.dHp);
            if (br.this.Epj != null) {
                br.this.Epj.fat().M(aQm);
            }
            if (timeLineObject.weappInfo == null) {
                Log.e("MicroMsg.TimeLineClickEvent", "appbrandSingePageListener weappInfo is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203835);
                return;
            }
            AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
            appBrandLaunchReferrer.leo = 6;
            appBrandLaunchReferrer.eda = timeLineObject.weappInfo.eda;
            Log.d("MicroMsg.TimeLineClickEvent", "launch weapp, extraData: %s", appBrandLaunchReferrer.lep);
            com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
            gVar.username = timeLineObject.weappInfo.username;
            gVar.kHw = timeLineObject.weappInfo.path;
            gVar.iOo = timeLineObject.weappInfo.nbf;
            gVar.version = timeLineObject.weappInfo.version;
            gVar.kHH = timeLineObject.ContentObj.Title;
            gVar.launchMode = 1;
            gVar.scene = 1154;
            gVar.dCw = timeLineObject.weappInfo.dCC;
            gVar.kHF = appBrandLaunchReferrer;
            if (timeLineObject.weappInfo.Nvm != null) {
                try {
                    com.tencent.mm.ab.f fVar = new com.tencent.mm.ab.f(timeLineObject.weappInfo.Nvm);
                    gVar.kHK = new ArrayList();
                    for (int i2 = 0; i2 < fVar.length(); i2++) {
                        gVar.kHK.add(fVar.getString(i2));
                    }
                } catch (com.tencent.mm.ab.g e2) {
                }
            }
            ((com.tencent.mm.plugin.appbrand.service.r) g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(view.getContext(), gVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203835);
        }
    };
    public View.OnClickListener ERu = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass13 */

        public final void onClick(View view) {
            AppMethodBeat.i(203836);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.TimeLineClickEvent", "appbrandHomeRedirectListener");
            if (!(view.getTag() instanceof TimeLineObject)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203836);
                return;
            }
            TimeLineObject timeLineObject = (TimeLineObject) view.getTag();
            if (timeLineObject.weappInfo == null) {
                Log.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203836);
                return;
            }
            String str = timeLineObject.weappInfo.username;
            wq wqVar = new wq();
            Log.i("MicroMsg.TimeLineClickEvent", "username: ".concat(String.valueOf(str)));
            wqVar.ecI.userName = str;
            wqVar.ecI.scene = 1009;
            wqVar.ecI.dCw = timeLineObject.Id + ":" + timeLineObject.UserName;
            EventCenter.instance.publish(wqVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203836);
        }
    };
    public View.OnClickListener ERv = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass14 */

        public final void onClick(View view) {
            AppMethodBeat.i(203837);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.TimeLineClickEvent", "hardMallProductRedirectListener");
            if (!(view.getTag() instanceof s)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203837);
                return;
            }
            s sVar = (s) view.getTag();
            TimeLineObject timeLineObject = sVar.EpO;
            if (timeLineObject.ContentObj.LoV.size() > 0) {
                SnsInfo aQm = aj.faO().aQm(sVar.dHp);
                if (br.this.Epj != null) {
                    br.this.Epj.fat().M(aQm);
                }
                String str = timeLineObject.ContentObj.LoV.get(0).EpK;
                Intent intent = new Intent();
                intent.putExtra("key_product_scene", 2);
                intent.putExtra("key_product_info", str);
                c.b(br.this.context, "product", ".ui.MallProductUI", intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203837);
        }
    };
    public View.OnClickListener ERw = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass15 */

        public final void onClick(View view) {
            AppMethodBeat.i(203838);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener");
            if (!(view.getTag() instanceof s)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203838);
                return;
            }
            s sVar = (s) view.getTag();
            TimeLineObject timeLineObject = sVar.EpO;
            if (timeLineObject.ContentObj.LoV.size() > 0) {
                SnsInfo aQm = aj.faO().aQm(sVar.dHp);
                if (br.this.Epj != null) {
                    br.this.Epj.fat().M(aQm);
                }
                String str = timeLineObject.ContentObj.LoV.get(0).EpK;
                Intent intent = new Intent();
                intent.putExtra("key_from_scene", 12);
                if (!TextUtils.isEmpty(str)) {
                    String[] split = str.split("#");
                    if (split.length >= 2) {
                        Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData[0]:" + split[0]);
                        intent.putExtra("key_card_id", split[0]);
                        intent.putExtra("key_card_ext", split[1]);
                        c.b(br.this.context, "card", ".ui.CardDetailUI", intent);
                    } else if (split.length == 1) {
                        Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include cardExt");
                        Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener card_id :".concat(String.valueOf(str)));
                        intent.putExtra("key_card_id", split[0]);
                        intent.putExtra("key_card_ext", "");
                        c.b(br.this.context, "card", ".ui.CardDetailUI", intent);
                    } else {
                        Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData not include card_id and cardExt");
                        Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData :".concat(String.valueOf(str)));
                    }
                } else {
                    Log.i("MicroMsg.TimeLineClickEvent", "cardRediretListener userData is empty");
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203838);
        }
    };
    public View.OnClickListener ERx = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass16 */

        public final void onClick(View view) {
            AppMethodBeat.i(203839);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.TimeLineClickEvent", "noteLinkRedirectListener");
            if (view.getTag() instanceof s) {
                s sVar = (s) view.getTag();
                if (sVar.EpO.ContentObj.LoU == 26) {
                    if (Util.isNullOrNil(sVar.EpO.ContentObj.LoX)) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(203839);
                        return;
                    }
                    hb hbVar = new hb();
                    hbVar.dLm.type = 37;
                    hbVar.dLm.desc = sVar.EpO.ContentObj.LoX;
                    String str = "";
                    if (sVar.EpO.ContentObj.LoV != null && sVar.EpO.ContentObj.LoV.size() > 0) {
                        String ki = ar.ki(aj.getAccSnsPath(), sVar.EpO.ContentObj.LoV.get(0).Id);
                        String e2 = r.e(sVar.EpO.ContentObj.LoV.get(0));
                        str = s.YS(new StringBuilder().append(ki).append(e2).toString()) ? ki + e2 : "";
                    }
                    hbVar.dLm.path = str;
                    hbVar.dLm.title = sVar.dHp;
                    hbVar.dLm.context = br.this.context;
                    EventCenter.instance.publish(hbVar);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203839);
        }
    };
    public View.OnClickListener ERy = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass17 */

        public final void onClick(final View view) {
            AppMethodBeat.i(203842);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i("MicroMsg.TimeLineClickEvent", "LiteApp Click");
            if (!(view.getTag() instanceof s)) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203842);
                return;
            }
            TimeLineObject timeLineObject = ((s) view.getTag()).EpO;
            if (timeLineObject.liteappInfo == null) {
                Log.e("MicroMsg.TimeLineClickEvent", "appbrandRedirectListener username is null");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203842);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("appId", timeLineObject.liteappInfo.appId);
            if (!Util.isNullOrNil(timeLineObject.liteappInfo.path)) {
                bundle.putString("path", timeLineObject.liteappInfo.path);
            }
            if (!Util.isNullOrNil(timeLineObject.liteappInfo.query)) {
                bundle.putString(SearchIntents.EXTRA_QUERY, timeLineObject.liteappInfo.query);
            }
            Context context = view.getContext();
            view.getContext().getString(R.string.zb);
            final q a2 = com.tencent.mm.ui.base.h.a(context, view.getContext().getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass17.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                }
            });
            ((com.tencent.mm.plugin.lite.a.a) g.af(com.tencent.mm.plugin.lite.a.a.class)).a(view.getContext(), bundle, false, new a.AbstractC1459a() {
                /* class com.tencent.mm.plugin.sns.ui.br.AnonymousClass17.AnonymousClass2 */

                @Override // com.tencent.mm.plugin.lite.a.a.AbstractC1459a
                public final void dTt() {
                    AppMethodBeat.i(203840);
                    h.INSTANCE.n(1293, 32, 1);
                    a2.cancel();
                    AppMethodBeat.o(203840);
                }

                @Override // com.tencent.mm.plugin.lite.a.a.AbstractC1459a
                public final void dTu() {
                    AppMethodBeat.i(203841);
                    u.makeText(view.getContext(), (int) R.string.eka, 0).show();
                    a2.cancel();
                    AppMethodBeat.o(203841);
                }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/TimeLineClickEvent$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203842);
        }
    };
    com.tencent.mm.plugin.sns.model.ai Epj;
    Context context;
    long lastClickTime = 0;
    int source = 0;
    q tipDialog;

    public interface a {
        void dWI();
    }

    public br(Context context2, a aVar, int i2, com.tencent.mm.plugin.sns.model.ai aiVar) {
        AppMethodBeat.i(99741);
        this.context = context2;
        this.ERb = aVar;
        this.source = i2;
        this.Epj = aiVar;
        AppMethodBeat.o(99741);
    }

    protected static boolean aMJ(String str) {
        AppMethodBeat.i(99742);
        mw mwVar = new mw();
        mwVar.dSw.action = -2;
        EventCenter.instance.publish(mwVar);
        com.tencent.mm.ay.f fVar = mwVar.dSx.dSy;
        if (fVar == null || !com.tencent.mm.ay.a.e(fVar) || !str.equals(fVar.jeV) || !com.tencent.mm.ay.a.bec()) {
            AppMethodBeat.o(99742);
            return false;
        }
        AppMethodBeat.o(99742);
        return true;
    }

    protected static String aRg(String str) {
        AppMethodBeat.i(99743);
        Log.d("MicroMsg.TimeLineClickEvent", "url:".concat(String.valueOf(str)));
        String R = com.tencent.mm.plugin.sns.c.a.jRu.R(str, "timeline");
        AppMethodBeat.o(99743);
        return R;
    }

    public static String aU(String str, String str2, String str3) {
        AppMethodBeat.i(99744);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            AppMethodBeat.o(99744);
            return "";
        }
        try {
            String str4 = XmlParser.parseXml(str, str2, null).get(str3);
            AppMethodBeat.o(99744);
            return str4;
        } catch (Exception e2) {
            Log.e("MicroMsg.TimeLineClickEvent", "getXmlValueByTag exp=" + e2.toString());
            AppMethodBeat.o(99744);
            return "";
        }
    }

    static /* synthetic */ void a(br brVar, s sVar) {
        css css;
        int i2;
        k tP;
        String str;
        int i3 = 1;
        AppMethodBeat.i(99745);
        TimeLineObject timeLineObject = sVar.EpO;
        if (aMJ(timeLineObject.Id)) {
            if (sVar.ixW != 0) {
                ol olVar = new ol();
                olVar.aWS(sVar.EpO.Id);
                if (1 != sVar.ixW) {
                    i3 = 17;
                }
                olVar.enl = 2;
                olVar.erW = (long) i3;
                aq.a(olVar);
            }
            h.INSTANCE.kvStat(10231, "1");
            com.tencent.mm.ay.a.bea();
        } else if (!com.tencent.mm.q.a.cC(brVar.context) && !com.tencent.mm.q.a.cA(brVar.context) && !com.tencent.mm.q.a.cE(brVar.context)) {
            h.INSTANCE.kvStat(10090, "1,0");
            if (timeLineObject.ContentObj.LoV.size() > 0) {
                cnb cnb = timeLineObject.ContentObj.LoV.get(0);
                if (brVar.source == 0) {
                    tP = k.tO(738);
                } else {
                    tP = k.tP(738);
                }
                k PH = tP.PH(timeLineObject.Id).PH(timeLineObject.UserName);
                if (timeLineObject.AppInfo == null) {
                    str = "";
                } else {
                    str = timeLineObject.AppInfo.Id;
                }
                PH.PH(str).PH(cnb.Title).PH(cnb.Desc).PH("");
                tP.bfK();
            }
            if (sVar.EpP) {
                com.tencent.mm.ay.a.a(com.tencent.mm.ay.i.a(aj.getAccPath(), timeLineObject, 9, null));
            } else {
                if (timeLineObject.ContentObj != null) {
                    css = timeLineObject.ContentObj.jfy;
                } else {
                    css = null;
                }
                com.tencent.mm.ay.a.c(com.tencent.mm.ay.i.a(aj.getAccPath(), timeLineObject, 1, com.tencent.mm.ay.h.a(timeLineObject.Id, css)));
            }
            if (sVar.ixW != 0) {
                ol olVar2 = new ol();
                olVar2.aWS(sVar.EpO.Id);
                if (1 == sVar.ixW) {
                    i2 = 1;
                } else {
                    i2 = 17;
                }
                olVar2.enl = 1;
                olVar2.erW = (long) i2;
                aq.a(olVar2);
            }
        }
        if (brVar.ERb != null) {
            brVar.ERb.dWI();
        }
        AppMethodBeat.o(99745);
    }
}
