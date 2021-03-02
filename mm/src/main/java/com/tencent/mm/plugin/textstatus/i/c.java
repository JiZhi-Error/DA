package com.tencent.mm.plugin.textstatus.i;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.textstatus.g.r;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0004\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\"\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fH\u0016J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R^\u0010\u0006\u001aR\u0012\u0004\u0012\u00020\b\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f0\n0\t0\u0007j(\u0012\u0004\u0012\u00020\b\u0012\u001e\u0012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f0\n0\t`\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/third/LiveSingleton;", "Lcom/tencent/mm/plugin/textstatus/third/ISpecialViewSingleton;", "()V", "liveStatusListener", "com/tencent/mm/plugin/textstatus/third/LiveSingleton$liveStatusListener$1", "Lcom/tencent/mm/plugin/textstatus/third/LiveSingleton$liveStatusListener$1;", "viewCache", "Ljava/util/HashMap;", "", "Ljava/lang/ref/SoftReference;", "Lkotlin/Pair;", "Landroid/view/View;", "Lkotlin/Function0;", "", "Lkotlin/collections/HashMap;", "getView", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getViewAndRefresh", "refreshCallback", "refreshLiveStatue", "liveId", "liveStatus", "", "release", "Companion", "plugin-textstatus_release"})
public final class c implements b {
    public static final a Gcn = new a((byte) 0);
    private static final String TAG = TAG;
    private HashMap<String, SoftReference<o<View, kotlin.g.a.a<x>>>> Gcl = new HashMap<>();
    private final b Gcm = new b(this);

    public c() {
        AppMethodBeat.i(216337);
        this.Gcm.alive();
        AppMethodBeat.o(216337);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/textstatus/third/LiveSingleton$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-textstatus_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(216338);
        AppMethodBeat.o(216338);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/textstatus/third/LiveSingleton$liveStatusListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-textstatus_release"})
    public static final class b extends IListener<hn> {
        final /* synthetic */ c Gco;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(c cVar) {
            this.Gco = cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hn hnVar) {
            AppMethodBeat.i(216333);
            hn hnVar2 = hnVar;
            if (hnVar2 != null) {
                d.h(new a(this, hnVar2));
            }
            AppMethodBeat.o(216333);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/textstatus/third/LiveSingleton$liveStatusListener$1$callback$1$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ b Gcp;
            final /* synthetic */ hn vQy;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, hn hnVar) {
                super(0);
                this.Gcp = bVar;
                this.vQy = hnVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(216332);
                c.a(this.Gcp.Gco, d.zs(this.vQy.dLW.id), this.vQy.dLW.liveStatus);
                x xVar = x.SXb;
                AppMethodBeat.o(216332);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.plugin.textstatus.i.b
    public final View a(r rVar) {
        AppMethodBeat.i(216334);
        p.h(rVar, "jumpInfo");
        Log.i(TAG, "getView jumpType:" + rVar.GaO);
        if (p.j(rVar.GaO, "2")) {
            ImageView imageView = new ImageView(MMApplicationContext.getContext());
            Context context = MMApplicationContext.getContext();
            p.g(context, "MMApplicationContext.getContext()");
            imageView.setImageDrawable(context.getResources().getDrawable(R.raw.finder_live_icon));
            ImageView imageView2 = imageView;
            AppMethodBeat.o(216334);
            return imageView2;
        }
        AppMethodBeat.o(216334);
        return null;
    }

    @Override // com.tencent.mm.plugin.textstatus.i.b
    public final View a(r rVar, kotlin.g.a.a<x> aVar) {
        ImageView imageView = null;
        AppMethodBeat.i(216335);
        p.h(rVar, "jumpInfo");
        p.h(aVar, "refreshCallback");
        Log.i(TAG, "getViewAndRefresh jumpType:" + rVar.GaO);
        if (p.j(rVar.GaO, "2")) {
            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
            dVar.j("", XmlParser.parseXml(rVar.GaQ, "finderLive", null));
            if (this.Gcl.get(dVar.jlf.hJs) == null) {
                imageView = new ImageView(MMApplicationContext.getContext());
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                imageView.setImageDrawable(context.getResources().getDrawable(R.raw.finder_live_icon));
                String str = dVar.jlf.hJs;
                p.g(str, "shareLiveInfo.shareLive.liveId");
                this.Gcl.put(str, new SoftReference<>(new o(imageView, aVar)));
            }
        }
        AppMethodBeat.o(216335);
        return imageView;
    }

    @Override // com.tencent.mm.plugin.textstatus.i.b
    public final void b(r rVar) {
        AppMethodBeat.i(216336);
        p.h(rVar, "jumpInfo");
        Log.i(TAG, "release jumpType:" + rVar.GaO);
        if (p.j(rVar.GaO, "2")) {
            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
            dVar.j("", XmlParser.parseXml(rVar.GaQ, "finderLive", null));
            Log.i(TAG, "release liveId:" + dVar.jlf.hJs);
            this.Gcl.remove(dVar.jlf.hJs);
        }
        AppMethodBeat.o(216336);
    }

    public static final /* synthetic */ void a(c cVar, String str, int i2) {
        AppMethodBeat.i(216339);
        Log.i(TAG, "refreshLiveStatue liveId:" + str + " liveStatus:" + i2);
        SoftReference<o<View, kotlin.g.a.a<x>>> softReference = cVar.Gcl.get(str);
        o<View, kotlin.g.a.a<x>> oVar = softReference != null ? softReference.get() : null;
        if (oVar != null) {
            A a2 = oVar.first;
            B b2 = oVar.second;
            if (i2 == 2) {
                a2.setVisibility(8);
            } else if (i2 == 1) {
                a2.setVisibility(0);
            }
            b2.invoke();
        }
        AppMethodBeat.o(216339);
    }
}
