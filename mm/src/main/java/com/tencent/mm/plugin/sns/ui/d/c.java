package com.tencent.mm.plugin.sns.ui.d;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.rw;
import com.tencent.mm.g.a.xv;
import com.tencent.mm.g.a.xw;
import com.tencent.mm.g.b.a.ab;
import com.tencent.mm.g.c.gk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.n.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.i.a.y;
import com.tencent.mm.plugin.l.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sight.decode.a.b;
import com.tencent.mm.plugin.sns.ad.g.k;
import com.tencent.mm.plugin.sns.ad.i.j;
import com.tencent.mm.plugin.sns.data.r;
import com.tencent.mm.plugin.sns.k.e;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.ai;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.au;
import com.tencent.mm.plugin.sns.model.bd;
import com.tencent.mm.plugin.sns.storage.ADInfo;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.AdSnsInfo;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.storage.y;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.SnsOnlineVideoActivity;
import com.tencent.mm.plugin.sns.ui.SnsSingleTextViewUI;
import com.tencent.mm.plugin.sns.ui.SnsTimeLineUI;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.ao;
import com.tencent.mm.plugin.sns.ui.at;
import com.tencent.mm.plugin.sns.ui.b.b.a;
import com.tencent.mm.plugin.sns.ui.b.b.b;
import com.tencent.mm.plugin.sns.ui.bc;
import com.tencent.mm.plugin.sns.ui.bg;
import com.tencent.mm.plugin.sns.ui.bk;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem;
import com.tencent.mm.plugin.sns.ui.item.a;
import com.tencent.mm.plugin.sns.ui.item.f;
import com.tencent.mm.plugin.sns.ui.item.n;
import com.tencent.mm.plugin.sns.ui.item.p;
import com.tencent.mm.plugin.sns.ui.s;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bcj;
import com.tencent.mm.protocal.protobuf.be;
import com.tencent.mm.protocal.protobuf.cjy;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dzo;
import com.tencent.mm.protocal.protobuf.dzx;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.tools.MaskImageButton;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.LinkedList;

public abstract class c {
    protected k EBv;
    public b.e EZJ;
    ai Epj;
    public View.OnClickListener Erh;
    public View.OnClickListener FaA;
    public View.OnClickListener FaB;
    public View.OnClickListener FaC;
    public View.OnClickListener FaD;
    public d FaE;
    public d FaF;
    public d FaG;
    public d FaH;
    public d FaI;
    public d FaJ;
    public d FaK;
    d FaL;
    public d FaM;
    public d FaN;
    public View.OnClickListener FaO;
    public View.OnClickListener FaP;
    public View.OnClickListener FaQ;
    public View.OnClickListener FaR;
    public View.OnClickListener FaS;
    public View.OnClickListener FaT;
    public View.OnClickListener FaU;
    public View.OnClickListener FaV;
    public View.OnClickListener FaW;
    public View.OnClickListener FaX;
    public View.OnClickListener FaY;
    public AdapterView.OnItemClickListener FaZ;
    volatile com.tencent.mm.plugin.sns.ui.b.b.b Fan;
    volatile a Fao;
    volatile com.tencent.mm.plugin.sns.ui.b.a.b Fap;
    volatile com.tencent.mm.plugin.sns.ui.b.a.a Faq;
    public b Far;
    public View.OnClickListener Fas;
    public View.OnLongClickListener Fat;
    public d Fau;
    public View.OnClickListener Fav;
    public View.OnClickListener Faw;
    public View.OnClickListener Fax;
    public View.OnClickListener Fay;
    public View.OnClickListener Faz;
    public AdapterView.OnItemClickListener Fba;
    public View.OnClickListener Fbb = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass1 */

        public final void onClick(View view) {
            boolean z;
            boolean z2 = false;
            AppMethodBeat.i(100199);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() == null) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100199);
                return;
            }
            SnsInfo fC = c.fC(view);
            if (fC == null || !fC.isAd()) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100199);
                return;
            }
            if (fC.getAdSnsInfo().getAdXml().hasVoteInfo()) {
                int kN = y.kN(fC.getAdSnsInfo().getAdXml().getAdVoteComponentUrl(), fC.getUxinfo());
                boolean z3 = kN > 0;
                String adVoteComponentUrl = fC.getAdSnsInfo().getAdXml().getAdVoteComponentUrl();
                String uxinfo = fC.getUxinfo();
                g.aAf();
                String ayV = com.tencent.mm.kernel.a.ayV();
                if (!z3) {
                    kN = 1;
                }
                y.b(adVoteComponentUrl, uxinfo, ayV, kN, z3 ? 0 : 1, "");
                if (!z3) {
                    z2 = true;
                }
                z = z2;
            } else {
                z = false;
            }
            TimeLineObject timeLine = fC.getTimeLine();
            if (timeLine.ContentObj.LoU == 15 && timeLine.sightFolded != 1) {
                c.a(c.this, view, fC, 1001, fC.getAdSnsInfo().getAdXml().getLeftCanvasInfo(), z);
            } else if ((timeLine.ContentObj.LoU == 1 && timeLine.ContentObj.LoV.size() == 1) || timeLine.ContentObj.LoU == 7) {
                c.b(c.this, view, fC, 1001, fC.getAdSnsInfo().getAdXml().getLeftCanvasInfo(), z);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100199);
        }
    };
    public View.OnClickListener Fbc = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass12 */

        public final void onClick(View view) {
            boolean z;
            boolean z2 = false;
            AppMethodBeat.i(100219);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (view.getTag() == null) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100219);
                return;
            }
            SnsInfo fC = c.fC(view);
            if (fC == null || !fC.isAd()) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100219);
                return;
            }
            if (fC.getAdSnsInfo().getAdXml().hasVoteInfo()) {
                int kN = y.kN(fC.getAdSnsInfo().getAdXml().getAdVoteComponentUrl(), fC.getUxinfo());
                boolean z3 = kN > 0;
                String adVoteComponentUrl = fC.getAdSnsInfo().getAdXml().getAdVoteComponentUrl();
                String uxinfo = fC.getUxinfo();
                g.aAf();
                String ayV = com.tencent.mm.kernel.a.ayV();
                if (!z3) {
                    kN = 2;
                }
                y.b(adVoteComponentUrl, uxinfo, ayV, kN, z3 ? 0 : 1, "");
                if (!z3) {
                    z2 = true;
                }
                z = z2;
            } else {
                z = false;
            }
            TimeLineObject timeLine = fC.getTimeLine();
            if (timeLine.ContentObj.LoU == 15 && timeLine.sightFolded != 1) {
                c.a(c.this, view, fC, 1002, fC.getAdSnsInfo().getAdXml().getRightCanvasInfo(), z);
            } else if ((timeLine.ContentObj.LoU == 1 && timeLine.ContentObj.LoV.size() == 1) || timeLine.ContentObj.LoU == 7) {
                c.b(c.this, view, fC, 1002, fC.getAdSnsInfo().getAdXml().getRightCanvasInfo(), z);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(100219);
        }
    };
    public View.OnClickListener Fbd;
    public bk.b Fbe;
    int Fbf;
    private IListener<xw> Fbg = new IListener<xw>() {
        /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass23 */

        {
            AppMethodBeat.i(160750);
            this.__eventId = xw.class.getName().hashCode();
            AppMethodBeat.o(160750);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xw xwVar) {
            AppMethodBeat.i(100237);
            xw xwVar2 = xwVar;
            Log.i("MicroMsg.TimelineClickListener", "receive timeline play click anim event");
            if (c.this.Fan != null) {
                final long j2 = xwVar2.eeh.gY;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass23.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(100234);
                        c.this.Fan.JW(j2);
                        c.this.Fan.a(new b.a() {
                            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass23.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.sns.ui.b.b.b.a
                            public final void onAnimationEnd() {
                                AppMethodBeat.i(100233);
                                Log.i("MicroMsg.TimelineClickListener", "timeline click animation end");
                                c.this.Fan = null;
                                AppMethodBeat.o(100233);
                            }
                        });
                        AppMethodBeat.o(100234);
                    }
                });
                AppMethodBeat.o(100237);
                return true;
            } else if (c.this.Fap != null) {
                final long j3 = xwVar2.eeh.gY;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass23.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(100236);
                        c.this.Fap.JW(j3);
                        c.this.Fap.a(new b.a() {
                            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass23.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.sns.ui.b.b.b.a
                            public final void onAnimationEnd() {
                                AppMethodBeat.i(100235);
                                Log.i("MicroMsg.TimelineClickListener", "detail click animation end");
                                c.this.Fap = null;
                                AppMethodBeat.o(100235);
                            }
                        });
                        AppMethodBeat.o(100236);
                    }
                });
                AppMethodBeat.o(100237);
                return true;
            } else {
                AppMethodBeat.o(100237);
                return false;
            }
        }
    };
    private IListener<xv> Fbh = new IListener<xv>() {
        /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass34 */

        {
            AppMethodBeat.i(160751);
            this.__eventId = xv.class.getName().hashCode();
            AppMethodBeat.o(160751);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xv xvVar) {
            AppMethodBeat.i(100255);
            xv xvVar2 = xvVar;
            Log.i("MicroMsg.TimelineClickListener", "receive timeline back anim event");
            if (c.this.Fao != null) {
                final long j2 = xvVar2.eeg.gY;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass34.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(100252);
                        if (c.this.activity instanceof SnsTimeLineUI) {
                            ((SnsTimeLineUI) c.this.activity).vx(true);
                        }
                        c.this.Fao.JW(j2);
                        c.this.Fao.a(new b.a() {
                            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass34.AnonymousClass1.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.sns.ui.b.b.b.a
                            public final void onAnimationEnd() {
                                AppMethodBeat.i(100251);
                                Log.i("MicroMsg.TimelineClickListener", "timeline back animation end");
                                c.this.Fao = null;
                                ((SnsTimeLineUI) c.this.activity).vx(false);
                                AppMethodBeat.o(100251);
                            }
                        });
                        AppMethodBeat.o(100252);
                    }
                });
                AppMethodBeat.o(100255);
                return true;
            } else if (c.this.Faq != null) {
                final long j3 = xvVar2.eeg.gY;
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass34.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(100254);
                        c.this.Faq.JW(j3);
                        c.this.Faq.a(new b.a() {
                            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass34.AnonymousClass2.AnonymousClass1 */

                            @Override // com.tencent.mm.plugin.sns.ui.b.b.b.a
                            public final void onAnimationEnd() {
                                AppMethodBeat.i(100253);
                                Log.i("MicroMsg.TimelineClickListener", "detail back animation end");
                                c.this.Faq = null;
                                AppMethodBeat.o(100253);
                            }
                        });
                        AppMethodBeat.o(100254);
                    }
                });
                AppMethodBeat.o(100255);
                return true;
            } else {
                AppMethodBeat.o(100255);
                return false;
            }
        }
    };
    public View.OnClickListener Fbi = new View.OnClickListener() {
        /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass39 */

        public final void onClick(View view) {
            MMImageView mMImageView;
            SnsInfo snsInfo;
            ADInfo a2;
            AppMethodBeat.i(203975);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Object tag = view.getTag();
            TagImageView tagImageView = null;
            if (tag instanceof BaseTimeLineItem.BaseViewHolder) {
                BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
                SnsInfo aQl = f.aQl(baseViewHolder.dRS);
                mMImageView = null;
                tagImageView = baseViewHolder.EWG;
                snsInfo = aQl;
            } else if (tag instanceof SnsInfo) {
                mMImageView = (MMImageView) view.getTag(R.id.ec_);
                snsInfo = (SnsInfo) tag;
            } else {
                mMImageView = null;
                snsInfo = null;
            }
            if (snsInfo != null) {
                AdSnsInfo adSnsInfo = snsInfo.getAdSnsInfo();
                int source = adSnsInfo.getSource();
                if (snsInfo != null && snsInfo.isAd()) {
                    ADInfo a3 = c.a(c.this, snsInfo);
                    if (snsInfo.getAdXml().isLandingPagesAd() && i.aQg(snsInfo.getAdSnsInfo().field_adxml)) {
                        String Q = i.Q(snsInfo);
                        if (!Util.isNullOrNil(Q)) {
                            adSnsInfo.field_adxml = Q;
                        }
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (tagImageView != null) {
                            tagImageView.getLocationInWindow(iArr);
                            width = tagImageView.getWidth();
                            height = tagImageView.getHeight();
                        } else if (mMImageView != null) {
                            mMImageView.getLocationInWindow(iArr);
                            width = mMImageView.getWidth();
                            height = mMImageView.getHeight();
                        }
                        Intent intent = new Intent();
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        intent.putExtra("sns_landing_pages_share_sns_id", snsInfo.getSnsId());
                        intent.putExtra("sns_landing_pages_rawSnsId", snsInfo.getTimeLine().Id);
                        intent.putExtra("sns_landing_pages_ux_info", snsInfo.getUxinfo());
                        TimeLineObject timeLine = snsInfo.getTimeLine();
                        if (timeLine != null) {
                            LinkedList<cnb> linkedList = timeLine.ContentObj.LoV;
                            if (linkedList.size() > 0) {
                                intent.putExtra("sns_landing_pages_share_thumb_url", linkedList.get(0).Msz);
                            }
                        }
                        intent.setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
                        int i2 = 9;
                        if (source == 2) {
                            i2 = 16;
                        } else if (source == 1) {
                            i2 = 10;
                        }
                        intent.putExtra("sns_landig_pages_from_source", i2);
                        intent.putExtra("sns_landing_pages_xml", snsInfo.getAdSnsInfo().field_adxml);
                        intent.putExtra("sns_landing_pages_rec_src", snsInfo.getAdRecSrc());
                        intent.putExtra("sns_landing_pages_xml_prefix", com.tencent.mm.g.c.f.COL_ADXML);
                        intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                        intent.putExtra("sns_landing_is_native_sight_ad", true);
                        Activity activity = c.this.activity;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        activity.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        c.this.activity.overridePendingTransition(0, 0);
                        r.a(new SnsAdClick(source, source == 0 ? 1 : 2, snsInfo.field_snsId, 23, 21));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(203975);
                        return;
                    } else if (a3 != null && a3.adActionType == 1) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("key_card_id", a3.adActionCardTpId);
                        intent2.putExtra("key_card_ext", a3.adActionCardExt);
                        intent2.putExtra("key_from_scene", 21);
                        intent2.putExtra("key_stastic_scene", 15);
                        com.tencent.mm.br.c.b(c.this.activity, "card", ".ui.CardDetailUI", intent2);
                        r.a(new SnsAdClick(source, source == 0 ? 1 : 2, snsInfo.field_snsId, 23, 11));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(203975);
                        return;
                    } else if (c.a(c.this, a3, snsInfo, false)) {
                        r.a(new SnsAdClick(source, source == 0 ? 1 : 2, snsInfo.field_snsId, 23, 31));
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(203975);
                        return;
                    }
                }
                SnsAdClick snsAdClick = new SnsAdClick(source, source == 0 ? 1 : 2, snsInfo.field_snsId, 23, 0);
                r.a(snsAdClick);
                String adInfoLink = snsInfo.getAdInfoLink();
                if (Util.isNullOrNil(adInfoLink)) {
                    adInfoLink = snsInfo.getAdLink();
                }
                Log.i("MicroMsg.TimelineClickListener", "adlink url " + adInfoLink + " " + snsInfo.getAdXml().webrightBar);
                Intent intent3 = new Intent();
                boolean z = snsInfo.getAdXml().webrightBar == 0;
                if (ac.jOL) {
                    z = false;
                }
                if (!(snsInfo == null || !snsInfo.isAd() || (a2 = c.a(c.this, snsInfo)) == null)) {
                    intent3.putExtra("KsnsViewId", a2.viewId);
                    adInfoLink = r.kb(adInfoLink, a2.uxInfo);
                    r.h(intent3, a2.uxInfo);
                }
                intent3.putExtra("KRightBtn", z);
                Bundle bundle = new Bundle();
                bundle.putParcelable("KSnsAdTag", snsAdClick);
                bundle.putString("key_snsad_statextstr", adSnsInfo.getTimeLine().statExtStr);
                intent3.putExtra("jsapiargs", bundle);
                intent3.putExtra("rawUrl", adInfoLink);
                intent3.putExtra("useJs", true);
                intent3.putExtra("srcUsername", snsInfo.field_userName);
                intent3.putExtra("stastic_scene", 15);
                intent3.putExtra("KPublisherId", "sns_" + r.Jb(snsInfo.field_snsId));
                intent3.putExtra("pre_username", snsInfo.field_userName);
                intent3.putExtra("prePublishId", "sns_" + r.Jb(snsInfo.field_snsId));
                intent3.putExtra("preUsername", snsInfo.field_userName);
                com.tencent.mm.plugin.sns.c.a.jRt.i(intent3, c.this.activity);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$44", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(203975);
        }
    };
    Activity activity;
    int source = 0;
    public View.OnTouchListener uwC;

    public abstract void dS(Object obj);

    public abstract void ffw();

    public abstract void ffx();

    public abstract void ffy();

    public abstract void ffz();

    public abstract void fo(View view);

    public abstract void fp(View view);

    public abstract void fq(View view);

    public abstract void fr(View view);

    public abstract void fs(View view);

    public abstract void ft(View view);

    public abstract void fu(View view);

    public c(int i2, Activity activity2, ai aiVar) {
        this.source = i2;
        this.activity = activity2;
        this.Epj = aiVar;
        this.Fbf = Util.getInt(h.aqJ().getValue("SnsPOICommentFeedNewUrlSwitch"), 0);
        Log.i("MicroMsg.TimelineClickListener", "init POIComment_FeedNewUrl_Switch:%d", Integer.valueOf(this.Fbf));
        this.Far = new b(this.activity, this.source, this.Epj);
        this.FaC = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass40 */

            /* JADX WARNING: Code restructure failed: missing block: B:60:0x02ac, code lost:
                if (com.tencent.mm.sdk.platformtools.Util.isNullOrNil(r0) == false) goto L_0x02ae;
             */
            /* JADX WARNING: Removed duplicated region for block: B:120:0x05e1  */
            /* JADX WARNING: Removed duplicated region for block: B:121:0x05e4  */
            /* JADX WARNING: Removed duplicated region for block: B:63:0x02ba  */
            /* JADX WARNING: Removed duplicated region for block: B:66:0x0301  */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x0306  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(android.view.View r11) {
                /*
                // Method dump skipped, instructions count: 1514
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass40.onClick(android.view.View):void");
            }
        };
        this.FaP = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass41 */

            public final void onClick(View view) {
                com.tencent.mm.modelsns.k tP;
                com.tencent.mm.modelsns.k tP2;
                ADInfo a2;
                AppMethodBeat.i(100259);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!(view.getTag() instanceof String)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(100259);
                    return;
                }
                SnsInfo aQm = aj.faO().aQm((String) view.getTag());
                if (aQm == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(100259);
                    return;
                }
                final TimeLineObject timeLine = aQm.getTimeLine();
                final cjy cjy = timeLine.Location;
                if (aQm.isAd()) {
                    Log.i("MicroMsg.TimelineClickListener", "click the ad poi button");
                    ADInfo a3 = c.a(c.this, aQm);
                    if (a3 == null) {
                        Log.e("MicroMsg.TimelineClickListener", "the adInfo is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(100259);
                        return;
                    }
                    SnsAdClick snsAdClick = new SnsAdClick(c.this.source, c.this.source == 0 ? 1 : 2, aQm.field_snsId, 19, 0);
                    com.tencent.mm.plugin.sns.data.k.a(snsAdClick, c.this.EBv, aQm, 19);
                    r.a(snsAdClick);
                    if (Util.isNullOrNil(a3.adActionPOILink)) {
                        Log.e("MicroMsg.TimelineClickListener", "the adActionPOILink is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(100259);
                        return;
                    }
                    if (c.this.source == 0) {
                        tP2 = com.tencent.mm.modelsns.k.tO(724);
                    } else {
                        tP2 = com.tencent.mm.modelsns.k.tP(724);
                    }
                    tP2.PH(r.v(aQm)).tR(aQm.field_type).fL(aQm.isAd()).PH(aQm.getUxinfo()).PH("").PH("").PH("").PH("").PH(a3.adActionPOIName).PH("").PH("");
                    tP2.bfK();
                    Log.i("MicroMsg.TimelineClickListener", "open webview url : " + a3.adActionPOILink);
                    Intent intent = new Intent();
                    if (!(aQm == null || !aQm.isAd() || (a2 = c.a(c.this, aQm)) == null)) {
                        intent.putExtra("KsnsViewId", a2.viewId);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("KSnsAdTag", snsAdClick);
                    intent.putExtra("jsapiargs", bundle);
                    intent.putExtra("useJs", true);
                    intent.putExtra("KPublisherId", "sns_" + r.Jb(aQm.field_snsId));
                    intent.putExtra("pre_username", aQm.field_userName);
                    intent.putExtra("prePublishId", "sns_" + r.Jb(aQm.field_snsId));
                    intent.putExtra("preUsername", aQm.field_userName);
                    intent.putExtra("rawUrl", r.kb(a3.adActionPOILink, a3.uxInfo));
                    com.tencent.mm.plugin.sns.c.a.jRt.i(intent, c.this.activity);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(100259);
                    return;
                }
                if (c.this.source == 0) {
                    tP = com.tencent.mm.modelsns.k.tO(724);
                } else {
                    tP = com.tencent.mm.modelsns.k.tP(724);
                }
                tP.PH(r.v(aQm)).tR(aQm.field_type).fL(aQm.isAd()).PH(aQm.getUxinfo()).PH(cjy.LIb).tR(cjy.Esb).PH(new StringBuilder().append(cjy.LbD).toString()).PH(new StringBuilder().append(cjy.LbC).toString()).PH(cjy.kHV).PH(cjy.ErZ).PH(cjy.kea);
                tP.bfK();
                final Intent intent2 = new Intent();
                eaa eaa = new eaa();
                eaa.LbC = cjy.LbC;
                eaa.LbD = cjy.LbD;
                eaa.kea = cjy.kea;
                eaa.kHV = cjy.kHV;
                eaa.ErZ = cjy.ErZ;
                eaa.LIb = cjy.LIb;
                eaa.Esb = cjy.Esb;
                eaa.Mpt = cjy.Mpt;
                eaa.Mpu = cjy.Mpu;
                eaa.Mpv = cjy.Mpv;
                eaa.Esd = cjy.Esd;
                ((com.tencent.mm.plugin.i.a.y) g.af(com.tencent.mm.plugin.i.a.y.class)).a(eaa, y.a.FINDER_POI_FROM_TYPE_SNS, timeLine.Id, new y.c() {
                    /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass41.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.i.a.y.c
                    public final void a(y.b bVar) {
                        boolean z;
                        String format;
                        AppMethodBeat.i(203976);
                        if (bVar == y.b.FINDER_POI_REDIRECT_TYPE_DEFAULT) {
                            z = !Util.isNullOrNil(cjy.LIb);
                        } else if (bVar == y.b.FINDER_POI_REDIRECT_TYPE_MAP) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (!z) {
                            intent2.putExtra("map_view_type", 7);
                            intent2.putExtra("kwebmap_slat", (double) cjy.LbD);
                            intent2.putExtra("kwebmap_lng", (double) cjy.LbC);
                            intent2.putExtra("kPoiName", cjy.kHV);
                            intent2.putExtra("Kwebmap_locaion", cjy.ErZ);
                            com.tencent.mm.br.c.b(c.this.activity, FirebaseAnalytics.b.LOCATION, ".ui.RedirectUI", intent2);
                            AppMethodBeat.o(203976);
                            return;
                        }
                        if (c.this.Fbf == 0) {
                            format = String.format(d.KyX, cjy.LIb);
                        } else {
                            format = String.format(d.KyY, cjy.LIb, timeLine.Id);
                        }
                        intent2.putExtra("rawUrl", format);
                        com.tencent.mm.plugin.sns.c.a.jRt.i(intent2, c.this.activity);
                        AppMethodBeat.o(203976);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100259);
            }
        };
        this.FaT = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass42 */

            public final void onClick(View view) {
                AppMethodBeat.i(100260);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!(view.getTag() instanceof String)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(100260);
                    return;
                }
                SnsInfo aQm = aj.faO().aQm((String) view.getTag());
                if (aQm == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(100260);
                } else if (aQm.isAd()) {
                    Log.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
                    ADInfo a2 = c.a(c.this, aQm);
                    if (a2 == null) {
                        Log.e("MicroMsg.TimelineClickListener", "the adInfo is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(100260);
                    } else if (Util.isNullOrNil(a2.adActionExtTailLink)) {
                        Log.e("MicroMsg.TimelineClickListener", "the adActionExtTailLink is null");
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(100260);
                    } else {
                        Log.i("MicroMsg.TimelineClickListener", "open webview url : " + a2.adActionExtTailLink);
                        Intent intent = new Intent();
                        intent.putExtra("jsapiargs", new Bundle());
                        intent.putExtra("useJs", true);
                        String kb = r.kb(a2.adActionExtTailLink, a2.uxInfo);
                        r.h(intent, a2.uxInfo);
                        intent.putExtra("rawUrl", kb);
                        com.tencent.mm.plugin.sns.c.a.jRt.i(intent, c.this.activity);
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(100260);
                    }
                } else {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(100260);
                }
            }
        };
        this.FaU = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass43 */

            public final void onClick(View view) {
                AppMethodBeat.i(100261);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getTag() instanceof BaseTimeLineItem.BaseViewHolder) {
                    SnsInfo aQm = aj.faO().aQm(((BaseTimeLineItem.BaseViewHolder) view.getTag()).dHp);
                    if (aQm == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(100261);
                        return;
                    } else if (aQm.isAd()) {
                        Log.i("MicroMsg.TimelineClickListener", "click the ad tailLink button");
                        SnsAdClick snsAdClick = new SnsAdClick(c.this.source, c.this.source == 0 ? 1 : 2, aQm.field_snsId, 24, 0);
                        com.tencent.mm.plugin.sns.data.k.a(snsAdClick, c.this.EBv, aQm, 24);
                        r.a(snsAdClick);
                        c.this.fp(view);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100261);
            }
        };
        this.Fas = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass44 */

            public final void onClick(View view) {
                SnsInfo snsInfo;
                boolean z;
                com.tencent.mm.modelsns.k tP;
                com.tencent.mm.modelsns.k tP2;
                AppMethodBeat.i(100262);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String str = (String) view.getTag();
                Log.d("MicroMsg.TimelineClickListener", "onCommentClick:".concat(String.valueOf(str)));
                Intent intent = new Intent();
                if (!(view instanceof MaskImageButton) || ((MaskImageButton) view).ico == null) {
                    snsInfo = null;
                    z = false;
                } else {
                    SnsInfo aQm = aj.faO().aQm((String) ((MaskImageButton) view).ico);
                    if (aQm == null || !aQm.isAd()) {
                        snsInfo = aQm;
                        z = false;
                    } else {
                        ADXml adXml = aQm.getAdXml();
                        SnsAdClick snsAdClick = new SnsAdClick(c.this.source, c.this.source == 0 ? 1 : 2, aQm.field_snsId, 1, 0);
                        com.tencent.mm.plugin.sns.data.k.a(snsAdClick, c.this.EBv, aQm, 1);
                        if (adXml != null) {
                            if (adXml.headClickType == 1 && !Util.isNullOrNil(adXml.headClickParam)) {
                                String str2 = adXml.headClickParam;
                                ADInfo a2 = c.a(c.this, aQm);
                                if (a2 != null) {
                                    str2 = r.kb(str2, a2.uxInfo);
                                }
                                Log.i("MicroMsg.TimelineClickListener", "headClickParam url " + str2 + " " + adXml.headClickRightBarShow);
                                Intent intent2 = new Intent();
                                boolean z2 = adXml.headClickRightBarShow == 0;
                                intent2.putExtra("KsnsViewId", c.a(c.this, aQm).viewId);
                                intent2.putExtra("KRightBtn", z2);
                                intent2.putExtra("jsapiargs", new Bundle());
                                intent2.putExtra("rawUrl", str2);
                                intent2.putExtra("useJs", true);
                                com.tencent.mm.plugin.sns.c.a.jRt.i(intent2, c.this.activity);
                                r.a(snsAdClick);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(100262);
                                return;
                            } else if (com.tencent.mm.plugin.sns.ad.e.h.b(c.this.activity, adXml, c.a(c.this, aQm), aQm.field_snsId, 1)) {
                                j.a(snsAdClick, 41);
                                r.a(snsAdClick);
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(100262);
                                return;
                            } else {
                                com.tencent.mm.plugin.sns.ad.timeline.a.d dVar = new com.tencent.mm.plugin.sns.ad.timeline.a.d();
                                dVar.put("ext_sns_ad_click", (Object) snsAdClick);
                                com.tencent.mm.plugin.sns.ad.timeline.a.c d2 = com.tencent.mm.plugin.sns.ad.timeline.a.a.d(1, c.this.activity);
                                if (d2 != null && d2.a(view, c.this.source, aQm, dVar)) {
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(100262);
                                    return;
                                }
                            }
                        }
                        snsInfo = aQm;
                        z = true;
                    }
                }
                if (str.endsWith("@ad")) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(100262);
                    return;
                }
                if (snsInfo != null) {
                    if (c.this.source == 0) {
                        tP2 = com.tencent.mm.modelsns.k.tO(snsInfo.isAd() ? 722 : 721);
                    } else {
                        tP2 = com.tencent.mm.modelsns.k.tP(snsInfo.isAd() ? 722 : 721);
                    }
                    tP2.PH(r.v(snsInfo)).tR(snsInfo.field_type).fL(snsInfo.isAd()).PH(snsInfo.getUxinfo()).PH(str);
                    tP2.bfK();
                }
                if (z) {
                    SnsAdClick snsAdClick2 = new SnsAdClick(c.this.source, c.this.source == 0 ? 1 : 2, snsInfo.field_snsId, 1, 40);
                    com.tencent.mm.plugin.sns.data.k.a(snsAdClick2, c.this.EBv, snsInfo, 1);
                    intent.putExtra("Contact_User", str);
                    intent.putExtra("KSnsAdTag", snsAdClick2);
                    intent.putExtra("Contact_Scene", 78);
                    intent.putExtra("CONTACT_INFO_UI_SOURCE", c.this.source == 0 ? 6 : 1);
                    com.tencent.mm.plugin.sns.c.a.jRt.c(intent, c.this.activity);
                    Log.i("MicroMsg.TimelineClickListener", "startContactInfo, addScene=78");
                    r.a(snsAdClick2);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(100262);
                    return;
                }
                c.this.Epj.fat().e(snsInfo, true);
                if (c.this.source == 0) {
                    tP = com.tencent.mm.modelsns.k.tO(746);
                } else {
                    tP = com.tencent.mm.modelsns.k.tP(746);
                }
                tP.PH(str).fL(str.endsWith(z.aTY()));
                tP.b(intent, "intent_key_StatisticsOplog");
                intent.putExtra("CONTACT_INFO_UI_SOURCE", c.this.source == 0 ? 6 : 1);
                intent.putExtra("Contact_User", str);
                com.tencent.mm.plugin.sns.c.a.jRt.c(intent, c.this.activity);
                ((com.tencent.mm.plugin.textstatus.a.c) g.ah(com.tencent.mm.plugin.textstatus.a.c.class)).report22210(str, 6);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100262);
            }
        };
        this.Fat = new View.OnLongClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass2 */

            public final boolean onLongClick(View view) {
                final String str;
                boolean z;
                int[] iArr;
                AppMethodBeat.i(100202);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
                final String str2 = (String) view.getTag();
                Log.d("MicroMsg.TimelineClickListener", "onCommentLongClick:".concat(String.valueOf(str2)));
                if (Util.isNullOrNil(str2)) {
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(100202);
                    return true;
                } else if (str2.equals(aj.fau())) {
                    com.tencent.mm.hellhoundlib.a.a.a(true, (Object) this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(100202);
                    return true;
                } else {
                    if (((MaskImageButton) view).ico == null || !(((MaskImageButton) view).ico instanceof String)) {
                        str = "";
                    } else {
                        str = (String) ((MaskImageButton) view).ico;
                    }
                    new Intent();
                    final SnsInfo aQm = aj.faO().aQm(str);
                    if (aQm == null || !aQm.isAd()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (z) {
                        com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                        AppMethodBeat.o(100202);
                        return false;
                    }
                    int[] iArr2 = new int[2];
                    if (view.getTag(R.id.iu_) instanceof int[]) {
                        iArr = (int[]) view.getTag(R.id.iu_);
                    } else {
                        iArr = iArr2;
                    }
                    new com.tencent.mm.ui.widget.b.a(c.this.activity).a(view, new View.OnCreateContextMenuListener() {
                        /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass2.AnonymousClass1 */

                        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                            AppMethodBeat.i(100200);
                            g.aAi();
                            as bjK = ((l) g.af(l.class)).aSN().bjK(aQm.getUserName());
                            boolean z = ((com.tencent.mm.plugin.zero.b.a) g.af(com.tencent.mm.plugin.zero.b.a.class)).aqJ().getInt("MMSocialBlackListFlag", BuildInfo.DEBUG ? 1 : 0) == 1;
                            if (bjK == null || aQm == null || !as.bjp(aQm.getUserName()) || !"3552365301".equals(bjK.field_openImAppid)) {
                                contextMenu.add(0, 0, 0, z ? c.this.activity.getString(R.string.bdf) : c.this.activity.getString(R.string.bdg));
                            } else {
                                contextMenu.add(0, 0, 0, z ? c.this.activity.getString(R.string.bdf) : c.this.activity.getString(R.string.bdh));
                            }
                            contextMenu.add(1, 1, 0, c.this.activity.getString(R.string.hb1));
                            AppMethodBeat.o(100200);
                        }
                    }, new o.g() {
                        /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass2.AnonymousClass2 */

                        @Override // com.tencent.mm.ui.base.o.g
                        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                            long j2 = 0;
                            AppMethodBeat.i(100201);
                            switch (menuItem.getItemId()) {
                                case 0:
                                    Intent intent = new Intent();
                                    if (aQm != null) {
                                        j2 = aQm.field_snsId;
                                    }
                                    intent.putExtra("sns_permission_snsinfo_svr_id", j2);
                                    intent.putExtra("sns_permission_userName", str2);
                                    intent.putExtra("sns_permission_anim", true);
                                    intent.putExtra("sns_permission_block_scene", 5);
                                    com.tencent.mm.br.c.b(c.this.activity, Scopes.PROFILE, ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_set_default_chatonly, 0) == 0 ? ".ui.PermissionSettingUI" : ".ui.PermissionSettingUI2", intent, 11);
                                    AppMethodBeat.o(100201);
                                    return;
                                case 1:
                                    Intent intent2 = new Intent();
                                    SnsInfo aQm = aj.faO().aQm(str);
                                    if (aQm != null) {
                                        Log.i("MicroMsg.TimelineClickListener", "expose id " + aQm.getSnsId() + " " + aQm.field_userName);
                                        if (aQm != null) {
                                            j2 = aQm.field_snsId;
                                        }
                                        intent2.putExtra("k_expose_msg_id", j2);
                                        intent2.putExtra("k_username", aQm == null ? "" : aQm.field_userName);
                                        intent2.putExtra("showShare", false);
                                        intent2.putExtra("rawUrl", String.format(e.C2115e.OyU, 33));
                                        com.tencent.mm.br.c.b(c.this.activity, "webview", ".ui.tools.WebViewUI", intent2);
                                        g.aAi();
                                        as bjK = ((l) g.af(l.class)).aSN().bjK(aQm.getUserName());
                                        if (bjK != null && aQm != null && as.bjp(aQm.getUserName()) && "3552365301".equals(bjK.field_openImAppid)) {
                                            com.tencent.mm.plugin.sns.k.e eVar = com.tencent.mm.plugin.sns.k.e.DUQ;
                                            com.tencent.mm.plugin.sns.k.e.aPR(aQm.getUserName());
                                            break;
                                        }
                                    } else {
                                        Log.i("MicroMsg.TimelineClickListener", "error get snsinfo by id " + str);
                                        AppMethodBeat.o(100201);
                                        return;
                                    }
                            }
                            AppMethodBeat.o(100201);
                        }
                    }, iArr[0], iArr[1]);
                    com.tencent.mm.hellhoundlib.a.a.a(false, (Object) this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$10", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
                    AppMethodBeat.o(100202);
                    return false;
                }
            }
        };
        this.Fau = new d() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass3 */

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final void a(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                int i2;
                AppMethodBeat.i(100203);
                bg bgVar = (bg) view.getTag();
                SnsInfo aQl = aj.faO().aQl(bgVar.dRS);
                if (aQl == null) {
                    AppMethodBeat.o(100203);
                    return;
                }
                contextMenu.add(0, 0, 0, c.this.activity.getString(R.string.t_));
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    contextMenu.add(0, 1, 0, c.this.activity.getString(R.string.fn9));
                }
                TimeLineObject timeLine = aQl.getTimeLine();
                if (bgVar.EHG || !(timeLine == null || timeLine.contentDescShowType == 1 || bgVar.EHH)) {
                    if (!bgVar.fiA()) {
                        au.a(contextMenu, true);
                    } else {
                        au.b(contextMenu, true);
                    }
                }
                com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, aQl);
                if (((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenFingerSearch() && ((c.this.activity instanceof SnsTimeLineUI) || (c.this.activity instanceof SnsCommentDetailUI))) {
                    contextMenu.add(0, 27, 0, c.this.activity.getString(R.string.cf_));
                    String nullAs = Util.nullAs(aQl.getTimeLine().ContentDesc, "");
                    if (c.this.activity instanceof SnsTimeLineUI) {
                        i2 = 3;
                    } else {
                        i2 = 5;
                    }
                    ar.a(1, com.tencent.mm.plugin.fts.a.d.Nj(77), 77, 0, "", "", r.Jb(aQl.field_snsId), i2, "", 0, (long) nullAs.length());
                }
                AppMethodBeat.o(100203);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final boolean fD(View view) {
                AppMethodBeat.i(100204);
                if (view.getTag() instanceof bg) {
                    SnsInfo aQl = aj.faO().aQl(((bg) view.getTag()).dRS);
                    if (aQl == null) {
                        AppMethodBeat.o(100204);
                        return false;
                    }
                    c.this.Far.a(view, aQl.getLocalid(), aQl.getTimeLine());
                    AppMethodBeat.o(100204);
                    return true;
                }
                AppMethodBeat.o(100204);
                return false;
            }
        };
        this.FaJ = new d() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass4 */

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final boolean fD(View view) {
                SnsInfo snsInfo;
                AppMethodBeat.i(100205);
                if ((view.getTag() instanceof BaseTimeLineItem.BaseViewHolder) || (view.getTag() instanceof SnsInfo) || (view.getTag() instanceof at) || (view.getTag() instanceof bc) || (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                    Object tag = view.getTag();
                    if (tag instanceof BaseTimeLineItem.BaseViewHolder) {
                        snsInfo = f.aQl(((BaseTimeLineItem.BaseViewHolder) view.getTag()).dRS);
                    } else if (tag instanceof SnsInfo) {
                        snsInfo = (SnsInfo) tag;
                    } else if (tag instanceof at) {
                        snsInfo = aj.faO().aQm(((at) tag).dHp);
                    } else if (view.getTag() instanceof bc) {
                        snsInfo = aj.faO().aQm(((bc) view.getTag()).dJX);
                    } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                        snsInfo = ((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag()).DsC;
                    } else {
                        snsInfo = null;
                    }
                    if (snsInfo != null) {
                        if (!snsInfo.isAd()) {
                            AppMethodBeat.o(100205);
                            return false;
                        } else if (snsInfo.getAdXml() == null || !snsInfo.getAdXml().isCardAd()) {
                            AppMethodBeat.o(100205);
                            return false;
                        } else {
                            c.this.Far.a(view, snsInfo.getLocalid(), snsInfo.getTimeLine());
                        }
                    }
                    AppMethodBeat.o(100205);
                    return true;
                }
                AppMethodBeat.o(100205);
                return false;
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final void a(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                SnsInfo snsInfo;
                AppMethodBeat.i(100206);
                Object tag = view.getTag();
                if ((tag instanceof BaseTimeLineItem.BaseViewHolder) || (tag instanceof SnsInfo) || (tag instanceof at) || (tag instanceof bc) || (tag instanceof com.tencent.mm.plugin.sns.ui.c.a.a)) {
                    if (tag instanceof BaseTimeLineItem.BaseViewHolder) {
                        snsInfo = f.aQl(((BaseTimeLineItem.BaseViewHolder) tag).dRS);
                    } else if (tag instanceof SnsInfo) {
                        snsInfo = (SnsInfo) tag;
                    } else if (tag instanceof at) {
                        snsInfo = aj.faO().aQm(((at) tag).dHp);
                    } else if (view.getTag() instanceof bc) {
                        snsInfo = aj.faO().aQm(((bc) view.getTag()).dJX);
                    } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                        snsInfo = ((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag()).DsC;
                    } else {
                        snsInfo = null;
                    }
                    if (!snsInfo.isAd()) {
                        AppMethodBeat.o(100206);
                        return;
                    } else if (snsInfo.getAdXml() == null || !snsInfo.getAdXml().isCardAd()) {
                        AppMethodBeat.o(100206);
                        return;
                    } else if (c.a(c.this, snsInfo).actionExtWeApp != null) {
                        AppMethodBeat.o(100206);
                        return;
                    } else if (com.tencent.mm.plugin.sns.ad.e.h.a(snsInfo.getAdXml(), snsInfo.getAdInfo())) {
                        AppMethodBeat.o(100206);
                        return;
                    } else {
                        if (com.tencent.mm.br.c.aZU("favorite")) {
                            if (snsInfo.getAdXml().isCardAd()) {
                                contextMenu.add(0, 20, 0, view.getContext().getString(R.string.fn9));
                            }
                            ef efVar = new ef();
                            efVar.dHy.dHp = snsInfo.getLocalid();
                            EventCenter.instance.publish(efVar);
                            if (efVar.dHz.dGX) {
                                contextMenu.add(0, 18, 0, view.getContext().getString(R.string.xa));
                            }
                        }
                        if (snsInfo != null) {
                            com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, snsInfo);
                        }
                    }
                }
                AppMethodBeat.o(100206);
            }
        };
        this.FaK = new d() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass5 */

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final boolean fD(View view) {
                SnsInfo snsInfo;
                AppMethodBeat.i(100207);
                if ((view.getTag() instanceof BaseTimeLineItem.BaseViewHolder) || (view.getTag() instanceof SnsInfo)) {
                    Object tag = view.getTag();
                    if (tag instanceof BaseTimeLineItem.BaseViewHolder) {
                        snsInfo = f.aQl(((BaseTimeLineItem.BaseViewHolder) view.getTag()).dRS);
                    } else if (tag instanceof SnsInfo) {
                        snsInfo = (SnsInfo) tag;
                    } else {
                        snsInfo = null;
                    }
                    if (snsInfo != null) {
                        c.this.Far.a(view, snsInfo.getLocalid(), snsInfo.getTimeLine());
                    }
                    AppMethodBeat.o(100207);
                    return true;
                }
                AppMethodBeat.o(100207);
                return false;
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final void a(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                SnsInfo snsInfo;
                AppMethodBeat.i(100208);
                Object tag = view.getTag();
                if ((tag instanceof BaseTimeLineItem.BaseViewHolder) || (tag instanceof SnsInfo)) {
                    if (tag instanceof BaseTimeLineItem.BaseViewHolder) {
                        snsInfo = f.aQl(((BaseTimeLineItem.BaseViewHolder) tag).dRS);
                    } else if (tag instanceof SnsInfo) {
                        snsInfo = (SnsInfo) tag;
                    } else {
                        snsInfo = null;
                    }
                    if (com.tencent.mm.br.c.aZU("favorite")) {
                        ADXml adXml = snsInfo.getAdXml();
                        ADInfo a2 = c.a(c.this, snsInfo);
                        if (adXml.isLinkAd()) {
                            if (adXml.isLandingPagesAd()) {
                                contextMenu.add(0, 2, 0, view.getContext().getString(R.string.fn9));
                            } else if (a2.adActionType == 0) {
                                contextMenu.add(0, 3, 0, view.getContext().getString(R.string.fn9));
                            }
                        }
                        ef efVar = new ef();
                        efVar.dHy.dHp = snsInfo.getLocalid();
                        EventCenter.instance.publish(efVar);
                        if (efVar.dHz.dGX) {
                            contextMenu.add(0, 18, 0, view.getContext().getString(R.string.xa));
                        }
                    }
                    if (snsInfo != null) {
                        com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, snsInfo);
                    }
                }
                AppMethodBeat.o(100208);
            }
        };
        this.FaG = new d() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass6 */

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final void a(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(100209);
                if (view.getTag() instanceof s) {
                    c.this.FaL.onCreateContextMenu(contextMenu, view, contextMenuInfo);
                }
                AppMethodBeat.o(100209);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final boolean fD(View view) {
                AppMethodBeat.i(100210);
                if (view.getTag() instanceof s) {
                    String str = ((s) view.getTag()).dHp;
                    c.this.Far.a(view, str, aj.faO().aQm(str).getTimeLine());
                    AppMethodBeat.o(100210);
                    return true;
                }
                AppMethodBeat.o(100210);
                return false;
            }
        };
        this.FaM = new d() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass7 */

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final void a(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(100211);
                if (com.tencent.mm.br.c.aZU("favorite")) {
                    contextMenu.add(0, 24, 0, view.getContext().getString(R.string.fn9));
                }
                AppMethodBeat.o(100211);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final boolean fD(View view) {
                AppMethodBeat.i(100212);
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.ai) {
                    String str = ((com.tencent.mm.plugin.sns.ui.ai) view.getTag()).dHp;
                    c.this.Far.a(view, str, aj.faO().aQm(str).getTimeLine());
                    AppMethodBeat.o(100212);
                    return true;
                }
                AppMethodBeat.o(100212);
                return false;
            }
        };
        this.FaF = new d() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass8 */

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final void a(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                int i2;
                int i3;
                int i4;
                AppMethodBeat.i(100214);
                if (view != null && (view.getTag() instanceof bc)) {
                    bc bcVar = (bc) view.getTag();
                    String str = bcVar.dJX;
                    SnsInfo aQm = aj.faO().aQm(str);
                    if (com.tencent.mm.br.c.aZU("favorite")) {
                        contextMenu.add(0, 2, 0, c.this.activity.getString(R.string.fn9));
                        ef efVar = new ef();
                        efVar.dHy.dHp = str;
                        EventCenter.instance.publish(efVar);
                        if (efVar.dHz.dGX) {
                            contextMenu.add(0, 18, 0, c.this.activity.getString(R.string.xa));
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, aQm);
                    MenuItem add = contextMenu.add(0, 21, 0, c.this.activity.getString(R.string.h5w));
                    int[] iArr = new int[2];
                    if (view != null) {
                        i3 = view.getWidth();
                        i2 = view.getHeight();
                        view.getLocationInWindow(iArr);
                    } else {
                        i2 = 0;
                        i3 = 0;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("img_gallery_width", i3).putExtra("img_gallery_height", i2).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                    add.setIntent(intent);
                    if (((com.tencent.mm.plugin.websearch.api.c) g.ah(com.tencent.mm.plugin.websearch.api.c.class)).isOpenImageSearch() && ((c.this.activity instanceof SnsTimeLineUI) || (c.this.activity instanceof SnsCommentDetailUI))) {
                        contextMenu.add(0, 26, 0, c.this.activity.getString(R.string.cf_));
                        if (c.this.activity instanceof SnsTimeLineUI) {
                            i4 = 10;
                        } else {
                            i4 = 7;
                        }
                        TimeLineObject timeLine = aQm.getTimeLine();
                        cnb cnb = bcVar.index < timeLine.ContentObj.LoV.size() ? timeLine.ContentObj.LoV.get(bcVar.index) : new cnb();
                        ab abVar = new ab();
                        ab abVar2 = abVar.ie("").m7if(r.Jb(aQm.field_snsId));
                        abVar2.enp = i4;
                        abVar2.eki = 1;
                        abVar2.enq = 81;
                        abVar.ig("");
                        abVar.ih("");
                        abVar.ii(com.tencent.mm.b.g.getMD5(com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), cnb.Id) + r.l(cnb)));
                        abVar.enx = System.currentTimeMillis();
                        abVar.bfK();
                        ar.a(abVar);
                    }
                }
                AppMethodBeat.o(100214);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final boolean fD(View view) {
                AppMethodBeat.i(100213);
                if (view.getTag() instanceof bc) {
                    String str = ((bc) view.getTag()).dJX;
                    c.this.Far.a(view, str, aj.faO().aQm(str).getTimeLine());
                    AppMethodBeat.o(100213);
                    return true;
                }
                AppMethodBeat.o(100213);
                return false;
            }
        };
        this.FaI = new d() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass9 */

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final boolean fD(View view) {
                String str;
                AppMethodBeat.i(203953);
                Object tag = view.getTag();
                if (tag instanceof bc) {
                    str = ((bc) tag).dJX;
                } else if (tag instanceof s) {
                    str = ((s) tag).dHp;
                } else {
                    str = null;
                }
                if (str != null) {
                    c.this.Far.a(view, str, aj.faO().aQm(str).getTimeLine());
                    AppMethodBeat.o(203953);
                    return true;
                }
                AppMethodBeat.o(203953);
                return false;
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final void a(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                String str;
                AppMethodBeat.i(203954);
                Object tag = view.getTag();
                if (tag instanceof bc) {
                    str = ((bc) tag).dJX;
                } else if (tag instanceof s) {
                    str = ((s) tag).dHp;
                } else {
                    str = null;
                }
                if (str != null) {
                    SnsInfo aQm = aj.faO().aQm(str);
                    TimeLineObject timeLine = aQm.getTimeLine();
                    if (com.tencent.mm.br.c.aZU("favorite")) {
                        switch (timeLine.ContentObj.LoU) {
                            case 1:
                                contextMenu.add(0, 2, 0, view.getContext().getString(R.string.fn9));
                                break;
                            case 15:
                                contextMenu.add(0, 10, 0, view.getContext().getString(R.string.fn9));
                                break;
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, aQm);
                }
                AppMethodBeat.o(203954);
            }
        };
        this.Erh = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass10 */

            public final void onClick(View view) {
                TimeLineObject timeLine;
                AppMethodBeat.i(100216);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String str = null;
                if (view.getTag() instanceof bc) {
                    str = ((bc) view.getTag()).dJX;
                } else if (view.getTag() instanceof BaseTimeLineItem.BaseViewHolder) {
                    str = ((BaseTimeLineItem.BaseViewHolder) view.getTag()).dHp;
                } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                    str = ((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag()).DsC.getLocalid();
                }
                SnsInfo aQm = f.aQm(str);
                if (aQm == null) {
                    Log.e("MicroMsg.TimelineClickListener", "photo click without snsinfo ,localId ".concat(String.valueOf(str)));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(100216);
                } else if (!aQm.isAd() || aQm.getAdXml() == null || (!aQm.getAdXml().isCardAd() && !aQm.getAdXml().isFullCardAd())) {
                    if (aQm.getTimeLine().ContentObj.LoU == 21) {
                        if (z.aTY().equals(aQm.getUserName())) {
                            aQm.getTimeLine();
                            m.y(aQm);
                            m.x(aQm);
                            System.currentTimeMillis();
                            com.tencent.mm.plugin.sns.lucky.a.b.pl(25);
                        }
                        if (!z.aTY().equals(aQm.getUserName())) {
                            com.tencent.mm.plugin.sns.lucky.b.a.c(2, aQm);
                            com.tencent.mm.plugin.sns.lucky.a.b.pl(30);
                        }
                    }
                    if (aQm.isAd()) {
                        ADInfo a2 = c.a(c.this, aQm);
                        if (aQm.getAdXml().isLandingPagesAd() && i.aQg(aQm.getAdSnsInfo().field_adxml)) {
                            String Q = i.Q(aQm);
                            if (!Util.isNullOrNil(Q)) {
                                aQm.getAdSnsInfo().field_adxml = Q;
                            }
                            SnsAdClick snsAdClick = new SnsAdClick(c.this.source, c.this.source == 0 ? 1 : 2, aQm.field_snsId, 21, 21);
                            com.tencent.mm.plugin.sns.data.k.a(snsAdClick, c.this.EBv, aQm, 21);
                            r.a(snsAdClick);
                            int[] iArr = new int[2];
                            if (view != null) {
                                view.getLocationInWindow(iArr);
                            }
                            int width = view.getWidth();
                            int height = view.getHeight();
                            Intent intent = new Intent();
                            intent.putExtra("img_gallery_left", iArr[0]);
                            intent.putExtra("img_gallery_top", iArr[1]);
                            intent.putExtra("img_gallery_width", width);
                            intent.putExtra("img_gallery_height", height);
                            intent.putExtra("sns_landing_pages_share_sns_id", aQm.getSnsId());
                            intent.putExtra("sns_landing_pages_rawSnsId", aQm.getTimeLine().Id);
                            intent.putExtra("sns_landing_pages_ux_info", aQm.getUxinfo());
                            intent.putExtra("sns_landing_pages_aid", aQm.getAid());
                            intent.putExtra("sns_landing_pages_traceid", aQm.getTraceid());
                            TimeLineObject timeLine2 = aQm.getTimeLine();
                            if (timeLine2 != null) {
                                LinkedList<cnb> linkedList = timeLine2.ContentObj.LoV;
                                if (linkedList.size() > 0) {
                                    intent.putExtra("sns_landing_pages_share_thumb_url", linkedList.get(0).Msz);
                                    intent.putExtra("sns_landing_pages_from_outer_index", ((bc) view.getTag()).index);
                                }
                            }
                            intent.setClass(c.this.activity, SnsAdNativeLandingPagesUI.class);
                            int i2 = 1;
                            if (c.this.source == 2) {
                                i2 = 16;
                            } else if (c.this.source == 1) {
                                i2 = 2;
                            }
                            intent.putExtra("sns_landig_pages_from_source", i2);
                            intent.putExtra("sns_landing_pages_xml", aQm.getAdSnsInfo().field_adxml);
                            intent.putExtra("sns_landing_pages_rec_src", aQm.getAdRecSrc());
                            intent.putExtra("sns_landing_pages_xml_prefix", com.tencent.mm.g.c.f.COL_ADXML);
                            if (!aQm.getAdXml().forbiddenCustomAnimation) {
                                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                                intent.putExtra("sns_landing_pages_is_normal_ad_animation", true);
                            }
                            Activity activity = c.this.activity;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            activity.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            if (!aQm.getAdXml().forbiddenCustomAnimation) {
                                c.this.activity.overridePendingTransition(0, 0);
                            }
                            if (c.this.Epj != null) {
                                c.this.Epj.fat().M(aQm);
                            }
                        } else if (c.a(c.this, a2, aQm, false)) {
                            SnsAdClick snsAdClick2 = new SnsAdClick(c.this.source, c.this.source == 0 ? 1 : 2, aQm.field_snsId, 21, 31);
                            com.tencent.mm.plugin.sns.data.k.a(snsAdClick2, c.this.EBv, aQm, 21);
                            r.a(snsAdClick2);
                        } else if (bk.Y(aQm) != 2) {
                            c.this.dS(view);
                        } else if (com.tencent.mm.plugin.sns.ad.e.h.a(c.this.activity, aQm.getAdXml(), a2, aQm.field_snsId, 3)) {
                            SnsAdClick snsAdClick3 = new SnsAdClick(c.this.source, c.this.source == 0 ? 1 : 2, aQm.field_snsId, 21, 37);
                            com.tencent.mm.plugin.sns.data.k.a(snsAdClick3, c.this.EBv, aQm, 21);
                            r.a(snsAdClick3);
                        } else {
                            c.this.dS(view);
                        }
                    } else {
                        c.this.dS(view);
                    }
                    bc bcVar = (bc) view.getTag();
                    if (bcVar.EAv && aQm != null) {
                        com.tencent.mm.plugin.sns.ui.a.c.g(aQm, bcVar.index);
                        com.tencent.mm.plugin.sns.ui.a.c.h(aQm, bcVar.index);
                        bd.aPu(aQm.getLocalid());
                    }
                    if (!(aQm == null || (timeLine = aQm.getTimeLine()) == null)) {
                        String str2 = timeLine.AppInfo == null ? null : timeLine.AppInfo.Id;
                        if (!Util.isNullOrNil(str2)) {
                            com.tencent.mm.plugin.sns.c.a.jRu.a(null, str2, com.tencent.mm.plugin.sns.c.a.jRu.go(str2), timeLine.UserName, 2, 4, 4, timeLine.statisticsData, timeLine.Id);
                        }
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(100216);
                } else {
                    c.this.Fbd.onClick(view);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$18", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(100216);
                }
            }
        };
        this.Fav = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass11 */

            public final void onClick(View view) {
                AppMethodBeat.i(100218);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                view.getTag();
                c.this.dS(view);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$19", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100218);
            }
        };
        this.Faw = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass13 */

            public final void onClick(final View view) {
                AppMethodBeat.i(100220);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                new f.a(c.this.activity).bow(c.this.activity.getResources().getString(R.string.hb3)).boA(c.this.activity.getResources().getString(R.string.tf)).apb(c.this.activity.getResources().getColor(R.color.a5e)).b(new f.c() {
                    /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass13.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                        com.tencent.mm.modelsns.k tP;
                        String str2;
                        com.tencent.mm.modelsns.k tP2;
                        AppMethodBeat.i(203955);
                        if (!(view.getTag() instanceof String)) {
                            AppMethodBeat.o(203955);
                            return;
                        }
                        String str3 = (String) view.getTag();
                        Log.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(str3)));
                        SnsInfo aQm = aj.faO().aQm(str3);
                        if (aQm == null) {
                            Log.d("MicroMsg.TimelineClickListener", "can not get snsinfo by localid %s then return it", str3);
                            AppMethodBeat.o(203955);
                        } else if (aQm.isDieItem()) {
                            Log.i("MicroMsg.TimelineClickListener", "dead item");
                            aj.faO().Zs(aQm.localid);
                            if (c.this.Fbe != null) {
                                c.this.Fbe.fiX();
                            }
                            if (c.this.source == 0) {
                                tP2 = com.tencent.mm.modelsns.k.tO(739);
                            } else {
                                tP2 = com.tencent.mm.modelsns.k.tP(739);
                            }
                            tP2.PH(r.v(aQm)).tR(aQm.field_type).PH(aQm.isDieItem() ? "2" : aQm.field_snsId == 0 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            tP2.bfK();
                            if (aQm.getTypeFlag() == 21) {
                                com.tencent.mm.plugin.sns.lucky.a.g.eZK().eZM();
                            }
                            AppMethodBeat.o(203955);
                        } else if (aQm.isInValid()) {
                            Log.i("MicroMsg.TimelineClickListener", "cancel item " + aQm.getLocalid());
                            aj.faK().J(aQm);
                            TimeLineObject timeLine = aQm.getTimeLine();
                            boolean z2 = false;
                            if (!(timeLine == null || timeLine.ContentObj == null || timeLine.ContentObj.dME == null || timeLine.ContentObj.dME.localId == 0)) {
                                z2 = true;
                            }
                            if (Util.secondsToNow((long) aQm.getCreateTime()) < ((long) com.tencent.mm.plugin.sns.model.at.DMU) && !z2) {
                                aj.fba().D(aQm);
                            }
                            c.this.ffw();
                            AppMethodBeat.o(203955);
                        } else {
                            Log.i("MicroMsg.TimelineClickListener", "delete by server");
                            String snsId = aQm.getSnsId();
                            aj.faN().Jr(com.tencent.mm.plugin.sns.storage.y.aOa(snsId));
                            g.aAi();
                            g.aAg().hqi.a(new com.tencent.mm.plugin.sns.model.s(com.tencent.mm.plugin.sns.storage.y.aOa(snsId), 1), 0);
                            TimeLineObject timeLine2 = aQm.getTimeLine();
                            boolean z3 = false;
                            if (!(timeLine2 == null || timeLine2.ContentObj == null || timeLine2.ContentObj.dME == null || timeLine2.ContentObj.dME.localId == 0)) {
                                z3 = true;
                            }
                            if (Util.secondsToNow((long) aQm.getCreateTime()) < ((long) com.tencent.mm.plugin.sns.model.at.DMU) && !z3) {
                                aj.fba().D(aQm);
                            }
                            aj.faO().delete(com.tencent.mm.plugin.sns.storage.y.aOa(snsId));
                            aj.faT().JI(com.tencent.mm.plugin.sns.storage.y.aOa(snsId));
                            com.tencent.mm.plugin.sns.storage.g.JH(com.tencent.mm.plugin.sns.storage.y.aOa(snsId));
                            c.this.ffw();
                            if (timeLine2 != null) {
                                if (timeLine2.AppInfo == null) {
                                    str2 = null;
                                } else {
                                    str2 = timeLine2.AppInfo.Id;
                                }
                                if (!Util.isNullOrNil(str2) && com.tencent.mm.plugin.sns.c.a.jRu.gq(str2)) {
                                    String go = com.tencent.mm.plugin.sns.c.a.jRu.go(str2);
                                    rw rwVar = new rw();
                                    rwVar.dYr.appId = str2;
                                    rwVar.dYr.dYs = timeLine2.UserName;
                                    rwVar.dYr.pkgName = go;
                                    rwVar.dYr.mediaTagName = timeLine2.statisticsData;
                                    EventCenter.instance.publish(rwVar);
                                }
                            }
                            if (c.this.source == 0) {
                                tP = com.tencent.mm.modelsns.k.tO(739);
                            } else {
                                tP = com.tencent.mm.modelsns.k.tP(739);
                            }
                            tP.PH(r.v(aQm)).tR(aQm.field_type).PH(aQm.isDieItem() ? "2" : aQm.field_snsId == 0 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            tP.bfK();
                            AppMethodBeat.o(203955);
                        }
                    }
                }).boB(c.this.activity.getResources().getString(R.string.sz)).a(new f.c() {
                    /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass13.AnonymousClass1 */

                    @Override // com.tencent.mm.ui.widget.a.f.c
                    public final void e(boolean z, String str) {
                    }
                }).show();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$20", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100220);
            }
        };
        this.Fax = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass14 */

            public final void onClick(View view) {
                AppMethodBeat.i(100221);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String str = (String) view.getTag();
                Log.d("MicroMsg.TimelineClickListener", "onItemDelClick:".concat(String.valueOf(str)));
                TimeLineObject timeLine = aj.faO().aQm(str).getTimeLine();
                be beVar = timeLine.actionInfo;
                if (beVar.KEw == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(100221);
                    return;
                }
                String go = com.tencent.mm.plugin.sns.c.a.jRu.go(beVar.KEw.jfi);
                int i2 = 0;
                if (timeLine.ContentObj.LoU == 1) {
                    i2 = 2;
                } else if (timeLine.ContentObj.LoU == 3) {
                    i2 = 5;
                } else if (timeLine.ContentObj.LoU == 15) {
                    i2 = 38;
                }
                if (i.a(timeLine, c.this.activity)) {
                    com.tencent.mm.plugin.sns.c.a.jRu.a(c.this.activity, beVar.KEw.jfi, go, timeLine.UserName, i2, 11, 9, beVar.KEw.KEq, timeLine.Id);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(100221);
                    return;
                }
                switch (beVar.oUv) {
                    case 4:
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", beVar.Url);
                        com.tencent.mm.plugin.sns.c.a.jRt.i(intent, c.this.activity);
                        com.tencent.mm.plugin.sns.c.a.jRu.a(c.this.activity, beVar.KEw.jfi, go, timeLine.UserName, i2, 11, 1, beVar.KEw.KEq, timeLine.Id);
                        break;
                    case 5:
                        if (beVar.Scene == 1) {
                            is isVar = new is();
                            isVar.dNr.actionCode = 2;
                            isVar.dNr.scene = 3;
                            isVar.dNr.appId = beVar.KEw.jfi;
                            isVar.dNr.context = c.this.activity;
                            EventCenter.instance.publish(isVar);
                            com.tencent.mm.plugin.sns.c.a.jRu.a(c.this.activity, beVar.KEw.jfi, go, timeLine.UserName, i2, 11, 6, beVar.KEw.KEq, timeLine.Id);
                            break;
                        }
                        break;
                    case 6:
                        int b2 = ao.b(c.this.activity, beVar);
                        if (b2 != 1) {
                            if (b2 == 2) {
                                is isVar2 = new is();
                                isVar2.dNr.context = c.this.activity;
                                isVar2.dNr.actionCode = 1;
                                isVar2.dNr.appId = beVar.KEw.jfi;
                                isVar2.dNr.messageAction = beVar.KEw.KEs;
                                isVar2.dNr.messageExt = beVar.KEw.KEr;
                                isVar2.dNr.scene = 3;
                                EventCenter.instance.publish(isVar2);
                                com.tencent.mm.plugin.sns.c.a.jRu.a(c.this.activity, beVar.KEw.jfi, go, timeLine.UserName, i2, 11, 3, beVar.KEw.KEq, timeLine.Id);
                                break;
                            }
                        } else {
                            is isVar3 = new is();
                            isVar3.dNr.context = c.this.activity;
                            isVar3.dNr.actionCode = 2;
                            isVar3.dNr.appId = beVar.KEw.jfi;
                            isVar3.dNr.messageAction = beVar.KEw.KEs;
                            isVar3.dNr.messageExt = beVar.KEw.KEr;
                            isVar3.dNr.scene = 3;
                            EventCenter.instance.publish(isVar3);
                            com.tencent.mm.plugin.sns.c.a.jRu.a(c.this.activity, beVar.KEw.jfi, go, timeLine.UserName, i2, 11, 6, beVar.KEw.KEq, timeLine.Id);
                            break;
                        }
                        break;
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$21", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100221);
            }
        };
        this.FaD = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass15 */

            public final void onClick(View view) {
                AppMethodBeat.i(100223);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getTag() instanceof SnsInfo) {
                    SnsInfo snsInfo = (SnsInfo) view.getTag();
                    if (snsInfo.getTypeFlag() == 21 && z.aTY().equals(snsInfo.getUserName())) {
                        snsInfo.getTimeLine();
                        m.y(snsInfo);
                        m.x(snsInfo);
                        System.currentTimeMillis();
                        com.tencent.mm.plugin.sns.lucky.a.b.pl(24);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_sendid", snsInfo.getSnsId());
                    intent.putExtra("key_feedid", snsInfo.getLocalid());
                    intent.setClassName(c.this.activity, "com.tencent.mm.plugin.sns.lucky.ui.SnsLuckyMoneyDetailUI");
                    Activity activity = c.this.activity;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    String localid = snsInfo.getLocalid();
                    snsInfo.getSnsId();
                    aRs(localid);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$22", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100223);
            }

            private static void aRs(String str) {
                AppMethodBeat.i(203956);
                SnsInfo JJ = aj.faO().JJ(aj.faO().aQm(str).field_snsId);
                if (JJ != null) {
                    TimeLineObject timeLine = JJ.getTimeLine();
                    if (timeLine != null) {
                        LinkedList<cnb> linkedList = timeLine.ContentObj.LoV;
                        if (linkedList.size() > 0) {
                            linkedList.get(0);
                        }
                    }
                    SnsObject C = an.C(JJ);
                    ArrayList arrayList = new ArrayList();
                    LinkedList<dzx> linkedList2 = C.SnsRedEnvelops.Naf;
                    if (linkedList2 != null) {
                        for (int i2 = 0; i2 < linkedList2.size(); i2++) {
                            dzx dzx = linkedList2.get(i2);
                            a.C1455a aVar = new a.C1455a();
                            aVar.mRa = dzx.Username;
                            aVar.yOR = dzx.CreateTime;
                            aVar.yOS = dzx.MYW;
                            arrayList.add(aVar);
                        }
                    }
                    com.tencent.mm.plugin.l.a.z(str, arrayList);
                }
                AppMethodBeat.o(203956);
            }
        };
        this.Fay = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass16 */

            public final void onClick(View view) {
                AppMethodBeat.i(100224);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.this.fo(view);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$23", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100224);
            }
        };
        this.Faz = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass17 */

            public final void onClick(View view) {
                AppMethodBeat.i(100225);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.this.fr(view);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$24", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100225);
            }
        };
        this.FaA = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass18 */

            public final void onClick(View view) {
                AppMethodBeat.i(100226);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getTag() instanceof String) {
                    String str = (String) view.getTag();
                    Log.d("MicroMsg.TimelineClickListener", "localId ".concat(String.valueOf(str)));
                    an.YD(com.tencent.mm.plugin.sns.storage.y.aQI(str));
                    an.YB(com.tencent.mm.plugin.sns.storage.y.aQI(str));
                    aj.faK().eZn();
                    c.this.ffw();
                    if (c.this.Fbe != null) {
                        c.this.Fbe.fiX();
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$25", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100226);
            }
        };
        this.FaB = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass19 */

            public final void onClick(View view) {
                AppMethodBeat.i(203957);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                try {
                    int aQI = com.tencent.mm.plugin.sns.storage.y.aQI((String) view.getTag());
                    Intent intent = new Intent();
                    intent.putExtra("sns_label_sns_info", aQI);
                    com.tencent.mm.plugin.sns.c.a.jRt.t(intent, c.this.activity);
                } catch (Exception e2) {
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$26", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203957);
            }
        };
        this.FaE = new d() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass20 */

            private static boolean c(com.tencent.mm.plugin.sns.ui.m mVar) {
                AppMethodBeat.i(203958);
                boolean z = false;
                if (!(mVar == null || mVar.DIu == null || Util.isNullOrNil(mVar.DIu.MYY))) {
                    z = true;
                }
                AppMethodBeat.o(203958);
                return z;
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final void a(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                boolean z;
                int i2;
                boolean z2;
                AppMethodBeat.i(203959);
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.m) {
                    com.tencent.mm.plugin.sns.ui.m mVar = (com.tencent.mm.plugin.sns.ui.m) view.getTag();
                    if ((!com.tencent.mm.plugin.sns.ui.widget.e.iY(mVar.DIu.MYX, 16) || mVar.scene == 2) && !c(mVar)) {
                        contextMenu.add(0, 11, 0, c.this.activity.getString(R.string.t_));
                    }
                    if (BuildInfo.DEBUG || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
                        z = true;
                    } else {
                        z = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_delete_others_comment_enable, 0) == 1;
                    }
                    if ((z && !Util.isNullOrNil(mVar.Epx) && mVar.Epx.equals(z.aTY())) || (mVar.UserName != null && mVar.UserName.equals(z.aTY()))) {
                        contextMenu.add(0, 7, 0, c.this.activity.getString(R.string.tf));
                    }
                    if (!com.tencent.mm.plugin.sns.ui.widget.e.iY(mVar.DIu.MYX, 16) && !c(mVar)) {
                        String kj = au.kj(mVar.Epv, new StringBuilder().append(mVar.DIu.MYT != 0 ? (long) mVar.DIu.MYT : mVar.DIu.MYV).toString());
                        if (mVar.scene == 1) {
                            i2 = 2;
                        } else if (mVar.scene == 2) {
                            i2 = 4;
                        } else {
                            i2 = -1;
                        }
                        au.b aPp = au.aPp(kj);
                        if (aPp == null || !aPp.iGD || aPp.aGI || (i2 & aPp.showFlag) == 0) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        if (!z2) {
                            au.a(contextMenu, false);
                            AppMethodBeat.o(203959);
                            return;
                        }
                        au.b(contextMenu, false);
                    }
                }
                AppMethodBeat.o(203959);
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final boolean fD(View view) {
                AppMethodBeat.i(203960);
                if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.m) {
                    SnsInfo aQl = aj.faO().aQl(((com.tencent.mm.plugin.sns.ui.m) view.getTag()).Epv);
                    c.this.Far.a(view, aQl.getLocalid(), aQl.getTimeLine());
                    AppMethodBeat.o(203960);
                    return true;
                }
                AppMethodBeat.o(203960);
                return false;
            }
        };
        this.uwC = new View.OnTouchListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass21 */

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(203961);
                Log.d("MicroMsg.TimelineClickListener", "v " + view.getId() + "  ");
                c.this.fq(view);
                AppMethodBeat.o(203961);
                return false;
            }
        };
        this.FaO = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass22 */

            public final void onClick(View view) {
                AppMethodBeat.i(100232);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getTag() instanceof bg) {
                    SnsInfo aQl = aj.faO().aQl(((bg) view.getTag()).dRS);
                    if (aQl == null) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(100232);
                        return;
                    }
                    Intent intent = new Intent();
                    intent.putExtra("sns_text_show", aQl.getTimeLine().ContentDesc);
                    intent.putExtra("sns_local_id", aQl.getLocalid());
                    intent.setClass(c.this.activity, SnsSingleTextViewUI.class);
                    Activity activity = c.this.activity;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$29", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100232);
            }
        };
        this.FaR = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass24 */

            public final void onClick(View view) {
                int width;
                int height;
                AppMethodBeat.i(100239);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getTag() instanceof s) {
                    s sVar = (s) view.getTag();
                    cnb cnb = sVar.EpO.ContentObj.LoV.get(0);
                    aj.faO().aQl(sVar.dHp);
                    String str = "";
                    String ki = com.tencent.mm.plugin.sns.model.ar.ki(aj.getAccSnsPath(), cnb.Id);
                    String str2 = "";
                    String j2 = r.j(cnb);
                    if (com.tencent.mm.vfs.s.YS(ki + j2)) {
                        str = ki + j2;
                        str2 = ki + r.e(cnb);
                    }
                    if (com.tencent.mm.vfs.s.YS(ki + r.p(cnb))) {
                        str = ki + r.p(cnb);
                        str2 = ki + r.n(cnb);
                    }
                    int[] iArr = new int[2];
                    View findViewById = view.findViewById(R.id.bf5);
                    if (findViewById != null) {
                        findViewById.getLocationInWindow(iArr);
                        width = findViewById.getWidth();
                        height = findViewById.getHeight();
                    } else {
                        view.getLocationInWindow(iArr);
                        width = view.getWidth();
                        height = view.getHeight();
                    }
                    Intent intent = new Intent();
                    intent.setClass(c.this.activity, SnsOnlineVideoActivity.class);
                    intent.putExtra("intent_videopath", str);
                    intent.putExtra("intent_thumbpath", str2);
                    intent.putExtra("intent_localid", sVar.dHp);
                    intent.putExtra("intent_isad", false);
                    intent.putExtra("intent_from_scene", c.this.source);
                    intent.putExtra("img_gallery_left", iArr[0]);
                    intent.putExtra("img_gallery_top", iArr[1]);
                    intent.putExtra("img_gallery_width", width);
                    intent.putExtra("img_gallery_height", height);
                    Activity activity = c.this.activity;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    activity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    c.this.activity.overridePendingTransition(0, 0);
                    c.a(c.this, sVar.EpO);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$30", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100239);
            }
        };
        this.FaQ = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass25 */

            /* JADX WARNING: Removed duplicated region for block: B:150:0x0866  */
            /* JADX WARNING: Removed duplicated region for block: B:160:0x093f  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(android.view.View r21) {
                /*
                // Method dump skipped, instructions count: 2419
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass25.onClick(android.view.View):void");
            }
        };
        this.FaH = new d() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass26 */

            /* JADX WARNING: Removed duplicated region for block: B:15:0x00a6  */
            /* JADX WARNING: Removed duplicated region for block: B:17:0x00b8  */
            @Override // com.tencent.mm.plugin.sns.ui.d.d
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void a(android.view.ContextMenu r11, android.view.View r12, android.view.ContextMenu.ContextMenuInfo r13) {
                /*
                // Method dump skipped, instructions count: 237
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass26.a(android.view.ContextMenu, android.view.View, android.view.ContextMenu$ContextMenuInfo):void");
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final boolean fD(View view) {
                AppMethodBeat.i(203965);
                if (view.getTag() instanceof at) {
                    String str = ((at) view.getTag()).dHp;
                    c.this.Far.a(view, str, aj.faO().aQm(str).getTimeLine());
                    AppMethodBeat.o(203965);
                    return true;
                }
                AppMethodBeat.o(203965);
                return false;
            }
        };
        this.FaS = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass27 */

            public final void onClick(View view) {
                AppMethodBeat.i(203966);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.this.fs(view);
                if (view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.c)) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203966);
                    return;
                }
                com.tencent.mm.plugin.sns.data.c cVar = (com.tencent.mm.plugin.sns.data.c) view.getTag();
                SnsInfo aQm = aj.faO().aQm(cVar.dHp);
                if (aQm == null) {
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(203966);
                    return;
                }
                if (aQm.isAd()) {
                    cVar.DDs = System.currentTimeMillis();
                    SnsAdClick snsAdClick = new SnsAdClick(c.this.source, c.this.source == 0 ? 1 : 2, aQm.field_snsId, 20, 0);
                    com.tencent.mm.plugin.sns.data.k.a(snsAdClick, c.this.EBv, aQm, 20);
                    r.a(snsAdClick);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$33", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203966);
            }
        };
        this.FaZ = new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass28 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(100244);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                Log.i("MicroMsg.TimelineClickListener", "unlike click");
                if (!(adapterView.getAdapter() instanceof com.tencent.mm.plugin.sns.ui.c)) {
                    Log.w("MicroMsg.TimelineClickListener", "unknown unlike adapter click");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(100244);
                    return;
                }
                com.tencent.mm.plugin.sns.data.c cVar = (com.tencent.mm.plugin.sns.data.c) view.getTag();
                SnsInfo aQm = aj.faO().aQm(cVar.dHp);
                if (aQm == null) {
                    try {
                        c.this.ffy();
                    } catch (Exception e2) {
                        Log.e("MicroMsg.TimelineClickListener", "onUnLikeFinishError exp=" + e2.toString());
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(100244);
                    return;
                }
                if (i2 == 0) {
                    if (aQm.isAd()) {
                        ADInfo a2 = c.a(c.this, aQm);
                        ((com.tencent.mm.plugin.sns.b.d) g.af(com.tencent.mm.plugin.sns.b.d.class)).a(11855, aQm.getAdRecSrc(), 3, a2 == null ? "" : a2.viewId, Integer.valueOf(aQm.getAdRecSrc()));
                    }
                    if (cVar.DDr.EQZ.adUnlikeInfo.fcI()) {
                        com.tencent.mm.plugin.sns.ui.c cVar2 = (com.tencent.mm.plugin.sns.ui.c) adapterView.getAdapter();
                        cVar2.lCq++;
                        cVar2.notifyDataSetChanged();
                        adapterView.setOnItemClickListener(c.this.Fba);
                        c.this.ffx();
                        ADInfo.c.a aVar = new ADInfo.c.a();
                        aVar.DWd = ADInfo.c.a.DVZ;
                        aVar.DDs = cVar.DDs;
                        aVar.DWe = 0;
                        com.tencent.mm.plugin.sns.model.s sVar = new com.tencent.mm.plugin.sns.model.s(aQm.field_snsId, 8, aVar);
                        g.aAi();
                        g.aAg().hqi.a(sVar, 0);
                    } else if (cVar.DDr.EQZ.forbidClick) {
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                        AppMethodBeat.o(100244);
                        return;
                    } else {
                        c.this.ft(view);
                        ADInfo.c.a aVar2 = new ADInfo.c.a();
                        aVar2.DDs = cVar.DDs;
                        aVar2.DWe = System.currentTimeMillis();
                        com.tencent.mm.plugin.sns.model.s sVar2 = new com.tencent.mm.plugin.sns.model.s(aQm.field_snsId, 8, aVar2);
                        g.aAi();
                        g.aAg().hqi.a(sVar2, 0);
                    }
                } else if (cVar.DDr.EQY.adFeedbackInfo == null) {
                    Log.e("MicroMsg.TimelineClickListener", "click feedback item but no report url");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                    AppMethodBeat.o(100244);
                    return;
                } else {
                    ADXml.e eVar = cVar.DDr.EQY.adFeedbackInfo;
                    int i3 = i2 - 1;
                    if (i3 < eVar.list.size()) {
                        String str = eVar.list.get(i3).url;
                        try {
                            Object[] objArr = {aQm.getTimeLine().Id};
                            Object[] objArr2 = {aQm.getAid()};
                            Object[] objArr3 = {aQm.getTraceid()};
                            g.aAf();
                            str = i.n(str, String.format("snsid=%s", objArr), String.format("aid=%s", objArr2), String.format("traceid=%s", objArr3), String.format("uin=%s", com.tencent.mm.kernel.a.ayV()));
                        } catch (Exception e3) {
                        }
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", str);
                        intent.putExtra("useJs", true);
                        intent.putExtra("KPublisherId", "sns_" + r.Jb(aQm.field_snsId));
                        intent.putExtra("pre_username", aQm.field_userName);
                        intent.putExtra("prePublishId", "sns_" + r.Jb(aQm.field_snsId));
                        intent.putExtra("preUsername", aQm.field_userName);
                        com.tencent.mm.plugin.sns.c.a.jRt.i(intent, c.this.activity);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$34", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(100244);
            }
        };
        this.Fba = new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass29 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(203967);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                if (view.getTag() != null && (view.getTag() instanceof com.tencent.mm.plugin.sns.data.c)) {
                    com.tencent.mm.plugin.sns.data.c cVar = (com.tencent.mm.plugin.sns.data.c) view.getTag();
                    if (i2 < cVar.DDr.EQZ.adUnlikeInfo.fcH().size()) {
                        if (cVar.DDr.EQZ.forbidClick) {
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                            AppMethodBeat.o(203967);
                            return;
                        }
                        ADInfo.c.a aVar = cVar.DDr.EQZ.adUnlikeInfo.fcH().get(i2);
                        Log.i("MicroMsg.TimelineClickListener", "unlike item click, reason=%s, id=%s", aVar.DWa, Integer.valueOf(aVar.DWd));
                        SnsInfo aQm = aj.faO().aQm(cVar.dHp);
                        if (aQm == null) {
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                            AppMethodBeat.o(203967);
                            return;
                        }
                        c.this.ft(view);
                        aVar.DDs = cVar.DDs;
                        aVar.DWe = System.currentTimeMillis();
                        com.tencent.mm.plugin.sns.model.s sVar = new com.tencent.mm.plugin.sns.model.s(aQm.field_snsId, 8, aVar);
                        g.aAi();
                        g.aAg().hqi.a(sVar, 0);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$35", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(203967);
            }
        };
        this.FaY = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass30 */

            public final void onClick(View view) {
                AppMethodBeat.i(163130);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (view.getTag() instanceof TimeLineObject) {
                    TimeLineObject timeLineObject = (TimeLineObject) view.getTag();
                    bcj bcj = timeLineObject.ContentObj.dME;
                    Intent intent = new Intent();
                    intent.putExtra("feed_object_id", r.aOw(bcj.objectId));
                    intent.putExtra("feed_object_nonceId", bcj.objectNonceId);
                    intent.putExtra("business_type", 0);
                    intent.putExtra("finder_user_name", bcj.username);
                    intent.putExtra("report_scene", 3);
                    intent.putExtra("from_user", timeLineObject.UserName);
                    ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).fillContextIdToIntent(4, 2, 25, intent);
                    ((com.tencent.mm.plugin.i.a.aj) g.ah(com.tencent.mm.plugin.i.a.aj.class)).enterFinderShareFeedUI(view.getContext(), intent);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$36", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(163130);
            }
        };
        this.Fbd = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass31 */

            /* JADX WARNING: Removed duplicated region for block: B:156:0x03e3  */
            /* JADX WARNING: Removed duplicated region for block: B:159:0x0415  */
            /* JADX WARNING: Removed duplicated region for block: B:162:0x0437  */
            /* JADX WARNING: Removed duplicated region for block: B:167:0x0480  */
            /* JADX WARNING: Removed duplicated region for block: B:168:0x0497  */
            /* JADX WARNING: Removed duplicated region for block: B:169:0x049f  */
            /* JADX WARNING: Removed duplicated region for block: B:173:0x04cb  */
            /* JADX WARNING: Removed duplicated region for block: B:182:0x0501  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(android.view.View r14) {
                /*
                // Method dump skipped, instructions count: 3452
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass31.onClick(android.view.View):void");
            }
        };
        this.FaN = new d() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass32 */

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final boolean fD(View view) {
                Cursor query;
                SnsInfo snsInfo;
                AppMethodBeat.i(203969);
                if (view.getTag() == null || !(view.getTag() instanceof TimeLineObject)) {
                    AppMethodBeat.o(203969);
                    return false;
                }
                TimeLineObject timeLineObject = (TimeLineObject) view.getTag();
                n faO = aj.faO();
                String str = timeLineObject.Id;
                SnsInfo snsInfo2 = new SnsInfo();
                if (!faO.Emq) {
                    query = faO.iFy.query(gk.TABLE_NAME, null, "stringSeq=?", new String[]{String.valueOf(str)}, null, null, null, 2);
                } else {
                    query = faO.iFy.query(gk.TABLE_NAME, null, "snsId=?", new String[]{new StringBuilder().append(n.aQy(str)).toString()}, null, null, null, 2);
                }
                if (query.moveToFirst()) {
                    snsInfo2.convertFrom(query);
                    query.close();
                    snsInfo = snsInfo2;
                } else {
                    query.close();
                    snsInfo = null;
                }
                if (snsInfo != null) {
                    c.this.Far.a(view, snsInfo.getLocalid(), timeLineObject);
                }
                AppMethodBeat.o(203969);
                return true;
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final void a(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(203970);
                if (view != null && (view.getTag() instanceof TimeLineObject) && com.tencent.mm.br.c.aZU("favorite")) {
                    contextMenu.add(0, 25, 0, c.this.activity.getString(R.string.fn9));
                }
                AppMethodBeat.o(203970);
            }
        };
        this.FaL = new d() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass33 */

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final boolean fD(View view) {
                AppMethodBeat.i(203971);
                Object tag = view.getTag();
                if (tag instanceof s) {
                    s sVar = (s) tag;
                    TimeLineObject timeLineObject = sVar.EpO;
                    if (timeLineObject.ContentObj.LoU == 10 || timeLineObject.ContentObj.LoU == 17 || timeLineObject.ContentObj.LoU == 22 || timeLineObject.ContentObj.LoU == 23) {
                        AppMethodBeat.o(203971);
                        return false;
                    }
                    c.this.Far.a(view, sVar.dHp, timeLineObject);
                    AppMethodBeat.o(203971);
                    return true;
                }
                AppMethodBeat.o(203971);
                return false;
            }

            @Override // com.tencent.mm.plugin.sns.ui.d.d
            public final void a(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(203972);
                Object tag = view.getTag();
                if (tag instanceof s) {
                    s sVar = (s) tag;
                    TimeLineObject timeLineObject = sVar.EpO;
                    if (com.tencent.mm.br.c.aZU("favorite")) {
                        switch (timeLineObject.ContentObj.LoU) {
                            case 1:
                                contextMenu.add(0, 2, 0, view.getContext().getString(R.string.fn9));
                                break;
                            case 3:
                                contextMenu.add(0, 3, 0, view.getContext().getString(R.string.fn9));
                                ef efVar = new ef();
                                efVar.dHy.dHp = sVar.dHp;
                                EventCenter.instance.publish(efVar);
                                if (efVar.dHz.dGX) {
                                    contextMenu.add(0, 18, 0, view.getContext().getString(R.string.xa));
                                    break;
                                }
                                break;
                            case 4:
                                contextMenu.add(0, 4, 0, view.getContext().getString(R.string.fn9));
                                ef efVar2 = new ef();
                                efVar2.dHy.dHp = sVar.dHp;
                                EventCenter.instance.publish(efVar2);
                                if (efVar2.dHz.dGX) {
                                    contextMenu.add(0, 18, 0, view.getContext().getString(R.string.xa));
                                    break;
                                }
                                break;
                            case 9:
                                contextMenu.add(0, 5, 0, view.getContext().getString(R.string.fn9));
                                break;
                            case 14:
                                contextMenu.add(0, 9, 0, view.getContext().getString(R.string.fn9));
                                break;
                            case 15:
                                contextMenu.add(0, 10, 0, view.getContext().getString(R.string.fn9));
                                break;
                            case 26:
                                contextMenu.add(0, 22, 0, view.getContext().getString(R.string.fn9));
                                break;
                            case 29:
                            case 37:
                            case 38:
                                break;
                            case 30:
                                contextMenu.add(0, 23, 0, view.getContext().getString(R.string.fn9));
                                break;
                            case 33:
                                contextMenu.add(0, 24, 0, view.getContext().getString(R.string.fn9));
                                break;
                            case 42:
                                contextMenu.add(0, 28, 0, view.getContext().getString(R.string.fn9));
                                ef efVar3 = new ef();
                                efVar3.dHy.dHp = sVar.dHp;
                                EventCenter.instance.publish(efVar3);
                                if (efVar3.dHz.dGX) {
                                    contextMenu.add(0, 18, 0, view.getContext().getString(R.string.xa));
                                    break;
                                }
                                break;
                            default:
                                contextMenu.add(0, 3, 0, view.getContext().getString(R.string.fn9));
                                break;
                        }
                    }
                    com.tencent.mm.plugin.sns.abtest.a.a(contextMenu, aj.faO().aQm(sVar.dHp));
                }
                AppMethodBeat.o(203972);
            }
        };
        this.EZJ = new b.e() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass35 */

            @Override // com.tencent.mm.plugin.sight.decode.a.b.e
            public final void c(com.tencent.mm.plugin.sight.decode.a.b bVar, int i2) {
                View view;
                AppMethodBeat.i(203973);
                if (bVar != null && i2 == 0) {
                    if (bVar.DmA != null) {
                        view = bVar.DmA.get();
                    } else {
                        view = null;
                    }
                    if (view != null && (view instanceof com.tencent.mm.plugin.sight.decode.a.a)) {
                        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view;
                        aVar.getVideoPath();
                        if (aVar.getTagObject() != null && (aVar.getTagObject() instanceof at)) {
                            aVar.getTagObject();
                        }
                    }
                }
                AppMethodBeat.o(203973);
            }
        };
        this.FaV = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass36 */

            public final void onClick(View view) {
                AppMethodBeat.i(100257);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.this.fu(view);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$41", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(100257);
            }
        };
        this.FaW = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass37 */

            public final void onClick(View view) {
                SnsInfo aQm;
                AppMethodBeat.i(163134);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.this.ffz();
                if (!(view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.data.g) || (aQm = aj.faO().aQm(((com.tencent.mm.plugin.sns.data.g) view.getTag()).dHp)) == null)) {
                    com.tencent.mm.plugin.sns.k.e eVar = com.tencent.mm.plugin.sns.k.e.DUQ;
                    com.tencent.mm.plugin.sns.k.e.aPQ(aQm.getUserName());
                    com.tencent.mm.plugin.sns.model.s sVar = new com.tencent.mm.plugin.sns.model.s(aQm.field_snsId, 9);
                    g.aAi();
                    g.aAg().hqi.a(sVar, 0);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$42", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(163134);
            }
        };
        this.FaX = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.sns.ui.d.c.AnonymousClass38 */

            public final void onClick(View view) {
                com.tencent.mm.plugin.sns.ui.m mVar;
                dzo dzo;
                AppMethodBeat.i(203974);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!(view.getTag() == null || !(view.getTag() instanceof com.tencent.mm.plugin.sns.ui.m) || (dzo = (mVar = (com.tencent.mm.plugin.sns.ui.m) view.getTag()).DIu) == null || Util.isNullOrNil(dzo.MYY) || dzo.MYY.get(0) == null)) {
                    String str = dzo.MYY.get(0).Md5;
                    EmojiInfo blk = bj.gCJ().OpN.blk(str);
                    Intent intent = new Intent();
                    intent.putExtra("custom_smiley_preview_md5", str);
                    if (!(blk.field_catalog == EmojiGroupInfo.VkP || blk.field_catalog == EmojiGroupInfo.VkO || blk.field_catalog == EmojiGroupInfo.VkN)) {
                        intent.putExtra("custom_smiley_preview_productid", blk.field_groupId);
                    }
                    com.tencent.mm.br.c.b(c.this.activity, "emoji", ".ui.CustomSmileyPreviewUI", intent, 1111);
                    com.tencent.mm.plugin.sns.k.e eVar = com.tencent.mm.plugin.sns.k.e.DUQ;
                    long aOa = com.tencent.mm.plugin.sns.storage.y.aOa(mVar.Epv);
                    String valueOf = String.valueOf(dzo.MYT);
                    e.a aVar = eVar.DVd.get(r.Jb(aOa));
                    if (aVar != null && !aVar.DVP.contains(valueOf)) {
                        aVar.DVP.add(valueOf);
                    }
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener$43", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(203974);
            }
        };
    }

    public final void c(k kVar) {
        this.EBv = kVar;
        if (this.Far != null) {
            this.Far.c(kVar);
        }
    }

    public final void ebz() {
        this.Far.ebz();
        EventCenter.instance.addListener(this.Fbg);
        EventCenter.instance.addListener(this.Fbh);
    }

    public final void removeListener() {
        this.Far.removeListener();
        EventCenter.instance.removeListener(this.Fbg);
        EventCenter.instance.removeListener(this.Fbh);
    }

    public static boolean a(String str, String str2, String str3, SnsInfo snsInfo, int i2) {
        ADInfo adInfo;
        try {
            if (!Util.isNullOrNil(str)) {
                if (i2 == 2) {
                    adInfo = snsInfo.getAtAdInfo();
                } else {
                    adInfo = snsInfo.getAdInfo();
                }
                if (adInfo == null) {
                    Log.e("MicroMsg.TimelineClickListener", "jumpWeApp adInfo==null");
                    return false;
                }
                r.a(str, str2, str3, snsInfo.getAid(), snsInfo.getTraceid(), r.Jb(snsInfo.field_snsId) + ":" + adInfo.uxInfo + ":" + aj.fau() + ":" + System.currentTimeMillis(), adInfo.uxInfo, i2 == 0 ? 1045 : 1046);
                return true;
            }
        } catch (Exception e2) {
            Log.e("MicroMsg.TimelineClickListener", "jumpWeApp exp:" + e2.toString());
        }
        return false;
    }

    public final void a(BaseTimeLineItem.BaseViewHolder baseViewHolder, Bundle bundle) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.Fan != null) {
            Log.w("MicroMsg.TimelineClickListener", "has already prepare click animation");
        } else if (baseViewHolder instanceof a.C1738a) {
            this.Fan = new com.tencent.mm.plugin.sns.ui.b.b.d((MMActivity) this.activity, baseViewHolder);
            this.Fao = new com.tencent.mm.plugin.sns.ui.b.b.c((MMActivity) this.activity, baseViewHolder);
            ((a.C1738a) baseViewHolder).EYi = true;
        } else if (baseViewHolder instanceof f.a) {
            f.a aVar = (f.a) baseViewHolder;
            if (bundle != null) {
                z3 = bundle.getBoolean("isFromTwist", false);
                z2 = bundle.getBoolean("isSimpleTwistAnim", false);
                z = bundle.getBoolean("isTwistClockwise", false);
            } else {
                z = false;
                z2 = false;
                z3 = false;
            }
            if (!z3) {
                this.Fan = new com.tencent.mm.plugin.sns.ui.b.b.f((MMActivity) this.activity, baseViewHolder);
            } else if (z2) {
                this.Fan = new com.tencent.mm.plugin.sns.ui.b.b.g((MMActivity) this.activity, baseViewHolder, z);
            }
            this.Fao = new com.tencent.mm.plugin.sns.ui.b.b.e((MMActivity) this.activity, baseViewHolder);
            aVar.EYi = true;
        } else if (baseViewHolder instanceof p.b) {
            this.Fan = new com.tencent.mm.plugin.sns.ui.b.b.k((MMActivity) this.activity, baseViewHolder);
            this.Fao = new com.tencent.mm.plugin.sns.ui.b.b.j((MMActivity) this.activity, baseViewHolder);
        } else if (baseViewHolder instanceof n.a) {
            this.Fan = new com.tencent.mm.plugin.sns.ui.b.b.i((MMActivity) this.activity, baseViewHolder);
            this.Fao = new com.tencent.mm.plugin.sns.ui.b.b.h((MMActivity) this.activity, baseViewHolder);
        }
    }

    public final void a(com.tencent.mm.plugin.sns.ui.c.a.a aVar, Bundle bundle) {
        boolean z;
        boolean z2;
        boolean z3;
        if (this.Fap != null) {
            Log.w("MicroMsg.TimelineClickListener", "has already prepare detail click animation");
        } else if (aVar instanceof com.tencent.mm.plugin.sns.ui.c.a.b) {
            this.Fap = new com.tencent.mm.plugin.sns.ui.b.a.d((MMActivity) this.activity, aVar);
            this.Faq = new com.tencent.mm.plugin.sns.ui.b.a.c((MMActivity) this.activity, aVar);
        } else if (aVar instanceof com.tencent.mm.plugin.sns.ui.c.a.c) {
            if (bundle != null) {
                z3 = bundle.getBoolean("isFromTwist", false);
                z2 = bundle.getBoolean("isSimpleTwistAnim", false);
                z = bundle.getBoolean("isTwistClockwise", false);
            } else {
                z = false;
                z2 = false;
                z3 = false;
            }
            if (!z3) {
                this.Fap = new com.tencent.mm.plugin.sns.ui.b.a.f((MMActivity) this.activity, aVar);
            } else if (z2) {
                this.Fap = new com.tencent.mm.plugin.sns.ui.b.a.g((MMActivity) this.activity, aVar, z);
            }
            this.Faq = new com.tencent.mm.plugin.sns.ui.b.a.e((MMActivity) this.activity, aVar);
        } else if (aVar instanceof com.tencent.mm.plugin.sns.ui.c.a.f) {
            this.Fap = new com.tencent.mm.plugin.sns.ui.b.a.k((MMActivity) this.activity, aVar);
            this.Faq = new com.tencent.mm.plugin.sns.ui.b.a.j((MMActivity) this.activity, aVar);
        } else if (aVar instanceof com.tencent.mm.plugin.sns.ui.c.a.d) {
            this.Fap = new com.tencent.mm.plugin.sns.ui.b.a.i((MMActivity) this.activity, aVar);
            this.Faq = new com.tencent.mm.plugin.sns.ui.b.a.h((MMActivity) this.activity, aVar);
        }
    }

    static /* synthetic */ SnsInfo fC(View view) {
        if (view.getTag() instanceof bc) {
            return com.tencent.mm.plugin.sns.storage.f.aQm(((bc) view.getTag()).dJX);
        }
        if (view.getTag() instanceof MaskImageView) {
            MaskImageView maskImageView = (MaskImageView) view.getTag();
            if (maskImageView.getTag() instanceof bc) {
                return com.tencent.mm.plugin.sns.storage.f.aQm(((bc) maskImageView.getTag()).dJX);
            }
        } else if (view.getTag() instanceof at) {
            return aj.faO().aQm(((at) view.getTag()).dHp);
        } else {
            if (view.getTag() instanceof BaseTimeLineItem.BaseViewHolder) {
                return com.tencent.mm.plugin.sns.storage.f.aQl(((BaseTimeLineItem.BaseViewHolder) view.getTag()).dRS);
            }
            if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                return ((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag()).DsC;
            }
        }
        return null;
    }

    static /* synthetic */ void a(c cVar, View view, SnsInfo snsInfo, int i2, String str, boolean z) {
        at atVar;
        int i3;
        at atVar2 = null;
        if (view.getTag() instanceof at) {
            atVar2 = (at) view.getTag();
        }
        if (view.getTag() instanceof BaseTimeLineItem.BaseViewHolder) {
            atVar2 = ((BaseTimeLineItem.BaseViewHolder) view.getTag()).EUK;
        }
        if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
            atVar = ((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag()).EUK;
        } else {
            atVar = atVar2;
        }
        if (snsInfo != null && atVar != null) {
            if (cVar.Epj != null) {
                cVar.Epj.fat().M(snsInfo);
            }
            boolean isAd = snsInfo.isAd();
            TimeLineObject timeLine = snsInfo.getTimeLine();
            if (timeLine.ContentObj.LoV == null || timeLine.ContentObj.LoV.size() == 0) {
                Log.e("MicroMsg.TimelineClickListener", "the obj.ContentObj.MediaObjList is null");
                return;
            }
            cnb cnb = timeLine.ContentObj.LoV.get(0);
            if (isAd) {
                aj.faL();
                if (!com.tencent.mm.plugin.sns.model.g.u(cnb)) {
                    atVar.EeS.setVisibility(8);
                    atVar.Ewv.setVisibility(0);
                    atVar.Ewv.gYN();
                    aj.faL().A(cnb);
                    com.tencent.mm.plugin.sns.model.c faJ = aj.faJ();
                    bp gCZ = bp.gCZ();
                    gCZ.hXs = timeLine.CreateTime;
                    faJ.a(cnb, 4, (com.tencent.mm.plugin.sns.data.n) null, gCZ);
                    return;
                }
            }
            if ((snsInfo.isAd() && snsInfo.getAdXml().isLandingPagesAd() && i.aQg(str)) || !isAd || !aj.faL().v(cnb)) {
                int[] iArr = new int[2];
                atVar.Ewu.getLocationInWindow(iArr);
                int width = atVar.Ewu.getWidth();
                int height = atVar.Ewu.getHeight();
                if (!snsInfo.isAd() || !snsInfo.getAdXml().isLandingPagesAd() || !i.aQg(str)) {
                    Log.e("MicroMsg.TimelineClickListener", "cardSelectLeftLsn invalid ad style");
                    return;
                }
                if (view.getTag() instanceof BaseTimeLineItem.BaseViewHolder) {
                    cVar.a((BaseTimeLineItem.BaseViewHolder) view.getTag(), (Bundle) null);
                } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                    cVar.a((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag(), (Bundle) null);
                }
                String Q = i.Q(snsInfo);
                if (!Util.isNullOrNil(Q)) {
                    snsInfo.getAdSnsInfo().field_adxml = Q;
                }
                int i4 = cVar.source;
                int i5 = cVar.source == 0 ? 1 : 2;
                long j2 = snsInfo.field_snsId;
                if (z) {
                    i3 = 22;
                } else {
                    i3 = 21;
                }
                SnsAdClick snsAdClick = new SnsAdClick(i4, i5, j2, i2, i3);
                com.tencent.mm.plugin.sns.data.k.a(snsAdClick, cVar.EBv, snsInfo, i2);
                r.a(snsAdClick);
                Intent intent = new Intent();
                intent.putExtra("img_gallery_left", iArr[0]);
                intent.putExtra("img_gallery_top", iArr[1]);
                intent.putExtra("img_gallery_width", width);
                intent.putExtra("img_gallery_height", height);
                intent.putExtra("sns_landing_pages_share_sns_id", snsInfo.getSnsId());
                intent.putExtra("sns_landing_pages_rawSnsId", snsInfo.getTimeLine().Id);
                intent.putExtra("sns_landing_pages_ux_info", snsInfo.getUxinfo());
                TimeLineObject timeLine2 = snsInfo.getTimeLine();
                if (timeLine2 != null) {
                    LinkedList<cnb> linkedList = timeLine2.ContentObj.LoV;
                    if (linkedList.size() > 0) {
                        intent.putExtra("sns_landing_pages_share_thumb_url", linkedList.get(0).Msz);
                    }
                }
                intent.setClass(cVar.activity, SnsAdNativeLandingPagesUI.class);
                int i6 = 1;
                if (cVar.source == 2) {
                    i6 = 16;
                } else if (cVar.source == 1) {
                    i6 = 2;
                }
                intent.putExtra("sns_landig_pages_from_source", i6);
                intent.putExtra("sns_landing_pages_xml", str);
                intent.putExtra("sns_landing_pages_rec_src", snsInfo.getAdRecSrc());
                intent.putExtra("sns_landing_pages_xml_prefix", com.tencent.mm.g.c.f.COL_ADXML);
                intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
                intent.putExtra("sns_landing_is_native_sight_ad", true);
                Activity activity2 = cVar.activity;
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(activity2, bl.axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener", "cardSelectSightCanvas", "(Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;ILjava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                activity2.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(activity2, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener", "cardSelectSightCanvas", "(Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;ILjava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                cVar.activity.overridePendingTransition(0, 0);
                return;
            }
            aj.faL().A(cnb);
            atVar.EeS.setVisibility(8);
            atVar.Ewv.setVisibility(8);
            com.tencent.mm.plugin.sns.model.g faL = aj.faL();
            VideoSightView videoSightView = atVar.Ews;
            int hashCode = cVar.activity.hashCode();
            int i7 = atVar.position;
            bp gCZ2 = bp.gCZ();
            gCZ2.hXs = timeLine.CreateTime;
            faL.a(snsInfo, cnb, videoSightView, hashCode, i7, gCZ2, isAd);
            atVar.Ews.start();
        }
    }

    static /* synthetic */ void b(c cVar, View view, SnsInfo snsInfo, int i2, String str, boolean z) {
        MaskImageView maskImageView;
        int i3;
        if (view.getTag() instanceof BaseTimeLineItem.BaseViewHolder) {
            BaseTimeLineItem.BaseViewHolder baseViewHolder = (BaseTimeLineItem.BaseViewHolder) view.getTag();
            if (baseViewHolder instanceof a.C1738a) {
                maskImageView = ((a.C1738a) baseViewHolder).EVm;
            } else {
                maskImageView = baseViewHolder.EWX.ZD(0);
            }
        } else if (view.getTag() instanceof MaskImageView) {
            maskImageView = (MaskImageView) view.getTag();
        } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.b) {
            maskImageView = ((com.tencent.mm.plugin.sns.ui.c.a.b) view.getTag()).EUS;
        } else {
            maskImageView = (TagImageView) view;
        }
        if (snsInfo.getAdXml().isLandingPagesAd() && i.aQg(str)) {
            if (view.getTag() instanceof BaseTimeLineItem.BaseViewHolder) {
                cVar.a((BaseTimeLineItem.BaseViewHolder) view.getTag(), (Bundle) null);
            } else if (view.getTag() instanceof com.tencent.mm.plugin.sns.ui.c.a.a) {
                cVar.a((com.tencent.mm.plugin.sns.ui.c.a.a) view.getTag(), (Bundle) null);
            }
            int i4 = cVar.source;
            int i5 = cVar.source == 0 ? 1 : 2;
            long j2 = snsInfo.field_snsId;
            if (z) {
                i3 = 22;
            } else {
                i3 = 21;
            }
            SnsAdClick snsAdClick = new SnsAdClick(i4, i5, j2, i2, i3);
            com.tencent.mm.plugin.sns.data.k.a(snsAdClick, cVar.EBv, snsInfo, i2);
            r.a(snsAdClick);
            String Q = i.Q(snsInfo);
            if (!Util.isNullOrNil(Q)) {
                snsInfo.getAdSnsInfo().field_adxml = Q;
            }
            int[] iArr = new int[2];
            if (com.tencent.mm.ui.ao.gJK()) {
                maskImageView.getLocationOnScreen(iArr);
            } else {
                maskImageView.getLocationInWindow(iArr);
            }
            int width = maskImageView.getWidth();
            int height = maskImageView.getHeight();
            Intent intent = new Intent();
            intent.putExtra("img_gallery_left", iArr[0]);
            intent.putExtra("img_gallery_top", iArr[1]);
            intent.putExtra("img_gallery_width", width);
            intent.putExtra("img_gallery_height", height);
            intent.putExtra("sns_landing_pages_share_sns_id", snsInfo.getSnsId());
            intent.putExtra("sns_landing_pages_rawSnsId", snsInfo.getTimeLine().Id);
            intent.putExtra("sns_landing_pages_ux_info", snsInfo.getUxinfo());
            intent.putExtra("sns_landing_pages_aid", snsInfo.getAid());
            intent.putExtra("sns_landing_pages_traceid", snsInfo.getTraceid());
            TimeLineObject timeLine = snsInfo.getTimeLine();
            if (timeLine != null) {
                LinkedList<cnb> linkedList = timeLine.ContentObj.LoV;
                if (linkedList.size() > 0) {
                    intent.putExtra("sns_landing_pages_share_thumb_url", linkedList.get(0).Msz);
                }
            }
            intent.setClass(cVar.activity, SnsAdNativeLandingPagesUI.class);
            int i6 = 1;
            if (cVar.source == 2) {
                i6 = 16;
            } else if (cVar.source == 1) {
                i6 = 2;
            }
            intent.putExtra("sns_landig_pages_from_source", i6);
            intent.putExtra("sns_landing_pages_xml", str);
            intent.putExtra("sns_landing_pages_rec_src", snsInfo.getAdRecSrc());
            intent.putExtra("sns_landing_pages_xml_prefix", com.tencent.mm.g.c.f.COL_ADXML);
            intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", true);
            Activity activity2 = cVar.activity;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(activity2, bl.axQ(), "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener", "cardSelectPicCanvas", "(Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;ILjava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            activity2.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(activity2, "com/tencent/mm/plugin/sns/ui/listener/TimelineClickListener", "cardSelectPicCanvas", "(Landroid/view/View;Lcom/tencent/mm/plugin/sns/storage/SnsInfo;ILjava/lang/String;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            cVar.activity.overridePendingTransition(0, 0);
            if (cVar.Epj != null) {
                cVar.Epj.fat().M(snsInfo);
            }
        }
    }

    static /* synthetic */ ADInfo a(c cVar, SnsInfo snsInfo) {
        if (snsInfo == null) {
            return null;
        }
        if (cVar.source == 2) {
            return snsInfo.getAtAdInfo();
        }
        return snsInfo.getAdInfo();
    }

    static /* synthetic */ void a(c cVar, Intent intent, SnsInfo snsInfo) {
        if (cVar.EBv == null || snsInfo == null) {
            Log.e("MicroMsg.TimelineClickListener", "snsAdStatistic or intent or info is null");
        } else if (bk.Y(snsInfo) != 9 && bk.Y(snsInfo) != 19) {
            Log.i("MicroMsg.TimelineClickListener", "viewType is not TYPE_SIGHT and is not TYPE_AD_SIGHT");
        } else if (snsInfo.getAdXml().adVideoContinuePlay) {
            long IV = cVar.EBv.IV(snsInfo.field_snsId);
            Log.i("MicroMsg.TimelineClickListener", "snsId = " + snsInfo.field_snsId + ", adSightVideoSeekTime = " + IV);
            intent.putExtra("sns_landing_page_sight_video_seek_time", IV);
        }
    }

    static /* synthetic */ boolean a(c cVar, ADInfo aDInfo, SnsInfo snsInfo, boolean z) {
        if (aDInfo == null) {
            return false;
        }
        String str = "";
        String str2 = "";
        String str3 = "";
        if (z && snsInfo.getAdXml().adTurnInfo.appUserName != null) {
            str = snsInfo.getAdXml().adTurnInfo.appUserName;
            str2 = snsInfo.getAdXml().adTurnInfo.dCx;
            str3 = snsInfo.getAdXml().adTurnInfo.appVersion;
        } else if (!z && aDInfo.adActionType == 4 && aDInfo.actionExtWeApp != null) {
            str = aDInfo.actionExtWeApp.appUserName;
            str2 = aDInfo.actionExtWeApp.dCx;
            str3 = aDInfo.actionExtWeApp.appVersion;
        }
        return a(str, str2, str3, snsInfo, cVar.source);
    }

    static /* synthetic */ void a(c cVar, TimeLineObject timeLineObject) {
        if (timeLineObject != null && timeLineObject.actionInfo != null && timeLineObject.actionInfo.KEw != null && com.tencent.mm.pluginsdk.model.app.h.gq(timeLineObject.actionInfo.KEw.jfi)) {
            be beVar = timeLineObject.actionInfo;
            com.tencent.mm.plugin.sns.c.a.jRu.a(cVar.activity, beVar.KEw.jfi, com.tencent.mm.plugin.sns.c.a.jRu.go(beVar.KEw.jfi), timeLineObject.UserName, 38, 19, 10, beVar.KEw.KEq, timeLineObject.Id);
        }
    }
}
