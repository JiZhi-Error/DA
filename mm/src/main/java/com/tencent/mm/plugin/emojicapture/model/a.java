package com.tencent.mm.plugin.emojicapture.model;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emojicapture.api.a;
import com.tencent.mm.plugin.emojicapture.api.b;
import com.tencent.mm.protocal.protobuf.chz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.c.c;
import com.tencent.mm.sticker.c.d;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.smtt.sdk.TbsListener;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0005H\u0002R\u000e\u0010\t\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/CheckLensInfo;", "", "context", "Landroid/content/Context;", "lensIdWithUrl", "", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "(Landroid/content/Context;Ljava/lang/String;Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;)V", "TAG", "getContext", "()Landroid/content/Context;", "getLensIdWithUrl", "()Ljava/lang/String;", "loadHint", "loading", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "kotlin.jvm.PlatformType", "getOnResult", "()Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$PrepareStickerCallback;", "exit", "", "startEmojiCapture", "lensId", "plugin-emojicapture_release"})
public final class a {
    final String TAG = "MicroMsg.CheckLensInfo";
    final Context context;
    final q qVq;
    private final String roh;
    private final String roi;
    final a.b roj;

    public a(Context context2, String str, a.b bVar) {
        int i2;
        final String str2;
        boolean z;
        p.h(context2, "context");
        p.h(bVar, "onResult");
        AppMethodBeat.i(TbsListener.ErrorCode.NEEDDOWNLOAD_4);
        this.context = context2;
        this.roi = str;
        this.roj = bVar;
        String string = this.context.getResources().getString(R.string.ek_);
        p.g(string, "context.resources.getString(R.string.loading)");
        this.roh = string;
        this.qVq = q.a(this.context, this.roh, true, 0, new DialogInterface$OnCancelListenerC0974a(this));
        String str3 = this.roi;
        if (str3 != null) {
            i2 = n.a((CharSequence) str3, "lensid=", 0, false, 6);
        } else {
            i2 = 0;
        }
        String str4 = this.roi;
        if (str4 != null) {
            int i3 = i2 + 7;
            if (str4 == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(TbsListener.ErrorCode.NEEDDOWNLOAD_4);
                throw tVar;
            }
            str2 = str4.substring(i3);
            p.g(str2, "(this as java.lang.String).substring(startIndex)");
        } else {
            str2 = null;
        }
        String str5 = str2;
        if (str5 == null || str5.length() == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            this.roj.dQ(false);
            AppMethodBeat.o(TbsListener.ErrorCode.NEEDDOWNLOAD_4);
            return;
        }
        d.a aVar = d.NOm;
        Context context3 = this.context;
        d.a.a((MMActivity) (!(context3 instanceof MMActivity) ? null : context3), str2, new c(this) {
            /* class com.tencent.mm.plugin.emojicapture.model.a.AnonymousClass1 */
            final /* synthetic */ a rok;

            {
                this.rok = r1;
            }

            @Override // com.tencent.mm.sticker.c.c
            public final void a(int i2, chz chz) {
                AppMethodBeat.i(141);
                com.tencent.mm.ac.d.h(new C0973a(this, chz));
                AppMethodBeat.o(141);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.emojicapture.model.a$1$a  reason: collision with other inner class name */
            static final class C0973a extends kotlin.g.b.q implements kotlin.g.a.a<x> {
                final /* synthetic */ AnonymousClass1 rom;
                final /* synthetic */ chz ron;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0973a(AnonymousClass1 r2, chz chz) {
                    super(0);
                    this.rom = r2;
                    this.ron = chz;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(140);
                    if (this.ron != null) {
                        a aVar = this.rom.rok;
                        String str = str2;
                        aVar.qVq.dismiss();
                        b.ax(aVar.context, str);
                        aVar.roj.dQ(false);
                    } else {
                        f.a aVar2 = new f.a(this.rom.rok.context);
                        aVar2.bow(this.rom.rok.context.getResources().getString(R.string.heo)).boA(this.rom.rok.context.getResources().getString(R.string.x_)).b(new f.c(this) {
                            /* class com.tencent.mm.plugin.emojicapture.model.a.AnonymousClass1.C0973a.AnonymousClass1 */
                            final /* synthetic */ C0973a roo;

                            {
                                this.roo = r1;
                            }

                            @Override // com.tencent.mm.ui.widget.a.f.c
                            public final void e(boolean z, String str) {
                                AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX);
                                a.a(this.roo.rom.rok);
                                AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.p.b.CTRL_INDEX);
                            }
                        });
                        aVar2.show();
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(140);
                    return xVar;
                }
            }
        });
        AppMethodBeat.o(TbsListener.ErrorCode.NEEDDOWNLOAD_4);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    /* renamed from: com.tencent.mm.plugin.emojicapture.model.a$a  reason: collision with other inner class name */
    static final class DialogInterface$OnCancelListenerC0974a implements DialogInterface.OnCancelListener {
        final /* synthetic */ a rok;

        DialogInterface$OnCancelListenerC0974a(a aVar) {
            this.rok = aVar;
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.i(TbsListener.ErrorCode.NEEDDOWNLOAD_3);
            Log.i(this.rok.TAG, "CheckLensInfo: cancel loading");
            a.a(this.rok);
            AppMethodBeat.o(TbsListener.ErrorCode.NEEDDOWNLOAD_3);
        }
    }

    public static final /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(144);
        aVar.qVq.dismiss();
        aVar.roj.dQ(false);
        AppMethodBeat.o(144);
    }
}
