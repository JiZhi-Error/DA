package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.ui.widget.snackbar.a;

public final class u extends Toast {
    private View OTO;
    private final Context context;
    public long duration;
    private int level;
    private int qdp;
    public final MTimerHandler timer = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.ui.base.u.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(142230);
            if (u.this.duration == -1) {
                u.this.show();
                AppMethodBeat.o(142230);
                return true;
            }
            u.b(u.this);
            if (u.this.qdp >= 0) {
                u.this.show();
                AppMethodBeat.o(142230);
                return true;
            }
            u.this.cancel();
            AppMethodBeat.o(142230);
            return false;
        }
    }, true);
    private final TextView yva;

    public interface b {
        void dU(View view);
    }

    static /* synthetic */ int b(u uVar) {
        int i2 = uVar.qdp;
        uVar.qdp = i2 - 1;
        return i2;
    }

    public u(Context context2) {
        super(context2);
        AppMethodBeat.i(142239);
        this.context = context2;
        reset();
        this.OTO = View.inflate(context2, R.layout.c3j, null);
        setView(this.OTO);
        setGravity(55, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(context2, 40.0f));
        setDuration(0);
        this.yva = (TextView) this.OTO.findViewById(R.id.ire);
        switch (this.level) {
            case 1:
                this.yva.setTextColor(-1);
                AppMethodBeat.o(142239);
                return;
            case 2:
                this.yva.setTextColor(this.context.getResources().getColor(R.color.abu));
                break;
        }
        AppMethodBeat.o(142239);
    }

    @Override // android.widget.Toast
    public final void setText(CharSequence charSequence) {
        AppMethodBeat.i(142240);
        this.yva.setText(charSequence);
        AppMethodBeat.o(142240);
    }

    @Override // android.widget.Toast
    public final void setText(int i2) {
        AppMethodBeat.i(142241);
        this.yva.setText(com.tencent.mm.ui.e.a.kn(this.context).getString(i2));
        AppMethodBeat.o(142241);
    }

    public final void reset() {
        this.level = 1;
        this.duration = 2000;
        this.qdp = ((int) (this.duration / 70)) + 1;
    }

    public final void gLj() {
        AppMethodBeat.i(205245);
        cancel();
        this.timer.stopTimer();
        this.qdp = ((int) (this.duration / 70)) + 1;
        this.timer.startTimer(70);
        AppMethodBeat.o(205245);
    }

    public static p a(Activity activity, String str, long j2) {
        AppMethodBeat.i(142242);
        View inflate = View.inflate(activity, R.layout.c3j, null);
        ((TextView) inflate.findViewById(R.id.ire)).setText(str);
        final p pVar = new p(inflate);
        pVar.setWidth(-1);
        pVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        pVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, rect.top + eu(activity));
        new MMHandler() {
            /* class com.tencent.mm.ui.base.u.AnonymousClass8 */

            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(142233);
                pVar.dismiss();
                super.handleMessage(message);
                AppMethodBeat.o(142233);
            }
        }.sendEmptyMessageDelayed(0, j2);
        AppMethodBeat.o(142242);
        return pVar;
    }

    private static int eu(Context context2) {
        int dimensionPixelSize;
        AppMethodBeat.i(142243);
        if (!(context2 instanceof AppCompatActivity) || ((AppCompatActivity) context2).getSupportActionBar() == null) {
            DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.b8);
            } else {
                dimensionPixelSize = context2.getResources().getDimensionPixelSize(R.dimen.b9);
            }
        } else {
            dimensionPixelSize = ((AppCompatActivity) context2).getSupportActionBar().getHeight();
        }
        if (dimensionPixelSize == 0) {
            int dimensionPixelSize2 = context2.getResources().getDimensionPixelSize(R.dimen.b9);
            AppMethodBeat.o(142243);
            return dimensionPixelSize2;
        }
        AppMethodBeat.o(142243);
        return dimensionPixelSize;
    }

    public static void g(final Context context2, View view) {
        AppMethodBeat.i(164156);
        if (!(context2 instanceof Activity) || android.support.v4.content.b.checkSelfPermission((Activity) context2, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            kf(context2);
            AppMethodBeat.o(164156);
            return;
        }
        com.tencent.mm.ui.widget.snackbar.b.a(context2, view, context2.getString(R.string.flo), context2.getString(R.string.yv), new a.b() {
            /* class com.tencent.mm.ui.base.u.AnonymousClass4 */

            @Override // com.tencent.mm.ui.widget.snackbar.a.b
            public final void bDZ() {
                AppMethodBeat.i(164155);
                if (!android.support.v4.app.a.a((Activity) context2, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                    h.a(context2, context2.getString(R.string.fln), context2.getString(R.string.flp), context2.getString(R.string.e_k), context2.getString(R.string.sz), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.base.u.AnonymousClass4.AnonymousClass1 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(164153);
                            dialogInterface.dismiss();
                            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                            intent.setData(Uri.fromParts("package", context2.getPackageName(), null));
                            intent.addFlags(268435456);
                            Context context = context2;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/ui/base/MMToast$14$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/ui/base/MMToast$14$1", "onClick", "(Landroid/content/DialogInterface;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            e.INSTANCE.idkeyStat(462, 23, 1, true);
                            AppMethodBeat.o(164153);
                        }
                    }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.ui.base.u.AnonymousClass4.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(164154);
                            dialogInterface.dismiss();
                            AppMethodBeat.o(164154);
                        }
                    });
                    AppMethodBeat.o(164155);
                    return;
                }
                e.INSTANCE.idkeyStat(462, 22, 1, true);
                android.support.v4.app.a.a((Activity) context2, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 32767);
                AppMethodBeat.o(164155);
            }
        });
        AppMethodBeat.o(164156);
    }

    /* access modifiers changed from: package-private */
    public static class a {
        public static int lastType = 0;
        private static Toast xfv = null;

        public static void aP(Context context, int i2) {
            AppMethodBeat.i(142238);
            Context applicationContext = context.getApplicationContext();
            if (lastType != i2) {
                xfv = null;
                lastType = i2;
            }
            if (xfv == null) {
                xfv = Toast.makeText(applicationContext, "", 1);
            }
            View inflate = View.inflate(applicationContext, R.layout.bom, null);
            if (i2 == 1) {
                ((TextView) inflate.findViewById(R.id.hcz)).setText(R.string.ez7);
            } else if (i2 == 3) {
                ((TextView) inflate.findViewById(R.id.hcz)).setText(R.string.ez8);
            } else {
                ((TextView) inflate.findViewById(R.id.hcz)).setText(R.string.ez9);
            }
            xfv.setView(inflate);
            xfv.show();
            AppMethodBeat.o(142238);
        }
    }

    public static void cE(Context context2, String str) {
        AppMethodBeat.i(205247);
        Toast makeText = Toast.makeText(context2, "", 0);
        View inflate = View.inflate(context2, R.layout.c33, null);
        ((TextView) inflate.findViewById(R.id.ird)).setText(str);
        makeText.setGravity(17, 0, 0);
        makeText.setView(inflate);
        makeText.show();
        AppMethodBeat.o(205247);
    }

    public static void cF(Context context2, String str) {
        AppMethodBeat.i(205248);
        Toast makeText = Toast.makeText(context2, "", 1);
        View inflate = View.inflate(context2, R.layout.c33, null);
        ((TextView) inflate.findViewById(R.id.ird)).setText(str);
        makeText.setGravity(17, 0, 0);
        makeText.setView(inflate);
        makeText.show();
        AppMethodBeat.o(205248);
    }

    public static void cG(final Context context2, String str) {
        AppMethodBeat.i(142246);
        Toast makeText = Toast.makeText(context2, "", 0);
        View inflate = View.inflate(context2, R.layout.pd, null);
        final TextView textView = (TextView) inflate.findViewById(R.id.ird);
        textView.setText(str);
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.ui.base.u.AnonymousClass5 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(205242);
                if (textView.getLineCount() > 1) {
                    textView.setTextSize(0, (float) com.tencent.mm.cb.a.aG(context2, R.dimen.bd));
                }
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                AppMethodBeat.o(205242);
            }
        });
        makeText.setGravity(17, 0, 0);
        makeText.setView(inflate);
        makeText.show();
        AppMethodBeat.o(142246);
    }

    public static void u(final Context context2, String str, int i2) {
        AppMethodBeat.i(205249);
        Toast makeText = Toast.makeText(context2, "", 0);
        View inflate = View.inflate(context2, R.layout.pd, null);
        WeImageView weImageView = (WeImageView) inflate.findViewById(R.id.irc);
        if (i2 != 0) {
            weImageView.setImageResource(i2);
        } else {
            weImageView.setVisibility(8);
        }
        final TextView textView = (TextView) inflate.findViewById(R.id.ird);
        textView.setText(str);
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.ui.base.u.AnonymousClass6 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(205243);
                if (textView.getLineCount() > 1) {
                    textView.setTextSize(0, (float) com.tencent.mm.cb.a.aG(context2, R.dimen.bd));
                }
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                AppMethodBeat.o(205243);
            }
        });
        makeText.setGravity(17, 0, 0);
        makeText.setView(inflate);
        makeText.show();
        AppMethodBeat.o(205249);
    }

    public static void cH(final Context context2, String str) {
        AppMethodBeat.i(142247);
        Toast makeText = Toast.makeText(context2, "", 0);
        View inflate = View.inflate(context2, R.layout.pd, null);
        ((WeImageView) inflate.findViewById(R.id.irc)).setImageResource(R.raw.icons_filled_info);
        final TextView textView = (TextView) inflate.findViewById(R.id.ird);
        textView.setText(str);
        textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            /* class com.tencent.mm.ui.base.u.AnonymousClass7 */

            public final void onGlobalLayout() {
                AppMethodBeat.i(205244);
                if (textView.getLineCount() > 1) {
                    textView.setTextSize(0, (float) com.tencent.mm.cb.a.aG(context2, R.dimen.bd));
                }
                textView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                AppMethodBeat.o(205244);
            }
        });
        makeText.setGravity(17, 0, 0);
        makeText.setView(inflate);
        makeText.show();
        AppMethodBeat.o(142247);
    }

    public static void a(Context context2, String str, b bVar) {
        AppMethodBeat.i(205250);
        Toast makeText = Toast.makeText(context2, "", 0);
        View inflate = View.inflate(context2, R.layout.pd, null);
        ((WeImageView) inflate.findViewById(R.id.irc)).setImageResource(R.raw.icons_filled_error);
        ((TextView) inflate.findViewById(R.id.ird)).setText(str);
        bVar.dU(inflate);
        makeText.setGravity(17, 0, 0);
        makeText.setView(inflate);
        makeText.show();
        AppMethodBeat.o(205250);
    }

    public static void kf(Context context2) {
        AppMethodBeat.i(142248);
        if (g.getExternalStorageState().equals("mounted_ro")) {
            a.aP(context2, 3);
            AppMethodBeat.o(142248);
            return;
        }
        a.aP(context2, 1);
        AppMethodBeat.o(142248);
    }

    public static void kg(Context context2) {
        AppMethodBeat.i(142249);
        a.aP(context2, 2);
        AppMethodBeat.o(142249);
    }

    public static p q(final Activity activity, String str) {
        AppMethodBeat.i(205246);
        View inflate = View.inflate(activity, R.layout.azs, null);
        TextView textView = (TextView) inflate.findViewById(R.id.ed0);
        textView.setText(str);
        textView.setOnClickListener(null);
        ((ImageView) inflate.findViewById(R.id.ecz)).setVisibility(8);
        final p pVar = new p(inflate);
        pVar.setWidth(-1);
        pVar.setHeight(-2);
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i2 = rect.top;
        int eu = eu(activity);
        if (i2 == 0) {
            i2 = ao.jK(activity);
        }
        final int i3 = i2 + eu;
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.ui.base.u.AnonymousClass9 */

            public final void run() {
                AppMethodBeat.i(142237);
                pVar.showAtLocation(activity.getWindow().getDecorView(), 48, 0, i3);
                AppMethodBeat.o(142237);
            }
        });
        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
            /* class com.tencent.mm.ui.base.u.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(142231);
                pVar.dismiss();
                AppMethodBeat.o(142231);
            }
        }, 2000);
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.ecy);
        imageButton.setVisibility(8);
        imageButton.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.ui.base.u.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(142232);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMToast$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                pVar.dismiss();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMToast$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(142232);
            }
        });
        AppMethodBeat.o(205246);
        return pVar;
    }

    public static int ay(Context context2) {
        AppMethodBeat.i(259382);
        int jK = ao.jK(context2);
        AppMethodBeat.o(259382);
        return jK;
    }
}
