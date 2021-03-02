package com.tencent.mm.plugin.wenote.multitask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.g.a.pa;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.taskbar.api.c;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.j;
import com.tencent.mm.plugin.wenote.ui.nativenote.NoteEditorUI;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.cru;
import com.tencent.mm.protocal.protobuf.ctx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.t;
import org.json.JSONObject;

public final class a extends c {
    private static final b JJn = new b();
    public static final C2007a JJo = new C2007a((byte) 0);
    private final NoteEditorUI JJm;
    public String data = "";
    public String title = "";
    public int type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(NoteEditorUI noteEditorUI, com.tencent.mm.plugin.multitask.a.a aVar) {
        super(aVar);
        p.h(noteEditorUI, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(aVar, "pageAdapter");
        AppMethodBeat.i(230921);
        this.JJm = noteEditorUI;
        Log.i("MicroMsg.NoteMultiTaskHelper", "create, NoteEditorUI:%s", Integer.valueOf(this.JJm.hashCode()));
        AppMethodBeat.o(230921);
    }

    /* renamed from: com.tencent.mm.plugin.wenote.multitask.a$a */
    public static final class C2007a {
        private C2007a() {
        }

        public /* synthetic */ C2007a(byte b2) {
            this();
        }

        static oc.a bbL(String str) {
            AppMethodBeat.i(230912);
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
                AppMethodBeat.o(230912);
                return aVar;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", e2, "parse NotifyWNNoteOperationEvent", new Object[0]);
                AppMethodBeat.o(230912);
                return null;
            }
        }

        private static Bundle bbM(String str) {
            AppMethodBeat.i(230913);
            Bundle bundle = new Bundle();
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator<String> keys = jSONObject.keys();
                p.g(keys, "jsonObject.keys()");
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.String");
                        AppMethodBeat.o(230913);
                        throw tVar;
                    }
                    String str2 = next;
                    bundle.putString(str2, jSONObject.getString(str2));
                }
                AppMethodBeat.o(230913);
                return bundle;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", e2, "jsonToBundle", new Object[0]);
                AppMethodBeat.o(230913);
                return null;
            }
        }

        static pa.a bbK(String str) {
            AppMethodBeat.i(230914);
            try {
                JSONObject jSONObject = new JSONObject(str);
                pa.a aVar = new pa.a();
                aVar.msgId = jSONObject.getLong("msgId");
                aVar.dVc = jSONObject.getString("noteXmlStr");
                aVar.dUo = jSONObject.getBoolean("showShare");
                aVar.scene = jSONObject.getInt("scene");
                aVar.context = MMApplicationContext.getContext();
                AppMethodBeat.o(230914);
                return aVar;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", e2, "parseOpenNoteFromSessionEventData", new Object[0]);
                AppMethodBeat.o(230914);
                return null;
            }
        }

        static q bbN(String str) {
            AppMethodBeat.i(230915);
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
                AppMethodBeat.o(230915);
                return qVar;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.NoteMultiTaskHelper", e2, "parseWNNoteKeepTopItem", new Object[0]);
                AppMethodBeat.o(230915);
                return null;
            }
        }
    }

    public static final class b implements c.a {
        b() {
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void a(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(230909);
            p.h(multiTaskInfo, "multiTaskInfo");
            AppMethodBeat.o(230909);
        }

        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void b(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(230910);
            p.h(multiTaskInfo, "multiTaskInfo");
            ctx ctx = new ctx();
            try {
                ctx.parseFrom(multiTaskInfo.field_data);
                ach ach = new ach();
                ach.LmR = true;
                int i2 = ctx.dRq;
                String str = ctx.Mzh;
                switch (i2) {
                    case 1:
                        C2007a aVar = a.JJo;
                        oc.a bbL = C2007a.bbL(str);
                        if (bbL == null) {
                            Log.e("MicroMsg.NoteMultiTaskHelper", "NotifyWNNoteOperationEvent data is null");
                            AppMethodBeat.o(230910);
                            return;
                        }
                        try {
                            bbL.dUl.putByteArray("key_multi_task_common_info", ach.toByteArray());
                        } catch (Exception e2) {
                            Log.printErrStackTrace("MicroMsg.WebMultiTaskHelper", e2, "onTaskBarItemClicked", new Object[0]);
                        }
                        if (bbL.type == 9) {
                            g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(bbL.field_localId);
                            p.g(DY, "MMKernel.plugin(IPluginF…calId(data.field_localId)");
                            if (DY != null) {
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
                        }
                        oc ocVar = new oc();
                        ocVar.dUe = bbL;
                        EventCenter.instance.publish(ocVar);
                        AppMethodBeat.o(230910);
                        return;
                    case 2:
                        C2007a aVar2 = a.JJo;
                        pa.a bbK = C2007a.bbK(str);
                        if (bbK == null) {
                            Log.e("MicroMsg.NoteMultiTaskHelper", "OpenNoteFromSessionEvent data is null");
                            AppMethodBeat.o(230910);
                            return;
                        }
                        bbK.dUl = new Bundle();
                        bbK.dUl.putByteArray("key_multi_task_common_info", ach.toByteArray());
                        pa paVar = new pa();
                        paVar.dVb = bbK;
                        EventCenter.instance.publish(paVar);
                        AppMethodBeat.o(230910);
                        return;
                    case 3:
                        Log.i("MicroMsg.NoteMultiTaskHelper", "click WNNoteBanner");
                        C2007a aVar3 = a.JJo;
                        q bbN = C2007a.bbN(str);
                        if (bbN != null) {
                            Bundle bundle2 = new Bundle();
                            bundle2.putByteArray("key_multi_task_common_info", ach.toByteArray());
                            C2007a aVar4 = a.JJo;
                            if (!bbN.JHR) {
                                h.INSTANCE.a(14789, 1);
                                Log.i("MicroMsg.NoteMultiTaskHelper", "isOpenFromSession: false");
                                com.tencent.mm.plugin.wenote.model.g gVar = new com.tencent.mm.plugin.wenote.model.g();
                                gVar.JGY = com.tencent.mm.plugin.wenote.b.a.b(bbN);
                                gVar.JGZ = 3;
                                com.tencent.mm.plugin.wenote.model.c gjz = com.tencent.mm.plugin.wenote.model.c.gjz();
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
                                Log.i("MicroMsg.NoteMultiTaskHelper", "isOpenFromSession: true");
                                j jVar = new j();
                                jVar.JGY = com.tencent.mm.plugin.wenote.b.a.b(bbN);
                                jVar.JGZ = 3;
                                com.tencent.mm.plugin.wenote.model.c gjz2 = com.tencent.mm.plugin.wenote.model.c.gjz();
                                p.g(gjz2, "SubCoreWNNoteMsg.getCore()");
                                gjz2.a(jVar);
                                and and2 = new and();
                                and2.scene = 8;
                                jVar.a(bbN.JHV, Long.valueOf(bbN.JHT), true, MMApplicationContext.getContext(), bbN.JHW, bbN.JHX, and2, bundle2);
                                AppMethodBeat.o(230910);
                                return;
                            }
                        } else {
                            Log.e("MicroMsg.NoteMultiTaskHelper", "WNNoteKeepTopItem data is null");
                            AppMethodBeat.o(230910);
                            return;
                        }
                }
                AppMethodBeat.o(230910);
            } catch (Exception e3) {
                Log.e("MicroMsg.NoteMultiTaskHelper", e3.getMessage());
                AppMethodBeat.o(230910);
            }
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void c(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(230911);
            p.h(multiTaskInfo, "multiTaskInfo");
            AppMethodBeat.o(230911);
        }
    }

    static {
        AppMethodBeat.i(230922);
        AppMethodBeat.o(230922);
    }

    public final void bbW(String str) {
        AppMethodBeat.i(230916);
        p.h(str, "title");
        this.title = str;
        bPu();
        super.ic(true);
        AppMethodBeat.o(230916);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.c
    public final void G(int i2, String str) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        Window window;
        View decorView;
        AppMethodBeat.i(230917);
        super.G(i2, str);
        if (eqZ()) {
            com.tencent.mm.plugin.multitask.a.a aVar = this.Aak;
            if (!(aVar == null || (activity3 = aVar.getActivity()) == null || (window = activity3.getWindow()) == null || (decorView = window.getDecorView()) == null)) {
                decorView.setBackgroundColor(0);
            }
            com.tencent.mm.plugin.multitask.a.a aVar2 = this.Aak;
            if (!(aVar2 == null || (activity2 = aVar2.getActivity()) == null)) {
                activity2.overridePendingTransition(R.anim.br, 0);
            }
            com.tencent.mm.plugin.multitask.a.a aVar3 = this.Aak;
            if (aVar3 != null) {
                activity = aVar3.getActivity();
            } else {
                activity = null;
            }
            com.tencent.mm.ui.base.b.a(activity, null);
        }
        AppMethodBeat.o(230917);
    }

    public final boolean l(int i2, String str, boolean z) {
        AppMethodBeat.i(230918);
        p.h(str, "title");
        NoteEditorUI noteEditorUI = this.JJm;
        if (noteEditorUI != null) {
            noteEditorUI.hideVKB();
        }
        this.title = str;
        bPu();
        boolean O = super.O(i2, z);
        AppMethodBeat.o(230918);
        return O;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final void d(Bitmap bitmap, boolean z) {
        AppMethodBeat.i(259060);
        if (z) {
            Log.i("MicroMsg.NoteMultiTaskHelper", "ended, remove historyTaskInfo");
            erc();
            AppMethodBeat.o(259060);
            return;
        }
        Log.i("MicroMsg.NoteMultiTaskHelper", "not ended update historyTaskInfo");
        ai(bitmap);
        AppMethodBeat.o(259060);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPp() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final boolean bPq() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final void bPu() {
        cru erh;
        AppMethodBeat.i(230919);
        if (this.type == 0) {
            AppMethodBeat.o(230919);
            return;
        }
        try {
            ctx ctx = new ctx();
            ctx.dRq = this.type;
            ctx.Mzh = this.data;
            MultiTaskInfo multiTaskInfo = this.Abp;
            if (!(multiTaskInfo == null || (erh = multiTaskInfo.erh()) == null)) {
                erh.title = this.title;
            }
            MultiTaskInfo multiTaskInfo2 = this.Abp;
            if (multiTaskInfo2 != null) {
                multiTaskInfo2.field_data = ctx.toByteArray();
                AppMethodBeat.o(230919);
                return;
            }
            AppMethodBeat.o(230919);
        } catch (Exception e2) {
            Log.e("MicroMsg.NoteMultiTaskHelper", "onMenuMultiTaskSelected error, ex = " + e2.getMessage());
            AppMethodBeat.o(230919);
        }
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean dki() {
        return true;
    }

    @Override // com.tencent.mm.plugin.multitask.b.c
    public final void a(c.b bVar) {
        NoteEditorUI noteEditorUI;
        AppMethodBeat.i(230920);
        if (eqZ() && (noteEditorUI = this.JJm) != null) {
            noteEditorUI.hideVKB();
        }
        super.a(bVar);
        AppMethodBeat.o(230920);
    }
}
