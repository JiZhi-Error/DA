package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.media.GetSightParamsIPCTask;
import com.tencent.mm.plugin.appbrand.jsapi.media.b;
import com.tencent.mm.plugin.appbrand.jsapi.media.q;
import com.tencent.mm.plugin.mmsight.SightCaptureResult;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vfs.o;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005¢\u0006\u0002\u0010\fJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010R\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00058\u0002X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow;", "", "mComponent", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "mSourceType", "", "mCapture", "mMediaType", "mShowRawButton", "", "maxDuration", "maxCount", "(Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;IIIZII)V", "mMaxCount", "mMaxDuration", "goAlbumUI", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "goSightCaptureUI", "startChoose", "Companion", "plugin-appbrand-integration_release"})
public final class c {
    public static final a mbQ = new a((byte) 0);
    private final com.tencent.mm.plugin.appbrand.jsapi.f czm;
    private final int mMaxCount = Math.min(Math.max(1, 1), 9);
    private final int mbL;
    private final int mbM;
    private final int mbN;
    private final int mbO;
    private final boolean mbP;

    static {
        AppMethodBeat.i(50542);
        AppMethodBeat.o(50542);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", "sightParams", "Lcom/tencent/mm/plugin/mmsight/SightParams;", "kotlin.jvm.PlatformType", "call"})
    public static final class d<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ c mbR;

        d(c cVar) {
            this.mbR = cVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(50528);
            final com.tencent.mm.vending.g.b hdH = g.hdH();
            Intent intent = new Intent();
            intent.setClassName(this.mbR.czm.getContext(), "com.tencent.mm.plugin.mmsight.ui.SightCaptureUI");
            intent.putExtra("KEY_SIGHT_PARAMS", (SightParams) obj);
            Activity kD = com.tencent.mm.ui.statusbar.d.kD(this.mbR.czm.getContext());
            if (kD == null) {
                b bVar = (b) new kotlin.g.a.a<b.c>() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.c.d.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ b.c invoke() {
                        AppMethodBeat.i(50526);
                        Log.e("MicroMsg.AppBrand.ChooseMediaWorkFlow", "step:goSightCaptureUI context !is activity");
                        b.c cVar = new b.c("fail:internal error invalid android context");
                        hdH.G(cVar);
                        AppMethodBeat.o(50526);
                        return cVar;
                    }
                }.invoke();
                AppMethodBeat.o(50528);
                return bVar;
            }
            com.tencent.luggage.h.f.aK(kD).a(intent, new f.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.c.d.AnonymousClass2 */

                @Override // com.tencent.luggage.h.f.b
                public final void a(int i2, Intent intent) {
                    AppMethodBeat.i(50527);
                    if (intent == null || i2 == 0) {
                        hdH.G(b.a.mbJ);
                        AppMethodBeat.o(50527);
                        return;
                    }
                    SightCaptureResult sightCaptureResult = (SightCaptureResult) intent.getParcelableExtra("key_req_result");
                    if (sightCaptureResult == null) {
                        hdH.G(new b.c("get null sight capture result"));
                        AppMethodBeat.o(50527);
                        return;
                    }
                    com.tencent.mm.vending.g.b bVar = hdH;
                    Object[] objArr = new Object[1];
                    objArr[0] = new b.d(j.listOf(new o(sightCaptureResult.zsy ? sightCaptureResult.zsG : sightCaptureResult.zsA)), 2);
                    bVar.G(objArr);
                    AppMethodBeat.o(50527);
                }
            });
            kD.overridePendingTransition(R.anim.ei, -1);
            b.a aVar = b.a.mbJ;
            AppMethodBeat.o(50528);
            return aVar;
        }
    }

    public c(com.tencent.mm.plugin.appbrand.jsapi.f fVar, int i2, int i3, int i4, boolean z, int i5) {
        p.h(fVar, "mComponent");
        AppMethodBeat.i(50541);
        this.czm = fVar;
        this.mbM = i2;
        this.mbN = i3;
        this.mbO = i4;
        this.mbP = z;
        this.mbL = Math.min(Math.max(i5, 1), 60);
        AppMethodBeat.o(50541);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$CANCELED;", "<anonymous parameter 0>", "", "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Boolean;)Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$CANCELED;"})
    static final class f<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ c mbR;

        f(c cVar) {
            this.mbR = cVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "onClick", "com/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow$startChoose$2$2$1"})
        static final class a implements e.a {
            final /* synthetic */ f mbU;
            final /* synthetic */ com.tencent.mm.vending.g.b mbV;

            a(f fVar, com.tencent.mm.vending.g.b bVar) {
                this.mbU = fVar;
                this.mbV = bVar;
            }

            @Override // com.tencent.mm.ui.widget.a.e.a
            public final void onClick() {
                AppMethodBeat.i(160624);
                this.mbV.G(b.a.mbJ);
                AppMethodBeat.o(160624);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t¨\u0006\n"}, hxF = {"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Landroid/view/View;", "<anonymous parameter 2>", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu", "com/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow$startChoose$2$2$2"})
        static final class b implements View.OnCreateContextMenuListener {
            final /* synthetic */ f mbU;
            final /* synthetic */ com.tencent.mm.vending.g.b mbV;

            b(f fVar, com.tencent.mm.vending.g.b bVar) {
                this.mbU = fVar;
                this.mbV = bVar;
            }

            public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
                AppMethodBeat.i(160625);
                contextMenu.add(0, 1, 0, this.mbU.mbR.czm.getContext().getString(R.string.um));
                contextMenu.add(0, 2, 1, this.mbU.mbR.czm.getContext().getString(R.string.uv));
                AppMethodBeat.o(160625);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007¨\u0006\b"}, hxF = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow$startChoose$2$2$3"})
        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.c$f$c  reason: collision with other inner class name */
        static final class C0678c implements o.g {
            final /* synthetic */ f mbU;
            final /* synthetic */ com.tencent.mm.vending.g.b mbV;

            C0678c(f fVar, com.tencent.mm.vending.g.b bVar) {
                this.mbU = fVar;
                this.mbV = bVar;
            }

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                com.tencent.mm.co.f d2;
                AppMethodBeat.i(160627);
                p.g(menuItem, "menuItem");
                switch (menuItem.getItemId()) {
                    case 1:
                        d2 = c.c(this.mbU.mbR);
                        break;
                    case 2:
                        d2 = c.d(this.mbU.mbR);
                        break;
                    default:
                        d2 = com.tencent.mm.co.g.ey(b.a.mbJ);
                        break;
                }
                d2.b(new com.tencent.mm.vending.c.a<_Ret, _Var>(this) {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.c.f.C0678c.AnonymousClass1 */
                    final /* synthetic */ C0678c mbW;

                    {
                        this.mbW = r1;
                    }

                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(160626);
                        this.mbW.mbV.G((b) obj);
                        x xVar = x.SXb;
                        AppMethodBeat.o(160626);
                        return xVar;
                    }
                });
                AppMethodBeat.o(160627);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "onDismiss", "com/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow$startChoose$2$2$4"})
        static final class d implements e.b {
            final /* synthetic */ f mbU;
            final /* synthetic */ com.tencent.mm.vending.g.b mbV;

            d(f fVar, com.tencent.mm.vending.g.b bVar) {
                this.mbU = fVar;
                this.mbV = bVar;
            }

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
                AppMethodBeat.i(160628);
                this.mbV.G(b.a.mbJ);
                AppMethodBeat.o(160628);
            }
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(50540);
            Activity kD = com.tencent.mm.ui.statusbar.d.kD(this.mbR.czm.getContext());
            if (kD == null) {
                b.a aVar = (b.a) AnonymousClass1.mbX.invoke();
                AppMethodBeat.o(50540);
                return aVar;
            }
            if (q.b.a.a(q.d.CAMERA, this.mbR.mbM)) {
                g.a(c.c(this.mbR));
            } else if (q.b.a.a(q.d.ALBUM, this.mbR.mbM)) {
                g.a(c.d(this.mbR));
            } else {
                com.tencent.mm.vending.g.b hdH = g.hdH();
                com.tencent.mm.ui.tools.l lVar = new com.tencent.mm.ui.tools.l(kD);
                lVar.a(new a(this, hdH));
                lVar.a(null, new b(this, hdH), new C0678c(this, hdH), new d(this, hdH));
            }
            b.a aVar2 = b.a.mbJ;
            AppMethodBeat.o(50540);
            return aVar2;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaWorkFlow$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    static final class e<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ c mbR;

        e(c cVar) {
            this.mbR = cVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            boolean z;
            AppMethodBeat.i(50532);
            final ArrayList arrayList = new ArrayList();
            arrayList.add("android.permission.RECORD_AUDIO");
            arrayList.add("android.permission.CAMERA");
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (com.tencent.mm.pluginsdk.permission.b.n(this.mbR.czm.getContext(), (String) it.next())) {
                    it.remove();
                }
            }
            if (arrayList.isEmpty()) {
                z = true;
            } else {
                Activity kD = com.tencent.mm.ui.statusbar.d.kD(this.mbR.czm.getContext());
                if (kD == null) {
                    z = ((Boolean) AnonymousClass1.mbS.invoke()).booleanValue();
                } else {
                    final com.tencent.mm.vending.g.b hdx = g.hdx();
                    hdx.hdw();
                    com.tencent.luggage.h.f aK = com.tencent.luggage.h.f.aK(kD);
                    Object[] array = arrayList.toArray(new String[0]);
                    if (array == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlin.Array<T>");
                        AppMethodBeat.o(50532);
                        throw tVar;
                    }
                    aK.a((String[]) array, new f.AbstractC0176f() {
                        /* class com.tencent.mm.plugin.appbrand.jsapi.media.c.e.AnonymousClass2 */

                        @Override // com.tencent.luggage.h.f.AbstractC0176f
                        public final void q(int[] iArr) {
                            AppMethodBeat.i(50531);
                            p.g(iArr, "grantResults");
                            int length = iArr.length;
                            int i2 = 0;
                            int i3 = 0;
                            while (i2 < length) {
                                int i4 = i3 + 1;
                                if (iArr[i2] != 0) {
                                    hdx.ej(new IllegalAccessException("fail:system permission denied"));
                                    Log.e("MicroMsg.AppBrand.ChooseMediaWorkFlow", "interrupt pipeline, " + ((String) arrayList.get(i3)) + " denied by user");
                                    AppMethodBeat.o(50531);
                                    return;
                                }
                                i2++;
                                i3 = i4;
                            }
                            hdx.G(Boolean.TRUE);
                            AppMethodBeat.o(50531);
                        }
                    });
                    z = false;
                }
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(50532);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult;", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    public static final class b<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ c mbR;

        b(c cVar) {
            this.mbR = cVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            int i2;
            int i3;
            AppMethodBeat.i(50524);
            final com.tencent.mm.vending.g.b hdH = g.hdH();
            int i4 = this.mbR.mbO;
            if (i4 == q.c.mey.cSx) {
                i2 = 2;
            } else if (i4 == q.c.mex.cSx) {
                i2 = 1;
            } else {
                i2 = 3;
            }
            if (this.mbR.mbP) {
                i3 = 8;
            } else {
                i3 = 7;
            }
            Intent intent = new Intent();
            intent.setClassName(this.mbR.czm.getContext(), "com.tencent.mm.plugin.gallery.ui.GalleryEntryUI");
            intent.putExtra("gallery_report_tag", 16);
            intent.putExtra("key_send_raw_image", this.mbR.mbP);
            intent.putExtra("max_select_count", this.mbR.mMaxCount);
            intent.putExtra("query_source_type", i3);
            intent.putExtra("query_media_type", i2);
            intent.putExtra("show_header_view", false);
            intent.putExtra("album_video_max_duration", LocalCache.TIME_DAY);
            intent.putExtra("album_business_tag", "album_business_bubble_media_by_jsapi_choosevideo");
            Activity kD = com.tencent.mm.ui.statusbar.d.kD(this.mbR.czm.getContext());
            if (kD == null) {
                b bVar = (b) new kotlin.g.a.a<b.c>() {
                    /* class com.tencent.mm.plugin.appbrand.jsapi.media.c.b.AnonymousClass1 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ b.c invoke() {
                        AppMethodBeat.i(50522);
                        Log.e("MicroMsg.AppBrand.ChooseMediaWorkFlow", "step:goAlbumUI context !is activity");
                        b.c cVar = new b.c("fail:internal error invalid android context");
                        hdH.G(cVar);
                        AppMethodBeat.o(50522);
                        return cVar;
                    }
                }.invoke();
                AppMethodBeat.o(50524);
                return bVar;
            }
            com.tencent.luggage.h.f.aK(kD).a(intent, new f.b() {
                /* class com.tencent.mm.plugin.appbrand.jsapi.media.c.b.AnonymousClass2 */

                @Override // com.tencent.luggage.h.f.b
                public final void a(int i2, Intent intent) {
                    AppMethodBeat.i(50523);
                    if (intent == null || i2 == 0) {
                        hdH.G(b.a.mbJ);
                        AppMethodBeat.o(50523);
                        return;
                    }
                    ArrayList<String> arrayList = new ArrayList();
                    v stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
                    if (stringArrayListExtra == null) {
                        stringArrayListExtra = v.SXr;
                    }
                    arrayList.addAll(stringArrayListExtra);
                    v stringArrayListExtra2 = intent.getStringArrayListExtra("CropImage_OutputPath_List");
                    if (stringArrayListExtra2 == null) {
                        stringArrayListExtra2 = v.SXr;
                    }
                    arrayList.addAll(stringArrayListExtra2);
                    com.tencent.mm.vending.g.b bVar = hdH;
                    Object[] objArr = new Object[1];
                    ArrayList arrayList2 = new ArrayList();
                    for (String str : arrayList) {
                        arrayList2.add(new com.tencent.mm.vfs.o(str));
                    }
                    objArr[0] = new b.d(arrayList2, 1);
                    bVar.G(objArr);
                    AppMethodBeat.o(50523);
                }
            });
            b.a aVar = b.a.mbJ;
            AppMethodBeat.o(50524);
            return aVar;
        }
    }

    public static final /* synthetic */ com.tencent.mm.co.f c(c cVar) {
        AppMethodBeat.i(50543);
        if (!(Util.getAvailableMemoryMB(cVar.czm.getContext()) > 200)) {
            Toast.makeText(cVar.czm.getContext(), cVar.czm.getContext().getString(R.string.jh), 1).show();
        }
        com.tencent.mm.co.f<_Ret> b2 = com.tencent.mm.co.g.hio().j(new C0677c(cVar)).b(new d(cVar));
        p.g(b2, "pipelineExt().`$worker`<…Result.CANCELED\n        }");
        AppMethodBeat.o(50543);
        return b2;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/mmsight/SightParams;", "<anonymous parameter 0>", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "call"})
    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.media.c$c  reason: collision with other inner class name */
    public static final class C0677c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ c mbR;

        C0677c(c cVar) {
            this.mbR = cVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Object call(Object obj) {
            int i2;
            AppMethodBeat.i(50525);
            int i3 = this.mbR.mbO;
            if (i3 == q.c.mey.cSx) {
                i2 = 1;
            } else {
                i2 = i3 == q.c.mex.cSx ? 2 : 0;
            }
            GetSightParamsIPCTask.a aVar = GetSightParamsIPCTask.mbY;
            SightParams p = GetSightParamsIPCTask.a.p(i2, this.mbR.mbL, q.b.a.a(q.a.FRONT, this.mbR.mbN));
            p.zsP = false;
            p.zsQ = true;
            AppMethodBeat.o(50525);
            return p;
        }
    }

    public static final /* synthetic */ com.tencent.mm.co.f d(c cVar) {
        AppMethodBeat.i(50544);
        com.tencent.mm.co.f<_Ret> b2 = com.tencent.mm.co.g.hio().b(new b(cVar));
        p.g(b2, "pipelineExt().`$ui`<Choo…Result.CANCELED\n        }");
        AppMethodBeat.o(50544);
        return b2;
    }
}
