package com.tencent.mm.plugin.expansions;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expansions.a;
import com.tencent.mm.toolkit.frontia.a.c;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0006J\u0014\u0010\u0015\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\fJ\u001a\u0010\u0017\u001a\u00020\u00062\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004J\u0014\u0010\u0018\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\fR(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/expansions/ExpansionsKtWrapper;", "", "()V", "assetsCallback", "Lkotlin/Function1;", "Landroid/content/res/AssetManager;", "", "getAssetsCallback", "()Lkotlin/jvm/functions/Function1;", "setAssetsCallback", "(Lkotlin/jvm/functions/Function1;)V", "callbackFail", "Lkotlin/Function0;", "getCallbackFail", "()Lkotlin/jvm/functions/Function0;", "setCallbackFail", "(Lkotlin/jvm/functions/Function0;)V", "installSuccess", "getInstallSuccess", "setInstallSuccess", "invoke", "onFail", "block", "onGetAssets", "onInstalled", "expansions-visitor_release"})
public final class b {
    public kotlin.g.a.a<x> rNA;
    kotlin.g.a.a<x> rNB;
    public kotlin.g.a.b<? super AssetManager, x> rNC;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/expansions/ExpansionsKtWrapper$invoke$1", "Lcom/tencent/mm/plugin/expansions/Expansions$AssetsCallback;", "onFail", "", "onSuccess", "assetManager", "Landroid/content/res/AssetManager;", "expansions-visitor_release"})
    public static final class a implements a.AbstractC1006a {
        final /* synthetic */ b rND;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(b bVar) {
            this.rND = bVar;
        }

        @Override // com.tencent.mm.plugin.expansions.a.AbstractC1006a
        public final void a(AssetManager assetManager) {
            AppMethodBeat.i(152981);
            p.h(assetManager, "assetManager");
            kotlin.g.a.b<? super AssetManager, x> bVar = this.rND.rNC;
            if (bVar != null) {
                bVar.invoke(assetManager);
                AppMethodBeat.o(152981);
                return;
            }
            AppMethodBeat.o(152981);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/expansions/ExpansionsKtWrapper$invoke$2", "Lcom/tencent/mm/plugin/expansions/Expansions$Callback;", "onFail", "", "onSuccess", "behavior", "Lcom/tencent/mm/toolkit/frontia/ext/ShareLibrary$SoLibBehavior;", "expansions-visitor_release"})
    /* renamed from: com.tencent.mm.plugin.expansions.b$b  reason: collision with other inner class name */
    public static final class C1007b implements a.b {
        final /* synthetic */ b rND;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1007b(b bVar) {
            this.rND = bVar;
        }

        @Override // com.tencent.mm.plugin.expansions.a.b
        public final void a(c.a aVar) {
            AppMethodBeat.i(152982);
            p.h(aVar, "behavior");
            kotlin.g.a.a<x> aVar2 = this.rND.rNB;
            if (aVar2 != null) {
                aVar2.invoke();
                AppMethodBeat.o(152982);
                return;
            }
            AppMethodBeat.o(152982);
        }
    }
}
