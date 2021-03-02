package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;
import android.os.Build;
import com.bumptech.glide.g.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class n implements l {
    private static final Bitmap.Config[] aII;
    private static final Bitmap.Config[] aIJ;
    private static final Bitmap.Config[] aIK = {Bitmap.Config.RGB_565};
    private static final Bitmap.Config[] aIL = {Bitmap.Config.ARGB_4444};
    private static final Bitmap.Config[] aIM = {Bitmap.Config.ALPHA_8};
    private final b aIN = new b();
    private final h<a, Bitmap> aIk = new h<>();
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> aIu = new HashMap();

    public n() {
        AppMethodBeat.i(77132);
        AppMethodBeat.o(77132);
    }

    static {
        AppMethodBeat.i(77143);
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        aII = configArr;
        aIJ = configArr;
        AppMethodBeat.o(77143);
    }

    @Override // com.bumptech.glide.load.b.a.l
    public final void g(Bitmap bitmap) {
        AppMethodBeat.i(77133);
        a c2 = this.aIN.c(k.k(bitmap), bitmap.getConfig());
        this.aIk.a(c2, bitmap);
        NavigableMap<Integer, Integer> b2 = b(bitmap.getConfig());
        Integer num = (Integer) b2.get(Integer.valueOf(c2.size));
        b2.put(Integer.valueOf(c2.size), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
        AppMethodBeat.o(77133);
    }

    @Override // com.bumptech.glide.load.b.a.l
    public final Bitmap b(int i2, int i3, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        a aVar;
        int i4 = 0;
        AppMethodBeat.i(77134);
        int i5 = k.i(i2, i3, config);
        a c2 = this.aIN.c(i5, config);
        if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
            switch (AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[config.ordinal()]) {
                case 1:
                    configArr = aII;
                    break;
                case 2:
                    configArr = aIK;
                    break;
                case 3:
                    configArr = aIL;
                    break;
                case 4:
                    configArr = aIM;
                    break;
                default:
                    configArr = new Bitmap.Config[]{config};
                    break;
            }
        } else {
            configArr = aIJ;
        }
        int length = configArr.length;
        while (true) {
            if (i4 < length) {
                Bitmap.Config config2 = configArr[i4];
                Integer ceilingKey = b(config2).ceilingKey(Integer.valueOf(i5));
                if (ceilingKey == null || ceilingKey.intValue() > i5 * 8) {
                    i4++;
                } else if (ceilingKey.intValue() != i5 || (config2 != null ? !config2.equals(config) : config != null)) {
                    this.aIN.a(c2);
                    aVar = this.aIN.c(ceilingKey.intValue(), config2);
                }
            }
        }
        aVar = c2;
        Bitmap b2 = this.aIk.b(aVar);
        if (b2 != null) {
            a(Integer.valueOf(aVar.size), b2);
            b2.reconfigure(i2, i3, config);
        }
        AppMethodBeat.o(77134);
        return b2;
    }

    @Override // com.bumptech.glide.load.b.a.l
    public final Bitmap pa() {
        AppMethodBeat.i(77135);
        Bitmap removeLast = this.aIk.removeLast();
        if (removeLast != null) {
            a(Integer.valueOf(k.k(removeLast)), removeLast);
        }
        AppMethodBeat.o(77135);
        return removeLast;
    }

    private void a(Integer num, Bitmap bitmap) {
        AppMethodBeat.i(77136);
        NavigableMap<Integer, Integer> b2 = b(bitmap.getConfig());
        Integer num2 = (Integer) b2.get(num);
        if (num2 == null) {
            NullPointerException nullPointerException = new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + h(bitmap) + ", this: " + this);
            AppMethodBeat.o(77136);
            throw nullPointerException;
        } else if (num2.intValue() == 1) {
            b2.remove(num);
            AppMethodBeat.o(77136);
        } else {
            b2.put(num, Integer.valueOf(num2.intValue() - 1));
            AppMethodBeat.o(77136);
        }
    }

    private NavigableMap<Integer, Integer> b(Bitmap.Config config) {
        AppMethodBeat.i(77137);
        NavigableMap<Integer, Integer> navigableMap = this.aIu.get(config);
        if (navigableMap == null) {
            navigableMap = new TreeMap<>();
            this.aIu.put(config, navigableMap);
        }
        AppMethodBeat.o(77137);
        return navigableMap;
    }

    @Override // com.bumptech.glide.load.b.a.l
    public final String h(Bitmap bitmap) {
        AppMethodBeat.i(77138);
        String a2 = a(k.k(bitmap), bitmap.getConfig());
        AppMethodBeat.o(77138);
        return a2;
    }

    @Override // com.bumptech.glide.load.b.a.l
    public final String c(int i2, int i3, Bitmap.Config config) {
        AppMethodBeat.i(77139);
        String a2 = a(k.i(i2, i3, config), config);
        AppMethodBeat.o(77139);
        return a2;
    }

    @Override // com.bumptech.glide.load.b.a.l
    public final int i(Bitmap bitmap) {
        AppMethodBeat.i(77140);
        int k = k.k(bitmap);
        AppMethodBeat.o(77140);
        return k;
    }

    public final String toString() {
        AppMethodBeat.i(77141);
        StringBuilder append = new StringBuilder("SizeConfigStrategy{groupedMap=").append(this.aIk).append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.aIu.entrySet()) {
            append.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.aIu.isEmpty()) {
            append.replace(append.length() - 2, append.length(), "");
        }
        String sb = append.append(")}").toString();
        AppMethodBeat.o(77141);
        return sb;
    }

    static class b extends d<a> {
        b() {
        }

        public final a c(int i2, Bitmap.Config config) {
            AppMethodBeat.i(77130);
            a aVar = (a) pd();
            aVar.b(i2, config);
            AppMethodBeat.o(77130);
            return aVar;
        }

        /* Return type fixed from 'com.bumptech.glide.load.b.a.m' to match base method */
        /* access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.b.a.d
        public final /* synthetic */ a pc() {
            AppMethodBeat.i(77131);
            a aVar = new a(this);
            AppMethodBeat.o(77131);
            return aVar;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class a implements m {
        private final b aIO;
        private Bitmap.Config aIm;
        int size;

        public a(b bVar) {
            this.aIO = bVar;
        }

        public final void b(int i2, Bitmap.Config config) {
            this.size = i2;
            this.aIm = config;
        }

        @Override // com.bumptech.glide.load.b.a.m
        public final void pb() {
            AppMethodBeat.i(77126);
            this.aIO.a(this);
            AppMethodBeat.o(77126);
        }

        public final String toString() {
            AppMethodBeat.i(77127);
            String a2 = n.a(this.size, this.aIm);
            AppMethodBeat.o(77127);
            return a2;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(77128);
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.size != aVar.size || !k.h(this.aIm, aVar.aIm)) {
                    AppMethodBeat.o(77128);
                    return false;
                }
                AppMethodBeat.o(77128);
                return true;
            }
            AppMethodBeat.o(77128);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(77129);
            int hashCode = (this.aIm != null ? this.aIm.hashCode() : 0) + (this.size * 31);
            AppMethodBeat.o(77129);
            return hashCode;
        }
    }

    static String a(int i2, Bitmap.Config config) {
        AppMethodBeat.i(77142);
        String str = "[" + i2 + "](" + config + ")";
        AppMethodBeat.o(77142);
        return str;
    }

    /* renamed from: com.bumptech.glide.load.b.a.n$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = new int[Bitmap.Config.values().length];

        static {
            AppMethodBeat.i(77125);
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 4;
                AppMethodBeat.o(77125);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(77125);
            }
        }
    }
}
