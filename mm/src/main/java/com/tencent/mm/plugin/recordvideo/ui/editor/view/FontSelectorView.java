package com.tencent.mm.plugin.recordvideo.ui.editor.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.recordvideo.res.e;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.s;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0001 B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\tH\u0002J\u0010\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u000e¢\u0006\u0002\n\u0000R(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00180\fj\b\u0012\u0004\u0012\u00020\u0018`\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "configList", "Ljava/util/ArrayList;", "Lorg/json/JSONObject;", "Lkotlin/collections/ArrayList;", "fontSelectCallback", "Lkotlin/Function1;", "", "", "getFontSelectCallback", "()Lkotlin/jvm/functions/Function1;", "setFontSelectCallback", "(Lkotlin/jvm/functions/Function1;)V", "fontSelectViewList", "Landroid/view/View;", "initFontResource", "initFontSelectView", "onFontSelect", FirebaseAnalytics.b.INDEX, "selectFontViewState", "setSelectFont", "font", "Companion", "plugin-recordvideo_release"})
public final class FontSelectorView extends LinearLayout {
    public static final a ChK = new a((byte) 0);
    private static final String TAG = TAG;
    private final ArrayList<View> ChH;
    private ArrayList<JSONObject> ChI;
    private kotlin.g.a.b<? super String, x> ChJ;

    public FontSelectorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(237961);
        this.ChH = new ArrayList<>();
        this.ChI = new ArrayList<>();
        setOrientation(0);
        setGravity(16);
        eMC();
        AppMethodBeat.o(237961);
    }

    public FontSelectorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(237962);
        AppMethodBeat.o(237962);
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.g.a.b<? super java.lang.String, kotlin.x>, kotlin.g.a.b<java.lang.String, kotlin.x> */
    public final kotlin.g.a.b<String, x> getFontSelectCallback() {
        return this.ChJ;
    }

    public final void setFontSelectCallback(kotlin.g.a.b<? super String, x> bVar) {
        this.ChJ = bVar;
    }

    private final void eMC() {
        AppMethodBeat.i(237957);
        if (e.BYn.BXZ) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", com.tencent.mm.cb.a.aI(getContext(), R.string.dgt));
            jSONObject.put("key", BuildConfig.KINDA_DEFAULT);
            jSONObject.put("path", BuildConfig.KINDA_DEFAULT);
            this.ChI.add(jSONObject);
            JSONArray eLn = e.BYn.eLn();
            if (eLn != null) {
                int length = eLn.length();
                for (int i2 = 0; i2 < length; i2++) {
                    this.ChI.add(eLn.optJSONObject(i2));
                }
            }
            eMD();
        }
        AppMethodBeat.o(237957);
    }

    private final void eMD() {
        AppMethodBeat.i(237958);
        try {
            int i2 = 0;
            for (T t : this.ChI) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    j.hxH();
                }
                T t2 = t;
                TextView textView = new TextView(getContext());
                String optString = t2.optString("name");
                String str = TextUtils.isEmpty(t2.optString("path")) ? "" : e.BYn.eLk() + t2.optString("path");
                textView.setText(optString);
                if (s.YS(str)) {
                    textView.setTypeface(Typeface.createFromFile(str));
                } else {
                    textView.setTypeface(Typeface.DEFAULT);
                }
                textView.setBackground(getContext().getDrawable(R.drawable.a4v));
                Context context = getContext();
                p.g(context, "context");
                textView.setTextColor(context.getResources().getColor(R.color.BW_BG_100));
                Context context2 = getContext();
                p.g(context2, "context");
                textView.setTextSize(0, (float) context2.getResources().getDimensionPixelSize(R.dimen.cb));
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                Context context3 = getContext();
                p.g(context3, "context");
                layoutParams.width = context3.getResources().getDimensionPixelSize(R.dimen.cr);
                layoutParams.height = com.tencent.mm.cb.a.fromDPToPix(getContext(), 30);
                if (i2 != this.ChI.size() - 1) {
                    Context context4 = getContext();
                    p.g(context4, "context");
                    layoutParams.setMarginEnd(context4.getResources().getDimensionPixelSize(R.dimen.ci));
                }
                textView.setGravity(17);
                addView(textView, layoutParams);
                this.ChH.add(textView);
                textView.setTag(Integer.valueOf(i2));
                textView.setOnClickListener(new b(this));
                i2 = i3;
            }
            View view = this.ChH.get(0);
            p.g(view, "fontSelectViewList[0]");
            view.setBackground(getContext().getDrawable(R.drawable.a4w));
            AppMethodBeat.o(237958);
        } catch (Exception e2) {
            Log.printErrStackTrace(TAG, e2, "parse font error", new Object[0]);
            AppMethodBeat.o(237958);
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$initFontSelectView$1$1"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ FontSelectorView ChL;

        b(FontSelectorView fontSelectorView) {
            this.ChL = fontSelectorView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(237956);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$initFontSelectView$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            FontSelectorView fontSelectorView = this.ChL;
            p.g(view, LocaleUtil.ITALIAN);
            Object tag = view.getTag();
            if (tag == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.Int");
                AppMethodBeat.o(237956);
                throw tVar;
            }
            FontSelectorView.a(fontSelectorView, ((Integer) tag).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/view/FontSelectorView$initFontSelectView$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(237956);
        }
    }

    private final void VV(int i2) {
        AppMethodBeat.i(237959);
        int i3 = 0;
        for (T t : this.ChH) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                j.hxH();
            }
            T t2 = t;
            if (i3 == i2) {
                t2.setBackground(getContext().getDrawable(R.drawable.a4w));
                i3 = i4;
            } else {
                t2.setBackground(getContext().getDrawable(R.drawable.a4v));
                i3 = i4;
            }
        }
        AppMethodBeat.o(237959);
    }

    public final void setSelectFont(String str) {
        AppMethodBeat.i(237960);
        if (TextUtils.isEmpty(str)) {
            VV(0);
            AppMethodBeat.o(237960);
            return;
        }
        int i2 = 0;
        for (T t : this.ChI) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                j.hxH();
            }
            T t2 = t;
            if (str != null) {
                String optString = t2.optString("path");
                p.g(optString, "jsonObject.optString(\"path\")");
                if (n.a((CharSequence) str, (CharSequence) optString, false)) {
                    VV(i2);
                }
                i2 = i3;
            } else {
                i2 = i3;
            }
        }
        AppMethodBeat.o(237960);
    }

    public static final /* synthetic */ void a(FontSelectorView fontSelectorView, int i2) {
        AppMethodBeat.i(237963);
        fontSelectorView.VV(i2);
        kotlin.g.a.b<? super String, x> bVar = fontSelectorView.ChJ;
        if (bVar != null) {
            bVar.invoke(e.BYn.eLk() + fontSelectorView.ChI.get(i2).optString("path"));
            AppMethodBeat.o(237963);
            return;
        }
        AppMethodBeat.o(237963);
    }
}
