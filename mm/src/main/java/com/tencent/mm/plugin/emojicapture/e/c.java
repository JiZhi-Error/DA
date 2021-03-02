package com.tencent.mm.plugin.emojicapture.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.r;
import com.tencent.mm.plugin.appbrand.jsapi.o.e;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.c.b;
import com.tencent.mm.plugin.emojicapture.model.d;
import com.tencent.mm.plugin.emojicapture.proxy.CgiEmojiTextSpamProxy;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI;
import com.tencent.mm.plugin.emojicapture.ui.EmojiVideoPlayTextureView;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorItemContainer;
import com.tencent.mm.plugin.emojicapture.ui.editor.EditorOutsideView;
import com.tencent.mm.plugin.emojicapture.ui.editor.EmojiEditorItemView;
import com.tencent.mm.plugin.emojicapture.ui.editor.TextEditorItemView;
import com.tencent.mm.plugin.sns.storage.ADXml;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.vfs.s;
import com.tencent.wxmm.v2helper;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015*\u0001\u0017\u0018\u0000 I2\u00020\u0001:\u0001IB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J7\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010\t2#\u0010+\u001a\u001f\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020$\u0018\u00010,H\u0002J2\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u001f2\u0016\u00103\u001a\u0012\u0012\u0004\u0012\u00020\t04j\b\u0012\u0004\u0012\u00020\t`5H\u0002J\b\u00106\u001a\u00020$H\u0016J\b\u00107\u001a\u00020$H\u0002J\b\u00108\u001a\u00020$H\u0016J\b\u00109\u001a\u00020$H\u0002J\b\u0010:\u001a\u00020\u0014H\u0016J\u0012\u0010;\u001a\u00020$2\b\u0010!\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010<\u001a\u00020$H\u0016J\b\u0010=\u001a\u00020$H\u0002J\b\u0010>\u001a\u00020\u0014H\u0016J\u0006\u0010?\u001a\u00020$J\b\u0010@\u001a\u00020$H\u0016J\u0010\u0010A\u001a\u00020$2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010B\u001a\u00020\u0014H\u0016J\u0010\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020\u0014H\u0002J\"\u0010E\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0014H\u0016J\"\u0010H\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010F\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u0014H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0004\n\u0002\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter;", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IPresenter;", "context", "Landroid/content/Context;", "view", "Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;", "uiNavigation", "Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;", "imitateMd5", "", "reporter", "Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/emojicapture/contract/EditorContract$IView;Lcom/tencent/mm/plugin/emojicapture/ui/EmojiCaptureUI$UINavigation;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/EmojiCaptureReporter;)V", "cgiEmojiTextSpamProxy", "Lcom/tencent/mm/plugin/emojicapture/proxy/CgiEmojiTextSpamProxy;", "emojiCaptureInfo", "Lcom/tencent/mm/plugin/emojicapture/model/capture/EmojiCaptureInfo;", "hideLoadingRunnable", "Ljava/lang/Runnable;", "isRemoveBg", "", "isSpeedup", "mixCallback", "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1;", "mixingInfo", "Lcom/tencent/mm/plugin/emojicapture/model/mix/EmojiMixInfo;", "originVideoPath", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "textColor", "", "viewPrepared", "voiceText", "voiceTextPrepared", "addEmoji", "", "emojiInfo", "Lcom/tencent/mm/api/IEmojiInfo;", "touchMatrix", "Landroid/graphics/Matrix;", "checkText", "text", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "shouldBlock", "createMixingEmojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "attachedText", "attachedEmojiMd5", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "destroy", "exportOriginVideo", "mix", "mixImpl", "onBack", "onVoiceTextFinished", "pause", "prepareCheck", "removeBg", "reset", "resume", "setup", "speedUp", "toggleTouch", "enable", "updateText", "color", "change", "updateTextWithoutCheck", "Companion", "plugin-emojicapture_release"})
public final class c implements b.a {
    public static final a rrq = new a((byte) 0);
    private Context context;
    private final com.tencent.mm.remoteservice.d gVN = new com.tencent.mm.remoteservice.d(this.context);
    private final String gXz;
    private boolean rpL;
    private String rqC;
    private com.tencent.mm.plugin.emojicapture.model.a.b rqD = new com.tencent.mm.plugin.emojicapture.model.a.b();
    private EmojiCaptureUI.b rqI;
    private final EmojiCaptureReporter rqJ;
    private String rrh;
    private boolean rri;
    private boolean rrj;
    private boolean rrk;
    private final CgiEmojiTextSpamProxy rrl = new CgiEmojiTextSpamProxy(this.gVN);
    private com.tencent.mm.plugin.emojicapture.model.b.d rrm;
    private final e rrn = new e(this);
    private final Runnable rro = new RunnableC0972c(this);
    private b.AbstractC0968b rrp;
    private int textColor;

    static {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.b.b.CTRL_INDEX);
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.b.b.CTRL_INDEX);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "shouldBlock", "", "invoke"})
    public static final class b extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ kotlin.g.a.b gWe;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(kotlin.g.a.b bVar) {
            super(1);
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(345);
            final boolean booleanValue = bool.booleanValue();
            MMHandlerThread.postToMainThread(new Runnable(this) {
                /* class com.tencent.mm.plugin.emojicapture.e.c.b.AnonymousClass1 */
                final /* synthetic */ b rrr;

                {
                    this.rrr = r1;
                }

                public final void run() {
                    AppMethodBeat.i(344);
                    kotlin.g.a.b bVar = this.rrr.gWe;
                    if (bVar != null) {
                        bVar.invoke(Boolean.valueOf(booleanValue));
                        AppMethodBeat.o(344);
                        return;
                    }
                    AppMethodBeat.o(344);
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(345);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "shouldBlock", "", "invoke"})
    static final class f extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ c rrt;
        final /* synthetic */ String rrv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(c cVar, String str) {
            super(1);
            this.rrt = cVar;
            this.rrv = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(350);
            boolean booleanValue = bool.booleanValue();
            Log.i("MicroMsg.EditorPresenter", "voice text block ".concat(String.valueOf(booleanValue)));
            this.rrt.rri = true;
            if (booleanValue) {
                u.makeText(this.rrt.context, (int) R.string.bwj, 0).show();
            } else {
                this.rrt.rqC = this.rrv;
            }
            c.b(this.rrt);
            x xVar = x.SXb;
            AppMethodBeat.o(350);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "shouldBlock", "", "invoke"})
    static final class j extends q implements kotlin.g.a.b<Boolean, x> {
        final /* synthetic */ boolean rrA;
        final /* synthetic */ c rrt;
        final /* synthetic */ com.tencent.mm.ui.base.q rrx;
        final /* synthetic */ String rry;
        final /* synthetic */ int rrz;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(c cVar, com.tencent.mm.ui.base.q qVar, String str, int i2, boolean z) {
            super(1);
            this.rrt = cVar;
            this.rrx = qVar;
            this.rry = str;
            this.rrz = i2;
            this.rrA = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Boolean bool) {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.nfc.f.CTRL_INDEX);
            boolean booleanValue = bool.booleanValue();
            this.rrx.dismiss();
            if (booleanValue) {
                u.makeText(this.rrt.context, (int) R.string.bwj, 0).show();
            } else {
                c.a(this.rrt, this.rry, this.rrz, this.rrA);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.nfc.f.CTRL_INDEX);
            return xVar;
        }
    }

    public c(Context context2, b.AbstractC0968b bVar, EmojiCaptureUI.b bVar2, String str, EmojiCaptureReporter emojiCaptureReporter) {
        p.h(context2, "context");
        p.h(bVar, "view");
        p.h(bVar2, "uiNavigation");
        p.h(emojiCaptureReporter, "reporter");
        AppMethodBeat.i(371);
        this.context = context2;
        this.rrp = bVar;
        this.rqI = bVar2;
        this.gXz = str;
        this.rqJ = emojiCaptureReporter;
        AppMethodBeat.o(371);
    }

    public static final /* synthetic */ void l(c cVar) {
        AppMethodBeat.i(375);
        cVar.cJz();
        AppMethodBeat.o(375);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$Companion;", "", "()V", "TAG", "", "plugin-emojicapture_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$mixCallback$1", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "onResult", "", "timeEnter", "", "success", "", "md5", "", "plugin-emojicapture_release"})
    public static final class e implements com.tencent.mm.emoji.d.a {
        final /* synthetic */ c rrt;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(c cVar) {
            this.rrt = cVar;
        }

        @Override // com.tencent.mm.emoji.d.a
        public final void a(long j2, boolean z, String str) {
            AppMethodBeat.i(349);
            com.tencent.mm.ac.d.h(new a(this, z, str));
            AppMethodBeat.o(349);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ boolean $success;
            final /* synthetic */ String hdx;
            final /* synthetic */ e rru;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(e eVar, boolean z, String str) {
                super(0);
                this.rru = eVar;
                this.$success = z;
                this.hdx = str;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(e.a.CTRL_INDEX);
                MMHandlerThread.removeRunnable(this.rru.rrt.rro);
                this.rru.rrt.rqI.cJE();
                if (this.$success) {
                    this.rru.rrt.rqI.s(true, this.hdx);
                } else {
                    u.makeText(this.rru.rrt.context, (int) R.string.bsd, 0).show();
                    this.rru.rrt.resume();
                }
                x xVar = x.SXb;
                AppMethodBeat.o(e.a.CTRL_INDEX);
                return xVar;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.e.c$c  reason: collision with other inner class name */
    static final class RunnableC0972c implements Runnable {
        final /* synthetic */ c rrt;

        RunnableC0972c(c cVar) {
            this.rrt = cVar;
        }

        public final void run() {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.o.e.CTRL_INDEX);
            this.rrt.rqI.cJE();
            u.makeText(this.rrt.context, (int) R.string.bsd, 0).show();
            this.rrt.resume();
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.o.e.CTRL_INDEX);
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.a
    public final void a(com.tencent.mm.plugin.emojicapture.model.a.b bVar) {
        AppMethodBeat.i(356);
        p.h(bVar, "emojiCaptureInfo");
        Log.i("MicroMsg.EditorPresenter", "setup");
        this.rqD = bVar;
        this.rrh = bVar.videoPath;
        this.rpL = bVar.rnN;
        this.textColor = bVar.roN;
        this.rrp.a(bVar, bVar.videoPath, bVar.roO, this.rpL, new h(this));
        com.tencent.mm.ac.d.b("EditorPresenter_setup", new i(bVar));
        AppMethodBeat.o(356);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.a
    public final void ank(String str) {
        AppMethodBeat.i(357);
        Log.i("MicroMsg.EditorPresenter", "voice text callback");
        g(str, new f(this, str));
        AppMethodBeat.o(357);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.a
    public final boolean cIx() {
        boolean z = true;
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.nfc.d.CTRL_INDEX);
        Log.i("MicroMsg.EditorPresenter", "removeBg " + this.rpL);
        if (!this.rqD.roO) {
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.nfc.d.CTRL_INDEX);
            return false;
        }
        EmojiVideoPlayTextureView videoPlayView = this.rrp.getVideoPlayView();
        if (videoPlayView == null || !videoPlayView.isPlaying()) {
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.nfc.d.CTRL_INDEX);
            return false;
        }
        if (this.rpL) {
            z = false;
        }
        this.rpL = z;
        EmojiVideoPlayTextureView videoPlayView2 = this.rrp.getVideoPlayView();
        if (videoPlayView2 != null) {
            videoPlayView2.setRemoveBackground(this.rpL);
        }
        boolean z2 = this.rpL;
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.nfc.d.CTRL_INDEX);
        return z2;
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.a
    public final boolean cIy() {
        AppMethodBeat.i(359);
        Log.i("MicroMsg.EditorPresenter", "speedUp " + this.rrk);
        EmojiVideoPlayTextureView videoPlayView = this.rrp.getVideoPlayView();
        if (videoPlayView == null || videoPlayView.getPlayRate() != 1.0f) {
            EmojiVideoPlayTextureView videoPlayView2 = this.rrp.getVideoPlayView();
            if (videoPlayView2 != null) {
                videoPlayView2.setPlayRate(1.0f);
            }
            this.rrk = false;
            AppMethodBeat.o(359);
            return false;
        }
        EmojiVideoPlayTextureView videoPlayView3 = this.rrp.getVideoPlayView();
        if (videoPlayView3 != null) {
            videoPlayView3.setPlayRate(2.0f);
        }
        this.rrk = true;
        AppMethodBeat.o(359);
        return true;
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.a
    public final void a(r rVar, Matrix matrix) {
        AppMethodBeat.i(v2helper.VOIP_ENC_HEIGHT_LV1);
        p.h(rVar, "emojiInfo");
        if (rVar instanceof EmojiInfo) {
            if (this.rrp.getItemContainer().getAllEmojiMd5().size() >= 8) {
                u.makeText(this.context, (int) R.string.br9, 0).show();
                AppMethodBeat.o(v2helper.VOIP_ENC_HEIGHT_LV1);
                return;
            }
            EmojiEditorItemView emojiEditorItemView = new EmojiEditorItemView(this.context);
            emojiEditorItemView.setEmojiInfo((EmojiInfo) rVar);
            emojiEditorItemView.resume();
            this.rrp.getItemContainer().a(emojiEditorItemView, matrix);
        }
        AppMethodBeat.o(v2helper.VOIP_ENC_HEIGHT_LV1);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.a
    public final void n(String str, int i2, boolean z) {
        AppMethodBeat.i(361);
        Log.i("MicroMsg.EditorPresenter", "updateText ".concat(String.valueOf(str)));
        g(str, new j(this, com.tencent.mm.ui.base.q.a(this.context, this.context.getString(R.string.ekc), true, 0, null), str, i2, z));
        AppMethodBeat.o(361);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class k implements View.OnClickListener {
        final /* synthetic */ z.f rrB;
        final /* synthetic */ c rrt;

        k(c cVar, z.f fVar) {
            this.rrt = cVar;
            this.rrB = fVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(355);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$updateTextWithoutCheck$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.rrt.rrp.a(true, this.rrB.SYG.getText(), this.rrB.SYG.getTextColor());
            EmojiCaptureReporter.a(13, this.rrt.rqJ.hdz, 0, 0, 0, 0, 0, 0, this.rrt.rqJ.scene);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/emojicapture/presenter/EditorPresenter$updateTextWithoutCheck$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(355);
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.a
    public final void cIz() {
        AppMethodBeat.i(362);
        if (!Util.isNullOrNil(this.gXz)) {
            com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
            p.g(ah, "MMKernel.plugin(IPluginEmoji::class.java)");
            if (!((Boolean) ((com.tencent.mm.plugin.emoji.b.d) ah).getProvider().c(ar.a.USERINFO_EMOJI_CAPTURE_IMITATE_SAVED_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                new d.a(this.context).aoS(R.string.bmn).aoV(R.string.bmm).a(new d(this)).show();
                com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.emoji.b.d.class);
                p.g(ah2, "MMKernel.plugin(IPluginEmoji::class.java)");
                ((com.tencent.mm.plugin.emoji.b.d) ah2).getProvider().d(ar.a.USERINFO_EMOJI_CAPTURE_IMITATE_SAVED_BOOLEAN, Boolean.TRUE);
                AppMethodBeat.o(362);
                return;
            }
        }
        cJz();
        AppMethodBeat.o(362);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onDismiss"})
    static final class d implements DialogInterface.OnDismissListener {
        final /* synthetic */ c rrt;

        d(c cVar) {
            this.rrt = cVar;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.o.g.CTRL_INDEX);
            c.l(this.rrt);
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.o.g.CTRL_INDEX);
        }
    }

    private final void cJz() {
        String str = null;
        AppMethodBeat.i(363);
        StringBuilder sb = new StringBuilder("start mix ");
        EmojiVideoPlayTextureView videoPlayView = this.rrp.getVideoPlayView();
        Log.i("MicroMsg.EditorPresenter", sb.append(videoPlayView != null ? videoPlayView.getVideoPath() : null).toString());
        com.tencent.mm.plugin.emojicapture.model.b.a aVar = new com.tencent.mm.plugin.emojicapture.model.b.a(this.rrp.getItemContainer().getValidRect());
        List<com.tencent.mm.plugin.emojicapture.ui.editor.a> allItemViews = this.rrp.getItemContainer().getAllItemViews();
        ArrayList<String> allEmojiMd5 = this.rrp.getItemContainer().getAllEmojiMd5();
        TextEditorItemView textItem = this.rrp.getItemContainer().getTextItem();
        int textColor2 = textItem != null ? textItem.getTextColor() : 0;
        String attachedText = this.rrp.getItemContainer().getAttachedText();
        for (com.tencent.mm.plugin.emojicapture.ui.editor.a aVar2 : allItemViews) {
            aVar.a(aVar2.c(null));
        }
        if (this.rrm == null) {
            this.rqJ.gXx = this.rrp.getItemContainer().getAttachedText();
            this.rqJ.textColor = textColor2;
            this.rqJ.rnN = this.rpL;
            this.rqJ.rnO = this.rrk;
            this.rqJ.rnP = allEmojiMd5.size();
            this.rqJ.dtZ = System.currentTimeMillis() - this.rqJ.hdz;
            EmojiCaptureReporter emojiCaptureReporter = this.rqJ;
            com.tencent.mm.sticker.f fVar = this.rqD.roL;
            if (fVar != null) {
                str = fVar.rnS;
            }
            emojiCaptureReporter.rnS = str;
            this.rqJ.cIu();
            EmojiInfo a2 = a(attachedText, textColor2, allEmojiMd5);
            com.tencent.mm.plugin.emojicapture.model.b.e eVar = com.tencent.mm.plugin.emojicapture.model.b.e.rpT;
            int i2 = this.rqD.scene;
            long j2 = a2.field_captureEnterTime;
            String str2 = this.rqD.videoPath;
            EmojiVideoPlayTextureView videoPlayView2 = this.rrp.getVideoPlayView();
            this.rrm = com.tencent.mm.plugin.emojicapture.model.b.e.a(i2, j2, str2, aVar, videoPlayView2 != null ? (int) videoPlayView2.getPlayRate() : 1, this.rpL, this.rqD.roL, a2);
        } else {
            EmojiCaptureProxy.a aVar3 = EmojiCaptureProxy.rrF;
            EmojiCaptureProxy.rrE.deleteEmojiInfoByEnterTime(this.rqJ.hdz);
            EmojiInfo a3 = a(attachedText, textColor2, allEmojiMd5);
            com.tencent.mm.plugin.emojicapture.model.b.e eVar2 = com.tencent.mm.plugin.emojicapture.model.b.e.rpT;
            int i3 = this.rqD.scene;
            long j3 = a3.field_captureEnterTime;
            String str3 = this.rqD.videoPath;
            EmojiVideoPlayTextureView videoPlayView3 = this.rrp.getVideoPlayView();
            this.rrm = com.tencent.mm.plugin.emojicapture.model.b.e.a(i3, j3, str3, aVar, videoPlayView3 != null ? (int) videoPlayView3.getPlayRate() : 1, this.rpL, this.rqD.roL, a3);
        }
        pause();
        if (com.tencent.mm.plugin.emojicapture.ui.c.Gq(this.rqD.scene)) {
            MMHandlerThread.removeRunnable(this.rro);
            MMHandlerThread.postToMainThreadDelayed(this.rro, Util.MILLSECONDS_OF_MINUTE);
            EmojiCaptureUI.b bVar = this.rqI;
            Context context2 = this.context;
            String string = this.context.getString(R.string.bse);
            p.g(string, "context.getString(R.string.emoji_generating)");
            EmojiCaptureUI.b.a.a(bVar, context2, string);
            com.tencent.mm.emoji.d.b bVar2 = com.tencent.mm.emoji.d.b.hdv;
            com.tencent.mm.emoji.d.b.a(this.rqD.hdz, this.rrn);
            AppMethodBeat.o(363);
            return;
        }
        EmojiCaptureUI.b.a.a(this.rqI, true);
        AppMethodBeat.o(363);
    }

    private final EmojiInfo a(String str, int i2, ArrayList<String> arrayList) {
        String str2;
        AppMethodBeat.i(364);
        String str3 = this.rqD.thumbPath;
        String bhK = s.bhK(str3);
        EmojiInfo emojiInfo = new EmojiInfo();
        String str4 = EmojiInfo.hYz() + bhK;
        if (!s.YS(str4)) {
            s.nw(str3, str4);
        }
        Log.i("MicroMsg.EditorPresenter", "create loading EmojiInfo. md5: " + bhK + " outputPath: " + str4);
        emojiInfo.setMd5(bhK);
        emojiInfo.byG("capture");
        emojiInfo.axt(EmojiInfo.VkQ);
        emojiInfo.field_attachedText = str;
        d.a aVar = com.tencent.mm.plugin.emojicapture.model.d.roA;
        emojiInfo.field_width = com.tencent.mm.plugin.emojicapture.model.d.roz;
        d.a aVar2 = com.tencent.mm.plugin.emojicapture.model.d.roA;
        emojiInfo.field_height = com.tencent.mm.plugin.emojicapture.model.d.roz;
        emojiInfo.a(EmojiInfo.a.STATUS_MIXING);
        emojiInfo.bH(arrayList);
        emojiInfo.field_imitateMd5 = this.gXz;
        emojiInfo.field_captureEnterTime = this.rqJ.hdz;
        com.tencent.mm.sticker.f fVar = this.rqD.roL;
        if (fVar != null) {
            str2 = fVar.rnS;
        } else {
            str2 = null;
        }
        emojiInfo.field_lensId = str2;
        d.a aVar3 = com.tencent.mm.plugin.emojicapture.model.d.roA;
        emojiInfo.field_attachTextColor = d.a.Gm(i2);
        emojiInfo.field_captureScene = this.rqJ.scene;
        EmojiCaptureProxy.a aVar4 = EmojiCaptureProxy.rrF;
        EmojiCaptureProxy.rrE.createEmojiInfo(emojiInfo);
        AppMethodBeat.o(364);
        return emojiInfo;
    }

    private final void g(String str, kotlin.g.a.b<? super Boolean, x> bVar) {
        AppMethodBeat.i(365);
        if (Util.isNullOrNil(str)) {
            bVar.invoke(Boolean.FALSE);
            AppMethodBeat.o(365);
            return;
        }
        this.rrl.cgiEmojiTextSpam(str, new b(bVar));
        AppMethodBeat.o(365);
    }

    private final void lI(boolean z) {
        AppMethodBeat.i(366);
        Log.i("MicroMsg.EditorPresenter", "toggleTouch: ".concat(String.valueOf(z)));
        if (this.context instanceof Activity) {
            Context context2 = this.context;
            if (context2 == null) {
                t tVar = new t("null cannot be cast to non-null type android.app.Activity");
                AppMethodBeat.o(366);
                throw tVar;
            }
            Activity activity = (Activity) context2;
            if (z) {
                activity.getWindow().clearFlags(16);
                AppMethodBeat.o(366);
                return;
            }
            activity.getWindow().addFlags(16);
        }
        AppMethodBeat.o(366);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.a
    public final boolean Ul() {
        AppMethodBeat.i(367);
        Log.i("MicroMsg.EditorPresenter", "onBack: " + this.rrp.bJw() + ' ' + this.rrp.cIB() + ' ' + this.rrp.cIC());
        if (!this.rrp.bJw()) {
            AppMethodBeat.o(367);
            return false;
        } else if (this.rrp.cIB()) {
            this.rrp.a(false, null, 0);
            AppMethodBeat.o(367);
            return true;
        } else if (this.rrp.cIC()) {
            this.rrp.lE(false);
            AppMethodBeat.o(367);
            return true;
        } else {
            this.rpL = false;
            this.rrk = false;
            this.rqC = null;
            this.rri = false;
            this.rrj = false;
            EmojiVideoPlayTextureView videoPlayView = this.rrp.getVideoPlayView();
            s.deleteFile(videoPlayView != null ? videoPlayView.getVideoPath() : null);
            this.rrp.reset();
            EditorItemContainer itemContainer = this.rrp.getItemContainer();
            itemContainer.pause();
            itemContainer.ruN.removeAllViews();
            this.rrm = null;
            lI(true);
            this.rqI.cJC();
            EmojiCaptureReporter.a(9, this.rqJ.hdz, 0, 0, 0, 0, 0, 0, this.rqJ.scene);
            AppMethodBeat.o(367);
            return true;
        }
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.a
    public final void pause() {
        EmojiVideoPlayTextureView videoPlayView;
        AppMethodBeat.i(368);
        Log.i("MicroMsg.EditorPresenter", "pause");
        EmojiVideoPlayTextureView videoPlayView2 = this.rrp.getVideoPlayView();
        if (!(videoPlayView2 == null || !videoPlayView2.isPlaying() || (videoPlayView = this.rrp.getVideoPlayView()) == null)) {
            videoPlayView.pause();
        }
        this.rrp.getItemContainer().pause();
        lI(false);
        AppMethodBeat.o(368);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.a
    public final void resume() {
        AppMethodBeat.i(369);
        Log.i("MicroMsg.EditorPresenter", "resume");
        EmojiVideoPlayTextureView videoPlayView = this.rrp.getVideoPlayView();
        if (videoPlayView != null) {
            videoPlayView.start();
        }
        this.rrp.getItemContainer().resume();
        lI(true);
        AppMethodBeat.o(369);
    }

    @Override // com.tencent.mm.plugin.emojicapture.c.b.a
    public final void destroy() {
        AppMethodBeat.i(370);
        Log.i("MicroMsg.EditorPresenter", "destroy");
        EmojiVideoPlayTextureView videoPlayView = this.rrp.getVideoPlayView();
        if (videoPlayView != null) {
            videoPlayView.stop();
        }
        this.rrp.getItemContainer().pause();
        this.rrp.destroy();
        this.gVN.release();
        this.rrl.setCallback(null);
        com.tencent.mm.emoji.d.b bVar = com.tencent.mm.emoji.d.b.hdv;
        com.tencent.mm.emoji.d.b.b(this.rqD.hdz, this.rrn);
        AppMethodBeat.o(370);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c rrt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(c cVar) {
            super(0);
            this.rrt = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.nfc.g.CTRL_INDEX);
            Log.i("MicroMsg.EditorPresenter", "video play callback");
            this.rrt.rrj = true;
            c.b(this.rrt);
            x xVar = x.SXb;
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.nfc.g.CTRL_INDEX);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ com.tencent.mm.plugin.emojicapture.model.a.b rrw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(com.tencent.mm.plugin.emojicapture.model.a.b bVar) {
            super(0);
            this.rrw = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.nfc.h.CTRL_INDEX);
            com.tencent.mm.plugin.sight.base.a aNx = com.tencent.mm.plugin.sight.base.e.aNx(this.rrw.videoPath);
            if (aNx != null) {
                EmojiCaptureReporter.Gi(34);
                EmojiCaptureReporter.fE(35, aNx.videoDuration);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.nfc.h.CTRL_INDEX);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ c rrt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(c cVar) {
            super(0);
            this.rrt = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(351);
            if (this.rrt.rri && this.rrt.rrj) {
                EmojiVideoPlayTextureView videoPlayView = this.rrt.rrp.getVideoPlayView();
                if (videoPlayView != null) {
                    videoPlayView.setRemoveBackground(this.rrt.rpL);
                }
                EmojiVideoPlayTextureView videoPlayView2 = this.rrt.rrp.getVideoPlayView();
                if (videoPlayView2 != null) {
                    videoPlayView2.setSticker(this.rrt.rqD.roL);
                }
                this.rrt.rrp.cIA();
                this.rrt.rqI.cJD();
                c.a(this.rrt, this.rrt.rqC, this.rrt.textColor, true);
                EmojiInfo emojiInfo = this.rrt.rqD.roP;
                if (emojiInfo != null) {
                    this.rrt.a(emojiInfo, this.rrt.rqD.roQ);
                }
                this.rrt.rrj = false;
                this.rrt.rri = false;
            }
            x xVar = x.SXb;
            AppMethodBeat.o(351);
            return xVar;
        }
    }

    public static final /* synthetic */ void b(c cVar) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.b.c.CTRL_INDEX);
        com.tencent.mm.ac.d.h(new g(cVar));
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.b.c.CTRL_INDEX);
    }

    public static final /* synthetic */ void a(c cVar, String str, int i2, boolean z) {
        AppMethodBeat.i(ADXml.AD_TURN_CARD_ANIMATION_TIME);
        z.f fVar = new z.f();
        fVar.SYG = (T) cVar.rrp.getItemContainer().getTextItem();
        if (fVar.SYG == null) {
            EditorItemContainer itemContainer = cVar.rrp.getItemContainer();
            T t = (T) new TextEditorItemView(itemContainer.getContext());
            itemContainer.ruN.addView(t, new RelativeLayout.LayoutParams(-1, -1));
            RectF validRect = itemContainer.getValidRect();
            Context context2 = itemContainer.getContext();
            p.g(context2, "context");
            t.a(validRect, context2.getResources().getDimension(R.dimen.a1w));
            EditorOutsideView editorOutsideView = itemContainer.ruO;
            RectF validRect2 = itemContainer.getValidRect();
            Context context3 = itemContainer.getContext();
            p.g(context3, "context");
            editorOutsideView.a(validRect2, context3.getResources().getDimension(R.dimen.a1w));
            fVar.SYG = t;
            fVar.SYG.setOnClickListener(new k(cVar, fVar));
        }
        fVar.SYG.a(str, i2, z);
        cVar.rrp.getItemContainer().setEditing(fVar.SYG);
        AppMethodBeat.o(ADXml.AD_TURN_CARD_ANIMATION_TIME);
    }
}
