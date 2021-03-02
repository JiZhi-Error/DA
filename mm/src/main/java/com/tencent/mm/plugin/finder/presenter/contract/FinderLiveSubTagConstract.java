package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.convert.at;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class FinderLiveSubTagConstract {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0016\u0010+\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\bJ\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u0002H\u0016J\b\u0010/\u001a\u00020-H\u0016R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001f\"\u0004\b\"\u0010#R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;", "parentTag", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "tagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "hasNextAction", "", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;Ljava/util/ArrayList;Z)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "convert", "Lcom/tencent/mm/plugin/finder/convert/FinderLiveSubTagConvert;", "getHasNextAction", "()Z", "setHasNextAction", "(Z)V", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "getParentTag", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "selectedTag", "getSelectedTag", "setSelectedTag", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;)V", "getTagData", "()Ljava/util/ArrayList;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;)V", "getData", "onAttach", "", "callback", "onDetach", "Companion", "plugin-finder_release"})
    public static final class Presenter implements a<ViewCallback> {
        public static final Companion uXw = new Companion((byte) 0);
        public g liveData;
        public WxRecyclerAdapter<bo> tFp;
        axk uXq;
        private at uXr;
        ViewCallback uXs;
        final axk uXt;
        private final ArrayList<bo> uXu;
        boolean uXv;

        static {
            AppMethodBeat.i(249809);
            AppMethodBeat.o(249809);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(byte b2) {
                this();
            }
        }

        public Presenter(axk axk, ArrayList<bo> arrayList, boolean z) {
            p.h(arrayList, "tagData");
            AppMethodBeat.i(249808);
            this.uXt = axk;
            this.uXu = arrayList;
            this.uXv = z;
            AppMethodBeat.o(249808);
        }

        public static final /* synthetic */ at a(Presenter presenter) {
            AppMethodBeat.i(249810);
            at atVar = presenter.uXr;
            if (atVar == null) {
                p.btv("convert");
            }
            AppMethodBeat.o(249810);
            return atVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(ViewCallback viewCallback) {
            AppMethodBeat.i(249807);
            a(viewCallback);
            AppMethodBeat.o(249807);
        }

        public final g getLiveData() {
            AppMethodBeat.i(249805);
            g gVar = this.liveData;
            if (gVar == null) {
                p.btv("liveData");
            }
            AppMethodBeat.o(249805);
            return gVar;
        }

        public final void a(ViewCallback viewCallback) {
            AppMethodBeat.i(249806);
            p.h(viewCallback, "callback");
            StringBuilder sb = new StringBuilder("onAttach parentTag:");
            axk axk = this.uXt;
            Log.i("FinderLiveSubTagConstract.Presenter", sb.append(axk != null ? axk.qHk : null).append(" tagData:").append(this.uXu).append(" hasNextAction:").append(this.uXv).toString());
            o oVar = o.ujN;
            g dfZ = o.dfZ();
            if (dfZ == null) {
                dfZ = new g();
            }
            this.liveData = dfZ;
            g gVar = this.liveData;
            if (gVar == null) {
                p.btv("liveData");
            }
            this.uXq = gVar.uix;
            this.uXr = new at(this.uXq);
            WxRecyclerAdapter<bo> wxRecyclerAdapter = new WxRecyclerAdapter<>(new FinderLiveSubTagConstract$Presenter$onAttach$1(this), this.uXu);
            wxRecyclerAdapter.RqP = new FinderLiveSubTagConstract$Presenter$onAttach$$inlined$apply$lambda$1(this);
            this.tFp = wxRecyclerAdapter;
            this.uXs = viewCallback;
            ViewCallback viewCallback2 = this.uXs;
            if (viewCallback2 != null) {
                View findViewById = viewCallback2.activity.findViewById(R.id.cxy);
                p.g(findViewById, "activity.findViewById(R.…r_live_sub_tag_ui_header)");
                viewCallback2.uXy = (RelativeLayout) findViewById;
                View findViewById2 = viewCallback2.activity.findViewById(R.id.cy0);
                p.g(findViewById2, "activity.findViewById(R.…sub_tag_ui_header_cancel)");
                viewCallback2.uXz = (WeImageView) findViewById2;
                View findViewById3 = viewCallback2.activity.findViewById(R.id.cy1);
                p.g(findViewById3, "activity.findViewById(R.…_sub_tag_ui_header_title)");
                viewCallback2.titleTv = (TextView) findViewById3;
                View findViewById4 = viewCallback2.activity.findViewById(R.id.cxz);
                p.g(findViewById4, "activity.findViewById(R.…tag_ui_header_action_btn)");
                viewCallback2.uXA = (TextView) findViewById4;
                View findViewById5 = viewCallback2.activity.findViewById(R.id.cxx);
                p.g(findViewById5, "activity.findViewById(R.…_live_sub_tag_ui_content)");
                viewCallback2.uXB = (RecyclerView) findViewById5;
                RecyclerView recyclerView = viewCallback2.uXB;
                if (recyclerView == null) {
                    p.btv("tagRecyclerView");
                }
                recyclerView.setLayoutManager(new LinearLayoutManager());
                RecyclerView recyclerView2 = viewCallback2.uXB;
                if (recyclerView2 == null) {
                    p.btv("tagRecyclerView");
                }
                WxRecyclerAdapter<bo> wxRecyclerAdapter2 = viewCallback2.uXC.tFp;
                if (wxRecyclerAdapter2 == null) {
                    p.btv("adapter");
                }
                recyclerView2.setAdapter(wxRecyclerAdapter2);
                RecyclerView recyclerView3 = viewCallback2.uXB;
                if (recyclerView3 == null) {
                    p.btv("tagRecyclerView");
                }
                ViewGroup.LayoutParams layoutParams = recyclerView3.getLayoutParams();
                if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                if (marginLayoutParams != null) {
                    marginLayoutParams.bottomMargin = au.aD(viewCallback2.activity) + marginLayoutParams.bottomMargin;
                }
                TextView textView = viewCallback2.titleTv;
                if (textView == null) {
                    p.btv("titleTv");
                }
                axk axk2 = viewCallback2.uXC.uXt;
                textView.setText(axk2 != null ? axk2.qHk : null);
                RelativeLayout relativeLayout = viewCallback2.uXy;
                if (relativeLayout == null) {
                    p.btv(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER);
                }
                ViewGroup.LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
                if (!(layoutParams2 instanceof ViewGroup.MarginLayoutParams)) {
                    layoutParams2 = null;
                }
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                if (marginLayoutParams2 != null) {
                    marginLayoutParams2.topMargin = au.getStatusBarHeight(viewCallback2.activity) + marginLayoutParams2.topMargin;
                }
                WeImageView weImageView = viewCallback2.uXz;
                if (weImageView == null) {
                    p.btv("cancelBtn");
                }
                weImageView.setOnClickListener(new FinderLiveSubTagConstract$ViewCallback$initView$3(viewCallback2));
                viewCallback2.dlV();
                if (viewCallback2.uXC.uXv) {
                    TextView textView2 = viewCallback2.uXA;
                    if (textView2 == null) {
                        p.btv("actionBtn");
                    }
                    AppCompatActivity context = viewCallback2.activity.getContext();
                    p.g(context, "activity.context");
                    textView2.setText(context.getResources().getString(R.string.d_y));
                } else {
                    TextView textView3 = viewCallback2.uXA;
                    if (textView3 == null) {
                        p.btv("actionBtn");
                    }
                    AppCompatActivity context2 = viewCallback2.activity.getContext();
                    p.g(context2, "activity.context");
                    textView3.setText(context2.getResources().getString(R.string.vl));
                }
                TextView textView4 = viewCallback2.uXA;
                if (textView4 == null) {
                    p.btv("actionBtn");
                }
                textView4.setOnClickListener(new FinderLiveSubTagConstract$ViewCallback$initView$4(viewCallback2));
                AppMethodBeat.o(249806);
                return;
            }
            AppMethodBeat.o(249806);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0002H\u0016J\u0006\u0010$\u001a\u00020%J\u0006\u0010&\u001a\u00020%R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\f¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$Presenter;)V", "actionBtn", "Landroid/widget/TextView;", "getActionBtn", "()Landroid/widget/TextView;", "setActionBtn", "(Landroid/widget/TextView;)V", "cancelBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getCancelBtn", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setCancelBtn", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "Landroid/widget/RelativeLayout;", "getHeader", "()Landroid/widget/RelativeLayout;", "setHeader", "(Landroid/widget/RelativeLayout;)V", "tagRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getTagRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setTagRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "titleTv", "getTitleTv", "setTitleTv", "getActivity", "getPresenter", "initView", "", "refreshActionBtn", "Companion", "plugin-finder_release"})
    public static final class ViewCallback implements c<Presenter> {
        public static final Companion uXD = new Companion((byte) 0);
        final MMActivity activity;
        public TextView titleTv;
        public TextView uXA;
        public RecyclerView uXB;
        final Presenter uXC;
        public RelativeLayout uXy;
        public WeImageView uXz;

        static {
            AppMethodBeat.i(249815);
            AppMethodBeat.o(249815);
        }

        public ViewCallback(MMActivity mMActivity, Presenter presenter) {
            p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(presenter, "presenter");
            AppMethodBeat.i(249814);
            this.activity = mMActivity;
            this.uXC = presenter;
            AppMethodBeat.o(249814);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveSubTagConstract$ViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(byte b2) {
                this();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
            if ((r0 == null || r0.length() == 0) == false) goto L_0x002d;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void dlV() {
            /*
                r5 = this;
                r4 = 249813(0x3cfd5, float:3.50063E-40)
                r2 = 1
                r3 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                android.widget.TextView r1 = r5.uXA
                if (r1 != 0) goto L_0x0012
                java.lang.String r0 = "actionBtn"
                kotlin.g.b.p.btv(r0)
            L_0x0012:
                com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract$Presenter r0 = r5.uXC
                com.tencent.mm.protocal.protobuf.axk r0 = r0.uXq
                if (r0 == 0) goto L_0x0038
                com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract$Presenter r0 = r5.uXC
                com.tencent.mm.protocal.protobuf.axk r0 = r0.uXq
                if (r0 == 0) goto L_0x0034
                java.lang.String r0 = r0.qHk
            L_0x0020:
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                if (r0 == 0) goto L_0x002a
                int r0 = r0.length()
                if (r0 != 0) goto L_0x0036
            L_0x002a:
                r0 = r2
            L_0x002b:
                if (r0 != 0) goto L_0x0038
            L_0x002d:
                r1.setEnabled(r2)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                return
            L_0x0034:
                r0 = 0
                goto L_0x0020
            L_0x0036:
                r0 = r3
                goto L_0x002b
            L_0x0038:
                r0 = r1
                r2 = r3
                r1 = r0
                goto L_0x002d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.presenter.contract.FinderLiveSubTagConstract.ViewCallback.dlV():void");
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.activity;
        }
    }
}
