package com.tencent.mm.plugin.appbrand.xweb_ext.a;

import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.c;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.d;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.e;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.i;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.m;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u001cH\u0016J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020$H\u0016J\u001c\u0010%\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010&2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001e\u0010'\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016J\u001c\u0010'\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010(2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\b\u0010-\u001a\u00020\u0018H\u0016J\b\u0010.\u001a\u00020\u0018H\u0016J\b\u0010/\u001a\u00020\u0010H\u0016J\u0012\u00100\u001a\u00020\u00182\b\u00101\u001a\u0004\u0018\u000102H\u0016J \u00103\u001a\u0002042\u0006\u00101\u001a\u0002042\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u000204H\u0016J\b\u00107\u001a\u00020\u0018H\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u00068"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/xweb_ext/live/WeEffectWorkaroundManager;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectWorkaroundManager;", "weEffectManager", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "stickerApplyAdapter", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;", "makeupApplyAdapter", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;", "(Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;)V", "getMakeupApplyAdapter$plugin_appbrand_integration_release", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IMakeupApplyAdapter;", "getStickerApplyAdapter$plugin_appbrand_integration_release", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IStickerApplyAdapter;", "getWeEffectManager", "()Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager;", "applyBlusherStick", "", "info", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/BlusherStickInfo;", "applyEyeBrow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeBrowInfo;", "applyEyeShadow", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/EyeShadowInfo;", "applyFaceBeauty", "", "type", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$FaceBeautyType;", "rate", "", "applyFaceContour", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/FaceContourInfo;", "applyFilter", "filePath", "", "alpha", "applyLipStick", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/LipStickInfo;", "applyMakeup", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$MakeupType;", "applySticker", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/IWeEffectManager$StickerType;", "stickerInfo", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo;", "clearFilters", "clearMakeups", "clearStickers", "isEnabled", "onDetectFacePoints", "p0", "", "onTextureCustomProcess", "", "p1", "p2", "onTextureDestoryed", "plugin-appbrand-integration_release"})
public final class p implements m {
    private final com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l cGQ;
    final i oHu;
    final e oHv;

    private p(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l lVar, i iVar, e eVar) {
        kotlin.g.b.p.h(lVar, "weEffectManager");
        kotlin.g.b.p.h(iVar, "stickerApplyAdapter");
        kotlin.g.b.p.h(eVar, "makeupApplyAdapter");
        AppMethodBeat.i(229769);
        this.cGQ = lVar;
        this.oHu = iVar;
        this.oHv = eVar;
        AppMethodBeat.o(229769);
    }

    public /* synthetic */ p(com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l lVar) {
        this(lVar, new j(lVar), new h(lVar));
        AppMethodBeat.i(229770);
        AppMethodBeat.o(229770);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.k
    public final boolean a(l.c cVar, List<StickerItemInfo> list) {
        AppMethodBeat.i(229752);
        kotlin.g.b.p.h(cVar, "type");
        kotlin.g.b.p.h(list, "stickerInfo");
        boolean a2 = this.oHu.a(cVar, list);
        AppMethodBeat.o(229752);
        return a2;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
    public final boolean a(n nVar) {
        AppMethodBeat.i(229753);
        kotlin.g.b.p.h(nVar, "info");
        boolean a2 = this.oHv.a(nVar);
        AppMethodBeat.o(229753);
        return a2;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
    public final boolean a(c cVar) {
        AppMethodBeat.i(229754);
        kotlin.g.b.p.h(cVar, "info");
        boolean a2 = this.oHv.a(cVar);
        AppMethodBeat.o(229754);
        return a2;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
    public final boolean a(a aVar) {
        AppMethodBeat.i(229755);
        kotlin.g.b.p.h(aVar, "info");
        boolean a2 = this.oHv.a(aVar);
        AppMethodBeat.o(229755);
        return a2;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
    public final boolean a(d dVar) {
        AppMethodBeat.i(229756);
        kotlin.g.b.p.h(dVar, "info");
        boolean a2 = this.oHv.a(dVar);
        AppMethodBeat.o(229756);
        return a2;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.g
    public final boolean a(b bVar) {
        AppMethodBeat.i(229757);
        kotlin.g.b.p.h(bVar, "info");
        boolean a2 = this.oHv.a(bVar);
        AppMethodBeat.o(229757);
        return a2;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final boolean isEnabled() {
        AppMethodBeat.i(229758);
        boolean isEnabled = this.cGQ.isEnabled();
        AppMethodBeat.o(229758);
        return isEnabled;
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final void a(l.a aVar, float f2) {
        AppMethodBeat.i(229759);
        this.cGQ.a(aVar, f2);
        AppMethodBeat.o(229759);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final void b(String str, float f2) {
        AppMethodBeat.i(229760);
        this.cGQ.b(str, f2);
        AppMethodBeat.o(229760);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final void clearFilters() {
        AppMethodBeat.i(229761);
        this.cGQ.clearFilters();
        AppMethodBeat.o(229761);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final void a(l.c cVar, String str) {
        AppMethodBeat.i(229762);
        this.cGQ.a(cVar, str);
        AppMethodBeat.o(229762);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final void Qf() {
        AppMethodBeat.i(229763);
        this.cGQ.Qf();
        AppMethodBeat.o(229763);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final void a(l.b bVar, String str) {
        AppMethodBeat.i(229764);
        this.cGQ.a(bVar, str);
        AppMethodBeat.o(229764);
    }

    @Override // com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.l
    public final void Qg() {
        AppMethodBeat.i(229765);
        this.cGQ.Qg();
        AppMethodBeat.o(229765);
    }

    @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
    public final int onTextureCustomProcess(int i2, int i3, int i4) {
        AppMethodBeat.i(229766);
        int onTextureCustomProcess = this.cGQ.onTextureCustomProcess(i2, i3, i4);
        AppMethodBeat.o(229766);
        return onTextureCustomProcess;
    }

    @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
    public final void onDetectFacePoints(float[] fArr) {
        AppMethodBeat.i(229767);
        this.cGQ.onDetectFacePoints(fArr);
        AppMethodBeat.o(229767);
    }

    @Override // com.tencent.rtmp.TXLivePusher.VideoCustomProcessListener
    public final void onTextureDestoryed() {
        AppMethodBeat.i(229768);
        this.cGQ.onTextureDestoryed();
        AppMethodBeat.o(229768);
    }
}
