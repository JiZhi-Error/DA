package com.tencent.mm.plugin.textstatus.f;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.textstatus.a.a;
import com.tencent.mm.plugin.textstatus.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u001a\u001b\u001c\u001d\u001eB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0001J6\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter;", "", "()V", "ICON_CHAR", "", "TAG", "", "listeners", "", "", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "cancelListener", "", "_key", "subject", "getTextStatusSpan", "", ch.COL_USERNAME, "displayName", "textSize", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "onNotify", "userName", "Listener", "StatusIconListener", "StatusSpanListener", "StatusSpanListenerNoMeasure", "StatusUpdateListener", "plugin-textstatus_release"})
public final class k {
    public static final k FZi = new k();
    private static final Map<Integer, a> pRR = new LinkedHashMap();

    static {
        AppMethodBeat.i(216225);
        com.tencent.mm.plugin.textstatus.b.f fVar = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        com.tencent.mm.plugin.textstatus.b.f.fvM().add(AnonymousClass1.FZj);
        com.tencent.mm.plugin.textstatus.b.f fVar2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        com.tencent.mm.plugin.textstatus.b.f.fvN().add(AnonymousClass2.FZk);
        AppMethodBeat.o(216225);
    }

    private k() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010\u0012\u001a\u00020\u0011H&R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "", "subject", "key", "", "(Ljava/lang/Object;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "setRef", "(Ljava/lang/ref/WeakReference;)V", "notDeadToRun", "", "onChange", "plugin-textstatus_release"})
    public static abstract class a {
        String key;
        public WeakReference<Object> nsR;

        public abstract void onChange();

        public a(Object obj, String str) {
            p.h(obj, "subject");
            p.h(str, "key");
            this.key = str;
            this.nsR = new WeakReference<>(obj);
            k kVar = k.FZi;
            synchronized (k.pRR) {
                k kVar2 = k.FZi;
                k.pRR.put(Integer.valueOf(obj.hashCode()), this);
            }
        }

        public final WeakReference<Object> fvT() {
            WeakReference<Object> weakReference = this.nsR;
            if (weakReference == null) {
                p.btv("ref");
            }
            return weakReference;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class f implements Runnable {
        final /* synthetic */ String jDi;

        f(String str) {
            this.jDi = str;
        }

        public final void run() {
            AppMethodBeat.i(216223);
            k kVar = k.FZi;
            synchronized (k.pRR) {
                try {
                    ArrayList<Number> arrayList = new ArrayList();
                    k kVar2 = k.FZi;
                    for (Map.Entry entry : k.pRR.entrySet()) {
                        if (p.j(((a) entry.getValue()).key, this.jDi)) {
                            if (((a) entry.getValue()).fvT().get() == null) {
                                arrayList.add(entry.getKey());
                            } else {
                                a aVar = (a) entry.getValue();
                                WeakReference<Object> weakReference = aVar.nsR;
                                if (weakReference == null) {
                                    p.btv("ref");
                                }
                                if (weakReference.get() != null) {
                                    aVar.onChange();
                                }
                            }
                        }
                    }
                    for (Number number : arrayList) {
                        int intValue = number.intValue();
                        k kVar3 = k.FZi;
                        k.pRR.remove(Integer.valueOf(intValue));
                    }
                    x xVar = x.SXb;
                } finally {
                    AppMethodBeat.o(216223);
                }
            }
        }
    }

    public static void C(String str, Object obj) {
        AppMethodBeat.i(216224);
        p.h(str, "_key");
        p.h(obj, "subject");
        synchronized (pRR) {
            try {
                a aVar = pRR.get(Integer.valueOf(obj.hashCode()));
                if (aVar != null && p.j(str, aVar.key)) {
                    pRR.remove(Integer.valueOf(obj.hashCode()));
                    Log.i("MicroMsg.TxtStatus.TextStatusEventCenter", "cancelListener ".concat(String.valueOf(str)));
                }
            } finally {
                AppMethodBeat.o(216224);
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusSpanListener;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "iconTV", "Landroid/widget/TextView;", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "(Ljava/lang/String;Landroid/widget/TextView;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;)V", "getIconScene", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "getIconType", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "onChange", "", "Companion", "plugin-textstatus_release"})
    public static final class c extends a {
        public static final a FZn = new a((byte) 0);
        private final a.c FZm;
        private final a.b VdF;

        static {
            AppMethodBeat.i(216216);
            AppMethodBeat.o(216216);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusSpanListener$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(String str, TextView textView, a.c cVar, a.b bVar) {
            super(textView, str);
            p.h(str, "userName");
            p.h(textView, "iconTV");
            p.h(cVar, "iconType");
            p.h(bVar, "iconScene");
            AppMethodBeat.i(258406);
            this.FZm = cVar;
            this.VdF = bVar;
            onChange();
            AppMethodBeat.o(258406);
        }

        @Override // com.tencent.mm.plugin.textstatus.f.k.a
        public final void onChange() {
            AppMethodBeat.i(216214);
            Log.d("MicroMsg.TxtStatus.StatusSpanListener", "onChange " + this.key);
            Object obj = fvT().get();
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.TextView");
                AppMethodBeat.o(216214);
                throw tVar;
            }
            TextView textView = (TextView) obj;
            k kVar = k.FZi;
            CharSequence a2 = k.a(this.key, textView.getText(), (int) textView.getTextSize(), this.FZm, this.VdF);
            if (a2 != null && (!p.j(textView.getText(), a2))) {
                textView.setText(a2);
            }
            AppMethodBeat.o(216214);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusSpanListenerNoMeasure;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "iconTV", "Lcom/tencent/mm/ui/base/NoMeasuredTextView;", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "(Ljava/lang/String;Lcom/tencent/mm/ui/base/NoMeasuredTextView;Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;)V", "getIconScene", "()Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "onChange", "", "Companion", "plugin-textstatus_release"})
    public static final class d extends a {
        public static final a FZo = new a((byte) 0);
        private final a.b VdF;

        static {
            AppMethodBeat.i(216219);
            AppMethodBeat.o(216219);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusSpanListenerNoMeasure$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(String str, NoMeasuredTextView noMeasuredTextView, a.b bVar) {
            super(noMeasuredTextView, str);
            p.h(str, "userName");
            p.h(noMeasuredTextView, "iconTV");
            p.h(bVar, "iconScene");
            AppMethodBeat.i(258407);
            this.VdF = bVar;
            onChange();
            AppMethodBeat.o(258407);
        }

        @Override // com.tencent.mm.plugin.textstatus.f.k.a
        public final void onChange() {
            AppMethodBeat.i(216217);
            Log.d("MicroMsg.TxtStatus.StatusSpanListenerNoMeasure", "onChange " + this.key);
            Object obj = fvT().get();
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.base.NoMeasuredTextView");
                AppMethodBeat.o(216217);
                throw tVar;
            }
            NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) obj;
            k kVar = k.FZi;
            CharSequence a2 = k.a(this.key, noMeasuredTextView.getText(), (int) noMeasuredTextView.getTextSize(), a.c.OUTLINED, this.VdF);
            if (a2 != null && (!p.j(noMeasuredTextView.getText(), a2))) {
                noMeasuredTextView.setText(a2);
            }
            AppMethodBeat.o(216217);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusIconListener;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "iconIV", "Landroid/widget/ImageView;", "(Ljava/lang/String;Landroid/widget/ImageView;)V", "onChange", "", "Companion", "plugin-textstatus_release"})
    public static final class b extends a {
        public static final a FZl = new a((byte) 0);

        static {
            AppMethodBeat.i(216213);
            AppMethodBeat.o(216213);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusIconListener$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(String str, ImageView imageView) {
            super(imageView, str);
            p.h(str, "userName");
            p.h(imageView, "iconIV");
            AppMethodBeat.i(216212);
            k kVar = k.FZi;
            k.aTh(str);
            AppMethodBeat.o(216212);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0059, code lost:
            if (r1 == null) goto L_0x005b;
         */
        @Override // com.tencent.mm.plugin.textstatus.f.k.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onChange() {
            /*
            // Method dump skipped, instructions count: 104
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.textstatus.f.k.b.onChange():void");
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusUpdateListener;", "Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$Listener;", "userName", "", "statusUpdate", "Lcom/tencent/mm/plugin/textstatus/api/IStatusUpdate;", "(Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/api/IStatusUpdate;)V", "onChange", "", "Companion", "plugin-textstatus_release"})
    public static final class e extends a {
        public static final a FZp = new a((byte) 0);

        static {
            AppMethodBeat.i(216222);
            AppMethodBeat.o(216222);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/model/TextStatusEventCenter$StatusUpdateListener$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"})
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(byte b2) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(String str, j jVar) {
            super(jVar, str);
            p.h(str, "userName");
            p.h(jVar, "statusUpdate");
            AppMethodBeat.i(216221);
            AppMethodBeat.o(216221);
        }

        @Override // com.tencent.mm.plugin.textstatus.f.k.a
        public final void onChange() {
            AppMethodBeat.i(216220);
            Log.i("MicroMsg.TxtStatus.StatusCardListener", "StatusCardListener onChange " + this.key);
            Object obj = fvT().get();
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.api.IStatusUpdate");
                AppMethodBeat.o(216220);
                throw tVar;
            }
            ((j) obj).DV(this.key);
            AppMethodBeat.o(216220);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ java.lang.CharSequence a(java.lang.String r11, java.lang.CharSequence r12, int r13, com.tencent.mm.plugin.textstatus.a.a.c r14, com.tencent.mm.plugin.textstatus.a.a.b r15) {
        /*
        // Method dump skipped, instructions count: 180
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.textstatus.f.k.a(java.lang.String, java.lang.CharSequence, int, com.tencent.mm.plugin.textstatus.a.a$c, com.tencent.mm.plugin.textstatus.a.a$b):java.lang.CharSequence");
    }

    public static final /* synthetic */ void aTh(String str) {
        AppMethodBeat.i(216227);
        Log.i("MicroMsg.TxtStatus.TextStatusEventCenter", "onNotify ".concat(String.valueOf(str)));
        h.RTc.aV(new f(str));
        AppMethodBeat.o(216227);
    }
}
