package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.b.f;
import com.tencent.mm.compatible.util.o;
import com.tencent.mm.memory.a.c;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.pluginsdk.ui.applet.z;
import com.tencent.mm.pluginsdk.ui.span.f;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* access modifiers changed from: package-private */
public final class r {
    private static final f<String, SpannableString> KrC = new c(500);
    private static Class<?>[] Ksc = {com.tencent.mm.ui.widget.a.class, p.class, ForegroundColorSpan.class};
    private ArrayList<u> KrD;
    private ArrayList<a> KrE;
    private ArrayList<z> KrF;
    boolean KrG;
    boolean KrH;
    boolean KrI;
    boolean KrJ;
    boolean KrK;
    boolean KrL;
    boolean KrM;
    boolean KrN;
    boolean KrO;
    boolean KrP;
    boolean KrQ;
    boolean KrR;
    boolean KrS;
    boolean KrT;
    boolean KrU;
    boolean KrV;
    boolean KrW;
    boolean KrX;
    int KrY;
    private int KrZ;
    boolean Ksa;
    Object Ksb;
    private TextView Ws;
    int gwE;
    a mAdTagClickCallback;
    int mAdTagClickScene;
    private Context mContext;
    String mSessionId;

    static {
        AppMethodBeat.i(152370);
        AppMethodBeat.o(152370);
    }

    public r(Context context) {
        AppMethodBeat.i(152345);
        this.KrD = new ArrayList<>();
        this.KrE = new ArrayList<>();
        this.KrF = new ArrayList<>();
        this.Ws = null;
        this.KrG = false;
        this.KrH = false;
        this.KrI = true;
        this.KrJ = false;
        this.KrK = false;
        this.KrL = true;
        this.KrM = true;
        this.KrN = false;
        this.KrO = false;
        this.KrP = false;
        this.KrQ = false;
        this.KrR = false;
        this.KrS = false;
        this.KrT = false;
        this.KrU = true;
        this.KrV = false;
        this.KrW = false;
        this.KrX = false;
        this.KrY = 0;
        this.KrZ = 0;
        this.mContext = null;
        this.Ksa = false;
        this.gwE = 0;
        this.KrD = new ArrayList<>();
        this.KrE = new ArrayList<>();
        this.KrF = new ArrayList<>();
        this.mContext = context;
        AppMethodBeat.o(152345);
    }

    public final r C(TextView textView) {
        AppMethodBeat.i(152346);
        this.Ws = textView;
        if (textView != null) {
            this.mContext = this.Ws.getContext();
        }
        AppMethodBeat.o(152346);
        return this;
    }

    private String V(CharSequence charSequence) {
        AppMethodBeat.i(152347);
        String str = ((Object) charSequence) + "@" + this.KrZ + "@" + this.KrG + "@" + this.KrH + "@" + this.KrK + "@" + this.KrL + "@" + this.KrM + "@" + this.KrY + "@" + this.Ksa + "@" + this.KrR + "@" + this.KrS + "@" + this.KrT + "@" + this.KrQ;
        AppMethodBeat.o(152347);
        return str;
    }

    public final SpannableString b(CharSequence charSequence, int i2, boolean z) {
        int textSize;
        SpannableString spannableString;
        AppMethodBeat.i(152348);
        if (charSequence == null) {
            SpannableString spannableString2 = new SpannableString("");
            AppMethodBeat.o(152348);
            return spannableString2;
        }
        this.KrZ = i2;
        String V = V(charSequence);
        if (!z || (spannableString = KrC.get(V)) == null) {
            SpannableString W = W(charSequence);
            if (this.Ksa) {
                Iterator<u> it = this.KrD.iterator();
                while (it.hasNext()) {
                    u next = it.next();
                    next.mSessionId = this.mSessionId;
                    next.fromScene = this.gwE;
                    if (Util.isNullOrNil(next.url)) {
                        W.setSpan(new ForegroundColorSpan(next.linkColor), next.start, next.end, 33);
                    } else if (next.start <= W.length() && next.end <= W.length()) {
                        W.setSpan(new p(this.KrY, next), next.start, next.end, 33);
                    }
                }
            }
            Iterator<z> it2 = this.KrF.iterator();
            while (it2.hasNext()) {
                z next2 = it2.next();
                if (next2.start <= W.length() && next2.end <= W.length()) {
                    Drawable drawable = this.mContext.getResources().getDrawable(next2.id);
                    if (next2.width <= 0 || next2.height <= 0) {
                        if (this.Ws == null) {
                            textSize = (int) (((float) this.KrZ) * 1.3f);
                        } else {
                            textSize = (int) (this.Ws.getTextSize() * 1.3f);
                        }
                        drawable.setBounds(0, 0, textSize, textSize);
                    } else {
                        drawable.setBounds(0, 0, com.tencent.mm.cb.a.fromDPToPix(this.mContext, next2.width), com.tencent.mm.cb.a.fromDPToPix(this.mContext, next2.height));
                    }
                    com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(drawable, 1);
                    aVar.QBM = com.tencent.mm.cb.a.fromDPToPix(this.mContext, 2);
                    W.setSpan(aVar, next2.start, next2.start + 1, 18);
                }
            }
            g(W);
            a(W);
            if (z) {
                KrC.x(V, new SpannableString(W));
            }
            AppMethodBeat.o(152348);
            return W;
        }
        f(spannableString);
        g(spannableString);
        a(spannableString);
        for (p pVar : (p[]) spannableString.getSpans(0, spannableString.length(), p.class)) {
            u hrefInfo = pVar.getHrefInfo();
            if (!(hrefInfo == null || hrefInfo.type != 60 || this.Ksb == null)) {
                hrefInfo.data = this.Ksb;
            }
        }
        AppMethodBeat.o(152348);
        return spannableString;
    }

    private static void f(Spannable spannable) {
        boolean z;
        AppMethodBeat.i(152349);
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        for (Object obj : spans) {
            int i2 = 0;
            while (true) {
                if (i2 >= Ksc.length) {
                    z = false;
                    break;
                } else if (Ksc[i2].isInstance(obj)) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                spannable.removeSpan(obj);
            }
        }
        AppMethodBeat.o(152349);
    }

    private SpannableString W(CharSequence charSequence) {
        SpannableString spannableString;
        AppMethodBeat.i(152350);
        this.KrD = new ArrayList<>();
        if (this.KrZ <= 0) {
            if (this.Ws != null) {
                this.KrZ = (int) this.Ws.getTextSize();
            } else {
                this.KrZ = com.tencent.mm.cb.a.aG(this.mContext, R.dimen.is);
            }
        }
        if (this.KrD == null) {
            this.KrD = new ArrayList<>();
        }
        if (this.KrE == null) {
            this.KrE = new ArrayList<>();
        }
        this.KrD.clear();
        this.KrE.clear();
        if (o.y(charSequence) && this.KrU && f.a.KqF != null && (f.a.KqF.N(charSequence) || f.a.KqF.M(charSequence))) {
            charSequence = charSequence.toString().replace("\n", "                                                                                                                                                                                                                                                                                                                        ");
        }
        if (this.KrG) {
            if (charSequence.toString().contains("data-miniprogram-appid")) {
                charSequence = Z(charSequence);
            } else {
                charSequence = Y(charSequence);
            }
        }
        if (this.KrR) {
            charSequence = X(charSequence);
        }
        if (this.KrT) {
            charSequence = b(charSequence, this.KrX);
        }
        if (!this.KrU || f.a.KqF == null) {
            spannableString = charSequence;
        } else {
            spannableString = f.a.KqF.b(this.mContext, charSequence, this.KrZ);
        }
        if (this.KrI) {
            aa(spannableString);
        }
        if (spannableString instanceof Spannable) {
            SpannableString spannableString2 = (SpannableString) spannableString;
            AppMethodBeat.o(152350);
            return spannableString2;
        }
        SpannableString spannableString3 = new SpannableString(spannableString);
        AppMethodBeat.o(152350);
        return spannableString3;
    }

    private CharSequence X(CharSequence charSequence) {
        String replace;
        AppMethodBeat.i(152351);
        Matcher matcher = k.a.KqN.matcher(charSequence.toString());
        while (matcher.find()) {
            if (this.KrS) {
                replace = charSequence.toString().replace(matcher.group(0), "");
            } else {
                replace = charSequence.toString().replace(matcher.group(0), "  ");
                String group = matcher.group(1);
                int start = matcher.start();
                int i2 = start + 2;
                int identifier = this.mContext.getResources().getIdentifier(group.toLowerCase(), "drawable", this.mContext.getPackageName());
                if (identifier != 0) {
                    z zVar = new z(start, i2, identifier);
                    if (!Util.isNullOrNil(group) && "original_label".equals(group)) {
                        zVar.height = 15;
                        zVar.width = 35;
                    }
                    this.KrF.add(zVar);
                } else {
                    Log.w("MicroMsg.SpanProcessor", "dz[parseImgSpan:error drawable name %s]", group);
                }
            }
            matcher = k.a.KqI.matcher(replace);
            charSequence = replace;
        }
        AppMethodBeat.o(152351);
        return charSequence;
    }

    private CharSequence b(CharSequence charSequence, boolean z) {
        int color;
        int i2;
        AppMethodBeat.i(152352);
        boolean z2 = false;
        String str = charSequence;
        Matcher matcher = k.a.KqL.matcher(charSequence);
        while (matcher.find()) {
            String group = matcher.group(0);
            String group2 = matcher.group(1);
            String group3 = matcher.group(2);
            String group4 = matcher.group(3);
            if (group4 == null) {
                group4 = "";
            }
            String replace = str.toString().replace(group, group4);
            int start = matcher.start(0);
            int length = group4.length() + start;
            if (start < 0 || length > charSequence.length()) {
                Log.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                str = replace;
            } else {
                try {
                    i2 = Color.parseColor(group2);
                } catch (Exception e2) {
                    Context context = MMApplicationContext.getContext();
                    int identifier = context.getResources().getIdentifier(group2, "color", context.getPackageName());
                    if (identifier <= 0) {
                        color = 0;
                    } else {
                        color = MMApplicationContext.getContext().getResources().getColor(identifier);
                    }
                    Log.w("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error at color : %s, resId : %s]", group2, Integer.valueOf(identifier));
                    i2 = color;
                }
                if (Util.isNullOrNil(group3)) {
                    u uVar = new u(start, length);
                    uVar.linkColor = i2;
                    this.KrD.add(uVar);
                    this.KrE.add(new a(start, length));
                } else {
                    u a2 = b.a(this.mContext, group3, start, length, i2, i2 & -1711276033);
                    if (a2 != null) {
                        if (this.Ksb != null) {
                            a2.data = this.Ksb;
                        }
                        this.KrD.add(a2);
                        this.KrE.add(new a(start, length));
                    }
                }
                z2 = true;
                str = replace;
                matcher = k.a.KqL.matcher(replace);
            }
        }
        if (!z2) {
            Matcher matcher2 = k.a.KqM.matcher(charSequence);
            while (matcher2.find()) {
                String group5 = matcher2.group(0);
                String group6 = matcher2.group(1);
                String group7 = matcher2.group(2);
                if (group7 == null) {
                    group7 = "";
                }
                if (group6.length() >= 2) {
                    str = str.toString().replace(group5, group7);
                    int start2 = matcher2.start(0);
                    int length2 = group7.length() + start2;
                    if (start2 < 0 || length2 > charSequence.length()) {
                        Log.e("MicroMsg.SpanProcessor", "dz[parseWCCustomLink error: start:%d, end:%d, source.length:%d]", Integer.valueOf(start2), Integer.valueOf(length2), Integer.valueOf(charSequence.length()));
                    } else {
                        if (!aN(group6, start2, length2) && z) {
                            u uVar2 = new u(group6, 2147483646, null);
                            if (this.Ksb != null) {
                                uVar2.data = this.Ksb;
                            }
                            uVar2.start = start2;
                            uVar2.end = length2;
                            if (!a(this.KrE, new a(start2, length2))) {
                                this.KrD.add(uVar2);
                                this.KrE.add(new a(start2, length2));
                            }
                        }
                        matcher2 = k.a.KqL.matcher(str);
                    }
                }
            }
        }
        AppMethodBeat.o(152352);
        return str;
    }

    private CharSequence Y(CharSequence charSequence) {
        Matcher matcher;
        AppMethodBeat.i(152353);
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() < 1500) {
            matcher = k.a.KqI.matcher(charSequence2);
        } else {
            matcher = k.a.KqH.matcher(charSequence2);
        }
        while (matcher.find()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            if (group.length() >= 2) {
                StringBuilder sb = new StringBuilder();
                if (matcher.start(0) > 0) {
                    sb.append(charSequence2.substring(0, matcher.start(0)));
                }
                sb.append(group2);
                if (matcher.end(0) < charSequence2.length()) {
                    sb.append(charSequence2.substring(matcher.end(0), charSequence2.length()));
                }
                charSequence2 = sb.toString();
                int start = matcher.start(0);
                int length = group2.length() + start;
                if (start < 0 || length > charSequence.length()) {
                    Log.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", Integer.valueOf(start), Integer.valueOf(length), Integer.valueOf(charSequence.length()));
                } else {
                    aN(group, start, length);
                    if (charSequence2.length() < 1500) {
                        matcher = k.a.KqI.matcher(charSequence2);
                    } else {
                        matcher = k.a.KqH.matcher(charSequence2);
                    }
                }
            }
        }
        AppMethodBeat.o(152353);
        return charSequence2;
    }

    private CharSequence Z(CharSequence charSequence) {
        String str;
        Matcher matcher;
        boolean z;
        z zVar;
        String str2;
        AppMethodBeat.i(152354);
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() < 1500) {
            matcher = k.a.KqK.matcher(charSequence2);
            str = charSequence2;
        } else {
            matcher = k.a.KqJ.matcher(charSequence2);
            str = charSequence2;
        }
        while (matcher.find()) {
            String group = matcher.group(0);
            String group2 = matcher.group(1);
            String group3 = matcher.group(2);
            Map<String, String> parseXml = XmlParser.parseXml(group.replace(group2, " ").replace(group3, " "), "a", null);
            if (parseXml == null) {
                Log.e("MicroMsg.SpanProcessor", "XmlParser parse return null, so continue");
            } else {
                String str3 = parseXml.get(".a.$data-miniprogram-appid");
                String str4 = parseXml.get(".a.$data-miniprogram-path");
                boolean z2 = !Util.isNullOrNil(group2);
                if (!Util.isNullOrNil(str3)) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z2 || z) {
                    if (!z) {
                        Log.e("MicroMsg.SpanProcessor", "url && appId is null, continue");
                    } else if (this.KrS) {
                        str2 = str.toString().replace(group, group3);
                        int start = matcher.start(0);
                        u uVar = new u(group2, 45, null);
                        uVar.start = start;
                        uVar.end = group3.length() + start;
                        this.KrD.add(uVar);
                    } else {
                        String concat = "    ".concat(String.valueOf(group3));
                        String replace = str.toString().replace(group, concat);
                        int start2 = matcher.start(0);
                        int length = start2 + concat.length();
                        if (ao.isDarkMode()) {
                            zVar = new z(start2 + 1, start2 + 3, R.raw.spannable_app_brand_link_logo_dark);
                        } else {
                            zVar = new z(start2 + 1, start2 + 3, R.raw.spannable_app_brand_link_logo);
                        }
                        this.KrF.add(zVar);
                        u uVar2 = new u(str3, 45, str4);
                        uVar2.start = start2 + 4;
                        uVar2.end = length;
                        this.KrD.add(uVar2);
                        str2 = replace;
                    }
                } else if (group2.length() >= 2) {
                    String replace2 = str.toString().replace(group, group3);
                    int start3 = matcher.start(0);
                    int length2 = group3.length() + start3;
                    if (start3 < 0 || length2 > charSequence.length()) {
                        Log.e("MicroMsg.SpanProcessor", "parseHref error, start:%d, end:%d, source.length:%d", Integer.valueOf(start3), Integer.valueOf(length2), Integer.valueOf(charSequence.length()));
                        str = replace2;
                    } else {
                        aN(group2, start3, length2);
                        str2 = replace2;
                    }
                }
                if (str2.length() < 1500) {
                    matcher = k.a.KqK.matcher(str2);
                    str = str2;
                } else {
                    matcher = k.a.KqJ.matcher(str2);
                    str = str2;
                }
            }
        }
        AppMethodBeat.o(152354);
        return str;
    }

    private void aa(CharSequence charSequence) {
        AppMethodBeat.i(152355);
        if (this.KrL) {
            this.KrE.addAll(ab(charSequence));
        }
        if (this.KrH) {
            this.KrE.addAll(ad(charSequence));
        }
        if (this.KrJ) {
            this.KrE.addAll(ae(charSequence));
        }
        if (this.KrP) {
            this.KrE.addAll(ak(charSequence));
        }
        if (this.KrM) {
            this.KrE.addAll(af(charSequence));
        }
        if (this.KrN) {
            this.KrE.addAll(ag(charSequence));
        }
        if (this.KrQ) {
            this.KrE.addAll(ah(charSequence));
        }
        if (this.KrK) {
            this.KrE.addAll(ai(charSequence));
        }
        if (this.KrO) {
            this.KrE.addAll(aj(charSequence));
        }
        if (this.KrW) {
            this.KrE.addAll(ac(charSequence));
        }
        if (this.KrV) {
            this.KrE.addAll(al(charSequence));
        }
        AppMethodBeat.o(152355);
    }

    private ArrayList<a> ab(CharSequence charSequence) {
        int i2 = 2000;
        AppMethodBeat.i(152356);
        ArrayList<a> arrayList = new ArrayList<>();
        Pattern pattern = k.a.KqR;
        if (charSequence.length() <= 2000) {
            i2 = charSequence.length();
        }
        Matcher matcher = pattern.matcher(charSequence.subSequence(0, i2));
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            u uVar = new u(matcher.group(), 24, null);
            uVar.start = start;
            uVar.end = end;
            if (!a(this.KrE, new a(start, end))) {
                this.KrD.add(uVar);
                arrayList.add(new a(start, end));
            }
        }
        AppMethodBeat.o(152356);
        return arrayList;
    }

    private ArrayList<a> ac(CharSequence charSequence) {
        int i2 = 2000;
        AppMethodBeat.i(152357);
        ArrayList<a> arrayList = new ArrayList<>();
        Pattern pattern = k.a.KqS;
        if (charSequence.length() <= 2000) {
            i2 = charSequence.length();
        }
        Matcher matcher = pattern.matcher(charSequence.subSequence(0, i2));
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            u uVar = new u(matcher.group(), 48, null);
            uVar.start = start;
            uVar.end = end;
            if (!a(this.KrE, new a(start, end))) {
                this.KrD.add(uVar);
                arrayList.add(new a(start, end));
            }
        }
        AppMethodBeat.o(152357);
        return arrayList;
    }

    private ArrayList<a> ad(CharSequence charSequence) {
        Matcher matcher;
        char charAt;
        AppMethodBeat.i(152358);
        ArrayList<a> arrayList = new ArrayList<>();
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() > 500) {
            matcher = k.a.KqQ.matcher(charSequence2.toLowerCase());
        } else {
            matcher = k.a.KqP.matcher(charSequence2.toLowerCase());
        }
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(this.KrE, new a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                if (end >= charSequence2.length() || 'a' > (charAt = charSequence2.charAt(end)) || charAt > 'z') {
                    u uVar = new u(charSequence2.substring(start, end), 1, this.Ksb);
                    uVar.start = start;
                    uVar.end = end;
                    this.KrD.add(uVar);
                    arrayList.add(new a(start, end));
                }
            }
        }
        AppMethodBeat.o(152358);
        return arrayList;
    }

    private ArrayList<a> ae(CharSequence charSequence) {
        AppMethodBeat.i(152359);
        ArrayList<a> arrayList = new ArrayList<>();
        String charSequence2 = charSequence.toString();
        if (charSequence2.length() > 200) {
            AppMethodBeat.o(152359);
        } else {
            Matcher matcher = k.a.KqX.matcher(charSequence2);
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                if (!a(this.KrE, new a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                    u uVar = new u(charSequence2.substring(start, end), 44, this.Ksb);
                    uVar.start = start;
                    uVar.end = end;
                    this.KrD.add(uVar);
                    arrayList.add(new a(start, end));
                }
            }
            AppMethodBeat.o(152359);
        }
        return arrayList;
    }

    private ArrayList<a> af(CharSequence charSequence) {
        AppMethodBeat.i(152360);
        ArrayList<a> arrayList = new ArrayList<>();
        String charSequence2 = charSequence.toString();
        Matcher matcher = k.a.KqU.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (!a(this.KrE, new a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                u uVar = new u(charSequence2.substring(start, end), 28, null);
                uVar.start = start;
                uVar.end = end;
                this.KrD.add(uVar);
                arrayList.add(new a(start, end));
            }
        }
        AppMethodBeat.o(152360);
        return arrayList;
    }

    private ArrayList<a> ag(CharSequence charSequence) {
        AppMethodBeat.i(152361);
        ArrayList<a> arrayList = new ArrayList<>();
        String charSequence2 = charSequence.toString();
        Matcher matcher = k.a.KqY.matcher(charSequence);
        while (matcher.find()) {
            if (c.KqA.bfg(matcher.group())) {
                int start = matcher.start();
                int end = matcher.end();
                if (!a(this.KrE, new a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                    u uVar = new u(charSequence2.substring(start, end), 50, this.Ksb);
                    uVar.start = start;
                    uVar.end = end;
                    this.KrD.add(uVar);
                    arrayList.add(new a(start, end));
                }
            }
        }
        AppMethodBeat.o(152361);
        return arrayList;
    }

    private ArrayList<a> ah(CharSequence charSequence) {
        AppMethodBeat.i(223868);
        ArrayList<a> arrayList = new ArrayList<>();
        String charSequence2 = charSequence.toString();
        Matcher matcher = k.a.Krb.matcher(charSequence);
        while (matcher.find()) {
            matcher.group();
            int start = matcher.start();
            int end = matcher.end();
            if (!a(this.KrE, new a(start, end)) && start >= 0 && end <= charSequence2.length()) {
                u uVar = new u(charSequence2.substring(start, end), 58, this.Ksb);
                uVar.start = start;
                uVar.end = end;
                this.KrD.add(uVar);
                arrayList.add(new a(start, end));
            }
        }
        AppMethodBeat.o(223868);
        return arrayList;
    }

    private ArrayList<a> ai(CharSequence charSequence) {
        AppMethodBeat.i(152362);
        ArrayList<a> arrayList = new ArrayList<>();
        Matcher matcher = k.a.KqT.matcher(charSequence);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            String group = matcher.group();
            int i2 = end - start;
            if (group.startsWith("+")) {
                i2--;
            }
            if ((!(i2 == 6 || i2 == 5) || "+12306+12110+12395+12121+12117+12119+95555+95566+95533+95588+95558+95599+95568+95595+95559+95508+95528+95501+95577+95561+10086+10010+10000+17951+17911+17900+118114+116114+950718+95598+12318+12315+12358+12365+12310+12369+12333+12366+95518+95519+95511+95500+95522+95567+95017".contains(group)) && i2 < 100 && !a(this.KrE, new a(start, end))) {
                u uVar = new u(group, 25, this.Ksb);
                uVar.start = start;
                uVar.end = end;
                this.KrD.add(uVar);
                arrayList.add(new a(start, end));
            }
        }
        AppMethodBeat.o(152362);
        return arrayList;
    }

    private ArrayList<a> aj(CharSequence charSequence) {
        AppMethodBeat.i(152363);
        ArrayList<a> arrayList = new ArrayList<>();
        Iterator<u> it = b.cn(this.mContext, charSequence.toString()).iterator();
        while (it.hasNext()) {
            u next = it.next();
            a aVar = new a(next.start, next.end);
            if (!a(this.KrE, aVar)) {
                this.KrD.add(next);
                arrayList.add(aVar);
            }
        }
        AppMethodBeat.o(152363);
        return arrayList;
    }

    private ArrayList<a> ak(CharSequence charSequence) {
        AppMethodBeat.i(152364);
        ArrayList<a> arrayList = new ArrayList<>();
        String charSequence2 = charSequence.toString();
        Matcher matcher = k.a.KqW.matcher(charSequence2);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            a aVar = new a(start, end);
            if (!a(this.KrE, aVar) && start >= 0 && end <= charSequence2.length()) {
                u uVar = new u(charSequence2.substring(start, end), 30, null);
                uVar.start = start;
                uVar.end = end;
                this.KrD.add(uVar);
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() <= 0) {
            Matcher matcher2 = k.a.KqV.matcher(charSequence2);
            while (matcher2.find()) {
                int start2 = matcher2.start();
                int end2 = matcher2.end();
                a aVar2 = new a(start2, end2);
                if (!a(this.KrE, aVar2) && start2 >= 0 && end2 <= charSequence2.length()) {
                    u uVar2 = new u(charSequence2.substring(start2, end2), 30, null);
                    uVar2.start = start2;
                    uVar2.end = end2;
                    this.KrD.add(uVar2);
                    arrayList.add(aVar2);
                }
            }
        }
        AppMethodBeat.o(152364);
        return arrayList;
    }

    private ArrayList<a> al(CharSequence charSequence) {
        AppMethodBeat.i(223869);
        ArrayList<a> arrayList = new ArrayList<>();
        String charSequence2 = charSequence.toString();
        Matcher matcher = k.a.Krc.matcher(charSequence2);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            a aVar = new a(start, end);
            if (!a(this.KrE, aVar) && start >= 0 && end <= charSequence2.length()) {
                u uVar = new u(charSequence2.substring(start, end), 60, null);
                uVar.start = start;
                uVar.data = this.Ksb;
                uVar.end = end;
                this.KrD.add(uVar);
                arrayList.add(aVar);
            }
        }
        AppMethodBeat.o(223869);
        return arrayList;
    }

    private boolean aN(String str, int i2, int i3) {
        AppMethodBeat.i(152365);
        u a2 = b.a(this.mContext, str, i2, i3);
        if (a2 != null) {
            if (this.Ksb != null) {
                a2.data = this.Ksb;
            }
            this.KrD.add(a2);
            this.KrE.add(new a(i2, i3));
            AppMethodBeat.o(152365);
            return true;
        }
        AppMethodBeat.o(152365);
        return false;
    }

    /* access modifiers changed from: package-private */
    public class a {
        private int end;
        private int start;

        a(int i2, int i3) {
            this.start = i2;
            this.end = i3;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(a aVar) {
            return this.end > aVar.start && aVar.end > this.start;
        }
    }

    private static boolean a(ArrayList<a> arrayList, a aVar) {
        AppMethodBeat.i(152366);
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            if (it.next().a(aVar)) {
                AppMethodBeat.o(152366);
                return true;
            }
        }
        AppMethodBeat.o(152366);
        return false;
    }

    private void g(Spannable spannable) {
        AppMethodBeat.i(152367);
        if (this.Ws != null && !Util.isNullOrNil(spannable.toString())) {
            if (ac.jPd) {
                this.Ws.setText(spannable, TextView.BufferType.SPANNABLE);
                AppMethodBeat.o(152367);
                return;
            }
            this.Ws.setText(spannable);
        }
        AppMethodBeat.o(152367);
    }

    private void a(SpannableString spannableString) {
        AppMethodBeat.i(152368);
        if (this.Ws != null) {
            o oVar = new o();
            oVar.mSessionId = this.mSessionId;
            oVar.setAdTagClickCallback(this.mAdTagClickCallback, 0);
            oVar.mAdTagClickScene = this.mAdTagClickScene;
            this.Ws.setOnTouchListener(oVar);
            AppMethodBeat.o(152368);
            return;
        }
        if (spannableString != null) {
            p[] pVarArr = (p[]) spannableString.getSpans(0, spannableString.length(), p.class);
            if (!(pVarArr == null || pVarArr.length <= 0 || this.mSessionId == null)) {
                for (p pVar : pVarArr) {
                    pVar.setSessionId(this.mSessionId);
                }
            }
            if (pVarArr != null && pVarArr.length > 0) {
                for (p pVar2 : pVarArr) {
                    pVar2.setAdTagClickCallback(this.mAdTagClickCallback, 0);
                    pVar2.setAdTagClickScene(this.mAdTagClickScene);
                }
            }
        }
        AppMethodBeat.o(152368);
    }

    public static void clearCache() {
        AppMethodBeat.i(152369);
        KrC.clear();
        AppMethodBeat.o(152369);
    }
}
