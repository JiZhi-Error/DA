package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002:\u0002PQB\u0005¢\u0006\u0002\u0010\u0003J\b\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020\u0005H\u0014J\u0018\u00105\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020807\u0018\u000106H\u0016J\"\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00052\b\u0010=\u001a\u0004\u0018\u00010>H\u0014J\u0012\u0010?\u001a\u00020:2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010B\u001a\u00020:H\u0014J,\u0010C\u001a\u00020:2\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u00052\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0016J2\u0010J\u001a\u00020:2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020G0L2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020G0L2\f\u0010N\u001a\b\u0012\u0004\u0012\u00020G0LH\u0002J\b\u0010O\u001a\u00020:H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u000e\u0012\b\u0012\u00060\nR\u00020\u0000\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR)\u0010\u000f\u001a\u001a\u0012\b\u0012\u00060\nR\u00020\u00000\u0010j\f\u0012\b\u0012\u00060\nR\u00020\u0000`\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101¨\u0006R"}, hxF = {"Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;", "Lcom/tencent/mm/ui/report/MMSecDataActivity;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "MAX_SELECT_CONTACT", "", "REQUEST_CODE_ADD_FOLLOWER", "REQUEST_CODE_FROM_PROFILE", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "dataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLoadingDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setLoadingDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "netSceneAddFollow", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneAddFollow;", "getNetSceneAddFollow", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneAddFollow;", "setNetSceneAddFollow", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneAddFollow;)V", "netSceneGetFollowList", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetWeRunFollowerList;", "getNetSceneGetFollowList", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetWeRunFollowerList;", "setNetSceneGetFollowList", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetWeRunFollowerList;)V", "netSceneProfileDetail", "Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetProfileDetail;", "getNetSceneProfileDetail", "()Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetProfileDetail;", "setNetSceneProfileDetail", "(Lcom/tencent/mm/plugin/exdevice/rank/model/NetSceneGetProfileDetail;)V", "recycleView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecycleView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecycleView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemConverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "startSelectUserToFollower", "mRecentLikeUsers", "", "mWechatSportFollows", "mMyFollows", "syncFollowList", "FollowItem", "FollowItemConvert", "app_release"})
public final class ExdeviceFollowsUI extends MMSecDataActivity implements i {
    private final ArrayList<a> kgc = new ArrayList<>();
    q loadingDialog;
    private WxRecyclerView rHX;
    com.tencent.mm.plugin.exdevice.g.a.i rHY;
    com.tencent.mm.plugin.exdevice.g.a.l rHZ;
    private com.tencent.mm.plugin.exdevice.g.a.g rIa;
    private final int rIb = 4660;
    private final int rIc = 4661;
    private final int rId = 10;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012 \u0005*\b\u0018\u00010\u0003R\u00020\u00040\u0003R\u00020\u00042\u0016\u0010\u0006\u001a\u0012 \u0005*\b\u0018\u00010\u0003R\u00020\u00040\u0003R\u00020\u0004H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;", "kotlin.jvm.PlatformType", "o2", "compare"})
    static final class g<T> implements Comparator<a> {
        public static final g rIj = new g();

        static {
            AppMethodBeat.i(230611);
            AppMethodBeat.o(230611);
        }

        g() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
            return aVar2.rIe.lCq - aVar.rIe.lCq;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012 \u0005*\b\u0018\u00010\u0003R\u00020\u00040\u0003R\u00020\u00042\u0016\u0010\u0006\u001a\u0012 \u0005*\b\u0018\u00010\u0003R\u00020\u00040\u0003R\u00020\u0004H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "o1", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;", "kotlin.jvm.PlatformType", "o2", "compare"})
    static final class h<T> implements Comparator<a> {
        public static final h rIk = new h();

        static {
            AppMethodBeat.i(230612);
            AppMethodBeat.o(230612);
        }

        h() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public final /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
            return aVar2.rIe.lCq - aVar.rIe.lCq;
        }
    }

    public ExdeviceFollowsUI() {
        AppMethodBeat.i(230619);
        AppMethodBeat.o(230619);
    }

    public static final /* synthetic */ void b(ExdeviceFollowsUI exdeviceFollowsUI) {
        AppMethodBeat.i(230620);
        exdeviceFollowsUI.cLM();
        AppMethodBeat.o(230620);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(230613);
        super.onCreate(bundle);
        setMMTitle(R.string.c26);
        setBackBtn(new e(this));
        addIconOptionMenu(0, R.raw.icons_outlined_add, new f(this));
        com.tencent.mm.kernel.g.azz().a(1043, this);
        com.tencent.mm.kernel.g.azz().a(1777, this);
        com.tencent.mm.kernel.g.azz().a(1758, this);
        this.rHX = (WxRecyclerView) findViewById(R.id.gy2);
        WxRecyclerView wxRecyclerView = this.rHX;
        if (wxRecyclerView != null) {
            wxRecyclerView.setLayoutManager(new LinearLayoutManager(1, false));
        }
        WxRecyclerView wxRecyclerView2 = this.rHX;
        if (wxRecyclerView2 != null) {
            wxRecyclerView2.setAdapter(new WxRecyclerAdapter(new c(this), this.kgc));
        }
        cLM();
        AppMethodBeat.o(230613);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class e implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ExdeviceFollowsUI rIf;

        e(ExdeviceFollowsUI exdeviceFollowsUI) {
            this.rIf = exdeviceFollowsUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(230608);
            this.rIf.finish();
            AppMethodBeat.o(230608);
            return false;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class f implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ ExdeviceFollowsUI rIf;

        f(ExdeviceFollowsUI exdeviceFollowsUI) {
            this.rIf = exdeviceFollowsUI;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(230610);
            ExdeviceFollowsUI exdeviceFollowsUI = this.rIf;
            this.rIf.getString(R.string.zb);
            exdeviceFollowsUI.loadingDialog = com.tencent.mm.ui.base.h.b((Context) this.rIf, this.rIf.getString(R.string.ekc), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener(this) {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceFollowsUI.f.AnonymousClass1 */
                final /* synthetic */ f rIi;

                {
                    this.rIi = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(230609);
                    com.tencent.mm.plugin.exdevice.g.a.i iVar = this.rIi.rIf.rHY;
                    if (iVar != null) {
                        com.tencent.mm.kernel.g.azz().a(iVar);
                    }
                    dialogInterface.dismiss();
                    AppMethodBeat.o(230609);
                }
            });
            this.rIf.rHZ = new com.tencent.mm.plugin.exdevice.g.a.l();
            com.tencent.mm.kernel.g.azz().b(this.rIf.rHZ);
            AppMethodBeat.o(230610);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(230614);
        com.tencent.mm.plugin.exdevice.g.a.i iVar = this.rHY;
        if (iVar != null) {
            com.tencent.mm.kernel.g.azz().a(iVar);
        }
        com.tencent.mm.plugin.exdevice.g.a.l lVar = this.rHZ;
        if (lVar != null) {
            com.tencent.mm.kernel.g.azz().a(lVar);
        }
        com.tencent.mm.plugin.exdevice.g.a.g gVar = this.rIa;
        if (gVar != null) {
            com.tencent.mm.kernel.g.azz().a(gVar);
        }
        com.tencent.mm.kernel.g.azz().b(1043, this);
        com.tencent.mm.kernel.g.azz().b(1777, this);
        com.tencent.mm.kernel.g.azz().b(1758, this);
        super.onDestroy();
        AppMethodBeat.o(230614);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.a4l;
    }

    private final void cLM() {
        AppMethodBeat.i(230615);
        this.rHY = new com.tencent.mm.plugin.exdevice.g.a.i(this, z.aTY(), "", null);
        com.tencent.mm.kernel.g.azz().b(this.rHY);
        AppMethodBeat.o(230615);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0095  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int r15, int r16, java.lang.String r17, com.tencent.mm.ak.q r18) {
        /*
        // Method dump skipped, instructions count: 538
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.exdevice.ui.ExdeviceFollowsUI.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(230617);
        HashSet hashSet = new HashSet(super.importUIComponents());
        hashSet.add(SportProfileUIC.class);
        HashSet hashSet2 = hashSet;
        AppMethodBeat.o(230617);
        return hashSet2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$buildItemConverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "app_release"})
    public static final class c implements com.tencent.mm.view.recyclerview.f {
        final /* synthetic */ ExdeviceFollowsUI rIf;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(ExdeviceFollowsUI exdeviceFollowsUI) {
            this.rIf = exdeviceFollowsUI;
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(230606);
            b bVar = new b();
            AppMethodBeat.o(230606);
            return bVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "id", "", "follow", "Lcom/tencent/mm/protocal/protobuf/Follow;", "(Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;JLcom/tencent/mm/protocal/protobuf/Follow;)V", "getFollow", "()Lcom/tencent/mm/protocal/protobuf/Follow;", "setFollow", "(Lcom/tencent/mm/protocal/protobuf/Follow;)V", "getId", "()J", "setId", "(J)V", "getItemId", "getItemType", "", "app_release"})
    public final class a implements com.tencent.mm.view.recyclerview.a {
        private long id;
        bes rIe;
        final /* synthetic */ ExdeviceFollowsUI rIf;

        public a(ExdeviceFollowsUI exdeviceFollowsUI, long j2, bes bes) {
            p.h(bes, "follow");
            this.rIf = exdeviceFollowsUI;
            AppMethodBeat.i(230602);
            this.id = j2;
            this.rIe = bes;
            AppMethodBeat.o(230602);
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final long lT() {
            return this.id;
        }

        @Override // com.tencent.mm.view.recyclerview.a
        public final int cxn() {
            return 2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016JD\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J \u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0006H\u0016¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItem;", "Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;", "(Lcom/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "app_release"})
    public final class b extends com.tencent.mm.view.recyclerview.e<a> {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.view.recyclerview.a, int, int, boolean, java.util.List] */
        @Override // com.tencent.mm.view.recyclerview.e
        public final /* synthetic */ void a(com.tencent.mm.view.recyclerview.h hVar, a aVar, int i2, int i3, boolean z, List list) {
            AppMethodBeat.i(230605);
            a aVar2 = aVar;
            p.h(hVar, "holder");
            p.h(aVar2, "item");
            a.b.c((ImageView) hVar.Mn(R.id.c6c), aVar2.rIe.username);
            TextView textView = (TextView) hVar.Mn(R.id.c6d);
            p.g(textView, "usernameTV");
            textView.setText(com.tencent.mm.pluginsdk.ui.span.l.b(ExdeviceFollowsUI.this, aa.getDisplayName(aVar2.rIe.username), textView.getTextSize()));
            int i4 = aVar2.rIe.lCq;
            View Mn = hVar.Mn(R.id.c5a);
            p.g(Mn, "holder.getView<TextView>….id.ex_device_user_score)");
            ((TextView) Mn).setText(String.valueOf(i4));
            if (i4 >= 10000) {
                ((TextView) hVar.Mn(R.id.c5a)).setTextColor(com.tencent.mm.cb.a.n(ExdeviceFollowsUI.this, R.color.nq));
            } else {
                ((TextView) hVar.Mn(R.id.c5a)).setTextColor(com.tencent.mm.cb.a.n(ExdeviceFollowsUI.this, R.color.np));
            }
            hVar.aus.setOnClickListener(new a(this, aVar2));
            AppMethodBeat.o(230605);
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final int getLayoutId() {
            return R.layout.a4k;
        }

        @Override // com.tencent.mm.view.recyclerview.e
        public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.h hVar, int i2) {
            AppMethodBeat.i(230604);
            p.h(recyclerView, "recyclerView");
            p.h(hVar, "holder");
            AppMethodBeat.o(230604);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
        static final class a implements View.OnClickListener {
            final /* synthetic */ b rIg;
            final /* synthetic */ a rIh;

            a(b bVar, a aVar) {
                this.rIg = bVar;
                this.rIh = aVar;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(230603);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(ExdeviceFollowsUI.this, ExdeviceProfileUI.class);
                intent.putExtra(ch.COL_USERNAME, this.rIh.rIe.username);
                ExdeviceFollowsUI.this.startActivityForResult(intent, ExdeviceFollowsUI.this.rIc);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$FollowItemConvert$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(230603);
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(230618);
        if (i2 == this.rIb) {
            if (i3 == -1) {
                if (intent != null) {
                    String stringExtra = intent.getStringExtra("Select_Contact");
                    p.g(stringExtra, "userName");
                    Object[] array = n.a(stringExtra, new String[]{","}).toArray(new String[0]);
                    if (array == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                        AppMethodBeat.o(230618);
                        throw tVar;
                    }
                    ArrayList<String> stringsToList = Util.stringsToList((String[]) array);
                    if (stringsToList == null) {
                        AppMethodBeat.o(230618);
                        return;
                    }
                    q qVar = this.loadingDialog;
                    if (qVar != null) {
                        qVar.show();
                    }
                    this.rIa = new com.tencent.mm.plugin.exdevice.g.a.g(stringsToList, null);
                    bg.azz().b(this.rIa);
                    AppMethodBeat.o(230618);
                    return;
                }
                AppMethodBeat.o(230618);
                return;
            }
        } else if (i2 == this.rIc && i3 == -1 && intent != null) {
            if (intent.getBooleanExtra("KeyNeedUpdateRank", false)) {
                com.tencent.f.h.RTc.n(new d(this), 500);
            }
            AppMethodBeat.o(230618);
            return;
        }
        AppMethodBeat.o(230618);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/exdevice/ui/ExdeviceFollowsUI$onActivityResult$2$1"})
    static final class d implements Runnable {
        final /* synthetic */ ExdeviceFollowsUI rIf;

        d(ExdeviceFollowsUI exdeviceFollowsUI) {
            this.rIf = exdeviceFollowsUI;
        }

        public final void run() {
            AppMethodBeat.i(230607);
            ExdeviceFollowsUI.b(this.rIf);
            AppMethodBeat.o(230607);
        }
    }
}
