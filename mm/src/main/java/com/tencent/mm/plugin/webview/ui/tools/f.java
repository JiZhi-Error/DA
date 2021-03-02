package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

public final class f {
    public static final a Jfx = new a((byte) 0);
    private static final String TAG = TAG;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        static final class b implements f.c {
            final /* synthetic */ Context $context;
            final /* synthetic */ Uri IMQ;

            b(Uri uri, Context context) {
                this.IMQ = uri;
                this.$context = context;
            }

            @Override // com.tencent.mm.ui.widget.a.f.c
            public final void e(boolean z, String str) {
                AppMethodBeat.i(210372);
                if (z) {
                    Intent intent = new Intent("android.intent.action.SENDTO", this.IMQ);
                    intent.addFlags(268435456);
                    try {
                        Context context = this.$context;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/webview/ui/tools/SMSQueryHelper$Companion$showDialog$build$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        context.startActivity((Intent) bl.pG(0));
                        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/ui/tools/SMSQueryHelper$Companion$showDialog$build$1", "onDialogClick", "(ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        AppMethodBeat.o(210372);
                        return;
                    } catch (Exception e2) {
                        Log.e(f.TAG, "start sms app failed:[%s]", e2.getMessage());
                    }
                }
                AppMethodBeat.o(210372);
            }
        }

        static final class c implements DialogInterface.OnDismissListener {
            public static final c Jfy = new c();

            static {
                AppMethodBeat.i(210374);
                AppMethodBeat.o(210374);
            }

            c() {
            }

            public final void onDismiss(DialogInterface dialogInterface) {
                AppMethodBeat.i(210373);
                Log.d(f.TAG, "OnDismissListener ");
                AppMethodBeat.o(210373);
            }
        }

        /* renamed from: com.tencent.mm.plugin.webview.ui.tools.f$a$a */
        public static final class C1985a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ Context $context;
            final /* synthetic */ String mkH;
            final /* synthetic */ String uhA;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C1985a(Context context, String str, String str2) {
                super(0);
                this.$context = context;
                this.uhA = str;
                this.mkH = str2;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(210371);
                a aVar = f.Jfx;
                Context context = this.$context;
                String str = this.uhA;
                if (str == null) {
                    p.hyc();
                }
                String str2 = this.mkH;
                p.h(context, "context");
                p.h(str, "msg");
                p.h(str2, "url");
                new f.a(context).bow(str).Dq(true).c(new b(Uri.parse(str2), context)).b(c.Jfy).show();
                x xVar = x.SXb;
                x xVar2 = x.SXb;
                AppMethodBeat.o(210371);
                return xVar2;
            }
        }
    }

    static {
        AppMethodBeat.i(210375);
        AppMethodBeat.o(210375);
    }
}
