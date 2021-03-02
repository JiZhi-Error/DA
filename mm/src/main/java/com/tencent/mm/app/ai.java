package com.tencent.mm.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.cc.e;
import com.tencent.mm.model.cr;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.e.a;
import com.tencent.mm.ui.widget.a.d;

public final class ai {
    static volatile boolean dmI;

    static /* synthetic */ void bQ(Context context) {
        AppMethodBeat.i(231410);
        bP(context);
        AppMethodBeat.o(231410);
    }

    public static void init(final Context context) {
        AppMethodBeat.i(231408);
        if (!dmI) {
            synchronized (ai.class) {
                try {
                    if (!dmI) {
                        cr.aWI();
                        a.b(new android.arch.a.c.a<Context, Resources>() {
                            /* class com.tencent.mm.app.ai.AnonymousClass1 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // android.arch.a.c.a
                            public final /* synthetic */ Resources apply(Context context) {
                                AppMethodBeat.i(231399);
                                Resources jp = e.jp(context);
                                AppMethodBeat.o(231399);
                                return jp;
                            }
                        });
                        a.c(new android.arch.a.c.a<String, String>() {
                            /* class com.tencent.mm.app.ai.AnonymousClass2 */

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                            @Override // android.arch.a.c.a
                            public final /* synthetic */ String apply(String str) {
                                AppMethodBeat.i(231400);
                                String str2 = str;
                                if (TextUtils.isEmpty(str2)) {
                                    AppMethodBeat.o(231400);
                                    return str2;
                                }
                                String translate = WeChatBrands.Wordings.translate(str2);
                                AppMethodBeat.o(231400);
                                return translate;
                            }
                        });
                        bP(context);
                        cr.F(new Runnable() {
                            /* class com.tencent.mm.app.ai.AnonymousClass3 */

                            public final void run() {
                                AppMethodBeat.i(231401);
                                ai.bQ(context);
                                AppMethodBeat.o(231401);
                            }
                        });
                        dmI = true;
                    }
                } finally {
                    AppMethodBeat.o(231408);
                }
            }
            return;
        }
        AppMethodBeat.o(231408);
    }

    private static void bP(final Context context) {
        AppMethodBeat.i(231409);
        final AnonymousClass4 r2 = new WeChatBrands.Business.AvailabilityAlertSupplier() {
            /* class com.tencent.mm.app.ai.AnonymousClass4 */
            d dmJ;

            @Override // com.tencent.mm.sdk.platformtools.WeChatBrands.Business.AvailabilityAlertSupplier
            public final void showDialog(Context context) {
                Context context2;
                AppMethodBeat.i(231404);
                if (this.dmJ == null || !this.dmJ.isShowing() || (context2 = this.dmJ.getContext()) == null || (context2 != context && (!(context2 instanceof ContextWrapper) || ((ContextWrapper) context2).getBaseContext() != context))) {
                    this.dmJ = new d.a(context).bon(getTilte()).boo(getBody()).bou(getPositiveBtnText()).c(getOnPositiveClickListener()).bov(getNegativeBtnText()).Dk(true).Dl(false).d(getOnNegativeClickListener()).f(new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.app.ai.AnonymousClass4.AnonymousClass2 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(231403);
                            AnonymousClass4.this.getOnDismissListener().onClick(dialogInterface, -2);
                            AnonymousClass4.this.dmJ = null;
                            AppMethodBeat.o(231403);
                        }
                    }).a(new DialogInterface.OnDismissListener() {
                        /* class com.tencent.mm.app.ai.AnonymousClass4.AnonymousClass1 */

                        public final void onDismiss(DialogInterface dialogInterface) {
                            AppMethodBeat.i(231402);
                            AnonymousClass4.this.getOnDismissListener().onClick(dialogInterface, -2);
                            AnonymousClass4.this.dmJ = null;
                            AppMethodBeat.o(231402);
                        }
                    }).hbn();
                    this.dmJ.show();
                    AppMethodBeat.o(231404);
                    return;
                }
                AppMethodBeat.o(231404);
            }
        };
        String aWF = cr.aWF();
        String aWG = cr.aWG();
        final String aWH = cr.aWH();
        if (aWF == null) {
            aWF = context.getString(R.string.als);
        }
        r2.setTilte(aWF).setBody(aWG == null ? context.getString(R.string.alp) : aWG).setPositiveBtnText(context.getString(R.string.alr)).setOnPositiveClickListener(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.app.ai.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(231406);
                if (r2.getCallback() != null) {
                    r2.getCallback().accept(1);
                }
                AppMethodBeat.o(231406);
            }
        }).setOnDismissListener(new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.app.ai.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(231405);
                if (r2.getCallback() != null) {
                    r2.getCallback().accept(-1);
                }
                AppMethodBeat.o(231405);
            }
        });
        if (!TextUtils.isEmpty(aWH)) {
            r2.setNegativeBtnText(context.getString(R.string.alq)).setOnNegativeClickListener(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.app.ai.AnonymousClass7 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(231407);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", aWH);
                    c.b(context, "webview", ".ui.tools.WebViewUI", intent);
                    if (r2.getCallback() != null) {
                        r2.getCallback().accept(0);
                    }
                    AppMethodBeat.o(231407);
                }
            });
        }
        WeChatBrands.updateBizRestrictAlertSupplier(r2);
        AppMethodBeat.o(231409);
    }
}
