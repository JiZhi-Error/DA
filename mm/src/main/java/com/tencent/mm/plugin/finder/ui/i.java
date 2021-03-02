package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.convert.aa;
import com.tencent.mm.plugin.finder.convert.ai;
import com.tencent.mm.plugin.finder.convert.ak;
import com.tencent.mm.plugin.finder.convert.u;
import com.tencent.mm.plugin.finder.feed.k;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ab;
import com.tencent.mm.plugin.finder.model.ad;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderFeedExposeLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderFeedDetailUIContract$Presenter;", "scene", "", "context", "Lcom/tencent/mm/ui/MMActivity;", "safeMode", "", "(ILcom/tencent/mm/ui/MMActivity;Z)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "checkExposeCommentStrategy", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "plugin-finder_release"})
public final class i extends k.a {
    String TAG = "Finder.FinderShareFeedDetailUI";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(int i2, MMActivity mMActivity, boolean z) {
        super(i2, mMActivity, z, false, 8);
        p.h(mMActivity, "context");
        AppMethodBeat.i(252808);
        AppMethodBeat.o(252808);
    }

    @Override // com.tencent.mm.plugin.finder.feed.b.a
    public final String getTAG() {
        return this.TAG;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "plugin-finder_release"})
    public static final class a implements f {
        final /* synthetic */ i vPZ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(i iVar) {
            this.vPZ = iVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016¨\u0006\u0012"}, hxF = {"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$1", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedVideoConvert;", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedVideo;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.ui.i$a$a  reason: collision with other inner class name */
        public static final class C1298a extends ak {
            final /* synthetic */ a vQa;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1298a(a aVar, com.tencent.mm.plugin.finder.video.k kVar, com.tencent.mm.plugin.finder.feed.i iVar, boolean z) {
                super(kVar, iVar, z, 0, 8);
                this.vQa = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.finder.model.BaseFinderFeed] */
            @Override // com.tencent.mm.plugin.finder.convert.l
            public final /* synthetic */ com.tencent.mm.bw.b a(ad adVar) {
                AppMethodBeat.i(252806);
                p.h(adVar, "item");
                com.tencent.mm.bw.b a2 = a.a(this.vQa);
                AppMethodBeat.o(252806);
                return a2;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List] */
            @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.plugin.finder.convert.ak
            public final /* bridge */ /* synthetic */ void a(h hVar, ad adVar, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(167691);
                a(hVar, adVar, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(167691);
            }

            @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.convert.ak
            public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(167690);
                a(hVar, (ad) aVar, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(167690);
            }

            @Override // com.tencent.mm.plugin.finder.convert.ak
            public final void a(h hVar, ad adVar, int i2, int i3, boolean z, List<Object> list) {
                AppMethodBeat.i(167689);
                p.h(hVar, "holder");
                p.h(adVar, "item");
                super.a(hVar, adVar, i2, i3, z, list);
                i.c(hVar, this.tAj);
                View Mn = hVar.Mn(R.id.d7i);
                if (Mn != null) {
                    Mn.setVisibility(8);
                    AppMethodBeat.o(167689);
                    return;
                }
                AppMethodBeat.o(167689);
            }
        }

        @Override // com.tencent.mm.view.recyclerview.f
        public final com.tencent.mm.view.recyclerview.e<?> EC(int i2) {
            AppMethodBeat.i(167707);
            switch (i2) {
                case 1:
                    e eVar = new e(this, this.vPZ, this.vPZ.tAj);
                    AppMethodBeat.o(167707);
                    return eVar;
                case 2:
                case 3001:
                    b bVar = new b(this, this.vPZ, this.vPZ.tAj);
                    AppMethodBeat.o(167707);
                    return bVar;
                case 4:
                case 3002:
                    C1298a aVar = new C1298a(this, this.vPZ.tCD, this.vPZ, this.vPZ.tAj);
                    AppMethodBeat.o(167707);
                    return aVar;
                case 7:
                    c cVar = new c(this, this.vPZ, this.vPZ.tAj);
                    AppMethodBeat.o(167707);
                    return cVar;
                case 8:
                    d dVar = new d(this, this.vPZ.tCD, this.vPZ, this.vPZ.tAj);
                    AppMethodBeat.o(167707);
                    return dVar;
                default:
                    y yVar = y.vXH;
                    y.dQ(this.vPZ.TAG, i2);
                    com.tencent.mm.plugin.finder.convert.f fVar = new com.tencent.mm.plugin.finder.convert.f();
                    AppMethodBeat.o(167707);
                    return fVar;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0016¨\u0006\u0012"}, hxF = {"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$2", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedImageConvert;", "getLikeBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
        public static final class b extends u {
            final /* synthetic */ a vQa;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar, com.tencent.mm.plugin.finder.feed.i iVar, boolean z) {
                super(iVar, z, 0, 4);
                this.vQa = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.plugin.finder.model.BaseFinderFeed] */
            @Override // com.tencent.mm.plugin.finder.convert.l
            public final /* synthetic */ com.tencent.mm.bw.b a(com.tencent.mm.plugin.finder.model.u uVar) {
                AppMethodBeat.i(252807);
                p.h(uVar, "item");
                com.tencent.mm.bw.b a2 = a.a(this.vQa);
                AppMethodBeat.o(252807);
                return a2;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List] */
            @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.plugin.finder.convert.u
            public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.plugin.finder.model.u uVar, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(167694);
                a(hVar, uVar, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(167694);
            }

            @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.convert.u
            public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(167693);
                a(hVar, (com.tencent.mm.plugin.finder.model.u) aVar, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(167693);
            }

            @Override // com.tencent.mm.plugin.finder.convert.u
            public final void a(h hVar, com.tencent.mm.plugin.finder.model.u uVar, int i2, int i3, boolean z, List<Object> list) {
                AppMethodBeat.i(167692);
                p.h(hVar, "holder");
                p.h(uVar, "item");
                super.a(hVar, uVar, i2, i3, z, list);
                i.c(hVar, this.tAj);
                View Mn = hVar.Mn(R.id.d7i);
                if (Mn != null) {
                    Mn.setVisibility(8);
                    AppMethodBeat.o(167692);
                    return;
                }
                AppMethodBeat.o(167692);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$3", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedTextCardConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedImage;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
        public static final class c extends ai {
            final /* synthetic */ a vQa;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(a aVar, com.tencent.mm.plugin.finder.feed.i iVar, boolean z) {
                super(iVar, z, 0, 4);
                this.vQa = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List] */
            @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.plugin.finder.convert.ai, com.tencent.mm.plugin.finder.convert.u
            public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.plugin.finder.model.u uVar, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(167697);
                a(hVar, uVar, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(167697);
            }

            @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e, com.tencent.mm.plugin.finder.convert.ai, com.tencent.mm.plugin.finder.convert.u
            public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(167696);
                a(hVar, (com.tencent.mm.plugin.finder.model.u) aVar, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(167696);
            }

            @Override // com.tencent.mm.plugin.finder.convert.ai, com.tencent.mm.plugin.finder.convert.u
            public final void a(h hVar, com.tencent.mm.plugin.finder.model.u uVar, int i2, int i3, boolean z, List<Object> list) {
                AppMethodBeat.i(167695);
                p.h(hVar, "holder");
                p.h(uVar, "item");
                super.a(hVar, uVar, i2, i3, z, list);
                i.c(hVar, this.tAj);
                AppMethodBeat.o(167695);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$4", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedMixConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedMix;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
        public static final class d extends aa {
            final /* synthetic */ a vQa;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(a aVar, com.tencent.mm.plugin.finder.video.k kVar, com.tencent.mm.plugin.finder.feed.i iVar, boolean z) {
                super(kVar, iVar, z, 0, 8);
                this.vQa = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List] */
            @Override // com.tencent.mm.plugin.finder.convert.l
            public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.plugin.finder.model.aa aaVar, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(167700);
                a(hVar, aaVar, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(167700);
            }

            @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e
            public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(167699);
                a(hVar, (com.tencent.mm.plugin.finder.model.aa) aVar, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(167699);
            }

            private void a(h hVar, com.tencent.mm.plugin.finder.model.aa aaVar, int i2, int i3, boolean z, List<Object> list) {
                AppMethodBeat.i(167698);
                p.h(hVar, "holder");
                p.h(aaVar, "item");
                super.a(hVar, (BaseFinderFeed) aaVar, i2, i3, z, list);
                i.c(hVar, this.tAj);
                AppMethodBeat.o(167698);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/ui/Presenter$buildItemCoverts$1$getItemConvert$5", "Lcom/tencent/mm/plugin/finder/convert/FinderFeedPlainTextConvert;", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "Lcom/tencent/mm/plugin/finder/model/FinderFeedPlainText;", "position", "", "type", "isHotPatch", "", "payloads", "", "", "plugin-finder_release"})
        public static final class e extends com.tencent.mm.plugin.finder.convert.ad {
            final /* synthetic */ a vQa;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(a aVar, com.tencent.mm.plugin.finder.feed.i iVar, boolean z) {
                super(iVar, z, 0, 4);
                this.vQa = aVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.view.recyclerview.h, com.tencent.mm.plugin.finder.model.BaseFinderFeed, int, int, boolean, java.util.List] */
            @Override // com.tencent.mm.plugin.finder.convert.l
            public final /* bridge */ /* synthetic */ void a(h hVar, ab abVar, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(167703);
                a(hVar, abVar, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(167703);
            }

            @Override // com.tencent.mm.plugin.finder.convert.l, com.tencent.mm.view.recyclerview.e
            public final /* bridge */ /* synthetic */ void a(h hVar, com.tencent.mm.view.recyclerview.a aVar, int i2, int i3, boolean z, List list) {
                AppMethodBeat.i(167702);
                a(hVar, (ab) aVar, i2, i3, z, (List<Object>) list);
                AppMethodBeat.o(167702);
            }

            private void a(h hVar, ab abVar, int i2, int i3, boolean z, List<Object> list) {
                AppMethodBeat.i(167701);
                p.h(hVar, "holder");
                p.h(abVar, "item");
                super.a(hVar, (BaseFinderFeed) abVar, i2, i3, z, list);
                i.c(hVar, this.tAj);
                AppMethodBeat.o(167701);
            }
        }

        public static final /* synthetic */ com.tencent.mm.bw.b a(a aVar) {
            if (aVar.vPZ.gte instanceof FinderShareFeedDetailUI) {
                return ((FinderShareFeedDetailUI) aVar.vPZ.gte).likeBuffer;
            }
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.k.a, com.tencent.mm.plugin.finder.feed.b.a
    public final f dce() {
        AppMethodBeat.i(167708);
        a aVar = new a(this);
        AppMethodBeat.o(167708);
        return aVar;
    }

    public static final /* synthetic */ void c(h hVar, boolean z) {
        AppMethodBeat.i(167710);
        if (z) {
            FinderFeedExposeLayout finderFeedExposeLayout = (FinderFeedExposeLayout) hVar.Mn(R.id.b92);
            c cVar = c.vCb;
            if (!c.drv()) {
                Log.i("Finder.FeedConvert", "hit EXPOSE_COMMENT_SHOW close");
                finderFeedExposeLayout.getCommentsLayout().setVisibility(8);
            }
            c cVar2 = c.vCb;
            if (!c.drw()) {
                Log.i("Finder.FeedConvert", "hit EXPOSE_COMMENTBTN_SHOW close");
                finderFeedExposeLayout.getSeeAllCommentsTv().setVisibility(8);
            }
        }
        AppMethodBeat.o(167710);
    }
}
