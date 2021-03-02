package com.tencent.mm.msgsubscription.util;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.msgsubscription.SubscribeMsgRequestResult;
import com.tencent.mm.msgsubscription.SubscribeMsgTmpItem;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.presenter.SubscribeMsgSettingData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00040\bJ,\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u00040\b¨\u0006\r"}, hxF = {"Lcom/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper;", "", "()V", "getSubscribeMsgInfoByNetScene", "", "userName", "", "receiver", "Lkotlin/Function1;", "Lcom/tencent/mm/msgsubscription/presenter/SubscribeMsgSettingData;", "syncSetting2Server", "data", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
public final class c {
    public static final c jDh = new c();

    static {
        AppMethodBeat.i(149823);
        AppMethodBeat.o(149823);
    }

    private c() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper$getSubscribeMsgInfoByNetScene$netScene$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    public static final class a implements b.c {
        final /* synthetic */ String jDi;
        final /* synthetic */ kotlin.g.a.b jDj;

        a(String str, kotlin.g.a.b bVar) {
            this.jDi = str;
            this.jDj = bVar;
        }

        @Override // com.tencent.mm.msgsubscription.a.b.c
        public final void a(int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            AppMethodBeat.i(149819);
            p.h(str, "errMsg");
            if (i2 != 0 || i3 != 0) {
                this.jDj.invoke(null);
                AppMethodBeat.o(149819);
            } else if (subscribeMsgRequestResult != null) {
                com.tencent.mm.msgsubscription.api.b bVar = com.tencent.mm.msgsubscription.api.b.jza;
                com.tencent.mm.msgsubscription.b.a Ru = com.tencent.mm.msgsubscription.api.b.Ru("name_wxa");
                if (Ru != null) {
                    Ru.a(this.jDi, (List<SubscribeMsgTmpItem>) subscribeMsgRequestResult.jyk, subscribeMsgRequestResult.jyo, true, false);
                }
                this.jDj.invoke(new SubscribeMsgSettingData(subscribeMsgRequestResult, (byte) 0));
                AppMethodBeat.o(149819);
            } else {
                this.jDj.invoke(null);
                AppMethodBeat.o(149819);
            }
        }
    }

    public static void c(String str, kotlin.g.a.b<? super SubscribeMsgSettingData, x> bVar) {
        AppMethodBeat.i(149821);
        p.h(str, "userName");
        p.h(bVar, "receiver");
        b.a.C0462a aVar = b.a.jzu;
        b.a.C0462a.a(str, new a(str, bVar)).a(com.tencent.mm.msgsubscription.a.a.jzi);
        AppMethodBeat.o(149821);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/msgsubscription/util/WxaSubscribeMsgSettingDataHelper$syncSetting2Server$netSceneSubscribeMsg$1", "Lcom/tencent/mm/msgsubscription/cgi/NetSceneSubscribeMsg$IOnNetSceneSubscribeEndCallback;", "onNetSceneEndCallback", "", "errType", "", "errCode", "errMsg", "", "result", "Lcom/tencent/mm/msgsubscription/SubscribeMsgRequestResult;", "plugin-comm_release"})
    public static final class b implements b.c {
        final /* synthetic */ String jDi;
        final /* synthetic */ kotlin.g.a.b jDj;

        b(kotlin.g.a.b bVar, String str) {
            this.jDj = bVar;
            this.jDi = str;
        }

        @Override // com.tencent.mm.msgsubscription.a.b.c
        public final void a(int i2, int i3, String str, SubscribeMsgRequestResult subscribeMsgRequestResult) {
            AppMethodBeat.i(149820);
            p.h(str, "errMsg");
            if (i2 == 0 && i3 == 0) {
                com.tencent.mm.msgsubscription.api.b bVar = com.tencent.mm.msgsubscription.api.b.jza;
                com.tencent.mm.msgsubscription.b.a Ru = com.tencent.mm.msgsubscription.api.b.Ru("name_wxa");
                if (!(Ru == null || subscribeMsgRequestResult == null)) {
                    Ru.a(this.jDi, (List<SubscribeMsgTmpItem>) subscribeMsgRequestResult.jyk, subscribeMsgRequestResult.jyo, true, false);
                }
                this.jDj.invoke(subscribeMsgRequestResult);
                AppMethodBeat.o(149820);
                return;
            }
            this.jDj.invoke(null);
            AppMethodBeat.o(149820);
        }
    }

    public static void a(String str, SubscribeMsgSettingData subscribeMsgSettingData, kotlin.g.a.b<? super SubscribeMsgRequestResult, x> bVar) {
        T t;
        AppMethodBeat.i(149822);
        p.h(str, "userName");
        p.h(subscribeMsgSettingData, "data");
        p.h(bVar, "receiver");
        b.a.C0462a aVar = b.a.jzu;
        ArrayList arrayList = new ArrayList();
        for (T t2 : subscribeMsgSettingData.iHf) {
            Iterator<T> it = subscribeMsgSettingData.jAj.jyk.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                if (TextUtils.equals(next.ixM, t2.ixM)) {
                    t = next;
                    break;
                }
            }
            T t3 = t;
            if (t3 != null) {
                if (t3.jyB != t2.jyB) {
                    arrayList.add(t2);
                }
            }
        }
        boolean z = subscribeMsgSettingData.iQD;
        p.h(str, ch.COL_USERNAME);
        p.h(arrayList, "templates");
        b.a.C0462a.a(str, "", z, new b(bVar, str), arrayList, new byte[0]).a(com.tencent.mm.msgsubscription.a.a.jzi);
        AppMethodBeat.o(149822);
    }
}
