package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI6;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class FinderLiveTagConstract {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00010B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J \u0010&\u001a\u00020#2\u0006\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010*J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0002H\u0016J\b\u0010-\u001a\u00020#H\u0016J\u0012\u0010.\u001a\u0004\u0018\u00010/2\u0006\u0010$\u001a\u00020%H\u0002R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u00061"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;", "tagData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "hasNextAction", "", "(Ljava/util/ArrayList;Z)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "getHasNextAction", "()Z", "setHasNextAction", "(Z)V", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "getLiveData", "()Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "setLiveData", "(Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;)V", "getTagData", "()Ljava/util/ArrayList;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;)V", "getData", "gotoSubTagUI", "", "tagIndex", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "callback", "onDetach", "parseSubTagList", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTagInfo;", "Companion", "plugin-finder_release"})
    public static final class Presenter implements a<ViewCallback> {
        public static final Companion uXG = new Companion((byte) 0);
        public g liveData;
        public WxRecyclerAdapter<bo> tFp;
        public ViewCallback uXF;
        private final ArrayList<bo> uXu;
        boolean uXv;

        static {
            AppMethodBeat.i(249822);
            AppMethodBeat.o(249822);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(byte b2) {
                this();
            }
        }

        public Presenter(ArrayList<bo> arrayList, boolean z) {
            p.h(arrayList, "tagData");
            AppMethodBeat.i(249821);
            this.uXu = arrayList;
            this.uXv = z;
            AppMethodBeat.o(249821);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(ViewCallback viewCallback) {
            AppMethodBeat.i(249820);
            a(viewCallback);
            AppMethodBeat.o(249820);
        }

        private g getLiveData() {
            AppMethodBeat.i(249818);
            g gVar = this.liveData;
            if (gVar == null) {
                p.btv("liveData");
            }
            AppMethodBeat.o(249818);
            return gVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:52:0x0183  */
        /* JADX WARNING: Removed duplicated region for block: B:62:0x01c9  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.ViewCallback r9) {
            /*
            // Method dump skipped, instructions count: 523
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract.Presenter.a(com.tencent.mm.plugin.finder.presenter.contract.FinderLiveTagConstract$ViewCallback):void");
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
        }

        public static final /* synthetic */ void a(Presenter presenter, int i2) {
            axk axk;
            String str;
            Integer num;
            LinkedList<axk> linkedList;
            byte[] bArr = null;
            AppMethodBeat.i(249823);
            Log.i("FinderLiveTagConstract.Presenter", "selected tagIndex:".concat(String.valueOf(i2)));
            ViewCallback viewCallback = presenter.uXF;
            if (viewCallback != null) {
                Intent intent = new Intent();
                intent.setClass(viewCallback.activity, OccupyFinderUI6.class);
                intent.putExtra("KEY_HAS_NEXT_ACTION", presenter.uXv);
                bo boVar = (bo) j.L(presenter.uXu, i2);
                if (boVar == null || !(boVar instanceof al)) {
                    axk = null;
                } else {
                    axk = ((al) boVar).uOy;
                }
                StringBuilder append = new StringBuilder("tagIndex:").append(i2).append(", selectTag:");
                if (axk != null) {
                    str = axk.qHk;
                } else {
                    str = null;
                }
                StringBuilder append2 = append.append(str).append(", selectTag.subList:");
                if (axk == null || (linkedList = axk.LHT) == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(linkedList.size());
                }
                Log.i("FinderLiveTagConstract.Presenter", append2.append(num).toString());
                if (axk != null) {
                    bArr = axk.toByteArray();
                }
                intent.putExtra("KEY_TAG_INFO", bArr);
                viewCallback.activity.startActivityForResult(intent, 1);
                AppMethodBeat.o(249823);
                return;
            }
            AppMethodBeat.o(249823);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020\u0004H\u0016J\b\u0010\"\u001a\u00020\u0002H\u0016J\u0006\u0010#\u001a\u00020 R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\f¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$Presenter;)V", "actionBtn", "Landroid/widget/TextView;", "getActionBtn", "()Landroid/widget/TextView;", "setActionBtn", "(Landroid/widget/TextView;)V", "cancelBtn", "getCancelBtn", "setCancelBtn", TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER, "Landroid/widget/RelativeLayout;", "getHeader", "()Landroid/widget/RelativeLayout;", "setHeader", "(Landroid/widget/RelativeLayout;)V", "tagRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getTagRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setTagRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "titleTv", "getTitleTv", "setTitleTv", "finishWithResult", "", "getActivity", "getPresenter", "initView", "Companion", "plugin-finder_release"})
    public static final class ViewCallback implements c<Presenter> {
        public static final Companion uXJ = new Companion((byte) 0);
        final MMActivity activity;
        public TextView kaq;
        public TextView titleTv;
        public TextView uXA;
        public RecyclerView uXB;
        final Presenter uXI;
        public RelativeLayout uXy;

        static {
            AppMethodBeat.i(249829);
            AppMethodBeat.o(249829);
        }

        public ViewCallback(MMActivity mMActivity, Presenter presenter) {
            p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(presenter, "presenter");
            AppMethodBeat.i(249828);
            this.activity = mMActivity;
            this.uXI = presenter;
            AppMethodBeat.o(249828);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveTagConstract$ViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(byte b2) {
                this();
            }
        }

        public final void amT() {
            AppMethodBeat.i(249827);
            Log.i("FinderLiveTagConstract.ViewCallback", "finishWithResult hasNextAction:" + this.uXI.uXv);
            if (this.uXI.uXv) {
                new Intent();
                Intent intent = new Intent();
                intent.putExtra("KEY_START_LIVE", true);
                this.activity.setResult(-1, intent);
                this.activity.finish();
                AppMethodBeat.o(249827);
                return;
            }
            this.activity.setResult(-1);
            this.activity.finish();
            AppMethodBeat.o(249827);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.activity;
        }
    }
}
