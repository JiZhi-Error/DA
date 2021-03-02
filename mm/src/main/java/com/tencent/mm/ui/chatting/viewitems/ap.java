package com.tencent.mm.ui.chatting.viewitems;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class ap {
    private static final LinearLayout.LayoutParams PNy = new LinearLayout.LayoutParams(-1, -2);

    static /* synthetic */ int hh(String str, int i2) {
        AppMethodBeat.i(37278);
        int hg = hg(str, i2);
        AppMethodBeat.o(37278);
        return hg;
    }

    public static boolean a(LinearLayout linearLayout, Map<String, String> map) {
        int i2;
        AppMethodBeat.i(37271);
        if (linearLayout == null) {
            Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle fail, digestLl is null");
            AppMethodBeat.o(37271);
            return false;
        }
        String str = map.get(".msg.appmsg.mmreader.category.item.digest");
        if (Util.isNullOrNil(str)) {
            Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle, digest is null");
            linearLayout.setVisibility(8);
            AppMethodBeat.o(37271);
            return false;
        }
        linearLayout.setVisibility(0);
        SpannableString spannableString = new SpannableString(str);
        try {
            spannableString.setSpan(new ForegroundColorSpan(linearLayout.getContext().getResources().getColor(R.color.a2x)), 0, spannableString.length(), 17);
        } catch (IndexOutOfBoundsException e2) {
            Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle setSpan error: %s", e2.getMessage());
        }
        int i3 = 0;
        while (true) {
            String str2 = ".msg.appmsg.mmreader.category.item.styles.style" + (i3 == 0 ? "" : String.valueOf(i3));
            if (!map.containsKey(str2)) {
                break;
            }
            b S = b.S(map, str2);
            if (S == null) {
                Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, styleKey = ".concat(String.valueOf(str2)));
            } else if (S.PNB >= S.PNC) {
                Log.w("MicroMsg.ChattingItemDyeingTemplateDecorator", "addStyle, no need to add, rangeFrom = " + S.PNB + ", rangeTo = " + S.PNC);
            } else {
                int i4 = S.PNB;
                int i5 = S.PNC;
                int i6 = S.maT;
                boolean z = S.ebY;
                boolean z2 = S.PNz;
                Log.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, rangeFrom = " + i4 + ", rangeTo = " + i5 + ", fontSize = " + i6 + ", isBlack = " + z + ", isUnderLine = " + z2);
                if (i4 < 0) {
                    Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i4), Integer.valueOf(i5));
                    i4 = 0;
                }
                if (i5 > spannableString.length()) {
                    Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i4), Integer.valueOf(i5));
                    i2 = spannableString.length();
                } else {
                    i2 = i5;
                }
                if (z) {
                    try {
                        spannableString.setSpan(new StyleSpan(1), i4, i2, 17);
                    } catch (IndexOutOfBoundsException e3) {
                        Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e3.getMessage());
                    }
                }
                if (z2) {
                    try {
                        spannableString.setSpan(new UnderlineSpan(), i4, i2, 17);
                    } catch (IndexOutOfBoundsException e4) {
                        Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e4.getMessage());
                    }
                }
                if (i6 != 14) {
                    try {
                        spannableString.setSpan(new AbsoluteSizeSpan(i6), i4, i2, 17);
                    } catch (IndexOutOfBoundsException e5) {
                        Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e5.getMessage());
                    }
                }
                int i7 = S.PNB;
                int i8 = S.PNC;
                int hT = ao.hT(S.color);
                Log.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, rangeFrom = " + i7 + ", rangeTo = " + i8 + ", color = " + hT);
                if (i7 < 0) {
                    Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i7), Integer.valueOf(i8));
                    i7 = 0;
                }
                if (i8 > spannableString.length()) {
                    Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setColor, params error. length:%d, from:%d, to:%d", Integer.valueOf(spannableString.length()), Integer.valueOf(i7), Integer.valueOf(i8));
                    i8 = spannableString.length();
                }
                try {
                    spannableString.setSpan(new ForegroundColorSpan(hT), i7, i8, 17);
                } catch (IndexOutOfBoundsException e6) {
                    Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "setFont setSpan error: %s", e6.getMessage());
                }
            }
            i3++;
        }
        Log.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total style count = ".concat(String.valueOf(i3)));
        int i9 = 0;
        ArrayList arrayList = new ArrayList();
        while (true) {
            String str3 = ".msg.appmsg.mmreader.category.item.styles.line" + (i9 == 0 ? "" : String.valueOf(i9));
            if (!map.containsKey(str3)) {
                Log.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "decorateStyle end, total line count = ".concat(String.valueOf(i9)));
                Collections.sort(arrayList);
                linearLayout.removeAllViews();
                a(linearLayout, spannableString, arrayList);
                AppMethodBeat.o(37271);
                return true;
            }
            a R = a.R(map, str3);
            if (R == null) {
                Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom fail, skip to next, lineKey = ".concat(String.valueOf(str3)));
            } else {
                arrayList.add(R);
            }
            i9++;
        }
    }

    static {
        AppMethodBeat.i(37279);
        AppMethodBeat.o(37279);
    }

    private static boolean a(LinearLayout linearLayout, SpannableString spannableString, List<a> list) {
        AppMethodBeat.i(37272);
        Log.d("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, nodeList size = " + list.size());
        int length = spannableString.length();
        int i2 = 0;
        for (a aVar : list) {
            if (aVar.offset > i2) {
                TextView textView = new TextView(linearLayout.getContext());
                textView.setText(spannableString.subSequence(i2, Math.min(aVar.offset, length)));
                textView.setLineSpacing(3.0f, 1.0f);
                linearLayout.addView(textView, PNy);
            }
            TextView textView2 = new TextView(linearLayout.getContext());
            textView2.setText(bnk(aVar.PNA));
            textView2.setSingleLine(true);
            if (aVar.maT != 14) {
                textView2.setTextSize((float) aVar.maT);
            }
            if (aVar.ebY) {
                textView2.setTypeface(null, 1);
            }
            if (aVar.PNz) {
                textView2.setPaintFlags(textView2.getPaintFlags() | 8);
            }
            textView2.setTextColor(ao.hT(aVar.color));
            linearLayout.addView(textView2, PNy);
            i2 = aVar.offset;
        }
        if (i2 >= length) {
            Log.i("MicroMsg.ChattingItemDyeingTemplateDecorator", "addLines, lastOffset >= maxLength, lastOffset = " + i2 + ", maxLength = " + length);
            AppMethodBeat.o(37272);
        } else {
            TextView textView3 = new TextView(linearLayout.getContext());
            textView3.setTextSize(0, (float) com.tencent.mm.cb.a.aG(textView3.getContext(), R.dimen.hc));
            textView3.setText(spannableString.subSequence(i2, length));
            textView3.setLineSpacing(2.0f, 1.0f);
            linearLayout.addView(textView3, PNy);
            AppMethodBeat.o(37272);
        }
        return true;
    }

    private static String bnk(String str) {
        AppMethodBeat.i(37273);
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() < 80) {
            sb.append(str);
        }
        String sb2 = sb.toString();
        AppMethodBeat.o(37273);
        return sb2;
    }

    /* access modifiers changed from: package-private */
    public static class b {
        public int PNB;
        public int PNC;
        public boolean PNz;
        public int color;
        public boolean ebY;
        public int maT;

        private b() {
        }

        public static b S(Map<String, String> map, String str) {
            String lowerCase;
            AppMethodBeat.i(37270);
            String str2 = map.get(str + ".range");
            if (Util.isNullOrNil(str2)) {
                Log.e("MicroMsg.StyleNode", "parseFrom fail, range is null");
                AppMethodBeat.o(37270);
                return null;
            } else if (str2.length() < 5 || str2.charAt(0) != '{' || str2.charAt(str2.length() - 1) != '}' || !str2.contains(",")) {
                Log.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, range = ".concat(String.valueOf(str2)));
                AppMethodBeat.o(37270);
                return null;
            } else {
                Log.d("MicroMsg.StyleNode", "parseFrom, range = ".concat(String.valueOf(str2)));
                String[] split = str2.substring(1, str2.length() - 1).split(",");
                if (split == null || split.length != 2) {
                    Log.e("MicroMsg.StyleNode", "parseFrom fail, range wrong format, strs array length = " + split.length);
                    AppMethodBeat.o(37270);
                    return null;
                }
                b bVar = new b();
                try {
                    bVar.PNB = Util.getInt(split[0], 0);
                    bVar.PNC = Util.getInt(split[1], 0) + bVar.PNB;
                    String str3 = map.get(str + ".font");
                    if (Util.isNullOrNil(str3)) {
                        Log.d("MicroMsg.StyleNode", "parseFrom, font is null, use default value");
                        lowerCase = "m";
                    } else {
                        lowerCase = str3.toLowerCase();
                    }
                    bVar.ebY = ap.gi(lowerCase);
                    bVar.PNz = ap.Vb(lowerCase);
                    bVar.maT = ap.bnl(lowerCase);
                    String str4 = str + ".color";
                    String str5 = str + ".wxcolors.wxcolor";
                    if (!ao.isDarkMode()) {
                        bVar.color = ap.hh(map.get(str5), ap.hh(map.get(str4), WebView.NIGHT_MODE_COLOR));
                    } else {
                        bVar.color = ap.hh(map.get(str5 + "1"), ap.hh(map.get(str5), ap.hh(map.get(str4), -855638017)));
                    }
                    AppMethodBeat.o(37270);
                    return bVar;
                } catch (Exception e2) {
                    Log.e("MicroMsg.StyleNode", "parseFrom fail, ex = " + e2.getMessage());
                    AppMethodBeat.o(37270);
                    return null;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static class a implements Comparable<a> {
        public String PNA;
        public boolean PNz;
        public int color;
        public boolean ebY;
        public int maT;
        public int offset;

        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(a aVar) {
            AppMethodBeat.i(37269);
            a aVar2 = aVar;
            if (aVar2 == null) {
                Log.e("MicroMsg.LineNode", "compareTo fail, should not be null");
                AppMethodBeat.o(37269);
                return 1;
            }
            int i2 = this.offset - aVar2.offset;
            AppMethodBeat.o(37269);
            return i2;
        }

        public static a R(Map<String, String> map, String str) {
            String lowerCase;
            AppMethodBeat.i(37268);
            a aVar = new a();
            try {
                aVar.offset = Util.getInt(map.get(str + ".offset"), 0);
                String str2 = map.get(str + ".font");
                if (Util.isNullOrNil(str2)) {
                    Log.d("MicroMsg.LineNode", "parseFrom, font is null, use default value");
                    lowerCase = "m";
                } else {
                    lowerCase = str2.toLowerCase();
                }
                aVar.ebY = ap.gi(lowerCase);
                aVar.PNz = ap.Vb(lowerCase);
                aVar.maT = ap.bnl(lowerCase);
                aVar.color = ap.hh(map.get(str + ".color"), ao.isDarkMode() ? -855638017 : WebView.NIGHT_MODE_COLOR);
                aVar.PNA = map.get(str + ".chars");
                if (Util.isNullOrNil(aVar.PNA)) {
                    Log.e("MicroMsg.LineNode", "parseFrom fail, chars is null");
                    AppMethodBeat.o(37268);
                    return null;
                }
                AppMethodBeat.o(37268);
                return aVar;
            } catch (Exception e2) {
                Log.e("MicroMsg.LineNode", "parseFrom fail, ex = " + e2.getMessage());
                AppMethodBeat.o(37268);
                return null;
            }
        }
    }

    private static int hg(String str, int i2) {
        AppMethodBeat.i(37274);
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(37274);
        } else {
            try {
                i2 = Color.parseColor(str);
                AppMethodBeat.o(37274);
            } catch (Exception e2) {
                Log.e("MicroMsg.ChattingItemDyeingTemplateDecorator", "parseFrom, ex = " + e2.getMessage());
                AppMethodBeat.o(37274);
            }
        }
        return i2;
    }

    static /* synthetic */ boolean gi(String str) {
        AppMethodBeat.i(37275);
        boolean contains = str.contains("b");
        AppMethodBeat.o(37275);
        return contains;
    }

    static /* synthetic */ boolean Vb(String str) {
        AppMethodBeat.i(37276);
        boolean contains = str.contains("u");
        AppMethodBeat.o(37276);
        return contains;
    }

    static /* synthetic */ int bnl(String str) {
        AppMethodBeat.i(37277);
        if (str.contains("m")) {
            AppMethodBeat.o(37277);
            return 18;
        } else if (str.contains("l")) {
            AppMethodBeat.o(37277);
            return 21;
        } else {
            AppMethodBeat.o(37277);
            return 14;
        }
    }
}
