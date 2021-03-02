package com.tencent.mm.plugin.card.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.av.q;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class n {
    public static Rect dC(View view) {
        AppMethodBeat.i(113858);
        Rect rect = new Rect();
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        AppMethodBeat.o(113858);
        return rect;
    }

    public static void f(View view, Rect rect) {
        AppMethodBeat.i(113859);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.o(113859);
    }

    public static String akl(String str) {
        AppMethodBeat.i(113860);
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.CardViewUtil", "toApply is null");
            AppMethodBeat.o(113860);
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            sb.append(str.charAt(i2));
            if ((i2 + 1) % 4 == 0) {
                sb.append(" ");
            }
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(113860);
        return sb2;
    }

    public static void a(ImageView imageView, String str, int i2, int i3, boolean z) {
        AppMethodBeat.i(113861);
        if (imageView == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(113861);
        } else if (!TextUtils.isEmpty(str)) {
            c.a aVar = new c.a();
            aVar.prefixPath = b.aKJ();
            q.bcW();
            aVar.jbw = null;
            aVar.fullPath = m.ajp(str);
            aVar.jbf = true;
            aVar.iaT = z;
            aVar.jbd = true;
            aVar.hZA = i2;
            aVar.hZz = i2;
            aVar.jbq = i3;
            q.bcV().a(str, imageView, aVar.bdv());
            AppMethodBeat.o(113861);
        } else {
            imageView.setImageResource(i3);
            AppMethodBeat.o(113861);
        }
    }

    public static void a(final Context context, final ImageView imageView, String str, int i2, final int i3) {
        AppMethodBeat.i(113862);
        if (imageView == null || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(113862);
        } else if (!TextUtils.isEmpty(str)) {
            c.a aVar = new c.a();
            aVar.prefixPath = b.aKJ();
            q.bcW();
            aVar.jbw = null;
            aVar.fullPath = m.ajp(str);
            aVar.jbf = true;
            aVar.iaT = false;
            aVar.jbd = true;
            aVar.hZA = i2;
            aVar.hZz = i2;
            aVar.jbq = R.drawable.c2i;
            q.bcV().a(str, imageView, aVar.bdv(), new h() {
                /* class com.tencent.mm.plugin.card.d.n.AnonymousClass1 */
                final /* synthetic */ int qld = R.drawable.c2i;

                @Override // com.tencent.mm.av.a.c.h
                public final void b(String str, View view) {
                }

                @Override // com.tencent.mm.av.a.c.h
                public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                    return null;
                }

                @Override // com.tencent.mm.av.a.c.h
                public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                    AppMethodBeat.i(113855);
                    if (bVar.bitmap != null) {
                        final Bitmap bitmap = bVar.bitmap;
                        MMHandlerThread.postToMainThread(new Runnable() {
                            /* class com.tencent.mm.plugin.card.d.n.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(113854);
                                imageView.setImageBitmap(bitmap);
                                imageView.setColorFilter(i3, PorterDuff.Mode.SRC_IN);
                                AppMethodBeat.o(113854);
                            }
                        });
                        AppMethodBeat.o(113855);
                        return;
                    }
                    n.b(imageView, this.qld, i3);
                    AppMethodBeat.o(113855);
                }
            });
            AppMethodBeat.o(113862);
        } else {
            b(imageView, R.drawable.c2i, i3);
            AppMethodBeat.o(113862);
        }
    }

    public static void b(final ImageView imageView, final int i2, final int i3) {
        AppMethodBeat.i(113863);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.mm.plugin.card.d.n.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(113856);
                imageView.setImageResource(i2);
                imageView.setColorFilter(i3, PorterDuff.Mode.SRC_IN);
                AppMethodBeat.o(113856);
            }
        });
        AppMethodBeat.o(113863);
    }

    public static void a(MMActivity mMActivity, com.tencent.mm.plugin.card.base.b bVar) {
        AppMethodBeat.i(113864);
        mMActivity.setActionbarColor(l.ake(bVar.csQ().ixw));
        AppMethodBeat.o(113864);
    }

    public static void d(MMActivity mMActivity) {
        AppMethodBeat.i(113865);
        mMActivity.setActionbarColor(mMActivity.getResources().getColor(R.color.afz));
        AppMethodBeat.o(113865);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public static void h(TextView textView, int i2) {
        AppMethodBeat.i(113866);
        switch (i2) {
            case 0:
                textView.setText(R.string.ata);
                AppMethodBeat.o(113866);
                return;
            case 1:
                textView.setText(R.string.at6);
                AppMethodBeat.o(113866);
                return;
            case 2:
                textView.setText(R.string.at9);
                AppMethodBeat.o(113866);
                return;
            case 3:
                textView.setText(R.string.at8);
                AppMethodBeat.o(113866);
                return;
            case 4:
                textView.setText(R.string.atb);
                AppMethodBeat.o(113866);
                return;
            case 5:
                textView.setText(R.string.atc);
                AppMethodBeat.o(113866);
                return;
            case 6:
                textView.setText(R.string.at7);
                AppMethodBeat.o(113866);
                return;
            case 7:
                textView.setText(R.string.at_);
                break;
        }
        AppMethodBeat.o(113866);
    }

    public static void a(View view, LinearLayout linearLayout) {
        AppMethodBeat.i(113867);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(view);
        AppMethodBeat.o(113867);
    }
}
