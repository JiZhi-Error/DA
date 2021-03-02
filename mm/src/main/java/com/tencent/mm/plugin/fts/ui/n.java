package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.json.JSONObject;

public final class n {
    public static boolean a(CharSequence charSequence, TextView textView) {
        AppMethodBeat.i(112037);
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            AppMethodBeat.o(112037);
            return false;
        }
        textView.setText(charSequence, TextView.BufferType.SPANNABLE);
        textView.setVisibility(0);
        AppMethodBeat.o(112037);
        return true;
    }

    public static boolean b(String str, TextView textView) {
        AppMethodBeat.i(112038);
        if (textView == null) {
            AppMethodBeat.o(112038);
            return false;
        } else if (str == null || str.length() == 0) {
            textView.setVisibility(8);
            AppMethodBeat.o(112038);
            return false;
        } else {
            textView.setText(l.b(textView.getContext(), str, textView.getTextSize()));
            textView.setVisibility(0);
            AppMethodBeat.o(112038);
            return true;
        }
    }

    public static void a(Context context, ImageView imageView, String str, String str2, int i2, boolean z) {
        AppMethodBeat.i(112039);
        a(context, imageView, str, str2, i2, z, 0, 0);
        AppMethodBeat.o(112039);
    }

    public static void a(Context context, ImageView imageView, String str, String str2, int i2, int i3, int i4) {
        AppMethodBeat.i(112040);
        a(context, imageView, str, str2, i2, false, i3, i4);
        AppMethodBeat.o(112040);
    }

    private static void a(Context context, ImageView imageView, String str, String str2, int i2, boolean z, int i3, int i4) {
        AppMethodBeat.i(112041);
        b(context, imageView, str, str2, i2, z, i3, i4);
        AppMethodBeat.o(112041);
    }

    private static void b(Context context, ImageView imageView, String str, String str2, int i2, boolean z, int i3, int i4) {
        AppMethodBeat.i(112042);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().a(imageView, str, str2, z, i3, i4);
        if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str2)) {
            Bitmap b2 = ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().b(str, str2, z, i3, i4);
            if (b2 == null || b2.isRecycled()) {
                if (i2 > 0) {
                    imageView.setImageResource(i2);
                } else {
                    imageView.setImageResource(R.color.ac_);
                }
                ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSImageLoader().a(context, imageView, str, str2, z, i3, i4);
            } else {
                c.a.a(context.getResources(), b2, imageView);
            }
            imageView.setVisibility(0);
            AppMethodBeat.o(112042);
        } else if (i2 <= 0 || (Util.isNullOrNil(str) && Util.isNullOrNil(str2))) {
            imageView.setVisibility(8);
            AppMethodBeat.o(112042);
        } else {
            imageView.setImageResource(i2);
            AppMethodBeat.o(112042);
        }
    }

    public static String Nu(int i2) {
        AppMethodBeat.i(112043);
        int i3 = 0;
        switch (i2) {
            case -20:
                i3 = R.string.djz;
                break;
            case -15:
                i3 = R.string.djp;
                break;
            case -13:
                i3 = R.string.djy;
                break;
            case -11:
                i3 = R.string.djq;
                break;
            case -8:
                i3 = R.string.djx;
                break;
            case -7:
                i3 = R.string.djm;
                break;
            case -6:
                i3 = R.string.djl;
                break;
            case -5:
                i3 = R.string.djn;
                break;
            case -4:
                i3 = R.string.djh;
                break;
            case -3:
                i3 = R.string.djg;
                break;
            case -2:
                i3 = R.string.djo;
                break;
            case -1:
                i3 = R.string.djk;
                break;
        }
        if (i3 == 0) {
            AppMethodBeat.o(112043);
            return null;
        }
        String string = MMApplicationContext.getContext().getString(i3);
        AppMethodBeat.o(112043);
        return string;
    }

    public static CharSequence a(Context context, List<com.tencent.mm.plugin.fts.a.a.g> list, String[] strArr, h hVar, TextPaint textPaint) {
        as Kn;
        AppMethodBeat.i(112044);
        final com.tencent.mm.plugin.fts.a.n nVar = (com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class);
        Arrays.sort(strArr, new Comparator<String>() {
            /* class com.tencent.mm.plugin.fts.ui.n.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* synthetic */ int compare(String str, String str2) {
                AppMethodBeat.i(112036);
                int stringCompareUtfBinary = nVar.stringCompareUtfBinary(str, str2);
                AppMethodBeat.o(112036);
                return stringCompareUtfBinary;
            }
        });
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            com.tencent.mm.plugin.fts.a.a.g gVar = list.get(i2);
            if (gVar.wWv < strArr.length) {
                String str = strArr[gVar.wWv];
                if (!Util.isNullOrNil(str) && (Kn = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(str)) != null) {
                    String str2 = Kn.field_username;
                    String b2 = ((b) g.af(b.class)).b(Kn, str2);
                    switch (gVar.wVW) {
                        case 31:
                            gVar.wWA = true;
                        case 30:
                            gVar.wWe = true;
                        case 29:
                            gVar.wWx = b2;
                            break;
                        case 32:
                            gVar.wWx = Kn.fuR;
                            gVar.wWy = b2;
                            break;
                        case 33:
                            gVar.wWx = gVar.content;
                            gVar.wWy = b2;
                            break;
                        case 36:
                            gVar.wWA = true;
                        case 35:
                            gVar.wWe = true;
                        case 34:
                            gVar.wWx = Kn.field_nickname;
                            if (!Kn.field_nickname.equals(b2)) {
                                gVar.wWy = b2;
                                break;
                            }
                            break;
                        case 37:
                            gVar.wWx = d.hw(str2, Kn.ajx());
                            gVar.wWy = b2;
                            break;
                    }
                    if (!Util.isNullOrNil(gVar.wWx) && gVar.wWx.contains(hVar.wWB)) {
                        gVar.wWz += 10;
                    }
                }
            }
        }
        Collections.sort(list, new Comparator<com.tencent.mm.plugin.fts.a.a.g>() {
            /* class com.tencent.mm.plugin.fts.ui.n.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(com.tencent.mm.plugin.fts.a.a.g gVar, com.tencent.mm.plugin.fts.a.a.g gVar2) {
                return gVar2.wWz - gVar.wWz;
            }
        });
        int i3 = 0;
        float f2 = 0.0f;
        while (i3 < list.size() && i3 < hVar.wWD.length) {
            float f3 = ((float) (b.a.wZP - 100)) - f2;
            if (f3 > 100.0f) {
                com.tencent.mm.plugin.fts.a.a.g gVar2 = list.get(i3);
                SpannableString b3 = l.b(context, gVar2.wWx, textPaint.getTextSize());
                if (spannableStringBuilder.length() > 0) {
                    spannableStringBuilder.append((CharSequence) ", ");
                }
                e eVar = new e();
                eVar.wWc = b3;
                eVar.wWd = hVar;
                eVar.wWe = gVar2.wWe;
                eVar.wWf = gVar2.wWA;
                eVar.wWi = f3;
                eVar.iW = textPaint;
                if (!Util.isNullOrNil(gVar2.wWy)) {
                    eVar.wWj = TextUtils.concat(l.b(context, gVar2.wWy, textPaint.getTextSize()), "(");
                    eVar.wWk = ")";
                }
                spannableStringBuilder.append(f.a(eVar).wWu);
                f2 = textPaint.measureText(spannableStringBuilder.toString());
                i3++;
            }
        }
        AppMethodBeat.o(112044);
        return spannableStringBuilder;
    }

    public static final void q(View view, boolean z) {
        AppMethodBeat.i(112045);
        if (z) {
            view.setVisibility(0);
            AppMethodBeat.o(112045);
            return;
        }
        view.setVisibility(8);
        AppMethodBeat.o(112045);
    }

    public static final void r(View view, boolean z) {
        AppMethodBeat.i(112046);
        if (z) {
            view.setBackgroundResource(R.drawable.qa);
            AppMethodBeat.o(112046);
            return;
        }
        view.setBackgroundResource(R.drawable.a5e);
        AppMethodBeat.o(112046);
    }

    public static final void s(View view, boolean z) {
        AppMethodBeat.i(112047);
        if (z) {
            view.setBackgroundResource(R.drawable.b9w);
            AppMethodBeat.o(112047);
            return;
        }
        view.setBackgroundResource(R.drawable.aij);
        AppMethodBeat.o(112047);
    }

    public static int a(JSONObject jSONObject, String str, Context context) {
        AppMethodBeat.i(112048);
        int optInt = jSONObject == null ? 0 : jSONObject.optInt("businessType");
        if (optInt == 0) {
            if (str.equals(context.getString(R.string.ggb))) {
                optInt = 2;
            } else if (str.equals(context.getString(R.string.ggf))) {
                optInt = 8;
            } else if (str.equals(context.getString(R.string.ggc))) {
                optInt = 1;
            } else {
                Log.i("MicroMsg.FTS.FTSUIApiLogic", "option " + str + " no type");
            }
        }
        AppMethodBeat.o(112048);
        return optInt;
    }
}
