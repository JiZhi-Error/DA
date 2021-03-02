package com.tencent.mm.ui.chatting.multitask;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.co;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.multitask.b.c;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.plugin.taskbar.api.c;
import com.tencent.mm.plugin.taskbar.d;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public final class b extends c {
    private static c.a JwV = new c.a() {
        /* class com.tencent.mm.ui.chatting.multitask.b.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void a(MultiTaskInfo multiTaskInfo) {
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void b(MultiTaskInfo multiTaskInfo) {
            AppMethodBeat.i(233468);
            if (multiTaskInfo.field_data == null) {
                AppMethodBeat.o(233468);
                return;
            }
            Context context = MMApplicationContext.getContext();
            if (!b.gSk()) {
                u.g(context, null);
                AppMethodBeat.o(233468);
                return;
            }
            aoe aoe = new aoe();
            try {
                aoe.parseFrom(multiTaskInfo.field_data);
            } catch (Throwable th) {
                Log.e("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "FileMultiTaskData parse error");
            }
            String str = aoe.filePath;
            if (!s.YS(str)) {
                new f.a(context).aC("").bow(context.getString(R.string.cej)).Dq(true).b((f.c) null).show();
                ((d) g.ah(d.class)).removeTaskInfo(multiTaskInfo.field_id, true, 0);
                AppMethodBeat.o(233468);
                return;
            }
            ach ach = new ach();
            ach.LmR = true;
            if (aoe.LzL) {
                Intent intent = new Intent();
                intent.setClassName(context, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                com.tencent.mm.plugin.multitask.f.b.a(intent, aoe);
                try {
                    intent.putExtra("key_multi_task_common_info", ach.toByteArray());
                } catch (Exception e2) {
                    Log.printErrStackTrace("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", e2, "onTaskBarItemClicked", new Object[0]);
                }
                intent.getExtras().putInt("scene", 9);
                intent.addFlags(268435456);
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(233468);
                return;
            }
            String str2 = aoe.gCr;
            String str3 = aoe.appId;
            boolean z = aoe.lwF;
            String str4 = aoe.processName;
            if (!Util.isNullOrNil(str4)) {
                ((com.tencent.mm.plugin.appbrand.service.f) g.af(com.tencent.mm.plugin.appbrand.service.f.class)).a(context, str, str2, str3, z, str4);
            } else if (com.tencent.mm.pluginsdk.ui.tools.a.a(str, str2, "", 9, ach)) {
                Intent intent2 = new Intent();
                intent2.setClassName(context, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                com.tencent.mm.plugin.multitask.f.b.a(intent2, aoe);
                intent2.putExtra("scene", 9);
                intent2.addFlags(268435456);
                a bl2 = new a().bl(intent2);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/multitask/FilesPageMultiTaskHelper$2", "onTaskBarItemClicked", "(Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(233468);
                return;
            }
            AppMethodBeat.o(233468);
        }

        @Override // com.tencent.mm.plugin.taskbar.api.c.a
        public final void c(MultiTaskInfo multiTaskInfo) {
        }
    };
    public static final Set<String> PDZ;
    private static boolean Pwq = false;
    private static long Pwr = 0;
    private boolean JwT = false;
    public boolean PDX = false;
    public aoe nhp = new aoe();

    static {
        AppMethodBeat.i(233479);
        HashSet hashSet = new HashSet();
        PDZ = hashSet;
        hashSet.add("app_type");
        PDZ.add("app_media_id");
        PDZ.add("app_msg_id");
        PDZ.add("app_show_share");
        PDZ.add("scene");
        AppMethodBeat.o(233479);
    }

    public b(com.tencent.mm.plugin.multitask.a.a aVar) {
        super(aVar);
        AppMethodBeat.i(233469);
        AppMethodBeat.o(233469);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.b
    public final boolean bPq() {
        return true;
    }

    public final boolean wu(int i2) {
        AppMethodBeat.i(233470);
        boolean O = O(i2, this.JwT);
        AppMethodBeat.o(233470);
        return O;
    }

    @Override // com.tencent.mm.plugin.multitask.b.a, com.tencent.mm.plugin.multitask.b.c
    public final boolean O(int i2, boolean z) {
        AppMethodBeat.i(233471);
        boolean O = super.O(i2, this.JwT);
        AppMethodBeat.o(233471);
        return O;
    }

    public final void gTD() {
        AppMethodBeat.i(233472);
        this.JwT = true;
        Log.i("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "setEnded ended:%b", Boolean.TRUE);
        AppMethodBeat.o(233472);
    }

    public final void gTE() {
        AppMethodBeat.i(233473);
        dkj();
        Log.i("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "setStart");
        AppMethodBeat.o(233473);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean bPp() {
        AppMethodBeat.i(233474);
        if (!Util.isNullOrNil(this.nhp.filePath) && !s.YS(this.nhp.filePath)) {
            AppMethodBeat.o(233474);
            return false;
        } else if (this.PDX) {
            AppMethodBeat.o(233474);
            return false;
        } else {
            AppMethodBeat.o(233474);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final boolean eqO() {
        return !this.PDX;
    }

    public final void g(String str, String str2, int i2, boolean z) {
        AppMethodBeat.i(233475);
        Log.i("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "onCreate, filePath:%s fileExt:%s sence:%s", str, str2, Integer.valueOf(i2));
        super.G(4, com.tencent.mm.plugin.multitask.g.aGI(str));
        this.JwT = false;
        this.nhp.filePath = str;
        this.nhp.LzM = s.boW(str);
        if (!z) {
            this.nhp.gCr = str2;
            this.nhp.qoX = i2;
            this.nhp.LzL = false;
            try {
                this.Abp.field_data = this.nhp.toByteArray();
            } catch (IOException e2) {
                Log.e("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "handleMultiTaskInfoClicked", e2);
            }
            eqX();
        } else if (this.Aak.getIntent() != null) {
            Intent intent = this.Aak.getIntent();
            aoe aoe = this.nhp;
            if (aoe != null) {
                Bundle extras = intent.getExtras();
                if (!(aoe == null || extras == null)) {
                    aoe.LzN = extras.getString("app_type");
                    aoe.LzO = extras.getString("app_media_id");
                    aoe.LzP = extras.getLong("app_msg_id");
                    aoe.LzQ = extras.getBoolean("app_show_share");
                    aoe.scene = extras.getInt("scene");
                }
            }
            this.nhp.LzL = true;
            try {
                this.Abp.field_data = this.nhp.toByteArray();
            } catch (IOException e3) {
                Log.e("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "handleMultiTaskInfoClicked", e3);
            }
            eqX();
            AppMethodBeat.o(233475);
            return;
        }
        AppMethodBeat.o(233475);
    }

    public static boolean gSk() {
        AppMethodBeat.i(233477);
        long currentTimeMillis = System.currentTimeMillis();
        Pwr = currentTimeMillis;
        if (Pwr + 30000 < currentTimeMillis) {
            bg.aVF();
            Pwq = com.tencent.mm.model.c.isSDCardAvailable();
        }
        boolean z = Pwq;
        AppMethodBeat.o(233477);
        return z;
    }

    public static void ebz() {
        AppMethodBeat.i(233478);
        EventCenter.instance.add(new IListener<co>() {
            /* class com.tencent.mm.ui.chatting.multitask.b.AnonymousClass1 */

            {
                AppMethodBeat.i(233466);
                this.__eventId = co.class.getName().hashCode();
                AppMethodBeat.o(233466);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(co coVar) {
                AppMethodBeat.i(233467);
                Log.d("MicroMsg.FilesFloatBall.FilesPageMultiTaskHelper", "startListeningFloatBallInfoEvent()");
                if (g.af(com.tencent.mm.plugin.taskbar.api.c.class) != null) {
                    ((com.tencent.mm.plugin.taskbar.api.c) g.af(com.tencent.mm.plugin.taskbar.api.c.class)).a(4, b.JwV);
                }
                AppMethodBeat.o(233467);
                return false;
            }
        });
        AppMethodBeat.o(233478);
    }

    @Override // com.tencent.mm.plugin.multitask.b.a
    public final long eqU() {
        return 1000;
    }

    public final void ni(String str, String str2) {
        AppMethodBeat.i(233476);
        MultiTaskInfo multiTaskInfo = this.Abp;
        multiTaskInfo.erh().title = str2;
        multiTaskInfo.erh().gCr = str;
        eqX();
        AppMethodBeat.o(233476);
    }
}
