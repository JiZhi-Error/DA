package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 \u00072\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0007\bR\u0012\u0010\u0004\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyWorkaroundLogic;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyWorkaroundLogic;", "weEffectManager", "getWeEffectManager", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "DUMMY", "IFactory", "luggage-xweb-ext_release"})
public interface m extends g, k, l {
    public static final a cGP = a.cGR;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory;", "", "create", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "DUMMY", "luggage-xweb-ext_release"})
    public interface b {
        public static final a cGS = a.cGT;

        m Qh();

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory$DUMMY;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$IFactory;", "()V", "create", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$DUMMY;", "luggage-xweb-ext_release"})
        public static final class a implements b {
            static final /* synthetic */ a cGT = new a();

            static {
                AppMethodBeat.i(215953);
                AppMethodBeat.o(215953);
            }

            private a() {
            }

            @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m.b
            public final /* bridge */ /* synthetic */ m Qh() {
                return m.cGP;
            }
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0014H\u0016J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u001cH\u0016J\u001c\u0010\u001d\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001e\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\u001c\u0010\u001f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010 2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010$\u001a\u00020\u0010H\u0016J\b\u0010%\u001a\u00020\u0010H\u0016J\b\u0010&\u001a\u00020\u0010H\u0016J\b\u0010'\u001a\u00020\bH\u0016J\u0012\u0010(\u001a\u00020\u00102\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J \u0010+\u001a\u00020,2\u0006\u0010)\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u00060"}, hxF = {"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager$DUMMY;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "()V", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "getWeEffectManager", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "applyBlusherStick", "", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "applyEyeBrow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "applyEyeShadow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "applyFaceBeauty", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$FaceBeautyType;", "rate", "", "applyFaceContour", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "applyFilter", "filePath", "", "alpha", "applyLipStick", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "applyMakeup", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "applySticker", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "stickerInfo", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "clearFilters", "clearMakeups", "clearStickers", "isEnabled", "onDetectFacePoints", "p0", "", "onTextureCustomProcess", "", "p1", "p2", "onTextureDestoryed", "luggage-xweb-ext_release"})
    public static final class a implements m {
        private static final l cGQ;
        static final /* synthetic */ a cGR = new a();

        static {
            AppMethodBeat.i(215952);
            l lVar = l.cGz;
            p.g(lVar, "IWeEffectManager.DUMMY");
            cGQ = lVar;
            AppMethodBeat.o(215952);
        }

        private a() {
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.k
        public final boolean a(l.c cVar, List<StickerItemInfo> list) {
            AppMethodBeat.i(215935);
            p.h(cVar, "type");
            p.h(list, "stickerInfo");
            AppMethodBeat.o(215935);
            return false;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
        public final boolean a(n nVar) {
            AppMethodBeat.i(215936);
            p.h(nVar, "info");
            AppMethodBeat.o(215936);
            return false;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
        public final boolean a(c cVar) {
            AppMethodBeat.i(215937);
            p.h(cVar, "info");
            AppMethodBeat.o(215937);
            return false;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
        public final boolean a(a aVar) {
            AppMethodBeat.i(215938);
            p.h(aVar, "info");
            AppMethodBeat.o(215938);
            return false;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
        public final boolean a(d dVar) {
            AppMethodBeat.i(215939);
            p.h(dVar, "info");
            AppMethodBeat.o(215939);
            return false;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
        public final boolean a(b bVar) {
            AppMethodBeat.i(215940);
            p.h(bVar, "info");
            AppMethodBeat.o(215940);
            return false;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final boolean isEnabled() {
            AppMethodBeat.i(215941);
            boolean isEnabled = cGQ.isEnabled();
            AppMethodBeat.o(215941);
            return isEnabled;
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final void a(l.a aVar, float f2) {
            AppMethodBeat.i(215942);
            cGQ.a(aVar, f2);
            AppMethodBeat.o(215942);
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final void b(String str, float f2) {
            AppMethodBeat.i(215943);
            cGQ.b(str, f2);
            AppMethodBeat.o(215943);
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final void clearFilters() {
            AppMethodBeat.i(215944);
            cGQ.clearFilters();
            AppMethodBeat.o(215944);
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final void a(l.c cVar, String str) {
            AppMethodBeat.i(215945);
            cGQ.a(cVar, str);
            AppMethodBeat.o(215945);
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final void Qf() {
            AppMethodBeat.i(215946);
            cGQ.Qf();
            AppMethodBeat.o(215946);
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final void a(l.b bVar, String str) {
            AppMethodBeat.i(215947);
            cGQ.a(bVar, str);
            AppMethodBeat.o(215947);
        }

        @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
        public final void Qg() {
            AppMethodBeat.i(215948);
            cGQ.Qg();
            AppMethodBeat.o(215948);
        }

        @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
        public final int onTextureCustomProcess(int i2, int i3, int i4) {
            AppMethodBeat.i(215949);
            int onTextureCustomProcess = cGQ.onTextureCustomProcess(i2, i3, i4);
            AppMethodBeat.o(215949);
            return onTextureCustomProcess;
        }

        @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
        public final void onDetectFacePoints(float[] fArr) {
            AppMethodBeat.i(215950);
            cGQ.onDetectFacePoints(fArr);
            AppMethodBeat.o(215950);
        }

        @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
        public final void onTextureDestoryed() {
            AppMethodBeat.i(215951);
            cGQ.onTextureDestoryed();
            AppMethodBeat.o(215951);
        }
    }
}
