package com.tencent.mm.ui.chatting.viewitems;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.liteapp.storage.WxaLiteAppInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.aa;
import com.tencent.mm.ag.k;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.av.r;
import com.tencent.mm.chatroom.d.y;
import com.tencent.mm.chatroom.d.z;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.g.a.ef;
import com.tencent.mm.g.a.kj;
import com.tencent.mm.g.a.nt;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.g.a.rc;
import com.tencent.mm.i.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.cl;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.lite.a.a;
import com.tencent.mm.plugin.sns.b.j;
import com.tencent.mm.plugin.topstory.a.i;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.r;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.pluginsdk.ui.applet.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.fat;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI;
import com.tencent.mm.ui.chatting.ac;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.d.b.m;
import com.tencent.mm.ui.chatting.t;
import com.tencent.mm.ui.chatting.viewitems.ai;
import com.tencent.mm.ui.chatting.viewitems.bd;
import com.tencent.mm.ui.chatting.viewitems.c;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.tools.x;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.transmit.g;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;

public final class e {
    private static boolean ESt = false;

    public static class g {
        public String MxJ;
        public h PJr;
        public int PJs = -1;
        public String dRr;
        public int ixW = 0;
        public css jfy = null;
        public long msgId;
        public String xml;
    }

    public static class h {
        public String JwO;
        public String coverUrl;
        public String iAA;
        public String playUrl;
        public String title;
        public String url;
    }

    static /* synthetic */ void b(ca caVar, c.a aVar, com.tencent.mm.ui.chatting.e.a aVar2, int i2) {
        AppMethodBeat.i(233615);
        a(caVar, aVar, aVar2, i2, 1);
        AppMethodBeat.o(233615);
    }

    static /* synthetic */ boolean n(k.b bVar) {
        AppMethodBeat.i(233608);
        boolean l = l(bVar);
        AppMethodBeat.o(233608);
        return l;
    }

    public static class d extends c {
        protected t.i PJg;
        protected t.l PJh;
        protected t.j PJi;
        private com.tencent.mm.ui.chatting.e.a PhN;
        private boolean tcb;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return false;
        }

        private t.i j(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(36791);
            if (this.PJg == null) {
                this.PJg = new t.i(aVar);
            }
            t.i iVar = this.PJg;
            AppMethodBeat.o(36791);
            return iVar;
        }

        private t.l k(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(36792);
            if (this.PJh == null) {
                this.PJh = new t.l(aVar);
            }
            t.l lVar = this.PJh;
            AppMethodBeat.o(36792);
            return lVar;
        }

        private t.j l(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(36793);
            if (this.PJi == null) {
                this.PJi = new t.j(aVar);
            }
            t.j jVar = this.PJi;
            AppMethodBeat.o(36793);
            return jVar;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (z || (i2 != 49 && i2 != 335544369 && i2 != 402653233 && i2 != 369098801 && i2 != 738197553 && i2 != 905969713)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36794);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.r7);
                view.setTag(new c().F(view, true));
            }
            AppMethodBeat.o(36794);
            return view;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final void a(c.a aVar, int i2, final com.tencent.mm.ui.chatting.e.a aVar2, ca caVar, String str) {
            String str2;
            com.tencent.mm.ag.t tVar;
            k.b bVar;
            String str3;
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            bq bqVar;
            boolean z5;
            String str4;
            String str5;
            int indexOf;
            AppMethodBeat.i(36795);
            final c cVar = (c) aVar;
            this.PhN = aVar2;
            cVar.reset();
            String content = caVar.getContent();
            m mVar = (m) aVar2.bh(m.class);
            mVar.bX(caVar);
            mVar.bY(caVar);
            mVar.bZ(caVar);
            if (!this.tcb || (indexOf = caVar.getContent().indexOf(58)) == -1) {
                str2 = content;
            } else {
                str2 = caVar.getContent().substring(indexOf + 1);
            }
            if (str2 != null) {
                k.b aD = k.b.aD(str2, caVar.ajQ());
                tVar = com.tencent.mm.ag.t.HI(str2);
                bVar = aD;
            } else {
                Log.e("MicroMsg.ChattingItemAppMsgFrom", "amessage, msgid:%s, user:%s", Long.valueOf(caVar.ajL()), str);
                tVar = null;
                bVar = null;
            }
            bq bqVar2 = new bq(caVar, aVar2.gRM(), i2, (String) null, (char) 0);
            boolean z6 = false;
            cVar.PIY.setVisibility(8);
            if (bVar != null) {
                cVar.PHN.aw(bVar.getTitle());
                cVar.jBR.setText(bVar.getDescription());
                cVar.PHS.setMaxLines(1);
                cVar.PHN.setTextColor(aVar2.getContext().getResources().getColor(R.color.FG_0));
                cVar.jBR.setTextColor(aVar2.getContext().getResources().getColor(R.color.u_));
                cVar.PIi.setBackgroundResource(R.drawable.mw);
                cVar.PIi.setPadding(0, aVar2.getContext().getResources().getDimensionPixelSize(R.dimen.ib), 0, 0);
                cVar.PHM.setVisibility(0);
                cVar.PIg.setVisibility(0);
                cVar.jBR.setVisibility(0);
                cVar.PHU.setVisibility(8);
                cVar.PHX.setVisibility(8);
                cVar.PHW.setVisibility(8);
                cVar.PIk.setVisibility(8);
                cVar.PIl.setVisibility(8);
                cVar.PHP.setVisibility(8);
                cVar.PHQ.setVisibility(8);
                cVar.PIu.setVisibility(8);
                cVar.PIo.setVisibility(8);
                cVar.PIi.setVisibility(0);
                cVar.PIB.setVisibility(8);
                cVar.PIJ.setVisibility(8);
                cVar.PIR.setVisibility(8);
                cVar.PIW.setVisibility(8);
                cVar.resetChatBubbleWidth(cVar.PIh, cVar.PJa);
                bVar.as(com.tencent.mm.ag.h.class);
                cVar.PIh.setBackgroundResource(R.drawable.mw);
                com.tencent.mm.pluginsdk.model.app.g gE = com.tencent.mm.pluginsdk.model.app.h.gE(bVar.appId, bVar.appVersion);
                if (gE != null) {
                    b(aVar2, bVar, caVar);
                }
                if (gE == null || gE.field_appName == null || gE.field_appName.trim().length() <= 0) {
                    str3 = bVar.appName;
                } else {
                    str3 = gE.field_appName;
                }
                boolean z7 = true;
                com.tencent.mm.cb.a.fromDPToPix((Context) aVar2.getContext(), 12);
                if (bVar.type == 20 || "wxaf060266bfa9a35c".equals(bVar.appId)) {
                    z7 = o.a.glW().eUk();
                }
                if (z7 && bVar.appId != null && bVar.appId.length() > 0 && gp(str3)) {
                    String a2 = com.tencent.mm.pluginsdk.model.app.h.a(aVar2.getContext(), gE, str3);
                    if (bVar.type == 19) {
                        cVar.tln.setText(aVar2.getContext().getResources().getString(R.string.fjd, a2));
                    } else {
                        cVar.tln.setText(a2);
                    }
                    cVar.tln.setVisibility(0);
                    cVar.tln.setCompoundDrawables(null, null, null, null);
                    cVar.PHR.setVisibility(0);
                    cVar.PHO.setVisibility(0);
                    if (gE == null || !gE.NA()) {
                        a(aVar2, (View) cVar.tln, bVar.appId);
                    } else {
                        a(aVar2, cVar.tln, caVar, bVar, gE.field_packageName, caVar.ajM());
                    }
                    cVar.PHO.setImageResource(R.drawable.ob);
                    a(aVar2, cVar.PHO, bVar.appId);
                    z = true;
                } else if (bVar.type == 24) {
                    cVar.tln.setText(MMApplicationContext.getContext().getString(R.string.c8z));
                    cVar.PHR.setVisibility(0);
                    cVar.tln.setVisibility(0);
                    cVar.PHO.setVisibility(8);
                    z = true;
                } else if (bVar.type == 19 || tVar.iAl == 19) {
                    cVar.tln.setText(MMApplicationContext.getContext().getString(R.string.azt));
                    cVar.PHR.setVisibility(0);
                    cVar.tln.setVisibility(0);
                    cVar.PHO.setVisibility(8);
                    z = true;
                } else if (!e.a(bVar, cVar)) {
                    cVar.PHR.setVisibility(8);
                    cVar.tln.setVisibility(8);
                    cVar.PHO.setVisibility(8);
                    z = false;
                } else {
                    z = true;
                }
                if (bVar.aSx()) {
                    cVar.PHR.setVisibility(8);
                    z2 = false;
                } else {
                    z2 = z;
                }
                cVar.PHR.setBackgroundResource(R.drawable.aij);
                boolean z8 = false;
                cVar.PHM.setVisibility(0);
                if (bVar.aSy() || !this.qoo) {
                    cVar.PHM.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), R.drawable.bjm));
                    z3 = false;
                } else {
                    final Bitmap bitmap = null;
                    if (!(bVar.type == 33 || bVar.type == 36 || bVar.type == 44 || bVar.type == 48 || b.bnh(caVar.ajP()))) {
                        bitmap = q.bcR().d(caVar.ajP(), com.tencent.mm.cb.a.getDensity(aVar2.getContext()));
                    }
                    if (bitmap == null || bitmap.isRecycled()) {
                        z8 = true;
                    } else {
                        cVar.PHM.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(bitmap, false, (float) com.tencent.mm.cb.a.fromDPToPix((Context) aVar2.getContext(), 1)));
                    }
                    if (e.m(bVar) == 3) {
                        cVar.PIi.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.e.d.AnonymousClass1 */
                            private boolean qCs = false;

                            public final boolean onPreDraw() {
                                AppMethodBeat.i(36771);
                                if (this.qCs) {
                                    cVar.PIi.getViewTreeObserver().removeOnPreDrawListener(this);
                                    AppMethodBeat.o(36771);
                                } else {
                                    cVar.PIi.getViewTreeObserver().removeOnPreDrawListener(this);
                                    this.qCs = true;
                                    int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) aVar2.Pwc.getContext(), 24);
                                    Bitmap bitmap = bitmap;
                                    if (bitmap == null || bitmap.isRecycled()) {
                                        bitmap = BitmapUtil.createColorBitmap(aVar2.Pwc.getContext().getResources().getColor(R.color.iu), fromDPToPix, fromDPToPix);
                                    }
                                    int height = bitmap.getHeight();
                                    if (fromDPToPix <= height) {
                                        height = fromDPToPix;
                                    }
                                    Bitmap fastblur = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap(bitmap, height, height, true), 0.9f), 20);
                                    int height2 = cVar.PIi.getHeight();
                                    int width = cVar.PIi.getWidth();
                                    if (height2 == 0) {
                                        height2 = com.tencent.mm.cb.a.aG(aVar2.Pwc.getContext(), R.dimen.x_);
                                    }
                                    if (width == 0) {
                                        width = com.tencent.mm.cb.a.aG(aVar2.Pwc.getContext(), R.dimen.xa);
                                    }
                                    cVar.PIi.setBackgroundDrawable(new BitmapDrawable(BitmapUtil.createMaskImage(fastblur, R.drawable.c3c, width, height2)));
                                    AppMethodBeat.o(36771);
                                }
                                return true;
                            }
                        });
                        if (ao.isDarkMode()) {
                            cVar.PHR.setBackgroundResource(R.drawable.aij);
                            z3 = z8;
                        } else {
                            cVar.PHR.setBackgroundResource(R.drawable.nw);
                        }
                    }
                    z3 = z8;
                }
                if (bVar.fQR == null || bVar.fQR.length() == 0) {
                    cVar.PHZ.setVisibility(8);
                } else {
                    cVar.PHZ.setVisibility(0);
                    b(aVar2, cVar.PHZ, bq.bnn(bVar.fQR));
                }
                cVar.PHY.setOnClickListener(null);
                cVar.PIc.setVisibility(0);
                cVar.PHT.setVisibility(8);
                cVar.PIf.setVisibility(0);
                cVar.PId.setVisibility(8);
                int m = e.m(bVar);
                if (bVar.type == 66) {
                    if (!TextUtils.isEmpty(bVar.izi) || !TextUtils.isEmpty(bVar.izj)) {
                        m = 33;
                    } else {
                        m = 5;
                    }
                }
                switch (m) {
                    case 0:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            cVar.PHN.setVisibility(8);
                        } else {
                            cVar.PHN.setVisibility(0);
                        }
                        cVar.jBR.setVisibility(0);
                        cVar.PHS.setVisibility(8);
                        cVar.PHY.setVisibility(8);
                        cVar.PHT.setVisibility(4);
                        cVar.jBR.setMaxLines(2);
                        if (z3) {
                            Bitmap c2 = com.tencent.mm.pluginsdk.model.app.h.c(bVar.appId, 1, com.tencent.mm.cb.a.getDensity(aVar2.getContext()));
                            if (c2 != null && !c2.isRecycled()) {
                                cVar.PHM.setImageBitmap(c2);
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            } else {
                                cVar.PHM.setImageResource(R.raw.app_attach_file_icon_webpage);
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            }
                        }
                        z4 = false;
                        bqVar = bqVar2;
                        break;
                    case 1:
                    case 2:
                    case 8:
                    case 9:
                    case 11:
                    case 12:
                    case 14:
                    case 17:
                    case 18:
                    case 21:
                    case 22:
                    case 23:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 35:
                    case 37:
                    case 38:
                    case 39:
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_RIGHT_CREATOR:
                    case 42:
                    case 43:
                    case 45:
                    case 46:
                    case 47:
                    default:
                        z4 = true;
                        bqVar = bqVar2;
                        break;
                    case 3:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            cVar.PHN.setVisibility(8);
                        } else {
                            cVar.PHN.setVisibility(0);
                            cVar.PHN.setTextColor(aVar2.getContext().getResources().getColor(R.color.ag2));
                        }
                        cVar.jBR.setVisibility(0);
                        cVar.jBR.setTextColor(aVar2.getContext().getResources().getColor(R.color.ag2));
                        cVar.PHS.setVisibility(8);
                        cVar.PHT.setVisibility(4);
                        cVar.PHY.setVisibility(0);
                        if ((caVar.ajL() + "_msg").equals(aVar.playingMsgId)) {
                            cVar.PHY.setImageResource(R.drawable.alq);
                        } else {
                            cVar.PHY.setImageResource(R.drawable.am5);
                        }
                        cVar.jBR.setMaxLines(2);
                        if (z3) {
                            Bitmap c3 = com.tencent.mm.pluginsdk.model.app.h.c(bVar.appId, 1, com.tencent.mm.cb.a.getDensity(aVar2.getContext()));
                            if (c3 == null || c3.isRecycled()) {
                                cVar.PHM.setImageResource(R.raw.app_attach_file_icon_music);
                            } else {
                                cVar.PHM.setImageBitmap(c3);
                            }
                        }
                        g gVar = new g();
                        gVar.msgId = caVar.ajL();
                        gVar.xml = caVar.getContent();
                        gVar.dRr = caVar.ajP();
                        cVar.PHY.setTag(gVar);
                        cVar.PHY.setOnClickListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOD());
                        z4 = false;
                        bqVar = bqVar2;
                        break;
                    case 4:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            cVar.PHN.setVisibility(8);
                        } else {
                            cVar.PHN.setVisibility(0);
                        }
                        cVar.jBR.setVisibility(0);
                        cVar.PHS.setVisibility(8);
                        cVar.PHY.setVisibility(0);
                        cVar.PHY.setImageResource(R.drawable.b1k);
                        cVar.PHT.setVisibility(4);
                        cVar.jBR.setMaxLines(2);
                        if (z3) {
                            c.a aVar3 = new c.a();
                            aVar3.ty(R.raw.app_attach_file_icon_webpage).bdq().dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50)).bdo().bdt().aw((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1));
                            q.bcV().a(Util.isNullOrNil(bVar.thumburl) ? bVar.iwO : bVar.thumburl, cVar.PHM, aVar3.bdv());
                            cVar.PHY.setVisibility(8);
                            z4 = false;
                            bqVar = bqVar2;
                            break;
                        }
                        z4 = false;
                        bqVar = bqVar2;
                        break;
                    case 5:
                        if (bVar != null) {
                            e.a(str, aVar2, caVar, bVar);
                        }
                        com.tencent.mm.ag.e eVar = (com.tencent.mm.ag.e) bVar.as(com.tencent.mm.ag.e.class);
                        if (eVar != null && eVar.iwe == 1 && eVar.iwc == 5 && ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()) {
                            c.a(aVar2, cVar, bVar, caVar, z3);
                            z4 = false;
                            bqVar = bqVar2;
                            break;
                        } else {
                            if (!z2 && al.a(bVar, eVar)) {
                                cVar.PIR.setVisibility(0);
                                cVar.PIW.setVisibility(0);
                                al.a(aVar2.getContext(), bVar, cVar.PIT, cVar.PIU);
                                al.b(cVar.PIV, bVar);
                            }
                            cVar.PHN.setVisibility(8);
                            if (bVar.title == null || bVar.title.length() <= 0) {
                                cVar.PHS.setVisibility(8);
                            } else {
                                cVar.PHS.setMaxLines(2);
                                cVar.PHS.setVisibility(0);
                                cVar.PHS.setText(bVar.getTitle());
                            }
                            cVar.jBR.setMaxLines(3);
                            if (e.n(bVar)) {
                                cVar.PHY.setVisibility(0);
                                cVar.PHY.setImageResource(R.drawable.b1k);
                            } else {
                                cVar.PHY.setVisibility(8);
                            }
                            cVar.PHT.setVisibility(4);
                            if (z3) {
                                c.a aVar4 = new c.a();
                                aVar4.ty(R.raw.app_attach_file_icon_webpage).bdq().OT(com.tencent.mm.plugin.image.d.dZF()).a(new n()).a(new com.tencent.mm.pluginsdk.ui.applet.e()).dr(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50), com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 50)).bdo().bdt().aw((float) com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1));
                                q.bcV().a(Util.isNullOrNil(bVar.thumburl) ? bVar.iwO : bVar.thumburl, cVar.PHM, aVar4.bdv());
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            }
                            z4 = false;
                            bqVar = bqVar2;
                            break;
                        }
                        break;
                    case 6:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            cVar.PHN.setVisibility(8);
                        } else {
                            cVar.PHN.setVisibility(0);
                            cVar.PHN.setMaxLines(2);
                        }
                        cVar.jBR.setVisibility(0);
                        cVar.PHS.setVisibility(8);
                        cVar.PHY.setVisibility(8);
                        cVar.PHT.setVisibility(4);
                        cVar.jBR.setMaxLines(2);
                        cVar.jBR.setText(Util.getSizeKB((long) bVar.iwI));
                        c.a(cVar, str2, bVar.iwI);
                        c.a(cVar, Boolean.TRUE, caVar, bVar.dCK, bVar.title);
                        if (z3) {
                            if (!b.bng(bVar.iwJ)) {
                                cVar.PHM.setImageResource(r.bdt(bVar.iwJ));
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            } else {
                                cVar.PHM.setImageResource(R.drawable.ba8);
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            }
                        }
                        z4 = false;
                        bqVar = bqVar2;
                        break;
                    case 7:
                        cVar.PHN.setVisibility(8);
                        if (bVar.title == null || bVar.title.trim().length() <= 0) {
                            cVar.PHS.setVisibility(8);
                        } else {
                            cVar.PHS.setMaxLines(2);
                            cVar.PHS.setVisibility(0);
                            cVar.PHS.setText(bVar.getTitle());
                        }
                        cVar.jBR.setMaxLines(3);
                        cVar.PHY.setVisibility(8);
                        cVar.PHT.setVisibility(4);
                        if (z3) {
                            Bitmap c4 = com.tencent.mm.pluginsdk.model.app.h.c(bVar.appId, 1, com.tencent.mm.cb.a.getDensity(aVar2.getContext()));
                            if (c4 != null && !c4.isRecycled()) {
                                cVar.PHM.setImageBitmap(c4);
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            } else {
                                cVar.PHM.setImageResource(R.raw.app_attach_file_icon_webpage);
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            }
                        }
                        z4 = false;
                        bqVar = bqVar2;
                        break;
                    case 10:
                        cVar.PHS.setVisibility(0);
                        if (bVar.ixg == 1) {
                            cVar.PHS.setText(R.string.gdh);
                        } else if (bVar.ixg == 2) {
                            cVar.PHS.setText(R.string.gdj);
                        } else if (bVar.ixg == 3) {
                            cVar.PHS.setText(R.string.gdi);
                        } else {
                            cVar.PHS.setText(R.string.gdk);
                        }
                        if (bVar.title != null && bVar.title.length() > 0) {
                            cVar.PHN.setVisibility(0);
                            cVar.PHN.aw(bVar.getTitle());
                        }
                        cVar.jBR.setMaxLines(4);
                        cVar.PHT.setVisibility(4);
                        cVar.PHY.setVisibility(8);
                        if (z3) {
                            Bitmap b2 = q.bcR().b(caVar.ajP(), com.tencent.mm.cb.a.getDensity(aVar2.getContext()), false);
                            if (b2 != null && !b2.isRecycled()) {
                                cVar.PHM.setImageBitmap(b2);
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            } else {
                                cVar.PHM.setImageResource(R.raw.app_attach_file_icon_webpage);
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            }
                        }
                        z4 = false;
                        bqVar = bqVar2;
                        break;
                    case 13:
                        cVar.PHN.setVisibility(0);
                        cVar.PHN.aw(bVar.getTitle());
                        cVar.PHS.setVisibility(0);
                        cVar.PHS.setText(R.string.b0w);
                        cVar.jBR.setMaxLines(4);
                        cVar.PHT.setVisibility(4);
                        cVar.PHY.setVisibility(8);
                        if (z3) {
                            Bitmap b3 = q.bcR().b(caVar.ajP(), com.tencent.mm.cb.a.getDensity(aVar2.getContext()), false);
                            if (b3 != null && !b3.isRecycled()) {
                                cVar.PHM.setImageBitmap(b3);
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            } else {
                                cVar.PHM.setImageResource(R.raw.app_attach_file_icon_webpage);
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            }
                        }
                        z4 = false;
                        bqVar = bqVar2;
                        break;
                    case 15:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            cVar.PHN.setVisibility(8);
                        } else {
                            cVar.PHN.setVisibility(0);
                        }
                        cVar.jBR.setVisibility(0);
                        cVar.PHS.setVisibility(8);
                        cVar.PHY.setVisibility(8);
                        cVar.PHT.setVisibility(4);
                        cVar.jBR.setMaxLines(2);
                        if (z3) {
                            Bitmap b4 = q.bcR().b(caVar.ajP(), com.tencent.mm.cb.a.getDensity(aVar2.getContext()), false);
                            if (b4 == null || b4.isRecycled()) {
                                cVar.PHM.setImageResource(R.raw.app_attach_file_icon_webpage);
                            } else {
                                cVar.PHM.setImageBitmap(b4);
                            }
                        }
                        bq bqVar3 = new bq(caVar, false, i2, "", false, bVar.title, bVar.eag, bVar.eah, bVar.title, bVar.ixo, bVar.url, false, false);
                        cVar.PIh.setTag(bqVar3);
                        cVar.PIh.setOnClickListener(i(aVar2));
                        z6 = true;
                        z4 = false;
                        bqVar = bqVar3;
                        break;
                    case 16:
                        cVar.PHN.setVisibility(0);
                        cVar.PHN.aw(bVar.description);
                        cVar.jBR.setText(bVar.ixU);
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            cVar.PHS.setVisibility(8);
                        } else {
                            cVar.PHS.setVisibility(0);
                            cVar.PHS.setText(bVar.title);
                        }
                        cVar.jBR.setMaxLines(4);
                        cVar.PHT.setVisibility(4);
                        cVar.PHY.setVisibility(8);
                        if (z3) {
                            Bitmap b5 = q.bcR().b(caVar.ajP(), com.tencent.mm.cb.a.getDensity(aVar2.getContext()), false);
                            if (b5 == null) {
                                cVar.PHM.setImageResource(R.raw.app_attach_file_icon_webpage);
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            } else {
                                cVar.PHM.setImageBitmap(b5);
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            }
                        }
                        z4 = false;
                        bqVar = bqVar2;
                        break;
                    case 19:
                        c.a(aVar2, cVar, bVar, z3);
                        z4 = false;
                        bqVar = bqVar2;
                        break;
                    case 20:
                        if (bVar.title != null && bVar.title.length() > 0) {
                            cVar.PHN.setVisibility(0);
                            cVar.PHN.aw(bVar.getTitle());
                            cVar.PHS.setVisibility(8);
                        }
                        cVar.jBR.setMaxLines(4);
                        cVar.PHT.setVisibility(4);
                        cVar.PHY.setVisibility(8);
                        if (z3) {
                            Bitmap b6 = q.bcR().b(caVar.ajP(), com.tencent.mm.cb.a.getDensity(aVar2.getContext()), false);
                            if (b6 != null && !b6.isRecycled()) {
                                cVar.PHM.setImageBitmap(b6);
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            } else {
                                cVar.PHM.setImageResource(R.raw.app_attach_file_icon_webpage);
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            }
                        }
                        z4 = false;
                        bqVar = bqVar2;
                        break;
                    case 24:
                        cVar.PHN.setVisibility(8);
                        cVar.PHS.setVisibility(0);
                        if (bVar.title == null || bVar.title.trim().length() <= 0) {
                            cVar.PHS.setText(l.b(cVar.PHS.getContext(), MMApplicationContext.getContext().getString(R.string.cd5), cVar.PHS.getTextSize()));
                        } else {
                            cVar.PHS.setText(l.b(cVar.PHS.getContext(), bVar.title, cVar.PHS.getTextSize()));
                        }
                        cVar.jBR.setMaxLines(3);
                        cVar.PHY.setVisibility(8);
                        cVar.PHT.setVisibility(4);
                        if (z3) {
                            cVar.PHM.setVisibility(8);
                            cVar.PIg.setVisibility(8);
                        }
                        c.b(aVar2, cVar, bVar, caVar, z3);
                        z4 = false;
                        bqVar = bqVar2;
                        break;
                    case 25:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            cVar.PHN.setVisibility(8);
                        } else {
                            cVar.PHN.setVisibility(0);
                        }
                        cVar.jBR.setVisibility(0);
                        cVar.PHS.setVisibility(8);
                        cVar.PHY.setVisibility(8);
                        cVar.PHT.setVisibility(4);
                        cVar.jBR.setMaxLines(2);
                        if (z3) {
                            Bitmap b7 = q.bcR().b(caVar.ajP(), com.tencent.mm.cb.a.getDensity(aVar2.getContext()), false);
                            if (b7 == null || b7.isRecycled()) {
                                cVar.PHM.setImageResource(R.raw.app_attach_file_icon_webpage);
                            } else {
                                cVar.PHM.setImageBitmap(b7);
                            }
                        }
                        bq bqVar4 = new bq(caVar, i2, "", aVar2.gOZ(), bVar.eag, bVar.eah, bVar.title, bVar.iyV, bVar.designerName, bVar.designerRediretctUrl, bVar.url);
                        cVar.PIh.setTag(bqVar4);
                        cVar.PIh.setOnClickListener(j(aVar2));
                        z6 = true;
                        z4 = false;
                        bqVar = bqVar4;
                        break;
                    case 26:
                    case 27:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            cVar.PHN.setVisibility(8);
                        } else {
                            cVar.PHN.setVisibility(0);
                        }
                        cVar.jBR.setVisibility(0);
                        cVar.PHS.setVisibility(8);
                        cVar.PHY.setVisibility(8);
                        cVar.PHT.setVisibility(4);
                        cVar.jBR.setMaxLines(2);
                        if (z3) {
                            Bitmap b8 = q.bcR().b(caVar.ajP(), com.tencent.mm.cb.a.getDensity(aVar2.getContext()), false);
                            if (b8 == null || b8.isRecycled()) {
                                cVar.PHM.setImageResource(R.raw.app_attach_file_icon_webpage);
                            } else {
                                cVar.PHM.setImageBitmap(b8);
                            }
                        }
                        bqVar = new bq();
                        bqVar.dTX = caVar;
                        bqVar.Pdm = false;
                        bqVar.position = i2;
                        bqVar.PQC = false;
                        bqVar.title = aVar2.gOZ();
                        bqVar.eag = bVar.eag;
                        bqVar.eah = bVar.eah;
                        bqVar.Nwj = bVar.title;
                        if (bVar.type == 26) {
                            bqVar.tid = bVar.tid;
                            bqVar.iyW = bVar.iyW;
                            bqVar.desc = bVar.desc;
                            bqVar.iconUrl = bVar.iconUrl;
                            bqVar.secondUrl = bVar.secondUrl;
                            bqVar.pageType = bVar.pageType;
                            cVar.PIh.setOnClickListener(k(aVar2));
                            z5 = true;
                        } else if (bVar.type == 27) {
                            bqVar.tid = bVar.tid;
                            bqVar.iyW = bVar.iyW;
                            bqVar.desc = bVar.desc;
                            bqVar.iconUrl = bVar.iconUrl;
                            bqVar.secondUrl = bVar.secondUrl;
                            bqVar.pageType = bVar.pageType;
                            cVar.PIh.setOnClickListener(l(aVar2));
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        cVar.PIh.setTag(bqVar);
                        z4 = false;
                        z6 = z5;
                        break;
                    case 33:
                        WxaAttributes Xk = ((com.tencent.mm.plugin.appbrand.service.q) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(bVar.izi);
                        ((w) com.tencent.mm.kernel.g.af(w.class)).VA(bVar.izi);
                        switch (bVar.izk) {
                            case 1:
                                String str6 = Xk != null ? Xk.field_nickname : bVar.title;
                                String str7 = Xk != null ? Xk.field_smallHeadURL : null;
                                cVar.PIi.setVisibility(8);
                                cVar.PIu.setVisibility(8);
                                cVar.PIo.setVisibility(0);
                                cVar.PIq.setText(str6);
                                cVar.PIB.setVisibility(8);
                                if (Util.isNullOrNil(str7)) {
                                    com.tencent.mm.modelappbrand.a.b.aXY().a(cVar.PIp, "file://".concat(String.valueOf(q.bcR().OF(caVar.ajP()))), com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
                                } else {
                                    com.tencent.mm.modelappbrand.a.b.aXY().a(cVar.PIp, str7, com.tencent.mm.modelappbrand.a.a.aXX(), com.tencent.mm.modelappbrand.a.g.iJB);
                                }
                                if (!e.a(bVar, Xk)) {
                                    cVar.PIA.setVisibility(8);
                                    z4 = false;
                                    bqVar = bqVar2;
                                    break;
                                } else {
                                    cVar.PIA.setVisibility(0);
                                    z4 = false;
                                    bqVar = bqVar2;
                                    break;
                                }
                            case 2:
                            case 3:
                                if (cVar.PIh.getLayoutParams() != null) {
                                    cVar.PIh.getLayoutParams().width = -2;
                                    cVar.PIh.requestLayout();
                                }
                                String str8 = Xk != null ? Xk.field_nickname : bVar.eah;
                                if (Xk != null) {
                                    str4 = Xk.field_smallHeadURL;
                                } else {
                                    str4 = bVar.izB;
                                }
                                cVar.PIi.setVisibility(8);
                                cVar.PIu.setVisibility(0);
                                cVar.PIo.setVisibility(8);
                                cVar.PIB.setVisibility(8);
                                cVar.PIy.setText(bVar.title);
                                e.h(cVar.PIy, bVar.title);
                                cVar.PIs.setText(str8);
                                e.a(cVar.PIt, bVar);
                                q.bcV().a(str4, cVar.PIr, ai.d.gvY);
                                String OF = q.bcR().OF(caVar.ajP());
                                cVar.PIv.setImageBitmap(null);
                                cVar.PIv.setVisibility(4);
                                if (e.a(bVar, Xk)) {
                                    cVar.lrd.setVisibility(0);
                                } else {
                                    cVar.lrd.setVisibility(8);
                                }
                                if (e.a(caVar, bVar, aVar2)) {
                                    cVar.PIY.setVisibility(0);
                                    boolean isNullOrNil = Util.isNullOrNil(caVar.ajU());
                                    cVar.PIY.setTag(caVar);
                                    cVar.PIY.setOnClickListener(new View.OnClickListener() {
                                        /* class com.tencent.mm.ui.chatting.viewitems.e.d.AnonymousClass5 */

                                        public final void onClick(View view) {
                                            AppMethodBeat.i(185027);
                                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                            bVar.bm(view);
                                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                            e.a((ca) view.getTag(), cVar, aVar2);
                                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(185027);
                                        }
                                    });
                                    e.a(isNullOrNil, cVar, aVar2);
                                } else {
                                    cVar.PIY.setVisibility(8);
                                }
                                final boolean o = e.o(bVar);
                                com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k() {
                                    /* class com.tencent.mm.ui.chatting.viewitems.e.d.AnonymousClass6 */

                                    @Override // com.tencent.mm.modelappbrand.a.b.k
                                    public final void aYg() {
                                        AppMethodBeat.i(36778);
                                        AppMethodBeat.o(36778);
                                    }

                                    @Override // com.tencent.mm.modelappbrand.a.b.k
                                    public final void I(Bitmap bitmap) {
                                        AppMethodBeat.i(36779);
                                        if (bitmap == null || bitmap.isRecycled()) {
                                            cVar.PIv.setVisibility(4);
                                            cVar.PIx.setVisibility(0);
                                            cVar.PIw.setVisibility(8);
                                            AppMethodBeat.o(36779);
                                            return;
                                        }
                                        cVar.PIv.setImageBitmap(bitmap);
                                        cVar.PIv.setVisibility(0);
                                        cVar.PIx.setVisibility(4);
                                        if (o) {
                                            cVar.PIw.setImageDrawable(com.tencent.mm.cb.a.l(aVar2.Pwc.getContext(), R.raw.shortvideo_play_btn));
                                            cVar.PIw.setVisibility(0);
                                            AppMethodBeat.o(36779);
                                            return;
                                        }
                                        cVar.PIw.setVisibility(8);
                                        AppMethodBeat.o(36779);
                                    }

                                    @Override // com.tencent.mm.modelappbrand.a.b.k
                                    public final void oD() {
                                        AppMethodBeat.i(36780);
                                        AppMethodBeat.o(36780);
                                    }

                                    @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                                    public final String Lb() {
                                        AppMethodBeat.i(36781);
                                        String format = String.format(Locale.ENGLISH, "CHATTING_ITEM_APPMSG_APPBRAND_COVER[%d %d]", 240, 192);
                                        AppMethodBeat.o(36781);
                                        return format;
                                    }
                                }, e.Lk(OF), (b.h) null, ((com.tencent.mm.modelappbrand.k) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).m10do(240, 192));
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            default:
                                cVar.PHR.setVisibility(0);
                                cVar.PHO.setVisibility(0);
                                cVar.PHO.setBackground(null);
                                cVar.PHO.setImageResource(R.raw.app_brand_we_app_logo_share);
                                e.a(cVar.tln, bVar);
                                z4 = true;
                                bqVar = bqVar2;
                                break;
                        }
                    case 34:
                        if (bVar.title == null || bVar.title.length() <= 0) {
                            cVar.PHN.setVisibility(8);
                        } else {
                            cVar.PHN.setVisibility(0);
                            if (!Util.isNullOrNil(bVar.iyd)) {
                                cVar.PHN.setTextColor(Util.convertStringToRGB(bVar.iyd, aVar2.getContext().getResources().getColor(R.color.a2x)));
                            } else {
                                cVar.PHN.setTextColor(aVar2.getContext().getResources().getColor(R.color.a2x));
                            }
                        }
                        cVar.jBR.setMaxLines(2);
                        cVar.jBR.setVisibility(0);
                        if (!Util.isNullOrNil(bVar.iye)) {
                            cVar.jBR.setTextColor(Util.convertStringToRGB(bVar.iye, aVar2.getContext().getResources().getColor(R.color.tx)));
                        } else {
                            cVar.jBR.setTextColor(aVar2.getContext().getResources().getColor(R.color.tx));
                        }
                        cVar.PHS.setVisibility(8);
                        cVar.PHT.setVisibility(4);
                        cVar.PHY.setVisibility(8);
                        cVar.PHR.setVisibility(0);
                        cVar.tln.setVisibility(0);
                        if (!Util.isNullOrNil(bVar.ixZ)) {
                            cVar.tln.setText(bVar.ixZ);
                        } else {
                            cVar.tln.setText(R.string.azr);
                        }
                        if (!this.qoo) {
                            cVar.PHM.setImageBitmap(BitmapFactory.decodeResource(aVar2.getResources(), R.drawable.bjm));
                            z4 = false;
                            bqVar = bqVar2;
                            break;
                        } else {
                            final Bitmap d2 = q.bcR().d(caVar.ajP(), com.tencent.mm.cb.a.getDensity(aVar2.getContext()));
                            if (d2 != null && !d2.isRecycled()) {
                                cVar.PHM.setImageBitmap(BitmapUtil.getRoundedCornerBitmap(d2, false, (float) (d2.getWidth() / 2)));
                            }
                            if (Util.isNullOrNil(bVar.iyc)) {
                                cVar.PIi.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                                    /* class com.tencent.mm.ui.chatting.viewitems.e.d.AnonymousClass10 */
                                    private boolean qCs = false;

                                    public final boolean onPreDraw() {
                                        AppMethodBeat.i(36789);
                                        if (this.qCs) {
                                            cVar.PIi.getViewTreeObserver().removeOnPreDrawListener(this);
                                            AppMethodBeat.o(36789);
                                        } else {
                                            cVar.PIi.getViewTreeObserver().removeOnPreDrawListener(this);
                                            this.qCs = true;
                                            int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) aVar2.Pwc.getContext(), 24);
                                            Bitmap bitmap = d2;
                                            if (bitmap == null || bitmap.isRecycled()) {
                                                bitmap = BitmapUtil.createColorBitmap(aVar2.Pwc.getContext().getResources().getColor(R.color.iu), fromDPToPix, fromDPToPix);
                                            }
                                            int height = bitmap.getHeight();
                                            if (fromDPToPix <= height) {
                                                height = fromDPToPix;
                                            }
                                            Bitmap fastblur = BitmapUtil.fastblur(BitmapUtil.setContrast(Bitmap.createScaledBitmap(bitmap, height, height, true), 0.9f), 20);
                                            int height2 = cVar.PIi.getHeight();
                                            int width = cVar.PIi.getWidth();
                                            if (height2 == 0) {
                                                height2 = com.tencent.mm.cb.a.aG(aVar2.Pwc.getContext(), R.dimen.x_);
                                            }
                                            if (width == 0) {
                                                width = com.tencent.mm.cb.a.aG(aVar2.Pwc.getContext(), R.dimen.xa);
                                            }
                                            cVar.PIi.setBackgroundDrawable(new BitmapDrawable(BitmapUtil.createMaskImage(fastblur, R.drawable.c3c, width, height2)));
                                            AppMethodBeat.o(36789);
                                        }
                                        return true;
                                    }
                                });
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            } else {
                                q.bcV().a(bVar.iyc, new ImageView(aVar2.getContext()), new c.a().bdp().bdv(), new com.tencent.mm.av.a.c.h() {
                                    /* class com.tencent.mm.ui.chatting.viewitems.e.d.AnonymousClass9 */

                                    @Override // com.tencent.mm.av.a.c.h
                                    public final void b(String str, View view) {
                                    }

                                    @Override // com.tencent.mm.av.a.c.h
                                    public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                                        return null;
                                    }

                                    @Override // com.tencent.mm.av.a.c.h
                                    public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                                        AppMethodBeat.i(36788);
                                        if (bVar.bitmap != null) {
                                            final Bitmap bitmap = bVar.bitmap;
                                            cVar.PIi.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
                                                /* class com.tencent.mm.ui.chatting.viewitems.e.d.AnonymousClass9.AnonymousClass1 */

                                                public final boolean onPreDraw() {
                                                    AppMethodBeat.i(36787);
                                                    cVar.PIi.getViewTreeObserver().removeOnPreDrawListener(this);
                                                    int height = cVar.PIi.getHeight();
                                                    int width = cVar.PIi.getWidth();
                                                    if (height == 0) {
                                                        height = com.tencent.mm.cb.a.aG(aVar2.Pwc.getContext(), R.dimen.x_);
                                                    }
                                                    if (width == 0) {
                                                        width = com.tencent.mm.cb.a.aG(aVar2.Pwc.getContext(), R.dimen.xa);
                                                    }
                                                    cVar.PIi.setBackgroundDrawable(new BitmapDrawable(BitmapUtil.createMaskImage(bitmap, R.drawable.c3c, width, height)));
                                                    AppMethodBeat.o(36787);
                                                    return true;
                                                }
                                            });
                                        }
                                        AppMethodBeat.o(36788);
                                    }
                                });
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            }
                        }
                        break;
                    case 36:
                        if (cVar.PIh.getLayoutParams() != null) {
                            cVar.PIh.getLayoutParams().width = -2;
                            cVar.PIh.requestLayout();
                        }
                        WxaAttributes Xk2 = ((com.tencent.mm.plugin.appbrand.service.q) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.q.class)).Xk(bVar.izi);
                        String str9 = Xk2 != null ? Xk2.field_nickname : bVar.eah;
                        if (Xk2 != null) {
                            str5 = Xk2.field_smallHeadURL;
                        } else {
                            str5 = bVar.izB;
                        }
                        cVar.PIi.setVisibility(8);
                        cVar.PIu.setVisibility(0);
                        cVar.PIo.setVisibility(8);
                        cVar.PIB.setVisibility(8);
                        if (e.a(caVar, bVar, aVar2)) {
                            cVar.PIY.setVisibility(0);
                            boolean isNullOrNil2 = Util.isNullOrNil(caVar.ajU());
                            cVar.PIY.setTag(caVar);
                            cVar.PIY.setOnClickListener(new View.OnClickListener() {
                                /* class com.tencent.mm.ui.chatting.viewitems.e.d.AnonymousClass4 */

                                public final void onClick(View view) {
                                    AppMethodBeat.i(179950);
                                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                    bVar.bm(view);
                                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                    e.a((ca) view.getTag(), cVar, aVar2);
                                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$ChattingItemAppMsgFrom$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                    AppMethodBeat.o(179950);
                                }
                            });
                            e.a(isNullOrNil2, cVar, aVar2);
                        } else {
                            cVar.PIY.setVisibility(8);
                        }
                        cVar.PIy.setText(bVar.title);
                        e.h(cVar.PIy, bVar.title);
                        cVar.PIs.setText(str9);
                        e.a(cVar.PIt, bVar);
                        q.bcV().a(str5, cVar.PIr, ai.d.gvY);
                        String OF2 = q.bcR().OF(caVar.ajP());
                        cVar.PIv.setImageBitmap(null);
                        com.tencent.mm.modelappbrand.a.b.aXY().a(cVar.PIv, "file://".concat(String.valueOf(OF2)), ((com.tencent.mm.modelappbrand.k) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).m10do(240, 192));
                        if (!e.a(bVar, Xk2)) {
                            cVar.lrd.setVisibility(8);
                            z4 = false;
                            bqVar = bqVar2;
                            break;
                        } else {
                            cVar.lrd.setVisibility(0);
                            z4 = false;
                            bqVar = bqVar2;
                            break;
                        }
                    case 40:
                        if (tVar.iAl == 19) {
                            c.a(aVar2, cVar, bVar, z3);
                            z4 = false;
                            bqVar = bqVar2;
                            break;
                        }
                        z4 = false;
                        bqVar = bqVar2;
                        break;
                    case 44:
                        z4 = true;
                        cVar.PHS.setMaxLines(2);
                        cVar.jBR.setMaxLines(3);
                        bqVar = bqVar2;
                        break;
                    case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE:
                        com.tencent.mm.ag.a aVar5 = (com.tencent.mm.ag.a) bVar.as(com.tencent.mm.ag.a.class);
                        String str10 = bVar.izB;
                        String str11 = bVar.eah;
                        String str12 = bVar.title;
                        String str13 = bVar.description;
                        if (aVar5 != null && !Util.isNullOrNil(aVar5.ivm) && !Util.isNullOrNil(aVar5.ivo)) {
                            cVar.PIH.setText(str11);
                            cVar.PIi.setVisibility(8);
                            cVar.PIu.setVisibility(8);
                            cVar.PIo.setVisibility(8);
                            cVar.PII.setVisibility(0);
                            cVar.PIE.setVisibility(8);
                            cVar.PII.setImageDrawable(com.tencent.mm.cb.a.l(aVar2.getContext(), R.raw.shortvideo_play_btn));
                            cVar.PIB.setVisibility(0);
                            cVar.PIC.setText(str12);
                            cVar.PID.setText(str13);
                            q.bcU().a(str10, new r.a() {
                                /* class com.tencent.mm.ui.chatting.viewitems.e.d.AnonymousClass7 */

                                @Override // com.tencent.mm.av.r.a
                                public final void a(String str, final Bitmap bitmap, String str2) {
                                    AppMethodBeat.i(36783);
                                    MMHandlerThread.postToMainThread(new Runnable() {
                                        /* class com.tencent.mm.ui.chatting.viewitems.e.d.AnonymousClass7.AnonymousClass1 */

                                        public final void run() {
                                            AppMethodBeat.i(36782);
                                            if (!bitmap.isRecycled()) {
                                                cVar.PIG.setImageBitmap(bitmap);
                                            }
                                            AppMethodBeat.o(36782);
                                        }
                                    });
                                    AppMethodBeat.o(36783);
                                }
                            });
                            Bitmap a3 = com.tencent.mm.modelappbrand.a.b.aXY().a(aVar5.ivo, ((com.tencent.mm.modelappbrand.k) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).a(240, 120, k.a.DECODE_TYPE_ORIGIN));
                            if (a3 == null) {
                                com.tencent.mm.modelappbrand.a.b.aXY().a(new b.k() {
                                    /* class com.tencent.mm.ui.chatting.viewitems.e.d.AnonymousClass8 */

                                    @Override // com.tencent.mm.modelappbrand.a.b.k
                                    public final void aYg() {
                                        AppMethodBeat.i(36784);
                                        cVar.PIF.setVisibility(4);
                                        AppMethodBeat.o(36784);
                                    }

                                    @Override // com.tencent.mm.modelappbrand.a.b.k
                                    public final void I(Bitmap bitmap) {
                                        AppMethodBeat.i(36785);
                                        if (bitmap != null && !bitmap.isRecycled()) {
                                            cVar.PIF.setImageBitmap(bitmap);
                                            cVar.PIF.setVisibility(0);
                                        }
                                        AppMethodBeat.o(36785);
                                    }

                                    @Override // com.tencent.mm.modelappbrand.a.b.k
                                    public final void oD() {
                                        AppMethodBeat.i(185028);
                                        Log.w("MicroMsg.ChattingItemAppMsgFrom", "hy: decode recorder cover failed receiver!");
                                        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(808, 2);
                                        AppMethodBeat.o(185028);
                                    }

                                    @Override // com.tencent.mm.modelappbrand.a.b.k, com.tencent.mm.modelappbrand.a.c
                                    public final String Lb() {
                                        AppMethodBeat.i(36786);
                                        String str = "CHAT#" + com.tencent.mm.plugin.appbrand.ac.n.cO(this);
                                        AppMethodBeat.o(36786);
                                        return str;
                                    }
                                }, aVar5.ivo, (b.h) null, ((com.tencent.mm.modelappbrand.k) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).a(240, 120, k.a.DECODE_TYPE_ORIGIN));
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            } else {
                                cVar.PIF.setImageBitmap(a3);
                                z4 = false;
                                bqVar = bqVar2;
                                break;
                            }
                        } else {
                            Log.d("MicroMsg.ChattingItemAppMsgFrom", "hy: no video url. treat as default");
                            z4 = true;
                            bqVar = bqVar2;
                            break;
                        }
                        break;
                }
                if (z4) {
                    if (bVar.title == null || bVar.title.length() <= 0) {
                        cVar.PHS.setVisibility(8);
                    } else {
                        cVar.PHS.setVisibility(0);
                        cVar.PHS.setMaxLines(2);
                        cVar.PHS.setText(bVar.title);
                    }
                    cVar.PHN.setVisibility(8);
                    if (z3) {
                        if (bVar.type == 33 || bVar.type == 36) {
                            String OF3 = q.bcR().OF(caVar.ajP());
                            cVar.PHM.setImageResource(R.raw.app_attach_file_icon_webpage);
                            com.tencent.mm.modelappbrand.a.b.aXY().a(cVar.PHM, "file://".concat(String.valueOf(OF3)), ((com.tencent.mm.modelappbrand.k) com.tencent.mm.kernel.g.af(com.tencent.mm.modelappbrand.k.class)).m10do(50, 50));
                        } else {
                            Bitmap b9 = q.bcR().b(caVar.ajP(), com.tencent.mm.cb.a.getDensity(aVar2.getContext()), false);
                            if (b9 == null || b9.isRecycled()) {
                                b9 = q.bcR().d(caVar.ajP(), com.tencent.mm.cb.a.getDensity(aVar2.getContext()));
                            }
                            if (b9 != null && !b9.isRecycled()) {
                                cVar.PHM.setImageBitmap(b9);
                            } else if (!Util.isNullOrNil(bVar.thumburl)) {
                                String str14 = bVar.thumburl;
                                c.a aVar6 = new c.a();
                                aVar6.ty(R.color.j6).bdq().bdo();
                                q.bcV().a(str14, cVar.PIL, aVar6.bdv());
                            } else {
                                cVar.PHM.setImageResource(R.drawable.ba8);
                            }
                        }
                    }
                    if (bVar.type == 44) {
                        c.a(aVar2, cVar, bVar);
                    }
                }
                if (aVar2.gRM()) {
                    cVar.PIb.setVisibility(8);
                    bqVar2 = bqVar;
                } else if (com.tencent.mm.pluginsdk.model.app.h.k(gE)) {
                    cVar.PIb.setVisibility(0);
                    c(aVar2, cVar.PIb, bq.a(bVar, caVar));
                    bqVar2 = bqVar;
                } else {
                    cVar.PIb.setVisibility(8);
                    bqVar2 = bqVar;
                }
            }
            if (!z6) {
                cVar.PIh.setTag(bqVar2);
                cVar.PIh.setOnClickListener(d(aVar2));
            }
            if (this.qoo) {
                cVar.PIh.setOnLongClickListener(c(aVar2));
                cVar.PIh.setOnTouchListener(((com.tencent.mm.ui.chatting.d.b.k) aVar2.bh(com.tencent.mm.ui.chatting.d.b.k.class)).gOC());
            }
            AppMethodBeat.o(36795);
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            boolean z;
            AppMethodBeat.i(233600);
            int i2 = ((bq) view.getTag()).position;
            int bdI = com.tencent.mm.pluginsdk.model.app.m.bdI(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
            k.b HD = k.b.HD(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
            com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(HD.appId, false, false);
            if (com.tencent.mm.pluginsdk.model.app.h.l(o) && !com.tencent.mm.ui.chatting.k.bm(caVar)) {
                if (HD.type == 6) {
                    com.tencent.mm.pluginsdk.model.app.c bdJ = com.tencent.mm.pluginsdk.model.app.m.bdJ(HD.dCK);
                    if ((bdJ == null || !b.h(caVar, bdJ.field_fileFullPath)) && !caVar.gDB()) {
                        mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                    }
                } else {
                    mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
                }
            }
            if (HD.iwI <= 0 || (HD.iwI > 0 && bdI >= 100)) {
                switch (e.m(HD)) {
                    case 1:
                        z = com.tencent.mm.al.g.aZH();
                        break;
                    case 2:
                        z = com.tencent.mm.al.g.aZI();
                        break;
                    case 3:
                        z = com.tencent.mm.al.g.aZR();
                        break;
                    case 4:
                        z = com.tencent.mm.al.g.aZJ();
                        break;
                    case 5:
                        z = com.tencent.mm.al.g.aZN();
                        break;
                    case 6:
                        z = com.tencent.mm.al.g.aZP();
                        if (!Util.isImageExt(HD.iwJ)) {
                            mVar.a(i2, 150, this.PhN.Pwc.getMMResources().getString(R.string.b0d), R.raw.icons_filled_otherapp);
                            break;
                        }
                        break;
                    case 8:
                        z = com.tencent.mm.al.g.aZL();
                        break;
                    case 16:
                        if (HD.ixV != 5 && HD.ixV != 6 && HD.ixV != 2) {
                            z = false;
                            break;
                        } else {
                            if (HD.ixV != 2 || br.B(caVar)) {
                                mVar.clear();
                            }
                            mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
                            AppMethodBeat.o(233600);
                            return false;
                        }
                        break;
                    case 34:
                        mVar.clear();
                        mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
                        AppMethodBeat.o(233600);
                        return false;
                    default:
                        z = false;
                        break;
                }
                if (z && !this.PhN.gRN()) {
                    mVar.add(i2, 114, 0, view.getContext().getString(R.string.b02));
                }
            }
            if (com.tencent.mm.br.c.aZU("favorite") && (o == null || !o.NA())) {
                switch (e.m(HD)) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 10:
                    case 13:
                    case 19:
                    case 20:
                    case 24:
                    case 33:
                    case 36:
                        mVar.a(i2, 116, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                        break;
                }
            }
            ef efVar = new ef();
            efVar.dHy.msgId = caVar.field_msgId;
            EventCenter.instance.publish(efVar);
            if (efVar.dHz.dGX || b.a(this.PhN.Pwc.getContext(), HD)) {
                mVar.a(i2, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
            }
            if (br.B(caVar)) {
                mVar.clear();
            }
            if (!this.PhN.gRN()) {
                mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            }
            if (BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) {
                mVar.a(i2, 144, view.getContext().getString(R.string.f0_), R.raw.fix_tools_entry);
            }
            AppMethodBeat.o(233600);
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, final com.tencent.mm.ui.chatting.e.a aVar, final ca caVar) {
            AppMethodBeat.i(36797);
            switch (menuItem.getItemId()) {
                case 100:
                    AppMethodBeat.o(36797);
                    break;
                case 111:
                    if (ac.bB(caVar)) {
                        final String N = br.N(caVar);
                        if (Util.isNullOrNil(N)) {
                            b.a(aVar, caVar, a(aVar, caVar));
                        } else {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(17509, 3, N);
                            com.tencent.mm.ui.base.h.a((Context) aVar.Pwc.getContext(), (int) R.string.gh9, (int) R.string.gh_, (int) R.string.zx, (int) R.string.b20, true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.chatting.viewitems.e.d.AnonymousClass11 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(36790);
                                    Intent intent = new Intent();
                                    intent.putExtra("rawUrl", N);
                                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(17509, 1, N);
                                    AppMethodBeat.o(36790);
                                }
                            }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.chatting.viewitems.e.d.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(36772);
                                    b.a(aVar, caVar, d.this.a(aVar, caVar));
                                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(17509, 2, N);
                                    AppMethodBeat.o(36772);
                                }
                            });
                        }
                        AppMethodBeat.o(36797);
                        break;
                    } else {
                        com.tencent.mm.ui.base.h.a(aVar.Pwc.getContext(), aVar.Pwc.getContext().getString(R.string.c89), "", aVar.Pwc.getContext().getString(R.string.j34), (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(36797);
                        break;
                    }
                case 114:
                    String str = caVar.field_content;
                    if (str != null) {
                        k.b HD = k.b.HD(str);
                        if (HD != null) {
                            switch (e.m(HD)) {
                                case 1:
                                    an.m(bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend), aVar.Pwc.getContext());
                                    break;
                                case 2:
                                    an.a(caVar, aVar.Pwc.getContext(), a(aVar, caVar), aVar.gRM());
                                    break;
                                case 3:
                                    an.a(caVar, bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend), aVar.Pwc.getContext());
                                    break;
                                case 4:
                                    an.c(caVar, aVar.Pwc.getContext());
                                    break;
                                case 5:
                                    an.c(caVar, bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend), aVar.Pwc.getContext());
                                    break;
                                case 6:
                                    an.b(caVar, bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend), aVar.Pwc.getContext());
                                    break;
                                case 8:
                                    an.d(caVar, aVar.Pwc.getContext());
                                    break;
                            }
                        }
                        AppMethodBeat.o(36797);
                        break;
                    } else {
                        AppMethodBeat.o(36797);
                        break;
                    }
                case 144:
                    Intent intent = new Intent();
                    intent.putExtra("Chat_Msg_Id", caVar.field_msgId);
                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", intent);
                    AppMethodBeat.o(36797);
                    break;
                default:
                    AppMethodBeat.o(36797);
                    break;
            }
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:75:0x03aa, code lost:
            if (c(r1, r13, r11, r14) == false) goto L_0x006f;
         */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0072  */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean c(android.view.View r12, final com.tencent.mm.ui.chatting.e.a r13, final com.tencent.mm.storage.ca r14) {
            /*
            // Method dump skipped, instructions count: 1146
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.e.d.c(android.view.View, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.storage.ca):boolean");
        }

        public static boolean b(k.b bVar, com.tencent.mm.ui.chatting.e.a aVar, c cVar, ca caVar) {
            String str;
            int i2;
            Bundle bundle;
            AppMethodBeat.i(161905);
            x xVar = x.Qxl;
            x.gXY();
            if (!Util.isNullOrNil(bVar.izj) || !Util.isNullOrNil(bVar.izi)) {
                String talkerUserName = aVar.getTalkerUserName();
                String a2 = cVar.a(aVar, caVar);
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
                bundle2.putBoolean("stat_kf_guide", com.tencent.mm.al.h.R(caVar));
                ((com.tencent.mm.plugin.appbrand.service.r) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(aVar.Pwc.getContext(), aVar.getTalkerUserName(), cVar.a(aVar, caVar), aVar.gRM(), bVar, bundle2);
                AppMethodBeat.o(161905);
            } else {
                String R = com.tencent.mm.pluginsdk.model.app.q.R(bVar.url, aVar.gRM() ? "groupmessage" : "singlemessage");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", R);
                intent.putExtra("webpageTitle", bVar.title);
                intent.putExtra("shortUrl", bVar.url);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(161905);
            }
            return true;
        }

        public static boolean c(k.b bVar, com.tencent.mm.ui.chatting.e.a aVar, c cVar, ca caVar) {
            AppMethodBeat.i(36800);
            com.tencent.mm.ag.a aVar2 = (com.tencent.mm.ag.a) bVar.as(com.tencent.mm.ag.a.class);
            if (aVar2 == null || Util.isNullOrNil(aVar2.ivm) || Util.isNullOrNil(aVar2.ivo)) {
                Log.w("MicroMsg.ChattingItemAppMsgFrom", "hy: no remote url provided. treat as default");
                AppMethodBeat.o(36800);
                return false;
            }
            String str = aVar2.ivm;
            String str2 = aVar2.ivl;
            String str3 = Util.isNullOrNil(aVar2.ivp) ? bVar.description : aVar2.ivp;
            String str4 = aVar2.ivn;
            String str5 = bVar.izj;
            String str6 = aVar2.ivo;
            Log.i("MicroMsg.ChattingItemAppMsgFrom", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, videoThumbUrl: %s", str, str2, str3, str4, str5, str6);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(ab.Eq(aVar.getTalkerUserName()) ? 2 : 1);
            objArr[1] = str5;
            objArr[2] = 1;
            objArr[3] = 1;
            hVar.a(17608, objArr);
            if (!Util.isNullOrNil(str)) {
                Bundle bundle = new Bundle();
                bundle.putString("key_chatting_wording", str3);
                bundle.putString("key_chatting_text", str4);
                bundle.putString("key_chatting_appid", str5);
                bundle.putLong("key_msg_id", caVar.field_msgId);
                bundle.putString("key_talker_username", aVar.getTalkerUserName());
                bundle.putString("key_sender_username", cVar.a(aVar, caVar));
                e.a(aVar, str, str2, str6, bundle);
            } else {
                Log.w("MicroMsg.ChattingItemAppMsgFrom", "hy: video msg invalid!!");
            }
            AppMethodBeat.o(36800);
            return true;
        }

        public static boolean d(k.b bVar, com.tencent.mm.ui.chatting.e.a aVar, c cVar, ca caVar) {
            String str;
            int i2;
            Bundle bundle;
            boolean z;
            AppMethodBeat.i(36801);
            Log.i("MicroMsg.ChattingItemAppMsgFrom", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", bVar.izi, bVar.izh, bVar.izj, bVar.url, Integer.valueOf(bVar.izz), bVar.izl);
            if (44 != bVar.type || (bVar.fn(false) && !Util.isNullOrNil(bVar.w(aVar.Pwc.getContext(), false)))) {
                String talkerUserName = aVar.getTalkerUserName();
                String a2 = cVar.a(aVar, caVar);
                Bundle bundle2 = new Bundle();
                if (aVar.Pwc instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI) {
                    str = "stat_scene";
                    i2 = 10;
                    bundle = bundle2;
                } else if (aVar.gRM()) {
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
                switch (bVar.izk) {
                    case 0:
                    case 2:
                        if (!(aVar.Pwc instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) {
                            if (!com.tencent.mm.al.h.R(caVar)) {
                                if (!ab.IT(talkerUserName)) {
                                    com.tencent.mm.modelappbrand.a.a(talkerUserName, a2, aVar.gRM(), bVar, bundle2);
                                    z = false;
                                    break;
                                } else {
                                    com.tencent.mm.modelappbrand.a.a(talkerUserName, 1074, bVar, bundle2);
                                    z = false;
                                    break;
                                }
                            } else {
                                com.tencent.mm.modelappbrand.a.a(talkerUserName, 1157, bVar, bundle2);
                                z = false;
                                break;
                            }
                        } else {
                            com.tencent.mm.modelappbrand.a.a(talkerUserName, 1073, bVar, bundle2);
                            z = false;
                            break;
                        }
                    case 1:
                        Intent intent = new Intent();
                        intent.putExtra("key_username", bVar.izi);
                        if (aVar.gRM()) {
                            intent.putExtra("key_from_scene", 1);
                            intent.putExtra("key_scene_note", talkerUserName + ":" + a2);
                        } else {
                            intent.putExtra("key_from_scene", 2);
                            intent.putExtra("key_scene_note", talkerUserName);
                        }
                        WxaExposedParams.a aVar2 = new WxaExposedParams.a();
                        aVar2.appId = bVar.izj;
                        aVar2.from = 6;
                        aVar2.kNW = bVar.izz;
                        aVar2.pkgVersion = bVar.izm;
                        intent.putExtra("key_scene_exposed_params", aVar2.bAv());
                        intent.putExtra("_stat_obj", bundle2);
                        com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "appbrand", ".ui.AppBrandProfileUI", intent);
                        z = false;
                        break;
                    case 3:
                        com.tencent.mm.modelappbrand.a.b(talkerUserName, a2, aVar.gRM(), bVar, bundle2);
                        z = false;
                        break;
                    default:
                        z = true;
                        break;
                }
                e.cL(caVar);
                if (!z) {
                    AppMethodBeat.o(36801);
                    return true;
                }
                AppMethodBeat.o(36801);
                return false;
            }
            AppMethodBeat.o(36801);
            return false;
        }

        public static boolean e(k.b bVar, com.tencent.mm.ui.chatting.e.a aVar, c cVar, ca caVar) {
            int i2;
            AppMethodBeat.i(169872);
            if (bVar.url == null || bVar.url.equals("")) {
                AppMethodBeat.o(169872);
                return false;
            } else if (!Util.isNullOrNil(bVar.canvasPageXml)) {
                Intent intent = new Intent();
                intent.putExtra("sns_landig_pages_from_source", 5);
                intent.putExtra("msg_id", caVar.field_msgId);
                intent.putExtra("sns_landing_pages_xml", bVar.canvasPageXml);
                intent.putExtra("sns_landing_pages_share_thumb_url", caVar.field_imgPath);
                String ka = com.tencent.mm.plugin.sns.data.k.ka(bVar.dRL, caVar.field_talker);
                if (!TextUtils.isEmpty(ka)) {
                    intent.putExtra("sns_landing_pages_extra", ka);
                }
                intent.addFlags(268435456);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
                AppMethodBeat.o(169872);
                return true;
            } else {
                aj ajVar = (aj) bVar.as(aj.class);
                if (ajVar == null || Util.isNullOrNil(ajVar.IEy)) {
                    String R = com.tencent.mm.pluginsdk.model.app.q.R(bVar.url, aVar.gRM() ? "groupmessage" : "singlemessage");
                    String str = bVar.url;
                    PackageInfo packageInfo = c.getPackageInfo(aVar.Pwc.getContext(), bVar.appId);
                    Intent intent2 = new Intent();
                    int intExtra = aVar.Pwc.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
                    if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(R)) {
                        R = ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).d(R, 1, intExtra, (int) (System.currentTimeMillis() / 1000));
                    }
                    intent2.putExtra("rawUrl", R);
                    intent2.putExtra("webpageTitle", bVar.title);
                    if (bVar.appId != null && ("wx751a1acca5688ba3".equals(bVar.appId) || "wxfbc915ff7c30e335".equals(bVar.appId) || "wx482a4001c37e2b74".equals(bVar.appId))) {
                        Bundle bundle = new Bundle();
                        bundle.putString("jsapi_args_appid", bVar.appId);
                        intent2.putExtra("jsapiargs", bundle);
                    }
                    if (!Util.isNullOrNil(str)) {
                        intent2.putExtra("shortUrl", str);
                    } else {
                        intent2.putExtra("shortUrl", bVar.url);
                    }
                    intent2.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
                    intent2.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
                    if (!Util.isNullOrNil(bVar.eag)) {
                        intent2.putExtra("srcUsername", bVar.eag);
                        intent2.putExtra("srcDisplayname", bVar.eah);
                    }
                    intent2.putExtra("msg_id", caVar.field_msgId);
                    intent2.putExtra("KPublisherId", "msg_" + Long.toString(caVar.field_msgSvrId));
                    intent2.putExtra("KAppId", bVar.appId);
                    intent2.putExtra("geta8key_username", aVar.getTalkerUserName());
                    intent2.putExtra("pre_username", cVar.a(aVar, caVar));
                    intent2.putExtra("from_scence", 2);
                    intent2.putExtra("expid_str", caVar.fRa);
                    intent2.putExtra("msgUsername", bVar.dRL);
                    intent2.putExtra("serverMsgID", String.valueOf(caVar.field_msgSvrId));
                    int aJ = com.tencent.mm.model.ac.aJ(cVar.a(aVar, caVar), aVar.getTalkerUserName());
                    intent2.putExtra("prePublishId", "msg_" + Long.toString(caVar.field_msgSvrId));
                    intent2.putExtra("preUsername", cVar.a(aVar, caVar));
                    intent2.putExtra("preChatName", aVar.getTalkerUserName());
                    intent2.putExtra("preChatTYPE", aJ);
                    intent2.putExtra("preMsgIndex", 0);
                    switch (aJ) {
                        case 1:
                            i2 = 3;
                            break;
                        case 2:
                            i2 = 2;
                            break;
                        case 3:
                        case 4:
                        case 5:
                        default:
                            i2 = 0;
                            break;
                        case 6:
                        case 7:
                            i2 = 5;
                            break;
                    }
                    intent2.putExtra("share_report_pre_msg_url", bVar.url);
                    intent2.putExtra("share_report_pre_msg_title", bVar.title);
                    intent2.putExtra("share_report_pre_msg_desc", bVar.description);
                    intent2.putExtra("share_report_pre_msg_icon_url", bVar.thumburl);
                    intent2.putExtra("share_report_pre_msg_appid", bVar.appId);
                    intent2.putExtra("share_report_from_scene", i2);
                    intent2.putExtra("geta8key_scene", 1);
                    if (i2 == 5) {
                        intent2.putExtra("share_report_biz_username", aVar.getTalkerUserName());
                    }
                    com.tencent.mm.ag.e eVar = (com.tencent.mm.ag.e) bVar.as(com.tencent.mm.ag.e.class);
                    int i3 = eVar != null ? eVar.iwc : -1;
                    intent2.putExtra(e.p.OzA, i3);
                    intent2.putExtra("key_enable_teen_mode_check", true);
                    intent2.addFlags(536870912);
                    if (eVar == null || i3 != 5 || eVar.iwe != 1 || !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()) {
                        c(aVar, caVar);
                        if (!((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(3) || !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(aVar.Pwc.getContext(), R, i3, 1, intExtra, intent2)) {
                            com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                            AppMethodBeat.o(169872);
                            return true;
                        }
                        Log.i("MicroMsg.ChattingItemAppMsgFrom", "jump to TmplWebview");
                        AppMethodBeat.o(169872);
                        return true;
                    }
                    Bundle bundle2 = new Bundle();
                    bundle2.putInt(e.b.OyQ, 1);
                    bundle2.putInt(e.b.OyR, intExtra);
                    bundle2.putInt("geta8key_scene", 1);
                    bundle2.putString("geta8key_username", aVar.getTalkerUserName());
                    if (ajVar != null && !Util.isNullOrNil(ajVar.IEy)) {
                        com.tencent.mm.plugin.webview.ui.tools.video.a aVar2 = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
                        com.tencent.mm.plugin.webview.ui.tools.video.a.bbi(ajVar.IEy);
                    }
                    com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(aVar.Pwc.getContext(), caVar.field_msgId, caVar.field_msgSvrId, 0, bundle2);
                    AppMethodBeat.o(169872);
                    return true;
                }
                fat fat = new fat();
                fat.IEy = ajVar.IEy;
                fat.IEz = ajVar.IEz;
                fat.IEA = ajVar.IEA;
                fat.IEB = ajVar.IEB;
                fat.IEC = ajVar.IEC;
                fat.IEG = ajVar.IEG;
                fat.rCq = ajVar.rCq;
                fat.msN = ajVar.msN;
                fat.xDQ = ajVar.xDQ;
                fat.IED = ajVar.IED;
                fat.IEE = ajVar.IEE;
                fat.IEF = ajVar.IEF;
                fat.source = ajVar.source;
                fat.eby = ajVar.eby;
                fat.IEH = ajVar.IEH;
                fat.IEJ = ajVar.IEJ;
                fat.IEK = ajVar.IEK;
                fat.IEL = ajVar.IEL;
                fat.IEI = ajVar.IEI;
                eit a2 = com.tencent.mm.plugin.topstory.a.h.a(fat, 32, aVar.Pwc.getContext().getString(R.string.dkf));
                i.a(fat, caVar);
                com.tencent.mm.plugin.websearch.api.ai.a(aVar.Pwc.getContext(), a2);
                AppMethodBeat.o(169872);
                return true;
            }
        }

        public static boolean a(k.b bVar, com.tencent.mm.ui.chatting.e.a aVar, c cVar, ca caVar) {
            String str;
            int i2;
            AppMethodBeat.i(36799);
            if (com.tencent.mm.q.a.cC(aVar.Pwc.getContext()) || com.tencent.mm.q.a.cA(aVar.Pwc.getContext()) || com.tencent.mm.q.a.cE(aVar.Pwc.getContext())) {
                Log.i("MicroMsg.ChattingItemAppMsgFrom", "Voip is running, can't do this");
                AppMethodBeat.o(36799);
                return true;
            } else if (cVar.a(aVar, bVar, caVar)) {
                AppMethodBeat.o(36799);
                return true;
            } else {
                String R = com.tencent.mm.pluginsdk.model.app.q.R(bVar.url, "message");
                String R2 = com.tencent.mm.pluginsdk.model.app.q.R(bVar.iwH, "message");
                PackageInfo packageInfo = c.getPackageInfo(aVar.Pwc.getContext(), bVar.appId);
                if (packageInfo == null) {
                    str = null;
                } else {
                    str = packageInfo.versionName;
                }
                if (packageInfo == null) {
                    i2 = 0;
                } else {
                    i2 = packageInfo.versionCode;
                }
                cVar.a(aVar, R, R2, str, i2, bVar.appId, true, caVar.field_msgId, caVar.field_msgSvrId, caVar);
                AppMethodBeat.o(36799);
                return true;
            }
        }
    }

    protected static void a(TextView textView, k.b bVar) {
        AppMethodBeat.i(36837);
        switch (bVar.izz) {
            case 1:
                textView.setText(R.string.rj);
                break;
            case 2:
                textView.setText(R.string.ri);
                break;
            default:
                textView.setText(R.string.ko);
                break;
        }
        textView.setVisibility(0);
        AppMethodBeat.o(36837);
    }

    /* renamed from: com.tencent.mm.ui.chatting.viewitems.e$e  reason: collision with other inner class name */
    public static class C2107e extends c implements t.n {
        protected t.i PJg;
        protected t.l PJh;
        protected t.j PJi;
        private com.tencent.mm.ui.chatting.e.a PhN;

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean gTT() {
            return true;
        }

        private t.i j(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(36822);
            if (this.PJg == null) {
                this.PJg = new t.i(aVar);
            }
            t.i iVar = this.PJg;
            AppMethodBeat.o(36822);
            return iVar;
        }

        private t.l k(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(36823);
            if (this.PJh == null) {
                this.PJh = new t.l(aVar);
            }
            t.l lVar = this.PJh;
            AppMethodBeat.o(36823);
            return lVar;
        }

        private t.j l(com.tencent.mm.ui.chatting.e.a aVar) {
            AppMethodBeat.i(36824);
            if (this.PJi == null) {
                this.PJi = new t.j(aVar);
            }
            t.j jVar = this.PJi;
            AppMethodBeat.o(36824);
            return jVar;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean bM(int i2, boolean z) {
            if (!z || (i2 != 49 && i2 != 335544369 && i2 != 402653233 && i2 != 369098801 && i2 != 738197553 && i2 != 905969713)) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final View a(LayoutInflater layoutInflater, View view) {
            AppMethodBeat.i(36825);
            if (view == null || view.getTag() == null) {
                view = new an(layoutInflater, R.layout.sl);
                view.setTag(new c().F(view, false));
            }
            AppMethodBeat.o(36825);
            return view;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Removed duplicated region for block: B:175:0x08dd  */
        /* JADX WARNING: Removed duplicated region for block: B:182:0x0910  */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.c.a r25, int r26, final com.tencent.mm.ui.chatting.e.a r27, com.tencent.mm.storage.ca r28, java.lang.String r29) {
            /*
            // Method dump skipped, instructions count: 6324
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.e.C2107e.a(com.tencent.mm.ui.chatting.viewitems.c$a, int, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.storage.ca, java.lang.String):void");
        }

        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(com.tencent.mm.ui.base.m mVar, View view, ca caVar) {
            boolean z;
            AppMethodBeat.i(233602);
            int i2 = ((bq) view.getTag()).position;
            if (caVar.field_content == null) {
                AppMethodBeat.o(233602);
                return true;
            }
            k.b HD = k.b.HD(bp.b(this.PhN.gRM(), caVar.field_content, caVar.field_isSend));
            if (HD == null) {
                AppMethodBeat.o(233602);
                return true;
            }
            com.tencent.mm.pluginsdk.model.app.g o = com.tencent.mm.pluginsdk.model.app.h.o(HD.appId, false, false);
            if (com.tencent.mm.pluginsdk.model.app.h.l(o) && !com.tencent.mm.ui.chatting.k.bm(caVar) && !(HD.type == 19 && caVar.field_status == 1)) {
                mVar.a(i2, 111, this.PhN.Pwc.getMMResources().getString(R.string.g5c), R.raw.icons_filled_share);
            }
            if ((caVar.field_status == 2 || caVar.fQV == 1) && b(caVar, this.PhN) && bnf(caVar.field_talker) && !as.HF(this.PhN.getTalkerUserName())) {
                mVar.a(i2, 123, view.getContext().getString(R.string.b0i), R.raw.icons_filled_previous);
            }
            switch (e.m(HD)) {
                case 1:
                    z = com.tencent.mm.al.g.aZH();
                    break;
                case 2:
                    z = com.tencent.mm.al.g.aZI();
                    break;
                case 3:
                    z = com.tencent.mm.al.g.aZR();
                    break;
                case 4:
                    z = com.tencent.mm.al.g.aZJ();
                    break;
                case 5:
                    z = com.tencent.mm.al.g.aZN();
                    break;
                case 6:
                    z = com.tencent.mm.al.g.aZP();
                    if (!Util.isImageExt(HD.iwJ)) {
                        mVar.a(i2, 150, this.PhN.Pwc.getMMResources().getString(R.string.b0d), R.raw.icons_filled_otherapp);
                        break;
                    }
                    break;
                case 8:
                    z = com.tencent.mm.al.g.aZL();
                    break;
                case 16:
                    if (HD.ixV != 5 && HD.ixV != 6 && HD.ixV != 2) {
                        z = false;
                        break;
                    } else {
                        if (HD.ixV != 2) {
                            mVar.clear();
                        }
                        mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
                        AppMethodBeat.o(233602);
                        return false;
                    }
                    break;
                case 34:
                    mVar.clear();
                    mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
                    AppMethodBeat.o(233602);
                    return false;
                default:
                    z = false;
                    break;
            }
            if (z && !this.PhN.gRN()) {
                mVar.add(i2, 114, 0, view.getContext().getString(R.string.b02));
            }
            if (com.tencent.mm.br.c.aZU("favorite") && (o == null || !o.NA())) {
                switch (e.m(HD)) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 10:
                    case 13:
                    case 19:
                    case 20:
                    case 24:
                    case 33:
                    case 36:
                        mVar.a(i2, 116, view.getContext().getString(R.string.fn9), R.raw.icons_filled_favorites);
                        break;
                }
            }
            ef efVar = new ef();
            efVar.dHy.msgId = caVar.field_msgId;
            EventCenter.instance.publish(efVar);
            if (efVar.dHz.dGX || b.a(this.PhN.Pwc.getContext(), HD)) {
                mVar.a(i2, 129, view.getContext().getString(R.string.b0c), R.raw.icons_filled_open);
            }
            if (!this.PhN.gRN()) {
                mVar.a(i2, 100, this.PhN.Pwc.getMMResources().getString(R.string.b06), R.raw.icons_filled_delete);
            }
            if (BuildInfo.IS_FLAVOR_RED || WeChatEnvironment.hasDebugger()) {
                mVar.a(i2, 144, view.getContext().getString(R.string.f0_), R.raw.fix_tools_entry);
            }
            AppMethodBeat.o(233602);
            return true;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
            k.b HD;
            AppMethodBeat.i(36829);
            switch (menuItem.getItemId()) {
                case 100:
                    AppMethodBeat.o(36829);
                    break;
                case 103:
                    String str = caVar.field_content;
                    if (str != null) {
                        k.b HD2 = k.b.HD(str);
                        if (HD2 != null) {
                            switch (HD2.type) {
                                case 16:
                                    kj kjVar = new kj();
                                    kjVar.dPt.dPu = HD2.dPu;
                                    kjVar.dPt.dFm = caVar.field_msgId;
                                    kjVar.dPt.dPv = caVar.field_talker;
                                    EventCenter.instance.publish(kjVar);
                                    break;
                            }
                        }
                        Intent intent = new Intent();
                        intent.putExtra("Chat_Msg_Id", caVar.field_msgId);
                        com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", intent);
                        AppMethodBeat.o(36829);
                        break;
                    } else {
                        AppMethodBeat.o(36829);
                        break;
                    }
                case 111:
                    if (!(caVar == null || !caVar.dOQ() || (HD = k.b.HD(caVar.field_content)) == null)) {
                        if (HD.type != 40) {
                            if (HD.type == 33 && !WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable(aVar.Pwc.getContext())) {
                                AppMethodBeat.o(36829);
                                break;
                            }
                        } else {
                            com.tencent.mm.ui.base.h.a(aVar.Pwc.getContext(), aVar.Pwc.getContext().getString(R.string.c89), "", aVar.Pwc.getContext().getString(R.string.j34), (DialogInterface.OnClickListener) null);
                            AppMethodBeat.o(36829);
                            break;
                        }
                    }
                    b.a(aVar, caVar, a(aVar, caVar));
                    AppMethodBeat.o(36829);
                    break;
                case 114:
                    String str2 = caVar.field_content;
                    if (str2 != null) {
                        k.b HD3 = k.b.HD(str2);
                        if (HD3 != null) {
                            switch (e.m(HD3)) {
                                case 1:
                                    an.m(bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend), aVar.Pwc.getContext());
                                    break;
                                case 2:
                                    an.a(caVar, aVar.Pwc.getContext(), a(aVar, caVar), aVar.gRM());
                                    break;
                                case 3:
                                    an.a(caVar, bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend), aVar.Pwc.getContext());
                                    break;
                                case 4:
                                    an.c(caVar, aVar.Pwc.getContext());
                                    break;
                                case 5:
                                    an.c(caVar, bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend), aVar.Pwc.getContext());
                                    break;
                                case 6:
                                    an.b(caVar, bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend), aVar.Pwc.getContext());
                                    break;
                                case 8:
                                    an.d(caVar, aVar.Pwc.getContext());
                                    break;
                            }
                        }
                        AppMethodBeat.o(36829);
                        break;
                    } else {
                        AppMethodBeat.o(36829);
                        break;
                    }
                case 144:
                    Intent intent2 = new Intent();
                    intent2.putExtra("Chat_Msg_Id", caVar.field_msgId);
                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "brandservice", ".ui.ShowAppMsgContentUI", intent2);
                    AppMethodBeat.o(36829);
                    break;
                default:
                    AppMethodBeat.o(36829);
                    break;
            }
            return false;
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x005b  */
        @Override // com.tencent.mm.ui.chatting.viewitems.c
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean c(android.view.View r11, final com.tencent.mm.ui.chatting.e.a r12, final com.tencent.mm.storage.ca r13) {
            /*
            // Method dump skipped, instructions count: 1342
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.e.C2107e.c(android.view.View, com.tencent.mm.ui.chatting.e.a, com.tencent.mm.storage.ca):boolean");
        }

        public static boolean f(k.b bVar, com.tencent.mm.ui.chatting.e.a aVar, c cVar, ca caVar) {
            String str;
            int i2;
            AppMethodBeat.i(36831);
            if (cVar.a(aVar, bVar, caVar)) {
                AppMethodBeat.o(36831);
                return true;
            }
            String R = com.tencent.mm.pluginsdk.model.app.q.R(bVar.url, "message");
            String R2 = com.tencent.mm.pluginsdk.model.app.q.R(bVar.iwH, "message");
            PackageInfo packageInfo = c.getPackageInfo(aVar.Pwc.getContext(), bVar.appId);
            if (packageInfo == null) {
                str = null;
            } else {
                str = packageInfo.versionName;
            }
            if (packageInfo == null) {
                i2 = 0;
            } else {
                i2 = packageInfo.versionCode;
            }
            cVar.a(aVar, R, R2, str, i2, bVar.appId, true, caVar.field_msgId, caVar.field_msgSvrId, caVar);
            AppMethodBeat.o(36831);
            return true;
        }

        public static boolean b(k.b bVar, com.tencent.mm.ui.chatting.e.a aVar, c cVar, ca caVar) {
            String str;
            int i2;
            Bundle bundle;
            AppMethodBeat.i(161906);
            if (!Util.isNullOrNil(bVar.izj) || !Util.isNullOrNil(bVar.izi)) {
                String talkerUserName = aVar.getTalkerUserName();
                String a2 = cVar.a(aVar, caVar);
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
                bundle2.putBoolean("stat_kf_guide", com.tencent.mm.al.h.R(caVar));
                ((com.tencent.mm.plugin.appbrand.service.r) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.r.class)).a(aVar.Pwc.getContext(), aVar.getTalkerUserName(), cVar.a(aVar, caVar), aVar.gRM(), bVar, bundle2);
                AppMethodBeat.o(161906);
            } else {
                String R = com.tencent.mm.pluginsdk.model.app.q.R(bVar.url, aVar.gRM() ? "groupmessage" : "singlemessage");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", R);
                intent.putExtra("webpageTitle", bVar.title);
                intent.putExtra("shortUrl", bVar.url);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(161906);
            }
            return true;
        }

        public static boolean g(k.b bVar, com.tencent.mm.ui.chatting.e.a aVar, c cVar, ca caVar) {
            String str;
            int i2;
            Bundle bundle;
            boolean z;
            AppMethodBeat.i(36832);
            Log.i("MicroMsg.ChattingItemAppMsgTo", "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s", bVar.izi, bVar.izh, bVar.izj, bVar.url, Integer.valueOf(bVar.izz), bVar.izl);
            if (44 != bVar.type || (bVar.fn(false) && !Util.isNullOrNil(bVar.w(aVar.Pwc.getContext(), false)))) {
                String talkerUserName = aVar.getTalkerUserName();
                String a2 = cVar.a(aVar, caVar);
                Bundle bundle2 = new Bundle();
                if (aVar.Pwc instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI) {
                    str = "stat_scene";
                    i2 = 10;
                    bundle = bundle2;
                } else if (aVar.gRM()) {
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
                bundle2.putBoolean("stat_kf_guide", com.tencent.mm.al.h.R(caVar));
                switch (bVar.izk) {
                    case 0:
                    case 2:
                        if (!(aVar.Pwc instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) {
                            if (!ab.IT(talkerUserName)) {
                                com.tencent.mm.modelappbrand.a.a(talkerUserName, a2, aVar.gRM(), bVar, bundle2);
                                z = false;
                                break;
                            } else {
                                com.tencent.mm.modelappbrand.a.a(talkerUserName, 1074, bVar, bundle2);
                                z = false;
                                break;
                            }
                        } else {
                            com.tencent.mm.modelappbrand.a.a(talkerUserName, 1073, bVar, bundle2);
                            z = false;
                            break;
                        }
                    case 1:
                        Intent intent = new Intent();
                        intent.putExtra("key_username", bVar.izi);
                        if (aVar.gRM()) {
                            intent.putExtra("key_from_scene", 1);
                            intent.putExtra("key_scene_note", aVar.getTalkerUserName() + ":" + a2);
                        } else {
                            intent.putExtra("key_from_scene", 2);
                            intent.putExtra("key_scene_note", talkerUserName);
                        }
                        intent.putExtra("_stat_obj", bundle2);
                        WxaExposedParams.a aVar2 = new WxaExposedParams.a();
                        aVar2.appId = bVar.izj;
                        aVar2.from = 6;
                        aVar2.kNW = bVar.izz;
                        aVar2.pkgVersion = bVar.izm;
                        intent.putExtra("key_scene_exposed_params", aVar2.bAv());
                        com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "appbrand", ".ui.AppBrandProfileUI", intent);
                        z = false;
                        break;
                    case 3:
                        com.tencent.mm.modelappbrand.a.b(talkerUserName, a2, aVar.gRM(), bVar, bundle2);
                        z = false;
                        break;
                    default:
                        z = true;
                        break;
                }
                e.cL(caVar);
                if (!z) {
                    AppMethodBeat.o(36832);
                    return true;
                }
                AppMethodBeat.o(36832);
                return false;
            }
            AppMethodBeat.o(36832);
            return false;
        }

        public static boolean h(k.b bVar, com.tencent.mm.ui.chatting.e.a aVar, c cVar, ca caVar) {
            AppMethodBeat.i(36833);
            com.tencent.mm.ag.a aVar2 = (com.tencent.mm.ag.a) bVar.as(com.tencent.mm.ag.a.class);
            if (aVar2 == null || Util.isNullOrNil(aVar2.ivm) || Util.isNullOrNil(aVar2.ivo)) {
                Log.w("MicroMsg.ChattingItemAppMsgTo", "hy: no remote url provided. give a hint");
                u.makeText(aVar.Pwc.getContext(), aVar.Pwc.getMMResources().getString(R.string.ys), 0).show();
                AppMethodBeat.o(36833);
                return true;
            }
            String str = aVar2.ivm;
            String str2 = aVar2.ivl;
            String str3 = aVar2.ebj;
            String str4 = Util.isNullOrNil(aVar2.ivp) ? bVar.description : aVar2.ivp;
            String str5 = aVar2.ivn;
            String str6 = bVar.izj;
            String str7 = aVar2.ivo;
            Log.i("MicroMsg.ChattingItemAppMsgTo", "hy: request start videoUrl: %s, localPath: %s, videoDesc: %s, videoButtonText: %s, appid: %s, thumbUrl: %s", str, str2, str4, str5, str6, str7);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(ab.Eq(aVar.getTalkerUserName()) ? 2 : 1);
            objArr[1] = str6;
            objArr[2] = 1;
            objArr[3] = 1;
            hVar.a(17608, objArr);
            if (!Util.isNullOrNil(str) || (!Util.isNullOrNil(str2) && s.YS(str2) && Util.nullAsNil(s.bhK(str2)).equals(str3))) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_chatting_type", bVar.type);
                bundle.putString("key_chatting_wording", str4);
                bundle.putString("key_chatting_text", str5);
                bundle.putString("key_chatting_appid", str6);
                bundle.putLong("key_msg_id", caVar.field_msgId);
                bundle.putString("key_talker_username", aVar.getTalkerUserName());
                bundle.putString("key_sender_username", cVar.a(aVar, caVar));
                e.a(aVar, str, str2, str7, bundle);
            } else {
                Log.w("MicroMsg.ChattingItemAppMsgTo", "hy: video msg invalid!!");
            }
            AppMethodBeat.o(36833);
            return false;
        }

        public static boolean i(k.b bVar, com.tencent.mm.ui.chatting.e.a aVar, c cVar, ca caVar) {
            int i2 = 0;
            AppMethodBeat.i(36834);
            if (bVar.url == null || bVar.url.equals("")) {
                AppMethodBeat.o(36834);
                return false;
            } else if (!Util.isNullOrNil(bVar.canvasPageXml)) {
                Intent intent = new Intent();
                intent.putExtra("sns_landig_pages_from_source", 5);
                intent.putExtra("msg_id", caVar.field_msgId);
                intent.putExtra("sns_landing_pages_xml", bVar.canvasPageXml);
                intent.putExtra("sns_landing_pages_share_thumb_url", caVar.field_imgPath);
                intent.addFlags(268435456);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
                AppMethodBeat.o(36834);
                return true;
            } else {
                aj ajVar = (aj) bVar.as(aj.class);
                if (ajVar == null || Util.isNullOrNil(ajVar.IEy)) {
                    String R = com.tencent.mm.pluginsdk.model.app.q.R(bVar.url, aVar.gRM() ? "groupmessage" : "singlemessage");
                    String str = bVar.url;
                    PackageInfo packageInfo = c.getPackageInfo(aVar.Pwc.getContext(), bVar.appId);
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", R);
                    intent2.putExtra("webpageTitle", bVar.title);
                    if (bVar.appId != null && ("wx751a1acca5688ba3".equals(bVar.appId) || "wxfbc915ff7c30e335".equals(bVar.appId) || "wx482a4001c37e2b74".equals(bVar.appId))) {
                        Bundle bundle = new Bundle();
                        bundle.putString("jsapi_args_appid", bVar.appId);
                        intent2.putExtra("jsapiargs", bundle);
                    }
                    if (!Util.isNullOrNil(str)) {
                        intent2.putExtra("shortUrl", str);
                    } else {
                        intent2.putExtra("shortUrl", bVar.url);
                    }
                    intent2.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
                    intent2.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
                    if (!Util.isNullOrNil(bVar.eag)) {
                        intent2.putExtra("srcUsername", bVar.eag);
                        intent2.putExtra("srcDisplayname", bVar.eah);
                    }
                    intent2.putExtra("msg_id", caVar.field_msgId);
                    intent2.putExtra("KPublisherId", "msg_" + Long.toString(caVar.field_msgSvrId));
                    intent2.putExtra("KAppId", bVar.appId);
                    intent2.putExtra("geta8key_username", aVar.getTalkerUserName());
                    intent2.putExtra("pre_username", cVar.a(aVar, caVar));
                    intent2.putExtra("from_scence", 2);
                    intent2.putExtra("expid_str", caVar.fRa);
                    int aJ = com.tencent.mm.model.ac.aJ(cVar.a(aVar, caVar), aVar.getTalkerUserName());
                    intent2.putExtra("prePublishId", "msg_" + Long.toString(caVar.field_msgSvrId));
                    intent2.putExtra("preUsername", cVar.a(aVar, caVar));
                    intent2.putExtra("preChatName", aVar.getTalkerUserName());
                    intent2.putExtra("preChatTYPE", aJ);
                    intent2.putExtra("preMsgIndex", 0);
                    switch (aJ) {
                        case 1:
                            i2 = 3;
                            break;
                        case 2:
                            i2 = 2;
                            break;
                        case 6:
                        case 7:
                            i2 = 5;
                            break;
                    }
                    intent2.putExtra("share_report_pre_msg_url", bVar.url);
                    intent2.putExtra("share_report_pre_msg_title", bVar.title);
                    intent2.putExtra("share_report_pre_msg_desc", bVar.description);
                    intent2.putExtra("share_report_pre_msg_icon_url", bVar.thumburl);
                    intent2.putExtra("share_report_pre_msg_appid", bVar.appId);
                    intent2.putExtra("share_report_from_scene", i2);
                    if (i2 == 5) {
                        intent2.putExtra("share_report_biz_username", aVar.getTalkerUserName());
                    }
                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    AppMethodBeat.o(36834);
                    return true;
                }
                fat fat = new fat();
                fat.IEy = ajVar.IEy;
                fat.IEz = ajVar.IEz;
                fat.IEA = ajVar.IEA;
                fat.IEB = ajVar.IEB;
                fat.IEC = ajVar.IEC;
                fat.IEG = ajVar.IEG;
                fat.rCq = ajVar.rCq;
                fat.msN = ajVar.msN;
                fat.xDQ = ajVar.xDQ;
                fat.IED = ajVar.IED;
                fat.IEE = ajVar.IEE;
                fat.IEF = ajVar.IEF;
                fat.source = ajVar.source;
                fat.eby = ajVar.eby;
                fat.IEH = ajVar.IEH;
                fat.IEJ = ajVar.IEJ;
                fat.IEK = ajVar.IEK;
                fat.IEL = ajVar.IEL;
                fat.IEI = ajVar.IEI;
                com.tencent.mm.plugin.websearch.api.ai.a(aVar.Pwc.getContext(), com.tencent.mm.plugin.topstory.a.h.a(fat, 32, aVar.Pwc.getContext().getString(R.string.dkf)));
                i.a(fat, caVar);
                AppMethodBeat.o(36834);
                return true;
            }
        }

        public static boolean j(k.b bVar, com.tencent.mm.ui.chatting.e.a aVar, c cVar, ca caVar) {
            int i2;
            AppMethodBeat.i(169873);
            if (!Util.isNullOrNil(bVar.canvasPageXml)) {
                Intent intent = new Intent();
                intent.putExtra("sns_landig_pages_from_source", 5);
                intent.putExtra("msg_id", caVar.field_msgId);
                intent.putExtra("sns_landing_pages_xml", bVar.canvasPageXml);
                intent.putExtra("sns_landing_pages_share_thumb_url", caVar.field_imgPath);
                String ka = com.tencent.mm.plugin.sns.data.k.ka(aVar.PkU, caVar.field_talker);
                if (!TextUtils.isEmpty(ka)) {
                    intent.putExtra("sns_landing_pages_extra", ka);
                }
                intent.addFlags(268435456);
                com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "sns", ".ui.SnsAdNativeLandingPagesPreviewUI", intent);
                AppMethodBeat.o(169873);
                return true;
            }
            aj ajVar = (aj) bVar.as(aj.class);
            if (ajVar == null || Util.isNullOrNil(ajVar.IEy)) {
                if (bVar.url != null && !bVar.url.equals("")) {
                    String R = com.tencent.mm.pluginsdk.model.app.q.R(bVar.url, aVar.gRM() ? "groupmessage" : "singlemessage");
                    String str = bVar.iwH;
                    int intExtra = aVar.Pwc.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
                    if (((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahv(R)) {
                        R = ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).d(R, 1, intExtra, (int) (System.currentTimeMillis() / 1000));
                    }
                    PackageInfo packageInfo = c.getPackageInfo(aVar.Pwc.getContext(), bVar.appId);
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", R);
                    intent2.putExtra("webpageTitle", bVar.title);
                    intent2.putExtra("msgUsername", aVar.PkU);
                    intent2.putExtra("serverMsgID", String.valueOf(caVar.field_msgSvrId));
                    Bundle bundle = new Bundle();
                    bundle.putString("key_snsad_statextstr", bVar.ean);
                    if (bVar.appId != null && ("wx751a1acca5688ba3".equals(bVar.appId) || "wxfbc915ff7c30e335".equals(bVar.appId) || "wx482a4001c37e2b74".equals(bVar.appId))) {
                        bundle.putString("jsapi_args_appid", bVar.appId);
                    }
                    intent2.putExtra("jsapiargs", bundle);
                    if (!Util.isNullOrNil(str)) {
                        intent2.putExtra("shortUrl", str);
                    } else {
                        intent2.putExtra("shortUrl", bVar.url);
                    }
                    intent2.putExtra("version_name", packageInfo == null ? null : packageInfo.versionName);
                    intent2.putExtra("version_code", packageInfo == null ? 0 : packageInfo.versionCode);
                    if (!Util.isNullOrNil(bVar.eag)) {
                        intent2.putExtra("srcUsername", bVar.eag);
                        intent2.putExtra("srcDisplayname", bVar.eah);
                    }
                    intent2.putExtra("msg_id", caVar.field_msgId);
                    intent2.putExtra("KPublisherId", "msg_" + Long.toString(caVar.field_msgSvrId));
                    intent2.putExtra("KAppId", bVar.appId);
                    intent2.putExtra("geta8key_username", aVar.getTalkerUserName());
                    intent2.putExtra("pre_username", cVar.a(aVar, caVar));
                    intent2.putExtra("from_scence", 2);
                    int aJ = com.tencent.mm.model.ac.aJ(cVar.a(aVar, caVar), aVar.getTalkerUserName());
                    intent2.putExtra("prePublishId", "msg_" + Long.toString(caVar.field_msgSvrId));
                    intent2.putExtra("preUsername", cVar.a(aVar, caVar));
                    intent2.putExtra("preChatName", aVar.getTalkerUserName());
                    intent2.putExtra("preChatTYPE", aJ);
                    intent2.putExtra("preMsgIndex", 0);
                    switch (aJ) {
                        case 1:
                            i2 = 3;
                            break;
                        case 2:
                            i2 = 2;
                            break;
                        case 3:
                        case 4:
                        case 5:
                        default:
                            i2 = 0;
                            break;
                        case 6:
                        case 7:
                            i2 = 5;
                            break;
                    }
                    intent2.putExtra("share_report_pre_msg_url", bVar.url);
                    intent2.putExtra("share_report_pre_msg_title", bVar.title);
                    intent2.putExtra("share_report_pre_msg_desc", bVar.description);
                    intent2.putExtra("share_report_pre_msg_icon_url", bVar.thumburl);
                    intent2.putExtra("share_report_pre_msg_appid", bVar.appId);
                    intent2.putExtra("geta8key_scene", 1);
                    intent2.putExtra("share_report_from_scene", i2);
                    if (i2 == 5) {
                        intent2.putExtra("share_report_biz_username", aVar.getTalkerUserName());
                    }
                    com.tencent.mm.ag.e eVar = (com.tencent.mm.ag.e) bVar.as(com.tencent.mm.ag.e.class);
                    int i3 = eVar != null ? eVar.iwc : -1;
                    intent2.putExtra(e.p.OzA, i3);
                    intent2.putExtra("key_enable_teen_mode_check", true);
                    intent2.putExtra("msgUsername", aVar.PkU);
                    intent2.putExtra("serverMsgID", String.valueOf(caVar.field_msgSvrId));
                    if (eVar != null && i3 == 5 && eVar.iwe == 1 && ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).cld()) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putInt(e.b.OyQ, 1);
                        bundle2.putInt(e.b.OyR, intExtra);
                        bundle2.putInt("geta8key_scene", 1);
                        bundle2.putString("geta8key_username", aVar.getTalkerUserName());
                        bundle2.putString("webpageTitle", bVar.title);
                        if (ajVar != null && !Util.isNullOrNil(ajVar.IEy)) {
                            com.tencent.mm.plugin.webview.ui.tools.video.a aVar2 = com.tencent.mm.plugin.webview.ui.tools.video.a.JxN;
                            com.tencent.mm.plugin.webview.ui.tools.video.a.bbi(ajVar.IEy);
                        }
                        com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(aVar.Pwc.getContext(), caVar.field_msgId, caVar.field_msgSvrId, 0, bundle2);
                        AppMethodBeat.o(169873);
                        return true;
                    } else if (!((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(3) || !((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(aVar.Pwc.getContext(), R, i3, 1, intExtra, intent2)) {
                        com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    } else {
                        Log.i("MicroMsg.ChattingItemAppMsgTo", "jump to TmplWebview");
                        AppMethodBeat.o(169873);
                        return true;
                    }
                }
                AppMethodBeat.o(169873);
                return true;
            }
            fat fat = new fat();
            fat.IEy = ajVar.IEy;
            fat.IEz = ajVar.IEz;
            fat.IEA = ajVar.IEA;
            fat.IEB = ajVar.IEB;
            fat.IEC = ajVar.IEC;
            fat.IEG = ajVar.IEG;
            fat.rCq = ajVar.rCq;
            fat.msN = ajVar.msN;
            fat.xDQ = ajVar.xDQ;
            fat.IED = ajVar.IED;
            fat.IEE = ajVar.IEE;
            fat.IEF = ajVar.IEF;
            fat.source = ajVar.source;
            fat.eby = ajVar.eby;
            fat.IEH = ajVar.IEH;
            fat.IEJ = ajVar.IEJ;
            fat.IEK = ajVar.IEK;
            fat.IEL = ajVar.IEL;
            fat.IEI = ajVar.IEI;
            com.tencent.mm.plugin.websearch.api.ai.a(aVar.Pwc.getContext(), com.tencent.mm.plugin.topstory.a.h.a(fat, 32, aVar.Pwc.getContext().getString(R.string.dkf)));
            i.a(fat, caVar);
            AppMethodBeat.o(169873);
            return true;
        }

        private static void a(c cVar, com.tencent.mm.ui.chatting.d.b.k kVar, ca caVar) {
            AppMethodBeat.i(36827);
            if (caVar.field_status != 2 || !b(kVar, caVar.field_msgId)) {
                if (cVar.PIn != null) {
                    cVar.PIn.setVisibility(8);
                }
            } else if (cVar.PIn != null) {
                cVar.PIn.setVisibility(0);
                AppMethodBeat.o(36827);
                return;
            }
            AppMethodBeat.o(36827);
        }

        @Override // com.tencent.mm.ui.chatting.t.n
        public final void b(View view, final com.tencent.mm.ui.chatting.e.a aVar, final ca caVar) {
            AppMethodBeat.i(233603);
            com.tencent.mm.ui.base.h.c(aVar.Pwc.getContext(), aVar.Pwc.getMMResources().getString(R.string.b1x), "", aVar.Pwc.getMMResources().getString(R.string.yh), aVar.Pwc.getMMResources().getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.viewitems.e.C2107e.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(36804);
                    if (caVar.dOQ()) {
                        com.tencent.mm.pluginsdk.model.app.m.aS(caVar);
                        aVar.BN(true);
                        AppMethodBeat.o(36804);
                        return;
                    }
                    AppMethodBeat.o(36804);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.chatting.viewitems.e.C2107e.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(179968);
                    AppMethodBeat.o(179968);
                }
            });
            AppMethodBeat.o(233603);
        }
    }

    public static void a(k.b bVar, com.tencent.mm.ui.chatting.e.a aVar, ca caVar) {
        AppMethodBeat.i(36838);
        pa paVar = new pa();
        paVar.dVb.context = aVar.Pwc.getContext();
        paVar.dVb.msgId = caVar.field_msgId;
        paVar.dVb.dUo = aVar.gRM();
        paVar.dVb.dVc = bVar.ixl;
        paVar.dVb.scene = 6;
        EventCenter.instance.publish(paVar);
        AppMethodBeat.o(36838);
    }

    /* access modifiers changed from: package-private */
    public static final class c extends c.a {
        public static int[] tnn = {R.id.axp, R.id.axq, R.id.axr, R.id.axs, R.id.axt};
        private ArrayList<MMImageView> EuD = new ArrayList<>();
        protected MMImageView PHM;
        protected MMNeat7extView PHN;
        protected ImageView PHO;
        protected ImageView PHP;
        protected TextView PHQ;
        protected LinearLayout PHR;
        protected TextView PHS;
        protected ImageView PHT;
        protected MMPinProgressBtn PHU;
        protected ImageView PHV;
        protected ImageView PHW;
        protected ImageView PHX;
        protected ImageView PHY;
        protected TextView PHZ;
        protected ImageView PIA;
        LinearLayout PIB;
        TextView PIC;
        TextView PID;
        ImageView PIE;
        ImageView PIF;
        ImageView PIG;
        TextView PIH;
        ImageView PII;
        LinearLayout PIJ;
        MMNeat7extView PIK;
        ImageView PIL;
        ImageView PIM;
        ImageView PIN;
        TextView PIO;
        TextView PIP;
        TextView PIQ;
        LinearLayout PIR;
        LinearLayout PIS;
        ImageView PIT;
        TextView PIU;
        TextView PIV;
        ImageView PIW;
        RelativeLayout PIX;
        LinearLayout PIY;
        TextView PIZ;
        protected ChattingItemFooter PIa;
        protected ImageView PIb;
        protected LinearLayout PIc;
        protected ViewGroup PId;
        protected TextView PIe;
        protected LinearLayout PIf;
        protected RelativeLayout PIg;
        protected FrameLayout PIh;
        protected LinearLayout PIi;
        protected LinearLayout PIj;
        protected ViewStub PIk;
        protected ImageView PIl;
        protected ImageView PIm;
        ImageView PIn;
        protected LinearLayout PIo;
        protected ImageView PIp;
        protected TextView PIq;
        protected ImageView PIr;
        protected TextView PIs;
        protected TextView PIt;
        protected LinearLayout PIu;
        protected ImageView PIv;
        protected ImageView PIw;
        protected ImageView PIx;
        protected TextView PIy;
        protected LinearLayout PIz;
        public int PJa = 0;
        private int PJb = Integer.MAX_VALUE;
        protected TextView jBR;
        protected ImageView lrd;
        protected TextView tln;

        c() {
            AppMethodBeat.i(36762);
            AppMethodBeat.o(36762);
        }

        public final c F(View view, boolean z) {
            AppMethodBeat.i(36763);
            super.create(view);
            this.PIz = (LinearLayout) view.findViewById(R.id.at0);
            this.PHM = (MMImageView) view.findViewById(R.id.att);
            this.PHN = (MMNeat7extView) view.findViewById(R.id.atv);
            this.PHS = (TextView) view.findViewById(R.id.aty);
            this.jBR = (TextView) view.findViewById(R.id.at9);
            this.tln = (TextView) view.findViewById(R.id.atq);
            this.PHO = (ImageView) view.findViewById(R.id.atn);
            this.PHQ = (TextView) view.findViewById(R.id.atp);
            this.PHP = (ImageView) view.findViewById(R.id.ato);
            this.PHR = (LinearLayout) view.findViewById(R.id.atm);
            this.PHT = (ImageView) view.findViewById(R.id.atr);
            this.PHU = (MMPinProgressBtn) view.findViewById(R.id.av1);
            this.PHV = (ImageView) this.convertView.findViewById(R.id.av0);
            this.PHW = (ImageView) this.convertView.findViewById(R.id.aup);
            this.PHX = (ImageView) this.convertView.findViewById(R.id.aye);
            this.PHY = (ImageView) view.findViewById(R.id.ata);
            this.PHZ = (TextView) view.findViewById(R.id.at6);
            this.PIb = (ImageView) view.findViewById(R.id.atl);
            this.checkBox = (CheckBox) view.findViewById(R.id.aue);
            this.maskView = view.findViewById(R.id.ax3);
            this.userTV = (TextView) view.findViewById(R.id.ayn);
            this.PIa = (ChattingItemFooter) view.findViewById(R.id.d8b);
            this.PIc = (LinearLayout) view.findViewById(R.id.s8);
            this.PId = (ViewGroup) view.findViewById(R.id.equ);
            this.PIe = (TextView) view.findViewById(R.id.eqr);
            this.PIf = (LinearLayout) view.findViewById(R.id.atz);
            this.PIh = (FrameLayout) view.findViewById(R.id.auf);
            this.PIi = (LinearLayout) view.findViewById(R.id.at7);
            this.PIm = (ImageView) view.findViewById(R.id.aun);
            this.PIg = (RelativeLayout) view.findViewById(R.id.ats);
            this.PIk = (ViewStub) view.findViewById(R.id.g1i);
            this.PIl = (ImageView) view.findViewById(R.id.aus);
            if (!z) {
                this.PIn = (ImageView) this.convertView.findViewById(R.id.ayd);
                this.uploadingPB = (ProgressBar) this.convertView.findViewById(R.id.j0y);
            }
            this.PIu = (LinearLayout) view.findViewById(R.id.aso);
            this.PIr = (ImageView) view.findViewById(R.id.at1);
            this.PIs = (TextView) view.findViewById(R.id.at3);
            this.PIy = (TextView) view.findViewById(R.id.asz);
            this.PIx = (ImageView) view.findViewById(R.id.c4n);
            this.PIv = (ImageView) view.findViewById(R.id.asp);
            this.PIw = (ImageView) view.findViewById(R.id.asm);
            this.PIo = (LinearLayout) view.findViewById(R.id.asn);
            this.PIp = (ImageView) view.findViewById(R.id.arz);
            this.PIq = (TextView) view.findViewById(R.id.as0);
            this.PIt = (TextView) view.findViewById(R.id.at2);
            this.lrd = (ImageView) view.findViewById(R.id.as1);
            this.PIA = (ImageView) view.findViewById(R.id.as3);
            this.PIB = (LinearLayout) view.findViewById(R.id.ass);
            this.PIC = (TextView) view.findViewById(R.id.asy);
            this.PID = (TextView) view.findViewById(R.id.asu);
            this.PIE = (ImageView) view.findViewById(R.id.asv);
            this.PIF = (ImageView) view.findViewById(R.id.ast);
            this.PIG = (ImageView) view.findViewById(R.id.asw);
            this.PIH = (TextView) view.findViewById(R.id.asx);
            this.PII = (ImageView) view.findViewById(R.id.asr);
            this.PIJ = (LinearLayout) view.findViewById(R.id.atc);
            this.PIN = (ImageView) view.findViewById(R.id.atg);
            this.PIK = (MMNeat7extView) view.findViewById(R.id.ath);
            this.PIL = (ImageView) view.findViewById(R.id.atf);
            this.PIR = (LinearLayout) view.findViewById(R.id.flc);
            this.PIS = (LinearLayout) view.findViewById(R.id.fle);
            this.PIW = (ImageView) view.findViewById(R.id.fld);
            this.PIX = (RelativeLayout) view.findViewById(R.id.atd);
            this.PIT = (ImageView) this.PIR.findViewById(R.id.at_);
            this.PIU = (TextView) this.PIR.findViewById(R.id.atb);
            this.PIV = (TextView) this.PIR.findViewById(R.id.atk);
            this.PIM = (ImageView) this.PIS.findViewById(R.id.at_);
            this.PIO = (TextView) this.PIS.findViewById(R.id.atb);
            this.PIQ = (TextView) this.PIS.findViewById(R.id.atk);
            this.PIP = (TextView) view.findViewById(R.id.ate);
            this.PIY = (LinearLayout) view.findViewById(R.id.atw);
            this.PIZ = (TextView) view.findViewById(R.id.atx);
            if (this.PHS != null && Build.VERSION.SDK_INT >= 16) {
                this.PJb = this.PHS.getMaxLines();
            }
            this.PJa = c.kk(MMApplicationContext.getContext());
            AppMethodBeat.o(36763);
            return this;
        }

        public final void reset() {
            AppMethodBeat.i(36764);
            if (this.PHS != null) {
                this.PHS.setMaxLines(this.PJb);
            }
            AppMethodBeat.o(36764);
        }

        public static void a(c cVar, String str, int i2) {
            AppMethodBeat.i(36765);
            int bdI = com.tencent.mm.pluginsdk.model.app.m.bdI(str);
            if (bdI == -1 || bdI >= 100 || i2 <= 0) {
                cVar.PHU.setVisibility(8);
                cVar.PHV.setVisibility(8);
                AppMethodBeat.o(36765);
                return;
            }
            cVar.PHU.setVisibility(0);
            cVar.PHV.setVisibility(0);
            cVar.PHU.setProgress(bdI);
            AppMethodBeat.o(36765);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        static void a(com.tencent.mm.ui.chatting.e.a aVar, c cVar, k.b bVar, boolean z) {
            String str;
            String str2;
            boolean z2;
            AppMethodBeat.i(36767);
            cVar.PHN.setVisibility(8);
            if (bVar.title == null || bVar.title.trim().length() <= 0) {
                cVar.PHS.setVisibility(8);
                str = null;
            } else {
                str = bVar.title;
                cVar.PHS.setVisibility(0);
                cVar.PHS.setMaxLines(2);
            }
            cVar.jBR.setMaxLines(4);
            cVar.PHY.setVisibility(8);
            cVar.PHT.setVisibility(4);
            if (z) {
                cVar.PHM.setVisibility(8);
            }
            rc rcVar = new rc();
            rcVar.dXF.type = 0;
            rcVar.dXF.dXH = bVar.ixl;
            EventCenter.instance.publish(rcVar);
            com.tencent.mm.protocal.b.a.c cVar2 = rcVar.dXG.dXP;
            if (cVar2 != null) {
                cVar.PHS.setText(l.b(cVar.PHS.getContext(), Util.nullAs(cVar2.title, bVar.title), cVar.PHS.getTextSize()));
                String str3 = cVar2.desc;
                if (str3 == null) {
                    Log.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", bVar.ixl);
                } else {
                    str3 = str3.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                }
                if (str3 != null && str3.length() > 100) {
                    str3 = str3.substring(0, 100);
                }
                cVar.jBR.setText(l.b(cVar.jBR.getContext(), Util.nullAs(str3, bVar.description), cVar.jBR.getTextSize()));
                Iterator<aml> it = cVar2.iAd.iterator();
                boolean z3 = false;
                String str4 = null;
                String str5 = null;
                str2 = str;
                while (it.hasNext()) {
                    aml next = it.next();
                    if (!com.tencent.mm.plugin.fav.ui.l.j(next) || Util.isNullOrNil(next.Lwp) || !next.Lwp.equals("WeNoteHtmlFile")) {
                        if (next.Lwh.LwO.LxA != null) {
                            z2 = true;
                            str2 = aVar.Pwc.getContext().getString(R.string.fvq);
                        } else {
                            if (next.Lwh.LwO.dRL != null) {
                                if (str5 == null) {
                                    str5 = next.Lwj;
                                    z2 = z3;
                                } else if (str5 != next.Lwj) {
                                    str4 = next.Lwj;
                                    z2 = z3;
                                }
                            }
                            z2 = z3;
                        }
                        switch (next.dataType) {
                            case 1:
                                z3 = z2;
                                break;
                            case 2:
                                if (z) {
                                    cVar.PHM.setVisibility(0);
                                    cVar.PHM.setImageResource(R.drawable.bxc);
                                }
                                z3 = z2;
                                break;
                            case 3:
                                if (z) {
                                    cVar.PHM.setVisibility(0);
                                    cVar.PHM.setImageResource(R.raw.app_attach_file_icon_voice);
                                }
                                z3 = z2;
                                break;
                            case 4:
                                if (z) {
                                    cVar.PHM.setVisibility(0);
                                    cVar.PHM.setImageResource(R.raw.app_attach_file_icon_video);
                                }
                                cVar.PHY.setVisibility(0);
                                cVar.PHY.setImageResource(R.drawable.b1k);
                                z3 = z2;
                                break;
                            case 5:
                                if (z) {
                                    cVar.PHM.setVisibility(0);
                                    cVar.PHM.setImageResource(R.raw.app_attach_file_icon_webpage);
                                }
                                z3 = z2;
                                break;
                            case 6:
                                cVar.PHM.setVisibility(0);
                                cVar.PHM.setImageResource(R.raw.app_attach_file_icon_location);
                                z3 = z2;
                                break;
                            case 7:
                                if (z) {
                                    cVar.PHM.setVisibility(0);
                                    cVar.PHM.setImageResource(R.raw.app_attach_file_icon_music);
                                }
                                cVar.PHY.setVisibility(0);
                                cVar.PHY.setImageResource(R.drawable.am5);
                                z3 = z2;
                                break;
                            case 8:
                                if (z) {
                                    cVar.PHM.setVisibility(0);
                                    cVar.PHM.setImageResource(com.tencent.mm.pluginsdk.f.bcX(next.LvC));
                                }
                                z3 = z2;
                                break;
                            case 9:
                            case 12:
                            case 13:
                            case 15:
                            case 17:
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            default:
                                z3 = z2;
                                break;
                            case 10:
                            case 11:
                            case 14:
                                if (z) {
                                    cVar.PHM.setVisibility(0);
                                    cVar.PHM.setImageResource(R.raw.app_attach_file_icon_unknow);
                                }
                                z3 = z2;
                                break;
                            case 16:
                                if (z) {
                                    cVar.PHM.setVisibility(0);
                                    cVar.PHM.setImageResource(R.drawable.bca);
                                }
                                z3 = z2;
                                break;
                            case 22:
                                if (z && !com.tencent.mm.plugin.fav.a.b.cUq()) {
                                    cVar.PHM.setVisibility(0);
                                    cVar.PHM.setImageResource(R.raw.icons_outlined_finder_icon);
                                    z3 = z2;
                                    break;
                                }
                                z3 = z2;
                                break;
                            case 29:
                                if (z) {
                                    cVar.PHM.setVisibility(0);
                                    cVar.PHM.setImageResource(R.raw.app_attach_file_icon_music);
                                }
                                cVar.PHY.setVisibility(0);
                                cVar.PHY.setImageResource(R.drawable.am5);
                                z3 = z2;
                                break;
                        }
                    }
                }
                if (str5 != null && str4 == null && !z3) {
                    str2 = aVar.Pwc.getContext().getString(R.string.cb7, new Object[]{str5});
                } else if (str5 != null && str4 != null && !str5.equals(str4) && !z3) {
                    str2 = aVar.Pwc.getContext().getString(R.string.cb6, new Object[]{str5, str4});
                }
            } else {
                str2 = str;
            }
            if (!Util.isNullOrNil(str2)) {
                cVar.PHS.setText(str2);
                cVar.PHS.setVisibility(0);
            }
            cVar.PHM.setVisibility(8);
            cVar.PIg.setVisibility(8);
            AppMethodBeat.o(36767);
        }

        static void a(com.tencent.mm.ui.chatting.e.a aVar, c cVar, k.b bVar, ca caVar, boolean z) {
            int i2;
            int gvi;
            AppMethodBeat.i(36768);
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.e eVar = com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.pAN;
            com.tencent.mm.plugin.brandservice.ui.timeline.preload.e.F(bVar.url, 5, "");
            cVar.PIi.setVisibility(8);
            cVar.PIJ.setVisibility(0);
            cVar.PIS.setVisibility(0);
            if (bVar.title == null || bVar.title.length() <= 0) {
                cVar.PIK.setVisibility(8);
            } else {
                cVar.PIK.setMaxLines(2);
                cVar.PIK.setVisibility(0);
                cVar.PIK.aw(bVar.getTitle());
            }
            com.tencent.mm.ag.e eVar2 = (com.tencent.mm.ag.e) bVar.as(com.tencent.mm.ag.e.class);
            if (eVar2 != null) {
                i2 = eVar2.duration;
            } else {
                i2 = 0;
            }
            String rJ = com.tencent.mm.ag.m.rJ(i2);
            if (!Util.isNullOrNil(rJ)) {
                cVar.PIP.setVisibility(0);
                cVar.PIP.setText(rJ);
            } else {
                cVar.PIP.setVisibility(8);
            }
            cVar.PIN.setVisibility(0);
            if (eVar2 != null && com.tencent.mm.ag.x.rK(eVar2.iwg)) {
                cVar.PIP.setVisibility(8);
                cVar.PIN.setVisibility(8);
            }
            al.a(aVar.Pwc.getContext(), bVar, cVar.PIM, cVar.PIO);
            al.b(cVar.PIQ, bVar);
            cVar.PHT.setVisibility(4);
            int aG = com.tencent.mm.cb.a.aG(aVar.Pwc.getContext(), R.dimen.xb) - com.tencent.mm.cb.a.fromDPToPix((Context) aVar.Pwc.getContext(), 24);
            int i3 = (aG * 9) / 16;
            if (com.tencent.mm.cb.a.ez(aVar.Pwc.getContext()) > 1.0f && cVar.PIX.getLayoutParams().height != (gvi = (int) ((((((float) cVar.PJa) / com.tencent.mm.cc.a.gvi()) - (((float) com.tencent.mm.cb.a.fromDPToPix((Context) aVar.Pwc.getContext(), 29)) * com.tencent.mm.cb.a.ez(aVar.Pwc.getContext()))) * 9.0f) / 16.0f))) {
                cVar.PIX.getLayoutParams().height = gvi;
                cVar.PIX.requestLayout();
            }
            if (z || !Util.isNullOrNil(bVar.thumburl)) {
                String u = com.tencent.mm.api.b.u(bVar.thumburl, 4);
                c.a aVar2 = new c.a();
                aVar2.jbq = R.color.j6;
                aVar2.jbe = true;
                aVar2.fullPath = com.tencent.mm.pluginsdk.model.s.bdu(u);
                c.a dr = aVar2.dr(aG, i3);
                dr.jaU = new n(4);
                dr.jbC = new com.tencent.mm.pluginsdk.ui.applet.e(4);
                dr.jbd = true;
                q.bcV().a(u, cVar.PIL, aVar2.bdv());
                AppMethodBeat.o(36768);
                return;
            }
            Bitmap bitmap = null;
            if (!b.bnh(caVar.field_imgPath)) {
                bitmap = q.bcR().a(caVar.field_imgPath, com.tencent.mm.cb.a.getDensity(aVar.Pwc.getContext()), false);
            }
            if (bitmap == null || bitmap.isRecycled()) {
                cVar.PIL.setImageResource(R.color.j6);
                AppMethodBeat.o(36768);
                return;
            }
            cVar.PIL.setImageBitmap(bitmap);
            AppMethodBeat.o(36768);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        static void b(com.tencent.mm.ui.chatting.e.a aVar, c cVar, k.b bVar, ca caVar, boolean z) {
            String string;
            boolean z2;
            String str;
            String str2;
            int i2;
            String str3;
            String str4;
            AppMethodBeat.i(36769);
            rc rcVar = new rc();
            rcVar.dXF.type = 0;
            rcVar.dXF.dXH = bVar.ixl;
            EventCenter.instance.publish(rcVar);
            com.tencent.mm.protocal.b.a.c cVar2 = rcVar.dXG.dXP;
            cVar.PIg.setVisibility(8);
            String[] strArr = new String[4];
            String[] strArr2 = new String[4];
            int[] iArr = new int[4];
            String[] strArr3 = new String[4];
            String[] strArr4 = new String[4];
            int[] iArr2 = new int[4];
            String[] strArr5 = new String[4];
            if (cVar2 != null) {
                String str5 = null;
                String nullAs = Util.nullAs(cVar2.desc, bVar.description);
                boolean z3 = false;
                Iterator<aml> it = cVar2.iAd.iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    aml next = it.next();
                    if (!com.tencent.mm.plugin.fav.ui.l.j(next) || Util.isNullOrNil(next.Lwp) || !next.Lwp.equals("WeNoteHtmlFile")) {
                        switch (next.dataType) {
                            case 1:
                                if (!z3) {
                                    String str6 = next.desc;
                                    if (!Util.isNullOrNil(str6)) {
                                        if (!Util.isNullOrNil(str6.replaceAll("\n", "").trim())) {
                                            str4 = next.desc.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                                        } else {
                                            str4 = str5;
                                        }
                                        z3 = true;
                                        str5 = str4;
                                        break;
                                    }
                                }
                                nullAs = nullAs;
                                break;
                            case 2:
                                if (z) {
                                    cVar.PIg.setVisibility(0);
                                    cVar.PHM.setVisibility(0);
                                    cVar.PHM.setImageResource(R.drawable.bxc);
                                }
                                if (i3 < 4) {
                                    strArr[i3] = next.iwX;
                                    strArr2[i3] = next.Lvk;
                                    iArr[i3] = (int) next.LvT;
                                    strArr3[i3] = next.KuR;
                                    strArr4[i3] = next.Lvp;
                                    iArr2[i3] = (int) next.LvI;
                                    strArr5[i3] = next.dLl;
                                }
                                i3++;
                                break;
                            case 3:
                            case 6:
                                break;
                            case 4:
                            case 5:
                            case 7:
                            default:
                                nullAs = nullAs;
                                break;
                            case 8:
                                if (Util.isNullOrNil(nullAs)) {
                                    nullAs = MMApplicationContext.getContext().getString(R.string.ve) + next.title;
                                }
                                nullAs = nullAs;
                                break;
                        }
                    }
                }
                if (str5 != null) {
                    String[] split = str5.split("\n", 2);
                    ArrayList arrayList = new ArrayList();
                    if (split.length > 0) {
                        for (String str7 : split) {
                            if (str7.length() > 0) {
                                arrayList.add(str7);
                            }
                        }
                    }
                    z2 = arrayList.size() == 1;
                    if (arrayList.size() == 1 && cVar2.iAd.size() == 2) {
                        str3 = MMApplicationContext.getContext().getString(R.string.cd5);
                    } else if (i3 > 0) {
                        str3 = (String) arrayList.get(0);
                        if (arrayList.size() > 1) {
                            str5 = (String) arrayList.get(1);
                        } else {
                            str5 = null;
                        }
                    } else {
                        str3 = (String) arrayList.get(0);
                        String[] split2 = nullAs.split(Pattern.quote(str3), 2);
                        str5 = split2[0].trim();
                        if (split2.length > 1) {
                            str5 = (split2[0].trim() + "\n" + split2[1].trim()).trim();
                        }
                    }
                    string = str3.trim();
                } else {
                    string = MMApplicationContext.getContext().getString(R.string.cd5);
                    z2 = false;
                    str5 = nullAs;
                }
                if (string != null) {
                    str = string.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                } else {
                    str = string;
                }
                cVar.PHS.setText(l.e(cVar.PHS.getContext(), (CharSequence) str, (int) cVar.PHS.getTextSize()));
                if (str5 == null || str5.length() <= 100) {
                    str2 = str5;
                } else {
                    str2 = str5.substring(0, 100).replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                }
                cVar.jBR.setText(l.e(cVar.jBR.getContext(), (CharSequence) str2, (int) cVar.jBR.getTextSize()));
                if (i3 > 0) {
                    cVar.PIg.setVisibility(8);
                    if (z2 || !z3 || Util.isNullOrNil(str2)) {
                        cVar.jBR.setVisibility(8);
                        cVar.PHS.setMaxLines(2);
                    } else {
                        cVar.jBR.setMaxLines(1);
                        cVar.jBR.setVisibility(0);
                        cVar.PHS.setMaxLines(1);
                    }
                    cVar.PIl.setVisibility(8);
                    cVar.PIk.setLayoutResource(R.layout.se);
                    try {
                        if (cVar.PIj == null) {
                            cVar.PIj = (LinearLayout) cVar.PIk.inflate();
                        } else {
                            cVar.PIj.setVisibility(0);
                        }
                    } catch (Exception e2) {
                        cVar.PIk.setVisibility(0);
                    }
                    if (i3 > 4) {
                        i2 = 4;
                    } else {
                        i2 = i3;
                    }
                    a(aVar, cVar, i2, strArr5, strArr2, strArr, iArr, caVar.field_talker);
                    ImageView imageView = (ImageView) cVar.PIj.findViewById(R.id.axu);
                    TextView textView = (TextView) cVar.PIj.findViewById(R.id.axo);
                    if (textView != null) {
                        textView.setTextSize(0, (float) MMApplicationContext.getContext().getResources().getDimensionPixelSize(R.dimen.k5));
                    }
                    if (i3 > 4) {
                        if (imageView != null) {
                            imageView.setVisibility(0);
                        }
                        if (textView != null) {
                            textView.setText("(" + i3 + ")");
                            textView.setVisibility(0);
                        }
                    }
                    AppMethodBeat.o(36769);
                    return;
                }
                cVar.PIk.setVisibility(8);
                cVar.PIl.setVisibility(0);
            }
            AppMethodBeat.o(36769);
        }

        private static void a(com.tencent.mm.ui.chatting.e.a aVar, c cVar, int i2, String[] strArr, String[] strArr2, String[] strArr3, int[] iArr, String str) {
            MMImageView mMImageView;
            AppMethodBeat.i(233597);
            for (int i3 = 0; i3 <= 4; i3++) {
                MMImageView mMImageView2 = (MMImageView) cVar.PIj.findViewById(tnn[i3]);
                if (mMImageView2 != null) {
                    mMImageView2.setImageDrawable(null);
                    mMImageView2.setVisibility(8);
                }
            }
            ImageView imageView = (ImageView) cVar.PIj.findViewById(R.id.axu);
            TextView textView = (TextView) cVar.PIj.findViewById(R.id.axo);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (textView != null) {
                textView.setVisibility(8);
            }
            for (int i4 = 0; i4 < i2; i4++) {
                if (i2 == 1) {
                    mMImageView = (MMImageView) cVar.PIj.findViewById(tnn[i4]);
                    mMImageView.setImageResource(R.raw.chatting_note_default_img_one);
                } else {
                    mMImageView = (MMImageView) cVar.PIj.findViewById(tnn[i4 + 1]);
                    mMImageView.setImageResource(R.raw.chatting_note_default_img);
                }
                mMImageView.setVisibility(0);
                String o = q.bcR().o("Note_" + strArr[i4], "", "");
                c.a aVar2 = new c.a();
                aVar2.jbi = 1;
                aVar2.jby = true;
                aVar2.jbt = R.raw.chatting_note_default_img;
                aVar2.hZz = (int) aVar.Pwc.getMMResources().getDimension(R.dimen.a9);
                aVar2.hZA = (int) aVar.Pwc.getMMResources().getDimension(R.dimen.a9);
                com.tencent.mm.av.a.a.c bdv = aVar2.bdv();
                if (s.YS(o)) {
                    q.bcV().a(o, mMImageView, bdv);
                } else {
                    com.tencent.mm.pluginsdk.model.app.k gne = com.tencent.mm.pluginsdk.model.app.ao.gne();
                    k.a aVar3 = (k.a) aVar.bh(com.tencent.mm.ui.chatting.d.b.k.class);
                    String str2 = strArr[i4];
                    long nowMilliSecond = Util.nowMilliSecond();
                    String str3 = strArr2[i4];
                    String str4 = strArr3[i4];
                    int i5 = iArr[i4];
                    String o2 = q.bcR().o("Note_".concat(String.valueOf(str2)), "", "");
                    if (!s.YS(o2)) {
                        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                        gVar.taskName = "task_AppMessageExtension_2";
                        gVar.field_mediaId = com.tencent.mm.an.c.a("downappthumb", nowMilliSecond, str, String.valueOf(str2));
                        gVar.field_fullpath = o2;
                        gVar.field_fileType = com.tencent.mm.i.a.MediaType_FULLSIZEIMAGE;
                        gVar.field_totalLen = i5;
                        gVar.field_aesKey = str3;
                        gVar.field_fileId = str4;
                        gVar.field_priority = com.tencent.mm.i.a.gpN;
                        gVar.field_chattype = ab.Eq(str) ? 1 : 0;
                        Log.d("MicroMsg.AppMessageExtension", "get thumb by cdn [appmsg 2] chatType[%d] user[%s] ", Integer.valueOf(gVar.field_chattype), str);
                        gVar.gqy = 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0180: IPUT  
                              (wrap: com.tencent.mm.pluginsdk.model.app.k$2 : 0x017d: CONSTRUCTOR  (r3v20 com.tencent.mm.pluginsdk.model.app.k$2) = 
                              (r5v6 'gne' com.tencent.mm.pluginsdk.model.app.k)
                              (r2v17 'aVar3' com.tencent.mm.pluginsdk.model.app.k$a)
                              (r9v0 'str4' java.lang.String)
                             call: com.tencent.mm.pluginsdk.model.app.k.2.<init>(com.tencent.mm.pluginsdk.model.app.k, com.tencent.mm.pluginsdk.model.app.k$a, java.lang.String):void type: CONSTRUCTOR)
                              (r12v3 'gVar' com.tencent.mm.i.g)
                             com.tencent.mm.i.g.gqy com.tencent.mm.i.g$a in method: com.tencent.mm.ui.chatting.viewitems.e.c.a(com.tencent.mm.ui.chatting.e.a, com.tencent.mm.ui.chatting.viewitems.e$c, int, java.lang.String[], java.lang.String[], java.lang.String[], int[], java.lang.String):void, file: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:217)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:110)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:56)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:143)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:157)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:99)
                            	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:210)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:67)
                            	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:93)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:59)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:244)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:237)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:342)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:295)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:264)
                            	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.util.ArrayList.forEach(ArrayList.java:1259)
                            	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x017d: CONSTRUCTOR  (r3v20 com.tencent.mm.pluginsdk.model.app.k$2) = 
                              (r5v6 'gne' com.tencent.mm.pluginsdk.model.app.k)
                              (r2v17 'aVar3' com.tencent.mm.pluginsdk.model.app.k$a)
                              (r9v0 'str4' java.lang.String)
                             call: com.tencent.mm.pluginsdk.model.app.k.2.<init>(com.tencent.mm.pluginsdk.model.app.k, com.tencent.mm.pluginsdk.model.app.k$a, java.lang.String):void type: CONSTRUCTOR in method: com.tencent.mm.ui.chatting.viewitems.e.c.a(com.tencent.mm.ui.chatting.e.a, com.tencent.mm.ui.chatting.viewitems.e$c, int, java.lang.String[], java.lang.String[], java.lang.String[], int[], java.lang.String):void, file: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:255)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:119)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:103)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:428)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:249)
                            	... 29 more
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.tencent.mm.pluginsdk.model.app.k, state: GENERATED_AND_UNLOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:215)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:630)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:363)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
                            	... 33 more
                            */
                        /*
                        // Method dump skipped, instructions count: 405
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.e.c.a(com.tencent.mm.ui.chatting.e.a, com.tencent.mm.ui.chatting.viewitems.e$c, int, java.lang.String[], java.lang.String[], java.lang.String[], int[], java.lang.String):void");
                    }

                    public static void a(c cVar, final Boolean bool, final ca caVar, final String str, final String str2) {
                        AppMethodBeat.i(36766);
                        final long j2 = caVar.field_msgId;
                        com.tencent.mm.pluginsdk.model.app.c Mp = com.tencent.mm.pluginsdk.model.app.ao.cgO().Mp(j2);
                        if (Mp == null) {
                            Log.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", Long.valueOf(j2), str2);
                            AppMethodBeat.o(36766);
                            return;
                        }
                        if (bool.booleanValue()) {
                            if (Mp.field_status == 101) {
                                cVar.PHX.setVisibility(0);
                                cVar.PHU.setVisibility(0);
                                cVar.PHV.setVisibility(0);
                            } else if (Mp.field_status == 102) {
                                cVar.PHX.setVisibility(8);
                                cVar.PHU.setVisibility(8);
                                cVar.PHV.setVisibility(8);
                            } else {
                                cVar.PHX.setVisibility(8);
                                cVar.PHU.setVisibility(8);
                                cVar.PHV.setVisibility(8);
                            }
                        } else if (Mp.field_status == 101) {
                            cVar.PHX.setVisibility(0);
                            cVar.PHW.setVisibility(8);
                        } else if (Mp.field_status == 105) {
                            cVar.PHX.setVisibility(8);
                            cVar.PHW.setVisibility(0);
                        } else {
                            cVar.PHX.setVisibility(8);
                            cVar.PHW.setVisibility(8);
                        }
                        if (caVar.field_status == 5) {
                            cVar.PHX.setVisibility(8);
                            cVar.PHW.setVisibility(8);
                        }
                        cVar.PHX.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.e.c.AnonymousClass1 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(36760);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                if (bool.booleanValue()) {
                                    long j2 = j2;
                                    String str = str2;
                                    com.tencent.mm.pluginsdk.model.app.c Mp = com.tencent.mm.pluginsdk.model.app.ao.cgO().Mp(j2);
                                    if (Mp == null) {
                                        Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.apq() + " getinfo failed: " + str);
                                    } else if (Mp.field_status != 101) {
                                        Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.apq() + " get status failed: " + str + " status:" + Mp.field_status);
                                    } else {
                                        Mp.field_status = 102;
                                        Mp.field_lastModifyTime = Util.nowSecond();
                                        com.tencent.mm.pluginsdk.model.app.ao.cgO().a(Mp, new String[0]);
                                    }
                                } else {
                                    long j3 = j2;
                                    String str2 = str2;
                                    com.tencent.mm.pluginsdk.model.app.c Mp2 = com.tencent.mm.pluginsdk.model.app.ao.cgO().Mp(j3);
                                    if (Mp2 == null) {
                                        Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.apq() + " getinfo failed: " + str2);
                                    } else if (Mp2.field_status != 101) {
                                        Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.apq() + " get status failed: " + str2 + " status:" + Mp2.field_status);
                                    } else {
                                        if (!Util.isNullOrNil(Mp2.field_clientAppDataId) || Util.isNullOrNil(Mp2.field_mediaSvrId)) {
                                            Mp2.field_status = 105;
                                        } else {
                                            Mp2.field_status = 102;
                                        }
                                        Mp2.field_lastModifyTime = Util.nowSecond();
                                        com.tencent.mm.pluginsdk.model.app.ao.cgO().a(Mp2, new String[0]);
                                    }
                                    caVar.setStatus(5);
                                    bg.aVF();
                                    com.tencent.mm.model.c.aSQ().Hb(j2);
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(36760);
                            }
                        });
                        cVar.PHW.setOnClickListener(new View.OnClickListener() {
                            /* class com.tencent.mm.ui.chatting.viewitems.e.c.AnonymousClass2 */

                            public final void onClick(View view) {
                                AppMethodBeat.i(36761);
                                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                bVar.bm(view);
                                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                if (!bool.booleanValue()) {
                                    long j2 = j2;
                                    String str = str2;
                                    com.tencent.mm.pluginsdk.model.app.c Mp = com.tencent.mm.pluginsdk.model.app.ao.cgO().Mp(j2);
                                    if (Mp == null) {
                                        Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.apq() + " getinfo failed: " + str);
                                    } else if (Mp.field_status == 105 || Mp.field_status == 101) {
                                        Mp.field_status = 101;
                                        Mp.field_lastModifyTime = Util.nowSecond();
                                        com.tencent.mm.pluginsdk.model.app.ao.cgO().a(Mp, new String[0]);
                                        com.tencent.mm.pluginsdk.model.app.ao.gnh().run();
                                    } else {
                                        Log.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.f.apq() + " get status failed: " + str + " status:" + Mp.field_status);
                                    }
                                    caVar.setStatus(1);
                                    bg.aVF();
                                    com.tencent.mm.model.c.aSQ().Hb(j2);
                                }
                                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMsgViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                AppMethodBeat.o(36761);
                            }
                        });
                        AppMethodBeat.o(36766);
                    }

                    @SuppressLint({"ResourceType"})
                    public static void a(com.tencent.mm.ui.chatting.e.a aVar, c cVar, k.b bVar) {
                        AppMethodBeat.i(233598);
                        String w = bVar.w(aVar.Pwc.getContext(), false);
                        if (!Util.isNullOrNil(w)) {
                            cVar.PHR.setVisibility(0);
                            cVar.tln.setVisibility(0);
                            cVar.PHO.setVisibility(0);
                            cVar.tln.setText(w);
                            if (k.a.BUSINESS_MY_LIFE_AROUND.ordinal() == bVar.izp) {
                                cVar.PHO.setImageResource(R.raw.my_life_around_default_icon);
                                AppMethodBeat.o(233598);
                                return;
                            } else if (k.a.BUSINESS_OTHER.ordinal() == bVar.izp || !Util.isNullOrNil(bVar.izt)) {
                                q.bcU().a(Util.isNullOrNil(bVar.izt) ? bVar.izB : bVar.izt, new r.a(cVar) {
                                    /* class com.tencent.mm.ui.chatting.viewitems.e.c.AnonymousClass3 */
                                    final /* synthetic */ c PJe;

                                    {
                                        this.PJe = r1;
                                    }

                                    @Override // com.tencent.mm.av.r.a
                                    public final void a(String str, final Bitmap bitmap, String str2) {
                                        AppMethodBeat.i(233596);
                                        MMHandlerThread.postToMainThread(new Runnable() {
                                            /* class com.tencent.mm.ui.chatting.viewitems.e.c.AnonymousClass3.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(233595);
                                                AnonymousClass3.this.PJe.PHO.setImageBitmap(bitmap);
                                                AppMethodBeat.o(233595);
                                            }
                                        });
                                        AppMethodBeat.o(233596);
                                    }
                                });
                            }
                        }
                        AppMethodBeat.o(233598);
                    }
                }

                /* access modifiers changed from: package-private */
                public static class b {
                    static boolean a(Context context, k.b bVar) {
                        AppMethodBeat.i(233594);
                        if (bVar == null || context == null) {
                            AppMethodBeat.o(233594);
                            return false;
                        } else if (e.m(bVar) == 3) {
                            boolean s = com.tencent.mm.pluginsdk.model.app.h.s(context, 16);
                            AppMethodBeat.o(233594);
                            return s;
                        } else if (bVar.type == 4) {
                            boolean s2 = com.tencent.mm.pluginsdk.model.app.h.s(context, 8);
                            AppMethodBeat.o(233594);
                            return s2;
                        } else if (bVar.type == 5) {
                            boolean s3 = com.tencent.mm.pluginsdk.model.app.h.s(context, 32);
                            AppMethodBeat.o(233594);
                            return s3;
                        } else if (bVar.type == 6) {
                            Long bcU = e.a.bcU(bVar.iwJ);
                            if (bcU == null) {
                                AppMethodBeat.o(233594);
                                return false;
                            }
                            boolean s4 = com.tencent.mm.pluginsdk.model.app.h.s(context, bcU.longValue());
                            AppMethodBeat.o(233594);
                            return s4;
                        } else {
                            AppMethodBeat.o(233594);
                            return false;
                        }
                    }

                    static boolean bng(String str) {
                        AppMethodBeat.i(36755);
                        boolean isImageExt = Util.isImageExt(str);
                        AppMethodBeat.o(36755);
                        return isImageExt;
                    }

                    static void a(final com.tencent.mm.ui.chatting.e.a aVar, final ca caVar, String str) {
                        boolean z;
                        AppMethodBeat.i(36756);
                        String b2 = bp.b(aVar.gRM(), caVar.field_content, caVar.field_isSend);
                        final Intent intent = new Intent(aVar.Pwc.getContext(), MsgRetransmitUI.class);
                        intent.putExtra("Retr_Msg_content", b2);
                        intent.putExtra("Retr_MsgFromScene", 2);
                        k.b HD = k.b.HD(b2);
                        if (HD != null && 19 == HD.type) {
                            intent.putExtra("Retr_Msg_Type", 10);
                        } else if (HD != null && 24 == HD.type) {
                            intent.putExtra("Retr_Msg_Type", 10);
                        } else if (HD == null || 16 != HD.type) {
                            if (HD != null && (33 == HD.type || 36 == HD.type)) {
                                aa aaVar = new aa();
                                aaVar.iAX = HD;
                                EventCenter.instance.publish(aaVar);
                            }
                            intent.putExtra("Retr_Msg_Type", 2);
                            String str2 = caVar.field_talker;
                            String JX = ad.JX(new StringBuilder().append(caVar.field_msgSvrId).toString());
                            intent.putExtra("reportSessionId", JX);
                            ad.b G = ad.aVe().G(JX, true);
                            G.l("prePublishId", "msg_" + caVar.field_msgSvrId);
                            G.l("preUsername", str);
                            G.l("preChatName", str2);
                            if (!(HD == null || HD.as(com.tencent.mm.ag.a.class) == null)) {
                                G.l("appservicetype", Integer.valueOf(((com.tencent.mm.ag.a) HD.as(com.tencent.mm.ag.a.class)).iuS));
                                intent.putExtra("Retr_MsgAppBrandServiceType", ((com.tencent.mm.ag.a) HD.as(com.tencent.mm.ag.a.class)).iuS);
                            }
                            if (HD != null && 33 == HD.type) {
                                if (!WeChatBrands.Business.Entries.SessionAppbrand.checkAvailable(aVar.Pwc.getContext())) {
                                    AppMethodBeat.o(36756);
                                    return;
                                }
                                if (aVar.gRM()) {
                                    G.l("fromScene", 2);
                                    intent.putExtra("Retr_MsgAppBrandFromScene", 2);
                                } else {
                                    G.l("fromScene", 1);
                                    intent.putExtra("Retr_MsgAppBrandFromScene", 1);
                                }
                                intent.putExtra("Retr_MsgFromUserName", str);
                                intent.putExtra("Retr_MsgTalker", caVar.field_talker);
                            }
                            G.l("sendAppMsgScene", 1);
                            ((j) com.tencent.mm.kernel.g.af(j.class)).a("adExtStr", G, caVar);
                        } else {
                            intent.putExtra("Retr_Msg_Type", 14);
                        }
                        intent.putExtra("Retr_Msg_Id", caVar.field_msgId);
                        if (HD == null || HD.type != 6) {
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            aVar.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(36756);
                            return;
                        }
                        if (HD.type == 6) {
                            com.tencent.mm.plugin.report.e.INSTANCE.idkeyStat(1203, 7, 1, false);
                            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                            Object[] objArr = new Object[11];
                            objArr[0] = HD.iwW;
                            objArr[1] = Integer.valueOf(HD.iwM == 1 ? 7 : 5);
                            objArr[2] = Integer.valueOf(HD.iwI);
                            objArr[3] = 2;
                            objArr[4] = Long.valueOf((cl.aWz() - caVar.field_createTime) / 1000);
                            objArr[5] = HD.iwJ;
                            objArr[6] = caVar.field_talker;
                            objArr[7] = 1;
                            objArr[8] = "";
                            objArr[9] = Long.valueOf(caVar.field_msgSvrId);
                            objArr[10] = Long.valueOf(caVar.field_createTime);
                            hVar.a(14665, objArr);
                        }
                        boolean z2 = HD.iwM != 0 || HD.iwI > 26214400;
                        intent.putExtra("Retr_Big_File", z2);
                        final com.tencent.mm.pluginsdk.model.app.c bdJ = com.tencent.mm.pluginsdk.model.app.m.bdJ(HD.dCK);
                        if (bdJ != null) {
                            com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(bdJ.field_fileFullPath);
                            if (oVar.exists() && oVar.length() == bdJ.field_totalLen) {
                                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                com.tencent.mm.hellhoundlib.a.a.a(aVar, bl2.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                aVar.startActivity((Intent) bl2.pG(0));
                                com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "retransmitAppMsg", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                AppMethodBeat.o(36756);
                                return;
                            } else if (bdJ.field_offset > 0 && bdJ.field_totalLen > bdJ.field_offset) {
                                String str3 = bdJ.field_fileFullPath;
                                if (caVar.gDB() || h(caVar, str3)) {
                                    Log.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                                    com.tencent.mm.ui.base.h.d(aVar.Pwc.getContext(), aVar.Pwc.getContext().getString(R.string.ce2), aVar.Pwc.getContext().getString(R.string.zb), new DialogInterface.OnClickListener() {
                                        /* class com.tencent.mm.ui.chatting.viewitems.e.b.AnonymousClass3 */

                                        public final void onClick(DialogInterface dialogInterface, int i2) {
                                        }
                                    });
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (!z) {
                                    com.tencent.mm.ui.base.h.c(aVar.Pwc.getContext(), aVar.Pwc.getMMResources().getString(R.string.bip), "", true);
                                }
                                AppMethodBeat.o(36756);
                                return;
                            }
                        }
                        Log.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", Integer.valueOf(HD.iwI), HD.iwW, Util.secPrint(HD.aesKey));
                        if (!z2) {
                            a(aVar, intent, caVar);
                            AppMethodBeat.o(36756);
                            return;
                        }
                        intent.putExtra("Retr_Big_File", z2);
                        com.tencent.mm.i.g gVar = new com.tencent.mm.i.g();
                        gVar.taskName = "task_ChattingItemAppMsg";
                        gVar.gqy = new g.a() {
                            /* class com.tencent.mm.ui.chatting.viewitems.e.b.AnonymousClass1 */

                            @Override // com.tencent.mm.i.g.a
                            public final int a(String str, int i2, com.tencent.mm.i.c cVar, com.tencent.mm.i.d dVar, boolean z) {
                                AppMethodBeat.i(36753);
                                Object[] objArr = new Object[7];
                                objArr[0] = str;
                                objArr[1] = Integer.valueOf(i2);
                                objArr[2] = cVar;
                                objArr[3] = dVar;
                                objArr[4] = Boolean.valueOf(cVar != null);
                                objArr[5] = Boolean.valueOf(dVar != null);
                                objArr[6] = Boolean.valueOf(z);
                                Log.i("MicroMsg.AppMessageUtil", "summerbig cdnCallback mediaId:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]", objArr);
                                if (dVar != null) {
                                    if (dVar.field_exist_whencheck) {
                                        com.tencent.mm.ui.chatting.e.a aVar = aVar;
                                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                                        com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil$1", "callback", "(Ljava/lang/String;ILcom/tencent/mm/cdn/keep_ProgressInfo;Lcom/tencent/mm/cdn/keep_SceneResult;Z)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                        aVar.startActivity((Intent) bl.pG(0));
                                        com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil$1", "callback", "(Ljava/lang/String;ILcom/tencent/mm/cdn/keep_ProgressInfo;Lcom/tencent/mm/cdn/keep_SceneResult;Z)I", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                                    } else if (caVar.gDB() || (bdJ != null && b.h(caVar, bdJ.field_fileFullPath))) {
                                        com.tencent.f.h.RTc.aV(new Runnable() {
                                            /* class com.tencent.mm.ui.chatting.viewitems.e.b.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                AppMethodBeat.i(179946);
                                                Log.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                                                com.tencent.mm.ui.base.h.d(aVar.Pwc.getContext(), aVar.Pwc.getContext().getString(R.string.ce2), aVar.Pwc.getContext().getString(R.string.zb), new DialogInterface.OnClickListener() {
                                                    /* class com.tencent.mm.ui.chatting.viewitems.e.b.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                                    }
                                                });
                                                AppMethodBeat.o(179946);
                                            }
                                        });
                                    } else {
                                        com.tencent.f.h.RTc.aV(new Runnable() {
                                            /* class com.tencent.mm.ui.chatting.viewitems.e.b.AnonymousClass1.AnonymousClass2 */

                                            public final void run() {
                                                AppMethodBeat.i(179947);
                                                com.tencent.mm.ui.base.h.c(aVar.Pwc.getContext(), aVar.Pwc.getMMResources().getString(R.string.bip), "", true);
                                                AppMethodBeat.o(179947);
                                            }
                                        });
                                    }
                                }
                                AppMethodBeat.o(36753);
                                return 0;
                            }

                            @Override // com.tencent.mm.i.g.a
                            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                            }

                            @Override // com.tencent.mm.i.g.a
                            public final byte[] f(String str, byte[] bArr) {
                                return new byte[0];
                            }
                        };
                        gVar.field_mediaId = com.tencent.mm.an.c.a("checkExist", Util.nowMilliSecond(), str, new StringBuilder().append(caVar.field_msgId).toString());
                        gVar.field_fileId = HD.iwW;
                        gVar.field_aesKey = HD.aesKey;
                        gVar.field_filemd5 = HD.filemd5;
                        gVar.field_fileType = com.tencent.mm.i.a.gpO;
                        gVar.field_talker = str;
                        gVar.field_priority = com.tencent.mm.i.a.gpM;
                        gVar.field_svr_signature = "";
                        gVar.field_onlycheckexist = true;
                        boolean f2 = com.tencent.mm.an.f.baQ().f(gVar);
                        Log.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", Boolean.valueOf(f2), gVar.field_fileId, gVar.field_mediaId, Util.secPrint(gVar.field_aesKey));
                        if (!f2) {
                            a(aVar, intent, caVar);
                        }
                        AppMethodBeat.o(36756);
                    }

                    private static boolean a(com.tencent.mm.ui.chatting.e.a aVar, Intent intent, ca caVar) {
                        AppMethodBeat.i(36757);
                        if (caVar.gDB() || h(caVar, null)) {
                            Log.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                            com.tencent.mm.ui.base.h.d(aVar.Pwc.getContext(), aVar.Pwc.getContext().getString(R.string.ce2), aVar.Pwc.getContext().getString(R.string.zb), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.ui.chatting.viewitems.e.b.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            });
                            AppMethodBeat.o(36757);
                            return true;
                        }
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(aVar, bl.axQ(), "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "dealIllegalFile", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Landroid/content/Intent;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        aVar.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(aVar, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$AppMessageUtil", "dealIllegalFile", "(Lcom/tencent/mm/ui/chatting/context/ChattingContext;Landroid/content/Intent;Lcom/tencent/mm/storage/MsgInfo;Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(36757);
                        return false;
                    }

                    public static boolean h(ca caVar, String str) {
                        AppMethodBeat.i(36758);
                        if (System.currentTimeMillis() - caVar.field_createTime <= 259200000 || (!Util.isNullOrNil(str) && s.YS(str))) {
                            AppMethodBeat.o(36758);
                            return false;
                        }
                        AppMethodBeat.o(36758);
                        return true;
                    }

                    public static boolean bnh(String str) {
                        boolean z = false;
                        AppMethodBeat.i(36759);
                        String d2 = q.bcR().d(str, false, true);
                        if (!s.YS(d2)) {
                            AppMethodBeat.o(36759);
                        } else {
                            BitmapFactory.Options options = new BitmapFactory.Options();
                            options.inJustDecodeBounds = true;
                            Bitmap decodeFile = BitmapUtil.decodeFile(d2, options);
                            if (options.outWidth * options.outHeight > 1048576) {
                                Log.i("MicroMsg.AppMessageUtil", "Bitmap to big:%d/%d", Integer.valueOf(options.outWidth), Integer.valueOf(options.outHeight));
                                z = true;
                            }
                            if (decodeFile != null) {
                                decodeFile.recycle();
                            }
                            AppMethodBeat.o(36759);
                        }
                        return z;
                    }
                }

                static final class a {
                    static void a(Intent intent, com.tencent.mm.ui.chatting.e.a aVar, ca caVar, c cVar) {
                        String str;
                        int i2;
                        Bundle bundle;
                        AppMethodBeat.i(36752);
                        String talkerUserName = aVar.getTalkerUserName();
                        String a2 = cVar.a(aVar, caVar);
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
                        intent.putExtra("_stat_obj", bundle2);
                        AppMethodBeat.o(36752);
                    }
                }

                private static boolean l(k.b bVar) {
                    AppMethodBeat.i(36839);
                    aj ajVar = (aj) bVar.as(aj.class);
                    if (ajVar == null || Util.isNullOrNil(ajVar.IEy)) {
                        AppMethodBeat.o(36839);
                        return false;
                    }
                    AppMethodBeat.o(36839);
                    return true;
                }

                public static boolean a(ca caVar, k.b bVar, com.tencent.mm.ui.chatting.e.a aVar) {
                    AppMethodBeat.i(179986);
                    if (!y.ama()) {
                        AppMethodBeat.o(179986);
                        return false;
                    } else if (caVar == null) {
                        AppMethodBeat.o(179986);
                        return false;
                    } else if (bVar == null) {
                        AppMethodBeat.o(179986);
                        return false;
                    } else if (!com.tencent.mm.modelappbrand.a.b(bVar) && !com.tencent.mm.modelappbrand.a.c(bVar)) {
                        AppMethodBeat.o(179986);
                        return false;
                    } else if (cl.aWz() - caVar.field_createTime >= com.tencent.mm.chatroom.storage.d.gtt.longValue()) {
                        AppMethodBeat.o(179986);
                        return false;
                    } else if (ab.IE(aVar.getTalkerUserName())) {
                        AppMethodBeat.o(179986);
                        return true;
                    } else {
                        AppMethodBeat.o(179986);
                        return false;
                    }
                }

                public static void a(boolean z, c.a aVar, com.tencent.mm.ui.chatting.e.a aVar2) {
                    AppMethodBeat.i(179987);
                    if (aVar instanceof c) {
                        a(z, (c) aVar, aVar2);
                        AppMethodBeat.o(179987);
                        return;
                    }
                    if (aVar instanceof bd.f) {
                        bd.a(z, (bd.f) aVar, aVar2);
                    }
                    AppMethodBeat.o(179987);
                }

                public static void a(boolean z, c cVar, com.tencent.mm.ui.chatting.e.a aVar) {
                    AppMethodBeat.i(179988);
                    if (cVar == null) {
                        AppMethodBeat.o(179988);
                    } else if (z) {
                        cVar.PIY.setBackgroundResource(R.drawable.n9);
                        cVar.PIZ.setTextColor(aVar.Pwc.getContext().getResources().getColor(R.color.BW_100_Alpha_0_8));
                        cVar.PIZ.setText(R.string.dwl);
                        AppMethodBeat.o(179988);
                    } else {
                        cVar.PIY.setBackgroundResource(R.drawable.n_);
                        cVar.PIZ.setTextColor(aVar.Pwc.getContext().getResources().getColor(R.color.Brand));
                        cVar.PIZ.setText(R.string.dwn);
                        AppMethodBeat.o(179988);
                    }
                }

                public static void a(ca caVar, c.a aVar, com.tencent.mm.ui.chatting.e.a aVar2) {
                    AppMethodBeat.i(179989);
                    a(caVar, aVar, aVar2, 0);
                    AppMethodBeat.o(179989);
                }

                public static void a(final ca caVar, final c.a aVar, final com.tencent.mm.ui.chatting.e.a aVar2, final int i2) {
                    AppMethodBeat.i(185048);
                    if (caVar == null) {
                        Log.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo: msginfo is null");
                        AppMethodBeat.o(185048);
                    } else if (MultiProcessMMKV.getMMKV("group_to_do").getBoolean("introduce_dialog_first", true)) {
                        MultiProcessMMKV.getMMKV("group_to_do").edit().putBoolean("introduce_dialog_first", false);
                        a(aVar2.Pwc.getContext(), Util.isNullOrNil(caVar.fRe), aVar2.getTalkerUserName(), caVar.fRe, y.f(caVar), new g.a() {
                            /* class com.tencent.mm.ui.chatting.viewitems.e.AnonymousClass2 */

                            @Override // com.tencent.mm.ui.transmit.g.a
                            public final void gUb() {
                                AppMethodBeat.i(233586);
                                e.b(caVar, aVar, aVar2, i2);
                                AppMethodBeat.o(233586);
                            }
                        });
                        AppMethodBeat.o(185048);
                    } else {
                        a(caVar, aVar, aVar2, i2, 0);
                        AppMethodBeat.o(185048);
                    }
                }

                private static void a(final ca caVar, final c.a aVar, final com.tencent.mm.ui.chatting.e.a aVar2, int i2, int i3) {
                    String str;
                    AppMethodBeat.i(185049);
                    if (caVar == null) {
                        Log.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo: msginfo is null");
                        AppMethodBeat.o(185049);
                        return;
                    }
                    final boolean isNullOrNil = Util.isNullOrNil(caVar.fRe);
                    Activity context = aVar2.Pwc.getContext();
                    String str2 = caVar.field_talker;
                    if (Util.isNullOrNil(caVar.fRe)) {
                        str = y.d(caVar);
                    } else {
                        str = caVar.fRe;
                    }
                    y.a(context, str2, str, y.f(caVar), isNullOrNil, 2, i2, i3, new y.a() {
                        /* class com.tencent.mm.ui.chatting.viewitems.e.AnonymousClass3 */

                        @Override // com.tencent.mm.chatroom.d.y.a
                        public final void amc() {
                            boolean z;
                            AppMethodBeat.i(233587);
                            if (!isNullOrNil) {
                                z = true;
                            } else {
                                z = false;
                            }
                            e.a(z, aVar, aVar2);
                            Log.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp addtodo msgId(%s) result:%s", Long.valueOf(caVar.field_msgSvrId), y.c(caVar));
                            AppMethodBeat.o(233587);
                        }

                        @Override // com.tencent.mm.chatroom.d.y.a
                        public final void amd() {
                            boolean z;
                            AppMethodBeat.i(233588);
                            if (!isNullOrNil) {
                                z = true;
                            } else {
                                z = false;
                            }
                            e.a(z, aVar, aVar2);
                            Log.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp recall msgId(%s) result:%s", Long.valueOf(caVar.field_msgSvrId), y.e(caVar));
                            AppMethodBeat.o(233588);
                        }
                    });
                    AppMethodBeat.o(185049);
                }

                private static void a(Context context, final boolean z, final String str, final String str2, final String str3, final g.a aVar) {
                    AppMethodBeat.i(233604);
                    final com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(context, 1, false);
                    final View inflate = View.inflate(context, R.layout.c3l, null);
                    ImageView imageView = (ImageView) inflate.findViewById(R.id.iri);
                    if (LocaleUtil.isChineseAppLang()) {
                        imageView.setImageResource(R.drawable.cp6);
                    } else {
                        imageView.setImageResource(R.drawable.cp7);
                    }
                    final f fVar = new f((byte) 0);
                    inflate.findViewById(R.id.irm).setOnClickListener(new View.OnClickListener() {
                        /* class com.tencent.mm.ui.chatting.viewitems.e.AnonymousClass4 */

                        public final void onClick(View view) {
                            AppMethodBeat.i(233589);
                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                            bVar.bm(view);
                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                            Log.i("MicroMsg.ChattingItemAppMsg", "introduce View click confirm!");
                            fVar.PJq = true;
                            eVar.bMo();
                            if (aVar != null) {
                                aVar.gUb();
                            }
                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemAppMsg$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                            AppMethodBeat.o(233589);
                        }
                    });
                    eVar.HLX = new o.f() {
                        /* class com.tencent.mm.ui.chatting.viewitems.e.AnonymousClass5 */

                        @Override // com.tencent.mm.ui.base.o.f
                        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                            AppMethodBeat.i(233590);
                            mVar.clear();
                            eVar.setFooterView(null);
                            eVar.setFooterView(inflate);
                            AppMethodBeat.o(233590);
                        }
                    };
                    eVar.PGl = new e.b() {
                        /* class com.tencent.mm.ui.chatting.viewitems.e.AnonymousClass6 */
                        final /* synthetic */ int gsC = 0;

                        @Override // com.tencent.mm.ui.widget.a.e.b
                        public final void onDismiss() {
                            AppMethodBeat.i(233591);
                            if (!fVar.PJq) {
                                z.a(str, 1, this.gsC, z ? 1 : 2, 1, str2, str3);
                            }
                            AppMethodBeat.o(233591);
                        }
                    };
                    eVar.Dm(true);
                    eVar.dGm();
                    AppMethodBeat.o(233604);
                }

                public static boolean a(k.b bVar, final com.tencent.mm.ui.chatting.e.a aVar) {
                    AppMethodBeat.i(233605);
                    String str = bVar.izu;
                    String str2 = bVar.izv;
                    String str3 = bVar.izw;
                    if (Util.isNullOrNil(str)) {
                        AppMethodBeat.o(233605);
                        return false;
                    }
                    boolean z = WeChatEnvironment.isCoolassistEnv() || ((com.tencent.mm.plugin.lite.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.lite.a.a.class)).aCR(str);
                    com.tencent.mm.plugin.lite.b.f.ecC();
                    WxaLiteAppInfo aCT = com.tencent.mm.plugin.lite.b.f.aCT(str);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(1293, 30, 1);
                    if (z) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.n(1293, 31, 1);
                        if (aCT == null) {
                            com.tencent.mm.plugin.lite.b.f.ecC();
                            if (com.tencent.mm.plugin.lite.b.f.ecE() == null) {
                                com.tencent.mm.plugin.lite.b.f.ecC().ecF();
                            }
                            com.tencent.mm.plugin.lite.b.f.ecC().a(str, null);
                            z = false;
                        }
                    }
                    if (!z) {
                        AppMethodBeat.o(233605);
                        return false;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("appId", str);
                    if (!Util.isNullOrNil(str2)) {
                        bundle.putString("path", str2);
                    }
                    if (!Util.isNullOrNil(str3)) {
                        bundle.putString(SearchIntents.EXTRA_QUERY, str3);
                    }
                    Activity context = aVar.Pwc.getContext();
                    aVar.Pwc.getContext().getString(R.string.zb);
                    final com.tencent.mm.ui.base.q a2 = com.tencent.mm.ui.base.h.a((Context) context, aVar.Pwc.getContext().getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.ui.chatting.viewitems.e.AnonymousClass7 */

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    ((com.tencent.mm.plugin.lite.a.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.lite.a.a.class)).a(aVar.Pwc.getContext(), bundle, false, new a.AbstractC1459a() {
                        /* class com.tencent.mm.ui.chatting.viewitems.e.AnonymousClass8 */

                        @Override // com.tencent.mm.plugin.lite.a.a.AbstractC1459a
                        public final void dTt() {
                            AppMethodBeat.i(233592);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.n(1293, 32, 1);
                            a2.cancel();
                            AppMethodBeat.o(233592);
                        }

                        @Override // com.tencent.mm.plugin.lite.a.a.AbstractC1459a
                        public final void dTu() {
                            AppMethodBeat.i(233593);
                            u.makeText(aVar.Pwc.getContext(), (int) R.string.eka, 0).show();
                            a2.cancel();
                            AppMethodBeat.o(233593);
                        }
                    });
                    AppMethodBeat.o(233605);
                    return true;
                }

                /* access modifiers changed from: package-private */
                public static class f {
                    public boolean PJq;

                    private f() {
                        this.PJq = false;
                    }

                    /* synthetic */ f(byte b2) {
                        this();
                    }
                }

                static /* synthetic */ boolean a(k.b bVar, c cVar) {
                    AppMethodBeat.i(36840);
                    if (l(bVar)) {
                        cVar.PHR.setVisibility(0);
                        cVar.tln.setVisibility(0);
                        cVar.tln.setText(R.string.hpe);
                        cVar.PHO.setVisibility(0);
                        cVar.PHO.setImageResource(R.drawable.cp9);
                        AppMethodBeat.o(36840);
                        return true;
                    }
                    AppMethodBeat.o(36840);
                    return false;
                }

                static /* synthetic */ int m(k.b bVar) {
                    AppMethodBeat.i(233606);
                    if (bVar.type != 3 || com.tencent.mm.plugin.music.model.m.akQ(bVar.appId) || !com.tencent.mm.plugin.music.model.m.cAI()) {
                        int i2 = bVar.type;
                        AppMethodBeat.o(233606);
                        return i2;
                    }
                    AppMethodBeat.o(233606);
                    return 5;
                }

                static /* synthetic */ void a(String str, com.tencent.mm.ui.chatting.e.a aVar, ca caVar, k.b bVar) {
                    int i2;
                    AppMethodBeat.i(233607);
                    if (!TextUtils.isEmpty(bVar.url)) {
                        long j2 = caVar.field_createTime;
                        String talkerUserName = aVar.getTalkerUserName();
                        int aJ = com.tencent.mm.model.ac.aJ(str, talkerUserName);
                        com.tencent.mm.ag.e eVar = (com.tencent.mm.ag.e) bVar.as(com.tencent.mm.ag.e.class);
                        if (eVar != null) {
                            i2 = eVar.iwc;
                        } else {
                            i2 = -1;
                        }
                        ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).a(bVar.url, i2, 1, Long.valueOf(caVar.field_msgSvrId), talkerUserName, Integer.valueOf(aJ), str, Long.valueOf(j2), Long.valueOf(((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).ahy(talkerUserName)));
                        ((com.tencent.mm.plugin.brandservice.a.e) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.e.class)).a(bVar.url, 1, bVar.appId, bVar.title, bVar.description, aVar.gRM() ? "groupmessage" : "singlemessage", 2);
                        if (!ESt && i2 != -1 && ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CR(23)) {
                            ESt = true;
                            ((com.tencent.mm.plugin.brandservice.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class)).CS(1);
                        }
                    }
                    AppMethodBeat.o(233607);
                }

                static /* synthetic */ void h(final TextView textView, final String str) {
                    AppMethodBeat.i(233609);
                    if (str != null) {
                        textView.post(new Runnable() {
                            /* class com.tencent.mm.ui.chatting.viewitems.e.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(36751);
                                if (textView.getPaint().measureText(str) > ((float) ((textView.getMeasuredWidth() - textView.getPaddingLeft()) - textView.getPaddingRight()))) {
                                    textView.setMinLines(2);
                                    AppMethodBeat.o(36751);
                                    return;
                                }
                                textView.setMinLines(0);
                                AppMethodBeat.o(36751);
                            }
                        });
                    }
                    AppMethodBeat.o(233609);
                }

                static /* synthetic */ boolean a(k.b bVar, WxaAttributes wxaAttributes) {
                    boolean hP;
                    boolean z;
                    boolean z2 = false;
                    AppMethodBeat.i(233610);
                    if (wxaAttributes == null) {
                        Log.i("MicroMsg.ChattingItemAppMsg", "[wantShowTradingGuaranteeFlag] attrs is null, get trading guarantee flag from AppContentAppBrandPiece");
                        com.tencent.mm.ag.a aVar = (com.tencent.mm.ag.a) bVar.as(com.tencent.mm.ag.a.class);
                        if (aVar != null) {
                            z = com.tencent.luggage.sdk.config.e.hP(aVar.ivc);
                        } else {
                            z = false;
                        }
                        hP = z;
                    } else {
                        Log.i("MicroMsg.ChattingItemAppMsg", "[wantShowTradingGuaranteeFlag] use attrs");
                        hP = com.tencent.luggage.sdk.config.e.hP(wxaAttributes.bAo().lgD.leb);
                    }
                    if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_scene_appbrand_conversation_share_card, 0) == 1) {
                        z2 = true;
                    }
                    boolean z3 = hP & z2;
                    AppMethodBeat.o(233610);
                    return z3;
                }

                static /* synthetic */ boolean o(k.b bVar) {
                    AppMethodBeat.i(233611);
                    com.tencent.mm.ag.a aVar = (com.tencent.mm.ag.a) bVar.as(com.tencent.mm.ag.a.class);
                    if (aVar == null) {
                        AppMethodBeat.o(233611);
                        return false;
                    } else if (aVar.ivf == 1) {
                        AppMethodBeat.o(233611);
                        return true;
                    } else {
                        AppMethodBeat.o(233611);
                        return false;
                    }
                }

                static /* synthetic */ String Lk(String str) {
                    AppMethodBeat.i(233612);
                    if (str == null || !str.startsWith("wcf://")) {
                        String concat = "file://".concat(String.valueOf(str));
                        AppMethodBeat.o(233612);
                        return concat;
                    }
                    AppMethodBeat.o(233612);
                    return str;
                }

                static /* synthetic */ boolean a(com.tencent.mm.ui.chatting.e.a aVar, String str, String str2, String str3, Bundle bundle) {
                    AppMethodBeat.i(233613);
                    Intent putExtra = new Intent().putExtra("key_video_url", str);
                    putExtra.putExtra("key_video_url", str);
                    putExtra.putExtra("key_cover_path", str3);
                    putExtra.putExtra("key_auto_save", true);
                    putExtra.putExtra("key_local_file_path", str2);
                    putExtra.putExtra("key_ext_data", bundle);
                    putExtra.putExtra("key_scene", 1);
                    com.tencent.mm.br.c.b(aVar.Pwc.getContext(), "appbrand", ".ui.AppBrandVideoPreviewUI", putExtra);
                    AppMethodBeat.o(233613);
                    return true;
                }

                static /* synthetic */ void cL(ca caVar) {
                    boolean z;
                    AppMethodBeat.i(233614);
                    x xVar = x.Qxl;
                    x.gXY();
                    if (caVar == null) {
                        Log.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo: msginfo is null");
                        AppMethodBeat.o(233614);
                        return;
                    }
                    if (!Util.isNullOrNil(caVar.fRe)) {
                        com.tencent.mm.chatroom.storage.c ai = ((PluginChatroomUI) com.tencent.mm.kernel.g.ah(PluginChatroomUI.class)).getGroupTodoStorage().ai(caVar.field_talker, caVar.fRe);
                        if (ai == null) {
                            Log.e("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo stoTodo(%s) == null", Boolean.valueOf(Util.isNullOrNil(caVar.fRe)));
                            AppMethodBeat.o(233614);
                            return;
                        }
                        boolean e2 = y.e(ai);
                        if (e2) {
                            z = y.b(ai);
                            if (z) {
                                nt ntVar = new nt();
                                ntVar.dTT.op = 3;
                                ntVar.dTT.dOe = caVar.field_talker;
                                ntVar.dTT.dTU = caVar.fRe;
                                EventCenter.instance.asyncPublish(ntVar, Looper.getMainLooper());
                            }
                        } else {
                            z = false;
                        }
                        z.a(caVar.field_talker, 0, 3, caVar.fRe, y.f(caVar));
                        Log.i("MicroMsg.ChattingItemAppMsg", "handleAppBrandClickIncludeTodo stoTodo(%s) update finish(%s %s)", Boolean.valueOf(Util.isNullOrNil(caVar.fRe)), Boolean.valueOf(z), Boolean.valueOf(e2));
                    }
                    AppMethodBeat.o(233614);
                }
            }
