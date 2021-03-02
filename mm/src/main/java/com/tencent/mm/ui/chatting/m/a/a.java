package com.tencent.mm.ui.chatting.m.a;

import android.os.Build;
import android.text.Spannable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.b.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.widget.MMTextView;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class a {
    private static volatile a PFd = null;
    private static final MMHandler PFe = new MMHandler("AAChattingHelper");

    static /* synthetic */ void b(CharSequence charSequence, ca caVar) {
        AppMethodBeat.i(36622);
        a(charSequence, caVar, 0);
        AppMethodBeat.o(36622);
    }

    static {
        AppMethodBeat.i(36623);
        AppMethodBeat.o(36623);
    }

    private a() {
        AppMethodBeat.i(185017);
        PFe.setLogging(false);
        AppMethodBeat.o(185017);
    }

    public static a gTK() {
        a aVar;
        AppMethodBeat.i(36619);
        if (PFd == null) {
            synchronized (a.class) {
                try {
                    if (PFd == null) {
                        PFd = new a();
                    }
                    aVar = PFd;
                } finally {
                    AppMethodBeat.o(36619);
                }
            }
            return aVar;
        }
        a aVar2 = PFd;
        AppMethodBeat.o(36619);
        return aVar2;
    }

    public static MMTextView.a gTL() {
        return EnumC2100a.TEXT_CALLBACK;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.mm.ui.chatting.m.a.a$a  reason: collision with other inner class name */
    public enum EnumC2100a implements MMTextView.a {
        TEXT_CALLBACK;

        public static EnumC2100a valueOf(String str) {
            AppMethodBeat.i(36614);
            EnumC2100a aVar = (EnumC2100a) Enum.valueOf(EnumC2100a.class, str);
            AppMethodBeat.o(36614);
            return aVar;
        }

        static {
            AppMethodBeat.i(36616);
            AppMethodBeat.o(36616);
        }

        @Override // com.tencent.mm.ui.widget.MMTextView.a
        public final void a(CharSequence charSequence, long j2) {
            AppMethodBeat.i(36615);
            ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
            if (Util.isNullOrNil(Hb.field_talker)) {
                Log.w("MicroMsg.AAChattingHelper", "hy: not retrieving correct msg from db. try use old one. msg id: %d", Long.valueOf(j2));
                AppMethodBeat.o(36615);
            } else if ((Hb.field_flag & 16) == 0) {
                a.b(charSequence, Hb);
                AppMethodBeat.o(36615);
            } else {
                Log.v("MicroMsg.AAChattingHelper", "hy: show already checked. msg id is: %d", Long.valueOf(j2));
                AppMethodBeat.o(36615);
            }
        }
    }

    private static void a(CharSequence charSequence, ca caVar, int i2) {
        AppMethodBeat.i(36620);
        if (charSequence instanceof Spannable) {
            PFe.postToWorker(new b(charSequence, caVar, i2));
        }
        AppMethodBeat.o(36620);
    }

    public static void a(CharSequence charSequence, ca caVar) {
        AppMethodBeat.i(36621);
        a(charSequence, caVar, 1);
        AppMethodBeat.o(36621);
    }

    /* access modifiers changed from: package-private */
    public static class b implements Runnable {
        private ca dCM;
        private int scene;
        private CharSequence text;

        /* renamed from: com.tencent.mm.ui.chatting.m.a.a$b$b  reason: collision with other inner class name */
        interface AbstractC2103b {
            c a(Object obj, Spannable spannable);
        }

        b(CharSequence charSequence, ca caVar, int i2) {
            this.text = charSequence;
            this.dCM = caVar;
            this.scene = i2;
        }

        public final void run() {
            AppMethodBeat.i(36618);
            if (this.text instanceof Spannable) {
                try {
                    Spannable spannable = (Spannable) this.text;
                    System.nanoTime();
                    Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
                    ArrayList arrayList = new ArrayList(1);
                    if (spans == null || spans.length == 0) {
                        arrayList = null;
                    } else {
                        for (Object obj : spans) {
                            if (obj != null && d.INSTANCE.c(obj, p.class)) {
                                arrayList.add(new C2101a.C2102a((byte) 0).a(obj, spannable));
                            }
                        }
                    }
                    if (!(arrayList == null || arrayList.size() == 0)) {
                        this.dCM = ((l) g.af(l.class)).eiy().Hb(this.dCM.field_msgId);
                        if (this.dCM != null && !Util.isNullOrNil(this.dCM.field_talker)) {
                            this.dCM.setFlag(this.dCM.field_flag | 16);
                            ((l) g.af(l.class)).eiy().a(this.dCM.field_msgId, this.dCM);
                        }
                        bg.aVF().aTo().aXf();
                        bg.aVF().aTo().b(b.EnumC0443b.Chatting);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            h.INSTANCE.a(14237, "msg", Long.valueOf(this.dCM.field_msgId), Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, Build.VERSION.INCREMENTAL, Build.DISPLAY, Integer.valueOf(this.scene), ((c) it.next()).extInfo);
                            h.INSTANCE.idkeyStat(587, 0, 1, false);
                        }
                    }
                    AppMethodBeat.o(36618);
                    return;
                } catch (Exception e2) {
                }
            }
            AppMethodBeat.o(36618);
        }

        static class c {
            String extInfo;
            String text;

            c(String str, String str2) {
                this.text = str;
                this.extInfo = str2;
            }
        }

        /* renamed from: com.tencent.mm.ui.chatting.m.a.a$b$a  reason: collision with other inner class name */
        static class C2101a {

            /* renamed from: com.tencent.mm.ui.chatting.m.a.a$b$a$a  reason: collision with other inner class name */
            static class C2102a implements AbstractC2103b {
                private C2102a() {
                }

                /* synthetic */ C2102a(byte b2) {
                    this();
                }

                @Override // com.tencent.mm.ui.chatting.m.a.a.b.AbstractC2103b
                public final c a(Object obj, Spannable spannable) {
                    String name;
                    AppMethodBeat.i(36617);
                    String substring = spannable.toString().substring(spannable.getSpanStart(obj), spannable.getSpanEnd(obj));
                    try {
                        name = Util.nullAs(new JSONObject(obj.toString()).optString("type"), obj.getClass().getName());
                    } catch (JSONException e2) {
                        name = obj.getClass().getName();
                    }
                    c cVar = new c(substring, name);
                    AppMethodBeat.o(36617);
                    return cVar;
                }
            }
        }
    }
}
