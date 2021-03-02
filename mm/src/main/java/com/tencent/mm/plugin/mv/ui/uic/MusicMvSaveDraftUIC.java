package com.tencent.mm.plugin.mv.ui.uic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.on;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.h;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.mv.ui.MusicMvRouterUI;
import com.tencent.mm.protocal.protobuf.csp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u001b\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0006J&\u0010\u001f\u001a\u00020\u001c2\b\b\u0002\u0010 \u001a\u00020\u00132\b\b\u0002\u0010!\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\"\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010&H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u000eXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "MENU_ID_NOT_SAVE_DRAFT", "", "getMENU_ID_NOT_SAVE_DRAFT", "()I", "MENU_ID_SAVE_DRAFT", "getMENU_ID_SAVE_DRAFT", "REQUEST_CODE_CREATE_FINDER_DRAFT", "getREQUEST_CODE_CREATE_FINDER_DRAFT", "TAG", "", "getTAG", "()Ljava/lang/String;", "fromScene", "isFinderNew", "", "lastPageId", "mvData", "Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "getMvData", "()Lcom/tencent/mm/protocal/protobuf/MusicMvData;", "setMvData", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "doBack", "", "isEdit", "pageId", "doDraft", "needCreateFinderContact", "needSave", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "plugin-mv_release"})
public final class MusicMvSaveDraftUIC extends UIComponent {
    final int AvS = 1;
    final int AvT = 2;
    private final int AvU = 10031;
    private csp AvV;
    private int AvW = 2;
    private final String TAG = "MicroMsg.Mv.MusicMvSaveDraftUIC";
    private boolean UZP;
    private int fromScene = getIntent().getIntExtra("key_mv_from_scene", 0);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvSaveDraftUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257351);
        AppMethodBeat.o(257351);
    }

    public static final /* synthetic */ void a(MusicMvSaveDraftUIC musicMvSaveDraftUIC, boolean z, boolean z2, csp csp) {
        AppMethodBeat.i(257352);
        musicMvSaveDraftUIC.a(z, z2, csp);
        AppMethodBeat.o(257352);
    }

    public final void a(csp csp, boolean z, int i2) {
        AppMethodBeat.i(257348);
        this.AvW = i2;
        if (z) {
            this.AvV = csp;
            e eVar = new e((Context) getActivity(), 1, true);
            eVar.hbr();
            eVar.j(getResources().getString(R.string.f9o), 17, getResources().getDimensionPixelSize(R.dimen.kc));
            eVar.setBackgroundColor(getContext().getResources().getColor(R.color.a1));
            eVar.a(new a(this));
            eVar.a(new b(this, csp, eVar));
            eVar.b(c.Var);
            eVar.dGm();
            AppMethodBeat.o(257348);
            return;
        }
        Intent intent = new Intent(getActivity(), MusicMvRouterUI.class);
        intent.addFlags(67108864);
        intent.putExtra("KEY_MUSIC_ROUTER", 4);
        getActivity().overridePendingTransition(-1, R.anim.er);
        com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
        com.tencent.mm.plugin.music.model.c.sm(true);
        AppCompatActivity activity = getActivity();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doBack", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doBack", "(Lcom/tencent/mm/protocal/protobuf/MusicMvData;ZI)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        getActivity().finish();
        if (this.fromScene == 1) {
            k euj = k.euj();
            p.g(euj, "MusicPlayerManager.Instance()");
            euj.etW().stopPlay();
        }
        i iVar = i.vfo;
        i.at(i2, false);
        AppMethodBeat.o(257348);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    public static final class a implements o.f {
        final /* synthetic */ MusicMvSaveDraftUIC AvX;

        a(MusicMvSaveDraftUIC musicMvSaveDraftUIC) {
            this.AvX = musicMvSaveDraftUIC;
        }

        @Override // com.tencent.mm.ui.base.o.f
        public final void onCreateMMMenu(m mVar) {
            AppMethodBeat.i(257345);
            mVar.d(this.AvX.AvS, this.AvX.getContext().getResources().getString(R.string.f9n));
            mVar.a(this.AvX.AvT, this.AvX.getColor(R.color.Red), this.AvX.getContext().getResources().getString(R.string.f9m));
            AppMethodBeat.o(257345);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    public static final class b implements o.g {
        final /* synthetic */ MusicMvSaveDraftUIC AvX;
        final /* synthetic */ csp AvY;
        final /* synthetic */ e nkZ;

        b(MusicMvSaveDraftUIC musicMvSaveDraftUIC, csp csp, e eVar) {
            this.AvX = musicMvSaveDraftUIC;
            this.AvY = csp;
            this.nkZ = eVar;
        }

        @Override // com.tencent.mm.ui.base.o.g
        public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
            AppMethodBeat.i(257346);
            p.g(menuItem, "menuItem");
            int itemId = menuItem.getItemId();
            if (itemId == this.AvX.AvS) {
                MusicMvSaveDraftUIC musicMvSaveDraftUIC = this.AvX;
                String aUg = z.aUg();
                musicMvSaveDraftUIC.UZP = aUg == null || aUg.length() == 0;
                MusicMvSaveDraftUIC.a(this.AvX, true, true, this.AvY);
                AppMethodBeat.o(257346);
            } else if (itemId == this.AvX.AvT) {
                this.AvX.UZP = false;
                MusicMvSaveDraftUIC.a(this.AvX, false, false, this.AvY);
                AppMethodBeat.o(257346);
            } else {
                this.nkZ.bMo();
                AppMethodBeat.o(257346);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onDismiss"})
    public static final class c implements e.b {
        public static final c Var = new c();

        static {
            AppMethodBeat.i(259290);
            AppMethodBeat.o(259290);
        }

        c() {
        }

        @Override // com.tencent.mm.ui.widget.a.e.b
        public final void onDismiss() {
            AppMethodBeat.i(257347);
            AppMethodBeat.o(257347);
        }
    }

    private final void a(boolean z, boolean z2, csp csp) {
        AppMethodBeat.i(257349);
        if (z) {
            String aUg = z.aUg();
            if (aUg == null || aUg.length() == 0) {
                y yVar = y.vXH;
                if (y.bE(getActivity())) {
                    Intent intent = new Intent();
                    intent.setClassName(getActivity(), "com.tencent.mm.plugin.finder.ui.FinderCreateContactUI");
                    intent.putExtra("scene", 89);
                    intent.putExtra("key_create_scene", 7);
                    intent.putExtra("key_router_to_profile", false);
                    intent.putExtra("key_mv_status", 1);
                    getActivity().startActivityForResult(intent, this.AvU);
                    AppMethodBeat.o(257349);
                    return;
                }
                AppMethodBeat.o(257349);
            }
        }
        i iVar = i.vfo;
        i.at(this.AvW, z2);
        if (csp != null) {
            csp csp2 = z2 ? csp : null;
            if (csp2 != null) {
                com.tencent.mm.plugin.mv.ui.a aVar = com.tencent.mm.plugin.mv.ui.a.ArA;
                com.tencent.mm.plugin.mv.ui.a.c(csp2);
                h.vDp.a(csp2);
                u.u(getActivity(), getString(R.string.ym), R.raw.icons_filled_done);
            }
        }
        Intent intent2 = new Intent(getActivity(), MusicMvRouterUI.class);
        intent2.addFlags(67108864);
        intent2.putExtra("KEY_MUSIC_ROUTER", 4);
        com.tencent.mm.plugin.music.model.c cVar = com.tencent.mm.plugin.music.model.c.Akc;
        com.tencent.mm.plugin.music.model.c.sm(true);
        AppCompatActivity activity = getActivity();
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
        com.tencent.mm.hellhoundlib.a.a.a(activity, bl.axQ(), "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doDraft", "(ZZLcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        activity.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(activity, "com/tencent/mm/plugin/mv/ui/uic/MusicMvSaveDraftUIC", "doDraft", "(ZZLcom/tencent/mm/protocal/protobuf/MusicMvData;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        getActivity().finish();
        if (this.fromScene == 1) {
            k euj = k.euj();
            p.g(euj, "MusicPlayerManager.Instance()");
            euj.etW().stopPlay();
        }
        com.tencent.mm.plugin.mv.a.l lVar = com.tencent.mm.plugin.mv.a.l.UZs;
        boolean z3 = this.UZP;
        String e2 = com.tencent.mm.plugin.mv.a.m.e(csp);
        p.h(e2, "partList");
        on hWv = com.tencent.mm.plugin.mv.a.l.hWv();
        hWv.PW(z2 ? 1 : 0);
        hWv.bvI(e2);
        hWv.PX(z3 ? 1 : 0);
        hWv.PV(9);
        hWv.bfK();
        com.tencent.mm.util.b bVar = com.tencent.mm.util.b.QYu;
        com.tencent.mm.util.b.a(hWv);
        AppMethodBeat.o(257349);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(257350);
        super.onActivityResult(i2, i3, intent);
        if (i2 == this.AvU) {
            Log.i(this.TAG, "callback create finder contact draft");
            csp csp = this.AvV;
            if (csp != null) {
                a(false, true, csp);
                AppMethodBeat.o(257350);
                return;
            }
        }
        AppMethodBeat.o(257350);
    }
}
