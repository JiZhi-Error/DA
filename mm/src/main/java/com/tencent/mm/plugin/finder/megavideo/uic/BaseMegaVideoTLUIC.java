package com.tencent.mm.plugin.finder.megavideo.uic;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.megavideo.multitask.a;
import com.tencent.mm.plugin.finder.megavideo.multitask.b;
import com.tencent.mm.plugin.finder.megavideo.ui.h;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.report.af;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.video.FinderVideoLayout;
import com.tencent.mm.plugin.finder.video.r;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentDrawerUIC;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cnu;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b&\u0018\u0000 E2\u00020\u0001:\u0001EB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H&J\b\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020#2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&H\u0016J\b\u0010(\u001a\u00020\fH\u0016J\u0012\u0010)\u001a\u00020#2\b\u0010*\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020-H\u0016J\u0012\u0010.\u001a\u00020#2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0012\u00101\u001a\u00020#2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00102\u001a\u00020#H\u0016J\u0012\u00103\u001a\u00020#2\b\u00104\u001a\u0004\u0018\u000105H\u0016J,\u00106\u001a\u00020#2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u000105H\u0016J\b\u0010>\u001a\u00020#H\u0016J\b\u0010?\u001a\u00020#H\u0016J\b\u0010@\u001a\u00020#H\u0016J\b\u0010A\u001a\u00020#H\u0016J\u0010\u0010B\u001a\u00020\f2\u0006\u0010C\u001a\u00020DH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006F"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "floatBallInfo", "Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "getFloatBallInfo", "()Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;", "setFloatBallInfo", "(Lcom/tencent/mm/protocal/protobuf/MegaVideoFloatBallInfo;)V", "isMultiTask", "", "multiTaskHelpter", "Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "getMultiTaskHelpter", "()Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;", "setMultiTaskHelpter", "(Lcom/tencent/mm/plugin/finder/megavideo/multitask/MegaVideoMultiTaskHelper;)V", "multiTaskIntent", "Landroid/content/Intent;", "getMultiTaskIntent", "()Landroid/content/Intent;", "setMultiTaskIntent", "(Landroid/content/Intent;)V", "needToReinit", "getNeedToReinit", "()Z", "setNeedToReinit", "(Z)V", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "getPresenter", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoTimelineContract$Presenter;", "initFloatBallData", "", "initMultiTaskData", "key", "", "positon", "onBackPressed", "onBeforeFinish", "resultIntent", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateAfter", "onDestroy", "onMultiTaskInit", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "onMultiTaskPagePause", "onMultiTaskPageResume", "onPause", "onResume", "supportMultiTaskType", "multiTaskType", "", "Companion", "plugin-finder_release"})
public abstract class BaseMegaVideoTLUIC extends MultiTaskUIComponent {
    public static final a uMR = new a((byte) 0);
    private cnu uLY = new cnu();
    protected com.tencent.mm.plugin.finder.megavideo.multitask.a uMN;
    Intent uMO;
    private boolean uMP;
    boolean uMQ;

    public abstract h.a dkq();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/uic/BaseMegaVideoTLUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseMegaVideoTLUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onCreate(Bundle bundle) {
        a(this, null, 3);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onCreateAfter(Bundle bundle) {
        h.a dkq = dkq();
        com.tencent.mm.plugin.finder.megavideo.multitask.a aVar = this.uMN;
        if (aVar == null) {
            p.btv("multiTaskHelpter");
        }
        dkq.a(aVar, this.uLY, this.uMP);
    }

    private static /* synthetic */ void a(BaseMegaVideoTLUIC baseMegaVideoTLUIC, String str, int i2) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        baseMegaVideoTLUIC.aue(str);
    }

    private void aue(String str) {
        String str2;
        byte[] byteArrayExtra;
        if (this.uMN == null) {
            if (str == null && (byteArrayExtra = getActivity().getIntent().getByteArrayExtra("KEY_FLOAT_BALL_INFO")) != null) {
                this.uMQ = true;
                try {
                    this.uLY.parseFrom(byteArrayExtra);
                } catch (Throwable th) {
                    Log.e("BaseMegaVideoUIC", "initFloatBallData", th);
                    x xVar = x.SXb;
                }
            }
            String str3 = this.uLY.key;
            if (str3 != null) {
                this.uMP = true;
            }
            this.uMN = new com.tencent.mm.plugin.finder.megavideo.multitask.a(getActivity(), new b(getActivity(), this.zZC, getRootView()));
            com.tencent.mm.plugin.finder.megavideo.multitask.a aVar = this.uMN;
            if (aVar == null) {
                p.btv("multiTaskHelpter");
            }
            if (str3 == null) {
                k kVar = k.vfA;
                str2 = k.doc();
            } else {
                str2 = str3;
            }
            aVar.G(22, str2);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public boolean onBackPressed() {
        return dkq().nJ(false);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onConfigurationChanged(Configuration configuration) {
        p.h(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        dkq().nI(configuration.orientation == 2);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onResume() {
        if (this.uMN != null) {
            com.tencent.mm.plugin.finder.megavideo.multitask.a aVar = this.uMN;
            if (aVar == null) {
                p.btv("multiTaskHelpter");
            }
            aVar.bCA();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onPause() {
        if (getActivity().isFinishing()) {
            af afVar = af.viA;
            af.doU();
        }
        if (this.uMN != null) {
            com.tencent.mm.plugin.finder.megavideo.multitask.a aVar = this.uMN;
            if (aVar == null) {
                p.btv("multiTaskHelpter");
            }
            aVar.aGj();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onBeforeFinish(Intent intent) {
        FinderVideoLayout finderVideoLayout;
        FeedData feedData;
        long j2 = 0;
        super.onBeforeFinish(intent);
        RecyclerView recyclerView = dkq().dko().getRecyclerView();
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            throw new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        }
        RecyclerView.v ch = recyclerView.ch(((LinearLayoutManager) layoutManager).ks());
        if (!(ch instanceof com.tencent.mm.view.recyclerview.h)) {
            ch = null;
        }
        com.tencent.mm.view.recyclerview.h hVar = (com.tencent.mm.view.recyclerview.h) ch;
        Intent intent2 = new Intent();
        if (!(hVar == null || (finderVideoLayout = (FinderVideoLayout) hVar.Mn(R.id.ckd)) == null)) {
            r videoView = finderVideoLayout.getVideoView();
            long currentPlayMs = videoView != null ? videoView.getCurrentPlayMs() : 0;
            FinderVideoLayout.b playInfo = finderVideoLayout.getPlayInfo();
            if (!(playInfo == null || (feedData = playInfo.feed) == null)) {
                j2 = feedData.getFeedId();
            }
            intent2.putExtra("KEY_VIDEO_START_PLAY_TIME_MS", currentPlayMs);
            intent2.putExtra("KEY_CACHE_OBJECT_ID", j2);
        }
        getContext().setResult(-1, intent2);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public void onDestroy() {
        if (this.uMN != null && this.uMN == null) {
            p.btv("multiTaskHelpter");
        }
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void dk(Object obj) {
        MultiTaskInfo multiTaskInfo = (MultiTaskInfo) (!(obj instanceof MultiTaskInfo) ? null : obj);
        if (multiTaskInfo != null) {
            try {
                this.uLY = new cnu();
                this.uLY.parseFrom(multiTaskInfo.field_data);
            } catch (Throwable th) {
                Log.e("BaseMegaVideoUIC", "onMultiTaskInit", th);
            }
            Intent intent = new Intent();
            y yVar = y.vXH;
            LinkedList<FinderObject> linkedList = this.uLY.Muf;
            p.g(linkedList, "floatBallInfo.cacheNewVideoList");
            LinkedList<FinderObject> linkedList2 = linkedList;
            ArrayList arrayList = new ArrayList(j.a(linkedList2, 10));
            for (T t : linkedList2) {
                p.g(t, LocaleUtil.ITALIAN);
                arrayList.add(new bm((FinderObject) t));
            }
            y.a(0, arrayList, (com.tencent.mm.bw.b) null, intent);
            this.uMO = intent;
            a(this, multiTaskInfo.field_id, 2);
        }
        this.uMP = true;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.b(getActivity()).get(FinderCommentDrawerUIC.class);
        p.g(viewModel, "UICProvider.of(activity)…entDrawerUIC::class.java)");
        new com.tencent.mm.plugin.finder.viewmodel.component.a((FinderCommentDrawerUIC) viewModel);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a, com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void a(View view, MultiTaskInfo multiTaskInfo, crq crq, Object obj) {
        Context context;
        p.h(multiTaskInfo, "multiTaskInfo");
        p.h(crq, "animateData");
        a.C1220a aVar = com.tencent.mm.plugin.finder.megavideo.multitask.a.uLw;
        if (view != null) {
            context = view.getContext();
        } else {
            context = null;
        }
        if (!(context instanceof Activity)) {
            context = null;
        }
        a.C1220a.a(multiTaskInfo, crq, true, (Activity) context);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void dkr() {
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a
    public final a.b dks() {
        return a.b.MODE_SHOW_MULTI_SCENE;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final boolean Js(int i2) {
        return i2 == 22;
    }
}
