package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.protocal.protobuf.eml;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\nH\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\u0010\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManageLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "mContext", "Landroid/content/Context;", "mAppId", "", "mPagePath", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "mDeletePhoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "mPhoneItems", "mPhoneNumberManagerView", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManagerView;", "mShowDelete", "", "addPhone", "", "editPhoneNumber", "enableEdit", "finishEdit", "getSpanString", "Landroid/text/SpannableString;", "getView", "Landroid/view/View;", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "removePhone", "phoneItem", "uninit", "updateView", "showDelete", "luggage-wechat-full-sdk_release"})
public final class w implements o {
    private final String lBI;
    final String mAppId;
    private final Context mContext;
    private p nAn;
    private final ArrayList<PhoneItem> nAo = new ArrayList<>();
    private final ArrayList<PhoneItem> nAp = new ArrayList<>();
    private boolean nAq;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Landroid/content/Intent;", "invoke", "(Ljava/lang/Integer;Landroid/content/Intent;)V"})
    static final class a extends q implements m<Integer, Intent, x> {
        public static final a nAr = new a();

        static {
            AppMethodBeat.i(148136);
            AppMethodBeat.o(148136);
        }

        a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* bridge */ /* synthetic */ x invoke(Integer num, Intent intent) {
            return x.SXb;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/UpdateUserPhoneResp;", "invoke"})
    static final class b extends q implements kotlin.g.a.b<eml, x> {
        final /* synthetic */ w nAs;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(w wVar) {
            super(1);
            this.nAs = wVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(eml eml) {
            Long l = null;
            boolean z = true;
            AppMethodBeat.i(148137);
            eml eml2 = eml;
            Object[] objArr = new Object[1];
            if (eml2 == null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            Log.i("MicroMsg.PhoneNumberManagerUI", "update %b", objArr);
            if (eml2 != null) {
                y aex = z.nBg.aex(this.nAs.mAppId);
                if (aex != null) {
                    y aex2 = z.nBg.aex(this.nAs.mAppId);
                    if (aex2 != null) {
                        l = Long.valueOf(aex2.nAZ);
                    }
                    if (l == null) {
                        p.hyc();
                    }
                    aex.nAZ = l.longValue() + 1;
                }
            } else {
                y aex3 = z.nBg.aex(this.nAs.mAppId);
                if (aex3 != null) {
                    y aex4 = z.nBg.aex(this.nAs.mAppId);
                    Long valueOf = aex4 != null ? Long.valueOf(aex4.nBa) : null;
                    if (valueOf == null) {
                        p.hyc();
                    }
                    aex3.nBa = valueOf.longValue() + 1;
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(148137);
            return xVar;
        }
    }

    public w(Context context, String str, String str2) {
        p.h(context, "mContext");
        p.h(str, "mAppId");
        p.h(str2, "mPagePath");
        AppMethodBeat.i(148147);
        this.mContext = context;
        this.mAppId = str;
        this.lBI = str2;
        AppMethodBeat.o(148147);
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.o
    public final void init() {
        AppMethodBeat.i(148138);
        this.nAn = new x(this.mContext, this);
        this.nAo.clear();
        ArrayList<PhoneItem> arrayList = this.nAo;
        r rVar = r.nzC;
        arrayList.addAll(r.bTy());
        z.nBg.aew(this.mAppId);
        AppMethodBeat.o(148138);
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.o
    public final View getView() {
        AppMethodBeat.i(148139);
        p pVar = this.nAn;
        if (pVar != null) {
            View view = pVar.getView();
            AppMethodBeat.o(148139);
            return view;
        }
        AppMethodBeat.o(148139);
        return null;
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.o
    public final void is(boolean z) {
        AppMethodBeat.i(148140);
        this.nAo.clear();
        ArrayList<PhoneItem> arrayList = this.nAo;
        r rVar = r.nzC;
        arrayList.addAll(r.bTy());
        p pVar = this.nAn;
        if (pVar != null) {
            pVar.b(z, this.nAo);
            AppMethodBeat.o(148140);
            return;
        }
        AppMethodBeat.o(148140);
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.o
    public final void bTv() {
        AppMethodBeat.i(148141);
        y aex = z.nBg.aex(this.mAppId);
        if (aex != null) {
            y aex2 = z.nBg.aex(this.mAppId);
            Long valueOf = aex2 != null ? Long.valueOf(aex2.nAX) : null;
            if (valueOf == null) {
                p.hyc();
            }
            aex.nAX = valueOf.longValue() + 1;
        }
        u uVar = u.nAe;
        u.bTz().a(this.mContext, this.mAppId, a.nAr);
        AppMethodBeat.o(148141);
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.o
    public final void a(PhoneItem phoneItem) {
        AppMethodBeat.i(148142);
        p.h(phoneItem, "phoneItem");
        this.nAp.add(phoneItem);
        this.nAo.remove(phoneItem);
        p pVar = this.nAn;
        if (pVar != null) {
            pVar.b(this.nAq, this.nAo);
            AppMethodBeat.o(148142);
            return;
        }
        AppMethodBeat.o(148142);
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.o
    public final void it(boolean z) {
        AppMethodBeat.i(148143);
        this.nAq = !z;
        p pVar = this.nAn;
        if (pVar != null) {
            pVar.b(this.nAq, this.nAo);
            AppMethodBeat.o(148143);
            return;
        }
        AppMethodBeat.o(148143);
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.o
    public final void bTx() {
        AppMethodBeat.i(148144);
        if (this.nAp.size() >= 0) {
            Iterator<PhoneItem> it = this.nAp.iterator();
            while (it.hasNext()) {
                PhoneItem next = it.next();
                y aex = z.nBg.aex(this.mAppId);
                if (aex != null) {
                    y aex2 = z.nBg.aex(this.mAppId);
                    Long valueOf = aex2 != null ? Long.valueOf(aex2.nAY) : null;
                    if (valueOf == null) {
                        p.hyc();
                    }
                    aex.nAY = valueOf.longValue() + 1;
                }
                new g(this.mAppId, next.dSf, 1).y(new b(this));
            }
        }
        r rVar = r.nzC;
        ArrayList<PhoneItem> arrayList = this.nAp;
        if (arrayList == null) {
            p.hyc();
        }
        rVar.K(arrayList);
        AppMethodBeat.o(148144);
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.o
    public final SpannableString bTw() {
        AppMethodBeat.i(148145);
        u uVar = u.nAe;
        SpannableString n = u.bTz().n(this.mContext, this.mAppId, this.lBI);
        AppMethodBeat.o(148145);
        return n;
    }

    @Override // com.tencent.mm.plugin.appbrand.phonenumber.o
    public final void uninit() {
        AppMethodBeat.i(148146);
        z.nBg.aev(this.mAppId);
        AppMethodBeat.o(148146);
    }
}
