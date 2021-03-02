package com.tencent.mm.plugin.emojicapture.model.a;

import android.support.v7.h.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.sticker.c;
import com.tencent.smtt.sdk.TbsListener;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010H\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallbackWrapper;", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "recommendCallback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "dataCallback", "(Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;)V", "getDataCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerListDiffCallback;", "dataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/sticker/LensItem;", "getRecommendCallback", "recommendList", "onMore", "", "lensList", "", "onRecommend", "plugin-emojicapture_release"})
public final class e implements d {
    final LinkedList<c> ppH = new LinkedList<>();
    final c roK;
    final LinkedList<c> roR = new LinkedList<>();
    final c roS;

    public e(c cVar, c cVar2) {
        p.h(cVar, "recommendCallback");
        p.h(cVar2, "dataCallback");
        AppMethodBeat.i(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS);
        this.roS = cVar;
        this.roK = cVar2;
        AppMethodBeat.o(TbsListener.ErrorCode.DECOUPLE_INSTLL_SUCCESS);
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.a.d
    public final void dk(List<c> list) {
        AppMethodBeat.i(231);
        p.h(list, "lensList");
        d.b("StickerPanelCallbackWrapper_onRecommend", new b(this, list));
        AppMethodBeat.o(231);
    }

    @Override // com.tencent.mm.plugin.emojicapture.model.a.d
    public final void dl(List<c> list) {
        AppMethodBeat.i(232);
        p.h(list, "lensList");
        d.b("StickerPanelCallbackWrapper_onMore", new a(this, list));
        AppMethodBeat.o(232);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e roT;
        final /* synthetic */ List roU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(e eVar, List list) {
            super(0);
            this.roT = eVar;
            this.roU = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            final c.b A;
            AppMethodBeat.i(230);
            synchronized (this.roT.roR) {
                try {
                    c.a aVar = com.tencent.mm.sticker.c.NML;
                    A = c.a.A(this.roT.roR, this.roU);
                    this.roT.roR.clear();
                    this.roT.roR.addAll(this.roU);
                } catch (Throwable th) {
                    AppMethodBeat.o(230);
                    throw th;
                }
            }
            d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.emojicapture.model.a.e.b.AnonymousClass1 */
                final /* synthetic */ b roY;

                {
                    this.roY = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(229);
                    this.roY.roT.roS.ad(this.roY.roU);
                    A.a(new android.support.v7.h.d(this) {
                        /* class com.tencent.mm.plugin.emojicapture.model.a.e.b.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 roZ;

                        /* JADX WARN: Incorrect args count in method signature: ()V */
                        {
                            this.roZ = r1;
                        }

                        @Override // android.support.v7.h.d
                        public final void f(int i2, int i3) {
                            AppMethodBeat.i(TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR);
                            this.roZ.roY.roT.roS.fH(i2, i3);
                            AppMethodBeat.o(TbsListener.ErrorCode.CREATE_TEMP_CONF_ERROR);
                        }

                        @Override // android.support.v7.h.d
                        public final void k(int i2, int i3) {
                            AppMethodBeat.i(226);
                            this.roZ.roY.roT.roS.fI(i2, i3);
                            AppMethodBeat.o(226);
                        }

                        @Override // android.support.v7.h.d
                        public final void l(int i2, int i3) {
                            AppMethodBeat.i(TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL);
                            this.roZ.roY.roT.roS.fJ(i2, i3);
                            AppMethodBeat.o(TbsListener.ErrorCode.HOST_CONTEXT_IS_NULL);
                        }

                        @Override // android.support.v7.h.d
                        public final void c(int i2, int i3, Object obj) {
                            AppMethodBeat.i(228);
                            this.roZ.roY.roT.roS.fK(i2, i3);
                            AppMethodBeat.o(228);
                        }
                    });
                    x xVar = x.SXb;
                    AppMethodBeat.o(229);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(230);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ e roT;
        final /* synthetic */ List roU;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(e eVar, List list) {
            super(0);
            this.roT = eVar;
            this.roU = list;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            final c.b A;
            AppMethodBeat.i(TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
            synchronized (this.roT.ppH) {
                try {
                    c.a aVar = com.tencent.mm.sticker.c.NML;
                    A = c.a.A(this.roT.ppH, this.roU);
                    this.roT.ppH.clear();
                    this.roT.ppH.addAll(this.roU);
                } catch (Throwable th) {
                    AppMethodBeat.o(TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
                    throw th;
                }
            }
            d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.emojicapture.model.a.e.a.AnonymousClass1 */
                final /* synthetic */ a roV;

                {
                    this.roV = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM);
                    this.roV.roT.roK.ad(this.roV.roU);
                    A.a(new android.support.v7.h.d(this) {
                        /* class com.tencent.mm.plugin.emojicapture.model.a.e.a.AnonymousClass1.AnonymousClass1 */
                        final /* synthetic */ AnonymousClass1 roX;

                        /* JADX WARN: Incorrect args count in method signature: ()V */
                        {
                            this.roX = r1;
                        }

                        @Override // android.support.v7.h.d
                        public final void f(int i2, int i3) {
                            AppMethodBeat.i(TbsListener.ErrorCode.RENAME_EXCEPTION);
                            this.roX.roV.roT.roK.fH(i2, i3);
                            AppMethodBeat.o(TbsListener.ErrorCode.RENAME_EXCEPTION);
                        }

                        @Override // android.support.v7.h.d
                        public final void k(int i2, int i3) {
                            AppMethodBeat.i(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
                            this.roX.roV.roT.roK.fI(i2, i3);
                            AppMethodBeat.o(TbsListener.ErrorCode.COPY_INSTALL_SUCCESS);
                        }

                        @Override // android.support.v7.h.d
                        public final void l(int i2, int i3) {
                            AppMethodBeat.i(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS);
                            this.roX.roV.roT.roK.fJ(i2, i3);
                            AppMethodBeat.o(TbsListener.ErrorCode.INCRUPDATE_INSTALL_SUCCESS);
                        }

                        @Override // android.support.v7.h.d
                        public final void c(int i2, int i3, Object obj) {
                            AppMethodBeat.i(TbsListener.ErrorCode.UNLZMA_FAIURE);
                            this.roX.roV.roT.roK.fK(i2, i3);
                            AppMethodBeat.o(TbsListener.ErrorCode.UNLZMA_FAIURE);
                        }
                    });
                    x xVar = x.SXb;
                    AppMethodBeat.o(TbsListener.ErrorCode.EXCEED_LZMA_RETRY_NUM);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(TbsListener.ErrorCode.EXCEED_INCR_UPDATE);
            return xVar;
        }
    }
}
