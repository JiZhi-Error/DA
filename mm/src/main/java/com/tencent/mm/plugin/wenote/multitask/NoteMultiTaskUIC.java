package com.tencent.mm.plugin.wenote.multitask;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.multitask.d;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent;
import com.tencent.mm.plugin.multitask.ui.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.c;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.protocal.protobuf.crt;
import com.tencent.mm.protocal.protobuf.ctx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J,\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\u0014\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\u0014\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010\u001e2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskUIC;", "Lcom/tencent/mm/plugin/multitask/ui/MultiTaskUIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "bundleToJson", "", "bundle", "Landroid/os/Bundle;", "getMultiTaskMode", "Lcom/tencent/mm/plugin/multitask/ui/IMultiTaskUIComponent$MultiTaskMode;", "jsonToBundle", "json", "onMultiTaskInit", "", "obj", "", "onMultiTaskItemClick", "view", "Landroid/view/View;", "info", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "animateData", "Lcom/tencent/mm/protocal/protobuf/MultiTaskAnimData;", "callback", "openNoteFromTopItem", "topItem", "Lcom/tencent/mm/plugin/wenote/model/datamodel/WNNoteKeepTopItem;", "parseNotifyWNNoteOperationEventData", "Lcom/tencent/mm/autogen/events/NotifyWNNoteOperationEvent$Data;", "parseOpenNoteFromSessionEventData", "Lcom/tencent/mm/autogen/events/OpenNoteFromSessionEvent$Data;", "parseWNNoteKeepTopItem", "supportMultiTaskType", "", "multiTaskType", "", "Companion", "app_release"})
public final class NoteMultiTaskUIC extends MultiTaskUIComponent {
    public static final a JJq = new a((byte) 0);

    static {
        AppMethodBeat.i(230931);
        AppMethodBeat.o(230931);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/wenote/multitask/NoteMultiTaskUIC$Companion;", "", "()V", "NoteDataType_FAV_SNS", "", "NoteDataType_SESSION", "NoteDataType_TOP_ITEM", "TAG", "", "app_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoteMultiTaskUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(230929);
        AppMethodBeat.o(230929);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoteMultiTaskUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(230930);
        AppMethodBeat.o(230930);
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final boolean Js(int i2) {
        return i2 == 3;
    }

    @Override // com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void dk(Object obj) {
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.plugin.multitask.ui.a, com.tencent.mm.plugin.multitask.ui.MultiTaskUIComponent
    public final void a(View view, MultiTaskInfo multiTaskInfo, crq crq, Object obj) {
        g DY;
        AppMethodBeat.i(230924);
        p.h(multiTaskInfo, "info");
        p.h(crq, "animateData");
        ach ach = new ach();
        ach.LmQ = crq;
        if (view != null) {
            SecDataUIC.a aVar = SecDataUIC.CWq;
            Context context = view.getContext();
            p.g(context, "view.context");
            SecDataUIC gU = SecDataUIC.a.gU(context);
            crt crt = gU != null ? (crt) gU.Xh(5) : null;
            ach.sGQ = crt != null ? crt.sGQ : null;
        }
        ctx ctx = new ctx();
        try {
            ctx.parseFrom(multiTaskInfo.field_data);
            int i2 = ctx.dRq;
            String str = ctx.Mzh;
            switch (i2) {
                case 1:
                    oc.a bbL = bbL(str);
                    if (bbL == null) {
                        Log.e("MicroMsg.NoteMultiTaskUIC", "NotifyWNNoteOperationEvent data is null");
                        AppMethodBeat.o(230924);
                        return;
                    }
                    bbL.dUl.putByteArray("key_multi_task_common_info", ach.toByteArray());
                    if (bbL.type == 9 && (DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(bbL.field_localId)) != null) {
                        bbL.dUg = DY.field_xml;
                        Bundle bundle = new Bundle();
                        amv guj = DY.field_favProto.guj();
                        p.g(guj, "favItemInfo.field_favProto.getNoteInfo()");
                        if (guj != null) {
                            bundle.putString("noteauthor", guj.LxT);
                            bundle.putString("noteeditor", guj.LxU);
                        }
                        bundle.putLong("edittime", DY.field_updateTime);
                        bbL.dUl = bundle;
                        bbL.field_favProto = DY.field_favProto;
                        bbL.type = 2;
                    }
                    oc ocVar = new oc();
                    com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(af.class);
                    p.g(ah, "MMKernel.plugin(IPluginFav::class.java)");
                    if (((af) ah).getFavItemInfoStorage().DY(bbL.field_localId) != null) {
                        ocVar.dUe = bbL;
                        EventCenter.instance.publish(ocVar);
                        AppMethodBeat.o(230924);
                        return;
                    }
                    Log.e("MicroMsg.NoteMultiTaskUIC", "favItemInfo id deleted");
                    u.makeText(MMApplicationContext.getContext(), (int) R.string.feb, 0).show();
                    ((d) com.tencent.mm.kernel.g.ah(d.class)).removeTaskInfoAndCoverImg(multiTaskInfo.field_id);
                    AppMethodBeat.o(230924);
                    return;
                case 2:
                    pa.a bbK = bbK(str);
                    if (bbK == null) {
                        Log.e("MicroMsg.NoteMultiTaskUIC", "OpenNoteFromSessionEvent data is null");
                        AppMethodBeat.o(230924);
                        return;
                    }
                    bbK.dUl = new Bundle();
                    bbK.dUl.putByteArray("key_multi_task_common_info", ach.toByteArray());
                    pa paVar = new pa();
                    paVar.dVb = bbK;
                    EventCenter.instance.publish(paVar);
                    AppMethodBeat.o(230924);
                    return;
                case 3:
                    Log.i("MicroMsg.NoteMultiTaskUIC", "click WNNoteBanner");
                    q bbN = bbN(str);
                    if (bbN != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putByteArray("key_multi_task_common_info", ach.toByteArray());
                        if (!bbN.JHR) {
                            h.INSTANCE.a(14789, 1);
                            Log.i("MicroMsg.NoteMultiTaskUIC", "isOpenFromSession: false");
                            com.tencent.mm.plugin.wenote.model.g gVar = new com.tencent.mm.plugin.wenote.model.g();
                            gVar.JGY = com.tencent.mm.plugin.wenote.b.a.b(bbN);
                            gVar.JGZ = 3;
                            c gjz = c.gjz();
                            p.g(gjz, "SubCoreWNNoteMsg.getCore()");
                            gjz.a(gVar);
                            and and = new and();
                            and.scene = 8;
                            gVar.a(bbN.JHS, MMApplicationContext.getContext(), Boolean.TRUE, bbN.JHW, bbN.JHX, and, null, bundle2.getByteArray("key_multi_task_common_info"));
                            break;
                        } else {
                            if (bbN.tcb) {
                                h.INSTANCE.a(14789, 3);
                            } else {
                                h.INSTANCE.a(14789, 2);
                            }
                            Log.i("MicroMsg.NoteMultiTaskUIC", "isOpenFromSession: true");
                            j jVar = new j();
                            jVar.JGY = com.tencent.mm.plugin.wenote.b.a.b(bbN);
                            jVar.JGZ = 3;
                            c gjz2 = c.gjz();
                            p.g(gjz2, "SubCoreWNNoteMsg.getCore()");
                            gjz2.a(jVar);
                            and and2 = new and();
                            and2.scene = 8;
                            jVar.a(bbN.JHV, Long.valueOf(bbN.JHT), true, MMApplicationContext.getContext(), bbN.JHW, bbN.JHX, and2, bundle2);
                            AppMethodBeat.o(230924);
                            return;
                        }
                    } else {
                        Log.e("MicroMsg.NoteMultiTaskUIC", "WNNoteKeepTopItem data is null");
                        AppMethodBeat.o(230924);
                        return;
                    }
            }
            AppMethodBeat.o(230924);
        } catch (Exception e2) {
            Log.e("MicroMsg.NoteMultiTaskUIC", e2.getMessage());
            AppMethodBeat.o(230924);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.ui.a
    public final a.b dks() {
        return a.b.MODE_SHOW_MULTI_SCENE;
    }

    private static oc.a bbL(String str) {
        AppMethodBeat.i(230925);
        try {
            JSONObject jSONObject = new JSONObject(str);
            oc.a aVar = new oc.a();
            aVar.type = jSONObject.getInt("type");
            aVar.dUg = jSONObject.getString("editorId");
            aVar.field_localId = jSONObject.getLong("field_localId");
            aVar.dUi = jSONObject.getString("insertJsonData");
            aVar.dUj = jSONObject.getString("exportJsonData");
            aVar.dUk = jSONObject.getBoolean("isInsert");
            String string = jSONObject.getString("bundleData");
            if (p.j(string, "")) {
                aVar.dUl = null;
            } else {
                p.g(string, "bd");
                aVar.dUl = bbM(string);
            }
            aVar.dUm = jSONObject.getInt("itemType");
            aVar.path = jSONObject.getString("path");
            aVar.dUn = jSONObject.getInt("intdata");
            aVar.dUo = jSONObject.getBoolean("showShare");
            aVar.field_favProto = new anb();
            String string2 = jSONObject.getString("field_favProto");
            if (!Util.isNullOrNil(string2)) {
                aVar.field_favProto.parseFrom(Base64.decode(string2, 0));
            }
            aVar.dUp = new and();
            String string3 = jSONObject.getString("reportInfo");
            if (!Util.isNullOrNil(string3)) {
                aVar.dUp.parseFrom(Base64.decode(string3, 0));
            }
            aVar.context = MMApplicationContext.getContext();
            AppMethodBeat.o(230925);
            return aVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", e2, "parse NotifyWNNoteOperationEvent", new Object[0]);
            AppMethodBeat.o(230925);
            return null;
        }
    }

    private static Bundle bbM(String str) {
        AppMethodBeat.i(230926);
        Bundle bundle = new Bundle();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            p.g(keys, "jsonObject.keys()");
            while (keys.hasNext()) {
                String next = keys.next();
                if (next == null) {
                    t tVar = new t("null cannot be cast to non-null type kotlin.String");
                    AppMethodBeat.o(230926);
                    throw tVar;
                }
                String str2 = next;
                bundle.putString(str2, jSONObject.getString(str2));
            }
            AppMethodBeat.o(230926);
            return bundle;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", e2, "jsonToBundle", new Object[0]);
            AppMethodBeat.o(230926);
            return null;
        }
    }

    private static pa.a bbK(String str) {
        AppMethodBeat.i(230927);
        try {
            JSONObject jSONObject = new JSONObject(str);
            pa.a aVar = new pa.a();
            aVar.msgId = jSONObject.getLong("msgId");
            aVar.dVc = jSONObject.getString("noteXmlStr");
            aVar.dUo = jSONObject.getBoolean("showShare");
            aVar.scene = jSONObject.getInt("scene");
            aVar.context = MMApplicationContext.getContext();
            AppMethodBeat.o(230927);
            return aVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", e2, "parseOpenNoteFromSessionEventData", new Object[0]);
            AppMethodBeat.o(230927);
            return null;
        }
    }

    private static q bbN(String str) {
        AppMethodBeat.i(230928);
        try {
            q qVar = new q();
            JSONObject jSONObject = new JSONObject(str);
            qVar.JHR = jSONObject.getBoolean("topIsOpenFromSession");
            qVar.JHS = jSONObject.getLong("topLocalId");
            qVar.JHT = jSONObject.getLong("topMsgId");
            qVar.tcb = jSONObject.getBoolean("isChatRoom");
            qVar.JHU = jSONObject.getString("topTitle");
            qVar.JHV = jSONObject.getString("topNoteXml");
            qVar.JHW = jSONObject.getInt("topLastPosition");
            qVar.JHX = jSONObject.getInt("topLastOffset");
            AppMethodBeat.o(230928);
            return qVar;
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.NoteMultiTaskUIC", e2, "parseWNNoteKeepTopItem", new Object[0]);
            AppMethodBeat.o(230928);
            return null;
        }
    }
}
