package com.tencent.mm.msgsubscription.presenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.presenter.b;
import com.tencent.mm.msgsubscription.util.c;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0006H\u0016J\u001a\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0006H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/msgsubscription/presenter/WxaSubscribeMsgSettingPagePresenter;", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "()V", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "changed", "", "subscribeMsgSettingData", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "dispatchLoadDataResult", "", "l", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "getCheckBoxState", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "loadData", "bizUsername", "", "onActivityCreated", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeMsgItemInfoClick", "view", "Landroid/view/View;", "onSubscribeSwitchChanged", "on", "Companion", "plugin-comm_release"})
public final class d extends a {
    public static final a jAl = new a((byte) 0);
    private Activity activity;
    private boolean bGB;
    private SubscribeMsgSettingData jAk;

    static {
        AppMethodBeat.i(149587);
        AppMethodBeat.o(149587);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<SubscribeMsgSettingData, x> {
        final /* synthetic */ b.a iQL;
        final /* synthetic */ d jAm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(d dVar, b.a aVar) {
            super(1);
            this.jAm = dVar;
            this.iQL = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(SubscribeMsgSettingData subscribeMsgSettingData) {
            AppMethodBeat.i(149579);
            this.jAm.jAk = subscribeMsgSettingData;
            d.b(this.iQL, this.jAm.jAk);
            x xVar = x.SXb;
            AppMethodBeat.o(149579);
            return xVar;
        }
    }

    public static final /* synthetic */ void b(b.a aVar, SubscribeMsgSettingData subscribeMsgSettingData) {
        AppMethodBeat.i(149588);
        a(aVar, subscribeMsgSettingData);
        AppMethodBeat.o(149588);
    }

    @Override // com.tencent.mm.msgsubscription.presenter.a
    public final void onActivityCreated(Activity activity2) {
        AppMethodBeat.i(149580);
        p.h(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        super.onActivityCreated(activity2);
        this.activity = activity2;
        AppMethodBeat.o(149580);
    }

    @Override // com.tencent.mm.msgsubscription.presenter.b
    public final void a(String str, b.a aVar) {
        AppMethodBeat.i(149581);
        p.h(str, "bizUsername");
        p.h(aVar, "l");
        Activity activity2 = this.activity;
        if (activity2 == null) {
            p.btv(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        }
        this.jAk = (SubscribeMsgSettingData) activity2.getIntent().getParcelableExtra("key_biz_data");
        if (this.jAk == null) {
            c cVar = c.jDh;
            c.c(str, new b(this, aVar));
            AppMethodBeat.o(149581);
            return;
        }
        a(aVar, this.jAk);
        AppMethodBeat.o(149581);
    }

    private static void a(b.a aVar, SubscribeMsgSettingData subscribeMsgSettingData) {
        AppMethodBeat.i(149582);
        if (subscribeMsgSettingData == null) {
            aVar.onError();
            AppMethodBeat.o(149582);
            return;
        }
        aVar.a(subscribeMsgSettingData);
        AppMethodBeat.o(149582);
    }

    @Override // com.tencent.mm.msgsubscription.presenter.b
    public final void a(SubscribeMsgTmpItem subscribeMsgTmpItem, boolean z) {
        AppMethodBeat.i(149584);
        p.h(subscribeMsgTmpItem, "itemChanged");
        this.bGB = true;
        SubscribeMsgSettingData subscribeMsgSettingData = this.jAk;
        if (subscribeMsgSettingData == null) {
            p.hyc();
        }
        for (SubscribeMsgTmpItem subscribeMsgTmpItem2 : subscribeMsgSettingData.iHf) {
            if (TextUtils.equals(subscribeMsgTmpItem.ixM, subscribeMsgTmpItem2.ixM)) {
                subscribeMsgTmpItem2.jyB = z ? 1 : 0;
                AppMethodBeat.o(149584);
                return;
            }
        }
        AppMethodBeat.o(149584);
    }

    @Override // com.tencent.mm.msgsubscription.presenter.b
    public final void fC(boolean z) {
        this.bGB = true;
        SubscribeMsgSettingData subscribeMsgSettingData = this.jAk;
        if (subscribeMsgSettingData != null) {
            subscribeMsgSettingData.iQD = z;
        }
    }

    @Override // com.tencent.mm.msgsubscription.presenter.a
    public final void y(Activity activity2) {
        AppMethodBeat.i(149585);
        p.h(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        if (this.bGB && this.jAk != null) {
            Intent intent = new Intent();
            intent.putExtra("key_biz_data", this.jAk);
            activity2.setResult(-1, intent);
        }
        AppMethodBeat.o(149585);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/msgsubscription/presenter/WxaSubscribeMsgSettingPagePresenter$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.msgsubscription.presenter.b
    public final boolean a(SubscribeMsgTmpItem subscribeMsgTmpItem) {
        AppMethodBeat.i(149586);
        p.h(subscribeMsgTmpItem, "item");
        if (subscribeMsgTmpItem.jyB == 1) {
            AppMethodBeat.o(149586);
            return true;
        }
        AppMethodBeat.o(149586);
        return false;
    }
}
