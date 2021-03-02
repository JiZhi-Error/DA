package com.tencent.mm.plugin.mv.ui.uic;

import android.arch.lifecycle.ViewModel;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.mv.a.e;
import com.tencent.mm.plugin.mv.a.k;
import com.tencent.mm.plugin.mv.ui.view.MusicMvCommentFooter;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.csi;
import com.tencent.mm.protocal.protobuf.csk;
import com.tencent.mm.protocal.protobuf.csl;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.a.ak;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00142\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\u001fH\u0002J\b\u0010$\u001a\u00020\u001fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR#\u0010\u000e\u001a\n \t*\u0004\u0018\u00010\u000f0\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R#\u0010\u0015\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0016\u0010\u000bR\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "chatMaxFooter", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "getChatMaxFooter", "()Landroid/view/ViewGroup;", "chatMaxFooter$delegate", "Lkotlin/Lazy;", "commentFooter", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "getCommentFooter", "()Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "commentFooter$delegate", "commentInput", "Landroid/view/View;", "commentRoot", "getCommentRoot", "commentRoot$delegate", "commentView", "isInput", "", "itemView", "viewRecord", "Lcom/tencent/mm/plugin/mv/ui/uic/VisibleRecord;", "bindView", "", "parent", "item", "Lcom/tencent/mm/plugin/mv/ui/convert/MvConvertData;", "exitInputComment", "startInputComment", "plugin-mv_release"})
public final class MusicMvCommentUIC extends UIComponent {
    private final kotlin.f Atg;
    private final kotlin.f Ath;
    private final kotlin.f Ati;
    private View Atj;
    private View Atk;
    private final c Atl;
    private boolean Atm;
    private final String TAG = "MicroMsg.MusicMvCommentUIC";
    private View aus;

    private final ViewGroup evL() {
        AppMethodBeat.i(257102);
        ViewGroup viewGroup = (ViewGroup) this.Atg.getValue();
        AppMethodBeat.o(257102);
        return viewGroup;
    }

    private final MusicMvCommentFooter evM() {
        AppMethodBeat.i(257103);
        MusicMvCommentFooter musicMvCommentFooter = (MusicMvCommentFooter) this.Ath.getValue();
        AppMethodBeat.o(257103);
        return musicMvCommentFooter;
    }

    private final ViewGroup evN() {
        AppMethodBeat.i(257104);
        ViewGroup viewGroup = (ViewGroup) this.Ati.getValue();
        AppMethodBeat.o(257104);
        return viewGroup;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MusicMvCommentUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(257106);
        this.Atg = g.ah(new d(appCompatActivity));
        this.Ath = g.ah(new e(appCompatActivity));
        this.Ati = g.ah(new f(appCompatActivity));
        this.Atl = new c();
        AppMethodBeat.o(257106);
    }

    public final void a(View view, com.tencent.mm.plugin.mv.ui.a.b bVar) {
        TextView textView;
        View view2;
        ViewParent viewParent;
        ViewGroup viewGroup;
        AppMethodBeat.i(257105);
        p.h(bVar, "item");
        Log.i(this.TAG, "bindView: ");
        View view3 = this.Atj;
        if (view3 != null) {
            view3.setOnClickListener(null);
        }
        if (!this.Atm) {
            this.Atk = view != null ? view.findViewById(R.id.b8k) : null;
        } else if (this.aus != null && (!p.j(this.aus, view))) {
            View view4 = this.Atk;
            ViewGroup viewGroup2 = (ViewGroup) (view4 != null ? view4.getParent() : null);
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.Atk);
            }
            View view5 = this.aus;
            if (!(view5 == null || (viewGroup = (ViewGroup) view5.findViewById(R.id.fem)) == null)) {
                viewGroup.addView(this.Atk);
            }
            if (view != null) {
                view2 = view.findViewById(R.id.b8k);
            } else {
                view2 = null;
            }
            this.Atk = view2;
            View view6 = this.Atk;
            if (view6 != null) {
                viewParent = view6.getParent();
            } else {
                viewParent = null;
            }
            ViewGroup viewGroup3 = (ViewGroup) viewParent;
            if (viewGroup3 != null) {
                viewGroup3.removeView(this.Atk);
            }
            evN().addView(this.Atk);
        }
        this.aus = view;
        View view7 = this.aus;
        if (view7 != null) {
            textView = (TextView) view7.findViewById(R.id.b90);
        } else {
            textView = null;
        }
        this.Atj = textView;
        View view8 = this.Atj;
        if (view8 != null) {
            view8.setOnClickListener(new a(this));
        }
        evL().setOnClickListener(new b(this));
        evM().setOnCommentSendImp(new c(this, bVar));
        AppMethodBeat.o(257105);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a implements View.OnClickListener {
        final /* synthetic */ MusicMvCommentUIC Atn;

        a(MusicMvCommentUIC musicMvCommentUIC) {
            this.Atn = musicMvCommentUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257096);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            Log.i(this.Atn.TAG, "click comment input");
            MusicMvCommentUIC.b(this.Atn);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257096);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b implements View.OnClickListener {
        final /* synthetic */ MusicMvCommentUIC Atn;

        b(MusicMvCommentUIC musicMvCommentUIC) {
            this.Atn = musicMvCommentUIC;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(257097);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            MusicMvCommentUIC.c(this.Atn);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(257097);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/mv/ui/uic/MusicMvCommentUIC$bindView$3", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter$IOnCommentSend;", "onCommentSend", "", "toSendText", "", "emojiMd5", "plugin-mv_release"})
    public static final class c implements MusicMvCommentFooter.b {
        final /* synthetic */ com.tencent.mm.plugin.mv.ui.a.b Asf;
        final /* synthetic */ MusicMvCommentUIC Atn;

        c(MusicMvCommentUIC musicMvCommentUIC, com.tencent.mm.plugin.mv.ui.a.b bVar) {
            this.Atn = musicMvCommentUIC;
            this.Asf = bVar;
        }

        @Override // com.tencent.mm.plugin.mv.ui.view.MusicMvCommentFooter.b
        public final void aIq(String str) {
            String str2;
            AppMethodBeat.i(257098);
            if (str != null) {
                if (!(str.length() > 0)) {
                    str = null;
                }
                if (str != null) {
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    MusicMvChattingUIC musicMvChattingUIC = (MusicMvChattingUIC) com.tencent.mm.ui.component.a.b(this.Atn.getActivity()).get(MusicMvChattingUIC.class);
                    com.tencent.mm.plugin.mv.a.e eVar = this.Asf.ArY;
                    p.h(str, "toSendText");
                    p.h(eVar, "musicMv");
                    String str3 = musicMvChattingUIC.AqO;
                    if (str3 != null && !Util.isNullOrNil(str)) {
                        csk csk = new csk();
                        csi csi = new csi();
                        csi.type = 1;
                        csi.Mxp = new csl();
                        csl csl = csi.Mxp;
                        if (csl != null) {
                            csl.text = str;
                        }
                        csk.BcW = String.valueOf(cl.aWA());
                        csk.MwX = str3;
                        csk.Mxt = z.aUa();
                        csk.Mxr = csi;
                        csk.createtime = (int) (System.currentTimeMillis() / 1000);
                        e.a aVar2 = com.tencent.mm.plugin.mv.a.e.ApR;
                        FinderObject a2 = e.a.a(eVar);
                        if (a2 != null) {
                            csk.Mxv = a2.id;
                            csk.LGs = a2.objectNonceId;
                            FinderContact finderContact = a2.contact;
                            if (finderContact == null || (str2 = finderContact.nickname) == null) {
                                str2 = "";
                            }
                            csk.Mxw = str2;
                        }
                        Log.i("MicroMsg.Mv.MusicMvChattingUIC", "postLiveMsg msg.objectId:" + csk.Mxv + " msg.objectNonceId:" + csk.LGs);
                        com.tencent.mm.plugin.mv.a.a.l lVar = musicMvChattingUIC.Ata;
                        if (lVar != null) {
                            com.tencent.mm.kernel.g.azz().a(lVar);
                        }
                        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
                        musicMvChattingUIC.Ata = new com.tencent.mm.plugin.mv.a.a.l(csk, ((MusicMvDataUIC) com.tencent.mm.ui.component.a.b(musicMvChattingUIC.getActivity()).get(MusicMvDataUIC.class)).Aqo, musicMvChattingUIC.getActivity().hashCode());
                        com.tencent.mm.kernel.g.azz().b(musicMvChattingUIC.Ata);
                        com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
                        ViewModel viewModel = com.tencent.mm.ui.component.a.b(musicMvChattingUIC.getActivity()).get(MusicMvDataUIC.class);
                        p.g(viewModel, "UICProvider.of(activity)…sicMvDataUIC::class.java)");
                        k kVar = k.Aql;
                        k.b(musicMvChattingUIC.getContext(), ((MusicMvDataUIC) viewModel).Aqo, eVar, 1, 0);
                    }
                }
            }
            MusicMvCommentUIC.c(this.Atn);
            AppMethodBeat.o(257098);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(257099);
            ViewGroup viewGroup = (ViewGroup) this.uQi.findViewById(R.id.ax4);
            AppMethodBeat.o(257099);
            return viewGroup;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/mv/ui/view/MusicMvCommentFooter;", "kotlin.jvm.PlatformType", "invoke"})
    static final class e extends q implements kotlin.g.a.a<MusicMvCommentFooter> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MusicMvCommentFooter invoke() {
            AppMethodBeat.i(257100);
            MusicMvCommentFooter musicMvCommentFooter = (MusicMvCommentFooter) this.uQi.findViewById(R.id.av5);
            AppMethodBeat.o(257100);
            return musicMvCommentFooter;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Landroid/view/ViewGroup;", "kotlin.jvm.PlatformType", "invoke"})
    static final class f extends q implements kotlin.g.a.a<ViewGroup> {
        final /* synthetic */ AppCompatActivity uQi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AppCompatActivity appCompatActivity) {
            super(0);
            this.uQi = appCompatActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ ViewGroup invoke() {
            AppMethodBeat.i(257101);
            ViewGroup viewGroup = (ViewGroup) this.uQi.findViewById(R.id.fb4);
            AppMethodBeat.o(257101);
            return viewGroup;
        }
    }

    public static final /* synthetic */ void b(MusicMvCommentUIC musicMvCommentUIC) {
        AppMethodBeat.i(257107);
        musicMvCommentUIC.Atm = true;
        View view = musicMvCommentUIC.aus;
        if (view != null) {
            musicMvCommentUIC.Atl.eD(view).s(ak.setOf((Object[]) new Integer[]{Integer.valueOf((int) R.id.ax5), Integer.valueOf((int) R.id.av5), Integer.valueOf((int) R.id.dol), Integer.valueOf((int) R.id.f5j), Integer.valueOf((int) R.id.bi3)}));
        }
        ViewGroup evL = musicMvCommentUIC.evL();
        p.g(evL, "chatMaxFooter");
        evL.setVisibility(0);
        MusicMvCommentFooter evM = musicMvCommentUIC.evM();
        p.g(evM, "commentFooter");
        evM.setVisibility(0);
        ViewGroup evL2 = musicMvCommentUIC.evL();
        p.g(evL2, "chatMaxFooter");
        evL2.setAlpha(0.0f);
        musicMvCommentUIC.evL().animate().alpha(1.0f).setDuration(200).start();
        View view2 = musicMvCommentUIC.Atk;
        ViewGroup viewGroup = (ViewGroup) (view2 != null ? view2.getParent() : null);
        if (viewGroup != null) {
            viewGroup.removeView(musicMvCommentUIC.Atk);
        }
        musicMvCommentUIC.evN().addView(musicMvCommentUIC.Atk);
        AppMethodBeat.o(257107);
    }

    public static final /* synthetic */ void c(MusicMvCommentUIC musicMvCommentUIC) {
        ViewGroup viewGroup;
        AppMethodBeat.i(257108);
        musicMvCommentUIC.Atm = false;
        musicMvCommentUIC.Atl.restore();
        ViewGroup evL = musicMvCommentUIC.evL();
        p.g(evL, "chatMaxFooter");
        evL.setVisibility(8);
        MusicMvCommentFooter evM = musicMvCommentUIC.evM();
        p.g(evM, "commentFooter");
        evM.setVisibility(8);
        View view = musicMvCommentUIC.Atk;
        ViewGroup viewGroup2 = (ViewGroup) (view != null ? view.getParent() : null);
        if (viewGroup2 != null) {
            viewGroup2.removeView(musicMvCommentUIC.Atk);
        }
        View view2 = musicMvCommentUIC.aus;
        if (view2 == null || (viewGroup = (ViewGroup) view2.findViewById(R.id.fem)) == null) {
            AppMethodBeat.o(257108);
            return;
        }
        viewGroup.addView(musicMvCommentUIC.Atk);
        AppMethodBeat.o(257108);
    }
}
