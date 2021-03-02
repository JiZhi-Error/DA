package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.co;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.ball.c.e;
import com.tencent.mm.plugin.ball.f.b;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.f;
import com.tencent.mm.plugin.handoff.model.HandOffFile;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.HashSet;
import java.util.Set;

public final class a extends f {
    private static final Set<String> Pwp;
    private static boolean Pwq = false;
    private static long Pwr = 0;
    private static e lqt = new com.tencent.mm.plugin.ball.c.f() {
        /* class com.tencent.mm.ui.chatting.g.a.AnonymousClass1 */

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void b(BallInfo ballInfo) {
            AppMethodBeat.i(35856);
            a.a(ballInfo);
            AppMethodBeat.o(35856);
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void c(BallInfo ballInfo) {
        }

        @Override // com.tencent.mm.plugin.ball.c.f, com.tencent.mm.plugin.ball.c.e
        public final void d(BallInfo ballInfo) {
        }
    };
    private String mFilePath = "";
    private String nhr = "";
    private int qpr = 0;

    static {
        AppMethodBeat.i(35866);
        HashSet hashSet = new HashSet();
        Pwp = hashSet;
        hashSet.add("app_type");
        Pwp.add("app_media_id");
        Pwp.add("app_msg_id");
        Pwp.add("app_show_share");
        Pwp.add("scene");
        AppMethodBeat.o(35866);
    }

    public a(com.tencent.mm.plugin.ball.a.f fVar) {
        super(fVar);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGg() {
        AppMethodBeat.i(35858);
        if (Util.isNullOrNil(this.mFilePath) || s.YS(this.mFilePath)) {
            AppMethodBeat.o(35858);
            return true;
        }
        AppMethodBeat.o(35858);
        return false;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean aGh() {
        return true;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void aGi() {
        AppMethodBeat.i(35859);
        Log.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedFinishWhenSwitchBallEvent, filePath:%s", this.mFilePath);
        super.aGi();
        if (!(this.oXA == null || this.oXA.getActivity() == null)) {
            this.oXA.getActivity().finish();
        }
        AppMethodBeat.o(35859);
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper, com.tencent.mm.plugin.ball.service.f
    public final void bCB() {
        AppMethodBeat.i(35860);
        Log.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onReceivedBallInfoRemovedEvent, filePath:%s", this.mFilePath);
        super.bCB();
        AppMethodBeat.o(35860);
    }

    public final void aC(String str, String str2, int i2) {
        AppMethodBeat.i(258940);
        Log.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "onCreate, filePath:%s fileExt:%s sence:%s", str, str2, Integer.valueOf(i2));
        this.mFilePath = str;
        this.nhr = str2;
        this.qpr = i2;
        super.G(4, b.agW(str));
        ciw().hDa = 4;
        ciw().oWx = this.qpr;
        cit();
        if (this.oWE.jkf != null) {
            this.oWE.jkf.putString("filePath", str);
            this.oWE.jkf.putBoolean("ifAppAttachDownloadUI", false);
            this.oWE.jkf.putString("fileExt", str2);
            this.oWE.jkf.putInt("sence", i2);
            cit();
        }
        AppMethodBeat.o(258940);
    }

    public static void ebz() {
        AppMethodBeat.i(35863);
        EventCenter.instance.add(new IListener<co>() {
            /* class com.tencent.mm.ui.chatting.g.a.AnonymousClass2 */

            {
                AppMethodBeat.i(161538);
                this.__eventId = co.class.getName().hashCode();
                AppMethodBeat.o(161538);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(co coVar) {
                AppMethodBeat.i(35857);
                Log.d("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "startListeningFloatBallInfoEvent()");
                if (g.af(com.tencent.mm.plugin.ball.c.b.class) != null) {
                    ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).a(4, a.lqt);
                }
                AppMethodBeat.o(35857);
                return false;
            }
        });
        AppMethodBeat.o(35863);
    }

    public static boolean isFileExist(String str) {
        AppMethodBeat.i(35864);
        boolean exists = new o(str).exists();
        AppMethodBeat.o(35864);
        return exists;
    }

    @Override // com.tencent.mm.plugin.ball.service.FloatBallHelper
    public final boolean bCG() {
        return true;
    }

    static /* synthetic */ void a(BallInfo ballInfo) {
        AppMethodBeat.i(35865);
        if (!(ballInfo == null || ballInfo.jkf == null)) {
            Log.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "handleBallInfoClicked, openFile ballInfo:%s", ballInfo);
            Context context = MMApplicationContext.getContext();
            long currentTimeMillis = System.currentTimeMillis();
            Pwr = currentTimeMillis;
            if (Pwr + 30000 < currentTimeMillis) {
                bg.aVF();
                Pwq = c.isSDCardAvailable();
            }
            if (!Pwq) {
                u.g(context, null);
                AppMethodBeat.o(35865);
                return;
            }
            boolean z = ballInfo.jkf.getBoolean("ifAppAttachDownloadUI");
            String string = ballInfo.jkf.getString("filePath");
            if (!s.YS(string)) {
                Log.i("MicroMsg.FilesFloatBall.FilesPageFloatBallHelper", "handleBallInfoClicked() %s not exist", string);
                f.a aVar = new f.a(context);
                aVar.aC("");
                f.a Dq = aVar.bow(context.getString(R.string.cej)).Dq(true);
                Dq.JnN = true;
                Dq.b((f.c) null).show();
                ((com.tencent.mm.plugin.ball.c.b) g.af(com.tencent.mm.plugin.ball.c.b.class)).l(new BallInfo(4, b.agW(string)));
                AppMethodBeat.o(35865);
                return;
            } else if (z) {
                Intent intent = new Intent();
                intent.setClassName(context, "com.tencent.mm.ui.chatting.AppAttachDownloadUI");
                com.tencent.mm.plugin.ball.f.a.a(intent, ballInfo.jkf, Pwp);
                intent.getExtras().putInt("scene", 9);
                intent.addFlags(268435456);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/chatting/floatball/FilesPageFloatBallHelper", "handleBallInfoClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/chatting/floatball/FilesPageFloatBallHelper", "handleBallInfoClicked", "(Lcom/tencent/mm/plugin/ball/model/BallInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(35865);
                return;
            } else {
                String string2 = ballInfo.jkf.getString("fileExt");
                String string3 = ballInfo.jkf.getString("appId");
                String string4 = ballInfo.jkf.getString("processName");
                boolean z2 = ballInfo.jkf.getBoolean("showMenu");
                ((com.tencent.mm.plugin.handoff.a.a) g.af(com.tencent.mm.plugin.handoff.a.a.class)).g(HandOffFile.fromBallInfo(ballInfo));
                if (Util.isNullOrNil(string4)) {
                    com.tencent.mm.pluginsdk.ui.tools.a.ao(string, string2, 9);
                    AppMethodBeat.o(35865);
                    return;
                }
                ((com.tencent.mm.plugin.appbrand.service.f) g.af(com.tencent.mm.plugin.appbrand.service.f.class)).a(context, string, string2, string3, z2, string4);
            }
        }
        AppMethodBeat.o(35865);
    }
}
