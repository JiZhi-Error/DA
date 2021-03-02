package com.tencent.mm.xeffect.effect;

import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.XEffectLog;
import com.tencent.mm.xeffect.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import org.libpag.PAGFont;

@l(hxD = {1, 1, 15}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u0001:\u00013B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\u000eJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u0013J \u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0017J\u0006\u0010\u001b\u001a\u00020\u000eJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0007J\u0019\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0007H J\u0019\u0010 \u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H J\u0019\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\"H J)\u0010#\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\"2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H J)\u0010$\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\"2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0007H J!\u0010&\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u0017H J\u0011\u0010'\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0007H J\t\u0010(\u001a\u00020\u0007H J\u0011\u0010)\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0007H J\u0019\u0010*\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H J\u0019\u0010+\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010,\u001a\u00020-H J\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007J\u000e\u00101\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u00102\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020-R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u00064"}, hxF = {"Lcom/tencent/mm/xeffect/effect/EffectManager;", "", "()V", "effectList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "<set-?>", "", "nPtr", "getNPtr", "()J", "addEffect", "effect", "bringToFront", "", "effectId", "clearEffect", "createEffect", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "asset", "Landroid/content/res/AssetManager;", "assetPath", "", "bytes", "", "path", "destroy", "getEffect", "nAddEffect", "ptr", "effectPtr", "nBringToFront", "nCreateEffect", "", "nCreateEffectAsset", "nCreateEffectBinary", "length", "nCreateEffectPath", "nDestroy", "nInit", "nProfileData", "nRemoveEffect", "nSetDecoderFactory", "factory", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "profileData", "Lcom/tencent/mm/xeffect/effect/EffectProfileData;", "removeEffect", "removeEffects", "setDecoderFactory", "Companion", "renderlib_release"})
public final class EffectManager {
    public static final a RxS = new a((byte) 0);
    private static final String TAG = TAG;
    private final LinkedList<ad> GAp = new LinkedList<>();
    public long Rxd = nInit();

    private final native long nAddEffect(long j2, long j3);

    private final native void nBringToFront(long j2, long j3);

    private final native long nCreateEffect(long j2, int i2);

    private final native long nCreateEffectAsset(long j2, int i2, AssetManager assetManager, String str);

    private final native long nCreateEffectBinary(long j2, int i2, byte[] bArr, long j3);

    private final native long nCreateEffectPath(long j2, int i2, String str);

    private final native void nDestroy(long j2);

    private final native long nInit();

    private final native long nProfileData(long j2);

    private final native void nRemoveEffect(long j2, long j3);

    private final native void nSetDecoderFactory(long j2, IStickerDecoderFactory iStickerDecoderFactory);

    private static final native void nSetDefaultFactory(IStickerDecoderFactory iStickerDecoderFactory);

    public EffectManager() {
        AppMethodBeat.i(237068);
        AppMethodBeat.o(237068);
    }

    public static final /* synthetic */ void a(IStickerDecoderFactory iStickerDecoderFactory) {
        AppMethodBeat.i(237070);
        nSetDefaultFactory(iStickerDecoderFactory);
        AppMethodBeat.o(237070);
    }

    @l(hxD = {1, 1, 15}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0011\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0010"}, hxF = {"Lcom/tencent/mm/xeffect/effect/EffectManager$Companion;", "", "()V", "TAG", "", "createEffect", "Lcom/tencent/mm/xeffect/effect/VLogEffect;", "ptr", "", "type", "Lcom/tencent/mm/xeffect/effect/EffectType;", "nSetDefaultFactory", "", "factory", "Lcom/tencent/mm/xeffect/effect/IStickerDecoderFactory;", "setDefaultFactory", "renderlib_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static void b(IStickerDecoderFactory iStickerDecoderFactory) {
            AppMethodBeat.i(237054);
            p.h(iStickerDecoderFactory, "factory");
            EffectManager.a(new StickerDecoderFactoryWrapper(iStickerDecoderFactory));
            AppMethodBeat.o(237054);
        }

        static ad a(long j2, j jVar) {
            AppMethodBeat.i(237055);
            XEffectLog.i(EffectManager.TAG, "create effect ptr:" + j2 + ", type:" + jVar, new Object[0]);
            if (j2 == 0) {
                AppMethodBeat.o(237055);
                return null;
            }
            switch (g.$EnumSwitchMapping$0[jVar.ordinal()]) {
                case 1:
                    t tVar = new t(j2);
                    AppMethodBeat.o(237055);
                    return tVar;
                case 2:
                    w wVar = new w(j2);
                    AppMethodBeat.o(237055);
                    return wVar;
                case 3:
                    v vVar = new v(j2);
                    AppMethodBeat.o(237055);
                    return vVar;
                case 4:
                    u uVar = new u(j2);
                    AppMethodBeat.o(237055);
                    return uVar;
                case 5:
                    s sVar = new s(j2);
                    AppMethodBeat.o(237055);
                    return sVar;
                case 6:
                    n nVar = new n(j2);
                    AppMethodBeat.o(237055);
                    return nVar;
                case 7:
                    aa aaVar = new aa(j2);
                    AppMethodBeat.o(237055);
                    return aaVar;
                case 8:
                    a aVar = new a(j2);
                    AppMethodBeat.o(237055);
                    return aVar;
                case 9:
                    c cVar = new c(j2);
                    AppMethodBeat.o(237055);
                    return cVar;
                case 10:
                    d dVar = new d(j2);
                    AppMethodBeat.o(237055);
                    return dVar;
                case 11:
                    x xVar = new x(j2);
                    AppMethodBeat.o(237055);
                    return xVar;
                case 12:
                    m mVar = new m(j2);
                    AppMethodBeat.o(237055);
                    return mVar;
                case 13:
                    ae aeVar = new ae(j2);
                    AppMethodBeat.o(237055);
                    return aeVar;
                case 14:
                    l lVar = new l(j2);
                    AppMethodBeat.o(237055);
                    return lVar;
                case 15:
                    k kVar = new k(j2);
                    AppMethodBeat.o(237055);
                    return kVar;
                case 16:
                    b bVar = new b(j2);
                    AppMethodBeat.o(237055);
                    return bVar;
                default:
                    AppMethodBeat.o(237055);
                    return null;
            }
        }
    }

    static {
        AppMethodBeat.i(237069);
        d.load("xlabeffect");
        d.load("pag");
        PAGFont.RegisterFallbackFonts();
        a.b(new e());
        AppMethodBeat.o(237069);
    }

    public final ad a(j jVar) {
        AppMethodBeat.i(237056);
        p.h(jVar, "type");
        ad a2 = a.a(nCreateEffect(this.Rxd, jVar.ordinal()), jVar);
        AppMethodBeat.o(237056);
        return a2;
    }

    public final ad a(j jVar, String str) {
        AppMethodBeat.i(237057);
        p.h(jVar, "type");
        p.h(str, "path");
        ad a2 = a.a(nCreateEffectPath(this.Rxd, jVar.ordinal(), str), jVar);
        AppMethodBeat.o(237057);
        return a2;
    }

    public final ad a(j jVar, byte[] bArr) {
        AppMethodBeat.i(237058);
        p.h(jVar, "type");
        p.h(bArr, "bytes");
        long nCreateEffectBinary = nCreateEffectBinary(this.Rxd, jVar.ordinal(), bArr, (long) bArr.length);
        ad a2 = a.a(nCreateEffectBinary, jVar);
        XEffectLog.i(TAG, "create effect binary ptr:" + nCreateEffectBinary + ", type:" + jVar + ", " + bArr.length, new Object[0]);
        AppMethodBeat.o(237058);
        return a2;
    }

    public final ad a(j jVar, AssetManager assetManager, String str) {
        AppMethodBeat.i(237059);
        p.h(jVar, "type");
        p.h(assetManager, "asset");
        p.h(str, "assetPath");
        ad a2 = a.a(nCreateEffectAsset(this.Rxd, jVar.ordinal(), assetManager, str), jVar);
        AppMethodBeat.o(237059);
        return a2;
    }

    public final ad a(ad adVar) {
        AppMethodBeat.i(237060);
        if (adVar != null) {
            long nAddEffect = nAddEffect(this.Rxd, adVar.ptr);
            adVar.id = nAddEffect;
            XEffectLog.i(TAG, "addEffect ptr:" + adVar.ptr + ", effectId:" + nAddEffect, new Object[0]);
            synchronized (this.GAp) {
                try {
                    this.GAp.add(adVar);
                } finally {
                    AppMethodBeat.o(237060);
                }
            }
        }
        return adVar;
    }

    public final ad Os(long j2) {
        T t;
        boolean z;
        AppMethodBeat.i(237061);
        Iterator<T> it = this.GAp.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            T next = it.next();
            if (next.id == j2) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                t = next;
                break;
            }
        }
        T t2 = t;
        AppMethodBeat.o(237061);
        return t2;
    }

    public final void Ot(long j2) {
        boolean z;
        AppMethodBeat.i(237062);
        synchronized (this.GAp) {
            try {
                Iterator<ad> it = this.GAp.iterator();
                int i2 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    if (it.next().id == j2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        break;
                    }
                    i2++;
                }
                if (i2 >= 0) {
                    XEffectLog.i(TAG, "removeEffect ptr:" + this.GAp.get(i2).ptr + ", effectId:" + j2, new Object[0]);
                    this.GAp.get(i2).id = 0;
                    this.GAp.remove(i2);
                }
                nRemoveEffect(this.Rxd, j2);
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(237062);
            }
        }
    }

    public final void b(j jVar) {
        AppMethodBeat.i(237063);
        p.h(jVar, "type");
        synchronized (this.GAp) {
            try {
                ArrayList<ad> arrayList = new ArrayList();
                for (T t : this.GAp) {
                    if (t.hiu() == jVar) {
                        arrayList.add(t);
                    }
                }
                for (ad adVar : arrayList) {
                    Ot(adVar.id);
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(237063);
            }
        }
    }

    public final void hiv() {
        AppMethodBeat.i(237064);
        synchronized (this.GAp) {
            try {
                for (T t : this.GAp) {
                    nRemoveEffect(this.Rxd, t.id);
                    t.id = 0;
                }
                this.GAp.clear();
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(237064);
            }
        }
    }

    public final void Ou(long j2) {
        int i2;
        boolean z;
        AppMethodBeat.i(237065);
        synchronized (this.GAp) {
            try {
                Iterator<ad> it = this.GAp.iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i2 = -1;
                        break;
                    }
                    if (it.next().id == j2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 >= 0) {
                    ad remove = this.GAp.remove(i2);
                    p.g(remove, "effectList.removeAt(index)");
                    this.GAp.add(remove);
                }
                nBringToFront(this.Rxd, j2);
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(237065);
            }
        }
    }

    public final EffectProfileData hiw() {
        AppMethodBeat.i(237066);
        EffectProfileData effectProfileData = new EffectProfileData(nProfileData(this.Rxd));
        AppMethodBeat.o(237066);
        return effectProfileData;
    }

    public final void destroy() {
        AppMethodBeat.i(237067);
        hiv();
        nDestroy(this.Rxd);
        AppMethodBeat.o(237067);
    }
}
