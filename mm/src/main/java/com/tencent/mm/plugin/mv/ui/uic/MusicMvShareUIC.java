package com.tencent.mm.plugin.mv.ui.uic;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.MenuItem;
import android.widget.Toast;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ag.k;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.protocal.protobuf.axx;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.cst;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.s;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002JD\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\t\u001a\u00020\u0006J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u000e\u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvShareUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "currentShareMv", "Lcom/tencent/mm/plugin/mv/model/MusicMv;", "clickListMenu", "", "musicMv", "clickMoreMenu", "doFav", "doShareMvToTimeLine", "musicWrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "Landroid/app/Activity;", "coverBm", "Landroid/graphics/Bitmap;", "CoverLocalPath", "", "shareObject", "Lcom/tencent/mm/protocal/protobuf/MusicShareObject;", "doShareToChat", "doShareToSns", "getMvCoverLocalPath", "mv", "onCreateMVBtnClicked", "Companion", "plugin-mv_release"})
public final class MusicMvShareUIC extends UIComponent {
    public static final a Awa = new a((byte) 0);
    private com.tencent.mm.plugin.mv.a.e AvZ;

    static {
        AppMethodBeat.i(257366);
        AppMethodBeat.o(257366);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvShareUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257365);
        AppMethodBeat.o(257365);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvShareUIC$Companion;", "", "()V", "MENU_ID_SECOND_CREATE_MV", "", "MENU_ID_SECOND_DEL_MV", "MENU_ID_SECOND_EXPOSE_MV", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_FAVORITE", "MENU_ID_SHARE_TO_SNS", "SHARE_TO_CHAT_REQUEST_CODE", "SHARE_TO_SNS_REQUEST_CODE", "TAG", "", "plugin-mv_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class b implements o.f {
        final /* synthetic */ MusicMvShareUIC Awb;

        public b(MusicMvShareUIC musicMvShareUIC) {
            this.Awb = musicMvShareUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(257353);
            mVar.b(101, this.Awb.getString(R.string.yz), 0);
            mVar.b(102, this.Awb.getString(R.string.f9y), 0);
            AppMethodBeat.o(257353);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class c implements o.g {
        final /* synthetic */ MusicMvShareUIC Awb;
        final /* synthetic */ com.tencent.mm.plugin.mv.a.e Awc;

        public c(MusicMvShareUIC musicMvShareUIC, com.tencent.mm.plugin.mv.a.e eVar) {
            this.Awb = musicMvShareUIC;
            this.Awc = eVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(257354);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 101:
                    MusicMvShareUIC.a(this.Awb, this.Awc);
                    AppMethodBeat.o(257354);
                    return;
                case 102:
                    MusicMvShareUIC.b(this.Awb, this.Awc);
                    break;
            }
            AppMethodBeat.o(257354);
        }
    }

    public final void i(com.tencent.mm.plugin.mv.a.e eVar) {
        long j2;
        FinderObject finderObject;
        FinderObjectDesc finderObjectDesc;
        axw axw;
        LinkedList<axz> linkedList;
        FinderObjectDesc finderObjectDesc2;
        AppMethodBeat.i(257363);
        p.h(eVar, "musicMv");
        Intent intent = new Intent();
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.ko(getContext()).get(MusicMvDataUIC.class);
        p.g(viewModel, "UICProvider.of(context).…sicMvDataUIC::class.java)");
        MusicMvDataUIC musicMvDataUIC = (MusicMvDataUIC) viewModel;
        csp csp = new csp();
        FinderObject finderObject2 = new FinderObject();
        Long l = eVar.ApE;
        if (l != null) {
            j2 = l.longValue();
        } else {
            j2 = 0;
        }
        finderObject2.id = j2;
        finderObject2.objectNonceId = eVar.ApF;
        FinderObjectDesc finderObjectDesc3 = new FinderObjectDesc();
        axw axw2 = new axw();
        axw2.Aqo = musicMvDataUIC.Aqo;
        axx axx = new axx();
        axx.LIe = 0.0f;
        axw2.ApI = axx;
        if (eVar.ApM == 1) {
            axw2.LId = eVar.ApH;
        } else if (!(eVar.ApM != 4 || (finderObject = eVar.ApP) == null || (finderObjectDesc = finderObject.objectDesc) == null || (axw = finderObjectDesc.mvInfo) == null || (linkedList = axw.LId) == null)) {
            axw2.LId = linkedList;
        }
        finderObjectDesc3.mvInfo = axw2;
        finderObject2.objectDesc = finderObjectDesc3;
        csp.MxE = finderObject2;
        if (eVar.ApM == 1) {
            csp.LDi = eVar.ApL;
        } else if (eVar.ApM == 4) {
            csp.LDi = eVar.ApQ;
        }
        FinderObject finderObject3 = csp.MxE;
        csp.MxG = (finderObject3 == null || (finderObjectDesc2 = finderObject3.objectDesc) == null) ? null : finderObjectDesc2.mvInfo;
        csp.MxF = j(eVar);
        intent.putExtra("key_track_data", csp.toByteArray());
        com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
        com.tencent.mm.plugin.music.model.c.sm(true);
        com.tencent.mm.plugin.finder.utils.a aVar2 = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.L(getActivity(), intent);
        SecDataUIC.a aVar3 = SecDataUIC.CWq;
        cst cst = (cst) SecDataUIC.a.a(getContext(), 7, cst.class);
        if (cst != null) {
            cst.MxN = 1;
            AppMethodBeat.o(257363);
            return;
        }
        AppMethodBeat.o(257363);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class d implements o.f {
        final /* synthetic */ MusicMvShareUIC Awb;
        final /* synthetic */ boolean Awd;

        public d(MusicMvShareUIC musicMvShareUIC, boolean z) {
            this.Awb = musicMvShareUIC;
            this.Awd = z;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            boolean z;
            boolean z2;
            boolean z3;
            AppMethodBeat.i(257355);
            String string = this.Awb.getContext().getString(R.string.yz);
            int color = this.Awb.getContext().getResources().getColor(R.color.Brand);
            if (!this.Awd) {
                z = true;
            } else {
                z = false;
            }
            mVar.a(101, string, R.raw.finder_full_share, color, z);
            String string2 = this.Awb.getContext().getString(R.string.f9y);
            if (!this.Awd) {
                z2 = true;
            } else {
                z2 = false;
            }
            mVar.a(102, string2, R.raw.bottomsheet_icon_moment, 0, z2);
            String string3 = this.Awb.getContext().getString(R.string.f8b);
            if (!this.Awd) {
                z3 = true;
            } else {
                z3 = false;
            }
            mVar.a(103, string3, R.raw.bottomsheet_icon_fav, 0, z3);
            AppMethodBeat.o(257355);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class e implements o.f {
        final /* synthetic */ MusicMvShareUIC Awb;
        final /* synthetic */ com.tencent.mm.plugin.mv.a.e Awc;
        final /* synthetic */ boolean Awd;
        final /* synthetic */ boolean Awe;
        final /* synthetic */ boolean Awf;

        public e(MusicMvShareUIC musicMvShareUIC, boolean z, boolean z2, com.tencent.mm.plugin.mv.a.e eVar, boolean z3) {
            this.Awb = musicMvShareUIC;
            this.Awe = z;
            this.Awf = z2;
            this.Awc = eVar;
            this.Awd = z3;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            boolean z;
            AppMethodBeat.i(257356);
            mVar.a(201, this.Awb.getContext().getString(R.string.f8y), R.raw.icons_outlined_mv_making_share, this.Awb.getContext().getResources().getColor(R.color.fo), !this.Awe);
            if (this.Awf) {
                e.a aVar = com.tencent.mm.plugin.mv.a.e.ApR;
                if (e.a.b(this.Awc)) {
                    mVar.a(203, (CharSequence) this.Awb.getContext().getString(R.string.f8p), R.raw.icons_outlined_report_problem, this.Awb.getContext().getResources().getColor(R.color.fo), false);
                    AppMethodBeat.o(257356);
                    return;
                }
            } else {
                String string = this.Awb.getContext().getString(R.string.cln);
                int color = this.Awb.getContext().getResources().getColor(R.color.fo);
                if (!this.Awd) {
                    z = true;
                } else {
                    z = false;
                }
                mVar.a(202, string, R.raw.icons_outlined_delete, color, z);
            }
            AppMethodBeat.o(257356);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class f implements o.g {
        final /* synthetic */ MusicMvShareUIC Awb;
        final /* synthetic */ com.tencent.mm.plugin.mv.a.e Awc;

        public f(MusicMvShareUIC musicMvShareUIC, com.tencent.mm.plugin.mv.a.e eVar) {
            this.Awb = musicMvShareUIC;
            this.Awc = eVar;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            int i3 = 0;
            AppMethodBeat.i(257357);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 101:
                    FinderContact finderContact = this.Awc.ApJ;
                    if (finderContact != null) {
                        i3 = finderContact.extFlag;
                    }
                    if ((i3 & 1024) != 0) {
                        y yVar = y.vXH;
                        String string = this.Awb.getActivity().getString(R.string.d61);
                        p.g(string, "activity.getString(com.t…finder_private_ban_share)");
                        y.aF(this.Awb.getActivity(), string);
                        AppMethodBeat.o(257357);
                        return;
                    }
                    MusicMvShareUIC.a(this.Awb, this.Awc);
                    AppMethodBeat.o(257357);
                    return;
                case 102:
                    FinderContact finderContact2 = this.Awc.ApJ;
                    if (finderContact2 != null) {
                        i3 = finderContact2.extFlag;
                    }
                    if ((i3 & 1024) != 0) {
                        y yVar2 = y.vXH;
                        String string2 = this.Awb.getActivity().getString(R.string.d61);
                        p.g(string2, "activity.getString(com.t…finder_private_ban_share)");
                        y.aF(this.Awb.getActivity(), string2);
                        AppMethodBeat.o(257357);
                        return;
                    }
                    MusicMvShareUIC.b(this.Awb, this.Awc);
                    AppMethodBeat.o(257357);
                    return;
                case 103:
                    MusicMvShareUIC.c(this.Awb, this.Awc);
                    break;
            }
            AppMethodBeat.o(257357);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", FirebaseAnalytics.b.INDEX, "", "onMMMenuItemSelected"})
    public static final class g implements o.g {
        final /* synthetic */ MusicMvShareUIC Awb;
        final /* synthetic */ com.tencent.mm.plugin.mv.a.e Awc;

        public g(MusicMvShareUIC musicMvShareUIC, com.tencent.mm.plugin.mv.a.e eVar) {
            this.Awb = musicMvShareUIC;
            this.Awc = eVar;
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(257359);
            p.g(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case 201:
                    this.Awb.i(this.Awc);
                    AppMethodBeat.o(257359);
                    return;
                case 202:
                    f.a aVar = new f.a(this.Awb.getContext());
                    aVar.bow(this.Awb.getContext().getString(R.string.f8j)).apa(R.string.tf).apb(this.Awb.getContext().getResources().getColor(R.color.a5e)).boB(this.Awb.getContext().getString(R.string.sz)).apc(this.Awb.getContext().getResources().getColor(R.color.a2x));
                    aVar.c(new f.c(this) {
                        /* class com.tencent.mm.plugin.mv.ui.uic.MusicMvShareUIC.g.AnonymousClass1 */
                        final /* synthetic */ g Awg;

                        {
                            this.Awg = r1;
                        }

                        @Override // com.tencent.mm.ui.widget.a.f.c
                        public final void e(boolean z, String str) {
                            Long l;
                            String str2;
                            AppMethodBeat.i(257358);
                            if (z) {
                                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                                com.tencent.mm.plugin.mv.a.e eVar = this.Awg.Awc;
                                p.h(eVar, "musicMv");
                                Log.i(((MusicMvMainUIC) com.tencent.mm.ui.component.a.b(this.Awg.Awb.getActivity()).get(MusicMvMainUIC.class)).TAG, "deleteMv " + eVar.ApE + ' ' + eVar.ApF + ' ' + eVar.ApM);
                                if (eVar.ApM == 1) {
                                    Long l2 = eVar.ApE;
                                    String str3 = eVar.ApF;
                                    if (!(l2 == null || str3 == null)) {
                                        long longValue = l2.longValue();
                                        t azz = com.tencent.mm.kernel.g.azz();
                                        String aUg = z.aUg();
                                        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
                                        azz.b(new av(aUg, longValue, str3, false));
                                        AppMethodBeat.o(257358);
                                        return;
                                    }
                                } else if (eVar.ApM == 4) {
                                    FinderObject finderObject = eVar.ApP;
                                    if (finderObject != null) {
                                        l = Long.valueOf(finderObject.id);
                                    } else {
                                        l = null;
                                    }
                                    FinderObject finderObject2 = eVar.ApP;
                                    if (finderObject2 != null) {
                                        str2 = finderObject2.objectNonceId;
                                    } else {
                                        str2 = null;
                                    }
                                    if (!(l == null || str2 == null)) {
                                        long longValue2 = l.longValue();
                                        t azz2 = com.tencent.mm.kernel.g.azz();
                                        String aUg2 = z.aUg();
                                        p.g(aUg2, "ConfigStorageLogic.getMyFinderUsername()");
                                        azz2.b(new av(aUg2, longValue2, str2, false));
                                    }
                                }
                            }
                            AppMethodBeat.o(257358);
                        }
                    }).show();
                    AppMethodBeat.o(257359);
                    return;
                case 203:
                    Long l = this.Awc.ApE;
                    if (l != null) {
                        com.tencent.mm.plugin.music.model.m.bk(this.Awb.getContext(), com.tencent.mm.ac.d.zs(l.longValue()));
                        AppMethodBeat.o(257359);
                        return;
                    }
                    break;
            }
            AppMethodBeat.o(257359);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class h implements e.b {
        public static final h Awh = new h();

        static {
            AppMethodBeat.i(257360);
            AppMethodBeat.o(257360);
        }

        h() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    public static final class j implements MMActivity.a {
        final /* synthetic */ com.tencent.mm.plugin.mv.a.e Awc;

        j(com.tencent.mm.plugin.mv.a.e eVar) {
            this.Awc = eVar;
        }

        @Override // com.tencent.mm.ui.MMActivity.a
        public final void d(int i2, int i3, Intent intent) {
            AppMethodBeat.i(257362);
            if (i2 == 1 && i3 == -1) {
                e.a aVar = com.tencent.mm.plugin.mv.a.e.ApR;
                FinderObject a2 = e.a.a(this.Awc);
                if (a2 != null) {
                    LinkedList linkedList = new LinkedList();
                    String zs = com.tencent.mm.ac.d.zs(a2.id);
                    String str = a2.objectNonceId;
                    if (str == null) {
                        str = "";
                    }
                    linkedList.add(new Pair(zs, str));
                    ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).shareStatsReport(linkedList, false);
                    StringBuilder append = new StringBuilder("share mv success ").append(com.tencent.mm.ac.d.zs(a2.id)).append(' ');
                    String str2 = a2.objectNonceId;
                    if (str2 == null) {
                        str2 = "";
                    }
                    Log.i("MicroMsg.Mv.MusicMvShareUIC", append.append(str2).toString());
                    AppMethodBeat.o(257362);
                    return;
                }
            }
            AppMethodBeat.o(257362);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\b"}, hxF = {"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "mmOnActivityResult"})
    public static final class i implements MMActivity.a {
        final /* synthetic */ MusicMvShareUIC Awb;
        final /* synthetic */ com.tencent.mm.plugin.mv.a.e Awc;

        i(MusicMvShareUIC musicMvShareUIC, com.tencent.mm.plugin.mv.a.e eVar) {
            this.Awb = musicMvShareUIC;
            this.Awc = eVar;
        }

        @Override // com.tencent.mm.ui.MMActivity.a
        public final void d(int i2, int i3, Intent intent) {
            AppMethodBeat.i(257361);
            if (2 == i2 && i3 == -1) {
                Toast.makeText(this.Awb.getContext(), this.Awb.getContext().getResources().getString(R.string.h0k), 0).show();
                e.a aVar = com.tencent.mm.plugin.mv.a.e.ApR;
                FinderObject a2 = e.a.a(this.Awc);
                if (a2 != null) {
                    LinkedList linkedList = new LinkedList();
                    String zs = com.tencent.mm.ac.d.zs(a2.id);
                    String str = a2.objectNonceId;
                    if (str == null) {
                        str = "";
                    }
                    linkedList.add(new Pair(zs, str));
                    ((PluginFinder) com.tencent.mm.kernel.g.ah(PluginFinder.class)).shareStatsReport(linkedList, false);
                    StringBuilder append = new StringBuilder("share mv to sns success ").append(com.tencent.mm.ac.d.zs(a2.id)).append(' ');
                    String str2 = a2.objectNonceId;
                    if (str2 == null) {
                        str2 = "";
                    }
                    Log.i("MicroMsg.Mv.MusicMvShareUIC", append.append(str2).toString());
                    AppMethodBeat.o(257361);
                    return;
                }
            }
            AppMethodBeat.o(257361);
        }
    }

    private final String j(com.tencent.mm.plugin.mv.a.e eVar) {
        boolean z;
        boolean z2;
        String str;
        boolean z3;
        String str2;
        AppMethodBeat.i(257364);
        String str3 = eVar.ApD;
        if (str3 != null) {
            if (str3.length() > 0) {
                str2 = str3;
            } else {
                str2 = null;
            }
            if (str2 != null && s.YS(str2)) {
                AppMethodBeat.o(257364);
                return str2;
            }
        }
        String str4 = eVar.coverUrl;
        if (str4 != null) {
            if (str4.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (!z3) {
                str4 = null;
            }
            if (str4 != null) {
                com.tencent.mm.plugin.mv.ui.a aVar = com.tencent.mm.plugin.mv.ui.a.ArA;
                String aIo = com.tencent.mm.plugin.mv.ui.a.aIo(str4);
                if (s.YS(aIo)) {
                    AppMethodBeat.o(257364);
                    return aIo;
                }
            }
        }
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(getActivity()).get(MusicMvDataUIC.class);
        p.g(viewModel, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
        MusicMvDataUIC musicMvDataUIC = (MusicMvDataUIC) viewModel;
        String str5 = musicMvDataUIC.Atr.thumbPath;
        if (str5 != null) {
            if (str5.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                str = str5;
            } else {
                str = null;
            }
            if (str != null && s.YS(str)) {
                AppMethodBeat.o(257364);
                return str;
            }
        }
        String str6 = musicMvDataUIC.Aqo.Djf;
        if (str6 != null) {
            p.g(str6, LocaleUtil.ITALIAN);
            if (str6.length() > 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                str6 = null;
            }
            if (str6 != null) {
                com.tencent.mm.plugin.mv.ui.a aVar3 = com.tencent.mm.plugin.mv.ui.a.ArA;
                p.g(str6, "url");
                String aIo2 = com.tencent.mm.plugin.mv.ui.a.aIo(str6);
                if (s.YS(aIo2)) {
                    AppMethodBeat.o(257364);
                    return aIo2;
                }
            }
        }
        AppMethodBeat.o(257364);
        return null;
    }

    public static final /* synthetic */ void a(MusicMvShareUIC musicMvShareUIC, com.tencent.mm.plugin.mv.a.e eVar) {
        LinkedList<FinderMedia> linkedList;
        FinderMedia finderMedia;
        AppMethodBeat.i(257367);
        musicMvShareUIC.AvZ = eVar;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(musicMvShareUIC.getActivity()).get(MusicMvDataUIC.class);
        p.g(viewModel, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
        axy axy = ((MusicMvDataUIC) viewModel).Aqo;
        k.b bVar = new k.b();
        bVar.type = 76;
        bVar.title = axy.BPc;
        bVar.description = axy.lDR;
        bVar.messageExt = axy.extraInfo;
        String str = axy.LIg;
        if (str == null) {
            str = "";
        }
        bVar.url = str;
        bVar.iwH = "";
        String str2 = axy.musicDataUrl;
        if (str2 == null) {
            str2 = "";
        }
        bVar.ixd = str2;
        bVar.ixe = "";
        bVar.appId = axy.LIf;
        com.tencent.mm.pluginsdk.ui.tools.b bVar2 = new com.tencent.mm.pluginsdk.ui.tools.b();
        bVar2.songAlbumUrl = axy.Djf;
        bVar2.songLyric = axy.LIh;
        e.a aVar2 = com.tencent.mm.plugin.mv.a.e.ApR;
        FinderObject a2 = e.a.a(eVar);
        if (a2 != null) {
            bVar2.Ktn = com.tencent.mm.ac.d.zs(a2.id);
            bVar2.Kto = a2.objectNonceId;
            FinderObjectDesc finderObjectDesc = a2.objectDesc;
            if (!(finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = (FinderMedia) kotlin.a.j.kt(linkedList)) == null)) {
                bVar2.Ktp = finderMedia.thumbUrl + finderMedia.thumb_url_token;
            }
            FinderContact finderContact = a2.contact;
            bVar2.Ktq = finderContact != null ? finderContact.nickname : null;
        }
        bVar2.songAlbumUrl = axy.Djf;
        bVar2.songLyric = axy.LIh;
        bVar2.Ktr = axy.lDR;
        bVar2.Kts = axy.albumName;
        bVar2.Ktt = axy.LIi;
        bVar2.Ktu = String.valueOf(axy.LIk);
        bVar2.Ktv = axy.identification;
        bVar2.Alz = axy.duration;
        bVar2.Ktw = axy.extraInfo;
        bVar.a(bVar2);
        String j2 = musicMvShareUIC.j(eVar);
        String a3 = k.b.a(bVar, null, null);
        Intent intent = new Intent();
        intent.putExtra("Retr_Msg_Type", 2);
        intent.putExtra("Retr_Msg_content", a3);
        intent.putExtra("Multi_Retr", true);
        intent.putExtra("Retr_go_to_chattingUI", false);
        intent.putExtra("Retr_show_success_tips", true);
        intent.putExtra("Retr_Msg_thumb_path", j2);
        com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
        com.tencent.mm.plugin.music.model.c.sm(true);
        Activity context = musicMvShareUIC.getContext();
        if (context == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(257367);
            throw tVar;
        }
        com.tencent.mm.br.c.a((MMActivity) context, ".ui.transmit.MsgRetransmitUI", intent, 1, new j(eVar));
        Log.i("MicroMsg.Mv.MusicMvShareUIC", "share mv to chat songName:" + axy.BPc + " mvObjectId:" + bVar2.Ktn + " mvNonceId:" + bVar2.Kto + " mvCoverUrl:" + bVar2.Ktp + " mvMakerFinderNickname:" + bVar2.Ktq + ", localCoverPath: " + j2);
        AppMethodBeat.o(257367);
    }

    public static final /* synthetic */ void b(MusicMvShareUIC musicMvShareUIC, com.tencent.mm.plugin.mv.a.e eVar) {
        css css;
        css css2;
        String str;
        LinkedList<FinderMedia> linkedList;
        FinderMedia finderMedia;
        Bitmap bitmap = null;
        AppMethodBeat.i(257368);
        musicMvShareUIC.AvZ = eVar;
        e.a aVar = com.tencent.mm.plugin.mv.a.e.ApR;
        FinderObject a2 = e.a.a(eVar);
        if (a2 != null) {
            css css3 = new css();
            css3.Ktn = com.tencent.mm.ac.d.zs(a2.id);
            css3.Kto = a2.objectNonceId;
            FinderObjectDesc finderObjectDesc = a2.objectDesc;
            if (!(finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = (FinderMedia) kotlin.a.j.kt(linkedList)) == null)) {
                css3.Ktp = finderMedia.thumbUrl + finderMedia.thumb_url_token;
            }
            FinderContact finderContact = a2.contact;
            css3.Ktq = finderContact != null ? finderContact.nickname : null;
            css = css3;
        } else {
            css = null;
        }
        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
        p.g(euj, "MusicPlayerManager.Instance()");
        com.tencent.mm.ay.f etU = euj.etU();
        String j2 = musicMvShareUIC.j(eVar);
        if (css == null) {
            css2 = new css();
        } else {
            css2 = css;
        }
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(musicMvShareUIC.getActivity()).get(MusicMvDataUIC.class);
        p.g(viewModel, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
        axy axy = ((MusicMvDataUIC) viewModel).Aqo;
        css2.singerName = axy.lDR;
        css2.albumName = axy.albumName;
        css2.musicGenre = axy.LIi;
        css2.issueDate = axy.LIk;
        css2.identification = axy.identification;
        css2.Alz = axy.duration;
        css2.extraInfo = axy.extraInfo;
        p.g(etU, "wrapper");
        AppCompatActivity activity = musicMvShareUIC.getActivity();
        p.h(etU, "musicWrapper");
        p.h(axy, "songInfo");
        p.h(activity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(eVar, "musicMv");
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = etU.jfd;
        wXMusicObject.musicDataUrl = etU.jfb;
        wXMusicObject.musicLowBandUrl = etU.jfc;
        wXMusicObject.musicLowBandDataUrl = etU.jfc;
        wXMusicObject.songAlbumUrl = axy.Djf;
        wXMusicObject.songLyric = axy.LIh;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = axy.BPc;
        wXMediaMessage.description = etU.jeY;
        String str2 = axy.extraInfo;
        if (str2 == null) {
            str2 = "";
        }
        wXMediaMessage.messageExt = str2;
        if (Util.isNullOrNil(j2)) {
            str = com.tencent.mm.plugin.music.model.m.C(etU);
        } else {
            str = j2;
        }
        if (str != null && s.YS(str)) {
            int dimension = (int) activity.getResources().getDimension(R.dimen.ht);
            bitmap = BitmapUtil.getBitmapNative(str, dimension, dimension);
        }
        if (bitmap != null) {
            wXMediaMessage.thumbData = Util.bmpToByteArray(bitmap, true);
        } else {
            int i2 = R.drawable.cvc;
            if (ao.isDarkMode()) {
                i2 = R.drawable.cvb;
            }
            wXMediaMessage.thumbData = Util.bmpToByteArray(BitmapUtil.getBitmapNative(i2), true);
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.message = wXMediaMessage;
        req.toBundle(bundle);
        intent.putExtra("Ksnsupload_timeline", bundle);
        intent.putExtra("Ksnsupload_musicid", etU.jeV);
        if (com.tencent.mm.pluginsdk.model.app.h.bdy(com.tencent.mm.plugin.music.model.m.D(etU))) {
            intent.putExtra("Ksnsupload_appid", com.tencent.mm.plugin.music.model.m.D(etU));
        }
        intent.putExtra("Ksnsupload_appname", com.tencent.mm.plugin.music.model.m.E(etU));
        String JX = ad.JX("music_player");
        ad.aVe().G(JX, true).l("prePublishId", "music_player");
        intent.putExtra("reportSessionId", JX);
        com.tencent.mm.modelsns.i iVar = new com.tencent.mm.modelsns.i();
        iVar.jlj = css2;
        intent.putExtra("Ksnsupload_music_share_object_xml", iVar.bfF());
        intent.putExtra("Ksnsupload_type", 25);
        intent.putExtra("need_result", true);
        com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
        com.tencent.mm.plugin.music.model.c.sm(true);
        com.tencent.mm.br.c.a((MMActivity) activity, ".plugin.sns.ui.SnsUploadUI", intent, 2, new i(musicMvShareUIC, eVar));
        AppMethodBeat.o(257368);
    }

    public static final /* synthetic */ void c(MusicMvShareUIC musicMvShareUIC, com.tencent.mm.plugin.mv.a.e eVar) {
        css css;
        css css2;
        LinkedList<FinderMedia> linkedList;
        FinderMedia finderMedia;
        AppMethodBeat.i(257369);
        musicMvShareUIC.AvZ = eVar;
        e.a aVar = com.tencent.mm.plugin.mv.a.e.ApR;
        FinderObject a2 = e.a.a(eVar);
        if (a2 != null) {
            css css3 = new css();
            css3.Ktn = com.tencent.mm.ac.d.zs(a2.id);
            css3.Kto = a2.objectNonceId;
            FinderObjectDesc finderObjectDesc = a2.objectDesc;
            if (!(finderObjectDesc == null || (linkedList = finderObjectDesc.media) == null || (finderMedia = (FinderMedia) kotlin.a.j.kt(linkedList)) == null)) {
                css3.Ktp = finderMedia.thumbUrl + finderMedia.thumb_url_token;
            }
            FinderContact finderContact = a2.contact;
            css3.Ktq = finderContact != null ? finderContact.nickname : null;
            css = css3;
        } else {
            css = null;
        }
        if (css == null) {
            css2 = new css();
        } else {
            css2 = css;
        }
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(musicMvShareUIC.getActivity()).get(MusicMvDataUIC.class);
        p.g(viewModel, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
        axy axy = ((MusicMvDataUIC) viewModel).Aqo;
        css2.singerName = axy.lDR;
        css2.albumName = axy.albumName;
        css2.musicGenre = axy.LIi;
        css2.issueDate = axy.LIk;
        css2.identification = axy.identification;
        css2.extraInfo = axy.extraInfo;
        css2.Alz = axy.duration;
        com.tencent.mm.plugin.music.e.k euj = com.tencent.mm.plugin.music.e.k.euj();
        p.g(euj, "MusicPlayerManager.Instance()");
        com.tencent.mm.plugin.music.model.m.a(euj.etU(), axy, musicMvShareUIC.getActivity(), css2);
        AppMethodBeat.o(257369);
    }
}
