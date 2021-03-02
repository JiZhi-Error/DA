package com.tencent.mm.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "201400504", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
@Deprecated
public final class h {

    public interface a {
        void Vq(int i2);
    }

    public interface b {
        boolean onFinish(CharSequence charSequence);
    }

    public interface c {
        void addDialog(Dialog dialog);
    }

    public interface d {
        void oj(int i2);
    }

    public interface e {
        void cy(int i2, int i3);
    }

    public static void a(Context context, Dialog dialog) {
        AppMethodBeat.i(141786);
        if (context instanceof c) {
            ((c) context).addDialog(dialog);
            if (context instanceof com.tencent.mm.ui.widget.a.c) {
                if (dialog instanceof com.tencent.mm.ui.widget.a.d) {
                    ((com.tencent.mm.ui.widget.a.d) dialog).iOnDialogDismissListener = (com.tencent.mm.ui.widget.a.c) context;
                    AppMethodBeat.o(141786);
                    return;
                } else if (dialog instanceof i) {
                    ((i) dialog).setiOnDialogDismissListener((com.tencent.mm.ui.widget.a.c) context);
                }
            }
        }
        AppMethodBeat.o(141786);
    }

    public static Toast cB(Context context, String str) {
        AppMethodBeat.i(141788);
        Toast cD = cD(context, str);
        AppMethodBeat.o(141788);
        return cD;
    }

    public static void cC(Context context, String str) {
        AppMethodBeat.i(141789);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            Toast.makeText(context, str, 0).show();
            AppMethodBeat.o(141789);
            return;
        }
        AppMethodBeat.o(141789);
    }

    public static Toast cD(Context context, String str) {
        AppMethodBeat.i(141790);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            Toast makeText = Toast.makeText(context, str, 0);
            makeText.show();
            AppMethodBeat.o(141790);
            return makeText;
        }
        AppMethodBeat.o(141790);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d X(Context context, String str, String str2) {
        AppMethodBeat.i(259380);
        com.tencent.mm.ui.widget.a.d c2 = c(context, str, str2, true);
        AppMethodBeat.o(259380);
        return c2;
    }

    public static com.tencent.mm.ui.widget.a.d c(Context context, String str, String str2, boolean z) {
        AppMethodBeat.i(141792);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str2);
            aVar.boo(str);
            aVar.Dk(z);
            aVar.aoV(R.string.x_).c(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.base.h.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(141772);
                    dialogInterface.cancel();
                    AppMethodBeat.o(141772);
                }
            });
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141792);
            return hbn;
        }
        AppMethodBeat.o(141792);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, String str2, DialogInterface.OnDismissListener onDismissListener) {
        AppMethodBeat.i(164147);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str2);
            aVar.boo(str);
            aVar.a(onDismissListener);
            aVar.Dk(false);
            aVar.aoV(R.string.x_).c(new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.base.h.AnonymousClass6 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(141776);
                    dialogInterface.cancel();
                    AppMethodBeat.o(141776);
                }
            });
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(164147);
            return hbn;
        }
        AppMethodBeat.o(164147);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d n(Context context, int i2, int i3) {
        String str;
        AppMethodBeat.i(141793);
        String aJ = i2 > 0 ? com.tencent.mm.cc.e.aJ(context, i2) : "";
        if (i3 > 0) {
            str = com.tencent.mm.cc.e.aJ(context, i3);
        } else {
            str = "";
        }
        com.tencent.mm.ui.widget.a.d c2 = c(context, aJ, str, true);
        AppMethodBeat.o(141793);
        return c2;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, int i2, int i3, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(141794);
        com.tencent.mm.ui.widget.a.d a2 = a(context, i2, i3, true, onClickListener);
        AppMethodBeat.o(141794);
        return a2;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, int i2, int i3, boolean z, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(141795);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            if (i3 > 0) {
                aVar.bon(com.tencent.mm.cc.e.jp(context).getString(i3));
            }
            aVar.boo(com.tencent.mm.cc.e.jp(context).getString(i2));
            aVar.aoV(R.string.x_).c(onClickListener);
            aVar.Dk(z);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141795);
            return hbn;
        }
        AppMethodBeat.o(141795);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d d(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(141796);
        com.tencent.mm.ui.widget.a.d a2 = a(context, str, str2, true, onClickListener);
        AppMethodBeat.o(141796);
        return a2;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(141797);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str2);
            aVar.boo(str);
            aVar.aoV(R.string.x_).c(onClickListener);
            aVar.Dk(z);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141797);
            return hbn;
        }
        AppMethodBeat.o(141797);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, String str2, String str3, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(141798);
        com.tencent.mm.ui.widget.a.d a2 = a(context, str, str2, str3, true, onClickListener);
        AppMethodBeat.o(141798);
        return a2;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, String str2, String str3, boolean z, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(141799);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str2);
            aVar.boo(str);
            aVar.bou(str3).c(onClickListener);
            aVar.Dk(z);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141799);
            return hbn;
        }
        AppMethodBeat.o(141799);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(141800);
        com.tencent.mm.ui.widget.a.d a2 = a(context, str, str2, onClickListener, onClickListener2, -1);
        AppMethodBeat.o(141800);
        return a2;
    }

    private static com.tencent.mm.ui.widget.a.d a(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, int i2) {
        AppMethodBeat.i(205224);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str2);
            aVar.boo(str);
            aVar.aoV(R.string.x_).c(onClickListener);
            aVar.aoW(R.string.sz).d(onClickListener2);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            if (i2 > 0) {
                hbn.ajL(context.getResources().getColor(i2));
            }
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(205224);
            return hbn;
        }
        AppMethodBeat.o(205224);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(141801);
        com.tencent.mm.ui.widget.a.d b2 = b(context, str, str2, z, onClickListener, onClickListener2);
        AppMethodBeat.o(141801);
        return b2;
    }

    private static com.tencent.mm.ui.widget.a.d b(Context context, String str, String str2, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(205225);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str2);
            aVar.boo(str);
            aVar.aoV(R.string.x_).c(onClickListener);
            aVar.aoW(R.string.sz).d(onClickListener2);
            aVar.Dk(z);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(205225);
            return hbn;
        }
        AppMethodBeat.o(205225);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, String str2, String str3, String str4, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(141802);
        com.tencent.mm.ui.widget.a.d a2 = a(context, str, str2, str3, str4, z, onClickListener, onClickListener2, -1);
        AppMethodBeat.o(141802);
        return a2;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, String str2, String str3, String str4, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, int i2) {
        AppMethodBeat.i(141803);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str2);
            aVar.boo(str);
            aVar.bou(str3).c(onClickListener);
            aVar.bov(str4).d(onClickListener2);
            aVar.Dk(z);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            if (i2 > 0) {
                hbn.ajL(context.getResources().getColor(i2));
            }
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141803);
            return hbn;
        }
        AppMethodBeat.o(141803);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, int i2, int i3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(141804);
        com.tencent.mm.ui.widget.a.d a2 = a(context, i2, i3, onClickListener, onClickListener2, -1);
        AppMethodBeat.o(141804);
        return a2;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, int i2, int i3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, int i4) {
        AppMethodBeat.i(205226);
        com.tencent.mm.ui.widget.a.d a2 = a(context, i2 > 0 ? com.tencent.mm.cc.e.aJ(context, i2) : "", i3 > 0 ? com.tencent.mm.cc.e.aJ(context, i3) : "", onClickListener, onClickListener2, i4);
        AppMethodBeat.o(205226);
        return a2;
    }

    public static com.tencent.mm.ui.widget.a.d b(Context context, int i2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(141805);
        com.tencent.mm.ui.widget.a.d a2 = a(context, i2 > 0 ? com.tencent.mm.cc.e.aJ(context, i2) : "", com.tencent.mm.cc.e.aJ(context, R.string.zb), false, onClickListener, onClickListener2);
        AppMethodBeat.o(141805);
        return a2;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, int i2, int i3, int i4, int i5, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(141806);
        com.tencent.mm.ui.widget.a.d a2 = a(context, i2 > 0 ? com.tencent.mm.cc.e.aJ(context, i2) : "", i3 > 0 ? com.tencent.mm.cc.e.aJ(context, i3) : "", com.tencent.mm.cc.e.aJ(context, i4), com.tencent.mm.cc.e.aJ(context, i5), z, onClickListener, onClickListener2);
        AppMethodBeat.o(141806);
        return a2;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, int i2, int i3, int i4, int i5, boolean z, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, int i6) {
        AppMethodBeat.i(141807);
        com.tencent.mm.ui.widget.a.d a2 = a(context, i2 > 0 ? com.tencent.mm.cc.e.aJ(context, i2) : "", i3 > 0 ? com.tencent.mm.cc.e.aJ(context, i3) : "", com.tencent.mm.cc.e.aJ(context, i4), com.tencent.mm.cc.e.aJ(context, i5), z, onClickListener, onClickListener2, i6);
        AppMethodBeat.o(141807);
        return a2;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, int i2, int i3, int i4, int i5, DialogInterface.OnClickListener onClickListener, final DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(141808);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            if (i3 != 0) {
                aVar.aoO(i3);
            }
            aVar.aoS(i2);
            aVar.aoV(i4).c(onClickListener);
            aVar.aoW(i5).d(onClickListener2);
            aVar.f(new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.base.h.AnonymousClass7 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(141777);
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(dialogInterface, 0);
                    }
                    AppMethodBeat.o(141777);
                }
            });
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141808);
            return hbn;
        }
        AppMethodBeat.o(141808);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d c(Context context, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(141809);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str2);
            aVar.boo(str);
            aVar.bou(str3).c(onClickListener);
            aVar.bov(str4).d(onClickListener2);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141809);
            return hbn;
        }
        AppMethodBeat.o(141809);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, int i2) {
        AppMethodBeat.i(141810);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str2);
            aVar.boo(str);
            aVar.bou(str3).c(onClickListener);
            aVar.bov(str4).d(onClickListener2);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.ajL(context.getResources().getColor(i2));
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141810);
            return hbn;
        }
        AppMethodBeat.o(141810);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, boolean z, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(141811);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str2);
            aVar.boo(str);
            aVar.bou(str3).c(onClickListener);
            aVar.bov(str4).d(onClickListener2);
            aVar.Dk(z);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141811);
            return hbn;
        }
        AppMethodBeat.o(141811);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, boolean z, String str, String str2, String str3, String str4, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, int i2, int i3) {
        AppMethodBeat.i(141812);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str2);
            aVar.boo(str);
            aVar.bou(str3).c(onClickListener);
            aVar.bov(str4).d(onClickListener2);
            aVar.Dk(z);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            if (i2 > 0) {
                hbn.ajL(context.getResources().getColor(i2));
            }
            if (i3 > 0) {
                hbn.ajM(context.getResources().getColor(i3));
            }
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141812);
            return hbn;
        }
        AppMethodBeat.o(141812);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, View view, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(141813);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str);
            aVar.hs(view);
            aVar.aoV(R.string.x_).c(onClickListener);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141813);
            return hbn;
        }
        AppMethodBeat.o(141813);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, View view, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(141814);
        com.tencent.mm.ui.widget.a.d a2 = a(context, true, str, view, str2, str3, onClickListener, onClickListener2);
        AppMethodBeat.o(141814);
        return a2;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, boolean z, String str, View view, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(141815);
        com.tencent.mm.ui.widget.a.d a2 = a(context, z, str, view, str2, str3, onClickListener, onClickListener2, -1);
        AppMethodBeat.o(141815);
        return a2;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, boolean z, String str, View view, String str2, String str3, DialogInterface.OnClickListener onClickListener, DialogInterface.OnClickListener onClickListener2, int i2) {
        AppMethodBeat.i(141816);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str);
            aVar.hs(view);
            aVar.bou(str2).c(onClickListener);
            aVar.bov(str3).d(onClickListener2);
            aVar.Dk(z);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            if (i2 > 0) {
                hbn.ajL(context.getResources().getColor(i2));
            }
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141816);
            return hbn;
        }
        AppMethodBeat.o(141816);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, String str2, View view, DialogInterface.OnClickListener onClickListener) {
        AppMethodBeat.i(141817);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str);
            aVar.hs(view);
            aVar.bou(str2).c(onClickListener);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141817);
            return hbn;
        }
        AppMethodBeat.o(141817);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, View view, DialogInterface.OnClickListener onClickListener, final DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(141818);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str);
            aVar.boo(null);
            aVar.hs(view);
            aVar.aoV(R.string.x_).c(onClickListener);
            aVar.aoW(R.string.sz).d(onClickListener2);
            aVar.f(new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.base.h.AnonymousClass8 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(141778);
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(dialogInterface, 0);
                    }
                    AppMethodBeat.o(141778);
                }
            });
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141818);
            return hbn;
        }
        AppMethodBeat.o(141818);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, View view, DialogInterface.OnClickListener onClickListener, final DialogInterface.OnClickListener onClickListener2) {
        AppMethodBeat.i(205227);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.aoO(R.string.zb);
            aVar.aoS(-1);
            aVar.hs(view);
            aVar.aoV(R.string.x_).c(onClickListener);
            aVar.aoW(R.string.he).d(onClickListener2);
            aVar.f(new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.base.h.AnonymousClass9 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(205215);
                    if (onClickListener2 != null) {
                        onClickListener2.onClick(dialogInterface, 0);
                    }
                    AppMethodBeat.o(205215);
                }
            });
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(205227);
            return hbn;
        }
        AppMethodBeat.o(205227);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, String str2, String str3, int i2, b bVar) {
        AppMethodBeat.i(141819);
        com.tencent.mm.ui.widget.a.d b2 = b(context, str, str2, str3, i2, bVar);
        AppMethodBeat.o(141819);
        return b2;
    }

    private static com.tencent.mm.ui.widget.a.d b(final Context context, String str, String str2, String str3, int i2, final b bVar) {
        AppMethodBeat.i(141820);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.Dk(false);
            aVar.Dl(true);
            aVar.aoW(R.string.sz).d(null);
            aVar.bon(str);
            View inflate = View.inflate(context, R.layout.b7k, null);
            final MMEditText mMEditText = (MMEditText) inflate.findViewById(R.id.bxz);
            if (!Util.isNullOrNil(str2)) {
                mMEditText.bol(str2);
            }
            TextView textView = (TextView) inflate.findViewById(R.id.ipe);
            if (Util.isNullOrNil(str3)) {
                textView.setVisibility(8);
            } else {
                textView.setText(str3);
            }
            aVar.aoV(R.string.x_).a(false, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.ui.base.h.AnonymousClass10 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(205217);
                    boolean z = true;
                    if (bVar != null) {
                        z = bVar.onFinish(mMEditText.getText().toString().trim());
                    }
                    if (z) {
                        dialogInterface.dismiss();
                        if (context instanceof MMActivity) {
                            MMHandlerThread.postToMainThread(new Runnable() {
                                /* class com.tencent.mm.ui.base.h.AnonymousClass10.AnonymousClass1 */

                                public final void run() {
                                    AppMethodBeat.i(205216);
                                    ((MMActivity) context).hideVKB();
                                    AppMethodBeat.o(205216);
                                }
                            });
                        }
                    }
                    AppMethodBeat.o(205217);
                }
            });
            if (i2 > 0) {
                com.tencent.mm.ui.tools.b.c.f(mMEditText).aoq(i2).a((c.a) null);
            }
            aVar.hs(inflate);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            a(context, hbn);
            if (context instanceof MMActivity) {
                inflate.post(new Runnable() {
                    /* class com.tencent.mm.ui.base.h.AnonymousClass11 */

                    public final void run() {
                        AppMethodBeat.i(205218);
                        ((MMActivity) context).showVKB();
                        AppMethodBeat.o(205218);
                    }
                });
            }
            AppMethodBeat.o(141820);
            return hbn;
        }
        AppMethodBeat.o(141820);
        return null;
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, List<String> list, int i2, final a aVar) {
        AppMethodBeat.i(141821);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(141821);
            return null;
        } else if (list.isEmpty()) {
            Log.w("MicroMsg.MMAlert", "show switch alert fail");
            AppMethodBeat.o(141821);
            return null;
        } else {
            d.a aVar2 = new d.a(context);
            aVar2.Dk(false);
            aVar2.aoW(R.string.sz);
            aVar2.bon(str);
            View inflate = View.inflate(context, R.layout.b7l, null);
            final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.ifm);
            for (int size = list.size() - 1; size >= 0; size--) {
                TextView textView = (TextView) View.inflate(context, R.layout.bkg, null);
                textView.setText(list.get(size));
                if (size == i2) {
                    textView.setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_on, 0, 0, 0);
                }
                if (size == list.size() - 1) {
                    context.getResources().getDimensionPixelSize(R.dimen.ir);
                    textView.setBackgroundResource(R.drawable.axz);
                }
                textView.setTag(Integer.valueOf(size));
                linearLayout.addView(textView, 0);
                textView.setOnClickListener(new View.OnClickListener() {
                    /* class com.tencent.mm.ui.base.h.AnonymousClass12 */

                    public final void onClick(View view) {
                        AppMethodBeat.i(205220);
                        com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                        bVar.bm(view);
                        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/base/MMAlert$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                        for (int i2 = 0; i2 < linearLayout.getChildCount(); i2++) {
                            TextView textView = (TextView) linearLayout.getChildAt(i2);
                            if (textView.getId() != R.id.ipe) {
                                textView.setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_off, 0, 0, 0);
                            }
                        }
                        ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(R.raw.radio_on, 0, 0, 0);
                        final int intValue = ((Integer) view.getTag()).intValue();
                        view.post(new Runnable() {
                            /* class com.tencent.mm.ui.base.h.AnonymousClass12.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(205219);
                                ((Dialog) linearLayout.getTag()).dismiss();
                                if (aVar != null) {
                                    aVar.Vq(intValue);
                                }
                                AppMethodBeat.o(205219);
                            }
                        });
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMAlert$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(205220);
                    }
                });
            }
            aVar2.hs(inflate);
            com.tencent.mm.ui.widget.a.d hbn = aVar2.hbn();
            linearLayout.setTag(hbn);
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141821);
            return hbn;
        }
    }

    public static com.tencent.mm.ui.widget.a.d a(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(141822);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            d.a aVar = new d.a(context);
            aVar.bon(str2);
            aVar.boo(str);
            aVar.aoV(R.string.x_).c(onClickListener);
            aVar.f(onCancelListener);
            com.tencent.mm.ui.widget.a.d hbn = aVar.hbn();
            hbn.show();
            a(context, hbn);
            AppMethodBeat.o(141822);
            return hbn;
        }
        AppMethodBeat.o(141822);
        return null;
    }

    public static q a(Context context, String str, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(141823);
        q a2 = a(context, 0, str, z, onCancelListener);
        AppMethodBeat.o(141823);
        return a2;
    }

    public static q b(Context context, String str, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(205228);
        q a2 = a(context, 2, str, z, onCancelListener);
        AppMethodBeat.o(205228);
        return a2;
    }

    public static q a(Context context, int i2, String str, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(141825);
        q a2 = a(context, i2, -1, str, z, onCancelListener);
        AppMethodBeat.o(141825);
        return a2;
    }

    public static q a(Context context, int i2, int i3, String str, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(141826);
        if (!(context instanceof Activity) || !((Activity) context).isFinishing()) {
            aa.activateBroadcast(true);
            final WeakReference weakReference = new WeakReference(onCancelListener);
            q b2 = q.b(context, str, z, i2, i3, new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.ui.base.h.AnonymousClass13 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(205221);
                    DialogInterface.OnCancelListener onCancelListener = (DialogInterface.OnCancelListener) weakReference.get();
                    if (onCancelListener != null) {
                        onCancelListener.onCancel(dialogInterface);
                    }
                    aa.activateBroadcast(false);
                    AppMethodBeat.o(205221);
                }
            });
            a(context, b2);
            AppMethodBeat.o(141826);
            return b2;
        }
        AppMethodBeat.o(141826);
        return null;
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, String str2, e eVar) {
        AppMethodBeat.i(141827);
        Dialog c2 = c(context, str, list, list2, str2, eVar);
        AppMethodBeat.o(141827);
        return c2;
    }

    public static Dialog b(Context context, String str, List<String> list, List<Integer> list2, String str2, e eVar) {
        AppMethodBeat.i(141828);
        Dialog c2 = c(context, str, list, list2, str2, eVar);
        AppMethodBeat.o(141828);
        return c2;
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, e eVar) {
        AppMethodBeat.i(141829);
        Dialog c2 = c(context, str, list, list2, null, eVar);
        AppMethodBeat.o(141829);
        return c2;
    }

    @Deprecated
    private static Dialog c(Context context, final String str, final List<String> list, final List<Integer> list2, final String str2, final e eVar) {
        AppMethodBeat.i(141830);
        if ((list == null || list.size() == 0) && Util.isNullOrNil(str2)) {
            AppMethodBeat.o(141830);
        } else {
            if (list == null) {
                list = new ArrayList<>();
            }
            com.tencent.mm.ui.widget.a.e eVar2 = new com.tencent.mm.ui.widget.a.e(context, 1, false);
            eVar2.HLX = new o.f() {
                /* class com.tencent.mm.ui.base.h.AnonymousClass2 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(205211);
                    if (!Util.isNullOrNil(str)) {
                        mVar.setHeaderTitle(str);
                    }
                    for (int i2 = 0; i2 < list.size(); i2++) {
                        mVar.d(((Integer) list2.get(i2)).intValue(), (CharSequence) list.get(i2));
                    }
                    if (!Util.isNullOrNil(str2)) {
                        mVar.d(-1, str2);
                    }
                    AppMethodBeat.o(205211);
                }
            };
            eVar2.HLY = new o.g() {
                /* class com.tencent.mm.ui.base.h.AnonymousClass3 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(205212);
                    if (eVar != null) {
                        eVar.cy(i2, menuItem.getItemId());
                    }
                    AppMethodBeat.o(205212);
                }
            };
            eVar2.dGm();
            AppMethodBeat.o(141830);
        }
        return null;
    }

    public static Dialog a(Context context, String str, String[] strArr, d dVar) {
        AppMethodBeat.i(141831);
        Dialog d2 = d(context, str, strArr, null, dVar);
        AppMethodBeat.o(141831);
        return d2;
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, d dVar) {
        AppMethodBeat.i(141832);
        Dialog d2 = d(context, str, strArr, str2, dVar);
        AppMethodBeat.o(141832);
        return d2;
    }

    public static Dialog b(Context context, String str, String[] strArr, String str2, d dVar) {
        AppMethodBeat.i(141833);
        Dialog d2 = d(context, str, strArr, str2, dVar);
        AppMethodBeat.o(141833);
        return d2;
    }

    public static Dialog c(Context context, String str, String[] strArr, String str2, d dVar) {
        AppMethodBeat.i(141834);
        Dialog d2 = d(context, str, strArr, str2, dVar);
        AppMethodBeat.o(141834);
        return d2;
    }

    @Deprecated
    private static Dialog d(Context context, final String str, String[] strArr, String str2, final d dVar) {
        AppMethodBeat.i(141835);
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            AppMethodBeat.o(141835);
        } else if ((strArr == null || strArr.length == 0) && Util.isNullOrNil(str2)) {
            AppMethodBeat.o(141835);
        } else {
            final ArrayList arrayList = new ArrayList();
            if (strArr != null && strArr.length > 0) {
                Collections.addAll(arrayList, strArr);
            }
            if (!Util.isNullOrNil(str2)) {
                arrayList.add(str2);
            }
            com.tencent.mm.ui.widget.a.e eVar = new com.tencent.mm.ui.widget.a.e(context, 1, false);
            eVar.HLX = new o.f() {
                /* class com.tencent.mm.ui.base.h.AnonymousClass4 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(205213);
                    mVar.setHeaderTitle(str);
                    for (int i2 = 0; i2 < arrayList.size(); i2++) {
                        mVar.d(i2, (CharSequence) arrayList.get(i2));
                    }
                    AppMethodBeat.o(205213);
                }
            };
            eVar.HLY = new o.g() {
                /* class com.tencent.mm.ui.base.h.AnonymousClass5 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(205214);
                    if (dVar != null) {
                        dVar.oj(menuItem.getItemId());
                    }
                    AppMethodBeat.o(205214);
                }
            };
            eVar.dGm();
            AppMethodBeat.o(141835);
        }
        return null;
    }

    public static Toast cA(Context context, String str) {
        AppMethodBeat.i(259379);
        Toast cD = cD(context, str);
        AppMethodBeat.o(259379);
        return cD;
    }
}
