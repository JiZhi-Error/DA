package com.tencent.mm.al.b;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.api.ISubscribeMsgService;
import com.tencent.mm.msgsubscription.c.a;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import com.tencent.mm.msgsubscription.presenter.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\f\u0018\u0000 92\u00020\u0001:\u00019B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0010H\u0016JB\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00100\u001a2\"\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010`\u00112\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001aH\u0002J\u0018\u0010!\u001a\u00020\"2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001aH\u0002J\u0012\u0010#\u001a\u00020\"2\b\u0010$\u001a\u0004\u0018\u00010\u0013H\u0002J\u0018\u0010%\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010)\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010*\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010+\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010,\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0004H\u0016J\u0018\u0010-\u001a\u00020\"2\u0006\u0010.\u001a\u00020\u00102\u0006\u0010/\u001a\u00020\nH\u0016J\u001a\u00100\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\nH\u0016J\u0010\u00105\u001a\u00020\"2\u0006\u00106\u001a\u000207H\u0002J\u0018\u00108\u001a\u00020\"2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001aH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0004\n\u0002\u0010\rR*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\u000fj\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, hxF = {"Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter;", "Lcom/tencent/mm/msgsubscription/presenter/BaseSubscribeMsgSettingPagePresenter;", "()V", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "bizService", "Lcom/tencent/mm/msgsubscription/model/SubscribeMsgService;", "bizUsername", "", "needUpdate", "", "opCallback", "com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1", "Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1;", "originTmpMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "Lkotlin/collections/HashMap;", "subscribeMsgRequestResult", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "subscribeSettingReportInfo", "Lcom/tencent/mm/msgsubscription/report/SubscribeMsgReporter$SubscribeMsgSettingReportInfo;", "subscribeSwitch", "canShow", LocaleUtil.ITALIAN, "filterUnShowTmps", "", "subscribeMsgTmpItems", "getCheckBoxState", "item", "getUpdatedList", "originList", "toSaveList", "initOriginTmpMap", "", "initReportInfo", "result", "loadData", "l", "Lcom/tencent/mm/msgsubscription/presenter/ISubscribeMsgSettingPagePresenter$LoadDataListener;", "loadFromRemote", "onActivityCreated", "onActivityPaused", "onActivityResumed", "onFinish", "onSubscribeMsgItemCheckBoxChanged", "itemChanged", "check", "onSubscribeMsgItemInfoClick", "view", "Landroid/view/View;", "onSubscribeSwitchChanged", "on", "reportSubscribeSettingOp", "opType", "", "updateOriginTmpMap", "Companion", "plugin-biz_release"})
public final class a extends com.tencent.mm.msgsubscription.presenter.a {
    public static final C0252a iQJ = new C0252a((byte) 0);
    private Activity activity;
    private String dVu = "";
    private boolean iQD;
    private com.tencent.mm.msgsubscription.b.a iQE = com.tencent.mm.msgsubscription.api.b.Ru("name_biz");
    private SubscribeMsgRequestResult iQF;
    private HashMap<String, SubscribeMsgTmpItem> iQG = new HashMap<>();
    private a.c iQH = new a.c();
    private c iQI = new c(this);
    private boolean needUpdate = true;

    static {
        AppMethodBeat.i(124726);
        AppMethodBeat.o(124726);
    }

    public a() {
        AppMethodBeat.i(124725);
        com.tencent.mm.msgsubscription.api.b bVar = com.tencent.mm.msgsubscription.api.b.jza;
        AppMethodBeat.o(124725);
    }

    public static final /* synthetic */ void a(a aVar, List list) {
        AppMethodBeat.i(124727);
        aVar.aw(list);
        AppMethodBeat.o(124727);
    }

    public static final /* synthetic */ void b(a aVar) {
        AppMethodBeat.i(212437);
        aVar.sR(1);
        AppMethodBeat.o(212437);
    }

    public static final /* synthetic */ void b(a aVar, SubscribeMsgRequestResult subscribeMsgRequestResult) {
        AppMethodBeat.i(212436);
        aVar.a(subscribeMsgRequestResult);
        AppMethodBeat.o(212436);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$opCallback$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-biz_release"})
    public static final class c implements com.tencent.mm.msgsubscription.api.a {
        final /* synthetic */ a iQK;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(a aVar) {
            this.iQK = aVar;
        }

        @Override // com.tencent.mm.msgsubscription.api.a
        public final void a(String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            AppMethodBeat.i(124713);
            p.h(str, "bizUsername");
            p.h(subscribeMsgRequestResult, "result");
            Log.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updateSubscribeMsgListAsync onSuccess");
            a.b(this.iQK, subscribeMsgRequestResult.jyk);
            AppMethodBeat.o(124713);
        }

        @Override // com.tencent.mm.msgsubscription.api.a
        public final void i(int i2, int i3, String str) {
            AppMethodBeat.i(124714);
            p.h(str, "errMsg");
            Log.e("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updateSubscribeMsgListAsync onError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            AppMethodBeat.o(124714);
        }
    }

    @Override // com.tencent.mm.msgsubscription.presenter.a
    public final void onActivityCreated(Activity activity2) {
        int i2 = 0;
        AppMethodBeat.i(124715);
        p.h(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        super.onActivityCreated(activity2);
        this.activity = activity2;
        this.iQH.sessionId = System.currentTimeMillis();
        a.c cVar = this.iQH;
        Intent intent = activity2.getIntent();
        if (intent != null) {
            i2 = intent.getIntExtra("key_enter_scene", 0);
        }
        cVar.enterScene = i2;
        AppMethodBeat.o(124715);
    }

    @Override // com.tencent.mm.msgsubscription.presenter.b
    public final void a(String str, b.a aVar) {
        AppMethodBeat.i(124716);
        p.h(str, "bizUsername");
        p.h(aVar, "l");
        Activity activity2 = this.activity;
        if (activity2 == null) {
            p.btv(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        }
        this.iQF = (SubscribeMsgRequestResult) activity2.getIntent().getParcelableExtra("key_biz_data");
        this.dVu = str;
        if (this.iQF != null) {
            SubscribeMsgRequestResult subscribeMsgRequestResult = this.iQF;
            if (subscribeMsgRequestResult == null) {
                p.hyc();
            }
            this.iQD = subscribeMsgRequestResult.jyo;
            SubscribeMsgRequestResult subscribeMsgRequestResult2 = this.iQF;
            if (subscribeMsgRequestResult2 == null) {
                p.hyc();
            }
            aw(subscribeMsgRequestResult2.jyk);
            SubscribeMsgRequestResult subscribeMsgRequestResult3 = this.iQF;
            if (subscribeMsgRequestResult3 == null) {
                p.hyc();
            }
            aVar.a(new SubscribeMsgSettingData(subscribeMsgRequestResult3));
            a(this.iQF);
            sR(1);
            AppMethodBeat.o(124716);
            return;
        }
        Activity activity3 = this.activity;
        if (activity3 == null) {
            p.btv(EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        }
        boolean booleanExtra = activity3.getIntent().getBooleanExtra("key_need_load_from_remote", false);
        Log.d("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo loadData need load from remote");
        if (booleanExtra) {
            com.tencent.mm.msgsubscription.b.a aVar2 = this.iQE;
            if (aVar2 != null) {
                aVar2.a(str, new b(this, aVar));
                AppMethodBeat.o(124716);
                return;
            }
            AppMethodBeat.o(124716);
            return;
        }
        aVar.onError();
        AppMethodBeat.o(124716);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, hxF = {"com/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$loadFromRemote$1", "Lcom/tencent/mm/msgsubscription/api/SubscribeMsgOpCallback;", "onError", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "bizUsername", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-biz_release"})
    public static final class b implements com.tencent.mm.msgsubscription.api.a {
        final /* synthetic */ a iQK;
        final /* synthetic */ b.a iQL;

        b(a aVar, b.a aVar2) {
            this.iQK = aVar;
            this.iQL = aVar2;
        }

        @Override // com.tencent.mm.msgsubscription.api.a
        public final void a(String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            AppMethodBeat.i(124711);
            p.h(str, "bizUsername");
            p.h(subscribeMsgRequestResult, "result");
            this.iQK.iQF = subscribeMsgRequestResult;
            a aVar = this.iQK;
            SubscribeMsgRequestResult subscribeMsgRequestResult2 = this.iQK.iQF;
            if (subscribeMsgRequestResult2 == null) {
                p.hyc();
            }
            aVar.iQD = subscribeMsgRequestResult2.jyo;
            a aVar2 = this.iQK;
            SubscribeMsgRequestResult subscribeMsgRequestResult3 = this.iQK.iQF;
            if (subscribeMsgRequestResult3 == null) {
                p.hyc();
            }
            a.a(aVar2, subscribeMsgRequestResult3.jyk);
            b.a aVar3 = this.iQL;
            SubscribeMsgRequestResult subscribeMsgRequestResult4 = this.iQK.iQF;
            if (subscribeMsgRequestResult4 == null) {
                p.hyc();
            }
            aVar3.a(new SubscribeMsgSettingData(subscribeMsgRequestResult4));
            a.b(this.iQK, this.iQK.iQF);
            a.b(this.iQK);
            AppMethodBeat.o(124711);
        }

        @Override // com.tencent.mm.msgsubscription.api.a
        public final void i(int i2, int i3, String str) {
            AppMethodBeat.i(124712);
            p.h(str, "errMsg");
            this.iQL.onError();
            AppMethodBeat.o(124712);
        }
    }

    private final void aw(List<SubscribeMsgTmpItem> list) {
        AppMethodBeat.i(124717);
        this.iQG.clear();
        if (list != null) {
            for (T t : list) {
                this.iQG.put(t.ixM, new SubscribeMsgTmpItem(t.title, t.ixM, t.jyz, t.jyd, t.jyA, t.jyB, t.VC, t.jyy));
            }
            AppMethodBeat.o(124717);
            return;
        }
        AppMethodBeat.o(124717);
    }

    @Override // com.tencent.mm.msgsubscription.presenter.b
    public final void a(SubscribeMsgTmpItem subscribeMsgTmpItem, boolean z) {
        int i2;
        AppMethodBeat.i(124719);
        p.h(subscribeMsgTmpItem, "itemChanged");
        SubscribeMsgRequestResult subscribeMsgRequestResult = this.iQF;
        if (subscribeMsgRequestResult == null) {
            p.hyc();
        }
        Iterator<SubscribeMsgTmpItem> it = subscribeMsgRequestResult.jyk.iterator();
        while (it.hasNext()) {
            SubscribeMsgTmpItem next = it.next();
            if (TextUtils.equals(subscribeMsgTmpItem.ixM, next.ixM)) {
                if (z) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                next.jyB = i2;
                subscribeMsgTmpItem.jyB = next.jyB;
                AppMethodBeat.o(124719);
                return;
            }
        }
        AppMethodBeat.o(124719);
    }

    @Override // com.tencent.mm.msgsubscription.presenter.b
    public final void fC(boolean z) {
        this.iQD = z;
    }

    @Override // com.tencent.mm.msgsubscription.presenter.a
    public final void onActivityResumed(Activity activity2) {
        AppMethodBeat.i(124721);
        p.h(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        super.onActivityResumed(activity2);
        this.needUpdate = activity2.getIntent().getBooleanExtra("key_need_update", true);
        AppMethodBeat.o(124721);
    }

    @Override // com.tencent.mm.msgsubscription.presenter.a
    public final void onActivityPaused(Activity activity2) {
        ArrayList<SubscribeMsgTmpItem> arrayList;
        ArrayList<SubscribeMsgTmpItem> arrayList2;
        boolean z;
        boolean z2;
        SubscribeMsgRequestResult subscribeMsgRequestResult;
        AppMethodBeat.i(124722);
        p.h(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.iQD);
        SubscribeMsgRequestResult subscribeMsgRequestResult2 = this.iQF;
        objArr[1] = subscribeMsgRequestResult2 != null ? Boolean.valueOf(subscribeMsgRequestResult2.jyo) : null;
        objArr[2] = Boolean.valueOf(this.needUpdate);
        Log.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo onPause updateSubscribeMsgListAsync isSubscribeMsgOpened: %b, origin opened: %s, needUpdate: %b", objArr);
        SubscribeMsgRequestResult subscribeMsgRequestResult3 = this.iQF;
        if (subscribeMsgRequestResult3 != null) {
            arrayList = subscribeMsgRequestResult3.jyk;
        } else {
            arrayList = null;
        }
        if (arrayList != null && this.needUpdate) {
            HashMap<String, SubscribeMsgTmpItem> hashMap = this.iQG;
            SubscribeMsgRequestResult subscribeMsgRequestResult4 = this.iQF;
            if (subscribeMsgRequestResult4 != null) {
                arrayList2 = subscribeMsgRequestResult4.jyk;
            } else {
                arrayList2 = null;
            }
            List<SubscribeMsgTmpItem> a2 = a(hashMap, arrayList2);
            if (!a2.isEmpty()) {
                z = true;
            } else {
                z = false;
            }
            if (z || (subscribeMsgRequestResult = this.iQF) == null || subscribeMsgRequestResult.jyo != this.iQD) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                com.tencent.mm.msgsubscription.api.c cVar = new com.tencent.mm.msgsubscription.api.c();
                com.tencent.mm.msgsubscription.presenter.c cVar2 = this.jAh;
                if (cVar2 == null) {
                    p.btv("view");
                }
                cVar.setUsername(cVar2.getUserName());
                cVar.jyV.addAll(a2);
                cVar.jzb = this.iQD;
                cVar.jze = this.iQI;
                cVar.jzf = true;
                cVar.jzg = true;
                com.tencent.mm.msgsubscription.b.a aVar = this.iQE;
                if (aVar != null) {
                    aVar.a(cVar);
                }
            } else {
                Log.i("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo updatedList is empty and no need to update");
            }
        }
        this.iQG.clear();
        AppMethodBeat.o(124722);
    }

    @Override // com.tencent.mm.msgsubscription.presenter.a
    public final void y(Activity activity2) {
        boolean z;
        ArrayList<SubscribeMsgTmpItem> arrayList;
        ArrayList<SubscribeMsgTmpItem> arrayList2;
        boolean z2;
        boolean z3;
        SubscribeMsgRequestResult subscribeMsgRequestResult;
        AppMethodBeat.i(124723);
        p.h(activity2, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        super.y(activity2);
        if (!this.needUpdate) {
            Log.v("MicroMsg.BizSubscribeMsgSettingPagePresenter", "alvinluo onFinish not need update and pass data back");
            Intent intent = new Intent();
            HashMap<String, SubscribeMsgTmpItem> hashMap = this.iQG;
            SubscribeMsgRequestResult subscribeMsgRequestResult2 = this.iQF;
            if (subscribeMsgRequestResult2 != null) {
                arrayList2 = subscribeMsgRequestResult2.jyk;
            } else {
                arrayList2 = null;
            }
            List<SubscribeMsgTmpItem> a2 = a(hashMap, arrayList2);
            if (!a2.isEmpty()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 || (subscribeMsgRequestResult = this.iQF) == null || subscribeMsgRequestResult.jyo != this.iQD) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                intent.putExtra("key_biz_data", new ISubscribeMsgService.Companion.SubscribeMsgListWrapper(a2, this.iQD));
            }
            intent.putExtra("key_need_update", z3);
            activity2.setResult(-1, intent);
        }
        this.iQH.jAw = this.iQD;
        SubscribeMsgRequestResult subscribeMsgRequestResult3 = this.iQF;
        if (!(subscribeMsgRequestResult3 == null || (arrayList = subscribeMsgRequestResult3.jyk) == null)) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                this.iQH.jAA.add(Integer.valueOf(it.next().jyB));
            }
        }
        sR(2);
        if (this.dVu.length() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (z && this.iQF != null) {
            com.tencent.mm.msgsubscription.c.a aVar = com.tencent.mm.msgsubscription.c.a.jAr;
            String str = this.dVu;
            SubscribeMsgRequestResult subscribeMsgRequestResult4 = this.iQF;
            if (subscribeMsgRequestResult4 == null) {
                p.hyc();
            }
            boolean z4 = subscribeMsgRequestResult4.jyo;
            SubscribeMsgRequestResult subscribeMsgRequestResult5 = this.iQF;
            if (subscribeMsgRequestResult5 == null) {
                p.hyc();
            }
            com.tencent.mm.msgsubscription.c.a.b(str, z4, subscribeMsgRequestResult5.jyk);
        }
        AppMethodBeat.o(124723);
    }

    private static List<SubscribeMsgTmpItem> a(HashMap<String, SubscribeMsgTmpItem> hashMap, List<SubscribeMsgTmpItem> list) {
        String str;
        AppMethodBeat.i(124724);
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (T t : list) {
                SubscribeMsgTmpItem subscribeMsgTmpItem = hashMap.get(t.ixM);
                if (subscribeMsgTmpItem == null || (str = subscribeMsgTmpItem.ixM) == null || !str.equals(t.ixM)) {
                    arrayList.add(t);
                } else if (subscribeMsgTmpItem.jyB != t.jyB) {
                    arrayList.add(t);
                }
            }
        }
        AppMethodBeat.o(124724);
        return arrayList;
    }

    private final void a(SubscribeMsgRequestResult subscribeMsgRequestResult) {
        AppMethodBeat.i(212434);
        if (subscribeMsgRequestResult == null) {
            AppMethodBeat.o(212434);
            return;
        }
        this.iQH.Rx(this.dVu);
        this.iQH.jAw = subscribeMsgRequestResult.jyo;
        this.iQH.jAx = subscribeMsgRequestResult.jyk.size();
        for (T t : subscribeMsgRequestResult.jyk) {
            this.iQH.jzS.add(t.ixM);
            this.iQH.jAy.add(Integer.valueOf(t.jyz));
            this.iQH.jAz.add(t.title);
            this.iQH.jAs.add(Integer.valueOf(t.jyB));
        }
        AppMethodBeat.o(212434);
    }

    private final void sR(int i2) {
        AppMethodBeat.i(212435);
        com.tencent.mm.msgsubscription.c.a.a(i2, this.iQH);
        AppMethodBeat.o(212435);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/modelbiz/subscribemsg/BizSubscribeMsgSettingPagePresenter$Companion;", "", "()V", "TAG", "", "plugin-biz_release"})
    /* renamed from: com.tencent.mm.al.b.a$a  reason: collision with other inner class name */
    public static final class C0252a {
        private C0252a() {
        }

        public /* synthetic */ C0252a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.msgsubscription.presenter.b
    public final boolean a(SubscribeMsgTmpItem subscribeMsgTmpItem) {
        AppMethodBeat.i(124720);
        p.h(subscribeMsgTmpItem, "item");
        if (subscribeMsgTmpItem.jyB == 1) {
            AppMethodBeat.o(124720);
            return true;
        }
        AppMethodBeat.o(124720);
        return false;
    }

    public static final /* synthetic */ void b(a aVar, List list) {
        AppMethodBeat.i(124728);
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SubscribeMsgTmpItem subscribeMsgTmpItem = (SubscribeMsgTmpItem) it.next();
                SubscribeMsgTmpItem subscribeMsgTmpItem2 = aVar.iQG.get(subscribeMsgTmpItem.ixM);
                if (subscribeMsgTmpItem2 != null) {
                    subscribeMsgTmpItem2.jyB = subscribeMsgTmpItem.jyB;
                }
            }
            AppMethodBeat.o(124728);
            return;
        }
        AppMethodBeat.o(124728);
    }
}
