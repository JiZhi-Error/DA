package com.tencent.mm.plugin.secdata.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.secdata.d;
import com.tencent.mm.plugin.secdata.e;
import com.tencent.mm.plugin.secdata.f;
import com.tencent.mm.plugin.secdata.h;
import com.tencent.mm.protocal.protobuf.aci;
import com.tencent.mm.protocal.protobuf.acj;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.UUID;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 22\u00020\u0001:\u00012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u001f\u0010\u0019\u001a\u0004\u0018\u0001H\u001a\"\b\b\u0000\u0010\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000b¢\u0006\u0002\u0010\u001dJ \u0010\u001e\u001a\n\u0012\u0004\u0012\u0002H\u001a\u0018\u00010\f\"\b\b\u0000\u0010\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000bJ5\u0010\u001f\u001a\u0004\u0018\u0001H\u001a\"\b\b\u0000\u0010\u001a*\u00020\u001b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\f\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u001a0\"¢\u0006\u0002\u0010#J\u0014\u0010$\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00112\u0006\u0010\u001c\u001a\u00020\u000bJ\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0012\u0010)\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J$\u0010-\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010.\u001a\u00020\u000b2\b\u0010/\u001a\u0004\u0018\u00010+H\u0016J\u001e\u00100\u001a\u00020&\"\b\b\u0000\u0010\u001a*\u00020\u001b2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H\u001a0\fJ\u001e\u00100\u001a\u00020&\"\b\b\u0000\u0010\u001a*\u00020\u001b2\f\u00101\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0011R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR5\u0010\t\u001a&\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\nj\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR5\u0010\u0010\u001a&\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00110\nj\u0012\u0012\u0004\u0012\u00020\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0011`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u00063"}, hxF = {"Lcom/tencent/mm/plugin/secdata/ui/SecDataUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "listSecDataMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/secdata/IListSecData;", "Lkotlin/collections/HashMap;", "getListSecDataMap", "()Ljava/util/HashMap;", "pageSecDataMap", "Lcom/tencent/mm/plugin/secdata/ISecData;", "getPageSecDataMap", "reportObjList", "Lcom/tencent/mm/protocal/protobuf/CommonReportObjList;", "getReportObjList", "()Lcom/tencent/mm/protocal/protobuf/CommonReportObjList;", "getCurrentCommonReportObj", "Lcom/tencent/mm/protocal/protobuf/CommonReportObj;", "getCurrentSubReportObj", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "type", "(I)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getListSecData", "getPreSubReportObj", "pageIndex", "clazz", "Ljava/lang/Class;", "(IILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getSecData", "initUICData", "", "intent", "Landroid/content/Intent;", "onCreateBefore", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "onStartActivityForResult", "requestCode", "options", "registerSecData", "secData", "Companion", "ui-sec-data_release"})
public final class SecDataUIC extends UIComponent {
    public static final a CWq = new a((byte) 0);
    private final acj CWn = new acj();
    private final HashMap<Integer, h<?>> CWo = new HashMap<>();
    private final HashMap<Integer, f<?>> CWp = new HashMap<>();
    private final String TAG = "MicroMsg.SecData.SecDataUIC";

    static {
        AppMethodBeat.i(224085);
        AppMethodBeat.o(224085);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SecDataUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(224084);
        AppMethodBeat.o(224084);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreateBefore(Bundle bundle) {
        AppMethodBeat.i(224073);
        super.onCreateBefore(bundle);
        aT(getIntent());
        AppMethodBeat.o(224073);
    }

    private final void aT(Intent intent) {
        AppMethodBeat.i(224074);
        this.CWo.clear();
        this.CWp.clear();
        this.CWn.oTA.clear();
        byte[] byteArrayExtra = intent.getByteArrayExtra("ReportKey.CommonReportObjKey");
        if (byteArrayExtra != null) {
            try {
                this.CWn.parseFrom(byteArrayExtra);
            } catch (Exception e2) {
            }
        }
        aci aci = new aci();
        aci.LmS = getActivity().getClass().getSimpleName();
        aci.LmT = cl.aWA();
        LinkedList<aci> linkedList = this.CWn.oTA;
        p.g(linkedList, "reportObjList.List");
        aci aci2 = (aci) j.kt(linkedList);
        if (aci2 != null) {
            aci.KXB = aci2.KXB;
            aci.LmU = aci2.LmU;
            aci.LmV = 0;
            Log.i(this.TAG, "fromPage:" + aci2.LmS + " contextId:" + aci2.KXB + " currentPage:" + aci.LmS);
        } else {
            aci.KXB = UUID.randomUUID().toString();
            aci.LmU = 0;
            aci.LmV = 1;
            Log.i(this.TAG, "firstPage:" + aci.LmS + " contextId:" + aci.KXB);
        }
        this.CWn.oTA.addFirst(aci);
        if (this.CWn.oTA.size() > 5) {
            this.CWn.oTA.removeLast();
        }
        AppMethodBeat.o(224074);
    }

    public final <T extends com.tencent.mm.bw.a> void a(h<T> hVar) {
        AppMethodBeat.i(224075);
        p.h(hVar, "secData");
        this.CWo.put(Integer.valueOf(hVar.getType()), hVar);
        AppMethodBeat.o(224075);
    }

    public final <T extends com.tencent.mm.bw.a> void a(f<T> fVar) {
        AppMethodBeat.i(224076);
        p.h(fVar, "secData");
        this.CWp.put(Integer.valueOf(fVar.getType()), fVar);
        AppMethodBeat.o(224076);
    }

    public final <T extends com.tencent.mm.bw.a> T f(int i2, Class<T> cls) {
        aci aci;
        LinkedList<ack> linkedList;
        T t;
        boolean z;
        AppMethodBeat.i(224077);
        p.h(cls, "clazz");
        LinkedList<aci> linkedList2 = this.CWn.oTA;
        if (!(linkedList2.size() > 1)) {
            linkedList2 = null;
        }
        if (!(linkedList2 == null || (aci = linkedList2.get(1)) == null || (linkedList = aci.LmW) == null)) {
            Iterator<T> it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                if (next.oUv == i2) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    t = next;
                    break;
                }
            }
            T t2 = t;
            if (t2 != null) {
                T newInstance = cls.newInstance();
                p.g(newInstance, "clazz.newInstance()");
                T t3 = newInstance;
                t3.parseFrom(t2.oTm.toByteArray());
                AppMethodBeat.o(224077);
                return t3;
            }
        }
        AppMethodBeat.o(224077);
        return null;
    }

    public final h<?> Xg(int i2) {
        AppMethodBeat.i(224078);
        h<?> hVar = this.CWo.get(Integer.valueOf(i2));
        AppMethodBeat.o(224078);
        return hVar;
    }

    public final <T extends com.tencent.mm.bw.a> f<T> eSr() {
        AppMethodBeat.i(224079);
        Object obj = this.CWp.get(1);
        if (!(obj instanceof f)) {
            obj = null;
        }
        f<T> fVar = (f) obj;
        AppMethodBeat.o(224079);
        return fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mm.bw.a] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends com.tencent.mm.bw.a> T Xh(int r5) {
        /*
            r4 = this;
            r1 = 0
            r3 = 224080(0x36b50, float:3.14003E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
            com.tencent.mm.plugin.secdata.h r0 = r4.Xg(r5)
            if (r0 == 0) goto L_0x0019
            com.tencent.mm.bw.a r0 = r0.eSl()
        L_0x0011:
            boolean r2 = r0 instanceof com.tencent.mm.bw.a
            if (r2 != 0) goto L_0x001b
        L_0x0015:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
            return r1
        L_0x0019:
            r0 = r1
            goto L_0x0011
        L_0x001b:
            r1 = r0
            goto L_0x0015
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.secdata.ui.SecDataUIC.Xh(int):com.tencent.mm.bw.a");
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onNewIntent(Intent intent) {
        boolean z = true;
        AppMethodBeat.i(224081);
        Log.i(this.TAG, "onNewIntent ".concat(String.valueOf(intent)));
        if (intent != null) {
            Intent intent2 = intent.getByteArrayExtra("ReportKey.CommonReportObjKey") != null ? intent : null;
            if (intent2 != null) {
                aT(intent2);
                AppMethodBeat.o(224081);
                return;
            }
        }
        SecDataUIC secDataUIC = this;
        Intent intent3 = secDataUIC.getIntent();
        if ((intent != null ? intent.getByteArrayExtra("ReportKey.CommonReportObjKey") : null) == null) {
            z = false;
        }
        if (!z) {
            intent3 = null;
        }
        if (intent3 != null) {
            secDataUIC.aT(intent3);
            AppMethodBeat.o(224081);
            return;
        }
        AppMethodBeat.o(224081);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onStartActivityForResult(Intent intent, int i2, Bundle bundle) {
        LinkedList<ack> linkedList;
        LinkedList<ack> linkedList2;
        LinkedList<ack> linkedList3;
        AppMethodBeat.i(224082);
        try {
            HashSet<Number> hashSet = new HashSet();
            Collection<h<?>> values = this.CWo.values();
            p.g(values, "pageSecDataMap.values");
            for (T t : values) {
                if (t.aS(intent)) {
                    ack ack = new ack();
                    ack.oUv = t.getType();
                    ack.oTm = new b(t.eSl().toByteArray());
                    aci eSs = eSs();
                    if (!(eSs == null || (linkedList3 = eSs.LmW) == null)) {
                        linkedList3.add(ack);
                    }
                    if (!t.eSm()) {
                        hashSet.add(Integer.valueOf(t.getType()));
                    }
                }
            }
            for (Number number : hashSet) {
                this.CWo.remove(Integer.valueOf(number.intValue()));
            }
            String str = this.TAG;
            StringBuilder sb = new StringBuilder("onStartActivityForResult SubObjList.size:");
            aci eSs2 = eSs();
            Log.i(str, sb.append((eSs2 == null || (linkedList2 = eSs2.LmW) == null) ? null : Integer.valueOf(linkedList2.size())).append(", requestCode:").append(i2).append(" options:").append(bundle).toString());
            if (intent != null) {
                intent.putExtra("ReportKey.CommonReportObjKey", this.CWn.toByteArray());
            }
            aci eSs3 = eSs();
            if (eSs3 == null || (linkedList = eSs3.LmW) == null) {
                AppMethodBeat.o(224082);
                return;
            }
            linkedList.clear();
            AppMethodBeat.o(224082);
        } catch (Exception e2) {
            AppMethodBeat.o(224082);
        }
    }

    private aci eSs() {
        AppMethodBeat.i(224083);
        LinkedList<aci> linkedList = this.CWn.oTA;
        p.g(linkedList, "reportObjList.List");
        aci aci = (aci) j.kt(linkedList);
        AppMethodBeat.o(224083);
        return aci;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000b¢\u0006\u0002\u0010\fJ=\u0010\r\u001a\u0004\u0018\u0001H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000b¢\u0006\u0002\u0010\u0010J=\u0010\u0011\u001a\u0004\u0018\u0001H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000b¢\u0006\u0002\u0010\u0013J5\u0010\u0014\u001a\u0004\u0018\u0001H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000b¢\u0006\u0002\u0010\fJ'\u0010\u0015\u001a\u0004\u0018\u0001H\u0004\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J-\u0010\u0019\u001a\u00020\u001a\"\b\b\u0000\u0010\u0004*\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u0002H\u0004¢\u0006\u0002\u0010\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006 "}, hxF = {"Lcom/tencent/mm/plugin/secdata/ui/SecDataUIC$Companion;", "", "()V", "getDefaultSecDataObj", "T", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "context", "Landroid/content/Context;", "type", "", "clazz", "Ljava/lang/Class;", "(Landroid/content/Context;ILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getOneTimeActivitySecDataObj", "activityName", "", "(Landroid/content/Context;Ljava/lang/String;ILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getPreSecDataObj", "pageIndex", "(Landroid/content/Context;IILjava/lang/Class;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "getSecDataObj", "onDefaultItemChildViewClick", "view", "Landroid/view/View;", "(ILandroid/view/View;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "onDefaultListSecDataGetView", "", "convertView", "data", "(ILandroid/view/View;Lcom/tencent/mm/protobuf/BaseProtoBuf;)V", "uic", "Lcom/tencent/mm/plugin/secdata/ui/SecDataUIC;", "ui-sec-data_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static SecDataUIC gU(Context context) {
            AppMethodBeat.i(224067);
            p.h(context, "context");
            if (context instanceof UIComponentActivity) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                SecDataUIC secDataUIC = (SecDataUIC) com.tencent.mm.ui.component.a.b((AppCompatActivity) context).get(SecDataUIC.class);
                AppMethodBeat.o(224067);
                return secDataUIC;
            }
            AppMethodBeat.o(224067);
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [com.tencent.mm.bw.a] */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static <T extends com.tencent.mm.bw.a> T a(android.content.Context r4, int r5, java.lang.Class<T> r6) {
            /*
                r1 = 0
                r3 = 224068(0x36b44, float:3.13986E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r3)
                java.lang.String r0 = "context"
                kotlin.g.b.p.h(r4, r0)
                java.lang.String r0 = "clazz"
                kotlin.g.b.p.h(r6, r0)
                com.tencent.mm.plugin.secdata.ui.SecDataUIC r0 = gU(r4)
                if (r0 == 0) goto L_0x002b
                com.tencent.mm.plugin.secdata.h r0 = r0.Xg(r5)
                if (r0 == 0) goto L_0x002b
                com.tencent.mm.bw.a r0 = r0.eSl()
            L_0x0023:
                boolean r2 = r0 instanceof com.tencent.mm.bw.a
                if (r2 != 0) goto L_0x002d
            L_0x0027:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r3)
                return r1
            L_0x002b:
                r0 = r1
                goto L_0x0023
            L_0x002d:
                r1 = r0
                goto L_0x0027
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.secdata.ui.SecDataUIC.a.a(android.content.Context, int, java.lang.Class):com.tencent.mm.bw.a");
        }

        public static <T extends com.tencent.mm.bw.a> T b(Context context, int i2, Class<T> cls) {
            AppMethodBeat.i(224069);
            p.h(context, "context");
            p.h(cls, "clazz");
            SecDataUIC gU = gU(context);
            if (gU != null) {
                T t = (T) gU.f(i2, cls);
                AppMethodBeat.o(224069);
                return t;
            }
            AppMethodBeat.o(224069);
            return null;
        }

        public static <T extends com.tencent.mm.bw.a> T a(Context context, String str, int i2, Class<T> cls) {
            AppMethodBeat.i(224070);
            p.h(context, "context");
            p.h(str, "activityName");
            p.h(cls, "clazz");
            SecDataUIC gU = gU(context);
            com.tencent.mm.plugin.secdata.a Xg = gU != null ? gU.Xg(i2) : null;
            if (Xg == null) {
                Xg = new com.tencent.mm.plugin.secdata.a(str, cls, i2, false);
                SecDataUIC gU2 = gU(context);
                if (gU2 != null) {
                    gU2.a(Xg);
                }
            }
            T t = (T) Xg.eSl();
            if (!(t instanceof com.tencent.mm.bw.a)) {
                t = null;
            }
            AppMethodBeat.o(224070);
            return t;
        }

        public static <T extends com.tencent.mm.bw.a> T c(Context context, int i2, Class<T> cls) {
            AppMethodBeat.i(224071);
            p.h(context, "context");
            p.h(cls, "clazz");
            SecDataUIC gU = gU(context);
            e Xg = gU != null ? gU.Xg(i2) : null;
            if (Xg == null) {
                Xg = new e(cls, i2);
                SecDataUIC gU2 = gU(context);
                if (gU2 != null) {
                    gU2.a(Xg);
                }
            }
            T t = (T) Xg.eSl();
            if (!(t instanceof com.tencent.mm.bw.a)) {
                t = null;
            }
            AppMethodBeat.o(224071);
            return t;
        }

        public static <T extends com.tencent.mm.bw.a> void a(View view, T t) {
            AppMethodBeat.i(224072);
            p.h(view, "convertView");
            p.h(t, "data");
            Context context = view.getContext();
            p.g(context, "convertView.context");
            SecDataUIC gU = gU(context);
            d eSr = gU != null ? gU.eSr() : null;
            if (eSr == null) {
                eSr = new d();
                Context context2 = view.getContext();
                p.g(context2, "convertView.context");
                SecDataUIC gU2 = gU(context2);
                if (gU2 != null) {
                    gU2.a(eSr);
                }
            }
            eSr.c(String.valueOf(view.hashCode()), t);
            AppMethodBeat.o(224072);
        }
    }
}
