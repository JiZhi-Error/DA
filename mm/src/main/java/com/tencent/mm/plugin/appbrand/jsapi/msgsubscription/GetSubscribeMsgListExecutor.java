package com.tencent.mm.plugin.appbrand.jsapi.msgsubscription;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestDialogUiData;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.WordingInfo;
import com.tencent.mm.msgsubscription.ui.b;
import com.tencent.mm.msgsubscription.util.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.json.JSONArray;

@l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\u00020\u0001:\u0002BCB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B5\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eB-\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000fJ\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\rH\u0016J6\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060+0*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0*2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020/0*H\u0002J*\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\r2\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\u00062\b\u0010&\u001a\u0004\u0018\u00010'H\u0016JB\u00104\u001a\u00020#2\u0018\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060+0*2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\r2\u0006\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u0006H\u0002J\b\u0010;\u001a\u00020#H\u0016J<\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060+0*2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0*2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u0002070>H\u0002J\u001a\u0010?\u001a\u00020#2\b\u0010@\u001a\u0004\u0018\u00010\u00032\u0006\u0010A\u001a\u00020\rH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/ISubscribeMsgCGIExecutor;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", ch.COL_USERNAME, "", "tmplIds", "", "eventListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "appid", "appType", "", "(Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;Ljava/lang/String;I)V", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;I)V", "dispatcher", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "getDispatcher", "()Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "setDispatcher", "(Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;)V", "getEventListener", "()Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "setEventListener", "(Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;)V", "subscribeMsgRequestDialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "getSubscribeMsgRequestDialog", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "setSubscribeMsgRequestDialog", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getTmplIds", "()Ljava/util/List;", "dealWithCgiResult", "", "context", "Landroid/content/Context;", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "describeContents", "itemsToReportList", "", "", "subscribeMsgTmpItems", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "items", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "onNetSceneEndCallback", "errType", "errCode", "errMsg", "report", "templateItems", "alwaysKeepSelected", "", "userOpType", "indexStr", "clickCountStr", "requestCgi", "toReportMap", "isCheck", "Lkotlin/Function1;", "writeToParcel", "dest", "flags", "Companion", "EventListener", "luggage-wechat-full-sdk_release"})
public final class GetSubscribeMsgListExecutor implements ISubscribeMsgCGIExecutor {
    public static final Parcelable.Creator<GetSubscribeMsgListExecutor> CREATOR = new b();
    public static final a mfB = new a((byte) 0);
    private final int appType;
    private final String dNI;
    final List<String> mfA;
    a.AbstractC0480a mfx;
    c mfy;
    public com.tencent.mm.msgsubscription.ui.b mfz;
    final String username;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH&J*\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$EventListener;", "", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "onUserActionCompleted", ch.COL_USERNAME, "items", "", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "uIData", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestDialogUiData;", "showDialog", "dialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "luggage-wechat-full-sdk_release"})
    public interface c {
        void a(int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult);

        void a(String str, List<SubscribeMsgTmpItem> list, SubscribeMsgRequestDialogUiData subscribeMsgRequestDialogUiData);

        void b(k kVar);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ Context $context;
        final /* synthetic */ SubscribeMsgRequestResult jAc;
        final /* synthetic */ List jAe;
        final /* synthetic */ boolean jAf;
        final /* synthetic */ GetSubscribeMsgListExecutor mfC;
        final /* synthetic */ Map mfD;
        final /* synthetic */ int mfE;

        d(GetSubscribeMsgListExecutor getSubscribeMsgListExecutor, SubscribeMsgRequestResult subscribeMsgRequestResult, Context context, List list, Map map, boolean z, int i2) {
            this.mfC = getSubscribeMsgListExecutor;
            this.jAc = subscribeMsgRequestResult;
            this.$context = context;
            this.jAe = list;
            this.mfD = map;
            this.jAf = z;
            this.mfE = i2;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<no name provided>", "", "event", "", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "alwaysKeepSelected", "", "invoke"})
        static final class a extends q implements kotlin.g.a.q<Integer, List<b.C0477b>, Boolean, x> {
            final /* synthetic */ d mfF;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar) {
                super(3);
                this.mfF = dVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.q
            public final /* synthetic */ x d(Integer num, List<b.C0477b> list, Boolean bool) {
                AppMethodBeat.i(230099);
                int intValue = num.intValue();
                List<b.C0477b> list2 = list;
                boolean booleanValue = bool.booleanValue();
                p.h(list2, "items");
                SubscribeMsgRequestDialogUiData.a aVar = SubscribeMsgRequestDialogUiData.jyc;
                SubscribeMsgRequestDialogUiData a2 = SubscribeMsgRequestDialogUiData.a.a(intValue, list2, booleanValue);
                c cVar = this.mfF.mfC.mfy;
                if (cVar != null) {
                    cVar.a(this.mfF.mfC.username, this.mfF.jAc.jyk, a2);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(230099);
                return xVar;
            }
        }

        public final void run() {
            String str;
            AppMethodBeat.i(183058);
            final a aVar = new a(this);
            if (this.$context instanceof Application) {
                aVar.d(2, this.jAe, Boolean.FALSE);
                Log.w("AppBrandSubscribeMsg.GetSubscribeMsgListExecutor", "a context which is Application to perform show dialog will case [UnsupportedOperationException] here");
                AppMethodBeat.o(183058);
                return;
            }
            GetSubscribeMsgListExecutor getSubscribeMsgListExecutor = this.mfC;
            com.tencent.mm.msgsubscription.ui.b bVar = new com.tencent.mm.msgsubscription.ui.b(n.dF(this.$context), this.jAe, new b.d(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.GetSubscribeMsgListExecutor.d.AnonymousClass1 */
                final /* synthetic */ d mfF;

                {
                    this.mfF = r1;
                }

                @Override // com.tencent.mm.msgsubscription.ui.b.d
                public final void c(int i2, List<b.C0477b> list) {
                    int i3;
                    AppMethodBeat.i(183056);
                    p.h(list, "resultData");
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(list);
                    switch (i2) {
                        case 1:
                        case 2:
                        case 3:
                            aVar.d(Integer.valueOf(i2), arrayList, Boolean.valueOf(this.mfF.mfC.bHz().jCa.isChecked()));
                            break;
                    }
                    List<Number> p = j.p(this.mfF.mfD.keySet());
                    ArrayList arrayList2 = new ArrayList();
                    for (Number number : p) {
                        Integer num = (Integer) this.mfF.mfD.get(Integer.valueOf(number.intValue()));
                        if (num != null) {
                            arrayList2.add(Integer.valueOf(num.intValue()));
                        }
                    }
                    GetSubscribeMsgListExecutor getSubscribeMsgListExecutor = this.mfF.mfC;
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.addAll(this.mfF.jAc.jyk);
                    List i4 = GetSubscribeMsgListExecutor.i(arrayList3, this.mfF.jAe);
                    boolean isChecked = this.mfF.mfC.bHz().jCa.isChecked();
                    switch (i2) {
                        case 1:
                            i3 = 1;
                            break;
                        case 2:
                            i3 = 2;
                            break;
                        case 3:
                            i3 = 3;
                            break;
                        default:
                            i3 = 0;
                            break;
                    }
                    GetSubscribeMsgListExecutor.a(getSubscribeMsgListExecutor, i4, isChecked, i3, j.a(p, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62), j.a(arrayList2, "#", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62));
                    AppMethodBeat.o(183056);
                }
            }, this.jAf);
            p.h(bVar, "<set-?>");
            getSubscribeMsgListExecutor.mfz = bVar;
            if (this.mfE == 3) {
                if (this.jAf) {
                    this.mfC.bHz().RK(this.jAc.jyk.get(0).jyy);
                } else {
                    com.tencent.mm.msgsubscription.ui.b bHz = this.mfC.bHz();
                    WordingInfo wordingInfo = this.jAc.jyn;
                    if (wordingInfo == null) {
                        p.hyc();
                    }
                    bHz.RK(wordingInfo.jyQ);
                }
            }
            if (this.mfE == 2) {
                com.tencent.mm.msgsubscription.ui.b bHz2 = this.mfC.bHz();
                WordingInfo wordingInfo2 = this.jAc.jyn;
                if (wordingInfo2 == null) {
                    p.hyc();
                }
                bHz2.setDesc(wordingInfo2.jyN);
            } else if (this.jAf) {
                com.tencent.mm.msgsubscription.ui.b bHz3 = this.mfC.bHz();
                StringBuilder sb = new StringBuilder();
                WordingInfo wordingInfo3 = this.jAc.jyn;
                if (wordingInfo3 == null) {
                    p.hyc();
                }
                bHz3.setDesc(sb.append(wordingInfo3.jyO).append(this.jAc.jyk.get(0).title).toString());
            } else {
                com.tencent.mm.msgsubscription.ui.b bHz4 = this.mfC.bHz();
                WordingInfo wordingInfo4 = this.jAc.jyn;
                if (wordingInfo4 == null) {
                    p.hyc();
                }
                bHz4.setDesc(wordingInfo4.jyR);
            }
            this.mfC.bHz().RD(this.jAc.appName);
            com.tencent.mm.msgsubscription.ui.b bHz5 = this.mfC.bHz();
            WordingInfo wordingInfo5 = this.jAc.jyn;
            if (wordingInfo5 == null || (str = wordingInfo5.jyL) == null) {
                str = "";
            }
            bHz5.RE(str);
            this.mfC.bHz().setIconUrl(this.jAc.jyi);
            com.tencent.mm.msgsubscription.ui.b bHz6 = this.mfC.bHz();
            WordingInfo wordingInfo6 = this.jAc.jyn;
            if (wordingInfo6 == null) {
                p.hyc();
            }
            bHz6.RH(wordingInfo6.jyH);
            com.tencent.mm.msgsubscription.ui.b bHz7 = this.mfC.bHz();
            WordingInfo wordingInfo7 = this.jAc.jyn;
            if (wordingInfo7 == null) {
                p.hyc();
            }
            bHz7.RI(wordingInfo7.jyI);
            com.tencent.mm.msgsubscription.ui.b bHz8 = this.mfC.bHz();
            WordingInfo wordingInfo8 = this.jAc.jyn;
            if (wordingInfo8 == null) {
                p.hyc();
            }
            bHz8.RJ(wordingInfo8.jyJ);
            this.mfC.bHz().jCq = R.drawable.cg_;
            if (this.mfE == 2) {
                com.tencent.mm.msgsubscription.ui.b bHz9 = this.mfC.bHz();
                WordingInfo wordingInfo9 = this.jAc.jyn;
                if (wordingInfo9 == null) {
                    p.hyc();
                }
                bHz9.RF(wordingInfo9.jyK);
            } else {
                com.tencent.mm.msgsubscription.ui.b bHz10 = this.mfC.bHz();
                WordingInfo wordingInfo10 = this.jAc.jyn;
                if (wordingInfo10 == null) {
                    p.hyc();
                }
                bHz10.RG(wordingInfo10.jyM);
            }
            this.mfC.bHz().jCg = new b.a.AbstractC0476a(this) {
                /* class com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.GetSubscribeMsgListExecutor.d.AnonymousClass2 */
                final /* synthetic */ d mfF;

                /* JADX WARN: Incorrect args count in method signature: ()V */
                {
                    this.mfF = r1;
                }

                @Override // com.tencent.mm.msgsubscription.ui.b.a.AbstractC0476a
                public final void aC(String str, int i2) {
                    T t;
                    AppMethodBeat.i(183057);
                    p.h(str, "templateId");
                    Iterator<T> it = this.mfF.jAc.jyk.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t = null;
                            break;
                        }
                        T next = it.next();
                        if (TextUtils.equals(next.ixM, str)) {
                            t = next;
                            break;
                        }
                    }
                    if (t != null) {
                        Map map = this.mfF.mfD;
                        Integer valueOf = Integer.valueOf(i2);
                        Integer num = (Integer) this.mfF.mfD.get(Integer.valueOf(i2));
                        map.put(valueOf, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
                    }
                    AppMethodBeat.o(183057);
                }
            };
            c cVar = this.mfC.mfy;
            if (cVar != null) {
                cVar.b(this.mfC.bHz());
                AppMethodBeat.o(183058);
                return;
            }
            AppMethodBeat.o(183058);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "item", "Lcom/tencent/mm/msgsubscription/SubscribeMsgTmpItem;", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<SubscribeMsgTmpItem, Boolean> {
        final /* synthetic */ List jAe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(List list) {
            super(1);
            this.jAe = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(SubscribeMsgTmpItem subscribeMsgTmpItem) {
            Object obj;
            boolean z;
            AppMethodBeat.i(50588);
            SubscribeMsgTmpItem subscribeMsgTmpItem2 = subscribeMsgTmpItem;
            p.h(subscribeMsgTmpItem2, "item");
            Iterator it = this.jAe.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                Object next = it.next();
                if (TextUtils.equals(subscribeMsgTmpItem2.ixM, ((b.C0477b) next).ixM)) {
                    obj = next;
                    break;
                }
            }
            b.C0477b bVar = (b.C0477b) obj;
            if (bVar != null) {
                z = bVar.jCx;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(50588);
            return valueOf;
        }
    }

    private GetSubscribeMsgListExecutor(String str, List<String> list, String str2, int i2) {
        AppMethodBeat.i(169633);
        this.username = str;
        this.mfA = list;
        this.dNI = str2;
        this.appType = i2;
        this.mfx = a.mfw;
        AppMethodBeat.o(169633);
    }

    public final com.tencent.mm.msgsubscription.ui.b bHz() {
        AppMethodBeat.i(50589);
        com.tencent.mm.msgsubscription.ui.b bVar = this.mfz;
        if (bVar == null) {
            p.btv("subscribeMsgRequestDialog");
        }
        AppMethodBeat.o(50589);
        return bVar;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GetSubscribeMsgListExecutor(android.os.Parcel r6) {
        /*
            r5 = this;
            r4 = 50593(0xc5a1, float:7.0896E-41)
            java.lang.String r0 = "parcel"
            kotlin.g.b.p.h(r6, r0)
            java.lang.String r0 = r6.readString()
            if (r0 != 0) goto L_0x0037
            java.lang.String r0 = ""
            r1 = r0
        L_0x0013:
            java.util.ArrayList r0 = r6.createStringArrayList()
            if (r0 == 0) goto L_0x0032
            java.util.List r0 = (java.util.List) r0
        L_0x001b:
            java.lang.String r2 = r6.readString()
            if (r2 != 0) goto L_0x0024
            java.lang.String r2 = ""
        L_0x0024:
            int r3 = r6.readInt()
            r5.<init>(r1, r0, r2, r3)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
            com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
            return
        L_0x0032:
            kotlin.a.v r0 = kotlin.a.v.SXr
            java.util.List r0 = (java.util.List) r0
            goto L_0x001b
        L_0x0037:
            r1 = r0
            goto L_0x0013
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.msgsubscription.GetSubscribeMsgListExecutor.<init>(android.os.Parcel):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetSubscribeMsgListExecutor(String str, List<String> list, c cVar, String str2, int i2) {
        this(str, list, str2, i2);
        p.h(str, ch.COL_USERNAME);
        p.h(list, "tmplIds");
        p.h(cVar, "eventListener");
        p.h(str2, "appid");
        AppMethodBeat.i(50594);
        this.mfy = cVar;
        AppMethodBeat.o(50594);
    }

    @Override // com.tencent.mm.msgsubscription.a.b.c
    public final void a(int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
        AppMethodBeat.i(50591);
        p.h(str, "errMsg");
        c cVar = this.mfy;
        if (cVar != null) {
            cVar.a(i2, i3, str, subscribeMsgRequestResult);
            AppMethodBeat.o(50591);
            return;
        }
        AppMethodBeat.o(50591);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        AppMethodBeat.i(50592);
        if (parcel != null) {
            parcel.writeString(this.username);
        }
        if (parcel != null) {
            parcel.writeStringList(this.mfA);
        }
        if (parcel != null) {
            parcel.writeString(this.dNI);
        }
        if (parcel != null) {
            parcel.writeInt(this.appType);
            AppMethodBeat.o(50592);
            return;
        }
        AppMethodBeat.o(50592);
    }

    public final int describeContents() {
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "TAG", "", "luggage-wechat-full-sdk_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/GetSubscribeMsgListExecutor;", "luggage-wechat-full-sdk_release"})
    public static final class b implements Parcelable.Creator<GetSubscribeMsgListExecutor> {
        b() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ GetSubscribeMsgListExecutor createFromParcel(Parcel parcel) {
            AppMethodBeat.i(50585);
            p.h(parcel, "parcel");
            GetSubscribeMsgListExecutor getSubscribeMsgListExecutor = new GetSubscribeMsgListExecutor(parcel);
            AppMethodBeat.o(50585);
            return getSubscribeMsgListExecutor;
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ GetSubscribeMsgListExecutor[] newArray(int i2) {
            return new GetSubscribeMsgListExecutor[i2];
        }
    }

    static {
        AppMethodBeat.i(50595);
        AppMethodBeat.o(50595);
    }

    public final void a(Context context, SubscribeMsgRequestResult subscribeMsgRequestResult) {
        boolean z;
        AppMethodBeat.i(50590);
        p.h(context, "context");
        p.h(subscribeMsgRequestResult, "result");
        if (subscribeMsgRequestResult.jyk.size() == 0) {
            c cVar = this.mfy;
            if (cVar != null) {
                cVar.a(this.username, subscribeMsgRequestResult.jyk, null);
                AppMethodBeat.o(50590);
                return;
            }
            AppMethodBeat.o(50590);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<SubscribeMsgTmpItem> it = subscribeMsgRequestResult.jyk.iterator();
        while (it.hasNext()) {
            SubscribeMsgTmpItem next = it.next();
            if (next.jyd == 1) {
                z = true;
            } else {
                z = false;
            }
            arrayList.add(new b.C0477b(z, next.title, next.jyA, next.ixM));
        }
        boolean z2 = subscribeMsgRequestResult.jyq == 1;
        if (z2) {
            ((b.C0477b) arrayList.get(0)).jCx = true;
        }
        MMHandlerThread.postToMainThread(new d(this, subscribeMsgRequestResult, context, arrayList, new LinkedHashMap(), z2, subscribeMsgRequestResult.jyk.get(0).jyz));
        AppMethodBeat.o(50590);
    }

    public static final /* synthetic */ void a(GetSubscribeMsgListExecutor getSubscribeMsgListExecutor, List list, boolean z, int i2, String str, String str2) {
        int i3 = 0;
        AppMethodBeat.i(50596);
        com.tencent.mm.plugin.appbrand.w.b bVar = (com.tencent.mm.plugin.appbrand.w.b) com.tencent.luggage.a.e.N(com.tencent.mm.plugin.appbrand.w.b.class);
        if (bVar != null) {
            Object[] objArr = new Object[14];
            objArr[0] = -1;
            objArr[1] = Uri.encode(new JSONArray((Collection) list).toString());
            objArr[2] = Integer.valueOf(i2);
            if (z) {
                i3 = 1;
            }
            objArr[3] = Integer.valueOf(i3);
            objArr[4] = -1;
            objArr[5] = -1;
            objArr[6] = getSubscribeMsgListExecutor.username;
            objArr[7] = "";
            objArr[8] = str;
            objArr[9] = str2;
            objArr[10] = 1;
            objArr[11] = "";
            objArr[12] = getSubscribeMsgListExecutor.dNI;
            objArr[13] = Integer.valueOf(getSubscribeMsgListExecutor.appType + 1000);
            bVar.a(17524, objArr);
            AppMethodBeat.o(50596);
            return;
        }
        AppMethodBeat.o(50596);
    }

    public static final /* synthetic */ List i(List list, List list2) {
        AppMethodBeat.i(50597);
        e eVar = new e(list2);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SubscribeMsgTmpItem subscribeMsgTmpItem = (SubscribeMsgTmpItem) it.next();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("templateType", String.valueOf(subscribeMsgTmpItem.jyz));
            linkedHashMap.put("selected", String.valueOf(((Boolean) eVar.invoke(subscribeMsgTmpItem)).booleanValue()));
            linkedHashMap.put("templateID", subscribeMsgTmpItem.ixM);
            arrayList.add(linkedHashMap);
        }
        AppMethodBeat.o(50597);
        return arrayList;
    }
}
