package com.tencent.mm.plugin.finder.profile.uic;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.common.Scopes;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ik;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.cgi.bb;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.cgi.cn;
import com.tencent.mm.plugin.finder.extension.reddot.h;
import com.tencent.mm.plugin.finder.feed.model.FinderProfileFeedLoader;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.profile.FinderProfileFeedFragment;
import com.tencent.mm.plugin.finder.report.d;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.ui.FinderCropAvatarUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.upload.action.g;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.utils.d;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLivePostBtnUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.forcenotify.f.a;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.aoy;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.app;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.ayu;
import com.tencent.mm.protocal.protobuf.bbj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.protocal.protobuf.fhi;
import com.tencent.mm.protocal.protobuf.fhn;
import com.tencent.mm.protocal.protobuf.or;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.TouchableLayout;
import com.tencent.mm.view.e;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.z;

public final class FinderProfileHeaderUIC extends UIComponent implements com.tencent.mm.ak.i {
    private static final com.tencent.mm.b.h<String, b> userExtInfoCache = new com.tencent.mm.b.h<>(100);
    private static final int vbY = 1;
    public static final a vbZ = new a((byte) 0);
    private final kotlin.f USE;
    private final kotlin.f USF;
    private final kotlin.f USG;
    private final kotlin.f USH;
    private final kotlin.f USI;
    private final kotlin.f USJ;
    private final kotlin.f USK;
    private final kotlin.f USL;
    private boolean USM;
    private final kotlin.f USN;
    private final kotlin.f USO;
    private final kotlin.f USP;
    private final String USQ;
    private final Context applicationContext = MMApplicationContext.getContext();
    private final int tOR;
    private final kotlin.f tYU;
    private final kotlin.f tZl;
    private final kotlin.f uZQ;
    String username;
    private final kotlin.f uuj;
    private final kotlin.f vaa;
    private final boolean vah;
    private final kotlin.f vbA;
    private final kotlin.f vbB;
    private final kotlin.f vbC;
    private final kotlin.f vbD;
    private final kotlin.f vbE;
    private final kotlin.f vbF;
    private final kotlin.f vbG;
    private final kotlin.f vbH;
    private final kotlin.f vbI;
    private final kotlin.f vbJ;
    private final kotlin.f vbK;
    private final kotlin.f vbL;
    private final kotlin.f vbM;
    private final kotlin.f vbN;
    private com.tencent.mm.ui.widget.a.e vbO;
    private final com.tencent.mm.plugin.finder.profile.adapter.a vbP;
    private IListener<ik> vbQ;
    private boolean vbR;
    private final int vbS;
    private int vbT;
    private int vbU;
    boolean vbV;
    private String vbW;
    private final p vbX;
    private View vbj;
    private final kotlin.f vbk;
    private final kotlin.f vbl;
    private final kotlin.f vbm;
    private final kotlin.f vbn;
    private final kotlin.f vbo;
    private final kotlin.f vbp;
    private final kotlin.f vbq;
    private final kotlin.f vbr;
    private final kotlin.f vbs;
    private final kotlin.f vbt;
    private final kotlin.f vbu;
    private final kotlin.f vbv;
    private final kotlin.f vbw;
    private final kotlin.f vbx;
    private final kotlin.f vby;
    private final kotlin.f vbz;

    private final TextView dmA() {
        AppMethodBeat.i(250347);
        TextView textView = (TextView) this.vbp.getValue();
        AppMethodBeat.o(250347);
        return textView;
    }

    private final LinearLayout dmB() {
        AppMethodBeat.i(250348);
        LinearLayout linearLayout = (LinearLayout) this.vbq.getValue();
        AppMethodBeat.o(250348);
        return linearLayout;
    }

    private final TextView dmC() {
        AppMethodBeat.i(250349);
        TextView textView = (TextView) this.vbr.getValue();
        AppMethodBeat.o(250349);
        return textView;
    }

    private final LinearLayout dmD() {
        AppMethodBeat.i(250350);
        LinearLayout linearLayout = (LinearLayout) this.vbs.getValue();
        AppMethodBeat.o(250350);
        return linearLayout;
    }

    private final LinearLayout dmE() {
        AppMethodBeat.i(250351);
        LinearLayout linearLayout = (LinearLayout) this.vbt.getValue();
        AppMethodBeat.o(250351);
        return linearLayout;
    }

    private final TextView dmF() {
        AppMethodBeat.i(250352);
        TextView textView = (TextView) this.vbu.getValue();
        AppMethodBeat.o(250352);
        return textView;
    }

    private final TextView dmG() {
        AppMethodBeat.i(250353);
        TextView textView = (TextView) this.vbv.getValue();
        AppMethodBeat.o(250353);
        return textView;
    }

    private final WeImageView dmH() {
        AppMethodBeat.i(250354);
        WeImageView weImageView = (WeImageView) this.vbw.getValue();
        AppMethodBeat.o(250354);
        return weImageView;
    }

    private final LinearLayout dmI() {
        AppMethodBeat.i(250355);
        LinearLayout linearLayout = (LinearLayout) this.vbx.getValue();
        AppMethodBeat.o(250355);
        return linearLayout;
    }

    private final TextView dmJ() {
        AppMethodBeat.i(250356);
        TextView textView = (TextView) this.vby.getValue();
        AppMethodBeat.o(250356);
        return textView;
    }

    private final TextView dmK() {
        AppMethodBeat.i(250357);
        TextView textView = (TextView) this.vbz.getValue();
        AppMethodBeat.o(250357);
        return textView;
    }

    private final WeImageView dmL() {
        AppMethodBeat.i(250358);
        WeImageView weImageView = (WeImageView) this.vbA.getValue();
        AppMethodBeat.o(250358);
        return weImageView;
    }

    private final LinearLayout dmM() {
        AppMethodBeat.i(250359);
        LinearLayout linearLayout = (LinearLayout) this.vbB.getValue();
        AppMethodBeat.o(250359);
        return linearLayout;
    }

    private final RelativeLayout dmN() {
        AppMethodBeat.i(250360);
        RelativeLayout relativeLayout = (RelativeLayout) this.vbC.getValue();
        AppMethodBeat.o(250360);
        return relativeLayout;
    }

    private final FrameLayout dmO() {
        AppMethodBeat.i(250361);
        FrameLayout frameLayout = (FrameLayout) this.vbD.getValue();
        AppMethodBeat.o(250361);
        return frameLayout;
    }

    private final WeImageView dmP() {
        AppMethodBeat.i(250362);
        WeImageView weImageView = (WeImageView) this.uZQ.getValue();
        AppMethodBeat.o(250362);
        return weImageView;
    }

    private final TextView dmQ() {
        AppMethodBeat.i(250363);
        TextView textView = (TextView) this.vbE.getValue();
        AppMethodBeat.o(250363);
        return textView;
    }

    private final RelativeLayout dmR() {
        AppMethodBeat.i(250364);
        RelativeLayout relativeLayout = (RelativeLayout) this.vbF.getValue();
        AppMethodBeat.o(250364);
        return relativeLayout;
    }

    private final TextView dmS() {
        AppMethodBeat.i(250365);
        TextView textView = (TextView) this.vbG.getValue();
        AppMethodBeat.o(250365);
        return textView;
    }

    private final RelativeLayout dmT() {
        AppMethodBeat.i(250366);
        RelativeLayout relativeLayout = (RelativeLayout) this.vbH.getValue();
        AppMethodBeat.o(250366);
        return relativeLayout;
    }

    private final TextView dmU() {
        AppMethodBeat.i(250367);
        TextView textView = (TextView) this.vbI.getValue();
        AppMethodBeat.o(250367);
        return textView;
    }

    private final TextView dmV() {
        AppMethodBeat.i(250368);
        TextView textView = (TextView) this.vbJ.getValue();
        AppMethodBeat.o(250368);
        return textView;
    }

    private final TextView dmW() {
        AppMethodBeat.i(250369);
        TextView textView = (TextView) this.vbK.getValue();
        AppMethodBeat.o(250369);
        return textView;
    }

    private final WeImageView dmX() {
        AppMethodBeat.i(250370);
        WeImageView weImageView = (WeImageView) this.vbL.getValue();
        AppMethodBeat.o(250370);
        return weImageView;
    }

    private final RelativeLayout dmY() {
        AppMethodBeat.i(250371);
        RelativeLayout relativeLayout = (RelativeLayout) this.vbM.getValue();
        AppMethodBeat.o(250371);
        return relativeLayout;
    }

    private final TextView dmZ() {
        AppMethodBeat.i(250372);
        TextView textView = (TextView) this.vbN.getValue();
        AppMethodBeat.o(250372);
        return textView;
    }

    private final FrameLayout dmv() {
        AppMethodBeat.i(250341);
        FrameLayout frameLayout = (FrameLayout) this.vbk.getValue();
        AppMethodBeat.o(250341);
        return frameLayout;
    }

    private final FrameLayout dmw() {
        AppMethodBeat.i(250342);
        FrameLayout frameLayout = (FrameLayout) this.vbl.getValue();
        AppMethodBeat.o(250342);
        return frameLayout;
    }

    private final WeImageView dmx() {
        AppMethodBeat.i(250343);
        WeImageView weImageView = (WeImageView) this.vbm.getValue();
        AppMethodBeat.o(250343);
        return weImageView;
    }

    private final TextView dmy() {
        AppMethodBeat.i(250344);
        TextView textView = (TextView) this.uuj.getValue();
        AppMethodBeat.o(250344);
        return textView;
    }

    private final TextView dmz() {
        AppMethodBeat.i(250346);
        TextView textView = (TextView) this.vbo.getValue();
        AppMethodBeat.o(250346);
        return textView;
    }

    private final ImageView getAvatarIv() {
        AppMethodBeat.i(250345);
        ImageView imageView = (ImageView) this.vbn.getValue();
        AppMethodBeat.o(250345);
        return imageView;
    }

    private final bbn getContextObj() {
        AppMethodBeat.i(250376);
        bbn bbn = (bbn) this.tYU.getValue();
        AppMethodBeat.o(250376);
        return bbn;
    }

    private final TextView hUA() {
        AppMethodBeat.i(261303);
        TextView textView = (TextView) this.USJ.getValue();
        AppMethodBeat.o(261303);
        return textView;
    }

    private final LinearLayout hUB() {
        AppMethodBeat.i(261304);
        LinearLayout linearLayout = (LinearLayout) this.USK.getValue();
        AppMethodBeat.o(261304);
        return linearLayout;
    }

    private final TextView hUC() {
        AppMethodBeat.i(261305);
        TextView textView = (TextView) this.USL.getValue();
        AppMethodBeat.o(261305);
        return textView;
    }

    private final LinearLayout hUv() {
        AppMethodBeat.i(261298);
        LinearLayout linearLayout = (LinearLayout) this.USE.getValue();
        AppMethodBeat.o(261298);
        return linearLayout;
    }

    private final View hUw() {
        AppMethodBeat.i(261299);
        View view = (View) this.USF.getValue();
        AppMethodBeat.o(261299);
        return view;
    }

    private final RelativeLayout hUx() {
        AppMethodBeat.i(261300);
        RelativeLayout relativeLayout = (RelativeLayout) this.USG.getValue();
        AppMethodBeat.o(261300);
        return relativeLayout;
    }

    private final TextView hUy() {
        AppMethodBeat.i(261301);
        TextView textView = (TextView) this.USH.getValue();
        AppMethodBeat.o(261301);
        return textView;
    }

    private final TextView hUz() {
        AppMethodBeat.i(261302);
        TextView textView = (TextView) this.USI.getValue();
        AppMethodBeat.o(261302);
        return textView;
    }

    private final boolean isSelfFlag() {
        AppMethodBeat.i(250373);
        boolean booleanValue = ((Boolean) this.tZl.getValue()).booleanValue();
        AppMethodBeat.o(250373);
        return booleanValue;
    }

    public static final class ai<T> implements Observer<h.a> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        ai(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            AppMethodBeat.i(250302);
            h.a aVar2 = aVar;
            View findViewById = this.vcd.vbj.findViewById(R.id.d27);
            kotlin.g.b.p.g(findViewById, "dotView");
            findViewById.setVisibility((aVar2 == null || !aVar2.dEF) ? 8 : 0);
            if (aVar2 != null) {
                if (aVar2.dEF) {
                    com.tencent.mm.plugin.finder.extension.reddot.k kVar = aVar2.tKT;
                    bdo bdo = aVar2.tKS;
                    if (!(kVar == null || bdo == null)) {
                        com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                        com.tencent.mm.plugin.finder.report.j.a(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, kVar, bdo, 1, FinderProfileHeaderUIC.c(this.vcd), 0, 0, 96);
                    }
                }
                AppMethodBeat.o(250302);
                return;
            }
            AppMethodBeat.o(250302);
        }
    }

    public static final class au extends kotlin.g.b.q implements kotlin.g.a.q<Integer, Integer, String, kotlin.x> {
        final /* synthetic */ com.tencent.mm.plugin.finder.api.g tEr;
        final /* synthetic */ FinderProfileHeaderUIC vcd;
        final /* synthetic */ SpannableString vcm;
        final /* synthetic */ z.d vcn;
        final /* synthetic */ z.d vco;
        final /* synthetic */ StringBuilder vcp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        au(FinderProfileHeaderUIC finderProfileHeaderUIC, SpannableString spannableString, z.d dVar, z.d dVar2, com.tencent.mm.plugin.finder.api.g gVar, StringBuilder sb) {
            super(3);
            this.vcd = finderProfileHeaderUIC;
            this.vcm = spannableString;
            this.vcn = dVar;
            this.vco = dVar2;
            this.tEr = gVar;
            this.vcp = sb;
        }

        @Override // kotlin.g.a.q
        public final /* synthetic */ kotlin.x d(Integer num, Integer num2, String str) {
            AppMethodBeat.i(250317);
            int intValue = num.intValue();
            int intValue2 = num2.intValue();
            String str2 = str;
            kotlin.g.b.p.h(str2, "nickname");
            this.vcm.setSpan(new com.tencent.mm.plugin.finder.view.l(str2, this.vcn.SYE, this.vco.SYE, new kotlin.g.a.b<String, kotlin.x>(this) {
                /* class com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC.au.AnonymousClass1 */
                final /* synthetic */ au vcq;

                {
                    this.vcq = r2;
                }

                @Override // kotlin.g.a.b
                public final /* synthetic */ kotlin.x invoke(String str) {
                    String str2;
                    AppMethodBeat.i(250316);
                    String str3 = str;
                    kotlin.g.b.p.h(str3, "nickname");
                    Log.i("Finder.FinderProfileHeaderUIC", "jumpAtProfileUIOfSignature nickname:".concat(String.valueOf(str3)));
                    com.tencent.mm.kernel.c.a af = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
                    kotlin.g.b.p.g(af, "MMKernel.service(IFinder…enModeConfig::class.java)");
                    if (!((com.tencent.mm.plugin.i.a.ad) af).dxX()) {
                        com.tencent.mm.plugin.finder.utils.d dVar = com.tencent.mm.plugin.finder.utils.d.vVg;
                        Activity context = this.vcq.vcd.getContext();
                        String username = this.vcq.tEr.getUsername();
                        kotlin.g.b.p.h(str3, "nickname");
                        if (context != null) {
                            if (com.tencent.mm.plugin.finder.utils.d.vVf.containsKey(str3)) {
                                FinderContact finderContact = com.tencent.mm.plugin.finder.utils.d.vVf.get(str3);
                                String str4 = finderContact != null ? finderContact.username : null;
                                if (Util.isNullOrNil(str4) || str4 == null) {
                                    Log.i(com.tencent.mm.plugin.finder.utils.d.TAG, "username nil");
                                    com.tencent.mm.ui.base.u.makeText(context, (int) R.string.ci1, 0).show();
                                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                                    StringBuilder append = new StringBuilder("0,2,").append(str3).append(",2,");
                                    if (username == null) {
                                        username = "";
                                    }
                                    hVar.kvStat(21172, append.append(username).toString());
                                } else {
                                    com.tencent.mm.plugin.finder.utils.d.e(str4, context);
                                    com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.INSTANCE;
                                    StringBuilder append2 = new StringBuilder("0,2,").append(str3).append(",1,");
                                    if (username == null) {
                                        str2 = "";
                                    } else {
                                        str2 = username;
                                    }
                                    hVar2.kvStat(21172, append2.append(str2).toString());
                                }
                            } else {
                                new com.tencent.mm.plugin.i.a.j(kotlin.a.j.listOf(str3)).aYI().g(new d.C1314d(str3, context, username));
                            }
                        }
                    }
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(250316);
                    return xVar;
                }
            }), intValue, intValue2, 17);
            this.vcp.append(str2 + '|');
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(250317);
            return xVar;
        }
    }

    static final class bi extends kotlin.g.b.q implements kotlin.g.a.r<Integer, Integer, String, com.tencent.mm.plugin.finder.cgi.au, kotlin.x> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bi(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(4);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.r
        public final /* synthetic */ kotlin.x invoke(Integer num, Integer num2, String str, com.tencent.mm.plugin.finder.cgi.au auVar) {
            b bVar;
            awt awt;
            apz cYf;
            AppMethodBeat.i(250334);
            num.intValue();
            num2.intValue();
            com.tencent.mm.plugin.finder.cgi.au auVar2 = auVar;
            a aVar = FinderProfileHeaderUIC.vbZ;
            b bVar2 = (b) FinderProfileHeaderUIC.userExtInfoCache.get(this.vcd.username);
            if (bVar2 == null) {
                bVar = new b();
            } else {
                bVar = bVar2;
            }
            if (auVar2 == null || (cYf = auVar2.cYf()) == null) {
                awt = null;
            } else {
                awt = cYf.live_notice_info;
            }
            bVar.vca = awt;
            a aVar2 = FinderProfileHeaderUIC.vbZ;
            FinderProfileHeaderUIC.userExtInfoCache.put(this.vcd.username, bVar);
            FinderProfileHeaderUIC.b(this.vcd, "onSceneEnd:[NetSceneCreateLiveNotice]");
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(250334);
            return xVar;
        }
    }

    public static final class bj extends kotlin.g.b.q implements kotlin.g.a.b<View, kotlin.x> {
        final /* synthetic */ com.tencent.mm.plugin.finder.api.g tEr;
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bj(FinderProfileHeaderUIC finderProfileHeaderUIC, com.tencent.mm.plugin.finder.api.g gVar) {
            super(1);
            this.vcd = finderProfileHeaderUIC;
            this.tEr = gVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(View view) {
            AppMethodBeat.i(250336);
            kotlin.g.b.p.h(view, LocaleUtil.ITALIAN);
            FinderProfileHeaderUIC.b(this.vcd, this.tEr);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(250336);
            return xVar;
        }
    }

    public static final class bk extends kotlin.g.b.q implements kotlin.g.a.b<View, kotlin.x> {
        final /* synthetic */ boolean tCn;
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bk(FinderProfileHeaderUIC finderProfileHeaderUIC, boolean z) {
            super(1);
            this.vcd = finderProfileHeaderUIC;
            this.tCn = z;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(View view) {
            String str;
            int i2 = 0;
            AppMethodBeat.i(250337);
            kotlin.g.b.p.h(view, LocaleUtil.ITALIAN);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderHomeTabFragment aN = ((FinderProfileTabUIC) com.tencent.mm.ui.component.a.b(this.vcd.getActivity()).get(FinderProfileTabUIC.class)).aN(FinderProfileFeedFragment.class);
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            FinderProfileFeedLoader.State state = ((FinderProfileFeedUIC) com.tencent.mm.ui.component.a.of(aN).get(FinderProfileFeedUIC.class)).getState();
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            String str2 = this.vcd.username;
            int aWB = cl.aWB();
            int i3 = this.tCn ? 1 : 0;
            if (state == FinderProfileFeedLoader.State.PRIVATE_LOCK) {
                i2 = 1;
            }
            com.tencent.mm.plugin.finder.report.k.c(str2, 1, aWB, i3, i2);
            com.tencent.mm.plugin.finder.model.ag agVar = com.tencent.mm.plugin.finder.model.ag.uOs;
            bbn c2 = FinderProfileHeaderUIC.c(this.vcd);
            String str3 = this.vcd.username;
            bb.a aVar3 = com.tencent.mm.plugin.finder.cgi.bb.tve;
            com.tencent.mm.plugin.finder.model.ag.a(c2, str3, com.tencent.mm.plugin.finder.cgi.bb.tvb, this.tCn);
            FinderProfileHeaderUIC.g(this.vcd);
            FinderProfileHeaderUIC.a(this.vcd, "setUnFollow");
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            c.a aVar4 = com.tencent.mm.plugin.finder.api.c.tsp;
            if (com.tencent.mm.plugin.finder.utils.y.j(c.a.asG(this.vcd.username))) {
                FinderProfileHeaderUIC.j(this.vcd);
            }
            com.tencent.mm.plugin.finder.profile.adapter.a aVar5 = this.vcd.vbP;
            View view2 = this.vcd.vbj;
            kotlin.g.b.p.g(view2, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            Context context = view2.getContext();
            com.tencent.mm.plugin.finder.api.g b2 = FinderProfileHeaderUIC.b(this.vcd);
            if (b2 != null) {
                str = b2.getNickname();
            } else {
                str = null;
            }
            aVar5.a(com.tencent.mm.pluginsdk.ui.span.l.c(context, str), FinderProfileHeaderUIC.i(this.vcd));
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(250337);
            return xVar;
        }
    }

    public static final class bl extends kotlin.g.b.q implements kotlin.g.a.b<View, kotlin.x> {
        final /* synthetic */ com.tencent.mm.plugin.finder.api.g tEr;
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bl(FinderProfileHeaderUIC finderProfileHeaderUIC, com.tencent.mm.plugin.finder.api.g gVar) {
            super(1);
            this.vcd = finderProfileHeaderUIC;
            this.tEr = gVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(View view) {
            String str;
            int i2 = 1;
            AppMethodBeat.i(250338);
            kotlin.g.b.p.h(view, LocaleUtil.ITALIAN);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderHomeTabFragment aN = ((FinderProfileTabUIC) com.tencent.mm.ui.component.a.b(this.vcd.getActivity()).get(FinderProfileTabUIC.class)).aN(FinderProfileFeedFragment.class);
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            FinderProfileFeedLoader.State state = ((FinderProfileFeedUIC) com.tencent.mm.ui.component.a.of(aN).get(FinderProfileFeedUIC.class)).getState();
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            String str2 = this.vcd.username;
            int aWB = cl.aWB();
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            int i3 = com.tencent.mm.plugin.finder.utils.y.i(this.tEr) ? 1 : 0;
            if (state != FinderProfileFeedLoader.State.PRIVATE_LOCK) {
                i2 = 0;
            }
            com.tencent.mm.plugin.finder.report.k.c(str2, 2, aWB, i3, i2);
            com.tencent.mm.plugin.finder.model.ag agVar = com.tencent.mm.plugin.finder.model.ag.uOs;
            bbn c2 = FinderProfileHeaderUIC.c(this.vcd);
            String str3 = this.vcd.username;
            bb.a aVar3 = com.tencent.mm.plugin.finder.cgi.bb.tve;
            com.tencent.mm.plugin.finder.model.ag.b(c2, str3, com.tencent.mm.plugin.finder.cgi.bb.tvd);
            FinderProfileHeaderUIC.g(this.vcd);
            FinderProfileHeaderUIC.a(this.vcd, "setWaiting");
            com.tencent.mm.plugin.finder.profile.adapter.a aVar4 = this.vcd.vbP;
            View view2 = this.vcd.vbj;
            kotlin.g.b.p.g(view2, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            Context context = view2.getContext();
            com.tencent.mm.plugin.finder.api.g b2 = FinderProfileHeaderUIC.b(this.vcd);
            if (b2 != null) {
                str = b2.getNickname();
            } else {
                str = null;
            }
            aVar4.a(com.tencent.mm.pluginsdk.ui.span.l.c(context, str), FinderProfileHeaderUIC.i(this.vcd));
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(250338);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class cb<T> implements Observer<h.a> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        cb(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(h.a aVar) {
            bdo bdo;
            String str;
            AppMethodBeat.i(261297);
            final h.a aVar2 = aVar;
            LinearLayout o = FinderProfileHeaderUIC.o(this.vcd);
            kotlin.g.b.p.g(o, "actionBarRedPackLayout");
            o.setVisibility((!FinderProfileHeaderUIC.m(this.vcd) || !FinderProfileHeaderUIC.n(this.vcd) || aVar2 == null || !aVar2.dEF) ? 8 : 0);
            TextView p = FinderProfileHeaderUIC.p(this.vcd);
            kotlin.g.b.p.g(p, "actionBarRedPackTxt");
            p.setText((aVar2 == null || (bdo = aVar2.tKS) == null || (str = bdo.title) == null) ? "" : str);
            LinearLayout o2 = FinderProfileHeaderUIC.o(this.vcd);
            kotlin.g.b.p.g(o2, "actionBarRedPackLayout");
            if (o2.getVisibility() == 0) {
                LinearLayout o3 = FinderProfileHeaderUIC.o(this.vcd);
                kotlin.g.b.p.g(o3, "actionBarRedPackLayout");
                com.tencent.mm.view.f.a(o3, new e.b(this) {
                    /* class com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC.cb.AnonymousClass1 */
                    final /* synthetic */ cb USU;

                    {
                        this.USU = r1;
                    }

                    @Override // com.tencent.mm.view.e.b
                    public final void p(View view, boolean z) {
                        AppMethodBeat.i(261293);
                        kotlin.g.b.p.h(view, "view");
                        if (z) {
                            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                            com.tencent.mm.plugin.finder.report.k.dC(1, "");
                            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                            bdo asW = ((PluginFinder) ah).getRedDotManager().asW("FinderProfileBanner");
                            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                            kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                            com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("FinderProfileBanner");
                            if (!(asX == null || asW == null)) {
                                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                                com.tencent.mm.plugin.finder.report.j.a(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, asX, asW, 1, FinderProfileHeaderUIC.c(this.USU.vcd), 0, 0, 96);
                            }
                        }
                        AppMethodBeat.o(261293);
                    }
                });
            }
            FinderProfileHeaderUIC.o(this.vcd).setOnClickListener(new View.OnClickListener(this) {
                /* class com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC.cb.AnonymousClass2 */
                final /* synthetic */ cb USU;

                {
                    this.USU = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.plugin.finder.extension.reddot.k kVar;
                    bbj bbj;
                    com.tencent.mm.bw.b bVar;
                    AppMethodBeat.i(261294);
                    com.tencent.mm.hellhoundlib.b.b bVar2 = new com.tencent.mm.hellhoundlib.b.b();
                    bVar2.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$refreshRedPack$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar2.axR());
                    h.a aVar = aVar2;
                    if (!(aVar == null || (kVar = aVar.tKT) == null || (bbj = kVar.tLm) == null || (bVar = bbj.VjF) == null)) {
                        fhn fhn = new fhn();
                        fhn.parseFrom(bVar.toByteArray());
                        String str = fhn.VjW;
                        String str2 = fhn.KDW;
                        if (!(str == null || str2 == null)) {
                            com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                            int i2 = fhn.KDY;
                            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                            com.tencent.mm.plugin.finder.utils.a.a(this.USU.vcd.getContext(), str, str2, i2, "", (Boolean) com.tencent.mm.plugin.finder.storage.c.hVg().value());
                        }
                        com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                        com.tencent.mm.plugin.finder.report.k.dC(2, "");
                        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                        kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
                        bdo asW = ((PluginFinder) ah).getRedDotManager().asW("FinderProfileBanner");
                        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                        kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
                        com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("FinderProfileBanner");
                        if (!(asX == null || asW == null)) {
                            com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                            com.tencent.mm.plugin.finder.report.j.a(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, asX, asW, 2, FinderProfileHeaderUIC.c(this.USU.vcd), 0, 0, 96);
                        }
                    }
                    com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class);
                    kotlin.g.b.p.g(ah3, "MMKernel.plugin(IPluginFinder::class.java)");
                    ((com.tencent.mm.plugin.i.a.aj) ah3).getRedDotManager().asV("ProfileEntrance");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$refreshRedPack$1$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(261294);
                }
            });
            FinderProfileHeaderUIC.q(this.vcd).setOnClickListener(AnonymousClass3.USW);
            AppMethodBeat.o(261297);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderProfileHeaderUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        kotlin.g.b.p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(250408);
        this.vbj = com.tencent.mm.ui.aa.jQ(appCompatActivity).inflate(R.layout.aj7, (ViewGroup) null);
        this.vbk = kotlin.g.ah(new ax(appCompatActivity));
        this.vbl = kotlin.g.ah(new aw(this));
        this.vbm = kotlin.g.ah(new ad(this));
        this.uuj = kotlin.g.ah(new bd(this));
        this.vbn = kotlin.g.ah(new j(this));
        this.vbo = kotlin.g.ah(new bm(this));
        this.vbp = kotlin.g.ah(new bn(this));
        this.vbq = kotlin.g.ah(new ae(this));
        this.vbr = kotlin.g.ah(new af(this));
        this.vbs = kotlin.g.ah(new u(this));
        this.vbt = kotlin.g.ah(new az(this));
        this.vbu = kotlin.g.ah(new v(this));
        this.vbv = kotlin.g.ah(new q(this));
        this.vbw = kotlin.g.ah(new r(this));
        this.vbx = kotlin.g.ah(new i(this));
        this.vby = kotlin.g.ah(new h(this));
        this.vbz = kotlin.g.ah(new g(this));
        this.vbA = kotlin.g.ah(new f(this));
        this.vbB = kotlin.g.ah(new bc(this));
        this.vbC = kotlin.g.ah(new t(this));
        this.vaa = kotlin.g.ah(new o(appCompatActivity));
        this.vbD = kotlin.g.ah(new c(appCompatActivity));
        this.uZQ = kotlin.g.ah(new e(appCompatActivity));
        this.vbE = kotlin.g.ah(new d(appCompatActivity));
        this.vbF = kotlin.g.ah(new ba(this));
        this.vbG = kotlin.g.ah(new bb(this));
        this.vbH = kotlin.g.ah(new aa(this));
        this.vbI = kotlin.g.ah(new z(this));
        this.vbJ = kotlin.g.ah(new x(this));
        this.vbK = kotlin.g.ah(new y(this));
        this.USE = kotlin.g.ah(new bx(this));
        this.USF = kotlin.g.ah(new by(this));
        this.USG = kotlin.g.ah(new bu(this));
        this.USH = kotlin.g.ah(new bs(this));
        this.USI = kotlin.g.ah(new bt(this));
        this.USJ = kotlin.g.ah(new br(this));
        this.vbL = kotlin.g.ah(new w(this));
        this.vbM = kotlin.g.ah(new ab(this));
        this.vbN = kotlin.g.ah(new ac(this));
        this.USK = kotlin.g.ah(new bv(this));
        this.USL = kotlin.g.ah(new bw(this));
        this.tZl = kotlin.g.ah(new ay(this));
        this.username = "";
        this.tYU = kotlin.g.ah(new n(appCompatActivity));
        this.vah = ((com.tencent.mm.plugin.i.a.aj) com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.i.a.aj.class)).showFinderEntry();
        View view = this.vbj;
        if (view == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(250408);
            throw tVar;
        }
        this.vbP = new com.tencent.mm.plugin.finder.profile.adapter.a((ViewGroup) view);
        this.vbR = true;
        this.vbS = CdnLogic.kMediaTypeBeatificFile;
        this.tOR = 10021;
        this.vbT = -1;
        this.vbU = -1;
        this.USM = true;
        this.USN = kotlin.g.ah(new bp(this));
        this.USO = kotlin.g.ah(new bo(this));
        this.USP = kotlin.g.ah(new bq(this));
        this.USQ = "onSceneEnd:[NetSceneFinderUserPage]";
        this.vbW = "";
        this.vbX = new p(this);
        AppMethodBeat.o(250408);
    }

    public static final /* synthetic */ void a(FinderProfileHeaderUIC finderProfileHeaderUIC, String str) {
        AppMethodBeat.i(250410);
        finderProfileHeaderUIC.auz(str);
        AppMethodBeat.o(250410);
    }

    public static final /* synthetic */ com.tencent.mm.plugin.finder.api.g b(FinderProfileHeaderUIC finderProfileHeaderUIC) {
        AppMethodBeat.i(250412);
        com.tencent.mm.plugin.finder.api.g profileContact = finderProfileHeaderUIC.getProfileContact();
        AppMethodBeat.o(250412);
        return profileContact;
    }

    public static final /* synthetic */ void b(FinderProfileHeaderUIC finderProfileHeaderUIC, String str) {
        AppMethodBeat.i(250411);
        finderProfileHeaderUIC.auw(str);
        AppMethodBeat.o(250411);
    }

    public static final /* synthetic */ bbn c(FinderProfileHeaderUIC finderProfileHeaderUIC) {
        AppMethodBeat.i(250414);
        bbn contextObj = finderProfileHeaderUIC.getContextObj();
        AppMethodBeat.o(250414);
        return contextObj;
    }

    public static final /* synthetic */ void c(FinderProfileHeaderUIC finderProfileHeaderUIC, String str) {
        AppMethodBeat.i(250413);
        finderProfileHeaderUIC.aux(str);
        AppMethodBeat.o(250413);
    }

    public static final /* synthetic */ void g(FinderProfileHeaderUIC finderProfileHeaderUIC) {
        AppMethodBeat.i(250416);
        finderProfileHeaderUIC.dnl();
        AppMethodBeat.o(250416);
    }

    public static final /* synthetic */ String i(FinderProfileHeaderUIC finderProfileHeaderUIC) {
        AppMethodBeat.i(250417);
        String dno = finderProfileHeaderUIC.dno();
        AppMethodBeat.o(250417);
        return dno;
    }

    public static final /* synthetic */ void j(FinderProfileHeaderUIC finderProfileHeaderUIC) {
        AppMethodBeat.i(250419);
        finderProfileHeaderUIC.P(false, false);
        AppMethodBeat.o(250419);
    }

    public static final /* synthetic */ TextView k(FinderProfileHeaderUIC finderProfileHeaderUIC) {
        AppMethodBeat.i(250420);
        TextView dmG = finderProfileHeaderUIC.dmG();
        AppMethodBeat.o(250420);
        return dmG;
    }

    public static final /* synthetic */ boolean m(FinderProfileHeaderUIC finderProfileHeaderUIC) {
        AppMethodBeat.i(250421);
        boolean isSelf = finderProfileHeaderUIC.isSelf();
        AppMethodBeat.o(250421);
        return isSelf;
    }

    public static final /* synthetic */ boolean n(FinderProfileHeaderUIC finderProfileHeaderUIC) {
        AppMethodBeat.i(250422);
        boolean isSelfFlag = finderProfileHeaderUIC.isSelfFlag();
        AppMethodBeat.o(250422);
        return isSelfFlag;
    }

    private final boolean isSelf() {
        AppMethodBeat.i(250374);
        boolean j2 = kotlin.g.b.p.j(this.username, com.tencent.mm.model.z.aUg());
        AppMethodBeat.o(250374);
        return j2;
    }

    private final com.tencent.mm.plugin.finder.api.g getProfileContact() {
        AppMethodBeat.i(250375);
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        com.tencent.mm.plugin.finder.api.g asG = c.a.asG(this.username);
        AppMethodBeat.o(250375);
        return asG;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(250409);
        AppMethodBeat.o(250409);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        awt awt;
        AppMethodBeat.i(250377);
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.azz().a(3736, this);
        com.tencent.mm.kernel.g.azz().a(6653, this);
        com.tencent.mm.kernel.g.azz().a(3761, this);
        ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().a(106, this.vbX);
        String stringExtra = getActivity().getIntent().getStringExtra("finder_username");
        kotlin.g.b.p.g(stringExtra, "activity.intent.getStrin…leUI.KEY_FINDER_USERNAME)");
        this.username = stringExtra;
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("KEY_FINDER_LIVE_NOTICE_INFO");
        if (byteArrayExtra != null) {
            b bVar = (b) userExtInfoCache.get(this.username);
            if (bVar == null) {
                b bVar2 = new b();
                bVar2.vca = new awt();
                awt awt2 = bVar2.vca;
                if (awt2 != null) {
                    awt2.parseFrom(byteArrayExtra);
                }
                userExtInfoCache.put(this.username, bVar2);
            } else {
                bVar.vca = new awt();
                awt awt3 = bVar.vca;
                if (awt3 != null) {
                    awt3.parseFrom(byteArrayExtra);
                }
            }
        }
        if (getIntent().hasExtra("key_extra_info")) {
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(getContext());
            if (fH != null) {
                fH.s(0, this.username);
            }
        }
        dmv().addView(this.vbj);
        FrameLayout dmw = dmw();
        kotlin.g.b.p.g(dmw, "headerBgLayout");
        ViewGroup.LayoutParams layoutParams = dmw.getLayoutParams();
        int statusBarHeight = com.tencent.mm.ui.au.getStatusBarHeight(getActivity());
        float dimension = getActivity().getResources().getDimension(R.dimen.b9);
        layoutParams.height = kotlin.h.a.cR(((float) statusBarHeight) + dimension);
        FrameLayout dmw2 = dmw();
        kotlin.g.b.p.g(dmw2, "headerBgLayout");
        dmw2.setLayoutParams(layoutParams);
        FrameLayout dmv = dmv();
        kotlin.g.b.p.g(dmv, "headerContainer");
        dmv.setMinimumHeight(kotlin.h.a.cR(((float) statusBarHeight) + dimension));
        auw("onCreate");
        this.vbQ = new bh(this);
        IListener<ik> iListener = this.vbQ;
        if (iListener != null) {
            iListener.alive();
        }
        b bVar3 = (b) userExtInfoCache.get(this.username);
        if (!(bVar3 == null || (awt = bVar3.vca) == null)) {
            this.vbU = awt.status;
        }
        TextView dmU = dmU();
        kotlin.g.b.p.g(dmU, "finderLiveTimeView");
        com.tencent.mm.ui.ao.a(dmU.getPaint(), 0.8f);
        if (com.tencent.mm.ui.ao.isDarkMode()) {
            hUv().setBackgroundResource(R.drawable.cux);
        } else {
            hUv().setBackgroundResource(R.drawable.a1b);
        }
        View view = this.vbj;
        kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.gjf);
        kotlin.g.b.p.g(frameLayout, "header.profile_loading_state_container");
        frameLayout.setVisibility(8);
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        ((FinderLivePostBtnUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderLivePostBtnUIC.class)).wyn = new bi(this);
        if (isSelf() && isSelfFlag()) {
            com.tencent.mm.kernel.g.azz().b(new cd(8));
        }
        TextView hUy = hUy();
        kotlin.g.b.p.g(hUy, "campaignNameTv");
        com.tencent.mm.ui.ao.a(hUy.getPaint(), 0.8f);
        hUx().setOnClickListener(new ca(this));
        com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h hVar2 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.hSI(), getActivity(), new cb(this));
        AppMethodBeat.o(250377);
    }

    public static final class bh extends IListener<ik> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        bh(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ik ikVar) {
            ik.a aVar;
            AppMethodBeat.i(250333);
            ik ikVar2 = ikVar;
            if (kotlin.g.b.p.j((ikVar2 == null || (aVar = ikVar2.dNb) == null) ? null : aVar.dNc, this.vcd.username)) {
                com.tencent.mm.ac.d.h(new a(this));
            }
            AppMethodBeat.o(250333);
            return false;
        }

        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
            final /* synthetic */ bh vct;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(bh bhVar) {
                super(0);
                this.vct = bhVar;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ kotlin.x invoke() {
                AppMethodBeat.i(250332);
                FinderProfileHeaderUIC.a(this.vct.vcd, "onEvent");
                kotlin.x xVar = kotlin.x.SXb;
                AppMethodBeat.o(250332);
                return xVar;
            }
        }
    }

    static final class ca implements View.OnClickListener {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        ca(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            this.vcd = finderProfileHeaderUIC;
        }

        public final void onClick(View view) {
            aqk aqk;
            AppMethodBeat.i(261292);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$initActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            a aVar = FinderProfileHeaderUIC.vbZ;
            b bVar2 = (b) FinderProfileHeaderUIC.userExtInfoCache.get(this.vcd.username);
            if (bVar2 != null) {
                aqk = bVar2.tqo;
            } else {
                aqk = null;
            }
            if (aqk != null) {
                Intent intent = new Intent();
                intent.putExtra("key_activity_id", aqk.twd);
                intent.putExtra("key_activity_name", aqk.eventName);
                Log.i("Finder.FinderProfileHeaderUIC", "eventTopicId :" + aqk.twd + " eventName:" + aqk.eventName);
                com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.aa(this.vcd.getActivity(), intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$initActivity$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261292);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStart() {
        AppMethodBeat.i(250378);
        super.onStart();
        if (!this.vbR) {
            com.tencent.mm.ak.t azz = com.tencent.mm.kernel.g.azz();
            cn cnVar = new cn(this.username, 0, null, 0, getContextObj(), 0, 0, 110);
            cnVar.twC = true;
            azz.b(cnVar);
        }
        this.vbR = false;
        AppMethodBeat.o(250378);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(250379);
        super.onResume();
        RelativeLayout dmT = dmT();
        kotlin.g.b.p.g(dmT, "finderLiveView");
        if (dmT.getVisibility() == 0) {
            com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
            com.tencent.mm.plugin.finder.report.live.m.a(s.az.ExposeProfile, this.username, 0, s.j.COMMENT_SCENE_PROFILE_PAGE.scene);
        }
        com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.bxB("FinderProfileBanner");
        bxU("onResume");
        AppMethodBeat.o(250379);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(250380);
        super.onDestroy();
        IListener<ik> iListener = this.vbQ;
        if (iListener != null) {
            iListener.dead();
        }
        ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFinderSyncExtension().b(106, this.vbX);
        com.tencent.mm.kernel.g.azz().b(3736, this);
        com.tencent.mm.kernel.g.azz().b(6653, this);
        com.tencent.mm.kernel.g.azz().b(3761, this);
        AppMethodBeat.o(250380);
    }

    private final void auw(String str) {
        String str2;
        String str3 = null;
        AppMethodBeat.i(250381);
        long uptimeMillis = SystemClock.uptimeMillis();
        dnk();
        dnm();
        dnn();
        dnl();
        auz(str);
        dnf();
        dnc();
        dne();
        dnd();
        auy(str);
        aux(str);
        dnb();
        dna();
        bxT(str);
        bxU(str);
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
        x(com.tencent.mm.plugin.finder.utils.y.j(c.a.asG(this.username)), str);
        com.tencent.mm.plugin.finder.profile.adapter.a aVar2 = this.vbP;
        View view = this.vbj;
        kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        Context context = view.getContext();
        com.tencent.mm.plugin.finder.api.g profileContact = getProfileContact();
        if (profileContact != null) {
            str2 = profileContact.getNickname();
        } else {
            str2 = null;
        }
        aVar2.a(com.tencent.mm.pluginsdk.ui.span.l.c(context, str2), dno(), kotlin.g.b.p.j("onCreate", str));
        StringBuilder sb = new StringBuilder("[refreshProfile] nickname:");
        com.tencent.mm.plugin.finder.api.g profileContact2 = getProfileContact();
        if (profileContact2 != null) {
            str3 = profileContact2.getNickname();
        }
        Log.i("Finder.FinderProfileHeaderUIC", sb.append(str3).append(" COST=").append(SystemClock.uptimeMillis() - uptimeMillis).append("ms source=").append(str).toString());
        AppMethodBeat.o(250381);
    }

    private final void bxT(String str) {
        boolean z2;
        boolean z3;
        String str2;
        aoy aoy;
        LinkedList<fhi> linkedList = null;
        AppMethodBeat.i(261306);
        Log.i("Finder.FinderProfileHeaderUIC", "[handleMIniProgramList] source:".concat(String.valueOf(str)));
        b bVar = (b) userExtInfoCache.get(this.username);
        LinkedList<fhi> linkedList2 = (bVar == null || (aoy = bVar.vcc) == null) ? null : aoy.Vir;
        LinearLayout hUB = hUB();
        kotlin.g.b.p.g(hUB, "finderMiniProgramListLayout");
        hUB.setVisibility(8);
        LinkedList<fhi> linkedList3 = linkedList2;
        if (linkedList3 == null || linkedList3.isEmpty()) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            linkedList = linkedList2;
        }
        if (linkedList != null) {
            if (kotlin.g.b.p.j(this.USQ, str)) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                String str3 = this.username;
                if (str3 == null) {
                    str2 = "";
                } else {
                    str2 = str3;
                }
                String str4 = linkedList.get(0).app_id;
                if (str4 == null) {
                    str4 = "";
                }
                com.tencent.mm.plugin.finder.report.k.j(5, str2, "", str4);
            }
            TextView hUC = hUC();
            kotlin.g.b.p.g(hUC, "finderMiniProgramName");
            hUC.setText(getActivity().getResources().getString(R.string.jcx, linkedList.get(0).qFU));
            hUB().setOnClickListener(new bz(linkedList, this, str));
            LinearLayout hUB2 = hUB();
            kotlin.g.b.p.g(hUB2, "finderMiniProgramListLayout");
            hUB2.setVisibility(0);
            AppMethodBeat.o(261306);
            return;
        }
        LinearLayout hUB3 = hUB();
        kotlin.g.b.p.g(hUB3, "finderMiniProgramListLayout");
        hUB3.setVisibility(8);
        AppMethodBeat.o(261306);
    }

    public static final class bz implements View.OnClickListener {
        final /* synthetic */ String UST;
        final /* synthetic */ LinkedList uVW;
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        bz(LinkedList linkedList, FinderProfileHeaderUIC finderProfileHeaderUIC, String str) {
            this.uVW = linkedList;
            this.vcd = finderProfileHeaderUIC;
            this.UST = str;
        }

        public final void onClick(View view) {
            String str;
            String str2;
            AppMethodBeat.i(261291);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleMIniProgramList$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            String str3 = this.vcd.username;
            if (str3 == null) {
                str = "";
            } else {
                str = str3;
            }
            String str4 = ((fhi) this.uVW.get(0)).app_id;
            if (str4 == null) {
                str4 = "";
            }
            com.tencent.mm.plugin.finder.report.k.j(6, str, "", str4);
            String str5 = ((fhi) this.uVW.get(0)).app_id;
            String str6 = ((fhi) this.uVW.get(0)).path;
            if (!(str5 == null || str6 == null)) {
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                AppCompatActivity activity = this.vcd.getActivity();
                com.tencent.mm.plugin.finder.api.g b2 = FinderProfileHeaderUIC.b(this.vcd);
                if (b2 == null || (str2 = b2.getUsername()) == null) {
                    str2 = "";
                }
                com.tencent.mm.plugin.finder.utils.a.a(activity, str5, str6, 1193, str2);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleMIniProgramList$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(261291);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x013f, code lost:
        if (r1 == null) goto L_0x0141;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void bxU(java.lang.String r12) {
        /*
        // Method dump skipped, instructions count: 441
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC.bxU(java.lang.String):void");
    }

    private final void dna() {
        LinkedList<or> linkedList;
        boolean z2;
        boolean z3;
        LinkedList<or> linkedList2;
        or orVar;
        AppMethodBeat.i(250382);
        b bVar = (b) userExtInfoCache.get(this.username);
        if (bVar == null) {
            bVar = new b();
        }
        aoy aoy = bVar.vcc;
        if (!(aoy == null || (linkedList = aoy.LAZ) == null)) {
            if (!(!linkedList.isEmpty())) {
                linkedList = null;
            }
            if (linkedList != null) {
                String str = linkedList.get(0).KUC;
                if (str == null || str.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (z3) {
                    linkedList2 = linkedList;
                } else {
                    linkedList2 = null;
                }
                if (!(linkedList2 == null || (orVar = linkedList2.get(0)) == null)) {
                    RelativeLayout dmY = dmY();
                    kotlin.g.b.p.g(dmY, "finderMediaEntrance");
                    com.tencent.mm.view.f.a(dmY, new an(orVar, this));
                    RelativeLayout dmY2 = dmY();
                    kotlin.g.b.p.g(dmY2, "finderMediaEntrance");
                    dmY2.setVisibility(0);
                    TextView dmZ = dmZ();
                    kotlin.g.b.p.g(dmZ, "finderMediaName");
                    dmZ.setText(getActivity().getResources().getString(R.string.d6f, orVar.KUD));
                    dmY().setOnClickListener(new ao(orVar, this));
                    AppMethodBeat.o(250382);
                    return;
                }
            }
        }
        RelativeLayout dmY3 = dmY();
        kotlin.g.b.p.g(dmY3, "finderMediaEntrance");
        dmY3.setVisibility(8);
        AppMethodBeat.o(250382);
    }

    public static final class an extends e.b {
        final /* synthetic */ FinderProfileHeaderUIC vcd;
        final /* synthetic */ or vcj;

        an(or orVar, FinderProfileHeaderUIC finderProfileHeaderUIC) {
            this.vcj = orVar;
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // com.tencent.mm.view.e.b
        public final void p(View view, boolean z) {
            String str;
            AppMethodBeat.i(250309);
            kotlin.g.b.p.h(view, "view");
            if (z) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.api.g b2 = FinderProfileHeaderUIC.b(this.vcd);
                if (b2 == null || (str = b2.getUsername()) == null) {
                    str = "";
                }
                String str2 = this.vcj.KUC;
                if (str2 == null) {
                    str2 = "";
                }
                com.tencent.mm.plugin.finder.report.k.T(3, str, str2);
            }
            AppMethodBeat.o(250309);
        }
    }

    public static final class ao implements View.OnClickListener {
        final /* synthetic */ FinderProfileHeaderUIC vcd;
        final /* synthetic */ or vcj;

        ao(or orVar, FinderProfileHeaderUIC finderProfileHeaderUIC) {
            this.vcj = orVar;
            this.vcd = finderProfileHeaderUIC;
        }

        public final void onClick(View view) {
            String str;
            AppMethodBeat.i(250310);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleMeadiaEntrance$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.api.g b2 = FinderProfileHeaderUIC.b(this.vcd);
            if (b2 == null || (str = b2.getUsername()) == null) {
                str = "";
            }
            String str2 = this.vcj.KUC;
            if (str2 == null) {
                str2 = "";
            }
            com.tencent.mm.plugin.finder.report.k.T(4, str, str2);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", this.vcj.KUC);
            intent.putExtra("Contact_Scene", 183);
            intent.putExtra("force_get_contact", true);
            intent.putExtra("key_use_new_contact_profile", true);
            com.tencent.mm.br.c.b(this.vcd.getActivity(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleMeadiaEntrance$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250310);
        }
    }

    private final void aux(String str) {
        awt awt;
        boolean z2;
        AppMethodBeat.i(250383);
        Log.i("Finder.FinderProfileHeaderUIC", "[handleFinderLiveNoticeInfo] source:".concat(String.valueOf(str)));
        if (!kotlin.g.b.p.j(str, "onSceneEnd:[NetSceneFinderUserPage]") || this.USM) {
            b bVar = (b) userExtInfoCache.get(this.username);
            if (bVar != null) {
                awt = bVar.vca;
            } else {
                awt = null;
            }
            if (awt != null) {
                String str2 = awt.dDJ;
                if (str2 == null || str2.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    RelativeLayout dmT = dmT();
                    kotlin.g.b.p.g(dmT, "finderLiveView");
                    dmT.setVisibility(0);
                    LinearLayout hUv = hUv();
                    kotlin.g.b.p.g(hUv, "finderNoticeActivityLayout");
                    hUv.setVisibility(0);
                    View hUw = hUw();
                    kotlin.g.b.p.g(hUw, "finderNoticeActivityLine");
                    RelativeLayout dmT2 = dmT();
                    kotlin.g.b.p.g(dmT2, "finderLiveView");
                    hUw.setVisibility(dmT2.getVisibility());
                    TextView dmU = dmU();
                    kotlin.g.b.p.g(dmU, "finderLiveTimeView");
                    Resources resources = getContext().getResources();
                    com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
                    dmU.setText(resources.getString(R.string.ckv, com.tencent.mm.plugin.finder.utils.y.Gi(((long) awt.dvv) * 1000)));
                    if (!isSelf() || !isSelfFlag()) {
                        TextView dmW = dmW();
                        kotlin.g.b.p.g(dmW, "finderLiveCount");
                        dmW.setVisibility(8);
                        if (awt.status == 1) {
                            TextView dmV = dmV();
                            kotlin.g.b.p.g(dmV, "finderLiveBookBtn");
                            dmV.setText(getContext().getResources().getString(R.string.ckq));
                        } else {
                            TextView dmV2 = dmV();
                            kotlin.g.b.p.g(dmV2, "finderLiveBookBtn");
                            dmV2.setText(getContext().getResources().getString(R.string.ckr));
                        }
                        dmV().setOnClickListener(new am(this, awt));
                        AppMethodBeat.o(250383);
                        return;
                    }
                    TextView dmW2 = dmW();
                    kotlin.g.b.p.g(dmW2, "finderLiveCount");
                    dmW2.setVisibility(0);
                    TextView dmW3 = dmW();
                    kotlin.g.b.p.g(dmW3, "finderLiveCount");
                    Resources resources2 = getContext().getResources();
                    com.tencent.mm.plugin.finder.utils.y yVar2 = com.tencent.mm.plugin.finder.utils.y.vXH;
                    dmW3.setText(resources2.getString(R.string.ckt, com.tencent.mm.plugin.finder.utils.y.LT(awt.LHw)));
                    TextView dmV3 = dmV();
                    kotlin.g.b.p.g(dmV3, "finderLiveBookBtn");
                    dmV3.setText(getContext().getResources().getString(R.string.cks));
                    dmV().setOnClickListener(new al(this, awt));
                    AppMethodBeat.o(250383);
                    return;
                }
            }
            RelativeLayout dmT3 = dmT();
            kotlin.g.b.p.g(dmT3, "finderLiveView");
            dmT3.setVisibility(8);
            AppMethodBeat.o(250383);
            return;
        }
        AppMethodBeat.o(250383);
    }

    public static final class al implements View.OnClickListener {
        final /* synthetic */ FinderProfileHeaderUIC vcd;
        final /* synthetic */ awt vch;

        al(FinderProfileHeaderUIC finderProfileHeaderUIC, awt awt) {
            this.vcd = finderProfileHeaderUIC;
            this.vch = awt;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250307);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleFinderLiveNoticeInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) this.vcd.getContext(), 1, true);
            eVar.setTitleView(com.tencent.mm.ui.aa.jQ(this.vcd.getContext()).inflate(R.layout.af2, (ViewGroup) null));
            eVar.a(new o.f(this) {
                /* class com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC.al.AnonymousClass1 */
                final /* synthetic */ al vci;

                {
                    this.vci = r1;
                }

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
                    AppMethodBeat.i(250305);
                    kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
                    if (mVar.gKQ()) {
                        a aVar = FinderProfileHeaderUIC.vbZ;
                        mVar.a(FinderProfileHeaderUIC.vbY, this.vci.vcd.getResources().getColor(R.color.Red), this.vci.vcd.getResources().getString(R.string.cxu));
                    }
                    AppMethodBeat.o(250305);
                }
            });
            eVar.a(new o.g(this) {
                /* class com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC.al.AnonymousClass2 */
                final /* synthetic */ al vci;

                {
                    this.vci = r1;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    awt awt;
                    AppMethodBeat.i(250306);
                    kotlin.g.b.p.g(menuItem, "menuItem");
                    int itemId = menuItem.getItemId();
                    a aVar = FinderProfileHeaderUIC.vbZ;
                    if (itemId != FinderProfileHeaderUIC.vbY || (awt = this.vci.vch) == null) {
                        AppMethodBeat.o(250306);
                        return;
                    }
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    kotlin.g.b.p.h(awt, "liveNoticeInfo");
                    String aUg = com.tencent.mm.model.z.aUg();
                    kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                    FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(((FinderLivePostBtnUIC) com.tencent.mm.ui.component.a.b(this.vci.vcd.getActivity()).get(FinderLivePostBtnUIC.class)).getActivity());
                    com.tencent.mm.kernel.g.azz().b(new com.tencent.mm.plugin.finder.cgi.au(aUg, awt, 1, fH != null ? fH.dIx() : null));
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.a(s.ab.LIVE_CANCEL_BOOK, "");
                    AppMethodBeat.o(250306);
                }
            });
            eVar.dGm();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleFinderLiveNoticeInfo$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250307);
        }
    }

    public static final class am implements View.OnClickListener {
        final /* synthetic */ FinderProfileHeaderUIC vcd;
        final /* synthetic */ awt vch;

        am(FinderProfileHeaderUIC finderProfileHeaderUIC, awt awt) {
            this.vcd = finderProfileHeaderUIC;
            this.vch = awt;
        }

        public final void onClick(View view) {
            int i2;
            AppMethodBeat.i(250308);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleFinderLiveNoticeInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (this.vch.status == 1) {
                this.vch.status = 0;
                com.tencent.mm.plugin.forcenotify.f.a aVar = com.tencent.mm.plugin.forcenotify.f.a.UWN;
                com.tencent.mm.plugin.forcenotify.f.a.a(this.vcd.getContext(), 2, new a(this));
                com.tencent.mm.plugin.finder.report.live.m mVar = com.tencent.mm.plugin.finder.report.live.m.vli;
                com.tencent.mm.plugin.finder.report.live.m.a(s.az.Book, this.vcd.username, 0, s.j.COMMENT_SCENE_PROFILE_PAGE.scene);
                i2 = 1;
            } else {
                this.vch.status = 1;
                com.tencent.mm.plugin.finder.report.live.m mVar2 = com.tencent.mm.plugin.finder.report.live.m.vli;
                com.tencent.mm.plugin.finder.report.live.m.a(s.az.Cancle, this.vcd.username, 0, s.j.COMMENT_SCENE_PROFILE_PAGE.scene);
                i2 = 2;
            }
            this.vcd.vbT = this.vch.status;
            String str = this.vcd.username;
            String str2 = this.vch.dDJ;
            if (str2 == null) {
                kotlin.g.b.p.hyc();
            }
            kotlin.g.b.p.g(str2, "liveNoticeInfo.noticeId!!");
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.kernel.g.azz().b(new com.tencent.mm.plugin.finder.cgi.ar(str, str2, i2, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.vcd.getActivity()).get(FinderReporterUIC.class)).dIx()));
            com.tencent.mm.plugin.finder.feed.model.e eVar = com.tencent.mm.plugin.finder.feed.model.e.tUY;
            awt ato = com.tencent.mm.plugin.finder.feed.model.e.ato(this.vcd.username);
            if (ato != null) {
                ato.status = this.vch.status;
            }
            FinderProfileHeaderUIC.c(this.vcd, "handleFinderLiveNoticeInfo");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleFinderLiveNoticeInfo$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250308);
        }

        public static final class a implements a.AbstractC1365a {
            final /* synthetic */ am USS;

            a(am amVar) {
                this.USS = amVar;
            }

            @Override // com.tencent.mm.plugin.forcenotify.f.a.AbstractC1365a
            public final void dQ(boolean z) {
                AppMethodBeat.i(261290);
                if (z) {
                    FinderProfileHeaderUIC.r(this.USS.vcd);
                }
                AppMethodBeat.o(261290);
            }
        }
    }

    private final void dnb() {
        CharSequence charSequence = null;
        AppMethodBeat.i(250384);
        b bVar = (b) userExtInfoCache.get(this.username);
        if (bVar == null) {
            bVar = new b();
        }
        bel bel = bVar.vcb;
        z.f fVar = new z.f();
        fVar.SYG = "";
        z.f fVar2 = new z.f();
        fVar2.SYG = "";
        Log.i("Finder.FinderProfileHeaderUIC", "[handleShopEntrance] anchor's shopAppInfo.appId:" + (bel != null ? bel.appId : null) + ",shopAppInfo.appUrl:" + (bel != null ? bel.LOg : null));
        if (bel == null || Util.isNullOrNil(bel.appId)) {
            RelativeLayout dmR = dmR();
            kotlin.g.b.p.g(dmR, "myMiniShopEntrance");
            dmR.setVisibility(8);
        } else {
            RelativeLayout dmR2 = dmR();
            kotlin.g.b.p.g(dmR2, "myMiniShopEntrance");
            dmR2.setVisibility(0);
            T t2 = (T) bel.appId;
            if (t2 == null) {
                t2 = (T) "";
            }
            fVar.SYG = t2;
            T t3 = (T) bel.LOg;
            if (t3 == null) {
                t3 = (T) "";
            }
            fVar2.SYG = t3;
            if (isSelf() && isSelfFlag() && Util.isNullOrNil((String) fVar.SYG)) {
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                Object obj = aAh.azQ().get(ar.a.USERINFO_MY_FINDER_SHOP_APPID_STRING_SYNC, "");
                if (obj == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(250384);
                    throw tVar;
                }
                fVar.SYG = (T) ((String) obj);
                com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
                Object obj2 = aAh2.azQ().get(ar.a.USERINFO_MY_FINDER_SHOP_PATH_STRING_SYNC, "");
                if (obj2 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(250384);
                    throw tVar2;
                }
                fVar2.SYG = (T) ((String) obj2);
            }
            dmR().setOnClickListener(new as(this, fVar, fVar2));
        }
        StringBuilder append = new StringBuilder("handleShopEntrance shop appId:").append((String) fVar.SYG).append(",path:").append((String) fVar2.SYG).append(",isSelf:").append(isSelf()).append(",isSelfFlag:").append(isSelfFlag()).append(",shop txt:");
        TextView dmS = dmS();
        if (dmS != null) {
            charSequence = dmS.getText();
        }
        Log.i("Finder.FinderProfileHeaderUIC", append.append(charSequence).toString());
        AppMethodBeat.o(250384);
    }

    public static final class as implements View.OnClickListener {
        final /* synthetic */ FinderProfileHeaderUIC vcd;
        final /* synthetic */ z.f vck;
        final /* synthetic */ z.f vcl;

        as(FinderProfileHeaderUIC finderProfileHeaderUIC, z.f fVar, z.f fVar2) {
            this.vcd = finderProfileHeaderUIC;
            this.vck = fVar;
            this.vcl = fVar2;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250314);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleShopEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(1, this.vck.SYG, Util.getUuidRandom().toString(), 1175, String.valueOf(SystemClock.elapsedRealtimeNanos()), "", "");
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.a(this.vcd.getContext(), this.vck.SYG, this.vcl.SYG, 1175, this.vcd.username + ':' + Util.getUuidRandom());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleShopEntrance$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250314);
        }
    }

    private final void dnc() {
        AppMethodBeat.i(250385);
        b bVar = (b) userExtInfoCache.get(this.username);
        if (bVar == null) {
            bVar = new b();
        }
        if (bVar.fansCount > 0 && hUD()) {
            LinearLayout dmE = dmE();
            kotlin.g.b.p.g(dmE, "labelLayout");
            dmE.setVisibility(0);
            AppMethodBeat.o(250385);
        } else if ((!isSelf() || !isSelfFlag()) && bVar.friendFollowCount > 0 && this.vah) {
            LinearLayout dmE2 = dmE();
            kotlin.g.b.p.g(dmE2, "labelLayout");
            dmE2.setVisibility(0);
            AppMethodBeat.o(250385);
        } else {
            LinearLayout dmE3 = dmE();
            kotlin.g.b.p.g(dmE3, "labelLayout");
            dmE3.setVisibility(8);
            AppMethodBeat.o(250385);
        }
    }

    private final void auy(String str) {
        AppMethodBeat.i(250386);
        if (!isSelf() && !isSelfFlag()) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (com.tencent.mm.plugin.finder.storage.c.dtG().value().intValue() > 0 && this.vah) {
                View view = this.vbj;
                kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
                FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.hju);
                kotlin.g.b.p.g(frameLayout, "header.sendMsgBtn");
                frameLayout.setVisibility(0);
                View view2 = this.vbj;
                kotlin.g.b.p.g(view2, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
                TextView textView = (TextView) view2.findViewById(R.id.d2r);
                kotlin.g.b.p.g(textView, "chatText");
                com.tencent.mm.ui.ao.a(textView.getPaint(), 0.8f);
                if (kotlin.g.b.p.j(str, "onCreate")) {
                    View view3 = this.vbj;
                    kotlin.g.b.p.g(view3, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
                    FrameLayout frameLayout2 = (FrameLayout) view3.findViewById(R.id.hju);
                    kotlin.g.b.p.g(frameLayout2, "header.sendMsgBtn");
                    com.tencent.mm.view.f.a(frameLayout2, new ap(this));
                }
                View view4 = this.vbj;
                kotlin.g.b.p.g(view4, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
                ((FrameLayout) view4.findViewById(R.id.hju)).setOnClickListener(new aq(this));
                AppMethodBeat.o(250386);
                return;
            }
        }
        View view5 = this.vbj;
        kotlin.g.b.p.g(view5, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        FrameLayout frameLayout3 = (FrameLayout) view5.findViewById(R.id.hju);
        kotlin.g.b.p.g(frameLayout3, "header.sendMsgBtn");
        frameLayout3.setVisibility(8);
        AppMethodBeat.o(250386);
    }

    public static final class ap extends e.b {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        ap(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // com.tencent.mm.view.e.b
        public final void p(View view, boolean z) {
            AppMethodBeat.i(250311);
            kotlin.g.b.p.h(view, "view");
            if (z) {
                com.tencent.mm.plugin.finder.report.d dVar = com.tencent.mm.plugin.finder.report.d.vdp;
                d.b dnK = com.tencent.mm.plugin.finder.report.d.dnK();
                String aUg = com.tencent.mm.model.z.aUg();
                kotlin.g.b.p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                dnK.ah(aUg, "", this.vcd.username);
                com.tencent.mm.plugin.finder.report.d dVar2 = com.tencent.mm.plugin.finder.report.d.vdp;
                com.tencent.mm.plugin.finder.report.d.dnK().a(FinderProfileHeaderUIC.c(this.vcd), 3);
                View view2 = this.vcd.vbj;
                kotlin.g.b.p.g(view2, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
                FrameLayout frameLayout = (FrameLayout) view2.findViewById(R.id.hju);
                kotlin.g.b.p.g(frameLayout, "header.sendMsgBtn");
                com.tencent.mm.view.f.a(frameLayout, (e.b) null);
            }
            AppMethodBeat.o(250311);
        }
    }

    public static final class aq implements View.OnClickListener {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        aq(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            this.vcd = finderProfileHeaderUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250312);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleMessageBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            Activity context = this.vcd.getContext();
            com.tencent.mm.plugin.finder.api.g b2 = FinderProfileHeaderUIC.b(this.vcd);
            if (!com.tencent.mm.plugin.finder.utils.y.af(context, b2 != null ? b2.field_extFlag : 0)) {
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                com.tencent.mm.plugin.finder.utils.a.aD(this.vcd.getContext(), this.vcd.username);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleMessageBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250312);
        }
    }

    private final void dnd() {
        AppMethodBeat.i(250387);
        if (!isSelf() || !isSelfFlag()) {
            RelativeLayout dmN = dmN();
            kotlin.g.b.p.g(dmN, "editLayout");
            dmN.setVisibility(8);
            AppMethodBeat.o(250387);
            return;
        }
        com.tencent.mm.plugin.finder.extension.reddot.h hVar = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h hVar2 = com.tencent.mm.plugin.finder.extension.reddot.h.tKR;
        com.tencent.mm.plugin.finder.extension.reddot.h.a(com.tencent.mm.plugin.finder.extension.reddot.h.daP(), getActivity(), new ai(this));
        RelativeLayout dmN2 = dmN();
        kotlin.g.b.p.g(dmN2, "editLayout");
        dmN2.setVisibility(0);
        dmN().setOnClickListener(new aj(this));
        AppMethodBeat.o(250387);
    }

    public static final class aj implements View.OnClickListener {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        aj(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            this.vcd = finderProfileHeaderUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250303);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleEditBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.ft(this.vcd.getActivity());
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            bdo asW = ((PluginFinder) ah).getRedDotManager().asW("FinderSetting");
            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("FinderSetting");
            if (!(asX == null || asW == null)) {
                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                com.tencent.mm.plugin.finder.report.j.a(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, asX, asW, 2, FinderProfileHeaderUIC.c(this.vcd), 0, 0, 96);
            }
            com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
            ((PluginFinder) ah3).getRedDotManager().asV("FinderSetting");
            com.tencent.mm.kernel.b.a ah4 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah4, "MMKernel.plugin(PluginFinder::class.java)");
            ((PluginFinder) ah4).getRedDotManager().e("ProfileEntrance", new int[]{1000});
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleEditBtn$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250303);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private final void dne() {
        FinderAuthInfo finderAuthInfo;
        AppMethodBeat.i(250388);
        LinearLayout dmI = dmI();
        kotlin.g.b.p.g(dmI, "authLayout");
        dmI.setVisibility(8);
        com.tencent.mm.plugin.finder.api.g profileContact = getProfileContact();
        if (profileContact == null || (finderAuthInfo = profileContact.field_authInfo) == null) {
            Log.w("Finder.FinderProfileHeaderUIC", "[handleAuthGenerator] profileContact=" + (getProfileContact() != null));
            AppMethodBeat.o(250388);
        } else if (finderAuthInfo.authIconType <= 0) {
            Log.w("Finder.FinderProfileHeaderUIC", "[handleAuthGenerator] authIconType<=0");
            AppMethodBeat.o(250388);
        } else {
            dmJ().setOnClickListener(new ag(this, finderAuthInfo));
            dmK().setOnClickListener(new ah(this, finderAuthInfo));
            WeImageView dmL = dmL();
            kotlin.g.b.p.g(dmL, "authArrowIv");
            dmL.setVisibility(4);
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            View view = this.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            ImageView imageView = (ImageView) view.findViewById(R.id.d1o);
            kotlin.g.b.p.g(imageView, "header.finder_profile_auth_icon");
            com.tencent.mm.plugin.finder.utils.y.a(imageView, finderAuthInfo);
            switch (finderAuthInfo.authIconType) {
                case 1:
                    String str = finderAuthInfo.authProfession;
                    if (str != null) {
                        TextView dmK = dmK();
                        kotlin.g.b.p.g(dmK, "authByTv");
                        dmK.setVisibility(0);
                        TextView dmK2 = dmK();
                        kotlin.g.b.p.g(dmK2, "authByTv");
                        dmK2.setText(getResources().getString(R.string.cjs, str));
                        dmK().setOnClickListener(null);
                    }
                    LinearLayout dmI2 = dmI();
                    kotlin.g.b.p.g(dmI2, "authLayout");
                    dmI2.setVisibility(0);
                    AppMethodBeat.o(250388);
                    return;
                case 2:
                    TextView dmJ = dmJ();
                    kotlin.g.b.p.g(dmJ, "authGeneratorTv");
                    dmJ.setVisibility(8);
                    LinearLayout dmI3 = dmI();
                    kotlin.g.b.p.g(dmI3, "authLayout");
                    dmI3.setVisibility(0);
                    WeImageView dmL2 = dmL();
                    kotlin.g.b.p.g(dmL2, "authArrowIv");
                    dmL2.setVisibility(0);
                    String str2 = finderAuthInfo.authProfession;
                    if (str2 != null) {
                        TextView dmK3 = dmK();
                        kotlin.g.b.p.g(dmK3, "authByTv");
                        dmK3.setVisibility(0);
                        TextView dmK4 = dmK();
                        kotlin.g.b.p.g(dmK4, "authByTv");
                        dmK4.setText(getResources().getString(R.string.cjs, str2));
                        AppMethodBeat.o(250388);
                        return;
                    }
                    AppMethodBeat.o(250388);
                    return;
                case 100:
                    LinearLayout dmI4 = dmI();
                    kotlin.g.b.p.g(dmI4, "authLayout");
                    dmI4.setVisibility(0);
                    TextView dmJ2 = dmJ();
                    kotlin.g.b.p.g(dmJ2, "authGeneratorTv");
                    dmJ2.setVisibility(8);
                    WeImageView dmL3 = dmL();
                    kotlin.g.b.p.g(dmL3, "authArrowIv");
                    dmL3.setVisibility(8);
                    dmK().setOnClickListener(null);
                    dmK().setText(R.string.cp9);
                    break;
            }
            AppMethodBeat.o(250388);
        }
    }

    public static final class ag implements View.OnClickListener {
        final /* synthetic */ FinderProfileHeaderUIC vcd;
        final /* synthetic */ FinderAuthInfo vcg;

        ag(FinderProfileHeaderUIC finderProfileHeaderUIC, FinderAuthInfo finderAuthInfo) {
            this.vcd = finderProfileHeaderUIC;
            this.vcg = finderAuthInfo;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250300);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleAuthGenerator$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!Util.isNullOrNil(this.vcg.appName) && !Util.isNullOrNil(this.vcg.detailLink)) {
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                AppCompatActivity activity = this.vcd.getActivity();
                String str = this.vcg.appName;
                if (str == null) {
                    str = "";
                }
                String str2 = this.vcg.detailLink;
                if (str2 == null) {
                    str2 = "";
                }
                com.tencent.mm.plugin.finder.utils.a.y(activity, str, str2);
            } else if (!Util.isNullOrNil(this.vcg.detailLink)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.vcg.detailLink);
                com.tencent.mm.br.c.b(this.vcd.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleAuthGenerator$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250300);
        }
    }

    public static final class ah implements View.OnClickListener {
        final /* synthetic */ FinderProfileHeaderUIC vcd;
        final /* synthetic */ FinderAuthInfo vcg;

        ah(FinderProfileHeaderUIC finderProfileHeaderUIC, FinderAuthInfo finderAuthInfo) {
            this.vcd = finderProfileHeaderUIC;
            this.vcg = finderAuthInfo;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250301);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleAuthGenerator$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!Util.isNullOrNil(this.vcg.appName) && !Util.isNullOrNil(this.vcg.detailLink)) {
                com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
                AppCompatActivity activity = this.vcd.getActivity();
                String str = this.vcg.appName;
                if (str == null) {
                    str = "";
                }
                String str2 = this.vcg.detailLink;
                if (str2 == null) {
                    str2 = "";
                }
                com.tencent.mm.plugin.finder.utils.a.y(activity, str, str2);
            } else if (!Util.isNullOrNil(this.vcg.detailLink)) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.vcg.detailLink);
                com.tencent.mm.br.c.b(this.vcd.getContext(), "webview", ".ui.tools.WebViewUI", intent);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleAuthGenerator$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250301);
        }
    }

    private final void dnf() {
        AppMethodBeat.i(250389);
        if (!isSelf() || !isSelfFlag()) {
            b bVar = (b) userExtInfoCache.get(this.username);
            if (bVar == null) {
                bVar = new b();
            }
            if (bVar.friendFollowCount > 0 && this.vah) {
                LinearLayout dmB = dmB();
                kotlin.g.b.p.g(dmB, "friendFollowLayout");
                dmB.setVisibility(0);
                TextView dmC = dmC();
                kotlin.g.b.p.g(dmC, "friendFollowTv");
                dmC.setText(getContext().getResources().getString(R.string.cov, com.tencent.mm.plugin.finder.utils.k.Lv(bVar.friendFollowCount)));
                AppMethodBeat.o(250389);
                return;
            }
        }
        LinearLayout dmB2 = dmB();
        kotlin.g.b.p.g(dmB2, "friendFollowLayout");
        dmB2.setVisibility(8);
        AppMethodBeat.o(250389);
    }

    public static final class k implements o.f {
        final /* synthetic */ FinderProfileHeaderUIC vcd;
        final /* synthetic */ com.tencent.mm.plugin.finder.api.g vce;

        k(FinderProfileHeaderUIC finderProfileHeaderUIC, com.tencent.mm.plugin.finder.api.g gVar) {
            this.vcd = finderProfileHeaderUIC;
            this.vce = gVar;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(250278);
            kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.a(this.vcd.tOR, this.vcd.getResources().getColor(R.color.Red), this.vcd.getResources().getString(R.string.cit));
            }
            AppMethodBeat.o(250278);
        }
    }

    public static final class l implements o.g {
        final /* synthetic */ FinderProfileHeaderUIC vcd;
        final /* synthetic */ com.tencent.mm.plugin.finder.api.g vce;

        l(FinderProfileHeaderUIC finderProfileHeaderUIC, com.tencent.mm.plugin.finder.api.g gVar) {
            this.vcd = finderProfileHeaderUIC;
            this.vce = gVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(250279);
            kotlin.g.b.p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == this.vcd.tOR) {
                FinderProfileHeaderUIC.a(this.vcd, this.vce);
                this.vcd.vbO = null;
            }
            AppMethodBeat.o(250279);
        }
    }

    public static final class m implements e.b {
        final /* synthetic */ FinderProfileHeaderUIC vcd;
        final /* synthetic */ com.tencent.mm.plugin.finder.api.g vce;

        m(FinderProfileHeaderUIC finderProfileHeaderUIC, com.tencent.mm.plugin.finder.api.g gVar) {
            this.vcd = finderProfileHeaderUIC;
            this.vce = gVar;
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(250280);
            this.vcd.vbO = null;
            AppMethodBeat.o(250280);
        }
    }

    private final void auz(String str) {
        AppMethodBeat.i(250390);
        View view = this.vbj;
        kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.d2c);
        if (isSelf() || !this.vah) {
            kotlin.g.b.p.g(frameLayout, "followBtn");
            frameLayout.setVisibility(8);
            AppMethodBeat.o(250390);
            return;
        }
        View view2 = this.vbj;
        kotlin.g.b.p.g(view2, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        TextView textView = (TextView) view2.findViewById(R.id.d2d);
        kotlin.g.b.p.g(textView, "followBtnTv");
        com.tencent.mm.ui.ao.a(textView.getPaint(), 0.8f);
        kotlin.g.b.p.g(frameLayout, "followBtn");
        frameLayout.setVisibility(0);
        g.a aVar = com.tencent.mm.plugin.finder.upload.action.g.vUn;
        if (com.tencent.mm.plugin.finder.upload.action.g.vUm.asJ(this.username)) {
            dnh();
            AppMethodBeat.o(250390);
            return;
        }
        g.a aVar2 = com.tencent.mm.plugin.finder.upload.action.g.vUn;
        if (com.tencent.mm.plugin.finder.upload.action.g.vUm.asK(this.username)) {
            dng();
            AppMethodBeat.o(250390);
            return;
        }
        auA(str);
        AppMethodBeat.o(250390);
    }

    private final void dng() {
        AppMethodBeat.i(250391);
        View view = this.vbj;
        kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.d2c);
        dnj();
        View view2 = this.vbj;
        kotlin.g.b.p.g(view2, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        TextView textView = (TextView) view2.findViewById(R.id.d2d);
        dmQ().setText(R.string.cot);
        dmQ().setTextColor(getResources().getColor(R.color.FG_0));
        dmQ().setBackgroundResource(R.drawable.a39);
        textView.setText(R.string.cot);
        textView.setTextColor(getResources().getColor(R.color.FG_0));
        frameLayout.setBackgroundResource(R.drawable.a39);
        com.tencent.mm.plugin.finder.api.g profileContact = getProfileContact();
        if (profileContact == null) {
            AppMethodBeat.o(250391);
            return;
        }
        frameLayout.setOnClickListener(new c(new bl(this, profileContact)));
        dmO().setOnClickListener(null);
        AppMethodBeat.o(250391);
    }

    private final void dnh() {
        AppMethodBeat.i(250392);
        View view = this.vbj;
        kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.d2c);
        frameLayout.setBackgroundResource(R.drawable.a39);
        dmO().setBackgroundResource(R.drawable.a39);
        dni();
        com.tencent.mm.plugin.finder.api.g profileContact = getProfileContact();
        if (profileContact == null) {
            AppMethodBeat.o(250392);
            return;
        }
        bj bjVar = new bj(this, profileContact);
        frameLayout.setOnClickListener(new c(bjVar));
        dmO().setOnClickListener(new c(bjVar));
        AppMethodBeat.o(250392);
    }

    private final void dni() {
        AppMethodBeat.i(250393);
        View view = this.vbj;
        kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        TextView textView = (TextView) view.findViewById(R.id.d2d);
        WeImageView dmx = dmx();
        kotlin.g.b.p.g(dmx, "followIv");
        dmx.setVisibility(0);
        kotlin.g.b.p.g(textView, "followBtnTv");
        textView.setVisibility(8);
        WeImageView dmP = dmP();
        kotlin.g.b.p.g(dmP, "actionBarFollowedIv");
        dmP.setVisibility(0);
        TextView dmQ = dmQ();
        kotlin.g.b.p.g(dmQ, "actionBarFollowTv");
        dmQ.setVisibility(8);
        AppMethodBeat.o(250393);
    }

    private final void dnj() {
        AppMethodBeat.i(250394);
        View view = this.vbj;
        kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        TextView textView = (TextView) view.findViewById(R.id.d2d);
        WeImageView dmx = dmx();
        kotlin.g.b.p.g(dmx, "followIv");
        dmx.setVisibility(8);
        kotlin.g.b.p.g(textView, "followBtnTv");
        textView.setVisibility(0);
        WeImageView dmP = dmP();
        kotlin.g.b.p.g(dmP, "actionBarFollowedIv");
        dmP.setVisibility(8);
        TextView dmQ = dmQ();
        kotlin.g.b.p.g(dmQ, "actionBarFollowTv");
        dmQ.setVisibility(0);
        AppMethodBeat.o(250394);
    }

    private final void auA(String str) {
        int i2 = 1;
        AppMethodBeat.i(250395);
        com.tencent.mm.plugin.finder.api.g profileContact = getProfileContact();
        if (profileContact == null) {
            AppMethodBeat.o(250395);
            return;
        }
        View view = this.vbj;
        kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.d2c);
        View view2 = this.vbj;
        kotlin.g.b.p.g(view2, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        TextView textView = (TextView) view2.findViewById(R.id.d2d);
        dnj();
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        boolean i3 = com.tencent.mm.plugin.finder.utils.y.i(profileContact);
        if (kotlin.g.b.p.j(str, "onSceneEnd")) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderHomeTabFragment aN = ((FinderProfileTabUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderProfileTabUIC.class)).aN(FinderProfileFeedFragment.class);
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            FinderProfileFeedLoader.State state = ((FinderProfileFeedUIC) com.tencent.mm.ui.component.a.of(aN).get(FinderProfileFeedUIC.class)).getState();
            com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
            String str2 = this.username;
            int aWB = cl.aWB();
            int i4 = i3 ? 1 : 0;
            if (state != FinderProfileFeedLoader.State.PRIVATE_LOCK) {
                i2 = 0;
            }
            com.tencent.mm.plugin.finder.report.k.c(str2, 4, aWB, i4, i2);
        }
        if (i3) {
            dmQ().setText(R.string.coa);
            textView.setText(R.string.coa);
        } else {
            dmQ().setText(R.string.co_);
            textView.setText(R.string.co_);
        }
        dmO().setBackgroundResource(R.drawable.a38);
        dmQ().setTextColor(getResources().getColor(R.color.am));
        textView.setTextColor(getResources().getColor(R.color.am));
        frameLayout.setBackgroundResource(R.drawable.a38);
        bk bkVar = new bk(this, i3);
        frameLayout.setOnClickListener(new c(bkVar));
        dmO().setOnClickListener(new c(bkVar));
        AppMethodBeat.o(250395);
    }

    private final void dnk() {
        int color;
        int color2;
        AppMethodBeat.i(250396);
        com.tencent.mm.plugin.finder.api.g profileContact = getProfileContact();
        if (profileContact == null) {
            AppMethodBeat.o(250396);
            return;
        }
        View findViewById = getContext().findViewById(R.id.d24);
        String str = profileContact.field_signature;
        if (!(str == null || str.length() == 0)) {
            WeImageView dmH = dmH();
            kotlin.g.b.p.g(dmH, "descTvArrow");
            dmH.setVisibility(8);
            String string = getContext().getResources().getString(R.string.cjt, profileContact.field_signature);
            kotlin.g.b.p.g(string, "context.resources.getStr… contact.field_signature)");
            SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), string);
            StringBuilder sb = new StringBuilder();
            z.d dVar = new z.d();
            com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
            kotlin.g.b.p.g(af2, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (((com.tencent.mm.plugin.i.a.ad) af2).dxX()) {
                Context context = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
                color = context.getResources().getColor(R.color.FG_0);
            } else {
                Context context2 = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context2, "MMApplicationContext.getContext()");
                color = context2.getResources().getColor(R.color.Link_80);
            }
            dVar.SYE = color;
            z.d dVar2 = new z.d();
            com.tencent.mm.kernel.c.a af3 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.ad.class);
            kotlin.g.b.p.g(af3, "MMKernel.service(IFinder…enModeConfig::class.java)");
            if (((com.tencent.mm.plugin.i.a.ad) af3).dxX()) {
                Context context3 = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context3, "MMApplicationContext.getContext()");
                color2 = context3.getResources().getColor(R.color.ac_);
            } else {
                Context context4 = MMApplicationContext.getContext();
                kotlin.g.b.p.g(context4, "MMApplicationContext.getContext()");
                color2 = context4.getResources().getColor(R.color.BW_0_Alpha_0_2);
            }
            dVar2.SYE = color2;
            com.tencent.mm.plugin.finder.utils.d dVar3 = com.tencent.mm.plugin.finder.utils.d.vVg;
            com.tencent.mm.plugin.finder.utils.d.a(string, new au(this, c2, dVar, dVar2, profileContact, sb));
            String sb2 = sb.toString();
            kotlin.g.b.p.g(sb2, "reportNickname.toString()");
            gQ(sb2, profileContact.getUsername());
            TextView dmG = dmG();
            kotlin.g.b.p.g(dmG, "descTv");
            dmG.setText(c2);
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            TextView dmG2 = dmG();
            kotlin.g.b.p.g(dmG2, "descTv");
            kotlin.g.b.p.g(c2, "signatureSpan");
            com.tencent.mm.plugin.finder.utils.y.a(dmG2, c2);
            TextView dmG3 = dmG();
            kotlin.g.b.p.g(dmG3, "descTv");
            dmG3.setVisibility(0);
            findViewById.setBackgroundResource(0);
            findViewById.setPadding(0, 0, 0, 0);
            findViewById.setOnClickListener(null);
            if (findViewById != null) {
                findViewById.setOnLongClickListener(new av(this));
                AppMethodBeat.o(250396);
                return;
            }
            AppMethodBeat.o(250396);
        } else if (isSelf()) {
            dmG().setText(R.string.clg);
            WeImageView dmH2 = dmH();
            kotlin.g.b.p.g(dmH2, "descTvArrow");
            dmH2.setVisibility(0);
            findViewById.setBackgroundResource(R.drawable.a34);
            int dimension = (int) getActivity().getResources().getDimension(R.dimen.ct);
            findViewById.setPadding((int) getActivity().getResources().getDimension(R.dimen.bt), dimension, 0, dimension);
            findViewById.setOnClickListener(new at(this));
            AppMethodBeat.o(250396);
        } else {
            TextView dmG4 = dmG();
            kotlin.g.b.p.g(dmG4, "descTv");
            dmG4.setVisibility(8);
            AppMethodBeat.o(250396);
        }
    }

    public static final class at implements View.OnClickListener {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        at(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            this.vcd = finderProfileHeaderUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250315);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleUserDesc$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putExtra("key_scene", 2);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.N(this.vcd.getContext(), intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleUserDesc$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250315);
        }
    }

    public static final class av implements View.OnLongClickListener {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        av(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            this.vcd = finderProfileHeaderUIC;
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.i(250320);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleUserDesc$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, bVar.axR());
            com.tencent.mm.ui.widget.b.a aVar = new com.tencent.mm.ui.widget.b.a(this.vcd.getContext(), view);
            aVar.a(new View.OnCreateContextMenuListener(this) {
                /* class com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC.av.AnonymousClass1 */
                final /* synthetic */ av vcr;

                {
                    this.vcr = r1;
                }

                public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                    AppMethodBeat.i(250318);
                    contextMenu.add(0, 0, 0, this.vcr.vcd.getContext().getString(R.string.t_));
                    AppMethodBeat.o(250318);
                }
            });
            aVar.a(new o.g(this) {
                /* class com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC.av.AnonymousClass2 */
                final /* synthetic */ av vcr;

                {
                    this.vcr = r1;
                }

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(250319);
                    if (i2 == 0) {
                        ClipboardHelper.setText(FinderProfileHeaderUIC.k(this.vcr.vcd).getText());
                    }
                    AppMethodBeat.o(250319);
                }
            });
            TouchableLayout.a aVar2 = TouchableLayout.Rni;
            int i2 = TouchableLayout.kuv;
            TouchableLayout.a aVar3 = TouchableLayout.Rni;
            boolean ez = aVar.ez(i2, TouchableLayout.kuw);
            com.tencent.mm.hellhoundlib.a.a.a(ez, this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleUserDesc$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
            AppMethodBeat.o(250320);
            return ez;
        }
    }

    private final void gQ(String str, String str2) {
        AppMethodBeat.i(250397);
        if (kotlin.g.b.p.j(str, this.vbW)) {
            AppMethodBeat.o(250397);
            return;
        }
        this.vbW = str;
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
        StringBuilder append = new StringBuilder("0,1,").append(str).append(",0,");
        if (str2 == null) {
            str2 = "";
        }
        hVar.kvStat(21172, append.append(str2).toString());
        AppMethodBeat.o(250397);
    }

    private final void dnl() {
        AppMethodBeat.i(250398);
        com.tencent.mm.plugin.finder.api.g profileContact = getProfileContact();
        if (profileContact == null) {
            AppMethodBeat.o(250398);
            return;
        }
        LinearLayout dmM = dmM();
        kotlin.g.b.p.g(dmM, "nickNameContainer");
        ViewGroup.LayoutParams layoutParams = dmM.getLayoutParams();
        if (layoutParams == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
            AppMethodBeat.o(250398);
            throw tVar;
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        TextView dmA = dmA();
        kotlin.g.b.p.g(dmA, "userTagLayout");
        if (dmA.getVisibility() == 4) {
            layoutParams2.bottomToTop = -1;
            layoutParams2.topToTop = R.id.d1r;
            layoutParams2.bottomToBottom = R.id.d1r;
        } else {
            layoutParams2.bottomToTop = R.id.d1s;
            layoutParams2.topToTop = -1;
            layoutParams2.bottomToBottom = -1;
        }
        LinearLayout dmM2 = dmM();
        kotlin.g.b.p.g(dmM2, "nickNameContainer");
        dmM2.setLayoutParams(layoutParams2);
        TextView dmy = dmy();
        kotlin.g.b.p.g(dmy, "nicknameTv");
        com.tencent.mm.ui.ao.a(dmy.getPaint(), 0.8f);
        com.tencent.mm.plugin.finder.loader.m mVar = com.tencent.mm.plugin.finder.loader.m.uJa;
        com.tencent.mm.loader.d<com.tencent.mm.plugin.finder.loader.o> dka = com.tencent.mm.plugin.finder.loader.m.dka();
        com.tencent.mm.plugin.finder.loader.a aVar = new com.tencent.mm.plugin.finder.loader.a(profileContact.field_avatarUrl);
        ImageView avatarIv = getAvatarIv();
        kotlin.g.b.p.g(avatarIv, "avatarIv");
        com.tencent.mm.plugin.finder.loader.m mVar2 = com.tencent.mm.plugin.finder.loader.m.uJa;
        dka.a(aVar, avatarIv, com.tencent.mm.plugin.finder.loader.m.a(m.a.AVATAR));
        getAvatarIv().setOnClickListener(new ar(this, profileContact));
        AppMethodBeat.o(250398);
    }

    public static final class ar implements View.OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.finder.api.g tEr;
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        ar(FinderProfileHeaderUIC finderProfileHeaderUIC, com.tencent.mm.plugin.finder.api.g gVar) {
            this.vcd = finderProfileHeaderUIC;
            this.tEr = gVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250313);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleNickname$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Intent intent = new Intent();
            intent.putStringArrayListExtra("key_url_list", new ArrayList<>(kotlin.a.j.listOf(this.tEr.cXH())));
            intent.putExtra("key_preview_avatar", true);
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.M(this.vcd.getActivity(), intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleNickname$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250313);
        }
    }

    private final boolean hUD() {
        AppMethodBeat.i(261308);
        if (!isSelf() || !isSelfFlag()) {
            com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
            if (!((Boolean) com.tencent.mm.plugin.finder.storage.c.hVd().value()).booleanValue()) {
                AppMethodBeat.o(261308);
                return false;
            }
        }
        AppMethodBeat.o(261308);
        return true;
    }

    private final void dnm() {
        int i2 = 0;
        AppMethodBeat.i(250399);
        b bVar = (b) userExtInfoCache.get(this.username);
        if (bVar == null) {
            bVar = new b();
        }
        if (bVar.fansCount <= 0 || !hUD()) {
            LinearLayout dmD = dmD();
            kotlin.g.b.p.g(dmD, "fansLayout");
            dmD.setVisibility(8);
        } else {
            boolean z2 = isSelf() && isSelfFlag();
            LinearLayout dmD2 = dmD();
            kotlin.g.b.p.g(dmD2, "fansLayout");
            dmD2.setVisibility(0);
            if (z2) {
                TextView dmF = dmF();
                kotlin.g.b.p.g(dmF, "fansTv");
                dmF.setText(getContext().getResources().getString(R.string.cm9, com.tencent.mm.plugin.finder.utils.k.Lw(bVar.fansCount)));
                dmD().setOnClickListener(new ak(this));
                View view = this.vbj;
                kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
                WeImageView weImageView = (WeImageView) view.findViewById(R.id.d29);
                kotlin.g.b.p.g(weImageView, "header.finder_profile_fans_arrow");
                LinearLayout dmB = dmB();
                kotlin.g.b.p.g(dmB, "friendFollowLayout");
                if (dmB.getVisibility() == 0) {
                    i2 = 8;
                }
                weImageView.setVisibility(i2);
            } else {
                TextView dmF2 = dmF();
                kotlin.g.b.p.g(dmF2, "fansTv");
                dmF2.setText(getContext().getResources().getString(R.string.j_d, com.tencent.mm.plugin.finder.utils.k.Lw(bVar.fansCount)));
            }
        }
        View view2 = this.vbj;
        kotlin.g.b.p.g(view2, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        View findViewById = view2.findViewById(R.id.ebr);
        kotlin.g.b.p.g(findViewById, "header.line");
        LinearLayout dmB2 = dmB();
        kotlin.g.b.p.g(dmB2, "friendFollowLayout");
        findViewById.setVisibility(dmB2.getVisibility());
        AppMethodBeat.o(250399);
    }

    public static final class ak implements View.OnClickListener {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        ak(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            this.vcd = finderProfileHeaderUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(250304);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleFansLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh, "MMKernel.storage()");
            int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_FANS_ADDCOUNT_INT_SYNC, 0);
            if (i2 > 0) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, 1, 2, 5, 3, i2, (String) null, (String) null, 0, FinderProfileHeaderUIC.c(this.vcd), 0, 0, 3520);
            }
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
            aAh2.azQ().set(ar.a.USERINFO_FINDER_FANS_ADDCOUNT_INT_SYNC, (Object) 0);
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
            bdo asW = ((PluginFinder) ah).getRedDotManager().asW("AuthorProfileFans");
            com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
            kotlin.g.b.p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
            com.tencent.mm.plugin.finder.extension.reddot.k asX = ((PluginFinder) ah2).getRedDotManager().asX("AuthorProfileFans");
            if (!(asX == null || asW == null)) {
                com.tencent.mm.plugin.finder.report.j jVar = com.tencent.mm.plugin.finder.report.j.vft;
                com.tencent.mm.plugin.finder.report.j.a(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, asX, asW, 2, FinderProfileHeaderUIC.c(this.vcd), 0, 0, 96);
                com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
                kotlin.g.b.p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
                ((PluginFinder) ah3).getRedDotManager().asV("AuthorProfileFans");
            }
            com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
            com.tencent.mm.plugin.finder.utils.a.fz(this.vcd.getActivity());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/profile/uic/FinderProfileHeaderUIC$handleFansLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250304);
        }
    }

    static final class ax extends kotlin.g.b.q implements kotlin.g.a.a<FrameLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ax(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ FrameLayout invoke() {
            AppMethodBeat.i(250322);
            FrameLayout frameLayout = (FrameLayout) this.uQi.findViewById(R.id.dnv);
            AppMethodBeat.o(250322);
            return frameLayout;
        }
    }

    static final class aw extends kotlin.g.b.q implements kotlin.g.a.a<FrameLayout> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aw(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ FrameLayout invoke() {
            AppMethodBeat.i(250321);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.d2j);
            AppMethodBeat.o(250321);
            return frameLayout;
        }
    }

    static final class ad extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ad(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(250297);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            WeImageView weImageView = (WeImageView) view.findViewById(R.id.d2e);
            AppMethodBeat.o(250297);
            return weImageView;
        }
    }

    static final class bd extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bd(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250328);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.d2q);
            AppMethodBeat.o(250328);
            return textView;
        }
    }

    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<ImageView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ ImageView invoke() {
            AppMethodBeat.i(250277);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            ImageView imageView = (ImageView) view.findViewById(R.id.d1q);
            AppMethodBeat.o(250277);
            return imageView;
        }
    }

    static final class bm extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bm(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250339);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.g6w);
            AppMethodBeat.o(250339);
            return textView;
        }
    }

    static final class bn extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bn(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250340);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.j1q);
            AppMethodBeat.o(250340);
            return textView;
        }
    }

    static final class ae extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ae(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(250298);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.d2h);
            AppMethodBeat.o(250298);
            return linearLayout;
        }
    }

    static final class af extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        af(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250299);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.d2i);
            AppMethodBeat.o(250299);
            return textView;
        }
    }

    static final class u extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(250288);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.d2a);
            AppMethodBeat.o(250288);
            return linearLayout;
        }
    }

    static final class az extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        az(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(250324);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.e74);
            AppMethodBeat.o(250324);
            return linearLayout;
        }
    }

    static final class v extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250289);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.d2b);
            AppMethodBeat.o(250289);
            return textView;
        }
    }

    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250284);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.d25);
            AppMethodBeat.o(250284);
            return textView;
        }
    }

    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(250285);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            WeImageView weImageView = (WeImageView) view.findViewById(R.id.d23);
            AppMethodBeat.o(250285);
            return weImageView;
        }
    }

    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(250276);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.d1p);
            AppMethodBeat.o(250276);
            return linearLayout;
        }
    }

    static final class h extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250275);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.d1n);
            AppMethodBeat.o(250275);
            return textView;
        }
    }

    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250274);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.d1m);
            AppMethodBeat.o(250274);
            return textView;
        }
    }

    static final class f extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(250273);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            WeImageView weImageView = (WeImageView) view.findViewById(R.id.d1l);
            AppMethodBeat.o(250273);
            return weImageView;
        }
    }

    static final class bc extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bc(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(250327);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.d2p);
            AppMethodBeat.o(250327);
            return linearLayout;
        }
    }

    static final class t extends kotlin.g.b.q implements kotlin.g.a.a<RelativeLayout> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ RelativeLayout invoke() {
            AppMethodBeat.i(250287);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.d28);
            AppMethodBeat.o(250287);
            return relativeLayout;
        }
    }

    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<CoordinatorLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ CoordinatorLayout invoke() {
            AppMethodBeat.i(250282);
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.uQi.findViewById(R.id.bg4);
            AppMethodBeat.o(250282);
            return coordinatorLayout;
        }
    }

    static final class c extends kotlin.g.b.q implements kotlin.g.a.a<FrameLayout> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ FrameLayout invoke() {
            AppMethodBeat.i(250270);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FrameLayout dme = ((FinderProfileActionBarUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(FinderProfileActionBarUIC.class)).dme();
            AppMethodBeat.o(250270);
            return dme;
        }
    }

    private final void dnn() {
        AppMethodBeat.i(250400);
        b bVar = (b) userExtInfoCache.get(this.username);
        if (bVar == null) {
            bVar = new b();
        }
        TextView dmz = dmz();
        kotlin.g.b.p.g(dmz, "userOriginalTag");
        dmz.setVisibility(8);
        if (bVar.userTags.isEmpty()) {
            TextView dmA = dmA();
            kotlin.g.b.p.g(dmA, "userTagLayout");
            dmA.setVisibility(4);
            AppMethodBeat.o(250400);
            return;
        }
        TextView dmA2 = dmA();
        kotlin.g.b.p.g(dmA2, "userTagLayout");
        dmA2.setVisibility(0);
        AppMethodBeat.o(250400);
    }

    static final class e extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(250272);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            WeImageView weImageView = (WeImageView) ((FinderProfileActionBarUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(FinderProfileActionBarUIC.class)).uZQ.getValue();
            AppMethodBeat.o(250272);
            return weImageView;
        }
    }

    static final class d extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250271);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            TextView textView = (TextView) ((FinderProfileActionBarUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(FinderProfileActionBarUIC.class)).uZR.getValue();
            AppMethodBeat.o(250271);
            return textView;
        }
    }

    static final class ba extends kotlin.g.b.q implements kotlin.g.a.a<RelativeLayout> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ba(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ RelativeLayout invoke() {
            AppMethodBeat.i(250325);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.d3m);
            AppMethodBeat.o(250325);
            return relativeLayout;
        }
    }

    static final class bb extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bb(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250326);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.hqi);
            AppMethodBeat.o(250326);
            return textView;
        }
    }

    static final class aa extends kotlin.g.b.q implements kotlin.g.a.a<RelativeLayout> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        aa(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ RelativeLayout invoke() {
            AppMethodBeat.i(250294);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.cw6);
            AppMethodBeat.o(250294);
            return relativeLayout;
        }
    }

    static final class z extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250293);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.cw8);
            AppMethodBeat.o(250293);
            return textView;
        }
    }

    static final class x extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250291);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.cw3);
            AppMethodBeat.o(250291);
            return textView;
        }
    }

    static final class y extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250292);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.cw4);
            AppMethodBeat.o(250292);
            return textView;
        }
    }

    private final String dno() {
        String str;
        AppMethodBeat.i(250401);
        b bVar = (b) userExtInfoCache.get(this.username);
        if (bVar == null) {
            bVar = new b();
        }
        LinkedList<String> linkedList = bVar.userTags;
        if (!linkedList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next()).append(" ");
            }
            SpannableString c2 = com.tencent.mm.pluginsdk.ui.span.l.c(getContext(), sb.toString());
            if (c2 != null) {
                str = c2.toString();
                kotlin.g.b.p.g(str, "this.toString()");
                AppMethodBeat.o(250401);
                return str;
            }
        }
        str = "";
        AppMethodBeat.o(250401);
        return str;
    }

    static final class bx extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bx(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(261288);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.k1f);
            AppMethodBeat.o(261288);
            return linearLayout;
        }
    }

    static final class by extends kotlin.g.b.q implements kotlin.g.a.a<View> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        by(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ View invoke() {
            AppMethodBeat.i(261289);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            View findViewById = view.findViewById(R.id.k1g);
            AppMethodBeat.o(261289);
            return findViewById;
        }
    }

    static final class bu extends kotlin.g.b.q implements kotlin.g.a.a<RelativeLayout> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bu(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ RelativeLayout invoke() {
            AppMethodBeat.i(261285);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.k1t);
            AppMethodBeat.o(261285);
            return relativeLayout;
        }
    }

    static final class bs extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bs(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(261283);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.jzd);
            AppMethodBeat.o(261283);
            return textView;
        }
    }

    static final class bt extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bt(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(261284);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.k1v);
            AppMethodBeat.o(261284);
            return textView;
        }
    }

    static final class br extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        br(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(261282);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.k1s);
            AppMethodBeat.o(261282);
            return textView;
        }
    }

    static final class w extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(250290);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            WeImageView weImageView = (WeImageView) view.findViewById(R.id.d1t);
            AppMethodBeat.o(250290);
            return weImageView;
        }
    }

    static final class ab extends kotlin.g.b.q implements kotlin.g.a.a<RelativeLayout> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ab(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ RelativeLayout invoke() {
            AppMethodBeat.i(250295);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.fbi);
            AppMethodBeat.o(250295);
            return relativeLayout;
        }
    }

    static final class ac extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ac(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(250296);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.fbk);
            AppMethodBeat.o(250296);
            return textView;
        }
    }

    static final class bv extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bv(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(261286);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.jze);
            AppMethodBeat.o(261286);
            return linearLayout;
        }
    }

    static final class bw extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bw(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(261287);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.jzf);
            AppMethodBeat.o(261287);
            return textView;
        }
    }

    static /* synthetic */ void a(FinderProfileHeaderUIC finderProfileHeaderUIC, boolean z2) {
        AppMethodBeat.i(250403);
        finderProfileHeaderUIC.x(z2, "");
        AppMethodBeat.o(250403);
    }

    private final void x(boolean z2, String str) {
        AppMethodBeat.i(250402);
        if (z2) {
            WeImageView dmX = dmX();
            kotlin.g.b.p.g(dmX, "finderBlockIcon");
            dmX.setVisibility(0);
        } else {
            WeImageView dmX2 = dmX();
            kotlin.g.b.p.g(dmX2, "finderBlockIcon");
            dmX2.setVisibility(8);
        }
        if (!kotlin.g.b.p.j(str, "onCreate")) {
            com.tencent.mm.plugin.finder.profile.adapter.a aVar = this.vbP;
            View view = this.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            Context context = view.getContext();
            com.tencent.mm.plugin.finder.api.g profileContact = getProfileContact();
            aVar.a(com.tencent.mm.pluginsdk.ui.span.l.c(context, profileContact != null ? profileContact.getNickname() : null), dno(), false);
        }
        AppMethodBeat.o(250402);
    }

    static final class ay extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ay(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(250323);
            Boolean valueOf = Boolean.valueOf(this.vcd.getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false));
            AppMethodBeat.o(250323);
            return valueOf;
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        String str2;
        b bVar;
        aqk aqk;
        String str3;
        AppMethodBeat.i(250404);
        kotlin.g.b.p.h(qVar, "scene");
        Fragment fragment = getFragment();
        if ((fragment == null || !fragment.isDetached()) && !getActivity().isFinishing()) {
            if (i2 == 0 && i3 == 0) {
                if (qVar instanceof cn) {
                    if (((cn) qVar).twp == 0) {
                        StringBuilder append = new StringBuilder("username=").append(this.username).append(", scene username=");
                        FinderContact cZk = ((cn) qVar).cZk();
                        if (cZk != null) {
                            str2 = cZk.username;
                        } else {
                            str2 = null;
                        }
                        Log.i("Finder.FinderProfileHeaderUIC", append.append(str2).toString());
                        if (!kotlin.g.b.p.j(((cn) qVar).tuH, this.username)) {
                            AppMethodBeat.o(250404);
                            return;
                        }
                        FinderContact cZk2 = ((cn) qVar).cZk();
                        if (!(cZk2 == null || (str3 = cZk2.username) == null)) {
                            kotlin.g.b.p.g(str3, LocaleUtil.ITALIAN);
                            this.username = str3;
                        }
                        b bVar2 = (b) userExtInfoCache.get(this.username);
                        if (bVar2 == null) {
                            bVar = new b();
                        } else {
                            bVar = bVar2;
                        }
                        bVar.fansCount = ((cn) qVar).fansCount;
                        bVar.friendFollowCount = ((cn) qVar).friendFollowCount;
                        bVar.at(((cn) qVar).userTags);
                        com.tencent.mm.bw.a aYK = ((cn) qVar).rr.aYK();
                        if (aYK == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
                            AppMethodBeat.o(250404);
                            throw tVar;
                        }
                        awt awt = ((FinderUserPageResponse) aYK).liveNoticeInfo;
                        if (!(this.vbU == -1 || this.vbT == -1 || awt == null || awt.status != this.vbU)) {
                            Log.i("Finder.FinderProfileHeaderUIC", "[checkLiveNoticeInfo] notice action change before sceneEnd");
                            awt.status = this.vbT;
                        }
                        bVar.vca = awt;
                        bVar.vcb = ((cn) qVar).cZl();
                        com.tencent.mm.bw.a aYK2 = ((cn) qVar).rr.aYK();
                        if (aYK2 == null) {
                            kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
                            AppMethodBeat.o(250404);
                            throw tVar2;
                        }
                        bVar.vcc = ((FinderUserPageResponse) aYK2).biz_info;
                        com.tencent.mm.bw.a aYK3 = ((cn) qVar).rr.aYK();
                        if (aYK3 == null) {
                            kotlin.t tVar3 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
                            AppMethodBeat.o(250404);
                            throw tVar3;
                        }
                        LinkedList<aqk> linkedList = ((FinderUserPageResponse) aYK3).eventInfoList;
                        if (linkedList != null) {
                            aqk = (aqk) kotlin.a.j.kt(linkedList);
                        } else {
                            aqk = null;
                        }
                        bVar.tqo = aqk;
                        userExtInfoCache.put(this.username, bVar);
                        auw(this.USQ);
                        if (this.USM) {
                            this.USM = false;
                            AppMethodBeat.o(250404);
                            return;
                        }
                    }
                } else if (qVar instanceof cd) {
                    this.vbV = true;
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    ((FinderLivePostBtnUIC) com.tencent.mm.ui.component.a.b(getActivity()).get(FinderLivePostBtnUIC.class)).dIm().a(((cd) qVar).cZc());
                }
            }
            AppMethodBeat.o(250404);
            return;
        }
        AppMethodBeat.o(250404);
    }

    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<bbn> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ bbn invoke() {
            AppMethodBeat.i(250281);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.uQi).get(FinderReporterUIC.class)).dIx();
            AppMethodBeat.o(250281);
            return dIx;
        }
    }

    static final class bp extends kotlin.g.b.q implements kotlin.g.a.a<LinearLayout> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bp(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ LinearLayout invoke() {
            AppMethodBeat.i(261280);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.gkd);
            AppMethodBeat.o(261280);
            return linearLayout;
        }
    }

    static final class bo extends kotlin.g.b.q implements kotlin.g.a.a<WeImageView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bo(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ WeImageView invoke() {
            AppMethodBeat.i(261279);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            WeImageView weImageView = (WeImageView) view.findViewById(R.id.gkb);
            AppMethodBeat.o(261279);
            return weImageView;
        }
    }

    static final class bq extends kotlin.g.b.q implements kotlin.g.a.a<TextView> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        bq(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            super(0);
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ TextView invoke() {
            AppMethodBeat.i(261281);
            View view = this.vcd.vbj;
            kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
            TextView textView = (TextView) view.findViewById(R.id.gke);
            AppMethodBeat.o(261281);
            return textView;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        String str;
        String str2;
        boolean z2 = false;
        int i4 = 1;
        AppMethodBeat.i(250405);
        super.onActivityResult(i2, i3, intent);
        if (intent == null) {
            AppMethodBeat.o(250405);
            return;
        }
        switch (i2) {
            case 10006:
                Log.d("Finder.FinderProfileHeaderUIC", "onActivityResult CONTEXT_MENU_IMAGE_BROUND");
                Uri data = intent.getData();
                if (data == null || (str2 = data.getPath()) == null) {
                    str2 = "";
                }
                kotlin.g.b.p.g(str2, "data.data?.path?:\"\"");
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    Log.w("Finder.FinderProfileHeaderUIC", "filePath is null.try to getResultPhotoPath.");
                    Context context = this.applicationContext;
                    com.tencent.mm.plugin.finder.utils.al alVar = com.tencent.mm.plugin.finder.utils.al.waC;
                    str2 = com.tencent.mm.pluginsdk.ui.tools.s.h(context, intent, com.tencent.mm.plugin.finder.utils.al.dEA());
                    kotlin.g.b.p.g(str2, "TakePhotoUtil.getResultP…PathRouter.finderTmpPath)");
                }
                Log.i("Finder.FinderProfileHeaderUIC", "filePath[" + str2 + "] " + intent);
                String str4 = str2;
                if (str4 == null || str4.length() == 0) {
                    z2 = true;
                }
                if (z2) {
                    Log.e("Finder.FinderProfileHeaderUIC", "filePath is null.");
                    AppMethodBeat.o(250405);
                    return;
                }
                AppCompatActivity activity = getActivity();
                String str5 = str2 + System.currentTimeMillis();
                Charset charset = kotlin.n.d.UTF_8;
                if (str5 == null) {
                    kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(250405);
                    throw tVar;
                }
                byte[] bytes = str5.getBytes(charset);
                kotlin.g.b.p.g(bytes, "(this as java.lang.String).getBytes(charset)");
                String messageDigest = com.tencent.mm.b.g.getMessageDigest(bytes);
                kotlin.g.b.p.g(messageDigest, "MD5.getMessageDigest((fi…eMillis()).toByteArray())");
                intent.setClass(activity, FinderCropAvatarUI.class);
                intent.putExtra("key_crop_style", 1);
                intent.putExtra("key_crop_source", 2);
                intent.putExtra("key_source_img_path", str2);
                intent.putExtra("key_result_file_name", messageDigest);
                activity.startActivityForResult(intent, 10008);
                AppMethodBeat.o(250405);
                return;
            case CdnLogic.kMediaTypeFavoriteBigFile:
                Log.d("Finder.FinderProfileHeaderUIC", "onActivityResult MENU_ID_SET_HEADIMG_TAKEPHOTO");
                Context context2 = this.applicationContext;
                com.tencent.mm.plugin.finder.utils.al alVar2 = com.tencent.mm.plugin.finder.utils.al.waC;
                String h2 = com.tencent.mm.pluginsdk.ui.tools.s.h(context2, intent, com.tencent.mm.plugin.finder.utils.al.dEA());
                if (h2 == null) {
                    Log.e("Finder.FinderProfileHeaderUIC", "filePath is null.");
                    AppMethodBeat.o(250405);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_ImgPath", h2);
                String str6 = h2 + System.currentTimeMillis();
                Charset charset2 = kotlin.n.d.UTF_8;
                if (str6 == null) {
                    kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(250405);
                    throw tVar2;
                }
                byte[] bytes2 = str6.getBytes(charset2);
                kotlin.g.b.p.g(bytes2, "(this as java.lang.String).getBytes(charset)");
                String messageDigest2 = com.tencent.mm.b.g.getMessageDigest(bytes2);
                StringBuilder sb = new StringBuilder();
                com.tencent.mm.plugin.finder.utils.al alVar3 = com.tencent.mm.plugin.finder.utils.al.waC;
                StringBuilder append = sb.append(com.tencent.mm.plugin.finder.utils.al.dEA());
                if (messageDigest2 == null) {
                    kotlin.g.b.p.hyc();
                }
                intent2.putExtra("CropImage_OutputPath", append.append(messageDigest2).toString());
                intent2.setClassName(getActivity(), "com.tencent.mm.ui.tools.CropImageNewUI");
                getContext().startActivityForResult(intent2, 10008);
                AppMethodBeat.o(250405);
                return;
            case 10008:
                Log.d("Finder.FinderProfileHeaderUIC", "onActivityResult REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM");
                String stringExtra = intent.getStringExtra("key_result_img_path");
                if (stringExtra == null || !com.tencent.mm.vfs.s.YS(stringExtra)) {
                    Log.e("Finder.FinderProfileHeaderUIC", "ERROR! filePath=".concat(String.valueOf(stringExtra)));
                    AppMethodBeat.o(250405);
                    return;
                }
                Log.d("Finder.FinderProfileHeaderUIC", "REQUEST_CODE_IMAGE_BROUND_SEND_COMFIRM ".concat(String.valueOf(stringExtra)));
                com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
                kotlin.g.b.p.g(aAh, "MMKernel.storage()");
                aAh.azQ().set(ar.a.USERINFO_MY_FINDER_LOCAL_COVER_IMG_STRING_SYNC, stringExtra);
                g.a aVar = com.tencent.mm.plugin.finder.upload.g.vSJ;
                com.tencent.mm.plugin.finder.upload.g gVar = com.tencent.mm.plugin.finder.upload.g.vSH;
                String str7 = this.username;
                be beVar = new be(this);
                kotlin.g.b.p.h(stringExtra, "path");
                kotlin.g.b.p.h(str7, "userName");
                kotlin.g.b.p.h(beVar, "callback");
                gVar.vSB.a(new com.tencent.mm.plugin.finder.upload.l(stringExtra, str7), beVar);
                AppMethodBeat.o(250405);
                return;
            case 10009:
                c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
                com.tencent.mm.plugin.finder.api.g asG = c.a.asG(com.tencent.mm.model.z.aUg());
                String stringExtra2 = intent.getStringExtra("Country");
                if (stringExtra2 == null) {
                    stringExtra2 = "";
                }
                String stringExtra3 = intent.getStringExtra("Contact_Province");
                if (stringExtra3 == null) {
                    stringExtra3 = "";
                }
                String stringExtra4 = intent.getStringExtra("Contact_City");
                if (stringExtra4 == null) {
                    stringExtra4 = "";
                }
                Log.i("Finder.FinderProfileHeaderUIC", "countryCode " + stringExtra2 + " provinceCode" + stringExtra3 + " cityCode" + stringExtra4);
                if (kotlin.g.b.p.j(stringExtra2, "unshow")) {
                    com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
                    kotlin.g.b.p.g(aAh2, "MMKernel.storage()");
                    com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
                    kotlin.g.b.p.g(aAh3, "MMKernel.storage()");
                    aAh3.azQ().set(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, Integer.valueOf(aAh2.azQ().getInt(ar.a.USERINFO_FINDER_USER_EXT_FLAG_INT_SYNC, 0) & -5));
                    str = "";
                } else {
                    i4 = 0;
                    str = stringExtra2;
                }
                if (asG != null) {
                    app app = asG.field_extInfo;
                    if (app != null) {
                        app.country = str;
                        app.fuJ = stringExtra3;
                        app.fuK = stringExtra4;
                    } else {
                        asG.field_extInfo = new app();
                        asG.field_extInfo.country = str;
                        asG.field_extInfo.fuJ = stringExtra3;
                        asG.field_extInfo.fuK = stringExtra4;
                    }
                    c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
                    c.a.c(asG);
                }
                ((com.tencent.mm.plugin.i.a.x) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.x.class)).a(str, stringExtra3, stringExtra4, i4, null);
                break;
        }
        AppMethodBeat.o(250405);
    }

    public static final class be implements com.tencent.mm.loader.g.f<com.tencent.mm.loader.g.c> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        be(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // com.tencent.mm.loader.g.f
        public final void a(com.tencent.mm.loader.g.c cVar, com.tencent.mm.loader.g.j jVar) {
            AppMethodBeat.i(250329);
            kotlin.g.b.p.h(cVar, "task");
            kotlin.g.b.p.h(jVar, "status");
            if (jVar == com.tencent.mm.loader.g.j.Fail) {
                com.tencent.mm.ui.base.u.makeText(this.vcd.getActivity(), this.vcd.getString(R.string.dax), 0).show();
                AppMethodBeat.o(250329);
                return;
            }
            com.tencent.mm.ui.base.u.makeText(this.vcd.getActivity(), this.vcd.getString(R.string.daz), 0).show();
            AppMethodBeat.o(250329);
        }
    }

    public static final class b {
        public int fansCount;
        public int friendFollowCount;
        aqk tqo;
        public LinkedList<String> userTags;
        awt vca;
        public bel vcb;
        aoy vcc;

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
            if (kotlin.g.b.p.j(r3.tqo, r4.tqo) != false) goto L_0x004c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 250269(0x3d19d, float:3.50702E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x004c
                boolean r0 = r4 instanceof com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC.b
                if (r0 == 0) goto L_0x0051
                com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC$b r4 = (com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC.b) r4
                int r0 = r3.friendFollowCount
                int r1 = r4.friendFollowCount
                if (r0 != r1) goto L_0x0051
                int r0 = r3.fansCount
                int r1 = r4.fansCount
                if (r0 != r1) goto L_0x0051
                java.util.LinkedList<java.lang.String> r0 = r3.userTags
                java.util.LinkedList<java.lang.String> r1 = r4.userTags
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0051
                com.tencent.mm.protocal.protobuf.awt r0 = r3.vca
                com.tencent.mm.protocal.protobuf.awt r1 = r4.vca
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0051
                com.tencent.mm.protocal.protobuf.bel r0 = r3.vcb
                com.tencent.mm.protocal.protobuf.bel r1 = r4.vcb
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0051
                com.tencent.mm.protocal.protobuf.aoy r0 = r3.vcc
                com.tencent.mm.protocal.protobuf.aoy r1 = r4.vcc
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0051
                com.tencent.mm.protocal.protobuf.aqk r0 = r3.tqo
                com.tencent.mm.protocal.protobuf.aqk r1 = r4.tqo
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0051
            L_0x004c:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0050:
                return r0
            L_0x0051:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0050
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC.b.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(250268);
            int i3 = ((this.friendFollowCount * 31) + this.fansCount) * 31;
            LinkedList<String> linkedList = this.userTags;
            int hashCode = ((linkedList != null ? linkedList.hashCode() : 0) + i3) * 31;
            awt awt = this.vca;
            int hashCode2 = ((awt != null ? awt.hashCode() : 0) + hashCode) * 31;
            bel bel = this.vcb;
            int hashCode3 = ((bel != null ? bel.hashCode() : 0) + hashCode2) * 31;
            aoy aoy = this.vcc;
            int hashCode4 = ((aoy != null ? aoy.hashCode() : 0) + hashCode3) * 31;
            aqk aqk = this.tqo;
            if (aqk != null) {
                i2 = aqk.hashCode();
            }
            int i4 = hashCode4 + i2;
            AppMethodBeat.o(250268);
            return i4;
        }

        public final String toString() {
            AppMethodBeat.i(250267);
            String str = "UserExtInfo(friendFollowCount=" + this.friendFollowCount + ", fansCount=" + this.fansCount + ", userTags=" + this.userTags + ", finderLiveNoticInfo=" + this.vca + ", shopInfo=" + this.vcb + ", bizInfo=" + this.vcc + ", eventInfo=" + this.tqo + ")";
            AppMethodBeat.o(250267);
            return str;
        }

        private b(LinkedList<String> linkedList) {
            kotlin.g.b.p.h(linkedList, "userTags");
            AppMethodBeat.i(250265);
            this.friendFollowCount = -1;
            this.fansCount = -1;
            this.userTags = linkedList;
            this.vca = null;
            this.vcb = null;
            this.vcc = null;
            this.tqo = null;
            AppMethodBeat.o(250265);
        }

        public /* synthetic */ b() {
            this(new LinkedList());
            AppMethodBeat.i(250266);
            AppMethodBeat.o(250266);
        }

        public final void at(LinkedList<String> linkedList) {
            AppMethodBeat.i(250264);
            kotlin.g.b.p.h(linkedList, "<set-?>");
            this.userTags = linkedList;
            AppMethodBeat.o(250264);
        }
    }

    public static final class p implements com.tencent.mm.plugin.finder.api.f {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        p(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // com.tencent.mm.plugin.finder.api.f
        public final void a(apf apf, int i2, int i3) {
            AppMethodBeat.i(250283);
            kotlin.g.b.p.h(apf, "cmdItem");
            if (!FinderProfileHeaderUIC.m(this.vcd) || !FinderProfileHeaderUIC.n(this.vcd)) {
                AppMethodBeat.o(250283);
                return;
            }
            switch (apf.cmdId) {
                case 106:
                    FinderProfileHeaderUIC.b(this.vcd, "handleCmd");
                    break;
            }
            AppMethodBeat.o(250283);
        }
    }

    static final class bf implements o.f {
        final /* synthetic */ FinderProfileHeaderUIC vcd;

        bf(FinderProfileHeaderUIC finderProfileHeaderUIC) {
            this.vcd = finderProfileHeaderUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(250330);
            kotlin.g.b.p.g(mVar, LocaleUtil.ITALIAN);
            if (mVar.gKQ()) {
                mVar.a(this.vcd.vbS, this.vcd.getResources().getColor(R.color.Red), this.vcd.getResources().getString(R.string.d1g));
            }
            AppMethodBeat.o(250330);
        }
    }

    static final class bg implements o.g {
        final /* synthetic */ FinderProfileHeaderUIC vcd;
        final /* synthetic */ z.a vcs;

        bg(FinderProfileHeaderUIC finderProfileHeaderUIC, z.a aVar) {
            this.vcd = finderProfileHeaderUIC;
            this.vcs = aVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(250331);
            kotlin.g.b.p.g(menuItem, "menuItem");
            if (menuItem.getItemId() == this.vcd.vbS) {
                FinderProfileHeaderUIC.b(this.vcd, !this.vcs.SYB);
            }
            AppMethodBeat.o(250331);
        }
    }

    public static final class s implements com.tencent.mm.plugin.i.a.ai<ayu> {
        final /* synthetic */ FinderProfileHeaderUIC vcd;
        final /* synthetic */ boolean vcf;

        s(FinderProfileHeaderUIC finderProfileHeaderUIC, boolean z) {
            this.vcd = finderProfileHeaderUIC;
            this.vcf = z;
        }

        @Override // com.tencent.mm.plugin.i.a.ai
        public final /* synthetic */ void a(ayu ayu, apg apg) {
            boolean z;
            com.tencent.mm.plugin.finder.api.g b2;
            AppMethodBeat.i(250286);
            ayu ayu2 = ayu;
            kotlin.g.b.p.h(ayu2, "req");
            kotlin.g.b.p.h(apg, "ret");
            if (apg.retCode == 0) {
                c.a aVar = com.tencent.mm.plugin.finder.api.c.tsp;
                com.tencent.mm.plugin.finder.api.g asG = c.a.asG(this.vcd.username);
                if (asG != null) {
                    if (ayu2.opType == 1) {
                        asG.field_extFlag |= 16384;
                        if (this.vcf) {
                            com.tencent.mm.ui.base.u.u(this.vcd.getActivity(), this.vcd.getString(R.string.d1n), R.raw.icons_filled_eyes_off);
                        }
                        c.a aVar2 = com.tencent.mm.plugin.finder.api.c.tsp;
                        if (c.a.asJ(this.vcd.username) && (b2 = FinderProfileHeaderUIC.b(this.vcd)) != null) {
                            FinderProfileHeaderUIC.a(this.vcd, b2);
                        }
                    } else {
                        asG.field_extFlag &= -16385;
                        if (this.vcf) {
                            com.tencent.mm.ui.base.u.u(this.vcd.getActivity(), this.vcd.getString(R.string.d1q), R.raw.icons_filled_done);
                        }
                    }
                    c.a aVar3 = com.tencent.mm.plugin.finder.api.c.tsp;
                    c.a.c(asG);
                    FinderProfileHeaderUIC finderProfileHeaderUIC = this.vcd;
                    if (ayu2.opType == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    FinderProfileHeaderUIC.a(finderProfileHeaderUIC, z);
                    AppMethodBeat.o(250286);
                    return;
                }
                AppMethodBeat.o(250286);
                return;
            }
            com.tencent.mm.ui.base.u.makeText(this.vcd.getActivity(), this.vcd.getString(R.string.d1j), 0).show();
            AppMethodBeat.o(250286);
        }
    }

    static /* synthetic */ void b(FinderProfileHeaderUIC finderProfileHeaderUIC, boolean z2) {
        AppMethodBeat.i(250407);
        finderProfileHeaderUIC.P(z2, true);
        AppMethodBeat.o(250407);
    }

    private final void P(boolean z2, boolean z3) {
        AppMethodBeat.i(250406);
        ((com.tencent.mm.plugin.i.a.r) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.r.class)).a(this.username, z2, new s(this, z3));
        AppMethodBeat.o(250406);
    }

    public static final /* synthetic */ LinearLayout o(FinderProfileHeaderUIC finderProfileHeaderUIC) {
        AppMethodBeat.i(261309);
        LinearLayout linearLayout = (LinearLayout) finderProfileHeaderUIC.USN.getValue();
        AppMethodBeat.o(261309);
        return linearLayout;
    }

    public static final /* synthetic */ TextView p(FinderProfileHeaderUIC finderProfileHeaderUIC) {
        AppMethodBeat.i(261310);
        TextView textView = (TextView) finderProfileHeaderUIC.USP.getValue();
        AppMethodBeat.o(261310);
        return textView;
    }

    public static final /* synthetic */ WeImageView q(FinderProfileHeaderUIC finderProfileHeaderUIC) {
        AppMethodBeat.i(261311);
        WeImageView weImageView = (WeImageView) finderProfileHeaderUIC.USO.getValue();
        AppMethodBeat.o(261311);
        return weImageView;
    }

    public static final /* synthetic */ void r(FinderProfileHeaderUIC finderProfileHeaderUIC) {
        AppMethodBeat.i(261312);
        Toast makeText = com.tencent.mm.ui.base.u.makeText(finderProfileHeaderUIC.getContext(), finderProfileHeaderUIC.getContext().getString(R.string.jb8), 0);
        makeText.setGravity(17, 0, 0);
        makeText.show();
        AppMethodBeat.o(261312);
    }

    public static final /* synthetic */ void a(FinderProfileHeaderUIC finderProfileHeaderUIC, com.tencent.mm.plugin.finder.api.g gVar) {
        String str;
        int i2 = 1;
        AppMethodBeat.i(250415);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderHomeTabFragment aN = ((FinderProfileTabUIC) com.tencent.mm.ui.component.a.b(finderProfileHeaderUIC.getActivity()).get(FinderProfileTabUIC.class)).aN(FinderProfileFeedFragment.class);
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        FinderProfileFeedLoader.State state = ((FinderProfileFeedUIC) com.tencent.mm.ui.component.a.of(aN).get(FinderProfileFeedUIC.class)).getState();
        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
        String str2 = finderProfileHeaderUIC.username;
        int aWB = cl.aWB();
        com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
        int i3 = com.tencent.mm.plugin.finder.utils.y.i(gVar) ? 1 : 0;
        if (state != FinderProfileFeedLoader.State.PRIVATE_LOCK) {
            i2 = 0;
        }
        com.tencent.mm.plugin.finder.report.k.c(str2, 3, aWB, i3, i2);
        com.tencent.mm.plugin.finder.model.ag agVar = com.tencent.mm.plugin.finder.model.ag.uOs;
        bbn contextObj = finderProfileHeaderUIC.getContextObj();
        String str3 = finderProfileHeaderUIC.username;
        bb.a aVar3 = com.tencent.mm.plugin.finder.cgi.bb.tve;
        com.tencent.mm.plugin.finder.model.ag.b(contextObj, str3, com.tencent.mm.plugin.finder.cgi.bb.tvc);
        finderProfileHeaderUIC.dnl();
        finderProfileHeaderUIC.auz("setFollowed");
        com.tencent.mm.plugin.finder.profile.adapter.a aVar4 = finderProfileHeaderUIC.vbP;
        View view = finderProfileHeaderUIC.vbj;
        kotlin.g.b.p.g(view, TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
        Context context = view.getContext();
        com.tencent.mm.plugin.finder.api.g profileContact = finderProfileHeaderUIC.getProfileContact();
        if (profileContact != null) {
            str = profileContact.getNickname();
        } else {
            str = null;
        }
        aVar4.a(com.tencent.mm.pluginsdk.ui.span.l.c(context, str), finderProfileHeaderUIC.dno());
        AppMethodBeat.o(250415);
    }

    public static final /* synthetic */ void b(FinderProfileHeaderUIC finderProfileHeaderUIC, com.tencent.mm.plugin.finder.api.g gVar) {
        AppMethodBeat.i(250418);
        if (finderProfileHeaderUIC.vbO == null) {
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e((Context) finderProfileHeaderUIC.getContext(), 1, true);
            eVar.o(finderProfileHeaderUIC.getContext().getResources().getString(R.string.cis), 17);
            eVar.a(new k(finderProfileHeaderUIC, gVar));
            eVar.a(new l(finderProfileHeaderUIC, gVar));
            eVar.b(new m(finderProfileHeaderUIC, gVar));
            finderProfileHeaderUIC.vbO = eVar;
        }
        com.tencent.mm.ui.widget.a.e eVar2 = finderProfileHeaderUIC.vbO;
        if (eVar2 != null) {
            if (!eVar2.isShowing()) {
                eVar2.dGm();
            }
            AppMethodBeat.o(250418);
            return;
        }
        AppMethodBeat.o(250418);
    }
}
