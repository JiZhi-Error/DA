package com.tencent.mm.openim.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.a.a;
import com.tencent.mm.openim.e.c;
import com.tencent.mm.openim.e.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.span.MMTextAppearanceSpan;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.cwr;
import com.tencent.mm.protocal.protobuf.cws;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.EllipsizeTextView;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class t implements com.tencent.mm.openim.a.a {
    private HashMap<String, b> jHk = new HashMap<>();
    private EllipsizeTextView.a jHl = new EllipsizeTextView.a() {
        /* class com.tencent.mm.openim.b.t.AnonymousClass1 */

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.CharSequence] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // com.tencent.mm.ui.base.EllipsizeTextView.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.CharSequence a(android.widget.TextView r10, java.lang.CharSequence r11, java.lang.String r12, int r13, int r14) {
            /*
            // Method dump skipped, instructions count: 187
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.openim.b.t.AnonymousClass1.a(android.widget.TextView, java.lang.CharSequence, java.lang.String, int, int):java.lang.CharSequence");
        }
    };
    private EllipsizeTextView.a jHm = new EllipsizeTextView.a() {
        /* class com.tencent.mm.openim.b.t.AnonymousClass2 */

        @Override // com.tencent.mm.ui.base.EllipsizeTextView.a
        public final CharSequence a(TextView textView, CharSequence charSequence, String str, int i2, int i3) {
            AppMethodBeat.i(151235);
            Drawable drawable = textView.getContext().getResources().getDrawable(R.raw.open_im_main_logo);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            CharSequence ellipsize = TextUtils.ellipsize(charSequence, textView.getPaint(), ((float) ((textView.getMeasuredWidth() - textView.getCompoundPaddingRight()) - textView.getCompoundPaddingLeft())) - (((float) drawable.getIntrinsicWidth()) + textView.getPaint().measureText(" ")), TextUtils.TruncateAt.END);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ellipsize);
            spannableStringBuilder.append((CharSequence) " ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), ellipsize.length(), ellipsize.length() + 1, 33);
            AppMethodBeat.o(151235);
            return spannableStringBuilder;
        }
    };

    /* access modifiers changed from: package-private */
    public class b {
        LinkedList<String> jHp;
        LinkedList<String> jHq;

        private b() {
            AppMethodBeat.i(151237);
            this.jHp = new LinkedList<>();
            this.jHq = new LinkedList<>();
            AppMethodBeat.o(151237);
        }

        /* synthetic */ b(t tVar, byte b2) {
            this();
        }
    }

    public t() {
        AppMethodBeat.i(151238);
        s.boN("wcf://openim/");
        c cVar = new c();
        cVar.field_appid = "3552365301";
        cVar.field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        g.aAi();
        ((PluginOpenIM) g.ah(PluginOpenIM.class)).getAppIdInfoStg().get(cVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        if (cVar.systemRowid == -1) {
            Sc("3552365301");
            AppMethodBeat.o(151238);
            return;
        }
        AppMethodBeat.o(151238);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(151239);
        if (qVar.getType() != 453) {
            AppMethodBeat.o(151239);
        } else if (i2 == 0 && i3 == 0) {
            i iVar = (i) qVar;
            b bVar = this.jHk.get(iVar.jHc + iVar.language);
            if (bVar != null) {
                if (!bVar.jHp.isEmpty()) {
                    while (bVar.jHq.size() < 10 && !bVar.jHp.isEmpty()) {
                        bVar.jHq.add(bVar.jHp.removeFirst());
                    }
                    g.aAg().hqi.a(new i(iVar.jHc, iVar.language, bVar.jHq), 0);
                    AppMethodBeat.o(151239);
                    return;
                }
                this.jHk.remove(iVar.jHc + iVar.language);
            }
            AppMethodBeat.o(151239);
        } else {
            AppMethodBeat.o(151239);
        }
    }

    @Override // com.tencent.mm.openim.a.a
    public final CharSequence a(Context context, CharSequence charSequence) {
        AppMethodBeat.i(151240);
        if (Util.isNullOrNil(charSequence)) {
            charSequence = "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.append((CharSequence) " ");
        Drawable drawable = context.getResources().getDrawable(R.raw.open_im_main_logo);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        spannableStringBuilder.setSpan(new ImageSpan(drawable), charSequence.length(), charSequence.length() + 1, 33);
        AppMethodBeat.o(151240);
        return spannableStringBuilder;
    }

    @Override // com.tencent.mm.openim.a.a
    public final SpannableString e(Context context, String str, int i2) {
        AppMethodBeat.i(151241);
        SpannableString e2 = l.e(context, (CharSequence) str, i2);
        AppMethodBeat.o(151241);
        return e2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: android.text.SpannableStringBuilder */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mm.openim.a.a
    public final void a(Context context, TextView textView, CharSequence charSequence, String str, String str2, int i2) {
        SpannableString e2;
        String str3;
        AppMethodBeat.i(151242);
        if (textView instanceof EllipsizeTextView) {
            EllipsizeTextView ellipsizeTextView = (EllipsizeTextView) textView;
            String bN = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).bN(str, str2);
            if (Util.isNullOrNil(bN)) {
                bN = "";
            } else if ("3552365301".equals(str)) {
                bN = " @".concat(String.valueOf(bN));
            }
            ellipsizeTextView.setLayoutCallback(this.jHl);
            ellipsizeTextView.a(charSequence, bN, R.color.a3_, i2);
            AppMethodBeat.o(151242);
            return;
        }
        String bN2 = ((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).bN(str, str2);
        if (!Util.isNullOrNil(bN2)) {
            if ("3552365301".equals(str)) {
                str3 = " @".concat(String.valueOf(bN2));
            } else {
                str3 = bN2;
            }
            SpannableString e3 = l.e(context, charSequence, i2);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) e3);
            SpannableString spannableString = new SpannableString(str3);
            ColorStateList m = com.tencent.mm.cb.a.m(context, R.color.a3_);
            spannableString.setSpan(new TextAppearanceSpan(null, 0, i2, m, m), 0, str3.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            e2 = spannableStringBuilder;
        } else {
            e2 = l.e(context, charSequence, i2);
        }
        textView.setText(e2);
        AppMethodBeat.o(151242);
    }

    @Override // com.tencent.mm.openim.a.a
    public final void a(Context context, TextView textView, CharSequence charSequence) {
        AppMethodBeat.i(151243);
        if (textView instanceof EllipsizeTextView) {
            EllipsizeTextView ellipsizeTextView = (EllipsizeTextView) textView;
            ellipsizeTextView.setLayoutCallback(this.jHm);
            ellipsizeTextView.a(charSequence, " ", -1, (int) textView.getTextSize());
            AppMethodBeat.o(151243);
            return;
        }
        textView.setText(((com.tencent.mm.openim.a.a) g.af(com.tencent.mm.openim.a.a.class)).a(context, charSequence));
        AppMethodBeat.o(151243);
    }

    /* access modifiers changed from: package-private */
    public class a {
        Bitmap bitmap;

        private a() {
        }

        /* synthetic */ a(t tVar, byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.openim.a.a
    public final CharSequence a(Context context, String str, String str2, float f2) {
        AppMethodBeat.i(151244);
        Bitmap RY = RY(str);
        if (RY != null) {
            SpannableString b2 = l.b(context, "  ".concat(String.valueOf(str2)), f2);
            int fromDPToPix = (int) (((float) com.tencent.mm.cb.a.fromDPToPix(context, 2)) + f2);
            ImageSpan imageSpan = new ImageSpan(MMApplicationContext.getContext(), RY);
            imageSpan.getDrawable().setBounds(0, 0, fromDPToPix, fromDPToPix);
            b2.setSpan(imageSpan, 0, 1, 33);
            AppMethodBeat.o(151244);
            return b2;
        }
        AppMethodBeat.o(151244);
        return str2;
    }

    @Override // com.tencent.mm.openim.a.a
    public final Bitmap RY(String str) {
        AppMethodBeat.i(151245);
        final a aVar = new a(this, (byte) 0);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(151245);
            return null;
        }
        c.a aVar2 = new c.a();
        aVar2.jbf = true;
        aVar2.fullPath = "wcf://openim/" + com.tencent.mm.b.g.getMessageDigest(str.getBytes());
        com.tencent.mm.av.q.bcV().a(str, (ImageView) null, aVar2.bdv(), new h() {
            /* class com.tencent.mm.openim.b.t.AnonymousClass3 */

            @Override // com.tencent.mm.av.a.c.h
            public final void b(String str, View view) {
            }

            @Override // com.tencent.mm.av.a.c.h
            public final Bitmap a(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                return null;
            }

            @Override // com.tencent.mm.av.a.c.h
            public final void b(String str, View view, com.tencent.mm.av.a.d.b bVar) {
                AppMethodBeat.i(151236);
                if (bVar.status == 0 && bVar.bitmap != null && !bVar.bitmap.isRecycled()) {
                    aVar.bitmap = bVar.bitmap;
                }
                AppMethodBeat.o(151236);
            }
        });
        Bitmap bitmap = aVar.bitmap;
        AppMethodBeat.o(151245);
        return bitmap;
    }

    @Override // com.tencent.mm.openim.a.a
    public final int RZ(String str) {
        AppMethodBeat.i(151246);
        com.tencent.mm.openim.e.c cVar = new com.tencent.mm.openim.e.c();
        cVar.field_appid = str;
        g.aAi();
        ((PluginOpenIM) g.ah(PluginOpenIM.class)).getAppIdInfoStg().get(cVar, "appid");
        if (cVar.systemRowid == -1) {
            Sc(str);
            AppMethodBeat.o(151246);
            return 0;
        }
        int i2 = cVar.field_appRec.KIp;
        AppMethodBeat.o(151246);
        return i2;
    }

    @Override // com.tencent.mm.openim.a.a
    public final String a(String str, String str2, a.EnumC0497a aVar) {
        AppMethodBeat.i(151247);
        com.tencent.mm.openim.e.c cVar = new com.tencent.mm.openim.e.c();
        cVar.field_appid = str;
        g.aAi();
        ((PluginOpenIM) g.ah(PluginOpenIM.class)).getAppIdInfoStg().get(cVar, "appid");
        if (cVar.systemRowid == -1) {
            Sc(str);
            AppMethodBeat.o(151247);
            return null;
        }
        String a2 = a(cVar.field_acctTypeId, str2, aVar, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
        if (a2 == null) {
            a2 = a(cVar.field_acctTypeId, str2, aVar, LocaleUtil.ENGLISH);
        }
        AppMethodBeat.o(151247);
        return a2;
    }

    @Override // com.tencent.mm.openim.a.a
    public final String b(String str, String str2, a.EnumC0497a aVar) {
        AppMethodBeat.i(151248);
        String a2 = a(str, str2, aVar, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
        if (a2 == null) {
            a2 = a(str, str2, aVar, LocaleUtil.ENGLISH);
        }
        AppMethodBeat.o(151248);
        return a2;
    }

    private static String a(String str, String str2, a.EnumC0497a aVar, String str3) {
        AppMethodBeat.i(151249);
        com.tencent.mm.openim.e.a aVar2 = new com.tencent.mm.openim.e.a();
        aVar2.field_acctTypeId = str;
        aVar2.field_language = str3;
        g.aAi();
        ((PluginOpenIM) g.ah(PluginOpenIM.class)).getAccTypeInfoStg().get(aVar2, "acctTypeId", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        if (aVar2.systemRowid == -1) {
            AppMethodBeat.o(151249);
            return null;
        } else if (aVar == a.EnumC0497a.TYPE_WORDING) {
            Iterator<cws> it = aVar2.field_accTypeRec.KEp.iterator();
            while (it.hasNext()) {
                cws next = it.next();
                if (str2.equals(next.key)) {
                    String str4 = next.dQx;
                    AppMethodBeat.o(151249);
                    return str4;
                }
            }
            AppMethodBeat.o(151249);
            return null;
        } else {
            Iterator<cwr> it2 = aVar2.field_accTypeRec.duo.iterator();
            while (it2.hasNext()) {
                cwr next2 = it2.next();
                if (str2.equals(next2.key)) {
                    String str5 = next2.url;
                    AppMethodBeat.o(151249);
                    return str5;
                }
            }
            AppMethodBeat.o(151249);
            return null;
        }
    }

    @Override // com.tencent.mm.openim.a.a
    public final String c(String str, String str2, a.EnumC0497a aVar) {
        AppMethodBeat.i(151250);
        String b2 = b(str, str2, aVar, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
        if (b2 == null) {
            b2 = b(str, str2, aVar, LocaleUtil.ENGLISH);
        }
        AppMethodBeat.o(151250);
        return b2;
    }

    private String b(String str, String str2, a.EnumC0497a aVar, String str3) {
        AppMethodBeat.i(151251);
        com.tencent.mm.openim.e.c cVar = new com.tencent.mm.openim.e.c();
        cVar.field_appid = str;
        cVar.field_language = str3;
        g.aAi();
        ((PluginOpenIM) g.ah(PluginOpenIM.class)).getAppIdInfoStg().get(cVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        if (cVar.systemRowid == -1) {
            bO(str, str3);
            AppMethodBeat.o(151251);
            return null;
        } else if (aVar == a.EnumC0497a.TYPE_WORDING) {
            Iterator<cws> it = cVar.field_appRec.KEp.iterator();
            while (it.hasNext()) {
                cws next = it.next();
                if (str2.equals(next.key)) {
                    String str4 = next.dQx;
                    AppMethodBeat.o(151251);
                    return str4;
                }
            }
            AppMethodBeat.o(151251);
            return null;
        } else {
            Iterator<cwr> it2 = cVar.field_appRec.duo.iterator();
            while (it2.hasNext()) {
                cwr next2 = it2.next();
                if (str2.equals(next2.key)) {
                    String str5 = next2.url;
                    AppMethodBeat.o(151251);
                    return str5;
                }
            }
            AppMethodBeat.o(151251);
            return null;
        }
    }

    @Override // com.tencent.mm.openim.a.a
    public final String bN(String str, String str2) {
        AppMethodBeat.i(151252);
        String t = t(str, str2, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
        if (t == null) {
            t = t(str, str2, LocaleUtil.ENGLISH);
        }
        AppMethodBeat.o(151252);
        return t;
    }

    @Override // com.tencent.mm.openim.a.a
    public final void bkB() {
        AppMethodBeat.i(151253);
        ((PluginOpenIM) g.ah(PluginOpenIM.class)).getAppIdInfoStg().iFy.delete("OpenIMAppIdInfo", null, null);
        ((PluginOpenIM) g.ah(PluginOpenIM.class)).getAccTypeInfoStg().iFy.delete("OpenIMAccTypeInfo", null, null);
        ((PluginOpenIM) g.ah(PluginOpenIM.class)).getWordingInfoStg().iFy.delete("OpenIMWordingInfo", null, null);
        AppMethodBeat.o(151253);
    }

    @Override // com.tencent.mm.openim.a.a
    public final TextAppearanceSpan f(Context context, String str, int i2) {
        AppMethodBeat.i(151254);
        MMTextAppearanceSpan mMTextAppearanceSpan = null;
        if ("3552365301".equals(str)) {
            ColorStateList m = com.tencent.mm.cb.a.m(context, R.color.BW_0_Alpha_0_5);
            mMTextAppearanceSpan = new MMTextAppearanceSpan(i2, m, m);
        }
        AppMethodBeat.o(151254);
        return mMTextAppearanceSpan;
    }

    private String t(String str, String str2, String str3) {
        AppMethodBeat.i(151255);
        e eVar = new e();
        eVar.field_appid = str;
        eVar.field_language = str3;
        eVar.field_wordingId = str2;
        g.aAi();
        ((PluginOpenIM) g.ah(PluginOpenIM.class)).getWordingInfoStg().get(eVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "wordingId");
        if (eVar.systemRowid == -1) {
            s(str, str3, str2);
            AppMethodBeat.o(151255);
            return null;
        }
        String str4 = eVar.field_wording;
        AppMethodBeat.o(151255);
        return str4;
    }

    private void Sc(String str) {
        AppMethodBeat.i(151256);
        bO(str, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
        AppMethodBeat.o(151256);
    }

    private void bO(String str, String str2) {
        AppMethodBeat.i(151257);
        s(str, str2, "");
        AppMethodBeat.o(151257);
    }

    @Override // com.tencent.mm.openim.a.a
    public final void s(String str, String str2, String str3) {
        AppMethodBeat.i(151258);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(151258);
            return;
        }
        Log.i("MicroMsg.Openim.OpenImResourceMgr", "try checkDoSceneGetRec openimAppId %s language %s wordingid %s", str, str2, str3);
        if (!this.jHk.containsKey(str + str2)) {
            b bVar = new b(this, (byte) 0);
            if (!Util.isNullOrNil(str3)) {
                bVar.jHq.add(str3);
            }
            this.jHk.put(str + str2, bVar);
            g.aAg().hqi.a(new i(str, str2, bVar.jHq), 0);
        }
        if (Util.isNullOrNil(str3)) {
            AppMethodBeat.o(151258);
            return;
        }
        b bVar2 = this.jHk.get(str + str2);
        if (bVar2.jHp.contains(str3) || bVar2.jHq.contains(str3)) {
            AppMethodBeat.o(151258);
            return;
        }
        bVar2.jHp.add(str3);
        AppMethodBeat.o(151258);
    }

    @Override // com.tencent.mm.openim.a.a
    public final void bM(String str, String str2) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(151259);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(151259);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        com.tencent.mm.openim.e.c cVar = new com.tencent.mm.openim.e.c();
        cVar.field_appid = str;
        cVar.field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
        g.aAi();
        ((PluginOpenIM) g.ah(PluginOpenIM.class)).getAppIdInfoStg().get(cVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE);
        stringBuffer.append(String.format("openIMAppIdinfo.field_updateTime %s | ", Long.valueOf(cVar.field_updateTime)));
        if (cVar.systemRowid == -1 || Util.secondsToNow(cVar.field_updateTime) > 172800) {
            z = true;
        } else {
            z = false;
        }
        if (!z && !Util.isNullOrNil(str2)) {
            e eVar = new e();
            eVar.field_appid = str;
            eVar.field_language = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
            eVar.field_wordingId = str2;
            g.aAi();
            ((PluginOpenIM) g.ah(PluginOpenIM.class)).getWordingInfoStg().get(eVar, "appid", FFmpegMetadataRetriever.METADATA_KEY_LANGUAGE, "wordingId");
            if (eVar.systemRowid == -1 || Util.secondsToNow(eVar.field_updateTime) > 172800) {
                z2 = true;
            } else {
                z2 = z;
            }
            stringBuffer.append(String.format("wordingInfo.field_updateTime %s | ", Long.valueOf(eVar.field_updateTime)));
            z = z2;
        }
        Log.i("MicroMsg.Openim.OpenImResourceMgr", "checkRecUpdate openimAppId %s wordingId %s needUpdate %s logBuffer: %s", str, str2, Boolean.valueOf(z), stringBuffer.toString());
        if (z) {
            s(str, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), str2);
        }
        AppMethodBeat.o(151259);
    }
}
