package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.emojicapture.api.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.loader.e;
import com.tencent.mm.sticker.loader.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.smtt.sdk.TbsListener;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u000b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eJ\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002R\u000e\u0010\t\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/CheckStickerDownload;", "", "context", "Landroid/content/Context;", "url", "", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;)V", "TAG", "callback", "com/tencent/mm/plugin/emojicapture/model/CheckStickerDownload$callback$1", "Lcom/tencent/mm/plugin/emojicapture/model/CheckStickerDownload$callback$1;", "canRetry", "", "canceled", "getContext", "()Landroid/content/Context;", "loadHint", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "kotlin.jvm.PlatformType", "getOnResult", "()Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "getUrl", "()Ljava/lang/String;", "destroy", "", "rescan", "download", "startPreview", "plugin-emojicapture_release"})
public final class b {
    final String TAG = "MicroMsg.CheckStickerDownload";
    final Context context;
    boolean jcC;
    final q qVq;
    private final String roh;
    final a.b roj;
    private boolean rop = true;
    final a roq;
    final String url;

    public b(Context context2, String str, a.b bVar) {
        p.h(context2, "context");
        p.h(str, "url");
        p.h(bVar, "onResult");
        AppMethodBeat.i(153);
        this.context = context2;
        this.url = str;
        this.roj = bVar;
        String string = this.context.getResources().getString(R.string.ts);
        p.g(string, "context.resources.getStr…R.string.app_downloading)");
        this.roh = string;
        this.qVq = q.a(this.context, this.roh, true, 0, new DialogInterface$OnCancelListenerC0978b(this));
        this.roq = new a(this);
        e eVar = e.NNN;
        e.a(this.roq);
        cID();
        AppMethodBeat.o(153);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.b$b  reason: collision with other inner class name */
    static final class DialogInterface$OnCancelListenerC0978b implements DialogInterface.OnCancelListener {
        final /* synthetic */ b ror;

        DialogInterface$OnCancelListenerC0978b(b bVar) {
            this.ror = bVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(150);
            Log.i(this.ror.TAG, "startStickerPreview: cancel loading");
            this.ror.jcC = true;
            this.ror.lG(false);
            AppMethodBeat.o(150);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/emojicapture/model/CheckStickerDownload$callback$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/sticker/loader/StickerTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-emojicapture_release"})
    public static final class a implements f<g> {
        final /* synthetic */ b ror;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(b bVar) {
            this.ror = bVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.loader.g.c, com.tencent.mm.loader.g.j] */
        @Override // com.tencent.mm.loader.g.f
        public final /* synthetic */ void a(g gVar, j jVar) {
            AppMethodBeat.i(149);
            g gVar2 = gVar;
            p.h(gVar2, "task");
            p.h(jVar, "status");
            if (p.j(gVar2.NNU.url, this.ror.url)) {
                Log.i(this.ror.TAG, "onLoaderFin: " + jVar + ' ' + this.ror.jcC);
                if (!this.ror.jcC) {
                    if (jVar == j.OK) {
                        b bVar = this.ror;
                        bVar.roj.dQ(false);
                        bVar.qVq.dismiss();
                        com.tencent.mm.plugin.emojicapture.api.b.fa(bVar.context);
                        e eVar = e.NNN;
                        e.b(bVar.roq);
                        AppMethodBeat.o(149);
                        return;
                    }
                    f.a aVar = new f.a(this.ror.context);
                    switch (gVar2.NNU.errType) {
                        case 1:
                        case 2:
                            aVar.bow(this.ror.context.getResources().getString(R.string.het)).apa(R.string.yi).boB(this.ror.context.getString(R.string.sz)).b(new C0976a(this)).a(new C0977b(this));
                            break;
                        case 4:
                            aVar.bow(this.ror.context.getResources().getString(R.string.hev)).apa(R.string.x_).b(new c(this));
                            break;
                        case 5:
                            aVar.bow(this.ror.context.getResources().getString(R.string.heu)).apa(R.string.x_).b(new d(this));
                            break;
                    }
                    aVar.show();
                }
            }
            AppMethodBeat.o(149);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.model.b$a$a  reason: collision with other inner class name */
        static final class C0976a implements f.c {
            final /* synthetic */ a ros;

            C0976a(a aVar) {
                this.ros = aVar;
            }

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(145);
                this.ros.ror.cID();
                AppMethodBeat.o(145);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
        /* renamed from: com.tencent.mm.plugin.emojicapture.model.b$a$b  reason: collision with other inner class name */
        static final class C0977b implements f.c {
            final /* synthetic */ a ros;

            C0977b(a aVar) {
                this.ros = aVar;
            }

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(146);
                this.ros.ror.lG(true);
                AppMethodBeat.o(146);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
        static final class c implements f.c {
            final /* synthetic */ a ros;

            c(a aVar) {
                this.ros = aVar;
            }

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(TbsListener.ErrorCode.NEEDDOWNLOAD_8);
                this.ros.ror.lG(false);
                AppMethodBeat.o(TbsListener.ErrorCode.NEEDDOWNLOAD_8);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
        static final class d implements f.c {
            final /* synthetic */ a ros;

            d(a aVar) {
                this.ros = aVar;
            }

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(148);
                this.ros.ror.lG(false);
                AppMethodBeat.o(148);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void cID() {
        AppMethodBeat.i(151);
        e eVar = e.NNN;
        e.biv(this.url);
        AppMethodBeat.o(151);
    }

    public final void lG(boolean z) {
        AppMethodBeat.i(152);
        this.qVq.dismiss();
        e eVar = e.NNN;
        e.b(this.roq);
        this.roj.dQ(z);
        AppMethodBeat.o(152);
    }
}
